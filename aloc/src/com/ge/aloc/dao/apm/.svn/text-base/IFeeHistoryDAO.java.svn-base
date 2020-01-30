/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: IFeeHistoryDAO.java
 * Purpose: IFeeHistoryDAO.java used for maintaining Surety Names.
 *
 */

package com.ge.aloc.dao.apm;

import com.ge.aloc.model.APMDetails;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author Rajat-Hydus
 *
 */
public interface IFeeHistoryDAO {

	/**
	 * Method to get the Default fee history Details - Top Level View
	 * @return
	 * @throws HWFServiceException
	 */
	public APMDetails searchFeeHistory() throws HWFServiceException;

	/**
	 * This Method is used to get FeeHistory Invoice file
	 * @return
	 * @param apmDetails
	 * @throws HWFServiceException
	 */
	public APMDetails exportInvoiceFeeHistory(APMDetails apmDetails) throws HWFServiceException;

}
