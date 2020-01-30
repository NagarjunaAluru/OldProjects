/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: AuditSearchAction.java
 * Purpose: AuditSearchAction used for search audit and action log 
 */
package com.ge.aloc.action.request;

import org.apache.commons.lang.StringUtils;

import com.ge.aloc.ALOCContext;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.exception.ALOCAttachmentException;
import com.ge.aloc.exception.ALOCException;
import com.ge.aloc.model.ActionDrawDownValues;
import com.ge.aloc.model.DrawDownValues;
import com.ge.aloc.model.RequestDetails;
import com.ge.aloc.util.ALOCCommonHelper;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author Bhuvaneswari.a
 *
 */
public class AuditSearchAction extends RequestDetailsSupportAction {


	private static final long serialVersionUID = 1L;

	protected String fromDate;
	protected String toDate;
	protected String searchCriteriaValue;
	protected String searchCriteriaText;

	@Override
	public String submit() throws HWFServiceException, ALOCAttachmentException,
	ALOCException {
		return null;
	}

	/**
	 * method to search the auditLog 
	 * @return
	 * @throws HWFServiceException 
	 * @throws java.text.ParseException  
	 */
	public String auditandActionSearch() throws HWFServiceException, java.text.ParseException {
		RequestDetails requestDetails=new RequestDetails();
		if(StringUtils.isNotEmpty(getLogType())){
			if(getLogType().equalsIgnoreCase(ALOCConstants.ACTION)){
				requestDetails=ALOCCommonHelper.actionLogSearchCriteria(fromDate,toDate,searchCriteriaValue,searchCriteriaText);
			}else{
				requestDetails=ALOCCommonHelper.auditLogSearchCriteria(fromDate,toDate,searchCriteriaValue,searchCriteriaText);
			}
		}
		requestDetails = requestDetailsSectionManager.getFullAuditandActionLog(getStageName(),getLogType(),getRequestId(),requestDetails);
		if(logType.equalsIgnoreCase(ALOCConstants.ACTION)){
			if(requestDetails.getActionLogs()!=null){
				ALOCContext.getActiveRequest().getModel().setActionLogs(requestDetails.getActionLogs());
			}
			if(requestDetails.getActionDrawDownValues()!=null){
				ActionDrawDownValues drawDownValues=new ActionDrawDownValues();
				if(requestDetails.getActionDrawDownValues().getActions()!=null){
					drawDownValues.setActions(requestDetails.getActionDrawDownValues().getActions());
				}
				if(requestDetails.getActionDrawDownValues().getActionTakenBies()!=null){
					drawDownValues.setActionTakenBies(requestDetails.getActionDrawDownValues().getActionTakenBies());
				}
				ALOCContext.getActiveRequest().getModel().setActionDrawDownValues(drawDownValues);
			}
			return ALOCConstants.ACTION;
		}
		else{
			if(requestDetails.getAuditLogs()!=null){
				ALOCContext.getActiveRequest().getModel().setAuditLogs(requestDetails.getAuditLogs());
			}
			if(requestDetails.getDrawDownValues()!=null){
				DrawDownValues drawDownvalues=new DrawDownValues();
				if(requestDetails.getDrawDownValues().getActionTakenBies()!=null){
					drawDownvalues.setActionTakenBies(requestDetails.getDrawDownValues().getActionTakenBies());
				}
				if(requestDetails.getDrawDownValues().getAttributeChangeds()!=null){
					drawDownvalues.setAttributeChangeds(requestDetails.getDrawDownValues().getAttributeChangeds());
				}
				ALOCContext.getActiveRequest().getModel().setDrawDownValues(drawDownvalues);
			}
			return ALOCConstants.AUDIT;
		}

	}

	/**
	 * This method is used to get the fromDate
	 * @return the fromDate
	 */
	public String getFromDate() {
		return fromDate;
	}

	/**
	 * This method is used to set the fromDate
	 * @param fromdate the fromDate to set
	 */
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	/**This method is used to get the toDate
	 * @return the toDate
	 */
	public String getToDate() {
		return toDate;
	}

	/**
	 * This method is used to set the toDate
	 * @param todate the toDate to set
	 */
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	/**
	 * @return the searchCriteriaValue
	 */
	public String getSearchCriteriaValue() {
		return searchCriteriaValue;
	}

	/**
	 * @param searchCriteriaValue the searchCriteriaValue to set
	 */
	public void setSearchCriteriaValue(String searchCriteriaValue) {
		this.searchCriteriaValue = searchCriteriaValue;
	}


	/**
	 * This method is used to get search searchCriteriaText.
	 * @return the searchCriteriaText
	 */
	public String getSearchCriteriaText() {
		return searchCriteriaText;
	}

	/**
	 * This method is used to set searchCriteriaText.
	 * @param searchCriteriaText the searchCriteriaText to set
	 */
	public void setSearchCriteriaText(String searchCriteriaText) {
		this.searchCriteriaText = searchCriteriaText;
	}

}
