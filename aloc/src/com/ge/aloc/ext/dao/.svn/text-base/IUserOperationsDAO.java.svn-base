/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: IUserOperationsDAO.java
 * Purpose: IUserOperationsDAO used for the all external user operations
 */
package com.ge.aloc.ext.dao;

import com.ge.aloc.ext.UserOperationException;
import com.ge.aloc.model.EASDetails;
import com.ge.aloc.model.LandingPageDtls;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * This is DAO specification for external user operations.
 * 
 * @author chaitanya.n
 */
public interface IUserOperationsDAO {

	/**
	 * Method to Create New User
	 * @throws HWFServiceException
	 */
	public void createUser(EASDetails easDetails) throws HWFServiceException;

	/**
	 * Method to get external user information by userName.
	 * 
	 * @param userName
	 * @return
	 * @throws HWFServiceException
	 */
	public EASDetails getUser(String userName) throws HWFServiceException, UserOperationException;

	/**
	 * Method to get external user information based on users email.
	 * 
	 * @return
	 * @throws HWFServiceException
	 */
	public EASDetails getUserByEmail(String email) throws HWFServiceException, UserOperationException;

	/**
	 * This method is used to get landing page details
	 * 
	 * @param landingPageDetails
	 * @return
	 */
	public LandingPageDtls getLandingPageDetails() throws HWFServiceException;
}
