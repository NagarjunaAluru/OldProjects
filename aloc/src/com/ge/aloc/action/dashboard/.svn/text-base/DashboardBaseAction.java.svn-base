/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: DashboardBaseAction.java
 * Purpose: DashboardBaseAction used for the default operations
 */
package com.ge.aloc.action.dashboard;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.ge.aloc.DashboardViewType;
import com.ge.aloc.UserRole;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.manager.dashboard.IDashboardManager;
import com.ge.aloc.model.GlanceDetails;
import com.ge.aloc.model.Inbox;
import com.ge.aloc.model.Inbox.DashBoardTabsCount;
import com.ge.aloc.model.MsgHeader;
import com.ge.aloc.model.NameValue;
import com.ge.aloc.model.RequestDetails;
import com.ge.aloc.model.Search;
import com.ge.aloc.model.SiteAdminStaticData.SitesList;
import com.ge.aloc.model.StaticDataManagement.UserSites;
import com.ge.aloc.util.ALOCCommonHelper;
import com.hydus.hwf.context.UserContext;
import com.hydus.hwf.exceptions.ErrorData;
import com.hydus.hwf.exceptions.HWFException;
import com.hydus.hwf.exceptions.HWFServiceException;
import com.hydus.hwf.exceptions.IErrorHandler;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author chaitanya.n
 * 
 */
public class DashboardBaseAction extends ActionSupport {

	private static final long serialVersionUID = 3417380466820678635L;
	
	protected Inbox results;
	protected String siteId;
	protected Integer searchCriteriaType;
	protected String searchCriteriaText;
	protected List<RequestDetails> searchResult;
	protected DashboardViewType dashboardViewType;
	protected Search searchCriteria;
	private List<SitesList> childSitesList = new ArrayList<SitesList>();
	private String requestId;
	private String bundleId;
	private String beneficiaryName;
	private String bundleTransactionState;
	private IDashboardManager dashboardManager;
	private HttpServletRequest request = ServletActionContext.getRequest();
	private Map<String, Object> sessionValues = ActionContext.getContext().getSession();
	private List<UserSites> userSpecificSitesList;
	private List<NameValue> selectedsiteList = new ArrayList<NameValue>();
	protected IErrorHandler errorHandler;
	private String errorMsg;

	/*
	 * -------------------------------------------------------------- Start Dash
	 * Board Common actions *
	 * --------------------------------------------------------------
	 */

	/**
	 * This method is used to get default display tab name.
	 * 
	 * @return
	 */
	public String getDefaultDisplayTabName() {
		return null;
	}

	/**
	 * 
	 * Method to save default dashboard view
	 * 
	 * @return
	 * @throws HWFServiceException
	 * @throws IOException
	 */
	public String saveDefaultView() throws HWFServiceException, IOException {
		String type = request.getParameter(ALOCConstants.DEFAULT_VIEW);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType(ALOCConstants.MIMETYPE_TEXT_STRING);
		dashboardManager.saveDefaultDisplayTabName(type);
		response.getWriter().print(ALOCConstants.DV_SUCCESS_MSG);
		return null;
	}

