/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: NewFundingRequestAction.java
 * Purpose: NewFundingRequestAction used for the all leg and deal operations
 */
package com.ge.icfp.newrequest.action;


import static com.ge.icfp.common.constants.ICFPConstants.ADDCPAREQUEST;
import static com.ge.icfp.common.constants.ICFPConstants.ADDLEG;
import static com.ge.icfp.common.constants.ICFPConstants.CASHMANAGEMENT;
import static com.ge.icfp.common.constants.ICFPConstants.CPA;
import static com.ge.icfp.common.constants.ICFPConstants.DEAL;
import static com.ge.icfp.common.constants.ICFPConstants.DEALREQUESTID;
import static com.ge.icfp.common.constants.ICFPConstants.DELETELEG;
import static com.ge.icfp.common.constants.ICFPConstants.DRAFT_GLOBEL;
import static com.ge.icfp.common.constants.ICFPConstants.EVENTTYPE;
import static com.ge.icfp.common.constants.ICFPConstants.EVENTTYPEID;
import static com.ge.icfp.common.constants.ICFPConstants.EVENTTYPENAME;
import static com.ge.icfp.common.constants.ICFPConstants.EVENTTYPES;
import static com.ge.icfp.common.constants.ICFPConstants.FORWARD_HOMEPAGE;
import static com.ge.icfp.common.constants.ICFPConstants.FRONTOFFICE;
import static com.ge.icfp.common.constants.ICFPConstants.GETTREQID;
import static com.ge.icfp.common.constants.ICFPConstants.ICFFO_CASHMANAGEMENT_MEMBER;
import static com.ge.icfp.common.constants.ICFPConstants.ICFFO_FRONTOFFICE_MEMBER;
import static com.ge.icfp.common.constants.ICFPConstants.ICFFO_MIDDLEOFFICE_MEMBER;
import static com.ge.icfp.common.constants.ICFPConstants.ICFFO_TREASURYTAX_MEMBER;
import static com.ge.icfp.common.constants.ICFPConstants.INSERT;
import static com.ge.icfp.common.constants.ICFPConstants.INSERTDEAL;
import static com.ge.icfp.common.constants.ICFPConstants.LEGERRORS;
import static com.ge.icfp.common.constants.ICFPConstants.LEGEXIST;
import static com.ge.icfp.common.constants.ICFPConstants.LEGNUMBER;
import static com.ge.icfp.common.constants.ICFPConstants.LEGS_ERRMSG;
import static com.ge.icfp.common.constants.ICFPConstants.LEGTYPE;
import static com.ge.icfp.common.constants.ICFPConstants.LEGTYPEID;
import static com.ge.icfp.common.constants.ICFPConstants.MIDDLEOFFICE;
import static com.ge.icfp.common.constants.ICFPConstants.MODIFY;
import static com.ge.icfp.common.constants.ICFPConstants.MYTASKS_SMALL;
import static com.ge.icfp.common.constants.ICFPConstants.NO_CAP;
import static com.ge.icfp.common.constants.ICFPConstants.PRODUCTTYPE;
import static com.ge.icfp.common.constants.ICFPConstants.REMOVECURRENT;
import static com.ge.icfp.common.constants.ICFPConstants.ROLEINFO;
import static com.ge.icfp.common.constants.ICFPConstants.SECTION;
import static com.ge.icfp.common.constants.ICFPConstants.STATICDATA;
import static com.ge.icfp.common.constants.ICFPConstants.SUCCESS;
import static com.ge.icfp.common.constants.ICFPConstants.SUCCESSCPA;
import static com.ge.icfp.common.constants.ICFPConstants.SUCCESSMSG;
import static com.ge.icfp.common.constants.ICFPConstants.TEN;
import static com.ge.icfp.common.constants.ICFPConstants.TRESURYTAG;
import static com.ge.icfp.common.constants.ICFPConstants.TRUE_SMALL;
import static com.ge.icfp.common.constants.ICFPConstants.UPDATEMESSAGE;
import static com.ge.icfp.common.constants.ICFPConstants.USER_MGMT;
import static com.ge.icfp.common.constants.ICFPConstants.VALUEDT;
import static com.ge.icfp.common.constants.ICFPConstants.VAULTREQUESTID;
import static com.ge.icfp.common.constants.ICFPConstants.YES_CAP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.DynaActionForm;

