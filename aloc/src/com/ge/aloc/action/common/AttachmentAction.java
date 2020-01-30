/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: AttachmentAction.java
 * Purpose:AttachmentAction used for the attachments upload, download into local path 
 * and delete from local path as well as gelib
 * 
 */
package com.ge.aloc.action.common;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.web.struts.ActionSupport;

import com.ge.aloc.AttachmentType;
import com.ge.aloc.IRequestDetailsBOAware;
import com.ge.aloc.bo.AttachmentBO;
import com.ge.aloc.bo.FormatBO;
import com.ge.aloc.bo.RequestDetailsBO;
import com.ge.aloc.common.util.AttachmentUtils;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.exception.ALOCAttachmentException;
import com.ge.aloc.exception.ALOCException;
import com.ge.aloc.manager.IALOCAttachmentManager;
import com.ge.aloc.manager.IRequestDetailsManager;
import com.ge.aloc.model.Attachment;
import com.ge.aloc.model.ReferenceNumberValidation;
import com.ge.aloc.model.RequestDetails;
import com.hydus.hwf.exceptions.ErrorData;
import com.hydus.hwf.exceptions.HWFServiceException;
import com.hydus.hwf.exceptions.HWFServiceStubException;
import com.hydus.hwf.exceptions.IErrorHandler;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author rajeswari.guthi
 *
 */
public class AttachmentAction extends ActionSupport implements IRequestDetailsBOAware {

	/**
	 * LOGGER
	 */
	private static final Logger LOGGER = Logger.getLogger(AttachmentAction.class);
	
	private IALOCAttachmentManager alocAttachmentManager;
	protected IRequestDetailsManager requestDetailsManager;
	protected RequestDetailsBO requestDetailsBO;
	protected IErrorHandler errorHandler;
	
	private File fileUpload;
	private String fileUploadContentType;
	private String fileUploadFileName;

	private String geLibFileId;
	private Integer index;
	private Integer typeId;
	private Integer formatId;
	private boolean copyPasteFlag;
	

	// Result Properties
	private String status;
	private String errorCode;
	private String errorMsg;
	private Attachment attachment;
	private String atmtsFlag;


