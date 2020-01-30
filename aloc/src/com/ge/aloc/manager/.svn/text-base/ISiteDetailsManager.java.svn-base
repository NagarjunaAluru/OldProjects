/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ISiteDetailsManager.java
 * Purpose: ISiteDetailsManager used for the all site operations
 */
package com.ge.aloc.manager;

import java.util.List;

import com.ge.aloc.bo.SiteDetailsBO;
import com.ge.aloc.model.SiteAdmin;
import com.ge.aloc.model.UserDetails;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author madhusudhan.gosula
 *
 */
public interface ISiteDetailsManager {

	/**
	 * This method is used to Create A Site
	 * @return
	 */
	SiteAdmin createSite(SiteDetailsBO siteDetailsBO) throws HWFServiceException;

	/**
	 * This method is used to Save Default Delivery Instructions section
	 * @return
	 * @throws HWFServiceException
	 */
	SiteAdmin saveDefaultDelivary() throws HWFServiceException;


	/**
	 * This method is used to Save Customized Site References Section
	 * @throws HWFServiceException
	 */
	SiteAdmin saveCustomizedSiteReferences(SiteDetailsBO siteDetailsBO) throws HWFServiceException;


	/**
	 * This method is used to Create A Bank Site
	 * @throws HWFServiceException
	 */
	SiteAdmin createBankSite(SiteDetailsBO siteDetailsBO) throws HWFServiceException;


	/**
	 * This method is used to Save DelegationConfig Section
	 * @throws HWFServiceException
	 */
	void saveDelegationConfig() throws HWFServiceException;

	/**
	 * This method is used to get All Available Approvers
	 * @throws HWFServiceException
	 */
	List<UserDetails> getAvailableAprrovers() throws HWFServiceException;


	/**
	 * This method is used to Save Group
	 * @throws HWFServiceException
	 */
	void saveGroup(String groupName) throws HWFServiceException;
	
	/**
	 * This method is used to Delete Group
	 * @throws HWFServiceException
	 */
	void deleteGroup(String groupId) throws HWFServiceException;


	/**
	 * This method is used to Validate Group Name
	 * @throws HWFServiceException
	 */
	String validateGroup(String groupName) throws HWFServiceException;


	/**
	 * This method is used to Open BusinessAdmin Page
	 * @return
	 * @throws HWFServiceException
	 */
	SiteAdmin openBusinessAdmin(String siteId) throws HWFServiceException;

	/**
	 * This method is used to Save Delegation Approvers in Business SiteAdmin
	 * @param delegates
	 * @param adminAvailableApprovers
	 * @param siteAdmin
	 * @return
	 */
	SiteAdmin saveBusinessDelegates(String delegates,List<UserDetails> selectedApprovers,SiteAdmin siteAdmin) throws HWFServiceException;
}
