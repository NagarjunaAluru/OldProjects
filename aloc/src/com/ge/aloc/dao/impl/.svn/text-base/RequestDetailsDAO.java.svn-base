/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: RequestDetailsDAO.java
 * Purpose: RequestDetailsDAO used for the all the request DAO Implementations
 */
package com.ge.aloc.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.ge.aloc.ActionType;
import com.ge.aloc.AttachmentType;
import com.ge.aloc.FormatType;
import com.ge.aloc.InstrumentType;
import com.ge.aloc.OpCode;
import com.ge.aloc.ServiceClientSupport;
import com.ge.aloc.UserRole;
import com.ge.aloc.WorkflowStage;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.dao.IRequestDetailsDAO;
import com.ge.aloc.model.APMDetails;
import com.ge.aloc.model.ActionDetails;
import com.ge.aloc.model.Amendment;
import com.ge.aloc.model.Attachment;
import com.ge.aloc.model.AttachmentPermission;
import com.ge.aloc.model.CurrentBankFees;
import com.ge.aloc.model.FeeHistoryDetails;
import com.ge.aloc.model.FullSummary;
import com.ge.aloc.model.GetAmendmentRiders;
import com.ge.aloc.model.MsgHeader;
import com.ge.aloc.model.ReferenceNumberValidation;
import com.ge.aloc.model.RequestDetails;
import com.ge.aloc.model.Rider;
import com.ge.aloc.model.SuretyMaster;
import com.ge.aloc.model.SuretyMasterCollection;
import com.ge.aloc.model.UpdateReporting;
import com.ge.aloc.util.ALOCCommonHelper;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author chaitanya.n
 *
 */
public class RequestDetailsDAO extends ServiceClientSupport implements IRequestDetailsDAO {

	/**
	 * This method performs the section operation
	 * @throws HWFServiceException
	 * @see IRequestDetailsDAO#performSectionOperation(RequestDetails, OpCode)
	 */
	public void performSectionOperation(RequestDetails requestDetails,
			OpCode sectionOperation) throws HWFServiceException {

		ALOCCommonHelper.setMsgHeader(requestDetails, OpCode.CREATEREQUEST);
		requestDetails.getProjDescription().setOpCode(
				sectionOperation.getOperationCode());
		requestDetails = serviceClient.invokeService(
				OpCode.REQUESTDETAILS.getOperationCode(), requestDetails,
				RequestDetails.class);

	}

	/**
	 * This method is used for creating a new request
	 * @param requestDetails
	 * @param Operation
	 * @return RequestDetails
	 * @throws HWFServiceException
	 */
	public RequestDetails createNewRequest(RequestDetails requestDetails) throws HWFServiceException {
		ALOCCommonHelper.setMsgHeader(requestDetails, OpCode.CREATEREQUEST);
		requestDetails = serviceClient.invokeService(OpCode.REQUESTDETAILS.getOperationCode(), requestDetails, RequestDetails.class);
		return requestDetails;
	}

	/**
	 * This method is used for creating Amendment and rider request id
	 * @param bigInteger
	 *  @return RequestDetails
	 */
	public RequestDetails createAmendmentandRiderRequestId(InstrumentType instrumentType,BigInteger bigInteger) throws HWFServiceException{
		RequestDetails requestDetails = new RequestDetails();
		requestDetails.setInstrumentTypeId(BigInteger.valueOf(instrumentType.getId()));
		requestDetails.setInstrumentType(instrumentType.getName());
		requestDetails.setRequestId(bigInteger);
		if(InstrumentType.AMENDMENT.equals(instrumentType)){
			Amendment amendment = new Amendment();
			amendment.setRequestId(bigInteger);
			requestDetails.setAmendment(amendment);
		}else if(InstrumentType.RIDER.equals(instrumentType)){
			Rider rider= new Rider();
			rider.setRequestId(bigInteger);
			requestDetails.setRider(rider);
		}

		ALOCCommonHelper.setMsgHeader(requestDetails, OpCode.GETREQID);
		requestDetails = serviceClient.invokeService(OpCode.REQUESTDETAILS.getOperationCode(), requestDetails, RequestDetails.class);
		return (requestDetails!=null) ? requestDetails : null;
	}


