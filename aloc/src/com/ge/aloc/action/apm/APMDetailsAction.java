/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: APMDetailsAction.java
 * Purpose: APMDetailsAction used for maintaining All APM Related Details.
 *
 */
package com.ge.aloc.action.apm;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.ge.aloc.common.util.AttachmentUtils;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.exception.ALOCException;
import com.ge.aloc.manager.IALOCAttachmentManager;
import com.ge.aloc.manager.apm.IAPMDetailsManager;
import com.ge.aloc.model.APMDetails;
import com.ge.aloc.model.Attachment;
import com.ge.aloc.model.BUCAndADN;
import com.ge.aloc.model.CurrencySetup;
import com.ge.aloc.model.NameValue;
import com.ge.aloc.model.PaymentPeriodDetails;
import com.ge.aloc.util.APMDetailsHelper;
import com.ge.aloc.util.JSONHelper;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.hydus.hwf.exceptions.ErrorData;
import com.hydus.hwf.exceptions.HWFServiceException;
import com.hydus.hwf.exceptions.HWFServiceStubException;
import com.hydus.hwf.exceptions.IErrorHandler;
import com.hydus.hwf.util.StringUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.ValidationWorkflowAware;



/**
 * @author Ramakrishna.s
 * 
 */
public class APMDetailsAction extends ActionSupport implements ValidationWorkflowAware {

	private static final long serialVersionUID = -8160867239431026163L;

	private IAPMDetailsManager apmDetailsManager;
	protected APMDetails apmDetails;
	private String fxRateViewType;
	protected String updatedBUCVal;
	protected String updatedADNVal;
	protected List<NameValue> fxRatePeriodList=new ArrayList<NameValue>();
	protected List<PaymentPeriodDetails> paymentPeriodDetails=new ArrayList<PaymentPeriodDetails>();
	private PaymentPeriodDetails firstpaymentperiod=new PaymentPeriodDetails();
	protected List<BigInteger> fxRatePeriodyearList=new ArrayList<BigInteger>();
	private Map<String, Object> sessionValues = ActionContext.getContext().getSession();
	protected boolean errorShow=false;
	protected List<BUCAndADN> bucAdnList = new ArrayList<BUCAndADN>();	
	protected CurrencySetup currencySetup;
	protected Integer invalidBUCADNSize;
	protected String pageFrom;
	protected IErrorHandler errorHandler;	
	private String errorMsg;
	protected boolean showCalculateFeeTable;
	protected IALOCAttachmentManager alocAttachmentManager;

	/**
	 * This method decides the page to display on validation error conditions
	 */
	public String getInputResultName() {
		if(currencySetup != null){
			apmDetails = (APMDetails)sessionValues.get(ALOCConstants.CURRENCY_SETUP_DETAILS);
			APMDetailsHelper apmHelper=new APMDetailsHelper();
			apmDetails = apmHelper.getCurrencySetupDetailsForSelCurrency(apmDetails, currencySetup);
			sessionValues.put(ALOCConstants.CURRENCY_SETUP_DETAILS, apmDetails);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
		errorShow=true;
		return INPUT;
	}

	/**
	 * Method to get the BUCADNDetails for all requests
	 * @return 
	 * @throws HWFServiceException
	 */
	public String getAllBUCADNDetails() throws HWFServiceException {
		APMDetails apmDet = (APMDetails) sessionValues.get(ALOCConstants.FEE_PAYMENT_RUN_DETAILS);
		BigInteger apmConfigId = apmDet.getFeePaymentRunDetails().getFeePeriodDetails().getAPMConfigID();
		apmDetails = apmDetailsManager.getAllBUCADNDetails(apmConfigId);
		bucAdnList = apmDetails.getBUCAndADNs();
		return SUCCESS;
	}

	/**
	 * Method to get the BUCADNDetails for selected BUC & ADN combination
	 * @return 
	 * @throws HWFServiceException
	 */
	public String getBUCADNDetails() throws HWFServiceException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String invalidBUC = request.getParameter(ALOCConstants.BUC);
		String invalidADN = request.getParameter(ALOCConstants.ADN);
		APMDetails apmDet = (APMDetails) sessionValues.get(ALOCConstants.FEE_PAYMENT_RUN_DETAILS);
		BigInteger apmConfigId = apmDet.getFeePaymentRunDetails().getFeePeriodDetails().getAPMConfigID();
		apmDetails = apmDetailsManager.getBUCADNDetails(invalidBUC,invalidADN,apmConfigId);
		bucAdnList = apmDetails.getBUCAndADNs();
		return SUCCESS;
	}

