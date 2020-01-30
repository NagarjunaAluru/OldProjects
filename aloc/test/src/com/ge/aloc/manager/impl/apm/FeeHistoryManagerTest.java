/**
 * 
 */
package com.ge.aloc.manager.impl.apm;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.dao.impl.DAOConnectionHelper;
import com.ge.aloc.dao.impl.apm.FeeHistoryDAO;
import com.ge.aloc.model.APMDetails;
import com.hydus.hwf.bw.service.IServiceClient;
import com.hydus.hwf.context.UserContext;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author nagarjuna.aluru
 *
 */
public class FeeHistoryManagerTest {
	private static IServiceClient serviceClient;
	private static FeeHistoryDAO feeHistoryDAO;
	private static FeeHistoryManager feeHistoryManager;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		serviceClient = DAOConnectionHelper.getServiceClient();
		feeHistoryDAO = new FeeHistoryDAO();
		feeHistoryManager=new FeeHistoryManager();
		feeHistoryDAO.setServiceClient(serviceClient);
		feeHistoryManager.setFeeHistoryDAO(feeHistoryDAO);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		serviceClient = null;
		feeHistoryDAO = null;
		feeHistoryManager = null;
	}

	/**
	 * This method is used to get FeeHistory Details
	 * Test method for {@link com.ge.aloc.manager.impl.apm.FeeHistoryManager#searchFeeHistory()}.
	 */
	@Test
	public void testSearchFeeHistory() {
		setUserContextDetails();
		try{
			APMDetails apmDetails=feeHistoryManager.searchFeeHistory();
			assertNotNull(apmDetails);
			assertNotNull(apmDetails.getFeeHistoryDetails().getFullSummaries());
		}catch(HWFServiceException e){
			fail("Error while calling APMDetails Process");
		}	
	}

	/**
	 * THis method id used to get Invoice details
	 * Test method for {@link com.ge.aloc.manager.impl.apm.FeeHistoryManager#exportInvoiceFeeHistory(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testExportInvoiceFeeHistory() {
		setUserContextDetails();
		try{
			String alocRecNos = "7465";
			String paymentIds = "1";
			APMDetails apmDetails=feeHistoryManager.exportInvoiceFeeHistory(alocRecNos, paymentIds);
			assertNotNull(apmDetails);
			assertNotNull(apmDetails.getFeeHistoryDetails().getInvoiceDetails());
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
