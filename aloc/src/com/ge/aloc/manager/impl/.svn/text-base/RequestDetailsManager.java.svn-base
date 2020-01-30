/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: RequestDetailsManager.java
 * Purpose: RequestDetailsManager used for the all request operations
 */
package com.ge.aloc.manager.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.ge.aloc.ALOCContext;
import com.ge.aloc.ActionType;
import com.ge.aloc.AttachmentType;
import com.ge.aloc.InstrumentType;
import com.ge.aloc.OpCode;
import com.ge.aloc.bo.AttachmentBO;
import com.ge.aloc.bo.RequestDetailsBO;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.dao.IRequestDetailsDAO;
import com.ge.aloc.exception.NoActiveRequestException;
import com.ge.aloc.manager.IRequestDetailsManager;
import com.ge.aloc.model.Attachment;
import com.ge.aloc.model.AvailableSites;
import com.ge.aloc.model.CurrentBankFees;
import com.ge.aloc.model.FeeHistoryDetails;
import com.ge.aloc.model.FeesDetails;
import com.ge.aloc.model.FeesDetails.SuretyNames;
import com.ge.aloc.model.GetAmendmentRiders;
import com.ge.aloc.model.ReferenceNumberValidation;
import com.ge.aloc.model.RequestDetails;
import com.ge.aloc.model.SelectedSites;
import com.ge.aloc.model.SuretyMaster;
import com.ge.aloc.model.SuretyMasterCollection;
import com.ge.aloc.model.UpdateReporting;
import com.ge.aloc.model.WFDetails;
import com.ge.aloc.util.ALOCCommonHelper;
import com.hydus.hwf.context.UserContext;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author chaitanya.n
 *
 */
public class RequestDetailsManager implements IRequestDetailsManager {

	protected IRequestDetailsDAO requestDetailsDAO;

	/**
	 * This method is used to sets a Active request
	 * @param requestDetails
	 */
	private static RequestDetailsBO setAsActiveRequest(RequestDetails requestDetails) {
		RequestDetailsBO requestDetailsBO = new RequestDetailsBO(requestDetails);
		ALOCContext.setActiveRequest(requestDetailsBO);
		return requestDetailsBO;
	}

	/**
	 * This method is used to create a request
	 * @throws HWFServiceException 
	 * @see com.ge.aloc.manager.IRequestDetailsManager#createRequest()
	 */
	public RequestDetailsBO createRequest(String instrumentType,String instrumentTypeName, String siteId, String siteName,BigInteger modelId) throws HWFServiceException {
		RequestDetails requestDetails = new RequestDetails();
		requestDetails.setInstrumentTypeId(new BigInteger(instrumentType));
		requestDetails.setInstrumentType(instrumentTypeName);
		requestDetails.setSiteId(new BigInteger(siteId));
		requestDetails.setSiteName(siteName);
		requestDetails.setModelId(modelId);
		requestDetails.setOpCode(OpCode.SAVE.getOperationCode());
		requestDetails = requestDetailsDAO.createNewRequest(requestDetails);		
		return setAsActiveRequest(requestDetails);
	}
	/**
	 * This method is used to  open a request
	 * @return RequestDetailsBO
	 */
	public RequestDetailsBO openRequest(InstrumentType instrumentType,BigInteger id, String amentmentId) throws HWFServiceException {
		RequestDetails requestDetails = getRequest(instrumentType,id, amentmentId);
		return setAsActiveRequest(requestDetails);
	}

