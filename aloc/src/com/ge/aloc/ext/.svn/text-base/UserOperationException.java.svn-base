/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: UserOperationException.java
 * Purpose: UserOperationException used for the all external user operations
 */
package com.ge.aloc.ext;

import com.ge.aloc.exception.ALOCException;

/**
 * This is exception class for all user operation related errors.
 * 
 * @author chaitanya.n
 *
 */
public class UserOperationException extends ALOCException {

	private static final long serialVersionUID = -7787847530035712433L;

	public static final String CATEGORY_ID = "ALOC.EXT.USR";

	public static final String EC_NOTAUTHENTICATED = "NOTAUTHENTICATED";
	public static final String EC_NOTFOUND = "NOTFOUND";
	public static final String EC_NOTFOUND_EMAIL = "NOTFOUND.EMAIL";
	public static final String EC_EXISTED = "EXISTED";
	public static final String EC_EXISTED_EMAIL = "EXISTED.EMAIL";
	public static final String EC_EXISTED_MSG = "User already existed";
	public static final String EC_EXISTED_EMAIL_MSG = "Email already existed";
	public static final String EC_EAS_SERVICE = "EAS.SERVICE";
	public static final String EC_MAIL_SEND = "MAIL.SEND";
	public static final String EC_MAIL_CONTENT_CREATION = "MAIL.CONTENT.CREATION";
	public static final String EC_OTP_NOTMATCH = "OTP.NOTMATCH";
	public static final String EC_IDM_APPR_PENDING = "IDM.APPR.PENDING";

	public static final String EAS_USER_NOT_FOUND = "WARN_EAS_USER_NOT_FOUND-/ProcessDefinitions/SubProcesses/EAS/SubProcesses/EASSearch";

	public static final String USER_NOT_FOUND = "USER_NOT_FOUND";

	/**
	 * Constructor to create object of this class
	 * 
	 * @param code
	 * @param msgAttributes
	 */
	public UserOperationException(String code, Object... msgAttributes) {
		super(code, msgAttributes);
	}

	/**
	 * Constructor to create object of this class
	 * 
	 * @param code
	 * @param message
	 * @param msgAttributes
	 */
	public UserOperationException(String code, String message,
			Object... msgAttributes) {
		super(code, message, msgAttributes);
	}

	/**
	 * Constructor to create object of this class
	 * 
	 * @param code
	 * @param message
	 * @param cause
	 * @param msgAttributes
	 */
	public UserOperationException(String code, String message,
			Throwable cause, Object... msgAttributes) {
		super(code, message, cause, msgAttributes);
	}

	/**
	 * Constructor to create object of this class
	 * 
	 * @param code
	 * @param cause
	 * @param msgAttributes
	 */
	public UserOperationException(String code, Throwable cause,
			Object... msgAttributes) {
		super(code, cause, msgAttributes);
	}
	
	/**
	 * Returns Category ID of the exception
	 */
	@Override
	protected String getCategoryId() {
		return CATEGORY_ID;
	}
}
