/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: RequestorAction.java
 * Purpose: RequestorAction used for the request operations
 */
package com.ge.aloc.action.requestor;


import static com.ge.aloc.constants.ALOCConstants.BANKGUARANTEE;
import static com.ge.aloc.constants.ALOCConstants.CREATEREQUEST;
import static com.ge.aloc.constants.ALOCConstants.DOCUMENTARY_LETTER_OF_CREDIT_CONFIRMATION;
import static com.ge.aloc.constants.ALOCConstants.EMPTY_STRING;
import static com.ge.aloc.constants.ALOCConstants.STANDBY_LETTER_OF_CREDIT;
import static com.ge.aloc.constants.ALOCConstants.SUBMIT;
import static com.ge.aloc.constants.ALOCConstants.SURETY_BOND;

import java.math.BigInteger;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.ge.aloc.ALOCContext;
import com.ge.aloc.ActionType;
import com.ge.aloc.InstrumentType;
import com.ge.aloc.action.request.RequestDetailsSupportAction;
import com.ge.aloc.bo.RequestDetailsBO;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.exception.ALOCAttachmentException;
import com.ge.aloc.exception.ALOCException;
import com.ge.aloc.exception.ALOCRuntimeException;
import com.ge.aloc.exception.NoActiveRequestException;
import com.ge.aloc.model.BuRequestor;
import com.ge.aloc.model.GoodsOrigin;
import com.ge.aloc.model.NameValue;
import com.ge.aloc.model.ObligeeRef;
import com.ge.aloc.model.RefDetails;
import com.ge.aloc.model.RequestDetails;
import com.ge.aloc.model.ShipmentOrigin;
import com.ge.aloc.model.SiteSelection;
import com.ge.aloc.model.StaticDataManagement.UserSites;
import com.ge.aloc.util.ALOCCommonHelper;
import com.hydus.hwf.exceptions.HWFServiceException;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author chaitanya.n
 *
 */
public class RequestorAction extends RequestDetailsSupportAction {

	private static final long serialVersionUID = -3346689068584544256L;
	private int gereferenceFieldAddIndex;
	private int gereferenceFieldRemoveIndex;

	private int oblreferenceFieldRemoveIndex;
	private int oblreferenceFieldAddIndex;

	private int buContactPersonFieldAddIndex;
	private int buContactPersonFieldRemoveIndex;

	private int geregferenceFieldAddIndex;
	private int geregferenceFieldRemoveIndex;

	private int geBenificiaryFieldAddIndex;
	private int geBenificiaryFieldRemoveIndex;

	private int shipOrgCtryFieldAddIndex;
	private int shipOrgCtryFieldRemoveIndex;

	private int originGoodsFieldAddIndex;
	private int originGoodsFieldRemoveIndex;

	private int paymentsFieldAddIndex;
	private int paymentsFieldRemoveIndex;

	private int bgGeReferenceFieldAddIndex;
	private int bgGeReferenceFieldRemoveIndex;

	private int customerFieldAddIndex;
	private int customerFieldRemoveIndex;

	private List<String> rightSelSites;
	private String selectedSiteNames;

	private ActionType actionType;

	private String instrumentTypeId;
	private String landingPageReq;

	private String siteId;

	private String sectionName;
	private String sncWorkingSection;


	/**
	 * This method is used to open the specific request based on given request Id
	 * @return
	 */
	@Override
	public String openRequest() throws HWFServiceException {
		super.openRequest();
		return SUCCESS;
	}

	/* (non-Javadoc)
	 * @see com.ge.aloc.action.request.RequestDetailsSupportAction#openAmendmentRequest()
	 * 
	 * This method is used to open the Amendment request based on given request Id
	 */
	@Override
	public String openAmendmentRequest() throws HWFServiceException {
		editMode = true;
		return super.openAmendmentRequest();
	}

	/**
	 *This method is used to open the Surety Rider request based on given request Id  
	 * @return 
	 */
	@Override
	public String openRiderRequest() throws HWFServiceException {
		editMode = true;
		return super.openRiderRequest();
	}
	/**
	 * This method is used to open the current active request
	 * @return
	 */
	@Override
	public String openActiveRequest() throws HWFServiceException {
		editMode = true;
		HttpSession session = ServletActionContext.getRequest().getSession();
		if(StringUtils.isNotBlank((String) session.getAttribute("WorkingSection"))){
			sncWorkingSection = (String) session.getAttribute("WorkingSection");
		}
		return getRequestResultPage();
	}

	/**
	 * This method is used to save the Request sections based on section Id
	 */
	@Override
	public String applySection() throws HWFServiceException, ALOCAttachmentException, ALOCException  {
		saveSection();
		return getSectionResultPage();
	}


