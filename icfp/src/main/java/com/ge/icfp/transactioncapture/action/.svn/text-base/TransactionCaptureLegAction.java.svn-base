/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: TransactionCaptureLegAction.java
 * Purpose: TransactionCaptureLegAction used for save leg of Deals
 */
package com.ge.icfp.transactioncapture.action;

import static com.ge.icfp.common.constants.ICFPConstants.ACTIONID;
import static com.ge.icfp.common.constants.ICFPConstants.BOTH;
import static com.ge.icfp.common.constants.ICFPConstants.CAPITAL;
import static com.ge.icfp.common.constants.ICFPConstants.CERTFYCM;
import static com.ge.icfp.common.constants.ICFPConstants.CERTFYFO;
import static com.ge.icfp.common.constants.ICFPConstants.CLOSEREQ;
import static com.ge.icfp.common.constants.ICFPConstants.CPA;
import static com.ge.icfp.common.constants.ICFPConstants.DAY2LEG;
import static com.ge.icfp.common.constants.ICFPConstants.DEAL;
import static com.ge.icfp.common.constants.ICFPConstants.EQUITY_SMALL;
import static com.ge.icfp.common.constants.ICFPConstants.ID;
import static com.ge.icfp.common.constants.ICFPConstants.IMMEDIATE_DRAWDOWN;
import static com.ge.icfp.common.constants.ICFPConstants.INDUSTRIAL;
import static com.ge.icfp.common.constants.ICFPConstants.INSERTDEAL;
import static com.ge.icfp.common.constants.ICFPConstants.ISCPA;
import static com.ge.icfp.common.constants.ICFPConstants.LEGNUMBER;
import static com.ge.icfp.common.constants.ICFPConstants.LEGSEQID;
import static com.ge.icfp.common.constants.ICFPConstants.LEG_LABEL;
import static com.ge.icfp.common.constants.ICFPConstants.MDM;
import static com.ge.icfp.common.constants.ICFPConstants.NO;
import static com.ge.icfp.common.constants.ICFPConstants.ONE;
import static com.ge.icfp.common.constants.ICFPConstants.OTHERS;
import static com.ge.icfp.common.constants.ICFPConstants.PROCEEDTONEXTLEG;
import static com.ge.icfp.common.constants.ICFPConstants.PTYPE;
import static com.ge.icfp.common.constants.ICFPConstants.RCA;
import static com.ge.icfp.common.constants.ICFPConstants.SAVE;
import static com.ge.icfp.common.constants.ICFPConstants.SAVE_LOW;
import static com.ge.icfp.common.constants.ICFPConstants.SUCCESS;
import static com.ge.icfp.common.constants.ICFPConstants.SUCCESSCPA;
import static com.ge.icfp.common.constants.ICFPConstants.TRUE;
import static com.ge.icfp.common.constants.ICFPConstants.UPDATE;
import static com.ge.icfp.common.constants.ICFPConstants.UPDATED_LABEL;
import static com.ge.icfp.common.constants.ICFPConstants.UPDATEMESSAGE;
import static com.ge.icfp.common.constants.ICFPConstants.VALIDATEVAULTREQUEST;
import static com.ge.icfp.common.constants.ICFPConstants.VAULTIDDETAILS;
import static com.ge.icfp.common.constants.ICFPConstants.VAULTIDDETAILS_SMALL;
import static com.ge.icfp.common.constants.ICFPConstants.VIEWINPUTSCREENS;
import static com.ge.icfp.common.constants.ICFPConstants.YES;
import jarjar.orgapachecommonslang.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ge.icfp.action.ICFPException;
import com.ge.icfp.common.action.FourBlockerLegAction;
import com.ge.icfp.common.attachments.validation.AttachmentValidator;
import com.ge.icfp.common.constants.ICFPConstants;
import com.ge.icfp.common.formbean.InputLegForm;
import com.ge.icfp.common.helper.CurrentDealManager;
import com.ge.icfp.common.helper.CurrentInboxManager;
import com.ge.icfp.common.helper.ICFPCommonHelper;
import com.ge.icfp.common.helper.ICFPDay2LegHelper;
import com.ge.icfp.common.helper.ICFPLegHelper;
import com.ge.icfp.common.vo.LegSummaryVO;
import com.ge.icfp.common.vo.PendingEntityVO;
import com.ge.icfp.model.CPALegRequest;
import com.ge.icfp.model.DealRequest;
import com.ge.icfp.model.DerivativesRequest;
import com.ge.icfp.model.Entity;
import com.ge.icfp.model.EquityLegRequest;
import com.ge.icfp.model.MDM;
import com.ge.icfp.model.MDM.CashPool;
import com.ge.icfp.model.MDM.VaultIDDetails;
import com.ge.icfp.model.MgmtEntity;
import com.ge.icfp.model.MsgHeader;
import com.ge.icfp.model.OtherLegRequest;
import com.ge.icfp.model.RCALegRequest;
import com.ge.icfp.tag.DealManager;
import com.ge.icfp.util.WorkflowStages;
import com.hydus.wff.core.exception.HWFServiceException;
import com.hydus.wff.core.exception.HWFStubException;
/**
 * 
 * @author madhusudhan.gosula
 *
 */
