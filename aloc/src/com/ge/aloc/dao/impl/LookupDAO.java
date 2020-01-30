/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: LookupDAO.java
 * Purpose: LookupDAO used for the all the lookup DAO Implementations
 */
package com.ge.aloc.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.ge.aloc.AddressType;
import com.ge.aloc.OpCode;
import com.ge.aloc.ServiceClientSupport;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.dao.ILookupDAO;
import com.ge.aloc.model.AddressDtls;
import com.ge.aloc.model.AlocUserData;
import com.ge.aloc.model.AlocUserDataResp;
import com.ge.aloc.model.IBSDetails;
import com.ge.aloc.model.IBSDetails.ADN;
import com.ge.aloc.model.IBSDetails.BUC;
import com.ge.aloc.model.MDM;
import com.ge.aloc.model.MDM.BankDetails;
import com.ge.aloc.model.MDM.Entity;
import com.ge.aloc.model.MDM.GoldIdCSOValidation;
import com.ge.aloc.model.MDM.Pagination;
import com.ge.aloc.model.MsgHeader;
import com.ge.aloc.model.RequestorLookUp;
import com.ge.aloc.model.RequestorSearchRequest;
import com.ge.aloc.model.StaticDataManagement;
import com.ge.aloc.model.StaticDataManagement.UserSites;
import com.ge.aloc.model.UserDetails;
import com.ge.aloc.util.ALOCCommonHelper;
import com.hydus.hwf.context.UserContext;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author chaitanya.n
 *
 */
public class LookupDAO extends ServiceClientSupport implements ILookupDAO {

	/**
	 * @see com.ge.aloc.dao.ILookupDAO#invokeStaticDataService()
	 */
	public StaticDataManagement invokeStaticDataService() throws HWFServiceException{

		StaticDataManagement staticDataObject = new StaticDataManagement();
		staticDataObject.setMsgHeader(setMsgHeader(OpCode.COMMONSTATICDATA));
		List<UserSites> usersites = new ArrayList<UserSites>();
		UserSites usersite = new UserSites();
		String userSSO = UserContext.getContext().getuserDetails().getUserId();
		usersite.setUserSso(userSSO);
		usersites.add(usersite);
		staticDataObject.setUserSites(usersites);
		staticDataObject = serviceClient.invokeService(OpCode.STATICDATA.getOperationCode(), staticDataObject,StaticDataManagement.class);
		return staticDataObject;
	}

	/**
	 * @see com.ge.aloc.dao.ILookupDAO#invokeMasterDataService()
	 */
	public MDM invokeMasterDataService() throws HWFServiceException {
		MDM mdmObject = new MDM();

		mdmObject.setMsgHeader(setMsgHeader(OpCode.MDMSTATICDATA));
		mdmObject = serviceClient.invokeService(OpCode.MDM.getOperationCode(), mdmObject,MDM.class);
		return mdmObject;
	}

	/**
	 * @see com.ge.aloc.dao.ILookupDAO#invokeLegalEntity(String, Integer)
	 */
	public List<Entity> invokeLegalEntity(String goldID, Integer pageNo) throws HWFServiceException {
		MDM mdmObject = new MDM();
		List<Entity> entities = new ArrayList<Entity>();
		Entity entity = new Entity();
		entity.setLEGoldId(goldID);
		entities.add(entity);

		Pagination pagination = new Pagination();
		pagination.setPaginationEnable(true);
		pagination.setPaginationStart(pageNo);
		pagination.setPaginationIncrement(ALOCConstants.PAGE_INCREMENT);

		mdmObject.setEntities(entities);
		mdmObject.setMsgHeader(setMsgHeader(OpCode.GOLDIDINFO));
		mdmObject.setPagination(pagination);
		mdmObject = serviceClient.invokeService(OpCode.MDM.getOperationCode(), mdmObject,MDM.class);
		return mdmObject.getEntities();
	}


