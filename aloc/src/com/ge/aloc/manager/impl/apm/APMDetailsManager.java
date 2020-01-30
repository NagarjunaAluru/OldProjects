/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: APMDetailsManager.java
 * Purpose: APMDetailsManager.java used for maintaining All APM Related Details.
 *
 */

package com.ge.aloc.manager.impl.apm;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.ge.aloc.ALOCContext;
import com.ge.aloc.AttachmentType;
import com.ge.aloc.MasterDataFactory;
import com.ge.aloc.OpCode;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.dao.apm.IAPMDetailsDAO;
import com.ge.aloc.exception.ALOCAttachmentException;
import com.ge.aloc.exception.ALOCException;
import com.ge.aloc.manager.IALOCAttachmentManager;
import com.ge.aloc.manager.apm.IAPMDetailsManager;
import com.ge.aloc.model.APMDetails;
import com.ge.aloc.model.Attachment;
import com.ge.aloc.model.BUCAndADN;
import com.ge.aloc.model.BankFeeDetails;
import com.ge.aloc.model.CurrencySetup;
import com.ge.aloc.model.FXRateHistory;
import com.ge.aloc.model.FXRateHistoryAndCurrencySetup;
import com.ge.aloc.model.FeeHistoryDetails;
import com.ge.aloc.model.FeePaymentRunDetails;
import com.ge.aloc.model.FeePeriodDetails;
import com.ge.aloc.model.FullSummary;
import com.ge.aloc.model.MDM.Currency;
import com.ge.aloc.model.NameValue;
import com.ge.aloc.model.PaymentPeriodDetails;
import com.ge.aloc.util.ALOCCommonHelper;
import com.ge.aloc.util.APMDetailsHelper;
import com.hydus.hwf.context.UserContext;
import com.hydus.hwf.exceptions.HWFServiceException;
import com.hydus.hwf.util.StringUtils;


/**
 * @author Ramakrishna.s
 *
 */

public class APMDetailsManager implements IAPMDetailsManager{

	/**
	 * LOGGER
	 */
	private static final Logger LOGGER = Logger.getLogger(APMDetailsManager.class);
	private IAPMDetailsDAO apmDetailsDAO;
	protected IALOCAttachmentManager alocAttachmentManager;

	/**
	 *  Method to open FeePaymentRun screen
	 * @return APMDetails
	 * @throws HWFServiceException
	 */
	public APMDetails openFeePaymentRun() throws HWFServiceException {
		APMDetails apmDetails = apmDetailsDAO.openFeePaymentRun();
		return apmDetails;
	}

	/**
	 * Method to get the Calculate Fee Details
	 * @return APMDetails
	 * @param apmDetails
	 * @throws HWFServiceException
	 */
	public APMDetails getCalculateFeesDetails(APMDetails apmDetails) throws HWFServiceException {
		apmDetails = apmDetailsDAO.getCalculateFeesDetails(apmDetails);
		return apmDetails;
	}

	/**
	 * This Method is used to get the CalculateFeeTable Details
	 * @return APMDetails
	 * @param apmDetails
	 * @param bankMDMId
	 * @param bankName
	 * @throws HWFServiceException
	 */
	public APMDetails expandFeeTableDetails(APMDetails apmDetails,String bankMDMId,String bankName) throws HWFServiceException {
		if(apmDetails != null && StringUtils.isNotBlank(bankMDMId)){
			List<BankFeeDetails> bankLst = new ArrayList<BankFeeDetails>();
			BankFeeDetails bankDetails = new BankFeeDetails();
			bankDetails.setBankMDMId(bankMDMId);
			bankDetails.setBankName(bankName);
			bankLst.add(bankDetails);
			apmDetails.getFeePaymentRunDetails().setBankFeeDetails(bankLst);
		}
		apmDetails = apmDetailsDAO.expandFeeTableDetails(apmDetails);
		apmDetails = APMDetailsHelper.getFeeRunAmountsAsString(apmDetails);
		return apmDetails;
	}

	/**
	 * Method to get the BUCADNDetails for all requests
	 * @param apmConfigId
	 * @return 
	 * @throws HWFServiceException
	 */
	public APMDetails getAllBUCADNDetails(BigInteger apmConfigId) throws HWFServiceException {
		APMDetails apmDetails = new APMDetails();
		FeePaymentRunDetails feePaymentRunDetails = new FeePaymentRunDetails();
		FeePeriodDetails feePeriodDetails = new FeePeriodDetails();
		feePeriodDetails.setAPMConfigID(apmConfigId);
		feePaymentRunDetails.setFeePeriodDetails(feePeriodDetails);
		apmDetails.setFeePaymentRunDetails(feePaymentRunDetails);
		apmDetails = apmDetailsDAO.getAllBUCADNDetails(apmDetails);
		return apmDetails;
	}