	/**
	 * This method is used to save the Request sections based on section Id
	 * @return
	 * @throws HWFServiceException
	 * @throws ALOCException 
	 * @throws ALOCAttachmentException 
	 */
	public String saveSection() throws HWFServiceException, ALOCAttachmentException, ALOCException {
		if(sectionId != null) {
			switch(sectionId) {
			case FORMAT:					
				HttpServletRequest request = ServletActionContext.getRequest();
				String standardFormat = request.getParameter(ALOCConstants.STANDARDFORMAT);
				String modifiedFormat = request.getParameter(ALOCConstants.MODIFIEDFORMAT);						
				requestDetailsSectionManager.saveFormat(standardFormat,modifiedFormat);
				break;

			case ATTACHMENTS:
				requestDetailsSectionManager.saveAttachments();
				break;		

				/* Amendment*/
			case AMENDMENT_TRANSACTION_PARTIES:
				requestDetailsSectionManager.saveAmendmentTP();
				break;
			case INSTRUMENT_AMOUNT_CURRENCY:
				requestDetailsSectionManager.saveAmendmentIAC();
				break;
			case EXPIRATION_DATES:
				requestDetailsSectionManager.saveAmendmentED();
				break;
			case OTHER_CHANGES:
				requestDetailsSectionManager.saveAmendmentOC();
				break;
			case RIDER_PRINCIPAL:
				requestDetailsSectionManager.saveRiderPrincipal();
				break;
			case RIDER_OBLIGEE:
				requestDetailsSectionManager.saveRiderObligee();
				break;
			case RIDER_EXPIRATION_DATES:
				requestDetailsSectionManager.saveRiderExpDate();
				break;
			case RIDER_BOND_INFORMATION:
				requestDetailsSectionManager.saveRiderBondInformation();
				break;
			case RIDER_DELIVERY_INSTRUTIONS:
				requestDetailsSectionManager.saveRiderDeliveryInstructions();
				break;


			}
		}
		editMode = true;
		return getSectionResultPage();
	}

	/**
	 * This method is used to submit the Request
	 */
	@Override
	public String submit() throws HWFServiceException,ALOCAttachmentException,ALOCException {
		String resultPage=null;
		if(requestId != null){
			validateRequest();
		}
		super.save(actionType);
		HttpSession session = ServletActionContext.getRequest().getSession();
		if((ActionType.SAVE).equals(actionType)){
			resultPage=ALOCConstants.FORWARD_HOMEPAGE;
		}else if((ActionType.SAVEANDCONTINUE).equals(actionType)){
			resultPage=SUCCESS;
			session.setAttribute(ALOCConstants.WORKINGSECTION, sncWorkingSection);
		}
		RequestDetailsBO requestDetailsBO = ALOCContext.getActiveRequest();
		session.setAttribute(ALOCConstants.SUCCESSMSG, requestDetailsBO.getModel().getComments());
		return resultPage;
	}

	/**
	 * This method is used to submit the Amendment Request
	 * @return
	 * @throws HWFServiceException
	 */
	public String submitAmendment() throws HWFServiceException {
		String resultPage=null;
		saveAmendment();
		if((ActionType.SAVE).equals(actionType)){
			resultPage=ALOCConstants.FORWARD_HOMEPAGE;
		}else if((ActionType.SAVEANDCONTINUE).equals(actionType)){
			resultPage=SUCCESS;
		}

		return resultPage;
	}

	/**
	 * This method is used to submit the Surety Rider Request
	 * @return
	 * @throws HWFServiceException
	 */
	public String submitRider() throws HWFServiceException {
		String resultPage=null;
		saveRider();
		if((ActionType.SAVE).equals(actionType)){
			resultPage=ALOCConstants.FORWARD_HOMEPAGE;
		}else if((ActionType.SAVEANDCONTINUE).equals(actionType)){
			resultPage=SUCCESS;
		}

		return resultPage;
	}


	/**
	 * This method is used to create the Request coming from landing page
	 * 
	 */
	public String openLandingPage() {
		editMode = true;
		RequestDetails requestDetails = new RequestDetails();
		List<UserSites> siteList =ALOCContext.getStaticDataFactory().getUserSpecificSitesList();
		if(siteList!=null && siteList.size() == ALOCConstants.SITELIST_MINSIZE){
			NameValue siteNameValue=siteList.get(ALOCConstants.BASE_VALUE);
			requestDetails.setSiteId(siteNameValue.getID());
			requestDetails.setSiteName(siteNameValue.getName());
		}
		requestDetails=ALOCCommonHelper.addRequestSummary(requestDetails);
		requestDetails.setInstrumentTypeId(new BigInteger(instrumentTypeId));
		requestDetails.setInstrumentType(InstrumentType.fromId(Integer.parseInt(instrumentTypeId)).getName());	
		RequestDetailsBO requestDetailsBO = new RequestDetailsBO(requestDetails);
		ALOCContext.setActiveRequest(requestDetailsBO);
		return SUCCESS;
	}	
	
