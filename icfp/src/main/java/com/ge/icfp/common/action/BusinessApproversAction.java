/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: BusinessApproversAction.java
 * Purpose:BusinessApproversAction used for Adding ,Deleting Additional Approvers
 */
package com.ge.icfp.common.action;

import static com.ge.icfp.common.constants.ICFPConstants.BUSINESSAPPROVERS;
import static com.ge.icfp.common.constants.ICFPConstants.BUSINESSAPPROVERSLIST;
import static com.ge.icfp.common.constants.ICFPConstants.CURRENTBUSINESSAPPROVERS;
import static com.ge.icfp.common.constants.ICFPConstants.DELETE;
import static com.ge.icfp.common.constants.ICFPConstants.DELETEBUSINESSAPPROVERS;
import static com.ge.icfp.common.constants.ICFPConstants.DUPLICATE;
import static com.ge.icfp.common.constants.ICFPConstants.INSERT;
import static com.ge.icfp.common.constants.ICFPConstants.ISEQUITY;
import static com.ge.icfp.common.constants.ICFPConstants.LAST_NAMEFIRST_NAME;
import static com.ge.icfp.common.constants.ICFPConstants.NAME;
import static com.ge.icfp.common.constants.ICFPConstants.SEARCHCRITERIA;
import static com.ge.icfp.common.constants.ICFPConstants.SEARCHTEXT;
import static com.ge.icfp.common.constants.ICFPConstants.SSOID;
import static com.ge.icfp.common.constants.ICFPConstants.SUCCESS;
import static com.ge.icfp.common.constants.ICFPConstants.USERMGMT;
import static com.ge.icfp.common.constants.ICFPConstants.USER_SSO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ge.icfp.action.ICFPBaseAction;
import com.ge.icfp.common.helper.CurrentDealManager;
import com.ge.icfp.model.BusinessApprovers;
import com.ge.icfp.model.DealRequest;
import com.ge.icfp.model.MsgHeader;
import com.ge.icfp.model.RoleInfo;
import com.ge.icfp.model.UserInformation;
import com.ge.icfp.tag.DealManager;
import com.hydus.wff.common.bw.ServiceClient;
import com.hydus.wff.core.context.UserContext;
import com.hydus.wff.core.exception.HWFServiceException;
import com.hydus.wff.core.exception.HWFStubException;
/**
 * BusinessApproversAction used for Adding ,Deleting Business Approvers
 * @author Narasimhulu
 *
 */
public class BusinessApproversAction extends ICFPBaseAction {
	private static final String BUSINESS_APPROVERS = "businessApprovers";
	private static final String BUSINESS_UNIT = "businessUnit";
	/**
	 * serviceClient
	 */
	private ServiceClient serviceClient;

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
	 * Delete Approver from the Deal Page
	 * @param  mapping  
	 * @param  form 
	 * @param  request  
	 * @param  response 
	 * @return ActionForward
	 */

