/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: SearchAction.java
 * Purpose:SearchAction used for the search
 */

package com.ge.icfp.common.action;

import static com.ge.icfp.common.constants.ICFPConstants.ACTIONID;
import static com.ge.icfp.common.constants.ICFPConstants.APPLICATION_VND_MS_EXCEL;
import static com.ge.icfp.common.constants.ICFPConstants.BORROWER;
import static com.ge.icfp.common.constants.ICFPConstants.BUSINESSSEGMENT;
import static com.ge.icfp.common.constants.ICFPConstants.CASHPOOLLEADER;
import static com.ge.icfp.common.constants.ICFPConstants.CASHPOOLPARTICIPANT;
import static com.ge.icfp.common.constants.ICFPConstants.CONTENTDISPOSITION;
import static com.ge.icfp.common.constants.ICFPConstants.DAY2LEG;
import static com.ge.icfp.common.constants.ICFPConstants.DEALCATEGORY;
import static com.ge.icfp.common.constants.ICFPConstants.DEALREQUESTID;
import static com.ge.icfp.common.constants.ICFPConstants.EVENTTYPE;
import static com.ge.icfp.common.constants.ICFPConstants.HWF_INBOX_1001;
import static com.ge.icfp.common.constants.ICFPConstants.ID;
import static com.ge.icfp.common.constants.ICFPConstants.ISCPA;
import static com.ge.icfp.common.constants.ICFPConstants.LAST_NAMEFIRST_NAME;
import static com.ge.icfp.common.constants.ICFPConstants.LEGNUMBER;
import static com.ge.icfp.common.constants.ICFPConstants.LENDER;
import static com.ge.icfp.common.constants.ICFPConstants.MYTASKS;
import static com.ge.icfp.common.constants.ICFPConstants.ONLYPIPELINE;
import static com.ge.icfp.common.constants.ICFPConstants.PLERIVEW;
import static com.ge.icfp.common.constants.ICFPConstants.PRODUCTTYPE;
import static com.ge.icfp.common.constants.ICFPConstants.REGION;
import static com.ge.icfp.common.constants.ICFPConstants.SEARCH;
import static com.ge.icfp.common.constants.ICFPConstants.SEARCHCRITERIA;
import static com.ge.icfp.common.constants.ICFPConstants.SEARCHTEXT;
import static com.ge.icfp.common.constants.ICFPConstants.SEARCHUSER;
import static com.ge.icfp.common.constants.ICFPConstants.SEARCHUSERINFO;
import static com.ge.icfp.common.constants.ICFPConstants.SOURCE;
import static com.ge.icfp.common.constants.ICFPConstants.USERMGMT;
import static com.ge.icfp.common.constants.ICFPConstants.USER_SSO;
import static com.ge.icfp.common.constants.ICFPConstants.VIEWINPUTSCREENS;

import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.write.WriteException;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import com.ge.icfp.action.ICFPBaseAction;
import com.ge.icfp.action.ICFPException;
import com.ge.icfp.common.constants.ICFPConstants;
import com.ge.icfp.common.helper.CurrentDealManager;
import com.ge.icfp.common.helper.ICFPCommonHelper;
import com.ge.icfp.common.helper.ICFPDay2LegHelper;
import com.ge.icfp.common.helper.ICFPLegHelper;
import com.ge.icfp.model.BusinessApprovers;
import com.ge.icfp.model.DealRequest;
import com.ge.icfp.model.DealRequests;
import com.ge.icfp.model.InboxReply;
import com.ge.icfp.model.MsgHeader;
import com.ge.icfp.model.MyAssignData;
import com.ge.icfp.model.MyTaskData;
import com.ge.icfp.model.RoleInfo;
import com.ge.icfp.model.Search;
import com.ge.icfp.model.UserInformation;
import com.ge.icfp.model.WorkItem;
import com.ge.icfp.pipeline.form.PipelineDetails;
import com.ge.icfp.util.PipelineUtils;
import com.ge.icfp.util.SearchUtils;
import com.ge.icfp.util.UserRole;
import com.ge.icfp.util.WriteToExcel;
import com.hydus.wff.common.bw.ServiceClient;
import com.hydus.wff.core.context.UserContext;
import com.hydus.wff.core.exception.HWFServiceException;
import com.hydus.wff.core.exception.HWFStubException;
import com.hydus.wff.core.session.SessionManager;
import com.hydus.wff.core.session.SessionVO;

