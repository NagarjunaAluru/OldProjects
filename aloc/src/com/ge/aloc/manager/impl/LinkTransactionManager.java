/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: LinkTransactionManager.java
 * Purpose: LinkTransactionManager used for Link/Unlink of Transactions
 */
package com.ge.aloc.manager.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.dao.ILinkTransactionDAO;
import com.ge.aloc.manager.ILinkTransactionManager;
import com.ge.aloc.model.Inbox;
import com.ge.aloc.model.LinkDetails;
import com.ge.aloc.model.RequestDetails;
import com.ge.aloc.model.RequestDetailsCollectionType;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author rguthi
 *
 */
public class LinkTransactionManager implements ILinkTransactionManager{

	private ILinkTransactionDAO linkTransactionDAO;


	/**
	 * This method is used for link and unlink transaction information and
	 * fetch the results based on search criteria
	 * @return
	 * @throws HWFServiceException 
	 * searchCriteria need to be implemented after BW service implementation
	 */
	public RequestDetailsCollectionType loadLinkTransactions(String requestId) throws HWFServiceException {
		Inbox inbox = new Inbox();		
		RequestDetailsCollectionType requestCollection = new RequestDetailsCollectionType();
		List<RequestDetails> requestDetList = new ArrayList<RequestDetails>();
		RequestDetails requestDetails = new RequestDetails();

		LinkDetails linkedDetais = new LinkDetails();		
		if(StringUtils.isNotBlank(requestId)){
			linkedDetais.setLinkRequestId(new BigInteger(requestId));			
		}		
		requestDetails.setLinkDetails(linkedDetais);			
		requestDetList.add(requestDetails);		
		requestCollection.setRequestDetails(requestDetList);
		inbox.setBundle(requestCollection);		
		requestCollection = linkTransactionDAO.loadLinkTransactions(inbox);
		return requestCollection;
	}

	/**
	 * This method is used for linking between a new request and a request 
	 * that has been submitted in the past
	 * @return
	 * @throws HWFServiceException 
	 */
	public List<RequestDetails> linkTransaction(String linkRequestId,String linkedRequestId) throws HWFServiceException {
		Inbox inbox = new Inbox();
		RequestDetailsCollectionType requestCoolection = new RequestDetailsCollectionType();		
		List<RequestDetails> requestDetList = new ArrayList<RequestDetails>();
		RequestDetails requestDetails = new RequestDetails();	
		LinkDetails linkedDetais = new LinkDetails();		
		if(StringUtils.isNotBlank(linkRequestId)){
			linkedDetais.setLinkRequestId(new BigInteger(linkRequestId));			
		}		
		if(StringUtils.isNotBlank(linkedRequestId)){
			linkedDetais.setAlocLinkedRequestId(linkedRequestId);
		}				
		requestDetails.setLinkDetails(linkedDetais);
		requestDetList.add(requestDetails);
		requestCoolection.setRequestDetails(requestDetList);
		inbox.setBundle(requestCoolection);		
		requestDetList = linkTransactionDAO.linkTransaction(inbox).getBundle().getRequestDetails();
		return requestDetList;
	}

	/**
	 * This method is used for unlink operation which are already linked  
	 * @return
	 * @throws HWFServiceException 
	 */
	public RequestDetails unLinkTransaction(String linkId,String linkRequestId) throws HWFServiceException {
		Inbox inbox = new Inbox();				
		RequestDetailsCollectionType requestCoolection = new RequestDetailsCollectionType();
		List<RequestDetails> requestDetList = new ArrayList<RequestDetails>();
		RequestDetails requestDetails = new RequestDetails();
		LinkDetails linkedDetais = new LinkDetails();	
		if(linkId!=null){
			linkedDetais.setLinkId(new BigInteger(linkId));
		}
		if(linkRequestId!=null){
			linkedDetais.setLinkRequestId(new BigInteger(linkRequestId));
		}

		requestDetails.setLinkDetails(linkedDetais);
		requestDetList.add(requestDetails);		
		requestCoolection.setRequestDetails(requestDetList);
		inbox.setBundle(requestCoolection);
		requestDetails = linkTransactionDAO.unLinkTransaction(inbox).getBundle().getRequestDetails().get(ALOCConstants.REQUESTDETAILS_BASE_INDEX);
		return requestDetails;
	}

	/**
	 * This method is used to create linkTransactionDAO instance
	 * @return the linkTransactionDAO
	 */
	public ILinkTransactionDAO getLinkTransactionDAO() {
		return linkTransactionDAO;
	}

	/**
	 * This method is used to set linkTransactionDAO instance
	 * @param linkTransactionDAO the linkTransactionDAO to set
	 */
	public void setLinkTransactionDAO(ILinkTransactionDAO linkTransactionDAO) {
		this.linkTransactionDAO = linkTransactionDAO;
	}
}
