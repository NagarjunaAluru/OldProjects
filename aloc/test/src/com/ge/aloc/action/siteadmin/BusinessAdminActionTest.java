/**
 * 
 */
package com.ge.aloc.action.siteadmin;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.common.AbstractTestCase;
import com.ge.aloc.model.SiteAdmin;

/**
 * @author madhusudhan.gosula
 *
 */
public class BusinessAdminActionTest extends AbstractTestCase {
	
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
	 * Test method for {@link com.ge.aloc.action.siteadmin.BusinessAdminAction#getCurrentApprovers()}.
	 */
	@Test
	public final void testGetCurrentApprovers() {
		BusinessAdminAction businessAdminAction = businessAdminAction("getCurrentApprovers");
		try{
			SiteAdmin siteAdmin = openSiteAdmin("1151");
			assertNotNull(siteAdmin);
			String result  = businessAdminAction.getCurrentApprovers();
			assertNotNull(result);
			assertEquals("currentDelegates",result);
		}catch (Exception e) {
			fail("ALOC_SITECREATEREQUEST_ERROR");
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.action.siteadmin.BusinessAdminAction#saveBusinessDelegates()}.
	 */
	@Test
	public final void testSaveBusinessDelegates() {
		BusinessAdminAction businessAdminAction = businessAdminAction("getCurrentApprovers");
		
		try{
			SiteAdmin siteAdmin = openSiteAdmin("1151");
			assertNotNull(siteAdmin);
			 String groupId = siteAdmin.getDelegationConfiguration().getApprovalGroupConfiguration().getGroups().get(0).getGroupId().toString();
			List<String> oldSelApprovers = new ArrayList<String>();
			oldSelApprovers.add("999911170~Approver_999911170~Test_999911170");
			oldSelApprovers.add("999911171~Approver_999911171~Test_999911171");
			oldSelApprovers.add("999911172~Approver_999911172~Test_999911172");
			
			businessAdminAction.setOldSelApprovers(oldSelApprovers);
			businessAdminAction.setDelegates(groupId);
			
			String result  = businessAdminAction.saveBusinessDelegates();
			assertNotNull(result);
			assertEquals("success",result);
		}catch (Exception e) {
			fail("ALOC_SITECREATEREQUEST_ERROR");
		}
	}

}
