/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: FourBlockerAction.java
 * Purpose:FourBlockerAction used for Loading and Submission of Deals
 */
package com.ge.icfp.common.action;

import static com.ge.icfp.common.constants.ICFPConstants.ACTION;
import static com.ge.icfp.common.constants.ICFPConstants.ACTIONID;
import static com.ge.icfp.common.constants.ICFPConstants.AFFIRM;
import static com.ge.icfp.common.constants.ICFPConstants.CURRENTBUSINESSAPPROVERS;
import static com.ge.icfp.common.constants.ICFPConstants.DELETEBUSINESSAPPROVERS;
import static com.ge.icfp.common.constants.ICFPConstants.SAVE;
import static com.ge.icfp.common.constants.ICFPConstants.REJECT;
import static com.ge.icfp.common.constants.ICFPConstants.AFTER_POPULATING;
import static com.ge.icfp.common.constants.ICFPConstants.ASSIGNREVIEW;
import static com.ge.icfp.common.constants.ICFPConstants.BEFORE_POPULATING;
import static com.ge.icfp.common.constants.ICFPConstants.BUSINESSAPPROVERSLIST;
import static com.ge.icfp.common.constants.ICFPConstants.CLOSEREQ;
import static com.ge.icfp.common.constants.ICFPConstants.CURRENTADDITIONALAPPROVERS;
import static com.ge.icfp.common.constants.ICFPConstants.CURRENTUSERINFOLIST;
import static com.ge.icfp.common.constants.ICFPConstants.DAY2LEG;
import static com.ge.icfp.common.constants.ICFPConstants.DEALCOMMENTS;
import static com.ge.icfp.common.constants.ICFPConstants.DEALREQUESTID;
import static com.ge.icfp.common.constants.ICFPConstants.DELETEUSERINFOLIST;
import static com.ge.icfp.common.constants.ICFPConstants.EQUITY_LEGSUMMARY;
import static com.ge.icfp.common.constants.ICFPConstants.FAILUREMSG;
import static com.ge.icfp.common.constants.ICFPConstants.FORWARDPAGE;
import static com.ge.icfp.common.constants.ICFPConstants.FORWARD_HOMEPAGE;
import static com.ge.icfp.common.constants.ICFPConstants.FOUR;
import static com.ge.icfp.common.constants.ICFPConstants.HIGH;
import static com.ge.icfp.common.constants.ICFPConstants.HWF_FOURBLOCKER_1001;
import static com.ge.icfp.common.constants.ICFPConstants.HWF_INBOX_1001;
import static com.ge.icfp.common.constants.ICFPConstants.ID;
import static com.ge.icfp.common.constants.ICFPConstants.IDAGEAG;
import static com.ge.icfp.common.constants.ICFPConstants.IDAGREVW;
import static com.ge.icfp.common.constants.ICFPConstants.INSERT;
import static com.ge.icfp.common.constants.ICFPConstants.ISCPA;
import static com.ge.icfp.common.constants.ICFPConstants.ISEQUITY;
import static com.ge.icfp.common.constants.ICFPConstants.LEGNUMBER;
import static com.ge.icfp.common.constants.ICFPConstants.LEGSUMMARY;
import static com.ge.icfp.common.constants.ICFPConstants.MEDIUM;
import static com.ge.icfp.common.constants.ICFPConstants.NO;
import static com.ge.icfp.common.constants.ICFPConstants.ONE;
import static com.ge.icfp.common.constants.ICFPConstants.OTHERAPPROVER;
import static com.ge.icfp.common.constants.ICFPConstants.OTHERCOMMENTS;
import static com.ge.icfp.common.constants.ICFPConstants.OTHERLEGSUMMARY;
import static com.ge.icfp.common.constants.ICFPConstants.PROCEEDTONEXTLEG;
import static com.ge.icfp.common.constants.ICFPConstants.ROLEIDMAP;
import static com.ge.icfp.common.constants.ICFPConstants.ROLEINFO;
import static com.ge.icfp.common.constants.ICFPConstants.SAVEMESSAGE;
import static com.ge.icfp.common.constants.ICFPConstants.SECTION;
import static com.ge.icfp.common.constants.ICFPConstants.SENDTOEBOARDROOMAPPROVE;
import static com.ge.icfp.common.constants.ICFPConstants.SEVEN;
import static com.ge.icfp.common.constants.ICFPConstants.SOCASHMG;
import static com.ge.icfp.common.constants.ICFPConstants.SOCOUNTX;
import static com.ge.icfp.common.constants.ICFPConstants.SOMIDOFF;
import static com.ge.icfp.common.constants.ICFPConstants.SOTLEGAL;
import static com.ge.icfp.common.constants.ICFPConstants.SOTPRICE;
import static com.ge.icfp.common.constants.ICFPConstants.SOTRESTX;
import static com.ge.icfp.common.constants.ICFPConstants.SOURCE;
import static com.ge.icfp.common.constants.ICFPConstants.SUCCESS;
import static com.ge.icfp.common.constants.ICFPConstants.SUCCESSCPA;
import static com.ge.icfp.common.constants.ICFPConstants.TASK;
import static com.ge.icfp.common.constants.ICFPConstants.TASKASSIGN;
import static com.ge.icfp.common.constants.ICFPConstants.TEAMMEMBERID;
import static com.ge.icfp.common.constants.ICFPConstants.TEAMMEMBERLIST;
import static com.ge.icfp.common.constants.ICFPConstants.TESGREVW;
import static com.ge.icfp.common.constants.ICFPConstants.TWO;
import static com.ge.icfp.common.constants.ICFPConstants.UPDATEICFPSTATUS;
import static com.ge.icfp.common.constants.ICFPConstants.UPDATEMESSAGE;
import static com.ge.icfp.common.constants.ICFPConstants.USER_MGMT;
import static com.ge.icfp.common.constants.ICFPConstants.VALIDATEVAULTREQUEST;
import static com.ge.icfp.common.constants.ICFPConstants.VIEWINPUTSCREENS;
import static com.ge.icfp.common.constants.ICFPConstants.YES;
import static com.ge.icfp.common.constants.ICFPConstants.APPROVE;
import static com.ge.icfp.common.constants.ICFPConstants.APPROVEWITHMODIFICATION;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64OutputStream;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import com.ge.icfp.action.ICFPBaseAction;
import com.ge.icfp.action.ICFPException;
import com.ge.icfp.common.attachments.AttachmentType;
import com.ge.icfp.common.attachments.AttachmentUtils;
import com.ge.icfp.common.attachments.ICFPAttachmentManager;
import com.ge.icfp.common.attachments.validation.AttachmentValidator;
import com.ge.icfp.common.constants.ICFPConstants;
import com.ge.icfp.common.helper.CurrentDealManager;
import com.ge.icfp.common.helper.CurrentInboxManager;
import com.ge.icfp.common.helper.ICFPCommonHelper;
import com.ge.icfp.common.helper.ICFPDay2LegHelper;
import com.ge.icfp.common.helper.ICFPLegHelper;
import com.ge.icfp.model.AssignReviewer;
import com.ge.icfp.model.Attachment;
import com.ge.icfp.model.CPALegRequest;
import com.ge.icfp.model.DealRequest;
import com.ge.icfp.model.EboardUpdate;
import com.ge.icfp.model.EquityLegRequest;
import com.ge.icfp.model.FourBlocker;
import com.ge.icfp.model.IDAGEAGLead;
import com.ge.icfp.model.MsgHeader;
import com.ge.icfp.model.NameValue;
import com.ge.icfp.model.OtherLegRequest;
import com.ge.icfp.model.QualitativeFactors;
import com.ge.icfp.model.RCALegRequest;
import com.ge.icfp.model.RoleInfo;
import com.ge.icfp.model.TClassificationLevel;
import com.ge.icfp.model.TesgList;
import com.ge.icfp.model.TesgPopUp;
import com.ge.icfp.model.UpdateStatus;
import com.ge.icfp.model.UserInformation;
import com.ge.icfp.tag.DealManager;
import com.ge.icfp.util.Actions;
import com.ge.icfp.util.StaticDataFactory;
import com.ge.icfp.util.UserRole;
import com.ge.icfp.util.Utils;
import com.ge.icfp.util.ValidateQualitativeAssessments;
import com.ge.icfp.util.WorkflowStages;
import com.ge.icfp.util.report.pdf.DealPDFGenerator;
import com.ge.icfp.util.report.pdf.ReportType;
import com.hydus.wff.common.bw.ServiceClient;
import com.hydus.wff.core.context.UserContext;
import com.hydus.wff.core.exception.HWFServiceException;
import com.hydus.wff.core.exception.HWFStubException;
import com.hydus.wff.core.session.SessionManager;

