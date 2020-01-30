/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: RequestDetailsSectionManager.java
 * Purpose: RequestDetailsSectionManager used for the all request section operations
 */
package com.ge.aloc.manager.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.ge.aloc.ALOCContext;
import com.ge.aloc.ActionType;
import com.ge.aloc.AtmtPermType;
import com.ge.aloc.FormatType;
import com.ge.aloc.InstrumentType;
import com.ge.aloc.OpCode;
import com.ge.aloc.bo.AttachmentBO;
import com.ge.aloc.bo.FormatBO;
import com.ge.aloc.bo.RequestDetailsBO;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.dao.IRequestDetailsSectionDAO;
import com.ge.aloc.exception.ALOCAttachmentException;
import com.ge.aloc.exception.ALOCException;
import com.ge.aloc.exception.NoActiveRequestException;
import com.ge.aloc.manager.IALOCAttachmentManager;
import com.ge.aloc.manager.IRequestDetailsSectionManager;
import com.ge.aloc.model.Attachment;
import com.ge.aloc.model.AttachmentPermission;
import com.ge.aloc.model.RequestDetails;
import com.ge.aloc.model.WFDetails;
import com.ge.aloc.util.ALOCCommonHelper;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author chaitanya.n
 *
 */
public class RequestDetailsSectionManager implements IRequestDetailsSectionManager {

	private IRequestDetailsSectionDAO requestDetailsSectionDAO;
	private IALOCAttachmentManager alocAttachmentManager;

	/**
	 * This method is used to save the attachment section
	 * @throws ALOCException 
	 * @throws ALOCAttachmentException 
	 * @see com.ge.aloc.manager.IRequestDetailsSectionManager#saveAttachments()
	 */
	public void saveAttachments() throws HWFServiceException, ALOCAttachmentException, ALOCException {	 
		RequestDetailsBO requestDetailsBO = ALOCContext.getActiveRequest();
		requestDetailsSectionDAO.saveAttachments(requestDetailsBO.getModel());
	}


	/**
	 * This method is used to save attachment section
	 * @throws ALOCException 
	 * @see com.ge.aloc.manager.IRequestDetailsSectionManager#saveFormat() 
	 */
	@SuppressWarnings("unused")
	public void saveFormat(String standardFormat, String modifiedFormat) throws HWFServiceException, ALOCException { 	
		RequestDetailsBO requestDetailsBO = ALOCContext.getActiveRequest();
		FormatBO formatBO = requestDetailsBO.getFormatBO();
		FormatType formatType = formatBO.getFormatType();
		List<AttachmentBO> formatAttachmentBOList =  formatBO.getAttachmentBOList();
		Attachment atmt = null;
		AttachmentBO formatAttachmentBO = (!formatAttachmentBOList.isEmpty()) ? formatAttachmentBOList.get(ALOCConstants.BASE_VALUE) : null;

		if((formatAttachmentBO != null && formatAttachmentBO.getModel().getGeFileId() != null) && (formatType.getId() != FormatType.NON_STANDARD.getId())) {
			formatAttachmentBO.getModel().getAttachmentPermissions().clear();
			alocAttachmentManager.delete(formatAttachmentBO.getModel());
		}		
		String actionType = ((formatAttachmentBO == null||formatAttachmentBO.getModel().getActionType() == null) && (formatAttachmentBO==null||formatAttachmentBO.getModel().getGeFileId() == null)) ? OpCode.UPDATE.getOperationCode() : OpCode.DELETE.getOperationCode();
		if(formatAttachmentBO == null) {
			formatAttachmentBO = new AttachmentBO(); 
			formatAttachmentBOList.add(formatAttachmentBO);
		}
		if(FormatType.STANDARD.equals(formatType)){
			if(actionType.equals(ALOCConstants.DELETE)){
				formatAttachmentBO.getModel().setActionType(OpCode.DELETE.getOperationCode());
				formatAttachmentBO.getModel().setOpCode(OpCode.DELETE.getOperationCode());
				requestDetailsBO.getModel().setSwiftFormatDoc(standardFormat);
			}
			else{
				formatAttachmentBO.getModel().setActionType(OpCode.UPDATE.getOperationCode());
				formatAttachmentBO.getModel().setOpCode(OpCode.UPDATE.getOperationCode());
				requestDetailsBO.getModel().setSwiftFormatDoc(standardFormat);
			 }			
			standardFormat=null; 
		}else if(FormatType.MODIFIED.equals(formatType)){
			if(actionType.equals(ALOCConstants.DELETE)){
				formatAttachmentBO.getModel().setActionType(OpCode.DELETE.getOperationCode());
				formatAttachmentBO.getModel().setOpCode(OpCode.DELETE.getOperationCode());
				requestDetailsBO.getModel().setSwiftFormatDoc(modifiedFormat);
			}
			else{
				formatAttachmentBO.getModel().setActionType(OpCode.UPDATE.getOperationCode());
				formatAttachmentBO.getModel().setOpCode(OpCode.UPDATE.getOperationCode());
				requestDetailsBO.getModel().setSwiftFormatDoc(modifiedFormat);
			 }			
			modifiedFormat= null;
		}else if(FormatType.NON_STANDARD.equals(formatType)){
			BigInteger instrumentType = requestDetailsBO.getModel().getInstrumentTypeId();
			if(formatAttachmentBO.getModel().getGeFileId() != null){
				List<AttachmentPermission> atmtPermissions = new ArrayList<AttachmentPermission>();
				AttachmentPermission treasury = new AttachmentPermission();
				treasury.setPermissionId(AtmtPermType.TREASURY.getId());
				treasury.setPermissionName(AtmtPermType.TREASURY.name());
				atmtPermissions.add(treasury);
				if(instrumentType != null && (instrumentType.equals(BigInteger.valueOf(InstrumentType.SURETY_BOND.getId())) || instrumentType.equals(BigInteger.valueOf(InstrumentType.RIDER.getId())))){
					AttachmentPermission broker = new AttachmentPermission();
					broker.setPermissionId(AtmtPermType.Surety.getId());
					broker.setPermissionName(AtmtPermType.Surety.name());
					atmtPermissions.add(broker);
				}else{
					AttachmentPermission bank = new AttachmentPermission();
					bank.setPermissionId(AtmtPermType.BANK.getId());
					bank.setPermissionName(AtmtPermType.BANK.name());
					atmtPermissions.add(bank);
				}
				formatAttachmentBO.getModel().setAttachmentPermissions(atmtPermissions);
			}
			requestDetailsBO.getModel().setSwiftFormatDoc(null);
		}
		
		requestDetailsBO.getModel().getFormat().setFormatValue(null);
		formatAttachmentBO.getModel().setActionType(actionType);		
		requestDetailsSectionDAO.saveFormat(requestDetailsBO.getModel());
	}