	/**
	 * Method to update the selected request BUCADNDetails
	 * @return
	 * @throws HWFServiceException
	 */
	public String updateBUCADNDetails() throws HWFServiceException {
		APMDetails apmDet = (APMDetails) sessionValues.get(ALOCConstants.FEE_PAYMENT_RUN_DETAILS);
		BigInteger apmConfigId = apmDet.getFeePaymentRunDetails().getFeePeriodDetails().getAPMConfigID();
		apmDetailsManager.updateBUCADNDetails(bucAdnList,updatedBUCVal,updatedADNVal,apmConfigId);
		return SUCCESS;
	}

	/**
	 * Method to get APMDetails to show fee summary details
	 * @return
	 * @throws HWFServiceException
	 */
	public String getFeeSummaryDetails() throws HWFServiceException {
		try{
			APMDetails apmDet = (APMDetails) sessionValues.get(ALOCConstants.FEE_PAYMENT_RUN_DETAILS);
			apmDetails=apmDetailsManager.getFeeSummaryDetails(apmDet);
		}catch(HWFServiceException hse){						
			addActionMessage(hse.getReason());				
		}
		return SUCCESS;
	}

	/**
	 * Method to get APMDetails to show fee summary details in FeeHistory page
	 * @return
	 * @throws HWFServiceException
	 */
	public String getFHFeeSummaryDetails() throws HWFServiceException {
		try{
			apmDetails=apmDetailsManager.getFHFeeSummaryDetails();
		}catch(HWFServiceException hse){						
			addActionMessage(hse.getReason());				
		}
		return SUCCESS;
	}

	/* ---------------------------------------------------------------------------------------------------------------------------------
	 * 										 Payment Period Related Methods
	 ----------------------------------------------------------------------------------------------------------------------------------- */

	/**
	 * Method to open Payment Period
	 * @return
	 * @throws HWFServiceException 
	 */
	public String openPaymentPeriod() throws HWFServiceException{
		apmDetails = apmDetailsManager.openPaymentPeriod();
		sessionValues.put(ALOCConstants.PAYMENT_PERIOD_DETAILS, apmDetails);

		return SUCCESS;
	}

	/**
	 *  Method to save Payment Period
	 * @return
	 * @throws HWFServiceException
	 * @throws ParseException 
	 */
	public String savePaymentPeriod() throws HWFServiceException, ParseException{  
		apmDetails = apmDetailsManager.savePaymentPeriod(firstpaymentperiod);
		sessionValues.put(ALOCConstants.PAYMENT_PERIOD_DETAILS, apmDetails);
		List<PaymentPeriodDetails> paymentperiodDetails=apmDetails.getPaymentPeriodDetails();
		HttpServletRequest request = ServletActionContext.getRequest();
		String curIndex = request.getParameter(ALOCConstants.CURINDEX);
		firstpaymentperiod=paymentperiodDetails.get(Integer.valueOf(curIndex));
		firstpaymentperiod.setIBSFile(curIndex);
		errorShow=false;
		return SUCCESS;
	}

