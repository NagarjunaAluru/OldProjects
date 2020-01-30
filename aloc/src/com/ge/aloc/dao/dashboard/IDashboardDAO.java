/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: IDashboardDAO.java
 * Purpose: IDashboardDAO used for draft,my transaction,my requests data base calls 
 * and other business methods
 */
package com.ge.aloc.dao.dashboard;

import com.ge.aloc.DashboardViewType;
import com.ge.aloc.IServiceClientAware;
import com.ge.aloc.model.Inbox;
import com.ge.aloc.model.RequestDetails;
import com.ge.aloc.model.Search;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * 
 * @author hariprasad.madas
 * 
 */
public interface IDashboardDAO extends IServiceClientAware {

	/**
	 * Method to display Dashboard Details of all types
	 * @param inbox
	 * @return
	 * @throws HWFServiceException
	 */
	public Inbox loadDashboardData(Inbox inbox,DashboardViewType dashboardViewType) throws HWFServiceException;

	/**
	 * Method to save default dashboard view
	 * @param inbox
	 * @return
	 * @throws HWFServiceException
	 */
	public Inbox saveDefaultDisplayTabName(Inbox inbox) throws HWFServiceException;

	/**
	 * Method to delete selected request from Dashboard
	 * @param requestDetails
	 * @return
	 * @throws HWFServiceException
	 */
	public RequestDetails deleteRequest(RequestDetails requestDetails)throws HWFServiceException;


	/**
	 * Method to enable the selected Model
	 * @param inbox
	 * @return
	 * @throws HWFServiceException
	 */
	public Inbox enableModel(Inbox inbox) throws HWFServiceException; 

	/**
	 * Method to disable the selected Model
	 * @param inbox
	 * @return
	 * @throws HWFServiceException
	 */
	public Inbox disableModel(Inbox inbox) throws HWFServiceException; 

	/**
	 * Method to delete the selected Model
	 * @param inbox
	 * @return
	 * @throws HWFServiceException
	 */
	public Inbox deleteModel(Inbox inbox) throws HWFServiceException; 

	/**
	 * Method to get the my transactions details based on glance selection
	 * @param searchCriteria
	 * @return
	 * @throws HWFServiceException 
	 */
	public Inbox getGlanceDetails(Search searchCriteria,String glancecount) throws HWFServiceException;
}
