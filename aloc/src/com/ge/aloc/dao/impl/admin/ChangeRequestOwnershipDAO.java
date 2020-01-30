/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ChangeRequestOwnershipDAO.java
 * Purpose: ChangeRequestOwnershipDAO used for search and change the requests ownership
 */
package com.ge.aloc.dao.impl.admin;

import com.ge.aloc.OpCode;
import com.ge.aloc.ServiceClientSupport;
import com.ge.aloc.dao.admin.IChangeRequestOwnershipDAO;
import com.ge.aloc.model.RequestorTrasactionsReply;
import com.ge.aloc.util.ALOCCommonHelper;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author madhavi.pathella
 *
 */
public class ChangeRequestOwnershipDAO extends ServiceClientSupport implements IChangeRequestOwnershipDAO {
	
	/**
	 * Method to get search available requests for selected requester.
	 * @param requestorTrasactionsReply
	 * @return
	 * @throws HWFServiceException
	 */
	public RequestorTrasactionsReply searchSelOwnerRequestDetails(
			RequestorTrasactionsReply requestorTrasactionsReply) throws HWFServiceException {
		requestorTrasactionsReply.setMsgHeader(ALOCCommonHelper.createMsgHeader(OpCode.GETREQUESTORREPLY.getOperationCode()));
		return (RequestorTrasactionsReply)serviceClient.invokeService(OpCode.GETREQUESTORREPLYDETAILS.getOperationCode(), requestorTrasactionsReply, RequestorTrasactionsReply.class);
	}
	
	/**
	 * Method to change the ownership of selected requests with given new requestor.
	 * @param requestorTrasactionsReply
	 * @return
	 * @throws HWFServiceException
	 */
	public RequestorTrasactionsReply changeSelectedRequestsOwnership(
			RequestorTrasactionsReply requestorTrasactionsReply)
			throws HWFServiceException {
		requestorTrasactionsReply.setMsgHeader(ALOCCommonHelper.createMsgHeader(OpCode.CHANGEREQUESTOWNERSHIP.getOperationCode()));
		return (RequestorTrasactionsReply)serviceClient.invokeService(OpCode.GETREQUESTORREPLYDETAILS.getOperationCode(), requestorTrasactionsReply, RequestorTrasactionsReply.class);
	}
}
