/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: StaticDataFactory.java
 * Purpose: StaticDataFactory used to retrieve the Static data.
 */
package com.ge.icfp.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.ehcache.CacheManager;

import org.apache.log4j.Logger;

import com.ge.icfp.model.MsgHeader;
import com.ge.icfp.model.NameValue;
import com.ge.icfp.model.StaticDataManagement;
import com.ge.icfp.model.StaticDataManagement.ReferenceData;
import com.ge.icfp.model.StaticDataManagement.TransactionEventTypes;
import com.hydus.wff.common.bw.ServiceClient;
import com.hydus.wff.core.cache.SelfPopulatingEHCacheSupport;
import com.hydus.wff.core.exception.HWFServiceException;
import com.hydus.wff.core.exception.HWFStubException;
import static com.ge.icfp.common.constants.ICFPConstants.*;
/**
 * @author srinivasan.desa
 *
 */
public class StaticDataFactory extends SelfPopulatingEHCacheSupport<String, StaticDataManagement>{
	
	private static final Logger LOGGER = Logger.getLogger(StaticDataFactory.class);
	public static final String CTX_KEY = "com.ge.icfp.StaticData";
	public static final String CACHE_NAME = StaticDataFactory.class.getName();
	private static final String CACHE_KEY_STATICDATA_MNGT = "static_data_management";
	
	private ServiceClient serviceClient;
	
	/**
	 * Constructor to create instance of this class
	 */
	public StaticDataFactory() {
		super(CACHE_NAME, CacheManager.getInstance());
	}
	
	/**
	 * This method initializes the cache with data.
	 */
	public Object createEntry(Object key) throws HWFServiceException, HWFStubException {
		if(CACHE_KEY_STATICDATA_MNGT.equals(key)) {
			if(LOGGER.isInfoEnabled()) {
				LOGGER.info("Refreshing static data on the cache");
			}
			MsgHeader msgHeader = new MsgHeader();
			msgHeader = new MsgHeader();
			msgHeader.setOpcode(STATICDATA);

			StaticDataManagement staticDataObject = new StaticDataManagement();
			staticDataObject.setMsgHeader(msgHeader);
			staticDataObject = serviceClient.invokeService(STATICDATA, staticDataObject,StaticDataManagement.class);
			return staticDataObject;
		}
		return null;
	}
	
