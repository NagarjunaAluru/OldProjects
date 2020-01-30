/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: ICFPAttachmentException.java
 * Purpose: Exception class for the attachment functionality 
 */
package com.ge.icfp.common.attachments;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import org.apache.commons.lang.StringUtils;

import com.ge.icfp.action.ICFPException;
import com.ge.icfp.model.Attachment;
import com.ge.icfp.util.Utils;

/**
 * @author chaitanya.n
 * This class have all the attachment exceptions
 */
public class ICFPAttachmentException extends ICFPException {

	private static final long serialVersionUID = 8693905896988897279L;
	
	public static final String ERROR_CODE_UPLOAD = "ICFFO_ATMT_001";
	public static final String ERROR_CODE_DOWNLOAD = "ICFFO_ATMT_011";
	public static final String ERROR_CODE_DELETE = "ICFFO_ATMT_016";
	public static final String ERROR_CODE_UPDATEMETA = "ICFFO_ATMT_021";
	public static final String ERROR_CODE_INVALID_FILENAME = "ICFFO_ATMT_031";
	public static final String ERROR_CODE_MULTIPLE_FILES_NOT_ALLOWED = "ICFFO_ATMT_032";
	public static final String ERROR_CODE_INVALID_INPUT_PARAMS = "ICFFO_ATMT_033";
	public static final String ERROR_CODE_INVALID_FILESIZE = "ICFFO_ATMT_034";
	public static final String ERROR_CODE_INVALID_FILEEXTENSION = "ICFFO_ATMT_035";
	public static final String ERROR_CODE_INVALID_CHARSINNAME = "ICFFO_ATMT_036";
	public static final String ERROR_CODE_SERVICEERR = "ICFFO_ATMT_070";
	public static final String ERROR_CODE_SECURITY_RULES = "ICFFO_ATMT_080";
	public static final String ERRO_CODE_VALIDATION_RULE = "ICFFO_ATMT_090";
	public static final String ERROR_CODE_UWFILE_GEN = "ICFFO_ATMT_120";
	
	private static final ResourceBundle ERROR_BUNDLE = ResourceBundle.getBundle("properties/attachment-errors");
	
	private Integer dealSeqId;
	private Attachment attachment;
	private String[] fileExtensions;

	/**
	 * @param code
	 */
	public ICFPAttachmentException(String code) {
		super(code);
	}

	/**
	 * @param code
	 * @param message
	 */
	public ICFPAttachmentException(String code, String message) {
		super(code, message);
	}

	/**
	 * @param code
	 * @param message
	 * @param cause
	 */
	public ICFPAttachmentException(String code, String message, Throwable cause) {
		super(code, message, cause);
	}

	/**
	 * @param code
	 * @param cause
	 */
	public ICFPAttachmentException(String code, Throwable cause) {
		super(code, cause);
	}

	/**
	 * @return the attachment
	 */
	public Attachment getAttachment() {
		return attachment;
	}

	/**
	 * @param attachment the attachment to set
	 */
	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}

	/**
	 * @return the dealSeqId
	 */
	public Integer getDealSeqId() {
		return dealSeqId;
	}

	/**
	 * @param dealSeqId the dealSeqId to set
	 */
	public void setDealSeqId(Integer dealSeqId) {
		this.dealSeqId = dealSeqId;
	}
	
	/**
	 * 
	 */
	public String getMessage() {
        String message = super.getMessage();
        if(message == null) {
        	message = getLocalizedMessage();
        }
        return message;
    }
	
	/**
	 * 
	 */
	public String getLocalizedMessage() {
		if(StringUtils.isNotBlank(code)) {
			String msg = ERROR_BUNDLE.getString(code);
			return MessageFormat.format(msg, getMessageParams());
		} else {
			return getMessage();
		}
	}
	
	/**
	 * 
	 * @return
	 */
	private Object[] getMessageParams() {
		String fileId = (attachment != null) ? attachment.getGeFileId() : null;
		String fileName = (attachment != null) ? attachment.getOrigAttachmentName() : null;
		String type = (attachment != null) ? AttachmentType.fromId(attachment.getAttachmentTypeId()).getName() : null;
		return new String[] {fileId, fileName, type, String.valueOf(dealSeqId), Utils.toString(fileExtensions)};
	}

	public String[] getFileExtensions() {
		return fileExtensions;
	}

	public void setFileExtensions(String[] fileExtensions) {
		this.fileExtensions = fileExtensions;
	}
}
