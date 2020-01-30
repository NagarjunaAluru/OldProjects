/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: AttachmentUtils.java
 * Purpose: Provides utility methods for the attachments functionality  
 */
package com.ge.icfp.common.attachments;

import static com.ge.icfp.common.attachments.IAttachmentConstants.PROP_GELIBMATTR_BORROWER_BUSEG;
import static com.ge.icfp.common.attachments.IAttachmentConstants.PROP_GELIBMATTR_BORROWER_CDR;
import static com.ge.icfp.common.attachments.IAttachmentConstants.PROP_GELIBMATTR_BORROWER_COUNTRY;
import static com.ge.icfp.common.attachments.IAttachmentConstants.PROP_GELIBMATTR_BORROWER_ENTITYNAME;
import static com.ge.icfp.common.attachments.IAttachmentConstants.PROP_GELIBMATTR_BORROWER_GOLDID;
import static com.ge.icfp.common.attachments.IAttachmentConstants.PROP_GELIBMATTR_BORROWER_MEGOLDID;
import static com.ge.icfp.common.attachments.IAttachmentConstants.PROP_GELIBMATTR_BUSINESSREGION;
import static com.ge.icfp.common.attachments.IAttachmentConstants.PROP_GELIBMATTR_CURRENCY;
import static com.ge.icfp.common.attachments.IAttachmentConstants.PROP_GELIBMATTR_DEALCATEGORY;
import static com.ge.icfp.common.attachments.IAttachmentConstants.PROP_GELIBMATTR_DEALNAME;
import static com.ge.icfp.common.attachments.IAttachmentConstants.PROP_GELIBMATTR_DOCTYPE;
import static com.ge.icfp.common.attachments.IAttachmentConstants.PROP_GELIBMATTR_EFFECTIVEDATE;
import static com.ge.icfp.common.attachments.IAttachmentConstants.PROP_GELIBMATTR_INSTRUMENTID;
import static com.ge.icfp.common.attachments.IAttachmentConstants.PROP_GELIBMATTR_LENDER_BUSEG;
import static com.ge.icfp.common.attachments.IAttachmentConstants.PROP_GELIBMATTR_LENDER_CDR;
import static com.ge.icfp.common.attachments.IAttachmentConstants.PROP_GELIBMATTR_LENDER_COUNTRY;
import static com.ge.icfp.common.attachments.IAttachmentConstants.PROP_GELIBMATTR_LENDER_ENTITYNAME;
import static com.ge.icfp.common.attachments.IAttachmentConstants.PROP_GELIBMATTR_LENDER_GOLDID;
import static com.ge.icfp.common.attachments.IAttachmentConstants.PROP_GELIBMATTR_LENDER_MEGOLDID;
import static com.ge.icfp.common.attachments.IAttachmentConstants.PROP_GELIBMATTR_METURITYDATE;
import static com.ge.icfp.common.attachments.IAttachmentConstants.PROP_GELIBMATTR_PARTICIPANT_CDR;
import static com.ge.icfp.common.attachments.IAttachmentConstants.PROP_GELIBMATTR_PARTICIPANT_ENTITYNAME;
import static com.ge.icfp.common.attachments.IAttachmentConstants.PROP_GELIBMATTR_PARTICIPANT_GOLDID;
import static com.ge.icfp.common.attachments.IAttachmentConstants.PROP_GELIBMATTR_PARTICIPANT_MENAME;
import static com.ge.icfp.common.attachments.IAttachmentConstants.PROP_GELIBMATTR_POOLLEADER_CURRENCY;
import static com.ge.icfp.common.attachments.IAttachmentConstants.PROP_GELIBMATTR_POOLLEADER_ENTITYNAME;
import static com.ge.icfp.common.attachments.IAttachmentConstants.PROP_GELIBMATTR_POOLLEADER_GOLDID;
import static com.ge.icfp.common.attachments.IAttachmentConstants.PROP_GELIBMATTR_POOLLEADER_LENAME;
import static com.ge.icfp.common.attachments.IAttachmentConstants.PROP_GELIBMATTR_PRODUCTTYPE;
import static com.ge.icfp.common.attachments.IAttachmentConstants.PROP_GELIBMATTR_TRANSCAPTURESYSTEM;
import static com.ge.icfp.common.attachments.IAttachmentConstants.PROP_GELIBMATTR_TRANSNUMBER;
import static com.ge.icfp.common.attachments.IAttachmentConstants.PROP_GELIBMATTR_WORKFLOWREQID;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.ge.icfp.action.ICFPException;
import com.ge.icfp.common.helper.CurrentDealManager;
import com.ge.icfp.common.helper.EntityHelper;
import com.ge.icfp.common.helper.EntityHelper.EntityType;
import com.ge.icfp.common.helper.ICFPCommonHelper;
import com.ge.icfp.common.helper.ICFPDay2LegHelper;
import com.ge.icfp.common.helper.ICFPLegHelper;
import com.ge.icfp.model.Amendment;
import com.ge.icfp.model.Attachment;
import com.ge.icfp.model.CPALegRequest;
import com.ge.icfp.model.CPASummary;
import com.ge.icfp.model.DealRequest;
import com.ge.icfp.model.DerivativesRequest;
import com.ge.icfp.model.Entity;
import com.ge.icfp.model.ExceptionRequestForm;
import com.ge.icfp.model.LegSummary;
import com.ge.icfp.model.NameValue;
import com.ge.icfp.model.RCALegRequest;
import com.ge.icfp.util.BusinessRegion;
import com.ge.icfp.util.DateUtil;
import com.ge.icfp.util.ProductType;
import com.ge.icfp.util.StaticDataFactory;
import com.hydus.wff.core.context.UserContext;

