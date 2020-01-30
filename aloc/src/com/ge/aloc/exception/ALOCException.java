/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ALOCException.java
 * Purpose: ALOCException used to handle the checked exceptions.
 */
package com.ge.aloc.exception;

import java.util.ResourceBundle;

import com.hydus.hwf.exceptions.AbstractException;


/**
 * @author chaitanya.n
 *
 */
public class ALOCException extends AbstractException {

	private static final long serialVersionUID = -5128259804454021085L;
	public static final String CATEGORY_ID = "ALOC.GENERAL";
	protected final static ResourceBundle ERRORMSGS_BUNDLE = ResourceBundle.getBundle("alocerrors");

	public static final String EC_PROP_ACCESS = "PROPERTY.ACCESS";
	public static final String EC_PROP_SET = "PROPERTY.SET";

	/**
	 * Constructor with code and message arguments.
	 * 
	 * @param code
	 * @param msgAttributes
	 */
	public ALOCException(String code, Object... msgAttributes) {
		super(code, msgAttributes);
	}



	/**
	 * Constructor with code, message and message arguments.
	 * 
	 * @param code
	 * @param message
	 * @param msgAttributes
	 */
	public ALOCException(String code, String message, Object... msgAttributes) {
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
	public ALOCException(String code, String message, Throwable cause, Object... msgAttributes) {
		super(code, message, cause, msgAttributes);
	}

	/**
	 * Constructor with code, cause and message arguments.
	 * 
	 * @param code
	 * @param cause
	 * @param msgAttributes
	 */
	public ALOCException(String code, Throwable cause, Object... msgAttributes) {
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
