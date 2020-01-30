/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: HomePageAction.java
 */

package com.ge.icfp.common.action;

import static com.ge.icfp.common.constants.ICFPConstants.DEAL;
import static com.ge.icfp.common.constants.ICFPConstants.DELETE;
import static com.ge.icfp.common.constants.ICFPConstants.HWF_INBOX_1001;
import static com.ge.icfp.common.constants.ICFPConstants.INBOX;
import static com.ge.icfp.common.constants.ICFPConstants.MYCLOSE;
import static com.ge.icfp.common.constants.ICFPConstants.MYDRAFT;
import static com.ge.icfp.common.constants.ICFPConstants.MYREQ;
import static com.ge.icfp.common.constants.ICFPConstants.MYTASKS;
import static com.ge.icfp.common.constants.ICFPConstants.ONLYPIPELINE;
import static com.ge.icfp.common.constants.ICFPConstants.PLERIVEW;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import com.ge.icfp.action.ICFPBaseAction;
import com.ge.icfp.action.ICFPException;
import com.ge.icfp.common.attachments.ICFPAttachmentManager;
import com.ge.icfp.common.helper.CurrentInboxManager;
import com.ge.icfp.common.helper.ICFPCommonHelper;
import com.ge.icfp.model.DealRequest;
import com.ge.icfp.model.InboxReply;
import com.ge.icfp.model.MsgHeader;
import com.ge.icfp.model.MyAssignData;
import com.ge.icfp.model.MyTaskData;
import com.ge.icfp.model.WorkItem;
import com.ge.icfp.util.UserRole;
import com.hydus.wff.common.bw.ServiceClient;
import com.hydus.wff.core.context.UserContext;
import com.hydus.wff.core.exception.HWFServiceException;
import com.hydus.wff.core.exception.HWFStubException;
import com.hydus.wff.core.session.SessionManager;
/**
 * Load the Inbox Screen
 * @author arijit.biswas
 *
 */
public class InboxAction extends ICFPBaseAction{
	private static final String DELETE_REQUEST_LIST = "deleteRequestList";
	private static final String BEGIN_INBOX_ACTION_DELETE_DRAFT_REQUEST = "Begin - InboxAction.deleteDraftRequest()";
	private static final String BEGIN_INBOX_ACTION_EXECUTE_INBOX_TASK = "Begin - InboxAction.executeInboxTask()";
	private static final String MY_DRAFT_COUNT = "MyDraftCount";
	private static final String MY_CLOSE_COUNT = "MyCloseCount";
	private static final String MY_REQUEST_COUNT = "MyRequestCount";
	private static final String MY_UNASSIGNED_TASK_COUNT = "MyUnassignedTaskCount";
	private static final String MYASSIGNEDTASKS = "MYASSIGNEDTASKS";
	private static final String PIPELINE_MGMT = "ICFP-PipelineManagement";
	private static final String TYPE2 = "type";
	private static final Logger LOGGER = Logger.getLogger(InboxAction.class);
	private static final String FORWARD_HOMEPAGE = "inboxPage";
	public static final String FORWARD_SEARCHPAGE = "readOnlySearch";
	private ServiceClient serviceClient;
	private ICFPAttachmentManager attachmentManager;
	
	public ICFPAttachmentManager getAttachmentManager() {
		return attachmentManager;
	}

