/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: IValidateAmendmentRiderManager.java
 * Purpose: IValidateAmendmentRiderManager used for validate Amendment and Rider in Landing Page
 */
package com.ge.aloc.manager.common;

import com.ge.aloc.model.RequestStatusDetails;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author arijit.biswas
 *
 */
public interface IValidateAmendmentRiderManager {
	/**
	 * This method is used to validate to create the amendment or rider request from the landing page.
	 * @param amendRiderOption
	 * @param amendRiderValue
	 * @return
	 * @throws HWFServiceException
	 */
	public RequestStatusDetails validate(String amendRiderOption, String amendRiderValue) throws HWFServiceException;
}
