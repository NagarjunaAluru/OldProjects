/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: IAmendmentWorkflowMgmtDAO.java
 * Purpose: IAmendmentWorkflowMgmtDAO used for maintaining amendment amount.
 *
 */
package com.ge.aloc.dao.admin;

import com.ge.aloc.IServiceClientAware;
import com.ge.aloc.model.AmendmentWorkflowMgmt;
import com.hydus.hwf.exceptions.HWFServiceException;
/**
 * @author madhusudhan.gosula
 *
 */
public interface IAmendmentWorkflowMgmtDAO extends IServiceClientAware {

	/**
	 * Method to get the available Amendment amount
	 * @return
	 * @throws HWFServiceException
	 */
	public AmendmentWorkflowMgmt open(AmendmentWorkflowMgmt amendmentWorkflowMgmt) throws HWFServiceException;

	/**
	 * Method to add or update the amendment amount
	 * @param amendmentWorkflowMgmt
	 * @return
	 * @throws HWFServiceException
	 */
	public AmendmentWorkflowMgmt save(AmendmentWorkflowMgmt amendmentWorkflowMgmt) throws HWFServiceException;

}
