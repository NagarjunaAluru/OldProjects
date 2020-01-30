/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: Day2LegBuilder.java
 * Purpose: This class renders the Day2 leg.
 */
package com.ge.icfp.util.report.pdf.builder;

import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.lang.StringUtils;

import com.ge.icfp.action.ICFPException;
import com.ge.icfp.common.helper.EntityHelper;
import com.ge.icfp.common.helper.EntityHelper.EntityType;
import com.ge.icfp.common.helper.ICFPDay2LegHelper;
import com.ge.icfp.model.AgreementExtension;
import com.ge.icfp.model.Amendment;
import com.ge.icfp.model.Attachment;
import com.ge.icfp.model.CPASummary;
import com.ge.icfp.model.CPATermination;
import com.ge.icfp.model.Correction;
import com.ge.icfp.model.DayTwoOperations;
import com.ge.icfp.model.DrawDown;
import com.ge.icfp.model.Entity;
import com.ge.icfp.model.FacilityIncreaseDecrease;
import com.ge.icfp.model.LegSummary;
import com.ge.icfp.model.Termination;
import com.ge.icfp.util.EventType;
import com.ge.icfp.util.Utils;
import com.ge.icfp.util.report.pdf.DealPDFStyle;
import com.ge.icfp.util.report.pdf.PDFReportHelper;
import com.ge.icfp.util.report.pdf.ReportContext;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPTable;
import static com.ge.icfp.common.constants.ICFPConstants.*;
/**
 * This class provides Day2 specified functionality rendering.
 * 
 * @author chaitanya
 */
public class Day2LegBuilder extends LegBuilder<Day2LegBuilder> {

	private static final String TERMINATION_NOTICE_ATTACHED = "Termination Notice Attached";
	private static final String ACCRUED_INTEREST_AMOUNT = "Accrued Interest Amount";
	private static final String REQUEST_DERIVATIVES = "Request Derivatives";
	private static final String ORIGINAL_LEGAL_AGREEMENT_ATTACHED = "Original Legal Agreement Attached";
	private static final String MATURITY_DT = "maturityDt";
	private static final String PRINCIPAL_FACILITY_AMOUNT = "Principal/Facility amount";
	private static final String IS_LENDER_PROVIDER_A_REGULATED_ENTITY = "Is Lender/Provider a Regulated Entity";
	private static final String ORIGINAL_TRANSACTION_DETAILS = "Original Transaction Details";

	/**
	 * Constructor to create instance of this class.
	 * 
	 * @param context
	 * @param legNumber
	 * @param leg
	 */
	public Day2LegBuilder(ReportContext context, int legNumber, Object leg) {
		super(context, legNumber, leg);
	}
	
	/**
	 * Returns the {@link EventType} of the leg.
	 * 
	 * @return
	 * @throws ICFPException
	 */
	public EventType getEventType() throws ICFPException {
		return ICFPDay2LegHelper.getEventType(leg);
	}
	
	/**
	 * Returns {@link DayTwoOperations} of the leg.
	 * 
	 * @return
	 * @throws ICFPException
	 */
	public DayTwoOperations getDayTwoOperations() throws ICFPException {
		return  Utils.fetchPropertyValue(DAYTWOOPERATIONS, getLeg(), DayTwoOperations.class);
	}
	
	/**
	 * Renders the Original Transaction details of the leg.
	 * 
	 * @return
	 * @throws DocumentException 
	 * @throws ICFPException 
	 */
	public Day2LegBuilder appendOriginalTransactionDetails() throws DocumentException, ICFPException {
		Section section = DealPDFStyle.createSubSection(Day2LegBuilder.ORIGINAL_TRANSACTION_DETAILS, getReportContext().getCurrentSection());
		LegSummary legSummary = (LegSummary)getLegSummary();
		
		PdfPTable orgTransDetails = DealPDFStyle.createFormTable(2);
		orgTransDetails.addCell(DealPDFStyle.createFormFieldCell(PRODUCT_TYPE, legSummary.getProductType(), true));
		String tradeID = (getEventType() == EventType.AMENDMENT_FACILITY_INC_DEC) ? "Facility ID" : "Trade ID/Loan Model ID";
		orgTransDetails.addCell(DealPDFStyle.createFormFieldCell(tradeID, legSummary.getTransactionId(), true));
		Integer termsInMonths = legSummary.getTermInMonths();
		orgTransDetails.addCell(DealPDFStyle.createFormFieldCell("Term(in months)", ((termsInMonths != null) ? String.valueOf(termsInMonths) : null), false));
		orgTransDetails.addCell(DealPDFStyle.createFormFieldCell("Is transaction hedged", PDFReportHelper.convertZeroOrOneToNoOrYes(legSummary.getIsHedgedFlag()), false));
		orgTransDetails.addCell(DealPDFStyle.createFormFieldCell("Non-Standard Legal Agreement(s)", PDFReportHelper.convertZeroOrOneToNoOrYes(legSummary.getOriginalLegalAgreementsFlag()), true));
		
		EventType eventType = getEventType();
		if(eventType == EventType.CORRECTION || eventType == EventType.GENERAL_AMENDMENT) {
			orgTransDetails.addCell(DealPDFStyle.createFormFieldCell(CURRENCY_CAP, legSummary.getOriginalCCY(), true));
			orgTransDetails.addCell(DealPDFStyle.createFormFieldCell(Day2LegBuilder.PRINCIPAL_FACILITY_AMOUNT, PDFReportHelper.formatCurrency(legSummary.getOriginalCCYAmount()), false));
			orgTransDetails.addCell(DealPDFStyle.createFormFieldCell(USD_EQUIVALENT, PDFReportHelper.formatCurrency(legSummary.getUSDEquivalent()), false));
		}else {
			orgTransDetails.addCell(DealPDFStyle.createFormFieldCell(CURRENCY_CAP, legSummary.getDayOneCCY(), true));
			orgTransDetails.addCell(DealPDFStyle.createFormFieldCell(Day2LegBuilder.PRINCIPAL_FACILITY_AMOUNT, PDFReportHelper.formatCurrency(legSummary.getDayOneCCYAmount()), false));
			orgTransDetails.addCell(DealPDFStyle.createFormFieldCell(USD_EQUIVALENT, PDFReportHelper.formatCurrency(legSummary.getDayOneUSDEquivalent()), false));
		}
	
		section.add(orgTransDetails);
		return this;
	}
	
	
	/**
	 * Renders the Original Transaction Details for the CPA leg.
	 * 
	 * @return
	 * @throws DocumentException 
	 * @throws ICFPException 
	 */
	public Day2LegBuilder appendCPAOriginalTransactionDetails() throws DocumentException, ICFPException {
		Section section = DealPDFStyle.createSubSection(Day2LegBuilder.ORIGINAL_TRANSACTION_DETAILS, getReportContext().getCurrentSection());
		PdfPTable orgTransDetails = DealPDFStyle.createFormTable(2);
		CPASummary legSummary = (CPASummary) getLegSummary();
		orgTransDetails.addCell(DealPDFStyle.createFormFieldCell(PRODUCT_TYPE, legSummary.getProductType(), true));
		orgTransDetails.addCell(DealPDFStyle.createFormFieldCell("Valut Request ID", getReportContext().getDeal().getVaultId(), true));
		section.add(orgTransDetails);
		return this;
	}
	