	/**
	 * Method to Cancel Payment Period row
	 * @return
	 * @throws HWFServiceException
	 */
	public String cancelPaymentPeriod() throws HWFServiceException{
		apmDetails = (APMDetails) sessionValues.get(ALOCConstants.PAYMENT_PERIOD_DETAILS);
		HttpServletRequest request = ServletActionContext.getRequest();
		String apmConfigID = request.getParameter(ALOCConstants.APMCONFIGID);
		List<PaymentPeriodDetails> paymentperiodDetails=apmDetails.getPaymentPeriodDetails();
		firstpaymentperiod=apmDetailsManager.cancel(paymentperiodDetails,apmConfigID);
		errorShow=false;
		return SUCCESS;
	}

	/**
	 * Method to add the Payment Period
	 * @return
	 * @throws HWFServiceException
	 */
	public String addPaymentPeriodRow() throws HWFServiceException {
		errorShow=false;
		return SUCCESS;
	}

	/**
	 * Method to cancel  two Payment Period rows 
	 * @return
	 * @throws HWFServiceException
	 */
	public String cancelPaymentPeriodTwoRow() throws HWFServiceException {
		apmDetails = (APMDetails) sessionValues.get(ALOCConstants.PAYMENT_PERIOD_DETAILS);
		HttpServletRequest request = ServletActionContext.getRequest();
		List<PaymentPeriodDetails> paymentperiodDetails=apmDetails.getPaymentPeriodDetails();
		String curIndex = request.getParameter(ALOCConstants.CURINDEX);
		firstpaymentperiod=paymentperiodDetails.get(Integer.valueOf(curIndex));
		firstpaymentperiod.setIBSFile(curIndex);
		errorShow=false;
		return SUCCESS;
	}

	/**
	 * Method to edit the the selected payment period row
	 * @return
	 * @throws HWFServiceException
	 */
	public String editPaymentPeriodRow() throws HWFServiceException {
		apmDetails = (APMDetails) sessionValues.get(ALOCConstants.PAYMENT_PERIOD_DETAILS);
		HttpServletRequest request = ServletActionContext.getRequest();
		String apmConfigID = request.getParameter(ALOCConstants.APMCONFIGID);
		List<PaymentPeriodDetails> paymentperiodDetails=apmDetails.getPaymentPeriodDetails();
		firstpaymentperiod=apmDetailsManager.cancel(paymentperiodDetails,apmConfigID);
		errorShow=false;
		return SUCCESS;
	}

	/**
	 *  Method to save two Payment Period rows
	 * @return
	 * @throws HWFServiceException
	 * @throws ParseException
	 */
	public String savePaymentPeriodTwoRow() throws HWFServiceException, ParseException{
		apmDetails = apmDetailsManager.savePaymentPeriodTwoRow();
		sessionValues.put(ALOCConstants.PAYMENT_PERIOD_DETAILS, apmDetails);
		return null;
	}

	/* ---------------------------------------------------------------------------------------------------------------------------------
	 * 										FX Rate History & Currency Setup Related Methods
	 ----------------------------------------------------------------------------------------------------------------------------------- */

	/**
	 * method to get the year list
	 * @return
	 * @throws HWFServiceException
	 */
	public String getYearlist() throws HWFServiceException{
		fxRateViewType = ALOCConstants.FXRATEHISTORY;
		return SUCCESS;
	}

	/**
	 * method to to get the rate history
	 * @return
	 * @throws HWFServiceException
	 * @throws NullPointerException
	 * @throws ParseException
	 */
	public String openFXRateHistory() throws HWFServiceException,NullPointerException, ParseException{
		fxRatePeriodList=apmDetailsManager.openFXRateHistory();
		HttpServletResponse response = ServletActionContext.getResponse();
		JsonObject result = new JsonObject();
		JsonArray respnseData = new JsonArray();
		for(NameValue subType : fxRatePeriodList) {
			JsonObject jsonSubType = new JsonObject();
			jsonSubType.addProperty(ALOCConstants.JSON_PROP_ID, subType.getID());
			jsonSubType.addProperty(ALOCConstants.JSON_PROP_NAME, subType.getName());
			respnseData.add(jsonSubType);
		}
		result.add(ALOCConstants.RESULT, respnseData);
		JSONHelper.writeResponse(result, response);
		fxRateViewType = ALOCConstants.FXRATEHISTORY;
		return SUCCESS;
	}

