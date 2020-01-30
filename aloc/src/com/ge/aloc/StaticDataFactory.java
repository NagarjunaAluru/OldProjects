/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: StaticDataFactory.java
 * Purpose: StaticDataFactory used to retrieve the Static data.
 */
package com.ge.aloc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.ehcache.CacheManager;

import org.apache.log4j.Logger;

import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.dao.ILookupDAO;
import com.ge.aloc.manager.IReferenceDataManager;
import com.ge.aloc.model.AddressDtls;
import com.ge.aloc.model.AvailableSites;
import com.ge.aloc.model.MDM.BankDetails;
import com.ge.aloc.model.MDM;
import com.ge.aloc.model.MDM.Currency;
import com.ge.aloc.model.NameValue;
import com.ge.aloc.model.SiteAdminStaticData;
import com.ge.aloc.model.StaticDataManagement;
import com.ge.aloc.model.StaticDataManagement.FormatSelection;
import com.ge.aloc.model.StaticDataManagement.ParentSites;
import com.ge.aloc.model.StaticDataManagement.StateList.StateInfo;
import com.ge.aloc.model.StaticDataManagement.UserSites;
import com.hydus.hwf.cache.SelfPopulatingEHCacheSupport;
import com.hydus.hwf.exceptions.HWFServiceException;
import com.opensymphony.xwork2.ActionContext;
/**
 * @author madhusudhan.gosula
 *
 */
public class StaticDataFactory extends SelfPopulatingEHCacheSupport<String, Object>{

	private static final Logger LOGGER = Logger.getLogger(StaticDataFactory.class);
	public static final String CTX_KEY = StaticDataFactory.class.getName();
	public static final String CACHE_NAME = StaticDataFactory.class.getName();
	private static final String CACHE_KEY_STATICDATA_MNGT = "static_data_management";
	private static final String CACHE_KEY_USER_SITES = "static_data_management_usersites";
	private static final String CACHE_KEY_INSTRUMENT_TYPE_MAP = "static_data_management_instrument_type_map";
	private static final String CACHE_SITES_LIST = "siteLst";
	private static final String CACHE_KEY_REPORT_ADDR_DTLS = "static_data_management_address_details";
	/**
	 * 
	 */
	private ILookupDAO lookupDAO;
	private IReferenceDataManager referenceDataManager;

	/**
	 * Constructor to create instance of this class
	 */
	public StaticDataFactory() {
		super(CACHE_NAME, CacheManager.getInstance());
	}

	/**
	 * This is used to get lookupDAO instance object.
	 * @return the lookupDAO
	 */
	public ILookupDAO getLookupDAO() {
		return lookupDAO;
	}

	/**
	 * This is used to set the lookup dao instance object
	 * @param lookupDAO the lookupDAO to set
	 */
	public void setLookupDAO(ILookupDAO lookupDAO) {
		this.lookupDAO = lookupDAO;
	}

	/**
	 * Returns the StaticDataManagement object form the cache.
	 * 
	 * @return
	 */
	protected StaticDataManagement getStaticDataManagement() {
		return (StaticDataManagement) get(CACHE_KEY_STATICDATA_MNGT);
	}

	/**
	 * This method initialises the cache with data.
	 */
	public Object createEntry(Object key) throws HWFServiceException{
		if(CACHE_KEY_STATICDATA_MNGT.equals(key)) {
			if(LOGGER.isInfoEnabled()) {
				LOGGER.info(ALOCConstants.STATICDATAREFRESHONCACHE);
			}
			StaticDataManagement staticDataObject = new StaticDataManagement();
			staticDataObject = lookupDAO.invokeStaticDataService();
			return staticDataObject;
		}
		return null;
	}

	/**
	 * This method returns Bond Type
	 * @return 
	 */
	public List<NameValue> getBondTypes(){
		return getStaticDataManagement().getBondTypes();
	}


	/**
	 * This method returns Bond Type
	 * @return 
	 */
	public List<NameValue> getAdminBondTypes(){
		List<NameValue> bondTypeList = new ArrayList<NameValue>();
		List<NameValue> bondTypes = getStaticDataManagement().getBondTypes();
		for(NameValue nameValue : bondTypes) {
			if(nameValue.getID().intValue()==ALOCConstants.BIDBOND_ID  || nameValue.getID().intValue()==ALOCConstants.CONTRACTBOND_ID){
				bondTypeList.add(nameValue);
			}
		}
		return bondTypeList;
	}

