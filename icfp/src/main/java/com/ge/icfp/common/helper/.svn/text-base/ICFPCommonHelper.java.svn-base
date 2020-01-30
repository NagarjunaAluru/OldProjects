/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: ICFPCommonHelper.java
 * Purpose: This file will have all helper methods to get deal,leg, validate deal,leg, exceptions and derivatives.
 * 
 */
package com.ge.icfp.common.helper;

import static com.ge.icfp.common.constants.ICFPConstants.CAPITAL;
import static com.ge.icfp.common.constants.ICFPConstants.COULD_NOT_FETCH_PROPERTY;
import static com.ge.icfp.common.constants.ICFPConstants.CPA;
import static com.ge.icfp.common.constants.ICFPConstants.DEAL;
import static com.ge.icfp.common.constants.ICFPConstants.DELETE;
import static com.ge.icfp.common.constants.ICFPConstants.EN;
import static com.ge.icfp.common.constants.ICFPConstants.EQUITY;
import static com.ge.icfp.common.constants.ICFPConstants.FINALRATING;
import static com.ge.icfp.common.constants.ICFPConstants.FOURBLOCKER;
import static com.ge.icfp.common.constants.ICFPConstants.FOURBLOCKERFORM;
import static com.ge.icfp.common.constants.ICFPConstants.GETTREQID;
import static com.ge.icfp.common.constants.ICFPConstants.ICFP_300;
import static com.ge.icfp.common.constants.ICFPConstants.IMMEDIATE_DRAWDOWN;
import static com.ge.icfp.common.constants.ICFPConstants.INSERT;
import static com.ge.icfp.common.constants.ICFPConstants.LEGERRORS;
import static com.ge.icfp.common.constants.ICFPConstants.LEGS_ERRMSG;
import static com.ge.icfp.common.constants.ICFPConstants.MDM;
import static com.ge.icfp.common.constants.ICFPConstants.MODELSCORE;
import static com.ge.icfp.common.constants.ICFPConstants.NULL;
import static com.ge.icfp.common.constants.ICFPConstants.ON_BEAN;
import static com.ge.icfp.common.constants.ICFPConstants.OTHER;
import static com.ge.icfp.common.constants.ICFPConstants.PRODUCTTYPE;
import static com.ge.icfp.common.constants.ICFPConstants.QUALITATIVEFACTORS;
import static com.ge.icfp.common.constants.ICFPConstants.QUALITATIVEFACTORSFORM;
import static com.ge.icfp.common.constants.ICFPConstants.RANGE;
import static com.ge.icfp.common.constants.ICFPConstants.RCA;
import static com.ge.icfp.common.constants.ICFPConstants.SNPRATING;
import static com.ge.icfp.common.constants.ICFPConstants.TCLASSIFICATIONLEVEL;
import static com.ge.icfp.common.constants.ICFPConstants.TCLASSIFICATIONLEVELFORM;
import static com.ge.icfp.common.constants.ICFPConstants.TPRIORITYTIMINGS;
import static com.ge.icfp.common.constants.ICFPConstants.TPRIORITYTIMINGSFORM;
import static com.ge.icfp.common.constants.ICFPConstants.TSUMMARYOWNER;
import static com.ge.icfp.common.constants.ICFPConstants.TSUMMARYOWNERFORM;
import static com.ge.icfp.common.constants.ICFPConstants.UPDATESTATUSFORM;
import static com.ge.icfp.common.constants.ICFPConstants.US;
import static com.ge.icfp.common.constants.ICFPConstants.VAULTIDDETAILS;
import jarjar.orgapachecommonslang.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.validator.Validator;
import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.validator.Resources;

import com.ge.icfp.action.ICFPException;
import com.ge.icfp.common.attachments.ICFPAttachmentManager;
import com.ge.icfp.common.constants.ICFPConstants;
import com.ge.icfp.common.vo.NameValueVO;
import com.ge.icfp.model.Amendment;
import com.ge.icfp.model.CPALegRequest;
import com.ge.icfp.model.CPASummary;
import com.ge.icfp.model.DayTwoOperations;
import com.ge.icfp.model.DealRequest;
import com.ge.icfp.model.DerivativesRequest;
import com.ge.icfp.model.Entity;
import com.ge.icfp.model.EquityLegRequest;
import com.ge.icfp.model.ExceptionRequestForm;
import com.ge.icfp.model.LegSummary;
import com.ge.icfp.model.Legs;
import com.ge.icfp.model.MDM;
import com.ge.icfp.model.ShareInfo;
import com.ge.icfp.model.MDM.CashPool;
import com.ge.icfp.model.MDM.VaultIDDetails;
import com.ge.icfp.model.MgmtEntity;
import com.ge.icfp.model.MsgHeader;
import com.ge.icfp.model.NameValue;
import com.ge.icfp.model.OtherLegRequest;
import com.ge.icfp.model.RCALegRequest;
import com.ge.icfp.model.UpdateStatus;
import com.ge.icfp.util.DateUtil;
import com.ge.icfp.util.LegComparator;
import com.ge.icfp.util.MasterDataFactory;
import com.ge.icfp.util.StaticDataFactory;
import com.hydus.wff.common.bw.ServiceClient;
import com.hydus.wff.core.context.UserContext;
import com.hydus.wff.core.exception.HWFServiceException;
import com.hydus.wff.core.exception.HWFStubException;
import com.hydus.wff.core.session.SessionManager;

import formdef.plugin.FormMapping;
import formdef.plugin.util.FormUtils;
/**
 * Common Helper used in deal and leg screens
 * @author chaitanya
 *
 */
public class ICFPCommonHelper {
	