/**
 * This class used to perform the utilities for attachments and comments
 * @author chaitanya.n
 *
 */
public class AttachmentUtils {
	
	private static final Logger LOGGER = Logger.getLogger(AttachmentUtils.class);
	
	/**
	 * This method used to generate file name i.e usersso-ddhhmmss-randomnumber-filename format
	 * 
	 * 
	 * @param file
	 * @param type
	 * @param deal
	 */
	static String generateFileName(String fileName, AttachmentType type, DealRequest deal, Object leg) {
		StringBuilder newFileName = new StringBuilder().append(deal.getDealSeqId()).append("-")
				.append(UserContext.getCurrentUserContext().getId()).append("-")
				.append(new SimpleDateFormat("ddhhmmss").format(new Date())).append("-")
				.append(( int ) ( Math.random() * 100 ))
				.append("-").append(fileName);
		return newFileName.toString();
	}
	
	/**
	 * This method is the Main method for deal and leg update metadata information in GELIB.
	 * 
	 * Based on the properties read from the configuration file and set the values using request object
	 * 	  
	 * @param repositoryAttachment
	 * @param attachment
	 * @param leg
	 * @param deal
	 * @throws ICFPException 
	 */
	static void addMetadata(com.hydus.wff.ge.attachments.Attachment repositoryAttachment, Attachment attachment, Object leg, DealRequest deal, Properties configuration, StaticDataFactory staticDataFactory) throws ICFPException {
		if(LOGGER.isInfoEnabled()) {
			StringBuilder msg = new StringBuilder().append("Populating metadata for the attachment ").append(attachment.getOrigAttachmentName())
					.append(" of type ").append(AttachmentType.fromId(attachment.getAttachmentTypeId()).getName()).append(" for the deal ").append(deal.getDealSeqId());
			LOGGER.info(msg.toString());
		}
		addDealMetadata(repositoryAttachment, attachment, deal, configuration, staticDataFactory);
		
		if(leg != null) {
			if(ICFPLegHelper.getProductType(leg) == ProductType.CPA) {
				addCPALegMetadata(repositoryAttachment, attachment, (CPALegRequest)leg, deal, configuration);
			} else {
				addDebtEquityLegMetadata(repositoryAttachment, attachment, leg, deal, configuration);
			}
		}
		
		if(LOGGER.isInfoEnabled()) {
			StringBuilder msg = new StringBuilder().append("Successfully populated metadata for the attachment ").append(attachment.getOrigAttachmentName())
					.append(" of type ").append(AttachmentType.fromId(attachment.getAttachmentTypeId()).getName()).append(" for the deal ").append(deal.getDealSeqId());
			LOGGER.info(msg.toString());
		}
	}
	
	/**
	 * This method add deal level metadata information in GELIB for perticular attachemnt object by providing configuration file
	 * @param repositoryAttachment
	 * @param attachment
	 * @param deal
	 */
	private static void addDealMetadata(com.hydus.wff.ge.attachments.Attachment repositoryAttachment, Attachment attachment, DealRequest deal, Properties configuration, StaticDataFactory staticDataFactory) {
		Map<String, Object> properties = repositoryAttachment.metadata();
		
		if(deal.getBusinessRequestId() != null) {
			properties.put(configuration.getProperty(PROP_GELIBMATTR_WORKFLOWREQID), deal.getBusinessRequestId());
		}
		
		if(StringUtils.isNotBlank(deal.getDealName())) {
			properties.put(configuration.getProperty(PROP_GELIBMATTR_DEALNAME), deal.getDealName());
		}
		
		if(deal.getDealCategoryId() != null) {
			Iterator<NameValue> dealCategoriesItr = staticDataFactory.getDealCategories().iterator();
			while(dealCategoriesItr.hasNext()) {
				NameValue category = dealCategoriesItr.next();
				if(category.getID().equals(deal.getDealCategoryId())) {
					properties.put(configuration.getProperty(PROP_GELIBMATTR_DEALCATEGORY), category.getName());
					break;
				}
			}
		}
		
		if(deal.getResponsibleRegionId() != null) {
			BusinessRegion buRegion = BusinessRegion.fromId(deal.getResponsibleRegionId());
			properties.put(configuration.getProperty(PROP_GELIBMATTR_BUSINESSREGION), buRegion.getName());
		}
		
		properties.put(configuration.getProperty(PROP_GELIBMATTR_DOCTYPE), AttachmentType.fromId(attachment.getAttachmentTypeId()).getName());
	}
	
