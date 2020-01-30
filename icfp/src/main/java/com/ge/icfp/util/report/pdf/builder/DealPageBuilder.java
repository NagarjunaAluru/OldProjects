/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: DealPageBuilder.java
 * Purpose: This class renders Deal Page of the PDF report.
 */
package com.ge.icfp.util.report.pdf.builder;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.ge.icfp.action.ICFPException;
import com.ge.icfp.common.helper.EntityHelper;
import com.ge.icfp.common.helper.EntityHelper.EntityType;
import com.ge.icfp.common.helper.ICFPCommonHelper;
import com.ge.icfp.common.helper.ICFPDay2LegHelper;
import com.ge.icfp.common.helper.ICFPLegHelper;
import com.ge.icfp.model.ActionLog;
import com.ge.icfp.model.Attachment;
import com.ge.icfp.model.CPALegRequest;
import com.ge.icfp.model.CPASummary;
import com.ge.icfp.model.DayTwoOperations;
import com.ge.icfp.model.DealRequest;
import com.ge.icfp.model.DerivativesRequest;
import com.ge.icfp.model.DerivativesRequest.CounterPartyInfo;
import com.ge.icfp.model.Entity;
import com.ge.icfp.model.ExceptionRequestForm;
import com.ge.icfp.model.FacilityIncreaseDecrease;
import com.ge.icfp.model.LegSummary;
import com.ge.icfp.model.NameValue;
import com.ge.icfp.model.OtherLegRequest;
import com.ge.icfp.model.QualitativeFactors;
import com.ge.icfp.model.RCALegRequest;
import com.ge.icfp.model.TPLegRequest;
import com.ge.icfp.tag.DealManager;
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
 * This class provides logic to render deal page of the report.
 * 
 * @author chaitanya
 */
public class DealPageBuilder extends ReportBuilder {

	private static final String PRIORITY = "Priority";
	private static final String DEFAULT_TRANSACTION_CLASSIFICATION_LEVEL = "Default Transaction Classification Level";
	private static final String REQUEST_DETAILS = "Request Details";
	private static final String BORROWER_INSOLVENT = "Borrower Insolvent";
	private static final String FINANCIAL_STATEMENTS_DATE_1_YEAR = "Financial Statements Date > 1 year";
	private static final String EVENT = "Event";
	private static final String LEG2 = "Leg #";

	/**
	 * Constructor to instantiate the object.
	 * 
	 * @param context
	 */
	public DealPageBuilder(ReportContext context) {
		super(context);
	}
	
	/**
	 * Renders the summary of the deal.
	 * 
	 * @return
	 * @throws DocumentException 
	 */
	public DealPageBuilder appendDealSummary() throws DocumentException {
		Section section = DealPDFStyle.createSection(PROJECT_SUMMARY, getReportContext().getCurrentChapter());
		DealRequest deal = getReportContext().getDeal();
		PdfPTable projSummary = DealPDFStyle.createFormTable(2);
		StringBuilder fullName = new StringBuilder();
		if(StringUtils.isNotBlank(deal.getLastName())) {
			fullName.append(deal.getLastName());
		}
		if(StringUtils.isNotBlank(deal.getFirstName())) {
			if(fullName.length() > 0) {
				fullName.append(", ");
			}
			fullName.append(deal.getFirstName());
		}
		projSummary.addCell(DealPDFStyle.createFormFieldCell(TRANSACTION_OWNER, fullName.toString(), true));
		projSummary.addCell(DealPDFStyle.createEmptyFormFieldCell(true));
		projSummary.addCell(DealPDFStyle.createFormFieldCell(DEAL_ID, deal.getUniqueId(), false));
		projSummary.addCell(DealPDFStyle.createFormFieldCell(DEAL_NAME, deal.getDealName(), false));
		projSummary.addCell(DealPDFStyle.createFormFieldCell(DEAL_RATIONALE, deal.getDealRationale(), true));
		projSummary.addCell(DealPDFStyle.createFormFieldCell(DEAL_CATEGORY, deal.getDealCategory(), true));
		section.add(projSummary);
		return this;
	}
	
	/**
	 * Renders the summary for CPA deal
	 * @return
	 */
	public DealPageBuilder appendCPADealSummary() {
		Section section = DealPDFStyle.createSection(PROJECT_SUMMARY, getReportContext().getCurrentChapter());
		DealRequest deal = getReportContext().getDeal();
		PdfPTable projSummary = DealPDFStyle.createFormTable(2);
		StringBuilder fullName = new StringBuilder();
		if(StringUtils.isNotBlank(deal.getLastName())) {
			fullName.append(deal.getLastName());
		}
		if(StringUtils.isNotBlank(deal.getFirstName())) {
			if(fullName.length() > 0) {
				fullName.append(", ");
			}
			fullName.append(deal.getFirstName());
		}
		projSummary.addCell(DealPDFStyle.createFormFieldCell(TRANSACTION_OWNER, fullName.toString(), true));
		projSummary.addCell(DealPDFStyle.createEmptyFormFieldCell(true));
		projSummary.addCell(DealPDFStyle.createFormFieldCell("Request ID", deal.getUniqueId(), false));
		projSummary.addCell(DealPDFStyle.createFormFieldCell(DESCRIPTION, deal.getDealName(), false)); 
		projSummary.addCell(DealPDFStyle.createFormFieldCell("Request Category", deal.getDealCategory(), true));
		projSummary.addCell(DealPDFStyle.createFormFieldCell("Request Rationale", deal.getDealRationale(), true));
		projSummary.addCell(DealPDFStyle.createFormFieldCell("Vault Request ID", deal.getVaultId(), false  ));
		projSummary.addCell(DealPDFStyle.createEmptyFormFieldCell(false)); // Add empty cell
		
		section.add(projSummary);
		return this;
	}
	
