/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: RequestDetailsAwareIntercepter.java
 * Purpose: RequestDetailsAwareIntercepter used for the request invocations
 */
package com.ge.aloc.action.interceptors;

import com.ge.aloc.ALOCContext;
import com.ge.aloc.IRequestDetailsBOAware;
import com.ge.aloc.bo.RequestDetailsBO;
import com.opensymphony.xwork2.ActionInvocation;


/**
 * @author hariprasad.madas
 *
 */
public class RequestDetailsBOAwareIntercepter extends ALOCInterceptor {

	private static final long serialVersionUID = -508577619048093275L;

	/**
	 * This method is used to set the requestDetailsBO object before the action invocation.
	 */
	protected void beforeInvocation(ActionInvocation actionInvocation) {
		Object action = actionInvocation.getAction();
		RequestDetailsBO requestDetailsBO = ALOCContext.getActiveRequest();
		if(IRequestDetailsBOAware.class.isAssignableFrom(action.getClass())) {
			((IRequestDetailsBOAware) action).setRequestDetailsBO(requestDetailsBO);
		}
	}
}
