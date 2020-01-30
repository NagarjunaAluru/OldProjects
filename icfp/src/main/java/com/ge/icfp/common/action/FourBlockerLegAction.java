/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: FourBlockerLegAction.java
 * Purpose: FourBlockerLegAction used for all the input leg screen actions.
 */
package com.ge.icfp.common.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ge.icfp.action.ICFPBaseAction;
import com.ge.icfp.action.ICFPException;
import com.ge.icfp.common.attachments.validation.AttachmentValidator;
import com.ge.icfp.common.formbean.InputLegForm;
import com.ge.icfp.common.helper.CurrentDealManager;
import com.ge.icfp.common.helper.ICFPCommonHelper;
import com.ge.icfp.common.helper.ICFPDay2LegHelper;
import com.ge.icfp.common.helper.ICFPLegHelper;
import com.ge.icfp.common.vo.LegSummaryVO;
import com.ge.icfp.model.CPALegRequest;
import com.ge.icfp.model.DealRequest;
import com.ge.icfp.model.EquityLegRequest;
import com.ge.icfp.model.MsgHeader;
import com.ge.icfp.model.OtherLegRequest;
import com.ge.icfp.model.QualitativeFactors;
import com.ge.icfp.model.RCALegRequest;
import com.ge.icfp.tag.DealManager;
import com.ge.icfp.util.EventType;
import com.ge.icfp.util.Utils;

import com.hydus.wff.common.bw.ServiceClient;
import com.hydus.wff.core.context.UserContext;
import com.hydus.wff.core.exception.HWFServiceException;
import com.hydus.wff.core.exception.HWFStubException;
import static com.ge.icfp.common.constants.ICFPConstants.*;
/**
 * Common Action class used for all types of Leg Screen, except for Front office 
 *
 * @author madhusudhan.gosula
 *
 */
public class FourBlockerLegAction extends ICFPBaseAction {
	private static final String ATMT_ERROR = "atmtError";
	private static final String COMMAND_LEG_DETAILS_ID = "command=legDetails&id=";
	private static final String NEXT_LEG = "nextLeg";
	/**
	 * serviceClient
	 */
	protected ServiceClient serviceClient;
	
	private int actionId;

	/**
	 * @return the serviceClient
	 */
	public ServiceClient getServiceClient() {
		return serviceClient;
	}

	/**
	 * @param serviceClient the serviceClient to set
	 */
	public void setServiceClient(ServiceClient serviceClient) {
		this.serviceClient = serviceClient;
	}
	/**
	 * Invoke the service to save the leg object.
	 *
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return success forward to the appropriate page.
	 * @throws HWFServiceException if ant thing happens.
	 * @throws HWFStubException 
	 * @throws ICFPException 
	 */
	public ActionForward saveLeg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HWFServiceException, HWFStubException, ICFPException {

		InputLegForm legForm = (InputLegForm) form;
		applyAssesment( legForm, request );
		DealRequest dealRequest = CurrentDealManager.getCurrentDeal(request);
		CurrentDealManager.syncCommentsWithFormObject(request);
		
		Integer legNumber = legForm.getLegNumber();
		Object leg = CurrentDealManager.getLegByNumber(legNumber, request);
		if(leg instanceof EquityLegRequest) {
			EquityLegRequest equityLeg = (EquityLegRequest) leg;
			EventType eventType = ICFPDay2LegHelper.getEventType(equityLeg);
			if (eventType != null) {
				String comment = request.getParameter(OTHEREQUITYCOMMENTS);
				equityLeg.setOtherEquityComments(comment);
			}
		}
		
		String requestID = dealRequest.getDealSeqId().toString();
		
		if(!TRUE.equals(request.getParameter(SAVE_LOW))){
			ActionErrors errors = AttachmentValidator.getInstance().validateLeg(leg, request);
			if(!errors.isEmpty()) {
				saveErrors(request, errors);
				StringBuffer path = returnToLegSummary(mapping, legForm, legForm.getLegNumber(), true, request);
				request.setAttribute(ATMT_ERROR,"Please fix the following fields highlighted in red.");
				return new ActionForward( path.toString() );
			}
		}
		
		prepareMsgHeader(dealRequest, INSERTDEAL, SAVE,22);
		dealRequest = serviceClient.invokeService(DEAL, dealRequest, DealRequest.class);
		
		dealRequest = ICFPCommonHelper.getDeal(Integer.valueOf(requestID), serviceClient);
		CurrentDealManager.setActiveDeal(dealRequest, request);
		
		Boolean isEquityDeal = CurrentDealManager.isEquityDeal(request);
		request.setAttribute(ISEQUITY,isEquityDeal);
		
		String legSeqId = "";
		if(request.getParameter(LEGSEQID) != null ){
			legSeqId = request.getParameter(LEGSEQID);
		}
		request.setAttribute(UPDATEMESSAGE,LEG_LABEL+ legSeqId + UPDATED_LABEL);
		if(TRUE.equals(request.getParameter(SAVE_LOW))){
			StringBuffer path = returnToLegSummary(mapping, legForm, legForm.getLegNumber(), true, request);
			return new ActionForward( path.toString() );
		}
		else{
			if(legForm.getpType().equals(CPA)){
				request.setAttribute(ISCPA,true);
				return mapping.findForward(SUCCESSCPA);
			}else{
				return mapping.findForward(SUCCESS);
			}
		}
		
	}
	
