/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: LegBuilder.java
 * Purpose: This class renders leg information of the PDF report.
 */
package com.ge.icfp.util.report.pdf.builder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.ge.icfp.action.ICFPException;
import com.ge.icfp.common.helper.EntityHelper;
import com.ge.icfp.common.helper.EntityHelper.EntityType;
import com.ge.icfp.common.helper.ICFPDay2LegHelper;
import com.ge.icfp.common.helper.ICFPLegHelper;
import com.ge.icfp.model.CPALegRequest;
import com.ge.icfp.model.DayTwoOperations;
import com.ge.icfp.model.DealRequest;
import com.ge.icfp.model.Entity;
import com.ge.icfp.model.EquityLegRequest;
import com.ge.icfp.model.FacilityIncreaseDecrease;
import com.ge.icfp.model.LegSummary;
import com.ge.icfp.model.OtherLegRequest;
import com.ge.icfp.model.RCALegRequest;
import com.ge.icfp.model.RateInformation;
import com.ge.icfp.model.ShareInfo;
import com.ge.icfp.model.SolvencyMetrics;
import com.ge.icfp.model.StaticDataManagement.SolvencyMetricsCalc;
import com.ge.icfp.model.TPLegRequest;
import com.ge.icfp.util.EventType;
import com.ge.icfp.util.ProductType;
import com.ge.icfp.util.Utils;
import com.ge.icfp.util.report.pdf.DealPDFStyle;
import com.ge.icfp.util.report.pdf.PDFReportHelper;
import com.ge.icfp.util.report.pdf.ReportContext;
import com.hydus.wff.core.exception.HWFServiceException;
import com.hydus.wff.core.exception.HWFStubException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import static com.ge.icfp.common.constants.ICFPConstants.*;
/**
 * This class provides rendering functionality for common sections in Day1 and Day2 legs.
 * 
 * @author chaitanya
 */
public class LegBuilder<T extends LegBuilder<T>> extends ReportBuilder {
	
	private static final String PRUDENTIALLY_REGULATED_ENTITY = "Prudentially Regulated Entity";
	private static final String PRINCIPAL_ENTITY = "Principal Entity";
	private static final String GOLD_ID = "GOLD ID";
	private static final String BORROWER = "Borrower";
	private static final String PURCHASER = "Purchaser";
	private static final String RECIPIENT = "Recipient";
	private static final String LENDER = "Lender";
	private static final String ISSUER = "Issuer";
	private static final String PROVIDER = "Provider";
	private static final String TERM_IN_MONTHS2 = "termInMonths";
	private static final String TERM_IN_MONTHS = "Term (in months)";
	private static final String TERM = "term";
	private static final String PRODUCT_TYPE = "Product Type";
	private static final String EVENT_TYPE = "Event Type";
	
	/**
	 * Creates LegBuilder object dependes on type of leg.
	 * 
	 * @param context
	 * @param legNumber
	 * @param leg
	 * @return
	 * @throws ICFPException
	 */
	public static LegBuilder<?> newLegBuilder(ReportContext context, int legNumber, Object leg) throws ICFPException {
		if(PDFReportHelper.isImmediateDrawdownLeg(leg)) {
			return new Day1LegBuilder(context, legNumber, leg);
		} else if(ICFPDay2LegHelper.isDay2Leg(leg)) {
			return new Day2LegBuilder(context, legNumber, leg);
		} else {
			return new Day1LegBuilder(context, legNumber, leg);
		}
	}
	
	protected int legNumber;
	protected Object leg;
	
	/**
	 * Crates the instance of this class.
	 * 
	 * @param context
	 * @param legNumber
	 */
	protected LegBuilder(ReportContext context, int legNumber, Object leg) {
		super(context);
		this.legNumber = legNumber;
		this.leg = leg;
	}
	

