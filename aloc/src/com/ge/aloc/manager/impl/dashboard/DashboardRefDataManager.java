/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: DashboardRefDataManager.java
 * Purpose: DashboardRefDataManager used for dashboard the ajax operations
 */
package com.ge.aloc.manager.impl.dashboard;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.ge.aloc.ActionType;
import com.ge.aloc.InstrumentType;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.dao.dashboard.IDashboardRefDataDAO;
import com.ge.aloc.manager.dashboard.IDashboardRefDataManager;
import com.ge.aloc.model.ActionDetails;
import com.ge.aloc.model.ActionLog;
import com.ge.aloc.model.Amendment;
import com.ge.aloc.model.BondDetails;
import com.ge.aloc.model.InstrumentDetails;
import com.ge.aloc.model.MsgHeader;
import com.ge.aloc.model.ReqContactInfo;
import com.ge.aloc.model.RequestDetails;
import com.ge.aloc.model.Rider;
import com.ge.aloc.model.TransactionParties;
import com.ge.aloc.model.WFDetails;
import com.ge.aloc.util.ALOCCommonHelper;
import com.hydus.hwf.exceptions.HWFServiceException;
import com.hydus.hwf.util.StringUtils;

/**
 * @author arijit.biswas
 *
 */
public class DashboardRefDataManager implements IDashboardRefDataManager {
	private IDashboardRefDataDAO dashboardRefDataDAO;

	/**
	 * Method to get the Action log details of selected request
	 * @param requestId
	 * @param alocRecordNo
	 * @param instrumentTypeId
	 * @return
	 * @throws HWFServiceException
	 */
	public List<ActionLog> getActionLog(String requestId,String alocRecordNo,String instrumentTypeId) throws HWFServiceException {
		ActionLog actionLog = new ActionLog();
		actionLog.setAlocRequestId(requestId);
		actionLog.setAlocRecordId(alocRecordNo);
		if(StringUtils.isNotBlank(instrumentTypeId)){
			actionLog.setInstrumentTypeId(new BigInteger(instrumentTypeId));
		}
		return dashboardRefDataDAO.getActionLog(actionLog);
	}

	/**
	 *  Method to get the request contact information for selected request
	 * @param reqContactInfo
	 * @param instrumentTypeId
	 * @param amendmentId
	 * @return
	 * @throws HWFServiceException
	 */
	public ReqContactInfo getReqContactInfo(String requestId,String instrumentTypeId,String amendmentId,String bidFlag,BigDecimal bidReplyId) throws HWFServiceException {
		ReqContactInfo reqContactInfo = new ReqContactInfo();
		if (StringUtils.isNotBlank(requestId)) {
			if (requestId.indexOf(ALOCConstants.BANKLOOKUP_HYPEN) > ALOCConstants.BASE_VALUE) {
				int endVal = requestId.indexOf(ALOCConstants.BANKLOOKUP_HYPEN);
				requestId = requestId.substring(ALOCConstants.BASE_VALUE, endVal);
			}}
		
		if (StringUtils.isNotBlank(instrumentTypeId)) {
			reqContactInfo.setInstrumentTypeId(new BigInteger(instrumentTypeId));}
		
		if (StringUtils.isNotBlank(instrumentTypeId)
				&& instrumentTypeId.equalsIgnoreCase(Integer.toString(InstrumentType.AMENDMENT.getId()))) {
			reqContactInfo.setAmendmentId(amendmentId); }
		else if (StringUtils.isNotBlank(instrumentTypeId) 
				&& instrumentTypeId.equalsIgnoreCase(Integer.toString(InstrumentType.RIDER.getId()))) {
			reqContactInfo.setRiderId(amendmentId); }
		else {
			reqContactInfo.setAlocRequestId(new BigInteger(requestId)); }
		reqContactInfo.setBidReplyFlag(bidFlag);
		if(bidReplyId != null)
			reqContactInfo.setBidReplyId(bidReplyId.toBigInteger());
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(null);
		reqContactInfo.setMsgHeader(msgHeader);
		return dashboardRefDataDAO.getReqContactInfo(reqContactInfo);
	}

	/**
	 * Method to get the treasury bid process request contact information for selected request
	 * @param requestId
	 * @return
	 * @throws HWFServiceException
	 */
	public ReqContactInfo getTreasuryBidRequestContactInfo(String requestId)
			throws HWFServiceException {
		ReqContactInfo reqContactInfo = new ReqContactInfo();
		reqContactInfo.setAlocRequestId(new BigInteger(requestId));
		return dashboardRefDataDAO.getTreasuryBidRequestContactInfo(reqContactInfo);
	}

