/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: IReferenceDataManager.java
 * Purpose: IReferenceDataManager used for all the ajax operations
 */
package com.ge.aloc.manager;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import com.ge.aloc.model.InstrumentRisk;
import com.ge.aloc.model.PoleCountry;
import com.ge.aloc.model.Reimbursement;
import com.ge.aloc.model.RequestDetails;
import com.ge.aloc.model.SiteAdminStaticData;
import com.ge.aloc.model.StaticDataManagement.UserSites;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author narasimhulu.b
 *
 */
public interface IReferenceDataManager {

	/**
	 * This  method is used to get usd equivalent details for the amount based on currency code.
	 * @param curencyCode
	 * @param originalAmount
	 * @return
	 * @throws HWFServiceException
	 */
	BigDecimal getUSDEquivalentDetails(String curencyCode, BigDecimal originalAmount) throws HWFServiceException;

	/**
	 * This  method is used to get site type based on siteId.
	 * @param siteId
	 * @return site Name
	 * @throws HWFServiceException
	 */

	RequestDetails getSiteType(String siteId) throws HWFServiceException;


	/**
	 * This method is used to bond sub types.
	 * @param bondType
	 * @return
	 * @throws HWFServiceException
	 */
	void getBondSubTypes(Boolean isAdmin) throws HWFServiceException;

	/**
	 * Method to get the Parent Sites
	 * @return
	 * @throws HWFServiceException
	 */
	void getSiteNames() throws HWFServiceException;

	/**
	 * Method to get the Parent Sites
	 * @return
	 * @throws HWFServiceException
	 */
	List<SiteAdminStaticData.SitesList> getAllSiteNames() throws HWFServiceException;

	/**
	 * method to get the Available Sites
	 * @return
	 * @throws HWFServiceException
	 */
	void getAvailSites() throws HWFServiceException;

	/**
	 *  Method to get the Parent prefix,Description & ChildSites Types from the Service
	 * @return
	 * @throws HWFServiceException
	 */
	void getChildSites() throws HWFServiceException;

	/**
	 * This method is used to Check the Site Name Valid or Not
	 * @return
	 * @throws HWFServiceException
	 */
	void checkSiteNameValid() throws HWFServiceException;

	/**
	 * This method is used to Check the Site Prefix Valid or Not
	 * @param siteName
	 * @throws HWFServiceException
	 */
	void checkSitePrefixValid() throws HWFServiceException;


	/**
	 * This method is used to get the site list based on selected site types
	 * @return
	 * @throws HWFServiceException
	 */
	List<UserSites> getSites() throws HWFServiceException;


	/**
	 * This method is used to get delegation approvers for request
	 * @param revisedContractAmt
	 * @param instrumentTypeId
	 * @param requestId
	 * @return
	 */
	RequestDetails getDelegationApprovers(BigInteger requestId,BigInteger instrumentTypeId,BigDecimal approverAmount,String wfstage,InstrumentRisk instrumentRisk) throws HWFServiceException;
	
	
	/**
	 * This method is used to get the business site list
	 * 
	 * @return
	 * @throws HWFServiceException
	 */
	public List<UserSites> getBusinessSiteNames() throws HWFServiceException;

	/**
	 * This is used to get list of reimbursement agreement available 
	 * @param reimbursement
	 * @return
	 * @throws HWFServiceException
	 */
	public Reimbursement getReimbursementAgreementList(BigInteger requestId)throws HWFServiceException;
	
	
	/**
	 * This is used to get poleName based on the country code for the specific country.
	 * @param countryCode
	 * @return PoleCountry
	 * @throws HWFServiceException
	 */

	public PoleCountry getDefaultPole(String countryCode) throws HWFServiceException;


}