	/**
	 * This method is used to Create the Request details from model
	 * @return
	 * @throws HWFServiceException
	 */
	public String createModelRequest() throws HWFServiceException {
		RequestDetails requestDetails = null;
			RequestDetailsBO modelRequestDetailsBO = requestDetailsManager.openModelRequest(requestId.toString());
			requestDetails = modelRequestDetailsBO.getModel();
		
		RequestDetails cloneRequestDetails = new RequestDetails();
		cloneRequestDetails.setInstrumentType(requestDetails.getInstrumentType());
		cloneRequestDetails.setInstrumentTypeId(requestDetails.getInstrumentTypeId());
		cloneRequestDetails=ALOCCommonHelper.addRequestSummary(cloneRequestDetails);
		if(requestDetails.getSiteSelection()!= null && requestDetails.getSiteSelection().getSelectedSites() != null && requestDetails.getSiteSelection().getSelectedSites().size() > ALOCConstants.SITELIST_MINSIZE)
		{
			cloneRequestDetails.setSiteSelection(new SiteSelection());
			cloneRequestDetails.getSiteSelection().setSelectedSites(requestDetails.getSiteSelection().getSelectedSites());
		}else{
			cloneRequestDetails.setSiteId(requestDetails.getSiteId());
			cloneRequestDetails.setSiteName(requestDetails.getSiteName());
		}		
		if(requestDetails.getInstrumentType().equalsIgnoreCase(BANKGUARANTEE) || requestDetails.getInstrumentType().equalsIgnoreCase(STANDBY_LETTER_OF_CREDIT))
		{
			cloneRequestDetails = ALOCCommonHelper.bgSblcClone(requestDetails, cloneRequestDetails,false);

		}else if(requestDetails.getInstrumentType().equalsIgnoreCase(SURETY_BOND))
		{
			cloneRequestDetails = ALOCCommonHelper.suretyBondClone(requestDetails, cloneRequestDetails,false);

		}else if(requestDetails.getInstrumentType().equalsIgnoreCase(DOCUMENTARY_LETTER_OF_CREDIT_CONFIRMATION))
		{
			cloneRequestDetails = ALOCCommonHelper.dlocClone(requestDetails, cloneRequestDetails,false);		
		} 	
		cloneRequestDetails.setModelId(modelId);
		requestDetailsBO = new RequestDetailsBO(cloneRequestDetails);
		ALOCContext.setActiveRequest(requestDetailsBO);
		
		editMode=true;
		return SUCCESS;
	}
	/**
	 * This method is used to save the Request coming from landing page
	 */
	public String createRequest() throws HWFServiceException {
		String resultPage=null;
		editMode = true;
		if(requestId != null){
			validateRequest();
		}
		String selectedSiteId=EMPTY_STRING;
		HttpSession session = ServletActionContext.getRequest().getSession();
		if(StringUtils.isNotBlank(siteId)){
			selectedSiteId = getSiteId().replace(ALOCConstants.COMMA, ALOCConstants.EMPTY_STRING);
		}
		RequestDetailsBO requestDetailsBO =requestDetailsSectionManager.createLandingPageRequest(selectedSiteId,actionType);
		setRequestDetailsBO(requestDetailsBO);
		if((ActionType.SAVE).equals(actionType)){
			resultPage=ALOCConstants.FORWARD_HOMEPAGE;
		}else if((ActionType.SAVEANDCONTINUE).equals(actionType)){
			resultPage=SUCCESS;
		}
		session.setAttribute(ALOCConstants.SUCCESSMSG, requestDetailsBO.getModel().getComments());
		return resultPage;

	}

	/**
	 * This method is used to save the Request coming from landing page
	 */
	public String openBondInfo()  {
		RequestDetailsBO requestDetailsBO = ALOCContext.getActiveRequest();
		if(requestDetailsBO == null) {
			throw new NoActiveRequestException();
		}
		RequestDetails requestDetails = requestDetailsBO.getModel();
		if(requestDetails!= null && requestDetails.getBondInfo()!= null){
		requestDetails.setBondInfo(null);
		}
		editMode = true;
		return SUCCESS;

	}


	/**
	 *  This method is used to add Additional Fields dynamically
	 */
	public String addAdditionalField() {
		return SUCCESS;
	}

	/**
	 * This method is used to remove Additional Fields dynamically
	 */
	public String removeAdditionalField(){
		RequestDetailsBO requestDetailsBO = ALOCContext.getActiveRequest();
		if(requestDetailsBO == null) {
			throw new NoActiveRequestException();
		}
		RequestDetails requestDetails = requestDetailsBO.getModel();
		if(requestDetails.getInstrumentTypeId().equals(BigInteger.valueOf(InstrumentType.BANK_GUARANTEE.getId())) || requestDetails.getInstrumentTypeId().equals(BigInteger.valueOf(InstrumentType.LOC.getId()))){
			removeBgSblcAdditionalField(requestDetails);
		}
		else if(requestDetails.getInstrumentTypeId().equals(BigInteger.valueOf(InstrumentType.SURETY_BOND.getId()))){
			removeSuretyAdditionalField(requestDetails);
		}else if(requestDetails.getInstrumentTypeId().equals(BigInteger.valueOf(InstrumentType.DOCUMENT_LOC.getId()))){
			removeDLOCAdditionalField(requestDetails);
		}

		return SUCCESS;
	}

