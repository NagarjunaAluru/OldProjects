/**
 * 
 */
package com.optumrx.rxb.dataloader.model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author Aluru.Nagarjuna
 *
 */
public class RxBAudit implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String batchNo;
	private Timestamp jobInvokeStartTime;
	private Timestamp jobInvokeEndTime;
	private String fileValidationStatus;
	private String dataLoadStatus;
	
	private String batchLapsedTime;
	private Integer totalFormularies;
	private Integer skippedFormularies;
	private Integer loadedFormularies;
	private Integer erroredFormularies;
	
	private String archiveFileName;
	private String archiveFileDeleted;
	
	public RxBAudit(String batchNo, String fileValidationStatus, Timestamp jobInvokeStartTime) {
		this.batchNo = batchNo;
		this.fileValidationStatus = fileValidationStatus;
		this.jobInvokeStartTime = jobInvokeStartTime;
	}
	
	public RxBAudit(String batchNo, Timestamp jobInvokeEndTime) {
		this.batchNo = batchNo;
		this.jobInvokeEndTime = jobInvokeEndTime;
	}
	
	public RxBAudit() {
	}

	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public String getFileValidationStatus() {
		return fileValidationStatus;
	}
	public void setFileValidationStatus(String fileValidationStatus) {
		this.fileValidationStatus = fileValidationStatus;
	}
	public String getDataLoadStatus() {
		return dataLoadStatus;
	}
	public void setDataLoadStatus(String dataLoadStatus) {
		this.dataLoadStatus = dataLoadStatus;
	}
	public String getBatchLapsedTime() {
		return batchLapsedTime;
	}
	public void setBatchLapsedTime(String batchLapsedTime) {
		this.batchLapsedTime = batchLapsedTime;
	}
	public Integer getTotalFormularies() {
		return totalFormularies;
	}
	public void setTotalFormularies(Integer totalFormularies) {
		this.totalFormularies = totalFormularies;
	}
	public Integer getSkippedFormularies() {
		return skippedFormularies;
	}
	public void setSkippedFormularies(Integer skippedFormularies) {
		this.skippedFormularies = skippedFormularies;
	}
	public Integer getLoadedFormularies() {
		return loadedFormularies;
	}
	public void setLoadedFormularies(Integer loadedFormularies) {
		this.loadedFormularies = loadedFormularies;
	}
	public Integer getErroredFormularies() {
		return erroredFormularies;
	}
	public void setErroredFormularies(Integer erroredFormularies) {
		this.erroredFormularies = erroredFormularies;
	}
	public Timestamp getJobInvokeStartTime() {
		return jobInvokeStartTime;
	}
	public void setJobInvokeStartTime(Timestamp jobInvokeStartTime) {
		this.jobInvokeStartTime = jobInvokeStartTime;
	}
	public Timestamp getJobInvokeEndTime() {
		return jobInvokeEndTime;
	}
	public void setJobInvokeEndTime(Timestamp jobInvokeEndTime) {
		this.jobInvokeEndTime = jobInvokeEndTime;
	}
	public String getArchiveFileName() {
		return archiveFileName;
	}
	public void setArchiveFileName(String archiveFileName) {
		this.archiveFileName = archiveFileName;
	}
	public String getArchiveFileDeleted() {
		return archiveFileDeleted;
	}
	public void setArchiveFileDeleted(String archiveFileDeleted) {
		this.archiveFileDeleted = archiveFileDeleted;
	}
	
}
