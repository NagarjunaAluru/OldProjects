/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: IRequestDetailsAware.java
 * Purpose: IRequestDetailsAware used get the request.
 */
package com.ge.aloc;

import com.ge.aloc.bo.RequestDetailsBO;
import com.ge.aloc.model.RequestDetails;

/**
 * 
 * @author madhusudhan.gosula
 *
 */
public interface IRequestDetailsBOAware {

	/**
	 * This method is used set request details BO object
	 * @param requestDetailsBO
	 */
	void setRequestDetailsBO(RequestDetailsBO requestDetailsBO);

	/**
	 * This method is used to get request details BO object
	 * @return
	 */
	RequestDetailsBO getRequestDetailsBO();

	/**
	 * This method is used to get Request details object.
	 * @return
	 */
	RequestDetails getRequestDetails();
}
