/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: APMDetailsHelper.java
 * Purpose: APMDetailsHelper used to have the export csv details
 */
package com.ge.aloc.util;

import static com.ge.aloc.constants.ALOCConstants.APPLICATION_VND_MS_EXCEL;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ge.aloc.ALOCContext;
import com.ge.aloc.FHSearchCriteriaType;
import com.ge.aloc.action.apm.FeeHistoryAction;
import com.ge.aloc.bo.excel.CellDetail;
import com.ge.aloc.bo.excel.ExcelSheet;
import com.ge.aloc.bo.excel.ExcelSheetCollection;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.exception.ALOCRuntimeException;
import com.ge.aloc.manager.apm.IAPMDetailsManager;
import com.ge.aloc.model.APMDetails;
import com.ge.aloc.model.APMSearch;
import com.ge.aloc.model.AddressDtls;
import com.ge.aloc.model.CreditAndCarryOverReport;
import com.ge.aloc.model.CurrencySetup;
import com.ge.aloc.model.FeeCalculationDetails;
import com.ge.aloc.model.FeeDetails;
import com.ge.aloc.model.FeePeriodDetails;
import com.ge.aloc.model.FeeSummary;
import com.ge.aloc.model.FullSummary;
import com.ge.aloc.model.GetFXRates;
import com.ge.aloc.model.InvoiceDetails;
import com.ge.aloc.model.MDM.Country;
import com.ge.aloc.model.MDM.Currency;
import com.ge.aloc.model.NameValue;
import com.ge.aloc.model.OtherFee;
import com.ge.aloc.model.PaymentPeriodDetails;
import com.ge.aloc.model.RequestFeeDetails;
import com.ge.aloc.model.StaticDataManagement.UserSites;
import com.ge.aloc.model.USForeignFee;
import com.hydus.hwf.exceptions.HWFServiceException;


/**
 * @author madhusudhan.gosula
 *
 */

public class APMDetailsHelper {
	private static final Logger LOGGER = Logger.getLogger(FeeHistoryAction.class);

	/**
	 * This method to used to add cells to excel sheet
	 * @param objId
	 * @param fxRates
	 * @param poiWorkbook
	 * @param excelSheets
	 * @param excelSheetObj
	 */
	public static void repeatableExcelObjects(int objId , GetFXRates fxRates,HSSFWorkbook poiWorkbook ,ExcelSheet excelSheetObj){
		SimpleDateFormat formatter = new SimpleDateFormat(ALOCConstants.FORMAT_INV_PATTERN);

		fillCellDetails(excelSheetObj, ALOCConstants.NUM_ZERO, fxRates.getCurrencyCode(), objId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_ONE, fxRates.getFXRate()!=null ? ALOCCommonHelper.getStringWithDecimalValue(fxRates.getFXRate().toString()) : ALOCConstants.EMPTY_STRING, objId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWO, fxRates.getFXRateSource(), objId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_THREE, fxRates.getFXRateDate()!=null ? formatter.format(fxRates.getFXRateDate().getTime()) : ALOCConstants.EMPTY_STRING, objId);
	}

	/**
	 * This method to used to fill cell details to the excel sheet
	 * @param excelSheetObj
	 * @param i
	 * @param value
	 * @param objId
	 */
	private static void fillCellDetails(ExcelSheet excelSheetObj, int i, String value, int objId) {
		CellDetail cellDetailObj = new CellDetail();
		cellDetailObj.setRowId(objId);
		cellDetailObj.setColumnId(i);
		cellDetailObj.setValue(value);
		excelSheetObj.getCellDetail().add(cellDetailObj);

	}


	/**
	 * This method is used to get the row values and set it into payment period
	 * @return
	 * @throws ParseException
	 */
	public  static PaymentPeriodDetails getRowValues() throws ParseException{

		PaymentPeriodDetails payment=new PaymentPeriodDetails();
		HttpServletRequest request = ServletActionContext.getRequest();
		String apmConfigId = request.getParameter(ALOCConstants.PAYMENT_CONFIG_ID);
		String paymentPeriodStartDate = request.getParameter(ALOCConstants.STARTDATE);
		String paymentPeriodEndDate = request.getParameter(ALOCConstants.ENDDATE);
		String fxRateRevalueDate = request.getParameter(ALOCConstants.REVALUEDATE);
		String paymentPeriodCutoffDate = request.getParameter(ALOCConstants.CUTOFDATE);
		String minPaymentAmountUSD = request.getParameter(ALOCConstants.USDAMOUNT);
		String dayCount = request.getParameter(ALOCConstants.DAYCOUNT);
		if(minPaymentAmountUSD.contains(ALOCConstants.COMMA)){
			minPaymentAmountUSD=minPaymentAmountUSD.replaceAll(ALOCConstants.COMMA, ALOCConstants.EMPTY_STRING);
		}
		if(paymentPeriodStartDate!=null && !ALOCConstants.EMPTY_STRING.equals(paymentPeriodStartDate)){
			payment.setPaymentPeriodStartDate(ALOCCommonHelper.convertStringToCal(paymentPeriodStartDate));
		}
		if(paymentPeriodEndDate!=null && !ALOCConstants.EMPTY_STRING.equals(paymentPeriodEndDate)){
			payment.setPaymentPeriodEndDate(ALOCCommonHelper.convertStringToCal(paymentPeriodEndDate));
		}
		if(fxRateRevalueDate!=null && !ALOCConstants.EMPTY_STRING.equals(fxRateRevalueDate)){
			payment.setFXRateRevalueDate(ALOCCommonHelper.convertStringToCal(fxRateRevalueDate));
		}
		if(paymentPeriodCutoffDate!=null && !ALOCConstants.EMPTY_STRING.equals(paymentPeriodCutoffDate)){
			payment.setPaymentPeriodCutoffDate(ALOCCommonHelper.convertStringToCal(paymentPeriodCutoffDate));
		}
		if(minPaymentAmountUSD!=null){
			payment.setMinPaymentAmountUSD(new BigDecimal(minPaymentAmountUSD));
		}
		if(dayCount!=null){
			payment.setDayCount(new BigInteger(dayCount));
		}
		if(apmConfigId!=null && !ALOCConstants.EMPTY_STRING.equals(apmConfigId)){
			payment.setAPMConfigID(new BigInteger(apmConfigId));
		}
		return payment;

	}

	/**
	 * This method is used to append the start date and end date to display in fx rate history 
	 * @return
	 * @throws ParseException
	 */
	public  static List<NameValue> formatDate(APMDetails apmDetails) throws ParseException{
		int ratePeriodListlength=ALOCConstants.NUM_ZERO;
		List<NameValue> FxRatePeriodList=new ArrayList<NameValue>();
		if(apmDetails.getFXRateHistoryAndCurrencySetup().getFXRateHistory().getFeePeriodDetails()!=null){
			ratePeriodListlength=apmDetails.getFXRateHistoryAndCurrencySetup().getFXRateHistory().getFeePeriodDetails().size();
		} 
		String ratePeriods=ALOCConstants.EMPTY_STRING;
		String ratePeriodkey=ALOCConstants.EMPTY_STRING;
		NameValue nameValue;
		SimpleDateFormat formatter = new SimpleDateFormat(ALOCConstants.FORMAT_INV_PATTERN);

		for(int i=ALOCConstants.NUM_ZERO;i<ratePeriodListlength;i++){
			nameValue = new NameValue();
			if(apmDetails.getFXRateHistoryAndCurrencySetup().getFXRateHistory().getFeePeriodDetails().get(i).getAPMConfigID()!=null){
				ratePeriodkey=apmDetails.getFXRateHistoryAndCurrencySetup().getFXRateHistory().getFeePeriodDetails().get(i).getAPMConfigID().toString();
			}
			ratePeriods =ratePeriods+formatter.format(apmDetails.getFXRateHistoryAndCurrencySetup().getFXRateHistory().getFeePeriodDetails().get(i).getPeriodStartDate().getTime())+ALOCConstants.HYPEN;
			ratePeriods+=formatter.format(apmDetails.getFXRateHistoryAndCurrencySetup().getFXRateHistory().getFeePeriodDetails().get(i).getPeriodEndDate().getTime());
			if(ratePeriodkey!=null && !ALOCConstants.EMPTY_STRING.equals(ratePeriodkey)){
				nameValue.setID(new BigInteger(ratePeriodkey));
			}
			nameValue.setName(ratePeriods);
			FxRatePeriodList.add(nameValue);
			ratePeriods=ALOCConstants.EMPTY_STRING;
		} 
		return FxRatePeriodList;
	}


