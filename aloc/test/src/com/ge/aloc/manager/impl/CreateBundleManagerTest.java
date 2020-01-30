 /*
  *Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: CreateBundleManagerTest.java
 * Purpose: CreateBundleManagerTest used for the all the create bundle module service test cases
 */
 
package com.ge.aloc.manager.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.dao.impl.CreateBundleDAO;
import com.ge.aloc.dao.impl.DAOConnectionHelper;
import com.ge.aloc.exception.ALOCException;
import com.ge.aloc.model.RequestDetails;
import com.hydus.hwf.bw.service.IServiceClient;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author madhusudhan.gosula
 *
 */
public class CreateBundleManagerTest {
	private static IServiceClient serviceClient;
	public static CreateBundleManager createBundleManager;
	private static CreateBundleDAO createBundleDAO;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		serviceClient = DAOConnectionHelper.getServiceClient();
		createBundleManager = new CreateBundleManager();	
		createBundleDAO = new CreateBundleDAO();
		createBundleDAO.setServiceClient(serviceClient);
		createBundleManager.setCreateBundleDAO(createBundleDAO);
	}

	/**
	 * Test method for {@link com.ge.aloc.manager.impl.CreateBundleManager#addOrCreateBundle(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testAddOrCreateBundle() {
		String requestId = null;
		String bundleId = null;
		assertNull(requestId);
		assertNull(bundleId);		
		requestId= "4958";
		bundleId="24";
		assertNotNull(requestId);
		assertNotNull(bundleId);		
			try {
				RequestDetails requestDetails = createBundleManager.addOrCreateBundle(requestId, bundleId);
				assertNotNull(requestDetails.getComments());
			} catch (HWFServiceException e) {
				assertNotNull(e);
				assertEquals("", e.getMessage());//TODO verify the error message.
			} catch (ALOCException e) {
				assertNotNull(e);
				assertEquals("", e.getMessage());//TODO verify the error message.
			}
	}

	/**
	 * Test method for {@link com.ge.aloc.manager.impl.CreateBundleManager#loadBundleList()}.
	 */
	@Test
	public final void testLoadBundleList() {
		try {
			String requestId = "7533";
			List<RequestDetails> reqDetailsList = createBundleManager.loadBundleList(requestId);
			assertNotNull(reqDetailsList);
		} catch (HWFServiceException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		}
		
	}

	/**
	 * Test method for {@link com.ge.aloc.manager.impl.CreateBundleManager#removeBundle(java.lang.String)}.
	 */
	@Test
	public final void testRemoveBundle() {		
		String bundleId = null;
		assertNull(bundleId);		
		bundleId="24";
		assertNotNull(bundleId);	
		try {
			RequestDetails requestDetails =  createBundleManager.removeBundle(bundleId);
			assertNotNull(requestDetails.getComments());
		} catch (HWFServiceException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.manager.impl.CreateBundleManager#submitBundle(java.lang.String)}.
	 */
	@Test
	public final void testSubmitBundle() {
		String bundleId = null;
		assertNull(bundleId);		
		bundleId="24";
		assertNotNull(bundleId);	
		try {
			RequestDetails requestDetails =  createBundleManager.submitBundle(bundleId);
			assertNotNull(requestDetails.getComments());
		} catch (HWFServiceException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.manager.impl.CreateBundleManager#removeRequestFromBundle(java.lang.String, java.lang.String)}.
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
			RequestDetails requestDetails = createBundleManager.removeRequestFromBundle(requestId, bundleId);
			assertNotNull(requestDetails.getComments());
		} catch (HWFServiceException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		}
		
	}

}