	/**
	 * Method to get the BUCADNDetails for selected BUC & ADN combination
	 * @param invalidBUC
	 * @param invalidADN
	 * @param apmConfigId
	 * @return APMDetails
	 * @throws HWFServiceException
	 */
	public APMDetails getBUCADNDetails(String invalidBUC,String invalidADN,BigInteger apmConfigId) throws HWFServiceException {
		List<BUCAndADN> bucAndADNsList = new ArrayList<BUCAndADN>();
		APMDetails apmDetails = new APMDetails();
		FeePaymentRunDetails feePaymentRunDetails = new FeePaymentRunDetails();
		FeePeriodDetails feePeriodDetails = new FeePeriodDetails();
		feePeriodDetails.setAPMConfigID(apmConfigId);
		feePaymentRunDetails.setFeePeriodDetails(feePeriodDetails);
		apmDetails.setFeePaymentRunDetails(feePaymentRunDetails);
		BUCAndADN bucAndADN = new BUCAndADN();
		bucAndADN.setBUC(invalidBUC);
		bucAndADN.setADN(invalidADN);
		bucAndADNsList.add(bucAndADN);
		apmDetails.setBUCAndADNs(bucAndADNsList);
		apmDetails = apmDetailsDAO.getBUCADNDetails(apmDetails);
		return apmDetails;
	}

	/**
	 * Method to update the selected request BUCADNDetails
	 * @param bucAdnList
	 * @param updatedBUCVal
	 * @param updatedADNVal
	 * @param apmConfigId
	 * @throws HWFServiceException
	 */
	public void updateBUCADNDetails(List<BUCAndADN> bucAdnList,String updatedBUCVal,String updatedADNVal,BigInteger apmConfigId)throws HWFServiceException {
		List<BUCAndADN> updatedBucAndADNsList = new ArrayList<BUCAndADN>();
		if(bucAdnList != null & bucAdnList.size() > ALOCConstants.BUC_START_INDEX)
		{
			for(BUCAndADN bucAndADN : bucAdnList)
			{
				if(bucAndADN.isUpdateFlag())
				{
					if(updatedBUCVal != null && updatedBUCVal.length() > ALOCConstants.BUC_START_INDEX)
					{
						bucAndADN.setBUC(updatedBUCVal);
					}
					if(updatedADNVal != null && updatedADNVal.length() > ALOCConstants.BUC_START_INDEX)
					{
						bucAndADN.setADN(updatedADNVal);
					}
					updatedBucAndADNsList.add(bucAndADN);
				}
			}
		}
		APMDetails updatedAPMDetails = new APMDetails();
		FeePaymentRunDetails feePaymentRunDetails = new FeePaymentRunDetails();
		FeePeriodDetails feePeriodDetails = new FeePeriodDetails();
		feePeriodDetails.setAPMConfigID(apmConfigId);
		feePaymentRunDetails.setFeePeriodDetails(feePeriodDetails);
		updatedAPMDetails.setFeePaymentRunDetails(feePaymentRunDetails);
		updatedAPMDetails.setBUCAndADNs(updatedBucAndADNsList);
		apmDetailsDAO.updateBUCADNDetails(updatedAPMDetails);
	}

	/**
	 * Method to get APMDetails to show fee summary details
	 * @return APMDetails
	 * @param apmDetails
	 * @throws HWFServiceException
	 */
	public APMDetails getFeeSummaryDetails(APMDetails apmDetails)throws HWFServiceException {
		if(apmDetails != null){
			apmDetails=apmDetailsDAO.getFeeSummaryDetails(apmDetails);
			APMDetailsHelper.removeBigDecimalZeroValues(apmDetails);
			apmDetails = APMDetailsHelper.getFeeSummaryAmountsAsString(apmDetails);
		}
		return apmDetails;
	}

	/**
	 * Method to get APMDetails to show fee summary details in FeeHistory page
	 * @return APMDetails
	 * @throws HWFServiceException
	 */
	public APMDetails getFHFeeSummaryDetails()throws HWFServiceException {
		HttpServletRequest request = ServletActionContext.getRequest();
		APMDetails apmDetails = new APMDetails();
		FeePaymentRunDetails feeRun = new FeePaymentRunDetails();
		apmDetails.setFeePaymentRunDetails(feeRun);
		FeeHistoryDetails feeDet = new FeeHistoryDetails();
		List<FullSummary> feeLst = new ArrayList<FullSummary>();
		FullSummary fullSum = new FullSummary();
		fullSum.setPaymentID(request.getParameter(ALOCConstants.PAYMENT_ID));
		feeLst.add(fullSum);
		feeDet.setFullSummaries(feeLst);
		apmDetails.setFeeHistoryDetails(feeDet);

		apmDetails=apmDetailsDAO.getFeeSummaryDetails(apmDetails);
		APMDetailsHelper.removeBigDecimalZeroValues(apmDetails);
		apmDetails = APMDetailsHelper.getFeeSummaryAmountsAsString(apmDetails);
		return apmDetails;
	}

