/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ReferenceDataDAO.java
 * Purpose: ReferenceDataDAO used for all the ajax DAO implementations
 */
package com.ge.aloc.dao.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.ge.aloc.ALOCContext;
import com.ge.aloc.InstrumentType;
import com.ge.aloc.OpCode;
import com.ge.aloc.ServiceClientSupport;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.dao.IReferenceDataDAO;
import com.ge.aloc.model.InstrumentRisk;
import com.ge.aloc.model.MDM;
import com.ge.aloc.model.MsgHeader;
import com.ge.aloc.model.NameValue;
import com.ge.aloc.model.ParentSiteDetails;
import com.ge.aloc.model.PoleCountry;
import com.ge.aloc.model.Rates;
import com.ge.aloc.model.Reimbursement;
import com.ge.aloc.model.RequestDetails;
import com.ge.aloc.model.SiteAdmin;
import com.ge.aloc.model.SiteAdminStaticData;
import com.ge.aloc.model.SiteAdminStaticData.SitesList;
import com.ge.aloc.model.StaticDataManagement;
import com.ge.aloc.model.StaticDataManagement.UserSites;
import com.ge.aloc.model.WFDetails;
import com.ge.aloc.util.ALOCCommonHelper;
import com.hydus.hwf.context.UserContext;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author narasimhulu.b
 * 
 */
public class ReferenceDataDAO extends ServiceClientSupport implements IReferenceDataDAO {

