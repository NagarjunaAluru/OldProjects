/**
 * 
 */
package com.ge.aloc.bo;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author madhusudhan.gosula
 *
 */
public class TimeBOTest {

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
	 * Test method for {@link com.ge.aloc.bo.TimeBO#TimeBO()}.
	 */
	@Test
	public final void testTimeBO() {
		TimeBO timeBO = new TimeBO(new GregorianCalendar());
		timeBO.setHours(11);
		timeBO.setMinutes(23);
		timeBO.setPeriod("AM");
		assertEquals("Hours are not matching", 11, timeBO.getHours().intValue());
		assertEquals("Minutes are not matching", 23, timeBO.getMinutes().intValue());
		assertEquals("Period is not matching", "AM", timeBO.getPeriod());
	}
	
	@Test
	public void testTimeBONull()
	{
		
		TimeBO timeBO = new TimeBO(new GregorianCalendar());
		assertNull("Hours is not null", timeBO.getHours());
		assertNull("Minutes is not null", timeBO.getMinutes());
		assertNull("Period is not null", timeBO.getPeriod());
	}

}
