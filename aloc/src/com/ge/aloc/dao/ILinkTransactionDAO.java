/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ILinkTransactionDAO.java
 * Purpose: ILinkTransactionDAO used for Link/Unlink of Transactions
 */
package com.ge.aloc.dao;

import com.ge.aloc.model.Inbox;
import com.ge.aloc.model.RequestDetailsCollectionType;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author rguthi
 *
 */
public interface ILinkTransactionDAO {

	/**
	 * This method is used for link and unlink transaction information 
	 * and fetch the results based on search criteria
	 * @param inbox
	 * @return
	 * @throws HWFServiceException
	 */
	public RequestDetailsCollectionType loadLinkTransactions(Inbox inbox) throws HWFServiceException;

	/**
	 * This method is used for linking between a new request and a request 
	 * that has been submitted in the past
	 * @param inbox
	 * @return
	 * @throws HWFServiceException
	 */
	public Inbox linkTransaction(Inbox inbox) throws HWFServiceException;

	/**
	 * This method is used for unlink operation which are already linked 
	 * @param inbox
	 * @return
	 * @throws HWFServiceException
	 */
	public Inbox unLinkTransaction(Inbox inbox) throws HWFServiceException;

}
