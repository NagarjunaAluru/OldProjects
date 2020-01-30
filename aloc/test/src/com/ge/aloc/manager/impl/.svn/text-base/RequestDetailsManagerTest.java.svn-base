/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: RequestDetailsManager.java
 * Purpose: RequestDetailsManager used for the all request operations
 */

package com.ge.aloc.manager.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.math.BigInteger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.ALOCContext;
import com.ge.aloc.ActionType;
import com.ge.aloc.InstrumentType;
import com.ge.aloc.bo.RequestDetailsBO;
import com.ge.aloc.dao.impl.DAOConnectionHelper;
import com.ge.aloc.dao.impl.RequestDetailsDAO;
import com.ge.aloc.model.RequestDetails;
import com.hydus.hwf.bw.service.IServiceClient;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author madhusudhan.gosula
 *
 */
public class RequestDetailsManagerTest {
	private static IServiceClient serviceClient;
	private static RequestDetailsManager requestDetailsManager;
	private static RequestDetailsDAO requestDetailsDAO;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		serviceClient = DAOConnectionHelper.getServiceClient();
		requestDetailsManager = new RequestDetailsManager();	
		requestDetailsDAO = new RequestDetailsDAO();
		requestDetailsDAO.setServiceClient(serviceClient);
		requestDetailsManager.setRequestDetailsDAO(requestDetailsDAO);		
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
	 * Test method for {@link com.ge.aloc.manager.impl.RequestDetailsManager#createRequest(java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testCreateRequest() {
		String instrumentTypeName = InstrumentType.BANK_GUARANTEE.getName();
		String instrumentType = String.valueOf(InstrumentType.BANK_GUARANTEE.getId());
		String siteId = "1";
		String siteName = "Test";
		BigInteger modelId = new BigInteger("222");
		
		try {
			requestDetailsManager.createRequest(instrumentType, instrumentTypeName, siteId, siteName,modelId);
			RequestDetailsBO requestDetailsBO = ALOCContext.getActiveRequest();
			RequestDetails requestDetails = requestDetailsBO.getModel();
			assertNotNull(requestDetails);
		} catch (HWFServiceException e) {
			fail("Error while create the request"+ e.getMessage());
		}	
	}

	/**
	 * Test method for {@link com.ge.aloc.manager.impl.RequestDetailsManager#openRequest(java.math.BigInteger)}.
	 */
	@Test
	public final void testOpenRequest() {
		try {
			requestDetailsManager.openRequest(new BigInteger("101"));
			RequestDetailsBO requestDetailsBO = ALOCContext.getActiveRequest();
			RequestDetails requestDetails = requestDetailsBO.getModel();
			assertNotNull(requestDetails);
		} catch (HWFServiceException e) {
			fail("Error while open the request"+ e.getMessage());
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.manager.impl.RequestDetailsManager#getRequest(java.math.BigInteger)}.
	 */
	@Test
	public final void testGetRequest() {
		try {
			RequestDetails requestDetails = requestDetailsManager.getRequest(new BigInteger("101"));
			assertNotNull(requestDetails);
		} catch (HWFServiceException e) {
			fail("Error while get the request"+ e.getMessage());
		}
	}

	
	/**
	 * Test method for {@link com.ge.aloc.manager.impl.RequestDetailsManager#saveandSubmit(com.ge.aloc.ActionType)}.
	 */
	@Test
	public final void testSaveandSubmit() {
		try {
			RequestDetails requestDetails = new RequestDetails();
			requestDetails.setRequestId(new BigInteger("101"));
			RequestDetailsBO requestDetailsBO = new RequestDetailsBO(requestDetails);
			ALOCContext.setActiveRequest(requestDetailsBO );
			ActionType actionType = ActionType.SAVE;
			requestDetailsManager.saveandSubmit(actionType);
		} catch (HWFServiceException e) {
			fail("Error while submit the request"+ e.getMessage());
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.manager.impl.RequestDetailsManager#saveandSubmit(com.ge.aloc.ActionType)}.
	 */
	@Test
	public final void testSaveandApprove() {
		try {
			RequestDetails requestDetails = new RequestDetails();
			requestDetails.setRequestId(new BigInteger("101"));
			RequestDetailsBO requestDetailsBO = new RequestDetailsBO(requestDetails);
			ALOCContext.setActiveRequest(requestDetailsBO );
			ActionType actionType = ActionType.APPROVE;
			requestDetailsManager.saveandApprove(actionType);
		} catch (HWFServiceException e) {
			fail("Error while approve the request"+ e.getMessage());
		}
	}

}
