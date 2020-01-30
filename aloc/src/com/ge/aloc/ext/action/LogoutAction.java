/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: LogoutAction.java
 * Purpose: LogoutAction used to kill the current session.
 * A zero value causes the cookie to be deleted
 */
package com.ge.aloc.ext.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.ge.aloc.constants.ALOCConstants;

/**
 * @author madhusudhan.gosula
 *
 */
public class LogoutAction extends com.hydus.hwf.security.struts2.LogoutAction {

	private static final long serialVersionUID = -91930823092063757L;
	
	private static final Logger LOGGER = Logger.getLogger(LogoutAction.class);

	/**
	 * 
	 */
	public String execute() {
		String result = super.execute();
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse(); 
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookieToDelete : cookies) {
				cookieToDelete.setMaxAge(ALOCConstants.MIN_INDEX);
				cookieToDelete.setValue(ALOCConstants.EMPTY_STRING);
				if(LOGGER.isInfoEnabled()) {
					StringBuilder cookieInfo = new StringBuilder().append(ALOCConstants.COOKIE)
							.append(cookieToDelete.getName())
							.append(ALOCConstants.COOKIE_PATH).append(cookieToDelete.getPath())
							.append(ALOCConstants.COOKIE_DOMAIN).append(cookieToDelete.getDomain()).append(ALOCConstants.COOKIE_CLOSEBRACE);
					LOGGER.info(cookieInfo.toString());
				}
				response.addCookie(cookieToDelete);
			}
		}
		
		return result;
	}
}