	/**
	 * Method to get the fx rates
	 * @return
	 * @throws HWFServiceException
	 */
	public String getFxRates() throws HWFServiceException{
		HttpServletRequest request =ServletActionContext.getRequest(); 
		String payPeriod = request.getParameter(ALOCConstants.FEEPERIODID);	
		apmDetails=apmDetailsManager.getFxRates(payPeriod);
		sessionValues.put(ALOCConstants.FXRATEHISTORY_DETAILS, apmDetails);
		fxRateViewType = ALOCConstants.FXRATEHISTORY;
		return SUCCESS;
	}

	/**
	 * method to download FX Rates
	 * @return
	 * @throws HWFServiceException,Exception 
	 */
	public String downloadFXRates() throws HWFServiceException,Exception { 
		HttpServletRequest request =ServletActionContext.getRequest(); 
		String payPeriod = request.getParameter(ALOCConstants.FEEPERIODID);	
		apmDetails=apmDetailsManager.downloadFxRates(payPeriod);
		APMDetailsHelper helper=new APMDetailsHelper();
		helper.downloadFXRatesHistory(apmDetails);
		return null;
	}

	/**
	 * Method to get the Currency Setup Details
	 * @return
	 * @throws HWFServiceException
	 */
	public String getCurrencySetUpDetails() throws HWFServiceException {
		apmDetails=apmDetailsManager.getCurrencySetUpDetails();
		errorShow = false;
		sessionValues.put(ALOCConstants.CURRENCY_SETUP_DETAILS, apmDetails);
		fxRateViewType = ALOCConstants.CURRENCYSETUP;

		return SUCCESS;
	}

	/**
	 * Method to add the Currency Row
	 * @return
	 * @throws HWFServiceException
	 */
	public String addCurrencyRow() throws HWFServiceException {
		apmDetails = (APMDetails) sessionValues.get(ALOCConstants.CURRENCY_SETUP_DETAILS);
		errorShow = false;
		return SUCCESS;
	}

	/**
	 * Method to edit the Currency Row
	 * @return
	 * @throws HWFServiceException
	 */
	public String editCurrencyRow() throws HWFServiceException {
		apmDetails = (APMDetails) sessionValues.get(ALOCConstants.CURRENCY_SETUP_DETAILS);
		errorShow = false;
		return SUCCESS;
	}

	/**
	 * Method to Save the Currency Row
	 * @return
	 * @throws HWFServiceException
	 */
	public String saveCurrencySetRow() throws HWFServiceException {
		apmDetails = apmDetailsManager.saveCurrencySetRow(currencySetup);
		sessionValues.put(ALOCConstants.CURRENCY_SETUP_DETAILS, apmDetails);
		errorShow = false;
		return SUCCESS;
	}

	/**
	 * Method to Save the Currency Row
	 * @return
	 * @throws HWFServiceException
	 */
	public String cancelCurrencyRow() throws HWFServiceException {
		HttpServletRequest request =ServletActionContext.getRequest(); 
		String curConfigId = request.getParameter(ALOCConstants.CURRENCY_CONFIG_ID);	
		apmDetails=apmDetailsManager.getCurrencySetUpDetails();
		sessionValues.put(ALOCConstants.CURRENCY_SETUP_DETAILS, apmDetails);
		errorShow = false;

		if(StringUtils.isNotBlank(curConfigId)){
			return SUCCESS;
		}else {
			return null;
		}
	}

	/**
	 * Method to Save the Currency Row
	 * @return
	 * @throws HWFServiceException
	 */
	public String deleteCurrencyRow() throws HWFServiceException {
		apmDetails = apmDetailsManager.deleteCurrencyRow();
		sessionValues.put(ALOCConstants.CURRENCY_SETUP_DETAILS, apmDetails);
		return SUCCESS;
	}

