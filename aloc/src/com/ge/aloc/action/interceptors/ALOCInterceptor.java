/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ALOCInterceptor.java
 * Purpose: ALOCInterceptor used for the invocations
 */
package com.ge.aloc.action.interceptors;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
/**
 * This is a template class for all ALOC action interceptors.
 * 
 * Sub-classes need to implement either {@link #beforeInvocation(ActionInvocation)} or {@link #afterInvocation(ActionInvocation)}.
 * 
 * This class follows Template method design pattern.
 * 
 * @author madhusudhan.gosula
 *
 */
public class ALOCInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = -3998189490638266691L;

	/**
	 * This is the template method for all ALOC action interceptors.
	 */
	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		beforeInvocation(actionInvocation);
		String result = actionInvocation.invoke();
		afterInvocation(actionInvocation);
		return result;
	}

	/**
	 * This is the interceptor method which will be call before the invocation.
	 * 
	 * Sub classes need to override this method if they have to do some processing before the action call.
	 * 
	 * @param actionInvocation
	 */
	protected void afterInvocation(ActionInvocation actionInvocation) {
	}

	/**
	 * This is the interceptor method which will be call after the invocation.
	 * 
	 * Sub classes need to override this method if they have to do some clean up after the action invocation.
	 * 
	 * @param actionInvocation
	 */
	protected void beforeInvocation(ActionInvocation actionInvocation) {
	}
}
