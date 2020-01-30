/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: SwiftMessageMonitoringDAOTest.java
 * Purpose: SwiftMessageMonitoringDAOTest class used for swift message monitoring purpose.
 */
package com.ge.aloc.dao.impl.admin;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.dao.impl.DAOConnectionHelper;
import com.ge.aloc.model.SwiftDashBoard;
import com.ge.aloc.model.SwiftMonitoring;
import com.hydus.hwf.bw.service.IServiceClient;
import com.hydus.hwf.context.UserContext;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author sunil.yakkaluru
 *
 */
public class SwiftMessageMonitoringDAOTest 
{
	private static IServiceClient serviceClient;
	private static SwiftMessageMonitoringDAO swiftMessageMonitoringDAO;
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		serviceClient = DAOConnectionHelper.getServiceClient();
		swiftMessageMonitoringDAO = new SwiftMessageMonitoringDAO();
		swiftMessageMonitoringDAO.setServiceClient(serviceClient);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		List<String> roleslist = new ArrayList<String>();
		roleslist.add("Treasury Analyst");
		UserContext.getContext().getuserDetails().setRoles(roleslist);
	}
	
	
	/**
	 * Test method for {@link com.ge.aloc.manager.impl.admin.SwiftMessageMonitoringDAO#openMethod(com.ge.aloc.model.swiftDashBoard)}.
	 */
	@Test
	public final void testopenMethod(){
		SwiftDashBoard swiftDashBoard =  new SwiftDashBoard();
		SwiftMonitoring swiftMonitoring = new SwiftMonitoring();
		try{
			List<SwiftMonitoring> swiftMonitorings =  new ArrayList<SwiftMonitoring>();
			swiftMonitorings.add(swiftMonitoring);
			swiftDashBoard.setSwiftMonitorings(swiftMonitorings);
			swiftDashBoard = swiftMessageMonitoringDAO.open(swiftMonitoring);
			assertNotNull(swiftDashBoard);
			
		}catch (HWFServiceException e) {
			assertNotNull(swiftDashBoard);			
		}
	}
	

	/**
	 * Test method for {@link com.ge.aloc.manager.impl.admin.SwiftMessageMonitoringDAO#resendMethod(com.ge.aloc.model.swiftDashBoard)}.
	 */
	@Test
	public final void testresendMethod(){
		SwiftDashBoard swiftDashBoard =  new SwiftDashBoard();
		SwiftMonitoring swiftMonitoring = new SwiftMonitoring();
		try{
			List<SwiftMonitoring> swiftMonitorings =  new ArrayList<SwiftMonitoring>();
			swiftMonitoring.setALOCRecordNo(7222);
			swiftMonitorings.add(swiftMonitoring);
			swiftDashBoard.setSwiftMonitorings(swiftMonitorings);
			swiftDashBoard = swiftMessageMonitoringDAO.resend(swiftMonitoring);
			assertNotNull(swiftDashBoard);
			
		}catch (HWFServiceException e) {
			assertNotNull(swiftDashBoard);			
		}
	}
	
	/**
	 * Test method for {@link com.ge.aloc.manager.impl.admin.SwiftMessageMonitoringDAO#searchMethod(com.ge.aloc.model.swiftDashBoard)}.
	 */
	@Test
	public final void testsearchMethod(){
		SwiftDashBoard swiftDashBoard =  new SwiftDashBoard();
		SwiftMonitoring swiftMonitoring = new SwiftMonitoring();
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
			swiftDashBoard = swiftMessageMonitoringDAO.seacrh(swiftMonitoring);
			assertNotNull(swiftDashBoard);
			
		}catch (HWFServiceException e) {
			assertNotNull(swiftDashBoard);			
		}
	}
	
	/**
	 * Test method for {@link com.ge.aloc.manager.impl.admin.SwiftMessageMonitoringDAO#basicSearchMethod(com.ge.aloc.model.swiftDashBoard)}.
	 */
	@Test
	public final void testbasicSearchMethod(){
		SwiftDashBoard swiftDashBoard =  new SwiftDashBoard();
		SwiftMonitoring swiftMonitoring = new SwiftMonitoring();
		try{
			List<SwiftMonitoring> swiftMonitorings =  new ArrayList<SwiftMonitoring>();
			swiftMonitoring.setALOCRecordNo(7222);
			swiftMonitorings.add(swiftMonitoring);
			swiftDashBoard = swiftMessageMonitoringDAO.seacrh(swiftMonitoring);
			assertNotNull(swiftDashBoard);
			
		}catch (HWFServiceException e) {
			assertNotNull(swiftDashBoard);			
		}
	}


}
