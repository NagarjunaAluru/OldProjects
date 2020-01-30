/**
 * 
 */
package com.ge.aloc.manager.impl.dashboard;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.dao.impl.DAOConnectionHelper;
import com.ge.aloc.dao.impl.dashboard.DashboardRefDataDAO;
import com.ge.aloc.model.ActionLog;
import com.hydus.hwf.bw.service.IServiceClient;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author madhusudhan.gosula
 *
 */
public class DashboardRefDataManagerTest {
	private static IServiceClient serviceClient;
	private static DashboardRefDataManager dashboardRefDataManager;
	private static DashboardRefDataDAO dashboardRefDataDAO;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		serviceClient = DAOConnectionHelper.getServiceClient();
		dashboardRefDataManager = new DashboardRefDataManager(); 
		dashboardRefDataDAO = new DashboardRefDataDAO();
		dashboardRefDataDAO.setServiceClient(serviceClient);
		dashboardRefDataManager.setDashboardRefDataDAO(dashboardRefDataDAO);
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
	 * Test method for {@link com.ge.aloc.manager.impl.dashboard.DashboardRefDataManager#getActionLog(java.lang.String)}.
	 */
	@Test
	public final void testGetActionLog() {

		String requestId = "5053";		
		try {
			List<ActionLog> actionLogs = dashboardRefDataManager.getActionLog(requestId,requestId,"2");
			assertNotNull(actionLogs);
		} catch (HWFServiceException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		}
	}
}
