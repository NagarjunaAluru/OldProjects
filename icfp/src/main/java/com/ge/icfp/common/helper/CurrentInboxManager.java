/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: CurrentInboxManager.java
 * Purpose: CurrentInboxManager used for setting Inbox Data in Session.
 */
package com.ge.icfp.common.helper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ge.icfp.model.DealRequest;
import com.ge.icfp.model.MyAssignData;
import com.ge.icfp.model.MyGroupTaskData;
import com.ge.icfp.model.MyTaskData;
import com.ge.icfp.model.UpdateStatus;
import com.ge.icfp.model.WorkItem;
import static com.ge.icfp.common.constants.ICFPConstants.*;
/**
 * Stores the User deals for his session
 * 
 * @author arijit.biswas
 *
 */
public class CurrentInboxManager {
	private static final String MY_ASSIGNED_TASKS = "myAssignedTasks";
	static final Logger LOGGER = Logger.getLogger(CurrentInboxManager.class);
	public static final String SSN_KEY_ASSIGN_DATA = "assignData";
	public static final String SSN_KEY_TASK_DATA = "taskData";
	public static final String SSN_KEY_GROUP_TASK_DATA = "groupTaskData";
	public static final String SSN_KEY_MYREQ_DATA = "myRequestData";
	public static final String SSN_KEY_MYDRAFT_DATA = "myDraftData";
	public static final String SSN_KEY_MYCLOSE_DATA = "myCloseData";
	
	/**
	 * setAssignedData used to assign MyAssignData in session
	 * @param assignedData
	 * @param request
	 */
	public static void setAssignedData(MyAssignData assignedData, HttpServletRequest request) {
		if(assignedData != null) {
			assignedData.setWorkItems(removeDuplicate(assignedData.getWorkItems()));
			HttpSession session = request.getSession();
			session.setAttribute(SSN_KEY_ASSIGN_DATA, assignedData);
		}
	}
	/**
	 * setTaskData used to assign MyTaskData in session
	 * @param taskData
	 * @param request
	 */
	public static void setTaskData(MyTaskData taskData, HttpServletRequest request) {
		if(taskData != null) {
			taskData.setWorkItems(removeDuplicate(taskData.getWorkItems()));
			HttpSession session = request.getSession();
			session.setAttribute(SSN_KEY_TASK_DATA, taskData);
		}
	}
	/**
	 * removeDuplicate
	 * @param arlList
	 * @return
	 */
	public static List<WorkItem> removeDuplicate(List<WorkItem> workItems) {
		Set<WorkItem> uniqueObjects = new HashSet<WorkItem>(workItems);
		return new ArrayList<WorkItem>(uniqueObjects);
	}
	
	/**
	 * setGroupTaskData used to assign MyGroupTaskData in session
	 * @param groupTaskData
	 * @param request
	 */
	public static void setGroupTaskData(MyGroupTaskData groupTaskData, HttpServletRequest request) {
		if(groupTaskData != null) {
			groupTaskData.setWorkItems(removeDuplicate(groupTaskData.getWorkItems()));
			HttpSession session = request.getSession();
			session.setAttribute(SSN_KEY_GROUP_TASK_DATA, groupTaskData);
		}
	}
	/**
	 * setMyRequestData used to assign My Request, Draft REquest, Closed Request Data in session
	 * @param myRequestData
	 * @param request
	 * @param requestType
	 */
	public static void setMyRequestData(MyTaskData myRequestData, HttpServletRequest request, String requestType) {
		if(myRequestData != null) {
			HttpSession session = request.getSession();
			if(requestType.equals(MYREQ)){
				session.setAttribute(SSN_KEY_MYREQ_DATA, myRequestData);
			}else if(requestType.equals(MYDRAFT)){
				session.setAttribute(SSN_KEY_MYDRAFT_DATA, myRequestData);
			}else if(requestType.equals(MYCLOSE)){
				session.setAttribute(SSN_KEY_MYCLOSE_DATA, myRequestData);
			}
		}
	}
	/**
	 * 
	 * @param request
	 * @return assignedData
	 */
	public static MyAssignData getAssignedData(HttpServletRequest request) {
		MyAssignData assignedData = null;
		HttpSession session = request.getSession(false);
		if(session != null) {
			assignedData = (MyAssignData) session.getAttribute(SSN_KEY_ASSIGN_DATA);
		}
		return assignedData;
	}
	
	/**
	 * 
	 * @param request
	 * @return taskData
	 */
	public static MyTaskData getTaskData(HttpServletRequest request) {
		MyTaskData taskData = null;
		HttpSession session = request.getSession(false);
		if(session != null) {
			taskData = (MyTaskData) session.getAttribute(SSN_KEY_TASK_DATA);
		}
		return taskData;
	}
	
	/**
	 * 
	 * @param request
	 * @return groupTaskData
	 */
	public static MyGroupTaskData getGroupTaskData(HttpServletRequest request) {
		MyGroupTaskData groupTaskData = null;
		HttpSession session = request.getSession(false);
		if(session != null) {
			groupTaskData = (MyGroupTaskData) session.getAttribute(SSN_KEY_GROUP_TASK_DATA);
		}
		return groupTaskData;
	}
	
