/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: IPoleNameMgmtManager.java
 * Purpose: IPoleNameMgmtManager used for Surety Name Management operations and user actions.
 */
package com.ge.aloc.manager.admin;

import java.util.Map;

import com.ge.aloc.model.PoleNameList;
import com.ge.aloc.model.PoleNameManagement;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author Rajat-Hydus
 *
 */
public interface IPoleNameMgmtManager {

	/**
	 * Method to open the update Pole
	 * @return
	 * @throws HWFServiceException
	 */
	public PoleNameList open() throws HWFServiceException ;
	/**
	 * Method to cancel the update Pole
	 * @param poleMaster
	 * @param selectedCountriesCodes
	 * @return
	 * @throws HWFServiceException
	 */
	public PoleNameManagement update(PoleNameManagement poleNameMgmt,String selectedCountriesCodes) throws HWFServiceException ;
	/**
	 * Method to cancel the get available countries
	 * @param poleMaster
	 * @return
	 * @throws HWFServiceException
	 */
	public Map<String, String> getAvailableCountries(PoleNameManagement poleNameMgmt) throws HWFServiceException;
}
