/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: DashboardRefDataAction.java
 * Purpose: DashboardRefDataAction used for dashboard ajax operations
 */
package com.ge.aloc.action.dashboard;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.ge.aloc.DashboardViewType;
import com.ge.aloc.WorkflowStage;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.manager.dashboard.IDashboardRefDataManager;
import com.ge.aloc.model.ActionLog;
import com.ge.aloc.model.ReqContactInfo;
import com.ge.aloc.model.RequestDetails;
import com.ge.aloc.model.WinningBank;
import com.hydus.hwf.exceptions.ErrorData;
import com.hydus.hwf.exceptions.HWFServiceException;
import com.hydus.hwf.exceptions.IErrorHandler;
import com.hydus.hwf.util.StringUtils;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author arijit.biswas
 *
 */
public class DashboardRefDataAction extends ActionSupport{

	private static final long serialVersionUID = 1L;

	private IDashboardRefDataManager dashboardRefDataManager;

	private List<ActionLog> actionLogDetails;
	private WinningBank winningBankDetails;
	private ReqContactInfo reqContactInfo;
	private DashboardViewType dashboardViewType;
	private String instrumentTypeId;
	private String requestId;
	private String bundleId;
	private WorkflowStage stage;
	private String wfid;
	private String queueName;
	private String procedureName;
	private String stageName;
	private BigDecimal bankBidId;
	private String bidFlag;
	private String amendmentId;
	private List<RequestDetails> requestDetailsList;
	private String designatedForBundlingFlag;
	private BigDecimal bidReplyId;
	private String issuingBankName;
	protected String workFlowstageId;
	private String bankName;
	private String riderId;
	private String sitePrefix;
	protected IErrorHandler errorHandler;	
	private String errorMsg;
	private String alocRecordId;
	private String state;
	private String transmissionPlatform;
	private String deleteReason;
	private String amdRiderExist;
	private String paymentsPaid;
	
	private HttpServletRequest request = ServletActionContext.getRequest();

	/**
	 * Method to get the Action log details of selected request
	 * @return
	 * @throws HWFServiceException
	 */
	public String getActionLog() throws HWFServiceException{
		String reqID = request.getParameter(ALOCConstants.REQUESTID);
		String alocRecordNo = request.getParameter(ALOCConstants.ALOCRECORDNUMBER);
		String instrumentTypeId = request.getParameter(ALOCConstants.INSTRUMENTTYPEID);
		actionLogDetails = dashboardRefDataManager.getActionLog(reqID,alocRecordNo,instrumentTypeId);

		return ALOCConstants.ACTIONLOGSUCCESS;
	}

	/**
	 * Method to get the request contact information for selected request
	 * @return
	 * @throws HWFServiceException
	 */
	public String getRequestContactInfo() throws HWFServiceException{
		String reqID = request.getParameter(ALOCConstants.REQUESTID);
		String dashBoardViewType = request.getParameter(ALOCConstants.DASHBOARDTYPE);
		if(dashBoardViewType != null){
		setDashboardViewType(DashboardViewType.valueOf(dashBoardViewType));
		reqContactInfo = dashboardRefDataManager.getReqContactInfo(reqID,instrumentTypeId,amendmentId,bidFlag,bidReplyId); 
		}
		return getReturnType(); 
	}

	/**
	 * Method to get the treasury bid process request contact information for selected request
	 * @return
	 * @throws HWFServiceException
	 */
	public String getTreasuryBidRequestContactInfo() throws HWFServiceException {
		reqContactInfo = dashboardRefDataManager.getTreasuryBidRequestContactInfo(requestId);
		return SUCCESS;
	}

	/**
	 * This Method is used to get the request details for selected bundle or request Id
	 * @return
	 * @throws HWFServiceException
	 */
	public String selectWinnerRequests() throws HWFServiceException {
		try{
				requestDetailsList = dashboardRefDataManager.selectWinnerRequests(bundleId,requestId,instrumentTypeId);
				sitePrefix = requestDetailsList.get(ALOCConstants.BASE_VALUE).getSitePrefix();
		}catch(HWFServiceException hse){	
			ErrorData errorData = errorHandler.handle(hse);
			this.errorMsg = errorData.getCause().getMessage();				
			return SUCCESS;
		}
		return SUCCESS;
	}

	/**
	 * Method to select request from Dashboard to delete
	 * @return
	 * @throws HWFServiceException
	 */
	public String deleteRequestModel() throws HWFServiceException {
		/*
		 * The properties of this class has been used in the JSP to render the results
		 * So the request should go via this action method.
		 */
		deleteReason = null;
		return SUCCESS;
	}
	
