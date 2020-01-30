/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: RecordsRetentionMgmtManagerTest.java
 * Purpose: RecordsRetentionMgmtManagerTest class used for records retention creation purpose.
 */
package com.ge.aloc.manager.impl.admin;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.dao.impl.DAOConnectionHelper;
import com.ge.aloc.dao.impl.admin.RecordsRetentionMgmtDAO;
import com.ge.aloc.model.RecordRetention;
import com.ge.aloc.model.RetentionRecipient;
import com.hydus.hwf.bw.service.IServiceClient;
import com.hydus.hwf.context.UserContext;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author sunil.yakkaluru
 *
 */
public class RecordsRetentionMgmtManagerTest
{
	private static IServiceClient serviceClient;
	private static RecordsRetentionMgmtManager recordsRetentionMgmtManager;
	private static RecordsRetentionMgmtDAO recordsRetentionMgmtDAO;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		serviceClient = DAOConnectionHelper.getServiceClient();
		recordsRetentionMgmtManager = new RecordsRetentionMgmtManager(); 
		recordsRetentionMgmtDAO = new RecordsRetentionMgmtDAO();
		recordsRetentionMgmtDAO.setServiceClient(serviceClient);
		recordsRetentionMgmtManager.setRecordRetentionMgmtDAO(recordsRetentionMgmtDAO);
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
	 * Test method for {@link com.ge.aloc.manager.impl.admin.RecordsRetentionMgmtManager#modify(com.ge.aloc.model.RecordRetention)}.
	 */
	@Test
	public final void testOpen(){
		RecordRetention recordRetention =  new RecordRetention();
		try{
			recordRetention = recordsRetentionMgmtManager.open();
			assertNotNull(recordRetention);
			
		}catch (HWFServiceException e) {
			assertNotNull(recordRetention);			
		}
	}
	
	/**
	 * Test method for {@link com.ge.aloc.manager.impl.admin.RecordsRetentionMgmtManager#modify(com.ge.aloc.model.RecordRetention)}.
	 */
	@Test
	public final void testModify(){
		RecordRetention recordRetention =  new RecordRetention();
		try{
			recordRetention.setYearsAfterExpiry(1);
			recordRetention.setScheduleFrequencyFlag(true);
			recordRetention.setScheduleFrequencyID(1);
			recordRetention.setNextRunDate(Calendar.getInstance());
			recordRetention.setApproximateNumberOfRecords("10");
			recordRetention.setDateRangeOfRecordsPurged(Calendar.getInstance());
			recordRetention = recordsRetentionMgmtManager.modify(recordRetention);
			assertNotNull(recordRetention);
			
		}catch (HWFServiceException e) {
			assertNotNull(recordRetention);			
		}
	}
	
	/**
	 * Test method for {@link com.ge.aloc.manager.impl.admin.RecordsRetentionMgmtManager#modify(com.ge.aloc.model.RecordRetention)}.
	 */
	@Test
	public final void testModifyWithOneTimeRun(){
		RecordRetention recordRetention =  new RecordRetention();
		try{
			recordRetention.setScheduleFrequencyID(1);
			recordRetention.setYearsAfterExpiry(1);
			recordRetention.setScheduleFrequencyFlag(false);
			recordRetention.setOneTimeRunDate(Calendar.getInstance());
			recordRetention.setNextRunDate(Calendar.getInstance());
			recordRetention.setApproximateNumberOfRecords("10");
			recordRetention.setDateRangeOfRecordsPurged(Calendar.getInstance());
			recordRetention = recordsRetentionMgmtManager.modify(recordRetention);
			assertNotNull(recordRetention);
			
		}catch (HWFServiceException e) {
			assertNotNull(recordRetention);			
		}
	}
	
	/**
	 * Test method for {@link com.ge.aloc.manager.impl.admin.RecordsRetentionMgmtManager#submit(com.ge.aloc.model.RecordRetention)}.
	 */
	@Test
	public final void testSubmit(){
		RecordRetention recordRetention =  new RecordRetention();
		try{
			recordRetention.setYearsAfterExpiry(1);
			recordRetention.setScheduleFrequencyFlag(true);
			recordRetention.setScheduleFrequencyID(1);
			recordRetention.setOneTimeRunDate(Calendar.getInstance());
			recordRetention.setNextRunDate(Calendar.getInstance());
			recordRetention.setApproximateNumberOfRecords("10");
			recordRetention.setDateRangeOfRecordsPurged(Calendar.getInstance());
			recordRetention.setStatus("1");
			recordRetention = recordsRetentionMgmtManager.submit(recordRetention);
			assertNotNull(recordRetention);
			
		}catch (HWFServiceException e) {
			assertNotNull(recordRetention);			
		}
	}
	
	/**
	 * Test method for {@link com.ge.aloc.manager.impl.admin.RecordsRetentionMgmtManager#openRecordsPurgeReport(com.ge.aloc.model.RecordRetention)}.
	 */
	@Test
	public final void testopenRecordsPurgeReport(){
		RecordRetention recordRetention =  new RecordRetention();
		try{
			recordRetention = recordsRetentionMgmtManager.openRecordsPurgeReport();
			assertNotNull(recordRetention);
		}catch (HWFServiceException e) {
			assertNotNull(recordRetention);			
		}
	}
	
	/**
	 * Test method for {@link com.ge.aloc.manager.impl.admin.RecordsRetentionMgmtManager#sendRecordRetentionMgmt(com.ge.aloc.model.RecordRetention)}.
	 */
	@Test
	public final void testSendRecordRetentionMgmt() {
		RecordRetention recordRetention = new RecordRetention(); 		
		try {		
			RetentionRecipient retentionRecipient = new RetentionRecipient();
			retentionRecipient.setRecipientSsoId("999911171");
			retentionRecipient.setRecipientEmail("test@ge.com");
			retentionRecipient.setRecipientFirstName("first name");
			retentionRecipient.setRecipientLastName("last name");
			recordRetention.setRetentionRecipient(retentionRecipient);
			recordRetention = recordsRetentionMgmtManager.sendRecordRetentionMgmt(recordRetention);			
			assertNotNull(recordRetention);
		} catch (HWFServiceException e) {
			assertNotNull(recordRetention);			
		}
	}


}