	/* ---------------------------------------------------------------------------------------------------------------------------------
	 * 										Fee Payment Run Related Methods 
	 ----------------------------------------------------------------------------------------------------------------------------------- */

	/**
	 * Method to open the Fee Payment Run Page
	 * @return 
	 * @throws HWFServiceException
	 */
	public String openFeePaymentRun() throws HWFServiceException{
		apmDetails = apmDetailsManager.openFeePaymentRun();
		sessionValues.put(ALOCConstants.FEE_PAYMENT_RUN_DETAILS, apmDetails);
		return SUCCESS;
	}

	/**
	 * Method to get the CalculateFeesDetails 
	 * @return 
	 * @throws HWFServiceException
	 */
	public String getCalculateFeesDetails() throws HWFServiceException{
		try{
			APMDetails apmDet = (APMDetails) sessionValues.get(ALOCConstants.FEE_PAYMENT_RUN_DETAILS);
			apmDetails = apmDetailsManager.getCalculateFeesDetails(apmDet);
			sessionValues.put(ALOCConstants.CALCULATE_FEE_DETAILS, apmDetails);
		}catch(HWFServiceException hse){	
			ErrorData errorData = errorHandler.handle(hse);
			this.errorMsg = errorData.getCause().getMessage();				
		}
		return SUCCESS;
	}

	/**
	 * This Method is used to get the expandFeeTable Details
	 * @return 
	 * @throws HWFServiceException
	 */
	public String expandFeeTableDetails() throws HWFServiceException{
		HttpServletRequest request = ServletActionContext.getRequest();
		String bankMDMId = request.getParameter(ALOCConstants.BANK_MDMID);
		String bankName = request.getParameter(ALOCConstants.BANK_NAME);
		apmDetails = (APMDetails)sessionValues.get(ALOCConstants.FEE_PAYMENT_RUN_DETAILS);

		apmDetails = apmDetailsManager.expandFeeTableDetails(apmDetails,bankMDMId,bankName);
		return SUCCESS;
	}

	/**
	 * Method to get the CalculateFeesDetails
	 * @return
	 * @throws HWFServiceException
	 */
	public String getFeePaymentRunCalculateFees() throws HWFServiceException {
		try{
			APMDetails apmFeeTab = (APMDetails) sessionValues.get(ALOCConstants.CALCULATE_FEE_DETAILS);
			APMDetails tempApmDetails = (APMDetails) sessionValues.get(ALOCConstants.FEE_PAYMENT_RUN_DETAILS);
			if(showCalculateFeeTable == true && apmFeeTab != null){
				apmDetails = apmFeeTab;
				apmDetails.getFeePaymentRunDetails().setFeePeriodDetails(tempApmDetails.getFeePaymentRunDetails().getFeePeriodDetails());
			}else{
				apmDetails = apmDetailsManager.getCalculateFeesDetails(tempApmDetails);
				apmDetails.getFeePaymentRunDetails().setFeePeriodDetails(tempApmDetails.getFeePaymentRunDetails().getFeePeriodDetails());
				sessionValues.put(ALOCConstants.CALCULATE_FEE_DETAILS, apmDetails);
				showCalculateFeeTable = true;
			}
		}catch(HWFServiceException hse){	
			ErrorData errorData = errorHandler.handle(hse);
			this.errorMsg = errorData.getCause().getMessage();				
		}
		return SUCCESS;
	}

	/**
	 * 
	 * Method to get the Fee payment run values for Download to CSV
	 * @throws HWFServiceException
	 */
	public void downloadToCSV() throws HWFServiceException,Exception {
		APMDetailsHelper apmHelper=new APMDetailsHelper();
		APMDetails apmDet = (APMDetails) sessionValues.get(ALOCConstants.FEE_PAYMENT_RUN_DETAILS);
		apmDetails = apmDetailsManager.getFeeRunDownloadToCSV(apmDet);
		apmDetails.getFeePaymentRunDetails().setFeePeriodDetails(apmDet.getFeePaymentRunDetails().getFeePeriodDetails());
		apmHelper.downloadToCSV(apmDetails);
	}

