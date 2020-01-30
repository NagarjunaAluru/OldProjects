/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: IAPMDetailsManager.java
 * Purpose: IAPMDetailsManager.java used for maintaining All APM Related Details.
 *
 */

package com.ge.aloc.manager.apm;

import java.math.BigInteger;
import java.text.ParseException;
import java.util.List;

import com.ge.aloc.model.APMDetails;
import com.ge.aloc.model.BUCAndADN;
import com.ge.aloc.model.CurrencySetup;
import com.ge.aloc.model.NameValue;
import com.ge.aloc.model.PaymentPeriodDetails;
import com.hydus.hwf.exceptions.HWFServiceException;


/**
 * @author Ramakrishna.s
 *
 */
public interface IAPMDetailsManager {

	/**
	 * Method to get the BUCADNDetails for all requests
	 * @param apmConfigId
	 * @return 
	 * @throws HWFServiceException
	 */
	APMDetails getAllBUCADNDetails(BigInteger apmConfigId) throws HWFServiceException;	

	/**
	 * Method to get the BUCADNDetails for selected BUC & ADN combination
	 * @param invalidBUC
	 * @param invalidADN
	 * @param apmConfigId
	 * @return 
	 * @throws HWFServiceException
	 */
	APMDetails getBUCADNDetails(String invalidBUC,String invalidADN,BigInteger apmConfigId) throws HWFServiceException;

	/**
	 * Method to update the selected request BUCADNDetails
	 * @param bucAdnList
	 * @param updatedBUCVal
	 * @param updatedADNVal
	 * @param apmConfigId
	 * @throws HWFServiceException
	 */
	void updateBUCADNDetails(List<BUCAndADN> bucAdnList,String updatedBUCVal,String updatedADNVal,BigInteger apmConfigId) throws HWFServiceException;

	/**
	 *  Method to open FeePaymentRun screen
	 * @return 
	 * @throws HWFServiceException
	 */
	APMDetails openFeePaymentRun() throws HWFServiceException;

	/**
	 *  Method to get the Calculate Fees Details
	 * @return 
	 * @param apmDetails
	 * @throws HWFServiceException
	 */
	APMDetails getCalculateFeesDetails(APMDetails apmDetails) throws HWFServiceException;

	/**
	 * This Method is used to get the expand CalculateFeeTable Details
	 * @return 
	 * @param apmDetails
	 * @param bankMDMId
	 * @param bankName
	 * @throws HWFServiceException
	 */
	APMDetails expandFeeTableDetails(APMDetails apmDetails,String bankMDMId,String bankName) throws HWFServiceException;

	/**
	 * Method to get APMDetails to show fee summary details
	 * @return 
	 * @param apmDetails
	 * @throws HWFServiceException
	 */
	APMDetails getFeeSummaryDetails(APMDetails apmDetails) throws HWFServiceException;

	/**
	 * Method to get APMDetails to show fee summary details in FeeHistory page
	 * @return 
	 * @throws HWFServiceException
	 */
	APMDetails getFHFeeSummaryDetails() throws HWFServiceException;

	/**
	 *  Method to open PaymentPeriod screen
	 * @return 
	 * @throws HWFServiceException
	 */
	APMDetails openPaymentPeriod() throws HWFServiceException;

	/**
	 *  Method to save Payment Period
	 * @return
	 * @param firstpaymentperiod
	 * @throws HWFServiceException
	 */
	APMDetails savePaymentPeriod(PaymentPeriodDetails firstpaymentperiod) throws HWFServiceException,ParseException;

	/**
	 * Method to save two Payment Period rows
	 * @return
	 * @throws HWFServiceException
	 * @throws ParseException
	 */
	APMDetails savePaymentPeriodTwoRow() throws HWFServiceException,ParseException;

	/**method to cancel the payment period row
	 * @param paymentperiodList
	 * @param apmConfigID
	 * @return
	 */
	PaymentPeriodDetails cancel(List<PaymentPeriodDetails> paymentperiodList,String apmConfigID);

	/* --------------------------------------------------------------------------------------------------------------------------------------
	 * 								FX Rate History & Currency Setup Related Methods
	 ---------------------------------------------------------------------------------------------------------------------------------------- */
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
	List<BigInteger> getYearlist() throws HWFServiceException;

	/**
	 * Method to open the FX Rate History Page 
	 * @return 
	 * @throws HWFServiceException
	 */
	List<NameValue> openFXRateHistory() throws HWFServiceException, ParseException;

	/**
	 * Method to get the FX Rates  
	 * @return 
	 * @param feePeriodId
	 * @throws HWFServiceException
	 */
	APMDetails getFxRates(String feePeriodId) throws HWFServiceException;

	/**
	 * Method to download the FX Rates  
	 * @return 
	 * @throws HWFServiceException
	 */
	APMDetails downloadFxRates(String feePeriodId) throws HWFServiceException;

	/**
	 * Method to Save Currency Setup Row 
	 * @return 
	 * @param currencySetup
	 * @throws HWFServiceException
	 */
	APMDetails saveCurrencySetRow(CurrencySetup currencySetup) throws HWFServiceException;

	/**
	 * Method to Delete Currency Setup Row 
	 * @return 
	 * @throws HWFServiceException
	 */
	APMDetails deleteCurrencyRow() throws HWFServiceException;

	/**
	 * Method to get the Fee payment run values for Download to CSV
	 * @return
	 * @param apmDetails
	 * @throws HWFServiceException
	 */
	APMDetails getFeeRunDownloadToCSV(APMDetails apmDetails) throws HWFServiceException;
	
	/**
	 * Method to get the Credit And Carry Overs Export
	 * @return
	 * @param apmDetails
	 * @throws HWFServiceException
	 */
	APMDetails getCreditAndCarryOverDetails(APMDetails apmDetails) throws HWFServiceException;
	
	/**
	 * Method to send CSV file
	 * @param apmDetails
	 * @param csvFile
	 * @throws HWFServiceException
	 */
	APMDetails saveCSVFile(APMDetails apmDetails, byte[] csvFile) throws HWFServiceException;
	
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
