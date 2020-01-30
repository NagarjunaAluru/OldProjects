/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: RCATransferPricingInputAction.java
 * Purpose: RCATransferPricingInputAction used for review the deal,accept the deal, send back the deal 
 * and view the Leg when click on the action icon from the deal review screen.
 */
package com.ge.icfp.transferpricing.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.validator.Validator;
import org.apache.log4j.Logger;
import org.apache.struts.Globals;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.validator.Resources;

import com.ge.icfp.action.ICFPBaseAction;
import com.ge.icfp.action.ICFPException;
import com.ge.icfp.common.attachments.validation.AttachmentValidator;
import com.ge.icfp.common.constants.ICFPConstants;
import com.ge.icfp.common.helper.CurrentDealManager;
import com.ge.icfp.common.helper.ICFPCommonHelper;
import com.ge.icfp.common.helper.ICFPDay2LegHelper;
import com.ge.icfp.common.helper.ICFPLegHelper;
import com.ge.icfp.model.CPALegRequest;
import com.ge.icfp.model.DealRequest;
import com.ge.icfp.model.EquityLegRequest;
import com.ge.icfp.model.MsgHeader;
import com.ge.icfp.model.OtherLegRequest;
import com.ge.icfp.model.QualitativeFactors;
import com.ge.icfp.model.RCALegRequest;
import com.ge.icfp.model.RateInformation;
import com.ge.icfp.model.SolvencyMetrics;
import com.ge.icfp.model.TPLegRequest;
import com.ge.icfp.tag.DealManager;
import com.ge.icfp.util.EventType;
import com.ge.icfp.util.MasterDataFactory;
import com.ge.icfp.util.Utils;
import com.hydus.wff.common.bw.ServiceClient;
import com.hydus.wff.core.context.UserContext;
import com.hydus.wff.core.exception.HWFServiceException;
import com.hydus.wff.core.exception.HWFStubException;
import static com.ge.icfp.common.constants.ICFPConstants.*;
/**
 * This class is used to show the transfer pricing leg details and when they are modified
 * the updated information need to be saved.
 * @author srinivasan.desa
 *
 */


public class RCATransferPricingInputAction extends ICFPBaseAction {
	private static final String FALSE = "false";
	private static final String POST_TRANSACTION = "postTransaction";
	private static final String ASSESSMENT_FLAG = "assessmentFlag";
	private static final String COMMENT2 = "comment";
	private static final String MODEL_TYPE_ID = "modelTypeId";
	private static final String ICFPCPADAY2_LEG_REQUEST_FORM = "ICFPCPADAY2LegRequestForm";
	private static final String INTEREST_TYPE_ID = "interestTypeId";
	private static final String SAVE = "save";
	private static final String ACTION_VALUE = "actionValue";
	private static final String NEXT_LEG_NUMBER = "nextLegNumber";
	private static final String TP_LEG_REQUEST_RANGE = "TPLegRequest.range";
	private static final String TP_LEG_REQUEST_MODEL_SCORE = "TPLegRequest.modelScore";
	private static final String TP_LEG_REQUEST_SP_RATING = "TPLegRequest.SPRating";
	private static final String TP_LEG_REQUEST_FINAL_RATING = "TPLegRequest.finalRating";
	private static final String TP_LEG_REQUEST_RANGE_ID = "TPLegRequest.rangeId";
	private static final String TP_LEG_REQUEST_MODEL_SCORE_ID = "TPLegRequest.modelScoreId";
	private static final String TP_LEG_REQUEST_SP_RATING_ID = "TPLegRequest.SPRatingId";
	private static final String TP_LEG_REQUEST_FINAL_RATING_ID = "TPLegRequest.finalRatingId";
	private static final String PAGE = "page";
	private static final String NEXTLEG_SUMMARY = "nextlegSummary";
	/**
	 * LOGGER
	 */
	private static final Logger LOGGER = Logger.getLogger(RCATransferPricingInputAction.class);
	/**
	 * serviceClient
	 */
	private ServiceClient serviceClient;
	
	
	/**
	 * This method is used to open the next leg in transfer pricing transaction 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward nextLeg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Integer curLegNumber = Integer.valueOf(request.getParameter(ID));
		int legNumber = isNextLeg( curLegNumber, request);
		Object leg = CurrentDealManager.getLegByNumber(legNumber, request);
		
		if(leg!=null && leg instanceof EquityLegRequest) {
			ActionForward actionForward = mapping.findForward(EQUITY_LEGSUMMARY);
			StringBuffer path = null;

			if(actionForward == null){
				path=new StringBuffer("/transferPricing/transferPricing.do?command=legDetails");
			}else{
				path= new StringBuffer( actionForward.getPath() );	
			}
		
			if(path.indexOf( "?" ) == -1) {
				path.append("?");
			}
			path.append(ID_LABEL).append(legNumber).append("&pType=EQUITY").append("&command=legDetails");
			return new ActionForward( path.toString() );
		}
		
		request.setAttribute(ID, legNumber);
		
		openRCALeg(mapping, form, request, response);
		
		if ( legNumber>0){
			String forward = null;
			ActionForward actionForward = new ActionForward();
			StringBuffer path = null;
			forward = RCATransferPricingInputAction.NEXTLEG_SUMMARY;
			actionForward = mapping.findForward( forward );
			path = new StringBuffer( actionForward.getPath() );
			boolean isQuery = ( path.indexOf( "?" ) >= 0 );
			if( isQuery )
			{
			path.append( ID_LABEL );
			path.append( legNumber );
			}
			else
			{
			path.append( "command=openLeg&id=" );
			path.append(legNumber);
			}
			
			return new ActionForward( path.toString() );
		
		}
		request.setAttribute(ACTIONID, 3);
		request.setAttribute(LEGNUMBER, legNumber);
		return new ActionForward(LEGSUMMARY );
	}
	
	/**
	 * Next Leg number 
	 * @param legForm
	 * @param request
	 * @return
	 */
	protected Integer isNextLeg(Integer curLegNumber, HttpServletRequest request){
		if(curLegNumber < CurrentDealManager.getCurrentDeal(request).getLegs().getAllLegs().size()){
			return getNextLeg(curLegNumber, request);
		}
		return 0;
	}
	private Integer getNextLeg(Integer legNumber, HttpServletRequest request) {
		boolean isGoToNextLeg = DealManager.hideLegView(legNumber+1, request);
		int noOfLegs = CurrentDealManager.getCurrentDeal(request).getLegs().getAllLegs().size();
		if(isGoToNextLeg){
			if((legNumber + 1) < noOfLegs){
				return getNextLeg(legNumber +1, request);
			}else{
				return 0;
			}
		}else{
			if((legNumber + 1) <= noOfLegs){
				return legNumber + 1;
			}else{
				return 0;
			}
		}
	}