	/**
	 * Method used to upload attachments for particular attachment type and return respective view 
	 * @return
	 * @throws HWFServiceException 
	 * @throws ALOCAttachmentException 
	 * @throws ALOCException
	 * @throws IOException
	 */
	public String upload() throws HWFServiceException, ALOCAttachmentException, ALOCException {
		AttachmentType type = AttachmentType.fromId(typeId, formatId);		
		int atmtCnt = ALOCConstants.ATTACHMENTS_BASE_COUNT;
		switch(type) {
		case OTHER:
			// Make sure attachment is existed at index
			int atmtCount = requestDetailsBO.getAttachmentBOList().size();
			if(index >= atmtCount) {
				for(int i = atmtCount - ALOCConstants.ATTACHMENTS_MIN_COUNT; i <= index; i++) {
					requestDetailsBO.getAttachmentBOList().add(new AttachmentBO());
				}
			}

			attachment = requestDetailsBO.getAttachmentBOList().get(index).getModel();
			break;
		case NON_STANDARD_FORMAT:
			FormatBO formatBO = requestDetailsBO.getFormatBO();
			if(formatBO == null) {
				formatBO = new FormatBO();
				requestDetailsBO.setFormatBO(formatBO);
			}

			// Make sure attachment is existed
			if(formatBO.getAttachmentBOList().isEmpty()) {
				formatBO.getAttachmentBOList().add(new AttachmentBO());
			}

			attachment = formatBO.getAttachmentBOList().get(ALOCConstants.ATTACHMENTS_START_INDEX).getModel();
			break;
		case ISSUER:
			// Make sure attachment is existed
			atmtCnt = requestDetailsBO.getAttachmentBOList().size();
			if(index >= atmtCnt) {
				for(int i = atmtCnt - ALOCConstants.ATTACHMENTS_MIN_COUNT; i <= index; i++) {
					requestDetailsBO.getAttachmentBOList().add(new AttachmentBO());
				}
			}

			attachment = requestDetailsBO.getAttachmentBOList().get(index).getModel();
			//Issuance data mapping.
			requestDetailsBO.getAttachmentBOList().get(index).getModel().setIssuanceDocType(requestDetailsBO.getAttachmentBOList().get(index).getIssuanceDocType());
			if(requestDetailsBO.getAttachmentBOList().get(index).getIssuanceDocType() != null){
				requestDetailsBO.getAttachmentBOList().get(index).getModel().setIssuanceDocTypeId(new BigInteger(requestDetailsBO.getAttachmentBOList().get(index).getIssuanceDocType()));
			}
			requestDetailsBO.getAttachmentBOList().get(index).getModel().setIssuanceBankRefNo(requestDetailsBO.getAttachmentBOList().get(index).getIssuanceBankRefNo());
			requestDetailsBO.getAttachmentBOList().get(index).getModel().setIssuanceDate(requestDetailsBO.getAttachmentBOList().get(index).getIssuanceDate());
			requestDetailsBO.getAttachmentBOList().get(index).getModel().setIssuanceDesc(requestDetailsBO.getAttachmentBOList().get(index).getIssuanceDesc());
			requestDetailsBO.getAttachmentBOList().get(index).getModel().setIssuanceDocument(requestDetailsBO.getAttachmentBOList().get(index).getIssuanceDocument());
			break;
		case CLOSURE:
			// Make sure attachment is existed
			atmtCnt = requestDetailsBO.getAttachmentBOList().size();
			if(index >= atmtCnt) {
				for(int i = atmtCnt - ALOCConstants.ATTACHMENTS_MIN_COUNT; i <= index; i++) {
					requestDetailsBO.getAttachmentBOList().add(new AttachmentBO());
				}
			}

			attachment = requestDetailsBO.getAttachmentBOList().get(index).getModel();
			break;	
		}
		try {
			if(type!= null && type.equals(AttachmentType.ISSUER)){
				ReferenceNumberValidation referenceNumberValidation = new ReferenceNumberValidation();
				if(StringUtils.isNotBlank(requestDetailsBO.getAttachmentBOList().get(index).getIssuanceDocType())){
					referenceNumberValidation.setIssuanceDocTypeId(new BigInteger(requestDetailsBO.getAttachmentBOList().get(index).getIssuanceDocType()));
				}
				referenceNumberValidation.setReferenceNumber(requestDetailsBO.getAttachmentBOList().get(index).getIssuanceBankRefNo());
				referenceNumberValidation.setRequestId(requestDetailsBO.getModel().getRequestId());
				if(StringUtils.isNotBlank(referenceNumberValidation.getReferenceNumber())){
					ReferenceNumberValidation refNoValidation = requestDetailsManager.checkBankRefNumber(referenceNumberValidation);
					referenceNumberValidation.setStatusMessage(refNoValidation.getStatusMessage());
					
					if(referenceNumberValidation != null && StringUtils.isNotBlank(referenceNumberValidation.getStatusMessage()) &&
							referenceNumberValidation.getStatusMessage().equalsIgnoreCase(ALOCConstants.ISSUER_BANKREFNO_EXISTED)){
						ALOCAttachmentException exception = new ALOCAttachmentException(ALOCAttachmentException.EC_INVALID_BANKREFNO);
						exception.setRequestId(referenceNumberValidation.getRequestId());
						throw exception;
					}
				}
			}
			saveAttachment(attachment, type);				
		}catch (ALOCException e) {	
			if(attachment.getGeFileId() !=null &&e.getCode() != null && !e.getCode().equalsIgnoreCase(ALOCAttachmentException.EC_FILE_SIZE_LIMIT)
					&&!e.getCode().equalsIgnoreCase(ALOCAttachmentException.EC_INVALID_FILEEXTENSION)&&!e.getCode().equalsIgnoreCase(ALOCAttachmentException.EC_INVALID_FILENAME)
					&&!e.getCode().equalsIgnoreCase(ALOCAttachmentException.EC_SPECIAL_CHARS_FILENAME)&&!e.getCode().equalsIgnoreCase(ALOCAttachmentException.EC_INVALID_BANKREFNO)
					&&!e.getCode().equalsIgnoreCase(ALOCAttachmentException.EC_NO_METADATA_FOR_FOLDER) && !e.getCode().equalsIgnoreCase(ALOCAttachmentException.EC_UPLOAD)){
				alocAttachmentManager.delete(attachment);
			}
			this.status = ALOCConstants.ERROR;
			ErrorData errorData = errorHandler.handle(e);
			this.errorCode = errorData.getCode();
			this.errorMsg = errorData.getMessage();
			return Action.ERROR;
		}
		this.status = ALOCConstants.STATUS_SUCCESS;
		return Action.SUCCESS;
	}