	/**
	 * 
	 * Method to get the Fee payment run values for Download to CSV
	 * @throws HWFServiceException
	 */
	public void creditAndCarryOversExport() throws HWFServiceException,Exception {
		APMDetailsHelper apmHelper=new APMDetailsHelper();
		APMDetails apmDet = (APMDetails) sessionValues.get(ALOCConstants.FEE_PAYMENT_RUN_DETAILS);
		apmDetails = apmDetailsManager.getCreditAndCarryOverDetails(apmDet);
		apmHelper.creditAndCarryOversExport(apmDetails);
	}

	/**
	 * Method to send Invoice call to a third party
	 * @return SUCCESS
	 * @throws HWFServiceException
	 */
	public String sendInvoices() throws HWFServiceException {
		try{
			APMDetails apmDet = (APMDetails) sessionValues.get(ALOCConstants.FEE_PAYMENT_RUN_DETAILS);
			apmDetails = apmDetailsManager.sendInvoices(apmDet);
		}catch(HWFServiceException hse){						
			addActionMessage(hse.getReason());				
		}
		return SUCCESS;
	}

	/**
	 * Method to send web cash files call to a third party
	 * @return SUCCESS
	 * @throws HWFServiceException
	 */
	public String sendWebCashFiles() throws HWFServiceException {
		try{
			APMDetails apmDet = (APMDetails) sessionValues.get(ALOCConstants.FEE_PAYMENT_RUN_DETAILS);
			apmDetails = apmDetailsManager.sendWebCashFiles(apmDet);			
		}catch(HWFServiceException hse){						
			addActionMessage(hse.getReason());				
		}
		return SUCCESS;
	}

	/**
	 * Method to Complete Payment call to a third party
	 * @return SUCCESS
	 * @throws HWFServiceException
	 */
	public String completePayment() throws HWFServiceException {
		try{
			APMDetails apmDet = (APMDetails) sessionValues.get(ALOCConstants.FEE_PAYMENT_RUN_DETAILS);
			apmDetails = apmDetailsManager.completePayment(apmDet);
		}catch(HWFServiceException hse){						
			addActionMessage(hse.getReason());				
		}
		return SUCCESS;
	}

	
	/** 
	 * This method is used to download the WebCash / IBS attachments.
	 * @return
	 * @throws IOException 
	 * @throws HWFServiceException
	 */
	public String downloadAPMAttachment() throws IOException, HWFServiceException,HWFServiceStubException,ALOCException {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		String geLibFileId = request.getParameter(ALOCConstants.PARAM_GELIBFILEID);		
		String indexId = request.getParameter(ALOCConstants.PARAM_INDEX_ID);		
		OutputStream outputStream = null;
		Attachment attachmentToDownload = null;		
		try {
			if (StringUtils.isNotBlank(geLibFileId)) {
				APMDetails apmDet = (APMDetails) sessionValues.get(ALOCConstants.PAYMENT_PERIOD_DETAILS);
				attachmentToDownload = AttachmentUtils.searchAttachmentByGELibId(geLibFileId,apmDet.getPaymentPeriodDetails().get(Integer.valueOf(indexId).intValue()).getAttachments()); 											
				response.setContentType(ServletActionContext.getServletContext().getMimeType(attachmentToDownload.getAttachmentName()));
				response.addHeader(ALOCConstants.HEADER_CONTENT_DISPOSITION,ALOCConstants.CONTENT_DISPOSITION_VALUE+ attachmentToDownload.getAttachmentName());
				outputStream = response.getOutputStream();
				alocAttachmentManager.downloadAttachment(outputStream,attachmentToDownload);
			}
		} finally {
			outputStream.flush();
			outputStream.close();
		}
		return null;
	}
	
	
	
	/* ----------------------------------------------------------------------------------------------------------------------------------
	 * 														INJECTOR METHODS
	 ------------------------------------------------------------------------------------------------------------------------------------ */

