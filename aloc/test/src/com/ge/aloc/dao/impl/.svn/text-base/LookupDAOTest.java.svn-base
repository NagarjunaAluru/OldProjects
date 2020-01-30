/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: LookupDAOTest.java
 * Purpose: LookupDAOTest used for testing all the lookup DAO Implementations
 */

package com.ge.aloc.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.AddressType;
import com.ge.aloc.model.AddressDtls;
import com.ge.aloc.model.AlocUserDataResp;
import com.ge.aloc.model.MDM;
import com.ge.aloc.model.MDM.BankDetails;
import com.ge.aloc.model.MDM.Entity;
import com.ge.aloc.model.StaticDataManagement;
import com.ge.aloc.model.UserDetails;
import com.hydus.hwf.bw.service.IServiceClient;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author madhusudhan.gosula
 *
 */
public class LookupDAOTest {
	private static IServiceClient serviceClient;
	private static LookupDAO lookupDAO;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		serviceClient = DAOConnectionHelper.getServiceClient();
		lookupDAO = new LookupDAO();
		lookupDAO.setServiceClient(serviceClient);
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
	 * Test method for {@link com.ge.aloc.dao.impl.LookupDAO#invokeStaticDataService()}.
	 */
	@Test
	public final void testInvokeStaticDataService() {
		try {
			StaticDataManagement staticDataManagement = lookupDAO.invokeStaticDataService();
			assertNotNull(staticDataManagement);
		} catch (HWFServiceException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		}
		
	}

	/**
	 * Test method for {@link com.ge.aloc.dao.impl.LookupDAO#invokeMasterDataService()}.
	 */
	@Test
	public final void testInvokeMasterDataService() {
		try {
			MDM mdmObject = lookupDAO.invokeMasterDataService();
			assertNotNull(mdmObject);
		} catch (HWFServiceException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.dao.impl.LookupDAO#invokeLegalEntity(java.lang.String, java.lang.Integer)}.
	 */
	@Test
	public final void testInvokeLegalEntity() {
		try {
			String goldID = "000084";
			Integer pageNo = Integer.valueOf("1");
			List<Entity> legalEntities = lookupDAO.invokeLegalEntity(goldID,pageNo);
			assertNotNull(legalEntities);
		} catch (HWFServiceException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.dao.impl.LookupDAO#invokeBusinessContactPerson(java.lang.String)}.
	 */
	@Test
	public final void testInvokeBusinessContactPerson() {
		try {
			String businessContactPerson = "suresh";		
			AlocUserDataResp userDetaisList = lookupDAO.invokeBusinessContactPerson(businessContactPerson,null,null);
			assertNotNull(userDetaisList);
		} catch (HWFServiceException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		}
		
	}

	/**
	 * Test method for {@link com.ge.aloc.dao.impl.LookupDAO#invokeNameAddress(com.ge.aloc.AddressType, java.lang.String)}.
	 */
	@Test
	public final void testInvokeNameAddress() {
		try {
			AddressType addressType = AddressType.fromId(1);
			String name = "suresh";			
			List<AddressDtls> addressDtlsList = lookupDAO.invokeNameAddress(addressType,name);
			assertNotNull(addressDtlsList);
		} catch (HWFServiceException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.dao.impl.LookupDAO#invokeGERecipientDetails(java.lang.String)}.
	 */
	@Test
	public final void testInvokeGERecipientDetails() {
		try {
			String geRecipient = "suresh";		
			List<UserDetails> userDetaisList = lookupDAO.invokeGERecipientDetails(geRecipient);
			assertNotNull(userDetaisList);
		} catch (HWFServiceException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.dao.impl.LookupDAO#invokeBankDetails(java.lang.String)}.
	 */
	@Test
	public final void testInvokeBankDetails() {
		try {
			String bankName = "IOB";		
			Integer pageNo = Integer.valueOf("1");
			List<BankDetails> bankDetaisList = lookupDAO.invokeBankDetails(bankName,null,null,null,pageNo);
			assertNotNull(bankDetaisList);
		} catch (HWFServiceException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.dao.impl.LookupDAO#invokeIBSDetails(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testInvokeIBSDetails() {
		try {
			String bucCode="BUC_101";
			String adnCode="ADN_101";		
			MDM isbDetaisList = lookupDAO.invokeIBSDetails(bucCode,adnCode);
			assertNotNull(isbDetaisList);
		} catch (HWFServiceException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		}
	}

}
