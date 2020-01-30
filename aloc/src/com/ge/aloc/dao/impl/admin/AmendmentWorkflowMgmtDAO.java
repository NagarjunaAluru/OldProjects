/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: AmendmentWorkflowMgmtDAO.java
 * Purpose: AmendmentWorkflowMgmtDAO used for add or update amendment amount.
 *
 */
package com.ge.aloc.dao.impl.admin;

import com.ge.aloc.OpCode;
import com.ge.aloc.ServiceClientSupport;
import com.ge.aloc.dao.admin.IAmendmentWorkflowMgmtDAO;
import com.ge.aloc.model.AmendmentWorkflowMgmt;
import com.ge.aloc.model.MsgHeader;
import com.ge.aloc.util.ALOCCommonHelper;
import com.hydus.hwf.exceptions.HWFServiceException;
/**
 * @author madhusudhan.gosula
 *
 */
public class AmendmentWorkflowMgmtDAO extends ServiceClientSupport implements IAmendmentWorkflowMgmtDAO {

	/**
	 * This method is used to fetch the amendment amount
	 * @param amendmentWorkflow
	 */
	public AmendmentWorkflowMgmt open(AmendmentWorkflowMgmt amendmentWorkflow) throws HWFServiceException {
		amendmentWorkflow = (AmendmentWorkflowMgmt) serviceClient.invokeService(OpCode.AMDWORKFLOW.getOperationCode(), amendmentWorkflow, AmendmentWorkflowMgmt.class);
		return amendmentWorkflow;
	}

	/**
	 * Method to add or update the amendment amount
	 * @param amendmentWorkflow
	 * @return
	 * @throws HWFServiceException
	 */
	public AmendmentWorkflowMgmt save(AmendmentWorkflowMgmt amendmentWorkflow)
			throws HWFServiceException {
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.SAVE.getOperationCode());
		amendmentWorkflow.setMsgHeader(msgHeader);
		return (AmendmentWorkflowMgmt) serviceClient.invokeService(OpCode.AMDWORKFLOW.getOperationCode(), amendmentWorkflow, AmendmentWorkflowMgmt.class);
	}

}
