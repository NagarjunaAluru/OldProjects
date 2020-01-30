/*
 * Copyright  2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ReportsHelper.java
 * Purpose: ReportsHelper used for Export the results to Excel file for different reports.
 *
 */
package com.ge.aloc.util;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import com.ge.aloc.InstrumentType;
import com.ge.aloc.OpCode;
import com.ge.aloc.ReportTypes;
import com.ge.aloc.bo.excel.CellDetail;
import com.ge.aloc.bo.excel.ExcelSheet;
import com.ge.aloc.bo.excel.ExcelSheetCollection;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.exception.ALOCRuntimeException;
import com.ge.aloc.model.AgingDetails;
import com.ge.aloc.model.AverageFeesPaidDetails;
import com.ge.aloc.model.BidSuccessDetails;
import com.ge.aloc.model.ContingentliabilityDetails;
import com.ge.aloc.model.CycleTimeDetails;
import com.ge.aloc.model.ECSODetails;
import com.ge.aloc.model.FeeProjectionDetails;
import com.ge.aloc.model.FeeQuotationDetails;
import com.ge.aloc.model.FeesPaidDetails;
import com.ge.aloc.model.GCFODetails;
import com.ge.aloc.model.IssuanceExpirationDetails;
import com.ge.aloc.model.ReportsDetails;
import com.ge.aloc.model.UserReportDetails;
import com.ge.aloc.reports.ALOCReportException;
import com.ge.aloc.reports.adhoc.DataType;
import com.ge.aloc.reports.adhoc.FilterBO;
import com.ge.aloc.reports.adhoc.Operator;
import com.ge.aloc.reports.adhoc.TemplateBO;
import com.hydus.hwf.ge.attachments.AttachmentHelper;
import com.hydus.hwf.util.StringUtils;

/**
 * @author srikanth.bayyannagari
 *
 */
public final class ReportsHelper {
	private static final Logger LOGGER = Logger.getLogger(ReportsHelper.class);
	private static final Map<String, byte[]> TEMPLATE_MAP = new HashMap<String, byte[]>();
	private static String site_Id;
	private static String beneficiary_Obligee_Name;
	private static String applicant_Principal_Name;
	private static String thirdParty_Applicant_Name;
	private static String instrument_Type;
	private static String issuers;
	private static String instrument_Purpose;
	private static SimpleDateFormat formatter = new SimpleDateFormat(ALOCConstants.FORMATEPATTERN);
	private ReportsHelper(){}
	
	/**
	 * @param fileName
	 * @return
	 */
	private synchronized static InputStream getTemplateInputStream(String fileName) {
		byte[] template = TEMPLATE_MAP.get(fileName);
		
		if(template == null) {
			URL templateFile = Thread.currentThread().getContextClassLoader().getResource(fileName);
			if(templateFile == null) {
				String errMsg = new StringBuilder().append(ALOCConstants.REPORT_TEMPLATE_MSG).append(fileName).append(ALOCConstants.REPORT_TEMPLATE_CLASSPATH_MSG).toString();
				throw new ALOCRuntimeException(ALOCRuntimeException.EC_RESOURCE_NOTFOUND, errMsg);
			}
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			AttachmentHelper.readFromFile(baos, new File(templateFile.getFile()));
			template = baos.toByteArray();
			baos = null;
			TEMPLATE_MAP.put(fileName, template);
			
		}
		
		return new ByteArrayInputStream(template);
	}

	/**
	 * This method to used to add cells to excel sheet
	 * @param objId
	 * @param cgtDtlk
	 * @param poiWorkbook
	 * @param excelSheetObj
	 */
	public static void exportContigentLiabilityResults(int rowId , ContingentliabilityDetails cgtDtl, ExcelSheet excelSheetObj){
		Double instrumentAmount = null;
		Double morBloombergRate = null;
		Double usdAmount = null;
		Date issuanceDate = null;
		Date usExpirationDate = null;
		Date foreignExpirationDate = null;
		Date economicExpDate = null;
		
		site_Id = cgtDtl.getSiteIDs().toString().replace(ALOCConstants.REPORT_OPEN_BRACKET, ALOCConstants.REPORT_EMPTY_CHAR).replace(ALOCConstants.REPORT_CLOSE_BRACKET, ALOCConstants.REPORT_EMPTY_CHAR).trim();
		String usdAmountWithDecimal = ALOCCommonHelper.getStringWithDecimalValue(cgtDtl.getUSDAmount()!=null?cgtDtl.getUSDAmount().toString():ALOCConstants.EMPTY_STRING);
		String instrumentAmountWithDecimal = ALOCCommonHelper.getStringWithDecimalValue(cgtDtl.getInstrumentAmount());
		if(StringUtils.isNotBlank(instrumentAmountWithDecimal))
			instrumentAmount= Double.parseDouble(instrumentAmountWithDecimal);
		if(StringUtils.isNotBlank(cgtDtl.getMORBloombergRate()))
			morBloombergRate= Double.parseDouble(cgtDtl.getMORBloombergRate());
		if(StringUtils.isNotBlank(usdAmountWithDecimal))
			usdAmount= Double.parseDouble(usdAmountWithDecimal);
		
		try {
			if(StringUtils.isNotBlank(cgtDtl.getIssuanceDate()))
				issuanceDate = formatter.parse(cgtDtl.getIssuanceDate());
			if(StringUtils.isNotBlank(cgtDtl.getUSExpDate()))
				usExpirationDate = formatter.parse(cgtDtl.getUSExpDate());
			if(StringUtils.isNotBlank(cgtDtl.getForeignExpDate()))
				foreignExpirationDate = formatter.parse(cgtDtl.getForeignExpDate());
			if(StringUtils.isNotBlank(cgtDtl.getEconomicExpDate()))
				economicExpDate = formatter.parse(cgtDtl.getEconomicExpDate());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_ZERO, cgtDtl.getSiteIDs()!=null ? site_Id : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_ONE, cgtDtl.getALOCRecordId()!=null ? cgtDtl.getALOCRecordId().toString()  : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWO, cgtDtl.getBankReference()!=null ? cgtDtl.getBankReference() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_THREE, cgtDtl.getBeneficiaryObligeeName()!=null ? cgtDtl.getBeneficiaryObligeeName() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_FOUR, cgtDtl.getBeneficiaryObligeeCountry()!=null ? cgtDtl.getBeneficiaryObligeeCountry() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_FIVE, cgtDtl.getApplicantPrincipal()!=null ? cgtDtl.getApplicantPrincipal() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_SIX, cgtDtl.getThirdpartyApplicant()!=null ? cgtDtl.getThirdpartyApplicant() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_SEVEN, cgtDtl.getInstrumentCurrency()!=null ? cgtDtl.getInstrumentCurrency() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_EIGHT, instrumentAmount , rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_NINE, usdAmount, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TEN, cgtDtl.getIssuer()!=null ? cgtDtl.getIssuer().toString() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_ELEVEN, cgtDtl.getIssuingBankBranch()!=null ? cgtDtl.getIssuingBankBranch().toString() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWELVE, morBloombergRate, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_THIRTEEN, issuanceDate, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_FOURTEEN, usExpirationDate, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_FIFTEEN, foreignExpirationDate, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_SIXTEEN, economicExpDate, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_SEVENTEEN, cgtDtl.getCurrentContactNameSSO()!=null ? cgtDtl.getCurrentContactNameSSO().toString() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_EIGHTEEN, cgtDtl.getCurrentContactSSO()!=null ? cgtDtl.getCurrentContactSSO().toString() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_NINTEEN, cgtDtl.getRequestorName()!=null ? cgtDtl.getRequestorName().toString() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWENTY, cgtDtl.getRequestorSSO()!=null ? cgtDtl.getRequestorSSO().toString() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWENTYONE, cgtDtl.getBUC()!=null ? cgtDtl.getBUC().toString() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWENTYTWO, cgtDtl.getADN()!=null ? cgtDtl.getADN().toString() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWENTYTHREE, cgtDtl.getGEReference()!=null ? cgtDtl.getGEReference().toString() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWENTYFOUR, cgtDtl.getInstrumentType()!=null ? cgtDtl.getInstrumentType().toString() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWENTYFIVE, cgtDtl.getInstrumentPurpose()!=null ? cgtDtl.getInstrumentPurpose().toString() : ALOCConstants.EMPTY_STRING, rowId);
	}
	
