/**
 * 
 */
package com.optumrx.rxb.dataloader.util;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import au.com.bytecode.opencsv.CSVWriter;

/**
 * @author Aluru.Nagarjuna
 *
 */
public class RxBLoaderUtil {
	
	private static Logger log = LoggerFactory.getLogger(RxBLoaderUtil.class);
	
	public static final String ERROR_REPORT = "_ERROR_REPORT.CSV";
	public static final String LOAD_REPORT = "_LOAD_REPORT.CSV";
	public static final String BATCH_DETAILS_REPORT = "_DETAILS_REPORT.CSV";
	public static final String EMAIL_REPORT = "_EMAIL_NOTIFICATION.CSV";
	
	private String zipPath;
	private String reportPath;
	private String optionKey;
	private String csvPath;
	private String jobendtime;
	private String coolofperiod;
	private int archiveDeleteDays;
	
	
	/**
	 * @param resultSet
	 * @param statement
	 * @param connection
	 */
	public static void closeDBObjects(ResultSet resultSet, Statement statement, Connection connection) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (Exception exception) {
				log.error("Error while closing ResultSet:"+ExceptionUtil.getStackTrace(exception));
			}
		}
		if (statement != null) {
			try {
				statement.close();
			} catch (Exception exception) {
				log.error("Error while closing Statement:"+ExceptionUtil.getStackTrace(exception));
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (Exception exception) {
				log.error("Error while closing Connection:"+ExceptionUtil.getStackTrace(exception));
			}
		}
	}
	
	/**
	 * This method will create CSV Report file 
	 * @param fileName
	 * @param errorMsg
	 * @throws IOException
	 */
	public void createCSVFile(String fileName, String[] errorMsg) throws IOException {
		CSVWriter csvWriter = new CSVWriter(new FileWriter(fileName), ',');
		csvWriter.writeNext(errorMsg);
		csvWriter.flush();
		csvWriter.close();
	}
	
	public String getZipPath() {
		return zipPath;
	}
	public void setZipPath(String zipPath) {
		this.zipPath = zipPath;
	}
	public String getReportPath() {
		return reportPath;
	}
	public void setReportPath(String reportPath) {
		this.reportPath = reportPath;
	}
	public String getCsvPath() {
		return csvPath;
	}
	public void setCsvPath(String csvPath) {
		this.csvPath = csvPath;
	}
	public String getOptionKey() {
		return optionKey;
	}
	public void setOptionKey(String optionKey) {
		this.optionKey = optionKey;
	}
	public String getJobendtime() {
		return jobendtime;
	}
	public void setJobendtime(String jobendtime) {
		this.jobendtime = jobendtime;
	}
	public String getCoolofperiod() {
		return coolofperiod;
	}
	public void setCoolofperiod(String coolofperiod) {
		this.coolofperiod = coolofperiod;
	}
	public int getArchiveDeleteDays() {
		return archiveDeleteDays;
	}
	public void setArchiveDeleteDays(int archiveDeleteDays) {
		this.archiveDeleteDays = archiveDeleteDays;
	}

	@Override
	public String toString() {
		return "RxBLoaderUtil [zipPath=" + zipPath + ", reportPath=" + reportPath + ", optionKey=" + optionKey + ", csvPath=" + csvPath
				+ ", jobendtime=" + jobendtime + ", coolofperiod=" + coolofperiod + ", archiveDeleteDays=" + archiveDeleteDays + "]";
	}

}
