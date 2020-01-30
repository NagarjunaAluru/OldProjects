/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ValidateCloseTransactionAction.java
 * Purpose: ValidateCloseTransactionAction used for validate closed requests in Landing Page
 */
package com.ge.aloc.action.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.manager.common.IValidateCloseTransactionManager;
import com.ge.aloc.model.RequestDetails;
import com.ge.aloc.util.JSONHelper;
import com.google.gson.JsonObject;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author arijit.biswas
 *
 */
public class ValidateCloseTransactionAction {

	private IValidateCloseTransactionManager validateCloseTransactionManager;
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response = ServletActionContext.getResponse();

	/**
	 * This method is used to validate Close Transaction from the landing page.
	 * @return
	 * @throws HWFServiceException
	 */
	public String execute() throws HWFServiceException {
		String closeTransOption = request.getParameter(ALOCConstants.CLOSETRANSOPTION);
		String closeTransValue = request.getParameter(ALOCConstants.CLOSETRANSVALUE);
		closeTransValue = (closeTransValue != null) ? closeTransValue.trim() : ALOCConstants.EMPTY_STRING;
		RequestDetails requestDetails = validateCloseTransactionManager.validate(closeTransOption, closeTransValue);

		if(requestDetails.getRequestId()!= null){
			JsonObject result = new JsonObject();
			JsonObject closeTransDtls = new JsonObject();
			closeTransDtls.addProperty(ALOCConstants.ALOCRECORDNO, requestDetails.getRequestId());
			closeTransDtls.addProperty(ALOCConstants.INSTRUMENTTYPEID, requestDetails.getInstrumentTypeId());
			closeTransDtls.addProperty(ALOCConstants.WFSTAGE, requestDetails.getWFDetails().getWFStage());
			closeTransDtls.addProperty(ALOCConstants.WFID, requestDetails.getWFDetails().getWFID());
			closeTransDtls.addProperty(ALOCConstants.QUEUENAME, requestDetails.getWFDetails().getQueueName());
			closeTransDtls.addProperty(ALOCConstants.PROCEDURENAME, requestDetails.getWFDetails().getProcedureName());
			result.add(ALOCConstants.RESULT, closeTransDtls);
			JSONHelper.writeResponse(result, response);
		}

		return null;
	}

	/**
	 * This is used to create the validateCloseTransactionManager instance object.
	 * @return the validateCloseTransactionManager
	 */
	public IValidateCloseTransactionManager getValidateCloseTransactionManager() {
		return validateCloseTransactionManager;
	}

	/**
	 * This is used to create the validateCloseTransactionManager instance object.
	 * @param validateCloseTransactionManager the validateCloseTransactionManager to set
	 */
	public void setValidateCloseTransactionManager(
			IValidateCloseTransactionManager validateCloseTransactionManager) {
		this.validateCloseTransactionManager = validateCloseTransactionManager;
	}


}
