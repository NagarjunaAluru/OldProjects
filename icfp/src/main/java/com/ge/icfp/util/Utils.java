/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: Utils.java
 * Purpose: file used for implementing utilities/reusable methods
 * 
 */

package com.ge.icfp.util;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMessage;

import com.ge.icfp.action.ICFPException;
import com.ge.icfp.common.constants.AttachmentConstants;
import com.ge.icfp.common.vo.NameValueVO;
import com.ge.icfp.model.DealRequest;
import com.ge.icfp.model.DerivativesRequest;
import com.ge.icfp.model.DerivativesRequest.CounterPartyInfo;
import com.ge.icfp.model.NameValue;
import com.ge.icfp.model.StaticDataManagement.TransactionEventTypes;
import com.ge.icfp.model.StaticDataManagement.WFStageDetails;
import com.ge.icfp.newrequest.form.vo.DerivativeDetailsVO;
import com.hydus.wff.core.exception.HWFServiceException;
import com.hydus.wff.core.exception.HWFStubException;

/**
 *	Used for utilities functions
 * @author hariprasad.madas
 *
 */
public class Utils {
	private static final Logger LOGGER = Logger.getLogger(Utils.class);
	
	public static DateFormat fmt = new SimpleDateFormat("MM/dd/yyyy");
	public static DateFormat dateTimefmt = new SimpleDateFormat("MM/dd/yyyy hh:mm aaa");
	public static DateFormat actionLogfmt = new SimpleDateFormat("MMM dd,yyyy hh:mm a");
	
	/**
	 * Parses a string to date in the format MM/dd/yyyy
	 * @param date
	 * @return date
	 * @throws ParseException
	 */
	public static Date parseDate(String date) throws ParseException{
		Date parsedDate = fmt.parse(date);
		return parsedDate;
	}
	
	
	/**
	 * Parses a date from a string in the format MM/dd/yyyy hh:mm aaa
	 * @param date
	 * @return date
	 * @throws ParseException
	 */
	public static Date parseDateTime(String date) throws ParseException {
		return dateTimefmt.parse(date);
	}
	
	/**
	 * Parse date available in the format MMM dd,yyyy hh:mm a 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date parseActionLogDate(String date) throws ParseException{
		return actionLogfmt.parse(date);
	}
	
	/**
	 * 
	 * @param date
	 * @return
	 */
	public static String formatDate(Date date) {
		String fmtdDate = "";
		fmtdDate = fmt.format(date);
		
		return fmtdDate;
	}
	/**
	 * Method will return the date in yyyy-MM-dd string format
	 * getCurrentDate
	 * @return
	 */
	public static String getCurrentDate(){		
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat( "yyyy-MM-dd" ); 
		return format.format( currentDate.getTime() );		
	}
	
	/**
	 * this method used to make blank to null
	 * @param value
	 * @return
	 */
	public static String makeBlankToNull(String value) {
		if(value != null && value.trim().length() == 0) {
			return null;
		}
		return value;
	}
	/**
	 * this method used 'null' string to null object
	 * @param value
	 * @return
	 */
	public static String makenullToNull(String value) {
		if(value!=null && value.equalsIgnoreCase("null")) {
			return null;
		}
		return value;
	}
	
	/**
	 * This method converts String array to Integer array.
	 * 
	 * @param input
	 * @return
	 */
	public static Integer[] convertStringArrayToIntegerArray(String[] input) {
		Integer[] result = null;
		if(input != null && input.length > 0) {
			result = new Integer[input.length];
			for(int i = 0; i < input.length; i++) {
				result[i] = Integer.valueOf(input[i]);
			}
		}
		return result;
	}
	
	
	/**
	 * This method used truncate escape chars if its window
	 * @param location
	 * @return
	 */
	public static String stringConcatForOS(String location) {
		if(location!=null) {
		if(location.contains("\\")) {
			location = location.replace("\\", "\\\\"); 
		}
		}
		return location;
	}
	
