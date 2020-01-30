/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ReferenceDataManagerTest.java
 * Purpose: ReferenceDataManagerTest used for all the ajax operations
 */
package com.ge.aloc.manager.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.dao.impl.DAOConnectionHelper;
import com.ge.aloc.dao.impl.ReferenceDataDAO;
import com.hydus.hwf.bw.service.IServiceClient;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author madhusudhan.gosula
 *
 */
public class ReferenceDataManagerTest {

	private static IServiceClient serviceClient;
	public static ReferenceDataManager referenceDataManager;
	private static ReferenceDataDAO referenceDataDAO;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		serviceClient = DAOConnectionHelper.getServiceClient();
		referenceDataManager = new ReferenceDataManager();	
		referenceDataDAO = new ReferenceDataDAO();
		referenceDataDAO.setServiceClient(serviceClient);
		referenceDataManager.setReferenceDataDAO(referenceDataDAO);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		referenceDataManager = null;
		referenceDataDAO = null;
		serviceClient = null;
	}	

	/**
	 * Test method for {@link com.ge.aloc.manager.impl.ReferenceDataManager#getUSDEquivalentDetails(java.lang.String, java.math.BigDecimal)}.
	 */
	@Test
	public final void testGetUSDEquivalentDetails() {
		String curencyCode="12";
		BigDecimal originalAmount= new BigDecimal("1000");
		try {
			BigDecimal amountDecimal = referenceDataManager.getUSDEquivalentDetails(curencyCode, originalAmount);
			assertNotNull(amountDecimal);
		} catch (HWFServiceException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.manager.impl.ReferenceDataManager#getBondSubTypes(java.lang.String)}.
	 */
	@Test
	public final void testGetBondSubTypes() {
		Boolean bondType = true;	
		try {
			referenceDataManager.getBondSubTypes(bondType);
		} catch (HWFServiceException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.manager.impl.ReferenceDataManager#getSiteNames()}.
	 */
	@Test
	public final void testGetSiteNames() {	
		try {
			referenceDataManager.getSiteNames();
		} catch (HWFServiceException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.manager.impl.ReferenceDataManager#getAvailSites(java.lang.String)}.
	 */
	@Test
	public final void testGetAvailSites() {
		try {
			referenceDataManager.getAvailSites();
		} catch (HWFServiceException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		}
	}
}
