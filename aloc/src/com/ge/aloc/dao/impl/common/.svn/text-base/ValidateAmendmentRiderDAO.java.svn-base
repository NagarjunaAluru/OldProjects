/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ValidateAmendmentRiderDAO.java
 * Purpose: ValidateAmendmentRiderDAO used for validate Amendment and Rider in Landing Page
 */
package com.ge.aloc.dao.impl.common;

import com.ge.aloc.OpCode;
import com.ge.aloc.ServiceClientSupport;
import com.ge.aloc.dao.common.IValidateAmendmentRiderDAO;
import com.ge.aloc.model.GetAmendmentRiders;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author arijit.biswas
 *
 */
public class ValidateAmendmentRiderDAO extends ServiceClientSupport implements IValidateAmendmentRiderDAO {

	/**
	 * @see com.ge.aloc.dao.common.IValidateAmendmentRiderDAO#validate(GetAmendmentRiders)
	 */
	public GetAmendmentRiders validate(GetAmendmentRiders getAmendmentRiders) throws HWFServiceException {
		getAmendmentRiders = serviceClient.invokeService(OpCode.AMENDMENTRIDERDETAILS.getOperationCode(), getAmendmentRiders, GetAmendmentRiders.class);
		return getAmendmentRiders;
	}


}
