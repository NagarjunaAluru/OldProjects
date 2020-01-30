/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: FeeHistoryActionTest.java
 * Purpose: FeeHistoryActionTest class used for testing the usecases of the screen
 *
 */
package com.ge.aloc.action.apm;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.common.AbstractTestCase;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.model.StaticDataManagement.UserSites;
import com.hydus.hwf.context.UserContext;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author nagarjuna.aluru
 *
 */
public class FeeHistoryActionTest extends AbstractTestCase{

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
	 * This method is used to search for FeeHistory
	 * Test method for {@link com.ge.aloc.action.apm.FeeHistoryAction#searchFeeHistory()}.
	 */
	@Test
	public void testSearchFeeHistory() {
		FeeHistoryAction feeHistoryAction = getFeeHistoryAction("searchFeeHistory");
		assertNotNull(feeHistoryAction);		
		try {						
			setUserContextDetails();			
			List<UserSites> userSitesLst = new ArrayList<UserSites>();
			UserSites userSites = new UserSites();
			userSites.setUserSso(UserContext.getContext().getuserDetails().getUserId());
			userSites.setSiteTypeId(BigInteger.valueOf(1562));
			userSites.setSiteType("SITE_TEST_HYDUS_FINAN_CR_001");
			userSitesLst.add(userSites);			
			Map<String, Object> userSitesMap = new HashMap<String, Object>();
			userSitesMap.put(ALOCConstants.USERSPECIFICSITES,userSitesLst);
			feeHistoryAction.sessionValues = userSitesMap;		
			request.setParameter(ALOCConstants.DEF_VIEW_TYPE,"Top Level Summary");
			String result = feeHistoryAction.searchFeeHistory();
			assertEquals("success", result);
		} catch (HWFServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to export Invoice file 
	 * Test method for {@link com.ge.aloc.action.apm.FeeHistoryAction#exportInvoiceFeeHistory()}.
	 */
	@Test
	public void testExportInvoiceFeeHistory() {
		FeeHistoryAction feeHistoryAction;
		feeHistoryAction = getFeeHistoryAction("exportInvoiceFeeHistory");
		assertNotNull(feeHistoryAction);
			try {
				request.setParameter(ALOCConstants.PAYMENT_IDS,"1");
				request.setParameter(ALOCConstants.ALOC_REC_NOS,"4693");
				feeHistoryAction.exportInvoiceFeeHistory();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

}
