/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: LookupManager.java
 * Purpose: LookupManager used for the all look up operations
 */
package com.ge.aloc.manager.impl;

import java.util.ArrayList;
import java.util.List;

import com.ge.aloc.AddressType;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.dao.ILookupDAO;
import com.ge.aloc.manager.ILookupManager;
import com.ge.aloc.model.AddressDtls;
import com.ge.aloc.model.AlocUserDataResp;
import com.ge.aloc.model.MDM;
import com.ge.aloc.model.MDM.BankDetails;
import com.ge.aloc.model.MDM.Entity;
import com.ge.aloc.model.MDM.GoldIdCSOValidation;
import com.ge.aloc.model.RequestorLookupDetails;
import com.ge.aloc.model.RequestorSearchRequest;
import com.ge.aloc.model.UserDetails;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author chaitanya.n
 *
 */
public class LookupManager implements ILookupManager {
	private ILookupDAO lookupDAO;
	/**
	 * @see com.ge.aloc.manager.ILookupManager#getLegalEntity(String, Integer)
	 */
	public List<Entity> getLegalEntity(String goldID, Integer pageNo) throws HWFServiceException {
		return lookupDAO.invokeLegalEntity(goldID,pageNo);
	}
	/**
	 * @see com.ge.aloc.manager.ILookupManager#getAddressDetails(AddressType, String)
	 */
	public List<AddressDtls> getAddressDetails(AddressType addressType,String name) throws HWFServiceException {
		if(addressType == AddressType.CUSTOMER){
			addressType = AddressType.BENEFICIARY;
		}
		return lookupDAO.invokeNameAddress(addressType, name);
	}
	/**
	 * @see com.ge.aloc.manager.ILookupManager#getBussContactPerson(String)
	 */
	public AlocUserDataResp getBussContactPerson(String bucSSO, String bucFirstName, String bucLastName) throws HWFServiceException{
		return lookupDAO.invokeBusinessContactPerson(bucSSO, bucFirstName, bucLastName);
	}
	/**
	 * @see com.ge.aloc.manager.ILookupManager#getGERecipientDetails(String)
	 */
	public AlocUserDataResp getGERecipientDetails(String geRecipient, String bucFirstName, String bucLastName) throws HWFServiceException {
		return lookupDAO.invokeBusinessContactPerson(geRecipient, bucFirstName, bucLastName);
	}
	/**
	 * @see com.ge.aloc.manager.ILookupManager#getbankDetails(String)
	 */
	public List<BankDetails> getBankDetails(String bankName, String bankCountryCd, String bankCountry, String bankCity, Integer pageNo) throws HWFServiceException {
		return lookupDAO.invokeBankDetails(bankName,bankCountryCd,bankCountry,bankCity,pageNo);
	}
	/**
	 * @see com.ge.aloc.manager.ILookupManager#getBankSearchResults(String, String, String, String)
	 */
	public List<BankDetails> getBankSearchResults(String bankName,String bankCountryCd, String bankCountry,
			String bankCity, String bankAddress, String bankBIC, Integer pageNo)
					throws HWFServiceException {
		BankDetails bankDetails = new BankDetails();
		bankDetails.setBankName(bankName);
		bankDetails.setBICCode(bankBIC);
		AddressDtls addressDetails = new AddressDtls();
		addressDetails.setCity(bankCity);
		addressDetails.setCountryCd(bankCountryCd);
		addressDetails.setCountry(bankCountry);
		List<String> address = new ArrayList<String>();
		address.add(bankAddress);
		addressDetails.setAddress(address);
		bankDetails.setBankAddress(addressDetails);
		return lookupDAO.invokeBankSearchResults(bankDetails,pageNo);
	}

	/**
	 * @see com.ge.aloc.manager.ILookupManager#getIBSDetails(String, String)
	 */
	public MDM getIBSDetails(String bucCode, String adnCode) throws HWFServiceException {
		return lookupDAO.invokeIBSDetails(bucCode, adnCode);
	}
	/**
	 * @see com.ge.aloc.manager.ILookupManager#getCSOLEValidation(String, String)
	 */
	public GoldIdCSOValidation getCSOLEValidation(String csoValue, String leGoldIdValue) throws HWFServiceException {
		return lookupDAO.invokeCSOLEValidation(csoValue, leGoldIdValue);
	}
	/**
	 * @see com.ge.aloc.manager.ILookupManager#getRequestorDetails(java.lang.String)
	 */
	public List<RequestorLookupDetails> getRequestorDetails(String requestorName)
			throws HWFServiceException {
		RequestorSearchRequest requestorSearchRequest = lookupDAO.invokeRequestorDetails(requestorName);
		return requestorSearchRequest.getRequestorLookUps().get(ALOCConstants.BASE_VALUE).getRequestorLookupDetails();
	}
	
	/**
	 * @see com.ge.aloc.manager.ILookupManager#getBussContactPerson(String)
	 */
	public List<UserDetails> getUserDetails(String bussContPer) throws HWFServiceException{
		return lookupDAO.getUserDetails(bussContPer);
	}
	
	/* -------------------------------------------------------------------------------------------------------------------------------------------
	 * 														INJECTOR METHODS
	 -------------------------------------------------------------------------------------------------------------------------------------------- */
	/**
	 * Method to create lookupDAO instance object.
	 * @return
	 */
	public ILookupDAO getLookupDAO() {
		return lookupDAO;
	}
	/**
	 * Method to create lookupDAO instance object.
	 * @param lookupDAO
	 */
	public void setLookupDAO(ILookupDAO lookupDAO) {
		this.lookupDAO = lookupDAO;
	}
}
