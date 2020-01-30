/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: MasterDataFactory.java
 * Purpose:MasterDataFactory for handling all master data
 */
package com.ge.icfp.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.ehcache.CacheManager;

import org.apache.log4j.Logger;

import com.ge.icfp.common.vo.NameValueVO;
import com.ge.icfp.model.DealCurrency;
import com.ge.icfp.model.FloatInformation;
import com.ge.icfp.model.MDM;
import com.ge.icfp.model.MDM.CashPool;
import com.ge.icfp.model.MDM.Country;
import com.ge.icfp.model.MDM.Region;
import com.ge.icfp.model.MgmtEntity;
import com.ge.icfp.model.MsgHeader;
import com.ge.icfp.model.NameValue;
import com.google.gson.Gson;
import com.hydus.wff.common.bw.ServiceClient;
import com.hydus.wff.core.cache.SelfPopulatingEHCacheSupport;
import com.hydus.wff.core.exception.HWFServiceException;
import com.hydus.wff.core.exception.HWFStubException;
import static com.ge.icfp.common.constants.ICFPConstants.*;
/**
 * 
 * This class is used to handle all the dropdown data's  to be loaded 
 * and available in factory object
 * 
 * @author srinivasan.desa
 *
 */
public class MasterDataFactory extends SelfPopulatingEHCacheSupport<String, MDM> {
	private static final Logger LOGGER = Logger.getLogger(MasterDataFactory.class);
	public static final String CTX_KEY = "com.ge.icfp.MasterData";
	public static final String CACHE_NAME = MasterDataFactory.class.getName();
	private static final String CACHE_KEY_MDMDATA = "master_data_management";
	private static final String CACHE_KEY_FLOATING_MDMDATA = "floating_master_data_management";
	private static final String CACHE_KEY_CASHPOOLBANK_MDMDATA = "cashpoolbank_master_data_management";
	
	private ServiceClient serviceClient;
	
	/**
	 * Constructor to create instance of this class
	 */
	public MasterDataFactory() {
		super(CACHE_NAME, CacheManager.getInstance());
	}
	
	/**
	 * This method initializes the cache with data.
	 */
	public Object createEntry(Object key) throws HWFServiceException, HWFStubException {
		if(CACHE_KEY_MDMDATA.equals(key)) {
			if(LOGGER.isInfoEnabled()) {
				LOGGER.info("Refreshing master data on the cache");
			}
			MsgHeader msgHeader = new MsgHeader();
			msgHeader = new MsgHeader();
			msgHeader.setOpcode("LEGDATA");

			MDM mdmObject = new MDM();
			mdmObject.setMsgHeader(msgHeader);
			mdmObject = serviceClient.invokeService(MDM, mdmObject,MDM.class);
			return mdmObject;
		}
		
		if(CACHE_KEY_FLOATING_MDMDATA.equals(key)) {
			if(LOGGER.isInfoEnabled()) {
				LOGGER.info("Refreshing floating master data on the cache");
			}
			MsgHeader msgHeader = new MsgHeader();
			msgHeader = new MsgHeader();
			msgHeader.setOpcode("RATEINFO");

			MDM floatingMasterDataObject = new MDM();
			floatingMasterDataObject.setMsgHeader(msgHeader);
			floatingMasterDataObject = serviceClient.invokeService(MDM, floatingMasterDataObject,MDM.class);
			return floatingMasterDataObject;
		}
		
		if(CACHE_KEY_CASHPOOLBANK_MDMDATA.equals(key)) {
			if(LOGGER.isInfoEnabled()) {
				LOGGER.info("Refreshing floating master data on the cache");
			}
			List<Region> regions = new ArrayList<Region>();
			List<Country> countries = new ArrayList<Country>();
			List<DealCurrency> dealCurrencies = new ArrayList<DealCurrency>();
			MDM cashpoolMasterDataObject = new MDM();
			MsgHeader msgHeader = new MsgHeader();
			msgHeader.setOpcode(CASHPOOL);
			cashpoolMasterDataObject.setMsgHeader(msgHeader);
			cashpoolMasterDataObject.setRegions(regions);
			cashpoolMasterDataObject.setCountries(countries);
			cashpoolMasterDataObject.setDealCurrencies(dealCurrencies);
			cashpoolMasterDataObject = serviceClient.invokeService(MDM,cashpoolMasterDataObject,MDM.class);
			return cashpoolMasterDataObject;
		}
		return null;
	}
	
