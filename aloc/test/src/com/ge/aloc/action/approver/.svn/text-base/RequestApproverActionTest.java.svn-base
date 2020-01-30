/**
 * 
 */
package com.ge.aloc.action.approver;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.bo.RequestDetailsBO;
import com.ge.aloc.common.AbstractTestCase;
import com.ge.aloc.model.ActionDetails;
import com.ge.aloc.model.AddressDtls;
import com.ge.aloc.model.BankDetails;
import com.ge.aloc.model.BidReplyDetails;
import com.ge.aloc.model.BidmemoDetails;
import com.ge.aloc.model.ConfirmationFees;
import com.ge.aloc.model.FeesDetails;
import com.ge.aloc.model.IndicativePricingCompletedDetails;
import com.ge.aloc.model.IssuingBankDetails;
import com.ge.aloc.model.OneTimeFeesDetails;
import com.ge.aloc.model.PricingDetails;
import com.ge.aloc.model.ProposedBankBranchConfirmDetails;
import com.ge.aloc.model.RequestDetails;

/**
 * @author madhusudhan.gosula
 *
 */
public class RequestApproverActionTest extends AbstractTestCase {
	
	private static Calendar dateTime;
	private static Calendar bidExpirationDateTime;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		BidReplyDetails replyDetails = new BidReplyDetails();
		dateTime = new GregorianCalendar(2013, Calendar.FEBRUARY, 5, 11,50);
		bidExpirationDateTime = new GregorianCalendar(2014, Calendar.FEBRUARY, 5, 11,50);
		replyDetails.setPricingExpirationDate(dateTime);
		replyDetails.setBidExpirationDate(bidExpirationDateTime);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	/**
	 * Test method for {@link com.ge.aloc.action.approver.RequestApproverAction#submit()}.
	 */
	@Test
	public final void testSubmit() {
		fail("Not yet implemented"); 
	}

	/**
	 * Test method for {@link com.ge.aloc.action.approver.RequestApproverAction#treasuryAnalystSubmit()}.
	 */
	@Test
	public final void testTreasuryAnalystSubmit() {
		fail("Not yet implemented"); 
	}

	/**
	 * Test method for {@link com.ge.aloc.action.approver.RequestApproverAction#getActionType()}.
	 */
	@Test
	public final void testGetActionType() {
		fail("Not yet implemented"); 
	}

	/**
	 * Test method for {@link com.ge.aloc.action.approver.RequestApproverAction#setActionType(int)}.
	 */
	@Test
	public final void testSetActionType() {
		fail("Not yet implemented"); 
	}

	/**
	 * Test method for {@link com.ge.aloc.action.approver.RequestApproverAction#getCurrentStage()}.
	 */
	@Test
	public final void testGetCurrentStage() {
		fail("Not yet implemented"); 
	}

	/**
	 * Test method for {@link com.ge.aloc.action.approver.RequestApproverAction#setCurrentStage(java.lang.String)}.
	 */
	@Test
	public final void testSetCurrentStage() {
		fail("Not yet implemented"); 
	}
	
	
	 // Test bidReply action (submit bid reply, save next or go to next bundle, opt out)
	 
