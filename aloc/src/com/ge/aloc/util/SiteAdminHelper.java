/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: SiteAdminHelper.java
 * Purpose: SiteAdminHelper used for the active site
 */
package com.ge.aloc.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.ge.aloc.ALOCContext;
import com.ge.aloc.InstrumentType;
import com.ge.aloc.OpCode;
import com.ge.aloc.StaticDataFactory;
import com.ge.aloc.bo.SiteDetailsBO;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.exception.ALOCRuntimeException;
import com.ge.aloc.model.ActionDetails;
import com.ge.aloc.model.ApprovalGroupConfiguration;
import com.ge.aloc.model.Approver;
import com.ge.aloc.model.BankSwift;
import com.ge.aloc.model.DelegationConfig;
import com.ge.aloc.model.DelegationConfiguration;
import com.ge.aloc.model.Group;
import com.ge.aloc.model.Instrument;
import com.ge.aloc.model.NameValue;
import com.ge.aloc.model.ParentSite;
import com.ge.aloc.model.SiteAdmin;
import com.ge.aloc.model.StaticDataManagement.ParentSites;
import com.ge.aloc.model.UserDetails;
import com.hydus.hwf.util.StringUtils;

/**
 * @author chaitanya.n
 *
 */
public class SiteAdminHelper {

	public static final String SSN_KEY_SITE_DETAILS_BO = SiteDetailsBO.class.getName();
	private static final String SSN_KEY_ACTIVE_SITE_CTX = ActiveSiteContext.class.getName();
	private static final String SITE_KEY_ALL_SITE_APPROVERS = "AVAILABLE_SITE_APPROVERS";
	private static final String SITE_KEY_SELECTED_APPROVERS = "SELECTED_APPROVERS";

	/**
	 * 
	 * @author chaitanya.n
	 *
	 */
	private static class ActiveSiteContext {
		private Integer siteId;
		private Map<String, Object> contextMap = new HashMap<String, Object>();

		/**
		 * constructor
		 * @param siteId
		 */
		ActiveSiteContext(Integer siteId) {
			this.siteId = siteId;
		}
		/**
		 * This is used to get siteId attribute
		 * @return
		 */
		public Integer getSiteId() {
			return this.siteId;
		}
	}

	/**
	 * Method to get the Active Site Context
	 * @return
	 */
	public static ActiveSiteContext getActiveSiteContext() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		ActiveSiteContext activeSiteContext = (ActiveSiteContext) session.getAttribute(SSN_KEY_ACTIVE_SITE_CTX);
		SiteDetailsBO activeSite = getActiveSite();

		if(activeSiteContext != null && !activeSiteContext.getSiteId().equals(activeSite.getModel().getSiteId())) {
			session.removeAttribute(SSN_KEY_ACTIVE_SITE_CTX);
			activeSiteContext = null;
		}

