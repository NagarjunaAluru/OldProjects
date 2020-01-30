/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: DefaultDashboardManagerTest.java
 * Purpose: DefaultDashboardManagerTest used for the transactions,draft,my request 
 * and other business methods
 */
package com.ge.aloc.manager.impl.dashboard;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.DashboardViewType;
import com.ge.aloc.dao.impl.DAOConnectionHelper;
import com.ge.aloc.dao.impl.dashboard.DashboardDAO;
import com.ge.aloc.model.Inbox;
import com.ge.aloc.model.RequestDetails;
import com.hydus.hwf.bw.service.IServiceClient;
import com.hydus.hwf.context.UserContext;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author madhusudhan.gosula
 *
 */
public class DefaultDashboardManagerTest {
	private static IServiceClient serviceClient;
	private static DashboardDAO dashboardDAO;
	private static DefaultDashboardManager defaultDashboardManager;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		serviceClient = DAOConnectionHelper.getServiceClient();		
		defaultDashboardManager = new DefaultDashboardManager();
		dashboardDAO = new DashboardDAO();
		dashboardDAO.setServiceClient(serviceClient);
		defaultDashboardManager.setCommonDashboardDAO(dashboardDAO);
		List<String> rolesList = new ArrayList<String>();
		rolesList.add("TreasuryAnalyst");
		UserContext.getContext().getuserDetails().setUserId("999911248");
		UserContext.getContext().getuserDetails().setLastName("TreasuryAnalyst_999911248");
		UserContext.getContext().getuserDetails().setFirstName("Test_999911248");
		UserContext.getContext().getuserDetails().setRoles(rolesList);
	}

	/**
	 * This method is used to save default DashBoard view
	 * Test method for {@link com.ge.aloc.manager.impl.dashboard.DefaultDashboardManager#saveDefaultDisplayTabName(java.lang.Object)}.
	 */
	@Test
	public final void testSaveDefaultDisplayTabName() {
		try {
		 	   defaultDashboardManager.saveDefaultDisplayTabName("MYTRANSACTIONS");
			} catch (HWFServiceException e) {
				fail("Error while updating Default view of DashBoard");
			}
		}

	/**
	 * This method is used to get the selected DashBoard view type details
	 * Test method for {@link com.ge.aloc.manager.impl.dashboard.DefaultDashboardManager#loadDashboardData(com.ge.aloc.DashboardViewType)}.
	 */
	@Test
	public final void testLoadDashboardData() {
			try {
					Inbox inbox = defaultDashboardManager.loadDashboardData(DashboardViewType.MYTRANSACTIONS);
					assertNotNull(inbox);
					assertNotNull(inbox.getMyTransactions());
			} catch (HWFServiceException e) {
				e.printStackTrace();
				fail("Error while displaying the My Transaction dashboard details");
			}
			try {
					Inbox inbox = defaultDashboardManager.loadDashboardData(DashboardViewType.ALLREQUESTS);
					assertNotNull(inbox);
					assertNotNull(inbox.getAllRequests());
			} catch (HWFServiceException e) {
				e.printStackTrace();
				fail("Error while displaying the All Request dashboard details");
			}
			try {
					Inbox inbox = defaultDashboardManager.loadDashboardData(DashboardViewType.DRAFTS);
					assertNotNull(inbox);
					assertNotNull(inbox.getDrafts());
			} catch (HWFServiceException e) {
				e.printStackTrace();
				fail("Error while displaying the Draft dashboard details");
			}
			try {
					Inbox inbox = defaultDashboardManager.loadDashboardData(DashboardViewType.MODEL);
					assertNotNull(inbox);
					assertNotNull(inbox.getModels());
			} catch (HWFServiceException e) {
				e.printStackTrace();
				fail("Error while displaying the Model dashboard details");
			}
			try {
					Inbox inbox = defaultDashboardManager.loadDashboardData(DashboardViewType.BUNDLES);
					assertNotNull(inbox);
					assertNotNull(inbox.getBundle());
			} catch (HWFServiceException e) {
				e.printStackTrace();
				fail("Error while displaying the bundle dashboard details");
			}
	}

	/**
	 * This method is used to get the default DashBoard view type details
	 * Test method for {@link com.ge.aloc.manager.impl.dashboard.DefaultDashboardManager#loadDefaultDashboardData()}.
	 */
	@Test
	public final void testLoadDefaultDashboardData() {
			try {
					Inbox inbox = defaultDashboardManager.loadDefaultDashboardData();
					assertNotNull(inbox);
					assertNotNull(inbox.getMyTransactions());
		} catch (HWFServiceException e) {
			e.printStackTrace();
			fail("Error while displaying the default dashboard details");
		}
	}
	
	/**
	 * This method is used to delete the selected request from DashBoard
	 * Test method for {@link com.ge.aloc.manager.impl.dashboard.DefaultDashboardManager#deleteRequest()}.
	 */
	@Test
	public final void testDeleteRequest() {
			try {
					RequestDetails requestDetails = defaultDashboardManager.deleteRequest("7734");
					assertNotNull(requestDetails);
		} catch (HWFServiceException e) {
			e.printStackTrace();
			fail("Error while deleting selected requestDetails");
		}
	}
	
	/**
	 * This method is used to enable the selected model from DashBoard
	 * Test method for {@link com.ge.aloc.manager.impl.dashboard.DefaultDashboardManager#enableModel()}.
	 */
	@Test
	public final void testEnableModel() {
			try {
					Inbox inbox = defaultDashboardManager.enableModel(DashboardViewType.MODEL, "7298");
					assertNotNull(inbox);
		} catch (HWFServiceException e) {
			e.printStackTrace();
			fail("Error while calling enable model Process");
		}
	}
	
	/**
	 * This method is used to disable the selected model from DashBoard
	 * Test method for {@link com.ge.aloc.manager.impl.dashboard.DefaultDashboardManager#disableModel()}.
	 */
	@Test
	public final void testDisableModel() {
			try {
					Inbox inbox = defaultDashboardManager.disableModel(DashboardViewType.MODEL, "7298");
					assertNotNull(inbox);
		} catch (HWFServiceException e) {
			e.printStackTrace();
			fail("Error while calling disable model Process");
		}
	}
	
	/**
	 * This method is used to delete the selected model from DashBoard
	 * Test method for {@link com.ge.aloc.manager.impl.dashboard.DefaultDashboardManager#deleteModel()}.
	 */
	@Test
	public final void testDeleteModel() {
			try {
					Inbox inbox = defaultDashboardManager.deleteModel(DashboardViewType.MODEL, "7188");
					assertNotNull(inbox);
		} catch (HWFServiceException e) {
			e.printStackTrace();
			fail("Error while calling delete model Process");
		}
	}
	
	
	/**
	 * This method is used to delete the selected model from DashBoard
	 * Test method for {@link com.ge.aloc.manager.impl.dashboard.DefaultDashboardManager#deleteModel()}.
	 */
	@Test
	public final void testGetGlanceDetails() {
		//TODO set the parameters in request
	}
}