	/**
	 * This method is used to download fxrates
	 * @return 
	 * @throws Exception 
	 */
	public  void downloadFXRatesHistory(APMDetails apmDetails) throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();	
		String filename = ALOCConstants.FXRATESXL;
		response.setContentType(APPLICATION_VND_MS_EXCEL);
		response.setHeader(ALOCConstants.CONTENTDESC, ALOCConstants.ATTACHMENTFILE + filename + ALOCConstants.SLASH);
		WriteFeePaymentToExcel writeToExcel = new WriteFeePaymentToExcel();
		HSSFWorkbook poiWorkbook = null; 
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(ALOCConstants.XLPATH);
		poiWorkbook= new HSSFWorkbook(is, true);

		int rowId = ALOCConstants.ROW_FIVE;
		ExcelSheetCollection excelSheets = new ExcelSheetCollection();
		ExcelSheet excelSheetObj = new ExcelSheet();
		if(apmDetails!=null){
			List<GetFXRates> getFxRates=apmDetails.getFXRateHistoryAndCurrencySetup().getFXRateHistory().getGetFXRates();
			if(getFxRates.size()!=ALOCConstants.NUM_ZERO) {
				for(GetFXRates fxRates : getFxRates){
					APMDetailsHelper.repeatableExcelObjects(rowId,fxRates,poiWorkbook,excelSheetObj);
					rowId++;

				}
			}
		}

		excelSheetObj.setSheetName(poiWorkbook.getSheetName(ALOCConstants.NUM_ZERO));
		excelSheets.getExcelSheet().add(excelSheetObj);

