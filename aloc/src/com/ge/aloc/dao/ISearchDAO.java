/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ISearchDAO.java
 * Purpose: ISearchDAO used for the search DAO declarations
 */
package com.ge.aloc.dao;

import com.ge.aloc.DashboardViewType;
import com.ge.aloc.model.APMDetails;
import com.ge.aloc.model.Inbox;
import com.ge.aloc.model.IssuingBank;
import com.ge.aloc.model.Search;
import com.ge.aloc.model.SuretyMaster;
import com.ge.aloc.model.SuretyMasterCollection;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author arijit.biswas
 *
 */
public interface ISearchDAO {
	/**
	 * This method is used to perform search and retrun result from the DB.
	 * @param searchCriteria
	 * @param dashboardViewType
	 * @return
	 * @throws HWFServiceException
	 */
	public Inbox executeSearch(Search searchCriteria,DashboardViewType dashboardViewType) throws HWFServiceException;


	/**
	 * This method is used to perform Fee History search and return result from the DB.
	 * @param apmDetails
	 * @return
	 * @throws HWFServiceException
	 */
	public APMDetails executeFHSearch(APMDetails apmDetails)throws HWFServiceException;
	
	/**
	 * @return
	 * @throws HWFServiceException
	 */
	public IssuingBank getAllIssuingBanks()throws HWFServiceException;
	
	/**
	 * Method to retrieve the Surety Company Names List
	 * @param suretyMaster
	 * @return SuretyMasterCollection
	 * @throws HWFServiceException
	 */
	public SuretyMasterCollection getActiveSuretyMasterList(SuretyMaster suretyMaster) throws HWFServiceException;
}
