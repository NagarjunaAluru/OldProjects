/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: AdditionalApproversAction.java
 * Purpose:AdditionalApproversAction used for Adding ,Deleting Additional Approvers
 */
package com.ge.icfp.common.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ge.icfp.action.ICFPBaseAction;
import com.ge.icfp.common.helper.CurrentDealManager;
import com.ge.icfp.common.helper.CurrentInboxManager;
import com.ge.icfp.model.AdditionalApprovers;
import com.ge.icfp.model.DealRequest;
import com.ge.icfp.model.MsgHeader;
import com.ge.icfp.model.RoleInfo;
import com.ge.icfp.model.UpdateStatus;
import com.ge.icfp.model.UserInfo;
import com.ge.icfp.model.UserInformation;
import com.hydus.wff.common.bw.ServiceClient;
import com.hydus.wff.core.context.UserContext;
import com.hydus.wff.core.exception.HWFServiceException;
import com.hydus.wff.core.exception.HWFStubException;

import formdef.plugin.util.FormUtils;
import static com.ge.icfp.common.constants.ICFPConstants.*;
/**
 * AdditionalApproversAction used for Adding ,Deleting Additional Approvers
 * @author sreenivas.pattaswamy
 *
 */
public class AdditionalApproversAction extends ICFPBaseAction {
	private static final String ADDITIONAL_APPROVERS = "additionalApprovers";
	private static final String ALL_SEARCH_USER_INFO = "allSearchUserInfo";
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
		ActionForward forward = null;
		
		List<UserInfo> userInfoList = null;
		List<UserInfo> deleteUserInfoList = null;
		AdditionalApprovers additionalApprovers = null;
		List<UserInfo> existingUserInfoList = null;
		UpdateStatus updateStatus = createUpdateStatusBean(mapping, form, request);
		
		if(request.getSession().getAttribute(CURRENTUSERINFOLIST) == null ){
			 userInfoList = new ArrayList<UserInfo>();
		}else{
			userInfoList = (List<UserInfo>) request.getSession().getAttribute(CURRENTUSERINFOLIST);
		}
		if(request.getSession().getAttribute(CURRENTADDITIONALAPPROVERS) == null ){
			 additionalApprovers = new AdditionalApprovers();
		}else {
			additionalApprovers = (AdditionalApprovers) request.getSession().getAttribute(CURRENTADDITIONALAPPROVERS);
			existingUserInfoList=additionalApprovers.getUserInfos();
		}
		
		if(request.getSession().getAttribute(DELETEUSERINFOLIST) == null ){
			deleteUserInfoList = new ArrayList<UserInfo>();
		}else{
			deleteUserInfoList = (List<UserInfo>) request.getSession().getAttribute(DELETEUSERINFOLIST);
		}
		String ssoId = request.getParameter(SSOID);
	
		for(int i =0;i<userInfoList.size();i++){
			UserInfo userInfo = (UserInfo) userInfoList.get(i);
			if ( ssoId.equals(userInfo.getSsoId())  ){
				 userInfoList.remove(i);
   				 break;
			}
		}
		for(int i =0;i<existingUserInfoList.size();i++){
			UserInfo userInfo = (UserInfo) existingUserInfoList.get(i);
			if ( ssoId.equals(userInfo.getSsoId())  ){
				deleteUserInfoList.add(userInfo);
				break;
			}
		}
				
		if( (userInfoList != null) && (userInfoList.size() > 0 ) ){
			request.getSession().setAttribute(CURRENTUSERINFOLIST, userInfoList);
		}
		if( (deleteUserInfoList != null) &&  (deleteUserInfoList.size() > 0 ) ){
			request.getSession().setAttribute(DELETEUSERINFOLIST, deleteUserInfoList);
		}
		
		Boolean isCPADeal = CurrentDealManager.isCPADeal(request);
		Boolean isEquityDeal = CurrentDealManager.isEquityDeal(request);
		request.setAttribute(ISCPA,isCPADeal);
		request.setAttribute(ISEQUITY,isEquityDeal);
		
		String wfStage = updateStatus.getWFStage();
		if(SOTLEGAL.equals(wfStage)){
			forward=mapping.findForward(SUCCESS);
			
		}else{
			forward=mapping.findForward(FRONTOFFICE);
		}
		return forward;
						
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
		ActionForward forward = null;

		String ssoId = request.getParameter(SSOID);
		String[] ssoIds = ssoId.split(",");
		String name = request.getParameter(NAME);
		List<UserInfo> userInfoList = null;
		AdditionalApprovers additionalApprovers = null;
		List<UserInfo> existingUserInfoList = null;
		UpdateStatus updateStatus = createUpdateStatusBean(mapping, form, request);
		
		if(request.getSession().getAttribute(CURRENTUSERINFOLIST) == null ){
			 userInfoList = new ArrayList<UserInfo>();
		}else{
			userInfoList = (List<UserInfo>) request.getSession().getAttribute(CURRENTUSERINFOLIST);
		}
		