	/**
	 * The following test case tests opt in for a bid of the bid
	 */
	@Test
	public final void testBgBidReply() {
		try {
			RequestDetails requestDetails = openRequest(4791);
			RequestApproverAction approverAction = approverAction("bidReply",requestDetails);
			approverAction.setActionType(9);
			// Fill up the request details with the BG bid reply details
			BidReplyDetails bid = requestDetails.getBidReplyDetails();
			if(bid==null){
				bid = new BidReplyDetails();
			}
			bid.setBidExpirationDate(Calendar.getInstance());
			bid.setNotes("Sample Notes");
			
			//populating the issuing bank details
			IssuingBankDetails bankDet = requestDetails.getIssuingBankDetails();
			if(bankDet==null){
				bankDet = new IssuingBankDetails();
			}
			bankDet.setBankName("Swiss Bank");
			bankDet.setBIC("BUC_1");
			
			AddressDtls addressDet = new AddressDtls();
			
			List<String> address = new ArrayList<String>();
			address.add("Hyderabad");
			address.add("Erramanzil");
			addressDet.setAddress(address);
			addressDet.setStateProvince("AP");
			addressDet.setZIPPostalCode("500082");
			bankDet.setAddressDtls(addressDet);
			bankDet.setUSExpirationDate(Calendar.getInstance());
			
			//populating the pricing  details
			PricingDetails pricingDetails = requestDetails.getPricingDetails();
			if(pricingDetails==null){
				pricingDetails = new PricingDetails();
			}
			pricingDetails.setAllInCommissionsId(BigInteger.valueOf(1));
			pricingDetails.setAllInCommissionsValue(new BigDecimal("10"));
			pricingDetails.setAllInAmmendmentTransactionFee(new BigDecimal("160"));
			pricingDetails.setLocalCommissionsId(BigInteger.valueOf(1));
			pricingDetails.setLocalCommissionsValue(new BigDecimal("10"));
			pricingDetails.setLocalAmmendmentTransactionFee(new BigDecimal("160"));
			
			//populating the one time fees details
			OneTimeFeesDetails oneTimeFees = requestDetails.getOneTimeFeesDetails();
			if(oneTimeFees==null){
				oneTimeFees = new OneTimeFeesDetails();
			}
			oneTimeFees.setVATTaxes(new BigDecimal("100"));
			oneTimeFees.setStampTaxes(new BigDecimal("200"));
			oneTimeFees.setIncidentalAdminFee(new BigDecimal("300"));
			oneTimeFees.setOther(new BigDecimal("400"));

			String result = approverAction.submit();
			
			assertEquals("The action submit has not returned success","success", result);

		} catch (Exception e) {
			fail("Test case failed with error message : "+ e.getMessage());
		}
	}
	
	/**
	 * The following test case tests opt in for a bid of the bid
	 */
	
	@Test
	public final void testBgOptOut() {
		try {
			RequestDetails requestDetails = openRequest(4791);
			RequestApproverAction approverAction = approverAction("bidReply",requestDetails);
			approverAction.setActionType(9);
			requestDetails.setBidOrOptFlag("Optout");
			ActionDetails actionDet = new ActionDetails();
			actionDet.setReasonForOptingOut("Opting Out");
			requestDetails.setActionDetails(actionDet);
			
			String result = approverAction.submit();
			assertEquals("success", result);
			
		}catch (Exception e) {
			fail("Test case failed with error message : "+ e.getMessage());
		}
	}
	
	/**
	 * The following test case tests opt in for a bid of the bid
	 */
	@Test
	public final void testBgBidReplyWithNullVal() {
		try {
			RequestDetails requestDetails = openRequest(4791);
			RequestApproverAction approverAction = approverAction("bidReply",requestDetails);
			approverAction.setActionType(9);
			
			requestDetails.setBidReplyDetails(null);
			requestDetails.setIssuingBankDetails(null);
			requestDetails.setPrincipal(null);
			requestDetails.setOneTimeFeesDetails(null);
			
			String result = approverAction.submit();
			assertEquals("The action submit has not returned success","success", result);
			
		}catch (Exception e) {
			fail("Test case failed with error message : "+ e.getMessage());
		}
	}
		
	
	/**
	 * Test sbBidReply action
	 */
	@Test
	public final void testSbBidReply() {
		
		RequestDetails requestDetails;
		try {
			requestDetails = openRequest(5202);
			RequestApproverAction approverAction = approverAction("bidReply",requestDetails);
			approverAction.setActionType(9);
			
			//populating the Bid Memo Details
			BidmemoDetails replyDetails = new BidmemoDetails();
			bidExpirationDateTime = new GregorianCalendar(2014, Calendar.FEBRUARY, 5, 11,50);
			replyDetails.setExpirationDateTime(bidExpirationDateTime);
			requestDetails.setBidmemoDetails(replyDetails);
			
			dateTime = requestDetails.getBidmemoDetails().getExpirationDateTime();
			assertNotNull(dateTime);
			
			ActionDetails actionDet = new ActionDetails();
			actionDet.setComments("Test");
			requestDetails.setActionDetails(actionDet);
			
			//populating the Fees Details
			FeesDetails fees = new FeesDetails();
			assertNotNull(fees);
			fees.setSurityName("Surety Name");
			fees.setSurityId(new BigInteger("5"));
			fees.setPremiumFees(new BigDecimal("1000"));
			fees.setChargeForRider(new BigDecimal("1000"));
			fees.setTotoalPremium(new BigDecimal("1000"));
			requestDetails.setFeesDetails(fees);
			assertEquals("Surety Name", requestDetails.getFeesDetails().getSurityName());
			
			String result = approverAction.submit();
			assertEquals("success", result);
			
		} catch (Exception e) {
			fail("Test case failed with error message : "+ e.getMessage());
		}
		
		
	}
	
