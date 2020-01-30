/**
 * 
 */
package com.optumrx.rxb.dataloader.dao.db2.impl;

import java.io.FileWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import au.com.bytecode.opencsv.CSVWriter;

import com.optumrx.rxb.dataloader.dao.db2.IRxBLoadDao;
import com.optumrx.rxb.dataloader.model.RxBAudit;
import com.optumrx.rxb.dataloader.util.ExceptionUtil;
import com.optumrx.rxb.dataloader.util.RxBLoaderUtil;



/**
 * 
 * @author Aluru.Nagarjuna
 *
 */
public class RxBLoadDaoImpl implements IRxBLoadDao {
	
	private static Logger log = LoggerFactory.getLogger(RxBLoadDaoImpl.class);
	
	private JdbcTemplate jdbcTemplateObject;
	
	private static final String INSERT_BATCH = "insert into MI_RXB_BATCH_INFO (BATCH_NO,LAST_UPD_TIMESTAMP) values(?,CURRENT_TIMESTAMP)";

	
	@Override
	public String callCSVProc(String eofFileName,RxBLoaderUtil loaderUtil, Timestamp jobEndTime, int batchId) throws Exception {
		log.debug("-----RxBLoadDaoImpl callCSVProc() Start-----");
		log.error("*** EOF file name:"+eofFileName+" ***");
		long startTime = System.currentTimeMillis();
		Connection connection = null;
		CallableStatement callableStmt = null;
		Statement statement=null;
		ResultSet rs = null;
		StringBuilder gttLogs = new StringBuilder(); 
		try {
			connection = getConnection();

			callableStmt = connection.prepareCall("{ CALL RXB_LOADER_PROC (?, ?, ?, ?, ?) }");
			callableStmt.setString(1, eofFileName);
			//callableStmt.setInt(2, batchId);
			callableStmt.setTimestamp(2, jobEndTime);
			callableStmt.setString(3, loaderUtil.getCoolofperiod());
			callableStmt.setString(4, loaderUtil.getOptionKey());
			//callableStmt.setString(6, loaderUtil.getCsvPath());
			callableStmt.setString(5, "/rxbshare/rxbsysdev4/rxbload/RxbLoaderFeed/");
			callableStmt.execute();
			log.debug("RXB_LOADER_PROC (?, ?, ?, ?, ?) Executed Successfully");
		} catch (Exception e) {
			log.error("Error in callCSVProc :RXB_LOADER_PROC" + ExceptionUtil.getStackTrace(e));
			statement = connection.createStatement();
            rs = statement.executeQuery("select * from session.logs");
            log.error(" ********************** GTT Start ***************************** ");
            while(rs.next()) {
                log.error("RXB_LOADER_PROC Log Exceptions GTT = {PROC_NAME: "+rs.getString(1)+"\n LOG_MESSAGE: "
                			+rs.getString(2)+"\n ERROR_MESSAGE: "+rs.getString(3)+"}");
                gttLogs.append("RXB_LOADER_PROC Log Exceptions GTT = PROC_NAME: "+rs.getString(1)+"; LOG_MESSAGE: "
                			+rs.getString(2)+"; ERROR_MESSAGE: "+rs.getString(3));
            }
            log.error(" *********************** GTT End ****************************** ");
		} finally {
			log.info("Closing DB Objects");
			RxBLoaderUtil.closeDBObjects(rs, statement, null);
			RxBLoaderUtil.closeDBObjects(null, callableStmt, connection);
		}
		long endTime = System.currentTimeMillis();
		log.debug(" ********************** ");
		log.debug("TIME TAKEN TO EXECUTE RXB_LOADER_PROC PROCEDURE : [" + (endTime - startTime) + "] in milliseconds");
		log.debug(" ********************** ");
		log.debug("-----RxBLoadDaoImpl callCSVProc() End-----");
		return gttLogs.toString();
	}
	
