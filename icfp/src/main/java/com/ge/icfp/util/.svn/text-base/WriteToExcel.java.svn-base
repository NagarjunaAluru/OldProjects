/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: WriteToExcel.java
 * Purpose: WriteToExcel used for writing pipeline Data to Excel
 */
package com.ge.icfp.util;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import jxl.HeaderFooter;
import jxl.SheetSettings;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.PageOrientation;
import jxl.format.PaperSize;
import jxl.format.Pattern;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.apache.log4j.Logger;

import com.ge.icfp.action.ICFPException;
import com.ge.icfp.pipeline.form.ChartInfo;
import com.ge.icfp.pipeline.form.PipelineDetails;
/**
 * 
 * @author arijit.biswas
 *
 */
public class WriteToExcel {
	// Logger using Log4J API
	private static final Logger LOGGER = Logger.getLogger(WriteToExcel.class);
	
	private Properties properties = null;
	private static String propertyFilename = "properties/application.properties";
	private static final int CHART_COLUMNS_COUNT = 15;
	private static final int HEADER_ROW_COUNT = 4;
	private static final int DATA_COLUMN_COUNT = 14;
	private static final int DATA_COLUMN_COUNT_BELOW = 3;
	
	// Following properties declared as instance variables instead of static variable, because of JExcel bug
	private final WritableFont fontNormal = new WritableFont(WritableFont.createFont("GE Inspira"), 12);
	private final WritableFont fontBold = new WritableFont(WritableFont.createFont("GE Inspira"), 12, WritableFont.BOLD);
	private final WritableFont fontBoldWhite = new WritableFont(WritableFont.createFont("GE Inspira"), 12, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.WHITE);
	private final WritableFont fontTitle = new WritableFont(WritableFont.createFont("GE Inspira"), 18, WritableFont.BOLD);
	
	private final WritableCellFormat cellFormatLegend = new WritableCellFormat(fontBold);
	private final WritableCellFormat cellFormatTitle = new WritableCellFormat(fontTitle);
	private final WritableCellFormat cellFormatData = new WritableCellFormat(fontNormal);
	
	private final WritableCellFormat cellFormatHeader = new WritableCellFormat(fontBoldWhite);
	private final WritableCellFormat cellFormatPipelineHeader = new WritableCellFormat(fontBoldWhite);
	private final WritableCellFormat cellFormatSnOHeader = new WritableCellFormat(fontBoldWhite);
	private final WritableCellFormat cellFormatRnAHeader = new WritableCellFormat(fontBoldWhite);
	private final WritableCellFormat cellFormatClosingHeader = new WritableCellFormat(fontBoldWhite);
	
	private final WritableCellFormat cellFormatCompleted = new WritableCellFormat(fontNormal);
	private final WritableCellFormat cellFormatInProgress = new WritableCellFormat(fontNormal);
	private final WritableCellFormat cellFormatNotStarted = new WritableCellFormat(fontNormal);
	
	/**
	 * @throws ICFPException 
	 * 
	 */
	public WriteToExcel() throws ICFPException {
		try {
			cellFormatData.setBorder(Border.ALL, BorderLineStyle.THIN, Colour.GRAY_80);
			cellFormatData.setWrap(true);
			
			cellFormatHeader.setBackground(Colour.BLUE_GREY);
			cellFormatHeader.setAlignment(Alignment.CENTRE);
			cellFormatHeader.setWrap(true);
			cellFormatHeader.setVerticalAlignment(VerticalAlignment.BOTTOM);
			cellFormatHeader.setBorder(Border.ALL, BorderLineStyle.THIN, Colour.GRAY_80);
			
			cellFormatPipelineHeader.setBackground(Colour.BLUE, Pattern.SOLID);
			cellFormatPipelineHeader.setWrap(true);
			cellFormatPipelineHeader.setBorder(Border.ALL, BorderLineStyle.THIN, Colour.GRAY_80);
			cellFormatPipelineHeader.setAlignment(Alignment.CENTRE);
			cellFormatPipelineHeader.setVerticalAlignment(VerticalAlignment.BOTTOM);
			
			cellFormatSnOHeader.setBackground(Colour.DARK_BLUE, Pattern.SOLID);
			cellFormatSnOHeader.setWrap(true);
			cellFormatSnOHeader.setBorder(Border.ALL, BorderLineStyle.THIN, Colour.GRAY_80);
			cellFormatSnOHeader.setAlignment(Alignment.CENTRE);
			cellFormatSnOHeader.setVerticalAlignment(VerticalAlignment.BOTTOM);
			
			cellFormatRnAHeader.setBackground(Colour.LIGHT_BLUE, Pattern.SOLID);
			cellFormatRnAHeader.setWrap(true);
			cellFormatRnAHeader.setBorder(Border.ALL, BorderLineStyle.THIN, Colour.GRAY_80);
			cellFormatRnAHeader.setAlignment(Alignment.CENTRE);
			cellFormatRnAHeader.setVerticalAlignment(VerticalAlignment.BOTTOM);
			
			cellFormatClosingHeader.setBackground(Colour.YELLOW2, Pattern.SOLID);
			cellFormatClosingHeader.setWrap(true);
			cellFormatClosingHeader.setBorder(Border.ALL, BorderLineStyle.THIN, Colour.GRAY_80);
			cellFormatClosingHeader.setAlignment(Alignment.CENTRE);
			cellFormatClosingHeader.setVerticalAlignment(VerticalAlignment.BOTTOM);
			
			cellFormatCompleted.setBackground(Colour.DARK_BLUE, Pattern.SOLID);
			cellFormatCompleted.setWrap(true);
			cellFormatCompleted.setBorder(Border.ALL, BorderLineStyle.THIN, Colour.GRAY_80);
			cellFormatCompleted.setAlignment(Alignment.CENTRE);
			cellFormatCompleted.setVerticalAlignment(VerticalAlignment.CENTRE);
			
			cellFormatInProgress.setBackground(Colour.BLUE, Pattern.SOLID);
			cellFormatInProgress.setWrap(true);
			cellFormatInProgress.setBorder(Border.ALL, BorderLineStyle.THIN, Colour.GRAY_80);
			cellFormatInProgress.setAlignment(Alignment.CENTRE);
			cellFormatInProgress.setVerticalAlignment(VerticalAlignment.CENTRE);
			
			cellFormatNotStarted.setBackground(Colour.SKY_BLUE, Pattern.SOLID);
			cellFormatNotStarted.setWrap(true);
			cellFormatNotStarted.setBorder(Border.ALL, BorderLineStyle.THIN, Colour.GRAY_80);
			cellFormatNotStarted.setAlignment(Alignment.CENTRE);
			cellFormatNotStarted.setVerticalAlignment(VerticalAlignment.CENTRE);
		} catch (WriteException e) {
			LOGGER.error("Error while initializing the Excel sheet format", e);
			throw new ICFPException("", "Error while creating formats for spreadsheet", e);
		}
	}
	
