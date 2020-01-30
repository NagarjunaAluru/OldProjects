/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: SearchAction.java
 * Purpose: SearchAction used for Search Operations
 */
package com.ge.aloc.action.search;

import java.math.BigInteger;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.ge.aloc.DashboardViewType;
import com.ge.aloc.InstrumentType;
import com.ge.aloc.SearchCriteriaType;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.manager.ISearchManager;
import com.ge.aloc.model.APMDetails;
import com.ge.aloc.model.APMSearch;
import com.ge.aloc.model.GlanceDetails;
import com.ge.aloc.model.Inbox;
import com.ge.aloc.model.Inbox.DashBoardTabsCount;
import com.ge.aloc.model.IssuingBank;
import com.ge.aloc.model.MsgHeader;
import com.ge.aloc.model.Search;
import com.ge.aloc.model.SearchInstrDetails;
import com.ge.aloc.model.SearchReqDetails.BondSubBond;
import com.ge.aloc.model.SiteAdminStaticData.SitesList;
import com.ge.aloc.model.StaticDataManagement.UserSites;
import com.ge.aloc.model.SuretyMasterCollection;
import com.ge.aloc.util.ALOCCommonHelper;
import com.ge.aloc.util.APMDetailsHelper;
import com.hydus.hwf.exceptions.HWFServiceException;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author arijit.biswas
 *
 */
public class SearchAction {

	protected String siteId;
	protected Integer searchCriteriaType;
	protected String searchCriteriaText;
	protected String advanceSearchCriteriaText;
	protected Inbox searchResult;
	protected Inbox results;
	protected DashboardViewType dashboardViewType;
	protected Search searchCriteria;
	protected BigInteger[] instrumentTypes;
	protected String expandBundle;
	protected List<BigInteger> selSites;
	private ISearchManager searchManager;
	private HttpServletRequest request = ServletActionContext.getRequest();
	private List<UserSites> userSpecificSitesList;
	private Map<String, Object> sessionValues = ActionContext.getContext().getSession();
	private List<SitesList> childSitesList = new ArrayList<SitesList>();
	protected APMDetails apmDetails;
	protected APMSearch apmSearch;	
	protected String isInstrumentType1;
	protected String isInstrumentType2;
	protected String isInstrumentType3;
	protected String isInstrumentType4;
	protected String isInstrumentType5;
	protected String isInstrumentType6;
	protected String allInstrumentTypes;
	protected String istripartyApplicant;
	protected String isPrivateApplicant;
	protected String isFinancialCheck;
	protected String isIndustrialCheck;
	protected String financial;
	protected String industrial;
	private String rightSelSites;
	protected String businessContactPersonName;
	protected String newSubBond;
	protected String newInstrumentPurpose;
	protected String newPole;
	protected String newInstrumentCurrency;
	protected String newIssuanceCountry;
	protected List<BondSubBond> bondSubBondList;
	protected IssuingBank issuingBanks;
	SuretyMasterCollection suretyMasterCollection;

	/* --------------------------------------------------------------
	 * 				Start Search Common actions					  *				
	 * -------------------------------------------------------------- */
	/**
	 * method to search the dash board related tabs
	 * @param searchCriteria
	 * @return
	 * @throws HWFServiceException 
	 */
	@SuppressWarnings("unchecked")
	public String basicSearch() throws HWFServiceException {
		GlanceDetails glanceDetails;
		searchCriteriaText = (searchCriteriaText != null) ? searchCriteriaText.trim() : ALOCConstants.EMPTY_STRING;
		if(ALOCConstants.SEARCH_DOT.equals(searchCriteriaText)){
			searchCriteriaText = ALOCConstants.EMPTY_STRING;
		}
		userSpecificSitesList=(List<UserSites>) sessionValues.get(ALOCConstants.USERSPECIFICSITES);
		Search basicSearch = ALOCCommonHelper.populateSearchSchema(siteId, searchCriteriaType, searchCriteriaText, userSpecificSitesList);
		if(dashboardViewType != null){
		searchResult = searchManager.executeSearch(basicSearch, dashboardViewType);
		
		glanceDetails=searchResult.getGlanceDetails();
		if(glanceDetails==null){
			searchResult.setGlanceDetails((GlanceDetails)sessionValues.get(ALOCConstants.GLANCE_DETAILS));
		}
		MsgHeader msgHeader=searchResult.getMsgHeader();
		if(msgHeader==null){
			searchResult.setMsgHeader((MsgHeader)sessionValues.get(ALOCConstants.DASHBOARD_HEADEROPCODE));
		}
		DashBoardTabsCount dashBoardTabsCount = (DashBoardTabsCount) sessionValues.get(ALOCConstants.DASHBOARD_TABS_COUNT);
		if(dashBoardTabsCount != null){
		ALOCCommonHelper.setSearchTabCount(searchResult, dashBoardTabsCount, dashboardViewType);
		}
		}
		return ALOCConstants.SUCCESS;
	}