	/**
	 * This method is used to create amendment request id
	 * @throws HWFServiceException 
	 * @see com.ge.aloc.manager.IRequestDetailsManager#createAmendmentRequestId(InstrumentType instrumentType, BigInteger bigInteger)
	 */
	public RequestDetailsBO createAmendmentRequestId(InstrumentType instrumentType,BigInteger bigInteger) throws HWFServiceException {
		RequestDetails amendmentRequestDetails = requestDetailsDAO.createAmendmentandRiderRequestId(instrumentType,bigInteger);
		if(amendmentRequestDetails.getAmendment().getAmendmentInstrumentAmountCurr().getCurrentInstrumentAmt()!=null){
			if(amendmentRequestDetails.getAmendment().getAmendmentInstrumentAmountCurr().getRevisedInstrumentAmt() == null){
				amendmentRequestDetails.getAmendment().getAmendmentInstrumentAmountCurr().setRevisedInstrumentAmt(amendmentRequestDetails.getAmendment().getAmendmentInstrumentAmountCurr().getCurrentInstrumentAmt());
			}
		}
		if(amendmentRequestDetails.getRequestSummary()!=null && amendmentRequestDetails.getRequestSummary().getRequestor()!=null && UserContext.getContext().getuserDetails()!=null){
			amendmentRequestDetails.getRequestSummary().getRequestor().setSsoId(UserContext.getContext().getuserDetails().getUserId());
			amendmentRequestDetails.getRequestSummary().getRequestor().setFirstName(UserContext.getContext().getuserDetails().getFirstName());
			amendmentRequestDetails.getRequestSummary().getRequestor().setLastName(UserContext.getContext().getuserDetails().getLastName());
			}
		return setAsActiveRequest(amendmentRequestDetails);
	}

	/**
	 * This method is used create surety riders request Id
	 * @throws HWFServiceException 
	 * @see com.ge.aloc.manager.IRequestDetailsManager#createSuretyRiderRequestId(InstrumentType,BigInteger)
	 */
	public RequestDetailsBO createSuretyRiderRequestId(InstrumentType instrumentType, BigInteger bigInteger) throws HWFServiceException {
		RequestDetails suretyRiderRequestDetails = requestDetailsDAO.createAmendmentandRiderRequestId(instrumentType,bigInteger);
		if(suretyRiderRequestDetails.getBondDetails().getBondTypeId()!=null && suretyRiderRequestDetails.getBondDetails().getBondTypeId().intValue()==ALOCConstants.CONTRACTBOND_ID){
			if(suretyRiderRequestDetails.getRider().getRiderBondInformation().getCurrentBondAmt()!=null && suretyRiderRequestDetails.getRider().getRiderBondInformation().getRevisedBondAmt() == null){
				suretyRiderRequestDetails.getRider().getRiderBondInformation().setRevisedBondAmt(suretyRiderRequestDetails.getRider().getRiderBondInformation().getCurrentBondAmt());
			}
			if(suretyRiderRequestDetails.getRider().getRiderBondInformation().getRevisedContractAmt() == null && suretyRiderRequestDetails.getRider().getRiderBondInformation().getOriginalContractAmt()!=null){
				suretyRiderRequestDetails.getRider().getRiderBondInformation().setRevisedContractAmt(suretyRiderRequestDetails.getRider().getRiderBondInformation().getOriginalContractAmt());
			}
		}else if(suretyRiderRequestDetails.getRider().getRiderBondInformation().getRevisedBondAmt() == null && suretyRiderRequestDetails.getRider().getRiderBondInformation().getCurrentBondAmt()!=null){
			suretyRiderRequestDetails.getRider().getRiderBondInformation().setRevisedBondAmt(suretyRiderRequestDetails.getRider().getRiderBondInformation().getCurrentBondAmt());
		}
		if(suretyRiderRequestDetails.getRequestSummary()!=null && suretyRiderRequestDetails.getRequestSummary().getRequestor()!=null && UserContext.getContext().getuserDetails()!=null){
			suretyRiderRequestDetails.getRequestSummary().getRequestor().setSsoId(UserContext.getContext().getuserDetails().getUserId());
			suretyRiderRequestDetails.getRequestSummary().getRequestor().setFirstName(UserContext.getContext().getuserDetails().getFirstName());
			suretyRiderRequestDetails.getRequestSummary().getRequestor().setLastName(UserContext.getContext().getuserDetails().getLastName());
			}
		return setAsActiveRequest(suretyRiderRequestDetails);

	}

	/**
	 * This method is used to get a request
	 * @return RequestDetails
	 * @throws HWFServiceException 
	 * @see com.ge.aloc.manager.IRequestDetailsManager#getRequest(java.lang.Integer)
	 */
	public RequestDetails getRequest(BigInteger id) throws HWFServiceException {
		return getRequest(null, id, null);
	}

