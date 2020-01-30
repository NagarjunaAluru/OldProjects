 /*
  *Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: AbstractTestCase.java
 * Purpose: AbstractTestCase used for all Action classes instances
 */

package com.ge.aloc.common;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.StrutsSpringTestCase;

import com.ge.aloc.ALOCContext;
import com.ge.aloc.MasterDataFactory;
import com.ge.aloc.StaticDataFactory;
import com.ge.aloc.action.CreateBundleAction;
import com.ge.aloc.action.ReferenceDataAction;
import com.ge.aloc.action.admin.RecordsRetentionMgmtAction;
import com.ge.aloc.action.admin.ReimbursementAgreementAction;
import com.ge.aloc.action.admin.StandardFormatMgmtAction;
import com.ge.aloc.action.admin.SuretyNameMgmtAction;
import com.ge.aloc.action.admin.SwiftMessageMonitoringAction;
import com.ge.aloc.action.admin.UserAnnouncementMgmtAction;
import com.ge.aloc.action.apm.APMDetailsAction;
import com.ge.aloc.action.apm.FeeHistoryAction;
import com.ge.aloc.action.approver.RequestApproverAction;
import com.ge.aloc.action.common.ValidateAmendmentRiderAction;
import com.ge.aloc.action.dashboard.DashboardBaseAction;
import com.ge.aloc.action.dashboard.DashboardRefDataAction;
import com.ge.aloc.action.requestor.RequestorAction;
import com.ge.aloc.action.requestor.RequestorReviewAction;
import com.ge.aloc.action.search.SearchAction;
import com.ge.aloc.action.siteadmin.BusinessAdminAction;
import com.ge.aloc.action.siteadmin.ManageSiteAction;
import com.ge.aloc.action.siteadmin.SiteAdminAction;
import com.ge.aloc.bo.RequestDetailsBO;
import com.ge.aloc.bo.SiteDetailsBO;
import com.ge.aloc.model.Reimbursement;
import com.ge.aloc.model.RequestDetails;
import com.ge.aloc.model.SiteAdmin;
import com.ge.aloc.model.StandardFormatMaster;
import com.ge.aloc.util.SiteAdminHelper;
import com.hydus.hwf.context.TestUserContext;
import com.hydus.hwf.context.UserContext;
import com.hydus.hwf.exceptions.HWFServiceException;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionProxy;

abstract public class AbstractTestCase extends StrutsSpringTestCase {
	
	private static final String[] springXmls = {"aloc-action-beans.xml","aloc-business-beans.xml", "aloc-common-beans.xml", "hwf-beans.xml"};

	/**
	 * 
	 */
	@Override
	protected void setupBeforeInitDispatcher() throws Exception {
		super.setupBeforeInitDispatcher();
		servletContext.setAttribute(StaticDataFactory.CTX_KEY, applicationContext.getBean("staticDataFactory"));
		servletContext.setAttribute(MasterDataFactory.CTX_KEY, applicationContext.getBean("masterDataFactory"));	
	}

	@Override
	protected String[] getContextLocations() {		
		return springXmls;
	}
			