	/**
	 * This method is used to save the leg details in transfer pricing transaction 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	public ActionForward save(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm icfpLegRequestForm = (DynaActionForm) form;
		String pageNumberStr = (String)request.getParameter(RCATransferPricingInputAction.PAGE);
		Integer legNumber = Integer.valueOf((String)icfpLegRequestForm.get(LEGNUMBER));
		request.setAttribute(LEGNUMBER, legNumber);
		Object leg = CurrentDealManager.getLegByNumber(legNumber, request);
		EventType eventType = ICFPDay2LegHelper.getEventType(leg);
		int pageNumber=2;
		// Validating save to OtherLegRequest type
		CurrentDealManager.syncTPCommentsWithFormObject(request);
		request.setAttribute(ACTIONID, 3);
		if(eventType == null && leg instanceof OtherLegRequest) {
			ActionErrors errors = new ActionErrors();
			
			if(StringUtils.isNotEmpty(pageNumberStr)) {
				pageNumber = Integer.parseInt(pageNumberStr);
			}
			Validator validator = Resources.initValidator(ICFPOTHERLEGREQUESTFORM, icfpLegRequestForm, getServlet().getServletContext(), request, errors,pageNumber);
			validator.validate();
			if(!errors.isEmpty()) {
				saveErrors(request, errors);
			}
			if(pageNumber > 2){
				ActionErrors attErrors = AttachmentValidator.getInstance().validateLeg(leg, request);
				if(attErrors!=null)
				{
					errors.add(attErrors);
				}
			}
			if(!errors.isEmpty()) {
				saveErrors(request, errors);
				request.setAttribute(LEGNUMBER, legNumber);
				request.setAttribute(ICFPConstants.AMTERROR,"Please fix the following fields highlighted in red.");
			}
			if(!getErrors(request).isEmpty()) {
				return mapping.findForward(LEGSUMMARY);
			}
		}else if(eventType != null && leg instanceof RCALegRequest){
			ActionErrors errors = new ActionErrors();
			if(StringUtils.isNotEmpty(pageNumberStr)) {
				pageNumber = Integer.parseInt(pageNumberStr);
			}
			Validator validator = Resources.initValidator(ICFPOTHERLEGREQUESTFORM, icfpLegRequestForm, getServlet().getServletContext(), request, errors,pageNumber);
			validator.validate();
			
			validateCommentsForDay2(icfpLegRequestForm,errors);
			if(!errors.isEmpty()) {
				saveErrors(request, errors);
			}
			if(pageNumber > 2){
				ActionErrors attErrors = AttachmentValidator.getInstance().validateLeg(leg, request);
				if(attErrors!=null)
				{
					errors.add(attErrors);
				}
			}
			if(!errors.isEmpty()) {
				saveErrors(request, errors);
				request.setAttribute(LEGNUMBER, legNumber);
				request.setAttribute(ICFPConstants.AMTERROR,"Please fix the following fields highlighted in red.");
				
			}
			if(!getErrors(request).isEmpty()) {
				return mapping.findForward(DAY2LEG);
			}
		}else if (eventType == null && leg instanceof RCALegRequest){
			ActionErrors errors = new ActionErrors();
			if(StringUtils.isNotEmpty(pageNumberStr)) {
				pageNumber = Integer.parseInt(pageNumberStr);
			}
			Validator validator = Resources.initValidator(ICFPLEGREQUESTFORM, icfpLegRequestForm, getServlet().getServletContext(), request, errors,pageNumber);
			validator.validate();
			if(!errors.isEmpty()) {
				saveErrors(request, errors);
				
			}
			if(pageNumber > 2){
				ActionErrors attErrors = AttachmentValidator.getInstance().validateLeg(leg, request);
				if(attErrors!=null)
				{
					errors.add(attErrors);
				}
			}
			if(!errors.isEmpty()) {
				saveErrors(request, errors);
				request.setAttribute(LEGNUMBER, legNumber);
				request.setAttribute(ICFPConstants.AMTERROR,"Please fix the following fields highlighted in red.");
			}
			if(!getErrors(request).isEmpty()) {
				return mapping.findForward(LEGSUMMARY);
			}
		}
		
		String radioButton =  request.getParameter(RADIOVALUE);
		DealRequest dealRequest = CurrentDealManager.getCurrentDeal(request);
		Integer dealSeqID = dealRequest.getDealSeqId();
		
		DynaActionForm legSummaryForm = (DynaActionForm) icfpLegRequestForm.get(LEGSUMMARY);
		String currency = "";
		String currencyName = (String)legSummaryForm.get(ORIGINALCCY);
		if(currencyName!=null && currencyName.contains("-")){
			String tempCurrnecy[] = currencyName.split("-");
			currency = tempCurrnecy[0];
			legSummaryForm.set(ORIGINALCCY, currency);
		}
		
		String dayOnecurrency = "";
		String dayOnecurrencyName = (String)legSummaryForm.get(DAYONECCY);
		if(dayOnecurrencyName!=null && dayOnecurrencyName.contains("-")){
			String dayOnetempCurrnecy[] = dayOnecurrencyName.split("-");
			dayOnecurrency = dayOnetempCurrnecy[0];
			legSummaryForm.set(DAYONECCY, dayOnecurrency);
		}
		
		
		
		ICFPLegHelper.synchLegWithForm(leg, icfpLegRequestForm, request, getServlet().getServletContext(), mapping, this);
		
		if(leg instanceof EquityLegRequest) {
			EquityLegRequest equityLeg = (EquityLegRequest) leg;
			String comment = request.getParameter(OTHEREQUITYCOMMENTS);
			equityLeg.setOtherEquityComments(comment);
			String comments  = request.getParameter(COMMENTS_TRANSFER_PRICING);
			if(comments!=null && StringUtils.isNotEmpty(comments) && (equityLeg.getLegSummary().getComments()==null ||
					StringUtils.isEmpty(equityLeg.getLegSummary().getComments()))){
				equityLeg.getLegSummary().setComments(comments);
			}
		}else if(leg instanceof RCALegRequest) {
			RCALegRequest rcaLeg = (RCALegRequest) leg;
			String comments  = request.getParameter(COMMENTS_TRANSFER_PRICING);
			if(comments!=null && StringUtils.isNotEmpty(comments)){
				rcaLeg.getLegSummary().setComments(comments);
			}	
		}else if(leg instanceof OtherLegRequest) {
			OtherLegRequest otherLeg = (OtherLegRequest) leg;
			String comments  = request.getParameter(COMMENTS_TRANSFER_PRICING);
			if(comments!=null && StringUtils.isNotEmpty(comments)){
				otherLeg.getLegSummary().setComments(comments);
			}	
		}
		
		
		Object legSummary = ICFPLegHelper.getLegSummary(leg);
		
		
		if(!(leg instanceof EquityLegRequest)){
			@SuppressWarnings("unchecked")
			List<QualitativeFactors> quanlitativeFectorsList = Utils.fetchPropertyValue(QUALITATIVEFACTORS, legSummary, List.class);
			applyAssesment(quanlitativeFectorsList,request,radioButton,legNumber);
			
			Integer finalRatingID = Utils.fetchPropertyValue(RCATransferPricingInputAction.TP_LEG_REQUEST_FINAL_RATING_ID, leg, Integer.class);
			String finalRating = ICFPCommonHelper.getNameByUsingID(finalRatingID,FINALRATING,request);
			Integer spRatingID = Utils.fetchPropertyValue(RCATransferPricingInputAction.TP_LEG_REQUEST_SP_RATING_ID, leg, Integer.class);
			String spRating = ICFPCommonHelper.getNameByUsingID(spRatingID,SNPRATING,request);
			Integer modelScoreId = Utils.fetchPropertyValue(RCATransferPricingInputAction.TP_LEG_REQUEST_MODEL_SCORE_ID, leg, Integer.class);
			String modelScore = ICFPCommonHelper.getNameByUsingID(modelScoreId,MODELSCORE,request);
			Integer rangeId = Utils.fetchPropertyValue(RCATransferPricingInputAction.TP_LEG_REQUEST_RANGE_ID, leg, Integer.class);
			String range = ICFPCommonHelper.getNameByUsingID(rangeId,RANGE,request);
	
			Utils.setPropertyValue(RCATransferPricingInputAction.TP_LEG_REQUEST_FINAL_RATING, finalRating, leg);
			Utils.setPropertyValue(RCATransferPricingInputAction.TP_LEG_REQUEST_SP_RATING, spRating, leg);
			Utils.setPropertyValue(RCATransferPricingInputAction.TP_LEG_REQUEST_MODEL_SCORE, modelScore, leg);
			Utils.setPropertyValue(RCATransferPricingInputAction.TP_LEG_REQUEST_RANGE, range, leg);
			if(pageNumber > 2){
				ICFPLegHelper.setTPValidateFlag(leg, ICFPConstants.Y_CAP);
			}else if (pageNumber <= 2){
				ICFPLegHelper.setTPValidateFlag(leg, ICFPConstants.N_CAP);
			}
		}		
		String opcode = ICFPLegHelper.getOpCode(leg);
		Integer legSeqId = ICFPLegHelper.getLegSeqId(leg);
		
		prepareMsgHeader(dealRequest, INSERTDEAL, SAVE,22);
	
		if(leg instanceof EquityLegRequest){
			ICFPLegHelper.setOpCodeFlag(leg, UPDATE);
		}else{
			ICFPLegHelper.setOpCodeFlag(leg, TPUPDATE);
		}
		
		serviceClient.invokeService(DEAL, dealRequest,DealRequest.class);
		dealRequest = ICFPCommonHelper.getDeal(dealRequest.getDealSeqId(), serviceClient);
		CurrentDealManager.setActiveDeal(dealRequest, request);
		
		int nextLegNumber = isNextLeg( legNumber, request);
		request.setAttribute(RCATransferPricingInputAction.NEXT_LEG_NUMBER, String.valueOf((nextLegNumber > 0) ? nextLegNumber : 0));
		
		
		request.setAttribute(UPDATEMESSAGE,LEG_LABEL+ legSeqId + UPDATED_LABEL);
		
		request.setAttribute(DEALREQUESTID,dealSeqID.toString());
		String actionValue = request.getParameter(RCATransferPricingInputAction.ACTION_VALUE);
		ActionForward forward = null;
		if(StringUtils.isNotBlank(actionValue) && RCATransferPricingInputAction.SAVE.equals(actionValue)) {
			forward = openRCALeg(mapping, icfpLegRequestForm, request, response);
		} else {
			openRCALeg(mapping, icfpLegRequestForm, request, response);
			forward = mapping.findForward(SUCCESS);
		}
		return forward;
	}
	
	/**
	 * This method is used to save the leg and go to next leg in transfer pricing transaction 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward saveAndGoToNextLeg(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		DynaActionForm icfpLegRequestForm = (DynaActionForm) form;
		Integer legNumber = Integer.valueOf((String)icfpLegRequestForm.get(LEGNUMBER));
		save(mapping, form, request, response);
		
		Integer prelegNumber = (Integer)request.getAttribute(LEGNUMBER);
		String legNumberStr = (String)request.getAttribute(RCATransferPricingInputAction.NEXT_LEG_NUMBER);
		
		if(StringUtils.isNotBlank(legNumberStr)) {
			legNumber = Integer.parseInt(legNumberStr);
		}
		
		Object leg = CurrentDealManager.getLegByNumber(legNumber, request);
		EventType eventType = ICFPDay2LegHelper.getEventType(leg);
		
		request.setAttribute(ACTIONID, 3);
		request.setAttribute(LEGNUMBER, legNumber);
		if(eventType == null && leg instanceof OtherLegRequest) {
			ActionErrors errors = (ActionErrors)request.getAttribute(Globals.ERROR_KEY);
			if(errors!=null && !errors.isEmpty()) {
				return mapping.findForward(LEGSUMMARY);
			}
		}else if(eventType != null && leg instanceof RCALegRequest){
			ActionErrors errors = (ActionErrors)request.getAttribute(Globals.ERROR_KEY);
			if(errors!=null && !errors.isEmpty()) {
				return mapping.findForward(DAY2LEG);
			}
		}else if(eventType == null && leg instanceof RCALegRequest){
			ActionErrors errors = (ActionErrors)request.getAttribute(Globals.ERROR_KEY);
			if(errors!=null && !errors.isEmpty()) {
				return mapping.findForward(LEGSUMMARY);
			}
		}
		
		int nextLegNumber = isNextLeg( prelegNumber, request); 
		if ( nextLegNumber>0){
			request.setAttribute(RCATransferPricingInputAction.NEXT_LEG_NUMBER, String.valueOf(nextLegNumber));
			return nextLeg(mapping, form, request, response);
		}else{
			request.setAttribute(RCATransferPricingInputAction.NEXT_LEG_NUMBER, ICFPConstants.ZERO);
			return mapping.findForward(INBOX_SMALL);
		}
	}
	
	/**
	 * This method is used to save the leg and return to deal in transfer pricing transaction 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward saveAndReturnToDeal(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		save(mapping, form, request, response);
		
		DynaActionForm icfpLegRequestForm = (DynaActionForm) form;
		int legNumber = Integer.valueOf((String)icfpLegRequestForm.get(LEGNUMBER));
		
		Object leg = CurrentDealManager.getLegByNumber(legNumber, request);
		EventType eventType = ICFPDay2LegHelper.getEventType(leg);
		request.setAttribute(ACTIONID, 3);
		request.setAttribute(LEGNUMBER, legNumber);
		if(eventType == null && leg instanceof OtherLegRequest) {
			ActionErrors errors = (ActionErrors)request.getAttribute(Globals.ERROR_KEY);
			if(errors!=null && !errors.isEmpty()) {
				return mapping.findForward(LEGSUMMARY);
			}
		}else if(eventType != null && leg instanceof RCALegRequest){
			ActionErrors errors = (ActionErrors)request.getAttribute(Globals.ERROR_KEY);
			if(errors!=null && !errors.isEmpty()) {
				return mapping.findForward(DAY2LEG);
			}
		}else if(eventType == null && leg instanceof RCALegRequest){
			ActionErrors errors = (ActionErrors)request.getAttribute(Globals.ERROR_KEY);
			if(errors!=null && !errors.isEmpty()) {
				return mapping.findForward(LEGSUMMARY);
			}
		}
		
		return mapping.findForward(SUCCESS);
	}
	
	/**
	 * This method is used to save the cpa deal .
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward saveCPA(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String actionValue = request.getParameter(RCATransferPricingInputAction.ACTION_VALUE);
		String pageNumberStr = (String)request.getParameter(RCATransferPricingInputAction.PAGE);
		DynaActionForm icfpLegRequestForm = (DynaActionForm) form;
		
		DynaActionForm rateInformationForm = (DynaActionForm)icfpLegRequestForm.get(RATEINFORMATION);
		
		if(rateInformationForm!=null)
		   rateInformationForm.set(RCATransferPricingInputAction.INTEREST_TYPE_ID,TWO);
		
		DealRequest dealRequest = CurrentDealManager.getCurrentDeal(request);
		int legNumber = Integer.valueOf((String)icfpLegRequestForm.get(LEGNUMBER));
		CPALegRequest leg = CurrentDealManager.getCPALegByNumber(legNumber, request);
		EventType eventType = ICFPDay2LegHelper.getEventType(leg);
		int pageNumber=2;
		request.setAttribute(ACTIONID, 3);
		request.setAttribute(LEGNUMBER, legNumber);
		CurrentDealManager.syncCommentsWithFormObject(request);
		if(eventType != null && actionValue == null){ // Day2 -  Save n Return to Deal

			ActionErrors errors = new ActionErrors();
			
			if(!StringUtils.isEmpty(pageNumberStr))
			{
				pageNumber = Integer.parseInt(pageNumberStr);
			}
			
			Validator validator = Resources.initValidator(RCATransferPricingInputAction.ICFPCPADAY2_LEG_REQUEST_FORM, icfpLegRequestForm, getServlet().getServletContext(), request, errors,pageNumber);
			validator.validate();
			
			validateCommentsForDay2(icfpLegRequestForm,errors);
			
			if(pageNumber > 2){
				ActionErrors attErrors = AttachmentValidator.getInstance().validateLeg(leg, request);
				if(attErrors!=null)
				{
					errors.add(attErrors);
				}
			}

			if(!errors.isEmpty()) {
				saveErrors(request, errors);
				return mapping.findForward(DAY2LEG);
			}
		}else if (eventType == null)
		{
			ActionErrors errors = new ActionErrors();
			if(StringUtils.isNotEmpty(pageNumberStr)) {
				pageNumber = Integer.parseInt(pageNumberStr);
			}
			Validator validator = Resources.initValidator(CPALEGREQUESTFORM, icfpLegRequestForm, getServlet().getServletContext(), request, errors,pageNumber);
			validator.validate();
			
			if(pageNumber > 2){
				ActionErrors attErrors = AttachmentValidator.getInstance().validateLeg(leg, request);
				if(attErrors!=null)
				{
					errors.add(attErrors);
				}
			}
			
			if(!errors.isEmpty()) {
				saveErrors(request, errors);
				return mapping.findForward(CPALEGSUMMARY);
			}
		}
				
		ICFPLegHelper.syncCPALegWithForm(leg, icfpLegRequestForm, request, getServlet().getServletContext(), mapping, this);
		
		
			CPALegRequest cpaLegObject = (CPALegRequest) leg;
			String comments  = request.getParameter(COMMENTS_TRANSFER_PRICING);
			if(comments!=null && StringUtils.isNotEmpty(comments)){
				cpaLegObject.setComments(comments);
			}	
		
		Integer legSeqId = ICFPLegHelper.getLegSeqId(leg);
		
		Integer finalRatingID = ((CPALegRequest) leg).getTPLegRequest().getFinalRatingId();
		Integer spRatingID = ((CPALegRequest) leg).getTPLegRequest().getSPRatingId();
		Integer modelScoreId = ((CPALegRequest) leg).getTPLegRequest().getModelScoreId();
		Integer rangeId = ((CPALegRequest) leg).getTPLegRequest().getRangeId();
		String finalRating = ICFPCommonHelper.getNameByUsingID(finalRatingID,FINALRATING,request);
		String spRating = ICFPCommonHelper.getNameByUsingID(spRatingID,SNPRATING,request);
		String modelScore = ICFPCommonHelper.getNameByUsingID(modelScoreId,MODELSCORE,request);
		String range = ICFPCommonHelper.getNameByUsingID(rangeId,RANGE,request);
	
	 	((CPALegRequest) leg).getTPLegRequest().setFinalRating(finalRating);
		((CPALegRequest) leg).getTPLegRequest().setSPRating(spRating);
		((CPALegRequest) leg).getTPLegRequest().setModelScore(modelScore);
		((CPALegRequest) leg).getTPLegRequest().setRange(range);
				
		CPALegRequest cpaLeg = (CPALegRequest) leg;
		cpaLeg.getCPASummary().setCPALegOpcode(TPUPDATE);
		CurrentDealManager.syncCommentsWithFormObject(request);
		prepareMsgHeader(dealRequest, INSERTDEAL, SAVE,22);
		cpaLeg.getCPASummary().setCPALegOpcode(TPUPDATE);
		
		if(pageNumber > 2){
			ICFPLegHelper.setTPValidateFlag(leg, ICFPConstants.Y_CAP);
		}else if (pageNumber <= 2){
			ICFPLegHelper.setTPValidateFlag(leg, ICFPConstants.N_CAP);
		}
		serviceClient.invokeService(DEAL, dealRequest,DealRequest.class);
		String seqId = "";
		if(legSeqId != null){
			seqId = legSeqId.toString();
		}
		request.setAttribute(UPDATEMESSAGE,LEG_LABEL+ seqId + UPDATED_LABEL);
		int nextLegNumber = isNextLeg( legNumber, request); 
		
		if ( nextLegNumber>0){
			request.setAttribute(RCATransferPricingInputAction.NEXT_LEG_NUMBER, String.valueOf(nextLegNumber));
		}else{
			request.setAttribute(RCATransferPricingInputAction.NEXT_LEG_NUMBER, ICFPConstants.ZERO);
		}
		
		ActionForward forward = null;
		request.setAttribute(ACTIONID, 3);
		request.setAttribute(LEGNUMBER, legNumber);
		// Refresh leg in case of only save
		if(actionValue!=null && actionValue.equals(RCATransferPricingInputAction.SAVE)) {
			dealRequest = ICFPCommonHelper.getDeal(dealRequest.getDealSeqId(), serviceClient);
			CurrentDealManager.setActiveDeal(dealRequest, request);
			request.setAttribute(ID, legNumber);
			forward = openCPALeg(mapping, form, request, response);
		} else {
			openCPALeg(mapping, form, request, response);
			forward = mapping.findForward(SUCCESS);
		}
		
		return forward;
	}
	
	/**
	 * This method is called when save and return to deal is pressed 
	 * in cpa transfer pricing screen
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward cpaSaveAndReturnToDeal(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return saveCPA(mapping, form, request, response);
	}
	
/**
 * prepareMsgHeader
 * @param dealRequest
 * @param opcode
 * @param action
 * @param actionId
 */
	private void prepareMsgHeader(DealRequest dealRequest, String opcode,
			String action, int actionId) {
		MsgHeader msgHeader = new MsgHeader();
		msgHeader.setOpcode(opcode);
		String userId = UserContext.getCurrentUserContext().getId();
		msgHeader.setAuditCreator(userId);
		msgHeader.setAuditModifier(userId);
		msgHeader.setAuditCreatorFirstName(UserContext.getCurrentUserContext().getFirstName());
		msgHeader.setAuditCreatorLastName(UserContext.getCurrentUserContext().getLastName());
		msgHeader.setAuditModifierFirstName(UserContext.getCurrentUserContext().getFirstName());
		msgHeader.setAuditModifierLastName(UserContext.getCurrentUserContext().getLastName());

		if (actionId != 0) {
			dealRequest.setActionId(actionId);
		}

		dealRequest.setMsgHeader(msgHeader);

		if (action != null && action.trim().length() > 0) {
			dealRequest.setAction(action);
		}

		dealRequest.setTransOwnerSsoId(userId);
	}
	
