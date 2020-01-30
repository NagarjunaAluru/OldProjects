/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: SiteDetailsManagerTest.java
 * Purpose: SiteDetailsManagerTest used for the all site operations
 */
 
package com.ge.aloc.manager.impl;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.action.siteadmin.ManageSiteAction;
import com.ge.aloc.bo.SiteDetailsBO;
import com.ge.aloc.common.AbstractTestCase;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.dao.impl.DAOConnectionHelper;
import com.ge.aloc.dao.impl.SiteDetailsDAO;
import com.ge.aloc.model.ApprovalGroupConfiguration;
import com.ge.aloc.model.CustomizedSiteReferences;
import com.ge.aloc.model.DelegationConfig;
import com.ge.aloc.model.DelegationConfiguration;
import com.ge.aloc.model.DeliveryInstructions;
import com.ge.aloc.model.Group;
import com.ge.aloc.model.GroupAssignment;
import com.ge.aloc.model.Instrument;
import com.ge.aloc.model.ParentSite;
import com.ge.aloc.model.SiteAdmin;
import com.ge.aloc.model.SiteType;
import com.ge.aloc.model.UserDetails;
import com.ge.aloc.util.SiteAdminHelper;
import com.hydus.hwf.bw.service.IServiceClient;
import com.hydus.hwf.context.TestUserContext;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author nagarjuna.aluru
 *
 */
