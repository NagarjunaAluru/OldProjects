/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: IBusinessUnitCodeManager.java
 * Purpose: 
 */
package com.ge.aloc.manager.admin;

import com.ge.aloc.model.BusinessUnitCode;
import com.ge.aloc.model.BusinessUnitCodeList;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author Rajat-Hydus
 *
 */
public interface IBlockBUCManager {

	/**
	 * Method to get the list of already blocked BUC's
	 * @return BusinessUnitCodeList
	 * @throws HWFServiceException
	 */
	public BusinessUnitCodeList open() throws HWFServiceException ;	

	/**
	 * Method to search the BUC and get the associated ADN's 
	 * @param businessUnitCode
	 * @return BusinessUnitCodeList
	 * @throws HWFServiceException
	 */
	public BusinessUnitCodeList search(BusinessUnitCode businessUnitCode) throws HWFServiceException ;	


	/**
	 * Method to validate the BUC
	 * @param buc
	 * @return BusinessUnitCode
	 * @throws HWFServiceException
	 */
	public BusinessUnitCode validateBUC(String buc) throws HWFServiceException ;	

	/**
	 * Method to block the selected BUC and ADN combination
	 * @param businessUnitCode
	 * @return BusinessUnitCode
	 * @throws HWFServiceException
	 */
	public BusinessUnitCode blockBUC(BusinessUnitCode businessUnitCode,String reasonForBlock) throws HWFServiceException;

	/**
	 * Method to unblock the selected BUC and ADN combination
	 * @param businessUnitCode
	 * @return BusinessUnitCode
	 * @throws HWFServiceException
	 */
	public BusinessUnitCode unBlockBUC(BusinessUnitCode businessUnitCode) throws HWFServiceException;
}
