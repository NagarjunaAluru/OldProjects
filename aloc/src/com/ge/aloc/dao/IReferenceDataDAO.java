/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: IReferenceDataDAO.java
 * Purpose: IReferenceDataDAO used for all the ajax DAO declarations
 */
package com.ge.aloc.dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import com.ge.aloc.model.InstrumentRisk;
import com.ge.aloc.model.NameValue;
import com.ge.aloc.model.PoleCountry;
import com.ge.aloc.model.Reimbursement;
import com.ge.aloc.model.RequestDetails;
import com.ge.aloc.model.SiteAdminStaticData;
import com.ge.aloc.model.StaticDataManagement;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author narasimhulu.b
 *
 */
public interface IReferenceDataDAO {

	/**
	 * This method is used to get the usd equal amount to original amount
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
	 * This method is used to get Bond sub types 
	 * @param bondType
	 * @return
	 * @throws HWFServiceException
	 */
	List<NameValue> getBondSubTypes(String bondType) throws HWFServiceException;

	/**
	 * Method to get the Site Names
	 * @return
	 * @throws HWFServiceException
	 */
	List<SiteAdminStaticData.SitesList> getSiteNames() throws HWFServiceException;

	/**
	 * Method to get the Parent Sites
	 * @return
	 * @throws HWFServiceException
	 */
	List<SiteAdminStaticData.SitesList> getAvailSites(String modifySiteTypeId) throws HWFServiceException;

	/**
	 * 
	 * Method to get the Parent Prefix, parent description & child sites
	 * @return
	 * @throws HWFServiceException
	 */
	StaticDataManagement getChildSites(String parentSiteId) throws HWFServiceException;

	/**
	 * This method is used to Check the Site Name Valid or Not
	 * @throws HWFServiceException
	 */
	String checkSiteNameValid(String siteName) throws HWFServiceException;

	/**
	 * This method is used to Check the Site Prefix Valid or Not
	 * @param sitePrefix
	 * @return
	 * @throws HWFServiceException
	 */
	String checkSitePrefixValid(String sitePrefix) throws HWFServiceException;


	/**
	 * This method is used to get the site list based on selected site types
	 * @return
	 * @throws HWFServiceException
	 */
	List<SiteAdminStaticData.SitesList> getSites(StaticDataManagement staticDataMgmt) throws HWFServiceException;

	/**
	 * This method is used to get delegation approvers
	 * @param revisedContractAmt
	 * @param instrumentTypeId
	 * @param requestId
	 * @return
	 */
	RequestDetails getDelegationApprovers(BigInteger requestId,BigInteger instrumentTypeId,BigDecimal approverAmount,String wfstage,InstrumentRisk instrumentRisk) throws HWFServiceException;
	
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
