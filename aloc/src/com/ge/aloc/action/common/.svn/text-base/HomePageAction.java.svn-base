/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: HomePageAction.java
 * Purpose: HomePageAction used for work flow users and it admins  to login and start a session.
 */
package com.ge.aloc.action.common;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.ge.aloc.InstrumentType;
import com.ge.aloc.UserRole;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.manager.common.IHomePageManager;
import com.ge.aloc.model.DashBoard;
import com.ge.aloc.model.Inbox;
import com.ge.aloc.model.LandingPageDtls;
import com.ge.aloc.model.StaticDataManagement.UserSites;
import com.hydus.hwf.context.UserContext;
import com.hydus.hwf.exceptions.HWFServiceException;
import com.hydus.hwf.util.StringUtils;
import com.opensymphony.xwork2.ActionContext;

/**
 * Action class for work flow users and it admins  to login and start a session
 * 
 * @see: specify the class names to check
 */
public class HomePageAction {

	private IHomePageManager homePageManager;
	private LandingPageDtls landingpageDetails;
	private List<UserSites> userSpecificSites;
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

	/**
	 * Decides landing page based on logged in user. 
	 */
	@SuppressWarnings("unchecked")
	public String execute() throws HWFServiceException {
		String forward = ALOCConstants.ROLES_NOT_FOUND;

		List<String> userRoles = UserContext.getContext().getuserDetails().getRoles();
		if(!userRoles.isEmpty()) {
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
							if(inbox!=null&&inbox.getMyTransactions()!=null&&inbox.getMyTransactions().getDashBoards().size()>ALOCConstants.MIN_INDEX){
								DashBoard dashboardDet = inbox.getMyTransactions().getDashBoards().get(ALOCConstants.MIN_INDEX);
								if(dashboardDet != null){
									this.requestId = dashboardDet.getALOCRecordNumber();
									this.stage = (dashboardDet.getWFDetails() != null) ? dashboardDet.getWFDetails().getWFStageID() : null;
									this.stageName = (dashboardDet.getWFDetails() != null) ? dashboardDet.getWFDetails().getWFStage() : null;
									this.instrumentId = dashboardDet.getInstrumentID();
									this.queueName =  (dashboardDet.getWFDetails()!= null)?dashboardDet.getWFDetails().getQueueName() : null;
									this.procedureName=(dashboardDet.getWFDetails()!=null)?dashboardDet.getWFDetails().getProcedureName():null;
									this.wfid =  (dashboardDet.getWFDetails() != null) ? dashboardDet.getWFDetails().getWFID() : null;
									if(instrumentId != null && instrumentId.equals(BigInteger.valueOf(InstrumentType.AMENDMENT.getId()))){
										this.amendmentId =  dashboardDet.getAmendmentId();
									}else if(instrumentId != null && instrumentId.equals(BigInteger.valueOf(InstrumentType.RIDER.getId()))){
										this.amendmentId = dashboardDet.getRiderId();
									}
									return ALOCConstants.EMAIL_REQUEST;
								}
							}
						}
			}
			landingpageDetails = homePageManager.getLandingPageDetails(userRoles);
			ActionContext.getContext().getSession().put(ALOCConstants.REPORTS_ACCESS_FLAG,landingpageDetails.getReportsAccessFlag());
			if(userRoles.contains(UserRole.TreasuryAnalyst.getName()) 
					|| userRoles.contains(UserRole.TreasuryApprover.getName())) {
				forward = ALOCConstants.TREASURYHOMEPAGE;
			}else if(userRoles.contains(UserRole.Requestor.getName()) 
					|| userRoles.contains(UserRole.Approver.getName())
					|| userRoles.contains(UserRole.SiteAdmin.getName())
					|| userRoles.contains(UserRole.ReadOnly.getName())) {
				forward = ALOCConstants.BUSINESSHOMEPAGE;
			} 
		}

		return forward;
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
	 * This is used to get requestId value.
	 * @return the requestId
	 */
	public BigInteger getRequestId() {
		return requestId;
	}
	/**
	 *  This is used to set requestId
	 * @param requestId the requestId to set
	 */
	public void setRequestId(BigInteger requestId) {
		this.requestId = requestId;
	}
	/**
	 *  This is used to get stage value
	 * @return the stage
	 */
	public BigInteger getStage() {
		return stage;
	}
	/**
	 *  This is used to set stage value
	 * @param stage the stage to set
	 */
	public void setStage(BigInteger stage) {
		this.stage = stage;
	}
	/**
	 *  This is used to get stageName
	 * @return the stageName
	 */
	public String getStageName() {
		return stageName;
	}
	/**
	 *  This is used to set stageName
	 * @param stageName the stageName to set
	 */
	public void setStageName(String stageName) {
		this.stageName = stageName;
	}
	/**
	 *  This is used to get instrumentId
	 * @return the instrumentId
	 */
	public BigInteger getInstrumentId() {
		return instrumentId;
	}
	/**
	 *  This is used to set instrumentId
	 * @param instrumentId the instrumentId to set
	 */
	public void setInstrumentId(BigInteger instrumentId) {
		this.instrumentId = instrumentId;
	}
	/**
	 *  This is used to get queueName
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
	 * This is used to get amendmentId
	 * @param amendmentId the amendmentId to set
	 */
	public void setAmendmentId(String amendmentId) {
		this.amendmentId = amendmentId;
	}

}