	/**
	 * This method is used to get the apmDetailsManager instance object.
	 * @return
	 */
	public IAPMDetailsManager getApmDetailsManager() {
		return apmDetailsManager;
	}

	/**
	 * This method is used to set the apmDetailsManager instance object.
	 * @param apmDetailsManager
	 */
	public void setApmDetailsManager(IAPMDetailsManager apmDetailsManager) {
		this.apmDetailsManager = apmDetailsManager;
	}

	/**
	 * This method is used to get the apmDetails instance object.
	 * @return the apmDetails
	 */
	public APMDetails getApmDetails() {
		return apmDetails;
	}

	/**
	 * This method is used to set the apmDetails instance object.
	 * @param apmDetails the apmDetails to set
	 */
	public void setApmDetails(APMDetails apmDetails) {
		this.apmDetails = apmDetails;
	}

	/**
	 * This method is used to get the fxRateViewType instance object.
	 * Get FXRateViewType
	 * @return
	 */
	public String getFxRateViewType() {
		return fxRateViewType;
	}

	/**
	 * This method is used to set the fxRateViewType instance object.
	 * @param fxRateViewType
	 */
	public void setFxRateViewType(String fxRateViewType) {
		this.fxRateViewType = fxRateViewType;
	}

	/**
	 * This method is used to get the updated BUC Value.
	 * @return the updatedBUCVal
	 */
	public String getUpdatedBUCVal() {
		return updatedBUCVal;
	}

	/**
	 * This method is used to set the updated BUC Value.
	 * @param updatedBUCVal the updatedBUCVal to set
	 */
	public void setUpdatedBUCVal(String updatedBUCVal) {
		this.updatedBUCVal = updatedBUCVal;
	}

	/**
	 * This method is used to get the updated ADN Value.
	 * @return the updatedADNVal
	 */
	public String getUpdatedADNVal() {
		return updatedADNVal;
	}

	/**
	 * This method is used to set the updated ADN Value.
	 * @param updatedADNVal the updatedADNVal to set
	 */
	public void setUpdatedADNVal(String updatedADNVal) {
		this.updatedADNVal = updatedADNVal;
	}

	/**
	 * This method is used to get the FxRatePeriod list.
	 * @return the FxRatePeriodList
	 */
	public List<NameValue> getFxRatePeriodList() {
		return fxRatePeriodList;
	}

	/**
	 * This method is used to set the FxRatePeriod list.
	 * @param fxRatePeriodList the FxRatePeriodList to set
	 */
	public void setFxRatePeriodList(List<NameValue> fxRatePeriodList) {
		this.fxRatePeriodList = fxRatePeriodList;
	}

	/**
	 * This method is used to get the paymentPeriodDetails list.
	 * @return the paymentPeriodDetails
	 */
	public List<PaymentPeriodDetails> getPaymentPeriodDetails() {
		return paymentPeriodDetails;
	}

	/**
	 * This method is used to set the paymentPeriodDetails list.
	 * @param paymentPeriodDetails the paymentPeriodDetails to set
	 */
	public void setPaymentPeriodDetails(
			List<PaymentPeriodDetails> paymentPeriodDetails) {
		this.paymentPeriodDetails = paymentPeriodDetails;
	}

	/**
	 * This method is used verify errorShow.
	 * @return the errorShow
	 */
	public boolean isErrorShow() {
		return errorShow;
	}

	/**
	 * This method is used verify error show and set true or false value.
	 * @param errorShow the errorShow to set
	 */
	public void setErrorShow(boolean errorShow) {
		this.errorShow = errorShow;
	}

	/**
	 * This method is used to get the FxRatePeriodyear list.
	 * @return the fxRatePeriodyearList
	 */
	public List<BigInteger> getFxRatePeriodyearList() {
		return fxRatePeriodyearList;
	}

