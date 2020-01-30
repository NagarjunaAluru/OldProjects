/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: RecordsRetentionMgmtAction.java
 * Purpose: RecordsRetentionMgmtAction used for all records Retention management related functionality
 */

package com.ge.aloc.action.admin;



import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.manager.admin.IRecordsRetentionMgmtManager;
import com.ge.aloc.model.RecordRetention;
import com.hydus.hwf.exceptions.HWFServiceException;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.ValidationWorkflowAware;

/**
 * @author madhusudhan.gosula
 *
 */
public class RecordsRetentionMgmtAction extends ActionSupport implements  ValidationWorkflowAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4720308151566613506L;

	private IRecordsRetentionMgmtManager recordsRetentionManager;
	private RecordRetention recordRetention;
	private String geRecipient;
	private String recipientSelection;
	private String viewRetention;

	/**
	 * This method is used to open RecordsRetentionManagement form
	 * @return
	 * @throws HWFServiceException
	 */
	public String open() throws HWFServiceException{
		recordRetention = recordsRetentionManager.open();
		if(recordRetention !=null)
		{

			ActionContext.getContext().getSession().put(ALOCConstants.RETENTIONVALUES, recordRetention);
			if(recordRetention.getStatus() == null || recordRetention.getStatus().trim().equals(ALOCConstants.EMPTY_STRING) ||
					recordRetention.getStatus().equalsIgnoreCase(ALOCConstants.REJECT) ||
					recordRetention.getStatus().equalsIgnoreCase(ALOCConstants.APPROVE))
			{
				return ALOCConstants.RECORDSRETENTION;
			}
			else {return ALOCConstants.RECORDSRETENTIONAPPR;}
		}
		return ALOCConstants.RECORDSRETENTION;
	}

	/**
	 * This method is used to open RecordsPurgeReport
	 * @return
	 * @throws HWFServiceException
	 */
	public String openRecordsPurgeReport() throws HWFServiceException{
		recordRetention = recordsRetentionManager.openRecordsPurgeReport();
		if(recordRetention !=null)
		{
			ActionContext.getContext().getSession().put(ALOCConstants.RETENTIONVALUES, recordRetention);
		}
		return ALOCConstants.OPENPERGEREPORT;
	}

	/**
	 * This method is used to modify RecordsRetentionManagement
	 * @return
	 * @throws HWFServiceException
	 */
	public String modify() throws HWFServiceException{
		recordRetention = recordsRetentionManager.modify(recordRetention);
		if(viewRetention !=null && viewRetention.equals(ALOCConstants.YES))
		{
			return ALOCConstants.RECORDSRETENTION;
		}
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute(ALOCConstants.PORTAL_SUCCESSMSG,ALOCConstants.RETENTION_UPDATE_SUCCESS);
		return ALOCConstants.TREASURYADMINPORTAL;
	}

	/**
	 * This method is used to fetch fullAuditLog
	 * @return
	 * @throws HWFServiceException
	 */
	public String fullAuditLog() throws HWFServiceException{
		recordRetention = (RecordRetention)ActionContext.getContext().getSession().get(ALOCConstants.RETENTIONVALUES);
		return SUCCESS;
	}

	/**
	 * This method is used to submit RecordsRetentionManagement
	 * @return
	 * @throws HWFServiceException
	 */
	public String submit() throws HWFServiceException{
		try{
			recordRetention = recordsRetentionManager.submit(recordRetention);
		}catch(HWFServiceException hse)
		{						
			addActionError(hse.getReason());
			recordRetention = (RecordRetention)ActionContext.getContext().getSession().get(ALOCConstants.RETENTIONVALUES);
			return ALOCConstants.RECORDSRETENTION;
		}
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute(ALOCConstants.PORTAL_SUCCESSMSG,ALOCConstants.RETENTION_UPDATE_SUCCESS);
		return ALOCConstants.TREASURYADMINPORTAL;
	}

	/**
	 * This method is used to Send RecordsRetentionManagement
	 * @return
	 * @throws HWFServiceException
	 */
	public String sendRecordRetentionMgmt() throws HWFServiceException{
		recordRetention = recordsRetentionManager.sendRecordRetentionMgmt(recordRetention);
		return ALOCConstants.TREASURYADMINPORTAL;
	}
	/**
	 * cancel is used to navigate the admin portel page.
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
		RecordRetention recordRetentionAuditLogs = new RecordRetention();
		recordRetentionAuditLogs = (RecordRetention)ActionContext.getContext().getSession().get(ALOCConstants.RETENTIONVALUES);
		if(recordRetentionAuditLogs.getRecordRetentionAuditLogs() !=null){
			recordRetention.setRecordRetentionAuditLogs(recordRetentionAuditLogs.getRecordRetentionAuditLogs());
		}
		return INPUT;
	}


	/**
	 * This is used to get RecordRetention object
	 * @return the recordRetention
	 */
	public RecordRetention getRecordRetention() {
		return recordRetention;
	}

	/**
	 * This is used to set RecordRetention object
	 * @param recordRetention the recordRetention to set
	 */
	public void setRecordRetention(RecordRetention recordRetention) {
		this.recordRetention = recordRetention;
	}

	/**
	 * This is used to get RecordsRetentionManager object.
	 * @return the recordsRetentionManager
	 */
	public IRecordsRetentionMgmtManager getRecordsRetentionManager() {
		return recordsRetentionManager;
	}

	/**
	 * This is used to create RecordsRetentionManager instance object.
	 * @param recordsRetentionManager the recordsRetentionManager to set
	 */
	public void setRecordsRetentionManager(
			IRecordsRetentionMgmtManager recordsRetentionManager) {
		this.recordsRetentionManager = recordsRetentionManager;
	}

	/**
	 * This is used to get GeRecipient.
	 * @return the geRecipient
	 */
	public String getGeRecipient() {
		return geRecipient;
	}

	/**
	 * This is used to set GeRecipient. 
	 * @param geRecipient the geRecipient to set
	 */
	public void setGeRecipient(String geRecipient) {
		this.geRecipient = geRecipient;
	}

	/**
	 * This is used to get recipient selection.
	 * @return recipientSelection
	 */
	public String getRecipientSelection() {
		return recipientSelection;
	}

	/**
	 * This is used to set recipient selection.
	 * @param recipientSelection the recipientSelection to set
	 */
	public void setRecipientSelection(String recipientSelection) {
		this.recipientSelection = recipientSelection;
	}

	/**
	 * This is used to get ViewRetention
	 * @return ViewRetention
	 */
	public String getViewRetention() {
		return viewRetention;
	}

	/**
	 * This is used to set view retention
	 * @param viewRetention the viewRetention to set
	 */
	public void setViewRetention(String viewRetention) {
		this.viewRetention = viewRetention;
	}

}
