 /*
  *Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: CreateBundleDAOTest.java
 * Purpose: CreateBundleDAOTest used for the all the create bundle DAO test cases
 */
package com.ge.aloc.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.OpCode;
import com.ge.aloc.model.Inbox;
import com.ge.aloc.model.MsgHeader;
import com.ge.aloc.util.ALOCCommonHelper;
import com.hydus.hwf.bw.service.IServiceClient;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author rajeswari.guthi
 *
 */
public class CreateBundleDAOTest {
	private static IServiceClient serviceClient;
	private static CreateBundleDAO createBundleDAO;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		serviceClient = DAOConnectionHelper.getServiceClient();
		createBundleDAO = new CreateBundleDAO();
		createBundleDAO.setServiceClient(serviceClient);
	}


	/**
	 * Test method for {@link com.ge.aloc.dao.impl.CreateBundleDAO#loadBundleList()}.
	 */
	@Test
	public final void testLoadBundleList() {				
		try {
			String requestId = "7533";
				createBundleDAO.loadBundleList(requestId);
			} catch (HWFServiceException e) {
				assertNotNull(e);
				assertEquals("", e.getMessage());//TODO verify the error message.
			}
		
	}

	/**
	 * Test method for {@link com.ge.aloc.dao.impl.CreateBundleDAO#addOrCreateBundle(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testAddOrCreateBundle() {
		String requestId = null;
		String bundleId = null;
		assertNull(requestId);
		assertNull(bundleId);		
		requestId= "4951";
		bundleId="24";
		assertNotNull(requestId);
		assertNotNull(bundleId);
		try {
			createBundleDAO.addOrCreateBundle(requestId, bundleId);
		} catch (HWFServiceException e) {			
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		}		
	}

	/**
	 * Test method for {@link com.ge.aloc.dao.impl.CreateBundleDAO#removeBundle(java.lang.String)}.
	 */
	@Test
	public final void testRemoveBundle() {		
		String bundleId = null;
		assertNull(bundleId);		
		bundleId="24";
		assertNotNull(bundleId);
		
		try {
			 createBundleDAO.removeBundle(bundleId);
		} catch (HWFServiceException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.dao.impl.CreateBundleDAO#removeRequestFromBundle(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testRemoveRequestFromBundle() {
		String requestId = null;
		String bundleId = null;
		assertNull(requestId);
		assertNull(bundleId);		
		requestId= "4951";
		bundleId="24";
		assertNotNull(requestId);
		assertNotNull(bundleId);
		try {
			createBundleDAO.removeRequestFromBundle(requestId, bundleId);
		} catch (HWFServiceException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.dao.impl.CreateBundleDAO#submitBundle(java.lang.String)}.
	 */
	@Test
	public final void testSubmitBundle() {		
		String bundleId = null;
		assertNull(bundleId);		
		bundleId="24";	
		assertNotNull(bundleId);
		try {
			 createBundleDAO.submitBundle(bundleId);
		} catch (HWFServiceException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.dao.impl.CreateBundleDAO#addDetailsToBundle(com.ge.aloc.model.Inbox, com.ge.aloc.model.MsgHeader, java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testAddDetailsToBundle() {		
		Inbox inboxResult = new Inbox();		
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.CREATEBUNDLE.getOperationCode());	
		String requestId = null;
		String bundleId = null;
		assertNull(requestId);
		assertNull(bundleId);		
		requestId= "4951";
		bundleId="24";
		assertNotNull(requestId);
		assertNotNull(bundleId);		
		inboxResult = createBundleDAO.addDetailsToBundle(inboxResult,msgHeader, requestId, bundleId);
	}
	
}
