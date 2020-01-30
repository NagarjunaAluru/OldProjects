/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ReportContext.java
 * Purpose: Context class for PDF report generation
 */
package com.ge.aloc.reports.pdf;

import java.util.ResourceBundle;

import com.ge.aloc.model.RequestDetails;
import com.ge.aloc.ALOCContext;
import com.ge.aloc.MasterDataFactory;
import com.ge.aloc.StaticDataFactory;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.Section;

/**
 * This class provides context information for {@link DealPDFGenerator} and related classes.
 * 
 * @author chaitanya
 *
 */
public class ReportContext {

	private Document document;

	private final ReportType reportType;

	private final String reportFileName;

	private String reportName;

	private int chapterCounter;

	private final ResourceBundle bundle;

	private Chapter currentChapter;

	private Section currentSection;

	/**
	 * Constructor to instantiate this class
	 */
	public ReportContext(ReportType reportType, ResourceBundle bundle, String reportFileName, String reportName) {
		this.reportType = reportType;
		this.bundle = bundle;
		this.reportFileName = reportFileName;
		this.reportName = reportName;
	}

	/**
	 * Returns the deal object of the report
	 * 
	 * @return
	 */
	public RequestDetails getRequestDetails() {
		return ALOCContext.getActiveRequest().getModel();
	}

	/**
	 * Sets the @link {@link Document} object of the report.
	 * 
	 * @param document
	 */
	public void setDocument(Document document) {
		this.document = document;
	}

	/**
	 * Returns the {@link Document} object of the report.
	 * 
	 * @return
	 */
	public Document getDocument() {
		return document;
	}

	/**
	 * Returns the {@link StaticDataFactory}
	 * 
	 * @return
	 */
	public StaticDataFactory getStaticDataFactory() {
		return ALOCContext.getStaticDataFactory();
	}

	/**
	 * Returns the {@link MasterDataFactory}
	 * 
	 * @return
	 */
	public MasterDataFactory getMasterDataFactory() {
		return ALOCContext.getMasterDataFactory();
	}

	/**
	 * Returns the PDF resources of application.
	 * 
	 * @return
	 */
	public ResourceBundle getResourceBundle() {
		return bundle;
	}

	/**
	 * Returns the generating report type.
	 * @return
	 */
	public ReportType getReportType() {
		return this.reportType;
	}

	/**
	 * Returns current chapter number
	 * @return
	 */
	public int getChapterNumber() {
		return chapterCounter;
	}

	/**
	 * Returns next chapter number.
	 * 
	 * @return
	 */
	public int newChapter() {
		return ++chapterCounter;
	}

	/**
	 * Returns the current active chapter of the report.
	 * 
	 * @return the currentChapter
	 */
	public Chapter getCurrentChapter() {
		return currentChapter;
	}

	/**
	 * Sets the current active chapter of the report.
	 * 
	 * @param currentChapter the currentChapter to set
	 */
	public void setCurrentChapter(Chapter currentChapter) {
		this.currentChapter = currentChapter;
	}

	/**
	 * Returns the current active section of the report.
	 * 
	 * @return the currentSection
	 */
	public Section getCurrentSection() {
		return currentSection;
	}

	/**
	 * Sets the current active chapter of the report.
	 * @param currentSection the currentSection to set
	 */
	public void setCurrentSection(Section currentSection) {
		this.currentSection = currentSection;
	}
	/**
	 * 
	 * @return the reportFileName
	 */
	public String getReportFileName() {
		return this.reportFileName;
	}

	/**
	 * @return the reportName
	 */
	public String getReportName() {
		return reportName;
	}

	/**
	 * set the current type of Report Name
	 * @param reportName the reportName to set
	 */
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
}
