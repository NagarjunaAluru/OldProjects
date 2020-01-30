/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ServiceClientAwareInterceptor.java
 * Purpose: ServiceClientAwareInterceptor used for the service invocations
 */
package com.ge.aloc.action.interceptors;

import com.ge.aloc.IServiceClientAware;
import com.hydus.hwf.bw.service.IServiceClient;
import com.opensymphony.xwork2.ActionInvocation;

public class ServiceClientAwareInterceptor extends ALOCInterceptor {

	private static final long serialVersionUID = 7918588640420852672L;

	private IServiceClient serviceClient;

	/**
	 * This method is used to set the serviceClient object before the action invocation.
	 * @param actionInvocation
	 */
	protected void beforeInvocation(ActionInvocation actionInvocation) {
		Object action = actionInvocation.getAction();
		if(IServiceClientAware.class.isAssignableFrom(action.getClass())) {
			((IServiceClientAware) action).setServiceClient(serviceClient);
		}
	}

	/**
	 * This is used to create service client instance object for the invocation.
	 * @return the serviceClient
	 */
	public IServiceClient getServiceClient() {
		return serviceClient;
	}

	/**
	 * This is used to set service client instance object for the invocation.
	 * @param serviceClient the serviceClient to set
	 */
	public void setServiceClient(IServiceClient serviceClient) {
		this.serviceClient = serviceClient;
	}
}
