/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: UserOperationsDAO.java
 * Purpose: UserOperationsDAO used for the all external user operations
 */
package com.ge.aloc.ext.dao.impl;

import com.ge.aloc.OpCode;
import com.ge.aloc.ServiceClientSupport;
import com.ge.aloc.ext.UserOperationException;
import com.ge.aloc.ext.dao.IUserOperationsDAO;
import com.ge.aloc.model.EASContactDetails;
import com.ge.aloc.model.EASCredentials;
import com.ge.aloc.model.EASDetails;
import com.ge.aloc.model.LandingPageDtls;
import com.ge.aloc.model.MsgHeader;
import com.ge.aloc.util.ALOCCommonHelper;
import com.hydus.hwf.exceptions.HWFApplicationException;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * This is implementation class for {@link IUserOperationsDAO}.
 * 
 * @author chaitanya.n
 */
public class UserOperationsDAO extends ServiceClientSupport implements IUserOperationsDAO {

	/**
	 * @see com.ge.aloc.ext.dao.IUserOperationsDAO#createUser(com.ge.aloc.model.EASDetails)
	 */
	public void createUser(EASDetails easDetails) throws HWFServiceException {
		MsgHeader msgHeader = createMsgHeader(OpCode.INSERT.getOperationCode());
		easDetails.setMsgHeader(msgHeader);
		easDetails = serviceClient.invokeService(OpCode.EASOPERATIONS.getOperationCode(), easDetails, EASDetails.class);
	}

	/**
	 * @see com.ge.aloc.ext.dao.IUserOperationsDAO#getUser(String)
	 * @throws UserOperationException
	 */
	public EASDetails getUser(String userName) throws HWFServiceException, UserOperationException {
		EASCredentials easCreds = new EASCredentials();
		easCreds.setUserId(userName);
		EASDetails easDetails = new EASDetails();
		easDetails.setEASCredentials(easCreds);
		easDetails = search(easDetails);
		return easDetails;
	}

	/**
	 * @see com.ge.aloc.ext.dao.IUserOperationsDAO#getUserByEmail()
	 * @throws UserOperationException 
	 */
	public EASDetails getUserByEmail(String email) throws HWFServiceException, UserOperationException {
		EASContactDetails easContactDetails = new EASContactDetails();
		easContactDetails.setEmailAddress(email);
		EASDetails easDetails = new EASDetails();
		easDetails.setEASContactDetails(easContactDetails);
		easDetails = search(easDetails);
		return easDetails;
	}

	/**
	 * Method to Search the User details by Mail Id 
	 * @param input
	 * @return
	 * @throws HWFServiceException 
	 * @throws UserOperationException 
	 */
	private EASDetails search(EASDetails input) throws HWFServiceException, UserOperationException {
		EASDetails output = null;

		MsgHeader msgHeader = createMsgHeader(OpCode.EASSEARCH.getOperationCode());
		input.setMsgHeader(msgHeader);
		try {
			output = serviceClient.invokeService(OpCode.EASOPERATIONS.getOperationCode(), input, EASDetails.class);
		} catch(HWFApplicationException ae) {
			if(ae.getCode() != null && ae.getCode().equals(UserOperationException.EAS_USER_NOT_FOUND) || ae.getCode().equals(UserOperationException.USER_NOT_FOUND)) {
				boolean byUserId = (input.getEASCredentials() != null && input.getEASCredentials().getUserId() != null);
				if(byUserId) {
					throw new UserOperationException(UserOperationException.EC_NOTFOUND, input.getEASCredentials().getUserId());
				} else {
					throw new UserOperationException(UserOperationException.EC_NOTFOUND_EMAIL, input.getEASContactDetails().getEmailAddress());
				}
			} 
			throw ae;
		}
		return output;
	}


	/**
	 * Method to get the Landing page details
	 */
	public LandingPageDtls getLandingPageDetails() throws HWFServiceException {
		LandingPageDtls landingPageDetails = new LandingPageDtls();
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.LANDINGPAGE.getOperationCode());
		landingPageDetails.setMsgHeader(msgHeader);
		landingPageDetails = serviceClient.invokeService(OpCode.LANDINGPAGE.getOperationCode(), landingPageDetails, LandingPageDtls.class);
		return landingPageDetails;
	}

	/**
	 * Set Message Header for External Users
	 * @param opCode
	 * @return
	 */
	private MsgHeader createMsgHeader(String opCode) {
		MsgHeader msgHeader = new MsgHeader();
		msgHeader.setOpcode(opCode);
		return msgHeader;
	}
}
