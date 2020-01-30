/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: PDFReportHelper.java
 * Purpose: file is used to holding leg attachments
 * 
 */
package com.ge.icfp.util.report.pdf;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.lang.StringUtils;

import com.ge.icfp.action.ICFPException;
import com.ge.icfp.common.constants.ICFPConstants;
import com.ge.icfp.common.helper.ICFPCommonHelper;
import com.ge.icfp.common.helper.ICFPLegHelper;
import com.ge.icfp.model.DealRequest;
import com.ge.icfp.model.EquityLegRequest;
import com.ge.icfp.model.ExceptionRequestForm;
import com.ge.icfp.model.LegSummary;
import com.ge.icfp.model.RCALegRequest;
import com.ge.icfp.model.SolvencyMetrics;
import com.ge.icfp.model.StaticDataManagement.SolvencyMetricsCalc;
import com.ge.icfp.model.TPLegRequest;
import com.ge.icfp.util.ProductType;
import com.ge.icfp.util.SolvencyCalc;
import com.ge.icfp.util.Utils;
import com.itextpdf.text.BaseColor;
import static com.ge.icfp.common.constants.ICFPConstants.*;
/**
 * This is helper class for PDF report generation.
 * 
 * @author cnarvan
 *
 */
public class PDFReportHelper {
	private static final String CURRENCY_FORMAT = "###,###.##";
	private static final String DECIMAL_FORMAT = "#.##";
	/**
	 * Returns SolvencyMetrics Assessment of leg.
	 * 
	 * @param tpLegRequest
	 * @return
	 */
	public static String getSolvencyMetricsAssessment(TPLegRequest tpLegRequest){
		String result = NO_CAP;
		for (SolvencyMetrics solvencyMetrics : tpLegRequest.getSolvencyMetrics()) {
			if(solvencyMetrics.isAssessmentFlag()){
				result=YES_CAP;
				break;
			}
		}
		return result;
	}
	