	/**
	 * This method is used to open the RCA, Bond, TL,Other product type of leg details.
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward openRCALeg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Integer legNumber = (Integer) request.getAttribute(ID);
		if(legNumber == null) {
			legNumber = Integer.valueOf(request.getParameter(ID));
		}
		DynaActionForm icfpLegForm = (DynaActionForm) form;
		Object leg = CurrentDealManager.getLegByNumber(legNumber, request);
		EventType eventType = ICFPDay2LegHelper.getEventType(leg);
		
		// Set QualitativeFactors if not exists
		ICFPLegHelper.prepareQualitativeFactors(leg, 10);
		RateInformation rateInformation = null;
		// Equity doesn't have rate information and solvency metrics
		TPLegRequest tpLegRequest = null;
		if(!(leg instanceof EquityLegRequest)){
			tpLegRequest = Utils.fetchPropertyValue(TPLEGREQUEST, leg, TPLegRequest.class);
			if(tpLegRequest == null) {
				tpLegRequest = new TPLegRequest();
				Utils.setPropertyValue(TPLEGREQUEST, tpLegRequest, leg);
			}
			rateInformation = Utils.fetchPropertyValue(RATEINFORMATION, leg, RateInformation.class);
			if(rateInformation == null) {
				rateInformation = new RateInformation();
				Utils.setPropertyValue(RATEINFORMATION, rateInformation, leg);
			}
			
			List<SolvencyMetrics> solvencyMatricsList = tpLegRequest.getSolvencyMetrics();
			// Set UPDATE opcode to all SolvencyMatrics which are fetched from DB
			if(!solvencyMatricsList.isEmpty()) {
				for(SolvencyMetrics eachSolvencyMatrics : solvencyMatricsList) {
					if(eachSolvencyMatrics.getSolvencyMetricOpcode() == null) {
						eachSolvencyMatrics.setSolvencyMetricOpcode(UPDATE);
					}
				}
			}
			
			// Add new SovlvencyMatrics; if less than 7
			for(int i=solvencyMatricsList.size(); i < 7; i++) {
				SolvencyMetrics solvencyMatrix = new SolvencyMetrics();
				solvencyMatrix.setSolvencyMetricOpcode(INSERT);
				solvencyMatricsList.add(solvencyMatrix);
			}
			formatCurrency(icfpLegForm,tpLegRequest,true);
		}
		
		if(leg instanceof EquityLegRequest){
			if(((EquityLegRequest) leg).getOtherEquityComments()!=null){
			request.setAttribute(OTHERCOMMENTS,((EquityLegRequest) leg).getOtherEquityComments());
			}
		}
		ICFPLegHelper.syncFormWithLeg(icfpLegForm, leg, request, getServlet().getServletContext(), mapping, this);
		icfpLegForm.set(LEGNUMBER, String.valueOf(legNumber));
		
		// Equity doesn't have rate information and solvency metrics
		if(!(leg instanceof EquityLegRequest)){
			formatCurrency(icfpLegForm,tpLegRequest,false);
			
			if(rateInformation.getFloatingRateIndex()==null || StringUtils.isEmpty(rateInformation.getFloatingRateIndex())){
				((DynaActionForm)form).set(INDEXTERMMAP, new HashMap<String, String>());
			}else{
				request.setAttribute(FLOATINGRATEINDEX, rateInformation.getFloatingRateIndex());
				getIndexTermData(mapping,form,request,response); 
			}
		}
		
		Integer nextLegNumber = isNextLeg(legNumber, request);
		// If next leg not exists; make nextLegNumber as zero 
		if(CurrentDealManager.getLegByNumber(nextLegNumber, request) == null) {
			nextLegNumber = 0;
		}
		request.setAttribute(RCATransferPricingInputAction.NEXT_LEG_NUMBER, String.valueOf(nextLegNumber));
		
		ActionForward forward = null;
		request.setAttribute(ACTIONID, 3);
		request.setAttribute(LEGNUMBER, legNumber);
		
		if(eventType != null) {
			forward = mapping.findForward(DAY2LEG);
		} else {
			if(leg instanceof OtherLegRequest) {
				forward = mapping.findForward(OTHERLEGSUMMARY);
			} else {
				forward = mapping.findForward(LEGSUMMARY);
			}
		}
		
		return forward;
	}

	/**
	 * This method is used to open cpa leg details.
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward openCPALeg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Integer legNumber = (Integer) request.getAttribute(ID);
		if(legNumber == null) {
			legNumber = Integer.valueOf(request.getParameter(ID));
		}
		
		Object leg = CurrentDealManager.getLegByNumber(legNumber,CPALegRequest.class, request);
		request.setAttribute(ID, legNumber);
		DynaActionForm cpaLegForm = (DynaActionForm) form;
		
		// Set QualitativeFactors if not exists
		ICFPLegHelper.prepareQualitativeFactors(leg, 10);
		
		TPLegRequest tpLegRequest = Utils.fetchPropertyValue(TPLEGREQUEST, leg, TPLegRequest.class);
		if(tpLegRequest == null) {
			tpLegRequest = new TPLegRequest();
			Utils.setPropertyValue(TPLEGREQUEST, tpLegRequest, leg);
		}
		RateInformation rateInformation = Utils.fetchPropertyValue(RATEINFORMATION, leg, RateInformation.class);
		if(rateInformation == null) {
			rateInformation = new RateInformation();
			Utils.setPropertyValue(RATEINFORMATION, rateInformation, leg);
		}
		
		List<SolvencyMetrics> solvencyMatricsList = tpLegRequest.getSolvencyMetrics();
		// Set UPDATE opcode to all SolvencyMatrics which are fetched from DB
		if(!solvencyMatricsList.isEmpty()) {
			for(SolvencyMetrics eachSolvencyMatrics : solvencyMatricsList) {
				if(eachSolvencyMatrics.getSolvencyMetricOpcode() == null) {
					eachSolvencyMatrics.setSolvencyMetricOpcode(UPDATE);
				}
			}
		}
		
		// Add new SovlvencyMatrics; if less than 7
		for(int i=solvencyMatricsList.size(); i < 7; i++) {
			SolvencyMetrics solvencyMatrix = new SolvencyMetrics();
			solvencyMatrix.setSolvencyMetricOpcode(INSERT);
			solvencyMatricsList.add(solvencyMatrix);
		}
		
		formatCurrency((DynaActionForm)form,tpLegRequest,true);
		
		ICFPLegHelper.syncFormWithLeg((DynaActionForm)form, leg, request, getServlet().getServletContext(), mapping, this);
		
		if(((DynaActionForm)cpaLegForm.get(TPLEGREQUEST)).getString(RCATransferPricingInputAction.MODEL_TYPE_ID)!=null
				&& !((DynaActionForm)cpaLegForm.get(TPLEGREQUEST)).getString(RCATransferPricingInputAction.MODEL_TYPE_ID).equals("")
				&& !((DynaActionForm)cpaLegForm.get(TPLEGREQUEST)).getString(RCATransferPricingInputAction.MODEL_TYPE_ID).equals(ONE)) {
			Integer value = Integer.valueOf(((DynaActionForm)cpaLegForm.get(TPLEGREQUEST)).getString(RCATransferPricingInputAction.MODEL_TYPE_ID));
			request.setAttribute(RCATransferPricingInputAction.MODEL_TYPE_ID, value);
		}
		
		formatCurrency((DynaActionForm)form,tpLegRequest,false);
		
		if(rateInformation.getFloatingRateIndex()==null || StringUtils.isEmpty(rateInformation.getFloatingRateIndex())){
			((DynaActionForm)form).set(INDEXTERMMAP, new HashMap<String, String>());
		}else{
			request.setAttribute(FLOATINGRATEINDEX, rateInformation.getFloatingRateIndex());
			getIndexTermData(mapping,form,request,response); 
		}
		
		ActionForward forward = null;
		EventType eventType = ICFPDay2LegHelper.getEventType(leg);
		request.setAttribute(ACTIONID, 3);
		request.setAttribute(LEGNUMBER, legNumber);
		if(eventType != null) {//Day2
			forward = mapping.findForward(DAY2LEG);
		} else {//Day1
			forward = mapping.findForward(CPALEGSUMMARY);
		}
		return forward;
	}
	
	/**
	 * This method is used to set the solvency metric opcode to the solvency metrix form.
	 * @param tpLegRequestForm
	 * @param OpCode
	 */
	public static void setSolvencyMetricOpCode(DynaActionForm tpLegRequestForm, String OpCode) {
		@SuppressWarnings("unchecked")
		List<DynaActionForm> solvencyMatrixForm = (List<DynaActionForm>) tpLegRequestForm.get(SOLVENCYMETRICS);
		for(int i=0; i<solvencyMatrixForm.size(); i++) {
			solvencyMatrixForm.get(i).set(SOLVENCYMETRICOPCODE, OpCode);
		}
	}
	
	
	
