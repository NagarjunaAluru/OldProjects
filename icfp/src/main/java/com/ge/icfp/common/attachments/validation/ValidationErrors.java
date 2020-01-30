/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: ValidationErrors.java
 * Purpose: Represents ValidationErrors if attachment or comments not provided
 */
package com.ge.icfp.common.attachments.validation;

import java.text.MessageFormat;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMessage;

import com.ge.icfp.common.attachments.AttachmentType;

/**
 * Class used to Provide the validation Errors if deal and leg attachments and comments not provided
 * @author chaitanya.n
 *
 */
public class ValidationErrors {
	private static final String DEAL_ATMT_ERROR = "error.atmt.type{0}.deal";
	private static final String LEG_ATMT_ERROR = "error.atmt.type{0}.leg{1}";
	private static final String GLOBAL_LEG_ATMT_ERROR = "error.atmt.type{0}.leg";
	private static final String ERR_MSG = "Attachment or comment is mandatory";
	
	private ActionErrors actionErrors = new ActionErrors();
	private MessageFormat dealAtmtMsgFormat = new MessageFormat(DEAL_ATMT_ERROR);
	private MessageFormat legAtmtMsgFormat = new MessageFormat(LEG_ATMT_ERROR);
	private MessageFormat globalAtmtMsgFormat = new MessageFormat(GLOBAL_LEG_ATMT_ERROR);

	/**
	 * 
	 */
	ValidationErrors() {
	}
	
	/**
	 * Method used to add the error if deal attachment not provided
	 * @param type
	 */
	public void addDealAttachmentError(AttachmentType type) {
		String errorKey = dealAtmtMsgFormat.format(new Object[]{type.getId()});
		actionErrors.add(errorKey, new ActionMessage(errorKey, ERR_MSG));
	}
	
	/**
	 * Method used to add the error if leg attachment not provided
	 * @param legIndex
	 * @param type
	 */
	public void addLegAttachmentError(int legIndex, AttachmentType type) {
		String errorKey = legAtmtMsgFormat.format(new Object[]{type.getId(), legIndex});
		actionErrors.add(errorKey, new ActionMessage(errorKey, ERR_MSG));
		
		String globalLegErrorKey = globalAtmtMsgFormat.format(new Object[]{type.getId()});
		if(!actionErrors.get(globalLegErrorKey).hasNext()) {
			actionErrors.add(globalLegErrorKey, new ActionMessage(globalLegErrorKey, ERR_MSG));
		}
	}

	/**
	 * @return the actionErrors
	 */
	ActionErrors getActionErrors() {
		return actionErrors;
	}
}
