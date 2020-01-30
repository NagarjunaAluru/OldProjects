/**
 * 
 */
package com.ge.aloc.action.admin;

import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.common.AbstractTestCase;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.model.RecordRetention;
import com.ge.aloc.model.RetentionRecipient;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author sunil.yakkaluru
 *
 */
public class RecordsRetentionMgmtActionTest extends AbstractTestCase
{
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	/* (non-Javadoc)
	 * @see org.apache.struts2.StrutsTestCase#setUp()
	 */
	@Before
	protected void setUp() throws Exception {
		super.setUp();
		setUserContextDetails();
	}

	/* (non-Javadoc)
	 * @see org.apache.struts2.StrutsTestCase#tearDown()
	 */
	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	
	/**
	 * Test method for {@link com.ge.aloc.action.admin.RecordsRetentionMgmtAction#open()}.
	 */
	@Test
	public final void testopen()
	{
		RecordsRetentionMgmtAction retentionMgmtAction = getRecordRetentionAction("openRecordsRetentionManagement");
		try
		{
			retentionMgmtAction.open();
			assertNotNull(retentionMgmtAction);
		}catch (HWFServiceException e) {
			fail(ALOCConstants.TESTCASE_FIALED_ERROR_MESSAGE + e.getMessage());		
		}
	}
	
	/**
	 * Test method for {@link com.ge.aloc.action.admin.RecordsRetentionMgmtAction#modify()}.
	 */
	@Test
	public final void testmodify()
	{
		RecordsRetentionMgmtAction retentionMgmtAction = getRecordRetentionAction("saveRecordRetention");
		RecordRetention retention = new RecordRetention();
		try
		{
			retention.setOneTimeRunDate(Calendar.getInstance());
			retention.setScheduleFrequencyFlag(true);
			retention.setScheduleFrequencyID(11);
			retention.setYearsAfterExpiry(10);
			retention.setNextRunDate(Calendar.getInstance());
			retention.setApproximateNumberOfRecords("100");
			retention.setDateRangeOfRecordsPurged(Calendar.getInstance());
			retentionMgmtAction.setRecordRetention(retention);
			retentionMgmtAction.modify();
			assertNotNull(retentionMgmtAction);
		}catch (HWFServiceException e) {
			fail(ALOCConstants.TESTCASE_FIALED_ERROR_MESSAGE + e.getMessage());		
		}
	}
	
	/**
	 * Test method for {@link com.ge.aloc.action.admin.RecordsRetentionMgmtAction#submit()}.
	 */
	@Test
	public final void testsubmit()
	{
		RecordsRetentionMgmtAction retentionMgmtAction =getRecordRetentionAction("submitRecordRetention");
		RecordRetention retention = new RecordRetention();
		try
		{
			retention.setRetentionManagementId(81);
			retention.setStatus("Approve");
			retentionMgmtAction.setRecordRetention(retention);
			retentionMgmtAction.submit();
			assertNotNull(retentionMgmtAction);
		}catch (HWFServiceException e) {
			fail(ALOCConstants.TESTCASE_FIALED_ERROR_MESSAGE + e.getMessage());			
		}
	}
	
	/**
	 * Test method for {@link com.ge.aloc.action.admin.RecordsRetentionMgmtAction#openRecordsPurgeReport()}.
	 */
	@Test
	public final void testopenRecordsPurgeReport()
	{
		RecordsRetentionMgmtAction retentionMgmtAction = getRecordRetentionAction("openPurgeReport");
		try
		{
			retentionMgmtAction.openRecordsPurgeReport();
			assertNotNull(retentionMgmtAction);
		}catch (HWFServiceException e) {
			fail(ALOCConstants.TESTCASE_FIALED_ERROR_MESSAGE + e.getMessage());			
		}
	}
	
	/**
	 * Test method for {@link com.ge.aloc.action.admin.RecordsRetentionMgmtAction#sendRecordRetentionMgmt()}.
	 */
	@Test
	public final void testsendRecordRetentionMgmt()
	{
		RecordsRetentionMgmtAction retentionMgmtAction = getRecordRetentionAction("sendRectention");
		RecordRetention retention = new RecordRetention();
		try
		{
			RetentionRecipient retentionRecipient = new RetentionRecipient();
			retentionRecipient.setRecipientEmail("test@ge.com");
			retentionRecipient.setRecipientFirstName("SiteAdmin_999911186");
			retentionRecipient.setRecipientLastName("Test_999911186");
			retentionRecipient.setRecipientSsoId("999911186");
			retention.setRetentionRecipient(retentionRecipient);
			retentionMgmtAction.setRecordRetention(retention);
			retentionMgmtAction.sendRecordRetentionMgmt();
			assertNotNull(retentionMgmtAction);
		}catch (HWFServiceException e) {
			fail(ALOCConstants.TESTCASE_FIALED_ERROR_MESSAGE + e.getMessage());				
		}
	}
	
}
