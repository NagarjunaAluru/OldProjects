/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: AmendmentWorkflowMgmtManager.java
 * Purpose: AmendmentWorkflowMgmtManager used to define and modify the amendment amount.
 */
package com.ge.aloc.manager.impl.admin;

import com.ge.aloc.dao.admin.IAmendmentWorkflowMgmtDAO;
import com.ge.aloc.manager.admin.IAmendmentWorkflowMgmtManager;
import com.ge.aloc.model.AmendmentWorkflowMgmt;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author madhusudhan.gosula
 *
 */
public class AmendmentWorkflowMgmtManager implements IAmendmentWorkflowMgmtManager{

	private IAmendmentWorkflowMgmtDAO amendmentWorkflowMgmtDAO;

	/**
	 * This method is used to fetch the amendment amount from DB
	 * @return amendmentWorkflow
	 */
	public AmendmentWorkflowMgmt open() throws HWFServiceException {
		AmendmentWorkflowMgmt amendmentWorkflow = new AmendmentWorkflowMgmt();
		amendmentWorkflow = amendmentWorkflowMgmtDAO.open(amendmentWorkflow);
		return amendmentWorkflow;
	}
	/**
	 * This method is used to save the amendment amount from DB
	 * @return amendmentWorkflow
	 */
	public AmendmentWorkflowMgmt save(AmendmentWorkflowMgmt amendmentWorkflow) throws HWFServiceException {
		amendmentWorkflow = amendmentWorkflowMgmtDAO.save(amendmentWorkflow);
		return amendmentWorkflow;
	}
	/**
	 * This method is used to get Amendment work flow management DAO
	 * @return the amendmentWorkflowMgmtDAO
	 */
	public IAmendmentWorkflowMgmtDAO getAmendmentWorkflowMgmtDAO() {
		return amendmentWorkflowMgmtDAO;
	}
	/**
	 * This method is used to set Amendment work flow management DAO
	 * @param amendmentWorkflowMgmtDAO the amendmentWorkflowMgmtDAO to set
	 */
	public void setAmendmentWorkflowMgmtDAO(
			IAmendmentWorkflowMgmtDAO amendmentWorkflowMgmtDAO) {
		this.amendmentWorkflowMgmtDAO = amendmentWorkflowMgmtDAO;
	}

}
