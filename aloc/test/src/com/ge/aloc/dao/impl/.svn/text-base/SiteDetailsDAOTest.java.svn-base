/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: SiteDetailsDAO.java
 * Purpose: SiteDetailsDAO used for the all site DAO Implementations
 */
package com.ge.aloc.dao.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.OpCode;
import com.ge.aloc.common.AbstractTestCase;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.model.ActionDetails;
import com.ge.aloc.model.ApprovalGroupConfiguration;
import com.ge.aloc.model.Approver;
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
import com.hydus.hwf.bw.service.IServiceClient;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author nagarjuna.aluru
 *
 */
public class SiteDetailsDAOTest extends AbstractTestCase{
	private static IServiceClient serviceClient;
	private static SiteDetailsDAO siteDetailsDAO;
	private static SiteAdmin siteAdmin;
	private static List<UserDetails> adminAvailableApprovers;
	

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}
	
	/**
	 * @throws java.lang.
	 */
	@Before
	public void setUp() throws Exception {
		serviceClient = DAOConnectionHelper.getServiceClient();
		siteDetailsDAO = new SiteDetailsDAO();
		siteDetailsDAO.setServiceClient(serviceClient);
		adminAvailableApprovers = new ArrayList<UserDetails>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		siteDetailsDAO = null;
		siteAdmin = null;
	}

	/**
	 * Test method for {@link com.ge.aloc.dao.impl.SiteDetailsDAO#createSite(com.ge.aloc.model.SiteAdmin)}.
	 */
	@Test
	public void testCreateSite() {
		
		String siteName = null;
		String sitePrefix = null;
		String description = null;
		String siteType = null;
		String headerSiteOnly = null;
		String leGoldId = null;
		String leName = null;
		String leMDMId = null;
		
		assertNull(siteName);
		assertNull(sitePrefix);
		assertNull(description);
		assertNull(siteType);
		assertNull(headerSiteOnly);
		assertNull(leGoldId);
		assertNull(leName);
		assertNull(leMDMId);
		
		assertNull(siteAdmin);
		
		siteAdmin = new SiteAdmin();
		assertNotNull(siteAdmin);
		
		siteAdmin.setSiteName("GE TReasury");
		siteAdmin.setSitePrefix("GE");
		
		SiteType sitetype = new SiteType();
		sitetype.setSiteTypeId(Integer.valueOf("2"));
		sitetype.setSiteTypeName("Financial");
		siteAdmin.setSiteType(sitetype);
		
		ParentSite parentSite = new ParentSite();
		assertNotNull(parentSite);
		
		parentSite.setParentSiteId(Integer.valueOf("5"));
		parentSite.setParentSiteName("GE");
		siteAdmin.setParentSite(parentSite);
		
		siteAdmin.setHeaderSiteOnly(new Boolean(false));
		siteAdmin.setLeGoldId("000063");
		siteAdmin.setLeName("GE Finance");
		siteAdmin.setLeMDMId(new BigInteger("1233"));
		
		assertEquals("GE TReasury", siteAdmin.getSiteName());
		assertEquals("GE", siteAdmin.getSitePrefix());
		assertEquals("Financial", siteAdmin.getSiteType().getSiteTypeName());
		assertEquals(Integer.valueOf("2"), siteAdmin.getSiteType().getSiteTypeId());
		assertEquals(new Boolean(false) , siteAdmin.isHeaderSiteOnly());
		assertEquals("000063", siteAdmin.getLeGoldId());
		assertEquals("GE Finance", siteAdmin.getLeName());
		assertEquals(new BigInteger("1233"), siteAdmin.getLeMDMId());
		
		ActionDetails actionDet = new ActionDetails();
		assertNotNull(actionDet);
		actionDet.setActionName(OpCode.SAVE.getOperationCode());
		siteAdmin.setActionDetails(actionDet);
		
		try{
			siteAdmin = siteDetailsDAO.createSite(siteAdmin);
		}catch(HWFServiceException e){
			fail("ALOC_SITECREATEREQUEST_ERROR");
		}
		try{
			siteAdmin = siteDetailsDAO.createSite(null);
		}catch(HWFServiceException e){
			fail("ALOC_SITECREATEREQUEST_ERROR");
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.dao.impl.SiteDetailsDAO#saveDefaultDelivary(com.ge.aloc.model.SiteAdmin)}.
	 */
	@Test
	public void testSaveDefaultDelivary() {
		siteAdmin = new SiteAdmin();
		siteAdmin = getSiteDetails();
		
		DeliveryInstructions delInstructions = new DeliveryInstructions();
		delInstructions.setDeliveryType("true");
		delInstructions.setCompanyName("HYDUS");
		delInstructions.setFirstName("HYD");
		delInstructions.setLastName("HYDUS");
		delInstructions.setPhoneNo("0402334400");
		siteAdmin.setDeliveryInstructions(delInstructions);
		
		try {
			siteDetailsDAO.saveDefaultDelivary(siteAdmin);
		} catch (HWFServiceException e) {
			fail("ALOC_SITECREATEREQUEST_ERROR");
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.dao.impl.SiteDetailsDAO#saveCustomizedSiteReferences(com.ge.aloc.model.SiteAdmin)}.
	 */
	@Test
	public void testSaveCustomizedSiteReferences() {
		siteAdmin = new SiteAdmin();
		siteAdmin = getSiteDetails();
		
		CustomizedSiteReferences cusRef = new CustomizedSiteReferences();
		List<String> customs = new ArrayList<String>();
		customs.add("cus1");
		customs.add("cus2");
		cusRef.setSiteCustoms(customs);
		siteAdmin.setCustomizedSiteReferences(cusRef);
		
		try {
			siteDetailsDAO.saveCustomizedSiteReferences(siteAdmin);
		} catch (HWFServiceException e) {
			fail("ALOC_SITECREATEREQUEST_ERROR");
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.dao.impl.SiteDetailsDAO#saveDelegationConfig(com.ge.aloc.model.SiteAdmin)}.
	 */
	@Test
	public void testSaveDelegationConfig() {
		siteAdmin = new SiteAdmin();
		siteAdmin = getSiteDetails();
		
		DelegationConfiguration delConfig = new DelegationConfiguration();
		ApprovalGroupConfiguration appGroup = new ApprovalGroupConfiguration();
		DelegationConfig config = new DelegationConfig();
		List<Group> grpLst = new ArrayList<Group>();
		
		Group indus = new Group();
		indus.setGroupName("Indus");
		indus.setGroupId(Integer.valueOf(83));
		grpLst.add(indus);
		
		Group business = new Group();
		business.setGroupName("Business");
		business.setGroupId(Integer.valueOf(84));
		grpLst.add(business);
		
		Group xyz = new Group();
		xyz.setGroupName("xyz");
		xyz.setGroupId(Integer.valueOf(663));
		grpLst.add(xyz);
		
		appGroup.setGroups(grpLst);
		delConfig.setApprovalGroupConfiguration(appGroup);
		
		config.setCurePeriodIndicatorFlag("No");
		config.setDelegationConfigId(new BigInteger("17"));
		config.setGEAppDrawFlag("Yes");
		List<GroupAssignment> asgnLst = new ArrayList<GroupAssignment>();
		
		GroupAssignment grpAssignment = new GroupAssignment();
		grpAssignment.setGroupId(Integer.valueOf(83));
		grpAssignment.setGroupLevel(Integer.valueOf(1));
		grpAssignment.setGroupName("Indus");
		asgnLst.add(grpAssignment);
		
		GroupAssignment grpAssignment1 = new GroupAssignment();
		grpAssignment1.setGroupId(Integer.valueOf(84));
		grpAssignment1.setGroupLevel(Integer.valueOf(2));
		grpAssignment1.setGroupName("Business");
		asgnLst.add(grpAssignment1);
		
		config.setGroupAssignments(asgnLst);
		config.setInstrBaseAmt(new BigDecimal(1));
		config.setInstrEndAmt(new BigDecimal(50000));
		List<Instrument> instrLst = new ArrayList<Instrument>();
		
		Instrument rider = new Instrument();
		rider.setInstr("Rider");
		rider.setInstrId(Integer.valueOf(6));
		rider.setInstrumentFlag("Y");
		instrLst.add(rider);
		
		Instrument amendment = new Instrument();
		amendment.setInstr("Amendment");
		amendment.setInstrId(Integer.valueOf(5));
		amendment.setInstrumentFlag("Y");
		instrLst.add(amendment);
		
		Instrument bond = new Instrument();
		bond.setInstr("Surety Bond");
		bond.setInstrId(Integer.valueOf(3));
		bond.setInstrumentFlag("Y");
		instrLst.add(bond);
		
		Instrument loc = new Instrument();
		loc.setInstr("Standby Letter Of Credit");
		loc.setInstrId(Integer.valueOf(2));
		loc.setInstrumentFlag("Y");
		instrLst.add(loc);
		
		Instrument bg = new Instrument();
		bg.setInstr("Bank Guarantee");
		bg.setInstrId(Integer.valueOf(1));
		bg.setInstrumentFlag("Y");
		instrLst.add(bg);
		
		Instrument dloc = new Instrument();
		dloc.setInstr("Documentary Letter Of Credit Confirmation");
		dloc.setInstrId(Integer.valueOf(4));
		dloc.setInstrumentFlag("Y");
		instrLst.add(dloc);
		
		config.setInstruments(instrLst);
		
		List<DelegationConfig> delLst = new ArrayList<DelegationConfig>();
		delLst.add(config);
		delConfig.setDelegationConfigs(delLst);
		siteAdmin.setDelegationConfiguration(delConfig);
		
		try {
			siteDetailsDAO.saveDelegationConfig(siteAdmin);
			assertNotNull(siteAdmin);
		} catch (HWFServiceException e) {
			fail("ALOC_SITECREATEREQUEST_ERROR");
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.dao.impl.SiteDetailsDAO#getAvailableAprrovers(com.ge.aloc.model.SiteAdmin)}.
	 */
	@Test
	public void testGetAvailableAprrovers() {
		siteAdmin = new SiteAdmin();
		siteAdmin = getSiteDetails();
		
		try {
			List<UserDetails> availableApprovers = siteDetailsDAO.getAvailableAprrovers(siteAdmin);
			assertNotNull(availableApprovers);
		} catch (HWFServiceException e) {
			fail("Site not available with requested Site Id"+ e.getMessage());
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.dao.impl.SiteDetailsDAO#saveGroup(com.ge.aloc.model.SiteAdmin, java.lang.String)}.
	 */
	@Test
	public void testSaveGroup() {
		siteAdmin = new SiteAdmin();
		siteAdmin = getSiteDetails();
		//Don't use Existing Group Name
		String groupName= "Test Group";
		
		DelegationConfiguration delConfig = new DelegationConfiguration();
		ApprovalGroupConfiguration appGroup = new ApprovalGroupConfiguration();
		Group group = new Group();
		group.setGroupName(groupName);
		List<Group> grpLst = new ArrayList<Group>();
		grpLst.add(group);
		appGroup.setGroups(grpLst);
		delConfig.setApprovalGroupConfiguration(appGroup);
		siteAdmin.setDelegationConfiguration(delConfig);
		
		try {
			siteDetailsDAO.saveGroup(siteAdmin, groupName);
			List<Group> groupList = siteAdmin.getDelegationConfiguration().getApprovalGroupConfiguration().getGroups();
			
			for(Group grp : groupList){
				if(groupName.equals(grp.getGroupName()));
				assertEquals(groupName, grp.getGroupName());
			}
		} catch (HWFServiceException e) {
			fail("ALOC_SITECREATEREQUEST_ERROR");
		}
		
	}

	/**
	 * Test method for {@link com.ge.aloc.dao.impl.SiteDetailsDAO#openBusinessAdmin(java.lang.String)}.
	 */
	@Test
	public void testOpenBusinessAdmin() {
		siteAdmin = new SiteAdmin();
		
		try {
			siteAdmin = siteDetailsDAO.openBusinessAdmin("39");
			assertNotNull(siteAdmin);
			assertNotNull(siteAdmin.getSiteName());
			assertNotNull(siteAdmin.getSitePrefix());
			assertNotNull(siteAdmin.getSiteId());
		} catch (HWFServiceException e) {
			fail("Site not available with requested Site Id"+ e.getMessage());
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.dao.impl.SiteDetailsDAO#saveBusinessDelegates(java.lang.String, java.util.List, com.ge.aloc.model.SiteAdmin)}.
	 */
	@Test
	public void testSaveBusinessDelegates() {
		
		siteAdmin = new SiteAdmin();
		
		String siteName = null;
		String sitePrefix = null;
		String description = null;
		String siteType = null;
	
		assertNull(siteName);
		assertNull(sitePrefix);
		assertNull(description);
		assertNull(siteType);
		
		assertNotNull(siteAdmin);
		assertNull(siteAdmin.getSiteName());
		assertNull(siteAdmin.getSitePrefix());
		
		siteAdmin.setSiteName("nj");
		siteAdmin.setSitePrefix("nj");
		siteAdmin.setDescription("vgg");
		
		SiteType sitetype = new SiteType();
		sitetype.setSiteTypeId(Integer.valueOf("1"));
		sitetype.setSiteTypeName("Financial Business");
		siteAdmin.setSiteType(sitetype);
		siteAdmin.setSiteId(Integer.valueOf(351));
		siteAdmin.setParentDescription("FinSite");
		siteAdmin.setParentPrefix("Site1Prefix");
		
		ParentSite parentSite = new ParentSite();
		assertNotNull(parentSite);
		
		parentSite.setParentSiteId(Integer.valueOf("5"));
		parentSite.setParentSiteName("FinSiteName1");
		siteAdmin.setParentSite(parentSite);
		
		siteAdmin.setHeaderSiteOnly(new Boolean(false));
		siteAdmin.setLeGoldId("000153");
		siteAdmin.setLeName("General Electric Credit Corporation of Georgia");
		siteAdmin.setLeMDMId(new BigInteger("59607"));
		
		assertEquals("nj", siteAdmin.getSiteName());
		assertEquals("nj", siteAdmin.getSitePrefix());
		assertEquals("Financial Business", siteAdmin.getSiteType().getSiteTypeName());
		assertEquals(Integer.valueOf("1"), siteAdmin.getSiteType().getSiteTypeId());
		assertEquals(new Boolean(false) , siteAdmin.isHeaderSiteOnly());
		assertEquals("000153", siteAdmin.getLeGoldId());
		assertEquals("General Electric Credit Corporation of Georgia", siteAdmin.getLeName());
		assertEquals(new BigInteger("59607"), siteAdmin.getLeMDMId());
		
		DelegationConfiguration delConfig = new DelegationConfiguration();
		ApprovalGroupConfiguration appGroupConfig = new ApprovalGroupConfiguration();
		
		List<Approver> apprLst = new ArrayList<Approver>();
		
		//Populating the Approvers Details
		Approver approver =new Approver();
		approver.setAppLastName("kyalam"+ALOCConstants.COMMA+"sumanth");
		approver.setSssoId("999928606"+ALOCConstants.COMMA+"kyalam"+ALOCConstants.COMMA+"sumanth");
		apprLst.add(approver);
		
		Approver approver1 =new Approver();
		approver1.setAppLastName("vudathu"+ALOCConstants.COMMA+"kishore");
		approver1.setSssoId("999928588"+ALOCConstants.COMMA+"vudathu"+ALOCConstants.COMMA+"kishore");
		apprLst.add(approver1);
		
		Approver approver2 =new Approver();
		approver2.setAppLastName("kudhan"+ALOCConstants.COMMA+"basha");
		approver2.setSssoId("999928506"+ALOCConstants.COMMA+"kudhan"+ALOCConstants.COMMA+"basha");
		apprLst.add(approver2);
		
		//Populating the Approvers Save Action
		UserDetails userDet = new UserDetails();
		userDet.setLastName("kyalam"+ALOCConstants.COMMA+"sumanth");
		userDet.setUserSso("999928606"+ALOCConstants.COMMA+"kyalam"+ALOCConstants.COMMA+"sumanth");
		adminAvailableApprovers.add(userDet);
		
		UserDetails userDet1 = new UserDetails();
		userDet1.setLastName("vudathu"+ALOCConstants.COMMA+"kishore");
		userDet1.setUserSso("999928588"+ALOCConstants.COMMA+"vudathu"+ALOCConstants.COMMA+"kishore"+ALOCConstants.COMMA+ALOCConstants.DELETE);
		adminAvailableApprovers.add(userDet1);
		
		UserDetails userDet2 = new UserDetails();
		userDet2.setLastName("kudhan"+ALOCConstants.COMMA+"basha");
		userDet2.setUserSso("999928506"+ALOCConstants.COMMA+"kudhan"+ALOCConstants.COMMA+"basha");
		adminAvailableApprovers.add(userDet2);
		
		UserDetails userDet3 = new UserDetails();
		userDet3.setLastName("Yarlagadda"+ALOCConstants.COMMA+"Suresh");
		userDet3.setUserSso("999928508"+ALOCConstants.COMMA+"Yarlagadda"+ALOCConstants.COMMA+"Suresh"+ALOCConstants.COMMA+ALOCConstants.INSERT);
		adminAvailableApprovers.add(userDet3);
		
		UserDetails userDet4 = new UserDetails();
		userDet4.setLastName("Pamidi"+ALOCConstants.COMMA+"Raju");
		userDet4.setUserSso("999928510"+ALOCConstants.COMMA+"Pamidi"+ALOCConstants.COMMA+"Raju"+ALOCConstants.COMMA+ALOCConstants.INSERT);
		adminAvailableApprovers.add(userDet4);
		
		Group group = new Group();
		group.setGroupId(Integer.valueOf(100));
		group.setGroupName("new");
		group.setApprovers(apprLst);
		List<Group> group1 = new ArrayList<Group>();
		group1.add(group);
		
		appGroupConfig.setGroups(group1);
		delConfig.setApprovalGroupConfiguration(appGroupConfig);
		siteAdmin.setDelegationConfiguration(delConfig);
	}
	
	/**
	 * Common
	 * This method is used to set the data for SiteAdmin 
	 */
	@Test
	public SiteAdmin getSiteDetails() {
		
		String siteName = null;
		String sitePrefix = null;
		String description = null;
		String siteType = null;
		String headerSiteOnly = null;
		String leGoldId = null;
		String leName = null;
		String leMDMId = null;
		
		assertNull(siteName);
		assertNull(sitePrefix);
		assertNull(description);
		assertNull(siteType);
		assertNull(headerSiteOnly);
		assertNull(leGoldId);
		assertNull(leName);
		assertNull(leMDMId);
		
		if(siteAdmin == null){
			siteAdmin = new SiteAdmin();
		}
		assertNotNull(siteAdmin);
		
		siteAdmin.setSiteName("Test");
		siteAdmin.setSitePrefix("Testing");
		siteAdmin.setSiteId(Integer.valueOf(39));
		SiteType sitetype = new SiteType();
		sitetype.setSiteTypeId(Integer.valueOf("1"));
		sitetype.setSiteTypeName("Financial Business");
		siteAdmin.setSiteType(sitetype);
		
		ParentSite parentSite = new ParentSite();
		assertNotNull(parentSite);
		
		parentSite.setParentSiteId(Integer.valueOf("1"));
		parentSite.setParentSiteName("FinSiteName1");
		siteAdmin.setParentSite(parentSite);
		
		siteAdmin.setHeaderSiteOnly(new Boolean(false));
		siteAdmin.setLeGoldId("000086");
		siteAdmin.setLeName("GE Capital Commercial Asset Funding, Inc.");
		siteAdmin.setLeMDMId(new BigInteger("64176"));
		
		assertEquals("Test", siteAdmin.getSiteName());
		assertEquals("Testing", siteAdmin.getSitePrefix());
		assertEquals("Financial Business", siteAdmin.getSiteType().getSiteTypeName());
		assertEquals(Integer.valueOf("1"), siteAdmin.getSiteType().getSiteTypeId());
		assertEquals(new Boolean(false) , siteAdmin.isHeaderSiteOnly());
		assertEquals("000086", siteAdmin.getLeGoldId());
		assertEquals("GE Capital Commercial Asset Funding, Inc.", siteAdmin.getLeName());
		assertEquals(new BigInteger("64176"), siteAdmin.getLeMDMId());
		
		return siteAdmin;
	}

}
