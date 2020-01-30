/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ReportsDAOTest.java
 * Purpose: ReportsDAOTest used for testing Reports Implementation
 */
package com.ge.aloc.dao.impl;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import com.ge.aloc.common.AbstractTestCase;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.dao.impl.reports.ReportsDAO;
import com.ge.aloc.model.ReportsDetails;
import com.hydus.hwf.bw.service.IServiceClient;
import com.hydus.hwf.exceptions.HWFServiceException;

public class ReportsDAOTest extends AbstractTestCase{

	private static IServiceClient serviceClient;
	private static ReportsDAO reportsDAO;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		serviceClient = DAOConnectionHelper.getServiceClient();
		reportsDAO = new ReportsDAO();
		reportsDAO.setServiceClient(serviceClient);
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
	 * Test method for {@link com.ge.aloc.dao.impl.reports.ReportsDAO#callExporttoExcel()}
	 */
	public void testCallExporttoExcel(ReportsDetails reportsDetails) {
		try {
			ReportsDetails reportDetails = reportsDAO.callContingentReportExport(reportsDetails);
			assertNotNull(reportDetails);
		} catch (HWFServiceException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		}
	}
	
	/**
	 * Test method for {@link com.ge.aloc.dao.impl.reports.ReportsDAO#getMORRates}
	 */
	public void testGetMORRates() {
		try {
			String morRate = reportsDAO.getMORRates(ALOCConstants.EMPTY_STRING);
			assertNotNull(morRate);
		} catch (HWFServiceException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		}
	}
}