	/**
	 * This method add leg level metadata information for CPA deal in GELIB.
	 * 
	 * @param repositoryAttachment
	 * @param attachment
	 * @param leg
	 * @param deal
	 * @throws ICFPException 
	 */
	private static void addCPALegMetadata(com.hydus.wff.ge.attachments.Attachment repositoryAttachment, Attachment attachment, CPALegRequest leg, DealRequest deal, Properties configuration) throws ICFPException {
		Map<String, Object> properties = repositoryAttachment.metadata();
		CPASummary cpaSummary = leg.getCPASummary();
		
		if(StringUtils.isNotBlank(leg.getTransactionCapturedInId())) {
			properties.put(configuration.getProperty(PROP_GELIBMATTR_TRANSCAPTURESYSTEM), leg.getTransactionCapturedInId());
		}
		
		if(cpaSummary.getEffectiveDt() != null) {
			properties.put(configuration.getProperty(PROP_GELIBMATTR_EFFECTIVEDATE), DateUtil.getValueDate(cpaSummary.getEffectiveDt(),"MM/dd/yyyy"));
		}
		
		if(cpaSummary.getMaturityDt() != null) {
			properties.put(configuration.getProperty(PROP_GELIBMATTR_METURITYDATE),DateUtil.getValueDate(cpaSummary.getMaturityDt(),"MM/dd/yyyy"));
		}
		
		if(StringUtils.isNotBlank(cpaSummary.getCurrencyCd())) {
			properties.put(configuration.getProperty(PROP_GELIBMATTR_CURRENCY), cpaSummary.getCurrencyCd());
		}
		
		properties.put(configuration.getProperty(PROP_GELIBMATTR_PRODUCTTYPE), ProductType.CPA.name());
		
		Entity participant = EntityHelper.searchEntity(cpaSummary, EntityType.PARTICIPANT);
		if(participant != null) {
			if(StringUtils.isNotBlank(participant.getLEGoldId())) {
				properties.put(configuration.getProperty(PROP_GELIBMATTR_PARTICIPANT_GOLDID), participant.getLEGoldId());
			}
			
			if(StringUtils.isNotBlank(participant.getCDRCd())) {
				properties.put(configuration.getProperty(PROP_GELIBMATTR_PARTICIPANT_CDR), participant.getCDRCd());
			}
			
			if(StringUtils.isNotBlank(participant.getMEName())) {
				properties.put(configuration.getProperty(PROP_GELIBMATTR_PARTICIPANT_MENAME), participant.getMEName());
			}
			
			if(StringUtils.isNotBlank(participant.getLEName())) {
				StringBuilder entityName = new StringBuilder();
				entityName.append(participant.getLEName());
				if(StringUtils.isNotBlank(participant.getCountry())) {
					entityName.append("-").append(participant.getCountry());
				}
				if(StringUtils.isNotBlank(cpaSummary.getCurrencyCd())) {
					entityName.append("-").append(cpaSummary.getCurrencyCd());
				}
				if(!participant.getTreasuryCodes().isEmpty()) {
					entityName.append("-").append(participant.getTreasuryCodes().get(0));
				}
				properties.put(configuration.getProperty(PROP_GELIBMATTR_PARTICIPANT_ENTITYNAME), entityName.toString());
			}
		}
		
		Entity poolleader = EntityHelper.searchEntity(cpaSummary, EntityType.PARTICIPANT);
		if(poolleader != null) {
			if(StringUtils.isNotBlank(poolleader.getLEGoldId())) {
				properties.put(configuration.getProperty(PROP_GELIBMATTR_POOLLEADER_GOLDID), poolleader.getLEGoldId());
			}
			
			// TODO Need clarification whether need to update to GELIB or not
			/*if(StringUtils.isNotBlank(poolleader.getCDRCd())) {
				properties.put(configuration.getProperty(PROP_GELIBMATTR_POOLLEADER_CDR), poolleader.getCDRCd());
			}*/
			
			/*if(StringUtils.isNotBlank(poolleader.getMEName())) {
				properties.put(configuration.getProperty(PROP_GELIBMATTR_POOLLEADER_MENAME), poolleader.getMEName());
			}*/
			
			if(StringUtils.isNotBlank(poolleader.getLEName())) {
				properties.put(configuration.getProperty(PROP_GELIBMATTR_POOLLEADER_LENAME), poolleader.getLEName());
			}
			
			if(StringUtils.isNotBlank(poolleader.getLEName())) {
				StringBuilder entityName = new StringBuilder();
				entityName.append(poolleader.getLEName());
				if(StringUtils.isNotBlank(poolleader.getCountry())) {
					entityName.append("-").append(poolleader.getCountry());
				}
				if(StringUtils.isNotBlank(cpaSummary.getCurrencyCd())) {
					entityName.append("-").append(cpaSummary.getCurrencyCd());
				}
				if(!poolleader.getTreasuryCodes().isEmpty()) {
					entityName.append("-").append(poolleader.getTreasuryCodes().get(0));
				}
				properties.put(configuration.getProperty(PROP_GELIBMATTR_POOLLEADER_ENTITYNAME), entityName.toString());
			}
			if(StringUtils.isNotBlank(cpaSummary.getCurrencyCd())) {
				properties.put(configuration.getProperty(PROP_GELIBMATTR_POOLLEADER_CURRENCY), cpaSummary.getCurrencyCd());
			}
		}
	}
	
