/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ALOCPDFStyle.java
 * Purpose: ALOCPDFStyle used styles for the PDF report
 */
package com.ge.aloc.reports.pdf;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.exception.ALOCRuntimeException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;


/**
 * This class represents the styles for the PDF report.
 * 
 * @author cnarvan
 */
public class ALOCPDFStyle {
	public static final String GE_FONT_FILE = "fonts/GEInspRg.ttf";

	public static final BaseFont FONT_GE_DEFAULT = createDefaultFont();

	public static final Font FONT_REPORT_TITLE = new Font(FONT_GE_DEFAULT, 26);
	public static final Font FONT_HEADING1 = new Font(FONT_GE_DEFAULT, 18);
	public static final Font FONT_HEADING2 = new Font(FONT_GE_DEFAULT, 14);
	public static final Font FONT_HEADING3 = new Font(FONT_GE_DEFAULT, 12);
	public static final Font FONT_NORMAL = new Font(FONT_GE_DEFAULT, 8);
	public static final Font FONT_ITALIC = new Font(FONT_GE_DEFAULT, 8, Font.ITALIC);

	public static final Font FONT_SECTION_HEADING = new Font(FONT_GE_DEFAULT, 10, Font.BOLD);
	public static final Font FONT_FORM_FIELD_TITLE = new Font(FONT_GE_DEFAULT, 7, Font.BOLD);
	public static final Font FONT_FORM_FIELD_VALUE = FONT_NORMAL;

	public static final Font FONT_SECTION_CELL_TITLE = new Font(FONT_GE_DEFAULT, 7, Font.BOLD);
	public static final Font FONT_MULTI_SECTION_TITLE = new Font(FONT_GE_DEFAULT, 8, Font.BOLD);
	public static final Font FONT_SECTION_CELL_VALUE = FONT_NORMAL;

	public static final Font FONT_SUB_SECTION_TITLE = new Font(FONT_GE_DEFAULT, 9, Font.BOLD);

	public static final Font FONT_TABLE_COLUMN_HEADER = new Font(FONT_GE_DEFAULT, 7, Font.BOLD);

	public static final Font FONT_PAGE_HEADER = new Font(FONT_GE_DEFAULT, 9);
	public static final Font FONT_PAGE_FOOTER = new Font(FONT_GE_DEFAULT, 9, Font.NORMAL, new BaseColor(128, 128, 128));

	// TOC
	public static final Font FONT_TOC_TITLE = new Font(FONT_GE_DEFAULT, 16);
	public static final Font FONT_TOC_CHAPTER = new Font(FONT_GE_DEFAULT, 11);
	public static final Font FONT_TOC_SECTION = new Font(FONT_GE_DEFAULT, 9);
	public static final Font FONT_TOC_SUBSECTION = new Font(FONT_GE_DEFAULT, 8);

