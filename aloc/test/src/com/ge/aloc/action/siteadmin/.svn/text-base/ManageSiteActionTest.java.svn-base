package com.ge.aloc.action.siteadmin;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.StaticDataFactory;
import com.ge.aloc.common.AbstractTestCase;
import com.ge.aloc.model.CustomizedSiteReferences;
import com.ge.aloc.model.DelegationConfiguration;
import com.ge.aloc.model.ParentSite;
import com.ge.aloc.model.SiteAdmin;
import com.ge.aloc.model.SiteType;
import com.ge.aloc.util.SiteAdminHelper;
import com.hydus.hwf.context.UserContext;
import com.hydus.hwf.exceptions.HWFServiceException;

public class ManageSiteActionTest extends AbstractTestCase {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	protected void setUp() throws Exception {
		super.setUp();		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Test method for {@link com.ge.aloc.action.siteadmin.ManageSiteAction#validateAndSaveSection()}.
	 */
	@Test
	public void testValidateAndSaveSection() {
		ManageSiteAction manageSiteAction = manageSiteAction("validateAndSaveSection");

		try {
			manageSiteAction.setSectionId("site.section.customizedSiteReferences");
			SiteAdmin siteAdmin =  SiteAdminHelper.getActiveSite().getModel();
			siteAdmin = getSiteDetails(siteAdmin);

			CustomizedSiteReferences siteCustoms = new CustomizedSiteReferences();
			List<String> customsLst = new ArrayList<String>();
			customsLst.add("CSF_FINAN_003_01");
			customsLst.add("CSF_FINAN_003_02");
			customsLst.add("CSF_FINAN_003_03");
			siteCustoms.setSiteCustoms(customsLst);
			siteCustoms.setSiteRequiredFlag(true);
			siteAdmin.setCustomizedSiteReferences(siteCustoms);
			setUserContextDetails();
			String result = manageSiteAction.validateAndSaveSection();
			assertEquals("sectionControllerPage", result);
		} catch (HWFServiceException e) {
			fail(e.getMessage());
		}

	}

	/**
	 * Test method for {@link com.ge.aloc.action.siteadmin.ManageSiteAction#getCopySiteDetails()}.
	 */
	@Test
	public void testGetCopySiteDetails() {
		ManageSiteAction manageSiteAction = manageSiteAction("getCopySiteDetails");

		try {
			SiteAdmin siteAdmin = openSiteAdmin("1566");//Need to change based on Environment(Dev1 or Dev2), Current Dev1.
			assertNotNull(siteAdmin);
			request.setParameter("selectSiteName", "1566");//Need to change based on Environment(Dev1 or Dev2), Current Dev1.
			setUserContextDetails();
			StaticDataFactory sdf = (StaticDataFactory)servletContext.getAttribute(StaticDataFactory.CTX_KEY);
			UserContext.getContext().getApplicationScopedContext().put(StaticDataFactory.CTX_KEY, sdf);
			String copySite = manageSiteAction.getCopySiteDetails();
			assertEquals("copySite", copySite);
		} catch (Exception e) {
			fail(e.getMessage());
		}

	}

	/**
	 * Test method for {@link com.ge.aloc.action.siteadmin.ManageSiteAction#getModifySiteDetails()}.
	 */
	@Test
	public void testGetModifySiteDetails() {
		ManageSiteAction manageSiteAction = manageSiteAction("getModifySiteDetails");

		try {
			request.setParameter("siteId","1566");//Need to change based on Environment(Dev1 or Dev2), Current Dev1.
			setUserContextDetails();
			String modify = manageSiteAction.getModifySiteDetails();
			assertEquals("modifySite", modify);
		} catch (HWFServiceException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.action.siteadmin.ManageSiteAction#addCustomField()}.
	 */
	@Test
	public void testAddCustomField() throws HWFServiceException {
		ManageSiteAction manageSiteAction = manageSiteAction("addCustomField");
		try {
			SiteAdmin siteAdmin = manageSiteAction.getSiteDetailsBO().getModel();
			siteAdmin = getSiteDetails(siteAdmin);
			String result = manageSiteAction.addCustomField();
			assertEquals("success", result);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.action.siteadmin.ManageSiteAction#removeCustomField()}.
	 */
	@Test
	public void testRemoveCustomField() throws HWFServiceException {
		ManageSiteAction manageSiteAction = manageSiteAction("removeCustomField");
		try {
			SiteAdmin siteAdmin = manageSiteAction.getSiteDetailsBO().getModel();
			siteAdmin = getSiteDetails(siteAdmin);
			String result = manageSiteAction.removeCustomField();
			assertEquals("success", result);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.action.siteadmin.ManageSiteAction#createGroup()}.
	 */
	@Test
	public void testCreateGroup() throws HWFServiceException {
		ManageSiteAction manageSiteAction = manageSiteAction("createGroup");
		try {
			manageSiteAction.setGroupName("JUnit");
			SiteAdmin siteAdmin = manageSiteAction.getSiteDetailsBO().getModel();
			siteAdmin = getSiteDetails(siteAdmin);
			siteAdmin.setDelegationConfiguration(new DelegationConfiguration());
			setUserContextDetails();
			String result = manageSiteAction.createGroup();
			assertEquals("success", result);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.action.siteadmin.ManageSiteAction#delegationConfig()}.
	 */
	@Test
	public void testDelegationConfig() throws HWFServiceException {
		ManageSiteAction manageSiteAction = manageSiteAction("delegationConfig");
		try {
			setUserContextDetails();
			String result = manageSiteAction.delegationConfig();
			assertEquals("success", result);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.action.siteadmin.ManageSiteAction#addGroup()}.
	 */
	@Test
	public void testAddGroup() throws HWFServiceException {
		ManageSiteAction manageSiteAction = manageSiteAction("addGroup");
		try {
			setUserContextDetails();
			String result = manageSiteAction.addGroup();
			assertEquals("success", result);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.action.siteadmin.ManageSiteAction#addGroup()}.
	 */
	@Test
	public void testGetInputResultName() throws HWFServiceException {
		ManageSiteAction manageSiteAction = manageSiteAction("addGroup");
		try {
			setUserContextDetails();
			manageSiteAction.setSectionId("site.section.createDelegateConfig");
			openSiteAdmin("1566");//Need to change based on Environment(Dev1 or Dev2), Current Dev1.
			String result = manageSiteAction.getInputResultName();
			assertEquals("input", result);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Common method
	 * This method is used to set the data for SiteAdmin Model
	 * Need to change based on Environment(Dev1 or Dev2), Current Dev1.
	 */
	@Test
	public SiteAdmin getSiteDetails(SiteAdmin siteAdmin) {

		siteAdmin.setSiteName("SITE_TEST_HYDUS_FINAN_CR_003");
		siteAdmin.setSitePrefix("STHF03");
		siteAdmin.setDescription("This is a test site");

		SiteType sitetype = new SiteType();
		sitetype.setSiteTypeId(Integer.valueOf("1"));
		sitetype.setSiteTypeName("Financial Business");
		siteAdmin.setSiteType(sitetype);
		siteAdmin.setSiteId(Integer.valueOf(1566));
		siteAdmin.setParentDescription("This is a test finan site");
		siteAdmin.setParentPrefix("STFC01");

		ParentSite parentSite = new ParentSite();

		parentSite.setParentSiteId(1562);
		parentSite.setParentSiteName("SITE_TEST_HYDUS_FINAN_CR_001");
		siteAdmin.setParentSite(parentSite);

		siteAdmin.setHeaderSiteOnly(new Boolean(false));
		siteAdmin.setLeGoldId("A01044");
		siteAdmin.setLeName("GE Power Systems, Inc.");
		siteAdmin.setLeMDMId(new BigInteger("65985"));

		assertEquals("SITE_TEST_HYDUS_FINAN_CR_003", siteAdmin.getSiteName());
		assertEquals("STHF03", siteAdmin.getSitePrefix());
		return siteAdmin;
	}
}