	/**
	 * This method returns Bond Sub Type
	 * @return
	 */
	public List<NameValue> getBondSubTypes(){
		return getStaticDataManagement().getBondSubTypes();
	}
	/**
	 * This method returns Instrument Purpose
	 * @return
	 */
	public List<NameValue> getInstrumentPurpose(){
		return getStaticDataManagement().getInstrumentPurposes();
	}



	/**
	 * This method returns Request statuses
	 * @return
	 */
	public List<NameValue> getRequestStatuses(){
		return getStaticDataManagement().getRequestStatuses();
	}
	/**
	 * This method is used to get instrument purpose list from the static data factor
	 *  with out finanical instrument purpose.
	 * @return
	 */
	public List<NameValue> getInstrumentPurposeList() {
		List<NameValue> instrumentList = new ArrayList<NameValue>();
		List<NameValue> oriInstrumentList = getStaticDataManagement().getInstrumentPurposes();
		for(NameValue nameValue : oriInstrumentList) {
			if(!nameValue.getName().equals(ALOCConstants.FINANCIAL)){
				instrumentList.add(nameValue);
			}
		}
		return instrumentList;
	}


	/**
	 * This method is for getting instrument purpose List for treasury admin standard format screen  
	 * 
	 * @return
	 */
	public List<NameValue> getStandardInstrumentPurposeList() {
		List<NameValue> instrumentList = new ArrayList<NameValue>();
		List<NameValue> oriInstrumentList = getStaticDataManagement().getInstrumentPurposes();
		for(NameValue nameValue : oriInstrumentList) {
			if(!nameValue.getName().equals(ALOCConstants.OTHER_SMALL)){
				instrumentList.add(nameValue);
			}
		}
		return instrumentList;
	}



	/**
	 * This method returns Instrument Type
	 * @return
	 */
	public List<NameValue> getInstrumentType(){
		return getStaticDataManagement().getInstrumentTypes();
	}

	/**
	 * This method returns Instrument Type for the Site delegation
	 * @return
	 */
	public List<NameValue> getInstrumentTypeDeleg(){
		List<NameValue> instrDelegLst = getStaticDataManagement().getInstrumentTypes();
		List<NameValue> newInstrDelegLst = new ArrayList<NameValue>();
		for(NameValue nameValue : instrDelegLst) {			
			if(nameValue.getID().intValue() != InstrumentType.DOCUMENT_LOC.getId()){
				newInstrDelegLst.add(nameValue);
			}
		}
		return newInstrDelegLst;
	}

	/**
	 * This method is added for the Treasury Admin Portal Standard Format Management
	 * This list contains only four values 1,2,3,and 4.
	 * @return
	 */
	public List<NameValue> getInstrumentTypeList() {
		List<NameValue> instrumentTypeList = new ArrayList<NameValue>();
		List<NameValue> oriInstrumentTypeList = getStaticDataManagement().getInstrumentTypes();
		for(NameValue nameValue : oriInstrumentTypeList) {			
			if((nameValue.getID().intValue()==InstrumentType.BANK_GUARANTEE.getId() || nameValue.getID().intValue()==InstrumentType.LOC.getId()
					|| nameValue.getID().intValue()==InstrumentType.SURETY_BOND.getId() || nameValue.getID().intValue()==InstrumentType.DOCUMENT_LOC.getId())){
				instrumentTypeList.add(nameValue);
			}
		}
		return instrumentTypeList;
	}

	/**
	 * This method is added for the Treasury Admin Portal Standard Format Management
	 * This list contains only four values 1,2,3,and 4.
	 * @return
	 */
	public List<NameValue> getInstrumentTypeBundle() {
		List<NameValue> instrumentTypeList = new ArrayList<NameValue>();
		List<NameValue> oriInstrumentTypeList = getStaticDataManagement().getInstrumentTypes();
		for(NameValue nameValue : oriInstrumentTypeList) {			
			if((nameValue.getID().intValue()==InstrumentType.BANK_GUARANTEE.getId() || nameValue.getID().intValue()==InstrumentType.LOC.getId()
					|| nameValue.getID().intValue()==InstrumentType.DOCUMENT_LOC.getId() || nameValue.getID().intValue()==InstrumentType.AMENDMENT.getId())){
				instrumentTypeList.add(nameValue);
			}
		}
		return instrumentTypeList;
	}
	
