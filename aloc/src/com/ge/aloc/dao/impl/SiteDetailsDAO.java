/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: SiteDetailsDAO.java
 * Purpose: SiteDetailsDAO used for the all site DAO Implementations
 */
package com.ge.aloc.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.ge.aloc.InstrumentType;
import com.ge.aloc.OpCode;
import com.ge.aloc.ServiceClientSupport;
import com.ge.aloc.bo.SiteDetailsBO;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.dao.ISiteDetailsDAO;
import com.ge.aloc.model.ActionDetails;
import com.ge.aloc.model.ApprovalGroupConfiguration;
import com.ge.aloc.model.BankFeePaymentSetup;
import com.ge.aloc.model.BankSWIFTConfiguration;
import com.ge.aloc.model.DelegationConfig;
import com.ge.aloc.model.DelegationConfiguration;
import com.ge.aloc.model.Group;
import com.ge.aloc.model.GroupAssignment;
import com.ge.aloc.model.Instrument;
import com.ge.aloc.model.MDM;
import com.ge.aloc.model.MDM.GetApprovers;
import com.ge.aloc.model.MsgHeader;
import com.ge.aloc.model.SiteAdmin;
import com.ge.aloc.model.SiteType;
import com.ge.aloc.model.UserDetails;
import com.ge.aloc.util.ALOCCommonHelper;
import com.ge.aloc.util.SiteAdminHelper;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author madhusudhan.gosula
 *
 */
public class SiteDetailsDAO extends ServiceClientSupport implements ISiteDetailsDAO {


	/**
	 * Method to invoke the Service for the Create Site
	 * @param SiteAdmin
	 * @return siteAdmin
	 * @throws HWFServiceException
	 */
	public SiteAdmin createSite(SiteAdmin siteAdmin) throws HWFServiceException {

		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.SAVE.getOperationCode());
		siteAdmin.setMsgHeader(msgHeader);

		siteAdmin = SiteAdminHelper.setParentsiteAndSiteName(siteAdmin);
		siteAdmin.setBankFeePaymentSetup(new BankFeePaymentSetup());
		siteAdmin.setBankSWIFTConfiguration(new BankSWIFTConfiguration());

		ActionDetails actionDet = new ActionDetails();
		actionDet.setActionName(OpCode.SAVE.getOperationCode());
		siteAdmin.setActionDetails(actionDet);

