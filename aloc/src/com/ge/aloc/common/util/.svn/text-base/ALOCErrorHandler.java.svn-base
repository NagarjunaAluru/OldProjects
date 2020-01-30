/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ALOCErrorHandler.java
 * Purpose: ALOCErrorHandler is global error handler for the application.
 */
package com.ge.aloc.common.util;

import com.ge.aloc.constants.ALOCConstants;
import com.hydus.hwf.exceptions.DefaultErrorHandler;
import com.hydus.hwf.exceptions.ErrorData;
import com.hydus.hwf.exceptions.HWFApplicationException;

/**
 * This class inherits the default functionality of {@link DefaultErrorHandler}.
 * 
 * This class overrides the default behaviour for BW exceptions, it shows the same 
 * error message.
 * 
 * @author cnarvan
 */
public class ALOCErrorHandler extends DefaultErrorHandler {

	/** 
	 * This method logs the exception and returns error information.
	 * 
	 * @see com.hydus.hwf.exceptions.IErrorHandler#handle(java.lang.Throwable)
	 */
	public ErrorData handle(Throwable t) {
		ErrorData errorData = super.handle(t);
		if(t instanceof HWFApplicationException) {
			HWFApplicationException hwfae = (HWFApplicationException) t;
			errorData = new ErrorData(hwfae.getId(), hwfae.getReason() + ALOCConstants.SPACE_COLON_SPACE + hwfae.getDetail(), t);
		}
		return errorData;
	}
}
