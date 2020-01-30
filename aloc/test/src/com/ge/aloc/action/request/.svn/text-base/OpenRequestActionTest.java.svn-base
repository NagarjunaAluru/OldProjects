/**
 * 
 */
package com.ge.aloc.action.request;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigInteger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author madhusudhan.gosula
 *
 */
public class OpenRequestActionTest {
	
	private OpenRequestAction openRequestAction;

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
		openRequestAction = new OpenRequestAction();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.ge.aloc.action.request.OpenRequestAction#execute()}.
	 */
	@Test
	public final void testExecute() {
		openRequestAction.execute();
	}

	/**
	 * Test method for {@link com.ge.aloc.action.request.OpenRequestAction#getRequestId()}.
	 */
	@Test
	public final void testGetRequestId() {
		
		openRequestAction.setRequestId(new BigInteger("123"));
		
		assertNotNull(openRequestAction.getRequestId());
		assertEquals(new BigInteger("123"), openRequestAction.getRequestId());
		
	}

	/**
	 * Test method for {@link com.ge.aloc.action.request.OpenRequestAction#getStage()}.
	 */
	@Test
	public final void testGetStage() {
		openRequestAction.setStage(1);
		assertNotNull(openRequestAction.getStage());
		assertEquals(Integer.valueOf(1), openRequestAction.getStage());
	}

}