	/**
	 * createDerivativeDetailsVOList
	 * @param derivativeRequestList
	 * @param request
	 * @return
	 * @throws HWFServiceException 
	 * @throws HWFStubException 
	 */
	public static List<DerivativeDetailsVO> createDerivativeDetailsVOList(
			List<DerivativesRequest> derivativeRequestList,
			HttpServletRequest request) throws HWFServiceException, HWFStubException {
		List<DerivativeDetailsVO> derivativeDetailsVOList = new ArrayList<DerivativeDetailsVO>();
		int count = 1;
		for (DerivativesRequest derivativeRequest : derivativeRequestList) {
			if (!derivativeRequest.getDerivativesOpcode().equalsIgnoreCase("DELETE")) {
				DerivativeDetailsVO derivativeDetailsVO = createDerivativeDetailsVO(derivativeRequest, request);
				derivativeDetailsVO.setDerivativeNumber(count);
				derivativeDetailsVOList.add(derivativeDetailsVO);
			}
			count++;
		}
		return derivativeDetailsVOList;
	}
	
	/**
	 * createDerivativeDetailsVO
	 * @param derivativeRequest
	 * @param request
	 * @return
	 * @throws HWFServiceException 
	 * @throws HWFStubException 
	 */
	public static DerivativeDetailsVO createDerivativeDetailsVO(DerivativesRequest derivativeRequest, HttpServletRequest request) throws HWFServiceException, HWFStubException {
		DerivativeDetailsVO derivativeVO = new DerivativeDetailsVO();
		StaticDataFactory staticDataFactory =(StaticDataFactory)request.getSession().getServletContext().getAttribute(StaticDataFactory.CTX_KEY);
		MasterDataFactory masterDataFactory = (MasterDataFactory)request.getSession().getServletContext().getAttribute(MasterDataFactory.CTX_KEY);
		if(derivativeRequest.getDerivativeTypeId() != null) {
			String derivativeType = getLabel(staticDataFactory.getDerivativeTypes(),derivativeRequest.getDerivativeTypeId());
			derivativeVO.setDerivativeType(derivativeType);
			derivativeVO.setDerivativeTypeId(derivativeRequest.getDerivativeTypeId().toString());
		}
		derivativeVO.setDeriativesSeqId(derivativeRequest.getDeriativesSeqId());
		Integer deriativesCategoryId = derivativeRequest.getDeriativesCategoryId();
		if(deriativesCategoryId != null && deriativesCategoryId == 1) {
			derivativeVO.setInternalOrExternal("Internal");
		} else {
			derivativeVO.setInternalOrExternal("External");
		}
		
		if(derivativeRequest.getTermInMonths()!=null){
			derivativeVO.setTermInMonths(derivativeRequest.getTermInMonths());
		}
		
		if(derivativeRequest.getContractClassId()!=null){
			derivativeVO.setContractClass(derivativeRequest.getContractClassValue());
		}
		
		if(derivativeRequest.getHedgeProgramId()!=null)
		{
			String hedgeProgram = getLabel(staticDataFactory.getHedgePrograms(),derivativeRequest.getHedgeProgramId());
			derivativeVO.setHedgeProgram(hedgeProgram);
			derivativeVO.setHedgeProgramId(derivativeRequest.getHedgeProgramId().toString());
			
		}
		
		if(derivativeRequest.getHedgeDesignationId() != null) {
			String hedgeDesignation = getLabel(staticDataFactory.getHedgeDesignation(),derivativeRequest.getHedgeDesignationId());
			derivativeVO.setHedgeDesigation(hedgeDesignation);
			derivativeVO.setHedgeDesigationId(derivativeRequest.getHedgeDesignationId().toString());
		}
		if(derivativeRequest.getTaxDesignationId() != null) {
			String taxDesignation = getLabel(staticDataFactory.getTaxDesignation(),derivativeRequest.getTaxDesignationId());
			derivativeVO.setTaxDesigation(taxDesignation);
		}
		
		CounterPartyInfo counterParty1 = (derivativeRequest.getCounterPartyInfos().size() > 0) ? derivativeRequest.getCounterPartyInfos().get(0) : null;
		CounterPartyInfo counterParty2 = (derivativeRequest.getCounterPartyInfos().size() > 1) ? derivativeRequest.getCounterPartyInfos().get(1) : null;
		
		if(counterParty1!=null && counterParty1.getDayCountId()!=null)
		{
			String dayCount = getLabel(staticDataFactory.getDayCounts(),counterParty1.getDayCountId());
			counterParty1.setDayCount(dayCount);
		}
		
		if(counterParty2!=null && counterParty2.getDayCountId()!=null)
		{
			String dayCount = getLabel(staticDataFactory.getDayCounts(),counterParty2.getDayCountId());
			counterParty2.setDayCount(dayCount);
		}
		
		if(counterParty1!=null && counterParty1.getInterestResetFreqId()!=null)
		{
			String interestResetFreq = getLabel(staticDataFactory.getInterestResetFreqs(),counterParty1.getInterestResetFreqId());
			counterParty1.setInterestResetFreq(interestResetFreq);
		}
		
		if(counterParty2!=null && counterParty2.getDayCountId()!=null)
		{
			String interestResetFreq = getLabel(staticDataFactory.getInterestResetFreqs(),counterParty2.getInterestResetFreqId());
			counterParty2.setInterestResetFreq(interestResetFreq);
		}
		
		if(counterParty1!=null)
		{
			derivativeVO.setCounterPartyInfo1(counterParty1);
		}
		
		if(counterParty2 !=null)
		{
			derivativeVO.setCounterPartyInfo2(counterParty2);
		}
		
		
		
		String currency1 = null;
		if(counterParty1==null || counterParty1.getCurrencyPair()==null){
			currency1 = "-";
		}else{
			currency1 = getLabelCurrency(masterDataFactory.getDealCurrencies(),counterParty1.getCurrencyPair());
		}
		String currency2 = null;
		if(counterParty2==null || counterParty2.getCurrencyPair()==null){
			currency2 = "-";
		}else{
			currency2 = getLabelCurrency(masterDataFactory.getDealCurrencies(),counterParty2.getCurrencyPair());
		}
		derivativeVO.setCurrency1(currency1);
		if(counterParty1.getAmt()!=null)
		{
			String counterPart1Amt= counterParty1.getAmt().toString();
			derivativeVO.setDerivativeAmount1(counterPart1Amt == null ? "-" :counterPart1Amt);
		}	
		if(counterParty1.getInterestTypeId() != null){
			derivativeVO.setFixedOrFloat1((counterParty1 != null && counterParty1.getInterestTypeId() == 2)  ? "Float" : "Fixed");	
		}
		
		
		
		derivativeVO.setCurrency2(currency2);
		if(counterParty2.getAmt()!=null){
			String counterPart2Amt= counterParty2.getAmt().toString();
			derivativeVO.setDerivativeAmount2(counterPart2Amt == null ? "-" :counterPart2Amt);
		}
		if(counterParty2.getInterestTypeId() != null){
			derivativeVO.setFixedOrFloat2((counterParty2 != null && counterParty2.getInterestTypeId() == 2) ? "Float" : "Fixed");	
		}
		if(derivativeRequest.getTradeRequestWorkflowId()!=null && StringUtils.isNotEmpty(derivativeRequest.getTradeRequestWorkflowId()))
		{
			derivativeVO.setTradeRequestWorkflowId(derivativeRequest.getTradeRequestWorkflowId());
		}else{
			derivativeVO.setTradeRequestWorkflowId("");
		}
		if(derivativeRequest.getDerivativesTradeId()!=null && StringUtils.isNotEmpty(derivativeRequest.getDerivativesTradeId()))
		{
			derivativeVO.setDerivativeTradeId(derivativeRequest.getDerivativesTradeId());
		}else{
			derivativeVO.setDerivativeTradeId("");
		}
		
		return derivativeVO;
	}
	
