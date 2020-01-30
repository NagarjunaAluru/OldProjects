/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ILookupManager.java
 * Purpose: ILookupManager used for the all look up operations
 */
package com.ge.aloc.manager;

import java.util.List;

import com.ge.aloc.AddressType;
import com.ge.aloc.model.AddressDtls;
import com.ge.aloc.model.AlocUserDataResp;
import com.ge.aloc.model.MDM;
import com.ge.aloc.model.MDM.BankDetails;
import com.ge.aloc.model.MDM.Entity;
import com.ge.aloc.model.MDM.GoldIdCSOValidation;
import com.ge.aloc.model.RequestorLookupDetails;
import com.ge.aloc.model.UserDetails;
import com.hydus.hwf.exceptions.HWFServiceException;


/**
 * @author chaitanya.n
 *
 */
public interface ILookupManager {
	/**
	 * Method to get Legal Entity List from MDM for lookup.
	 * @param goldID
	 * @param pageNo
	 * @return 
	 * @throws HWFServiceException
	 */
	public List<Entity> getLegalEntity(String goldID, Integer pageNo) throws HWFServiceException;

	/**
	 * Method to get Name and Address List from MDM for lookup.
	 * @param addressType
	 * @param name
	 * @return
	 * @throws HWFServiceException
	 */
	public List<AddressDtls> getAddressDetails(AddressType addressType,String name) throws HWFServiceException;

	/**
	 * Method to get Business Contact Person List from MDM for lookup.
	 * @param bussContPer
	 * @return
	 * @throws HWFServiceException
	 */
	public AlocUserDataResp getBussContactPerson(String bucSSO, String bucFirstName, String bucLastName) throws HWFServiceException;

	/**
	 * Method to get GE Reference List from MDM for lookup.
	 * @param geRecipient
	 * @return
	 * @throws HWFServiceException
	 */
	public AlocUserDataResp getGERecipientDetails(String geRecipient, String bucFirstName, String bucLastName) throws HWFServiceException;

	/**
	 * Method to get Bank Details List from MDM for lookup.
	 * @param bankName
	 * @return
	 * @throws HWFServiceException
	 */
	public List<BankDetails> getBankDetails(String bankName, String bankCountryCd, String bankCountry, String bankCity, Integer pageNo) throws HWFServiceException;

	/**
	 * Method to get Bank Details List from MDM for lookup Search.
	 * @param bankCountry
	 * @param bankCity
	 * @param bankAddress
	 * @param bankBIC
	 * @return
	 * @throws HWFServiceException
	 */
	public List<BankDetails> getBankSearchResults(String bankName,String bankCountryCd, String bankCountry, String bankCity, String bankAddress, String bankBIC, Integer pageNo) throws HWFServiceException;
	/**
	 * Method to validate BUC and ADN Values.
	 * @param bucCode
	 * @param adnCode
	 * @return
	 * @throws HWFServiceException
	 */
	public MDM getIBSDetails(String bucCode, String adnCode) throws HWFServiceException;

	/**
	 * Method to validate CSO Value w.r.t Legal Entity Value.
	 * @param csoValue
	 * @param leGoldIdValue
	 * @return
	 * @throws HWFServiceException
	 */
	public GoldIdCSOValidation getCSOLEValidation(String csoValue, String leGoldIdValue) throws HWFServiceException;
	
	/**
	 * Method to get requester Details List for selected search criteria.
	 * @param requestorName
	 * @return
	 * @throws HWFServiceException
	 */
	public List<RequestorLookupDetails> getRequestorDetails(String requestorName) throws HWFServiceException;
	
	/**
	 * Method to get Business Contact Person List from MDM for lookup.
	 * @param bussContPer
	 * @return
	 * @throws HWFServiceException
	 */
	public List<UserDetails> getUserDetails(String bussContPer) throws HWFServiceException;
}