	/**
	 *  Method to open PaymentPeriod screen
	 * @return APMDetails
	 * @throws HWFServiceException
	 */
	public APMDetails openPaymentPeriod() throws HWFServiceException {
		APMDetails apmDetails = apmDetailsDAO.openPaymentPeriod();
		return apmDetails;
	}

	/**
	 *  Method to save Payment Period
	 * @return apmdetails
	 * @param firstpaymentperiod
	 * @throws HWFServiceException
	 * @throws ParseException 
	 */
	public APMDetails savePaymentPeriod(PaymentPeriodDetails firstpaymentperiod) throws HWFServiceException, ParseException{
		APMDetails apmDet = new APMDetails();
		List<PaymentPeriodDetails> paymentPeriodDetails=new ArrayList<PaymentPeriodDetails>();
		paymentPeriodDetails.add(firstpaymentperiod);
		apmDet.setPaymentPeriodDetails(paymentPeriodDetails);	
		APMDetails apmdetails = apmDetailsDAO.savePaymentPeriod(apmDet);
		return apmdetails;
	}

	/**
	 *  Method to save TwoRowPayment
	 * @return apmdetails
	 * @throws HWFServiceException
	 * @throws ParseException
	 */
	public APMDetails savePaymentPeriodTwoRow() throws HWFServiceException,ParseException {
		APMDetails apmDet = new APMDetails();
		PaymentPeriodDetails paymentDetails=null;
		paymentDetails=APMDetailsHelper.getRowValues();
		List<PaymentPeriodDetails> paymentPeriodDetails=new ArrayList<PaymentPeriodDetails>();
		paymentPeriodDetails.add(paymentDetails);

		HttpServletRequest request = ServletActionContext.getRequest();
		String apmConfigIdOne = request.getParameter(ALOCConstants.PAYMENT_CONFIG_IDONE);
		String paymentPeriodStartDateOne = request.getParameter(ALOCConstants.STARTDATEONE);
		String paymentPeriodEndDateOne = request.getParameter(ALOCConstants.ENDDATEONE);
		String fxRateRevalueDateOne = request.getParameter(ALOCConstants.REVALUEDATEONE);
		String paymentPeriodCutoffDateOne = request.getParameter(ALOCConstants.CUTOFDATEONE);
		String minPaymentAmountUSDOne = request.getParameter(ALOCConstants.USDAMOUNTONE);
		String dayCountOne = request.getParameter(ALOCConstants.DAYCOUNTONE);
		paymentDetails=new PaymentPeriodDetails();
		if(paymentPeriodStartDateOne!=null && !ALOCConstants.EMPTY_STRING.equals(paymentPeriodStartDateOne)){
			paymentDetails.setPaymentPeriodStartDate(ALOCCommonHelper.convertStringToCal(paymentPeriodStartDateOne));
		}
		if(paymentPeriodEndDateOne!=null && !ALOCConstants.EMPTY_STRING.equals(paymentPeriodEndDateOne)){
			paymentDetails.setPaymentPeriodEndDate(ALOCCommonHelper.convertStringToCal(paymentPeriodEndDateOne));
		}
		if(fxRateRevalueDateOne!=null && !ALOCConstants.EMPTY_STRING.equals(fxRateRevalueDateOne)){
			paymentDetails.setFXRateRevalueDate(ALOCCommonHelper.convertStringToCal(fxRateRevalueDateOne));
		}
		if(paymentPeriodCutoffDateOne!=null && !ALOCConstants.EMPTY_STRING.equals(paymentPeriodCutoffDateOne)){
			paymentDetails.setPaymentPeriodCutoffDate(ALOCCommonHelper.convertStringToCal(paymentPeriodCutoffDateOne));
		}
		if(minPaymentAmountUSDOne!=null){
			paymentDetails.setMinPaymentAmountUSD(new BigDecimal(minPaymentAmountUSDOne));
		}
		if(dayCountOne!=null){
			paymentDetails.setDayCount(new BigInteger(dayCountOne));
		}
		if(apmConfigIdOne!=null && !ALOCConstants.EMPTY_STRING.equals(apmConfigIdOne)){
			paymentDetails.setAPMConfigID(new BigInteger(apmConfigIdOne));
		}
		paymentPeriodDetails.add(paymentDetails);
		apmDet.setPaymentPeriodDetails(paymentPeriodDetails);        
		APMDetails apmdetails = apmDetailsDAO.savePaymentPeriod(apmDet);
		return apmdetails;
	}

