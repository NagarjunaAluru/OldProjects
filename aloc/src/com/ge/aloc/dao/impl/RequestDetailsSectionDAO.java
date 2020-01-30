/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: RequestDetailsSectionDAO.java
 * Purpose: RequestDetailsSectionDAO used for the all the request section DAO implementations
 */
package com.ge.aloc.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import com.ge.aloc.ActionType;
import com.ge.aloc.FormatType;
import com.ge.aloc.InstrumentType;
import com.ge.aloc.OpCode;
import com.ge.aloc.ServiceClientSupport;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.dao.IRequestDetailsSectionDAO;
import com.ge.aloc.model.AddressDtls;
import com.ge.aloc.model.Attachment;
import com.ge.aloc.model.DelegationApprovers;
import com.ge.aloc.model.FormatTemplate;
import com.ge.aloc.model.MsgHeader;
import com.ge.aloc.model.RequestDetails;
import com.ge.aloc.util.ALOCCommonHelper;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author chaitanya.n
 *
 */
public class RequestDetailsSectionDAO extends ServiceClientSupport implements IRequestDetailsSectionDAO {

	/**
	 * This method is used for save request details
	 * @param requestDetails
	 *
	 */
	public RequestDetails save(RequestDetails requestDetails)	throws HWFServiceException {
		requestDetails.setActionLogs(null);
		requestDetails.setOpCode(OpCode.SAVE.getOperationCode());
		requestDetails=invokeService(requestDetails);
		return requestDetails;
	}
	/* (non-Javadoc)
	 * This method is used to save Attachments section 
	 * @see com.ge.aloc.dao.IRequestDetailsSectionDAO#saveAttachments(com.ge.aloc.bo.RequestDetailsBO)
	 */
	public void saveAttachments(RequestDetails requestDetails) throws HWFServiceException {
		if (requestDetails.getAttachments() != null && !requestDetails.getAttachments().isEmpty()) {//sync the file permissions for Attachments
			for (Attachment attachment :requestDetails.getAttachments()){	
				if(attachment.getAttachmentId()!=null) {
					attachment.setActionType(OpCode.UPDATE.getOperationCode()); }
				else {
					attachment.setActionType(OpCode.INSERT.getOperationCode());	}
				attachment.setOpCode(OpCode.SAVE.getOperationCode());	
				
			} 
			if((requestDetails.getAmendment()!= null && requestDetails.getAmendment().getAmendmentRequestId()!= null)){							
				requestDetails.setInstrumentType(requestDetails.getAmendment().getInstrumentType());
				requestDetails.setInstrumentTypeId(new BigInteger(requestDetails.getAmendment().getInstrumentTypeId()));								
			}
			if((requestDetails.getRider()!= null && requestDetails.getRider().getRiderRequestId()!= null)){							
				requestDetails.setInstrumentType(requestDetails.getRider().getInstrumentType());
				requestDetails.setInstrumentTypeId(new BigInteger(requestDetails.getRider().getInstrumentTypeId()));								
			}
			RequestDetails rdFromDB = invokeService(requestDetails);				
			requestDetails.setAttachments(rdFromDB.getAttachments());
		}		
	}

	/* (non-Javadoc)
	 * This method is used to save format section 
	 * @see com.ge.aloc.dao.IRequestDetailsSectionDAO#saveFormat(com.ge.aloc.bo.RequestDetailsBO)
	 */
	public void saveFormat(RequestDetails requestDetails) throws HWFServiceException {		
		if (requestDetails.getFormat().getAttachments() != null && !requestDetails.getFormat().getAttachments().isEmpty()) { 
			String formatTypeId = requestDetails.getFormat().getFormatTypeId();
			for (Attachment attachment :requestDetails.getFormat().getAttachments()){
				if(Integer.valueOf(formatTypeId).intValue() == FormatType.NON_STANDARD.getId() && attachment.getAttachmentId()!=null){
					attachment.setActionType(OpCode.UPDATE.getOperationCode());
				}else if(StringUtils.isNotBlank(attachment.getGeFileId())){
					attachment.setActionType(OpCode.DELETE.getOperationCode());	}				
				attachment.setOpCode(OpCode.SAVE.getOperationCode());	
			}
			requestDetails.getFormat().setOpCode(OpCode.SAVE.getOperationCode());
			RequestDetails rdFromDB = invokeService(requestDetails);
			requestDetails.setFormat(rdFromDB.getFormat());
			requestDetails.setSwiftFormatDoc(rdFromDB.getSwiftFormatDoc());	
		}		
	}
	/**
	 * This method is used to save an Amendment details
	 * @return RequestDetails
	 */
	public RequestDetails saveAmendment(RequestDetails requestDetails)
			throws HWFServiceException {
		if (requestDetails.getAmendment() != null) {
			requestDetails.getAmendment().setOpCode(OpCode.SAVE.getOperationCode());
			requestDetails.setActionLogs(null);
			requestDetails=  invokeService(requestDetails);

		}
		return requestDetails;
	}



