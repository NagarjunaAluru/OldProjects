/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: IDashboardRefManager.java
 * Purpose: IDashboardRefManager used for dashboard the ajax operations
 */
package com.ge.aloc.manager.dashboard;

import java.math.BigDecimal;
import java.util.List;

import com.ge.aloc.model.ActionLog;
import com.ge.aloc.model.ReqContactInfo;
import com.ge.aloc.model.RequestDetails;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author arijit.biswas
 *
 */
public interface IDashboardRefDataManager {
	/**
	 * Method to get the Action log details of selected request
	 * @param requestId
	 * @param alocRecordNo
	 * @param instrumentTypeId
	 * @return
	 * @throws HWFServiceException
	 */
	public List<ActionLog> getActionLog(String requestId,String alocRecordNo,String instrumentTypeId) throws HWFServiceException;

	/**
	 * Method to get the request contact information for selected request
	 * @param requestId
	 * @param instrumentTypeId
	 * @param amendmentId
	 * @return
	 * @throws HWFServiceException
	 */
	public ReqContactInfo getReqContactInfo(String requestId,String instrumentTypeId,String amendmentId,String bidFlag,BigDecimal  bidReplyId) throws HWFServiceException;

	/**
	 * Method to get the treasury bid process request contact information for selected request
	 * @param requestId
	 * @return
	 * @throws HWFServiceException
	 */
	public ReqContactInfo getTreasuryBidRequestContactInfo(String requestId) throws HWFServiceException;

	/**
	 * This Method is used to get the request details for selected bundle or request Id
	 * @param bundleId
	 * @param requestId
	 * @param instrumentTypeId
	 * @return
	 * @throws HWFServiceException
	 */
	public List<RequestDetails> selectWinnerRequests(String bundleId,String requestId,String instrumentTypeId) throws HWFServiceException;

	/**
	 * Method to delete selected request from Dashboard
	 * @param requestId
	 * @param wfid
	 * @param stageName
	 * @param queueName
	 * @param procedureName
	 * @param workFlowstageId
	 * @throws HWFServiceException
	 */
	public RequestDetails deleteRequest(String requestId,String wfid, String stageName, String queueName,
			String procedureName,String workFlowstageId,String amendmentId, String instrumentTypeId, String reasonForDelete) throws HWFServiceException;
}