	/**
	 * Method to Cancel Payment Period row
	 * @param paymentperiodList
	 * @param apmConfigID
	 * @return payment
	 */
	public PaymentPeriodDetails cancel(List<PaymentPeriodDetails> paymentperiodList,String apmConfigID){

		PaymentPeriodDetails payment = new PaymentPeriodDetails();
		if(apmConfigID!=null && !(apmConfigID.equals(ALOCConstants.EMPTY_STRING)))
		{
			if(paymentperiodList != null && paymentperiodList.size() > ALOCConstants.PAYMENTPERIOD_MIN_SIZE)
			{
				int indexNum = ALOCConstants.START_INDEX;
				for(PaymentPeriodDetails tempPaymentPeriodDetails : paymentperiodList)
				{
					indexNum++;
					if((new BigInteger(apmConfigID)).equals(tempPaymentPeriodDetails.getAPMConfigID()))
					{
						payment = tempPaymentPeriodDetails;
						indexNum--;
						String index = String.valueOf(indexNum);
						payment.setIBSFile(index);
						break;
					}
				}
			}
		}
		return payment;
	}

	/* -------------------------------------------------------------------------------------------------------------------------------------------
	 * 														FX Rate History & Currency Setup Related Methods
	 -------------------------------------------------------------------------------------------------------------------------------------------- */

	/**
	 * Method to get the Currency Setup Details
	 * @return apmDetails
	 * @throws HWFServiceException
	 */
	public APMDetails getCurrencySetUpDetails() throws HWFServiceException{
		APMDetails apmDetails=apmDetailsDAO.getCurrencySetUpDetails();
		List<CurrencySetup> currencySetuplst = apmDetails.getFXRateHistoryAndCurrencySetup().getCurrencySetups();
		for(CurrencySetup eachCur : currencySetuplst){
			if(eachCur.getBUC() == null){ eachCur.setBUC(ALOCConstants.EMPTY_STRING); }
			else{ eachCur.setBUC(eachCur.getBUC());	}
			if(eachCur.getADN() == null){ eachCur.setADN(ALOCConstants.EMPTY_STRING); }
			else{ eachCur.setADN(eachCur.getADN());	}
		}
		return apmDetails;
	}

	/**
	 * Method to get the FX Rates  
	 * @return apmDetails
	 * @param feePeriodId
	 * @throws HWFServiceException
	 */
	public APMDetails getFxRates(String feePeriodId) throws HWFServiceException{
		APMDetails apmDetails=null;
		if(feePeriodId!=null && !feePeriodId.equalsIgnoreCase(ALOCConstants.EMPTY_STRING)){
			apmDetails=apmDetailsDAO.getFxRates(new BigInteger(feePeriodId));
		}
		return apmDetails;
	}

	/**
	 * Method to download the FX Rates  
	 * @return apmDetails
	 * @throws HWFServiceException
	 */
	public APMDetails downloadFxRates(String feePeriodId) throws HWFServiceException{
		APMDetails apmDetails=null;
		if(feePeriodId!=null && !feePeriodId.equalsIgnoreCase(ALOCConstants.EMPTY_STRING)){
			apmDetails=apmDetailsDAO.downloadFxRates(new BigInteger(feePeriodId));
		}
		return apmDetails;
	}

	/**
	 * method to get the year list
	 * @return FxRatePeriodyearList
	 * @throws HWFServiceException
	 */
	public List<BigInteger> getYearlist() throws HWFServiceException{
		APMDetails apmDetails=apmDetailsDAO.getYearlist();
		List<BigInteger> FxRatePeriodyearList=new ArrayList<BigInteger>();
		FxRatePeriodyearList=apmDetails.getFXRateHistoryAndCurrencySetup().getFXRateHistory().getFromYears();
		return FxRatePeriodyearList;
	}

