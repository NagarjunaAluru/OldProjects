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
public class GoveringRuleTypeTest {

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
	 * Test method for {@link com.ge.aloc.GoveringRuleType#fromId(int)}.
	 */
	@Test
	public final void testFromId() {
		GoveringRuleType actionType = GoveringRuleType.fromId(1);
		assertNotNull(actionType);
		assertEquals("PRACTICE", actionType.name());
		ActionType actionType1 = ActionType.fromId(99);
		assertNull(actionType1);
	}

	/**
	 * Test method for {@link com.ge.aloc.GoveringRuleType#fromName(java.lang.String)}.
	 */
	@Test
	public final void testFromName() {
		GoveringRuleType actionType = GoveringRuleType.fromName("practice");
		assertNotNull(actionType);
		assertEquals("PRACTICE", actionType.name());
		ActionType actionType1 = ActionType.fromName("invalid");
		assertNull(actionType1);
	}

}
