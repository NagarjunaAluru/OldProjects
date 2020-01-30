/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ReimbursementAgreementActionTest.java
 * Purpose: ReimbursementAgreementActionTest class used for reimbursement agreement creation purpose.
 *
 */
package com.ge.aloc.action.admin;

import java.math.BigInteger;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.common.AbstractTestCase;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.model.NameValue;
import com.ge.aloc.model.Reimbursement;
import com.ge.aloc.model.ReimbursementAgreement;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author rajeswari.guthi
 *
 */
public class ReimbursementAgreementActionTest extends AbstractTestCase{
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	/* (non-Javadoc)
	 * @see org.apache.struts2.StrutsTestCase#setUp()
	 */
	@Before
	protected void setUp() throws Exception {
		super.setUp();
	}

	/* (non-Javadoc)
	 * @see org.apache.struts2.StrutsTestCase#tearDown()
	 */
	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * This is used to test the ReimbursmentAgreement entry page
	 * Test method for {@link com.ge.aloc.action.admin.ReimbursementAgreementAction#openReimbursementAgreement()}.
	 */
	@Test
	public final void testOpenReimbursementAgreement() {		
		ReimbursementAgreementAction reimbursementAgreementAction = getReimbursementAgreementMgmtAction(ALOCConstants.OPENREIMBURSEMENTLIST);					
		try {			
			String result =  reimbursementAgreementAction.openReimbursementAgreement();
			assertNotNull(result);
			assertEquals(ALOCConstants.SUCCESS,result);
		} catch (HWFServiceException e) {
			fail(ALOCConstants.TESTCASE_FIALED_ERROR_MESSAGE + e.getMessage());
		}
		
	}

	/**
	 * This is used to test add or update functionality of a Reimbursment Agreement 
	 * Test method for {@link com.ge.aloc.action.admin.ReimbursementAgreementAction#createOrUpdateReimbursementAgreement()}.
	 */
	@Test
	public final void testCreateOrUpdateReimbursementAgreement() {
		ReimbursementAgreementAction reimbursementAgreementAction = getReimbursementAgreementMgmtAction("createOrUpdateAgreement");			 
		ReimbursementAgreement reimbursementAgreement = new ReimbursementAgreement();
		try {
			reimbursementAgreement.setReimbursementAgreementId(new BigInteger("341"));			
			reimbursementAgreement.setAgreementEnabledDisabled("Enabled");
			reimbursementAgreement.setAgreementText("Test Message");
			reimbursementAgreement.setDeafultAgreement(false);			
			Reimbursement reimbursement = new Reimbursement();
			reimbursement.setReimbursementAgreement(reimbursementAgreement);
			reimbursementAgreementAction.setReimbursement(reimbursement);					
			String result = reimbursementAgreementAction.createOrUpdateAgreement();			
			assertNotNull(result);
		} catch (HWFServiceException e) {
			fail(ALOCConstants.TESTCASE_FIALED_ERROR_MESSAGE + e.getMessage());
		}
		
	}
	
	/**
	 * This is used to get the details of a given Reimbursement agreement
	 * Test method for {@link com.ge.aloc.action.admin.ReimbursementAgreementAction#loadReimbursementAgreementDetails()}.
	 */
	@Test
	public final void testLoadReimbursementAgreementDetails() {
		ReimbursementAgreementAction reimbursementAgreementAction = getReimbursementAgreementMgmtAction("reimbursementAgreementDetails");		
		ReimbursementAgreement reimbursementAgreement = new ReimbursementAgreement();
		try {
			reimbursementAgreement.setReimbursementAgreementId(new BigInteger("341"));	
			Reimbursement reimbursement = new Reimbursement();
			reimbursement.setReimbursementAgreement(reimbursementAgreement);
			reimbursementAgreementAction.setReimbursement(reimbursement);				
			String result = reimbursementAgreementAction.loadReimbursementAgreementDetails();					
			assertNotNull(result);
			assertEquals(ALOCConstants.SUCCESS,result);
		} catch (HWFServiceException e) {
			fail(ALOCConstants.TESTCASE_FIALED_ERROR_MESSAGE + e.getMessage());
		}
	}
	
	/**
	 * This method is used to load roles from DB
	 * @return
	 * @throws HWFServiceException
	 */
	@Test
	public final void testGetReimbursementList(){
		ReimbursementAgreementAction reimbursementAgreementAction = getReimbursementAgreementMgmtAction("reimbursementAgreementDetails");		
		try {				
				List<NameValue> reimbursementList =  reimbursementAgreementAction.getReimbursementList();					
				assertNotNull(reimbursementList);			
		} catch (HWFServiceException e) {
			fail(ALOCConstants.TESTCASE_FIALED_ERROR_MESSAGE + e.getMessage());
		}		
	}		


}