	/**
	 * Method to display Dashboard Details of all types
	 * 
	 * @return
	 * @throws HWFServiceException
	 */
	@SuppressWarnings("unchecked")
	public String display() throws HWFServiceException {
		HttpSession session = ServletActionContext.getRequest().getSession();
		String msg = (String) session.getAttribute(ALOCConstants.SUCCESSMSG);
		if(msg != null && !msg.isEmpty()) {
			addActionMessage(msg);
			session.removeAttribute(ALOCConstants.SUCCESSMSG);
		}
		String errMsg = (String) session.getAttribute(ALOCConstants.ERROR);//Common code for all Error Messages Display.
		if(errMsg != null && !errMsg.isEmpty()) {
			this.errorMsg = errMsg;
			session.removeAttribute(ALOCConstants.ERROR);
		}
		
		try {
			if (dashboardViewType != null) {
				if (dashboardViewType != DashboardViewType.ALLREQUESTS && dashboardViewType != DashboardViewType.TREASURYBANKHIST
						&& dashboardViewType != DashboardViewType.TREASURYBROKERHIST) {
					results = dashboardManager.loadDashboardData(dashboardViewType);
					//String Flag="Y";
					String Flag=ALOCConstants.DashBoard_Y;   
					System.out.println("dashboard base action---------------------------"+Flag);
					session.setAttribute("Flag",Flag);
					DashBoardTabsCount dashBoardTabsCount = results.getDashBoardTabsCount();
					DashBoardTabsCount sessionDashBoardTabsCount = (DashBoardTabsCount) sessionValues.get(ALOCConstants.DASHBOARD_TABS_COUNT);
					if(!(dashBoardTabsCount != null) && !(sessionDashBoardTabsCount != null)){
						Inbox inboxResults = dashboardManager.loadDefaultDashboardData();
						results.setDashBoardTabsCount(inboxResults.getDashBoardTabsCount());
						results.setGlanceDetails(inboxResults.getGlanceDetails());
					}
					ALOCCommonHelper.setGlanceDetails(results, sessionValues);
					ALOCCommonHelper.setDashboardTabCount(results, sessionValues);
					ALOCCommonHelper.setHeaderOpcode(results, sessionValues);
				} else {
					results = new Inbox();
					GlanceDetails glanceDetails = (GlanceDetails) sessionValues
							.get(ALOCConstants.GLANCE_DETAILS);
					results.setGlanceDetails(glanceDetails);
					DashBoardTabsCount dashBoardTabsCount = (DashBoardTabsCount) sessionValues
							.get(ALOCConstants.DASHBOARD_TABS_COUNT);
					if (dashBoardTabsCount == null) {
						results = dashboardManager.loadDefaultDashboardData();
						ALOCCommonHelper.setGlanceDetails(results, sessionValues);
						ALOCCommonHelper.setDashboardTabCount(results, sessionValues);
					} else {
						results.setDashBoardTabsCount(dashBoardTabsCount);
					}
					MsgHeader msgHeader = (MsgHeader) sessionValues
							.get(ALOCConstants.DASHBOARD_HEADEROPCODE);
					results.setMsgHeader(msgHeader);
				}

			} else {
				results = dashboardManager.loadDefaultDashboardData();
				if (results.getDefaultView() == null) {
					List<String> userRoles = UserContext.getContext()
							.getuserDetails().getRoles();
					if (userRoles.contains(UserRole.BankOperations.getName())
							|| userRoles.contains(UserRole.BankReadOnly
									.getName())) {
						dashboardViewType = DashboardViewType.BANKBIDPROCESS;
					} else if (userRoles
							.contains(UserRole.SuretyBrokerOperations.getName())
							|| userRoles.contains(UserRole.SuretyBrokerReadOnly
									.getName())) {
						dashboardViewType = DashboardViewType.TREASURYBROKERBIDPROCESS;
					} else if (userRoles.contains(UserRole.ReadOnly.getName())) {
						dashboardViewType = DashboardViewType.ALLREQUESTS;
					} else {
						dashboardViewType = DashboardViewType.MYTRANSACTIONS;
					}
				} else {
					dashboardViewType = DashboardViewType.valueOf(results
							.getDefaultView());
				}
				ALOCCommonHelper.setGlanceDetails(results, sessionValues);
				ALOCCommonHelper.setDashboardTabCount(results, sessionValues);
				ALOCCommonHelper.setHeaderOpcode(results, sessionValues);
			}
			userSpecificSitesList = (List<UserSites>) sessionValues
					.get(ALOCConstants.USERSPECIFICSITES);
			if (sessionValues.get(ALOCConstants.IS_FINANCIAL_BUSINESS) == null) {
				sessionValues.put(ALOCConstants.IS_FINANCIAL_BUSINESS,
						ALOCCommonHelper
								.isFinancialBusiness(userSpecificSitesList));
			}
			if (sessionValues.get(ALOCConstants.IS_INDUSTRIAL_BUSINESS) == null) {
				sessionValues.put(ALOCConstants.IS_INDUSTRIAL_BUSINESS,
						ALOCCommonHelper
								.isIndustrialBusiness(userSpecificSitesList));
			}
		} catch (HWFServiceException hse) {
			ErrorData errorData = errorHandler.handle(hse);
			this.errorMsg = errorData.getCause().getMessage();
			return SUCCESS;
		}

		return SUCCESS;
	}

