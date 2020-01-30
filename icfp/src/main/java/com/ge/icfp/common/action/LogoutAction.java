/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: LogoutAction.java
 * Purpose: LogoutAction used for user's to end their session.
 */
package com.ge.icfp.common.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hydus.wff.core.struts.BaseAction;
import com.hydus.wff.core.util.PropertyManager;
import static com.ge.icfp.common.constants.ICFPConstants.*; 
/**
 * Action class for user's to end their session
 * 
 *  @author madhusudhan.gosula
 */

public class LogoutAction extends BaseAction {
	private static final String LOGOUT_URL = "logout.url";
	private static final String END_LOGOUT_ACTION_EXECUTE = "End - LogoutAction.execute()";
	private static final String BEGIN_LOGOUT_ACTION_EXECUTE = "Begin - LogoutAction.execute()";
	private static final Logger LOGGER = Logger.getLogger(LogoutAction.class);
	// Global Forwards
	public static final String FORWARD_LOGINPAGE = "loginPage";

	/**
	 * Redirects to Logout page
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return forward ActionForward
	 * @throws Exception if ant thing happens
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(BEGIN_LOGOUT_ACTION_EXECUTE);
		}
	
		HttpSession session = request.getSession(false);
		if(session != null) {
			session.invalidate();
		}
	
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(END_LOGOUT_ACTION_EXECUTE);
		}
		
		String url = getPropertyValue(LOGOUT_URL);
		response.sendRedirect(url);
		
		return null;
	}

	/**
	 * getPropertyValue
	 * @param property
	 * @return
	 */
	private String getPropertyValue(String property) {

		return StringUtils.isEmpty(property) ? "" : PropertyManager.getString(
				PROPERTIES_APPLICATION, property);
	}
}