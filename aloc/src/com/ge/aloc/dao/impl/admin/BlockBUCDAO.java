/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: BusinessUnitCodeDAO.java
 * Purpose: 
 */
package com.ge.aloc.dao.impl.admin;

import com.ge.aloc.OpCode;
import com.ge.aloc.ServiceClientSupport;
import com.ge.aloc.dao.admin.IBlockBUCDAO;
import com.ge.aloc.model.BusinessUnitCode;
import com.ge.aloc.model.BusinessUnitCodeList;
import com.ge.aloc.model.MsgHeader;
import com.ge.aloc.util.ALOCCommonHelper;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author Rajat-Hydus
 *
 */
public class BlockBUCDAO extends ServiceClientSupport  implements IBlockBUCDAO{

	/**
	 * Method to get the list of already blocked BUC's
	 * @return BusinessUnitCodeList
	 * @throws HWFServiceException
	 */
	public BusinessUnitCodeList open() throws HWFServiceException {
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.GETBUCLIST.getOperationCode());
		BusinessUnitCode businessUnitCode = new BusinessUnitCode();
		businessUnitCode.setMsgHeader(msgHeader);
		return (BusinessUnitCodeList) serviceClient.invokeService(OpCode.BUCMANAGEMENT.getOperationCode(), businessUnitCode, BusinessUnitCodeList.class);
	}

	/**
	 * Method to search the BUC and get the associated ADN's 
	 * @param businessUnitCode
	 * @return BusinessUnitCodeList
	 * @throws HWFServiceException
	 */
	public BusinessUnitCodeList search(BusinessUnitCode businessUnitCode) throws HWFServiceException {
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.GETBUCDETAILS.getOperationCode());
		businessUnitCode.setMsgHeader(msgHeader);
		return (BusinessUnitCodeList) serviceClient.invokeService(OpCode.BUCMANAGEMENT.getOperationCode(), businessUnitCode, BusinessUnitCodeList.class);
	}

	/**
	 * Method to validate the BUC
	 * @param businessUnitCode
	 * @return BusinessUnitCode
	 * @throws HWFServiceException
	 */
	public BusinessUnitCode validateBUC(BusinessUnitCode businessUnitCode) throws HWFServiceException {
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.BUCINSERT.getOperationCode());
		businessUnitCode.setMsgHeader(msgHeader);
		businessUnitCode.setBUCOpcode(OpCode.SEARCH.getOperationCode());
		return (BusinessUnitCode)serviceClient.invokeService(OpCode.BUCMANAGEMENT.getOperationCode(), businessUnitCode, BusinessUnitCode.class);
	}

	/**
	 * Method to block the selected BUC and ADN combination
	 * @param businessUnitCode
	 * @return BusinessUnitCode
	 * @throws HWFServiceException
	 */
	public BusinessUnitCode blockBUC(BusinessUnitCode businessUnitCode)	throws HWFServiceException {
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.BUCINSERT.getOperationCode());
		businessUnitCode.setMsgHeader(msgHeader);
		return (BusinessUnitCode)serviceClient.invokeService(OpCode.BUCMANAGEMENT.getOperationCode(), businessUnitCode, BusinessUnitCode.class);
	}

	/**
	 * Method to unblock the selected BUC and ADN combination
	 * @param businessUnitCode
	 * @return BusinessUnitCode
	 * @throws HWFServiceException
	 */
	public BusinessUnitCode unBlockBUC(BusinessUnitCode businessUnitCode) throws HWFServiceException {
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.BUCUPDATE.getOperationCode());
		businessUnitCode.setMsgHeader(msgHeader);
		return (BusinessUnitCode) serviceClient.invokeService(OpCode.BUCMANAGEMENT.getOperationCode(), businessUnitCode, BusinessUnitCode.class);
	}
}
