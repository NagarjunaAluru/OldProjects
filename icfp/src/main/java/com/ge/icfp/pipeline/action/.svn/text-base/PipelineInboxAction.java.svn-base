/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: PipelineInboxAction.java
 * Purpose: PipelineInboxAction used for executing Pipeline Management Inbox Screen and
 * and filter the pipeline date according to criteria.
 */
package com.ge.icfp.pipeline.action;


import static com.ge.icfp.common.constants.ICFPConstants.ACTIONID;
import static com.ge.icfp.common.constants.ICFPConstants.APPLICATION_VND_MS_EXCEL;
import static com.ge.icfp.common.constants.ICFPConstants.BUSINESSSEGMENT;
import static com.ge.icfp.common.constants.ICFPConstants.CONTENTDISPOSITION;
import static com.ge.icfp.common.constants.ICFPConstants.CURRENCY;
import static com.ge.icfp.common.constants.ICFPConstants.DEALCATEGORY;
import static com.ge.icfp.common.constants.ICFPConstants.EVENTTYPE;
import static com.ge.icfp.common.constants.ICFPConstants.HWF_INBOX_1001;
import static com.ge.icfp.common.constants.ICFPConstants.INBOX;
import static com.ge.icfp.common.constants.ICFPConstants.LAST_NAMEFIRST_NAME;
import static com.ge.icfp.common.constants.ICFPConstants.PIPELINEDETAILLIST;
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

import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.write.WriteException;

import org.apache.axis.utils.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ge.icfp.action.ICFPBaseAction;
import com.ge.icfp.action.ICFPException;
import com.ge.icfp.common.helper.ICFPCommonHelper;
import com.ge.icfp.model.BusinessApprovers;
import com.ge.icfp.model.DealRequest;
import com.ge.icfp.model.DealRequests;
import com.ge.icfp.model.MsgHeader;
import com.ge.icfp.model.RoleInfo;
import com.ge.icfp.model.Search;
import com.ge.icfp.model.UserActionData;
import com.ge.icfp.model.UserInformation;
import com.ge.icfp.pipeline.form.PipelineDetails;
import com.ge.icfp.pipeline.form.PipelineInboxForm;
import com.ge.icfp.util.PipelineUtils;
import com.ge.icfp.util.SearchUtils;
import com.ge.icfp.util.WriteToExcel;
import com.hydus.wff.common.bw.ServiceClient;
import com.hydus.wff.core.context.UserContext;
import com.hydus.wff.core.exception.HWFServiceException;
import com.hydus.wff.core.exception.HWFStubException;
import com.hydus.wff.core.session.SessionManager;
/**
 * 
 * @author arijit.biswas
 *
 */
public class PipelineInboxAction extends ICFPBaseAction{
	
	private static final String ERROR_WHILE_CLOSING_OUTPUT_STREAM = "Error while closing output stream";

	private static final String ACTION_DETAIL = "actionDetail";

	private static final String USER_DATA = "userData";

	private static final String STAGE_ID = "stageId";

	private static final String DEAL_ID = "dealId";

	private static final String MOSEARCH = "MOSEARCH";

	private static final String PRIORITY2 = "priority";

	private static final String DEAL_TYPE = "dealType";

	private static final String WORK_FLOW_STATE = "workFlowState";

	private static final String MOPIPELINEREVIEW = "MOPIPELINEREVIEW";

	private static final String VIEWINBOXMO = "viewinboxmo";

	private static final String MO = "MO";

	private static final String FO = "FO";

	private static final String PIPELINE_TYPE = "pipelineType";

	private static final String SIDE_CHART = "sideChart";

	private static final String BELOW_CHART = "belowChart";

	private static final String PIPELINE_DETAIL_LIST_ORIGINAL = "pipelineDetailListOriginal";

	private static final String PIPELINEREVIEW = "PIPELINEREVIEW";

	private static final String VIEWINBOX = "viewinbox";

	private static final String NO_CHART = "noChart";

	private static final String FOSEARCH = "FOSEARCH";

	private static final String HEADER = "header";

	public static final Logger LOGGER = Logger.getLogger(PipelineInboxAction.class);
	
