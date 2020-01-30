/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: SearchDAO.java
 * Purpose: SearchDAO used for the search DAO Implementations
 */
package com.ge.aloc.dao.impl;

import com.ge.aloc.DashboardViewType;
import com.ge.aloc.OpCode;
import com.ge.aloc.ServiceClientSupport;
import com.ge.aloc.dao.ISearchDAO;
import com.ge.aloc.model.APMDetails;
import com.ge.aloc.model.Inbox;
import com.ge.aloc.model.IssuingBank;
import com.ge.aloc.model.MsgHeader;
import com.ge.aloc.model.Search;
import com.ge.aloc.model.SuretyMaster;
import com.ge.aloc.model.SuretyMasterCollection;
import com.ge.aloc.util.ALOCCommonHelper;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author arijit.biswas
 *
 */
public class SearchDAO extends ServiceClientSupport implements ISearchDAO{
	/**
	 * @see com.ge.aloc.dao.ISearchDAO#executeSearch(Search)
	 */
	public Inbox executeSearch(Search searchCriteria,DashboardViewType dashboardViewType) throws HWFServiceException {
		Inbox inbox = new Inbox();
		switch (dashboardViewType) {
		case MYTRANSACTIONS:
			searchCriteria.setMsgHeader(ALOCCommonHelper.createMsgHeader(OpCode.MYTRANSACTIONSEARCH.getOperationCode()));
			break;
		case ALLREQUESTS:
			searchCriteria.setMsgHeader(ALOCCommonHelper.createMsgHeader(OpCode.ALLREQSEARCH.getOperationCode()));
			break;
		case DRAFTS:
			searchCriteria.setMsgHeader(ALOCCommonHelper.createMsgHeader(OpCode.DRAFTSEARCH.getOperationCode()));
			break;
		case BUNDLES:
			searchCriteria.setMsgHeader(ALOCCommonHelper.createMsgHeader(OpCode.BUNDLESEARCH.getOperationCode()));
			break;		
		case MODEL:
			searchCriteria.setMsgHeader(ALOCCommonHelper.createMsgHeader(OpCode.MODELSEARCH.getOperationCode()));
			break;
		case TREASURYBIDPROCESS:
			searchCriteria.setMsgHeader(ALOCCommonHelper.createMsgHeader(OpCode.DASHBOARD_TREASURYBIDPROCESS.getOperationCode()));
			break;
		case BANKBIDPROCESS:
			searchCriteria.setMsgHeader(ALOCCommonHelper.createMsgHeader(OpCode.DASHBOARD_BANKBIDPROCESS.getOperationCode()));
			break;
		case TREASURYBANKPENDINGINCE:
			searchCriteria.setMsgHeader(ALOCCommonHelper.createMsgHeader(OpCode.DASHBOARD_TREASURYBANKPENDINGINCE.getOperationCode()));
			break;
		case TREASURYBANKHIST:
			searchCriteria.setMsgHeader(ALOCCommonHelper.createMsgHeader(OpCode.DASHBOARD_TREASURYBANKHIST.getOperationCode()));
			break;
		case TREASURYBROKERBIDPROCESS:
			searchCriteria.setMsgHeader(ALOCCommonHelper.createMsgHeader(OpCode.DASHBOARD_TREASURYBROKERBIDPROCESS.getOperationCode()));
			break;
		case TREASURYBROKERPENDINGINCE:
			searchCriteria.setMsgHeader(ALOCCommonHelper.createMsgHeader(OpCode.DASHBOARD_TREASURYBROKERPENDINGINCE.getOperationCode()));
			break;
		case TREASURYBROKERHIST:
			searchCriteria.setMsgHeader(ALOCCommonHelper.createMsgHeader(OpCode.DASHBOARD_TREASURYBROKERHIST.getOperationCode()));
			break;
		}
		inbox  = serviceClient.invokeService(OpCode.SEARCH.getOperationCode(), searchCriteria, Inbox.class);
		return inbox;
	}

	/**
	 * This method is used to perform Fee History search and return result from the DB.
	 * @param apmDetails
	 * @return
	 * @throws HWFServiceException
	 */
	public APMDetails executeFHSearch(APMDetails apmDetails)throws HWFServiceException{
		apmDetails  =serviceClient.invokeService(OpCode.APMDETAILS.getOperationCode(),apmDetails, APMDetails.class);
		return apmDetails;

	}

	/**
	 * This method is used to perform Fee History search and return result from the DB.
	 * @param apmDetails
	 * @return
	 * @throws HWFServiceException
	 */
	public IssuingBank getAllIssuingBanks() throws HWFServiceException {
		IssuingBank issuingBank = new IssuingBank();
		issuingBank.setMsgHeader(ALOCCommonHelper.createMsgHeader(OpCode.ISSUINGBANK.getOperationCode()));
		issuingBank = serviceClient.invokeService(OpCode.ISSUINGBANK.getOperationCode(),issuingBank,IssuingBank.class);
		return issuingBank;
	}

	public SuretyMasterCollection getActiveSuretyMasterList(
			SuretyMaster suretyMaster) throws HWFServiceException {
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.GETACTIVESURETY.getOperationCode());
		suretyMaster.setMsgHeader(msgHeader);
		SuretyMasterCollection suretyList = (SuretyMasterCollection) serviceClient.invokeService(OpCode.INITIATESURETY.getOperationCode(), suretyMaster, SuretyMasterCollection.class);
		return suretyList;
	}
}
