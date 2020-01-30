/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: RuleExecutor.java
 * Purpose: RuleExecutor executes configured rules.
 */
package com.ge.icfp.rules;

import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMessage;
import org.drools.FactException;
import org.drools.RuleBase;
import org.drools.WorkingMemory;
import org.drools.io.RuleBaseLoader;
import org.drools.io.RuleSetLoader;

import com.ge.icfp.action.ICFPException;
import com.ge.icfp.common.helper.ICFPLegHelper;
import com.ge.icfp.model.CPALegRequest;
import com.ge.icfp.model.CPASummary;
import com.ge.icfp.model.DealRequest;
import com.ge.icfp.model.LegSummary;
import com.ge.icfp.rules.util.LegCollectionRuleWrapper;
import com.ge.icfp.util.ProductType;
import com.ge.icfp.util.Utils;
import static com.ge.icfp.common.constants.ICFPConstants.*; 
/**
 * @author chaitanya
 *
 */
public class RuleExecutor {
	
	private static final String ERROR_WHILE_CREATING_RULE_BASE_WITH_THE_RULES = "Error while creating RuleBase with the rules ";
	private static final String NOT_FOUND_IN_THE_CLASSPATH = " not found in the classpath";
	private static final String RULE_CONFIGURATION_FILE = "Rule configuration file ";
	private static final String ERROR_WHILE_FIRING_THE_RULES_AGAINS_THE_FACTS = "Error while firing the rules agains the facts ";
	private static final String ERROR_WHILE_ASSERTING_THE_FACT = "Error while asserting the fact: ";
	private static final String RULE_CONFIG_LEG_COLLECTION_FILE = "/drools/icfp_leg_collection.java.drl";
	public static final String APP_DATA_ERRORS_ID = "ruleErrors";
	public static final String APP_DATA_HTTP_REQUEST_ID = "httpRequest";
	
	public static final RuleExecutor INSTANCE = new RuleExecutor();
	
	/**
	 * Static method to get singleton instance of this class.
	 * 
	 * @return
	 */
	public static RuleExecutor getInstance() {
		return INSTANCE;
	}
	
	/**
	 * 
	 * @param errors
	 * @return
	 */
	public static ActionErrors convertErrorsToActionErrors(RuleErrors errors) {
		ActionErrors actionErrors = new ActionErrors();
		if(errors != null && !errors.isEmpty()) {
			for(RuleError error : errors) {
				if(error.getLevel() == RuleErrorLevel.ERROR) {
					actionErrors.add(APP_DATA_ERRORS_ID, new ActionMessage(error.getCode(), error.getParameters()));
				}
			}
		}
		return actionErrors;
	}
	
	private RuleBase legCollectionRuleBase;

	/**
	 * Private constructor to implement singleton pattern
	 * 
	 * @throws ICFPException 
	 */
	private RuleExecutor() {
	}
	
	/**
	 * 
	 * @param facts
	 * @return
	 * @throws ICFPException 
	 */
	public RuleErrors executeLegCollectionRules(Map<String, Object> appData, Object... facts) throws ICFPException {
		RuleErrors errors = new RuleErrors();
		
		WorkingMemory workingMemory = getLegCollectionWorkingMemory();
		workingMemory.setApplicationData(APP_DATA_ERRORS_ID, errors);
		if(appData != null && !appData.isEmpty()) {
			for(Map.Entry<String, Object> entry : appData.entrySet()) {
				workingMemory.setApplicationData(entry.getKey(), entry.getValue());
			}
		}
		
		if(facts != null && facts.length > 0) {
			for(Object fact : facts) {
				try {
					workingMemory.assertObject(fact);
				} catch (FactException e) {
					StringBuilder errMsg = new StringBuilder();
					errMsg.append(RuleExecutor.ERROR_WHILE_ASSERTING_THE_FACT).append(fact);
					throw new ICFPException("", errMsg.toString(), e);
				}
			}
			try {
				workingMemory.fireAllRules();
			} catch (FactException e) {
				StringBuilder errMsg = new StringBuilder();
				errMsg.append(RuleExecutor.ERROR_WHILE_FIRING_THE_RULES_AGAINS_THE_FACTS).append(Arrays.asList(facts));
				throw new ICFPException("", errMsg.toString(), e);
			}
		}
		return errors;
	}
	