	/**
	 * @see com.ge.aloc.dao.ILookupDAO#invokeBusinessContactPerson(String)
	 */
	public AlocUserDataResp invokeBusinessContactPerson(String bucSSO, String bucFirstName, String bucLastName) throws HWFServiceException{
		AlocUserData alocUserData = new AlocUserData();
		if(com.hydus.hwf.util.StringUtils.isNotBlank(bucFirstName) && com.hydus.hwf.util.StringUtils.isNotBlank(bucLastName)) {
			alocUserData.setFirstName(bucFirstName);
			alocUserData.setLastName(bucLastName);
		}
		else	{
			alocUserData.setSSOID(bucSSO);
		}
		return (AlocUserDataResp)serviceClient.invokeService(OpCode.GLOBALSSOSERACH.getOperationCode(), alocUserData, AlocUserDataResp.class);
	}
	/**
	 * @see com.ge.aloc.dao.ILookupDAO#invokeNameAddress(AddressType, String)
	 */
	public List<AddressDtls> invokeNameAddress(AddressType addressType,String name)throws HWFServiceException {

		StaticDataManagement staticDataObject = new StaticDataManagement();
		staticDataObject.setMsgHeader(setMsgHeader(OpCode.ADDRDETAILS));
		List<AddressDtls> addressDetails = new ArrayList<AddressDtls>();
		AddressDtls address = new AddressDtls();
		address.setName(name);
		address.setAddressTypeId(new BigInteger(String.valueOf(addressType.getId())));
		addressDetails.add(address);
		staticDataObject.setAddressDetails(addressDetails);
		staticDataObject = serviceClient.invokeService(OpCode.STATICDATA.getOperationCode(), staticDataObject,StaticDataManagement.class);
		return staticDataObject.getAddressDetails();
	}

	/**
	 * @see com.ge.aloc.dao.ILookupDAO#invokeGERecipientDetails(String)
	 */
	public List<UserDetails> invokeGERecipientDetails(String geRecipient)
			throws HWFServiceException {
		MDM mdmObject = new MDM();
		com.ge.aloc.model.MDM.GERecipientDetails geRecipientDetails = new com.ge.aloc.model.MDM.GERecipientDetails();
		List<UserDetails> userDetailsList = new ArrayList<UserDetails>();
		UserDetails userDetail = new UserDetails();
		if(StringUtils.contains(geRecipient, ',')){
			userDetail.setFirstName(StringUtils.split(geRecipient, ',')[ALOCConstants.MIN_VALUE].trim());
			userDetail.setLastName(StringUtils.split(geRecipient, ',')[ALOCConstants.BASE_VALUE].trim());
		}else{
			userDetail.setFirstName(geRecipient);
		}
		userDetailsList.add(userDetail);
		geRecipientDetails.setUserDetails(userDetailsList);
		mdmObject.setGERecipientDetails(geRecipientDetails);
		mdmObject.setMsgHeader(setMsgHeader(OpCode.RECIPIENTDETAILS));
		mdmObject = serviceClient.invokeService(OpCode.MDM.getOperationCode(), mdmObject,MDM.class);
		return mdmObject.getGERecipientDetails().getUserDetails();
	}
	/**
	 * @see com.ge.aloc.dao.ILookupDAO#invokeBankDetails(String)
	 */
	public List<BankDetails> invokeBankDetails(String bankName, String bankCountryCd, String bankCountry, String bankCity, Integer pageNo)
			throws HWFServiceException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession ses=request.getSession();
		//MDM mdmObject = new MDM();
		//List<BankDetails> bankDetailsList = new ArrayList<MDM.BankDetails>();
		//AddressDtls addressDtls = new AddressDtls();
		//BankDetails bankDetails = new BankDetails();
		//bankDetails.setBankName(bankName);
		//addressDtls.setCountry(bankCountry);
		//addressDtls.setCountryCd(bankCountryCd);
		//addressDtls.setCity(bankCity);
		//bankDetails.setBankAddress(addressDtls);
		//bankDetailsList.add(bankDetails);

