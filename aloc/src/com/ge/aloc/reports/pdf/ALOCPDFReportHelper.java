/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ALOCPDFReportHelper.java
 * Purpose: ALOCPDFReportHelper used helper for the PDF report
 */

package com.ge.aloc.reports.pdf;

import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_CURRENCY_FORMAT;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_DATE_FORMAT;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_FALSE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_NO_CAP;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_TRUE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_YES_CAP;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.manager.ICreateBundleManager;
import com.ge.aloc.manager.ILinkTransactionManager;
import com.ge.aloc.manager.IRequestDetailsManager;
import com.ge.aloc.manager.IRequestDetailsSectionManager;
import com.ge.aloc.manager.impl.LinkTransactionManager;
import com.ge.aloc.manager.impl.RequestDetailsManager;
import com.ge.aloc.manager.impl.admin.ReimbursementAgreementMgmtManager;
import com.ge.aloc.model.AddressDtls;
import com.ge.aloc.model.CurrentBankFees;
import com.ge.aloc.model.FeeHistoryDetails;
import com.ge.aloc.model.GetAmendmentRiders;
import com.ge.aloc.model.Reimbursement;
import com.ge.aloc.model.ReimbursementAgreement;
import com.ge.aloc.model.RequestDetails;
import com.ge.aloc.model.RequestDetailsCollectionType;
import com.ge.aloc.reports.pdf.request.RequestPDFConstants;
import com.hydus.hwf.exceptions.HWFServiceException;
import com.hydus.hwf.util.StringUtils;
/**
 * This is helper class for PDF report generation.
 * 
 * @author narasimhulu
 *
 */
public class ALOCPDFReportHelper {

	private static ReportContext reportContext;

	/**
	 * This method is used to get reportContext
	 * @return the reportContext
	 */
	public ReportContext getReportContext() {
		return reportContext;
	}

	/**
	 * This method is used to set reportContext
	 * @param reportContext the reportContext to set
	 */
	public static void setReportContext(ReportContext context) {
		reportContext = context;
	}

	/**
	 * This method is used to get resource value from the reportContext
	 * @param key
	 * @return
	 */
	public static String getResourceValue(String key) {
		return reportContext.getResourceBundle().getString(key);
	}

	/**
	 * This method converts string value to Yes or No.
	 * 
	 * @param value
	 * @return
	 */
	public static String convertStringAsYesOrNo(String value) {
		String result = null;
		if (value != null) {
			if (value.equalsIgnoreCase(getResourceValue(RES_KEY_TRUE))) {
				result = getResourceValue(RES_KEY_YES_CAP);

			} else if (value.equalsIgnoreCase(getResourceValue(RES_KEY_FALSE))) {
				result = getResourceValue(RES_KEY_NO_CAP);

			}

		}
		return result;
	}

	/**
	 * This method converts boolean variable to Yes or No.
	 * 
	 * @param value
	 * @return
	 */

	public static String convertBooleanAsYesOrNo(Boolean value) {
		String result = null;
		if(value != null) {
			result = (value) ? getResourceValue(RES_KEY_YES_CAP) : getResourceValue(RES_KEY_NO_CAP);
		}
		return result;
	}