	/**
	 * This method used for open a request
	 * @throws HWFServiceException 
	 * @see com.ge.aloc.manager.IRequestDetailsManager#openRequest(java.lang.Integer)
	 */
	public RequestDetailsBO openRequest(BigInteger id) throws HWFServiceException {
		RequestDetails requestDetails = getRequest(id);
		if(requestDetails.getInstrumentTypeId()!=null && InstrumentType.SURETY_BOND.getId()==requestDetails.getInstrumentTypeId().intValue()){
			if(requestDetails.getBondReqDtls()!=null && requestDetails.getAddressDtls()!=null){
				ALOCCommonHelper.setAddressDetails(requestDetails);
			}
		}
		return setAsActiveRequest(requestDetails);
	}

	/**
	 * This is used to open the Bid Award request upon clicking on the selected bank reply.
	 * @param requestId
	 * @param bidReplyId
	 * @return
	 * @throws HWFServiceException
	 */
	public RequestDetailsBO openBidAwardRequest(BigInteger requestId,BigInteger bidReplyId) throws HWFServiceException {
		RequestDetails requestDetails = new RequestDetails();
		requestDetails.setRequestId(requestId);
		requestDetails.setBidReplyID(bidReplyId);
		requestDetails = requestDetailsDAO.openBidAwardRequest(requestDetails);
		return setAsActiveRequest(requestDetails);
	}
	
	/**
	 * This is used to open the Bid Reply request upon clicking on the selected bank reply.
	 * @param requestId
	 * @param bidReplyId
	 * @return
	 * @throws HWFServiceException
	 */
	public RequestDetailsBO openBidReplyRequest(BigInteger requestId,BigInteger bankBidId) throws HWFServiceException {
		RequestDetails requestDetails = new RequestDetails();
		requestDetails.setRequestId(requestId);
		requestDetails.setBANKBIDID(bankBidId);
		requestDetails = requestDetailsDAO.openBidAwardRequest(requestDetails);
		return setAsActiveRequest(requestDetails);
	}

	/**
	 * This method is used for get request
	 * @return RequestDetails
	 */
	public RequestDetails getRequest(InstrumentType instrumentType,BigInteger id, String amendmentId) throws HWFServiceException {
		RequestDetails requestDetails = requestDetailsDAO.getRequest(instrumentType,id, amendmentId);
		return requestDetails;
	}

	/**
	 * This method is used to save and submit
	 * @see com.ge.aloc.manager.IRequestDetailsManager#saveandSubmit(actionType)
	 */
	public RequestDetails saveandSubmit(ActionType actionType) throws HWFServiceException {
		RequestDetails requestDetails = getActiveRequestDetails();
		if(requestDetails.getInstrumentTypeId()!=null && InstrumentType.SURETY_BOND.getId() == requestDetails.getInstrumentTypeId().intValue()){
			if(requestDetails.getBondReqDtls()!=null && requestDetails.getAddressDtls()!=null){
				requestDetails = ALOCCommonHelper.setBondReqDtls(requestDetails);
			}
		}
		requestDetails = requestDetailsDAO.saveandSubmit(requestDetails, actionType);
		return requestDetails;
	}

	/**
	 * This method is used to submit the Amendment
	 * @see com.ge.aloc.manager.IRequestDetailsManager#submitAmendment(actionType)
	 */
	public RequestDetails submitAmendment(ActionType actionType) throws HWFServiceException {
		return requestDetailsDAO.submitAmendment(getActiveRequestDetails(), actionType);

	}

	/**
	 * This method is used to submit the rider
	 * @see com.ge.aloc.manager.IRequestDetailsManager#submitRider(actionType)
	 */
	public  RequestDetails submitRider(ActionType actionType) throws HWFServiceException {
		return requestDetailsDAO.submitRider(getActiveRequestDetails(), actionType);
	}

