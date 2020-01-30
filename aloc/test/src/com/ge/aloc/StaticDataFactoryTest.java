/**
 * 
 */
package com.ge.aloc;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.model.NameValue;
import com.ge.aloc.model.StaticDataManagement;
import com.ge.aloc.model.StaticDataManagement.FormatSelection;
import com.ge.aloc.model.StaticDataManagement.ParentSites;
import com.ge.aloc.model.StaticDataManagement.StateList.StateInfo;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author madhusudhan.gosula
 *
 */
public class StaticDataFactoryTest {
	private StaticDataFactory staticDataFactory;

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
		staticDataFactory = new StaticDataFactory();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.ge.aloc.StaticDataFactory#StaticDataFactory()}.
	 */
	@Test
	public final void testStaticDataFactory() {
		assertNotNull(staticDataFactory);
	}

	/**
	 * Test method for {@link com.ge.aloc.StaticDataFactory#getStaticDataManagement()}.
	 */
	@Test
	public final void testGetStaticDataManagement() {
		StaticDataManagement staticDataManagement = staticDataFactory.getStaticDataManagement();
		assertNotNull(staticDataManagement);
	}

	/**
	 * Test method for {@link com.ge.aloc.StaticDataFactory#createEntry(java.lang.Object)}.
	 */
	@Test
	public final void testCreateEntry() {
		try {
			staticDataFactory.createEntry("static_data_management");
		} catch (HWFServiceException e) {
			fail("sttic data load failed :::"+e.getMessage());
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.StaticDataFactory#getBondTypes()}.
	 */
	@Test
	public final void testGetBondTypes() {
		List<NameValue> list = staticDataFactory.getBondTypes();
		assertNotNull(list);
	}

	/**
	 * Test method for {@link com.ge.aloc.StaticDataFactory#getBondSubTypes()}.
	 */
	@Test
	public final void testGetBondSubTypes() {
		List<NameValue> list = staticDataFactory.getBondSubTypes();
		assertNotNull(list);
	}

	/**
	 * Test method for {@link com.ge.aloc.StaticDataFactory#getInstrumentPurpose()}.
	 */
	@Test
	public final void testGetInstrumentPurpose() {
		List<NameValue> list = staticDataFactory.getInstrumentPurpose();
		assertNotNull(list);
	}

	/**
	 * Test method for {@link com.ge.aloc.StaticDataFactory#getInstrumentPurposeList()}.
	 */
	@Test
	public final void testGetInstrumentPurposeList() {
		List<NameValue> list = staticDataFactory.getInstrumentPurposeList();
		assertNotNull(list);
	}

	/**
	 * Test method for {@link com.ge.aloc.StaticDataFactory#getInstrumentType()}.
	 */
	@Test
	public final void testGetInstrumentType() {
		List<NameValue> list = staticDataFactory.getInstrumentType();
		assertNotNull(list);
	}

	/**
	 * Test method for {@link com.ge.aloc.StaticDataFactory#getInstrumentTypeMap()}.
	 */
	@Test
	public final void testGetInstrumentTypeMap() {
		Map<Integer, String> map = staticDataFactory.getInstrumentTypeMap();
		assertNotNull(map);
	}

	/**
	 * Test method for {@link com.ge.aloc.StaticDataFactory#getFormatSelection()}.
	 */
	@Test
	public final void testGetFormatSelection() {
		List<FormatSelection> list = staticDataFactory.getFormatSelection();
		assertNotNull(list);
	}

	/**
	 * Test method for {@link com.ge.aloc.StaticDataFactory#getLCPaymentTerms()}.
	 */
	@Test
	public final void testGetLCPaymentTerms() {
		List<NameValue> list = staticDataFactory.getLCPaymentTerms();
		assertNotNull(list);
	}

	/**
	 * Test method for {@link com.ge.aloc.StaticDataFactory#getSiteTypes()}.
	 */
	@Test
	public final void testGetSiteTypes() {
		List<NameValue> list = staticDataFactory.getSiteTypes();
		assertNotNull(list);
	}

	/**
	 * Test method for {@link com.ge.aloc.StaticDataFactory#getParentSites()}.
	 */
	@Test
	public final void testGetParentSites() {
		List<ParentSites> list = staticDataFactory.getParentSites();
		assertNotNull(list);
	}

	/**
	 * Test method for {@link com.ge.aloc.StaticDataFactory#getBankCharges()}.
	 */
	@Test
	public final void testGetBankCharges() {
		List<NameValue> list = staticDataFactory.getBankCharges();
		assertNotNull(list);
	}

	/**
	 * Test method for {@link com.ge.aloc.StaticDataFactory#getPolesDetails()}.
	 */
	@Test
	public final void testGetPolesDetails() {
		List<NameValue> list = staticDataFactory.getPolesDetails();
		assertNotNull(list);
	}

	/**
	 * Test method for {@link com.ge.aloc.StaticDataFactory#getUserSites()}.
	 */
	@Test
	public final void testGetUserSites() {
		List<NameValue> list = staticDataFactory.getUserSites();
		assertNotNull(list);
	}

	/**
	 * Test method for {@link com.ge.aloc.StaticDataFactory#getStateList()}.
	 */
	@Test
	public final void testGetStateList() {
		List<StateInfo> list = staticDataFactory.getStateList();
		assertNotNull(list);
	}

	/**
	 * Test method for {@link com.ge.aloc.StaticDataFactory#getGeDivisionsList()}.
	 */
	@Test
	public final void testGetGeDivisionsList() {
		List<NameValue> list = staticDataFactory.getGeDivisionsList();
		assertNotNull(list);
	}

	/**
	 * Test method for {@link com.ge.aloc.StaticDataFactory#getFileExtnsList()}.
	 */
	@Test
	public final void testGetFileExtnsList() {
		List<NameValue> list = staticDataFactory.getFileExtnsList();
		assertNotNull(list);
	}

	/**
	 * Test method for {@link com.ge.aloc.StaticDataFactory#getLinkSearchList()}.
	 */
	@Test
	public final void testGetLinkSearchList() {
		List<NameValue> list = staticDataFactory.getLinkSearchList();
		assertNotNull(list);
	}
}
