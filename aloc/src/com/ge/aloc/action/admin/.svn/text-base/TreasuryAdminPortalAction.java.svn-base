/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: TreasuryAdminPortalAction.java
 * Purpose: TreasuryAdminPortalAction used to retrive the portal page.
 */

package com.ge.aloc.action.admin;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.ge.aloc.constants.ALOCConstants;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author madhusudhan.gosula
 *
 */
public class TreasuryAdminPortalAction extends ActionSupport{

	private static final long serialVersionUID = -3663081967890110818L;

	/**
	 * 
	 */
	public String execute() {
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		String msg = (String) session.getAttribute(ALOCConstants.PORTAL_SUCCESSMSG);
		//String Flag="N";
		String Flag=ALOCConstants.DashBoard_N;   
		session.setAttribute("Flag",Flag);
		
		if(msg != null && !msg.isEmpty()) {
			addActionMessage(msg);
			session.removeAttribute(ALOCConstants.PORTAL_SUCCESSMSG);
		}
		return SUCCESS;
	}
}
