/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: IReimbursementAgreementMgmtManager.java
 * Purpose: IReimbursementAgreementMgmtManager used for Reimebursement Agreement Management operations.
 */
package com.ge.aloc.manager.admin;

import com.ge.aloc.model.Reimbursement;
import com.hydus.hwf.exceptions.HWFServiceException;


/**
 * @author rajeswari.guthi
 *
 */
public interface IReimbursementAgreementMgmtManager {

	/**
	 *  This is used to get add or update the reimbursement agreement
	 * @param reimbursement
	 * @return
	 * @throws HWFServiceException
	 */
	public Reimbursement createOrUpdateReimbursementAgreement(Reimbursement reimbursement)throws HWFServiceException;

	/**
	 * This is used to get list of reimbursement agreement available 
	 * @param reimbursement
	 * @return
	 * @throws HWFServiceException
	 */
	public Reimbursement loadReimbursementAgreementList(Reimbursement reimbursement)throws HWFServiceException;


	/**
	 * This is used to get details of selected reimbursement agreement  
	 * @param reimbursement
	 * @return
	 * @throws HWFServiceException
	 */
	public Reimbursement loadReimbursementAgreementDetailsById(Reimbursement reimbursement)throws HWFServiceException;


}