	/**
	 * 
	 * @return {@link Properties}
	 */
	public Properties getProperties() {
		return properties;
	}

	/**
	 * 
	 * @param properties
	 */
	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	/**
	 * 
	 * @param output {@link OutputStream}
	 * @param pipelineDetailList {@link List}
	 * @param tableType {@link String}
	 * @throws IOException
	 * @throws WriteException
	 * @throws ParseException 
	 */
	public void write(OutputStream output, List<PipelineDetails> pipelineDetailList, String tableType , String pipelineType) throws IOException, WriteException, ParseException {
		loadProperties();
		WorkbookSettings wbSettings = new WorkbookSettings();
		wbSettings.setLocale(new Locale("en", "EN"));

		WritableWorkbook workbook = Workbook.createWorkbook(output, wbSettings);
		workbook.setColourRGB(Colour.DARK_BLUE, 29, 71, 159);
		workbook.setColourRGB(Colour.BLUE, 36, 98, 231);
		workbook.setColourRGB(Colour.SKY_BLUE, 140, 207, 255);
		workbook.setColourRGB(Colour.BLUE_GREY, 129, 158, 182);
		workbook.setColourRGB(Colour.LIGHT_BLUE, 76, 156, 213);
		workbook.setColourRGB(Colour.YELLOW2, 248, 196, 94);
		
		int columnCount = 0;
		int rowCount = HEADER_ROW_COUNT + pipelineDetailList.size();
		if(tableType.equals("Show/Hide Chart")){
			workbook.createSheet("Pipeline Details - Progress Chart", 0);
			columnCount = DATA_COLUMN_COUNT;
		}else if(tableType.equals("Show below")){
			workbook.createSheet("Pipeline Details - Below", 0);
			columnCount = DATA_COLUMN_COUNT_BELOW + CHART_COLUMNS_COUNT;
		}else if(tableType.equals("Show to side")){
			workbook.createSheet("Pipeline Details - Side", 0);
			columnCount = DATA_COLUMN_COUNT + CHART_COLUMNS_COUNT;
		}
				
		WritableSheet excelSheet = workbook.getSheet(0);
		SheetSettings sheetSettings = excelSheet.getSettings();
		sheetSettings.setPrintGridLines(true);
		sheetSettings.setPaperSize(PaperSize.LEGAL);
		sheetSettings.setOrientation(PageOrientation.LANDSCAPE);
		sheetSettings.setFitWidth(1);
		sheetSettings.setTopMargin(0.5d);
		sheetSettings.setRightMargin(0.1d);
		sheetSettings.setBottomMargin(0.5d);
		sheetSettings.setLeftMargin(0.1d);
		sheetSettings.setHeaderMargin(0.2d);
		sheetSettings.setFooterMargin(0.2d);
		sheetSettings.setHorizontalCentre(true);
		HeaderFooter footer = new HeaderFooter();
		footer.getLeft().append("Intercompany Finance Pipeline");
		HeaderFooter.Contents footerCenterContents = footer.getCentre();
		footerCenterContents.append("Page ");
		footerCenterContents.appendPageNumber();
		footerCenterContents.append(" of ");
		footerCenterContents.appendTotalPages();
		footer.getRight().appendDate();
		sheetSettings.setFooter(footer);
		sheetSettings.setPrintArea(0, 0, columnCount - 1, rowCount - 1);
		sheetSettings.setPrintTitlesRow(2, 3);
		
		createLabel(excelSheet,tableType, pipelineType);
		createContent(excelSheet, pipelineDetailList,tableType,pipelineType);
			
		workbook.write();
		workbook.close();
	}
	/**
	 * 
	 * @param output
	 * @param searchResultList
	 * @throws IOException
	 * @throws WriteException
	 * @throws ParseException
	 */
	public void searchWrite(OutputStream output, List<PipelineDetails> searchResultList) throws IOException, WriteException, ParseException {
		loadProperties();
		WorkbookSettings wbSettings = new WorkbookSettings();

		wbSettings.setLocale(new Locale("en", "EN"));

		WritableWorkbook workbook = Workbook.createWorkbook(output, wbSettings);
		workbook.setColourRGB(Colour.DARK_BLUE, 29, 71, 159);
		workbook.setColourRGB(Colour.BLUE, 36, 98, 231);
		workbook.setColourRGB(Colour.SKY_BLUE, 140, 207, 255);
		workbook.setColourRGB(Colour.BLUE_GREY, 129, 158, 182);
		workbook.setColourRGB(Colour.LIGHT_BLUE, 76, 156, 213);
		workbook.setColourRGB(Colour.YELLOW2, 248, 196, 94);
		
		workbook.createSheet("Search Details", 0);
		WritableSheet excelSheet = workbook.getSheet(0);
		SheetSettings sheetSettings = excelSheet.getSettings();
		sheetSettings.setPrintGridLines(true);
		sheetSettings.setPaperSize(PaperSize.LEGAL);
		sheetSettings.setOrientation(PageOrientation.LANDSCAPE);
		sheetSettings.setFitWidth(1);
		sheetSettings.setTopMargin(0.5d);
		sheetSettings.setRightMargin(0.1d);
		sheetSettings.setBottomMargin(0.5d);
		sheetSettings.setLeftMargin(0.1d);
		sheetSettings.setHeaderMargin(0.2d);
		sheetSettings.setFooterMargin(0.2d);
		sheetSettings.setHorizontalCentre(true);
		HeaderFooter footer = new HeaderFooter();
		footer.getLeft().append("Intercompany Finance Search Details");
		HeaderFooter.Contents footerCenterContents = footer.getCentre();
		footerCenterContents.append("Page ");
		footerCenterContents.appendPageNumber();
		footerCenterContents.append(" of ");
		footerCenterContents.appendTotalPages();
		footer.getRight().appendDate();
		sheetSettings.setFooter(footer);
		sheetSettings.setPrintArea(0, 0, 13, searchResultList.size() + 1);
		sheetSettings.setPrintTitlesRow(0, 1);
		
		createSearchLabel(excelSheet);
		createSearchContent(excelSheet, searchResultList);
			
		workbook.write();
		workbook.close();
	}