import formdef.plugin.util.FormUtils;
/**
 * Common Action uses across all four blocker screen.
 * This hanles action like submit, navigation to leg, validation  
 * @author arijit.biswas
 *
 */
public class FourBlockerAction extends ICFPBaseAction {
	private static final String ATMT_ERROR = "atmtError";
	private static final String T_CLASSIFICATION_LEVEL_FORM = "TClassificationLevelForm";
	private static final String FOUR_BLOCKER_FORM = "fourBlockerForm";
	private static final String T_CLASSIFICATION_LEVEL = "tClassificationLevel";
	private static final String FOUR_BLOCKER = "fourBlocker";
	private static final String IDAG_AFFIRM_FLAG = "IdagAffirmFlag";
	private static final String SUCCESSFULLY_EXPORTED_UNDERWRITING_THE_PDF_FOR_DEAL = "Successfully Exported Underwriting the PDF for deal ";
	private static final String EXPORTING_UNDERWRITING_PDF_FOR_DEAL = "Exporting Underwriting PDF for deal ";
	private static final String TRANSFER_PRICING_LEG_VIEW = "/transferPricingLegView";
	private static final String LEG_SUMMARY_CPA = "legSummaryCPA";
	private static final String DAY2TCM_OLEG = "day2TCMOleg";
	private static final String DAY2CPA_LEG = "day2CPALeg";
	private static final String GETTESGAPPROVERS = "GETTESGAPPROVERS";
	private static final String GETTESGACTIONS = "GETTESGACTIONS";
	private static final String GETIDAGAPPROVERS = "GETIDAGAPPROVERS";
	private static final String QUALITATIVE_ASSESSMENT_IS_NOT_SAVED_FOR_LEGS = "Qualitative Assessment is not saved for Legs ";
	private static final String EBOARD_COMMENTS = "eboardComments";
	private static final String UNDER_WRITING = "UnderWriting-";
	private static final String UNDERWRITING_FILE_FOR_DEAL = "Underwriting file for Deal ";
	private static final String EQUITY_PITCH_FILE_FOR_DEAL = "Equity pitch file for Deal ";
	private static final String ON_BEHALF1 = "onBehalf1";
	private static final String APPROVER_LIST = "approverList";
	private static final String ON_BEHALF = "onBehalf";
	private static final String APPROVE_REJECT = "approveReject:";
	private static final String WF_STAGE = "wfStage:";
	private static final String ACTION_NAME = "actionName:";
	private static final String IS_SEND_TC = "isSendTC";
	private static final String TESG_MEMBER_LIST = "TESGMemberList";
	private static final String TESG_MEMBER_LIST_POPUP = "TESGMemberListPopup";
	private static final String IDAG_MEMBER_LIST = "IDAGMemberList";
	private static final String DELEGATE = "Delegate";
	private static final String IDAG_LEAD = "idagLead";
	private static final String ROLE = "role";
	private static final Logger LOGGER = Logger.getLogger(FourBlockerAction.class);
	protected ServiceClient serviceClient;
	private int actionId;
	protected ICFPAttachmentManager attachmentManager;
	
	

