/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: IRecordsRetentionMgmtDAO.java
 * Purpose: IRecordsRetentionMgmtDAO used for maintaining Records Retention.
 *
 */
package com.ge.aloc.dao.admin;

import com.ge.aloc.IServiceClientAware;
import com.ge.aloc.model.RecordRetention;
import com.hydus.hwf.exceptions.HWFServiceException;
/**
 * @author madhusudhan.gosula
 *
 */
public interface IRecordsRetentionMgmtDAO extends IServiceClientAware {

	/**
	 * Method to get the available records retention management details.
	 * @return
	 * @throws HWFServiceException
	 */
	public RecordRetention open(RecordRetention recordRetention) throws HWFServiceException;

	/**
	 * Method to open the records purge report
	 * @param recordRetention
	 * @return
	 * @throws HWFServiceException
	 */
	public RecordRetention openRecordsPurgeReport(RecordRetention recordRetention) throws HWFServiceException;

	/**
	 * Method to modify the records retention management
	 * @param recordRetention
	 * @return
	 * @throws HWFServiceException
	 */
	public RecordRetention modify(RecordRetention recordRetention) throws HWFServiceException;

	/**
	 * Method to approve/reject the records retention management
	 * @param recordRetention
	 * @return
	 * @throws HWFServiceException
	 */
	public RecordRetention submit(RecordRetention recordRetention) throws HWFServiceException;

	/**
	 * Method to send the records retention management
	 * @param recordRetention
	 * @return
	 * @throws HWFServiceException
	 */
	public RecordRetention sendRecordRetentionMgmt(RecordRetention recordRetention) throws HWFServiceException;
}
