/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: SuretyNameMgmtActionTest.java
 * Purpose: SuretyNameMgmtActionTest class used for testing the usecases of the screen
 *
 */
package com.ge.aloc.action.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.common.AbstractTestCase;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.model.SuretyMaster;
import com.ge.aloc.model.SuretyMasterCollection;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author madhusudhan.gosula
 *
 */
public class SuretyNameMgmtActionTest  extends AbstractTestCase{

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
	 * This Method is used to get the available surety company names
	 * Test method for {@link com.ge.aloc.action.admin.SuretyNameMgmtAction#openSurety()}.
	 */
	@Test
	public final void testOpenSurety() {
		SuretyNameMgmtAction suretyNameMgmtAction;
		suretyNameMgmtAction = suretyNameMgmtAction("openSurety");
		assertNotNull(suretyNameMgmtAction);
		
		try {
			    setUserContextDetails();
			    suretyNameMgmtAction.setSessionValues(new HashMap<String, Object>());
				String result = suretyNameMgmtAction.openSurety();
				assertNotNull(result);
				assertEquals(ALOCConstants.GETSURETYSUCCESS,result);
		} catch (HWFServiceException e) {
			fail(ALOCConstants.TESTCASE_FIALED_ERROR_MESSAGE + e.getMessage());	
		}
	}
	
	/**
	 * This Method is used to add the new SuretyCompany Name
	 * Test method for {@link com.ge.aloc.action.admin.SuretyNameMgmtAction#addSurety()}.
	 */
	@Test
	public final void testAddSurety() {
		SuretyNameMgmtAction suretyNameMgmtAction;
		suretyNameMgmtAction = suretyNameMgmtAction("addSurety");
		assertNotNull(suretyNameMgmtAction);
		
		try {
				String result = suretyNameMgmtAction.addSurety();
				assertNotNull(result);
				assertEquals(ALOCConstants.ADDSURETYSUCCESS,result);
		} catch (HWFServiceException e) {
			fail(ALOCConstants.TESTCASE_FIALED_ERROR_MESSAGE + e.getMessage());	
		}
	}
	
	/**
	 * This Method is used to update the selected SuretyCompany Name
	 * Test method for {@link com.ge.aloc.action.admin.SuretyNameMgmtAction#editSurety()}.
	 */
	@Test
	public final void testEditSurety() {
		SuretyNameMgmtAction suretyNameMgmtAction;
		suretyNameMgmtAction = suretyNameMgmtAction("editSurety");
		assertNotNull(suretyNameMgmtAction);
		
		try {
				SuretyMaster  suretyMaster = new SuretyMaster();
				suretyMaster.setSuretyId(Long.valueOf(441));
				suretyMaster.setSuretyName("For Rider Test");
				List<SuretyMaster> suretyList = new ArrayList<SuretyMaster>();
				suretyList.add(suretyMaster);
				SuretyMasterCollection suretyListCollection = new SuretyMasterCollection();
				suretyListCollection.setSuretyMasters(suretyList);
				suretyNameMgmtAction.setSuretyList(suretyListCollection);
				Map<String, Object> suretyNames = new HashMap<String, Object>();
				suretyNames.put(ALOCConstants.SURETYNAMES, suretyListCollection);
			    suretyNameMgmtAction.setSessionValues(suretyNames);
			    request.setParameter(ALOCConstants.CURINDEX,"0");
				String result = suretyNameMgmtAction.editSurety();
				assertNotNull(result);
				assertEquals(ALOCConstants.ADDSURETYSUCCESS,result);
		} catch (HWFServiceException e) {
			fail(ALOCConstants.TESTCASE_FIALED_ERROR_MESSAGE + e.getMessage());	
		}
	}
	
	/**
	 * This Method is used to add or update given SuretyCompany Name
	 * Test method for {@link com.ge.aloc.action.admin.SuretyNameMgmtAction#updateSurety()}.
	 */
	@Test
	public final void testUpdateSurety() {
		SuretyNameMgmtAction suretyNameMgmtAction;
		suretyNameMgmtAction = suretyNameMgmtAction("updateSurety");
		assertNotNull(suretyNameMgmtAction);
		SuretyMaster suretyMaster = new SuretyMaster();
		
		try {
			    setUserContextDetails();
			    suretyNameMgmtAction.setSessionValues(new HashMap<String, Object>());
			    suretyMaster.setSuretyId(Long.valueOf(261));
			    suretyMaster.setSuretyName("SampleJunitTest5");
			    suretyMaster.setSuretyStatus(true);
			    suretyNameMgmtAction.setSuretyMaster(suretyMaster);
				String result = suretyNameMgmtAction.updateSurety();
				assertNotNull(result);
				assertEquals(ALOCConstants.UPDATESURETYSUCCESS,result);
		} catch (HWFServiceException e) {
			fail(ALOCConstants.TESTCASE_FIALED_ERROR_MESSAGE + e.getMessage());	
		}
	}
	
	/**
	 * This Method is used to cancel the SuretyCompany Name changes
	 * Test method for {@link com.ge.aloc.action.admin.SuretyNameMgmtAction#cancelSurety()}.
	 */
	@Test
	public final void testCancelSurety() {
		SuretyNameMgmtAction suretyNameMgmtAction;
		suretyNameMgmtAction = suretyNameMgmtAction("cancelSurety");
		assertNotNull(suretyNameMgmtAction);
		
		try {
			    setUserContextDetails();			    
			    request.setParameter(ALOCConstants.SURETYID, "441");
			    SuretyMaster  suretyMaster = new SuretyMaster();
				suretyMaster.setSuretyId(Long.valueOf(441));
				suretyMaster.setSuretyName("For Rider Test");
				List<SuretyMaster> suretyList = new ArrayList<SuretyMaster>();
				suretyList.add(suretyMaster);
				SuretyMasterCollection suretyListCollection = new SuretyMasterCollection();
				suretyListCollection.setSuretyMasters(suretyList);
				suretyNameMgmtAction.setSuretyList(suretyListCollection);
				Map<String, Object> suretyNames = new HashMap<String, Object>();
				suretyNames.put(ALOCConstants.SURETYNAMES, suretyListCollection);
			    suretyNameMgmtAction.setSessionValues(suretyNames);			   			    
				String result = suretyNameMgmtAction.cancelSurety();
				assertNotNull(result);
				assertEquals(ALOCConstants.UPDATESURETYSUCCESS,result);
		} catch (HWFServiceException e) {
			fail(ALOCConstants.TESTCASE_FIALED_ERROR_MESSAGE + e.getMessage());	
		}
	}
}