	/**
	 * getDealCurrencies is used to retrieve deal currencies list from mdm.
	 * @return list
	 */
	public List<NameValueVO> getDealCurrencies() {
		MDM mdmObject = get(CACHE_KEY_MDMDATA);
		List<DealCurrency> dealCurrencyNameValue = mdmObject.getDealCurrencies();
		List<NameValueVO> dealCurrencyLst = new ArrayList<NameValueVO>();
		for(DealCurrency dealCurrency:dealCurrencyNameValue){
			NameValueVO nameValue = new NameValueVO();
			nameValue.setId(dealCurrency.getCurrencyCode());
			nameValue.setName(dealCurrency.getCurrencyName());
			dealCurrencyLst.add(nameValue);
		}
		return dealCurrencyLst;
	}
	
	/**
	 * Returns the Currency Map
	 * 
	 * @return
	 */
	public Map<String, String> getDealCurrenciesMap() {
		Map<String, String> currencyMap = new HashMap<String, String>();
		MDM mdmObject = get(CACHE_KEY_MDMDATA);
		List<DealCurrency> dealCurrencyNameValue = mdmObject.getDealCurrencies();
		for(DealCurrency dealCurrency:dealCurrencyNameValue){
			currencyMap.put(dealCurrency.getCurrencyCode(), dealCurrency.getCurrencyName());
		}
		return currencyMap;
	}
	
	/**
	 * getAllCurrencies is used to retrieve all currencies list from mdm.
	 * @return String
	 */
	public String getAllCurrencies() throws HWFServiceException, HWFStubException{
		
		MDM mdmObject = get(CACHE_KEY_MDMDATA);
		List<DealCurrency> dealCurrencyNameValue = mdmObject.getDealCurrencies();
		
		List<String> list = new ArrayList<String>();
		for(DealCurrency cur : dealCurrencyNameValue){
			list.add(cur.getCurrencyCode() + "-" + cur.getCurrencyName() );
		}
		
		return new Gson().toJson( list ).toString();
	}
	/**
	 * getFloatingIndex
	 * @return list
	 */
	public List<NameValue> getFloatingIndex() {
		MDM floatingMasterData = get(CACHE_KEY_FLOATING_MDMDATA);
		List<FloatInformation> floatInformationList = floatingMasterData.getFloatInformations();
		
		// Fix for empty float information
		if(floatInformationList == null || floatInformationList.isEmpty()) {
			remove(CACHE_KEY_FLOATING_MDMDATA);
			floatingMasterData = get(CACHE_KEY_FLOATING_MDMDATA);
			floatInformationList = floatingMasterData.getFloatInformations();
		}
		
		List<NameValue> floatInformationLst = new ArrayList<NameValue>();
		
		String previousRateIndex="";
		String currentRateIndex="";
		
		for(FloatInformation floatInformation:floatInformationList){
		
			if(floatInformation.getFloatingRateIndex()!=null){
				
				currentRateIndex = floatInformation.getFloatingRateIndex();
				
				if(previousRateIndex==null || previousRateIndex.equals(""))
				{
					NameValue nameValue = new NameValue();
					nameValue.setName(floatInformation.getFloatingRateIndex());
					previousRateIndex = currentRateIndex;
					floatInformationLst.add(nameValue);
				}else{
					if(previousRateIndex!=null && currentRateIndex!=null &&
							!currentRateIndex.equals(previousRateIndex))
					{
						NameValue nameValue = new NameValue();
						nameValue.setName(floatInformation.getFloatingRateIndex());
						previousRateIndex = currentRateIndex;
						floatInformationLst.add(nameValue);
					}
				}
			}
		}
		return floatInformationLst;
	}	
	
