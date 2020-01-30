/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: HomePageAction.java
 * Purpose: HomePageAction used for work flow users and it admins  to login and start a session.
 */
package com.ge.icfp.common.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ge.icfp.util.UserRole;
import com.hydus.wff.core.context.UserContext;
import com.hydus.wff.core.session.SessionVO;
import com.hydus.wff.core.struts.BaseAction;

/**
 * Action class for work flow users and it admins  to login and start a session
 * 
 * @see: specify the class names to check
 */
public class HomePageAction extends BaseAction {

	private static final String DATA_MAINTENANCE = "dataMaintenance";
	private static final String APPROVAL_INBOX = "approvalInbox";

	/**
	 * Decides landing page based on logged in user. 
	 * if user has pipeline reviewer role, he/she will get Pipeline Management screen
	 * otherwise the inbox screen specific to the user
	 */
	public ActionForward execute(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		ActionForward forward = null;
		UserContext userContext = UserContext.getCurrentUserContext();
		SessionVO sessionVO = userContext.getUserSession();
		
		List<String> userRoles = sessionVO.getRoles();
		if(userRoles.contains(UserRole.Admin.getName())) {
			forward = mapping.findForward(DATA_MAINTENANCE);
		}else {
			forward = mapping.findForward(APPROVAL_INBOX);
		}
		return forward;
	}
}