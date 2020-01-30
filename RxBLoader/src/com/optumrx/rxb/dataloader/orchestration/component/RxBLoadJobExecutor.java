package com.optumrx.rxb.dataloader.orchestration.component;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import au.com.bytecode.opencsv.CSVWriter;

import com.optumrx.rxb.dataloader.dao.db2.IRxBLoadDao;
import com.optumrx.rxb.dataloader.model.EOFCSV;
import com.optumrx.rxb.dataloader.model.RxBAudit;
import com.optumrx.rxb.dataloader.util.ApplicationContextProvider;
import com.optumrx.rxb.dataloader.util.ExceptionUtil;
import com.optumrx.rxb.dataloader.util.FileReadUtil;
import com.optumrx.rxb.dataloader.util.RxBLoaderThreadService;
import com.optumrx.rxb.dataloader.util.RxBLoaderUtil;


public class RxBLoadJobExecutor implements Runnable
{
	private static Logger log = LoggerFactory.getLogger(RxBLoadJobExecutor.class);
	FileReadUtil fileReadUtil = (FileReadUtil) ApplicationContextProvider.getApplicationContext().getBean("fileReaderUtil");
	IRxBLoadDao rxbLoader = (IRxBLoadDao) ApplicationContextProvider.getApplicationContext().getBean("rxbLoaderDao");
	RxBLoaderUtil loaderUtil = (RxBLoaderUtil) ApplicationContextProvider.getApplicationContext().getBean("loaderUtil");
	
	private static int count=0;
	
