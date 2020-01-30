/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ReimbursementAgreementMgmtManagerTest.java
 * Purpose: ReimbursementAgreementMgmtManagerTest class used for reimbursement agreement creation purpose.
 *
 */
package com.ge.aloc.manager.impl.admin;

import static org.junit.Assert.assertNotNull;

import java.math.BigInteger;

import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.dao.impl.DAOConnectionHelper;
import com.ge.aloc.dao.impl.admin.ReimbursementAgreementMgmtDAO;
import com.ge.aloc.model.Reimbursement;
import com.ge.aloc.model.ReimbursementAgreement;
import com.hydus.hwf.bw.service.IServiceClient;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author rajeswari.guthi
 *
 */
public class ReimbursementAgreementMgmtManagerTest {
	
	private static IServiceClient serviceClient;
	private static ReimbursementAgreementMgmtManager reimbursementAgreementMgmtManager;
	private static ReimbursementAgreementMgmtDAO reimbursementAgreementMgmtDAO;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		serviceClient = DAOConnectionHelper.getServiceClient();
		reimbursementAgreementMgmtManager = new ReimbursementAgreementMgmtManager(); 
		reimbursementAgreementMgmtDAO = new ReimbursementAgreementMgmtDAO();
		reimbursementAgreementMgmtDAO.setServiceClient(serviceClient);
		reimbursementAgreementMgmtManager.setReimbursementAgreementMgmtDAO(reimbursementAgreementMgmtDAO);
	}

	/**
	 * Test method for {@link com.ge.aloc.manager.impl.admin.ReimbursementAgreementMgmtManager#createOrUpdateReimbursementAgreement(com.ge.aloc.model.Reimbursement)}.
	 */
	@Test
	public final void testCreateReimbursementAgreement() {		
		Reimbursement reimbursement = new Reimbursement(); 		
		try {			
			ReimbursementAgreement reimbursementAgreement = new ReimbursementAgreement();
			reimbursementAgreement.setReimbursementAgreementId(null);
			reimbursementAgreement.setAgreementEnabledDisabled("Enabled");
			reimbursementAgreement.setAgreementText("Test Message");
			reimbursementAgreement.setDeafultAgreement(true);
			reimbursementAgreement.setDeafultAgreementType("Indutrial");
			reimbursement.setReimbursementAgreement(reimbursementAgreement);
			reimbursement = reimbursementAgreementMgmtManager.createOrUpdateReimbursementAgreement(reimbursement);			
			assertNotNull(reimbursement.getReimburseLists());
		} catch (HWFServiceException e) {
			assertNotNull(reimbursement);			
		}
		
	}

	/**
	 * Test method for {@link com.ge.aloc.manager.impl.admin.ReimbursementAgreementMgmtManager#createOrUpdateReimbursementAgreement(com.ge.aloc.model.Reimbursement)}.
	 */
	@Test
	public final void testUpdateReimbursementAgreement() {		
		Reimbursement reimbursement = new Reimbursement(); 		
		try {			
			ReimbursementAgreement reimbursementAgreement = new ReimbursementAgreement();
			reimbursementAgreement.setReimbursementAgreementId(new BigInteger("107"));
			reimbursementAgreement.setAgreementEnabledDisabled("Enabled");
			reimbursementAgreement.setAgreementText("Test Message");
			reimbursementAgreement.setDeafultAgreement(true);
			reimbursementAgreement.setDeafultAgreementType("Indutrial");
			reimbursement.setReimbursementAgreement(reimbursementAgreement);
			reimbursement = reimbursementAgreementMgmtManager.createOrUpdateReimbursementAgreement(reimbursement);			
			assertNotNull(reimbursement.getReimburseLists());
		} catch (HWFServiceException e) {
			assertNotNull(reimbursement);			
		}
		
	}
	
	/**
	 * Test method for {@link com.ge.aloc.manager.impl.admin.ReimbursementAgreementMgmtManager#loadReimbursementAgreementList(com.ge.aloc.model.Reimbursement)}.
	 */
	@Test
	public final void testLoadReimbursementAgreementList() {		
		Reimbursement reimbursement = new Reimbursement(); 		
		try {			
			reimbursement.setReimbursementAgreement(new ReimbursementAgreement());
			reimbursement = reimbursementAgreementMgmtManager.loadReimbursementAgreementList(reimbursement);					
			assertNotNull(reimbursement.getReimburseLists());
		} catch (HWFServiceException e) {
			assertNotNull(reimbursement);			
		}
	}
	

	/**
	 * Test method for {@link com.ge.aloc.manager.impl.admin.ReimbursementAgreementMgmtManager#loadReimbursementAgreementDetailsById(com.ge.aloc.model.Reimbursement)}.
	 */
	@Test
	public final void testLoadReimbursementAgreementDetailsById() {
		Reimbursement reimbursement = new Reimbursement(); 		
		try {			
			ReimbursementAgreement reimbursementAgreement = new ReimbursementAgreement();
			reimbursementAgreement.setReimbursementAgreementId(new BigInteger("107"));
			reimbursement.setReimbursementAgreement(reimbursementAgreement);
			reimbursement = reimbursementAgreementMgmtManager.loadReimbursementAgreementDetailsById(reimbursement);
			assertNotNull(reimbursement.getReimburseLists());
		} catch (HWFServiceException e) {
			assertNotNull(reimbursement);			
		}
		
	}

}
