/**
 * 
 */
package com.ge.aloc.manager.impl;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.dao.impl.DAOConnectionHelper;
import com.ge.aloc.dao.impl.RequestDetailsSectionDAO;
import com.hydus.hwf.bw.service.IServiceClient;

/**
 * @author narasimhulu.b
 *
 */
public class RequestDetailsSectionManagerTest {
	private static IServiceClient serviceClient;
	private static RequestDetailsSectionManager requestDetailsSectionManager;	
	private static RequestDetailsSectionDAO requestDetailsSectionDAO;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		serviceClient = DAOConnectionHelper.getServiceClient();
		requestDetailsSectionManager = new RequestDetailsSectionManager();	
		requestDetailsSectionDAO = new RequestDetailsSectionDAO();
		requestDetailsSectionDAO.setServiceClient(serviceClient);
		requestDetailsSectionManager.setRequestDetailsSectionDAO(requestDetailsSectionDAO);
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
	 * Test method for {@link com.ge.aloc.manager.impl.RequestDetailsSectionManager#getRequestDetailsSectionDAO()}.
	 */
	@Test
	public void testGetRequestDetailsSectionDAO() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.ge.aloc.manager.impl.RequestDetailsSectionManager#setRequestDetailsSectionDAO(com.ge.aloc.dao.IRequestDetailsSectionDAO)}.
	 */
	@Test
	public void testSetRequestDetailsSectionDAO() {
		fail("Not yet implemented");
	}

}