import com.ge.icfp.action.ICFPBaseAction;
import com.ge.icfp.action.ICFPException;
import com.ge.icfp.common.attachments.ICFPAttachmentException;
import com.ge.icfp.common.attachments.ICFPAttachmentManager;
import com.ge.icfp.common.attachments.validation.AttachmentValidator;
import com.ge.icfp.common.constants.ICFPConstants;
import com.ge.icfp.common.helper.CurrentDealManager;
import com.ge.icfp.common.helper.CurrentInboxManager;
import com.ge.icfp.common.helper.ICFPCommonHelper;
import com.ge.icfp.common.helper.ICFPLegHelper;
import com.ge.icfp.model.CPALegRequest;
import com.ge.icfp.model.DealRequest;
import com.ge.icfp.model.EquityLegRequest;
import com.ge.icfp.model.Legs;
import com.ge.icfp.model.MsgHeader;
import com.ge.icfp.model.OtherLegRequest;
import com.ge.icfp.model.RCALegRequest;
import com.ge.icfp.model.RoleInfo;
import com.ge.icfp.model.StaticDataManagement;
import com.ge.icfp.model.StaticDataManagement.TransactionEventTypes;
import com.ge.icfp.model.UserInformation;
import com.ge.icfp.rules.RuleExecutor;
import com.ge.icfp.tag.DealManager;
import com.ge.icfp.util.DateUtil;
import com.hydus.wff.common.bw.ServiceClient;
import com.hydus.wff.core.config.vo.ProcessComponentVO;
import com.hydus.wff.core.context.UserContext;
import com.hydus.wff.core.exception.HWFServiceException;
import com.hydus.wff.core.exception.HWFStubException;
import com.hydus.wff.core.session.SessionManager;

import formdef.plugin.FormMapping;
import formdef.plugin.util.FormUtils;
/**
 * NewFundingRequestAction used for the all leg and deal operations
 * @author srinivasan.desa
 *
 */
public class NewFundingRequestAction extends ICFPBaseAction {
	
	private static final String SUCCESSCPA_SMALL = "successcpa";
	private static final String ICFFO_MIDDLE_OFFICE = "ICFFO-MiddleOffice";
	private static final String SUBMIT = "SUBMIT";
	private static final String HOME = "home";
	private static final String RESUBMIT = "RESUBMIT";
	private static final String WITHDRAW = "WITHDRAW";
	private static final String DRAFT_SAVED_SUCCESSFULLY_AND_REQUEST_ID_IS = "Draft saved successfully and Request Id is # ";
	private static final String HAS_BEEN_WITH_DRAWN_SUCCESSFULLY = " has been with drawn successfully";
	private static final String REQUEST_ID_IS = "Request Id is # ";
	private static final String LATEST_DT_OF_FIN_STTMNT = "latestDtOfFinSttmnt";
	private static final String CLONE_FLAG = "cloneFlag";
	private static final String MY_REQUESTS = "myRequests";
	private static final String WF_STAGE = "wfStage";
	private static final String DEAL_REQUEST_FORM = "dealRequestForm";
	private static final String DATE_FORMAT = "MM/dd/yyyy";
	private ServiceClient serviceClient;
	private ICFPAttachmentManager attachmentManager;
	
	public ICFPAttachmentManager getAttachmentManager() {
		return attachmentManager;
	}

	public void setAttachmentManager(ICFPAttachmentManager attachmentManager) {
		this.attachmentManager = attachmentManager;
	}

