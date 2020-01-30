/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: LoginPageAction.java
 * Purpose: LoginPageAction is used to display the login page for external users
 */
package com.ge.aloc.ext.action;

import com.ge.aloc.ext.manager.IUserOperationsManager;
import com.opensymphony.xwork2.ActionSupport;

/**
 * This class handles all requests related to login pages.
 * 
 * @author chaitanya.n
 */
public class LoginAction extends ActionSupport {
	
	private static final long serialVersionUID = 8366467955326785684L;
	
	private IUserOperationsManager userOperationsManager;

	private String orgId;
	private String target;
	private String smagentname;
	
	/**
	 * This method prepares data required to display login page.
	 * 
	 * @return
	 */
	public String login() {
		this.orgId = userOperationsManager.getEASOrgId();
		return ActionSupport.SUCCESS;
	}
	
	/**
	 * This method handles login attempt with invalid userId.
	 * 
	 * @return
	 */
	public String invalidUserId() {
		addActionError(getText("error.login.invalidUserId"));
		return login();
	}
	
	/**
	 * This method handles the login attempt with invalid password.
	 * 
	 * @return
	 */
	public String invalidPassword() {
		addActionError(getText("error.login.invalidPassword"));
		return login();
	}
	
	/**
	 * This method handles the user lock status after attempting maximum times.
	 * 
	 * @return
	 */
	public String userLocked() {
		addActionError(getText("error.login.userLocked"));
		return login();
	}

	/* -------------------------------------------------------------------------------------------------------------------------------- 
	 * 											PROPERTY SETTER/GETTER METHODS
	 --------------------------------------------------------------------------------------------------------------------------------- */

	/**
	 * Getter method for organisation id.
	 * 
	 * @return the orgId
	 */
	public String getOrgId() {
		return orgId;
	}

	/**
	 * Setter method for organisation id.
	 * 
	 * @param orgId the orgId to set
	 */
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	/* -------------------------------------------------------------------------------------------------------------------------------------------------------
	 * 															DEPENDENCY INJECTION METHODS
	 ------------------------------------------------------------------------------------------------------------------------------------------------------- */

	/**
	 * Setter method to inject {@link IUserOperationsManager} instance
	 * 
	 * @param authenticationMngr the authenticationMngr to set
	 */
	public void setUserOperationsManager(IUserOperationsManager authenticationMngr) {
		this.userOperationsManager = authenticationMngr;
	}

	/**
	 * Getter method of {@link IUserOperationsManager} instance.
	 * 
	 * @return the authenticationMngr
	 */
	public IUserOperationsManager getUserOperationsManager() {
		return userOperationsManager;
	}
	
	/**
	 * Returns Home Page URL
	 * 
	 * @return
	 */
	public String getTarget() {
		return target;
	}
	
	/**
	 * Returns Siteminder Agent Name
	 * 
	 * @return
	 */
	public String getSmagentname() {
		return this.smagentname;
	}
	
	/**
	 * Sets Siteminder Agent Name
	 * 
	 * @param sMAGENTNAME the sMAGENTNAME to set
	 */
	public void setSMAGENTNAME(String smagentname) {
		this.smagentname = smagentname;
	}

	/**
	 * Sets the Home Page URL
	 * 
	 * @param tARGET the tARGET to set
	 */
	public void setTARGET(String target) {
		this.target = target;
	}
}