	/**
	 * This method is added for the Treasury Admin Portal Standard Format Management
	 * This list contains only four values 1,2 and 3
	 * @return
	 */
	public List<NameValue> getInstrumentTypeModel() {
		List<NameValue> instrumentTypeList = new ArrayList<NameValue>();
		List<NameValue> oriInstrumentTypeList = getStaticDataManagement().getInstrumentTypes();
		for(NameValue nameValue : oriInstrumentTypeList) {			
			if(nameValue.getID().intValue()==InstrumentType.BANK_GUARANTEE.getId() || nameValue.getID().intValue()==InstrumentType.LOC.getId() || nameValue.getID().intValue()==InstrumentType.SURETY_BOND.getId()){
				instrumentTypeList.add(nameValue);
			}
		}
		return instrumentTypeList;
	}
	
	/**
	 * This method is added for the Broker Dashboard Advance search
	 * This list contains only two values 2 and 6
	 * @return
	 */
	public List<NameValue> getBrokerInstrumentTypes() {
		List<NameValue> instrumentTypeList = new ArrayList<NameValue>();
		List<NameValue> oriInstrumentTypeList = getStaticDataManagement().getInstrumentTypes();
		for(NameValue nameValue : oriInstrumentTypeList) {			
			if(nameValue.getID().intValue()==InstrumentType.SURETY_BOND.getId() || nameValue.getID().intValue()==InstrumentType.RIDER.getId()){
				instrumentTypeList.add(nameValue);
			}
		}
		return instrumentTypeList;
	}
	
	/**
	 * This method is used to get Instrument Type Map.
	 * @return
	 */
	public Map<Integer, String> getInstrumentTypeMap() {
		@SuppressWarnings("unchecked")
		Map<Integer, String> instTypeMap = (Map<Integer, String>) get(CACHE_KEY_INSTRUMENT_TYPE_MAP);
		if(instTypeMap == null) {
			for(NameValue instType : getInstrumentType()) {
				instTypeMap = new HashMap<Integer, String>();
				instTypeMap.put(instType.getID().intValue(), instType.getName());
				put(CACHE_KEY_INSTRUMENT_TYPE_MAP, instTypeMap);
			}
		}
		return instTypeMap;
	}
	/**
	 * Method to get all the Parent Sites
	 * @return
	 * @throws HWFServiceException
	 */
	public List<SiteAdminStaticData.SitesList> getAllSites() throws HWFServiceException{
		@SuppressWarnings("unchecked")
		List<SiteAdminStaticData.SitesList> sitesLst = (List<SiteAdminStaticData.SitesList>) get(CACHE_SITES_LIST);
		if(sitesLst == null) {
			sitesLst = referenceDataManager.getAllSiteNames();
			put(CACHE_SITES_LIST, sitesLst);
		}

		return sitesLst;
	}

	/**
	 * remove SitesList
	 */
	public void removeSitesLst(){
		remove(CACHE_SITES_LIST);
	}

	/**
	 * This method returns Format Selection
	 * @return
	 */
	public List<FormatSelection> getFormatSelection(){
		return getStaticDataManagement().getFormatSelections();
	}

	/**
	 * This method returns LC Payment Terms
	 * @return
	 */
	public List<NameValue> getLCPaymentTerms(){
		return getStaticDataManagement().getLCPaymentTerms();
	}
	/**
	 * This method returns Site Types
	 * @return
	 */
	public List<NameValue> getSiteTypes(){
		return getStaticDataManagement().getSiteTypes();
	}
	/**
	 * This method returns Address of GE
	 * @return
	 */
	public List<AddressDtls> getAddressDetails(){
		return getStaticDataManagement().getAddressDetails();
	}
	/**
	 * This method returns Bank Swift MessageTypes
	 * @return
	 */
	public List<NameValue> getSwiftMessageTypes(){
		return getStaticDataManagement().getSwiftMessageTypes();
	}
	/**
	 * This method returns Parent Sites
	 * @return
	 */
	public List<ParentSites> getParentSites(){
		return getStaticDataManagement().getParentSites();
	}
	/**
	 * This method returns Bank Charges
	 * @return
	 */
	public List<NameValue> getBankCharges(){
		return getStaticDataManagement().getBankCharges();
	}
	/**
	 * This method returns Poles Details
	 * @return
	 */
	public List<NameValue> getPolesDetails(){
		return getStaticDataManagement().getPolesDetails();
	}

