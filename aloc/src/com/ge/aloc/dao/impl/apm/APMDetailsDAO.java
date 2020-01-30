/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ApmDetailsDAO.java
 * Purpose: ApmDetailsDAO.java for maintaining All APM Related Details.
 *
 */

package com.ge.aloc.dao.impl.apm;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.ge.aloc.OpCode;
import com.ge.aloc.ServiceClientSupport;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.dao.apm.IAPMDetailsDAO;
import com.ge.aloc.model.APMDetails;
import com.ge.aloc.model.FXRateHistory;
import com.ge.aloc.model.FXRateHistoryAndCurrencySetup;
import com.ge.aloc.model.FeePeriodDetails;
import com.ge.aloc.model.FeeRequestSummary;
import com.ge.aloc.model.FeeSummaryDetails;
import com.ge.aloc.model.MsgHeader;
import com.ge.aloc.util.ALOCCommonHelper;
import com.hydus.hwf.exceptions.HWFServiceException;


/**
 * @author Ramakrishna.s
 *
 */

public class APMDetailsDAO extends ServiceClientSupport implements IAPMDetailsDAO {


	/**
	 * Method to get the BUCADNDetails for all requests
	 * @param apmDetails
	 * @return APMDetails
	 * @throws HWFServiceException
	 */
	public APMDetails getAllBUCADNDetails(APMDetails apmDetails)
			throws HWFServiceException {
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.GETBUCADN.getOperationCode());
		apmDetails.setMsgHeader(msgHeader);
		apmDetails = serviceClient.invokeService(OpCode.APMDETAILS.getOperationCode(), apmDetails, APMDetails.class);
		return apmDetails;
	}

	/**
	 * Method to get the BUCADNDetails for selected BUC & ADN combination
	 * @param apmDetails
	 * @return APMDetails
	 * @throws HWFServiceException
	 */
	public APMDetails getBUCADNDetails(APMDetails apmDetails)
			throws HWFServiceException {
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.GETLISTBYBUCADN.getOperationCode());
		apmDetails.setMsgHeader(msgHeader);
		apmDetails = serviceClient.invokeService(OpCode.APMDETAILS.getOperationCode(), apmDetails, APMDetails.class);
		return apmDetails;
	}

	/**
	 * Method to update the selected request BUCADNDetails
	 * @param apmDetails
	 * @throws HWFServiceException
	 */
	public void updateBUCADNDetails(APMDetails apmDetails)
			throws HWFServiceException {
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.UPDATEBUCADN.getOperationCode());
		apmDetails.setMsgHeader(msgHeader);
		apmDetails = serviceClient.invokeService(OpCode.APMDETAILS.getOperationCode(), apmDetails, APMDetails.class);
	}

	/**
	 * Method to invoke the Service for FeePaymentRun Details
	 * @return apmDetails
	 * @throws HWFServiceException
	 */
	public APMDetails openFeePaymentRun() throws HWFServiceException {
		APMDetails apmDetails = new APMDetails();

		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.GETFEEPAYMENTRUN.getOperationCode());
		apmDetails.setMsgHeader(msgHeader);

		apmDetails = serviceClient.invokeService(OpCode.APMDETAILS.getOperationCode(), apmDetails, APMDetails.class);
		return apmDetails;
	}

	/**
	 * Method to invoke the Service for CalculateFee Details
	 * @return apmDetails
	 * @param apmDetails
	 * @throws HWFServiceException
	 */
	public APMDetails getCalculateFeesDetails(APMDetails apmDetails) throws HWFServiceException {

		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.GETFEEPAYMENTRUN.getOperationCode());
		apmDetails.setMsgHeader(msgHeader);
		apmDetails.getFeePaymentRunDetails().setOpCode(OpCode.CALCULATEFEE.getOperationCode());

		apmDetails = serviceClient.invokeService(OpCode.APMDETAILS.getOperationCode(), apmDetails, APMDetails.class);
		return apmDetails;
	}	

	/**
	 * This Method is used to invoke the Service for CalculateFee expand rows Details
	 * @return apmDetails
	 * @param apmDetails
	 * @throws HWFServiceException
	 */
	public APMDetails expandFeeTableDetails(APMDetails apmDetails) throws HWFServiceException {
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.GETFEEPAYMENTRUN.getOperationCode());
		apmDetails.setMsgHeader(msgHeader);
		apmDetails.getFeePaymentRunDetails().setOpCode(OpCode.GETREQUESTSBYBANK.getOperationCode());

		apmDetails = serviceClient.invokeService(OpCode.APMDETAILS.getOperationCode(), apmDetails, APMDetails.class);
		return apmDetails;
	}

	/**
	 * Method to get APMDetails to show fee summary details
	 * @return APMDetails
	 * @param apmDetails
	 * @throws HWFServiceException
	 */
	public APMDetails getFeeSummaryDetails(APMDetails apmDetails) throws HWFServiceException {
		HttpServletRequest request = ServletActionContext.getRequest();
		FeeSummaryDetails feeSummary = new FeeSummaryDetails();
		FeeRequestSummary feeReqSummary = new FeeRequestSummary();
		feeReqSummary.setRequestId(new BigInteger(request.getParameter(ALOCConstants.ALOC_RECORD_NUMBER)));
		feeSummary.setFeeRequestSummary(feeReqSummary);
		apmDetails.setFeeSummaryDetails(feeSummary);
		apmDetails.getFeePaymentRunDetails().setOpCode(null);
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.GETFEESUMMARY.getOperationCode());
		apmDetails.setMsgHeader(msgHeader);

		apmDetails = serviceClient.invokeService(OpCode.APMDETAILS.getOperationCode(), apmDetails, APMDetails.class);	
		return apmDetails;
	}

	/**
	 * Method to invoke the Service for PaymentPeriod Details
	 * @return apmDetails
	 * @throws HWFServiceException
	 */
	public APMDetails openPaymentPeriod() throws HWFServiceException {
		APMDetails apmDetails = new APMDetails();

		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.GETPAYMENTPERIODS.getOperationCode());
		apmDetails.setMsgHeader(msgHeader);
		apmDetails = serviceClient.invokeService(OpCode.APMDETAILS.getOperationCode(), apmDetails, APMDetails.class);
		return apmDetails;
	}

	/**
	 * Method to save the payment Period details
	 * @return apmDetails
	 * @param apmDetails
	 * @throws HWFServiceException
	 */
	public APMDetails savePaymentPeriod(APMDetails apmDetails)
			throws HWFServiceException {	
		BigInteger apmConfigId = apmDetails.getPaymentPeriodDetails().get(ALOCConstants.PAYMENTPERIOD_BASE_INDEX).getAPMConfigID();
		if(apmConfigId!=null && !(ALOCConstants.EMPTY_STRING.equals(apmConfigId))){
			apmDetails.getPaymentPeriodDetails().get(ALOCConstants.PAYMENTPERIOD_BASE_INDEX).setOpCode(ALOCConstants.UPDATE);
		}else{
			apmDetails.getPaymentPeriodDetails().get(ALOCConstants.PAYMENTPERIOD_BASE_INDEX).setOpCode(ALOCConstants.INSERT);
		}

		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.GETPAYMENTPERIODS.getOperationCode());
		apmDetails.setMsgHeader(msgHeader);
		apmDetails = serviceClient.invokeService(OpCode.APMDETAILS.getOperationCode(), apmDetails, APMDetails.class);
		return apmDetails;
	}

	/* -------------------------------------------------------------------------------------------------------------------------------------------
	 * 										FX Rate History & Currency Setup Related Methods
	 -------------------------------------------------------------------------------------------------------------------------------------------- */
	/**
	 * Method to get the Currency Setup Details
	 * @return apmDetails
	 * @throws HWFServiceException
	 */
	public APMDetails getCurrencySetUpDetails() throws HWFServiceException{

		APMDetails apmDetails=new APMDetails();
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.CURRENCYSETUP.getOperationCode());
		apmDetails.setMsgHeader(msgHeader);
		apmDetails = serviceClient.invokeService(OpCode.APMDETAILS.getOperationCode(), apmDetails, APMDetails.class);
		return apmDetails;
	}

	/**
	 * method to get the year list
	 * @return apmDetails
	 * @throws HWFServiceException
	 */
	public APMDetails getYearlist() throws HWFServiceException{
		APMDetails apmDetails=new APMDetails();
		FXRateHistoryAndCurrencySetup fxAndCurrencySetup=new FXRateHistoryAndCurrencySetup();
		FXRateHistory fxRatehistory=new FXRateHistory();
		fxRatehistory.setOpCode(ALOCConstants.GETYEARS);
		fxAndCurrencySetup.setFXRateHistory(fxRatehistory);
		apmDetails.setFXRateHistoryAndCurrencySetup(fxAndCurrencySetup);	

		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.FXRATEHISTORY.getOperationCode());
		apmDetails.setMsgHeader(msgHeader);
		apmDetails = serviceClient.invokeService(OpCode.APMDETAILS.getOperationCode(), apmDetails, APMDetails.class);
		return apmDetails;
	}

	/**
	 * Method to get APMDetails to show fX rate history periods 
	 * @param FXRateHistory
	 * @return APMDetails
	 * @throws HWFServiceException
	 */
	public APMDetails openFXRateHistory(FXRateHistory fxRatehistory)throws HWFServiceException{
		APMDetails apmDetails=new APMDetails();
		FXRateHistoryAndCurrencySetup fxAndCurrencySetup=new FXRateHistoryAndCurrencySetup();
		fxRatehistory.setOpCode(ALOCConstants.FILTERPERIODS);
		fxAndCurrencySetup.setFXRateHistory(fxRatehistory);
		apmDetails.setFXRateHistoryAndCurrencySetup(fxAndCurrencySetup);

		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.FXRATEHISTORY.getOperationCode());
		apmDetails.setMsgHeader(msgHeader);
		apmDetails = serviceClient.invokeService(OpCode.APMDETAILS.getOperationCode(), apmDetails, APMDetails.class);
		return apmDetails;
	}


	/**
	 * Method to get the FX Rates  
	 * @return apmDetails
	 * @param feePeriodId
	 * @throws HWFServiceException
	 */
	public APMDetails getFxRates(BigInteger feePeriodId) throws HWFServiceException{
		APMDetails apmDetails=new APMDetails();	
		List<FeePeriodDetails> feePeriodDetails=new ArrayList<FeePeriodDetails>();
		FeePeriodDetails FeePeriod=new FeePeriodDetails();
		FeePeriod.setAPMConfigID(feePeriodId);
		feePeriodDetails.add(FeePeriod);
		FXRateHistoryAndCurrencySetup fXRateHistoryAndCurrencySetup=new FXRateHistoryAndCurrencySetup();
		FXRateHistory fxRateHistory=new FXRateHistory();
		fxRateHistory.setFeePeriodDetails(feePeriodDetails);
		fXRateHistoryAndCurrencySetup.setFXRateHistory(fxRateHistory);
		apmDetails.setFXRateHistoryAndCurrencySetup(fXRateHistoryAndCurrencySetup);

		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.GETFXRATES.getOperationCode());
		apmDetails.setMsgHeader(msgHeader);
		apmDetails = serviceClient.invokeService(OpCode.APMDETAILS.getOperationCode(), apmDetails, APMDetails.class);
		return apmDetails;
	}

	/**
	 * Method to download the FX Rates  
	 * @return apmDetails
	 * @throws HWFServiceException
	 */
	public APMDetails downloadFxRates(BigInteger feePeriodId) throws HWFServiceException{
		APMDetails apmDetails=new APMDetails();	
		List<FeePeriodDetails> feePeriodDetails=new ArrayList<FeePeriodDetails>();
		FeePeriodDetails FeePeriod=new FeePeriodDetails();
		FeePeriod.setAPMConfigID(feePeriodId);
		feePeriodDetails.add(FeePeriod);
		FXRateHistoryAndCurrencySetup fXRateHistoryAndCurrencySetup=new FXRateHistoryAndCurrencySetup();
		FXRateHistory fxRateHistory=new FXRateHistory();
		fxRateHistory.setFeePeriodDetails(feePeriodDetails);
		fxRateHistory.setOpCode(ALOCConstants.DOWNLOADFXRATES);
		fXRateHistoryAndCurrencySetup.setFXRateHistory(fxRateHistory);
		apmDetails.setFXRateHistoryAndCurrencySetup(fXRateHistoryAndCurrencySetup);	
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.FXRATEHISTORY.getOperationCode());
		apmDetails.setMsgHeader(msgHeader);
		apmDetails = serviceClient.invokeService(OpCode.APMDETAILS.getOperationCode(), apmDetails, APMDetails.class);
		return apmDetails;
	}

	/**
	 * Method to Save the Currency Setup Row  
	 * @return apmDetails
	 * @param apmDetails
	 * @throws HWFServiceException
	 */
	public APMDetails saveCurrencySetRow(APMDetails apmDetails) throws HWFServiceException{

		BigInteger currencyConfigId = apmDetails.getFXRateHistoryAndCurrencySetup().getCurrencySetups().get(ALOCConstants.CURRENCYSETUP_BASE_INDEX).getCurrencyConfigId();
		if(currencyConfigId!=null && !(ALOCConstants.EMPTY_STRING.equals(currencyConfigId))){
			apmDetails.getFXRateHistoryAndCurrencySetup().getCurrencySetups().get(ALOCConstants.CURRENCYSETUP_BASE_INDEX).setOpCode(ALOCConstants.UPDATE);
		}else{
			apmDetails.getFXRateHistoryAndCurrencySetup().getCurrencySetups().get(ALOCConstants.CURRENCYSETUP_BASE_INDEX).setOpCode(ALOCConstants.INSERT);
		}
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.CURRENCYSETUP.getOperationCode());
		apmDetails.setMsgHeader(msgHeader);
		apmDetails = serviceClient.invokeService(OpCode.APMDETAILS.getOperationCode(), apmDetails, APMDetails.class);

		return apmDetails;
	}

	/**
	 * Method to Delete the Currency Setup Row  
	 * @return apmDetails
	 * @param apmDetails
	 * @throws HWFServiceException
	 */
	public APMDetails deleteCurrencyRow(APMDetails apmDetails) throws HWFServiceException{
		apmDetails.getFXRateHistoryAndCurrencySetup().getCurrencySetups().get(ALOCConstants.CURRENCYSETUP_BASE_INDEX).setOpCode(ALOCConstants.DELETE);
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.CURRENCYSETUP.getOperationCode());
		apmDetails.setMsgHeader(msgHeader);
		apmDetails = serviceClient.invokeService(OpCode.APMDETAILS.getOperationCode(), apmDetails, APMDetails.class);
		return apmDetails;
	}

	/**
	 * Method to get the Fee payment run values for Download to CSV
	 * @return apmDetails
	 * @param apmDetails
	 * @throws HWFServiceException
	 */
	public APMDetails getFeeRunDownloadToCSV(APMDetails apmDetails) throws HWFServiceException{
		apmDetails.getFeePaymentRunDetails().setOpCode(OpCode.FEEPAYRUNDOWNLOAD.getOperationCode());
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.GETFEEPAYMENTRUN.getOperationCode());
		apmDetails.setMsgHeader(msgHeader);
		apmDetails = serviceClient.invokeService(OpCode.APMDETAILS.getOperationCode(), apmDetails, APMDetails.class);
		return apmDetails;
	}
	
	/**
	 * Method to get the Credit And carry over values
	 * @return apmDetails
	 * @param apmDetails
	 * @throws HWFServiceException
	 */
	public APMDetails getCreditAndCarryOverDetails(APMDetails apmDetails) throws HWFServiceException{
		apmDetails.getFeePaymentRunDetails().setOpCode(OpCode.CREDITSANDCARRYOVERS.getOperationCode());
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.GETFEEPAYMENTRUN.getOperationCode());
		apmDetails.setMsgHeader(msgHeader);
		apmDetails = serviceClient.invokeService(OpCode.APMDETAILS.getOperationCode(), apmDetails, APMDetails.class);
		return apmDetails;
	}
	
	/**
	 * Method to send Invoice call to a third party
	 * @return apmDetails
	 * @param apmDetails
	 * @throws HWFServiceException
	 */
	public APMDetails sendInvoices(APMDetails apmDetails) throws HWFServiceException{
		apmDetails.getFeePaymentRunDetails().setOpCode(OpCode.SENDINVOICES.getOperationCode());
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.GETFEEPAYMENTRUN.getOperationCode());
		apmDetails.setMsgHeader(msgHeader);
		apmDetails = serviceClient.invokeService(OpCode.APMDETAILS.getOperationCode(), apmDetails, APMDetails.class);
		return apmDetails;
	}

	/**
	 * Method to send web cash files call to a third party
	 * @return apmDetails
	 * @param apmDetails
	 * @throws HWFServiceException
	 */
	public APMDetails sendWebCashFiles(APMDetails apmDetails) throws HWFServiceException{
		apmDetails.getFeePaymentRunDetails().setOpCode(OpCode.SENDWEBCASHFILES.getOperationCode());
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.GETFEEPAYMENTRUN.getOperationCode());
		apmDetails.setMsgHeader(msgHeader);
		apmDetails = serviceClient.invokeService(OpCode.APMDETAILS.getOperationCode(), apmDetails, APMDetails.class);
		return apmDetails;
	}

	/**
	 * Method to Complete Payment call to a third party
	 * @return apmDetails
	 * @param apmDetails
	 * @throws HWFServiceException
	 */
	public APMDetails completePayment(APMDetails apmDetails) throws HWFServiceException{
		apmDetails.getFeePaymentRunDetails().setOpCode(OpCode.COMPLETEPAYMENT.getOperationCode());
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.GETFEEPAYMENTRUN.getOperationCode());
		apmDetails.setMsgHeader(msgHeader);
		apmDetails = serviceClient.invokeService(OpCode.APMDETAILS.getOperationCode(), apmDetails, APMDetails.class);
		return apmDetails;
	}

	public APMDetails saveAPMFeePaymentAttachments(APMDetails apmDetails)
			throws HWFServiceException {
		apmDetails.getFeePaymentRunDetails().setOpCode(OpCode.WEBCASHFILE.getOperationCode());
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.GETFEEPAYMENTRUN.getOperationCode());
		apmDetails.setMsgHeader(msgHeader);
		apmDetails = serviceClient.invokeService(OpCode.APMDETAILS.getOperationCode(), apmDetails, APMDetails.class);		
		return apmDetails;
	}

}
