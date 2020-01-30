package com.ge.aloc.bo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.model.IndicativePricingCompletedDetails;

public class IndicativePricingCompletedDetailsBOTest
{
	
	private static IndicativePricingCompletedDetailsBO replyDetailsBO;
	private static IndicativePricingCompletedDetailsBO replyDetailsBO2;
	private static Calendar pricingExpirationTime;
	
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		replyDetailsBO  = new IndicativePricingCompletedDetailsBO();
		IndicativePricingCompletedDetails replyDetails = new IndicativePricingCompletedDetails();
		pricingExpirationTime = new GregorianCalendar(2014, Calendar.FEBRUARY, 5, 11,50);
		replyDetails.setPricingExpirationDateTime(pricingExpirationTime);
		replyDetailsBO2 = new IndicativePricingCompletedDetailsBO(replyDetails);
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
	
	
	@Test
	public final void testIndicativePricingCompletedDetailsBO(){
		IndicativePricingCompletedDetails details = replyDetailsBO.getModel();
		assertNotNull("IndicativePricingCompletedDetails is null",details);
	}
	
	
	
	@Test
	public final void testIndicativePricingCompletedDetailsBOIndicativePricingCompletedDetails(){
		IndicativePricingCompletedDetails details = replyDetailsBO2.getModel();
		assertNotNull("IndicativePricingCompletedDetails is null",details);
	}
	
	
	@Test
	public final void testgetPricingExpirationTime(){
		TimeBO timeBO = replyDetailsBO2.getPricingExpirationTime();
		timeBO.setHours(3);
		timeBO.setMinutes(34);
		timeBO.setPeriod("PM");
		Calendar calendarActual = replyDetailsBO2.getModel().getPricingExpirationDateTime();
		assertEquals("Hours are not matching", timeBO.getHours().intValue(), calendarActual.get(Calendar.HOUR));
		assertEquals("Minutes are not matching", timeBO.getMinutes().intValue(), calendarActual.get(Calendar.MINUTE));
		assertEquals("Period is not matching", 1, calendarActual.get(Calendar.AM_PM));
		
		pricingExpirationTime.set(Calendar.HOUR,3);
		pricingExpirationTime.set(Calendar.MINUTE,34);
		pricingExpirationTime.set(Calendar.AM_PM,Calendar.PM);
		
		Calendar actualPricingExpirationDateTime= replyDetailsBO2.getModel().getPricingExpirationDateTime();
		assertEquals("Pricing expiration time not matching",pricingExpirationTime,actualPricingExpirationDateTime);
	
       }

}
