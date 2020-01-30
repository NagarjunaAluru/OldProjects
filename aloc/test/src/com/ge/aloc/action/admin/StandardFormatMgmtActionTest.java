/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: StandardFormatMgmtActionTest.java
 * Purpose: StandardFormatMgmtActionTest class used for testing the usecases of the screen
 *
 */
package com.ge.aloc.action.admin;


import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.common.AbstractTestCase;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.model.StandardFormatMaster;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author rajeswari.guthi
 *
 */
public class StandardFormatMgmtActionTest extends AbstractTestCase {

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
	 * This is used to open the standard format management.
	 * Test method for {@link com.ge.aloc.action.admin.StandardFormatMgmtAction#openStdFormatUrlManagement()}.
	 * @throws Exception 
	 * @throws HWFServiceException 
	 */
	@Test
	public final void testOpenStdFormatUrlManagement() throws Exception {		
		StandardFormatMgmtAction standardFormatMgmtAction = getStdFormatMgmtAction("openStdFormatUrlManagement");//It is a method name		
		try {
			standardFormatMgmtAction.openStdFormatUrlManagement();
		} catch (HWFServiceException e) {
			fail(ALOCConstants.TESTCASE_FIALED_ERROR_MESSAGE + e.getMessage());	
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.action.admin.StandardFormatMgmtAction#getStdFormatManagement()}.
	 * @throws Exception 
	 */
	@Test
	public final void testGetStdFormatManagement() throws Exception {
		StandardFormatMaster standardFormatMaster = new StandardFormatMaster();
		StandardFormatMgmtAction standardFormatMgmtAction = getStdFormatMgmtAction(ALOCConstants.GESTANDARDFORMATMANAGEMENT);
		standardFormatMaster.setStandardFormatInstrumentTypeId(Long.valueOf("1"));
		standardFormatMaster.setStandardFormatPurpusId(Long.valueOf("12"));
		standardFormatMgmtAction.setStandardFormatMaster(standardFormatMaster);
		try {		
			 setUserContextDetails();
			 String result = standardFormatMgmtAction.getStdFormatManagement();
			 assertNotNull(result);
		} catch (HWFServiceException e) {
			fail(ALOCConstants.TESTCASE_FIALED_ERROR_MESSAGE + e.getMessage());	
		}
	}

	/**
	 * This test is used to get the standard format audit log download
	 * @throws Exception
	 */
	@Test
	public final void testUpdatedGeStandardFormatFile() throws Exception{		
		StandardFormatMgmtAction standardFormatMgmtAction = getStdFormatMgmtAction("downloadFormat"); 
		request.setParameter(ALOCConstants.FORMATAUDITTRAILID, "487"); 
		request.setParameter(ALOCConstants.INSTRUMENT_TYPE_ID, "1");
		try {			
			 setUserContextDetails();
			 standardFormatMgmtAction.updatedGeStandardFormatFile();			 
		} catch (HWFServiceException e) {		
			fail(ALOCConstants.TESTCASE_FIALED_ERROR_MESSAGE + e.getMessage());	
		}
	}
	
	/**
	 * Test method for {@link com.ge.aloc.action.admin.StandardFormatMgmtAction#standardFormatManagement()}.
	 * @throws Exception 
	 */
	@Test
	public final void testStandardFormatManagement() throws Exception {
		StandardFormatMaster standardFormatMaster = new StandardFormatMaster();
		StandardFormatMgmtAction standardFormatMgmtAction = getStdFormatMgmtAction("standardFormatManagement");
		standardFormatMaster.setStandardFormatInstrumentTypeId(Long.valueOf("1"));
		standardFormatMaster.setStandardFormatPurpusId(Long.valueOf("12"));
		standardFormatMaster.setStandardFormatId(Long.valueOf("161"));
		String bookmarks ="<ALOC Record Number>,<Applicant Address>,<Beneficiary Address>,<Contract Amount>,<Contract Number>,<Expiration Date>,<Instrument Amount>,<Instrument Type>,<Project Description>,";
		bookmarks+="<Advance Payment Amount>,<Applicant Name>,<Beneficiary Name>,<Contract Date>,<Currency Code>,<Instrument Amount in Words>,<Instrument Purpose>";
		standardFormatMaster.setStandardFormatFormat(bookmarks);
		try {
			 setUserContextDetails();
			 String result = standardFormatMgmtAction.standardFormatManagement();
			 assertNotNull(result);
		} catch (HWFServiceException e) {
			fail(ALOCConstants.TESTCASE_FIALED_ERROR_MESSAGE + e.getMessage());	
		}
	}

}
