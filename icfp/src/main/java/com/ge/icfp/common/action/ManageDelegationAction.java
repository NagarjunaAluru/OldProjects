/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: ManageDelegationAction.java
 * Purpose: ManageDelegationAction used for managing delegate.
 */
package com.ge.icfp.common.action;

import static com.ge.icfp.common.constants.ICFPConstants.FAILUREMSG;
import static com.ge.icfp.common.constants.ICFPConstants.GET;
import static com.ge.icfp.common.constants.ICFPConstants.ICFFO_READONLY;
import static com.ge.icfp.common.constants.ICFPConstants.INSERT;
import static com.ge.icfp.common.constants.ICFPConstants.MM_DD_YYYY;
import static com.ge.icfp.common.constants.ICFPConstants.ROLEINFO;
import static com.ge.icfp.common.constants.ICFPConstants.UPDATE;
import static com.ge.icfp.common.constants.ICFPConstants.UPDATEMESSAGE;
import static com.ge.icfp.common.constants.ICFPConstants.USER_MGMT;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.axis.utils.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import com.ge.icfp.action.ICFPBaseAction;
import com.ge.icfp.action.ICFPException;
import com.ge.icfp.common.constants.ICFPConstants;
import com.ge.icfp.common.vo.DelegationVO;
import com.ge.icfp.model.Delegation;
import com.ge.icfp.model.DelegationRequest;
import com.ge.icfp.model.MsgHeader;
import com.ge.icfp.model.RoleInfo;
import com.ge.icfp.model.UserInformation;
import com.ge.icfp.util.SecurityHelper;
import com.ge.icfp.util.UserRole;
import com.hydus.wff.common.bw.ServiceClient;
import com.hydus.wff.core.context.UserContext;
import com.hydus.wff.core.exception.HWFServiceException;
import com.hydus.wff.core.exception.HWFStubException;
import com.hydus.wff.core.session.SessionManager;
/**
 * Manages the delegate user for a deal
 *  
 *
 */
public class ManageDelegationAction extends ICFPBaseAction {
	private static final String DELEGATE = "_Delegate";
	private static final String _IDAG = "_IDAG";
	private static final String _TESG_DELEGATE = "_TESG_Delegate";
	private static final String _TESG_MEMBER = "_TESG_Member";
	private static final String HAS_BEEN_REVOKED_SUCCESSFULLY = " has been Revoked Successfully";
	private static final String ROLE_NAME = "Role Name ";
	private static final String BEGIN_MANAGE_DELEGATION_ACTION_REVOKE_DELEGATION = "Begin - ManageDelegationAction.revokeDelegation()";
	private static final String SAVE_ROLES = "saveRoles";
	private static final String SUCCESS = "Success";
	private static final String ROLES_DELEGATED_SUCCESSFULLY = "Roles Delegated Successfully";
	private static final String PLEASE_INPUT_APPROPRIATE_VALUE = "Please Input Appropriate Value";
	private static final String USER_DELEGATE_ID = "userDelegateId";
	private static final String DELEGATOR_FIRST_NAMES = "delegatorFirstNames";
	private static final String DELEGATOR_LAST_NAMES = "delegatorLastNames";
	private static final String DELEGATOR_SSOID = "delegatorSSOID";
	private static final String INSERT_UPDATE = "insertUpdate";
	private static final String DELEGATE_TO_DATE = "delegateToDate";
	private static final String DELEGATE_FROM_DATE = "delegateFromDate";
	private static final String DELEGATE_LAST_NAMES = "delegateLastNames";
	private static final String DELEGATE_FIRST_NAMES = "delegateFirstNames";
	private static final String DELEGATE_SSOID = "delegateSSOID";
	private static final String ROLE_NAMES = "roleNames";
	private static final String ROLE_IDS = "roleIds";
	private static final String NO_OF_ROLES = "noOfRoles";
	private static final String BEGIN_MANAGE_DELEGATION_ACTION_SAVE_DELEGATION = "Begin - ManageDelegationAction.saveDelegation()";
	private static final String OPEN_MANAGE_ROLES = "openManageRoles";
	private static final String OPEN_ADMIN_MANAGE_ROLES = "openAdminManageDelegations";
	private static final String USER_GROUPS = "userGroups";
	private static final String USER_DELEGATION = "userDelegation";
	private static final String DELEGATION2 = "DELEGATION";
	private static final String DELEGATE_SSO_ID = "delegateSSO";
	private static final String BEGIN_MANAGE_DELEGATION_ACTION_OPEN_MANAGE_DELEGATIONS = "Begin - ManageDelegationAction.openManageDelegations()";
	private static final Logger LOGGER = Logger.getLogger(ManageDelegationAction.class);
	private static final String CAN_DELEGATE = "canDelegate"; 
	private static final String SAVE_ADMIN_DELEGATION_ROLES = "saveaAdminDelegationRoles";
	private static final String MANAGE_DELEGATION = "manageDelegation";
	private ServiceClient serviceClient;
	private SecurityHelper securityHelper;