	/**
	 * This method to used to add cells to excel sheet
	 * @param objId
	 * @param cgtDtl
	 * @param poiWorkbook
	 * @param excelSheetObj
	 */
	public static void exportExternalContigentLiabilityResults(int rowId , ContingentliabilityDetails cgtDtl, ExcelSheet excelSheetObj){
		Double instrumentAmount=null;
		Double morBloombergRate = null;
		Double usdAmount = null;
		Date issuanceDate = null;
		Date usExpirationDate = null;
		Date foreignExpirationDate = null;
		Date economicExpDate = null;
		
		site_Id = cgtDtl.getSiteIDs().toString().replace(ALOCConstants.REPORT_OPEN_BRACKET, ALOCConstants.REPORT_EMPTY_CHAR).replace(ALOCConstants.REPORT_CLOSE_BRACKET, ALOCConstants.REPORT_EMPTY_CHAR).trim();
		String instrumentAmountWithDecimal = ALOCCommonHelper.getStringWithDecimalValue(cgtDtl.getInstrumentAmount());
		String usdAmountWithDecimal = ALOCCommonHelper.getStringWithDecimalValue(cgtDtl.getUSDAmount()!=null?cgtDtl.getUSDAmount().toString():ALOCConstants.EMPTY_STRING);
		if(StringUtils.isNotBlank(instrumentAmountWithDecimal))
			instrumentAmount= Double.parseDouble(instrumentAmountWithDecimal);
		if(StringUtils.isNotBlank(cgtDtl.getMORBloombergRate()))
			morBloombergRate= Double.parseDouble(cgtDtl.getMORBloombergRate());
		if(StringUtils.isNotBlank(usdAmountWithDecimal))
			usdAmount= Double.parseDouble(usdAmountWithDecimal);
		try {
			if(StringUtils.isNotBlank(cgtDtl.getIssuanceDate()))
				issuanceDate = formatter.parse(cgtDtl.getIssuanceDate());
			if(StringUtils.isNotBlank(cgtDtl.getUSExpDate()))
				usExpirationDate = formatter.parse(cgtDtl.getUSExpDate());
			if(StringUtils.isNotBlank(cgtDtl.getForeignExpDate()))
				foreignExpirationDate = formatter.parse(cgtDtl.getForeignExpDate());
			if(StringUtils.isNotBlank(cgtDtl.getEconomicExpDate()))
				economicExpDate = formatter.parse(cgtDtl.getEconomicExpDate());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_ZERO, cgtDtl.getSiteIDs()!=null ? site_Id : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_ONE, cgtDtl.getALOCRecordId()!=null ? cgtDtl.getALOCRecordId().toString()  : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWO, cgtDtl.getBankReference()!=null ? cgtDtl.getBankReference() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_THREE, cgtDtl.getBeneficiaryObligeeName()!=null ? cgtDtl.getBeneficiaryObligeeName() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_FOUR, cgtDtl.getBeneficiaryObligeeCountry()!=null ? cgtDtl.getBeneficiaryObligeeCountry() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_FIVE, cgtDtl.getApplicantPrincipal()!=null ? cgtDtl.getApplicantPrincipal() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_SIX, cgtDtl.getThirdpartyApplicant()!=null ? cgtDtl.getThirdpartyApplicant() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_SEVEN, cgtDtl.getInstrumentCurrency()!=null ? cgtDtl.getInstrumentCurrency() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_EIGHT, instrumentAmount, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_NINE, usdAmount, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TEN, cgtDtl.getIssuer()!=null ? cgtDtl.getIssuer().toString() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_ELEVEN, cgtDtl.getIssuingBankBranch()!=null ? cgtDtl.getIssuingBankBranch().toString() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWELVE, morBloombergRate, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_THIRTEEN, issuanceDate, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_FOURTEEN, usExpirationDate, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_FIFTEEN, foreignExpirationDate, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_SIXTEEN, economicExpDate, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_SEVENTEEN, cgtDtl.getCurrentContactNameSSO()!=null ? cgtDtl.getCurrentContactNameSSO().toString() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_EIGHTEEN, cgtDtl.getCurrentContactSSO()!=null ? cgtDtl.getCurrentContactSSO().toString() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_NINTEEN, cgtDtl.getRequestorName()!=null ? cgtDtl.getRequestorName().toString() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWENTY, cgtDtl.getRequestorSSO()!=null ? cgtDtl.getRequestorSSO().toString() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWENTYONE, cgtDtl.getGEReference()!=null ? cgtDtl.getGEReference().toString() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWENTYTWO, cgtDtl.getInstrumentType()!=null ? cgtDtl.getInstrumentType().toString() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWENTYTHREE, cgtDtl.getInstrumentPurpose()!=null ? cgtDtl.getInstrumentPurpose().toString() : ALOCConstants.EMPTY_STRING, rowId);
	}


	/**
	 * This method to used to fill cell details to the excel sheet
	 * @param excelSheetObj
	 * @param columnId
	 * @param value
	 * @param rowId
	 */
	private static void fillCellDetails(ExcelSheet excelSheetObj, int columnId, String value, int rowId) {
		CellDetail cellDetailObj = new CellDetail();
		cellDetailObj.setRowId(rowId);
		cellDetailObj.setColumnId(columnId);
		cellDetailObj.setValue(value);
		excelSheetObj.getCellDetail().add(cellDetailObj);

	}
	
	/**
	 * This method to used to fill cell details to the excel sheet
	 * @param excelSheetObj
	 * @param columnId
	 * @param value
	 * @param rowId
	 */
	private static void fillCellDetails(ExcelSheet excelSheetObj, int columnId, Double amount, int rowId) {
		CellDetail cellDetailObj = new CellDetail();
		cellDetailObj.setRowId(rowId);
		cellDetailObj.setColumnId(columnId);
		cellDetailObj.setAmount(amount);
		excelSheetObj.getCellDetail().add(cellDetailObj);

	}
	
	/**
	 * This method to used to fill cell details to the excel sheet
	 * @param excelSheetObj
	 * @param columnId
	 * @param value
	 * @param rowId
	 */
	private static void fillCellDetails(ExcelSheet excelSheetObj, int columnId, Date date, int rowId) {
		CellDetail cellDetailObj = new CellDetail();
		cellDetailObj.setRowId(rowId);
		cellDetailObj.setColumnId(columnId);
		cellDetailObj.setDateValue(date);
		excelSheetObj.getCellDetail().add(cellDetailObj);

	}
	
	/**
	 * Method to export the results for Contingent Liability Report
	 * @param reportsDetails
	 * @throws ALOCReportException 
	 */
	public static void callContingentReportExport(ReportsDetails reportsDetails, String fileName) throws ALOCReportException{
		List<ContingentliabilityDetails> cldList = reportsDetails.getContingentliabilityDetails();
		Map<String, List<ContingentliabilityDetails>> bankRefToCldMap = new HashMap<String, List<ContingentliabilityDetails>>();

		// Grouping the ContingentliabilityDetails using bank reference
		for(ContingentliabilityDetails cld : cldList) {
			List<ContingentliabilityDetails> bankCldList = bankRefToCldMap.get(cld.getIssuer());
			if(bankCldList == null) {
				bankCldList = new ArrayList<ContingentliabilityDetails>();
				bankRefToCldMap.put(cld.getIssuer(), bankCldList);
			}
			bankCldList.add(cld);
		}

		HttpServletResponse response = ServletActionContext.getResponse();
		
		if(bankRefToCldMap.keySet().size() == ALOCConstants.MIN_VALUE){
			fileName = new StringBuilder().append(ALOCConstants.CONTIGENTLIABILITYPATH).append(cldList.get(ALOCConstants.BASE_VALUE).getIssuer()).append(ALOCConstants.ZIP_EXTENSION).toString();
		}else {
			fileName = new StringBuilder().append(fileName).append(ALOCConstants.ZIP_EXTENSION).toString();
		}
		
		response.setContentType(ServletActionContext.getServletContext().getMimeType(fileName));
		response.addHeader(ALOCConstants.HEADER_CONTENT_DISPOSITION,ALOCConstants.CONTENT_DISPOSITION_VALUE + fileName);

		ZipOutputStream zOutputStream = null;
		try {
			zOutputStream = new ZipOutputStream(new BufferedOutputStream(response.getOutputStream()));
			Set<String> bankRefs = bankRefToCldMap.keySet();
			for(String bankRef : bankRefs) {
				List<ContingentliabilityDetails> bankClds = bankRefToCldMap.get(bankRef);
				if(StringUtils.isNotBlank(bankRef)){
					ZipEntry zipEntry = new ZipEntry(bankRef + ALOCConstants.XLSFILE);
					zOutputStream.putNextEntry(zipEntry);
					createFile(bankClds, zOutputStream);
					zOutputStream.closeEntry();
				}
			}
		} catch (IOException ioe) {
			throw new ALOCReportException(ALOCReportException.EC_REPORT_IO, ioe);
		} finally {
			try {
				if(zOutputStream != null) {
					zOutputStream.close();
				}
			} catch (IOException ioe) {
				LOGGER.warn(ALOCConstants.REPORT_ZIP_OUTPUT_STREAM_ERROR_MSG, ioe);
			}
		}
	}

	/**
	 * 
	 * @param brdList
	 * @param outStream
	 * @throws ALOCReportException 
	 * @throws IOException 
	 */
	private static void createFile(List<ContingentliabilityDetails> brdList, OutputStream outStream) throws ALOCReportException {
		InputStream templateStream = null;

		try {
			templateStream = getTemplateInputStream(ALOCConstants.CONTIGENT_REPORT_TEMPLATE_LOCATION);
			WriteFeePaymentToExcel writeToExcel = new WriteFeePaymentToExcel();
			HSSFWorkbook poiWorkbook = new HSSFWorkbook(templateStream, true);

			ExcelSheetCollection excelSheets = new ExcelSheetCollection();
			ExcelSheet excelSheet = new ExcelSheet();

			int rowId = ALOCConstants.EXCEL_START_INDEX;
			for(ContingentliabilityDetails brd : brdList) {

				ReportsHelper.exportContigentLiabilityResults(rowId, brd, excelSheet);
				rowId++;
			}

			excelSheet.setSheetName(poiWorkbook.getSheetName(ALOCConstants.BASE_VALUE));
			excelSheets.getExcelSheet().add(excelSheet);
			writeToExcel.write(poiWorkbook, excelSheets);
			poiWorkbook.write(outStream);

		} catch (Exception e) {
			throw new ALOCReportException(ALOCReportException.EC_REPORT_CREATE, e);
		}finally {
			try {
				if(templateStream != null) {
					templateStream.close();
				}
			} catch (IOException ioe) {
				LOGGER.warn(ALOCConstants.REPORT_EXCEL_TEMPLATE_ERROR_MSG, ioe);
			}
		}
	}

	/**
	 * Method to set the bid Success Report details
	 */
	private static ReportsDetails assignBidSuccessReport(ReportsDetails reportDetails){
		LOGGER.info(ALOCConstants.REPORT_BID_SUCCESS_LOGGER_MSG);
		reportDetails.setMsgHeader(ALOCCommonHelper.createMsgHeader(OpCode.GETBIDSUCCESS.toString()));
		return reportDetails;

	}

	/**
	 * Method to set the Cycle Time Report details
	 */
	private static ReportsDetails assignCycleTimeReport(ReportsDetails reportsDetails){
		LOGGER.info(ALOCConstants.REPORT_CYCLE_TIME_LOGGER_MSG);
		reportsDetails.setMsgHeader(ALOCCommonHelper.createMsgHeader(OpCode.GETCYCLETIME.toString()));
		return reportsDetails;
	}
	
	/**
	 * Method to set Avg Fees Paid Details
	 * @param reportDetails
	 * @return
	 */
	private static ReportsDetails assignAvgFeePaidReport(ReportsDetails reportDetails){
		LOGGER.info(ALOCConstants.REPORT_AVG_FEES_PAID_LOGGER_MSG);
		reportDetails.setMsgHeader(ALOCCommonHelper.createMsgHeader(OpCode.GETAVERAGEFEESPAID.toString()));
		return reportDetails;
	}

