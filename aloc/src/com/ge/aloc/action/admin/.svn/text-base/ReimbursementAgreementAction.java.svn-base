/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ReimbursementAgreementAction.java
 * Purpose: ReimbursementAgreementAction used for Reimebursement Agreement Management operations.
 */
package com.ge.aloc.action.admin;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.manager.admin.IReimbursementAgreementMgmtManager;
import com.ge.aloc.model.NameValue;
import com.ge.aloc.model.ReimburseList;
import com.ge.aloc.model.Reimbursement;
import com.ge.aloc.model.Reimbursement.Transactions;
import com.ge.aloc.model.ReimbursementAgreement;
import com.hydus.hwf.exceptions.HWFServiceException;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.ValidationWorkflowAware;

/**
 * @author rajeswari.guthi
 * 
 */
public class ReimbursementAgreementAction extends ActionSupport implements ValidationWorkflowAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2370863206582347416L;

	private IReimbursementAgreementMgmtManager reimbursementAgreementMgmtManager;

	private Reimbursement reimbursement;

	private String addOrEditSelection = "";

	private String errorMessageData = "";

	private boolean includeNoPage = false;
	
	private List<String> siteNamesList = new ArrayList<String>();

	/**
	 * This is used to get the add or edit selection
	 * @return the addOrEditSelection
	 */
	public String getAddOrEditSelection() {
		return addOrEditSelection;
	}


	/**
	 * This is used to set add or edit selection
	 * @param addOrEditSelection the addOrEditSelection to set
	 */
	public void setAddOrEditSelection(String addOrEditSelection) {
		this.addOrEditSelection = addOrEditSelection;
	}


	/**
	 * This method to open the agreement 
	 * @return
	 * @throws HWFServiceException
	 */	
	public String openReimbursementAgreement() throws HWFServiceException{	
		ActionContext.getContext().getSession().put(ALOCConstants.REIMBURSEMENTDATA, null);
		ActionContext.getContext().getSession().put(ALOCConstants.AGREEMENTLIST,null);
		return SUCCESS; 
	}

	/**
	 * This method to open the agreement 
	 * @return
	 * @throws HWFServiceException
	 */
	public String openReimbursementPage() throws HWFServiceException{			
		return ALOCConstants.OPEN_REIMBURSEMENT_PAGE;
	}

	/**
	 *This method is used to create Or Update ReimbursementAgreement form. 
	 * @return
	 * @throws HWFServiceException
	 */
	public String createOrUpdateAgreement() throws HWFServiceException {	
		try{		
			if(reimbursement==null){ 
				reimbursement = (Reimbursement)ActionContext.getContext().getSession().get(ALOCConstants.REIMBURSEMENTDATA);
				if(reimbursement.getSiteNames() != null)
					reimbursement.setDefaultOpcode(ALOCConstants.DEFAULT_OPCODE);					
			}
			if(reimbursement.getReimbursementAgreement().isDeafultAgreement()==false)
			{
				reimbursement.getReimbursementAgreement().setDeafultAgreementType(null);
			}
			reimbursement = reimbursementAgreementMgmtManager.createOrUpdateReimbursementAgreement(reimbursement);				
			if(reimbursement.getSiteNames()!=null && !reimbursement.getSiteNames().isEmpty())
			{				
				errorMessageData = ALOCConstants.EFFECTED_SITES+getFormattedSiteNames(reimbursement.getSiteNames());
				siteNamesList = getFormattedSiteNames(reimbursement.getSiteNames());
				ActionContext.getContext().getSession().put(ALOCConstants.REIMBURSEMENTDATA, reimbursement);
				return INPUT;
			}
			else if(reimbursement.getTransactions() != null && !reimbursement.getTransactions().isEmpty())
			{
				List<Integer> transactionList = new ArrayList<Integer>();
				for(Transactions transactions :reimbursement.getTransactions())
				{
					transactionList.add(transactions.getRecords());
				}
				addActionMessage(ALOCConstants.EFFECTED_TRANCATIONS+transactionList.toString());		
				ActionContext.getContext().getSession().put(ALOCConstants.REIMBURSEMENTDATA, reimbursement);
				return INPUT;
			}			
			if(addOrEditSelection.equalsIgnoreCase(ALOCConstants.ADD)){
				List<NameValue> reimbursementList = getReimbusrementAgreementList(reimbursement);
				ActionContext.getContext().getSession().put(ALOCConstants.AGREEMENTLIST, reimbursementList);
				ActionContext.getContext().getSession().put(ALOCConstants.REIMBURSEMENTDATA, reimbursement);
			}
		}catch(HWFServiceException hse){	
			addActionMessage(hse.getReason());						
			return INPUT;
		}
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute(ALOCConstants.PORTAL_SUCCESSMSG,ALOCConstants.REIMBURSEMENT_AGMT_SUCCESS_MSG);
		return SUCCESS;			
	}
	
	/**
	 * 
	 * This method is used to retrieve ReimbursementAgreement details from the DB. 
	 * @return
	 * @throws HWFServiceException
	 * @throws IOException
	 */
	public String loadReimbursementAgreementDetails() throws HWFServiceException{
		try{				
			HttpServletRequest request = ServletActionContext.getRequest();						
			addOrEditSelection = (String)request.getParameter(ALOCConstants.ADD_OR_EDIT_SELECTION);
			reimbursement = reimbursementAgreementMgmtManager.loadReimbursementAgreementDetailsById(reimbursement);	
			includeNoPage= false;
		}catch(HWFServiceException hse){		
			addActionMessage(hse.getReason());							
		}
		return SUCCESS;	
	}

	/**
	 * This method is used to load roles from DB
	 * @return
	 * @throws HWFServiceException
	 */
	@SuppressWarnings("unchecked")
	public List<NameValue> getReimbursementList() throws HWFServiceException{			
		List<NameValue> reimbursementList = (List<NameValue>) ActionContext.getContext().getSession().get(ALOCConstants.AGREEMENTLIST);			
		if(addOrEditSelection.equalsIgnoreCase(ALOCConstants.EMPTY_STRING)  && (reimbursementList == null || reimbursementList.isEmpty())) {
			reimbursement = new Reimbursement();
			reimbursement.setReimbursementAgreement(new ReimbursementAgreement());
			reimbursement = reimbursementAgreementMgmtManager.loadReimbursementAgreementList(reimbursement);
			reimbursementList = getReimbusrementAgreementList(reimbursement);						
			ActionContext.getContext().getSession().put(ALOCConstants.AGREEMENTLIST, reimbursementList);
		}
		return reimbursementList;
	}
	
	/**
	 * This Method is used to format the sitenames for display
	 * @param siteNameList
	 * @return
	 */
	private List<String> getFormattedSiteNames(List<String> siteNamesList) {
		List<String> siteNames = new ArrayList<String>();
		int actualWidth = ALOCConstants.ROW_SEVENTYFIVE;
		for(int i=0; i< siteNamesList.size(); i++) {
			int siteNameWidth = siteNamesList.get(i).length();
			if(siteNames.size() > 0) {
				int previousRowLength = siteNames.get(siteNames.size()-1).length();
				if((siteNameWidth+previousRowLength) < actualWidth) {
					String previousRow = siteNames.get(siteNames.size()-1);
					previousRow = previousRow+ALOCConstants.COMMA_SPACE+ siteNamesList.get(i);
					siteNames.remove(siteNames.size()-1);
					siteNames.add(previousRow);
				} else {
					siteNames.add(siteNamesList.get(i));
				}
			} else {
				if(siteNameWidth < actualWidth) {
					siteNames.add(ALOCConstants.EFFECTED_SITES + siteNamesList.get(i));
				}
			}
		}
		return siteNames;
	}

	/**
	 * This is used to create reimbursementAgreementMgmtManager instance object.
	 * @return the reimbursementAgreementMgmtManager
	 */
	public IReimbursementAgreementMgmtManager getReimbursementAgreementMgmtManager() {
		return reimbursementAgreementMgmtManager;
	}

	/**
	 * This is used to create reimbursementAgreementMgmtManager instance object.
	 * @param reimbursementAgreementMgmtManager the reimbursementAgreementMgmtManager to set
	 */
	public void setReimbursementAgreementMgmtManager(
			IReimbursementAgreementMgmtManager reimbursementAgreementMgmtManager) {
		this.reimbursementAgreementMgmtManager = reimbursementAgreementMgmtManager;
	}

	/**
	 * This is used to get the reimbursement object.
	 * @return the reimbursement
	 */
	public Reimbursement getReimbursement() {
		return reimbursement;
	}

	/**
	 *This is used to set the reimbursement object.
	 * @param reimbursement the reimbursement to set
	 */
	public void setReimbursement(Reimbursement reimbursement) {
		this.reimbursement = reimbursement;
	}


	/**
	 * This is used to get the reimbursementAgreementsList
	 * return List<NameValue>
	 */
	private List<NameValue> getReimbusrementAgreementList(Reimbursement reimbursement){
		List<NameValue> reimbursementList = new ArrayList<NameValue>();
		if(reimbursement.getReimburseLists()!= null) {
			for(ReimburseList agreementName : reimbursement.getReimburseLists()) {
				NameValue nameValue = new NameValue();
				nameValue.setID(new BigInteger(agreementName.getReimburseAgreementId().toString()));
				nameValue.setName(agreementName.getReimburseAgreementName());
				reimbursementList.add(nameValue);
			} 
		}
		return reimbursementList;
	}

	/**
	 * @return the errorMessageData
	 */
	public String getErrorMessageData() {
		return errorMessageData;
	}


	/**
	 * @param errorMessageData the errorMessageData to set
	 */
	public void setErrorMessageData(String errorMessageData) {
		this.errorMessageData = errorMessageData;
	}


	/**
	 * @return the includePage
	 */
	public boolean isIncludeNoPage() {
		return includeNoPage;
	}


	/**
	 * @param includePage the includeNoPage to set
	 */
	public void setIncludeNoPage(boolean includeNoPage) {
		this.includeNoPage = includeNoPage;
	}
	
	/**
	 * @return the siteNamesList
	 */
	public List<String> getSiteNamesList() {
		return siteNamesList;
	}


	/**
	 * @param siteNamesList the siteNamesList to set
	 */
	public void setSiteNamesList(List<String> siteNamesList) {
		this.siteNamesList = siteNamesList;
	}

	/**
	 * This is used to do the validation and return to the input page.
	 */	
	public String getInputResultName() { 
		includeNoPage = true;
		return INPUT;
	}
}