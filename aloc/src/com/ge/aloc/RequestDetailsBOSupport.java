/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: RequestDetailsSupport.java
 * Purpose: RequestDetailsSupport used for the all request operations
 */
package com.ge.aloc;

import com.ge.aloc.bo.RequestDetailsBO;
import com.ge.aloc.model.RequestDetails;

/**
 * @author chaitanya.n
 *
 */
public class RequestDetailsBOSupport implements IRequestDetailsBOAware {

	protected RequestDetailsBO requestDetailsBO;

	/**
	 * This method is used to get the request details BO Object.
	 * @return the requestDetailsBO
	 */
	public RequestDetailsBO getRequestDetailsBO() {
		return requestDetailsBO;
	}

	/**
	 * This method is used to set the request details BO object.
	 * @param requestDetailsBO the requestDetailsBO to set
	 */
	public void setRequestDetailsBO(RequestDetailsBO requestDetailsBO) {
		this.requestDetailsBO = requestDetailsBO;
	}

	/**
	 * This method is used to get RequestDetails Object.
	 */
	public RequestDetails getRequestDetails() {
		return requestDetailsBO.getModel();
	}
}
