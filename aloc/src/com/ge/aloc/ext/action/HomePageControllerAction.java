/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: HomePageAction.java
 * Purpose: HomePageAction controls the first page of external user after login.
 */
package com.ge.aloc.ext.action;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.ge.aloc.DashboardViewType;
import com.ge.aloc.InstrumentType;
import com.ge.aloc.UserRole;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.ext.manager.IUserOperationsManager;
import com.ge.aloc.manager.common.IHomePageManager;
import com.ge.aloc.model.BidProcess;
import com.ge.aloc.model.DashBoard;
import com.ge.aloc.model.Inbox;
import com.ge.aloc.model.LandingPageDtls;
import com.ge.aloc.model.StaticDataManagement.UserSites;
import com.hydus.hwf.context.UserContext;
import com.hydus.hwf.exceptions.HWFServiceException;
import com.hydus.hwf.util.StringUtils;
import com.opensymphony.xwork2.ActionContext;

/**
 * This class handles the HomePage requests.
 * 
 * @author chaitanya.n
 */
public class HomePageControllerAction {

	private IUserOperationsManager userOperationsManager;
	private LandingPageDtls landingpageDetails;
	private List<UserSites> userSpecificSites;
	private IHomePageManager homePageManager;
	private Map<String, Object> sessionValues = ActionContext.getContext().getSession();

	//To open e-mail Request
	private BigInteger requestId;
	private BigInteger stage;
	private String stageName;
	private BigInteger instrumentId;
	private String queueName;
	private String procedureName;
	private String wfid;
	private String amendmentId;
	private BigDecimal bankBidId;
	private String bidFlag;
	private String bankName;
	private DashboardViewType dashboardViewType;