	/**
	 * This method is for save and approve
	 * @see com.ge.aloc.manager.IRequestDetailsManager#saveandSubmit(actionType)
	 */
	public RequestDetails saveandApprove(ActionType actionType) throws HWFServiceException {
		RequestDetails requestDetails = getActiveRequestDetails();
		if(actionType==ActionType.BANK_AGREES_TO_CONFIRMATION){
			List<AttachmentBO> attachmentBOList = getActiveRequestDetailsBO().getAttachmentBOList();
			int atmtCnt = ALOCConstants.BASE_VALUE;
			for(AttachmentBO atmtBO : attachmentBOList) {
				requestDetails.getAttachments().get(atmtCnt).setIssuanceBankRefNo(atmtBO.getIssuanceBankRefNo());
				requestDetails.getAttachments().get(atmtCnt).setIssuanceDate(atmtBO.getIssuanceDate());
				requestDetails.getAttachments().get(atmtCnt).setIssuanceDesc(atmtBO.getIssuanceDesc());	
				requestDetails.getAttachments().get(atmtCnt).setIssuanceDocTypeId(StringUtils.isNotBlank(atmtBO.getIssuanceBankRefNo())?new BigInteger(atmtBO.getIssuanceDocType()):null);
				requestDetails.getAttachments().get(atmtCnt).setIssuanceDocument(atmtBO.getIssuanceDocument());
				atmtCnt++;
			}
		}
		if(actionType==ActionType.COMPLETE_TRANSACTION){
			List<AttachmentBO> attachmentBOList = getActiveRequestDetailsBO().getAttachmentBOList();
			int atmtCnt = ALOCConstants.BASE_VALUE;
			for(AttachmentBO atmtBO : attachmentBOList) {
				requestDetails.getAttachments().get(atmtCnt).setIssuanceDesc(atmtBO.getIssuanceDesc());	
				requestDetails.getAttachments().get(atmtCnt).setIssuanceDocument(atmtBO.getIssuanceDocument());
				atmtCnt++;
			}
		}
		if(requestDetails.getInstrumentTypeId() != null && InstrumentType.RIDER.getId()==requestDetails.getInstrumentTypeId().intValue()){
			if(requestDetails.getRider() != null && requestDetails.getRider().getRiderBondInformation() !=null && requestDetails.getRider().getRiderBondInformation().getValidationUsdAmount()!=null){
				requestDetails.getRider().getRiderBondInformation().setValidationUsdAmount(null);
			}
		}
		requestDetails = requestDetailsDAO.saveandApprove(requestDetails, actionType);
		if(requestDetails.getRequestId()!=null && requestDetails.getInstrumentTypeId()!=null && InstrumentType.SURETY_BOND.getId()==requestDetails.getInstrumentTypeId().intValue()){
			if(requestDetails.getBondReqDtls()!=null && requestDetails.getAddressDtls()!=null){
				ALOCCommonHelper.setAddressDetails(requestDetails);
			}
		}
		setAsActiveRequest(requestDetails);
		return requestDetails;

	}

	/**
	 * Method to save issuance data at taxonomy level
	 * @see com.ge.aloc.manager.IRequestDetailsManager#issuanceSave(actionType)
	 */
	public RequestDetails issuanceSave(ActionType actionType) throws HWFServiceException {
		RequestDetails requestDetails = getActiveRequestDetails();
		List<AttachmentBO> attachmentBOList = getActiveRequestDetailsBO().getAttachmentBOList();
		int atmtCnt = ALOCConstants.BASE_VALUE;
		for(AttachmentBO atmtBO : attachmentBOList) {
			requestDetails.getAttachments().get(atmtCnt).setIssuanceBankRefNo(atmtBO.getIssuanceBankRefNo());
			requestDetails.getAttachments().get(atmtCnt).setIssuanceDate(atmtBO.getIssuanceDate());
			requestDetails.getAttachments().get(atmtCnt).setIssuanceDesc(atmtBO.getIssuanceDesc());	
			requestDetails.getAttachments().get(atmtCnt).setIssuanceDocTypeId(atmtBO.getIssuanceDocType()!=null?new BigInteger(atmtBO.getIssuanceDocType()):null);
			requestDetails.getAttachments().get(atmtCnt).setIssuanceDocument(atmtBO.getIssuanceDocument());
			atmtCnt++;
		}
		requestDetails = requestDetailsDAO.issuanceSave(requestDetails, actionType);
		setAsActiveRequest(requestDetails);
		return requestDetails;

	}
	
