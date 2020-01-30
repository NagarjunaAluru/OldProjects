/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: AttachmentTag.java
 * This file we are not using now, this was used in previous implementation 
 * Purpose: AttachmentTag used for displaying data in Attachment Screen.
 */

package com.ge.icfp.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.hydus.wff.core.util.PropertyManager;
import static com.ge.icfp.common.constants.ICFPConstants.*; 
/**
 * @author hariprasad.madas
 * 
 * 
 *
 */

/**
 * Note: This file will be deleted once integrated  the common component for attachment
 *
 */
		
public class AttachmentTag extends TagSupport {

	private static final Logger LOGGER = Logger.getLogger(AttachmentTag.class);

	private static final long serialVersionUID = 2011L;
	private String replaceField;
	private String showDiv;
	private String showType;
	private String property;
	private String label;
	private String formName;
	private String attachVOName;
	private String buttonName;
	private String mandatory;

	
	public String getButtonName() {
		return buttonName;
	}

	public void setButtonName(String buttonName) {
		this.buttonName = buttonName;
	}

	public String getAttachVOName() {
		return attachVOName;
	}

	public void setAttachVOName(String attachVOName) {
		this.attachVOName = attachVOName;
	}

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	private String requestProperty;

	public String getRequestProperty() {
		return requestProperty;
	}

	public void setRequestProperty(String requestProperty) {
		this.requestProperty = requestProperty;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}



	public String getMandatory() {
		return mandatory;
	}

	public void setMandatory(String mandatory) {
		this.mandatory = mandatory;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	
	public String getShowDiv() {
		return showDiv;
	}

	public void setShowDiv(String showDiv) {
		this.showDiv = showDiv;
	}
	
	
	public String getReplaceField() {
		return replaceField;
	}

	public void setReplaceField(String replaceField) {
		this.replaceField = replaceField;
	}

	public String getShowType() {
		return showType;
	}

	public void setShowType(String showType) {
		this.showType = showType;
	}

	

	private String getPropertyValue(String property) {

		return StringUtils.isEmpty(property) ? "" : PropertyManager.getString(
				PROPERTIES_APPLICATION, property);
	}

	@Override
	public int doAfterBody() throws JspException {
		return super.doAfterBody();
	}

	@Override
	public int doEndTag() throws JspException {
		return super.doEndTag();
	}

	@Override
	public Tag getParent() {
		return super.getParent();
	}

	@Override
	public void release() {
		super.release();
	}

}
