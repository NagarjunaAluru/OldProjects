/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: ICFPException.java
 * Purpose: ICFPException used to handle global exceptions.
 */
package com.ge.icfp.action;

import java.io.IOException;
import java.io.InputStream;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import com.hydus.wff.core.exception.HWFException;

/**
 * This wraps all the application exception 
 * and reads the property file for retrieving proper error message
 *  
 */
public class ICFPException extends Exception {
	private static final String SUCCESSFULLY_LOADED_ICFP_EXCEPTION_PROPERTIES = "Successfully loaded \'icfp-exception.properties\'";
	private static final String UNABLE_TO_LOAD_ICFP_EXCEPTION_PROPERTIES = "Unable to load \'icfp-exception.properties\'";
	private static final String PROPERTIES_ICFP_EXCEPTION_PROPERTIES = "properties/icfp-exception.properties";
	private static final String LOADING_ICFP_EXCEPTION_PROPERTIES = "Loading \'icfp-exception\'.properties ";
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3883984619062811742L;
	/**
	 * LOGGER
	 */
	private static final Logger LOGGER = Logger.getLogger(ICFPException.class);
	/**
	 * bundle
	 */
	protected static ResourceBundle bundle;
	/*
	 * code
	 */
	protected String code;
	/**
	 * reason
	 */
	protected String reason;
	
	/**
	 * Nested class to handle the case of property key not been 
	 * available in properties file
	 */
	private static class ExceptionResources extends PropertyResourceBundle {
		/**
		 * ExceptionResources
		 * @param stream
		 * @throws IOException
		 */
		public ExceptionResources(InputStream stream) throws IOException {
			super(stream);
		}
		/**
		 * handleGetObject
		 */
		public Object handleGetObject(String key) {
	        Object result = super.handleGetObject(key);
	        if(result == null) {
	        	result = key;
	        }
	        return result;
	    }
	}
	
	/*
	 * Loads the icfp-exception.properties file 
	 */
	static {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(LOADING_ICFP_EXCEPTION_PROPERTIES);
		}
		
		InputStream is = HWFException.class.getClassLoader().getResourceAsStream(PROPERTIES_ICFP_EXCEPTION_PROPERTIES);
		try {
			bundle = new ExceptionResources(is);
		} catch (IOException ioe) {
			String errMsg = UNABLE_TO_LOAD_ICFP_EXCEPTION_PROPERTIES;
			LOGGER.error(errMsg, ioe);
			throw new RuntimeException(errMsg, ioe);
		}
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug(SUCCESSFULLY_LOADED_ICFP_EXCEPTION_PROPERTIES);
		}
	}

	/**
	 * Initialize the exception with error code,
	 * Matching message for error code will be looked upon properties file.
	 * 
	 * @param code Error Code
	 */
	public ICFPException(String code) {
		super(bundle.getString(code));
		this.code = code;
		this.reason = bundle.getString(code);
	}
	
	/**
	 * Initialize the exception with error code and reason
	 * Matching message for error code will be looked upon properties file.
	 * 
	 * @param code
	 * @param message
	 */
	public ICFPException(String code, String message) {
		super(message);
		this.code = code;
		this.reason = bundle.getString(code);
	}

	/**
	 * Initialize the exception with error code, reason and pass previous exception
	 * Matching message for error code will be looked upon properties file.
	 * 
	 * @param code
	 * @param message
	 * @param cause
	 */
	public ICFPException(String code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
		this.reason = bundle.getString(code);
	}

	/**
	 * Initialize the exception with error code and pass previous exception
	 * Matching message for error code will be looked upon properties file.
	 *  
	 * @param code
	 * @param cause
	 */
	public ICFPException(String code, Throwable cause) {
		super(cause);
		this.code = code;
		this.reason = bundle.getString(code);
	}
	
	/**
	 * 
	 * @return
	 */
	public String getCode() {
		return code;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getReason() {
		return this.reason;
	}
}
