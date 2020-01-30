/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: DefaultDashboardManager.java
 * Purpose: DefaultDashboardManager used for the transactions,draft,my request 
 * and other business methods
 */
package com.ge.aloc.manager.impl.dashboard;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.ge.aloc.DashboardViewType;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.dao.dashboard.IDashboardDAO;
import com.ge.aloc.manager.dashboard.IDashboardManager;
import com.ge.aloc.model.BundleDetails;
import com.ge.aloc.model.Inbox;
import com.ge.aloc.model.RequestDetails;
import com.ge.aloc.model.RequestDetailsCollectionType;
import com.ge.aloc.model.Search;
import com.ge.aloc.util.ALOCCommonHelper;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author chaitanya.n
 * 
 */
public class DefaultDashboardManager implements IDashboardManager {

	private IDashboardDAO commonDashboardDAO;

	RequestDetails requestDetails=new RequestDetails();

	/**
	 * Method to save default dashboard view
	 * @param defaultTab
	 * @return
	 * @throws HWFServiceException 
	 */
	public String saveDefaultDisplayTabName(Object defaultTab) throws HWFServiceException {
		Inbox inbox = new Inbox();
		if(defaultTab != null){
		inbox.setDefaultView(defaultTab.toString());
		commonDashboardDAO.saveDefaultDisplayTabName(inbox);
		}
		return null;
	}

	/**
	 * Method to display Dashboard Details of all types
	 * @return
	 * @throws HWFServiceException 
	 */
	public Inbox loadDashboardData(DashboardViewType dashboardViewType)
			throws HWFServiceException {
		Inbox inbox = new Inbox();
		inbox = commonDashboardDAO.loadDashboardData(inbox,dashboardViewType);
		if(dashboardViewType.getOpCode().getOperationCode().equals(ALOCConstants.GETBUNDLE))
		{
			if(inbox.getBundle() != null)
			{
				inbox = ALOCCommonHelper.getInboxDetailByBundleId(inbox);
			}
		}
		return inbox;
	}

	/**
	 * Method to display default Dashboard Details of all types
	 * @return
	 * @throws HWFServiceException
	 */
	public Inbox loadDefaultDashboardData() throws HWFServiceException {
		Inbox inbox = new Inbox();
		return commonDashboardDAO.loadDashboardData(inbox,null);
	}

	/**
	 *  Method to get the my transactions details based on glance selection
	 * 
	 * @return
	 * @throws HWFServiceException 
	 */
	public Inbox getGlanceDetails() throws HWFServiceException {
		Inbox inbox=new Inbox();
		Search search=new Search();
		String glancecount=ALOCConstants.EMPTY_STRING;
		HttpServletRequest request=ServletActionContext.getRequest();
		String instrumentPurpose=request.getParameter(ALOCConstants.GLANCEPARAM);
		glancecount=request.getParameter(ALOCConstants.GLANCECOUNT);
		search=ALOCCommonHelper.createSearch(instrumentPurpose);
		inbox=commonDashboardDAO.getGlanceDetails(search,glancecount);	
		return inbox;
	}
	/**
	 * Method to delete selected request from Dashboard
	 * 
	 * @param requestId
	 * @return
	 * @throws HWFServiceException
	 */
	public RequestDetails deleteRequest(String requestId) throws HWFServiceException {
		RequestDetails requestDetails = new RequestDetails();
		requestDetails.setRequestId(new BigInteger(requestId));
		requestDetails = commonDashboardDAO.deleteRequest(requestDetails);
		return requestDetails;
	}

	/**
	 * Method to enable the selected Model
	 * 
	 * @param dashboardViewType
	 * @param requestId
	 * @return
	 * @throws HWFServiceException
	 */
	public Inbox enableModel(DashboardViewType dashboardViewType,String requestId) throws HWFServiceException {
		Inbox inbox = new Inbox();		
		RequestDetails requestDetails = new RequestDetails();
		requestDetails.setRequestId(new BigInteger(requestId));		
		List<RequestDetails> requestDetailList = new ArrayList<RequestDetails>();
		requestDetailList.add(requestDetails);		
		RequestDetailsCollectionType requestDetailsCollectionList = new RequestDetailsCollectionType();
		requestDetailsCollectionList.setRequestDetails(requestDetailList);		
		inbox.setModels(requestDetailsCollectionList);
		inbox = commonDashboardDAO.enableModel(inbox);
		return inbox;
	}

