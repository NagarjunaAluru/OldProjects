/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: CreateBundleDAO.java
 * Purpose: CreateBundleDAO used for add or remove or create functionality of the Bundle.
 *
 */

package com.ge.aloc.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.ge.aloc.OpCode;
import com.ge.aloc.ServiceClientSupport;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.dao.ICreateBundleDAO;
import com.ge.aloc.model.BundleDetails;
import com.ge.aloc.model.Inbox;
import com.ge.aloc.model.MsgHeader;
import com.ge.aloc.model.RequestDetails;
import com.ge.aloc.model.RequestDetailsCollectionType;
import com.ge.aloc.util.ALOCCommonHelper;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author rajeswari.guthi
 *
 */
public class CreateBundleDAO extends ServiceClientSupport implements ICreateBundleDAO {

	/**
	 * This method is used to load the list of bundles available
	 * @return
	 * @throws HWFServiceException 
	 */
	public List<RequestDetails>  loadBundleList(String requestId) throws HWFServiceException{			
		Inbox inboxResult = new Inbox();                                                    
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.GETVALIDBUNDLES.getOperationCode());	
		inboxResult = addDetailsToBundle(inboxResult, msgHeader,requestId, null);					
		inboxResult = (Inbox)serviceClient.invokeService(OpCode.INBOX.getOperationCode(), inboxResult, Inbox.class);			   
		List<RequestDetails> requestDetailsList = inboxResult.getBundle().getRequestDetails();
		return requestDetailsList;

	}

	/**
	 * This is used to get create or update a bundle
	 * @param requestId
	 * @param bundleId
	 * @return
	 * @throws HWFServiceException
	 */
	public RequestDetails addOrCreateBundle(String requestId, String bundleId) throws HWFServiceException  {			    		
		Inbox inboxResult = new Inbox();		
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.CREATEBUNDLE.getOperationCode());					
		inboxResult = addDetailsToBundle(inboxResult, msgHeader,requestId, bundleId);		
		inboxResult = (Inbox)serviceClient.invokeService(OpCode.INBOX.getOperationCode(), inboxResult, Inbox.class);
		List<RequestDetails> requestDetailsList = inboxResult.getBundle().getRequestDetails();
		return requestDetailsList.get(ALOCConstants.REQUESTDETAILS_BASE_INDEX);		 
	}


	/**
	 * This is used to delete selected bundle
	 * @param bundleId
	 * @throws HWFServiceException
	 */
	public RequestDetails removeBundle(String bundleId) throws HWFServiceException {		
		Inbox inboxResult = new Inbox();		   
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.DELBUNDLE.getOperationCode());					
		inboxResult = addDetailsToBundle(inboxResult, msgHeader,null, bundleId);
		inboxResult = (Inbox)serviceClient.invokeService(OpCode.INBOX.getOperationCode(), inboxResult, Inbox.class);
		List<RequestDetails> requestDetailsList = inboxResult.getBundle().getRequestDetails();		
		return  requestDetailsList.get(ALOCConstants.REQUESTDETAILS_BASE_INDEX);
	}



	/**
	 * This is used to remove a selected request from the selected bundle
	 * @param requestId
	 * @param bundleId
	 * @throws HWFServiceException
	 */
	public RequestDetails removeRequestFromBundle(String requestId,String bundleId) throws HWFServiceException {
		Inbox inboxResult = new Inbox();				
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.DELREQ.getOperationCode());		
		inboxResult = addDetailsToBundle(inboxResult, msgHeader,requestId, bundleId);
		inboxResult = (Inbox)serviceClient.invokeService(OpCode.INBOX.getOperationCode(), inboxResult, Inbox.class);
		List<RequestDetails> requestDetailsList = inboxResult.getBundle().getRequestDetails();			
		return requestDetailsList.get(ALOCConstants.REQUESTDETAILS_BASE_INDEX);
	}


	/**
	 * This is used to submit selected bundle
	 * @param bundleId
	 * @throws HWFServiceException
	 */
	public RequestDetails submitBundle(String bundleId) throws HWFServiceException {
		Inbox inboxResult = new Inbox();		
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.SUBMITBUNDLE.getOperationCode());
		inboxResult = addDetailsToBundle(inboxResult, msgHeader,null, bundleId);
		inboxResult = (Inbox)serviceClient.invokeService(OpCode.INBOX.getOperationCode(), inboxResult, Inbox.class);
		List<RequestDetails> requestDetailsList = inboxResult.getBundle().getRequestDetails();
		return  requestDetailsList.get(ALOCConstants.REQUESTDETAILS_BASE_INDEX);

	}

	/**
	 * This is used to get requests for a selected bundle
	 * @param bundleId
	 * @return
	 * @throws HWFServiceException
	 */
	public List<RequestDetails> getRequestsForBundle(String bundleId)
			throws HWFServiceException {
		Inbox inboxResult = new Inbox();
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.GETBUNDLEREQ.getOperationCode());		  
		inboxResult = addDetailsToBundle(inboxResult, msgHeader,null, bundleId);
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
	protected Inbox addDetailsToBundle(Inbox inboxResult,MsgHeader msgHeader, String requestId,String bundleId) {
		BundleDetails bundleDetails = new BundleDetails();
		List<RequestDetails> requestDetList = new ArrayList<RequestDetails>();
		RequestDetails requestDetails = new RequestDetails();		
		requestDetails.setMsgHeader(msgHeader);  
		if(requestId != null){
			requestDetails.setRequestId(new BigInteger(requestId));
		}
		if(bundleId != null){
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


}