	/**
	 * Renders the Transaction summary of the deal.
	 * 
	 * @return
	 * @throws DocumentException 
	 * @throws ICFPException 
	 */
	public DealPageBuilder appendTransactionSummary() throws DocumentException, ICFPException {
		DealRequest deal = getReportContext().getDeal();
		int legCount = ICFPCommonHelper.getLegCount(deal);
		
		if(legCount == 0) {
			return this;
		}
		
		Section section = DealPDFStyle.createSection("Transaction Legs", getReportContext().getCurrentChapter());
		PdfPTable legSummary = DealPDFStyle.createTable(5f, 5f, 7f, 8f, 4f, 7f, 5f, 8f, 7f, 5f, 8f, 7f, 8f, 8f, 8f);
		legSummary.getDefaultCell().setColspan(15); // For derivatives table
		
		// Create first level column headers
		legSummary.addCell(DealPDFStyle.createTableHeaderCell(DealPageBuilder.LEG2));
		legSummary.addCell(DealPDFStyle.createTableHeaderCell("Trade ID"));
		legSummary.addCell(DealPDFStyle.createTableHeaderCell(PRODUCT_TYPE));
		legSummary.addCell(DealPDFStyle.createTableHeaderCell(DealPageBuilder.EVENT));
		legSummary.addCell(DealPDFStyle.createTableHeaderCell(TERM_IN_MONTHS));
		legSummary.addCell(DealPDFStyle.createTableHeaderCell(LENDER_PROVIDER, 3));
		legSummary.addCell(DealPDFStyle.createTableHeaderCell("Borrower/Recipient", 3));
		legSummary.addCell(DealPDFStyle.createTableHeaderCell(ORIGINAL_CURRENCY, 2));
		legSummary.addCell(DealPDFStyle.createTableHeaderCell(ORIGINAL_CURRENCY));
		legSummary.addCell(DealPDFStyle.createTableHeaderCell(DERIVATIVES));
		
		// Create second level column headers
		legSummary.addCell(DealPDFStyle.createTableHeaderCell(""));
		legSummary.addCell(DealPDFStyle.createTableHeaderCell(""));
		legSummary.addCell(DealPDFStyle.createTableHeaderCell(""));
		legSummary.addCell(DealPDFStyle.createTableHeaderCell(""));
		legSummary.addCell(DealPDFStyle.createTableHeaderCell(""));
		legSummary.addCell(DealPDFStyle.createTableHeaderCell(LEGAL_ENTITY_GOLD_ID));
		legSummary.addCell(DealPDFStyle.createTableHeaderCell(CDR));
		legSummary.addCell(DealPDFStyle.createTableHeaderCell(COUNTRY_BIG));
		legSummary.addCell(DealPDFStyle.createTableHeaderCell(LEGAL_ENTITY_GOLD_ID));
		legSummary.addCell(DealPDFStyle.createTableHeaderCell(CDR));
		legSummary.addCell(DealPDFStyle.createTableHeaderCell(COUNTRY_BIG));
		legSummary.addCell(DealPDFStyle.createTableHeaderCell(CURRENCY_CAP));
		legSummary.addCell(DealPDFStyle.createTableHeaderCell(AMOUNT));
		legSummary.addCell(DealPDFStyle.createTableHeaderCell(""));
		legSummary.addCell(DealPDFStyle.createTableHeaderCell(""));
		
		boolean globalDerivativesFlag = false;
		String globalQualitativeNotchingFlag = null;
		String solvencyMetricsAssessmentFlag = null;
		for(int i=1; i<=legCount; i++) {
			Object leg = ICFPCommonHelper.getLegByNumber(i, deal);
			
			// Set global flags
			if(leg instanceof RCALegRequest || leg instanceof OtherLegRequest || leg instanceof CPALegRequest) {
				TPLegRequest tpLegRequest = Utils.fetchPropertyValue(TPLEGREQUEST, leg, TPLegRequest.class);
				
				if(tpLegRequest != null) {
					if(globalQualitativeNotchingFlag == null || !YES_CAP.equals(globalQualitativeNotchingFlag)) {
						String qNotches = tpLegRequest.getQualitativeNotches();
						globalQualitativeNotchingFlag = (StringUtils.isNotBlank(qNotches) && Double.valueOf(qNotches) > 0) ? YES_CAP : NO_CAP;
					}
					
					if(solvencyMetricsAssessmentFlag == null || !YES_CAP.equals(solvencyMetricsAssessmentFlag)) {
						solvencyMetricsAssessmentFlag = PDFReportHelper.getSolvencyMetricsAssessment(tpLegRequest);
					}
				}
			}
			
			Object legSummaryObj = ICFPLegHelper.getLegSummary(leg);
			
			legSummary.addCell(DealPDFStyle.createTableDataCell(String.valueOf(Utils.fetchPropertyValue(LEGSEQID, legSummaryObj, Integer.class))));
			legSummary.addCell(DealPDFStyle.createTableDataCell(Utils.fetchPropertyValue("transactionId", legSummaryObj, String.class)));
			legSummary.addCell(DealPDFStyle.createTableDataCell(Utils.fetchPropertyValue(PRODUCTTYPE, legSummaryObj, String.class)));
			
			EventType eventType= ICFPDay2LegHelper.getEventType(leg);
			StringBuilder eventName = new StringBuilder();
			if(PDFReportHelper.isImmediateDrawdownLeg(leg)) {
				eventName.append(Utils.fetchPropertyValue(TRANSACTIONEVENTTYPE, legSummaryObj, String.class)).append(" for Leg # ").append(Utils.fetchPropertyValueAsString("drawDown", legSummaryObj));
			} else if(eventType != null && eventType == EventType.AMENDMENT_FACILITY_INC_DEC) {
				eventName.append(AMENDMENTFACILITY);
				DayTwoOperations dayTwoOperations = Utils.fetchPropertyValue(DAYTWOOPERATIONS, leg, DayTwoOperations.class);
				FacilityIncreaseDecrease facilityIncDec = (dayTwoOperations != null) ? dayTwoOperations.getFacilityIncreaseDecrease() : null;
				eventName.append((facilityIncDec.getFacilityTypeId().equals(1)) ? INCREASE : DECREASE);
			} else if(eventType != null) {
				eventName.append(Utils.fetchPropertyValue(TRANSACTIONEVENTTYPE, legSummaryObj, String.class));
			} else {
				eventName.append(NEW_TRANSACTION);
			}
			legSummary.addCell(DealPDFStyle.createTableDataCell(eventName.toString()));
			legSummary.addCell(DealPDFStyle.createTableDataCell(Utils.fetchPropertyValueAsString("termInMonths", legSummaryObj)));
			
			
			Entity lenderEntity = EntityHelper.searchEntity(legSummaryObj, EntityType.ORIGINAL_LENDER);
			Entity borrowerEntity = EntityHelper.searchEntity(legSummaryObj, EntityType.ORIGINAL_BORROWER);
			
			legSummary.addCell(DealPDFStyle.createTableDataCell((lenderEntity != null) ? lenderEntity.getLEGoldId() : null));
			legSummary.addCell(DealPDFStyle.createTableDataCell((lenderEntity != null) ? lenderEntity.getCDRCd() : null));
			legSummary.addCell(DealPDFStyle.createTableDataCell((lenderEntity != null) ? lenderEntity.getCountry() : null));
			
			legSummary.addCell(DealPDFStyle.createTableDataCell((borrowerEntity != null) ? borrowerEntity.getLEGoldId() : null));
			legSummary.addCell(DealPDFStyle.createTableDataCell((borrowerEntity != null) ? borrowerEntity.getCDRCd() : null));
			legSummary.addCell(DealPDFStyle.createTableDataCell((borrowerEntity != null) ? borrowerEntity.getCountry() : null));
			
			legSummary.addCell(DealPDFStyle.createTableDataCell(Utils.fetchPropertyValueAsString(ORIGINALCCY, legSummaryObj)));
			
			Double amount = null;
			if(PDFReportHelper.isImmediateDrawdownLeg(leg)) {
				amount = Utils.fetchPropertyValue(IMMDTDRDOWNAMT, leg, Double.class);
			} else if(eventType == EventType.AMENDMENT_FACILITY_INC_DEC) {
				DayTwoOperations dayTwoOperations = Utils.fetchPropertyValue(DAYTWOOPERATIONS, leg, DayTwoOperations.class);
				if(dayTwoOperations != null && dayTwoOperations.getFacilityIncreaseDecrease() != null) {
					amount = dayTwoOperations.getFacilityIncreaseDecrease().getFacilityIncDecAmt();
				}
			} else {
				amount = ((LegSummary) legSummaryObj).getOriginalCCYAmount();
			}
			
			legSummary.addCell(DealPDFStyle.createTableDataCell(PDFReportHelper.formatCurrency(amount)));
			Double usdEquivalent = null;
			if(eventType == EventType.AMENDMENT_FACILITY_INC_DEC) {
				DayTwoOperations dayTwoOperations = Utils.fetchPropertyValue(DAYTWOOPERATIONS, leg, DayTwoOperations.class);
				if(dayTwoOperations != null && dayTwoOperations.getFacilityIncreaseDecrease() != null) {
					usdEquivalent = dayTwoOperations.getFacilityIncreaseDecrease().getFacilityIncDecUSDEquivalentAmt();
				}
			} else {
				usdEquivalent = Utils.fetchPropertyValue(USDEQUIVALENT, legSummaryObj, Double.class);
			}
			legSummary.addCell(DealPDFStyle.createTableDataCell(PDFReportHelper.formatCurrency(usdEquivalent)));
			
			Boolean hasDerivatives = PDFReportHelper.hasDerivatives(leg);
			legSummary.addCell(DealPDFStyle.createTableDataCell(PDFReportHelper.convertBooleanAsYesOrNo(hasDerivatives, false)));
			
			globalDerivativesFlag = globalDerivativesFlag | ((hasDerivatives != null) ? hasDerivatives : false);

			List<DerivativesRequest> derivatives = ICFPLegHelper.getDerivatives(leg);
			if(derivatives != null && !derivatives.isEmpty()) {
				legSummary.addCell(createDerivativesTableInTS(derivatives));
			}
		}
		
		section.add(legSummary);
		
		Section transactionSummarySection = DealPDFStyle.createSection(TRANSACTION_SUMMARY, getReportContext().getCurrentChapter());
		PdfPTable transSummary = DealPDFStyle.createFormTable(2);
		List<Object> legs = deal.getLegs().getAllLegs();
		String secureFlag= (deal.getSecurityCategoryId() != null && deal.getSecurityCategoryId().equals(1)) ? "Secured" : "Unsecured";
		transSummary.addCell(DealPDFStyle.createFormFieldCell(SECURITYTYPE, secureFlag, true));
		transSummary.addCell(DealPDFStyle.createFormFieldCell(EQUITY_SMALL, DealManager.getEquityInfusionsDividendsFlag(legs), true));
		
		String impairmentHistFlag = (deal.isImpairmentHistoryFlag()!= null && deal.isImpairmentHistoryFlag()) ? YES_CAP : NO_CAP;
		transSummary.addCell(DealPDFStyle.createFormFieldCell(IMPAIRMENT_HISTORY, impairmentHistFlag, false));
		transSummary.addCell(DealPDFStyle.createFormFieldCell(PRUDENTIALLY_REGULATED_LEGAL_ENTITY, DealManager.getPrudentialEntityFlag(legs), false));
		
		transSummary.addCell(DealPDFStyle.createFormFieldCell(IMPAIRMENT_COMMENT, deal.getImpairmentComment(), true));
		transSummary.addCell(DealPDFStyle.createFormFieldCell(PRINCIPAL_LEGAL_ENTITY, DealManager.getPrincipalEntityFlag(legs), true));
		
		String finStmtDtAboveOneYrFlag = (deal.isFinSttmntDtAboveOneYrFlag()!= null && deal.isFinSttmntDtAboveOneYrFlag()) ? YES_CAP : NO_CAP;
		transSummary.addCell(DealPDFStyle.createFormFieldCell(DealPageBuilder.FINANCIAL_STATEMENTS_DATE_1_YEAR, finStmtDtAboveOneYrFlag, false));
		transSummary.addCell(DealPDFStyle.createFormFieldCell(SUBORDINATED_DEBT, DealManager.getSubOrdinateDebtFlag(legs), false));
		
		transSummary.addCell(DealPDFStyle.createFormFieldCell(LATEST_DATE_OF_FINANCIAL_STATEMENT, PDFReportHelper.formatDate(deal.getLatestDtOfFinSttmnt()), true)); 
		transSummary.addCell(DealPDFStyle.createFormFieldCell(DealPageBuilder.BORROWER_INSOLVENT, PDFReportHelper.getBorrowerInsolvencyFlag(deal), true));
		
		transSummary.addCell(DealPDFStyle.createFormFieldCell(NON_STANDARD_LEGAL_AGREEMENT, DealManager.getNonStandardDocsFlag(legs), false));
		transSummary.addCell(DealPDFStyle.createFormFieldCell(QUALITATIVE_NOTCHING, globalQualitativeNotchingFlag, false));
		
		
		transSummary.addCell(DealPDFStyle.createFormFieldCell(DERIVATIVES, PDFReportHelper.convertBooleanAsYesOrNo(globalDerivativesFlag, (legCount > 0 ? false : null)), true));
		transSummary.addCell(DealPDFStyle.createFormFieldCell(CROSS_BORDER, DealManager.getCrossBorderFlagValue(legs), true));
		
		transactionSummarySection.add(transSummary);
		return this;
	}
	
