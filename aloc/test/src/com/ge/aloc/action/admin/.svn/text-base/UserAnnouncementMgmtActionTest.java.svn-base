/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: UserAnnouncementMgmtActionTest.java
 * Purpose: UserAnnouncementMgmtActionTest class used for user announcement agreement creation purpose.
 */
package com.ge.aloc.action.admin;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.bo.UserAnnouncementBO;
import com.ge.aloc.common.AbstractTestCase;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.model.Attachment;
import com.ge.aloc.model.RoleSelection;
import com.ge.aloc.model.UserAnnouncement;
import com.hydus.hwf.exceptions.HWFServiceException;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author sunil.yakkaluru
 *
 */
public class UserAnnouncementMgmtActionTest extends AbstractTestCase
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
	 * Test method for {@link com.ge.aloc.action.admin.UserAnnouncementMgmtAction#getRolesAnnouncement()}.
	 */
	@Test
	public final void testgetRolesAnnouncement()
	{
		 UserAnnouncementMgmtAction userAnnouncementMgmtAction = getUserAnnoucementAction("createUserAnnouncement");
		 assertNotNull(userAnnouncementMgmtAction.createUserAnnouncement());		
	}
	
	/**
	 * Test method for {@link com.ge.aloc.action.admin.UserAnnouncementMgmtAction#loadUserAnnouncementDetailsById()}.
	 */
	@Test
	public final void testloadUserAnnouncementDetailsById()
	{
	    UserAnnouncementMgmtAction userAnnouncementMgmtAction = getUserAnnoucementAction("loadUserAnnouncement");		
		try
		{
			userAnnouncementMgmtAction.setUserAnnouncementId(143);
			String userannouncement =  userAnnouncementMgmtAction.loadUserAnnouncement();
			assertNotNull(userannouncement);
		}catch (HWFServiceException e) {
			fail(ALOCConstants.TESTCASE_FIALED_ERROR_MESSAGE + e.getMessage());			
		}
	}
	
	/**
	 * Test method for {@link com.ge.aloc.action.admin.UserAnnouncementMgmtAction#createOrUpdateUserAnnouncement()}.
	 */
	@Test
	public final void testcreateOrUpdateUserAnnouncement()
	{
		 UserAnnouncementMgmtAction userAnnouncementMgmtAction = getUserAnnoucementAction("createOrUpdateUserAnnouncement");
		UserAnnouncement userAnnouncement =  new UserAnnouncement();
		try
		{
			userAnnouncement.setUserAnnouncementID(143);
			userAnnouncement.setMessageContent("message content");
			List<BigDecimal> siteSelections = new ArrayList<BigDecimal>();
			siteSelections.add(new BigDecimal(1));
			siteSelections.add(new BigDecimal(2));
			userAnnouncement.setSiteSelections(siteSelections);
			
			List<RoleSelection> roleSelections = new ArrayList<RoleSelection>();
			RoleSelection roleSelection = new RoleSelection();
			roleSelection.setRoleId(2);
			roleSelection.setRoleName("SiteAdmin");
			roleSelections.add(roleSelection);
			userAnnouncement.setRoleSelections(roleSelections);
			
			userAnnouncement.setStartDate(Calendar.getInstance());
			userAnnouncement.setEndDate(Calendar.getInstance());
			userAnnouncement.setAttachments(new ArrayList<Attachment>());			
			UserAnnouncementBO userAnnouncementBO = new UserAnnouncementBO(userAnnouncement);
			ActionContext.getContext().getSession().put(ALOCConstants.USERANNCOUNCEMENT,userAnnouncementBO);
			userAnnouncementMgmtAction.getUserAnnouncementBO();		
		    userAnnouncementMgmtAction.saveUserAnnouncement();
		}catch (Exception e) {
			fail(ALOCConstants.TESTCASE_FIALED_ERROR_MESSAGE + e.getMessage());		
		}
	}
	
	
	/**
	 * Test method for {@link com.ge.aloc.action.admin.UserAnnouncementMgmtAction#loadActiveAnnouncement()}.
	 */
	@Test
	public final void testloadActiveAnnouncement()
	{
		 UserAnnouncementMgmtAction userAnnouncementMgmtAction = getUserAnnoucementAction("loadActiveAnnouncement");
		 try {
			 String activeAnnouncements = userAnnouncementMgmtAction.loadActiveAnnouncement();
			 assertNotNull(activeAnnouncements);
		} catch (HWFServiceException e) {
			fail(ALOCConstants.TESTCASE_FIALED_ERROR_MESSAGE + e.getMessage());	
		}
	}
	
	/**
	 * Test method for {@link com.ge.aloc.action.admin.UserAnnouncementMgmtAction#deleteAnnouncement()}.
	 */
	@Test
	public final void testdeleteAnnouncement()
	{
		 UserAnnouncementMgmtAction userAnnouncementMgmtAction = getUserAnnoucementAction("deleteAnnouncement");
		 userAnnouncementMgmtAction.setUserAnnouncementId(145);		
		try
		{			
		    userAnnouncementMgmtAction.deleteAnnouncement();
		}catch (Exception e) {
			fail(ALOCConstants.TESTCASE_FIALED_ERROR_MESSAGE + e.getMessage());		
		}
	}
	
	/**
	 * 
	 * @throws Exception 
	 */
	@Test
	public final void testdownloadAttachment() throws Exception{		
		UserAnnouncementMgmtAction userAnnouncementMgmtAction = getUserAnnoucementAction("downloadAttachment");
		userAnnouncementMgmtAction.loadActiveAnnouncement();
		request.setParameter(ALOCConstants.PARAM_GELIBFILEID,"3000446777761031");	
		request.setParameter(ALOCConstants.ANNOUNCEMENTTYPE,"activeAnnouncements");
		request.setParameter(ALOCConstants.ACTIVEANNOUNCEMENTINDEX,"1");
		request.setParameter(ALOCConstants.USERANNOUNCEMENTID,"143");
		try {			
			 userAnnouncementMgmtAction.downloadAttachment();			 
		} catch (HWFServiceException e) {		
			fail(ALOCConstants.TESTCASE_FIALED_ERROR_MESSAGE + e.getMessage());
		}
	}

}