public class TransactionCaptureLegAction extends FourBlockerLegAction {

	private static final String FALSE_DATA = "falseData";
	private static final String TRUE_DATA = "trueData";
	private static final String PAGE_TRANSACTION_CAPTURE = "&page=transactionCapture";
	private static final String DETAILS = "details";
	private static final String TERM_LOAN = "TERM LOAN";
	private static final String BOND = "BOND";
	private static final String NEXT_LEG_FOCM = "nextLegFOCM";
	private static final String SUCESS_CMFO = "sucessCMFO";
	private static final String FORWARD2 = "forward";
	private static final Logger log = Logger.getLogger(TransactionCaptureLegAction.class);
	/**
	 * TRUE_FLAG
	 */
	public static final String TRUE_FLAG_STRING = ONE;
	/**
	 * FALSE_FLAG
	 */
	public static final String FALSE_FLAG_STRING = "0";

	/**
	 * 
	 */
	@Override
	public ActionForward saveLeg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HWFServiceException, HWFStubException,ICFPException {
		request.getSession().removeAttribute(VALIDATEVAULTREQUEST);
		InputLegForm legForm = (InputLegForm) form;
		updateLegSummary(legForm, request);
		DealRequest dealRequest = CurrentDealManager.getCurrentDeal(request);
		Object leg = CurrentDealManager.getLegByNumber(legForm.getLegNumber(), request);
		String forward = request.getParameter(TransactionCaptureLegAction.FORWARD2);
		if (CPA.equals(legForm.getpType())) {
			request.setAttribute(ISCPA, true);
			
		}
		if(!TRUE.equals(request.getParameter(SAVE_LOW))){
			if (TransactionCaptureLegAction.SUCESS_CMFO.equals(forward)) {
			ActionErrors errors = AttachmentValidator.getInstance().validateLeg(leg, request);
			if(!errors.isEmpty()) {
				saveErrors(request, errors);
				StringBuffer path = returnToLegSummary(mapping, legForm, legForm.getLegNumber(), true, request);
				request.setAttribute(ICFPConstants.AMTERROR,"Please fix the following fields highlighted in red.");
				return new ActionForward( path.toString() );
			}
			}
		}
		prepareMsgHeader(dealRequest, INSERTDEAL, SAVE, 22);
		dealRequest = serviceClient.invokeService(DEAL, dealRequest,
				DealRequest.class);
		dealRequest = ICFPCommonHelper.getDeal(dealRequest.getDealSeqId(), serviceClient);
		CurrentDealManager.setActiveDeal(dealRequest, request);
		
		String legSeqId = request.getParameter(LEGSEQID);
		if( org.apache.commons.lang.StringUtils.isEmpty(legSeqId) ){
			
			legSeqId = ICFPLegHelper.getLegSeqId( leg ) !=null ? String.valueOf(ICFPLegHelper.getLegSeqId( leg )):"";
		}
		
		request.setAttribute(UPDATEMESSAGE, LEG_LABEL + legSeqId + UPDATED_LABEL);

		if (TRUE.equals(request.getParameter(SAVE_LOW))) {
			StringBuffer path = returnToLegSummary(mapping, legForm, legForm.getLegNumber(), true, request);
			return new ActionForward(path.toString());
		} else {
			if (TransactionCaptureLegAction.SUCESS_CMFO.equals(forward)) {
				return mapping.findForward(forward);
			} else {
				return mapping.findForward(SUCCESS);
			}
		}
	}

