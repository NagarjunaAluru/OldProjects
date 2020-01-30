/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: SiteAdminAction.java
 * Purpose: SiteAdminAction used for the all site operations
 */
package com.ge.aloc.action.siteadmin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.ge.aloc.bo.SiteDetailsBO;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.manager.ISiteDetailsManager;
import com.ge.aloc.model.SiteAdmin;
import com.ge.aloc.util.SiteAdminHelper;
import com.ge.aloc.view.section.SiteSectionId;
import com.hydus.hwf.exceptions.HWFServiceException;
import com.hydus.hwf.util.StringUtils;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.ValidationWorkflowAware;

/**
 * @author chaitanya.n
 *
 */
public class SiteAdminAction extends ActionSupport implements ValidationWorkflowAware{

	private static final long serialVersionUID = -8160867239431026163L;

	private ISiteDetailsManager siteDetailsManager;
	private static SiteDetailsBO siteDetailsBO;
	private boolean editMode;
	private SiteSectionId sectionId;
	private boolean modifySite;
	private boolean copySite;
	private String bankName;
	private String bankSelection;
	private String bankCountryCd;
	private String bankCity;
	private String goldId;
	private String goldIdSelection;
	protected boolean createSiteValidate;

	/**
	 * Method to Open the Site Admin Page
	 * @return OPEN_SITEADMIN_PAGE
	 */
	public String openSiteAdminPage() {
		SiteAdminHelper.removeActiveSite();
		siteDetailsBO = new SiteDetailsBO(new SiteAdmin()); 

		return ALOCConstants.OPEN_SITEADMIN_PAGE;
	}

	/**
	 * Method to create A Site
	 * @return OPEN_ACTIVE_SITE
	 * @throws HWFServiceException 
	 */
	public String createSite() throws HWFServiceException {
		try{
			SiteDetailsBO siteDetailsBOOld = SiteAdminHelper.getActiveSiteCreate();
			SiteAdmin siteAdmin = siteDetailsManager.createSite(siteDetailsBO);
			SiteAdminHelper.setDelegationValues(siteDetailsBO, siteAdmin, siteDetailsBOOld);
			
			editMode = true;
			createSiteValidate = true;
			SiteAdminHelper.setActiveSite(siteDetailsBO);

			HttpSession session = ServletActionContext.getRequest().getSession();
			if(siteDetailsBO.getModel().isHeaderSiteOnly() == true){
				if(modifySite == true){
					session.setAttribute(ALOCConstants.PORTAL_SUCCESSMSG,siteAdmin.getComments());
				}else{
					session.setAttribute(ALOCConstants.PORTAL_SUCCESSMSG,siteAdmin.getComments());
				}
			}
			addActionMessage(siteAdmin.getComments());
		}catch(HWFServiceException hse){						
			addActionError(hse.getReason());				
		}
		return ALOCConstants.OPEN_ACTIVE_SITE;
	}