	/**
	 * Renders the Transaction summary for CPA deal.
	 * 
	 * @return
	 * @throws ICFPException 
	 */
	public DealPageBuilder appendCPATransactionSummary() throws ICFPException {
		DealRequest deal = getReportContext().getDeal();
		int legCount = ICFPCommonHelper.getLegCount(deal);
		
		if(legCount == 0) {
			return this;
		}
		
		Section section = DealPDFStyle.createSection(DealPageBuilder.REQUEST_DETAILS, getReportContext().getCurrentChapter());
		PdfPTable legSummary = DealPDFStyle.createTable(5f, 7f, 9f, 8f, 5f, 7f, 9f, 8f, 5f, 7f, 9f, 9f);
		
		// Create first level column headers
		legSummary.addCell(DealPDFStyle.createTableHeaderCell(DealPageBuilder.LEG2));
		legSummary.addCell(DealPDFStyle.createTableHeaderCell(PRODUCT_TYPE));
		legSummary.addCell(DealPDFStyle.createTableHeaderCell("Inhouse Bank ID"));
		legSummary.addCell(DealPDFStyle.createTableHeaderCell("Participant", 4));
		legSummary.addCell(DealPDFStyle.createTableHeaderCell("Pool Leader", 4));
		legSummary.addCell(DealPDFStyle.createTableHeaderCell(BANK_NAME));
		
		// Create second level column headers
		legSummary.addCell(DealPDFStyle.createTableHeaderCell(""));
		legSummary.addCell(DealPDFStyle.createTableHeaderCell(""));
		legSummary.addCell(DealPDFStyle.createTableHeaderCell(""));
		legSummary.addCell(DealPDFStyle.createTableHeaderCell(LEGAL_ENTITY_GOLD_ID));
		legSummary.addCell(DealPDFStyle.createTableHeaderCell(CDR));
		legSummary.addCell(DealPDFStyle.createTableHeaderCell(COUNTRY_BIG));
		legSummary.addCell(DealPDFStyle.createTableHeaderCell(ME));
		legSummary.addCell(DealPDFStyle.createTableHeaderCell(LEGAL_ENTITY_GOLD_ID));
		legSummary.addCell(DealPDFStyle.createTableHeaderCell(CDR));
		legSummary.addCell(DealPDFStyle.createTableHeaderCell(COUNTRY_BIG));
		legSummary.addCell(DealPDFStyle.createTableHeaderCell(ME));
		legSummary.addCell(DealPDFStyle.createTableHeaderCell(""));
		
		String globalQualitativeNotchingFlag = null;
		String solvencyMetricsAssessmentFlag = null;
		for(int i=1; i<=legCount; i++) {
			Object leg = ICFPCommonHelper.getLegByNumber(i, deal);
			
			TPLegRequest tpLegRequest = Utils.fetchPropertyValue(TPLEGREQUEST, leg, TPLegRequest.class);
			
			// Set global flags
			if(tpLegRequest != null) {
				if(globalQualitativeNotchingFlag == null || !YES_CAP.equals(globalQualitativeNotchingFlag)) {
					String qNotches = tpLegRequest.getQualitativeNotches();
					globalQualitativeNotchingFlag = (StringUtils.isNotBlank(qNotches) && Double.valueOf(qNotches) > 0) ? YES_CAP : NO_CAP;
				}
				
				if(solvencyMetricsAssessmentFlag == null || !YES_CAP.equals(solvencyMetricsAssessmentFlag)) {
					solvencyMetricsAssessmentFlag = PDFReportHelper.getSolvencyMetricsAssessment(tpLegRequest);
				}
			}
			
			CPASummary legSummaryObj = (CPASummary) ICFPLegHelper.getLegSummary(leg);
			
			legSummary.addCell(DealPDFStyle.createTableDataCell(String.valueOf(Utils.fetchPropertyValue(LEGSEQID, legSummaryObj, Integer.class))));
			legSummary.addCell(DealPDFStyle.createTableDataCell(Utils.fetchPropertyValue(PRODUCTTYPE, legSummaryObj, String.class)));
			legSummary.addCell(DealPDFStyle.createTableDataCell(Utils.fetchPropertyValue("subLedgerTransactionId", legSummaryObj, String.class))); 
			
			Entity participant = EntityHelper.searchEntity(legSummaryObj, EntityType.PARTICIPANT);
			Entity poolleader = EntityHelper.searchEntity(legSummaryObj, EntityType.POOL_LEADER);
			
			legSummary.addCell(DealPDFStyle.createTableDataCell((participant != null) ? participant.getLEGoldId() : null));
			legSummary.addCell(DealPDFStyle.createTableDataCell((participant != null) ? participant.getCDRCd() : null));
			legSummary.addCell(DealPDFStyle.createTableDataCell((participant != null) ? participant.getCountry() : null));
			legSummary.addCell(DealPDFStyle.createTableDataCell((participant != null) ? participant.getMEName() : null));
			
			legSummary.addCell(DealPDFStyle.createTableDataCell((poolleader != null) ? poolleader.getLEGoldId() : null));
			legSummary.addCell(DealPDFStyle.createTableDataCell((poolleader != null) ? poolleader.getCDRCd() : null));
			legSummary.addCell(DealPDFStyle.createTableDataCell((poolleader != null) ? poolleader.getCountry() : null));
			legSummary.addCell(DealPDFStyle.createTableDataCell((poolleader != null) ? poolleader.getMEName() : null));
			legSummary.addCell(DealPDFStyle.createTableDataCell(legSummaryObj.getBnkName()));
		}
		
		section.add(legSummary);
		
		Section transactionSummarySection = DealPDFStyle.createSection(TRANSACTION_SUMMARY, getReportContext().getCurrentChapter());
		PdfPTable transSummary = DealPDFStyle.createFormTable(2);
		List<Object> legs = deal.getLegs().getAllLegs();
		
		
		transSummary.addCell(DealPDFStyle.createFormFieldCell(CROSS_BORDER, DealManager.getCrossBorderFlagValue(legs), true));
		transSummary.addCell(DealPDFStyle.createFormFieldCell(NON_STANDARD_LEGAL_AGREEMENT, DealManager.getNonStandardDocsFlag(legs), true));
		
		String impairmentHistFlag = (deal.isImpairmentHistoryFlag()!= null && deal.isImpairmentHistoryFlag()) ? YES_CAP : NO_CAP;
		transSummary.addCell(DealPDFStyle.createFormFieldCell(IMPAIRMENT_HISTORY, impairmentHistFlag, false));
		transSummary.addCell(DealPDFStyle.createFormFieldCell(PRUDENTIALLY_REGULATED_LEGAL_ENTITY, DealManager.getPrudentialEntityFlag(legs), false));
		
		transSummary.addCell(DealPDFStyle.createFormFieldCell(IMPAIRMENT_COMMENT, deal.getImpairmentComment(), true));
		transSummary.addCell(DealPDFStyle.createFormFieldCell(PRINCIPAL_LEGAL_ENTITY, DealManager.getPrincipalEntityFlag(legs), true));
		

		String finStmtDtAboveOneYrFlag = (deal.isFinSttmntDtAboveOneYrFlag()!= null && deal.isFinSttmntDtAboveOneYrFlag()) ? YES_CAP : NO_CAP;
		transSummary.addCell(DealPDFStyle.createFormFieldCell(DealPageBuilder.FINANCIAL_STATEMENTS_DATE_1_YEAR, finStmtDtAboveOneYrFlag, false));
		transSummary.addCell(DealPDFStyle.createFormFieldCell("Cash Pool Participant Insolvent", PDFReportHelper.getBorrowerInsolvencyFlag(deal), false));
		
		transSummary.addCell(DealPDFStyle.createFormFieldCell(LATEST_DATE_OF_FINANCIAL_STATEMENT, PDFReportHelper.formatDate(deal.getLatestDtOfFinSttmnt()), true)); 
		transSummary.addCell(DealPDFStyle.createEmptyFormFieldCell(true));
		
		transactionSummarySection.add(transSummary);
		return this;
	}
	
