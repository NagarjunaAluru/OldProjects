/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ReferenceDataManager.java
 * Purpose: ReferenceDataManager used for all the ajax operations
 */
package com.ge.aloc.manager.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.ge.aloc.ALOCContext;
import com.ge.aloc.InstrumentType;
import com.ge.aloc.SiteType;
import com.ge.aloc.StaticDataFactory;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.dao.IReferenceDataDAO;
import com.ge.aloc.manager.IReferenceDataManager;
import com.ge.aloc.model.InstrumentRisk;
import com.ge.aloc.model.NameValue;
import com.ge.aloc.model.PoleCountry;
import com.ge.aloc.model.Reimbursement;
import com.ge.aloc.model.RequestDetails;
import com.ge.aloc.model.SiteAdminStaticData;
import com.ge.aloc.model.SiteAdminStaticData.SitesList;
import com.ge.aloc.model.StaticDataManagement;
import com.ge.aloc.model.StaticDataManagement.ParentSites;
import com.ge.aloc.model.StaticDataManagement.UserSites;
import com.ge.aloc.util.JSONHelper;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.hydus.hwf.exceptions.HWFServiceException;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author narasimhulu.b
 *
 */
public class ReferenceDataManager implements IReferenceDataManager {
	private IReferenceDataDAO referenceDataDAO;

	/**
	 * @see IReferenceDataManager#getUSDEquivalentDetails(String, BigDecimal)
	 */
	public BigDecimal getUSDEquivalentDetails(String curencyCode, BigDecimal originalAmount) throws HWFServiceException {
		return referenceDataDAO.getUSDEquivalentDetails(curencyCode, originalAmount);
	}

	/**
	 * @see IReferenceDataManager#getSiteType(String)
	 */
	public RequestDetails getSiteType(String siteId) throws HWFServiceException {
		return referenceDataDAO.getSiteType(siteId);
	}

