/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: PipelineReviewDealAction.java
 * Purpose:PipelineReviewDealAction used for review the deal,accept the deal, send back the deal 
 * and view the Leg when click on the action icon from the deal review screen.
 */
package com.ge.icfp.pipeline.action;

import static com.ge.icfp.common.constants.ICFPConstants.ACTIONID;
import static com.ge.icfp.common.constants.ICFPConstants.CASHMANAGEMENT;
import static com.ge.icfp.common.constants.ICFPConstants.CPA;
import static com.ge.icfp.common.constants.ICFPConstants.DEALREQUESTID;
import static com.ge.icfp.common.constants.ICFPConstants.EQUITY_SMALL;
import static com.ge.icfp.common.constants.ICFPConstants.EVENTTYPE;
import static com.ge.icfp.common.constants.ICFPConstants.EVENTTYPENAME;
import static com.ge.icfp.common.constants.ICFPConstants.FAILUREMSG;
import static com.ge.icfp.common.constants.ICFPConstants.FORWARD_HOMEPAGE;
import static com.ge.icfp.common.constants.ICFPConstants.FRONTOFFICE;
import static com.ge.icfp.common.constants.ICFPConstants.ID;
import static com.ge.icfp.common.constants.ICFPConstants.LEGEXIST;
import static com.ge.icfp.common.constants.ICFPConstants.LEGNUMBER;
import static com.ge.icfp.common.constants.ICFPConstants.LEGTYPE;
import static com.ge.icfp.common.constants.ICFPConstants.MIDDLEOFFICE;
import static com.ge.icfp.common.constants.ICFPConstants.NO_CAP;
import static com.ge.icfp.common.constants.ICFPConstants.ONLYPIPELINE;
import static com.ge.icfp.common.constants.ICFPConstants.OTHER_SMALL;
import static com.ge.icfp.common.constants.ICFPConstants.PLERIVEW;
import static com.ge.icfp.common.constants.ICFPConstants.PRODUCTTYPE;
import static com.ge.icfp.common.constants.ICFPConstants.RCA;
import static com.ge.icfp.common.constants.ICFPConstants.ROLEINFO;
import static com.ge.icfp.common.constants.ICFPConstants.SIX;
import static com.ge.icfp.common.constants.ICFPConstants.SOURCE;
import static com.ge.icfp.common.constants.ICFPConstants.SUCCESS;
import static com.ge.icfp.common.constants.ICFPConstants.TRANSACTIONEVENTTYPE;
import static com.ge.icfp.common.constants.ICFPConstants.TRESURYTAG;
import static com.ge.icfp.common.constants.ICFPConstants.TWENTYONE;
import static com.ge.icfp.common.constants.ICFPConstants.TWO;
import static com.ge.icfp.common.constants.ICFPConstants.UPDATEICFPSTATUS;
import static com.ge.icfp.common.constants.ICFPConstants.UPDATEMESSAGE;
import static com.ge.icfp.common.constants.ICFPConstants.UPDATESTATUSFORM;
import static com.ge.icfp.common.constants.ICFPConstants.USER_MGMT;
import static com.ge.icfp.common.constants.ICFPConstants.VALUEDT;
import static com.ge.icfp.common.constants.ICFPConstants.VIEWINPUTSCREENS;
import static com.ge.icfp.common.constants.ICFPConstants.YES_CAP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import com.ge.icfp.action.ICFPBaseAction;
import com.ge.icfp.action.ICFPException;
import com.ge.icfp.common.attachments.ICFPAttachmentManager;
import com.ge.icfp.common.attachments.validation.AttachmentValidator;
import com.ge.icfp.common.constants.ICFPConstants;
import com.ge.icfp.common.helper.CurrentDealManager;
import com.ge.icfp.common.helper.ICFPCommonHelper;
import com.ge.icfp.common.helper.ICFPDay2LegHelper;
import com.ge.icfp.common.helper.ICFPLegHelper;
import com.ge.icfp.common.vo.CPALegSummaryVO;
import com.ge.icfp.common.vo.LegSummaryVO;
import com.ge.icfp.model.CPALegRequest;
import com.ge.icfp.model.DealRequest;
import com.ge.icfp.model.DerivativesRequest;
import com.ge.icfp.model.EquityLegRequest;
import com.ge.icfp.model.MsgHeader;
import com.ge.icfp.model.OtherLegRequest;
import com.ge.icfp.model.RCALegRequest;
import com.ge.icfp.model.RoleInfo;
import com.ge.icfp.model.UpdateStatus;
import com.ge.icfp.model.UserInformation;
import com.ge.icfp.newrequest.form.vo.DerivativeDetailsVO;
import com.ge.icfp.util.EventType;
import com.ge.icfp.util.UserRole;
import com.ge.icfp.util.Utils;
import com.ge.icfp.util.WorkflowStages;
import com.hydus.wff.common.bw.ServiceClient;
import com.hydus.wff.core.config.vo.ProcessComponentVO;
import com.hydus.wff.core.context.UserContext;
import com.hydus.wff.core.exception.HWFServiceException;
import com.hydus.wff.core.exception.HWFStubException;

