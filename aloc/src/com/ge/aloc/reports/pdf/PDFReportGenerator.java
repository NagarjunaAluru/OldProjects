/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: PDFReportGenerator.java
 * Purpose: PDFReportGenerator used to generates the PDF report of request details
 */
package com.ge.aloc.reports.pdf;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.reports.ALOCReportException;
import com.hydus.hwf.exceptions.HWFServiceException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * @author narasimhulu.b
 *
 */
public abstract class PDFReportGenerator {

	private static final Logger LOGGER = Logger.getLogger(PDFReportGenerator.class);

	/**
	 * This method is used to initialize
	 */
	public void init(String reportName) {
		getReportContext().setReportName(reportName);
	}

	/**
	 * This method is used to get report type
	 * @return
	 */
	public ReportType getReportType() {
		return getReportContext().getReportType();
	}

	/**
	 * This method generates the PDF report and writes to {@link OutputStream}
	 * @throws ALOCReportException 
	 * @throws HWFServiceException 
	 * 
	 */
	public void generate(OutputStream outStream) throws ALOCReportException, HWFServiceException {
		try {
			process(outStream);
		} finally {
			try {
				if(outStream != null) {
					outStream.close();
				}
			} catch (IOException e) {
				String errMsg = new StringBuilder().append(ALOCConstants.PDF_ERROR_IN_CLOSING_FILE)
						.append(getReportContext().getReportFileName())
						.append(ALOCConstants.OF_THE_TYPE).append(getReportContext().getReportType()).toString();
				LOGGER.warn(errMsg);
				throw new ALOCReportException(ALOCConstants.PDF_ERROR_WHILE_REPORTGENERATING,e);
			}
		}
	}

	/**
	 * This method generates the PDF report and writes to {@link HttpServletResponse}
	 * @throws ALOCReportException 
	 * @throws HWFServiceException 
	 */
	public void generate() throws ALOCReportException, HWFServiceException {
		HttpServletResponse response =ServletActionContext.getResponse();
		response.setContentType(ALOCConstants.ALLOWEDTYPEPDF);
		String fileName = null;
		fileName = new StringBuilder().append(getReportContext().getReportFileName()).toString();
		String contentDisposition = new StringBuilder().append(ALOCConstants.ATTACHMENTFILE).append(fileName).append(ALOCConstants.SLASH).toString();
		response.setHeader(ALOCConstants.CONTENTDESC, contentDisposition);
		OutputStream outStream = null;
		try {
			outStream = response.getOutputStream();
		} catch (IOException ioe) {
			LOGGER.error(ALOCConstants.ERROR_WHILE_ACCESSING, ioe);
			throw new ALOCReportException(ALOCConstants.ERROR_WHILE_ACCESSING,ioe);
		}

		try {
			process(outStream);
		} finally {
			try {
				if(outStream != null) {
					outStream.close();
				}
			} catch (IOException e) {
				String errorMsg = new StringBuilder().append(ALOCConstants.PDF_ERROR_IN_CLOSING_FILE)
						.append(getReportContext().getReportFileName())
						.append(ALOCConstants.OF_THE_TYPE).append(getReportContext().getReportType()).toString();
				LOGGER.warn(errorMsg);
				throw new ALOCReportException(ALOCConstants.ERROR_WHILE_CLOSING_STREAM,e);
			}
		}
	}