		if(request.getSession().getAttribute(CURRENTADDITIONALAPPROVERS) == null ){
			 additionalApprovers = new AdditionalApprovers();
		}else {
			additionalApprovers = (AdditionalApprovers) request.getSession().getAttribute(CURRENTADDITIONALAPPROVERS);
			existingUserInfoList=additionalApprovers.getUserInfos();
		}


		if(ssoIds.length > 0){
			if(existingUserInfoList!=null && existingUserInfoList.size() > 0){
				for(int i =0;i<existingUserInfoList.size();i++){
					for(int j =0;j<ssoIds.length;j++){
						UserInfo userInfo = (UserInfo) existingUserInfoList.get(i);
						if (ssoIds[j].equalsIgnoreCase(userInfo.getSsoId())){
							ssoIds[j]=DUPLICATE;
						}
					}
				}
			}
			if(userInfoList!=null && userInfoList.size() > 0){
				for(int i =0;i<userInfoList.size();i++){
					for(int j =0;j<ssoIds.length;j++){
						UserInfo userInfo = (UserInfo) userInfoList.get(i);
						if (ssoIds[j].equalsIgnoreCase(userInfo.getSsoId())){
							ssoIds[j]=DUPLICATE;
						}
					}
				}
			}
		}
		 for(int i=0;i<ssoIds.length;i++) {
			 if(ssoIds[i]!=DUPLICATE){
				 name = getName(request,ssoIds[i]); // lookup data reading once gain from mdm
				 if(name!=null) {
					 userInfoList=populateApprovers(ssoIds[i], name, userInfoList);
				 }
			 }
		 }	 
		
		if( (userInfoList != null) && (userInfoList.size() > 0 ) ){
			
			request.getSession().setAttribute(CURRENTUSERINFOLIST, userInfoList);
			if (additionalApprovers.getUserInfos().size() > 0) {
				
				List<UserInfo>totalUserList=null;
				totalUserList=additionalApprovers.getUserInfos();
				for (Object user : userInfoList) {
					UserInfo userInfo = (UserInfo) user;
					String userSsoId = userInfo.getSsoId();
					boolean isExist = false;
					Iterator<UserInfo> it = totalUserList.iterator();
					while (it.hasNext()) {
						UserInfo existingUser = (UserInfo) it.next();
						if (userSsoId.equals(existingUser.getSsoId())) {
							isExist = true;
						}

					}
					if (!isExist) {
						totalUserList.add(userInfo);
					}

				}
				additionalApprovers.setUserInfos(totalUserList);

			}else{
				additionalApprovers.setUserInfos(userInfoList);
			}
						
			request.getSession().setAttribute(CURRENTADDITIONALAPPROVERS, additionalApprovers);
			
		}
		
		Boolean isCPADeal = CurrentDealManager.isCPADeal(request);
		Boolean isEquityDeal = CurrentDealManager.isEquityDeal(request);
		request.setAttribute(ISCPA,isCPADeal);
		request.setAttribute(ISEQUITY,isEquityDeal);
		
		String wfStage = updateStatus.getWFStage();
		if(SOTLEGAL.equals(wfStage)){
			forward=mapping.findForward(SUCCESS);
			
		}else{
			forward=mapping.findForward(FRONTOFFICE);
		}
				
