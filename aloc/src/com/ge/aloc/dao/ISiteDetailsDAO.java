/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ISiteDetailsDAO.java
 * Purpose: ISiteDetailsDAO used for the site DAO declarations
 */
package com.ge.aloc.dao;

import java.util.List;

import com.ge.aloc.IServiceClientAware;
import com.ge.aloc.model.SiteAdmin;
import com.ge.aloc.model.UserDetails;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author madhusudhan.gosula
 *
 */
public interface ISiteDetailsDAO extends IServiceClientAware {

	/**
	 * This method is used to create A Site
	 * @param siteAdmin
	 * @return
	 * @throws HWFServiceException
	 */
	SiteAdmin createSite(SiteAdmin siteAdmin) throws HWFServiceException;

	/**
	 * This method is used to Save Default Delivery Instructions section
	 * @param siteAdmin
	 * @return
	 * @throws HWFServiceException
	 */
	SiteAdmin saveDefaultDelivary(SiteAdmin siteAdmin) throws HWFServiceException;


	/**
	 * This method is used to Save Customized Site References Section
	 * @param siteAdmin
	 * @return
	 * @throws HWFServiceException
	 */
	SiteAdmin saveCustomizedSiteReferences(SiteAdmin siteAdmin) throws HWFServiceException;


	/**
	 * This method is used to Create A Bank Site
	 * @param siteAdmin
	 * @return
	 * @throws HWFServiceException
	 */
	SiteAdmin createBankSite(SiteAdmin siteAdmin) throws HWFServiceException;

	/**
	 * This method is used to Save DelegationConfig Section
	 * @param siteAdmin
	 * @return
	 * @throws HWFServiceException
	 */
	void saveDelegationConfig(SiteAdmin siteAdmin) throws HWFServiceException;

	/**
	 * This method is used to get All the Available Approvers
	 * @return
	 * @throws HWFServiceException
	 */
	List<UserDetails> getAvailableAprrovers(SiteAdmin siteadmin) throws HWFServiceException;


	/**
	 * This method is used to Save Group
	 * @return
	 * @throws HWFServiceException
	 */
	void saveGroup(SiteAdmin siteAdmin, String groupName) throws HWFServiceException;
	
	/**
	 * This method is used to Delete the Group
	 * @return
	 * @throws HWFServiceException
	 */
	void deleteGroup(SiteAdmin siteAdmin, String groupId) throws HWFServiceException;


	/**
	 * This method is used to Validate Group Name
	 * @return
	 * @throws HWFServiceException
	 */
	String validateGroup(SiteAdmin siteAdmin, String groupName) throws HWFServiceException;


	/**
	 * This method is used to Open BusinessAdmin Page
	 * @param siteId
	 * @return
	 * @throws HWFServiceException
	 */
	SiteAdmin openBusinessAdmin(String siteId) throws HWFServiceException;

	/**
	 * This method is used to Save Delegation Approvers in Business SiteAdmin
	 * @param siteAdmin
	 * @return
	 * @throws HWFServiceException
	 */
	SiteAdmin saveBusinessDelegates(SiteAdmin siteAdmin) throws HWFServiceException;;
}
