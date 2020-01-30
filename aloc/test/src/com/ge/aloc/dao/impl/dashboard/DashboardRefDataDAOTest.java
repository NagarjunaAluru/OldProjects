/**
 * 
 */
package com.ge.aloc.dao.impl.dashboard;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.OpCode;
import com.ge.aloc.dao.impl.DAOConnectionHelper;
import com.ge.aloc.model.ActionLog;
import com.ge.aloc.model.MsgHeader;
import com.ge.aloc.model.ReqContactInfo;
import com.ge.aloc.model.RequestDetails;
import com.hydus.hwf.bw.service.IServiceClient;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author arijit.biswas
 *
 */
public class DashboardRefDataDAOTest {
	private static IServiceClient serviceClient;
	private static RequestDetails requestDetail;
	private static ActionLog actionLog;
	private static DashboardRefDataDAO dashboardRefDataDAO;
	private static MsgHeader msgHeader;
	private static List<ActionLog> actionLogs;
	private static ReqContactInfo reqContactInfo;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		serviceClient = DAOConnectionHelper.getServiceClient();		
		dashboardRefDataDAO = new DashboardRefDataDAO();
		dashboardRefDataDAO.setServiceClient(serviceClient);
		requestDetail = new RequestDetails();
		msgHeader = new MsgHeader();
		actionLogs = new ArrayList<ActionLog>();
		reqContactInfo = new ReqContactInfo();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		requestDetail = null;
		dashboardRefDataDAO = null;
		msgHeader = null;
		actionLogs = null;
	}

	/**
	 * Test method for {@link com.ge.aloc.dao.impl.dashboard.DashboardRefDataDAO#getActionLog(com.ge.aloc.model.RequestDetails)}.
	 */
	@Test
	public void testGetActionLog() {
		String requestId = null;
		assertNull(requestId);
		requestId = "3908";
		assertNotNull(requestId);
		assertEquals("3908", requestId);
		
		assertNotNull(requestDetail);
		assertNull(requestDetail.getRequestId());
		requestDetail.setRequestId(new BigInteger(requestId));
		assertNotNull(requestDetail.getRequestId());
		assertEquals(requestId, requestDetail.getRequestId());
		try {
			actionLogs = dashboardRefDataDAO.getActionLog(actionLog);
			assertNull(actionLogs);
			assertEquals("ActionLog Success Message","Action Log Success");
		} catch (Exception e) {
			fail("Error while getting Action Log");
		}
		try {
			actionLogs = dashboardRefDataDAO.getActionLog(null);
		} catch (HWFServiceException e) {
			assertNotNull(e);
			assertEquals("ActionLog Error Message",e.getMessage());
		}
	}
	
	/**
	 * Test method for {@link com.ge.aloc.dao.impl.dashboard.DashboardRefDataDAO#getReqContactInfo(com.ge.aloc.model.ReqContactInfo)}.
	 */
	@Test
	public void testGetReqContactInfo() {
		String requestId = null;
		String operationCode = null;
		assertNull(requestId);
		assertNull(operationCode);
		requestId = "3908";
		operationCode = OpCode.REQCONTACTDTLS.getOperationCode();
		assertNotNull(requestId);
		assertNotNull(operationCode);
		assertEquals("3908", requestId);
		assertEquals("REQCONTACTDTLS", operationCode);
		
		assertNotNull(msgHeader);
		assertNull(msgHeader.getOpcode());
		msgHeader.setOpcode(operationCode);
		assertNotNull(msgHeader.getOpcode());
		assertEquals(operationCode,msgHeader.getOpcode());
		reqContactInfo.setMsgHeader(msgHeader);
		reqContactInfo.setAlocRequestId(new BigInteger(requestId));
		assertNotNull(reqContactInfo);
		assertNull(reqContactInfo.getMsgHeader());
		
		try {
			ReqContactInfo expReqContactInfo = dashboardRefDataDAO.getReqContactInfo(reqContactInfo);
			assertNull(expReqContactInfo);
			assertEquals("Request Contact Details Success Message","Request Contact Details Success");
		} catch (Exception e) {
			fail("Error while getting Request Contact Details");
		}
	}
	
	/**
	 * Test method for {@link com.ge.aloc.dao.impl.dashboard.DashboardRefDataDAO#getTreasuryBidRequestContactInfo(com.ge.aloc.model.ReqContactInfo)}.
	 */
	@Test
	public void testGetTreasuryBidRequestContactInfo() {
		String requestId = null;
		String operationCode = null;
		assertNull(requestId);
		assertNull(operationCode);
		requestId = "3908";
		operationCode = OpCode.REQCONTACTDTLS.getOperationCode();
		assertNotNull(requestId);
		assertNotNull(operationCode);
		assertEquals("3908", requestId);
		assertEquals("REQCONTACTDTLS", operationCode);
		
		assertNotNull(msgHeader);
		assertNull(msgHeader.getOpcode());
		msgHeader.setOpcode(operationCode);
		assertNotNull(msgHeader.getOpcode());
		assertEquals(operationCode,msgHeader.getOpcode());
		reqContactInfo.setMsgHeader(msgHeader);
		reqContactInfo.setAlocRequestId(new BigInteger(requestId));
		assertNotNull(reqContactInfo);
		assertNull(reqContactInfo.getMsgHeader());
		
		try {
			ReqContactInfo expReqContactInfo = dashboardRefDataDAO.getReqContactInfo(reqContactInfo);
			assertNull(expReqContactInfo);
			assertEquals("Request Contact Details Success Message","Request Contact Details Success");
		} catch (Exception e) {
			fail("Error while getting Request Contact Details");
		}
	}
}