	/**
	 * 
	 * @param facts
	 * @return
	 * @throws ICFPException
	 */
	public RuleErrors executeLegCollectionRules(Object... facts) throws ICFPException {
		return executeLegCollectionRules((Map<String, Object>)null, facts);
	}
	
	/**
	 * 
	 * @param request
	 * @param facts
	 * @return
	 * @throws ICFPException
	 */
	public RuleErrors executeLegCollectionRules(HttpServletRequest request, Object... facts) throws ICFPException {
		Map<String, Object> appData = new HashMap<String, Object>();
		appData.put(APP_DATA_HTTP_REQUEST_ID, request);
		return executeLegCollectionRules(appData, facts);
	}
	
	/**
	 * This method performs the validations for add leg
	 * 
	 * @param deal
	 * @param productId
	 * @param eventId
	 * @return
	 * @throws ICFPException 
	 */
	public ActionErrors checkAddLeg(DealRequest deal, Integer productId, Integer eventId, HttpServletRequest request) throws ICFPException {
		ActionErrors actionErrors = null;
		
		// Validation not required for first leg
		if(deal.getLegs() != null && !deal.getLegs().getAllLegs().isEmpty() && eventId != null) {
			ProductType productType = ProductType.fromId(productId);
			Object newLeg = ICFPLegHelper.createLegObject(productType);
			Object legSummary = (productType == ProductType.CPA) ? new CPASummary() : new LegSummary();
			boolean isCPA = (newLeg instanceof CPALegRequest);
			String legSummaryProperty = (isCPA) ? CPASUMMARY_SMALL : LEGSUMMARY;
			Utils.setPropertyValue(legSummaryProperty, legSummary, newLeg);
			Utils.setPropertyValue(LEGTYPEID, productId, legSummary);
			Utils.setPropertyValue(TRANSACTIONEVENTTYPEID, eventId, legSummary);
			
			LegCollectionRuleWrapper legCollection = new LegCollectionRuleWrapper(deal.getLegs().getAllLegs());
			legCollection.addLeg(newLeg);
			RuleErrors errors = executeLegCollectionRules(legCollection);
			actionErrors = convertErrorsToActionErrors(errors);
		}
		return actionErrors;
	}
	
	/**
	 * 
	 * @return
	 * @throws ICFPException 
	 */
	private synchronized WorkingMemory getLegCollectionWorkingMemory() throws ICFPException {
		if(legCollectionRuleBase == null) {
			
			ClassLoader cl = Thread.currentThread().getContextClassLoader();
			if(cl == null) {
				cl = RuleExecutor.class.getClassLoader();
			}
			
			URL url = RuleExecutor.class.getResource(RULE_CONFIG_LEG_COLLECTION_FILE);
			if(url == null) {
				StringBuilder errMsg = new StringBuilder();
				errMsg.append(RuleExecutor.RULE_CONFIGURATION_FILE).append(RULE_CONFIG_LEG_COLLECTION_FILE).append(RuleExecutor.NOT_FOUND_IN_THE_CLASSPATH);
				throw new ICFPException("", errMsg.toString());
			}
			
			try {
				RuleSetLoader ruleSetLoader = new RuleSetLoader();
				ruleSetLoader.addFromUrl(url);
				
				RuleBaseLoader ruleBaseLoader = new RuleBaseLoader();
				ruleBaseLoader.addFromRuleSetLoader(ruleSetLoader);
				legCollectionRuleBase = ruleBaseLoader.buildRuleBase();
			} catch (Exception e) {
				StringBuilder errMsg = new StringBuilder();
				errMsg.append(RuleExecutor.ERROR_WHILE_CREATING_RULE_BASE_WITH_THE_RULES).append(RULE_CONFIG_LEG_COLLECTION_FILE);
				throw new ICFPException("", errMsg.toString(), e);
			}
		}
		return legCollectionRuleBase.newWorkingMemory();
	}
}
