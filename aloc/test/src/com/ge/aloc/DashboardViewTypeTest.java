/**
 * 
 */
package com.ge.aloc;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author madhusudhan.gosula
 *
 */
public class DashboardViewTypeTest {

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
	 * Test method for {@link com.ge.aloc.DashboardViewType#getOpCode()}.
	 */
	@Test
	public final void testGetOpCode() {
		DashboardViewType dashBoardViewType = DashboardViewType.MYTRANSACTIONS;
		assertNotNull(dashBoardViewType.getOpCode());
		assertEquals("DASHBOARD_MYTRANSACTIONS", dashBoardViewType.getOpCode().name());
		
		DashboardViewType dashBoardViewType1 = DashboardViewType.ALLREQUESTS;
		assertNotNull(dashBoardViewType1.getOpCode());
		assertEquals("DASHBOARD_ALLREQUESTS", dashBoardViewType1.getOpCode().name());
		
		DashboardViewType dashBoardViewType2 = DashboardViewType.DRAFTS;
		assertNotNull(dashBoardViewType2.getOpCode());
		assertEquals("DASHBOARD_DRAFTS", dashBoardViewType2.getOpCode().name());
		
		DashboardViewType dashBoardViewType3 = DashboardViewType.MODEL;
		assertNotNull(dashBoardViewType3.getOpCode());
		assertEquals("DASHBOARD_MODELS", dashBoardViewType3.getOpCode().name());
		
		DashboardViewType dashBoardViewType4 = DashboardViewType.BUNDLES;
		assertNotNull(dashBoardViewType4.getOpCode());
		assertEquals("DASHBOARD_BUNDLE", dashBoardViewType4.getOpCode().name());
		
		DashboardViewType dashBoardViewType5 = DashboardViewType.BANKBIDPROCESS;
		assertNotNull(dashBoardViewType5.getOpCode());
		assertEquals("DASHBOARD_BANK", dashBoardViewType5.getOpCode().name());
	}

}
