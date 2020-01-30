/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: IAPMDetailsDAO.java
 * Purpose: IAPMDetailsDAO.java for maintaining All APM Related Details.
 *
 */

package com.ge.aloc.dao.apm;

import java.math.BigInteger;

import com.ge.aloc.model.APMDetails;
import com.ge.aloc.model.FXRateHistory;
import com.hydus.hwf.exceptions.HWFServiceException;


/**
 * @author Ramakrishna.s
 *
 */
public interface IAPMDetailsDAO {

	/**
	 * Method to get the BUCADNDetails for all requests
	 * @param apmDetails
	 * @return APMDetails
	 * @throws HWFServiceException
	 */
	APMDetails getAllBUCADNDetails(APMDetails apmDetails) throws HWFServiceException;

	/**
	 * Method to get the BUCADNDetails for selected BUC & ADN combination
	 * @param apmDetails
	 * @return APMDetails
	 * @throws HWFServiceException
	 */
	APMDetails getBUCADNDetails(APMDetails apmDetails) throws HWFServiceException;

	/**
	 * Method to update the selected request BUCADNDetails
	 * @param apmDetails
	 * @throws HWFServiceException
	 */
	void updateBUCADNDetails(APMDetails apmDetails) throws HWFServiceException;

	/**
	 * Method to invoke the Service for FeePaymentRun Details
	 * @return apmDetails
	 * @throws HWFServiceException
	 */
	APMDetails openFeePaymentRun() throws HWFServiceException;

	/**
	 * Method to invoke the Service for CalculateFee Details
	 * @return apmDetails expandFeeTableDetails
	 * @param apmDetails
	 * @throws HWFServiceException
	 */
	APMDetails getCalculateFeesDetails(APMDetails apmDetails) throws HWFServiceException;

	/**
	 * Method to invoke the Service for CalculateFee expand row details Details
	 * @return apmDetails
	 * @throws HWFServiceException
	 */
	APMDetails expandFeeTableDetails(APMDetails apmDetails) throws HWFServiceException;

	/**
	 * Method to get APMDetails to show fee summary details
	 * @return APMDetails
	 * @param apmDetails
	 * @throws HWFServiceException
	 */
	APMDetails getFeeSummaryDetails(APMDetails apmDetails)throws HWFServiceException;

	/**
	 * Method to invoke the Service for PaymentPeriod Details
	 * @return apmDetails
	 * @throws HWFServiceException
	 */
	APMDetails openPaymentPeriod() throws HWFServiceException;


	/**
	 *  Method to save Payment Period
	 * @return
	 * @throws HWFServiceException
	 */
	APMDetails savePaymentPeriod(APMDetails apmDetails) throws HWFServiceException;
	
	
	/**
	 *  Method to save Payment Period webcash/ibs invoice attachments
	 * @return
	 * @throws HWFServiceException
	 */
	APMDetails saveAPMFeePaymentAttachments(APMDetails apmDetails) throws HWFServiceException;


	/* -------------------------------------------------------------------------------------------------------------------------------------------
	 * 										FX Rate History & Currency Setup Related Methods
	 -------------------------------------------------------------------------------------------------------------------------------------------- */
	/**
	 * Method to get the Currency Setup Details
	 * @return
	 * @throws HWFServiceException
	 */
	APMDetails getCurrencySetUpDetails() throws HWFServiceException;

	/**method to get the year list
	 * @return
	 * @throws HWFServiceException
	 */
	APMDetails getYearlist() throws HWFServiceException;

	/**
	 * Method to open the FX Rate History Page 
	 * @param FXRateHistory
	 * @return 
	 * @throws HWFServiceException
	 */
	APMDetails openFXRateHistory(FXRateHistory fxRatehistory) throws HWFServiceException;

	/**
	 * Method to get the FX Rates  
	 * @return 
	 * @throws HWFServiceException
	 */
	APMDetails getFxRates(BigInteger feePeriodId) throws HWFServiceException;

	/**
	 * Method to download the FX Rates  
	 * @return 
	 * @throws HWFServiceException
	 */
	APMDetails downloadFxRates(BigInteger feePeriodId) throws HWFServiceException;

	/**
	 * Method to Save the Currency Setup Row 
	 * @return 
	 * @throws HWFServiceException
	 */
	APMDetails saveCurrencySetRow(APMDetails apmDetails) throws HWFServiceException;

	/**
	 * Method to Delete the Currency Setup Row 
	 * @return 
	 * @throws HWFServiceException
	 */
	APMDetails deleteCurrencyRow(APMDetails apmDetails) throws HWFServiceException;

	/**
	 * 
	 * Method to get the Fee payment run values for Download to CSV
	 * @return
	 * @param apmDetails
	 * @throws HWFServiceException
	 */
	APMDetails getFeeRunDownloadToCSV(APMDetails apmDetails) throws HWFServiceException;

	/**
	 * 
	 * Method to get the Fee payment run values for Download to CSV
	 * @return
	 * @param apmDetails
	 * @throws HWFServiceException
	 */
	APMDetails getCreditAndCarryOverDetails(APMDetails apmDetails) throws HWFServiceException;

	/**
	 * Method to send Invoice call to a third party
	 * @param apmDetails
	 * @throws HWFServiceException
	 */
	APMDetails sendInvoices(APMDetails apmDetails) throws HWFServiceException;

	/**
	 * Method to send web cash files call to a third party
	 * @param apmDetails
	 * @throws HWFServiceException
	 */
	APMDetails sendWebCashFiles(APMDetails apmDetails) throws HWFServiceException;

	/**
	 * Method to Complete Payment call to a third party
	 * @param apmDetails
	 * @throws HWFServiceException
	 */
	APMDetails completePayment(APMDetails apmDetails) throws HWFServiceException;

}
