/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: ContactUsAction.java
 * Purpose: ContactUsAction used for display contact us page.
 */
package com.ge.icfp.common.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hydus.wff.core.struts.BaseAction;
/**
 * Display the Contact us Page
 * @author madhusudhan.gosula
 *
 */
public class ContactUsAction extends BaseAction {
	private static final String CONTACTUSPAGE = "contactuspage";

	/**
	 * Display the Contact us Page
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return forward ActionForward
	 * @throws Exception if ant thing happens
	 */
	public ActionForward execute(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response)
            throws Exception {
		return mapping.findForward(CONTACTUSPAGE);		
	}
}