import formdef.plugin.util.FormUtils;
/**
 * @author kavitha.ramdeni
 *
 */
public class SearchAction extends ICFPBaseAction {
	private static final String HELP = "help";
	private static final String CONTACT_US = "contactUs";
	private static final String SEARCH_FORM = "searchForm";
	private static final String ERROR_WHILE_CLOSING_OUTPUT_STREAM = "Error while closing output stream";
	private static final String SEARCH_RESULT_XLS = "SearchResult.xls";
	private static final String SEARCH_DETAILS = "searchDetails";
	private static final String I_READ_ONLY = "(?i:.*ReadOnly.*)";
	private static final String ICFFO_ADMIN = "ICFFO-Admin";
	private static final String SEARCH_RESULTS = "searchResults";
	private static final String SHOW_SEARCH_RESULT = "showSearchResult";
	private static final String SEARCHED_LIST = "searchedList";
	private static final String SEARCH_RESULT_LIST = "searchResultList";
	private static final String RESULT_VALUES = "resultValues";
	private static final String SEARCH_VALUES = "searchValues";
	private static final String CASH_POOL_DETAILS_CURRENCY = "cashPoolDetailsCurrency";
	private static final String CASH_POOL_DETAILS_REGION = "cashPoolDetailsRegion";
	private static final String CASH_POOL_DETAILS_COUNTRY = "cashPoolDetailsCountry";
	private static final String CASH_POOL_DETAILS_BANK_NAME = "cashPoolDetailsBankName";
	private static final String REQUEST_STATE = "requestState";
	private static final String DEALID = "DEALID";
	private static final String HOMEPAGE = "homePage";
	private static final String ERROR_MSG = "atmtError";
	private static final String PERMISION_ERROR = "No permision to view this deal";
	private static final String HWF_ROUTER_1001 = "HWF.ROUTER.1001";
	private static final String GETINBOXFORDEAL = "GETINBOXFORDEAL";
	private static final String WORK_ITEM = "workItem";
	private static final String TASK_ASSIGNER = "taskAssigner";
	private static final String SEARCHROUTE = "searchroute";
	private static final String EXPDEAL = "EXPAPPLI";
	public static final Logger LOGGER = Logger.getLogger(SearchAction.class);
	/**
	 * serviceClient
	 */
	private ServiceClient serviceClient;
	
	
	/**
	 * searchResults is used to display the searched results
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return success forward to the appropriate page.
	 * @throws ParseException 
	 * @throws Exception
	 */
	public ActionForward searchResults(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HWFServiceException, HWFStubException, ParseException {
		DealRequests dealCollection = new DealRequests();
		String[] productType = request.getParameterValues(PRODUCTTYPE);
		((DynaActionForm) form).set("productType",productType);
		String[] eventType = request.getParameterValues(EVENTTYPE);
		((DynaActionForm) form).set(EVENTTYPE,eventType);
		String[] requestState = request.getParameterValues(REQUEST_STATE);
		((DynaActionForm) form).set(REQUEST_STATE,requestState);
		String[] region= request.getParameterValues(REGION);
		((DynaActionForm) form).set(REGION,region);
		String[] businessSegment= request.getParameterValues(BUSINESSSEGMENT);
		((DynaActionForm) form).set(BUSINESSSEGMENT,businessSegment);
		Integer[] dealCategory = null;
		String[] dealCategoryPar = request.getParameterValues(DEALCATEGORY);
		if(dealCategoryPar!=null && dealCategoryPar.length>0)
		{
			dealCategory = new Integer[dealCategoryPar.length];
			for(int i=0;i<dealCategoryPar.length;i++){
				dealCategory[i]= Integer.valueOf(dealCategoryPar[i]);
			}
		}else if (dealCategoryPar ==null)
		{
			((DynaActionForm) form).set(DEALCATEGORY,null);
		}
		String dealDerivativeType = request.getParameter("dealWithDerivatives");
		if(dealDerivativeType==null){
			((DynaActionForm) form).set("dealWithDerivatives",null);
		}else{
			((DynaActionForm) form).set("dealWithDerivatives",dealDerivativeType);
		}
		
		String[] cashPoolDetailsBankName= request.getParameterValues(CASH_POOL_DETAILS_BANK_NAME);
		
		if(cashPoolDetailsBankName==null){
			((DynaActionForm) form).set(CASH_POOL_DETAILS_BANK_NAME,null);
		}else{
			((DynaActionForm) form).set(CASH_POOL_DETAILS_BANK_NAME,cashPoolDetailsBankName);
		}
		
		String[] cashPoolDetailsCountry= request.getParameterValues(CASH_POOL_DETAILS_COUNTRY); 
		
		if(cashPoolDetailsCountry==null){
			((DynaActionForm) form).set(CASH_POOL_DETAILS_COUNTRY,null);
		}else{
			((DynaActionForm) form).set(CASH_POOL_DETAILS_COUNTRY,cashPoolDetailsCountry);
		}
		
		
		String[] cashPoolDetailsRegion= request.getParameterValues(CASH_POOL_DETAILS_REGION); 
		if(cashPoolDetailsRegion==null){
			((DynaActionForm) form).set(CASH_POOL_DETAILS_REGION,null);
		}else{
			((DynaActionForm) form).set(CASH_POOL_DETAILS_REGION,cashPoolDetailsRegion);
		}
		
		
		String[] cashPoolDetailsCurrency= request.getParameterValues(CASH_POOL_DETAILS_CURRENCY); 
		
		if(cashPoolDetailsCurrency==null){
			((DynaActionForm) form).set(CASH_POOL_DETAILS_CURRENCY,null);
		}else{
			((DynaActionForm) form).set(CASH_POOL_DETAILS_CURRENCY,cashPoolDetailsCurrency);
		}
		
		
		DynaActionForm lenderForm = (DynaActionForm) ((DynaActionForm) form).get(LENDER);
		
		String lenderFundHoldOperationId[] = (String[])request.getParameterValues("lender.fundHoldOperationId");
		
		if(lenderFundHoldOperationId==null)
		{
			lenderForm.set(ICFPConstants.FUND_HOLD_OPERATION_ID,null);
		}else{
			lenderForm.set(ICFPConstants.FUND_HOLD_OPERATION_ID, lenderFundHoldOperationId);
		}
		
        String lenderCountry[] = (String[])request.getParameterValues("lender.country");
		
		if(lenderCountry==null)
		{
			lenderForm.set(ICFPConstants.COUNTRY,null);
		}else{
			lenderForm.set(ICFPConstants.COUNTRY, lenderCountry);
		}
		
		((DynaActionForm) form).set(LENDER,lenderForm);
		DynaActionForm borrowerForm = (DynaActionForm) ((DynaActionForm) form).get(BORROWER);
		
		
		String borrowerFundHoldOperationId[] = (String[])request.getParameterValues("borrower.fundHoldOperationId");
		
		if(borrowerFundHoldOperationId==null)
		{
			borrowerForm.set(ICFPConstants.FUND_HOLD_OPERATION_ID,null);
		}else{
			borrowerForm.set(ICFPConstants.FUND_HOLD_OPERATION_ID, borrowerFundHoldOperationId);
		}
		
		String borrowerCountry[] = (String[])request.getParameterValues("borrower.country");
		
		if(borrowerCountry==null)
		{
			borrowerForm.set(ICFPConstants.COUNTRY,null);
		}else{
			borrowerForm.set(ICFPConstants.COUNTRY, borrowerCountry);
		}
		
		((DynaActionForm) form).set(BORROWER,borrowerForm);
		DynaActionForm cashPoolParticipantForm = (DynaActionForm) ((DynaActionForm) form).get(CASHPOOLPARTICIPANT);
		
		String cashPoolParticipantFundHoldOperationId[] = (String[])request.getParameterValues("cashPoolParticipant.fundHoldOperationId");
		
		if(cashPoolParticipantFundHoldOperationId==null)
		{
			cashPoolParticipantForm.set(ICFPConstants.FUND_HOLD_OPERATION_ID,null);
		}else{
			cashPoolParticipantForm.set(ICFPConstants.FUND_HOLD_OPERATION_ID, cashPoolParticipantFundHoldOperationId);
		}
		
		String cashPoolParticipantCountry[] = (String[])request.getParameterValues("cashPoolParticipant.country");
		
		if(cashPoolParticipantCountry==null)
		{
			cashPoolParticipantForm.set(ICFPConstants.COUNTRY,null);
		}else{
			cashPoolParticipantForm.set(ICFPConstants.COUNTRY, cashPoolParticipantCountry);
		}
		((DynaActionForm) form).set(CASHPOOLPARTICIPANT,cashPoolParticipantForm);
		
		DynaActionForm cashPoolLeaderForm = (DynaActionForm) ((DynaActionForm) form).get(CASHPOOLLEADER);
		
		String cashPoolLeaderFundHoldOperationId[] = (String[])request.getParameterValues("cashPoolLeader.fundHoldOperationId");
		
		if(cashPoolLeaderFundHoldOperationId==null)
		{
			cashPoolLeaderForm.set(ICFPConstants.FUND_HOLD_OPERATION_ID,null);
		}else{
			cashPoolLeaderForm.set(ICFPConstants.FUND_HOLD_OPERATION_ID, cashPoolLeaderFundHoldOperationId);
		}
		
		String cashPoolLeaderCountry[] = (String[])request.getParameterValues("cashPoolLeader.country");
		
		if(cashPoolLeaderCountry==null)
		{
			cashPoolLeaderForm.set(ICFPConstants.COUNTRY,null);
		}else{
			cashPoolLeaderForm.set(ICFPConstants.COUNTRY, cashPoolLeaderCountry);
		}
		
		((DynaActionForm) form).set(CASHPOOLLEADER,cashPoolLeaderForm);
		Search search = (Search) FormUtils.getFormValues(form, this, mapping, request);
		String[] businessSegments = ICFPCommonHelper.getUserBusinessSegment(request, businessSegment);
		String[] ownerBusinessSegment = ICFPCommonHelper.getOwnerBusinessSegment(request, businessSegment);
		getRequestor(request, search);
		Map<String, String> result = new HashMap<String, String>();
		
		SearchUtils.syncSearchCriteria(productType, eventType, requestState, region,
				businessSegments, ownerBusinessSegment, dealCategory, cashPoolDetailsBankName, cashPoolDetailsCountry, cashPoolDetailsRegion,
				cashPoolDetailsCurrency, lenderForm, borrowerForm, cashPoolParticipantForm, cashPoolLeaderForm, search, result, request);
		search.setLoginSso(SessionManager.getSessionUser(request).getUserId());
		request.getSession().setAttribute(SEARCH_VALUES, search);
		request.getSession().setAttribute(RESULT_VALUES, result);
		dealCollection = serviceClient.invokeService(SEARCH, search, DealRequests.class);
		List<PipelineDetails> searchDetails = PipelineUtils.populateSearchDetails(dealCollection, request);
	
		List<String> onlyPipelineDetails = new ArrayList<String>();
		List<DealRequest> allDealReq=dealCollection.getDealRequests();
		for (DealRequest eachDeal : allDealReq) {
			if(eachDeal.getWFStage()!=null && eachDeal.getWFStage().equals(PLERIVEW)){
				onlyPipelineDetails.add(String.valueOf(eachDeal.getDealSeqId()));
			}
		}
		request.getSession().setAttribute(ONLYPIPELINE, onlyPipelineDetails );
		request.getSession().setAttribute(SEARCH_RESULT_LIST, searchDetails);
		request.getSession().setAttribute(SEARCHED_LIST, result);
		request.setAttribute(SHOW_SEARCH_RESULT, true);
		return mapping.findForward(SEARCH_RESULTS);

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
	 * @throws ParseException
	 */
	public ActionForward searchEmailResults(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HWFServiceException, HWFStubException, ParseException {
		DealRequests dealCollection = new DealRequests();
		Search search = new Search();
		Set<String> allowedBUs = new HashSet<String>();
		ICFPCommonHelper.getReadOnlyRoles(request, allowedBUs);
		String currentUserId = UserContext.getCurrentUserContext().getId();
		String businessRequestID = (String)request.getAttribute(DEALID);
		
		List<String> businessSegments = new ArrayList<String>(allowedBUs);
		search.setOwnerBusinessSegments(businessSegments);
		search.setBusinessSegments(businessSegments);
		search.setDealId(businessRequestID);
		getRequestor(request, search);
		search.setLoginSso(currentUserId);
		dealCollection = serviceClient.invokeService(SEARCH, search, DealRequests.class);
		if(!dealCollection.getDealRequests().isEmpty() && dealCollection.getDealRequests().size()>0){
			DealRequest deal = dealCollection.getDealRequests().get(0);
			request.setAttribute(DEALREQUESTID,deal.getDealSeqId().toString());
			return getSearchDealDetail(mapping, form, request, response);
		}
		request.setAttribute(ERROR_MSG, PERMISION_ERROR);
		return mapping.findForward(HOMEPAGE);
	}
	/**
	 * 
	 * @param request
	 * @return
	 */
	private void getRequestor(HttpServletRequest request, Search search) {
		List<String> roles = SessionManager.getRoles(request);
		SessionVO sessionVO = SessionManager.getSessionUser(request);
		boolean isRequestorOnly = false;
		boolean isNotReadOnly = false;
		if(!roles.contains(ICFFO_ADMIN)){
			for (String roleName : roles) {
				if( roleName.matches( I_READ_ONLY ) ){
					isNotReadOnly = true;
				}
			}
			if(!isNotReadOnly){
				for (String string : roles) {
					if(string.contains(UserRole.Requestor.getName())){
						isRequestorOnly = true;
					}
				}
			}
		}
		if(isRequestorOnly){
			search.setSsoId(sessionVO.getUserId());
			search.setFirstName(sessionVO.getFirstName());
			search.setLastName(sessionVO.getLastName());
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
	 * @throws ParseException
	 */
	public ActionForward returnToSearchResults(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HWFServiceException, HWFStubException, ParseException {
		DealRequests dealCollection = new DealRequests();
		Search search = (Search) request.getSession().getAttribute(SEARCH_VALUES);
		@SuppressWarnings("unchecked")
		Map<String, String> result = (Map<String, String>) request.getSession().getAttribute(RESULT_VALUES);
		if(search!=null){
			dealCollection = serviceClient.invokeService(SEARCH, search, DealRequests.class);
			List<PipelineDetails> searchDetails = PipelineUtils.populateSearchDetails(dealCollection, request);
			request.getSession().setAttribute(SEARCH_RESULT_LIST, searchDetails);
			request.getSession().setAttribute(SEARCHED_LIST, result);
			request.setAttribute(SHOW_SEARCH_RESULT, true);
			return mapping.findForward(SEARCH_RESULTS);
		}else{
			return mapping.findForward(HOMEPAGE);
		}
		
	}
	/**
	 * Open the deal details page for the requested deal
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HWFServiceException
	 * @throws HWFStubException
	 * @throws ParseException
	 */
	public ActionForward getSearchDealDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HWFServiceException, HWFStubException, ParseException {
		ActionForward forward = null;
		String requestID = request.getParameter(DEALREQUESTID);
		if(requestID==null || requestID.equals(""))
		{
			requestID = (String)request.getAttribute(DEALREQUESTID);
		}
		DealRequest deal = ICFPCommonHelper.getDeal(Integer.valueOf(requestID), serviceClient);
		CurrentDealManager.setActiveDeal(deal, request);
		Boolean isCPADeal = CurrentDealManager.isCPADeal(request);
		Boolean isEquityDeal = CurrentDealManager.isEquityDeal(request);
		forward = mapping.findForward(SEARCH_DETAILS);
		request.getSession().setAttribute("currentAdditionalApprovers", null); 
		request.getSession().setAttribute("businessApproversList",null);
		if (deal != null) {
			if( deal.getAdditionalApprovers() != null && deal.getAdditionalApprovers().getUserInfos() != null  && deal.getAdditionalApprovers().getUserInfos().size() > 0 ){
				request.getSession().setAttribute("currentAdditionalApprovers", deal.getAdditionalApprovers()); 
			}
			if( deal.getBusinessApprovers()!= null && deal.getBusinessApprovers().size() > 0 ){
				request.getSession().setAttribute("businessApproversList", deal.getBusinessApprovers());  
			}
		}
		request.setAttribute(ISCPA,isCPADeal);
		request.setAttribute("isEquity",isEquityDeal);
		return forward;
	}
	
	/**
	 * Build the URL based on the workflow stage
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws ICFPException 
	 * @throws HWFStubException 
	 * @throws HWFServiceException 
	 * @throws ParseException 
	 */
	public ActionForward getSearchActionDealDetail(ActionMapping mapping, ActionForm form,
		        HttpServletRequest request, HttpServletResponse response) throws ICFPException, HWFServiceException, HWFStubException, ParseException {
		 
		 String id = request.getParameter(DEALID);
		 String dealID = request.getParameter(DEALREQUESTID);
		 String userid = SessionManager.getUserID(request);
		 
		 boolean isIDEmpty = StringUtils.isEmpty(id);	
		 boolean isUserEmpty = StringUtils.isEmpty(userid);
		 
		 if( isIDEmpty || isUserEmpty ){
			 throw new ICFPException(HWF_ROUTER_1001);
		 }		 
		 List<String> roles = SessionManager.getRoles(request);
		 String roleName = getRoles(roles);
			
		 MsgHeader header = new MsgHeader();
		 header.setOpcode(MYTASKS);
		 header.setAuditCreator( userid );
		 header.setRoleName(roleName);
		 
		 DealRequest dealRequest = new DealRequest();
		 dealRequest.setUniqueId(id);
		 dealRequest.setMsgHeader( header );
		 
		 InboxReply reply = serviceClient.invokeService(GETINBOXFORDEAL, dealRequest, InboxReply.class);
		 
		 MyAssignData unassign = reply.getMyAssignData();
		 MyTaskData mytask = reply.getMyTaskData();
		 
		 boolean isAvailable = false;
		 
		 for(WorkItem item : unassign.getWorkItems()){
			 
			 if( id.equals( item.getBusinessRequestID()) ){
				if (EXPDEAL.equals(item.getCurrentStage())) {
					isAvailable = false;
				} else {
					isAvailable = true;
					request.setAttribute(TASK_ASSIGNER, true);
					request.setAttribute(WORK_ITEM, item);
				}
				break;
			 }
		 }
		 
		 if( !isAvailable ){
			 
			for( WorkItem item: mytask.getWorkItems() ){
				
				if( id.equals( item.getBusinessRequestID() )){
					if(EXPDEAL.equals(item.getCurrentStage())){
						isAvailable = false;
					} else {
						isAvailable = true;
						request.setAttribute(WORK_ITEM, item);
						request.setAttribute(TASK_ASSIGNER, false);
					}
					break;
				}
			}
		 }
		 
		 
		 
		 if( isAvailable  ){
			 return mapping.findForward(SEARCHROUTE);
		 }else{
			 request.setAttribute(DEALID, id);
			 request.setAttribute(DEALREQUESTID,dealID);
			 return getSearchDealDetail(mapping, form, request, response);
		 }
	 }

	/**
	 * Return role name as comma seperated string
	 * @param roles
	 * @param roleName
	 * @return
	 * @throws ICFPException 
	 */
	private String getRoles(List<String> roles ) throws ICFPException {
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
	 * exportToExcel is used to export Pipeline Data to Excel Sheet
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return open a Excel File
	 * @throws IOException 
	 * @throws WriteException 
	 * @throws ParseException 
	 * @throws ICFPException 
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public ActionForward exportToExcel(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HWFServiceException, HWFStubException, WriteException, IOException, ParseException, ICFPException {

		String filename = SEARCH_RESULT_XLS;
		response.setContentType(APPLICATION_VND_MS_EXCEL);
	    response.setHeader(CONTENTDISPOSITION, "attachment; filename=\"" + filename + "\"");
	   
	    WriteToExcel writeToExcel = new WriteToExcel();
	    OutputStream outStream = null;
	    try {
	    	 outStream = response.getOutputStream();
	    	 writeToExcel.searchWrite(response.getOutputStream(), 
	 	    		(List<PipelineDetails>) request.getSession().getAttribute(SEARCH_RESULT_LIST));
	    } finally {
	    	try {
				if(outStream != null) {
					outStream.close();
				}
			} catch (IOException e) {
				LOGGER.warn(ERROR_WHILE_CLOSING_OUTPUT_STREAM, e);
				throw new ICFPException("",ERROR_WHILE_CLOSING_OUTPUT_STREAM, e);
			}
	    }
	   
	    
		return null;
		
	}
	/**
	 * searchResults is used to display the searched results
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return success forward to the appropriate page.
	 * @throws ParseException 
	 * @throws Exception
	 */
	public ActionForward searchForm(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HWFServiceException, HWFStubException, ParseException {
		
		DynaActionForm localForm = (DynaActionForm)form;
		localForm.getMap().clear();
		ICFPLegHelper.prepareSearchForm((DynaActionForm) form, mapping, request, this);
		request.setAttribute(SHOW_SEARCH_RESULT, false);
		return mapping.findForward(SEARCH_FORM);

	}
	
	/**
	 * Open Contact Us page
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HWFServiceException
	 * @throws HWFStubException
	 * @throws ParseException
	 */
	
	public ActionForward contactUs(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HWFServiceException, HWFStubException, ParseException {
		
		
		return mapping.findForward(CONTACT_US);

	}
	/**
	 * Open Help Page
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HWFServiceException
	 * @throws HWFStubException
	 * @throws ParseException
	 */
	public ActionForward help(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HWFServiceException, HWFStubException, ParseException {
		
		
		return mapping.findForward(HELP);

	}
	/**
	 * Invoke the service to search requested user 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HWFServiceException
	 * @throws HWFStubException
	 * @throws ParseException
	 */
	public ActionForward searchUserInfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HWFServiceException, HWFStubException, ParseException {
		
		String searchCriteria = request.getParameter(SEARCHCRITERIA);
		String searchText = request.getParameter(SEARCHTEXT);
		List<BusinessApprovers> userInfoSearchResultsList = new ArrayList<BusinessApprovers>();
		MsgHeader msgHeader = new MsgHeader();
		msgHeader.setOpcode(SEARCHUSER);
		if(UserContext.getCurrentUserContext() != null){
			String loggedInUserId = UserContext.getCurrentUserContext().getId();
			msgHeader.setAuditModifier(loggedInUserId);
		}

		UserInformation userInformation = new UserInformation();
		userInformation.setMsgHeader(msgHeader);
		List<RoleInfo> roleInfos = new ArrayList<RoleInfo>();
	
		RoleInfo searchRequest = new RoleInfo();
		if(searchCriteria.equalsIgnoreCase(USER_SSO)){
			searchRequest.setSsoId(searchText);
		}else if(searchCriteria.equalsIgnoreCase(LAST_NAMEFIRST_NAME)){
			String[] searchOn = searchText.split(",");
			if(searchOn.length==1){
				searchRequest.setFirstName(searchOn[0]);
				searchRequest.setLastName(searchOn[0]);
			}
			else{
				searchRequest.setFirstName(searchOn[1].trim());
				searchRequest.setLastName(searchOn[0].trim());
			}
		}else{
			searchRequest.setFirstName(searchText);
			searchRequest.setLastName(searchText);
		}
		
		roleInfos.add(searchRequest);
		
		userInformation.setRoleInfos(roleInfos);
		userInformation = serviceClient.invokeService(USERMGMT,
				userInformation, UserInformation.class);
		if (userInformation != null) {
			List<RoleInfo> roleInfoList = userInformation.getRoleInfos();
			if (searchCriteria.equalsIgnoreCase(USER_SSO)) {
				for (int i = 0; i < roleInfoList.size(); i++) {
					RoleInfo roleInfo = roleInfoList.get(i);
					BusinessApprovers userInfo = new BusinessApprovers();
					userInfo.setSSOID(roleInfo.getSsoId());
					userInfo.setFirstName(roleInfo.getFirstName());
					userInfo.setLastName(roleInfo.getLastName());
					userInfo.setGroup(roleInfo.getBusinessUnit());
					userInfoSearchResultsList.add(userInfo);
				}
			}
			if (!searchCriteria.equalsIgnoreCase(USER_SSO)) {
				for (int i = 0; i < roleInfoList.size(); i++) {
					RoleInfo roleInfo = roleInfoList.get(i);
					BusinessApprovers userInfo = new BusinessApprovers();
					userInfo.setSSOID(roleInfo.getSsoId());
					userInfo.setFirstName(roleInfo.getFirstName());
					userInfo.setLastName(roleInfo.getLastName());
					userInfo.setGroup(roleInfo.getBusinessUnit());
					userInfoSearchResultsList.add(userInfo);
				}
			}
		}
		request.getSession().setAttribute(SEARCHUSERINFO, userInfoSearchResultsList);
		return mapping.findForward(SEARCH_FORM);

	}
	
	/**
	 * Open the Leg screen
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
		request.setAttribute(ACTIONID, 11);
		request.setAttribute(LEGNUMBER, legNumberInt);
		if(ICFPDay2LegHelper.isDay2Leg(leg)){
			forward = mapping.findForward(DAY2LEG);
		}else{
			forward=mapping.findForward(VIEWINPUTSCREENS);
		}
		return forward;
	}

	public ServiceClient getServiceClient() {
		return serviceClient;
	}

	public void setServiceClient(ServiceClient serviceClient) {
		this.serviceClient = serviceClient;
	}
	
	

}
