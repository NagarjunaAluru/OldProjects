/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ReportRenderer.java
 * Purpose: ReportRenderer class for PDF report generation
 */
package com.ge.aloc.reports.pdf;

import com.ge.aloc.reports.ALOCReportException;
import com.hydus.hwf.exceptions.HWFServiceException;
import com.itextpdf.text.DocumentException;

/**
 * @author narasimhulu.b
 *
 */
public abstract class ReportRenderer {

	private int chapterCounter;

	/**
	 * Returns the next chapter number of the report.
	 * 
	 * @return
	 */
	protected int nextChapterNumber() {
		return ++chapterCounter;
	}

	/**
	 * This method renders the total PDF report for current request.
	 * 
	 * @param context
	 * @throws DocumentException 
	 * @throws ALOCReportException 
	 * @throws HWFServiceException 
	 */
	public abstract void render(ReportContext context) throws DocumentException, ALOCReportException, HWFServiceException;
}
