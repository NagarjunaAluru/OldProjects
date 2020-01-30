/**
 * 
 */
package com.ge.aloc.dao.impl.apm;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.dao.impl.DAOConnectionHelper;
import com.ge.aloc.model.APMDetails;
import com.ge.aloc.model.BUCAndADN;
import com.ge.aloc.model.FXRateHistory;
import com.ge.aloc.model.FeePaymentRunDetails;
import com.ge.aloc.model.FeePeriodDetails;
import com.ge.aloc.model.MsgHeader;
import com.ge.aloc.model.PaymentPeriodDetails;
import com.ge.aloc.util.ALOCCommonHelper;
import com.hydus.hwf.bw.service.IServiceClient;
import com.hydus.hwf.context.UserContext;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author nagarjuna.aluru
 *
 */
public class APMDetailsDAOTest {
	private static IServiceClient serviceClient;
	private static APMDetailsDAO apmDetailsDAO;

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
		serviceClient = DAOConnectionHelper.getServiceClient();
		apmDetailsDAO = new APMDetailsDAO();
		apmDetailsDAO.setServiceClient(serviceClient);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		apmDetailsDAO = null;
	}

	/**
	 * This method is used to get the requests with invalid BUC ADN values
	 * Test method for {@link com.ge.aloc.dao.impl.apm.APMDetailsDAO#getBUCADNDetails()}.
	 */
	@Test
	public void testGetBUCADNDetails() {
		
		try {
				setUserContextDetails();
				APMDetails apmDetails = new APMDetails();
				apmDetails = apmDetailsDAO.getBUCADNDetails(apmDetails);
				assertNotNull(apmDetails);
				assertNotNull(apmDetails.getBUCAndADNs());
		} catch (HWFServiceException e) {
			fail("Error while retrieving the requests with invalid BUC ADN values");
		}
	}

	/**
	 * This method is used to update the requests with valid BUC ADN values
	 * Test method for {@link com.ge.aloc.dao.impl.apm.APMDetailsDAO#updateBUCADNDetails(com.ge.aloc.model.APMDetails)}.
	 */
	@Test
	public void testUpdateBUCADNDetails() {
		try {
				setUserContextDetails();
				BUCAndADN bucAndADN = new BUCAndADN();
				bucAndADN.setBUC("ADI267");
				bucAndADN.setADN("ADIDEBITNOTE");
				bucAndADN.setRequestId(new BigInteger("7231"));
				bucAndADN.setUpdateFlag(true);
				List<BUCAndADN> bucAndADNList = new ArrayList<BUCAndADN>();
				bucAndADNList.add(bucAndADN);
				APMDetails apmDetails = new APMDetails();
				apmDetails.setBUCAndADNs(bucAndADNList);
				apmDetailsDAO.updateBUCADNDetails(apmDetails);
				assertNotNull(apmDetails);
				assertNotNull(apmDetails.getBUCAndADNs());
		} catch (HWFServiceException e) {
			fail("Error while updating the requests with valid BUC ADN values");
		}
	}

	/**
	 * test Method to invoke the Service for FeePaymentRun Details
	 * Test method for {@link com.ge.aloc.dao.impl.apm.APMDetailsDAO#openFeePaymentRun()}.
	 */
	@Test
	public void testOpenFeePaymentRun() {
		
		try {
			setUserContextDetails();
			APMDetails apmDetails = apmDetailsDAO.openFeePaymentRun();
			assertNotNull(apmDetails);
			assertNotNull(apmDetails.getFeePaymentRunDetails().getFeePeriodDetails());
		} catch (HWFServiceException e) {
			e.printStackTrace();
			fail("Error while calling APMDetails Process");
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.dao.impl.apm.APMDetailsDAO#getCalculateFeesDetails()}.
	 */
	@Test
	public void testGetCalculateFeesDetails() {
		try {
			setUserContextDetails();//TODO need to test after service integration
			APMDetails apmDetails = new APMDetails();
			FeePaymentRunDetails feeRun = new FeePaymentRunDetails();
			FeePeriodDetails feePeroid = new FeePeriodDetails();
			feePeroid.setAPMConfigID(new BigInteger("90"));
			Calendar cal = Calendar.getInstance();
			cal.set(2013, 12, 28);
			feePeroid.setPeriodCuttOffDate(cal);
			feeRun.setFeePeriodDetails(feePeroid);
			Calendar cal1 = Calendar.getInstance();
			cal1.set(2013, 05, 10);
			feePeroid.setPeriodStartDate(cal1);
			feePeroid.setPeriodEndDate(cal);
			apmDetails.setFeePaymentRunDetails(feeRun);
			APMDetails apmDet = apmDetailsDAO.getCalculateFeesDetails(apmDetails);
			assertNotNull(apmDet);
		} catch (HWFServiceException e) {
			e.printStackTrace();
			fail("Error while calling APMDetails Process");
		}
	}

	/**
	 * Test Method to show fee summary details
	 * Test method for {@link com.ge.aloc.dao.impl.apm.APMDetailsDAO#getFeeSummaryDetails()}.
	 */
	@Test
	public void testGetFeeSummaryDetails() {
		//TODO set the request parameters here
		try{
			setUserContextDetails();
			APMDetails apmDet = new APMDetails();
			FeePaymentRunDetails feeRunDet = new FeePaymentRunDetails();
			FeePeriodDetails feePeriod = new FeePeriodDetails();
			feePeriod.setAPMConfigID(new BigInteger("4"));
			Calendar cal = Calendar.getInstance();
			cal.set(2013, 01, 14);
			feePeriod.setPeriodCuttOffDate(cal);
			feePeriod.setPeriodStartDate(cal);
			Calendar cal1 = Calendar.getInstance();
			cal1.set(2013,05,14);
			feePeriod.setPeriodEndDate(cal1);
			feeRunDet.setFeePeriodDetails(feePeriod);
			apmDet.setFeePaymentRunDetails(feeRunDet);
			APMDetails apmDetails = apmDetailsDAO.getFeeSummaryDetails(apmDet);
			assertNotNull(apmDetails);
			assertNotNull(apmDetails.getFeeSummaryDetails());
			
		}catch (HWFServiceException e) {
				e.printStackTrace();
				fail("Error while calling APMDetails Process");
			}
	}
	/**
	 * Test Method to get APMDetails to show fX rate history periods 
	 * Test method for {@link com.ge.aloc.dao.impl.apm.APMDetailsDAO#openFXRateHistory()}.
	 */
	@Test
	public void testOpenFXRateHistory() {
		try{
			setUserContextDetails();
			FXRateHistory fxRatehistory=new FXRateHistory();
			List<BigInteger> FxRatePeriodyearList;
			FxRatePeriodyearList=new ArrayList<BigInteger>();
			FxRatePeriodyearList.add(new BigInteger("2010"));
			fxRatehistory.setFromYears(FxRatePeriodyearList);
			FxRatePeriodyearList=new ArrayList<BigInteger>();
			FxRatePeriodyearList.add(new BigInteger("2014"));
			fxRatehistory.setToYears(FxRatePeriodyearList);
			APMDetails apmDetails = apmDetailsDAO.openFXRateHistory(fxRatehistory);
			assertNotNull(apmDetails);
			assertNotNull(apmDetails.getFXRateHistoryAndCurrencySetup().getFXRateHistory().getFeePeriodDetails());
		}catch (HWFServiceException e) {
				e.printStackTrace();
				fail("Error while calling APMDetails Process");
			}
	}
	
	/**
	 * Test Method to get the FX Rates  
	 * Test method for {@link com.ge.aloc.dao.impl.apm.APMDetailsDAO#getFxRates()}.
	 */
	@Test
	public void testGetFxRates() {
		try{
			setUserContextDetails();
			APMDetails apmDetails = apmDetailsDAO.getFxRates(new BigInteger("1"));
			assertNotNull(apmDetails);
			assertNotNull(apmDetails.getFXRateHistoryAndCurrencySetup().getFXRateHistory().getGetFXRates());
		}catch (HWFServiceException e) {
				fail("Error while calling APMDetails Process");
			}
	}
	
	
	/**
	 * Test Method to download the FX Rates 
	 * Test method for {@link com.ge.aloc.dao.impl.apm.APMDetailsDAO#downloadFxRates()}.
	 */
	@Test
	public void testdownloadFxRates() {
		try{
			setUserContextDetails();
			APMDetails apmDetails = apmDetailsDAO.downloadFxRates(new BigInteger("120"));
			assertNotNull(apmDetails);
			assertNotNull(apmDetails.getFXRateHistoryAndCurrencySetup().getFXRateHistory().getGetFXRates());
		}catch (HWFServiceException e) {
				fail("Error while calling APMDetails Process");
			}
	}
	
	

	/**
	 * Test method to get the year list
	 * Test method for {@link com.ge.aloc.dao.impl.apm.APMDetailsDAO#testgetYearlist()}.
	 */
	@Test
	public void testgetYearlist() {
		try{
			setUserContextDetails();
			APMDetails apmDetails = apmDetailsDAO.getYearlist();
		    List<BigInteger> FxRatePeriodyearList=new ArrayList<BigInteger>();
		    FxRatePeriodyearList=apmDetailsDAO.getYearlist().getFXRateHistoryAndCurrencySetup().getFXRateHistory().getFromYears();
			assertNotNull(apmDetails);
			assertNotNull(FxRatePeriodyearList);
		}catch (HWFServiceException e) {
				fail("Error while calling APMDetails Process");
			}
	}
	
	
	/**
	 * Test Method to invoke the Service for PaymentPeriod Details
	 * Test method for {@link com.ge.aloc.dao.impl.apm.APMDetailsDAO#openPaymentPeriod()}.
	 * 
	 */
	@Test
	public void testopenPaymentPeriod(){
		try{
			 setUserContextDetails();
			 APMDetails apmDetails = apmDetailsDAO.openPaymentPeriod();
			 assertNotNull(apmDetails);
			 assertNotNull(apmDetails.getPaymentPeriodDetails());
		}catch(HWFServiceException e){
			fail("Error while calling APMDetails Process");
		}	
	}
	
	

	/**
	 * Test Method to save the payment Period details
	 * Test method for {@link com.ge.aloc.dao.impl.apm.APMDetailsDAO#savePaymentPeriod()}.
	 * @throws ParseException 
	 * 
	 */
	@Test
	public void testsavePaymentPeriod() throws ParseException{
		try{
			  APMDetails apmDet = new APMDetails();
			  setUserContextDetails();
			  List<PaymentPeriodDetails> paymentPeriodDetails=new ArrayList<PaymentPeriodDetails>();
			  PaymentPeriodDetails firstpaymentperiod=new PaymentPeriodDetails();
			  firstpaymentperiod.setDayCount(new BigInteger("10"));
			  firstpaymentperiod.setMinPaymentAmountUSD(new BigDecimal("20"));
			  firstpaymentperiod.setPaymentPeriodStartDate(ALOCCommonHelper.convertStringToCal("10-Feb-2013"));
			  firstpaymentperiod.setPaymentPeriodEndDate(ALOCCommonHelper.convertStringToCal("10-Apr-2014"));
			  firstpaymentperiod.setPaymentPeriodCutoffDate(ALOCCommonHelper.convertStringToCal("1-Mar-2013"));
			  firstpaymentperiod.setFXRateRevalueDate(ALOCCommonHelper.convertStringToCal("10-Mar-2013"));
		      paymentPeriodDetails.add(firstpaymentperiod);
			  apmDet.setPaymentPeriodDetails(paymentPeriodDetails);
			  MsgHeader msgHeader=new MsgHeader();
			  msgHeader.setAuditCreator("999911248");
			  msgHeader.setAuditModifier("999911248");
			  APMDetails apmDetails = apmDetailsDAO.savePaymentPeriod(apmDet);
			  assertNotNull(apmDetails);
			  assertNotNull(apmDetails.getPaymentPeriodDetails());
		}catch(HWFServiceException e){
			fail("Error while calling APMDetails Process");
		}	
	}
	
	 /**
	   * Method to set the user context details 
	 */
	  private void setUserContextDetails()
	  {
		  List<String> rolesList = new ArrayList<String>();
		  rolesList.add("TreasuryAnalyst");
		  UserContext.getContext().getuserDetails().setUserId("999911248");
		  UserContext.getContext().getuserDetails().setLastName("TreasuryAnalyst_999911248");
		  UserContext.getContext().getuserDetails().setFirstName("Test_999911248");
		  UserContext.getContext().getuserDetails().setRoles(rolesList);
	  }
	  

}
