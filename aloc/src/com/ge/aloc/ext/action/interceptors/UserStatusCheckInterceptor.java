/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: UserStatusCheckInterceptor.java
 * Purpose: UserStatusCheckInterceptor used to check user registration status
 */
package com.ge.aloc.ext.action.interceptors;

import java.util.Map;

import com.ge.aloc.constants.ALOCConstants;
import com.hydus.hwf.context.JAASUserContext;
import com.hydus.hwf.context.UserContext;
import com.hydus.hwf.util.StringUtils;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * @author madhusudhan.gosula
 *
 */
public class UserStatusCheckInterceptor extends AbstractInterceptor {
	
	private static final long serialVersionUID = 7871933159907482843L;
	
	public static final String USR_REG_PENDING_RESULT = "userRegistrationPending";
	
	/**
	 * This method check status of login user; if status is APPROVED it proceed with the request
	 * else it forwards to pending registration page.
	 */
	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		String result = USR_REG_PENDING_RESULT;
		UserContext uc = UserContext.getContext();
		
		if(uc instanceof JAASUserContext) {
			Map<String, String> statusMap = uc.getuserDetails().getStatusMap();
			String status = (statusMap != null) ? statusMap.get(ALOCConstants.IDM_STATUS) : null;
			if(StringUtils.isNotBlank(status) && status.equalsIgnoreCase(ALOCConstants.APPROVED)) {
				result = actionInvocation.invoke();
			}
		}
		return result;
	}
}
