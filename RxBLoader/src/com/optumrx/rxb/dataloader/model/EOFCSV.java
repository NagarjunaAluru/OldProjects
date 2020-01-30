/**
 * 
 */
package com.optumrx.rxb.dataloader.model;

import java.io.Serializable;

/**
 * 
 * @author Aluru.Nagarjuna
 *
 */
public class EOFCSV implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String recordType;
	private String fileName ; 
	private String recordCount ;
	/**
	 * @return the recordType
	 */
	public String getRecordType() {
		return recordType;
	}
	/**
	 * @param recordType the recordType to set
	 */
	public void setRecordType(String recordType) {
		this.recordType = recordType;
	}
	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * @return the recordCount
	 */
	public String getRecordCount() {
		return recordCount;
	}
	/**
	 * @param recordCount the recordCount to set
	 */
	public void setRecordCount(String recordCount) {
		this.recordCount = recordCount;
	}
	/** (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SummaryCSV [recordType=" + recordType + ", fileName="
				+ fileName + ", recordCount=" + recordCount + "]";
	} 
	
}
