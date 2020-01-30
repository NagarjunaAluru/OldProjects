/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: StandardFormatMgmtDAO.java
 * Purpose: StandardFormatMgmtDAO used for the all Standard Format Maanagement operations
 */
package com.ge.aloc.dao.impl.admin;

import com.ge.aloc.OpCode;
import com.ge.aloc.ServiceClientSupport;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.dao.admin.IStandardFormatMgmtDAO;
import com.ge.aloc.model.MsgHeader;
import com.ge.aloc.model.StandardFormatMaster;
import com.ge.aloc.util.ALOCCommonHelper;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author rajeswari.guthi
 *
 */
public class StandardFormatMgmtDAO extends ServiceClientSupport  implements IStandardFormatMgmtDAO {


	/**
	 * This is used to get the formt template details for the selected instrumenttype,instrument purpose,biond type and bond subtype. 
	 * @param standardFormatMaster
	 * @return
	 * @throws HWFServiceException
	 */
	public StandardFormatMaster getFormatMaster(StandardFormatMaster standardFormatMaster) throws HWFServiceException {
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.GETFORMATMASTER.getOperationCode());
		standardFormatMaster.setMsgHeader(msgHeader);	
		standardFormatMaster = serviceClient.invokeService(OpCode.GETFORMATMASTER.getOperationCode(), standardFormatMaster,StandardFormatMaster.class);
		return standardFormatMaster;		
	}

	/**
	 * This is used to get updated format template file for the selected formatAuditTrailId. 
	 * @param standardFormatMaster
	 * @return
	 * @throws HWFServiceException
	 */
	public StandardFormatMaster getUpdatedGeStandardFormatFile(StandardFormatMaster standardFormatMaster) throws HWFServiceException {
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.GETAUDIT.getOperationCode());
		standardFormatMaster.setOpCode(OpCode.GETAUDIT.getOperationCode());
		standardFormatMaster.setMsgHeader(msgHeader);	
		standardFormatMaster = serviceClient.invokeService(OpCode.GETFORMATMASTER.getOperationCode(), standardFormatMaster,StandardFormatMaster.class);
		return standardFormatMaster;
	}

	/**
	 * This is used to get add or update the formt template details for the selected instrumenttype,instrument purpose,biond type and bond subtype.
	 * @param standardFormatMaster
	 * @return
	 * @throws HWFServiceException
	 */
	public StandardFormatMaster manageStandardFormatMaster(StandardFormatMaster standardFormatMaster)
			throws HWFServiceException {
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.UPDATEFORMATMASTER.getOperationCode());
		standardFormatMaster.setMsgHeader(msgHeader);
		if(standardFormatMaster.getStandardFormatId()==null){
			standardFormatMaster.setStandardFormatName(ALOCConstants.STANDARDGEFORMAT);
			standardFormatMaster.setOpCode(OpCode.INSERT.getOperationCode());
		}else{
			standardFormatMaster.setOpCode(OpCode.UPDATE.getOperationCode());
		}
		standardFormatMaster = serviceClient.invokeService(OpCode.UPDATEFORMATMASTER.getOperationCode(), standardFormatMaster,StandardFormatMaster.class);
		return standardFormatMaster; 		
	}

}
