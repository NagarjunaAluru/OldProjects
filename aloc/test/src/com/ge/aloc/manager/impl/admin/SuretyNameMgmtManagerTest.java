/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: SuretyNameMgmtManagerTest.java
 * Purpose: SuretyNameMgmtManagerTest used for Surety Name Management operations and user actions.
 */

package com.ge.aloc.manager.impl.admin;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.dao.impl.DAOConnectionHelper;
import com.ge.aloc.dao.impl.admin.SuretyNameMgmtDAO;
import com.ge.aloc.model.SuretyMaster;
import com.ge.aloc.model.SuretyMasterCollection;
import com.hydus.hwf.bw.service.IServiceClient;
import com.hydus.hwf.context.UserContext;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author madhusudhan.gosula
 *
 */
public class SuretyNameMgmtManagerTest {
	
	private static IServiceClient serviceClient;
	private static SuretyNameMgmtManager suretyNameMgmtManager;
	private static SuretyNameMgmtDAO suretyNameMgmtDAO;
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		serviceClient = DAOConnectionHelper.getServiceClient();
		suretyNameMgmtManager = new SuretyNameMgmtManager(); 
		suretyNameMgmtDAO = new SuretyNameMgmtDAO();
		suretyNameMgmtDAO.setServiceClient(serviceClient);
		suretyNameMgmtManager.setSuretyNameMgmtDAO(suretyNameMgmtDAO);
		List<String> rolesList = new ArrayList<String>();
		rolesList.add("TreasuryAnalyst");
		UserContext.getContext().getuserDetails().setUserId("999911248");
		UserContext.getContext().getuserDetails().setLastName("TreasuryAnalyst_999911248");
		UserContext.getContext().getuserDetails().setFirstName("Test_999911248");
		UserContext.getContext().getuserDetails().setRoles(rolesList);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		suretyNameMgmtDAO= null;
		suretyNameMgmtManager = null;
	}

	/**
	 * This method is used to fetch the list of Surety Names
	 * Test method for {@link com.ge.aloc.manager.impl.admin.SuretyNameMgmtManager#open(com.ge.aloc.model.SuretyMaster)}.
	 */
	@Test
	public final void testOpen() {		
		try {
				SuretyMasterCollection suretyMasterCollection = suretyNameMgmtManager.open();
				assertNotNull(suretyMasterCollection);
				assertNotNull(suretyMasterCollection.getSuretyMasters());
		} catch (HWFServiceException e) {
			fail("Error while fetching the list of Surety Names");
		}
	}

	/**
	 * This method is used to add or update given SuretyCompany Name
	 * Test method for {@link com.ge.aloc.manager.impl.admin.SuretyNameMgmtManager#update(com.ge.aloc.model.SuretyMaster)}.
	 */
	@Test
	public final void testUpdate() {
		
		try {
				SuretyMaster suretyMaster = new SuretyMaster();
				suretyMaster.setSuretyId(Long.valueOf("300"));
				suretyMaster.setSuretyName("SuretyDAOTest");
				suretyMaster.setSuretyStatus(false);
			    suretyMaster = suretyNameMgmtManager.update(suretyMaster);
			 assertNotNull(suretyMaster);
		} catch (HWFServiceException e) {
			fail("Error while adding or updating given SuretyCompany Name");
		}
	}
	
	/**
	 * This method is used to cancel the given SuretyCompany Name changes
	 * Test method for {@link com.ge.aloc.manager.impl.admin.SuretyNameMgmtManager#cancel(com.ge.aloc.model.SuretyMaster)}.
	 */
	@Test
	public final void testCancel() {
		try {
				SuretyMaster suretyMaster = new SuretyMaster();
				suretyMaster.setSuretyId(Long.valueOf("263"));
				suretyMaster.setSuretyName("SuretyDAOTest");
				suretyMaster.setSuretyStatus(false);
				List<SuretyMaster> suretyMasterList = new ArrayList<SuretyMaster>();
				suretyMasterList.add(suretyMaster);
				suretyMaster = suretyNameMgmtManager.cancel(suretyMasterList, "263");
				assertNotNull(suretyMaster);
		} catch (Exception e) {
			fail("Error while canceling given SuretyCompany Name changes");
		}
	}
	
	/**
	 * This method is used to get the Surety Comp Name Row value for given suretyId
	 * Test method for {@link com.ge.aloc.manager.impl.admin.SuretyNameMgmtManager#getSuretyDetailsForSelSurety(com.ge.aloc.model.SuretyMaster)}.
	 */
	@Test
	public final void testGetSuretyDetailsForSelSurety() {
		try {
				SuretyMaster suretyMaster = new SuretyMaster();
				suretyMaster.setSuretyId(Long.valueOf("263"));
				suretyMaster.setSuretyName("SuretyDAOTest");
				suretyMaster.setSuretyStatus(false);
				List<SuretyMaster> suretyMasterList = new ArrayList<SuretyMaster>();
				suretyMasterList.add(suretyMaster);
				SuretyMasterCollection suretyMasterCollection = new SuretyMasterCollection();
				suretyMasterCollection.setSuretyMasters(suretyMasterList);
				suretyMasterCollection = suretyNameMgmtManager.getSuretyDetailsForSelSurety(suretyMasterCollection, suretyMaster);
				assertNotNull(suretyMasterCollection);
				assertNotNull(suretyMasterCollection.getSuretyMasters());
		} catch (Exception e) {
			fail("Error while retrieving the Surety Comp Name Row value for given suretyId");
		}
	}
}