	/**
	 * This method is used to get usd equivalent details based on currency code
	 * for the specified amount.
	 * 
	 * @param curencyCode
	 * @param curencyCode
	 * @throws HWFServiceException
	 * 
	 */
	public BigDecimal getUSDEquivalentDetails(String curencyCode, BigDecimal originalAmount) throws HWFServiceException {

		MDM mdmObject = new MDM();
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.MORRATE.getOperationCode());
		mdmObject.setMsgHeader(msgHeader);
		BigDecimal usdAmount = null;
		Rates rates = new Rates();
		rates.setFrequency(originalAmount);
		rates.setObjectCurrencyCode(curencyCode);
		List<Rates> ratesList = new ArrayList<Rates>();
		ratesList.add(rates);
		mdmObject.setRates(ratesList);
		mdmObject = serviceClient.invokeService(OpCode.MDM.getOperationCode(), mdmObject, MDM.class);
		if (mdmObject != null) {
			Rates ratesDet = (mdmObject.getRates().size() != ALOCConstants.MDM_RATES_BASE_INDEX) ? mdmObject.getRates().get(ALOCConstants.MDM_RATES_BASE_INDEX) : null;
			if (ratesDet != null) {
				usdAmount = ratesDet.getUSDAmount();
			}
		}
		return usdAmount;
	}

	/**
	 * This method is used to get site type.
	 */
	public RequestDetails getSiteType(String siteId) throws HWFServiceException {
		RequestDetails requestDetails = new RequestDetails();
		MsgHeader msgHeader = ALOCCommonHelper
				.createMsgHeader(OpCode.GETSITETYPE.getOperationCode());
		requestDetails.setMsgHeader(msgHeader);
		requestDetails.setSiteId(new BigInteger(siteId));
		requestDetails = serviceClient.invokeService(
				OpCode.REQUESTDETAILS.getOperationCode(), requestDetails,
				RequestDetails.class);

		return requestDetails;
	}

	/**
	 * This method is used to get bond sub types.
	 * 
	 * @param bondType
	 * @return BondSubTypes
	 */
	public List<NameValue> getBondSubTypes(String bondType)
			throws HWFServiceException {

		StaticDataManagement staticDataObject = new StaticDataManagement();
		MsgHeader msgHeader = ALOCCommonHelper
				.createMsgHeader(OpCode.SUBBONDTYPES.getOperationCode());
		staticDataObject.setMsgHeader(msgHeader);

		List<NameValue> bondTypes = new ArrayList<NameValue>();
		NameValue nameValue = new NameValue();
		nameValue.setID(new BigInteger(bondType));
		bondTypes.add(nameValue);
		staticDataObject.setBondTypes(bondTypes);
		staticDataObject.setUserSites(new ArrayList<UserSites>());
		staticDataObject = serviceClient.invokeService(
				OpCode.STATICDATA.getOperationCode(), staticDataObject,
				StaticDataManagement.class);
		return staticDataObject.getBondSubTypes();
	}

	/**
	 * Method to get the SiteTypes from the Service
	 * 
	 * @return SitesList
	 */
	public List<SiteAdminStaticData.SitesList> getSiteNames()
			throws HWFServiceException {

		StaticDataManagement staticDataObject = new StaticDataManagement();
		MsgHeader msgHeader = ALOCCommonHelper
				.createMsgHeader(OpCode.SITEADMINSTATICDATA.getOperationCode());
		staticDataObject.setMsgHeader(msgHeader);

		List<UserSites> usersites = new ArrayList<UserSites>();
		UserSites usersite = new UserSites();
		String userSSO = UserContext.getContext().getuserDetails().getUserId();
		usersite.setUserSso(userSSO);
		usersites.add(usersite);
		staticDataObject.setUserSites(usersites);
		staticDataObject = serviceClient.invokeService(
				OpCode.STATICDATA.getOperationCode(), staticDataObject,
				StaticDataManagement.class);

		SiteAdminStaticData siteAdminStaticData = staticDataObject
				.getSiteAdminStaticData();
		if (siteAdminStaticData != null) {
			return siteAdminStaticData.getSitesLists();
		}

		return null;

	}

	/**
	 * Method to get the SiteTypes from the Service
	 * 
	 * @param modifySiteTypeId
	 * @return SitesLists
	 */
	public List<SiteAdminStaticData.SitesList> getAvailSites(
			String modifySiteTypeId) throws HWFServiceException {

		StaticDataManagement staticDataObject = new StaticDataManagement();
		MsgHeader msgHeader = ALOCCommonHelper
				.createMsgHeader(OpCode.SITEADMINSTATICDATA.getOperationCode());
		staticDataObject.setMsgHeader(msgHeader);

		SitesList sitesList = new SitesList();
		sitesList.setSiteTypeId(new BigInteger(modifySiteTypeId));
		List<SitesList> list = new ArrayList<SitesList>();
		list.add(sitesList);
		SiteAdminStaticData adminStaticdata = new SiteAdminStaticData();
		adminStaticdata.setSitesLists(list);

		staticDataObject.setSiteAdminStaticData(adminStaticdata);
		staticDataObject = serviceClient.invokeService(
				OpCode.STATICDATA.getOperationCode(), staticDataObject,
				StaticDataManagement.class);

		SiteAdminStaticData siteAdminStaticData = staticDataObject
				.getSiteAdminStaticData();
		if (siteAdminStaticData != null) {
			return siteAdminStaticData.getSitesLists();
		}
		return null;
	}

	/**
	 * Method to get the ChildSites Types from the Service
	 * 
	 * @param parentSiteId
	 * @throws HWFServiceException
	 */
	public StaticDataManagement getChildSites(String parentSiteId)
			throws HWFServiceException {

		StaticDataManagement staticDataObject = new StaticDataManagement();
		MsgHeader msgHeader = ALOCCommonHelper
				.createMsgHeader(OpCode.GETCHILDSITES.getOperationCode());
		staticDataObject.setMsgHeader(msgHeader);

		SiteAdminStaticData adminStaticdata = new SiteAdminStaticData();
		ParentSiteDetails parentSite = new ParentSiteDetails();
		parentSite.setSiteId(new BigInteger(parentSiteId));
		adminStaticdata.setParentSiteDetails(parentSite);
		staticDataObject.setSiteAdminStaticData(adminStaticdata);

		staticDataObject = serviceClient.invokeService(
				OpCode.STATICDATA.getOperationCode(), staticDataObject,
				StaticDataManagement.class);
		return staticDataObject;
	}

	/**
	 * Method to invoke the Service to check the Site Name is Valid or Not
	 * 
	 * @param siteName
	 * @return siteName
	 * @throws HWFServiceException
	 */
	public String checkSiteNameValid(String siteName)
			throws HWFServiceException {
		SiteAdmin siteadmin = new SiteAdmin();
		siteadmin.setSiteName(siteName);
		siteadmin = serviceClient.invokeService(
				OpCode.SITEEXISTEDORNOT.getOperationCode(), siteadmin,
				SiteAdmin.class);
		return siteadmin.getSiteName();
	}

	/**
	 * Method to invoke the Service to check the Site prefix is Valid or Not
	 * 
	 * @param sitePrefix
	 * @return sitePrefix
	 * @throws HWFServiceException
	 */
	public String checkSitePrefixValid(String sitePrefix)
			throws HWFServiceException {
		SiteAdmin siteadmin = new SiteAdmin();
		siteadmin.setSitePrefix(sitePrefix);
		siteadmin = serviceClient.invokeService(
				OpCode.SITEEXISTEDORNOT.getOperationCode(), siteadmin,
				SiteAdmin.class);
		return siteadmin.getSitePrefix();
	}

	/**
	 * This method is used to get the site list based on selected site types
	 * 
	 * @return
	 * @throws HWFServiceException
	 */
	public List<SiteAdminStaticData.SitesList> getSites(
			StaticDataManagement staticDataMgmt) throws HWFServiceException {

		MsgHeader msgHeader = ALOCCommonHelper
				.createMsgHeader(OpCode.SITEADMINSTATICDATA.getOperationCode());
		staticDataMgmt.setMsgHeader(msgHeader);
		staticDataMgmt = serviceClient.invokeService(
				OpCode.STATICDATA.getOperationCode(), staticDataMgmt,
				StaticDataManagement.class);
		List<SiteAdminStaticData.SitesList> selsites = staticDataMgmt
				.getSiteAdminStaticData().getSitesLists();
		return selsites;
	}

	/**
	 * This method is used to get delegation approvers on submit
	 * 
	 * @param requestId
	 * @param approverAmount
	 * @param instrumentTypeId
	 * @return RequestDetails
	 * @throws HWFServiceException
	 */
	public RequestDetails getDelegationApprovers(BigInteger requestId,BigInteger instrumentTypeId,BigDecimal approverAmount,String wfstage,InstrumentRisk instrumentRisk) throws HWFServiceException{
		RequestDetails requestDetails = new RequestDetails();
		WFDetails wfDetails = new WFDetails();
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.GETAPPROVERS.getOperationCode());
		if(instrumentTypeId.intValue()==InstrumentType.BANK_GUARANTEE.getId() || instrumentTypeId.intValue()==InstrumentType.LOC.getId()){
			requestDetails.setInstrumentRisk(instrumentRisk);
			}
		requestDetails.setMsgHeader(msgHeader);
		requestDetails.setRequestId(requestId);
		requestDetails.setInstrumentTypeId(instrumentTypeId);
		requestDetails.setApproverAmount(approverAmount);
		wfDetails.setWFStage(wfstage);
		requestDetails.setWFDetails(wfDetails);
		return (RequestDetails) serviceClient.invokeService(OpCode.APPROVE.getOperationCode(), requestDetails, RequestDetails.class);

	}
	
	/**
	 * This is used to get list of reimbursement agreement available 
	 * @param reimbursement
	 * @return
	 * @throws HWFServiceException
	 */
	public Reimbursement getReimbursementAgreementList(BigInteger requestId)throws HWFServiceException{
		Reimbursement reimbursement = new Reimbursement();
		reimbursement.setRequestId(requestId);
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.GETREQUESTREIMBURSEMENT.getOperationCode());
		reimbursement.setMsgHeader(msgHeader);
		reimbursement = serviceClient.invokeService(OpCode.REIMBURSEMENTAGREEMENT.getOperationCode(), reimbursement,Reimbursement.class);
		return reimbursement;
		
		
	}
	
	/**
	 * This is used to get poleName based on the country code for the specific country.
	 * @param countryCode
	 * @return PoleCountry
	 * @throws HWFServiceException
	 */

	public PoleCountry getDefaultPole(String countryCode) throws HWFServiceException{
		PoleCountry poleCountry = new PoleCountry();
		poleCountry.setCountryName(countryCode);
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.GETPOLECOUNTRY.getOperationCode());
		poleCountry.setMsgHeader(msgHeader);
		poleCountry = serviceClient.invokeService(OpCode.GETPOLECOUNTRY.getOperationCode(), poleCountry,PoleCountry.class);
		return poleCountry;
		
	}
	
	

}
