 /*
  *Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: CreateBundleActionTest.java
 * Purpose: CreateBundleActionTest used for the all the create bundle Action test cases
 */
package com.ge.aloc.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.common.AbstractTestCase;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.exception.ALOCException;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author madhusudhan.gosula
 *
 */
public class CreateBundleActionTest extends AbstractTestCase{
	
	public static final Log logger = LogFactory.getLog(CreateBundleActionTest.class);
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
			
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}


	/**
	 * This method is used to add or create Bundle.
	 * Test method for {@link com.ge.aloc.action.CreateBundleAction#createBundle()}.
	 * @throws Exception 
	 * @throws NumberFormatException 
	 */
	@Test
	public final void testCreateBundle() throws NumberFormatException, Exception {
		try {
			CreateBundleAction createBundleAction = getBundleAction("createBundle");
			request.setParameter(ALOCConstants.REQUEST_ID, "7534");
			request.setParameter(ALOCConstants.AMP_BUNDLEID, "288");			
			String result = createBundleAction.createBundle();
			assertNotNull(result);
			assertEquals(ALOCConstants.SUCCESS,result);
		} catch (HWFServiceException e) {			
			assertEquals("", e.getMessage());
		} catch (ALOCException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * This method is used to load list of bundles
	 * Test method for {@link com.ge.aloc.action.CreateBundleAction#loadBundleList()}.
	 * @throws Exception 
	 * @throws NumberFormatException 
	 */
	@Test
	public final void testLoadBundleList() throws NumberFormatException, Exception {
		try {
			CreateBundleAction createBundleAction = getBundleAction("loadBundleList");
			request.setParameter(ALOCConstants.REQUEST_ID, "7534");
			String result = createBundleAction.loadBundleList();
			assertNotNull(result);
			assertEquals(ALOCConstants.SUCCESS,result);
		} catch (HWFServiceException e) {			
			assertEquals("", e.getMessage());
		} catch (ALOCException e) {			
			fail(e.getMessage());
		}
	}

	/**
	 * This method is used to remove bundle for the given bundle id.
	 * Test method for {@link com.ge.aloc.action.CreateBundleAction#removeBundle()}.
	 * @throws Exception 
	 */
	@Test
	public final void testRemoveBundle() throws Exception {
		try {
			request.setParameter(ALOCConstants.BUNDLEID, "201");	
			CreateBundleAction createBundleAction = getBundleAction("removeBundle");
			String result = createBundleAction.removeBundle();
			assertNotNull(result);
			assertEquals(ALOCConstants.SUCCESS,result);
		} catch (HWFServiceException e) {			
			assertEquals("", e.getMessage());
		} catch (ALOCException e) {			
			fail(e.getMessage());
		}
	}

	/**
	 * This method is used to submit the bundle for a given bundle id.
	 * Test method for {@link com.ge.aloc.action.CreateBundleAction#submitBundle()}.
	 * @throws Exception 
	 */
	@Test
	public final void testSubmitBundle() throws Exception {
		try {
			request.setParameter(ALOCConstants.BUNDLEID, "287");	
			CreateBundleAction createBundleAction = getBundleAction("submitBundle");
			String result = createBundleAction.submitBundle();
			assertNotNull(result);
			assertEquals(ALOCConstants.SUCCESS,result);
		} catch (HWFServiceException e) {			
			fail(e.getMessage());
		}
	}

	/**
	 * This method is used remove the given request from the selected bundle.
	 * Test method for {@link com.ge.aloc.action.CreateBundleAction#removeRequestFromBundle()}.
	 * @throws Exception 
	 */
	@Test
	public final void testRemoveRequestFromBundle() throws Exception {
		try {
			request.setParameter(ALOCConstants.REQUEST_ID, "7534");
			request.setParameter(ALOCConstants.BUNDLEID, "287");		
			CreateBundleAction createBundleAction = getBundleAction("removeRequestFromBundle");
			String result =  createBundleAction.removeRequestFromBundle();
			assertNotNull(result);
			assertEquals(ALOCConstants.SUCCESS,result);
		} catch (HWFServiceException e) {			
			fail(e.getMessage());
		}
	}
}