	/** (non-Javadoc)
	 * This method is used to save rider details
	 * @see com.ge.aloc.dao.IRequestDetailsSectionDAO#saveRider(com.ge.aloc.model.RequestDetails)
	 */
	public RequestDetails saveRider(RequestDetails requestDetails)
			throws HWFServiceException {
		if (requestDetails.getRider() != null) {
			requestDetails.getRider().setOpCode(OpCode.SAVE.getOperationCode());
			requestDetails.setActionLogs(null);
			requestDetails=  invokeService(requestDetails);

		}
		return requestDetails;
	}
	/**
	 * This method is used to save an Amendment Transaction Parties section 
	 */
	public void saveAmendmentTP(RequestDetails requestDetails)
			throws HWFServiceException {
		if (requestDetails.getAmendment() != null && requestDetails.getAmendment().getTransactionParties() != null) {
			if(requestDetails.getAmendment().getTransactionParties().isTriPartyRequestFlag() == null || (requestDetails.getAmendment().getTransactionParties().isTriPartyRequestFlag() != null && !requestDetails.getAmendment().getTransactionParties().isTriPartyRequestFlag())){
				requestDetails.getAmendment().getTransactionParties().setTriPartyApplicant(null);
			}
			requestDetails.getAmendment().getTransactionParties().setOpCode(OpCode.SAVE.getOperationCode());
			RequestDetails amendrdFromDB = invokeService(requestDetails);
			requestDetails.getAmendment().getTransactionParties().getTpApplicantDetails().setAddressDtls(amendrdFromDB.getAmendment().getTransactionParties().getTpApplicantDetails().getAddressDtls());
			requestDetails.getAmendment().getTransactionParties().setTriPartyApplicant(amendrdFromDB.getAmendment().getTransactionParties().getTriPartyApplicant());
			requestDetails.getAmendment().getTransactionParties().getCustomer().setAddressDtls(amendrdFromDB.getAmendment().getTransactionParties().getCustomer().getAddressDtls());
			requestDetails.getAmendment().getTransactionParties().setOpCode(null);
			if(amendrdFromDB.getWFDetails()!=null){
				requestDetails.setWFDetails(amendrdFromDB.getWFDetails());
			}
		}
	}

	/**
	 * This method is used to save an Amendment Instrument Amount/Currency section
	 */
	public void saveAmendmentIAC(RequestDetails requestDetails)
			throws HWFServiceException {
		if (requestDetails.getAmendment() != null && requestDetails.getAmendment().getAmendmentInstrumentAmountCurr() != null) {
			requestDetails.getAmendment().getAmendmentInstrumentAmountCurr().setOpCode(OpCode.SAVE.getOperationCode());
			RequestDetails amendrdFromDB = invokeService(requestDetails);
			requestDetails.getAmendment().getAmendmentInstrumentAmountCurr().setRevisedInstrumentAmt(amendrdFromDB.getAmendment().getAmendmentInstrumentAmountCurr().getRevisedInstrumentAmt());
			requestDetails.getAmendment().getAmendmentInstrumentAmountCurr().setOpCode(null);

			if(requestDetails.getDelegationApprovers()!=null){
				requestDetails.setDelegationApprovers(amendrdFromDB.getDelegationApprovers());
			}else{
				DelegationApprovers deleapp= new DelegationApprovers();
				requestDetails.setDelegationApprovers(deleapp);
				requestDetails.getDelegationApprovers().setDelegationGroups(amendrdFromDB.getDelegationApprovers().getDelegationGroups());
			}




		}

	}

	/**
	 * This method is used to save an Amendment Expire Dates section
	 */
	public void saveAmendmentED(RequestDetails requestDetails)
			throws HWFServiceException {
		if (requestDetails.getAmendment() != null && requestDetails.getAmendment().getExpiryDate() != null) {
			requestDetails.getAmendment().getExpiryDate().setOpCode(OpCode.SAVE.getOperationCode());
			RequestDetails amendrdFromDB = invokeService(requestDetails);
			requestDetails.getAmendment().getExpiryDate().setRevisedExpiryDate(amendrdFromDB.getAmendment().getExpiryDate().getRevisedExpiryDate());
			requestDetails.getAmendment().getExpiryDate().setOpCode(null);
		}
	}