public class SiteDetailsManagerTest extends AbstractTestCase{
	private static IServiceClient serviceClient;
	private static SiteDetailsManager siteDetailsManager;
	private static SiteDetailsDAO siteDetailsDAO;
	private SiteDetailsBO siteDetailsBO;
	private SiteAdmin siteAdmin;
	String siteId;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		serviceClient = DAOConnectionHelper.getServiceClient();
		siteDetailsManager = new SiteDetailsManager(); 
		siteDetailsDAO = new SiteDetailsDAO();
		siteDetailsDAO.setServiceClient(serviceClient);
		siteDetailsManager.setSiteDetailsDAO(siteDetailsDAO);
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		serviceClient = null;
		siteDetailsManager = null;
		siteDetailsDAO = null;
		SiteAdminHelper.removeActiveSite();
	}

	/**
	 * Test method for {@link com.ge.aloc.manager.impl.SiteDetailsManager#createSite(com.ge.aloc.bo.SiteDetailsBO)}.
	 */
	@Test
	public void testCreateSite() {
		SiteAdmin siteDetails = null;
		siteDetailsBO = new SiteDetailsBO(siteDetails);
		siteAdmin = siteDetailsBO.getModel();
		
		siteAdmin = new SiteAdmin();
		assertNotNull(siteAdmin);
		siteDetailsBO = new SiteDetailsBO(siteDetails);
		siteAdmin.setSiteName("Test Site");
		siteAdmin.setSitePrefix("ABC");
		ParentSite site = new ParentSite();
		site.setParentSiteId(12);
		site.setParentSiteName("Junit Test");
		siteAdmin.setParentSite(site);
		SiteType siteType = new SiteType();
		siteType.setSiteTypeName("Financial Site");
		siteType.setSiteTypeId(151);
		siteAdmin.setSiteType(siteType);
		
		siteDetailsBO = new SiteDetailsBO(siteAdmin);
		
		try {
			siteAdmin = siteDetailsBO.getModel();
			ManageSiteAction manageSiteAction = manageSiteAction("validateAndSaveSection");
			setUserContextDetails();
			siteAdmin = manageSiteAction.getSiteDetailsManager().createSite(siteDetailsBO);
			assertNotNull(siteAdmin);
			assertNotNull(siteAdmin.getSiteId());
			assertEquals("Site Name Success","Test Site",siteAdmin.getSiteName());
			assertEquals("Site Prefix Success","Test Site",siteAdmin.getSitePrefix());
			assertEquals("Site Type Success","Test Site",siteAdmin.getSiteType());
			assertEquals("Site Type Id Success","Test Site",siteAdmin.getSiteType().getSiteTypeId());
			assertEquals("Site Type Name Success","Test Site",siteAdmin.getSiteType().getSiteTypeName());
			
		} catch (HWFServiceException e) {
			fail("Error while getting SiteAdmin Details"+e.getMessage()); // TODO
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.manager.impl.SiteDetailsManager#saveDefaultDelivary()}.
	 */
	@Test
	public void testSaveDefaultDelivary() {
		SiteAdmin siteAdmin = new SiteAdmin();
		siteAdmin.setSiteName("Test Site3");
		CustomizedSiteReferences siteCust = new CustomizedSiteReferences();
		List<String> cusLst = new ArrayList<String>();
		cusLst.add("Site Custom");
		siteCust.setSiteCustoms(cusLst);
		siteAdmin.setCustomizedSiteReferences(siteCust);
		DeliveryInstructions instructions = new DeliveryInstructions();
		instructions.setCity("Hyderabad");
		instructions.setCompanyName("Hydus");
		instructions.setCountry("India");
		siteAdmin.setDeliveryInstructions(instructions);
		siteAdmin.setDescription("Junit Test Site");
		siteAdmin.setHeaderSiteOnly(false);
		siteAdmin.setLeGoldId("000084");
		siteAdmin.setLeMDMId(new BigInteger("61428"));
		siteAdmin.setLeName("General Electric Capital Corporation");
		siteAdmin.setRequestCheck(false);
		siteAdmin.setSiteId(1327);
		siteAdmin.setSitePrefix("ts3");
		SiteType siteType = new SiteType();
		siteType.setSiteTypeId(1);
		siteType.setSiteTypeName("Financial");
		siteAdmin.setSiteType(siteType);
		SiteDetailsBO siteDetailsBO = new SiteDetailsBO(siteAdmin);
		try{
			ManageSiteAction manageSiteAction = manageSiteAction("validateAndSaveSection");
			TestUserContext.createUserContext(request, request.getSession(), servletContext);
			SiteAdminHelper.setActiveSite(siteDetailsBO);
			setUserContextDetails();
			manageSiteAction.getSiteDetailsManager().saveDefaultDelivary();
		}catch (HWFServiceException e) {
			fail("Error while getting SiteAdmin Details"+e.getMessage()); // TODO
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.manager.impl.SiteDetailsManager#saveCustomizedSiteReferences(com.ge.aloc.bo.SiteDetailsBO)}.
	 */
	@Test
	public void testSaveCustomizedSiteReferences() {
		SiteAdmin siteAdmin = new SiteAdmin();
		siteAdmin.setSiteName("Test Site3");
		CustomizedSiteReferences siteCust = new CustomizedSiteReferences();
		List<String> cusLst = new ArrayList<String>();
		cusLst.add("Site Custom");
		siteCust.setSiteCustoms(cusLst);
		siteAdmin.setCustomizedSiteReferences(siteCust);
		siteAdmin.setDescription("Junit Test Site");
		siteAdmin.setHeaderSiteOnly(false);
		siteAdmin.setLeGoldId("000084");
		siteAdmin.setLeMDMId(new BigInteger("61428"));
		siteAdmin.setLeName("General Electric Capital Corporation");
		siteAdmin.setRequestCheck(false);
		siteAdmin.setSiteId(1327);
		siteAdmin.setSitePrefix("ts3");
		SiteType siteType = new SiteType();
		siteType.setSiteTypeId(1);
		siteType.setSiteTypeName("Financial");
		siteAdmin.setSiteType(siteType);
		SiteDetailsBO siteDetailsBO = new SiteDetailsBO(siteAdmin);
		try
		{
			ManageSiteAction manageSiteAction = manageSiteAction("validateAndSaveSection");
			setUserContextDetails();
			manageSiteAction.getSiteDetailsManager().saveCustomizedSiteReferences(siteDetailsBO);
		}catch (HWFServiceException e) {
			fail("Error while getting SiteAdmin Details"+e.getMessage()); // TODO
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.manager.impl.SiteDetailsManager#saveDelegationConfig()}.
	 */
	@Test
	public void testSaveDelegationConfig() {
		
		SiteAdmin siteAdmin = new SiteAdmin();
		siteAdmin.setSiteName("test1231");
		siteAdmin.setDescription("sdfsfs test");
		siteAdmin.setHeaderSiteOnly(false);
		siteAdmin.setLeGoldId("000084");
		siteAdmin.setLeMDMId(new BigInteger("61428"));
		siteAdmin.setLeName("General Electric Capital Corporation");
		siteAdmin.setRequestCheck(false);
		siteAdmin.setSiteId(1287);
		siteAdmin.setSitePrefix("tes233");
		SiteType siteType = new SiteType();
		siteType.setSiteTypeId(1);
		siteType.setSiteTypeName("Financial Business");
		siteAdmin.setSiteType(siteType);
		
		DelegationConfiguration configuration = new DelegationConfiguration();
		Group group = new Group();
		group.setGroupName("Group Test");
		group.setGroupId(1067);
		List<Group> list = new ArrayList<Group>();
		list.add(group);
		ApprovalGroupConfiguration groupConfiguration = new ApprovalGroupConfiguration();
		groupConfiguration.setGroups(list);
		configuration.setApprovalGroupConfiguration(groupConfiguration);
		
		Instrument instruments = new Instrument();
		instruments.setInstr("Bank Gaurantee");
		
		GroupAssignment groupAssignments = new GroupAssignment();
		groupAssignments.setGroupName("Group Test");
		groupAssignments.setGroupLevel(1);
		
		List<GroupAssignment> gList = new ArrayList<GroupAssignment>();
		gList.add(groupAssignments);
		
		List<Instrument> ilist = new ArrayList<Instrument>();
		ilist.add(instruments);
		
		DelegationConfig delegationConfigs = new DelegationConfig();
		delegationConfigs.setInstruments(ilist);
		delegationConfigs.setInstrBaseAmt(new BigDecimal(1000));
		delegationConfigs.setInstrEndAmt(new BigDecimal(2000));
		delegationConfigs.setNotificationCaluseFlag("No");
		delegationConfigs.setCurePeriodIndicatorFlag("No");
		delegationConfigs.setGEAppDrawFlag("No");
		delegationConfigs.setGroupAssignments(gList);
		delegationConfigs.setOpCode(ALOCConstants.INSERT);
		
		List<DelegationConfig> configsList = new ArrayList<DelegationConfig>();
		configsList.add(delegationConfigs);
		
		configuration.setDelegationConfigs(configsList);
		siteAdmin.setDelegationConfiguration(configuration);
		SiteDetailsBO siteDetailsBO = new SiteDetailsBO(siteAdmin);
		try
		{
			ManageSiteAction manageSiteAction = manageSiteAction("validateAndSaveSection");
			setUserContextDetails();
			SiteAdminHelper.setActiveSite(siteDetailsBO);
			manageSiteAction.getSiteDetailsManager().saveDelegationConfig();
		}catch (HWFServiceException e) {
			fail("Error while getting SiteAdmin Details"+e.getMessage()); // TODO
		}
		
	}
	
	/**
	 * Test method for {@link com.ge.aloc.manager.impl.SiteDetailsManager#saveGroup(java.lang.String)}.
	 */
	@Test
	public void testSaveGroup() {
		
		SiteAdmin siteAdmin = new SiteAdmin();
		siteAdmin.setSiteName("Test Site3");
		siteAdmin.setDescription("Junit Test Site");
		siteAdmin.setHeaderSiteOnly(false);
		siteAdmin.setLeGoldId("000084");
		siteAdmin.setLeMDMId(new BigInteger("61428"));
		siteAdmin.setLeName("General Electric Capital Corporation");
		siteAdmin.setRequestCheck(false);
		siteAdmin.setSiteId(1327);
		siteAdmin.setSitePrefix("ts3");
		SiteType siteType = new SiteType();
		siteType.setSiteTypeId(1);
		siteType.setSiteTypeName("Financial");
		siteAdmin.setSiteType(siteType);
		
		DelegationConfiguration configuration = new DelegationConfiguration();
		Group group = new Group();
		group.setGroupName("New Test");
		group.setGroupName("New Test2");
		List<Group> list = new ArrayList<Group>();
		list.add(group);
		ApprovalGroupConfiguration groupConfiguration = new ApprovalGroupConfiguration();
		groupConfiguration.setGroups(list);
		configuration.setApprovalGroupConfiguration(groupConfiguration);
		siteAdmin.setDelegationConfiguration(configuration);
		SiteDetailsBO siteDetailsBO = new SiteDetailsBO(siteAdmin);
		try
		{
			ManageSiteAction manageSiteAction = manageSiteAction("validateAndSaveSection");
			setUserContextDetails();
			SiteAdminHelper.setActiveSite(siteDetailsBO);
			manageSiteAction.getSiteDetailsManager().saveGroup("New Test2");
		}catch (HWFServiceException e) {
			fail("Error while getting SiteAdmin Details"+e.getMessage()); // TODO
		}		
	}
	
	/**
	 * Test method for {@link com.ge.aloc.manager.impl.SiteDetailsManager#validateGroup(java.lang.String)}.
	 */
	@Test
	public void testValidateGroup() {
		
		SiteAdmin siteAdmin = new SiteAdmin();
		siteAdmin.setSiteName("Test Site3");
		siteAdmin.setDescription("Junit Test Site");
		siteAdmin.setHeaderSiteOnly(false);
		siteAdmin.setLeGoldId("000084");
		siteAdmin.setLeMDMId(new BigInteger("61428"));
		siteAdmin.setLeName("General Electric Capital Corporation");
		siteAdmin.setRequestCheck(false);
		siteAdmin.setSiteId(1327);
		siteAdmin.setSitePrefix("ts3");
		SiteType siteType = new SiteType();
		siteType.setSiteTypeId(1);
		siteType.setSiteTypeName("Financial");
		siteAdmin.setSiteType(siteType);
		
		DelegationConfiguration configuration = new DelegationConfiguration();
		Group group = new Group();
		group.setGroupName("New Test");
		group.setGroupName("New Test2");
		List<Group> list = new ArrayList<Group>();
		list.add(group);
		ApprovalGroupConfiguration groupConfiguration = new ApprovalGroupConfiguration();
		groupConfiguration.setGroups(list);
		configuration.setApprovalGroupConfiguration(groupConfiguration);
		siteAdmin.setDelegationConfiguration(configuration);
		SiteDetailsBO siteDetailsBO = new SiteDetailsBO(siteAdmin);
		try
		{
			ManageSiteAction manageSiteAction = manageSiteAction("validateAndSaveSection");
			setUserContextDetails();
			SiteAdminHelper.setActiveSite(siteDetailsBO);
			String result = manageSiteAction.getSiteDetailsManager().validateGroup("New Test3");
			assertNotNull(result);
		}catch (HWFServiceException e) {
			fail("Error while getting SiteAdmin Details"+e.getMessage()); // TODO
		}		
	}
	
	/**
	 * Test method for {@link com.ge.aloc.manager.impl.SiteDetailsManager#getAvailableAprrovers()}.
	 */
	@Test
	public void testGetAvailableAprrovers() {
		
		SiteAdmin siteAdmin = new SiteAdmin();
		siteAdmin.setSiteName("Test Site3");
		siteAdmin.setDescription("Junit Test Site");
		siteAdmin.setHeaderSiteOnly(false);
		siteAdmin.setLeGoldId("000084");
		siteAdmin.setLeMDMId(new BigInteger("61428"));
		siteAdmin.setLeName("General Electric Capital Corporation");
		siteAdmin.setRequestCheck(false);
		siteAdmin.setSiteId(1327);
		siteAdmin.setSitePrefix("ts3");
		SiteType siteType = new SiteType();
		siteType.setSiteTypeId(3);
		siteType.setSiteTypeName("Financial");
		siteAdmin.setSiteType(siteType);
		SiteDetailsBO siteDetailsBO = new SiteDetailsBO(siteAdmin);
		
		List<UserDetails> availableApprovers = new ArrayList<UserDetails>();
		try
		{
			ManageSiteAction manageSiteAction = manageSiteAction("validateAndSaveSection");
			setUserContextDetails();
			SiteAdminHelper.setActiveSite(siteDetailsBO);
			availableApprovers=manageSiteAction.getSiteDetailsManager().getAvailableAprrovers();
			assertNotNull(availableApprovers);
		}catch (HWFServiceException e) {
			fail("Error while getting SiteAdmin Details"+e.getMessage()); // TODO
		}		
	}
	
	/**
	 * Test method for {@link com.ge.aloc.manager.impl.SiteDetailsManager#openBusinessAdmin(java.lang.String)}.
	 */
	@Test
	public void testopenBusinessAdmin() {
		
		SiteAdmin siteAdmin = new SiteAdmin();
		siteAdmin.setSiteName("Test Site3");
		siteAdmin.setDescription("Junit Test Site");
		siteAdmin.setHeaderSiteOnly(false);
		siteAdmin.setLeGoldId("000084");
		siteAdmin.setLeMDMId(new BigInteger("61428"));
		siteAdmin.setLeName("General Electric Capital Corporation");
		siteAdmin.setRequestCheck(false);
		siteAdmin.setSiteId(1344);
		siteAdmin.setSitePrefix("ts3");
		SiteType siteType = new SiteType();
		siteType.setSiteTypeId(3);
		siteType.setSiteTypeName("Financial");
		siteAdmin.setSiteType(siteType);
		
		DelegationConfiguration configuration = new DelegationConfiguration();
		Group group = new Group();
		group.setGroupName("New Test");
		group.setGroupId(10);
		List<Group> list = new ArrayList<Group>();
		list.add(group);
		ApprovalGroupConfiguration groupConfiguration = new ApprovalGroupConfiguration();
		groupConfiguration.setGroups(list);
		configuration.setApprovalGroupConfiguration(groupConfiguration);
		
		Instrument instruments = new Instrument();
		instruments.setInstr("Bank Gaurantee");
		
		GroupAssignment groupAssignments = new GroupAssignment();
		groupAssignments.setGroupName("New Test");
		groupAssignments.setGroupId(1);
		
		List<GroupAssignment> gList = new ArrayList<GroupAssignment>();
		gList.add(groupAssignments);
		
		List<Instrument> ilist = new ArrayList<Instrument>();
		ilist.add(instruments);
		
		DelegationConfig delegationConfigs = new DelegationConfig();
		delegationConfigs.setInstruments(ilist);
		delegationConfigs.setInstrBaseAmt(new BigDecimal(1000));
		delegationConfigs.setInstrEndAmt(new BigDecimal(2000));
		delegationConfigs.setNotificationCaluseFlag("No");
		delegationConfigs.setCurePeriodIndicatorFlag("No");
		delegationConfigs.setGEAppDrawFlag("No");
		delegationConfigs.setGroupAssignments(gList);
		
		List<DelegationConfig> configsList = new ArrayList<DelegationConfig>();
		configsList.add(delegationConfigs);
		
		
		configuration.setDelegationConfigs(configsList);
		siteAdmin.setDelegationConfiguration(configuration);
		
		SiteDetailsBO siteDetailsBO = new SiteDetailsBO(siteAdmin);
		try
		{
			ManageSiteAction manageSiteAction = manageSiteAction("validateAndSaveSection");
			setUserContextDetails();
			SiteAdminHelper.setActiveSite(siteDetailsBO);
			manageSiteAction.getSiteDetailsManager().openBusinessAdmin("1344");
		}catch (HWFServiceException e) {
			fail("Error while getting SiteAdmin Details"+e.getMessage()); // TODO
		}		
	}
	
	/**
	 * Test method for {@link com.ge.aloc.manager.impl.SiteDetailsManager#saveBusinessDelegates(java.lang.String,com.ge.aloc.model.UserDetails,com.ge.aloc.model.SiteAdmin)}.
	 */
	@Test
	public void testsaveBusinessDelegates() {
		
		String delegates="1067";
		SiteAdmin siteAdmin = new SiteAdmin();
		siteAdmin.setSiteName("test1231");
		siteAdmin.setDescription("sdfsfs test");
		siteAdmin.setHeaderSiteOnly(false);
		siteAdmin.setLeGoldId("000084");
		siteAdmin.setLeMDMId(new BigInteger("61428"));
		siteAdmin.setLeName("General Electric Capital Corporation");
		siteAdmin.setRequestCheck(false);
		siteAdmin.setSiteId(1287);
		siteAdmin.setSitePrefix("tes233");
		SiteType siteType = new SiteType();
		siteType.setSiteTypeId(1);
		siteType.setSiteTypeName("Financial Business");
		siteAdmin.setSiteType(siteType);
		
		DelegationConfiguration configuration = new DelegationConfiguration();
		Group group = new Group();
		group.setGroupName("Group Test");
		group.setGroupId(1067);
		List<Group> list = new ArrayList<Group>();
		list.add(group);
		ApprovalGroupConfiguration groupConfiguration = new ApprovalGroupConfiguration();
		groupConfiguration.setGroups(list);
		configuration.setApprovalGroupConfiguration(groupConfiguration);
		
		siteAdmin.setDelegationConfiguration(configuration);
		
		List<UserDetails> adminAvailableApprovers = new ArrayList<UserDetails>();
		UserDetails userDetails = new UserDetails();
		userDetails.setLastName("Approver_999911176,Test_999911176");
		userDetails.setUserSso("999911176,Approver_999911176,Test_999911176,INSERT");
		adminAvailableApprovers.add(userDetails);
		
		SiteDetailsBO siteDetailsBO = new SiteDetailsBO(siteAdmin);
		try
		{
			ManageSiteAction manageSiteAction = manageSiteAction("validateAndSaveSection");
			setUserContextDetails();
			SiteAdminHelper.setActiveSite(siteDetailsBO);
			siteAdmin=manageSiteAction.getSiteDetailsManager().saveBusinessDelegates(delegates, adminAvailableApprovers, siteAdmin);
			assertNotNull(siteAdmin);
		}catch (HWFServiceException e) {
			fail("Error while getting SiteAdmin Details"+e.getMessage()); // TODO
		}
	}

}
