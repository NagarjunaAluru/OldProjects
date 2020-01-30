/**
 * 
 */
package com.ge.aloc.view.section;

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
public class SiteSectionIdTest {

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
	 * Test method for {@link com.ge.aloc.view.section.SiteSectionId#fromString(java.lang.String)}.
	 */
	@Test
	public final void testFromString() {
		SiteSectionId siteSection = SiteSectionId.fromString("site.section.createNewSite");
		assertNotNull(siteSection.name());
		assertEquals("CREATE_NEW_SITE", siteSection.name());
	}

}
