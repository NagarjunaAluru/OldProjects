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
public class AtmtPermTypeTest {

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
	 * Test method for {@link com.ge.aloc.AtmtPermType#fromId(java.lang.String)}.
	 */
	@Test
	public final void testFromId() {
		AtmtPermType atmtPermType = AtmtPermType.fromId("1");
		assertNotNull(atmtPermType.getId());
		assertEquals("1", atmtPermType.getId());
		AtmtPermType atmtPermType1 = AtmtPermType.fromId("99");
		assertNull(atmtPermType1);
	}

	/**
	 * Test method for {@link com.ge.aloc.AtmtPermType#getId()}.
	 */
	@Test
	public final void testGetId() {
		AtmtPermType atmtPermType = AtmtPermType.TREASURY;
		assertNotNull(atmtPermType.getId());
		assertEquals("1", atmtPermType.getId());
	}

}