	/**
	 * Returns the appropirate action path based on leg type
	 *
	 * @param mapping
	 * @param legForm
	 * @return
	 */
	protected StringBuffer returnToLegSummary(ActionMapping mapping,
			InputLegForm legForm, int nextLegNo, boolean isSameLeg, HttpServletRequest request) {
		String forward = null;
		ActionForward actionForward = new ActionForward();
		StringBuffer path = null;
		forward = NEXT_LEG;
		actionForward = mapping.findForward( forward );
		path = new StringBuffer( actionForward.getPath() );
		boolean isQuery = ( path.indexOf( "?" ) >= 0 );
		if( isQuery )
		{
		path.append( ID_LABEL );
		if(isSameLeg == true){
			path.append( nextLegNo );
		}else{
			path.append( nextLegNo );
		}
		if(legForm.getpType().equals(CPA)){
			path.append( PTYPE );
			path.append( legForm.getpType());
		}
		}
		else
		{
		path.append( COMMAND_LEG_DETAILS_ID );
		if(isSameLeg == true){
			path.append( nextLegNo );
		}else{
			path.append( nextLegNo );
		}
		if(legForm.getpType().equals(CPA)){
			path.append( PTYPE );
			path.append( legForm.getpType());
		}
		}
		return path;
	}
	/**
	 * prepareMsgHeader is use to set the Message header opcode to the deal request object.
	 * @param dealRequest DealRequest
	 * @param opcode String
	 * @param action String
	 * @param actionId int
	 */
	protected void prepareMsgHeader(DealRequest dealRequest, String opcode, String action, int actionId) {
		MsgHeader msgHeader = new MsgHeader();
		msgHeader.setOpcode(opcode);
		String userId = UserContext.getCurrentUserContext().getId();
		msgHeader.setAuditCreator(userId);
		msgHeader.setAuditModifier(userId);
		msgHeader.setAuditCreatorFirstName(UserContext.getCurrentUserContext().getFirstName());
		msgHeader.setAuditCreatorLastName(UserContext.getCurrentUserContext().getLastName());
		msgHeader.setAuditModifierFirstName(UserContext.getCurrentUserContext().getFirstName());
		msgHeader.setAuditModifierLastName(UserContext.getCurrentUserContext().getLastName());
		dealRequest.setActionId(actionId);
		dealRequest.setMsgHeader(msgHeader);
		
		if(action!=null && action.trim().length()>0){
		 dealRequest.setAction(action);
		}
		
		dealRequest.setTransOwnerSsoId(userId);
	}
	/**
	 * cancelLeg is used to navigate the previous page.
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return success forward to the previous page.
	 */
	public ActionForward cancelLeg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		
		return mapping.findForward(SUCCESS);
	}
	/**
	 * saveNextLeg is used to save the current leg open the next leg.
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return success forward to the appropriate page.
	 * @throws HWFServiceException if any thing happens.
	 * @throws HWFStubException 
	 * @throws ICFPException 
	 */
	public ActionForward saveNextLeg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws HWFServiceException, HWFStubException, ICFPException{
		
		InputLegForm legForm = (InputLegForm) form;
		
		applyAssesment( legForm, request );
		DealRequest dealRequest = CurrentDealManager.getCurrentDeal(request);
		CurrentDealManager.syncCommentsWithFormObject(request);
		
		String requestID = dealRequest.getDealSeqId().toString();
		
		Integer legNumber = legForm.getLegNumber();
		Object leg = CurrentDealManager.getLegByNumber(legNumber, request);
		
		ActionErrors errors = AttachmentValidator.getInstance().validateLeg(leg, request);
		if(!errors.isEmpty()) {
			saveErrors(request, errors);
			StringBuffer path = returnToLegSummary(mapping, legForm, legForm.getLegNumber(), true, request);
			request.setAttribute(ATMT_ERROR,"Please fix the following fields highlighted in red.");
			return new ActionForward( path.toString() );
		}
		
		prepareMsgHeader(dealRequest, INSERTDEAL, SAVE,22);
		dealRequest = serviceClient.invokeService(DEAL, dealRequest, DealRequest.class);
		
		dealRequest = ICFPCommonHelper.getDeal(Integer.valueOf(requestID), serviceClient);
		CurrentDealManager.setActiveDeal(dealRequest, request);
		String legSeqId = "";
		if(request.getParameter(LEGSEQID) != null ){
			legSeqId = request.getParameter(LEGSEQID);
		}
		request.setAttribute(UPDATEMESSAGE,LEG_LABEL+ legSeqId + UPDATED_LABEL);
		int nextLegNo = isNextLeg( legForm, request ).intValue();
		Boolean isEquityDeal = CurrentDealManager.isEquityDeal(request);
		request.setAttribute(ISEQUITY,isEquityDeal);
		
		if ( nextLegNo > 0){
			StringBuffer path = returnToLegSummary(mapping, legForm, nextLegNo, false, request);
			LegSummaryVO legSummary = (LegSummaryVO) DealManager.fetchLegSummary(nextLegNo, request);
			if(EQUITY.equalsIgnoreCase(legSummary.getProductType())){
				path.append(PTYPE).append(legSummary.getProductType());
			}
			return new ActionForward( path.toString() );
		}else{
			if(legForm.getpType().equals(CPA)){
				request.setAttribute(ISCPA,true);
				return mapping.findForward(SUCCESSCPA);
			}else{
				return mapping.findForward(SUCCESS);
			}
		}
		
	}
	/**
	 * isNextLeg is used to identify whether the next leg is available in the deal object.
	 * @param legForm InputLegForm
	 * @param request HttpServletRequest
	 * @return boolean
	 */
	protected Integer isNextLeg(InputLegForm legForm, HttpServletRequest request){
		if(legForm.getLegNumber() < CurrentDealManager.getCurrentDeal(request).getLegs().getAllLegs().size()){
			return getNextLeg(legForm.getLegNumber(), request);
		}
		return 0;
	}
	/**
	 * @param legForm
	 * @param request
	 * @return
	 */
	protected Integer getNextLeg(Integer legNumber, HttpServletRequest request) {
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
	 * Add/Update the qualitative factors. If the factor exists it will update or will 
	 * create new factor  
	 * 
	 * @param factors List
	 * @param legForm InputLegForm
	 */
	
	private static void updateCurrQualitativeFactors(List<QualitativeFactors> factors, InputLegForm legForm) {

		if (legForm.getqFactorId() == null)
			return;
		
		String factorIdStr = StringUtils.trim(legForm.getqFactorId());
		Integer factorId = new Integer( factorIdStr );
		
		boolean isUpdated = false;

		for (QualitativeFactors factor : factors) {

			if (factor.getQualitativeFactorId().equals(factorId)) {
				factor.setQualitativeFactorOpcode(UPDATE);
				factor.setQualitativeFactorId( factorId );
				populateQualitativeFactors(factor, legForm);
				isUpdated = true;
			}
		}
		
		if( !isUpdated ){
			QualitativeFactors factor =  new QualitativeFactors();
			factor.setQualitativeFactorOpcode(INSERT);
			populateQualitativeFactors(factor, legForm);
			factor.setQualitativeFactorId( factorId );
			factors.add( factor );
		}
		
	}
	
	/**
	 * updateQualitativeFactors
	 * @param factor
	 * @param legForm
	 */
	private static void populateQualitativeFactors( QualitativeFactors factor, InputLegForm legForm){
		
		String assessment = legForm.getqAssessment();
		
		if( assessment == null){//set it to Low
			factor.setAssessmentId( 3 );
		}else{
			Integer assessmentInt = new Integer( assessment );
			factor.setAssessmentId( assessmentInt );
		}
		factor.setQualitativeFactorId(Integer.valueOf(legForm.getqFactorId()));
		factor.setComment(legForm.getRationale());
		String ownerSsoId = UserContext.getCurrentUserContext().getId();
		factor.setOwnerSso(ownerSsoId);
		
	}

	/**
	 * applyAssesment is used to apply qualitative assessment for the all or remaining legs.
	 * @param legForm InputLegForm
	 * @param request HttpServletRequest
	 * @throws ICFPException 
	 */
	private void applyAssesment( InputLegForm legForm, HttpServletRequest request ) throws ICFPException {
		Integer legNumber = legForm.getLegNumber();
		Object leg = CurrentDealManager.getLegByNumber(legNumber, request);
		boolean isCPA = (leg instanceof CPALegRequest);
		String legSummaryProperty = (isCPA) ? CPASUMMARY : LEGSUMMARY;
		
		Object legSummary = Utils.fetchPropertyValue(legSummaryProperty, leg, Object.class);
		@SuppressWarnings("unchecked")
		List<QualitativeFactors> qualitativeFactors = Utils.fetchPropertyValue(QUALITATIVEFACTORS, legSummary, List.class);
		updateCurrQualitativeFactors(qualitativeFactors, legForm);
		ICFPLegHelper.setOpCodeFlag(leg, UPDATE);
		setLegComments(leg,legForm);
		
		String qApplyAssessment = legForm.getqApplyAssessment();
		Integer startLegNumber = null;
		if (ALL.equals(qApplyAssessment) || REMAINING.equals(qApplyAssessment)) {
			startLegNumber = 1;
		}
		
		if(startLegNumber != null) {
			QualitativeFactors newQualitativeFactors = new QualitativeFactors();
			populateQualitativeFactors(newQualitativeFactors, legForm);
			List<QualitativeFactors> newQualitativeFactorsList = new ArrayList<QualitativeFactors>();
			newQualitativeFactorsList.add(newQualitativeFactors);
			Integer factorId = new Integer(legForm.getqFactorId());
			for(; startLegNumber <= CurrentDealManager.getLegCount(request); startLegNumber++) {
				if(startLegNumber.equals(legNumber)) {
					continue;
				}
				if(DealManager.hideLegView(startLegNumber, request)){
					continue;
				}
				Object legToApply = CurrentDealManager.getLegByNumber(startLegNumber, request);
				ICFPLegHelper.applyQualitativeFactor(qApplyAssessment, legToApply, newQualitativeFactorsList, factorId);
			}
		}
	}
	/**
	 * Update the comments entered in the screen into Leg Object
	 * @param leg
	 * @param legForm
	 */
	private void setLegComments(Object leg, InputLegForm legForm) {
		if(leg instanceof RCALegRequest) {
			RCALegRequest rcaLeg = (RCALegRequest) leg;
				rcaLeg.getLegSummary().setComments(legForm.getlComments());
		} else if(leg instanceof EquityLegRequest) {
			EquityLegRequest equityLeg = (EquityLegRequest) leg;
				equityLeg.getLegSummary().setComments(legForm.getlComments());
		} else if(leg instanceof OtherLegRequest) {
			OtherLegRequest otherLeg = (OtherLegRequest) leg;
				otherLeg.getLegSummary().setComments(legForm.getlComments());
		} else if(leg instanceof CPALegRequest) {
			CPALegRequest cpaLeg = (CPALegRequest) leg;
				cpaLeg.setComments(legForm.getlComments());
		}
	}
	/**
	 * 
	 * @return
	 */
	public int getActionId() {
		return actionId;
	}
	/**
	 * 
	 * @param actionId
	 */
	public void setActionId(int actionId) {
		this.actionId = actionId;
	}
	
}