	/**
	 * Method to set the Aging Report details
	 */
	private static ReportsDetails assignAgingReport(ReportsDetails reportDetails){
		LOGGER.info(ALOCConstants.REPORT_AGING_LOGGER_MSG);
		reportDetails.setMsgHeader(ALOCCommonHelper.createMsgHeader(OpCode.GETAGING.toString()));
		return reportDetails;
	}


	/**
	 * Method to set the Fees Paid Report details
	 */
	private static ReportsDetails assignFeesPaidReport(ReportsDetails reportDetails){
		LOGGER.info(ALOCConstants.REPORT_FEES_PAID_LOGGER_MSG);
		reportDetails.setMsgHeader(ALOCCommonHelper.createMsgHeader(OpCode.GETFEESPAID.toString()));
		return reportDetails;
	}

	/**
	 * Method to set the Issuance & Expiration Report details
	 */
	private static ReportsDetails assignIssuanceExpirationReport(ReportsDetails reportDetails){
		LOGGER.info(ALOCConstants.REPORT_ISSUANCE_LOGGER_MSG);
		List<IssuanceExpirationDetails> issuanceExpirationList = new ArrayList<IssuanceExpirationDetails>();

		if(null != reportDetails){
			issuanceExpirationList = reportDetails.getIssuanceExpirationDetails();
			IssuanceExpirationDetails issuanceDetails = issuanceExpirationList.get(ALOCConstants.BASE_VALUE);
			if(issuanceDetails.getUSExpirationDate().equalsIgnoreCase(ALOCConstants.FALSE)){
				issuanceDetails.setINExpStartDt(ALOCConstants.EMPTY_STRING);
				issuanceDetails.setINExpEndDt(ALOCConstants.EMPTY_STRING);
			}
			if(issuanceDetails.getIssuanceDate().equalsIgnoreCase(ALOCConstants.FALSE)){
				issuanceDetails.setINIssuanceStartDt(ALOCConstants.EMPTY_STRING);
				issuanceDetails.setINIssuanceEndDt(ALOCConstants.EMPTY_STRING);
			}
			issuanceExpirationList.set(ALOCConstants.BASE_VALUE, issuanceDetails);
		}
		
		reportDetails.setMsgHeader(ALOCCommonHelper.createMsgHeader(OpCode.GETISSUANCEEXPIRATION.toString()));
		reportDetails.setIssuanceExpirationDetails(issuanceExpirationList);
		return reportDetails;
	}

	/**
	 * Method to set the ECSO Report details
	 */
	private static ReportsDetails assignECSOReport(ReportsDetails reportDetails){
		LOGGER.info(ALOCConstants.REPORT_ECSO_LOGGER_MSG);
		reportDetails.setMsgHeader(ALOCCommonHelper.createMsgHeader(OpCode.GETECSO.toString()));
		return reportDetails;
	}

	/**
	 * Method to set the GCFO Report details
	 */
	private static ReportsDetails assignGCFOReport(ReportsDetails reportDetails){
		LOGGER.info(ALOCConstants.REPORT_GCFO_LOGGER_MSG);
		reportDetails.setMsgHeader(ALOCCommonHelper.createMsgHeader(OpCode.GETGCFO.toString()));
		return reportDetails;
	}
	
	/**
	 * Method to set the User Report details
	 */
	private static ReportsDetails assignUserReport(ReportsDetails reportDetails){
		LOGGER.info(ALOCConstants.REPORT_USER_LOGGER_MSG);
		List<UserReportDetails> userReportDetailsList = new ArrayList<UserReportDetails>();

		if(null != reportDetails){
			userReportDetailsList = reportDetails.getUserReportDetails();
			UserReportDetails userReportDetails = userReportDetailsList.get(ALOCConstants.BASE_VALUE);
			if(userReportDetails.getStatus().equalsIgnoreCase(ALOCConstants.ALL)){
				userReportDetails.setStatus(ALOCConstants.A);}
			else if(userReportDetails.getStatus().equalsIgnoreCase(ALOCConstants.ENABLED)){
				userReportDetails.setStatus(ALOCConstants.N);}
			else {
				userReportDetails.setStatus(ALOCConstants.Y);}
		
			userReportDetailsList.set(ALOCConstants.BASE_VALUE,userReportDetails);
		}
		reportDetails.setMsgHeader(ALOCCommonHelper.createMsgHeader(OpCode.GETUSERREPORT.toString()));
		reportDetails.setUserReportDetails(userReportDetailsList);
		return reportDetails;
	}
	
	/**
	 * Method to set the Fee Quotation Report details
	 */
	private static ReportsDetails assignFeeQuotationReport(ReportsDetails reportDetails){
		LOGGER.info(ALOCConstants.REPORT_FEE_QUOTATION_LOGGER_MSG);
		reportDetails.setMsgHeader(ALOCCommonHelper.createMsgHeader(OpCode.GETFEEQUOTATION.toString()));
		return reportDetails;
	}
	
	/**
	 * Method to set the Fee Projection Report details
	 */
	private static ReportsDetails assignFeeProjectionReport(ReportsDetails reportDetails){
		LOGGER.info(ALOCConstants.REPORT_FEE_PROJECTION_LOGGER_MSG);
		reportDetails.setMsgHeader(ALOCCommonHelper.createMsgHeader(OpCode.GETFEEPROJECTION.toString()));
		return reportDetails;
	}
	
	/**
	 * Method to assign the properties of reports
	 * @param reportName
	 */
	public static ReportsDetails assignReportProperties(String reportName,ReportsDetails reportsDetails1){
		ReportsDetails reportDtl = null;
		ReportTypes reportTypes = ReportTypes.fromName(reportName);
		switch(reportTypes){
		case ISSUANCEEXPIRATIONREPORT:
			reportDtl = assignIssuanceExpirationReport(reportsDetails1);
			break;
		case BIDSUCCESSREPORT:
			reportDtl = assignBidSuccessReport(reportsDetails1);
			break;
		case AGINGREPORT:
			reportDtl = assignAgingReport(reportsDetails1);
			break;
		case FEESPAIDREPORT:
			reportDtl = assignFeesPaidReport(reportsDetails1);
			break;
		case CYCLETIMEREPORT:
			reportDtl = assignCycleTimeReport(reportsDetails1);
			break;
		case ECSOREPORT:
			reportDtl = assignECSOReport(reportsDetails1);
			break;
		case GCFOREPORT:
			reportDtl = assignGCFOReport(reportsDetails1);
			break;
		case USERREPORT:
			reportDtl = assignUserReport(reportsDetails1);
			break;
		case FEEQUOTATIONREPORT:
			reportDtl = assignFeeQuotationReport(reportsDetails1);
			break;
		case AVERAGEFEESPAIDREPORT:
			reportDtl = assignAvgFeePaidReport(reportsDetails1);
			break;
		case FEEPROJECTIONREPORT:
			reportDtl = assignFeeProjectionReport(reportsDetails1);
			break;
		}
		return reportDtl;
	}

	/**
	 * Method to divide the response of exported results
	 * @param reportsDetails
	 * @throws ALOCReportException
	 * @throws IOException 
	 */
	public static void generateExcelReport(String reportName, ReportsDetails reportsDetails, String fileName, Boolean isExternal) throws ALOCReportException, IOException{
		ReportTypes reportTypes = ReportTypes.fromName(reportName);
		switch(reportTypes){
		case ISSUANCEEXPIRATIONREPORT:
			createExcelReport(reportsDetails,ALOCConstants.ISSUANCEEXPIRATION_REPORT_TEMPLATE, reportName, fileName, isExternal);
			break;
		case BIDSUCCESSREPORT:
			createExcelReport(reportsDetails,ALOCConstants.BIDSUCCESS_REPORT_TEMPLATE, reportName, fileName, isExternal);
			break;
		case AGINGREPORT:
			createExcelReport(reportsDetails,ALOCConstants.AGING_REPORT_TEMPLATE_LOCATION, reportName, fileName, isExternal);
			break;
		case FEESPAIDREPORT:
			createExcelReport(reportsDetails,ALOCConstants.FEEPAID_REPORT_TEMPLATE, reportName, fileName, isExternal);
			break;
		case CYCLETIMEREPORT:
			createExcelReport(reportsDetails,ALOCConstants.CYCLETIME_REPORT_TEMPLATE, reportName, fileName, isExternal);
			break;
		case ECSOREPORT:
			createExcelReport(reportsDetails,ALOCConstants.ECSO_REPORT_TEMPLATE, reportName, fileName, isExternal);
			break;
		case GCFOREPORT:
			createExcelReport(reportsDetails,ALOCConstants.GCFO_REPORT_TEMPLATE, reportName, fileName, isExternal);
			break;
		case USERREPORT:
			createExcelReport(reportsDetails,ALOCConstants.USER_REPORT_TEMPLATE, reportName, fileName, isExternal);
			break;
		case FEEQUOTATIONREPORT:
			createExcelReport(reportsDetails,ALOCConstants.FEEQUOTATION_REPORT_TEMPLATE, reportName, fileName, isExternal);
			break;
		case AVERAGEFEESPAIDREPORT:
			createExcelReport(reportsDetails, ALOCConstants.AVERAGEFEEPAID_REPORT_TEMPLATE, reportName, fileName, isExternal);
			break;
		case FEEPROJECTIONREPORT:
			createExcelReport(reportsDetails, ALOCConstants.FEEPROJECTION_REPORT_TEMPLATE, reportName, fileName, isExternal);
			break;
		case CONTINGENTREPORT:
			if(!isExternal)
				createExcelReport(reportsDetails, ALOCConstants.CONTIGENT_REPORT_TEMPLATE_LOCATION, reportName, fileName, isExternal);
			else
				createExcelReport(reportsDetails, ALOCConstants.CONTIGENT_REPORT_EXT_TEMPLATE_LOCATION, reportName, fileName, isExternal);
			
			break;
		}
	}