	/**
	 * Renders teh Transaction Classification Level information of the deal.
	 * 
	 * @return
	 */
	public DealPageBuilder appendTransactionClassificationLevel() {
		Section section = DealPDFStyle.createSection(TRANSACTION_CLASSIFICATION_LEVEL, getReportContext().getCurrentChapter());
		PdfPTable classificationLevelTable = DealPDFStyle.createFormTable(2);
		DealRequest deal = getReportContext().getDeal();
		String dealTCL = (deal.getDealTcl() != null) ? String.valueOf(deal.getDealTcl()) : null;
		classificationLevelTable.addCell(DealPDFStyle.createFormFieldCell(DealPageBuilder.DEFAULT_TRANSACTION_CLASSIFICATION_LEVEL, dealTCL, true));
		classificationLevelTable.addCell(DealPDFStyle.createEmptyFormFieldCell(true));
		
		Boolean riskOverrideFlag = deal.isRiskOverrideFlag();
		classificationLevelTable.addCell(DealPDFStyle.createFormFieldCell("Risk Review override needed", PDFReportHelper.convertBooleanAsYesOrNo(riskOverrideFlag), false));
		classificationLevelTable.addCell(DealPDFStyle.createEmptyFormFieldCell(false));
		
		Integer ruAmendedTcl = deal.getRuAmendedTcl();
		Integer tempClassificationLevel = (riskOverrideFlag != null && riskOverrideFlag.booleanValue()) ? 0 : deal.getDealTcl();
		Integer classificationLevel = (ruAmendedTcl != null) ? ruAmendedTcl : tempClassificationLevel;
			
		classificationLevelTable.addCell(DealPDFStyle.createFormFieldCell(TRANSACTION_CLASSIFICATION_LEVEL, (classificationLevel != null) ? String.valueOf(classificationLevel) : null, true));
		classificationLevelTable.addCell(DealPDFStyle.createFormFieldCell("Revised Transaction Classification Level Comments", deal.getRevisedTclComments(), true));
		section.add(classificationLevelTable);
		return this;
	}
	
