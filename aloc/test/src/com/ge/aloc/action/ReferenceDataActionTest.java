/**
 * 
 */
package com.ge.aloc.action;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.common.AbstractTestCase;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.model.SiteAdmin;
import com.ge.aloc.util.SiteAdminHelper;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author madhusudhan.gosula
 *
 */
public class ReferenceDataActionTest extends AbstractTestCase{

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
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.ge.aloc.action.ReferenceDataAction#getUSDEquivalent()}.
	 */
	@Test
	public final void testGetUSDEquivalent() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.ge.aloc.action.ReferenceDataAction#getBondSubTypes()}.
	 */
	@Test
	public final void testGetBondSubTypes() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.ge.aloc.action.ReferenceDataAction#loadParentSites()}.
	 */
	@Test
	public final void testLoadParentSites() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.ge.aloc.action.ReferenceDataAction#getDescPrefixParentSites()}.
	 */
	@Test
	public final void testGetDescPrefixParentSites() {
		
		ReferenceDataAction referenceDataAction;
		
		
		referenceDataAction = referenceDataAction("/int/siteAdmin","getDescPrefixParentSites");
		request.setParameter(ALOCConstants.PARENT_SITEID, "983");
		assertNotNull(referenceDataAction);
	}
	
	/**
	 * Test method for {@link com.ge.aloc.action.siteadmin.ManageSiteAction#checkSiteNameValid()}.
	 * @throws IOException 
	 */
	@Test
	public void testCheckSiteNameValid() throws IOException {
		ReferenceDataAction referenceDataAction = referenceDataAction("/int/siteAdmin","checkSiteNameValid");
		assertNotNull(referenceDataAction);
		SiteAdmin siteAdmin =  SiteAdminHelper.getActiveSite().getModel();
		assertNotNull(siteAdmin);
		request.setParameter(ALOCConstants.SITENAME, "test");
		
		try {
			referenceDataAction.checkSiteNameValid();
			
			String siteName = response.getContentAsString();
			assertNotNull(siteName);
		} catch (HWFServiceException e) {
			fail("ALOC_SITECREATEREQUEST_ERROR");
		}


	}
	/**
	 * Test method for {@link com.ge.aloc.action.siteadmin.ManageSiteAction#checkSitePrefixValid()}.
	 * @throws IOException 
	 */
	@Test
	public void testCheckSitePrefixValid() throws IOException {
		ReferenceDataAction referenceDataAction = referenceDataAction("/int/siteAdmin","checkSitePrefixValid");
		assertNotNull(referenceDataAction);
		SiteAdmin siteAdmin =  SiteAdminHelper.getActiveSite().getModel();
		assertNotNull(siteAdmin);
		request.setParameter(ALOCConstants.SITEPREFIX, "Testing");
		
		try {
			referenceDataAction.checkSitePrefixValid();
			
			String sitePrefix = response.getContentAsString();
			assertNotNull(sitePrefix);
			
		} catch (HWFServiceException e) {
			fail("ALOC_SITECREATEREQUEST_ERROR");
		}
		
	}
	
	/**
	 * Test method for {@link com.ge.aloc.action.ReferenceDataAction#getSiteNames()}.
	 */
	@Test
	public final void testGetSiteNames() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.ge.aloc.action.ReferenceDataAction#getAvailSites()}.
	 */
	@Test
	public final void testGetAvailSites() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.ge.aloc.action.ReferenceDataAction#getReferenceDataManager()}.
	 */
	@Test
	public final void testGetReferenceDataManager() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.ge.aloc.action.ReferenceDataAction#setReferenceDataManager(com.ge.aloc.manager.IReferenceDataManager)}.
	 */
	@Test
	public final void testSetReferenceDataManager() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.ge.aloc.action.ReferenceDataAction#getDelegationApprovers()}.
	 */
	@Test
	public final void testGetDelegationApprovers() {
		fail("Not yet implemented"); // TODO
	}

}
