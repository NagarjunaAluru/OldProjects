/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: IHomePageDAO.java
 * Purpose: IHomePageDAO used for work flow users and it admins  to login and start a session.
 */
package com.ge.aloc.dao.common;

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
public interface IHomePageDAO {

	/**
	 * This method is used to get landing page details
	 * @param landingPageDetails
	 * @return
	 */
	public LandingPageDtls getLandingPageDetails() throws HWFServiceException;


	/**
	 *  This method is used to get user specific sites
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
	 * @param landingPageDetails
	 * @return
	 */
	public Inbox getEmailRequest(String requestId) throws HWFServiceException;
}