	/**
	 * This method redirects to the landing page depends on users role.
	 * 
	 * @return
	 * @throws IOException 
	 * @throws HWFServiceException 
	 */
	@SuppressWarnings("unchecked")
	public String execute() throws IOException, HWFServiceException {
		String forward = null;
		int minIndex = ALOCConstants.MIN_INDEX;
		List<String> userRoles = UserContext.getContext().getuserDetails().getRoles();
		String roleName = (!userRoles.isEmpty()) ? userRoles.get(ALOCConstants.BASE_VALUE) : null;
		userSpecificSites=(List<UserSites>) sessionValues.get(ALOCConstants.USERSPECIFICSITES); 
		if(userSpecificSites==null){
			userSpecificSites = homePageManager.getUserSpecificSites();
			sessionValues.put(ALOCConstants.USERSPECIFICSITES, userSpecificSites);
		}

		HttpServletRequest request = ServletActionContext.getRequest();
		String refererURL = request.getHeader(ALOCConstants.REFERER);
		if(StringUtils.isNotBlank(refererURL) && refererURL.contains(ALOCConstants.REQUESTID_EQUALS)){
			String[] requestIdArr = refererURL.split(ALOCConstants.REQUESTID_EQUALS);
			String requestId =(requestIdArr.length==ALOCConstants.EMAIL_REQUEST_LENGTH)?
					refererURL.split(ALOCConstants.REQUESTID_EQUALS)[ALOCConstants.MIN_VALUE]:null;
			if(StringUtils.isNotBlank(requestId)){
				Inbox inbox = homePageManager.getEmailRequest(requestId);
				if(inbox != null && inbox.getBankBidProcess() != null && inbox.getBankBidProcess().getBidProcess().size()>minIndex ||
						inbox != null && inbox.getTreasuryBidProcess() != null && inbox.getTreasuryBidProcess().getBidProcess().size()>minIndex ||
						inbox != null && inbox.getPendingIssuance() != null && inbox.getPendingIssuance().getDashBoards().size()>minIndex ||
						inbox != null && inbox.getHistroricalTransactions()!=null&&inbox.getHistroricalTransactions().getDashBoards().size()>minIndex){
					BidProcess bidProcess = null;
					DashBoard dashboard = null;
					Boolean isHistoricalTab = false;
					if(inbox != null && inbox.getBankBidProcess() != null && inbox.getBankBidProcess().getBidProcess().size()>minIndex){
						bidProcess = inbox.getBankBidProcess().getBidProcess().get(minIndex);
					}else if(inbox != null && inbox.getTreasuryBidProcess() != null && inbox.getTreasuryBidProcess().getBidProcess().size()>minIndex){
						bidProcess = inbox.getTreasuryBidProcess().getBidProcess().get(minIndex);
					}else if(inbox != null && inbox.getPendingIssuance() != null && inbox.getPendingIssuance().getDashBoards().size()>minIndex){
						dashboard = inbox.getPendingIssuance().getDashBoards().get(minIndex);
					}else if(inbox!=null&&inbox.getHistroricalTransactions()!=null&&inbox.getHistroricalTransactions().getDashBoards().size()>minIndex){
						dashboard = inbox.getHistroricalTransactions().getDashBoards().get(minIndex);
						isHistoricalTab = true;
					}
					if(bidProcess != null){
						this.requestId = bidProcess.getRequestId();
						this.stage = (bidProcess.getWFDetails() != null) ? bidProcess.getWFDetails().getWFStageID() : null;
						this.stageName = (bidProcess.getWFDetails() != null) ? bidProcess.getWFDetails().getWFStage() : null;
						this.instrumentId = bidProcess.getInstrumentTypeId();
						this.queueName =  (bidProcess.getWFDetails()!= null)?bidProcess.getWFDetails().getQueueName() : null;
						this.procedureName=(bidProcess.getWFDetails()!=null)?bidProcess.getWFDetails().getProcedureName():null;
						this.wfid =  (bidProcess.getWFDetails() != null) ? bidProcess.getWFDetails().getWFID() : null;
						if(instrumentId != null && instrumentId.equals(BigInteger.valueOf(InstrumentType.AMENDMENT.getId()))){
							this.amendmentId =  (bidProcess.getAmendmentId() != null) ? bidProcess.getAmendmentId().toString():null;
						}else if(instrumentId != null && instrumentId.equals(BigInteger.valueOf(InstrumentType.RIDER.getId()))){
							this.amendmentId = (bidProcess.getRiderId() != null) ? bidProcess.getRiderId().toString() : null;
						}
						this.bankBidId = bidProcess.getBankBidId();
						this.bidFlag = bidProcess.getBidFlag();
						this.bankName = bidProcess.getBankName();

						return ALOCConstants.EMAIL_REQUEST;
					}else if(dashboard != null){
						this.requestId = dashboard.getALOCRecordNumber();
						this.stage = (dashboard.getWFDetails() != null) ? dashboard.getWFDetails().getWFStageID() : null;
						this.stageName = (dashboard.getWFDetails() != null) ? dashboard.getWFDetails().getWFStage() : null;
						this.instrumentId = dashboard.getInstrumentID();
						this.queueName =  (dashboard.getWFDetails()!= null)?dashboard.getWFDetails().getQueueName() : null;
						this.procedureName=(dashboard.getWFDetails()!=null)?dashboard.getWFDetails().getProcedureName():null;
						this.wfid =  (dashboard.getWFDetails() != null) ? dashboard.getWFDetails().getWFID() : null;
						if(instrumentId != null && instrumentId.equals(BigInteger.valueOf(InstrumentType.AMENDMENT.getId()))){
							this.amendmentId =  (dashboard.getAmendmentId() != null) ? dashboard.getAmendmentId().toString():null;
						}else if(instrumentId != null && instrumentId.equals(BigInteger.valueOf(InstrumentType.RIDER.getId()))){
							this.amendmentId = (dashboard.getRiderId() != null) ? dashboard.getRiderId().toString() : null;
						}
						String reqState = dashboard.getState();
						if((isHistoricalTab == true) && reqState != null && !reqState.equalsIgnoreCase(ALOCConstants.OUTSTANDING)){
							this.dashboardViewType = DashboardViewType.ALLREQUESTS;
							return ALOCConstants.EMAIL_TAXONOMY_REQUEST;
						}
						return ALOCConstants.EMAIL_REQUEST;
					}
				}
			}
		}
		landingpageDetails = userOperationsManager.getLandingPageDetails(userRoles);
		ActionContext.getContext().getSession().put(ALOCConstants.REPORTS_ACCESS_FLAG,landingpageDetails.getReportsAccessFlag());
		UserRole role = UserRole.fromName(roleName);
		switch(role) {
		case BankOperations:
		case BankReadOnly:
			forward = ALOCConstants.BANKHOMEPAGE;
			break;
		case SuretyBrokerOperations:
		case SuretyBrokerReadOnly:
			forward = ALOCConstants.BROKERHOMEPAGE;
			break;
		}
		return forward;
	}

	/* -------------------------------------------------------------------------------------------------------------------------------- 
	 * 											PROPERTY SETTER/GETTER METHODS
	 --------------------------------------------------------------------------------------------------------------------------------- */
	/**
	 * This is used to create landingpageDetails instance object.
	 * @return
	 */
	public LandingPageDtls getLandingpageDetails() {
		return landingpageDetails;
	}
	/**
	 * This is used to set landingpageDetails instance object.
	 * @param landingpageDetails
	 */
	public void setLandingpageDetails(LandingPageDtls landingpageDetails) {
		this.landingpageDetails = landingpageDetails;
	}

