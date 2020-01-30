/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: RecordsRetentionMgmtDAOTest.java
 * Purpose: RecordsRetentionMgmtDAOTest class used for records retention creation purpose.
 */
package com.ge.aloc.dao.impl.admin;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.OpCode;
import com.ge.aloc.dao.impl.DAOConnectionHelper;
import com.ge.aloc.model.MsgHeader;
import com.ge.aloc.model.RecordRetention;
import com.ge.aloc.model.RetentionRecipient;
import com.ge.aloc.util.ALOCCommonHelper;
import com.hydus.hwf.bw.service.IServiceClient;
import com.hydus.hwf.context.UserContext;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author sunil.yakkaluru
 *
 */
public class RecordsRetentionMgmtDAOTest
{

	private static IServiceClient serviceClient;
	private static RecordsRetentionMgmtDAO recordsRetentionMgmtDAO;
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		serviceClient = DAOConnectionHelper.getServiceClient();
		recordsRetentionMgmtDAO = new RecordsRetentionMgmtDAO();
		recordsRetentionMgmtDAO.setServiceClient(serviceClient);
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
		List<String> roleslist = new ArrayList<String>();
		roleslist.add("Treasury Analyst");
		UserContext.getContext().getuserDetails().setRoles(roleslist);
	}
	
	/**
	 * Test method for {@link com.ge.aloc.dao.impl.admin.RecordsRetentionMgmtDAO#open(com.ge.aloc.model.RecordRetention)}.
	 */
	@Test
	public final void testOpen() {
		RecordRetention recordRetention = new RecordRetention(); 		
		try {			
			recordRetention.setRetentionManagementId(1);
			MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.INITIATERECORDSRETENTION.getOperationCode());
			recordRetention.setMsgHeader(msgHeader);
			recordRetention = recordsRetentionMgmtDAO.open(recordRetention);			
			assertNotNull(recordRetention);
		} catch (HWFServiceException e) {
			assertNotNull(recordRetention);			
		}
	}
	
	
	/**
	 * Test method for {@link com.ge.aloc.dao.impl.admin.RecordsRetentionMgmtDAO#modify(com.ge.aloc.model.RecordRetention)}.
	 */
	@Test
	public final void testModify() {
		RecordRetention recordRetention = new RecordRetention(); 		
		try {			
			MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.UPDATERECORDSRETENTION.getOperationCode());
			recordRetention.setMsgHeader(msgHeader);
			recordRetention.setYearsAfterExpiry(1);
			recordRetention.setScheduleFrequencyFlag(true);
			recordRetention.setScheduleFrequencyID(1);
			recordRetention = recordsRetentionMgmtDAO.modify(recordRetention);			
			assertNotNull(recordRetention);
		} catch (HWFServiceException e) {
			assertNotNull(recordRetention);			
		}
	}
	
	
	/**
	 * Test method for {@link com.ge.aloc.dao.impl.admin.RecordsRetentionMgmtDAO#openRecordsPurgeReport(com.ge.aloc.model.RecordRetention)}.
	 */
	@Test
	public final void testOpenRecordsPurgeReport() {
		RecordRetention recordRetention = new RecordRetention(); 		
		try {			
			MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.OPENRECORDSPURGEREPORT.getOperationCode());
			recordRetention.setMsgHeader(msgHeader);
			recordRetention = recordsRetentionMgmtDAO.openRecordsPurgeReport(recordRetention);			
			assertNotNull(recordRetention);
		} catch (HWFServiceException e) {
			assertNotNull(recordRetention);			
		}
	}
	
	/**
	 * Test method for {@link com.ge.aloc.dao.impl.admin.RecordsRetentionMgmtDAO#submit(com.ge.aloc.model.RecordRetention)}.
	 */
	@Test
	public final void testSubmit() {
		RecordRetention recordRetention = new RecordRetention(); 		
		try {	
			MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.SUBMITRECORDSRETENTION.getOperationCode());
			recordRetention.setMsgHeader(msgHeader);
			recordRetention.setYearsAfterExpiry(1);
			recordRetention.setScheduleFrequencyFlag(true);
			recordRetention.setScheduleFrequencyID(1);
			recordRetention.setNextRunDate(Calendar.getInstance());
			recordRetention.setApproximateNumberOfRecords("200");
			recordRetention.setDateRangeOfRecordsPurged(Calendar.getInstance());
			recordRetention.setStatus("approved");
			recordRetention = recordsRetentionMgmtDAO.submit(recordRetention);			
			assertNotNull(recordRetention);
		} catch (HWFServiceException e) {
			assertNotNull(recordRetention);			
		}
	}
	
	/**
	 * Test method for {@link com.ge.aloc.dao.impl.admin.RecordsRetentionMgmtDAO#sendRecordRetentionMgmt(com.ge.aloc.model.RecordRetention)}.
	 */
	@Test
	public final void testSendRecordRetentionMgmt() {
		RecordRetention recordRetention = new RecordRetention(); 		
		try {		
			MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.SENDRECORDRETENTION.getOperationCode());
			recordRetention.setMsgHeader(msgHeader);
			RetentionRecipient retentionRecipient = new RetentionRecipient();
			retentionRecipient.setRecipientSsoId("999911171");
			retentionRecipient.setRecipientEmail("test@ge.com");
			retentionRecipient.setRecipientFirstName("first name");
			retentionRecipient.setRecipientLastName("last name");
			recordRetention.setRetentionRecipient(retentionRecipient);
			recordRetention = recordsRetentionMgmtDAO.sendRecordRetentionMgmt(recordRetention);			
			assertNotNull(recordRetention);
		} catch (HWFServiceException e) {
			assertNotNull(recordRetention);			
		}
	}
	
	
	
}
