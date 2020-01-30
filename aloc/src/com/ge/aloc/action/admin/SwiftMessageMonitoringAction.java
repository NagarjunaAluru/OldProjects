/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: SwiftMessageMonitoringAction.java
 * Purpose: SwiftMessageMonitoringAction used to fetch the swift messages for monitoring
 */

package com.ge.aloc.action.admin;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.manager.admin.ISwiftMessageMonitoringManager;
import com.ge.aloc.model.SwiftDashBoard;
import com.ge.aloc.model.SwiftMonitoring;
import com.hydus.hwf.exceptions.HWFServiceException;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author madhusudhan.gosula
 *
 */
public class SwiftMessageMonitoringAction extends ActionSupport {

	private static final long serialVersionUID = 4720308151566613506L;

	private ISwiftMessageMonitoringManager swiftMessageMonitoringManager;
	private SwiftDashBoard swiftDashBoard;
	private SwiftMonitoring swiftMonitoring;
	protected String searchCriteriaText;
	private HttpServletRequest request = ServletActionContext.getRequest();

	/**
	 * This method is used to open swift Message Monitoring Manager form.
	 * @return
	 * @throws HWFServiceException
	 */
	public String openSwiftMessage() throws HWFServiceException{
		swiftDashBoard = swiftMessageMonitoringManager.open();
		return ALOCConstants.SWIFTMSGMONITOR;
	}

	/**
	 * This search method is used to filter the records.
	 * @return
	 * @throws HWFServiceException
	 */
	public String searchSwiftMessage() throws HWFServiceException{
		swiftDashBoard = swiftMessageMonitoringManager.search(swiftMonitoring);
		return ALOCConstants.SWIFTSEARCH;
	}

	/**
	 * This search method is used to filter the records.
	 * @return
	 * @throws HWFServiceException
	 */
	public String basicSearchSwiftMessage() throws HWFServiceException{
		swiftMonitoring = new SwiftMonitoring();
		searchCriteriaText =  request.getParameter(ALOCConstants.SEARCHCRITERIATEXT);
		swiftMonitoring.setALOCRecordId(searchCriteriaText);
		swiftDashBoard = swiftMessageMonitoringManager.search(swiftMonitoring);
		return ALOCConstants.SWIFTSEARCH;
	}

	/**
	 * This method is used to resend the swift messages.
	 * @return
	 * @throws HWFServiceException
	 */
	public String resendSwiftMessage() throws HWFServiceException{
		swiftDashBoard = swiftMessageMonitoringManager.resend(swiftMonitoring);
		return ALOCConstants.SWIFTRESEND;
	}
	/**
	 * This method is used to navigate the admin portel page.
	 * @return
	 * @throws HWFServiceException
	 */
	public String cancel() throws HWFServiceException{
		return SUCCESS;
	}

	/**
	 * This is used to get Swift Message Monitoring Manager object.
	 * @return the swiftMessageMonitoringManager
	 */
	public ISwiftMessageMonitoringManager getSwiftMessageMonitoringManager() {
		return swiftMessageMonitoringManager;
	}

	/**
	 * This is used to create Swift Message Monitoring Manager instance object.
	 * @param swiftMessageMonitoringManager the swiftMessageMonitoringManager to set
	 */
	public void setSwiftMessageMonitoringManager(
			ISwiftMessageMonitoringManager swiftMessageMonitoringManager) {
		this.swiftMessageMonitoringManager = swiftMessageMonitoringManager;
	}


	/**
	 * This is used to get SwiftDashBoard object.
	 * @return the swiftDashBoard
	 */
	public SwiftDashBoard getSwiftDashBoard() {
		return swiftDashBoard;
	}


	/**
	 * This is used to set SwiftDashBoard object.
	 * @param swiftDashBoard the swiftDashBoard to set
	 */
	public void setSwiftDashBoard(SwiftDashBoard swiftDashBoard) {
		this.swiftDashBoard = swiftDashBoard;
	}

	/**
	 * This is used to get SwiftMonitoring object.
	 * @return the swiftMonitoring
	 */
	public SwiftMonitoring getSwiftMonitoring() {
		return swiftMonitoring;
	}

	/**
	 * This is used to set SwiftMonitoring object.
	 * @param swiftMonitoring the swiftMonitoring to set
	 */
	public void setSwiftMonitoring(SwiftMonitoring swiftMonitoring) {
		this.swiftMonitoring = swiftMonitoring;
	}

	/**
	 * This is used to get text for search.
	 * @return the searchCriteriaText
	 */
	public String getSearchCriteriaText() {
		return searchCriteriaText;
	}

	/**
	 * This is used to set text for search.
	 * @param searchCriteriaText the searchCriteriaText to set
	 */
	public void setSearchCriteriaText(String searchCriteriaText) {
		this.searchCriteriaText = searchCriteriaText;
	}
}
