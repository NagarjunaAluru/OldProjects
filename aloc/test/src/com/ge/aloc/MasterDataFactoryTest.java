/**
 * 
 */
package com.ge.aloc;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.model.MDM;
import com.ge.aloc.model.MDM.Country;
import com.ge.aloc.model.MDM.Currency;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author madhusudhan.gosula
 *
 */
public class MasterDataFactoryTest {
	private MasterDataFactory masterDataFactory;
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
		masterDataFactory = new MasterDataFactory();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.ge.aloc.MasterDataFactory#MasterDataFactory()}.
	 */
	@Test
	public final void testMasterDataFactory() {
		assertNotNull(masterDataFactory);
	}

	/**
	 * Test method for {@link com.ge.aloc.MasterDataFactory#createEntry(java.lang.Object)}.
	 */
	@Test
	public final void testCreateEntry() {
		try {
			masterDataFactory.createEntry("master_static_data_management");
		} catch (HWFServiceException e) {
			fail("master data load failed :::"+e.getMessage());
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.MasterDataFactory#getMasterData()}.
	 */
	@Test
	public final void testGetMasterData() {
		MDM mdm = masterDataFactory.getMasterData();
		assertNotNull(mdm);
	}


	/**
	 * Test method for {@link com.ge.aloc.MasterDataFactory#getCountries()}.
	 */
	@Test
	public final void testGetCountries() {
		List<Country> countries = masterDataFactory.getCountries();
		assertNotNull(countries);
	}

	/**
	 * Test method for {@link com.ge.aloc.MasterDataFactory#getCurrencies()}.
	 */
	@Test
	public final void testGetCurrencies() {
		List<Currency> currencies = masterDataFactory.getCurrencies();
		assertNotNull(currencies);
	}

}
