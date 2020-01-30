/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: IValidateCloseTransactionDAO.java
 * Purpose: IValidateCloseTransactionDAO used for validate closed requests in Landing Page
 */
package com.ge.aloc.dao.common;

import com.ge.aloc.model.LandingPageDtls;
import com.ge.aloc.model.RequestDetails;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author arijit.biswas
 *
 */
public interface IValidateCloseTransactionDAO {

	/**
	 * This method is used to invoke validate Close Transaction Service.
	 * @param landingPageDetails
	 * @throws HWFServiceException 
	 */
	public RequestDetails validate(LandingPageDtls landingPageDetails) throws HWFServiceException;
}
