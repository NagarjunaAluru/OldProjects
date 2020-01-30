package com.ge.aloc.action.siteadmin;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.OpCode;
import com.ge.aloc.StaticDataFactory;
import com.ge.aloc.bo.SiteDetailsBO;
import com.ge.aloc.common.AbstractTestCase;
import com.ge.aloc.model.ActionDetails;
import com.ge.aloc.model.BankDetails;
import com.ge.aloc.model.BankFeePaymentSetup;
import com.ge.aloc.model.BankPayment;
import com.ge.aloc.model.BankSWIFTConfiguration;
import com.ge.aloc.model.BankSwift;
import com.ge.aloc.model.ParentSite;
import com.ge.aloc.model.SiteAdmin;
import com.ge.aloc.model.SiteType;
import com.ge.aloc.util.SiteAdminHelper;
import com.hydus.hwf.context.UserContext;
import com.hydus.hwf.exceptions.HWFServiceException;

public class SiteAdminActionTest extends AbstractTestCase{


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
	 * Test method for {@link com.ge.aloc.action.siteadin.SiteAdminAction#openActiveSite()}.
	 */
	@Test
	public void testOpenSiteAdminPage() {
		SiteAdminAction siteAdminAction;

		try {
			SiteAdmin siteAdmin = openSiteAdmin("1566");
			assertNotNull(siteAdmin);
			StaticDataFactory sdf = (StaticDataFactory)servletContext.getAttribute(StaticDataFactory.CTX_KEY);
			UserContext.getContext().getApplicationScopedContext().put(StaticDataFactory.CTX_KEY, sdf);
			siteAdminAction = new SiteAdminAction();
			String result = siteAdminAction.openSiteAdminPage();
			assertEquals("openSiteAdminPage", result);
		} catch (Exception e) {
			assertEquals("An error has occured, please check log for more details",e.getMessage());
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.action.siteadin.SiteAdminAction#createSite()}.
	 * @throws HWFServiceException 
	 */
	@Test
	public void testCreateSite() {

		SiteAdminAction siteAdminAction;
		try {
			siteAdminAction = createSite();
			SiteAdmin siteAdmin = siteAdminAction.getSiteDetailsBO().getModel();
			siteAdmin.setSiteName("Junit test2");//Need to provide Valid SiteName
			siteAdmin.setSitePrefix("junit2");//Need to provide Valid SitePrefix
			siteAdmin.setDescription("Junit test");

			SiteType siteType = new SiteType();
			siteType.setSiteTypeId(Integer.valueOf(1));
			siteType.setSiteTypeName("Financial Business");
			siteAdmin.setSiteType(siteType);

			ParentSite parentSite = new ParentSite();
			parentSite.setParentSiteId(Integer.valueOf(5));
			parentSite.setParentSiteName("GE");
			siteAdmin.setParentSite(parentSite);

			siteAdmin.setHeaderSiteOnly(new Boolean(false));
			siteAdmin.setLeGoldId("000063");
			siteAdmin.setLeName("GE Finance");
			siteAdmin.setLeMDMId(new BigInteger("1233"));

			ActionDetails actionDet = new ActionDetails();
			actionDet.setActionName(OpCode.SAVE.getOperationCode());
			siteAdmin.setActionDetails(actionDet);

			SiteDetailsBO siteDetailsBO = new SiteDetailsBO(siteAdmin);
			SiteAdminHelper.setActiveSite(siteDetailsBO);
			setUserContextDetails();
			StaticDataFactory sdf = (StaticDataFactory)servletContext.getAttribute(StaticDataFactory.CTX_KEY);
			UserContext.getContext().getApplicationScopedContext().put(StaticDataFactory.CTX_KEY, sdf);
			assertNotNull(sdf);			
			siteAdminAction.createSite();
			assertNotNull(siteAdmin);
		} catch (Exception e) {
			fail("ALOC_SITECREATEREQUEST_ERROR"+e.getMessage());
		}

	}

	/**
	 * Test method for {@link com.ge.aloc.action.siteadin.SiteAdminAction#createSite()}.
	 * @throws HWFServiceException 
	 */
	@Test
	public void testOpenBusinessAdmin() throws HWFServiceException{
		try {
			SiteAdmin siteAdmin = openSiteAdmin("1566");//Need to provide Valid SiteId
			assertNotNull(siteAdmin);
			assertEquals("STHF03", siteAdmin.getSitePrefix());//Need to provide SitePrefix of the above given SiteId
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.action.siteadin.SiteAdminAction#createBankSite()}.
	 * @throws HWFServiceException 
	 */
	@Test
	public void testCreateBankSite() {
		SiteAdminAction siteAdminAction;

		try {
			siteAdminAction = createSite();
			SiteAdmin siteAdmin = siteAdminAction.getSiteDetailsBO().getModel();

			siteAdmin = getBankSiteDetails(siteAdmin);

			ActionDetails actionDet = new ActionDetails();
			actionDet.setActionName(OpCode.SAVE.getOperationCode());
			siteAdmin.setActionDetails(actionDet);
			setUserContextDetails();
			StaticDataFactory sdf = (StaticDataFactory)servletContext.getAttribute(StaticDataFactory.CTX_KEY);
			UserContext.getContext().getApplicationScopedContext().put(StaticDataFactory.CTX_KEY, sdf);
			siteAdminAction.createBankSite();			
			assertNotNull(siteAdmin);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.action.siteadin.SiteAdminAction#openCreateSite()}.
	 * @throws HWFServiceException 
	 */
	@Test
	public void testOpenCreateSite() {
		SiteAdminAction siteAdminAction;

		try {
			openSiteAdmin("1566");//Need to provide Valid SiteId
			siteAdminAction = siteAdminAction("openCreateSite");
			assertNotNull(siteAdminAction);
			setUserContextDetails();
			StaticDataFactory sdf = (StaticDataFactory)servletContext.getAttribute(StaticDataFactory.CTX_KEY);
			UserContext.getContext().getApplicationScopedContext().put(StaticDataFactory.CTX_KEY, sdf);
			String result = siteAdminAction.openCreateSite();
			assertEquals("openCreateSite", result);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Method to set the BankSite details
	 *  
	 */
	@Test
	public SiteAdmin getBankSiteDetails(SiteAdmin siteAdmin) {

		siteAdmin.setSiteName("Junit BankSite2");//Need to provide Valid SiteName
		siteAdmin.setSitePrefix("JUnit2");//Need to provide Valid SitePrefix
		siteAdmin.setDescription("Junit Bank site test");

		SiteType siteType = new SiteType();
		siteType.setSiteTypeId(Integer.valueOf(2));
		siteType.setSiteTypeName("Bank");
		siteAdmin.setSiteType(siteType);

		ParentSite parentSite = new ParentSite();
		parentSite.setParentSiteId(Integer.valueOf(817));
		parentSite.setParentSiteName("header");
		siteAdmin.setParentSite(parentSite);

		siteAdmin.setTriPartyEnabled(new Boolean(true));
		siteAdmin.setPrivateLabel(new Boolean(false));
		siteAdmin.setGroupEmailAddress("aloc@hydus.com");

		BankDetails bankLookupDet = new BankDetails();
		bankLookupDet.setName("Swiss Bank");
		bankLookupDet.setBankIdentifierCode("BIC_1");

		List<String> addr = new ArrayList<String>();
		addr.add("Main Line");
		addr.add("AK Street");
		bankLookupDet.setAddress(addr);

		bankLookupDet.setCity("Switzerland");
		bankLookupDet.setCountry("Switzerland");
		bankLookupDet.setStateProvince("100012");
		bankLookupDet.setZIPPostalCode("100012");
		bankLookupDet.setBankMDMId(new BigInteger("1"));

		BankFeePaymentSetup bankFee = new BankFeePaymentSetup();
		bankFee.setBankModelCode("Model code1");
		siteAdmin.setBankFeePaymentSetup(bankFee);
		List<BankPayment> paymentsLst = new ArrayList<BankPayment>();
		BankPayment payments = new BankPayment();
		payments.setPaymentCurrency("INR");
		paymentsLst.add(payments);
		bankFee.setBankPayments(paymentsLst);

		BankSWIFTConfiguration bankSwift = new BankSWIFTConfiguration();
		bankSwift.setBankIdentifierCodeAddress("BIC_2");
		bankSwift.setSWIFTEnabled(new Boolean(true));
		bankSwift.withIsFileActEnabled(true);

		List<BankSwift> bankSwiftsLst = new ArrayList<BankSwift>();

		BankSwift bankSwifts = new BankSwift();
		bankSwifts.setMessageType("MT760");
		bankSwifts.setMessageDirection("Inbound");
		bankSwifts.setMessageSupport(new Boolean(true));
		bankSwifts.setMessageTypeId(new BigInteger("1"));
		bankSwiftsLst.add(bankSwifts);

		BankSwift bankSwifts1 = new BankSwift();
		bankSwifts1.setMessageType("MT761");
		bankSwifts1.setMessageSupport(new Boolean(false));
		bankSwifts1.setMessageTypeId(new BigInteger("2"));
		bankSwiftsLst.add(bankSwifts1);

		BankSwift bankSwifts2 = new BankSwift();
		bankSwifts2.setMessageType("MT762");
		bankSwifts2.setMessageDirection("Inbound");
		bankSwifts2.setMessageSupport(new Boolean(true));
		bankSwifts2.setMessageTypeId(new BigInteger("3"));
		bankSwiftsLst.add(bankSwifts2);

		BankSwift bankSwifts3 = new BankSwift();
		bankSwifts3.setMessageType("MT763");
		bankSwifts3.setMessageSupport(new Boolean(false));
		bankSwifts3.setMessageTypeId(new BigInteger("4"));
		bankSwiftsLst.add(bankSwifts3);

		BankSwift bankSwifts4 = new BankSwift();
		bankSwifts4.setMessageType("MT764");
		bankSwifts4.setMessageDirection("Outbound");
		bankSwifts4.setMessageSupport(new Boolean(true));
		bankSwifts4.setMessageTypeId(new BigInteger("5"));
		bankSwiftsLst.add(bankSwifts4);

		BankSwift bankSwifts5 = new BankSwift();
		bankSwifts5.setMessageType("MT767");
		bankSwifts5.setMessageSupport(new Boolean(false));
		bankSwifts5.setMessageTypeId(new BigInteger("6"));
		bankSwiftsLst.add(bankSwifts5);

		BankSwift bankSwifts6 = new BankSwift();
		bankSwifts6.setMessageType("MT784");
		bankSwifts6.setMessageDirection("Outbound");
		bankSwifts6.setMessageSupport(new Boolean(true));
		bankSwifts6.setMessageTypeId(new BigInteger("7"));
		bankSwiftsLst.add(bankSwifts6);

		BankSwift bankSwifts7 = new BankSwift();
		bankSwifts7.setMessageType("MT785");
		bankSwifts7.setMessageSupport(new Boolean(false));
		bankSwifts7.setMessageTypeId(new BigInteger("8"));
		bankSwiftsLst.add(bankSwifts7);

		BankSwift bankSwifts8 = new BankSwift();
		bankSwifts8.setMessageType("MT786");
		bankSwifts8.setMessageDirection("Outbound");
		bankSwifts8.setMessageSupport(new Boolean(true));
		bankSwifts8.setMessageTypeId(new BigInteger("9"));
		bankSwiftsLst.add(bankSwifts8);

		BankSwift bankSwifts9 = new BankSwift();
		bankSwifts9.setMessageType("MT787");
		bankSwifts9.setMessageSupport(new Boolean(false));
		bankSwifts9.setMessageTypeId(new BigInteger("10"));
		bankSwiftsLst.add(bankSwifts9);

		bankSwift.setBankSwifts(bankSwiftsLst);

		siteAdmin.setBankSWIFTConfiguration(bankSwift);

		return siteAdmin;
	}
}
