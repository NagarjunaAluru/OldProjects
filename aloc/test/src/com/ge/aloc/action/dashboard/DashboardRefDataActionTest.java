/**
 * 
 */
package com.ge.aloc.action.dashboard;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.common.AbstractTestCase;
import com.ge.aloc.constants.ALOCConstants;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author madhusudhan.gosula
 *
 */
public class DashboardRefDataActionTest extends AbstractTestCase{

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
	 * Test Method to get the Action log details of selected request
	 * Test method for {@link com.ge.aloc.action.dashboard.DashboardRefDataAction#getActionLog()}.
	 */
	@Test
	public final void testGetActionLog() {
		
		DashboardRefDataAction dashboardRefDataAction;
		dashboardRefDataAction = getDashboardRefDataAction("ActionLogDashboardRefData");
		assertNotNull(dashboardRefDataAction);
		setUserContextDetails();
		request.setParameter(ALOCConstants.REQUESTID,"10");
		dashboardRefDataAction.setRequest(request);
		try {
					String result = dashboardRefDataAction.getActionLog();
					assertNotNull(result);
					assertEquals("actionLogSuccess",result);
		 } catch (HWFServiceException e) {
				fail("Error while getting action log");
		}
		
	}

	/**
	 * Test Method to get the request contact information for selected request
	 * Test method for {@link com.ge.aloc.action.dashboard.DashboardRefDataAction#getRequestContactInfo()}.
	 */
	@Test
	public final void testGetRequestContactInfo() {
		DashboardRefDataAction dashboardRefDataAction;
		dashboardRefDataAction = getDashboardRefDataAction("RequestContactInfoDashboardRefData");
		assertNotNull(dashboardRefDataAction);
		setUserContextDetails();
		request.setParameter(ALOCConstants.REQUESTID,"7205");
		request.setParameter(ALOCConstants.DASHBOARDTYPE,"MYTRANSACTIONS");
		dashboardRefDataAction.setRequest(request);
		try {
			String result = dashboardRefDataAction.getRequestContactInfo();
			assertNull(result);
			assertEquals("null",result);
	} catch (HWFServiceException e) {
		fail("Error while getting WB details");
	}
	}
	
	/**
	 * Test Method to get the treasury bid process request contact information for selected request
	 * Test method for {@link com.ge.aloc.action.dashboard.DashboardRefDataAction#getTreasuryBidRequestContactInfo()}.
	 */
	@Test
	public final void testGetTreasuryBidRequestContactInfo() {
		DashboardRefDataAction dashboardRefDataAction;
		dashboardRefDataAction = getDashboardRefDataAction("RequestContactInfoDashboardRefData");
		assertNotNull(dashboardRefDataAction);
		setUserContextDetails();
		dashboardRefDataAction.setRequestId("10");
		try {
			String result = dashboardRefDataAction.getTreasuryBidRequestContactInfo();
			assertNull(result);
			assertEquals("null",result);
	} catch (HWFServiceException e) {
		fail("Error while retrieving request contact info for treasury bid process");
	}
	}
}
