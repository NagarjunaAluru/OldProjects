/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: PoleNameMgmtDAO.java
 * Purpose: PoleNameMgmtDAO used for add or update Surety Names.
 *
 */
package com.ge.aloc.dao.impl.admin;

import com.ge.aloc.OpCode;
import com.ge.aloc.ServiceClientSupport;
import com.ge.aloc.dao.admin.IPoleNameMgmtDAO;
import com.ge.aloc.model.MsgHeader;
import com.ge.aloc.model.PoleNameList;
import com.ge.aloc.model.PoleNameManagement;
import com.ge.aloc.util.ALOCCommonHelper;
import com.hydus.hwf.exceptions.HWFServiceException;
/**
 * @author Rajat-Hydus
 *
 */
public class PoleNameMgmtDAO extends ServiceClientSupport implements IPoleNameMgmtDAO {

	/**
	 * This method is used to fetch the list of Pole Names
	 * @param poleNameMgmt
	 */
	public PoleNameList open(PoleNameManagement poleNameMgmt) throws HWFServiceException {
		return (PoleNameList) serviceClient.invokeService(OpCode.POLEMANAGEMENT.getOperationCode(), poleNameMgmt, PoleNameList.class);
	}

	/**
	 * This method is used to f=get list of countries
	 * @param poleNameMgmt
	 */
	public PoleNameList getCountries(PoleNameManagement poleNameMgmt)
			throws HWFServiceException {
		return (PoleNameList) serviceClient.invokeService(OpCode.POLEMANAGEMENT.getOperationCode(), poleNameMgmt, PoleNameList.class);
	}

	/**
	 * This method is used to insert the pole management record
	 * @param poleNameMgmt
	 * @return PoleNameList
	 * @throws HWFServiceException
	 */
	public PoleNameManagement insert(PoleNameManagement poleNameMgmt)
			throws HWFServiceException {
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.INSERT.getOperationCode());
		poleNameMgmt.setMsgHeader(msgHeader);
		return (PoleNameManagement) serviceClient.invokeService(OpCode.POLEMANAGEMENT.getOperationCode(), poleNameMgmt, PoleNameManagement.class);
	}

	/**
	 * This method is used to update the list of Pole Names
	 * @param poleNameMgmt
	 * @return PoleNameManagement
	 * @throws HWFServiceException
	 */
	public PoleNameManagement update(PoleNameManagement poleNameMgmt)
			throws HWFServiceException {
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.UPDATEPOLE.getOperationCode());
		poleNameMgmt.setMsgHeader(msgHeader);
		return (PoleNameManagement) serviceClient.invokeService(OpCode.POLEMANAGEMENT.getOperationCode(), poleNameMgmt, PoleNameManagement.class);
	}
}
