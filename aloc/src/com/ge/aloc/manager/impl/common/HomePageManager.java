/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: HomePageManager.java
 * Purpose: HomePageManager used for work flow users and it admins  to login and start a session.
 */
package com.ge.aloc.manager.impl.common;

import java.util.List;

import com.ge.aloc.dao.common.IHomePageDAO;
import com.ge.aloc.manager.common.IHomePageManager;
import com.ge.aloc.model.ContactUsDtls;
import com.ge.aloc.model.Inbox;
import com.ge.aloc.model.LandingPageDtls;
import com.ge.aloc.model.StaticDataManagement.UserSites;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author arijit.biswas
 *
 */
public class HomePageManager implements IHomePageManager {

	private IHomePageDAO homePageDAO;

	/**
	 * This method is used to get landing page details.
	 */
	public LandingPageDtls getLandingPageDetails(List<String> userRoles) throws HWFServiceException {
		return homePageDAO.getLandingPageDetails();
	}

	/**
	 * This method is use dto get user specific sites
	 * @throws HWFServiceException
	 */
	public List<UserSites> getUserSpecificSites() throws HWFServiceException {
		return homePageDAO.getUserSpecificSites();
	}
	/**
	 * This method is used to get Contact Details
	 */
	public ContactUsDtls getContactDetails() throws HWFServiceException {
		return homePageDAO.getContactDetails();
	}
	
	/**
	 * This method is used to get RequestDetails from Email link.
	 * @param requestId
	 * @return inbox
	 */
	public Inbox getEmailRequest(String requestId) throws HWFServiceException {
		return homePageDAO.getEmailRequest(requestId);
	}
	
	/**
	 * This method is used to get homePageDAO instance
	 * @return
	 */
	public IHomePageDAO getHomePageDAO() {
		return homePageDAO;
	}
	/**
	 * This method is used to set homePageDAO instance
	 * @param homePageDAO
	 */
	public void setHomePageDAO(IHomePageDAO homePageDAO) {
		this.homePageDAO = homePageDAO;
	}

}