	/**
	 * This method is used to search bundle for Manage Bundle
	 * @return
	 * @throws HWFServiceException
	 */
	public String manageBundleSearch() throws HWFServiceException {
		searchCriteriaType = SearchCriteriaType.BUNDLE_ID.getId();
		searchCriteriaText = request.getParameter(ALOCConstants.BUNDLEID);
		searchCriteriaText = (searchCriteriaText != null) ? searchCriteriaText.trim() : ALOCConstants.EMPTY_STRING;
		Search basicSearch = ALOCCommonHelper.populateSearchSchema(siteId, searchCriteriaType, searchCriteriaText,userSpecificSitesList);
		searchResult = searchManager.executeSearch(basicSearch, dashboardViewType);
		return ALOCConstants.SUCCESS;
	}

	/**
	 * This method is used to perform fee history search and retrieve the records from DB.
	 * @return
	 * @throws HWFServiceException
	 * @throws ParseException 
	 */
	@SuppressWarnings("unchecked")
	public String basicFHSearch() throws HWFServiceException, ParseException {
		StringBuilder searchCriteria = new StringBuilder();
		searchCriteriaText = (searchCriteriaText != null) ? searchCriteriaText.trim() : ALOCConstants.EMPTY_STRING;
		if(ALOCConstants.APMSEARCH.equals(searchCriteriaText)){
			searchCriteriaText = ALOCConstants.EMPTY_STRING;
		}
		userSpecificSitesList=(List<UserSites>) sessionValues.get(ALOCConstants.USERSPECIFICSITES);
		APMSearch apmSearch=APMDetailsHelper.populateFHsearch(siteId,searchCriteriaType,searchCriteriaText,userSpecificSitesList,searchCriteria);
		apmDetails = searchManager.executeFHSearch(apmSearch);
		apmDetails = APMDetailsHelper.assignDecimalValue(apmDetails);
		sessionValues.put(ALOCConstants.FEE_HISTORY_DETAILS, apmDetails);
		sessionValues.put(ALOCConstants.FEEHISTORY_SEARCH, searchCriteria.toString());
		return ALOCConstants.SUCCESS;
	}

	/**
	 * method to search the dash board related tabs
	 * @param searchCriteria
	 * @return
	 * @throws HWFServiceException 
	 */
	@SuppressWarnings("unchecked")
	public String advanceSearch() throws HWFServiceException {
		GlanceDetails glanceDetails;
		searchCriteria=ALOCCommonHelper.createSearchCriteria(searchCriteria,instrumentTypes,selSites,bondSubBondList);
		if(dashboardViewType != null){
		searchResult = searchManager.executeSearch(searchCriteria, dashboardViewType);
		glanceDetails=searchResult.getGlanceDetails();
		if(glanceDetails==null){
			searchResult.setGlanceDetails((GlanceDetails)sessionValues.get(ALOCConstants.GLANCE_DETAILS));
		}
		MsgHeader msgHeader=searchResult.getMsgHeader();
		if(msgHeader==null){
			searchResult.setMsgHeader((MsgHeader)sessionValues.get(ALOCConstants.DASHBOARD_HEADEROPCODE));
		}
		userSpecificSitesList=(List<UserSites>) sessionValues.get(ALOCConstants.USERSPECIFICSITES); 
		DashBoardTabsCount dashBoardTabsCount = (DashBoardTabsCount) sessionValues.get(ALOCConstants.DASHBOARD_TABS_COUNT);
		if(dashBoardTabsCount != null){
		ALOCCommonHelper.setSearchTabCount(searchResult, dashBoardTabsCount, dashboardViewType);
		}
		setInstrumentTypesChecked(instrumentTypes);
		if(searchCriteria.getTriPartyApplicantFlag()!=null && searchCriteria.getTriPartyApplicantFlag().equalsIgnoreCase(ALOCConstants.TRUE)){
			istripartyApplicant=ALOCConstants.TRUE_SMALL;
		}
		if(searchCriteria.getPrivateLabelApplicantFlag()!=null && searchCriteria.getPrivateLabelApplicantFlag().equalsIgnoreCase(ALOCConstants.TRUE)){
			isPrivateApplicant=ALOCConstants.TRUE_SMALL;
		}
		if(financial!=null && financial.equalsIgnoreCase(ALOCConstants.TRUE_SMALL)){
			isFinancialCheck=ALOCConstants.TRUE_SMALL;
		}
		if(industrial!=null && industrial.equalsIgnoreCase(ALOCConstants.TRUE_SMALL)){
			isIndustrialCheck=ALOCConstants.TRUE_SMALL;
		}
		rightSelSites = ALOCCommonHelper.setSelectedSitesForAdvanceSearch(selSites);
		}
		return ALOCConstants.SUCCESS;
	}

