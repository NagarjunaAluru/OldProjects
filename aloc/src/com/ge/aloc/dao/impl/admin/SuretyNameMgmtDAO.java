/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: SuretyNameMgmtDAO.java
 * Purpose: SuretyNameMgmtDAO used for add or update Surety Names.
 *
 */
package com.ge.aloc.dao.impl.admin;

import com.ge.aloc.OpCode;
import com.ge.aloc.ServiceClientSupport;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.dao.admin.ISuretyNameMgmtDAO;
import com.ge.aloc.model.MsgHeader;
import com.ge.aloc.model.SuretyMaster;
import com.ge.aloc.model.SuretyMasterCollection;
import com.ge.aloc.util.ALOCCommonHelper;
import com.hydus.hwf.exceptions.HWFServiceException;
/**
 * @author Rajat-Hydus
 *
 */
public class SuretyNameMgmtDAO extends ServiceClientSupport implements ISuretyNameMgmtDAO {

	/**
	 * This method is used to fetch the list of Surety Names
	 * @param suretyMaster
	 */
	public SuretyMasterCollection open(SuretyMaster suretyMaster) throws HWFServiceException {
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.INITIATESURETY.getOperationCode());
		suretyMaster.setMsgHeader(msgHeader);
		SuretyMasterCollection suretyList = (SuretyMasterCollection) serviceClient.invokeService(OpCode.INITIATESURETY.getOperationCode(), suretyMaster, SuretyMasterCollection.class);
		return suretyList;
	}

	/**
	 * Method to add or update given SuretyCompany Name
	 * @param suretyMaster
	 * @return
	 * @throws HWFServiceException
	 */
	public SuretyMaster update(SuretyMaster suretyMaster)
			throws HWFServiceException {
		if(suretyMaster.getSuretyId()!=null && suretyMaster.getSuretyId().toString() != ALOCConstants.EMPTY_STRING)
		{
			suretyMaster.setOpCode(ALOCConstants.UPDATESURETY);
		}
		else
		{
			suretyMaster.setOpCode(ALOCConstants.INSURTSURETY);
		}
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.UPDATESURETY.getOperationCode());
		suretyMaster.setMsgHeader(msgHeader);
		return (SuretyMaster) serviceClient.invokeService(OpCode.UPDATESURETY.getOperationCode(), suretyMaster, SuretyMaster.class);
	}
}
