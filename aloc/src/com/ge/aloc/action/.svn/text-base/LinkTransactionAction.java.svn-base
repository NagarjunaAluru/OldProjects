/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: LinkTransactionAction.java
 * Purpose: LinkTransactionAction used for Link/Unlink of Transactions
 */
package com.ge.aloc.action;

import static com.ge.aloc.constants.ALOCConstants.ALOCRECORDNUMBER;
import static com.ge.aloc.constants.ALOCConstants.LINKID;
import static com.ge.aloc.constants.ALOCConstants.REQUESTID;

import java.math.BigInteger;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.ge.aloc.DashboardViewType;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.exception.ALOCException;
import com.ge.aloc.manager.ILinkTransactionManager;
import com.ge.aloc.model.RequestDetails;
import com.hydus.hwf.exceptions.HWFServiceException;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author rguthi
 *
 */
public class LinkTransactionAction extends ActionSupport {	

	private static final long serialVersionUID = 5292944947872268009L;

	private ILinkTransactionManager linkTransactionManager;

	private String  linkRequestId;

	private DashboardViewType dashboardViewType;

	private RequestDetails requestDetails;	

	private List<RequestDetails> requestDetailsList ;

	private BigInteger alocRecordNumber;
	
	private BigInteger  linkId;
	

	/**
	 * This method is used for link and unlink transaction 
	 * information and fetch the results based on search criteria
	 * @return
	 * @throws HWFServiceException  
	 */
	public String loadLinkTransactions() throws HWFServiceException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String linkRequestId = (String)request.getParameter(REQUESTID);
		requestDetailsList  =  linkTransactionManager.loadLinkTransactions(linkRequestId).getRequestDetails();
		if(requestDetailsList.get(ALOCConstants.REQUESTDETAILS_BASE_INDEX).getLinkDetails()!=null)
			linkId = requestDetailsList.get(ALOCConstants.REQUESTDETAILS_BASE_INDEX).getLinkDetails().getLinkId();
		return SUCCESS;
	}

	/**
	 * This method is used for linking between a new request and a request 
	 * that has been submitted in the past
	 * @return
	 */
	public String linkTransaction() throws HWFServiceException,ALOCException {

		HttpServletRequest request = ServletActionContext.getRequest();
		String linkRequestId = (String)request.getParameter(REQUESTID);
		String linkedRequestId = (String)request.getParameter(ALOCRECORDNUMBER);
		requestDetailsList = linkTransactionManager.linkTransaction(linkRequestId,linkedRequestId);	
		if(requestDetailsList.get(ALOCConstants.REQUESTDETAILS_BASE_INDEX).getLinkDetails()!=null)
			linkId = requestDetailsList.get(ALOCConstants.REQUESTDETAILS_BASE_INDEX).getLinkDetails().getLinkId();
		return SUCCESS;
	}

	/**
	 * This method is used for unlink operation which are already linked  
	 * @return
	 */
	public String unLinkTransaction() throws HWFServiceException {
		HttpServletRequest request = ServletActionContext.getRequest();		
		String linkId = (String)request.getParameter(LINKID);
		String linkedRequestId = (String)request.getParameter(REQUESTID);
		requestDetails =  linkTransactionManager.unLinkTransaction(linkId,linkedRequestId);
		return SUCCESS;
	}


	/**
	 * 
	 * @return
	 */
	public BigInteger getLinkId() {
		return linkId;
	}

	/**
	 * 
	 * @param linkId
	 */
	public void setLinkId(BigInteger linkId) {
		this.linkId = linkId;
	}

	/**
	 * @return the linkTransactionManager
	 */
	public ILinkTransactionManager getLinkTransactionManager() {
		return linkTransactionManager;
	}

	/**
	 * @param linkTransactionManager the linkTransactionManager to set
	 */
	public void setLinkTransactionManager(
			ILinkTransactionManager linkTransactionManager) {
		this.linkTransactionManager = linkTransactionManager;
	}
	/**
	 * This is used to get the request details list.
	 * @return
	 */
	public List<RequestDetails> getRequestDetailsList() {
		return requestDetailsList;
	}
	/**
	 * This is used to set request details list.
	 * @param requestDetailsList
	 */
	public void setRequestDetailsList(List<RequestDetails> requestDetailsList) {
		this.requestDetailsList = requestDetailsList;
	}
	/**
	 * This is used to get link request Id.
	 * @return
	 */
	public String getLinkRequestId() {
		return linkRequestId;
	}
	/**
	 * This is used set link request Id.
	 * @param linkRequestId
	 */
	public void setLinkRequestId(String linkRequestId) {
		this.linkRequestId = linkRequestId;
	}
	/**
	 * This is used to get request details object.
	 * @return
	 */
	public RequestDetails getRequestDetails() {
		return requestDetails;
	}
	/**
	 * This is used to set the request details object.
	 * @param requestDetails
	 */
	public void setRequestDetails(RequestDetails requestDetails) {
		this.requestDetails = requestDetails;
	}


	/**
	 * This is used to get dashboard view Type.
	 * @return the dashboardViewType
	 */
	public DashboardViewType getDashboardViewType() {
		return dashboardViewType;
	}

	/**
	 * @param dashboardViewType the dashboardViewType to set
	 */
	public void setDashboardViewType(DashboardViewType dashboardViewType) {
		this.dashboardViewType = dashboardViewType;
	}

	/**
	 * This is used to get alocRecordNumber.
	 * @return the alocRecordNumber
	 */
	public BigInteger getAlocRecordNumber() {
		return alocRecordNumber;
	}

	/**
	 * This is used to set alocRecordNumber.
	 * @param alocRecordNumber the alocRecordNumber to set
	 */
	public void setAlocRecordNumber(BigInteger alocRecordNumber) {
		this.alocRecordNumber = alocRecordNumber;
	}
}