	/**
	 * 
	 */
	@Override
	public ActionForward saveNextLeg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HWFServiceException, HWFStubException ,ICFPException{

		InputLegForm legForm = (InputLegForm) form;
		updateLegSummary(legForm, request);
		DealRequest dealRequest = CurrentDealManager.getCurrentDeal(request);
		CurrentDealManager.syncCommentsWithFormObject(request);
		
		Object leg = CurrentDealManager.getLegByNumber(legForm.getLegNumber(), request);
		String forward = request.getParameter(TransactionCaptureLegAction.FORWARD2);
		if (CPA.equals(legForm.getpType())) {
			request.setAttribute(ISCPA, true);
			
		}
		if (TransactionCaptureLegAction.SUCESS_CMFO.equals(forward)) {
			ActionErrors errors = AttachmentValidator.getInstance().validateLeg(leg, request);
			if(!errors.isEmpty()) {
				saveErrors(request, errors);
				StringBuffer path = returnToLegSummary(mapping, legForm, legForm.getLegNumber(), true, request);
				request.setAttribute(ICFPConstants.AMTERROR,"Please fix the following fields highlighted in red.");
				return new ActionForward( path.toString() );
			}
		}
		
		prepareMsgHeader(dealRequest, INSERTDEAL, SAVE, 22);
		dealRequest = serviceClient.invokeService(DEAL, dealRequest,
				DealRequest.class);
		dealRequest = ICFPCommonHelper.getDeal(dealRequest.getDealSeqId(), serviceClient);
		CurrentDealManager.setActiveDeal(dealRequest, request);
				
		String legSeqId = "";
		if(request.getParameter(LEGSEQID) != null ){
			legSeqId = request.getParameter(LEGSEQID);
		}
		
		if(legSeqId!=""){
			request.setAttribute(UPDATEMESSAGE, LEG_LABEL + legSeqId
					+ UPDATED_LABEL);
		}
		
		int nextLegNo = isNextLegTC( legForm, request ).intValue();
		if ( nextLegNo > 0){
			StringBuffer path = returnToLegSummary(mapping, legForm, nextLegNo, false, request);
			LegSummaryVO legSummary = (LegSummaryVO) DealManager.fetchLegSummary(nextLegNo, request);
			if (TransactionCaptureLegAction.SUCESS_CMFO.equals(forward)) {
				ActionForward actionForward = mapping.findForward(TransactionCaptureLegAction.NEXT_LEG_FOCM);
				StringBuffer path1 = new StringBuffer( actionForward.getPath() );
				path1.append("&source=transactionCapture/transactionCaptureFOCMFourBlocker&id=").append(nextLegNo).append(PTYPE).append(legSummary.getProductType());
				return new ActionForward(path1.toString());
			} else {
				path.append(PTYPE).append(legSummary.getProductType());
				return new ActionForward(path.toString());
			}
		} else {
			
			if (legForm.getpType().equals(CPA)) {
				request.setAttribute(ISCPA, true);
				return mapping.findForward(SUCCESSCPA);
			} else {
				if (TransactionCaptureLegAction.SUCESS_CMFO.equals(forward)) {
					return mapping.findForward(forward);
				} else {
					return mapping.findForward(SUCCESS);
				}
			}
		}
	}

	/**
	 * isNextLegTC is used to identify whether the next leg is available in the deal object.
	 * @param legForm InputLegForm
	 * @param request HttpServletRequest
	 * @return boolean
	 */
	protected Integer isNextLegTC(InputLegForm legForm, HttpServletRequest request){
		int totalLegs = CurrentDealManager.getCurrentDeal(request).getLegs().getAllLegs().size();
		if(legForm.getLegNumber() < totalLegs){
			String currentStage = CurrentDealManager.getCurrentDeal(request).getWFStage();
			if(CERTFYFO.equalsIgnoreCase(currentStage) || CERTFYCM.equalsIgnoreCase(currentStage)){
				return getNextLeg(legForm.getLegNumber(), request);
			}else if(CLOSEREQ.equalsIgnoreCase(currentStage)){
				if(getImmediateDrawdown(legForm, request)){
					if((legForm.getLegNumber() + 2) <= totalLegs){
						return legForm.getLegNumber() + 2;
					}else{
						return 0;
					}
				}else{
					return legForm.getLegNumber() + 1;
				}
			}
			
		}
		return 0;
	}

