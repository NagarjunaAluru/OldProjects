/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ILookupDAO.java
 * Purpose: ILookupDAO used for the all the lookup DAO declarations
 */
package com.ge.aloc.dao;

import java.util.List;

import com.ge.aloc.AddressType;
import com.ge.aloc.IServiceClientAware;
import com.ge.aloc.model.AddressDtls;
import com.ge.aloc.model.MDM;
import com.ge.aloc.model.MDM.BankDetails;
import com.ge.aloc.model.MDM.Entity;
import com.ge.aloc.model.MDM.GoldIdCSOValidation;
import com.ge.aloc.model.AlocUserDataResp;
import com.ge.aloc.model.RequestorSearchRequest;
import com.ge.aloc.model.StaticDataManagement;
import com.ge.aloc.model.UserDetails;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author chaitanya.n
 *
 */
public interface ILookupDAO extends IServiceClientAware {
	/**
	 * This method is used to invoke Static Data Service
	 * @return
	 * @throws HWFServiceException
	 */
	public StaticDataManagement invokeStaticDataService() throws HWFServiceException;
	/**
	 * This method is used to invoke Master Data Service
	 * @param msgHeader
	 * @return
	 * @throws HWFServiceException
	 */
	public MDM invokeMasterDataService() throws HWFServiceException;
	/**
	 * This method is used to invoke Legal Entity From MDM
	 * @param goldID
	 * @return
	 * @throws HWFServiceException
	 */
	public List<Entity> invokeLegalEntity(String goldID, Integer pageNo) throws HWFServiceException;
	/**
	 * This method is used to invoke Name Address From Static Data Management
	 * @param addressType
	 * @param name
	 * @return
	 * @throws HWFServiceException
	 */
	public List<AddressDtls> invokeNameAddress(AddressType addressType,String name)throws HWFServiceException;

	/**
	 * This method is used to invoke Business Contact Person From Static Data Management
	 * @param bussContPer
	 * @return
	 * @throws HWFServiceException
	 */
	public AlocUserDataResp invokeBusinessContactPerson(String bucSSO, String bucFirstName, String bucLastName) throws HWFServiceException;

	/**
	 * This method is used to invoke GE Recipient Details From MDM
	 * @param bussContPer
	 * @return
	 * @throws HWFServiceException
	 */
	public List<UserDetails> invokeGERecipientDetails(String geRecipient) throws HWFServiceException;

	/**
	 * This method is used to invoke Bank Details From MDM
	 * @param bankName
	 * @return
	 * @throws HWFServiceException
	 */
	public List<BankDetails> invokeBankDetails(String bankName, String bankCountryCd, String bankCountry, String bankCity, Integer pageNo) throws HWFServiceException;

	/**
	 * This method is used to invoke Bank Search Result From MDM
	 * @param bankDetails
	 * @return
	 * @throws HWFServiceException
	 */
	public List<BankDetails> invokeBankSearchResults(BankDetails bankDetails, Integer pageNo) throws HWFServiceException;

	/**
	 * This method is used to invoke IBS Details From MDM
	 * @param bucCode
	 * @param adnCode
	 * @return
	 * @throws HWFServiceException
	 */
	public MDM invokeIBSDetails(String bucCode, String adnCode) throws HWFServiceException;

	/**
	 * This method is used to invoke CSO LE Validation From MDM
	 * @param csoValue
	 * @param leGoldIdValue
	 * @return
	 * @throws HWFServiceException
	 */
	public GoldIdCSOValidation invokeCSOLEValidation(String csoValue, String leGoldIdValue) throws HWFServiceException; 
	
	/**
	 * Method to get requester Details List for selected search criteria.
	 * @param requestorName
	 * @return
	 * @throws HWFServiceException
	 */
	public RequestorSearchRequest invokeRequestorDetails(String requestorName) throws  HWFServiceException;
	
	/**
	 * This method is used to get mor rates
	 * @return
	 * @throws HWFServiceException
	 */
	public String getMORRates() throws HWFServiceException;
	
	/**
	 * This method is used to get bloomberg rates
	 * @return
	 * @throws HWFServiceException
	 */
	public String getBloombergRates() throws HWFServiceException;
	
	/**
	 * Method to get Address Details for all reports for selected search criteria.
	 * @return
	 * @throws HWFServiceException
	 */
	public List<AddressDtls> getReportsAddressDtls()throws HWFServiceException;
	
	/**
	 * This method is used to invoke Business Contact Person From Static Data Management
	 * @param bussContPer
	 * @return
	 * @throws HWFServiceException
	 */
	public List<UserDetails> getUserDetails(String bussContPer) throws HWFServiceException;
}
