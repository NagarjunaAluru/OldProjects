/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: LookupAction.java
 * Purpose: LookupAction used for the all look up operations
 */
package com.ge.aloc.action.lookup;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.ge.aloc.ALOCContext;
import com.ge.aloc.AddressType;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.manager.ILookupManager;
import com.ge.aloc.model.AddressDtls;
import com.ge.aloc.model.AlocUserDataResp;
import com.ge.aloc.model.AlocUserInfo;
import com.ge.aloc.model.IBSDetails;
import com.ge.aloc.model.MDM;
import com.ge.aloc.model.RequestorLookupDetails;
import com.ge.aloc.model.MDM.BankDetails;
import com.ge.aloc.model.MDM.Country;
import com.ge.aloc.model.MDM.Entity;
import com.ge.aloc.model.MDM.GoldIdCSOValidation;
import com.ge.aloc.model.UserDetails;
import com.ge.aloc.util.ALOCCommonHelper;
import com.ge.aloc.util.JSONHelper;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.hydus.hwf.exceptions.HWFServiceException;
import com.hydus.hwf.util.StringUtils;
/**
 * 
 * @author arijit.biswas
 *
 */
public class LookupAction {
	private ILookupManager lookupManager;
	private String goldId;
	private int pageNumber = ALOCConstants.MIN_VALUE;
	private int addressTypeId;
	private int addressIndex;
	private String addressTypeName;
	private String nameForAddress;
	private String personName;
	private String geRecipient;
	private String bankName;
	private String bankCountryCd;
	private String bankCountry;
	private String bankCity;
	private String bankAddress;
	private String bankBIC;
	private List<Entity> legalEntities;
	private List<AddressDtls> addressDetailsList;
	private List<AlocUserInfo> businessContactList;
	private List<AlocUserInfo> geRecipientDetailList;
	private List<BankDetails> bankDetailsList;
	private List<IBSDetails> ibsDetailsList;
	private GoldIdCSOValidation goldIdCSOValidation;
	private String lookUpNo;
	private int recordCount;
	private int previousPageStart;
	private int nextPageStart;
	private boolean readOnlyFlag = false;
	private String bankDetailCountryCd;
	private String bankDetailCountry;
	private List<RequestorLookupDetails> requestorLookupDetailsList;
	private String requestorName;
	private String requestorType;
	private String newRequestorName;
	private HttpServletRequest request = ServletActionContext.getRequest();
	private String bucFirstName;
	private String bucLastName;
	private List<UserDetails> userDetailsList;
	private String dlocAddressType;

	/**
	 * Method to get Legal Entity List from MDM for lookup.
	 * @return
	 * @throws HWFServiceException
	 */
	public String getLegalEntity() throws HWFServiceException{
		goldId = request.getParameter(ALOCConstants.FILTER_VALUE);
		legalEntities = lookupManager.getLegalEntity(goldId, pageNumber);
		if(pageNumber > ALOCConstants.PAGE_INCREMENT){
			previousPageStart = pageNumber-ALOCConstants.PAGE_INCREMENT;
		}else{
			previousPageStart = ALOCConstants.PREVIOUS_PAGE_START_INDEX;
		}
		if(legalEntities.size() > ALOCConstants.LEGALENTITIES_BASE_SIZE){
			recordCount = legalEntities.size();
			nextPageStart = pageNumber + ALOCConstants.PAGE_INCREMENT;
		}
		return ALOCConstants.LEGALENTITYLOOKUPPAGE;
	}

	/**
	 * Method to get Name and Address List from MDM for lookup.
	 * @return
	 * @throws HWFServiceException
	 */
	public String getNameAddress() throws HWFServiceException{
		AddressType addressType = AddressType.fromId(addressTypeId);
		nameForAddress = request.getParameter(ALOCConstants.FILTER_VALUE);
		if(StringUtils.isNotBlank(dlocAddressType) && dlocAddressType.equals("applicant")){
			addressType = AddressType.fromId(7);
		}else if(StringUtils.isNotBlank(dlocAddressType) && dlocAddressType.equals("beneficiary")){
			addressType = AddressType.fromId(1);
		}
		addressDetailsList = lookupManager.getAddressDetails(addressType, nameForAddress);
		if(StringUtils.isNotBlank(dlocAddressType) && dlocAddressType.equals("applicant")){
			addressType = AddressType.fromId(1);
		}else if(StringUtils.isNotBlank(dlocAddressType) && dlocAddressType.equals("beneficiary")){
			addressType = AddressType.fromId(7);
		}
		addressTypeName = addressType.getName();
		return ALOCConstants.NAMEADDRESSLOOKUPPAGE;
	}

