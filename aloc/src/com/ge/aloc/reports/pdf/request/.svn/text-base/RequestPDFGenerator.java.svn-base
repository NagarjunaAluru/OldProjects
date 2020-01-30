/*
 * Copyright © 2013 GE. ALL RIGHTS RESERVED.
 * FileName: RequestPDFGenerator.java
 * Purpose: file is used to generate pdf report for the current active request
 * 
 */
package com.ge.aloc.reports.pdf.request;

import java.util.ResourceBundle;

import com.ge.aloc.ALOCContext;
import com.ge.aloc.bo.RequestDetailsBO;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.exception.NoActiveRequestException;
import com.ge.aloc.model.RequestDetails;
import com.ge.aloc.reports.pdf.PDFReportGenerator;
import com.ge.aloc.reports.pdf.ReportContext;
import com.ge.aloc.reports.pdf.ReportRenderer;
import com.ge.aloc.reports.pdf.ReportType;


/**
 * This class is the main class to generate pdf report for the current active request.
 * 
 * @author narasimha
 */
public class RequestPDFGenerator extends PDFReportGenerator {

	public static final String RESOURCE_BUNDLE_FILE_PATH = "i18n/requestpdf";
	private ReportContext context;

	/**
	 * This method initializes this class with required data.
	 * 
	 * @param request
	 */
	public void init(String reportName) {
		RequestDetailsBO activeReqDetailsBO = ALOCContext.getActiveRequest();
		if(activeReqDetailsBO == null) {
			throw new NoActiveRequestException();
		}
		RequestDetails requestDetails = activeReqDetailsBO.getModel();
		ResourceBundle bundle = ResourceBundle.getBundle(RESOURCE_BUNDLE_FILE_PATH);
		StringBuilder reportFileName = new StringBuilder().append(requestDetails.getAlocRecordId()).append(ALOCConstants.HYPEN).append(reportName).append(ALOCConstants.PDF_EXTENSION);
		context = new ReportContext(ReportType.REQUEST, bundle, reportFileName.toString(), reportName);
	}

	@Override
	public ReportContext getReportContext() {
		return context;
	}

	@Override
	protected ReportRenderer getReportRenderer() {
		return new RequestReportRenderer();
	}
}