	/**
	 * Open the request deal page for DealRequesID provided in request paramters.
	 * This method used specifically of IDAG stage.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HWFServiceException
	 * @throws HWFStubException
	 */
	public ActionForward openDeal(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws HWFServiceException, HWFStubException {
		ActionForward forward = null;

		String requestID = request.getParameter(DEALREQUESTID);
		if(requestID==null || requestID.equals(""))
		{
			requestID = (String)request.getAttribute(DEALREQUESTID);
		}
		request.getSession().setAttribute(CURRENTADDITIONALAPPROVERS, null); 
		request.getSession().setAttribute(BUSINESSAPPROVERSLIST,null);
			
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		CurrentDealManager.setActiveDeal(deal, request);

		ICFPLegHelper.prepareTCLForm((DynaActionForm)form, mapping, request, this);
		if(deal != null){
			//Additional Approvers BEGIN
			if( deal.getAdditionalApprovers() != null && deal.getAdditionalApprovers().getUserInfos() != null  && deal.getAdditionalApprovers().getUserInfos().size() > 0 ){
				request.getSession().setAttribute(CURRENTADDITIONALAPPROVERS, deal.getAdditionalApprovers()); 
			}
			//Additional Approvers END

			if( deal.getBusinessApprovers()!= null && deal.getBusinessApprovers().size() > 0 ){
				request.getSession().setAttribute(BUSINESSAPPROVERSLIST, deal.getBusinessApprovers());  
			}
			
			//Assign a reviewer Button BEGIN
			if(request.getParameter(SECTION) != null){
				String section = request.getParameter(SECTION);
				request.getSession().setAttribute(SECTION, section);
			}
			//Assign a reviewer Button END
		}

		request.getSession().setAttribute(ROLE, IDAG_LEAD);
		Boolean isEquityDeal = CurrentDealManager.isEquityDeal(request);
		Boolean isCPADeal = CurrentDealManager.isCPADeal(request);
		if(isCPADeal!=null && isCPADeal) {
			forward = mapping.findForward(SUCCESSCPA);
		} else {
			forward = mapping.findForward(SUCCESS);
		}
		
		List<String> roles = SessionManager.getRoles(request);
		String roleName = "";
		if(!roles.isEmpty()){
			for(String actualRole : roles) {
				if(actualRole.contains(TASK)){
					roleName = actualRole;
					break;
				}
			}
			if("".equals(roleName)){
				for(String actualRole : roles) {
					if(actualRole.contains(DELEGATE)){
						roleName = actualRole;
						break;
					}
				}
			}
			
		}
		
		request.getSession().setAttribute(TEAMMEMBERLIST,getTeamMembers(roleName, request));
		request.getSession().setAttribute(IDAG_MEMBER_LIST,getIDAGApprovers(deal, request));
		/**
		 * Code is modified to get the Tesg member list while opening the TESG Approvals 
		 */
		request.getSession().setAttribute(TESG_MEMBER_LIST,getTESGApprovers(deal, request));
		
		request.setAttribute(ISCPA,isCPADeal);
		request.setAttribute(ISEQUITY,isEquityDeal);
		
		return forward;
	}
	
	
	/**
	 * Load the four blocker screen for the given deal ID in request paramaters
	 * This method is called for other than IDAG stage 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward load(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws HWFServiceException, HWFStubException {
		ActionForward forward = null;

		String requestID = request.getParameter(DEALREQUESTID);
		if(requestID==null || requestID.equals(""))
		{
			requestID = (String)request.getAttribute(DEALREQUESTID);
		}
		request.getSession().setAttribute(CURRENTUSERINFOLIST,null);
		request.getSession().setAttribute(DELETEUSERINFOLIST,null);		
		request.getSession().setAttribute(CURRENTADDITIONALAPPROVERS, null); 
		request.getSession().setAttribute(BUSINESSAPPROVERSLIST,null);
		request.getSession().setAttribute(DELETEBUSINESSAPPROVERS,null);
		request.getSession().setAttribute(CURRENTBUSINESSAPPROVERS,null);
		
		DealRequest deal = ICFPCommonHelper.getDeal(Integer.valueOf(requestID), serviceClient);
		CurrentDealManager.setActiveDeal(deal, request);
		
		UpdateStatus updateStatus = createUpdateStatusBean(mapping, form, request);
		ICFPLegHelper.prepareTCLForm((DynaActionForm)form, mapping, request, this);
		if(deal != null){
			TClassificationLevel tclLevel = new TClassificationLevel();
			if(deal.getRuAmendedTcl()!=null){
				tclLevel.setRUAmendedTCL(deal.getRuAmendedTcl().toString());
			}
			if(deal.getRevisedTclComments()!=null){
				tclLevel.setRevisedTCLComments(deal.getRevisedTclComments());
			}
			if(deal.isRiskOverrideFlag()!=null){
				String riskFlag = ICFPConstants.ZERO;
				if(deal.isRiskOverrideFlag()==true){
					riskFlag = ICFPConstants.ONE;
				}
				tclLevel.setRiskReviewOverride(riskFlag);
			}
			
			DynaActionForm fourBlockerForm = (DynaActionForm) ((DynaActionForm) form).get(FOUR_BLOCKER);
			if(fourBlockerForm == null) {
				fourBlockerForm = FormUtils.getInstance().createDynaActionForm(FOUR_BLOCKER_FORM, mapping.getModuleConfig(), this);
				((DynaActionForm) form).set(FOUR_BLOCKER, fourBlockerForm);
			}
			
			DynaActionForm tclForm = (DynaActionForm) fourBlockerForm.get(T_CLASSIFICATION_LEVEL);
			if(tclForm == null) {
				tclForm = FormUtils.getInstance().createDynaActionForm(T_CLASSIFICATION_LEVEL_FORM, mapping.getModuleConfig(), this);
				fourBlockerForm.set(T_CLASSIFICATION_LEVEL, tclForm);
			}
			
			FormUtils.getInstance().populateForm(T_CLASSIFICATION_LEVEL_FORM, tclForm, tclLevel, mapping.getModuleConfig(), this, mapping, request);
			
			//Additional Approvers BEGIN
			if( deal.getAdditionalApprovers() != null && deal.getAdditionalApprovers().getUserInfos() != null  && deal.getAdditionalApprovers().getUserInfos().size() > 0 ){
				request.getSession().setAttribute(CURRENTADDITIONALAPPROVERS, deal.getAdditionalApprovers()); 
			}
			//Additional Approvers END

			if( deal.getBusinessApprovers()!= null && deal.getBusinessApprovers().size() > 0 ){
				request.getSession().setAttribute(BUSINESSAPPROVERSLIST, deal.getBusinessApprovers());  
			}
			//Assign a reviewer Button BEGIN
			if(request.getParameter(SECTION) != null){
				String section = request.getParameter(SECTION);
				request.getSession().setAttribute(SECTION, section);
			}
			//Assign a reviewer Button END
		}

		request.getSession().setAttribute(ROLE, IDAG_LEAD);
		Boolean isEquityDeal = CurrentDealManager.isEquityDeal(request);
		Boolean isCPADeal = CurrentDealManager.isCPADeal(request);
		if(isCPADeal!=null && isCPADeal) {
			forward = mapping.findForward(SUCCESSCPA);
		} else {
			forward = mapping.findForward(SUCCESS);
		}
		
		List<String> roles = SessionManager.getRoles(request);
		String roleName = "";
		if(!roles.isEmpty()){
			for(String actualRole : roles) {
				if(actualRole.contains(TASK)){
					roleName = actualRole;
					break;
				}
			}
			if("".equals(roleName)){
				for(String actualRole : roles) {
					if(actualRole.contains(DELEGATE)){
						roleName = actualRole;
						break;
					}
				}
			}
		}
		
		request.getSession().setAttribute(TEAMMEMBERLIST,getTeamMembers(roleName, request));

		// getting the list of IDAG Member list affiliated with the deal request
		
		int IdagLeadstage = deal.getWFStageId();
		request.getSession().setAttribute( ICFPConstants.IDAGLEAD, ICFPConstants.N_CAP);
		/**
		 * Code is modified to get the Idag member list while opening the IDAG/EAG Approvals 
		 */
		List<IDAGEAGLead> idagApprovers = new ArrayList<IDAGEAGLead>();
		String workFlowStage = updateStatus.getWFStage();
		if(IDAGEAG.equals(workFlowStage) || IDAGREVW.equals(workFlowStage)){
			if(IDAGEAG.equals(workFlowStage)){
				request.getSession().setAttribute( ICFPConstants.IDAGLEAD, ICFPConstants.Y_CAP );
			}
			idagApprovers = getIDAGApprovers(deal, request);
			request.getSession().setAttribute(IDAG_MEMBER_LIST,idagApprovers);
		} else if("".equals(workFlowStage)){
			if(IdagLeadstage == 5 || IdagLeadstage == 6){
				if(IdagLeadstage == 6){
					request.getSession().setAttribute( ICFPConstants.IDAGLEAD, ICFPConstants.Y_CAP );
				}
				idagApprovers = getIDAGApprovers(deal, request); 
				request.getSession().setAttribute(IDAG_MEMBER_LIST,idagApprovers);
			}
		}
			
		/**
		 * Code is modified to get the Tesg member list while opening the TESG Approvals 
		 */
		if(TESGREVW.equals(workFlowStage)){
			request.getSession().setAttribute(TESG_MEMBER_LIST,getTESGApprovers(deal, request));
			request.getSession().setAttribute(TESG_MEMBER_LIST_POPUP,getTESGApproversPopup(deal, request));
			request.getSession().setAttribute( ICFPConstants.POSTIDAG, ICFPConstants.Y_CAP);
		}else if("".equals(workFlowStage)){
			if(IdagLeadstage == 7){
				request.getSession().setAttribute(TESG_MEMBER_LIST,getTESGApprovers(deal, request));
				request.getSession().setAttribute(TESG_MEMBER_LIST_POPUP,getTESGApproversPopup(deal, request));
				request.getSession().setAttribute(ICFPConstants.POSTIDAG, ICFPConstants.Y_CAP);
			}
		}
		
		request.setAttribute(ISCPA,isCPADeal);
		request.setAttribute(ISEQUITY,isEquityDeal);
		if(deal.isSendTCFlag()!=null){
			request.getSession().setAttribute(IS_SEND_TC, deal.isSendTCFlag());
		}else{
			request.getSession().setAttribute(IS_SEND_TC, false);
		}
		return forward;
	}