	/**
	 * getLabel
	 * @param listObj
	 * @param id
	 * @return
	 */
	public static String getLabel(List<NameValue> listObj,int id){
		 String label = "-";
		 for(NameValue nameValue:listObj){
			 if(nameValue.getID().equals(id)){
				 label = nameValue.getName(); 
			 }
		 }
		 return label;
	 }
	
	/**
	 * getLabelCurrency
	 * @param listObj
	 * @param id
	 * @return
	 */
	
	public static String getLabelCurrency(List<NameValueVO> listObj,String id){
		 String label = "-";
		 for(NameValueVO nameValue:listObj){
			 if(nameValue.getId().equals(id)){
				 label = nameValue.getName(); 
			 }
		 }
		 return label;
	 }

	/**
	 * getProductName
	 * @param productId
	 * @param request
	 * @return
	 * @throws HWFServiceException 
	 * @throws HWFStubException 
	 */
	public static String getProductName(int productId, HttpServletRequest request) throws HWFServiceException, HWFStubException{
		ServletContext servletContext = request.getSession().getServletContext();
		StaticDataFactory staticDataFactory =(StaticDataFactory)servletContext.getAttribute(StaticDataFactory.CTX_KEY); 
		List <NameValue> producttypes = staticDataFactory.getProductTypes(); 
		for(NameValue namevalue:producttypes){
			if(productId == namevalue.getID()){
				return namevalue.getName();
			}
		}
		return "";
	}
	
	
	/**
	 * getProductName
	 * @param productId
	 * @param request
	 * @return
	 * @throws HWFServiceException 
	 * @throws HWFStubException 
	 */
	public static String getFundingCompanyName(int companyId, HttpServletRequest request) throws HWFServiceException, HWFStubException{
		ServletContext servletContext = request.getSession().getServletContext();
		StaticDataFactory staticDataFactory =(StaticDataFactory)servletContext.getAttribute(StaticDataFactory.CTX_KEY); 
		List <NameValue> fundingCompanyNames = staticDataFactory.getFundingCompany(); 
		for(NameValue namevalue:fundingCompanyNames){
			if(companyId == namevalue.getID()){
				return namevalue.getName();
			}
		}
		return "";
	}