	/**
	 * This method is for get the request
	 * @param instrumentType
	 * @param bigInteger
	 * @param amendmentId
	 * @return RequestDetails
	 * @throws HWFServiceException
	 */
	public RequestDetails getRequest(InstrumentType instrumentType, BigInteger id, String amendmentId) throws HWFServiceException {
		RequestDetails requestDetails = new RequestDetails();
		requestDetails.setRequestId(id);
		if(InstrumentType.AMENDMENT.equals(instrumentType) && !StringUtils.isBlank(amendmentId)){
			Amendment amendment = new Amendment();
			amendment.setAmendmentRequestId(amendmentId);
			requestDetails.setAmendment(amendment);
		}else if(InstrumentType.RIDER.equals(instrumentType) && !StringUtils.isBlank(amendmentId)){
			Rider rider= new Rider();
			rider.setRiderRequestId(amendmentId);
			requestDetails.setRider(rider);
		}
		ALOCCommonHelper.setMsgHeader(requestDetails, OpCode.GETREQUEST);
		requestDetails = serviceClient.invokeService(OpCode.REQUESTDETAILS.getOperationCode(), requestDetails, RequestDetails.class);
		return (requestDetails!=null) ? requestDetails : null;
	}

	/**
	 * This method is used for get current request
	 * @param bigInteger
	 * @return RequestDetails
	 * @throws HWFServiceException
	 */
	public RequestDetails getRequest(BigInteger id) throws HWFServiceException {
		return getRequest(null,id, null);
	}


	/**
	 * This method is used  to  submit the Amendment
	 * @param requestDetails
	 */
	public RequestDetails submitAmendment(RequestDetails requestDetails,
			ActionType actionType) throws HWFServiceException {

		if (requestDetails.getAmendment().getActionDetails() == null) {
			ActionDetails acdetails = new ActionDetails();
			acdetails.setActionId(String.valueOf(actionType.getId()));
			acdetails.setActionName(actionType.getName());
			requestDetails.getAmendment().setActionDetails(acdetails);


		} else {
			requestDetails.getAmendment().getActionDetails().setActionId(
					String.valueOf(actionType.getId()));
			requestDetails.getAmendment().getActionDetails().setActionName(
					actionType.getName());
		}
		requestDetails.getAmendment().setOpCode(actionType.getName());
		requestDetails.setActionLogs(null);
		requestDetails.setAuditLogs(null);
		if(actionType.equals(ActionType.DELETE_AMENDMENT)){
			ALOCCommonHelper.setMsgHeader(requestDetails, OpCode.DELETEAMDMENT);
		}else{
			ALOCCommonHelper.setMsgHeader(requestDetails, OpCode.CREATEREQUEST);
		}
		

		requestDetails = serviceClient.invokeService(
				OpCode.REQUESTDETAILS.getOperationCode(), requestDetails,
				RequestDetails.class);
		return requestDetails;
	}

	/**
	 * This method is used to submit the rider
	 * @param requestDetails
	 */
	public RequestDetails submitRider(RequestDetails requestDetails,
			ActionType actionType) throws HWFServiceException {

		if (requestDetails.getRider().getActionDetails() == null) {
			ActionDetails acdetails = new ActionDetails();
			acdetails.setActionId(String.valueOf(actionType.getId()));
			acdetails.setActionName(actionType.getName());
			requestDetails.getRider().setActionDetails(acdetails);


		} else {
			requestDetails.getRider().getActionDetails().setActionId(
					String.valueOf(actionType.getId()));
			requestDetails.getRider().getActionDetails().setActionName(
					actionType.getName());
		}
		requestDetails.setActionLogs(null);
		requestDetails.setAuditLogs(null);
		requestDetails.getRider().setOpCode(actionType.getName());
		ALOCCommonHelper.setMsgHeader(requestDetails, OpCode.CREATEREQUEST);
		requestDetails = serviceClient.invokeService(
				OpCode.REQUESTDETAILS.getOperationCode(), requestDetails,
				RequestDetails.class);
		return requestDetails;
	}