	/**
	 * This method is used to update the Taxonomy
	 * Method to update Taxonomy Transaction Parties fields
	 * @throws HWFServiceException
	 */
	public RequestDetails updateTaxonomy() throws HWFServiceException {
		RequestDetails requestDetails = getActiveRequestDetails();
		requestDetails = requestDetailsDAO.updateTaxonomy(requestDetails);
		return requestDetails;
	}
	
	/**
	 * This method is used to get the Taxonomy ReportingData
	 * @param requestId
	 * @throws HWFServiceException
	 */
	public UpdateReporting getReportingData(BigInteger requestId) throws HWFServiceException {
		UpdateReporting updateReporting = new UpdateReporting();
		updateReporting.setAlocRequestId(requestId);
		updateReporting = requestDetailsDAO.getReportingData(updateReporting);
		return updateReporting;
	}
	
	/**
	 * This method is used to update the Taxonomy ReportingData
	 * @param updateReporting
	 * @throws HWFServiceException
	 */
	public UpdateReporting updateReportingData(UpdateReporting updateReporting) throws HWFServiceException {
		
		updateReporting = requestDetailsDAO.updateReportingData(updateReporting);
		return updateReporting;
	}

	/**
	 * This method is used to open a model request
	 * @throws HWFServiceException 
	 * @see com.ge.aloc.manager.IRequestDetailsManager#openModelRequest(java.lang.String)
	 */
	public RequestDetailsBO openModelRequest(String requestId) throws HWFServiceException {

		RequestDetails requestDetails = requestDetailsDAO.openModelRequest(requestId);
		List<SelectedSites> selSiteSelections = requestDetails.getSiteSelection().getSelectedSites();
		if(selSiteSelections == null || selSiteSelections.size() == ALOCConstants.MIN_SIZE)
		{
			selSiteSelections = new ArrayList<SelectedSites>();
			SelectedSites selectedSite = new SelectedSites();
			selectedSite.setSiteId(requestDetails.getSiteId().intValue());
			selectedSite.setSiteName(requestDetails.getSiteName());
			selSiteSelections.add(selectedSite);
			requestDetails.getSiteSelection().setSelectedSites(selSiteSelections);

			List<AvailableSites> availableSitesList = requestDetails.getSiteSelection().getAvailableSites();
			List<AvailableSites> newAvailableSitesList = new ArrayList<AvailableSites>();
			for(AvailableSites availableSite : availableSitesList)
			{
				if(availableSite.getSiteId() != requestDetails.getSiteId().intValue())
				{
					newAvailableSitesList.add(availableSite);
				}
			}
			requestDetails.getSiteSelection().setAvailableSites(newAvailableSitesList);
		}
		if(requestDetails.getInstrumentTypeId()!=null && InstrumentType.SURETY_BOND.getId()==requestDetails.getInstrumentTypeId().intValue()){
			if(requestDetails.getBondReqDtls()!=null && requestDetails.getAddressDtls()!=null){
				requestDetails = ALOCCommonHelper.setAddressDetails(requestDetails);
			}
		}
		return setAsActiveRequest(requestDetails);
	}

	/**
	 * This method is used to save model
	 * @throws HWFServiceException 
	 * @see com.ge.aloc.manager.IRequestDetailsManager#saveModel(com.ge.aloc.model.RequestDetails)
	 */
	public RequestDetails saveModel(List<String> rightSelSites) throws HWFServiceException {

		RequestDetails requestDetails = getActiveRequestDetails();
		requestDetails = ALOCCommonHelper.setSiteSelectionDetails(requestDetails, rightSelSites);
		if(requestDetails.getInstrumentTypeId()!=null && InstrumentType.SURETY_BOND.getId() == requestDetails.getInstrumentTypeId().intValue()){
			if(requestDetails.getBondReqDtls()!=null && requestDetails.getAddressDtls()!=null){
				requestDetails = ALOCCommonHelper.setBondReqDtls(requestDetails);
			}
		}
		return requestDetailsDAO.saveModel(requestDetails);
	}

