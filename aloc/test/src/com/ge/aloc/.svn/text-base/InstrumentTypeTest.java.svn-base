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
public class InstrumentTypeTest {

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
	 * Test method for {@link com.ge.aloc.InstrumentType#fromId(int)}.
	 */
	@Test
	public final void testFromId() {
		InstrumentType actionType = InstrumentType.fromId(1);
		assertNotNull(actionType.getId());
		assertNotNull(actionType.getName());
		assertEquals(1, actionType.getId());
		assertEquals("Bank Guarantee", actionType.getName());
		InstrumentType actionType1 = InstrumentType.fromId(99);
		assertNull(actionType1);
	}

	/**
	 * Test method for {@link com.ge.aloc.InstrumentType#getName()}.
	 */
	@Test
	public final void testGetName() {
		InstrumentType actionType = InstrumentType.BANK_GUARANTEE;
		assertNotNull(actionType.getName());
		assertEquals("Bank Guarantee", actionType.getName());
	}

	/**
	 * Test method for {@link com.ge.aloc.InstrumentType#getId()}.
	 */
	@Test
	public final void testGetId() {
		InstrumentType actionType = InstrumentType.BANK_GUARANTEE;
		assertNotNull(actionType.getId());
		assertEquals(1, actionType.getId());
	}

}