	/**
	 * Renders the Transaction Priority and Timing information of the deal.
	 * 
	 */
	public DealPageBuilder appendTransactionPriorityAndTiming() {
		Section section = DealPDFStyle.createSection(TRANSACTION_PRIORITY_AND_TIMING, getReportContext().getCurrentChapter());
		DealRequest deal = getReportContext().getDeal();
		
		PdfPTable projSummary = DealPDFStyle.createFormTable(2);
		projSummary.addCell(DealPDFStyle.createFormFieldCell(DealPageBuilder.PRIORITY, deal.getPriority(), true));
		projSummary.addCell(DealPDFStyle.createFormFieldCell(REGION_RESPONSIBILITY, deal.getResponsibleRegion(), true));
		projSummary.addCell(DealPDFStyle.createFormFieldCell(PRIORITY_COMMENT,deal.getPriorityComment(), false));
		String valueDt = (deal.getValueDt() != null) ? PDFReportHelper.formatDate(deal.getValueDt()) : null; 
		projSummary.addCell(DealPDFStyle.createFormFieldCell(VALUE_DATE, valueDt, false)); 
		String requestDt = (deal.getRequestDt() != null) ?  PDFReportHelper.formatDate(deal.getRequestDt()) : null; 
		projSummary.addCell(DealPDFStyle.createFormFieldCell(REQUEST_DATE, requestDt, true));
		projSummary.addCell(DealPDFStyle.createEmptyFormFieldCell(true));
		section.add(projSummary);
		return this;
	}
	
