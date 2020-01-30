/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: DealPDFStyle.java
 * Purpose: file is used to holding leg attachments
 * 
 */
package com.ge.icfp.util.report.pdf;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.lowagie.text.Element;


/**
 * This class represents the styles for the PDF report.
 * 
 * @author cnarvan
 */
public class DealPDFStyle {
	public static final String GE_FONT_FILE = "fonts/GEInspRg.ttf";
	
	public static final BaseFont FONT_GE_DEFAULT = createDefaultFont();
	
	public static final Font FONT_HEADING1 = new Font(FONT_GE_DEFAULT, 18);
	public static final Font FONT_HEADING2 = new Font(FONT_GE_DEFAULT, 14);
	public static final Font FONT_HEADING3 = new Font(FONT_GE_DEFAULT, 12);
	public static final Font FONT_NORMAL = new Font(FONT_GE_DEFAULT, 8);
	public static final Font FONT_ITALIC = new Font(FONT_GE_DEFAULT, 8, Font.ITALIC);
	public static final Font FONT_TITLE = new Font(FONT_GE_DEFAULT, 26);
	
	public static final Font FONT_SECTION_HEADING = new Font(FONT_GE_DEFAULT, 10, Font.BOLD);
	public static final Font FONT_FORM_FIELD_TITLE = new Font(FONT_GE_DEFAULT, 7, Font.BOLD);
	public static final Font FONT_FORM_FIELD_VALUE = FONT_NORMAL;
	public static final Font FONT_TABLE_COLUMN_HEADER = new Font(FONT_GE_DEFAULT, 7, Font.BOLD);
	
	public static final Font FONT_HEADER = new Font(FONT_GE_DEFAULT, 9);
	public static final Font FONT_FOOTER = new Font(FONT_GE_DEFAULT, 9, Font.NORMAL, new BaseColor(128, 128, 128));
	
	// TOC
	public static final Font FONT_TOC_TITLE = new Font(FONT_GE_DEFAULT, 16);
	public static final Font FONT_TOC_CHAPTER = new Font(FONT_GE_DEFAULT, 11);
	public static final Font FONT_TOC_SECTION = new Font(FONT_GE_DEFAULT, 9);
	public static final Font FONT_TOC_SUBSECTION = new Font(FONT_GE_DEFAULT, 8);
	
	/**
	 * Create the new chapter for the report.
	 * 
	 * @param title
	 * @return
	 */
	public static Chapter createChapter(String title, int number) {
		Chapter chapter = (title == null) ? new Chapter(number) : new Chapter(title, number);
		return chapter;
	}
	
	/**
	 * Creates the title of the new {@link Section}
	 * 
	 * @param title
	 * @return
	 */
	public static Paragraph createSectionTitle(String title) {
		Chunk titleChunk = new Chunk(title, FONT_SECTION_HEADING);
		Paragraph titleParagraph = new Paragraph(titleChunk);
		titleParagraph.setSpacingBefore(5f);
		titleParagraph.setSpacingAfter(5f);
		return titleParagraph;
	}
	
	/**
	 * Creates the new {@link Section} for the PDF report.
	 * 
	 * @param chapter
	 * @return
	 */
	public static Section createSection(String title, Chapter chapter) {
		Paragraph titlePara = createSectionTitle(title);
		Section section = chapter.addSection(titlePara, 0);
		return section;
	}
	
	/**
	 * Creates the sub-section title for the PDF report.
	 * @param title
	 * @return
	 */
	public static Paragraph createSubSectionTitle(String title) {
		Chunk titleChunk = new Chunk(title, FONT_SECTION_HEADING);
		Paragraph titleParagraph = new Paragraph(titleChunk);
		titleParagraph.setSpacingBefore(0f);
		titleParagraph.setSpacingAfter(0f);
		return titleParagraph;
	}
	
