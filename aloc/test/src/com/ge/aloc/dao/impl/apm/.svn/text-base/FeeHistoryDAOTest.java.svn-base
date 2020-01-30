/**
 * 
 */
package com.ge.aloc.dao.impl.apm;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ge.aloc.dao.impl.DAOConnectionHelper;
import com.ge.aloc.model.APMDetails;
import com.ge.aloc.model.FeeHistoryDetails;
import com.ge.aloc.model.FullSummary;
import com.hydus.hwf.bw.service.IServiceClient;
import com.hydus.hwf.context.UserContext;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author nagarjuna.aluru
 *
 */
public class FeeHistoryDAOTest {
	private static IServiceClient serviceClient;
	private static FeeHistoryDAO feeHistoryDAO;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		serviceClient = DAOConnectionHelper.getServiceClient();
		feeHistoryDAO = new FeeHistoryDAO();
		feeHistoryDAO.setServiceClient(serviceClient);
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		feeHistoryDAO = null;
	}

	/**
	 * This method is used to get FeeHistory Details
	 * Test method for {@link com.ge.aloc.dao.impl.apm.FeeHistoryDAO#searchFeeHistory()}.
	 */
	@Test
	public void testSearchFeeHistory() {
		try {
			setUserContextDetails();
			APMDetails apmDetails = feeHistoryDAO.searchFeeHistory();
			assertNotNull(apmDetails);
			assertNotNull(apmDetails.getFeeHistoryDetails().getFullSummaries());
	} catch (HWFServiceException e) {
		fail("Error while retrieving apmDetails values");
	}
	}

	/**
	 * This method is used to get FeeHistory Invoice Details
	 * Test method for {@link com.ge.aloc.dao.impl.apm.FeeHistoryDAO#exportInvoiceFeeHistory(com.ge.aloc.model.APMDetails)}.
	 */
	@Test
	public void testExportInvoiceFeeHistory() {
		try {
			setUserContextDetails();
			APMDetails apmDet = new APMDetails();
			FeeHistoryDetails feeDet = new FeeHistoryDetails();
			List<FullSummary> summaryLst = new ArrayList<FullSummary>();
			FullSummary summary = new FullSummary();
			summary.setALOCRecordNumber(new BigInteger("7465"));
			summary.setPaymentID("1");
			summaryLst.add(summary);
			feeDet.setFullSummaries(summaryLst);
			apmDet.setFeeHistoryDetails(feeDet);
			APMDetails apmDetails = feeHistoryDAO.exportInvoiceFeeHistory(apmDet);
			assertNotNull(apmDetails);
			assertNotNull(apmDetails.getFeeHistoryDetails().getInvoiceDetails());
	} catch (HWFServiceException e) {
		fail("Error while retrieving apmDetails values");
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