	private ThreadLocal<SimpleDateFormat> format = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH);
		}
	};
	
	@Override
	public void run() {
		Map<String,Boolean> eofFile=null;
		String reportsPath = null;
		String regionBatchIds = null;
		int batchId = 0;
		String eofFileName = null;
		try {
			// check if there is any job to be executed
			if (RxBLoadJobExecutorQ.isQEmpty()) {
				count=count+1;
				if(count<=15) {
					log.error(" ---- There are no records to process in RxBLoadJobExecutorQ! ----");
					return;
				}
				else {
					return;
				}
			}
			log.error(" **** CURRENT JOBS IN EXECUTOR Q ["+RxBLoadJobExecutorQ.getQSize()+"] ****");
			count=0;
			
			eofFile=RxBLoadJobExecutorQ.getFromQ();
			
			if(eofFile==null){
				return;
			}
			
			reportsPath = loaderUtil.getReportPath();
			Map.Entry<String,Boolean> entry=eofFile.entrySet().iterator().next();
			eofFileName= entry.getKey();
			Boolean isValid=entry.getValue();
			String gttLogs = "";
			
			regionBatchIds = fileReadUtil.getRegionBatchIds(eofFileName,false);
			String batchNo = fileReadUtil.getRegionBatchIds(eofFileName, true);
			String filename=regionBatchIds.concat(RxBLoaderUtil.EMAIL_REPORT).toUpperCase();
			log.debug("Email report fileName :"+filename);

			batchId = rxbLoader.insertBatch(regionBatchIds);
			//if the validation clears.
			if(isValid != null && isValid) {
				rxbLoader.insertAudit(batchId,"S");
				
				//Calling main Stored Procedure
				Timestamp jobEndTime = getJobEndTime(loaderUtil.getJobendtime());
				gttLogs = rxbLoader.callCSVProc(eofFileName,loaderUtil,jobEndTime,batchId);
				
				if(gttLogs.length()>0) {
					RxBAudit updatedRecord = rxbLoader.getAudit(batchId);
					if(updatedRecord.getBatchNo() != null && !updatedRecord.getBatchNo().isEmpty() && 
							updatedRecord.getDataLoadStatus()!= null && updatedRecord.getDataLoadStatus().equals("E")) {
						throw new Exception(gttLogs);//Throwing error if timeout occurs.
					} else {
						String gttError[] = {"Error occured while processing CSV files : GTT ::",gttLogs};
						batchEndProcess(eofFileName, batchNo, regionBatchIds, gttError, batchId);
					}
				} else {
					Map<Integer,String> reptMap = new HashMap<Integer,String>();
					reptMap.put(batchId,eofFileName);
					RxBLoadReportExecutorQ.addToQ(reptMap);//Adding successfully loaded EOF file to generate reports 
					log.error(" ---- Valid EOF File added to RxBLoadReportExecutorQ :[ "+eofFileName+" ] ----");
				}
			}else {
				//Add the Batch number to audit table for failure batch
				rxbLoader.insertAudit(batchId,"F");
				String errorMsg[] = {"Invalid EOF file:","Some of the CSV files are missing"};
				batchEndProcess(eofFileName, batchNo, regionBatchIds, errorMsg, batchId);
			}
		}catch (Exception exception) {
			log.error("Exception in RxBLoadJobExecutor run() :: "+ExceptionUtil.getStackTrace(exception));
			try {
				String emailFileName=regionBatchIds.concat(RxBLoaderUtil.EMAIL_REPORT).toUpperCase();
				log.debug("Email report name "+emailFileName);
				String errorMsg[] = {"Error occured while loading CSVs:",exception.getMessage()};
				//Generates Error report if any error occurred from java or timeout from DB end.
				loaderUtil.createCSVFile(reportsPath.concat(emailFileName),errorMsg);
				generateEOFReport(eofFileName,reportsPath);
			} catch (IOException ioException) {
				log.error("Exception in RxBLoadJobExecutor catch block :: "+ExceptionUtil.getStackTrace(ioException));
			}
		} 
	}
	
	/**
	 * 
	 * @param eofFile
	 * @param rptPth
	 * @throws IOException
	 */
	private void generateEOFReport(String eofFile,String rptPth) throws IOException {
		//Generates EOF file[end of the process].
		String fileName=eofFile.toUpperCase();
		CSVWriter eofWriter = new CSVWriter(new FileWriter(rptPth.concat(fileName)), ',');;
		eofWriter.flush();
		eofWriter.close();
	}

	/**
	 * This method will generate Email Notification, Detail reports and 
	 * it will archive and delete the CSV files.
	 * @param eofFileName
	 * @param batchNo
	 * @param regionBatchIds
	 * @param errorMsg
	 * @param batchId
	 * @throws Exception
	 */
	private void batchEndProcess(String eofFileName, String batchNo, String regionBatchIds,
			String[] errorMsg, int batchId) throws Exception {
		List<String> fileList = null;
		List<EOFCSV> csvList = null;
		CSVWriter csvWriter = null;
		String zipPath = loaderUtil.getZipPath();
		String reportsPath = loaderUtil.getReportPath();
		String csvFolderPath = loaderUtil.getCsvPath();
		String filename=regionBatchIds.concat(RxBLoaderUtil.EMAIL_REPORT).toUpperCase();
		log.info("Email report fileName :"+filename);
		Calendar calendar =Calendar.getInstance();
		String archiveFileName = format.get().format(calendar.getTime())+"_"+regionBatchIds+".zip"; // suffix the datetimestamp.
		String detailReport = regionBatchIds.concat(RxBLoaderUtil.BATCH_DETAILS_REPORT).toUpperCase();
		
		//Generates Error report if CSV file(s) are not exists in Feed path or Error occurred from DB.
		loaderUtil.createCSVFile(reportsPath.concat(filename),errorMsg);
		
		log.info("eofFileName before processSummaryCsv "+eofFileName);
		csvList = fileReadUtil.processSummaryCsv(csvFolderPath, eofFileName);//Reading the eof csv file content.
		log.info("eofFileName before generateFileList "+eofFileName);
		fileList = fileReadUtil.generateFileList(csvList,eofFileName,null);//Generating file list to archive and delete the CSVs
		
		csvWriter = new CSVWriter(new FileWriter(reportsPath.concat(detailReport)), ',');//Creating Batch Detail report
		rxbLoader.createBatchDetailReport(batchId,csvWriter);
		csvWriter.flush();
		csvWriter.close();
		
		fileReadUtil.zipIt(zipPath+archiveFileName,fileList,csvFolderPath,
			null,null,detailReport,reportsPath);// Generating zip file 
			
		rxbLoader.updateAudit(batchId,null,archiveFileName);//Updating Job End time and Archive file name in DB

		generateEOFReport(eofFileName,reportsPath);
		
		//Once the csv files are archived, it will deletes files from the Feed path
		fileReadUtil.deleteCSVFiles(csvFolderPath, fileList);
	}

	/**
	 * This method will give the Job End time TimeStamp
	 * @param jobendtime
	 * @return
	 */
	private Timestamp getJobEndTime(String jobendtime) {
		RxBLoaderThreadService threadService = null;
		Long jobKillTime=0L;
		Timestamp time = null;
		try{
			if(jobendtime != null && !jobendtime.isEmpty()) {
				threadService =(RxBLoaderThreadService) ApplicationContextProvider.getApplicationContext().getBean("rxbLoaderThreadService");
				jobKillTime=threadService.getDifferneceInMin(jobendtime,new Date());
				Calendar currentTime = Calendar.getInstance();
				currentTime.clear();
				currentTime.setTime(new Date());
				currentTime.add(Calendar.MINUTE,jobKillTime.intValue());
			 	time = new Timestamp(currentTime.getTimeInMillis());
			} else {
				time = new Timestamp(System.currentTimeMillis());
			}
		} catch(Exception exception) {
			log.error("Error in getJobEndTime():"+ExceptionUtil.getStackTrace(exception));
			time = new Timestamp(System.currentTimeMillis());
		}
		return time;
	}

}
