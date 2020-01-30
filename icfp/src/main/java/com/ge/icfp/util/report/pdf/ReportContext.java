/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: ReportContext.java
 * Purpose: Context class for PDF report generation
 */
package com.ge.icfp.util.report.pdf;

import java.util.ResourceBundle;

import com.ge.icfp.model.DealRequest;
import com.ge.icfp.util.MasterDataFactory;
import com.ge.icfp.util.StaticDataFactory;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.Section;

/**
 * This class provides context information for {@link DealPDFGenerator} and related classes.
 * 
 * @author chaitanya
 *
 */
public abstract class ReportContext {
	
	public static final String RESOURCE_BUNDLE_FILE_PATH = "properties/PdfReportResources";
	
	private int chapterCounter;
	
	private ResourceBundle bundle;
	
	private Chapter currentChapter;
	
	private Section currentSection;
	
	/**
	 * Constructor to instantiate this class
	 */
	public ReportContext() {
		bundle = ResourceBundle.getBundle(RESOURCE_BUNDLE_FILE_PATH);
	}

	/**
	 * Returns the deal object of the report
	 * 
	 * @return
	 */
	public abstract DealRequest getDeal();
	
	/**
	 * Returns the {@link Document} object of the report.
	 * 
	 * @return
	 */
	public abstract Document getDocument();
	
	/**
	 * Returns the {@link StaticDataFactory}
	 * 
	 * @return
	 */
	public abstract StaticDataFactory getStaticDataFactory();
	
	/**
	 * Returns the {@link MasterDataFactory}
	 * 
	 * @return
	 */
	public abstract MasterDataFactory getMasterDataFactory();
	
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
	public abstract ReportType getReportType();
	
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
}