	/**
	 * Returns the given date value from 2012-06-20T06:03:43.258+05:30 to format
	 * 06/20/2012 (MM/dd/yyyy)
	 * 
	 * @param date
	 * @return
	 */
	public static String formatDate(XMLGregorianCalendar date) {
		if(date == null) {
			return null;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(MM_DD_YYYY);
		return dateFormat.format(date.toGregorianCalendar().getTime());
	}
	
	/**
	 * Helper method to formats the currency.
	 * 
	 * @param currency
	 * @return
	 */
	public static String formatCurrency(Double currency) {
		if(currency == null) {
			return null;
		}
		DecimalFormat currencyFormatter = new DecimalFormat(CURRENCY_FORMAT);
		String currencyAsString = currencyFormatter.format(currency);
		return String.valueOf(currencyAsString);
	}
	
	/**
	 * Helper method to format the number.
	 * 
	 * @param number
	 * @return
	 */
	public static String formatNumber(Double number) {
		String result = null;
		if(number != null) {
			result = String.valueOf(number);
		}
		return result;
	}
	
	/**
	 * This method converts boolean variable to Yes or No.
	 * 
	 * @param value
	 * @return
	 */
	public static String convertBooleanAsYesOrNo(Boolean value) {
		String result = null;
		if(value != null) {
			result = (value) ? YES_CAP : NO_CAP;
		}
		return result;
	}
	
	/**
	 * This method converts zero or one to Yes or No flags.
	 * 
	 * @param value
	 * @return
	 */
	public static String convertZeroOrOneToNoOrYes(String value) {
		String result = null;
		if(StringUtils.isNotBlank(value)) {
			result = (value.equals(ONE)) ? YES_CAP : NO_CAP;
		}
		return result;
	}
	
	/**
	 * This method converts 'Y' or 'N' flags to YES_CAP or NO_CAP value.
	 * 
	 * @param value
	 * @return
	 */
	public static String convertYOrNToYesOrNo(String value) {
		String result = null;
		if(StringUtils.isNotBlank(value)) {
			result = (value.equalsIgnoreCase(ICFPConstants.Y_CAP)) ? YES_CAP : NO_CAP;
		}
		return result;
	}
	
	/**
	 * Computes the Sovency Matrix color code.
	 * 
	 * @param postTransaction
	 * @param pCondition
	 * @param cpCondition
	 * @param wCondition
	 * @return
	 * @throws ICFPException 
	 */
	public static BaseColor computeSolvencyColor(String postTransaction, SolvencyMetricsCalc solvencyMetricsCalc) throws ICFPException {
		SolvencyCalc solvencyCalc = new SolvencyCalc(postTransaction);
		if(solvencyCalc.validate(solvencyMetricsCalc.getPass())) {
			return BaseColor.GREEN;
		} else if(solvencyCalc.validate(solvencyMetricsCalc.getConditionalPass())) {
			return BaseColor.YELLOW;
		} else if(solvencyCalc.validate(solvencyMetricsCalc.getWeakPerformer())) {
			return BaseColor.RED;
		}
		return null;
	}
	
	/**
	 * Return true if any leg has exceptions.
	 * 
	 * @param deal
	 * @return
	 * @throws ICFPException 
	 */
	@SuppressWarnings("unchecked")
	public static boolean hasExceptions(DealRequest deal, int legCount) throws ICFPException {
		boolean hasExceptions = false;
		if(legCount > 0) {
			Object legSummary = null;
			List<ExceptionRequestForm> exceptionRequestFormList = null;
			for(int i = 1; i <= legCount; i++) {
				Object leg = ICFPCommonHelper.getLegByNumber(i, deal);
				legSummary = ICFPLegHelper.getLegSummary(leg);
				exceptionRequestFormList = Utils.fetchPropertyValue(EXCEPTIONREQUESTFORMS, legSummary, List.class);
				if(!exceptionRequestFormList.isEmpty()) {
					hasExceptions = true;
					break;
				}
			}
		}
		return hasExceptions;
	}
	
	/**
	 * Method to get borrower insolvency flag
	 * @param request
	 * @return
	 * @throws ICFPException 
	 */
	public static String getBorrowerInsolvencyFlag(DealRequest dealRequest) throws ICFPException{
		String borrowerInSolvent = null;
		boolean borrowerInSolventFlag = false;
		if(dealRequest.getLegs()!=null && dealRequest.getLegs().getAllLegs()!=null){
			List<Object> legList = dealRequest.getLegs().getAllLegs();
			for(Object leg : legList) {
				String opcode = ICFPLegHelper.getOpCode(leg);
				if(opcode == null || !opcode.equals(DELETE)) {
					if(!(leg instanceof EquityLegRequest)){
						TPLegRequest tpLegRequest = Utils.fetchPropertyValue(TPLEGREQUEST, leg, TPLegRequest.class);
						if(tpLegRequest != null && tpLegRequest.getSolvencyMetrics()!=null && !tpLegRequest.getSolvencyMetrics().isEmpty()){
							List<SolvencyMetrics> solvencyMetricsList = tpLegRequest.getSolvencyMetrics();
							for(SolvencyMetrics solvencyMetricsObj:solvencyMetricsList)
							{
								Integer solvencyMetricsID = solvencyMetricsObj.getSolvencyMetricId();
								if(solvencyMetricsID!=null && solvencyMetricsID.intValue()==7)
								{
									borrowerInSolventFlag = solvencyMetricsObj.isAssessmentFlag();
								}
								
								if(borrowerInSolventFlag){
									borrowerInSolvent = YES_CAP;
									break;
								}else if (!borrowerInSolventFlag && !StringUtils.isEmpty(borrowerInSolvent) &&
										!borrowerInSolvent.equals(NO_CAP))
								{
									borrowerInSolvent = NO_CAP;
								}
							}
						}
						if(borrowerInSolventFlag){
							break;
						}
					} else{
						borrowerInSolvent = NO_CAP;
					}
					} 
					
				
			}
		}
		return borrowerInSolvent;
	}
	
	/**
	 * Formats the double value.
	 * 
	 * @param value
	 * @return
	 */
	public static String formatDouble(Double value) {
		if(value != null) {
			DecimalFormat df = new DecimalFormat(DECIMAL_FORMAT);
			return df.format(value);
		}
		return null;
	}
	
	/**
	 * Formats the float value.
	 * 
	 * @param value
	 * @return
	 */
	public static String formatFloat(Float value) {
		if(value != null) {
			DecimalFormat df = new DecimalFormat(DECIMAL_FORMAT);
			return df.format(value);
		}
		return null;
	}
	
	/**
	 * Checks whether specified leg is Immediate Drawdown or not.
	 * 
	 * @param leg
	 * @return
	 */
	public static boolean isImmediateDrawdownLeg(Object leg) {
		if(leg instanceof RCALegRequest) {
			LegSummary legSummary = ((RCALegRequest) leg).getLegSummary();
			if(legSummary != null && StringUtils.isNotBlank(legSummary.getTransactionEventType()) && IMMEDIATE_DRAWDOWN.equalsIgnoreCase(legSummary.getTransactionEventType())) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * This method returns true; if derivatives exists and false; if not.
	 * This returns null; if derivatives not applicable for specified leg.
	 * @param leg
	 * @return
	 * @throws ICFPException 
	 */
	public static Boolean hasDerivatives(Object leg) throws ICFPException {
		ProductType productType = ICFPLegHelper.getProductType(leg);
		if(isImmediateDrawdownLeg(leg) || productType == ProductType.EQUITY || productType == ProductType.CPA) {
			return null;
		}
		LegSummary legSummary = (LegSummary) ICFPLegHelper.getLegSummary(leg);
		Boolean result = legSummary.isDerivativesFlag();
		result = (result != null) ? result : false;
		return result;
	}
	
	/**
	 * This method converts boolean variable to Yes or No.
	 * 
	 * @param value
	 * @return
	 */
	public static String convertBooleanAsYesOrNo(Boolean value, boolean defaultValue) {
		String result = null;
		value = (value == null) ? defaultValue : value;
		if(value != null) {
			result = (value) ? YES_CAP : NO_CAP;
		}
		return result;
	}
}
