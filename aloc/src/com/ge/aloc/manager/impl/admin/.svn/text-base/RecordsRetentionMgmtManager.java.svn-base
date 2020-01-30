/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: RecordsRetentionMgmtManager.java
 * Purpose: RecordsRetentionMgmtManager used for Retention management operations and user actions.
 */
package com.ge.aloc.manager.impl.admin;

import com.ge.aloc.OpCode;
import com.ge.aloc.dao.admin.IRecordsRetentionMgmtDAO;
import com.ge.aloc.manager.admin.IRecordsRetentionMgmtManager;
import com.ge.aloc.model.MsgHeader;
import com.ge.aloc.model.RecordRetention;
import com.ge.aloc.util.ALOCCommonHelper;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author madhusudhan.gosula
 *
 */
public class RecordsRetentionMgmtManager implements IRecordsRetentionMgmtManager{

	private IRecordsRetentionMgmtDAO recordRetentionMgmtDAO;

	/**
	 * This method is used to fetch the records retention management.
	 * @return RecordRetention
	 */
	public RecordRetention open() throws HWFServiceException {
		RecordRetention recordRetention = new RecordRetention();
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.INITIATERECORDSRETENTION.getOperationCode());
		recordRetention.setMsgHeader(msgHeader);
		recordRetention = recordRetentionMgmtDAO.open(recordRetention);
		return recordRetention;
	}
	/**
	 * This method is used to fetch the records retention management purge report.
	 * @return RecordRetention
	 */
	public RecordRetention openRecordsPurgeReport() throws HWFServiceException {
		RecordRetention recordRetention = new RecordRetention();
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.OPENRECORDSPURGEREPORT.getOperationCode());
		recordRetention.setMsgHeader(msgHeader);
		recordRetention = recordRetentionMgmtDAO.openRecordsPurgeReport(recordRetention);
		return recordRetention;
	}
	/**
	 * Method to update given records retention management.
	 * @return added or updated Records Retention
	 */
	public RecordRetention modify(RecordRetention recordRetention )
			throws HWFServiceException {
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.UPDATERECORDSRETENTION.getOperationCode());
		recordRetention.setMsgHeader(msgHeader);
		return recordRetentionMgmtDAO.modify(recordRetention);
	}

	/**
	 * Method to approve/reject the records retention management.
	 * @return added or updated RecordRetention
	 */
	public RecordRetention submit(RecordRetention recordRetention)
			throws HWFServiceException {
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.SUBMITRECORDSRETENTION.getOperationCode());
		recordRetention.setMsgHeader(msgHeader);
		return recordRetentionMgmtDAO.submit(recordRetention);
	}

	/**
	 * Method is used to send to records retention management.
	 * @return added or updated RecordRetention
	 */
	public RecordRetention sendRecordRetentionMgmt(RecordRetention recordRetention)
			throws HWFServiceException {
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.SENDRECORDRETENTION.getOperationCode());
		recordRetention.setMsgHeader(msgHeader);
		return recordRetentionMgmtDAO.sendRecordRetentionMgmt(recordRetention);
	}
	/**
	 * This method is used to get recordRetentionMgmtDAO instance
	 * @return the recordRetentionMgmtDAO
	 */
	public IRecordsRetentionMgmtDAO getRecordRetentionMgmtDAO() {
		return recordRetentionMgmtDAO;
	}
	/**
	 *  This method is used to set recordRetentionMgmtDAO instance
	 * @param recordRetentionMgmtDAO the recordRetentionMgmtDAO to set
	 */
	public void setRecordRetentionMgmtDAO(
			IRecordsRetentionMgmtDAO recordRetentionMgmtDAO) {
		this.recordRetentionMgmtDAO = recordRetentionMgmtDAO;
	}

}
