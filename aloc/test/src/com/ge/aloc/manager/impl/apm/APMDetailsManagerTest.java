/**
 * 
 */
package com.ge.aloc.manager.impl.apm;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.dao.impl.DAOConnectionHelper;
import com.ge.aloc.dao.impl.apm.APMDetailsDAO;
import com.ge.aloc.model.APMDetails;
import com.ge.aloc.model.BUCAndADN;
import com.ge.aloc.model.FeePaymentRunDetails;
import com.ge.aloc.model.FeePeriodDetails;
import com.ge.aloc.model.MsgHeader;
import com.ge.aloc.model.PaymentPeriodDetails;
import com.ge.aloc.util.ALOCCommonHelper;
import com.hydus.hwf.bw.service.IServiceClient;
import com.hydus.hwf.context.UserContext;
import com.hydus.hwf.exceptions.HWFServiceException;


/**
 * @author bhuvaneswari.a
 *
 */
public class APMDetailsManagerTest{
	private static IServiceClient serviceClient;
	private static APMDetailsDAO apmDetailsDAO;
	private static APMDetailsManager apmDetailsManager;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		serviceClient = DAOConnectionHelper.getServiceClient();
		apmDetailsDAO = new APMDetailsDAO();
		apmDetailsManager=new APMDetailsManager();
		apmDetailsDAO.setServiceClient(serviceClient);
		apmDetailsManager.setApmDetailsDAO(apmDetailsDAO);
	}


	/**
	 *  test Method to open PaymentPeriod 
	 * Test method for {@link com.ge.aloc.dao.impl.apm.APMDetailsManager#openPaymentPeriod()}.
	 * 
	 */
	@Test
	public void testopenPaymentPeriod(){
		setUserContextDetails();
		try{
			APMDetails apmDetails=apmDetailsManager.openPaymentPeriod();
			assertNotNull(apmDetails);
			 assertNotNull(apmDetails.getPaymentPeriodDetails());
		}catch(HWFServiceException e){
			fail("Error while calling APMDetails Process");
		}	
	}
	
	
	/**
	 * test Method to save Payment Period
	 * Test method for {@link com.ge.aloc.dao.impl.apm.APMDetailsManager#savePaymentPeriod()}.
	 * @throws ParseException 
	 * 
	 */
	@Test
	public void testsavePaymentPeriod() throws ParseException{
		try{
			  PaymentPeriodDetails firstpaymentperiod=getpaymentPeriod();
			  setMsgHeader();
			  setUserContextDetails();
			  APMDetails apmDetails = apmDetailsManager.savePaymentPeriod(firstpaymentperiod);
			  assertNotNull(apmDetails);
			  assertNotNull(apmDetails.getPaymentPeriodDetails());
		}catch(HWFServiceException e){
			fail("Error while calling APMDetails Process");
		}	
	}
	
	
	/**
	 * test Method to cancel Payment Period row
	 * Test method for {@link com.ge.aloc.dao.impl.apm.APMDetailsManager#cancel()}.
	 * @throws ParseException 
	 * 
	 */
	@Test
	public void testcancel() throws ParseException{
		PaymentPeriodDetails firstpaymentperiod=getpaymentPeriod();
		  List<PaymentPeriodDetails> paymentperiodList=new ArrayList<PaymentPeriodDetails>();
		  paymentperiodList.add(firstpaymentperiod);
		  String apmConfigID="0";
		  setMsgHeader();
		  setUserContextDetails();
		  firstpaymentperiod = apmDetailsManager.cancel(paymentperiodList,apmConfigID);
		  assertNotNull(firstpaymentperiod);
	}
	
	/**
	 * to test Method save TwoRowPayment
	 * Test method for {@link com.ge.aloc.dao.impl.apm.APMDetailsManager#savePaymentPeriodTwoRow()}.
	 * @throws ParseException 
	 * 
	 */
	@Test
	public void testsavePaymentPeriodTwoRow() throws HWFServiceException,ParseException{
		//to do to set the parameters to request
			
	}
	
	/**
	 * test Method  to get the FX Rates 
	 * Test method for {@link com.ge.aloc.dao.impl.apm.APMDetailsManager#getFxRates()}.
	 */
	@Test
	public void testGetFxRates() {
		try{
			String feePeriodId="1";
			setUserContextDetails();
			APMDetails apmDetails = apmDetailsManager.getFxRates(feePeriodId);
			assertNotNull(apmDetails);
		}catch (HWFServiceException e) {
				fail("Error while calling get fx rates");
			}
	}
	
	
	/**
	 * test Method to  download the FX Rates  
	 * Test method for {@link com.ge.aloc.dao.impl.apm.APMDetailsManager#downloadFxRates()}.
	 */
	@Test
	public void testdownloadFxRates() {
		try{
			setUserContextDetails();
			APMDetails apmDetails = apmDetailsManager.downloadFxRates("120");
			assertNotNull(apmDetails);
		}catch (HWFServiceException e) {
				fail("Error while downloading fx rates");
			}
	}
	
	

	/**
	 * test method to get the year list
	 * Test method for {@link com.ge.aloc.dao.impl.apm.APMDetailsManager#testgetYearlist()}.
	 */
	@Test
	public void testgetYearlist() {
		try{
			setUserContextDetails();
			List<BigInteger> FxRatePeriodyearList=new ArrayList<BigInteger>();
			FxRatePeriodyearList = apmDetailsManager.getYearlist();
			assertNotNull(FxRatePeriodyearList);
		}catch (HWFServiceException e) {
				fail("Error while getting fx rate year list");
			}
	}
	

	/**
	 * test Method to open the FX Rate History Page 
	 * Test method for {@link com.ge.aloc.dao.impl.apm.APMDetailsManager#openFXRateHistory()}.
	 */
	@Test
	public void testOpenFXRateHistory() {
		//to do to set the parameters to request
	}
	
	
	/**
	 * test Method to open FeePaymentRun screen
	 * Test method for {@link com.ge.aloc.dao.impl.apm.APMDetailsManager#openFeePaymentRun()}.
	 */
	@Test
	public void testOpenFeePaymentRun() {
		
		try {
			setUserContextDetails();
			APMDetails apmDetails = apmDetailsManager.openFeePaymentRun();
			assertNotNull(apmDetails);
		} catch (HWFServiceException e) {
			fail("Error while calling open FeePaymentRun");
		}
	}
	
	/**
	 * test Method to get CalculateFee Details
	 * Test method for {@link com.ge.aloc.dao.impl.apm.APMDetailsManager#getCalculateFeesDetails()}.
	 */
	@Test
	public void testGetCalculateFeesDetails() {
		
		try {
			setUserContextDetails();
			APMDetails apmDetails = new APMDetails();
			FeePaymentRunDetails feeRun = new FeePaymentRunDetails();
			FeePeriodDetails feePeroid = new FeePeriodDetails();
			feePeroid.setAPMConfigID(new BigInteger("90"));
			Calendar cal = Calendar.getInstance();
			cal.set(2013, 12, 28);
			feePeroid.setPeriodCuttOffDate(cal);
			Calendar cal1 = Calendar.getInstance();
			cal1.set(2013, 05, 10);
			feePeroid.setPeriodStartDate(cal1);
			feePeroid.setPeriodEndDate(cal);
			feeRun.setFeePeriodDetails(feePeroid);
			apmDetails.setFeePaymentRunDetails(feeRun);
			APMDetails apmDet = apmDetailsManager.getCalculateFeesDetails(apmDetails);
			assertNotNull(apmDet);
		} catch (HWFServiceException e) {
			fail("Error while calling Fee Calculation Details");
		}
	}
	
	/**
	 * test Method to get APMDetails to show fee summary details
	 * Test method for {@link com.ge.aloc.dao.impl.apm.APMDetailsManager#getFeeSummaryDetails()}.
	 */
	@Test
	public void testGetFeeSummaryDetails() {
		//to do to set the parameters to request
		
	}
	
	 /**
	   * Method to set the message header
	 */
	private MsgHeader setMsgHeader(){
		 MsgHeader msgHeader=new MsgHeader();
		 msgHeader.setAuditCreator("999911248");
		 msgHeader.setAuditModifier("999911248");
		return msgHeader;
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
	  
	  
	  /**
		 * method for populating data to payment period bean}.
		 * @throws ParseException 
		 */ 
	  private PaymentPeriodDetails getpaymentPeriod() throws ParseException{
		    PaymentPeriodDetails firstpaymentperiods=new PaymentPeriodDetails();
			firstpaymentperiods.setDayCount(new BigInteger("10"));
			firstpaymentperiods.setMinPaymentAmountUSD(new BigDecimal("20"));
			firstpaymentperiods.setPaymentPeriodStartDate(ALOCCommonHelper.convertStringToCal("10-Feb-2013"));
			firstpaymentperiods.setPaymentPeriodEndDate(ALOCCommonHelper.convertStringToCal("10-Apr-2014"));
			firstpaymentperiods.setPaymentPeriodCutoffDate(ALOCCommonHelper.convertStringToCal("1-Mar-2013"));
			firstpaymentperiods.setFXRateRevalueDate(ALOCCommonHelper.convertStringToCal("10-Mar-2013"));
			return firstpaymentperiods;
	  }
	  
	  /**
	   * This method is used to get the requests with invalid BUC ADN values
	   * Test method for {@link com.ge.aloc.manager.impl.apm.APMDetailsManager#getBUCADNDetails()}.
	   */
	  @Test
	  public void testGetBUCADNDetails() {
			try {  
					setUserContextDetails();
					APMDetails apmDetails = apmDetailsManager.getBUCADNDetails("AAA","BBB",new BigInteger("341"));
					assertNotNull(apmDetails);
					assertNotNull(apmDetails.getBUCAndADNs());
			} catch (HWFServiceException e) {
				fail("Error while retrieving the requests with invalid BUC ADN values");
			}
		}

	 /**
	  * This method is used to update the requests with valid BUC ADN values
	  * Test method for {@link com.ge.aloc.manager.impl.apm.APMDetailsManager#updateBUCADNDetails()}.
	  */
	  @Test
	  public void testUpdateBUCADNDetails() {
			try {
					setUserContextDetails();
					BUCAndADN bucAndADN = new BUCAndADN();
					bucAndADN.setBUC("BUC_101");
					bucAndADN.setADN("ADN_101");
					bucAndADN.setRequestId(new BigInteger("7231"));
					bucAndADN.setUpdateFlag(true);
					List<BUCAndADN> bucAndADNList = new ArrayList<BUCAndADN>();
					bucAndADNList.add(bucAndADN);
					apmDetailsManager.updateBUCADNDetails(bucAndADNList,"ADI267","ADIDEBITNOTE",new BigInteger("8"));
					assertNotNull(bucAndADNList);
			} catch (HWFServiceException e) {
				fail("Error while updating the requests with valid BUC ADN values");
			}
	 }
}