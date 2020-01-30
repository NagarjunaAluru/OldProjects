/**
 * 
 */
package com.ge.aloc.ext.eas.service.client;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author chaitanya.n
 *
 */
public class EASOTPTest {
	
	public static final String STR_WSDL_LOCATION = "https://autheservice-nxgen.stage.us.money.ge.com:8443/EnhancedAuthenticationService/services/B2EService?wsdl";
	private static B2EService SERVICE;
	private static String otp;
	
	private B2ERequest request;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		SERVICE = EASTest.createService();
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
		request = EASTest.createRequest();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		request = null;
	}

	@Test 
	public void generateOTP() {
		request.getUserAttributes().setUserName("jjacob99");
		request.setUseOtp(Boolean.TRUE.toString());
		B2EResponse response = SERVICE.challenge(request);
		
		Assert.assertEquals("SUCCESS", response.getResult());
		otp = response.getChallengeQuestionText();
		System.out.println("OTP: " + otp);
		Assert.assertNotNull(otp);
	}

	@Test
	public void validateOTP() {
		request.getUserAttributes().setUserName("jjacob99");
		request.setUseOtp(Boolean.TRUE.toString());
		request.setChallengeAnswer(otp);
		B2EResponse response = SERVICE.challengeAnswer(request);
		Assert.assertEquals("SUCCESS", response.getResult());
		Assert.assertEquals(Integer.valueOf(0), response.getChallengeAnswerScore());
	}
}
