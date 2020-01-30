/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ReimbursementAgreementMgmtDAOTest.java
 * Purpose: ReimbursementAgreementMgmtDAOTest class used for reimbursement agreement creation purpose.
 *
 */
package com.ge.aloc.dao.impl.admin;

import static org.junit.Assert.assertNotNull;

import java.math.BigInteger;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.dao.impl.DAOConnectionHelper;
import com.ge.aloc.model.Reimbursement;
import com.ge.aloc.model.ReimbursementAgreement;
import com.hydus.hwf.bw.service.IServiceClient;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author rajeswari.guthi
 *
 */
public class ReimbursementAgreementMgmtDAOTest {
	
	/**
	 * 
	 */
	private static IServiceClient serviceClient;
	private static ReimbursementAgreementMgmtDAO reimbursementAgreementMgmtDAO;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		serviceClient = DAOConnectionHelper.getServiceClient();
		reimbursementAgreementMgmtDAO = new ReimbursementAgreementMgmtDAO();
		reimbursementAgreementMgmtDAO.setServiceClient(serviceClient);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for {@link com.ge.aloc.dao.impl.admin.ReimbursementAgreementMgmtDAO#loadReimbursementAgreementList(com.ge.aloc.model.Reimbursement)}.
	 */
	@Test
	public final void testLoadReimbursementAgreementList() {
		
		Reimbursement reimbursement = new Reimbursement(); 		
		try {			
			reimbursement.setReimbursementAgreement(new ReimbursementAgreement());
			reimbursement = reimbursementAgreementMgmtDAO.loadReimbursementAgreementList(reimbursement);			
			assertNotNull(reimbursement.getReimburseLists());
		} catch (HWFServiceException e) {
			assertNotNull(reimbursement);			
		}
		
	}

	/**
	 * Test method for {@link com.ge.aloc.dao.impl.admin.ReimbursementAgreementMgmtDAO#createOrUpdateReimbursementAgreement(com.ge.aloc.model.Reimbursement)}.
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
			reimbursement = reimbursementAgreementMgmtDAO.createOrUpdateReimbursementAgreement(reimbursement);			
			assertNotNull(reimbursement.getReimburseLists());
		} catch (HWFServiceException e) {
			assertNotNull(reimbursement);			
		}
		
	}

	/**
	 * Test method for {@link com.ge.aloc.dao.impl.admin.ReimbursementAgreementMgmtDAO#createOrUpdateReimbursementAgreement(com.ge.aloc.model.Reimbursement)}.
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
			reimbursement = reimbursementAgreementMgmtDAO.createOrUpdateReimbursementAgreement(reimbursement);			
			assertNotNull(reimbursement.getReimburseLists());
		} catch (HWFServiceException e) {
			assertNotNull(reimbursement);			
		}
		
	}
	
	/**
	 * Test method for {@link com.ge.aloc.dao.impl.admin.ReimbursementAgreementMgmtDAO#loadReimbursementAgreementDetailsById(com.ge.aloc.model.Reimbursement)}.
	 */
	@Test
	public final void testLoadReimbursementAgreementDetailsById() {

		Reimbursement reimbursement = new Reimbursement(); 		
		try {			
			ReimbursementAgreement reimbursementAgreement = new ReimbursementAgreement();
			reimbursementAgreement.setReimbursementAgreementId(new BigInteger("107"));
			reimbursement.setReimbursementAgreement(reimbursementAgreement);
			reimbursement = reimbursementAgreementMgmtDAO.loadReimbursementAgreementDetailsById(reimbursement);			
			assertNotNull(reimbursement.getReimburseLists());
		} catch (HWFServiceException e) {
			assertNotNull(reimbursement);			
		}
		
		
	}

}
