/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: SearchManagerTest.java
 * Purpose: SearchManagerTest used for the search operations
 */
package com.ge.aloc.manager.impl;

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
import com.ge.aloc.dao.impl.DAOConnectionHelper;
import com.ge.aloc.dao.impl.SearchDAO;
import com.ge.aloc.model.APMDetails;
import com.ge.aloc.model.APMSearch;
import com.ge.aloc.model.BundleDetails;
import com.ge.aloc.model.Inbox;
import com.ge.aloc.model.RequestDetails;
import com.ge.aloc.model.Search;
import com.ge.aloc.model.SearchReqDetails;
import com.hydus.hwf.bw.service.IServiceClient;
import com.hydus.hwf.context.UserContext;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author madhusudhan.gosula
 *
 */
public class SearchManagerTest {
	private static IServiceClient serviceClient;
	public static SearchManager searchManager;
	private static SearchDAO searchDAO;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		serviceClient = DAOConnectionHelper.getServiceClient();
		searchManager = new SearchManager();	
		searchDAO = new SearchDAO();
		searchDAO.setServiceClient(serviceClient);
		searchManager.setSearchDAO(searchDAO);
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
	 * Test method for {@link com.ge.aloc.manager.impl.SearchManager#executeSearch()}.
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
			Inbox inbox = searchManager.executeSearch(searchCriteria, dashboardViewType);
			assertNotNull(inbox);
		} catch (HWFServiceException e) {
			fail("Error while searching in dashboard");
		}
		
	}
	
	/**
	 * test Method to search in fee history
	 * Test method for {@link com.ge.aloc.manager.impl.SearchManager#executeFHSearch()}.
	 */
	@Test
	public final void testexecuteFHSearch() {
		APMSearch apmSearch=new APMSearch();
		apmSearch.setALOCRecordNumber(new BigInteger("6935"));
		setUserContextDetails();
		try {
			APMDetails apmdetails=searchManager.executeFHSearch(apmSearch);
			assertNotNull(apmdetails);
		} catch (HWFServiceException e) {
			fail("Error while searching in dashboard");
		}
		
	}
	
	/**
	 * Test method for manage bundle in dash board
	 * Test method for  {@link com.ge.aloc.manager.impl.SearchManager#manageBundleSearch
	 */
	@Test
	public final void testmanageBundleSearch() {
		Search search = new Search();
		Inbox inbox = new Inbox();
		try {
			DashboardViewType dashboardViewType=DashboardViewType.valueOf("BUNDLES");
			List<RequestDetails> requestDetails = new ArrayList<RequestDetails>();
			RequestDetails details = new RequestDetails();
			BundleDetails bundleDetails  = new BundleDetails();
			bundleDetails.setBundleId(new BigInteger("241"));
			details.setBundleDetails(bundleDetails);
			requestDetails.add(details);
			search.setRequestDetails(requestDetails);
			setUserContextDetails();
			inbox = searchManager.executeSearch(search, dashboardViewType);
			assertNotNull(inbox);
		} catch (HWFServiceException e) {
			assertNotNull(e);
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
