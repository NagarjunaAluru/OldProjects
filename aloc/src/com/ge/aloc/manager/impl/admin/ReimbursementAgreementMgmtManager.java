/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ReimbursementAgreementMgmtManager.java
 * Purpose: ReimbursementAgreementMgmtManager used for Reimbursement Agreement  Management operations.
 */
package com.ge.aloc.manager.impl.admin;

import com.ge.aloc.dao.admin.IReimbursementAgreementMgmtDAO;
import com.ge.aloc.manager.admin.IReimbursementAgreementMgmtManager;
import com.ge.aloc.model.Reimbursement;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 *  @author rajeswari.guthi
 *  
 *  
 */
public class ReimbursementAgreementMgmtManager implements IReimbursementAgreementMgmtManager{

	private IReimbursementAgreementMgmtDAO reimbursementAgreementMgmtDAO;

	/**
	 *  This is used to get add or update the reimbursement agreement
	 * @param reimbursement
	 * @return
	 * @throws HWFServiceException
	 */
	public Reimbursement createOrUpdateReimbursementAgreement(
			Reimbursement reimbursement)
					throws HWFServiceException {
		return reimbursementAgreementMgmtDAO.createOrUpdateReimbursementAgreement(reimbursement);
	}


	/**
	 * This is used to get list of reimbursement agreement available 
	 * @param reimbursement
	 * @return
	 * @throws HWFServiceException
	 */
	public Reimbursement loadReimbursementAgreementList(
			Reimbursement reimbursement) throws HWFServiceException {
		return reimbursementAgreementMgmtDAO.loadReimbursementAgreementList(reimbursement);
	}


	/**
	 * This is used to get details of selected reimbursement agreement  
	 * @param reimbursement
	 * @return
	 * @throws HWFServiceException
	 */
	public Reimbursement loadReimbursementAgreementDetailsById(
			Reimbursement reimbursement) throws HWFServiceException {
		return reimbursementAgreementMgmtDAO.loadReimbursementAgreementDetailsById(reimbursement);
	}



	/**
	 * This is used to set the DAO service for reimbursement agreement
	 * @return the reimbursementAgreementMgmtDAO
	 */
	public IReimbursementAgreementMgmtDAO getReimbursementAgreementMgmtDAO() {
		return reimbursementAgreementMgmtDAO;
	}

	/**
	 * This is used to get DAO service for reimbursement agreement
	 * @param reimbursementAgreementMgmtDAO the reimbursementAgreementMgmtDAO to set
	 */
	public void setReimbursementAgreementMgmtDAO(
			IReimbursementAgreementMgmtDAO reimbursementAgreementMgmtDAO) {
		this.reimbursementAgreementMgmtDAO = reimbursementAgreementMgmtDAO;
	}

}
