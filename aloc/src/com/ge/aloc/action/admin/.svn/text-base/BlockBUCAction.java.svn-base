/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: BlockKBUCAction.java
 * Purpose: Enables Treasury users to block usage of BUC and A.D.N combination.
 */
package com.ge.aloc.action.admin;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.manager.admin.IBlockBUCManager;
import com.ge.aloc.model.BusinessUnitCode;
import com.ge.aloc.model.BusinessUnitCodeList;
import com.ge.aloc.util.JSONHelper;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.hydus.hwf.exceptions.HWFServiceException;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.ValidationWorkflowAware;

/**
 * @author Rajat-Hydus
 * 
 */
public class BlockBUCAction extends ActionSupport implements ValidationWorkflowAware{

	private static final long serialVersionUID = -4518305408765228503L;

	private IBlockBUCManager blockBUCManager;
	private BusinessUnitCodeList businessUnitCodeList;
	private BusinessUnitCode businessUnitCode;
	private String searchBUCText;
	private String searchADNText;
	private Map<String, Object> sessionValues = ActionContext.getContext().getSession();
	protected boolean errorBUC;
	private String unBlockbucVal;
	private String unBlockadnVal;
	private String blockBUCSelectedVal;
	private String bucValue;
	private String reasonForBlock;

	/**
	 * Method to get the all blocked BUC list
	 * 
	 * @return
	 * @throws HWFServiceException
	 */
	public String openBUC() throws HWFServiceException {
		businessUnitCodeList = blockBUCManager.open();
		sessionValues.put(ALOCConstants.BLOCKBUCLIST, businessUnitCodeList);
		errorBUC = false;
		return ALOCConstants.SUCCESS;
	}

	/**
	 *  Method to reset and get the all blocked BUC list
	 * 
	 * @return
	 * @throws HWFServiceException
	 */
	public String resetSearchBUC() throws HWFServiceException {
		businessUnitCodeList = blockBUCManager.open();
		sessionValues.put(ALOCConstants.BLOCKBUCLIST, businessUnitCodeList);
		errorBUC = false;
		return ALOCConstants.SUCCESS;
	}

	/**
	 * Method to get the blocked ADNs for selected BUC 
	 * 
	 * @return
	 * @throws HWFServiceException
	 */
	public String searchBUC() throws HWFServiceException {
		BusinessUnitCode searchBusinessUnitCode = new BusinessUnitCode();
		searchBusinessUnitCode.setBUC(searchBUCText);
		searchBusinessUnitCode.setADN(searchADNText);
		int bucIndexZero = ALOCConstants.BUC_START_INDEX;
		businessUnitCodeList = blockBUCManager.search(searchBusinessUnitCode);
		if(businessUnitCodeList != null && businessUnitCodeList.getBusinessUnitCodes() != null && 
				businessUnitCodeList.getBusinessUnitCodes().size() > bucIndexZero){
			if(businessUnitCodeList.getBusinessUnitCodes().get(bucIndexZero).getMsgHeader() != null && 
					businessUnitCodeList.getBusinessUnitCodes().get(bucIndexZero).getMsgHeader().getStatus() != null){
				addActionMessage(businessUnitCodeList.getBusinessUnitCodes().get(bucIndexZero).getMsgHeader().getStatus());
				businessUnitCodeList = (BusinessUnitCodeList)sessionValues.get(ALOCConstants.BLOCKBUCLIST);}
			else{sessionValues.put(ALOCConstants.BLOCKBUCLIST, businessUnitCodeList);}}
		errorBUC = false;
		return ALOCConstants.SUCCESS;
	}


	/**
	 * Method to validate the given BUC 
	 * @return
	 * @throws HWFServiceException
	 */
	public String validateBUC() throws HWFServiceException {
		BusinessUnitCode resBusinessUnitCode = blockBUCManager.validateBUC(bucValue);
		HttpServletResponse response = ServletActionContext.getResponse();
		JsonObject result = new JsonObject();
		JsonArray respnseData = new JsonArray();
		JsonObject jsonSubType = new JsonObject();
		jsonSubType.addProperty(ALOCConstants.JSON_PROP_ID, ALOCConstants.BUCVALUE);
		jsonSubType.addProperty(ALOCConstants.JSON_PROP_NAME, resBusinessUnitCode.getMsgHeader().getStatus());
		respnseData.add(jsonSubType);
		result.add(ALOCConstants.RESULT, respnseData);
		JSONHelper.writeResponse(result, response);
		return ALOCConstants.SUCCESS;
	}