	/**
	 * Method to export data to excel file based on the report Name
	 * @param reportDetail
	 * @param templateURL
	 * @param reportName
	 * @param outStream
	 * @throws ALOCReportException
	 */
	private static void createExcelReport(ReportsDetails reportDetail, String templateFile, String reportName, String XLSFileName, Boolean isExternal) throws ALOCReportException {
		InputStream templateStream = getTemplateInputStream(templateFile);
		OutputStream outStream = null;
		try {
			String filename = ALOCConstants.EMPTY_STRING;
			SimpleDateFormat sdfDate = new SimpleDateFormat(ALOCConstants.YYYY_MM_DD);
		    Date today = new Date();
			String todayDate = sdfDate.format(today);
			
			ReportTypes reportTypes = ReportTypes.fromName(reportName);
			switch(reportTypes){
				case GCFOREPORT:
				case FEEPROJECTIONREPORT:
				case ISSUANCEEXPIRATIONREPORT:
				case CONTINGENTREPORT:
				case AVERAGEFEESPAIDREPORT:
				case FEEQUOTATIONREPORT:
				case FEESPAIDREPORT:
					filename = XLSFileName + ALOCConstants.XLSFILE;
					break;
				default: 
					filename = reportName + ALOCConstants.UNDERSCORE + todayDate + ALOCConstants.XLSFILE;
	            	break;
			}
			
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType(ServletActionContext.getServletContext().getMimeType(filename));
			response.addHeader(ALOCConstants.HEADER_CONTENT_DISPOSITION,ALOCConstants.ATTACHMENTFILE + filename + ALOCConstants.SLASH);

			WriteFeePaymentToExcel writeToExcel = new WriteFeePaymentToExcel();
			HSSFWorkbook poiWorkbook = new HSSFWorkbook(templateStream, true);
			ExcelSheetCollection excelSheets = new ExcelSheetCollection();
			ExcelSheet excelSheet = new ExcelSheet();
			excelSheet = fillReportsDataToExcel(reportName, reportDetail, excelSheet, isExternal);
			excelSheet.setSheetName(poiWorkbook.getSheetName(ALOCConstants.BASE_VALUE));
			excelSheets.getExcelSheet().add(excelSheet);
			writeToExcel.write(poiWorkbook, excelSheets);
			outStream = new BufferedOutputStream(response.getOutputStream());
			poiWorkbook.write(outStream);

		} catch (IOException e) {
			throw new ALOCReportException(ALOCReportException.EC_REPORT_CREATE, e);
		} catch (Exception e) {
			LOGGER.error(ALOCConstants.REPORT_EXCEL_GENERATE_ERROR_MSG, e);
			throw new ALOCReportException(ALOCReportException.EC_REPORT_CREATE, e);
		} finally {
			try {
				if(outStream != null) {
					outStream.close();
				}
			} catch (IOException ioe) {
				LOGGER.warn(ALOCConstants.REPORT_OUTPUT_STRAEM_CLOSE_ERROR_MSG, ioe);
			}
			
			try {
				if(templateStream != null) {
					templateStream.close();
				}
			} catch (IOException ioe) {
				LOGGER.warn(ALOCConstants.REPORT_EXCEL_TEMPLATE_ERROR_MSG, ioe);
			}
		}

	}
	

	/**
	 * fillReportsDataToExcel to fill the Report details in to Excel.
	 * @param reportName
	 * @param rowId
	 * @param reportDetail
	 * @param excelSheet
	 * @return ExcelSheet
	 */
	private static ExcelSheet fillReportsDataToExcel(String reportName, ReportsDetails reportDetail, ExcelSheet excelSheet, Boolean isExternal) {
		int rowId = ALOCConstants.EXCEL_START_INDEX;

		ReportTypes reportTypes = ReportTypes.fromName(reportName);
		switch(reportTypes){
		case ISSUANCEEXPIRATIONREPORT:
			for(IssuanceExpirationDetails issuanceExpiration : reportDetail.getIssuanceExpirationDetails()){
				ReportsHelper.exportIssuanceExpirationResults(rowId, issuanceExpiration, excelSheet);
				rowId++;
			}
			break;
		case BIDSUCCESSREPORT:
			for(BidSuccessDetails bidSuccess : reportDetail.getBidSuccessDetails()) {
				ReportsHelper.exportBidSuccessResults(rowId, bidSuccess, excelSheet);
				rowId++;
			}
			break;
		case AGINGREPORT:
			for(AgingDetails agingDetail : reportDetail.getAgingDetails()){
				ReportsHelper.exportAgingResults(rowId, agingDetail, excelSheet);
				rowId++;
			}
			break;
		case FEESPAIDREPORT:
			for(FeesPaidDetails feepaidDetails : reportDetail.getFeesPaidDetails()){
				if(!feepaidDetails.getFeeCurrency().equalsIgnoreCase(ALOCConstants.TOTAL)){
					ReportsHelper.exportFeesPaidResults(rowId, feepaidDetails, excelSheet);
					rowId++;
				}
			}
			break;
		case CYCLETIMEREPORT:
			for(CycleTimeDetails cycleTime : reportDetail.getCycleTimeDetails()){
				ReportsHelper.exportCycleTimeResults(rowId, cycleTime, excelSheet);
				rowId++;
			}
			break;
		case ECSOREPORT:
			for(ECSODetails ecsoDetails : reportDetail.getECSODetails()){
				ReportsHelper.exportECSOResults(rowId, ecsoDetails, excelSheet);
				rowId++;
			}
			break;
		case GCFOREPORT:
			for(GCFODetails gcfoDetails : reportDetail.getGCFODetails()){
				ReportsHelper.exportGCFOResults(rowId, gcfoDetails, excelSheet);
				rowId++;
			}
			break;
		case USERREPORT:
			for(UserReportDetails userReportDetails : reportDetail.getUserReportDetails()){
				ReportsHelper.exportUserResults(rowId, userReportDetails, excelSheet);
				rowId++;
			}
			break;
		case FEEQUOTATIONREPORT:
			for(FeeQuotationDetails feeQuotationDetails : reportDetail.getFeeQuotationDetails()){
				ReportsHelper.exportFeeQuotationResults(rowId, feeQuotationDetails, excelSheet);
				rowId++;
			}
			break;
		case AVERAGEFEESPAIDREPORT:
			for(AverageFeesPaidDetails averageFeePaidDetails : reportDetail.getAverageFeesPaidDetails()){
				ReportsHelper.exportAverageFeesPaidResults(rowId, averageFeePaidDetails, excelSheet);
				rowId++;
			}
			break;
		case FEEPROJECTIONREPORT:
			fillFeeProjectionHeaders(Integer.parseInt((String) ServletActionContext.getRequest().getSession().getAttribute(ALOCConstants.SELECTEDNOMONTHS)),excelSheet);
			for(FeeProjectionDetails feeProjectionDtl : reportDetail.getFeeProjectionDetails()){
				ReportsHelper.exportFeeProjectionReportResults(rowId, feeProjectionDtl , excelSheet);
				rowId++;
			}
			break;
		case CONTINGENTREPORT:
			if(!isExternal){
				for(ContingentliabilityDetails contingentDtl : reportDetail.getContingentliabilityDetails()){
					ReportsHelper.exportContigentLiabilityResults(rowId, contingentDtl, excelSheet);
					rowId++;
				}
			} else{
				for(ContingentliabilityDetails contingentDtl : reportDetail.getContingentliabilityDetails()){
					ReportsHelper.exportExternalContigentLiabilityResults(rowId, contingentDtl, excelSheet);
					rowId++;
				}
			}
			break;
		}
		return excelSheet;
	}

	/**
	 * Method to write the content to ECSO report Excel file
	 * @param rowId
	 * @param ecsoDetails
	 * @param poiWorkbook
	 * @param excelSheetObj
	 */
	private static void exportECSOResults(int rowId,ECSODetails ecsoDetails, ExcelSheet excelSheetObj) {
		Double csoAmount = null;
		Double outstandingAmount = null;
		Double usdAmount = null;
		Date csoApprovalDate = null;
		
		if(StringUtils.isNotBlank(ecsoDetails.getCSOAMOUNT()))
			csoAmount = Double.parseDouble(ecsoDetails.getCSOAMOUNT());
		if(StringUtils.isNotBlank(ecsoDetails.getOUTSTANDINGAMOUNT()))
			outstandingAmount = Double.parseDouble(ecsoDetails.getOUTSTANDINGAMOUNT());
		if(StringUtils.isNotBlank(ecsoDetails.getALOCUSDEQUIVALENTAMOUNT()))
			usdAmount = Double.parseDouble(ecsoDetails.getALOCUSDEQUIVALENTAMOUNT());
		try {
			if(StringUtils.isNotBlank(ecsoDetails.getCSOAPPROVALDATE()))
				csoApprovalDate = formatter.parse(ecsoDetails.getCSOAPPROVALDATE());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		fillCellDetails(excelSheetObj, ALOCConstants.ROW_ZERO, ecsoDetails.getSITEID()!=null ? ecsoDetails.getSITEID() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_ONE, ecsoDetails.getSITENAME()!=null ? ecsoDetails.getSITENAME() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWO, ecsoDetails.getALOCRECORD()!=null ? ecsoDetails.getALOCRECORD() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_THREE, ecsoDetails.getINSTRUMENTTYPE()!=null ? ecsoDetails.getINSTRUMENTTYPE().toString() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_FOUR, ecsoDetails.getGOLDID().toString()!=null ? ecsoDetails.getGOLDID().toString() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_FIVE, ecsoDetails.getCSOTYPE()!=null ? ecsoDetails.getCSOTYPE(): ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_SIX, ecsoDetails.getCSORECORD()!=null ? ecsoDetails.getCSORECORD() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_SEVEN, csoAmount, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_EIGHT, csoApprovalDate, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_NINE, ecsoDetails.getCSOAPPROVERNAME()!=null ? ecsoDetails.getCSOAPPROVERNAME() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TEN, usdAmount, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_ELEVEN, outstandingAmount, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWELVE, ecsoDetails.getSTATUS()!=null ? ecsoDetails.getSTATUS() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_THIRTEEN, ecsoDetails.getREQUESTORNAME()!=null ? ecsoDetails.getREQUESTORNAME() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_FOURTEEN, ecsoDetails.getREQUESTORSSO()!=null ? ecsoDetails.getREQUESTORSSO() : ALOCConstants.EMPTY_STRING, rowId);
	}
	
	/**
	 * Method to write the content to User Report Excel file
	 * @param rowId
	 * @param issuanceExpiration
	 * @param poiWorkbook
	 * @param excelSheetObj
	 */
	private static void exportUserResults(int rowId,UserReportDetails userReportDetails, ExcelSheet excelSheetObj) {
		site_Id = userReportDetails.getSiteIDs().toString().replace(ALOCConstants.REPORT_OPEN_BRACKET, ALOCConstants.REPORT_EMPTY_CHAR).replace(ALOCConstants.REPORT_CLOSE_BRACKET, ALOCConstants.REPORT_EMPTY_CHAR).trim();
		
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_ZERO, userReportDetails.getSiteIDs()!=null ? site_Id : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_ONE, userReportDetails.getSSOUserID()!=null ? userReportDetails.getSSOUserID().toString() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWO, userReportDetails.getName()!=null ? userReportDetails.getName().toString(): ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_THREE, userReportDetails.getUserRole()!=null ? userReportDetails.getUserRole().toString(): ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_FOUR, userReportDetails.getUserGroups()!=null ? userReportDetails.getUserGroups().toString(): ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_FIVE, userReportDetails.getStatus()!=null ? userReportDetails.getStatus().toString(): ALOCConstants.EMPTY_STRING, rowId);
		
		
	}
	
