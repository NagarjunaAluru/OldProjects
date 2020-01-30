/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: HomePageDAO.java
 * Purpose: HomePageDAO used for work flow users and it admins  to login and start a session.
 */
package com.ge.aloc.dao.impl.common;

import java.util.ArrayList;
import java.util.List;

import com.ge.aloc.OpCode;
import com.ge.aloc.ServiceClientSupport;
import com.ge.aloc.dao.common.IHomePageDAO;
import com.ge.aloc.model.ContactUsDtls;
import com.ge.aloc.model.Inbox;
import com.ge.aloc.model.LandingPageDtls;
import com.ge.aloc.model.MsgHeader;
import com.ge.aloc.model.OpenEmailLink;
import com.ge.aloc.model.StaticDataManagement;
import com.ge.aloc.model.StaticDataManagement.UserSites;
import com.ge.aloc.util.ALOCCommonHelper;
import com.hydus.hwf.context.UserContext;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author arijit.biswas
 *
 */
public class HomePageDAO extends ServiceClientSupport implements IHomePageDAO {

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
	 * Method to get the SiteTypes from the Service
	 */
	public List<UserSites> getUserSpecificSites() throws HWFServiceException {
		StaticDataManagement staticDataObject = new StaticDataManagement();
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.GETUSERSITES.getOperationCode());
		staticDataObject.setMsgHeader(msgHeader);

		List<UserSites> userSitesLst = new ArrayList<UserSites>();
		UserSites userSites = new UserSites();
		userSites.setUserSso(UserContext.getContext().getuserDetails().getUserId());
		userSitesLst.add(userSites);
		staticDataObject.setUserSites(userSitesLst);

		staticDataObject = serviceClient.invokeService(OpCode.STATICDATA.getOperationCode(), staticDataObject,StaticDataManagement.class);
		if(staticDataObject!=null){
			userSitesLst = staticDataObject.getUserSites();
			return userSitesLst;
		}

		return null;
	}

	/**
	 * This method is used to get Contact Details
	 */
	public ContactUsDtls getContactDetails() throws HWFServiceException {
		ContactUsDtls contactDetails = new ContactUsDtls();
		return serviceClient.invokeService(OpCode.CONTACTUSDETAILS.getOperationCode(), contactDetails, ContactUsDtls.class);
	}
	
	/**
	 * This method is used to get RequestDetails from Email link.
	 * @param requestId
	 * @return inbox
	 */
	public Inbox getEmailRequest(String requestId) throws HWFServiceException {
		OpenEmailLink openEmailRequest = new OpenEmailLink();
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(null);
		openEmailRequest.setMsgHeader(msgHeader);
		openEmailRequest.setAlocRecordId(requestId);

		Inbox inbox = serviceClient.invokeService(OpCode.OPENEMAILLINK.getOperationCode(), openEmailRequest, Inbox.class);
		return inbox;
	}
}
