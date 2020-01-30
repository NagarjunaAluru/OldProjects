/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: PoleNameMgmtManager.java
 * Purpose: PoleNameMgmtManager used for Pole Name Management operations and user actions.
 */
package com.ge.aloc.manager.impl.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.ge.aloc.ALOCContext;
import com.ge.aloc.OpCode;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.dao.admin.IPoleNameMgmtDAO;
import com.ge.aloc.manager.admin.IPoleNameMgmtManager;
import com.ge.aloc.model.MsgHeader;
import com.ge.aloc.model.PoleCountryAssociation;
import com.ge.aloc.model.PoleNameList;
import com.ge.aloc.model.PoleNameManagement;
import com.ge.aloc.model.MDM.Country;
import com.ge.aloc.util.ALOCCommonHelper;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author Rajat-Hydus
 *
 */
public class PoleNameMgmtManager implements IPoleNameMgmtManager{

	private IPoleNameMgmtDAO poleNameMgmtDAO;

	/**
	 * This method is used to fetch All pole names available in DB
	 * @return PoleName List details
	 */
	public PoleNameList open() throws HWFServiceException {
		PoleNameList poleNameList = new PoleNameList();
		PoleNameManagement poleNameMgmt = new PoleNameManagement();
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.INITIATEPOLE.getOperationCode());
		poleNameMgmt.setMsgHeader(msgHeader);
		poleNameMgmt.setOpcode(OpCode.INITIATEPOLE.getOperationCode());
		poleNameList = poleNameMgmtDAO.open(poleNameMgmt);
		return poleNameList;
	}

	/**
	 * This method is used to fetch the pole countries for selected pole
	 * @param poleNameMgmt
	 * @return selectedCountries
	 */
	public Map<String, String> getAvailableCountries(PoleNameManagement poleNameMgmt)
			throws HWFServiceException {
		Map<String, String> selectedCountries = new HashMap<String, String>();
		int seletcedPoleId = poleNameMgmt.getPoleId();
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.POLECOUNTRY.getOperationCode());
		poleNameMgmt.setMsgHeader(msgHeader);
		poleNameMgmt.setOpcode(OpCode.POLECOUNTRY.getOperationCode());
		PoleNameList allPoels = poleNameMgmtDAO.getCountries(poleNameMgmt);
		for(PoleNameManagement poleWithCountries : allPoels.getPoleNameManagements()) {
			if(poleWithCountries.getPoleId().equals(seletcedPoleId)) {
				for(PoleCountryAssociation poleCountryAssociation : poleWithCountries.getPoleCountryAssociations()) {
					selectedCountries.put(poleCountryAssociation.getCountryCd(),poleCountryAssociation.getCountryName());
				}
			}
		}

		return selectedCountries;
	}

	/**
	 * This method is used to add or update the pole names and countries
	 * @param poleNameMgmt
	 * @param selectedCountriesCodes
	 * @return poleNameList
	 */
	public PoleNameManagement update(PoleNameManagement poleNameMgmt,String selectedCountriesCodes)
			throws HWFServiceException {
		List<PoleCountryAssociation> poleCountryAssociationList = new ArrayList<PoleCountryAssociation>();
		PoleCountryAssociation poleCountryAssociation;
		List<String> selectedCountriesCodesList = getSelectedCountriesCodesList(selectedCountriesCodes);
		List<Country> MDMCountries = ALOCContext.getMasterDataFactory().getCountries();
		if(MDMCountries !=null && !MDMCountries.isEmpty())
		{
			Iterator<Country> MDMCountriesItr = MDMCountries.iterator();
			Country MDMCountry = null;
			while(MDMCountriesItr.hasNext()) {
				MDMCountry = MDMCountriesItr.next();
				if(selectedCountriesCodesList.contains(MDMCountry.getCountryCode()))
				{
					poleCountryAssociation = new PoleCountryAssociation();
					poleCountryAssociation.setCountryCd(MDMCountry.getCountryCode());
					poleCountryAssociation.setCountryName(MDMCountry.getCountryName());
					poleCountryAssociationList.add(poleCountryAssociation);
				}
			}
		}
		poleNameMgmt.setPoleCountryAssociations(poleCountryAssociationList);
		if(poleNameMgmt.getPoleId() != null && poleNameMgmt.getPoleId().toString() != ALOCConstants.EMPTY_STRING){  
			poleNameMgmt.setModifiedPoleName(poleNameMgmt.getPoleName());
			poleNameMgmt = poleNameMgmtDAO.update(poleNameMgmt);
			}
		else {	
			poleNameMgmt = poleNameMgmtDAO.insert(poleNameMgmt);
		}
		return poleNameMgmt;
	}

	/**
	 * This method is used to get the selected countries codes List
	 * @param selectedCountriesCodes
	 * @return selectedCountriesCodesList
	 */
	private List<String> getSelectedCountriesCodesList(
			String selectedCountriesCodes) {
		List<String> selectedCountriesCodesList = new ArrayList<String>();
		StringTokenizer strToken = new StringTokenizer(selectedCountriesCodes,ALOCConstants.UNDERSCORE);
		while(strToken.hasMoreTokens())
		{
			selectedCountriesCodesList.add(strToken.nextToken());
		}
		return selectedCountriesCodesList;
	}


	/**
	 * This method is used to get poleNameMgmtDAO instance
	 * @return the poleNameMgmtDAO
	 */
	public IPoleNameMgmtDAO getPoleNameMgmtDAO() {
		return poleNameMgmtDAO;
	}

	/**
	 * This method is used to set poleNameMgmtDAO instance
	 * @param poleNameMgmtDAO the poleNameMgmtDAO to set
	 */
	public void setPoleNameMgmtDAO(IPoleNameMgmtDAO poleNameMgmtDAO) {
		this.poleNameMgmtDAO = poleNameMgmtDAO;
	}
}