	/**
	 * Method to add the given block BUC details 
	 * @return
	 * @throws HWFServiceException
	 */
	public String addBlockBUC() throws HWFServiceException {
		return ALOCConstants.ADDBLOCKBUC;
	}

	/**
	 * Method to block the given BUC and ADN 
	 * @return
	 * @throws HWFServiceException
	 */
	public String blockBUC() throws HWFServiceException {
		try
		{
			BusinessUnitCode resBusinessUnitCode = blockBUCManager.blockBUC(businessUnitCode,reasonForBlock);
			if(resBusinessUnitCode.getMsgHeader().getStatus() != null)
			{	
				errorBUC = true;
				addActionError(resBusinessUnitCode.getMsgHeader().getStatus());
				businessUnitCodeList = (BusinessUnitCodeList)sessionValues.get(ALOCConstants.BLOCKBUCLIST);return INPUT;}
			else
			{
				businessUnitCodeList = blockBUCManager.open();
				sessionValues.put(ALOCConstants.BLOCKBUCLIST, businessUnitCodeList);
				errorBUC = false;
				businessUnitCode = null; return ALOCConstants.SUCCESS;}
		}catch(HWFServiceException hse){
			errorBUC = true;
			addActionError(hse.getReason());
			businessUnitCodeList = (BusinessUnitCodeList)sessionValues.get(ALOCConstants.BLOCKBUCLIST);
			return INPUT;
		}
	}

	/**
	 * Method to unblock the given BUC and ADN 
	 * @return
	 * @throws HWFServiceException
	 */
	public String unBlockBUC() throws HWFServiceException {
		blockBUCManager.unBlockBUC(businessUnitCode);
		businessUnitCodeList = blockBUCManager.open();
		sessionValues.put(ALOCConstants.BLOCKBUCLIST, businessUnitCodeList);
		errorBUC = false;
		businessUnitCode = null;
		return ALOCConstants.SUCCESS;
	}

	/**
	 * Method to unblock the selected BUC and ADN values 
	 * @return
	 * @throws HWFServiceException
	 */
	public String unBlockSelBUC() throws HWFServiceException {
		return ALOCConstants.UNBLOCKSUCCESS;
	}

	/**
	 * This method decides the page to display on validation error conditions
	 */
	public String getInputResultName() {
		String invokedMethod = ActionContext.getContext().getActionInvocation().getProxy().getMethod();
		if(invokedMethod.equals(ALOCConstants.BLOCKBUCMETHOD))
			errorBUC = true;
		businessUnitCodeList = (BusinessUnitCodeList)sessionValues.get(ALOCConstants.BLOCKBUCLIST);
		return INPUT;
	}

	/**
	 * This method is used to get the session object instance
	 * 
	 * @return the sessionValues
	 */
	public Map<String, Object> getSessionValues() {
		return sessionValues;
	}

	/**
	 * This method is used to set the session object instance
	 * 
	 * @param sessionValues
	 *            the sessionValues to set
	 */
	public void setSessionValues(Map<String, Object> sessionValues) {
		this.sessionValues = sessionValues;
	}

	/**
	 * This method is used to get the blockBUCManager object instance
	 * @return the blockBUCManager
	 */
	public IBlockBUCManager getBlockBUCManager() {
		return blockBUCManager;
	}

	/**
	 * This method is used to set the blockBUCManager object instance
	 * @param blockBUCManager the blockBUCManager to set
	 */
	public void setBlockBUCManager(IBlockBUCManager blockBUCManager) {
		this.blockBUCManager = blockBUCManager;
	}

	/**
	 * This method is used to get the businessUnitCodeList object instance
	 * @return the businessUnitCodeList
	 */
	public BusinessUnitCodeList getBusinessUnitCodeList() {
		return businessUnitCodeList;
	}

