/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ALOCReportException.java
 * Purpose: ALOCReportException used to handle the checked exceptions
 */
package com.ge.aloc.reports;

import com.ge.aloc.exception.ALOCException;

/**
 * @author narasimhulu.b
 *
 */
public class ALOCReportException extends ALOCException {

	private static final long serialVersionUID = -2783211956057675574L;

	private static final String DEFAULT_CODE = "ALOC_REP_001";

	public static final String EC_REPORT_CREATE = "REPORT.CREATE";
	public static final String EC_REPORT_IO = "REPORT.IO";

	/**
	 * default constructor.
	 */
	public ALOCReportException() {
		super(DEFAULT_CODE);
	}

	/**
	 * constructor with message
	 * @param message
	 */
	public ALOCReportException(String message) {
		super(DEFAULT_CODE, message);
	}

	/**
	 * constructor with code and message
	 * @param code
	 * @param message
	 */
	public ALOCReportException(String code, String message) {
		super(((code == null) ? DEFAULT_CODE : code), message);
	}

	/**
	 * constructor with message and cause
	 * @param message
	 * @param cause
	 */
	public ALOCReportException(String message, Throwable cause) {
		super(DEFAULT_CODE, message, cause);
	}

	/**
	 * constructor with code,message and cause.
	 * @param code
	 * @param message
	 * @param cause
	 */
	public ALOCReportException(String code, String message, Throwable cause) {
		super(((code == null) ? DEFAULT_CODE : code), message, cause);
	}
}