	/**
	 * method to set the checked instrumentTypes in advance search
	 * @param checkedInstrumentTypes
	 */
	private void setInstrumentTypesChecked(BigInteger[] checkedInstrumentTypes) {
		if(checkedInstrumentTypes != null){
		for(BigInteger id : checkedInstrumentTypes){
			if(id != null && id.intValue() == InstrumentType.BANK_GUARANTEE.getId()) {
				isInstrumentType1 = ALOCConstants.TRUE_SMALL; }
			else if(id != null && id.intValue() == InstrumentType.LOC.getId()) {
				isInstrumentType2 = ALOCConstants.TRUE_SMALL; }
			else if(id != null && id.intValue() == InstrumentType.SURETY_BOND.getId()) {
				isInstrumentType3 = ALOCConstants.TRUE_SMALL; }
			else if(id != null && id.intValue() == InstrumentType.DOCUMENT_LOC.getId()) {
				isInstrumentType4 = ALOCConstants.TRUE_SMALL; }
			else if(id != null && id.intValue() == InstrumentType.AMENDMENT.getId()) {
				isInstrumentType5 = ALOCConstants.TRUE_SMALL; }
			else if(id != null && id.intValue() == InstrumentType.RIDER.getId()) {
				isInstrumentType6 = ALOCConstants.TRUE_SMALL; }
		}}
	}
	
	/**
	 * This method is used to perform fee history advance search and retrieve the records from DB.
	 * @return
	 * @throws HWFServiceException
	 */
	public String advanceFHSearch() throws HWFServiceException {
		StringBuilder searchCriteria = new StringBuilder();
		APMDetailsHelper.populateFHsearchCriteria(apmSearch,searchCriteria);
		apmDetails = searchManager.executeFHSearch(apmSearch);
		apmDetails = APMDetailsHelper.assignDecimalValue(apmDetails);
		sessionValues.put(ALOCConstants.FEE_HISTORY_DETAILS, apmDetails);
		sessionValues.put(ALOCConstants.FEEHISTORY_SEARCH, searchCriteria.toString());
		return ALOCConstants.SUCCESS;
	}

	/**
	 * 
	 * @return
	 * @throws HWFServiceException
	 */
	@SuppressWarnings("unchecked")
	public String displayPendingAmendmentRider() throws HWFServiceException {
		GlanceDetails glanceDetails;
		searchCriteria = new Search();
		SearchInstrDetails searchInstrDetails = new SearchInstrDetails();
		List<BigInteger> instrTypeIds = Arrays.asList(instrumentTypes);
		searchInstrDetails.setInstrTypeIds(instrTypeIds);
		searchCriteria.setSearchInstrDetails(searchInstrDetails);
		searchCriteria.setStatus(ALOCConstants.BANK_ISSUE);
		results = searchManager.executeSearch(searchCriteria, dashboardViewType);
		glanceDetails=results.getGlanceDetails();
		if(glanceDetails==null){
			results.setGlanceDetails((GlanceDetails)sessionValues.get(ALOCConstants.GLANCE_DETAILS));
		}
		userSpecificSitesList=(List<UserSites>) sessionValues.get(ALOCConstants.USERSPECIFICSITES);  
		return ALOCConstants.SUCCESS;
	}
	/**
	 * This method is used to add Elements.
	 * @return
	 * @throws HWFServiceException
	 */
	public String addElements() throws HWFServiceException{
		return ALOCConstants.SUCCESS;
	}
	
