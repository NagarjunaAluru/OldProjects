/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ALOCAttachmentException.java
 * Purpose: This is Exception class for the attachment functionality. 
 */

package com.ge.aloc.exception;

import java.math.BigInteger;

import org.apache.commons.lang3.StringUtils;

import com.ge.aloc.AttachmentType;
import com.ge.aloc.common.util.BeanUtils;
import com.ge.aloc.model.Attachment;
import com.hydus.hwf.exceptions.ExceptionUtils;

/**
 * @author rajeswari.guthi
 *
 */
public class ALOCAttachmentException extends ALOCException {

	private static final long serialVersionUID = -9071460426031692651L;

	public static final String CATEGORY_ID = "ALOC.ATMT";

	public static final String EC_UPLOAD = "UPLOAD";
	public static final String EC_DOWNLOAD = "DOWNLOAD";
	public static final String EC_DELETE = "DELETE";
	public static final String EC_INVALID_FILENAME = "FILENAME.INVALID";	
	public static final String EC_SPECIAL_CHARS_FILENAME = "FILENAME.SPECIALCHARS";
	public static final String EC_INVALID_INPUT_PARAMS = "INPUT.PARAMS.INVALID";
	public static final String EC_NO_METADATA_FOR_FOLDER = "NO.METADATA.FOR.FOLDER";
	public static final String EC_INVALID_FILEEXTENSION = "FILEEXTENSION.INVALID";
	public static final String EC_FILE_SIZE_LIMIT = "FILE.SIZE.LIMIT";
	public static final String EC_SERVICEERR = "SERVICEERR";
	public static final String EC_INVALID_BANKREFNO = "BANKREFNO.INVALID";

	private Attachment attachment;
	private BigInteger requestId;
	private Integer userAnnouncementID;
	private String[] fileExtensions;

	/**
	 * Constructor with code
	 * 
	 * @param code
	 */
	public ALOCAttachmentException(String code) {
		super(code);
	}

	/**
	 * Constructor with code and message
	 * 
	 * @param code
	 * @param message
	 */
	public ALOCAttachmentException(String code, String message) {
		super(code, message);
	}

	/**
	 * Constructor with code, message and cause
	 * 
	 * @param code
	 * @param message
	 * @param cause
	 */
	public ALOCAttachmentException(String code, String message, Throwable cause) {
		super(code, message, cause);
	}

	/**
	 * Constructor with code and cause
	 * 
	 * @param code
	 * @param cause
	 */
	public ALOCAttachmentException(String code, Throwable cause) {
		super(code, cause);
	}

	/**
	 * This is used to get attachment.
	 * @return the attachment
	 */
	public Attachment getAttachment() {
		return attachment;
	}

	/**
	 * This is used to set attachment attribute
	 * @param attachment the attachment to set
	 */
	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}

	/**
	 * This is used to get request Id attribute
	 * @return the requestId
	 */
	public BigInteger getRequestId() {
		return requestId;
	}

	/**
	 * This is used to set request Id attribute
	 * @param requestId the requestId to set
	 */
	public void setRequestId(BigInteger requestId) {
		this.requestId = requestId;
	}

	/**
	 * This is used to get file Extensions
	 * @return the fileExtensions
	 */
	public String[] getFileExtensions() {
		return fileExtensions;
	}

	/**
	 * This is used to set file extensions attribute
	 * @param fileExtensions the fileExtensions to set
	 */
	public void setFileExtensions(String[] fileExtensions) {
		this.fileExtensions = fileExtensions;
	}

	/**
	 * Returns Category ID of the exception
	 */
	@Override
	protected String getCategoryId() {
		return CATEGORY_ID;
	}

	/**
	 * This method returns localised message from resource bundles
	 */
	public String getLocalizedMessage() {
		String msg = null;
		if(StringUtils.isNotBlank(code)) {
			msg = ExceptionUtils.getFormatedResourceMessage(getResourceBundle(), getCodeWithCategoryId(), getMessageParams());
		} else {
			msg = ExceptionUtils.getFormatedResourceMessage(getResourceBundle(), getCategoryId(), getMessageParams());
		}

		if(StringUtils.isBlank(msg)) {
			msg = getMessage();
		}
		return msg;
	}

	/**
	 * This method is used to get message params.
	 * @return
	 */
	public Object[] getMessageParams() {
		String fileId = (attachment != null) ? attachment.getGeFileId() : null;
		String fileName = (attachment != null) ? attachment.getAttachmentName() : null;		
		String type = (attachment != null) ? AttachmentType.fromId(Integer.valueOf(String.valueOf(attachment.getAttachmentTypeId())).intValue()).getName() : null;
		return new String[] {fileId, fileName, type, String.valueOf(requestId), BeanUtils.toString(fileExtensions)};
	}

	/**
	 * @return the userAnnouncementID
	 */
	public Integer getUserAnnouncementID() {
		return userAnnouncementID;
	}

	/**
	 * @param userAnnouncementID the userAnnouncementID to set
	 */
	public void setUserAnnouncementID(Integer userAnnouncementID) {
		this.userAnnouncementID = userAnnouncementID;
	}
}
