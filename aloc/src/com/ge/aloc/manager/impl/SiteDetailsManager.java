/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: SiteDetailsManager.java
 * Purpose: SiteDetailsManager used for the all site operations
 */
package com.ge.aloc.manager.impl;

import java.util.List;

import com.ge.aloc.bo.SiteDetailsBO;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.dao.ISiteDetailsDAO;
import com.ge.aloc.manager.ISiteDetailsManager;
import com.ge.aloc.model.BankSwift;
import com.ge.aloc.model.SiteAdmin;
import com.ge.aloc.model.UserDetails;
import com.ge.aloc.util.SiteAdminHelper;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author madhusudhan.gosula
 *
 */
public class SiteDetailsManager implements ISiteDetailsManager {

	private ISiteDetailsDAO siteDetailsDAO;

	/**
	 * This method is used to Create A Site
	 * @throws HWFServiceException 
	 * @see com.ge.aloc.manager.ISiteDetailsManager#createSite()
	 */
	public SiteAdmin createSite(SiteDetailsBO siteDetailsBO) throws HWFServiceException {
			if(siteDetailsBO.getModel().getCustomizedSiteReferences()!=null){
				siteDetailsBO.getModel().getCustomizedSiteReferences().setActionDetails(null);
				}
			if(siteDetailsBO.getModel().getDeliveryInstructions()!= null){
				siteDetailsBO.getModel().getDeliveryInstructions().setActionDetails(null);
				}
			if(siteDetailsBO.getModel().getDelegationConfiguration()!= null){
				siteDetailsBO.getModel().getDelegationConfiguration().setActionDetails(null);
				}
		return siteDetailsDAO.createSite(siteDetailsBO.getModel());
	}

	/**
	 * This method is used to Save Default Delivery Instructions section
	 * @throws HWFServiceException 
	 * @see com.ge.aloc.manager.ISiteDetailsManager#saveDefaultDelivary()
	 */
	public SiteAdmin saveDefaultDelivary() throws HWFServiceException {
		SiteAdmin siteAdmin = SiteAdminHelper.getActiveSite().getModel();
		if(siteAdmin!= null){
			siteAdmin.setActionDetails(null);
			if(siteAdmin.getCustomizedSiteReferences()!=null){
				siteAdmin.getCustomizedSiteReferences().setActionDetails(null);
				}
			if(siteAdmin.getDelegationConfiguration()!= null){
				siteAdmin.getDelegationConfiguration().setActionDetails(null);
				}
		}
		return siteDetailsDAO.saveDefaultDelivary(siteAdmin);
	}

	/**
	 * This method is used to Save Customized Site References Section
	 * @throws HWFServiceException 
	 * @see com.ge.aloc.manager.ISiteDetailsManager#saveCustomizedSiteReferences()
	 */
	public SiteAdmin saveCustomizedSiteReferences(SiteDetailsBO siteDetailsBO) throws HWFServiceException {
		if(siteDetailsBO!= null){
			siteDetailsBO.getModel().setActionDetails(null);
			if(siteDetailsBO.getModel().getDeliveryInstructions()!= null){
				siteDetailsBO.getModel().getDeliveryInstructions().setActionDetails(null);
				}
			if(siteDetailsBO.getModel().getDelegationConfiguration()!= null){
				siteDetailsBO.getModel().getDelegationConfiguration().setActionDetails(null);
				}
		}
		return siteDetailsDAO.saveCustomizedSiteReferences(siteDetailsBO.getModel());
	}

	/**
	 * This method is used to Create A Bank Site
	 * @throws HWFServiceException 
	 * @see com.ge.aloc.manager.ISiteDetailsManager#saveBankSwiftConfig()
	 */
	public SiteAdmin createBankSite(SiteDetailsBO siteDetailsBO) throws HWFServiceException {
		SiteAdmin siteadmin = siteDetailsBO.getModel();
		if(siteadmin.getBankSWIFTConfiguration()!=null){
			List<BankSwift> bankSwtLst = siteadmin.getBankSWIFTConfiguration().getBankSwifts();
			for(BankSwift eachSft: bankSwtLst){
				if(eachSft.isMessageSupport() == null || eachSft.isMessageSupport() == false){
					eachSft.setMessageDirection(ALOCConstants.EMPTY_STRING);
				}
			}
		}
		if(siteadmin!= null){
			if(siteadmin.getCustomizedSiteReferences()!=null){
				siteadmin.getCustomizedSiteReferences().setActionDetails(null);
				}
			if(siteadmin.getDeliveryInstructions()!= null){
				siteadmin.getDeliveryInstructions().setActionDetails(null);
				}
			if(siteadmin.getDelegationConfiguration()!= null){
				siteadmin.getDelegationConfiguration().setActionDetails(null);
				}
		}
		return siteDetailsDAO.createBankSite(siteadmin);
	}

