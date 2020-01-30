/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: AttachmentAction.java
 * Purpose:AttachmentAction used for the attachments upload into local path 
 * and delete from local path as well as gelib
 * 
 */
package com.ge.icfp.common.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ge.icfp.action.ICFPBaseAction;
import com.ge.icfp.action.ICFPException;
import com.ge.icfp.common.helper.CurrentDealManager;
import com.ge.icfp.model.DealRequest;
import com.ge.icfp.util.report.pdf.DealPDFGenerator;

/**
 * Generates PDF file with whole deal information upon request
 * 
 * @author hariprasad.madas
 * 
 */
public class ExportToPDFAction extends ICFPBaseAction {
	/**
	 * LOGGER
	 */
	private static Logger LOGGER = Logger.getLogger(ExportToPDFAction.class);

	/**
	 * Method used to Export PDF for all product types
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 * @throws ICFPException
	 */
	public ActionForward exportPDF(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ICFPException {
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		DealPDFGenerator pdfGenerator = new DealPDFGenerator(deal);
		return null;
	}
}
