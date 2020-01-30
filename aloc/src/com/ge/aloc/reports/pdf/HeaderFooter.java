/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: HeaderFooter.java
 * Purpose: HeaderFooter used to generates the Header and Footer sections of the report by capturing the events.
 */
package com.ge.aloc.reports.pdf;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.reports.pdf.request.RequestPDFConstants;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPTableEvent;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
/**
 * This class generates the Header and Footer sections of the report by capturing the events.
 * 
 * @author cnarvan
 */
public class HeaderFooter extends PdfPageEventHelper {

	private final ReportContext context;
	private final DateFormat dateFormat;
	private boolean displayPageNumber;

	/**
	 * Constructor to instantiate the class.
	 * 
	 * @param context
	 */
	public HeaderFooter(ReportContext context) {
		this.context = context;
		dateFormat = new SimpleDateFormat(context.getResourceBundle().getString(RequestPDFConstants.RES_KEY_DATE_FORMAT));
		displayPageNumber = true;
	}

	/**
	 * This method renders the header and footer for every page by capturing end page event.
	 * 
	 */
	public void onEndPage(PdfWriter writer, Document document) {
		Rectangle page = document.getPageSize();

		// Writer Header
		PdfPTable headTable = getHeader(writer, document);
		headTable.setTotalWidth(page.getWidth() - document.leftMargin() - document.rightMargin());
		headTable.writeSelectedRows(0, -1, document.leftMargin(), page.getHeight(), writer.getDirectContent());

		// Writer Footer
		PdfPTable footTable = getFooter(writer, document);
		footTable.setTotalWidth(page.getWidth() - document.leftMargin() - document.rightMargin());
		footTable.writeSelectedRows(ALOCConstants.BASE_VALUE, ALOCConstants.BASE_NEGATIVE_VALUE, document.leftMargin(), document.bottomMargin(), writer.getDirectContent());
	}

	/**
	 * This is helper method to create header of the page.
	 * 
	 * @param writer
	 * @param document
	 * @return
	 */
	protected PdfPTable getHeader(PdfWriter writer, Document document) {
		PdfPTable headerTable = new PdfPTable(ALOCConstants.SECOND_VALUE);
		headerTable.setTableEvent(new PdfPTableEvent() {
			public void tableLayout(PdfPTable table, float[][] widths, float[] heights,
					int headerRows, int rowStart, PdfContentByte[] canvases) {
				PdfContentByte lineCb = canvases[ALOCConstants.MIN_VALUE];

				float[] lastRow = widths[widths.length - ALOCConstants.MIN_VALUE];
				float orginX = lastRow[ALOCConstants.BASE_VALUE];
				float orginY = heights[heights.length - ALOCConstants.MIN_VALUE];
				float rightX = lastRow[lastRow.length - ALOCConstants.MIN_VALUE];

				lineCb.moveTo(orginX, orginY);
				lineCb.lineTo(rightX, orginY);
				lineCb.stroke();
			}
		});
		StringBuilder leftMsg = new StringBuilder().append(context.getRequestDetails().getAlocRecordId());
		Phrase leftMsgPhrase = new Phrase(leftMsg.toString(), ALOCPDFStyle.FONT_PAGE_HEADER);
		headerTable.addCell(createCell(leftMsgPhrase, Element.ALIGN_LEFT));

		StringBuilder date = new StringBuilder().append(ALOCConstants.DATE_COLON).append(dateFormat.format(new Date()));
		Phrase dateMsg = new Phrase(date.toString(), ALOCPDFStyle.FONT_PAGE_HEADER);
		headerTable.addCell(createCell(dateMsg, Element.ALIGN_RIGHT));
		return headerTable;
	}

	/**
	 * This is helper method to generate footer of every page.
	 * 
	 * @param writer
	 * @param document
	 * @return
	 */
	protected PdfPTable getFooter(PdfWriter writer, Document document) {
		PdfPTable footerTable = new PdfPTable(ALOCConstants.THREE_COLUMNS);
		footerTable.setTableEvent(new PdfPTableEvent() {
			public void tableLayout(PdfPTable table, float[][] widths, float[] heights,
					int headerRows, int rowStart, PdfContentByte[] canvases) {
				PdfContentByte lineCb = canvases[ALOCConstants.MIN_VALUE];

				float[] topRow = widths[ALOCConstants.BASE_VALUE];
				float topRowStartX = topRow[ALOCConstants.BASE_VALUE];
				float topRowStartY = heights[ALOCConstants.BASE_VALUE];
				float topRowrightX = topRow[topRow.length - ALOCConstants.MIN_VALUE];

				lineCb.moveTo(topRowStartX, topRowStartY);
				lineCb.lineTo(topRowrightX, topRowStartY);
				lineCb.stroke();
			}
		});

		String type = (context.getReportType() != null) ? context.getReportType().getName() : "UNKNOWN";
		Phrase footerTitle = new Phrase(type, ALOCPDFStyle.FONT_PAGE_FOOTER);
		footerTable.addCell(createCell(footerTitle, Element.ALIGN_LEFT));

		Phrase confidential = new Phrase("GE CONFIDENTIAL", ALOCPDFStyle.FONT_PAGE_FOOTER);
		footerTable.addCell(createCell(confidential, Element.ALIGN_CENTER));

		if(displayPageNumber) {
			Phrase pageNumber = new Phrase("Page " + writer.getPageNumber(), ALOCPDFStyle.FONT_PAGE_FOOTER);
			footerTable.addCell(createCell(pageNumber, Element.ALIGN_RIGHT));
		} else {
			footerTable.addCell(createCell(new Phrase(""), Element.ALIGN_RIGHT));
		}
		return footerTable;
	}

	/**
	 * This method creates table cell for header and footer.
	 * 
	 * @return
	 */
	protected PdfPCell createCell() {
		PdfPCell cell = new PdfPCell();
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setVerticalAlignment(Element.ALIGN_BOTTOM);
		return cell;
	}

	/**
	 * This is helper method to create a header and footer table cell with specified data.
	 * 
	 * @param data
	 * @param hAlignment
	 * @return
	 */
	protected PdfPCell createCell(Phrase data, int hAlignment) {
		PdfPCell cell = new PdfPCell(data);
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(hAlignment);
		return cell;
	}

	/**
	 * This method returns true if displayPageNumber flag is set.
	 * 
	 * @return
	 */
	public boolean isDisplayPageNumber() {
		return displayPageNumber;
	}

	/**
	 * This is setter method for displayPageNumber attribute.
	 * 
	 * @param displayPageNumber
	 */
	public void setDisplayPageNumber(boolean displayPageNumber) {
		this.displayPageNumber = displayPageNumber;
	}
}