	/**
	 * 
	 * @param sheet {@link WritableSheet}
	 * @param type {@link String}
	 * @throws WriteException
	 */
	private void createLabel(WritableSheet sheet, String type, String pipelineType)
			throws WriteException {
		// Write a few headers
		createHeaders(sheet,type, pipelineType);
		cellMerge(sheet,type, pipelineType);
	}
	/**
	 * 
	 * @param sheet
	 * @throws WriteException
	 */
	private void createSearchLabel(WritableSheet sheet)
			throws WriteException {
		createSearchHeaders(sheet);
		cellSearchMerge(sheet);
	}
	/**
	 * 
	 * @param sheet
	 * @throws WriteException
	 * @throws RowsExceededException
	 */
	private void createSearchHeaders(WritableSheet sheet)  throws WriteException,
	RowsExceededException{
		addCaption(sheet, 0, 0, "#");
		addCaption(sheet, 1, 0, "State");
		addCaption(sheet, 2, 0, "Deal ID");
		addCaption(sheet, 3, 0, "Deal Name");
		addCaption(sheet, 4, 1, "Debt Value");
		addCaption(sheet, 5, 1, "Equity Value");
		addCaption(sheet, 6, 0, "Deal Category");
		addCaption(sheet, 7, 0, "Event");
		addCaption(sheet, 8, 0, "Transaction Owner");
		addCaption(sheet, 9, 0, "Value Date");
		addCaption(sheet, 10, 0, "Number of days remaining");
		addCaption(sheet, 11, 0, "Priority");
		addCaption(sheet, 12, 0, "Work Flow State");
		addCaption(sheet, 13, 0, "Status");
		addCaption(sheet, 4, 0, "(USD Equivalent)");
	}
	/**
	 * 
	 * @param sheet
	 * @throws WriteException
	 * @throws RowsExceededException
	 */
	private void cellSearchMerge(WritableSheet sheet)  throws WriteException,
	RowsExceededException{
		sheet.mergeCells(0, 0, 0, 1);
		sheet.mergeCells(1, 0, 1, 1);
		sheet.mergeCells(2, 0, 2, 1);
		sheet.mergeCells(3, 0, 3, 1);
		sheet.mergeCells(6, 0, 6, 1);
		sheet.mergeCells(7, 0, 7, 1);
		sheet.mergeCells(8, 0, 8, 1);
		sheet.mergeCells(9, 0, 9, 1);
		sheet.mergeCells(10, 0, 10, 1);
		sheet.mergeCells(11, 0, 11, 1);
		sheet.mergeCells(12, 0, 12, 1);
		sheet.mergeCells(13, 0, 13, 1);
		
		sheet.mergeCells(4, 0, 5, 0);
	}
	/**
	 * 
	 * @param sheet {@link WritableSheet}
	 * @param type {@link String}
	 * @throws WriteException
	 * @throws RowsExceededException
	 */
	private void createHeaders(WritableSheet sheet, String type, String pipelineType)  throws WriteException,
	RowsExceededException{
		sheet.addCell(new Label(0, 0, "Intercompany Finance Pipeline", cellFormatTitle));
		
		if(type.equals("Show/Hide Chart")){
			
			addCaption(sheet, 0, 2, properties.getProperty("label.pipelineInbox.table.no"));
			addCaption(sheet, 1, 2, properties.getProperty("label.pipelineInbox.table.requestDate"));
			addCaption(sheet, 2, 2, properties.getProperty("label.pipelineInbox.table.dealId"));
			addCaption(sheet, 3, 2, properties.getProperty("label.pipelineInbox.table.dealName"));
			if("FO".equals(pipelineType)){
				addCaption(sheet, 4, 3, properties.getProperty("label.pipelineInbox.table.debtValue"));
				addCaption(sheet, 5, 3, properties.getProperty("label.pipelineInbox.table.equityValue"));
				addCaption(sheet, 6, 2, properties.getProperty("label.pipelineInbox.table.productType"));
				addCaption(sheet, 7, 2, properties.getProperty("label.pipelineInbox.table.dealCategory"));
				addCaption(sheet, 8, 2, properties.getProperty("label.pipelineInbox.table.transactionOwner"));
				addCaption(sheet, 9, 2, properties.getProperty("label.pipelineInbox.table.regionResponsibility"));
				addCaption(sheet, 10, 2, properties.getProperty("label.pipelineInbox.table.valueDate"));
				addCaption(sheet, 11, 2, "Days Remaining");
				addCaption(sheet, 12, 2, properties.getProperty("label.pipelineInbox.table.priority"));
				addCaption(sheet, 13, 2, properties.getProperty("label.pipelineInbox.table.workFlowStatus"));
				addCaption(sheet, 14, 2, properties.getProperty("label.pipelineInbox.table.status"));
				addCaption(sheet, 4, 2, properties.getProperty("label.pipelineInbox.table.usdEquivalent"));
			}else if("MO".equals(pipelineType)){
				addCaption(sheet, 4, 2, properties.getProperty("label.pipelineInbox.table.valueUSDEquivalent"));
				addCaption(sheet, 5, 2, properties.getProperty("label.pipelineInbox.table.event"));
				addCaption(sheet, 6, 2, properties.getProperty("label.pipelineInbox.table.dealCategory"));
				addCaption(sheet, 7, 2, properties.getProperty("label.pipelineInbox.table.transactionOwner"));
				addCaption(sheet, 8, 2, properties.getProperty("label.pipelineInbox.table.standardException"));
				addCaption(sheet, 9, 2, properties.getProperty("label.pipelineInbox.table.regionResponsibility"));
				addCaption(sheet, 10, 2, properties.getProperty("label.pipelineInbox.table.valueDate"));
				addCaption(sheet, 11, 2, "Days Remaining");
				addCaption(sheet, 12, 2, properties.getProperty("label.pipelineInbox.table.priority"));
				addCaption(sheet, 13, 2, properties.getProperty("label.pipelineInbox.table.workFlowStatus"));
				addCaption(sheet, 14, 2, properties.getProperty("label.pipelineInbox.table.status"));
			}
		}else if(type.equals("Show below")){
			
			sheet.addCell(new Label(8, 0, "", cellFormatCompleted));
			sheet.addCell(new Label(9, 0, "Completed or Not Applicable", cellFormatLegend));
			sheet.addCell(new Label(13, 0, "", cellFormatInProgress));
			sheet.addCell(new Label(14, 0, "In Progress", cellFormatLegend));
			sheet.addCell(new Label(17, 0, "", cellFormatNotStarted));
			sheet.addCell(new Label(18, 0, "Not Started", cellFormatLegend));
			
			addCaption(sheet, 0, 2, properties.getProperty("label.pipelineInbox.table.no"));
			addCaption(sheet, 1, 2, properties.getProperty("label.pipelineInbox.table.requestDate"));
			addCaption(sheet, 2, 2, properties.getProperty("label.pipelineInbox.table.dealId"));
			addCaption(sheet, 3, 2, properties.getProperty("label.pipelineInbox.table.dealName"));
			addPipelineHeader(sheet, 4, 2, "Pipeline");
			
			addSNOHeader(sheet, 5, 3, "Front Office");
			addSNOHeader(sheet, 6, 3, "Transfer Pricing");
			addSNOHeader(sheet, 7, 3, "Treasury Tax");
			addSNOHeader(sheet, 8, 3, "Regulatory/Jurisdictional Reviews");
			addSNOHeader(sheet, 9, 3, "Legal");
			addSNOHeader(sheet, 10, 3, "Middle Office");
			addSNOHeader(sheet, 11, 3, "Cash Opperations");
			
			addRiskHeader(sheet, 12, 3, "Risk Management");
			addRiskHeader(sheet, 13, 3, "Business Finance");
			addRiskHeader(sheet, 14, 3, "IDAG");
			addRiskHeader(sheet, 15, 3, "TESG");
			
			addCaption3(sheet, 16, 3, "Additional Reviewers");
			addCaption3(sheet, 17, 3, "Docs. & Certify");
			addCaption3(sheet, 18, 3, "Booking and Close");
			
			addCaption(sheet, 5, 2, "Structuring & Underwriting");
			addCaption(sheet, 12, 2, "Reviews & Approvals");
			addCaption(sheet, 16, 2, "Closing");
			
		}else if(type.equals("Show to side")){
			
			sheet.addCell(new Label(14, 0, "", cellFormatCompleted));
			sheet.addCell(new Label(15, 0, "Completed or Not Applicable", cellFormatLegend));
			sheet.addCell(new Label(19, 0, "", cellFormatInProgress));
			sheet.addCell(new Label(20, 0, "In Progress", cellFormatLegend));
			sheet.addCell(new Label(23, 0, "", cellFormatNotStarted));
			sheet.addCell(new Label(24, 0, "Not Started", cellFormatLegend));
			addCaption(sheet, 0, 2, properties.getProperty("label.pipelineInbox.table.no"));
			addCaption(sheet, 1, 2, properties.getProperty("label.pipelineInbox.table.requestDate"));
			addCaption(sheet, 2, 2, properties.getProperty("label.pipelineInbox.table.dealId"));
			addCaption(sheet, 3, 2, properties.getProperty("label.pipelineInbox.table.dealName"));
			if("FO".equals(pipelineType)){
				addCaption(sheet, 4, 3, properties.getProperty("label.pipelineInbox.table.debtValue"));
				addCaption(sheet, 5, 3, properties.getProperty("label.pipelineInbox.table.equityValue"));
				addCaption(sheet, 6, 2, properties.getProperty("label.pipelineInbox.table.productType"));
				addCaption(sheet, 7, 2, properties.getProperty("label.pipelineInbox.table.dealCategory"));
				addCaption(sheet, 8, 2, properties.getProperty("label.pipelineInbox.table.transactionOwner"));
				addCaption(sheet, 9, 2, properties.getProperty("label.pipelineInbox.table.regionResponsibility"));
				addCaption(sheet, 10, 2, properties.getProperty("label.pipelineInbox.table.valueDate"));
				addCaption(sheet, 11, 2, "Days Remaining");
				addCaption(sheet, 12, 2, properties.getProperty("label.pipelineInbox.table.priority"));
				addCaption(sheet, 13, 2, properties.getProperty("label.pipelineInbox.table.workFlowStatus"));
				addCaption(sheet, 14, 2, properties.getProperty("label.pipelineInbox.table.status"));
				addCaption(sheet, 4, 2, properties.getProperty("label.pipelineInbox.table.usdEquivalent"));
			}else if("MO".equals(pipelineType)){
				addCaption(sheet, 4, 2, properties.getProperty("label.pipelineInbox.table.valueUSDEquivalent"));
				addCaption(sheet, 5, 2, properties.getProperty("label.pipelineInbox.table.event"));
				addCaption(sheet, 6, 2, properties.getProperty("label.pipelineInbox.table.dealCategory"));
				addCaption(sheet, 7, 2, properties.getProperty("label.pipelineInbox.table.transactionOwner"));
				addCaption(sheet, 8, 2, properties.getProperty("label.pipelineInbox.table.standardException"));
				addCaption(sheet, 9, 2, properties.getProperty("label.pipelineInbox.table.regionResponsibility"));
				addCaption(sheet, 10, 2, properties.getProperty("label.pipelineInbox.table.valueDate"));
				addCaption(sheet, 11, 2, "Days Remaining");
				addCaption(sheet, 12, 2, properties.getProperty("label.pipelineInbox.table.priority"));
				addCaption(sheet, 13, 2, properties.getProperty("label.pipelineInbox.table.workFlowStatus"));
				addCaption(sheet, 14, 2, properties.getProperty("label.pipelineInbox.table.status"));
			}
			addPipelineHeader(sheet, 15, 2, "Pipeline");
			
			addSNOHeader(sheet, 16, 3, "Front Office");
			addSNOHeader(sheet, 17, 3, "Transfer Pricing");
			addSNOHeader(sheet, 18, 3, "Treasury Tax");
			addSNOHeader(sheet, 19, 3, "Regulatory/Jurisdictional Reviews");
			addSNOHeader(sheet, 20, 3, "Legal");
			addSNOHeader(sheet, 21, 3, "Middle Office");
			addSNOHeader(sheet, 22, 3, "Cash Opperations");
			
			addRiskHeader(sheet, 23, 3, "Risk Management");
			addRiskHeader(sheet, 24, 3, "Business Finance");
			addRiskHeader(sheet, 25, 3, "IDAG");
			addRiskHeader(sheet, 26, 3, "TESG");
			
			addCaption3(sheet, 27, 3, "Additional Reviewers");
			addCaption3(sheet, 28, 3, "Docs. & Certify");
			addCaption3(sheet, 29, 3, "Booking and Close");
			
			addCaption(sheet, 16, 2, "Structuring & Underwriting");
			addCaption(sheet, 23, 2, "Reviews & Approvals");
			addCaption(sheet, 27, 2, "Closing");
		}
	}
	
