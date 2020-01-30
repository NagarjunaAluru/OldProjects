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

import com.ge.aloc.model.BidReplyDetails;

/**
 * @author madhusudhan.gosula
 *
 */
public class BidReplyDetailsBOTest {

	private static BidReplyDetailsBO replyDetailsBO;
	private static BidReplyDetailsBO replyDetailsBO2;
	private static Calendar dateTime;
	private static Calendar bidExpirationDateTime;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		replyDetailsBO  = new BidReplyDetailsBO();
		BidReplyDetails replyDetails = new BidReplyDetails();
		dateTime = new GregorianCalendar(2013, Calendar.FEBRUARY, 5, 11,50);
		bidExpirationDateTime = new GregorianCalendar(2014, Calendar.FEBRUARY, 5, 11,50);
		replyDetails.setPricingExpirationDate(dateTime);
		replyDetails.setBidExpirationDate(bidExpirationDateTime);
		replyDetailsBO2 = new BidReplyDetailsBO(replyDetails);
		
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
	 * Test method for {@link com.ge.aloc.bo.BidReplyDetailsBO#BidReplyDetailsBO(com.ge.aloc.model.BidReplyDetails)}.
	 */
	@Test
	public final void testBidReplyDetailsBOBidReplyDetails() {
		BidReplyDetails details =  replyDetailsBO2.getModel();
		assertNotNull("BidReplyDetails model is null",details);
	}

	/**
	 * Test method for {@link com.ge.aloc.bo.BidReplyDetailsBO#BidReplyDetailsBO()}.
	 */
	@Test
	public final void testBidReplyDetailsBO() {
		BidReplyDetails details =  replyDetailsBO.getModel();
		assertNotNull("BidReplyDetails model is null",details);

	}

	/**
	 * Test method for {@link com.ge.aloc.bo.BidReplyDetailsBO#getPricingExpirationTime()}.
	 */
	@Test
	public final void testGetPricingExpirationTime() {
		String expectedTime = DateFormat.getTimeInstance(DateFormat.SHORT).format(dateTime.getTime());
		String actualTime = replyDetailsBO2.getPricingExpirationTime();
		assertEquals("Times are not matching ",expectedTime, actualTime);
	}

	/**
	 * Test method for {@link com.ge.aloc.bo.BidReplyDetailsBO#getBidExpirationTime()}.
	 */
	@Test
	public final void testGetBidExpirationTime() {
		TimeBO timeBO = replyDetailsBO2.getBidExpirationTime();
		timeBO.setHours(2);
		timeBO.setMinutes(34);
		timeBO.setPeriod("PM");
		Calendar calendarActual = replyDetailsBO2.getModel().getBidExpirationDate();
		assertEquals("Hours are not matching", timeBO.getHours().intValue(), calendarActual.get(Calendar.HOUR));
		assertEquals("Minutes are not matching", timeBO.getMinutes().intValue(), calendarActual.get(Calendar.MINUTE));
		assertEquals("Period is not matching", 1, calendarActual.get(Calendar.AM_PM));
		bidExpirationDateTime.set(Calendar.HOUR, 2);
		bidExpirationDateTime.set(Calendar.MINUTE,34);
		bidExpirationDateTime.set(Calendar.AM_PM,Calendar.PM);
		
		Calendar actualBidExpirationDateTime= replyDetailsBO2.getModel().getBidExpirationDate();
		assertEquals("Bid expiration dates are not matching",bidExpirationDateTime, actualBidExpirationDateTime);
		
	}

}