	/**
	 * getDealCategoryName
	 * @param productId
	 * @param request
	 * @return
	 * @throws HWFServiceException
	 * @throws HWFStubException 
	 */
	public static String getDealCategoryName(int dealCategoryId, HttpServletRequest request) throws HWFServiceException, HWFStubException{
		ServletContext servletContext = request.getSession().getServletContext();
		StaticDataFactory staticDataFactory =(StaticDataFactory)servletContext.getAttribute(StaticDataFactory.CTX_KEY); 
		List <NameValue> dealCategoryNames = staticDataFactory.getDealCategories(); 
		for(NameValue namevalue:dealCategoryNames){
			if(dealCategoryId == namevalue.getID()){
				return namevalue.getName();
			}
		}
		return "";
	}
	/**
	 * 
	 * @param workFlowStage
	 * @param request
	 * @return
	 * @throws HWFServiceException
	 * @throws HWFStubException
	 */
	public static String getWorkFlowStageDesc(String workFlowStage, HttpServletRequest request) throws HWFServiceException, HWFStubException{
		ServletContext servletContext = request.getSession().getServletContext();
		StaticDataFactory staticDataFactory =(StaticDataFactory)servletContext.getAttribute(StaticDataFactory.CTX_KEY); 
		List<WFStageDetails> workFlowStages = staticDataFactory.getWorkFlowStageDetails(); 
		for(WFStageDetails wfStageDetails : workFlowStages){
			if(workFlowStage.equalsIgnoreCase(wfStageDetails.getWFStage())){
				return wfStageDetails.getWFStageDesc();
			}
		}
		return "";
	}
	/**
	 * 
	 * @param workFlowStageId
	 * @param request
	 * @return
	 * @throws HWFServiceException
	 * @throws HWFStubException
	 */
	public static String getWorkFlowStageDesc(Integer workFlowStageId, HttpServletRequest request) throws HWFServiceException, HWFStubException{
		ServletContext servletContext = request.getSession().getServletContext();
		StaticDataFactory staticDataFactory =(StaticDataFactory)servletContext.getAttribute(StaticDataFactory.CTX_KEY); 
		List<WFStageDetails> workFlowStages = staticDataFactory.getWorkFlowStageDetails(); 
		for(WFStageDetails wfStageDetails : workFlowStages){
			if(String.valueOf(workFlowStageId).equals(wfStageDetails.getWFStageId())){
				return wfStageDetails.getWFStageDesc();
			}
		}
		return "";
	}
	/**
	 * getDealCurrencyName
	 * @param dealCurrency
	 * @param request
	 * @return
	 * @throws HWFServiceException
	 * @throws HWFStubException
	 */
	public static String getDealCurrencyName(String dealCurrency, HttpServletRequest request) throws HWFServiceException, HWFStubException{
		ServletContext servletContext = request.getSession().getServletContext();
		MasterDataFactory masterDataFactory =(MasterDataFactory)servletContext.getAttribute(MasterDataFactory.CTX_KEY); 
		List <NameValueVO> dealCurrencyNames = masterDataFactory.getDealCurrencies(); 
		for(NameValueVO namevalue : dealCurrencyNames){
			if(dealCurrency.equals(namevalue.getId())){
				return namevalue.getName();
			}
		}
		return "";
	}
	/**
	 * getDealCountryName
	 * @param dealCountry
	 * @param request
	 * @return
	 * @throws HWFServiceException
	 * @throws HWFStubException
	 */
	public static String getDealCountryName(String dealCountry, HttpServletRequest request) throws HWFServiceException, HWFStubException{
		ServletContext servletContext = request.getSession().getServletContext();
		MasterDataFactory masterDataFactory =(MasterDataFactory)servletContext.getAttribute(MasterDataFactory.CTX_KEY); 
		List <NameValueVO> dealCountryNames = masterDataFactory.getCountries(); 
		for(NameValueVO namevalue : dealCountryNames){
			if(dealCountry.equals(namevalue.getId())){
				return namevalue.getName();
			}
		}
		return "";
	}
	/**
	 * getDealRegionName
	 * @param dealRegion
	 * @param request
	 * @return
	 * @throws HWFServiceException
	 * @throws HWFStubException
	 */
	public static String getDealRegionName(String dealRegion, HttpServletRequest request) throws HWFServiceException, HWFStubException{
		ServletContext servletContext = request.getSession().getServletContext();
		MasterDataFactory masterDataFactory =(MasterDataFactory)servletContext.getAttribute(MasterDataFactory.CTX_KEY); 
		List <NameValueVO> dealRegionNames = masterDataFactory.getRegions(); 
		for(NameValueVO namevalue : dealRegionNames){
			if(dealRegion.equals(namevalue.getId())){
				return namevalue.getName();
			}
		}
		return "";
	}
	/**
	 * 
	 * @param eventTypeId
	 * @param request
	 * @return
	 * @throws HWFServiceException
	 * @throws HWFStubException
	 */
	public static String getEventTypeName(String eventTypeId, HttpServletRequest request) throws HWFServiceException, HWFStubException{
		ServletContext servletContext = request.getSession().getServletContext();
		StaticDataFactory staticDataFactory =(StaticDataFactory)servletContext.getAttribute(StaticDataFactory.CTX_KEY); 
		List <TransactionEventTypes> dealCategoryNames = staticDataFactory.getEventType();
		for(TransactionEventTypes namevalue:dealCategoryNames){
			if(eventTypeId.equals(namevalue.getEventTypeID())){
				return namevalue.getEventTypeName();
			}
		}
		return "";
	}
	/**
	 * validateValueDt
	 * @param valueDt
	 * @param errors
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static ActionErrors validateValueDt(String valueDt,ActionErrors errors,XMLGregorianCalendar dealRequestDate)
	{
		try{

			String mm="";
			String dd="";
			String yyyy="";
			String dealRequestDateStr="";
			String vaultDtStr="";
			if(dealRequestDate!=null)
			{
				mm = String.valueOf(dealRequestDate.getMonth());
				mm = (mm!=null && mm.length()==1) ? mm="0"+mm : mm;
				dd = String.valueOf(dealRequestDate.getDay());
				dd = (dd!=null && dd.length()==1) ? dd="0"+dd : dd;
				yyyy = String.valueOf(dealRequestDate.getYear());
				dealRequestDateStr = mm+"/"+dd+"/"+yyyy;
			}
			if(valueDt!=null && valueDt.trim().length()>=10)
			{
				mm = valueDt.substring(0, 2);
				dd = valueDt.substring(3, 5);
				yyyy = valueDt.substring(6, 10);
				vaultDtStr = mm+"/"+dd+"/"+yyyy;
			}	
			long  diffDays = DateUtil.daysBetweenDates(dealRequestDateStr, vaultDtStr );
			if(diffDays<=0)
			{
				if(errors == null)
				{
					errors = new ActionErrors();
				}
				errors.add("valueDateInPipeLineReview", new ActionMessage("valueDateInPipeLineReview"));

				if(errors!=null && !errors.isEmpty())
				{
					return errors;
				}
			}
		}catch(Exception e)
		{
			return null;
		}
		return errors;
	}
	/**
	 * validateLatestDtOfFinSttmnt is used to validate the Latest Date of financial statement
	 * @param latestDtOfFinSttmnt
	 * @param errors
	 * @return
	 */
	public ActionErrors validateLatestDtOfFinSttmnt(String latestDtOfFinSttmnt,ActionErrors errors)
	{
			try{
				
				String currentDate = DateUtil.getCurrentDate();
			
				String mm="";
				String dd="";
				String yyyy="";
				long diffDays = 0;
				
				if(currentDate!=null)
				{
					mm = currentDate.substring(5,7);
					dd = currentDate.substring(8,10);
					yyyy = currentDate.substring(0,4);
				}
				
				currentDate = mm+"/"+dd+"/"+yyyy;
	
				if(latestDtOfFinSttmnt!=null && latestDtOfFinSttmnt.trim().length()>=10)
				{
					diffDays = DateUtil.daysBetweenDates(currentDate, latestDtOfFinSttmnt );
				}
	
				if(diffDays<0)
				{
					if(errors == null)
					{
						errors = new ActionErrors();
					}
					errors.add("latestDtOfFinSttmntCurrDateValidation", new ActionMessage("latestDtOfFinSttmntValidation"));
				}
	
			}catch(Exception e)
			{
				return null;
			}
		
		return errors;
	}
	
