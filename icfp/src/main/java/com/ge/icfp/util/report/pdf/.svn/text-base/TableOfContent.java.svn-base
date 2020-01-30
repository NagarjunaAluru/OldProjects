/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: ReportType.java
 * Purpose: This class generates the TOC of the PDF report.
 */
package com.ge.icfp.util.report.pdf;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * This class generates the Table Of Content for the PDF report.
 * 
 * @author cnarvan
 */
public class TableOfContent extends PdfPageEventHelper {
	
	private static final String BLANK = "";
	
	protected PdfPTable content;
	
	private int indexCounter;
	
	/**
	 * Constructor to create instance of this class.
	 */
	public TableOfContent() {
		content = DealPDFStyle.createTOCTable();
	}
	
	/**
	  * This method generates the TOC entry on start of new section.
	  * 
	  */
	public void onSection(PdfWriter writer, Document document, float paragraphPosition, int depth, Paragraph title) {
		String sectionIndex = String.valueOf(nextIndex());
		
		// Setting index to chunks.
		for(Chunk chunk : title.getChunks()) {
			chunk.setLocalDestination(sectionIndex);
		}
		
		String titleText = (title == null) ? BLANK : title.getContent();
		content.getDefaultCell().setHorizontalAlignment(0);
		Chunk titleChunk = null;
		switch(depth) {
        case 2: // '\002'
            content.getDefaultCell().setIndent(10F);
            titleChunk = new Chunk(titleText, DealPDFStyle.FONT_TOC_SECTION);
            titleChunk.setLocalGoto(sectionIndex);
            content.addCell(new Phrase(titleChunk));
            content.getDefaultCell().setIndent(0.0F);
            content.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
            content.addCell(new Phrase("" + document.getPageNumber(), DealPDFStyle.FONT_TOC_SECTION));
            break;

        default:
            content.getDefaultCell().setIndent(20F);
            titleChunk = new Chunk(titleText, DealPDFStyle.FONT_TOC_SUBSECTION);
            titleChunk.setLocalGoto(sectionIndex);
            content.addCell(new Phrase(titleChunk));
            content.getDefaultCell().setIndent(0.0F);
            content.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
            content.addCell(new Phrase("" + document.getPageNumber(), DealPDFStyle.FONT_TOC_SUBSECTION));
            break;
        }
	}
	
	/**
	 * This method prints the TOC table to the document.
	 * 
	 * @param document
	 * @param writer
	 * @throws DocumentException 
	 */
	public void print(Document document, PdfWriter writer) throws DocumentException {
		document.add(content);
	}
	
	/**
	 * Returns the current index.
	 * 
	 * @return
	 */
	protected int getCurrentIndex() {
		return indexCounter;
	}
	
	/**
	 * Returns the next index
	 * 
	 * @return
	 */
	protected int nextIndex() {
		return ++indexCounter;
	}
}