		return forward;
		
		
	}
	
	
	/**
	 * why we need this method is searched name contains multiple ',' 
	 * Thats why userinfo mdm search list we are getting from session
	 * @param request
	 * @param ssoID
	 * @return
	 */
	private String getName(HttpServletRequest request, String ssoID) {
		String name = null;
		if(request.getSession().getAttribute(ALL_SEARCH_USER_INFO)!=null) {
		AdditionalApprovers additionalApproversSearch = (AdditionalApprovers) request.getSession().getAttribute(ALL_SEARCH_USER_INFO);
		if (additionalApproversSearch != null) {
			List<UserInfo> li = additionalApproversSearch.getUserInfos();
			for (int i = 0; i < li.size(); i++) {
				UserInfo userInfo = (UserInfo) li.get(i);
				if (userInfo.getSsoId().equals(ssoID)) {
					name = userInfo.getLastName()+"," + userInfo.getFirstName();
					break;
				}
			}
		}
		}
		return name;
	}


	/**
	 * Find the Additional Approvers using SSOID,First Name,Last Name,Full Name & Email Address
	 * @param  mapping  
	 * @param  form 
	 * @param  request  
	 * @param  response 
	 * @return ActionForward
	 * @throws HWFStubException 
	 */
	public ActionForward search(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws HWFServiceException, HWFStubException {
		ActionForward forward = null;
		UpdateStatus updateStatus = createUpdateStatusBean(mapping, form, request);
		String searchCriteria = request.getParameter(SEARCHCRITERIA);
		String searchText = request.getParameter(SEARCHTEXT);
		HttpSession session = request.getSession();
		List<UserInfo> userInfoSearchResultsList = new ArrayList<UserInfo>();
		if(request.getSession().getAttribute(ALL_SEARCH_USER_INFO)!=null) {
			//refer getName method
			request.getSession().setAttribute(ALL_SEARCH_USER_INFO,null);
		}
		MsgHeader msgHeader = new MsgHeader();
		msgHeader.setOpcode(USERSEARCH);
		if(UserContext.getCurrentUserContext() != null){
			String loggedInUserId = UserContext.getCurrentUserContext().getId();

			msgHeader.setAuditModifier(loggedInUserId);
		}

		UserInformation userInformation = new UserInformation();
		userInformation.setMsgHeader(msgHeader);
		List<RoleInfo> roleInfos = new ArrayList<RoleInfo>();
		//TODO Full Name,Email,Group attributes needs to be added
		RoleInfo searchRequest = new RoleInfo();

		if(searchCriteria!=null && searchCriteria.equalsIgnoreCase(USER_SSO)){
			searchRequest.setSsoId(searchText);
		} else if(searchCriteria!=null && searchCriteria.equalsIgnoreCase(LAST_NAMEFIRST_NAME)){
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
		roleInfos.add(searchRequest);
		userInformation.setRoleInfos(roleInfos);
		DealRequest dealRequest = CurrentDealManager.getCurrentDeal(request);
		userInformation = serviceClient.invokeService(USERMGMT,
				userInformation, UserInformation.class);
		if (userInformation != null) {
			List<RoleInfo> roleInfoList = userInformation.getRoleInfos();
			
			if (searchCriteria!=null && searchCriteria.equalsIgnoreCase(USER_SSO)) {
				for (int i = 0; i < roleInfoList.size(); i++) {
					RoleInfo roleInfo = roleInfoList.get(i);
					
					String ssoId = "";
					if(roleInfo.getSsoId()!=null){
						ssoId =String.valueOf(roleInfo.getSsoId());
					}
					if(ssoId.equals(dealRequest.getTransOwnerSsoId())){
						continue;
					}
					
					UserInfo userInfo = new UserInfo();
					userInfo.setSsoId(roleInfo.getSsoId());
					userInfo.setFirstName(roleInfo.getFirstName());
					userInfo.setLastName(roleInfo.getLastName());					
					userInfoSearchResultsList.add(userInfo);
				}
			}
			// //////////////
			// Note - other than SSO ID search - not implementing the work
			// around
			if (searchCriteria!=null && !searchCriteria.equalsIgnoreCase(USER_SSO)) {
				for (int i = 0; i < roleInfoList.size(); i++) {
					RoleInfo roleInfo = roleInfoList.get(i);
					String ssoId = "";
					if(roleInfo.getSsoId()!=null){
						ssoId =String.valueOf(roleInfo.getSsoId());
					}
					if(ssoId.equals(dealRequest.getTransOwnerSsoId())){
						continue;
					}
					UserInfo userInfo = new UserInfo();
					userInfo.setSsoId(roleInfo.getSsoId());
					userInfo.setFirstName(roleInfo.getFirstName());
					userInfo.setLastName(roleInfo.getLastName());					
					userInfoSearchResultsList.add(userInfo);
				}
			}
		}
		AdditionalApprovers additionalApproversSearch = new AdditionalApprovers();
		additionalApproversSearch.setUserInfos(userInfoSearchResultsList);
		request.setAttribute(ADDITIONAL_APPROVERS, additionalApproversSearch);
		//refer getName method for below line
		session.setAttribute(ALL_SEARCH_USER_INFO, additionalApproversSearch);
		
		Boolean isCPADeal = CurrentDealManager.isCPADeal(request);
		Boolean isEquityDeal = CurrentDealManager.isEquityDeal(request);
		request.setAttribute(ISCPA,isCPADeal);
		request.setAttribute(ISEQUITY,isEquityDeal);
		
		String wfStage = updateStatus.getWFStage();
		if(SOTLEGAL.equals(wfStage)){
			forward=mapping.findForward(SUCCESS);
			
		}else{
			forward=mapping.findForward(FRONTOFFICE);
		}
				
		return forward;
	}

	/**
	 * Helper method for populating the Additional Approvers
	 * @param  ssoId  
	 * @param  name 
	 */
	private List<UserInfo> populateApprovers(String ssoId, String name, List<UserInfo> userInfoList) {
		UserInfo userInfo = new UserInfo();
		userInfo.setSsoId(ssoId);
		
		if(name != null && !"".equals(name)){
			String[] names = name.split(",");
			userInfo.setFirstName(names[1]);
			userInfo.setLastName(names[0]);
		}
		userInfo.setAssignerSsoId(UserContext.getCurrentUserContext().getId());
		userInfo.setAssignerFirstName(UserContext.getCurrentUserContext().getFirstName());
		userInfo.setAssignerLastName(UserContext.getCurrentUserContext().getLastName());
		userInfoList.add(userInfo);
		
		return userInfoList;
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
		
		updateStatus.setDealSeqId( String.valueOf(deal.getDealSeqId()) );
		if(null == updateStatus.getActionId()){
			if(null != request.getParameter(ACTION)){
				updateStatus.setActionId((String)request.getParameter(ACTION));
			}
		}
		CurrentInboxManager.updateWorkflowData(updateStatus, request);
		
		return updateStatus;
	}
}