	/**
	 * This method returns Sites related to the User
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<NameValue> getUserSites(){
		List<NameValue> result = (List<NameValue>) get(CACHE_KEY_USER_SITES);
		if(result == null) {
			result = new ArrayList<NameValue>();
			for (UserSites userSites : getStaticDataManagement().getUserSites()) {
				NameValue userSite = new NameValue();
				userSite.setID(userSites.getID());
				userSite.setName(userSites.getName());
				result.add(userSite);
			}
			put(CACHE_KEY_USER_SITES, result);
		}
		return result;
	}
	/**
	 * This is used to get the State list from the static data.
	 * @return
	 */
	public List<StateInfo> getStateList(){
		return getStaticDataManagement().getStateList().getStateInfos();
	}
	/**
	 * This is used to get the GE Divisions list from the static data.
	 * @return
	 */
	public List<NameValue> getGeDivisionsList(){
		return getStaticDataManagement().getGEDivisionsList().getGEDivisionNames();
	}
	/**
	 * This is used to get the File extns list from the static data.
	 * @return
	 */
	public List<NameValue> getFileExtnsList(){
		return getStaticDataManagement().getFileExtnsList().getFileExtnTypes();
	}

	/**
	 * This is used to get thelink search list from the static data.
	 * @return
	 */
	public List<NameValue> getLinkSearchList(){
		return getStaticDataManagement().getSearchCriteria().getDashBoardLinkToSearches();
	}
	/**
	 * This is used to get the pricing details list from the static data.
	 * @return
	 */
	public List<NameValue> getPricingDetails(){
		return getStaticDataManagement().getPricingDetails();
	}

	/**
	 * Method to get the Governing Rules Static Data
	 * @return
	 */
	public List<NameValue> getGoverningRules(){
		return getStaticDataManagement().getGoverningRules();
	}

	/**
	 * Method to get the fee structures Static Data
	 * @return
	 */
	public List<NameValue> getFeeStructures(){
		return getStaticDataManagement().getFeeStructures();
	}

	/**
	 * This used to create reference Data manager instance.
	 * @return the referenceDataManager
	 */
	public IReferenceDataManager getReferenceDataManager() {
		return referenceDataManager;
	}

	/**
	 * This is used to create referenceDataManager instance.
	 * @param referenceDataManager the referenceDataManager to set
	 */
	public void setReferenceDataManager(IReferenceDataManager referenceDataManager) {
		this.referenceDataManager = referenceDataManager;
	}

	/**
	 * This method returns List of user specific Type
	 * @return 
	 */
	@SuppressWarnings("unchecked")
	public List<UserSites> getUserSpecificSitesList(){
		Map<String, Object> sessionValues = ActionContext.getContext().getSession();
		return (List<UserSites>) sessionValues.get(ALOCConstants.USERSPECIFICSITES);
	}
	
	/**
	 * This method returns List of Available Sites List
	 * @return 
	 */
	@SuppressWarnings("unchecked")
	public List<AvailableSites> getAvailableSitesList(){
		Map<String, Object> sessionValues = ActionContext.getContext().getSession();
		return (List<AvailableSites>) sessionValues.get(ALOCConstants.AVAILABLESITES);
	}
	
	/**
	 * This method returns List of Available Banks List
	 * @return 
	 */
	@SuppressWarnings("unchecked")
	public List<BankDetails> getAvailableBanksList(){
		Map<String, Object> sessionValues = ActionContext.getContext().getSession();
		return (List<BankDetails>) sessionValues.get(ALOCConstants.ALLBANKLIST);
	}
	
	
	/**
	 * This is used to get the Bid Statuses details list from the static data.
	 * @return
	 */
	public List<NameValue> getBidStatusesList(){
		return getStaticDataManagement().getBidStatuses();
	}

	/**
	 * 
	 * @return
	 * @throws HWFServiceException 
	 */
	@SuppressWarnings("unchecked")
	public List<AddressDtls> getReportAddressDetails() throws HWFServiceException {
		List<AddressDtls> result = (List<AddressDtls>) get(CACHE_KEY_REPORT_ADDR_DTLS);
		if(result == null) {
			result = lookupDAO.getReportsAddressDtls();
			put(CACHE_KEY_REPORT_ADDR_DTLS, result);
		}
		return result;
	}
	
	/**
	 * Method to get the Currencies for Report
	 * @return
	 * @throws HWFServiceException
	 */
	@SuppressWarnings("unchecked")
	public List<MDM.Currency> getReportCurrency() throws HWFServiceException{
		Map<String, Object> sessionValues = ActionContext.getContext().getSession();
		return (List<Currency>) sessionValues.get(ALOCConstants.REPORTCURRENCY);
	}
}