	/**
	 * Test SuretyBidReply action
	 */
	@Test
	public final void testSuretyFeesBidReply() {
		
		
		RequestDetails requestDetails;
		try {
			requestDetails = openRequest(5202);
			RequestApproverAction approverAction = approverAction("bidReply",requestDetails);
			approverAction.setActionType(9);
		
			FeesDetails fees = new FeesDetails();
			assertNotNull(fees);
			fees.setSurityName("Surety Name");
			fees.setSurityId(new BigInteger("5"));
			fees.setPremiumFees(new BigDecimal("1000"));
			fees.setChargeForRider(new BigDecimal("1000"));
			fees.setTotoalPremium(new BigDecimal("1000"));
			requestDetails.setFeesDetails(fees);
			assertEquals("Surety Name", requestDetails.getFeesDetails().getSurityName());
			
			String result = approverAction.submit();
			assertEquals("success", result);
		
		
	} catch (Exception e) {
		fail("Test case failed with error message : "+ e.getMessage());
	}
	
	}
	
	/**
	 * Test SuretyBidReply
	 */
	@Test
	public final void testSuretyBidReply() {
		
		RequestDetails requestDetails;
		try {
			requestDetails = openRequest(5202);
			RequestApproverAction approverAction = approverAction("bidReply",requestDetails);
			approverAction.setActionType(9);
			
			requestDetails.setBidReplyDetails(null);
			requestDetails.setIssuingBankDetails(null);
			requestDetails.setPrincipal(null);
			requestDetails.setOneTimeFeesDetails(null);
			requestDetails.setFeesDetails(null);
			requestDetails.setBidmemoDetails(null);
			requestDetails.setActionDetails(null);
			
		} catch (Exception e) {
			fail("Test case failed with error message : "+ e.getMessage());
		}
	}
	
