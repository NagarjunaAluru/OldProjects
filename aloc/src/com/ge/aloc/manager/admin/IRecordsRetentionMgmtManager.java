/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: IRecordsRetentionMgmtManager.java
 * Purpose: IRecordsRetentionMgmtManager used for records retention Management operations and user actions.
 */
package com.ge.aloc.manager.admin;

import com.ge.aloc.model.RecordRetention;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author madhusudhan.gosula
 *
 */
public interface IRecordsRetentionMgmtManager {

	/**
	 * Method to open given Records retention management
	 * @return
	 * @throws HWFServiceException
	 */
	public RecordRetention open() throws HWFServiceException ;


	/**
	 * Method to approve/reject Records retention management
	 * @param suretyMaster
	 * @return
	 * @throws HWFServiceException
	 */
	public RecordRetention submit(RecordRetention recordRetention) throws HWFServiceException ;

	/**
	 * Method to open the Records retention management purge report
	 * @return
	 * @throws HWFServiceException
	 */
	public RecordRetention openRecordsPurgeReport() throws HWFServiceException;


	/**
	 * Method to update given Records retention management
	 * @return
	 * @throws HWFServiceException
	 */
	public RecordRetention modify(RecordRetention recordRetention) throws HWFServiceException;

	/**
	 * Method to send Records retention management
	 * @return
	 * @throws HWFServiceException
	 */
	public RecordRetention sendRecordRetentionMgmt(RecordRetention recordRetention) throws HWFServiceException;
}
