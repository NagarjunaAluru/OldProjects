/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ValidateAmendmentRiderManager.java
 * Purpose: ValidateAmendmentRiderManager used for validate Amendment and Rider in Landing Page
 */
package com.ge.aloc.manager.impl.common;

import com.ge.aloc.OpCode;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.dao.common.IValidateAmendmentRiderDAO;
import com.ge.aloc.manager.common.IValidateAmendmentRiderManager;
import com.ge.aloc.model.GetAmendmentRiders;
import com.ge.aloc.model.RequestStatusDetails;
import com.ge.aloc.util.ALOCCommonHelper;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author arijit.biswas
 *
 */
public class ValidateAmendmentRiderManager implements IValidateAmendmentRiderManager {
	private IValidateAmendmentRiderDAO validateAmendmentRiderDAO;

	/**
	 * @see com.ge.aloc.manager.common.IValidateAmendmentRiderManager#validate(String, String)
	 */
	public RequestStatusDetails validate(String amendRiderOption, String amendRiderValue) throws HWFServiceException {
		GetAmendmentRiders getAmendmentRiders = new GetAmendmentRiders();
		RequestStatusDetails requestStatusDetails = new RequestStatusDetails();
		if(amendRiderOption.equals(ALOCConstants.ISSUERREFERENCENUMBER)){
			requestStatusDetails.setBankReferenceNumber(amendRiderValue);
		}else if(amendRiderOption.equals(ALOCConstants.ALOCRECNO)){
			requestStatusDetails.setALOCRecordId(amendRiderValue);
		}
		getAmendmentRiders.setRequestStatusDetails(requestStatusDetails);
		getAmendmentRiders.setMsgHeader(ALOCCommonHelper.createMsgHeader(OpCode.GETREQUESTSTATUS.getOperationCode()));
		getAmendmentRiders = validateAmendmentRiderDAO.validate(getAmendmentRiders);
		return getAmendmentRiders.getRequestStatusDetails();
	}

	/**
	 * This is used to create the validateAmendmentRiderDAO instance object.
	 * @return the validateAmendmentRiderDAO
	 */
	public IValidateAmendmentRiderDAO getValidateAmendmentRiderDAO() {
		return validateAmendmentRiderDAO;
	}

	/**
	 * This is used to create the validateAmendmentRiderDAO instance object.
	 * @param validateAmendmentRiderDAO the validateAmendmentRiderDAO to set
	 */
	public void setValidateAmendmentRiderDAO(IValidateAmendmentRiderDAO validateAmendmentRiderDAO) {
		this.validateAmendmentRiderDAO = validateAmendmentRiderDAO;
	}


}