	/**
	 * Method to write the content to Fee Quotation Report Excel file
	 * @param rowId
	 * @param issuanceExpiration
	 * @param poiWorkbook
	 * @param excelSheetObj
	 */
	private static void exportFeeQuotationResults(int rowId,FeeQuotationDetails feeQuotationDetails, ExcelSheet excelSheetObj) {
		Double noOfIssuances = null;
		Double usdEquivalentOfIssuances = null;
		Double totalUSDEquivalentFees = null;
		Double otherFees = null;
		Double averageBPS = null;
		Double totalNoOfBids = null;
		issuers = feeQuotationDetails.getInIssuers().toString().replace(ALOCConstants.REPORT_OPEN_BRACKET, ALOCConstants.REPORT_EMPTY_CHAR).replace(ALOCConstants.REPORT_CLOSE_BRACKET, ALOCConstants.REPORT_EMPTY_CHAR).trim();
		
		if(StringUtils.isNotBlank(feeQuotationDetails.getNumberOfIssuances()))
			noOfIssuances = Double.parseDouble(feeQuotationDetails.getNumberOfIssuances());
		if(StringUtils.isNotBlank(feeQuotationDetails.getUSDEquivalentOfIssuances()))
			usdEquivalentOfIssuances = Double.parseDouble(feeQuotationDetails.getUSDEquivalentOfIssuances());
		if(StringUtils.isNotBlank(feeQuotationDetails.getTotalUSDEquivalentFees()))
			totalUSDEquivalentFees = Double.parseDouble(feeQuotationDetails.getTotalUSDEquivalentFees());
		if(StringUtils.isNotBlank(feeQuotationDetails.getOtherFees()))
			otherFees = Double.parseDouble(feeQuotationDetails.getOtherFees());
		if(StringUtils.isNotBlank(feeQuotationDetails.getAverageBPS()))
			averageBPS = Double.parseDouble(feeQuotationDetails.getAverageBPS());
		    averageBPS = (double) Math.round(averageBPS);
		if(StringUtils.isNotBlank(feeQuotationDetails.getTotalNumberOfBids()))
			totalNoOfBids = Double.parseDouble(feeQuotationDetails.getTotalNumberOfBids());
		
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_ZERO, feeQuotationDetails.getInIssuers()!=null ? issuers : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_ONE, feeQuotationDetails.getInCountryIssuance()!=null ? feeQuotationDetails.getInCountryIssuance().toString() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWO, noOfIssuances, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_THREE, usdEquivalentOfIssuances, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_FOUR, totalUSDEquivalentFees, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_FIVE, otherFees, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_SIX, averageBPS, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_SEVEN, totalNoOfBids, rowId);
		
	}

	/**
	 * Method to write the content to GCFO report Excel file
	 * @param rowId
	 * @param gcfoDetails
	 * @param poiWorkbook
	 * @param excelSheetObj
	 */
	private static void exportGCFOResults(int rowId,GCFODetails gcfoDetails, ExcelSheet excelSheetObj) {
		Double facilityAmount = null;
		Date facilityStartDate = null;
		Date facilityEndDate = null;
		
		if(StringUtils.isNotBlank(gcfoDetails.getFACILITYAMOUNT()))
			facilityAmount = Double.parseDouble(gcfoDetails.getFACILITYAMOUNT());
		try {
			if(StringUtils.isNotBlank(gcfoDetails.getFACILITYSTARTDATE()))
				facilityStartDate = formatter.parse(gcfoDetails.getFACILITYSTARTDATE());
			if(StringUtils.isNotBlank(gcfoDetails.getFACILITYENDDATE()))
				facilityEndDate = formatter.parse(gcfoDetails.getFACILITYENDDATE());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		fillCellDetails(excelSheetObj, ALOCConstants.ROW_ZERO, gcfoDetails.getGEBUSINESSGROUP()!=null ? gcfoDetails.getGEBUSINESSGROUP() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_ONE, gcfoDetails.getGCFORECORD()!=null ? gcfoDetails.getGCFORECORD().toString() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWO, gcfoDetails.getLECODEGOLDID()!=null ? gcfoDetails.getLECODEGOLDID().toString() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_THREE, gcfoDetails.getLENAME()!=null ? gcfoDetails.getLENAME() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_FOUR, gcfoDetails.getFACILITYTYPE()!=null ? gcfoDetails.getFACILITYTYPE() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_FIVE, facilityAmount, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_SIX, gcfoDetails.getFACILITYCURRENCY()!=null ? gcfoDetails.getFACILITYCURRENCY() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_SEVEN, gcfoDetails.getBUSINESSNAME()!=null ? gcfoDetails.getBUSINESSNAME() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_EIGHT, gcfoDetails.getBUSINESSSSO()!=null ? gcfoDetails.getBUSINESSSSO().toString() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_NINE, gcfoDetails.getPURPOSEOFCREDITFACILITYREMARKS()!=null ? gcfoDetails.getPURPOSEOFCREDITFACILITYREMARKS().toString() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TEN, facilityStartDate, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_ELEVEN, facilityEndDate, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWELVE, gcfoDetails.getSUPPORTEDENTITYNAME()!=null ? gcfoDetails.getSUPPORTEDENTITYNAME().toString() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_THIRTEEN, gcfoDetails.getBANKSPARENTNAME()!=null ? gcfoDetails.getBANKSPARENTNAME().toString() : ALOCConstants.EMPTY_STRING, rowId);		
	}

	/**
	 * Method to write the content to Fee paid report Excel file
	 * @param rowId
	 * @param feepaidDetails
	 * @param poiWorkbook
	 * @param excelSheetObj
	 */
	private static void exportFeesPaidResults(int rowId,FeesPaidDetails feepaidDetails, ExcelSheet excelSheetObj) {
		Double feeAmount = null;
		Double instrumentAmount = null;
		Double usdAmount = null;
		Double usAllInRateArrearsBpsFee = null;
		Double usAllInRateInAdvance = null;
		Double usFlatFeeInAdvance = null;
		Double usFlatFeeLifeInAdvance = null;
		Double foreignAllInRateArrears = null;
		Double foreignAllInRateInAdvance = null;
		Double foreignFlatFeeInAdvance = null;
		Double foreignFlatFeeLifeInAdvance = null;
		Double foreignAmendmentFees = null;
		Double usAmendmentFees = null;
		Double otherFees = null;
		Date issueDate = null;
		Date paymentDate = null;
		site_Id = feepaidDetails.getBusinessSites().toString().replace(ALOCConstants.REPORT_OPEN_BRACKET, ALOCConstants.REPORT_EMPTY_CHAR).replace(ALOCConstants.REPORT_CLOSE_BRACKET, ALOCConstants.REPORT_EMPTY_CHAR).trim();
		
		if(StringUtils.isNotBlank(feepaidDetails.getUSDEquinsAmount()))
			instrumentAmount = Double.parseDouble(feepaidDetails.getUSDEquinsAmount());
		if(feepaidDetails.getUSDEquivalentAmount() != null)
			usdAmount = feepaidDetails.getUSDEquivalentAmount().doubleValue();
		if(StringUtils.isNotBlank(feepaidDetails.getAmountOfFee()))
			feeAmount = Double.parseDouble(feepaidDetails.getAmountOfFee());
		if(StringUtils.isNotBlank(feepaidDetails.getUSPAArrearsBPSFee()))
			usAllInRateArrearsBpsFee = Double.parseDouble(feepaidDetails.getUSPAArrearsBPSFee());
		if(StringUtils.isNotBlank(feepaidDetails.getUSPAInAdvance()))
			usAllInRateInAdvance = Double.parseDouble(feepaidDetails.getUSPAInAdvance());
		if(StringUtils.isNotBlank(feepaidDetails.getUSFlatFeePAInAdvance()))
			usFlatFeeInAdvance = Double.parseDouble(feepaidDetails.getUSFlatFeePAInAdvance());
		if(StringUtils.isNotBlank(feepaidDetails.getUSFlatFeeLifeInAdvance()))
			usFlatFeeLifeInAdvance = Double.parseDouble(feepaidDetails.getUSFlatFeeLifeInAdvance());
		if(StringUtils.isNotBlank(feepaidDetails.getForeignRatePAArrears()))
			foreignAllInRateArrears = Double.parseDouble(feepaidDetails.getForeignRatePAArrears());
		if(StringUtils.isNotBlank(feepaidDetails.getForeignRatePAInAdvance()))
			foreignAllInRateInAdvance = Double.parseDouble(feepaidDetails.getForeignRatePAInAdvance());
		if(StringUtils.isNotBlank(feepaidDetails.getForeignFlatFeePAInAdvance()))
			foreignFlatFeeInAdvance = Double.parseDouble(feepaidDetails.getForeignFlatFeePAInAdvance());
		if(StringUtils.isNotBlank(feepaidDetails.getForeignFlatFeeLifeInAdvance()))
			foreignFlatFeeLifeInAdvance = Double.parseDouble(feepaidDetails.getForeignFlatFeeLifeInAdvance());
		if(StringUtils.isNotBlank(feepaidDetails.getUSAmendmentFees()))
			usAmendmentFees = Double.parseDouble(feepaidDetails.getUSAmendmentFees());
		if(StringUtils.isNotBlank(feepaidDetails.getForeignAmendmentFees()))
			foreignAmendmentFees = Double.parseDouble(feepaidDetails.getForeignAmendmentFees());
		if(StringUtils.isNotBlank(feepaidDetails.getOtherFees()))
			otherFees = Double.parseDouble(feepaidDetails.getOtherFees());
		
		try {
			if(StringUtils.isNotBlank(feepaidDetails.getIssuanceDate()))
				issueDate = formatter.parse(feepaidDetails.getIssuanceDate());
			if(StringUtils.isNotBlank(feepaidDetails.getPaymentDate()))
				paymentDate = formatter.parse(feepaidDetails.getPaymentDate());
		} catch (ParseException e) {
			e.printStackTrace();
		}	
		
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_ZERO, feepaidDetails.getALOCRecordNumber()!=null ? feepaidDetails.getALOCRecordNumber().toString() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_ONE, feepaidDetails.getGeref1()!=null ? feepaidDetails.getGeref1() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWO, feepaidDetails.getBankReferenceNumber()!=null ? feepaidDetails.getBankReferenceNumber().toString() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_THREE, feepaidDetails.getIssuer()!=null ? feepaidDetails.getIssuer() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_FOUR, feeAmount, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_FIVE, feepaidDetails.getCountryOfIssuance()!=null ? feepaidDetails.getCountryOfIssuance().toString() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_SIX, feepaidDetails.getFeeCurrency()!=null ? feepaidDetails.getFeeCurrency() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_SEVEN, instrumentAmount, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_EIGHT, usdAmount, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_NINE, feepaidDetails.getBusinessSites()!=null ? site_Id : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TEN, issueDate, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_ELEVEN, paymentDate, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWELVE, feepaidDetails.getPaymentID()!=null ? feepaidDetails.getPaymentID().toString() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_THIRTEEN, usAllInRateArrearsBpsFee, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_FOURTEEN, usAllInRateInAdvance, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_FIFTEEN, usFlatFeeInAdvance, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_SIXTEEN, usFlatFeeLifeInAdvance, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_SEVENTEEN, foreignAllInRateArrears, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_EIGHTEEN, foreignAllInRateInAdvance, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_NINTEEN, foreignFlatFeeInAdvance, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWENTY, foreignFlatFeeLifeInAdvance, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWENTYONE, usAmendmentFees, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWENTYTWO, foreignAmendmentFees, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWENTYTHREE, otherFees, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWENTYFOUR, feepaidDetails.getRequestorName()!=null ? feepaidDetails.getRequestorName() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWENTYFIVE, feepaidDetails.getRequestorSso()!=null ? feepaidDetails.getRequestorSso() : ALOCConstants.EMPTY_STRING, rowId);
	}

	/**
	 * Method to write the content to Issuance and expiration report Excel file
	 * @param rowId
	 * @param issuanceExpiration
	 * @param poiWorkbook
	 * @param excelSheetObj
	 */
	private static void exportIssuanceExpirationResults(int rowId,IssuanceExpirationDetails issuanceExpiration, ExcelSheet excelSheetObj) {
		Double instrumentAmount = null;
		Double fxRate = null;
		Double usdAmount = null;
		Date issuanceDate = null;
		Date usExpirationDate = null;
		Date foreignExpirationDate = null;
		Date economicExpDate = null;
		Date contractDate = null;
		
	    site_Id = issuanceExpiration.getSiteIDs().toString().replace(ALOCConstants.REPORT_OPEN_BRACKET, ALOCConstants.REPORT_EMPTY_CHAR).replace(ALOCConstants.REPORT_CLOSE_BRACKET, ALOCConstants.REPORT_EMPTY_CHAR).trim();
		beneficiary_Obligee_Name = issuanceExpiration.getBeneficiaryObligeeNames().toString().replace(ALOCConstants.REPORT_OPEN_BRACKET, ALOCConstants.REPORT_EMPTY_CHAR).replace(ALOCConstants.REPORT_CLOSE_BRACKET, ALOCConstants.REPORT_EMPTY_CHAR).trim();
		applicant_Principal_Name = issuanceExpiration.getApplicantPrincipals().toString().replace(ALOCConstants.REPORT_OPEN_BRACKET, ALOCConstants.REPORT_EMPTY_CHAR).replace(ALOCConstants.REPORT_CLOSE_BRACKET, ALOCConstants.REPORT_EMPTY_CHAR).trim();
		thirdParty_Applicant_Name = issuanceExpiration.getThirdpartyApplicants().toString().replace(ALOCConstants.REPORT_OPEN_BRACKET, ALOCConstants.REPORT_EMPTY_CHAR).replace(ALOCConstants.REPORT_CLOSE_BRACKET, ALOCConstants.REPORT_EMPTY_CHAR).trim();
		instrument_Type = issuanceExpiration.getInstrumentTypes().toString().replace(ALOCConstants.REPORT_OPEN_BRACKET, ALOCConstants.REPORT_EMPTY_CHAR).replace(ALOCConstants.REPORT_CLOSE_BRACKET, ALOCConstants.REPORT_EMPTY_CHAR).trim();
		
		if(StringUtils.isNotBlank(issuanceExpiration.getInstrumentAmount()))
			instrumentAmount= Double.parseDouble(issuanceExpiration.getInstrumentAmount());
		if(StringUtils.isNotBlank(issuanceExpiration.getFXRateMonthMOR()))
			fxRate = Double.parseDouble(issuanceExpiration.getFXRateMonthMOR());
		if(issuanceExpiration.getUSDAmount() != null)
			usdAmount = issuanceExpiration.getUSDAmount().doubleValue();
		
		try {
			if(StringUtils.isNotBlank(issuanceExpiration.getIssuanceDate()))
				issuanceDate = formatter.parse(issuanceExpiration.getIssuanceDate());
			if(StringUtils.isNotBlank(issuanceExpiration.getUSExpirationDate()))
				usExpirationDate = formatter.parse(issuanceExpiration.getUSExpirationDate());
			if(StringUtils.isNotBlank(issuanceExpiration.getForeignExpDate()))
				foreignExpirationDate = formatter.parse(issuanceExpiration.getForeignExpDate());
			if(StringUtils.isNotBlank(issuanceExpiration.getEconomicExpDate()))
				economicExpDate = formatter.parse(issuanceExpiration.getEconomicExpDate());
			if(StringUtils.isNotBlank(issuanceExpiration.getCurrentContact()))
				contractDate = formatter.parse(issuanceExpiration.getCurrentContact());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_ZERO, issuanceExpiration.getSiteIDs()!=null ? site_Id : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_ONE, issuanceExpiration.getALOCRecordNumber()!=null ? issuanceExpiration.getALOCRecordNumber().toString() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWO, issuanceExpiration.getBeneficiaryObligeeNames()!=null ? beneficiary_Obligee_Name : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_THREE, issuanceExpiration.getBeneficiaryObligeeCountry()!=null ? issuanceExpiration.getBeneficiaryObligeeCountry().toString() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_FOUR, issuanceExpiration.getCountryOfIssuance()!=null ? issuanceExpiration.getCountryOfIssuance().toString() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_FIVE, issuanceExpiration.getApplicantPrincipals()!=null ? applicant_Principal_Name : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_SIX, issuanceExpiration.getThirdpartyApplicants()!=null ? thirdParty_Applicant_Name : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_SEVEN, issuanceExpiration.getInstrumentCurrency()!=null ? issuanceExpiration.getInstrumentCurrency().toString() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_EIGHT, instrumentAmount, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_NINE, usdAmount, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TEN, fxRate, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_ELEVEN, issuanceDate, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWELVE, usExpirationDate, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_THIRTEEN, foreignExpirationDate, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_FOURTEEN, economicExpDate, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_FIFTEEN, issuanceExpiration.getIssuer()!=null ? issuanceExpiration.getIssuer().toString() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_SIXTEEN, issuanceExpiration.getIssuingBankBranch()!=null ? issuanceExpiration.getIssuingBankBranch().toString() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_SEVENTEEN, issuanceExpiration.getCurrentContactNameSSO()!=null ? issuanceExpiration.getCurrentContactNameSSO().toString() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_EIGHTEEN, issuanceExpiration.getCurrentContactSSO()!=null ? issuanceExpiration.getCurrentContactSSO().toString() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_NINTEEN, issuanceExpiration.getRequestor()!=null ? issuanceExpiration.getRequestor().toString() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWENTY, issuanceExpiration.getRequestorSSO()!=null ? issuanceExpiration.getRequestorSSO().toString() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWENTYONE, issuanceExpiration.getBUC()!=null ? issuanceExpiration.getBUC().toString() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWENTYTWO, issuanceExpiration.getADN()!=null ? issuanceExpiration.getADN().toString() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWENTYTHREE, issuanceExpiration.getGEReference()!=null ? issuanceExpiration.getGEReference().toString() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWENTYFOUR, contractDate, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWENTYFIVE, issuanceExpiration.getInstrumentTypes()!=null ? instrument_Type : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWENTYSIX, issuanceExpiration.getInstrumentPurpose()!=null ? issuanceExpiration.getInstrumentPurpose().toString() : ALOCConstants.EMPTY_STRING, rowId);
	}

	/**
	 * Method to write the content to aging report Excel file
	 * @param rowId
	 * @param agingDetail
	 * @param poiWorkbook
	 * @param excelSheetObj
	 */
	private static void exportAgingResults(int rowId,AgingDetails agingDetail, ExcelSheet excelSheetObj) {
		Double instrumentAmount = null;
		Double inAgingMonths = null;
		Date expirationDate = null;
		Date issuanceDate = null;
		Date originalExpirationDate = null;
		site_Id = agingDetail.getSiteIDs().toString().replace(ALOCConstants.REPORT_OPEN_BRACKET, ALOCConstants.REPORT_EMPTY_CHAR).replace(ALOCConstants.REPORT_CLOSE_BRACKET, ALOCConstants.REPORT_EMPTY_CHAR).trim();
		String instrumentAmountWithDecimal = ALOCCommonHelper.getStringWithDecimalValue(agingDetail.getInstrumentAmount());
		
		if(StringUtils.isNotBlank(instrumentAmountWithDecimal))
			instrumentAmount = Double.parseDouble(instrumentAmountWithDecimal);
		if(StringUtils.isNotBlank(agingDetail.getInAgingMonths()))
			inAgingMonths = Double.parseDouble(agingDetail.getInAgingMonths());
		try {
			if(StringUtils.isNotBlank(agingDetail.getIssuanceDate()))
				issuanceDate = formatter.parse(agingDetail.getIssuanceDate());
			if(StringUtils.isNotBlank(agingDetail.getExpirationDate()))
				expirationDate = formatter.parse(agingDetail.getExpirationDate());
			if(StringUtils.isNotBlank(agingDetail.getOrigEconExpirationDate()))
				originalExpirationDate = formatter.parse(agingDetail.getOrigEconExpirationDate());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_ZERO, agingDetail.getALOCRecord()!=null ? agingDetail.getALOCRecord() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_ONE, agingDetail.getSiteIDs()!=null ? site_Id : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWO, agingDetail.getApplicantName()!=null ? agingDetail.getApplicantName().toString(): ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_THREE, agingDetail.getIssuer()!=null ? agingDetail.getIssuer().toString() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_FOUR, agingDetail.getBeneficiaryName()!=null ? agingDetail.getBeneficiaryName().toString() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_FIVE, agingDetail.getBeneCountry()!=null ? agingDetail.getBeneCountry() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_SIX, agingDetail.getCountryofIssuance()!=null ? agingDetail.getCountryofIssuance().toString() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_SEVEN, issuanceDate, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_EIGHT, instrumentAmount, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_NINE, agingDetail.getInstrumentCurrency()!=null ? agingDetail.getInstrumentCurrency() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TEN, inAgingMonths, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_ELEVEN, expirationDate, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWELVE, originalExpirationDate, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_THIRTEEN, agingDetail.getRequestorName()!=null ? agingDetail.getRequestorName().toString() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_FOURTEEN, agingDetail.getRequestorSso()!=null ? agingDetail.getRequestorSso().toString() : ALOCConstants.EMPTY_STRING, rowId);
	}


	/**
	 * Method to write the content to bid success report Excel file
	 * @param rowId
	 * @param bidSuccessDtl
	 * @param poiWorkbook
	 * @param excelSheetObj
	 */
	private static void exportBidSuccessResults(int rowId , BidSuccessDetails bidSuccessDtl, ExcelSheet excelSheetObj) {
		Double totalNoOfBids = null;
		Double totalNoOfReplies = null;
		Double totalWon = null;
		Double totalLost = null;
		Double totalOptOut = null;
		Double totalExpired = null;
		Double wonPercentage = null;
		Double lossPercentage = null;
		site_Id = bidSuccessDtl.getSITEIDS().toString().replace(ALOCConstants.REPORT_OPEN_BRACKET, ALOCConstants.REPORT_EMPTY_CHAR).replace(ALOCConstants.REPORT_CLOSE_BRACKET, ALOCConstants.REPORT_EMPTY_CHAR).trim();
		if(StringUtils.isNotBlank(bidSuccessDtl.getTotalofBids()))
			totalNoOfBids = Double.parseDouble(bidSuccessDtl.getTotalofBids());
		if(StringUtils.isNotBlank(bidSuccessDtl.getTotalofReplies()))
			totalNoOfReplies = Double.parseDouble(bidSuccessDtl.getTotalofReplies());
		if(StringUtils.isNotBlank(bidSuccessDtl.getTotalWon()))
			totalWon = Double.parseDouble(bidSuccessDtl.getTotalWon());
		if(StringUtils.isNotBlank(bidSuccessDtl.getTotalLost()))
			totalLost = Double.parseDouble(bidSuccessDtl.getTotalLost());
		if(StringUtils.isNotBlank(bidSuccessDtl.getTotalOptOut()))
			totalOptOut = Double.parseDouble(bidSuccessDtl.getTotalOptOut());
		if(StringUtils.isNotBlank(bidSuccessDtl.getTotalExpired()))
			totalExpired = Double.parseDouble(bidSuccessDtl.getTotalExpired());
		if(StringUtils.isNotBlank(bidSuccessDtl.getWon()))
			wonPercentage = Double.parseDouble(bidSuccessDtl.getWon());
		if(StringUtils.isNotBlank(bidSuccessDtl.getLost()))
			lossPercentage = Double.parseDouble(bidSuccessDtl.getLost());
		
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_ZERO, bidSuccessDtl.getSITEIDS()!=null ? site_Id : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_ONE, bidSuccessDtl.getBANKNAME()!=null ? bidSuccessDtl.getBANKNAME() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWO, bidSuccessDtl.getCOUNTRYISSUE()!=null ? bidSuccessDtl.getCOUNTRYISSUE() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_THREE, bidSuccessDtl.getCURRENCYISSUE()!=null ? bidSuccessDtl.getCURRENCYISSUE() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_FOUR, totalNoOfBids, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_FIVE, totalNoOfReplies, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_SIX, totalWon, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_SEVEN, totalLost, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_EIGHT, totalOptOut, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_NINE, totalExpired, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TEN, wonPercentage, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_ELEVEN, lossPercentage, rowId);
	}
  
	/**
	 * Method to write the content to Cycle time report Excel file
	 * @param rowId
	 * @param cycleTimeDtl
	 * @param poiWorkbook
	 * @param excelSheetObj
	 */
	private static void exportCycleTimeResults(int rowId , CycleTimeDetails cycleTimeDtl, ExcelSheet excelSheetObj) {
		Double businessAmount = null;
		Double treasury1Amount = null;
		Double treasury2Amount = null;
		Double bank1Amount = null;
		Double bank2Amount = null;
		Double totalAmount = null;
		site_Id = cycleTimeDtl.getSiteIds().toString().replace(ALOCConstants.REPORT_OPEN_BRACKET, ALOCConstants.REPORT_EMPTY_CHAR).replace(ALOCConstants.REPORT_CLOSE_BRACKET, ALOCConstants.REPORT_EMPTY_CHAR).trim();
		instrument_Type = cycleTimeDtl.getInstrumentTypes().toString().replace(ALOCConstants.REPORT_OPEN_BRACKET, ALOCConstants.REPORT_EMPTY_CHAR).replace(ALOCConstants.REPORT_CLOSE_BRACKET, ALOCConstants.REPORT_EMPTY_CHAR).trim();
		instrument_Purpose = cycleTimeDtl.getInstrumentPurposes().toString().replace(ALOCConstants.REPORT_OPEN_BRACKET, ALOCConstants.REPORT_EMPTY_CHAR).replace(ALOCConstants.REPORT_CLOSE_BRACKET, ALOCConstants.REPORT_EMPTY_CHAR).trim();
		
		if(StringUtils.isNotBlank(cycleTimeDtl.getBusiness()))
			businessAmount = Double.parseDouble(cycleTimeDtl.getBusiness());
		if(StringUtils.isNotBlank(cycleTimeDtl.getTreasury1()))
			treasury1Amount = Double.parseDouble(cycleTimeDtl.getTreasury1());
		if(StringUtils.isNotBlank(cycleTimeDtl.getTreasury2()))
			treasury2Amount = Double.parseDouble(cycleTimeDtl.getTreasury2());
		if(StringUtils.isNotBlank(cycleTimeDtl.getBank1()))
			bank1Amount = Double.parseDouble(cycleTimeDtl.getBank1());
		if(StringUtils.isNotBlank(cycleTimeDtl.getBank2()))
			bank2Amount = Double.parseDouble(cycleTimeDtl.getBank2());
		if(StringUtils.isNotBlank(cycleTimeDtl.getTotal()))
			totalAmount = Double.parseDouble(cycleTimeDtl.getTotal());
		
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_ZERO, cycleTimeDtl.getALOCRecordNumber()!=null ? cycleTimeDtl.getALOCRecordNumber() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_ONE, cycleTimeDtl.getSiteIds().toString()!=null ? site_Id : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWO, cycleTimeDtl.getApplicantName()!=null ? cycleTimeDtl.getApplicantName() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_THREE, cycleTimeDtl.getIssuer()!=null ? cycleTimeDtl.getIssuer(): ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_FOUR, cycleTimeDtl.getIssuingBankBranch()!=null ? cycleTimeDtl.getIssuingBankBranch() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_FIVE, cycleTimeDtl.getBeneficiaryName()!=null ? cycleTimeDtl.getBeneficiaryName() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_SIX, cycleTimeDtl.getBeneficiaryCountry()!=null ? cycleTimeDtl.getBeneficiaryCountry() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_SEVEN, cycleTimeDtl.getCountryOfIssuance()!=null ? cycleTimeDtl.getCountryOfIssuance() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_EIGHT, cycleTimeDtl.getInstrumentTypes().toString()!=null ? instrument_Type : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_NINE, cycleTimeDtl.getInstrumentPurposes().toString()!=null ? instrument_Purpose : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TEN, businessAmount, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_ELEVEN, treasury1Amount, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWELVE, treasury2Amount, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_THIRTEEN, bank1Amount, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_FOURTEEN, bank2Amount, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_FIFTEEN, totalAmount, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_SIXTEEN, cycleTimeDtl.getRequestorName()!=null ? cycleTimeDtl.getRequestorName() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_SEVENTEEN, cycleTimeDtl.getRequestorSso()!=null ? cycleTimeDtl.getRequestorSso() : ALOCConstants.EMPTY_STRING, rowId);
	}
	
	/**
	 * Method to write the content to Average Fees Paid report Excel file
	 * @param rowId
	 * @param averageFeePaidDtl
	 * @param poiWorkbook
	 * @param excelSheetObj
	 */
	private static void exportAverageFeesPaidResults(int rowId,AverageFeesPaidDetails averageFeePaidDtl , ExcelSheet excelSheetObj){
		Double noOfIssuances = null;
		Double usdEquivalentAmount = null;
		Double noOfIssuancesUnderOneYear = null;
		Double amountUnderOneYear = null;
		Double noOfIssuancesOneToThreeYears = null;
		Double amountUnderOneToThreeYears = null;
		Double noOfIssuancesThreeToFive = null;
		Double amountUnderThreeToFiveYears = null;
		Double noOfIssuancesGreaterThanFiveYears = null;
		Double amountGreaterThanFiveYears = null;
		
		if(StringUtils.isNotBlank(averageFeePaidDtl.getNoofIssuances()))
			noOfIssuances = Double.parseDouble(averageFeePaidDtl.getNoofIssuances());
		if(StringUtils.isNotBlank(averageFeePaidDtl.getUSDEquivalentValue()))
			usdEquivalentAmount = Double.parseDouble(averageFeePaidDtl.getUSDEquivalentValue());
		if(StringUtils.isNotBlank(averageFeePaidDtl.getCOUNTLT1YR()))
			noOfIssuancesUnderOneYear = Double.parseDouble(averageFeePaidDtl.getCOUNTLT1YR());
		if(StringUtils.isNotBlank(averageFeePaidDtl.getUNDER1YR()))
			amountUnderOneYear = Double.parseDouble(averageFeePaidDtl.getUNDER1YR());
		if(StringUtils.isNotBlank(averageFeePaidDtl.getUNDER1TO3YEARS()))
			noOfIssuancesOneToThreeYears = Double.parseDouble(averageFeePaidDtl.getUNDER1TO3YEARS());
		if(StringUtils.isNotBlank(averageFeePaidDtl.getCOUNT1TO3()))
			amountUnderOneToThreeYears = Double.parseDouble(averageFeePaidDtl.getCOUNT1TO3());
		if(StringUtils.isNotBlank(averageFeePaidDtl.getUNDER3TO5YEARS()))
			noOfIssuancesThreeToFive = Double.parseDouble(averageFeePaidDtl.getUNDER3TO5YEARS());
		if(StringUtils.isNotBlank(averageFeePaidDtl.getCOUNT3TO5()))
			amountUnderThreeToFiveYears = Double.parseDouble(averageFeePaidDtl.getCOUNT3TO5());
		if(StringUtils.isNotBlank(averageFeePaidDtl.getCOUNTGT5YR()))
			noOfIssuancesGreaterThanFiveYears = Double.parseDouble(averageFeePaidDtl.getCOUNTGT5YR());
		if(StringUtils.isNotBlank(averageFeePaidDtl.getGT5YR()))
			amountGreaterThanFiveYears = Double.parseDouble(averageFeePaidDtl.getGT5YR());
		
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_ZERO, averageFeePaidDtl.getUSDEQUIAMOUNT()!=null ? averageFeePaidDtl.getUSDEQUIAMOUNT() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_ONE, noOfIssuances, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWO, usdEquivalentAmount, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_THREE, noOfIssuancesUnderOneYear, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_FOUR, amountUnderOneYear, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_FIVE, noOfIssuancesOneToThreeYears, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_SIX, amountUnderOneToThreeYears, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_SEVEN, noOfIssuancesThreeToFive, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_EIGHT, amountUnderThreeToFiveYears, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_NINE, noOfIssuancesGreaterThanFiveYears, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TEN, amountGreaterThanFiveYears, rowId);

	}
	
	/**
	 * Method to export FeeProjection Details
	 * @param rowId
	 * @param feeProjectionDtl
	 * @param poiWorkbook
	 * @param excelSheet
	 */
	private static void exportFeeProjectionReportResults(int rowId,FeeProjectionDetails feeProjectionDtl, ExcelSheet excelSheetObj) {
		Double usdEquivalentAmount = null;
		Double monthRange1 = null;
		Double monthRange2 = null;
		Double monthRange3 = null;
		Double monthRange4 = null;
		Date issueDate = null;
		Date expiryDate = null;
		
		if(StringUtils.isNotBlank(feeProjectionDtl.getUSDEQUIVALENTAMT()))
			usdEquivalentAmount = Double.parseDouble(feeProjectionDtl.getUSDEQUIVALENTAMT());
		if(StringUtils.isNotBlank(feeProjectionDtl.getMONTHRANGE1()))
			monthRange1 = Double.parseDouble(feeProjectionDtl.getMONTHRANGE1());
		if(StringUtils.isNotBlank(feeProjectionDtl.getMONTHRANGE2()))
			monthRange2 = Double.parseDouble(feeProjectionDtl.getMONTHRANGE2());
		if(StringUtils.isNotBlank(feeProjectionDtl.getMONTHRANGE3()))
			monthRange3 = Double.parseDouble(feeProjectionDtl.getMONTHRANGE3());
		if(StringUtils.isNotBlank(feeProjectionDtl.getMONTHRANGE4()))
			monthRange4 = Double.parseDouble(feeProjectionDtl.getMONTHRANGE4());
		
		try {
			if(StringUtils.isNotBlank(feeProjectionDtl.getISSUEDATE()))
				issueDate = formatter.parse(feeProjectionDtl.getISSUEDATE());
			if(StringUtils.isNotBlank(feeProjectionDtl.getEXPIRYDATE()))
				expiryDate = formatter.parse(feeProjectionDtl.getEXPIRYDATE());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_ZERO, feeProjectionDtl.getALOCRECORDNUM()!=null ? feeProjectionDtl.getALOCRECORDNUM() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_ONE, feeProjectionDtl.getBANKREFNUM()!=null ? feeProjectionDtl.getBANKREFNUM() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWO, usdEquivalentAmount, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_THREE, feeProjectionDtl.getCURRENCYOFINSTRUMENT()!=null ? feeProjectionDtl.getCURRENCYOFINSTRUMENT() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_FOUR, issueDate, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_FIVE, expiryDate, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_SIX, monthRange1, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_SEVEN, monthRange2, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_EIGHT, monthRange3, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_NINE, monthRange4, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TEN, feeProjectionDtl.getRequestorName()!=null ? feeProjectionDtl.getRequestorName() : ALOCConstants.EMPTY_STRING, rowId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_ELEVEN, feeProjectionDtl.getRequestorSso()!=null ? feeProjectionDtl.getRequestorSso() : ALOCConstants.EMPTY_STRING, rowId);
	}	
	
	/**
	 * Method to convert Instrument to Filter
	 * @param instrumentTypes
	 * @return
	 */
	
	public static FilterBO getInstrumentFilter(InstrumentType[] instrumentTypes){
		StringBuilder instrumentId = new StringBuilder();
		for(int i=ALOCConstants.BASE_VALUE; i<instrumentTypes.length; i++){
			instrumentId.append(instrumentTypes[i].getId());
			if(i < instrumentTypes.length - ALOCConstants.MIN_VALUE) {
				instrumentId.append(ALOCConstants.REPORT_COMMA);
			}
		}
		
		FilterBO instrumentFilter = new FilterBO();
		instrumentFilter.setCondition(ALOCConstants.AND);
		instrumentFilter.setFieldId(ALOCConstants.INSTRUMENT_ID);
		instrumentFilter.setOperatorType(Operator.IN);
		List<String> instrumentValue = new ArrayList<String>();
		instrumentValue.add(instrumentId.toString());
		instrumentFilter.setValue(instrumentValue);
		
		return instrumentFilter;
	}
	
	/**
	 * 
	 * @param template
	 * @return
	 */
	public static FilterBO setDateFilterValues(TemplateBO template) throws ParseException{
		List<String> dateFilterValue = new ArrayList<String>();
		FilterBO dateFilter = new FilterBO();
		
		dateFilterValue.add(DataType.DATE.storageTimestampFormat(template.getFromDate()));
		dateFilterValue.add(DataType.DATE.storageTimestampFormat(template.getToDate()));
		dateFilter.setCondition(ALOCConstants.WHERE);
		dateFilter.setFieldId(template.getDateFilter());
		dateFilter.setOperatorType(Operator.IN_BETWEEN);
		dateFilter.setValue(dateFilterValue);
		return dateFilter;
	}
	
	/**
	 * Method to fill the Headers for the Fee Projection Report
	 */
	private static void fillFeeProjectionHeaders(int noOfMonths,ExcelSheet excelSheet){
		int dividedVal = noOfMonths/ALOCConstants.FEE_PROJ_REPORT_NUM_FOUR;
		String firstCell =  ALOCConstants.BASE_VALUE + ALOCConstants.BANKLOOKUP_HYPEN + (int)dividedVal*ALOCConstants.FEE_PROJ_REPORT_NUM_ONE + ALOCConstants.MONTHS;
		String secondCell = (int) dividedVal*ALOCConstants.FEE_PROJ_REPORT_NUM_ONE + ALOCConstants.BANKLOOKUP_HYPEN + (int)dividedVal*ALOCConstants.FEE_PROJ_REPORT_NUM_TWO + ALOCConstants.MONTHS ;
		String thirdCell = (int) dividedVal*ALOCConstants.FEE_PROJ_REPORT_NUM_TWO + ALOCConstants.BANKLOOKUP_HYPEN + (int)dividedVal*ALOCConstants.FEE_PROJ_REPORT_NUM_THREE +  ALOCConstants.MONTHS;
		String fourthCel = (int) dividedVal*ALOCConstants.FEE_PROJ_REPORT_NUM_THREE + ALOCConstants.BANKLOOKUP_HYPEN + noOfMonths +  ALOCConstants.MONTHS;
		
		fillCellDetails(excelSheet, ALOCConstants.ROW_SIX, firstCell, ALOCConstants.ROW_ONE);
		fillCellDetails(excelSheet, ALOCConstants.ROW_SEVEN, secondCell, ALOCConstants.ROW_ONE);
		fillCellDetails(excelSheet, ALOCConstants.ROW_EIGHT, thirdCell, ALOCConstants.ROW_ONE);
		fillCellDetails(excelSheet, ALOCConstants.ROW_NINE, fourthCel, ALOCConstants.ROW_ONE);
	}
	
	

}
