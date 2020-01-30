package com.optumrx.rxb.dataloader.orchestration.component;

import java.io.FileWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
import com.optumrx.rxb.dataloader.util.RxBLoaderUtil;


public class RxBLoadReportExecutor implements Runnable
{
	private static Logger log = LoggerFactory.getLogger(RxBLoadReportExecutor.class);
	FileReadUtil fileReadUtil = (FileReadUtil) ApplicationContextProvider.getApplicationContext().getBean("fileReaderUtil");
	IRxBLoadDao rxbLoader = (IRxBLoadDao) ApplicationContextProvider.getApplicationContext().getBean("rxbLoaderDao");
	RxBLoaderUtil loaderUtil = (RxBLoaderUtil) ApplicationContextProvider.getApplicationContext().getBean("loaderUtil");
	
	private static int count=0;
	private String errorReport;
	private String loadReport;
	
	private ThreadLocal<SimpleDateFormat> format = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH);
		}
	};
	
	@Override
	public void run() {
		Map<Integer,String> eofFile=null;
		String detailReport = null;
		CSVWriter detailWriter = null;
		CSVWriter emailReportWriter = null;
		String reportsPath = null;
		String regionBatchIds = null;
		List<String> fileList = null;
		List<EOFCSV> csvList = null;
		int batchId = 0;
		String eofFileName = null;
		try {
			// check if there is any job to be executed
			if (RxBLoadReportExecutorQ.isQEmpty()) {
				count=count+1;
				if(count<=15) {
					log.error(" ---- There are no records to process in RxBLoadReportExecutorQ! ----");
					return;
				}
				else {
					return;
				}
			}
			log.error(" ************** CURRENT JOBS IN REPORT EXECUTOR Q ["+RxBLoadReportExecutorQ.getQSize()+"] **************");
			count=0;
			
			eofFile=RxBLoadReportExecutorQ.getFromQ();
			
			if(eofFile==null){
				return;
			}
			
			String zipPath = loaderUtil.getZipPath();
			reportsPath = loaderUtil.getReportPath();
			String csvFolderPath = loaderUtil.getCsvPath();
			
			boolean reportsFlag = false;
			Map.Entry<Integer,String> entry=eofFile.entrySet().iterator().next();
			eofFileName = entry.getValue();
			batchId = entry.getKey();
			String gttLogs = "";
			
			String batchNo = null;
			if(eofFileName != null) {
				regionBatchIds = fileReadUtil.getRegionBatchIds(eofFileName,false);
				batchNo = fileReadUtil.getRegionBatchIds(eofFileName, true);
			}else {
				regionBatchIds = rxbLoader.getBatchNo(batchId);
				batchNo = regionBatchIds.substring(regionBatchIds.indexOf("_")+1);
			}
			String filename=regionBatchIds.concat(RxBLoaderUtil.EMAIL_REPORT).toUpperCase();
			log.info("Email report fileName :"+filename);
			emailReportWriter = new CSVWriter(new FileWriter(reportsPath.concat(filename)), ',');
			Calendar calendar =Calendar.getInstance();
			String archiveFileName = format.get().format(calendar.getTime())+"_"+regionBatchIds+".zip"; // suffix the datetimestamp.
			
			if(batchId > 0) {
				RxBAudit updatedRecord = rxbLoader.getAudit(batchId);
				if(updatedRecord.getBatchNo() != null && !updatedRecord.getBatchNo().isEmpty() && 
						updatedRecord.getDataLoadStatus()!= null && updatedRecord.getDataLoadStatus().equals("S")) {
					try{
						reportsFlag = createReports(regionBatchIds,batchId);
					} catch(Exception exception) {
						gttLogs = exception.getMessage();
					}
				} else if(updatedRecord.getBatchNo() != null && !updatedRecord.getBatchNo().isEmpty() && 
						updatedRecord.getDataLoadStatus()!= null && updatedRecord.getDataLoadStatus().equals("E")) {
					throw new Exception(gttLogs);
				}
				
				detailReport = regionBatchIds.concat(RxBLoaderUtil.BATCH_DETAILS_REPORT).toUpperCase();
				detailWriter = new CSVWriter(new FileWriter(reportsPath.concat(detailReport)), ',');
				
				rxbLoader.createBatchDetailReport(batchId,detailWriter);
				
				detailWriter.flush();
				detailWriter.close();
				
				log.info("eofFileName before processSummaryCsv "+eofFileName);
				csvList = fileReadUtil.processSummaryCsv(csvFolderPath, eofFileName);//Reading the eof csv file content.
				log.info("eofFileName before generateFileList "+eofFileName);
				fileList = fileReadUtil.generateFileList(csvList,eofFileName,null);
				
				//Archiving all the feed CSVs and Reports.
				fileReadUtil.zipIt(zipPath+archiveFileName,fileList,csvFolderPath,
					errorReport,loadReport,detailReport,reportsPath);
				
				//Once the csv files are archived, it will deletes files from the Feed folder
				fileReadUtil.deleteCSVFiles(csvFolderPath, fileList);
					
				//Updating Audit with archiveFileName and EndTime.
				rxbLoader.updateAudit(batchId,null,archiveFileName);
				
				if(reportsFlag) {
					//Getting Audit information to generate Email_Notification report.
					RxBAudit detailRecord = rxbLoader.getAudit(batchId);
					detailRecord.setBatchNo(batchNo);
					
					prepareAuditCSVBody(detailRecord,regionBatchIds,emailReportWriter);
				}else {
					String error[] = {"Error occured while processing CSV files : GTT ::",gttLogs};
					//Generates Error report if any error occurred from DB end.
					emailReportWriter.writeNext(error);
				}
			} else {
				throw new Exception("Invalid BatchId:"+batchId);
			}
			
		}catch (Exception exception) {
			log.error("Exception in RxBLoadReportExecutor run() :: "+ExceptionUtil.getStackTrace(exception));
			try {
				String emailFileName=regionBatchIds.concat(RxBLoaderUtil.EMAIL_REPORT).toUpperCase();
				log.info("Email report name "+emailFileName);
				String errorMsg[] = {"Error occured while loading CSVs:",exception.getMessage()};
				//Generates Error report if any error occurred from java or timeout from DB end.
				loaderUtil.createCSVFile(reportsPath.concat(emailFileName),errorMsg);
			} catch (Exception ioException) {
				log.error("Exception in RxBLoadReportExecutor catch block :: "+ExceptionUtil.getStackTrace(ioException));
			}
		} finally {
			try {
				if(emailReportWriter != null) {
					emailReportWriter.flush();
					emailReportWriter.close();
				}
				if(eofFileName != null || batchId>0) {
					String errorMsg[] = {};
					if(eofFileName == null)//Constructing EOF file name for failed case.
						eofFileName = regionBatchIds.replaceFirst("_", "#").concat("#ZEOF.CSV");
					loaderUtil.createCSVFile(reportsPath.concat(eofFileName.toUpperCase()),errorMsg);
				}
			} catch (Exception exception) {
				log.error("Exception in RxBLoadReportExecutor finally block :: "+ExceptionUtil.getStackTrace(exception));
			}
		}
	}
	
	/**
	 * 
	 * @param regionBatchIds
	 * @param eofFileName
	 * @throws Exception 
	 */
	private boolean createReports(String regionBatchIds, int batchId) throws Exception {
		log.debug("-----RxBLoadOrchestrator createReports() Start-----");
		String reportsPath = loaderUtil.getReportPath();
		String csvPath = loaderUtil.getCsvPath();

		boolean reportsFlag = false;
		errorReport = regionBatchIds.concat(RxBLoaderUtil.ERROR_REPORT).toUpperCase();
		loadReport = regionBatchIds.concat(RxBLoaderUtil.LOAD_REPORT).toUpperCase();
		try{
			log.info("error rpt name in createReports:" +errorReport);
			log.info("load rpt name in createReports:" +loadReport);
			
			rxbLoader.updateAuditReportTimes(batchId,"", true);//Updating report start time in Audit
			
			rxbLoader.createReports(batchId,csvPath,reportsPath.concat(errorReport),reportsPath.concat(loadReport));
			reportsFlag = true;
			//Updating the report flag to Completed i'e 'C' and end time in Audit
			rxbLoader.updateAuditReportTimes(batchId,"C", false);
			rxbLoader.deleteReportData(batchId);//Deleting reports data from report tables.
			
			log.debug("Error Report File path :"+reportsPath.concat(errorReport));
			log.debug("Load Summary Report File path :"+reportsPath.concat(loadReport));
		}catch(Exception exception){
			log.error("Error in createReports():"+ExceptionUtil.getStackTrace(exception)); 
			if(reportsFlag) {
				//Updating the report flag to Completed i'e 'C'and end time in Audit
				rxbLoader.updateAuditReportTimes(batchId,"C", false);
				rxbLoader.deleteReportData(batchId);//Deleting reports data from report tables.
			}else {
				rxbLoader.updateAuditReportTimes(batchId,"Y", false);
			}
		}
		log.debug("-----RxBLoadOrchestrator createReports() End-----");
		return reportsFlag;
	}
	
	/**
	 * This method will prepare the Email_Notification report data.
	 * @param audit
	 * @param regionBatchIds
	 * @return
	 */
	private void prepareAuditCSVBody(RxBAudit audit, String regionBatchIds, CSVWriter emailReport) {
		log.debug("-----RxBLoadOrchestrator prepareAuditCSVBody() Start-----");
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
		NumberFormat formatter = new DecimalFormat("00");
		Date startTime = null;
		Date endTime = null;
		if(audit.getJobInvokeStartTime()!=null) {
			startTime = new Date(audit.getJobInvokeStartTime().getTime());
		}
		if(audit.getJobInvokeEndTime()!=null) {
			endTime = new Date(audit.getJobInvokeEndTime().getTime());
		}
		long diff = (endTime!=null?endTime.getTime():0) - (startTime!=null?startTime.getTime():0);
	    long diffSeconds = diff / 1000 % 60;
	    long diffMinutes = diff / (60 * 1000) % 60;
	    long diffHours = diff / (60 * 60 * 1000);
	    
	    String[] csvRow1 = {"BMS to RxBuilder load details are:" };
	    String[] csvRow2 = {"Batch : ",audit.getBatchNo()};
	    String[] csvRow3 = {"Batch Name ",regionBatchIds};
    	String[] csvRow4 = {"Batch Status ",(audit.getDataLoadStatus()!=null
				&& audit.getDataLoadStatus().equals("S")? "LOAD COMPLETED":"LOAD FAILED")};
    	String[] csvRow5 = {"Batch Start DateTime ",(startTime!=null?format.format(startTime):"")};
    	String[] csvRow6 = {"Batch End DateTime ",(endTime!=null?format.format(endTime):"")};
    	String[] csvRow7 = {"Batch Lapsed Time(hh:mm:ss) ",(formatter.format(diffHours)+":"
	  			+(formatter.format(diffMinutes)+":"+formatter.format(diffSeconds)))};
    	String[] csvRow8 = {"Total Formularies",audit.getTotalFormularies().toString()};
    	String[] csvRow9 = {"Total Formularies Updated",audit.getSkippedFormularies().toString()};
    	String[] csvRow10 = {"Total Formularies Loaded",audit.getLoadedFormularies().toString()};
    	String[] csvRow11 = {"Total Formularies Errored",audit.getErroredFormularies().toString()};
    	String[] blankRow = {""};
	    emailReport.writeNext(csvRow1);
	    emailReport.writeNext(blankRow);
	    emailReport.writeNext(csvRow2);
	    emailReport.writeNext(blankRow);
	    emailReport.writeNext(csvRow3);
	    emailReport.writeNext(csvRow4);
	    emailReport.writeNext(csvRow5);
	    emailReport.writeNext(csvRow6);
	    emailReport.writeNext(csvRow7);
	    emailReport.writeNext(blankRow);
	    emailReport.writeNext(csvRow8);
	    emailReport.writeNext(csvRow9);
	    emailReport.writeNext(csvRow10);
	    emailReport.writeNext(csvRow11);
	  	log.debug("-----RxBLoadOrchestrator prepareAuditCSVBody() End-----");
	}
	
}
