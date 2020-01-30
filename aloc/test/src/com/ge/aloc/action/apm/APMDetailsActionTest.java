/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: APMDetailsActionTest.java
 * Purpose: APMDetailsActionTest class used for testing the usecases of the screen
 *
 */
package com.ge.aloc.action.apm;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.common.AbstractTestCase;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.model.APMDetails;
import com.ge.aloc.model.BUCAndADN;
import com.ge.aloc.model.FeePaymentRunDetails;
import com.ge.aloc.model.FeePeriodDetails;
import com.ge.aloc.model.PaymentPeriodDetails;
import com.ge.aloc.util.ALOCCommonHelper;
import com.hydus.hwf.exceptions.HWFServiceException;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author nagarjuna.aluru
 *
 */
public class APMDetailsActionTest extends AbstractTestCase{

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
	 *test Method to open the Fee Payment Run Page
	 * Test method for {@link com.ge.aloc.action.apm.APMDetailsAction#openFeePaymentRun()}.
	 * @throws HWFServiceException 
	 */
	@Test
	public void testOpenFeePaymentRun(){
		APMDetailsAction apmDetailsAction;
		apmDetailsAction = getAPMDetailsAction("openFeePaymentRun");
		assertNotNull(apmDetailsAction);
		setUserContextDetails();
		try {
			Map<String, Object> sessionValues=ActionContext.getContext().getSession();;
			apmDetailsAction.setSessionValues(sessionValues);
			String result = apmDetailsAction.openFeePaymentRun();
			assertNotNull(result);
			assertEquals("success",result);
		} catch (HWFServiceException e) {
			e.printStackTrace();
			fail(ALOCConstants.TESTCASE_FIALED_ERROR_MESSAGE + e.getMessage());		
		}
	}

	/**
	 * test Method to get the CalculateFeesDetails 
	 * Test method for {@link com.ge.aloc.action.apm.APMDetailsAction#getCalculateFeesDetails()}.
	 */
	@Test
	public void testGetCalculateFeesDetails() {
		APMDetailsAction apmDetailsAction;
		apmDetailsAction = getAPMDetailsAction("getCalculateFeesDetails");
		assertNotNull(apmDetailsAction);
		setUserContextDetails();
		try {
			Map<String, Object> sessionValues=ActionContext.getContext().getSession();;
			apmDetailsAction.setSessionValues(sessionValues);
			apmDetailsAction.openFeePaymentRun();
			String result = apmDetailsAction.getCalculateFeesDetails();
			assertNotNull(result);
			assertEquals("success",result);
		} catch (HWFServiceException e) {
			fail(ALOCConstants.TESTCASE_FIALED_ERROR_MESSAGE + e.getMessage());		
		}
	}


	/**
	 * test method to the get the year list
	 * Test method for {@link com.ge.aloc.action.apm.APMDetailsAction#getYearlist()}
	 * @throws HWFServiceException 
	 */
	@Test
	public void testGetYearlist() throws HWFServiceException {
		APMDetailsAction apmDetailsAction;
		apmDetailsAction = getAPMDetailsAction("getYearlist");
		assertNotNull(apmDetailsAction);
		setUserContextDetails();
		try{
			String result = apmDetailsAction.getYearlist();
			assertNotNull(result);
			assertEquals("success",result);}
		catch(HWFServiceException e) {
			fail(ALOCConstants.TESTCASE_FIALED_ERROR_MESSAGE + e.getMessage());		
		}
	}



	/**
	 * test method to get the rate history
	 * Test method for {@link com.ge.aloc.action.apm.APMDetailsAction#openFXRateHistory()}.
	 * @throws ParseException 
	 * @throws NullPointerException 
	 * @throws HWFServiceException 
	 */
	@Test
	public void testOpenFXRateHistory() throws HWFServiceException, NullPointerException, ParseException {
		APMDetailsAction apmDetailsAction;
		apmDetailsAction = getAPMDetailsAction("openFXRateHistory");
		assertNotNull(apmDetailsAction);
		setUserContextDetails();
		request.setParameter(ALOCConstants.FXFROMYEAR, "2010");
		request.setParameter(ALOCConstants.FXTOYEAR, "2014");
		try{
			String result = apmDetailsAction.openFXRateHistory();
			assertNotNull(result);
			assertEquals("success",result);}
		catch(HWFServiceException e) {
			fail(ALOCConstants.TESTCASE_FIALED_ERROR_MESSAGE + e.getMessage());	
		}
	}

	/**
	 *  test Method to get the fx rates
	 * Test method for {@link com.ge.aloc.action.apm.APMDetailsAction#openFXRateHistory()}.
	 * @throws HWFServiceException
	 */
	@Test
	public void testGetFxRates() throws HWFServiceException {
		APMDetailsAction apmDetailsAction;
		apmDetailsAction = getAPMDetailsAction("getFxRates");
		assertNotNull(apmDetailsAction);
		setUserContextDetails();
		Map<String, Object> sessionValues=ActionContext.getContext().getSession();;
		apmDetailsAction.setSessionValues(sessionValues);
		request.setParameter(ALOCConstants.FEEPERIODID, "1");
		try{
			String result = apmDetailsAction.getFxRates();
			assertNotNull(result);
			assertEquals("success",result);
		}
		catch(HWFServiceException e) {
			fail(ALOCConstants.TESTCASE_FIALED_ERROR_MESSAGE + e.getMessage());	
		}

	}

	/**
	 * test method to download FX Rates
	 * Test method for {@link com.ge.aloc.action.apm.APMDetailsAction#downloadFXRates()}
	 * @throws throws Exception 
	 */
	@Test
	public void testDownloadFXRates() throws Exception {
		APMDetailsAction apmDetailsAction;
		apmDetailsAction= getAPMDetailsAction("downloadResultExport");
		assertNotNull(apmDetailsAction);
		setUserContextDetails();
		try{
			String result = apmDetailsAction.downloadFXRates();
			assertEquals(null,result);
		} catch (HWFServiceException e) {
			fail(ALOCConstants.TESTCASE_FIALED_ERROR_MESSAGE + e.getMessage());	
		}

	}

	/**
	 * This method is used to get the requests with invalid BUC ADN values
	 * Test method for {@link com.ge.aloc.action.apm.APMDetailsAction#getBUCADNDetails()}.
	 */
	@Test
	public void testGetBUCADNDetails() {
		APMDetailsAction apmDetailsAction;		
		apmDetailsAction = getAPMDetailsAction("getBUCADNDetails");
		assertNotNull(apmDetailsAction);

		try {  
			setUserContextDetails();
			request.setParameter(ALOCConstants.BUC,"ADMUKL");
			request.setParameter(ALOCConstants.ADN,"307020210");
			APMDetails apmDetails= new APMDetails();
			FeePaymentRunDetails feePaymentRunDetails = new FeePaymentRunDetails();
			FeePeriodDetails feePeriodDetails = new FeePeriodDetails();
			feePeriodDetails.setAPMConfigID(BigInteger.valueOf(342));
			feePaymentRunDetails.setFeePeriodDetails(feePeriodDetails);
			apmDetails.setFeePaymentRunDetails(feePaymentRunDetails);			
			Map<String, Object> apmDetailsList = new HashMap<String, Object>();
			apmDetailsList.put(ALOCConstants.FEE_PAYMENT_RUN_DETAILS, apmDetails);
			apmDetailsAction.setSessionValues(apmDetailsList);		
			String result = apmDetailsAction.getBUCADNDetails();
			assertNotNull(result);
			assertEquals(ALOCConstants.SUCCESS,result);
			assertNotNull(apmDetailsAction.getBucAdnList());
		} catch (HWFServiceException e) {
			fail(ALOCConstants.TESTCASE_FIALED_ERROR_MESSAGE + e.getMessage());	
		}
	}

	/**
	 * This method is used to update the requests with valid BUC ADN values
	 * Test method for {@link com.ge.aloc.action.apm.APMDetailsAction#updateBUCADNDetails()}.
	 */
	@Test
	public void testUpdateBUCADNDetails() {
		APMDetailsAction apmDetailsAction;		
		apmDetailsAction = getAPMDetailsAction("updateBUCADNDetails");
		assertNotNull(apmDetailsAction);

		try {
			setUserContextDetails();
			BUCAndADN bucAndADN = new BUCAndADN();
			bucAndADN.setBUC("BUC_101");
			bucAndADN.setADN("ADN_101");
			bucAndADN.setRequestId(new BigInteger("7231"));
			bucAndADN.setUpdateFlag(true);
			List<BUCAndADN> bucAndADNList = new ArrayList<BUCAndADN>();
			bucAndADNList.add(bucAndADN);
			apmDetailsAction.setBucAdnList(bucAndADNList);
			apmDetailsAction.setUpdatedBUCVal("ADI267");
			apmDetailsAction.setUpdatedADNVal("ADIDEBITNOTE");
			APMDetails apmDetails= new APMDetails();
			FeePaymentRunDetails feePaymentRunDetails = new FeePaymentRunDetails();
			FeePeriodDetails feePeriodDetails = new FeePeriodDetails();
			feePeriodDetails.setAPMConfigID(BigInteger.valueOf(342));
			feePaymentRunDetails.setFeePeriodDetails(feePeriodDetails);
			apmDetails.setFeePaymentRunDetails(feePaymentRunDetails);			
			Map<String, Object> apmDetailsList = new HashMap<String, Object>();
			apmDetailsList.put(ALOCConstants.FEE_PAYMENT_RUN_DETAILS, apmDetails);
			apmDetailsAction.setSessionValues(apmDetailsList);	
			String result = apmDetailsAction.updateBUCADNDetails();
			assertNotNull(result);
			assertEquals(ALOCConstants.SUCCESS,result);
		} catch (HWFServiceException e) {
			fail(ALOCConstants.TESTCASE_FIALED_ERROR_MESSAGE + e.getMessage());	
		}
	}

	/**
	 * test Method to get APMDetails to show fee summary details
	 * Test method for {@link com.ge.aloc.action.apm.APMDetailsAction#getFeeSummaryDetails()}.
	 * @throws HWFServiceException 
	 */
	@Test
	public void testGetFeeSummaryDetails() throws HWFServiceException {
		APMDetailsAction apmDetailsAction;
		apmDetailsAction= getAPMDetailsAction("getFeeSummary");
		assertNotNull(apmDetailsAction);
		setUserContextDetails();
		try{
			Map<String, Object> sessionValues=ActionContext.getContext().getSession();;
			apmDetailsAction.setSessionValues(sessionValues);
			request.setParameter(ALOCConstants.ALOC_RECORD_NUMBER,"6677");
			apmDetailsAction.openFeePaymentRun();
			String result = apmDetailsAction.getFeeSummaryDetails();
			assertNotNull(result);
			assertEquals("success",result);	    
		} catch (HWFServiceException e) {
			fail(ALOCConstants.TESTCASE_FIALED_ERROR_MESSAGE + e.getMessage());	
		}   

	}

	/**
	 * test Method to open Payment Period
	 * Test method for {@link com.ge.aloc.action.apm.APMDetailsAction#openPaymentPeriod()}.
	 * @throws HWFServiceException 
	 */
	@Test
	public void testOpenPaymentPeriod() throws HWFServiceException {
		APMDetailsAction apmDetailsAction;
		apmDetailsAction= getAPMDetailsAction("openPaymentPeriod");
		assertNotNull(apmDetailsAction);
		setUserContextDetails();
		Map<String, Object> sessionValues=ActionContext.getContext().getSession();;
		apmDetailsAction.setSessionValues(sessionValues);
		try{
			String result = apmDetailsAction.openPaymentPeriod();
			assertNotNull(result);
			assertEquals("success",result);	    
		} catch (HWFServiceException e) {
			fail(ALOCConstants.TESTCASE_FIALED_ERROR_MESSAGE + e.getMessage());	
		}   

	}


	/**
	 * test Method to save Payment Period
	 * Test method for {@link com.ge.aloc.action.apm.APMDetailsAction#savePaymentPeriod()}.
	 * @throws HWFServiceException 
	 * @throws ParseException 
	 */
	@Test
	public void testSavePaymentPeriod() throws HWFServiceException, ParseException {
		APMDetailsAction apmDetailsAction;
		apmDetailsAction= getAPMDetailsAction("savePaymentPeriod");
		PaymentPeriodDetails firstpaymentperiods=getpaymentPeriod();					
		apmDetailsAction.setFirstpaymentperiod(firstpaymentperiods);
		Map<String, Object> sessionValues=ActionContext.getContext().getSession();;
		apmDetailsAction.setSessionValues(sessionValues);
		request.setParameter(ALOCConstants.CURINDEX,"0");   
		assertNotNull(apmDetailsAction);
		setUserContextDetails();
		try{
			String result = apmDetailsAction.savePaymentPeriod();
			assertNotNull(result);
			assertEquals("success",result);	    
		} catch (HWFServiceException e) {
			fail(ALOCConstants.TESTCASE_FIALED_ERROR_MESSAGE + e.getMessage());		
		}   

	}

	/**
	 * test Method to Cancel Payment Period row
	 * Test method for {@link com.ge.aloc.action.apm.APMDetailsAction#cancelPaymentPeriod()}.
	 * @throws HWFServiceException 
	 * @throws ParseException 
	 */
	@Test
	public void testCancelPaymentPeriod() throws HWFServiceException, ParseException {
		APMDetailsAction apmDetailsAction;
		apmDetailsAction= getAPMDetailsAction("cancelPaymentPeriod");
		List<PaymentPeriodDetails> paymentPeriod=new ArrayList<PaymentPeriodDetails>();
		PaymentPeriodDetails firstpaymentperiods=getpaymentPeriod();
		paymentPeriod.add(firstpaymentperiods);
		APMDetails apmdetails=new APMDetails();
		apmdetails.setPaymentPeriodDetails(paymentPeriod);
		Map<String, Object> sessionValues=ActionContext.getContext().getSession();
		sessionValues.put(ALOCConstants.PAYMENT_PERIOD_DETAILS, apmdetails);
		apmDetailsAction.setSessionValues(sessionValues);
		assertNotNull(apmDetailsAction);
		setUserContextDetails();
		try{
			String result = apmDetailsAction.cancelPaymentPeriod();
			assertNotNull(result);
			assertEquals("success",result);	    
		} catch (HWFServiceException e) {
			fail(ALOCConstants.TESTCASE_FIALED_ERROR_MESSAGE + e.getMessage());	
		}   

	}

	/**
	 * test Method to add new  Payment Period
	 * Test method for {@link com.ge.aloc.action.apm.APMDetailsAction#addPaymentPeriodRow()}.
	 * @throws HWFServiceException 
	 * @throws ParseException 
	 */
	@Test
	public void testAddPaymentPeriodRow() throws HWFServiceException, ParseException {
		APMDetailsAction apmDetailsAction;
		apmDetailsAction= getAPMDetailsAction("addPaymentPeriodRow");
		assertNotNull(apmDetailsAction);
		setUserContextDetails();

		try{
			String result = apmDetailsAction.addPaymentPeriodRow();
			assertNotNull(result);
			assertEquals("success",result);	    
		} catch (HWFServiceException e) {
			fail(ALOCConstants.TESTCASE_FIALED_ERROR_MESSAGE + e.getMessage());	
		}   

	}


	/**
	 * test Method to cancel  two Payment Period rows 
	 * Test method for {@link com.ge.aloc.action.apm.APMDetailsAction#cancelPaymentPeriodTwoRow()}.
	 * @throws HWFServiceException 
	 * @throws ParseException 
	 */
	@Test
	public void testCancelPaymentPeriodTwoRow() throws HWFServiceException, ParseException {
		APMDetailsAction apmDetailsAction;
		apmDetailsAction= getAPMDetailsAction("cancelPaymentPeriodTwoRow");
		List<PaymentPeriodDetails> paymentPeriod=new ArrayList<PaymentPeriodDetails>();
		PaymentPeriodDetails firstpaymentperiods=getpaymentPeriod();
		paymentPeriod.add(firstpaymentperiods);
		APMDetails apmdetails=new APMDetails();
		apmdetails.setPaymentPeriodDetails(paymentPeriod);
		Map<String, Object> sessionValues=ActionContext.getContext().getSession();
		sessionValues.put(ALOCConstants.PAYMENT_PERIOD_DETAILS, apmdetails);
		apmDetailsAction.setSessionValues(sessionValues);
		request.setParameter(ALOCConstants.CURINDEX,"0");
		assertNotNull(apmDetailsAction);
		setUserContextDetails();

		try{
			String result = apmDetailsAction.cancelPaymentPeriodTwoRow();
			assertNotNull(result);
			assertEquals("success",result);	    
		} catch (HWFServiceException e) {
			fail(ALOCConstants.TESTCASE_FIALED_ERROR_MESSAGE + e.getMessage());		
		}   

	}

	/**
	 * test  Method to edit the the selected payment period row
	 * Test method for {@link com.ge.aloc.action.apm.APMDetailsAction#editPaymentPeriodRow()}.
	 * @throws HWFServiceException 
	 * @throws ParseException 
	 */
	@Test
	public void testEditPaymentPeriodRow() throws HWFServiceException, ParseException {
		APMDetailsAction apmDetailsAction;
		apmDetailsAction= getAPMDetailsAction("editPaymentPeriodRow");
		List<PaymentPeriodDetails> paymentPeriod=new ArrayList<PaymentPeriodDetails>();
		PaymentPeriodDetails firstpaymentperiods=getpaymentPeriod();
		paymentPeriod.add(firstpaymentperiods);
		APMDetails apmdetails=new APMDetails();
		apmdetails.setPaymentPeriodDetails(paymentPeriod);
		Map<String, Object> sessionValues=ActionContext.getContext().getSession();
		sessionValues.put(ALOCConstants.PAYMENT_PERIOD_DETAILS, apmdetails);
		apmDetailsAction.setSessionValues(sessionValues);
		request.setParameter(ALOCConstants.APMCONFIGID,"0");
		assertNotNull(apmDetailsAction);
		setUserContextDetails();
		try{
			String result = apmDetailsAction.editPaymentPeriodRow();
			assertNotNull(result);
			assertEquals("success",result);	    
		} catch (HWFServiceException e) {
			fail(ALOCConstants.TESTCASE_FIALED_ERROR_MESSAGE + e.getMessage());		
		}   

	}

	/**
	 * test Method to save two Payment Period rows
	 * Test method for {@link com.ge.aloc.action.apm.APMDetailsAction#savePaymentPeriodTwoRow()}.
	 * @throws HWFServiceException 
	 * @throws ParseException 
	 */
	@Test
	public void testSavePaymentPeriodTwoRow() throws HWFServiceException, ParseException {
		APMDetailsAction apmDetailsAction;
		apmDetailsAction= getAPMDetailsAction("savePaymentPeriodTwo");

		request.setParameter(ALOCConstants.PAYMENT_CONFIG_ID,"");
		request.setParameter(ALOCConstants.STARTDATE,"10 Feb 2013");
		request.setParameter(ALOCConstants.ENDDATE,"10 Apr 2014");
		request.setParameter(ALOCConstants.REVALUEDATE,"1 Mar 2013");
		request.setParameter(ALOCConstants.CUTOFDATE,"1 Mar 2013");
		request.setParameter(ALOCConstants.USDAMOUNT,"10");
		request.setParameter(ALOCConstants.DAYCOUNT,"10");
		request.setParameter(ALOCConstants.PAYMENT_CONFIG_IDONE,"");
		request.setParameter(ALOCConstants.STARTDATEONE,"11 Apr 2014");
		request.setParameter(ALOCConstants.ENDDATEONE,"12 Apr 2014");
		request.setParameter(ALOCConstants.REVALUEDATEONE,"13 Apr 2014");
		request.setParameter(ALOCConstants.CUTOFDATEONE,"14 Apr 2014");
		request.setParameter(ALOCConstants.USDAMOUNTONE,"20");
		request.setParameter(ALOCConstants.DAYCOUNTONE,"20");
		Map<String, Object> sessionValues=ActionContext.getContext().getSession();
		apmDetailsAction.setSessionValues(sessionValues);
		assertNotNull(apmDetailsAction);
		setUserContextDetails();
		try{
			String result = apmDetailsAction.savePaymentPeriodTwoRow();
			assertNull(result);
			assertEquals(null,result);	    
		} catch (HWFServiceException e) {
			fail(ALOCConstants.TESTCASE_FIALED_ERROR_MESSAGE + e.getMessage());		
		}   

	}

	/**
	 * method for populating data to payment period bean}.
	 * @throws ParseException 
	 */ 
	private PaymentPeriodDetails getpaymentPeriod() throws ParseException{
		PaymentPeriodDetails firstpaymentperiods=new PaymentPeriodDetails();
		firstpaymentperiods.setDayCount(new BigInteger("10"));
		firstpaymentperiods.setMinPaymentAmountUSD(new BigDecimal("20"));
		firstpaymentperiods.setPaymentPeriodStartDate(ALOCCommonHelper.convertStringToCal("10 Feb 2013"));
		firstpaymentperiods.setPaymentPeriodEndDate(ALOCCommonHelper.convertStringToCal("10 Apr 2014"));
		firstpaymentperiods.setPaymentPeriodCutoffDate(ALOCCommonHelper.convertStringToCal("1 Mar 2013"));
		firstpaymentperiods.setFXRateRevalueDate(ALOCCommonHelper.convertStringToCal("10 Mar 2013"));
		return firstpaymentperiods;

	}


}