	/**
	 * formatCurrency
	 * @param currency
	 * @return {@link String}
	 */
	protected static String formatCurrency(String currency){
		if(currency != null && !currency.equals("") && !currency.equals("null")){
			Double cur = Double.parseDouble(currency);
			NumberFormat currencyFormatter;
			currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
			currency = currencyFormatter.format(cur);
			currency = currency.substring(1, currency.indexOf("."));
		}
		return currency;
			
	}
	
	/**
	 * This method fetches the specified property value from the specified bean.
	 * 
	 * @param object
	 * @param exceptedType
	 * @return
	 * @throws ICFPException 
	 */
	public static <T> T fetchPropertyValue(String name, Object bean, Class<T> expectedType) throws ICFPException {
		Object result = null;
		try {
			result = PropertyUtils.getProperty(bean, name);
		} catch (Exception e) {
			String errMsg = new StringBuilder().append("Could not fetch property \'").append(name).append("\' on bean \'").append(bean.getClass().getName()).append("\'").toString();
			LOGGER.error(errMsg, e);
			throw new ICFPException("ICFP_300", errMsg, e);
		} 
		return expectedType.cast(result);
	}
	
	/**
	 * This method fetches the specified property value from the specified bean as {@link String}.
	 * 
	 * @return
	 * @throws ICFPException 
	 */
	public static String fetchPropertyValueAsString(String name, Object bean) throws ICFPException {
		Object result = null;
		try {
			result = PropertyUtils.getProperty(bean, name);
		} catch (Exception e) {
			String errMsg = new StringBuilder().append("Could not fetch property \'").append(name).append("\' on bean \'").append(bean.getClass().getName()).append("\'").toString();
			LOGGER.error(errMsg, e);
			throw new ICFPException("ICFP_300", errMsg, e);
		} 
		return (result != null) ? String.valueOf(result) : null;
	}
	
