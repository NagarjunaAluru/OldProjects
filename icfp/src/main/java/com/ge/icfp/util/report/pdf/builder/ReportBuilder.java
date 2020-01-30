/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: ReportBuilder.java
 * Purpose: This class provides functionality for ReportContext.
 */
package com.ge.icfp.util.report.pdf.builder;

import java.util.ResourceBundle;

import com.ge.icfp.model.DealRequest;
import com.ge.icfp.util.MasterDataFactory;
import com.ge.icfp.util.StaticDataFactory;
import com.ge.icfp.util.report.pdf.ReportContext;
import com.ge.icfp.util.report.pdf.ReportType;
import com.itextpdf.text.Document;

/**
 * This class provides functionality for {@link ReportContext}
 * 
 * @author chaitanya
 *
 */
public class ReportBuilder extends ReportContext {
	
	private ReportContext context;
	
	/**
	 * Consturctor to initialize the object.
	 * 
	 */
	protected ReportBuilder(ReportContext context) {
		this.context = context;
	}
	
	/**
	 * Getter method for the {@link ReportContext}
	 * 
	 * @return
	 */
	protected ReportContext getReportContext() {
		return context;
	}

	/**
	 * 
	 */
	public void build() {
	}

	/**
	 * @see ReportContext#getDeal()
	 */
	public DealRequest getDeal() {
		return context.getDeal();
	}

	/**
	 * @see ReportContext#getDocument()
	 */
	public Document getDocument() {
		return context.getDocument();
	}

	/**
	 * @see ReportContext#getStaticDataFactory()
	 */
	public StaticDataFactory getStaticDataFactory() {
		return context.getStaticDataFactory();
	}

	/**
	 * @see ReportContext#getMasterDataFactory()
	 */
	public MasterDataFactory getMasterDataFactory() {
		return context.getMasterDataFactory();
	}

	/**
	 * @see ReportContext#getResourceBundle()
	 */
	public ResourceBundle getResourceBundle() {
		return context.getResourceBundle();
	}

	/**
	 * @see ReportContext#getReportType()
	 */
	public ReportType getReportType() {
		return context.getReportType();
	}
}