	/**
	 * Method to open the FX Rate History Page 
	 * @return FxRatePeriodList
	 * @throws HWFServiceException
	 * @throws ParseException 
	 */
	public List<NameValue> openFXRateHistory() throws HWFServiceException, ParseException{
		HttpServletRequest request = ServletActionContext.getRequest();
		String fromDate= request.getParameter(ALOCConstants.FXFROMYEAR);
		String toDate= request.getParameter(ALOCConstants.FXTOYEAR);
		List<BigInteger> FxRatePeriodyearList;
		FXRateHistory fxRatehistory=new FXRateHistory();
		FxRatePeriodyearList=new ArrayList<BigInteger>();
		if(fromDate!=null && !ALOCConstants.EMPTY_STRING.equals(fromDate) ){
			FxRatePeriodyearList.add(new BigInteger(fromDate));
		}
		fxRatehistory.setFromYears(FxRatePeriodyearList);
		FxRatePeriodyearList=new ArrayList<BigInteger>();
		if(toDate!=null && !ALOCConstants.EMPTY_STRING.equals(toDate) ){
			FxRatePeriodyearList.add(new BigInteger(toDate));
		}
		fxRatehistory.setToYears(FxRatePeriodyearList);
		APMDetails apmDetails=apmDetailsDAO.openFXRateHistory(fxRatehistory);
		List<NameValue> FxRatePeriodList=new ArrayList<NameValue>();
		FxRatePeriodList=APMDetailsHelper.formatDate(apmDetails);
		return FxRatePeriodList;
	}

	/**
	 * Method to Save the Currency Setup Row 
	 * @return apmDet
	 * @param currencySetup
	 * @throws HWFServiceException
	 */
	public APMDetails saveCurrencySetRow(CurrencySetup currencySetup) throws HWFServiceException{
		APMDetails apmDet = new APMDetails();
		FXRateHistoryAndCurrencySetup fxRateCurSetUp = new FXRateHistoryAndCurrencySetup();
		List<CurrencySetup> lst = new ArrayList<CurrencySetup>();

		if(currencySetup.getRateDirection().equals(ALOCConstants.MULTIPLY)){ currencySetup.setRateDirection(ALOCConstants.M); }
		else if(currencySetup.getRateDirection().equals(ALOCConstants.DIVIDE)) { currencySetup.setRateDirection(ALOCConstants.D); } 

		if(currencySetup.getAPMPaymentCurrencyFlag().equalsIgnoreCase(ALOCConstants.YES)){ currencySetup.setAPMPaymentCurrencyFlag(ALOCConstants.Y); }
		else if(currencySetup.getAPMPaymentCurrencyFlag().equalsIgnoreCase(ALOCConstants.NO)) { currencySetup.setAPMPaymentCurrencyFlag(ALOCConstants.N); } 

		if(currencySetup.getCurrencyName()==null || ALOCConstants.EMPTY_STRING.equals(currencySetup.getCurrencyName())){
			MasterDataFactory masFactory =ALOCContext.getMasterDataFactory();
			List<Currency> currencies = masFactory.getCurrencies();

			for(Currency cur : currencies){
				if(currencySetup.getCurrencyCode().equalsIgnoreCase(cur.getCurrencyCode())){
					currencySetup.setCurrencyName(cur.getCurrencyName());
					break;
				}
			}
		}
		lst.add(currencySetup);
		fxRateCurSetUp.setCurrencySetups(lst);
		apmDet.setFXRateHistoryAndCurrencySetup(fxRateCurSetUp);

		apmDet = apmDetailsDAO.saveCurrencySetRow(apmDet);
		List<CurrencySetup> currencySetuplst = apmDet.getFXRateHistoryAndCurrencySetup().getCurrencySetups();
		for (CurrencySetup eachCur : currencySetuplst) {
			if (eachCur.getBUC() == null) {
				eachCur.setBUC(ALOCConstants.EMPTY_STRING);
			} else {
				eachCur.setBUC(eachCur.getBUC());
			}
			if (eachCur.getADN() == null) {
				eachCur.setADN(ALOCConstants.EMPTY_STRING);
			} else {
				eachCur.setADN(eachCur.getADN());
			}
		}
		return apmDet;
	}


	/**
	 * Method to Delete the Currency Setup Row 
	 * @return apmDetails
	 * @throws HWFServiceException
	 */
	public APMDetails deleteCurrencyRow() throws HWFServiceException{
		HttpServletRequest request = ServletActionContext.getRequest();
		String configId = request.getParameter(ALOCConstants.CONFIG_ID);

		APMDetails apmDet = new APMDetails();
		FXRateHistoryAndCurrencySetup fxRateCurSetUp = new FXRateHistoryAndCurrencySetup();
		CurrencySetup currencySetups = new CurrencySetup();
		List<CurrencySetup> lst = new ArrayList<CurrencySetup>();

		currencySetups.setCurrencyConfigId(new BigInteger(configId));
		lst.add(currencySetups);
		fxRateCurSetUp.setCurrencySetups(lst);
		apmDet.setFXRateHistoryAndCurrencySetup(fxRateCurSetUp);

		return apmDetailsDAO.deleteCurrencyRow(apmDet);
	}