	/**
	 * 
	 * @param name
	 * @param value
	 * @param bean
	 * @throws ICFPException 
	 */
	public static void setPropertyValue(String name, Object value, Object bean) throws ICFPException {
		try {
			PropertyUtils.setProperty(bean, name, value);
		} catch (Exception e) {
			String errMsg = new StringBuilder().append("Could not set property \'").append(name).append("\' on bean \'").append(bean.getClass().getName())
					.append("\' with value ").append(value).toString();
			LOGGER.error(errMsg, e);
			throw new ICFPException("ICFP_301", errMsg, e);
		} 
	}

	
	/**
	 * Checks whether all properties of a bean are empty or not
	 * 
	 * @param bean
	 * @return
	 * @throws ICFPException
	 */
	public static boolean isAllPropertiesBlank(Object bean) throws ICFPException {
		boolean allBlank = true;
		try {
			@SuppressWarnings("unchecked")
			Map<String, Object> map = new BeanMap(bean);
			for (String key : map.keySet()) {
				if ("class".equalsIgnoreCase(key) || "metaClass".equalsIgnoreCase(key)) {
					continue;
				}
				
				Object value = map.get(key);
				if(value == null) {
					continue;
				}
				
				if(value instanceof String && StringUtils.isBlank((String) value)) {
					continue;
				}
				
				if(value.getClass().isArray() && Array.getLength(value) == 0) {
					continue;
				}
				
				if(Collection.class.isAssignableFrom(value.getClass()) && ((Collection<?>) value).isEmpty()) {
					continue;
				}
				
				allBlank = false;
				break;
			}
		} catch (Exception e) {
			String errMsg = new StringBuilder().append("Could not fetch properties of bean \'").append(bean.getClass().getName()).append("\'").toString();
			LOGGER.error(errMsg, e);
			throw new ICFPException("ICFP_302", errMsg, e);
		}
		return allBlank;
	}
	
