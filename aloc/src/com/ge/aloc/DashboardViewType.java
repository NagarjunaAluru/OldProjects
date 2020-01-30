/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: DashboardType.java
 * Purpose: DashboardType used for the all dashboard constants.
 */
package com.ge.aloc;


/**
 * @author hariprasad.madas
 *
 */
public enum DashboardViewType {
	MYTRANSACTIONS(OpCode.DASHBOARD_MYTRANSACTIONS), 
	ALLREQUESTS(OpCode.DASHBOARD_ALLREQUESTS), 
	DRAFTS(OpCode.DASHBOARD_DRAFTS), 
	MODEL(OpCode.DASHBOARD_MODELS), 
	BUNDLES(OpCode.DASHBOARD_BUNDLE), 
	TREASURYBIDPROCESS(OpCode.DASHBOARD_TREASURYBIDPROCESS),
	BANKBIDPROCESS(OpCode.DASHBOARD_BANKBIDPROCESS),
	TREASURYBANKPENDINGINCE(OpCode.DASHBOARD_TREASURYBANKPENDINGINCE),
	TREASURYBANKHIST(OpCode.DASHBOARD_TREASURYBANKHIST),
	TREASURYBROKERBIDPROCESS(OpCode.DASHBOARD_TREASURYBROKERBIDPROCESS),
	TREASURYBROKERPENDINGINCE(OpCode.DASHBOARD_TREASURYBROKERPENDINGINCE),
	TREASURYBROKERHIST(OpCode.DASHBOARD_TREASURYBROKERHIST),	
	BUNDLEREQ(OpCode.DASHBOARD_BUNDLE_REQ);

	private OpCode opCode;

	/**
	 * DashboardView Type constructor.
	 * @param opCode
	 */
	private DashboardViewType(OpCode opCode) {
		this.opCode = opCode;
	}

	/**
	 * This is used to get Opcode
	 * getOpcode
	 * @return
	 */
	public OpCode getOpCode() {
		return this.opCode;
	}
}
