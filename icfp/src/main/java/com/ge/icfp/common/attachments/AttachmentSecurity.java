/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: AttachmentSecurity.java
 * AttachmentSecurity used for security for all deal and leg level attachments
 * 
 * 
 */
package com.ge.icfp.common.attachments;

import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import jxl.common.Logger;

import org.drools.FactException;
import org.drools.RuleBase;
import org.drools.WorkingMemory;
import org.drools.io.RuleBaseLoader;
import org.drools.io.RuleSetLoader;

import com.ge.icfp.common.helper.CurrentDealManager;
import com.ge.icfp.model.DealRequest;

/**
 * @author hariprasad.madas
 * This class used to provide the security for all deal and leg level attachments
 *
 */
public class AttachmentSecurity {
	private static final Logger LOGGER = Logger.getLogger(AttachmentSecurity.class);
	private static final String RULE_CONFIG_FILE = "/drools/icfp_atmt_security.java.drl";
	private static final String REQ_KEY_DEAL_PERMISSIONS = "icfp.atmt.deal.permissions";
	
	/**
	 * This Method gives the deal permissions of current request object
	 * @param request
	 * @return
	 */
	public static DealPermissions getDealPermissions(HttpServletRequest request) {
		DealPermissions dealPermissions = (DealPermissions) request.getAttribute(REQ_KEY_DEAL_PERMISSIONS);
		if(dealPermissions == null) {
			dealPermissions = new DealPermissions(request);
			request.setAttribute(REQ_KEY_DEAL_PERMISSIONS, dealPermissions);
		}
		return dealPermissions;
	}
	
	/**
	 * 
	 * @author chaitanya.n
	 *
	 */
	private static class LazyHolder {
		static final AttachmentSecurity INSTANCE = create();
		
		private static AttachmentSecurity create() {
			AttachmentSecurity attachmentSecurity = new AttachmentSecurity();
			attachmentSecurity.init();
			return attachmentSecurity;
		}
	}
	
	/**
	 * create the instance of the object
	 * @return
	 */
	public static AttachmentSecurity getInstance() {
		return LazyHolder.INSTANCE;
	}
	
	private RuleBase securityRuleBase;
	
	/**
	 * 
	 */
	private AttachmentSecurity() {
	}
	
	/**
	 *  Main method to initialize and rule config file loader and build rule base
	 */
	private void init() {
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		if(cl == null) {
			cl = AttachmentSecurity.class.getClassLoader();
		}
		
		URL url = AttachmentSecurity.class.getResource(RULE_CONFIG_FILE);
		if(url == null) {
			StringBuilder errMsg = new StringBuilder();
			errMsg.append("Rule configuration file ").append(RULE_CONFIG_FILE).append(" not found in the classpath");
			throw new RuntimeException(errMsg.toString());
		}
		
		try {
			RuleSetLoader ruleSetLoader = new RuleSetLoader();
			ruleSetLoader.addFromUrl(url);
			
			RuleBaseLoader ruleBaseLoader = new RuleBaseLoader();
			ruleBaseLoader.addFromRuleSetLoader(ruleSetLoader);
			securityRuleBase = ruleBaseLoader.buildRuleBase();
		} catch (Exception e) {
			StringBuilder errMsg = new StringBuilder();
			errMsg.append("Error while creating RuleBase with the rules ").append(RULE_CONFIG_FILE);
			LOGGER.error(errMsg.toString(), e);
			throw new RuntimeException(errMsg.toString(), e);
		}
	}
	
	/**
	 * This Method returns attachment permissions for particular type
	 * @param type
	 * @param deal
	 * @return
	 * @throws ICFPAttachmentException 
	 */
	public AttachmentPermissions getDealLevelPermissions(AttachmentType type, HttpServletRequest request) throws ICFPAttachmentException {
		DealPermissions dealPermissions = AttachmentSecurity.getDealPermissions(request);
		AttachmentPermissions permissions = new AttachmentPermissions(type, null, dealPermissions);
		populateAccessFlags(permissions);
		permissions.freez();
		return permissions;
	}
	
	/**
	 * This Method gives the leg permissions of current attachment type of leg object
	 * @param type
	 * @param legIndex
	 * @param request
	 * @return
	 * @throws ICFPAttachmentException 
	 */
	public AttachmentPermissions getLegLevelPermissions(AttachmentType type, Integer legIndex, HttpServletRequest request) throws ICFPAttachmentException {
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		Object leg = AttachmentUtils.getLeg(legIndex, deal);
		return getLegLevelPermissions(type, leg, request);
	}
	
	/**
	 * This Method gives the leg and deal permissions of current attachment type of leg object
	 * @param type
	 * @param deal
	 * @param leg
	 * @param derivative
	 * @param exceptionRequest
	 * @param amendment
	 * @return
	 * @throws ICFPAttachmentException 
	 */
	public AttachmentPermissions getLegLevelPermissions(AttachmentType type, Object leg, HttpServletRequest request) throws ICFPAttachmentException {
		DealPermissions dealPermissions = AttachmentSecurity.getDealPermissions(request);
		AttachmentPermissions permissions = new AttachmentPermissions(type, leg, dealPermissions);
		populateAccessFlags(permissions);
		permissions.freez();
		return permissions;
	}
	
	/** 
	 *  This Method used to fire rules for particular attachment permissions
	 * @param permissions
	 * @throws ICFPAttachmentException 
	 */
	private void populateAccessFlags(AttachmentPermissions permissions) throws ICFPAttachmentException {
		try {
			WorkingMemory workingMemory = securityRuleBase.newWorkingMemory();
			workingMemory.assertObject(permissions);
			workingMemory.fireAllRules();
		} catch (FactException e) {
			LOGGER.error("Error while firing the attachment security rules", e);
			throw new ICFPAttachmentException(ICFPAttachmentException.ERROR_CODE_SECURITY_RULES, "Error while firing the attachment security rules", e);
		}
	}
}
