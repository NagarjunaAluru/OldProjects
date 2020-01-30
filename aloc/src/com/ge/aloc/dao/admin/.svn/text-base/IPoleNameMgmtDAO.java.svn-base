/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: IPoleNameMgmtDAO.java
 * Purpose: IPoleNameMgmtDAO used for maintaining Surety Names.
 *
 */
package com.ge.aloc.dao.admin;

import com.ge.aloc.IServiceClientAware;
import com.ge.aloc.model.PoleNameList;
import com.ge.aloc.model.PoleNameManagement;
import com.hydus.hwf.exceptions.HWFServiceException;
/**
 * @author Rajat-Hydus
 *
 */
public interface IPoleNameMgmtDAO extends IServiceClientAware {

	/**
	 * This method is used to open the pole management records
	 * @param poleMaster
	 * @return
	 * @throws HWFServiceException
	 */
	public PoleNameList open(PoleNameManagement poleNameMgmt) throws HWFServiceException;
	/**
	 * This method is used to insert the pole management record.
	 * @param poleMaster
	 * @return
	 * @throws HWFServiceException
	 */
	public PoleNameManagement insert(PoleNameManagement poleNameMgmt) throws HWFServiceException;
	/**
	 * This method is used to update the pole management record.
	 * @param poleMaster
	 * @return
	 * @throws HWFServiceException
	 */
	public PoleNameManagement update(PoleNameManagement poleNameMgmt) throws HWFServiceException;
	/**
	 * This method is used to get the countries
	 * @param poleMaster
	 * @return
	 * @throws HWFServiceException
	 */
	public PoleNameList getCountries(PoleNameManagement poleNameMgmt) throws HWFServiceException;
}