	@SuppressWarnings("unchecked")
	public ActionForward deleteApprover(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws HWFServiceException {
		
		List<BusinessApprovers> currentBusinessApprovers = null;
		List<BusinessApprovers> businessApprovers = null;
		List<BusinessApprovers> deleteBusinessApprovers = null;
		List<BusinessApprovers> existingBusinessApprovers = null;
		String businessUnit = request.getParameter(BUSINESS_UNIT);
		Boolean isEquityDeal = CurrentDealManager.isEquityDeal(request);
		request.setAttribute(ISEQUITY,isEquityDeal);
		if(request.getSession().getAttribute(CURRENTBUSINESSAPPROVERS) == null ){
			currentBusinessApprovers = new ArrayList<BusinessApprovers>();
		}else{
			currentBusinessApprovers = (List<BusinessApprovers>) request.getSession().getAttribute(CURRENTBUSINESSAPPROVERS);
		}
		if(request.getSession().getAttribute(BUSINESSAPPROVERSLIST) == null ){
			businessApprovers = new ArrayList<BusinessApprovers>();
		}else {
			businessApprovers=(List<BusinessApprovers>) request.getSession().getAttribute(BUSINESSAPPROVERSLIST);
			existingBusinessApprovers=businessApprovers;
		}
		
		if(request.getSession().getAttribute(DELETEBUSINESSAPPROVERS) == null ){
			deleteBusinessApprovers = new ArrayList<BusinessApprovers>();
		}else{
			deleteBusinessApprovers = (List<BusinessApprovers>) request.getSession().getAttribute(DELETEBUSINESSAPPROVERS);
		}
		String ssoId = request.getParameter(SSOID);
	
		for(int i =0;i<currentBusinessApprovers.size();i++){
			BusinessApprovers bu = (BusinessApprovers) currentBusinessApprovers.get(i);
			if ( ssoId.equals(bu.getSSOID()) && businessUnit.equalsIgnoreCase(bu.getGroup()) ){
				currentBusinessApprovers.remove(i);
				break;
			}
		}
		for(int i =0;i<existingBusinessApprovers.size();i++){
			BusinessApprovers ba = (BusinessApprovers) existingBusinessApprovers.get(i);
			if ( ssoId.equals(ba.getSSOID()) && businessUnit.equalsIgnoreCase(ba.getGroup())  ){
				ba.setOpCode(DELETE);
				deleteBusinessApprovers.add(ba);
				break;
			}
		}
				
		if( (currentBusinessApprovers != null) && (currentBusinessApprovers.size() > 0 ) ){
			
			request.getSession().setAttribute(CURRENTBUSINESSAPPROVERS, currentBusinessApprovers);
		}
		if( (deleteBusinessApprovers != null) &&  (deleteBusinessApprovers.size() > 0 ) ){
			
			request.getSession().setAttribute(DELETEBUSINESSAPPROVERS, deleteBusinessApprovers);
		}
		return mapping.findForward(SUCCESS);
	}

	/**
	 * Saves selected Approver to the the Deal page from the search results
	 * @param  mapping  
	 * @param  form 
	 * @param  request  
	 * @param  response 
	 * @return ActionForward
	 */
	@SuppressWarnings("unchecked")
	public ActionForward saveSelection(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws HWFServiceException {

		String ssoId = request.getParameter(SSOID);
		String[] ssoIds = ssoId.split(",");
		String name = request.getParameter(NAME);
		String businessUnit = request.getParameter(BUSINESS_UNIT);
		String[] businessUnits = businessUnit.split(",");
		List<BusinessApprovers> currentBusinessApprovers = null;
		List<BusinessApprovers> businessApprovers = null;
		List<BusinessApprovers> existingBusinessApprovers = null;
		Boolean isEquityDeal = CurrentDealManager.isEquityDeal(request);
		request.setAttribute(ISEQUITY,isEquityDeal);
				
		if(request.getSession().getAttribute(CURRENTBUSINESSAPPROVERS) == null ){
			currentBusinessApprovers = new ArrayList<BusinessApprovers>();
		}else{
			currentBusinessApprovers = (List<BusinessApprovers>) request.getSession().getAttribute(CURRENTBUSINESSAPPROVERS);
		}
		

		if(request.getSession().getAttribute(BUSINESSAPPROVERSLIST) == null ){
			businessApprovers = new ArrayList<BusinessApprovers>();
		}else {
			businessApprovers=(List<BusinessApprovers>) request.getSession().getAttribute(BUSINESSAPPROVERSLIST);
			existingBusinessApprovers=businessApprovers;
		}
		if(ssoIds.length > 0){
			if(existingBusinessApprovers!=null && existingBusinessApprovers.size() > 0){
				for(int i =0;i<existingBusinessApprovers.size();i++){
					for(int j =0;j<ssoIds.length;j++){
						BusinessApprovers ba = (BusinessApprovers) existingBusinessApprovers.get(i);
						if (ssoIds[j].equalsIgnoreCase(ba.getSSOID()) && businessUnit.equalsIgnoreCase(ba.getGroup())){
							ssoIds[j]=DUPLICATE;
						}
					}
				}
			}
			if(currentBusinessApprovers!=null && currentBusinessApprovers.size() > 0){
				for(int i =0;i<currentBusinessApprovers.size();i++){
					for(int j =0;j<ssoIds.length;j++){
						BusinessApprovers cuba = (BusinessApprovers) currentBusinessApprovers.get(i);
						if (ssoIds[j].equalsIgnoreCase(cuba.getSSOID()) && businessUnit.equalsIgnoreCase(cuba.getGroup())){
							ssoIds[j]=DUPLICATE;
						}
					}
				}
			}
		}
		for(int i=0;i<ssoIds.length;i++) {
			 if(ssoIds[i]!=DUPLICATE){
					 currentBusinessApprovers = populateBusinessApprovers(ssoIds[i], name, businessUnit,currentBusinessApprovers);
			 }
		}	 
		if ((currentBusinessApprovers != null) && (currentBusinessApprovers.size() > 0)) {
			request.getSession().setAttribute(CURRENTBUSINESSAPPROVERS,currentBusinessApprovers);
			for (Object businessApprover : currentBusinessApprovers) {
				BusinessApprovers br = (BusinessApprovers) businessApprover;
				String userSsoId = br.getSSOID();
				String currentGroup = br.getGroup();
				boolean isExist = false;
				if (businessApprovers.size() > 0) {
					Iterator<BusinessApprovers> it = businessApprovers.iterator();
					while (it.hasNext()) {
						BusinessApprovers existingBA = (BusinessApprovers) it.next();
						if (userSsoId.equals(existingBA.getSSOID()) && currentGroup.equalsIgnoreCase(existingBA.getGroup())) {
							isExist = true;
						}

					}
					if (!isExist) {
						businessApprovers.add(br);
					}

				} else {
					businessApprovers.add(br);
				}

			}
		}
		request.getSession().setAttribute(BUSINESSAPPROVERSLIST,businessApprovers);

		return mapping.findForward(SUCCESS);

	}


	
	/**
	 * Helper method for populating the Additional Approvers
	 * @param  ssoId  
	 * @param  name 
	 */
	private List<BusinessApprovers> populateBusinessApprovers(String ssoId, String name, String businessUnit,List<BusinessApprovers> currentBusinessApprovers) {
		BusinessApprovers bar = new BusinessApprovers();
		bar.setSSOID(ssoId);
		bar.setGroup(businessUnit);
		if(name != null && !"".equals(name)){
			String[] names = name.split(",");
			bar.setFirstName(names[1]);
			bar.setLastName(names[0]);
		}
		bar.setOpCode(INSERT);
		bar.setAssignerSsoId(UserContext.getCurrentUserContext().getId());
		bar.setAssignerFirstName(UserContext.getCurrentUserContext().getFirstName());
		bar.setAssignerLastName(UserContext.getCurrentUserContext().getLastName());
		currentBusinessApprovers.add(bar);
		
		return currentBusinessApprovers;
	}
	/**
	 * Find the Business Approvers using SSOID,First Name,Last Name
	 * @param  mapping  
	 * @param  form 
	 * @param  request  
	 * @param  response 
	 * @return ActionForward
	 * @throws HWFStubException 
	 */
	public ActionForward businessSearch(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws HWFServiceException, HWFStubException {

		String searchCriteria = request.getParameter(SEARCHCRITERIA);
		String searchText = request.getParameter(SEARCHTEXT);
		List<BusinessApprovers> businessApproversList = new ArrayList<BusinessApprovers>();
		Boolean isEquityDeal = CurrentDealManager.isEquityDeal(request);
		request.setAttribute(ISEQUITY,isEquityDeal);
		MsgHeader msgHeader = new MsgHeader();
		msgHeader.setOpcode(BUSINESSAPPROVERS);
		if(UserContext.getCurrentUserContext() != null){
			String loggedInUserId = UserContext.getCurrentUserContext().getId();
			msgHeader.setAuditModifier(loggedInUserId);
		}

		UserInformation userInformation = new UserInformation();
		userInformation.setMsgHeader(msgHeader);
		List<RoleInfo> roleInfos = new ArrayList<RoleInfo>();
		
		DealRequest dealRequest = CurrentDealManager.getCurrentDeal(request);
		
		List<String> businessSegments = DealManager.getEquityBusinessSegment( request );
		
		for(String businessUnit : businessSegments ){
			RoleInfo searchRequest = new RoleInfo();

			if(searchCriteria.equalsIgnoreCase(USER_SSO)){
				searchRequest.setSsoId(searchText);
			} else if(searchCriteria.equalsIgnoreCase(LAST_NAMEFIRST_NAME)){
				String[] searchOn = searchText.split(",");
					if(searchOn.length==1){
					searchRequest.setFirstName(searchOn[0]);
					searchRequest.setLastName(searchOn[0]);
					}
					else{
					searchRequest.setFirstName(searchOn[1]);
					searchRequest.setLastName(searchOn[0]);
					}
				}
			searchRequest.setBusinessUnit( businessUnit );
			roleInfos.add(searchRequest);
		}
		
		if(businessSegments.size() < 1){
			RoleInfo searchRequest = new RoleInfo();
			if(searchCriteria.equalsIgnoreCase(USER_SSO)){
				searchRequest.setSsoId(searchText);
			}
			if(searchCriteria.equalsIgnoreCase(LAST_NAMEFIRST_NAME)){
				String[] searchOn = searchText.split(",");
					if(searchOn.length==1){
					searchRequest.setFirstName(searchOn[0]);
					searchRequest.setLastName(searchOn[0]);
					}
					else{
					searchRequest.setFirstName(searchOn[1]);
					searchRequest.setLastName(searchOn[0]);
					}
				}
			else{
				searchRequest.setFirstName(searchText);
				searchRequest.setLastName(searchText);
			}
			roleInfos.add(searchRequest);
		}
		
		userInformation.setRoleInfos(roleInfos);
		userInformation = serviceClient.invokeService(USERMGMT,userInformation, UserInformation.class);
		if (userInformation != null) {
			List<RoleInfo> roleInfoList = userInformation.getRoleInfos();
			if (searchCriteria.equalsIgnoreCase(USER_SSO)) {
				for (int i = 0; i < roleInfoList.size(); i++) {
					String ssoId = "";
					RoleInfo roleInfo = roleInfoList.get(i);
					if(roleInfo.getSsoId()!=null){
						ssoId =String.valueOf(roleInfo.getSsoId());
					}
					if(ssoId.equals(dealRequest.getTransOwnerSsoId())){
						continue;
					}
					BusinessApprovers businessApprover = new BusinessApprovers();
					businessApprover.setSSOID(roleInfo.getSsoId());
					businessApprover.setGroup(roleInfo.getBusinessUnit());
					businessApprover.setFirstName(roleInfo.getFirstName());
					businessApprover.setLastName(roleInfo.getLastName());
					businessApproversList.add(businessApprover);
				}
			}
			
			if (!searchCriteria.equalsIgnoreCase(USER_SSO)) {
				for (int i = 0; i < roleInfoList.size(); i++) {
					RoleInfo roleInfo = roleInfoList.get(i);
					String ssoId = "";
					if(roleInfo.getSsoId()!=null){
						ssoId =String.valueOf(roleInfo.getSsoId());
					}
					if(ssoId.equals(dealRequest.getTransOwnerSsoId())){
						continue;
					}
					BusinessApprovers businessApprover = new BusinessApprovers();
					businessApprover.setSSOID(roleInfo.getSsoId());
					businessApprover.setGroup(roleInfo.getBusinessUnit());
					businessApprover.setFirstName(roleInfo.getFirstName());
					businessApprover.setLastName(roleInfo.getLastName());
					businessApproversList.add(businessApprover);
				}
			}
		}
		request.setAttribute(BUSINESS_APPROVERS, businessApproversList);
		return mapping.findForward(SUCCESS);
	}
}
