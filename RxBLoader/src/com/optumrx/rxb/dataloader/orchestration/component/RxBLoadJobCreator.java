package com.optumrx.rxb.dataloader.orchestration.component;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.optumrx.rxb.dataloader.dao.db2.IRxBLoadDao;
import com.optumrx.rxb.dataloader.model.EOFCSV;
import com.optumrx.rxb.dataloader.util.ApplicationContextProvider;
import com.optumrx.rxb.dataloader.util.ExceptionUtil;
import com.optumrx.rxb.dataloader.util.FileReadUtil;
import com.optumrx.rxb.dataloader.util.RxBLoaderUtil;


public class RxBLoadJobCreator implements Runnable
{

	private static Logger log = LoggerFactory.getLogger(RxBLoadJobCreator.class);
	FileReadUtil fileReadUtil = (FileReadUtil) ApplicationContextProvider.getApplicationContext().getBean("fileReaderUtil");
	RxBLoaderUtil loaderUtil = (RxBLoaderUtil) ApplicationContextProvider.getApplicationContext().getBean("loaderUtil");
	IRxBLoadDao rxbLoader = (IRxBLoadDao) ApplicationContextProvider.getApplicationContext().getBean("rxbLoaderDao");
	
	List<String> eofFileList =  new ArrayList<String>();
	List<String> csvFileList =  new ArrayList<String>();
	

	@Override
	public void run() {
		List<EOFCSV> csvList = null;
		String csvFolderPath = loaderUtil.getCsvPath();
		try {
			// get all the tasks from the queue and check for RUN_ID
			int count = RxBLoadJobCreatorQ.getQSize();

			if (count == 0) {
				log.error(" ---- There are no records to process in RxBLoadJobCreatorQ! ----");
				return;
			}
			
			eofFileList.clear();
			for (int i = 0; i < count; i++) {
				// adding to the list
				eofFileList.add(RxBLoadJobCreatorQ.getFromQ());
			}

			log.error(" **** CURRENT JOBS IN CREATOR Q [" + eofFileList.size()+ "] ****");
			csvFileList.clear();
			for (String eofFileName : eofFileList) {
				csvList = fileReadUtil.processSummaryCsv(csvFolderPath,eofFileName);//Reading the eof csv file content.
				log.debug( eofFileName + " EOF CSV Records size :"+csvList.size());
				
				boolean callProc = true;
				if(csvList != null && csvList.size()>0){
					for(EOFCSV csvFile : csvList){// For every filename in eof file.
						if(!isFileExist(csvFolderPath+csvFile.getFileName())){// Check if the filename( in eof file) exist in the said path.
							if(csvFile.getFileName() != null && !csvFile.getFileName().isEmpty()
									&& csvFile.getRecordCount() != null && !csvFile.getRecordCount().isEmpty()){
								log.error("CSV file not found :"+csvFolderPath+csvFile.getFileName());
								callProc = false;
							}
						}
					}
				}else {
					log.error("************** No records found in ["+ eofFileName +"] EOF file **************");
				}
				Map<String,Boolean> eofStatus = new HashMap<String,Boolean>();
				if(callProc && csvList != null && csvList.size()>0){
					eofStatus.put(eofFileName, true);
					RxBLoadJobExecutorQ.addToQ(eofStatus);
					log.error(" ---- Valid EOF File added to RxBLoadJobExecutorQ :[ "+eofFileName+" ] ----");
				}else {
					eofStatus.put(eofFileName, false);
					RxBLoadJobExecutorQ.addToQ(eofStatus);
					log.error(" ---- Invalid EOF File added to RxBLoadJobExecutorQ :[ "+eofFileName+" ] ----");
				}
			}
		}catch (Exception exception) {
			log.error("Exception in RxBLoadJobCreator run() : "+ExceptionUtil.getStackTrace(exception));
		}
	}
	
	/**
	 * @param csvFile
	 * @return
	 */
	private boolean isFileExist(String csvFile) {
		return  (new File(csvFile).exists())?true:false;
	}

}
