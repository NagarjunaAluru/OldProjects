/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ReportsManagerTest.java
 * Purpose: ReportsManagerTest used for testing Reports Implementation
 */
package com.ge.aloc.manager.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.dao.impl.DAOConnectionHelper;
import com.ge.aloc.dao.impl.reports.ReportsDAO;
import com.ge.aloc.model.ReportsDetails;
import com.ge.aloc.reports.ALOCReportException;
import com.hydus.hwf.bw.service.IServiceClient;
import com.hydus.hwf.exceptions.HWFServiceException;
/**
 * 
 * @author srikanth.bayyannagar
 *
 */
public class ReportsManagerTest {
	private static IServiceClient serviceClient;
	private static ReportsDAO reportsDAO;
	private static ReportsManager reportsManager;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		serviceClient = DAOConnectionHelper.getServiceClient();		
		reportsManager = new ReportsManager();
		reportsDAO = new ReportsDAO();
		reportsDAO.setServiceClient(serviceClient);
		reportsManager.setReportsDAO(reportsDAO);
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
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}
	
	
	/**
	 * Test method for {@link com.ge.aloc.manager.impl.ReportsManager#callExportExcel}.
	 * @throws FileNotFoundException 
	 */
	@Test
	public void callContingentReportExport(String reportName, ReportsDetails reportsDetails1, String fileName, Boolean isExternal) throws HWFServiceException, ALOCReportException, IOException {
		try {
			reportsManager.exportReportDetails(reportName, reportsDetails1, fileName, isExternal);
		} catch (HWFServiceException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		} 
	}

	/**
	 * Test method for {@link com.ge.aloc.manager.impl.ReportsManager#getMORRates}.
	 */
	@Test
	public final void getMORRates() {
		try {
			String morRates = reportsManager.getMORRates(ALOCConstants.EMPTY_STRING);
			assertNotNull(morRates);
		} catch (HWFServiceException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		} 
	}
}