	/**
	 * 
	 * @param sheet {@link WritableSheet}
	 * @param type {@link String}
	 * @throws WriteException
	 * @throws RowsExceededException
	 */
	private void cellMerge(WritableSheet sheet, String type, String pipelineType)  throws WriteException,
	RowsExceededException{
		sheet.mergeCells(0, 0, 5, 0);
		if(type.equals("Show/Hide Chart")){	
			sheet.mergeCells(0, 2, 0, 3);
			sheet.mergeCells(1, 2, 1, 3);
			sheet.mergeCells(2, 2, 2, 3);
			sheet.mergeCells(3, 2, 3, 3);
			sheet.mergeCells(6, 2, 6, 3);
			sheet.mergeCells(7, 2, 7, 3);
			sheet.mergeCells(8, 2, 8, 3);
			sheet.mergeCells(9, 2, 9, 3);
			sheet.mergeCells(10, 2, 10, 3);
			sheet.mergeCells(11, 2, 11, 3);
			sheet.mergeCells(12, 2, 12, 3);
			sheet.mergeCells(13, 2, 13, 3);
			sheet.mergeCells(14, 2, 14, 3);
			if("FO".equals(pipelineType)){
				sheet.mergeCells(4, 2, 5, 2);
			}else if("MO".equals(pipelineType)){
				sheet.mergeCells(4, 2, 4, 3);
				sheet.mergeCells(5, 2, 5, 3);
			}
		}else if(type.equals("Show below")){
			sheet.mergeCells(0, 2, 0, 3);
			sheet.mergeCells(1, 2, 1, 3);
			sheet.mergeCells(2, 2, 2, 3);
			sheet.mergeCells(3, 2, 3, 3);
			sheet.mergeCells(4, 2, 4, 3);
			sheet.mergeCells(5, 2, 11, 2);
			sheet.mergeCells(12, 2, 15, 2);
			sheet.mergeCells(16, 2, 18, 2);
		}else if(type.equals("Show to side")){
			sheet.mergeCells(0, 2, 0, 3);
			sheet.mergeCells(1, 2, 1, 3);
			sheet.mergeCells(2, 2, 2, 3);
			sheet.mergeCells(3, 2, 3, 3);
			sheet.mergeCells(6, 2, 6, 3);
			sheet.mergeCells(7, 2, 7, 3);
			sheet.mergeCells(8, 2, 8, 3);
			sheet.mergeCells(9, 2, 9, 3);
			sheet.mergeCells(10, 2, 10, 3);
			sheet.mergeCells(11, 2, 11, 3);
			sheet.mergeCells(12, 2, 12, 3);
			sheet.mergeCells(13, 2, 13, 3);
			sheet.mergeCells(14, 2, 14, 3);
			if("FO".equals(pipelineType)){
				sheet.mergeCells(4, 2, 5, 2);
			}else if("MO".equals(pipelineType)){
				sheet.mergeCells(4, 2, 4, 3);
				sheet.mergeCells(5, 2, 5, 3);
			}
			sheet.mergeCells(15, 2, 15, 3);
			sheet.mergeCells(16, 2, 22, 2);
			sheet.mergeCells(23, 2, 26, 2);
			sheet.mergeCells(27, 2, 29, 2);
		}
	}

