/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: SwiftMessageMonitoringDAO.java
 * Purpose: SwiftMessageMonitoringDAO used for swift message monitoring
 *
 */
package com.ge.aloc.dao.impl.admin;

import com.ge.aloc.OpCode;
import com.ge.aloc.ServiceClientSupport;
import com.ge.aloc.dao.admin.ISwiftMessageMonitoringDAO;
import com.ge.aloc.model.MsgHeader;
import com.ge.aloc.model.SwiftDashBoard;
import com.ge.aloc.model.SwiftMonitoring;
import com.ge.aloc.util.ALOCCommonHelper;
import com.hydus.hwf.exceptions.HWFServiceException;
/**
 * @author madhusudhan.gosula
 *
 */
public class SwiftMessageMonitoringDAO extends ServiceClientSupport implements ISwiftMessageMonitoringDAO {

	/**
	 * This method is used to fetch the swift messages
	 * @param swiftMonitoring
	 */
	public SwiftDashBoard open(SwiftMonitoring swiftMonitoring) throws HWFServiceException {
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.SWIFTMESSAGES.getOperationCode());
		swiftMonitoring.setMsgHeader(msgHeader);
		return (SwiftDashBoard) serviceClient.invokeService(OpCode.SWIFTOPERATIONS.getOperationCode(), swiftMonitoring, SwiftDashBoard.class);
	}

	/**
	 * Method is used to search the swift messages
	 * @param swiftMonitoring
	 * @return
	 * @throws HWFServiceException
	 */
	public SwiftDashBoard seacrh(SwiftMonitoring swiftMonitoring)
			throws HWFServiceException {
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.SEARCHSWIFTMESSAGES.getOperationCode());
		swiftMonitoring.setMsgHeader(msgHeader);
		return (SwiftDashBoard) serviceClient.invokeService(OpCode.SWIFTOPERATIONS.getOperationCode(), swiftMonitoring, SwiftDashBoard.class);
	}

	/**
	 * Method is used to search the swift messages
	 * @param swiftMonitoring
	 * @return
	 * @throws HWFServiceException
	 */
	public SwiftDashBoard resend(SwiftMonitoring swiftMonitoring)
			throws HWFServiceException {
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.RESEND.getOperationCode());
		swiftMonitoring.setMsgHeader(msgHeader);
		return (SwiftDashBoard) serviceClient.invokeService(OpCode.SWIFTOPERATIONS.getOperationCode(), swiftMonitoring, SwiftDashBoard.class);
	}

}