import formdef.plugin.FormMapping;
import formdef.plugin.util.FormUtils;
/**
 * PipelineReviewDealAction used for review the deal,accept the deal, send back the deal and view the Leg
 * @author kavitha.ramdeni
 * 
 */
public class PipelineReviewDealAction extends ICFPBaseAction {
	
	private static final String ACTIONBYPR = "ACTIONBYPR";

	private static final String ROLE_MAP = "roleMap";

	private static final String I_TREASURY_TAX = "(?i:.*TreasuryTax.*)";

	private static final String I_CASH_MANAGEMENT = "(?i:.*CashManagement.*)";

	private static final String I_FRONT_OFFICE = "(?i:.*FrontOffice.*)";

	private static final String I_MIDDLE_OFFICE = "(?i:.*MiddleOffice.*)";

	private static final String DAY2_VIEW_LEG = "day2ViewLeg";

	private static final String DERIVATE_DETAILS_VO_LIST = "derivateDetailsVOList";

	private static final String LEG_NO = "legNo";

	private static final String REVIEW_SUCCESS = "review_success";

	private static final String THERE_IS_NO_FURTHER_DEAL_TO_REVIEW = "There is no further Deal to Review";

	private static final String SELECTED_COMMENTS = "selectedComments";

	private static final String REJECT = "REJECT";

	private static final String ACCEPT_SUCCESS_MO = "accept_successMO";

	private static final String MO_PIPELINE = "MOPipeline";

	private static final String ACCEPT_SUCCESS = "accept_success";

	private static final String FO_PIPELINE = "FOPipeline";

	private static final String ACCEPT_SUCCESS_DASHBOARD = "accept_successDashboard";

	private static final String DASHBOARD = "dashboard";

	private static final String SOURCE_PAGE = "sourcePage";

	private static final String COMMENTS = "comments";

	private static final String ACCTION_COMMENTS = "acctionComments";

	private static final String ACCEPT = "ACCEPT";

	private static final String CPA_PIPELINE = "cpa_pipeline";

	private static final String WF_STAGE_ID_MSG = "wfStageIdMsg";

	private static final String WF_STAGE_ID_IS_ONE_BEFORE_APPROVALS = "Wf Stage Id is one before approvals";

	private static final String CREATOR_LOG_IN_ID = "creatorLogInId";

	private static final String CREATOR_CAN_NOT_BE_PERFORM_ACTIONS = "Creator can not be perform actions";

	private static final String TREASURY_TAX = "treasuryTax";

	private static final String TC_MO_FLAG = "tcMoFlag";

	private static final String CPA_LEG_DETAILS = "CpaLegDetails";

	private static final String LEG_DETAILS = "legDetails";

	private static final String DEAL_REQUEST_ATTR_ID = "DealRequestAttrID";

	
	/**
	 * serviceClient
	 */
	private ServiceClient serviceClient;
	/**
	 * attachmentManager
	 */
	private ICFPAttachmentManager attachmentManager;
	/**
	 * getServiceClient
	 * @return
	 */
	public ServiceClient getServiceClient() {
		return serviceClient;
	}
	/**
	 * setServiceClient
	 * @param serviceClient
	 */
	public void setServiceClient(ServiceClient serviceClient) {
		this.serviceClient = serviceClient;
	}

	/**
	 * 
	 * @return
	 */
	public ICFPAttachmentManager getAttachmentManager() {
		return attachmentManager;
	}
	/**
	 * 
	 * @param attachmentManager
	 */
	public void setAttachmentManager(ICFPAttachmentManager attachmentManager) {
		this.attachmentManager = attachmentManager;
	}