	/**
	 *This method is used to remove Surety Additional Field dynamically 
	 */
	public void removeSuretyAdditionalField(RequestDetails requestDetails) {
		if(sectionName.equalsIgnoreCase(ALOCConstants.OBLIGEE)){
			if( requestDetails != null && requestDetails.getObligee() != null && requestDetails.getObligee().getObligeeReves() != null){
				if(oblreferenceFieldAddIndex < requestDetails.getObligee().getObligeeReves().size()){
					List<ObligeeRef> refDet = requestDetails.getObligee().getObligeeReves();
					for (int i=ALOCConstants.MIN_SIZE; i<requestDetails.getObligee().getObligeeReves().size();i++) {
						if(oblreferenceFieldAddIndex <= i){
							refDet.remove(i);
						}
					}
					requestDetails.getObligee().setObligeeReves(refDet);
				}
			}
		}else if(sectionName.equalsIgnoreCase(ALOCConstants.PRINCIPAL)){
			if( requestDetails != null && requestDetails.getPrincipal() != null && requestDetails.getPrincipal().getRefDetails() != null){
				if(gereferenceFieldAddIndex < requestDetails.getPrincipal().getRefDetails().size()){
					List<RefDetails> refDet = requestDetails.getPrincipal().getRefDetails();
					for (int i=ALOCConstants.MIN_SIZE; i<requestDetails.getPrincipal().getRefDetails().size();i++) {
						if(gereferenceFieldAddIndex <= i){
							refDet.remove(i);
						}
					}
					requestDetails.getPrincipal().setRefDetails(refDet);
				}
			}
		}
	}

	/**
	 *This method is used to remove DLOC Additional Field dynamically 
	 */
	public void removeDLOCAdditionalField(RequestDetails requestDetails) {
		if(sectionName.equalsIgnoreCase(ALOCConstants.APPLICANT)){
			removeApplicantAdditionalField(requestDetails);
		}
		if(sectionName.equalsIgnoreCase(ALOCConstants.CUSTBENFICIARY)){
			removeCustBenAdditionalField(requestDetails);
		}
		if(sectionName.equalsIgnoreCase(ALOCConstants.SHIPMENTCOUNTRY)){
			removeShipmentAdditionalField(requestDetails);
		}
		if(sectionName.equalsIgnoreCase(ALOCConstants.ORIGINGOODS)){
			removeOriginAdditionalField(requestDetails);
		}
		if(sectionName.equalsIgnoreCase(ALOCConstants.BUCONTACTPERSON)){
			removeBupAdditionalField(requestDetails);
		}
	}

	/**
	 *This method is used to remove DLOC applicant Additional Field dynamically 
	 */
	public void removeApplicantAdditionalField(RequestDetails requestDetails) {
		if( requestDetails != null && requestDetails.getApplicantDetails() != null && requestDetails.getApplicantDetails().getRefDetails() != null){
			if(geregferenceFieldAddIndex < requestDetails.getApplicantDetails().getRefDetails().size()){
				List<RefDetails> refDet = requestDetails.getApplicantDetails().getRefDetails();
				for (int i=ALOCConstants.MIN_SIZE; i<requestDetails.getApplicantDetails().getRefDetails().size();i++) {
					if(geregferenceFieldAddIndex <= i){
						refDet.remove(i);
					}
				}
				requestDetails.getApplicantDetails().setRefDetails(refDet);
			}
		}
	}

