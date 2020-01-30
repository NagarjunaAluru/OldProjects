/**
 * 
 */
package com.ge.aloc.action.search;

import java.math.BigInteger;
import java.util.HashMap;

import org.apache.struts2.ServletActionContext;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.DashboardViewType;
import com.ge.aloc.common.AbstractTestCase;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.model.Search;
import com.ge.aloc.model.SearchInstrDetails;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author madhusudhan.gosula
 *
 */
public class SearchActionTest extends AbstractTestCase{

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
	 * test method to search the dash board related tabs
	 * Test method for {@link com.ge.aloc.action.search.SearchAction#basicSearch()}.
	 */
	@Test
	public final void testBasicSearch() {
			try {
				   SearchAction searchAction;
				   searchAction = getSearchAction("basicSearch");
				   assertNotNull(searchAction);
				   setUserContextDetails();
				   request.setParameter(ALOCConstants.SITEID, "101");
				   request.setParameter(ALOCConstants.SEARCHCRITERIATYPE, "1");
				   request.setParameter(ALOCConstants.SEARCHCRITERIATEXT, "1000");
				   request.setParameter(ALOCConstants.DASHBOARDTYPE, "BUNDLES");
				   searchAction.setRequest(ServletActionContext.getRequest());
				   searchAction.setSessionValues(new HashMap<String, Object>());
				   String result = searchAction.basicSearch();
				   assertNotNull(result);
				   assertEquals("success",result);
			} catch (HWFServiceException e) {
				e.printStackTrace();
				fail("Error while doing basic search");
			}
	}
	
	/**
	 * test method for advance search in dash board
	 * Test method for {@link com.ge.aloc.action.search.SearchAction#advanceSearch()}.
	 */
	@Test
	public final void testAdvanceSearch() {
		 
		  try {
			  SearchAction searchAction;
			  searchAction = getSearchAction("advanceSearch");
			  assertNotNull(searchAction);
			  setUserContextDetails();
			  DashboardViewType dashboardViewType=DashboardViewType.valueOf("BUNDLES");
			  searchAction.setDashboardViewType(dashboardViewType);
			  BigInteger[] instrumentTypes = new BigInteger[1];
			  instrumentTypes[0]=new BigInteger("2");
			  searchAction.setInstrumentTypes(instrumentTypes);
			  Search searchCriteria = new Search();
			  searchCriteria.setSearchInstrDetails(new SearchInstrDetails());
			  searchAction.setSearchCriteria(searchCriteria);
			  searchAction.setSessionValues(new HashMap<String, Object>());
			  String result = searchAction.advanceSearch();
			  assertNotNull(result);
			  assertEquals("success",result);
			} catch (HWFServiceException e) {
				e.printStackTrace();
				fail("Error while doing advance search");
			}
	}

	/**
	 * test method to add Elements in dashboard.
	 * Test method for {@link com.ge.aloc.action.search.SearchAction#addElements()}.
	 */
	@Test
	public final void testAddElements() {
		  try {
			  SearchAction searchAction;
			  searchAction = getSearchAction("addInstrumentPurpose");
			  assertNotNull(searchAction);	
			  setUserContextDetails();
			  String result = searchAction.addElements();
			  assertNotNull(result);
			  assertEquals("success",result);
			} catch (HWFServiceException e) {
				e.printStackTrace();
				fail("Error while adding elements");
			}
	}
	
	/**
	 * Test method for {@link com.ge.aloc.action.search.SearchAction#manageBundleSearch()}.
	 */
	@Test
	public final void testmanageBundleSearch() {
		  try {
			   SearchAction searchAction;
			   searchAction = getSearchAction("manageBundle");
			   assertNotNull(searchAction);	
			   request.setParameter(ALOCConstants.SEARCHCRITERIATYPE, "8");
			   request.setParameter(ALOCConstants.BUNDLEID, "241");
			   DashboardViewType dashboardViewType=DashboardViewType.valueOf("BUNDLES");
			   searchAction.setDashboardViewType(dashboardViewType);
			   setUserContextDetails();
			   searchAction.setRequest(ServletActionContext.getRequest());
			   String result = searchAction.manageBundleSearch();
			   assertNotNull(result);
			   assertEquals("success",result);
			} catch (HWFServiceException e) {
				e.printStackTrace();
				fail("Error while adding elements");
			}
	}
}