	/**
	 * applyAssesment is used to apply qualitative assessment for the all or remaining legs.
	 * @param legForm InputLegForm
	 * @param request HttpServletRequest
	 * @throws ICFPException 
	 */
	private void applyAssesment(List<QualitativeFactors> currentLegQualitativeFactors, HttpServletRequest request,String qApplyAssessment, int legNumber ) throws ICFPException {
		Integer startLegNumber = null;
		
		if (StringUtils.isNotBlank(qApplyAssessment) && ALL.equals(qApplyAssessment)) {
			startLegNumber = 1;
		} else if (StringUtils.isNotBlank(qApplyAssessment) && REMAINING.equals(qApplyAssessment)) {
			startLegNumber = 1;
		} 
		
		// If Checkbox selected
		if(startLegNumber != null) {
			for(; startLegNumber <= CurrentDealManager.getLegCount(request); startLegNumber++) {
				if(startLegNumber.equals(legNumber)) {
					continue;
				}
				if(DealManager.hideLegView(startLegNumber, request)){
					continue;
				}
				Object leg = CurrentDealManager.getLegByNumber(startLegNumber, request);
				ICFPLegHelper.applyQualitativeFactor(qApplyAssessment, leg, currentLegQualitativeFactors, 10);
			}
		}
	}
	
