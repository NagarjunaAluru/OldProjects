/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ISearchManager.java
 * Purpose: ISearchManager used for the search operations
 */
package com.ge.aloc.manager;

import com.ge.aloc.DashboardViewType;
import com.ge.aloc.model.APMDetails;
import com.ge.aloc.model.APMSearch;
import com.ge.aloc.model.Inbox;
import com.ge.aloc.model.IssuingBank;
import com.ge.aloc.model.Search;
import com.ge.aloc.model.SuretyMasterCollection;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author arijit.biswas
 *
 */
public interface ISearchManager {
	/**
	 * This method is used to perform search and returns dashboard results.
	 * @param searchCriteria
	 * @return
	 * @throws HWFServiceException
	 */
	public Inbox executeSearch(Search searchCriteria, DashboardViewType dashboardViewType) throws HWFServiceException;

	/**
	 * This method is used to perform fee history search.
	 * @param searchCriteria
	 * @return
	 * @throws HWFServiceException
	 */
	public APMDetails executeFHSearch(APMSearch apmSearch ) throws HWFServiceException;
	
	/**
	 * @return
	 * @throws HWFServiceException
	 */
	public IssuingBank getAllIssuingBanks()throws HWFServiceException;
	
	/**
	 * @return
	 * @throws HWFServiceException
	 */
	public SuretyMasterCollection getAllSuretyCompNames() throws HWFServiceException;
}
