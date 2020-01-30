/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: IValidateCloseTransactionManager.java
 * Purpose: IValidateCloseTransactionManager used for validate closed requests in Landing Page
 */

package com.ge.aloc.manager.common;

import com.ge.aloc.model.RequestDetails;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author arijit.biswas
 *
 */
public interface IValidateCloseTransactionManager {

	/**
	 * This method is used to validate Close Transaction from the landing page.
	 * @param closeTransOption
	 * @param closeTransValue
	 * @throws HWFServiceException 
	 */
	public RequestDetails validate(String closeTransOption,String closeTransValue) throws HWFServiceException;
}