	/**
	 * This method is used to save an Amendment Other Changes section
	 */
	public void saveAmendmentOC(RequestDetails requestDetails)
			throws HWFServiceException {
		if (requestDetails.getAmendment() != null){
			requestDetails.getAmendment().setOpCode(OpCode.SAVE.getOperationCode());
			invokeService(requestDetails);
			requestDetails.getAmendment().setOpCode(null);
		}
	}

	/**
	 * This method is used to save rider principal section
	 */
	public void saveRiderPrincipal(RequestDetails requestDetails)
			throws HWFServiceException {
		if (requestDetails.getRider() != null && requestDetails.getRider().getPrincipal() != null) {
			requestDetails.getRider().getPrincipal().setOpCode(OpCode.SAVE.getOperationCode());
			RequestDetails riderFromDB = invokeService(requestDetails);
			requestDetails.getRider().setPrincipal(riderFromDB.getRider().getPrincipal());
		}
	}

	/**
	 * This method is used to save rider Obligee section
	 */
	public void saveRiderObligee(RequestDetails requestDetails)
			throws HWFServiceException {
		if (requestDetails.getRider() != null && requestDetails.getRider().getObligee() != null) {
			requestDetails.getRider().getObligee().setOpCode(OpCode.SAVE.getOperationCode());
			RequestDetails riderFromDB = invokeService(requestDetails);
			requestDetails.getRider().setObligee(riderFromDB.getRider().getObligee());
		}
	}

	/**
	 * This method is used to save rider Expire Date section
	 */
	public void saveRiderExpDate(RequestDetails requestDetails)
			throws HWFServiceException {
		if (requestDetails.getRider() != null && requestDetails.getRider().getExpiryDate() != null) {
			requestDetails.getRider().getExpiryDate().setOpCode(OpCode.SAVE.getOperationCode());
			RequestDetails riderFromDB = invokeService(requestDetails);
			requestDetails.getRider().setExpiryDate(riderFromDB.getRider().getExpiryDate());
		}
	}

	/**
	 * This method is used to save rider bond Information section
	 */
	public void saveRiderBondInformation(RequestDetails requestDetails)
			throws HWFServiceException {
		if (requestDetails.getRider() != null && requestDetails.getRider().getRiderBondInformation() != null) {
			requestDetails.getRider().getRiderBondInformation().setOpCode(OpCode.SAVE.getOperationCode());
			RequestDetails riderFromDB = invokeService(requestDetails);
			requestDetails.getRider().setRiderBondInformation(riderFromDB.getRider().getRiderBondInformation());

			if(requestDetails.getDelegationApprovers()!=null){
				requestDetails.setDelegationApprovers(riderFromDB.getDelegationApprovers());
			}else{
				DelegationApprovers deleapp= new DelegationApprovers();
				requestDetails.setDelegationApprovers(deleapp);
				requestDetails.getDelegationApprovers().setDelegationGroups(riderFromDB.getDelegationApprovers().getDelegationGroups());
			}			

		}

	}

	/**
	 * This method is used to save rider delivery Instructions section
	 */
	public void saveRiderDeliveryInstructions(RequestDetails requestDetails)
			throws HWFServiceException {
		if (requestDetails.getRider() != null && requestDetails.getRider().getDeliveryInstructions() != null) {
			requestDetails.getRider().getDeliveryInstructions().setOpCode(OpCode.SAVE.getOperationCode());
			RequestDetails riderFromDB = invokeService(requestDetails);
			requestDetails.getRider().setDeliveryInstructions(riderFromDB.getRider().getDeliveryInstructions());
		}
	}

	/**
	 * This method is used for invoking service
	 * @param requestDetails
	 *
	 */

	private RequestDetails invokeService(RequestDetails requestDetails) throws HWFServiceException {

		ALOCCommonHelper.setMsgHeader(requestDetails, OpCode.CREATEREQUEST);
		requestDetails = serviceClient.invokeService(
				OpCode.REQUESTDETAILS.getOperationCode(), requestDetails,
				RequestDetails.class);
		return requestDetails;
	}


	/** 
	 * This method is used to get Standard format document
	 * @param requestId
	 * @param instrumentPurposeId
	 * @param bondTypeId
	 * @param bondSubTypeId
	 * @return formatTemplate
	 * @see com.ge.aloc.dao.IRequestDetailsSectionDAO#getStandardFormatDocument(java.lang.String)
	 */
	public String getStandardFormatDocument(String requestId,String instrPurposeId,BigInteger bondTypeId,BigInteger bondSubTypeId) throws HWFServiceException {
		MsgHeader msgHeader = new MsgHeader();		
		msgHeader.setOpcode(OpCode.GETFORMAT.getOperationCode());		
		FormatTemplate  formatTemplate = new FormatTemplate();			
		formatTemplate.setRequestId(requestId);			
		formatTemplate.setMsgHeader(msgHeader);
		if(StringUtils.isNotBlank(instrPurposeId)){
			formatTemplate.setInstrumentPurpusId(new BigInteger(instrPurposeId));
		}
		if(bondTypeId != null){
			formatTemplate.setBondTypeId(bondTypeId);
		}
		if(bondSubTypeId != null){
			formatTemplate.setSubBondTypeId(bondSubTypeId);
		}
		formatTemplate = serviceClient.invokeService(OpCode.GETFORMAT.getOperationCode(), formatTemplate,FormatTemplate.class);		
		return formatTemplate.getFormatValue();
	}	