	/**
	 * Returns Index term values for given floating rate index.
	 * Need to be modified with out service call
	 * @return
	 */
	public Map<String, String> getIndexTerm(String floatingRateIndex,ServiceClient serviceClient) {
		MDM floatingMasterData = get(CACHE_KEY_FLOATING_MDMDATA);
		List<FloatInformation> floatInformationList = floatingMasterData.getFloatInformations();
		Map<String,String> indexTermMap = new HashMap<String, String>();
		String currentRateIndex="";
		
		for(FloatInformation floatInformation:floatInformationList){
			if(floatInformation.getFloatingRateIndex()!=null){
				currentRateIndex = floatInformation.getFloatingRateIndex();
				if(floatingRateIndex!=null && currentRateIndex!=null
						&& currentRateIndex.equals(floatingRateIndex))
				{
					indexTermMap.put(floatInformation.getFloatingRateIndexTerm(), floatInformation.getFloatingRateIndexTerm());
				}
			
			}
		}
		return indexTermMap;
	}
	/**
	 * getBankList
	 * @param floatingRateIndex
	 * @param serviceClient
	 * @return
	 */
	public Map<String, String> getBankInformations() {
		MDM cashpoolBankMasterData = get(CACHE_KEY_CASHPOOLBANK_MDMDATA);
		List<CashPool> resultCP = cashpoolBankMasterData.getCashPools();
		Map<String, String> bankInfo = new HashMap<String, String>();
		for (CashPool cashPool : resultCP) {
			bankInfo.put(cashPool.getBankName(), cashPool.getBankName());
		}
		return bankInfo;
	}
	/**
	 * getMgmtEntities
	 * @return list
	 */
	public List<NameValue> getMgmtEntities() {
		MDM mdmObject = get(CACHE_KEY_MDMDATA);
		List<MgmtEntity> mgmtEntityNameValue = mdmObject.getMgmtEntities();
		List<NameValue> mgmtEntityLst = new ArrayList<NameValue>();
		for(MgmtEntity mgmtEntity:mgmtEntityNameValue){
			NameValue nameValue = new NameValue();
			nameValue.setID(mgmtEntity.getID());
			nameValue.setName(mgmtEntity.getName());
			mgmtEntityLst.add(nameValue);
		}
		return mgmtEntityLst;
	}	
	
	/**
	 * getCountries
	 * @return list
	 */
	public List<NameValueVO> getCountries() {
		MDM mdmObject = get(CACHE_KEY_MDMDATA);
		List<Country> countryLst = mdmObject.getCountries();
		List<NameValueVO> countryNamevalueLst = new ArrayList<NameValueVO>();
		for(Country country:countryLst){
			NameValueVO nameValue = new NameValueVO();
			nameValue.setId(country.getCountryCode());
			nameValue.setName(country.getCountryName());
			countryNamevalueLst.add(nameValue);
		}
		return countryNamevalueLst;
	}
	/**
	 * getRegions
	 * @return list
	 */
	public List<NameValueVO> getRegions() {
		MDM mdmObject = get(CACHE_KEY_MDMDATA);
		List<Region> regionLst = mdmObject.getRegions();
		List<NameValueVO> regionNamevalueLst = new ArrayList<NameValueVO>();
		for(Region region:regionLst){
			NameValueVO nameValue = new NameValueVO();
			nameValue.setId(region.getRegionID());
			nameValue.setName(region.getRegionName());
			regionNamevalueLst.add(nameValue);
		}
		return regionNamevalueLst;
	}
	
	/**
	 * Returns the Service Client
	 * @return
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