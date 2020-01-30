/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: UserAnnouncementMgmtDAOTest.java
 * Purpose: UserAnnouncementMgmtDAOTest class used for user announcement creation purpose.
 */
package com.ge.aloc.dao.impl.admin;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.dao.impl.DAOConnectionHelper;
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
public class UserAnnouncementMgmtDAOTest
{
	
	private static IServiceClient serviceClient;
	private static UserAnnouncementMgmtDAO userAnnouncementMgmtDAO;
	
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		serviceClient = DAOConnectionHelper.getServiceClient();
		userAnnouncementMgmtDAO = new UserAnnouncementMgmtDAO();
		userAnnouncementMgmtDAO.setServiceClient(serviceClient);
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
		  List<String> rolesList = new ArrayList<String>();
		  rolesList.add("TreasuryAnalyst");
		  UserContext.getContext().getuserDetails().setUserId("999911248");
		  UserContext.getContext().getuserDetails().setLastName("TreasuryAnalyst_999911248");
		  UserContext.getContext().getuserDetails().setFirstName("Test_999911248");
		  UserContext.getContext().getuserDetails().setRoles(rolesList);
		
	}
	
	
	/**
	 * Test method for {@link com.ge.aloc.dao.impl.admin.UserAnnouncementMgmtDAO#loadRolesList(com.ge.aloc.model.UserAnnouncement)}.
	 */
	@Test
	public final void testloadRolesList()
	{
		UserAnnouncement userAnnouncement = new UserAnnouncement();
		try
		{
			userAnnouncement  = userAnnouncementMgmtDAO.loadRolesList();
			assertNotNull(userAnnouncement);		
		}catch (HWFServiceException e) {
			assertNotNull(userAnnouncement);			
		}
	}
	
	
	/**
	 * Test method for {@link com.ge.aloc.dao.impl.admin.UserAnnouncementMgmtDAO#loadUserAnnouncementDetailsById(com.ge.aloc.model.UserAnnouncement)}.
	 */
	@Test
	public final void testloadUserAnnouncement()
	{
		UserAnnouncement userAnnouncement = new UserAnnouncement();
		try
		{
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
			
			userAnnouncement  = userAnnouncementMgmtDAO.loadUserAnnouncementDetailsById(userAnnouncement);
			assertNotNull(userAnnouncement);		
			
		}catch (HWFServiceException e) {
			assertNotNull(userAnnouncement);			
		}
	}
	
	/**
	 * Test method for {@link com.ge.aloc.dao.impl.admin.UserAnnouncementMgmtDAO#loadUserAnnouncementDetailsById(com.ge.aloc.model.UserAnnouncement)}.
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
			userAnnouncement  = userAnnouncementMgmtDAO.loadUserAnnouncementDetailsById(userAnnouncement);
			assertNotNull(userAnnouncement);		
			
		}catch (HWFServiceException e) {
			assertNotNull(userAnnouncement);			
		}
	}
	
	
	/**
	 * Test method for {@link com.ge.aloc.dao.impl.admin.UserAnnouncementMgmtDAO#createOrUpdateUserAnnouncement(com.ge.aloc.model.UserAnnouncement)}.
	 */
	@Test
	public final void testcreateUserAnnouncement()
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
			userAnnouncement  = userAnnouncementMgmtDAO.createOrUpdateUserAnnouncement(userAnnouncement);
			assertNotNull(userAnnouncement);	
			assertNotNull(userAnnouncement.getRoleSelections());	
			
		}catch (HWFServiceException e) {
			assertNotNull(userAnnouncement);			
		}
	}
	
	/**
	 * Test method for {@link com.ge.aloc.dao.impl.admin.UserAnnouncementMgmtDAO#createOrUpdateUserAnnouncement(com.ge.aloc.model.UserAnnouncement)}.
	 */
	@Test
	public final void testUpdateUserAnnouncement()
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
			userAnnouncement  = userAnnouncementMgmtDAO.createOrUpdateUserAnnouncement(userAnnouncement);
			assertNotNull(userAnnouncement);		
			assertNotNull(userAnnouncement.getRoleSelections());
		}catch (HWFServiceException e) {
			assertNotNull(userAnnouncement);			
		}
	}
	
	/**
	 * Test method for {@link com.ge.aloc.dao.impl.admin.UserAnnouncementMgmtDAO#loadActiveAnnouncement(com.ge.aloc.model.UserAnnouncement)}.
	 */
	@Test
	public final void testloadActiveAnnouncement()
	{
		UserAnnouncement userAnnouncement = new UserAnnouncement();
		try
		{
			userAnnouncement  = userAnnouncementMgmtDAO.loadActiveAnnouncement();
			assertNotNull(userAnnouncement);		
			assertNotNull(userAnnouncement.getRoleSelections());
		}catch (HWFServiceException e) {
			assertNotNull(userAnnouncement);			
		}
		
	}
	
	
	/**
	 * Test method for {@link com.ge.aloc.dao.impl.admin.UserAnnouncementMgmtDAO#deleteAnnouncement(com.ge.aloc.model.UserAnnouncement)}.
	 */
	@Test
	public final void testdeleteAnnouncement()
	{
		UserAnnouncement userAnnouncement = new UserAnnouncement();
		try
		{
			userAnnouncement.setUserAnnouncementID(76);
			userAnnouncement  = userAnnouncementMgmtDAO.deleteAnnouncement(userAnnouncement);
			assertNotNull(userAnnouncement);		
			assertNotNull(userAnnouncement.getRoleSelections());
		}catch (HWFServiceException e) {
			assertNotNull(userAnnouncement);			
		}
		
	}
	


}
