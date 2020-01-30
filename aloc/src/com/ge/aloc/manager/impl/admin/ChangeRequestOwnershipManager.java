/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: IChangeRequestOwnershipManager.java
 * Purpose: IChangeRequestOwnershipManager used for search and change the requests ownership
 */
package com.ge.aloc.manager.impl.admin;

import java.util.ArrayList;
import java.util.List;

import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.dao.admin.IChangeRequestOwnershipDAO;
import com.ge.aloc.manager.admin.IChangeRequestOwnershipManager;
import com.ge.aloc.model.RequestorTransaction;
import com.ge.aloc.model.RequestorTrasactionsReply;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author madhavi.pathella
 *
 */
public class ChangeRequestOwnershipManager implements
		IChangeRequestOwnershipManager {
	
	private IChangeRequestOwnershipDAO changeRequestOwnershipDAO;

	/**
	 * @return the changeRequestOwnershipDAO
	 */
	public IChangeRequestOwnershipDAO getChangeRequestOwnershipDAO() {
		return changeRequestOwnershipDAO;
	}

	/**
	 * @param changeRequestOwnershipDAO the changeRequestOwnershipDAO to set
	 */
	public void setChangeRequestOwnershipDAO(IChangeRequestOwnershipDAO changeRequestOwnershipDAO) {
		this.changeRequestOwnershipDAO = changeRequestOwnershipDAO;
	}
	
	/**
	 * Method to get search available requests for selected requester.
	 * @param requestorTrasactionsReply
	 * @return
	 * @throws HWFServiceException
	 */
	public RequestorTrasactionsReply searchSelOwnerRequestDetails(
			RequestorTrasactionsReply requestorTrasactionsReply)
			throws HWFServiceException {
		return changeRequestOwnershipDAO.searchSelOwnerRequestDetails(requestorTrasactionsReply);
	}
	
	/**
	 * Method to change the ownership of selected requests with given new requestor.
	 * @param requestorTrasactionsReply
	 * @param requestorTransactionList
	 * @return
	 * @throws HWFServiceException
	 */
	public RequestorTrasactionsReply changeSelectedRequestsOwnership(
			RequestorTrasactionsReply requestorTrasactionsReply,List<RequestorTransaction> requestorTransactionList)
			throws HWFServiceException {
		List<RequestorTransaction> selRequestorTransactionList = new ArrayList<RequestorTransaction>();
		if(requestorTransactionList != null && requestorTransactionList.size() > ALOCConstants.BASE_VALUE)
		{
			for(RequestorTransaction requestorTransaction : requestorTransactionList)
			{
				if(requestorTransaction.isSelectedRequest())
				{
					selRequestorTransactionList.add(requestorTransaction);
				}
			}
		}
		requestorTrasactionsReply.setRequestorTransactions(selRequestorTransactionList);
		return changeRequestOwnershipDAO.changeSelectedRequestsOwnership(requestorTrasactionsReply);
	}
}