	/**
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HWFServiceException
	 * @throws HWFStubException
	 */
	public ActionForward getIndexTermData(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws HWFServiceException, HWFStubException {

		String floatRateIndexVal = (String)request.getParameter(FLOATINGRATEINDEX);
		String actionID  = request.getParameter(ACTIONID_SMALL);
		String legNumber = request.getParameter(LEGNUMBER);
		if(floatRateIndexVal==null || StringUtils.isEmpty(floatRateIndexVal))
		{
			floatRateIndexVal = (String)request.getAttribute(FLOATINGRATEINDEX);
		}
		
		Map<String,String> indexTermMap = new HashMap<String, String>();
		
		if(floatRateIndexVal!=null && !floatRateIndexVal.equals(""))
		{
			MasterDataFactory mdmDataFactoryObj = (MasterDataFactory) getServlet().getServletContext().getAttribute(MasterDataFactory.CTX_KEY);
			indexTermMap = mdmDataFactoryObj.getIndexTerm(floatRateIndexVal,serviceClient);
		}
		
	    ((DynaActionForm)form).set(INDEXTERMMAP, indexTermMap);
	    String productType=request.getParameter(PRODUCTTYPE);
	    request.setAttribute(ACTIONID, actionID);
		request.setAttribute(LEGNUMBER, legNumber);
		
	    if(productType!=null && productType.equals(CPA)){
	    	 return mapping.findForward(CPALEGSUMMARY);
	    }
		
	    return mapping.findForward(LEGSUMMARY);
	}
	
	/**
	 * Converts all the sovency pre transaction and solvency post transaction values to currency format
	 * @param icfpLegForm
	 * @param tpLegRequest
	 * @param objectChangeFlag
	 */
	public void formatCurrency(DynaActionForm icfpLegForm,TPLegRequest tpLegRequest,boolean objectChangeFlag)
	{
		
		if(objectChangeFlag){
			
			if(tpLegRequest.getSolvencyMetrics()!=null && tpLegRequest.getSolvencyMetrics().size()>0)
			{
				boolean changeFlag= false;
				List<SolvencyMetrics> solvencyMetrics = tpLegRequest.getSolvencyMetrics();
				if(solvencyMetrics!=null && solvencyMetrics.size()>0)
				{
					String positiveShareCapPreTran = (String) (solvencyMetrics.get(5).getPreTransaction())==null?ICFPConstants.ZERO:solvencyMetrics.get(5).getPreTransaction();
					if(positiveShareCapPreTran!=null && StringUtils.isNotEmpty(positiveShareCapPreTran) && !positiveShareCapPreTran.equals(ICFPConstants.ZERO))
					{
						positiveShareCapPreTran = ICFPCommonHelper.formatNegativeCurrency(positiveShareCapPreTran);
						solvencyMetrics.get(5).setPreTransaction(positiveShareCapPreTran);
						changeFlag = true;
					}
					
					String positiveShareCapPostTran = (String) (solvencyMetrics.get(5).getPostTransaction())==null?ICFPConstants.ZERO:solvencyMetrics.get(5).getPostTransaction();
					if(positiveShareCapPostTran!=null && StringUtils.isNotEmpty(positiveShareCapPostTran) && !positiveShareCapPostTran.equals(ICFPConstants.ZERO))
					{
						positiveShareCapPostTran = ICFPCommonHelper.formatNegativeCurrency(positiveShareCapPostTran);
						solvencyMetrics.get(5).setPostTransaction(positiveShareCapPostTran);
						changeFlag = true;
					}
					
					String positiveEquityPreTran = (String) (solvencyMetrics.get(4).getPreTransaction())==null?ICFPConstants.ZERO:solvencyMetrics.get(4).getPreTransaction();
					if(positiveEquityPreTran!=null && StringUtils.isNotEmpty(positiveEquityPreTran) && !positiveEquityPreTran.equals(ICFPConstants.ZERO))
					{
						positiveEquityPreTran = ICFPCommonHelper.formatNegativeCurrency(positiveEquityPreTran);
						solvencyMetrics.get(4).setPreTransaction(positiveEquityPreTran);
						changeFlag = true;
					}
					
					String positiveEquityPostTran = (String) (solvencyMetrics.get(4).getPostTransaction())==null?ICFPConstants.ZERO:solvencyMetrics.get(4).getPostTransaction();
					if(positiveEquityPostTran!=null && StringUtils.isNotEmpty(positiveEquityPostTran) && !positiveEquityPostTran.equals(ICFPConstants.ZERO))
					{
						positiveEquityPostTran = ICFPCommonHelper.formatNegativeCurrency(positiveEquityPostTran);
						solvencyMetrics.get(4).setPostTransaction(positiveEquityPostTran);
						changeFlag = true;
					}
					if(changeFlag)
					{
						tpLegRequest.setSolvencyMetrics(solvencyMetrics);
					}
				}
			}
			
			
		}else{

			DynaActionForm tpLegRequestForm = (DynaActionForm) icfpLegForm.get(TPLEGREQUEST);
			Double totalDebt = (tpLegRequest.getTotalDebt())==null?0:tpLegRequest.getTotalDebt();
			tpLegRequestForm.set("totalDebt",ICFPCommonHelper.formatCurrency(Double.toString(totalDebt)));

			Double totalCapital = (tpLegRequest.getTotalCapital())==null?0:tpLegRequest.getTotalCapital();
			tpLegRequestForm.set("totalCapital",ICFPCommonHelper.formatCurrency(Double.toString(totalCapital)));

			Double netIncome = (tpLegRequest.getNetIncome())==null?0:tpLegRequest.getNetIncome();
			tpLegRequestForm.set("netIncome",ICFPCommonHelper.formatNegativeCurrency(Double.toString(netIncome)));
		}
		
	
		
	}
	
	public void validateCommentsForDay2(DynaActionForm icfpLegRequestForm,ActionErrors errors)
	{
		DynaActionForm tpLegRequestForm = (DynaActionForm)icfpLegRequestForm.get(TPLEGREQUEST);
		if(tpLegRequestForm!=null){
			@SuppressWarnings("unchecked")
			ArrayList<DynaActionForm> solvencyMetricsFormList = (ArrayList<DynaActionForm>) tpLegRequestForm.get(SOLVENCYMETRICS);
			if(solvencyMetricsFormList!=null && solvencyMetricsFormList.size()>=7)
			{
				for(int i=0;i<solvencyMetricsFormList.size();i++){
					
					DynaActionForm solvencyMetricsForm = (DynaActionForm)solvencyMetricsFormList.get(i);
					String comment = solvencyMetricsForm.getString(RCATransferPricingInputAction.COMMENT2);
					String assessmentFlag = solvencyMetricsForm.getString(RCATransferPricingInputAction.ASSESSMENT_FLAG);
					String postTransaction = solvencyMetricsForm.getString(RCATransferPricingInputAction.POST_TRANSACTION);
					if(assessmentFlag!=null && assessmentFlag.equals(RCATransferPricingInputAction.FALSE) && 
							 (postTransaction !=null && !postTransaction.equals("")) &&
							(comment==null || StringUtils.isEmpty(comment)) && i<6)
					{
						
						if (errors == null) {
							errors = new ActionErrors();
						}
						String message = SOLVENCYMETRICS+i+RCATransferPricingInputAction.COMMENT2;
						errors.add(message, new ActionMessage(message , message));
					}else if (assessmentFlag!=null && assessmentFlag.equals(TRUE_SMALL) && 
							(comment==null || StringUtils.isEmpty(comment)) && i==6)
					{
						if (errors == null) {
							errors = new ActionErrors();
						}
						String message = SOLVENCYMETRICS+i+RCATransferPricingInputAction.COMMENT2;
						errors.add(message, new ActionMessage(message , message));
					}
					
				}
				
			}
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public ServiceClient getServiceClient() {
		return serviceClient;
	}

	

	/**
	 * 
	 * @param serviceClient
	 */
	public void setServiceClient(ServiceClient serviceClient) {
		this.serviceClient = serviceClient;
	}
}
