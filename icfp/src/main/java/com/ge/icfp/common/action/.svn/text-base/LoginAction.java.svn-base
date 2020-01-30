/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: LoginAction.java
 * Purpose: LoginAction used for work flow users and it admins  to login and start a session.
 */
package com.ge.icfp.common.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import com.hydus.wff.core.exception.HWFServiceException;
import com.hydus.wff.core.session.SessionManager;
import com.hydus.wff.core.session.SessionVO;
import com.hydus.wff.core.struts.BaseAction;
import static com.ge.icfp.common.constants.ICFPConstants.*;
/**
 * Action class for work flow users and it admins  to login and start a session
 * 
 * @author madhusudhan.gosula
 */
public class LoginAction extends BaseAction {
	
	private static final String USER_NAME = "userName";
	private static final String BEGIN_LOGIN_ACTION_EXECUTE = "Begin - LoginAction.execute()";
	// Logger using Log4J API
	private static final Logger LOGGER = Logger.getLogger(LoginAction.class);
	


	
	
	/**
	 * Redirects to Home if Valid user available
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return forward ActionForward
	 * @throws HWFServiceException if ant thing happens
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HWFServiceException {

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(BEGIN_LOGIN_ACTION_EXECUTE);
		}
		DynaActionForm loginForm = (DynaActionForm) form;
		SessionVO user = SessionManager.getSessionUser(request);
		if(user==null){
			return mapping.getInputForward();
		}

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("user name " + loginForm.getString(USER_NAME));
		}
		
		return mapping.findForward(FORWARD_HOMEPAGE);
	}
}