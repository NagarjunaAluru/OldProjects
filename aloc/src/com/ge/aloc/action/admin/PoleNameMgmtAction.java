/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: PoleNameMgmtAction.java
 * Purpose: PoleNameMgmtAction used for maintaining Pole Names.
 *
 */
package com.ge.aloc.action.admin;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.ge.aloc.ALOCContext;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.manager.admin.IPoleNameMgmtManager;
import com.ge.aloc.model.MDM.Country;
import com.ge.aloc.model.PoleNameList;
import com.ge.aloc.model.PoleNameManagement;
import com.hydus.hwf.exceptions.HWFServiceException;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.ValidationWorkflowAware;

/**
 * @author Rajat-Hydus
 * 
 */
public class PoleNameMgmtAction extends ActionSupport implements ValidationWorkflowAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1601358822155150669L;
	private IPoleNameMgmtManager poleNameManager;
	private Map<Integer, PoleNameManagement> poleNameManagements;
	private Map<String, String> selectedCountries;
	private PoleNameManagement  poleNameMgmt;
	private String selectedCountriesCodes;
	protected boolean errorPole;

	/**
	 * Method to get the available Pole Names
	 * @return
	 * @throws HWFServiceException
	 */
	public String openPole() throws HWFServiceException {
		PoleNameList poleList = poleNameManager.open();
		poleNameManagements = new LinkedHashMap<Integer, PoleNameManagement>();
		for(PoleNameManagement pnm : poleList.getPoleNameManagements()) {
			poleNameManagements.put(pnm.getPoleId(), pnm);
		}
		ServletActionContext.getRequest().getSession().setAttribute(ALOCConstants.POLENAMES, poleNameManagements);
		errorPole = false;
		return ALOCConstants.GETPOLESUCCESS;
	}

	/**
	 * Method to add the new Pole Name
	 * @return
	 * @throws HWFServiceException
	 */
	public String addPole() throws HWFServiceException {
		errorPole = false;
		return ALOCConstants.ADDPOLESUCCESS;
	}

	/**
	 * Method to edit the selected Pole Name
	 * @return
	 * @throws HWFServiceException
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public String editPole() throws HWFServiceException, IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		poleNameManagements = (Map<Integer, PoleNameManagement>) ServletActionContext.getRequest().getSession().getAttribute(ALOCConstants.POLENAMES);
		String poleId = request.getParameter(ALOCConstants.POLEID);
		poleNameMgmt = poleNameManagements.get(Integer.valueOf(poleId));
		selectedCountries = poleNameManager.getAvailableCountries(poleNameMgmt);
		errorPole = false;
		return ALOCConstants.ADDPOLESUCCESS;
	}

	/**
	 * Method to add or update given Pole Name
	 * @return
	 * @throws HWFServiceException
	 * @throws IOException
	 */

	@SuppressWarnings("unchecked")
	public String updatePole() throws HWFServiceException, IOException {
		try
		{
			poleNameManagements = (Map<Integer, PoleNameManagement>) ServletActionContext.getRequest().getSession().getAttribute(ALOCConstants.POLENAMES);
			PoleNameManagement updatedPoleNameMgmt = poleNameManager.update(poleNameMgmt,selectedCountriesCodes);
			if(poleNameMgmt.getPoleId() != null && !poleNameMgmt.getPoleId().equals(ALOCConstants.EMPTY_STRING))
				poleNameManagements.remove(poleNameMgmt.getPoleId());	
			poleNameMgmt = updatedPoleNameMgmt;
			poleNameManagements.put(updatedPoleNameMgmt.getPoleId(), updatedPoleNameMgmt);
			ServletActionContext.getRequest().getSession().setAttribute(ALOCConstants.POLENAMES, poleNameManagements);
			errorPole = false;
		}catch(HWFServiceException hse){
			errorPole = true;
			addActionError(hse.getReason());
			return INPUT;
		}
		return ALOCConstants.UPDATEPOLESUCCESS;
	}

	/**
	 * Method to cancel the Pole Name changes
	 * @return
	 * @throws HWFServiceException
	 */
	@SuppressWarnings("unchecked")
	public String cancelPole() throws HWFServiceException {
		poleNameManagements = (Map<Integer, PoleNameManagement>) ServletActionContext.getRequest().getSession().getAttribute(ALOCConstants.POLENAMES);
		HttpServletRequest request = ServletActionContext.getRequest();
		String poleId = request.getParameter(ALOCConstants.POLEID);
		if(poleId!=null && !(poleId.equals(ALOCConstants.EMPTY_STRING))){
			poleNameMgmt = poleNameManagements.get(Integer.valueOf(poleId));
		}
		errorPole = false;
		return ALOCConstants.UPDATEPOLESUCCESS;
	}	

	/**
	 * Method to get the available countries from MDM
	 * @return the availableCountries
	 */
	public Map<String, String> getAvailableCountries() {
		Map<String, String> availableCountries = new HashMap<String, String>();
		List<Country> MDMCountries = ALOCContext.getMasterDataFactory().getCountries();
		if(MDMCountries !=null && !MDMCountries.isEmpty())
		{
			Iterator<Country> MDMCountriesItr = MDMCountries.iterator();
			Country MDMCountry = null;
			while(MDMCountriesItr.hasNext()) {
				MDMCountry = MDMCountriesItr.next();
				availableCountries.put(MDMCountry.getCountryCode(),MDMCountry.getCountryName());
			}
		}
		return availableCountries;
	}
	/**
	 * This is used to create the poleNameManager instance object.
	 * @return the poleNameManager
	 */
	public IPoleNameMgmtManager getPoleNameManager() {
		return poleNameManager;
	}

	/**
	 * This is used to create the poleNameManager instance object.
	 * @param poleNameManager the poleNameManager to set
	 */
	public void setPoleNameManager(IPoleNameMgmtManager poleNameManager) {
		this.poleNameManager = poleNameManager;
	}

	/**
	 * This is used to get the poleNameMgmt value
	 * @return the poleNameMgmt
	 */
	public PoleNameManagement getPoleNameMgmt() {
		return poleNameMgmt;
	}
	/**
	 * This is used to set the poleNameMgmt value
	 * @param poleNameMgmt the poleNameMgmt to set
	 */
	public void setPoleNameMgmt(PoleNameManagement poleNameMgmt) {
		this.poleNameMgmt = poleNameMgmt;
	}

	/**
	 * This is used to get the selected countries List.
	 * @return the selectedCountries
	 */
	public Map<String, String> getSelectedCountries() {
		return selectedCountries;
	}


	/**
	 * This is used to set the selected countries List.
	 * @param selectedCountries the selectedCountries to set
	 */
	public void setSelectedCountries(Map<String, String> selectedCountries) {
		this.selectedCountries = selectedCountries;
	}

	/**
	 * This method decides the page to display on validation error conditions
	 */
	public String getInputResultName() {
		errorPole=true;
		return INPUT;
	}

	/**
	 * This is used to verify whether any error on Pole.
	 * @return the errorPole
	 */
	public boolean isErrorPole() {
		return errorPole;
	}


	/**
	 * This is used to verify whether any error on Pole.
	 * @param errorPole the errorPole to set
	 */
	public void setErrorPole(boolean errorPole) {
		this.errorPole = errorPole;
	}

	/**
	 * This is used to get the selectedCountriesCodes
	 * @return the selectedCountriesCodes
	 */
	public String getSelectedCountriesCodes() {
		return selectedCountriesCodes;
	}

	/**
	 * This is used to set the selectedCountriesCodes
	 * @param selectedCountriesCodes the selectedCountriesCodes to set
	 */
	public void setSelectedCountriesCodes(String selectedCountriesCodes) {
		this.selectedCountriesCodes = selectedCountriesCodes;
	}
	
	/**
	 * This is used to get the poleNameManagements value
	 * @return the poleNameManagements
	 */
	public Map<Integer, PoleNameManagement> getPoleNameManagements() {
		return poleNameManagements;
	}

	/**
	 * This is used to set the poleNameManagements value
	 * @param poleNameManagements the poleNameManagements to set
	 */
	public void setPoleNameManagements(
			Map<Integer, PoleNameManagement> poleNameManagements) {
		this.poleNameManagements = poleNameManagements;
	}
	
	/**
	 * This is used to get the poleNameManagements value
	 * @param index
	 * @return
	 */
	public PoleNameManagement getPoleNameManagements(Integer index) {
		return poleNameManagements.get(index);
	}
}
	