		siteAdmin = serviceClient.invokeService(OpCode.CREATESITESETUP.getOperationCode(), siteAdmin, SiteAdmin.class);
		return siteAdmin;
	}

	/**
	 * Method to invoke the Service for the Default Delivery Instructions Save Functionality
	 * @param SiteAdmin
	 * @return
	 * @throws HWFServiceException
	 */
	public SiteAdmin saveDefaultDelivary(SiteAdmin siteadmin) throws HWFServiceException {
		if (siteadmin.getDeliveryInstructions() != null) {
			ActionDetails actionDet = new ActionDetails();
			actionDet.setActionName(OpCode.SAVE.getOperationCode());
			siteadmin.getDeliveryInstructions().setActionDetails(actionDet);
			siteadmin.getDeliveryInstructions().setOpCode(OpCode.SAVE.getOperationCode());
			siteadmin = invokeService(siteadmin);
		}
		return siteadmin;
	}

	/**
	 * Method to invoke the Service for the Customized Site References Save Functionality
	 * @param SiteAdmin
	 * @return
	 * @throws HWFServiceException
	 */
	public SiteAdmin saveCustomizedSiteReferences(SiteAdmin siteadmin) throws HWFServiceException {
		if (siteadmin.getCustomizedSiteReferences() != null) {
			ActionDetails actionDet = new ActionDetails();
			actionDet.setActionName(OpCode.SAVE.getOperationCode());
			siteadmin.getCustomizedSiteReferences().setActionDetails(actionDet);
			siteadmin = invokeService(siteadmin);
		}
		return siteadmin;
	}

	/**
	 * Method to invoke the Service for the Bank Site Creation
	 * @param SiteAdmin
	 * @return
	 * @throws HWFServiceException
	 */
	public SiteAdmin createBankSite(SiteAdmin siteAdmin) throws HWFServiceException {
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.SAVE.getOperationCode());
		siteAdmin.setMsgHeader(msgHeader);
		siteAdmin = SiteAdminHelper.setParentsiteAndSiteName(siteAdmin);

		ActionDetails actionDet = new ActionDetails();
		actionDet.setActionName(OpCode.SAVE.getOperationCode());
		siteAdmin.setActionDetails(actionDet);

		siteAdmin = serviceClient.invokeService(OpCode.CREATESITESETUP.getOperationCode(), siteAdmin, SiteAdmin.class);
		return siteAdmin;
	}


	/**
	 * Method to invoke the Service for the Delegation Configuration Save Functionality
	 * @param SiteAdmin
	 * @return
	 * @throws HWFServiceException
	 */
	public void saveDelegationConfig(SiteAdmin siteadmin) throws HWFServiceException {

		ActionDetails actionDet = new ActionDetails();
		actionDet.setActionName(OpCode.SAVE.getOperationCode());
		siteadmin.getDelegationConfiguration().setActionDetails(actionDet);

		List<DelegationConfig> delegationConfiglst= siteadmin.getDelegationConfiguration().getDelegationConfigs();
		for(DelegationConfig delegationConfig:delegationConfiglst){
			List<GroupAssignment> groupAssignments = delegationConfig.getGroupAssignments();
			int level = ALOCConstants.MIN_VALUE;
			for(GroupAssignment groupAssignment:groupAssignments){
				if(groupAssignment.getOpCode()!=null){
					if(groupAssignment.getGroupId()==null && groupAssignment.getOpCode().equals(ALOCConstants.DELETE)){
						groupAssignments.remove(groupAssignment);
					}
					if(!(groupAssignment.getOpCode().equals(OpCode.DELETE))){
						groupAssignment.setGroupLevel(level);
						level =level+ALOCConstants.MIN_VALUE;
					}
					if(groupAssignment.getGroupId()!=null && !(groupAssignment.getOpCode().equals(ALOCConstants.DELETE))){
						groupAssignment.setOpCode(ALOCConstants.UPDATE);
					}
				}
			}
			
			BigInteger configId = delegationConfig.getDelegationConfigId();
			String opCode = delegationConfig.getOpCode();
			if(configId != null && opCode != ALOCConstants.EMPTY_STRING && opCode != ALOCConstants.DELETE){
				delegationConfig.setOpCode(ALOCConstants.UPDATE);
			}

			List<Instrument> instLst = delegationConfig.getInstruments();
			List<Integer> ItrIdsLst = new ArrayList<Integer>();
			for(Instrument inst: instLst){
				ItrIdsLst.add(inst.getInstrId());
			}
			if((ItrIdsLst.size()==ALOCConstants.SECOND_VALUE && ItrIdsLst.contains(InstrumentType.SURETY_BOND.getId()) && ItrIdsLst.contains(InstrumentType.RIDER.getId())) || 
					(ItrIdsLst.size()==ALOCConstants.MIN_VALUE && (ItrIdsLst.contains(InstrumentType.SURETY_BOND.getId()) || ItrIdsLst.contains(InstrumentType.RIDER.getId())))){
				delegationConfig.setNotificationCaluseFlag(ALOCConstants.EMPTY_STRING);
				delegationConfig.setCurePeriodIndicatorFlag(ALOCConstants.EMPTY_STRING);
				delegationConfig.setGEAppDrawFlag(ALOCConstants.EMPTY_STRING);
			}
		}
		siteadmin=invokeService(siteadmin);
		setAsActiveSite(siteadmin);
	}

	/**
	 *  Method to invoke the Service to get the Available Approvers
	 * @param siteAdmin
	 * @return userDetailsLst
	 * @throws HWFServiceException
	 */
	public List<UserDetails> getAvailableAprrovers(SiteAdmin siteAdmin) throws HWFServiceException {

		MDM mdmObject = new MDM();
		MsgHeader msgHeader = new MsgHeader();
		msgHeader.setOpcode(OpCode.APPROVERS.getOperationCode());

		mdmObject.setMsgHeader(msgHeader);
		GetApprovers getApp = new GetApprovers();
		int siteTypeId =siteAdmin.getSiteType().getSiteTypeId();
		BigInteger siteTypeIdBigInt = new BigInteger(String.valueOf(siteTypeId));
		getApp.setSiteTypeId(siteTypeIdBigInt);
		getApp.setSiteTypeName(siteAdmin.getSiteType().getSiteTypeName());
		getApp.setSiteId(BigInteger.valueOf(siteAdmin.getSiteId()));
		getApp.setSiteName(siteAdmin.getSiteName());
		mdmObject.setGetApprovers(getApp);

		mdmObject = serviceClient.invokeService(OpCode.MDM.getOperationCode(), mdmObject,MDM.class);
		getApp = mdmObject.getGetApprovers();

		List<UserDetails> userDetailsLst = getApp.getUserDetails();
		return userDetailsLst;
	}

	/**
	 * Method to invoke the Service to save the Group
	 * @param siteAdmin
	 * @param gourpName
	 * @throws HWFServiceException 
	 */
	public void saveGroup(SiteAdmin siteAdmin, String groupName) throws HWFServiceException {
		List<Group> allGroups = siteAdmin.getDelegationConfiguration().getApprovalGroupConfiguration().getGroups();
		Group groupToSave = SiteAdminHelper.findApproverGroupByName(allGroups, groupName);

		if(groupToSave != null) {
			if(groupToSave.getGroupId() == null) {
				groupToSave.setOpCode(OpCode.INSERT.getOperationCode());
			} else {
				groupToSave.setOpCode(OpCode.UPDATE.getOperationCode());
			}

			SiteAdmin siteAdminToSave = new SiteAdmin();
			siteAdminToSave.setSiteId(siteAdmin.getSiteId());
			SiteType siteType = new SiteType();
			siteAdminToSave.setSiteType(siteType);
			siteType.setSiteTypeId(siteAdmin.getSiteType().getSiteTypeId());
			siteType.setSiteTypeName(siteAdmin.getSiteType().getSiteTypeName());

			DelegationConfiguration delegConfig = new DelegationConfiguration();
			delegConfig.setOpCode(OpCode.SAVE.getOperationCode());
			siteAdminToSave.setDelegationConfiguration(delegConfig);
			delegConfig.setApprovalGroupConfiguration(new ApprovalGroupConfiguration());
			delegConfig.getApprovalGroupConfiguration().getGroups().add(groupToSave);
			SiteAdmin savedSiteAdmin = invokeService(siteAdminToSave);
			siteAdmin.getDelegationConfiguration().setApprovalGroupConfiguration(savedSiteAdmin.getDelegationConfiguration().getApprovalGroupConfiguration());
			siteAdmin.getDelegationConfiguration().setComments(savedSiteAdmin.getDelegationConfiguration().getComments());
		}
	}
	
	/**
	 * Method to invoke the Service to Delete the Group
	 * @param siteAdmin
	 * @param gourpName
	 * @throws HWFServiceException 
	 */
	public void deleteGroup(SiteAdmin siteAdmin, String groupId) throws HWFServiceException {
		List<Group> allGroups = siteAdmin.getDelegationConfiguration().getApprovalGroupConfiguration().getGroups();
		Group groupToDelete = SiteAdminHelper.findApproverGroupById(allGroups, Integer.valueOf(groupId));

		if(groupToDelete != null) {
			if(groupToDelete.getGroupId() != null) {
				groupToDelete.setOpCode(OpCode.DELETE.getOperationCode());
			} 
			SiteAdmin siteAdminToSave = new SiteAdmin();
			siteAdminToSave.setSiteId(siteAdmin.getSiteId());
			SiteType siteType = new SiteType();
			siteAdminToSave.setSiteType(siteType);
			siteType.setSiteTypeId(siteAdmin.getSiteType().getSiteTypeId());
			siteType.setSiteTypeName(siteAdmin.getSiteType().getSiteTypeName());

			DelegationConfiguration delegConfig = new DelegationConfiguration();
			delegConfig.setOpCode(OpCode.SAVE.getOperationCode());
			siteAdminToSave.setDelegationConfiguration(delegConfig);
			delegConfig.setApprovalGroupConfiguration(new ApprovalGroupConfiguration());
			delegConfig.getApprovalGroupConfiguration().getGroups().add(groupToDelete);
			SiteAdmin savedSiteAdmin = invokeService(siteAdminToSave);
			ApprovalGroupConfiguration approvalGrpConfig = savedSiteAdmin.getDelegationConfiguration() != null ? 
					savedSiteAdmin.getDelegationConfiguration().getApprovalGroupConfiguration():null;
			siteAdmin.getDelegationConfiguration().setApprovalGroupConfiguration(approvalGrpConfig);
			siteAdmin.getDelegationConfiguration().setComments(savedSiteAdmin.getDelegationConfiguration().getComments());
		}
	}

	/**
	 * Method to invoke the Service to validate the group
	 * @throws HWFServiceException
	 * @param siteAdmin
	 * @param gourpName
	 * @return Comments
	 */
	public String validateGroup(SiteAdmin siteAdmin, String groupName) throws HWFServiceException {
		SiteAdmin siteAdminNew = new SiteAdmin();
		DelegationConfiguration delegConfig = new DelegationConfiguration();

		delegConfig.setComments(groupName);
		siteAdminNew.setSiteId(siteAdmin.getSiteId());
		siteAdminNew.setDelegationConfiguration(delegConfig);

		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.SAVE.getOperationCode());
		siteAdminNew.setMsgHeader(msgHeader);

		siteAdminNew = serviceClient.invokeService(OpCode.GROUPEXISTEDORNOT.getOperationCode(), siteAdminNew, SiteAdmin.class);
		String validatestr = siteAdminNew.getDelegationConfiguration().getComments();
		if(!(validatestr.equals(ALOCConstants.VALID))){
			siteAdmin.getDelegationConfiguration().setComments(validatestr);
		}else{
			siteAdmin.getDelegationConfiguration().setComments(ALOCConstants.EMPTY_STRING);
		}

		setAsActiveSite(siteAdmin);

		return validatestr;
	}

	/**
	 * Method to Open the Business SiteAdmin page
	 * @throws HWFServiceException
	 * @return siteAdmin
	 * @param siteId
	 */
	public SiteAdmin openBusinessAdmin(String siteId) throws HWFServiceException {
		SiteAdmin siteAdmin = new SiteAdmin();
		siteAdmin.setSiteId(Integer.parseInt(siteId)); 
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.SAVE.getOperationCode());
		siteAdmin.setMsgHeader(msgHeader);

		siteAdmin = serviceClient.invokeService(OpCode.GETSITESETUPDETAILS.getOperationCode(), siteAdmin, SiteAdmin.class);
		return siteAdmin;
	}

	/**
	 * Method to Save SiteAdmin Delegates section
	 * @param delegates
	 * @param adminAvailableApprovers
	 * @param siteAdmin
	 * @return siteAdmin
	 * @throws HWFServiceException
	 */
	public SiteAdmin saveBusinessDelegates(SiteAdmin siteAdmin) throws HWFServiceException {
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.SITEADMIN_UPDATE.getOperationCode());
		siteAdmin.setMsgHeader(msgHeader);

		siteAdmin = serviceClient.invokeService(OpCode.SITEADMIN_UPDATE.getOperationCode(), siteAdmin, SiteAdmin.class);

		return siteAdmin;
	}

	/**
	 * Method to invoke the Service
	 * @param siteAdmin
	 * @return siteAdmin
	 */
	private SiteAdmin invokeService(SiteAdmin siteAdmin) throws HWFServiceException {
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.SAVE.getOperationCode());
		siteAdmin.setMsgHeader(msgHeader);

		siteAdmin = serviceClient.invokeService(OpCode.CREATESITESETUP.getOperationCode(), siteAdmin, SiteAdmin.class);
		return siteAdmin;
	}

	/**
	 * Method to set the Active Site
	 * @param siteAdmin
	 */
	private void setAsActiveSite(SiteAdmin siteAdmin) {
		SiteDetailsBO siteDetailsBO = new SiteDetailsBO(siteAdmin);
		SiteAdminHelper.setActiveSite(siteDetailsBO);
	}
}
