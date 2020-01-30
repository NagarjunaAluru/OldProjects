/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ISwiftMessageMonitoringDAO.java
 * Purpose: ISwiftMessageMonitoringDAO used for swift message monitoring.
 *
 */
package com.ge.aloc.dao.admin;

import com.ge.aloc.IServiceClientAware;
import com.ge.aloc.model.SwiftDashBoard;
import com.ge.aloc.model.SwiftMonitoring;
import com.hydus.hwf.exceptions.HWFServiceException;
/**
 * @author madhusudhan.gosula
 *
 */
public interface ISwiftMessageMonitoringDAO extends IServiceClientAware {

	/**
	 * Method to get the available swift messages
	 * @return
	 * @throws HWFServiceException
	 */
	public SwiftDashBoard open(SwiftMonitoring swiftMonitoring) throws HWFServiceException;

	/**
	 * Method to seacrh the swift messages
	 * @param swiftMonitoring
	 * @return
	 * @throws HWFServiceException
	 */
	public SwiftDashBoard seacrh(SwiftMonitoring swiftMonitoring) throws HWFServiceException;
	/**
	 * Method to resend the swift messages
	 * @param swiftMonitoring
	 * @return
	 * @throws HWFServiceException
	 */
	public SwiftDashBoard resend(SwiftMonitoring swiftMonitoring) throws HWFServiceException;

}