	/**
	 * Method to get the Fee payment run values for Download to CSV
	 * @return apmDetails
	 * @param apmDetails
	 * @throws HWFServiceException
	 */
	public APMDetails getFeeRunDownloadToCSV(APMDetails apmDetails) throws HWFServiceException{
		if(apmDetails != null){
			APMDetails apmDet = new APMDetails();
			FeePaymentRunDetails feeRun = new FeePaymentRunDetails();
			FeePeriodDetails feePeriod = new FeePeriodDetails();
			feePeriod.setAPMConfigID(apmDetails.getFeePaymentRunDetails().getFeePeriodDetails().getAPMConfigID());
			feeRun.setFeePeriodDetails(feePeriod);
			apmDet.setFeePaymentRunDetails(feeRun);
			apmDetails = apmDetailsDAO.getFeeRunDownloadToCSV(apmDet);
		}
		return apmDetails;
	}
	
	/**
	 * Method to get the Fee payment run values for Download to CSV
	 * @return apmDetails
	 * @param apmDetails
	 * @throws HWFServiceException
	 */
	public APMDetails getCreditAndCarryOverDetails(APMDetails apmDetails) throws HWFServiceException{
		if(apmDetails != null){
			APMDetails apmDet = new APMDetails();
			FeePaymentRunDetails feeRun = new FeePaymentRunDetails();
			FeePeriodDetails feePeriod = new FeePeriodDetails();
			feePeriod.setAPMConfigID(apmDetails.getFeePaymentRunDetails().getFeePeriodDetails().getAPMConfigID());
			feeRun.setFeePeriodDetails(feePeriod);
			apmDet.setFeePaymentRunDetails(feeRun);
			apmDetails = apmDetailsDAO.getCreditAndCarryOverDetails(apmDet);
		}
		return apmDetails;
	}
	
	/**
	 * Method to send Invoice call to a third party
	 * @return apmDetails
	 * @param apmDetails
	 * @throws HWFServiceException
	 */
	public APMDetails saveCSVFile(APMDetails apmDetails, byte[] csvFile) throws HWFServiceException{
		if(apmDetails != null){
			List<Attachment> atmtList = apmDetails.getFeePaymentRunDetails() != null ? apmDetails.getFeePaymentRunDetails().getAttachments():null;
			FeePeriodDetails feePeriodDetails = apmDetails.getFeePaymentRunDetails().getFeePeriodDetails();
			Calendar peroidStartDate = (feePeriodDetails != null) ? feePeriodDetails.getPeriodStartDate() : null;
			Calendar peroidEndDate = (feePeriodDetails != null) ? feePeriodDetails.getPeriodEndDate() : null;
			Attachment atmt = new Attachment();
			Attachment deleteAttachment = null;
			boolean deleteAtmt = false;
			try {
				if(atmtList != null && !atmtList.isEmpty()) {
					for(Attachment attachment : atmtList) {
						if(attachment.getAttachmentTypeId() != null  && attachment.getAttachmentTypeId().intValue()==(AttachmentType.CSV).getId()) {								
							if(attachment != null && attachment.getGeFileId() != null) {
							 	 deleteAttachment = new Attachment();
								 deleteAttachment.setGeFileId(attachment.getGeFileId());
								 deleteAttachment.setGeFolderId(attachment.getGeFolderId());
								 deleteAttachment.setAttachmentTypeId(attachment.getAttachmentTypeId());
								 deleteAttachment.setAttachmentName(attachment.getAttachmentName());
								 deleteAttachment.setAttachmentOriginalName(attachment.getAttachmentOriginalName());
								 deleteAttachment.setGeLibraryReference(attachment.getGeLibraryReference());
								 deleteAtmt = true;
								 atmt.setActionType(OpCode.UPDATE.getOperationCode());
								 atmt.setAttachmentId(attachment.getAttachmentId());
								 break;
								}
						}
					}
				}else
				{
					atmt.setActionType(OpCode.INSERT.getOperationCode());
				}
				atmt.setAttachmentTypeId(new BigInteger(String.valueOf(AttachmentType.CSV.getId())));
				atmt.setAttachmentOriginalName(ALOCConstants.FEEHISTORY_CSV);
				String userSSO = UserContext.getContext().getuserDetails().getUserId();
				atmt.setAttachedBySSOID(userSSO);
				
				SimpleDateFormat formatter = new SimpleDateFormat(ALOCConstants.DATE_FORMAT);
				StringBuilder fileName = new StringBuilder().append(formatter.format(peroidStartDate.getTime())).append(ALOCConstants.UNDERSCORE)
						.append((ALOCConstants.TO).trim()).append(ALOCConstants.UNDERSCORE).append(formatter.format(peroidEndDate.getTime()))
						.append(ALOCConstants.UNDERSCORE).append(new SimpleDateFormat(ALOCConstants.CSV_DATEFORMAT).format(new Date()))
						.append(ALOCConstants.UNDERSCORE).append(atmt.getAttachmentOriginalName());
				atmt.setAttachmentName(fileName.toString());
				
				atmt = alocAttachmentManager.addCSVAttachment(csvFile,atmt);
				
				atmt.setAPMConfigId(apmDetails.getFeePaymentRunDetails().getFeePeriodDetails().getAPMConfigID());
				List<Attachment> attachmentsLst = new ArrayList<Attachment>();
				attachmentsLst.add(atmt);
				apmDetails.getFeePaymentRunDetails().setAttachments(attachmentsLst);
				// Make a service call to save new attachment
				apmDetails = apmDetailsDAO.saveAPMFeePaymentAttachments(apmDetails);
				
				// Delete Attachment If exists		
				if(deleteAtmt == true){
					try{
						alocAttachmentManager.delete(deleteAttachment);
					}catch(ALOCAttachmentException ae){
						LOGGER.error(ALOCConstants.ERROR_WHILE_DELETING_FILE + deleteAttachment.getAttachmentName(), ae);
					}
				}
			} catch (ALOCAttachmentException e) {				
				LOGGER.error(e.getMessage(), e);
			} catch (ALOCException e) {				
				LOGGER.error(e.getMessage(), e);
			}
		}
		return apmDetails;
	}