	/**
	 * Method used to delete attachment for particular type and returns particular view
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HWFServiceException 
	 * @throws IOException
	 */
	public String delete() throws HWFServiceException {
		AttachmentType type = AttachmentType.fromId(typeId, formatId);
		List<AttachmentBO> attachmentBOList = null;
		 
		switch(type) {
		case OTHER:
			attachmentBOList = requestDetailsBO.getAttachmentBOList();
			break;
		case NON_STANDARD_FORMAT:
			attachmentBOList = requestDetailsBO.getFormatBO().getAttachmentBOList();
			break;
		case ISSUER:
			attachmentBOList = requestDetailsBO.getAttachmentBOList();
			break;
		case CLOSURE:
			attachmentBOList = requestDetailsBO.getAttachmentBOList();
			break;	
		}
		AttachmentBO attachmentBO = null;
		for(AttachmentBO atmtBO : attachmentBOList) {
			if(geLibFileId.equalsIgnoreCase(atmtBO.getModel().getGeFileId())) {
				attachmentBO = atmtBO;
				break;
			}
		}
		if(attachmentBO!=null){
			attachment = attachmentBO.getModel();						
			try {
				try{
					alocAttachmentManager.delete(attachment);
				}catch(ALOCAttachmentException ae){
					LOGGER.error(ALOCConstants.ERROR_WHILE_DELETING_FILE + attachment.getAttachmentName(), ae);
				}
				// delete from db 
				requestDetailsManager.deleteAttachments(attachment, type);
				attachmentBOList.remove(attachmentBO); 
			} catch (ALOCException e) {
				this.status = ALOCConstants.ERROR;
				ErrorData errorData = errorHandler.handle(e);
				this.errorCode = errorData.getCode();
				this.errorMsg = errorData.getMessage();
				return Action.ERROR;
			}
		}		
		this.status = ALOCConstants.STATUS_SUCCESS;
		if((type == AttachmentType.CLOSURE || type == AttachmentType.ISSUER)&& copyPasteFlag==true){
			return Action.SUCCESS;
		}
		else {
			return (type == AttachmentType.OTHER) ? ALOCConstants.OTHER_ATTACHMENT_SUCCESS : (type == AttachmentType.ISSUER) ? ALOCConstants.ISSUER_ATTACHMENT_SUCCESS :(type == AttachmentType.CLOSURE) ? ALOCConstants.CLOSURE_ATTACHMENT_SUCCESS : Action.SUCCESS;
		}
	}

	/**
	 *  Method used download file from GELib based on request parameters like GELIb FileID etc
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */

	/** 
	 * This method is used to download the attachment.
	 * @return
	 * @throws IOException 
	 * @throws HWFServiceException
	 */
	public String download() throws IOException, HWFServiceException,HWFServiceStubException,ALOCException {
		AttachmentType type = AttachmentType.fromId(typeId, formatId);
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		String downloadAtmts = request.getParameter(ALOCConstants.ATMTS_BYSESSION);
		OutputStream outputStream = null;
		Attachment attachment = null;

		switch(type) {
		case OTHER:
			if(downloadAtmts != null && downloadAtmts.equalsIgnoreCase(ALOCConstants.TRUE_SMALL)){
				@SuppressWarnings("unchecked")
				List<Attachment> atmtsList = (List<Attachment>)ActionContext.getContext().getSession().get(requestDetailsBO.getModel().getRequestId()+ALOCConstants.UNDERSCORE+ALOCConstants.ATTACHMENTS_BY_TYPE);
				attachment = AttachmentUtils.searchAttachmentByGELibId(geLibFileId,atmtsList);
			}else{
				attachment = AttachmentUtils.searchAttachmentByGELibId(geLibFileId,requestDetailsBO.getModel().getAttachments());
			}
			break;
		case NON_STANDARD_FORMAT:
			attachment = AttachmentUtils.searchAttachmentByGELibId(geLibFileId, requestDetailsBO.getModel().getFormat().getAttachments());
			break;
		case ISSUER:
			attachment = AttachmentUtils.searchAttachmentByGELibId(geLibFileId, requestDetailsBO.getModel().getAttachments());
			break;
		case CLOSURE:
			if(downloadAtmts != null && downloadAtmts.equalsIgnoreCase(ALOCConstants.TRUE_SMALL)){
				@SuppressWarnings("unchecked")
				List<Attachment> taxonomyClosureAtmt = (List<Attachment>)ActionContext.getContext().getSession().get(ALOCConstants.TAXONOMY_CLOSURE_ATTACHMENTS);
				attachment = AttachmentUtils.searchAttachmentByGELibId(geLibFileId,taxonomyClosureAtmt);
			}else{
				attachment = AttachmentUtils.searchAttachmentByGELibId(geLibFileId, requestDetailsBO.getModel().getAttachments());
			}
			break;	
		}
		if (attachment.getAttachmentOriginalName() != null) {
			response.setContentType(ServletActionContext.getServletContext().getMimeType(attachment.getAttachmentOriginalName()));
			response.addHeader(ALOCConstants.HEADER_CONTENT_DISPOSITION,ALOCConstants.CONTENT_DISPOSITION_VALUE	+ attachment.getAttachmentOriginalName());
		}
		try {
			outputStream = response.getOutputStream();
			alocAttachmentManager.downloadAttachment(outputStream,attachment);
		} finally {
			outputStream.flush();
			outputStream.close();
		}
		return null;
	}


	/**
	 * This method saves the attachment.
	 * 
	 * @param attachment
	 * @param type
	 * @throws ALOCAttachmentException
	 * @throws ALOCException
	 * @throws HWFServiceException 
	 */
	private void saveAttachment(Attachment attachment,AttachmentType type) throws ALOCAttachmentException, ALOCException, HWFServiceException {
		boolean deleteAtmt = false;
		Attachment deleteAttachment = null;
		if(attachment != null && attachment.getGeFileId() != null && attachment.getGeFolderId() != null) {
			if(fileUpload!=null && fileUpload.length() > ALOCConstants.FILEUPLOAD_BASE_LENGTH) {				
				alocAttachmentManager.validateAtmtInput(fileUpload, fileUploadFileName);
				deleteAttachment = new Attachment();
				deleteAttachment.setGeFileId(attachment.getGeFileId());
				deleteAttachment.setGeFolderId(attachment.getGeFolderId());
				deleteAttachment.setAttachmentTypeId(attachment.getAttachmentTypeId());
				deleteAttachment.setAttachmentName(attachment.getAttachmentName());
				deleteAttachment.setAttachmentOriginalName(attachment.getAttachmentOriginalName());
				deleteAttachment.setGeLibraryReference(attachment.getGeLibraryReference());
				deleteAtmt = true;
			}
		}
		if(fileUpload!=null && fileUpload.length() > ALOCConstants.FILEUPLOAD_BASE_LENGTH) {				
			attachment = alocAttachmentManager.addAttachment(fileUpload, fileUploadFileName, type, attachment);
		}
		// Make a service call to save new attachment
		requestDetailsManager.saveAttachments(type,attachment);
		
		// Delete Attachment If exists		
		if(deleteAtmt == true){
			try{
				alocAttachmentManager.delete(deleteAttachment);
			}catch(ALOCAttachmentException ae){
				LOGGER.error(ALOCConstants.ERROR_WHILE_DELETING_FILE + deleteAttachment.getAttachmentName(), ae);
			}
		}

	}

	/* -------------------------------------------------------------------------------------------------------------------------------------------------------
	 * 															DEPENDENCY INJECTION METHODS
	 ------------------------------------------------------------------------------------------------------------------------------------------------------- */

	/*
	 * @see com.ge.aloc.IRequestDetailsBOAware#getRequestDetails()
	 * This method is used to get the RequestDetails.
	 */
	public RequestDetails getRequestDetails() {
		return requestDetailsBO.getModel();
	}


	/**
	 * @return the alocAttachmentManager
	 */
	public IALOCAttachmentManager getAlocAttachmentManager() {
		return alocAttachmentManager;
	}



