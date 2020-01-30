/**
 * 
 */
package com.ge.aloc.ext.eas.service.client;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.xml.namespace.QName;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author chaitanya.n
 *
 */
public class EASTest {
	private static final Logger LOGGER = Logger.getLogger(EASTest.class);
	
	public static final String STR_WSDL_LOCATION = "https://autheservice-nxgen.stage.us.money.ge.com:8443/EnhancedAuthenticationService/services/B2EService?wsdl";
	private static final ObjectFactory OBJ_FACTORY = new ObjectFactory();
	
	private static final String ORG_ID = "ALOC";
	private static final String APPLICATION_ID = "ID_ALOC";
	private static final String APPLICATION_PASSWORD = "test123test.";
	private static final String OPERATION = "SSO";
	
	
	private static B2EService SERVICE;
	
	private B2ERequest request;
	
	/**
	 * @throws java.lang.Exception
	 */
	public static B2EService createService() throws Exception {
		QName serviceName = new QName("http://com.ge.b2ewebservice/B2EService/", "B2EService");
		
		URL url = null;
        try {
        	url = new URL(STR_WSDL_LOCATION);
        } catch (MalformedURLException e) {
        	LOGGER.warn("Failed to create URL for the wsdl Location: 'file:/D:/Hydus/Development/ALOC/Workspace/maven.1368442936316/aloc/wsdl/EAS.wsdl', retrying as a local file", e);
        }
        //B2EService service = new B2EService_Service(url, serviceName).getB2EServiceSOAP();
        //return service;
        return null;
	}
	
	/**
	 * 
	 * @return
	 */
	public static B2ERequest createRequest() {
		B2ERequest request = new B2ERequest();
		request.setApplicationID(APPLICATION_ID);
		request.setApplicationPassword(APPLICATION_PASSWORD);
		request.setOperation(OPERATION);
		UserAttributes userAttributes = OBJ_FACTORY.createUserAttributes();
		userAttributes.setOrgId(ORG_ID);
		request.setUserAttributes(userAttributes);
		return request;
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		SERVICE = createService();
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
		request = createRequest();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		request = null;
	}

	@Test
	public void serviceCreated() {
		assertNotNull(SERVICE);
	}
	
	//@Test
		public void addUser() {
			UserAttributes userAttributes = request.getUserAttributes();
			userAttributes.setGivenName("Chaitanya");
			userAttributes.setMail("chaitanya.narvaneni@hydus.com");
			userAttributes.setSelfReg("true");
			userAttributes.setSurname("Narvaneni");
			userAttributes.setUserName("chaitanya.n");
			userAttributes.setPassword("test123$");
			//userAttributes.setSsoStatus("U");
			//userAttributes.setUserLanguage("English");
			//userAttributes.setUserCountry("India");
			B2EResponse response = SERVICE.addUser(request);
			assertNotNull(response);
			assertEquals("SUCCESS", response.getResult());
			assertNotNull(response.getUserAttributes().getGessouid());
		}
	
	@Test
	public void getUserInfo() {
		//DeviceRequest deviceRequest = new DeviceRequest();
		//request.setDeviceRequest(deviceRequest);
		//request.setBindDevice("false");
		
		request.getUserAttributes().setUserName("madhusudhan.g");
		B2EResponse response = SERVICE.getUserInfo(request);
		assertNotNull(response);
	}
	
	//@Test
		public void updatePassword() {
			UserAttributes userAttributes = request.getUserAttributes();
			userAttributes.setUserName("madhusudhan.g");
			userAttributes.setPassword("test$123");
			B2EResponse response = SERVICE.updatePassword(request);
			assertNotNull(response);
			assertEquals("SUCCESS", response.getResult());
		}
		
		//@Test
		public void generateOneTimePassword() {
			request.getUserAttributes().setUserName("madhusudhan.g");
			request.setUseOtp("true");
			B2EResponse response = SERVICE.challenge(request);
			assertNotNull(response);
			assertEquals("SUCCESS", response.getResult());
			assertNotNull(response.getChallengeQuestionText());
		}
		
		//@Test
		public void challengeAnswer() {
			request.getUserAttributes().setUserName("madhusudhan.g");
			request.setUseOtp("true");
			request.setChallengeAnswer("H226fh");
			B2EResponse response = SERVICE.challengeAnswer(request);
			assertNotNull(response);
			assertEquals("SUCCESS", response.getResult());
			assertNotNull(response.getChallengeAnswerScore());
			assertEquals(true, response.getChallengeAnswerScore().intValue() < 100);
		}
		
		//@Test
		public void forgotUserID() {
			request.getUserAttributes().setMail("madhusudhan.gosula@hydus.com");
			B2EResponse response = SERVICE.forgotUserID(request);
			assertNotNull(response);
			assertEquals("SUCCESS", response.getResult());
			assertNotNull(response.getUserIDMatches());
			List<UIDMatch> matchedUIDs = response.getUserIDMatches().getItem();
			assertEquals(true, !matchedUIDs.isEmpty());
		}
		
		//@Test
		public void signin() {
			request.getUserAttributes().setUserName("madhusudhan.g");
			B2EResponse response = SERVICE.signin(request);
			assertNotNull(response);
			assertEquals("SUCCESS", response.getResult());
		}
		
		//@Test
		public void challengeAnwser() {
			request.getUserAttributes().setUserName("madhusudhan.g");
			request.setUseOtp("false");
			request.setChallengeAnswerId("Q1.1");
			request.setChallengeAnswer("Khammam");
			B2EResponse response = SERVICE.challengeAnswer(request);
			assertNotNull(response);
			assertEquals("SUCCESS", response.getResult());
			assertNotNull(response.getChallengeAnswerScore());
		}
}
