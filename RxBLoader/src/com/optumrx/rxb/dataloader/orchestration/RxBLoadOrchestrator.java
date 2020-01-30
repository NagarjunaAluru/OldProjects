package com.optumrx.rxb.dataloader.orchestration;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.optumrx.rxb.dataloader.dao.db2.IRxBLoadDao;
import com.optumrx.rxb.dataloader.model.RxBAudit;
import com.optumrx.rxb.dataloader.orchestration.component.EofFileListener;
import com.optumrx.rxb.dataloader.orchestration.component.RxBLoadReportExecutorQ;
import com.optumrx.rxb.dataloader.util.ApplicationContextProvider;
import com.optumrx.rxb.dataloader.util.ExceptionUtil;
import com.optumrx.rxb.dataloader.util.FileReadUtil;
import com.optumrx.rxb.dataloader.util.RxBLoaderUtil;


/**
 * 
 * @author Aluru.Nagarjuna
 *
 */
public class RxBLoadOrchestrator  {

	private static Logger log = LoggerFactory.getLogger(RxBLoadOrchestrator.class);

	FileReadUtil fileReadUtil = (FileReadUtil) ApplicationContextProvider.getApplicationContext().getBean("fileReaderUtil");
	IRxBLoadDao rxbLoader = (IRxBLoadDao) ApplicationContextProvider.getApplicationContext().getBean("rxbLoaderDao");
	RxBLoaderUtil loaderUtil = (RxBLoaderUtil) ApplicationContextProvider.getApplicationContext().getBean("loaderUtil");
	EofFileListener eofFileListener = (EofFileListener) ApplicationContextProvider.getApplicationContext().getBean("eofFileListener");

	public void executeLoader() throws Exception {
		log.debug("-----RxBLoadOrchestrator executeLoader() Start-----");
		List<String> eofFileList = null;
		try {
			// DB will update REPORT_GEN_FLAG='Y', once they have populated report data.
			// Java will fetch only those batchId whose REPORT_GEN_FLAG='Y', once report is populated, java will update to 'C'.
			List<RxBAudit> auditList = rxbLoader.getAuditByFlag();
			log.error(auditList.size() + " :: BatchId's of Reports to be processed");
			if(auditList.size()>0) {
				Map<Integer,String> reptMap = null;
				for (RxBAudit auditRecord : auditList) {
					if(auditRecord.getBatchNo() !=null && !auditRecord.getBatchNo().isEmpty()) {
						reptMap = new HashMap<Integer,String>();
						reptMap.put(Integer.valueOf(auditRecord.getBatchNo()), null);
						RxBLoadReportExecutorQ.addToQ(reptMap);//Adding report generation failed batches to regenerate reports.
						log.error(" Valid EOF File added back to RxBLoadReportExecutorQ BatchId:["+auditRecord.getBatchNo()+"]");
					}else {
						 log.error("Batch Id is blank in Audit table");
					}
				}
			}
			
			String csvFolderPath = loaderUtil.getCsvPath();
			log.debug(" -------------------------------------------------------------------------------------- ");
			log.debug("Configuration Details :"+loaderUtil.toString());			
			log.debug(" -------------------------------------------------------------------------------------- ");
			
			if(csvFolderPath != null){
				eofFileList = getEOFFiles(csvFolderPath);
			    log.debug(" ----- EOF File List :"+eofFileList+ " -----");
			}
			
			eofFileListener.processEofFileList(csvFolderPath, eofFileList);
			deleteArchiveFiles();
		}catch(Exception exception){
			log.error("Exception in RxBLoadOrchestrator executeLoader() :: "+ExceptionUtil.getStackTrace(exception));
			throw exception;
		}
		log.debug("-----RxBLoadOrchestrator executeLoader() End-----");
	}
	
	/**
	 * This method will remove the archive files based on the archiveDeleteDays value from spring xml file
	 */
	private void deleteArchiveFiles() {
		try {
			List<RxBAudit> auditList = rxbLoader.getArchieveRecords(loaderUtil.getArchiveDeleteDays());
			File archfile ;
			if(auditList.size()>0) {
				for(RxBAudit rxBAudit : auditList) {
					archfile = new File(loaderUtil.getZipPath()+rxBAudit.getArchiveFileName());
					if(archfile.exists()){
						archfile.delete();//Deleting Archive file
						log.error("Archive File deleted :: "+rxBAudit.getArchiveFileName() );
					}else{
						log.error("Archive File not found to delete :: "+rxBAudit.getArchiveFileName() );
					}
					rxbLoader.updateAudit(0,rxBAudit.getBatchNo(),null);//Updating ARCHIVE_DELETED flag to 'Y'
					log.error("Updated isDeleted flag in Audit to :: Y ");
				}
			}
			
		} catch (Exception exception) {
			log.error("Exception in RxBLoadOrchestrator deleteArchiveFiles() :: "+ExceptionUtil.getStackTrace(exception));
		}
	}

	/**
	 * 
	 * @param csvFolderPath
	 * @return
	 */
	private List<String> getEOFFiles(String csvFolderPath) {
		List<String> eofFileList = new ArrayList<String>();//declaration of arraylist.
		File folder = new File(csvFolderPath);
		if (!folder.exists()) {
			throw new RuntimeException("Directory not found: " + folder);
		}
		File[] listOfFiles = folder.listFiles();//Fetch list of files present in the path.
		// added on 10/05/2017
		//list out only #ZEOF.CSV files from the directory.
		ArrayList<File> fileList = new ArrayList<File>(); //declaration of arraylist.
		for (File file : listOfFiles) { //for each file
			if (file.isFile() && file.getName().contains("#ZEOF")
		    		  && file.getName().toUpperCase().endsWith(".CSV")) {// Finding all *EOF files
				fileList.add(file);//Add it to fileList.
		      }
		}

		if(fileList!=null && fileList.size()>0){
			Collections.sort(fileList, new Comparator<File>() {// sort the #ZEOF.CSV files based on lastModified.
				public int compare(File f1, File f2) {
					return Long.valueOf(f1.lastModified()).compareTo(
							f2.lastModified());
				}
			});
			for (File fileName: fileList ) { //for each file
				eofFileList.add(fileName.getName()); // add the filename to eofFileList.
			}
		}
		else{
			log.debug("No #ZEOF.CSV files for processing");
		}
		return eofFileList;
	}

}