	/**
	 * Method to delete selected request from Dashboard
	 * @return
	 * @throws HWFServiceException
	 */
	public String deleteRequest() throws HWFServiceException {
		try{
				HttpSession session = ServletActionContext.getRequest().getSession();
				RequestDetails requestDetails = dashboardRefDataManager.deleteRequest(requestId,wfid,stageName,queueName,procedureName,workFlowstageId,amendmentId,instrumentTypeId,deleteReason);
				session.setAttribute(ALOCConstants.SUCCESSMSG, requestDetails.getComments());
	       }catch(HWFServiceException hse){	
			ErrorData errorData = errorHandler.handle(hse);
			this.errorMsg = errorData.getCause().getMessage();				
			return SUCCESS;
		}
		return SUCCESS;
	}
	
	/**
	 * Method to get the linked transaction count for given request
	 * @return
	 * @throws HWFServiceException
	 */
	public String getLinkedTransactionsCount() throws HWFServiceException {
		String reqID = request.getParameter(ALOCConstants.REQUESTID);
		reqContactInfo = dashboardRefDataManager.getReqContactInfo(reqID,instrumentTypeId,amendmentId,bidFlag,bidReplyId); 
		return SUCCESS;
	}

	/**
	 * Method to get the selected DashBoard return type 
	 * @return
	 */
	private String getReturnType() {
		String returnType = ALOCConstants.EMPTY_STRING;
		if(dashboardViewType != null){
		switch (dashboardViewType) {
		case MYTRANSACTIONS:
			returnType = ALOCConstants.MYTRANSACTIONS_TAB;
			break;
		case ALLREQUESTS:
			returnType = ALOCConstants.ALLREQUESTS_TAB;
			break;
		case DRAFTS:
			returnType = ALOCConstants.DRAFTS_TAB;
			break;
		case BANKBIDPROCESS:
			returnType = ALOCConstants.BANKBID_TAB;
			break;
		case TREASURYBANKPENDINGINCE:
			returnType = ALOCConstants.BANKPENDINGISS_TAB;
			break;
		case TREASURYBANKHIST:
			returnType = ALOCConstants.BANKHISTTRANS_TAB;
			break;
		case TREASURYBROKERBIDPROCESS:
			returnType = ALOCConstants.BANKBID_TAB;
			break;
		case TREASURYBROKERPENDINGINCE:
			returnType = ALOCConstants.BANKPENDINGISS_TAB;
			break;
		case TREASURYBROKERHIST:
			returnType = ALOCConstants.BANKHISTTRANS_TAB;
		}
		}
		return returnType;
	}

	/**
	 * This method is used to get the actionLogDetails list.
	 * @return the actionLogDetails
	 */
	public List<ActionLog> getActionLogDetails() {
		return actionLogDetails;
	}

	/**
	 * This method is used to set the actionLogDetails list.
	 * @param actionLogDetails the actionLogDetails to set
	 */
	public void setActionLogDetails(List<ActionLog> actionLogDetails) {
		this.actionLogDetails = actionLogDetails;
	}

	/**
	 * This method is used to get the winningBankDetails.
	 * @return the winningBankDetails
	 */
	public WinningBank getWinningBankDetails() {
		return winningBankDetails;
	}

	/**
	 *  This method is used to set the winningBankDetails.
	 * @param winningBankDetails the winningBankDetails to set
	 */
	public void setWinningBankDetails(WinningBank winningBankDetails) {
		this.winningBankDetails = winningBankDetails;
	}

	/**
	 * This method is used to get the reqContactInfo details.
	 * @return the reqContactInfo
	 */
	public ReqContactInfo getReqContactInfo() {
		return reqContactInfo;
	}

	/**
	 *  This method is used to set the reqContactInfo details.
	 * @param reqContactInfo the reqContactInfo to set
	 */
	public void setReqContactInfo(ReqContactInfo reqContactInfo) {
		this.reqContactInfo = reqContactInfo;
	}

	/**
	 * This method is used to get the dashboardViewType.
	 * @return the dashboardViewType
	 */
	public DashboardViewType getDashboardViewType() {
		return dashboardViewType;
	}

	/**
	 *  This method is used to set the dashboardViewType.
	 * @param dashboardViewType the dashboardViewType to set
	 */
	public void setDashboardViewType(DashboardViewType dashboardViewType) {
		this.dashboardViewType = dashboardViewType;
	}

	/**
	 * This method is used to get the dashboardRefDataManager instance.
	 * @return the dashboardRefDataManager
	 */
	public IDashboardRefDataManager getDashboardRefDataManager() {
		return dashboardRefDataManager;
	}

	/**
	 *  This method is used to create the dashboardRefDataManager instance.
	 * @param dashboardRefDataManager the dashboardRefDataManager to set
	 */
	public void setDashboardRefDataManager(
			IDashboardRefDataManager dashboardRefDataManager) {
		this.dashboardRefDataManager = dashboardRefDataManager;
	}