	/**
	 * 
	 * @param sheet
	 * @param searchResultList
	 * @throws WriteException
	 * @throws RowsExceededException
	 * @throws ParseException
	 */
	private void createSearchContent(WritableSheet sheet, List<PipelineDetails> searchResultList) throws WriteException,
	RowsExceededException, ParseException {
		for (int i = 0; i < searchResultList.size(); i++) {
			addLabel(sheet, 0, i+2, ""+(i+1));
			addLabel(sheet, 1, i+2, searchResultList.get(i).getStatus());
			addLabel(sheet, 2, i+2, searchResultList.get(i).getUniqueId());
			addLabel(sheet, 3, i+2, searchResultList.get(i).getDealName());
			addLabel(sheet, 4, i+2, searchResultList.get(i).getDebtValue());
			addLabel(sheet, 5, i+2, searchResultList.get(i).getEquityValue());
			addLabel(sheet, 6, i+2, searchResultList.get(i).getDealCategory());
			addLabel(sheet, 7, i+2, searchResultList.get(i).getEvent());
			addLabel(sheet, 8, i+2, searchResultList.get(i).getName());
			addLabel(sheet, 9, i+2, searchResultList.get(i).getValueDate());
			addLabel(sheet, 10, i+2, searchResultList.get(i).getNoOfDaysRemaining());
			addLabel(sheet, 11, i+2, searchResultList.get(i).getPriority());
			addLabel(sheet, 12, i+2, searchResultList.get(i).getWorkFlowState());
			addLabel(sheet, 13, i+2, searchResultList.get(i).getStatus());
		}
		
	}
	/**
	 * 
	 * @param sheet {@link WritableSheet}
	 * @param pipelineDetailList {@link List}
	 * @param type {@link String}
	 * @throws WriteException
	 * @throws RowsExceededException
	 * @throws ParseException 
	 */
	private void createContent(WritableSheet sheet, List<PipelineDetails> pipelineDetailList, String type, String pipelineType) throws WriteException,
			RowsExceededException, ParseException {
		if(type.equals("Show/Hide Chart")){
			for (int i = 0; i < pipelineDetailList.size(); i++) {
				addLabel(sheet, 0, i+4, ""+(i+1));
				addLabel(sheet, 1, i+4, pipelineDetailList.get(i).getRequestDate());
				addLabel(sheet, 2, i+4, pipelineDetailList.get(i).getUniqueId());
				addLabel(sheet, 3, i+4, pipelineDetailList.get(i).getDealName());
				if("FO".equals(pipelineType)){
					addLabel(sheet, 4, i+4, pipelineDetailList.get(i).getDebtValue());
					addLabel(sheet, 5, i+4, pipelineDetailList.get(i).getEquityValue());
					addLabel(sheet, 6, i+4, pipelineDetailList.get(i).getProductTypeCollection());
					addLabel(sheet, 7, i+4, pipelineDetailList.get(i).getDealCategory());
					addLabel(sheet, 8, i+4, pipelineDetailList.get(i).getTransOwnerSsoId());
					addLabel(sheet, 9, i+4, pipelineDetailList.get(i).getResponsibleRegion());
					addLabel(sheet, 10, i+4, pipelineDetailList.get(i).getValueDate());
					addLabel(sheet, 11, i+4, pipelineDetailList.get(i).getNoOfDaysRemaining());
					addLabel(sheet, 12, i+4, pipelineDetailList.get(i).getPriority());
					addLabel(sheet, 13, i+4, pipelineDetailList.get(i).getWorkFlowState());
					addLabel(sheet, 14, i+4, pipelineDetailList.get(i).getStatus());
				}else if("MO".equals(pipelineType)){
					addLabel(sheet, 4, i+4, pipelineDetailList.get(i).getDebtValue());
					addLabel(sheet, 5, i+4, pipelineDetailList.get(i).getEvent());
					addLabel(sheet, 6, i+4, pipelineDetailList.get(i).getDealCategory());
					addLabel(sheet, 7, i+4, pipelineDetailList.get(i).getTransOwnerSsoId());
					addLabel(sheet, 8, i+4, pipelineDetailList.get(i).getStandardException());
					addLabel(sheet, 9, i+4, pipelineDetailList.get(i).getResponsibleRegion());
					addLabel(sheet, 10, i+4, pipelineDetailList.get(i).getValueDate());
					addLabel(sheet, 11, i+4, pipelineDetailList.get(i).getNoOfDaysRemaining());
					addLabel(sheet, 12, i+4, pipelineDetailList.get(i).getPriority());
					addLabel(sheet, 13, i+4, pipelineDetailList.get(i).getWorkFlowState());
					addLabel(sheet, 14, i+4, pipelineDetailList.get(i).getStatus());
				}
			}
		}else if(type.equals("Show below")){
			for (int i = 0; i < pipelineDetailList.size(); i++) {
				addLabel(sheet, 0, i+4, ""+(i+1));
				addLabel(sheet, 1, i+4, pipelineDetailList.get(i).getRequestDate());
				addLabel(sheet, 2, i+4, pipelineDetailList.get(i).getUniqueId());
				addLabel(sheet, 3, i+4, pipelineDetailList.get(i).getDealName());
				addLabelforChart(sheet, 4, i+4, pipelineDetailList.get(i).getPipeline());
				addLabelforChart(sheet, 5, i+4, pipelineDetailList.get(i).getFrontO());
				addLabelforChart(sheet, 6, i+4, pipelineDetailList.get(i).gettPricing());
				addLabelforChart(sheet, 7, i+4, pipelineDetailList.get(i).gettTax());
				addLabelforChart(sheet, 8, i+4, pipelineDetailList.get(i).getCountryT());
				addLabelforChart(sheet, 9, i+4, pipelineDetailList.get(i).gettLegal());
				addLabelforChart(sheet, 10, i+4, pipelineDetailList.get(i).getMiddleO());
				addLabelforChart(sheet, 11, i+4, pipelineDetailList.get(i).getCashM());
				addLabelforChart(sheet, 12, i+4, pipelineDetailList.get(i).getRiskM());
				addLabelforChart(sheet, 13, i+4, pipelineDetailList.get(i).getBusinessF());
				addLabelforChart(sheet, 14, i+4, pipelineDetailList.get(i).getIdag());
				addLabelforChart(sheet, 15, i+4, pipelineDetailList.get(i).getTesg());
				addLabelforChart(sheet, 16, i+4, pipelineDetailList.get(i).getAdditionalR());
				addLabelforChart(sheet, 17, i+4, pipelineDetailList.get(i).getCertify());
				addLabelforChart(sheet, 18, i+4, pipelineDetailList.get(i).getClose());
			}
		}else if(type.equals("Show to side")){
			for (int i = 0; i < pipelineDetailList.size(); i++) {
				addLabel(sheet, 0, i+4, ""+(i+1));
				addLabel(sheet, 1, i+4, pipelineDetailList.get(i).getRequestDate());
				addLabel(sheet, 2, i+4, pipelineDetailList.get(i).getUniqueId());
				addLabel(sheet, 3, i+4, pipelineDetailList.get(i).getDealName());
				if("FO".equals(pipelineType)){
					addLabel(sheet, 4, i+4, pipelineDetailList.get(i).getDebtValue());
					addLabel(sheet, 5, i+4, pipelineDetailList.get(i).getEquityValue());
					addLabel(sheet, 6, i+4, pipelineDetailList.get(i).getProductTypeCollection());
					addLabel(sheet, 7, i+4, pipelineDetailList.get(i).getDealCategory());
					addLabel(sheet, 8, i+4, pipelineDetailList.get(i).getTransOwnerSsoId());
					addLabel(sheet, 9, i+4, pipelineDetailList.get(i).getResponsibleRegion());
					addLabel(sheet, 10, i+4, pipelineDetailList.get(i).getValueDate());
					addLabel(sheet, 11, i+4, pipelineDetailList.get(i).getNoOfDaysRemaining());
					addLabel(sheet, 12, i+4, pipelineDetailList.get(i).getPriority());
					addLabel(sheet, 13, i+4, pipelineDetailList.get(i).getWorkFlowState());
					addLabel(sheet, 14, i+4, pipelineDetailList.get(i).getStatus());
				}else if("MO".equals(pipelineType)){
					addLabel(sheet, 4, i+4, pipelineDetailList.get(i).getDebtValue());
					addLabel(sheet, 5, i+4, pipelineDetailList.get(i).getEvent());
					addLabel(sheet, 6, i+4, pipelineDetailList.get(i).getDealCategory());
					addLabel(sheet, 7, i+4, pipelineDetailList.get(i).getTransOwnerSsoId());
					addLabel(sheet, 8, i+4, pipelineDetailList.get(i).getStandardException());
					addLabel(sheet, 9, i+4, pipelineDetailList.get(i).getResponsibleRegion());
					addLabel(sheet, 10, i+4, pipelineDetailList.get(i).getValueDate());
					addLabel(sheet, 11, i+4, pipelineDetailList.get(i).getNoOfDaysRemaining());
					addLabel(sheet, 12, i+4, pipelineDetailList.get(i).getPriority());
					addLabel(sheet, 13, i+4, pipelineDetailList.get(i).getWorkFlowState());
					addLabel(sheet, 14, i+4, pipelineDetailList.get(i).getStatus());
				}
				addLabelforChart(sheet, 15, i+4, pipelineDetailList.get(i).getPipeline());
				addLabelforChart(sheet, 16, i+4, pipelineDetailList.get(i).getFrontO());
				addLabelforChart(sheet, 17, i+4, pipelineDetailList.get(i).gettPricing());
				addLabelforChart(sheet, 18, i+4, pipelineDetailList.get(i).gettTax());
				addLabelforChart(sheet, 19, i+4, pipelineDetailList.get(i).getCountryT());
				addLabelforChart(sheet, 20, i+4, pipelineDetailList.get(i).gettLegal());
				addLabelforChart(sheet, 21, i+4, pipelineDetailList.get(i).getMiddleO());
				addLabelforChart(sheet, 22, i+4, pipelineDetailList.get(i).getCashM());
				addLabelforChart(sheet, 23, i+4, pipelineDetailList.get(i).getRiskM());
				addLabelforChart(sheet, 24, i+4, pipelineDetailList.get(i).getBusinessF());
				addLabelforChart(sheet, 25, i+4, pipelineDetailList.get(i).getIdag());
				addLabelforChart(sheet, 26, i+4, pipelineDetailList.get(i).getTesg());
				addLabelforChart(sheet, 27, i+4, pipelineDetailList.get(i).getAdditionalR());
				addLabelforChart(sheet, 28, i+4, pipelineDetailList.get(i).getCertify());
				addLabelforChart(sheet, 29, i+4, pipelineDetailList.get(i).getClose());
			}
		}
	}

