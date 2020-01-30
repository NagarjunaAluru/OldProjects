/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: SearchUtils.java
 * Purpose: SearchUtils is a utility class to sync criteria's before displaying
 */
package com.ge.icfp.util;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.axis.utils.StringUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.struts.action.DynaActionForm;

import com.ge.icfp.common.constants.ICFPConstants;
import com.ge.icfp.model.Search;
import com.ge.icfp.model.Search.Borrower;
import com.ge.icfp.model.Search.CashPoolLeader;
import com.ge.icfp.model.Search.CashPoolParticipant;
import com.ge.icfp.model.Search.Lender;
import com.hydus.wff.core.exception.HWFServiceException;
import com.hydus.wff.core.exception.HWFStubException;
import static com.ge.icfp.common.constants.ICFPConstants.*;
/**
 * 
 * @author madhusudhan.gosula
 *
 */
public class SearchUtils {
	/**
	 * 
	 * @param productType
	 * @param eventType
	 * @param region
	 * @param businessSegments
	 * @param dealCategory
	 * @param search
	 * @param request
	 * @throws HWFServiceException
	 * @throws HWFStubException
	 */
	public static void syncPipelineSearchCriteria(String[] productType, String[] eventType,
			String[] region, String[] businessSegments, String[] ownerBusinessSegments,
			String[] dealCategory, String[] workFlowState, String[] dealType, 
			String[] priority, String[] currency, Search search, 
			HttpServletRequest request ) throws HWFServiceException, HWFStubException {
		
		productType = removeBlankElements(productType);
		eventType = removeBlankElements(eventType);
		workFlowState = removeBlankElements(workFlowState);
		region = removeBlankElements(region);
		dealCategory = removeBlankElements(dealCategory);
		dealType = removeBlankElements(dealType);
		priority = removeBlankElements(priority);
		currency = removeBlankElements(currency);
		if(productType != null && productType.length > 0){
			search.setProductTypes(Arrays.asList(productType));
		}else{
			search.setProductTypes(null);
		}
		if(eventType != null && eventType.length > 0){
			search.setEventTypes(Arrays.asList(eventType));
		}else{
			search.setEventTypes(null);
		}
		if(region != null && region.length > 0){
			search.setRegions(Arrays.asList(region));
		}else{
			search.setRegions(null);
		}
		if(businessSegments != null ){
			search.setBusinessSegments(Arrays.asList(businessSegments));
		}else{
			search.setBusinessSegments(null);
		}
		if(ownerBusinessSegments != null ){
			search.setOwnerBusinessSegments(Arrays.asList(ownerBusinessSegments));
		}else{
			search.setOwnerBusinessSegments(null);
		}
		if(dealCategory != null && dealCategory.length > 0){
			Integer[] dealCat = new Integer[dealCategory.length];
			for (int i = 0; i < dealCategory.length; i++) {
				dealCat[i] = Integer.parseInt(dealCategory[i]);
			}
			search.setDealCategories(Arrays.asList(dealCat));
		}else{
			search.setDealCategories(null);
		}
		
		if(StringUtils.isEmpty(search.getDealId())){
			search.setDealId(null);
		}
		
		if(StringUtils.isEmpty(search.getDealName())){
			search.setDealName(null);
		}
		
		if(StringUtils.isEmpty(search.getCDR())){
			search.setCDR(null);
		}
		
		if(StringUtils.isEmpty(search.getGoldId())){
			search.setGoldId(null);
		}
		boolean isSNO = false;
		if(workFlowState != null && workFlowState.length > 0){
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < workFlowState.length; i++) {
				if(!StringUtils.isEmpty(workFlowState[i])){
					if(TWENTYSEVEN.equals(workFlowState[i])){
						isSNO = true;
					}
					sb.append(workFlowState[i]);
					if(i < (workFlowState.length - 1))
						sb.append(",");
				}
			}
			if(sb.length()>0){
				if(isSNO){
					sb.append(",13");
				}
				search.setWorkFlowState(sb.toString());
			}else{
				search.setWorkFlowState(null);
			}
		}else{
			search.setWorkFlowState(null);
		}
		if(dealType != null && dealType.length > 0){
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < dealType.length; i++) {
				if(!StringUtils.isEmpty(dealType[i])){
					sb.append("'").append(dealType[i]).append("'");
					if(i < (dealType.length - 1))
						sb.append(",");
				}
			}
			if(sb.length()>0){
				search.setDealType(sb.toString());
			}else{
				search.setDealType(null);
			}
			
		}else{
			search.setDealType(null);
		}
		
		if(priority != null && priority.length > 0){
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < priority.length; i++) {
				if(!StringUtils.isEmpty(priority[i])){
					sb.append(priority[i]);
					if(i < (priority.length - 1))
						sb.append(",");
				}
			}
			if(sb.length()>0){
				search.setPriority(sb.toString());
			}else{
				search.setPriority(null);
			}
		}else{
			search.setPriority(null);
		}
		
		if(currency != null && currency.length > 0){
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < currency.length; i++) {
				if(!StringUtils.isEmpty(currency[i])){
					sb.append("'").append(currency[i]).append("'");
					if(i < (currency.length - 1))
						sb.append(",");
				}
			}
			if(sb.length()>0){
				search.setOriginalCurrency(sb.toString());
			}else{
				search.setOriginalCurrency(null);
			}
		}else{
			search.setOriginalCurrency(null);
		}
		
		if(StringUtils.isEmpty(search.getDealWithDerivatives())){
			search.setDealWithDerivatives(null);
		}
		
		if(StringUtils.isEmpty(search.getDebtValueFrom())){
			search.setDebtValueFrom(null);
		}
		if(StringUtils.isEmpty(search.getDebtValueTo())){
			search.setDebtValueTo(null);
		}
		
		if(StringUtils.isEmpty(search.getEquityValueFrom())){
			search.setEquityValueFrom(null);
		}
		if(StringUtils.isEmpty(search.getEquityValueTo())){
			search.setEquityValueTo(null);
		}
		
		if(StringUtils.isEmpty(search.getValueDtFrom())){
			search.setValueDtFrom(null);
		}
		else{
			search.setValueDtFrom(search.getValueDtFrom().toString().replaceAll("/", "-"));
		}
		if(StringUtils.isEmpty(search.getValueDtTo())){
			search.setValueDtTo(null);
		}else{
			search.setValueDtTo(search.getValueDtTo().toString().replaceAll("/", "-"));
		}
		
		if(StringUtils.isEmpty(search.getDaysRemainingFrom())){
			search.setDaysRemainingFrom(null);
		}
		if(StringUtils.isEmpty(search.getDaysRemainingTo())){
			search.setDaysRemainingTo(null);
		}
		
		if(StringUtils.isEmpty(search.getFirstName())){
			search.setFirstName(null);
		}else{
			search.setFirstName(search.getFirstName().trim());
		}
		
		if(StringUtils.isEmpty(search.getLastName())){
			search.setLastName(null);
		}else{
			search.setLastName(search.getLastName().trim());
		}
		
		if(StringUtils.isEmpty(search.getSsoId())){
			search.setSsoId(null);
		}
		
	}
	/**
	 * @param productType
	 * @param eventType
	 * @param requestState
	 * @param region
	 * @param businessSegments
	 * @param cashPoolDetailsCurrency 
	 * @param cashPoolDetailsRegion 
	 * @param cashPoolDetailsCountry 
	 * @param cashPoolDetailsBankName 
	 * @param dealCategory 
	 * @param search
	 * @throws HWFStubException 
	 * @throws HWFServiceException 
	 */
	public static void syncSearchCriteria(String[] productType, String[] eventType,
			String[] requestState, String[] region, String[] businessSegments, String[] ownerBusinessSegments,
			Integer[] dealCategory, String[] cashPoolDetailsBankName, String[] cashPoolDetailsCountry, 
			String[] cashPoolDetailsRegion, String[] cashPoolDetailsCurrency, DynaActionForm lenderForm,
			DynaActionForm borrowerForm, DynaActionForm cashPoolParticipantForm, DynaActionForm cashPoolLeaderForm, Search search, 
			Map<String, String> result, HttpServletRequest request ) throws HWFServiceException, HWFStubException {
		
		productType = removeBlankElements(productType);
		eventType = removeBlankElements(eventType);
		requestState = removeBlankElements(requestState);
		region = removeBlankElements(region);
		dealCategory = removeBlankElements(dealCategory);
		cashPoolDetailsBankName = removeBlankElements(cashPoolDetailsBankName);
		cashPoolDetailsCountry = removeBlankElements(cashPoolDetailsCountry);
		cashPoolDetailsRegion = removeBlankElements(cashPoolDetailsRegion);
		cashPoolDetailsCurrency = removeBlankElements(cashPoolDetailsCurrency);
		if(productType != null && productType.length > 0){
			search.setProductTypes(Arrays.asList(productType));
			String[] productTypeNames = getProductTypeNames(productType);
			StringBuilder sb = getListElement(productTypeNames);
			result.put(PRODUCT_TYPE, sb.toString());
		}
		else
			search.setProductTypes(null);
		if(eventType != null && eventType.length > 0){
			search.setEventTypes(Arrays.asList(eventType));
			String[] eventTypeNames = getEventTypeNames(eventType);
			StringBuilder sb = getListElement(eventTypeNames);
			result.put(EVENT_TYPE, sb.toString());
		}
		else
			search.setEventTypes(null);
		if(requestState != null && requestState.length > 0){
			search.setRequestStates(Arrays.asList(requestState));
			String[] requestStateNames = getRequestStateNames(requestState);
			StringBuilder sb = getListElement(requestStateNames);
			result.put(REQUEST_STATE, sb.toString());
		}else
			search.setRequestStates(null);
		if(region != null && region.length > 0){
			search.setRegions(Arrays.asList(region));
			String[] regionNames = getRegionNames(region);
			StringBuilder sb = getListElement(regionNames);
			result.put(REGION_REGION, sb.toString());
		}else
			search.setRegions(null);
		if(businessSegments != null && businessSegments.length > 0){
			search.setBusinessSegments(Arrays.asList(businessSegments));
			result.put(BUSINESS_SEGMENT, getListElement(businessSegments).toString());
		}else
			search.setBusinessSegments(null);
		
		if(ownerBusinessSegments != null){
			search.setOwnerBusinessSegments(Arrays.asList(ownerBusinessSegments));
			result.put(OWNER_BUSINESS_SEGMENT, getListElement(ownerBusinessSegments).toString());
		}else
			search.setOwnerBusinessSegments(null);
		
		if(StringUtils.isEmpty(search.getOriginalCurrency())){
			search.setOriginalCurrency(null);
		}else{
			result.put(ORIGINAL_CURRENCY, Utils.getDealCurrencyName(search.getOriginalCurrency().toString(), request));
			search.setOriginalCurrency("'"+search.getOriginalCurrency()+"'");
		}
		if(search.getAmountFrom() != null){
			result.put(ORIGINAL_AMOUNT_FROM, search.getAmountFrom().toString());
		}
		if(search.getAmountTo() != null){
			result.put(ORIGINAL_AMOUNT_TO, search.getAmountTo().toString());
		}
		if(search.getUsdEquivalentFrom() != null){
			result.put(USD_EQUIVALENT_AMOUNT_FROM, search.getUsdEquivalentFrom().toString());
		}
		if(search.getUsdEquivalentTo() != null){
			result.put(USD_EQUIVALENT_AMOUNT_TO, search.getUsdEquivalentTo().toString());
		}
		if(StringUtils.isEmpty(search.getFirstName())){
			search.setFirstName(null);
		}else{
			search.setFirstName(search.getFirstName().trim());
			result.put(FIRST_NAME, search.getFirstName().toString());
		}
		if(StringUtils.isEmpty(search.getLastName())){
			search.setLastName(null);
		}else{
			search.setLastName(search.getLastName().trim());
			result.put(LAST_NAME, search.getLastName().toString());
		}
		if(StringUtils.isEmpty(search.getSsoId())){
			search.setSsoId(null);
		}else{
			result.put(SSO_ID, search.getSsoId().toString());
		}
		if(StringUtils.isEmpty(search.getPriority())){
			search.setPriority(null);
		}else{
			String priority = getPriorityNames(search);
			result.put(PRIORITY, priority);
		}
		if(StringUtils.isEmpty(search.getDealId())){
			search.setDealId(null);
		}else{
			result.put(DEAL_ID, search.getDealId().toString());
		}
		if(StringUtils.isEmpty(search.getDealName())){
			search.setDealName(null);
		}else{
			result.put(DEAL_NAME, search.getDealName().toString());
		}
		if(StringUtils.isEmpty(search.getDealWithDerivatives())){
			search.setDealWithDerivatives(null);
		}else{
			String dealWithDerivatives = null;
			if(search.getDealWithDerivatives().equals(ONE)){
				dealWithDerivatives = YES_CAP;
			}else if(search.getDealWithDerivatives().equals(ICFPConstants.ZERO)){
				dealWithDerivatives = NO_CAP;
			}
			result.put(DEAL_WITH_DERIVATIVES, dealWithDerivatives);
		}
		if(StringUtils.isEmpty(search.getValueDtFrom())){
			search.setValueDtFrom(null);
		}else{
			search.setValueDtFrom(search.getValueDtFrom().toString().replaceAll("/", "-"));
			result.put(VALUE_FROM_DATE, search.getValueDtFrom().toString());
		}
		if(StringUtils.isEmpty(search.getValueDtTo())){
			search.setValueDtTo(null);
		}else{
			search.setValueDtTo(search.getValueDtTo().toString().replaceAll("/", "-"));
			result.put(VALUE_TO_DATE, search.getValueDtTo().toString());
		}
		if(StringUtils.isEmpty(search.getRequestDtFrom())){
			search.setRequestDtFrom(null);
		}else{
			search.setRequestDtFrom(search.getRequestDtFrom().toString().replaceAll("/", "-"));
			result.put(REQUEST_FROM_DATE, search.getRequestDtFrom().toString());
		}
		if(StringUtils.isEmpty(search.getRequestDtTo())){
			search.setRequestDtTo(null);
		}else{
			search.setRequestDtTo(search.getRequestDtTo().toString().replaceAll("/", "-"));
			result.put(REQUEST_TO_DATE, search.getRequestDtTo().toString());
		}
		if(StringUtils.isEmpty(search.getCloseDtFrom())){
			search.setCloseDtFrom(null);
		}else{
			search.setCloseDtFrom(search.getCloseDtFrom().toString().replaceAll("/", "-"));
			result.put(CLOSE_FROM_DATE, search.getCloseDtFrom().toString());
		}
		if(StringUtils.isEmpty(search.getCloseDtTo())){
			search.setCloseDtTo(null);
		}else{
			search.setCloseDtTo(search.getCloseDtTo().toString().replaceAll("/", "-"));
			result.put(CLOSE_TO_DATE, search.getCloseDtTo().toString());
		}
		if(dealCategory != null && dealCategory.length > 0){
			search.setDealCategories(Arrays.asList(dealCategory));
			String[] dealCategoryNames = getDealCategoryNames(dealCategory, request);
			StringBuilder sb = getListElement(dealCategoryNames);
			result.put(DEAL_CATEGORY, sb.toString());
		}
		else
			search.setDealCategories(null);
		
		if(cashPoolDetailsBankName != null && cashPoolDetailsBankName.length > 0){
			search.setCashPoolDetailsBankNames(Arrays.asList(cashPoolDetailsBankName));
			StringBuilder sb = getListElement(cashPoolDetailsBankName);
			result.put(CASH_POOL_DETAILS_BANK_NAMES, sb.toString());
		}
		else
			search.setCashPoolDetailsBankNames(null);
		
		if(cashPoolDetailsCountry != null && cashPoolDetailsCountry.length > 0){
			search.setCashPoolDetailsCountries(Arrays.asList(cashPoolDetailsCountry));
			String[] cashPoolDetailsCountryNames = getCashPoolDetailsCountryNames(cashPoolDetailsCountry, request);
			StringBuilder sb = getListElement(cashPoolDetailsCountryNames);
			result.put(CASH_POOL_DETAILS_COUNTRIES, sb.toString());
		}
		else
			search.setCashPoolDetailsCountries(null);
		
		if(cashPoolDetailsRegion != null && cashPoolDetailsRegion.length > 0){
			search.setCashPoolDetailsRegions(Arrays.asList(cashPoolDetailsRegion));
			String[] cashPoolDetailsRegionNames = getCashPoolDetailsRegionNames(cashPoolDetailsRegion, request);
			StringBuilder sb = getListElement(cashPoolDetailsRegionNames);
			result.put(CASH_POOL_DETAILS_REGION, sb.toString());
		}
		else
			search.setCashPoolDetailsRegions(null);
		
		if(cashPoolDetailsCurrency != null && cashPoolDetailsCurrency.length > 0){
			search.setCashPoolDetailsCurrencies(Arrays.asList(cashPoolDetailsCurrency));
			String[] cashPoolDetailsCurrencyNames = getCashPoolDetailsCurrencyNames(cashPoolDetailsCurrency, request);
			StringBuilder sb = getListElement(cashPoolDetailsCurrencyNames);
			result.put(CASH_POOL_DETAILS_CURRENCIES, sb.toString());
		}
		else
			search.setCashPoolDetailsCurrencies(null);
		String[] lenderFundHO = (String[])lenderForm.get(FUND_HOLD_OPERATION_ID);
		String[] lenderCountry = (String[])lenderForm.get(COUNTRY);
		if(StringUtils.isEmpty(search.getLender().getLEName()) && StringUtils.isEmpty(search.getLender().getMEName()) 
				&& StringUtils.isEmpty(search.getLender().getCDRCd()) && (lenderFundHO==null || lenderFundHO.length == 0)
				&& StringUtils.isEmpty(search.getLender().getCapitalIndustrial()) && (lenderCountry==null || lenderCountry.length == 0)
				&& StringUtils.isEmpty(search.getLender().getPrincplEntityFlag()) && StringUtils.isEmpty(search.getLender().getRegulatedEntityFlag())){
			search.setLender(null);
		}else{
			syncLender(search.getLender(), lenderFundHO, lenderCountry, result, request);
		}
		String[] borrowerFundHO = (String[])borrowerForm.get(FUND_HOLD_OPERATION_ID);
		String[] borrowerCountry = (String[])borrowerForm.get(COUNTRY);
		if(StringUtils.isEmpty(search.getBorrower().getLEName()) && StringUtils.isEmpty(search.getBorrower().getMEName()) 
				&& StringUtils.isEmpty(search.getBorrower().getCDRCd()) && ( borrowerFundHO ==null || borrowerFundHO.length == 0) 
				&& StringUtils.isEmpty(search.getBorrower().getCapitalIndustrial()) && (borrowerCountry==null || borrowerCountry.length == 0)
				&& StringUtils.isEmpty(search.getBorrower().getPrincplEntityFlag()) && StringUtils.isEmpty(search.getBorrower().getRegulatedEntityFlag())){
			search.setBorrower(null);
		}else{
			syncBorrower(search.getBorrower(), borrowerFundHO, borrowerCountry, result, request);
		}
		String[] cashPoolParticipantFundHO = (String[])cashPoolParticipantForm.get(FUND_HOLD_OPERATION_ID);
		String[] cashPoolParticipantCountry = (String[])cashPoolParticipantForm.get(COUNTRY);
		if(StringUtils.isEmpty(search.getCashPoolParticipant().getLEName()) && StringUtils.isEmpty(search.getCashPoolParticipant().getMEName()) 
				&& StringUtils.isEmpty(search.getCashPoolParticipant().getCDRCd()) && ( cashPoolParticipantFundHO==null || cashPoolParticipantFundHO.length == 0)
				&& StringUtils.isEmpty(search.getCashPoolParticipant().getCapitalIndustrial()) && (cashPoolParticipantCountry==null || cashPoolParticipantCountry.length == 0)
				&& StringUtils.isEmpty(search.getCashPoolParticipant().getPrincplEntityFlag()) && StringUtils.isEmpty(search.getCashPoolParticipant().getRegulatedEntityFlag())){
			search.setCashPoolParticipant(null);
		}else{
			syncCashPoolParticipant(search.getCashPoolParticipant(), cashPoolParticipantFundHO, cashPoolParticipantCountry, result, request);
		}
		String[] cashPoolLeaderFundHO = (String[])cashPoolLeaderForm.get(FUND_HOLD_OPERATION_ID);
		String[] cashPoolLeaderCountry = (String[])cashPoolLeaderForm.get(COUNTRY);
		if(StringUtils.isEmpty(search.getCashPoolLeader().getLEName()) && StringUtils.isEmpty(search.getCashPoolLeader().getMEName()) 
				&& StringUtils.isEmpty(search.getCashPoolLeader().getCDRCd()) && (cashPoolLeaderFundHO==null || cashPoolLeaderFundHO.length == 0)
				&& StringUtils.isEmpty(search.getCashPoolLeader().getCapitalIndustrial()) && (cashPoolLeaderCountry==null ||  cashPoolLeaderCountry.length == 0)
				&& StringUtils.isEmpty(search.getCashPoolLeader().getPrincplEntityFlag()) && StringUtils.isEmpty(search.getCashPoolLeader().getRegulatedEntityFlag())){
			search.setCashPoolLeader(null);
		}else{
			syncCashPoolLeader(search.getCashPoolLeader(), cashPoolLeaderFundHO, cashPoolLeaderCountry, result, request);
		}
	}
	/**
	 * @param productType
	 * @return
	 */
	private static String[] removeBlankElements(String[] array) {
		if(ArrayUtils.isNotEmpty(array) ){
			List<String> result = new LinkedList<String>();
			for(String item : array){
		        if(org.apache.commons.lang.StringUtils.isNotBlank(item)){
		            result.add(item);
		        }
		    }
			return result.size() > 0 ? result.toArray(array) : null;
		}
		return array;
	}
	/**
	 * @param productType
	 * @return
	 */
	private static Integer[] removeBlankElements(Integer[] array) {
		if(ArrayUtils.isNotEmpty(array) ){
			List<Integer> result = new LinkedList<Integer>();
			for(Integer item : array){
		        if(item != 0){
		            result.add(item);
		        }
		    }
			return result.size() > 0 ? result.toArray(array) : null;
		}
		return array;
	}
	
	/**
	 * 
	 * @param lender
	 * @throws HWFStubException 
	 * @throws HWFServiceException 
	 * @throws NumberFormatException 
	 */
	public static void syncLender(Lender lender, String[] lenderFundHO, String[] lenderCountry, Map<String, String> result,
			 HttpServletRequest request) throws NumberFormatException, HWFServiceException, HWFStubException{
		if(StringUtils.isEmpty(lender.getCapitalIndustrial()))
			lender.setCapitalIndustrial(null);
		else{
			if(lender.getCapitalIndustrial().equals(ONE)){
				result.put(LENDER_CAPITAL_OR_INDUSTRIAL, CAPITAL);
			}else if(lender.getCapitalIndustrial().equals(TWO)){
				result.put(LENDER_CAPITAL_OR_INDUSTRIAL, INDUSTRIAL);
			}
		}
		if(StringUtils.isEmpty(lender.getCDRCd()))
			lender.setCDRCd(null);
		else
			result.put(LENDER_CDR, lender.getCDRCd());
		if(StringUtils.isEmpty(lender.getLEName()))
			lender.setLEName(null);
		else
			result.put(LENDER_LE_NAME, lender.getLEName());
		if(StringUtils.isEmpty(lender.getMEName()))
			lender.setMEName(null);
		else
			result.put(LENDER_ME_NAME, lender.getMEName());
		if(StringUtils.isEmpty(lender.getPrincplEntityFlag()))
			lender.setPrincplEntityFlag(null);
		else{
			if(lender.getPrincplEntityFlag().equals(ONE)){
				result.put(LENDER_PRINCIPAL_ENTITY_FLAG, YES_CAP);
			}else if(lender.getPrincplEntityFlag().equals(ICFPConstants.ZERO)){
				result.put(LENDER_PRINCIPAL_ENTITY_FLAG, NO_CAP);
			}
		}
		if(StringUtils.isEmpty(lender.getRegulatedEntityFlag()))
			lender.setRegulatedEntityFlag(null);
		else{
			if(lender.getRegulatedEntityFlag().equals(ONE)){
				result.put(LENDER_REGULATED_ENTITY_FLAG, YES_CAP);
			}else if(lender.getRegulatedEntityFlag().equals(ICFPConstants.ZERO)){
				result.put(LENDER_REGULATED_ENTITY_FLAG, NO_CAP);
			}
		}
		if(lenderFundHO != null && lenderFundHO.length > 0){
			lender.setFundHoldOperationIds(Arrays.asList(lenderFundHO));
			String[] lenderFundHOs = getFundHoldOperation(lenderFundHO, request);
			StringBuilder sb = getListElement(lenderFundHOs);
			result.put(LENDER_COMPANY, sb.toString());
		}
		if(lenderCountry != null && lenderCountry.length > 0){
			lender.setCountries(Arrays.asList(lenderCountry));
			String[] lenderCountryNames = getCashPoolDetailsCountryNames(lenderCountry, request);
			StringBuilder sb = getListElement(lenderCountryNames);
			result.put(LENDER_COUNTRY, sb.toString());
		}
	}
	/**
	 * 
	 * @param borrower
	 * @throws HWFStubException 
	 * @throws HWFServiceException 
	 * @throws NumberFormatException 
	 */
	public static void syncBorrower(Borrower borrower, String[] borrowerFundHO, String[] borrowerCountry, Map<String, String> result,
			HttpServletRequest request) throws NumberFormatException, HWFServiceException, HWFStubException{
		if(StringUtils.isEmpty(borrower.getCapitalIndustrial()))
			borrower.setCapitalIndustrial(null);
		else{
			if(borrower.getCapitalIndustrial().equals(ONE)){
				result.put(BORROWER_CAPITAL_OR_INDUSTRIAL, CAPITAL);
			}else if(borrower.getCapitalIndustrial().equals(TWO)){
				result.put(BORROWER_CAPITAL_OR_INDUSTRIAL, INDUSTRIAL);
			}
		}
		if(StringUtils.isEmpty(borrower.getCDRCd()))
			borrower.setCDRCd(null);
		else
			result.put(BORROWER_CDR, borrower.getCDRCd());
		if(StringUtils.isEmpty(borrower.getLEName()))
			borrower.setLEName(null);
		else
			result.put(BORROWER_LE_NAME, borrower.getLEName());
		if(StringUtils.isEmpty(borrower.getMEName()))
			borrower.setMEName(null);
		else
			result.put(BORROWER_ME_NAME, borrower.getMEName());
		if(StringUtils.isEmpty(borrower.getPrincplEntityFlag()))
			borrower.setPrincplEntityFlag(null);
		else{
			if(borrower.getPrincplEntityFlag().equals(ONE)){
				result.put(BORROWER_PRINCIPAL_ENTITY_FLAG, YES_CAP);
			}else if(borrower.getPrincplEntityFlag().equals(ICFPConstants.ZERO)){
				result.put(BORROWER_PRINCIPAL_ENTITY_FLAG, NO_CAP);
			}
		}
		if(StringUtils.isEmpty(borrower.getRegulatedEntityFlag()))
			borrower.setRegulatedEntityFlag(null);
		else{
			if(borrower.getRegulatedEntityFlag().equals(ONE)){
				result.put(BORROWER_REGULATED_ENTITY_FLAG, YES_CAP);
			}else if(borrower.getRegulatedEntityFlag().equals(ICFPConstants.ZERO)){
				result.put(BORROWER_REGULATED_ENTITY_FLAG, NO_CAP);
			}
		}
		if(borrowerFundHO != null && borrowerFundHO.length > 0){
			borrower.setFundHoldOperationIds(Arrays.asList(borrowerFundHO));
			String[] borrowerFundHOs = getFundHoldOperation(borrowerFundHO, request);
			StringBuilder sb = getListElement(borrowerFundHOs);
			result.put(BORROWER_COMPANY, sb.toString());
		}
		if(borrowerCountry != null && borrowerCountry.length > 0){
			borrower.setCountries(Arrays.asList(borrowerCountry));
			String[] borrowerCountryNames = getCashPoolDetailsCountryNames(borrowerCountry, request);
			StringBuilder sb = getListElement(borrowerCountryNames);
			result.put(BORROWER_COUNTRY, sb.toString());
		}
	}
	/**
	 * 
	 * @param cashPoolParticipant
	 * @throws HWFStubException 
	 * @throws HWFServiceException 
	 * @throws NumberFormatException 
	 */
	public static void syncCashPoolParticipant(CashPoolParticipant cashPoolParticipant, String[] cashPoolParticipantFundHO, 
			String[] cashPoolParticipantCountry, Map<String, String> result, HttpServletRequest request) throws NumberFormatException, HWFServiceException, HWFStubException{
		if(StringUtils.isEmpty(cashPoolParticipant.getCapitalIndustrial()))
			cashPoolParticipant.setCapitalIndustrial(null);
		else{
			if(cashPoolParticipant.getCapitalIndustrial().equals(ONE)){
				result.put(CASH_POOL_PARTICIPANT_CAPITAL_OR_INDUSTRIAL, CAPITAL);
			}else if(cashPoolParticipant.getCapitalIndustrial().equals(TWO)){
				result.put(CASH_POOL_PARTICIPANT_CAPITAL_OR_INDUSTRIAL, INDUSTRIAL);
			}
		}
		if(StringUtils.isEmpty(cashPoolParticipant.getCDRCd()))
			cashPoolParticipant.setCDRCd(null);
		else
			result.put(CASH_POOL_PARTICIPANT_CDR, cashPoolParticipant.getCDRCd());
		if(StringUtils.isEmpty(cashPoolParticipant.getLEName()))
			cashPoolParticipant.setLEName(null);
		else
			result.put(CASH_POOL_PARTICIPANT_LE_NAME, cashPoolParticipant.getLEName());
		if(StringUtils.isEmpty(cashPoolParticipant.getMEName()))
			cashPoolParticipant.setMEName(null);
		else
			result.put(CASH_POOL_PARTICIPANT_ME_NAME, cashPoolParticipant.getMEName());
		if(StringUtils.isEmpty(cashPoolParticipant.getPrincplEntityFlag()))
			cashPoolParticipant.setPrincplEntityFlag(null);
		else{
			if(cashPoolParticipant.getPrincplEntityFlag().equals(ONE)){
				result.put(CASH_POOL_PARTICIPANT_PRINCIPAL_ENTITY_FLAG, YES_CAP);
			}else if(cashPoolParticipant.getPrincplEntityFlag().equals(ICFPConstants.ZERO)){
				result.put(CASH_POOL_PARTICIPANT_PRINCIPAL_ENTITY_FLAG, NO_CAP);
			}
		}
		if(StringUtils.isEmpty(cashPoolParticipant.getRegulatedEntityFlag()))
			cashPoolParticipant.setRegulatedEntityFlag(null);
		else{
			if(cashPoolParticipant.getRegulatedEntityFlag().equals(ONE)){
				result.put(CASH_POOL_PARTICIPANT_REGULATED_ENTITY_FLAG, YES_CAP);
			}else if(cashPoolParticipant.getRegulatedEntityFlag().equals(ICFPConstants.ZERO)){
				result.put(CASH_POOL_PARTICIPANT_REGULATED_ENTITY_FLAG, NO_CAP);
			}
		}
		if(cashPoolParticipantFundHO != null && cashPoolParticipantFundHO.length > 0){
			cashPoolParticipant.setFundHoldOperationIds(Arrays.asList(cashPoolParticipantFundHO));
			String[] cashPoolParticipantFundHOs = getFundHoldOperation(cashPoolParticipantFundHO, request);
			StringBuilder sb = getListElement(cashPoolParticipantFundHOs);
			result.put(CASH_POOL_PARTICIPANT_COMPANY, sb.toString());
		}
		if(cashPoolParticipantCountry != null && cashPoolParticipantCountry.length > 0){
			cashPoolParticipant.setCountries(Arrays.asList(cashPoolParticipantCountry));
			String[] cashPoolParticipantCountryNames = getCashPoolDetailsCountryNames(cashPoolParticipantCountry, request);
			StringBuilder sb = getListElement(cashPoolParticipantCountryNames);
			result.put(CASH_POOL_PARTICIPANT_COUNTRY, sb.toString());
		}
	}
	/**
	 * 
	 * @param cashPoolLeader
	 * @throws HWFStubException 
	 * @throws HWFServiceException 
	 * @throws NumberFormatException 
	 */
	public static void syncCashPoolLeader(CashPoolLeader cashPoolLeader, String[] cashPoolLeaderFundHO, 
			String[] cashPoolLeaderCountry, Map<String, String> result, HttpServletRequest request) throws NumberFormatException, HWFServiceException, HWFStubException{
		if(StringUtils.isEmpty(cashPoolLeader.getCapitalIndustrial())){
			cashPoolLeader.setCapitalIndustrial(null);
		}else{
			if(cashPoolLeader.getCapitalIndustrial().equals(ONE)){
				result.put(CASH_POOL_LENDER_CAPITAL_OR_INDUSTRIAL, CAPITAL);
			}else if(cashPoolLeader.getCapitalIndustrial().equals(TWO)){
				result.put(CASH_POOL_LENDER_CAPITAL_OR_INDUSTRIAL, INDUSTRIAL);
			}
		}
		if(StringUtils.isEmpty(cashPoolLeader.getCDRCd())){
			cashPoolLeader.setCDRCd(null);
		}else{
			result.put(CASH_POOL_LEADER_CDR, cashPoolLeader.getCDRCd());
		}
		if(StringUtils.isEmpty(cashPoolLeader.getLEName())){
			cashPoolLeader.setLEName(null);
		}else{
			result.put(CASH_POOL_LEADER_LE_NAME, cashPoolLeader.getLEName());
		}
		if(StringUtils.isEmpty(cashPoolLeader.getMEName())){
			cashPoolLeader.setMEName(null);
		}else{
			result.put(CASH_POOL_LEADER_ME_NAME, cashPoolLeader.getMEName());
		}
		if(StringUtils.isEmpty(cashPoolLeader.getPrincplEntityFlag())){
			cashPoolLeader.setPrincplEntityFlag(null);
		}else{
			if(cashPoolLeader.getPrincplEntityFlag().equals(ONE)){
				result.put(CASH_POOL_LEADER_PRINCIPAL_ENTITY_FLAG, YES_CAP);
			}else if(cashPoolLeader.getPrincplEntityFlag().equals(ICFPConstants.ZERO)){
				result.put(CASH_POOL_LEADER_PRINCIPAL_ENTITY_FLAG, NO_CAP);
			}
		}
		if(StringUtils.isEmpty(cashPoolLeader.getRegulatedEntityFlag())){
			cashPoolLeader.setRegulatedEntityFlag(null);
		}else{
			if(cashPoolLeader.getRegulatedEntityFlag().equals(ONE)){
				result.put(CASH_POOL_LEADER_REGULATED_ENTITY_FLAG, YES_CAP);
			}else if(cashPoolLeader.getRegulatedEntityFlag().equals(ICFPConstants.ZERO)){
				result.put(CASH_POOL_LEADER_REGULATED_ENTITY_FLAG, NO_CAP);
			}
		}
		if(cashPoolLeaderFundHO != null && cashPoolLeaderFundHO.length > 0){
			cashPoolLeader.setFundHoldOperationIds(Arrays.asList(cashPoolLeaderFundHO));
			String[] cashPoolLeaderFundHOs = getFundHoldOperation(cashPoolLeaderFundHO, request);
			StringBuilder sb = getListElement(cashPoolLeaderFundHOs);
			result.put(CASH_POOL_LEADER_COMPANY, sb.toString());
		}
		if(cashPoolLeaderCountry != null && cashPoolLeaderCountry.length > 0){
			cashPoolLeader.setCountries(Arrays.asList(cashPoolLeaderCountry));
			String[] cashPoolLeaderCountryNames = getCashPoolDetailsCountryNames(cashPoolLeaderCountry, request);
			StringBuilder sb = getListElement(cashPoolLeaderCountryNames);
			result.put(CASH_POOL_LEADER_COUNTRY, sb.toString());
		}
	}
	/**
	 * 
	 * @param fundHoldOperation
	 * @param request
	 * @return
	 * @throws NumberFormatException
	 * @throws HWFServiceException
	 * @throws HWFStubException
	 */
	private static String[] getFundHoldOperation(String[] fundHoldOperation, HttpServletRequest request) throws NumberFormatException, HWFServiceException, HWFStubException{
		String[] fundHoldOperations = new String[fundHoldOperation.length];
		for (int i = 0; i < fundHoldOperations.length; i++) {
			fundHoldOperations[i] = Utils.getFundingCompanyName(Integer.parseInt(fundHoldOperation[i]), request);
		}
		return fundHoldOperations;
	}
	/**
	 * 
	 * @param cashPoolDetailsRegion
	 * @param request
	 * @return
	 * @throws HWFServiceException
	 * @throws HWFStubException
	 */
	private static String[] getCashPoolDetailsRegionNames(
			String[] cashPoolDetailsRegion, HttpServletRequest request) throws HWFServiceException, HWFStubException {
		String[] cashPoolDetailsRegionNames = new String[cashPoolDetailsRegion.length];
		for (int i = 0; i < cashPoolDetailsRegion.length; i++) {
			cashPoolDetailsRegionNames[i] = Utils.getDealRegionName(cashPoolDetailsRegion[i], request);
		}
		return cashPoolDetailsRegionNames;
	}
	/**
	 * 
	 * @param cashPoolDetailsCurrency
	 * @param request
	 * @return
	 * @throws HWFServiceException
	 * @throws HWFStubException
	 */
	private static String[] getCashPoolDetailsCurrencyNames(
			String[] cashPoolDetailsCurrency, HttpServletRequest request) throws HWFServiceException, HWFStubException {
		String[] cashPoolDetailsCurrencyNames = new String[cashPoolDetailsCurrency.length];
		for (int i = 0; i < cashPoolDetailsCurrency.length; i++) {
			cashPoolDetailsCurrencyNames[i] = Utils.getDealCurrencyName(cashPoolDetailsCurrency[i], request);
		}
		return cashPoolDetailsCurrencyNames;
	}
	/**
	 * 
	 * @param cashPoolDetailsCountry
	 * @param request
	 * @return
	 * @throws HWFServiceException
	 * @throws HWFStubException
	 */
	private static String[] getCashPoolDetailsCountryNames(
			String[] cashPoolDetailsCountry, HttpServletRequest request) throws HWFServiceException, HWFStubException {
		String[] cashPoolDetailsCountryNames = new String[cashPoolDetailsCountry.length];
		for (int i = 0; i < cashPoolDetailsCountry.length; i++) {
			cashPoolDetailsCountryNames[i] = Utils.getDealCountryName(cashPoolDetailsCountry[i], request);
		}
		return cashPoolDetailsCountryNames;
	}
	/**
	 * 
	 * @param dealCategory
	 * @param request
	 * @return
	 * @throws HWFServiceException
	 * @throws HWFStubException
	 */
	private static String[] getDealCategoryNames(Integer[] dealCategory, HttpServletRequest request) throws HWFServiceException, HWFStubException {
		String[] dealCategoryNames = new String[dealCategory.length];
		for (int i = 0; i < dealCategory.length; i++) {
			dealCategoryNames[i] = Utils.getDealCategoryName(dealCategory[i], request);
		}
		return dealCategoryNames;
	}
	/**
	 * @param search
	 */
	private static String getPriorityNames(Search search) {
		String priority = null;
		if(search.getPriority().equals(ONE)){
			priority = HIGH;
		}else if(search.getPriority().equals(TWO)){
			priority = MEDIUM;
		}else if(search.getPriority().equals(THREE)){
			priority = LOW;
		}
		return priority;
	}
	/**
	 * 
	 * @param region
	 * @return
	 */
	private static String[] getRegionNames(String[] region) {
		String[] regionNames = new String[region.length];
		for (int i = 0; i < region.length; i++) {
			if(ONE.equals(region[i])){
				regionNames[i] = AMERICAS;
			}else if(TWO.equals(region[i])){
				regionNames[i] = EUROPE;
			}else if(THREE.equals(region[i])){
				regionNames[i] = ASIA;
			}
		}
		return regionNames;
	}
	/**
	 * 
	 * @param requestState
	 * @return
	 */
	private static String[] getRequestStateNames(String[] requestState) {
		String[] requestStateNames = new String[requestState.length];
		for (int i = 0; i < requestState.length; i++) {
			if(ONE.equals(requestState[i])){
				requestStateNames[i] = INPROGRESS;
			}else if(TWO.equals(requestState[i])){
				requestStateNames[i] = DRAFT;
			}else if(THREE.equals(requestState[i])){
				requestStateNames[i] = CLOSE;
			}else if(FOUR.equals(requestState[i])){
				requestStateNames[i] = WITHDRAWN;
			}
		}
		return requestStateNames;
	}
	/**
	 * @param productType
	 */
	private static String[] getProductTypeNames(String[] productType) {
		String[] productTypeNames = new String[productType.length];
		for (int i = 0; i < productType.length; i++) {
			if(productType[i].equals(ONE)){
				productTypeNames[i] = RCA;
			}else if(productType[i].equals(TWO)){
				productTypeNames[i] = EQUITY;
			}else if(productType[i].equals(THREE)){
				productTypeNames[i] = CASH_POOL;
			}else if(productType[i].equals(FOUR)){
				productTypeNames[i] = OTHER_SMALL;
			}else if(productType[i].equals(FIVE)){
				productTypeNames[i] = TERM_LOAN;
			}else if(productType[i].equals(SIX)){
				productTypeNames[i] = BOND;
			}
		}
		return productTypeNames;
	}
	/**
	 * @param eventType
	 */
	private static String[] getEventTypeNames(String[] eventType) {
		String[] eventTypeNames = new String[eventType.length];
		for (int i = 0; i < eventType.length; i++) {
			if(ONE.equals(eventType[i])){
				eventTypeNames[i] = CASH_POOL_TERMINATION;
			}else if(TWO.equals(eventType[i])){
				eventTypeNames[i] = CASH_POOL_OTHER;
			}else if(THREE.equals(eventType[i])){
				eventTypeNames[i] = ASSIGNMENT;
			}else if(FOUR.equals(eventType[i])){
				eventTypeNames[i] = AMENDMENT_AGREEMENT_EXTENSION;
			}else if(FIVE.equals(eventType[i])){
				eventTypeNames[i] = AMENDMENT_FACILITY_DECREASE_INCREASE;
			}else if(SIX.equals(eventType[i])){
				eventTypeNames[i] = AMENDMENT_GENERAL_AMENDMENT;
			}else if(SEVEN.equals(eventType[i])){
				eventTypeNames[i] = PREPAYMENT;
			}else if(EIGHT.equals(eventType[i])){
				eventTypeNames[i] = DRAWDOWN;
			}else if(NINE.equals(eventType[i])){
				eventTypeNames[i] = EARLY_TERMINATION;
			}else if(TEN.equals(eventType[i])){
				eventTypeNames[i] = CORRECTIONS;
			}else if(ELEVEN.equals(eventType[i])){
				eventTypeNames[i] = DEBT_EQUITY_OTHER;
			}else if(TWELVE.equals(eventType[i])){
				eventTypeNames[i] = DIVIDENDS;
			}
		}
		return eventTypeNames;
	}
	/**
	 * @param elements
	 * @return StringBuilder
	 */
	private static StringBuilder getListElement(String[] elements) {
		StringBuilder sb=new StringBuilder();
		int i=1;
		for (String string : elements) {
			sb.append(string);
			if(i<elements.length){
				sb.append(", ");
			}
			i++;
		}
		return sb;
	}
}