	/**
	 * @return
	 * @throws HWFServiceException
	 */
	public String getAllIssuingBanks() throws HWFServiceException{
		issuingBanks = (IssuingBank)sessionValues.get(ALOCConstants.ISSUINGBANKNAMES);
		if(issuingBanks == null || issuingBanks.getBankNames() == null) {
			issuingBanks = searchManager.getAllIssuingBanks();
			sessionValues.put(ALOCConstants.ISSUINGBANKNAMES, issuingBanks);
		}
		return ALOCConstants.SUCCESS;
	}
	
	/**
	 * @return
	 * @throws HWFServiceException
	 */
	public String getAllSuretyNames() throws HWFServiceException{
		suretyMasterCollection = (SuretyMasterCollection)sessionValues.get(ALOCConstants.SURETYCOMPNAMES);
		if(suretyMasterCollection == null) {
			suretyMasterCollection = searchManager.getAllSuretyCompNames();
			sessionValues.put(ALOCConstants.SURETYCOMPNAMES, suretyMasterCollection);
		}
		return ALOCConstants.SUCCESS;
	}
	
	/* --------------------------------------------------------------
	 * 				End Dash Board Common actions					  *				
	 * -------------------------------------------------------------- */

	/**
	 * This method is used to get search result.
	 * @return the searchResult
	 */
	public Inbox getSearchResult() {
		return searchResult;
	}

	/**
	 * This method is used to set search result.
	 * @param searchResult the searchResult to set
	 */
	public void setSearchResult(Inbox searchResult) {
		this.searchResult = searchResult;
	}

	/**
	 * @return the results
	 */
	public Inbox getResults() {
		return results;
	}

	/**
	 * @param results the results to set
	 */
	public void setResults(Inbox results) {
		this.results = results;
	}

	/**
	 * This method is used to get search dashboardViewType.
	 * @return the dashboardViewType
	 */
	public DashboardViewType getDashboardViewType() {
		return dashboardViewType;
	}

	/**
	 * This method is used to set search dashboardViewType.
	 * @param dashboardViewType the dashboardViewType to set
	 */
	public void setDashboardViewType(DashboardViewType dashboardViewType) {
		this.dashboardViewType = dashboardViewType;
	}

	/**
	 * This method is used to get search siteId.
	 * @return the siteId
	 */
	public String getSiteId() {
		return siteId;
	}

	/**
	 * This method is used to set search siteId.
	 * @param siteId the siteId to set
	 */
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	/**
	 * This method is used to get searchCriteriaType.
	 * @return the searchCriteriaType
	 */
	public Integer getSearchCriteriaType() {
		return searchCriteriaType;
	}

	/**
	 * This method is used to set searchCriteriaType.
	 * @param searchCriteriaType the searchCriteriaType to set
	 */
	public void setSearchCriteriaType(Integer searchCriteriaType) {
		this.searchCriteriaType = searchCriteriaType;
	}

	/**
	 * This method is used to get search searchCriteriaText.
	 * @return the searchCriteriaText
	 */
	public String getSearchCriteriaText() {
		return searchCriteriaText;
	}

	/**
	 * This method is used to set searchCriteriaText.
	 * @param searchCriteriaText the searchCriteriaText to set
	 */
	public void setSearchCriteriaText(String searchCriteriaText) {
		this.searchCriteriaText = searchCriteriaText;
	}
	/**
	 * This method is used to get searchCriteria.
	 * @return the searchCriteria
	 */
	public Search getSearchCriteria() {
		return searchCriteria;
	}

	/**
	 * This method is used to set searchCriteria.
	 * @param searchCriteria the searchCriteria to set
	 */
	public void setSearchCriteria(Search searchCriteria) {
		this.searchCriteria = searchCriteria;
	}
	/**
	 * This method is used to get searchManager.
	 * @return the searchManager
	 */
	public ISearchManager getSearchManager() {
		return searchManager;
	}

	/**
	 *  This method is used to set searchManager.
	 * @param searchManager the searchManager to set
	 */
	public void setSearchManager(ISearchManager searchManager) {
		this.searchManager = searchManager;
	}
	/**
	 *  This method is used to get instrumentTypes.
	 * @return the instrumentTypes
	 */
	public BigInteger[] getInstrumentTypes() {
		return instrumentTypes;
	}