	/**
	 * getProductTypes
	 * @return
	 */
	public List<NameValue> getProductTypes() {
		StaticDataManagement statData = get(CACHE_KEY_STATICDATA_MNGT);
		List<NameValue> productTypeNameValue = statData.getProductTypes();
		List<NameValue> productTypeNameValue1 = new ArrayList<NameValue>();
		for(NameValue namevalue:productTypeNameValue){
			NameValue nameValue1 = new NameValue();
			if(namevalue.getID()!=3){
				nameValue1.setID(namevalue.getID());
				nameValue1.setName(namevalue.getName());
				productTypeNameValue1.add(nameValue1);
			}
		}
		return productTypeNameValue1;
	}
	/**
	 * getAllProductTypes
	 * @return
	 */
	public List<NameValue> getAllProductTypes() {
		StaticDataManagement statData = get(CACHE_KEY_STATICDATA_MNGT);
		return statData.getProductTypes();
	}
	/**
	 * searchApprover
	 * @return
	 */
	public List<String> searchApprover() {
		StaticDataManagement statData = get(CACHE_KEY_STATICDATA_MNGT);
		List<NameValue> productTypeNameValue = statData.getSearchCriterias();
		List<String> productTypeLst = new ArrayList<String>();
		for(NameValue nameValue:productTypeNameValue){
			productTypeLst.add(nameValue.getName());
		}
		return productTypeLst;
	}
	/**
	 * getSearchCriteria
	 * @return
	 */
	public List<NameValue> getSearchCriteria() {
		StaticDataManagement statData = get(CACHE_KEY_STATICDATA_MNGT);
		return statData.getSearchCriterias();
	}
	/**
	 * transactionCapturedIn
	 * @return
	 */
	public List<String> transactionCapturedIn() throws HWFServiceException, HWFStubException{
		StaticDataManagement statData = get(CACHE_KEY_STATICDATA_MNGT);
		List<NameValue> productTypeNameValue = statData.getTransactionCapturedIns();
		List<String> productTypeLst = new ArrayList<String>();
		for(NameValue nameValue:productTypeNameValue){
			productTypeLst.add(nameValue.getName());
		}
		return productTypeLst;
	}
	/**
	 * getTransactionCapturedIn
	 * @return
	 */
	public List<NameValue> getTransactionCapturedIn() throws HWFServiceException, HWFStubException{
		StaticDataManagement statData = get(CACHE_KEY_STATICDATA_MNGT);
		return statData.getTransactionCapturedIns();
	}
	/**
	 * getDealCategories
	 * @return
	 */
	public List<NameValue> getDealCategories() {
		StaticDataManagement statData = get(CACHE_KEY_STATICDATA_MNGT);
		return statData.getDealCategories();
	}
	/**
	 * getDerivativeTypes
	 * @return
	 */
	public List<NameValue> getDerivativeTypes() {
		StaticDataManagement statData = get(CACHE_KEY_STATICDATA_MNGT);
		return statData.getDerivativeTypes();
	}
	/**
	 * getHedgeDesignation
	 * @return
	 */
	public List<NameValue> getHedgeDesignation() {
		StaticDataManagement statData = get(CACHE_KEY_STATICDATA_MNGT);
		return statData.getHedgeDesignations();
	}	
	/**
	 * getContractClass
	 * @return
	 */
	public List<NameValue> getContractClass() {
		StaticDataManagement statData = get(CACHE_KEY_STATICDATA_MNGT);
		return statData.getContractClass();
	}	
	/**
	 * getTaxDesignation
	 * @return
	 */
	public List<NameValue> getTaxDesignation() {
		StaticDataManagement statData = get(CACHE_KEY_STATICDATA_MNGT);
		return statData.getTaxDesignations();
	}	
	/**
	 * getInterestResetFreqs
	 * @return
	 */
	public List<NameValue> getInterestResetFreqs() {
		StaticDataManagement statData = get(CACHE_KEY_STATICDATA_MNGT);
		return statData.getInterestResetFreqs();
	}
	/**
	 * getHedgePrograms
	 * @return
	 */
	public List<NameValue> getHedgePrograms() {
		StaticDataManagement statData = get(CACHE_KEY_STATICDATA_MNGT);
		return statData.getHedgePrograms();
	}
	/**
	 * getDayCounts
	 * @return
	 */
	public List<NameValue> getDayCounts() {
		StaticDataManagement statData = get(CACHE_KEY_STATICDATA_MNGT);
		return statData.getDayCounts();
	}
	/**
	 * getModelScores
	 * @return
	 */
	public List<NameValue> getModelScores() {
		StaticDataManagement statData = get(CACHE_KEY_STATICDATA_MNGT);
		return statData.getModelScores();
	}
	/**
	 * getSNPRatings
	 * @return
	 */
	public List<NameValue> getSNPRatings() {
		StaticDataManagement statData = get(CACHE_KEY_STATICDATA_MNGT);
		return statData.getSNPRatings();
	}
	/**
	 * getRanges
	 * @return
	 */
	public List<NameValue> getRanges() {
		StaticDataManagement statData = get(CACHE_KEY_STATICDATA_MNGT);
		return statData.getRanges();
	}
	/**
	 * getFinalRating
	 * @return
	 */
	public List<NameValue> getFinalRating() {
		StaticDataManagement statData = get(CACHE_KEY_STATICDATA_MNGT);
		return statData.getFinalRatings();
	}
	/**
	 * getFundHoldOthers
	 * @return
	 */
	public List<NameValue> getFundHoldOthers() {
		StaticDataManagement statData = get(CACHE_KEY_STATICDATA_MNGT);
		return statData.getFundHoldOthers();
	}
	/**
	 * getFormOfEquity
	 * @return
	 */
	public List<NameValue> getFormOfEquity() {
		StaticDataManagement statData = get(CACHE_KEY_STATICDATA_MNGT);
		return statData.getEquityForms();
	}
	/**
	 * getShareTypes
	 * @return
	 */
	public List<NameValue> getShareTypes() {
		StaticDataManagement statData = get(CACHE_KEY_STATICDATA_MNGT);
		return statData.getShareTypes();
	}
	
	/**
	 * getTermsAndConditions
	 * @return
	 */
	public List<NameValue> getTermsAndConditions() {
		StaticDataManagement statData = get(CACHE_KEY_STATICDATA_MNGT);
		return statData.getTermsAndConditions();
	}
	