	/**
	 *This method is used to remove DLOC customer/beneficiary Additional Field dynamically 
	 */
	public void removeCustBenAdditionalField(RequestDetails requestDetails) {
		if( requestDetails != null && requestDetails.getBeneficiaryDetails() != null && requestDetails.getBeneficiaryDetails().getRefDetails() != null){
			if(geBenificiaryFieldAddIndex < requestDetails.getBeneficiaryDetails().getRefDetails().size()){
				List<RefDetails> refDet = requestDetails.getBeneficiaryDetails().getRefDetails();
				for (int i=ALOCConstants.MIN_SIZE; i<requestDetails.getBeneficiaryDetails().getRefDetails().size();i++) {
					if(geBenificiaryFieldAddIndex <= i){
						refDet.remove(i);
					}
				}
				requestDetails.getBeneficiaryDetails().setRefDetails(refDet);
			}
		}
	}
	/**
	 *This method is used to remove DLOC shipment country Additional Field dynamically 
	 */
	public void removeShipmentAdditionalField(RequestDetails requestDetails) {
		if( requestDetails != null && requestDetails.getTransactionDetails() != null && requestDetails.getTransactionDetails().getShipmentOrigins() != null){
			if(shipOrgCtryFieldAddIndex < requestDetails.getTransactionDetails().getShipmentOrigins().size()){
				List<ShipmentOrigin> refDet = requestDetails.getTransactionDetails().getShipmentOrigins();
				for (int i=ALOCConstants.MIN_SIZE; i<requestDetails.getTransactionDetails().getShipmentOrigins().size();i++) {
					if(shipOrgCtryFieldAddIndex <= i){
						refDet.remove(i);
					}
				}
				requestDetails.getTransactionDetails().setShipmentOrigins(refDet);
			}
		}
	}
	/**
	 *This method is used to remove DLOC origin goods Additional Field dynamically 
	 */
	public void removeOriginAdditionalField(RequestDetails requestDetails) {
		if( requestDetails != null && requestDetails.getTransactionDetails() != null && requestDetails.getTransactionDetails().getGoodsOrigins() != null){
			if(originGoodsFieldAddIndex < requestDetails.getTransactionDetails().getGoodsOrigins().size()){
				List<GoodsOrigin> refDet = requestDetails.getTransactionDetails().getGoodsOrigins();
				for (int i=ALOCConstants.MIN_SIZE; i<requestDetails.getTransactionDetails().getGoodsOrigins().size();i++) {
					if(originGoodsFieldAddIndex <= i){
						refDet.remove(i);
					}
				}
				requestDetails.getTransactionDetails().setGoodsOrigins(refDet);
			}
		}
	}
	/**
	 *This method is used to remove DLOC business contact person lookup Additional Field dynamically 
	 */
	public void removeBupAdditionalField(RequestDetails requestDetails) {
		if( requestDetails != null && requestDetails.getBuContactPerson() != null && requestDetails.getBuContactPerson().getBuRequestors() != null){
			if(buContactPersonFieldAddIndex < requestDetails.getBuContactPerson().getBuRequestors().size()){
				List<BuRequestor> refDet = requestDetails.getBuContactPerson().getBuRequestors();
				for (int i=ALOCConstants.MIN_SIZE; i<requestDetails.getBuContactPerson().getBuRequestors().size();i++) {
					if(buContactPersonFieldAddIndex <= i){
						refDet.remove(i);
					}
				}
				requestDetails.getBuContactPerson().setBuRequestors(refDet);
			}
		}
	}

	/**
	 *This method is used to remove BG/SBLC Additional Field dynamically 
	 */
	public void removeBgSblcAdditionalField(RequestDetails requestDetails) {
		if(sectionName.equalsIgnoreCase(ALOCConstants.TPAPPLICANT)){
			if( requestDetails != null && requestDetails.getTransactionParties() != null && requestDetails.getTransactionParties().getTpApplicantDetails() != null && requestDetails.getTransactionParties().getTpApplicantDetails().getRefDetails() != null){
				if(bgGeReferenceFieldAddIndex < requestDetails.getTransactionParties().getTpApplicantDetails().getRefDetails().size()){
					List<RefDetails> refDet = requestDetails.getTransactionParties().getTpApplicantDetails().getRefDetails();
					for (int i=ALOCConstants.MIN_SIZE; i<requestDetails.getTransactionParties().getTpApplicantDetails().getRefDetails().size();i++) {
						if(bgGeReferenceFieldAddIndex <= i){
							refDet.remove(i);
						}
					}
					requestDetails.getTransactionParties().getTpApplicantDetails().setRefDetails(refDet);
				}
			}
		}else if(sectionName.equalsIgnoreCase(ALOCConstants.CUSTOMER)){
			if( requestDetails != null && requestDetails.getTransactionParties() != null && requestDetails.getTransactionParties().getCustomer() != null && requestDetails.getTransactionParties().getCustomer().getRefDetails() != null){
				if(customerFieldAddIndex < requestDetails.getTransactionParties().getCustomer().getRefDetails().size()){
					List<RefDetails> refDet = requestDetails.getTransactionParties().getCustomer().getRefDetails();
					for (int i=ALOCConstants.MIN_SIZE; i<requestDetails.getTransactionParties().getCustomer().getRefDetails().size();i++) {
						if(customerFieldAddIndex <= i){
							refDet.remove(i);
						}
					}
					requestDetails.getTransactionParties().getCustomer().setRefDetails(refDet);
				}
			}
		}
	}

	/**
	 * This method is used to get the selected Model Details
	 * @return
	 * @throws HWFServiceException
	 */
	@Override
	public String openModelRequest() throws HWFServiceException {
		editMode = true;
		super.openModelRequest();
		RequestDetails requestDetails = getRequestDetails();
		rightSelSites = ALOCCommonHelper.setSelSiteIds(requestDetails, rightSelSites);
		return getModelRequestResultPage();
	}

	/**
	 * This method is used to get selected Model details in read only mode
	 * @return
	 * @throws HWFServiceException
	 */
	public String displayModelRequest() throws HWFServiceException {
		editMode = false;
		super.openModelRequest();
		RequestDetails requestDetails = getRequestDetails();
		selectedSiteNames = ALOCCommonHelper.setSelSiteNames(requestDetails, selectedSiteNames);
		return getModelRequestResultPage();
	}

	/**
	 * This method is used to save the Modified Model details
	 * @return
	 * @throws HWFServiceException
	 */
	public String saveModel() throws HWFServiceException {
		return super.saveModel(rightSelSites);
	}

