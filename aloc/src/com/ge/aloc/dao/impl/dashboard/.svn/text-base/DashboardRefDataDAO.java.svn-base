/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: DashboardRefDataDAO.java
 * Purpose: DashboardRefDataDAO used for dashboard ajax DAO operation
 */
package com.ge.aloc.dao.impl.dashboard;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.ge.aloc.ActionType;
import com.ge.aloc.OpCode;
import com.ge.aloc.ServiceClientSupport;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.dao.dashboard.IDashboardRefDataDAO;
import com.ge.aloc.model.ActionLog;
import com.ge.aloc.model.BundleDetails;
import com.ge.aloc.model.Inbox;
import com.ge.aloc.model.MsgHeader;
import com.ge.aloc.model.ReqContactInfo;
import com.ge.aloc.model.RequestDetails;
import com.ge.aloc.model.RequestDetailsCollectionType;
import com.ge.aloc.util.ALOCCommonHelper;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author arijit.biswas
 *
 */
public class DashboardRefDataDAO extends ServiceClientSupport implements IDashboardRefDataDAO {

	/**
	 * Method to get the Action log details of selected request
	 * @param actionLog
	 * @return
	 * @throws HWFServiceException
	 */
	public List<ActionLog> getActionLog(ActionLog actionLog) throws HWFServiceException {
		RequestDetails requestDetail = new RequestDetails();
		MsgHeader msgHeader =  ALOCCommonHelper.createMsgHeader(null);
		actionLog.setMsgHeader(msgHeader);
		requestDetail = serviceClient.invokeService(OpCode.ACTIONLOG.getOperationCode(), actionLog, RequestDetails.class);

		return requestDetail.getActionLogs();
	}

	/**
	 *  Method to get the request contact information for selected request
	 * @param reqContactInfo
	 * @return
	 * @throws HWFServiceException
	 */
	public ReqContactInfo getReqContactInfo(ReqContactInfo reqContactInfo) throws HWFServiceException {
		reqContactInfo = serviceClient.invokeService(OpCode.REQCONTACTDTLS.getOperationCode(), reqContactInfo, ReqContactInfo.class);
		return reqContactInfo;
	}

	/**
	 * Method to get the treasury bid process request contact information for selected request
	 * @param reqContactInfo
	 * @return
	 * @throws HWFServiceException
	 */
	public ReqContactInfo getTreasuryBidRequestContactInfo(ReqContactInfo reqContactInfo) throws HWFServiceException {
		MsgHeader msgHeader =  ALOCCommonHelper.createMsgHeader(OpCode.REQCONTACTBIDDTLS.getOperationCode());
		reqContactInfo.setMsgHeader(msgHeader);
		reqContactInfo = serviceClient.invokeService(OpCode.REQCONTACTDTLS.getOperationCode(), reqContactInfo, ReqContactInfo.class);
		return reqContactInfo;
	}

	/**
	 * This is used to get requests for a selected bundle
	 * @param bundleId
	 * @return
	 * @throws HWFServiceException
	 */
	public List<RequestDetails> getRequestsForSelBundle(String bundleId)
			throws HWFServiceException {
		Inbox inboxResult = new Inbox();
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.GETBUNDLEREQ.getOperationCode());		  
		inboxResult = addDetailsToBundle(inboxResult, msgHeader, bundleId);
		inboxResult = (Inbox)serviceClient.invokeService(OpCode.INBOX.getOperationCode(), inboxResult, Inbox.class);
		List<RequestDetails> requestDetailsList = inboxResult.getBundle().getRequestDetails();
		return requestDetailsList;
	}

	/**
	 * This is utility to set the data for the bundle
	 * @param inboxResult
	 * @param requestId
	 * @param bundleId
	 * @return
	 */
	protected Inbox addDetailsToBundle(Inbox inboxResult,MsgHeader msgHeader,String bundleId) {
		BundleDetails bundleDetails = new BundleDetails();
		List<RequestDetails> requestDetList = new ArrayList<RequestDetails>();
		RequestDetails requestDetails = new RequestDetails();		
		requestDetails.setMsgHeader(msgHeader);  
		if(bundleId != null && bundleId.length() > ALOCConstants.BASE_VALUE){
			bundleDetails.setBundleId(new BigInteger(bundleId));
		}
		requestDetails.setBundleDetails(bundleDetails);
		requestDetList.add(requestDetails);
		RequestDetailsCollectionType requestCollection = new RequestDetailsCollectionType();
		requestCollection.setRequestDetails(requestDetList);
		inboxResult.setBundle(requestCollection);		
		inboxResult.setMsgHeader(msgHeader);
		return inboxResult;		
	}

	/**
	 *  Method to delete selected request from Dashboard
	 * @param requestDetails
	 * @return
	 * @throws HWFServiceException
	 */
	public RequestDetails deleteRequest(RequestDetails requestDetails) throws HWFServiceException{
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.DELETEREQ.getOperationCode());
		requestDetails.setMsgHeader(msgHeader);
		requestDetails=serviceClient.invokeService(OpCode.REQUESTDETAILS.getOperationCode(),requestDetails,RequestDetails.class);
		return requestDetails;	
	}

	/**
	 *  Method to delete selected Amendment or Rider request from Dashboard
	 * @param requestDetails
	 * @return
	 * @throws HWFServiceException
	 */
	public RequestDetails deleteAmendmentORRiderRequest(RequestDetails requestDetails, ActionType actionType)
			throws HWFServiceException {
		if(requestDetails.getWFDetails().getWFStageID().intValue() > 1) {
			ALOCCommonHelper.setMsgHeader(requestDetails, OpCode.APPROVE);
			requestDetails = serviceClient.invokeService(OpCode.APPROVE.getOperationCode(), requestDetails,	RequestDetails.class);
		} else if(requestDetails.getWFDetails().getWFStageID().intValue() == 1) {
			ALOCCommonHelper.setMsgHeader(requestDetails, OpCode.DELETEAMDMENT);
			requestDetails = serviceClient.invokeService(OpCode.REQUESTDETAILS.getOperationCode(), requestDetails,RequestDetails.class);
		}
		return requestDetails;
	}
}
