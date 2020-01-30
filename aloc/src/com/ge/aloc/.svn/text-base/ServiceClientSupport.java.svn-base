/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ServiceClientSupport.java
 * Purpose: ServiceClientSupport used for the all service invocations.
 */
package com.ge.aloc;

import com.hydus.hwf.bw.service.IServiceClient;

/**
 * @author madhusudhan.gosula
 *
 */
public class ServiceClientSupport implements IServiceClientAware {
	/**
	 * 
	 */
	protected IServiceClient serviceClient;
	/**
	 * (non-Javadoc)
	 * @see com.ge.aloc.IServiceClientAware#setServiceClient(com.hydus.hwf.bw.service.IServiceClient)
	 */
	public void setServiceClient(IServiceClient serviceClient) {
		this.serviceClient = serviceClient;
	}
	/**
	 * This method is used to get Service Client to invoke service.
	 */
	public IServiceClient getServiceClient() {
		return this.serviceClient;
	}
}
