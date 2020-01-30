/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: FeeHistoryDAO.java
 * Purpose: FeeHistoryDAO.java used for maintaining Surety Names.
 *
 */

package com.ge.aloc.dao.impl.apm;

import com.ge.aloc.OpCode;
import com.ge.aloc.ServiceClientSupport;
import com.ge.aloc.dao.apm.IFeeHistoryDAO;
import com.ge.aloc.model.APMDetails;
import com.ge.aloc.model.MsgHeader;
import com.ge.aloc.util.ALOCCommonHelper;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author Rajat-Hydus
 *
 */
public class FeeHistoryDAO extends ServiceClientSupport implements IFeeHistoryDAO{

	/**
	 * Method to get the Default fee history Details - Top Level View
	 */
	public APMDetails searchFeeHistory()throws HWFServiceException {
		APMDetails apmDetails = new APMDetails();

		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.FEEHISTORY.getOperationCode());
		apmDetails.setMsgHeader(msgHeader);

		apmDetails = serviceClient.invokeService(OpCode.APMDETAILS.getOperationCode(), apmDetails, APMDetails.class);
		return apmDetails;
	}

	/**
	 * This Method is used to invoke the service to get FeeHistory Invoice Details
	 * @param apmDeails
	 * @return apmDeails
	 */
	public APMDetails exportInvoiceFeeHistory(APMDetails apmDetails)throws HWFServiceException {

		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.PRINTINVOICEDATA.getOperationCode());
		apmDetails.setMsgHeader(msgHeader);

		apmDetails = serviceClient.invokeService(OpCode.APMDETAILS.getOperationCode(), apmDetails, APMDetails.class);
		return apmDetails;
	}
}