	/**
	 * 
	 * @param sheet {@link WritableSheet}
	 * @param column {@link Integer}
	 * @param row {@link Integer}
	 * @param s {@link String}
	 * @throws RowsExceededException
	 * @throws WriteException
	 */
	private void addCaption(WritableSheet sheet, int column, int row, String s)
			throws RowsExceededException, WriteException {
		Label label;
		label = new Label(column, row, s, cellFormatHeader);
		sheet.addCell(label);
	}

	/**
	 * 
	 * @param sheet
	 * @param column
	 * @param row
	 * @param s
	 * @throws RowsExceededException
	 * @throws WriteException
	 */
	private void addSNOHeader(WritableSheet sheet, int column, int row, String s)
			throws RowsExceededException, WriteException {
		Label label;
		label = new Label(column, row, s, cellFormatSnOHeader);
		sheet.addCell(label);
	}
	
	/**
	 * 
	 * @param sheet
	 * @param column
	 * @param row
	 * @param s
	 * @throws RowsExceededException
	 * @throws WriteException
	 */
	private void addRiskHeader(WritableSheet sheet, int column, int row, String s)
			throws RowsExceededException, WriteException {
		Label label;
		label = new Label(column, row, s, cellFormatRnAHeader);
		sheet.addCell(label);
	}
	
