/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ManageSiteAction.java
 * Purpose: ManageSiteAction used for the all site operations
 */
package com.ge.aloc.action.siteadmin;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.ge.aloc.bo.DelegationConfigBO;
import com.ge.aloc.bo.SiteDetailsBO;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.manager.ISiteDetailsManager;
import com.ge.aloc.model.ApprovalGroupConfiguration;
import com.ge.aloc.model.DelegationConfig;
import com.ge.aloc.model.DelegationConfiguration;
import com.ge.aloc.model.Group;
import com.ge.aloc.model.SiteAdmin;
import com.ge.aloc.model.UserDetails;
import com.ge.aloc.util.ALOCCommonHelper;
import com.ge.aloc.util.SiteAdminHelper;
import com.ge.aloc.view.section.SiteSectionId;
import com.hydus.hwf.exceptions.HWFServiceException;
import com.hydus.hwf.util.StringUtils;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.ValidationWorkflowAware;

/**
 * @author madhusudhan.gosula
 *
 */
public class ManageSiteAction extends ActionSupport implements ValidationWorkflowAware {

	private static final long serialVersionUID = 5535375111962652198L;

	private SiteSectionId sectionId;
	private ISiteDetailsManager siteDetailsManager;
	private SiteDetailsBO siteDetailsBO;
	private int customFieldAddIndex;
	private int customFieldRemoveIndex;
	private boolean editMode;
	private boolean modifySite;
	private boolean copySite;
	private boolean ignoreParentSites;
	private String groupName;
	private String delegates;
	protected boolean validationSuccess;

	/**
	 * Method to Open the Site
	 * @return to openActiveSite()
	 */
	public String openSite() {
		SiteAdminHelper.removeActiveSite();
		SiteDetailsBO requestedSite = null;
		SiteAdminHelper.setActiveSite(requestedSite);
		copySite = false;
		modifySite = false;
		return openActiveSite();
	}

	/**
	 * Method to open the Active Site
	 * @return OPEN_SITE_PAGE
	 */
	public String openActiveSite() {
		siteDetailsBO = SiteAdminHelper.getActiveSite();
		return ALOCConstants.OPEN_SITE_PAGE;
	}

	/**
	 * Method to Save all the Toggles
	 * @return SECTION_CONTROLLER_PAGE
	 * @throws HWFServiceException
	 */
	public String saveSection() throws HWFServiceException {
		HttpSession session = ServletActionContext.getRequest().getSession();
		SiteAdmin siteAdmin = null;
		if(sectionId != null) {
			try{
				switch(sectionId) {
				case DEFAULT_DELIVERY_INSTRUCTIONS:
					siteAdmin = getSiteDetailsManager().saveDefaultDelivary();
					ignoreParentSites = true;
					addActionMessage(siteAdmin.getDeliveryInstructions().getComments());
					break;
				case CUSTOMIZED_SITE_REFERENCES:
					siteAdmin = getSiteDetailsManager().saveCustomizedSiteReferences(getSiteDetailsBO());
					ignoreParentSites = true;
					addActionMessage(siteAdmin.getCustomizedSiteReferences().getComments());
					break;
				case CREATE_DELEGATION_CONFIGURATION:
					List<DelegationConfigBO> delegationConfigBOList = (siteDetailsBO.getDelegationConfigurationBO() != null) ? siteDetailsBO.getDelegationConfigurationBO().getDelegationConfigBOList() : null;
					if(delegationConfigBOList != null) {
						ALOCCommonHelper.cleanTempDelegationConfigBOs(delegationConfigBOList);
					}
					getSiteDetailsManager().saveDelegationConfig();
					validationSuccess = true;
					if(modifySite == true){
						session.setAttribute(ALOCConstants.PORTAL_SUCCESSMSG,ALOCConstants.SITE +
								siteDetailsBO.getModel().getSiteName()+ALOCConstants.SITE_UPDATE_SUCCESS);
					}else{
						session.setAttribute(ALOCConstants.PORTAL_SUCCESSMSG,ALOCConstants.SITE +
								siteDetailsBO.getModel().getSiteName()+ALOCConstants.SITE_CREATE_SUCCESS);
					}
					break;
				}
			}catch(HWFServiceException hse){						
				addActionError(hse.getReason());				
			}
		}
		return ALOCConstants.SECTION_CONTROLLER_PAGE;
	}