	/**
	 * getGeneralAmendmentTypes
	 * @return
	 */
	public List<NameValue> getGeneralAmendmentTypes() {
		StaticDataManagement statData = get(CACHE_KEY_STATICDATA_MNGT);
		return statData.getGeneralAmendmentTypes();
       
    }
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Map<Integer, String> getTermsAndConditionsMap() {
		Map<Integer, String> termsAndConditionsMap = new HashMap<Integer, String>();
		StaticDataManagement statData = get(CACHE_KEY_STATICDATA_MNGT);
		List<NameValue> termsAndConditions = statData.getTermsAndConditions();
		for(NameValue eachTermsAndConditions : termsAndConditions) {
			termsAndConditionsMap.put(eachTermsAndConditions.getID(), eachTermsAndConditions.getName());
		}
		return termsAndConditionsMap;
	}
	
	/**
	 * This function will get the solvency matrix details from static data factory
	 * @return
	 */
	public List<StaticDataManagement.SolvencyMetricsCalc> getSolvencyMatrixValues() throws HWFServiceException, HWFStubException{
		StaticDataManagement statData = get(CACHE_KEY_STATICDATA_MNGT);
		return statData.getSolvencyMetricsCalcs();
	}
	
	/**
	 * 
	 * @return
	 */
	public List<StaticDataManagement.ContactICF> getContactUsValues() throws HWFServiceException, HWFStubException{
		StaticDataManagement statData = get(CACHE_KEY_STATICDATA_MNGT);
		return statData.getContactICves();
	}
	/**
	 * getCertificateList
	 * @return
	 */
	public List<NameValue> getCertificateList() throws HWFServiceException, HWFStubException{
		StaticDataManagement statData = get(CACHE_KEY_STATICDATA_MNGT);
		return statData.getCertLists();
	}
	/**
	 * 
	 * @return
	 */
	public List<NameValue> getFundingCompany() throws HWFServiceException, HWFStubException{
		StaticDataManagement statData = get(CACHE_KEY_STATICDATA_MNGT);
		return statData.getFCHCOCS();
	}
	/**
	 * 
	 * @return
	 */
	public List<TransactionEventTypes> getEventType() throws HWFServiceException, HWFStubException{
		StaticDataManagement statData = get(CACHE_KEY_STATICDATA_MNGT);
		return statData.getTransactionEventTypes();
	}
	
	/**
	 * getModelTypes
	 * @return
	 */
	public List<NameValue> getModelTypes() {
		StaticDataManagement statData = get(CACHE_KEY_STATICDATA_MNGT);
		return statData.getModelTypes();
	}
	
	
	
	/**
	 * 
	 * @return
	 * @throws HWFServiceException
	 * @throws HWFStubException
	 */
	public List<StaticDataManagement.WFStageDetails> getWorkFlowStageDetails() throws HWFServiceException, HWFStubException{
		StaticDataManagement statData = get(CACHE_KEY_STATICDATA_MNGT);
		return statData.getWFStageDetails();
	}
	
	/**
	 * getDealCategories
	 * @return
	 */
	public List<NameValue> getRegionResponsibility() {
		StaticDataManagement statData = get(CACHE_KEY_STATICDATA_MNGT);
		return statData.getRegionResponsibilities();
	}
	
	/**
	 * get EboardApprovalAmount
	 * @return
	 */
	public String  getReferenceData() {
		StaticDataManagement statData = get(CACHE_KEY_STATICDATA_MNGT);
		List<ReferenceData> referenceData =  statData.getReferenceDatas();
		
		for(ReferenceData eachData : referenceData) {
			if(eachData.getReferenceDataName().equalsIgnoreCase(EBOARDAPPROVALAMOUNT)){
				return eachData.getReferenceDataValue();
			}
		}
		return "";
	}
	
	/**
	 * get PrefferedFileTypes
	 * @return
	 */
	public  List<String>  getReferenceFileExtData() {
		 List<String> fileExt = new ArrayList<String>();
		StaticDataManagement statData = get(CACHE_KEY_STATICDATA_MNGT);
		List<ReferenceData> referenceData = statData.getReferenceDatas();
		for(ReferenceData eachData : referenceData) {
			if(eachData.getReferenceDataName().equalsIgnoreCase(PREFFEREDFILETYPE)){
				fileExt.add(eachData.getReferenceDataValue());
			}
		}
		return fileExt;
	}
	


	/**
	 * @return the serviceClient
	 */
	public ServiceClient getServiceClient() {
		return serviceClient;
	}

	/**
	 * @param serviceClient the serviceClient to set
	 */
	public void setServiceClient(ServiceClient serviceClient) {
		this.serviceClient = serviceClient;
	}
}