	/**
	 * @param legForm
	 * @param request
	 */
	private boolean getImmediateDrawdown(InputLegForm legForm,
			HttpServletRequest request) {
		Object leg = CurrentDealManager.getLegByNumber(legForm.getLegNumber() + 1, request);
		if(leg instanceof RCALegRequest){
			RCALegRequest rcaLeg = CurrentDealManager.getLegByNumber(legForm.getLegNumber() + 1, RCALegRequest.class, request);
			return IMMEDIATE_DRAWDOWN.equals(rcaLeg.getLegSummary().getTransactionEventType());
		}else if(leg instanceof CPALegRequest){
			CPALegRequest cpaLeg = CurrentDealManager.getLegByNumber(legForm.getLegNumber() + 1, CPALegRequest.class, request);
			return IMMEDIATE_DRAWDOWN.equals(cpaLeg.getCPASummary().getTransactionEventType());
		}else if(leg instanceof EquityLegRequest){
			EquityLegRequest equityLeg = CurrentDealManager.getLegByNumber(legForm.getLegNumber() + 1, EquityLegRequest.class, request);
			return IMMEDIATE_DRAWDOWN.equals(equityLeg.getLegSummary().getTransactionEventType());
		}else if(leg instanceof OtherLegRequest){
			OtherLegRequest otherLeg = CurrentDealManager.getLegByNumber(legForm.getLegNumber() + 1, OtherLegRequest.class, request);
			return IMMEDIATE_DRAWDOWN.equals(otherLeg.getLegSummary().getTransactionEventType());
		}
		return false;
	}
	
	/**
	 * Forcefully setting null. in case of Actionform populating default value
	 * for primitive type. This will avoid JAXB to generate empty tags.
	 * 
	 * @param leg
	 */
	private void updateEntities(Object leg, InputLegForm legForm) {

		List<PendingEntityVO> pEntites = legForm.getPEntities();

		List<Entity> entities = ICFPLegHelper.getEntityList(leg);

		for (ListIterator<Entity> item = entities.listIterator(); item
				.hasNext();) {

			Entity entity = item.next();

			if (ICFPConstants.N_CAP.equals(entity.getEntitySetupFlag()))
				continue;

			for (PendingEntityVO pEntity : pEntites) {

				if (entity.getLeTypeId().equals(pEntity.getLeTypeId())) {

					pEntity.setEntitySetupFlag(ICFPConstants.N_CAP);
					if (pEntity.getFundHoldOperationId() != null
							&& 0 == pEntity.getFundHoldOperationId()) {
						pEntity.setFundHoldOperationId(null);
					}
					item.set(pEntity.getEntity());
				}
			}

		}
	}