	/**
	 * This method add leg level metadata information for DEBT/Equity deals in GELIB.
	 * @param repositoryAttachment
	 * @param attachment
	 * @param leg
	 * @param deal
	 * @throws ICFPException 
	 */
	private static void addDebtEquityLegMetadata(com.hydus.wff.ge.attachments.Attachment repositoryAttachment, Attachment attachment, Object leg, DealRequest deal, Properties configuration) throws ICFPException {
		Map<String, Object> properties = repositoryAttachment.metadata();
		
		LegSummary legSummary = (LegSummary) ICFPLegHelper.getLegSummary(leg);
		
		if(StringUtils.isNotBlank(legSummary.getTransactionCaptureIn())) {
			properties.put(configuration.getProperty(PROP_GELIBMATTR_TRANSCAPTURESYSTEM), legSummary.getTransactionCaptureIn());
		}
		
		if(StringUtils.isNotBlank(legSummary.getTransactionId())) {
			properties.put(configuration.getProperty(PROP_GELIBMATTR_TRANSNUMBER), legSummary.getTransactionId());
		}
		
		if(StringUtils.isNotBlank(legSummary.getInstrumentId())) {
			properties.put(configuration.getProperty(PROP_GELIBMATTR_INSTRUMENTID), legSummary.getInstrumentId());
		}
		
		if(legSummary.getEffectiveDt() != null) {
			properties.put(configuration.getProperty(PROP_GELIBMATTR_EFFECTIVEDATE), DateUtil.getValueDate(legSummary.getEffectiveDt(),"MM/dd/yyyy"));
		}
		
		// TODO Need to set closed date
		
		if(legSummary.getMaturityDt() != null) {
			properties.put(configuration.getProperty(PROP_GELIBMATTR_METURITYDATE),DateUtil.getValueDate(legSummary.getMaturityDt(),"MM/dd/yyyy"));
		}
		
		properties.put(configuration.getProperty(PROP_GELIBMATTR_PRODUCTTYPE), legSummary.getProductType());
		
		Entity lender = EntityHelper.searchEntity(legSummary, EntityType.ORIGINAL_LENDER);
		if(lender != null) {
			if(StringUtils.isNotBlank(lender.getLEGoldId())) {
				properties.put(configuration.getProperty(PROP_GELIBMATTR_LENDER_GOLDID), lender.getLEGoldId());
			}
			
			if(StringUtils.isNotBlank(lender.getCDRCd())) {
				properties.put(configuration.getProperty(PROP_GELIBMATTR_LENDER_CDR), lender.getCDRCd());
			}
			
			if(StringUtils.isNotBlank(lender.getBusinessSegment())) {
				properties.put(configuration.getProperty(PROP_GELIBMATTR_LENDER_BUSEG), lender.getBusinessSegment());
			}
			
			if(StringUtils.isNotBlank(lender.getCountry())) {
				properties.put(configuration.getProperty(PROP_GELIBMATTR_LENDER_COUNTRY), lender.getCountry());
			}
			
			
			if(StringUtils.isNotBlank(lender.getMeGoldId())) {
				properties.put(configuration.getProperty(PROP_GELIBMATTR_LENDER_MEGOLDID), lender.getMeGoldId());
			}
			
			if(StringUtils.isNotBlank(lender.getLEName())) {
				StringBuilder entityName = new StringBuilder();
				entityName.append(lender.getLEName());
				if(StringUtils.isNotBlank(lender.getCountry())) {
					entityName.append("-").append(lender.getCountry());
				}
				if(StringUtils.isNotBlank(legSummary.getCurrencyName())) {
					entityName.append("-").append(legSummary);
				}
				if(!lender.getTreasuryCodes().isEmpty()) {
					entityName.append("-").append(lender.getTreasuryCodes().get(0));
				}
				properties.put(configuration.getProperty(PROP_GELIBMATTR_LENDER_ENTITYNAME), entityName.toString());
			}
		}
		
		Entity borrower = EntityHelper.searchEntity(legSummary, EntityType.ORIGINAL_BORROWER);
		if(borrower != null) {
			if(StringUtils.isNotBlank(borrower.getLEGoldId())) {
				properties.put(configuration.getProperty(PROP_GELIBMATTR_BORROWER_GOLDID), borrower.getLEGoldId());
			}
			
			if(StringUtils.isNotBlank(borrower.getCDRCd())) {
				properties.put(configuration.getProperty(PROP_GELIBMATTR_BORROWER_CDR), borrower.getCDRCd());
			}
			
			if(StringUtils.isNotBlank(borrower.getBusinessSegment())) {
				properties.put(configuration.getProperty(PROP_GELIBMATTR_BORROWER_BUSEG), borrower.getBusinessSegment());
			}
			
			if(StringUtils.isNotBlank(borrower.getCountry())) {
				properties.put(configuration.getProperty(PROP_GELIBMATTR_BORROWER_COUNTRY), borrower.getCountry());
			}
			
			
			if(StringUtils.isNotBlank(borrower.getMeGoldId())) {
				properties.put(configuration.getProperty(PROP_GELIBMATTR_BORROWER_MEGOLDID), borrower.getMeGoldId());
			}
			
			if(StringUtils.isNotBlank(borrower.getLEName())) {
				StringBuilder entityName = new StringBuilder();
				entityName.append(borrower.getLEName());
				if(StringUtils.isNotBlank(borrower.getCountry())) {
					entityName.append("-").append(borrower.getCountry());
				}
				if(StringUtils.isNotBlank(legSummary.getCurrencyName())) {
					entityName.append("-").append(legSummary);
				}
				if(!borrower.getTreasuryCodes().isEmpty()) {
					entityName.append("-").append(borrower.getTreasuryCodes().get(0));
				}
				properties.put(configuration.getProperty(PROP_GELIBMATTR_BORROWER_ENTITYNAME), entityName.toString());
			}
		}
	}
	
