/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: LinkTransactionManager.java
 * Purpose: LinkTransactionManager used for Link/Unlink of Transactions
 */

package com.ge.aloc.manager.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.dao.impl.DAOConnectionHelper;
import com.ge.aloc.dao.impl.LinkTransactionDAO;
import com.hydus.hwf.bw.service.IServiceClient;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author madhusudhan.gosula
 *
 */
public class LinkTransactionManagerTest {
	private static IServiceClient serviceClient;
	public static LinkTransactionManager linkTransactionManager;
	private static LinkTransactionDAO linkBundleDAO;	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		serviceClient = DAOConnectionHelper.getServiceClient();
		linkTransactionManager = new LinkTransactionManager();	
		linkBundleDAO = new LinkTransactionDAO();
		linkBundleDAO.setServiceClient(serviceClient);
		linkTransactionManager.setLinkTransactionDAO(linkBundleDAO);
	}


	/**
	 * Test method for {@link com.ge.aloc.manager.impl.LinkTransactionManager#loadLinkTransactions(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testLoadLinkTransactions() {
		String requestId = "4971";
		try {
			linkTransactionManager.loadLinkTransactions(requestId);
		} catch (HWFServiceException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		}
		
	}

	/**
	 * Test method for {@link com.ge.aloc.manager.impl.LinkTransactionManager#linkTransaction(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testLinkTransaction() {
		String requestId = "4971";
		String requestId1 = "";
		try {
			linkTransactionManager.linkTransaction(requestId, requestId1);
		} catch (HWFServiceException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.manager.impl.LinkTransactionManager#unLinkTransaction(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testUnLinkTransaction() {
		String linkId = "153";
		String linkedReqId = "4971";
		try {
			linkTransactionManager.unLinkTransaction(linkId, linkedReqId);
		} catch (HWFServiceException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.manager.impl.LinkTransactionManager#trasactionsAdvanceSearch(java.lang.Object)}.
	 */
	@Test
	public final void testTrasactionsAdvanceSearch() {
		fail("Not yet implemented"); // TODO needs to implement the functionality
	}

}
