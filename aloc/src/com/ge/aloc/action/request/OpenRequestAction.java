/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: OpenRequestAction.java
 * Purpose: OpenRequestAction used for the request operations
 */
package com.ge.aloc.action.request;

import java.math.BigInteger;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.ge.aloc.DashboardViewType;
import com.ge.aloc.UserRole;
import com.ge.aloc.WorkflowStage;
import com.ge.aloc.constants.ALOCConstants;
import com.hydus.hwf.context.UserContext;
import com.hydus.hwf.util.StringUtils;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author madhusudhan.gosula
 *
 */
public class OpenRequestAction extends ActionSupport {

	private static final long serialVersionUID = 6877115971939061788L;

	private BigInteger requestId;
	private WorkflowStage stage;
	private String stageName;
	private DashboardViewType dashboardViewType;
	private String requestorSSO;
	private String historicalTab;


	/**
	 * This method is used to open the request based on workflow stage 
	 * and navigate to the appropriate page..
	 * @return
	 */
	public String execute() {
		String resultName = null;
		if (getDashboardViewType() != null) {
			if (getDashboardViewType().equals(DashboardViewType.ALLREQUESTS)) {
				HttpSession session = ServletActionContext.getRequest().getSession();
				if(StringUtils.isNotBlank(historicalTab)){
				  session.setAttribute(ALOCConstants.HISTORICAL_TAB, historicalTab);
				}else{
					 session.removeAttribute(ALOCConstants.HISTORICAL_TAB);
				}
				return ALOCConstants.TAXONOMY;
			}
			else if (getDashboardViewType().equals(DashboardViewType.TREASURYBIDPROCESS)) {
				return ALOCConstants.OPENTREASURYBIDMEMO;
			}
		}
		boolean busApprover= false;
		List<String> userRoles = UserContext.getContext().getuserDetails().getRoles();
		if(userRoles.contains(UserRole.Approver.getName())) {
			busApprover = true;
		}
		if (UserContext.getContext().getuserDetails().getUserId() != null
				&& requestorSSO != null
				&& requestorSSO.equalsIgnoreCase(UserContext.getContext().getuserDetails().getUserId())) {
			busApprover = false;
		}
		if (StringUtils.isNotBlank(getStageName())) {
			switch(WorkflowStage.fromName(getStageName())) {
			case DRAFT:
			case REQUESTER:
				resultName = ALOCConstants.OPENREQUESTOR;
				break;
			case BUSINESSAPPROVER:
				if(busApprover){
					resultName = ALOCConstants.OPENBUSINESSAPPROVER;
				}else{
					resultName=ALOCConstants.REREQUEST;
				}
				break;
			case TREASURYANALYST:
				resultName = ALOCConstants.OPENTREASURYANALYST;
				break;
			case TREASURYAPPROVER:
				resultName = ALOCConstants.OPENTREASURYAPPROVER;
				break;
			case NEWMEMO:
			case TREASURYBIDMEMO:
				resultName = ALOCConstants.OPENTREASURYBIDMEMO;
				break;
			case TRESEDIT:
				resultName = ALOCConstants.OPENPOSTAWARD;
				break;
			case TREASURYBIDREPLY:
				resultName = ALOCConstants.OPENTREASURYBIDREPLY;
				break;
			case TREASURYBIDISSUE:
			case BANKISUE:
				resultName = ALOCConstants.ISSUER;
				break;
			case EVLREPLY:
				resultName=ALOCConstants.TREASURYBIDAWARD;
				break;
			case COMPLETE:
				resultName=ALOCConstants.CLOSURE;
				break;
			case REREQUEST:
			case REQUEST:
				resultName=ALOCConstants.REREQUEST;

			}
		}
		return resultName;
	}

	/**
	 * This is used to get the request Id.
	 * @return the requestId
	 */
	public BigInteger getRequestId() {
		return requestId;
	}

	/**
	 * This is used to set the request Id.
	 * @param requestId the requestId to set
	 */
	public void setRequestId(BigInteger requestId) {
		this.requestId = requestId;
	}

	/**
	 * This is used to get the stage id.
	 * @return the stage
	 */
	public Integer getStage() {
		return (stage != null) ? stage.getId() : WorkflowStage.DRAFT.getId();
	}

	/**
	 * This is used to set the stage id.
	 * @param stage the stage to set
	 */
	public void setStage(Integer stage) {
		if(stage != null) {
			this.stage = WorkflowStage.fromId(stage);
		}
	}

	/**
	 * This is used to get the stage name.
	 * @return the stageName
	 */
	public String getStageName() {
		return stageName;
	}

	/**
	 * This is used to set the stage name.
	 * @param stageName the stageName to set
	 */
	public void setStageName(String stageName) {
		this.stageName = stageName;
	}

	/**
	 * This is used to get the dashboardViewType.
	 * @return the dashboardViewType
	 */
	public DashboardViewType getDashboardViewType() {
		return dashboardViewType;
	}

	/**
	 * This is used to set the dashboardViewType.
	 * @param dashboardViewType the dashboardViewType to set
	 */
	public void setDashboardViewType(DashboardViewType dashboardViewType) {
		this.dashboardViewType = dashboardViewType;
	}
	
	/**
	 * This is used to get the requestorSSO.
	 * @return the requestorSSO
	 */
	public String getRequestorSSO() {
		return requestorSSO;
	}

	/**
	 * This is used to set the requestorSSO.
	 * @param requestorSSO the requestorSSO to set
	 */
	public void setRequestorSSO(String requestorSSO) {
		this.requestorSSO = requestorSSO;
	}
	
	/**
	 * This is used to get the historicalTab.
	 * @return the historicalTab
	 */
	public String getHistoricalTab() {
		return historicalTab;
	}
	
	/**
	 * This is used to set the historicalTab.
	 * @param historicalTab the historicalTab to set
	 */
	public void setHistoricalTab(String historicalTab) {
		this.historicalTab = historicalTab;
	}


}