	/**
	 * This method is used for save and Submit 
	 * @param requestDetails
	 */
	public RequestDetails saveandSubmit(RequestDetails requestDetails,
			ActionType actionType) throws HWFServiceException {

		ALOCCommonHelper.setOpCode(requestDetails, actionType);
		ALOCCommonHelper.setMsgHeader(requestDetails, OpCode.CREATEREQUEST);
		
		if((ActionType.SAVE_AS_MODEL).equals(actionType)){
			requestDetails.setSaveAsModel(OpCode.SAVE.getOperationCode());
		}
		if (requestDetails.getAttachments() != null && requestDetails.getAttachments().size() > ALOCConstants.BASE_VALUE) {//sync the file permissions for Attachments
			for (Attachment attachment :requestDetails.getAttachments()){	
				if(attachment.getAttachmentId()!=null) {
					attachment.setActionType(OpCode.UPDATE.getOperationCode()); }
				else if(StringUtils.isNotBlank(attachment.getGeFileId())){
					attachment.setActionType(OpCode.INSERT.getOperationCode());	}
				attachment.setOpCode(OpCode.SAVE.getOperationCode());	
			}
		}
		//This code is fix for draft version 
		if((StringUtils.isBlank(requestDetails.getFormat().getFormatType()) && StringUtils.isBlank(requestDetails.getFormat().getFormatTypeId()) && requestDetails.getFormat().getAttachments()!=null) ||
				StringUtils.isNotBlank(requestDetails.getFormat().getFormatType()) && requestDetails.getFormat().getFormatTypeId() == ALOCConstants.NON_STANDARD_FORMAT && requestDetails.getFormat().getAttachments()!=null||
				!(requestDetails.getFormat().getAttachments().get(ALOCConstants.BASE_VALUE).getAttachmentId() != null)){
			requestDetails.getFormat().getAttachments().get(ALOCConstants.BASE_VALUE).setAttachmentPermissions(null);	
		}
		if (StringUtils.isNotBlank(requestDetails.getFormat().getFormatTypeId()) && requestDetails.getFormat().getAttachments() != null) { //sync the file permissions for format
			if(requestDetails.getFormat().getAttachments().size()>ALOCConstants.BASE_VALUE){
				String formatTypeId = requestDetails.getFormat().getFormatTypeId();
				for (Attachment attachment :requestDetails.getFormat().getAttachments()){
					if(Integer.valueOf(formatTypeId).intValue() == FormatType.NON_STANDARD.getId() && attachment.getAttachmentId()!=null){
						attachment.setActionType(OpCode.UPDATE.getOperationCode());
					}else if(StringUtils.isNotBlank(attachment.getGeFileId())){
						attachment.setActionType(OpCode.DELETE.getOperationCode());	}				
					attachment.setOpCode(OpCode.SAVE.getOperationCode());	
				}
			}
			requestDetails.getFormat().setOpCode(OpCode.SAVE.getOperationCode());
		}
		requestDetails.setActionLogs(null);
		requestDetails.setAuditLogs(null);
		requestDetails = serviceClient.invokeService(
				OpCode.REQUESTDETAILS.getOperationCode(), requestDetails,
				RequestDetails.class);
		return requestDetails;
	}


	/**
	 * This method is used for save and approve
	 * @param requestDetails
	 */
	public RequestDetails saveandApprove(RequestDetails requestDetails,ActionType actionType) throws HWFServiceException {

		ALOCCommonHelper.setOpCode(requestDetails, actionType);

		if(requestDetails.getWFDetails()!=null && requestDetails.getWFDetails().getWFStage()!=null && requestDetails.getWFDetails().getWFStage().equals(ALOCConstants.BID_REPLY)){
			requestDetails = ALOCCommonHelper.setPricingDetails(requestDetails);
		}
		ALOCCommonHelper.setMsgHeader(requestDetails, OpCode.APPROVE);

		requestDetails.setActionLogs(null);
		requestDetails.setAuditLogs(null);
		requestDetails.setBankDetails(null);
		List<Attachment> attachmentsList = requestDetails.getAttachments();
		requestDetails = serviceClient.invokeService(OpCode.APPROVE.getOperationCode(), requestDetails,	RequestDetails.class);
		requestDetails.setAttachments(attachmentsList);//Attachments filtering 
		return requestDetails;
	}
	
	/**
	 * This method is used for issuanceSave at texonomy level
	 * @param requestDetails
	 */
	public RequestDetails issuanceSave(RequestDetails requestDetails,ActionType actionType) throws HWFServiceException {
		ALOCCommonHelper.setOpCode(requestDetails, actionType);
		ALOCCommonHelper.setMsgHeader(requestDetails, OpCode.ISSUANCEUPLOAD);
		requestDetails.setActionLogs(null);
		requestDetails.setAuditLogs(null);
		requestDetails.setBankDetails(null);
		requestDetails = serviceClient.invokeService(OpCode.ISSUANCEUPLOAD.getOperationCode(), requestDetails,	RequestDetails.class);
		return requestDetails;
	}
	/**
	 * Method to get the Amendment details for the Taxonomy
	 * @throws HWFServiceException
	 * @param id 
	 * @return amendments
	 */
	public GetAmendmentRiders getAmendments(BigInteger id) throws HWFServiceException {
		GetAmendmentRiders amendments = new GetAmendmentRiders();
		amendments.setRequestId(id);

		MsgHeader msgHeader = new MsgHeader();
		msgHeader  = ALOCCommonHelper.createMsgHeader(OpCode.GETAMENDMENTS.getOperationCode());
		amendments.setMsgHeader(msgHeader);

		amendments = serviceClient.invokeService(OpCode.AMENDMENTRIDERDETAILS.getOperationCode(), amendments,GetAmendmentRiders.class);
		return amendments;
	}

