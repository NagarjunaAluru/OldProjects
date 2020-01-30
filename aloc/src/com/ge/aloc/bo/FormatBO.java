/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: FormatBO.java
 * Purpose: FormatBO used for the all format operations
 */
package com.ge.aloc.bo;

import java.util.List;

import com.ge.aloc.FormatType;
import com.ge.aloc.model.Format;
import com.ge.aloc.util.AttachmentBOList;
import com.hydus.hwf.util.StringUtils;

/**
 * @author chaitanya.n
 */
public class FormatBO extends AbstractModel<Format> {

	private List<AttachmentBO> attachmentBOList; 

	/**
	 * This is a constructor for format
	 */
	public FormatBO() {
		super(new Format());
	}

	/**
	 * @param model
	 */
	protected FormatBO(Format model) {
		super(model);
	}

	/**
	 * This is used to get the selected format type for format section of requestor
	 * @return
	 */
	public FormatType getFormatType() {
		FormatType formatType = null;
		String formatTypeId = getModel().getFormatTypeId();
		if(StringUtils.isNotBlank(formatTypeId)) {
			formatType = FormatType.fromId(Integer.valueOf(formatTypeId));
		}
		return formatType;
	}

	/**
	 * This is used to get the attachment list for the format section of requestor
	 * @return
	 */
	public List<AttachmentBO> getAttachmentBOList() { 
		if(attachmentBOList == null || ((AttachmentBOList) attachmentBOList).getAttachmentList() != getModel().getAttachments()) {
			attachmentBOList = new AttachmentBOList(getModel().getAttachments());
		}
		return attachmentBOList;
	}

}
