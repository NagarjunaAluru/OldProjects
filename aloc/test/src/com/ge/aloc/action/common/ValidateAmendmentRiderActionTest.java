/**
 * 
 */
package com.ge.aloc.action.common;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.common.AbstractTestCase;
import com.ge.aloc.constants.ALOCConstants;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author arijit.biswas
 *
 */
public class ValidateAmendmentRiderActionTest extends AbstractTestCase{

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
	 * Test method for {@link com.ge.aloc.action.common.ValidateAmendmentRiderAction#execute()}.
	 */
	@Test
	public void testExecute() {
		ValidateAmendmentRiderAction validateAmendmentRiderAction;
		request.setParameter(ALOCConstants.AMENDRIDEROPTION, "alocRecNo");
		request.setParameter(ALOCConstants.AMENDRIDERVALUE, "7409");
		validateAmendmentRiderAction = getValidateAmendmentRiderAction("validateAmendmentRider");
		assertNotNull(validateAmendmentRiderAction);
		try {
			String result = validateAmendmentRiderAction.execute();
			assertNull(result);
			assertEquals("success",result);
		} catch (IOException e) {
			fail("Error while validating before create amendment and rider");
		}
	}

}