	/**
	 * Creates the sub-section for the PDF report.
	 * 
	 * @param title
	 * @param parent
	 * @return
	 */
	public static Section createSubSection(String title, Section parent) {
		Paragraph titlePara = createSubSectionTitle(title);
		Section section = parent.addSection(titlePara, 0);
		return section;
	}
	
	/**
	 * Creates the Table cell for the form field.
	 * 
	 * @return
	 */
	public static PdfPCell createFormFieldCell(String title, String value, boolean oddRow) {
		PdfPTable fieldTable = new PdfPTable(1);
		PdfPCell defaultCell = fieldTable.getDefaultCell();
		defaultCell.setBorder(Rectangle.NO_BORDER);
		defaultCell.setHorizontalAlignment(Element.ALIGN_LEFT);
		if(oddRow) {
			defaultCell.setBackgroundColor(new BaseColor(247, 247, 247));
		}
		fieldTable.addCell(new Phrase(title, FONT_FORM_FIELD_TITLE));
		value = (StringUtils.isBlank(value) ? "-" : value);
		fieldTable.addCell(new Phrase(value, FONT_FORM_FIELD_VALUE));
		PdfPCell formFieldCell = new PdfPCell(fieldTable);
		formFieldCell.setBorder(Rectangle.NO_BORDER);
		formFieldCell.setPaddingBottom(5f);
		return formFieldCell;
	}
	
	/**
	 * Creates the table cell for multi-row form field.
	 * 
	 * @param title
	 * @param values
	 * @param oddRow
	 * @return
	 */
	public static PdfPCell createMultiRowFormFieldCell(String title, List<String> values, boolean oddRow) {
		PdfPTable fieldTable = new PdfPTable(1);
		PdfPCell defaultCell = fieldTable.getDefaultCell();
		defaultCell.setBorder(Rectangle.NO_BORDER);
		defaultCell.setHorizontalAlignment(Element.ALIGN_LEFT);
		if(oddRow) {
			defaultCell.setBackgroundColor(new BaseColor(247, 247, 247));
		}
		fieldTable.addCell(new Phrase(title, FONT_FORM_FIELD_TITLE));
		
		if(values == null || values.isEmpty()) {
			fieldTable.addCell(new Phrase("-", FONT_FORM_FIELD_VALUE));
		} else {
			for(String eachValue : values) {
				fieldTable.addCell(new Phrase(eachValue, FONT_FORM_FIELD_VALUE));
			}
		}
		
		PdfPCell formFieldCell = new PdfPCell(fieldTable);
		formFieldCell.setBorder(Rectangle.NO_BORDER);
		formFieldCell.setPaddingBottom(5f);
		return formFieldCell;
	}
	
	/**
	 * Creates the empty form field cell.
	 * 
	 * @return
	 */
	public static PdfPCell createEmptyFormFieldCell(boolean oddRow){
		PdfPCell formFieldCell = new PdfPCell(new Phrase(""));
		formFieldCell.setBorder(Rectangle.NO_BORDER);
		formFieldCell.setPaddingBottom(5f);
		if(oddRow) {
			formFieldCell.setBackgroundColor(new BaseColor(247, 247, 247));
		}
		return formFieldCell;
	}
	
	/**
	 * Creates the form table.
	 * 
	 * @param columns
	 * @return
	 */
	public static PdfPTable createFormTable(int columns) {
		PdfPTable formTable = new PdfPTable(columns);
		formTable.setWidthPercentage(95);
		formTable.setSpacingBefore(10f);
		formTable.setSpacingAfter(10f);
		return formTable;
	}
	
	/**
	 * Creates the table with specified widths of the columns.
	 * 
	 * @param columnWidths
	 * @return
	 */
	public static PdfPTable createTable(float... columnWidths) {
		PdfPTable formTable = new PdfPTable(columnWidths);
		formTable.setWidthPercentage(95f);
		formTable.setSpacingBefore(10f);
		formTable.setSpacingAfter(10f);
		return formTable;
	}
	