	/**
	 * 
	 */
	protected void updateLegSummary(InputLegForm legForm,
			HttpServletRequest request)throws HWFServiceException, HWFStubException,ICFPException {
		Integer tCaptureIn = legForm.getSelectedTransactionCapturedIn();
		String transactionId = legForm.getTransactionId();

		String pType = legForm.getpType();

		if (RCA.equalsIgnoreCase(pType) || TransactionCaptureLegAction.BOND.equalsIgnoreCase(pType)
				|| TransactionCaptureLegAction.TERM_LOAN.equalsIgnoreCase(pType)) {
			RCALegRequest leg = CurrentDealManager.getCurrentLeg(
					RCALegRequest.class, request);
			updateEntities(leg, legForm);
			udpateTCode(legForm, leg.getLegSummary().getEntities(), request);
			if(tCaptureIn != null && tCaptureIn.intValue() != 0)
			{
				leg.getLegSummary().setTransactionCaptureInId(tCaptureIn);	
			}else{
				leg.getLegSummary().setTransactionCaptureInId(null);
			}
			leg.getLegSummary().setTransactionId(transactionId);
			leg.getLegSummary().setComments(legForm.getlComments());
			if (legForm.getFacilityId() != null) {
				leg.getLegSummary().setInstrumentId(legForm.getFacilityId());
			}
			updateTradeRequestWorkflowId(legForm, leg.getLegSummary()
					.getDerivativesRequests());
			updateDerivativeTradeID(legForm, leg.getLegSummary()
					.getDerivativesRequests());

			String opcode = ICFPLegHelper.getOpCode(leg);
			Integer legSeqId = ICFPLegHelper.getLegSeqId(leg);
			if (legSeqId != null && opcode == null) {
				ICFPLegHelper.setOpCodeFlag(leg, UPDATE);
			}
		} else if (EQUITY_SMALL.equalsIgnoreCase(pType)) {
			EquityLegRequest equityLeg = CurrentDealManager.getCurrentLeg(
					EquityLegRequest.class, request);
			updateEntities(equityLeg, legForm);
			udpateTCode(legForm, equityLeg.getLegSummary().getEntities(),
					request);
			if(tCaptureIn != null && tCaptureIn.intValue() != 0)
			{
			  equityLeg.getLegSummary().setTransactionCaptureInId(tCaptureIn);
			}else{
				equityLeg.getLegSummary().setTransactionCaptureInId(null);
			}
			equityLeg.getLegSummary().setTransactionId(transactionId);
			equityLeg.getLegSummary().setComments(legForm.getlComments());
			String opcode = ICFPLegHelper.getOpCode(equityLeg);
			Integer legSeqId = ICFPLegHelper.getLegSeqId(equityLeg);
			if (legSeqId != null && opcode == null) {
				ICFPLegHelper.setOpCodeFlag(equityLeg, UPDATE);
			}
		} else if (OTHERS.equalsIgnoreCase(pType)) {
			OtherLegRequest otherLeg = CurrentDealManager.getCurrentLeg(
					OtherLegRequest.class, request);
			updateEntities(otherLeg, legForm);
			udpateTCode(legForm, otherLeg.getLegSummary().getEntities(),
					request);
			if(tCaptureIn != null && tCaptureIn.intValue() != 0)
			{
			 otherLeg.getLegSummary().setTransactionCaptureInId(tCaptureIn);
			}else{
				otherLeg.getLegSummary().setTransactionCaptureInId(null);
			}
			otherLeg.getLegSummary().setTransactionId(transactionId);
			otherLeg.getLegSummary().setComments(legForm.getlComments());
			
			updateTradeRequestWorkflowId(legForm, otherLeg.getLegSummary()
					.getDerivativesRequests());
			updateDerivativeTradeID(legForm, otherLeg.getLegSummary()
					.getDerivativesRequests());
			
			String opcode = ICFPLegHelper.getOpCode(otherLeg);
			Integer legSeqId = ICFPLegHelper.getLegSeqId(otherLeg);
			if (legSeqId != null && opcode == null) {
				ICFPLegHelper.setOpCodeFlag(otherLeg, UPDATE);
			}
		} else if (CPA.equalsIgnoreCase(pType)) {
			CPALegRequest cpaLeg = CurrentDealManager.getCurrentLeg(
					CPALegRequest.class, request);
			updateEntities(cpaLeg, legForm);
			udpateCPATCode(legForm, cpaLeg.getCPASummary().getEntities(),
					request);
			if(tCaptureIn != null && tCaptureIn.intValue() != 0)
			{
			cpaLeg.setTransactionCapturedInId(String.valueOf(tCaptureIn));
			cpaLeg.getCPASummary().setTransactionCaptureIn(
					String.valueOf(tCaptureIn));
			}else{
				cpaLeg.setTransactionCapturedInId(null);
				cpaLeg.getCPASummary().setTransactionCaptureIn(null);
			}
			cpaLeg.getCPASummary().setBnkName(legForm.getBankName());
			cpaLeg.getCPASummary().setSubLedgerTransactionId(transactionId);
			cpaLeg.setComments(legForm.getlComments());
			String vaultID = legForm.getVaultId();
			
			if(vaultID!=null && StringUtils.isNotEmpty(vaultID))
			{
				DealRequest dealRequest = CurrentDealManager.getCurrentDeal(request);
				dealRequest.setVaultId(vaultID);
				
				boolean vaultMatchFlag = getVaultMatchFlag(vaultID,dealRequest);
				if(vaultMatchFlag){ 
					cpaLeg.getCPASummary().setInlineFlag(TRUE_FLAG_STRING); 
				}else{
					cpaLeg.getCPASummary().setInlineFlag(FALSE_FLAG_STRING); 
				}
				
			}

			String opcode = ICFPLegHelper.getOpCode(cpaLeg);
			Integer legSeqId = ICFPLegHelper.getLegSeqId(cpaLeg);
			if (legSeqId != null && opcode == null) {
				ICFPLegHelper.setOpCodeFlag(cpaLeg, UPDATE);
			}
		}

	}