	/**
	 * Renders the Exceptions of the deal.
	 * 
	 * @throws ICFPException 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public DealPageBuilder appendExceptions() throws ICFPException {
		DealRequest deal = getReportContext().getDeal();
		int legCount = ICFPCommonHelper.getLegCount(deal);
		if(!PDFReportHelper.hasExceptions(deal, legCount)) {
			return this;
		}
		Section section = DealPDFStyle.createSection("Exceptions", getReportContext().getCurrentChapter());
		
		PdfPTable excSummary = DealPDFStyle.createTable(8f, 12f, 12f, 12f, 12f, 12f, 12f, 12f,8f);
		excSummary.addCell(DealPDFStyle.createTableHeaderCell(DealPageBuilder.LEG2));
		excSummary.addCell(DealPDFStyle.createTableHeaderCell(STANDARD_TERMS_CONDITIONS));
		excSummary.addCell(DealPDFStyle.createTableHeaderCell(EXCEPTION_REQUESTED));
		excSummary.addCell(DealPDFStyle.createTableHeaderCell(RATIONAL_FOR_EXCEPTION_IMPACT));
		excSummary.addCell(DealPDFStyle.createTableHeaderCell(RATIONAL_FOR_EXCEPTION_POTENTIAL_ALTERNATIVES));
		excSummary.addCell(DealPDFStyle.createTableHeaderCell(EXCEPTION_TIMELINE));
		excSummary.addCell(DealPDFStyle.createTableHeaderCell("Remediation Timeline"));
		excSummary.addCell(DealPDFStyle.createTableHeaderCell(COMMENTS));
		excSummary.addCell(DealPDFStyle.createTableHeaderCell(ATTACHMENTS));
		
		
		Object legSummary = null;
		List<ExceptionRequestForm> exceptionRequestFormList = null;

		for (int i = 1; i <= legCount; i++) {
			Object leg = ICFPCommonHelper.getLegByNumber(i, deal);
			legSummary = ICFPLegHelper.getLegSummary(leg);
			exceptionRequestFormList = Utils.fetchPropertyValue(EXCEPTIONREQUESTFORMS, legSummary, List.class);
			if(exceptionRequestFormList.isEmpty()) {
				continue;
			}
			
			for(ExceptionRequestForm exceptionRequestForm : exceptionRequestFormList) {
				excSummary.addCell(DealPDFStyle.createTableDataCell(String.valueOf(Utils.fetchPropertyValue(LEGSEQID, legSummary, Integer.class))));
				excSummary.addCell(DealPDFStyle.createTableDataCell(exceptionRequestForm.getStandardTermsConditions()));
				excSummary.addCell(DealPDFStyle.createTableDataCell(exceptionRequestForm.getRequestedException()));
				excSummary.addCell(DealPDFStyle.createTableDataCell(exceptionRequestForm.getRationaleForExceptionImpact()));
				excSummary.addCell(DealPDFStyle.createTableDataCell(exceptionRequestForm.getRationaleForExceptionPotentialAlternatives()));
				excSummary.addCell(DealPDFStyle.createTableDataCell(exceptionRequestForm.getExceptionTimeline()));
				excSummary.addCell(DealPDFStyle.createTableDataCell(exceptionRequestForm.getRemediationTimeline()));
				excSummary.addCell(DealPDFStyle.createTableDataCell(exceptionRequestForm.getRemediationTimelineComments()));
				
				List<Attachment> exceptionAttachments = exceptionRequestForm.getAttachments();
				StringBuilder attachmentList = new StringBuilder();
				if(!exceptionAttachments.isEmpty()) {
					for(int attachmentIndex = 0; attachmentIndex < exceptionAttachments.size(); attachmentIndex++) {
						attachmentList.append(exceptionAttachments.get(attachmentIndex).getOrigAttachmentName());
						if(attachmentIndex < exceptionAttachments.size() - 1) {
							attachmentList.append("\n");
						}
					}
				}
				excSummary.addCell(DealPDFStyle.createTableDataCell(attachmentList.toString()));
			}
		}
		
		section.add(excSummary);
		return this;
	}
	
	
	/**
	 * Renders the Qualitative Assesments of the deal.
	 * @throws ICFPException 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public DealPageBuilder appendQualitativeAssessment() throws ICFPException {
		Section section = DealPDFStyle.createSection("Qualitative Assessment", getReportContext().getCurrentChapter());
		PdfPTable qualitativeSummary = DealPDFStyle.createTable(10f, 30f, 20f, 20f,20f);
		
		qualitativeSummary.addCell(DealPDFStyle.createTableHeaderCell(DealPageBuilder.LEG2));
		qualitativeSummary.addCell(DealPDFStyle.createTableHeaderCell("Qualitative Risk Factors"));
		qualitativeSummary.addCell(DealPDFStyle.createTableHeaderCell("Assessment "));
		qualitativeSummary.addCell(DealPDFStyle.createTableHeaderCell("Owner"));
		qualitativeSummary.addCell(DealPDFStyle.createTableHeaderCell("Rationale"));
		
		DealRequest deal = getReportContext().getDeal();
		int legCount = ICFPCommonHelper.getLegCount(deal);
		if(legCount == 0) {
			return this;
		}
		
		List<QualitativeFactors> legQualitativeFactors = null;
		Object leg = null;
		Object legSummary = null;
		for(int legIndex = 1; legIndex <= legCount; legIndex++) {
			leg = ICFPCommonHelper.getLegByNumber(legIndex, deal);
			legSummary = ICFPLegHelper.getLegSummary(leg);
			legQualitativeFactors = Utils.fetchPropertyValue(QUALITATIVEFACTORS, legSummary, List.class);
			
			for(QualitativeFactors qualitativeFactors : legQualitativeFactors) {
				if(!qualitativeFactors.getAssessment().equalsIgnoreCase("Low")) {
					qualitativeSummary.addCell(DealPDFStyle.createTableDataCell(String.valueOf(Utils.fetchPropertyValue(LEGSEQID, legSummary, Integer.class))));
					qualitativeSummary.addCell(DealPDFStyle.createTableDataCell(qualitativeFactors.getQualitativeFactor().replaceAll(" Risk", "")));
					qualitativeSummary.addCell(DealPDFStyle.createTableDataCell(qualitativeFactors.getAssessment()));
					qualitativeSummary.addCell(DealPDFStyle.createTableDataCell(qualitativeFactors.getOwnerSso()));
					qualitativeSummary.addCell(DealPDFStyle.createTableDataCell(qualitativeFactors.getComment()));
				}
			}
		}
		section.add(qualitativeSummary);
		return this;
	}
	
	
	/**
	 * Renders the Recommendation of the deal.
	 */
	public DealPageBuilder appendRecommendations() {
		Section section = DealPDFStyle.createSection("Recommendations", getReportContext().getCurrentChapter());
		PdfPTable recommendations = DealPDFStyle.createTable(20f, 20f, 60f);
		
		recommendations.addCell(DealPDFStyle.createTableHeaderCell("Date"));
		recommendations.addCell(DealPDFStyle.createTableHeaderCell("Author"));
		recommendations.addCell(DealPDFStyle.createTableHeaderCell(COMMENTS));
		
		List<ActionLog> actionLogList = getReportContext().getDeal().getActionLogs();
		for(ActionLog actionLog : actionLogList) {
			String stage = actionLog.getGroupName();
			if(StringUtils.isBlank(stage)) {
				continue;
			}
			if("IDAG".equalsIgnoreCase(stage.trim()) || "TESG".equalsIgnoreCase(stage.trim()) || stage.contains("Biz")) {
				recommendations.addCell(DealPDFStyle.createTableDataCell(actionLog.getActionDt()));
				StringBuilder author = new StringBuilder();
				if(StringUtils.isNotBlank(actionLog.getLastName())) {
					author.append(actionLog.getLastName());
				}
				
				if(StringUtils.isNotBlank(actionLog.getFirstName())) {
					if(author.length() > 0) {
						author.append(", ");
					}
					author.append(actionLog.getFirstName());
				}
				recommendations.addCell(DealPDFStyle.createTableDataCell(author.toString())); 
				recommendations.addCell(DealPDFStyle.createTableDataCell(actionLog.getComments()));
			}
		}
		
		section.add(recommendations);
		return this;
	}
	
	
	
