/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: DealPDFGenerator.java
 * Purpose: file is used to holding leg attachments
 * 
 */
package com.ge.icfp.util.report.pdf;

import jarjar.orgapachecommonsio.output.ByteArrayOutputStream;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ge.icfp.action.ICFPException;
import com.ge.icfp.model.DealRequest;
import com.ge.icfp.util.MasterDataFactory;
import com.ge.icfp.util.StaticDataFactory;
import com.hydus.wff.core.exception.HWFServiceException;
import com.hydus.wff.core.exception.HWFStubException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * This class is the main class to generate pdf report for the current active deal.
 * 
 * @author cnarvan
 */
public class DealPDFGenerator {
	private static final Logger LOGGER = Logger.getLogger(DealPDFGenerator.class);
	
	private DealRequest deal;
	private StaticDataFactory staticDataFactory;
	private MasterDataFactory masterDataFactory;
	private ReportType type;
	
	/**
	 * Constructor to intialize the object
	 * @param deal
	 */
	public DealPDFGenerator(DealRequest deal) {
		this.deal = deal;
	}
	
	/**
	 * This method initializes this class with required data.
	 * 
	 * @param request
	 */
	public void init(HttpServletRequest request, ReportType type) {
		ServletContext context = request.getSession().getServletContext();
		staticDataFactory = (StaticDataFactory) context.getAttribute(StaticDataFactory.CTX_KEY);
		masterDataFactory = (MasterDataFactory) context.getAttribute(MasterDataFactory.CTX_KEY);
		this.type = type;
	}
	
	/**
	 * This method generates the PDF report and returns the data as byte array.
	 * 
	 * @return
	 * @throws ICFPException 
	 * @throws HWFStubException 
	 * @throws HWFServiceException 
	 */
	public byte[] generate() throws ICFPException, HWFServiceException, HWFStubException {
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		process(bout);
		return bout.toByteArray();
	}
	
	/**
	 * This method generates the PDF report and writes to {@link OutputStream}
	 * 
	 * @throws ICFPException 
	 * @throws HWFStubException 
	 * @throws HWFServiceException 
	 * @throws IOException 
	 * 
	 */
	public void generate(OutputStream outStream) throws ICFPException, HWFServiceException, HWFStubException, IOException {
		try {
			process(outStream);
			outStream.flush();
		} finally {
			try {
				outStream.close();
			} catch (IOException e) {
				LOGGER.warn("Error in closing the output stream while generating report for the deal " + deal.getDealSeqId());
				throw new ICFPException("","Error in closing the output stream while generating report for the deal ",e);
			}
		}
	}
	
	/**
	 * This method generates the PDF report and writes to {@link HttpServletResponse}
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ICFPException 
	 * @throws HWFStubException 
	 * @throws HWFServiceException 
	 */
	public void generate(HttpServletRequest request, HttpServletResponse response) throws IOException, ICFPException, HWFServiceException, HWFStubException {
		response.setContentType("application/pdf");
		String fileName = null;
		if(type == ReportType.EXPORT_DEAL) {
			fileName = new StringBuilder().append(deal.getBusinessRequestId()).append("-Export.pdf").toString();
		} else {
			fileName = new StringBuilder().append(deal.getBusinessRequestId()).append("-Underwriting_File.pdf").toString();
		}
		String contentDisposition = new StringBuilder().append("attachment; filename=\"").append(fileName).append("\"").toString();
		response.setHeader("Content-disposition", contentDisposition);
		OutputStream outStream = response.getOutputStream();
		try {
			process(outStream);
			outStream.flush();
		} finally {
			try {
				if(outStream != null) {
					outStream.close();
				}
			} catch (IOException e) {
				LOGGER.warn("Error in closing the output stream while generating report for the deal " + deal.getDealSeqId());
				throw new ICFPException("","Error in closing the output stream while generating report for the deal ",e);
			}
		}
	}
	
	/**
	 * This is helper method to generate PDF report for the current active deal.
	 * 
	 * @param outStream
	 * @throws ICFPException 
	 * @throws HWFStubException 
	 * @throws HWFServiceException 
	 */
	protected void process(OutputStream outStream) throws ICFPException, HWFServiceException, HWFStubException {
		BufferedOutputStream bufOutStream = new BufferedOutputStream(outStream);
		Document document = new Document(PageSize.A4, 36f, 36f, 36f, 36f);
		ReportContext reportContext = createReportContext(document);

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
			DealRenderer.getInstance(reportContext).render();
			int totalPagesBeforeIndex = writer.getPageNumber();
			
			// Writing Table of Content
			document.newPage();
			bodyHeaderAndFooter.setDisplayPageNumber(false); // Stop displaying page numbers for TOC
			printTocTitle(document, writer);
			toc.print(document, writer);
			int totalPages = writer.getPageNumber();
			
			// Reorder pages to bring Table of Content to front.
			int[] reorder = new int[totalPages];
			for(int i = 0; i < totalPages; i++) {
				reorder[i] = i + totalPagesBeforeIndex + 1;
				if(reorder[i] > totalPages) {
					reorder[i] -= totalPages;
				}
			}
			document.newPage();
			writer.reorderPages(reorder);
		} catch (DocumentException e) {
			String errMsg = new StringBuilder().append("Error while generating PDF report of type ").append(type)
					.append(" for the deal ").append(deal.getDealSeqId()).toString();
			throw new ICFPException("", errMsg, e);
		} finally {
			try {
				if(document != null) {
					document.close();
				}
			} catch (Exception e) {
				LOGGER.warn("Error while closing the PDF Body Writer", e);
				throw new ICFPException("","Error while closing the PDF Body Writer",e);
			}
		}
	}
	
	/**
	 * Write title of Table of Content.
	 * 
	 * @param tocDocument
	 * @param tocWriter
	 * @throws DocumentException
	 */
	private void printTocTitle(Document tocDocument, PdfWriter tocWriter) throws DocumentException {
		Phrase heading = new Phrase("Table of content");
		tocDocument.add(heading);
	}

	/**
	 * Creates the {@link ReportContext} object for this deal
	 * 
	 * @return
	 */
	private ReportContext createReportContext(final Document document) {
		return new ReportContext() {
			
			public StaticDataFactory getStaticDataFactory() {
				return staticDataFactory;
			}
			
			public ReportType getReportType() {
				return type;
			}
			
			public MasterDataFactory getMasterDataFactory() {
				return masterDataFactory;
			}
			
			public Document getDocument() {
				return document;
			}
			
			public DealRequest getDeal() {
				return deal;
			}
		};
	}
}
