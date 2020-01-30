/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ILinkTransactionManager.java
 * Purpose: ILinkTransactionManager used for Link/Unlink of Transactions
 */
package com.ge.aloc.manager;

import java.util.List;

import com.ge.aloc.model.RequestDetails;
import com.ge.aloc.model.RequestDetailsCollectionType;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author rguthi
 *
 */
public interface ILinkTransactionManager {


	/**
	 * This method is used for link and unlink transaction information 
	 * and fetch the results based on search criteria
	 * @param inbox
	 * @return
	 * @throws HWFServiceException
	 */
	public RequestDetailsCollectionType loadLinkTransactions(String requestId) throws HWFServiceException;

	/**
	 * This method is used for linking between a new request and a request 
	 * that has been submitted in the past
	 * @param inbox
	 * @return
	 * @throws HWFServiceException
	 */
	public List<RequestDetails> linkTransaction(String linkRequestId,String linkedRequestId ) throws HWFServiceException; 

	/**
	 * This method is used for unlink operation which are already linked 
	 * @param inbox
	 * @return
	 * @throws HWFServiceException
	 */
	public RequestDetails unLinkTransaction(String linkId,String linkedRequestId) throws HWFServiceException;

}
