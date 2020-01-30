/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: PDFReportGeneratorFactory.java
 * Purpose: PDFReportGeneratorFactory used to create the PDFGenerator instances based on Report type
 */
package com.ge.aloc.reports.pdf;

import com.ge.aloc.reports.pdf.request.RequestPDFGenerator;

/**
 * This is used to create the PDFGenerator class instances based on Report type
 * @author narasimhulu.b
 *
 */
public class PDFReportGeneratorFactory {

	public static final PDFReportGeneratorFactory INSTANCE = new PDFReportGeneratorFactory();

	/**
	 *This is a pdf report generator factory constructor 
	 */
	protected PDFReportGeneratorFactory() {}

	/**
	 * This method is used to get report generator
	 * @param type
	 * @return
	 */
	public PDFReportGenerator getReportGenerator(ReportType type) {
		PDFReportGenerator reportGenerator = null;
		if(ReportType.REQUEST.equals(type)){
			reportGenerator = new RequestPDFGenerator();
		}else{
			throw new IllegalArgumentException("Invalid report type " + type);
		}
		return reportGenerator;
	}
}
