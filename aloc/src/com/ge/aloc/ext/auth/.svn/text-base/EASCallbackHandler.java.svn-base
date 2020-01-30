/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: EASCallbackHandler.java
 * Purpose: EASCallbackHandler is used to authenticate the UserId
 */
package com.ge.aloc.ext.auth;

import org.apache.log4j.Logger;

import com.ge.aloc.constants.ALOCConstants;
import com.hydus.hwf.ge.security.auth.callback.GESSOWebAppCallbackHandler;
import com.hydus.hwf.util.StringUtils;

/**
 * This is JAAS callback handle class to fetch userId from request.
 * 
 * @author chaitanya.n
 */
public class EASCallbackHandler extends GESSOWebAppCallbackHandler {

	private static final Logger LOGGER = Logger.getLogger(EASCallbackHandler.class);

	/**
	 * This method fetches the authenticated userID from the request.
	 * 
	 * User usually authenticated by Siteminder at the webserver.
	 */
	@Override
	protected String getUserName() {
		String userId = (request.getHeader("sm_user") != null) ? request.getHeader("sm_user") : request.getHeader("smuser");
		
		// Development mode trying with USER parameter
		if(userId == null) {
			if(LOGGER.isInfoEnabled()) {
				LOGGER.info("Could not find user ID header of the Siteminder using either \'sm_user\' or \'smuser\' request headers; application may running in dev, tryin with USER parameter");
			}
			
			userId = request.getParameter(ALOCConstants.USER);
		}
		
		if(StringUtils.isNotBlank(userId)) {
			int orgSeperatorIndex = userId.indexOf(':');
			userId = (orgSeperatorIndex > ALOCConstants.BASE_VALUE) ? userId.substring(orgSeperatorIndex + ALOCConstants.MIN_VALUE) : userId;
		}
		
		if(StringUtils.isBlank(userId)) {
			LOGGER.warn("Could not find user token in the request " + request.getRequestURI());
		}
		return userId;
	}
}
