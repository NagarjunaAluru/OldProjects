/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: TestUserContext.java
 * Purpose: TestUserContext used for creating the user context
 */
package com.hydus.hwf.context;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.hydus.hwf.security.auth.User;

public class TestUserContext {
	
	/**
	 *This is used to create user context 
	 * @param request
	 */
	public static void createUserContext(HttpServletRequest request)
    {
		HttpSession session = request.getSession();
		ServletContext servletContext = session.getServletContext();
		createUserContext(request, session, servletContext);
    }
	
	/**
	 * This is used to create user context
	 * @param request
	 * @param session
	 * @param servletContext
	 */
	public static void createUserContext(HttpServletRequest request, HttpSession session, ServletContext servletContext) {
		IContext requestScopeContext = UserContextUtils.createRequestScopeContext(request);
		IContext sessionScopeContext = (session != null) ? UserContextUtils.createSessionScopeContext(request) : null;
		IContext applicationScopeContext = (servletContext != null) ? UserContextUtils.createApplicationScopeContext(servletContext) : null;
		
		User user = UserContextUtils.createUnAuthenticatedJAASUser(request);
		Map<String, Object> context = new HashMap<String, Object>();
		UserContext userContext = UserContextUtils.createUserContext(user, context, requestScopeContext, sessionScopeContext, applicationScopeContext);
		UserContext.setContext(userContext);
	}
	
	/**
	 * This is used to unset the context
	 */
	public static void unsetContext()
    {
		UserContext.unsetContext();
    }

}