	/**
	 * 
	 * @param legForm
	 * @param deal
	 */
	private void updateDerivativeTradeID(InputLegForm legForm,
			List<DerivativesRequest> derivativesRequestList) {

		String tradeId[] = legForm.getDerivativeTradeId();

		if (derivativesRequestList != null && tradeId != null
				&& derivativesRequestList.size() > 0 && tradeId.length > 0) {
			for (int i = 0; i < derivativesRequestList.size(); i++) {
				DerivativesRequest derivativesRequest = derivativesRequestList
						.get(i);
				derivativesRequest.setDerivativesTradeId(tradeId[i]);
				derivativesRequest.setDerivativesOpcode(UPDATE);
			}
		}

	}

	/**
	 * 
	 * @param legForm
	 * @param entities
	 */
	protected void udpateTCode(InputLegForm legForm, List<Entity> entities,
			HttpServletRequest request) {
		String LTCode = "";
		if(legForm.getLenderTCode()!=null){
			LTCode = legForm.getLenderTCode().toUpperCase();
		}
		
		String BTCode = "";
		if(legForm.getBorrowerTCode()!=null){
			BTCode = legForm.getBorrowerTCode().toUpperCase();
		}
		String stageName = CurrentInboxManager.getCurrentWorkflowStage(request);

		if (!WorkflowStages.CLOSEREQ.name().equals(stageName))
			return;

		List<Integer> lenderList = new ArrayList<Integer>();
		lenderList.add(1);
		lenderList.add(14);
		lenderList.add(9);
		List<Integer> borList = new ArrayList<Integer>();
		borList.add(2);
		borList.add(15);
		borList.add(10);
		
		
		for (Entity ent : entities) {

			if (!"".equals(BTCode) && ent.getLeTypeId() != null
					&& borList.contains(ent.getLeTypeId())) {
				ent.setBankTreasuryCd(BTCode);
				ent.getTreasuryCodes().clear();
				ent.getTreasuryCodes().add(BTCode);
			} else if (!"".equals(LTCode) && ent.getLeTypeId() != null
					&& lenderList.contains(ent.getLeTypeId())) {
				ent.setBankTreasuryCd(LTCode);
				ent.getTreasuryCodes().clear();
				ent.getTreasuryCodes().add(LTCode);
			}
			if(org.apache.commons.lang.StringUtils.isBlank(BTCode) && borList.contains(ent.getLeTypeId())){
				ent.getTreasuryCodes().clear();
			}else if(org.apache.commons.lang.StringUtils.isBlank(LTCode) && lenderList.contains(ent.getLeTypeId())){
				ent.getTreasuryCodes().clear();
			}

		}

	}

	/**
	 * Updates the trade request workflow id.
	 * 
	 * @param legForm
	 * @param derivativesRequestList
	 */
	protected void updateTradeRequestWorkflowId(InputLegForm legForm,
			List<DerivativesRequest> derivativesRequestList) {
		String[] tradeRequestWorkflowIDList = legForm
				.getTradeRequestWorkflowId();

		if (derivativesRequestList != null
				&& tradeRequestWorkflowIDList != null
				&& derivativesRequestList.size() > 0
				&& tradeRequestWorkflowIDList.length > 0) {
			for (int i = 0; i < derivativesRequestList.size(); i++) {
				DerivativesRequest derivativesRequest = derivativesRequestList
						.get(i);
				derivativesRequest
						.setTradeRequestWorkflowId(tradeRequestWorkflowIDList[i]);
				derivativesRequest.setDerivativesOpcode(UPDATE);
			}
		}

	}

	/**
	 * 
	 * @param legForm
	 * @param entities
	 */
	protected void udpateCPATCode(InputLegForm legForm, List<Entity> entities,
			HttpServletRequest request) {

		String[] LTCode = legForm.getLenderCPATCode();
		String[] BTCode = legForm.getBorrowerCPATCode();
		List<String> ltList = new ArrayList<String>();
		List<String> btList = new ArrayList<String>();

		if(LTCode!=null){
			for(String s : LTCode){
				if(StringUtils.isNotEmpty(s))
					ltList.add(s);
			}
		}

		if(BTCode!=null){
			for(String s2: BTCode){
				if(StringUtils.isNotEmpty(s2))
					btList.add(s2);
			}
		}

		String stageName = CurrentInboxManager.getCurrentWorkflowStage(request);
		if (!WorkflowStages.CLOSEREQ.name().equals(stageName))
			return;

		for (Entity ent : entities) {

			if ( ent.getLeTypeId() != null
					&& ent.getLeTypeId() == 8) {				
				ent.getTreasuryCodes().clear();
				ent.getTreasuryCodes().addAll( btList );
			} else if ( ent.getLeTypeId() != null
							&& ent.getLeTypeId() == 7) {				
				ent.getTreasuryCodes().clear();
				ent.getTreasuryCodes().addAll( ltList );
			}

		}

	}
	
