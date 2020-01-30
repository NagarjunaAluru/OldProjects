/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ValidateCloseTransactionManager.java
 * Purpose: ValidateCloseTransactionManager used for validate closed requests in Landing Page
 */
package com.ge.aloc.manager.impl.common;

import com.ge.aloc.CloseTransactionOptionEnum;
import com.ge.aloc.dao.common.IValidateCloseTransactionDAO;
import com.ge.aloc.manager.common.IValidateCloseTransactionManager;
import com.ge.aloc.model.LandingPageDtls;
import com.ge.aloc.model.RequestDetails;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author arijit.biswas
 *
 */
public class ValidateCloseTransactionManager implements
IValidateCloseTransactionManager {
	private IValidateCloseTransactionDAO validateCloseTransactionDAO;

	/**
	 * @see com.ge.aloc.manager.common.IValidateCloseTransactionManager#validate(String, String)
	 */
	public RequestDetails validate(String closeTransOption, String closeTransValue) throws HWFServiceException {
		LandingPageDtls landingPageDtls = new LandingPageDtls();
		switch(CloseTransactionOptionEnum.fromName(closeTransOption)){
		case ALOCRECNO:
			landingPageDtls.setAlocRecordId(closeTransValue);
			break;
		case ISSUERREFERENCENUMBER:
		case BANKREFERENCENUMBER:
		case BONDREFERENCENUMBER:
			landingPageDtls.setIssuerRefNum(closeTransValue);
			break;
		}

		return validateCloseTransactionDAO.validate(landingPageDtls);
	}

	/**
	 * This is used to create the validateCloseTransactionDAO instance object.
	 * @return the validateCloseTransactionDAO
	 */
	public IValidateCloseTransactionDAO getValidateCloseTransactionDAO() {
		return validateCloseTransactionDAO;
	}

	/**
	 * This is used to create the validateCloseTransactionDAO instance object.
	 * @param validateCloseTransactionDAO the validateCloseTransactionDAO to set
	 */
	public void setValidateCloseTransactionDAO(
			IValidateCloseTransactionDAO validateCloseTransactionDAO) {
		this.validateCloseTransactionDAO = validateCloseTransactionDAO;
	}


}
