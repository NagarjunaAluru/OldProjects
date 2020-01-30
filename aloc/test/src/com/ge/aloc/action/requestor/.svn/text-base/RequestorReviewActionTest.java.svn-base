/**
 * 
 */
package com.ge.aloc.action.requestor;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.RequestDetailsData;
import com.ge.aloc.bo.RequestDetailsBO;
import com.ge.aloc.common.AbstractTestCase;
import com.ge.aloc.model.RequestDetails;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author madhusudhan.gosula
 *
 */
public class RequestorReviewActionTest extends AbstractTestCase{

	private RequestorReviewAction requestorReviewAction;
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
	 * Test method for {@link com.ge.aloc.action.requestor.RequestorReviewAction#submit()}.
	 */
	@Test
	public final void testSubmit() {
		RequestorReviewAction requestorReviewAction=null;
		try {
			
			requestorReviewAction = requestorReviewAction("submit");
			RequestDetailsData requestDetailsData = new RequestDetailsData();
			RequestDetails requestDetails = requestDetailsData.getSuretyBondDetails();
			RequestDetailsBO requestDetailsBO = new RequestDetailsBO(requestDetails);
			requestorReviewAction.setRequestDetailsBO(requestDetailsBO);
			requestorReviewAction.setActionType(1);
			String resultPage=requestorReviewAction.submit();
			assertNotNull(resultPage);
		} catch (HWFServiceException e) {
			fail("Error while review the request");
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.action.requestor.RequestorReviewAction#getActionType()}.
	 */
	@Test
	public final void testGetActionType() {
		requestorReviewAction.setActionType(1);
		assertNotNull(requestorReviewAction.getActionType());
		assertEquals(1,requestorReviewAction.getActionType());
	}
	
	/**
	 * Test method for {@link com.ge.aloc.action.requestor.RequestorReviewAction#submit()}.
	 */
	@Test
	public final void testSubmitRider() {
		try {
			requestorReviewAction.setActionType(1);
			requestorReviewAction.submitRider();
		} catch (HWFServiceException e) {
			fail("Error while review the request");
		}
	}
}
