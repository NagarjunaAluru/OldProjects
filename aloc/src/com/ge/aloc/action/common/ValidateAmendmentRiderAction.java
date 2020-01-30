/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ValidateAmendmentRiderAction.java
 * Purpose: ValidateAmendmentRiderAction used for validate Amendment and Rider in Landing Page
 */
package com.ge.aloc.action.common;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.manager.common.IValidateAmendmentRiderManager;
import com.ge.aloc.model.RequestStatusDetails;
import com.ge.aloc.util.JSONHelper;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.hydus.hwf.exceptions.HWFServiceException;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author arijit.biswas
 *
 */
public class ValidateAmendmentRiderAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private IValidateAmendmentRiderManager validateAmendmentRiderManager;
	private RequestStatusDetails requestStatusDetails;
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response = ServletActionContext.getResponse();

	/**
	 * This method is used to validate to create the amendment or rider request from the landing page.
	 * @return
	 * @throws HWFServiceException
	 */
	public String execute() throws IOException {
		String amendRiderOption = request.getParameter(ALOCConstants.AMENDRIDEROPTION);
		String amendRiderValue = request.getParameter(ALOCConstants.AMENDRIDERVALUE);
		amendRiderValue = (amendRiderValue != null) ? amendRiderValue.trim() : ALOCConstants.EMPTY_STRING;
		JsonObject result = new JsonObject();
		JsonArray respnseData = new JsonArray();
		JsonObject amendmentRiderStatus = new JsonObject();
		try {
			requestStatusDetails = validateAmendmentRiderManager.validate(amendRiderOption, amendRiderValue);
			amendmentRiderStatus.addProperty(ALOCConstants.ALOCRECORDNO, requestStatusDetails.getALOCRecordNumber());
			amendmentRiderStatus.addProperty(ALOCConstants.INSTRUMENTTYPE, requestStatusDetails.getInstrumentType());
			amendmentRiderStatus.addProperty(ALOCConstants.INSTRUMENTTYPEID, requestStatusDetails.getInstrumentTypeId());
			amendmentRiderStatus.addProperty(ALOCConstants.WFSTAGE, requestStatusDetails.getWFStage());
			amendmentRiderStatus.addProperty(ALOCConstants.WFSTAGEID, requestStatusDetails.getWFStageId());
			respnseData.add(amendmentRiderStatus);
			result.add(ALOCConstants.RESULT, respnseData);
			JSONHelper.writeResponse(result, response);
		} catch (HWFServiceException hse) {
			response.setStatus(HttpServletResponse. SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write(hse.getLocalizedMessage());
		}
		return null;

	}

	/**
	 * This is used to create the validateAmendmentRiderManager instance object.
	 * @return the validateAmendmentRiderManager
	 */
	public IValidateAmendmentRiderManager getValidateAmendmentRiderManager() {
		return validateAmendmentRiderManager;
	}

	/**
	 * This is used to create the validateAmendmentRiderManager instance object.
	 * @param validateAmendmentRiderManager the validateAmendmentRiderManager to set
	 */
	public void setValidateAmendmentRiderManager(
			IValidateAmendmentRiderManager validateAmendmentRiderManager) {
		this.validateAmendmentRiderManager = validateAmendmentRiderManager;
	}

	/**
	 * This is used to get the requestStatusDetails object.
	 * @return the requestStatusDetails
	 */
	public RequestStatusDetails getRequestStatusDetails() {
		return requestStatusDetails;
	}

	/**
	 * This is used to set the requestStatusDetails object.
	 * @param requestStatusDetails the requestStatusDetails to set
	 */
	public void setRequestStatusDetails(RequestStatusDetails requestStatusDetails) {
		this.requestStatusDetails = requestStatusDetails;
	}
}
