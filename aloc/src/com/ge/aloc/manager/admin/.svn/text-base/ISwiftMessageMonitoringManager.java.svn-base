/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ISwiftMessageMonitoringManager.java
 * Purpose: ISwiftMessageMonitoringManager used for swift message monitoring.
 */
package com.ge.aloc.manager.admin;

import com.ge.aloc.model.SwiftDashBoard;
import com.ge.aloc.model.SwiftMonitoring;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author madhusudhan.gosula
 *
 */
public interface ISwiftMessageMonitoringManager {

	/**
	 * Method to open the swift messages
	 * @return
	 * @throws HWFServiceException
	 */
	public SwiftDashBoard open() throws HWFServiceException ;

	/**
	 * Method to search the swift message records from the application.
	 * @return
	 * @throws HWFServiceException
	 */

	public SwiftDashBoard search(SwiftMonitoring swiftMonitoring) throws HWFServiceException ;


	/**
	 * Method to re-send the swift messages.
	 * @return
	 * @throws HWFServiceException
	 */
	public SwiftDashBoard resend(SwiftMonitoring swiftMonitoring) throws HWFServiceException ;

}
