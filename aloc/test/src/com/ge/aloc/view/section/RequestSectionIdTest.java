/**
 * 
 */
package com.ge.aloc.view.section;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author madhusudhan.gosula
 *
 */
public class RequestSectionIdTest {

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
	 * Test method for {@link com.ge.aloc.view.section.RequestSectionId#fromString(java.lang.String)}.
	 */
	@Test
	public final void testFromString() {
		RequestSectionId requestSection = RequestSectionId.fromString("request.section.projectDescription");
		assertNotNull(requestSection.name());
		assertEquals("PROJECT_DESCRIPTION", requestSection.name());
	}

}
