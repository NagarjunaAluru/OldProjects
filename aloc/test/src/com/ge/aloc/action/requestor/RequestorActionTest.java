/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: RequestorActionTest.java
 * Purpose: RequestorActionTest used for the all request operations
 */
package com.ge.aloc.action.requestor;

import java.math.BigInteger;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.ALOCContext;
import com.ge.aloc.RequestDetailsData;
import com.ge.aloc.bo.RequestDetailsBO;
import com.ge.aloc.common.AbstractTestCase;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.exception.ALOCAttachmentException;
import com.ge.aloc.exception.ALOCException;
import com.ge.aloc.model.RequestDetails;
import com.ge.aloc.model.SiteSelection;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author rajeswari.guthi
 *
 */
public class RequestorActionTest extends AbstractTestCase {
	private RequestorAction requestorAction;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	/* (non-Javadoc)
	 * @see org.apache.struts2.StrutsTestCase#setUp()
	 */
	@Before
	protected void setUp() throws Exception {
		super.setUp();		
	}

	/* (non-Javadoc)
	 * @see org.apache.struts2.StrutsTestCase#tearDown()
	 */
	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * This method is used to test open request 
	 * Test method for {@link com.ge.aloc.action.requestor.RequestorAction#openRequest()}.
	 */
	public final void testOpenRequest() {
		try {
			 requestorAction = getRequestorAction("openRequest");
			 requestorAction.setRequestId(BigInteger.valueOf(new Long("10226")));
			 setUserContextDetails();			 			
			 requestorAction.openRequest();
		} catch (HWFServiceException e) {
			fail(ALOCConstants.TESTCASE_FIALED_ERROR_MESSAGE + e.getMessage());
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.action.requestor.RequestorAction#openAmendmentRequest()}.
	 */
	@Test
	public void testOpenAmendmentRequest() {
		try {
			 requestorAction = getRequestorAction("openAmendmentRequest");
			 requestorAction.setRequestId(BigInteger.valueOf(new Long("10226")));
			 requestorAction.setInstrumentId(Integer.valueOf(5));
			 setUserContextDetails();			 			
			 requestorAction.openAmendmentRequest();
		} catch (HWFServiceException e) {
			fail(ALOCConstants.TESTCASE_FIALED_ERROR_MESSAGE + e.getMessage());
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.action.requestor.RequestorAction#openRiderRequest()}.
	 */
	@Test
	public void testOpenRiderRequest() {
		try {
			 requestorAction = getRequestorAction("openRiderRequest");
			 requestorAction.setRequestId(BigInteger.valueOf(new Long("10226")));
			 requestorAction.setInstrumentId(Integer.valueOf(6));
			 setUserContextDetails();			 			
			 requestorAction.openAmendmentRequest();
		} catch (HWFServiceException e) {
			fail(ALOCConstants.TESTCASE_FIALED_ERROR_MESSAGE + e.getMessage());
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.action.requestor.RequestorAction#openActiveRequest()}.
	 */
	@Test
	public void testOpenActiveRequest() {
		try {
			 requestorAction = getRequestorAction("openLandingRequest");
			 RequestDetailsData requestDetailsData = new RequestDetailsData();
			 RequestDetails requestDetails = requestDetailsData.getSuretyBondDetails();
			 RequestDetailsBO requestDetailsBO = new RequestDetailsBO(requestDetails);
			 requestorAction.setRequestDetailsBO(requestDetailsBO);
			 setUserContextDetails();			 			
			 requestorAction.openActiveRequest();
		} catch (HWFServiceException e) {
			fail(ALOCConstants.TESTCASE_FIALED_ERROR_MESSAGE + e.getMessage());
		}
		
	}

	/**
	 * Test method for {@link com.ge.aloc.action.requestor.RequestorAction#applySection()}.
	 * @throws ALOCException 
	 * @throws ALOCAttachmentException 
	 */
	@Test
	public void testApplySection() throws ALOCAttachmentException, ALOCException {
		try {
			 requestorAction = getRequestorAction("saveSection");
			 setUserContextDetails();
			 RequestDetailsData requestDetailsData = new RequestDetailsData();
			 RequestDetails requestDetails = requestDetailsData.getSuretyBondDetails();
			 RequestDetailsBO requestDetailsBO = new RequestDetailsBO(requestDetails);
			 requestorAction.setRequestDetailsBO(requestDetailsBO);
			 requestorAction.saveSection();
		} catch (HWFServiceException e) {
			fail(ALOCConstants.TESTCASE_FIALED_ERROR_MESSAGE + e.getMessage());
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.action.requestor.RequestorAction#submit()}.
	 */
	@Test
	public void testSubmit() throws HWFServiceException,ALOCAttachmentException,ALOCException {
		try {
			 requestorAction = getRequestorAction("saveAndContinue");
			 RequestDetailsData requestDetailsData = new RequestDetailsData();
			 RequestDetails requestDetails = requestDetailsData.getDlocDetails();
			 RequestDetailsBO requestDetailsBO = new RequestDetailsBO(requestDetails);
			 ALOCContext.setActiveRequest(requestDetailsBO);
			 requestorAction.setActionType(1);
			 setUserContextDetails();			 			
			 requestorAction.submit();
		} catch (HWFServiceException e) {
			fail(ALOCConstants.TESTCASE_FIALED_ERROR_MESSAGE + e.getMessage());
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.action.requestor.RequestorAction#openModelRequest()}.
	 */
	@Test
	public void testOpenModelRequest() {
		try {
			 requestorAction = getRequestorAction("openModelRequest");
			 request.setParameter(ALOCConstants.MODEL_REQUEST_ID, "10226");
			 setUserContextDetails();			 			
			 requestorAction.openModelRequest();
		} catch (HWFServiceException e) {
			fail(ALOCConstants.TESTCASE_FIALED_ERROR_MESSAGE + e.getMessage());
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.action.requestor.RequestorAction#saveSection()}.
	 */
	@Test
	public void testSaveSection() throws HWFServiceException, ALOCAttachmentException, ALOCException{
		try {
			requestorAction = getRequestorAction("saveSection");
			RequestDetailsData requestDetailsData = new RequestDetailsData();
			RequestDetails requestDetails = requestDetailsData.getBgOrSblcDetails("2");
			RequestDetailsBO requestDetailsBO = new RequestDetailsBO(requestDetails);
			requestorAction.setRequestDetailsBO(requestDetailsBO);
			setUserContextDetails();			 			
			requestorAction.saveSection();
		} catch (HWFServiceException e) {
			fail(ALOCConstants.TESTCASE_FIALED_ERROR_MESSAGE + e.getMessage());
		}
	}


	/**
	 * Test method for {@link com.ge.aloc.action.requestor.RequestorAction#openLandingPage()}.
	 */
	@Test
	public void testOpenLandingPage() {
		requestorAction = getRequestorAction("createNewRequest");
		setUserContextDetails();	
		requestorAction.setInstrumentTypeId("3");
		requestorAction.openLandingPage();
	}

	/**
	 * Test method for {@link com.ge.aloc.action.requestor.RequestorAction#createModelRequest()}.
	 */
	@Test
	public void testCreateModelRequest() {
		try {
			requestorAction = getRequestorAction("createModelRequest");
			RequestDetailsData requestDetailsData = new RequestDetailsData();
			RequestDetails requestDetails = requestDetailsData.getBgOrSblcDetails(String.valueOf(1));
			requestDetails.setRequestId(BigInteger.valueOf(10333));
			requestDetails.setSiteSelection(new SiteSelection());
			requestDetails.setModelId(BigInteger.valueOf(666));
			requestDetails.setModelName("test model");
			RequestDetailsBO requestDetailsBO = new RequestDetailsBO(requestDetails);
			ALOCContext.setActiveRequest(requestDetailsBO);
			requestorAction.setRightSelSites(new ArrayList<String>());
			requestorAction.setRequestId(BigInteger.valueOf(10333));
			setUserContextDetails();
			requestorAction.createModelRequest();
		} catch (HWFServiceException e) {
			fail(ALOCConstants.TESTCASE_FIALED_ERROR_MESSAGE + e.getMessage());
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.action.requestor.RequestorAction#createRequest()}.
	 */
	@Test
	public void testCreateRequest() {
		try {
			 requestorAction = getRequestorAction("createDraftRequest");
			 setUserContextDetails();		
			 requestorAction.setEditMode(true);
			 requestorAction.setSiteId(String.valueOf(1566));
			 
			 RequestDetailsData requestDetailsData = new RequestDetailsData();
			 RequestDetails requestDetails = requestDetailsData.getBgOrSblcDetails(String.valueOf(1));
			 RequestDetailsBO requestDetailsBO = new RequestDetailsBO(requestDetails);
			 ALOCContext.setActiveRequest(requestDetailsBO);
			 
			 requestorAction.createRequest();
		} catch (HWFServiceException e) {
			fail(ALOCConstants.TESTCASE_FIALED_ERROR_MESSAGE + e.getMessage());
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.action.requestor.RequestorAction#openBondInfo()}.
	 */
	@Test
	public void testOpenBondInfo() {
		requestorAction = getRequestorAction("bondInfoController");
		requestorAction.setEditMode(true);
		requestorAction.openBondInfo();
	}

	/**
	 * Test method for {@link com.ge.aloc.action.requestor.RequestorAction#addAdditionalField()}.
	 */
	@Test
	public void testAddAdditionalField() {
		 requestorAction = getRequestorAction("addAdditionalField");
		 requestorAction.addAdditionalField();
	}

	/**
	 * Test method for {@link com.ge.aloc.action.requestor.RequestorAction#removeAdditionalField()}.
	 */
	@Test
	public void testRemoveAdditionalField() {
		requestorAction = getRequestorAction("removeAdditionalField");
		RequestDetailsData requestDetailsData = new RequestDetailsData();
		RequestDetails requestDetails = requestDetailsData.getSuretyBondDetails();
		RequestDetailsBO requestDetailsBO = new RequestDetailsBO(requestDetails);
		ALOCContext.setActiveRequest(requestDetailsBO);
		requestorAction.setSectionName(ALOCConstants.OBLIGEE);
		requestorAction.removeAdditionalField();
	}

	/**
	 * Test method for {@link com.ge.aloc.action.requestor.RequestorAction#removeSuretyAdditionalField(com.ge.aloc.model.RequestDetails)}.
	 */
	@Test
	public void testRemoveSuretyAdditionalField() {
		requestorAction = getRequestorAction("removeAdditionalField");
		RequestDetailsData requestDetailsData = new RequestDetailsData();
		RequestDetails requestDetails = requestDetailsData.getSuretyBondDetails();
		RequestDetailsBO requestDetailsBO = new RequestDetailsBO(requestDetails);
		ALOCContext.setActiveRequest(requestDetailsBO);
		requestorAction.setSectionName(ALOCConstants.PRINCIPAL);
		requestorAction.removeAdditionalField();
	}

	public void setRemoveAddtionalFieldData(){
		requestorAction = getRequestorAction("removeAdditionalField");
		RequestDetailsData requestDetailsData = new RequestDetailsData();
		RequestDetails requestDetails = requestDetailsData.getDlocDetails();
		RequestDetailsBO requestDetailsBO = new RequestDetailsBO(requestDetails);
		ALOCContext.setActiveRequest(requestDetailsBO);
	}
	/**
	 * Test method for {@link com.ge.aloc.action.requestor.RequestorAction#removeDLOCAdditionalField(com.ge.aloc.model.RequestDetails)}.
	 */
	@Test
	public void testRemoveDLOCAdditionalField() {
		setRemoveAddtionalFieldData();
		requestorAction.setSectionName(ALOCConstants.CUSTBENFICIARY);
		requestorAction.removeAdditionalField();
	}

	/**
	 * Test method for {@link com.ge.aloc.action.requestor.RequestorAction#removeApplicantAdditionalField(com.ge.aloc.model.RequestDetails)}.
	 */
	@Test
	public void testRemoveApplicantAdditionalField() {
		setRemoveAddtionalFieldData();
		requestorAction.setSectionName(ALOCConstants.APPLICANT);
		requestorAction.removeAdditionalField();
	}

	/**
	 * Test method for {@link com.ge.aloc.action.requestor.RequestorAction#removeCustBenAdditionalField(com.ge.aloc.model.RequestDetails)}.
	 */
	@Test
	public void testRemoveCustBenAdditionalField() {
		setRemoveAddtionalFieldData();
		requestorAction.setSectionName(ALOCConstants.CUSTBENFICIARY);
		requestorAction.removeAdditionalField();
	}

	/**
	 * Test method for {@link com.ge.aloc.action.requestor.RequestorAction#removeShipmentAdditionalField(com.ge.aloc.model.RequestDetails)}.
	 */
	@Test
	public void testRemoveShipmentAdditionalField() {
		setRemoveAddtionalFieldData();
		requestorAction.setSectionName(ALOCConstants.SHIPMENTCOUNTRY);
		requestorAction.removeAdditionalField();
	}

	/**
	 * Test method for {@link com.ge.aloc.action.requestor.RequestorAction#removeOriginAdditionalField(com.ge.aloc.model.RequestDetails)}.
	 */
	@Test
	public void testRemoveOriginAdditionalField() {
		setRemoveAddtionalFieldData();
		requestorAction.setSectionName(ALOCConstants.ORIGINGOODS);
		requestorAction.removeAdditionalField();
	}

	/**
	 * Test method for {@link com.ge.aloc.action.requestor.RequestorAction#removeBupAdditionalField(com.ge.aloc.model.RequestDetails)}.
	 */
	@Test
	public void testRemoveBupAdditionalField() {
		setRemoveAddtionalFieldData();
		requestorAction.setSectionName(ALOCConstants.BUCONTACTPERSON);
		requestorAction.removeAdditionalField();
	}

	/**
	 * Test method for {@link com.ge.aloc.action.requestor.RequestorAction#removeBgSblcAdditionalField(com.ge.aloc.model.RequestDetails)}.
	 */
	@Test
	public void testRemoveBgSblcAdditionalField() {
		requestorAction = getRequestorAction("removeAdditionalField");
		RequestDetailsData requestDetailsData = new RequestDetailsData();
		RequestDetails requestDetails = requestDetailsData.getBgOrSblcDetails(String.valueOf(2));
		RequestDetailsBO requestDetailsBO = new RequestDetailsBO(requestDetails);
		ALOCContext.setActiveRequest(requestDetailsBO);
		requestorAction.setSectionName(ALOCConstants.TPAPPLICANT);
		requestorAction.removeAdditionalField();
	}

	/**
	 * Test method for {@link com.ge.aloc.action.requestor.RequestorAction#displayModelRequest()}.
	 */
	@Test
	public void testDisplayModelRequest() {
		try {
			requestorAction = getRequestorAction("displayModelRequest");
			request.setParameter(ALOCConstants.MODEL_REQUEST_ID, "10226");
			setUserContextDetails();
			requestorAction.displayModelRequest();
		} catch (HWFServiceException e) {
			fail(ALOCConstants.TESTCASE_FIALED_ERROR_MESSAGE + e.getMessage());
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.action.requestor.RequestorAction#saveModel()}.
	 */
	@Test
	public void testSaveModel() {
		try {
			requestorAction = getRequestorAction("saveModel");
			RequestDetailsData requestDetailsData = new RequestDetailsData();
			RequestDetails requestDetails = requestDetailsData.getBgOrSblcDetails(String.valueOf(1));
			requestDetails.setRequestId(BigInteger.valueOf(10333));
			requestDetails.setSiteSelection(new SiteSelection());
			requestDetails.setModelName("test model");
			RequestDetailsBO requestDetailsBO = new RequestDetailsBO(requestDetails);
			ALOCContext.setActiveRequest(requestDetailsBO);
			requestorAction.setRightSelSites(new ArrayList<String>());
			setUserContextDetails();
			requestorAction.saveModel();
		} catch (HWFServiceException e) {
			fail(ALOCConstants.TESTCASE_FIALED_ERROR_MESSAGE + e.getMessage());
		}
	}
}
