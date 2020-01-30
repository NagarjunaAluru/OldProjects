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
public class SiteTypeTest {

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
	 * Test method for {@link com.ge.aloc.SiteType#fromId(int)}.
	 */
	@Test
	public final void testFromId() {
		SiteType actionType = SiteType.fromId(1);
		assertNotNull(actionType.getId());
		assertNotNull(actionType.getName());
		assertEquals(1, actionType.getId());
		assertEquals("Industrail Business Site", actionType.getName());
		SiteType actionType1 = SiteType.fromId(99);
		assertNull(actionType1);
	}

	/**
	 * Test method for {@link com.ge.aloc.SiteType#getName()}.
	 */
	@Test
	public final void testGetName() {
		SiteType actionType = SiteType.INDUSTRAIL_BUSINESS_SITE;
		assertNotNull(actionType.getName());
		assertEquals("Industrail Business Site", actionType.getName());
	}

	/**
	 * Test method for {@link com.ge.aloc.SiteType#getId()}.
	 */
	@Test
	public final void testGetId() {
		SiteType actionType = SiteType.FINANCIAL_BUSINESS_SITE;
		assertNotNull(actionType.getId());
		assertEquals(2, actionType.getId());
	}

}