	/**
	 * Method to send Invoice call to a third party
	 * @return apmDetails
	 * @param apmDetails
	 * @throws HWFServiceException
	 */
	public APMDetails sendInvoices(APMDetails apmDetails) throws HWFServiceException{
		if(apmDetails != null){
			APMDetails apmDet = new APMDetails();
			FeePaymentRunDetails feeRun = new FeePaymentRunDetails();
			FeePeriodDetails feePeriod = new FeePeriodDetails();
			feePeriod.setAPMConfigID(apmDetails.getFeePaymentRunDetails().getFeePeriodDetails().getAPMConfigID());
			feeRun.setFeePeriodDetails(feePeriod);
			apmDet.setFeePaymentRunDetails(feeRun);
			apmDetails = apmDetailsDAO.sendInvoices(apmDet);
			String IBSContent = apmDetails.getFeePaymentRunDetails().getIBSFileContent();
			String IBSFileName = apmDetails.getFeePaymentRunDetails().getIBSFileName();
			Attachment atmt = null;
			try {
				if(IBSContent!=null && IBSContent.length() > ALOCConstants.IBS_BASE_INDEX) {		
					List<Attachment> atmtList = apmDetails.getFeePaymentRunDetails().getAttachments();
					if(atmtList != null && !atmtList.isEmpty()) {
						for(Attachment attachment : atmtList) {
							if(attachment.getAttachmentTypeId().intValue()==(AttachmentType.IBS).getId()) {								
								 if(attachment != null && attachment.getGeFileId() != null) {
										BigInteger atmtId =  attachment.getAttachmentId();
										alocAttachmentManager.delete(attachment);
										attachment.setAttachmentId(atmtId);			
									}
								 atmt = attachment;
								 atmt.setActionType(OpCode.UPDATE.getOperationCode());
								 break;
							}
						}
					}else
					{
						atmt = new Attachment();
						atmt.setActionType(OpCode.INSERT.getOperationCode());
					}
					atmt.setAttachmentTypeId(new BigInteger(String.valueOf(AttachmentType.IBS.getId())));					
					atmt = alocAttachmentManager.addAPMAttachment(IBSContent,IBSFileName,atmt);
					atmt.setAPMConfigId(apmDetails.getFeePaymentRunDetails().getFeePeriodDetails().getAPMConfigID());
					List<Attachment> attachmentsLst = new ArrayList<Attachment>();
					attachmentsLst.add(atmt);
					apmDetails.getFeePaymentRunDetails().setAttachments(attachmentsLst);
					// Make a service call to save new attachment
					apmDetails.getFeePaymentRunDetails().setIBSFileContent(null);
					apmDetails.getFeePaymentRunDetails().setIBSFileName(null);										
					apmDetails = apmDetailsDAO.saveAPMFeePaymentAttachments(apmDetails);
				}

			} catch (ALOCAttachmentException e) {				
				LOGGER.error(e.getMessage(), e);
			} catch (ALOCException e) {				
				LOGGER.error(e.getMessage(), e);
			}
		}
		return apmDetails;
	}

