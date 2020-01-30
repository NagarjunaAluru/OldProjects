/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: StandardFormatMgmtDAOTest.java
 * Purpose: StandardFormatMgmtDAOTest class used for testing the usecases of the screen
 *
 */
package com.ge.aloc.dao.impl.admin;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.dao.impl.DAOConnectionHelper;
import com.ge.aloc.model.FormatAuditTrail;
import com.ge.aloc.model.FormatAuditTrailCollection;
import com.ge.aloc.model.StandardFormatMaster;
import com.hydus.hwf.bw.service.IServiceClient;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author rajeswari.guthi
 *
 */

public class StandardFormatMgmtDAOTest {
	/**
	 * 
	 */
	private static IServiceClient serviceClient;
	private static StandardFormatMgmtDAO standardFormatMgmtDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		serviceClient = DAOConnectionHelper.getServiceClient();
		standardFormatMgmtDAO = new StandardFormatMgmtDAO();
		standardFormatMgmtDAO.setServiceClient(serviceClient);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public final void testGetFormatMaster() {
		StandardFormatMaster standardFormatMaster = new StandardFormatMaster();
		try {
			standardFormatMaster.setStandardFormatInstrumentTypeId(Long.valueOf("1"));
			standardFormatMaster.setStandardFormatPurpusId(Long.valueOf("12"));
			standardFormatMaster = standardFormatMgmtDAO.getFormatMaster(standardFormatMaster);
			assertNotNull(standardFormatMaster.getBookMarkMasterCollection().getBookMarkMasters());
		} catch (HWFServiceException e) {
			assertNotNull(standardFormatMaster);			
		}
	}

	@Test
	public final void testManageStandardFormatMaster() {
		StandardFormatMaster standardFormatMaster = new StandardFormatMaster();
		try {
			standardFormatMaster.setStandardFormatInstrumentTypeId(Long.valueOf("1"));
			standardFormatMaster.setStandardFormatPurpusId(Long.valueOf("3"));
			standardFormatMaster.setStandardFormatId(Long.valueOf("1"));
			standardFormatMaster = standardFormatMgmtDAO.manageStandardFormatMaster(standardFormatMaster);
			assertNotNull(standardFormatMaster.getBookMarkMasterCollection().getBookMarkMasters());
		} catch (HWFServiceException e) {
			assertNotNull(standardFormatMaster);			
		}
	}
	
	
	@Test
	public final void testgetUpdatedGeStandardFormatFile() {
		StandardFormatMaster standardFormatMaster = new StandardFormatMaster();
		try {
			String auditTrailId = "81";					
			FormatAuditTrail formatAuditTrail = new FormatAuditTrail();
			formatAuditTrail.setFormatAuditTrailId(Long.valueOf(auditTrailId));
			List<FormatAuditTrail> formatAuditTrailList = new ArrayList<FormatAuditTrail>();
			formatAuditTrailList.add(formatAuditTrail);
			FormatAuditTrailCollection formatAuditTrailCollection = new FormatAuditTrailCollection();
			formatAuditTrailCollection.setFormatAuditTrails(formatAuditTrailList); 
			standardFormatMaster.setFormatAuditTrailCollection(formatAuditTrailCollection);
			standardFormatMaster = standardFormatMgmtDAO.manageStandardFormatMaster(standardFormatMaster);			
		} catch (HWFServiceException e) {
			assertNotNull(standardFormatMaster);			
		}
	}

}
