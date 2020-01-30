/**
 * 
 */
package com.optumrx.rxb.dataloader.dao.db2;

import java.sql.Timestamp;
import java.util.List;

import au.com.bytecode.opencsv.CSVWriter;

import com.optumrx.rxb.dataloader.model.RxBAudit;
import com.optumrx.rxb.dataloader.util.RxBLoaderUtil;

/**
 * @author Aluru.Nagarjuna
 *
 */
public interface IRxBLoadDao {

	public String callCSVProc(String eofFileName,RxBLoaderUtil loaderUtil, Timestamp jobEndTime, int batchId) throws Exception;
	
	public void createReports(int batchId, String csvPath, String errWriter, String statusWriter) throws Exception;
	
	public void createBatchDetailReport(int batchId, CSVWriter detailWriter) throws Exception;
	
	public int insertBatch(String batchNo) throws Exception;
	
	public String getBatchNo(int batchId) throws Exception;
	
	public RxBAudit getAudit(int batchId) throws Exception;
	
	public List<RxBAudit> getAuditByFlag() throws Exception;
	
	public void insertAudit(int batchId, String status) throws Exception;
	
	public void updateAudit(int batchId, String batchNo, String archiveFileName) throws Exception;
	
	public void updateAuditReportTimes(int batchId, String reportFlag, boolean isStartTime) throws Exception;
	
	public void deleteReportData(int batchId) throws Exception;
	
	public List<RxBAudit> getArchieveRecords(int days) throws Exception;

}