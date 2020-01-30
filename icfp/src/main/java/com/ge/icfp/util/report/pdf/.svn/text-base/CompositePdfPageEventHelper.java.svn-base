/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: CompositePdfPageEventHelper.java
 * Purpose: file is used to holding leg attachments
 * 
 */
package com.ge.icfp.util.report.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * This is composite Event Helper to generate hader and footer and Table of contents
 * @author cnarvan
 */
public class CompositePdfPageEventHelper extends PdfPageEventHelper {

	private PdfPageEventHelper[] listeners;

	/**
	 * Constructor to initialize with multiple event helpers
	 * @param listeners
	 */
	public CompositePdfPageEventHelper(PdfPageEventHelper... listeners) {
		this.listeners = listeners;
		if (this.listeners == null) {
			this.listeners = new PdfPageEventHelper[0];
		}
	}

	/**
	 * Event Handler for open document
	 */
	public void onOpenDocument(PdfWriter writer, Document document) {
		for (PdfPageEventHelper listener : listeners) {
			listener.onOpenDocument(writer, document);
		}
	}

	/**
	 * Event handler for start of the page.
	 */
	public void onStartPage(PdfWriter writer, Document document) {
		for (PdfPageEventHelper listener : listeners) {
			listener.onStartPage(writer, document);
		}
	}
	
	/**
	 * Event handler for end of the page
	 */
	public void onEndPage(PdfWriter writer,Document document) {
		for (PdfPageEventHelper listener : listeners) {
			listener.onEndPage(writer, document);
		}
    }
	
	/**
	 * Event handler on close of the document
	 */
	 public void onCloseDocument(PdfWriter writer,Document document) {
		 for (PdfPageEventHelper listener : listeners) {
				listener.onCloseDocument(writer, document);
		 }
	 }
	 
	 /**
	  * Event handler on start of the paragraph
	  */
	 public void onParagraph(PdfWriter writer,Document document,float paragraphPosition) {
		 for (PdfPageEventHelper listener : listeners) {
				listener.onParagraph(writer, document, paragraphPosition);
		 }
	 }
	 
	 /**
	  * Event handler on end of the paragraph
	  */
	 public void onParagraphEnd(PdfWriter writer,Document document,float paragraphPosition) {
		 for (PdfPageEventHelper listener : listeners) {
				listener.onParagraphEnd(writer, document, paragraphPosition);
		 }
	 }
	 
	 /**
	  * Event handler on start of the chapter
	  */
	 public void onChapter(PdfWriter writer,Document document,float paragraphPosition,Paragraph title) {
		 for (PdfPageEventHelper listener : listeners) {
				listener.onChapter(writer, document, paragraphPosition, title);
		 }
	 }
	 
	 /**
	  * Event handler on end of the chapter
	  */
	 public void onChapterEnd(PdfWriter writer,Document document,float position) {
		 for (PdfPageEventHelper listener : listeners) {
				listener.onChapterEnd(writer, document, position);
		 }
	 }
	 
	 /**
	  * Event handler on start of the Section
	  */
	 public void onSection(PdfWriter writer,Document document,float paragraphPosition,int depth,Paragraph title) {
		 for (PdfPageEventHelper listener : listeners) {
				listener.onSection(writer, document, paragraphPosition, depth, title);
		 }
	 }
	 
	 /**
	  * Event handler on end of the Section
	  */
	 public void onSectionEnd(PdfWriter writer,Document document,float position) {
		 for (PdfPageEventHelper listener : listeners) {
				listener.onSectionEnd(writer, document, position);
		 }
	 }
	 
	 /**
	  * Event handler on start of the generic tag.
	  */
	 public void onGenericTag(PdfWriter writer,Document document,Rectangle rect,String text) {
		 for (PdfPageEventHelper listener : listeners) {
				listener.onGenericTag(writer, document, rect, text);
		 }
	 }
}