	/**
	 * This method to get the leg object of current leg index
	 * @param index
	 * @param deal
	 * @return
	 * @throws ICFPAttachmentException 
	 */
	public static Object getLeg(int index, DealRequest deal) throws ICFPAttachmentException {
		Object leg = ICFPCommonHelper.getLegByNumber(index, deal);
		if(leg == null) {
			throw new ICFPAttachmentException(ICFPAttachmentException.ERROR_CODE_INVALID_INPUT_PARAMS, "Invalid Leg Index " + index);
		}
		return  leg;
	}
	
	/**
	 * This method return the amendment object using current amendment index 
	 * @param index
	 * @param leg
	 * @return
	 * @throws ICFPException
	 */
	public static Amendment getAmendment(int index, Object leg) throws ICFPException {
		Amendment amendment = null;
		List<Amendment> legAmendments = ICFPLegHelper.filterDeletedAmendments(ICFPDay2LegHelper.getAmendments(leg));
		if(legAmendments != null && !legAmendments.isEmpty()) {
			amendment = legAmendments.get(index - 1);
		}
		if(amendment == null) {
			throw new ICFPAttachmentException(ICFPAttachmentException.ERROR_CODE_INVALID_INPUT_PARAMS, "Invalid Amendment Index " + index);
		}
		return amendment;
	}
	
	/**
	 * This method return the Exception object using current exception index 
	 * @param index
	 * @param leg
	 * @return
	 * @throws ICFPAttachmentException 
	 */
	public static ExceptionRequestForm getExceptionRequestForm(int index, Object leg) throws ICFPAttachmentException {
		ExceptionRequestForm exceptionRequest = null;
		List<ExceptionRequestForm> legExceptions = ICFPLegHelper.filterDeletedExceptions(ICFPLegHelper.getExceptions(leg));
		if(legExceptions!=null && !legExceptions.isEmpty()) {
			exceptionRequest = legExceptions.get(index - 1);
		}
		if(exceptionRequest == null) {
			throw new ICFPAttachmentException(ICFPAttachmentException.ERROR_CODE_INVALID_INPUT_PARAMS, "Invalid Exception Index " + index);
		}
		return exceptionRequest;
	}
	
