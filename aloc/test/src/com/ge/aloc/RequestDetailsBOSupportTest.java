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

import com.ge.aloc.bo.RequestDetailsBO;
import com.ge.aloc.model.RequestDetails;

/**
 * @author madhusudhan.gosula
 *
 */
public class RequestDetailsBOSupportTest {
	
	private RequestDetailsBOSupport requestDetailsBOSupport;
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
		requestDetailsBOSupport = new RequestDetailsBOSupport();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.ge.aloc.RequestDetailsBOSupport#getRequestDetailsBO()}.
	 */
	@Test
	public final void testGetRequestDetailsBO() {
		RequestDetails requestDetails =  new RequestDetails();
		RequestDetailsBO requestDetailsBO = new RequestDetailsBO(requestDetails );
		requestDetailsBOSupport.setRequestDetailsBO(requestDetailsBO );
		
		requestDetailsBO = requestDetailsBOSupport.getRequestDetailsBO();
		assertNotNull(requestDetailsBO);
	}

	/**
	 * Test method for {@link com.ge.aloc.RequestDetailsBOSupport#getRequestDetails()}.
	 */
	@Test
	public final void testGetRequestDetails() {
		RequestDetails requestDetails =  new RequestDetails();
		RequestDetailsBO requestDetailsBO = new RequestDetailsBO(requestDetails );
		requestDetailsBOSupport.setRequestDetailsBO(requestDetailsBO );
		requestDetails = requestDetailsBOSupport.getRequestDetails();
		assertNotNull(requestDetailsBO);
	}

}
