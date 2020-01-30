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
public class WorkflowStageTest {

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
	 * Test method for {@link com.ge.aloc.WorkflowStage#fromId(int)}.
	 */
	@Test
	public final void testFromId() {
		WorkflowStage actionType = WorkflowStage.fromId(1);
		assertNotNull(actionType.getId());
		assertNotNull(actionType.getName());
		assertEquals(1, actionType.getId());
		assertEquals("Requestor", actionType.getName());
		WorkflowStage actionType1 = WorkflowStage.fromId(99);
		assertNull(actionType1);
	}

	/**
	 * Test method for {@link com.ge.aloc.WorkflowStage#getId()}.
	 */
	@Test
	public final void testGetId() {
		WorkflowStage actionType = WorkflowStage.REQUESTER;
		assertNotNull(actionType.getId());
		assertEquals(1, actionType.getId());
	}

	/**
	 * Test method for {@link com.ge.aloc.WorkflowStage#getName()}.
	 */
	@Test
	public final void testGetName() {
		WorkflowStage actionType = WorkflowStage.BUSINESSAPPROVER;
		assertNotNull(actionType.getName());
		assertEquals("BUSAPROV", actionType.getName());
	}

}