	/**
	 * Method to get the Copy Site Details
	 * @return COPY_SITE
	 * @throws HWFServiceException
	 */
	public String getCopySiteDetails() throws HWFServiceException {
		HttpServletRequest request = ServletActionContext.getRequest();
		copySite = true;
		modifySite = false;

		SiteAdminHelper.removeActiveSite();
		String siteId =  request.getParameter(ALOCConstants.SELECT_SITENAME);
		SiteAdmin siteAdmin = getSiteDetailsManager().openBusinessAdmin(siteId);
		editMode = false;
		SiteAdminHelper.setAllIdsEmpty(siteAdmin);
		siteAdmin.setDelegationConfiguration(null);

		siteDetailsBO = new SiteDetailsBO(siteAdmin);
		SiteAdminHelper.setActiveSite(siteDetailsBO);

		return ALOCConstants.COPY_SITE;
	}

	/**
	 * Method to get the Modify Site Details
	 * @return MODIFY_SITE
	 * @throws HWFServiceException
	 */
	public String getModifySiteDetails() throws HWFServiceException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String siteId =  request.getParameter(ALOCConstants.SITE_ID);
		modifySite = true;
		copySite = false;

		SiteAdmin siteAdmin = getSiteDetailsManager().openBusinessAdmin(siteId);
		SiteAdminHelper.setDelegOpcodeUpdate(siteAdmin);

		siteDetailsBO = new SiteDetailsBO(siteAdmin);
		SiteAdminHelper.setActiveSite(siteDetailsBO);