	/**
	 * Method to get Business Contact Person List from MDM for lookup.
	 * @return
	 * @throws HWFServiceException
	 * @throws IOException 
	 */
	public String getBusinessContactPerson() throws HWFServiceException, IOException{
		HttpServletResponse response = ServletActionContext.getResponse();
		personName = request.getParameter(ALOCConstants.FILTER_VALUE);
		requestorType = request.getParameter(ALOCConstants.REQUESTOR_TYPE);
		String lookUpNumber =  request.getParameter(ALOCConstants.LOOKUPNUM);	
		setLookUpNo(lookUpNumber);
		AlocUserDataResp alocUserDataResp = lookupManager.getBussContactPerson(personName,bucFirstName,bucLastName);
		if(StringUtils.isNotBlank(alocUserDataResp.getStatus()) && !alocUserDataResp.getStatus().equals(ALOCConstants.STATUS_SUCCESS)) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			response.getWriter().write(alocUserDataResp.getStatus());
			return null;
		}
		else
			businessContactList = alocUserDataResp.getAlocUserInfos();
		return ALOCConstants.BUSINESSCONTACTPERSONLOOKUPPAGE;
	}
    
	/**
	 * Method to get Business Contact Person List from MDM for lookup.
	 * @return
	 * @throws HWFServiceException
	 * @throws IOException 
	 */
	public String getUserDetails() throws HWFServiceException, IOException{
		personName = request.getParameter(ALOCConstants.FILTER_VALUE);
		userDetailsList = lookupManager.getUserDetails(personName);
		return ALOCConstants.USERDETAILSLOOKUPPAGE;
	}
	/**
	 * Method to get GE Reference List from MDM for lookup.
	 * @return
	 * @throws HWFServiceException
	 * @throws IOException 
	 */
	public String getGEReference() throws HWFServiceException, IOException{
		HttpServletResponse response = ServletActionContext.getResponse();
		geRecipient = request.getParameter(ALOCConstants.FILTER_VALUE);
		AlocUserDataResp alocUserDataResp = lookupManager.getGERecipientDetails(geRecipient,bucFirstName,bucLastName);
		if(StringUtils.isNotBlank(alocUserDataResp.getStatus()) && !alocUserDataResp.getStatus().equals(ALOCConstants.STATUS_SUCCESS)) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			response.getWriter().write(alocUserDataResp.getStatus());
			return null;
		}
		else
			geRecipientDetailList = alocUserDataResp.getAlocUserInfos();
		return ALOCConstants.GEREFERENCELOOKUPPAGE;
	}

	/**
	 * Method to get Bank Details List from MDM for lookup.
	 * @return
	 * @throws HWFServiceException
	 */
	public String getBankDetails() throws HWFServiceException{
		bankName = request.getParameter(ALOCConstants.FILTER_VALUE);
		bankCountry = (StringUtils.isNotBlank(bankCountryCd) && StringUtils.isBlank(bankCountry)) ? getCountryName(bankCountryCd) : bankCountry;
		if(StringUtils.isNotBlank(bankName) && StringUtils.isNotBlank(bankCountry) && StringUtils.isNotBlank(bankCity)){
			bankDetailsList = lookupManager.getBankDetails(bankName, bankCountryCd,bankCountry,bankCity,pageNumber);
		}
		bankDetailCountryCd = bankCountryCd;
		bankDetailCountry = bankCountry;
		if(pageNumber > ALOCConstants.PAGE_INCREMENT){
			previousPageStart = pageNumber-ALOCConstants.PAGE_INCREMENT;
		}else{
			previousPageStart = ALOCConstants.PREVIOUS_PAGE_START_INDEX;
		}
		if(bankDetailsList != null && bankDetailsList.size() > ALOCConstants.BANKDETAILS_LIST_SIZE){
			recordCount = bankDetailsList.size();
			nextPageStart = pageNumber + ALOCConstants.PAGE_INCREMENT;
		}
		return ALOCConstants.BANKDETAILSLOOKUPPAGE;
	}

	/**
	 * Method to get Bank Search Result List from MDM for lookup.
	 * @return
	 * @throws HWFServiceException
	 */
	public String getBankAdvanceSearch() throws HWFServiceException{
		bankDetailsList = lookupManager.getBankSearchResults(bankName,bankDetailCountryCd, bankDetailCountry, bankCity, bankAddress, bankBIC, pageNumber);
		if(pageNumber > ALOCConstants.PAGE_INCREMENT){
			previousPageStart = pageNumber-ALOCConstants.PAGE_INCREMENT;
		}else{
			previousPageStart = ALOCConstants.PREVIOUS_PAGE_START_INDEX;
		}
		if(bankDetailsList.size() > ALOCConstants.BANKDETAILS_LIST_SIZE){
			recordCount = bankDetailsList.size();
			nextPageStart = pageNumber + ALOCConstants.PAGE_INCREMENT;
		}
		return ALOCConstants.BANKDETAILSLOOKUPPAGE;
	}
	/**
	 * Method to validate BUC and ADN Values.
	 * @return
	 * @throws HWFServiceException
	 * @throws IOException
	 */
	public String getBUCADN() throws HWFServiceException, IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		String bucValue =  request.getParameter(ALOCConstants.BUCVALUE);
		String adnValue = request.getParameter(ALOCConstants.ADNVALUE);
		HttpServletResponse response = ServletActionContext.getResponse();
		MDM mdmObj =  lookupManager.getIBSDetails(bucValue, adnValue);
		JsonObject result = new JsonObject();
		JsonArray jsonArray = new JsonArray();
		
		int ibsIndexZero = ALOCConstants.IBS_BASE_INDEX;
		if(mdmObj.getIBSDetails().get(ibsIndexZero).getIBSMessageDetails().get(ibsIndexZero).getIBSMessage() != null){
			jsonArray = ALOCCommonHelper.prepareBUCADNJsonObject(mdmObj.getIBSDetails().get(ibsIndexZero).getIBSMessageDetails().get(ibsIndexZero), jsonArray);
		}
		if(mdmObj.getBusinessUnitCode() != null){
			jsonArray = ALOCCommonHelper.prepareBlockedBUCJsonObject(mdmObj.getBusinessUnitCode(), jsonArray);
		}

		result.add(ALOCConstants.RESULT, jsonArray);
		JSONHelper.writeResponse(result, response);
		return null;
	}

	/**
	 * Method to validate CSO Value w.r.t Legal Entity Value.
	 * @return
	 * @throws HWFServiceException
	 * @throws IOException
	 */
	public String getCSOLEValidation() throws HWFServiceException, IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		String csoValue =  request.getParameter(ALOCConstants.CSOVALUE);
		String leGoldIdValue = request.getParameter(ALOCConstants.LEGOLDIDVALUE);
		HttpServletResponse response = ServletActionContext.getResponse();
		goldIdCSOValidation = lookupManager.getCSOLEValidation(csoValue, leGoldIdValue);
		JsonObject result = new JsonObject();
		JsonArray jsonArray = new JsonArray();
		JsonObject obj = new JsonObject();
		obj.addProperty(ALOCConstants.ISCSOLEVALID, goldIdCSOValidation.getValidationDetails().isIsValidCombo());
		obj.addProperty(ALOCConstants.RESULTMESSAGE, goldIdCSOValidation.getValidationDetails().getValidationResult());
		jsonArray.add(obj);
		result.add(ALOCConstants.RESULT, jsonArray);
		JSONHelper.writeResponse(result, response);
		return null;
	}
	
	/**
	 * Method to get requester Details List for selected search criteria.
	 * @return
	 * @throws HWFServiceException
	 */
	public String getRequestorDetails() throws HWFServiceException{
		requestorName = request.getParameter(ALOCConstants.FILTER_VALUE);
		requestorType = request.getParameter(ALOCConstants.REQUESTOR_TYPE);
		requestorLookupDetailsList = lookupManager.getRequestorDetails(requestorName);
		return ALOCConstants.REQUESTORLOOKUPPAGE;
	}
	
	/**
	 * This method is used to get the Country Code based on the CountryName
	 * @param countryName
	 * @return countryCode
	 */
	public String getCountryName(String countryCode) {
		String countryName = ALOCConstants.EMPTY_STRING;
		List<Country> MDMCountries = ALOCContext.getMasterDataFactory().getCountries();
		if(MDMCountries !=null && !MDMCountries.isEmpty() && StringUtils.isNotBlank(countryCode)){
			for(Country mdmCountriesLst : MDMCountries){
				if(StringUtils.isNotBlank(mdmCountriesLst.getCountryCode()) && mdmCountriesLst.getCountryCode().equalsIgnoreCase(countryCode)){
					return mdmCountriesLst.getCountryName();
				}
			}
		}
		return countryName;
	}

	/* -------------------------------------------------------------------------------------------------------------------------------- 
	 * 											PROPERTY SETTER/GETTER METHODS
	 --------------------------------------------------------------------------------------------------------------------------------- */

	/**
	 * Method to get Legal Entity List
	 * @return the legalEntities
	 */
	public List<Entity> getLegalEntities() {
		return legalEntities;
	}

	/**
	 * Method to get Address Details List
	 * @return the addressDetailsList
	 */
	public List<AddressDtls> getAddressDetailsList() {
		return addressDetailsList;
	}

	/**
	 * Method to get Business Contact Person List
	 * @return the businessContactList
	 */
	public List<AlocUserInfo> getBusinessContactList() {
		return businessContactList;
	}

	/**
	 * Method to get GE Recipient Detail List
	 * @return the geRecipientDetailList
	 */
	public List<AlocUserInfo> getGeRecipientDetailList() {
		return geRecipientDetailList;
	}

	/**
	 * Method to set GE Recipient Detail List
	 * @param geRecipientDetailList the geRecipientDetailList to set
	 */
	public void setGeRecipientDetailList(List<AlocUserInfo> geRecipientDetailList) {
		this.geRecipientDetailList = geRecipientDetailList;
	}

	/**
	 * Method to get Gold Id Value
	 * @return the goldId
	 */
	public String getGoldId() {
		return goldId;
	}

	/**
	 * Method to set Gold Id Value
	 * @param goldId the goldId to set
	 */
	public void setGoldId(String goldId) {
		this.goldId = goldId;
	}

	/**
	 * Method to get Page Number
	 * @return the pageNumber
	 */
	public int getPageNumber() {
		return pageNumber;
	}

	/**
	 * Method to get Address Type Id
	 * @return the addressTypeId
	 */
	public int getAddressTypeId() {
		return addressTypeId;
	}

	/**
	 * Method to get Person Name
	 * @return the personName
	 */
	public String getPersonName() {
		return personName;
	}

	/**
	 * Method to set Page Number
	 * @param pageNumber the pageNumber to set
	 */
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	/**
	 * Method to get Address Index
	 * @return the addressIndex
	 */
	public int getAddressIndex() {
		return addressIndex;
	}

	/**
	 * Method to set Address Index
	 * @param addressIndex the addressIndex to set
	 */
	public void setAddressIndex(int addressIndex) {
		this.addressIndex = addressIndex;
	}

	/**
	 * Method to get Name For Address
	 * @return the nameForAddress
	 */
	public String getNameForAddress() {
		return nameForAddress;
	}

	/**
	 * Method to set Name For Address
	 * @param nameForAddress the nameForAddress to set
	 */
	public void setNameForAddress(String nameForAddress) {
		this.nameForAddress = nameForAddress;
	}

	/**
	 * Method to get Address Type Name
	 * @return the addressTypeName
	 */
	public String getAddressTypeName() {
		return addressTypeName;
	}

	/**
	 * Method to set Address Type Name
	 * @param addressTypeName the addressTypeName to set
	 */
	public void setAddressTypeName(String addressTypeName) {
		this.addressTypeName = addressTypeName;
	}

	/**
	 * Method to set Address Type Id
	 * @param addressTypeId the addressTypeId to set
	 */
	public void setAddressTypeId(int addressTypeId) {
		this.addressTypeId = addressTypeId;
	}

	/**
	 * Method to set Person Name
	 * @param personName the personName to set
	 */
	public void setPersonName(String personName) {
		this.personName = personName;
	}

	/**
	 * Method to get GE Recipient
	 * @return the geRecipient
	 */
	public String getGeRecipient() {
		return geRecipient;
	}

	/**
	 * Method to set GE Recipient
	 * @param geRecipient the geRecipient to set
	 */
	public void setGeRecipient(String geRecipient) {
		this.geRecipient = geRecipient;
	}

	/**
	 * Method to get Bank Name
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * Method to set Bank Name
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	/**
	 * Method to get the bankCountryCd value
	 * @return the bankCountryCd
	 */
	public String getBankCountryCd() {
		return bankCountryCd;
	}

	/**
	 * Method to set the bankCountryCd value
	 * @param bankCountryCd the bankCountryCd to set
	 */
	public void setBankCountryCd(String bankCountryCd) {
		this.bankCountryCd = bankCountryCd;
	}

	/**
	 * Method to get the bankCountryCd value
	 * @return the bankCountry
	 */
	public String getBankCountry() {
		return bankCountry;
	}

	/**
	 * Method to set the bankCountryCd value
	 * @param bankCountry the bankCountry to set
	 */
	public void setBankCountry(String bankCountry) {
		this.bankCountry = bankCountry;
	}

	/**
	 * Method to get the bankCity value
	 * @return the bankCity
	 */
	public String getBankCity() {
		return bankCity;
	}

	/**
	 * Method to set the bankCity value
	 * @param bankCity the bankCity to set
	 */
	public void setBankCity(String bankCity) {
		this.bankCity = bankCity;
	}

	/**
	 * Method to get the bankAddress value
	 * @return the bankAddress
	 */
	public String getBankAddress() {
		return bankAddress;
	}

	/**
	 * Method to set the bankAddress value
	 * @param bankAddress the bankAddress to set
	 */
	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}

	/**
	 * Method to get the bankBIC value
	 * @return the bankBIC
	 */
	public String getBankBIC() {
		return bankBIC;
	}

	/**
	 * Method to set the bankBIC value
	 * @param bankBIC the bankBIC to set
	 */
	public void setBankBIC(String bankBIC) {
		this.bankBIC = bankBIC;
	}

	/**
	 * Method to get Bank Details List
	 * @return the bankDetailsList
	 */
	public List<BankDetails> getBankDetailsList() {
		return bankDetailsList;
	}

	/**
	 * Method to set Bank Details List
	 * @param bankDetailsList the bankDetailsList to set
	 */
	public void setBankDetailsList(List<BankDetails> bankDetailsList) {
		this.bankDetailsList = bankDetailsList;
	}

	/**
	 * Method to get Record Count
	 * @return the recordCount
	 */
	public int getRecordCount() {
		return recordCount;
	}

	/**
	 * Method to set Record Count
	 * @param recordCount the recordCount to set
	 */
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	/**
	 * Method to get Previous Page Start
	 * @return the previousPageStart
	 */
	public int getPreviousPageStart() {
		return previousPageStart;
	}

	/**
	 * Method to set Previous Page Start
	 * @param previousPageStart the previousPageStart to set
	 */
	public void setPreviousPageStart(int previousPageStart) {
		this.previousPageStart = previousPageStart;
	}

	/**
	 * Method to get NextPageStart
	 * @return the nextPageStart
	 */
	public int getNextPageStart() {
		return nextPageStart;
	}

	/**
	 * Method to set NextPageStart 
	 * @param nextPageStart the nextPageStart to set
	 */
	public void setNextPageStart(int nextPageStart) {
		this.nextPageStart = nextPageStart;
	}

	/**
	 * Method to get IBS Details List
	 * @return the ibsDetailsList
	 */
	public List<IBSDetails> getIbsDetailsList() {
		return ibsDetailsList;
	}

	/**
	 * Method to set IBS Details List
	 * @param ibsDetailsList the ibsDetailsList to set
	 */
	public void setIbsDetailsList(List<IBSDetails> ibsDetailsList) {
		this.ibsDetailsList = ibsDetailsList;
	}

	/**
	 * Method to get GoldId CSO Validation
	 * @return the goldIdCSOValidation
	 */
	public GoldIdCSOValidation getGoldIdCSOValidation() {
		return goldIdCSOValidation;
	}

	/**
	 * Method to set GoldId CSO Validation
	 * @param goldIdCSOValidation the goldIdCSOValidation to set
	 */
	public void setGoldIdCSOValidation(GoldIdCSOValidation goldIdCSOValidation) {
		this.goldIdCSOValidation = goldIdCSOValidation;
	}

	/**
	 * Method to get LookUp No
	 * @return
	 */
	public String getLookUpNo() {
		return lookUpNo;
	}
	/**
	 * Method to set LookUp No
	 * @param lookUpNo
	 */
	public void setLookUpNo(String lookUpNo) {
		this.lookUpNo = lookUpNo;
	}
	/* -------------------------------------------------------------------------------------------------------------------------------------------
	 * 														INJECTOR METHODS
	 -------------------------------------------------------------------------------------------------------------------------------------------- */

	/**
	 * Method to create lookupManager instance object.
	 * @return
	 */
	public ILookupManager getLookupManager() {
		return lookupManager;
	}

	/**
	 * Method to create lookupManager instance object.
	 * @param lookupManager
	 */
	public void setLookupManager(ILookupManager lookupManager) {
		this.lookupManager = lookupManager;
	}

	/**
	 * Method to get readOnlyFlag value
	 * @return the readOnlyFlag
	 */
	public boolean isReadOnlyFlag() {
		return readOnlyFlag;
	}

	/**
	 * Method to set readOnlyFlag value
	 * @param readOnlyFlag the readOnlyFlag to set
	 */
	public void setReadOnlyFlag(boolean readOnlyFlag) {
		this.readOnlyFlag = readOnlyFlag;
	}
	
	/**
	 * Method to get bankDetailCountryCd value
	 * @return the bankDetailCountryCd
	 */
	public String getBankDetailCountryCd() {
		return bankDetailCountryCd;
	}

	/**
	 * Method to set bankDetailCountryCd value
	 * @param bankDetailCountryCd the bankDetailCountryCd to set
	 */
	public void setBankDetailCountryCd(String bankDetailCountryCd) {
		this.bankDetailCountryCd = bankDetailCountryCd;
	}

	/**
	 * Method to get bankDetailCountry value
	 * @return the bankDetailCountry
	 */
	public String getBankDetailCountry() {
		return bankDetailCountry;
	}

	/**
	 * Method to set bankDetailCountry value
	 * @param bankDetailCountry the bankDetailCountry to set
	 */
	public void setBankDetailCountry(String bankDetailCountry) {
		this.bankDetailCountry = bankDetailCountry;
	}
	
	/**
	 * Method to get requestorName value
	 * @return the requestorName
	 */
	public String getRequestorName() {
		return requestorName;
	}

	/**
	 * Method to set requestorName value
	 * @param requestorName the requestorName to set
	 */
	public void setRequestorName(String requestorName) {
		this.requestorName = requestorName;
	}
	/**
	 * Method to get requestorLookupDetailsList value
	 * @return the requestorLookupDetailsList
	 */
	public List<RequestorLookupDetails> getRequestorLookupDetailsList() {
		return requestorLookupDetailsList;
	}

	/**
	 * Method to set requestorLookupDetailsList value
	 * @param requestorLookupDetailsList the requestorLookupDetailsList to set
	 */
	public void setRequestorLookupDetailsList(
			List<RequestorLookupDetails> requestorLookupDetailsList) {
		this.requestorLookupDetailsList = requestorLookupDetailsList;
	}
	
	/**
	 * Method to get requestorType value
	 * @return the requestorType
	 */
	public String getRequestorType() {
		return requestorType;
	}

	/**
	 * Method to set requestorType value
	 * @param requestorType the requestorType to set
	 */
	public void setRequestorType(String requestorType) {
		this.requestorType = requestorType;
	}
	
	/**
	 * Method to get newRequestorName value
	 * @return the newRequestorName
	 */
	public String getNewRequestorName() {
		return newRequestorName;
	}

	/**
	 * Method to set newRequestorName value
	 * @param newRequestorName the newRequestorName to set
	 */
	public void setNewRequestorName(String newRequestorName) {
		this.newRequestorName = newRequestorName;
	}
	
	/**
	 * Method to get bucFirstName value
	 * @return the bucFirstName
	 */
	public String getBucFirstName() {
		return bucFirstName;
	}

	/**
	 * Method to set bucFirstName value
	 * @param bucFirstName the bucFirstName to set
	 */
	public void setBucFirstName(String bucFirstName) {
		this.bucFirstName = bucFirstName;
	}

	/**
	 * Method to get bucLastName value
	 * @return the bucLastName
	 */
	public String getBucLastName() {
		return bucLastName;
	}

	/**
	 * Method to set bucLastName value
	 * @param bucLastName the bucLastName to set
	 */
	public void setBucLastName(String bucLastName) {
		this.bucLastName = bucLastName;
	}

	/**
	 * @return the userDetailsList
	 */
	public List<UserDetails> getUserDetailsList() {
		return userDetailsList;
	}

	/**
	 * @param userDetailsList the userDetailsList to set
	 */
	public void setUserDetailsList(List<UserDetails> userDetailsList) {
		this.userDetailsList = userDetailsList;
	}
	
	/**
	 * @return the dlocAddressType
	 */
	public String getDlocAddressType() {
		return dlocAddressType;
	}

	/**
	 * @param dlocAddressType the dlocAddressType to set
	 */
	public void setDlocAddressType(String dlocAddressType) {
		this.dlocAddressType = dlocAddressType;
	}
}
