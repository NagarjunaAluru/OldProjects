/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: SuretyNameMgmtAction.java
 * Purpose: SuretyNameMgmtAction used for maintaining Fee History.
 *
 */
package com.ge.aloc.action.apm;

import static com.ge.aloc.constants.ALOCConstants.SUCCESS;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.manager.apm.IFeeHistoryManager;
import com.ge.aloc.model.APMDetails;
import com.ge.aloc.model.PaymentDetail;
import com.ge.aloc.model.PaymentDetailCollection;
import com.ge.aloc.model.StaticDataManagement.UserSites;
import com.ge.aloc.util.APMDetailsHelper;
import com.hydus.hwf.exceptions.HWFServiceException;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author Rajat-Hydus
 * 
 */
public class FeeHistoryAction {

	private IFeeHistoryManager feeHistoryManager;
	private PaymentDetailCollection  paymentDetailList;
	private PaymentDetail  paymentDetail;
	protected APMDetails apmDetails;
	protected Map<String, Object> sessionValues = ActionContext.getContext().getSession();
	private HttpServletRequest request = ServletActionContext.getRequest();
	private List<UserSites> userSpecificSitesList;

	/**
	 * Method to get the Default fee history Details - Top Level View
	 * @return
	 * @throws HWFServiceException
	 */
	@SuppressWarnings("unchecked")
	public String searchFeeHistory() throws HWFServiceException {
		String defViewType = null;
		userSpecificSitesList=(List<UserSites>) sessionValues.get(ALOCConstants.USERSPECIFICSITES); 
		
		defViewType = request.getParameter(ALOCConstants.DEF_VIEW_TYPE);
		if(defViewType!=null){
			apmDetails=(APMDetails)sessionValues.get(ALOCConstants.FEE_HISTORY_DETAILS);
			apmDetails = APMDetailsHelper.assignDecimalValue(apmDetails);
			return ALOCConstants.DEFVIWPAGE;
		}else {
			sessionValues.remove(ALOCConstants.FEE_HISTORY_DETAILS);
			sessionValues.remove(ALOCConstants.FEEHISTORY_SEARCH);
			return SUCCESS;
		}

	}

	/**
	 * This Method is used to export fee history Invoice Details
	 * @return
	 * @throws Exception 
	 */
	public void exportInvoiceFeeHistory() throws HWFServiceException {
		String paymentIds = request.getParameter(ALOCConstants.PAYMENT_IDS);
		String alocRecNos = request.getParameter(ALOCConstants.ALOC_REC_NOS);

		apmDetails = feeHistoryManager.exportInvoiceFeeHistory(alocRecNos, paymentIds);

		APMDetailsHelper apmHelper=new APMDetailsHelper();
		apmHelper.exportInvoiceFeeHistory(apmDetails);
	}
	
	/**
	 * This Method is used to export Fee History Search Results 
	 * @return
	 * @throws Exception 
	 */
	public void downloadFHSearchResults() throws Exception {
		
		apmDetails=sessionValues.get(ALOCConstants.FEE_HISTORY_DETAILS) != null?
				(APMDetails)sessionValues.get(ALOCConstants.FEE_HISTORY_DETAILS):null;
				
		String searchCriteria = sessionValues.get(ALOCConstants.FEEHISTORY_SEARCH) != null ?
				(String) sessionValues.get(ALOCConstants.FEEHISTORY_SEARCH):ALOCConstants.EMPTY_STRING;

		APMDetailsHelper apmHelper=new APMDetailsHelper();
		apmHelper.exportSeachFeeHistoryData(apmDetails,searchCriteria);
	}

	/* ----------------------------------------------------------------------------------------------------------------------------------
	 * 														INJECTOR METHODS
	 ------------------------------------------------------------------------------------------------------------------------------------ */

	/**
	 * This is used to create apmDetails instance object.
	 * @return
	 */
	public APMDetails getApmDetails() {
		return apmDetails;
	}

	/**
	 * This is used to create apmDetails instance object.
	 * @param apmDetails
	 */
	public void setApmDetails(APMDetails apmDetails) {
		this.apmDetails = apmDetails;
	}
	/**
	 * This is used to create feeHistoryManager instance object.
	 * @return the feeHistoryManager
	 */
	public IFeeHistoryManager getFeeHistoryManager() {
		return feeHistoryManager;
	}
	/**
	 * This is used to create paymentDetailList instance object.
	 * @return the paymentDetailList
	 */
	public PaymentDetailCollection getPaymentDetailList() {
		return paymentDetailList;
	}
	/**
	 * This is used to create paymentDetail instance object.
	 * @return the paymentDetail
	 */
	public PaymentDetail getPaymentDetail() {
		return paymentDetail;
	}
	/**
	 * This is used to set the feeHistoryManager instance object.
	 * @param feeHistoryManager the feeHistoryManager to set
	 */
	public void setFeeHistoryManager(IFeeHistoryManager feeHistoryManager) {
		this.feeHistoryManager = feeHistoryManager;
	}
	/**
	 * This is used to set paymentDetail list.
	 * @param paymentDetailList the paymentDetailList to set
	 */
	public void setPaymentDetailList(PaymentDetailCollection paymentDetailList) {
		this.paymentDetailList = paymentDetailList;
	}
	/**
	 * This is used to set paymentDetai.
	 * @param paymentDetail the paymentDetail to set
	 */
	public void setPaymentDetail(PaymentDetail paymentDetail) {
		this.paymentDetail = paymentDetail;
	}

	/**
	 * This method is used to get the userSpecificSites List.
	 * @return the userSpecificSiteesList
	 */
	public List<UserSites> getUserSpecificSitesList() {
		return userSpecificSitesList;
	}

	/**
	 * This method is used to set the userSpecificSites List.
	 * @param userSpecificSitesList the userSpecificSitesList to set
	 */
	public void setUserSpecificSitesList(List<UserSites> userSpecificSitesList) {
		this.userSpecificSitesList = userSpecificSitesList;
	}
}