	/**
	 * This method is used to save Amendment Transaction Parties section
	 * @throws HWFServiceException
	 */
	public void saveAmendmentTP() throws HWFServiceException {
		getRequestDetailsSectionDAO().saveAmendmentTP(getActiveRequestDetails());
	}

	/**
	 *  This method is used to save Instrument Amount/currency section
	 *  @throws HWFServiceException
	 */
	public void saveAmendmentIAC() throws HWFServiceException {
		getRequestDetailsSectionDAO().saveAmendmentIAC(getActiveRequestDetails());
	}

	/** This method is used to save Transaction Parties section
	 * @throws HWFServiceException
	 * 
	 */
	public void saveAmendmentED() throws HWFServiceException {
		getRequestDetailsSectionDAO().saveAmendmentED(getActiveRequestDetails());
	}
	/**
	 *  This method is used to save other changes section
	 *  @throws HWFServiceException
	 */
	public void saveAmendmentOC() throws HWFServiceException {
		getRequestDetailsSectionDAO().saveAmendmentOC(getActiveRequestDetails());
	}
	/**
	 * This method is used to save rider and principal section
	 * @throws HWFServiceException
	 */
	public void saveRiderPrincipal() throws HWFServiceException {
		getRequestDetailsSectionDAO().saveRiderPrincipal(getActiveRequestDetails());
	}

	/**
	 * This method is used to save the rider and Obligee section
	 * @throws HWFServiceException
	 */
	public void saveRiderObligee() throws HWFServiceException {
		getRequestDetailsSectionDAO().saveRiderObligee(getActiveRequestDetails());
	}

	/**
	 * This method is used to save rider Expire date 
	 * @throws HWFServiceException
	 */
	public void saveRiderExpDate() throws HWFServiceException {
		getRequestDetailsSectionDAO().saveRiderExpDate(getActiveRequestDetails());
	}

	/**
	 * This method is used save rider bond information section
	 * @throws HWFServiceException
	 */
	public void saveRiderBondInformation() throws HWFServiceException {
		getRequestDetailsSectionDAO().saveRiderBondInformation(getActiveRequestDetails());
	}

	/**
	 * This method is used to save the rider and delivery Instruction section
	 * @throws HWFServiceException
	 */
	public void saveRiderDeliveryInstructions() throws HWFServiceException {
		getRequestDetailsSectionDAO().saveRiderDeliveryInstructions(getActiveRequestDetails());
	}

	/**
	 * This method is used to fetch the details from Active Request Details 
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
	 * This method is used to get the Active request details
	 * @return RequestDetails
	 */
	private RequestDetails getActiveRequestDetails() {
		return getActiveRequestDetailsBO().getModel();
	}


