/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: SwiftMessageMonitoringManager.java
 * Purpose: SwiftMessageMonitoringManager used for swift messages.
 */
package com.ge.aloc.manager.impl.admin;

import java.util.ArrayList;
import java.util.List;

import com.ge.aloc.dao.admin.ISwiftMessageMonitoringDAO;
import com.ge.aloc.manager.admin.ISwiftMessageMonitoringManager;
import com.ge.aloc.model.SwiftDashBoard;
import com.ge.aloc.model.SwiftMonitoring;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author madhusudhan.gosula
 *
 */
public class SwiftMessageMonitoringManager implements ISwiftMessageMonitoringManager{

	private ISwiftMessageMonitoringDAO swiftMessageMonitoringDAO;

	/**
	 * This method is used to fetch the swift messages
	 * @return swiftDashBoard
	 */
	public SwiftDashBoard open() throws HWFServiceException {
		SwiftDashBoard swiftDashBoard = new SwiftDashBoard();
		SwiftMonitoring swiftMonitoring = new SwiftMonitoring();
		swiftDashBoard = swiftMessageMonitoringDAO.open(swiftMonitoring);
		return swiftDashBoard;
	}
	/**
	 * This method is used to seacrh the swift messages
	 * @param SwiftMonitoring
	 * @return swiftDashBoard
	 */
	public SwiftDashBoard search(SwiftMonitoring swiftMonitoring) throws HWFServiceException {

		List<SwiftMonitoring> swiftMonitorings = new ArrayList<SwiftMonitoring>();
		swiftMonitorings.add(swiftMonitoring);
		SwiftDashBoard swiftDashBoard = new SwiftDashBoard();
		swiftDashBoard.setSwiftMonitorings(swiftMonitorings);
		swiftDashBoard = swiftMessageMonitoringDAO.seacrh(swiftMonitoring);
		return swiftDashBoard;
	}
	/**
	 * This method is used to resend the swift messages
	 * @param SwiftMonitoring
	 * @return swiftDashBoard
	 */
	public SwiftDashBoard resend(SwiftMonitoring swiftMonitoring) throws HWFServiceException {
		SwiftDashBoard swiftDashBoard = new SwiftDashBoard();
		swiftDashBoard = swiftMessageMonitoringDAO.resend(swiftMonitoring);
		return swiftDashBoard;
	}

	/**
	 * This method is used to get SwiftMessageMonitoringDAO object
	 * @return the swiftMessageMonitoringDAO
	 */
	public ISwiftMessageMonitoringDAO getSwiftMessageMonitoringDAO() {
		return swiftMessageMonitoringDAO;
	}
	/**
	 * This method is used to create SwiftMessageMonitoringDAO instance object
	 * @param swiftMessageMonitoringDAO the swiftMessageMonitoringDAO to set
	 */
	public void setSwiftMessageMonitoringDAO(
			ISwiftMessageMonitoringDAO swiftMessageMonitoringDAO) {
		this.swiftMessageMonitoringDAO = swiftMessageMonitoringDAO;
	}

}
