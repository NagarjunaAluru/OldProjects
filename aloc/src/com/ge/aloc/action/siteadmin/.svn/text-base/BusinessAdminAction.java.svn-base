/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: BusinessAdminAction.java
 * Purpose: BusinessAdminAction used for the all Business site operations
 */
package com.ge.aloc.action.siteadmin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.ge.aloc.bo.SiteDetailsBO;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.manager.ISiteDetailsManager;
import com.ge.aloc.model.Group;
import com.ge.aloc.model.SiteAdmin;
import com.ge.aloc.model.UserDetails;
import com.ge.aloc.util.SiteAdminHelper;
import com.hydus.hwf.exceptions.HWFServiceException;
import com.hydus.hwf.util.StringUtils;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author nagarjuna.aluru
 *
 */
public class BusinessAdminAction extends ActionSupport {

	private static final long serialVersionUID = 1088199564871340539L;

	private ISiteDetailsManager siteDetailsManager;
	private SiteDetailsBO siteDetailsBO;
	private List<UserDetails> availbleApprovers;
	private String delegates;
	private List<String> oldSelApprovers;
	private String siteOrBusinessSite;
	
	/**
	 * Method to get Available Approvers by Drop-down selection
	 * @return
	 * @throws HWFServiceException
	 */
	public String getCurrentApprovers() throws HWFServiceException {
		SiteAdmin siteAdmin = getSiteDetailsBO().getModel();
		List<Group> groupLst = siteAdmin.getDelegationConfiguration().getApprovalGroupConfiguration().getGroups();

		availbleApprovers = availableApprovers(availbleApprovers); 
		oldSelApprovers = SiteAdminHelper.getCurrentApprovers(groupLst);
		return ALOCConstants.CURRENT_DELEGATES;
	}	


	/**
	 * Method to Save Approvers of Delegates section
	 * @return
	 * @throws HWFServiceException
	 */
	public String saveBusinessDelegates() throws HWFServiceException {
		List<UserDetails> selAppDetails = SiteAdminHelper.addSelAppToUserDetails(oldSelApprovers);

		SiteAdmin siteAdmin = getSiteDetailsBO().getModel();
		if(StringUtils.isNotBlank(delegates)){
			siteAdmin = siteDetailsManager.saveBusinessDelegates(delegates,selAppDetails,siteAdmin);
		}
		SiteAdminHelper.setDelegOpcodeUpdate(siteAdmin);
		siteDetailsBO = new SiteDetailsBO(siteAdmin);
		SiteAdminHelper.setActiveSite(siteDetailsBO);
		if(StringUtils.isNotBlank(siteOrBusinessSite)){
			return ALOCConstants.SHOW_GROUPS;
		}
		return SUCCESS;
	}

	/**
	 * Method to get All Available Approvers
	 * @param availbleApprovers
	 * @return availbleApprovers
	 * @throws HWFServiceException
	 */
	private List<UserDetails> availableApprovers(List<UserDetails> availbleApprovers) throws HWFServiceException{
		availbleApprovers = getSiteDetailsManager().getAvailableAprrovers();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().setAttribute(ALOCConstants.AVAILBLEAPPROVERS, availbleApprovers);
		for(UserDetails userDet : availbleApprovers) {

			userDet.setUserSso(userDet.getUserSso()+ALOCConstants.TILDA+userDet.getLastName()+ALOCConstants.TILDA+userDet.getFirstName());
			userDet.setLastName(userDet.getLastName()+ALOCConstants.COMMA_SPACE+userDet.getFirstName());
		}
		return availbleApprovers;
	}

	/* -------------------------------------------------------------------------------------------------------------------------------- 
	 * 											PROPERTY SETTER/GETTER METHODS
	 --------------------------------------------------------------------------------------------------------------------------------- */
	/**
	 * This method is used to get delegates
	 * @return the delegates
	 */
	public String getDelegates() {
		return delegates;
	}

	/**
	 * This method is used to set delegates
	 * @param delegates the delegates to set
	 */
	public void setDelegates(String delegates) {
		this.delegates = delegates;
	}

	/**
	 * This method is used to get SiteAdmin Model
	 * @return
	 */
	public SiteAdmin getSiteAdmin() {
		return getSiteDetailsBO().getModel();
	}

	/**
	 * This method is used to get siteDetailsBO
	 * @return the siteDetailsBO
	 */
	public SiteDetailsBO getSiteDetailsBO() {
		if(siteDetailsBO == null) {
			siteDetailsBO = SiteAdminHelper.getActiveSite();
		} 
		return siteDetailsBO;
	}

	/**
	 * This method is used to get availbleApprovers
	 * @return
	 */
	public List<UserDetails> getAvailbleApprovers() {
		return availbleApprovers;
	}

	/**
	 * This method is used to set availbleApprovers
	 * @param availbleApprovers
	 */
	public void setAvailbleApprovers(List<UserDetails> availbleApprovers) {
		this.availbleApprovers = availbleApprovers;
	}

	/**
	 * 
	 * @return
	 */
	public List<String> getOldSelApprovers() {
		return oldSelApprovers;
	}

	/**
	 * 
	 * @param oldSelApprovers
	 */
	public void setOldSelApprovers(List<String> oldSelApprovers) {
		this.oldSelApprovers = oldSelApprovers;
	}
	
	/**
	 * This is used to get the site or the business site
	 * @return
	 */
	public String getSiteOrBusinessSite() {
		return siteOrBusinessSite;
	}

	/**
	 * This is used to set the site or business site
	 * @param siteOrBusinessSite
	 */
	public void setSiteOrBusinessSite(String siteOrBusinessSite) {
		this.siteOrBusinessSite = siteOrBusinessSite;
	}
	/* -------------------------------------------------------------------------------------------------------------------------------------------
	 * 														INJECTOR METHODS
	 -------------------------------------------------------------------------------------------------------------------------------------------- */

	/**
	 * This method is used to get siteDetailsManager
	 * @return the siteDetailsManager
	 */
	public ISiteDetailsManager getSiteDetailsManager() {
		return siteDetailsManager;
	}

	/**
	 * This method is used to set siteDetailsManager
	 * @param siteDetailsManager the siteDetailsManager to set
	 */
	public void setSiteDetailsManager(ISiteDetailsManager siteDetailsManager) {
		this.siteDetailsManager = siteDetailsManager;
	}


}