	/**
	 * Returns the aloc date format(MMM-dd-yyyy)
	 * 
	 * @param formatDate
	 * @param cal
	 * @return
	 */
	public static String formatDate(Calendar cal) {
		if(cal == null) {
			return null;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(getResourceValue(RES_KEY_DATE_FORMAT));
		return dateFormat.format(cal.getTime());
	}
	
	/**
	 * Returns the aloc Time Format
	 * @param formatDate
	 * @param cal
	 * @return
	 */
	public static String formatTime(String time) {
		
		StringBuilder dateTime = new StringBuilder();
		
		String hours = ALOCConstants.EMPTY_STRING;
		String minutes = ALOCConstants.EMPTY_STRING;
		String period = ALOCConstants.EMPTY_STRING;
		int baseVal = ALOCConstants.BASE_VALUE;
		int minVal = ALOCConstants.MIN_VALUE;
		int secondVal = ALOCConstants.SECOND_VALUE;
		if(StringUtils.isNotBlank(time)){
			String[] timeArr = time.split(ALOCConstants.COMMA);
			minutes = timeArr.length > baseVal ? timeArr[baseVal] : ALOCConstants.EMPTY_STRING;
			hours = timeArr.length > minVal ? timeArr[minVal] : ALOCConstants.EMPTY_STRING;
			period = timeArr.length > secondVal ? timeArr[secondVal] : ALOCConstants.EMPTY_STRING;
		}
		if(StringUtils.isNotBlank(hours)){
			int hoursIntVal = Integer.parseInt(hours);
			if(hoursIntVal >= ALOCConstants.MIN_HOURS  && hoursIntVal < ALOCConstants.MAX_HOURS)
				hours = ALOCConstants.BASE_VALUE+hours;
		}
		if(StringUtils.isNotBlank(minutes)){
			int minutesIntVal = Integer.parseInt(minutes);
			if(minutesIntVal >= ALOCConstants.MIN_MINUTES  && minutesIntVal < ALOCConstants.MAX_MINUTES)
				minutes = ALOCConstants.BASE_VALUE+minutes;
		}
		if(StringUtils.isNotBlank(hours)){
			dateTime.append(hours).append(ALOCConstants.COLON);
		}
		if(StringUtils.isNotBlank(minutes) && dateTime.length() > ALOCConstants.BASE_VALUE){
			dateTime.append(minutes).append(ALOCConstants.EMPTY_SPACE_STRING);
		}
		if(StringUtils.isNotBlank(period) && dateTime.length() > ALOCConstants.BASE_VALUE){
			dateTime.append(period);
		}
		if(dateTime != null && dateTime.length() > ALOCConstants.BASE_VALUE){
			time = dateTime.toString();
		}else{
			time = ALOCConstants.EMPTY_STRING;
		}
		return time;
	}

	/**
	 * Helper method to formats the amount.
	 * 
	 * @param currency
	 * @return
	 */
	public static String formatCurrency(BigDecimal currency) {
		if(currency == null) {
			return null;
		}
		DecimalFormat currencyFormatter = new DecimalFormat(getResourceValue(RES_KEY_CURRENCY_FORMAT));
		String currencyAsString = currencyFormatter.format(currency);
		return String.valueOf(currencyAsString);
	}

	/**
	 * Helper method to get the ReimbursementAgreementText based on the agreementID.
	 * @param reimbursementAgreementId BigInteger
	 * @return reimbursementText
	 */
	public static String getReimbursementAgreementData(BigInteger reimbursementAgreementId) throws HWFServiceException {
		String result = null;
		if (reimbursementAgreementId != null) {
			Reimbursement reimbursement = new Reimbursement();
			reimbursement.setReimbursementAgreement(new ReimbursementAgreement());
			reimbursement.getReimbursementAgreement().setReimbursementAgreementId(reimbursementAgreementId);
			WebApplicationContext context = getWebApplicationContext();
			ReimbursementAgreementMgmtManager reimbursementAgreementMgmtManager = (ReimbursementAgreementMgmtManager) context
					.getBean(RequestPDFConstants.REIMBURSMENT_AGREEMENT_MANAGER);
			reimbursement = reimbursementAgreementMgmtManager.loadReimbursementAgreementDetailsById(reimbursement);
			if (reimbursement != null) {
				result = (reimbursement.getReimbursementAgreement() != null) ? 
						reimbursement.getReimbursementAgreement().getAgreementText() : null;
			}
		}
		return result;
	}

	/**
	 * This method to get Address Details as String Array.
	 * 
	 * @param addressDtls
	 * @return
	 */

	public static String[] convertAddressAsString(AddressDtls addressDtls) {

		String address1 = null;
		String address2 = null;
		if (addressDtls.getAddress() != null
				&& !addressDtls.getAddress().isEmpty()) {

			if (addressDtls.getAddress().get(ALOCConstants.BASE_VALUE) != null) {
				address1 = addressDtls.getAddress().get(ALOCConstants.BASE_VALUE);
			}
			if (addressDtls.getAddress().size() > ALOCConstants.MIN_VALUE
					&& addressDtls.getAddress().get(ALOCConstants.MIN_VALUE) != null) {
				address2 = addressDtls.getAddress().get(ALOCConstants.MIN_VALUE);
			}
		}
		String[] addressValues = { addressDtls.getName(), address1, address2,
				addressDtls.getCity(), addressDtls.getStateProvince(),
				addressDtls.getZIPPostalCode(), addressDtls.getCountry() };

		return addressValues;

	}

	/**
	 * This method to get WebApplicationContext.
	 * 
	 * @param
	 * @return
	 */

	private static WebApplicationContext getWebApplicationContext() {
		return WebApplicationContextUtils
				.getRequiredWebApplicationContext(ServletActionContext
						.getServletContext());
	}


	/**
	 * Helper method to get the GetAmendment based on the requestID.
	 * 
	 * @param requestId BigInteger and instrumentType
	 * @return GetAmendmentRiders
	 */
	public static GetAmendmentRiders getAmendmentDetails(BigInteger requestId) throws HWFServiceException {
		GetAmendmentRiders amendments = null;
		if (requestId != null) {
			WebApplicationContext context = getWebApplicationContext();
			IRequestDetailsManager requestDetailsManager = (RequestDetailsManager) context
					.getBean(RequestPDFConstants.REQUESTDETAILSMANAGER);
				amendments = requestDetailsManager.getAmendments(requestId);
		}
		return amendments;
	}
	
	/**
	 * Helper method to get the GetRider details based on the requestID.
	 * 
	 * @param requestId BigInteger and instrumentType
	 * @return GetAmendmentRiders
	 */
	public static GetAmendmentRiders getRiderDetails(BigInteger requestId) throws HWFServiceException {
		GetAmendmentRiders riders = null;
		if (requestId != null) {
			WebApplicationContext context = getWebApplicationContext();
			IRequestDetailsManager requestDetailsManager = (RequestDetailsManager) context
					.getBean(RequestPDFConstants.REQUESTDETAILSMANAGER);
			riders = requestDetailsManager.getRiders(requestId);
		}
		return riders;
	}

	
	/**
	 * Helper method to get the Fee History Details based on the requestId.
	 * 
	 * @param requestId BigInteger
	 * @return GetFeeHistoryDetails
	 */
	public static FeeHistoryDetails getFeeHisory(BigInteger requestId) throws HWFServiceException {
		FeeHistoryDetails feeHistoryDetails = null;
			if (requestId != null) {
				WebApplicationContext context = getWebApplicationContext();
				IRequestDetailsManager requestDetailsManager = (RequestDetailsManager) context
						.getBean(RequestPDFConstants.REQUESTDETAILSMANAGER);
				feeHistoryDetails = requestDetailsManager.getFeeHistory(requestId);
			}
		return feeHistoryDetails;
	}
	
	/**
	 * Helper method to get the Competing Bid replies details based on the requestId
	 * @param requestId
	 * @return
	 * @throws HWFServiceException
	 */
	public static CurrentBankFees getCompetingBidReplies(BigInteger requestId)
			throws HWFServiceException {
		CurrentBankFees currBankFees = null;
		if (requestId != null) {
			WebApplicationContext context = getWebApplicationContext();
			IRequestDetailsManager requestDetailsManager = (RequestDetailsManager) context
					.getBean(RequestPDFConstants.REQUESTDETAILSMANAGER);
			currBankFees = requestDetailsManager.getCompBidReplies(requestId);
		}
		return currBankFees;
	}
	
	/**
	 * Helper method to get the linked transaction details based on the requestId
	 * @param requestId
	 * @return
	 * @throws HWFServiceException
	 */
	public static RequestDetailsCollectionType getLinkedTransactions(BigInteger requestId) throws HWFServiceException {
		RequestDetailsCollectionType reqDetails = null;
		if (requestId != null) {
				WebApplicationContext context = getWebApplicationContext();
				ILinkTransactionManager iLinkTranManager = (LinkTransactionManager) context.getBean(RequestPDFConstants.LINKTRANSACTIONMANAGER);
				reqDetails = iLinkTranManager.loadLinkTransactions(requestId.toString());
		}
		return reqDetails;
	}
	
	/**
	 * Helper method to get the bundled transaction details based on the bundleId
	 * @param requestDetails
	 * @return
	 * @throws HWFServiceException
	 */
	public static List<RequestDetails> getBundleTransactions(RequestDetails requestDetails) throws HWFServiceException {
		List<RequestDetails> reqDetailslst = new ArrayList<RequestDetails>();
		WebApplicationContext context = getWebApplicationContext();
		ICreateBundleManager ibundleManager = (ICreateBundleManager) context.getBean(RequestPDFConstants.CREATEBUNDLEMANAGER);

		BigInteger requestId = requestDetails.getRequestId();
		if(requestId!=null && requestDetails.getBundleDetails()!=null 
				&& requestDetails.getBundleDetails().getBundleId()!=null){
			String bundleId = requestDetails.getBundleDetails().getBundleId().toString();
			reqDetailslst  =  ibundleManager.getRequestsForBundle(bundleId);
		}
		return reqDetailslst;
	}
	
	/**
	 * Helper method to get the all the Transaction/Audit Log details based on the requestID.
	 * @param stageName
	 * @param logType
	 * @param resquestID
	 * @param requestDetail
	 * @return
	 * @throws HWFServiceException
	 */
	public static RequestDetails getTransactionAuditLogDetails(String stageName, String logType,BigInteger resquestID,RequestDetails requestDetail) throws HWFServiceException {
		if (resquestID != null) {
			WebApplicationContext context = getWebApplicationContext();
			IRequestDetailsSectionManager requestDetailsSectionManager = (IRequestDetailsSectionManager) context
					.getBean(RequestPDFConstants.REQUESTDETAILSSECTIONMANAGER);
			requestDetail = requestDetailsSectionManager.getFullAuditandActionLog(stageName, logType, resquestID, requestDetail);
		}
		return requestDetail;
	}
	
}