	/**
	 * This method is used to get the rightSelSites.
	 * @return the rightSelSites
	 */
	public List<String> getRightSelSites() {
		return rightSelSites;
	}

	/**
	 * This method is used to set the rightSelSites.
	 * @param rightSelSites 
	 */
	public void setRightSelSites(List<String> rightSelSites) {
		this.rightSelSites = rightSelSites;
	}

	/**
	 * This method is used to get the gereferenceFieldAddIndex.
	 * @return the gereferenceFieldAddIndex
	 */
	public int getGereferenceFieldAddIndex() {
		return gereferenceFieldAddIndex;
	}
	/**
	 * This method is used to set the gereferenceFieldAddIndex.
	 * @param gereferenceFieldAddIndex
	 */
	public void setGereferenceFieldAddIndex(int gereferenceFieldAddIndex) {
		this.gereferenceFieldAddIndex = gereferenceFieldAddIndex;
	}

	/**
	 * This method is used to get the gereferenceFieldRemoveIndex.
	 * @return the gereferenceFieldRemoveIndex
	 */
	public int getGereferenceFieldRemoveIndex() {
		return gereferenceFieldRemoveIndex;
	}
	/**
	 * This method is used to set the selectedInstrumentType.
	 * @param gereferenceFieldRemoveIndex
	 */
	public void setGereferenceFieldRemoveIndex(int gereferenceFieldRemoveIndex) {
		this.gereferenceFieldRemoveIndex = gereferenceFieldRemoveIndex;
	}
	/**
	 * This method is used to get the oblreferenceFieldRemoveIndex.
	 * @return the oblreferenceFieldRemoveIndex
	 */
	public int getOblreferenceFieldRemoveIndex() {
		return oblreferenceFieldRemoveIndex;
	}
	/**
	 * This method is used to set the oblreferenceFieldRemoveIndex.
	 * @param oblreferenceFieldRemoveIndex
	 */
	public void setOblreferenceFieldRemoveIndex(int oblreferenceFieldRemoveIndex) {
		this.oblreferenceFieldRemoveIndex = oblreferenceFieldRemoveIndex;
	}
	/**
	 * This method is used to get the oblreferenceFieldAddIndex.
	 * @return the oblreferenceFieldAddIndex
	 */
	public int getOblreferenceFieldAddIndex() {
		return oblreferenceFieldAddIndex;
	}
	/**
	 * This method is used to set the oblreferenceFieldAddIndex.
	 * @param oblreferenceFieldAddIndex
	 */
	public void setOblreferenceFieldAddIndex(int oblreferenceFieldAddIndex) {
		this.oblreferenceFieldAddIndex = oblreferenceFieldAddIndex;
	}
	/**
	 * This method is used to get the geregferenceFieldAddIndex.
	 * @return the geregferenceFieldAddIndex
	 */
	public int getGeregferenceFieldAddIndex() {
		return geregferenceFieldAddIndex;
	}

	/**
	 * This method is used to set the geregferenceFieldAddIndex.
	 * @param geregferenceFieldAddIndex
	 */
	public void setGeregferenceFieldAddIndex(int geregferenceFieldAddIndex) {
		this.geregferenceFieldAddIndex = geregferenceFieldAddIndex;
	}

	/**
	 * This method is used to get the geregferenceFieldRemoveIndex.
	 * @return the geregferenceFieldRemoveIndex
	 */
	public int getGeregferenceFieldRemoveIndex() {
		return geregferenceFieldRemoveIndex;
	}

	/**
	 * This method is used to set the geregferenceFieldRemoveIndex.
	 * @param geregferenceFieldRemoveIndex
	 */
	public void setGeregferenceFieldRemoveIndex(int geregferenceFieldRemoveIndex) {
		this.geregferenceFieldRemoveIndex = geregferenceFieldRemoveIndex;
	}

	/**
	 * This method is used to get the geBenificiaryFieldAddIndex .
	 * @return the geBenificiaryFieldAddIndex
	 */
	public int getGeBenificiaryFieldAddIndex() {
		return geBenificiaryFieldAddIndex;
	}

	/**
	 * This method is used to set the geBenificiaryFieldAddIndex.
	 * @param geBenificiaryFieldAddIndex
	 */
	public void setGeBenificiaryFieldAddIndex(int geBenificiaryFieldAddIndex) {
		this.geBenificiaryFieldAddIndex = geBenificiaryFieldAddIndex;
	}
	/**
	 * This method is used to get the geBenificiaryFieldRemoveIndex.
	 * @return the geBenificiaryFieldRemoveIndex
	 */

	public int getGeBenificiaryFieldRemoveIndex() {
		return geBenificiaryFieldRemoveIndex;
	}

	/**
	 * This method is used to set the geBenificiaryFieldRemoveIndex.
	 * @param geBenificiaryFieldRemoveIndex
	 */
	public void setGeBenificiaryFieldRemoveIndex(int geBenificiaryFieldRemoveIndex) {
		this.geBenificiaryFieldRemoveIndex = geBenificiaryFieldRemoveIndex;
	}