	/**
	 * Renders the Leg information.
	 * 
	 * @return
	 * @throws DocumentException 
	 * @throws ICFPException 
	 */
	@SuppressWarnings("unchecked")
	public T appendLegInfo() throws DocumentException, ICFPException {
		Section section = getReportContext().getCurrentSection();
		DealRequest deal = getReportContext().getDeal();
		Object legSummary = getLegSummary();
		boolean isCPALeg = isCPALeg();
		PdfPTable legDetailSummary = DealPDFStyle.createFormTable(2);
		
		legDetailSummary.addCell(DealPDFStyle.createEmptyFormFieldCell(false));
		
		EventType eventType = ICFPDay2LegHelper.getEventType(getLeg());
		StringBuilder eventName = new StringBuilder();
		if(PDFReportHelper.isImmediateDrawdownLeg(leg)) {
			eventName.append(Utils.fetchPropertyValue(TRANSACTIONEVENTTYPE, legSummary, String.class)).append(" for Leg # ").append(Utils.fetchPropertyValueAsString("drawDown", legSummary));
		} else if(eventType != null && eventType == EventType.AMENDMENT_FACILITY_INC_DEC) {
			eventName.append(AMENDMENTFACILITY);
			DayTwoOperations dayTwoOperations = Utils.fetchPropertyValue(DAYTWOOPERATIONS, leg, DayTwoOperations.class);
			FacilityIncreaseDecrease facilityIncDec = (dayTwoOperations != null) ? dayTwoOperations.getFacilityIncreaseDecrease() : null;
			eventName.append((facilityIncDec.getFacilityTypeId().equals(1)) ? INCREASE : DECREASE);
		} else if(eventType != null) {
			eventName.append(Utils.fetchPropertyValue(TRANSACTIONEVENTTYPE, legSummary, String.class));
		} else {
			eventName.append(NEW_TRANSACTION);
		}
		legDetailSummary.addCell(DealPDFStyle.createFormFieldCell(LegBuilder.EVENT_TYPE, eventName.toString(), false));
		
		legDetailSummary.addCell(DealPDFStyle.createFormFieldCell(LegBuilder.PRODUCT_TYPE, Utils.fetchPropertyValue(PRODUCTTYPE, legSummary, String.class), true));
		if(isCPALeg) {
			legDetailSummary.addCell(DealPDFStyle.createFormFieldCell(DEAL_CURRENCY, Utils.fetchPropertyValue(CURRENCYCD, legSummary, String.class), true));
			String termsInMonths = PDFReportHelper.formatDouble(Utils.fetchPropertyValue(LegBuilder.TERM, legSummary, Double.class));
			legDetailSummary.addCell(DealPDFStyle.createFormFieldCell(LegBuilder.TERM_IN_MONTHS, termsInMonths, false));
		} else {
			legDetailSummary.addCell(DealPDFStyle.createFormFieldCell(DEAL_CURRENCY, Utils.fetchPropertyValue(ORIGINALCCY, legSummary, String.class), true));
			Integer termsInMonths = Utils.fetchPropertyValue(LegBuilder.TERM_IN_MONTHS2, legSummary, Integer.class);
			legDetailSummary.addCell(DealPDFStyle.createFormFieldCell(LegBuilder.TERM_IN_MONTHS, ((termsInMonths != null) ? String.valueOf(termsInMonths) : null), false));
			
			Double amount = null;
			if(PDFReportHelper.isImmediateDrawdownLeg(leg)) {
				amount = Utils.fetchPropertyValue(IMMDTDRDOWNAMT, leg, Double.class);
			} else if(eventType == EventType.AMENDMENT_FACILITY_INC_DEC) {
				DayTwoOperations dayTwoOperations = Utils.fetchPropertyValue(DAYTWOOPERATIONS, leg, DayTwoOperations.class);
				if(dayTwoOperations != null && dayTwoOperations.getFacilityIncreaseDecrease() != null) {
					amount = dayTwoOperations.getFacilityIncreaseDecrease().getFacilityIncDecAmt();
				}
			} else {
				amount = ((LegSummary) legSummary).getOriginalCCYAmount();
			}
			legDetailSummary.addCell(DealPDFStyle.createFormFieldCell(AMOUNT, PDFReportHelper.formatCurrency(amount), false));
			
			Double usdEquivalent = null;
			if(eventType == EventType.AMENDMENT_FACILITY_INC_DEC) {
				DayTwoOperations dayTwoOperations = Utils.fetchPropertyValue(DAYTWOOPERATIONS, leg, DayTwoOperations.class);
				if(dayTwoOperations != null && dayTwoOperations.getFacilityIncreaseDecrease() != null) {
					usdEquivalent = dayTwoOperations.getFacilityIncreaseDecrease().getFacilityIncDecUSDEquivalentAmt();
				}
			} else {
				usdEquivalent = Utils.fetchPropertyValue(USDEQUIVALENT, legSummary, Double.class);
			}
			legDetailSummary.addCell(DealPDFStyle.createFormFieldCell(USD_EQUIVALENT, PDFReportHelper.formatCurrency(usdEquivalent), true));
		}
		legDetailSummary.addCell(DealPDFStyle.createFormFieldCell(VALUE_DATE, PDFReportHelper.formatDate(deal.getValueDt()), true));
		
		section.add(legDetailSummary);
		return (T)this;
	}
	
	
	/**
	 * Renders Lender information of the leg.
	 * 
	 * @return
	 * @throws DocumentException 
	 * @throws ICFPException 
	 */
	@SuppressWarnings("unchecked")
	public T appendLenderInformation() throws DocumentException, ICFPException {
		ProductType productType = ICFPLegHelper.getProductType(getLeg());

		Object legSummary = getLegSummary();
		String entityTypeName = null;
		switch(productType) {
			case EQUITY:
				entityTypeName = LegBuilder.PROVIDER;
				break;
			case BOND:
				entityTypeName = LegBuilder.PURCHASER;
				break;
			default:
				entityTypeName = LegBuilder.LENDER;
				break;
		}
		
		Section section = DealPDFStyle.createSubSection(entityTypeName, getReportContext().getCurrentSection());
		PdfPTable entityInfo = DealPDFStyle.createFormTable(2);
		
		Entity entity = EntityHelper.searchEntity(legSummary, EntityType.ORIGINAL_LENDER);
		
		entityInfo.addCell(DealPDFStyle.createEmptyFormFieldCell(false));
		String isLegalEntity = (entity != null) ? PDFReportHelper.convertYOrNToYesOrNo(entity.getEntitySetupFlag()) : null;
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(LEGAL_ENTITY_SETUP_PENDING,isLegalEntity, false));
		
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(CDR_CODE, ((entity != null) ? entity.getCDRCd() : null), true));
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(LEGAL_ENTITY_GOLD_ID, ((entity != null) ? entity.getLEGoldId() : null), true));
		
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(LEGAL_ENTITY_NAME, ((entity != null) ? entity.getLEName() : null), false));
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(COUNTRY_BIG, ((entity != null) ? entity.getCountry() : null), false));
		
		String headerName = new StringBuilder().append("Is ").append(entityTypeName).append(" a Regulated Entity").toString();
		String isRequlatedEntity = (entity != null) ? PDFReportHelper.convertBooleanAsYesOrNo(entity.isRegulatedEntityFlag()) : null;
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(headerName, isRequlatedEntity, true));		
		headerName = new StringBuilder().append("Is ").append(entityTypeName).append(" a Principal Entity").toString();
		String isPrincipalEntity = (entity != null) ? PDFReportHelper.convertBooleanAsYesOrNo(entity.isPrincplEntityFlag()) : null;
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(headerName, isPrincipalEntity, true));
		
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(MANAGEMENT_ENTITY, ((entity != null) ? entity.getMEName() : null), false));
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(CAPITAL_OR_INDUSTRIAL, ((entity != null) ? entity.getCapitalIndustrial() : null), false));
		
		String treasuryCode = (!entity.getTreasuryCodes().isEmpty()) ? entity.getTreasuryCodes().get(0) : null;
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(TREASURY_CODE, treasuryCode, true));
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(BUSINESS_SEGMENT, ((entity != null) ? entity.getBusinessSegment() : null), true));
		
		entityInfo.addCell(DealPDFStyle.createEmptyFormFieldCell(false));
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(FUNDING_COMPANY_HOLDING, ((entity != null) ? entity.getFundHoldOperation() : null), false));
		
		section.add(entityInfo);
		return (T)this;
	}
	
	
	/**
	 * Renders Borrower information of the leg.
	 * 
	 * @return
	 * @throws DocumentException 
	 * @throws ICFPException 
	 */
	@SuppressWarnings("unchecked")
	public T appendBorrowerInformation() throws DocumentException, ICFPException {
		ProductType productType = ICFPLegHelper.getProductType(getLeg());
		Object legSummary = getLegSummary();
		String entityTypeName = null;
		switch(productType) {
			case EQUITY:
				entityTypeName = LegBuilder.RECIPIENT;
				break;
			case BOND:
				entityTypeName = LegBuilder.ISSUER;
				break;
			default:
				entityTypeName = LegBuilder.BORROWER;
				break;
		}
		
		Section section = DealPDFStyle.createSubSection(entityTypeName, getReportContext().getCurrentSection());
		PdfPTable entityInfo = DealPDFStyle.createFormTable(2);
		
		
		Entity entity = EntityHelper.searchEntity(legSummary, EntityType.ORIGINAL_BORROWER);
		
		entityInfo.addCell(DealPDFStyle.createEmptyFormFieldCell(false));
		String isLegalEntity = (entity != null) ? PDFReportHelper.convertYOrNToYesOrNo(entity.getEntitySetupFlag()) : null;
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(LEGAL_ENTITY_SETUP_PENDING,isLegalEntity, false));
		
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(CDR_CODE, ((entity != null) ? entity.getCDRCd() : null), true));
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(LEGAL_ENTITY_GOLD_ID, ((entity != null) ? entity.getLEGoldId() : null), true));
		
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(LEGAL_ENTITY_NAME, ((entity != null) ? entity.getLEName() : null), false));
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(COUNTRY_BIG, ((entity != null) ? entity.getCountry() : null), false));
		
		String headerName = new StringBuilder().append("Is ").append(entityTypeName).append(" a Regulated Entity").toString();
		String isRequlatedEntity = (entity != null) ? PDFReportHelper.convertBooleanAsYesOrNo(entity.isRegulatedEntityFlag()) : null;
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(headerName, isRequlatedEntity, true));		
		headerName = new StringBuilder().append("Is ").append(entityTypeName).append(" a Principal Entity").toString();
		String isPrincipalEntity = (entity != null) ? PDFReportHelper.convertBooleanAsYesOrNo(entity.isPrincplEntityFlag()) : null;
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(headerName, isPrincipalEntity, true));
		
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(MANAGEMENT_ENTITY, ((entity != null) ? entity.getMEName() : null), false));
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(CAPITAL_OR_INDUSTRIAL, ((entity != null) ? entity.getCapitalIndustrial() : null), false));
		
		String treasuryCode = (!entity.getTreasuryCodes().isEmpty()) ? entity.getTreasuryCodes().get(0) : null;
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(TREASURY_CODE, treasuryCode, true));
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(BUSINESS_SEGMENT, ((entity != null) ? entity.getBusinessSegment() : null), true));
		
		entityInfo.addCell(DealPDFStyle.createEmptyFormFieldCell(false));
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(FUNDING_COMPANY_HOLDING, ((entity != null) ? entity.getFundHoldOperation() : null), false));
		
		section.add(entityInfo);
		return (T)this;
	}
	
	/**
	 * Renders Guarantee information of the leg.
	 * 
	 * @return
	 * @throws DocumentException 
	 * @throws ICFPException 
	 */
	@SuppressWarnings("unchecked")
	public T appendGuaranteeInformation() throws DocumentException, ICFPException {
		Object leg =  getLeg();
		Boolean isGuaranteeFeeApplicableFlag = null;
		if(leg instanceof RCALegRequest) {
			isGuaranteeFeeApplicableFlag = ((RCALegRequest) leg).isGuaranteeFeeApplicableFlag();
		} else if(leg instanceof OtherLegRequest) {
			isGuaranteeFeeApplicableFlag = ((OtherLegRequest) leg).isGuaranteeFeeApplicableFlag();
		}
		if(isGuaranteeFeeApplicableFlag == null || !isGuaranteeFeeApplicableFlag) {
			return (T) this;
		}
		LegSummary legSummary = (LegSummary) ICFPLegHelper.getLegSummary(leg);
		Section section = DealPDFStyle.createSubSection("Guarantor Information", getReportContext().getCurrentSection());
		PdfPTable entityInfo = DealPDFStyle.createFormTable(2);
		Entity entity = EntityHelper.searchEntity(legSummary, EntityType.GUARANTOR);
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(CDR_CODE, ((entity != null) ? entity.getCDRCd() : null), false));
		entityInfo.addCell(DealPDFStyle.createEmptyFormFieldCell(false));
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(LEGAL_ENTITY_NAME, ((entity != null) ? entity.getLEName() : null), true));
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(LegBuilder.GOLD_ID, ((entity != null) ? entity.getLEGoldId() : null), true));
		String isPrincipalEntity = (entity != null) ? PDFReportHelper.convertBooleanAsYesOrNo(entity.isPrincplEntityFlag()) : null;
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(LegBuilder.PRINCIPAL_ENTITY, isPrincipalEntity, false));
		String isRequlatedEntity = (entity != null) ? PDFReportHelper.convertBooleanAsYesOrNo(entity.isRegulatedEntityFlag()) : null;
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(LegBuilder.PRUDENTIALLY_REGULATED_ENTITY, isRequlatedEntity, false));	
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(MANAGEMENT_ENTITY, ((entity != null) ? entity.getMEName() : null), true));
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(COUNTRY_BIG, ((entity != null) ? entity.getCountry() : null), true));
		section.add(entityInfo);
		return (T)this;
	}
	
	
	/**
	 * Renders Fee and Withholding details
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T appendFeeAndWithholdingDetails() {
		Object leg =  getLeg();
		Boolean isGuaranteeFeeApplicableFlag = null;
		Double guaranteeFeeRate = null;
		Boolean isGuaranteeAgreementFlag = null;
		
		if(leg instanceof RCALegRequest) {
			isGuaranteeFeeApplicableFlag = ((RCALegRequest) leg).isGuaranteeFeeApplicableFlag();
			guaranteeFeeRate = ((RCALegRequest) leg).getGuaranteeFeeRate();
			isGuaranteeAgreementFlag = ((RCALegRequest) leg).isGuaranteeAgreementFlag();
		} else if(leg instanceof OtherLegRequest) {
			isGuaranteeFeeApplicableFlag = ((OtherLegRequest) leg).isGuaranteeFeeApplicableFlag();
			guaranteeFeeRate  = ((OtherLegRequest) leg).getGuaranteeFeeRate();
			isGuaranteeAgreementFlag = ((OtherLegRequest) leg).isGuaranteeAgreementFlag();
		}
		
		Section section = DealPDFStyle.createSubSection("Fee and Withholding", getReportContext().getCurrentSection());
		PdfPTable feeAndWithholdingTable = DealPDFStyle.createFormTable(2);
		feeAndWithholdingTable.addCell(DealPDFStyle.createFormFieldCell("Guarantee Agreement Attached?", PDFReportHelper.convertBooleanAsYesOrNo(isGuaranteeAgreementFlag), false));
		feeAndWithholdingTable.addCell(DealPDFStyle.createEmptyFormFieldCell(false));
		
		feeAndWithholdingTable.addCell(DealPDFStyle.createFormFieldCell("Guarantee fee applicable", PDFReportHelper.convertBooleanAsYesOrNo(isGuaranteeFeeApplicableFlag), true));
		if(isGuaranteeFeeApplicableFlag != null && isGuaranteeFeeApplicableFlag) {
			feeAndWithholdingTable.addCell(DealPDFStyle.createFormFieldCell("Guarantee fee rate", PDFReportHelper.formatDouble(guaranteeFeeRate), true));
		} else {
			feeAndWithholdingTable.addCell(DealPDFStyle.createEmptyFormFieldCell(true));
		}
		
		if(leg instanceof RCALegRequest) {
			Boolean withhldingTaxApplicableFlag = ((RCALegRequest) leg).isWithhldngTaxApplicableFlag();
			Boolean otherFeesFlag = ((RCALegRequest) leg).isOtherFeeFlag();
			feeAndWithholdingTable.addCell(DealPDFStyle.createFormFieldCell("Withholding tax applicable", PDFReportHelper.convertBooleanAsYesOrNo(withhldingTaxApplicableFlag), false));
			feeAndWithholdingTable.addCell(DealPDFStyle.createFormFieldCell("Other fees", PDFReportHelper.convertBooleanAsYesOrNo(otherFeesFlag), false));
		}
		section.add(feeAndWithholdingTable);
		return (T)this;
	}
	
	
	/**
	 * Renders the Participant information of the leg.
	 * 
	 * @return
	 * @throws DocumentException 
	 * @throws ICFPException 
	 */
	@SuppressWarnings("unchecked")
	public T appendParticipantInformation() throws DocumentException, ICFPException {
		Section section = DealPDFStyle.createSubSection("Participant", getReportContext().getCurrentSection());
		PdfPTable entityInfo = DealPDFStyle.createFormTable(2);
		
		Object legSummary = getLegSummary();
		Entity entity = EntityHelper.searchEntity(legSummary, EntityType.PARTICIPANT);
		
		entityInfo.addCell(DealPDFStyle.createEmptyFormFieldCell(false));
		String isLegalEntity = (entity != null) ? PDFReportHelper.convertYOrNToYesOrNo(entity.getEntitySetupFlag()) : null;
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(LEGAL_ENTITY_SETUP_PENDING,isLegalEntity, false));
		
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(CDR_CODE, ((entity != null) ? entity.getCDRCd() : null), true));
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(LEGAL_ENTITY_GOLD_ID, ((entity != null) ? entity.getLEGoldId() : null), true));
		
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(LEGAL_ENTITY_NAME, ((entity != null) ? entity.getLEName() : null), false));
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(COUNTRY_BIG, ((entity != null) ? entity.getCountry() : null), false));
		
		String isRequlatedEntity = (entity != null) ? PDFReportHelper.convertBooleanAsYesOrNo(entity.isRegulatedEntityFlag()) : null;
		entityInfo.addCell(DealPDFStyle.createFormFieldCell("Is Participant a Regulated Entity", isRequlatedEntity, true));		
		String isPrincipalEntity = (entity != null) ? PDFReportHelper.convertBooleanAsYesOrNo(entity.isPrincplEntityFlag()) : null;
		entityInfo.addCell(DealPDFStyle.createFormFieldCell("Is Participant a Principal Entity", isPrincipalEntity, true));
		
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(MANAGEMENT_ENTITY, ((entity != null) ? entity.getMEName() : null), false));
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(CAPITAL_OR_INDUSTRIAL, ((entity != null) ? entity.getCapitalIndustrial() : null), false));
		
		entityInfo.addCell(DealPDFStyle.createMultiRowFormFieldCell(TREASURY_CODE, ((entity != null) ? entity.getTreasuryCodes() : null), true));
		entityInfo.addCell(DealPDFStyle.createEmptyFormFieldCell(true));

		section.add(entityInfo);
		return (T)this;
	}
	
	
	/**
	 * Renders PoolLeader information of the leg.
	 * 
	 * @return
	 * @throws DocumentException 
	 * @throws ICFPException 
	 */
	@SuppressWarnings("unchecked")
	public T appendPoolLeaderInformation() throws DocumentException, ICFPException {
		Section section = DealPDFStyle.createSubSection("Pool Leader", getReportContext().getCurrentSection());
		PdfPTable entityInfo = DealPDFStyle.createFormTable(2);
		
		Object legSummary = getLegSummary();
		Entity entity = EntityHelper.searchEntity(legSummary, EntityType.POOL_LEADER);
		
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(CASH_POOL_NAME, ((entity != null) ? entity.getLEName() : null), true));
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(LEGAL_ENTITY_GOLD_ID, ((entity != null) ? entity.getLEGoldId() : null), true));
		
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(CDR_CODE, ((entity != null) ? entity.getCDRCd() : null), false));
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(COUNTRY_BIG, ((entity != null) ? entity.getCountry() : null), false));
		
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(LEGAL_ENTITY_NAME, ((entity != null) ? entity.getLEName() : null), true));
		String isPrincipalEntity = (entity != null) ? PDFReportHelper.convertBooleanAsYesOrNo(entity.isPrincplEntityFlag()) : null;
		entityInfo.addCell(DealPDFStyle.createFormFieldCell("Is Pool Leader a Principal Entity", isPrincipalEntity, true));
		
		String isRequlatedEntity = (entity != null) ? PDFReportHelper.convertBooleanAsYesOrNo(entity.isRegulatedEntityFlag()) : null;
		entityInfo.addCell(DealPDFStyle.createFormFieldCell("Is Pool Leader a Regulated Entity", isRequlatedEntity, false));	
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(CAPITAL_OR_INDUSTRIAL, ((entity != null) ? entity.getCapitalIndustrial() : null), false));
		
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(MANAGEMENT_ENTITY, ((entity != null) ? entity.getMEName() : null), true));
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(BANK_NAME, ((entity != null) ? entity.getBankTreasuryCd() : null), true));
		
		entityInfo.addCell(DealPDFStyle.createMultiRowFormFieldCell(TREASURY_CODE, ((entity != null) ? entity.getTreasuryCodes() : null), false));
		entityInfo.addCell(DealPDFStyle.createEmptyFormFieldCell(false));
		
		section.add(entityInfo);
		return (T)this;
	}
	
	/**
	 * Renders Model Drivers of the leg.
	 * 
	 * @return
	 * @throws DocumentException 
	 * @throws ICFPException 
	 */
	@SuppressWarnings("unchecked")
	public T appendModelDriversInfo() throws DocumentException, ICFPException {
		Section section = DealPDFStyle.createSubSection("Model Type", getReportContext().getCurrentSection());
		PdfPTable modelTypeTable = DealPDFStyle.createFormTable(1);
		TPLegRequest tpLegRequest = Utils.fetchPropertyValue(TPLEGREQUEST, leg, TPLegRequest.class);
		modelTypeTable.addCell(DealPDFStyle.createFormFieldCell("Model type", ((tpLegRequest != null && tpLegRequest.getModelTypeId() != null) ? tpLegRequest.getModelType() : null), true));
		section.add(modelTypeTable);
		
		Integer modelTypeId = (tpLegRequest != null) ? tpLegRequest.getModelTypeId() : null;
		if(modelTypeId != null && modelTypeId.intValue() == 1) {
			section = DealPDFStyle.createSubSection("Model Drivers", getReportContext().getCurrentSection());
			PdfPTable modelDriverInfo = DealPDFStyle.createFormTable(2);
			
			modelDriverInfo.addCell(DealPDFStyle.createFormFieldCell("Total Debt (USD)", PDFReportHelper.formatCurrency(tpLegRequest.getTotalDebt()), true));
			String totalDebtCapital = PDFReportHelper.formatDouble(tpLegRequest.getTotalDebtCaptialRatio());
			totalDebtCapital = (totalDebtCapital != null) ? totalDebtCapital + "%" : totalDebtCapital;
			modelDriverInfo.addCell(DealPDFStyle.createFormFieldCell("Total Debt/Total Capital", totalDebtCapital, true));
			modelDriverInfo.addCell(DealPDFStyle.createFormFieldCell("Total Capital (USD)", PDFReportHelper.formatCurrency(tpLegRequest.getTotalCapital()), false));
			String netChargeOffReceivables = PDFReportHelper.formatDouble(tpLegRequest.getNetChargeOffReceivables());
			netChargeOffReceivables = (netChargeOffReceivables != null) ? netChargeOffReceivables + "%" : netChargeOffReceivables;
			modelDriverInfo.addCell(DealPDFStyle.createFormFieldCell("Net Charge-off/Receivables", netChargeOffReceivables, false));
			modelDriverInfo.addCell(DealPDFStyle.createFormFieldCell("Net Income (USD)", PDFReportHelper.formatCurrency(tpLegRequest.getNetIncome()), true));
			String netIntersetMargin = PDFReportHelper.formatDouble(tpLegRequest.getNetInterestMargin());
			netIntersetMargin = (netIntersetMargin != null) ? netIntersetMargin + "%" : netIntersetMargin;
			modelDriverInfo.addCell(DealPDFStyle.createFormFieldCell("Net Interest Margin", netIntersetMargin, true));
			String returnOnAvgAssets = PDFReportHelper.formatDouble(tpLegRequest.getReturnOnAvgAssets());
			returnOnAvgAssets = (returnOnAvgAssets != null) ? returnOnAvgAssets + "%" : returnOnAvgAssets;
			modelDriverInfo.addCell(DealPDFStyle.createFormFieldCell("Return on Avg. Assets", returnOnAvgAssets, false));
			modelDriverInfo.addCell(DealPDFStyle.createEmptyFormFieldCell(false));
			section.add(modelDriverInfo);
		}
		
		if(modelTypeId != null && modelTypeId.intValue() != 1) {
			PdfPTable pricingAtmtTable = DealPDFStyle.createFormTable(1);
			PdfPCell defaultCell = pricingAtmtTable.getDefaultCell();
			defaultCell.setBorder(Rectangle.NO_BORDER);
			defaultCell.setHorizontalAlignment(Element.ALIGN_LEFT);
			defaultCell.setBackgroundColor(new BaseColor(126, 246, 132));
			pricingAtmtTable.addCell(new Phrase("See Pricing Attachment.", DealPDFStyle.FONT_NORMAL));
			getReportContext().getCurrentSection().add(pricingAtmtTable);
		}
		
		return (T)this;
	}
	
	
	/**
	 * Renders Scores Info of the leg.
	 * 
	 * @return
	 * @throws DocumentException 
	 * @throws ICFPException 
	 */
	@SuppressWarnings("unchecked")
	public T appendScoresInfo() throws DocumentException, ICFPException {
		Section section = DealPDFStyle.createSubSection("Score", getReportContext().getCurrentSection());
		PdfPTable scoreInfo = DealPDFStyle.createFormTable(2);
		
		String modelScore = null;
		String spRatingId = null;
		String range = null;
		String finalRating = null;
		String sovereignConstraintFlag = null;
		String qualitativeNotches = null;
		String spNumericalRating = null;
		TPLegRequest tpLegRequest = Utils.fetchPropertyValue(TPLEGREQUEST, leg, TPLegRequest.class);
		if(tpLegRequest != null) {
			modelScore = tpLegRequest.getModelScore();
			spRatingId = (tpLegRequest.getSPRatingId() != null) ? tpLegRequest.getSPRating() : null;
			range = tpLegRequest.getRange();
			finalRating = tpLegRequest.getFinalRating();
			sovereignConstraintFlag = PDFReportHelper.convertBooleanAsYesOrNo(tpLegRequest.isSovereignConstraintFlag());
			qualitativeNotches = tpLegRequest.getQualitativeNotches();
			spNumericalRating = PDFReportHelper.formatDouble(tpLegRequest.getSPNumericalRating());
		}
		
		scoreInfo.addCell(DealPDFStyle.createFormFieldCell("Model Score", modelScore, true));
		scoreInfo.addCell(DealPDFStyle.createFormFieldCell("S&P Rating", spRatingId, true));
		scoreInfo.addCell(DealPDFStyle.createFormFieldCell("Range", range, false));
		scoreInfo.addCell(DealPDFStyle.createFormFieldCell("Final Rating", finalRating, false));
		scoreInfo.addCell(DealPDFStyle.createFormFieldCell("Sovereign Constraint", sovereignConstraintFlag, true));
		scoreInfo.addCell(DealPDFStyle.createFormFieldCell("Qualitative Notches", qualitativeNotches, true));
		scoreInfo.addCell(DealPDFStyle.createFormFieldCell("S&P Numerical Rating", spNumericalRating, false));
		scoreInfo.addCell(DealPDFStyle.createEmptyFormFieldCell(false));
		section.add(scoreInfo);
		
		return (T)this;
	}
	
	/**
	 * Renders Pricing information of the leg.
	 * 
	 * @return
	 * @throws DocumentException 
	 * @throws ICFPException 
	 */
	@SuppressWarnings("unchecked")
	public T appendPricingInfo() throws DocumentException, ICFPException {
		RateInformation rateInfo = Utils.fetchPropertyValue(RATEINFORMATION, leg, RateInformation.class);
		if(rateInfo == null) {
			return (T)this;
		}
		
		Section section = DealPDFStyle.createSubSection("Pricing Information", getReportContext().getCurrentSection());
		PdfPTable pricingInfo = DealPDFStyle.createFormTable(2);
		
		String interestType = (rateInfo.getInterestTypeId() != null) ? ((rateInfo.getInterestTypeId().equals(2)) ? "Float" : "Fixed") : null;
		pricingInfo.addCell(DealPDFStyle.createFormFieldCell("Interest Type", interestType, true));
		pricingInfo.addCell(DealPDFStyle.createEmptyFormFieldCell(true));
		
		if(interestType != null) {
			if(interestType.equals("Fixed")) {
				pricingInfo.addCell(DealPDFStyle.createFormFieldCell("Base fixed Rate", PDFReportHelper.formatDouble(rateInfo.getBaseFixedRate()), false));
				pricingInfo.addCell(DealPDFStyle.createEmptyFormFieldCell(false));
			} else if(interestType.equals("Float")) {
				String floatingRateIndex = (rateInfo.getInterestTypeId() != null && rateInfo.getInterestTypeId().equals(2)) ? rateInfo.getFloatingRateIndex() : null;
				String floatingRateIndexTerm = (rateInfo.getInterestTypeId() != null && rateInfo.getInterestTypeId().equals(2)) ? rateInfo.getFloatingRateIndexTerm() : null;
				pricingInfo.addCell(DealPDFStyle.createFormFieldCell("Floating Rate Index", floatingRateIndex, false));
				pricingInfo.addCell(DealPDFStyle.createFormFieldCell("Index Term", floatingRateIndexTerm, false));
			}
			
			pricingInfo.addCell(DealPDFStyle.createFormFieldCell("Minimum Spread (bps)", PDFReportHelper.formatDouble(rateInfo.getMinSpread()), true));
			pricingInfo.addCell(DealPDFStyle.createFormFieldCell("Maximum Spread (bps)", PDFReportHelper.formatDouble(rateInfo.getMaxSpread()), true));
			
			TPLegRequest tpLegRequest = Utils.fetchPropertyValue(TPLEGREQUEST, leg, TPLegRequest.class);
			pricingInfo.addCell(DealPDFStyle.createFormFieldCell("Transfer Pricing Summary", (tpLegRequest != null) ? tpLegRequest.getTPSummary() : null, false));
			pricingInfo.addCell(DealPDFStyle.createFormFieldCell("Spread (bps)", PDFReportHelper.formatDouble(rateInfo.getSpread()), false));
		}
		
		section.add(pricingInfo);
		
		return (T)this;
	}
	
	/**
	 * Renders Solvency Matrics of the leg.
	 * 
	 * @return
	 * @throws DocumentException 
	 * @throws ICFPException 
	 * @throws HWFStubException 
	 * @throws HWFServiceException 
	 */
	@SuppressWarnings("unchecked")
	public T appendSolvencyMetricsInfo() throws DocumentException, ICFPException, HWFServiceException, HWFStubException {
		Section section = DealPDFStyle.createSubSection("Solvency Metrics", getReportContext().getCurrentSection());
		PdfPTable solvencySummary = DealPDFStyle.createTable(15f, 10f, 10f, 15f, 15f, 10f, 10f, 15f);
		
		// Create first level column headers
		solvencySummary.addCell(DealPDFStyle.createTableHeaderCell("Solvency Metrics"));
		solvencySummary.addCell(DealPDFStyle.createTableHeaderCell("Pre Transaction"));
		solvencySummary.addCell(DealPDFStyle.createTableHeaderCell("Post Transaction"));
		solvencySummary.addCell(DealPDFStyle.createTableHeaderCell("Fund Co/Hold Co/Op Co Thresholds", 3));
		solvencySummary.addCell(DealPDFStyle.createTableHeaderCell("Assessment"));
		solvencySummary.addCell(DealPDFStyle.createTableHeaderCell("Rationale - required only if threshold breached"));
		
		// Create second level column headers
		solvencySummary.addCell(DealPDFStyle.createTableHeaderCell(""));
		solvencySummary.addCell(DealPDFStyle.createTableHeaderCell(""));
		solvencySummary.addCell(DealPDFStyle.createTableHeaderCell(""));
		solvencySummary.addCell(DealPDFStyle.createTableHeaderCell("Pass"));
		solvencySummary.addCell(DealPDFStyle.createTableHeaderCell("Conditional Pass"));
		solvencySummary.addCell(DealPDFStyle.createTableHeaderCell("Weak Performer"));
		solvencySummary.addCell(DealPDFStyle.createTableHeaderCell(""));
		solvencySummary.addCell(DealPDFStyle.createTableHeaderCell(""));
		
		TPLegRequest tpLegRequest = Utils.fetchPropertyValue(TPLEGREQUEST, leg, TPLegRequest.class);
		if(tpLegRequest != null && !tpLegRequest.getSolvencyMetrics().isEmpty()) {
			List<SolvencyMetrics> solvencyMetricsList = tpLegRequest.getSolvencyMetrics();
			
			List<SolvencyMetricsCalc> solvencyMetricsCalcList = getStaticDataFactory().getSolvencyMatrixValues();
			// Create Map of SolvencyMetricsCalc object with Type ID as key
			Map<String, SolvencyMetricsCalc> typeIdToSolvMetricCalcMap = new HashMap<String, SolvencyMetricsCalc>();
			for(SolvencyMetricsCalc solvencyMetricsCalc : solvencyMetricsCalcList) {
				typeIdToSolvMetricCalcMap.put(solvencyMetricsCalc.getSolvencyMetricsTypeId(), solvencyMetricsCalc);
			}
			
			SolvencyMetricsCalc solvencyMetricsCalc = null;
			int solvencyCounter = 1;
			for(SolvencyMetrics solvencyMetrics : solvencyMetricsList) {
				solvencySummary.addCell(DealPDFStyle.createTableDataCell(solvencyMetrics.getSolvencyMetric()));
				
				if(solvencyCounter == 7) {
					solvencySummary.addCell(DealPDFStyle.createTableEmptyDataCell());
					solvencySummary.addCell(DealPDFStyle.createTableEmptyDataCell());
				} else {
					String strPreTransactionValue = solvencyMetrics.getPreTransaction();
					Double preTransactionValue = (StringUtils.isNotBlank(strPreTransactionValue)) ? new Double(strPreTransactionValue) : null;
					solvencySummary.addCell(DealPDFStyle.createTableDataCell(PDFReportHelper.formatCurrency(preTransactionValue)));
					String strPostTransactionValue = solvencyMetrics.getPostTransaction();
					Double postTransactionValue = (StringUtils.isNotBlank(strPostTransactionValue)) ? new Double(strPostTransactionValue) : null;
					solvencySummary.addCell(DealPDFStyle.createTableDataCell(PDFReportHelper.formatCurrency(postTransactionValue)));
				} 
				
				solvencyMetricsCalc = typeIdToSolvMetricCalcMap.get(String.valueOf(solvencyMetrics.getSolvencyMetricId()));
				if(solvencyCounter == 7) {
					solvencySummary.addCell(DealPDFStyle.createTableEmptyDataCell());
					solvencySummary.addCell(DealPDFStyle.createTableEmptyDataCell());
					solvencySummary.addCell(DealPDFStyle.createTableEmptyDataCell());
				} else if(solvencyMetricsCalc != null) {
					PdfPCell passCell = DealPDFStyle.createTableDataCell(solvencyMetricsCalc.getPass());
					solvencySummary.addCell(passCell);
					PdfPCell condPassCell = DealPDFStyle.createTableDataCell(solvencyMetricsCalc.getConditionalPass());
					solvencySummary.addCell(condPassCell);
					PdfPCell weekPerfCell = DealPDFStyle.createTableDataCell(solvencyMetricsCalc.getWeakPerformer());
					solvencySummary.addCell(weekPerfCell);
				} else {
					solvencySummary.addCell(DealPDFStyle.createTableDataCell(null));
					solvencySummary.addCell(DealPDFStyle.createTableDataCell(null));
					solvencySummary.addCell(DealPDFStyle.createTableDataCell(null));
				}
				
				BaseColor assesmentColor = null;
				PdfPCell assesmentCell = null;
				if(solvencyCounter  == 7 && solvencyMetrics.isAssessmentFlag() != null) {
					if(solvencyMetrics.isAssessmentFlag()) {
						assesmentCell = DealPDFStyle.createTableDataCell(YES_CAP);
						assesmentColor = BaseColor.RED;
					} else {
						assesmentCell = DealPDFStyle.createTableDataCell(NO_CAP);
						assesmentColor = BaseColor.GREEN;
					}
				} else {
					assesmentCell = DealPDFStyle.createTableEmptyDataCell();
				}
				
				if(solvencyCounter != 7 && solvencyMetrics.getPostTransaction() != null && solvencyMetricsCalc != null) {
					assesmentColor = PDFReportHelper.computeSolvencyColor(solvencyMetrics.getPostTransaction(), solvencyMetricsCalc);
				}
				
				if(assesmentColor != null) {
					assesmentCell.setBackgroundColor(assesmentColor);
				}
				solvencySummary.addCell(assesmentCell);
				solvencySummary.addCell(DealPDFStyle.createTableDataCell(solvencyMetrics.getComment()));
				solvencyCounter++;
			}
		}
		section.add(solvencySummary);
		
		if(tpLegRequest != null && !tpLegRequest.getSolvencyMetrics().isEmpty()) {
			section.add(new Paragraph(new Chunk("*If the total transaction amount is <25% of the pre-transaction total assets, pro-forma ratios may not be performed.", DealPDFStyle.FONT_ITALIC)));
		}
		return (T)this;
	}
	
	/**
	 * Renders Equity Details section for Equity leg.
	 * 
	 * @return
	 * @throws ICFPException 
	 */
	@SuppressWarnings("unchecked")
	public T appendEquityDetails() throws ICFPException {
		Section section = DealPDFStyle.createSubSection("Equity Details", getReportContext().getCurrentSection());
		PdfPTable sharesInfoTable = null;
		EquityLegRequest leg = (EquityLegRequest) getLeg();
		LegSummary legSummary = leg.getLegSummary();
		if(leg.getEquityFormId() != null) {
			if(leg.getEquityFormId() != 4) {
				sharesInfoTable = DealPDFStyle.createTable(40f, 30f, 30f);
			} else {
				sharesInfoTable = DealPDFStyle.createTable(25f, 25f, 25f, 25f);
				sharesInfoTable.addCell(DealPDFStyle.createTableHeaderCell("Debt terms"));
			}
			sharesInfoTable.addCell(DealPDFStyle.createTableHeaderCell("Share type"));
			sharesInfoTable.addCell(DealPDFStyle.createTableHeaderCell("Number of shares"));
			sharesInfoTable.addCell(DealPDFStyle.createTableHeaderCell("Par value per share"));
			List<ShareInfo> shareInfos = leg.getShareInfos();
			for(ShareInfo eachShare : shareInfos) {
				if(leg.getEquityFormId() == 4) {
					sharesInfoTable.addCell(DealPDFStyle.createTableDataCell(eachShare.getDebtTerms()));
				}
				sharesInfoTable.addCell(DealPDFStyle.createTableDataCell(eachShare.getShareType()));
				sharesInfoTable.addCell(DealPDFStyle.createTableDataCell((eachShare.getNumberOfShares()) != null ? String.valueOf(eachShare.getNumberOfShares()) : null));
				sharesInfoTable.addCell(DealPDFStyle.createTableDataCell(PDFReportHelper.formatDouble(eachShare.getShareValue())));
			}
			section.add(sharesInfoTable);
		}
		
		PdfPTable descriptionTable = DealPDFStyle.createFormTable(1);
		String termsInMonths = (legSummary.getTermInMonths() != null) ? String.valueOf(legSummary.getTermInMonths()) : null;
		descriptionTable.addCell(DealPDFStyle.createFormFieldCell(LegBuilder.TERM_IN_MONTHS, termsInMonths, true));
		descriptionTable.addCell(DealPDFStyle.createFormFieldCell(DESCRIPTION, leg.getOtherEquityComments(), false));
		section.add(descriptionTable);
		
		PdfPTable equityDetailsTable = DealPDFStyle.createFormTable(2);
		equityDetailsTable.addCell(DealPDFStyle.createFormFieldCell(SUBORDINATED_DEBT, PDFReportHelper.convertBooleanAsYesOrNo(legSummary.isSubordinatedDebt()), true));
		equityDetailsTable.addCell(DealPDFStyle.createFormFieldCell(DEAL_CURRENCY, legSummary.getOriginalCCY(), true));
		equityDetailsTable.addCell(DealPDFStyle.createFormFieldCell("Are there Derivatives?", PDFReportHelper.convertBooleanAsYesOrNo(PDFReportHelper.hasDerivatives(leg)), false));
		equityDetailsTable.addCell(DealPDFStyle.createFormFieldCell(AMOUNT, PDFReportHelper.formatCurrency(legSummary.getOriginalCCYAmount()), false));
		equityDetailsTable.addCell(DealPDFStyle.createFormFieldCell(CROSS_BORDER, PDFReportHelper.convertBooleanAsYesOrNo(leg.isCrossBorderFlag()), true));
		equityDetailsTable.addCell(DealPDFStyle.createFormFieldCell("USD equivalent", PDFReportHelper.formatCurrency(legSummary.getUSDEquivalent()), true));
		
		equityDetailsTable.addCell(DealPDFStyle.createEmptyFormFieldCell(false));
		equityDetailsTable.addCell(DealPDFStyle.createFormFieldCell("Double Leverage", PDFReportHelper.convertBooleanAsYesOrNo(leg.isDoubleLeverageFlag()), false));
		
		equityDetailsTable.addCell(DealPDFStyle.createFormFieldCell(NON_STANDARD_LEGAL_AGREEMENT, PDFReportHelper.convertBooleanAsYesOrNo(legSummary.isNonStandardAgreementsFlag()), true));
		equityDetailsTable.addCell(DealPDFStyle.createFormFieldCell("eBoardroom eligible", PDFReportHelper.convertBooleanAsYesOrNo(leg.isEBoardApprovalRequiredFlag()), true));
		section.add(equityDetailsTable);
		return (T) this;
	}
	
	/**
	 * Renders Product details of the leg.
	 * 
	 * @return
	 * @throws ICFPException 
	 */
	@SuppressWarnings("unchecked")
	public T appendProductDetails() throws ICFPException {
		Section section = DealPDFStyle.createSubSection("Product Details", getReportContext().getCurrentSection());
		PdfPTable productDetailsTable = DealPDFStyle.createFormTable(2);
		LegSummary legSummary = (LegSummary) getLegSummary();
		ProductType productType = getProductType();
		productDetailsTable.addCell(DealPDFStyle.createFormFieldCell(LegBuilder.PRODUCT_TYPE, legSummary.getProductType(), true));
		productDetailsTable.addCell(DealPDFStyle.createFormFieldCell(DEAL_CURRENCY, legSummary.getOriginalCCY(), true));
		
		productDetailsTable.addCell(DealPDFStyle.createFormFieldCell(LegBuilder.TERM_IN_MONTHS, (legSummary.getTermInMonths() != null) ? String.valueOf(legSummary.getTermInMonths()) : null, false));
		
		EventType eventType = ICFPDay2LegHelper.getEventType(getLeg());
		Double amount = null;
		/*if(eventType == EventType.DRAWDOWN) {
			DayTwoOperations dayTwoOperations = Utils.fetchPropertyValue(DAYTWOOPERATIONS, leg, DayTwoOperations.class);
			if(dayTwoOperations != null && dayTwoOperations.getDrawDown() != null) {
				amount = dayTwoOperations.getDrawDown().getDrawdownAmt();
			}
		} else*/
		if(eventType == EventType.AMENDMENT_FACILITY_INC_DEC) {
			DayTwoOperations dayTwoOperations = Utils.fetchPropertyValue(DAYTWOOPERATIONS, leg, DayTwoOperations.class);
			if(dayTwoOperations != null && dayTwoOperations.getFacilityIncreaseDecrease() != null) {
				amount = dayTwoOperations.getFacilityIncreaseDecrease().getFacilityIncDecAmt();
			}
		} else if(PDFReportHelper.isImmediateDrawdownLeg(leg)) {
			amount = Utils.fetchPropertyValue(IMMDTDRDOWNAMT, leg, Double.class);
		} else {
			amount = ((LegSummary) legSummary).getOriginalCCYAmount();
		}
		productDetailsTable.addCell(DealPDFStyle.createFormFieldCell(AMOUNT, PDFReportHelper.formatCurrency(amount), false));

		productDetailsTable.addCell(DealPDFStyle.createFormFieldCell(SUBORDINATED_DEBT, PDFReportHelper.convertBooleanAsYesOrNo(legSummary.isSubordinatedDebt()), true));
		
		Double usdEquivalent = null;
		if(eventType == EventType.AMENDMENT_FACILITY_INC_DEC) {
			DayTwoOperations dayTwoOperations = Utils.fetchPropertyValue(DAYTWOOPERATIONS, leg, DayTwoOperations.class);
			if(dayTwoOperations != null && dayTwoOperations.getFacilityIncreaseDecrease() != null) {
				usdEquivalent = dayTwoOperations.getFacilityIncreaseDecrease().getFacilityIncDecUSDEquivalentAmt();
			}
		} else {
			usdEquivalent = Utils.fetchPropertyValue(USDEQUIVALENT, legSummary, Double.class);
		}
		productDetailsTable.addCell(DealPDFStyle.createFormFieldCell("USD equivalent", PDFReportHelper.formatCurrency(usdEquivalent), true));
		
		productDetailsTable.addCell(DealPDFStyle.createFormFieldCell(CROSS_BORDER, PDFReportHelper.convertBooleanAsYesOrNo(ICFPLegHelper.getCrossBorderFlagValue(getLeg())), false));
		if(productType == ProductType.BOND) {
			productDetailsTable.addCell(DealPDFStyle.createFormFieldCell("Issue Price %", PDFReportHelper.formatDouble(legSummary.getIssuePrice()), false));
		} else {
			productDetailsTable.addCell(DealPDFStyle.createEmptyFormFieldCell(false));
		}
		
		productDetailsTable.addCell(DealPDFStyle.createFormFieldCell("Are there Derivatives?", PDFReportHelper.convertBooleanAsYesOrNo(PDFReportHelper.hasDerivatives(leg)), true));
		if(productType == ProductType.BOND) {
			productDetailsTable.addCell(DealPDFStyle.createFormFieldCell("Agent/Dealer Commission %", PDFReportHelper.formatDouble(legSummary.getAgentDealerCommission()), true));
		} else {
			productDetailsTable.addCell(DealPDFStyle.createEmptyFormFieldCell(true));
		}
		
		Boolean isImmediateDrawdownFlag = (leg instanceof RCALegRequest) ? ((RCALegRequest) leg).isImmdtDrdownApplicableFlag() : null;
		productDetailsTable.addCell(DealPDFStyle.createFormFieldCell("Immediate drawdown applicable", PDFReportHelper.convertBooleanAsYesOrNo(isImmediateDrawdownFlag), false));
		productDetailsTable.addCell(DealPDFStyle.createFormFieldCell(NON_STANDARD_LEGAL_AGREEMENT, PDFReportHelper.convertBooleanAsYesOrNo(legSummary.isNonStandardAgreementsFlag()), false));
		
		if(productType == ProductType.BOND) {
			productDetailsTable.addCell(DealPDFStyle.createFormFieldCell("Net Proceeds", PDFReportHelper.formatCurrency(legSummary.getNetProceedsAmt()), true));
			productDetailsTable.addCell(DealPDFStyle.createEmptyFormFieldCell(true));
		} 
		section.add(productDetailsTable);
		return (T) this;
	}
	
	/**
	 * Renders Product details for the Equity leg.
	 * 
	 * @return
	 * @throws ICFPException 
	 */
	@SuppressWarnings("unchecked")
	public T appendEquityProductDetails() throws ICFPException {
		Section section = DealPDFStyle.createSubSection("Product Details", getReportContext().getCurrentSection());
		PdfPTable productDetailsTable = DealPDFStyle.createFormTable(2);
		productDetailsTable.addCell(DealPDFStyle.createFormFieldCell(LegBuilder.PRODUCT_TYPE, Utils.fetchPropertyValue(PRODUCTTYPE, getLegSummary(), String.class), true));
		productDetailsTable.addCell(DealPDFStyle.createFormFieldCell("Form of Equity", ((EquityLegRequest) getLeg()).getEquityForm(), true));
		section.add(productDetailsTable);
		return (T) this;
	}
	
	/**
	 * Renders description for the Other leg.
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T appendOtherDescription() {
		OtherLegRequest leg = (OtherLegRequest) getLeg();
		Section section = DealPDFStyle.createSubSection(DESCRIPTION, getReportContext().getCurrentSection());
		String descriptionStr = (StringUtils.isNotBlank(leg.getDescription())) ? leg.getDescription() : "-";
		Paragraph description = new Paragraph(new Chunk(descriptionStr, DealPDFStyle.FONT_ITALIC));
		section.add(description);
		return (T) this;
	}
	
	/**
	 * Getter method for leg number.
	 * 
	 * @return
	 */
	public int getLegNumber() {
		return legNumber;
	}
	
	/**
	 * Getter method for leg.
	 * 
	 * @return
	 */
	public Object getLeg() {
		return leg;
	}
	
	/**
	 * Getter method for LegSummary.
	 * 
	 * @return
	 */
	public Object getLegSummary() {
		return ICFPLegHelper.getLegSummary(leg);
	}
	
	/**
	 * Returns true if current leg is Day2.
	 * 
	 * @return
	 * @throws ICFPException
	 */
	public boolean isDay2Leg() throws ICFPException {
		return ICFPDay2LegHelper.isDay2Leg(leg);
	}
	
	/**
	 * Returns {@link ProductType} of the leg.
	 * 
	 * @return
	 * @throws ICFPException 
	 */
	public ProductType getProductType() throws ICFPException {
		return ICFPLegHelper.getProductType(leg);
	}
	
	/**
	 * Returns true if the current leg is CPA leg.
	 * 
	 * @return
	 */
	public boolean isCPALeg() {
		return (leg instanceof CPALegRequest);
	}
	
	/**
	 * Returns true if the current leg is Equity.
	 * 
	 * @return
	 */
	public boolean isEquityLeg() {
		return (leg instanceof EquityLegRequest);
	}
}