	/**
	 * Renders the Deal Team for current deal.
	 * 
	 */
	public DealPageBuilder appendDealTeam() {
		Section section = DealPDFStyle.createSection(DEAL_TEAM, getReportContext().getCurrentChapter());
		PdfPTable projSummary = DealPDFStyle.createFormTable(2); 
		
		DealRequest deal = getReportContext().getDeal();
		projSummary.addCell(DealPDFStyle.createFormFieldCell("Front Office ", deal.getFrontOfficeAssignedSso(), true));
		projSummary.addCell(DealPDFStyle.createFormFieldCell("Middle Office ", deal.getMiddleOfficeAssignedSso(), true));
		projSummary.addCell(DealPDFStyle.createFormFieldCell("Cash Management ",  deal.getCashManagementAssignedSso(), false));
		projSummary.addCell(DealPDFStyle.createFormFieldCell("Treasury Tax ", deal.getTreasuryTaxAssigned(), false));
	
		section.add(projSummary);
		return this;
	}
	
	/**
	 * Renders the Cash Pool details of the deal.
	 * 
	 * @return
	 * @throws ICFPException 
	 */
	public DealPageBuilder appendCashPoolDetails() throws ICFPException {
		Section section = DealPDFStyle.createSection("Cash Pool Details", getReportContext().getCurrentChapter());
		PdfPTable cashPoolTable = DealPDFStyle.createFormTable(2); 
		DealRequest deal = getReportContext().getDeal();
		CPALegRequest leg = (CPALegRequest) ICFPCommonHelper.getLegByNumber(1, deal);
		CPASummary legSummary = (leg != null) ? leg.getCPASummary() : null;
		Entity poolLeaderEntity = (legSummary != null) ? EntityHelper.searchEntity(leg.getCPASummary(), EntityType.POOL_LEADER) : null;
		cashPoolTable.addCell(DealPDFStyle.createFormFieldCell(CASH_POOL_NAME, (poolLeaderEntity != null) ? poolLeaderEntity.getLEName() : null, true));
		cashPoolTable.addCell(DealPDFStyle.createFormFieldCell("Cash Pool Country", (poolLeaderEntity != null) ? poolLeaderEntity.getCountry() : null, true));
		cashPoolTable.addCell(DealPDFStyle.createFormFieldCell("Cash Pool Region",  (legSummary != null) ? legSummary.getRegion() : null, false));
		cashPoolTable.addCell(DealPDFStyle.createFormFieldCell("Cash Pool Currency", (legSummary != null)? legSummary.getCurrencyCd() : null, false));	
		section.add(cashPoolTable);
		return this;
	}
	
