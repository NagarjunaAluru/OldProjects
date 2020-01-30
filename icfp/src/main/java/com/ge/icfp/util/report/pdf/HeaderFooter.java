/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: DealRenderer.java
 * Purpose: file is used to holding leg attachments
 * 
 */
package com.ge.icfp.util.report.pdf;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import static com.ge.icfp.common.constants.ICFPConstants.*;

/**
 * This class generates the Header and Footer sections of the report by capturing the events.
 * 
 * @author cnarvan
 */
public class HeaderFooter extends PdfPageEventHelper {
	private ReportContext context;
	private DateFormat dateFormat = null;
	private boolean displayPageNumber;
	
	/**
	 * Constructor to instantiate the class.
	 * 
	 * @param context
	 */
	public HeaderFooter(ReportContext context) {
		this.context = context;
		dateFormat = new SimpleDateFormat(MM_DD_YYYY);
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
		footTable.writeSelectedRows(0, -1, document.leftMargin(), document.bottomMargin(), writer.getDirectContent());
	}
	
	/**
	 * This is helper method to create header of the page.
	 * 
	 * @param writer
	 * @param document
	 * @return
	 */
	protected PdfPTable getHeader(PdfWriter writer, Document document) {
		PdfPTable headerTable = new PdfPTable(2);
		headerTable.setTableEvent(new PdfPTableEvent() {
			public void tableLayout(PdfPTable table, float[][] widths, float[] heights,
					int headerRows, int rowStart, PdfContentByte[] canvases) {
				PdfContentByte lineCb = canvases[1];
				
				float[] lastRow = widths[widths.length - 1];
				float orginX = lastRow[0];
				float orginY = heights[heights.length - 1];
				float rightX = lastRow[lastRow.length - 1];
				
				lineCb.moveTo(orginX, orginY);
				lineCb.lineTo(rightX, orginY);
				lineCb.stroke();
			}
		});
		StringBuilder leftMsg = new StringBuilder().append("[").append(context.getDeal().getDealName()).append("(")
				.append(context.getDeal().getUniqueId()).append(")]");
		Phrase leftMsgPhrase = new Phrase(leftMsg.toString(), DealPDFStyle.FONT_HEADER);
		headerTable.addCell(createCell(leftMsgPhrase, Element.ALIGN_LEFT));
		
		StringBuilder date = new StringBuilder().append("[").append(dateFormat.format(new Date())).append("]");
		Phrase dateMsg = new Phrase(date.toString(), DealPDFStyle.FONT_HEADER);
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
		PdfPTable footerTable = new PdfPTable(3);
		footerTable.setTableEvent(new PdfPTableEvent() {
			public void tableLayout(PdfPTable table, float[][] widths, float[] heights,
					int headerRows, int rowStart, PdfContentByte[] canvases) {
				PdfContentByte lineCb = canvases[1];
				//lineCb.setFontAndSize(BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, false), 24);
				
				float[] topRow = widths[0];
				float topRowStartX = topRow[0];
				float topRowStartY = heights[0];
				float topRowrightX = topRow[topRow.length - 1];
				
				lineCb.moveTo(topRowStartX, topRowStartY);
				lineCb.lineTo(topRowrightX, topRowStartY);
				lineCb.stroke();
			}
		});
		
		String type = (context.getReportType() != null) ? context.getReportType().getName() : "UNKNOWN";
		Phrase footerTitle = new Phrase(type, DealPDFStyle.FONT_FOOTER);
		footerTable.addCell(createCell(footerTitle, Element.ALIGN_LEFT));
		
		Phrase confidential = new Phrase("GE CONFIDENTIAL", DealPDFStyle.FONT_FOOTER);
		footerTable.addCell(createCell(confidential, Element.ALIGN_CENTER));
		
		if(displayPageNumber) {
			Phrase pageNumber = new Phrase("Page " + writer.getPageNumber(), DealPDFStyle.FONT_FOOTER);
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
