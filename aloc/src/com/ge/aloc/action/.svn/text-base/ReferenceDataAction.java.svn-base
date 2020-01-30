/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ReferenceDataAction.java
 * Purpose: ReferenceDataAction used for all the ajax operations
 */
package com.ge.aloc.action;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.ge.aloc.ALOCContext;
import com.ge.aloc.InstrumentType;
import com.ge.aloc.StaticDataFactory;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.exception.ALOCRuntimeException;
import com.ge.aloc.manager.IReferenceDataManager;
import com.ge.aloc.model.DelegationApprovers;
import com.ge.aloc.model.DelegationGroup;
import com.ge.aloc.model.GroupApprover;
import com.ge.aloc.model.InstrumentRisk;
import com.ge.aloc.model.PoleCountry;
import com.ge.aloc.model.ReimburseList;
import com.ge.aloc.model.Reimbursement;
import com.ge.aloc.model.RequestDetails;
import com.ge.aloc.model.SiteAdminStaticData;
import com.ge.aloc.model.SiteAdminStaticData.SitesList;
import com.ge.aloc.model.StaticDataManagement.ParentSites;
import com.ge.aloc.model.StaticDataManagement.UserSites;
import com.ge.aloc.model.TransactionParties;
import com.ge.aloc.util.ALOCCommonHelper;
import com.ge.aloc.util.JSONHelper;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.hydus.hwf.context.UserContext;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author narasimhulu.b
 *
 */
public class ReferenceDataAction {

	private IReferenceDataManager referenceDataManager;
	protected List<UserSites> childSitesList;
	protected List<ParentSites> parentSiteLst;
	private String parentPrefix;
	private String parentDescription;
	private List<BigInteger> selSites;
	private String selSiteList;

	/**
	 * This is used to get USD Equivalent based on the currency code for the specific amount.
	 * @return
	 * @throws HWFServiceException
	 * @throws IOException
	 */
	public void getUSDEquivalent() throws HWFServiceException{
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String curencyCode=request.getParameter(ALOCConstants.CURRCODE);
		String originalAmount=request.getParameter(ALOCConstants.ORIGINALCCYAMOUNT);
		String amount=originalAmount.replace(ALOCConstants.COMMA, ALOCConstants.EMPTY_STRING);
			BigDecimal result = referenceDataManager.getUSDEquivalentDetails(curencyCode, new BigDecimal(amount));
			if(result!= null){
			JSONHelper.writeSuccessResponse(result.toString(), response);
			}else{
				JSONHelper.writeSuccessResponse(ALOCConstants.EMPTY_STRING, response);
			}
	}

	/**
	 * This is used to get the SiteType.
	 * @return
	 */
	public void getSiteType() throws HWFServiceException {
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String siteId=request.getParameter(ALOCConstants.SITEID);
		JsonObject result = new JsonObject();
		try {
			RequestDetails requestDetails = referenceDataManager.getSiteType(siteId);
			if (requestDetails != null) {
				JsonObject jsonSubType = new JsonObject();
				jsonSubType.addProperty(ALOCConstants.SITE_TYPE, requestDetails.getSiteTypeName());
				TransactionParties transactionParties = requestDetails.getTransactionParties();
				if(transactionParties!=null && transactionParties.getTpApplicantDetails()!=null){
					String bucCode=transactionParties.getTpApplicantDetails().getBuUnit();
					String adnCode=transactionParties.getTpApplicantDetails().getAccDist();
					if(StringUtils.isNotBlank(bucCode)){
						jsonSubType.addProperty(ALOCConstants.BUCID, bucCode);
					}
					if(StringUtils.isNotBlank(adnCode)){
						jsonSubType.addProperty(ALOCConstants.ADNID, adnCode);
					}
					
				}
				result.add(ALOCConstants.RESULT, jsonSubType);
				JSONHelper.writeResponse(result, response);
			}
		} catch (HWFServiceException hwfse) {
			JSONHelper.writeFailureResponse(hwfse.getCode(), hwfse.getLocalizedMessage(), response);
		}

	}
	

	/**
	 * This is used to get the bond sub types.
	 * @return
	 */
	public void getBondSubTypes() throws HWFServiceException {
		referenceDataManager.getBondSubTypes(false);
	}

	/**
	 * This is used to get admin bond sub types.
	 * @return
	 */
	public void getAdminBondSubTypes() throws HWFServiceException {
		referenceDataManager.getBondSubTypes(true);			
	}