	/**
	 * This method return the Derivatives object using current derivative index and leg index 
	 * @param index
	 * @param leg
	 * @return
	 * @throws ICFPAttachmentException 
	 */
	public static DerivativesRequest getDerivativeRequest(int index, Object leg) throws ICFPAttachmentException {
		DerivativesRequest derivativeRequest = null;
		List<DerivativesRequest> derivatives = ICFPLegHelper.filterDeletedDerivatives(ICFPLegHelper.getDerivatives(leg));
		if(derivatives != null && !derivatives.isEmpty()) {
			derivativeRequest = derivatives.get(index - 1);
		}
		if(derivativeRequest == null) {
			throw new ICFPAttachmentException(ICFPAttachmentException.ERROR_CODE_INVALID_INPUT_PARAMS, "Invalid Derivative Index " + index);
		}
		return derivativeRequest;
	}
	
	/**
	 * This method return the Attachment object by providing the gefileId
	 * @param repFileId
	 * @param request
	 * @return
	 * @throws ICFPException 
	 */
	public static Attachment getAttachmentByRepositoryId(String repFileId, HttpServletRequest request) throws ICFPException {
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		return getAttachmentByGELibId(repFileId, deal);
	}
	
	/**
	 * This method return attachment object 
	 * It will search and return the deal Attachment object by providing the gefileId
	 * @param id
	 * @return
	 * @throws ICFPException 
	 */
	public static Attachment getAttachmentByGELibId(String id, DealRequest deal) throws ICFPException {
		// Searching in deal attachments
		Attachment result = searchAttachmentByGELibId(id, deal.getAttachments());
		
		// Searching in legs
		if(result == null && deal.getLegs() != null && !deal.getLegs().getAllLegs().isEmpty()) {
			for(Object leg : deal.getLegs().getAllLegs()) {
				result = getLegAttachmentByGELibId(id, leg);
				if(result != null) {
					break;
				}
			}
		}
		return result;
	}
	
	/**
	 * This method returns deleted attachment object by setting delete opcode for particular attachment by providing gefileid 
	 * @param id
	 * @return
	 * @throws ICFPException 
	 */
	public static Attachment deleteAttachmentByGELibId(String id, DealRequest deal) throws ICFPException {
		// Searching in deal attachments
		Attachment result = deleteAttachmentByGELibId(id, deal.getAttachments());
		
		// Searching in legs
		if(result == null && deal.getLegs() != null && !deal.getLegs().getAllLegs().isEmpty()) {
			for(Object leg : deal.getLegs().getAllLegs()) {
				result = deleteLegAttachmentByGELibId(id, leg);
				if(result != null) {
					break;
				}
			}
		}
		return result;
	}
	
	/**
	 * This method returns leg attachment by providing the gefileid and leg object
	 * @param id
	 * @param leg
	 * @return
	 * @throws ICFPException 
	 */
	public static Attachment getLegAttachmentByGELibId(String id, Object leg) throws ICFPException {
		ProductType productType = ICFPLegHelper.getProductType(leg);
		if(productType == ProductType.CPA) {
			return performCPALegAttachmentOperation(id, (CPALegRequest)leg, AttachmentOperation.FETCH);
		} else {
			return performNonCPALegAttachmentOperation(id, leg, AttachmentOperation.FETCH);
		}
	}
	
