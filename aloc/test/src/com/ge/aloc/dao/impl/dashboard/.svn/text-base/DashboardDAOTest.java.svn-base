/**
 * 
 */
package com.ge.aloc.dao.impl.dashboard;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.DashboardViewType;
import com.ge.aloc.dao.impl.DAOConnectionHelper;
import com.ge.aloc.model.Inbox;
import com.ge.aloc.model.RequestDetails;
import com.ge.aloc.model.RequestDetailsCollectionType;
import com.ge.aloc.model.Search;
import com.ge.aloc.util.ALOCCommonHelper;
import com.hydus.hwf.bw.service.IServiceClient;
import com.hydus.hwf.context.UserContext;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author arijit.biswas
 *
 */
public class DashboardDAOTest {
	private static IServiceClient serviceClient;
	private static DashboardDAO dashboardDAO;
	private static Inbox inbox;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		serviceClient = DAOConnectionHelper.getServiceClient();
		dashboardDAO = new DashboardDAO();
		dashboardDAO.setServiceClient(serviceClient);
		inbox = new Inbox();
		List<String> rolesList = new ArrayList<String>();
		rolesList.add("TreasuryAnalyst");
		UserContext.getContext().getuserDetails().setUserId("999911248");
		UserContext.getContext().getuserDetails().setLastName("TreasuryAnalyst_999911248");
		UserContext.getContext().getuserDetails().setFirstName("Test_999911248");
		UserContext.getContext().getuserDetails().setRoles(rolesList);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dashboardDAO = null;
		inbox = null;
	}

	/**
	 * This method is used to get the default DashBoard view type details
	 * Test method for {@link com.ge.aloc.dao.impl.dashboard.DashboardDAO#loadDashboardData(com.ge.aloc.model.Inbox)}.
	 */
	@Test
	public void testLoadDashboardData() {
		try {
				inbox = new Inbox();
				inbox = dashboardDAO.loadDashboardData(inbox,DashboardViewType.MYTRANSACTIONS);
				assertNotNull(inbox);
				assertNotNull(inbox.getMyTransactions());
			 } catch (HWFServiceException e) {
				 fail("Error while retrieving My Transaction details");
			 }
		try {
				inbox = dashboardDAO.loadDashboardData(inbox,DashboardViewType.ALLREQUESTS);
				assertNotNull(inbox);
				assertNotNull(inbox.getAllRequests());
			} catch (HWFServiceException e) {
				fail("Error while retrieving All Request details");
			}
		try {
				inbox = dashboardDAO.loadDashboardData(inbox,DashboardViewType.DRAFTS);
				assertNotNull(inbox);
				assertNotNull(inbox.getDrafts());
			} catch (HWFServiceException e) {
				fail("Error while retrieving Draft details");
			}
		try {
				inbox = dashboardDAO.loadDashboardData(inbox,DashboardViewType.MODEL);
				assertNotNull(inbox);
				assertNotNull(inbox.getModels());
			} catch (HWFServiceException e) {
				fail("Error while retrieving Model details");
			}
		try {
				inbox = dashboardDAO.loadDashboardData(inbox,DashboardViewType.BUNDLES);
				assertNotNull(inbox);
				assertNotNull(inbox.getBundle());
			} catch (HWFServiceException e) {
				fail("Error while retrieving bundle details");
		}
	}

	/**
	 * This method is used to save default DashBoard view
	 * Test method for {@link com.ge.aloc.dao.impl.dashboard.DashboardDAO#saveDefaultDisplayTabName(com.ge.aloc.model.Inbox)}.
	 */
	@Test
	public void testSaveDefaultDisplayTabName() {
		try {
			 	inbox = new Inbox();
			 	inbox.setDefaultView("MYTRANSACTIONS");
			 	inbox = dashboardDAO.saveDefaultDisplayTabName(inbox);
			 	assertNotNull(inbox);
		} catch (HWFServiceException e) {
			fail("Error while updating Default view of DashBoard");
		}
	}
	
	/**
	 * This method is used to enable the selected model from DashBoard
	 * Test method for {@link com.ge.aloc.dao.impl.dashboard.DashboardDAO#enableModel(com.ge.aloc.model.Inbox)}.
	 */
	@Test
	public void testEnableModel() {
		try {
				inbox = new Inbox();		
				RequestDetails requestDetails = new RequestDetails();
				requestDetails.setRequestId(new BigInteger("7298"));		
				List<RequestDetails> requestDetailList = new ArrayList<RequestDetails>();
				requestDetailList.add(requestDetails);		
				RequestDetailsCollectionType requestDetailsCollectionList = new RequestDetailsCollectionType();
				requestDetailsCollectionList.setRequestDetails(requestDetailList);		
				inbox.setModels(requestDetailsCollectionList);
				inbox = dashboardDAO.enableModel(inbox);
				assertNotNull(inbox);
		} catch (HWFServiceException e) {
			fail("Error while calling enable model Process");
		}
	}
	
	/**
	 * This method is used to disable the selected model from DashBoard
	 * Test method for {@link com.ge.aloc.dao.impl.dashboard.DashboardDAO#disableModel(com.ge.aloc.model.Inbox)}.
	 */
	@Test
	public void testDisableModel() {
		try {
				inbox = new Inbox();		
				RequestDetails requestDetails = new RequestDetails();
				requestDetails.setRequestId(new BigInteger("7298"));		
				List<RequestDetails> requestDetailList = new ArrayList<RequestDetails>();
				requestDetailList.add(requestDetails);		
				RequestDetailsCollectionType requestDetailsCollectionList = new RequestDetailsCollectionType();
				requestDetailsCollectionList.setRequestDetails(requestDetailList);		
				inbox.setModels(requestDetailsCollectionList);
				inbox = dashboardDAO.disableModel(inbox);
				assertNotNull(inbox);
		} catch (HWFServiceException e) {
			fail("Error while calling disable model Process");
		}
	}
	
	/**
	 * This method is used to delete the selected model from DashBoard
	 * Test method for {@link com.ge.aloc.dao.impl.dashboard.DashboardDAO#deleteModel(com.ge.aloc.model.Inbox)}.
	 */
	@Test
	public void testDeleteModel() {
		try {
				inbox = new Inbox();		
				RequestDetails requestDetails = new RequestDetails();
				requestDetails.setRequestId(new BigInteger("7188"));		
				List<RequestDetails> requestDetailList = new ArrayList<RequestDetails>();
				requestDetailList.add(requestDetails);		
				RequestDetailsCollectionType requestDetailsCollectionList = new RequestDetailsCollectionType();
				requestDetailsCollectionList.setRequestDetails(requestDetailList);		
				inbox.setModels(requestDetailsCollectionList);
				inbox = dashboardDAO.disableModel(inbox);
				assertNotNull(inbox);
		} catch (HWFServiceException e) {
			fail("Error while calling delete model Process");
		}
	}
	
	/**
	 * Method to get the my transactions details based on glance selection
	 * Test method for {@link com.ge.aloc.dao.impl.dashboard.DashboardDAO#getGlanceDetails(com.ge.aloc.model.Inbox)}.
	 */
	@Test
	public void testGetGlanceDetails() {
		try {
			    Search searchCriteria=new Search();
			    searchCriteria=ALOCCommonHelper.createSearch("BIDS");
				String glancecount ="";
				inbox = dashboardDAO.getGlanceDetails(searchCriteria, glancecount );
				assertNotNull(inbox);
				assertNotNull(inbox.getGlanceDetails());
		} catch (HWFServiceException e) {
			fail("Error while retrieving glance details");
		}
	}
	/**
	 * This method is used to delete the selected request from DashBoard
	 * Test method for {@link com.ge.aloc.dao.impl.dashboard.DashboardDAO#deleteRequest(com.ge.aloc.model.Inbox)}.
	 */
	@Test
	public void testDeleteRequest() {
		try {
				RequestDetails requestDetails = new RequestDetails();
				requestDetails.setRequestId(new BigInteger("7734"));
				requestDetails=dashboardDAO.deleteRequest(requestDetails);
				assertNotNull(requestDetails);
		} catch (HWFServiceException e) {
			fail("Error while deleting requestDetails");
		}
	}
}