	/**
	 * This method is used to set instrumentTypes.
	 * @param instrumentTypes the instrumentTypes to set
	 */
	public void setInstrumentTypes(BigInteger[] instrumentTypes) {
		this.instrumentTypes = instrumentTypes;
	}
	/**
	 * This method is used to expandBundle.
	 * @return
	 */
	public String isExpandBundle() {
		return expandBundle;
	}
	/**
	 * This method is used set expandBundle value.
	 * @param expandBundle
	 */
	public void setExpandBundle(String expandBundle) {
		this.expandBundle = expandBundle;
	}

	/**
	 * This method is used to get the user specific list.
	 * @return the userSpecificSitesList
	 */
	public List<UserSites> getUserSpecificSitesList() {
		return userSpecificSitesList;
	}

	/**
	 * This method is used to set the user specific list.
	 * @param userSpecificSitesList the userSpecificSitesList to set
	 */
	public void setUserSpecificSitesList(List<UserSites> userSpecificSitesList) {
		this.userSpecificSitesList = userSpecificSitesList;
	}

	/**
	 * This method is used to get SessionValues.
	 * @return the sessionValues
	 */
	public Map<String, Object> getSessionValues() {
		return sessionValues;
	}

	/**
	 * This method is used to set the SessionValues.
	 * @param sessionValues the sessionValues to set
	 */
	public void setSessionValues(Map<String, Object> sessionValues) {
		this.sessionValues = sessionValues;
	}

	/**
	 * This method is used to get the request object instance
	 * @return the request
	 */
	public HttpServletRequest getRequest() {
		return request;
	}

	/**
	 * This method is used to set the request object instance
	 * @param request the request to set
	 */
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 *  This method is used to get the Child List.
	 * @return the childSitesList
	 */
	public List<SitesList> getChildSitesList() {
		return childSitesList;
	}
	/** This method is used to set the Child List
	 * @param childSitesList the childSitesList to set
	 */
	public void setChildSitesList(List<SitesList> childSitesList) {
		this.childSitesList = childSitesList;
	}

	/**
	 * This method is used to get ApmDetails
	 * @return the apmDetails
	 */
	public APMDetails getApmDetails() {
		return apmDetails;
	}

	/**
	 *  This method is used to set ApmDetails
	 * @param apmDetails the apmDetails to set
	 */
	public void setApmDetails(APMDetails apmDetails) {
		this.apmDetails = apmDetails;
	}

	/**
	 * This method is used to get apmSearch
	 * @return the apmSearch
	 */
	public APMSearch getApmSearch() {
		return apmSearch;
	}

	/**
	 * This method is used to set apmSearch
	 * @param apmSearch the apmSearch to set
	 */
	public void setApmSearch(APMSearch apmSearch) {
		this.apmSearch = apmSearch;
	}
	/**
	 * This method is used to set selSites
	 * @return the selSites
	 */
	public List<BigInteger> getSelSites() {
		return selSites;
	}

	/**
	 * This method is used to set selSites
	 * @param selSites the selSites to set
	 */
	public void setSelSites(List<BigInteger> selSites) {
		this.selSites = selSites;
	}

	/**
	 * This method is used to get search advanceSearchCriteriaText.
	 * @return the advanceSearchCriteriaText
	 */
	public String getAdvanceSearchCriteriaText() {
		return advanceSearchCriteriaText;
	}

	/**
	 * This method is used to set advanceSearchCriteriaText.
	 * @param advanceSearchCriteriaText the advanceSearchCriteriaText to set
	 */
	public void setAdvanceSearchCriteriaText(String advanceSearchCriteriaText) {
		this.advanceSearchCriteriaText = advanceSearchCriteriaText;
	}
	/**
	 * This method is used to get allInstrumentTypes
	 * @return the allInstrumentTypes
	 */
	public String getAllInstrumentTypes() {
		return allInstrumentTypes;
	}

	/**
	 * This method is used to set allInstrumentTypes
	 * @param allInstrumentTypes the allInstrumentTypes to set
	 */
	public void setAllInstrumentTypes(String allInstrumentTypes) {
		this.allInstrumentTypes = allInstrumentTypes;
	}

	/**
	 * This method is used to get isInstrumentType1
	 * @return the isInstrumentType1
	 */
	public String getIsInstrumentType1() {
		return isInstrumentType1;
	}

	/**
	 * This method is used to set isInstrumentType1
	 * @param isInstrumentType1 the isInstrumentType1 to set
	 */
	public void setIsInstrumentType1(String isInstrumentType1) {
		this.isInstrumentType1 = isInstrumentType1;
	}