	/**
	 * This method returns deleted leg attachment object by setting delete opcode for particular attachment by providing gefileid
	 * @param id
	 * @param leg
	 * @return
	 * @throws ICFPException 
	 */
	public static Attachment deleteLegAttachmentByGELibId(String id, Object leg) throws ICFPException {
		ProductType productType = ICFPLegHelper.getProductType(leg);
		if(productType == ProductType.CPA) {
			return performCPALegAttachmentOperation(id, (CPALegRequest)leg, AttachmentOperation.DELETE);
		} else {
			return performNonCPALegAttachmentOperation(id, leg, AttachmentOperation.DELETE);
		}
	}
	
	
	/**
	 * This method returns DEBT/Equity attachment object by setting opcode for particular attachment by providing gefileid and leg object
	 * @param id
	 * @param leg
	 * @return
	 * @throws ICFPException 
	 */
	private static Attachment performNonCPALegAttachmentOperation(String id, Object leg, AttachmentOperation operation) throws ICFPException {
		LegSummary legSummary = (LegSummary) ICFPLegHelper.getLegSummary(leg);
		// Searching in Leg Level attachments
		Attachment result = performAttachmentOperationByGELibId(id, legSummary.getAttachments(), operation);
		
		// Search in ExceptionRequestForms
		if(result == null && !legSummary.getExceptionRequestForms().isEmpty()) {
			List<ExceptionRequestForm> filteredExceptions = ICFPLegHelper.filterDeletedExceptions(legSummary.getExceptionRequestForms());
			for(ExceptionRequestForm exceptionRequestForm : filteredExceptions) {
				result = performAttachmentOperationByGELibId(id, exceptionRequestForm.getAttachments(), operation);
				if(result != null) {
					break;
				}
			}
		}
		
		// Search in Derivatives
		if(result == null && !legSummary.getDerivativesRequests().isEmpty()) {
			List<DerivativesRequest> filteredDerivatives = ICFPLegHelper.filterDeletedDerivatives(legSummary.getDerivativesRequests());
			for(DerivativesRequest derivative : filteredDerivatives) {
				result = performAttachmentOperationByGELibId(id, derivative.getAttachments(), operation);
				if(result != null) {
					break;
				}
			}
		}
		
		// Search in Amendments
		if(result == null) {
			List<Amendment> amendments = ICFPDay2LegHelper.getAmendments(leg);
			if(amendments != null && !amendments.isEmpty()) {
				List<Amendment> filteredAmendments = ICFPLegHelper.filterDeletedAmendments(amendments);
				for(Amendment amendment : filteredAmendments) {
					result = performAttachmentOperationByGELibId(id, amendment.getAttachments(), operation);
					if(result != null) {
						break;
					}
				}
			}
		}
		
		return result;
	}
	
	/**
	 * This method returns CPA attachment object by setting opcode for particular attachment by providing gefileid and leg object
	 * @param id
	 * @param leg
	 * @return
	 * @throws ICFPException 
	 */
	private static Attachment performCPALegAttachmentOperation(String id, CPALegRequest leg, AttachmentOperation operation) throws ICFPException {
		Attachment result = performAttachmentOperationByGELibId(id, leg.getCPASummary().getAttachments(), operation);
		
		// Search in ExcpetionRequestForms
		if(result == null && !leg.getCPASummary().getExceptionRequestForms().isEmpty()) {
			List<ExceptionRequestForm> filteredExceptions = ICFPLegHelper.filterDeletedExceptions(leg.getCPASummary().getExceptionRequestForms());
			for(ExceptionRequestForm exceptionRequestForm : filteredExceptions) {
				result = performAttachmentOperationByGELibId(id, exceptionRequestForm.getAttachments(), operation);
				if(result != null) {
					break;
				}
			}
		}
		
		// Search in Amendments
		if(result == null) {
			List<Amendment> amendments = ICFPDay2LegHelper.getAmendments(leg);
			if(amendments != null && !amendments.isEmpty()) {
				List<Amendment> filteredAmendments = ICFPLegHelper.filterDeletedAmendments(amendments);
				for(Amendment amendment : filteredAmendments) {
					result = performAttachmentOperationByGELibId(id, amendment.getAttachments(), operation);
					if(result != null) {
						break;
					}
				}
			}
		}
		return result;
	}
	
	/**
	 * This method returns attachment object by setting opcode for particular attachment
	 * It will search in the list of attachment object of perticular gefileid
	 * @param id
	 * @param attachmentList
	 * @param operation
	 * @return
	 */
	public static Attachment performAttachmentOperationByGELibId(String id, List<Attachment> attachmentList, AttachmentOperation operation) {
		return (operation == AttachmentOperation.FETCH) ? searchAttachmentByGELibId(id, attachmentList) : deleteAttachmentByGELibId(id, attachmentList);
	}
	
	/**
	 *  This method returns attachment by searching with the gefileid in the list
	 * @param id
	 * @param attachmentList
	 * @return
	 */
	public static Attachment searchAttachmentByGELibId(String id, List<Attachment> attachmentList) {
		if(attachmentList != null && !attachmentList.isEmpty()) {
			for(Attachment attachment : attachmentList) {
				if(id.equals(attachment.getGeFileId())) {
					return attachment;
				}
			}
		}
		return null;
	}
	
	/**
	 *  This method used to remove attachment object from the list which is equal to provided gefileid
	 * @param id
	 * @param attachmentList
	 * @return
	 */
	public static Attachment deleteAttachmentByGELibId(String id, List<Attachment> attachmentList) {
		if(attachmentList != null && !attachmentList.isEmpty()) {
			Iterator<Attachment> attachmentItr = attachmentList.listIterator();
			Attachment attachment = null;
			while(attachmentItr.hasNext()) {
				attachment = attachmentItr.next();
				if(id.equals(attachment.getGeFileId())) {
					attachmentItr.remove();
				}
			}
		}
		return null;
	}
	
