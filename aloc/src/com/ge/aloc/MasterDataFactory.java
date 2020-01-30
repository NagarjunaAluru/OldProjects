/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: MasterDataFactory.java
 * Purpose:MasterDataFactory for handling all master data
 */
package com.ge.aloc;

import java.util.List;

import net.sf.ehcache.CacheManager;

import org.apache.log4j.Logger;

import com.ge.aloc.dao.ILookupDAO;
import com.ge.aloc.model.MDM;
import com.ge.aloc.model.MDM.Country;
import com.ge.aloc.model.MDM.Currency;
import com.hydus.hwf.cache.SelfPopulatingEHCacheSupport;
import com.hydus.hwf.exceptions.HWFServiceException;
/**
 * 
 * This class is used to handle all the dropdown data's  to be loaded 
 * and available in factory object
 * 
 * @author madhusudhan.gosula
 *
 */
public class MasterDataFactory extends SelfPopulatingEHCacheSupport<String, Object> {
	private static final Logger LOGGER = Logger.getLogger(MasterDataFactory.class);
	public static final String CTX_KEY = MasterDataFactory.class.getName();
	public static final String CACHE_NAME = MasterDataFactory.class.getName();
	private static final String CACHE_KEY_MDMDATA = "master_static_data_management";
	private static final String CACHE_KEY_MORRATES = "masterdata.morrates";
	private static final String CACHE_KEY_BLOOMBERGRATES = "masterdata.bloombergrates";

	private ILookupDAO lookupDAO;

	/**
	 * Constructor to create instance of this class
	 */
	public MasterDataFactory() {
		super(CACHE_NAME, CacheManager.getInstance());
	}

	/**
	 * This method initialises the cache with data.
	 */
	public Object createEntry(Object key) throws HWFServiceException{
		if(CACHE_KEY_MDMDATA.equals(key)) {
			if(LOGGER.isInfoEnabled()) {
				LOGGER.info("Refreshing master data on the cache");
			}
			MDM mdm = new MDM();
			mdm = lookupDAO.invokeMasterDataService();

			return mdm;
		} else if(CACHE_KEY_MORRATES.equals(key)) {
			return lookupDAO.getMORRates();
		} else if(CACHE_KEY_BLOOMBERGRATES.equals(key)) {
			return lookupDAO.getBloombergRates();
		}
		
		return null;
	}

	/**
	 * This method is used get Master data.
	 * @return
	 */
	protected MDM getMasterData(){
		return (MDM) get(CACHE_KEY_MDMDATA);
	}

	/**
	 * This method is used get lookup DAO.
	 * @return the lookupDAO
	 */
	public ILookupDAO getLookupDAO() {
		return lookupDAO;
	}

	/**
	 * This method is used set look up DAO.
	 * @param lookupDAO the lookupDAO to set
	 */
	public void setLookupDAO(ILookupDAO lookupDAO) {
		this.lookupDAO = lookupDAO;
	}
	/**
	 * This method returns Countries
	 * @return
	 */
	public List<Country> getCountries(){
		return getMasterData().getCountries();
	}
	/**
	 * This method returns Currencies
	 * @return
	 */
	public List<Currency> getCurrencies(){
		return getMasterData().getCurrencies();
	}
	
	/**
	 * This method returns MOR rates
	 * @return
	 */
	public String getMorRates() {
		return (String) get(CACHE_KEY_MORRATES);
	}
	
	/**
	 * This method returns Bloomberg rates
	 * @return 
	 */
	public String getBloombergRates() {
		return (String) get(CACHE_KEY_BLOOMBERGRATES);
	}
}