	/**
	 * Method to get the Amendment details for the Taxonomy
	 * @throws HWFServiceException
	 * @param id 
	 * @return riders
	 */
	public GetAmendmentRiders getRiders(BigInteger id) throws HWFServiceException {
		GetAmendmentRiders riders = new GetAmendmentRiders();
		riders.setRequestId(id);

		MsgHeader msgHeader = new MsgHeader();
		msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.GETRIDERS.getOperationCode());
		riders.setMsgHeader(msgHeader);

		riders = serviceClient.invokeService(OpCode.AMENDMENTRIDERDETAILS.getOperationCode(), riders,GetAmendmentRiders.class);
		return riders;
	}

	/**
	 * Method to get the FeeHistory details for the Taxonomy
	 * @throws HWFServiceException
	 * @param id 
	 * @return feeHistory
	 */
	public FeeHistoryDetails getFeeHistory(BigInteger id) throws HWFServiceException {
		
		APMDetails apmDetails = new APMDetails();
		FeeHistoryDetails feeHistDet = new FeeHistoryDetails();
		List<FullSummary> fullSumLst = new ArrayList<FullSummary>();
		FullSummary fullSum = new FullSummary();
		fullSum.setALOCRecordNumber(id);
		fullSumLst.add(fullSum);
		feeHistDet.setFullSummaries(fullSumLst);
		apmDetails.setFeeHistoryDetails(feeHistDet);
		
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.REQFEEHISTORY.getOperationCode());
		apmDetails.setMsgHeader(msgHeader);

		apmDetails = serviceClient.invokeService(OpCode.APMDETAILS.getOperationCode(), apmDetails, APMDetails.class);
		feeHistDet = apmDetails.getFeeHistoryDetails();
		
		return feeHistDet;
	}
	
	/**
	 * Method to get the Competing bid reply details for the Taxonomy
	 * @throws HWFServiceException
	 * @param id 
	 * @return feeHistory
	 */
	public CurrentBankFees getCompBidReplies(BigInteger id) throws HWFServiceException {
		CurrentBankFees curBankFees = new CurrentBankFees();
		curBankFees.setAlocRequestId(id);
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.COMPETINGBIDREPLIES.getOperationCode());
		curBankFees.setMsgHeader(msgHeader);
		
		curBankFees = serviceClient.invokeService(OpCode.TAXONOMY.getOperationCode(), curBankFees, CurrentBankFees.class);
		
		return curBankFees;
	}
	
	/**
	 * Method to get the Current bank fees details for the Taxonomy
	 * @throws HWFServiceException
	 * @param id 
	 * @return feeHistory
	 */
	public CurrentBankFees getCurrBankFees(BigInteger id) throws HWFServiceException {
		CurrentBankFees curBankFees = new CurrentBankFees();
		curBankFees.setAlocRequestId(id);
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.CURRENTBANKFEES.getOperationCode());
		curBankFees.setMsgHeader(msgHeader);
		
		curBankFees = serviceClient.invokeService(OpCode.TAXONOMY.getOperationCode(), curBankFees, CurrentBankFees.class);
		
		return curBankFees;
	}
	
	/**
	 * Method to get the Current bank fees details for the Taxonomy
	 * @throws HWFServiceException
	 * @param id 
	 * @return feeHistory
	 */
	public CurrentBankFees saveCurrBankFees(CurrentBankFees curBankFees) throws HWFServiceException {
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.FEEADJUSTMENTS.getOperationCode());
		curBankFees.setMsgHeader(msgHeader);
		
		curBankFees =  serviceClient.invokeService(OpCode.TAXONOMY.getOperationCode(), curBankFees, CurrentBankFees.class);
		return curBankFees;
	}
	
	/**
	 * Method to get the Bank Reference Number valid or not(Issuance stage).
	 * @param referenceNumberValidation
	 * @throws HWFServiceException
	 */
	public ReferenceNumberValidation checkBankRefNumber(ReferenceNumberValidation referenceNumberValidation) throws HWFServiceException {
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.REFERENCENUMBERVALIDATION.getOperationCode());
		referenceNumberValidation.setMsgHeader(msgHeader);
		referenceNumberValidation =  serviceClient.invokeService(OpCode.REFERENCENUMBERVALIDATION.getOperationCode(), referenceNumberValidation, ReferenceNumberValidation.class);
		return referenceNumberValidation;
	}

	/**
	 * Method to get the selected Model requestDetails
	 * @return RequestDetails
	 */
	public RequestDetails openModelRequest(String requestId)
			throws HWFServiceException {
		RequestDetails requestDetails = new RequestDetails();
		requestDetails.setRequestId(new BigInteger(requestId));
		ALOCCommonHelper.setMsgHeader(requestDetails, OpCode.GETSITEMODEL);
		requestDetails = serviceClient.invokeService(OpCode.SITEMODELDETAILS.getOperationCode(),requestDetails,RequestDetails.class);
		return requestDetails;
	}

	/**
	 * Method to save the Modified Model details
	 */
	public RequestDetails saveModel(RequestDetails requestDetails)
			throws HWFServiceException {
		ALOCCommonHelper.setMsgHeader(requestDetails, OpCode.UPDATESITEMODEL);
		requestDetails.setOpCode(OpCode.SAVE.getOperationCode());
		requestDetails = serviceClient.invokeService(OpCode.SITEMODELDETAILS.getOperationCode(), requestDetails,RequestDetails.class);
		return requestDetails;
	}

	/**
	 * Method to update Taxonomy Transaction Parties fields
	 * @throws HWFServiceException
	 * @param requestDetails
	 * @return requestDetails
	 */
	public RequestDetails updateTaxonomy(RequestDetails requestDetails) throws HWFServiceException {
		ALOCCommonHelper.setMsgHeader(requestDetails, OpCode.TAXONOMY);
		requestDetails = serviceClient.invokeService(OpCode.REQUESTDETAILS.getOperationCode(), requestDetails,RequestDetails.class);
		return requestDetails;
	}
	
	/**
	 * Method to update Taxonomy Transaction Parties fields
	 * @throws HWFServiceException
	 * @param updateReporting
	 * @return updateReporting
	 */
	public UpdateReporting getReportingData(UpdateReporting updateReporting) throws HWFServiceException {
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.GETUPDATEREPORTING.getOperationCode());
		updateReporting.setMsgHeader(msgHeader);
		
		updateReporting = serviceClient.invokeService(OpCode.UPDATEREPORTING.getOperationCode(), updateReporting,UpdateReporting.class);
				
		return updateReporting;
	}
	
	/**
	 * Method to update Taxonomy Transaction Parties fields
	 * @throws HWFServiceException
	 * @param updateReporting
	 * @return updateReporting
	 */
	public UpdateReporting updateReportingData(UpdateReporting updateReporting) throws HWFServiceException {
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.UPDATE.getOperationCode());
		updateReporting.setMsgHeader(msgHeader);
		updateReporting = serviceClient.invokeService(OpCode.UPDATEREPORTING.getOperationCode(), updateReporting,UpdateReporting.class);
		return updateReporting;
	}

	/**
	 * Method to retrieve the Surety Company Names List
	 * @param suretyMaster
	 * @return SuretyMasterCollection
	 * @throws HWFServiceException
	 */
	public SuretyMasterCollection getActiveSuretyMasterList(
			SuretyMaster suretyMaster) throws HWFServiceException {
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.GETACTIVESURETY.getOperationCode());
		suretyMaster.setMsgHeader(msgHeader);
		SuretyMasterCollection suretyList = (SuretyMasterCollection) serviceClient.invokeService(OpCode.INITIATESURETY.getOperationCode(), suretyMaster, SuretyMasterCollection.class);
		return suretyList;
	}

	/**
	 * This is used to open the Bid Award request upon clicking on the selected bank reply.
	 * @param requestDetails
	 * @return
	 * @throws HWFServiceException
	 */
	public RequestDetails openBidAwardRequest(RequestDetails requestDetails)
			throws HWFServiceException {
		ALOCCommonHelper.setMsgHeader(requestDetails, OpCode.GETREQUEST);
		requestDetails = serviceClient.invokeService(OpCode.REQUESTDETAILS.getOperationCode(), requestDetails, RequestDetails.class);
		return (requestDetails!=null) ? requestDetails : null;
	}

	/**
	 * 
	 */
	public RequestDetails saveAttachments(RequestDetails requestDetails,AttachmentType type,Attachment attachment) throws HWFServiceException {
		ALOCCommonHelper.setMsgHeader(requestDetails, OpCode.REQUESTDETAILS); //message header changed from CREATEREQUEST to REQUESTDETAILS opcode for saving instant attachment upload functionality
		if (type == AttachmentType.NON_STANDARD_FORMAT) {			
			requestDetails.getFormat().setOpCode(OpCode.SAVE.getOperationCode());	
			for (Attachment formatAttachment : requestDetails.getFormat().getAttachments()){				
				formatAttachment.setOpCode(OpCode.SAVE.getOperationCode());		 		
			}
			RequestDetails rdFromDB = serviceClient.invokeService(OpCode.REQUESTDETAILS.getOperationCode(), requestDetails,RequestDetails.class);
			requestDetails.setFormat(rdFromDB.getFormat());
		}else if(type == AttachmentType.ISSUER){
			
			
			List<Attachment> atmtList = new ArrayList<Attachment>();
			attachment.setOpCode(OpCode.SAVE.getOperationCode());
			atmtList.add(attachment);
			requestDetails.setAttachments(atmtList);

			if((requestDetails.getAmendment()!= null && requestDetails.getAmendment().getAmendmentRequestId()!= null) || (requestDetails.getRider()!= null && requestDetails.getRider().getRiderRequestId()!= null)){
				requestDetails.setRequestId(null);				
				requestDetails.setInstrumentType(null);
				requestDetails.setInstrumentTypeId(null);				
			}
			
			RequestDetails rdFromDB = serviceClient.invokeService(OpCode.REQUESTDETAILS.getOperationCode(), requestDetails,RequestDetails.class);
			if((requestDetails.getAmendment()!= null && requestDetails.getAmendment().getAmendmentRequestId()!= null) || (requestDetails.getRider()!= null && requestDetails.getRider().getRiderRequestId()!= null)){
				if(requestDetails.getAmendment()!= null && requestDetails.getAmendment().getAmendmentRequestId()!= null){
					requestDetails.setInstrumentTypeId(new BigInteger(requestDetails.getAmendment().getInstrumentTypeId()));
					requestDetails.setRequestId(requestDetails.getAmendment().getRequestId());
					requestDetails.setInstrumentType(requestDetails.getAmendment().getInstrumentType());
				}
				if(requestDetails.getRider()!= null && requestDetails.getRider().getRiderRequestId()!= null){
					requestDetails.setInstrumentTypeId(new BigInteger(requestDetails.getRider().getInstrumentTypeId()));
					requestDetails.setRequestId(requestDetails.getRider().getRequestId());
					requestDetails.setInstrumentType(requestDetails.getRider().getInstrumentType());
				}					
			}
			
			if(rdFromDB.getAttachments().size() == ALOCConstants.MIN_VALUE) {
				Attachment atmt = rdFromDB.getAttachments().get(ALOCConstants.BASE_VALUE);
				if(requestDetails.getBidReplyDetails().getIssuanceTypeFlag() != null && ALOCConstants.ISSUANCE_TYPE_INDIRECT.equalsIgnoreCase(requestDetails.getBidReplyDetails().getIssuanceTypeFlag())) {
					Attachment newAtmt = new Attachment();
					newAtmt.setAttachmentTypeId(new BigInteger(ALOCConstants.DOCTYPE_ISSUER));
					
					if(atmt.getIssuanceDocTypeId().intValue() == ALOCConstants.MIN_VALUE) {
						newAtmt.setIssuanceDocTypeId(new BigInteger(ALOCConstants.DOCTYPE_OTHER));
						newAtmt.setIssuanceDocType(ALOCConstants.DOCTYPE_OTHER);
						rdFromDB.getAttachments().add(ALOCConstants.BASE_VALUE, newAtmt);
					} else {
						newAtmt.setIssuanceDocTypeId(new BigInteger(ALOCConstants.DOCTYPE_FORMAT));
						newAtmt.setIssuanceDocType(ALOCConstants.DOCTYPE_FORMAT);
						rdFromDB.getAttachments().add(newAtmt);
					}
				}
			} else if(rdFromDB.getAttachments().size() == ALOCConstants.SECOND_VALUE) {
				if(rdFromDB.getAttachments().get(ALOCConstants.BASE_VALUE).getIssuanceDocTypeId().intValue() == ALOCConstants.MIN_VALUE) {
					Attachment atmt = rdFromDB.getAttachments().remove(ALOCConstants.BASE_VALUE);
					rdFromDB.getAttachments().add(atmt);
				}
			}
			requestDetails.setAttachments(rdFromDB.getAttachments());		
		} else if(type == AttachmentType.OTHER ||type == AttachmentType.CLOSURE){
			List<String> atmtFolderId = new ArrayList<String>();
			for (Attachment reqAttachment : requestDetails.getAttachments()){					
				reqAttachment.setOpCode(OpCode.SAVE.getOperationCode());
				if(StringUtils.isNotBlank(reqAttachment.getGeFileId())){
					atmtFolderId.add(reqAttachment.getGeFileId());
				}
			}
			if((requestDetails.getAmendment()!= null && requestDetails.getAmendment().getAmendmentRequestId()!= null) || (requestDetails.getRider()!= null && requestDetails.getRider().getRiderRequestId()!= null)){
				requestDetails.setRequestId(null);				
				requestDetails.setInstrumentType(null);
				requestDetails.setInstrumentTypeId(null);				
				
			}
			RequestDetails rdFromDB = serviceClient.invokeService(OpCode.REQUESTDETAILS.getOperationCode(), requestDetails,RequestDetails.class);
			if((requestDetails.getAmendment()!= null && requestDetails.getAmendment().getAmendmentRequestId()!= null) || (requestDetails.getRider()!= null && requestDetails.getRider().getRiderRequestId()!= null)){
				if(requestDetails.getAmendment()!= null && requestDetails.getAmendment().getAmendmentRequestId()!= null){
					requestDetails.setInstrumentTypeId(new BigInteger(requestDetails.getAmendment().getInstrumentTypeId()));
					requestDetails.setRequestId(requestDetails.getAmendment().getRequestId());
					requestDetails.setInstrumentType(requestDetails.getAmendment().getInstrumentType());
				}
				if(requestDetails.getRider()!= null && requestDetails.getRider().getRiderRequestId()!= null){
					requestDetails.setInstrumentTypeId(new BigInteger(requestDetails.getRider().getInstrumentTypeId()));
					requestDetails.setRequestId(requestDetails.getRider().getRequestId());
					requestDetails.setInstrumentType(requestDetails.getRider().getInstrumentType());
				}					
			}
			String stageName = requestDetails.getWFDetails()  != null ? requestDetails.getWFDetails().getWFStage() : ALOCConstants.EMPTY_STRING;
			String roleName = (requestDetails.getMsgHeader() != null) ? requestDetails.getMsgHeader().getRoleName() : null;
			if(((WorkflowStage.TREASURYANALYST.getName().equals(stageName)||WorkflowStage.TRESEDIT.getName().equals(stageName))	&& roleName != null 
					&& (roleName.equalsIgnoreCase(UserRole.TreasuryAnalyst.getName()) || roleName.equalsIgnoreCase(UserRole.TreasuryApprover.getName())))
					&& rdFromDB.getAttachments() != null && !rdFromDB.getAttachments().isEmpty()) {
				List<Attachment> atmtsList = new ArrayList<Attachment>();
				
				for(Attachment reqAttachment : rdFromDB.getAttachments()) {
					if(reqAttachment.getAttachmentTypeId().intValue() == AttachmentType.OTHER.getId()){
						if(!reqAttachment.getAttachmentPermissions().isEmpty()){
							for(AttachmentPermission atmtPermissions : reqAttachment.getAttachmentPermissions()){
								if((StringUtils.isNotBlank(atmtPermissions.getPermissionId())&&Integer.valueOf(atmtPermissions.getPermissionId())==ALOCConstants.MIN_VALUE)||
										(atmtFolderId!=null&&atmtFolderId.contains(reqAttachment.getGeFileId()))){
									atmtsList.add(reqAttachment);
									break;
								}
							}
						}
					}else{
						atmtsList.add(reqAttachment);
					}
				}
				requestDetails.setAttachments(atmtsList);
			}else{
				requestDetails.setAttachments(rdFromDB.getAttachments());
			}
			
		}			

		return requestDetails;
	}
	
	/**
	 * Method to save FormatData with Swift changes 
	 * @see com.ge.aloc.dao.IRequestDetailsSectionDAO#saveFormatSwiftData(com.ge.aloc.bo.RequestDetailsBO)
	 */
	public RequestDetails saveFormatSwiftData(RequestDetails requestDetails) throws HWFServiceException {		
		if (requestDetails.getFormat().getAttachments() != null && !requestDetails.getFormat().getAttachments().isEmpty()) { 
			for (Attachment attachment :requestDetails.getFormat().getAttachments()){	
				attachment.setActionType(OpCode.UPDATE.getOperationCode()); 
				attachment.setOpCode(OpCode.SAVE.getOperationCode());
			}
			requestDetails.getFormat().setOpCode(OpCode.SAVE.getOperationCode());
			 ALOCCommonHelper.setMsgHeader(requestDetails, OpCode.CREATEREQUEST);
			requestDetails = serviceClient.invokeService(OpCode.REQUESTDETAILS.getOperationCode(), requestDetails,RequestDetails.class);
		}
		return requestDetails;
	}

	/**
	 * Method to submit the surety bond
	 * @param requestDetails
	 * @param actionType
	 * @throws HWFServiceException
	 */
	public RequestDetails awardSubmit(RequestDetails requestDetails,
			ActionType actionType) throws HWFServiceException {
		ALOCCommonHelper.setOpCode(requestDetails, actionType);
		ALOCCommonHelper.setMsgHeader(requestDetails, OpCode.APPROVE);
		requestDetails = serviceClient.invokeService(
				OpCode.APPROVE.getOperationCode(), requestDetails,
				RequestDetails.class);
		return (requestDetails != null) ? requestDetails : null;

	}
	/**
	 * delete the attachment
	 * @param requestDetails
	 * @param type
	 * @return
	 * @throws HWFServiceException
	 */
	public RequestDetails deleteAttachments(RequestDetails requestDetails,Attachment atmt, AttachmentType type)	throws HWFServiceException {
		ALOCCommonHelper.setMsgHeader(requestDetails, OpCode.REQUESTDETAILS); //message header changed from CREATEREQUEST to REQUESTDETAILS opcode for saving instant attachment upload functionality
		if (type == AttachmentType.NON_STANDARD_FORMAT) {			
			requestDetails.getFormat().setOpCode(OpCode.SAVE.getOperationCode());
			RequestDetails rdFromDB = serviceClient.invokeService(OpCode.REQUESTDETAILS.getOperationCode(), requestDetails,RequestDetails.class);		
			requestDetails.setFormat(rdFromDB.getFormat());
		}else if(type == AttachmentType.OTHER || type == AttachmentType.ISSUER
				||type == AttachmentType.CLOSURE){
			List<String> atmtFolderId = new ArrayList<String>();
			for (Attachment attachment : requestDetails.getAttachments()){
				attachment.setOpCode(OpCode.SAVE.getOperationCode());
				if(StringUtils.isNotBlank(attachment.getGeFileId())){
					atmtFolderId.add(attachment.getGeFileId());
				}
				if(attachment.getActionType()==null && attachment.getGeFileId() != null && attachment.getGeFileId().equalsIgnoreCase(atmt.getGeFileId())){
					attachment.setActionType(OpCode.DELETE.getOperationCode());
				}
			}	
			if((requestDetails.getAmendment()!= null && requestDetails.getAmendment().getAmendmentRequestId()!= null) || (requestDetails.getRider()!= null && requestDetails.getRider().getRiderRequestId()!= null)){
				requestDetails.setRequestId(null);				
				requestDetails.setInstrumentType(null);
				requestDetails.setInstrumentTypeId(null);								
			}
			RequestDetails rdFromDB =  serviceClient.invokeService(OpCode.REQUESTDETAILS.getOperationCode(), requestDetails,RequestDetails.class);	
			requestDetails.setAttachments(rdFromDB.getAttachments());	
			if(requestDetails.getRider()!=null  && requestDetails.getRider().getRiderRequestId()!= null){
				requestDetails.setInstrumentTypeId(new BigInteger(requestDetails.getRider().getInstrumentTypeId()));
				requestDetails.setRequestId(requestDetails.getRider().getRequestId());
				requestDetails.setInstrumentType(requestDetails.getRider().getInstrumentType());
			}
			if(requestDetails.getAmendment()!=null && requestDetails.getAmendment().getAmendmentRequestId()!= null){
				requestDetails.setInstrumentTypeId(new BigInteger(requestDetails.getAmendment().getInstrumentTypeId()));
				requestDetails.setRequestId(requestDetails.getAmendment().getRequestId());
				requestDetails.setInstrumentType(requestDetails.getAmendment().getInstrumentType());
			}	
			String stageName = requestDetails.getWFDetails()  != null ? requestDetails.getWFDetails().getWFStage() : ALOCConstants.EMPTY_STRING;
			String roleName = (requestDetails.getMsgHeader() != null) ? requestDetails.getMsgHeader().getRoleName() : null;
			if(((WorkflowStage.TREASURYANALYST.getName().equals(stageName)||WorkflowStage.TRESEDIT.getName().equals(stageName))	&& roleName != null 
					&& (roleName.equalsIgnoreCase(UserRole.TreasuryAnalyst.getName()) || roleName.equalsIgnoreCase(UserRole.TreasuryApprover.getName())))
					&& rdFromDB.getAttachments() != null && !rdFromDB.getAttachments().isEmpty()) {
				List<Attachment> atmtsList = new ArrayList<Attachment>();
				
				for(Attachment reqAttachment : rdFromDB.getAttachments()) {
					if(reqAttachment.getAttachmentTypeId().intValue() == AttachmentType.OTHER.getId()){
						if(!reqAttachment.getAttachmentPermissions().isEmpty()){
							for(AttachmentPermission atmtPermissions : reqAttachment.getAttachmentPermissions()){
								if((StringUtils.isNotBlank(atmtPermissions.getPermissionId())&&Integer.valueOf(atmtPermissions.getPermissionId())==ALOCConstants.MIN_VALUE)||
										(atmtFolderId!=null&&atmtFolderId.contains(reqAttachment.getGeFileId()))){
									atmtsList.add(reqAttachment);
									break;
								}
							}
						}
					}else{
						atmtsList.add(reqAttachment);
					}
				}
				requestDetails.setAttachments(atmtsList);
			}
		}			
		return requestDetails;
	}

}