	/**
	 * Method used to open the new CPA Deal or Deal
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HWFServiceException 
	 * @throws NumberFormatException 
	 */
	public ActionForward openCurrentDealRequest(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, HWFServiceException {
		ActionForward forward = (request.getParameter(PRODUCTTYPE)!=null && request.getParameter(PRODUCTTYPE).equalsIgnoreCase(CPA))
				? mapping.findForward(SUCCESSCPA)
				: mapping.findForward(SUCCESS);
		return forward;
	}
	
	/**
	 * Method used to open the CPA Deal or Deal in edit mode
	 * @param mappingsss
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HWFServiceException 
	 * @throws NumberFormatException 
	 * @throws HWFStubException 
	 */
	public ActionForward load(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, HWFServiceException, HWFStubException {
		String requestID = request.getParameter(DEALREQUESTID);
		DealRequest dealRequest = null;
		ActionForward forward = null;
		roleInfoInvocation(request);
		if(requestID!=null){
			dealRequest = ICFPCommonHelper.getDeal(Integer.valueOf(requestID), serviceClient);
			CurrentDealManager.setActiveDeal(dealRequest, request);
			FormUtils.getInstance().populateForm(NewFundingRequestAction.DEAL_REQUEST_FORM, form, dealRequest, mapping.getModuleConfig(),this, mapping, request);
		}
		request.getSession().setAttribute("currentAdditionalApprovers", null); 
		request.getSession().setAttribute("businessApproversList",null);
		if(dealRequest != null){
			//Additional Approvers BEGIN
			if( dealRequest.getAdditionalApprovers() != null && dealRequest.getAdditionalApprovers().getUserInfos() != null  && dealRequest.getAdditionalApprovers().getUserInfos().size() > 0 ){
				request.getSession().setAttribute("currentAdditionalApprovers", dealRequest.getAdditionalApprovers()); 
			}
			//Additional Approvers END

			if( dealRequest.getBusinessApprovers()!= null && dealRequest.getBusinessApprovers().size() > 0 ){
				request.getSession().setAttribute("businessApproversList", dealRequest.getBusinessApprovers());  
			}
		}
		String task =(String)request.getParameter(SECTION); 
		
		if(task!=null && task.equals(MYTASKS_SMALL)){
			String wfStage = CurrentInboxManager.getWorkflowStage(dealRequest, request);
			request.setAttribute(NewFundingRequestAction.WF_STAGE, wfStage);
			request.getSession().setAttribute(SECTION, task);
		}else{
			request.getSession().setAttribute(SECTION, NewFundingRequestAction.MY_REQUESTS);
		}
		Boolean isEquityDeal = CurrentDealManager.isEquityDeal(request);
		Boolean isCPADeal = CurrentDealManager.isCPADeal(request);
		request.setAttribute(ICFPConstants.ISCPA,isCPADeal);
		request.setAttribute(ICFPConstants.ISEQUITY,isEquityDeal);
		
		request.getSession().removeAttribute(VAULTREQUESTID);
		if(CurrentDealManager.isCPADeal(request)!=null && CurrentDealManager.isCPADeal(request)) {
			request.getSession().setAttribute(VAULTREQUESTID, dealRequest.getVaultId());
			forward = mapping.findForward(SUCCESSCPA);
		} else {
			return mapping.findForward(SUCCESS);
		}
		return forward;
	}

	/**
	 * Method used to open  the new deal request screen
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HWFServiceException 
	 * @throws HWFStubException 
	 */
	public ActionForward newRequest(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws HWFServiceException, HWFStubException {
		
		String productType = (String)request.getParameter(PRODUCTTYPE);
		DealRequest dealRequest = new DealRequest();
		prepareMsgHeader(dealRequest, GETTREQID, null,0);
		prepareFirstLastName(dealRequest);
		
		dealRequest = serviceClient.invokeService(DEAL, dealRequest,DealRequest.class);
		CurrentDealManager.setActiveDeal(dealRequest, request);
		FormUtils.getInstance().populateForm(NewFundingRequestAction.DEAL_REQUEST_FORM, form,dealRequest, mapping.getModuleConfig(), this, mapping,request);
	    ((DynaActionForm)form).set(LEGTYPEID, "");
		request.setAttribute(LEGEXIST, NO_CAP);
		CurrentDealManager.syncCommentsWithFormObject(request);
		request.getSession().removeAttribute(VAULTREQUESTID);
		if(productType!=null && productType.equals(CPA))
		{
			request.getSession().setAttribute(VAULTREQUESTID, dealRequest.getVaultId());
		}
		
		request.getSession().setAttribute(SECTION, NewFundingRequestAction.MY_REQUESTS);
		
		return (productType!=null && productType.equals(CPA)) 
				? mapping.findForward(NewFundingRequestAction.SUCCESSCPA_SMALL)
				: mapping.findForward(SUCCESS);
	}
	
	
	/**
	 * Method used to open  the deal which is cloned by another deal
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HWFServiceException 
	 * @throws HWFStubException 
	 */
	public ActionForward cloneDeal(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws HWFServiceException, HWFStubException,Exception {
		DealRequest dealRequest = ICFPCommonHelper.setCloneDeal(mapping, form,request, response,serviceClient);
	    String productType = (String)request.getAttribute(PRODUCTTYPE);
	    FormUtils.getInstance().populateForm(NewFundingRequestAction.DEAL_REQUEST_FORM, form,dealRequest, mapping.getModuleConfig(), this, mapping,request);
	    CurrentDealManager.syncCommentsWithFormObject(request);
		request.getSession().removeAttribute(VAULTREQUESTID);
		((DynaActionForm)form).set(NewFundingRequestAction.CLONE_FLAG, TRUE_SMALL);
		
		if(productType!=null && productType.equals(CPA))
		{
			request.getSession().setAttribute(VAULTREQUESTID, dealRequest.getVaultId());
		} 
		request.getSession().setAttribute(SECTION, MYTASKS_SMALL);
		request.setAttribute(CLONE_FLAG,TRUE_SMALL);
		saveAsDraft(mapping, form, request, response);
		return (productType!=null && productType.equals(CPA)) 
				? mapping.findForward(NewFundingRequestAction.SUCCESSCPA_SMALL)
				: mapping.findForward(SUCCESS);
				
	}
	
	/**
	 * Method is used to validate the "value date" and "last date of financial statement."
	 * @param dealRequestForm
	 * @param request
	 */
	private void validate(DealRequest dealRequest, DynaActionForm dealRequestForm, HttpServletRequest request, boolean isDraft) {
		ActionErrors errors = null;
		String valueDate = dealRequestForm.getString(VALUEDT);
		if(valueDate!=null && valueDate.trim().length()>0) {			
			errors = DateUtil.validateValueDt(valueDate,errors);
		}
		String latestDtOfFinSttmnt = (String)dealRequestForm.getString(NewFundingRequestAction.LATEST_DT_OF_FIN_STTMNT);
		if(latestDtOfFinSttmnt!=null && latestDtOfFinSttmnt.trim().length()>0){
			errors = DateUtil.validateLatestDtOfFinSttmnt(latestDtOfFinSttmnt,errors);
		}
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
					isValidated = rcaLeg.getLegSummary().getRequesterValidateFlag();
					legNumber = rcaLeg.getLegSummary().getLegSeqId();
					
					String eventType = rcaLeg.getLegSummary().getTransactionEventType();
					/**
					 * Code to validate draw down date
					 */
					//Immediate Drawdown
					XMLGregorianCalendar drawDownDate = rcaLeg.getDrdownValueDt();
					String drawDownDtStr = "";
					if(drawDownDate!=null && eventType!=null &&  drawDownDate.toString().length()>=10 
							&& !eventType.equals("Immediate Drawdown"))
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
				} else if(leg instanceof EquityLegRequest) {
					EquityLegRequest equityLeg = (EquityLegRequest) leg;
					isValidated = equityLeg.getLegSummary().getRequesterValidateFlag();
					legNumber = equityLeg.getLegSummary().getLegSeqId();
				} else if(leg instanceof OtherLegRequest) {
					OtherLegRequest otherLeg = (OtherLegRequest) leg;
					isValidated = otherLeg.getLegSummary().getRequesterValidateFlag();
					legNumber = otherLeg.getLegSummary().getLegSeqId();
				} else if(leg instanceof CPALegRequest) {
					CPALegRequest cpaLeg = (CPALegRequest) leg;
					isValidated = cpaLeg.getCPASummary().getRequesterValidateFlag();
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
				errorMsg = errorMsg+" were not validated. Please return to the leg and click on Save and return to Deal to validate";
				errors.add(LEGERRORS, new ActionMessage(LEGERRORS , errorMsg));
			}
			
		}

		if(errors!=null && !errors.isEmpty()) {
			saveErrors(request, errors);
		}
		
	}
	
	/**
	 * Method is used to save the deal in the draft format
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HWFServiceException
	 * @throws HWFStubException 
	 * @throws ICFPException 
	 * @throws ICFPAttachmentException 
	 */
	public ActionForward saveAsDraft(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws HWFServiceException, HWFStubException, ICFPAttachmentException, ICFPException {
		ActionForward forward = null;
		DynaActionForm dealRequestForm = (DynaActionForm) form;
		int size = DealManager.getTotalNumberofLegs(request);
		
		
		if(size==0) { 
			request.setAttribute(LEGEXIST, NO_CAP);
		} else {
			request.setAttribute(LEGEXIST, YES_CAP);
		}
		CurrentDealManager.syncCommentsWithFormObject(request);
		String requestID = null;
		if(getErrors(request).isEmpty()) {
			DealRequest dealRequest = CurrentDealManager.getCurrentDeal(request);
			requestID = dealRequest.getDealSeqId().toString();
			FormMapping formMapping = FormUtils.getInstance().findFormDefinition(NewFundingRequestAction.DEAL_REQUEST_FORM,getServlet().getServletContext(),mapping.getModuleConfig());
			FormUtils.getInstance().populateBeanFromForm(formMapping,dealRequest, dealRequestForm, this, mapping, request);
			prepareMsgHeader(dealRequest, INSERTDEAL, DRAFT_GLOBEL,1);
				
			
			
			String cloneFlag = request.getParameter(NewFundingRequestAction.CLONE_FLAG);
			
			boolean showMessage = true;
			
			if(cloneFlag==null || StringUtils.isEmpty(cloneFlag))
			{
				cloneFlag = (String)request.getAttribute(NewFundingRequestAction.CLONE_FLAG);
				
				if(cloneFlag!=null && cloneFlag.equals(TRUE_SMALL))
				{
				  showMessage = false;
				}
			}
			
			if(cloneFlag!=null && cloneFlag.equals(TRUE_SMALL))
			{
				setCloneLegOpCode(dealRequest);	
			}
			attachmentManager.updateMetadataForAllAttachments(dealRequest);
			dealRequest = serviceClient.invokeService(DEAL, dealRequest,DealRequest.class);
			request.getSession().removeAttribute(REMOVECURRENT);
			
			dealRequest = ICFPCommonHelper.getDeal(Integer.valueOf(requestID), serviceClient);
			CurrentDealManager.setActiveDeal(dealRequest, request);
			FormUtils.getInstance().populateForm(NewFundingRequestAction.DEAL_REQUEST_FORM, form, dealRequest, mapping.getModuleConfig(),this, mapping, request);
		
			if(showMessage){
			   request.setAttribute(SUCCESSMSG,NewFundingRequestAction.DRAFT_SAVED_SUCCESSFULLY_AND_REQUEST_ID_IS+dealRequest.getUniqueId());
			}
			forward = mapping.findForward(SUCCESS);
		} else {
			forward = mapping.getInputForward();
		}
		return forward;
	}
	
	/**
	 * This will with draw the request.
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HWFServiceException
	 * @throws HWFStubException
	 * @throws ICFPException 
	 * @throws ICFPAttachmentException 
	 */
	public ActionForward withdrawRequest(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws HWFServiceException, HWFStubException, ICFPAttachmentException, ICFPException {
		ActionForward forward = null;
		DynaActionForm dealRequestForm = (DynaActionForm) form;
		int size = DealManager.getTotalNumberofLegs(request);
		
		
		if(size==0) { 
			request.setAttribute(LEGEXIST, NO_CAP);
		} else {
			request.setAttribute(LEGEXIST, YES_CAP);
		}
		if(getErrors(request).isEmpty()) {
			DealRequest dealRequest = CurrentDealManager.getCurrentDeal(request);
			FormMapping formMapping = FormUtils.getInstance().findFormDefinition(NewFundingRequestAction.DEAL_REQUEST_FORM,getServlet().getServletContext(),mapping.getModuleConfig());
			FormUtils.getInstance().populateBeanFromForm(formMapping,dealRequest, dealRequestForm, this, mapping, request);
			prepareMsgHeader(dealRequest, INSERTDEAL, NewFundingRequestAction.WITHDRAW,24);
			attachmentManager.deleteAllAttachments(dealRequest);
			dealRequest = serviceClient.invokeService(DEAL, dealRequest,DealRequest.class);
			request.getSession().removeAttribute(REMOVECURRENT);
			request.setAttribute(UPDATEMESSAGE,NewFundingRequestAction.REQUEST_ID_IS+dealRequest.getUniqueId()+NewFundingRequestAction.HAS_BEEN_WITH_DRAWN_SUCCESSFULLY);
			forward = mapping.findForward(NewFundingRequestAction.HOME);
		} else {
			forward = mapping.getInputForward();
		}
		return forward;
	}
	
	/**
	 * This will re submit the request
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HWFServiceException
	 * @throws HWFStubException
	 * @throws ICFPAttachmentException 
	 */
	public ActionForward reSubmitRequest(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws HWFServiceException, HWFStubException, ICFPException  {
		ActionForward forward = null;
		DynaActionForm dealRequestForm = (DynaActionForm) form;
		int size = DealManager.getTotalNumberofLegs(request);
		
		
		if(size==0) { 
			request.setAttribute(LEGEXIST, NO_CAP);
		} else {
			request.setAttribute(LEGEXIST, YES_CAP);
		}
		DealRequest dealRequest = CurrentDealManager.getCurrentDeal(request);
		validate(dealRequest, dealRequestForm, request, true);
		CurrentDealManager.syncCommentsWithFormObject(request);
		if(getErrors(request).isEmpty()) {
			ActionErrors errors = AttachmentValidator.getInstance().validateDeal(request);
			if(!errors.isEmpty()) {
				saveErrors(request, errors);
				request.setAttribute(ICFPConstants.AMTERROR,"Please fix the following fields highlighted in red.");
			}
			if(getErrors(request).isEmpty()) {
				FormMapping formMapping = FormUtils.getInstance().findFormDefinition(NewFundingRequestAction.DEAL_REQUEST_FORM,getServlet().getServletContext(),mapping.getModuleConfig());
				FormUtils.getInstance().populateBeanFromForm(formMapping,dealRequest, dealRequestForm, this, mapping, request);
				prepareMsgHeader(dealRequest, INSERTDEAL, NewFundingRequestAction.RESUBMIT,23);
				attachmentManager.updateMetadataForAllAttachments(dealRequest);
				dealRequest = serviceClient.invokeService(DEAL, dealRequest,DealRequest.class);
				request.getSession().removeAttribute(REMOVECURRENT);
				request.setAttribute(UPDATEMESSAGE,NewFundingRequestAction.REQUEST_ID_IS+dealRequest.getUniqueId()+" has been Re Submitted successfully");
				forward = mapping.findForward(NewFundingRequestAction.HOME);
			}else{
				forward = mapping.getInputForward();
			}
		} else {
			forward = mapping.getInputForward();
		}
		return forward;
	}

	/**
	 * Method is used to save the deal 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HWFServiceException
	 * @throws HWFStubException 
	 * @throws ICFPException 
	 */
	public ActionForward createRequest(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws HWFServiceException, HWFStubException, ICFPException {

		DynaActionForm dealRequestForm = (DynaActionForm) form;
		DealRequest dealRequest = CurrentDealManager.getCurrentDeal(request);
		FormMapping formMapping = FormUtils.getInstance().findFormDefinition(NewFundingRequestAction.DEAL_REQUEST_FORM,getServlet().getServletContext(),mapping.getModuleConfig());
		FormUtils.getInstance().populateBeanFromForm(formMapping,dealRequest, dealRequestForm, this, mapping, request);
		int size = DealManager.getTotalNumberofLegs(request);
		
		if(size==0) { 
			request.setAttribute(LEGEXIST, NO_CAP);
		} else {
			request.setAttribute(LEGEXIST, YES_CAP);
		}
		
		validate(dealRequest, dealRequestForm, request, false);
		
		CurrentDealManager.syncCommentsWithFormObject(request);
		
		if(getErrors(request).isEmpty()) {
			ActionErrors errors = AttachmentValidator.getInstance().validateDeal(request);
			if(!errors.isEmpty()) {
				saveErrors(request, errors);
				request.setAttribute(ICFPConstants.AMTERROR,"Please fix the following fields highlighted in red.");
			}
			if(getErrors(request).isEmpty()) {
				prepareMsgHeader(dealRequest, INSERTDEAL, NewFundingRequestAction.SUBMIT,2);
				
				String cloneFlag = request.getParameter(NewFundingRequestAction.CLONE_FLAG);
				
				if(cloneFlag!=null && cloneFlag.equals(TRUE_SMALL))
				{
					setCloneLegOpCode(dealRequest);	
				}
				
				if(size >0){
					attachmentManager.updateMetadataForAllAttachments(dealRequest);
					dealRequest = serviceClient.invokeService(DEAL, dealRequest,DealRequest.class);
					request.getSession().removeAttribute(REMOVECURRENT);
					request.setAttribute(UPDATEMESSAGE,"New Financing Request created successfully with Request ID # "
									+ dealRequest.getUniqueId());
				}else{
					throw new ICFPException("HWF.FUNDINGREQUEST.1001");
				}
			}
		} 
		request.getSession().removeAttribute(VAULTREQUESTID);
		ActionForward forward = (getErrors(request).isEmpty()) ? mapping.findForward(NewFundingRequestAction.HOME) : mapping.getInputForward();
		return forward;
	}

	
	
    /**
	 * This method is used to cancel the new deal
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return success
	 * @throws Exception if any thing happens
	 */
	public ActionForward cancel(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward(FORWARD_HOMEPAGE);
	}

	
	/**
	 * method used to add a let to the current deal
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward addLeg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionForward forward = null;
		DynaActionForm dealRequestForm = (DynaActionForm) form;
		Integer productId = Integer.valueOf(dealRequestForm.getString(LEGTYPEID));
		String strEventTypeId = dealRequestForm.getString(EVENTTYPEID);
		Integer eventId = null;
		if(StringUtils.isNotBlank(strEventTypeId)) {
			eventId = Integer.valueOf(strEventTypeId);
		}
		// Check allowed leg combination rules
		ActionErrors errors = RuleExecutor.INSTANCE.checkAddLeg(CurrentDealManager.getCurrentDeal(request), productId, eventId, request);
		if(errors != null && !errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.getInputForward();
		} else {
			prepareLegForAddition(mapping, form, request);
			forward = mapping.findForward(ADDLEG);
		}
		return forward;
	}
	
	/**
	 * method used to add the CPA leg to current deal
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward addCPALeg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		prepareLegForAddition(mapping, form, request);
		return mapping.findForward(ADDCPAREQUEST);
	}
	
	/**
	 * Helper Method  for Adding the Leg 
	 * @param mapping
	 * @param form
	 * @param request
	 */
	private void prepareLegForAddition(ActionMapping mapping, ActionForm form,
			HttpServletRequest request) {
		DealRequest currentDeal = CurrentDealManager.getCurrentDeal(request);
		DynaActionForm dealRequestForm = (DynaActionForm)form;
		String legTypeId = dealRequestForm.getString(LEGTYPEID);
		String eventTypeId = dealRequestForm.getString(EVENTTYPEID);
		request.setAttribute(LEGTYPE,legTypeId);
		request.setAttribute(EVENTTYPE, eventTypeId);
		if(!"".equals(eventTypeId) &&  eventTypeId!=null){
			@SuppressWarnings({ "unchecked", "rawtypes" })
			HashMap<String,String> eventMap = (HashMap) dealRequestForm.get(EVENTTYPES);
			request.setAttribute(EVENTTYPENAME, eventMap.get(eventTypeId));
		}
		FormMapping formMapping = FormUtils.getInstance().findFormDefinition(NewFundingRequestAction.DEAL_REQUEST_FORM, getServlet().getServletContext(), mapping.getModuleConfig());
		FormUtils.getInstance().populateBeanFromForm(formMapping, currentDeal, form, this, mapping, request);
		CurrentDealManager.syncCommentsWithFormObject(request);
	}

	
	/**
	 * method is used to delete the leg from the Current deal
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward deleteLeg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setAttribute(LEGEXIST, YES_CAP);
		DealRequest currentDeal = CurrentDealManager.getCurrentDeal(request);
		DynaActionForm dealRequestForm = (DynaActionForm)form;
		String legTypeId = dealRequestForm.getString(LEGTYPEID);
		request.setAttribute(LEGTYPE,legTypeId);
		FormMapping formMapping = FormUtils.getInstance().findFormDefinition(NewFundingRequestAction.DEAL_REQUEST_FORM, getServlet().getServletContext(), mapping.getModuleConfig());
		FormUtils.getInstance().populateBeanFromForm(formMapping, currentDeal, form, this, mapping, request);
		return mapping.findForward(DELETELEG);
	}
	
	
	
	/**
	 * method is used to modify the existing leg in the current deal
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward modifyLeg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DealRequest currentDeal = CurrentDealManager.getCurrentDeal(request);
		DynaActionForm dealRequestForm = (DynaActionForm)form;
		String legTypeId = dealRequestForm.getString(LEGTYPEID);
		request.setAttribute(LEGTYPE,legTypeId);
		FormMapping formMapping = FormUtils.getInstance().findFormDefinition(NewFundingRequestAction.DEAL_REQUEST_FORM, getServlet().getServletContext(), mapping.getModuleConfig());
		FormUtils.getInstance().populateBeanFromForm(formMapping, currentDeal, form, this, mapping, request);
		request.setAttribute(MODIFY, true);
		String legNumber = (String) request.getParameter(LEGNUMBER);
		if(legNumber!=null && !legNumber.equals("")){
			request.setAttribute(LEGNUMBER, new Integer(legNumber));	
		}
		
		return mapping.findForward("modifyLeg");
	}
	
	/**
	 * 
	 * @return
	 */
	public ServiceClient getServiceClient() {
		return serviceClient;
	}

	/**
	 * p
	 * @param serviceClient
	 */
	public void setServiceClient(ServiceClient serviceClient) {
		this.serviceClient = serviceClient;
	}
	
	
	
	/**
	 * While leg is cloned the legopcode must be INSERT 
	 * This method will set the legopcode as INSERT
	 * @param dealRequest
	 */
	public void setCloneLegOpCode(DealRequest dealRequest)
	{
		Legs allLegs = dealRequest.getLegs();
		List<Object> legList = null;
		Integer legSeqID = null;
		
		if(allLegs!=null)
		{
		   legList = 	allLegs.getAllLegs();
		}
		
		if(legList!=null && legList.size()>0)
		{
			for(Object legObject:legList)
			{
				legSeqID = ICFPLegHelper.getLegSeqId(legObject);
				// legseqid value will be null when leg is not edited and deal is directly submitted
				if(legSeqID==null) 
				{
					String opcode= INSERT;
					if(legObject instanceof RCALegRequest) {
						RCALegRequest rcaLeg = (RCALegRequest) legObject;
						rcaLeg.getLegSummary().setLegOpcode(opcode);
					} else if(legObject instanceof EquityLegRequest) {
						EquityLegRequest equityLeg = (EquityLegRequest) legObject;
						equityLeg.getLegSummary().setLegOpcode(opcode);
					} else if(legObject instanceof OtherLegRequest) {
						OtherLegRequest otherLeg = (OtherLegRequest) legObject;
						otherLeg.getLegSummary().setLegOpcode(opcode);
					} else if(legObject instanceof CPALegRequest) {
						CPALegRequest cpaLeg = (CPALegRequest) legObject;
						cpaLeg.getCPASummary().setCPALegOpcode(opcode);
					}
				}
				legSeqID = null;
				
			}
		}
	}
	
	
	/**
	 * Method is used to prepare the message header 
	 * @param dealRequest
	 */
	private void prepareMsgHeader(DealRequest dealRequest, String opcode, String action, int actionId) {
		MsgHeader msgHeader = new MsgHeader();
		msgHeader.setOpcode(opcode);
		String userId = UserContext.getCurrentUserContext().getId();
		msgHeader.setAuditCreator(userId);
		msgHeader.setAuditModifier(userId);
		msgHeader.setAuditCreatorFirstName(UserContext.getCurrentUserContext().getFirstName());
		msgHeader.setAuditCreatorLastName(UserContext.getCurrentUserContext().getLastName());
		if(actionId!=0){
		  dealRequest.setActionId(actionId);
		}
		
		dealRequest.setMsgHeader(msgHeader);
		
		if(action!=null && action.trim().length()>0){
		 dealRequest.setAction(action);
		}
		dealRequest.setTransOwnerSsoId(userId);
	}
	
	/**
	 * prepares display name 
	 */
	private void prepareFirstLastName(DealRequest dealRequest) {
		
		MsgHeader msgHeader = dealRequest.getMsgHeader();
		
		String firstName  = UserContext.getCurrentUserContext().getFirstName();
		String lastName = UserContext.getCurrentUserContext().getLastName();
		msgHeader.setAuditCreatorFirstName(firstName);
		msgHeader.setAuditCreatorLastName(lastName);
		msgHeader.setAuditModifierFirstName(firstName);
		msgHeader.setAuditModifierLastName(lastName);
	}
	
	
	

	/**
	 * getEventDetails
	 * @return
	 * @throws HWFServiceException
	 * @throws HWFStubException
	 */
	public ActionForward getEventDetails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws HWFServiceException, HWFStubException {
		MsgHeader msgHeader = new MsgHeader();
		msgHeader = new MsgHeader();
		msgHeader.setOpcode("GETEVENTDETAILS");
		
		String productTypeId = request.getParameter(PRODUCTTYPE);

		StaticDataManagement staticDataObject = new StaticDataManagement();
		List<TransactionEventTypes> transTypesLst = new ArrayList<TransactionEventTypes>();
		TransactionEventTypes transTypes = new TransactionEventTypes();
		transTypes.setLegTypeID(productTypeId);
		transTypesLst.add(transTypes);
					
		staticDataObject.setTransactionEventTypes(transTypesLst);
		staticDataObject.setMsgHeader(msgHeader);
		staticDataObject = serviceClient.invokeService(STATICDATA, staticDataObject,StaticDataManagement.class);
		
		transTypesLst =  staticDataObject.getTransactionEventTypes();
		
		//Correction event is allowed only for MiddleOffice person
		List<String> roles = SessionManager.getRoles(request);
		boolean isMiddleOfficePerson = false;
		for(String role: roles){
			if( role.contains(NewFundingRequestAction.ICFFO_MIDDLE_OFFICE) ){
				isMiddleOfficePerson = true;
				break;
			}
		}
		
		Map<String,String> eventMap = new HashMap<String, String>();
		String eventID = null;
		for(TransactionEventTypes eventTypes:transTypesLst){
			eventID = eventTypes.getEventTypeID();
			
			if( TEN.equals(eventID) ){
				if(isMiddleOfficePerson){
					eventMap.put(eventTypes.getEventTypeID(),eventTypes.getEventTypeName());
				}					
			}else{
				eventMap.put(eventTypes.getEventTypeID(),eventTypes.getEventTypeName());
			}
				
		}
		
	    ((DynaActionForm)form).set(EVENTTYPES, eventMap);
	    return mapping.findForward(SUCCESS);
	}
	/**
	 * 
	 * @param request
	 * @throws HWFServiceException
	 * @throws HWFStubException
	 */
	protected void roleInfoInvocation(HttpServletRequest request) throws HWFServiceException, HWFStubException {
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
				if(roleInfo.getRoleName().equalsIgnoreCase(ICFFO_MIDDLEOFFICE_MEMBER)){//Front Office
					processComp1.add(processComp);
				}else if(roleInfo.getRoleName().equalsIgnoreCase(ICFFO_FRONTOFFICE_MEMBER)){//Middle Office
					processComp2.add(processComp);
				}else if(roleInfo.getRoleName().equalsIgnoreCase(ICFFO_CASHMANAGEMENT_MEMBER)){//CM
					processComp3.add(processComp);
				}else if(roleInfo.getRoleName().equalsIgnoreCase(ICFFO_TREASURYTAX_MEMBER)){//TT
					processComp4.add(processComp);
				}
			}
			request.getSession().setAttribute(MIDDLEOFFICE, processComp1);
			request.getSession().setAttribute(FRONTOFFICE, processComp2);
			request.getSession().setAttribute(CASHMANAGEMENT, processComp3);
			request.getSession().setAttribute(TRESURYTAG, processComp4);
		}
	}

}



