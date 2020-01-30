/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: SwiftMessageMonitoringActionTest.java
 * Purpose: SwiftMessageMonitoringActionTest class used for swift message monitoring purpose.
 */
package com.ge.aloc.action.admin;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.common.AbstractTestCase;
import com.ge.aloc.model.SwiftDashBoard;
import com.ge.aloc.model.SwiftMonitoring;
import com.hydus.hwf.context.UserContext;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author sunil.yakkaluru
 *
 */
public class SwiftMessageMonitoringActionTest extends AbstractTestCase
{
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	/* (non-Javadoc)
	 * @see org.apache.struts2.StrutsTestCase#setUp()
	 */
	@Before
	protected void setUp() throws Exception {
		super.setUp();
			List<String> roleslist = new ArrayList<String>();
			roleslist.add("Treasury Analyst");
			UserContext.getContext().getuserDetails().setRoles(roleslist);
	}

	/* (non-Javadoc)
	 * @see org.apache.struts2.StrutsTestCase#tearDown()
	 */
	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	
	/**
	 * Test method for {@link com.ge.aloc.action.admin.swiftMessageMonitoringAction#openMethod()}.
	 */
	@Test
	public final void testopen()
	{
		SwiftMessageMonitoringAction swiftMessageMonitoringAction = getSwiftMsgMonitorAction("openSwiftMessageMonitoring");
		try
		{
			swiftMessageMonitoringAction.openSwiftMessage();
			assertNotNull(swiftMessageMonitoringAction);
		}catch (HWFServiceException e) {
			fail("Test case failed with error message : "+ e.getMessage());			
		}
	}
	
	
	/**
	 *  Test method for {@link com.ge.aloc.action.admin.swiftMessageMonitoringAction#openMethod()}.
	 */
	@Test
	public final void testresendMethod(){
		SwiftDashBoard swiftDashBoard =  new SwiftDashBoard();
		SwiftMonitoring swiftMonitoring = new SwiftMonitoring();
		SwiftMessageMonitoringAction swiftMessageMonitoringAction = getSwiftMsgMonitorAction("resendSwiftMessageMonitoring");
		try{
			List<SwiftMonitoring> swiftMonitorings =  new ArrayList<SwiftMonitoring>();
			swiftMonitoring.setALOCRecordNo(7222);
			swiftMonitorings.add(swiftMonitoring);
			swiftDashBoard.setSwiftMonitorings(swiftMonitorings);
			swiftMessageMonitoringAction.setSwiftMonitoring(swiftMonitoring);
			swiftMessageMonitoringAction.resendSwiftMessage();
			assertNotNull(swiftDashBoard);
			
		}catch (HWFServiceException e) {
			assertNotNull(swiftDashBoard);			
		}
	}
	
	/**
	 * Test method for {@link com.ge.aloc.action.admin.swiftMessageMonitoringAction#searchMethod()}.
	 */
	@Test
	public final void testsearchMethod(){
		SwiftDashBoard swiftDashBoard =  new SwiftDashBoard();
		SwiftMonitoring swiftMonitoring = new SwiftMonitoring();
		SwiftMessageMonitoringAction swiftMessageMonitoringAction = getSwiftMsgMonitorAction("searchSwiftMessageMonitoring");
		try{
			List<SwiftMonitoring> swiftMonitorings =  new ArrayList<SwiftMonitoring>();
			swiftMonitoring.setALOCRecordNo(7222);
			List<String> instList = new ArrayList<String>();
			instList.add("Bank Guarantee");
			swiftMonitoring.setInstruments(instList);
			swiftMonitoring.setSubMessageType("msg");
			swiftMonitoring.setStatus("done");
			swiftMonitoring.setDirection("direction");
			swiftMonitoring.setMessageSequenceGroup("all");
			swiftMonitoring.setDateTime(Calendar.getInstance());
			swiftMonitorings.add(swiftMonitoring);
			swiftMessageMonitoringAction.setSwiftMonitoring(swiftMonitoring);
			swiftMessageMonitoringAction.searchSwiftMessage();
			assertNotNull(swiftDashBoard);
			
		}catch (HWFServiceException e) {
			assertNotNull(swiftDashBoard);			
		}
	}
	
	
	/**
	 * Test method for {@link com.ge.aloc.action.admin.swiftMessageMonitoringAction#basicSearchMethod()}.
	 */
	@Test
	public final void testbasicSearchMethod(){
		SwiftDashBoard swiftDashBoard =  new SwiftDashBoard();
		SwiftMonitoring swiftMonitoring = new SwiftMonitoring();
		SwiftMessageMonitoringAction swiftMessageMonitoringAction = getSwiftMsgMonitorAction("searchSwiftMessageMonitoring");
		try{
			List<SwiftMonitoring> swiftMonitorings =  new ArrayList<SwiftMonitoring>();
			swiftMonitoring.setALOCRecordNo(7222);
			swiftMonitorings.add(swiftMonitoring);
			swiftMessageMonitoringAction.setSwiftMonitoring(swiftMonitoring);
			swiftMessageMonitoringAction.searchSwiftMessage();
			assertNotNull(swiftDashBoard);
			
		}catch (HWFServiceException e) {
			assertNotNull(swiftDashBoard);			
		}
	}
	
	
	
	

}
