/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: EntityHelper.java
 * Purpose: EntityHelper deals all the entities information
 */
package com.ge.icfp.common.helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import com.ge.icfp.action.ICFPException;
import com.ge.icfp.common.constants.ICFPConstants;
import com.ge.icfp.model.CPALegRequest;
import com.ge.icfp.model.CPASummary;
import com.ge.icfp.model.Entity;
import com.ge.icfp.util.EventType;
import com.ge.icfp.util.ProductType;
import com.ge.icfp.util.Utils;

import formdef.plugin.FormMapping;
import formdef.plugin.util.FormUtils;
import static com.ge.icfp.common.constants.ICFPConstants.*; 

/**
 * 
 * This class generates/populates back from form to model for Entities
 * 
 * @author cnarvaneni
 *
 */
public class EntityHelper {
	private static final String ENTITIES2 = "entities";
	private static final String ENTITY_SETUP_FLAG = "entitySetupFlag";
	private static Map<EntityHelper.EntityIdkey, Integer> ENTITY_ID_MAP = new ConcurrentHashMap<EntityHelper.EntityIdkey, Integer>();
	
	static {
		// Day1
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.RCA, null, EntityType.ORIGINAL_LENDER), 1);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.RCA, null, EntityType.ORIGINAL_BORROWER), 2);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.RCA, null, EntityType.GUARANTOR), 3);
		
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.TERM_LOAN, null, EntityType.ORIGINAL_LENDER), 1);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.TERM_LOAN, null, EntityType.ORIGINAL_BORROWER), 2);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.TERM_LOAN, null, EntityType.GUARANTOR), 3);
		
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.BOND, null, EntityType.ORIGINAL_LENDER), 14);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.BOND, null, EntityType.ORIGINAL_BORROWER), 15);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.BOND, null, EntityType.GUARANTOR), 3);
		
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.OTHER, null, EntityType.ORIGINAL_LENDER), 1);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.OTHER, null, EntityType.ORIGINAL_BORROWER), 2);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.OTHER, null, EntityType.GUARANTOR), 3);
		
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.EQUITY, null, EntityType.ORIGINAL_LENDER), 9);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.EQUITY, null, EntityType.ORIGINAL_BORROWER), 10);
		
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.CPA, null, EntityType.PARTICIPANT), 7);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.CPA, null, EntityType.POOL_LEADER), 8);
		
		// Day2 RCA
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.RCA, EventType.ASSIGNMENT, EntityType.ORIGINAL_LENDER), 1);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.RCA, EventType.ASSIGNMENT, EntityType.ORIGINAL_BORROWER), 2);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.RCA, EventType.ASSIGNMENT, EntityType.NEW_LENDER), 12);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.RCA, EventType.ASSIGNMENT, EntityType.NEW_BORROWER), 13);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.RCA, EventType.ASSIGNMENT, EntityType.PAYOR), 6);
		
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.RCA, EventType.AMENDMENT_AGREMENT_EXTENSION, EntityType.ORIGINAL_LENDER), 1);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.RCA, EventType.AMENDMENT_AGREMENT_EXTENSION, EntityType.ORIGINAL_BORROWER), 2);
		
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.RCA, EventType.AMENDMENT_FACILITY_INC_DEC, EntityType.ORIGINAL_LENDER), 1);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.RCA, EventType.AMENDMENT_FACILITY_INC_DEC, EntityType.ORIGINAL_BORROWER), 2);
		
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.RCA, EventType.GENERAL_AMENDMENT, EntityType.ORIGINAL_LENDER), 1);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.RCA, EventType.GENERAL_AMENDMENT, EntityType.ORIGINAL_BORROWER), 2);
		
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.RCA, EventType.EARYLY_TERMINATION, EntityType.ORIGINAL_LENDER), 1);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.RCA, EventType.EARYLY_TERMINATION, EntityType.ORIGINAL_BORROWER), 2);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.RCA, EventType.EARYLY_TERMINATION, EntityType.PAYOR), 6);
		
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.RCA, EventType.CORRECTION, EntityType.ORIGINAL_LENDER), 1);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.RCA, EventType.CORRECTION, EntityType.ORIGINAL_BORROWER), 2);
		
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.RCA, EventType.DEBT_EQUITY_OTHER, EntityType.ORIGINAL_LENDER), 1);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.RCA, EventType.DEBT_EQUITY_OTHER, EntityType.ORIGINAL_BORROWER), 2);
		
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.RCA, EventType.DRAWDOWN, EntityType.ORIGINAL_LENDER), 1);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.RCA, EventType.DRAWDOWN, EntityType.ORIGINAL_BORROWER), 2);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.RCA, EventType.DRAWDOWN, EntityType.PAYOR), 6);
		
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.RCA, EventType.PREPAYMENT, EntityType.ORIGINAL_LENDER), 1);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.RCA, EventType.PREPAYMENT, EntityType.ORIGINAL_BORROWER), 2);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.RCA, EventType.PREPAYMENT, EntityType.PAYOR), 6);
		
		// Day2 TL
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.TERM_LOAN, EventType.ASSIGNMENT, EntityType.ORIGINAL_LENDER), 1);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.TERM_LOAN, EventType.ASSIGNMENT, EntityType.ORIGINAL_BORROWER), 2);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.TERM_LOAN, EventType.ASSIGNMENT, EntityType.NEW_LENDER), 12);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.TERM_LOAN, EventType.ASSIGNMENT, EntityType.NEW_BORROWER), 13);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.TERM_LOAN, EventType.ASSIGNMENT, EntityType.PAYOR), 6);
		
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.TERM_LOAN, EventType.AMENDMENT_AGREMENT_EXTENSION, EntityType.ORIGINAL_LENDER), 1);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.TERM_LOAN, EventType.AMENDMENT_AGREMENT_EXTENSION, EntityType.ORIGINAL_BORROWER), 2);
		
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.TERM_LOAN, EventType.GENERAL_AMENDMENT, EntityType.ORIGINAL_LENDER), 1);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.TERM_LOAN, EventType.GENERAL_AMENDMENT, EntityType.ORIGINAL_BORROWER), 2);
		
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.TERM_LOAN, EventType.EARYLY_TERMINATION, EntityType.ORIGINAL_LENDER), 1);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.TERM_LOAN, EventType.EARYLY_TERMINATION, EntityType.ORIGINAL_BORROWER), 2);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.TERM_LOAN, EventType.EARYLY_TERMINATION, EntityType.PAYOR), 6);
		
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.TERM_LOAN, EventType.CORRECTION, EntityType.ORIGINAL_LENDER), 1);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.TERM_LOAN, EventType.CORRECTION, EntityType.ORIGINAL_BORROWER), 2);
		
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.TERM_LOAN, EventType.DEBT_EQUITY_OTHER, EntityType.ORIGINAL_LENDER), 1);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.TERM_LOAN, EventType.DEBT_EQUITY_OTHER, EntityType.ORIGINAL_BORROWER), 2);
		
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.TERM_LOAN, EventType.PREPAYMENT, EntityType.ORIGINAL_LENDER), 1);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.TERM_LOAN, EventType.PREPAYMENT, EntityType.ORIGINAL_BORROWER), 2);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.TERM_LOAN, EventType.PREPAYMENT, EntityType.PAYOR), 6);
		
		// Day2 Bond
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.BOND, EventType.ASSIGNMENT, EntityType.ORIGINAL_LENDER), 14);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.BOND, EventType.ASSIGNMENT, EntityType.ORIGINAL_BORROWER), 15);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.BOND, EventType.ASSIGNMENT, EntityType.NEW_LENDER), 16);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.BOND, EventType.ASSIGNMENT, EntityType.NEW_BORROWER), 17);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.BOND, EventType.ASSIGNMENT, EntityType.PAYOR), 6);
		
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.BOND, EventType.AMENDMENT_AGREMENT_EXTENSION, EntityType.ORIGINAL_LENDER), 14);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.BOND, EventType.AMENDMENT_AGREMENT_EXTENSION, EntityType.ORIGINAL_BORROWER), 15);
		
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.BOND, EventType.GENERAL_AMENDMENT, EntityType.ORIGINAL_LENDER), 14);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.BOND, EventType.GENERAL_AMENDMENT, EntityType.ORIGINAL_BORROWER), 15);
		
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.BOND, EventType.EARYLY_TERMINATION, EntityType.ORIGINAL_LENDER), 14);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.BOND, EventType.EARYLY_TERMINATION, EntityType.ORIGINAL_BORROWER), 15);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.BOND, EventType.EARYLY_TERMINATION, EntityType.PAYOR), 6);
		
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.BOND, EventType.CORRECTION, EntityType.ORIGINAL_LENDER), 14);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.BOND, EventType.CORRECTION, EntityType.ORIGINAL_BORROWER), 15);
		
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.BOND, EventType.DEBT_EQUITY_OTHER, EntityType.ORIGINAL_LENDER), 14);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.BOND, EventType.DEBT_EQUITY_OTHER, EntityType.ORIGINAL_BORROWER), 15);
		
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.BOND, EventType.PREPAYMENT, EntityType.ORIGINAL_LENDER), 14);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.BOND, EventType.PREPAYMENT, EntityType.ORIGINAL_BORROWER), 15);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.BOND, EventType.PREPAYMENT, EntityType.PAYOR), 6);
		
		// Day2 Others
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.OTHER, EventType.ASSIGNMENT, EntityType.ORIGINAL_LENDER), 1);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.OTHER, EventType.ASSIGNMENT, EntityType.ORIGINAL_BORROWER), 2);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.OTHER, EventType.ASSIGNMENT, EntityType.NEW_LENDER), 12);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.OTHER, EventType.ASSIGNMENT, EntityType.NEW_BORROWER), 13);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.OTHER, EventType.ASSIGNMENT, EntityType.PAYOR), 6);
		
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.OTHER, EventType.AMENDMENT_AGREMENT_EXTENSION, EntityType.ORIGINAL_LENDER), 1);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.OTHER, EventType.AMENDMENT_AGREMENT_EXTENSION, EntityType.ORIGINAL_BORROWER), 2);
		
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.OTHER, EventType.AMENDMENT_FACILITY_INC_DEC, EntityType.ORIGINAL_LENDER), 1);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.OTHER, EventType.AMENDMENT_FACILITY_INC_DEC, EntityType.ORIGINAL_BORROWER), 2);
		
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.OTHER, EventType.GENERAL_AMENDMENT, EntityType.ORIGINAL_LENDER), 1);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.OTHER, EventType.GENERAL_AMENDMENT, EntityType.ORIGINAL_BORROWER), 2);
		
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.OTHER, EventType.EARYLY_TERMINATION, EntityType.ORIGINAL_LENDER), 1);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.OTHER, EventType.EARYLY_TERMINATION, EntityType.ORIGINAL_BORROWER), 2);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.OTHER, EventType.EARYLY_TERMINATION, EntityType.PAYOR), 6);
		
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.OTHER, EventType.CORRECTION, EntityType.ORIGINAL_LENDER), 1);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.OTHER, EventType.CORRECTION, EntityType.ORIGINAL_BORROWER), 2);
		
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.OTHER, EventType.DEBT_EQUITY_OTHER, EntityType.ORIGINAL_LENDER), 1);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.OTHER, EventType.DEBT_EQUITY_OTHER, EntityType.ORIGINAL_BORROWER), 2);
		
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.OTHER, EventType.DRAWDOWN, EntityType.ORIGINAL_LENDER), 1);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.OTHER, EventType.DRAWDOWN, EntityType.ORIGINAL_BORROWER), 2);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.OTHER, EventType.DRAWDOWN, EntityType.PAYOR), 6);
		
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.OTHER, EventType.PREPAYMENT, EntityType.ORIGINAL_LENDER), 1);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.OTHER, EventType.PREPAYMENT, EntityType.ORIGINAL_BORROWER), 2);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.OTHER, EventType.PREPAYMENT, EntityType.PAYOR), 6);
		
		// Day2 Equity
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.EQUITY, EventType.DEBT_EQUITY_OTHER, EntityType.ORIGINAL_LENDER), 1);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.EQUITY, EventType.DEBT_EQUITY_OTHER, EntityType.ORIGINAL_BORROWER), 2);
		
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.EQUITY, EventType.DEVIDENTS, EntityType.ORIGINAL_LENDER), 1);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.EQUITY, EventType.DEVIDENTS, EntityType.ORIGINAL_BORROWER), 2);
		
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.EQUITY, EventType.CORRECTION, EntityType.ORIGINAL_LENDER), 1);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.EQUITY, EventType.CORRECTION, EntityType.ORIGINAL_BORROWER), 2);
		
		// Day2 CPA
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.CPA, EventType.CASHPOOL_TERMINATION, EntityType.PARTICIPANT), 7);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.CPA, EventType.CASHPOOL_TERMINATION, EntityType.POOL_LEADER), 8);
		
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.CPA, EventType.CASHPOOL_OTHER, EntityType.PARTICIPANT), 7);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.CPA, EventType.CASHPOOL_OTHER, EntityType.POOL_LEADER), 8);
		
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.CPA, EventType.CORRECTION, EntityType.PARTICIPANT), 7);
		ENTITY_ID_MAP.put(new EntityIdkey(ProductType.CPA, EventType.CORRECTION, EntityType.POOL_LEADER), 8);
	}
	
	/**
	 * Represents EntityType 
	 */
	public static enum EntityType {
		ORIGINAL_LENDER("lenderEntity", "lenderTCodeEntity"), 
		ORIGINAL_BORROWER("borrowerEntity", "borrowerTCodeEntity"), 
		NEW_LENDER("newLenderEntity", "newLenderTCodeEntity"), 
		NEW_BORROWER("newBorrowerEntity", "newBorrowerTCodeEntity"), 
		PAYOR("payorEntity", "payorTCodeEntity"), 
		PARTICIPANT("participantEntity", "participantTCodeEntities"), 
		POOL_LEADER("poolLeaderEntity", null),
		GUARANTOR("guarantorEntity", null);
		
		private String property;
		private String tcodeProperty;
		
		/**
		 * Creates the {@link EntityType}
		 * @param property
		 * @param tcodeProperty
		 */
		private EntityType(String property, String tcodeProperty) {
			this.property = property;
			this.tcodeProperty = tcodeProperty;
		}
		
		/**
		 * Returns the property of model.
		 * 
		 * @return
		 */
		public String getProperty() {
			return this.property;
		}
		
		/**
		 * Returns the tcodeProperty of form.
		 * 
		 * @return
		 */
		public String getTcodeProperty() {
			return this.tcodeProperty;
		}
	}
	
	/**
	 * This class represents as a key for Entity ID mapping
	 */
	private static class EntityIdkey {
		protected ProductType productType;
		protected EventType eventType;
		protected EntityType entityType;
		
		/**
		 * Creates the {@link EntityIdkey}
		 * 
		 * @param productType
		 * @param eventType
		 * @param entityType
		 */
		protected EntityIdkey(ProductType productType, EventType eventType, EntityType entityType) {
			this.productType = productType;
			this.eventType = eventType;
			this.entityType = entityType;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((entityType == null) ? 0 : entityType.hashCode());
			result = prime * result
					+ ((eventType == null) ? 0 : eventType.hashCode());
			result = prime * result
					+ ((productType == null) ? 0 : productType.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			EntityIdkey other = (EntityIdkey) obj;
			if (entityType != other.entityType)
				return false;
			if (eventType != other.eventType)
				return false;
			if (productType != other.productType)
				return false;
			return true;
		}
	}
	
	/**
	 * Returns LE_TYPE_ID based on specified {@link ProductType}, {@link EventType} and {@link EntityType}
	 * 
	 * @param productType
	 * @param eventType
	 * @return
	 */
	public static int getLETypeId(ProductType productType, EventType eventType, EntityType entityType) {
		EntityIdkey key = new EntityIdkey(productType, eventType, entityType);
		return ENTITY_ID_MAP.get(key);
	}
	
	/**
	 * Synchronizes form with entity objects
	 * 
	 * @param form
	 * @param leg
	 * @throws ICFPException 
	 */
	public static void syncFormWithEntities(DynaActionForm form, Object leg, HttpServletRequest request, ActionMapping mapping, Action action) throws ICFPException {
		boolean isCPA = (leg instanceof CPALegRequest);
		String legSummaryProperty = (isCPA) ? CPASUMMARY_SMALL : LEGSUMMARY;
		DynaActionForm summaryForm = (DynaActionForm) form.get(legSummaryProperty);
		ProductType productType = ICFPLegHelper.getProductType(leg);
		EventType eventType = ICFPDay2LegHelper.getEventType(leg);
		Map<EntityType, Integer> requiredEntityTypes = getEntityTypes(productType, eventType);
		Map<EntityType, Entity> typeToEntityMap = getTypeToEntityMap(leg, requiredEntityTypes);
		for(Entry<EntityType, Entity> entry : typeToEntityMap.entrySet()) {
			DynaActionForm entityForm = (DynaActionForm) FormUtils.setFormValues(ENTITYFORM, entry.getValue(), action, mapping, request);
			if(!isCPA && !entry.getValue().getTreasuryCodes().isEmpty()) {
				entityForm.set(TREASURYCODE, entry.getValue().getTreasuryCodes().get(0));
			}
			summaryForm.set(entry.getKey().getProperty(), entityForm);
			String tcodeProperty = entry.getKey().getTcodeProperty();
			if(isCPA && !entry.getValue().getTreasuryCodes().isEmpty() && entry.getValue().getLeTypeId()==8) {
				entityForm.set(TREASURYCODE, entry.getValue().getTreasuryCodes().get(0));
			}
			if(tcodeProperty != null) {
				List<String> tCodeList = entry.getValue().getTreasuryCodes();
				if(isCPA && !tCodeList.isEmpty()) {
					String[] tCodes = new String[tCodeList.size()];
					summaryForm.set(tcodeProperty, tCodeList.toArray(tCodes));
				} else if(!isCPA && !tCodeList.isEmpty()) {
					DynaActionForm tcodeForm = FormUtils.getInstance().createDynaActionForm(ENTITYFORM, mapping.getModuleConfig(), action);
					tcodeForm.set(TREASURYCODE, entry.getValue().getTreasuryCodes().get(0));
					summaryForm.set(tcodeProperty, tcodeForm);
				}
			}
		}
	}
	
	/**
	 * Synchronizes the Entity objects with form.
	 * 
	 * @param leg
	 * @param form
	 * @throws ICFPException 
	 */
	public static void syncEntitiesWithForm(Object leg, DynaActionForm form, HttpServletRequest request,
			ServletContext context, ActionMapping mapping, Action action) throws ICFPException {
		boolean isCPA = leg instanceof CPALegRequest;
		String legSummaryProperty = (isCPA) ? CPASUMMARY_SMALL : LEGSUMMARY;
		Integer leTypeId = null;
		Integer legalEntitySeqId = null;
		DynaActionForm summaryForm = (DynaActionForm) form.get(legSummaryProperty);
		ProductType productType = ICFPLegHelper.getProductType(leg);
		EventType eventType = ICFPDay2LegHelper.getEventType(leg);
		Map<EntityType, Integer> requiredEntityTypes = getEntityTypes(productType, eventType);
		Map<EntityType, Entity> typeToEntityMap = getTypeToEntityMap(leg, requiredEntityTypes);
		for(Entry<EntityType, Entity> entry : typeToEntityMap.entrySet()) {
			Entity entity = entry.getValue();
			if(entity.getLeTypeId()!=null && entity.getLeTypeId()== 7) {
				leTypeId =entity.getLeTypeId();
			}
			if(isCPA && entity.getLegalEntitySeqId()!=null){
				legalEntitySeqId=entity.getLegalEntitySeqId();
				
			}
			DynaActionForm entityForm = (DynaActionForm) summaryForm.get(entry.getKey().getProperty());
			FormMapping formMapping = FormUtils.getInstance().findFormDefinition(ENTITYFORM, context, mapping.getModuleConfig());
			FormUtils.getInstance().populateBeanFromForm(formMapping, entry.getValue(), entityForm, action, mapping, request);
			if(!isCPA || (isCPA && entity.getLeTypeId()!=null && entity.getLeTypeId()==8)) {
				entity.getTreasuryCodes().clear();
				String tCode = entityForm.getString(TREASURYCODE);
				if(StringUtils.isNotBlank(tCode)) {
					entity.getTreasuryCodes().add(tCode);
				}
			}
			
			String tcodeProperty = entry.getKey().getTcodeProperty();
			if(tcodeProperty != null) {
				setTreasuryCodes(entity, summaryForm, tcodeProperty, isCPA);
			}
			setLeCategoryId(entity);
			// Fix for the entity setup flag null or blank
			setEntitySetupFlag(entity, entityForm.getString(EntityHelper.ENTITY_SETUP_FLAG),entityForm.getString(LEGOLDID));
			if(entity.getLeTypeId()==null && leTypeId!=null) {
				entity.setLeTypeId(leTypeId);
			}
			if(isCPA && entity.getLegalEntitySeqId()==null && legalEntitySeqId != null){
				entity.setLegalEntitySeqId(legalEntitySeqId);
				
			}
			
			
			
		}
		removeEmptyEntities(leg);
	}
	
	/**
	 * Returns the {@link EntityType} to {@link Entity} map of the leg
	 * 
	 * @param productType
	 * @param eventType
	 * @param entityType
	 * @return
	 * @throws ICFPException 
	 */
	public static Map<EntityType, Entity> getTypeToEntityMap(Object leg, Map<EntityType, Integer> entityTypes) throws ICFPException {
		Map<EntityType, Entity> typeToEntityMap = new HashMap<EntityHelper.EntityType, Entity>();
		if(entityTypes.isEmpty()) {
			return typeToEntityMap;
		}
		Object legSummary = ICFPLegHelper.getLegSummary(leg);
		@SuppressWarnings("unchecked")
		List<Entity> entities = Utils.fetchPropertyValue(EntityHelper.ENTITIES2, legSummary, List.class);
		
		for(Entry<EntityType, Integer> entry: entityTypes.entrySet()) {
			Entity entity = fetchEntityFromList(entry.getValue(), entities);
			if(entity == null) {
				entity = new Entity();
				entity.setLeTypeId(entry.getValue());
				entities.add(entity);
			}
			typeToEntityMap.put(entry.getKey(), entity);
		}
		return typeToEntityMap;
	}
	
	/**
	 * Fetches requested type entity from the list
	 * 
	 * @param type
	 * @param entities
	 * @return
	 */
	public static Entity fetchEntityFromList(Integer id, List<Entity> entities) {
		Entity entity = null;
		for(Entity eachEntity : entities) {
			if(eachEntity.getLeTypeId().equals(id)) {
				entity = eachEntity;
				break;
			}
		}
		return entity;
	}
	
	/**
	 * Returns Entity Types with Ids for the specified {@link ProductType} and {@link EventType}
	 * @param productType
	 * @param eventType
	 * @return
	 */
	public static Map<EntityType, Integer> getEntityTypes(ProductType productType, EventType eventType) {
		Map<EntityType, Integer> entityTypesMap = new HashMap<EntityHelper.EntityType, Integer>();
		for(Entry<EntityHelper.EntityIdkey, Integer> entry : ENTITY_ID_MAP.entrySet()) {
			EntityIdkey entityIdKey = entry.getKey();
			if(entityIdKey.productType == productType && entityIdKey.eventType == eventType)  {
				entityTypesMap.put(entityIdKey.entityType, entry.getValue());
			}
		}
		return entityTypesMap;
	}
	
	/**
	 * Fetches the specified type entity from legSummary object.
	 * 
	 * @param entities
	 * @param type
	 * @param productType
	 * @param eventType
	 * @return
	 * @throws ICFPException 
	 */
	public static Entity searchEntity(Object legSummary, EntityType type) throws ICFPException {
		@SuppressWarnings("unchecked")
		List<Entity> entities = Utils.fetchPropertyValue(EntityHelper.ENTITIES2, legSummary, List.class);
		ProductType productType = null;
		EventType eventType = null;
		//To be removed once legTypeId mapped through service
		if(legSummary instanceof CPASummary){
			if(CPA.equals(((CPASummary) legSummary).getProductType())){
				((CPASummary) legSummary).setLegTypeId(3);
			}
			
		}
		Integer productTypeId = Utils.fetchPropertyValue(LEGTYPEID, legSummary, Integer.class);
		Integer eventTypeId = Utils.fetchPropertyValue(TRANSACTIONEVENTTYPEID, legSummary, Integer.class);
		if(productTypeId != null) {
			productType = ProductType.fromId(productTypeId);
		}
		if(eventTypeId != null) {
			eventType = EventType.fromId(eventTypeId);
		}
		Entity entity = null;
		Integer leTypeId = ENTITY_ID_MAP.get(new EntityIdkey(productType, eventType, type));
		if(leTypeId != null) {
			for(Entity eachEntity : entities) {
				if(eachEntity.getLeTypeId().equals(leTypeId)) {
					entity = eachEntity;
					break;
				}
			}	
		}
		return entity;
	}
	
	/**
	 * Fetches the entities of a leg
	 * @param leg
	 * @return
	 * @throws ICFPException 
	 */
	public static List<Entity> fetchEntites(Object leg) throws ICFPException {
		String legSummaryProperty = (leg instanceof CPALegRequest) ? CPASUMMARY : LEGSUMMARY;
		Object summary = Utils.fetchPropertyValue(legSummaryProperty, leg, Object.class);
		@SuppressWarnings("unchecked")
		List<Entity> entities = Utils.fetchPropertyValue(EntityHelper.ENTITIES2, summary, List.class);
		return entities;
	}
	
	/**
	 * Fetches the specified entity 
	 * @param leg
	 * @param entityType
	 * @return
	 * @throws ICFPException 
	 */
	public static Entity searchEntityInLeg(Object leg, EntityType entityType) throws ICFPException {
		String legSummaryProperty = (leg instanceof CPALegRequest) ? CPASUMMARY : LEGSUMMARY;
		Object summary = Utils.fetchPropertyValue(legSummaryProperty, leg, Object.class);
		return searchEntity(summary, entityType);
		
	}
	
	/**
	 * Removes Empty entities
	 * @param entities
	 * @throws ICFPException 
	 */
	private static void removeEmptyEntities(Object leg) throws ICFPException {
		for(Iterator<Entity> entities = fetchEntites(leg).listIterator(); entities.hasNext(); ) {
			Entity entity = entities.next();
			Integer id = entity.getLeTypeId();
			String entitySetupFlag = entity.getEntitySetupFlag();
			// Do not remove entity if flag is true
			if(StringUtils.isNotBlank(entitySetupFlag) 
					&& ICFPConstants.Y_CAP.equals(entitySetupFlag.toUpperCase())) {
				continue;
			}
			Integer categoryId = entity.getLeCategoryId();
			entity.setLeTypeId(null);
			entity.setEntitySetupFlag(null);
			entity.setLeCategoryId(null);
			if(Utils.isAllPropertiesBlank(entity)) {
				entities.remove();
				continue;
			}
			entity.setLeTypeId(id);
			entity.setEntitySetupFlag(entitySetupFlag);
			entity.setLeCategoryId(categoryId);
		}
	}
	
	/**
	 * Sets LeCategoryId based on captialOrIndustrialFlag.
	 * 
	 * @param entity
	 */
	private static void setLeCategoryId(Entity entity) {
		String capitalIndusrialFlag = entity.getCapitalIndustrial();
		if(CAPITAL.equals(capitalIndusrialFlag)) {
			entity.setLeCategoryId(1);
		}
		else if(INDUSTRIAL.equals(capitalIndusrialFlag)) {
			entity.setLeCategoryId(2);
		}else if(BOTH.equals(capitalIndusrialFlag)) {
			entity.setLeCategoryId(3);
		} else {
			entity.setLeCategoryId(null);
		}
	}
	
	/**
	 * Sets Entity SetupFlag.
	 * 
	 * @param entity
	 * @param entitySetupFlag
	 */
	private static void setEntitySetupFlag(Entity entity, String entitySetupFlag,String leGoldId) {
		if(StringUtils.isNotBlank(leGoldId)){
			entity.setEntitySetupFlag(ICFPConstants.N_CAP);
			entitySetupFlag = ICFPConstants.N_CAP;
		}
		if(entitySetupFlag!=null && entitySetupFlag.equals(ICFPConstants.N_CAP) ){
			return;
		}
		if(entitySetupFlag==null || (StringUtils.isBlank(entitySetupFlag)
				|| entitySetupFlag.equals(ICFPConstants.N_CAP) || ICFPConstants.ZERO.equals(entitySetupFlag))
				&& (StringUtils.isNotBlank(entity.getLEGoldId()))){
			entity.setEntitySetupFlag(ICFPConstants.N_CAP);
		}else{
			entity.setLEGoldId(null);
			entity.setCountry(null);
			entity.setCDRCd(null);
			entity.setLEName(null);
			entity.setEntitySetupFlag(ICFPConstants.Y_CAP);
			entity.setLeCategoryId(1);
		}
	}
	
	/**
	 * 
	 * @param entity
	 * @param summaryForm
	 */
	private static void setTreasuryCodes(Entity entity, DynaActionForm summaryForm, String tcodeProperty, boolean isCPA) {
		String[] tCodes = null;
			if(isCPA) {
				tCodes = summaryForm.getStrings(tcodeProperty);
			} else {
				DynaActionForm tcodeForm = (DynaActionForm) summaryForm.get(tcodeProperty);
				String treasuryCode = tcodeForm.getString(TREASURYCODE);
				tCodes = new String[] {treasuryCode};
			}
			// Setting Treasury Codes to Entity
			if(tCodes != null && tCodes.length > 0) {
				ArrayList<String> newList = new ArrayList<String>();
				newList.addAll( Arrays.asList(tCodes) );
				// Remove empty treasury codes
				for(ListIterator<String> tCodeItr = newList.listIterator(); tCodeItr.hasNext(); ) {
					if(StringUtils.isBlank(tCodeItr.next())) {
						tCodeItr.remove();
					}
				}
				entity.setTreasuryCodes( newList );
			}else{
				entity.setTreasuryCodes( null );
				if(isCPA){
					entity.setBankTreasuryCd( "" );
				}
			}
	}
}