	/**
	 * This method is used to create landing page request
	 * @throws HWFServiceException 
	 * 
	 */
	public RequestDetails createLandingPageRequest(RequestDetails requestDetails, String siteId,ActionType actionType) throws HWFServiceException{	

		if(StringUtils.isNotBlank(siteId)){
			requestDetails.setSiteId(new BigInteger(siteId));
		}
		if(actionType!=null && (ActionType.SAVE).equals(actionType)){
			ALOCCommonHelper.setOpCode(requestDetails, actionType);
		}
		InstrumentType instrumentType = InstrumentType.fromId(requestDetails.getInstrumentTypeId().intValue()); 
		switch(instrumentType) {
		case BANK_GUARANTEE:
			requestDetails.getTransactionParties().setOpCode(OpCode.SAVE.getOperationCode());
			break;
		case LOC:
			requestDetails.getTransactionParties().setOpCode(OpCode.SAVE.getOperationCode());
			break;
		case SURETY_BOND:
			requestDetails.getBondDetails().setOpCode(OpCode.SAVE.getOperationCode());
			if(requestDetails.getPrincipal()!=null && requestDetails.getPrincipal().getAddressDtls()!=null){
				List<String> address = new ArrayList<String>();
				if(requestDetails.getAddressDtls()==null){
					AddressDtls AddressDtls = new AddressDtls();
					requestDetails.setAddressDtls(AddressDtls);
				}
				requestDetails.getAddressDtls().setName(requestDetails.getPrincipal().getAddressDtls().getName());
				if(requestDetails.getPrincipal().getAddressDtls().getAddress()!= null){
				address.add(0,requestDetails.getPrincipal().getAddressDtls().getAddress().get(0));
				}
				if(requestDetails.getPrincipal().getAddressDtls().getAddress()!= null && requestDetails.getPrincipal().getAddressDtls().getAddress().get(1)!=null){
					address.add(1,requestDetails.getPrincipal().getAddressDtls().getAddress().get(1));
				}
				requestDetails.getAddressDtls().setAddress(address);
				requestDetails.getAddressDtls().setCity(requestDetails.getPrincipal().getAddressDtls().getCity());
				requestDetails.getAddressDtls().setStateProvince(requestDetails.getPrincipal().getAddressDtls().getStateProvince());
				requestDetails.getAddressDtls().setZIPPostalCode(requestDetails.getPrincipal().getAddressDtls().getZIPPostalCode());
				requestDetails.getAddressDtls().setCountry(requestDetails.getPrincipal().getAddressDtls().getCountry());
				requestDetails.getAddressDtls().setCountryCd(requestDetails.getPrincipal().getAddressDtls().getCountryCd());		
			}
			break;
		case DOCUMENT_LOC:
			requestDetails.getBuContactPerson().setOpCode(OpCode.SAVE.getOperationCode());
			break;
		}
		ALOCCommonHelper.setMsgHeader(requestDetails, OpCode.CREATEREQUEST);		
		requestDetails = serviceClient.invokeService(OpCode.REQUESTDETAILS.getOperationCode(), requestDetails,RequestDetails.class);

		return requestDetails;

	}

	/**
	 * This method is used for save request details
	 * @param requestDetails
	 *
	 */
	public RequestDetails saveRequestDetails(RequestDetails requestDetails)	throws HWFServiceException {
		requestDetails=invokeService(requestDetails);
		return requestDetails;
	}


	/**
	 * This method is used to get the full audit log Details
	 * @param requestDetails
	 * @param logType
	 * @throws HWFServiceException
	 * @return
	 */
	public RequestDetails getFullAuditandActionLog(String logType,RequestDetails requestDetails) throws HWFServiceException{
		if(logType.equalsIgnoreCase(ALOCConstants.ACTION)){
			ALOCCommonHelper.setMsgHeader(requestDetails, OpCode.GETTRANSDATA);	
		}else{
			ALOCCommonHelper.setMsgHeader(requestDetails, OpCode.GETAUDITDATA);
		}	
		requestDetails = serviceClient.invokeService(OpCode.REQUESTDETAILS.getOperationCode(), requestDetails,RequestDetails.class);	
		return requestDetails;
	}

}
