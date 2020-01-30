/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: SearchDAOTest.java
 * Purpose: SearchDAOTest used for the search DAO Implementations
 */
package com.ge.aloc.dao.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.DashboardViewType;
import com.ge.aloc.OpCode;
import com.ge.aloc.model.APMDetails;
import com.ge.aloc.model.APMSearch;
import com.ge.aloc.model.Inbox;
import com.ge.aloc.model.Search;
import com.ge.aloc.model.SearchReqDetails;
import com.ge.aloc.util.ALOCCommonHelper;
import com.hydus.hwf.bw.service.IServiceClient;
import com.hydus.hwf.context.UserContext;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author madhusudhan.gosula
 *
 */
public class SearchDAOTest {
	private static IServiceClient serviceClient;
	private static SearchDAO searchDAO;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		serviceClient = DAOConnectionHelper.getServiceClient();
		searchDAO = new SearchDAO();
		searchDAO.setServiceClient(serviceClient);
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
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * test Method to basic search in dash board
	 * Test method for {@link com.ge.aloc.dao.impl.SearchDAO#basicSearch(com.ge.aloc.model.Search)}.
	 */
	@Test
	public final void testexecuteSearch() {
		Search searchCriteria = new Search();
		SearchReqDetails SearchReqDetails=new SearchReqDetails();
		SearchReqDetails.setAlocReqNo(new BigInteger("10"));
		searchCriteria.setSearchReqDetails(SearchReqDetails);
		 DashboardViewType dashboardViewType=DashboardViewType.valueOf("BUNDLES");
		 setUserContextDetails();
		try {
			Inbox inbox = searchDAO.executeSearch(searchCriteria, dashboardViewType);
			assertNotNull(inbox);
			
		} catch (HWFServiceException e) {
			fail("Error while searching in dashboard");
		}
		
	}
	
	/**
	 * test Method to search in fee history
	 * Test method for {@link com.ge.aloc.dao.impl.SearchDAO#executeFHSearch(com.ge.aloc.model.APMSearch)}.
	 */
	@Test
	public final void testexecuteFHSearch() {
		 APMSearch apmSearch=new APMSearch();
		 APMDetails	apmDetails=new APMDetails();
		 apmDetails.setAPMSearch(apmSearch);
		 setUserContextDetails();
		 apmDetails.setMsgHeader(ALOCCommonHelper.createMsgHeader(OpCode.APMSEARCH.getOperationCode()));	
		try {
			APMDetails apmDetails1=searchDAO.executeFHSearch(apmDetails);
			assertNotNull(apmDetails1);		
		} catch (HWFServiceException e) {
			fail("Error while searching in dashboard");
		}
		
	}
	 /**
	   * Method to set the user context details 
	 */
	  private void setUserContextDetails()
	  {
		  List<String> rolesList = new ArrayList<String>();
		  rolesList.add("TreasuryAnalyst");
		  UserContext.getContext().getuserDetails().setUserId("999911248");
		  UserContext.getContext().getuserDetails().setLastName("TreasuryAnalyst_999911248");
		  UserContext.getContext().getuserDetails().setFirstName("Test_999911248");
		  UserContext.getContext().getuserDetails().setRoles(rolesList);
	  }

}
