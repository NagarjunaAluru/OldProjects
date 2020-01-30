/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: DashboardDAO.java
 * DashboardDAO used to implement common operations for all dashboards
 */
package com.ge.aloc.dao.impl.dashboard;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.ge.aloc.DashboardViewType;
import com.ge.aloc.OpCode;
import com.ge.aloc.ServiceClientSupport;
import com.ge.aloc.UserRole;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.dao.dashboard.IDashboardDAO;
import com.ge.aloc.model.Inbox;
import com.ge.aloc.model.MsgHeader;
import com.ge.aloc.model.RequestDetails;
import com.ge.aloc.model.Search;
import com.ge.aloc.util.ALOCCommonHelper;
import com.hydus.hwf.context.UserContext;
import com.hydus.hwf.exceptions.HWFServiceException;
import com.opensymphony.xwork2.ActionContext;

/**
 * 
 * @author hariprasad.madas
 * 
 */
public class DashboardDAO extends ServiceClientSupport implements IDashboardDAO {

	/**
	 * Method to display Dashboard Details of all types
	 * @param inbox
	 * @return
	 * @throws HWFServiceException
	 */
	public Inbox loadDashboardData(Inbox inbox,DashboardViewType dashboardViewType) throws HWFServiceException {
		MsgHeader msgHeader = null;
		if(dashboardViewType != null){
			msgHeader = ALOCCommonHelper.createMsgHeader(dashboardViewType.getOpCode().getOperationCode());}
		else{
			msgHeader = ALOCCommonHelper.createMsgHeader(null);}
		inbox.setMsgHeader(msgHeader);
		inbox = serviceClient.invokeService(OpCode.INBOX.getOperationCode(), inbox, Inbox.class);
		return inbox;
	}

	/**
	 * Method to save default dashboard view
	 * @param inbox
	 * @return
	 * @throws HWFServiceException
	 */
	public Inbox saveDefaultDisplayTabName(Inbox inbox) throws HWFServiceException {
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.UPDATEDEFAULTVIEW.getOperationCode());
		inbox.setMsgHeader(msgHeader);
		inbox = serviceClient.invokeService(OpCode.INBOX.getOperationCode(), inbox, Inbox.class);
		return inbox;
	}

	/**
	 * Method to delete selected request from DashBoard
	 * @param requestDetails
	 * @return
	 * @throws HWFServiceException
	 */
	public RequestDetails deleteRequest(RequestDetails requestDetails)throws HWFServiceException{
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.DELETEREQ.getOperationCode());
		requestDetails.setMsgHeader(msgHeader);
		requestDetails=serviceClient.invokeService(OpCode.REQUESTDETAILS.getOperationCode(), requestDetails,RequestDetails.class);
		return requestDetails;	
	}

	/**
	 * Method to enable the selected Model
	 * @param inbox
	 * @return
	 * @throws HWFServiceException
	 */
	public Inbox enableModel(Inbox inbox) throws HWFServiceException {
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.DASHBOARD_MODELS.getOperationCode());
		msgHeader.setStatus(OpCode.ENABLE.getOperationCode());			
		inbox.setMsgHeader(msgHeader);
		inbox=serviceClient.invokeService(OpCode.INBOX.getOperationCode(), inbox, Inbox.class);
		return inbox;
	}

	/**
	 * Method to disable the selected Model
	 * @param inbox
	 * @return
	 * @throws HWFServiceException
	 */
	public Inbox disableModel(Inbox inbox) throws HWFServiceException {
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.DASHBOARD_MODELS.getOperationCode());
		msgHeader.setStatus(OpCode.DISABLE.getOperationCode());	
		inbox.setMsgHeader(msgHeader);
		inbox=serviceClient.invokeService(OpCode.INBOX.getOperationCode(), inbox, Inbox.class);
		return inbox;
	}

	/**
	 * Method to delete the selected Model
	 * @param inbox
	 * @return
	 * @throws HWFServiceException
	 */
	public Inbox deleteModel(Inbox inbox) throws HWFServiceException {		
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.DASHBOARD_MODELS.getOperationCode());
		msgHeader.setStatus(OpCode.DELETEMODEL.getOperationCode());
		inbox.setMsgHeader(msgHeader);
		inbox=serviceClient.invokeService(OpCode.INBOX.getOperationCode(), inbox, Inbox.class);
		return inbox;
	}


	/**
	 *  Method to get the my transactions details based on glance selection
	 * 
	 * @return
	 * @throws HWFServiceException 
	 */
	public Inbox getGlanceDetails(Search searchCriteria,String glancecount) throws HWFServiceException{
		List<String> userRoles = UserContext.getContext().getuserDetails().getRoles();
		Inbox inbox=new Inbox();
		MsgHeader msgHeader = null;
		if(userRoles.contains(UserRole.BankOperations.getName()) || userRoles.contains(UserRole.BankReadOnly.getName())){
			if(StringUtils.isNotEmpty(glancecount))
			{
				msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.BANKBIDRETURNREVISION.getOperationCode());
			}
			else{
				msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.BANKBIDGLANCECOUNT.getOperationCode());
			}
		}else if(userRoles.contains(UserRole.SuretyBrokerOperations.getName()) || userRoles.contains(UserRole.SuretyBrokerReadOnly.getName())){
			if(StringUtils.isNotEmpty(glancecount))
			{
				msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.BROKERBIDRETURNREVISION.getOperationCode());
			}
			else{
				msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.BROKERBIDGLANCECOUNT.getOperationCode());
			}
		}else if(userRoles.contains(UserRole.TreasuryAnalyst.getName()) || userRoles.contains(UserRole.TreasuryApprover.getName()))
		{
			Map<String, Object> sessionValues = ActionContext.getContext().getSession();
			MsgHeader msgHead=(MsgHeader)sessionValues.get(ALOCConstants.DASHBOARD_HEADEROPCODE);
			if(msgHead!=null && msgHead.getOpcode()!=null && msgHead.getOpcode().equalsIgnoreCase(ALOCConstants.MYTRANSACTION)){
				if(StringUtils.isNotEmpty(glancecount))
				{
					msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.RETURNREVISION.getOperationCode());
				}
				else{
					msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.GLANCECOUNT.getOperationCode());
				}
			}
			else{
				if(StringUtils.isNotEmpty(glancecount))
				{
					msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.TREASURYBIDRETURNREVISION.getOperationCode());
				}
				else{
					msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.TREASURYBIDGLANCECOUNT.getOperationCode());
				}
			}
		}else{
			if(StringUtils.isNotEmpty(glancecount))
			{
				msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.RETURNREVISION.getOperationCode());
			}
			else{
				msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.GLANCECOUNT.getOperationCode());
			}
		}
		searchCriteria.setMsgHeader(msgHeader);
		inbox  = serviceClient.invokeService(OpCode.MYTRANSGLANCECOUNT.getOperationCode(), searchCriteria, Inbox.class);	
		return inbox;
	}
}