	@Override
	public void createReports(int batchId, String csvPath, String errorReport, String loadReport) throws Exception {
		log.debug("-----RxBLoadDaoImpl createReports() Start-----");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		CSVWriter errorWriter = null;
		CSVWriter loadWriter = null;
		try{
			connection = getConnection();
			
			preparedStatement = connection.prepareStatement("SELECT * FROM MI_RXB_ERROR_REPORT where BATCH_ID=?");
			preparedStatement.setInt(1, batchId);
			rs = preparedStatement.executeQuery();
			if (rs != null) {
				errorWriter = new CSVWriter(new FileWriter(errorReport), ',');
		    	errorWriter.writeAll(rs, true);
		    	errorWriter.flush();
				errorWriter.close();
				log.debug("***** Error Report File path:"+errorReport+" *****");
			}
			
			preparedStatement = connection.prepareStatement("SELECT * FROM MI_RXB_LOAD_STATUS where BATCH_ID=?");
			preparedStatement.setInt(1, batchId);
			rs = preparedStatement.executeQuery();
			if (rs != null) {
				loadWriter = new CSVWriter(new FileWriter(loadReport), ',');
		    	loadWriter.writeAll(rs, true);
		    	loadWriter.flush();
				loadWriter.close();
				log.debug("***** Load Report generated @:"+loadReport+" *****");
			}
		}catch(Exception e){
			log.error("Error in RxBLoadDaoImpl createReports() :"+ExceptionUtil.getStackTrace(e));
			throw new Exception(e);
		}finally{
			log.info("Closing DB Objects");
			RxBLoaderUtil.closeDBObjects(rs, preparedStatement, connection);
		}
		log.debug("-----RxBLoadDaoImpl createReports() End-----");
	}
	
	@Override
	public void createBatchDetailReport(int batchId, CSVWriter detailWriter) throws Exception {
		log.debug("-----RxBLoadDaoImpl createBatchDetailReport() Start-----");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try{
			connection = getConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM MI_RXB_BATCH_DETAILS_INFO where BATCH_ID=?");
			preparedStatement.setInt(1, batchId);
			rs = preparedStatement.executeQuery();
			
			if (rs != null) {
				detailWriter.writeAll(rs, true);
			}
		}catch(Exception e){
			log.error("Error in RxBLoadDaoImpl createBatchDetailReport():"+ExceptionUtil.getStackTrace(e));
			throw e;
		}finally{
			log.info("Closing DB Objects");
			RxBLoaderUtil.closeDBObjects(rs, preparedStatement, connection);
		}
		log.debug("-----RxBLoadDaoImpl createBatchDetailReport() End-----");
	}
	
	@SuppressWarnings("static-access")
	@Override
	public int insertBatch(String batchNo) throws Exception {
		log.debug("-----RxBLoadDaoImpl insertBatch() Start-----");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		int batchId = 0;
		try{
			connection = getConnection();
			preparedStatement =connection.prepareStatement(INSERT_BATCH,preparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, batchNo);
			preparedStatement.executeUpdate();
			
			rs = preparedStatement.getGeneratedKeys();
			if (rs.next()) {
				batchId = rs.getInt(1);
			}
		}catch(Exception e){
			log.error("Error in insertBatch():"+ExceptionUtil.getStackTrace(e));
			throw e;
		}finally{
			log.info("Closing DB Objects");
			RxBLoaderUtil.closeDBObjects(rs, preparedStatement, connection);
		}
		log.debug("-----RxBLoadDaoImpl insertBatch() End-----");
		return batchId;
	}
	
