/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: ICFPBaseValidatorForm.java
 * Purpose: ICFPBaseValidatorForm used as generic form for icfp.
 */
package com.ge.icfp.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

/**
 * @author chaitanya
 *
 */
public class ICFPBaseValidatorForm extends ValidatorForm {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5660992447479809846L;
	/**
	 * command
	 */
	private String command;
	/**
	 * getCommand
	 * @return
	 */
	public String getCommand() {
		return command;
	}
	/**
	 * setCommand
	 * @param command
	 */
	public void setCommand(String command) {
		this.command = command;
	}
	/**
	 * validate
	 */
	public ActionErrors validate(ActionMapping arg0, HttpServletRequest arg1) {
		
		if("load".equals(command))
			return new ActionErrors();
		
		return super.validate(arg0, arg1);
	}
}
