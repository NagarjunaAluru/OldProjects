/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: FOCPALegAction.java
 * Purpose:FOCPALegAction used for the all leg and deal operations of CPA Front office
 */
package com.ge.icfp.frontoffice.action;

import jarjar.orgapachecommonslang.StringUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import com.ge.icfp.common.attachments.validation.AttachmentValidator;
import com.ge.icfp.common.constants.ICFPConstants;
import com.ge.icfp.common.helper.CurrentDealManager;
import com.ge.icfp.common.helper.ICFPCommonHelper;
import com.ge.icfp.common.helper.ICFPDay2LegHelper;
import com.ge.icfp.common.helper.ICFPLegHelper;
import com.ge.icfp.common.legs.action.CPALegAction;
import com.ge.icfp.model.CPALegRequest;
import com.ge.icfp.model.DealRequest;
import com.ge.icfp.util.EventType;
import com.ge.icfp.util.Utils;
import static com.ge.icfp.common.constants.ICFPConstants.*;
/**
 * Action class for CPA Four Blocker
 *
 * @author sreenivasulu.talloju
 *
 */
public class FOCPALegAction extends CPALegAction {
	
	private static final Logger logger = Logger.getLogger(FOCPALegAction.class);
	

	
	
	/**
	 * Method is used to open the leg details
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward openLeg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		Integer legNumber = (Integer) request.getAttribute(LEGNUMBER);
		if (legNumber == null) {
			legNumber = Integer.valueOf(request.getParameter(LEGNUMBER));
		}
		Object leg = CurrentDealManager.getLegByNumber(legNumber, request);
		
		// Set QualitativeFactors If not exists
		ICFPLegHelper.prepareQualitativeFactors(leg, 1, 2, 3, 4, 5);
		ICFPLegHelper.syncFormWithLeg((DynaActionForm) form, leg, request, getServlet().getServletContext(), mapping, this);

		String mode = request.getParameter(MODIFY);
		if (mode != null && mode.equals(TRUE_SMALL)) {
			request.getSession().setAttribute(ADDORMODIFYFLAG, MODIFY);
			request.getSession().setAttribute(REMOVECURRENT, YES);
		}
		request.getSession().setAttribute(ADDORMODIFYREQ, MODIFY);
		request.setAttribute(LEGEXIST, YES_CAP);

		((DynaActionForm) form).set(LEGNUMBER, Integer.toString(legNumber));
		
		String legForward = ADDREQUEST;
		request.setAttribute(ACTIONID, 2);
		request.setAttribute(LEGNUMBER, legNumber);
		
		EventType eventType = ICFPDay2LegHelper.getEventType(leg);
		if(eventType != null) {
			legForward = ADDDAY2LEGREQUEST;
			String eventTypeName = Utils.fetchPropertyValue("CPASummary.transactionEventType", leg, String.class);
			request.setAttribute(EVENTTYPENAME, eventTypeName);
			request.setAttribute(EVENTTYPEID, eventType.getId());
		}
		return mapping.findForward(legForward);
	}
	
	
	/**
	 * Method to save the leg to current deal
	 * @param form
	 * @param request
	 * @param mapping
	 * @throws throws Exception 
	 */
	@Override
	public void saveLeg(DynaActionForm form, HttpServletRequest request,
			ActionMapping mapping, boolean isValidate) throws Exception {
		DynaActionForm legSummaryForm = (DynaActionForm) form.get(CPASUMMARY_SMALL);
		int legNumber = Integer.valueOf((String) form.get(LEGNUMBER));
		legSummaryForm.set(LEGNUMBER, String.valueOf(legNumber));
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		request.setAttribute(DEALREQUESTID, deal.getDealSeqId());
		CPALegRequest leg = CurrentDealManager.getLegByNumber(legNumber,
				CPALegRequest.class, request);
		ServletContext servletContext = getServlet().getServletContext();

		if (logger.isInfoEnabled()) {
			logger.info("Saving form bean to leg type " + leg);
		}
		ICFPLegHelper.syncCPALegWithForm(leg, form, request, servletContext,
				mapping, this);
		String comments  = request.getParameter(COMMENTS_TEXT_AREA);
		if(comments!=null && StringUtils.isNotEmpty(comments)){
			leg.setComments(comments);
		}
		CurrentDealManager.syncCommentsWithFormObject(request);
		String opcode = leg.getCPASummary().getCPALegOpcode();
		Integer legSeqId = leg.getCPASummary().getLegSeqId();
		if ((opcode == null || opcode.equals("")) && legSeqId == null) {
			leg.getCPASummary().setCPALegOpcode(INSERT);

		} else if (legSeqId != null && opcode == null) {
			leg.getCPASummary().setCPALegOpcode(UPDATE);

		}
		leg.getCPASummary().setCPALegOpcode(UPDATE);
		request.setAttribute(LEGNUMBER, legNumber);
		request.setAttribute(LEGEXIST, YES_CAP);
		ICFPLegHelper.prepareMsgHeader(deal, INSERTDEAL, SAVE, 22);
	
		if(isValidate){
			ActionErrors errors = AttachmentValidator.getInstance().validateLeg(leg, request);
			if(!errors.isEmpty()) {
				saveErrors(request, errors);
				request.setAttribute(ICFPConstants.AMTERROR,"Please fix the following fields highlighted in red.");
				return;
			}
			ICFPLegHelper.setFOValidateFlag(leg, ICFPConstants.Y_CAP);
		}else{
			ICFPLegHelper.setFOValidateFlag(leg,ICFPConstants.N_CAP);
		}
		deal = serviceClient.invokeService(DEAL, deal, DealRequest.class);

		deal = ICFPCommonHelper.getDeal(deal.getDealSeqId(), serviceClient);
		CurrentDealManager.setActiveDeal(deal, request);
		
		Object leg1 = CurrentDealManager.getLegByNumber(legNumber, request);
		legSeqId = ICFPLegHelper.getLegSeqId(leg1);
		
		request.setAttribute(UPDATEMESSAGE,LEG_LABEL+ legSeqId + UPDATED_LABEL);

	}
	
	

}