	private ServiceClient serviceClient;
	/**
	 * executeInbox is used to execute IDAG Pipeline Management Inbox Screen
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return success forward to the appropriate page.
	 * @throws ParseException 
	 * @throws ICFPException 
	 * @throws Exception
	 */
	public ActionForward executeInbox(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HWFServiceException, HWFStubException, ParseException, ICFPException {

		DealRequests dealCollection = new DealRequests();
		String source = request.getParameter(SOURCE);
		PipelineInboxForm pipelineForm = (PipelineInboxForm) form;
		if(!PipelineInboxAction.HEADER.equals(source) && !StringUtils.isEmpty(pipelineForm.getSearch().getOpCode()) && PipelineInboxAction.FOSEARCH.equals(pipelineForm.getSearch().getOpCode())){
			Search search = pipelineForm.getSearch();
			dealCollection = serviceClient.invokeService(SEARCH, search, DealRequests.class);
			List<PipelineDetails> searchDetails = PipelineUtils.populatePipelineSearch(dealCollection, request, PipelineInboxAction.FO);
			if (searchDetails != null && !searchDetails.isEmpty()){
				request.getSession().setAttribute(PIPELINEDETAILLIST,searchDetails);
			}
			List<String> searchPipelineDetails = new ArrayList<String>();
			List<DealRequest> allDealReq=dealCollection.getDealRequests();
			for (DealRequest eachDeal : allDealReq) {
				if(eachDeal.getWFStage()!=null && eachDeal.getWFStage().equals("PLERIVEW")){
					searchPipelineDetails.add(String.valueOf(eachDeal.getDealSeqId()));
				}
			}
			request.getSession().setAttribute(ONLYPIPELINE, searchPipelineDetails );
			request.setAttribute(PipelineInboxAction.NO_CHART, true);
			return mapping.findForward(PipelineInboxAction.VIEWINBOX);
		}
		List<String> onlyPipelineDetails = new ArrayList<String>();
		List<String> roles = SessionManager.getRoles(request);
		String roleName = getRoles(roles);
		MsgHeader msgHeader = new MsgHeader();
		msgHeader.setRoleName(roleName);
		msgHeader.setOpcode(PipelineInboxAction.PIPELINEREVIEW);
		dealCollection = serviceClient.invokeService(INBOX, msgHeader,DealRequests.class);
		List<PipelineDetails> pipelineDetails = PipelineUtils.populatePipelineMgmt(dealCollection, request);
		List<DealRequest> allDealReq=dealCollection.getDealRequests();
		for (DealRequest eachDeal : allDealReq) {
			if(eachDeal.getWFStage()!=null && eachDeal.getWFStage().equals(PLERIVEW)){
				onlyPipelineDetails.add(String.valueOf(eachDeal.getDealSeqId()));
			}
		}
		request.getSession().setAttribute(PIPELINEDETAILLIST, pipelineDetails);
		request.getSession().setAttribute(ONLYPIPELINE, onlyPipelineDetails );
		request.getSession().setAttribute(PipelineInboxAction.PIPELINE_DETAIL_LIST_ORIGINAL,	pipelineDetails);
		request.setAttribute(PipelineInboxAction.NO_CHART, true);
		
		return mapping.findForward(PipelineInboxAction.VIEWINBOX);

	}
	
	/**
	 * Add Flag to show no chart
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward showNoChart(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		request.setAttribute(PipelineInboxAction.NO_CHART, true);
		String forward = getPipelineType(request);
		return mapping.findForward(forward);
	}

	/**
	 * Add Flag to show chart below the table
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward showBelowChart(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		request.setAttribute(PipelineInboxAction.BELOW_CHART, true);
		String forward = getPipelineType(request);
		return mapping.findForward(forward);
	}
	/**
	 * Add Flag to show chart side of the table
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward showSideChart(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		request.setAttribute(PipelineInboxAction.SIDE_CHART, true);
		String forward = getPipelineType(request);
		return mapping.findForward(forward);
	}
	
	/**
	 * @param request
	 * @return
	 */
	private String getPipelineType(HttpServletRequest request) {
		String forward = null;
		if(PipelineInboxAction.FO.equals(request.getParameter(PipelineInboxAction.PIPELINE_TYPE))){
			forward = PipelineInboxAction.VIEWINBOX;
		}if(PipelineInboxAction.MO.equals(request.getParameter(PipelineInboxAction.PIPELINE_TYPE))){
			forward = PipelineInboxAction.VIEWINBOXMO;
		}
		return forward;
	}
	/**
	 * executeInbox is used to execute Middle Office Pipeline Management Inbox Screen
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return success forward to the appropriate page.
	 * @throws ParseException 
	 * @throws ICFPException 
	 * @throws Exception
	 */
	public ActionForward executeInboxMO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HWFServiceException, HWFStubException, ParseException, ICFPException {

		DealRequests dealCollection = new DealRequests();
		String source = request.getParameter(SOURCE);
		PipelineInboxForm pipelineForm = (PipelineInboxForm) form;
		if(!PipelineInboxAction.HEADER.equals(source) && !StringUtils.isEmpty(pipelineForm.getSearch().getOpCode()) && PipelineInboxAction.MOSEARCH.equals(pipelineForm.getSearch().getOpCode())){
			Search search = pipelineForm.getSearch();
			dealCollection = serviceClient.invokeService(SEARCH, search, DealRequests.class);
			List<PipelineDetails> searchDetails = PipelineUtils.populatePipelineSearch(dealCollection, request, PipelineInboxAction.MO);
			if (searchDetails != null && !searchDetails.isEmpty()){
				request.getSession().setAttribute(PIPELINEDETAILLIST,searchDetails);
			}
			List<String> searchPipelineDetails = new ArrayList<String>();
			List<DealRequest> allDealReq=dealCollection.getDealRequests();
			for (DealRequest eachDeal : allDealReq) {
				if(eachDeal.getWFStage()!=null && eachDeal.getWFStage().equals("PLERIVEW")){
					searchPipelineDetails.add(String.valueOf(eachDeal.getDealSeqId()));
				}
			}
			request.getSession().setAttribute(ONLYPIPELINE, searchPipelineDetails );
			request.setAttribute(PipelineInboxAction.NO_CHART, true);
			return mapping.findForward(PipelineInboxAction.VIEWINBOXMO);
		}
		List<String> roles = SessionManager.getRoles(request);
		String roleName = getRoles(roles);
		MsgHeader msgHeader = new MsgHeader();
		msgHeader.setRoleName(roleName);
		msgHeader.setOpcode(PipelineInboxAction.MOPIPELINEREVIEW);
		dealCollection = serviceClient.invokeService(INBOX, msgHeader,DealRequests.class);
		List<PipelineDetails> pipelineDetails = PipelineUtils.populatePipelineMgmtMO(dealCollection, request);
		request.getSession().setAttribute(PIPELINEDETAILLIST, pipelineDetails);
		List<String> onlyPipelineDetails = new ArrayList<String>();
		List<DealRequest> allDealReq=dealCollection.getDealRequests();
		for (DealRequest eachDeal : allDealReq) {
			if(eachDeal.getWFStage()!=null && eachDeal.getWFStage().equals(PLERIVEW)){
				onlyPipelineDetails.add(String.valueOf(eachDeal.getDealSeqId()));
			}
		}
		request.getSession().setAttribute(PIPELINEDETAILLIST, pipelineDetails);
		request.getSession().setAttribute(ONLYPIPELINE, onlyPipelineDetails );
		request.getSession().setAttribute(PipelineInboxAction.PIPELINE_DETAIL_LIST_ORIGINAL,	pipelineDetails);
		request.setAttribute(PipelineInboxAction.NO_CHART, true);
		return mapping.findForward(PipelineInboxAction.VIEWINBOXMO);

	}
	
	/**
	 * executeFilter is used pipeline data with respect to filter Option and Value
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return success forward to the appropriate page.
	 * @throws ParseException 
	 * @throws Exception
	 */
	public ActionForward executeFilter(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws HWFServiceException, HWFStubException, ParseException
			 {
		PipelineInboxForm pipelineForm = (PipelineInboxForm) form;
		DealRequests dealCollection = new DealRequests();
		String[] productType = request.getParameterValues(PRODUCTTYPE);
		pipelineForm.setProductType(productType);
		String[] eventType = request.getParameterValues(EVENTTYPE);
		pipelineForm.setEventType(eventType);
		String[] region= request.getParameterValues(REGION);
		pipelineForm.setRegion(region);
		String[] businessSegment= request.getParameterValues(BUSINESSSEGMENT);
		pipelineForm.setBusinessSegment(businessSegment);
		String[] dealCategory = request.getParameterValues(DEALCATEGORY);
		if(dealCategory!=null && dealCategory.length>0)
		{
			Integer dealCategoryArr[] = new Integer[dealCategory.length];
			for(int i=0;i<dealCategory.length;i++){
				dealCategoryArr[i]= Integer.valueOf(dealCategory[i]);
			}
			
			pipelineForm.setDealCategory(dealCategoryArr);
		}else if (dealCategory ==null)
		{
			pipelineForm.setDealCategory(null);
		}
		
		String[] workFlowState= request.getParameterValues(PipelineInboxAction.WORK_FLOW_STATE);
		pipelineForm.setWorkFlowState(workFlowState);
		String[] dealType= request.getParameterValues(PipelineInboxAction.DEAL_TYPE);
		pipelineForm.setDealType(dealType);
		String[] priority= request.getParameterValues(PipelineInboxAction.PRIORITY2);
		pipelineForm.setPriority(priority);
		String[] currency= request.getParameterValues(CURRENCY);
		pipelineForm.setCurrency(currency);
		Search search = pipelineForm.getSearch();
		
		String dealDerivativeType = request.getParameter("search.dealWithDerivatives");
		if(dealDerivativeType==null){
			search.setDealWithDerivatives(null);
			pipelineForm.getSearch().setDealWithDerivatives(null);
		}
		
		String[] bSegments = ICFPCommonHelper.getUserBusinessSegment(request, businessSegment);
		String[] ownerBusinessSegment = ICFPCommonHelper.getOwnerBusinessSegment(request, businessSegment);
		SearchUtils.syncPipelineSearchCriteria(productType, eventType, region,
				bSegments, ownerBusinessSegment, dealCategory, workFlowState, dealType, priority, currency, search, request);

		search.setOpCode("FOSEARCH");
		search.setLoginSso(SessionManager.getSessionUser(request).getUserId());
		dealCollection = serviceClient.invokeService("SEARCH", search, DealRequests.class);
		List<PipelineDetails> searchDetails = PipelineUtils.populatePipelineSearch(dealCollection, request, "FO");
		if (searchDetails != null && !searchDetails.isEmpty()) {
			request.getSession().setAttribute(PIPELINEDETAILLIST,searchDetails);
		}else{
			request.getSession().setAttribute(PIPELINEDETAILLIST,searchDetails);
		}
		request.setAttribute(PipelineInboxAction.NO_CHART, true);
		return mapping.findForward(PipelineInboxAction.VIEWINBOX);
	}
	/**
	 * getFilteredList Method is used to filter Pipeline Data
	 * @param pipelineDetailList List<PipelineDetails>
	 * @return List<PipelineDetails>
	 */
	protected List<PipelineDetails> getFilteredList(List<PipelineDetails> pipelineDetailList,
			List<PipelineDetails> searchDetails) {
		List<PipelineDetails> filteredDealCollection = new ArrayList<PipelineDetails>();
		for (int i = 0; i < pipelineDetailList.size(); i++) {
			for (int j = 0; j < searchDetails.size(); j++) {
				if(searchDetails.get(j).getRequestID().equals(pipelineDetailList.get(i).getRequestID())){
					filteredDealCollection.add(pipelineDetailList.get(i));
				}
			}
		}
		return filteredDealCollection;
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
			throws HWFServiceException, HWFStubException, WriteException, ParseException, IOException, ICFPException {

		String filename = "PipelineExcel.xls";
		response.setContentType(APPLICATION_VND_MS_EXCEL);
	    response.setHeader(CONTENTDISPOSITION, "attachment; filename=\"" + filename + "\"");
	    String tableType = request.getParameter("tableType");
	    String pipelineType = request.getParameter("pipelineType");
	    WriteToExcel writeToExcel = new WriteToExcel();
	    OutputStream outStream = null;
	    try {
	    	outStream = response.getOutputStream();
	 	   writeToExcel.write(outStream, 
	 	    		(List<PipelineDetails>) request.getSession().getAttribute("pipelineDetailList"), tableType, pipelineType);
	    } finally {
	    	try {
				if(outStream != null) {
					outStream.close();
				}
			} catch (IOException e) {
				LOGGER.warn(PipelineInboxAction.ERROR_WHILE_CLOSING_OUTPUT_STREAM, e);
				throw new ICFPException("",PipelineInboxAction.ERROR_WHILE_CLOSING_OUTPUT_STREAM, e);
			}
	    }
	   
	    
		return null;
		
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
		String[] businessSegments = new String[]{"CLL Americas","Capital HQ/Other","Asia","Treasury","EMEA","GECAS","EMRG","Retail Finance","Restructure Op.","EFS","Commercial Real Estate"};
		
		for(String businessUnit : businessSegments ){
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
			searchRequest.setBusinessUnit( businessUnit );
			roleInfos.add(searchRequest);
		}
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
		return mapping.findForward(PipelineInboxAction.VIEWINBOX);

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
	public ActionForward executeFilterMO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws HWFServiceException, HWFStubException, ParseException
			 {
		PipelineInboxForm pipelineForm = (PipelineInboxForm) form;
		DealRequests dealCollection = new DealRequests();
		String[] productType = request.getParameterValues(PRODUCTTYPE);
		pipelineForm.setProductType(productType);
		String[] eventType = request.getParameterValues(EVENTTYPE);
		pipelineForm.setEventType(eventType);
		String[] region= request.getParameterValues(REGION);
		pipelineForm.setRegion(region);
		String[] businessSegment= request.getParameterValues(BUSINESSSEGMENT);
		pipelineForm.setBusinessSegment(businessSegment);
		String[] dealCategory = request.getParameterValues(DEALCATEGORY);
		if(dealCategory!=null && dealCategory.length>0)
		{
			Integer dealCategoryArr[] = new Integer[dealCategory.length];
			for(int i=0;i<dealCategory.length;i++){
				dealCategoryArr[i]= Integer.valueOf(dealCategory[i]);
			}
			
			pipelineForm.setDealCategory(dealCategoryArr);
		}else if (dealCategory ==null)
		{
			pipelineForm.setDealCategory(null);
		}
		
		String[] workFlowState= request.getParameterValues(PipelineInboxAction.WORK_FLOW_STATE);
		pipelineForm.setWorkFlowState(workFlowState);
		String[] dealType= request.getParameterValues(PipelineInboxAction.DEAL_TYPE);
		pipelineForm.setDealType(dealType);
		String[] priority= request.getParameterValues(PipelineInboxAction.PRIORITY2);
		pipelineForm.setPriority(priority);
		String[] currency= request.getParameterValues(CURRENCY);
		pipelineForm.setCurrency(currency);
		Search search = pipelineForm.getSearch();
		String dealDerivativeType = request.getParameter("search.dealWithDerivatives");
		if(dealDerivativeType==null){
			search.setDealWithDerivatives(null);
			pipelineForm.getSearch().setDealWithDerivatives(null);
		}
		String[] bSegments = ICFPCommonHelper.getUserBusinessSegment(request, businessSegment);
		String[] ownerBusinessSegment = ICFPCommonHelper.getOwnerBusinessSegment(request, businessSegment);
		SearchUtils.syncPipelineSearchCriteria(productType, eventType, region,
				bSegments, ownerBusinessSegment, dealCategory, workFlowState, dealType, priority, currency, search, request);
		search.setOpCode("MOSEARCH");
		search.setLoginSso(SessionManager.getSessionUser(request).getUserId());
		dealCollection = serviceClient.invokeService("SEARCH", search, DealRequests.class);
		List<PipelineDetails> searchDetails = PipelineUtils.populatePipelineSearch(dealCollection, request, "MO");
		if (searchDetails != null && !searchDetails.isEmpty()) {
			request.getSession().setAttribute(PIPELINEDETAILLIST,searchDetails);
		}else{
			request.getSession().setAttribute(PIPELINEDETAILLIST,searchDetails);
		}
		request.setAttribute(PipelineInboxAction.NO_CHART, true);
		return mapping.findForward(PipelineInboxAction.VIEWINBOXMO);
	}
	
	/**
	 * Return role name as comma seperated string
	 * @param roles
	 * @param roleName
	 * @return
	 * @throws ICFPException 
	 */
	private String getRoles(List<String> roles ) throws ICFPException {
		
		String roleName = null;		
		
		if(roles == null || roles.size() == 0){
			throw new  ICFPException(HWF_INBOX_1001);
		}
			 
		roleName = org.apache.commons.lang.StringUtils.join(roles, ",");
		
		return roleName;
	}

	/**
	 * @throws HWFStubException 
	 * @throws HWFServiceException 
	*
	*/
	public ActionForward getActionTaken(ActionMapping mapping,
											ActionForm form,
											HttpServletRequest request,
											HttpServletResponse response) throws HWFServiceException, HWFStubException{
		Integer dealId = Integer.parseInt( request.getParameter(PipelineInboxAction.DEAL_ID) );
		Integer stageId = Integer.parseInt( request.getParameter(PipelineInboxAction.STAGE_ID) );
		Integer actionId = Integer.parseInt( request.getParameter(ACTIONID) );
		
		UserActionData input = new UserActionData();		
		input.setDealSeqId( dealId );
		input.setWfStageId( stageId );
		input.setActionId( actionId );
		
		MsgHeader msgHeader = new MsgHeader();
		msgHeader.setOpcode("USERACTIONDATA");
		
		UserInformation userInfo = new UserInformation();
		userInfo.getUserActionDatas().add( input );
		userInfo.setMsgHeader(msgHeader);
		
		userInfo = serviceClient.invokeService(USERMGMT, userInfo, UserInformation.class);
		request.setAttribute(PipelineInboxAction.USER_DATA, userInfo.getUserActionDatas().get(0) );

		return mapping.findForward(PipelineInboxAction.ACTION_DETAIL);
	}

	/**
	 * 
	 * @return ServiceClient
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
