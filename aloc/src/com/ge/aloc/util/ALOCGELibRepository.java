/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ALOCGELibRepository.java
 * Purpose: ALOCGELibRepository used for external users
 */
package com.ge.aloc.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hydus.hwf.ge.attachments.impl.GELibRepository;

/**
 * @author nagarjuna.aluru
 *
 */
public class ALOCGELibRepository extends GELibRepository {
	
	public static final String REQ_ATTR_ISEXTERNAL = "externalRequest";

	/**
	 * 
	 */
	@Override
	protected String getUserId() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Boolean isExternalRequest = (Boolean) request.getAttribute(REQ_ATTR_ISEXTERNAL);
		if(isExternalRequest != null && isExternalRequest.equals(Boolean.TRUE)) {
			return super.getDefaultUserId();
		} else {
			return super.getDefaultUserId();
			/*return super.getUserId();*/ //Need to change once all the Dev users got access to GE Library 
		}
	}
}