		if(activeSiteContext == null) {
			activeSiteContext = new ActiveSiteContext(activeSite.getModel().getSiteId());
			session.setAttribute(SSN_KEY_ACTIVE_SITE_CTX, activeSiteContext);
		} 		
		return activeSiteContext;
	}

	/**
	 * Method to get the Available Site Approvers
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, UserDetails> getAvailableSiteApprovers() {
		return (Map<String, UserDetails>) getActiveSiteContext().contextMap.get(SITE_KEY_ALL_SITE_APPROVERS);
	}

	/**
	 * Method to set the Available Site Approvers
	 * @param allApprovers
	 */
	public static void setAvailableSiteApprovers(List<UserDetails> allApprovers) {
		if(allApprovers != null && !allApprovers.isEmpty()) {
			Map<String, UserDetails> approversMap = new LinkedHashMap<String, UserDetails>();
			for(UserDetails approver : allApprovers) {
				approversMap.put(approver.getUserSso(), approver);
			}
			getActiveSiteContext().contextMap.put(SITE_KEY_ALL_SITE_APPROVERS, approversMap);
		} else {
			getActiveSiteContext().contextMap.remove(SITE_KEY_ALL_SITE_APPROVERS);
		}
	}

	/**
	 * Method to set the Selected Approvers
	 * @param selectedApprovers
	 */
	public static void setSelectedApprovers(Map<String, UserDetails> selectedApprovers) {
		if(selectedApprovers != null && !selectedApprovers.isEmpty()) {
			getActiveSiteContext().contextMap.put(SITE_KEY_SELECTED_APPROVERS, selectedApprovers);
		} else {
			getActiveSiteContext().contextMap.remove(SITE_KEY_SELECTED_APPROVERS);
		}
	}

	/**
	 * Method to get the Selected Approvers
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, UserDetails> getSelectedApprovers() {
		return (Map<String, UserDetails>) getActiveSiteContext().contextMap.get(SITE_KEY_SELECTED_APPROVERS);
	}

	/**
	 * Method to find Approver Group By Name
	 * @param allGroups
	 * @param groupName
	 * @return
	 */
	public static Group findApproverGroupByName(List<Group> allGroups, String groupName) {
		Group resultGroup = null;
		if(!allGroups.isEmpty()) {
			for(Group group : allGroups) {
				if(groupName.equals(group.getGroupName())) {
					resultGroup = group;
					break;
				}
			}
		}
		return resultGroup;
	}
	
	/**
	 * Method to find Approver Group By Name
	 * @param allGroups
	 * @param groupName
	 * @return
	 */
	public static Group findApproverGroupById(List<Group> allGroups, Integer groupId) {
		Group resultGroup = null;
		if(!allGroups.isEmpty()) {
			for(Group group : allGroups) {
				if(group.getGroupId() != null){
					if(groupId.intValue() == group.getGroupId().intValue()) {
						resultGroup = group;
						break;
					}
				}
			}
		}
		return resultGroup;
	}

	/**
	 * Method to set the Group Approvers
	 * @param group
	 * @param approvers
	 */
	public static void setGroupApprovers(Group group, List<UserDetails> approvers) {
		Map<String, Approver> oldApprovers = new HashMap<String, Approver>();
		for(Approver approver : group.getApprovers()) {
			if(approver.getGroupApprId() != null) {
				oldApprovers.put(approver.getSssoId(), approver);
			}
		}
		group.getApprovers().clear();
		String approverSSOId = null;
		for(UserDetails approver : approvers) {
			approverSSOId = approver.getUserSso();
			Approver approverToAdd = oldApprovers.get(approverSSOId);
			if(approverToAdd == null) {
				approverToAdd = new Approver();
				approverToAdd.setOpCode(OpCode.INSERT.getOperationCode());
				approverToAdd.setSssoId(approverSSOId);
				approverToAdd.setAppFirstName(approver.getFirstName());
				approverToAdd.setAppLastName(approver.getLastName());
			} else {
				oldApprovers.remove(approverToAdd.getSssoId());
			}
			group.getApprovers().add(approverToAdd);
		}

		for(Approver oldApprover : oldApprovers.values()) {
			oldApprover.setOpCode(OpCode.DELETE.getOperationCode());
			group.getApprovers().add(oldApprover);
		}
	}

	/**
	 * Method to get the Active Site
	 * @return
	 */
	public static SiteDetailsBO getActiveSite() {
		SiteDetailsBO activeSite = null;
		HttpSession session = ServletActionContext.getRequest().getSession(false);
		if(session != null) {
			activeSite = (SiteDetailsBO) session.getAttribute(SSN_KEY_SITE_DETAILS_BO);
		}
		if(activeSite == null) {
			throw new ALOCRuntimeException(ALOCRuntimeException.EC_ACTIVESITE_NOTFOUND);
		}
		return activeSite;
	}

	/**
	 * Method to set the Active Site
	 * @param siteDetailsBO
	 */
	public static void setActiveSite(SiteDetailsBO siteDetailsBO) {
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute(SSN_KEY_SITE_DETAILS_BO, siteDetailsBO);
	}

	/**
	 * Method to remove the Ative Site
	 */
	public static void removeActiveSite() {
		HttpSession session = ServletActionContext.getRequest().getSession(false);
		if(session != null) {
			session.removeAttribute(SSN_KEY_SITE_DETAILS_BO);
			StaticDataFactory staticDataFactory =ALOCContext.getStaticDataFactory(); 
			staticDataFactory.removeSitesLst();
		}
	}

	/**
	 * method to get the Desc Prefix ParentSites
	 * @param siteType
	 * @return
	 */
	public static List<String> getDescPrefixParentSites(String parentSiteId){

		StaticDataFactory staticDataFactory =ALOCContext.getStaticDataFactory(); 
		List <ParentSites> parentSites = staticDataFactory.getParentSites();
		List<String> descPrefixLst = new ArrayList<String>();
		for(ParentSites parentSite:parentSites){
			if(parentSiteId.equals(parentSite.getID().toString())){
				descPrefixLst.add(parentSite.getParentSitePrefix());
				descPrefixLst.add(parentSite.getParentSiteDescription());
			}
		}
		return descPrefixLst;
	}

	/**
	 * Method to get the parent Site Name
	 * @param parentSiteId
	 * @return
	 */
	public static String getParentSiteName(String parentSiteId){
		String parentSiteName = ALOCConstants.EMPTY_STRING;
		StaticDataFactory staticDataFactory =ALOCContext.getStaticDataFactory(); 
		List <ParentSites> parentSites = staticDataFactory.getParentSites();
		for(ParentSites parentSite:parentSites){
			if(parentSiteId.equals(parentSite.getID().toString())){
				parentSiteName = parentSite.getName();
			}
		}
		return parentSiteName;
	}

	/**
	 * Method to set the parent Site Name and the address
	 * @param siteAdmin
	 * @return
	 */
	public static SiteAdmin setParentsiteAndSiteName(SiteAdmin siteAdmin){
		if(siteAdmin.getParentSite().getParentSiteId()!=null){
			String parentSiteName =  getParentSiteName(siteAdmin.getParentSite().getParentSiteId().toString());
			ParentSite parSite = new ParentSite();
			parSite.setParentSiteId(siteAdmin.getParentSite().getParentSiteId());
			parSite.setParentSiteName(parentSiteName);
			siteAdmin.setParentSite(parSite);
		}
		siteAdmin.getSiteType().setSiteTypeName(getSiteName(siteAdmin.getSiteType().getSiteTypeId().toString()));
		return siteAdmin;
	}

	/**
	 * Method to get the SiteName
	 * @param siteId
	 * @return
	 */
	private static String getSiteName(String siteId){
		StaticDataFactory staticDataFactory =ALOCContext.getStaticDataFactory(); 
		List <NameValue> siteTypes = staticDataFactory.getSiteTypes();
		for(NameValue namevalue:siteTypes){
			if(siteId.equals(namevalue.getID().toString())){
				return namevalue.getName();
			}
		}
		return siteId;
	}
	/**
	 * Method to Crate SSO to NameMap
	 * @param allUsers
	 * @return
	 */
	public static Map<String, String> crateSSOToNameMap(Collection<UserDetails> allUsers) {
		Map<String, String> result = new LinkedHashMap<String, String>();
		if(allUsers != null && !allUsers.isEmpty()) {
			for(UserDetails userDetails : allUsers) {
				String value = new StringBuilder().append(userDetails.getLastName()).append(ALOCConstants.COMMA_SPACE).append(userDetails.getFirstName()).toString();
				result.put(userDetails.getUserSso(), value);
			}
		}
		return result;
	}

	/**
	 * method to load the Available Sites
	 * @param all Sites
	 * @return
	 */
	public static List<NameValue> loadAvailSites(String modifySiteId){

		StaticDataFactory staticDataFactory =ALOCContext.getStaticDataFactory(); 
		List<NameValue> siteTypes = staticDataFactory.getSiteTypes();
		List<NameValue> namevalueLst = new ArrayList<NameValue>();
		for(NameValue sites:siteTypes){
			if(siteTypes != null){
				NameValue nameValue =new NameValue();
				nameValue.setID(sites.getID());
				nameValue.setName(sites.getName());
				namevalueLst.add(nameValue);
			}
		}
		return namevalueLst;
	}

	/**
	 * Method to set All the Ids as Empty
	 * @param siteAdmin
	 */
	public static void setAllIdsEmpty(SiteAdmin siteAdmin){
		siteAdmin.setSiteId(null);
		siteAdmin.setSiteName(ALOCConstants.EMPTY_STRING);
		siteAdmin.setSitePrefix(ALOCConstants.EMPTY_STRING);
		siteAdmin.setDescription(ALOCConstants.EMPTY_STRING);
	}

	/**
	 * Method to set the Opcode update for the delegation Instrument section
	 * @param siteAdmin
	 */
	public static SiteAdmin setDelegOpcodeUpdate(SiteAdmin siteAdmin){
		if(siteAdmin.getDelegationConfiguration() != null){
			List<DelegationConfig> delegConfigLst = siteAdmin.getDelegationConfiguration().getDelegationConfigs();
			for(DelegationConfig delConfig: delegConfigLst){
				List<com.ge.aloc.model.Instrument> instrLst = delConfig.getInstruments();
				for(com.ge.aloc.model.Instrument instr: instrLst){
					instr.setOpCode(OpCode.UPDATE.getOperationCode());
				}
				delConfig.setInstruments(instrLst);
			}
			siteAdmin.getDelegationConfiguration().setDelegationConfigs(delegConfigLst);
		}
		return siteAdmin;
	}

	/**
	 * method to validate the bank Swift configuration
	 * @param siteAdmin
	 * @return
	 */
	public static Boolean validateBankSwift(SiteAdmin siteAdmin){
		if(siteAdmin.getBankSWIFTConfiguration()!=null && siteAdmin.getBankSWIFTConfiguration().isSWIFTEnabled() != null
				&& siteAdmin.getBankSWIFTConfiguration().isSWIFTEnabled() == true){
			List<BankSwift> bankSwiftLst = siteAdmin.getBankSWIFTConfiguration().getBankSwifts();
			for(BankSwift eachSwift : bankSwiftLst){
				Boolean val = eachSwift.isMessageSupport();
				if(val == null){
					return false;
				}else if(val == true){
					String msg = eachSwift.getMessageDirection();
					if(StringUtils.isBlank(msg)){
						return false;
					}
				}
			}
		}
		return true;
	}

	/* -------------------------------------------------------------------------------------------------------------------------------------------
	 * 									Delegation Approvers related Methods
	 -------------------------------------------------------------------------------------------------------------------------------------------- */

	/**
	 * This Method is used to get Current Approvers by Drop-down selection
	 * @param adminAvailableApprovers
	 * @param groupLst
	 * @return adminAvailableApprovers
	 */
	public static List<String> getCurrentApprovers(List<Group> groupLst) {

		HttpServletRequest request = ServletActionContext.getRequest();
		String groupId =  request.getParameter(ALOCConstants.GROUP_ID);
		List<String> oldSelApprovers = new ArrayList<String>();
		if(StringUtils.isNotBlank(groupId) && groupLst != null){
			for(Group eachGroup:groupLst){
				if((eachGroup.getGroupId()) != null){
					if((eachGroup.getGroupId().toString()).equals(groupId)){
						List<Approver> apprLst = eachGroup.getApprovers();
						for(Approver approver: apprLst){
							oldSelApprovers.add(approver.getSssoId()+ALOCConstants.TILDA+approver.getAppLastName()+ALOCConstants.TILDA+approver.getAppFirstName());
						}
					}
				}
			}
		}
		return oldSelApprovers;
	}


	/**
	 * Method to set the Selected Approvers to the UserDetails
	 * @return
	 */
	public static List<UserDetails> addSelAppToUserDetails(List<String> selApprovers){
		List<UserDetails> useDetLst = new ArrayList<UserDetails>();
		UserDetails usdDetails = new UserDetails();
		for(String eachApprover : selApprovers){
			usdDetails = new UserDetails();
			if(!(eachApprover.equals(ALOCConstants.EMPTY_STRING))){
				String[] arr = eachApprover.split(ALOCConstants.TILDA);
				if(arr.length == ALOCConstants.NUM_THREE){
					usdDetails.setUserSso(arr[ALOCConstants.NUM_ZERO]);
					usdDetails.setLastName(arr[ALOCConstants.NUM_ONE]);
					usdDetails.setFirstName(arr[ALOCConstants.NUM_TWO]);
				}
				useDetLst.add(usdDetails);
			}
		}
		return useDetLst;
	}

	/**
	 * Method to set the Approver Opcode for Business Site / Create / Copy / Modify Site
	 * @return
	 */
	public static SiteAdmin setApproverOpcodes(SiteAdmin siteAdmin,String delegates,List<UserDetails> selApprovers){

		List<String> newSelSSOLst = new ArrayList<String>();
		List<String> oldSSOLst = new ArrayList<String>();
		for(UserDetails usrDet : selApprovers){
			newSelSSOLst.add(usrDet.getUserSso());
		}
		List<Group> groupLst = siteAdmin.getDelegationConfiguration().getApprovalGroupConfiguration().getGroups();
		DelegationConfiguration delConfig = new DelegationConfiguration();
		ApprovalGroupConfiguration appGroupConfig = new ApprovalGroupConfiguration();

		Group group = new Group();
		List<Group> selGroupLst = new ArrayList<Group>();
		Approver approver =new Approver();
		List<Approver> apprLst = new ArrayList<Approver>();

		//Set Opcode Delete
		for(Group eachGroup:groupLst){
			if(eachGroup.getGroupId()!=null){
				if((eachGroup.getGroupId().toString()).equalsIgnoreCase(delegates)){
					group.setGroupId(Integer.parseInt(delegates));
					group.setGroupName(eachGroup.getGroupName());
					group.setOpCode(OpCode.UPDATE.getOperationCode());

					List<Approver> appLst = eachGroup.getApprovers();
					for(Approver app : appLst){
						oldSSOLst.add(app.getSssoId());
						if(!newSelSSOLst.contains(app.getSssoId())){
							approver =new Approver();
							approver.setSssoId(app.getSssoId());
							approver.setAppLastName(app.getAppLastName());
							approver.setAppFirstName(app.getAppFirstName());
							approver.setOpCode(ALOCConstants.DELETE);
							apprLst.add(approver);
						}
					}
				}
			}
		}
		//Set Opcode Insert
		for(UserDetails eachUserdet : selApprovers){
			if(!(oldSSOLst.contains(eachUserdet.getUserSso()))){
				approver =new Approver();
				approver.setSssoId(eachUserdet.getUserSso());
				approver.setAppLastName(eachUserdet.getLastName());
				approver.setAppFirstName(eachUserdet.getFirstName());
				approver.setOpCode(ALOCConstants.INSERT);
				apprLst.add(approver);
			}
		}
		group.setApprovers(apprLst);
		selGroupLst.add(group);
		appGroupConfig.setGroups(selGroupLst);
		delConfig.setApprovalGroupConfiguration(appGroupConfig);
		siteAdmin.setDelegationConfiguration(delConfig);
		ActionDetails actionDet = new ActionDetails();
		actionDet.setActionName(OpCode.SAVE.getOperationCode());
		siteAdmin.getDelegationConfiguration().setActionDetails(actionDet);

		return siteAdmin;
	}
	
	/**
	 * Method to set the delegation flags to Empty When user clicks on Surety Bond/ Rider
	 */
	public static List<DelegationConfig> setDelegFlagToEmpty(DelegationConfiguration deleg){
		List<DelegationConfig> delegLst = deleg.getDelegationConfigs();
		List<DelegationConfig> delegLstNew = new ArrayList<DelegationConfig>();

		for(DelegationConfig eachDeleg : delegLst){
			DelegationConfig delegNew = new DelegationConfig();
			delegNew = eachDeleg;

			List<Instrument> instLst = eachDeleg.getInstruments();
			List<Integer> ItrLst = new ArrayList<Integer>();
			for(Instrument inst: instLst){
				if(inst.getOpCode()!=null && !inst.getOpCode().equals(ALOCConstants.DELETE)){
					ItrLst.add(inst.getInstrId());
				}
			}
			if((ItrLst.size()==ALOCConstants.INSTRUMENTS_MIN_SIZE && ItrLst.contains(InstrumentType.SURETY_BOND.getId()) && ItrLst.contains(InstrumentType.RIDER.getId())) || 
					(ItrLst.size()== ALOCConstants.INSTRUMENTS_BASE_SIZE && (ItrLst.contains(InstrumentType.SURETY_BOND.getId()) || ItrLst.contains(InstrumentType.RIDER.getId())))){
				delegNew.setNotificationCaluseFlag(ALOCConstants.EMPTY_STRING);
				delegNew.setCurePeriodIndicatorFlag(ALOCConstants.EMPTY_STRING);
				delegNew.setGEAppDrawFlag(ALOCConstants.EMPTY_STRING);
			}else{
				delegNew.setNotificationCaluseFlag(eachDeleg.getNotificationCaluseFlag());
				delegNew.setCurePeriodIndicatorFlag(eachDeleg.getCurePeriodIndicatorFlag());
				delegNew.setGEAppDrawFlag(eachDeleg.getGEAppDrawFlag());
			}
			delegLstNew.add(delegNew);
		}
		ApprovalGroupConfiguration appConfig = deleg.getApprovalGroupConfiguration();
		if(appConfig==null){
			delegLstNew = null;
		}
		return delegLstNew;
	}
	
	/**
	 * Method to set the delegation values
	 * @param siteDetailsBO
	 * @param siteAdmin
	 * @param siteDetailsBOOld
	 * @return
	 */
	public static SiteDetailsBO setDelegationValues(SiteDetailsBO siteDetailsBO,SiteAdmin siteAdmin,SiteDetailsBO siteDetailsBOOld){
		siteDetailsBO.getModel().setSiteId(siteAdmin.getSiteId());
		siteDetailsBO.getModel().setComments(siteAdmin.getComments());
		siteDetailsBO.getModel().setActionDetails(new ActionDetails());
		
		if(siteDetailsBOOld!=null && siteDetailsBO!=null){
			DelegationConfiguration deleg = siteDetailsBOOld.getModel().getDelegationConfiguration();
			if(deleg!=null){
				DelegationConfiguration delegConfig = new DelegationConfiguration();
				ApprovalGroupConfiguration appConfig = deleg.getApprovalGroupConfiguration();
				List<DelegationConfig> deleLst= deleg.getDelegationConfigs();
				if(appConfig!=null){
					delegConfig.setApprovalGroupConfiguration(appConfig);
				}
				if(deleLst!=null){
					delegConfig.setDelegationConfigs(deleLst);
				}
				siteDetailsBO.getModel().setDelegationConfiguration(delegConfig);
			}
		}
		return siteDetailsBO;
	}
	
	/**
	 * Method to get the Active Site for delegation
	 * @return
	 */
	public static SiteDetailsBO getActiveSiteCreate() {
		SiteDetailsBO activeSite = null;
		HttpSession session = ServletActionContext.getRequest().getSession(false);
		if(session != null) {
			activeSite = (SiteDetailsBO) session.getAttribute(SSN_KEY_SITE_DETAILS_BO);
		}
		return activeSite;
	}
}
