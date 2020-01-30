/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: IUserOperationsManager.java
 * Purpose: IUserOperationsManager used for the all external user operations
 */
package com.ge.aloc.ext.manager;

import java.util.List;

import com.ge.aloc.ext.UserOperationException;
import com.ge.aloc.model.EASDetails;
import com.ge.aloc.model.LandingPageDtls;
import com.hydus.hwf.exceptions.HWFServiceException;
import com.hydus.hwf.security.auth.principals.UserPrincipal;

/**
 * This is the specification for all external user management.
 * 
 * @author chaitanya.n
 */
public interface IUserOperationsManager {

	String CTX_KEY = IUserOperationsManager.class.getName();

	/**
	 * Returns organisation id of the application.
	 * 
	 * @return
	 */
	String getEASOrgId();

	/**
	 * This method creates the user in EAS.
	 * 
	 * @param userDetails
	 * @param password
	 * @param conformPassword
	 * @throws UserOperationException
	 */
	void createUser(EASDetails userDetails, char[] password) throws UserOperationException, HWFServiceException;

	/**
	 * This method Sets the user Id and One Time Password of the user by email.
	 * 
	 * @param email
	 * @return
	 * @throws UserOperationException
	 */
	void forgotUserIdOrPassword(String email) throws UserOperationException, HWFServiceException;

	/**
	 * This method resets the user password after validating the One Time Password.
	 * 
	 * @param password
	 * @throws UserOperationException
	 */
	void resetPassword(String userId, char[] otp, char[] password) throws UserOperationException;

	/**
	 * This method fetches the user information based on userName.
	 * 
	 * @param userName
	 * @return
	 * @throws UserOperationException
	 * @throws HWFServiceException
	 */
	UserPrincipal getUserPrincipal(String userName) throws UserOperationException, HWFServiceException;


	/**
	 * This method is used to get landing page details.
	 * 
	 * @param userRoles
	 * @return
	 * @throws HWFServiceException
	 */
	LandingPageDtls getLandingPageDetails(List<String> userRoles) throws HWFServiceException;


}