	/**
	 * Renders the Assignment Lender Information.
	 * 
	 * @return
	 * @throws DocumentException 
	 * @throws ICFPException 
	 */
	public Day2LegBuilder appendAssignmentLenderInformation() throws DocumentException, ICFPException {
		Object legSummary = getLegSummary();
		Entity entity = EntityHelper.searchEntity(legSummary, EntityType.NEW_LENDER);
		if(entity != null && StringUtils.isNotBlank(entity.getMEName())) {
			Section section = DealPDFStyle.createSubSection("New Lender/Provider", getReportContext().getCurrentSection());
			PdfPTable entityInfo = DealPDFStyle.createFormTable(2);
			
			entityInfo.addCell(DealPDFStyle.createEmptyFormFieldCell(false));
			String isLegalEntity = (entity != null) ? PDFReportHelper.convertYOrNToYesOrNo(entity.getEntitySetupFlag()) : null;
			entityInfo.addCell(DealPDFStyle.createFormFieldCell(LEGAL_ENTITY_SETUP_PENDING,isLegalEntity, false));
			
			entityInfo.addCell(DealPDFStyle.createFormFieldCell(CDR_CODE, ((entity != null) ? entity.getCDRCd() : null), true));
			entityInfo.addCell(DealPDFStyle.createFormFieldCell(LEGAL_ENTITY_GOLD_ID, ((entity != null) ? entity.getLEGoldId() : null), true));
			
			entityInfo.addCell(DealPDFStyle.createFormFieldCell(LEGAL_ENTITY_NAME, ((entity != null) ? entity.getLEName() : null), false));
			entityInfo.addCell(DealPDFStyle.createFormFieldCell(COUNTRY_BIG, ((entity != null) ? entity.getCountry() : null), false));
			
			String isRequlatedEntity = (entity != null) ? PDFReportHelper.convertBooleanAsYesOrNo(entity.isRegulatedEntityFlag()) : null;
			entityInfo.addCell(DealPDFStyle.createFormFieldCell(Day2LegBuilder.IS_LENDER_PROVIDER_A_REGULATED_ENTITY, isRequlatedEntity, true));		
			String isPrincipalEntity = (entity != null) ? PDFReportHelper.convertBooleanAsYesOrNo(entity.isPrincplEntityFlag()) : null;
			entityInfo.addCell(DealPDFStyle.createFormFieldCell("Is Lender/Provider a Principal Entity", isPrincipalEntity, true));
			
			entityInfo.addCell(DealPDFStyle.createFormFieldCell(MANAGEMENT_ENTITY, ((entity != null) ? entity.getMEName() : null), false));
			entityInfo.addCell(DealPDFStyle.createFormFieldCell(CAPITAL_OR_INDUSTRIAL, ((entity != null) ? entity.getCapitalIndustrial() : null), false));
			
			String treasuryCode = (!entity.getTreasuryCodes().isEmpty()) ? entity.getTreasuryCodes().get(0) : null;
			entityInfo.addCell(DealPDFStyle.createFormFieldCell(TREASURY_CODE, treasuryCode, true));
			entityInfo.addCell(DealPDFStyle.createFormFieldCell(BUSINESS_SEGMENT, ((entity != null) ? entity.getBusinessSegment() : null), true));
			
			entityInfo.addCell(DealPDFStyle.createEmptyFormFieldCell(false));
			entityInfo.addCell(DealPDFStyle.createFormFieldCell(FUNDING_COMPANY_HOLDING, ((entity != null) ? entity.getFundHoldOperation() : null), false));
			
			section.add(entityInfo);
		}
		return this;
	}
	
	
	/**
	 * Renders the Assignemnt Borrower information of the leg.
	 * 
	 * @return
	 * @throws DocumentException 
	 * @throws ICFPException 
	 */
	public Day2LegBuilder appendAssignmentBorrowerInformation() throws DocumentException, ICFPException {
		Object legSummary = getLegSummary();
		Entity entity = EntityHelper.searchEntity(legSummary, EntityType.NEW_BORROWER);
		if(entity != null && StringUtils.isNotBlank(entity.getMEName())) {
			Section section = DealPDFStyle.createSubSection("New Borrower/Recipient", getReportContext().getCurrentSection());
			PdfPTable entityInfo = DealPDFStyle.createFormTable(2);
			
			entityInfo.addCell(DealPDFStyle.createEmptyFormFieldCell(false));
			String isLegalEntity = (entity != null) ? PDFReportHelper.convertYOrNToYesOrNo(entity.getEntitySetupFlag()) : null;
			entityInfo.addCell(DealPDFStyle.createFormFieldCell(LEGAL_ENTITY_SETUP_PENDING,isLegalEntity, false));
			
			entityInfo.addCell(DealPDFStyle.createFormFieldCell(CDR_CODE, ((entity != null) ? entity.getCDRCd() : null), true));
			entityInfo.addCell(DealPDFStyle.createFormFieldCell(LEGAL_ENTITY_GOLD_ID, ((entity != null) ? entity.getLEGoldId() : null), true));
			
			entityInfo.addCell(DealPDFStyle.createFormFieldCell(LEGAL_ENTITY_NAME, ((entity != null) ? entity.getLEName() : null), false));
			entityInfo.addCell(DealPDFStyle.createFormFieldCell(COUNTRY_BIG, ((entity != null) ? entity.getCountry() : null), false));
			
			String isRequlatedEntity = (entity != null) ? PDFReportHelper.convertBooleanAsYesOrNo(entity.isRegulatedEntityFlag()) : null;
			entityInfo.addCell(DealPDFStyle.createFormFieldCell("Is Borrower/Recipient a Regulated Entity", isRequlatedEntity, true));		
			String isPrincipalEntity = (entity != null) ? PDFReportHelper.convertBooleanAsYesOrNo(entity.isPrincplEntityFlag()) : null;
			entityInfo.addCell(DealPDFStyle.createFormFieldCell("Is Borrower/Recipient a Principal Entity", isPrincipalEntity, true));
			
			entityInfo.addCell(DealPDFStyle.createFormFieldCell(MANAGEMENT_ENTITY, ((entity != null) ? entity.getMEName() : null), false));
			entityInfo.addCell(DealPDFStyle.createFormFieldCell(CAPITAL_OR_INDUSTRIAL, ((entity != null) ? entity.getCapitalIndustrial() : null), false));
			
			String treasuryCode = (!entity.getTreasuryCodes().isEmpty()) ? entity.getTreasuryCodes().get(0) : null;
			entityInfo.addCell(DealPDFStyle.createFormFieldCell(TREASURY_CODE, treasuryCode, true));
			entityInfo.addCell(DealPDFStyle.createFormFieldCell(BUSINESS_SEGMENT, ((entity != null) ? entity.getBusinessSegment() : null), true));
			
			entityInfo.addCell(DealPDFStyle.createEmptyFormFieldCell(false));
			entityInfo.addCell(DealPDFStyle.createFormFieldCell(FUNDING_COMPANY_HOLDING, ((entity != null) ? entity.getFundHoldOperation() : null), false));
			
			section.add(entityInfo);
		}
		return this;
	}
	