	/**
	 * 
	 * @param sheet
	 * @param column
	 * @param row
	 * @param s
	 * @throws RowsExceededException
	 * @throws WriteException
	 */
	private void addPipelineHeader(WritableSheet sheet, int column, int row, String s) throws RowsExceededException, WriteException {
		Label label;
		label = new Label(column, row, s, cellFormatPipelineHeader);
		sheet.addCell(label);
	}
	
	/**
	 * 
	 * @param sheet
	 * @param column
	 * @param row
	 * @param s
	 * @throws RowsExceededException
	 * @throws WriteException
	 */
	private void addCaption3(WritableSheet sheet, int column, int row, String s)
			throws RowsExceededException, WriteException {
		Label label;
		label = new Label(column, row, s, cellFormatClosingHeader);
		sheet.addCell(label);
	}
	/**
	 * 
	 * @param sheet {@link WritableSheet}
	 * @param column {@link Integer}
	 * @param row {@link Integer}
	 * @param s {@link String}
	 * @throws WriteException
	 * @throws RowsExceededException
	 */
	private void addLabel(WritableSheet sheet, int column, int row, String s)
			throws WriteException, RowsExceededException {
		Label label;
		label = new Label(column, row, s, cellFormatData);
		sheet.addCell(label);
	}
	/**
	 * 
	 * @param sheet
	 * @param column
	 * @param row
	 * @param s
	 * @throws WriteException
	 * @throws RowsExceededException
	 * @throws ParseException 
	 */
	private void addLabelforChart(WritableSheet sheet, int column, int row, ChartInfo chart)
			throws WriteException, RowsExceededException, ParseException {
		Label label = null;
		if(chart != null){
		if("completed".equals(chart.getStatus())){
			label = new Label(column, row, "", cellFormatCompleted);
		}else if("partial".equals(chart.getStatus())){
			label = new Label(column, row, "", cellFormatInProgress);
		}else if("inprogress".equals(chart.getStatus())){
			label = new Label(column, row, "", cellFormatNotStarted);
		} else if("notapplicable".equals(chart.getStatus())){
			label = new Label(column,row," - ", cellFormatCompleted);
		}
		sheet.addCell(label);
		}
	}
	/**
	 * loadProperties used to load Properties File
	 */
	private void loadProperties() {
		
		InputStream is = getClass().getClassLoader().getResourceAsStream( propertyFilename );

		if (properties == null){
			properties = new Properties();
		}
		try {
			properties.load(is);
		} catch (IOException e) {
			LOGGER.debug(e)	;		
		}finally{
			if( is != null){
				try {
					is.close();
				} catch (IOException e) {
					LOGGER.debug(e);
				}
			}
		}
	}
}
