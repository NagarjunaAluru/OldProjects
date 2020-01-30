/**
 * 
 */
package com.ge.aloc.bo;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import com.ge.aloc.model.BidmemoDetails;

/**
 * @author madhusudhan.gosula
 *
 */
public class BidMemoDetailsBOTest {

	private static BidMemoDetailsBO bidMemoDetailsBO;
	private static BidMemoDetailsBO bidMemoDetailsBO2;
	private static Calendar dateTime;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		bidMemoDetailsBO = new BidMemoDetailsBO();
		dateTime = new GregorianCalendar(2013, Calendar.FEBRUARY, 5, 11,50);
		BidmemoDetails memoDetails = new BidmemoDetails();
		memoDetails.setExpirationDateTime(dateTime);		
		bidMemoDetailsBO2 = new BidMemoDetailsBO(memoDetails);
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
	 * Test method for {@link com.ge.aloc.bo.BidMemoDetailsBO#BidMemoDetailsBO(com.ge.aloc.model.BidmemoDetails)}.
	 */
	@Test
	public final void testBidMemoDetailsBOBidmemoDetails() {
		BidmemoDetails details =  bidMemoDetailsBO2.getModel();
		assertNotNull("BidReplyDetails model is null",details);
	}

	/**
	 * Test method for {@link com.ge.aloc.bo.BidMemoDetailsBO#BidMemoDetailsBO()}.
	 */
	@Test
	public final void testBidMemoDetailsBO() {
		BidmemoDetails details =  bidMemoDetailsBO.getModel();
		assertNotNull("BidReplyDetails model is null",details);
	}

	/**
	 * Test method for {@link com.ge.aloc.bo.BidMemoDetailsBO#getExpirationTime()}.
	 */
	@Test
	public final void testGetExpirationTime() {
		String expectedTime = DateFormat.getTimeInstance(DateFormat.SHORT).format(dateTime.getTime());
		String actualTime = bidMemoDetailsBO2.getExpirationTime();
		assertEquals("Times are not matching ",expectedTime, actualTime);
	}

}
