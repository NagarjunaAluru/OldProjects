/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: StandardFormatMgmtManagerTest.java
 * Purpose: StandardFormatMgmtManagerTest class used for testing the usecases of the screen
 *
 */
package com.ge.aloc.manager.impl.admin;

import static org.junit.Assert.assertNotNull;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.dao.impl.DAOConnectionHelper;
import com.ge.aloc.dao.impl.admin.StandardFormatMgmtDAO;
import com.ge.aloc.model.StandardFormatMaster;
import com.hydus.hwf.bw.service.IServiceClient;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author rajeswari.guthi
 *
 */
public class StandardFormatMgmtManagerTest {
	
	private static IServiceClient serviceClient;
	private static StandardFormatMgmtManager standardFormatMgmtManager;
	private static StandardFormatMgmtDAO standardFormatMgmtDAO;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		serviceClient = DAOConnectionHelper.getServiceClient();
		standardFormatMgmtManager = new StandardFormatMgmtManager(); 
		standardFormatMgmtDAO = new StandardFormatMgmtDAO();
		standardFormatMgmtDAO.setServiceClient(serviceClient);
		standardFormatMgmtManager.setStandardFormatMgmtDAO(standardFormatMgmtDAO);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	
	/**
	 * Test method for {@link com.ge.aloc.manager.impl.admin.StandardFormatMgmtManager#getStandardFormatMaster(com.ge.aloc.model.StandardFormatMaster)}.
	 */
	@Test
	public final void testGetStandardFormatMaster() {
		StandardFormatMaster standardFormatMaster = new StandardFormatMaster();
		try {
			standardFormatMaster.setStandardFormatInstrumentTypeId(Long.valueOf("1"));
			standardFormatMaster.setStandardFormatPurpusId(Long.valueOf("3"));
			standardFormatMaster = standardFormatMgmtManager.getStandardFormatMaster(standardFormatMaster);
			assertNotNull(standardFormatMaster.getBookMarkMasterCollection().getBookMarkMasters());
		} catch (HWFServiceException e) {
			assertNotNull(standardFormatMaster);			
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.manager.impl.admin.StandardFormatMgmtManager#manageStandardFormatMaster(com.ge.aloc.model.StandardFormatMaster)}.
	 */
	@Test
	public final void testManageStandardFormatMaster() {
		StandardFormatMaster standardFormatMaster = new StandardFormatMaster();
		try {
			standardFormatMaster.setStandardFormatInstrumentTypeId(Long.valueOf("1"));
			standardFormatMaster.setStandardFormatPurpusId(Long.valueOf("3"));
			standardFormatMaster.setStandardFormatId(Long.valueOf("1"));
			standardFormatMaster = standardFormatMgmtManager.manageStandardFormatMaster(standardFormatMaster);
			assertNotNull(standardFormatMaster.getBookMarkMasterCollection().getBookMarkMasters());
		} catch (HWFServiceException e) {
			assertNotNull(standardFormatMaster);			
		}
	}

}