		//Pagination pagination = new Pagination();
		//pagination.setPaginationEnable(true);
		//pagination.setPaginationStart(pageNo);
		//pagination.setPaginationIncrement(ALOCConstants.PAGE_INCREMENT);
       // mdmObject.setBankDetails(bankDetailsList);
        String Flag=(String)ses.getAttribute("Flag");
      
       
        MDM mdmObject=null;
       if(Flag.equalsIgnoreCase("Y")){
    	  
            mdmObject = new MDM();
    		List<BankDetails> bankDetailsList = new ArrayList<MDM.BankDetails>();
    		AddressDtls addressDtls = new AddressDtls();
    		BankDetails bankDetails = new BankDetails();
    		bankDetails.setBankName(bankName);
    		addressDtls.setCountry(bankCountry);
    		addressDtls.setCountryCd(bankCountryCd);
    		addressDtls.setCity(bankCity);
    		bankDetails.setBankAddress(addressDtls);
    		bankDetailsList.add(bankDetails);
    		
        	Pagination pagination = new Pagination();
    		pagination.setPaginationEnable(true);
    		pagination.setPaginationStart(pageNo);
    		pagination.setPaginationIncrement(ALOCConstants.PAGE_INCREMENT);
            mdmObject.setBankDetails(bankDetailsList);
           // mdmObject.setMsgHeader(setMsgHeader(OpCode.BANKSEARCH));
        	mdmObject.setMsgHeader(setMsgHeader(OpCode.BANKDETAILS));
        	mdmObject.setPagination(pagination);
    		mdmObject = serviceClient.invokeService(OpCode.MDM.getOperationCode(), mdmObject,MDM.class);
      
        }else{
        	mdmObject = new MDM();
    		List<BankDetails> bankDetailsList = new ArrayList<MDM.BankDetails>();
    		AddressDtls addressDtls = new AddressDtls();
    		BankDetails bankDetails = new BankDetails();
    		bankDetails.setBankName(bankName);
    		addressDtls.setCountry(bankCountry);
    		addressDtls.setCountryCd(bankCountryCd);
    		addressDtls.setCity(bankCity);
    		bankDetails.setBankAddress(addressDtls);
    		bankDetailsList.add(bankDetails);
    		
        	Pagination pagination = new Pagination();
    		pagination.setPaginationEnable(true);
    		pagination.setPaginationStart(pageNo);
    		pagination.setPaginationIncrement(ALOCConstants.PAGE_INCREMENT);
            mdmObject.setBankDetails(bankDetailsList);
        	mdmObject.setMsgHeader(setMsgHeader(OpCode.BANKSEARCH));
        	mdmObject.setPagination(pagination);
    		mdmObject = serviceClient.invokeService(OpCode.MDM.getOperationCode(), mdmObject,MDM.class);
        	
        }
	    //mdmObject.setMsgHeader(setMsgHeader(OpCode.BANKDETAILS));
        
