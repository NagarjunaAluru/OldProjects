/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: SearchManager.java
 * Purpose: SearchManager used for the search operations
 */
package com.ge.aloc.manager.impl;


import com.ge.aloc.DashboardViewType;
import com.ge.aloc.OpCode;
import com.ge.aloc.dao.ISearchDAO;
import com.ge.aloc.manager.ISearchManager;
import com.ge.aloc.model.APMDetails;
import com.ge.aloc.model.APMSearch;
import com.ge.aloc.model.Inbox;
import com.ge.aloc.model.IssuingBank;
import com.ge.aloc.model.Search;
import com.ge.aloc.model.SuretyMaster;
import com.ge.aloc.model.SuretyMasterCollection;
import com.ge.aloc.util.ALOCCommonHelper;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author arijit.biswas
 *
 */
public class SearchManager implements ISearchManager{

	private ISearchDAO searchDAO;
	/* 
	 * @see com.ge.aloc.manager.dashboard.IDashboardSearchSupport#basicSearch(java.lang.Object)
	 */
	public Inbox executeSearch(Search searchCriteria, DashboardViewType dashboardViewType) throws HWFServiceException {
		Inbox inbox = searchDAO.executeSearch(searchCriteria, dashboardViewType);
		if(dashboardViewType.equals(DashboardViewType.BUNDLES))
		{
			if(inbox.getBundle() != null)
			{
				inbox = ALOCCommonHelper.getInboxDetailByBundleId(inbox);
			}
		}
		return inbox;
	}


	/**
	 * This method is used to perform Fee History search and return result from the DB.
	 * @param apmDetails
	 * @return
	 * @throws HWFServiceException
	 */
	public APMDetails executeFHSearch(APMSearch apmSearch)
			throws HWFServiceException {	
		apmSearch=ALOCCommonHelper.formatFHSearch(apmSearch);
		APMDetails apmDetails=new APMDetails();
		apmDetails.setAPMSearch(apmSearch);
		apmDetails.setMsgHeader(ALOCCommonHelper.createMsgHeader(OpCode.APMSEARCH.getOperationCode()));	
		apmDetails = searchDAO.executeFHSearch(apmDetails);
		return apmDetails;
	}
	
	public SuretyMasterCollection getAllSuretyCompNames() throws HWFServiceException {
		SuretyMaster suretyMaster = new SuretyMaster();
		return  searchDAO.getActiveSuretyMasterList(suretyMaster);
	}
	
	/**
	 * @return
	 * @throws HWFServiceException
	 */
	public IssuingBank getAllIssuingBanks()throws HWFServiceException {
		return searchDAO.getAllIssuingBanks();
	}

	/**
	 * @return the searchDAO
	 */
	public ISearchDAO getSearchDAO() {
		return searchDAO;
	}

	/**
	 * @param searchDAO the searchDAO to set
	 */
	public void setSearchDAO(ISearchDAO searchDAO) {
		this.searchDAO = searchDAO;
	}
}
