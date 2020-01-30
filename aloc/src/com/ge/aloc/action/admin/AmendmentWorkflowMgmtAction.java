/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: AmendmentWorkflowMgmtAction.java
 * Purpose: AmendmentWorkflowMgmtAction used to define the amendment amount through Admin.
 */

package com.ge.aloc.action.admin;

import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.manager.admin.IAmendmentWorkflowMgmtManager;
import com.ge.aloc.model.AmendmentWorkflowMgmt;
import com.hydus.hwf.exceptions.HWFServiceException;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.ValidationWorkflowAware;

/**
 * @author madhusudhan.gosula
 *
 */
public class AmendmentWorkflowMgmtAction extends ActionSupport implements ValidationWorkflowAware{

	private static final long serialVersionUID = 4720308151566613506L;

	private IAmendmentWorkflowMgmtManager amendmentWorkflowManager;
	private AmendmentWorkflowMgmt amendmentWorkflow;

	/**
	 * This is used to open the amendment workflow management with amendment amount.
	 * @return
	 * @throws HWFServiceException
	 */
	public String open() throws HWFServiceException{
		amendmentWorkflow = amendmentWorkflowManager.open();
		ActionContext.getContext().getSession().put(ALOCConstants.AMDAMOUNT, amendmentWorkflow);
		return ALOCConstants.AMENDMENTWORKFLOWMGT;
	}

	/**
	 * This method is used to fetch fullAuditLog
	 * @return
	 * @throws HWFServiceException
	 */
	public String fullAuditLog() throws HWFServiceException{
		amendmentWorkflow = (AmendmentWorkflowMgmt)ActionContext.getContext().getSession().get(ALOCConstants.AMDAMOUNT);
		return SUCCESS;
	}

	/**
	 * This method is used for back
	 * @return
	 * @throws HWFServiceException
	 */
	public String back() throws HWFServiceException{
		amendmentWorkflow = (AmendmentWorkflowMgmt)ActionContext.getContext().getSession().get(ALOCConstants.AMDAMOUNT);
		return SUCCESS;
	}
	/**
	 * save is used to change the amendment amount
	 * @return
	 * @throws HWFServiceException
	 */
	public String save() throws HWFServiceException{
		amendmentWorkflow = amendmentWorkflowManager.save(amendmentWorkflow);
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute(ALOCConstants.PORTAL_SUCCESSMSG,ALOCConstants.AMENDMENT_SUCCESS_MSG);
		return SUCCESS;
	}

	/**
	 * cancel is used to navigate the admin portal page.
	 * @return
	 * @throws HWFServiceException
	 */
	public String cancel() throws HWFServiceException{
		return SUCCESS;
	}

	/**
	 * This method decides the page to display on validation error conditions
	 */
	public String getInputResultName() {
		AmendmentWorkflowMgmt auditLogs  = new AmendmentWorkflowMgmt();
		auditLogs =(AmendmentWorkflowMgmt)ActionContext.getContext().getSession().get(ALOCConstants.AMDAMOUNT); 
		amendmentWorkflow.setAuditLogs(auditLogs.getAuditLogs());
		return INPUT;
	}


	/**
	 * This method is used to get Amendment work flow manager
	 * @return the amendmentWorkflowManager
	 */
	public IAmendmentWorkflowMgmtManager getAmendmentWorkflowManager() {
		return amendmentWorkflowManager;
	}


	/**
	 * This method is used to set Amendment work flow Manager
	 * @param amendmentWorkflowManager the amendmentWorkflowManager to set
	 */
	public void setAmendmentWorkflowManager(
			IAmendmentWorkflowMgmtManager amendmentWorkflowManager) {
		this.amendmentWorkflowManager = amendmentWorkflowManager;
	}


	/**
	 * This method is used to get Amendment Work flow
	 * @return the amendmentWorkflow
	 */
	public AmendmentWorkflowMgmt getAmendmentWorkflow() {
		return amendmentWorkflow;
	}


	/**
	 * This method is used to set Amendment work flow
	 * @param amendmentWorkflow the amendmentWorkflow to set
	 */
	public void setAmendmentWorkflow(AmendmentWorkflowMgmt amendmentWorkflow) {
		this.amendmentWorkflow = amendmentWorkflow;
	}
}