	/**
	 * This method is used to Save DelegationConfig Section
	 * @throws HWFServiceException 
	 * @see com.ge.aloc.manager.ISiteDetailsManager#saveDelegationConfig()
	 */
	public void saveDelegationConfig() throws HWFServiceException {
		SiteAdmin siteAdmin = SiteAdminHelper.getActiveSite().getModel();
		if(siteAdmin!= null){
			siteAdmin.setActionDetails(null);
			if(siteAdmin.getCustomizedSiteReferences()!=null){
				siteAdmin.getCustomizedSiteReferences().setActionDetails(null);
				}
			if(siteAdmin.getDeliveryInstructions()!= null){
				siteAdmin.getDeliveryInstructions().setActionDetails(null);
				}
		}
		siteDetailsDAO.saveDelegationConfig(siteAdmin);
	}

	/**
	 * This method is used to get All Available Approvers
	 * @throws HWFServiceException 
	 * @see com.ge.aloc.manager.ISiteDetailsManager#getAvailableAprrovers()
	 */
	public List<UserDetails> getAvailableAprrovers() throws HWFServiceException{
		return siteDetailsDAO.getAvailableAprrovers(SiteAdminHelper.getActiveSite().getModel());
	}

	/**
	 * This method is used to Save Group
	 * @throws HWFServiceException 
	 * @see com.ge.aloc.manager.ISiteDetailsManager#saveGroup()
	 */
	public void saveGroup(String groupName) throws HWFServiceException{
		siteDetailsDAO.saveGroup(SiteAdminHelper.getActiveSite().getModel(), groupName);
	}
	
	/**
	 * This method is used to Delete Group
	 * @throws HWFServiceException 
	 * @see com.ge.aloc.manager.ISiteDetailsManager#saveGroup()
	 */
	public void deleteGroup(String groupId) throws HWFServiceException{
		siteDetailsDAO.deleteGroup(SiteAdminHelper.getActiveSite().getModel(), groupId);
	}

	/**
	 * This method is used to Validate Group Name
	 * @throws HWFServiceException 
	 * @see com.ge.aloc.manager.ISiteDetailsManager#validateGroup()
	 */
	public String validateGroup(String groupName) throws HWFServiceException{
		return siteDetailsDAO.validateGroup(SiteAdminHelper.getActiveSite().getModel() , groupName);
	}

	/**
	 * This method is used to get siteDetailsDAO
	 * @return the siteDetailsDAO
	 */
	public ISiteDetailsDAO getSiteDetailsDAO() {
		return siteDetailsDAO;
	}
	/**
	 * This method is used to set siteDetailsDAO
	 * @param siteDetailsDAO 
	 */
	public void setSiteDetailsDAO(ISiteDetailsDAO siteDetailsDAO) {
		this.siteDetailsDAO = siteDetailsDAO;
	}

	/**
	 * This method is used to Open BusinessAdmin Page
	 * @throws HWFServiceException 
	 * @see com.ge.aloc.manager.ISiteDetailsManager#openBusinessAdmin()
	 */
	public SiteAdmin openBusinessAdmin(String siteId) throws HWFServiceException  {
		return siteDetailsDAO.openBusinessAdmin(siteId);

	}

	/**
	 * This method is used to Save Delegation Approvers in Business SiteAdmin
	 * @throws HWFServiceException 
	 * @see com.ge.aloc.manager.ISiteDetailsManager#saveBusinessDelegates()
	 */
	public SiteAdmin saveBusinessDelegates(String delegates,List<UserDetails> selectedApprovers,SiteAdmin siteAdmin) throws HWFServiceException  {
		siteAdmin = SiteAdminHelper.setApproverOpcodes(siteAdmin, delegates, selectedApprovers);
		return siteDetailsDAO.saveBusinessDelegates(siteAdmin);

	}

}