	/**
	 * This method is used to get the Deal information when click on deal id
	 * from the Pipeline Management screen
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws HWFStubException 
	 * @throws HWFServiceException
	 */
	public ActionForward getPipelineReviewDealDetail(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HWFServiceException, HWFStubException {
		String returnSummary = "";
		
		//Deal Team Section
	
	    Map <String, RoleInfo> roleMap = new HashMap<String, RoleInfo>();
		for (int i = 0; i < roleMap.size(); i++) {
			RoleInfo roleInfo = roleMap.get(i);
			roleMap.put(roleInfo.getSsoId(), roleInfo);
		}
		roleInfoInvocation(request,roleMap);
		
		String currentUserId = UserContext.getCurrentUserContext().getId();
		
		String requestID= request.getParameter(DEALREQUESTID);
		if(requestID!=null) {
			request.getSession().setAttribute(PipelineReviewDealAction.DEAL_REQUEST_ATTR_ID, requestID);
		}else{
			String dealRequestID =	(String)request.getSession().getAttribute(PipelineReviewDealAction.DEAL_REQUEST_ATTR_ID);
			if(dealRequestID!=null) {
				requestID=dealRequestID;
			}
		}
		request.getSession().setAttribute("currentAdditionalApprovers", null); 
		request.getSession().setAttribute("businessApproversList",null);
		DealRequest deal = ICFPCommonHelper.getDeal(Integer.valueOf(requestID), serviceClient);
			if (deal != null) {
			CurrentDealManager.setActiveDeal(deal, request);
			List<LegSummaryVO> legSummaryList = new ArrayList<LegSummaryVO>();
			List<CPALegSummaryVO> cpaSummaryList = new ArrayList<CPALegSummaryVO>();
			LegSummaryVO legSummary = null;
			CPALegSummaryVO CPALegSummary = null;
			List<Object> legList = deal.getLegs().getAllLegs();
			for(int i=1;i<=legList.size();i++){
				
				if(legList.get((i-1)) instanceof RCALegRequest){
					RCALegRequest rcaLeg = CurrentDealManager.getLegByNumber(i, RCALegRequest.class, request);
					legSummary = new LegSummaryVO(i, rcaLeg.getLegSummary(), request);
					returnSummary = RCA;
				}else if(legList.get((i-1)) instanceof EquityLegRequest){
					EquityLegRequest equityLeg = CurrentDealManager.getLegByNumber(i, EquityLegRequest.class, request);
					legSummary = new LegSummaryVO(i, equityLeg.getLegSummary(), request);
					returnSummary = EQUITY_SMALL;
				}else if(legList.get((i-1)) instanceof OtherLegRequest){
					OtherLegRequest otherLeg = CurrentDealManager.getLegByNumber(i, OtherLegRequest.class, request);
					legSummary = new LegSummaryVO(i, otherLeg.getLegSummary(), request);
					returnSummary = OTHER_SMALL;
				}else if(legList.get((i-1)) instanceof CPALegRequest){
					CPALegRequest cpaLeg = CurrentDealManager.getLegByNumber(i, CPALegRequest.class, request);
					CPALegSummary = new CPALegSummaryVO(i, cpaLeg.getCPASummary(),cpaLeg.getComments(),cpaLeg.getRateInformation(), cpaLeg.getTransactionCapturedInId());
					returnSummary = CPA;
					cpaSummaryList.add(CPALegSummary);
				}
				
				legSummaryList.add(legSummary);
			}
			request.getSession().setAttribute(PipelineReviewDealAction.LEG_DETAILS, legSummaryList);
			request.getSession().setAttribute(PipelineReviewDealAction.CPA_LEG_DETAILS, cpaSummaryList);
			Integer eventTypeId = deal.getEventTypeId();
			if (eventTypeId != null
					&& eventTypeId.intValue() == EventType.CORRECTION.getId()) {
				request.getSession().setAttribute(PipelineReviewDealAction.TC_MO_FLAG,true);
			}
			if( deal.getAdditionalApprovers() != null && deal.getAdditionalApprovers().getUserInfos() != null  && deal.getAdditionalApprovers().getUserInfos().size() > 0 ){
				request.getSession().setAttribute("currentAdditionalApprovers", deal.getAdditionalApprovers()); 
			}

			if( deal.getBusinessApprovers()!= null && deal.getBusinessApprovers().size() > 0 ){
				request.getSession().setAttribute("businessApproversList", deal.getBusinessApprovers());  
			}
			}
			DynaActionForm updateStatusForm = (DynaActionForm) form;
			
			updateStatusForm.set(FRONTOFFICE, ICFPConstants.ZERO);
			updateStatusForm.set(MIDDLEOFFICE, ICFPConstants.ZERO);
			updateStatusForm.set(CASHMANAGEMENT, ICFPConstants.ZERO);
			updateStatusForm.set(PipelineReviewDealAction.TREASURY_TAX, ICFPConstants.ZERO);
			
			int wfStageId = deal.getWFStageId();
			String sSoId = deal.getTransOwnerSsoId();
			if(sSoId.equalsIgnoreCase(currentUserId)){
				String creatorLogInId = PipelineReviewDealAction.CREATOR_CAN_NOT_BE_PERFORM_ACTIONS;
				request.setAttribute(PipelineReviewDealAction.CREATOR_LOG_IN_ID, creatorLogInId);
			}
			if (wfStageId > 1) {
				String wfStageIdMsg = PipelineReviewDealAction.WF_STAGE_ID_IS_ONE_BEFORE_APPROVALS;
				request.setAttribute(PipelineReviewDealAction.WF_STAGE_ID_MSG, wfStageIdMsg);
			}
			request.setAttribute(PRODUCTTYPE, returnSummary);
			if(!returnSummary.equals("")){
				request.setAttribute(LEGEXIST, YES_CAP);
			} else {
				request.setAttribute(LEGEXIST, NO_CAP);
			}
			Boolean isEquityDeal = CurrentDealManager.isEquityDeal(request);
			request.setAttribute(ICFPConstants.ISEQUITY,isEquityDeal);
			if(returnSummary.equalsIgnoreCase(CPA)){
				return mapping.findForward(PipelineReviewDealAction.CPA_PIPELINE);
			}
			else{
				return mapping.findForward(SUCCESS);
			}
			
	}


	/**
	 * This method used for accept the deal which is opened from Pipeline Management Screen
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse 
	 * @return ActionForward
	 * @throws HWFServiceException
	 * @throws HWFStubException 
	 * @throws ICFPException 
	 */
	public ActionForward acceptRequest(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HWFServiceException, HWFStubException, ICFPException {
		
		String productType = (String)request.getParameter(PRODUCTTYPE);	
        DynaActionForm dealRequestForm = (DynaActionForm) form; 		
		String valueDate = (String)dealRequestForm.getString(VALUEDT);
		
		DealRequest dealRequest = CurrentDealManager.getCurrentDeal(request);
		XMLGregorianCalendar dealRequestDate = dealRequest.getRequestDt();
		CurrentDealManager.syncCommentsWithFormObject(request);
		ActionErrors errors = null;
		errors = Utils.validateValueDt(valueDate,errors,dealRequestDate);	
		errors = AttachmentValidator.getInstance().validateDeal(request);
		if(errors!=null && !errors.isEmpty()) {
			
			saveErrors(request, errors);
			request.setAttribute(ICFPConstants.AMTERROR,"Please fix the following fields highlighted in red.");
			
			String sourcePage = (String) dealRequestForm.get(PipelineReviewDealAction.SOURCE_PAGE);
			if(sourcePage!=null) {
				dealRequestForm.set(PipelineReviewDealAction.SOURCE_PAGE, sourcePage);
			}
			
			if(productType!=null && productType.trim().equals(CPA)){
				return mapping.findForward(PipelineReviewDealAction.CPA_PIPELINE);
			}
			return mapping.getInputForward();
		}
		String actionId = TWENTYONE;
		String approveReject = ICFPConstants.ZERO;
		String approveFlag = PipelineReviewDealAction.ACCEPT;
	    
		//add the action comments
		dealRequestForm.set(PipelineReviewDealAction.ACCTION_COMMENTS, dealRequestForm.getString(PipelineReviewDealAction.COMMENTS) );
		
		submitDealRequest(dealRequestForm, mapping, form, request,actionId,approveReject,approveFlag);
		String sourcePage = (String) dealRequestForm.get(PipelineReviewDealAction.SOURCE_PAGE);
		String returnTo =null;
		if(sourcePage!=null && sourcePage.equals("")) {
			returnTo = "accept_successDashboard";
		}
		if( PipelineReviewDealAction.DASHBOARD.equals(sourcePage) ){
			returnTo = PipelineReviewDealAction.ACCEPT_SUCCESS_DASHBOARD;
		}else if(PipelineReviewDealAction.FO_PIPELINE.equals(sourcePage)){
			returnTo = PipelineReviewDealAction.ACCEPT_SUCCESS;
		}else if(PipelineReviewDealAction.MO_PIPELINE.equals(sourcePage)){
			returnTo = PipelineReviewDealAction.ACCEPT_SUCCESS_MO;
		}
		return mapping.findForward(returnTo);
	}
	

	/**
	 * This method used for send back the deal which is opened from Pipeline Management Screen
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws HWFServiceException
	 * @throws HWFStubException 
	 * @throws ICFPException 
	 */
	public ActionForward sendBack(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HWFServiceException, HWFStubException, ICFPException {
		
		    DynaActionForm dealRequestForm = (DynaActionForm) form; 						
			String valueDate = (String)dealRequestForm.getString(VALUEDT);
			String productType = (String)request.getParameter(PRODUCTTYPE);
			
			DealRequest dealRequest = CurrentDealManager.getCurrentDeal(request);
			XMLGregorianCalendar dealRequestDate = dealRequest.getRequestDt();
			CurrentDealManager.syncCommentsWithFormObject(request);
			ActionErrors errors = null;
			errors = Utils.validateValueDt(valueDate,errors,dealRequestDate);
			if(errors!=null && !errors.isEmpty()) {
				
				saveErrors(request, errors);
				
				if(productType!=null && productType.trim().equals(CPA)){
					return mapping.findForward(PipelineReviewDealAction.CPA_PIPELINE);
				}
				
				return mapping.getInputForward();
			}	
			String actionId = SIX;
			String approveReject = TWO;
			String rejectFlag = PipelineReviewDealAction.REJECT;
		
			//add the action comments
			
			String actionComments = request.getParameter(PipelineReviewDealAction.SELECTED_COMMENTS);
		
			dealRequestForm.set(PipelineReviewDealAction.ACCTION_COMMENTS,actionComments);
			submitDealRequest(dealRequestForm, mapping, form, request,actionId,approveReject,rejectFlag);
	
		return mapping.findForward("sendbank_success");

	}
		
	/**
	 * This method used for accept the deal which is opened from Pipeline Management Screen
	 * and review next deal if deal is available in the Pipeline Management Screen
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws HWFStubException 
	 * @throws ICFPException 
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public ActionForward reviewNextDeal(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HWFServiceException, HWFStubException, ICFPException {
		
		    DynaActionForm dealRequestForm = (DynaActionForm) form;
		    String valueDate = (String)dealRequestForm.getString(VALUEDT);
		    String productType = (String)request.getParameter(PRODUCTTYPE);
		    
		    DealRequest dealRequest = CurrentDealManager.getCurrentDeal(request);
			XMLGregorianCalendar dealRequestDate = dealRequest.getRequestDt();
			CurrentDealManager.syncCommentsWithFormObject(request);
			ActionErrors errors = null;	
			errors = Utils.validateValueDt(valueDate,errors,dealRequestDate);
			errors = AttachmentValidator.getInstance().validateDeal(request);
			if(errors!=null && !errors.isEmpty()) {
				
				saveErrors(request, errors);
				String sourcePage = (String) dealRequestForm.get(PipelineReviewDealAction.SOURCE_PAGE);
				if(sourcePage!=null) {
					dealRequestForm.set(PipelineReviewDealAction.SOURCE_PAGE, sourcePage);
				}
				if(productType!=null && productType.trim().equals(CPA)){
					return mapping.findForward(PipelineReviewDealAction.CPA_PIPELINE);
				}
				
				return mapping.getInputForward();
			}
						
			String actionId = TWENTYONE;
			String approveReject = ICFPConstants.ZERO;
			String approveFlag = PipelineReviewDealAction.ACCEPT;
			
			//add the action comments
			dealRequestForm.set(PipelineReviewDealAction.ACCTION_COMMENTS, dealRequestForm.getString(PipelineReviewDealAction.COMMENTS) );
			
			submitDealRequest(dealRequestForm, mapping, form, request,actionId,approveReject,approveFlag);

		// Fetch next req ID.
			DealRequest deal = CurrentDealManager.getCurrentDeal(request);
			String requestID = (deal.getDealSeqId() + "");
		     String nextReqID = null;
		     
		    List<String> pipelineDetailList;
			pipelineDetailList = (List<String>) request.getSession().getAttribute(ONLYPIPELINE);
					
			boolean current = false;	 
		     if (pipelineDetailList != null && pipelineDetailList.size() > 0) {
		    	
				for (int i = 0; i < pipelineDetailList.size(); i++) {
					String a = (String) pipelineDetailList.get(i);
					if(current == true)
			    	 {
			    		 nextReqID = a; 
			    		 break;
			    	 }
					if (a.equals(requestID)) {						
                    current = true;
					}
				}
				
			}	
		     if (nextReqID == null) {
		          String failureMsg = PipelineReviewDealAction.THERE_IS_NO_FURTHER_DEAL_TO_REVIEW;
		    	  request.setAttribute(FAILUREMSG, failureMsg);	    	 
		     }
			if (nextReqID != null) {	
				deal.setDealSeqId(Integer.valueOf(nextReqID));
				//Deal Team changes
			    Map <String, RoleInfo> roleMap = new HashMap<String, RoleInfo>();
				    for (int i = 0; i < roleMap.size(); i++) {
						RoleInfo roleInfo = roleMap.get(i);
						roleMap.put(roleInfo.getSsoId(), roleInfo);
						}
				roleInfoInvocation(request,roleMap);		
				DealRequest	dealRequest1 = ICFPCommonHelper.getDeal(Integer.valueOf(nextReqID), serviceClient);
					if (dealRequest1 != null) {
						CurrentDealManager.setActiveDeal(dealRequest1, request);
						request.getSession().setAttribute(PipelineReviewDealAction.DEAL_REQUEST_ATTR_ID, nextReqID);
					}
				return mapping.findForward(PipelineReviewDealAction.REVIEW_SUCCESS);
			}else{
				return mapping.findForward(FORWARD_HOMEPAGE);
			}
		}
	/**
	 * This method is used for open the Leg from Pipeline Review screen when click on action icon
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws HWFServiceException 
	 * @throws HWFStubException 
	 * @throws ICFPException 
	 */
	public ActionForward openLeg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HWFServiceException, HWFStubException, ICFPException {
		
		int legNumber = Integer.valueOf(request.getParameter(PipelineReviewDealAction.LEG_NO)).intValue();
		String reqID = (String) request.getSession().getAttribute(PipelineReviewDealAction.DEAL_REQUEST_ATTR_ID);
		Object leg = CurrentDealManager.getLegByNumber(legNumber, request);
		ICFPLegHelper.syncFormWithLeg((DynaActionForm) form, leg, request, getServlet().getServletContext(), mapping, this);
		List<DerivativeDetailsVO>  derivativeDetailsVOlist = new ArrayList<DerivativeDetailsVO>(); 
		if(leg instanceof RCALegRequest) {
			RCALegRequest rcaleg = (RCALegRequest)leg;
			for(DerivativesRequest derivativeRequest: rcaleg.getLegSummary().getDerivativesRequests()){
				DerivativeDetailsVO derivativeVO = Utils.createDerivativeDetailsVO(derivativeRequest, request);
				derivativeDetailsVOlist.add(derivativeVO);
			}
		}else if(leg instanceof OtherLegRequest) {
			OtherLegRequest otherLeg = (OtherLegRequest)leg;
			for(DerivativesRequest derivativeRequest: otherLeg.getLegSummary().getDerivativesRequests()){
				DerivativeDetailsVO derivativeVO = Utils.createDerivativeDetailsVO(derivativeRequest, request);
				derivativeDetailsVOlist.add(derivativeVO);
			}
		} 
		
		EventType eventType = getEventTypeInfo(request, leg);
		
		((DynaActionForm) form).set(LEGNUMBER, Integer.toString(legNumber));
		request.getSession().setAttribute(PipelineReviewDealAction.DEAL_REQUEST_ATTR_ID, reqID);
		request.setAttribute(PipelineReviewDealAction.DERIVATE_DETAILS_VO_LIST,derivativeDetailsVOlist);
		
		String strForward = getLegForwardRoute(request, legNumber, eventType);
		
		
		
		return mapping.findForward(strForward);
	}
	/**
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HWFServiceException
	 * @throws ICFPException 
	 */
	public ActionForward openCPALeg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HWFServiceException, ICFPException {
		int legNumber = Integer.valueOf(request.getParameter(PipelineReviewDealAction.LEG_NO)).intValue();
		String reqID = (String) request.getSession().getAttribute(PipelineReviewDealAction.DEAL_REQUEST_ATTR_ID);
		Object leg = CurrentDealManager.getLegByNumber(legNumber, request);
		ICFPLegHelper.syncFormWithLeg((DynaActionForm) form, leg, request, getServlet().getServletContext(), mapping, this);
		EventType eventType = getEventTypeInfo(request, leg);
		((DynaActionForm) form).set(LEGNUMBER, Integer.toString(legNumber));
		request.getSession().setAttribute(PipelineReviewDealAction.DEAL_REQUEST_ATTR_ID, reqID);
		String legForward = getLegForwardRoute(request, legNumber, eventType);
		return mapping.findForward(legForward);
	}
	
	/**
	 * @param request
	 * @param legNumber
	 * @param eventType
	 * @return
	 */
	private String getLegForwardRoute(HttpServletRequest request,
			int legNumber, EventType eventType) {
		String legForward = VIEWINPUTSCREENS;
		
		request.setAttribute(ACTIONID, 10);
		request.setAttribute(LEGNUMBER, legNumber);
		if(eventType != null) {
			legForward = PipelineReviewDealAction.DAY2_VIEW_LEG;
		}
		return legForward;
	}
	
	/**
	 * @param request
	 * @param leg
	 * @return
	 * @throws ICFPException
	 */
	private EventType getEventTypeInfo(HttpServletRequest request, Object leg)
			throws ICFPException {
		request.setAttribute(LEGTYPE, String.valueOf(ICFPLegHelper.getProductType(leg).getId()));
		EventType eventType = ICFPDay2LegHelper.getEventType(leg);
		if(eventType != null) {
			request.setAttribute(EVENTTYPE, String.valueOf(eventType.getId()));
			Object legSummaryObject = ICFPLegHelper.getLegSummary(leg);
			String eventTypeName = Utils.fetchPropertyValue(TRANSACTIONEVENTTYPE, legSummaryObject, String.class);
			request.setAttribute(EVENTTYPENAME, eventTypeName);
		}
		return eventType;
	}
	/**
	 * roleInfoInvocation for Deal Team selection
	 * @param request
	 * @throws HWFServiceException
	 * @throws HWFStubException 
	 */
	private void roleInfoInvocation(HttpServletRequest request,Map <String, RoleInfo> roleMap) throws HWFServiceException, HWFStubException {
		MsgHeader msgHeader1 = new MsgHeader();
		msgHeader1.setOpcode(ROLEINFO);
		UserInformation userInfo = new UserInformation();
		userInfo.setMsgHeader(msgHeader1);
		userInfo = serviceClient.invokeService(USER_MGMT, userInfo,UserInformation.class);
		if (userInfo != null) {
			ArrayList<RoleInfo> roleInfoList = (ArrayList<RoleInfo>) userInfo.getRoleInfos();
			RoleInfo roleInfo = new RoleInfo(); 
			List<ProcessComponentVO> processComp1 = new ArrayList<ProcessComponentVO>();
			List<ProcessComponentVO> processComp2 = new ArrayList<ProcessComponentVO>();
			List<ProcessComponentVO> processComp3 = new ArrayList<ProcessComponentVO>();
			List<ProcessComponentVO> processComp4 = new ArrayList<ProcessComponentVO>();
			
			for(int i=0;i<roleInfoList.size();i++)
			{
				roleInfo = (RoleInfo)roleInfoList.get(i);
				ProcessComponentVO processComp = new ProcessComponentVO();
				processComp.setId(String.valueOf(roleInfo.getRoleId()));
				processComp.setLabel(roleInfo.getRoleName());
				processComp.setId( roleInfo.getSsoId() );
				String UserName = roleInfo.getLastName() +" , " +roleInfo.getFirstName();
				
				processComp.setLabel(UserName);
				roleMap.put(roleInfo.getSsoId(), roleInfo);
				String roleName = roleInfo.getRoleName();
				if( roleName.matches( PipelineReviewDealAction.I_MIDDLE_OFFICE )){
				
					boolean isDuplicate = checkDuplicates(roleInfo,processComp1);
					if(isDuplicate){
						continue;
					}
					processComp1.add(processComp);
					roleMap.put(roleInfo.getSsoId(), roleInfo);
				}else if( roleName.matches( PipelineReviewDealAction.I_FRONT_OFFICE )){
					boolean isDuplicate = checkDuplicates(roleInfo,processComp2);
					if(isDuplicate){
						continue;
					}
					processComp2.add(processComp);
					roleMap.put(roleInfo.getSsoId(), roleInfo);
				}else if( roleName.matches( PipelineReviewDealAction.I_CASH_MANAGEMENT) ){
					boolean isDuplicate = checkDuplicates(roleInfo,processComp3);
					if(isDuplicate){
						continue;
					}
					processComp3.add(processComp);
				}else if( roleName.matches( PipelineReviewDealAction.I_TREASURY_TAX ) ){
					boolean isDuplicate = checkDuplicates(roleInfo,processComp4);
					if(isDuplicate){
						continue;
					}
					processComp4.add(processComp);
					roleMap.put(roleInfo.getSsoId(), roleInfo);
				}
			}
			request.getSession().setAttribute(MIDDLEOFFICE, processComp1);
			request.getSession().setAttribute(FRONTOFFICE, processComp2);
			request.getSession().setAttribute(CASHMANAGEMENT, processComp3);
			request.getSession().setAttribute(TRESURYTAG, processComp4);
			request.setAttribute(PipelineReviewDealAction.ROLE_MAP, roleMap);
			request.getSession().setAttribute(PipelineReviewDealAction.ROLE_MAP, roleInfoList);
		}
		
	}
	
	/**
	 * dealTeamInvocation for Deal Team
	 * @param request
	 * @throws HWFServiceException
	 * @throws HWFStubException 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void dealTeamInvocation(HttpServletRequest request,UpdateStatus updateStatus) throws HWFServiceException, HWFStubException {
		
		ArrayList <RoleInfo> roleInfoList = (ArrayList)request.getSession().getAttribute(PipelineReviewDealAction.ROLE_MAP);
		RoleInfo roleInfo = new RoleInfo(); 
				
			for(int i=0;i<roleInfoList.size();i++)
			{
				roleInfo = (RoleInfo)roleInfoList.get(i);
				String roleName = roleInfo.getRoleName();
			
				if( roleName.matches( PipelineReviewDealAction.I_MIDDLE_OFFICE )){
				  
					if(roleInfo.getSsoId().equals(updateStatus.getMiddleOffice())){
					String middleOfficeFirstName = roleInfo.getFirstName();
					String middleOfficeLastName = roleInfo.getLastName();
					String middleRoleName = roleInfo.getRoleName();
					Integer middleRoleId = roleInfo.getRoleId();
					updateStatus.setMiddleOfficeFirstName(middleOfficeFirstName);
					updateStatus.setMiddleOfficeLastName(middleOfficeLastName);
					updateStatus.setMiddleOfficeRoleId(middleRoleId+ "");
			
					updateStatus.setMiddleOfficeRoleName(middleRoleName);
				}
				}else if( roleName.matches( PipelineReviewDealAction.I_FRONT_OFFICE )){
					if(roleInfo.getSsoId().equals(updateStatus.getFrontOffice())){
					String frontOfficeFirstName = roleInfo.getFirstName();
					String frontOfficeLastName = roleInfo.getLastName();
					String frontOfficeRoleName = roleInfo.getRoleName();
					
					Integer frontOfficeRoleId = roleInfo.getRoleId();
					updateStatus.setFrontOfficeFirstName(frontOfficeFirstName);
					updateStatus.setFrontOfficeLastName(frontOfficeLastName);
			
					updateStatus.setFrontOfficeRoleName(frontOfficeRoleName);
					updateStatus.setFrontOfficeRoleId(frontOfficeRoleId+ "");
				}
				}else if( roleName.matches( PipelineReviewDealAction.I_CASH_MANAGEMENT) ){
					if(roleInfo.getSsoId().equals(updateStatus.getCashManagement())){
					String cashManagementFirstName = roleInfo.getFirstName();
					String cashManagementLastName = roleInfo.getLastName();
					String cashManagementRoleName = roleInfo.getRoleName();
					Integer cashManagementRoleId = roleInfo.getRoleId();
					updateStatus.setCashManagementFirstName(cashManagementFirstName);
					updateStatus.setCashManagementLastName(cashManagementLastName);
	
					updateStatus.setCashManagementRoleName(cashManagementRoleName);
					updateStatus.setCashManagementRoleId(cashManagementRoleId+ "");
				}
				}else if( roleName.matches( PipelineReviewDealAction.I_TREASURY_TAX ) ){
					if(roleInfo.getSsoId().equals(updateStatus.getTreasuryTax())){
					String treasuryTaxFirstName = roleInfo.getFirstName();
					String treasuryTaxLastName = roleInfo.getLastName();
					String treasuryTaxRoleName = roleInfo.getRoleName();
					Integer treasuryTaxtRoleId = roleInfo.getRoleId();
					updateStatus.setTreasuryTaxFirstName(treasuryTaxFirstName);
					updateStatus.setTreasuryTaxLastName(treasuryTaxLastName);
					updateStatus.setTreasuryTaxRoleName(treasuryTaxRoleName);
					updateStatus.setTreasuryTaxRoleId(treasuryTaxtRoleId+ "");
				}
				}
				
			}
			
		}
	/**
	 * 
	 * @param roleInfo
	 * @param processComp
	 * @return
	 */
	private boolean checkDuplicates(RoleInfo roleInfo, List<ProcessComponentVO> processComp) {
		boolean isAvailable = false;
		for(ProcessComponentVO oldProcessComp : processComp) {
			if (roleInfo.getSsoId().equals(oldProcessComp.getId())) {
				isAvailable = true;
				break;
			}
		}
		return isAvailable;
	}
	/**
	 * submitDealRequest
	 * @param dealRequestForm
	 * @param mapping
	 * @param form
	 * @param request
	 * @param actionId
	 * @param approveReject
	 * @param approveFlag
	 * @throws HWFServiceException
	 * @throws HWFStubException 
	 * @throws ICFPException 
	 */
	private void submitDealRequest(DynaActionForm dealRequestForm,
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			String actionId, String approveReject, String approveRejectFlag)
			throws HWFServiceException, HWFStubException, ICFPException {

		UpdateStatus updateStatus = new UpdateStatus();
		
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		FormMapping formMapping = FormUtils.getInstance().findFormDefinition(UPDATESTATUSFORM, getServlet().getServletContext(), mapping.getModuleConfig());
		FormUtils.getInstance().populateBeanFromForm(formMapping, updateStatus, dealRequestForm, this, mapping, request);
		dealTeamInvocation(request,updateStatus);
		updateStatus.setActionId(actionId);
		updateStatus.setApproveReject(approveReject);
		updateStatus.setStatusId(approveRejectFlag);
		String currentUserId = UserContext.getCurrentUserContext().getId();
		String firstName = UserContext.getCurrentUserContext().getFirstName();
		String lastName = UserContext.getCurrentUserContext().getLastName();
		updateStatus.setApproverSSOId(currentUserId);
	    updateStatus.setWFStageID(String.valueOf(WorkflowStages.INITIATION.getId()));
		updateStatus.setWFStage(PLERIVEW);
		updateStatus.setRoleId(String.valueOf(UserRole.PipelineReviewer.getId()));
		MsgHeader msgHeader = new MsgHeader();
		msgHeader.setOpcode(PipelineReviewDealAction.ACTIONBYPR);
		msgHeader.setAuditModifier(currentUserId);
		msgHeader.setAuditModifierFirstName(firstName);
		msgHeader.setAuditModifierLastName(lastName);
		msgHeader.setAuditCreator(currentUserId);
		msgHeader.setAuditCreatorFirstName(firstName);
		msgHeader.setAuditCreatorLastName(lastName);
		updateStatus.setMsgHeader(msgHeader);
		
	
		//Business ID
		updateStatus.setApproverFname(firstName);
		updateStatus.setApproverLname(lastName);
		updateStatus.setApproverSSOId(currentUserId);
		updateStatus.setBusinessRequestId(deal.getUniqueId());
	
		CurrentDealManager.setDealObjectToUpdateStatusComments(deal, updateStatus, request);
		
		CurrentDealManager.syncPropertiesforMeta(deal,updateStatus,request); // Method used for update meta info
		attachmentManager.updateMetadataForAllAttachments(deal);
		updateStatus = serviceClient.invokeService(UPDATEICFPSTATUS, updateStatus, UpdateStatus.class);
	 
		if (updateStatus != null) {
			String updateMsg = updateStatus.getComments();
			String uniqueId = deal.getUniqueId();
			String updateMsg1 = "Deal ID: " + uniqueId + " has been "
					+ updateMsg;
			request.setAttribute(UPDATEMESSAGE, updateMsg1);
		}
		
		
	}
	
	/**
	 * viewInputScreens
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * forwards to screen that displays all the input screens
	 */
	
	public ActionForward viewInputScreens(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws ICFPException{
		
		String source = request.getParameter(SOURCE);
		request.setAttribute(SOURCE,source);
		int legNumber = Integer.valueOf(request.getParameter(ID)).intValue();
		Object leg = CurrentDealManager.getLegByNumber(legNumber, request);
		EventType eventType = getEventTypeInfo(request, leg);
		String strForward = getLegForwardRoute(request, legNumber, eventType);
		return mapping.findForward(strForward);
	}
			
}