	/**
	 * Method to retrieve the Surety Company Names List
	 * @throws HWFServiceException
	 */
	public RequestDetailsBO getActiveSuretyMasterList(RequestDetailsBO requestDetailsBO) throws HWFServiceException {
		SuretyMaster suretyMaster = new SuretyMaster();
		SuretyMasterCollection suretyMasterCollection = requestDetailsDAO.getActiveSuretyMasterList(suretyMaster);
		List<SuretyMaster> suretyMasters = suretyMasterCollection.getSuretyMasters();
		List<SuretyNames> newSuretyNames = new ArrayList<SuretyNames>();
		SuretyNames suretyNames = new SuretyNames();
		for(SuretyMaster suretyMaster2 : suretyMasters)
		{
			suretyNames = new SuretyNames();
			suretyNames.setSuretyId(suretyMaster2.getSuretyId().toString());
			suretyNames.setSuretyName(suretyMaster2.getSuretyName());
			newSuretyNames.add(suretyNames);
		}
		RequestDetails requestDetails = requestDetailsBO.getModel();
		if(requestDetailsBO.getModel().getFeesDetails() == null)
			requestDetails.setFeesDetails(new FeesDetails());
		requestDetails.getFeesDetails().setSuretyNames(newSuretyNames);
		return requestDetailsBO;
	}
	
	/**
	 * This is used to select the winner for Bid award
	 * @param actionType
	 * @param requestId
	 * @param bidReplyId
	 * @param transmissionPlatform
	 * @param procedureName
	 * @param workFlowstageId
	 * @param queueName
	 * @param stageName
	 * @param wfid
	 * @param swiftData
	 * @throws HWFServiceException
	 */
	public RequestDetails selectWinnerForBidAward(ActionType actionType,
			BigInteger requestId, BigInteger bidReplyId,
			String transmissionPlatform, String wfid, String stageName,
			String queueName, String procedureName, String workFlowstageId, String selBidWinnerType,String sitePrefix,String swiftData)
			throws HWFServiceException {
		RequestDetails requestDetails = null;
		if(ALOCConstants.SELWINNER_FROMREQUEST.equalsIgnoreCase(selBidWinnerType))
		{
			requestDetails=getActiveRequestDetails();
		}
		else
		{
			requestDetails = new RequestDetails();
			requestDetails.setSitePrefix(sitePrefix);
		}
		
		requestDetails.setRequestId(requestId);
		requestDetails.setBidReplyID(bidReplyId);
		if(StringUtils.isNotEmpty(transmissionPlatform)){
			requestDetails.setTransmissionPlatform(transmissionPlatform);
		}
		requestDetails.setSwiftFormatDoc(swiftData);
		WFDetails wfDetails=new WFDetails();
		wfDetails.setWFID(wfid);
		wfDetails.setWFStage(stageName);
		wfDetails.setProcedureName(procedureName);
		wfDetails.setQueueName(queueName);
		if(StringUtils.isNotEmpty(workFlowstageId)){
			wfDetails.setWFStageID(new BigInteger(workFlowstageId));
		}	
		requestDetails.setWFDetails(wfDetails);
		requestDetails=requestDetailsDAO.awardSubmit(requestDetails,actionType);
		return requestDetails;
	}

	/**
	 * Method to save Attachment
	 * @throws HWFServiceException
	 */
	public RequestDetails saveAttachments(AttachmentType type,Attachment attachment) throws HWFServiceException {
		if(type == AttachmentType.ISSUER){
			return requestDetailsDAO.saveAttachments(getActiveRequestDetails(),type,attachment);
		}else{
			return requestDetailsDAO.saveAttachments(getActiveRequestDetails(),type,null);
		}
	}
	
	/**
	 * Method to save FormatData with Swift changes
	 * @param requestDetails
	 * @throws HWFServiceException
	 */
	public RequestDetails saveFormatSwiftData(RequestDetails requestDetails) throws HWFServiceException {					
		return requestDetailsDAO.saveFormatSwiftData(requestDetails);
	}


	/**
	 *  Method to delete Attachment
	 */
	public RequestDetails deleteAttachments(Attachment atmt, AttachmentType type)
			throws HWFServiceException {
		return requestDetailsDAO.deleteAttachments(getActiveRequestDetails(),atmt,type);
	}