	/**
	 * This function returns validateVaultRequest flag as true if given vault id
	 * matches with participant and pool details.
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward getVaultDetailValidationFlag(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws HWFServiceException, HWFStubException,ICFPException {
		request.getSession().removeAttribute(VALIDATEVAULTREQUEST);
		InputLegForm legForm = (InputLegForm) form;
		legForm.setpType(CPA);
		DealRequest dealRequest = CurrentDealManager.getCurrentDeal(request);

		String vaultID = request.getParameter(VAULTIDDETAILS_SMALL);
		String legNumber = request.getParameter(LEGNUMBER);
		boolean valutDetailsMatchFlag = false;
		if(vaultID!=null && StringUtils.isNotEmpty(vaultID)){

			valutDetailsMatchFlag = getVaultMatchFlag(vaultID,dealRequest);
			dealRequest.setVaultId( vaultID );
		}
		request.setAttribute(ID, legNumber);
		StringBuffer path = returnToLegSummary(mapping, legForm, legForm.getLegNumber(), true, request);
		if(path!=null && StringUtils.isNotEmpty(path.toString()))
		{
		   path.append(TransactionCaptureLegAction.PAGE_TRANSACTION_CAPTURE);	
		}
		if(valutDetailsMatchFlag){
		   request.setAttribute(TransactionCaptureLegAction.DETAILS,TransactionCaptureLegAction.TRUE_DATA);
		}else{
			request.setAttribute(TransactionCaptureLegAction.DETAILS,TransactionCaptureLegAction.FALSE_DATA);
		}
		
		return new ActionForward( path.toString() );
	}
	
	/**
	 * Return true if given vaultID matches with the avilable participant and pool information. 
	 * 
	 * @param vaultID
	 * @param dealRequest
	 * @return
	 * @throws HWFServiceException
	 * @throws HWFStubException
	 * @throws ICFPException
	 */
	public boolean getVaultMatchFlag(String vaultID, DealRequest dealRequest)throws HWFServiceException, HWFStubException,ICFPException
	{
		if(vaultID!=null && StringUtils.isNotEmpty(vaultID)){

			ICFPCommonHelper icfpCommonHelper = new ICFPCommonHelper();
			
			boolean valutDetailsMatchFlag = icfpCommonHelper.validateVaultRequestID(dealRequest,serviceClient,vaultID);
			
			return valutDetailsMatchFlag;
		}
		
		return false;
	}
	
