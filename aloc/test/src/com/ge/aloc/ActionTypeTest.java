/**
 * 
 */
package com.ge.aloc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
/**
 * @author madhusudhan.gosula
 *
 */
public class ActionTypeTest {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testFromId() {
		ActionType actionType = ActionType.fromId(1);
		assertNotNull(actionType.getId());
		assertNotNull(actionType.getName());
		assertEquals(1, actionType.getId());
		assertEquals("SAVE", actionType.getName());
		ActionType actionType1 = ActionType.fromId(99);
		assertNull(actionType1);
	}

	@Test
	public final void testFromName() {
		ActionType actionType = ActionType.fromName("SAVE");
		assertNotNull(actionType.getId());
		assertNotNull(actionType.getName());
		assertEquals(1, actionType.getId());
		assertEquals("SAVE", actionType.getName());
		ActionType actionType1 = ActionType.fromName("INVALID");
		assertNull(actionType1);
	}

	@Test
	public final void testGetId() {
		ActionType actionType = ActionType.SAVE;
		assertNotNull(actionType.getId());
		assertEquals(1, actionType.getId());
		
		ActionType actionType1 = ActionType.SUBMIT;
		assertNotNull(actionType1.getId());
		assertEquals(2, actionType1.getId());
		
		ActionType actionType2 = ActionType.APPROVE;
		assertNotNull(actionType2.getId());
		assertEquals(4, actionType2.getId());
		
		ActionType actionType3 = ActionType.REJECT;
		assertNotNull(actionType3.getId());
		assertEquals(5, actionType3.getId());
		
		ActionType actionType4 = ActionType.SAVE_AS_MODEL;
		assertNotNull(actionType4.getId());
		assertEquals(7, actionType4.getId());
	}

	@Test
	public final void testGetName() {
		ActionType actionType = ActionType.SAVE;
		assertNotNull(actionType.getName());
		assertEquals("SAVE", actionType.getName());
		
		ActionType actionType1 = ActionType.SUBMIT;
		assertNotNull(actionType1.getName());
		assertEquals("SUBMIT", actionType1.getName());
		
		ActionType actionType2 = ActionType.APPROVE;
		assertNotNull(actionType2.getName());
		assertEquals("APPROVE", actionType2.getName());
		
		ActionType actionType3 = ActionType.REJECT;
		assertNotNull(actionType3.getName());
		assertEquals("REJECT", actionType3.getName());
		
		ActionType actionType4 = ActionType.SAVE_AS_MODEL;
		assertNotNull(actionType4.getName());
		assertEquals("SAVE", actionType4.getName());
	}

}