	/* -------------------------------------------------------------------------------------------------------------------------------------------------------
	 * 															PROPERTY GETTER/SETTER METHODS
	 ------------------------------------------------------------------------------------------------------------------------------------------------------- */


	/**
	 * @param alocAttachmentManager the alocAttachmentManager to set
	 */
	public void setAlocAttachmentManager(
			IALOCAttachmentManager alocAttachmentManager) {
		this.alocAttachmentManager = alocAttachmentManager;
	}


	/**
	 * @return the fileUpload
	 */
	public File getFileUpload() {
		return fileUpload;
	}

	/**
	 * @param fileUpload the fileUpload to set
	 */
	public void setFileUpload(File fileUpload) {
		this.fileUpload = fileUpload;
	}

	/**
	 * @return the fileUploadContentType
	 */
	public String getFileUploadContentType() {
		return fileUploadContentType;
	}

	/**
	 * @param fileUploadContentType the fileUploadContentType to set
	 */
	public void setFileUploadContentType(String fileUploadContentType) {
		this.fileUploadContentType = fileUploadContentType;
	}

	/**
	 * @return the fileUploadFileName
	 */
	public String getFileUploadFileName() {
		return fileUploadFileName;
	}

	/**
	 * @param fileUploadFileName the fileUploadFileName to set
	 */
	public void setFileUploadFileName(String fileUploadFileName) {
		this.fileUploadFileName = fileUploadFileName;
	}

	/**
	 * @return the requestDetailsBO
	 */
	public RequestDetailsBO getRequestDetailsBO() {
		return requestDetailsBO;
	}


	/**
	 * @param requestDetailsBO the requestDetailsBO to set
	 */
	public void setRequestDetailsBO(RequestDetailsBO requestDetailsBO) {
		this.requestDetailsBO = requestDetailsBO;
	}




	/**
	 * @return the geLibFileId
	 */
	public String getGeLibFileId() {
		return geLibFileId;
	}


	/**
	 * @param geLibFileId the geLibFileId to set
	 */
	public void setGeLibFileId(String geLibFileId) {
		this.geLibFileId = geLibFileId;
	}


	/**
	 * @return the requestDetailsManager
	 */
	public IRequestDetailsManager getRequestDetailsManager() {
		return requestDetailsManager;
	}

	/**
	 * @param requestDetailsManager the requestDetailsManager to set
	 */
	public void setRequestDetailsManager(
			IRequestDetailsManager requestDetailsManager) {
		this.requestDetailsManager = requestDetailsManager;
	}

	/**
	 * @return the index
	 */
	public Integer getIndex() {
		return index;
	}


	/**
	 * @param index the index to set
	 */
	public void setIndex(Integer index) {
		this.index = index;
	}


	/**
	 * @return the typeId
	 */
	public Integer getTypeId() {
		return typeId;
	}


	/**
	 * @param typeId the typeId to set
	 */
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}


	/**
	 * @return the formatId
	 */
	public Integer getFormatId() {
		return formatId;
	}


	/**
	 * @param formatId the formatId to set
	 */
	public void setFormatId(Integer formatId) {
		this.formatId = formatId;
	}

	/**
	 * @return the copyPasteFlag
	 */
	public boolean isCopyPasteFlag() {
		return copyPasteFlag;
	}

	/**
	 * @param copyPasteFlag the copyPasteFlag to set
	 */
	public void setCopyPasteFlag(boolean copyPasteFlag) {
		this.copyPasteFlag = copyPasteFlag;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @return the errorMsg
	 */
	public String getErrorMsg() {
		return errorMsg;
	}

	/**
	 * @return the attachment
	 */
	public Attachment getAttachment() {
		return attachment;
	}

	/**
	 * @return the errorHander
	 */
	public IErrorHandler getErrorHandler() {
		return errorHandler;
	}

	/**
	 * @param errorHander the errorHander to set 
	 */
	public void setErrorHandler(IErrorHandler errorHandler) {
		this.errorHandler = errorHandler;
	}

	/**
	 * @return the atmtsFlag
	 */
	public String getAtmtsFlag() {
		return atmtsFlag;
	}

	/**
	 * @param atmtsFlag the atmtsFlag to set
	 */
	public void setAtmtsFlag(String atmtsFlag) {
		this.atmtsFlag = atmtsFlag;
	}

}
