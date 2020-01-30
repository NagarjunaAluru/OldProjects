/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ALOCRuntimeException.java
 * Purpose: ALOCRuntimeException used to handle the runtime exceptions.
 */
package com.ge.aloc.exception;

import java.util.ResourceBundle;

import com.hydus.hwf.exceptions.AbstractRuntimeException;

/**
 * @author chaitanya.n
 *
 */
public class ALOCRuntimeException extends AbstractRuntimeException {

	private static final long serialVersionUID = -916503687584220715L;
	public static final String CATEGORY_ID = "ALOC.GENERAL.RUNTIME";
	protected final static ResourceBundle ERRORMSGS_BUNDLE = ResourceBundle.getBundle("alocerrors");

	public static final String EC_CONFIG = "CONFIG";

	public static final String EC_RESOURCE_NOTFOUND = "RESOURCE.NOTFOUND";
	public static final String EC_ROLES_NOTFOUND = "ROLES.NOTFOUND";
	public static final String EC_ACTIVESITE_NOTFOUND = "ACTIVESITE.NOTFOUND";
	public static final String EC_SEARCH_INVALID_AMT_RANGE = "ADVANCESEARCH.INVALID_AMT_RANGE";
	public static final String EC_SEARCH_INVALID_DATE_RANGE = "ADVANCESEARCH.INVALID_DATE_RANGE";
	public static final String EC_SEARCH_INVALID_AMOUNT = "ADVANCESEARCH.INVALID_AMOUNT";
	public static final String EC_ACTIVEREQUEST_NOTFOUND = "ACTIVEREQUEST.NOTFOUND";
	public static final String EC_SEARCH_INVALID_VALUE = "BASICSEARCH.INVALID_VALUE";
	public static final String EC_SEARCH_INVALID_NAME = "BASICSEARCH.INVALID_NAME";

	/**
	 * Constructor with code and message arguments.
	 * 
	 * @param code
	 * @param msgAttributes
	 */
	public ALOCRuntimeException(String code, Object... msgAttributes) {
		super(code, msgAttributes);
	}

	/**
	 * Constructor with code, message and message arguments.
	 * 
	 * @param code
	 * @param message
	 * @param msgAttributes
	 */
	public ALOCRuntimeException(String code, String message, Object... msgAttributes) {
		super(code, message, msgAttributes);
	}

	/**
	 * Constructor with code, message, cause and message arguments.
	 * 
	 * @param code
	 * @param message
	 * @param cause
	 * @param msgAttributes
	 */
	public ALOCRuntimeException(String code, String message, Throwable cause, Object... msgAttributes) {
		super(code, message, cause, msgAttributes);
	}

	/**
	 * Constructor with code, cause and message arguments.
	 * 
	 * @param code
	 * @param cause
	 * @param msgAttributes
	 */
	public ALOCRuntimeException(String code, Throwable cause, Object... msgAttributes) {
		super(code, cause, msgAttributes);
	}

	/**
	 * Resource bundle for error code and message mapping.
	 */
	@Override
	protected ResourceBundle getResourceBundle() {
		return ERRORMSGS_BUNDLE;
	}

	/**
	 * Returns Category ID of the exception
	 */
	@Override
	protected String getCategoryId() {
		return CATEGORY_ID;
	}
}