	/**
	 * Method to get the amendment details for the taxonomy
	 * @throws HWFServiceException
	 * @param id 
	 * @see com.ge.aloc.manager.IRequestDetailsManager#getAmendments()
	 */
	public GetAmendmentRiders getAmendments(BigInteger id) throws HWFServiceException {
		return requestDetailsDAO.getAmendments(id);
	}

	/**
	 * Method to get the Rider details for the taxonomy
	 * @throws HWFServiceException
	 * @param id 
	 * @see com.ge.aloc.manager.IRequestDetailsManager#getRiders()
	 */
	public GetAmendmentRiders getRiders(BigInteger id) throws HWFServiceException {
		return requestDetailsDAO.getRiders(id);
	}

	/**
	 * Method to get the Fee History details for the Taxonomy
	 * @throws HWFServiceException
	 * @param id 
	 * @see com.ge.aloc.manager.IRequestDetailsManager#getFeeHistory()
	 */
	public FeeHistoryDetails getFeeHistory(BigInteger id) throws HWFServiceException {
		return requestDetailsDAO.getFeeHistory(id);
	}
	
	/**
	 * Method to get the competing bidReply details for the Taxonomy
	 * @throws HWFServiceException
	 * @param id 
	 * @see com.ge.aloc.manager.IRequestDetailsManager#getFeeHistory()
	 */
	public CurrentBankFees getCompBidReplies(BigInteger id) throws HWFServiceException {
		return requestDetailsDAO.getCompBidReplies(id);
	}
	
	/**
	 * Method to get the Current bank fees details for the Taxonomy
	 * @throws HWFServiceException
	 * @param id 
	 * @see com.ge.aloc.manager.IRequestDetailsManager#getFeeHistory()
	 */
	public CurrentBankFees getCurrBankFees(BigInteger id) throws HWFServiceException {
		CurrentBankFees currentBankFees = requestDetailsDAO.getCurrBankFees(id);
		if(currentBankFees !=null && currentBankFees.getCumulativeFeeAdjustments()!= null){
			ALOCCommonHelper.removeBigDecimalZeroValues(currentBankFees.getCumulativeFeeAdjustments());
		}
		return currentBankFees;
	}
	
	/**
	 * Method to get the Save Current bank fees details for the Taxonomy
	 * @throws HWFServiceException
	 * @param id 
	 * @see com.ge.aloc.manager.IRequestDetailsManager#getFeeHistory()
	 */
	public CurrentBankFees saveCurrBankFees(CurrentBankFees curBankFees) throws HWFServiceException {
		return requestDetailsDAO.saveCurrBankFees(curBankFees);
	}
	
	/**
	 * Method to get the Bank Reference Number valid or not at Issuance page.
	 * @throws HWFServiceException
	 * @param id 
	 * @see com.ge.aloc.manager.IRequestDetailsManager#getFeeHistory()
	 */
	public ReferenceNumberValidation checkBankRefNumber(ReferenceNumberValidation referenceNumberValidation) throws HWFServiceException {
		return requestDetailsDAO.checkBankRefNumber(referenceNumberValidation);
	}
	
	/**
	 * This method is used to get RequestDetailsDAO
	 * @return IRequestDetailsDAO
	 */
	public IRequestDetailsDAO getRequestDetailsDAO() {
		return requestDetailsDAO;
	}

	/**
	 * This method is used to set request Details DAO
	 * @param requestDetailsDAO
	 */
	public void setRequestDetailsDAO(IRequestDetailsDAO requestDetailsDAO) {
		this.requestDetailsDAO = requestDetailsDAO;
	}


	/**
	 * This method is used to get Active Request Details 
	 * @return RequestDetailsBO
	 */
	private RequestDetailsBO getActiveRequestDetailsBO() {
		RequestDetailsBO requestDetailsBO = ALOCContext.getActiveRequest();
		if(requestDetailsBO == null) {
			throw new NoActiveRequestException();
		}
		return requestDetailsBO;
	}

	/**
	 * This method is used to get Active request Details
	 * @return RequestDetails
	 */
	private RequestDetails getActiveRequestDetails() {
		return getActiveRequestDetailsBO().getModel();
	}
}