	/**
	 * This Method is used to get the request details for selected bundle or request Id
	 * @param bundleId
	 * @param requestId
	 * @param instrumentTypeId
	 * @return
	 * @throws HWFServiceException
	 */
	public List<RequestDetails> selectWinnerRequests(String bundleId,String requestId,String instrumentTypeId) throws HWFServiceException {
		List<RequestDetails> requestDetailList = new ArrayList<RequestDetails>();
		if( bundleId != null && bundleId.length() > ALOCConstants.BASE_VALUE)
		{
			requestDetailList = dashboardRefDataDAO.getRequestsForSelBundle(bundleId);
		}
		else if(requestId != null && requestId.length() > ALOCConstants.BASE_VALUE)
		{
			ReqContactInfo reqContactInfo = new ReqContactInfo();
			reqContactInfo.setAlocRequestId(new BigInteger(requestId));
			MsgHeader msgHeader =  ALOCCommonHelper.createMsgHeader(null);
			reqContactInfo.setMsgHeader(msgHeader);
			reqContactInfo = dashboardRefDataDAO.getReqContactInfo(reqContactInfo);
			RequestDetails requestDetails = new RequestDetails();
			requestDetails.setRequestId(new BigInteger(requestId));
			requestDetails.setInstrumentTypeId(new BigInteger(instrumentTypeId));
			InstrumentDetails instrumentDetails = new InstrumentDetails();
			if(reqContactInfo.getInstrumentType() != null)
				requestDetails.setInstrumentType(reqContactInfo.getInstrumentType());
			instrumentDetails.setInstrumentCurrencyId(reqContactInfo.getInstrumentCcy());
			if(reqContactInfo.getInstrumentAmt() != null)
				instrumentDetails.setInstrumentAmt(reqContactInfo.getInstrumentAmt());
			instrumentDetails.setExpiryDt(reqContactInfo.getExpDt());
			requestDetails.setInstrumentDetails(instrumentDetails);
			if(reqContactInfo.getBondTypeId() != null)
			{
				BondDetails bondDetails = new BondDetails();
				bondDetails.setBondTypeId(reqContactInfo.getBondTypeId());
				if(reqContactInfo.getSubBondTypeId() != null)
					bondDetails.setSubBondTypeId(reqContactInfo.getSubBondTypeId());
				requestDetails.setBondDetails(bondDetails);
			}
			if(reqContactInfo.getInstrumentPurposeId() != null)
			{
				TransactionParties transactionParties = new TransactionParties();
				transactionParties.setInstrumentPurposeId(reqContactInfo.getInstrumentPurposeId().toString());
				requestDetails.setTransactionParties(transactionParties);
			}
			if(StringUtils.isNotBlank(reqContactInfo.getAlocRecordId()))
			{
				requestDetails.setAlocRecordId(reqContactInfo.getAlocRecordId());
			}
			if(StringUtils.isNotBlank(reqContactInfo.getSitePrefix()))
			{
				requestDetails.setSitePrefix(reqContactInfo.getSitePrefix());
			}
			requestDetailList.add(requestDetails);
		}
		return requestDetailList;
	}
	
	/**
	 * Method to delete selected request from Dashboard
	 * @param requestId
	 * @param wfid
	 * @param stageName
	 * @param queueName
	 * @param procedureName
	 * @param workFlowstageId
	 * @throws HWFServiceException
	 */
	public RequestDetails deleteRequest(String requestId,String wfid, String stageName, String queueName,
			String procedureName,String workFlowstageId, String amendmentId, String instrumentTypeId, String reasonForDelete) throws HWFServiceException{
		RequestDetails requestDetails=new RequestDetails();
		WFDetails wfDetails=new WFDetails();
		wfDetails.setWFID(wfid);
		wfDetails.setWFStage(stageName);
		wfDetails.setProcedureName(procedureName);
		wfDetails.setQueueName(queueName);
		if(StringUtils.isNotBlank(workFlowstageId)){
			wfDetails.setWFStageID(new BigInteger(workFlowstageId));
		}
		requestDetails.setWFDetails(wfDetails);
		
		ActionDetails acdetails = new ActionDetails();
		acdetails.setActionId(String.valueOf(ActionType.DELETE_AMENDMENT.getId()));
		acdetails.setActionName(ActionType.DELETE_AMENDMENT.getName());
		acdetails.setComments(reasonForDelete);
		
		if (StringUtils.isNotBlank(instrumentTypeId)
				&& instrumentTypeId.equalsIgnoreCase(Integer.toString(InstrumentType.AMENDMENT.getId()))) {
			Amendment amendment = new Amendment();
			amendment.setAmendmentRequestId(amendmentId);
			amendment.setActionDetails(acdetails);
			amendment.setOpCode(ActionType.DELETE_AMENDMENT.getName());
			requestDetails.setAmendment(amendment);
			requestDetails.setInstrumentTypeId(new BigInteger(instrumentTypeId));
			requestDetails = dashboardRefDataDAO.deleteAmendmentORRiderRequest(requestDetails, ActionType.DELETE_AMENDMENT);
		}else if (StringUtils.isNotBlank(instrumentTypeId) 
				&& instrumentTypeId.equalsIgnoreCase(Integer.toString(InstrumentType.RIDER.getId()))) {
			Rider rider  = new Rider();
			rider.setRiderRequestId(amendmentId);
			rider.setActionDetails(acdetails);
			rider.setOpCode(ActionType.DELETE_AMENDMENT.getName());
			requestDetails.setRider(rider);
			requestDetails.setInstrumentTypeId(new BigInteger(instrumentTypeId));
			requestDetails = dashboardRefDataDAO.deleteAmendmentORRiderRequest(requestDetails, ActionType.DELETE_AMENDMENT);
		}else {
			if(StringUtils.isNotBlank(requestId)) {
				requestDetails.setRequestId(new BigInteger(requestId));
				requestDetails.setActionDetails(acdetails);
				requestDetails = dashboardRefDataDAO.deleteRequest(requestDetails);
			}
		}
		return requestDetails;
	}

	/**
	 * This is used to get the dashboardRefDataDAO object.
	 * @return the dashboardRefDataDAO
	 */
	public IDashboardRefDataDAO getDashboardRefDataDAO() {
		return dashboardRefDataDAO;
	}

	/**
	 * This is used to create the dashboardRefDataDAO object instance.
	 * @param dashboardRefDataDAO the dashboardRefDataDAO to set
	 */
	public void setDashboardRefDataDAO(IDashboardRefDataDAO dashboardRefDataDAO) {
		this.dashboardRefDataDAO = dashboardRefDataDAO;
	}
}
