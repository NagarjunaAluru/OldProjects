/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ChangeRequestOwnershipAction.java
 * Purpose: ChangeRequestOwnershipAction used for search and change the requests ownership
 */
package com.ge.aloc.action.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.manager.IReferenceDataManager;
import com.ge.aloc.manager.admin.IChangeRequestOwnershipManager;
import com.ge.aloc.model.RequestorSearchRequest;
import com.ge.aloc.model.RequestorTransaction;
import com.ge.aloc.model.RequestorTrasactionsReply;
import com.ge.aloc.model.StaticDataManagement.UserSites;
import com.hydus.hwf.exceptions.ErrorData;
import com.hydus.hwf.exceptions.HWFServiceException;
import com.hydus.hwf.exceptions.IErrorHandler;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.ValidationWorkflowAware;

/**
 * @author madhavi.pathella
 *
 */
public class ChangeRequestOwnershipAction extends ActionSupport implements ValidationWorkflowAware{

	private static final long serialVersionUID = 1042029472193471310L;
	
	private IChangeRequestOwnershipManager changeRequestOwnershipManager;
	private IReferenceDataManager referenceDataManager;
	private List<UserSites> businessSitesList = new ArrayList<UserSites>();
	private String selBusinessSiteCd;
	private String selBusinessSiteName;
	private RequestorSearchRequest requestorSearchRequest;
	private RequestorTrasactionsReply requestorTrasactionsReply;
	private List<RequestorTransaction> requestorTransactionList = new ArrayList<RequestorTransaction>();
	private boolean errorShow;
	private IErrorHandler errorHandler;	
	private String errorMsg;
	
	/**
	 * This method decides the page to display on validation error conditions
	 */
	@SuppressWarnings("unchecked")
	public String getInputResultName() {
		errorShow = true;
		requestorTrasactionsReply.setRequestorBusinessSite(selBusinessSiteName);
		businessSitesList = (List<UserSites>)ServletActionContext.getRequest().getSession().getAttribute(ALOCConstants.BUSINESSSITE_NAMES);
		return INPUT;
	}
	
	/**
	 * Method to get requester Details List for selected search criteria.
	 * @return
	 * @throws HWFServiceException
	 */
	public String openChangeRequestOwnership() throws HWFServiceException
	{
		businessSitesList = referenceDataManager.getBusinessSiteNames();
		ServletActionContext.getRequest().getSession().setAttribute(ALOCConstants.BUSINESSSITE_NAMES, businessSitesList);
		return SUCCESS;
	}
	
	/**
	 * Method to get search available requests for selected requester.
	 * @return
	 * @throws HWFServiceException
	 */
	public String searchSelOwnerRequestDetails() throws HWFServiceException
	{
		selBusinessSiteName = requestorTrasactionsReply.getRequestorBusinessSite();
		requestorTrasactionsReply = changeRequestOwnershipManager.searchSelOwnerRequestDetails(requestorTrasactionsReply);
		requestorTransactionList = requestorTrasactionsReply.getRequestorTransactions();
		return SUCCESS;
	}
	
	/**
	 * Method to change the ownership of selected requests with given new requestor.
	 * @return
	 * @throws HWFServiceException
	 */
	public String changeSelectedRequestsOwnership() throws HWFServiceException
	{
		try
		{
			requestorTrasactionsReply = changeRequestOwnershipManager.changeSelectedRequestsOwnership(requestorTrasactionsReply,requestorTransactionList);
		}catch(HWFServiceException hse){	
			ErrorData errorData = errorHandler.handle(hse);
			this.errorMsg = errorData.getCause().getMessage();				
			return INPUT;
		}
		HttpSession session = ServletActionContext.getRequest().getSession();
		if(requestorTrasactionsReply !=null && requestorTrasactionsReply.getMsgHeader().getStatus() !=null){
		session.setAttribute(ALOCConstants.PORTAL_SUCCESSMSG,requestorTrasactionsReply.getMsgHeader().getStatus());}
		return ALOCConstants.TREASURYADMINPORTAL;
	}
	
	/**
	 * Method to get the changeRequestOwnershipManager object instance.
	 * @return the changeRequestOwnershipManager
	 */
	public IChangeRequestOwnershipManager getChangeRequestOwnershipManager() {
		return changeRequestOwnershipManager;
	}

	/**
	 * Method to set the changeRequestOwnershipManager object instance.
	 * @param changeRequestOwnershipManager the changeRequestOwnershipManager to set
	 */
	public void setChangeRequestOwnershipManager(
			IChangeRequestOwnershipManager changeRequestOwnershipManager) {
		this.changeRequestOwnershipManager = changeRequestOwnershipManager;
	}
	