	public void setAttachmentManager(ICFPAttachmentManager attachmentManager) {
		this.attachmentManager = attachmentManager;
	}
	/**
	 * Call the Inbox service for logged in USER and returns all the deals to Inbox screen
	 * @throws HWFServiceException 
	 * @throws HWFStubException 
	 * @throws ICFPException 
	 * 
	 */
	public ActionForward executeInbox(ActionMapping mapping, 
										ActionForm form, 
										HttpServletRequest request, 
										HttpServletResponse response) 
				throws HWFServiceException, HWFStubException, ICFPException	{
		DynaActionForm loginForm = (DynaActionForm) form;
		String type = loginForm.getString(TYPE2);
		List<String> roles = SessionManager.getRoles(request);
		String roleName = getRoles(roles);
		InboxReply inboxReply = null;
		if(StringUtils.isEmpty(type)){
			type = MYTASKS;
		}
		
		//Forward to search screen if all the roles are read only
		if( hasOnlyReadRoles(roles) ){
			return mapping.findForward(FORWARD_SEARCHPAGE);
		}	
		
		if(MYTASKS.equals(type) || MYASSIGNEDTASKS.equals(type)){
			inboxReply = serviceClient.invokeService(INBOX, setMessageHeader(request, roleName,MYTASKS), InboxReply.class);
			MyAssignData assignedData = inboxReply.getMyAssignData();
			CurrentInboxManager.setAssignedData(assignedData, request);
			MyTaskData taskData = inboxReply.getMyTaskData();
			CurrentInboxManager.setTaskData(taskData, request);
			request.getSession().setAttribute(MY_UNASSIGNED_TASK_COUNT, assignedData.getWorkItems().size());
			request.getSession().setAttribute(MY_REQUEST_COUNT, inboxReply.getMyReqCount());
			request.getSession().setAttribute(MY_CLOSE_COUNT, inboxReply.getMyCloseCount());
			request.getSession().setAttribute(MY_DRAFT_COUNT, inboxReply.getMyDraftCount());
			
			List<String> onlyPipelineDetails = new ArrayList<String>();
			MyTaskData pipeLineTaskData = CurrentInboxManager.getTaskData(request);
			List<WorkItem> workItems = pipeLineTaskData.getWorkItems();
			for (WorkItem eachDeal : workItems) {
				if(eachDeal.getQueueName()!=null && eachDeal.getQueueName().equals(PIPELINE_MGMT)){
					onlyPipelineDetails.add(String.valueOf(eachDeal.getDealSeqID()));
				}
			}
			request.getSession().setAttribute(ONLYPIPELINE, onlyPipelineDetails );
			
		}else if(MYREQ.equals(type) || MYDRAFT.equals(type) || MYCLOSE.equals(type)){
			inboxReply = serviceClient.invokeService(INBOX, setMessageHeader(request, roleName,type), InboxReply.class);
			MyTaskData myRequestData = inboxReply.getMyTaskData();
			CurrentInboxManager.setMyRequestData(myRequestData, request,type);
		}
		
		loginForm.set(TYPE2, type);
		return mapping.findForward(FORWARD_HOMEPAGE);
	}
	/**
	 * Action invoked on Home page link, 
	 * This will load either Search screen(if user has only read role)
	 * or inbox screen
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HWFServiceException
	 * @throws HWFStubException
	 * @throws ICFPException 
	 */
	public ActionForward executeInboxHomeLink(ActionMapping mapping, 
												ActionForm form, 
												HttpServletRequest request, 
												HttpServletResponse response) 
					throws HWFServiceException, HWFStubException, ICFPException{
		
		DynaActionForm loginForm = (DynaActionForm) form;
		loginForm.set(TYPE2, MYTASKS);
		
		return executeInbox(mapping, loginForm, request, response);
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
	 * @throws ICFPException
	 */
	public ActionForward executeInboxTask(ActionMapping mapping, 
											ActionForm form, 
											HttpServletRequest request, 
											HttpServletResponse response) 
					throws HWFServiceException, HWFStubException, ICFPException	{
		if (LOGGER.isDebugEnabled()) {
		LOGGER.debug(BEGIN_INBOX_ACTION_EXECUTE_INBOX_TASK);
		}
		DynaActionForm loginForm = (DynaActionForm) form;
		String type = loginForm.getString(TYPE2);
		loginForm.set(TYPE2, type);
		return mapping.findForward(FORWARD_HOMEPAGE);
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
	 * @throws ICFPException
	 */
	public ActionForward deleteDraftRequest(ActionMapping mapping, 
											ActionForm form, 
											HttpServletRequest request, 
											HttpServletResponse response) 
					throws HWFServiceException, HWFStubException, ICFPException	{
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(BEGIN_INBOX_ACTION_DELETE_DRAFT_REQUEST);
			}
		DynaActionForm loginForm = (DynaActionForm) form;
		InboxReply inboxReply = null;
		String type = loginForm.getString(TYPE2);
		MsgHeader msgHeader = new MsgHeader();
		String userId = UserContext.getCurrentUserContext().getId();
		msgHeader.setOpcode(DELETE);
		msgHeader.setAuditModifier(userId);
		msgHeader.setAuditModifierFirstName(UserContext.getCurrentUserContext().getFirstName());
		msgHeader.setAuditModifierLastName(UserContext.getCurrentUserContext().getLastName());
		String deleteRequestList = loginForm.getString(DELETE_REQUEST_LIST);
		
		// Delete attachments of selected deals
		if(StringUtils.isNotBlank(deleteRequestList)) {
			StringTokenizer dealIds = new StringTokenizer(deleteRequestList, ",");
			while(dealIds.hasMoreTokens()) {
				String dealId = dealIds.nextToken();
				DealRequest deal = ICFPCommonHelper.getDeal(Integer.valueOf(dealId), serviceClient);
				attachmentManager.deleteAllAttachments(deal);
			}
		}
		
		DealRequest dealRequest = new DealRequest();
		dealRequest.setUniqueId(deleteRequestList);
		dealRequest.setMsgHeader(msgHeader);
		
		dealRequest = serviceClient.invokeService(DEAL, dealRequest, DealRequest.class);
		
		List<String> roles = SessionManager.getRoles(request);
		String roleName = getRoles(roles);
		
		inboxReply = serviceClient.invokeService(INBOX, setMessageHeader(request, roleName,type), InboxReply.class);
		MyTaskData myRequestData = inboxReply.getMyTaskData();
		CurrentInboxManager.setMyRequestData(myRequestData, request,type);
		request.getSession().setAttribute(MY_DRAFT_COUNT, myRequestData.getWorkItems().size());
		loginForm.set(TYPE2, type);
		return mapping.findForward(FORWARD_HOMEPAGE);
	}
	/**
	 * @param request
	 * @param roleName
	 * @return
	 */
	private MsgHeader setMessageHeader(HttpServletRequest request,
			String roleName, String opCode) {
		MsgHeader msgHeader = new MsgHeader();
		msgHeader.setOpcode(opCode);
		msgHeader.setAuditCreator(SessionManager.getUserID(request));
		msgHeader.setRoleName(roleName);
		return msgHeader;
	}
	
	/**
	 * Return true if only Read Only roles available 
	 * 
	 * @param roles
	 * @return
	 */
	private boolean hasOnlyReadRoles(List<String> roles){
		if( roles == null || roles.isEmpty()) {
			return false;
		}
		for(String role: roles){
			if(!role.contains( UserRole.ReadOnlyRole.getName() )){
				return false;
			}			
		}
		return true;
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
	 * 
	 * @return
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