	/**
	 * 
	 * @param request
	 * @return myRequestData
	 */
	public static MyTaskData getMyRequestData(HttpServletRequest request) {
		MyTaskData myRequestData = null;
		HttpSession session = request.getSession(false);
		if(session != null) {
			myRequestData = (MyTaskData) session.getAttribute(SSN_KEY_MYREQ_DATA);
		}
		return myRequestData;
	}
	
	/**
	 * 
	 * @param request
	 * @return myClosedData
	 */
	public static MyTaskData getClosedData(HttpServletRequest request) {
		MyTaskData myClosedData = null;
		HttpSession session = request.getSession(false);
		if(session != null) {
			myClosedData = (MyTaskData) session.getAttribute(SSN_KEY_MYREQ_DATA);
		}
		return myClosedData;
	}
	
	/**
	 * 
	 * @param request
	 * @return myDraftData
	 */
	public static MyTaskData getDraftData(HttpServletRequest request) {
		MyTaskData myDraftData = null;
		HttpSession session = request.getSession(false);
		if(session != null) {
			myDraftData = (MyTaskData) session.getAttribute(SSN_KEY_MYREQ_DATA);
		}
		return myDraftData;
	}
	
	/**
	 * Update the Workflow info like queue name, Stage id , current stage into updatestatus object
	 * 
	 * @param updateStatus
	 * @param request
	 */
	public static void updateWorkflowData(UpdateStatus updateStatus, HttpServletRequest request){
		
		String dealId = updateStatus.getDealSeqId();
		String section = (String) request.getSession().getAttribute(SECTION);
		List<WorkItem> allworkItems = new ArrayList<WorkItem>();
		if(MYTASKS_SMALL.equals(section)){
			MyTaskData mytaskData = getTaskData(request);
			allworkItems.addAll( mytaskData.getWorkItems() );
		}else if(CurrentInboxManager.MY_ASSIGNED_TASKS.equals(section)){
			MyAssignData unassignData = getAssignedData(request);
			allworkItems.addAll(unassignData.getWorkItems());
		}
		
		for(WorkItem item: allworkItems ){
			
			if(item.getDealSeqID().equals(dealId)){
				updateStatus.setWFId( item.getWFID() );
				updateStatus.setWFStage( item.getCurrentStage() );
				updateStatus.setQueueName( item.getQueueName() );
				break;
			}
		}
	}
	/**
	 * Returns Work flow stage for the given deal 
	 * @param dealRequest
	 * @param request
	 */
	public static String getWorkflowStage(DealRequest dealRequest, HttpServletRequest request){
		String section = (String) request.getSession().getAttribute(SECTION);
		if(section == null){
			section = request.getParameter(SECTION);
		}
		List<WorkItem> allworkItems = new ArrayList<WorkItem>();
		
		if(MYTASKS_SMALL.equals(section)){
			MyTaskData mytaskData = getTaskData(request);
			allworkItems.addAll( mytaskData.getWorkItems() );
		}else if(CurrentInboxManager.MY_ASSIGNED_TASKS.equals(section)){
			MyAssignData unassignData = getAssignedData(request);
			allworkItems.addAll(unassignData.getWorkItems());
		}
		for(WorkItem item: allworkItems ){
			if(item.getDealSeqID()!=null && dealRequest.getDealSeqId()!=null){
				if(item.getDealSeqID().trim().equals(dealRequest.getDealSeqId().toString())){
					return item.getCurrentStage();
				}
			}
		}
		return null;
	}
	/**
	 * Returns the workstage of current deal.
	 * 
	 * @param request
	 * @return
	 */
	public static String getCurrentWorkflowStage(HttpServletRequest request){
		
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		
		return getWorkflowStage(deal, request);
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public static String getCurrentWorkflowQueueName(HttpServletRequest request){
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		return getWorkflowQueueName(deal, request);
	}
	/**
	 * 
	 * @param dealRequest
	 * @param request
	 * @return
	 */
	public static String getWorkflowQueueName(DealRequest dealRequest, HttpServletRequest request){
		String section = (String) request.getSession().getAttribute(SECTION);
		List<WorkItem> allworkItems = new ArrayList<WorkItem>();
		
		if(MYTASKS_SMALL.equals(section)){
			MyTaskData mytaskData = getTaskData(request);
			allworkItems.addAll( mytaskData.getWorkItems() );
		}else if(CurrentInboxManager.MY_ASSIGNED_TASKS.equals(section)){
			MyAssignData unassignData = getAssignedData(request);
			allworkItems.addAll(unassignData.getWorkItems());
		}
		for(WorkItem item: allworkItems ){
			if(item.getDealSeqID()!=null && dealRequest.getDealSeqId()!=null){
				if(item.getDealSeqID().trim().equals(dealRequest.getDealSeqId().toString())){
					return item.getQueueName();
				}
			}
		}
		return null;
		
	}
}
