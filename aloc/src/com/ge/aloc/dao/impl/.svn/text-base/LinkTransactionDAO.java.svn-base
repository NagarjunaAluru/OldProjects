/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: LinkTransactionDAO.java
 * Purpose: LinkTransactionDAO used for Link/Unlink of Transactions
 */
package com.ge.aloc.dao.impl;

import com.ge.aloc.OpCode;
import com.ge.aloc.ServiceClientSupport;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.dao.ILinkTransactionDAO;
import com.ge.aloc.model.Inbox;
import com.ge.aloc.model.MsgHeader;
import com.ge.aloc.model.RequestDetailsCollectionType;
import com.ge.aloc.util.ALOCCommonHelper;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author rguthi
 *
 */
public class LinkTransactionDAO extends ServiceClientSupport implements ILinkTransactionDAO {	

	/**
	 * This method is used for link and unlink transaction information 
	 * and fetch the results based on search criteria
	 * @return
	 * @throws HWFServiceException 
	 */
	public RequestDetailsCollectionType loadLinkTransactions(Inbox inbox) throws HWFServiceException {	
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.LINKDETAILS.getOperationCode());	
		msgHeader.setStatus( OpCode.GETLINKREQ.getOperationCode());
		inbox.getBundle().getRequestDetails().get(ALOCConstants.REQUESTDETAILS_BASE_INDEX).setMsgHeader(msgHeader);		
		inbox.setMsgHeader(msgHeader);		
		inbox = serviceClient.invokeService(OpCode.INBOX.getOperationCode(), inbox, Inbox.class);
		return inbox.getBundle();	
	}

	/**
	 * This method is used for linking between a new request and a request 
	 * that has been submitted in the past
	 * @return
	 * @throws HWFServiceException 
	 */
	public Inbox linkTransaction(Inbox inbox) throws HWFServiceException {		
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.LINKDETAILS.getOperationCode());	
		msgHeader.setStatus( OpCode.CREATELINK.getOperationCode());
		inbox.getBundle().getRequestDetails().get(ALOCConstants.REQUESTDETAILS_BASE_INDEX).setMsgHeader(msgHeader);
		inbox.setMsgHeader(msgHeader);
		Inbox inboxResult = serviceClient.invokeService(OpCode.INBOX.getOperationCode(), inbox, Inbox.class);	
		return inboxResult;
	}

	/**
	 * This method is used for unlink operation which are already linked  
	 * @return
	 * @throws HWFServiceException 
	 */
	public Inbox unLinkTransaction(Inbox inbox) throws HWFServiceException {
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.LINKDETAILS.getOperationCode());	
		msgHeader.setStatus( OpCode.DELETELINK.getOperationCode());				
		inbox.getBundle().getRequestDetails().get(ALOCConstants.REQUESTDETAILS_BASE_INDEX).setMsgHeader(msgHeader);		
		inbox.setMsgHeader(msgHeader);
		Inbox inboxResult = serviceClient.invokeService(OpCode.INBOX.getOperationCode(), inbox, Inbox.class);	
		return inboxResult;
	}
}