		return ALOCConstants.MODIFY_SITE;
	}

	/**
	 * Method to validate and Save the Section
	 * @return to saveSection()
	 * @throws HWFServiceException 
	 */
	public String validateAndSaveSection() throws HWFServiceException {
		return saveSection();
	}


	/**
	 * Method to add the Custom Field for the Customized Site References
	 * @return SUCCESS
	 */
	public String addCustomField() {
		this.sectionId = SiteSectionId.CUSTOMIZED_SITE_REFERENCES;
		ignoreParentSites = true;
		SiteAdmin siteAdmin = getSiteAdmin();
		if(siteAdmin.getCustomizedSiteReferences() == null || siteAdmin.getCustomizedSiteReferences().getSiteCustoms().isEmpty()) {
			customFieldAddIndex = ALOCConstants.CUSTOMFIELD_INCREASE_INDEX;
		} else {
			customFieldAddIndex = siteAdmin.getCustomizedSiteReferences().getSiteCustoms().size();
		}
		return SUCCESS;
	}

	/**
	 * Method to remove the Custom Field for the Customized Site References
	 * @return SUCCESS
	 */
	public String removeCustomField() {
		this.sectionId = SiteSectionId.CUSTOMIZED_SITE_REFERENCES;
		ignoreParentSites = true;
		SiteAdmin siteAdmin = getSiteAdmin();
		List<String> customSites = (siteAdmin.getCustomizedSiteReferences() != null) ? siteAdmin.getCustomizedSiteReferences().getSiteCustoms() : null;
		if(customSites != null && customSites.size() > customFieldRemoveIndex) {
			customSites.remove(customFieldRemoveIndex);
		}
		return SUCCESS;
	}

	/**
	 * Method to create A Group
	 * @return SUCCESS
	 * @throws HWFServiceException 
	 */
	public String createGroup() throws HWFServiceException {
		try{
			String validateStr = getSiteDetailsManager().validateGroup(groupName);
			if(validateStr!=null && validateStr.equals(ALOCConstants.VALID)){
				Group group = new Group();
				group.setGroupName(groupName);
				DelegationConfiguration delegationConfig = siteDetailsBO.getModel().getDelegationConfiguration();
				if(delegationConfig == null) {
					delegationConfig = new DelegationConfiguration();
					siteDetailsBO.getModel().setDelegationConfiguration(delegationConfig);
				}
				ApprovalGroupConfiguration appGroupConfiguration = delegationConfig.getApprovalGroupConfiguration();
				if(appGroupConfiguration == null) {
					appGroupConfiguration = new ApprovalGroupConfiguration();
					delegationConfig.setApprovalGroupConfiguration(appGroupConfiguration);
				}
				if(appGroupConfiguration.getGroups().size() >= ALOCConstants.APPROVERGROUP_MAX_SIZE){
					addActionError(ALOCConstants.GROUP_VALIDATION_MSG);
					delegationConfig.setComments(ALOCConstants.GROUP_VALIDATION_MSG);
				}else{
					delegationConfig.setComments(null);
					appGroupConfiguration.getGroups().add(group);
					getSiteDetailsManager().saveGroup(groupName);
				}
			}
		}catch(HWFServiceException hse){						
			addActionError(hse.getReason());
			siteDetailsBO.getModel().getDelegationConfiguration().setComments(hse.getReason());
		}
		return  SUCCESS;
	}
	
	/**
	 * Method to delete A Group
	 * @return SUCCESS
	 * @throws HWFServiceException 
	 */
	public String deleteGroup() throws HWFServiceException {
		try{
			if(StringUtils.isNotBlank(delegates)){
				getSiteDetailsManager().deleteGroup(delegates);
			}
		}catch(HWFServiceException hse){						
			addActionError(hse.getReason());
			siteDetailsBO.getModel().getDelegationConfiguration().setComments(hse.getReason());
		}
		return  SUCCESS;
	}

	/**
	 * Method to add the DelegationConfig Row
	 * @return SUCCESS
	 * @throws HWFServiceException
	 */
	public String delegationConfig() throws HWFServiceException {
		ignoreParentSites = true;
		return SUCCESS;
	}

	/**
	 * Method to get the Available Approvers
	 * @return availableSiteApproversMap
	 * @throws HWFServiceException 
	 */
	private Map<String, UserDetails> getAvailbleApprovers() throws HWFServiceException {
		Map<String, UserDetails> availableSiteApproversMap = SiteAdminHelper.getAvailableSiteApprovers();
		if(availableSiteApproversMap == null) {
			List<UserDetails> availableApprovers = getSiteDetailsManager().getAvailableAprrovers();
			SiteAdminHelper.setAvailableSiteApprovers(availableApprovers);
		}
		return availableSiteApproversMap;
	}

	/**
	 * Method to add the Group
	 * @return SUCCESS
	 * @throws HWFServiceException
	 */
	public String addGroup() throws HWFServiceException {
		return SUCCESS;
	}

	/**
	 * This method decides the page to display on validation error conditions
	 */
	public String getInputResultName() {
		if(sectionId == SiteSectionId.CREATE_DELEGATION_CONFIGURATION) {
			siteDetailsBO = SiteAdminHelper.getActiveSite();
			DelegationConfiguration deleg = siteDetailsBO.getModel().getDelegationConfiguration();
			List<DelegationConfig> delegLstNew = SiteAdminHelper.setDelegFlagToEmpty(deleg);
			siteDetailsBO.getModel().getDelegationConfiguration().setDelegationConfigs(delegLstNew);
			
			HttpSession session = ServletActionContext.getRequest().getSession();
			String delegValidMsg = (String) session.getAttribute(ALOCConstants.VALIDATE_DELEGATION);
			
			if(delegValidMsg!=null){
				addActionError(delegValidMsg);
				session.removeAttribute(ALOCConstants.VALIDATE_DELEGATION);
			}
		}
		validationSuccess = false;
		return INPUT;
	}

	/* -------------------------------------------------------------------------------------------------------------------------------- 
	 * 											PROPERTY SETTER/GETTER METHODS
	 --------------------------------------------------------------------------------------------------------------------------------- */

	/**
	 * This method is used to get ignoreParentSites
	 * @return the ignoreParentSites
	 */
	public boolean isIgnoreParentSites() {
		return ignoreParentSites;
	}

	/**
	 * This method is used to set ignoreParentSites
	 * @param ignoreParentSites the ignoreParentSites to set
	 */
	public void setIgnoreParentSites(boolean ignoreParentSites) {
		this.ignoreParentSites = ignoreParentSites;
	}

	/**
	 * This method is used to get modifySite
	 * @return the modifySite
	 */
	public boolean isModifySite() {
		return modifySite;
	}

	/**
	 * This method is used to set modifySite
	 * @param modifySite the modifySite to set
	 */
	public void setModifySite(boolean modifySite) {
		this.modifySite = modifySite;
	}

	/**
	 * This method is used to get copySite
	 * @return copySite
	 */
	public boolean isCopySite() {
		return copySite;
	}

	/**
	 * This method is used to set copySite
	 * @param copySite
	 */
	public void setCopySite(boolean copySite) {
		this.copySite = copySite;
	}

	/**
	 * This method is used to get the Available Approvers Map
	 * @return
	 * @throws HWFServiceException 
	 */
	public Map<String, String> getAvailableApproversMap() throws HWFServiceException {
		Map<String, UserDetails> availableApprovers = getAvailbleApprovers();
		return SiteAdminHelper.crateSSOToNameMap(availableApprovers.values());
	}

	/**
	 * This method is used to get SectionId
	 * @return the sectionId
	 */
	public String getSectionId() {
		return (sectionId != null) ? sectionId.getAsString() : null;
	}

	/**
	 * This method is used to set the SectionId
	 * @param sectionId the sectionId to set
	 */
	public void setSectionId(String sectionId) {
		SiteSectionId siteSectionId = null;
		if(StringUtils.isNotBlank(sectionId)) {
			siteSectionId = SiteSectionId.fromString(sectionId);
		}
		this.sectionId = siteSectionId;
	}

	/**
	 * This method is used to get SiteAdmin Model
	 * @return SiteAdmin
	 */
	public SiteAdmin getSiteAdmin() {
		return getSiteDetailsBO().getModel();
	}



	/**
	 * This method is used to get siteDetailsBO
	 * @return the siteDetailsBO
	 */
	public SiteDetailsBO getSiteDetailsBO() {
		if(siteDetailsBO == null) {
			siteDetailsBO = SiteAdminHelper.getActiveSite();
		} 
		return siteDetailsBO;
	}

	/**
	 * This method is used to get customFieldAddIndex
	 * @return the customFieldAddIndex
	 */
	public int getCustomFieldAddIndex() {
		return customFieldAddIndex;
	}

	/**
	 * This method is used to get customFieldRemoveIndex
	 * @return the customFieldRemoveIndex
	 */
	public int getCustomFieldRemoveIndex() {
		return customFieldRemoveIndex;
	}

	/**
	 * This method is used to set customFieldAddIndex
	 * @param customFieldAddIndex the customFieldAddIndex to set
	 */
	public void setCustomFieldAddIndex(int customFieldAddIndex) {
		this.customFieldAddIndex = customFieldAddIndex;
	}

	/**
	 * This method is used to set customFieldRemoveIndex
	 * @param customFieldRemoveIndex the customFieldRemoveIndex to set
	 */
	public void setCustomFieldRemoveIndex(int customFieldRemoveIndex) {
		this.customFieldRemoveIndex = customFieldRemoveIndex;
	}

	/**
	 * This method is used to get the Selected Approvers
	 * @return
	 */
	public Map<String, String> getSelectedApprovers() {
		Map<String, UserDetails> selectedApprovers = SiteAdminHelper.getSelectedApprovers();
		return SiteAdminHelper.crateSSOToNameMap(selectedApprovers.values());
	}

	/**
	 * This method is used to get editMode
	 * @return editMode
	 */
	public boolean isEditMode() {
		return editMode;
	}

	/**
	 * This method is used to set editMode
	 * @param editMode
	 */
	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}

	/**
	 * This method is used to get groupName
	 * @return the groupName
	 */
	public String getGroupName() {
		return groupName;
	}

	/**
	 * This method is used to set groupName
	 * @param groupName the groupName to set
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	/**
	 * This is used to set validation Success Flag
	 * @return
	 */
	public boolean isValidationSuccess() {
		return validationSuccess;
	}

	/**
	 * This is used to set validation Success Flag
	 * @param validationSuccess
	 */
	public void setValidationSuccess(boolean validationSuccess) {
		this.validationSuccess = validationSuccess;
	}
	
	/**
	 * This is used to get the Group Value
	 * @return the delegates
	 */
	public String getDelegates() {
		return delegates;
	}

	/**
	 * This is used to set the Group Value
	 * @param delegates the delegates to set
	 */
	public void setDelegates(String delegates) {
		this.delegates = delegates;
	}
	
	/* -------------------------------------------------------------------------------------------------------------------------------------------
	 * 														INJECTOR METHODS
	 -------------------------------------------------------------------------------------------------------------------------------------------- */

	/**
	 * This method is used to get siteDetailsManager
	 * @return the siteDetailsManager
	 */
	public ISiteDetailsManager getSiteDetailsManager() {
		return siteDetailsManager;
	}

	/**
	 * This method is used to set siteDetailsManager
	 * @param siteDetailsManager the siteDetailsManager to set
	 */
	public void setSiteDetailsManager(ISiteDetailsManager siteDetailsManager) {
		this.siteDetailsManager = siteDetailsManager;
	}
}