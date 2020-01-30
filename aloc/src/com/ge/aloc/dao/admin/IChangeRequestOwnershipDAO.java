/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: IChangeRequestOwnershipDAO.java
 * Purpose: IChangeRequestOwnershipDAO used for search and change the requests ownership
 */
package com.ge.aloc.dao.admin;

import com.ge.aloc.model.RequestorTrasactionsReply;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author madhavi.pathella
 *
 */
public interface IChangeRequestOwnershipDAO {
	
	/**
	 * Method to get search available requests for selected requester.
	 * @param requestorTrasactionsReply
	 * @return
	 * @throws HWFServiceException
	 */
	public RequestorTrasactionsReply searchSelOwnerRequestDetails(RequestorTrasactionsReply requestorTrasactionsReply) throws HWFServiceException;
	
	/**
	 * Method to change the ownership of selected requests with given new requestor.
	 * @param requestorTrasactionsReply
	 * @return
	 * @throws HWFServiceException
	 */
	public RequestorTrasactionsReply changeSelectedRequestsOwnership(RequestorTrasactionsReply requestorTrasactionsReply) throws HWFServiceException;
}
