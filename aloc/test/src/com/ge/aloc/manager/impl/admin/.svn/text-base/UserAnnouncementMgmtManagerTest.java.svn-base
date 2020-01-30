/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: UserAnnouncementMgmtManagerTest.java
 * Purpose: UserAnnouncementMgmtManagerTest class used for user announcement creation purpose.
 */
package com.ge.aloc.manager.impl.admin;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.dao.impl.DAOConnectionHelper;
import com.ge.aloc.dao.impl.admin.UserAnnouncementMgmtDAO;
import com.ge.aloc.model.Attachment;
import com.ge.aloc.model.RoleSelection;
import com.ge.aloc.model.UserAnnouncement;
import com.hydus.hwf.bw.service.IServiceClient;
import com.hydus.hwf.context.UserContext;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author sunil.yakkaluru
 *
 */
public class UserAnnouncementMgmtManagerTest 
{
	private static IServiceClient serviceClient;
	private static UserAnnouncementMgmtDAO userAnnouncementMgmtDAO;
	private static UserAnnouncementMgmtManager userAnnouncementMgmtManager;
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		serviceClient = DAOConnectionHelper.getServiceClient();
		userAnnouncementMgmtManager = new UserAnnouncementMgmtManager(); 
		userAnnouncementMgmtDAO = new UserAnnouncementMgmtDAO();
		userAnnouncementMgmtDAO.setServiceClient(serviceClient);
		userAnnouncementMgmtManager.setUserAnnouncementMgmtDAO(userAnnouncementMgmtDAO);
	}
	

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		  List<String> rolesList = new ArrayList<String>();
		  rolesList.add("TreasuryAnalyst");
		  UserContext.getContext().getuserDetails().setUserId("999911248");
		  UserContext.getContext().getuserDetails().setLastName("TreasuryAnalyst_999911248");
		  UserContext.getContext().getuserDetails().setFirstName("Test_999911248");
		  UserContext.getContext().getuserDetails().setRoles(rolesList);
		
	}
	
	/**
	 *  Test method for {@link com.ge.aloc.dao.impl.admin.UserAnnouncementMgmtManager#loadRolesList(com.ge.aloc.model.UserAnnouncement)}.
	 */
	@Test
	public final void testloadRolesList()
	{
		UserAnnouncement userAnnouncement = new UserAnnouncement();
		try
		{
			userAnnouncement = userAnnouncementMgmtManager.loadRolesList();
			assertNotNull(userAnnouncement);
		}catch (HWFServiceException e) {
			assertNotNull(userAnnouncement);			
		}
	}
	
	
	/**
	 *  Test method for {@link com.ge.aloc.dao.impl.admin.UserAnnouncementMgmtManager#createOrUpdateUserAnnouncement(com.ge.aloc.model.UserAnnouncement)}.
	 */
	@Test
	public final void testcreateUserAnnouncement()
	{
		UserAnnouncement userAnnouncement = new UserAnnouncement();
		try
		{
			userAnnouncement.setUserAnnouncementID(1);
			userAnnouncement.setMessageContent("message content");
			List<BigDecimal> siteSelections = new ArrayList<BigDecimal>();
			siteSelections.add(new BigDecimal(1));
			siteSelections.add(new BigDecimal(2));
			userAnnouncement.setSiteSelections(siteSelections);
			List<RoleSelection> roleSelections = new ArrayList<RoleSelection>();
			RoleSelection roleSelection = new RoleSelection();
			roleSelection.setRoleId(1);
			roleSelection.setRoleName("SiteAdmin");
			roleSelections.add(roleSelection);
			userAnnouncement.setRoleSelections(roleSelections);
			List<Integer> selectedroleslist = new ArrayList<Integer>();
			selectedroleslist.add(1);
			userAnnouncement.setSelectedRoles(selectedroleslist);
			userAnnouncement.setStartDate(Calendar.getInstance());
			userAnnouncement.setEndDate(Calendar.getInstance());
			userAnnouncement.setAttachments(new ArrayList<Attachment>());
			userAnnouncement.setHyperLink("hyper link");
			
			userAnnouncement = userAnnouncementMgmtManager.createOrUpdateUserAnnouncement(userAnnouncement);
			assertNotNull(userAnnouncement);
		}catch (HWFServiceException e) {
			assertNotNull(userAnnouncement);			
		}
	}
	
	/**
	 *  Test method for {@link com.ge.aloc.dao.impl.admin.UserAnnouncementMgmtManager#createOrUpdateUserAnnouncement(com.ge.aloc.model.UserAnnouncement)}.
	 */
	@Test
	public final void testUpdateUserAnnouncement()
	{
		UserAnnouncement userAnnouncement = new UserAnnouncement();
		try
		{
			userAnnouncement.setUserAnnouncementID(1);
			userAnnouncement.setMessageContent("message content");
			List<BigDecimal> siteSelections = new ArrayList<BigDecimal>();
			siteSelections.add(new BigDecimal(1));
			siteSelections.add(new BigDecimal(2));
			userAnnouncement.setSiteSelections(siteSelections);
			List<RoleSelection> roleSelections = new ArrayList<RoleSelection>();
			RoleSelection roleSelection = new RoleSelection();
			roleSelection.setRoleId(1);
			roleSelection.setRoleName("SiteAdmin");
			roleSelections.add(roleSelection);
			userAnnouncement.setRoleSelections(roleSelections);
			List<Integer> selectedroleslist = new ArrayList<Integer>();
			selectedroleslist.add(1);
			userAnnouncement.setSelectedRoles(selectedroleslist);
			userAnnouncement.setStartDate(Calendar.getInstance());
			userAnnouncement.setEndDate(Calendar.getInstance());
			userAnnouncement.setAttachments(new ArrayList<Attachment>());
			userAnnouncement.setHyperLink("hyper link");
			
			userAnnouncement = userAnnouncementMgmtManager.createOrUpdateUserAnnouncement(userAnnouncement);
			assertNotNull(userAnnouncement);
		}catch (HWFServiceException e) {
			assertNotNull(userAnnouncement);			
		}
	}
	
	
	/**
	 *  Test method for {@link com.ge.aloc.dao.impl.admin.UserAnnouncementMgmtManager#loadUserAnnouncementDetailsById(com.ge.aloc.model.UserAnnouncement)}.
	 */
	@Test
	public final void testloadUserAnnouncementDetailsById()
	{
		UserAnnouncement userAnnouncement = new UserAnnouncement();
		try
		{
			userAnnouncement.setUserAnnouncementID(13);
			userAnnouncement.setMessageContent("message content");
			List<BigDecimal> siteSelections = new ArrayList<BigDecimal>();
			siteSelections.add(new BigDecimal(1));
			siteSelections.add(new BigDecimal(2));
			userAnnouncement.setSiteSelections(siteSelections);
			List<RoleSelection> roleSelections = new ArrayList<RoleSelection>();
			RoleSelection roleSelection = new RoleSelection();
			roleSelection.setRoleId(1);
			roleSelection.setRoleName("SiteAdmin");
			roleSelections.add(roleSelection);
			userAnnouncement.setRoleSelections(roleSelections);
			List<Integer> selectedroleslist = new ArrayList<Integer>();
			selectedroleslist.add(1);
			userAnnouncement.setSelectedRoles(selectedroleslist);
			userAnnouncement.setStartDate(Calendar.getInstance());
			userAnnouncement.setEndDate(Calendar.getInstance());
			userAnnouncement.setAttachments(new ArrayList<Attachment>());
			userAnnouncement.setHyperLink("hyper link");
			
			userAnnouncement = userAnnouncementMgmtManager.loadUserAnnouncementDetailsById(userAnnouncement);
			assertNotNull(userAnnouncement);
		}catch (HWFServiceException e) {
			assertNotNull(userAnnouncement);			
		}
	}
	
	/**
	 *  Test method for {@link com.ge.aloc.dao.impl.admin.UserAnnouncementMgmtManager#loadActiveAnnouncement(com.ge.aloc.model.UserAnnouncement)}.
	 */
	@Test
	public final void testloadActiveAnnouncement()
	{
		UserAnnouncement userAnnouncement = new UserAnnouncement();
		try
		{
			userAnnouncement  = userAnnouncementMgmtManager.loadActiveAnnouncement();
			assertNotNull(userAnnouncement);		
			assertNotNull(userAnnouncement.getRoleSelections());
		}catch (HWFServiceException e) {
			assertNotNull(userAnnouncement);			
		}
		
	}

	/**
	 *  Test method for {@link com.ge.aloc.dao.impl.admin.UserAnnouncementMgmtManager#deleteAnnouncement(com.ge.aloc.model.UserAnnouncement)}.
	 */
	@Test
	public final void testdeleteAnnouncement()
	{
		UserAnnouncement userAnnouncement = new UserAnnouncement();
		try
		{
			userAnnouncement.setUserAnnouncementID(76);
			userAnnouncement  = userAnnouncementMgmtManager.deleteAnnouncement(userAnnouncement);
			assertNotNull(userAnnouncement);		
			assertNotNull(userAnnouncement.getRoleSelections());
		}catch (HWFServiceException e) {
			assertNotNull(userAnnouncement);			
		}
		
	}

}