	/**
	 * Method to disable the selected Model
	 * 
	 * @param dashboardViewType
	 * @param requestId	 * 
	 * @return
	 * @throws HWFServiceException
	 */
	public Inbox disableModel(DashboardViewType dashboardViewType,String requestId) throws HWFServiceException {
		Inbox inbox = new Inbox();
		RequestDetails requestDetails = new RequestDetails();
		requestDetails.setRequestId(new BigInteger(requestId));
		List<RequestDetails> requestDetailList = new ArrayList<RequestDetails>();
		requestDetailList.add(requestDetails);
		RequestDetailsCollectionType requestDetailsCollectionList = new RequestDetailsCollectionType();
		requestDetailsCollectionList.setRequestDetails(requestDetailList);
		inbox.setModels(requestDetailsCollectionList);
		inbox = commonDashboardDAO.disableModel(inbox);
		return inbox;
	}

	/**
	 * Method to delete the selected Model
	 * 
	 * @param dashboardViewType
	 * @param requestId
	 * @return
	 * @throws HWFServiceException
	 */
	public Inbox deleteModel(DashboardViewType dashboardViewType,String requestId) throws HWFServiceException {
		Inbox inbox = new Inbox();
		RequestDetails requestDetails = new RequestDetails();
		requestDetails.setRequestId(new BigInteger(requestId));
		List<RequestDetails> requestDetailList = new ArrayList<RequestDetails>();
		requestDetailList.add(requestDetails);
		RequestDetailsCollectionType requestDetailsCollectionList = new RequestDetailsCollectionType();
		requestDetailsCollectionList.setRequestDetails(requestDetailList);
		inbox.setModels(requestDetailsCollectionList);
		inbox = commonDashboardDAO.deleteModel(inbox);
		return inbox;
	}

	/**
	 * Method to get all requests details for selected Bundle
	 * 
	 * @param dashboardViewType
	 * @param requestId
	 * @return
	 * @throws HWFServiceException
	 */
	public Inbox getAllRequestInfoForSelBundle(DashboardViewType dashboardViewType, String bundleId)
			throws HWFServiceException {
		Inbox inbox = new Inbox();
		RequestDetails requestDetails = new RequestDetails();
		BundleDetails bundleDetails = new BundleDetails();
		bundleDetails.setBundleId(new BigInteger(bundleId));
		requestDetails.setBundleDetails(bundleDetails);
		List<RequestDetails> requestDetailList = new ArrayList<RequestDetails>();
		requestDetailList.add(requestDetails);
		RequestDetailsCollectionType requestDetailsCollectionList = new RequestDetailsCollectionType();
		requestDetailsCollectionList.setRequestDetails(requestDetailList);
		inbox.setBundle(requestDetailsCollectionList);
		inbox = commonDashboardDAO.loadDashboardData(inbox,dashboardViewType);
		return inbox;
	}

	/*
	 * -------------------------------------------------------------------------
	 * 					Start Service Injections
	 * -------------------------------------------------------------------------
	 */

	/**
	 * This method is used to get the commonDashboardDAO instance object.
	 * @return the commonDashboardDAO
	 */
	public IDashboardDAO getCommonDashboardDAO() {
		return commonDashboardDAO;
	}

	/**
	 * This method is used to create the commonDashboardDAO instance object.
	 * @param commonDashboardDAO the commonDashboardDAO to set
	 */
	public void setCommonDashboardDAO(IDashboardDAO commonDashboardDAO) {
		this.commonDashboardDAO = commonDashboardDAO;
	}

	/*
	 * -------------------------------------------------------------------------
	 * 					End Service Injections
	 * -------------------------------------------------------------------------
	 */
}