	/**
	 * This is helper method to generate PDF report for the current active deal.
	 * @param outStream
	 * @throws ALOCReportException 
	 * @throws HWFServiceException 
	 */
	protected void process(OutputStream outStream) throws ALOCReportException, HWFServiceException {
		BufferedOutputStream bufOutStream = new BufferedOutputStream(outStream);
		Document document = new Document(PageSize.A4, 36f, 36f, 36f, 36f);
		ReportContext reportContext = getReportContext();
		reportContext.setDocument(document);

		try {
			// Initialize Listeners
			TableOfContent toc = new TableOfContent();
			HeaderFooter bodyHeaderAndFooter = new HeaderFooter(reportContext);

			// Initialize Document
			PdfWriter writer = PdfWriter.getInstance(document, bufOutStream);
			writer.setLinearPageMode();
			writer.setPageEvent(new CompositePdfPageEventHelper(bodyHeaderAndFooter, toc));
			document.open();

			// Writing content to document
			getReportRenderer().render(reportContext);
			int totalPagesBeforeIndex = writer.getPageNumber();

			// Writing Table of Content
			document.newPage();
			bodyHeaderAndFooter.setDisplayPageNumber(false); // Stop displaying page numbers for TOC
			printTocTitle(document, writer);
			toc.print(document, writer);
			int totalPages = writer.getPageNumber();

			// Reorder pages to bring Table of Content to front.
			int[] reorder = new int[totalPages];
			for(int i = ALOCConstants.BASE_VALUE; i < totalPages; i++) {
				reorder[i] = i + totalPagesBeforeIndex + ALOCConstants.MIN_VALUE;
				if(reorder[i] > totalPages) {
					reorder[i] -= totalPages;
				}
			}
			document.newPage();
			writer.reorderPages(reorder);
		} catch (DocumentException e) {
			String errMsg = new StringBuilder().append(ALOCConstants.ERROR_WHILE_GENERATING_PDFREPORT).append(getReportContext().getReportFileName())
					.append(ALOCConstants.OF_THE_TYPE).append(getReportContext().getReportType()).toString();
			throw new ALOCReportException(errMsg, e);
		} finally {
			if(document != null) {
				document.close();
			}
		}
	}

	/**
	 * Write title of Table of Content.
	 * @param tocDocument
	 * @param tocWriter
	 * @throws DocumentException
	 */
	protected void printTocTitle(Document tocDocument, PdfWriter tocWriter) throws DocumentException {
		Phrase heading = new Phrase(ALOCConstants.TABLE_OF_CONTENT);
		tocDocument.add(heading);
	}


	/**
	 * This method is used for generate pdf documents add to zip.
	 * @param tocDocument
	 * @param tocWriter
	 * @throws HWFServiceException 
	 * @throws DocumentException
	 */
	public OutputStream addMultiplePDFfilesToZip(OutputStream outStream) throws ALOCReportException, HWFServiceException {
		BufferedOutputStream bufOutStream = new BufferedOutputStream(outStream);
		Document document = new Document(PageSize.A4, 36f, 36f, 36f, 36f);
		ReportContext reportContext = getReportContext();
		reportContext.setDocument(document);
		try {
			// Initialize Listeners
			TableOfContent toc = new TableOfContent();
			HeaderFooter bodyHeaderAndFooter = new HeaderFooter(reportContext);

			// Initialize Document
			PdfWriter writer = PdfWriter.getInstance(document, bufOutStream);
			writer.setLinearPageMode();
			writer.setPageEvent(new CompositePdfPageEventHelper(bodyHeaderAndFooter, toc));
			document.open();

			// Writing content to document
			getReportRenderer().render(reportContext);
			int totalPagesBeforeIndex = writer.getPageNumber();

			// Writing Table of Content
			document.newPage();
			bodyHeaderAndFooter.setDisplayPageNumber(false); // Stop displaying page numbers for TOC
			printTocTitle(document, writer);
			toc.print(document, writer);
			int totalPages = writer.getPageNumber();

			// Reorder pages to bring Table of Content to front.
			int[] reorder = new int[totalPages];
			for(int i = ALOCConstants.BASE_VALUE; i < totalPages; i++) {
				reorder[i] = i + totalPagesBeforeIndex + ALOCConstants.MIN_VALUE;
				if(reorder[i] > totalPages) {
					reorder[i] -= totalPages;
				}
			}
			document.newPage();
			writer.reorderPages(reorder);
			return outStream;

		} catch (DocumentException e) {
			String errMsg = new StringBuilder().append(ALOCConstants.ERROR_WHILE_GENERATING_PDFREPORT).append(getReportContext().getReportFileName())
					.append(ALOCConstants.OF_THE_TYPE).append(getReportContext().getReportType()).toString();
			throw new ALOCReportException(errMsg, e);
		}finally {
			if(document != null) {
				document.close();
			}
		}

	}

	/**
	 * This method is used to get Report context
	 * @return
	 */
	public abstract ReportContext getReportContext(); 

	/**
	 * This method is used to get report render
	 * @return
	 */
	protected abstract ReportRenderer getReportRenderer();
}
