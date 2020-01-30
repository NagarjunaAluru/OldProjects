/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: AttachmentValidator.java
 * Purpose: Represents Attachment validator for all attachments and comments
 */
package com.ge.icfp.common.attachments.validation;

import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import jxl.common.Logger;

import org.apache.struts.action.ActionErrors;
import org.drools.FactException;
import org.drools.RuleBase;
import org.drools.WorkingMemory;
import org.drools.io.RuleBaseLoader;
import org.drools.io.RuleSetLoader;

import com.ge.icfp.common.attachments.AttachmentSecurity;
import com.ge.icfp.common.attachments.DealPermissions;
import com.ge.icfp.common.attachments.ICFPAttachmentException;
import com.ge.icfp.common.helper.CurrentDealManager;
import com.ge.icfp.model.DealRequest;

/**
 *  Common class for Attachment validator for all attachments and comments
 * @author chaitanya.n
 *
 */
public class AttachmentValidator {
	private static final Logger LOGGER = Logger.getLogger(AttachmentSecurity.class);
	private static final String RULE_CONFIG_FILE = "/drools/icfp_atmt_validation.java.drl";
	private static final String APPDATA_KEY_RESULT_ERRORS = "validationErrors";
	
	/**
	 * 
	 * @author chaitanya.n
	 *
	 */
	private static class LazyHolder {
		static final AttachmentValidator INSTANCE = new AttachmentValidator();
	}
	
	/**
	 * 
	 * @return
	 */
	public static AttachmentValidator getInstance() {
		return LazyHolder.INSTANCE;
	}
	
	private RuleBase validationRuleBase;
	
	/**
	 *  Main Method to call rule config file to perform the class level rules
	 */
	private AttachmentValidator() {
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
			validationRuleBase = ruleBaseLoader.buildRuleBase();
		} catch (Exception e) {
			StringBuilder errMsg = new StringBuilder();
			errMsg.append("Error while creating RuleBase with the rules ").append(RULE_CONFIG_FILE);
			LOGGER.error(errMsg.toString(), e);
			throw new RuntimeException(errMsg.toString(), e);
		}
	}
	
	/**
	 *  Method return action errors if any deal attachments validations are not improper
	 * @param deal
	 * @return
	 * @throws ICFPAttachmentException 
	 */
	public ActionErrors validateDeal(HttpServletRequest request) throws ICFPAttachmentException {
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		DealPermissions dealPermissions = AttachmentSecurity.getDealPermissions(request);
		return execute(new DealAdapter(deal, dealPermissions));
	}
	
	/**
	 * Method return action errors if any leg attachments validations are not improper
	 * @param leg
	 * @param deal
	 * @return
	 * @throws ICFPAttachmentException 
	 */
	public ActionErrors validateLeg(Object leg, HttpServletRequest request) throws ICFPAttachmentException {
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		DealPermissions dealPermissions = AttachmentSecurity.getDealPermissions(request);
		return execute(new LegAdapter(leg, deal, dealPermissions));
	}
	
	/**
	 * Method returns action errors if any of the validations not performed 
	 * @param fact
	 * @return
	 * @throws ICFPAttachmentException 
	 */
	private ActionErrors execute(ValidationAdapter fact) throws ICFPAttachmentException {
	ActionErrors errors = null;
	try {
		WorkingMemory workingMemory = validationRuleBase.newWorkingMemory();
		ValidationErrors validationErrors = new ValidationErrors();
		workingMemory.setApplicationData(APPDATA_KEY_RESULT_ERRORS, validationErrors);
		workingMemory.assertObject(fact);
		workingMemory.fireAllRules();
		errors = validationErrors.getActionErrors();
	} catch (FactException e) {
		LOGGER.error("Error while firing the attachment validation rules", e);
		throw new ICFPAttachmentException(ICFPAttachmentException.ERRO_CODE_VALIDATION_RULE, "Error while firing the attachment validation rules", e);
	}
	return errors;
	}
}
