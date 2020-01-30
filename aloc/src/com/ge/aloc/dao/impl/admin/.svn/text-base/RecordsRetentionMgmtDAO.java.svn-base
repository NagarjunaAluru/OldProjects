/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: RecordsRetentionMgmtDAO.java
 * Purpose: RecordsRetentionMgmtDAO used for add or update Records Retention management.
 *
 */
package com.ge.aloc.dao.impl.admin;

import com.ge.aloc.OpCode;
import com.ge.aloc.ServiceClientSupport;
import com.ge.aloc.dao.admin.IRecordsRetentionMgmtDAO;
import com.ge.aloc.model.RecordRetention;
import com.hydus.hwf.exceptions.HWFServiceException;
/**
 * @author madhusudhan.gosula
 *
 */
public class RecordsRetentionMgmtDAO extends ServiceClientSupport implements IRecordsRetentionMgmtDAO {

	/**
	 * Method to open given records retention management
	 * @param recordRetention
	 * @return
	 * @throws HWFServiceException
	 */
	public RecordRetention open(RecordRetention recordRetention)
			throws HWFServiceException {
		return (RecordRetention) serviceClient.invokeService(OpCode.RECORDRETENTION.getOperationCode(), recordRetention, RecordRetention.class);
	}
	/**
	 * Method to add or update given records retention management
	 * @param recordRetention
	 * @return
	 * @throws HWFServiceException
	 */
	public RecordRetention modify(RecordRetention recordRetention)
			throws HWFServiceException {
		return (RecordRetention) serviceClient.invokeService(OpCode.RECORDRETENTION.getOperationCode(), recordRetention, RecordRetention.class);
	}

	/**
	 * Method to open records retention management purge report
	 * @param recordRetention
	 * @return
	 * @throws HWFServiceException
	 */

	public RecordRetention openRecordsPurgeReport(RecordRetention recordRetention)
			throws HWFServiceException {
		return (RecordRetention) serviceClient.invokeService(OpCode.RECORDRETENTION.getOperationCode(), recordRetention, RecordRetention.class);
	}

	/**
	 * Method to approve/reject given records retention management
	 * @param recordRetention
	 * @return
	 * @throws HWFServiceException
	 */
	public RecordRetention submit(RecordRetention recordRetention)
			throws HWFServiceException {
		return (RecordRetention) serviceClient.invokeService(OpCode.RECORDRETENTION.getOperationCode(), recordRetention, RecordRetention.class);
	}
	/**
	 * Method to send records retention management
	 * @param recordRetention
	 * @return
	 * @throws HWFServiceException
	 */
	public RecordRetention sendRecordRetentionMgmt(RecordRetention recordRetention)
			throws HWFServiceException {
		return (RecordRetention) serviceClient.invokeService(OpCode.RECORDRETENTION.getOperationCode(), recordRetention, RecordRetention.class);
	}
}
