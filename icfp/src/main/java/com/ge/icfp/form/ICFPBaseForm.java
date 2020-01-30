/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: ICFPBaseForm.java
 * Purpose: ICFPBaseForm used as generic form for icfp.
 */
package com.ge.icfp.form;

import org.apache.struts.action.ActionForm;

/**
 * @author chaitanya
 *
 */
public class ICFPBaseForm extends ActionForm {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1653253801846569344L;
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
}
