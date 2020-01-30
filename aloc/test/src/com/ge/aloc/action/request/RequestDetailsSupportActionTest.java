/**
 * 
 */
package com.ge.aloc.action.request;

import java.math.BigInteger;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.action.approver.RequestApproverAction;
import com.ge.aloc.bo.RequestDetailsBO;
import com.ge.aloc.common.AbstractTestCase;
import com.ge.aloc.model.RequestDetails;
import com.ge.aloc.model.TpApplicantDetails;
import com.ge.aloc.model.TpBuContactPerson;

/**
 * @author narasimhulu.b
 *
 */
public class RequestDetailsSupportActionTest extends AbstractTestCase{

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
	 * Test method for {@link com.ge.aloc.action.request.RequestDetailsSupportAction#openRequest()}.
	 */
	@Test
	public void testOpenRequest() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.ge.aloc.action.request.RequestDetailsSupportAction#openAmendmentRequest()}.
	 */
	@Test
	public void testOpenAmendmentRequest() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.ge.aloc.action.request.RequestDetailsSupportAction#openRiderRequest()}.
	 */
	@Test
	public void testOpenRiderRequest() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.ge.aloc.action.request.RequestDetailsSupportAction#openActiveRequest()}.
	 */
	@Test
	public void testOpenActiveRequest() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.ge.aloc.action.request.RequestDetailsSupportAction#editSection()}.
	 */
	@Test
	public void testEditSection() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.ge.aloc.action.request.RequestDetailsSupportAction#applySection()}.
	 */
	@Test
	public void testApplySection() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.ge.aloc.action.request.RequestDetailsSupportAction#trackSection()}.
	 */
	@Test
	public void testTrackSection() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.ge.aloc.action.request.RequestDetailsSupportAction#cancelSection()}.
	 */
	@Test
	public void testCancelSection() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.ge.aloc.action.request.RequestDetailsSupportAction#save()}.
	 */
	@Test
	public void testSave() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.ge.aloc.action.request.RequestDetailsSupportAction#saveAmendment()}.
	 */
	@Test
	public void testSaveAmendment() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.ge.aloc.action.request.RequestDetailsSupportAction#saveRider()}.
	 */
	@Test
	public void testSaveRider() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.ge.aloc.action.request.RequestDetailsSupportAction#cancel()}.
	 */
	@Test
	public void testCancel() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.ge.aloc.action.request.RequestDetailsSupportAction#cancelAll()}.
	 */
	@Test
	public void testCancelAll() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.ge.aloc.action.request.RequestDetailsSupportAction#updateworkflowData(com.ge.aloc.bo.RequestDetailsBO)}.
	 */
	@Test
	public void testUpdateworkflowData() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.ge.aloc.action.request.RequestDetailsSupportAction#downloadAttachment()}.
	 */
	@Test
	public void testDownloadAttachment() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.ge.aloc.action.request.RequestDetailsSupportAction#downloadAllAttachmentsAsZip()}.
	 */
	@Test
	public void testDownloadAllAttachmentsAsZip() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.ge.aloc.action.request.RequestDetailsSupportAction#downloadFormatData()}.
	 */
	@Test
	public void testDownloadFormatData() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.ge.aloc.action.request.RequestDetailsSupportAction#submit()}.
	 */
	@Test
	public void testSubmit() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.ge.aloc.action.request.RequestDetailsSupportAction#getInputResultName()}.
	 */
	@Test
	public void testGetInputResultName() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.ge.aloc.action.request.RequestDetailsSupportAction#getRequestResultPage()}.
	 */
	@Test
	public void testGetRequestResultPage() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.ge.aloc.action.request.RequestDetailsSupportAction#getSectionResultPage()}.
	 */
	@Test
	public void testGetSectionResultPage() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.ge.aloc.action.request.RequestDetailsSupportAction#isRequestForValidateSection()}.
	 */
	@Test
	public void testIsRequestForValidateSection() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.ge.aloc.action.request.RequestDetailsSupportAction#getAmendments()}.
	 */
	@Test
	public void testGetAmendments() {
		RequestDetails requestDetails = null;
		try {
			setUserContextDetails();
			requestDetails = openRequest(7049);
			assertNotNull(requestDetails);
			RequestApproverAction approverAction = getApproverAction("AmendmentsTaxonomy", requestDetails);
			assertNotNull(approverAction);
			approverAction.setRequestId(new BigInteger("7049"));
			String result = approverAction.getAmendments();
			assertNotNull(result);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Test case failed with error message : "+ e.getMessage());
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.action.request.RequestDetailsSupportAction#getRiders()}.
	 */
	@Test
	public void testGetRiders() {
		RequestDetails requestDetails = null;
		try {
			setUserContextDetails();
			requestDetails = openRequest(7203);
			assertNotNull(requestDetails);
			RequestApproverAction approverAction = getApproverAction("RidersTaxonomy", requestDetails);
			assertNotNull(approverAction);
			approverAction.setRequestId(new BigInteger("7203"));
			String result = approverAction.getRiders();
			assertNotNull(result);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Test case failed with error message : "+ e.getMessage());
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.action.request.RequestDetailsSupportAction#getLinkTansactions()}.
	 */
	@Test
	public void testGetLinkTansactions() {
		RequestDetails requestDetails = null;
		try {
			setUserContextDetails();
			requestDetails = openRequest(7049);
			assertNotNull(requestDetails);
			RequestApproverAction approverAction = getApproverAction("LinkTansactionsTaxonomy", requestDetails);
			assertNotNull(approverAction);
			approverAction.setRequestId(new BigInteger("7049"));
			String result = approverAction.getLinkTansactions();
			assertNotNull(result);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Test case failed with error message : "+ e.getMessage());
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.action.request.RequestDetailsSupportAction#getBundleTansactions()}.
	 */
	@Test
	public void testGetBundleTansactions() {
		RequestDetails requestDetails = null;
		try {
			setUserContextDetails();
			requestDetails = openRequest(7049);
			assertNotNull(requestDetails);
			RequestApproverAction approverAction = getApproverAction("BundleTansactionsTaxonomy", requestDetails);
			assertNotNull(approverAction);
			approverAction.setRequestId(new BigInteger("7049"));
			String result = approverAction.getBundleTansactions();
			assertNotNull(result);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Test case failed with error message : "+ e.getMessage());
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.action.request.RequestDetailsSupportAction#getFeeHistory()}.
	 */
	@Test
	public void testGetFeeHistory() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.ge.aloc.action.request.RequestDetailsSupportAction#getCompBidReplies()}.
	 */
	@Test
	public void testGetCompBidReplies() {
		RequestDetails requestDetails = null;
		try {
			setUserContextDetails();
			requestDetails = openRequest(7049);
			assertNotNull(requestDetails);
			RequestApproverAction approverAction = getApproverAction("CompBidRepliesTaxonomy", requestDetails);
			assertNotNull(approverAction);
			approverAction.setRequestId(new BigInteger("7049"));
			String result = approverAction.getCompBidReplies();
			assertNotNull(result);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Test case failed with error message : "+ e.getMessage());
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.action.request.RequestDetailsSupportAction#getCurrBankFees()}.
	 */
	@Test
	public void testGetCurrBankFees() {
		RequestDetails requestDetails = null;
		try {
			setUserContextDetails();
			requestDetails = openRequest(7049);
			assertNotNull(requestDetails);
			RequestApproverAction approverAction = getApproverAction("CurrBankFeesTaxonomy", requestDetails);
			assertNotNull(approverAction);
			approverAction.setRequestId(new BigInteger("7049"));
			String result = approverAction.getCurrBankFees();
			assertNotNull(result);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Test case failed with error message : "+ e.getMessage());
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.action.request.RequestDetailsSupportAction#saveCurrBankFees()}.
	 */
	@Test
	public void testSaveCurrBankFees() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.ge.aloc.action.request.RequestDetailsSupportAction#updateTaxonomy()}.
	 */
	@Test
	public void testUpdateTaxonomy() {
		RequestDetails requestDetails = null;
		try {
			setUserContextDetails();
			requestDetails = openRequest(7049);
			RequestApproverAction approverAction = getApproverAction("updateTaxonomy",requestDetails);
			approverAction.setRequestId(new BigInteger("7049"));
			TpApplicantDetails tpApplicantDet = (requestDetails.getTransactionParties()!= null) ? requestDetails.getTransactionParties().getTpApplicantDetails() : null;
			TpBuContactPerson tpBucPerson= (tpApplicantDet!= null) ? tpApplicantDet.getTpBuContactPerson() : null;
			if(tpBucPerson != null){
				TpBuContactPerson newTPDet = new TpBuContactPerson();
				newTPDet.setFirstName("Approver_999911199");
				newTPDet.setLastName("Test_999911199");
				newTPDet.setSsoId(999911199);
				requestDetails.getTransactionParties().getTpApplicantDetails().setTpBuContactPerson(newTPDet);
				RequestDetailsBO requestDetailsBO = new RequestDetailsBO(requestDetails);
				approverAction.setRequestDetailsBO(requestDetailsBO);
			}
			String resultPage = approverAction.updateTaxonomy();
			assertNotNull(resultPage);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Test case failed with error message : "+ e.getMessage());
		} 
	}

	/**
	 * Test method for {@link com.ge.aloc.action.request.RequestDetailsSupportAction#getAuditLog()}.
	 */
	@Test
	public void testGetAuditLog() {
		RequestDetails requestDetails = null;
		try {
			setUserContextDetails();
			requestDetails = openRequest(7049);
			assertNotNull(requestDetails);
			RequestApproverAction approverAction = getApproverAction("AuditLogTaxonomy", requestDetails);
			assertNotNull(approverAction);
			approverAction.setRequestId(new BigInteger("7049"));
			String result = approverAction.getAuditLog();
			assertNotNull(result);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Test case failed with error message : "+ e.getMessage());
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.action.request.RequestDetailsSupportAction#getTransactionLog()}.
	 */
	@Test
	public void testGetTransactionLog() {
		RequestDetails requestDetails = null;
		try {
			setUserContextDetails();
			requestDetails = openRequest(7049);
			assertNotNull(requestDetails);
			RequestApproverAction approverAction = getApproverAction("TransactionLogTaxonomy", requestDetails);
			assertNotNull(approverAction);
			approverAction.setRequestId(new BigInteger("7049"));
			String result = approverAction.getTransactionLog();
			assertNotNull(result);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Test case failed with error message : "+ e.getMessage());
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.action.request.RequestDetailsSupportAction#getIssuer()}.
	 */
	@Test
	public void testGetIssuer() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.ge.aloc.action.request.RequestDetailsSupportAction#getClosure()}.
	 */
	@Test
	public void testGetClosure() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.ge.aloc.action.request.RequestDetailsSupportAction#getModelRequestResultPage()}.
	 */
	@Test
	public void testGetModelRequestResultPage() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.ge.aloc.action.request.RequestDetailsSupportAction#openModelRequest()}.
	 */
	@Test
	public void testOpenModelRequest() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.ge.aloc.action.request.RequestDetailsSupportAction#saveModel(java.util.List)}.
	 */
	@Test
	public void testSaveModel() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.ge.aloc.action.request.RequestDetailsSupportAction#cloneRequest()}.
	 */
	@Test
	public void testCloneRequest() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.ge.aloc.action.request.RequestDetailsSupportAction#saveRequestDetails()}.
	 */
	@Test
	public void testSaveRequestDetails() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.ge.aloc.action.request.RequestDetailsSupportAction#getFullAuditAndActionLog()}.
	 */
	@Test
	public void testGetFullAuditAndActionLog() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.ge.aloc.action.request.RequestDetailsSupportAction#setCalendarDetails(com.ge.aloc.model.RequestDetails)}.
	 */
	@Test
	public void testSetCalendarDetails() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.ge.aloc.action.request.RequestDetailsSupportAction#setAttachmentsToRequestByStage(com.ge.aloc.model.RequestDetails)}.
	 */
	@Test
	public void testSetAttachmentsToRequestByStage() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.ge.aloc.action.request.RequestDetailsSupportAction#setBidReplyCalendarDetails(com.ge.aloc.model.RequestDetails)}.
	 */
	@Test
	public void testSetBidReplyCalendarDetails() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.ge.aloc.action.request.RequestDetailsSupportAction#setHoursMinutes(com.ge.aloc.model.RequestDetails)}.
	 */
	@Test
	public void testSetHoursMinutes() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.ge.aloc.action.request.RequestDetailsSupportAction#getEditSectionList()}.
	 */
	@Test
	public void testGetEditSectionList() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.ge.aloc.action.request.RequestDetailsSupportAction#setEditSectionList(java.util.List)}.
	 */
	@Test
	public void testSetEditSectionList() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.ge.aloc.action.request.RequestDetailsSupportAction#getRequestDetails()}.
	 */
	@Test
	public void testGetRequestDetails() {
		fail("Not yet implemented");
	}
}