	/**
	 * Opens the Leg screen for the requested Leg 
	 *
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward legDetails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws HWFServiceException,Exception {
		ActionForward forward = null;
		String legIDStr = request.getParameter(ID);
		request.getSession().removeAttribute(VALIDATEVAULTREQUEST);
		if(legIDStr != null){
			forward = displayLegDetails(mapping, request, forward, legIDStr);
		}
		return forward;
	}

	/**
	 * Submit Deal for Approvals from Four Blocker screen
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HWFServiceException
	 * @throws ICFPException 
	 * @throws HWFStubException 
	 * @throws IOException 
	 */
	public ActionForward submitDealRequest(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws ICFPException, HWFServiceException, HWFStubException, IOException {
		UpdateStatus updateStatus = createUpdateStatusBean(mapping, form, request);
		if(updateStatus.getFourBlocker() != null && updateStatus.getFourBlocker().getTClassificationLevel() != null) {
			TClassificationLevel tClassificationLevel = updateStatus.getFourBlocker().getTClassificationLevel();
			if(tClassificationLevel.getRiskReviewOverride() != null
					&& tClassificationLevel.getRiskReviewOverride().trim().equals(ICFPConstants.ZERO)) {
				tClassificationLevel.setRUAmendedTCL(null);
				tClassificationLevel.setRevisedTCLComments(null);
			}
			tClassificationLevel = Utils.cleanBlankElements(tClassificationLevel);
			updateStatus.getFourBlocker().setTClassificationLevel(tClassificationLevel);
		}
		Boolean isCPADeal = CurrentDealManager.isCPADeal(request);
		// Setting list of approvers, on behalf of whom Idaglead is approving/rejecting, if any
		addIdagList(updateStatus, form, request);
		
		// Setting list of approvers, on behalf of whom tesglead is approving/rejecting, if any
		addTesgList(updateStatus, form, request);
		
		ServletContext servletContext = getServlet().getServletContext();
		if(updateStatus.getRoleId().equals(FOUR)){
			ICFPLegHelper.syncTClassificationLevel(updateStatus, (DynaActionForm)form, request, servletContext, mapping, this);
		}
		DealRequest dealRequest = CurrentDealManager.getCurrentDeal(request);
		
		CurrentDealManager.syncCommentsWithFormObject(request);
		CurrentDealManager.setDealObjectToUpdateStatusComments(dealRequest, updateStatus, request);
		
		if( !udpateEboardDetails(request, updateStatus)) {
			if(isCPADeal!=null && isCPADeal){
				request.setAttribute(ISCPA,isCPADeal);
			}
			return mapping.findForward(SUCCESS);
		}
		String wfStage = updateStatus.getWFStage();

	    String actionName = updateStatus.getActionId();
	    String approveReject = updateStatus.getApproveReject();
	    StringBuilder logInfo = new StringBuilder();
	    logInfo.append(BEFORE_POPULATING).append("\n")
	    		.append(ACTION_NAME).append(actionName).append("\n")
	    		.append(WF_STAGE).append(wfStage).append("\n")
	    		.append(APPROVE_REJECT).append(approveReject);

	    LOGGER.info(logInfo);
	   
	    if (SOTPRICE.equals(wfStage)) {
	    	ActionErrors errors = null;
	    	if (actionName.equals(AFFIRM)) {
	    		
	    		if(isCPADeal!=null && isCPADeal){
	    			request.setAttribute(ISCPA,isCPADeal);
	    		}
	    		
	    		errors = ICFPCommonHelper.validateLegData(dealRequest,null,false,true);
	    		if(errors!=null && !errors.isEmpty()) {
	    			saveErrors(request, errors);
	    			return mapping.findForward(SUCCESS);
	    		}
	    		
	    	}

	    } 
	    
	    // Assessment validations required for only S & O group members 
		if (SOCASHMG.equals(wfStage) || SOMIDOFF.equals(wfStage) || SOTRESTX.equals(wfStage) || SOTLEGAL.equals(wfStage) 
				|| SOTPRICE.equals(wfStage) || SOCOUNTX.equals(wfStage)) {
			ActionErrors errors = null;
			if (actionName.equals(AFFIRM)
					&& !validateAssessments(request, dealRequest,getQFactorId(updateStatus), wfStage)) {
				if(isCPADeal!=null && isCPADeal){
					request.setAttribute(ISCPA,isCPADeal);
				}
							
				return mapping.findForward(SUCCESS);
			}
		} 
		if(!actionName.equals(SAVE)){
			ActionErrors errors = null;
			if (isCPADeal != null && isCPADeal) {
				request.setAttribute(ISCPA, isCPADeal);
			}
			errors = AttachmentValidator.getInstance().validateDeal(request);
			if (errors != null && !errors.isEmpty()) {
				saveErrors(request, errors);
				request.setAttribute(ATMT_ERROR,"Please fix the following fields highlighted in red.");
				return mapping.findForward(SUCCESS);
			}

		}
		
		//Additional Approvers BEGIN
		if ((request.getSession().getAttribute(CURRENTUSERINFOLIST) != null)
				|| (request.getSession().getAttribute(DELETEUSERINFOLIST) != null)) {
			CurrentDealManager.populateAdditionalApprovers(request, updateStatus, dealRequest);
		}
		//Additional Approvers END
		
		updateStatus.setDealSeqId(String.valueOf(dealRequest.getDealSeqId()));
		String requestID = dealRequest.getDealSeqId().toString();
		String currentUserId = UserContext.getCurrentUserContext().getId();
		String lastName = UserContext.getCurrentUserContext().getLastName();
		String firstName = UserContext.getCurrentUserContext().getFirstName();

		updateStatus.setApproverSSOId(currentUserId);
		updateStatus.setApproverLname(lastName);
		updateStatus.setApproverFname(firstName);
		if(ASSIGNREVIEW.equals(actionName)){
			//show Assign Reviewer button
			setMsgHeader(updateStatus, TASKASSIGN, request);
			updateStatus.setApproveReject(SEVEN);
			if(null != request.getParameter(TEAMMEMBERID) ){
				List<AssignReviewer> assignReviewers = new ArrayList<AssignReviewer>(); 
				FourBlocker fourBlocker = new FourBlocker();
				AssignReviewer assignReviewer = new AssignReviewer();
				String ssoID = request.getParameter(TEAMMEMBERID);
				@SuppressWarnings("unchecked")
				Map<String,Integer> roleIDMap = (HashMap<String,Integer>)request.getSession().getAttribute(ROLEIDMAP);
				String roleID =  String.valueOf( roleIDMap.get(ssoID) );
				assignReviewer.setOpcode(INSERT);
				assignReviewer.setSSOID(ssoID); 
				assignReviewer.setRoleId(roleID);
				
				assignReviewers.add(assignReviewer);
				
				fourBlocker.setAssignReviewers(assignReviewers);
				updateStatus.setFourBlocker(fourBlocker);
			}
		}else{
			setMsgHeader(updateStatus, OTHERAPPROVER,request);
		}
		updateStatus.setActionId(Actions.getID(actionName));
		StringBuilder logInfoAfter = new StringBuilder();
	    logInfoAfter.append(AFTER_POPULATING).append("\n")
	    		.append(ACTION_NAME).append(actionName).append("\n")
	    		.append(WF_STAGE).append(wfStage).append("\n")
	    		.append(APPROVE_REJECT).append(approveReject);

		LOGGER.info(logInfoAfter);
		dealRequest.setComments(((String)request.getParameter(DEALCOMMENTS)));
		updateStatus.setComments((String)request.getParameter(DEALCOMMENTS));
		
		//Business ID
		updateStatus.setBusinessRequestId(dealRequest.getUniqueId());
		if(StringUtils.isEmpty(updateStatus.getActionId())){
			throw new ICFPException(HWF_FOURBLOCKER_1001);
		}
		CurrentDealManager.syncPropertiesforMeta(dealRequest,updateStatus,request); // Method used for update meta info
		attachmentManager.updateMetadataForAllAttachments(dealRequest);
		
		//update as TESG member on Affirm action for IDAG Lead, in case of name listed in pending TESG List
		Boolean isTESGStage = WorkflowStages.TESGREVW.getId() == dealRequest.getWFStageId();
		Boolean isAffirmAction = APPROVE.equals(actionName) || APPROVEWITHMODIFICATION.equals(actionName);
		
		if (isTESGStage && isAffirmAction) {
			
			if (DealManager.isUserInTESGPending(request)) {
				updateStatus.setRoleId(UserRole.TESG.getId());
			} else {
				updateStatus.setRoleId(UserRole.IDAGEAG_Lead.getId());
			}
		}
		//update as TESG member on Reject action for IDAG Lead, in case of name listed in pending TESG List
		if (REJECT.equals(actionName) && isTESGStage) {
			
			if (DealManager.isUserInTESGPending(request)) {
				updateStatus.setRoleId(UserRole.TESG.getId());
			} else {
				updateStatus.setRoleId(UserRole.IDAGEAG_Lead.getId());
			}
			
		}	
		
		updateStatus = serviceClient.invokeService(UPDATEICFPSTATUS, updateStatus, UpdateStatus.class);
		dealRequest = ICFPCommonHelper.getDeal(Integer.valueOf(requestID), serviceClient);
		CurrentDealManager.setActiveDeal(dealRequest, request);
		String forwardPage = ((DynaActionForm) form).getString(FORWARDPAGE);
		
		Boolean isEquityDeal = CurrentDealManager.isEquityDeal(request);
		request.setAttribute(ISEQUITY,isEquityDeal);
		if (updateStatus != null) {
			String updateMsg = updateStatus.getComments();
			if(forwardPage.equals(SUCCESS)){
				if(isCPADeal!=null && isCPADeal){
					request.setAttribute(ISCPA,isCPADeal);
				}
				request.setAttribute(SAVEMESSAGE, updateMsg);
			}else{
				request.setAttribute(UPDATEMESSAGE, updateMsg);
			}
		}
		return mapping.findForward(forwardPage);
	}
	/**
	 * Add Idag Members into the given updateStatus bean
	 * @param updateStatus
	 * @param form
	 * @param request
	 */
	private void addIdagList(UpdateStatus updateStatus,ActionForm form,
			HttpServletRequest request) {
		String onBehalf = request.getParameter(ON_BEHALF);
		if(StringUtils.isNotEmpty(onBehalf)){

			List<IDAGEAGLead> idageagLeads = new ArrayList<IDAGEAGLead>();
			String[] onBehalfs = ((DynaActionForm) form).getString(APPROVER_LIST).split("\\|");
			for(int i = 0; i <onBehalfs.length; i++){
				String[] eachApprover = onBehalfs[i].split(";");
				IDAGEAGLead idageagLead = new IDAGEAGLead();
				idageagLead.setActionFlag(eachApprover[0]);
				idageagLead.setGroup(eachApprover[1]);
				idageagLead.setSSOID(eachApprover[2]);
				idageagLead.setName(eachApprover[3]);
				idageagLeads.add(idageagLead);
			}
			
			updateStatus.setIDAGEAGLeads(idageagLeads);
		}
		
	}
	/**
	 * ADD all TESG member into given updateStatus bean
	 * @param updateStatus
	 * @param form
	 * @param request
	 */
	private void addTesgList(UpdateStatus updateStatus, ActionForm form,
			HttpServletRequest request) {
		String onBehalf1 = request.getParameter(ON_BEHALF1);
		if(StringUtils.isNotEmpty(onBehalf1)){
			@SuppressWarnings({ "unchecked" })
			List<TesgList> tesgList = (List<TesgList>)request.getSession().getAttribute(TESG_MEMBER_LIST);
			@SuppressWarnings("unchecked")
			List<TesgPopUp> tesgPopupList = (List<TesgPopUp>)request.getSession().getAttribute(TESG_MEMBER_LIST_POPUP);
			List<TesgList> tesgLeads = new ArrayList<TesgList>();
			String[] onBehalfs = ((DynaActionForm) form).getString(APPROVER_LIST).split(",");
			for(int i = 0; i <onBehalfs.length; i++){
				for(TesgList tesg: tesgList){
					if(tesg.getSSOID().equals(onBehalfs[i])){
						TesgList tesgLead = new TesgList();
						tesgLead.setSSOID(tesg.getSSOID());
						tesgLead.setName(tesg.getName());
						tesgLead.setGroup(tesg.getGroup());
						tesgLeads.add(tesgLead);
					}
				}
				for (TesgPopUp tesgPopUp : tesgPopupList) {
					if(tesgPopUp.getTesgSSO().equals(onBehalfs[i])){
						TesgList tesgLead = new TesgList();
						tesgLead.setSSOID(tesgPopUp.getTesgSSO());
						tesgLead.setName(tesgPopUp.getTesgName());
						tesgLead.setGroup("ICFP_TESG");
						tesgLeads.add(tesgLead);
					}
				}
			}
			updateStatus.setTesgLists(tesgLeads);
		}
		
	}
	/**
	 * Return Qualitative factor for the given WF stage
	 * @param updateStatus
	 * @return
	 * @throws NumberFormatException
	 */
	private Integer getQFactorId(UpdateStatus updateStatus)
			throws NumberFormatException {
		Integer qFactorId = null;
		if(SOCASHMG.equals(updateStatus.getWFStage())){
			qFactorId = 6;
		}else if(SOMIDOFF.equals(updateStatus.getWFStage())){
			qFactorId = 7;
		}else if(SOTRESTX.equals(updateStatus.getWFStage())){
			qFactorId = 8;
		}else if(SOTLEGAL.equals(updateStatus.getWFStage())){
			qFactorId = 9;
		}else if(SOTPRICE.equals(updateStatus.getWFStage())){
			qFactorId = 10;
		}else if(SOCOUNTX.equals(updateStatus.getWFStage())){
			qFactorId = 11;
		}
		return qFactorId;
	}
	
	
	/**
	 * Update Eboard related info for sending the deal to Eboardroom
	 * @param request
	 * @param updateStatus
	 * @return
	 * @throws ICFPException
	 * @throws HWFStubException 
	 * @throws HWFServiceException 
	 * @throws IOException 
	 */
	private boolean udpateEboardDetails(HttpServletRequest request,
			UpdateStatus updateStatus) throws ICFPException, HWFServiceException, HWFStubException, IOException {
		
		DealRequest dealRequest = CurrentDealManager.getCurrentDeal(request);
		String uniqueId = dealRequest.getUniqueId();
		
		Integer currentStage = dealRequest.getWFStageId();
		
		//Do only on send to eboardroom action
		if( !SENDTOEBOARDROOMAPPROVE.equals(updateStatus.getActionId()) )
			return true;
		
		//update Eboard only for TESG Stage
		if(  WorkflowStages.TESGREVW.getId() != currentStage )
			return true;
		
		EboardUpdate eboard = updateStatus.getEboardUpdate();
		
		if(eboard == null){
			eboard = new EboardUpdate();
			updateStatus.setEboardUpdate( eboard );
		}
		
		List<Attachment> equityPitchAtmtList = AttachmentUtils.searchAttachmentByType(AttachmentType.EQUITY_PITCH, dealRequest.getAttachments());
		
		if(!equityPitchAtmtList.isEmpty()) {
			Attachment equityPitchAtmt = equityPitchAtmtList.get(0);
			ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
			Base64OutputStream equitybase64out = new Base64OutputStream(byteOutputStream);
			attachmentManager.downloadAttachment(equitybase64out, equityPitchAtmt, dealRequest);
			equitybase64out.flush();
			try {
				
			} finally {
				try {
					equitybase64out.close();
				} catch (IOException e) {
					LOGGER.debug("FOurBlockerAction:udpateEboardDetails"+e);
				}
			}
			eboard.setEquityPitchFile(byteOutputStream.toString());
			eboard.setEquityPitchName( equityPitchAtmt.getOrigAttachmentName());
			eboard.setEquityPitchDesc( EQUITY_PITCH_FILE_FOR_DEAL + uniqueId );
		} 
			
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		Base64OutputStream base64out = new Base64OutputStream(out);
		
		DealPDFGenerator pdfGenerator = new DealPDFGenerator(dealRequest);
		pdfGenerator.init(request, ReportType.UNDERWRITING);
		pdfGenerator.generate(base64out);
			
		eboard.setUnderWritingPitchFile( out.toString() );

		eboard.setUnderWritingPitchDesc(UNDERWRITING_FILE_FOR_DEAL + uniqueId);
		eboard.setUnderWritingPitchName(UNDER_WRITING+uniqueId+".pdf");
		eboard.setOriginatorSsoId( new Integer( dealRequest.getTransOwnerSsoId() ) );
		
		Double amount = dealRequest.getHighestLegAmt();
		eboard.setTAmount( amount );
		
		Integer tclLevel = dealRequest.getRuAmendedTcl();
		if(tclLevel == null)
			tclLevel = dealRequest.getDealTcl();
		if(tclLevel == null)
			tclLevel = 0;
		
		eboard.setTClassLevel( tclLevel );
		
		String comments = request.getParameter(EBOARD_COMMENTS);
		eboard.setTDescription(comments);
		updateStatus.setComments( comments );
		
		eboard.setCreatedDate( dealRequest.getRequestDt() );
		eboard.setDealName( dealRequest.getDealName() );
		eboard.setDealCategory( dealRequest.getDealCategory() );
		eboard.setApprovalByDate(dealRequest.getValueDt());
		
		BigDecimal bigDecAmt = new BigDecimal(0.0);
		if(!"".equals(amount) && amount!=null){
			bigDecAmt = new BigDecimal(amount);
		}

		StaticDataFactory statData = (StaticDataFactory) request.getSession().getServletContext().getAttribute(StaticDataFactory.CTX_KEY);
		String referenceData =  statData.getReferenceData();
		BigDecimal eboardAmt =  new BigDecimal(0.0);
		if(!"".equals(referenceData) && referenceData!=null){
			eboardAmt = new BigDecimal(referenceData);
		}
		
		if(amount!=null && !amount.equals("")){
			if(bigDecAmt.compareTo(eboardAmt) ==0 || bigDecAmt.compareTo(eboardAmt)==1){
				eboard.setDealTypeFlag(TWO);
			} else {
				eboard.setDealTypeFlag(ONE);
			}
		}
		
		return true;
		
	}
	/**
	 * Return true if all Assessment information is filled in for the
	 * given QFactor ID
	 * @param request
	 * @param dealRequest
	 * @return
	 */
	protected boolean validateAssessments(HttpServletRequest request,
			DealRequest dealRequest, Integer qFactorId, String wfStage) {
	
		ValidateQualitativeAssessments validate = new ValidateQualitativeAssessments();
		List<Integer>errors =  validate.checkError( dealRequest.getLegs().getAllLegs(), qFactorId , wfStage, request);
		int counter = 1;
		StringBuilder errorMsg = new StringBuilder(QUALITATIVE_ASSESSMENT_IS_NOT_SAVED_FOR_LEGS);
		for(Integer i : errors){
			errorMsg.append( i );
			if( counter != errors.size() )
				errorMsg.append(",");
			counter++;
		}
		if(counter>1){
			request.setAttribute(FAILUREMSG, errorMsg);
		}
		return counter == 1 ? true:false;
	}
	
	/**
	 * Validate all the assessment provided in the deal request
	 * @param dealRequest {@link DealRequest}
	 * @return {@link Integer}
	 */
	protected int validateQAssessment(DealRequest dealRequest){
		int retValue = 0;
		for (Object leg : dealRequest.getLegs().getAllLegs()) {
			if(leg instanceof RCALegRequest){
				RCALegRequest rcaLeg = (RCALegRequest) leg;
				if(!validateQFactorsAssessment(rcaLeg.getLegSummary().getQualitativeFactors())){
					retValue = rcaLeg.getLegSummary().getLegNumber().intValue();break;
				}
			}else if(leg instanceof CPALegRequest){
				CPALegRequest cpaLeg = (CPALegRequest) leg;
				if(!validateQFactorsAssessment(cpaLeg.getCPASummary().getQualitativeFactors())){
					retValue = 1;break;
				}
			}else if(leg instanceof EquityLegRequest){
				EquityLegRequest equityLeg = (EquityLegRequest) leg;
				if(!validateQFactorsAssessment(equityLeg.getLegSummary().getQualitativeFactors())){
					retValue = equityLeg.getLegSummary().getLegNumber().intValue();break;
				}
			}else if(leg instanceof OtherLegRequest){
				OtherLegRequest otherLeg = (OtherLegRequest) leg;
				if(!validateQFactorsAssessment(otherLeg.getLegSummary().getQualitativeFactors())){
					retValue = otherLeg.getLegSummary().getLegNumber().intValue();break;
				}
			}
		}
		return retValue;
	}
	/**
	 * Validate if the assessments and comments are filled in for the given
	 * list
	 * @param factors {@link List}
	 * @return {@link Boolean}
	 */
	protected boolean validateQFactorsAssessment(List<QualitativeFactors> factors){
		boolean retValue = true;
		if(factors.size() > 0){
			for (QualitativeFactors qualitativeFactors : factors) {
				if(qualitativeFactors.getAssessment() == null || qualitativeFactors.getAssessment().equals("")){
					retValue = false;break;
				}else{
					if(qualitativeFactors.getAssessment().equals(HIGH) && (qualitativeFactors.getQualitativeFactorDesc() == null || qualitativeFactors.getQualitativeFactorDesc().equals(""))){
						retValue = false;break;
					}else if(qualitativeFactors.getAssessment().equals(MEDIUM) && (qualitativeFactors.getQualitativeFactorDesc() == null || qualitativeFactors.getQualitativeFactorDesc().equals(""))){
						retValue = false;break;
					}
				}
			}
		}else{
			retValue = false;
		}
		return retValue;
	}
	
	/**
	 * Action invoked for cancel link, and redirects to Home Page
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return success
	 * @throws HWFServiceException if any thing happens
	 */
	public ActionForward cancel(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws HWFServiceException {
		return mapping.findForward(FORWARD_HOMEPAGE);
	}

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

	public ICFPAttachmentManager getAttachmentManager() {
		return attachmentManager;
	}


	public void setAttachmentManager(ICFPAttachmentManager attachmentManager) {
		this.attachmentManager = attachmentManager;
	}


	/**
	 * 
	 * @param updateStatus
	 * @param opcode
	 * @throws ICFPException 
	 */
	protected void setMsgHeader(UpdateStatus updateStatus, String opcode, HttpServletRequest request) throws ICFPException {
		List<String> roles = SessionManager.getRoles(request);
		String roleName = getRoles(roles);
		MsgHeader msgHeader = new MsgHeader();
		msgHeader.setOpcode(opcode);
		String currentUserId = UserContext.getCurrentUserContext().getId();
		msgHeader.setAuditCreator(currentUserId);
		msgHeader.setAuditCreatorFirstName(UserContext.getCurrentUserContext().getFirstName());
		msgHeader.setAuditCreatorLastName(UserContext.getCurrentUserContext().getLastName());
		msgHeader.setRoleName(roleName);
		msgHeader.setAuditModifier(currentUserId);
		msgHeader.setAuditModifierFirstName(UserContext.getCurrentUserContext().getFirstName());
		msgHeader.setAuditModifierLastName(UserContext.getCurrentUserContext().getLastName());
		updateStatus.setMsgHeader(msgHeader);
	}

	/**
	 * 
	 * @param roles
	 * @return
	 * @throws ICFPException
	 */
	private String getRoles(List<String> roles) throws ICFPException {
		if(roles == null || roles.size() == 0){
			throw new  ICFPException(HWF_INBOX_1001);
		}
		StringBuilder roleBuilder = new StringBuilder();
		int roleCount = roles.size();
		int counter = 0;
		for(String eachRole : roles) {
			roleBuilder.append(eachRole);
			if(counter < roleCount - 1) {
				roleBuilder.append(",");
			}
		}
		return roleBuilder.toString();
	}


	/**
	 * Populate the UpdateStatus Bean form the Actionform
	 * @param mapping
	 * @param form
	 * @param request
	 * @return
	 */
	protected UpdateStatus createUpdateStatusBean(ActionMapping mapping, ActionForm form, HttpServletRequest request) {
		
		
		UpdateStatus updateStatus = (UpdateStatus) FormUtils.getFormValues(form, this, mapping, request);
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		
		updateStatus.setDealSeqId( String.valueOf(deal.getDealSeqId()));
		if(null == updateStatus.getActionId()){
			if(null != request.getParameter(ACTION)){
				updateStatus.setActionId((String)request.getParameter(ACTION));
			}
		}
		CurrentInboxManager.updateWorkflowData(updateStatus, request);
		
		return updateStatus;
	}
	/**
	 * Invoke the team member service for the requested roleName
	 * @param roleName
	 * @param request
	 * @return
	 * @throws HWFStubException 
	 * @throws HWFServiceException if any thing happens.
	 */
	public List<NameValue> getTeamMembers(String roleName, HttpServletRequest request) throws HWFServiceException, HWFStubException {
		List<NameValue> teamMembers = new ArrayList<NameValue>();
		MsgHeader msgHeader = new MsgHeader();
		msgHeader.setOpcode(ROLEINFO);
		UserInformation userInfo = new UserInformation();
		RoleInfo roleInfo = new RoleInfo();
		roleInfo.setRoleName(roleName);
		userInfo.getRoleInfos().add(roleInfo);
		userInfo.setMsgHeader(msgHeader);
		userInfo = serviceClient.invokeService(USER_MGMT, userInfo,UserInformation.class);
		if (userInfo != null) {
			ArrayList<RoleInfo> roleInfoList = (ArrayList<RoleInfo>) userInfo.getRoleInfos();
			RoleInfo roleInfo1 = null; 
			Map<String,Integer> roleIDMap = new HashMap<String,Integer>();
			for(int i=0;i<roleInfoList.size();i++)
			{
				boolean isAvailable = false;
				roleInfo1 = (RoleInfo)roleInfoList.get(i);
				for(NameValue oldName : teamMembers) {
					if (roleInfo1.getSsoId().equals(String.valueOf(oldName.getID()))) {
						isAvailable = true;
						break;
					}
				}
				if(isAvailable){
					continue;
				}
				NameValue nameValue = new NameValue();
				nameValue.setID(new Integer(roleInfo1.getSsoId()));
				String userName = roleInfo1.getLastName() +" , " +roleInfo1.getFirstName();
				nameValue.setName(userName);
				
				teamMembers.add(nameValue);
				roleIDMap.put(roleInfo1.getSsoId(), roleInfo1.getRoleId());
				
			}
			request.getSession().setAttribute(ROLEIDMAP, roleIDMap);
		}
		return teamMembers;
	}



	/**
	 * Invoke the service to obtain all the IDAG approvers 
	 * @param DealRequest
	 * @return List<RoleInfo>
	 * returns a list of Idag Approvers for affiliated with a deal request
	 * @throws HWFStubException 
	 */
	private List<IDAGEAGLead> getIDAGApprovers(DealRequest dealRequest, HttpServletRequest request) throws HWFServiceException, HWFStubException {
		UpdateStatus updateStatus = new UpdateStatus();
		MsgHeader msgHeader = new MsgHeader();
		msgHeader.setOpcode(GETIDAGAPPROVERS);
		updateStatus.setDealSeqId(String.valueOf(dealRequest.getDealSeqId()));
		String currentUserId = UserContext.getCurrentUserContext().getId();
		updateStatus.setApproverSSOId(currentUserId);
		updateStatus.setMsgHeader(msgHeader);
		updateStatus.setBusinessRequestId(dealRequest.getUniqueId());
		updateStatus.setActionId(ONE);
		updateStatus.setRoleId(ICFPConstants.FORTYSIX);
		CurrentInboxManager.updateWorkflowData(updateStatus, request);
		updateStatus = serviceClient.invokeService(UPDATEICFPSTATUS, updateStatus, UpdateStatus.class);
		List<IDAGEAGLead> idageagLeads = updateStatus.getIDAGEAGLeads();
		String idagPendingIds = updateStatus.getIDAGActionSSOID();
		if(!StringUtils.isBlank(idagPendingIds)){
			if(idagPendingIds.contains(currentUserId)){
				request.getSession().setAttribute(IDAG_AFFIRM_FLAG, ICFPConstants.Y_CAP);
			}else{
				request.getSession().setAttribute(IDAG_AFFIRM_FLAG, ICFPConstants.N_CAP);
			}
		}
		
		return idageagLeads;

	}

	/**
	 * Invoke the service to obtain all the TESG approvers yet to approve
	 * @param DealRequest
	 * @return List<RoleInfo>
	 * returns a list of Tesg Approvers for affiliated with a deal request
	 * @throws HWFStubException 
	 */
	private List<TesgList> getTESGApprovers(DealRequest dealRequest, HttpServletRequest request) throws HWFServiceException, HWFStubException {
		UpdateStatus updateStatus = new UpdateStatus();
		MsgHeader msgHeader = new MsgHeader();
		msgHeader.setOpcode(GETTESGAPPROVERS);
		updateStatus.setDealSeqId(String.valueOf(dealRequest.getDealSeqId()));
		String currentUserId = UserContext.getCurrentUserContext().getId();
		updateStatus.setApproverSSOId(currentUserId);
		updateStatus.setMsgHeader(msgHeader);
		updateStatus.setBusinessRequestId(dealRequest.getUniqueId());
		updateStatus.setDealSeqId(String.valueOf(dealRequest.getDealSeqId()));
		updateStatus.setActionId(ONE);
		updateStatus.setRoleId(ICFPConstants.FORTYSIX);
		CurrentInboxManager.updateWorkflowData(updateStatus, request);
		updateStatus = serviceClient.invokeService(UPDATEICFPSTATUS, updateStatus, UpdateStatus.class);
		List<TesgList> tesgList = updateStatus.getTesgLists();
		return tesgList;

	}
	/**
	 * Invoke the service to obtain all the TESG approvers who already Approved
	 * @param dealRequest
	 * @param request
	 * @return a list of Tesg Approvers for affiliated with a deal request
	 * @throws HWFServiceException
	 * @throws HWFStubException
	 */
	private List<TesgPopUp> getTESGApproversPopup(DealRequest dealRequest, HttpServletRequest request) throws HWFServiceException, HWFStubException {
		UpdateStatus updateStatus = new UpdateStatus();
		MsgHeader msgHeader = new MsgHeader();
		msgHeader.setOpcode(GETTESGACTIONS);
		updateStatus.setDealSeqId(String.valueOf(dealRequest.getDealSeqId()));
		String currentUserId = UserContext.getCurrentUserContext().getId();
		updateStatus.setApproverSSOId(currentUserId);
		updateStatus.setMsgHeader(msgHeader);
		updateStatus.setBusinessRequestId(dealRequest.getUniqueId());
		updateStatus.setDealSeqId(String.valueOf(dealRequest.getDealSeqId()));
		updateStatus.setActionId(ONE);
		updateStatus.setRoleId(ICFPConstants.FORTYSIX);
		CurrentInboxManager.updateWorkflowData(updateStatus, request);
		updateStatus = serviceClient.invokeService(UPDATEICFPSTATUS, updateStatus, UpdateStatus.class);
		List<TesgPopUp> tesgPopup = updateStatus.getTesgPopUps();
		return tesgPopup;

	}

	/**
	 * Opens the Leg Screen for the given legIDStr
	 * @param mapping
	 * @param request
	 * @param forward
	 * @param legIDStr
	 * @return
	 * @throws HWFServiceException
	 */
	private ActionForward displayLegDetails(ActionMapping mapping,
			HttpServletRequest request, ActionForward forward, String legIDStr) throws HWFServiceException,Exception {
		Object leg;
		int legID;
		legID = Integer.parseInt(legIDStr);// may throw Number Format Exception -- taken care by throws HWFServiceException
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		
		if (deal != null && deal.getLegs() != null
				&& deal.getLegs().getAllLegs() != null
				&& deal.getLegs().getAllLegs().size() > 0) {

			leg = CurrentDealManager.getLegByNumber(legID, request);
			if(leg != null){

				String proceedtoNextLeg = NO;

				if(legID == deal.getLegs().getAllLegs().size())
				{
					proceedtoNextLeg = YES;
				}
				request.setAttribute(PROCEEDTONEXTLEG, proceedtoNextLeg);

				request.setAttribute(ACTIONID, actionId);
				request.setAttribute(LEGNUMBER, legID);
				if(ICFPDay2LegHelper.isDay2Leg(leg)){
					 setCurrentLeg(request, leg);
					
					 String wfStage = CurrentInboxManager.getWorkflowStage(deal, request);
					 if(leg instanceof CPALegRequest && actionId == 3) {
						 forward = mapping.findForward(DAY2CPA_LEG);
					 } else {
						 forward = (wfStage.equals(CLOSEREQ)) ? mapping.findForward(DAY2TCM_OLEG): mapping.findForward(DAY2LEG);
					 }
				}else if(leg instanceof RCALegRequest) {
					CurrentDealManager.setCurrentLeg(leg, RCALegRequest.class,  request);
					forward = mapping.findForward(LEGSUMMARY);
				}else if(leg instanceof CPALegRequest) {
					CurrentDealManager.setCurrentLeg(leg, CPALegRequest.class, request);
					forward = mapping.findForward(LEG_SUMMARY_CPA);
				} else if(leg instanceof EquityLegRequest) {
					CurrentDealManager.setCurrentLeg(leg, EquityLegRequest.class,  request);
					if(((EquityLegRequest) leg).getOtherEquityComments()!=null){
						request.setAttribute(OTHERCOMMENTS,((EquityLegRequest) leg).getOtherEquityComments());
					}
					forward = mapping.findForward(EQUITY_LEGSUMMARY);
				} else if(leg instanceof OtherLegRequest) {
					CurrentDealManager.setCurrentLeg(leg, OtherLegRequest.class, request);
					forward = mapping.findForward(LEGSUMMARY);
					
					String path = forward.getPath();
					if(path!=null && path.contains(TRANSFER_PRICING_LEG_VIEW))
					{
						forward = mapping.findForward(OTHERLEGSUMMARY);
					}
					
				}
			}

		}
		return forward;
	}
	
	

	/**
	 * setCurrentLeg in the session  - Helper method
	 * @param request
	 * @param leg
	 */
	private void setCurrentLeg(HttpServletRequest request, Object leg) {
		if (leg instanceof RCALegRequest) {
			CurrentDealManager.setCurrentLeg(leg, RCALegRequest.class, request);
		} else if (leg instanceof CPALegRequest) {
			CurrentDealManager.setCurrentLeg(leg, CPALegRequest.class, request);
		} else if (leg instanceof EquityLegRequest) {
			CurrentDealManager.setCurrentLeg(leg, EquityLegRequest.class,
					request);
		} else if (leg instanceof OtherLegRequest) {
			CurrentDealManager.setCurrentLeg(leg, OtherLegRequest.class,
					request);
		}
	}


	/**
	 * Open CPA leg screen 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * forwards to screen that displays all the input screens
	 * @throws ICFPException 
	 */
	
	public ActionForward viewInputScreens(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws ICFPException{
		ActionForward forward=null;
		String source = request.getParameter(SOURCE);
		request.setAttribute(SOURCE,source);
		String legNumber = request.getParameter(ID);
		Integer legNumberInt = new Integer(legNumber);
		Object leg = CurrentDealManager.getLegByNumber(legNumberInt, request);
		request.setAttribute(LEGNUMBER, legNumberInt);
		if(ICFPDay2LegHelper.isDay2Leg(leg)){
			 request.setAttribute(ACTIONID, getActionId());
			 request.setAttribute(LEGNUMBER, legNumberInt);
			 forward = mapping.findForward(DAY2LEG);
			 
		}else{
			forward=mapping.findForward(VIEWINPUTSCREENS);
		}
		return forward;
	}
	
	/**
	 * Create Underwriting PDF file and sends it to download
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws ICFPException
	 * @throws IOException 
	 * @throws HWFStubException 
	 * @throws HWFServiceException 
	 */
	public ActionForward downloadUnderWritingFile(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws ICFPException, HWFServiceException, HWFStubException, IOException{
		
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		if(LOGGER.isInfoEnabled()) {
			String msg = new StringBuilder().append(EXPORTING_UNDERWRITING_PDF_FOR_DEAL).append(deal.getDealSeqId()).toString();
			LOGGER.info(msg);
		}
		
		DealPDFGenerator pdfGenerator = new DealPDFGenerator(deal);
		pdfGenerator.init(request, ReportType.UNDERWRITING);
		pdfGenerator.generate(request, response);
		
		if(LOGGER.isInfoEnabled()) {
			String msg = new StringBuilder().append(SUCCESSFULLY_EXPORTED_UNDERWRITING_THE_PDF_FOR_DEAL).append(deal.getDealSeqId()).toString();
			LOGGER.info(msg);
		}
		
		return null;
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