	/**
	 * @see IReferenceDataManager#getBondSubTypes(String)
	 */
	public void getBondSubTypes(Boolean isAdmin) throws HWFServiceException {

		String bondType = ServletActionContext.getRequest().getParameter(ALOCConstants.BONDTYPE);
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			List<NameValue> bondSubTypes = referenceDataDAO.getBondSubTypes(bondType);
			JsonObject result = new JsonObject();
			JsonArray respnseData = new JsonArray();

			if(isAdmin){
				for(NameValue subBondType : bondSubTypes) {
					if(!(subBondType.getID().intValue()==ALOCConstants.SUB_DIVISION_BOND_ID)){
						JsonObject jsonSubType = new JsonObject();
						jsonSubType.addProperty(ALOCConstants.JSON_PROP_ID, subBondType.getID());
						jsonSubType.addProperty(ALOCConstants.JSON_PROP_NAME, subBondType.getName());
						respnseData.add(jsonSubType);
					}
				}
			}else{
				for(NameValue subType : bondSubTypes) {
					JsonObject jsonSubType = new JsonObject();
					jsonSubType.addProperty(ALOCConstants.JSON_PROP_ID, subType.getID());
					jsonSubType.addProperty(ALOCConstants.JSON_PROP_NAME, subType.getName());
					respnseData.add(jsonSubType);
				}
			}

			result.add(ALOCConstants.RESULT, respnseData);
			JSONHelper.writeResponse(result, response);
		} catch (HWFServiceException hwfse) {
			JSONHelper.writeFailureResponse(hwfse.getCode(), hwfse.getLocalizedMessage(), response);
		}
	}


	/**
	 * Method to get the site Names
	 * @throws HWFServiceException
	 */
	@SuppressWarnings("unchecked")
	public void getSiteNames() throws HWFServiceException {
		HttpServletResponse response = ServletActionContext.getResponse();
		String businessSite = ServletActionContext.getRequest().getParameter(ALOCConstants.BUSINESS_SITE);
		try {
			List<SiteAdminStaticData.SitesList> siteTypes = referenceDataDAO.getSiteNames();
			JsonObject result = new JsonObject();
			JsonArray respnseData = new JsonArray();

			if(StringUtils.isNotBlank(businessSite)){
				Map<String, Object> sessionValues = ActionContext.getContext().getSession();
				List<UserSites> userSpecificSitesList=(List<UserSites>) sessionValues.get(ALOCConstants.USERSPECIFICSITES);
				if(userSpecificSitesList == null){
					userSpecificSitesList = new ArrayList<StaticDataManagement.UserSites>();
				}
				for(UserSites userSite : userSpecificSitesList) {
					for(SitesList eachSite : siteTypes) {
						if(userSite.getID()!=null&&eachSite.getSiteId()!=null&&(userSite.getID()).equals(eachSite.getSiteId())){
							BigInteger siteTypeId = eachSite.getSiteTypeId();
							SiteType siteType = (siteTypeId != null) ? SiteType.fromId(siteTypeId.intValue()) : null;
							if(siteType !=null && (siteType==SiteType.FINANCIAL_BUSINESS_SITE || siteType==SiteType.INDUSTRAIL_BUSINESS_SITE)){
								JsonObject jsonSubType = new JsonObject();
								jsonSubType.addProperty(ALOCConstants.JSON_PROP_ID, eachSite.getSiteId());
								jsonSubType.addProperty(ALOCConstants.JSON_PROP_NAME, eachSite.getSiteName());
								jsonSubType.addProperty(ALOCConstants.JSON_PROP_PREFIX, eachSite.getSitePrefix());
								respnseData.add(jsonSubType);
								break;
							}
						}
					}
				}
			}else{
				for(SitesList eachSite : siteTypes) {
					JsonObject jsonSubType = new JsonObject();
					BigInteger siteTypeId = eachSite.getSiteTypeId();
					SiteType siteType = (siteTypeId != null) ? SiteType.fromId(siteTypeId.intValue()) : null;
					if(siteType != null && !(siteType == SiteType.TREASURY)){
						jsonSubType.addProperty(ALOCConstants.JSON_PROP_ID, eachSite.getSiteId());
						jsonSubType.addProperty(ALOCConstants.JSON_PROP_NAME, eachSite.getSiteName());
						respnseData.add(jsonSubType);
					}
				}
			}
			result.add(ALOCConstants.RESULT, respnseData);
			JSONHelper.writeResponse(result, response);
		} catch (HWFServiceException hwfse) {
			JSONHelper.writeFailureResponse(hwfse.getCode(), hwfse.getLocalizedMessage(), response);
		}
	}

	/**
	 * Method to get the site Names
	 * @throws HWFServiceException
	 */
	public List<SiteAdminStaticData.SitesList> getAllSiteNames() throws HWFServiceException {
		return referenceDataDAO.getSiteNames();
	}

	/**
	 * Method to get the Parent Sites
	 * @throws HWFServiceException
	 */
	public void getAvailSites() throws HWFServiceException {
		String modifySiteTypeId = ServletActionContext.getRequest().getParameter(ALOCConstants.MODIFY_SITE_TYPE);
		HttpServletResponse response = ServletActionContext.getResponse();

		try {
			List<SiteAdminStaticData.SitesList> siteTypes = referenceDataDAO.getAvailSites(modifySiteTypeId);

			StaticDataFactory staticDataFactory =ALOCContext.getStaticDataFactory(); 
			staticDataFactory.removeSitesLst();

			JsonObject result = new JsonObject();
			JsonArray respnseData = new JsonArray();
			if(siteTypes!=null){
				for(SitesList subType : siteTypes) {
					JsonObject jsonSubType = new JsonObject();
					jsonSubType.addProperty(ALOCConstants.JSON_PROP_ID, subType.getSiteId());
					jsonSubType.addProperty(ALOCConstants.JSON_PROP_NAME, subType.getSiteName());
					jsonSubType.addProperty(ALOCConstants.JSON_PROP_PREFIX, subType.getSitePrefix());
					respnseData.add(jsonSubType);
				}
			}
			result.add(ALOCConstants.RESULT, respnseData);
			JSONHelper.writeResponse(result, response);
		} catch (HWFServiceException hwfse) {
			JSONHelper.writeFailureResponse(hwfse.getCode(), hwfse.getLocalizedMessage(), response);
		}
	}

	/**
	 *  Method to get the Parent prefix,Description & ChildSites Types from the Service
	 * @throws HWFServiceException
	 * @return the ChildSites
	 */
	public void getChildSites() throws HWFServiceException {
		String parentSiteId = ServletActionContext.getRequest().getParameter(ALOCConstants.PARENT_SITEID);
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			StaticDataManagement staticdata= referenceDataDAO.getChildSites(parentSiteId);
			List<ParentSites> parentSitesLst = staticdata.getParentSites();
			SiteAdminStaticData siteStaticdata = staticdata.getSiteAdminStaticData();

			JsonObject result = new JsonObject();
			JsonArray respnseData = new JsonArray();

			JsonObject jsonSubType = new JsonObject();
			if(parentSitesLst!=null){
				jsonSubType.addProperty(ALOCConstants.JSON_PROP_ID, parentSitesLst.get(ALOCConstants.PARENTSITE_BASE_INDEX).getParentSiteDescription());
				jsonSubType.addProperty(ALOCConstants.JSON_PROP_NAME, parentSitesLst.get(ALOCConstants.PARENTSITE_BASE_INDEX).getParentSitePrefix());
			}

			if(siteStaticdata!=null && siteStaticdata.getSitesLists().size()!=ALOCConstants.SELSITES_BASE_SIZE){
				List<SitesList> sitesLst = siteStaticdata.getSitesLists();
				for(SitesList eachSite : sitesLst){
					jsonSubType.addProperty(ALOCConstants.CHILD_SITES, eachSite.getSiteName());
					jsonSubType.addProperty(ALOCConstants.SITE_CODE, eachSite.getSiteCode());
					jsonSubType.addProperty(ALOCConstants.DESIGNATION, eachSite.getDesignation());
					respnseData.add(jsonSubType);
					jsonSubType = new JsonObject();
				}
			}else{
				respnseData.add(jsonSubType);
			}
			result.add(ALOCConstants.RESULT, respnseData);
			JSONHelper.writeResponse(result, response);
		} catch (HWFServiceException hwfse) {
			JSONHelper.writeFailureResponse(hwfse.getCode(), hwfse.getLocalizedMessage(), response);
		}
	}

	/**
	 * This method is used to Check the Site Name Valid or Not
	 * @throws HWFServiceException 
	 * @see com.ge.aloc.manager.ISiteDetailsManager#checkSiteNameValid()
	 */
	public void checkSiteNameValid() throws HWFServiceException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String siteName =  request.getParameter(ALOCConstants.SITENAME);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType(ALOCConstants.MIMETYPE_TEXT_STRING);
		try {
			String siteNameVal = referenceDataDAO.checkSiteNameValid(siteName);
			JsonObject result = new JsonObject();
			JsonArray jsonArray = new JsonArray();
			JsonObject obj = new JsonObject();
			obj.addProperty(ALOCConstants.SITENAMEVAL, siteNameVal);
			jsonArray.add(obj);

			result.add(ALOCConstants.RESULT, jsonArray);
			JSONHelper.writeResponse(result, response);
		} catch (HWFServiceException hwfse) {
			JSONHelper.writeFailureResponse(hwfse.getCode(), hwfse.getLocalizedMessage(), response);
		}
	}

	/**
	 * This method is used to Check the Site Prefix Valid or Not
	 * @param siteName
	 * @throws HWFServiceException
	 */
	public void checkSitePrefixValid() throws HWFServiceException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String sitePrefix =  request.getParameter(ALOCConstants.SITEPREFIX);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType(ALOCConstants.MIMETYPE_TEXT_STRING);
		try {
			String sitePrefixVal = referenceDataDAO.checkSitePrefixValid(sitePrefix);
			JsonObject result = new JsonObject();
			JsonArray jsonArray = new JsonArray();
			JsonObject obj = new JsonObject();
			obj.addProperty(ALOCConstants.SITEPREFIXVAL, sitePrefixVal);
			jsonArray.add(obj);

			result.add(ALOCConstants.RESULT, jsonArray);
			JSONHelper.writeResponse(result, response);
		} catch (HWFServiceException hwfse) {
			JSONHelper.writeFailureResponse(hwfse.getCode(), hwfse.getLocalizedMessage(), response);
		}
	}


	/**
	 * This method is used to get the site list based on selected site types
	 * @return
	 * @throws HWFServiceException
	 */
	@SuppressWarnings("unchecked")
	public List<UserSites> getSites() throws HWFServiceException{

		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, Object> sessionValues = ActionContext.getContext().getSession();
		List<UserSites> userSpecificSitesList=(List<UserSites>) sessionValues.get(ALOCConstants.USERSPECIFICSITES);	
		List<UserSites> sitesList = new ArrayList<StaticDataManagement.UserSites>();
		String financialSiteType= request.getParameter(ALOCConstants.FINANCECHECK);
		String industrialSiteType= request.getParameter(ALOCConstants.INDUSTRIALCHECK);
		String isReportsFlag = request.getParameter(ALOCConstants.ISREPORTSFLAG);
		
		if(financialSiteType.equalsIgnoreCase(ALOCConstants.TRUE_SMALL) && industrialSiteType.equalsIgnoreCase(ALOCConstants.TRUE_SMALL)){
			sitesList=userSpecificSitesList;
		}
		else if(financialSiteType.equalsIgnoreCase(ALOCConstants.TRUE_SMALL)){
			for(UserSites usersite:userSpecificSitesList){
				if(usersite.getSiteTypeId().compareTo(BigInteger.valueOf(InstrumentType.BANK_GUARANTEE.getId()))==ALOCConstants.BASE_VALUE){
					sitesList.add(usersite);
				}
			}
		}
		else if(industrialSiteType.equalsIgnoreCase(ALOCConstants.TRUE_SMALL)){
			for(UserSites usersite:userSpecificSitesList){
				if(usersite.getSiteTypeId().compareTo(BigInteger.valueOf(InstrumentType.DOCUMENT_LOC.getId()))==ALOCConstants.BASE_VALUE){
					sitesList.add(usersite);
				}
			}
		}else if(isReportsFlag!=null && isReportsFlag.equalsIgnoreCase(ALOCConstants.TRUE_SMALL)){
			if(!financialSiteType.equalsIgnoreCase(ALOCConstants.TRUE_SMALL) && !industrialSiteType.equalsIgnoreCase(ALOCConstants.TRUE_SMALL)){
			sitesList=userSpecificSitesList;
			}
		}
		return sitesList;		
	}
	
	/**
	 * Method to get the Business site Names
	 * @throws HWFServiceException
	 */
	public List<UserSites> getBusinessSiteNames() throws HWFServiceException {
		List<UserSites> businessSitesList = new ArrayList<StaticDataManagement.UserSites>();
		List<SiteAdminStaticData.SitesList> siteTypes = referenceDataDAO.getSiteNames();
				for(SitesList eachSite : siteTypes) {
					UserSites userSites = new UserSites();
					BigInteger siteTypeId = eachSite.getSiteTypeId();
					SiteType siteType = (siteTypeId != null) ? SiteType.fromId(siteTypeId.intValue()) : null;
					if(siteType != null && (siteType == SiteType.FINANCIAL_BUSINESS_SITE || siteType == SiteType.INDUSTRAIL_BUSINESS_SITE )){
						userSites.setID(eachSite.getSiteId());
						userSites.setName(eachSite.getSiteName());
						businessSitesList.add(userSites);
					}
				}
		return businessSitesList;
	}
	

	/**
	 * This method is used to get delegation approvers on submit
	 *  
	 * @param requestId
	 * @param approverAmount
	 * @param instrumentTypeId
	 * @throws HWFServiceException
	 */
	public RequestDetails getDelegationApprovers(BigInteger requestId,BigInteger instrumentTypeId,BigDecimal approverAmount,String wfstage,InstrumentRisk instrumentRisk) throws HWFServiceException{
		return referenceDataDAO.getDelegationApprovers(requestId,instrumentTypeId,approverAmount,wfstage,instrumentRisk);
	}
	
	/**
	 * This is used to get list of reimbursement agreement available 
	 * @param reimbursement
	 * @return
	 * @throws HWFServiceException
	 */
	public Reimbursement getReimbursementAgreementList(BigInteger requestId)throws HWFServiceException{
		return referenceDataDAO.getReimbursementAgreementList(requestId);
	}

	/**
	 * This is used to get poleName based on the country code for the specific country.
	 * @param countryCode
	 * @return PoleCountry
	 * @throws HWFServiceException
	 */
	public PoleCountry getDefaultPole(String countryCode)throws HWFServiceException{
		return referenceDataDAO.getDefaultPole(countryCode);
	}

	/**
	 * This method is used to create referenceDataDAO instance
	 * @return the referenceDataDAO
	 */
	public IReferenceDataDAO getReferenceDataDAO() {
		return referenceDataDAO;
	}

	/**
	 * This method is used to set referenceDataDAO instance
	 * @param referenceDataDAO the referenceDataDAO to set
	 */
	public void setReferenceDataDAO(IReferenceDataDAO referenceDataDAO) {
		this.referenceDataDAO = referenceDataDAO;
	}



}