	/**
	 * Method to get the selBusinessSiteCd value.
	 * @return the selBusinessSiteCd
	 */
	public String getSelBusinessSiteCd() {
		return selBusinessSiteCd;
	}

	/**
	 * Method to set the selBusinessSiteCd value.
	 * @param selBusinessSiteCd the selBusinessSiteCd to set
	 */
	public void setSelBusinessSiteCd(String selBusinessSiteCd) {
		this.selBusinessSiteCd = selBusinessSiteCd;
	}

	/**
	 * Method to get the selBusinessSiteName value.
	 * @return the selBusinessSiteName
	 */
	public String getSelBusinessSiteName() {
		return selBusinessSiteName;
	}

	/**
	 * Method to set the selBusinessSiteName value.
	 * @param selBusinessSiteName the selBusinessSiteName to set
	 */
	public void setSelBusinessSiteName(String selBusinessSiteName) {
		this.selBusinessSiteName = selBusinessSiteName;
	}
	
	/**
	 * Method to get the referenceDataManager value.
	 * @return the referenceDataManager
	 */
	public IReferenceDataManager getReferenceDataManager() {
		return referenceDataManager;
	}

	/**
	 * Method to set the referenceDataManager value.
	 * @param referenceDataManager the referenceDataManager to set
	 */
	public void setReferenceDataManager(IReferenceDataManager referenceDataManager) {
		this.referenceDataManager = referenceDataManager;
	}
	
	/**
	 * Method to get the businessSitesList value.
	 * @return the businessSitesList
	 */
	public List<UserSites> getBusinessSitesList() {
		return businessSitesList;
	}

	/**
	 * Method to set the businessSitesList value.
	 * @param businessSitesList the businessSitesList to set
	 */
	public void setBusinessSitesList(List<UserSites> businessSitesList) {
		this.businessSitesList = businessSitesList;
	}
	
	/**
	 * Method to get the requestorSearchRequest value.
	 * @return the requestorSearchRequest
	 */
	public RequestorSearchRequest getRequestorSearchRequest() {
		return requestorSearchRequest;
	}

	/**
	 * Method to set the requestorSearchRequest value.
	 * @param requestorSearchRequest the requestorSearchRequest to set
	 */
	public void setRequestorSearchRequest(
			RequestorSearchRequest requestorSearchRequest) {
		this.requestorSearchRequest = requestorSearchRequest;
	}
	
	/**
	 * Method to get the requestorTrasactionsReply value.
	 * @return the requestorTrasactionsReply
	 */
	public RequestorTrasactionsReply getRequestorTrasactionsReply() {
		return requestorTrasactionsReply;
	}

	/**
	 * Method to set the requestorTrasactionsReply value.
	 * @param requestorTrasactionsReply the requestorTrasactionsReply to set
	 */
	public void setRequestorTrasactionsReply(
			RequestorTrasactionsReply requestorTrasactionsReply) {
		this.requestorTrasactionsReply = requestorTrasactionsReply;
	}
	
	/**
	 * Method to get the requestorTransactionList value.
	 * @return the requestorTransactionList
	 */
	public List<RequestorTransaction> getRequestorTransactionList() {
		return requestorTransactionList;
	}

	/**
	 * Method to set the requestorTransactionList value.
	 * @param requestorTransactionList the requestorTransactionList to set
	 */
	public void setRequestorTransactionList(
			List<RequestorTransaction> requestorTransactionList) {
		this.requestorTransactionList = requestorTransactionList;
	}
	
	/**
	 * Method to get the errorShow value.
	 * @return the errorShow
	 */
	public boolean isErrorShow() {
		return errorShow;
	}

	/**
	 * Method to set the errorShow value.
	 * @param errorShow the errorShow to set
	 */
	public void setErrorShow(boolean errorShow) {
		this.errorShow = errorShow;
	}
	
	/**
	 * Method to get the errorHandler value.
	 * @return the errorHandler
	 */
	public IErrorHandler getErrorHandler() {
		return errorHandler;
	}

	/**
	 * Method to set the errorHandler value.
	 * @param errorHandler the errorHandler to set
	 */
	public void setErrorHandler(IErrorHandler errorHandler) {
		this.errorHandler = errorHandler;
	}

	/**
	 * Method to get the errorMsg value.
	 * @return the errorMsg
	 */
	public String getErrorMsg() {
		return errorMsg;
	}

	/**
	 * Method to set the errorMsg value.
	 * @param errorMsg the errorMsg to set
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
}