	private static final String COMMERCIAL_REAL_ESTATE = "Commercial Real Estate";
	private static final String COMM_REAL_ESTATE = "CommRealEstate";
	private static final String RESTRUCTURE_OP = "Restructure Op.";
	private static final String RETAIL = "Retail";
	private static final String RESTRUCTURE = "Restructure";
	private static final String RETAIL_FINANCE = "Retail Finance";
	private static final String CAPITAL_HQ_OTHER = "Capital HQ/Other";
	private static final String CLL_AMERICAS = "CLL Americas";
	private static final String CLL = "CLL";
	private static final String ERRORMSG = " were not validated. Please return to the leg and click on Save and return to Deal or Save and go to next leg  to validate";
	private static final String DEAL_REQUEST_ID = "dealRequestID";
	private static final String TAB_NUMBER = "tabNumber";
	private static final String DERIVATIVE_REQUEST_MODEL = "derivativeRequestModel";
	private static final String EXCEPTION_REQUEST_FORM_MODEL = "exceptionRequestFormModel";
	private static final String INDEXEDLEG_INVALID = "indexedleg.invalid";
	private static final String INDEXEDLEG_DERIVATIVES_INVALID = "indexedleg.derivatives.invalid";
	private static final String LEG_DERIVATIVES_INVALID = "leg.derivatives.invalid";
	private static final String LEGS = "legs";
	private static final String LEG_INDEX_EXCEPTIONS_INVALID = "leg.index.exceptions.invalid";
	private static final String EXCEPTIONS2 = "exceptions";
	private static final String LEG_EXCEPTIONS_INVALID = "leg.exceptions.invalid";
	private static final String OTHER_LEG_REQUEST_MODEL = "OtherLegRequestModel";
	private static final String EQUITY_LEG_REQUEST_MODEL = "EquityLegRequestModel";
	private static final String CPA_LEG_REQUEST_MODEL = "CPALegRequestModel";
	private static final String RCA_LEG_REQUEST_MODEL = "RCALegRequestModel";
	private static final String DEAL_REQUEST_MODEL = "dealRequestModel";
	private static final String PROJECT_SUMMARY = "projectSummary";
	private static final String PROJECT_SUMMARY_FORM = "projectSummaryForm";
	private static final String GETDEAL = "GETDEAL";
	private static final String DATE_FORMAT = "MM/dd/yyyy";
	private static final String CTX_KEY_ATMT_MNGR = "com.ge.icfp.AttachmentManager";
	static final Logger LOGGER = Logger.getLogger(ICFPCommonHelper.class);
	private static final LegComparator LEG_COMPARATOR = new LegComparator();
	/**
	 * 
	 * Returns deal object for the given deal ID
	 * @param id
	 * @param serviceClient
	 * @return
	 * @throws HWFServiceException
	 * @throws HWFStubException 
	 */
	public static DealRequest getDeal(Integer id, ServiceClient serviceClient)
			throws HWFServiceException, HWFStubException {
		DealRequest request = new DealRequest();
		request.setDealSeqId(id);

		MsgHeader msgHeader = new MsgHeader();
		msgHeader.setOpcode(ICFPCommonHelper.GETDEAL);
		msgHeader.setAuditCreator(UserContext.getCurrentUserContext().getId());
		msgHeader.setAuditModifier(UserContext.getCurrentUserContext().getId());
		request.setMsgHeader(msgHeader);

		request = serviceClient.invokeService(DEAL, request,DealRequest.class);
		if(request.getLegs() != null && !request.getLegs().getAllLegs().isEmpty()) {
			Collections.sort(request.getLegs().getAllLegs(), LEG_COMPARATOR);
		}
		return request; 
	}

	/**
	 * Prepare DynaAction form which is internaly referred
	 * @param updateStatusForm
	 */
	public static void prepareUpdateStatusForm(DynaActionForm updateStatusForm, ActionMapping mapping, HttpServletRequest request, Action action) {
		updateStatusForm.reset(mapping, request);
		
		DynaActionForm fourblockerForm = (DynaActionForm) FormUtils.getInstance().createActionForm(FOURBLOCKERFORM, action, mapping, request);
		updateStatusForm.set(FOURBLOCKER, fourblockerForm);
		
		DynaActionForm tSummaryOwnerForm = (DynaActionForm) FormUtils.getInstance().createActionForm(TSUMMARYOWNERFORM, action, mapping, request);
		fourblockerForm.set(TSUMMARYOWNER, tSummaryOwnerForm);
		
		DynaActionForm tPriorityTimingsForm = (DynaActionForm) FormUtils.getInstance().createActionForm(TPRIORITYTIMINGSFORM, action, mapping, request);
		fourblockerForm.set(TPRIORITYTIMINGS, tPriorityTimingsForm);
		
		DynaActionForm tClassificationLevelForm = (DynaActionForm) FormUtils.getInstance().createActionForm(TCLASSIFICATIONLEVELFORM, action, mapping, request);
		fourblockerForm.set(TCLASSIFICATIONLEVEL, tClassificationLevelForm);
		
		DynaActionForm qualitativeFactorsForm = (DynaActionForm) FormUtils.getInstance().createActionForm(QUALITATIVEFACTORSFORM, action, mapping, request);
		fourblockerForm.set(QUALITATIVEFACTORS, qualitativeFactorsForm);
		
		DynaActionForm projectSummaryForm = (DynaActionForm) FormUtils.getInstance().createActionForm(ICFPCommonHelper.PROJECT_SUMMARY_FORM, action, mapping, request);
		fourblockerForm.set(ICFPCommonHelper.PROJECT_SUMMARY, projectSummaryForm);
	}
	
	/**
	 * Sync the updateStatus form with model Object
	 * @param updateStatus
	 * @param updateStatusForm
	 * @param request
	 * @param context
	 * @param mapping
	 * @param action
	 */
	public static void syncUpdateStatusWithForm(UpdateStatus updateStatus,
			DynaActionForm updateStatusForm, HttpServletRequest request,
			ActionMapping mapping, Action action) {
		FormMapping formMapping = FormUtils.getInstance().findFormDefinition(
				UPDATESTATUSFORM, action.getServlet().getServletContext(),
				mapping.getModuleConfig());
		FormUtils.getInstance().populateBeanFromForm(formMapping, updateStatus,
				updateStatusForm, action, mapping, request);
		ICFPLegHelper.syncTClassificationLevel(updateStatus, updateStatusForm,
				request, action.getServlet().getServletContext(), mapping,
				action);
		ICFPLegHelper.syncTPriorityTimings(updateStatus, updateStatusForm,
				request, action.getServlet().getServletContext(), mapping,
				action);
		ICFPLegHelper.syncTSummaryOwner(updateStatus, updateStatusForm,
				request, action.getServlet().getServletContext(), mapping,
				action);
	}
	
	/**
	 * Check if the Deal has atleast one leg
	 * validateDealRequest
	 * @param dealRequest
	 * @param request
	 * @param servletContext
	 * @param page
	 * @return
	 * @throws ValidatorException 
	 */
	public static ActionErrors validateDealRequest(DealRequest dealRequest,
			HttpServletRequest request, ServletContext servletContext, int page) throws ValidatorException {
		ActionErrors errors = validateModel(ICFPCommonHelper.DEAL_REQUEST_MODEL, page,dealRequest, request, servletContext);
		if (dealRequest.getLegs() != null
				&& !dealRequest.getLegs().getAllLegs().isEmpty()) {
			int count = 1;
			for (Object eachLeg : dealRequest.getLegs().getAllLegs()) {
				validateLeg(eachLeg, request, servletContext, page, count,errors);
				count++;
			}
		}
		return errors;
	}
	
