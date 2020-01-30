/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ReferenceDataDAOTest.java
 * Purpose: ReferenceDataDAOTest used for testing all the lookup DAO Implementations
 * 
 */
package com.ge.aloc.dao.impl;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.model.NameValue;
import com.ge.aloc.model.SiteAdminStaticData;
import com.ge.aloc.model.SiteAdminStaticData.SitesList;
import com.hydus.hwf.bw.service.IServiceClient;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author madhusudhan.gosula
 *
 */
public class ReferenceDataDAOTest {
	
	private static IServiceClient serviceClient;
	private static ReferenceDataDAO referenceDataDAO;
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		serviceClient = DAOConnectionHelper.getServiceClient();
		referenceDataDAO = new ReferenceDataDAO();
		referenceDataDAO.setServiceClient(serviceClient);
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
	 * Test method for {@link com.ge.aloc.dao.impl.ReferenceDataDAO#getUSDEquivalentDetails(java.lang.String, java.math.BigDecimal)}.
	 */
	@Test
	public final void testGetUSDEquivalentDetails() {
		String curencyCode="12";
		BigDecimal originalAmount= new BigDecimal("1000");
		try {
			BigDecimal usdAmount = referenceDataDAO.getUSDEquivalentDetails(curencyCode,originalAmount);
			assertNotNull(usdAmount);
		} catch (HWFServiceException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		}
		
	}

	/**
	 * Test method for {@link com.ge.aloc.dao.impl.ReferenceDataDAO#getBondSubTypes(java.lang.String)}.
	 */
	@Test
	public final void testGetBondSubTypes() {
		String bondType = "2";
		try {
			List<NameValue> nameValues = referenceDataDAO.getBondSubTypes(bondType);
			assertNotNull(nameValues);
		} catch (HWFServiceException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.dao.impl.ReferenceDataDAO#getSiteNames()}.
	 */
	@Test
	public final void testGetSiteNames() {		
		try {			
			List<SiteAdminStaticData.SitesList> siteNames = referenceDataDAO.getSiteNames();
			assertNotNull(siteNames);
		} catch (HWFServiceException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		}
	}
	
	/**
	 * Test method for {@link com.ge.aloc.dao.impl.SiteDetailsDAO#checkSiteNameValid(java.lang.String)}.
	 */
	@Test
	public void testCheckSiteNameValid() {
		
		String siteName = "Test";
		try {
			String valid = referenceDataDAO.checkSiteNameValid(siteName);
			assertNotNull(valid);
			assertEquals(siteName +"    Already Existed", valid);
		} catch (HWFServiceException e) {
			fail("ALOC_SITECREATEREQUEST_ERROR");
		}

	}

	/**
	 * Test method for {@link com.ge.aloc.dao.impl.SiteDetailsDAO#checkSitePrefixValid(java.lang.String)}.
	 */
	@Test
	public void testCheckSitePrefixValid() {
		String sitePrefix = "Testing";
	
	try {
		String valid = referenceDataDAO.checkSitePrefixValid(sitePrefix);
		assertNotNull(valid);
		assertEquals(sitePrefix +"   Already Existed", valid);
	} catch (HWFServiceException e) {
		fail("ALOC_SITECREATEREQUEST_ERROR");
	}
	}
	
	/**
	 * Test method for {@link com.ge.aloc.dao.impl.ReferenceDataDAO#getAvailSites(java.lang.String)}.
	 */
	@Test
	public final void testGetAvailSites() {
		String modifySiteTypeId = "39";	
		try {
			List<SiteAdminStaticData.SitesList> siteNames = referenceDataDAO.getAvailSites(modifySiteTypeId);
			assertNotNull(siteNames);
		} catch (HWFServiceException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		}
	}
	
	/**
	 * Test method for {@link com.ge.aloc.dao.impl.ReferenceDataDAO#getChildSites()}.
	 */
	@Test
	public final void testGetChildSites() {		
		try {			
			@SuppressWarnings("unchecked")
			List<SiteAdminStaticData.SitesList> childSites = (List<SitesList>) referenceDataDAO.getChildSites("123");
			assertNotNull(childSites);
		} catch (HWFServiceException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		}
	}

}
