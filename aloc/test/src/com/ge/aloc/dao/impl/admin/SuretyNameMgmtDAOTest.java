/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: SuretyNameMgmtDAOTest.java
 * Purpose: SuretyNameMgmtDAOTest used for add or update Surety Names.
 *
 */
package com.ge.aloc.dao.impl.admin;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.dao.impl.DAOConnectionHelper;
import com.ge.aloc.model.SuretyMaster;
import com.ge.aloc.model.SuretyMasterCollection;
import com.hydus.hwf.bw.service.IServiceClient;
import com.hydus.hwf.context.UserContext;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author madhusudhan.gosula
 *
 */
public class SuretyNameMgmtDAOTest {
	
	private static IServiceClient serviceClient;
	private static SuretyNameMgmtDAO suretyNameMgmtDAO;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		serviceClient = DAOConnectionHelper.getServiceClient();
		suretyNameMgmtDAO = new SuretyNameMgmtDAO();
		suretyNameMgmtDAO.setServiceClient(serviceClient);
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
		serviceClient= null;
		suretyNameMgmtDAO= null;
	}
	
	/**
	 * This method is used to fetch the list of Surety Names
	 * Test method for {@link com.ge.aloc.dao.impl.admin.SuretyNameMgmtDAO#open(com.ge.aloc.model.SuretyMaster)}.
	 */
	@Test
	public final void testOpen() {
		SuretyMaster suretyMaster = new SuretyMaster();
		try {
				SuretyMasterCollection suretyMasterCollection = suretyNameMgmtDAO.open(suretyMaster);
				assertNotNull(suretyMasterCollection);
				assertNotNull(suretyMasterCollection.getSuretyMasters());
		} catch (HWFServiceException e) {
			fail("Error while fetching the list of Surety Names");
		}
	}

	/**
	 * This method is used to add or update given SuretyCompany Name
	 * Test method for {@link com.ge.aloc.dao.impl.admin.SuretyNameMgmtDAO#update(com.ge.aloc.model.SuretyMaster)}.
	 */
	@Test
	public final void testUpdate() {
		try {
				SuretyMaster suretyMaster = new SuretyMaster();
				suretyMaster.setSuretyId(Long.valueOf("300"));
				suretyMaster.setSuretyName("SuretyDAOTest");
				suretyMaster.setSuretyStatus(false);
				suretyMaster = suretyNameMgmtDAO.update(suretyMaster);
				assertNotNull(suretyMaster);
		} catch (HWFServiceException e) {
			fail("Error while adding or updating given SuretyCompany Name");
		}
	}
	
	/**
	 * This method is used to delete given SuretyCompany Name
	 * Test method for {@link com.ge.aloc.dao.impl.admin.SuretyNameMgmtDAO#delete(com.ge.aloc.model.SuretyMaster)}.
	 */
	@Test
	public final void testDelete() {
		try {
				SuretyMaster suretyMaster = new SuretyMaster();
				suretyMaster.setSuretyId(Long.valueOf("263"));
				suretyMaster = suretyNameMgmtDAO.update(suretyMaster);
				assertNotNull(suretyMaster);
		} catch (HWFServiceException e) {
			fail("Error while deleting given SuretyCompany Name");
		}
	}
}