	/**
	 * Check if the given leg has Model information filled in
	 * @param leg
	 * @param request
	 * @param servletContext
	 * @param page
	 * @param legIndex
	 * @param dealLevelErrors
	 * @return
	 * @throws ValidatorException 
	 */
	public static ActionErrors validateLeg(Object leg,
			HttpServletRequest request, ServletContext servletContext,
			int page, Integer legIndex, ActionErrors dealLevelErrors) throws ValidatorException {
		ActionErrors errors = null;
		List<ExceptionRequestForm> exceptions = null;
		List<DerivativesRequest> derivatives = null;
		if(leg instanceof RCALegRequest) {
			exceptions = ((RCALegRequest) leg).getLegSummary().getExceptionRequestForms();
			derivatives = ((RCALegRequest) leg).getLegSummary().getDerivativesRequests();
			errors = validateModel(ICFPCommonHelper.RCA_LEG_REQUEST_MODEL, page, leg, request, servletContext);
		} else if(leg instanceof CPALegRequest) {
			exceptions = new ArrayList<ExceptionRequestForm>();
			exceptions = ((CPALegRequest) leg).getCPASummary().getExceptionRequestForms();
			errors = validateModel(ICFPCommonHelper.CPA_LEG_REQUEST_MODEL, page, leg, request, servletContext);
		} else if(leg instanceof EquityLegRequest) {
			exceptions = ((EquityLegRequest) leg).getLegSummary().getExceptionRequestForms();
			derivatives = ((EquityLegRequest) leg).getLegSummary().getDerivativesRequests();
			errors = validateModel(ICFPCommonHelper.EQUITY_LEG_REQUEST_MODEL, page, leg, request, servletContext);
		} else if(leg instanceof OtherLegRequest) {
			exceptions = ((OtherLegRequest) leg).getLegSummary().getExceptionRequestForms();
			errors = validateModel(ICFPCommonHelper.OTHER_LEG_REQUEST_MODEL, page, leg, request, servletContext);
		}
		if(errors == null) {
			errors = new ActionErrors();
		}
		
		if(exceptions != null && !exceptions.isEmpty()) {
			int count = 1;
			for(ExceptionRequestForm exception : exceptions) {
				ActionErrors exceptionErrors = validateExceptionRequestForm(exception, request, servletContext, page);
				if(!exceptionErrors.isEmpty()) {
					ActionMessage error = null;
					if(legIndex == null) {
						error = new ActionMessage(ICFPCommonHelper.LEG_EXCEPTIONS_INVALID, count);
						errors.add(ICFPCommonHelper.EXCEPTIONS2, error);
					} else {
						error = new ActionMessage(ICFPCommonHelper.LEG_INDEX_EXCEPTIONS_INVALID, legIndex, count);
						dealLevelErrors.add(ICFPCommonHelper.LEGS, error);
					}
				}
				count++;
			}
		}
		
		if(derivatives != null && !derivatives.isEmpty()) {
			int count = 1;
			for(DerivativesRequest derivative : derivatives) {
				ActionErrors derivativeErrors = validateDerivativeRequest(derivative, request, servletContext, page);
				if(!derivativeErrors.isEmpty()) {
					ActionMessage error = null;
					if(legIndex == null) {
						error = new ActionMessage(ICFPCommonHelper.LEG_DERIVATIVES_INVALID, count);
						errors.add("derivatives", error);
					} else {
						error = new ActionMessage(ICFPCommonHelper.INDEXEDLEG_DERIVATIVES_INVALID, legIndex, count);
						dealLevelErrors.add(ICFPCommonHelper.LEGS, error);
					}
				}
			}
		}
		
		if(!errors.isEmpty() && legIndex != null) {
			dealLevelErrors.add(ICFPCommonHelper.LEGS, new ActionMessage(ICFPCommonHelper.INDEXEDLEG_INVALID, legIndex));
		}
		 
		return errors;
	}
	
	/**
	 * Validation for Exception
	 * @param exceptionRequestForm
	 * @param request
	 * @param servletContext
	 * @param page
	 * @return
	 * @throws ValidatorException 
	 */
	public static ActionErrors validateExceptionRequestForm(
			ExceptionRequestForm exceptionRequestForm,
			HttpServletRequest request, ServletContext servletContext, int page) throws ValidatorException {
		return validateModel(ICFPCommonHelper.EXCEPTION_REQUEST_FORM_MODEL, page, exceptionRequestForm, request, servletContext);
	}
	
	/**
	 * validateDerivativeRequest
	 * @param derivativeRequest
	 * @param request
	 * @param servletContext
	 * @param page
	 * @return
	 * @throws ValidatorException 
	 */
	public static ActionErrors validateDerivativeRequest(
			DerivativesRequest derivativeRequest, HttpServletRequest request,
			ServletContext servletContext, int page) throws ValidatorException {
		return validateModel(ICFPCommonHelper.DERIVATIVE_REQUEST_MODEL, page, derivativeRequest,	request, servletContext);
	}
	
	/**
	 * validateModel
	 * @param validationFormName
	 * @param page
	 * @param model
	 * @param request
	 * @param servletContext
	 * @return
	 * @throws ValidatorException 
	 */
	public static ActionErrors validateModel(String validationFormName,
			int page, Object model, HttpServletRequest request,
			ServletContext servletContext) throws ValidatorException {
		ActionErrors errors = new ActionErrors();
		Validator validator = Resources.initValidator(validationFormName,
				model, servletContext, request, errors, page);
			validator.validate();
		return errors;
	}
	
	/**
	 * Method to get the Amount with Comma Seperated
	 * @param currency
	 * @return
	 */
	public static String formatCurrency(String currency){
		if(currency != null && !currency.equals("") && !currency.equals(NULL)){
			Double cur = 0.0;
			try{
			
				cur = Double.parseDouble(currency);
			
			}catch(Exception e)
			{
				cur = new Double(0.0);
			}
			NumberFormat currencyFormatter;
			currencyFormatter = NumberFormat.getCurrencyInstance(new Locale(EN, US));
			currency = currencyFormatter.format(cur);
			currency = currency.substring(1, currency.length());
		}
		return currency;
			
	}
	
	/**
	 * Method to get the Negative Amount with Comma Seperated
	 * @param currency
	 * @return
	 */
	public static String formatNegativeCurrency(String currency){
		if(currency != null && !currency.equals("") && !currency.equals(NULL)){
			Double cur = 0.0;
			currency = currency.replace(",", "");
			try{
			
				cur = Double.parseDouble(currency);
			
			}catch(Exception e)
			{
				cur = new Double(0.0);
			}
			NumberFormat currencyFormatter;
			currencyFormatter = new DecimalFormat("-#,###,###.##");
			currency = currencyFormatter.format(cur);
			currency = currency.substring(1, currency.length());
		}
		return currency;
			
	}
	/**
	 * This method convert the String to integer value
	 * @param currency
	 * @return
	 */
	public static int convetCurrencyFormatToInt(String currency){
		
		int currencyVal=0;
		
		if(currency != null && !currency.equals("") && !currency.equals(NULL)){
			currency = currency.replace(",", "");
			Double curDob = Double.parseDouble(currency);
			currencyVal = curDob.intValue();
		}
		
		return currencyVal;
	}
	
	
	
