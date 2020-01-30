/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: IRequestDetailsAware.java
 * Purpose: IRequestDetailsAware used for the to get the service client.
 */
package com.ge.aloc;

import com.hydus.hwf.bw.service.IServiceClient;
/**
 * 
 * @author madhusudhan.gosula
 *
 */
public interface IServiceClientAware {
	/**
	 * This method is used to set the service client object.
	 * @param serviceClient
	 */
	void setServiceClient(IServiceClient serviceClient);

	/**
	 * This method is used get the service client object
	 * @return
	 */
	IServiceClient getServiceClient();
}
