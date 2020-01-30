/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: SuretyNameMgmtAction.java
 * Purpose: SuretyNameMgmtAction used for maintaining Surety Names.
 *
 */
package com.ge.aloc.action.admin;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.manager.admin.ISuretyNameMgmtManager;
import com.ge.aloc.model.SuretyMaster;
import com.ge.aloc.model.SuretyMasterCollection;
import com.hydus.hwf.exceptions.HWFServiceException;
import com.hydus.hwf.util.StringUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.ValidationWorkflowAware;

/**
 * 
 * @author Rajat-Hydus
 * 
 */
public class SuretyNameMgmtAction extends ActionSupport implements ValidationWorkflowAware{

	private static final long serialVersionUID = -3897622535348563380L;
	private ISuretyNameMgmtManager suretyNameManager;
	private SuretyMasterCollection  suretyList;
	private SuretyMaster  suretyMaster;
	private String suretyNameLength;
	private Map<String, Object> sessionValues = ActionContext.getContext().getSession();
	protected boolean errorSurety;

	/**
	 * Method to get the available SuretyCompany Names
	 * @return
	 * @throws HWFServiceException
	 */
	public String openSurety() throws HWFServiceException {
		suretyList = suretyNameManager.open();
		sessionValues.put(ALOCConstants.SURETYNAMES, suretyList);
		errorSurety = false;
		
		return ALOCConstants.GETSURETYSUCCESS;
	}

	/**
	 * Method to add the new SuretyCompany Name
	 * @return
	 * @throws HWFServiceException
	 */
	public String addSurety() throws HWFServiceException {
		errorSurety = false;
		suretyNameLength=ALOCConstants.SURETYNAME_LENGTH;
		return ALOCConstants.ADDSURETYSUCCESS;
	}

	/**
	 * Method to update the selected SuretyCompany Name
	 * @return
	 * @throws HWFServiceException
	 */
	public String editSurety() throws HWFServiceException {
		errorSurety = false;
		suretyList = (SuretyMasterCollection)sessionValues.get(ALOCConstants.SURETYNAMES);
		HttpServletRequest request = ServletActionContext.getRequest();
		String curIndex = request.getParameter(ALOCConstants.CURINDEX);
		SuretyMaster suretyMaster = suretyList.getSuretyMasters().get(Integer.valueOf(curIndex));
		suretyNameLength= (Integer.valueOf(ALOCConstants.SURETY_NAME_LENGTH-suretyMaster.getSuretyName().length())).toString();
		return ALOCConstants.ADDSURETYSUCCESS;
	}

	/**
	 * This method decides the page to display on validation error conditions
	 */
	public String getInputResultName() {
		if(StringUtils.isBlank(suretyMaster.getSuretyName())){suretyNameLength=ALOCConstants.SURETYNAME_LENGTH;}
		else{suretyNameLength = (Integer.valueOf(ALOCConstants.SURETY_NAME_LENGTH-suretyMaster.getSuretyName().length())).toString();}
		errorSurety=true;
		return INPUT;
	}

	/**
	 * Method to add or update given SuretyCompany Name
	 * @return
	 * @throws HWFServiceException
	 */

	public String updateSurety() throws HWFServiceException{
		suretyNameManager.update(suretyMaster);
		suretyList = suretyNameManager.open();
		sessionValues.put(ALOCConstants.SURETYNAMES, suretyList);
		errorSurety = false;
		return ALOCConstants.UPDATESURETYSUCCESS;
	}

	/**
	 * Method to cancel the SuretyCompany Name changes
	 * @return
	 * @throws HWFServiceException
	 */
	public String cancelSurety() throws HWFServiceException {
		suretyList = (SuretyMasterCollection)sessionValues.get(ALOCConstants.SURETYNAMES);
		HttpServletRequest request = ServletActionContext.getRequest();
		String suretyId = request.getParameter(ALOCConstants.SURETYID);
		List<SuretyMaster> suretyMasterList = suretyList.getSuretyMasters();
		suretyMaster = suretyNameManager.cancel(suretyMasterList,suretyId);
		errorSurety = false;
		return ALOCConstants.UPDATESURETYSUCCESS;
	}

	/**
	 * This method is used to create the suretyNameManager instance object.
	 * @return the suretyNameManager
	 */
	public ISuretyNameMgmtManager getSuretyNameManager() {
		return suretyNameManager;
	}

	/**
	 * This method is used to create the suretyNameManager instance object.
	 * @param suretyNameManager the suretyNameManager to set
	 */
	public void setSuretyNameManager(ISuretyNameMgmtManager suretyNameManager) {
		this.suretyNameManager = suretyNameManager;
	}

	/**
	 * This method is used to create the suretyMaster instance object.
	 * @return the suretyMaster
	 */
	public SuretyMaster getSuretyMaster() {
		return suretyMaster;
	}

	/**
	 * This method is used to create the suretyMaster instance object.
	 * @param suretyMaster the suretyMaster to set
	 */
	public void setSuretyMaster(SuretyMaster suretyMaster) {
		this.suretyMaster = suretyMaster;
	}

	/**
	 * This method is used to get the surety list.
	 * @return the suretyList
	 */
	public SuretyMasterCollection getSuretyList() {
		return suretyList;
	}

	/**
	 * This method is used to set the surety list.
	 * @param suretyList the suretyList to set
	 */
	public void setSuretyList(SuretyMasterCollection suretyList) {
		this.suretyList = suretyList;
	}

	/**
	 * This method is used verify error surety.
	 * @return the errorSurety
	 */
	public boolean isErrorSurety() {
		return errorSurety;
	}

	/**
	 * This method is used verify error surety and set true or false value.
	 * @param errorSurety the errorSurety to set
	 */
	public void setErrorSurety(boolean errorSurety) {
		this.errorSurety = errorSurety;
	}

	/**
	 * This method is used to get the session object instance
	 * @return the sessionValues
	 */
	public Map<String, Object> getSessionValues() {
		return sessionValues;
	}

	/**
	 * This method is used to set the session object instance
	 * @param sessionValues the sessionValues to set
	 */
	public void setSessionValues(Map<String, Object> sessionValues) {
		this.sessionValues = sessionValues;
	}
	/**
	 * This method is used to get the selected suretyNameLength value
	 * @return the suretyNameLength
	 */
	public String getSuretyNameLength() {
		return suretyNameLength;
	}

	/**
	 * This method is used to set the selected suretyNameLength value
	 * @param suretyNameLength the suretyNameLength to set
	 */
	public void setSuretyNameLength(String suretyNameLength) {
		this.suretyNameLength = suretyNameLength;
	}
}