	@Override
	public String getBatchNo(int batchId) throws Exception {
		log.debug("-----RxBLoadDaoImpl getBatchNo() Start-----");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		String batchNo = null;
		try{
			connection = getConnection();
			preparedStatement =connection.prepareStatement("Select * from MI_RXB_BATCH_INFO WHERE BATCH_ID=? ");
			preparedStatement.setInt(1, batchId);
			rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				batchNo = rs.getString("BATCH_NO");
			}
		}catch(Exception e){
			log.error("Error in getBatchNo():"+ExceptionUtil.getStackTrace(e));
			throw e;
		}finally{
			log.info("Closing DB Objects");
			RxBLoaderUtil.closeDBObjects(rs, preparedStatement, connection);
		}
		log.debug("-----RxBLoadDaoImpl getBatchNo() End-----");
		return batchNo;
	}
	
	@Override
	public RxBAudit getAudit(int batchId) throws Exception {
		log.debug("-----RxBLoadDaoImpl getAudit() Start-----");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		RxBAudit audit = new RxBAudit();
		try{
			connection = getConnection();
			preparedStatement =connection.prepareStatement("select * from MI_RXB_AUDIT_INFO where BATCH_ID=?");
			preparedStatement.setInt(1, batchId);
			rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				audit.setBatchNo(rs.getString("BATCH_ID"));
				audit.setJobInvokeStartTime(rs.getTimestamp("JOB_INVOKE_START_TIME"));
				audit.setJobInvokeEndTime(rs.getTimestamp("JOB_INVOKE_END_TIME"));
				audit.setFileValidationStatus(rs.getString("FILES_VALIDATION_STATUS"));
				audit.setDataLoadStatus(rs.getString("DATA_LOAD_STATUS"));
				audit.setTotalFormularies(rs.getInt("TOTAL_FORMULARIES"));
				audit.setSkippedFormularies(rs.getInt("FORMULARIES_SKIPPED"));
				audit.setLoadedFormularies(rs.getInt("FORMULARIES_LOADED"));
				audit.setErroredFormularies(rs.getInt("FORMULARIES_ERRORED"));
			}
		}catch(Exception e){
			log.error("Error in getAudit():"+ExceptionUtil.getStackTrace(e));
			throw e;
		}finally{
			log.info("Closing DB Objects");
			RxBLoaderUtil.closeDBObjects(rs, preparedStatement, connection);
		}
		log.debug("-----RxBLoadDaoImpl getAudit() End-----");
		return audit;
	}

	@Override
	public void insertAudit(int batchId, String status) throws Exception {
		log.debug("-----RxBLoadDaoImpl insertAudit() Start-----");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
	    
		try{
			connection = getConnection();
			preparedStatement =connection.prepareStatement("insert into MI_RXB_AUDIT_INFO " +
					"(BATCH_ID,JOB_INVOKE_START_TIME,FILES_VALIDATION_STATUS,ARCHIVE_FILE_NAME) values(?,CURRENT_TIMESTAMP,?,'')");
			preparedStatement.setInt(1, batchId);
			preparedStatement.setString(2, status);
			preparedStatement.executeUpdate();
		}catch(Exception e){
			log.error("Error in insertAudit():"+ExceptionUtil.getStackTrace(e));
			throw e;
		}finally{
			log.info("Closing DB Objects");
			RxBLoaderUtil.closeDBObjects(null, preparedStatement, connection);
		}
		log.debug("-----RxBLoadDaoImpl insertAudit() End-----");
	}
	
	@Override
	public void updateAuditReportTimes(int batchId, String reportFlag, boolean isStartTime) throws Exception {
		log.debug("-----RxBLoadDaoImpl updateAuditReportTimes() Start-----");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String query = null;
		try{
			connection = getConnection();
			if(isStartTime) {
				query = "UPDATE MI_RXB_AUDIT_INFO SET REPORT_START_TIME = CURRENT_TIMESTAMP where BATCH_ID = ?";
			}else {
				query = "UPDATE MI_RXB_AUDIT_INFO SET (REPORT_END_TIME,REPORT_GEN_FLAG) = (CURRENT_TIMESTAMP,?) where BATCH_ID = ?";
			}
			preparedStatement =connection.prepareStatement(query);
			if(isStartTime) {
				preparedStatement.setInt(1, batchId);
			}else {
				preparedStatement.setString(1, reportFlag);
				preparedStatement.setInt(2, batchId);
			}
			preparedStatement.executeUpdate();
		}catch(Exception e){
			log.error("Error in updateAuditReportTimes():"+ExceptionUtil.getStackTrace(e));
			throw e;
		}finally{
			log.info("Closing DB Objects");
			RxBLoaderUtil.closeDBObjects(null, preparedStatement, connection);
		}
		log.debug("-----RxBLoadDaoImpl updateAuditReportTimes() End-----");
	}
	
	@Override
	public void updateAudit(int batchId, String batchSlNo, String archiveFileName) throws Exception {
		log.debug("-----RxBLoadDaoImpl updateAudit() Start-----");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String query = null;
		int batch = 0;
		try{
			connection = getConnection();
			
			if(batchSlNo != null) {
				query = "UPDATE MI_RXB_AUDIT_INFO set ARCHIVE_DELETED = 'Y' where BATCH_ID = ?";
				batch = Integer.valueOf(batchSlNo).intValue();
			}else {
				query = "UPDATE MI_RXB_AUDIT_INFO SET (JOB_INVOKE_END_TIME, ARCHIVE_FILE_NAME) = (CURRENT_TIMESTAMP, ?) where BATCH_ID = ?";
				batch = batchId;
			}
			
			preparedStatement =connection.prepareStatement(query);
			if(batchSlNo != null) {
				preparedStatement.setInt(1, batch);
			} else {
				preparedStatement.setString(1, archiveFileName);
				preparedStatement.setInt(2, batch);
			}
			preparedStatement.executeUpdate();
		}catch(Exception e){
			log.error("Error in updateAudit():"+ExceptionUtil.getStackTrace(e));
			throw e;
		}finally{
			log.info("Closing DB Objects");
			RxBLoaderUtil.closeDBObjects(null, preparedStatement, connection);
		}
		log.debug("-----RxBLoadDaoImpl updateAudit() End-----");
	}
	
	@Override
	public void deleteReportData(int batchId) throws Exception {
		log.debug("-----RxBLoadDaoImpl deleteReportData() Start-----");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String query = null;
		try{
			connection = getConnection();
			if(batchId>0) {
				query = "DELETE FROM MI_RXB_ERROR_REPORT where BATCH_ID=?";
				preparedStatement =connection.prepareStatement(query);
				preparedStatement.setInt(1, batchId);
				preparedStatement.executeUpdate();
				
				query = "DELETE FROM MI_RXB_LOAD_STATUS where BATCH_ID=?";
				preparedStatement =connection.prepareStatement(query);
				preparedStatement.setInt(1, batchId);
				preparedStatement.executeUpdate();
			}
		}catch(Exception e){
			log.error("Error in deleteReportData():"+ExceptionUtil.getStackTrace(e));
		}finally{
			log.info("Closing DB Objects");
			RxBLoaderUtil.closeDBObjects(null, preparedStatement, connection);
		}
		log.debug("-----RxBLoadDaoImpl deleteReportData() End-----");
	}
	
	@Override
	public List<RxBAudit> getArchieveRecords(int days) throws Exception {
		log.debug("-----RxBLoadDaoImpl getArchieveRecords() Start-----");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<RxBAudit> auditList = new ArrayList<RxBAudit>();
		RxBAudit auditRecord = null;
		try{
			connection = getConnection();
			
			preparedStatement =connection.prepareStatement("SELECT * FROM MI_RXB_AUDIT_INFO WHERE " +
					"( ARCHIVE_DELETED IS NULL OR ARCHIVE_DELETED = 'N')AND DATE (JOB_INVOKE_END_TIME) " +
					"NOT BETWEEN CURRENT_DATE - ? DAYS AND CURRENT_DATE");
			preparedStatement.setInt(1, days);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				auditRecord = new RxBAudit();
				auditRecord.setBatchNo(resultSet.getString("BATCH_ID"));
				auditRecord.setJobInvokeStartTime(resultSet.getTimestamp("JOB_INVOKE_START_TIME"));
				auditRecord.setJobInvokeEndTime(resultSet.getTimestamp("JOB_INVOKE_END_TIME"));
				auditRecord.setArchiveFileName(resultSet.getString("ARCHIVE_FILE_NAME"));
				auditRecord.setArchiveFileDeleted(resultSet.getString("ARCHIVE_DELETED"));
				auditList.add(auditRecord);
			}
		}catch(Exception e){
			log.error("Error in getArchieveRecords():"+ExceptionUtil.getStackTrace(e));
		}finally{
			log.info("Closing DB Objects");
			RxBLoaderUtil.closeDBObjects(resultSet, preparedStatement, connection);
		}
		log.debug("-----RxBLoadDaoImpl getArchieveRecords() End-----");
		return auditList;
	}
	
	@Override
	public List<RxBAudit> getAuditByFlag() throws Exception {
		log.debug("-----RxBLoadDaoImpl getAuditByFlag() Start-----");
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		List<RxBAudit> auditList = new ArrayList<RxBAudit>();
		RxBAudit audit = null;
		try{
			connection = getConnection();
			statement =connection.createStatement();
			rs = statement.executeQuery("select * from MI_RXB_AUDIT_INFO where REPORT_GEN_FLAG='Y'");
			
			while (rs.next()) {
				audit = new RxBAudit();
				audit.setBatchNo(rs.getString("BATCH_ID"));
				auditList.add(audit);
			}
		}catch(Exception e){
			log.error("Error in getAuditByFlag():"+ExceptionUtil.getStackTrace(e));
		}finally{
			log.info("Closing DB Objects");
			RxBLoaderUtil.closeDBObjects(rs, statement, connection);
		}
		log.debug("-----RxBLoadDaoImpl getAuditByFlag() End-----");
		return auditList;
	}
	
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public Connection getConnection() throws SQLException {
			return this.jdbcTemplateObject.getDataSource().getConnection();
	}

}