	/**
	 * Renders the Derivatives Table as part of Transaction Summary of the deal.
	 * 
	 * @param derivatives
	 */
	private PdfPTable createDerivativesTableInTS(List<DerivativesRequest> derivatives) {
		PdfPTable derivativesTable = DealPDFStyle.createTable(5f, 9f, 9f, 7f, 10f, 9f, 7f, 10f, 9f, 12f, 13f);
		// Override style settings
		derivativesTable.setSpacingBefore(0f);
		derivativesTable.setWidthPercentage(100f);
		// Create first level column headers
		derivativesTable.addCell(DealPDFStyle.createDerivativeTableHeaderCell("Item No."));
		derivativesTable.addCell(DealPDFStyle.createDerivativeTableHeaderCell(DERIVATIVES));
		derivativesTable.addCell(DealPDFStyle.createDerivativeTableHeaderCell("Derivatives Type"));
		derivativesTable.addCell(DealPDFStyle.createDerivativeTableHeaderCell("Currency 1", 3));
		derivativesTable.addCell(DealPDFStyle.createDerivativeTableHeaderCell("Currency 2", 3));
		derivativesTable.addCell(DealPDFStyle.createDerivativeTableHeaderCell("Hedge Designation"));
		derivativesTable.addCell(DealPDFStyle.createDerivativeTableHeaderCell("Tax Designation"));
		
		// Create second level column headers
		derivativesTable.addCell(DealPDFStyle.createDerivativeTableHeaderCell(""));
		derivativesTable.addCell(DealPDFStyle.createDerivativeTableHeaderCell(""));
		derivativesTable.addCell(DealPDFStyle.createDerivativeTableHeaderCell(""));
		derivativesTable.addCell(DealPDFStyle.createDerivativeTableHeaderCell(CURRENCY_CAP));
		derivativesTable.addCell(DealPDFStyle.createDerivativeTableHeaderCell(AMOUNT));
		derivativesTable.addCell(DealPDFStyle.createDerivativeTableHeaderCell("Fixed/Float"));
		derivativesTable.addCell(DealPDFStyle.createDerivativeTableHeaderCell(CURRENCY_CAP));
		derivativesTable.addCell(DealPDFStyle.createDerivativeTableHeaderCell(AMOUNT));
		derivativesTable.addCell(DealPDFStyle.createDerivativeTableHeaderCell("Fixed/Float"));
		derivativesTable.addCell(DealPDFStyle.createDerivativeTableHeaderCell(""));
		derivativesTable.addCell(DealPDFStyle.createDerivativeTableHeaderCell(""));
		
		List<DerivativesRequest.CounterPartyInfo> counterParties = null;
		String intrestType = null;
		int count = 0;
		for(DerivativesRequest derivative : derivatives) {
			derivativesTable.addCell(DealPDFStyle.createTableDataCell(String.valueOf(++count)));
			String category = (derivative.getDeriativesCategoryId() != null && derivative.getDeriativesCategoryId()==1) ? INTERNAL : EXTERNAL;
			derivativesTable.addCell(DealPDFStyle.createTableDataCell(category));
			derivativesTable.addCell(DealPDFStyle.createTableDataCell(derivative.getDerivativeType()));
			counterParties = derivative.getCounterPartyInfos();
			
			if(counterParties.isEmpty()) {
				derivativesTable.addCell(DealPDFStyle.createTableDataCell(""));
				derivativesTable.addCell(DealPDFStyle.createTableDataCell(""));
				derivativesTable.addCell(DealPDFStyle.createTableDataCell(""));
				derivativesTable.addCell(DealPDFStyle.createTableDataCell(""));
				derivativesTable.addCell(DealPDFStyle.createTableDataCell(""));
				derivativesTable.addCell(DealPDFStyle.createTableDataCell(""));
			}
			
			Map<String, String> currencies = getMasterDataFactory().getDealCurrenciesMap();
			String currency = null;
			for(CounterPartyInfo counterParty : counterParties) {
				currency = currencies.get(counterParty.getCurrencyPair());
				derivativesTable.addCell(DealPDFStyle.createTableDataCell(currency));
				String counterPartyAmt = (counterParty.getAmt() != null) ? PDFReportHelper.formatCurrency(counterParty.getAmt()) : null; 
				derivativesTable.addCell(DealPDFStyle.createTableDataCell(counterPartyAmt));
				intrestType = (counterParty.getInterestTypeId() != null && counterParty.getInterestTypeId()==1) ? "Fixed" : "Float";
				derivativesTable.addCell(DealPDFStyle.createTableDataCell(intrestType));
			}
			
			derivativesTable.addCell(DealPDFStyle.createTableDataCell(derivative.getHedgeDesignationValue()));
			List<NameValue> taxDesignations = getReportContext().getStaticDataFactory().getTaxDesignation();
			String taxDesignation = null;
			if(derivative.getTaxDesignationId() != null) {
				for(NameValue eachTaxDesignation : taxDesignations) {
					if(eachTaxDesignation.getID().equals(derivative.getTaxDesignationId())) {
						taxDesignation = eachTaxDesignation.getName();
						break;
					}
				}
			}
			derivativesTable.addCell(DealPDFStyle.createTableDataCell(taxDesignation));
		}
		return derivativesTable;
	}
}