	/**
	 * This method is used to get isInstrumentType2
	 * @return the isInstrumentType2
	 */
	public String getIsInstrumentType2() {
		return isInstrumentType2;
	}

	/**
	 * This method is used to set isInstrumentType2
	 * @param isInstrumentType2 the isInstrumentType2 to set
	 */
	public void setIsInstrumentType2(String isInstrumentType2) {
		this.isInstrumentType2 = isInstrumentType2;
	}

	/**
	 * This method is used to get isInstrumentType3
	 * @return the isInstrumentType3
	 */
	public String getIsInstrumentType3() {
		return isInstrumentType3;
	}

	/**
	 * This method is used to set isInstrumentType3
	 * @param isInstrumentType3 the isInstrumentType3 to set
	 */
	public void setIsInstrumentType3(String isInstrumentType3) {
		this.isInstrumentType3 = isInstrumentType3;
	}

	/**
	 * This method is used to get isInstrumentType4
	 * @return the isInstrumentType4
	 */
	public String getIsInstrumentType4() {
		return isInstrumentType4;
	}

	/**
	 * This method is used to set isInstrumentType4
	 * @param isInstrumentType4 the isInstrumentType4 to set
	 */
	public void setIsInstrumentType4(String isInstrumentType4) {
		this.isInstrumentType4 = isInstrumentType4;
	}

	/**
	 * This method is used to get isInstrumentType5
	 * @return the isInstrumentType5
	 */
	public String getIsInstrumentType5() {
		return isInstrumentType5;
	}

	/**
	 * This method is used to set isInstrumentType5
	 * @param isInstrumentType5 the isInstrumentType5 to set
	 */
	public void setIsInstrumentType5(String isInstrumentType5) {
		this.isInstrumentType5 = isInstrumentType5;
	}

	/**
	 * This method is used to get isInstrumentType6
	 * @return the isInstrumentType6
	 */
	public String getIsInstrumentType6() {
		return isInstrumentType6;
	}

	/**
	 * This method is used to set isInstrumentType6
	 * @param isInstrumentType6 the isInstrumentType6 to set
	 */
	public void setIsInstrumentType6(String isInstrumentType6) {
		this.isInstrumentType6 = isInstrumentType6;
	}

	/**
	 * This method is used to get istripartyApplicant
	 * @return the istripartyApplicant
	 */
	public String getIstripartyApplicant() {
		return istripartyApplicant;
	}

	/**
	 * This method is used to set istripartyApplicant
	 * @param istripartyApplicant the istripartyApplicant to set
	 */
	public void setIstripartyApplicant(String istripartyApplicant) {
		this.istripartyApplicant = istripartyApplicant;
	}

	/**
	 * This method is used to get isPrivateApplicant
	 * @return the isPrivateApplicant
	 */
	public String getIsPrivateApplicant() {
		return isPrivateApplicant;
	}

	/**
	 * This method is used to set isPrivateApplicant
	 * @param isPrivateApplicant the isPrivateApplicant to set
	 */
	public void setIsPrivateApplicant(String isPrivateApplicant) {
		this.isPrivateApplicant = isPrivateApplicant;
	}


	/**
	 * This method is used to get isFinancialCheck
	 * @return the isFinancialCheck
	 */
	public String getIsFinancialCheck() {
		return isFinancialCheck;
	}

	/**
	 * This method is used to set isFinancialCheck
	 * @param isFinancialCheck the isFinancialCheck to set
	 */
	public void setIsFinancialCheck(String isFinancialCheck) {
		this.isFinancialCheck = isFinancialCheck;
	}

	/**
	 * This method is used to get isIndustrialCheck
	 * @return the isIndustrialCheck
	 */
	public String getIsIndustrialCheck() {
		return isIndustrialCheck;
	}

	/**
	 * This method is used to set isIndustrialCheck
	 * @param isIndustrialCheck the isIndustrialCheck to set
	 */
	public void setIsIndustrialCheck(String isIndustrialCheck) {
		this.isIndustrialCheck = isIndustrialCheck;
	}

	/**
	 * This method is used to get financial
	 * @return the financial
	 */
	public String getFinancial() {
		return financial;
	}

	/**
	 * This method is used to set financial
	 * @param financial the financial to set
	 */
	public void setFinancial(String financial) {
		this.financial = financial;
	}