	/**
	 * This method used to provide the list of attachment for particular type
	 * @param type
	 * @param attachmentList
	 * @return
	 */
	public static List<Attachment> searchAttachmentByType(AttachmentType type, List<Attachment> attachmentList) {
		List<Attachment> result = new ArrayList<Attachment>();
		if(attachmentList != null && !attachmentList.isEmpty()) {
			for(Attachment attachment : attachmentList) {
				if(attachment.getAttachmentTypeId().equals(type.getId())) {
					result.add(attachment);
				}
			}
		}
		return result;
	}
	
	/**
	 * This method used to provide the collection of attachment object for particular leg
	 * @param leg
	 * @return
	 * @throws ICFPException 
	 */
	public static Collection<Attachment> getAllLegAttachments(Object leg) throws ICFPException {
		List<Attachment> result = new ArrayList<Attachment>();
		ProductType productType = ICFPLegHelper.getProductType(leg);
		if(productType == ProductType.CPA) {
			CPASummary cpaSummary = ((CPALegRequest) leg).getCPASummary();
			result.addAll(cpaSummary.getAttachments());
		} else {
			LegSummary legSummary = (LegSummary) ICFPLegHelper.getLegSummary(leg);
			result.addAll(legSummary.getAttachments());
			
			if(!legSummary.getExceptionRequestForms().isEmpty()) {
				List<ExceptionRequestForm> filteredExceptions = ICFPLegHelper.filterDeletedExceptions(legSummary.getExceptionRequestForms());
				for(ExceptionRequestForm exceptionRequestForm : filteredExceptions) {
					result.addAll(exceptionRequestForm.getAttachments());
				}
			}
			
			if(!legSummary.getDerivativesRequests().isEmpty()) {
				List<DerivativesRequest> filteredDerivatives = ICFPLegHelper.filterDeletedDerivatives(legSummary.getDerivativesRequests());
				for(DerivativesRequest derivative : filteredDerivatives) {
					result.addAll(derivative.getAttachments());
				}
			}
		}
		
		List<Amendment> amendments = ICFPDay2LegHelper.getAmendments(leg);
		if(amendments != null && !amendments.isEmpty()) {
			List<Amendment> filteredAmendments = ICFPLegHelper.filterDeletedAmendments(amendments);
			for(Amendment amendment : filteredAmendments) {
				result.addAll(amendment.getAttachments());
			}
		}
		return result;
	}
	
	/**
	 * This method returns the all leg indexes to parse legs
	 * @param deal
	 * @return
	 */
	public static Integer[] getAllAttachmentLegIndexes(DealRequest deal) {
		Map<Integer, Object> legsWithIndexes = getAllAttachmentLegsWithIndexes(deal);
		Integer[] result = new Integer[legsWithIndexes.size()];
		result = legsWithIndexes.keySet().toArray(result);
		return result;
	}
	
	/**
	 * Method returns the Map object i.e key as leg index and value as legsummary
	 * @param deal
	 * @return
	 */
	public static Map<Integer, Object> getAllAttachmentLegsWithIndexes(DealRequest deal) {
		Map<Integer, Object> result = new LinkedHashMap<Integer, Object>();
		Object leg = null;
		for(int legIndex = 1; (leg = ICFPCommonHelper.getLegByNumber(legIndex, deal)) != null; legIndex++) {
			// Skip the immediate dradown legs
			if(leg instanceof RCALegRequest) {
				LegSummary legSummary = ((RCALegRequest) leg).getLegSummary();
				if(legSummary != null && StringUtils.isNotBlank(legSummary.getTransactionEventType()) && "Immediate Drawdown".equalsIgnoreCase(legSummary.getTransactionEventType())) {
					continue;
				}
			}
			result.put(legIndex, leg);
		}
		return result;
	}
	
	/**
	 * This method returns all the attachments of deal.
	 * 
	 * @param deal
	 * @return
	 * @throws ICFPException 
	 */
	public static List<Attachment> getAllAttachments(DealRequest deal) throws ICFPException {
		List<Attachment> allAttachments = new ArrayList<Attachment>();
		allAttachments.addAll(deal.getAttachments());
		for(Iterator<Object> legItr = getAllAttachmentLegsWithIndexes(deal).values().iterator(); legItr.hasNext(); ) {
			allAttachments.addAll(getAllLegAttachments(legItr.next()));
		}
		return allAttachments;
	}
	
	/**
	 *  Attachment operation for fetch/delete
	 * @author chaitanya.n
	 *
	 */
	public static enum AttachmentOperation {
		FETCH, DELETE;
	}
}