	/**
	 * This method is used to get the shipOrgCtryFieldAddIndex.
	 * @return the shipOrgCtryFieldAddIndex
	 */
	public int getShipOrgCtryFieldAddIndex() {
		return shipOrgCtryFieldAddIndex;
	}

	/**
	 * This method is used to set the shipOrgCtryFieldAddIndex.
	 * @param shipOrgCtryFieldAddIndex
	 */
	public void setShipOrgCtryFieldAddIndex(int shipOrgCtryFieldAddIndex) {
		this.shipOrgCtryFieldAddIndex = shipOrgCtryFieldAddIndex;
	}

	/**
	 * This method is used to get the shipOrgCtryFieldRemoveIndex.
	 * @return the shipOrgCtryFieldRemoveIndex
	 */
	public int getShipOrgCtryFieldRemoveIndex() {
		return shipOrgCtryFieldRemoveIndex;
	}

	/**
	 * This method is used to set the shipOrgCtryFieldRemoveIndex.
	 * @param shipOrgCtryFieldRemoveIndex
	 */
	public void setShipOrgCtryFieldRemoveIndex(int shipOrgCtryFieldRemoveIndex) {
		this.shipOrgCtryFieldRemoveIndex = shipOrgCtryFieldRemoveIndex;
	}

	/**
	 * This method is used to get the originGoodsFieldAddIndex.
	 * @return the originGoodsFieldAddIndex
	 */
	public int getOriginGoodsFieldAddIndex() {
		return originGoodsFieldAddIndex;
	}

	/**
	 * This method is used to set the originGoodsFieldAddIndex.
	 * @param originGoodsFieldAddIndex
	 */
	public void setOriginGoodsFieldAddIndex(int originGoodsFieldAddIndex) {
		this.originGoodsFieldAddIndex = originGoodsFieldAddIndex;
	}

	/**
	 * This method is used to get the originGoodsFieldRemoveIndex.
	 * @return the originGoodsFieldRemoveIndex
	 */
	public int getOriginGoodsFieldRemoveIndex() {
		return originGoodsFieldRemoveIndex;
	}

	/**
	 * This method is used to set the originGoodsFieldRemoveIndex.
	 * @param originGoodsFieldRemoveIndex
	 */
	public void setOriginGoodsFieldRemoveIndex(int originGoodsFieldRemoveIndex) {
		this.originGoodsFieldRemoveIndex = originGoodsFieldRemoveIndex;
	}

	/**
	 * This method is used to get the paymentsFieldAddIndex.
	 * @return the paymentsFieldAddIndex
	 */
	public int getPaymentsFieldAddIndex() {
		return paymentsFieldAddIndex;
	}

	/**
	 * This method is used to set the paymentsFieldAddIndex.
	 * @param paymentsFieldAddIndex
	 */
	public void setPaymentsFieldAddIndex(int paymentsFieldAddIndex) {
		this.paymentsFieldAddIndex = paymentsFieldAddIndex;
	}

	/**
	 * This method is used to get the paymentsFieldRemoveIndex.
	 * @return the paymentsFieldRemoveIndex
	 */
	public int getPaymentsFieldRemoveIndex() {
		return paymentsFieldRemoveIndex;
	}

	/**
	 * This method is used to set the paymentsFieldRemoveIndex.
	 * @param paymentsFieldRemoveIndex
	 */
	public void setPaymentsFieldRemoveIndex(int paymentsFieldRemoveIndex) {
		this.paymentsFieldRemoveIndex = paymentsFieldRemoveIndex;
	}

	/**
	 * This method is used to get the buContactPersonFieldAddIndex.
	 * @return the buContactPersonFieldAddIndex
	 */
	public int getBuContactPersonFieldAddIndex() {
		return buContactPersonFieldAddIndex;
	}

	/**
	 * This method is used to set the buContactPersonFieldAddIndex.
	 * @param buContactPersonFieldAddIndex
	 */
	public void setBuContactPersonFieldAddIndex(int buContactPersonFieldAddIndex) {
		this.buContactPersonFieldAddIndex = buContactPersonFieldAddIndex;
	}

	/**
	 * This method is used to get the buContactPersonFieldRemoveIndex.
	 * @return the buContactPersonFieldRemoveIndex
	 */
	public int getBuContactPersonFieldRemoveIndex() {
		return buContactPersonFieldRemoveIndex;
	}

	/**
	 * This method is used to set the buContactPersonFieldRemoveIndex.
	 * @param buContactPersonFieldRemoveIndex
	 */
	public void setBuContactPersonFieldRemoveIndex(
			int buContactPersonFieldRemoveIndex) {
		this.buContactPersonFieldRemoveIndex = buContactPersonFieldRemoveIndex;
	}

	/**
	 * This method is used to get the bgGeReferenceFieldAddIndex.
	 * @return the bgGeReferenceFieldAddIndex
	 */
	public int getBgGeReferenceFieldAddIndex() {
		return bgGeReferenceFieldAddIndex;
	}

