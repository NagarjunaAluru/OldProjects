/**
 * 
 */
package com.ge.aloc.dao.impl.common;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.dao.impl.DAOConnectionHelper;
import com.ge.aloc.model.GetAmendmentRiders;
import com.ge.aloc.model.RequestStatusDetails;
import com.hydus.hwf.bw.service.IServiceClient;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author arijit.biswas
 *
 */
public class ValidateAmendmentRiderDAOTest {

	private static IServiceClient serviceClient;
	private static ValidateAmendmentRiderDAO validateAmendmentRiderDAO;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		serviceClient = DAOConnectionHelper.getServiceClient();
		validateAmendmentRiderDAO = new ValidateAmendmentRiderDAO();
		validateAmendmentRiderDAO.setServiceClient(serviceClient);
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
	 * Test method for {@link com.ge.aloc.dao.impl.common.ValidateAmendmentRiderDAO#validate(com.ge.aloc.model.GetAmendmentRiders)}.
	 */
	@Test
	public void testValidate() {
		GetAmendmentRiders getAmendmentRiders = new GetAmendmentRiders();
		RequestStatusDetails requestStatusDetails = new RequestStatusDetails();
		requestStatusDetails.setALOCRecordNumber(new BigInteger("7409"));
		getAmendmentRiders.setRequestStatusDetails(requestStatusDetails);
		try {
			getAmendmentRiders = validateAmendmentRiderDAO.validate(getAmendmentRiders);
			assertNotNull(getAmendmentRiders);
		} catch (HWFServiceException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());
		}
	}

}