	public static final String HYPEN = "-";
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
		Section section = chapter.addSection(titlePara, ALOCConstants.BASE_VALUE);
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
		Section section = parent.addSection(titlePara, ALOCConstants.BASE_VALUE);
		return section;
	}

	/**
	 * Creates the Table cell for the form field.
	 * 
	 * @return
	 */
	public static PdfPCell createSummaryFieldCell(String title, String value, boolean oddRow) {
		PdfPTable fieldTable = new PdfPTable(ALOCConstants.MIN_VALUE);
		PdfPCell defaultCell = fieldTable.getDefaultCell();
		defaultCell.setBorder(Rectangle.NO_BORDER);
		defaultCell.setHorizontalAlignment(Element.ALIGN_LEFT);
		if(oddRow) {
			defaultCell.setBackgroundColor(new BaseColor(247, 247, 247));
		}
		fieldTable.addCell(new Phrase(title, FONT_FORM_FIELD_TITLE));
		value = (StringUtils.isBlank(value) ? HYPEN : value);
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
	public static PdfPCell createMultiRowSummaryFieldCell(String title, List<String> values, boolean oddRow) {
		PdfPTable fieldTable = new PdfPTable(ALOCConstants.MIN_VALUE);
		PdfPCell defaultCell = fieldTable.getDefaultCell();
		defaultCell.setBorder(Rectangle.NO_BORDER);
		defaultCell.setHorizontalAlignment(Element.ALIGN_LEFT);
		if(oddRow) {
			defaultCell.setBackgroundColor(new BaseColor(247, 247, 247));
		}
		fieldTable.addCell(new Phrase(title, FONT_FORM_FIELD_TITLE));

		if(values == null || values.isEmpty()) {
			fieldTable.addCell(new Phrase(HYPEN, FONT_FORM_FIELD_VALUE));
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
	public static PdfPCell createEmptySummaryFieldCell(boolean oddRow){
		PdfPCell formFieldCell = new PdfPCell(new Phrase(ALOCConstants.EMPTY_STRING));
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
	public static PdfPTable createSummaryTable(int columns) {
		PdfPTable formTable = new PdfPTable(columns);
		formTable.setWidthPercentage(95);
		formTable.setSpacingBefore(10f);
		formTable.setSpacingAfter(10f);
		return formTable;
	}

	/**
	 * This method used to create section data table
	 * @return
	 */
	public static PdfPTable createSectionDataTable() {
		return createSummaryTable(ALOCConstants.MIN_VALUE);
	}


	/**
	 * This method is used to create multi section data table
	 * @return
	 */
	public static PdfPTable createMultiSectionDataTable() {
		return createSummaryTable(ALOCConstants.SECOND_VALUE);
	}

	/**
	 * This method is used to create section data cell
	 * @param title
	 * @param values
	 * @return
	 */
	public static PdfPCell createSectionDataCell(String title, String... values) {
		PdfPTable fieldTable = new PdfPTable(ALOCConstants.SECOND_VALUE);
		PdfPCell defaultCell = fieldTable.getDefaultCell();
		defaultCell.setBorder(Rectangle.NO_BORDER);
		defaultCell.setHorizontalAlignment(Element.ALIGN_LEFT);
		fieldTable.addCell(new Phrase(title, FONT_SECTION_CELL_TITLE));
		if(title !=null && title.length() > ALOCConstants.BASE_VALUE){
			if(values == null || values.length == ALOCConstants.BASE_VALUE) {
				fieldTable.addCell(new Phrase(HYPEN, FONT_SECTION_CELL_VALUE));
			} else if(values.length == ALOCConstants.MIN_VALUE) {
				String value = (StringUtils.isBlank(values[ALOCConstants.BASE_VALUE]) ? HYPEN : values[ALOCConstants.BASE_VALUE]);
				fieldTable.addCell(new Phrase(value, FONT_SECTION_CELL_VALUE));
			} else {
				PdfPTable valueTable = new PdfPTable(ALOCConstants.MIN_VALUE);
				PdfPCell defaultValueCell = valueTable.getDefaultCell();
				defaultValueCell.setBorder(Rectangle.NO_BORDER);
				defaultValueCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				for(String eachValue : values) {
					valueTable.addCell(new Phrase(eachValue, FONT_SECTION_CELL_VALUE));
				}
				fieldTable.addCell(valueTable);
			}
		}
		PdfPCell formFieldCell = new PdfPCell(fieldTable);
		formFieldCell.setBorder(Rectangle.NO_BORDER);
		formFieldCell.setPaddingBottom(5f);
		return formFieldCell;
	}


	/**
	 * Create a single cell data
	 * @param title
	 * @param values
	 * @return
	 */
	public static PdfPCell createSingleSectionDataCell(String value) {

		PdfPTable valueTable = new PdfPTable(ALOCConstants.MIN_VALUE);
		PdfPCell defaultValueCell = valueTable.getDefaultCell();
		defaultValueCell.setBorder(Rectangle.NO_BORDER);
		defaultValueCell.setHorizontalAlignment(Element.ALIGN_LEFT);
		if (StringUtils.isNotBlank(value)) {
			valueTable.addCell(new Phrase(value, FONT_SECTION_CELL_VALUE));
		} else {
			valueTable.addCell(new Phrase(ALOCConstants.EMPTY_STRING, FONT_SECTION_CELL_VALUE));
		}

		PdfPCell formFieldCell = new PdfPCell(valueTable);
		formFieldCell.setBorder(Rectangle.NO_BORDER);
		formFieldCell.setPaddingBottom(5f);
		return formFieldCell;
	}


	/**
	 * Creates the previous and current section title
	 * @param title
	 * @return
	 */
	public static PdfPCell createMultiSectionTitle(String title) {
		PdfPTable fieldTable = new PdfPTable(ALOCConstants.MIN_VALUE);
		PdfPCell defaultCell = fieldTable.getDefaultCell();
		defaultCell.setBorder(Rectangle.NO_BORDER);
		defaultCell.setHorizontalAlignment(Element.ALIGN_LEFT);
		fieldTable.addCell(new Phrase(title, FONT_MULTI_SECTION_TITLE));
		PdfPCell formFieldCell = new PdfPCell(fieldTable);
		formFieldCell.setBorder(Rectangle.NO_BORDER);
		formFieldCell.setPaddingBottom(10f);
		return formFieldCell;
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
	 * Crates the table data cell.
	 * 
	 * @param data
	 * @return
	 */
	public static PdfPCell createTableDataCell(String data) {
		data = (StringUtils.isBlank(data)) ? HYPEN : data;
		PdfPCell cell = new PdfPCell(new Phrase(data, FONT_NORMAL));
		return cell;
	}

	/**
	 * Crates the table multiple data cells.
	 * 
	 * @param values
	 * @return
	 */
	public static PdfPCell createTableMultipleDataCells(String... values) {
		PdfPTable fieldTable = new PdfPTable(ALOCConstants.MIN_VALUE);
		if(values == null || values.length == ALOCConstants.BASE_VALUE) {
			fieldTable.addCell(new Phrase(HYPEN, FONT_NORMAL));
		} else if(values.length == ALOCConstants.MIN_VALUE) {
			String value = (StringUtils.isBlank(values[ALOCConstants.BASE_VALUE]) ? HYPEN : values[ALOCConstants.BASE_VALUE]);
			fieldTable.addCell(new Phrase(value, FONT_NORMAL));
		} else {
			PdfPTable valueTable = new PdfPTable(ALOCConstants.MIN_VALUE);
			PdfPCell defaultValueCell = valueTable.getDefaultCell();
			defaultValueCell.setBorder(Rectangle.NO_BORDER);
			for(String eachValue : values) {
				valueTable.addCell(new Phrase(eachValue, FONT_NORMAL));
			}
			fieldTable.addCell(valueTable);
		}

		PdfPCell formFieldCell = new PdfPCell(fieldTable);
		return formFieldCell;
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
			throw new ALOCRuntimeException(ALOCRuntimeException.EC_RESOURCE_NOTFOUND, e);
		} catch (IOException e) {
			throw new ALOCRuntimeException(ALOCRuntimeException.EC_CONFIG, e);
		}
	}

	/**
	 * Creates Table Of Contents table for the PDF report.
	 * 
	 * @return
	 */
	public static PdfPTable createTOCTable() {
		PdfPTable toc = new PdfPTable(ALOCConstants.SECOND_VALUE);
		toc.setWidthPercentage(ALOCConstants.MAX_WIDTH);
		toc.getDefaultCell().setUseVariableBorders(true);
		toc.getDefaultCell().setBorderColorBottom(BaseColor.WHITE);
		toc.getDefaultCell().setBorderColorRight(BaseColor.WHITE);
		toc.getDefaultCell().setBorderColorLeft(BaseColor.WHITE);
		toc.getDefaultCell().setBorderColorTop(BaseColor.WHITE);
		toc.getDefaultCell().setPaddingBottom(5);
		return toc;
	}

	/**
	 * Creates the Sub Section Title and Value
	 * @param title
	 * @param value
	 * @return
	 */
	public static PdfPCell createSubSectionDataCell(String title, String value) {

		PdfPTable valueTable = new PdfPTable(6);
		PdfPCell defaultValueCell = valueTable.getDefaultCell();
		defaultValueCell.setBorder(Rectangle.NO_BORDER);
		defaultValueCell.setHorizontalAlignment(Element.ALIGN_LEFT);
		valueTable.addCell(new Phrase(title, FONT_SUB_SECTION_TITLE));
		if(value == null) {
			valueTable.addCell(new Phrase(HYPEN, FONT_SECTION_CELL_VALUE));
		} else {
			String val = (StringUtils.isBlank(value) ? HYPEN : value);
			valueTable.addCell(new Phrase(val, FONT_SECTION_CELL_VALUE));
		}
		valueTable.addCell(ALOCConstants.EMPTY_STRING);
		valueTable.addCell(ALOCConstants.EMPTY_STRING);
		valueTable.addCell(ALOCConstants.EMPTY_STRING);
		valueTable.addCell(ALOCConstants.EMPTY_STRING);

		PdfPCell formFieldCell = new PdfPCell(valueTable);
		formFieldCell.setBorder(Rectangle.BOTTOM);
		formFieldCell.setColspan(ALOCConstants.BASE_VALUE);
		formFieldCell.setHorizontalAlignment(Element.ALIGN_LEFT);
		return formFieldCell;
	}
}
