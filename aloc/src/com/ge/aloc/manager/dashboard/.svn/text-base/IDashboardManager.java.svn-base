/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: IDashboardManager.java
 * Purpose: IDashboardManager used for the bundle Dashboard data for draft,my tranaction, my request and 
 *  other business methods
 */
package com.ge.aloc.manager.dashboard;

import com.ge.aloc.DashboardViewType;
import com.ge.aloc.model.Inbox;
import com.ge.aloc.model.RequestDetails;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author chaitanya.n
 *
 */
public interface IDashboardManager {

	/**
	 * Method to display Dashboard Details of all types
	 * @return
	 * @throws HWFServiceException 
	 */
	public Inbox loadDashboardData(DashboardViewType dashboardViewType) throws HWFServiceException;

	/**
	 * Method to display default Dashboard Details of all types
	 * @return
	 * @throws HWFServiceException
	 */
	public Inbox loadDefaultDashboardData() throws HWFServiceException;

	/**
	 * Method to save default dashboard view
	 * @param defaultTab
	 * @return
	 * @throws HWFServiceException 
	 */
	public String saveDefaultDisplayTabName(Object defaultTab) throws HWFServiceException;

	/**
	 * Method to delete selected request from Dashboard 
	 * @param requestId
	 * @return
	 * @throws HWFServiceException
	 */
	public RequestDetails deleteRequest(String requestId)throws HWFServiceException;

	/**
	 * Method to enable the selected Model
	 * @param dashboardViewType
	 * @param requestId
	 * @return
	 * @throws HWFServiceException
	 */
	public Inbox enableModel(DashboardViewType dashboardViewType,String requestId) throws HWFServiceException; 

	/**
	 * Method to disable the selected Model
	 * @param dashboardViewType
	 * @param requestId	 * 
	 * @return
	 * @throws HWFServiceException
	 */
	public Inbox disableModel(DashboardViewType dashboardViewType,String requestId) throws HWFServiceException; 

	/**
	 * Method to delete the selected Model
	 * @param dashboardViewType
	 * @param requestId
	 * @return
	 * @throws HWFServiceException
	 */
	public Inbox deleteModel(DashboardViewType dashboardViewType,String requestId) throws HWFServiceException; 

	/**
	 * Method to get the my transactions details based on glance selection
	 * @return
	 * @throws HWFServiceException 
	 */
	public Inbox getGlanceDetails() throws HWFServiceException;

	/**
	 * Method to get all requests details for selected Bundle
	 * @param dashboardViewType
	 * @param requestId
	 * @return
	 * @throws HWFServiceException
	 */
	public Inbox getAllRequestInfoForSelBundle(DashboardViewType dashboardViewType,String bundleId) throws HWFServiceException; 
}
