/**
 * 
 */
package com.ge.aloc.action.dashboard;

import java.io.IOException;
import java.util.HashMap;

import org.apache.struts2.ServletActionContext;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.DashboardViewType;
import com.ge.aloc.common.AbstractTestCase;
import com.ge.aloc.constants.ALOCConstants;
import com.hydus.hwf.exceptions.HWFException;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author madhusudhan.gosula
 *
 */
public class DashboardBaseActionTest extends AbstractTestCase{

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * This method is used to save default DashBoard view
	 * Test method for {@link com.ge.aloc.action.dashboard.DashboardBaseAction#saveDefaultView()}.
	 * @throws IOException 
	 */
	@Test
	public final void testSaveDefaultView() throws IOException {
		 DashboardBaseAction dashboardBaseAction;
			
	       dashboardBaseAction = getDashBoardBaseAction("displayDashboard");
			assertNotNull(dashboardBaseAction);
			
			try {
					setUserContextDetails();
				    request.setParameter(ALOCConstants.DEFAULT_VIEW, "MYTRANSACTIONS");
				    dashboardBaseAction.setRequest(ServletActionContext.getRequest());
					String result = dashboardBaseAction.saveDefaultView();
					assertNull(result);
					assertEquals(ALOCConstants.DV_SUCCESS_MSG,response.getContentAsString());
			} catch (HWFServiceException e) {
				fail("Error while saving the default view");
			}
			
	}

	/**
	 * This method is used to get the default DashBoard view type details
	 * Test method for {@link com.ge.aloc.action.dashboard.DashboardBaseAction#display()}.
	 */
	@Test
	public final void testDisplay() {
		  DashboardBaseAction dashboardBaseAction;
			
	       dashboardBaseAction = getDashBoardBaseAction("displayDashboard");
			assertNotNull(dashboardBaseAction);
			
			try {
				    setUserContextDetails();
					dashboardBaseAction.setSessionValues(new HashMap<String, Object>());
					String result = dashboardBaseAction.display();
					assertNotNull(result);
					assertEquals(ALOCConstants.SUCCESS,result);
			} catch (HWFServiceException e) {
				e.printStackTrace();
				fail("Error while displaying the default dashboard  details");
			}
	}
	
	/**
	 * Method to get the my transactions details based on glance selection
	 * Test method for {@link com.ge.aloc.action.dashboard.DashboardBaseAction#getGlanceDetails()}.
	 */
	@Test
	public final void testGetGlanceDetails() {
		  DashboardBaseAction dashboardBaseAction;
	      dashboardBaseAction = getDashBoardBaseAction("getGlanceDetails");
		  assertNotNull(dashboardBaseAction);
		  try {
			        setUserContextDetails();
			        request.setParameter(ALOCConstants.GLANCEPARAM,"BID"); 
			        dashboardBaseAction.setSessionValues(new HashMap<String, Object>());
					String result = dashboardBaseAction.getGlanceDetails();
					assertNotNull(result);
					assertEquals("success",result);
			} catch (HWFServiceException e) {
				e.printStackTrace();
				fail("Error while displaying the mytransactions glance records");
			}
		
	}
	
	/**
	 * This method is used to delete the selected request from DashBoard
	 * Test method for {@link com.ge.aloc.action.dashboard.DashboardBaseAction#deleteRequest(com.ge.aloc.model.Search)}.
	 * @throws HWFException 
	 */
	@Test
	public final void testdeleteRequest() throws HWFException {
       DashboardBaseAction dashboardBaseAction;
		
       dashboardBaseAction = getDashBoardBaseAction("deleteRequest");
		assertNotNull(dashboardBaseAction);
		
		try {
				setUserContextDetails();
			    dashboardBaseAction.setRequestId("7734");
				String result = dashboardBaseAction.deleteRequest();
				assertNotNull(result);
				assertEquals(ALOCConstants.SUCCESS,result);
		} catch (HWFServiceException e) {
			e.printStackTrace();
			fail("Error while deleting selected request");
		}
	}
	
	/**
	 * This method is used to enable the selected model from DashBoard
	 * Test method for {@link com.ge.aloc.action.dashboard.DashboardBaseAction#enableModel(com.ge.aloc.model.Search)}.
	 */
	@Test
	public final void testEnableModel() {
       DashboardBaseAction dashboardBaseAction;
       dashboardBaseAction = getDashBoardBaseAction("enableModel");
		assertNotNull(dashboardBaseAction);
		
		try {
				setUserContextDetails();
				request.setParameter(ALOCConstants.MODEL_REQUEST_ID, "7298");
				dashboardBaseAction.setDashboardViewType(DashboardViewType.MODEL);
				String result = dashboardBaseAction.enableModel();
				assertNotNull(result);
				assertEquals(ALOCConstants.SUCCESS,result);
		} catch (HWFServiceException e) {
			e.printStackTrace();
			fail("Error while calling enable model Process");
		}
	}
	
	/**
	 * This method is used to disable the selected model from DashBoard
	 * Test method for {@link com.ge.aloc.action.dashboard.DashboardBaseAction#disableModel(com.ge.aloc.model.Search)}.
	 */
	@Test
	public final void testDisableModel() {
		DashboardBaseAction dashboardBaseAction;
        dashboardBaseAction = getDashBoardBaseAction("disableModel");
		assertNotNull(dashboardBaseAction);
			
		try {
				setUserContextDetails();
				request.setParameter(ALOCConstants.MODEL_REQUEST_ID, "7298");
				dashboardBaseAction.setDashboardViewType(DashboardViewType.MODEL);
				String result = dashboardBaseAction.disableModel();
				assertNotNull(result);
				assertEquals(ALOCConstants.SUCCESS,result);
			} catch (HWFServiceException e) {
				e.printStackTrace();
				fail("Error while calling disable model Process");
			}
	}
	
	/**
	 * This method is used to delete the selected model from DashBoard 
	 * Test method for {@link com.ge.aloc.action.dashboard.DashboardBaseAction#deleteModel(com.ge.aloc.model.Search)}.
	 */
	@Test
	public final void testDeleteModel() {
		DashboardBaseAction dashboardBaseAction;
		
	       dashboardBaseAction = getDashBoardBaseAction("deleteModel");
			assertNotNull(dashboardBaseAction);
			
			try {
					setUserContextDetails();
					request.setParameter(ALOCConstants.MODEL_REQUEST_ID, "7188");
					dashboardBaseAction.setDashboardViewType(DashboardViewType.MODEL);
					String result = dashboardBaseAction.deleteModel();
					assertNotNull(result);
					assertEquals(ALOCConstants.SUCCESS,result);
			} catch (HWFServiceException e) {
				e.printStackTrace();
				fail("Error while calling delete model Process");
			}
	}
	
	/**
	 * This method is used to get the all requests details for selected bundle
	 * Test method for {@link com.ge.aloc.action.dashboard.DashboardBaseAction#getAllRequestInfoForSelBundle(com.ge.aloc.model.Search)}.
	 */
	@Test
	public final void testgetAllRequestInfoForSelBundle() {
		DashboardBaseAction dashboardBaseAction;
		
	       dashboardBaseAction = getDashBoardBaseAction("getAllRequestInfoForSelBundle");
			assertNotNull(dashboardBaseAction);
			
			try {
					setUserContextDetails();
					request.setParameter(ALOCConstants.BUNDLEID, "241");
					dashboardBaseAction.setDashboardViewType(DashboardViewType.BUNDLEREQ);
					String result = dashboardBaseAction.getAllRequestInfoForSelBundle();
					assertNotNull(result);
					assertEquals(ALOCConstants.SUCCESS,result);
			} catch (HWFServiceException e) {
				e.printStackTrace();
				fail("Error while retrieving all request details for selected bundle");
			}
	}
}
