/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: LookupManager.java
 * Purpose: LookupManager used for the all look up operations
 */

package com.ge.aloc.manager.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.AddressType;
import com.ge.aloc.dao.impl.DAOConnectionHelper;
import com.ge.aloc.dao.impl.LookupDAO;
import com.ge.aloc.model.AddressDtls;
import com.ge.aloc.model.AlocUserDataResp;
import com.ge.aloc.model.MDM;
import com.ge.aloc.model.MDM.BankDetails;
import com.ge.aloc.model.MDM.Entity;
import com.hydus.hwf.bw.service.IServiceClient;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author madhusudhan.gosula
 *
 */
public class LookupManagerTest {
	private static IServiceClient serviceClient;
	public static LookupManager LookupManager;
	private static LookupDAO lookupDAO;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		serviceClient = DAOConnectionHelper.getServiceClient();
		LookupManager = new LookupManager();	
		lookupDAO = new LookupDAO();
		lookupDAO.setServiceClient(serviceClient);
		LookupManager.setLookupDAO(lookupDAO);
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
	 * Test method for {@link com.ge.aloc.manager.impl.LookupManager#getLegalEntity(java.lang.String, java.lang.Integer)}.
	 */
	@Test
	public final void testGetLegalEntity() {
		String goldID = "000084";
		Integer pageNo = Integer.valueOf("3");
		 try {
			 List<Entity> entities = LookupManager.getLegalEntity(goldID,pageNo);
			 assertNotNull(entities);
		} catch (HWFServiceException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.manager.impl.LookupManager#getAddressDetails(com.ge.aloc.AddressType, java.lang.String)}.
	 */
	@Test
	public final void testGetAddressDetails() {
		AddressType addressType = AddressType.fromId(1);
		String name = "suresh";	
		 try {
			 List<AddressDtls> addressDetailsList = LookupManager.getAddressDetails(addressType, name);
			 assertNotNull(addressDetailsList);
		} catch (HWFServiceException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.manager.impl.LookupManager#getBussContactPerson(java.lang.String)}.
	 */
	@Test
	public final void testGetBussContactPerson() {
		 String bussContPer ="suresh";
		 try {
			AlocUserDataResp userDetails =  LookupManager.getBussContactPerson(bussContPer,null,null);
			 assertNotNull(userDetails);
		} catch (HWFServiceException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.manager.impl.LookupManager#getGERecipientDetails(java.lang.String)}.
	 */
	@Test
	public final void testGetGERecipientDetails() {
		 String geRecipient ="suresh";
		 try {
			AlocUserDataResp userDetails =  LookupManager.getGERecipientDetails(geRecipient,null,null);
			 assertNotNull(userDetails);
		} catch (HWFServiceException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.manager.impl.LookupManager#getbankDetails(java.lang.String)}.
	 */
	@Test
	public final void testGetbankDetails() {
		 String bankName ="SBI";
		 Integer pageNo = Integer.valueOf("3");
		 try {
			 List<BankDetails> bankDetails =  LookupManager.getBankDetails(bankName,null,null,null,pageNo);
			 assertNotNull(bankDetails);
		} catch (HWFServiceException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.manager.impl.LookupManager#getIBSDetails(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testGetIBSDetails() {
		String bucCode="BUC_101";
		String adnCode="ADN_101";	
		 try {
			 MDM isbDetails =  LookupManager.getIBSDetails(bucCode, adnCode);
			 assertNotNull(isbDetails);
		} catch (HWFServiceException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		}
	}

}
