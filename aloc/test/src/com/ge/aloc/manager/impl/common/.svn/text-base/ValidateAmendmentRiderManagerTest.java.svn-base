/**
 * 
 */
package com.ge.aloc.manager.impl.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.dao.impl.DAOConnectionHelper;
import com.ge.aloc.dao.impl.common.ValidateAmendmentRiderDAO;
import com.ge.aloc.model.RequestStatusDetails;
import com.hydus.hwf.bw.service.IServiceClient;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author arijit.biswas
 *
 */
public class ValidateAmendmentRiderManagerTest {

	private static IServiceClient serviceClient;
	private static ValidateAmendmentRiderDAO validateAmendmentRiderDAO;
	private static ValidateAmendmentRiderManager validateAmendmentRiderManager;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		serviceClient = DAOConnectionHelper.getServiceClient();	
		validateAmendmentRiderManager = new ValidateAmendmentRiderManager();
		validateAmendmentRiderDAO = new ValidateAmendmentRiderDAO();
		validateAmendmentRiderDAO.setServiceClient(serviceClient);
		validateAmendmentRiderManager.setValidateAmendmentRiderDAO(validateAmendmentRiderDAO);
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
	 * Test method for {@link com.ge.aloc.manager.impl.common.ValidateAmendmentRiderManager#validate(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testValidate() {
		String amendRiderOption = "alocRecNo";
		String amendRiderValue = "7409";
		try {
			RequestStatusDetails requestStatusDetails = validateAmendmentRiderManager.validate(amendRiderOption, amendRiderValue);
			assertNotNull(requestStatusDetails);
		} catch (HWFServiceException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());
		}
	}

}
