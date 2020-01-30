/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: SecurityHelper.java
 * Purpose: SecurityHelper used for get the ICFP Roles for Admin Delegate functionality.
 */
package com.ge.icfp.util;

import static com.ge.icfp.common.constants.ICFPConstants.FAILUREMSG;

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.rpc.ServiceException;

import com.ge.icfp.action.ICFPException;
import com.ge.treasury.security.AuthConnClient;
import com.ge.treasury.security.UserNotFoundException;
import com.ge.treasury.security.data.ApplicationRoles;
import com.ge.treasury.security.data.UserPermissions;
import com.ge.treasury.security.wsclient.SecurityUtilServiceLocator;
import com.hydus.wff.core.exception.HWFServiceException;

/**
 * @author madhusudhan.gosula
 *
 */
public class SecurityHelper {
	
	private static final String HWF_DELEGATION_1001 = "HWF.ROUTER.1001";
	private String applicationId;
	private SecurityUtilServiceLocator serviceLocator;
	
	/**
	 * 
	 * @param userId
	 * @return
	 * @throws ICFPException 
	 */
	public List<String> getRoles(String userId, HttpServletRequest request) throws HWFServiceException{
		List<String> result = null;
		try {
			UserPermissions userPermissions = serviceLocator.getSecurityUtilService().getUserPermissions(userId);
			String[] userRoles = parseApplicationRoles(userPermissions);
			if(userRoles != null) {
				result = Arrays.asList(userRoles);
			}
		} catch (RemoteException e) {
			throw new HWFServiceException(HWF_DELEGATION_1001);
		} catch (UserNotFoundException e) {
			request.setAttribute(FAILUREMSG, e.getMessage());
		} catch (ServiceException e) {
			throw new HWFServiceException(HWF_DELEGATION_1001);
		}
		return result;
	}
	/**
	 * 
	 * @param userPermissions
	 * @return
	 */
	private String[] parseApplicationRoles(UserPermissions userPermissions) {
		String[] result = null;
		ApplicationRoles currentApplicationRoles = null;
		for(ApplicationRoles applicationRoles : userPermissions.getApplicationRoles()) {
			if(applicationRoles.getApplicationId().equals(applicationId)) {
				currentApplicationRoles = applicationRoles;
			}
		}
		if(currentApplicationRoles != null) {
			AuthConnClient authConnClient = new AuthConnClient();
			result = authConnClient.parseApplicationRoles(currentApplicationRoles);
		}
		return result;
	}
	
	/**
	 * @param applicationId the applicationId to set
	 */
	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}
	/**
	 * @param serviceLocator the serviceLocator to set
	 */
	public void setServiceLocator(SecurityUtilServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}

}