	/**
	 * Test dlocBidReply action
	 */
	@Test
	public final void testDlocBidReply() {
		try {
			RequestDetails requestDetails = openRequest(4883);
			RequestApproverAction approverAction = approverAction("dlocBidReply",requestDetails);
			approverAction.setActionType(9);
			
			//confirmation details		    
		    ConfirmationFees feesDet = requestDetails.getConfirmationFees();
		    if(feesDet ==null){
		    	feesDet = new ConfirmationFees();
		    	requestDetails.setConfirmationFees(feesDet);
		    }
		    feesDet.setFeeStructureId(BigInteger.valueOf(1));
		    feesDet.setFeeStructureValue(new BigDecimal("123"));
		    feesDet.setOtherFees(new BigDecimal("2500"));
		    feesDet.setAdditionalComments("Additional comments");
		    
		    //proposed bank details		    
		    ProposedBankBranchConfirmDetails proposedBankConfirmDet = requestDetails.getProposedBankBranchConfirmDetails();
		    if(proposedBankConfirmDet == null){
		    	proposedBankConfirmDet = new ProposedBankBranchConfirmDetails();
		    	requestDetails.setProposedBankBranchConfirmDetails(proposedBankConfirmDet);
		    }		    
		    BankDetails bankDet = new BankDetails();
		    bankDet.setName("Swiss Bank");
			bankDet.setBankIdentifierCode("BUC_1");
			bankDet.setCity("Hyderabad");
			bankDet.setStateProvince("AP");
			bankDet.setZIPPostalCode("500082");
			
			List<String> address = new ArrayList<String>();
			address.add("Hyderabad");
			address.add("Erramanzil");
			bankDet.setAddress(address);
			bankDet.setCountry("India");
			
			proposedBankConfirmDet.setBankDetails(bankDet);
			
			//indicative pricing information			
			IndicativePricingCompletedDetails indicativePricingCompletedDetails = requestDetails.getIndicativePricingCompletedDetails();
			if(indicativePricingCompletedDetails == null){
				indicativePricingCompletedDetails = new IndicativePricingCompletedDetails();
				requestDetails.setIndicativePricingCompletedDetails(indicativePricingCompletedDetails);
			}	
			Calendar  pricingExpirationTime = Calendar.getInstance();
			pricingExpirationTime.set(Calendar.HOUR,3);
			pricingExpirationTime.set(Calendar.MINUTE,34);
			pricingExpirationTime.set(Calendar.AM_PM,Calendar.PM);	
			indicativePricingCompletedDetails.setPricingExpirationDateTime(pricingExpirationTime);
			
			
			//approverAction.getRequestDetailsBO().getIndicativePricingCompletedDetailsBO().getPricingExpirationTime();
			
			
			String result = approverAction.submit();		
			
			assertEquals("The action submit has not returned success","success", result);
		
		}catch (Exception e) {
			fail("Test case failed with error message : "+ e.getMessage());
		}
	}
	
	
	@Test
	public final void testDlocBidReplyWithBundle() {
		try {
			RequestDetails requestDetails = openRequest(7500);
			RequestApproverAction approverAction = approverAction("dlocBidReply",requestDetails);
			approverAction.setActionType(9);
		    //confirmation details		    
		    ConfirmationFees feesDet = requestDetails.getConfirmationFees();
		    if(feesDet ==null){
		    	feesDet = new ConfirmationFees();
		    	requestDetails.setConfirmationFees(feesDet);
		    }
		    feesDet.setFeeStructureId(BigInteger.valueOf(1));
		    feesDet.setFeeStructureValue(new BigDecimal("123"));
		    feesDet.setOtherFees(new BigDecimal("2500"));
		    feesDet.setAdditionalComments("Additional comments");
		    
		    //proposed bank details		    
		    ProposedBankBranchConfirmDetails proposedBankConfirmDet = requestDetails.getProposedBankBranchConfirmDetails();
		    if(proposedBankConfirmDet == null){
		    	proposedBankConfirmDet = new ProposedBankBranchConfirmDetails();
		    	requestDetails.setProposedBankBranchConfirmDetails(proposedBankConfirmDet);
		    }		    
		    BankDetails bankDet = new BankDetails();
		    bankDet.setName("Swiss Bank");
			bankDet.setBankIdentifierCode("BUC_1");
			bankDet.setCity("Hyderabad");
			bankDet.setStateProvince("AP");
			bankDet.setZIPPostalCode("500082");
			
			List<String> address = new ArrayList<String>();
			address.add("Hyderabad");
			address.add("Erramanzil");
			bankDet.setAddress(address);
			bankDet.setCountry("India");
			
			proposedBankConfirmDet.setBankDetails(bankDet);
			
			//indicative pricing information			
			IndicativePricingCompletedDetails indicativePricingCompletedDetails = requestDetails.getIndicativePricingCompletedDetails();
			if(indicativePricingCompletedDetails == null){
				indicativePricingCompletedDetails = new IndicativePricingCompletedDetails();
				requestDetails.setIndicativePricingCompletedDetails(indicativePricingCompletedDetails);
			}	
			Calendar  pricingExpirationTime = Calendar.getInstance();
			pricingExpirationTime.set(Calendar.HOUR,3);
			pricingExpirationTime.set(Calendar.MINUTE,34);
			pricingExpirationTime.set(Calendar.AM_PM,Calendar.PM);	
			indicativePricingCompletedDetails.setPricingExpirationDateTime(pricingExpirationTime);
			
			
			String result = approverAction.submit();		
			
			assertEquals("The action submit has not returned success","success", result);
			
		}catch (Exception e) {
			fail("Test case failed with error message : "+ e.getMessage());
		}
	}
	
	@Test
	public final void testDlocBidReplyOptOut() {
		try {
			RequestDetails requestDetails = openRequest(4883);
			RequestApproverAction approverAction = approverAction("dlocBidReply",requestDetails);
			RequestDetailsBO requestDetailsBO = new RequestDetailsBO(requestDetails);
			approverAction.setRequestDetailsBO(requestDetailsBO);
			approverAction.setActionType(9);

			ActionDetails actionDet =requestDetails.getActionDetails();
			if(actionDet == null){
				actionDet = new ActionDetails();
				requestDetails.setActionDetails(actionDet);			
			}
			actionDet.setReasonForOptingOut("ReasonForOptingOut");
			
			String result = approverAction.submit();	
			
			assertEquals("The action submit has not returned success","success", result);
			
		}catch (Exception e) {
			fail("Test case failed with error message : "+ e.getMessage());
		}
	}
	

}