		writeToExcel.write(poiWorkbook, excelSheets);
		writeExcelToResponse(poiWorkbook, response);
	}

	/**
	 * This Method is used to download CSV File
	 * @return
	 * @param  apmDetails
	 * @throws Exception 
	 */
	public void downloadToCSV(APMDetails apmDetails) throws Exception {
		List<FeeCalculationDetails> feeCalLst =  apmDetails.getFeePaymentRunDetails().getFeeCalculationDetails();

		HttpServletResponse response = ServletActionContext.getResponse();	
		String filename = ALOCConstants.CSV_REPORTS;
		response.setContentType(APPLICATION_VND_MS_EXCEL);
		response.setHeader(ALOCConstants.CONTENTDESC, ALOCConstants.ATTACHMENTFILE + filename + ALOCConstants.SLASH);
		WriteFeePaymentToExcel writeToExcel = new WriteFeePaymentToExcel();

		HSSFWorkbook poiWorkbook = null; 
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(ALOCConstants.CSV_XLPATH);
		poiWorkbook= new HSSFWorkbook(is, true);

		int rowId = ALOCConstants.ROW_TWO;
		ExcelSheetCollection excelSheets = new ExcelSheetCollection();
		ExcelSheet excelSheetObj = new ExcelSheet();
		SimpleDateFormat formatter = new SimpleDateFormat(ALOCConstants.FORMATEPATTERN);
		String empty = ALOCConstants.EMPTY_STRING;
		FeePeriodDetails feePeriodDetails = apmDetails.getFeePaymentRunDetails().getFeePeriodDetails();
		Calendar peroidStartDate = (feePeriodDetails != null) ? feePeriodDetails.getPeriodStartDate() : null;
		Calendar peroidEndDate = (feePeriodDetails != null) ? feePeriodDetails.getPeriodEndDate() : null;
		fillCellDetails(excelSheetObj,ALOCConstants.ROW_ZERO,ALOCConstants.FEE_PAYMENT_RUN+((peroidStartDate!=null)?formatter.format(peroidStartDate.getTime()):empty)
				+ALOCConstants.TO+((peroidEndDate != null) ? formatter.format(peroidEndDate.getTime()) : empty) , ALOCConstants.BASE_VALUE);
		if(feeCalLst!=null && feeCalLst.size()!=ALOCConstants.NUM_ZERO){
			for(FeeCalculationDetails feeDet : feeCalLst){
				repeatableObjForDownloadCSV(rowId, feeDet, excelSheetObj);
				rowId++;
			}
		}
		excelSheetObj.setSheetName(poiWorkbook.getSheetName(ALOCConstants.NUM_ZERO));
		excelSheets.getExcelSheet().add(excelSheetObj);
		
		writeToExcel.write(poiWorkbook, excelSheets);
		
		ByteArrayOutputStream bout = null;
		try {
			if(feeCalLst!=null && feeCalLst.size()!=ALOCConstants.NUM_ZERO){
				WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(ServletActionContext.getServletContext());
				IAPMDetailsManager apmDetailsManager = (IAPMDetailsManager) context.getBean(ALOCConstants.APMDETAILS_MANAGER_BEAN);
				bout = new ByteArrayOutputStream();
				poiWorkbook.write(bout);
				apmDetailsManager.saveCSVFile(apmDetails, bout.toByteArray());
			}
		} catch (Exception e) {
			try {
				if(bout != null) {
					bout.close();
				}
			} catch (IOException ioe) {
			}
		}
		bout = null;
		writeExcelToResponse(poiWorkbook, response);
	}

	/**
	 * This Method is used to Credits Carry Over Export to Excel
	 * @return
	 * @param  apmDetails
	 * @throws Exception 
	 */
	public void creditAndCarryOversExport(APMDetails apmDetails) throws Exception {
		if(apmDetails.getFeePaymentRunDetails()!=null && apmDetails.getFeePaymentRunDetails().getCreditAndCarryOverReports()!=null){
			List<CreditAndCarryOverReport> creditAndCarryOverLst =  apmDetails.getFeePaymentRunDetails().getCreditAndCarryOverReports();
			HttpServletResponse response = ServletActionContext.getResponse();	
			String filename = ALOCConstants.CREDITS_CARRYOVERS_EXPORT;
			response.setContentType(APPLICATION_VND_MS_EXCEL);
			response.setHeader(ALOCConstants.CONTENTDESC, ALOCConstants.ATTACHMENTFILE + filename + ALOCConstants.SLASH);
			WriteFeePaymentToExcel writeToExcel = new WriteFeePaymentToExcel();

			HSSFWorkbook poiWorkbook = null; 
			InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(ALOCConstants.CREDITS_XLPATH);
			poiWorkbook= new HSSFWorkbook(is, true);

			SimpleDateFormat formatter = new SimpleDateFormat(ALOCConstants.FORMAT_INV_PATTERN);

			int rowId = ALOCConstants.ROW_FOUR;
			int rowId_zero = ALOCConstants.ROW_ZERO;
			int rowId_one = ALOCConstants.ROW_ONE;
			ExcelSheetCollection excelSheets = new ExcelSheetCollection();
			ExcelSheet excelSheetObj = new ExcelSheet();

			if(apmDetails.getFeePaymentRunDetails()!=null && apmDetails.getFeePaymentRunDetails().getFeePeriodDetails()!=null){
				FeePeriodDetails feePerdet = apmDetails.getFeePaymentRunDetails().getFeePeriodDetails();
				if(feePerdet.getPeriodStartDate()!=null && feePerdet.getPeriodEndDate()!=null){
					fillCellDetails(excelSheetObj, ALOCConstants.NUM_THREE, feePerdet.getPeriodStartDate()!=null ? ALOCConstants.START_DATE+formatter.format(feePerdet.getPeriodStartDate().getTime()) : ALOCConstants.EMPTY_STRING, rowId_zero);
					fillCellDetails(excelSheetObj, ALOCConstants.NUM_THREE, feePerdet.getPeriodEndDate()!=null ? ALOCConstants.END_DATE+formatter.format(feePerdet.getPeriodEndDate().getTime()) : ALOCConstants.EMPTY_STRING, rowId_one);
				}
			}

			if(creditAndCarryOverLst!=null && creditAndCarryOverLst.size()!=ALOCConstants.NUM_ZERO){
				for(CreditAndCarryOverReport eachCredit : creditAndCarryOverLst){
					repeatableCredits(rowId, eachCredit, excelSheetObj);
					rowId++;
				}
			}
			excelSheetObj.setSheetName(poiWorkbook.getSheetName(ALOCConstants.NUM_ZERO));
			excelSheets.getExcelSheet().add(excelSheetObj);

			writeToExcel.write(poiWorkbook, excelSheets);
			writeExcelToResponse(poiWorkbook, response);
		}
	}

	/**
	 * Validation for payment period save
	 * @return
	 */
	public static boolean validateSavepaymentDetails(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String paymentPeriodStartDate = request.getParameter(ALOCConstants.STARTDATE);
		if(paymentPeriodStartDate!=null && !paymentPeriodStartDate.equalsIgnoreCase(ALOCConstants.EMPTY_STRING) ){
			return true;
		}
		else{return false;}
	}

	/**
	 * This Method is used to get the Currency Setup Row value for given currencyConfigId
	 * @return 
	 * @throws HWFServiceException
	 */
	public APMDetails getCurrencySetupDetailsForSelCurrency(APMDetails apmDetails,CurrencySetup currencySetup){
		List<CurrencySetup> tempCurrencySetupList = apmDetails.getFXRateHistoryAndCurrencySetup().getCurrencySetups();
		List<CurrencySetup> currencySetupList = new ArrayList<CurrencySetup>();

		for(CurrencySetup tempCurrencySetup : tempCurrencySetupList)
		{
			if(currencySetup.getCurrencyConfigId() != null && tempCurrencySetup.getCurrencyConfigId()!=null)
			{
				if(tempCurrencySetup.getCurrencyConfigId().equals(currencySetup.getCurrencyConfigId())){
					currencySetupList.add(currencySetup);
				}else{
					currencySetupList.add(tempCurrencySetup);
				}}else{
					currencySetupList.add(tempCurrencySetup);
				}
		}

		if(currencySetup.getCurrencyConfigId() == null || currencySetup.getCurrencyConfigId().equals(ALOCConstants.EMPTY_STRING)){
			HttpServletRequest request = ServletActionContext.getRequest();
			String curIndex = request.getParameter(ALOCConstants.CURINDEX);
			currencySetupList.add(Integer.valueOf(curIndex), currencySetup);
		}
		apmDetails.getFXRateHistoryAndCurrencySetup().setCurrencySetups(currencySetupList);
		return apmDetails;
	}


	/**
	 * This method to used to add cells to Download CSV for Fee payment Run
	 * @param objId
	 * @param feeCal
	 * @param excelSheetObj
	 */
	public static void repeatableObjForDownloadCSV(int objId , FeeCalculationDetails feeCal,ExcelSheet excelSheetObj){
		SimpleDateFormat formatter = new SimpleDateFormat(ALOCConstants.FORMAT_INV_PATTERN);
		String empty = ALOCConstants.EMPTY_STRING;
		String supressWebcashIBS = empty;
		if(feeCal.isSuppressWebcashIBS() != null && feeCal.isSuppressWebcashIBS() == true){
			supressWebcashIBS = ALOCConstants.YES_CAP;
		}else if(feeCal.isSuppressWebcashIBS() != null && feeCal.isSuppressWebcashIBS() == false){
			supressWebcashIBS = ALOCConstants.NO_CAP;
		}

		fillCellDetails(excelSheetObj, ALOCConstants.ROW_ZERO, feeCal.getBankReferenceNum() , objId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_ONE, feeCal.getAlocRecordNo() != null ? feeCal.getAlocRecordNo() : empty , objId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWO, feeCal.getTotalPayment() != null ? ALOCCommonHelper.getStringWithDecimalValue(feeCal.getTotalPayment().toString()) : empty , objId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_THREE, feeCal.getUSPayment() !=null ? ALOCCommonHelper.getStringWithDecimalValue(feeCal.getUSPayment().toString()) : empty, objId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_FOUR, feeCal.getForeignPayment() !=null ? ALOCCommonHelper.getStringWithDecimalValue(feeCal.getForeignPayment().toString()) : empty, objId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_FIVE, feeCal.getOtherPayment() !=null ? ALOCCommonHelper.getStringWithDecimalValue(feeCal.getOtherPayment().toString()) : empty, objId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_SIX, feeCal.getUSDCurrAmount()!=null ? ALOCCommonHelper.getStringWithDecimalValue(feeCal.getUSDCurrAmount().toString()) : empty, objId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_SEVEN, feeCal.getBeneName(), objId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_EIGHT, feeCal.getGERelBank() , objId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_NINE, feeCal.getIssueDt()!=null ? formatter.format(feeCal.getIssueDt().getTime()) : empty, objId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TEN, feeCal.getUSExpDt()!=null ? formatter.format(feeCal.getUSExpDt().getTime()) : empty, objId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_ELEVEN,feeCal.getForeignExpDt() !=null?formatter.format(feeCal.getForeignExpDt().getTime()).toString():empty,objId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWELVE, feeCal.getUSStartPeriod() != null ? formatter.format(feeCal.getUSStartPeriod().getTime()) : empty , objId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_THIRTEEN, feeCal.getUSEndPeriod() != null ? formatter.format(feeCal.getUSEndPeriod().getTime()) : empty , objId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_FOURTEEN, feeCal.getForeignStartPeriod() != null ? formatter.format(feeCal.getForeignStartPeriod().getTime()) : empty , objId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_FIFTEEN, feeCal.getForeignEndPeriod() != null ? formatter.format(feeCal.getForeignEndPeriod().getTime()) : empty , objId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_SIXTEEN, feeCal.getUSLastPdDt() != null ? formatter.format(feeCal.getUSLastPdDt().getTime()) : empty , objId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_SEVENTEEN, feeCal.getForeignLastPdDt() != null ? formatter.format(feeCal.getForeignLastPdDt().getTime()) : empty , objId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_EIGHTEEN, feeCal.getUSAllInBPSPAArrears() !=null ? ALOCCommonHelper.getStringWithDecimalValue(feeCal.getUSAllInBPSPAArrears().toString()) : empty, objId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_NINTEEN, feeCal.getUSAllInBPSPAAdv() !=null ? ALOCCommonHelper.getStringWithDecimalValue(feeCal.getUSAllInBPSPAAdv().toString()) : empty, objId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWENTY, feeCal.getUSFlatFeePAAdv() !=null ? ALOCCommonHelper.getStringWithDecimalValue(feeCal.getUSFlatFeePAAdv().toString()) : empty, objId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWENTYONE, feeCal.getUSFlatFeeLife() !=null ? ALOCCommonHelper.getStringWithDecimalValue(feeCal.getUSFlatFeeLife().toString()) : empty, objId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWENTYTWO, feeCal.getForeignAllInBPSPAArrears() !=null ? ALOCCommonHelper.getStringWithDecimalValue(feeCal.getForeignAllInBPSPAArrears().toString()) : empty, objId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWENTYTHREE, feeCal.getForeignAllInBPSPAAdv() !=null ? ALOCCommonHelper.getStringWithDecimalValue(feeCal.getForeignAllInBPSPAAdv().toString()) : empty, objId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWENTYFOUR, feeCal.getForeignFlatFeePAAdv() !=null ? ALOCCommonHelper.getStringWithDecimalValue(feeCal.getForeignFlatFeePAAdv().toString()) : empty, objId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWENTYFIVE, feeCal.getForeignFlatFeeLife() !=null ? ALOCCommonHelper.getStringWithDecimalValue(feeCal.getForeignFlatFeeLife().toString()) : empty, objId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWENTYSIX, StringUtils.isNotBlank(feeCal.getAmendmentId()) ? ALOCCommonHelper.getStringWithDecimalValue(feeCal.getAmendmentId()) :empty , objId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWENTYSEVEN, StringUtils.isNotBlank(feeCal.getAmendmentLoc()) ? ALOCCommonHelper.getStringWithDecimalValue(feeCal.getAmendmentLoc()) : empty, objId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWENTYEIGHT, feeCal.getVATTax() !=null ? ALOCCommonHelper.getStringWithDecimalValue(feeCal.getVATTax().toString()) : empty, objId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWENTYNINE, feeCal.getStampTax() !=null ? ALOCCommonHelper.getStringWithDecimalValue(feeCal.getStampTax().toString()) : empty, objId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_THIRTY, feeCal.getIncidentalFee() !=null ? ALOCCommonHelper.getStringWithDecimalValue(feeCal.getIncidentalFee().toString()) : empty, objId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_THIRTYONE, feeCal.getOtherFee() !=null ? ALOCCommonHelper.getStringWithDecimalValue(feeCal.getOtherFee().toString()) : empty, objId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_THIRTYTWO, feeCal.getFTRNNumber() , objId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_THIRTYTHREE, feeCal.getWebcashModel() , objId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_THIRTYFOUR, supressWebcashIBS , objId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_THIRTYFIVE, feeCal.getBUC() , objId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_THIRTYSIX, feeCal.getADN() , objId);
	}
	
	/**
	 * This Method is used to export the FeeHistory Search data
	 * @param objId
	 * @param feeCal
	 * @param excelSheetObj
	 */
	public static void repeatableObjForFeeHistorySearch(int objId , FullSummary fullSummary,ExcelSheet excelSheetObj){
		SimpleDateFormat formatter = new SimpleDateFormat(ALOCConstants.FORMAT_INV_PATTERN);
		String empty = ALOCConstants.EMPTY_STRING;

		fillCellDetails(excelSheetObj, ALOCConstants.ROW_ZERO, fullSummary.getPaymentID() != null? fullSummary.getPaymentID() :empty , objId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_ONE, fullSummary.getAlocRecordId() != null ? fullSummary.getAlocRecordId() : empty , objId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWO, fullSummary.getBankReferenceNumber() != null ? fullSummary.getBankReferenceNumber() : empty , objId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_THREE, fullSummary.getGEApplicant() !=null ? fullSummary.getGEApplicant() : empty, objId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_FOUR, fullSummary.getTriPartyApplicant() !=null ? fullSummary.getTriPartyApplicant() : empty, objId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_FIVE, fullSummary.getBeneficiaryName() !=null ? fullSummary.getBeneficiaryName() : empty, objId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_SIX, fullSummary.getPaymentCurrencyName()!=null ? fullSummary.getPaymentCurrencyName() : empty, objId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_SEVEN, fullSummary.getPaymentAmount() != null? ALOCCommonHelper.getStringWithDecimalValue(fullSummary.getPaymentAmount().toString()) : empty , objId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_EIGHT, fullSummary.getPaymentDate() !=null ? formatter.format(fullSummary.getPaymentDate().getTime()) : empty , objId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_NINE, fullSummary.getUSDPaymentAmount()!=null ? ALOCCommonHelper.getStringWithDecimalValue(fullSummary.getUSDPaymentAmount().toString()) : empty, objId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TEN, fullSummary.getUSFeeTotal()!=null ? ALOCCommonHelper.getStringWithDecimalValue(fullSummary.getUSFeeTotal().toString()) : empty, objId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_ELEVEN,fullSummary.getForeignFeeTotal() !=null? ALOCCommonHelper.getStringWithDecimalValue(fullSummary.getForeignFeeTotal().toString()):empty,objId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWELVE, fullSummary.getPeriodFeeCredits() != null ? ALOCCommonHelper.getStringWithDecimalValue(fullSummary.getPeriodFeeCredits().toString()) : empty , objId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_THIRTEEN, fullSummary.getPeriodAmendmentFees() != null ? ALOCCommonHelper.getStringWithDecimalValue(fullSummary.getPeriodAmendmentFees().toString()) : empty , objId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_FOURTEEN, fullSummary.getOtherFees() != null ? ALOCCommonHelper.getStringWithDecimalValue(fullSummary.getOtherFees().toString()) : empty , objId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_FIFTEEN, fullSummary.getOneTimeFees() != null ? ALOCCommonHelper.getStringWithDecimalValue(fullSummary.getOneTimeFees().toString()) : empty , objId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_SIXTEEN, fullSummary.getModelId() != null ? fullSummary.getModelId() : empty , objId);
	}

	/**
	 * This method to used to add cells to Credits And Carry Overs for Fee payment Run
	 * @param objId
	 * @param feeCal
	 * @param excelSheetObj
	 */
	public static void repeatableCredits(int objId , CreditAndCarryOverReport eachCredit,ExcelSheet excelSheetObj){
		String empty = ALOCConstants.EMPTY_STRING;

		fillCellDetails(excelSheetObj, ALOCConstants.ROW_ZERO, eachCredit.getBankName()!=null ? eachCredit.getBankName().toString() : empty, objId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_ONE, eachCredit.getAlocRecordId() !=null ? eachCredit.getAlocRecordId() : empty, objId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_TWO, eachCredit.getCreditAmount()!=null ? ALOCCommonHelper.getStringWithDecimalValue(eachCredit.getCreditAmount().toString()) : empty, objId);
		fillCellDetails(excelSheetObj, ALOCConstants.ROW_THREE, eachCredit.getCarryOverAmount()!=null ? ALOCCommonHelper.getStringWithDecimalValue(eachCredit.getCarryOverAmount().toString()) : empty, objId);
	}

	/**
	 * This Method is used to set the data for Invoice file
	 * @return
	 * @param  apmDetails
	 * @throws Exception 
	 */
	public void exportInvoiceFeeHistory(APMDetails apmDetails) throws HWFServiceException {
		HttpServletResponse response = ServletActionContext.getResponse();

		List<InvoiceDetails> feeHistory = apmDetails.getFeeHistoryDetails().getInvoiceDetails();
		String filename = ALOCConstants.APM_INVOICE_XLS;
		response.setContentType(APPLICATION_VND_MS_EXCEL);
		response.setHeader(ALOCConstants.CONTENTDESC, ALOCConstants.ATTACHMENTFILE + filename + ALOCConstants.SLASH);
		WriteFeePaymentToExcel writeToExcel = new WriteFeePaymentToExcel();
		OutputStream out = null;
		try {
			HSSFWorkbook poiWorkbook = null; 
			InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(ALOCConstants.APM_INVOICE_TEMPLATE);
			poiWorkbook= new HSSFWorkbook(is, true);
			ExcelSheetCollection excelSheets = new ExcelSheetCollection();
			int three = ALOCConstants.NUM_THREE;
			String empty = ALOCConstants.EMPTY_STRING;
			int i= ALOCConstants.NUM_ZERO;
			SimpleDateFormat formatter = new SimpleDateFormat(ALOCConstants.FORMAT_INV_PATTERN);

			for (InvoiceDetails invoiceDetails : feeHistory) {
				if(i > ALOCConstants.NUM_ZERO){
					poiWorkbook.cloneSheet(ALOCConstants.NUM_ZERO);
				}
				poiWorkbook.setSheetName(i,invoiceDetails.getAlocRecordId()+ALOCConstants.UNDERSCORE+new SimpleDateFormat(ALOCConstants.APM_INVOICE_DATEFORMAT).format(new Date())+ALOCConstants.HYPEN.toString()+(i+1));
				ExcelSheet excelSheet = new ExcelSheet();
				List<CellDetail> celDetLst = excelSheet.getCellDetail();
				Calendar payDate = invoiceDetails.getPaymentDate();

				celDetLst.add(setCellDetails(ALOCConstants.ROW_ONE,three,payDate!= null ? invoiceDetails.getBankReferenceNum()+ALOCConstants.HYPEN +
						((invoiceDetails.getQuarterOfYear() != null) ? invoiceDetails.getQuarterOfYear() : empty) :empty));
				celDetLst.add(setCellDetails(ALOCConstants.ROW_TWO,three,payDate != null ? formatter.format(payDate.getTime()) : empty));

				exportInvoiceData(celDetLst,invoiceDetails,formatter);

				excelSheet.setSheetName(poiWorkbook.getSheetName(i));
				excelSheets.getExcelSheet().add(excelSheet);
				i++;
			}
			writeToExcel.write(poiWorkbook, excelSheets);
			out = response.getOutputStream();
			poiWorkbook.write(out);
			out.flush();
		} catch (IOException ioe) {
			LOGGER.error(ALOCConstants.INVOICE_IOERROR_MSG, ioe);
			throw new ALOCRuntimeException(null, ALOCConstants.INVOICE_IOERROR_MSG, ioe);
		} finally {
			try {
				if(out != null) {
					out.close();
				}
			} catch (IOException ioe) {
				LOGGER.warn(ALOCConstants.INVOICE_CLOSING_ERRORMSG, ioe);
			}
		}
	}
	
	/**
	 * This Method is used to export the FeeHistory Search data
	 * @return
	 * @param  apmDetails
	 * @throws Exception 
	 */
	public void exportSeachFeeHistoryData(APMDetails apmDetails,String searchCriteria) throws Exception {
		List<FullSummary> fullSummaryList = apmDetails!=null && apmDetails.getFeeHistoryDetails() != null?apmDetails.getFeeHistoryDetails().getFullSummaries():null;

		HttpServletResponse response = ServletActionContext.getResponse();	
		String filename = ALOCConstants.APM_FEEHISTORY_XLS;
		response.setContentType(APPLICATION_VND_MS_EXCEL);
		response.setHeader(ALOCConstants.CONTENTDESC, ALOCConstants.ATTACHMENTFILE + filename + ALOCConstants.SLASH);
		WriteFeePaymentToExcel writeToExcel = new WriteFeePaymentToExcel();

		HSSFWorkbook poiWorkbook = null; 
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(ALOCConstants.TEMPLATE_APM_FEEHISTORY);
		poiWorkbook= new HSSFWorkbook(is, true);

		int rowId = ALOCConstants.ROW_FOUR;
		ExcelSheetCollection excelSheets = new ExcelSheetCollection();
		ExcelSheet excelSheetObj = new ExcelSheet();
		fillCellDetails(excelSheetObj, ALOCConstants.COLUMN_ONE, searchCriteria ,ALOCConstants.ROW_TWO);
		if(fullSummaryList!=null && fullSummaryList.size()>ALOCConstants.MIN_INDEX){
			for(FullSummary fullSummary : fullSummaryList){
				repeatableObjForFeeHistorySearch(rowId, fullSummary, excelSheetObj);
				rowId++;
			}
		}
		excelSheetObj.setSheetName(poiWorkbook.getSheetName(ALOCConstants.MIN_INDEX));
		excelSheets.getExcelSheet().add(excelSheetObj);

		writeToExcel.write(poiWorkbook, excelSheets);
		writeExcelToResponse(poiWorkbook, response);
	}
	
	/**
	 * This method is used to fill Invoice Data
	 * @param celDetLst
	 * @param invoiceDetails
	 * @param formatter
	 */
	private static void exportInvoiceData(List<CellDetail> celDetLst,InvoiceDetails invoiceDetails,SimpleDateFormat formatter){
		int zero = ALOCConstants.NUM_ZERO;
		int one = ALOCConstants.NUM_ONE;
		int two = ALOCConstants.NUM_TWO;
		int three = ALOCConstants.NUM_THREE;
		int four = ALOCConstants.ROW_FOUR;
		String empty = ALOCConstants.EMPTY_STRING;

		if(invoiceDetails.getCustomerBeneficiaryAddress() != null){
			if(invoiceDetails.getCustomerBeneficiaryAddress().getAddressDtls() != null){
				AddressDtls addDls = invoiceDetails.getCustomerBeneficiaryAddress().getAddressDtls();
				celDetLst.add(setCellDetails(ALOCConstants.ROW_EIGHT,two,addDls.getName()));
				String city = (StringUtils.isNotBlank(addDls.getCity())) ? addDls.getCity()+ALOCConstants.COMMA : empty;
				String state = (StringUtils.isNotBlank(addDls.getStateProvince())) ? addDls.getStateProvince()+ALOCConstants.COMMA : empty;
				if(addDls.getAddress() != null){
					List<String> addDetLst = addDls.getAddress();
					celDetLst.add(setCellDetails(ALOCConstants.ROW_NINE,two,addDetLst.size() > zero ? addDetLst.get(zero) : empty));
					celDetLst.add(setCellDetails(ALOCConstants.ROW_TEN,two,addDetLst.size() > one ? addDetLst.get(one) : empty));
				}
				celDetLst.add(setCellDetails(ALOCConstants.ROW_ELEVEN,two,city+state+ addDls.getZIPPostalCode()));
				celDetLst.add(setCellDetails(ALOCConstants.ROW_TWELVE,two,addDls.getCountry()));
			}
		}
		celDetLst.add(setCellDetails(ALOCConstants.ROW_SIXTEEN,two,invoiceDetails.getIssuingBankName() != null ? invoiceDetails.getIssuingBankName() : empty));
		celDetLst.add(setCellDetails(ALOCConstants.ROW_SEVENTEEN,two,invoiceDetails.getIssuanceDate() != null ? formatter.format(invoiceDetails.getIssuanceDate().getTime()) : empty));
		celDetLst.add(setCellDetails(ALOCConstants.ROW_EIGHTEEN,two,invoiceDetails.getUSExpirationDate() != null ?formatter.format(invoiceDetails.getUSExpirationDate().getTime()):empty));
		celDetLst.add(setCellDetails(ALOCConstants.ROW_NINTEEN,two,invoiceDetails.getExpirationDate() != null ?formatter.format(invoiceDetails.getExpirationDate().getTime()):empty));

		celDetLst.add(setCellDetails(ALOCConstants.ROW_TWENTYONE,two,invoiceDetails.getBankSiteName()));
		celDetLst.add(setCellDetails(ALOCConstants.ROW_TWENTYTWO,two,invoiceDetails.getBankReferenceNum()));
		celDetLst.add(setCellDetails(ALOCConstants.ROW_TWENTYTHREE,two,invoiceDetails.getAlocRecordId() != null ? invoiceDetails.getAlocRecordId() : empty));
		celDetLst.add(setCellDetails(ALOCConstants.ROW_TWENTYFOUR,two,invoiceDetails.getInitiaterContactName()));
		celDetLst.add(setCellDetails(ALOCConstants.ROW_TWENTYFIVE,one,invoiceDetails.getInstrumentCurrencyCode()));
		celDetLst.add(setCellDetails(ALOCConstants.ROW_TWENTYFIVE,two,invoiceDetails.getInstrumentAmount() != null ? ALOCCommonHelper.getStringWithDecimalValue(invoiceDetails.getInstrumentAmount().toString()) : empty));
		celDetLst.add(setCellDetails(ALOCConstants.ROW_TWENTYSIX,two,invoiceDetails.getPaymentDate() != null ? formatter.format(invoiceDetails.getPaymentDate().getTime()) : empty));
		
		celDetLst.add(setCellDetails(ALOCConstants.ROW_THIRTY,one,invoiceDetails.getUSFees() != null ? invoiceDetails.getPaymentCurrencyCode() : empty));
		celDetLst.add(setCellDetails(ALOCConstants.ROW_THIRTY,two,invoiceDetails.getUSFees() != null ? ALOCCommonHelper.getStringWithDecimalValue(invoiceDetails.getUSFees().toString()) : empty));
		celDetLst.add(setCellDetails(ALOCConstants.ROW_THIRTY,three,invoiceDetails.getUSPeriodStartDate()!=null?formatter.format(invoiceDetails.getUSPeriodStartDate().getTime()):empty));
		celDetLst.add(setCellDetails(ALOCConstants.ROW_THIRTY,four,invoiceDetails.getUSPeriodEndDate()!=null?formatter.format(invoiceDetails.getUSPeriodEndDate().getTime()):empty));
		
		celDetLst.add(setCellDetails(ALOCConstants.ROW_THIRTYONE,one,invoiceDetails.getForeignFees() != null ? invoiceDetails.getPaymentCurrencyCode() : empty));
		celDetLst.add(setCellDetails(ALOCConstants.ROW_THIRTYONE,two,invoiceDetails.getForeignFees() != null ? ALOCCommonHelper.getStringWithDecimalValue(invoiceDetails.getForeignFees().toString()) : empty));
		celDetLst.add(setCellDetails(ALOCConstants.ROW_THIRTYONE,three,invoiceDetails.getForeignPeriodStartDate()!=null?formatter.format(invoiceDetails.getForeignPeriodStartDate().getTime()):empty));
		celDetLst.add(setCellDetails(ALOCConstants.ROW_THIRTYONE,four,invoiceDetails.getForeignPeriodEndDate()!=null?formatter.format(invoiceDetails.getForeignPeriodEndDate().getTime()):empty));
		
		celDetLst.add(setCellDetails(ALOCConstants.ROW_THIRTYTWO,one,invoiceDetails.getOtherFees() != null ? invoiceDetails.getPaymentCurrencyCode() : empty));
		celDetLst.add(setCellDetails(ALOCConstants.ROW_THIRTYTWO,two,invoiceDetails.getOtherFees() != null ? ALOCCommonHelper.getStringWithDecimalValue(invoiceDetails.getOtherFees().toString()) : empty));
		celDetLst.add(setCellDetails(ALOCConstants.ROW_THIRTYTWO,four,invoiceDetails.getPaymentDate()!=null?formatter.format(invoiceDetails.getPaymentDate().getTime()):empty));
		
		celDetLst.add(setCellDetails(ALOCConstants.ROW_THIRTYFOUR,one,invoiceDetails.getTotalFees() != null ? invoiceDetails.getPaymentCurrencyCode() : empty));
		celDetLst.add(setCellDetails(ALOCConstants.ROW_THIRTYFOUR,two,invoiceDetails.getTotalFees() != null ? ALOCCommonHelper.getStringWithDecimalValue(invoiceDetails.getTotalFees().toString()) : empty));
		
		celDetLst.add(setCellDetails(ALOCConstants.ROW_THIRTYSIX,two,invoiceDetails.getBUC()));
		celDetLst.add(setCellDetails(ALOCConstants.ROW_THIRTYSIX,four,invoiceDetails.getADN()));
		celDetLst.add(setCellDetails(ALOCConstants.ROW_THIRTYSEVEN,two,invoiceDetails.getLEGoldID()+ALOCConstants.HYPEN+ invoiceDetails.getLEName()));
		celDetLst.add(setCellDetails(ALOCConstants.ROW_THIRTYEIGHT,two,invoiceDetails.getGEContactPersonName()));
	}

	/**
	 * This method is used to set the date for Invoice File 
	 * @param row
	 * @param column
	 * @param value
	 * @return cellDetail
	 */
	public static CellDetail setCellDetails(Integer row, Integer column, String value) {
		CellDetail cellDetail = new CellDetail();
		cellDetail.setColumnId(column);
		cellDetail.setRowId(row);
		cellDetail.setValue(value);
		return cellDetail;
	}

	/**
	 * method to populate the search criteria from basic Search
	 * @param userSpecificSites 
	 * @return
	 * @throws ParseException 
	 */
	public static APMSearch populateFHsearch(String siteId,Integer searchCriteriaType,
			String searchCriteriaText,List<UserSites> userSpecificSites,StringBuilder searchCriteria) throws ParseException {
		APMSearch apmSearch=new APMSearch();
		List<BigInteger> siteIds = new ArrayList<BigInteger>();
		if(StringUtils.isNotBlank(siteId)&& !siteId.equals(ALOCConstants.MONE)){
			siteId=siteId.replace(ALOCConstants.COMMA,ALOCConstants.EMPTY_STRING);
			siteIds.add(new BigInteger(siteId));
		}
		else{
			if(!CollectionUtils.isEmpty(userSpecificSites)){
				for (NameValue nameValue : userSpecificSites) {
					siteIds.add(new BigInteger(nameValue.getID().toString()));
				}
			}
		}
		apmSearch.setSiteIds(siteIds);
		apmSearch = feeHistorySearch(apmSearch,searchCriteriaType,searchCriteriaText,searchCriteria);
		return apmSearch;
	}
	
	/**
	 * method to populate the search criteria from basic Search
	 * @param userSpecificSites 
	 * @return
	 * @throws ParseException 
	 */
	public static void populateFHsearchCriteria(APMSearch apmSearch,StringBuilder searchCriteria) throws HWFServiceException {
		int minLength = ALOCConstants.BASE_VALUE;
		String semicolon = ALOCConstants.SEMICOLON_SPACE;
		SimpleDateFormat formatter = new SimpleDateFormat(ALOCConstants.FORMAT_INV_PATTERN);
		if(apmSearch != null){
			if(apmSearch.getALOCRecordNumber() != null){
				searchCriteria.append(ALOCConstants.SEARCH_ALOC_RECORD_NO).append(apmSearch.getALOCRecordNumber());
			}
			if(StringUtils.isNotBlank(apmSearch.getBUC())){
				searchCriteria = searchCriteria.length() >minLength ? searchCriteria.append(semicolon)
						.append(ALOCConstants.SEARCH_BUC).append(apmSearch.getBUC()):searchCriteria.append(ALOCConstants.SEARCH_BUC).append(apmSearch.getBUC());
			}
			if(StringUtils.isNotBlank(apmSearch.getADN())){
				searchCriteria = searchCriteria.length() >minLength?searchCriteria.append(semicolon).append(ALOCConstants.SEARCH_ADN).append(apmSearch.getADN()):
					searchCriteria.append(ALOCConstants.SEARCH_ADN).append(apmSearch.getADN());
			}
			if(StringUtils.isNotBlank(apmSearch.getApplicant())){
				searchCriteria = searchCriteria.length()>minLength?searchCriteria.append(semicolon).append(ALOCConstants.SEARCH_APPLICANT_NAME).append(apmSearch.getApplicant()):
					searchCriteria.append(ALOCConstants.SEARCH_APPLICANT_NAME).append(apmSearch.getApplicant());
			}
			if(StringUtils.isNotBlank(apmSearch.getBeneficiary())){
				searchCriteria = searchCriteria.length()>minLength?searchCriteria.append(semicolon).append(ALOCConstants.SEARCH_BENEFICIARY_NAME).append(apmSearch.getBeneficiary()):
					searchCriteria.append(ALOCConstants.SEARCH_BENEFICIARY_NAME).append(apmSearch.getBeneficiary());
			}
			if(StringUtils.isNotBlank(apmSearch.getBankReferenceNumber())){
				searchCriteria = searchCriteria.length()>minLength?searchCriteria.append(semicolon).append(ALOCConstants.SEARCH_BANK_REF_NO).append(apmSearch.getBankReferenceNumber()):
					searchCriteria.append(ALOCConstants.SEARCH_BANK_REF_NO).append(apmSearch.getBankReferenceNumber());
			}
			if(apmSearch.getInstrumentAmountFrom() != null){
				searchCriteria = searchCriteria.length()>minLength?searchCriteria.append(semicolon).append(ALOCConstants.SEARCH_FROM_INSTRUMENT_AMOUNT).append(apmSearch.getInstrumentAmountFrom()):
					searchCriteria.append(ALOCConstants.SEARCH_FROM_INSTRUMENT_AMOUNT).append(apmSearch.getInstrumentAmountFrom());
			}
			if(apmSearch.getInstrumentAmountTo() != null){
				searchCriteria = searchCriteria.length()>minLength?searchCriteria.append(semicolon).append(ALOCConstants.SEARCH_TO_INSTRUMENT_AMOUNT).append(apmSearch.getInstrumentAmountTo()):
					searchCriteria.append(ALOCConstants.SEARCH_TO_INSTRUMENT_AMOUNT).append(apmSearch.getInstrumentAmountTo());
			}
			if(apmSearch.getCountryOfIssuences() != null && !apmSearch.getCountryOfIssuences().isEmpty() && StringUtils.isNotBlank(apmSearch.getCountryOfIssuences().get(minLength))){
				if(searchCriteria.length()>minLength){
					searchCriteria.append(semicolon).append(ALOCConstants.SEARCH_STATE_COUNTRY);
				}else{searchCriteria.append(ALOCConstants.SEARCH_STATE_COUNTRY);}
				int count = minLength;
				for(String countries: apmSearch.getCountryOfIssuences()){
					if(StringUtils.isNotBlank(countries)){
						String countryName = getCountryName(countries);
						if(count>minLength){
							searchCriteria.append(ALOCConstants.SPACE_AND_SPACE).append(countryName);
						}else{
							searchCriteria.append(countryName);
						}
						count++;
					}
				}
			}
			if(apmSearch.getPaymentDateFrom() != null){
				searchCriteria = searchCriteria.length()>minLength?searchCriteria.append(semicolon).append(ALOCConstants.SEARCH_FROM_PAYMENT_DATE)
						.append(formatter.format(apmSearch.getPaymentDateFrom().getTime())):
					searchCriteria.append(ALOCConstants.SEARCH_FROM_PAYMENT_DATE).append(formatter.format(apmSearch.getPaymentDateFrom().getTime()));				
			}
			if(apmSearch.getPaymentDateTo() != null){
				searchCriteria = searchCriteria.length()>minLength?searchCriteria.append(semicolon).append(ALOCConstants.SEARCH_TO_PAYMENT_DATE)
						.append(formatter.format(apmSearch.getPaymentDateTo().getTime())):
					searchCriteria.append(ALOCConstants.SEARCH_TO_PAYMENT_DATE).append(formatter.format(apmSearch.getPaymentDateTo().getTime()));
			}
			if(apmSearch.getPaymentCurrencies() != null && !apmSearch.getPaymentCurrencies().isEmpty() && StringUtils.isNotBlank(apmSearch.getPaymentCurrencies().get(minLength))){
				if(searchCriteria.length()>minLength){
					searchCriteria.append(semicolon).append(ALOCConstants.SEARCH_PAYMENT_CURRENCY);
				}else{searchCriteria.append(ALOCConstants.SEARCH_PAYMENT_CURRENCY);}
				int count = minLength;
				for(String currencies: apmSearch.getPaymentCurrencies()){
					if(StringUtils.isNotBlank(currencies)){
						String currencyName = getCurrencyName(currencies);
						if(count>minLength){
							searchCriteria.append(ALOCConstants.SPACE_AND_SPACE).append(currencyName);
						}else{
							searchCriteria.append(currencyName);
						}
						count++;
					}
				}
			}
		}
	}
	
	/**
	 * This method is used to get the CountryName based on the Country Code
	 * @param countryCode
	 * @return countryName
	 */
	public static String getCountryName(String countryCode) {
		String countryName = ALOCConstants.EMPTY_STRING;
		List<Country> MDMCountries = ALOCContext.getMasterDataFactory().getCountries();
		if(MDMCountries !=null && !MDMCountries.isEmpty() && StringUtils.isNotBlank(countryCode)){
			for(Country mdmCountriesLst : MDMCountries){
				if(StringUtils.isNotBlank(mdmCountriesLst.getCountryCode()) && mdmCountriesLst.getCountryCode().equalsIgnoreCase(countryCode)){
					return mdmCountriesLst.getCountryName();
				}
			}
		}
		return countryName;
	}
	
	/**
	 * This method is used to get the CurrencyName based on the Currency Code
	 * @param currencyCode
	 * @return currencyName
	 */
	public static String getCurrencyName(String currencyCode) {
		String currencyName = ALOCConstants.EMPTY_STRING;
		List<Currency> MDMCurrencies = ALOCContext.getMasterDataFactory().getCurrencies();
		if(MDMCurrencies !=null && !MDMCurrencies.isEmpty() && StringUtils.isNotBlank(currencyCode)){
			for(Currency mdmCountriesLst : MDMCurrencies){
				if(StringUtils.isNotBlank(mdmCountriesLst.getCurrencyCode()) && mdmCountriesLst.getCurrencyCode().equalsIgnoreCase(currencyCode)){
					return mdmCountriesLst.getCurrencyName();
				}
			}
		}
		return currencyName;
	}

	/**
	 * method to navigate the search criteria from basic Search
	 * @param apmSearch
	 * @param searchCriteriaType
	 * @param searchCriteriaText
	 * @return apmSearch
	 * @throws ParseException 
	 */
	private static APMSearch feeHistorySearch(APMSearch apmSearch,Integer searchCriteriaType,String searchCriteriaText,StringBuilder searchCriteria)throws ParseException{
		switch (FHSearchCriteriaType.fromId(searchCriteriaType)) {
		case ADN:
			if(StringUtils.isNotEmpty(searchCriteriaText)){
				apmSearch.setADN(searchCriteriaText);
			}
			searchCriteria.append(ALOCConstants.SEARCH_ADN);
			break;
		case ALOC_RECORD_NUM:
			if(searchCriteriaText != null ){
				apmSearch.setALOCRecordId(searchCriteriaText);
			}else{
				apmSearch.setALOCRecordId(ALOCConstants.EMPTY_STRING);
			}
			searchCriteria.append(ALOCConstants.SEARCH_ALOC_RECORD_NO);
			break;
		case APPLICANT_NAME:
			if(StringUtils.isNotEmpty(searchCriteriaText)){
				apmSearch.setApplicant(searchCriteriaText);
			}
			searchCriteria.append(ALOCConstants.SEARCH_APPLICANT_NAME);
			break;
		case BANK_REFERENCE_NUMBER:
			if(StringUtils.isNotEmpty(searchCriteriaText)){
				apmSearch.setBankReferenceNumber(searchCriteriaText);
			}
			searchCriteria.append(ALOCConstants.SEARCH_BANK_REF_NO);
			break;
		case BENEFICIARY_NAME:
			if(StringUtils.isNotEmpty(searchCriteriaText)){
				apmSearch.setBeneficiary(searchCriteriaText);
			}
			searchCriteria.append(ALOCConstants.SEARCH_BENEFICIARY_NAME);
			break;
		case BUC:
			if(StringUtils.isNotEmpty(searchCriteriaText)){
				apmSearch.setBUC(searchCriteriaText);
			}
			searchCriteria.append(ALOCConstants.SEARCH_BUC);
			break;
		case CURRENCY:
			if(StringUtils.isNotEmpty(searchCriteriaText)){
				apmSearch.setInstrumentCurrency(searchCriteriaText);
			}
			searchCriteria.append(ALOCConstants.SEARCH_CURRENCY);
			break;
		case FOREIGN_EXPIRY_DATE:
			if(StringUtils.isNotEmpty(searchCriteriaText)){
				apmSearch.setForeignExpiryDate(ALOCCommonHelper.convertStringToCal(searchCriteriaText));
			}
			searchCriteria.append(ALOCConstants.SEARCH_FOREIGN_EXP_DATE);
			break;
		case INSTRUMENT_AMOUNT:
			if(StringUtils.isNotEmpty(searchCriteriaText)){
				apmSearch.setInstrumentAmount(new BigDecimal(searchCriteriaText));
			}
			searchCriteria.append(ALOCConstants.SEARCH_INSTRUMENT_AMOUNT);
			break;	
		case PAYMENT_AMOUNT_GREATERTHAN:
			if(StringUtils.isNotEmpty(searchCriteriaText)){
				apmSearch.setPaymentAmount(new BigDecimal(searchCriteriaText));
			}
			searchCriteria.append(ALOCConstants.SEARCH_PAYMENT_AMT_GT);
			break;	
		case PAYMENT_BANK:
			if(StringUtils.isNotEmpty(searchCriteriaText)){
				apmSearch.setPaymentBank(searchCriteriaText);
			}
			searchCriteria.append(ALOCConstants.SEARCH_PAYMENT_BANK);
			break;	
		case PAYMENT_CURRENCY:
			if(StringUtils.isNotEmpty(searchCriteriaText)){
				apmSearch.setPaymentCurrency(searchCriteriaText);
			}
			searchCriteria.append(ALOCConstants.SEARCH_PAYMENT_CURRENCY);
			break;	
		case PAYMENT_DATE:
			if(StringUtils.isNotEmpty(searchCriteriaText)){
				apmSearch.setPaymentDate(ALOCCommonHelper.convertStringToCal(searchCriteriaText));
			}
			searchCriteria.append(ALOCConstants.SEARCH_PAYMENT_DATE);
			break;	
		default:
			break;
		}
		searchCriteria.append(searchCriteriaText);
		return apmSearch;
	}

	/**
	 * This is utility method to write {@link HSSFWorkbook} to {@link HttpServletResponse}.
	 * 
	 * @param poiWorkbook
	 * @param response
	 * @throws IOException
	 */
	private void writeExcelToResponse(HSSFWorkbook poiWorkbook, HttpServletResponse response) throws IOException {
		OutputStream out = null;
		try {
			out = response.getOutputStream();
			poiWorkbook.write(out);
			out.flush();
		} finally {
			try {
				if(out != null) {
					out.close();
				}
			} catch (IOException ioe) {
				LOGGER.warn(ALOCConstants.SERVELET_OUTPUTSTREAM_ERROR, ioe);
			}
		}
	}

	/**
	 * Method to Assign the decimal digits to the String
	 * @param apmDetails
	 * @return APMDetails
	 */
	public static APMDetails assignDecimalValue(APMDetails apmDetails){
		if(apmDetails != null && apmDetails.getFeeHistoryDetails()!=null && apmDetails.getFeeHistoryDetails().getFullSummaries()!=null){
			if(apmDetails.getFeeHistoryDetails().getFullSummaries().size()!=ALOCConstants.BASE_VALUE){
				List<FullSummary> fullSumLstOld = apmDetails.getFeeHistoryDetails().getFullSummaries();
				for(FullSummary eachFulSum: fullSumLstOld){
					if(eachFulSum.getPaymentAmount()!=null){
						eachFulSum.setPaymentAmountString(eachFulSum.getPaymentAmount().toString());
					}
				}
			}
		}
		return apmDetails;
	}

	/**
	 * Method to Assign the decimal digits to the String in FeePaymentRun screen ExpandView
	 * @param apmDetails
	 * @return APMDetails
	 */
	public static APMDetails getFeeRunAmountsAsString(APMDetails apmDetails){
		if(apmDetails.getFeePaymentRunDetails()!=null && apmDetails.getFeePaymentRunDetails().getRequestFeeDetails()!=null){
			if(apmDetails.getFeePaymentRunDetails().getRequestFeeDetails().size()!=ALOCConstants.BASE_VALUE){
				List<RequestFeeDetails> feeLst = apmDetails.getFeePaymentRunDetails().getRequestFeeDetails();
				for(RequestFeeDetails eachFeeDet: feeLst){
					if(eachFeeDet.getPaymentAmount() !=null){
						eachFeeDet.setPaymentAmountString(ALOCCommonHelper.getStringWithDecimalValue(eachFeeDet.getPaymentAmount().toString()));
					}
					if(eachFeeDet.getUSDEquival() !=null){
						eachFeeDet.setUSDEquivalString(ALOCCommonHelper.getStringWithDecimalValue(eachFeeDet.getUSDEquival().toString()));
					}
				}
			}
		}
		return apmDetails;
	}

	/**
	 * Method to Assign the decimal digits to the String in FeeSummaryDetails screen
	 * @param apmDetails
	 * @return APMDetails
	 */
	public static APMDetails getFeeSummaryAmountsAsString(APMDetails apmDetails){
		if(apmDetails.getFeeSummaryDetails()!=null && apmDetails.getFeeSummaryDetails().getUSForeignFee()!=null){
			apmDetails = getUSForeignFeeDetails(apmDetails);
		}
		if(apmDetails.getFeeSummaryDetails() != null && apmDetails.getFeeSummaryDetails().getOtherFees().size() != ALOCConstants.BASE_VALUE){
			List<OtherFee> otherFeeLst = apmDetails.getFeeSummaryDetails().getOtherFees();
			for(OtherFee eachFeeDet: otherFeeLst){
				if(eachFeeDet.getIncidental() !=null){
					eachFeeDet.setIncidentalString(eachFeeDet.getIncidental().toString());
				}
				if(eachFeeDet.getOneTime() !=null){
					eachFeeDet.setOneTimeString(eachFeeDet.getOneTime().toString());
				}
				if(eachFeeDet.getOther() !=null){
					eachFeeDet.setOtherString(eachFeeDet.getOther().toString());
				}
				if(eachFeeDet.getStampTaxes() !=null){
					eachFeeDet.setStampTaxesString(eachFeeDet.getStampTaxes().toString());
				}
				if(eachFeeDet.getVATTaxes() !=null){
					eachFeeDet.setVATTaxesString(eachFeeDet.getVATTaxes().toString());
				}
			}
		}
		if(apmDetails.getFeeSummaryDetails() != null && apmDetails.getFeeSummaryDetails().getFeeSummary() != null){
			FeeSummary feeSummary = apmDetails.getFeeSummaryDetails().getFeeSummary();
			if(feeSummary.getTotalForeign() !=null){
				feeSummary.setTotalForeignString(feeSummary.getTotalForeign().toString());
			}
			if(feeSummary.getTotalOther() !=null){
				feeSummary.setTotalOtherString(feeSummary.getTotalOther().toString());
			}
			if(feeSummary.getTotalPayment() !=null){
				feeSummary.setTotalPaymentString(feeSummary.getTotalPayment().toString());
			}
			if(feeSummary.getTotalUS() !=null){
				feeSummary.setTotalUSString(feeSummary.getTotalUS().toString());
			}
		}
		return apmDetails;
	}

	/**
	 * Method to get USForeignFeeDetails
	 * @param apmDetails
	 * @return APMDetails
	 */
	private static APMDetails getUSForeignFeeDetails(APMDetails apmDetails){

		USForeignFee usForeignFeeDetails = apmDetails.getFeeSummaryDetails().getUSForeignFee();
		if(usForeignFeeDetails.getUSFeeDetails()!= null && usForeignFeeDetails.getUSFeeDetails().getFeeDetails().size() !=ALOCConstants.BASE_VALUE){
			apmDetails = getUSFeeDetails(apmDetails);
		}
		if(usForeignFeeDetails.getForeignFeeDetails()!= null && usForeignFeeDetails.getForeignFeeDetails().getFeeDetails().size() !=ALOCConstants.BASE_VALUE){
			List<FeeDetails> foreignFeeLst = apmDetails.getFeeSummaryDetails().getUSForeignFee().getForeignFeeDetails().getFeeDetails();
			for(FeeDetails eachFeeDet: foreignFeeLst){
				if(eachFeeDet.getBPsRateInAdvance() !=null){
					eachFeeDet.setBPsRateInAdvanceString(eachFeeDet.getBPsRateInAdvance().toString());
				}
				if(eachFeeDet.getBPsRateInArrears() !=null){
					eachFeeDet.setBPsRateInArrearsString(eachFeeDet.getBPsRateInArrears().toString());
				}
				if(eachFeeDet.getFlatFeeLife() !=null){
					eachFeeDet.setFlatFeeLifeString(eachFeeDet.getFlatFeeLife().toString());
				}
				if(eachFeeDet.getFlatFeePA() !=null){
					eachFeeDet.setFlatFeePAString(eachFeeDet.getFlatFeePA().toString());
				}
				if(eachFeeDet.getPartialPeriodAmount() !=null){
					eachFeeDet.setPartialPeriodAmountString(eachFeeDet.getPartialPeriodAmount().toString());
				}
			}
		}
		if(usForeignFeeDetails.getUSTotalAmendment() != null){
			apmDetails.getFeeSummaryDetails().getUSForeignFee().setUSTotalAmendmentString(usForeignFeeDetails.getUSTotalAmendment().toString());
		}
		if(usForeignFeeDetails.getUSTotalPayment() != null){
			apmDetails.getFeeSummaryDetails().getUSForeignFee().setUSTotalPaymentString(usForeignFeeDetails.getUSTotalPayment().toString());
		}
		if(usForeignFeeDetails.getForeignTotalAmendment() != null){
			apmDetails.getFeeSummaryDetails().getUSForeignFee().setForeignTotalAmendmentString(usForeignFeeDetails.getForeignTotalAmendment().toString());
		}
		if(usForeignFeeDetails.getForeignTotalPayment() != null){
			apmDetails.getFeeSummaryDetails().getUSForeignFee().setForeignTotalPaymentString(usForeignFeeDetails.getForeignTotalPayment().toString());
		}
		if(apmDetails.getFeeSummaryDetails().getTotalOther() != null){
			apmDetails.getFeeSummaryDetails().setTotalOtherString(apmDetails.getFeeSummaryDetails().getTotalOther().toString());
		}
		return apmDetails;
	}

	/**
	 * Method to get USFeeDetails
	 * @param apmDetails
	 * @return APMDetails
	 */
	private static APMDetails getUSFeeDetails(APMDetails apmDetails){
		List<FeeDetails> usFeeLst = apmDetails.getFeeSummaryDetails().getUSForeignFee().getUSFeeDetails().getFeeDetails();
		for(FeeDetails eachFeeDet: usFeeLst){
			if(eachFeeDet.getBPsRateInAdvance() !=null){
				eachFeeDet.setBPsRateInAdvanceString(eachFeeDet.getBPsRateInAdvance().toString());
			}
			if(eachFeeDet.getBPsRateInArrears() !=null){
				eachFeeDet.setBPsRateInArrearsString(eachFeeDet.getBPsRateInArrears().toString());
			}
			if(eachFeeDet.getFlatFeeLife() !=null){
				eachFeeDet.setFlatFeeLifeString(eachFeeDet.getFlatFeeLife().toString());
			}
			if(eachFeeDet.getFlatFeePA() !=null){
				eachFeeDet.setFlatFeePAString(eachFeeDet.getFlatFeePA().toString());
			}
			if(eachFeeDet.getPartialPeriodAmount() !=null){
				eachFeeDet.setPartialPeriodAmountString(eachFeeDet.getPartialPeriodAmount().toString());
			}
		}
		return apmDetails;
	}
	
	/**
	 * Method to get USFeeDetails
	 * @param apmDetails
	 * @return APMDetails
	 */
	public static void removeBigDecimalZeroValues(APMDetails apmDetails){
		if(apmDetails != null && apmDetails.getFeeSummaryDetails() != null && apmDetails.getFeeSummaryDetails().getOtherFees() != null){
			List<OtherFee> otherFeeList = apmDetails.getFeeSummaryDetails().getOtherFees();
			int zero = ALOCConstants.BASE_VALUE;
			
			if(apmDetails.getFeeSummaryDetails().getTotalOther() != null && apmDetails.getFeeSummaryDetails().getTotalOther().compareTo(new BigDecimal(zero)) == zero){
				apmDetails.getFeeSummaryDetails().setTotalOther(null);
			}
			for(OtherFee fees : otherFeeList){
				if(fees.getVATTaxes() != null && fees.getVATTaxes().compareTo(new BigDecimal(zero)) == zero){
					fees.setVATTaxes(null);
				}
				if(fees.getStampTaxes() != null && fees.getStampTaxes().compareTo(new BigDecimal(zero)) == zero){
					fees.setStampTaxes(null);
				}
				if(fees.getIncidental() != null && fees.getIncidental().compareTo(new BigDecimal(zero)) == zero){
					fees.setIncidental(null);
				}
				if(fees.getOther() != null && fees.getOther().compareTo(new BigDecimal(zero)) == zero){
					fees.setOther(null);
				}
				if(fees.getOneTime() != null && fees.getOneTime().compareTo(new BigDecimal(zero)) == zero){
					fees.setOneTime(null);
				}
			}
		}
	}

}