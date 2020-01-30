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
public class AddressTypeTest {

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
	 * Test method for {@link com.ge.aloc.AddressType#fromId(int)}.
	 */
	@Test
	public final void testFromId() {
		AddressType addressType = AddressType.fromId(1);
		assertNotNull(addressType.getId());
		assertNotNull(addressType.getName());
		assertEquals(1, addressType.getId());
		assertEquals("Applicant", addressType.getName());
		AddressType addressType1 = AddressType.fromId(99);
		assertNull(addressType1);
	}

	/**
	 * Test method for {@link com.ge.aloc.AddressType#fromName(java.lang.String)}.
	 */
	@Test
	public final void testFromName() {
		AddressType addressType = AddressType.fromName("Applicant");
		assertNotNull(addressType.getId());
		assertNotNull(addressType.getName());
		assertEquals(1, addressType.getId());
		assertEquals("Applicant", addressType.getName());
		AddressType addressType1 = AddressType.fromName("INVALID");
		assertNull(addressType1);
	}

	/**
	 * Test method for {@link com.ge.aloc.AddressType#getName()}.
	 */
	@Test
	public final void testGetName() {
		AddressType addressType = AddressType.APPLICANT;
		assertNotNull(addressType.getId());
		assertEquals(1, addressType.getId());
	}

	/**
	 * Test method for {@link com.ge.aloc.AddressType#getId()}.
	 */
	@Test
	public final void testGetId() {
		AddressType addressType = AddressType.APPLICANT;
		assertNotNull(addressType.getName());
		assertEquals("Applicant", addressType.getName());
	}

}