	/**
	 * 
	 * @param requestId
	 * @return
	 * @throws Exception
	 */
	protected RequestDetails openRequest(Integer requestId) throws Exception {
		try {
			TestUserContext.createUserContext(request, request.getSession(), servletContext);
			ActionProxy proxy = getActionProxy("/int/requestor/openRequest");
			RequestorAction requestorAction = (RequestorAction) proxy.getAction();
			requestorAction.setRequestId(BigInteger.valueOf(requestId));
			setUserContextDetails();
			String result = requestorAction.openRequest();
			return Action.SUCCESS.equals(result)?requestorAction.getRequestDetails():null;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 *  This method is to get ApproverAction 
	 * @param action
	 * @param requestDetails
	 * @return
	 */
	protected RequestApproverAction approverAction(String action,RequestDetails requestDetails)
	{
		ActionProxy proxy = getActionProxy("/int/approver/"+action);
		RequestApproverAction approverAction = (RequestApproverAction) proxy.getAction();
		RequestDetailsBO requestDetailsBO = new RequestDetailsBO(requestDetails);
		approverAction.setRequestDetailsBO(requestDetailsBO);
		return approverAction;
	}
	
	/**
	 *  This method is to get RequestApproverAction for Taxonomy
	 * @param action
	 * @param requestDetails
	 * @return
	 */
	protected RequestApproverAction getApproverAction(String action,RequestDetails requestDetails)
	{
		ActionProxy proxy = getActionProxy("/int/"+action);
		RequestApproverAction approverAction = (RequestApproverAction) proxy.getAction();
		RequestDetailsBO requestDetailsBO = new RequestDetailsBO(requestDetails);
		ALOCContext.setActiveRequest(requestDetailsBO);
		approverAction.setRequestDetailsBO(requestDetailsBO);
		return approverAction;
	}

	/**
	 * Method to open BusinessSiteAdmin page
	 * @param actionName
	 * @return action
	 */
	protected SiteAdmin openSiteAdmin(String siteId) throws Exception
	{
		TestUserContext.createUserContext(request, request.getSession(), servletContext);
		request.setParameter("siteId", siteId);
		ActionProxy proxy = getActionProxy("/int/siteadmin/openBusinessAdmin"); 
		SiteAdminAction action = (SiteAdminAction) proxy.getAction();
		setUserContextDetails();
		action.openBusinessAdmin();
		return SiteAdminHelper.getActiveSite().getModel();
	}

	/**
	 * Method for SiteAdminAction
	 * @param actionName
	 * @return action
	 */
	protected SiteAdminAction siteAdminAction(String actionName)
	{
		ActionProxy proxy = getActionProxy("/int/siteadmin/"+actionName);
		SiteAdminAction action = (SiteAdminAction) proxy.getAction();
		return action;
	}
	
	/**
	 * Method for SiteAdminAction
	 * @param actionName
	 * @return action
	 */
	protected BusinessAdminAction businessAdminAction(String actionName){
		ActionProxy proxy = getActionProxy("/int/siteadmin/"+actionName);
		BusinessAdminAction action = (BusinessAdminAction) proxy.getAction();
		return action;
	}
	
	/**
	   * Method for ManageSiteAction
	   * @param actionName
	   * @return action
	   */
	  protected ManageSiteAction manageSiteAction(String actionName)
	  {
		   ActionProxy proxy = getActionProxy("/int/siteadmin/"+actionName);
		   ManageSiteAction manageSiteAction = (ManageSiteAction) proxy.getAction();
		   SiteAdmin siteAdmin = new SiteAdmin();
		   SiteDetailsBO siteDetailsBO = new SiteDetailsBO(siteAdmin);
		   SiteAdminHelper.setActiveSite(siteDetailsBO);
		   
		   return manageSiteAction;
	  }

	/**
	 * Method to get the createSite details
	 * @return SiteAdminAction
	 */
	protected SiteAdminAction createSite() throws Exception {

		try {
			TestUserContext.createUserContext(request, request.getSession(), servletContext);
			ActionProxy proxy = getActionProxy("/int/siteadmin/createSite");
			SiteAdminAction siteAdminAction = (SiteAdminAction) proxy.getAction(); 
			SiteAdmin siteAdmin = new SiteAdmin();
			SiteDetailsBO siteDetailsBO = new SiteDetailsBO(siteAdmin);
			siteAdminAction.setSiteDetailsBO(siteDetailsBO);
			return siteAdminAction;
		} catch (Exception e) {
			throw e;
		}
	}
	/**
	 * This is used to get the instance of Bundle Action
	 * @param action
	 * @return
	 * @throws Exception
	 */
	protected CreateBundleAction getBundleAction(String action) {
		TestUserContext.createUserContext(request, request.getSession(), servletContext);
		ActionProxy proxy = getActionProxy("/int/bundle/"+action);
		CreateBundleAction createBundleAction = (CreateBundleAction) proxy.getAction();
		return createBundleAction;
	}

	/**
	 * This is used to get the instance of Standard Format Management Action
	 * @param actionName
	 * @return
	 * @throws Exception
	 */
	protected StandardFormatMgmtAction getStdFormatMgmtAction(String actionName) throws Exception
	{
		TestUserContext.createUserContext(request);
		ActionProxy proxy = getActionProxy("/int/admin/"+actionName);
		StandardFormatMgmtAction standardFormatMgmtAction = (StandardFormatMgmtAction) proxy.getAction();
		StandardFormatMaster standardFormatMaster= new StandardFormatMaster();      
		standardFormatMgmtAction.setStandardFormatMaster(standardFormatMaster);
		return standardFormatMgmtAction;
	}

	/**
	 * This is used to get the ReimbursementAgreementAction class instance
	 * @param actionName
	 * @return
	 */

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected ReimbursementAgreementAction getReimbursementAgreementMgmtAction(String actionName)
	{
		ActionProxy proxy = getActionProxy("/int/admin/"+actionName);
		ReimbursementAgreementAction reimbursementAgreementAction = (ReimbursementAgreementAction) proxy.getAction();
		Reimbursement reimbursement = new Reimbursement();
		reimbursement.setReimburseLists(new ArrayList());	  
		return reimbursementAgreementAction;
	}


	/**
	 * Method for APMDetailsAction
	 * @param actionName
	 * @return action
	 * @throws HWFServiceException 
	 */
	protected APMDetailsAction getAPMDetailsAction(String actionName){	  
		TestUserContext.createUserContext(request, request.getSession(), servletContext);
		ActionProxy proxy = getActionProxy("/int/apm/"+actionName);
		APMDetailsAction action = (APMDetailsAction) proxy.getAction();
		return action;
	}
	
	/**
	 * Method for FeeHistoryAction
	 * @param actionName
	 * @return action
	 * @throws HWFServiceException 
	 */
	protected FeeHistoryAction getFeeHistoryAction(String actionName){
		setUserContextDetails();
		ActionProxy proxy = getActionProxy("/int/admin/"+actionName);
		FeeHistoryAction action = (FeeHistoryAction) proxy.getAction();
		return action;
	}


	/**
	 * Method for DashboardBaseAction
	 * @param actionName
	 * @return action
	 * @throws HWFServiceException 
	 */
	protected DashboardBaseAction getDashBoardBaseAction(String actionName) {	  
		TestUserContext.createUserContext(request, request.getSession(), servletContext);
		ActionProxy proxy = getActionProxy("/int/dashboard/"+actionName);
		DashboardBaseAction action = (DashboardBaseAction) proxy.getAction();
		return action;
	}


	/**
	 * Method for DashboardRefDataAction
	 * @param actionName
	 * @return action
	 * @throws HWFServiceException 
	 */
	protected DashboardRefDataAction getDashboardRefDataAction(String actionName) {	  
		TestUserContext.createUserContext(request, request.getSession(), servletContext);
		ActionProxy proxy = getActionProxy("/int/dashboard/"+actionName);
		DashboardRefDataAction action = (DashboardRefDataAction) proxy.getAction();
		return action;
	}

	/**
	 * Method for ValidateAmendmentRiderAction
	 * @param actionName
	 * @return action
	 * @throws HWFServiceException 
	 */
	protected ValidateAmendmentRiderAction getValidateAmendmentRiderAction(String actionName) {
		TestUserContext.createUserContext(request, request.getSession(), servletContext);
		ActionProxy proxy = getActionProxy("/int/"+actionName);
		ValidateAmendmentRiderAction action = (ValidateAmendmentRiderAction) proxy.getAction();
		return action;
	}

	/**
	 * Method for SearchAction
	 * @param actionName
	 * @return action
	 * @throws HWFServiceException 
	 */
	protected SearchAction getSearchAction(String actionName) throws HWFServiceException {
		TestUserContext.createUserContext(request, request.getSession(), servletContext);  
		ActionProxy proxy = getActionProxy("/int/dashboard/"+actionName);
		SearchAction action = (SearchAction) proxy.getAction();
		return action;
	}

	/**
	 * Method for UserAnnouncementMgmtAction
	 * @param actionName
	 * @return action
	 */
	protected UserAnnouncementMgmtAction getUserAnnoucementAction(String actionName) {	  
		ActionProxy proxy = getActionProxy("/int/admin/"+actionName);
		UserAnnouncementMgmtAction action = (UserAnnouncementMgmtAction) proxy.getAction();
		return action;
	}

	/**
	 * Method for RecordsRetentionMgmtAction
	 * @param actionName
	 * @return action
	 */
	protected RecordsRetentionMgmtAction getRecordRetentionAction(String actionName) {

		ActionProxy proxy = getActionProxy("/int/admin/"+actionName);
		RecordsRetentionMgmtAction action = (RecordsRetentionMgmtAction) proxy.getAction();
		return action;
	}

	/**
	 * Method for SwiftMessageMonitoringAction
	 * @param actionName
	 * @return action
	 */
	protected SwiftMessageMonitoringAction getSwiftMsgMonitorAction(String actionName) {
		ActionProxy proxy = getActionProxy("/int/admin/"+actionName);
		SwiftMessageMonitoringAction action = (SwiftMessageMonitoringAction) proxy.getAction();
		return action;
	}

	/**
	 * Method for ReferenceDataAction
	 * @param nameSpace
	 * @param actionName
	 * @return action
	 * @throws HWFServiceException 
	 */
	protected ReferenceDataAction referenceDataAction(String nameSpace,String action) {	
		TestUserContext.createUserContext(request, request.getSession(), servletContext);
		ActionProxy proxy = getActionProxy(nameSpace+action);
		ReferenceDataAction referenceDataAction = (ReferenceDataAction) proxy.getAction();
		return referenceDataAction;
	}
  
  /**
   * Method to get the SuretyNameManagementAction object instance 
   * @param actionName
   * @return action
   */
  protected SuretyNameMgmtAction suretyNameMgmtAction(String action)
  {	
	   TestUserContext.createUserContext(request);
	   ActionProxy proxy = getActionProxy("/int/admin/"+action);
	   SuretyNameMgmtAction suretyNameMgmtAction = (SuretyNameMgmtAction) proxy.getAction();
	   return suretyNameMgmtAction;
  }
  
  /**
   * Method to set the user context details 
   */
  public void setUserContextDetails()
  {
	  List<String> rolesList = new ArrayList<String>();
	  rolesList.add("TreasuryAnalyst");
	  UserContext.getContext().getuserDetails().setUserId("999911248");
	  UserContext.getContext().getuserDetails().setLastName("TreasuryAnalyst_999911248");
	  UserContext.getContext().getuserDetails().setFirstName("Test_999911248");
	  UserContext.getContext().getuserDetails().setRoles(rolesList);
  }
  
  /**
	 * Method for RequestorReviewAction
	 * @param nameSpace
	 * @param actionName 
	 * @return action
	 * @throws HWFServiceException 
	 */
	protected RequestorReviewAction requestorReviewAction(String action) {	
		ActionProxy proxy = getActionProxy("/int/requestor/review/"+action);
		RequestorReviewAction requestorReviewAction = (RequestorReviewAction) proxy.getAction();
		return requestorReviewAction;
	}
	
	/**
	 * Method for RequestorReviewAction
	 * @param nameSpace
	 * @param actionName
	 * @return action
	 * @throws HWFServiceException 
	 */
	protected RequestorAction getRequestorAction(String action) {
		TestUserContext.createUserContext(request, request.getSession(), servletContext);
		ActionProxy proxy = getActionProxy("/int/requestor/"+action);
		RequestorAction requestorAction = (RequestorAction) proxy.getAction();
		return requestorAction;
	}
}