	/**
	 * This method is used to set the bgGeReferenceFieldAddIndex.
	 * @param bgGeReferenceFieldAddIndex
	 */
	public void setBgGeReferenceFieldAddIndex(int bgGeReferenceFieldAddIndex) {
		this.bgGeReferenceFieldAddIndex = bgGeReferenceFieldAddIndex;
	}

	/**
	 * This method is used to get the bgGeReferenceFieldRemoveIndex.
	 * @return the bgGeReferenceFieldRemoveIndex
	 */
	public int getBgGeReferenceFieldRemoveIndex() {
		return bgGeReferenceFieldRemoveIndex;
	}

	/**
	 * This method is used to set the bgGeReferenceFieldRemoveIndex.
	 * @param bgGeReferenceFieldRemoveIndex
	 */
	public void setBgGeReferenceFieldRemoveIndex(int bgGeReferenceFieldRemoveIndex) {
		this.bgGeReferenceFieldRemoveIndex = bgGeReferenceFieldRemoveIndex;
	}

	/**
	 * This method is used to get the customerFieldRemoveIndex.
	 * @return the customerFieldRemoveIndex
	 */
	public int getCustomerFieldRemoveIndex() {
		return customerFieldRemoveIndex;
	}

	/**
	 * This method is used to set the customerFieldRemoveIndex.
	 * @param customerFieldRemoveIndex
	 */
	public void setCustomerFieldRemoveIndex(int customerFieldRemoveIndex) {
		this.customerFieldRemoveIndex = customerFieldRemoveIndex;
	}
	/**
	 * This method is used to get the customerFieldAddIndex.
	 * @return the customerFieldAddIndex
	 */
	public int getCustomerFieldAddIndex() {
		return customerFieldAddIndex;
	}
	/**
	 * This method is used to set the customerFieldAddIndex.
	 * @param customerFieldAddIndex
	 */
	public void setCustomerFieldAddIndex(int customerFieldAddIndex) {
		this.customerFieldAddIndex = customerFieldAddIndex;
	}

	/**
	 * This method decides the page to display on validation error conditions
	 */
	public String getInputResultName() {
		if(requestId != null){
			try {
				validateRequest();
			} catch (HWFServiceException e) {
				throw new ALOCRuntimeException(ALOCRuntimeException.EC_ACTIVEREQUEST_NOTFOUND);
			}
		}
		editMode = true;
		validationSuccess = false;
		String invokedMethod = ActionContext.getContext().getActionInvocation().getProxy().getMethod();	
		if(invokedMethod.equals(SUBMIT) || invokedMethod.equals(CREATEREQUEST) ){
			return getRequestResultPage();
		}else{
			return super.getInputResultName();
		}

	}	

	/**
	 * This method is used to get the actionType.
	 * @return the actionType
	 */
	public int getActionType() {
		return actionType.getId();
	}

	/**
	 * This method is used to set the actionType.
	 * @param actionType 
	 */
	public void setActionType(int actionTypeId) {
		actionType = ActionType.fromId(actionTypeId);
	}

	/**
	 * This method is used to get the selectedSiteNames.
	 * @return the selectedSiteNames
	 */
	public String getSelectedSiteNames() {
		return selectedSiteNames;
	}

	/**
	 * This method is used to set the selectedSiteNames.
	 * @param selectedSiteNames
	 */
	public void setSelectedSiteNames(String selectedSiteNames) {
		this.selectedSiteNames = selectedSiteNames;
	}

	/**
	 * This method is used to get the siteId.
	 * @return the siteId
	 */
	public String getSiteId() {
		return siteId;
	}

	/**
	 * This method is used to set the siteId.
	 * @param siteId
	 */
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	/**
	 * This method is used to get the landingPageReq.
	 * @return the landingPageReq
	 */
	public String getLandingPageReq() {
		return landingPageReq;
	}

	/**
	 * This method is used to set the landingPageReq.
	 * @param landingPageReq
	 */
	public void setLandingPageReq(String landingPageReq) {
		this.landingPageReq = landingPageReq;
	}

	/**
	 * This method is used to get the instrumentTypeId.
	 * @return the instrumentTypeId
	 */
	public String getInstrumentTypeId() {
		return instrumentTypeId;
	}

	/**
	 * This method is used to set the instrumentTypeId.
	 * @param instrumentTypeId
	 */
	public void setInstrumentTypeId(String instrumentTypeId) {
		this.instrumentTypeId = instrumentTypeId;
	}

	/**
	 * @return This method is used to get the sectionName
	 */
	public String getSectionName() {
		return sectionName;
	}

	/**
	 * @param This method is used to set the sectionName
	 */
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	/**
	 * @return the sncWorkingSection
	 */
	public String getSncWorkingSection() {
		return sncWorkingSection;
	}

	/**
	 * @param sncWorkingSection the sncWorkingSection to set
	 */
	public void setSncWorkingSection(String sncWorkingSection) {
		this.sncWorkingSection = sncWorkingSection;
	}

}	