	/**
	 * This method is used to get industrial
	 * @return the industrial
	 */
	public String getIndustrial() {
		return industrial;
	}

	/**
	 * This method is used to set industrial
	 * @param industrial the industrial to set
	 */
	public void setIndustrial(String industrial) {
		this.industrial = industrial;
	}

	/**
	 * This method is used to get rightSelSites
	 * @return the rightSelSites
	 */
	public String getRightSelSites() {
		return rightSelSites;
	}

	/**
	 * This method is used to set rightSelSites
	 * @param rightSelSites the rightSelSites to set
	 */
	public void setRightSelSites(String rightSelSites) {
		this.rightSelSites = rightSelSites;
	}

	/**
	 * This method is used to get businessContactPersonName
	 * @return the businessContactPersonName
	 */
	public String getBusinessContactPersonName() {
		return businessContactPersonName;
	}

	/**
	 * This method is used to set businessContactPersonName
	 * @param businessContactPersonName the businessContactPersonName to set
	 */
	public void setBusinessContactPersonName(String businessContactPersonName) {
		this.businessContactPersonName = businessContactPersonName;
	}


	/**
	 * This method is used to get newSubBond
	 * @return the newSubBond
	 */
	public String getNewSubBond() {
		return newSubBond;
	}

	/**
	 * This method is used to set newSubBond
	 * @param selBondtype the newSubBond to set
	 */
	public void setNewSubBond(String newSubBond) {
		this.newSubBond = newSubBond;
	}

	/**
	 * This method is used to get newInstrumentPurpose
	 * @return the newInstrumentPurpose
	 */
	public String getNewInstrumentPurpose() {
		return newInstrumentPurpose;
	}

	/**
	 * This method is used to set newInstrumentPurpose
	 * @param newInstrumentPurpose the newInstrumentPurpose to set
	 */
	public void setNewInstrumentPurpose(String newInstrumentPurpose) {
		this.newInstrumentPurpose = newInstrumentPurpose;
	}

	/**
	 * This method is used to get newPole
	 * @return the newPole
	 */
	public String getNewPole() {
		return newPole;
	}

	/**
	 * This method is used to set newPole
	 * @param newPole the newPole to set
	 */
	public void setNewPole(String newPole) {
		this.newPole = newPole;
	}

	/**
	 * This method is used to get newInstrumentCurrency
	 * @return the newInstrumentCurrency
	 */
	public String getNewInstrumentCurrency() {
		return newInstrumentCurrency;
	}

	/**
	 * This method is used to set newInstrumentCurrency
	 * @param newInstrumentCurrency the newInstrumentCurrency to set
	 */
	public void setNewInstrumentCurrency(String newInstrumentCurrency) {
		this.newInstrumentCurrency = newInstrumentCurrency;
	}

	/**
	 * This method is used to get newIssuanceCountry
	 * @return the newIssuanceCountry
	 */
	public String getNewIssuanceCountry() {
		return newIssuanceCountry;
	}

	/**
	 * This method is used to set newIssuanceCountry
	 * @param newIssuanceCountry the newIssuanceCountry to set
	 */
	public void setNewIssuanceCountry(String newIssuanceCountry) {
		this.newIssuanceCountry = newIssuanceCountry;
	}
	
	/**
	 * This method is used to get bondSubBondList value
	 * @return the bondSubBondList
	 */
	public List<BondSubBond> getBondSubBondList() {
		return bondSubBondList;
	}

	/**
	 * This method is used to set bondSubBondList value
	 * @param bondSubBondList the bondSubBondList to set
	 */
	public void setBondSubBondList(List<BondSubBond> bondSubBondList) {
		this.bondSubBondList = bondSubBondList;
	}

	/**
	 * @return the issuingBanks
	 */
	public IssuingBank getIssuingBanks() {
		return issuingBanks;
	}

	/**
	 * @param issuingBanks the issuingBanks to set
	 */
	public void setIssuingBanks(IssuingBank issuingBanks) {
		this.issuingBanks = issuingBanks;
	}
	
	/**
	 * @return the suretyMasterCollection
	 */
	public SuretyMasterCollection getSuretyMasterCollection() {
		return suretyMasterCollection;
	}

	/**
	 * @param suretyMasterCollection the suretyMasterCollection to set
	 */
	public void setSuretyMasterCollection(
			SuretyMasterCollection suretyMasterCollection) {
		this.suretyMasterCollection = suretyMasterCollection;
	}
}
