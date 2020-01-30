/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ValidateCloseTransactionDAO.java
 * Purpose: ValidateCloseTransactionDAO used for validate closed requests in Landing Page
 */
package com.ge.aloc.dao.impl.common;

import com.ge.aloc.OpCode;
import com.ge.aloc.ServiceClientSupport;
import com.ge.aloc.dao.common.IValidateCloseTransactionDAO;
import com.ge.aloc.model.LandingPageDtls;
import com.ge.aloc.model.RequestDetails;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author arijit.biswas
 *
 */
public class ValidateCloseTransactionDAO extends ServiceClientSupport implements IValidateCloseTransactionDAO {

	/**
	 * @see com.ge.aloc.dao.common.IValidateCloseTransactionDAO#validate(LandingPageDtls)
	 */
	public RequestDetails validate(LandingPageDtls landingPageDetails) throws HWFServiceException {
		RequestDetails requestDetails=serviceClient.invokeService(OpCode.CLOSEDTRANSACTION.getOperationCode(), landingPageDetails, RequestDetails.class);
		return requestDetails;
	}

}
