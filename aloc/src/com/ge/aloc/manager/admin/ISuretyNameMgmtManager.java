/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ISuretyNameMgmtManager.java
 * Purpose: ISuretyNameMgmtManager used for Surety Name Management operations and user actions.
 */
package com.ge.aloc.manager.admin;

import java.util.List;

import com.ge.aloc.model.SuretyMaster;
import com.ge.aloc.model.SuretyMasterCollection;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author Rajat-Hydus
 *
 */
public interface ISuretyNameMgmtManager {

	/**
	 * Method to get the available SuretyCompany Names
	 * @return
	 * @throws HWFServiceException
	 */
	public SuretyMasterCollection open() throws HWFServiceException ;


	/**
	 * Method to add or update given SuretyCompany Name
	 * @param suretyMaster
	 * @return
	 * @throws HWFServiceException
	 */
	public SuretyMaster update(SuretyMaster suretyMaster) throws HWFServiceException ;

	/**
	 * Method to cancel the SuretyCompany Name changes
	 * @param suretyMasterList
	 * @param suretyId
	 * @return
	 */
	public SuretyMaster cancel(List<SuretyMaster> suretyMasterList,String suretyId);

	/**
	 * Method to get the Surety Comp Name Row value for given suretyId
	 * @return 
	 * @throws HWFServiceException
	 */
	public SuretyMasterCollection getSuretyDetailsForSelSurety(SuretyMasterCollection suretyMasterCollection,SuretyMaster suretyMaster) throws HWFServiceException;
}