	/**
	 * This method is for getting the request details section 
	 * @return the requestDetailsSectionDAO
	 */
	public IRequestDetailsSectionDAO getRequestDetailsSectionDAO() {
		return requestDetailsSectionDAO;
	}
	/**
	 * this method is used to set the request details section 
	 * @param requestDetailsSectionDAO the requestDetailsSectionDAO to set
	 */
	public void setRequestDetailsSectionDAO(
			IRequestDetailsSectionDAO requestDetailsSectionDAO) {
		this.requestDetailsSectionDAO = requestDetailsSectionDAO;
	}
	/**
	 * This method is used for getting the attachments added
	 * @return the alocAttachmentManager
	 */
	public IALOCAttachmentManager getAlocAttachmentManager() {
		return alocAttachmentManager;
	}
	/**
	 * This method is used to set aloc attachment manager
	 * @param alocAttachmentManager the alocAttachmentManager to set
	 */
	public void setAlocAttachmentManager(
			IALOCAttachmentManager alocAttachmentManager) {
		this.alocAttachmentManager = alocAttachmentManager;
	}

	/**
	 * This method is used to save Active request details
	 * @return RequestDetails
	 */
	public RequestDetails save(ActionType actionType) throws HWFServiceException {
		RequestDetails requestDetails=getActiveRequestDetails();
		if(requestDetails.getInstrumentTypeId()!=null && InstrumentType.SURETY_BOND.getId() == requestDetails.getInstrumentTypeId().intValue()){
			if(requestDetails.getBondReqDtls()!=null && requestDetails.getAddressDtls()!=null){
				requestDetails = ALOCCommonHelper.setBondReqDtls(requestDetails);
			}
		}
		if(actionType!=null && (ActionType.SAVE).equals(actionType)){
			ALOCCommonHelper.setOpCode(requestDetails, actionType);
		}
		if((requestDetails.getInstrumentTypeId().equals(BigInteger.valueOf(InstrumentType.BANK_GUARANTEE.getId())) || requestDetails.getInstrumentTypeId().equals(BigInteger.valueOf(InstrumentType.LOC.getId()))) && requestDetails.getInstrumentDetails()!=null){
			requestDetails = ALOCCommonHelper.deleteAutoInc(requestDetails);			
		}
		return getRequestDetailsSectionDAO().save(requestDetails);

	}

	/**
	 * This method is used to save Amendment details
	 * @return RequestDetails
	 */
	public RequestDetails saveAmendment() throws HWFServiceException {
		return getRequestDetailsSectionDAO().saveAmendment(getActiveRequestDetails());
	}


	/* (non-Javadoc)
	 * This method is used to save rider details
	 * @see com.ge.aloc.manager.IRequestDetailsSectionManager#saveRider()
	 */
	public RequestDetails saveRider() throws HWFServiceException {
		return getRequestDetailsSectionDAO().saveRider(getActiveRequestDetails());
	}
	
	/**
	 * This method is used to get the standard format document
	 * @param requestId
	 * @param instrumentPurposeId
	 * @param bondTypeId
	 * @param bondSubTypeId
	 * @return String
	 */
	public String getStandardFormatDocument(String requestId,String instrPurposeId,BigInteger bondTypeId,BigInteger bondSubTypeId) throws HWFServiceException {
		return requestDetailsSectionDAO.getStandardFormatDocument(requestId,instrPurposeId,bondTypeId,bondSubTypeId);
	}

	/**
	 * This method is used for creating landing page request
	 * @return RequestDetailsBO
	 */
	public RequestDetailsBO createLandingPageRequest(String siteId,ActionType actionType) throws HWFServiceException {
		RequestDetails requestDetails= getRequestDetailsSectionDAO().createLandingPageRequest(getActiveRequestDetails(), siteId,actionType);
		RequestDetailsBO requestDetailsBO = new RequestDetailsBO(requestDetails);
		ALOCContext.setActiveRequest(requestDetailsBO);
		return requestDetailsBO;

	}

	/**
	 * This method is used to save Active request details
	 * @return RequestDetails
	 */
	public RequestDetails saveRequestDetails() throws HWFServiceException {
		return getRequestDetailsSectionDAO().saveRequestDetails(getActiveRequestDetails());

	}


	/**
	 * This method is used to get the full audit and action log Details
	 * @throws HWFServiceException
	 * @return
	 */
	public RequestDetails getFullAuditandActionLog(String stageName,String logType,BigInteger resquestID,RequestDetails requestDetail) throws HWFServiceException{
		WFDetails wfDetails=new WFDetails();
		wfDetails.setWFStage(stageName);
		requestDetail.setWFDetails(wfDetails);
		requestDetail.setRequestId(resquestID);
		RequestDetails requestDetails=getRequestDetailsSectionDAO().getFullAuditandActionLog(logType,requestDetail);
		return requestDetails;

	}

}