	/**
	 * 
	 * @param currency
	 * @return formatted currency
	 */
	public static String formatAmount(String amount){
		if(amount != null && !amount.equals("") && !amount.equals(NULL)){
			Double cur = Double.parseDouble(amount);
			NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale(EN, US));
			amount = currencyFormatter.format(cur);
			if(amount.endsWith(".0") || amount.endsWith(".00")){
				amount = amount.substring(1, amount.indexOf("."));
			}else{
				amount = amount.substring(1, amount.length());
			}
			
		}
		return amount;
			
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
			String errMsg = new StringBuilder().append(COULD_NOT_FETCH_PROPERTY).append(name).append(ON_BEAN).append(bean.getClass().getName()).append("\'").toString();
			LOGGER.error(errMsg, e);
			throw new ICFPException(ICFP_300, errMsg, e);
		} 
		return expectedType.cast(result);
	}
	
	/**

	 * This method convert the String to integer value
	 * @param currency
	 * @return
	 */
	public static double convetCurrencyFormatToDouble(String currency){
		
		double currencyVal=0;
		
		if(currency != null && !currency.equals("") && !currency.equals(NULL)){
			currency = currency.replace(",", "");
			Double curDob = Double.parseDouble(currency);
			currencyVal = curDob.doubleValue();
		}
		
		return currencyVal;
			
	}
	
	/**

	 * This method convert the negative currency into double value
	 * @param currency
	 * @return
	 */
	public static BigDecimal convertNegativeCurrencyFormatToDouble(String currency){
		
		BigDecimal currencyVal=null;
		if(currency != null && !currency.equals("") && !currency.equals("null")){
			currency = currency.replace(",", "");
			currencyVal = new BigDecimal(currency);
		}
		return currencyVal;
	}
	
	/**
	 * Return true if the request is for Tab change
	 * @param request
	 * @return
	 */
	public static boolean isTabChangeRequest(HttpServletRequest request) {
		return request.getParameter(ICFPCommonHelper.TAB_NUMBER) != null;
	}

	/**
	 * Returns the Tab number
	 * @param request
	 * @return
	 */
	public static Integer getTabNumber(HttpServletRequest request) {
		String strTabNumber = request.getParameter(ICFPCommonHelper.TAB_NUMBER);
		return (strTabNumber != null) ? Integer.valueOf(strTabNumber) : null;
	}
	
	/**
	 * This method will return the Name of the given model score id or snprating id or
	 * final rating id or range id
	 * @param 
	 * @return
	 */
	public static String getNameByUsingID(Integer idValue,String typeOFList, HttpServletRequest request) throws Exception
	{
		List<NameValue> requiredList = null;
		StaticDataFactory staticDataFactory = (StaticDataFactory) request.getSession().getServletContext().getAttribute(StaticDataFactory.CTX_KEY);
		if(typeOFList!=null && typeOFList.equals(MODELSCORE))
		{
			requiredList =(ArrayList<NameValue>) staticDataFactory.getModelScores();
		}else if (typeOFList!=null && typeOFList.equals(SNPRATING))
		{
			requiredList =(ArrayList<NameValue>) staticDataFactory.getSNPRatings();
		}else if (typeOFList!=null && typeOFList.equals(FINALRATING))
		{
			requiredList =(ArrayList<NameValue>)staticDataFactory.getFinalRating();
		}else if (typeOFList!=null && typeOFList.equals(RANGE))
		{
			requiredList =(ArrayList<NameValue>)staticDataFactory.getRanges();
		}
		
		if(idValue!=null && requiredList!=null  && requiredList.size()>0)
		{
			for(int i=0;i<requiredList.size();i++)
			{
				NameValue nameValue = requiredList.get(i);
				if(nameValue.getID()!=null && nameValue.getID().intValue() == idValue.intValue())
				{
					return nameValue.getName();
					
				}
				
			}
		}
		
		return "";
	}
	
	/**
	 * Clones the current deal.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @param serviceClient
	 * @return
	 * @throws Exception
	 */
	public static DealRequest setCloneDeal(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response,ServiceClient serviceClient) throws Exception
	{
		String dealRequestID = request.getParameter(ICFPCommonHelper.DEAL_REQUEST_ID);
		
		DealRequest newDealRequest = new DealRequest();
		
		DealRequest dealRequest = null;
		
		if(dealRequestID!=null && !StringUtils.isEmpty(dealRequestID))
		{
			dealRequest = ICFPCommonHelper.getDeal(Integer.valueOf(dealRequestID), serviceClient);

			dealRequest.setDealSeqId(null);
			dealRequest.setDealName(null);
			dealRequest.setUniqueId(null);
			dealRequest.setValueDt(null);
			dealRequest.setPriority(null);
			dealRequest.setPriorityId(null);
			dealRequest.setPriorityComment(null);
			dealRequest.setAuditLogs(null);
			dealRequest.setActionLogs(null);
			dealRequest.setAdditionalApprovers(null);
			dealRequest.setAttachments(null);
			dealRequest.setCommentsLogs(null);
			dealRequest.setComments(null);
			dealRequest.setClosingCheckLists(null);
			dealRequest.setAttachmentTypeComments(null);
			dealRequest.setBusinessApprovers(null);
			dealRequest.setAttachments(null);
			
			Legs legs = dealRequest.getLegs();
			List<Object> allLegs = legs.getAllLegs();
			List<Object> newLegObjectList = new ArrayList<Object>();

			for(Object leg:allLegs)
			{
				if(leg instanceof RCALegRequest) {
					LegSummary legSummary = ((RCALegRequest) leg).getLegSummary();
					if(legSummary!=null)
					{
						String eventType=legSummary.getTransactionEventType();
						if(StringUtils.isNotBlank(eventType) && IMMEDIATE_DRAWDOWN.equals(eventType)){
							continue;
						}
						
						((RCALegRequest) leg).getLegSummary().setLegSeqId(null);
						((RCALegRequest) leg).getLegSummary().setAttachments(null);
						((RCALegRequest) leg).getLegSummary().setAttachmentTypeComments(null);
						removeExceptionAttachments(((RCALegRequest) leg).getLegSummary().getExceptionRequestForms());
						removeExceptionDerivativeInfo(((RCALegRequest) leg).getLegSummary().getDerivativesRequests());
						((RCALegRequest) leg).getLegSummary().setLegOpcode(INSERT);
					}
					
					DayTwoOperations dayTwoOperations = ((RCALegRequest) leg).getDayTwoOperations();
					if(dayTwoOperations!=null){
						removeAmmendmentAttachment(((RCALegRequest) leg).getDayTwoOperations().getAmendments());
						ArrayList<Amendment> amendmentsList = (ArrayList<Amendment>) ((RCALegRequest) leg).getDayTwoOperations().getAmendments();
						if(amendmentsList!=null && amendmentsList.size()>0)
						{
							for(Amendment amendmentObj:amendmentsList)
							{
								amendmentObj.setAmendmentOpcode(INSERT);
							}
						}
					}
					
					
					request.setAttribute(PRODUCTTYPE, RCA);
					
				} else if(leg instanceof EquityLegRequest) {
					LegSummary legSummary = ((EquityLegRequest) leg).getLegSummary();
					if(legSummary!=null)
					{
						((EquityLegRequest) leg).getLegSummary().setLegSeqId(null);
						((EquityLegRequest) leg).getLegSummary().setAttachments(null);
						((EquityLegRequest) leg).getLegSummary().setAttachmentTypeComments(null);
						removeExceptionAttachments(((EquityLegRequest) leg).getLegSummary().getExceptionRequestForms());
						removeExceptionDerivativeInfo( ((EquityLegRequest) leg).getLegSummary().getDerivativesRequests());
						((EquityLegRequest) leg).getLegSummary().setLegOpcode(INSERT);
						ArrayList<ShareInfo> shareInfoList = (ArrayList<ShareInfo>) ((EquityLegRequest) leg).getShareInfos();
						if(shareInfoList!=null && shareInfoList.size()>0)
						{
							for(ShareInfo shareInfoObj:shareInfoList)
							{
								shareInfoObj.setShareOpcode(INSERT);
							}
						}
					}
					DayTwoOperations dayTwoOperations = ((EquityLegRequest) leg).getDayTwoOperations();
					if(dayTwoOperations!=null){
						removeAmmendmentAttachment(((EquityLegRequest) leg).getDayTwoOperations().getAmendments());
					}
					request.setAttribute(PRODUCTTYPE, EQUITY);
					
				} else if(leg instanceof OtherLegRequest) {
					LegSummary legSummary = ((OtherLegRequest) leg).getLegSummary();
					if(legSummary!=null)
					{
						((OtherLegRequest) leg).getLegSummary().setLegSeqId(null);
						((OtherLegRequest) leg).getLegSummary().setAttachments(null);
						((OtherLegRequest) leg).getLegSummary().setAttachmentTypeComments(null);
						removeExceptionAttachments(((OtherLegRequest) leg).getLegSummary().getExceptionRequestForms());
						removeExceptionDerivativeInfo( ((OtherLegRequest) leg).getLegSummary().getDerivativesRequests());
						((OtherLegRequest) leg).getLegSummary().setLegOpcode(INSERT);
					}
					DayTwoOperations dayTwoOperations = ((OtherLegRequest) leg).getDayTwoOperations();
					if(dayTwoOperations!=null){
						removeAmmendmentAttachment(((OtherLegRequest) leg).getDayTwoOperations().getAmendments());
					}
					request.setAttribute(PRODUCTTYPE, OTHER);
					
				} else if(leg instanceof CPALegRequest) {
					
					CPASummary legSummary = ((CPALegRequest) leg).getCPASummary();
					if(legSummary!=null)
					{
						((CPALegRequest) leg).getCPASummary().setLegSeqId(null);
						((CPALegRequest) leg).getCPASummary().setAttachments(null);
						((CPALegRequest) leg).getCPASummary().setAttachmentTypeComments(null);
						List<ExceptionRequestForm> exceptionRequestFormsList = ((CPALegRequest) leg).getCPASummary().getExceptionRequestForms();
						removeExceptionAttachments(exceptionRequestFormsList);
						((CPALegRequest)leg).getCPASummary().setCPALegOpcode(INSERT);
					}
					DayTwoOperations dayTwoOperations = ((CPALegRequest) leg).getDayTwoOperations();
					if(dayTwoOperations!=null){
						((CPALegRequest) leg).getDayTwoOperations().getAmendments();
					}
					request.setAttribute(PRODUCTTYPE, CPA);
				}
				newLegObjectList.add(leg);
			}
			
			
			MsgHeader msgHeader = new MsgHeader();
			msgHeader.setOpcode(GETTREQID);
			String userId = UserContext.getCurrentUserContext().getId();
			msgHeader.setAuditCreator(userId);
			msgHeader.setAuditModifier(userId);
			msgHeader.setAuditCreatorFirstName(UserContext.getCurrentUserContext().getFirstName());
			msgHeader.setAuditCreatorLastName(UserContext.getCurrentUserContext().getLastName());
			String firstName  = UserContext.getCurrentUserContext().getFirstName();
			String lastName = UserContext.getCurrentUserContext().getLastName();
			msgHeader.setAuditCreatorFirstName(firstName);
			msgHeader.setAuditCreatorLastName(lastName);
			
			newDealRequest.setActionId(0);
			newDealRequest.setMsgHeader(msgHeader);
			newDealRequest.setTransOwnerSsoId(userId);
			newDealRequest = serviceClient.invokeService(DEAL, newDealRequest,DealRequest.class);

   
    
			newDealRequest.setWFId(dealRequest.getWFId());
			newDealRequest.setWFQueueName(dealRequest.getWFQueueName());
			newDealRequest.setAction(dealRequest.getAction());
			newDealRequest.setTimeToObtainApprovals(dealRequest.getTimeToObtainApprovals());
			newDealRequest.setCashManagementAssignedSso(dealRequest.getCashManagementAssignedSso());
			newDealRequest.setFrontOfficeAssignedSso(dealRequest.getFrontOfficeAssignedSso());
			newDealRequest.setMiddleOfficeAssignedSso(dealRequest.getMiddleOfficeAssignedSso());
			newDealRequest.setTreasuryTaxAssigned(dealRequest.getTreasuryTaxAssigned());
			newDealRequest.setRequestAmendmentTypeId(dealRequest.getRequestAmendmentTypeId());
			newDealRequest.setRequestAmendmentType(dealRequest.getRequestAmendmentType());
		    newDealRequest.setDealRationale(dealRequest.getDealRationale());
		    newDealRequest.setDealCategoryId(dealRequest.getDealCategoryId());
		    newDealRequest.setDealCategory(dealRequest.getDealCategory());
		    newDealRequest.setNumberOfTransactions(dealRequest.getNumberOfTransactions());
		    newDealRequest.setEventTypeId(dealRequest.getEventTypeId());
		    newDealRequest.setNumberOfDaysRem(dealRequest.getNumberOfDaysRem());
		    newDealRequest.setResponsibleRegionId(dealRequest.getResponsibleRegionId());
		    newDealRequest.setResponsibleRegion(dealRequest.getResponsibleRegion());

		    newDealRequest.setTransOwnerSsoId(dealRequest.getTransOwnerSsoId());
		    newDealRequest.setFirstName(dealRequest.getFirstName());
		    newDealRequest.setLastName(dealRequest.getLastName());
		    newDealRequest.setSecurityCategory(dealRequest.getSecurityCategory());
		    newDealRequest.setSecurityCategoryId(dealRequest.getSecurityCategoryId());
		    newDealRequest.setDebtValue(dealRequest.getDebtValue());
		    newDealRequest.setEquityValue(dealRequest.getEquityValue());
		    newDealRequest.setSubordinatedDebtFlag(dealRequest.isSubordinatedDebtFlag());
		    newDealRequest.setExpectedFundDt(dealRequest.getExpectedFundDt());
		    newDealRequest.setCrossBorderFlag(dealRequest.isCrossBorderFlag());
		    newDealRequest.setNonStandardDocsFlag(dealRequest.isNonStandardDocsFlag());
		    newDealRequest.setImpairmentHistoryFlag(dealRequest.isImpairmentHistoryFlag());
		    newDealRequest.setImpairmentComment(dealRequest.getImpairmentComment());
		    newDealRequest.setFinSttmntDtAboveOneYrFlag(dealRequest.isFinSttmntDtAboveOneYrFlag());
		    newDealRequest.setLatestDtOfFinSttmnt(dealRequest.getLatestDtOfFinSttmnt());
		    newDealRequest.setDerivativesNeededFlag(dealRequest.isDerivativesNeededFlag());
		    newDealRequest.setEquityInfusionsDividendsFlag(dealRequest.isEquityInfusionsDividendsFlag());
		    newDealRequest.setPrudentiallyRegulatedEntityFlag(dealRequest.isPrudentiallyRegulatedEntityFlag());
		    newDealRequest.setPrincipalLegalEntityFlag(dealRequest.isPrincipalLegalEntityFlag());
		    newDealRequest.setBorrowerInsolvencyFlag(dealRequest.isBorrowerInsolvencyFlag());
		    newDealRequest.setFOAffirmFlag(dealRequest.isFOAffirmFlag());
		    newDealRequest.setChngAfterIdagApprovalFlag(dealRequest.isChngAfterIdagApprovalFlag());
		    newDealRequest.setExceptionComments(dealRequest.getExceptionComments());
		    newDealRequest.setQualitativeFactors(dealRequest.getQualitativeFactors());
		    newDealRequest.setExceptionRequestForms(dealRequest.getExceptionRequestForms());
		    newDealRequest.setProductTypeCollection(dealRequest.getProductTypeCollection());
		    newDealRequest.setDealStatus(dealRequest.getDealStatus());
		    newDealRequest.setChangeTypeId(dealRequest.getChangeTypeId());
		    newDealRequest.setChangeTypeComments(dealRequest.getChangeTypeComments());
		    newDealRequest.setChngAfterApprovalsFlag(dealRequest.isChngAfterApprovalsFlag());
		    newDealRequest.setRiskOverrideFlag(dealRequest.isRiskOverrideFlag());
		    newDealRequest.setRuAmendedTcl(dealRequest.getRuAmendedTcl());
		    newDealRequest.setRevisedTclComments(dealRequest.getRevisedTclComments());
		    newDealRequest.setVaultId(dealRequest.getVaultId());
		    newDealRequest.setDealTcl(dealRequest.getDealTcl());
		    newDealRequest.setHighestLegAmt(dealRequest.getHighestLegAmt());
		    newDealRequest.setDerivativeTradeId(dealRequest.getDerivativeTradeId());
		    newDealRequest.setSpotRatesTimestamp(dealRequest.getSpotRatesTimestamp());
		    Legs legsObj = new Legs();
		    legsObj.setAllLegs(newLegObjectList);
		    newDealRequest.setLegs(legsObj);
		    newDealRequest.setStatusInfos(dealRequest.getStatusInfos());
		    newDealRequest.setIDAGEAGLeads(dealRequest.getIDAGEAGLeads());

		    CurrentDealManager.setActiveDeal(newDealRequest, request);
		}
		
		return newDealRequest;
	
	}
	
	/**
	 * Removes the excetpion attachmetns
	 * 
	 * @param exceptionRequestFormsList
	 */
	public static void removeExceptionAttachments(List<ExceptionRequestForm> exceptionRequestFormsList)
	{
		for(ExceptionRequestForm exceptionRequestForm:exceptionRequestFormsList)
		{
			exceptionRequestForm.setAttachments(null);
			exceptionRequestForm.setExceptionOpcode(null);
			exceptionRequestForm.setLegalExceptionsId(null);
			exceptionRequestForm.setExceptionOpcode(INSERT);
		}
	}
	
	/**
	 * Removes exception derivative info
	 * 
	 * @param derivativeList
	 */
	public static void removeExceptionDerivativeInfo(List<DerivativesRequest> derivativeList)
	{
		for(DerivativesRequest derivativesRequest:derivativeList)
		{
			derivativesRequest.setDerivativesOpcode(null);
			derivativesRequest.setDeriativesSeqId(null);
			derivativesRequest.setDerivativesOpcode(INSERT);
		}
	}
	
	/**
	 * Remove amendment attachmetns
	 * 
	 * @param ammendmentList
	 */
	public static void removeAmmendmentAttachment(List<Amendment> ammendmentList)
	{
		for(Amendment amendment:ammendmentList)
		{
			amendment.setAttachments(null);
		}
	}
	/**
	 * This method will take the vault request id from deal and compare the same with
	 * existing deal pool and participant details. If those match then returns true else false.
	 * @param dealRequest
	 * @param serviceClient
	 * @return
	 * @throws ICFPException
	 * @throws HWFServiceException
	 * @throws HWFStubException
	 */
	public boolean validateVaultRequestID(DealRequest dealRequest,ServiceClient serviceClient,String vaultID) throws ICFPException, HWFServiceException, HWFStubException
	{
		boolean participantMatchFlag = false;
		boolean cashPoolMatchFlag = false;
		if(dealRequest.getLegs()!=null && dealRequest.getLegs().getAllLegs()!=null
				&& dealRequest.getLegs().getAllLegs().size()>0)
		{
			List<Object> allLegs = dealRequest.getLegs().getAllLegs();
			Object legObject = allLegs.get(0);
			if(legObject!=null && legObject instanceof CPALegRequest) {
				
				
				String serviceParticipantLeGoldId="";
				String serviceParticipantTCode = "";
				String serviceParticipantMeName="";
				String servicePoolLeGoldId="";
				String servicePoolTCode = "";
				String servicePoolMeName="";
				
				MDM mdm = new MDM();
				MsgHeader msgHeader = new MsgHeader();
				msgHeader.setOpcode(VAULTIDDETAILS);
				mdm.setMsgHeader(msgHeader);
				List<VaultIDDetails> vaultRequestIDList = new ArrayList<VaultIDDetails>();
				VaultIDDetails vaultRequestID = new VaultIDDetails();
				vaultRequestID.setVaultRequestID(vaultID);
				vaultRequestIDList.add(vaultRequestID);
				mdm.setVaultIDDetails(vaultRequestIDList);
				
				mdm = serviceClient.invokeService(MDM,mdm,MDM.class);
				List<Entity> entitiesList = mdm.getEntities();
				
				if(entitiesList!=null)
				{
					for(int i=0;i<entitiesList.size();i++)
					{
						if(i==0)
						{
							Entity entityObj = entitiesList.get(0);
							List<MgmtEntity> managementEntityList = mdm.getMgmtEntities();
							if(managementEntityList!=null && managementEntityList.size()>0){
								MgmtEntity mgmtEntityObj = managementEntityList.get(0);
								if(mgmtEntityObj!=null){
									serviceParticipantMeName = mgmtEntityObj.getName();
								}
							}
							if(entityObj.getTreasuryCodes()!=null && entityObj.getTreasuryCodes().size()>0 )
							{
								serviceParticipantTCode = entityObj.getTreasuryCodes().get(0);
							}
							serviceParticipantLeGoldId = entityObj.getLEGoldId();
							
						}else if (i==1)
						{
							List<CashPool> cashPoolList = mdm.getCashPools();
							if(cashPoolList!=null && cashPoolList.size()>0){
									CashPool cashPoolObj = cashPoolList.get(0);
									
									servicePoolTCode = cashPoolObj.getTreasuryCode();
									servicePoolLeGoldId = cashPoolObj.getLEGoldID();
									servicePoolMeName = cashPoolObj.getManagementEntity();
								}
						}
					}// for loop
				}// entity list
			
				CPALegRequest cpaLeg = (CPALegRequest)legObject;
				CPASummary cpaSummary = null;
				Entity participantEntity = null;
				Entity cashPoolEntity = null;
				
				if(cpaLeg!=null && cpaLeg.getCPASummary()!=null)
				{
					cpaSummary = cpaLeg.getCPASummary();
					
					if(cpaSummary!=null && cpaSummary.getEntities()!=null)
					{
						List<Entity> cpaEntityList = cpaSummary.getEntities();
						
						if(cpaEntityList!=null && cpaEntityList.size()>0)
						{
							participantEntity = cpaEntityList.get(0);
							cashPoolEntity = cpaEntityList.get(1);
						}
					}
				}
				
				if(participantEntity!=null){
					
					if(participantEntity.getLEGoldId()!=null && participantEntity.getLEGoldId().equals(serviceParticipantLeGoldId)
							&& participantEntity.getMEName()!=null && participantEntity.getMEName().equals(serviceParticipantMeName)
							)
						
					for(String tCode : participantEntity.getTreasuryCodes()){
						
						if( tCode != null && tCode.equals(serviceParticipantTCode)){
							participantMatchFlag = true;
						}
					}										
				}
				
				if(cashPoolEntity!=null){
					
					if(cashPoolEntity.getLEGoldId()!=null && cashPoolEntity.getLEGoldId().equals(servicePoolLeGoldId)
							&& cashPoolEntity.getMEName()!=null && cashPoolEntity.getMEName().equals(servicePoolMeName)							
							)
						for(String tCode: cashPoolEntity.getTreasuryCodes()){
							
							if( tCode != null && tCode.equals(servicePoolTCode)){
								cashPoolMatchFlag = true;
							}
						}						
				}
				
				if(participantMatchFlag && cashPoolMatchFlag )
				{
					return true;
				}else{
					return false;
				}
			}
		}
		return false;
	}
	
	
	/**
	 * This method will return the Name of the given model score id or final rating id or range id
	 * @param 
	 * @return
	 */
	public static String getCurrencyNameById(String idValue,HttpServletRequest request) throws ICFPException
	{
		List<NameValueVO> requiredList = null;
		MasterDataFactory masterDataFactory = (MasterDataFactory) request.getSession().getServletContext().getAttribute(MasterDataFactory.CTX_KEY);
	
		requiredList =(ArrayList<NameValueVO>) masterDataFactory.getDealCurrencies();
		
		if(idValue!=null && requiredList!=null  && requiredList.size()>0)
		{
			for(int i=0;i<requiredList.size();i++)
			{
				NameValueVO nameValue = requiredList.get(i);
				if(nameValue.getId()!=null && nameValue.getId().equals(idValue))
				{
					return nameValue.getName();
					
				}
			}
		}
		return "";
	}
	
	/**
	 * Returns number of legs in a deal.
	 * 
	 * @param deal
	 * @return
	 */
	public static int getLegCount(DealRequest dealRequest) {
		int size = 0;
		for(Object legObj : dealRequest.getLegs().getAllLegs()) {
			String opcode = ICFPLegHelper.getOpCode(legObj);
			if(opcode != null && opcode.equalsIgnoreCase(DELETE)) {
				continue;
			}
			size++;
		}
		return size;
	}
	
	/**
	 * isCPADeal used identify whether the CPA Request or not.
	 * @param request HttpServletRequest
	 * @return boolean result
	 */
	public static Boolean isCPADeal(DealRequest dealRequest) {
		Boolean result = null;
		if(dealRequest != null && dealRequest.getLegs() != null && !dealRequest.getLegs().getAllLegs().isEmpty()) {
			result = (dealRequest.getLegs().getAllLegs().get(0) instanceof CPALegRequest) ? true : false;
		}
		return result;
	}
	
	/**
	 * Returns leg of the deal by leg number.
	 * 
	 * @param index
	 * @param request
	 * @return
	 */
	public static Object getLegByNumber(int index, DealRequest dealRequest) {
		Object leg = null;
		int count = 0;
		if(dealRequest.getLegs()!=null && dealRequest.getLegs().getAllLegs()!=null){
			for(Object legObj : dealRequest.getLegs().getAllLegs()) {
				String opcode = ICFPLegHelper.getOpCode(legObj);
				if(opcode != null && opcode.equalsIgnoreCase(DELETE)) {
					continue;
				} else if(count == index - 1) {
					leg = legObj;
					break;
				}
				count++;
			}
		}
		return leg;
	}
	
	public static ActionErrors  validateLegData(DealRequest dealRequest,String valueDate,boolean frontOfficeFlag,boolean transferPricingFlag)
	{
		ActionErrors errors = null;
		if(dealRequest.getLegs()!=null && dealRequest.getLegs().getAllLegs()!=null){
			List<Object> legList = dealRequest.getLegs().getAllLegs();
			String errorMsg = LEGS_ERRMSG;
			boolean errorsAdded=false;
			int i=0;
			for(Object leg : legList) {
				String isValidated = ICFPConstants.N_CAP;
				Integer legNumber = null;
				if(leg instanceof RCALegRequest) {
					RCALegRequest rcaLeg = (RCALegRequest) leg;
					if(frontOfficeFlag){
					    isValidated = rcaLeg.getLegSummary().getFoValidateFlag();
					}else if (transferPricingFlag){
						isValidated = rcaLeg.getLegSummary().getTpValidateFlag();
					}else{
					  isValidated = rcaLeg.getLegSummary().getRequesterValidateFlag();	
					}
					legNumber = rcaLeg.getLegSummary().getLegSeqId();
					
					/**
					 * Code to validate draw down date
					 */
					if(frontOfficeFlag){

						String eventType = rcaLeg.getLegSummary().getTransactionEventType();
						XMLGregorianCalendar drawDownDate = rcaLeg.getDrdownValueDt();
						String drawDownDtStr = "";
						if(drawDownDate!=null && eventType!=null &&  drawDownDate.toString().length()>=10 
								&& !eventType.equals("Immediate Drawdown") && !eventType.trim().equals("Drawdown") )
						{
							drawDownDtStr = DateUtil.getValueDate(drawDownDate, DATE_FORMAT);
						}

						if(drawDownDtStr!=null && valueDate!=null && drawDownDtStr.trim().length()>0 &&
								valueDate.trim().length()>0)
						{
							boolean flag = DateUtil.validateDrawdownDate(drawDownDtStr, valueDate);

							if(!flag){
								errorsAdded = true;
								if(!errorMsg.contains(legNumber.toString()))
								{
									if(i==0){
										errorMsg = errorMsg+legNumber;
									}else{
										errorMsg = errorMsg+","+legNumber;	
									}
								}
							}

						}
					}
				} else if(leg instanceof EquityLegRequest) {
					EquityLegRequest equityLeg = (EquityLegRequest) leg;
					if(frontOfficeFlag){
					  isValidated = equityLeg.getLegSummary().getFoValidateFlag();
					}else if (transferPricingFlag){
						isValidated = equityLeg.getLegSummary().getTpValidateFlag();
					}else{
					  isValidated = equityLeg.getLegSummary().getRequesterValidateFlag();	
					}
					legNumber = equityLeg.getLegSummary().getLegSeqId();
				} else if(leg instanceof OtherLegRequest) {
					OtherLegRequest otherLeg = (OtherLegRequest) leg;
					if(frontOfficeFlag){
					  isValidated = otherLeg.getLegSummary().getFoValidateFlag();
					}else if (transferPricingFlag){
						isValidated = otherLeg.getLegSummary().getTpValidateFlag();
					}else{
					  isValidated = otherLeg.getLegSummary().getRequesterValidateFlag();	
					}
					legNumber = otherLeg.getLegSummary().getLegSeqId();
				} else if(leg instanceof CPALegRequest) {
					CPALegRequest cpaLeg = (CPALegRequest) leg;
					
					if(frontOfficeFlag){
					  isValidated = cpaLeg.getCPASummary().getFoValidateFlag();
					}else if (transferPricingFlag){
						isValidated = cpaLeg.getCPASummary().getTpValidateFlag();
					}else{
					  isValidated = cpaLeg.getCPASummary().getRequesterValidateFlag();	
					}
					legNumber = cpaLeg.getCPASummary().getLegSeqId();
				}
				if((isValidated==null || isValidated.equals(ICFPConstants.N_CAP) ) && (!errorMsg.contains(legNumber.toString())) )
			    {
					errorsAdded = true;
					if(i==0){
					   errorMsg = errorMsg+legNumber;
					}else{
						errorMsg = errorMsg+","+legNumber;	
					}
				}
				i++;
			}
			
			if(errorsAdded){
				if (errors == null) {
					errors = new ActionErrors();
				}
				errorMsg = errorMsg+ICFPCommonHelper.ERRORMSG;
				errors.add(LEGERRORS, new ActionMessage(LEGERRORS , errorMsg));
			}
		}
		return errors;
	}
	
	/**
	 * This method copies the {@link InputStream} to {@link OutputStream}
	 * 
	 * @param input
	 * @param output
	 * @throws IOException 
	 */
	public static void copyStreams(InputStream input, OutputStream output) throws IOException {
		final ReadableByteChannel inputChannel = Channels.newChannel(input);
		final WritableByteChannel outputChannel = Channels.newChannel(output);
		final ByteBuffer buffer = ByteBuffer.allocateDirect(16 * 1024);
		while (inputChannel.read(buffer) != -1) {
			buffer.flip();
			outputChannel.write(buffer);
			buffer.compact();
		}
		// EOF will leave buffer in fill state
		 buffer.flip();
		// make sure the buffer is fully drained.
		while (buffer.hasRemaining()) {
			outputChannel.write(buffer);
		}
	}
	
	/**
	 * @param request
	 */
	public static String[] getUserBusinessSegment(HttpServletRequest request, String[] selectedBUs) {
		Set<String> businessSegments = null;
		Set<String> allowedBUs = new HashSet<String>();
		getReadOnlyRoles(request, allowedBUs);
		
		if(selectedBUs != null && selectedBUs.length > 0) {
			businessSegments = new HashSet<String>();
			for(int i = 0; i < selectedBUs.length; i++) {
				if(org.apache.commons.lang.StringUtils.isNotEmpty(selectedBUs[i]) && allowedBUs.contains(selectedBUs[i])) {
					businessSegments.add(selectedBUs[i]);
				}
			}
		} else {
			businessSegments = allowedBUs;
		}
		
		return (!businessSegments.isEmpty()) ? businessSegments.toArray(new String[businessSegments.size()]) : allowedBUs.toArray(new String[allowedBUs.size()]);
	}
	/**
	 * 
	 * @param request
	 * @param selectedBUs
	 * @return
	 */
	public static String[] getOwnerBusinessSegment(HttpServletRequest request, String[] selectedBUs) {
		Set<String> ownerBusinessSegments = null;
		Set<String> allowedBUs = new HashSet<String>();
		getReadOnlyRoles(request, allowedBUs);
		
		if(selectedBUs != null && selectedBUs.length > 0) {
			ownerBusinessSegments = new HashSet<String>();
			for(int i = 0; i < selectedBUs.length; i++) {
				if(org.apache.commons.lang.StringUtils.isNotEmpty(selectedBUs[i]) && !allowedBUs.contains(selectedBUs[i])) {
					ownerBusinessSegments.add(selectedBUs[i]);
				}
			}
			return (!ownerBusinessSegments.isEmpty()) ? ownerBusinessSegments.toArray(new String[ownerBusinessSegments.size()]) : null;
		}	
		return null;
	}

	/**
	 * @param request
	 * @param allowedBUs
	 */
	public static void getReadOnlyRoles(HttpServletRequest request,
			Set<String> allowedBUs) {
		List<String> roles = SessionManager.getRoles(request);
		for (String roleName : roles) {
			if(roleName.matches( "(?i:.*ReadOnly.*)|(?i:.*BusinessApprovers.*)|(?i:.*BusinessCFO.*)" )){
				String rName = roleName.substring(roleName.lastIndexOf("_")+1, roleName.length());
				if(rName.contains(ICFPCommonHelper.CLL)){
					rName = ICFPCommonHelper.CLL_AMERICAS;
				}else if(rName.contains(CAPITAL)){
					rName = ICFPCommonHelper.CAPITAL_HQ_OTHER;
				}else if(rName.contains(ICFPCommonHelper.RETAIL)){
					rName = ICFPCommonHelper.RETAIL_FINANCE;
				}else if(rName.contains(ICFPCommonHelper.RESTRUCTURE)){
					rName = ICFPCommonHelper.RESTRUCTURE_OP;
				}else if(rName.contains(ICFPCommonHelper.COMM_REAL_ESTATE)){
					rName = ICFPCommonHelper.COMMERCIAL_REAL_ESTATE;
				}
				allowedBUs.add(rName);
			}
		}
		
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public static ICFPAttachmentManager getAttachmentManger(HttpServletRequest request) {
		ServletContext context = request.getSession().getServletContext();
		return (ICFPAttachmentManager) context.getAttribute(CTX_KEY_ATMT_MNGR);
	}
}