	/**
	 * Method to send web cash files call to a third party
	 * @return apmDetails
	 * @param apmDetails
	 * @throws HWFServiceException
	 */
	public APMDetails sendWebCashFiles(APMDetails apmDetails) throws HWFServiceException{
		if(apmDetails != null){
			APMDetails apmDet = new APMDetails();
			FeePaymentRunDetails feeRun = new FeePaymentRunDetails();
			FeePeriodDetails feePeriod = new FeePeriodDetails();
			feePeriod.setAPMConfigID(apmDetails.getFeePaymentRunDetails().getFeePeriodDetails().getAPMConfigID());
			feeRun.setFeePeriodDetails(feePeriod);
			apmDet.setFeePaymentRunDetails(feeRun);
			apmDetails = apmDetailsDAO.sendWebCashFiles(apmDet);
			String webCashContent = apmDetails.getFeePaymentRunDetails().getWebCashFileContent();
			String webCashFileName = apmDetails.getFeePaymentRunDetails().getWebcashFileName();
			Attachment atmt = null;
			try {
				if(webCashContent!=null && webCashContent.length() > ALOCConstants.WEBCASH_BASE_INDEX) {		
					List<Attachment> atmtList = apmDetails.getFeePaymentRunDetails().getAttachments();
					if(atmtList != null && !atmtList.isEmpty()) {
						for(Attachment attachment : atmtList) {
							if(attachment.getAttachmentTypeId().intValue()==(AttachmentType.WEBCASH).getId()) {
								if(attachment != null && attachment.getGeFileId() != null) {
									BigInteger atmtId =  attachment.getAttachmentId();
									alocAttachmentManager.delete(attachment);
									attachment.setAttachmentId(atmtId);			
								}
								 atmt = attachment;
								 atmt.setActionType(OpCode.UPDATE.getOperationCode());
								 break;
							}
						}
					}else
					{
						atmt = new Attachment();
						atmt.setActionType(OpCode.INSERT.getOperationCode());
					}
					atmt.setAttachmentTypeId(new BigInteger(String.valueOf(AttachmentType.WEBCASH.getId())));					
					atmt = alocAttachmentManager.addAPMAttachment(webCashContent,webCashFileName, atmt);
					atmt.setAPMConfigId(apmDetails.getFeePaymentRunDetails().getFeePeriodDetails().getAPMConfigID());	
					List<Attachment> attachmentsLst = new ArrayList<Attachment>(); 
					attachmentsLst.add(atmt); 
					apmDetails.getFeePaymentRunDetails().setAttachments(attachmentsLst);
					// Make a service call to save new attachment
					apmDetails.getFeePaymentRunDetails().setWebCashFileContent(null);
					apmDetails.getFeePaymentRunDetails().setWebcashFileName(null);	
					apmDetails = apmDetailsDAO.saveAPMFeePaymentAttachments(apmDetails);
				}

			} catch (ALOCAttachmentException e) {				
				LOGGER.error(e.getMessage(), e);
			} catch (ALOCException e) {				
				LOGGER.error(e.getMessage(), e);
			}					
		}
		return apmDetails;
	}

	/**
	 * Method to Complete Payment call to a third party
	 * @return apmDetails
	 * @param apmDetails
	 * @throws HWFServiceException
	 */
	public APMDetails completePayment(APMDetails apmDetails) throws HWFServiceException{
		if(apmDetails != null){
			APMDetails apmDet = new APMDetails();
			FeePaymentRunDetails feeRun = new FeePaymentRunDetails();
			FeePeriodDetails feePeriod = new FeePeriodDetails();
			feePeriod.setAPMConfigID(apmDetails.getFeePaymentRunDetails().getFeePeriodDetails().getAPMConfigID());
			feeRun.setFeePeriodDetails(feePeriod);
			apmDet.setFeePaymentRunDetails(feeRun);
			apmDetails = apmDetailsDAO.completePayment(apmDet);
		}
		return apmDetails;
	}

	/* -------------------------------------------------------------------------------------------------------------------------------------------
	 * 														INJECTOR METHODS
	 -------------------------------------------------------------------------------------------------------------------------------------------- */
	/**
	 * This method is used to get the apmDetailsDAO instance object.
	 * @return
	 */
	public IAPMDetailsDAO getApmDetailsDAO() {
		return apmDetailsDAO;
	}

	/**
	 * This method is used to create the apmDetailsDAO instance object.
	 * @param apmDetailsDAO
	 */
	public void setApmDetailsDAO(IAPMDetailsDAO apmDetailsDAO) {
		this.apmDetailsDAO = apmDetailsDAO;
	}
	
	/**
	 * 
	 * @return
	 */
	public IALOCAttachmentManager getAlocAttachmentManager() {
		return alocAttachmentManager;
	}

	/**
	 * 
	 * @param alocAttachmentManager
	 */
	public void setAlocAttachmentManager(
			IALOCAttachmentManager alocAttachmentManager) {
		this.alocAttachmentManager = alocAttachmentManager;
	}
}