	/**
	 * Renders the Payer information of the leg.
	 * 
	 * @return
	 * @throws DocumentException
	 * @throws ICFPException
	 */
	public Day2LegBuilder appendPayerInformation() throws DocumentException, ICFPException {
		Object legSummary = getLegSummary();
		Section section = DealPDFStyle.createSubSection("Payer", getReportContext().getCurrentSection());
		PdfPTable entityInfo = DealPDFStyle.createFormTable(2);
		
		Entity entity = EntityHelper.searchEntity(legSummary, EntityType.ORIGINAL_BORROWER); 
		
		entityInfo.addCell(DealPDFStyle.createEmptyFormFieldCell(false));
		String isLegalEntity = (entity != null) ? PDFReportHelper.convertYOrNToYesOrNo(entity.getEntitySetupFlag()) : null;
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(LEGAL_ENTITY_SETUP_PENDING,isLegalEntity, false));
		
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(CDR_CODE, ((entity != null) ? entity.getCDRCd() : null), true));
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(LEGAL_ENTITY_GOLD_ID, ((entity != null) ? entity.getLEGoldId() : null), true));
		
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(LEGAL_ENTITY_NAME, ((entity != null) ? entity.getLEName() : null), false));
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(COUNTRY_BIG, ((entity != null) ? entity.getCountry() : null), false));
		
		String isRequlatedEntity = (entity != null) ? PDFReportHelper.convertBooleanAsYesOrNo(entity.isRegulatedEntityFlag()) : null;
		entityInfo.addCell(DealPDFStyle.createFormFieldCell("Is Payer a Regulated Entity", isRequlatedEntity, true));		
		String isPrincipalEntity = (entity != null) ? PDFReportHelper.convertBooleanAsYesOrNo(entity.isPrincplEntityFlag()) : null;
		entityInfo.addCell(DealPDFStyle.createFormFieldCell("Is Payer a Principal Entity", isPrincipalEntity, true));
		
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(MANAGEMENT_ENTITY, ((entity != null) ? entity.getMEName() : null), false));
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(CAPITAL_OR_INDUSTRIAL, ((entity != null) ? entity.getCapitalIndustrial() : null), false));
		
		String treasuryCode = (entity != null && !entity.getTreasuryCodes().isEmpty()) ? entity.getTreasuryCodes().get(0) : null;
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(TREASURY_CODE, treasuryCode, true));
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(BUSINESS_SEGMENT, ((entity != null) ? entity.getBusinessSegment() : null), true));
		
		entityInfo.addCell(DealPDFStyle.createEmptyFormFieldCell(false));
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(FUNDING_COMPANY_HOLDING, ((entity != null) ? entity.getFundHoldOperation() : null), false));
		
		section.add(entityInfo);
		return this;
	}
	
	/**
	 * Renders the Receiver information of the leg.
	 * 
	 * @return
	 * @throws DocumentException
	 * @throws ICFPException
	 */
	public Day2LegBuilder appendReceiverInformation() throws DocumentException, ICFPException {
		Object legSummary = getLegSummary();
		Section section = DealPDFStyle.createSubSection("Receiver", getReportContext().getCurrentSection());
		PdfPTable entityInfo = DealPDFStyle.createFormTable(2);
		
		Entity entity = EntityHelper.searchEntity(legSummary, EntityType.ORIGINAL_LENDER); 
		
		entityInfo.addCell(DealPDFStyle.createEmptyFormFieldCell(false));
		String isLegalEntity = (entity != null) ? PDFReportHelper.convertYOrNToYesOrNo(entity.getEntitySetupFlag()) : null;
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(LEGAL_ENTITY_SETUP_PENDING,isLegalEntity, false));
		
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(CDR_CODE, ((entity != null) ? entity.getCDRCd() : null), true));
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(LEGAL_ENTITY_GOLD_ID, ((entity != null) ? entity.getLEGoldId() : null), true));
		
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(LEGAL_ENTITY_NAME, ((entity != null) ? entity.getLEName() : null), false));
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(COUNTRY_BIG, ((entity != null) ? entity.getCountry() : null), false));
		
		String isRequlatedEntity = (entity != null) ? PDFReportHelper.convertBooleanAsYesOrNo(entity.isRegulatedEntityFlag()) : null;
		entityInfo.addCell(DealPDFStyle.createFormFieldCell("Is Receiver a Regulated Entity", isRequlatedEntity, true));		
		String isPrincipalEntity = (entity != null) ? PDFReportHelper.convertBooleanAsYesOrNo(entity.isPrincplEntityFlag()) : null;
		entityInfo.addCell(DealPDFStyle.createFormFieldCell("Is Receiver a Principal Entity", isPrincipalEntity, true));
		
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(MANAGEMENT_ENTITY, ((entity != null) ? entity.getMEName() : null), false));
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(CAPITAL_OR_INDUSTRIAL, ((entity != null) ? entity.getCapitalIndustrial() : null), false));
		
		String treasuryCode = (entity != null && !entity.getTreasuryCodes().isEmpty()) ? entity.getTreasuryCodes().get(0) : null;
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(TREASURY_CODE, treasuryCode, true));
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(BUSINESS_SEGMENT, ((entity != null) ? entity.getBusinessSegment() : null), true));
		
		entityInfo.addCell(DealPDFStyle.createEmptyFormFieldCell(false));
		entityInfo.addCell(DealPDFStyle.createFormFieldCell(FUNDING_COMPANY_HOLDING, ((entity != null) ? entity.getFundHoldOperation() : null), false));
		
		section.add(entityInfo);
		return this;
	}
	
	/**
	 * Renders teh Agreement Extension of the leg.
	 * 
	 * @return
	 * @throws DocumentException 
	 * @throws ICFPException 
	 */
	public Day2LegBuilder appendAgreementExtension() throws DocumentException, ICFPException {
		Section section = DealPDFStyle.createSubSection("Amendment: Agreement Extension Details", getReportContext().getCurrentSection());
		PdfPTable agreementExtensionInfo = DealPDFStyle.createFormTable(2);
		LegSummary legSummary = (LegSummary)getLegSummary();
		DayTwoOperations dayTwoOperations = getDayTwoOperations();
		AgreementExtension agreementExtension = (dayTwoOperations != null) ? dayTwoOperations.getAgreementExtension() : null;
		XMLGregorianCalendar amendmentMaturityDt = (agreementExtension != null) ? agreementExtension.getAmendmentMaturityDt() : null;
		agreementExtensionInfo.addCell(DealPDFStyle.createFormFieldCell("Amended Maturity Date", PDFReportHelper.formatDate(amendmentMaturityDt), true));
		agreementExtensionInfo.addCell(DealPDFStyle.createFormFieldCell(DEAL_CURRENCY, legSummary.getOriginalCCY(), true));
		XMLGregorianCalendar maturityDt = Utils.fetchPropertyValue(Day2LegBuilder.MATURITY_DT, legSummary, XMLGregorianCalendar.class);
		agreementExtensionInfo.addCell(DealPDFStyle.createFormFieldCell("Original Maturity Date", PDFReportHelper.formatDate(maturityDt), false));
		agreementExtensionInfo.addCell(DealPDFStyle.createFormFieldCell("Facility Amount", PDFReportHelper.formatCurrency(legSummary.getOriginalCCYAmount()), false));
		agreementExtensionInfo.addCell(DealPDFStyle.createFormFieldCell(Day2LegBuilder.ORIGINAL_LEGAL_AGREEMENT_ATTACHED, PDFReportHelper.convertBooleanAsYesOrNo(legSummary.isEventNoticeAttachedFlag()), true));
		agreementExtensionInfo.addCell(DealPDFStyle.createFormFieldCell(USD_EQUIVALENT, PDFReportHelper.formatCurrency(legSummary.getUSDEquivalent()), true));
		agreementExtensionInfo.addCell(DealPDFStyle.createFormFieldCell(Day2LegBuilder.REQUEST_DERIVATIVES, PDFReportHelper.convertBooleanAsYesOrNo(PDFReportHelper.hasDerivatives(leg)), false));
		agreementExtensionInfo.addCell(DealPDFStyle.createEmptyFormFieldCell(false));
	
		section.add(agreementExtensionInfo);
		return this;
	}
	
	/**
	 * Renders the Amendment Facility Increase or Decrease of the leg.
	 * 
	 * @return
	 * @throws DocumentException 
	 * @throws ICFPException 
	 */
	public Day2LegBuilder appendAmendFacilityIncDec() throws DocumentException, ICFPException {
		DayTwoOperations dayTwoOperations = getDayTwoOperations();
		FacilityIncreaseDecrease facilityIncDec = (dayTwoOperations != null) ? dayTwoOperations.getFacilityIncreaseDecrease() : null;
		if(facilityIncDec != null && facilityIncDec.getFacilityTypeId() != null) {
			String facilityType = (facilityIncDec.getFacilityTypeId().equals(1)) ? INCREASE : DECREASE;
			StringBuilder sectionTitle = new StringBuilder().append("Amendment: Facility ").append(facilityType).append(" Details");
			
			Section section = DealPDFStyle.createSubSection(sectionTitle.toString(), getReportContext().getCurrentSection());
			PdfPTable amendFacility = DealPDFStyle.createFormTable(2);
			
			LegSummary legSummary = (LegSummary) getLegSummary();
			amendFacility.addCell(DealPDFStyle.createFormFieldCell(CURRENCY_CAP, legSummary.getOriginalCCY(), true));
			StringBuilder headerTitle = new StringBuilder().append("Facility ").append(facilityType).append(" Amount");
			amendFacility.addCell(DealPDFStyle.createFormFieldCell(headerTitle.toString(), PDFReportHelper.formatCurrency(facilityIncDec.getFacilityIncDecAmt()), true));
			amendFacility.addCell(DealPDFStyle.createFormFieldCell("", "", false));
			amendFacility.addCell(DealPDFStyle.createFormFieldCell(USD_EQUIVALENT, PDFReportHelper.formatCurrency(facilityIncDec.getFacilityIncDecUSDEquivalentAmt()), false));
			amendFacility.addCell(DealPDFStyle.createFormFieldCell("Current Facility Amount", PDFReportHelper.formatCurrency(legSummary.getOriginalCCYAmount()), true));
			amendFacility.addCell(DealPDFStyle.createFormFieldCell("Amended Facility Amount", PDFReportHelper.formatCurrency(facilityIncDec.getAmendedFacilityAmt()), true));
			amendFacility.addCell(DealPDFStyle.createFormFieldCell(USD_EQUIVALENT, PDFReportHelper.formatCurrency(legSummary.getUSDEquivalent()), false));
			amendFacility.addCell(DealPDFStyle.createFormFieldCell(USD_EQUIVALENT, PDFReportHelper.formatCurrency(facilityIncDec.getAmendedUSDEquivalentAmt()), false));
			amendFacility.addCell(DealPDFStyle.createFormFieldCell(Day2LegBuilder.REQUEST_DERIVATIVES, PDFReportHelper.convertBooleanAsYesOrNo(PDFReportHelper.hasDerivatives(leg)), true));
			amendFacility.addCell(DealPDFStyle.createFormFieldCell(Day2LegBuilder.ORIGINAL_LEGAL_AGREEMENT_ATTACHED, PDFReportHelper.convertBooleanAsYesOrNo(legSummary.isEventNoticeAttachedFlag()), true));
			section.add(amendFacility);
		}
		return this;
	}
	
	
	/**
	 * Renders the Dividends of the leg.
	 * 
	 * @return
	 * @throws DocumentException 
	 */
	public Day2LegBuilder appendDividends() throws DocumentException {
		Section section = DealPDFStyle.createSubSection("Dividend Payment Details", getReportContext().getCurrentSection());
		PdfPTable dividendsTable = DealPDFStyle.createFormTable(2);
		LegSummary legSummary = (LegSummary) getLegSummary();
		dividendsTable.addCell(DealPDFStyle.createFormFieldCell(CURRENCY_CAP, legSummary.getOriginalCCY(), true));
		dividendsTable.addCell(DealPDFStyle.createFormFieldCell(AMOUNT, PDFReportHelper.formatCurrency(legSummary.getOriginalCCYAmount()), true));
		dividendsTable.addCell(DealPDFStyle.createEmptyFormFieldCell(false));
		dividendsTable.addCell(DealPDFStyle.createFormFieldCell(USD_EQUIVALENT, PDFReportHelper.formatCurrency(legSummary.getUSDEquivalent()), false));
		section.add(dividendsTable);
		return this;
	}
	
	
	/**
	 * Renders the DrawDown details of the leg.
	 * 
	 * @return
	 * @throws DocumentException 
	 * @throws ICFPException 
	 */
	public Day2LegBuilder appendDrawDownDetails() throws DocumentException, ICFPException {
		DayTwoOperations dayTwoOperations = getDayTwoOperations();
		DrawDown drawDown = (dayTwoOperations != null) ? dayTwoOperations.getDrawDown() : null;
		Section section = DealPDFStyle.createSubSection("DrawDown Details", getReportContext().getCurrentSection());
		PdfPTable drawdownTable = DealPDFStyle.createFormTable(2);
		LegSummary legSummary = (LegSummary) getLegSummary();
		drawdownTable.addCell(DealPDFStyle.createFormFieldCell("DrawDown Notice Attached", PDFReportHelper.convertBooleanAsYesOrNo(legSummary.isEventNoticeAttachedFlag()), true));
		drawdownTable.addCell(DealPDFStyle.createFormFieldCell(CURRENCY_CAP, legSummary.getOriginalCCY(), true));
		XMLGregorianCalendar draDownValueDt = (drawDown != null) ? drawDown.getDrawdownValueDt() : null;
		drawdownTable.addCell(DealPDFStyle.createFormFieldCell("DrawDown Value Date", PDFReportHelper.formatDate(draDownValueDt), false));
		drawdownTable.addCell(DealPDFStyle.createFormFieldCell("DrawDown Amount", PDFReportHelper.formatCurrency(legSummary.getOriginalCCYAmount()), false));
		drawdownTable.addCell(DealPDFStyle.createFormFieldCell("Request Derivative", PDFReportHelper.convertBooleanAsYesOrNo(PDFReportHelper.hasDerivatives(leg)), true));
		drawdownTable.addCell(DealPDFStyle.createFormFieldCell(USD_EQUIVALENT, PDFReportHelper.formatCurrency(legSummary.getUSDEquivalent()), true));
		section.add(drawdownTable);
		return this;
	}
	
	
	
	/**
	 * Renders the Prepayment information of the leg.
	 * 
	 * @return
	 * @throws DocumentException 
	 * @throws ICFPException 
	 */
	public Day2LegBuilder appendPrePayment() throws DocumentException, ICFPException {
		Section section = DealPDFStyle.createSubSection("Prepayment Details", getReportContext().getCurrentSection());
		PdfPTable prepaymentTable = DealPDFStyle.createFormTable(2);
		LegSummary legSummary = (LegSummary) getLegSummary();
		prepaymentTable.addCell(DealPDFStyle.createFormFieldCell("Fees", PDFReportHelper.formatNumber(legSummary.getFees()), true));
		prepaymentTable.addCell(DealPDFStyle.createFormFieldCell(CURRENCY_CAP, legSummary.getOriginalCCY(), true));
		prepaymentTable.addCell(DealPDFStyle.createFormFieldCell("Principal Prepayment Amount", PDFReportHelper.formatCurrency(legSummary.getOriginalCCYAmount()), false));
		prepaymentTable.addCell(DealPDFStyle.createFormFieldCell(Day2LegBuilder.ACCRUED_INTEREST_AMOUNT, PDFReportHelper.formatCurrency(legSummary.getAccruedInterestAmt()), false));
		prepaymentTable.addCell(DealPDFStyle.createEmptyFormFieldCell(true));
		prepaymentTable.addCell(DealPDFStyle.createFormFieldCell(USD_EQUIVALENT, PDFReportHelper.formatCurrency(legSummary.getUSDEquivalent()), true));
		prepaymentTable.addCell(DealPDFStyle.createFormFieldCell("Prepayment Notice Attached", PDFReportHelper.convertBooleanAsYesOrNo(legSummary.isEventNoticeAttachedFlag()), false));
		prepaymentTable.addCell(DealPDFStyle.createEmptyFormFieldCell(false));
		prepaymentTable.addCell(DealPDFStyle.createFormFieldCell(Day2LegBuilder.REQUEST_DERIVATIVES, PDFReportHelper.convertBooleanAsYesOrNo(PDFReportHelper.hasDerivatives(leg)), false));
		prepaymentTable.addCell(DealPDFStyle.createFormFieldCell("", "", false));
		section.add(prepaymentTable);
		return this;
	}
	
	/**
	 * Renders the Early Termination of the leg.
	 * 
	 * @return
	 * @throws DocumentException 
	 * @throws ICFPException 
	 */
	public Day2LegBuilder appendEarlyTermination() throws DocumentException, ICFPException {
		DayTwoOperations dayTwoOperations = getDayTwoOperations();
		Termination termination = (dayTwoOperations != null) ? dayTwoOperations.getTermination() : null;
		Section section = DealPDFStyle.createSubSection("Early Termination Details", getReportContext().getCurrentSection());
		PdfPTable terminationTable = DealPDFStyle.createFormTable(2);
		LegSummary legSummary = (LegSummary) getLegSummary();
		terminationTable.addCell(DealPDFStyle.createFormFieldCell(Day2LegBuilder.ACCRUED_INTEREST_AMOUNT, PDFReportHelper.formatCurrency(legSummary.getAccruedInterestAmt()), true));
		terminationTable.addCell(DealPDFStyle.createFormFieldCell(CURRENCY_CAP, legSummary.getOriginalCCY(), true));
		Double brokerageCostAmt = (termination != null) ? termination.getBrokerageCostAmt() : null;
		terminationTable.addCell(DealPDFStyle.createFormFieldCell("Brokerage Cost Amount", PDFReportHelper.formatCurrency(brokerageCostAmt), false));
		terminationTable.addCell(DealPDFStyle.createFormFieldCell("Principal Termination Amount", PDFReportHelper.formatCurrency(legSummary.getOriginalCCYAmount()), false));
		terminationTable.addCell(DealPDFStyle.createEmptyFormFieldCell(true));
		terminationTable.addCell(DealPDFStyle.createFormFieldCell(USD_EQUIVALENT, PDFReportHelper.formatCurrency(legSummary.getUSDEquivalent()), true));
		terminationTable.addCell(DealPDFStyle.createFormFieldCell(Day2LegBuilder.REQUEST_DERIVATIVES, PDFReportHelper.convertBooleanAsYesOrNo(PDFReportHelper.hasDerivatives(leg)), false));
		terminationTable.addCell(DealPDFStyle.createFormFieldCell(Day2LegBuilder.TERMINATION_NOTICE_ATTACHED, PDFReportHelper.convertBooleanAsYesOrNo(legSummary.isEventNoticeAttachedFlag()), false));
		section.add(terminationTable);
		return this;
	}
	
	/**
	 * Renders the Other Details for CPA leg.
	 * 
	 * @return
	 * @throws DocumentException 
	 * @throws ICFPException 
	 */
	public Day2LegBuilder appendCPAOtherDetail() throws DocumentException, ICFPException {
		DayTwoOperations dayTwoOperations = getDayTwoOperations();
		CPATermination cpaTermination = (dayTwoOperations != null) ? dayTwoOperations.getCPATermination() : null;
		Section section = DealPDFStyle.createSubSection("Other Details", getReportContext().getCurrentSection());
		PdfPTable otherDetails = DealPDFStyle.createFormTable(1);
		otherDetails.addCell(DealPDFStyle.createTableDataCell(cpaTermination.getOtherDetailsComments()));
		section.add(otherDetails);
		return this;
	}
	
	/**
	 * Renders the Other Details for the Equity leg.
	 * 
	 * @return
	 * @throws DocumentException 
	 * @throws ICFPException 
	 */
	public Day2LegBuilder appendEquityOtherDetail() throws DocumentException, ICFPException {
		DayTwoOperations dayTwoOperations = getDayTwoOperations();
		Correction correction = (dayTwoOperations != null) ? dayTwoOperations.getCorrection() : null;
		Section section = DealPDFStyle.createSubSection(DESCRIPTION, getReportContext().getCurrentSection());
		PdfPTable otherDetails = DealPDFStyle.createFormTable(2);
		LegSummary legSummary = (LegSummary) getLegSummary();
		otherDetails.addCell(DealPDFStyle.createFormFieldCell(CURRENCY_CAP, legSummary.getOriginalCCY(), true));
		otherDetails.addCell(DealPDFStyle.createFormFieldCell(AMOUNT, PDFReportHelper.formatCurrency(legSummary.getOriginalCCYAmount()), true));
		otherDetails.addCell(DealPDFStyle.createEmptyFormFieldCell(false));
		otherDetails.addCell(DealPDFStyle.createFormFieldCell(USD_EQUIVALENT, PDFReportHelper.formatCurrency(legSummary.getUSDEquivalent()), false));
		section.add(otherDetails);
		
		String comments = (correction != null) ? correction.getDebtEquityOtherComments() : null;
		section.add(DealPDFStyle.createCommentTable(comments));
		return this;
	}
	
	/**
	 * Renders the Termination information of CPA leg.
	 * 
	 * @return
	 * @throws DocumentException 
	 * @throws ICFPException 
	 */
	public Day2LegBuilder appendCPATermination() throws DocumentException, ICFPException {
		Section section = DealPDFStyle.createSubSection("Cash Pool Termination Details", getReportContext().getCurrentSection());
		PdfPTable cashPoolTable = DealPDFStyle.createFormTable(2);
		DayTwoOperations dayTwoOperations = getDayTwoOperations();
		CPATermination cpaTermination = (dayTwoOperations != null) ? dayTwoOperations.getCPATermination() : null;
		String currentCPAAttachedFlag = (cpaTermination != null) ? PDFReportHelper.convertYOrNToYesOrNo(cpaTermination.getCurrentCPAAttachedFlag()) : null;
		cashPoolTable.addCell(DealPDFStyle.createFormFieldCell("Current Cash Pool Agreement Attached", currentCPAAttachedFlag, false));
		String terminationNoticeAttachedFlag = (cpaTermination != null) ? PDFReportHelper.convertYOrNToYesOrNo(cpaTermination.getTerminationNoticeAttachedFlag()) : null;
		cashPoolTable.addCell(DealPDFStyle.createFormFieldCell(Day2LegBuilder.TERMINATION_NOTICE_ATTACHED, terminationNoticeAttachedFlag, false));
		section.add(cashPoolTable);
		return this;
	}
	
	/**
	 * Renders the correction information for the Correction leg.
	 * 
	 * @return
	 * @throws DocumentException 
	 * @throws ICFPException 
	 */
	public Day2LegBuilder appendCorrection() throws DocumentException, ICFPException {
		DayTwoOperations dayTwoOperations = getDayTwoOperations();
		Correction correction = (dayTwoOperations != null) ? dayTwoOperations.getCorrection() : null;
		
		Section psSection = DealPDFStyle.createSubSection("Problem Statement", getReportContext().getCurrentSection());
		String problemStatement = (correction != null) ? correction.getProblemStatement() : null;
		psSection.add(DealPDFStyle.createCommentTable(problemStatement));
		
		Section cnSection = DealPDFStyle.createSubSection("Correction Needed", getReportContext().getCurrentSection());
		PdfPTable cnTable = DealPDFStyle.createFormTable(2);
		String correctionNeededComments = (correction != null) ? correction.getCorrectionNeededComments() : null;
		cnTable.addCell(DealPDFStyle.createCommentTable(correctionNeededComments));
		XMLGregorianCalendar actionNeededByDt = (correction != null) ? correction.getActionNeededByDt() : null;
		cnTable.addCell(DealPDFStyle.createFormFieldCell("Action Needed By", PDFReportHelper.formatDate(actionNeededByDt), false));
		cnSection.add(cnTable);
		return this;
	}
	
	/**
	 * Renders teh general Amendment Details of the leg.
	 * 
	 * @throws ICFPException 
	 * 
	 */
	public Day2LegBuilder appendGeneralAmendmentDetails() throws ICFPException {
		Section section = DealPDFStyle.createSubSection("General Amendment Detail", getReportContext().getCurrentSection());
		PdfPTable amendmentsTbl = DealPDFStyle.createTable(8f, 10f, 13f, 13f, 13f, 8f, 10f, 15f, 10f);
		amendmentsTbl.addCell(DealPDFStyle.createTableHeaderCell("Amendmen #"));
		amendmentsTbl.addCell(DealPDFStyle.createTableHeaderCell(STANDARD_TERMS_CONDITIONS));
		amendmentsTbl.addCell(DealPDFStyle.createTableHeaderCell(EXCEPTION_REQUESTED));
		amendmentsTbl.addCell(DealPDFStyle.createTableHeaderCell(RATIONAL_FOR_EXCEPTION_IMPACT));
		amendmentsTbl.addCell(DealPDFStyle.createTableHeaderCell(RATIONAL_FOR_EXCEPTION_POTENTIAL_ALTERNATIVES));
		amendmentsTbl.addCell(DealPDFStyle.createTableHeaderCell(EXCEPTION_TIMELINE));
		amendmentsTbl.addCell(DealPDFStyle.createTableHeaderCell("Estimated Timeframe"));
		amendmentsTbl.addCell(DealPDFStyle.createTableHeaderCell(COMMENTS));
		amendmentsTbl.addCell(DealPDFStyle.createTableHeaderCell(ATTACHMENTS));
		
		DayTwoOperations dayTwoOperations = getDayTwoOperations();
		if(dayTwoOperations == null || dayTwoOperations.getAmendments().isEmpty()) {
			return this;
		}
		List<Amendment> amendments = dayTwoOperations.getAmendments();
		int amendmentIndex = 0;
		for(Amendment amendment : amendments) {
			amendmentsTbl.addCell(DealPDFStyle.createTableDataCell(String.valueOf(++amendmentIndex)));
			amendmentsTbl.addCell(DealPDFStyle.createTableDataCell(amendment.getAmendmentType()));
			amendmentsTbl.addCell(DealPDFStyle.createTableDataCell(amendment.getRequestedException()));
			amendmentsTbl.addCell(DealPDFStyle.createTableDataCell(amendment.getRationaleForExceptionImpact()));
			amendmentsTbl.addCell(DealPDFStyle.createTableDataCell(amendment.getRationaleForExceptionPotentialAlternatives()));
			amendmentsTbl.addCell(DealPDFStyle.createTableDataCell(amendment.getExceptionTimeline()));
			amendmentsTbl.addCell(DealPDFStyle.createTableDataCell(amendment.getRemediationTimelineTimeframe()));
			amendmentsTbl.addCell(DealPDFStyle.createTableDataCell(amendment.getRemediationTimelineComments()));
			
			List<Attachment> amendmentAttachments = amendment.getAttachments();
			StringBuilder attachmentList = new StringBuilder();
			if(!amendmentAttachments.isEmpty()) {
				for(int attachmentIndex = 0; attachmentIndex < amendmentAttachments.size(); attachmentIndex++) {
					attachmentList.append(amendmentAttachments.get(attachmentIndex).getOrigAttachmentName());
					if(attachmentIndex < amendmentAttachments.size() - 1) {
						attachmentList.append("\n");
					}
				}
			}
			amendmentsTbl.addCell(DealPDFStyle.createTableDataCell(attachmentList.toString()));
		}
		
		section.add(amendmentsTbl);
		return this;
	}
}
