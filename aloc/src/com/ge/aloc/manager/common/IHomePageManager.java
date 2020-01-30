/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: IHomePageManager.java
 * Purpose: IHomePageManager used for work flow users and it admins  to login and start a session.
 */
package com.ge.aloc.manager.common;

import java.util.List;

import com.ge.aloc.model.ContactUsDtls;
import com.ge.aloc.model.Inbox;
import com.ge.aloc.model.LandingPageDtls;
import com.ge.aloc.model.StaticDataManagement.UserSites;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author arijit.biswas
 *
 */
public interface IHomePageManager {
	/**
	 * This method is used to get landing page details.
	 * @param userRoles
	 * @return
	 * @throws HWFServiceException
	 */
	public LandingPageDtls getLandingPageDetails(List<String> userRoles) throws HWFServiceException;

	/**
	 * method to get the user Specific Sites
	 * @return
	 * @throws HWFServiceException
	 */
	List<UserSites> getUserSpecificSites() throws HWFServiceException;

	/**
	 * This method is used to get Contact Details
	 * @return
	 * @throws HWFServiceException
	 */
	public ContactUsDtls getContactDetails() throws HWFServiceException;
	
	/**
	 * This method is used to get RequestDetails from Email link.
	 * @param requestId
	 * @return
	 * @throws HWFServiceException
	 */
	public Inbox getEmailRequest(String requestId) throws HWFServiceException;
}