	/**
	 * Method to get the Parent Sites
	 * @return
	 */
	public void loadParentSites(){
		String modifySiteTypeId = ServletActionContext.getRequest().getParameter(ALOCConstants.MODIFY_SITE_TYPE);
		String siteId = ServletActionContext.getRequest().getParameter(ALOCConstants.SITE_ID);
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			StaticDataFactory staticDataFactory =ALOCContext.getStaticDataFactory(); 
			List<SiteAdminStaticData.SitesList> siteTypes = staticDataFactory.getAllSites();
			JsonObject result = new JsonObject();
			JsonArray respnseData = new JsonArray();
			if(siteTypes!=null){
				for(SitesList subType : siteTypes) {
					JsonObject jsonSubType = new JsonObject();
					if(subType.getSiteTypeId()!=null && modifySiteTypeId.equals(subType.getSiteTypeId().toString())){
						jsonSubType.addProperty(ALOCConstants.JSON_PROP_ID, subType.getSiteId());
						jsonSubType.addProperty(ALOCConstants.JSON_PROP_NAME, subType.getSiteName());
						if(!(StringUtils.isNotBlank(siteId) && siteId.equals(subType.getSiteId().toString()))){
							respnseData.add(jsonSubType);
						}
					}
				}
			}
			result.add(ALOCConstants.RESULT, respnseData);
			JSONHelper.writeResponse(result, response);
		} catch (HWFServiceException hwfse) {
			JSONHelper.writeFailureResponse(hwfse.getCode(), hwfse.getLocalizedMessage(), response);
		}
	}

	/**
	 * Method to get the Parent prefix,Description & ChildSites Types from the Service
	 * @return
	 * @throws HWFServiceException 
	 */
	public void getDescPrefixParentSites() throws HWFServiceException{
		referenceDataManager.getChildSites();
	}


	/**
	 * Method to get the Site Names from Static data factory for the copy Site
	 * @return
	 * @throws HWFServiceException
	 */
	public void getSiteNames() throws HWFServiceException {
		referenceDataManager.getSiteNames();
	}

	/**
	 * Method to get the Site Types
	 * @return
	 */
	public void getAvailSites() throws HWFServiceException, IOException{
		referenceDataManager.getAvailSites();
	}

	/**
	 * Method to the Delegation Approvers
	 * @return
	 */
	public void getDelegationApprovers() {
		RequestDetails requestDetails = ALOCContext.getActiveRequest().getModel();
		setDelegationApprovers(requestDetails);
	}

	/**
	 * Method used to get delegation approvers on click
	 * @throws HWFServiceException
	 */
	public void getApprovers() throws HWFServiceException{
		String wfstage=null;
		HttpServletRequest request=ServletActionContext.getRequest();
		BigInteger requestId= new BigInteger(request.getParameter(ALOCConstants.REQUESTID));
		BigInteger InstrumentTypeId= new BigInteger(request.getParameter(ALOCConstants.INSTRUMENTTYPEID));
		String amount = request.getParameter(ALOCConstants.APPROVERAMOUNT).replace(ALOCConstants.COMMA, ALOCConstants.EMPTY_STRING);
		String AmendmentOrRiderId = request.getParameter(ALOCConstants.AMENDMENTORRIDERID);
		String isResubmitPage = request.getParameter(ALOCConstants.ISRESUBMITPAGE);
		String isIRReadonlyPage = request.getParameter(ALOCConstants.ISIRREADONLYPAGE);
		BigDecimal approverAmount= new BigDecimal(amount);
		RequestDetails activeRequestDetails = ALOCContext.getActiveRequest().getModel();
		InstrumentRisk instrumentRisk = new InstrumentRisk();
		String activeRequestId;
		if(InstrumentTypeId!=null && InstrumentTypeId.intValue()==InstrumentType.AMENDMENT.getId() && StringUtils.isNotBlank(AmendmentOrRiderId)){
			activeRequestId=activeRequestDetails.getAmendment()!=null?activeRequestDetails.getAmendment().getAmendmentRequestId():null;
		}else if(InstrumentTypeId!=null && InstrumentTypeId.intValue()==InstrumentType.RIDER.getId() && StringUtils.isNotBlank(AmendmentOrRiderId)){
			activeRequestId=activeRequestDetails.getRider()!=null?activeRequestDetails.getRider().getRiderRequestId():null;
		}else{
		 activeRequestId = activeRequestDetails.getRequestId()!=null ? activeRequestDetails.getRequestId().toString() :null;
		}
		String openedRequestId=AmendmentOrRiderId!=null?AmendmentOrRiderId:requestId!=null?requestId.toString():null;
		if(StringUtils.isBlank(activeRequestId) || (StringUtils.isNotBlank(activeRequestId) && !activeRequestId.equalsIgnoreCase(openedRequestId))){
			throw new ALOCRuntimeException(ALOCRuntimeException.EC_ACTIVEREQUEST_NOTFOUND);
		}
		if(StringUtils.isNotBlank(isResubmitPage) && StringUtils.isBlank(isIRReadonlyPage) && InstrumentTypeId!=null && (InstrumentTypeId.intValue()==InstrumentType.BANK_GUARANTEE.getId() || InstrumentTypeId.intValue()==InstrumentType.LOC.getId())){
			boolean notiClauseFlag = new Boolean(request.getParameter(ALOCConstants.NOTICLAUSEFLAG)).booleanValue();
			boolean curePeriodFlag = new Boolean(request.getParameter(ALOCConstants.CUREPERIODFLAG)).booleanValue();
			boolean drDownApprFlag = new Boolean(request.getParameter(ALOCConstants.DRDOWNAPPRFLAG)).booleanValue();
			instrumentRisk.setNotiClauseFlag(notiClauseFlag);
			instrumentRisk.setCurePeriodFlag(curePeriodFlag);
			instrumentRisk.setDrDownApprFlag(drDownApprFlag);
		}else if(InstrumentTypeId!=null && (InstrumentTypeId.intValue()==InstrumentType.BANK_GUARANTEE.getId() || InstrumentTypeId.intValue()==InstrumentType.LOC.getId())){
			if(activeRequestDetails.getInstrumentRisk()!=null){
				instrumentRisk = activeRequestDetails.getInstrumentRisk();
				}
		}
		 wfstage= request.getParameter(ALOCConstants.WFSTAGE);
		RequestDetails requestDetails = referenceDataManager.getDelegationApprovers(requestId,InstrumentTypeId,approverAmount,wfstage,instrumentRisk);
		List<DelegationGroup> delegationgroups= requestDetails.getDelegationApprovers().getDelegationGroups();
		
		if (delegationgroups != null) {
			if(ALOCContext.getActiveRequest().getModel().getDelegationApprovers() == null){
				DelegationApprovers DelegationApprovers = new DelegationApprovers ();
				ALOCContext.getActiveRequest().getModel().setDelegationApprovers(DelegationApprovers);
			}
			ALOCContext.getActiveRequest().getModel().getDelegationApprovers().setDelegationGroups(delegationgroups);
			ALOCContext.getActiveRequest().getModel().getDelegationApprovers().setApprovalLevelRequired(requestDetails.getDelegationApprovers().getApprovalLevelRequired());
		}
		setDelegationApprovers(requestDetails);
	}

	/**
	 * Method used to set delegation approvers  
	 * @param requestDetails
	 */
	public void setDelegationApprovers(RequestDetails requestDetails) {
		HttpServletResponse response = ServletActionContext.getResponse();
		List<DelegationGroup> delegationGroups = new ArrayList<DelegationGroup>();
		DelegationApprovers delegationApprovers= requestDetails.getDelegationApprovers();
		List<GroupApprover> groupApprovers = new ArrayList<GroupApprover>();
		if (delegationApprovers != null) {
			delegationGroups = delegationApprovers.getDelegationGroups();
				groupApprovers = (delegationGroups.get(ALOCConstants.DELEGATION_APPROVER_BASEINDEX)).getGroupApprovers();
		}
		Collections.sort(groupApprovers);
		JsonObject result = new JsonObject();
		JsonArray respnseData = new JsonArray();
		RequestDetails activeRequestDetails = ALOCContext.getActiveRequest().getModel();
		for (GroupApprover levels : groupApprovers) {
			if (activeRequestDetails != null) {
				if (activeRequestDetails.getRequestSummary() != null && activeRequestDetails.getRequestSummary().getRequestor() != null
						&& activeRequestDetails.getRequestSummary().getRequestor().getSsoId() != null && levels.getSssoId() != null 
						) {
					if(!(levels.getSssoId().equalsIgnoreCase(activeRequestDetails.getRequestSummary().getRequestor().getSsoId()))){
						JsonObject jsonSubType = new JsonObject();
						respnseData.add(setApproverDataToJson(levels,delegationApprovers,jsonSubType));
					}
				}else if(UserContext.getContext().getuserDetails()!=null && UserContext.getContext().getuserDetails().getUserId()!=null && !(levels.getSssoId().equalsIgnoreCase(UserContext.getContext().getuserDetails().getUserId()))){
				JsonObject jsonSubType = new JsonObject();
				respnseData.add(setApproverDataToJson(levels,delegationApprovers,jsonSubType));
				}
			}else {
			JsonObject jsonSubType = new JsonObject();
			respnseData.add(setApproverDataToJson(levels,delegationApprovers,jsonSubType));
			}
		}
		result.add(ALOCConstants.RESULT, respnseData);
		JSONHelper.writeResponse(result, response);
	}
	
	/**
	 * Method to set Approvers data to JSon Object
	 * @param groupApprover
	 * @param delegationApprovers
	 * @param jsonSubType
	 * @return
	 */
	public JsonObject setApproverDataToJson(GroupApprover groupApprover,DelegationApprovers delegationApprovers,JsonObject jsonSubType){
		jsonSubType.addProperty(ALOCConstants.JSON_PROP_SSOID,groupApprover.getSssoId());
		jsonSubType.addProperty(ALOCConstants.JSON_PROP_FIRSTNAME,groupApprover.getAppFirstName());
		jsonSubType.addProperty(ALOCConstants.JSON_PROP_LASTNAME,groupApprover.getAppLastName());
		jsonSubType.addProperty(ALOCConstants.JSON_PROP_APPROVE_LEVELID,groupApprover.getApproverLevelId());
		jsonSubType.addProperty(ALOCConstants.JSON_PROP_LEVELSREQUIRED,delegationApprovers.getApprovalLevelRequired());
		if(delegationApprovers.getDelegationGroups()!=null && delegationApprovers.getDelegationGroups().get(0)!=null){
			jsonSubType.addProperty(ALOCConstants.JSON_PROP_GROUPNAME,delegationApprovers.getDelegationGroups().get(0).getGroupName());	
		}else{
			jsonSubType.addProperty(ALOCConstants.JSON_PROP_GROUPNAME,ALOCConstants.EMPTY_STRING);
		}
		return jsonSubType;
	}
	/**
	 * Method to the ReiembursmentTypes
	 * @return
	 */
	public String getReiembursmentTypes() throws HWFServiceException {
		HttpServletRequest request=ServletActionContext.getRequest();
		BigInteger requestId= new BigInteger(request.getParameter(ALOCConstants.REQUESTID));
	
		HttpServletResponse response = ServletActionContext.getResponse();
		Reimbursement reimbursement = referenceDataManager.getReimbursementAgreementList(requestId);
		RequestDetails requestDetails = ALOCContext.getActiveRequest().getModel();
		JsonObject result = new JsonObject();
		JsonArray respnseData = new JsonArray();
		for (ReimburseList agreementType : reimbursement.getReimburseLists()) {
			JsonObject jsonSubType = new JsonObject();
			jsonSubType.addProperty(ALOCConstants.JSON_AGREEMENT_TYPEID,
					agreementType.getReimburseAgreementId());
			jsonSubType.addProperty(ALOCConstants.JSON_AGREEMENT_TYPENAME,
					agreementType.getReimburseAgreementName());
			jsonSubType.addProperty(ALOCConstants.JSON_DEFEALT_AGREEMENT_TYPEID,
					requestDetails.getReimbursementAgreementId());
			respnseData.add(jsonSubType);
		}
		result.add(ALOCConstants.RESULT, respnseData);
		JSONHelper.writeResponse(result, response);
		return null;
	}

	/**
	 * This is used to get poleName based on the country code for the specific country.
	 * @return
	 * @throws HWFServiceException
	 */
	public void getDefaultPole() {
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String countryCode=request.getParameter(ALOCConstants.COUNTRYCODE);
		JsonObject result = new JsonObject();
		try {
			PoleCountry poleCountry = referenceDataManager.getDefaultPole(countryCode);
			if(poleCountry!= null){
				JsonObject jsonSubType = new JsonObject();
				jsonSubType.addProperty(ALOCConstants.POLEID, poleCountry.getPoleID());
				jsonSubType.addProperty(ALOCConstants.POLENAME,poleCountry.getPoleName());
				result.add(ALOCConstants.RESULT, jsonSubType);
				JSONHelper.writeResponse(result, response);
			}
		} catch (HWFServiceException hwfse) {
			JSONHelper.writeFailureResponse(hwfse.getCode(), hwfse.getLocalizedMessage(), response);
		}
	}

	/**
	 * Method to Check the Site Name Valid or Not
	 * @return null
	 * @throws HWFServiceException
	 * @throws IOException
	 */
	public void checkSiteNameValid() throws HWFServiceException, IOException{
		referenceDataManager.checkSiteNameValid();
	}

	/**
	 * Method to Check the Site Prefix Valid or Not
	 * @return
	 * @throws HWFServiceException
	 * @throws IOException
	 */
	public void checkSitePrefixValid() throws HWFServiceException, IOException{
		referenceDataManager.checkSitePrefixValid();
	}

	/**
	 * This method is used to get the selected sites
	 * @return
	 * @throws HWFServiceException
	 */
	public String getSites() throws HWFServiceException{
		childSitesList=referenceDataManager.getSites();
		selSites = ALOCCommonHelper.getSelectedSitesForAdvanceSearch(selSiteList);
		return ALOCConstants.SUCCESS;
	}

	/* -------------------------------------------------------------------------------------------------------------------------------------------
	 * 														INJECTOR METHODS
	 -------------------------------------------------------------------------------------------------------------------------------------------- */

	/**
	 * This Method is used to get referenceDataManager
	 * @return the referenceDataManager
	 */
	public IReferenceDataManager getReferenceDataManager() {
		return referenceDataManager;
	}

	/**
	 * This Method is used to set referenceDataManager
	 * @param referenceDataManager the referenceDataManager to set
	 */
	public void setReferenceDataManager(IReferenceDataManager referenceDataManager) {
		this.referenceDataManager = referenceDataManager;
	}

	/* -------------------------------------------------------------------------------------------------------------------------------- 
	 * 											PROPERTY SETTER/GETTER METHODS
	 --------------------------------------------------------------------------------------------------------------------------------- */

	/**
	 * This Method is used to get childSitesList
	 * @return the childSitesList
	 */
	public List<UserSites> getChildSitesList() {
		return childSitesList;
	}

	/**
	 *  This Method is used to set childSitesList
	 * @param childSitesList the childSitesList to set
	 */
	public void setChildSitesList(List<UserSites> childSitesList) {
		this.childSitesList = childSitesList;
	}

	/**
	 * This Method is used to get parentSiteLst
	 * @return the parentSiteLst
	 */
	public List<ParentSites> getParentSiteLst() {
		return parentSiteLst;
	}

	/**
	 * This Method is used to set parentSiteLst
	 * @param parentSiteLst the parentSiteLst to set
	 */
	public void setParentSiteLst(List<ParentSites> parentSiteLst) {
		this.parentSiteLst = parentSiteLst;
	}

	/**
	 * This Method is used to get parentDescription
	 * @return the parentDescription
	 */
	public String getParentDescription() {
		return parentDescription;
	}

	/**
	 * This Method is used to set parentDescription
	 * @param parentDescription the parentDescription to set
	 */
	public void setParentDescription(String parentDescription) {
		this.parentDescription = parentDescription;
	}

	/**
	 * This Method is used to get parentPrefix
	 * @return the parentPrefix
	 */
	public String getParentPrefix() {
		return parentPrefix;
	}

	/**
	 * This Method is used to set parentPrefix
	 * @param parentPrefix the parentPrefix to set
	 */
	public void setParentPrefix(String parentPrefix) {
		this.parentPrefix = parentPrefix;
	}
	
	/**
	 * This Method is used to get selSites value
	 * @return the selSites
	 */
	public List<BigInteger> getSelSites() {
		return selSites;
	}

	/**
	 * This Method is used to set selSites value
	 * @param selSites the selSites to set
	 */
	public void setSelSites(List<BigInteger> selSites) {
		this.selSites = selSites;
	}

	/**
	 * This Method is used to get selSiteList value
	 * @return the selSiteList
	 */
	public String getSelSiteList() {
		return selSiteList;
	}

	/**
	 * This Method is used to set selSiteList value
	 * @param selSiteList the selSiteList to set
	 */
	public void setSelSiteList(String selSiteList) {
		this.selSiteList = selSiteList;
	}
}