		//mdmObject.setPagination(pagination);
		//mdmObject = serviceClient.invokeService(OpCode.MDM.getOperationCode(), mdmObject,MDM.class);*/
		return mdmObject.getBankDetails();
	}

	
	/**
	 * @see com.ge.aloc.dao.ILookupDAO#invokeBankSearchResults(BankDetails)
	 */
	public List<BankDetails> invokeBankSearchResults(BankDetails bankDetails, Integer pageNo) throws HWFServiceException{
		MDM mdmObject = new MDM();
		List<BankDetails> bankDetailsList = new ArrayList<MDM.BankDetails>();
		bankDetailsList.add(bankDetails);

		Pagination pagination = new Pagination();
		pagination.setPaginationEnable(true);
		pagination.setPaginationStart(pageNo);
		pagination.setPaginationIncrement(ALOCConstants.PAGE_INCREMENT);

		mdmObject.setBankDetails(bankDetailsList);
		mdmObject.setMsgHeader(setMsgHeader(OpCode.BANKDETAILS));
		mdmObject.setPagination(pagination);
		mdmObject = serviceClient.invokeService(OpCode.MDM.getOperationCode(), mdmObject,MDM.class);
		return mdmObject.getBankDetails();
	}

	/**
	 * @see com.ge.aloc.dao.ILookupDAO#invokeIBSDetails(String, String)
	 */
	public MDM invokeIBSDetails(String bucCode, String adnCode)
			throws HWFServiceException {
		MDM mdmObject = new MDM();

		List<IBSDetails> ibsDetailsList = new ArrayList<IBSDetails>();
		IBSDetails ibsDetails = new IBSDetails();

		List<IBSDetails.ADN> adnList = new ArrayList<IBSDetails.ADN>();
		ADN adn = new ADN();
		adn.setADNCode(adnCode);
		adnList.add(adn);

		List<IBSDetails.BUC> bucList = new ArrayList<IBSDetails.BUC>();
		BUC buc = new BUC();
		buc.setBUCCode(bucCode);
		bucList.add(buc);

		ibsDetails.setADNS(adnList);
		ibsDetails.setBUCS(bucList);
		ibsDetailsList.add(ibsDetails);
		mdmObject.setIBSDetails(ibsDetailsList);
		mdmObject.setMsgHeader(setMsgHeader(OpCode.IBS));
		return serviceClient.invokeService(OpCode.MDM.getOperationCode(), mdmObject,MDM.class);
	}

	/**
	 * @see com.ge.aloc.dao.ILookupDAO#invokeCSOLEValidation(String, String)
	 */
	public GoldIdCSOValidation invokeCSOLEValidation(String csoValue, String leGoldIdValue) throws HWFServiceException {
		MDM mdmObject = new MDM();
		GoldIdCSOValidation goldIDCSOvalue = new GoldIdCSOValidation();
		goldIDCSOvalue.setCSONumber(csoValue);
		goldIDCSOvalue.setGoldId(leGoldIdValue);
		mdmObject.setGoldIdCSOValidation(goldIDCSOvalue);
		mdmObject.setMsgHeader(setMsgHeader(OpCode.CSO));
		mdmObject = serviceClient.invokeService(OpCode.MDM.getOperationCode(), mdmObject,MDM.class);
		return mdmObject.getGoldIdCSOValidation();
	}
	
	/**
	 * @see com.ge.aloc.dao.ILookupDAO#invokeRequestorDetails(java.lang.String)
	 */
	public RequestorSearchRequest invokeRequestorDetails(String requestorName) throws  HWFServiceException {
		RequestorSearchRequest requestorSearchRequest = new RequestorSearchRequest();
		List<RequestorLookUp> requestorLookUpsList = new ArrayList<RequestorLookUp>();
		RequestorLookUp requestorLookUp = new RequestorLookUp();
		requestorLookUp.setRequestorField(requestorName);
		requestorLookUpsList.add(requestorLookUp);
		requestorSearchRequest.setRequestorLookUps(requestorLookUpsList);
		requestorSearchRequest.setMsgHeader(ALOCCommonHelper.createMsgHeader(OpCode.GETREQUESTORLOOKUP.getOperationCode()));
		return serviceClient.invokeService(OpCode.GETREQUESTORDETAILS.getOperationCode(), requestorSearchRequest, RequestorSearchRequest.class);
	}

	/**
	 * Method to set Msg Header
	 * @param opCode
	 * @return
	 */
	private MsgHeader setMsgHeader(OpCode opCode) {
		MsgHeader msgHeader = new MsgHeader();
		msgHeader.setOpcode(opCode.getOperationCode());
		return msgHeader;
	}

	/**
	 * @see com.ge.aloc.dao.ILookupDAO#getMORRates()
	 */
	public String getMORRates() throws HWFServiceException {
		MDM mdmObject = new MDM();
		mdmObject.setMsgHeader(setMsgHeader(OpCode.GETALLMORRATES));
		mdmObject = serviceClient.invokeService(OpCode.MDM.getOperationCode(), mdmObject,MDM.class);
		return mdmObject.getRates().get(ALOCConstants.BASE_VALUE).getObjectCurrencyCode();
	}

	/**
	 * @see com.ge.aloc.dao.ILookupDAO#getBloombergRates()
	 */
	public String getBloombergRates() throws HWFServiceException {
		MDM mdmObject = new MDM();
		mdmObject.setMsgHeader(setMsgHeader(OpCode.GETALLBOOMBERGRATES));
		mdmObject = serviceClient.invokeService(OpCode.MDM.getOperationCode(), mdmObject,MDM.class);
		return mdmObject.getRates().get(ALOCConstants.BASE_VALUE).getObjectCurrencyCode();
	}
	
	/**
	 * @see com.ge.aloc.dao.IReportsDAO#getReportsAddressDtls()
	 */
	public List<AddressDtls> getReportsAddressDtls()throws HWFServiceException {
		StaticDataManagement staticDataObject = new StaticDataManagement();
		staticDataObject.setMsgHeader(ALOCCommonHelper.createMsgHeader(OpCode.GETREPORTSDATA.toString()));
		staticDataObject = serviceClient.invokeService(OpCode.STATICDATA.getOperationCode(), staticDataObject,StaticDataManagement.class);
		return staticDataObject.getAddressDetails();
	}
	
	/**
	 * @see com.ge.aloc.dao.ILookupDAO#invokeBusinessContactPerson(String)
	 */
	public List<UserDetails> getUserDetails(String bussContPer) throws HWFServiceException{
		MDM mdmObject = new MDM();
		com.ge.aloc.model.MDM.BussContPerson bussContPerson = new com.ge.aloc.model.MDM.BussContPerson();
		List<UserDetails> userDetailsList = new ArrayList<UserDetails>();
		UserDetails userDetail = new UserDetails();
		userDetail.setFirstName(bussContPer);
		userDetailsList.add(userDetail);
		bussContPerson.setUserDetails(userDetailsList);
		mdmObject.setBussContPerson(bussContPerson);
		mdmObject.setMsgHeader(setMsgHeader(OpCode.BUSSCONTPERSON));
		mdmObject = serviceClient.invokeService(OpCode.MDM.getOperationCode(), mdmObject,MDM.class);
		return (mdmObject.getBussContPerson()==null)?null:mdmObject.getBussContPerson().getUserDetails();
	}
}