	/**
	 * Method to get the my transactions details based on glance selection
	 * 
	 * @return
	 * @throws HWFServiceException
	 */
	@SuppressWarnings("unchecked")
	public String getGlanceDetails() throws HWFServiceException {
		try {
			results = dashboardManager.getGlanceDetails();
			List<String> userRoles = UserContext.getContext().getuserDetails().getRoles();
			ALOCCommonHelper.setGlanceDetails(results, sessionValues);
			ALOCCommonHelper.setDashboardTabCount(results,sessionValues);
			ALOCCommonHelper.setHeaderOpcode(results, sessionValues);
			results.getDashBoardTabsCount().setMyTransCount(new BigInteger(String.valueOf(results.getMyTransactions().getDashBoards().size())));
			userSpecificSitesList = (List<UserSites>) sessionValues.get(ALOCConstants.USERSPECIFICSITES);
			if (sessionValues.get(ALOCConstants.IS_FINANCIAL_BUSINESS) == null) {
				sessionValues.put(ALOCConstants.IS_FINANCIAL_BUSINESS,
						ALOCCommonHelper.isFinancialBusiness(userSpecificSitesList));
			}
			if (sessionValues.get(ALOCConstants.IS_INDUSTRIAL_BUSINESS) == null) {
				sessionValues.put(ALOCConstants.IS_INDUSTRIAL_BUSINESS,
						ALOCCommonHelper.isIndustrialBusiness(userSpecificSitesList));
			}
			if (userRoles.contains(UserRole.BankOperations.getName())
					|| userRoles.contains(UserRole.BankReadOnly.getName())) {
				dashboardViewType = DashboardViewType.BANKBIDPROCESS;

			} else if (userRoles.contains(UserRole.SuretyBrokerOperations.getName())
					|| userRoles.contains(UserRole.SuretyBrokerReadOnly.getName())) {
				dashboardViewType = DashboardViewType.TREASURYBROKERBIDPROCESS;
			} else {
				if (results.getMsgHeader() != null && results.getMsgHeader().getOpcode() != null
						&& results.getMsgHeader().getOpcode().equalsIgnoreCase(ALOCConstants.MYTRANSACTION)) {
					dashboardViewType = DashboardViewType.MYTRANSACTIONS;
				} else {
					dashboardViewType = DashboardViewType.TREASURYBIDPROCESS;
				}
			}
		} catch (HWFServiceException hse) {
			ErrorData errorData = errorHandler.handle(hse);
			this.errorMsg = errorData.getCause().getMessage();
			return SUCCESS;
		}
		return SUCCESS;
	}

	/**
	 * Method to delete request from Dashboard
	 * 
	 * @return
	 * @throws HWFException
	 */
	public String deleteRequest() throws HWFException {
		dashboardManager.deleteRequest(requestId);
		return SUCCESS;
	}

