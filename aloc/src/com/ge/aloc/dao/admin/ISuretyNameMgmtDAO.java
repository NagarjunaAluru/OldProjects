/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ISuretyNameMgmtDAO.java
 * Purpose: ISuretyNameMgmtDAO used for maintaining Surety Names.
 *
 */
package com.ge.aloc.dao.admin;

import com.ge.aloc.IServiceClientAware;
import com.ge.aloc.model.SuretyMaster;
import com.ge.aloc.model.SuretyMasterCollection;
import com.hydus.hwf.exceptions.HWFServiceException;
/**
 * @author Rajat-Hydus
 *
 */
public interface ISuretyNameMgmtDAO extends IServiceClientAware {

	/**
	 * Method to get the available SuretyCompany Names
	 * @return
	 * @throws HWFServiceException
	 */
	public SuretyMasterCollection open(SuretyMaster suretyMaster) throws HWFServiceException;

	/**
	 * Method to add or update given SuretyCompany Name
	 * @param suretyMaster
	 * @return
	 * @throws HWFServiceException
	 */
	public SuretyMaster update(SuretyMaster suretyMaster) throws HWFServiceException;
}
