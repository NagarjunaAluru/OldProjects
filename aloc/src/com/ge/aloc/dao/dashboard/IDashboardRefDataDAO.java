/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: IDashboardRefDataDAO.java
 * Purpose: IDashboardRefDataDAO used for dashboard ajax DAO declarations
 */
package com.ge.aloc.dao.dashboard;

import java.util.List;

import com.ge.aloc.ActionType;
import com.ge.aloc.model.ActionLog;
import com.ge.aloc.model.ReqContactInfo;
import com.ge.aloc.model.RequestDetails;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author arijit.biswas
 *
 */
public interface IDashboardRefDataDAO {
	/**
	 * Method to get the Action log details of selected request
	 * @param actionLog
	 * @return
	 * @throws HWFServiceException
	 */
	public List<ActionLog> getActionLog(ActionLog actionLog) throws HWFServiceException;

	/**
	 *  Method to get the request contact information for selected request
	 * @param reqContactInfo
	 * @return
	 * @throws HWFServiceException
	 */
	public ReqContactInfo getReqContactInfo(ReqContactInfo reqContactInfo) throws HWFServiceException;

	/**
	 * Method to get the treasury bid process request contact information for selected request
	 * @param reqContactInfo
	 * @return
	 * @throws HWFServiceException
	 */
	public ReqContactInfo getTreasuryBidRequestContactInfo(ReqContactInfo reqContactInfo) throws HWFServiceException;


	/**
	 * This is used to get requests for a selected bundle
	 * @param bundleId
	 * @return
	 * @throws HWFServiceException
	 */
	public List<RequestDetails> getRequestsForSelBundle(String bundleId) throws HWFServiceException;

	/**
	 *  Method to delete selected request from Dashboard
	 * @param requestDetails
	 * @return
	 * @throws HWFServiceException
	 */
	public RequestDetails deleteRequest(RequestDetails requestDetails) throws HWFServiceException;
	
	/**
	 *  Method to delete selected request from Dashboard
	 * @param requestDetails
	 * @return
	 * @throws HWFServiceException
	 */
	public RequestDetails deleteAmendmentORRiderRequest(RequestDetails requestDetails, ActionType actionType) throws HWFServiceException;
}