	/**
	 * This method is used to get the instrumentTypeId value.
	 * @return the instrumentTypeId
	 */
	public String getInstrumentTypeId() {
		return instrumentTypeId;
	}

	/**
	 *  This method is used to set the instrumentTypeId value.
	 * @param instrumentTypeId the instrumentTypeId to set
	 */
	public void setInstrumentTypeId(String instrumentTypeId) {
		this.instrumentTypeId = instrumentTypeId;
	}

	/**
	 * This method is used to get the requestId value.
	 * @return the requestId
	 */
	public String getRequestId() {
		return requestId;
	}

	/**
	 * This method is used to set the requestId value.
	 * @param requestId the requestId to set
	 */
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	/**
	 * This method is used to get the request object instance
	 * @return the request
	 */
	public HttpServletRequest getRequest() {
		return request;
	}

	/**
	 *  This method is used to set the request object instance
	 * @param request the request to set
	 */
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 * This method is used to get the request detail list
	 * @return the requestDetailsList
	 */
	public List<RequestDetails> getRequestDetailsList() {
		return requestDetailsList;
	}

	/**
	 * This method is used to set the request detail list
	 * @param requestDetailsList the requestDetailsList to set
	 */
	public void setRequestDetailsList(List<RequestDetails> requestDetailsList) {
		this.requestDetailsList = requestDetailsList;
	}
	/**
	 * This method is used to get the bundleId value
	 * @return the bundleId
	 */
	public String getBundleId() {
		return bundleId;
	}

	/**
	 * This method is used to set the bundleID value
	 * @param bundleId the bundleId to set
	 */
	public void setBundleId(String bundleId) {
		this.bundleId = bundleId;
	}

	/**
	 * This method is used to get the stage.
	 * @return the stage
	 */
	public Integer getStage() {
		return (stage != null) ? stage.getId() : WorkflowStage.DRAFT.getId();
	}
	/**
	 * This method is used to set the stage.
	 * @param stage
	 */
	public void setStage(Integer stage) {
		if(stage != null) {
			this.stage = WorkflowStage.fromId(stage);
		}
	}

	/**
	 * This method is used to get the wfid value
	 * @return the wfid
	 */
	public String getWfid() {
		return wfid;
	}

	/**
	 * This method is used to set the wfid value
	 * @param wfid the wfid to set
	 */
	public void setWfid(String wfid) {
		this.wfid = wfid;
	}

	/**
	 * This method is used to get the queueName value
	 * @return the queueName
	 */
	public String getQueueName() {
		return queueName;
	}

	/**
	 * This method is used to set the queueName value
	 * @param queueName the queueName to set
	 */
	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

	/**
	 * This method is used to get the procedureName value
	 * @return the procedureName
	 */
	public String getProcedureName() {
		return procedureName;
	}

	/**
	 * This method is used to set the procedureName value
	 * @param procedureName the procedureName to set
	 */
	public void setProcedureName(String procedureName) {
		this.procedureName = procedureName;
	}

	/**
	 * This method is used to get the stageName value
	 * @return the stageName
	 */
	public String getStageName() {
		return stageName;
	}

	/**
	 * This method is used to set the stageName value
	 * @param stageName the stageName to set
	 */
	public void setStageName(String stageName) {
		this.stageName = stageName;
	}

	/**
	 * This method is used to get the bidFlag value
	 * @return the bidFlag
	 */
	public String getBidFlag() {
		return bidFlag;
	}

	/**
	 * This method is used to set the bidFlag value
	 * @param bidFlag the bidFlag to set
	 */
	public void setBidFlag(String bidFlag) {
		this.bidFlag = bidFlag;
	}

	/**
	 * This method is used to get the amendmentId value
	 * @return the amendmentId
	 */
	public String getAmendmentId() {
		return amendmentId;
	}

	/**
	 * This method is used to set the amendmentId value
	 * @param amendmentId the amendmentId to set
	 */
	public void setAmendmentId(String amendmentId) {
		this.amendmentId = amendmentId;
	}

	/**
	 * This method is used to get the designatedForBundlingFlag value
	 * @return the designatedForBundlingFlag
	 */
	public String getDesignatedForBundlingFlag() {
		return designatedForBundlingFlag;
	}

	/**
	 * This method is used to set the designatedForBundlingFlag value
	 * @param designatedForBundlingFlag the designatedForBundlingFlag to set
	 */
	public void setDesignatedForBundlingFlag(String designatedForBundlingFlag) {
		this.designatedForBundlingFlag = designatedForBundlingFlag;
	}
	
	/**
	 * This method is used to get the issuingBankName value
	 * @return the issuingBankName
	 */
	public String getIssuingBankName() {
		return issuingBankName;
	}

	/**
	 * This method is used to set the issuingBankName value
	 * @param issuingBankName the issuingBankName to set
	 */
	public void setIssuingBankName(String issuingBankName) {
		this.issuingBankName = issuingBankName;
	}