	/**
	 * Method to Open BusinessAdmin Page
	 * @return OPENBUSINESSADMIN
	 * @throws HWFServiceException 
	 */
	public String openBusinessAdmin() throws HWFServiceException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String siteId =  request.getParameter(ALOCConstants.SITE_ID);
		if(StringUtils.isNotBlank(siteId)){
			SiteAdmin siteAdmin = getSiteDetailsManager().openBusinessAdmin(siteId);
			siteDetailsBO = new SiteDetailsBO(siteAdmin);
			SiteAdminHelper.setActiveSite(siteDetailsBO);
			return ALOCConstants.OPEN_BUSINESSADMIN_DETAILS;
		}
		return ALOCConstants.OPENBUSINESSADMIN;
	}

	/**
	 * Method to Create A Bank Site
	 * @return
	 * @throws HWFServiceException 
	 */
	public String createBankSite() throws HWFServiceException {
		try{
			HttpSession session = ServletActionContext.getRequest().getSession();
			getSiteDetailsManager().createBankSite(siteDetailsBO);
			editMode = true;
			createSiteValidate = true;
			if(modifySite == true){
				session.setAttribute(ALOCConstants.PORTAL_SUCCESSMSG,ALOCConstants.SITE +
						siteDetailsBO.getModel().getSiteName()+ALOCConstants.SITE_UPDATE_SUCCESS);
			}else{
				session.setAttribute(ALOCConstants.PORTAL_SUCCESSMSG,ALOCConstants.SITE +
						siteDetailsBO.getModel().getSiteName()+ALOCConstants.SITE_CREATE_SUCCESS);
			}
		}catch(HWFServiceException hse){						
			addActionError(hse.getReason());				
		}
		return ALOCConstants.OPEN_ACTIVE_SITE;
	}

	/**
	 * Method to Open the Create Site
	 * @return OPEN_CREATESITE_PAGE
	 */
	public String openCreateSite() {
		SiteAdminHelper.removeActiveSite();
		SiteDetailsBO requestedSite = null;
		SiteAdminHelper.setActiveSite(requestedSite);
		SiteAdmin siteAdmin = new SiteAdmin();
		siteDetailsBO = new SiteDetailsBO(siteAdmin);

		SiteAdminHelper.setActiveSite(siteDetailsBO);
		modifySite = false;
		copySite = false;
		return ALOCConstants.OPEN_CREATESITE_PAGE;
	}

	/**
	 * This method is used to do Validations for BankSwift section 
	 * @return
	 */
	public static Boolean bankSwiftValidate() {
		SiteAdmin siteAdmin = siteDetailsBO.getModel();
		return SiteAdminHelper.validateBankSwift(siteAdmin);
	}

	/**
	 * This method decides the page to display on validation error conditions
	 */
	public String getInputResultName() {
		createSiteValidate = false;
		return INPUT;
	}
	/* -------------------------------------------------------------------------------------------------------------------------------- 
	 * 											PROPERTY SETTER/GETTER METHODS
	 --------------------------------------------------------------------------------------------------------------------------------- */

	/**
	 * This method is used to get Section Id
	 * @return the sectionId
	 */
	public String getSectionId() {
		return (sectionId != null) ? sectionId.getAsString() : null;
	}

	/**
	 * This method is used to set Section Id
	 * @param sectionId 
	 */
	public void setSectionId(String sectionId) {
		SiteSectionId siteSectionId = null;
		if(StringUtils.isNotBlank(sectionId)) {
			siteSectionId = SiteSectionId.fromString(sectionId);
		}
		this.sectionId = siteSectionId;
	}

	/**
	 * This method is used to get siteDetailsBO
	 * @return the siteDetailsBO
	 */
	public SiteDetailsBO getSiteDetailsBO() {
		if(siteDetailsBO == null) {
			siteDetailsBO = new SiteDetailsBO(new SiteAdmin());
		}
		return siteDetailsBO;
	}

	/**
	 * This method is used to set siteDetailsBO
	 * @param siteDetailsBO 
	 */
	@SuppressWarnings("static-access")
	public void setSiteDetailsBO(SiteDetailsBO siteDetailsBO) {
		this.siteDetailsBO = siteDetailsBO;
	}

	/**
	 * This method is used to get SiteAdmin Model
	 * @return SiteAdmin
	 */
	public SiteAdmin getSiteAdmin() {
		return getSiteDetailsBO().getModel();
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
	 * This method is used to get modifySite Value
	 * @return modifySite
	 */
	public boolean isModifySite() {
		return modifySite;
	}

	/**
	 * This method is used to set modifySite Value
	 * @param modifySite
	 */
	public void setModifySite(boolean modifySite) {
		this.modifySite = modifySite;
	}

	/**
	 * This method is used to get copySite Value
	 * @return copySite
	 */
	public boolean isCopySite() {
		return copySite;
	}

	/**
	 * This method is used to set copySite Value
	 * @param copySite 
	 */
	public void setCopySite(boolean copySite) {
		this.copySite = copySite;
	}

	/**
	 * This method is used to get goldId Value
	 * @return goldId
	 */
	public String getGoldId() {
		return goldId;
	}

	/**
	 * This method is used to set goldId Value
	 * @param goldId 
	 */
	public void setGoldId(String goldId) {
		this.goldId = goldId;
	}

	/**
	 * This method is used to get bankName
	 * @return bankName
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * This method is used to set bankName
	 * @param bankName
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	/**
	 * This method is used to get bankCountryCd
	 * @return the bankCountryCd
	 */
	public String getBankCountryCd() {
		return bankCountryCd;
	}

	/**
	 * This method is used to set bankCountryCd
	 * @param bankCountryCd the bankCountryCd to set
	 */
	public void setBankCountryCd(String bankCountryCd) {
		this.bankCountryCd = bankCountryCd;
	}

	/**
	 * This method is used to get bankCity
	 * @return the bankCity
	 */
	public String getBankCity() {
		return bankCity;
	}

	/**
	 * This method is used to set bankCity
	 * @param bankCity the bankCity to set
	 */
	public void setBankCity(String bankCity) {
		this.bankCity = bankCity;
	}

	/**
	 * This method is used to get goldIdSelection
	 * @return the goldIdSelection
	 */
	public String getGoldIdSelection() {
		return goldIdSelection;
	}

	/**
	 * This method is used to set goldIdSelection
	 * @param goldIdSelection 
	 */
	public void setGoldIdSelection(String goldIdSelection) {
		this.goldIdSelection = goldIdSelection;
	}

	/**
	 * This method is used to get bankSelection
	 * @return the bankSelection
	 */
	public String getBankSelection() {
		return bankSelection;
	}

	/**
	 * This method is used to set bankSelection
	 * @param bankSelection 
	 */
	public void setBankSelection(String bankSelection) {
		this.bankSelection = bankSelection;
	}

	/**
	 * This is used to set validation Success Flag
	 * @return
	 */
	public boolean isCreateSiteValidate() {
		return createSiteValidate;
	}

	/**
	 * This is used to set validation Success Flag
	 * @return
	 */
	public void setCreateSiteValidate(boolean createSiteValidate) {
		this.createSiteValidate = createSiteValidate;
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
	 * @param siteDetailsManager 
	 */
	public void setSiteDetailsManager(ISiteDetailsManager siteDetailsManager) {
		this.siteDetailsManager = siteDetailsManager;
	}
}