	/**
	 * This method is used to set the FxRatePeriodyear list.
	 * @param fxRatePeriodyearList the fxRatePeriodyearList to set
	 */
	public void setFxRatePeriodyearList(List<BigInteger> fxRatePeriodyearList) {
		this.fxRatePeriodyearList = fxRatePeriodyearList;
	}

	/**
	 * This method is used to get the firstPaymentperiod instance object.
	 * @return the firstPaymentperiod
	 */
	public PaymentPeriodDetails getFirstpaymentperiod() {
		return firstpaymentperiod;
	}

	/**
	 * This method is used to set the firstPaymentperiod instance object.
	 * @param firstpaymentperiod the firstPaymentperiod to set
	 */
	public void setFirstpaymentperiod(PaymentPeriodDetails firstpaymentperiod) {
		this.firstpaymentperiod = firstpaymentperiod;
	}

	/**
	 * This method is used to get the BUCADNs List.
	 * @return the bucAdnList
	 */
	public List<BUCAndADN> getBucAdnList() {
		return bucAdnList;
	}

	/**
	 * This method is used to set the BUCADNs List.
	 * @param bucAdnList the bucAdnList to set
	 */
	public void setBucAdnList(List<BUCAndADN> bucAdnList) {
		this.bucAdnList = bucAdnList;
	}

	/**
	 * This method is used to get the currencySetup instance object.
	 * @return the currencySetup
	 */
	public CurrencySetup getCurrencySetup() {
		return currencySetup;
	}

	/**
	 * This method is used to set the currencySetup instance object.
	 * @param currencySetup the currencySetup to set
	 */
	public void setCurrencySetup(CurrencySetup currencySetup) {
		this.currencySetup = currencySetup;
	}

	/**
	 * This method is used to get the invalid BUCADNs size.
	 * @return the invalidBUCADNSize
	 */
	public Integer getInvalidBUCADNSize() {
		return invalidBUCADNSize;
	}

	/**
	 * This method is used to set the invalid BUCADNs size.
	 * @param invalidBUCADNSize the invalidBUCADNSize to set
	 */
	public void setInvalidBUCADNSize(Integer invalidBUCADNSize) {
		this.invalidBUCADNSize = invalidBUCADNSize;
	}

	/**
	 * This method is used to set the SessionValues.
	 * @return the sessionValues
	 */
	public Map<String, Object> getSessionValues() {
		return sessionValues;
	}

	/**
	 * This method is used to get the the SessionValues
	 * @param sessionValues the sessionValues to set
	 */
	public void setSessionValues(Map<String, Object> sessionValues) {
		this.sessionValues = sessionValues;
	}

	/**
	 * This method is used to get pageFrom
	 * @return the pageFrom
	 */
	public String getPageFrom() {
		return pageFrom;
	}

	/**
	 * This method is used to set pageFrom
	 * @param pageFrom the pageFrom to set
	 */
	public void setPageFrom(String pageFrom) {
		this.pageFrom = pageFrom;
	}

	/**
	 * This is used to get the errorHandler
	 * @return the errorHandler
	 */
	public IErrorHandler getErrorHandler() {
		return errorHandler;
	}

	/**
	 * This is used to set the errorHandler
	 * @param errorHandler the errorHandler to set
	 */
	public void setErrorHandler(IErrorHandler errorHandler) {
		this.errorHandler = errorHandler;
	}

	/**
	 * This is used to get the errorMsg
	 * @return the errorMsg
	 */
	public String getErrorMsg() {
		return errorMsg;
	}

	/**
	 * This is used to set the errorMsg
	 * @param errorMsg the errorMsg to set
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	/**
	 * This method is used to get showCalculateFeeTable
	 * @return the showCalculateFeeTable
	 */
	public boolean isShowCalculateFeeTable() {
		return showCalculateFeeTable;
	}

	/**
	 * This method is used to set showCalculateFeeTable
	 * @param showCalculateFeeTable the showCalculateFeeTable to set
	 */
	public void setShowCalculateFeeTable(boolean showCalculateFeeTable) {
		this.showCalculateFeeTable = showCalculateFeeTable;
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
