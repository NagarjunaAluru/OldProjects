/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: IFeeHistoryManager.java
 * Purpose: IFeeHistoryManager.java used for maintaining Surety Names.
 *
 */

package com.ge.aloc.manager.apm;

import com.ge.aloc.model.APMDetails;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author Rajat-Hydus
 *
 */
public interface IFeeHistoryManager {

	/**
	 * Method to get the Default fee history Details - Top Level View
	 * @return
	 * @throws HWFServiceException
	 */
	public APMDetails searchFeeHistory() throws HWFServiceException ;

	/**
	 * This Method is used to get FeeHistory Invoice file
	 * @return
	 * @param alocRecNos
	 * @param paymentIds
	 * @throws HWFServiceException
	 */
	public APMDetails exportInvoiceFeeHistory(String alocRecNos,String paymentIds) throws HWFServiceException ;


}