	/**
	 * Method to enable the selected Model
	 * 
	 * @return
	 * @throws HWFServiceException
	 */
	public String enableModel() throws HWFServiceException {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			String requestId = request.getParameter(ALOCConstants.MODEL_REQUEST_ID);
			results = dashboardManager.enableModel(dashboardViewType, requestId);
		} catch (HWFServiceException hse) {
			ErrorData errorData = errorHandler.handle(hse);
			this.errorMsg = errorData.getCause().getMessage();
			return SUCCESS;
		}
		return SUCCESS;
	}

	/**
	 * Method to disable the selected Model
	 * 
	 * @return
	 * @throws HWFServiceException
	 */
	public String disableModel() throws HWFServiceException {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			String requestId = request.getParameter(ALOCConstants.MODEL_REQUEST_ID);
			results = dashboardManager.disableModel(dashboardViewType, requestId);
		}catch(HWFServiceException hse){	
			ErrorData errorData = errorHandler.handle(hse);
			this.errorMsg = errorData.getCause().getMessage();				
			return SUCCESS;
		}
		return SUCCESS;
	}

	/**
	 * Method to delete the selected Model
	 * 
	 * @return
	 * @throws HWFServiceException
	 */
	public String deleteModel() throws HWFServiceException {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			String requestId = request.getParameter(ALOCConstants.MODEL_REQUEST_ID);
			results = dashboardManager.deleteModel(dashboardViewType, requestId);
		}catch(HWFServiceException hse){	
			ErrorData errorData = errorHandler.handle(hse);
			this.errorMsg = errorData.getCause().getMessage();				
			return SUCCESS;
		}
		return SUCCESS;
	}

	/**
	 * Method to get all requests details for selected Bundle
	 * 
	 * @return
	 * @throws HWFServiceException
	 */
	public String getAllRequestInfoForSelBundle() throws HWFServiceException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String bundleId = request.getParameter(ALOCConstants.BUNDLEID);
		try {
		if (dashboardViewType != null) {
			results = dashboardManager.getAllRequestInfoForSelBundle(dashboardViewType, bundleId);
			List<RequestDetails> reqDetailsList = results.getBundle().getRequestDetails();
			for (RequestDetails requestDetails : reqDetailsList) {
				if (requestDetails.getBeneficiaryDetails() != null && requestDetails.getBeneficiaryDetails().getAddressDtls() != null
						&& requestDetails.getBeneficiaryDetails().getAddressDtls().getName() != null){
					this.beneficiaryName = requestDetails.getBeneficiaryDetails().getAddressDtls().getName();}
				else if (requestDetails.getTransactionParties() != null	&& requestDetails.getTransactionParties().getCustomer()!= null
						&& requestDetails.getTransactionParties().getCustomer().getAddressDtls() != null
						&& requestDetails.getTransactionParties().getCustomer().getAddressDtls().getName() != null){
					this.beneficiaryName = requestDetails.getTransactionParties().getCustomer().getAddressDtls().getName();}
				bundleTransactionState = requestDetails.getBundleDetails().getTransactionState();
				if (StringUtils.isNotBlank(beneficiaryName))
					break;
			}
		}}catch(HWFServiceException hse){	
			ErrorData errorData = errorHandler.handle(hse);
			this.errorMsg = errorData.getCause().getMessage();				
			return SUCCESS;
		}
		return SUCCESS;
	}

	/*
	 * -------------------------------------------------------------- End Dash
	 * Board Common actions *
	 * --------------------------------------------------------------
	 */

	/**
	 * This method is used to get the results instance object.
	 * 
	 * @return the results
	 */
	public Inbox getResults() {
		return results;
	}

	/**
	 * This method is used to create the results instance object.
	 * 
	 * @param results
	 *            the results to set
	 */
	public void setResults(Inbox results) {
		this.results = results;
	}

	/**
	 * This method is used to get the searchResult list.
	 * 
	 * @return the searchResult
	 */
	public List<RequestDetails> getSearchResult() {
		return searchResult;
	}

	/**
	 * This method is used to set the searchResult list.
	 * 
	 * @param searchResult
	 *            the searchResult to set
	 */
	public void setSearchResult(List<RequestDetails> searchResult) {
		this.searchResult = searchResult;
	}

	/**
	 * This method is used to get the dashboardViewType instance object.
	 * 
	 * @return the dashboardViewType
	 */
	public DashboardViewType getDashboardViewType() {
		return dashboardViewType;
	}

	/**
	 * This method is used to create the dashboardViewType instance object.
	 * 
	 * @param dashboardViewType
	 *            the dashboardViewType to set
	 */
	public void setDashboardViewType(DashboardViewType dashboardViewType) {
		this.dashboardViewType = dashboardViewType;
	}

	/**
	 * This method is used to get the dashboardManager instance object.
	 * 
	 * @return the dashboardManager
	 */
	public IDashboardManager getDashboardManager() {
		return dashboardManager;
	}

	/**
	 * This method is used to create the dashboardManager instance object.
	 * 
	 * @param dashboardManager
	 *            the dashboardManager to set
	 */
	public void setDashboardManager(IDashboardManager dashboardManager) {
		this.dashboardManager = dashboardManager;
	}

	/**
	 * This method is used to get the siteId value.
	 * 
	 * @return the search
	 */
	public String getSiteId() {
		return siteId;
	}

	/**
	 * This method is used to set the siteId value.
	 * 
	 * @param search
	 *            the search to set
	 */
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	/**
	 * This method is used to get the searchCriteria Type.
	 * 
	 * @return the searchCriteriaType
	 */
	public Integer getSearchCriteriaType() {
		return searchCriteriaType;
	}

	/**
	 * This method is used to set the searchCriteria Type.
	 * 
	 * @param searchCriteriaType
	 *            the searchCriteriaType to set
	 */
	public void setSearchCriteriaType(Integer searchCriteriaType) {
		this.searchCriteriaType = searchCriteriaType;
	}

	/**
	 * This method is used to get the searchCriteria Text.
	 * 
	 * @return the searchCriteriaText
	 */
	public String getSearchCriteriaText() {
		return searchCriteriaText;
	}

	/**
	 * This method is used to set the searchCriteria Text.
	 * 
	 * @param searchCriteriaText
	 *            the searchCriteriaText to set
	 */
	public void setSearchCriteriaText(String searchCriteriaText) {
		this.searchCriteriaText = searchCriteriaText;
	}

	/**
	 * This method is used to get the searchCriteria value.
	 * 
	 * @return the searchCriteria
	 */
	public Search getSearchCriteria() {
		return searchCriteria;
	}

	/**
	 * @return the bundleTransactionState
	 */
	public String getBundleTransactionState() {
		return bundleTransactionState;
	}

	/**
	 * @param bundleTransactionState
	 *            the bundleTransactionState to set
	 */
	public void setBundleTransactionState(String bundleTransactionState) {
		this.bundleTransactionState = bundleTransactionState;
	}

	/**
	 * This method is used to set the searchCriteria value.
	 * 
	 * @param searchCriteria
	 *            the searchCriteria to set
	 */
	public void setSearchCriteria(Search searchCriteria) {
		this.searchCriteria = searchCriteria;
	}

	/**
	 * This method is used to get the Child List.
	 * 
	 * @return the childSitesList
	 */
	public List<SitesList> getChildSitesList() {
		return childSitesList;
	}

	/**
	 * This method is used to set the Child List
	 * 
	 * @param childSitesList
	 *            the childSitesList to set
	 */
	public void setChildSitesList(List<SitesList> childSitesList) {
		this.childSitesList = childSitesList;
	}

	/**
	 * This method is used to get requestId value.
	 * 
	 * @return the requestId
	 */
	public String getRequestId() {
		return requestId;
	}

	/**
	 * This method is used to set the requestId value.
	 * 
	 * @param requestId
	 *            the requestId to set
	 */
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	/**
	 * This method is used to get the bundleId value.
	 * 
	 * @return the bundleId
	 */
	public String getBundleId() {
		return bundleId;
	}

	/**
	 * This method is used to set the bundleId value.
	 * 
	 * @param bundleId
	 *            the bundleId to set
	 */
	public void setBundleId(String bundleId) {
		this.bundleId = bundleId;
	}

	/**
	 * This method is used to get the beneficiaryName value.
	 * 
	 * @return the beneficiaryName
	 */
	public String getBeneficiaryName() {
		return beneficiaryName;
	}

	/**
	 * This method is used to set the beneficiaryName value.
	 * 
	 * @param beneficiaryName
	 *            the beneficiaryName to set
	 */
	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}

	/**
	 * This method is used to get the userSpecificSites List.
	 * 
	 * @return the userSpecificSiteesList
	 */
	public List<UserSites> getUserSpecificSitesList() {
		return userSpecificSitesList;
	}

	/**
	 * This method is used to set the userSpecificSites List.
	 * 
	 * @param userSpecificSitesList
	 *            the userSpecificSitesList to set
	 */
	public void setUserSpecificSitesList(List<UserSites> userSpecificSitesList) {
		this.userSpecificSitesList = userSpecificSitesList;
	}

	/**
	 * This method is used to get the session object instance
	 * 
	 * @return the sessionValues
	 */
	public Map<String, Object> getSessionValues() {
		return sessionValues;
	}

	/**
	 * This method is used to set the session object instance
	 * 
	 * @param sessionValues
	 *            the sessionValues to set
	 */
	public void setSessionValues(Map<String, Object> sessionValues) {
		this.sessionValues = sessionValues;
	}

	/**
	 * This method is used to get the request object instance
	 * 
	 * @return the request
	 */
	public HttpServletRequest getRequest() {
		return request;
	}

	/**
	 * This method is used to set the request object instance
	 * 
	 * @param request
	 *            the request to set
	 */
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 * This method is used to get the selected site list
	 * 
	 * @return the selectedsiteList
	 */
	public List<NameValue> getSelectedsiteList() {
		return selectedsiteList;
	}

	/**
	 * This method is used to set the selected site list
	 * 
	 * @param selectedsiteList
	 *            the selectedsiteList to set
	 */
	public void setSelectedsiteList(List<NameValue> selectedsiteList) {
		this.selectedsiteList = selectedsiteList;
	}

	/**
	 * @return the errorHandler
	 */
	public IErrorHandler getErrorHandler() {
		return errorHandler;
	}

	/**
	 * @param errorHandler
	 *            the errorHandler to set
	 */
	public void setErrorHandler(IErrorHandler errorHandler) {
		this.errorHandler = errorHandler;
	}

	/**
	 * @return the errorMsg
	 */
	public String getErrorMsg() {
		return errorMsg;
	}

	/**
	 * @param errorMsg
	 *            the errorMsg to set
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
}