	/**
	 * This is used to create homePageManager instance object.
	 * @return
	 */
	public IHomePageManager getHomePageManager() {
		return homePageManager;
	}
	/**
	 * This is used to set homePageManager instance object.
	 * @param homePageManager
	 */
	public void setHomePageManager(IHomePageManager homePageManager) {
		this.homePageManager = homePageManager;
	}
	/**
	 * This is used to get user specific sites list.
	 * @return
	 */
	public List<UserSites> getUserSpecificSites() {
		return userSpecificSites;
	}
	/**
	 * This is used to set user specific sites list.
	 * @param userSpecificSites
	 */
	public void setUserSpecificSites(List<UserSites> userSpecificSites) {
		this.userSpecificSites = userSpecificSites;
	}

	/**
	 * This is used to get requestId
	 * @return the requestId
	 */
	public BigInteger getRequestId() {
		return requestId;
	}
	/**
	 * This is used to set requestId
	 * @param requestId the requestId to set
	 */
	public void setRequestId(BigInteger requestId) {
		this.requestId = requestId;
	}

	/**
	 * This is used to get stage
	 * @return the stage
	 */
	public BigInteger getStage() {
		return stage;
	}
	/**
	 * This is used to set stage
	 * @param stage the stage to set
	 */
	public void setStage(BigInteger stage) {
		this.stage = stage;
	}

	/**
	 * This is used to get stageName
	 * @return the stageName
	 */
	public String getStageName() {
		return stageName;
	}
	/**
	 * This is used to set stageName
	 * @param stageName the stageName to set
	 */
	public void setStageName(String stageName) {
		this.stageName = stageName;
	}

	/**
	 * This is used to get instrumentId
	 * @return the instrumentId
	 */
	public BigInteger getInstrumentId() {
		return instrumentId;
	}
	/**
	 * This is used to set instrumentId
	 * @param instrumentId the instrumentId to set
	 */
	public void setInstrumentId(BigInteger instrumentId) {
		this.instrumentId = instrumentId;
	}

	/**
	 * This is used to get queueName
	 * @return the queueName
	 */
	public String getQueueName() {
		return queueName;
	}
	/**
	 * This is used to set queueName
	 * @param queueName the queueName to set
	 */
	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

	/**
	 * This is used to get procedureName
	 * @return the procedureName
	 */
	public String getProcedureName() {
		return procedureName;
	}
	/**
	 * This is used to set procedureName
	 * @param procedureName the procedureName to set
	 */
	public void setProcedureName(String procedureName) {
		this.procedureName = procedureName;
	}

	/**
	 * This is used to get wfid
	 * @return the wfid
	 */
	public String getWfid() {
		return wfid;
	}
	/**
	 * This is used to set wfid
	 * @param wfid the wfid to set
	 */
	public void setWfid(String wfid) {
		this.wfid = wfid;
	}

	/**
	 * This is used to get amendmentId
	 * @return the amendmentId
	 */
	public String getAmendmentId() {
		return amendmentId;
	}
	/**
	 * This is used to set amendmentId
	 * @param amendmentId the amendmentId to set
	 */
	public void setAmendmentId(String amendmentId) {
		this.amendmentId = amendmentId;
	}

	/**
	 * This is used to get bankBidId
	 * @return the bankBidId
	 */
	public BigDecimal getBankBidId() {
		return bankBidId;
	}
	/**
	 * This is used to set bankBidId
	 * @param bankBidId the bankBidId to set
	 */
	public void setBankBidId(BigDecimal bankBidId) {
		this.bankBidId = bankBidId;
	}

	/**
	 * This is used to get bidFlag
	 * @return the bidFlag
	 */
	public String getBidFlag() {
		return bidFlag;
	}
	/**
	 * This is used to set bidFlag
	 * @param bidFlag the bidFlag to set
	 */
	public void setBidFlag(String bidFlag) {
		this.bidFlag = bidFlag;
	}

	/**
	 * This is used to get bankName
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}
	/**
	 * This is used to set bankName
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	/**
	 * This is used to get dashboardViewType
	 * @return the dashboardViewType
	 */
	public DashboardViewType getDashboardViewType() {
		return dashboardViewType;
	}
	/**
	 * This is used to set dashboardViewType
	 * @param dashboardViewType the dashboardViewType to set
	 */
	public void setDashboardViewType(DashboardViewType dashboardViewType) {
		this.dashboardViewType = dashboardViewType;
	}

	/* -------------------------------------------------------------------------------------------------------------------------------------------------------
	 * 															DEPENDENCY INJECTION METHODS
	 ------------------------------------------------------------------------------------------------------------------------------------------------------- */

	/**
	 * Setter method for {@link IUserOperationsManager} instance.
	 * 
	 * @param authenticationMngr the authenticationMngr to set
	 */
	public void setUserOperationsManager(IUserOperationsManager authenticationMngr) {
		this.userOperationsManager = authenticationMngr;
	}

	/**
	 * Getter method for {@link IUserOperationsManager} instance.
	 * 
	 * @return the authenticationMngr
	 */
	public IUserOperationsManager getUserOperationsManager() {
		return userOperationsManager;
	}
}