	/**
	 * This method is used to get the workFlowstageId value
	 * @return the workFlowstageId
	 */
	public String getWorkFlowstageId() {
		return workFlowstageId;
	}

	/**
	 * This method is used to set the workFlowstageId value
	 * @param workFlowstageId the workFlowstageId to set
	 */
	public void setWorkFlowstageId(String workFlowstageId) {
		this.workFlowstageId = workFlowstageId;
	}
	
	/**
	 * This method is used to get the bankName value
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * This method is used to set the bankName value
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	/**
	 * This method is used to get the riderId value
	 * @return the riderId
	 */
	public String getRiderId() {
		return riderId;
	}

	/**
	 * This method is used to set the riderId value
	 * @param riderId the riderId to set
	 */
	public void setRiderId(String riderId) {
		this.riderId = riderId;
	}

	/**
	 * This method is used to get the sitePrefix
	 * @return the sitePrefix
	 */
	public String getSitePrefix() {
		return sitePrefix;
	}

	/**
	 *  This method is used to set the sitePrefix
	 * @param sitePrefix the sitePrefix to set
	 */
	public void setSitePrefix(String sitePrefix) {
		this.sitePrefix = sitePrefix;
	}
	
	/**
	 * This method is used to get the errorHandler instance
	 * @return the errorHandler
	 */
	public IErrorHandler getErrorHandler() {
		return errorHandler;
	}

	/**
	 * This method is used to set the errorHandler instance
	 * @param errorHandler the errorHandler to set
	 */
	public void setErrorHandler(IErrorHandler errorHandler) {
		this.errorHandler = errorHandler;
	}

	/**
	 * This method is used to get the errorMsg value
	 * @return the errorMsg
	 */
	public String getErrorMsg() {
		return errorMsg;
	}

	/**
	 * This method is used to set the value errorMsg value
	 * @param errorMsg the errorMsg to set
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	/**
	 * This method is used to get the alocRecordId value
	 * @return the alocRecordId
	 */
	public String getAlocRecordId() {
		return alocRecordId;
	}

	/**
	 * This method is used to set the alocRecordId value
	 * @param alocRecordId the alocRecordId to set
	 */
	public void setAlocRecordId(String alocRecordId) {
		this.alocRecordId = alocRecordId;
	}
	
	/**
	 * This method is used to get the bankBidId value
	 * @return the bankBidId
	 */
	public BigDecimal getBankBidId() {
		return bankBidId;
	}

	/**
	 * This method is used to set the bankBidId value
	 * @param bankBidId the bankBidId to set
	 */
	public void setBankBidId(BigDecimal bankBidId) {
		this.bankBidId = bankBidId;
	}
	
	/**
	 * This method is used to get the bidReplyId value
	 * @return the bidReplyId
	 */
	public BigDecimal getBidReplyId() {
		return bidReplyId;
	}

	/**
	 * This method is used to set the bidReplyId value
	 * @param bidReplyId the bidReplyId to set
	 */
	public void setBidReplyId(BigDecimal bidReplyId) {
		this.bidReplyId = bidReplyId;
	}
	
	/**
	 * This method is used to get the state value
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * This method is used to set the state value
	 * @param state the state to set
	 */
	public void setState(String state) {
		if(StringUtils.isNotBlank(state)){
		this.state = state.toUpperCase(); }
	}
	
	/**
	 * This method is used to get the transmissionPlatform value
	 * @return the transmissionPlatform
	 */
	public String getTransmissionPlatform() {
		return transmissionPlatform;
	}

	/**
	 * This method is used to set the transmissionPlatform value
	 * @param transmissionPlatform the transmissionPlatform to set
	 */
	public void setTransmissionPlatform(String transmissionPlatform) {
		this.transmissionPlatform = transmissionPlatform;
	}
	
	/**
	 * @return the deleteReason
	 */
	public String getDeleteReason() {
		return deleteReason;
	}

	/**
	 * @param deleteReason the deleteReason to set
	 */
	public void setDeleteReason(String deleteReason) {
		this.deleteReason = deleteReason;
	}
	
	/**
	 * @return the paymentsPaid
	 */
	public String getPaymentsPaid() {
		return paymentsPaid;
	}

	/**
	 * @param paymentsPaid the paymentsPaid to set
	 */
	public void setPaymentsPaid(String paymentsPaid) {
		this.paymentsPaid = paymentsPaid;
	}

	/**
	 * @return the amdRiderExist
	 */
	public String getAmdRiderExist() {
		return amdRiderExist;
	}

	/**
	 * @param amdRiderExist the amdRiderExist to set
	 */
	public void setAmdRiderExist(String amdRiderExist) {
		this.amdRiderExist = amdRiderExist;
	}
}