	/**
	 * Open Manage delegate screen with all the possible delegate person that 
	 * can be selected. 
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HWFServiceException
	 * @throws HWFStubException
	 */
	public ActionForward openManageDelegations(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HWFServiceException,
			HWFStubException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(BEGIN_MANAGE_DELEGATION_ACTION_OPEN_MANAGE_DELEGATIONS);
		}
		DelegationRequest delegationRequest = new DelegationRequest();
		List<String> roles = SessionManager.getRoles(request);
		List<Delegation> delegationList = new ArrayList<Delegation>();
		Delegation delegation = new Delegation();
		delegation.setDelegateOpcode(GET);
		delegation.setRoleName(getRoles(roles));
		delegation.setRoleId(getRoleIds(roles));
		delegation.setDelegatorSSO(SessionManager.getUserID(request));
		delegationList.add(delegation);
		delegationRequest.setDelegations(delegationList);
		delegationRequest = serviceClient.invokeService(DELEGATION2, delegationRequest, DelegationRequest.class);
		
		String[] notApplicableRoles = new String[]
				{ UserRole.FrontOffice_Member.getName(), 
				  UserRole.CashManagement_Member.getName(),
				  UserRole.MiddleOffice_Member.getName(),
				  UserRole.TransferPricing_Member.getName(),
				  UserRole.TreasuryLegal_Member.getName(),
				  UserRole.TreasuryTax_Member.getName(),
				  UserRole.CountryTax_Member.getName(),
				  UserRole.RiskUnderwriting_Member.getName(),
				  UserRole.ReadOnlyRole.getName(),
				  UserRole.Requestor.getName(),
				  UserRole.IDAGEAG_Lead.getName(),
				  UserRole.TESG_DELEGATE.getName(),
				  UserRole.PipelineReviewer.getName()
				};
				
		
		List<DelegationVO> userDelegation = new ArrayList<DelegationVO>();
		List<String> roleNames = new ArrayList<String>();
		for (String role : roles) {
			for (UserRole all_roles : UserRole.values()) {
				if(role.contains(all_roles.getName()) && 
						!org.apache.commons.lang.StringUtils.contains(org.apache.commons.lang.StringUtils.join(notApplicableRoles, ","), role)){
					DelegationVO delegationVO = new DelegationVO();
					delegationVO.setRoleId(Integer.parseInt(all_roles.getId()));
					delegationVO.setRoleName(all_roles.getName());
					delegationVO.setInsertUpdate(INSERT);
					delegationVO.setDelegatorSSO(UserContext.getCurrentUserContext().getId());
					delegationVO.setDelegatorFirstName(UserContext.getCurrentUserContext().getFirstName());
					delegationVO.setDelegatorLastName(UserContext.getCurrentUserContext().getLastName());
					roleNames.add(all_roles.getName());
					if(!ICFFO_READONLY.equals(delegationVO.getRoleName())){
						userDelegation.add(delegationVO);
					}
				}
			}
		}
		if(delegationRequest.getDelegations().get(0).getDelegateOpcode() == null){
		for (DelegationVO delegationVO : userDelegation) {
			for (Delegation dele : delegationRequest.getDelegations()) {
				if(delegationVO.getRoleId().intValue() == dele.getRoleId().intValue() 
						&& ICFPConstants.N_CAP.equals(dele.getDeleteFlag())){
					delegationVO.setDelegateSSO(dele.getDelegateSSO());
					delegationVO.setDelegateFirstName(dele.getDelegateFirstName());
					delegationVO.setDelegateLastName(dele.getDelegateLastName());
					delegationVO.setDelegateFromDate(convertDateToString(dele.getDelegateFromDt()));
					delegationVO.setDelegateToDate(convertDateToString(dele.getDelegateToDt()));
					delegationVO.setInsertUpdate(UPDATE);
					delegationVO.setDelegatorSSO(dele.getDelegatorSSO());
					delegationVO.setDelegatorFirstName(dele.getDelegatorFirstName());
					delegationVO.setDelegatorLastName(dele.getDelegatorLastName());
					delegationVO.setUserDelegateId(Integer.toString(dele.getUserDelegateId()));
				}
			}
		}
		}
		request.getSession().setAttribute(USER_DELEGATION, userDelegation);
		request.getSession().setAttribute(USER_GROUPS, roleGroups(request, roleNames));
		return mapping.findForward(OPEN_MANAGE_ROLES);
	}
	
	/**
	 * Open Manage delegate screen with all the possible delegate person that 
	 * can be selected. 
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HWFServiceException
	 * @throws HWFStubException
	 * @throws ICFPException 
	 */
	public ActionForward openAdminManageDelegations(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HWFServiceException,
			HWFStubException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(BEGIN_MANAGE_DELEGATION_ACTION_OPEN_MANAGE_DELEGATIONS);
		}
		String delegateSSOID = (String) request.getSession().getAttribute(DELEGATE_SSO_ID);
		List<String> roles = securityHelper.getRoles(delegateSSOID, request);
		if(roles==null){
			return mapping.findForward(MANAGE_DELEGATION);
		}
		DelegationRequest delegationRequest = new DelegationRequest();
		List<Delegation> delegationList = new ArrayList<Delegation>();
		Delegation delegation = new Delegation();
		delegation.setDelegateOpcode(GET);
		delegation.setRoleName(getRoles(roles));
		delegation.setRoleId(getRoleIds(roles));
		delegation.setDelegatorSSO(delegateSSOID);
		delegationList.add(delegation);
		delegationRequest.setDelegations(delegationList);
		delegationRequest = serviceClient.invokeService(DELEGATION2, delegationRequest, DelegationRequest.class);
		
		String[] notApplicableRoles = new String[]
				{ UserRole.FrontOffice_Member.getName(), 
				  UserRole.CashManagement_Member.getName(),
				  UserRole.MiddleOffice_Member.getName(),
				  UserRole.TransferPricing_Member.getName(),
				  UserRole.TreasuryLegal_Member.getName(),
				  UserRole.TreasuryTax_Member.getName(),
				  UserRole.CountryTax_Member.getName(),
				  UserRole.RiskUnderwriting_Member.getName(),
				  UserRole.ReadOnlyRole.getName(),
				  UserRole.Requestor.getName(),
				  UserRole.IDAGEAG_Lead.getName(),
				  UserRole.TESG_DELEGATE.getName(),
				  UserRole.PipelineReviewer.getName()
				};
		
		List<DelegationVO> userDelegation = new ArrayList<DelegationVO>();
		List<String> roleNames = new ArrayList<String>();
		for (String role : roles) {
			for (UserRole all_roles : UserRole.values()) {
				if(role.contains(all_roles.getName()) && 
						!org.apache.commons.lang.StringUtils.contains(org.apache.commons.lang.StringUtils.join(notApplicableRoles, ","), role)){
					DelegationVO delegationVO = new DelegationVO();
					delegationVO.setRoleId(Integer.parseInt(all_roles.getId()));
					delegationVO.setRoleName(all_roles.getName());
					delegationVO.setInsertUpdate(INSERT);
					delegationVO.setDelegatorSSO(UserContext.getCurrentUserContext().getId());
					delegationVO.setDelegatorFirstName(UserContext.getCurrentUserContext().getFirstName());
					delegationVO.setDelegatorLastName(UserContext.getCurrentUserContext().getLastName());
					roleNames.add(all_roles.getName());
					if(!ICFFO_READONLY.equals(delegationVO.getRoleName())){
						userDelegation.add(delegationVO);
					}
				}
			}
		}
		if(delegationRequest.getDelegations().get(0).getDelegateOpcode() == null){
		for (DelegationVO delegationVO : userDelegation) {
			for (Delegation dele : delegationRequest.getDelegations()) {
				if(delegationVO.getRoleId().intValue() == dele.getRoleId().intValue()
						&& ICFPConstants.N_CAP.equals(dele.getDeleteFlag())){
					delegationVO.setDelegateSSO(dele.getDelegateSSO());
					delegationVO.setDelegateFirstName(dele.getDelegateFirstName());
					delegationVO.setDelegateLastName(dele.getDelegateLastName());
					delegationVO.setDelegateFromDate(convertDateToString(dele.getDelegateFromDt()));
					delegationVO.setDelegateToDate(convertDateToString(dele.getDelegateToDt()));
					delegationVO.setInsertUpdate(UPDATE);
					delegationVO.setDelegatorSSO(dele.getDelegatorSSO());
					delegationVO.setDelegatorFirstName(dele.getDelegatorFirstName());
					delegationVO.setDelegatorLastName(dele.getDelegatorLastName());
					delegationVO.setUserDelegateId(Integer.toString(dele.getUserDelegateId()));
				}
			}
		}
		}
		request.getSession().setAttribute(USER_DELEGATION, userDelegation);
		request.getSession().setAttribute(USER_GROUPS, roleGroups(request, roleNames));
		request.getSession().setAttribute(CAN_DELEGATE,ICFPConstants.Y_CAP);
		return mapping.findForward(OPEN_MANAGE_ROLES);
	}
	/**
	 * Convert dateformat
	 * @param dele
	 */
	private String convertDateToString(XMLGregorianCalendar xmlGregorianCalendar) {
		Date date = xmlGregorianCalendar.toGregorianCalendar().getTime();
		DateFormat format = new SimpleDateFormat(MM_DD_YYYY);
		return format.format(date);
		
	}
	/**
	 * Save the assigned delegate person
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HWFServiceException
	 * @throws HWFStubException
	 * @throws DatatypeConfigurationException 
	 * @throws ParseException 
	 */
	public ActionForward saveDelegation(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HWFServiceException,
			HWFStubException, DatatypeConfigurationException, ParseException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(BEGIN_MANAGE_DELEGATION_ACTION_SAVE_DELEGATION);
		}
		DynaActionForm loginForm = (DynaActionForm) form;
		int noOfRoles = Integer.parseInt(loginForm.getString(NO_OF_ROLES));
		String isAdmin = (String) request.getSession().getAttribute(CAN_DELEGATE);
		String[] roleId = loginForm.getStrings(ROLE_IDS);
		String[] roleName = request.getParameterValues(ROLE_NAMES);
		String[] delegateSSOID = request.getParameterValues(DELEGATE_SSOID);
		String[] delegateFirstName = request.getParameterValues(DELEGATE_FIRST_NAMES);
		String[] delegateLastName = request.getParameterValues(DELEGATE_LAST_NAMES);
		String[] delegateFromDate = request.getParameterValues(DELEGATE_FROM_DATE);
		String[] delegateToDate = request.getParameterValues(DELEGATE_TO_DATE);
		String[] insertUpdate = request.getParameterValues(INSERT_UPDATE);
		String[] delegatorSSOID = request.getParameterValues(DELEGATOR_SSOID);
		String[] delegatorFirstName = request.getParameterValues(DELEGATOR_LAST_NAMES);
		String[] delegatorLastName = request.getParameterValues(DELEGATOR_FIRST_NAMES);
		String[] userDelegateId = request.getParameterValues(USER_DELEGATE_ID);
		String[] valid = validateBeforeSave(delegateSSOID,delegateFirstName,delegateLastName,delegateFromDate,delegateToDate,noOfRoles);
		MsgHeader msgHeader = new MsgHeader();
		setMessageHeader(request, msgHeader);
		DelegationRequest delegationRequest = new DelegationRequest();
		List<Delegation> delegationList = new ArrayList<Delegation>();
		if(valid != null && valid.length == 0){
			request.setAttribute(FAILUREMSG, PLEASE_INPUT_APPROPRIATE_VALUE);
			return mapping.findForward(OPEN_MANAGE_ROLES);
		}else if(valid!=null && valid.length > 0){
			for (int i = 0; i < noOfRoles; i++) {
				for (int j = 0; j < valid.length; j++) {
					if(i == Integer.parseInt(valid[j])){
						Delegation delegation = new Delegation();
						delegation.setDelegateOpcode(insertUpdate[i]);
						delegation.setRoleId(Integer.parseInt(roleId[i]));
						delegation.setRoleName(roleName[i]);
						delegation.setDelegateSSO(delegateSSOID[i]);
						delegation.setDelegateFirstName(delegateFirstName[i].trim());
						delegation.setDelegateLastName(delegateLastName[i].trim());
						XMLGregorianCalendar fromDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(getXMLCalenderValue(delegateFromDate[i]));
						delegation.setDelegateFromDt(fromDate);
						XMLGregorianCalendar toDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(getXMLCalenderValue(delegateToDate[i]));
						delegation.setDelegateToDt(toDate);
						if(insertUpdate[i].equals(UPDATE)){
							delegation.setActualDelegateEndDt(toDate);
							delegation.setDeleteFlag(ICFPConstants.N_CAP);
							delegation.setDelegatorSSO(delegatorSSOID[i]);
							delegation.setDelegatorFirstName(delegatorFirstName[i]);
							delegation.setDelegatorLastName(delegatorLastName[i]);
							delegation.setUserDelegateId(Integer.parseInt(userDelegateId[i]));
						}else{
							delegation.setDeleteFlag(ICFPConstants.N_CAP);
							if(ICFPConstants.Y_CAP.equals(isAdmin)){
								String delegaterSSOID = (String) request.getSession().getAttribute(DELEGATE_SSO_ID);
								delegation.setDelegatorSSO(delegaterSSOID);
							}else{
								delegation.setDelegatorSSO(SessionManager.getUserID(request));
							}
							delegation.setDelegatorFirstName(SessionManager.getSessionUser(request).getFirstName());
							delegation.setDelegatorLastName(SessionManager.getSessionUser(request).getLastName());
						}
						delegation.setMsgHeader(msgHeader);
						delegationList.add(delegation);
					}
				}
			}
			delegationRequest.setDelegations(delegationList);
			delegationRequest = serviceClient.invokeService(DELEGATION2, delegationRequest, DelegationRequest.class);
			if(delegationRequest.getDelegations().get(0).getStatus().equalsIgnoreCase(ManageDelegationAction.SUCCESS)){
				request.setAttribute(UPDATEMESSAGE, ROLES_DELEGATED_SUCCESSFULLY);
				if(ICFPConstants.Y_CAP.equals(isAdmin)){
					return mapping.findForward(SAVE_ADMIN_DELEGATION_ROLES);
				}else{
					return mapping.findForward(SAVE_ROLES);
				}
				
			}
		}
		if(ICFPConstants.Y_CAP.equals(isAdmin)){
			return mapping.findForward(OPEN_ADMIN_MANAGE_ROLES);
		}
		return mapping.findForward(OPEN_MANAGE_ROLES);
	}
	
	/**
	 * Revokes the roles which he has already.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HWFServiceException
	 * @throws HWFStubException
	 * @throws DatatypeConfigurationException
	 * @throws ParseException
	 */
	public ActionForward revokeDelegation(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HWFServiceException,
			HWFStubException, DatatypeConfigurationException, ParseException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(BEGIN_MANAGE_DELEGATION_ACTION_REVOKE_DELEGATION);
		}
		String isAdmin = (String) request.getSession().getAttribute(CAN_DELEGATE);
		MsgHeader msgHeader = new MsgHeader();
		setMessageHeader(request, msgHeader);
		DelegationRequest delegationRequest = new DelegationRequest();
		List<Delegation> delegationList = new ArrayList<Delegation>();
		String userDelegateId = request.getParameter(USER_DELEGATE_ID);
		@SuppressWarnings("unchecked")
		List<DelegationVO> userDelegation = (List<DelegationVO>) request.getSession().getAttribute(USER_DELEGATION);
		String roleToDelegate = "";
		for (DelegationVO delegationVO : userDelegation) {
			if(userDelegateId.equals(delegationVO.getUserDelegateId())){
				Delegation delegation = new Delegation();
				XMLGregorianCalendar actualEndDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(getXMLCalenderValue(new Date()));
				delegation.setActualDelegateEndDt(actualEndDate);
				delegation.setDeleteFlag(ICFPConstants.Y_CAP);
				delegation.setDelegateOpcode(UPDATE);
				delegation.setRoleId(delegationVO.getRoleId());
				delegation.setRoleName(delegationVO.getRoleName());
				roleToDelegate = delegationVO.getRoleName();
				delegation.setDelegateSSO(delegationVO.getDelegateSSO());
				delegation.setDelegateFirstName(delegationVO.getDelegateFirstName());
				delegation.setDelegateLastName(delegationVO.getDelegateLastName());
				XMLGregorianCalendar fromDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(getXMLCalenderValue(delegationVO.getDelegateFromDate()));
				delegation.setDelegateFromDt(fromDate);
				XMLGregorianCalendar toDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(getXMLCalenderValue(delegationVO.getDelegateToDate()));
				delegation.setDelegateToDt(toDate);
				delegation.setDelegatorSSO(delegationVO.getDelegatorSSO());
				delegation.setDelegatorFirstName(delegationVO.getDelegatorFirstName());
				delegation.setDelegatorLastName(delegationVO.getDelegatorLastName());
				delegation.setUserDelegateId(Integer.parseInt(delegationVO.getUserDelegateId()));
				delegation.setMsgHeader(msgHeader);
				delegationList.add(delegation);
			}
		}
		delegationRequest.setDelegations(delegationList);
		delegationRequest = serviceClient.invokeService(DELEGATION2, delegationRequest, DelegationRequest.class);
		if(delegationRequest.getDelegations().get(0).getStatus().equalsIgnoreCase(ManageDelegationAction.SUCCESS)){
			request.setAttribute(UPDATEMESSAGE, ROLE_NAME+ roleToDelegate + HAS_BEEN_REVOKED_SUCCESSFULLY);
			if(ICFPConstants.Y_CAP.equals(isAdmin)){
				return mapping.findForward(SAVE_ADMIN_DELEGATION_ROLES);
			}else{
				return mapping.findForward(SAVE_ROLES);
			}
		}
		if(ICFPConstants.Y_CAP.equals(isAdmin)){
			return mapping.findForward(OPEN_ADMIN_MANAGE_ROLES);
		}
		return mapping.findForward(OPEN_MANAGE_ROLES);
	}
	/**
	 * 
	 * @param delegateSSOID
	 * @param delegateFirstName
	 * @param delegateLastName
	 * @param delegateFromDate
	 * @param delegateToDate
	 * @param noOfRoles
	 * @return
	 */
	private String[] validateBeforeSave(String[] delegateSSOID,
			String[] delegateFirstName, String[] delegateLastName,
			String[] delegateFromDate, String[] delegateToDate, int noOfRoles) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < noOfRoles; i++) {
			if(!StringUtils.isEmpty(delegateSSOID[i]) && !StringUtils.isEmpty(delegateFirstName[i]) && !StringUtils.isEmpty(delegateLastName[i])
					&& !StringUtils.isEmpty(delegateFromDate[i]) && !StringUtils.isEmpty(delegateToDate[i])){
				sb.append(i);
				if(i < (noOfRoles - 1))
					sb.append(",");
			}
		}
		if(sb.length() > 0){
			return sb.toString().split(",");
		}
		return null;
	}
	/**
	 * @param request
	 * @param msgHeader
	 */
	private void setMessageHeader(HttpServletRequest request,
			MsgHeader msgHeader) {
		msgHeader.setAuditCreator(SessionManager.getUserID(request));
		msgHeader.setAuditCreatorFirstName(SessionManager.getSessionUser(request).getFirstName());
		msgHeader.setAuditCreatorLastName(SessionManager.getSessionUser(request).getLastName());
		msgHeader.setAuditModifier(SessionManager.getUserID(request));
		msgHeader.setAuditModifierFirstName(SessionManager.getSessionUser(request).getFirstName());
		msgHeader.setAuditModifierLastName(SessionManager.getSessionUser(request).getLastName());
	}
	/**
	 * @param delegateFromDate
	 * @return
	 * @throws ParseException
	 */
	private GregorianCalendar getXMLCalenderValue(String stringDate) throws ParseException {
		GregorianCalendar gcal = new GregorianCalendar();
		DateFormat format = new SimpleDateFormat(MM_DD_YYYY);
		Date date = format.parse(stringDate);
		gcal.setTime(date);
		return gcal;
	}
	/**
	 * @param delegateFromDate
	 * @return
	 * @throws ParseException
	 */
	private GregorianCalendar getXMLCalenderValue(Date date) throws ParseException {
		GregorianCalendar gcal = new GregorianCalendar();
		gcal.setTime(date);
		return gcal;
	}
	/**
	 * Invoke the service to retrieve user information for the given role names
	 * @param request
	 * @param allRoleNames
	 * @return
	 * @throws HWFServiceException
	 * @throws HWFStubException
	 */
	private Map<String, String> roleGroups(HttpServletRequest request, List<String> allRoleNames) throws HWFServiceException, HWFStubException {
		Map<String, String> result = new HashMap<String, String>();
		for (String string : allRoleNames) {
			MsgHeader msgHeader = new MsgHeader();
			msgHeader.setOpcode(ROLEINFO);
			List<RoleInfo> userRoleInfoList = new ArrayList<RoleInfo>();
			RoleInfo userRoleInfo = new RoleInfo();
			if(string!=null){
				String roleName = string;
				if(roleName.contains(_TESG_MEMBER)){
					String tempString = roleName.replaceAll(_TESG_MEMBER, _TESG_DELEGATE);
					roleName = tempString;
				}
				if(roleName.contains(_IDAG)){
					String tempString = roleName.replaceAll(_IDAG, DELEGATE);
					roleName = tempString;
				}
				userRoleInfo.setRoleName(roleName);
			}
			userRoleInfoList.add(userRoleInfo);
			UserInformation userInfo = new UserInformation();
			userInfo.setRoleInfos(userRoleInfoList);
			userInfo.setMsgHeader(msgHeader);
			userInfo = serviceClient.invokeService(USER_MGMT, userInfo,UserInformation.class);
			if (userInfo != null) {
				ArrayList<RoleInfo> roleInfoList = (ArrayList<RoleInfo>) userInfo.getRoleInfos();
				for (RoleInfo roleInfo : roleInfoList) {
					for (int i = 0; i < allRoleNames.size(); i++) {
						if(roleInfo.getRoleName().contains(DELEGATE) && !roleInfo.getSsoId().equals(SessionManager.getUserID(request))){
							result.put(roleInfo.getSsoId(), roleInfo.getLastName()+", "+roleInfo.getFirstName());
						}
					}
				}
				
			}
		}
		
		
		return result;
	}
	/**
	 * 
	 * @param roles
	 * @return
	 */
	private String getRoles(List<String> roles ) {
		String roleName = null;
		
		for( UserRole all_roles : UserRole.values()  ){
			if( roles.contains( all_roles.getName() )){
				return all_roles.getName();
			}
		}
		return roleName;
	}

	/**
	 * 
	 * @param roles
	 * @return
	 */
	private Integer getRoleIds(List<String> roles ) {
		Integer roleId = null;
		
		for( UserRole all_roles : UserRole.values()  ){
			if( roles.contains( all_roles.getName() )){
				return Integer.parseInt(all_roles.getId());
			}
		}
		return roleId;
	}
	/**
	 * 
	 * @return
	 */
	public ServiceClient getServiceClient() {
		return serviceClient;
	}

	/**
	 * 
	 * @param serviceClient
	 */
	public void setServiceClient(ServiceClient serviceClient) {
		this.serviceClient = serviceClient;
	}

	/**
	 * @return the securityHelper
	 */
	public SecurityHelper getSecurityHelper() {
		return securityHelper;
	}

	/**
	 * @param securityHelper the securityHelper to set
	 */
	public void setSecurityHelper(SecurityHelper securityHelper) {
		this.securityHelper = securityHelper;
	}
}