	/**
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward getVaultDetails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		String vaultID = (String)request.getParameter(VAULTIDDETAILS_SMALL);
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
		List<VaultIDDetails> resultVaultDetails = null;
		if(mdm != null){
			resultVaultDetails = mdm.getVaultIDDetails();
		}
	
		List<Entity> entitiesList = mdm.getEntities();
		InputLegForm inputForm = (InputLegForm) request.getSession().getAttribute("inputform");
		if(inputForm == null){
			inputForm = new InputLegForm();
			request.getSession().setAttribute("inputform", inputForm);
		}
		
		List<PendingEntityVO> pEntityList = inputForm.getPEntities();
		
		
		if(entitiesList!=null && entitiesList.size() > 0)
		{	
			/*
			 * Service returned the entitiesList object with the order maintained
			 * where first item is participant and second item is pool leader  
			 */
			for(int i=0;i<entitiesList.size();i++)
			{
				if(i==0)
				{
					Entity entityObj = entitiesList.get(0);
					List<MgmtEntity> managementEntityList = mdm.getMgmtEntities();
					
					if(managementEntityList!=null && managementEntityList.size()>0){
						MgmtEntity mgmtEntityObj = managementEntityList.get(0);
						if(mgmtEntityObj!=null){
						  entityObj.setMEName(mgmtEntityObj.getName());
						}
					}
					
					boolean isUpdated = false;
					for(int k=0;k < pEntityList.size(); k++){
						PendingEntityVO orig_pEntity = pEntityList.get(k);
						if( 7 == orig_pEntity.getLeTypeId() ){
							PendingEntityVO pEntity = new PendingEntityVO( entityObj );
							isUpdated = true;
							pEntity.setLeTypeId(7);
							pEntity.setLegalEntitySeqId(orig_pEntity.getLegalEntitySeqId());
							pEntityList.set(k, pEntity);
						}
					}
					
					if( !isUpdated){
						pEntityList.add( new PendingEntityVO( entityObj) );
					}
										
				}else if (i==1)
				{
					Entity entityBean = new Entity();
					Entity serviceEntity = entitiesList.get(1);
					List<CashPool> cashPoolList = mdm.getCashPools();
					if(cashPoolList!=null && cashPoolList.size()>0){
							CashPool cashPoolObj = cashPoolList.get(0);
							entityBean.setCDRCd(serviceEntity.getCDRCd());
							entityBean.setCapitalIndustrial(serviceEntity.getCapitalIndustrial());
							entityBean.setLeType(serviceEntity.getCapitalIndustrial());
							entityBean.setLEName(cashPoolObj.getLegalEntity());
							entityBean.setLEGoldId(cashPoolObj.getLEGoldID());
							entityBean.setLeTypeId(8);
							entityBean.setCountry(serviceEntity.getCountry());
							String countryCode = cashPoolObj.getCountry();
							entityBean.setRegulatedEntityFlag(serviceEntity.isRegulatedEntityFlag());
							entityBean.setPrincplEntityFlag(serviceEntity.isPrincplEntityFlag());
							entityBean.setMEName(cashPoolObj.getManagementEntity());
							
							if(entityBean.getCapitalIndustrial()!=null && entityBean.getCapitalIndustrial().equals(CAPITAL))
							{
								entityBean.setLeCategoryId(1);
							}else if(entityBean.getCapitalIndustrial()!=null && entityBean.getCapitalIndustrial().equals(INDUSTRIAL))
							{
								entityBean.setLeCategoryId(2);
							}else if(entityBean.getCapitalIndustrial()!=null && entityBean.getCapitalIndustrial().equals(BOTH))
							{
								entityBean.setLeCategoryId(3);
							}else{
								entityBean.setLeCategoryId(null);
							}
							entityBean.setBankTreasuryCd(cashPoolObj.getBankName());
							entityBean.setBusinessSegment(cashPoolObj.getBusinessSegment());
							
							boolean isUpdated = false;
							for(int k=0; k< pEntityList.size(); k++){
								PendingEntityVO orig_pEntity = pEntityList.get(k);
								if( 8 == orig_pEntity.getLeTypeId() ){
									PendingEntityVO pEntity = new PendingEntityVO( entityBean );
									isUpdated = true;
									pEntity.setLegalEntitySeqId(orig_pEntity.getLegalEntitySeqId());
									pEntity.setLeTypeId(8);
									pEntityList.set(k, pEntity);
								}
							}
							
							if( !isUpdated){
								pEntityList.add( new PendingEntityVO( entityBean) );
							}
						}
					
				}
			}
			
			request.setAttribute(ICFPConstants.VAULT_LOOKUP, Boolean.TRUE);
		}else{
			request.setAttribute(ICFPConstants.ERROR_VAULT, Boolean.TRUE);
		}
		
		String proceedtoNextLeg = NO;
		ActionForward forward=null;
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		int legNumberInt = inputForm.getLegNumber();
		
		if(legNumberInt == deal.getLegs().getAllLegs().size()){
			proceedtoNextLeg = YES;
		}
		Object leg = CurrentDealManager.getLegByNumber(legNumberInt, request);
		
		request.setAttribute(PROCEEDTONEXTLEG, proceedtoNextLeg);
		request.setAttribute(LEGNUMBER, legNumberInt);
		String actionId = request.getParameter(ACTIONID);
		request.setAttribute(ACTIONID, actionId);
		request.setAttribute(ICFPConstants.SOURCE, request.getParameter(ICFPConstants.SOURCE));
		request.setAttribute(LEGSEQID, request.getParameter(LEGSEQID));
		request.setAttribute(ICFPConstants.P_TYPE, request.getParameter(ICFPConstants.P_TYPE));
		if(ICFPDay2LegHelper.isDay2Leg(leg)){
			 request.setAttribute(LEGNUMBER, legNumberInt);
			 forward = mapping.findForward(DAY2LEG);
			 
		}else{
			forward=mapping.findForward(VIEWINPUTSCREENS);
		}
		
	return forward;
		
	}
	
}