	/**
	 * This method is used to set the businessUnitCodeList object instance
	 * @param businessUnitCodeList the businessUnitCodeList to set
	 */
	public void setBusinessUnitCodeList(BusinessUnitCodeList businessUnitCodeList) {
		this.businessUnitCodeList = businessUnitCodeList;
	}

	/**
	 * This method is used to get the businessUnitCode object instance
	 * @return the businessUnitCode
	 */
	public BusinessUnitCode getBusinessUnitCode() {
		return businessUnitCode;
	}

	/**
	 * This method is used to set the businessUnitCode object instance
	 * @param businessUnitCode the businessUnitCode to set
	 */
	public void setBusinessUnitCode(BusinessUnitCode businessUnitCode) {
		this.businessUnitCode = businessUnitCode;
	}

	/**
	 * This method is used to check the errorBUC valid or not
	 * @return the errorBUC
	 */
	public boolean isErrorBUC() {
		return errorBUC;
	}

	/**
	 * This method is used to set the errorBUC value
	 * @param errorBUC the errorBUC to set
	 */
	public void setErrorBUC(boolean errorBUC) {
		this.errorBUC = errorBUC;
	}

	/**
	 * This method is used to get the searchBUCText value
	 * @return the searchBUCText
	 */
	public String getSearchBUCText() {
		return searchBUCText;
	}

	/**
	 * This method is used to set the searchBUCText value
	 * @param searchBUCText the searchBUCText to set
	 */
	public void setSearchBUCText(String searchBUCText) {
		this.searchBUCText = searchBUCText;
	}

	/**
	 * This method is used to get the searchADNText value
	 * @return the searchADNText
	 */
	public String getSearchADNText() {
		return searchADNText;
	}

	/**
	 * This method is used to set the searchADNText value
	 * @param searchADNText the searchADNText to set
	 */
	public void setSearchADNText(String searchADNText) {
		this.searchADNText = searchADNText;
	}

	/**
	 * This method is used to get the unBlockbucVal value
	 * @return the unBlockbucVal
	 */
	public String getUnBlockbucVal() {
		return unBlockbucVal;
	}

	/**
	 * This method is used to set the unBlockbucVal value
	 * @param unBlockbucVal the unBlockbucVal to set
	 */
	public void setUnBlockbucVal(String unBlockbucVal) {
		this.unBlockbucVal = unBlockbucVal;
	}

	/**
	 * This method is used to get the unBlockadnVal value
	 * @return the unBlockadnVal
	 */
	public String getUnBlockadnVal() {
		return unBlockadnVal;
	}

	/**
	 * This method is used to set the unBlockadnVal value
	 * @param unBlockadnVal the unBlockadnVal to set
	 */
	public void setUnBlockadnVal(String unBlockadnVal) {
		this.unBlockadnVal = unBlockadnVal;
	}

	/**
	 * This method is used to get the blockBUCSelectedVal value
	 * @return the blockBUCSelectedVal
	 */
	public String getBlockBUCSelectedVal() {
		return blockBUCSelectedVal;
	}

	/**
	 * This method is used to set the blockBUCSelectedVal value
	 * @param blockBUCSelectedVal the blockBUCSelectedVal to set
	 */
	public void setBlockBUCSelectedVal(String blockBUCSelectedVal) {
		this.blockBUCSelectedVal = blockBUCSelectedVal;
	}

	/**
	 * This method is used to get the bucValue value
	 * @return the bucValue
	 */
	public String getBucValue() {
		return bucValue;
	}

	/**
	 *  This method is used to set the bucValue value
	 * @param bucValue the bucValue to set
	 */
	public void setBucValue(String bucValue) {
		this.bucValue = bucValue;
	}

	/**
	 *  This method is used to get the reasonForBlock value
	 * @return the reasonForBlock
	 */
	public String getReasonForBlock() {
		return reasonForBlock;
	}

	/**
	 *  This method is used to get the reasonForBlock value
	 * @param reasonForBlock the reasonForBlock to set
	 */
	public void setReasonForBlock(String reasonForBlock) {
		this.reasonForBlock = reasonForBlock;
	}
}