	/**
	 * Creates the table header cell
	 * 
	 * @param text
	 * @return
	 */
	public static PdfPCell createTableHeaderCell(String text) {
		PdfPCell cell = new PdfPCell(new Phrase(text, FONT_TABLE_COLUMN_HEADER));
		cell.setBackgroundColor(new BaseColor(165, 195, 214));
		return cell;
	}
	
	/**
	 * Creates the table header cell with specified name and column spane.
	 * 
	 * @param text
	 * @param colspan
	 * @return
	 */
	public static PdfPCell createTableHeaderCell(String text, int colspan) {
		PdfPCell cell = createTableHeaderCell(text);
		cell.setColspan(colspan);
		return cell;
	}
	
	/**
	 * Creates the header cell for derivatives table.
	 * 
	 * @param text
	 * @return
	 */
	public static PdfPCell createDerivativeTableHeaderCell(String text) {
		PdfPCell cell = new PdfPCell(new Phrase(text, FONT_TABLE_COLUMN_HEADER));
		cell.setBackgroundColor(new BaseColor(214, 190, 74));
		return cell;
	}
	
	/**
	 * Creates the header cell for derivatives table with specified name and column span.
	 * 
	 * @param text
	 * @param colspan
	 * @return
	 */
	public static PdfPCell createDerivativeTableHeaderCell(String text, int colspan) {
		PdfPCell cell = createDerivativeTableHeaderCell(text);
		cell.setColspan(colspan);
		return cell;
	}
	
	/**
	 * Crates the table data cell.
	 * 
	 * @param data
	 * @return
	 */
	public static PdfPCell createTableDataCell(String data) {
		data = (StringUtils.isBlank(data)) ? "-" : data;
		PdfPCell cell = new PdfPCell(new Phrase(data, FONT_NORMAL));
		return cell;
	}
	
	/**
	 * Creates the empty table data cell.
	 * 
	 * @return
	 */
	public static PdfPCell createTableEmptyDataCell() {
		PdfPCell cell = new PdfPCell(new Phrase("", FONT_NORMAL));
		return cell;
	}
	
	/**
	 * Creates the table data cell with specified colspan
	 * @param data
	 * @param colspan
	 * @return
	 */
	public static PdfPCell createTableDataCell(String data, int colspan) {
		PdfPCell cell = createTableDataCell(data);
		cell.setColspan(colspan);
		return cell;
	}
	
	/**
	 * Creates the comments table.
	 * 
	 * @param comment
	 * @return
	 */
	public static PdfPTable createCommentTable(String comment) {
		PdfPTable commentsTable = new PdfPTable(1);
		commentsTable.setWidthPercentage(95f);
		commentsTable.setSpacingBefore(10f);
		commentsTable.setSpacingAfter(10f);
		PdfPCell commentsCell = new PdfPCell(new Phrase(comment, FONT_NORMAL));
		commentsCell.setBorderColor(new BaseColor(247, 247, 247));
		commentsTable.addCell(commentsCell);
		return commentsTable;
	}

	/**
	 * Creates the default font for the PDF report.
	 * 
	 * @return
	 * @throws IOException 
	 * @throws DocumentException 
	 */
	private static BaseFont createDefaultFont() {
		try {
			return BaseFont.createFont(GE_FONT_FILE, BaseFont.CP1252, BaseFont.EMBEDDED);
		} catch (DocumentException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Creates Table Of Contents table for the PDF report.
	 * 
	 * @return
	 */
	public static PdfPTable createTOCTable() {
		PdfPTable toc = new PdfPTable(2);
		toc.setWidthPercentage(100);
		toc.getDefaultCell().setUseVariableBorders(true);
		toc.getDefaultCell().setBorderColorBottom(BaseColor.WHITE);
		toc.getDefaultCell().setBorderColorRight(BaseColor.WHITE);
		toc.getDefaultCell().setBorderColorLeft(BaseColor.WHITE);
		toc.getDefaultCell().setBorderColorTop(BaseColor.WHITE);
		toc.getDefaultCell().setPaddingBottom(5);
		return toc;
	}
	
}