	/**
	 * Removes blank elements from specified object.
	 * 
	 * @param model
	 * @return
	 * @throws ICFPException 
	 */
	public static <T extends Object> T cleanBlankElements(T model) throws ICFPException {
		T result = null;
		
		if(isAllPropertiesBlank(model)) {
			return result;
		}
		
		result = model;
		
		// Not considering the model classes only
		if(model == null || !model.getClass().getPackage().getName().equals(DealRequest.class.getPackage().getName())) {
			return result;
		}
		
		try {
		@SuppressWarnings("unchecked")
		Map<String, Object> beanMap = new BeanMap(model);
		for(Entry<String, Object> entry : beanMap.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			
			if ("class".equalsIgnoreCase(key) || "metaClass".equalsIgnoreCase(key)) {
				continue;
			}
			
			if(value == null) {
				continue;
			}
			
			if(value instanceof String && StringUtils.isBlank(String.valueOf(value))) {
				beanMap.put(key, null); // Replacing blank String values to null
			}
			
			// Verifying sub model object
			if(DealRequest.class.getPackage() == value.getClass().getPackage() && cleanBlankElements(value) == null) {
				beanMap.put(key, null); // Replacing sub model object with null; if it is empty
			}
		}
		} catch (Exception e) {
			String errMsg = new StringBuilder().append("Could not clean blank properties of model \'").append(model.getClass().getName()).append("\'").toString();
			LOGGER.error(errMsg, e);
			throw new ICFPException("ICFP_303", errMsg, e);
		} 
		
		// Checking the bean after analyzing the properties;
		if(isAllPropertiesBlank(model)) {
			result = null;
		}
		return result;
	}
	
	/**
	 * 
	 * @param params
	 * @return
	 */
	public static final String toString(Object[] params) {
		StringBuilder result = new StringBuilder();
		if(params != null && params.length > 0) {
			int size = params.length;
			for(int i = 0; i < size; i++) {
				result.append(params[i]);
				if(i < size - 1) {
					result.append(",");
				}
			}
		}
		return result.toString();
	}
}
