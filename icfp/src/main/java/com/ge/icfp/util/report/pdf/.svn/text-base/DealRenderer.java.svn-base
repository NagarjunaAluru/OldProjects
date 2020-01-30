/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: DealRenderer.java
 * Purpose: file is used to holding leg attachments
 * 
 */
package com.ge.icfp.util.report.pdf;

import com.ge.icfp.action.ICFPException;
import com.ge.icfp.common.helper.ICFPCommonHelper;
import com.ge.icfp.common.helper.ICFPLegHelper;
import com.ge.icfp.model.DealRequest;
import com.ge.icfp.util.ProductType;
import com.ge.icfp.util.report.pdf.builder.Day1LegBuilder;
import com.ge.icfp.util.report.pdf.builder.Day2LegBuilder;
import com.ge.icfp.util.report.pdf.builder.DealPageBuilder;
import com.ge.icfp.util.report.pdf.builder.LegBuilder;
import com.hydus.wff.core.exception.HWFServiceException;
import com.hydus.wff.core.exception.HWFStubException;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Section;

/**
 * This class renders the PDF report for the current active deal.
 * 
 * @author chaitanya
 */
class DealRenderer {
	
	/**
	 * Creates the instance of this class for specified {@link ReportContext}.
	 * 
	 * @param context
	 * @return
	 */
	public static DealRenderer getInstance(ReportContext context) {
		return new DealRenderer(context);
	}
	
	private ReportContext context;
	private int chapterCounter;
	
	/**
	 * Constructor for creating this class with specified {@link ReportContext}
	 * 
	 * @param context
	 */
	private DealRenderer(ReportContext context) {
		this.context = context;
	}
	
	/**
	 * Returns the next chapter number of the report.
	 * 
	 * @return
	 */
	private int nextChapterNumber() {
		return ++chapterCounter;
	}

	/**
	 * This method renders the total PDF report for current deal.
	 * 
	 * @param context
	 * @throws DocumentException 
	 * @throws ICFPException 
	 * @throws HWFStubException 
	 * @throws HWFServiceException 
	 */
	void render() throws DocumentException, ICFPException, HWFServiceException, HWFStubException {
		Chapter chapter = DealPDFStyle.createChapter(null, nextChapterNumber());
		context.setCurrentChapter(chapter);
		DealRequest dealRequest = context.getDeal();
		DealPageBuilder dealPageBuilder = new DealPageBuilder(context);
		if(ICFPCommonHelper.isCPADeal(dealRequest)) {
			dealPageBuilder.appendCPADealSummary().appendCPATransactionSummary();
		} else {
			dealPageBuilder.appendDealSummary().appendTransactionSummary();
		}
		dealPageBuilder.appendTransactionPriorityAndTiming()
		.appendTransactionClassificationLevel()
		.appendDealTeam();
		if(ICFPCommonHelper.isCPADeal(dealRequest)) {
			dealPageBuilder.appendCashPoolDetails();
		}
		dealPageBuilder.appendExceptions()
		.appendQualitativeAssessment();
		context.getDocument().add(chapter);
		context.getDocument().newPage();
		
		
		int legCount = ICFPCommonHelper.getLegCount(dealRequest);
		Object leg = null;
		LegBuilder<?> legBuilder = null;
		Section legSection = null;
		Integer legSeqId = null;
		for(int legIndex = 1; legIndex <= legCount; legIndex++) {
			chapter = DealPDFStyle.createChapter(null, nextChapterNumber());
			context.setCurrentChapter(chapter);
			leg = ICFPCommonHelper.getLegByNumber(legIndex, dealRequest);
			legSeqId = ICFPLegHelper.getLegSeqId(leg);
			String legSectionTitle = new StringBuilder().append("Leg ID: ").append(legSeqId).toString();
			legSection = DealPDFStyle.createSection(legSectionTitle, chapter);
			context.setCurrentSection(legSection);
			
			legBuilder = LegBuilder.newLegBuilder(context, legIndex, leg);
			legBuilder.appendLegInfo();
			renderLeg(legBuilder);
			context.getDocument().add(chapter);
		}
		chapter = DealPDFStyle.createChapter(null, nextChapterNumber());
		context.setCurrentChapter(chapter);
		context.setCurrentSection(null);
		dealPageBuilder.appendRecommendations();
		context.getDocument().add(chapter);
		
		
	}
	
	/**
	 * This method is helper method to render the specified leg.
	 * 
	 * @param leg
	 * @throws ICFPException 
	 * @throws DocumentException 
	 * @throws HWFStubException 
	 * @throws HWFServiceException 
	 */
	private void renderLeg(LegBuilder<?> legBuilder) throws ICFPException, DocumentException, HWFServiceException, HWFStubException {
		if(PDFReportHelper.isImmediateDrawdownLeg(legBuilder.getLeg())) {
			renderImmediateDrawdownLeg((Day1LegBuilder)legBuilder);
		} else if(legBuilder.isDay2Leg()) {
			renderDay2Leg((Day2LegBuilder) legBuilder);
		} else {
			renderDay1Leg((Day1LegBuilder)legBuilder);
		}
		
		if(!legBuilder.isDay2Leg() && legBuilder.getProductType() == ProductType.EQUITY) {
			legBuilder.appendEquityProductDetails().appendEquityDetails();
		} else if(!legBuilder.isDay2Leg() && legBuilder.getProductType() != ProductType.CPA){
			legBuilder.appendProductDetails();
		}
		
		if(legBuilder.getProductType() == ProductType.OTHER) {
			legBuilder.appendOtherDescription();
		}
	}
	
	/**
	 * This method is helper method to render specified Day1 leg.
	 *  
	 * @param legBuilder
	 * @throws ICFPException 
	 * @throws DocumentException 
	 * @throws HWFStubException 
	 * @throws HWFServiceException 
	 */
	private void renderDay1Leg(Day1LegBuilder legBuilder) throws DocumentException, ICFPException, HWFServiceException, HWFStubException {
		ProductType productType = legBuilder.getProductType();
		if(productType != ProductType.CPA) {
			legBuilder.appendLenderInformation().appendBorrowerInformation();
		} else {
			legBuilder.appendParticipantInformation().appendPoolLeaderInformation();
		}
		
		if(productType == ProductType.RCA || productType == ProductType.BOND || productType == ProductType.TERM_LOAN || productType == ProductType.OTHER) {
			legBuilder.appendFeeAndWithholdingDetails().appendGuaranteeInformation();
		}
		
		if(productType != ProductType.EQUITY) {
			legBuilder.appendModelDriversInfo().appendScoresInfo();
			if(productType != ProductType.CPA) {
				legBuilder.appendPricingInfo();
			}
			legBuilder.appendSolvencyMetricsInfo();
		}
	}
	
	/**
	 * This is helper method to generate Immediate Drawdown leg.
	 * 
	 * @param legBuilder
	 * @throws ICFPException 
	 * @throws DocumentException 
	 */
	private void renderImmediateDrawdownLeg(Day1LegBuilder legBuilder) throws DocumentException, ICFPException {
		legBuilder.appendLenderInformation().appendBorrowerInformation();
	}
	
	/**
	 * This is helper method to generate Day2 leg.
	 * 
	 * @param leg
	 * @throws DocumentException 
	 * @throws ICFPException 
	 * @throws HWFStubException 
	 * @throws HWFServiceException 
	 */
	private void renderDay2Leg(Day2LegBuilder legBuilder) throws DocumentException, ICFPException, HWFServiceException, HWFStubException {
		switch(legBuilder.getProductType()) {
			case CPA:
				legBuilder.appendParticipantInformation().appendPoolLeaderInformation();
				break;
			case EQUITY:
				legBuilder.appendReceiverInformation().appendPayerInformation();
				break;
			case RCA:
			case TERM_LOAN:
			case BOND: 
				legBuilder.appendLenderInformation().appendBorrowerInformation();
				break;
		}
		
		if(!legBuilder.isEquityLeg()) {
			legBuilder.appendModelDriversInfo().appendScoresInfo();
			if(!legBuilder.isCPALeg()) {
				legBuilder.appendPricingInfo();
			}
			legBuilder.appendSolvencyMetricsInfo();
		}
		
		if(legBuilder.isCPALeg()) {
			legBuilder.appendCPAOriginalTransactionDetails();
		} else if(!legBuilder.isEquityLeg()) {
			legBuilder.appendOriginalTransactionDetails();
		}
		
		switch(legBuilder.getEventType()) {
			case CASHPOOL_TERMINATION:
				legBuilder.appendCPATermination();
				break;
			case CASHPOOL_OTHER:
				legBuilder.appendCPAOtherDetail();
				break;
			case ASSIGNMENT:
				legBuilder.appendAssignmentLenderInformation().appendAssignmentBorrowerInformation();
				break;
			case AMENDMENT_AGREMENT_EXTENSION:
				legBuilder.appendAgreementExtension();
				break;
			case AMENDMENT_FACILITY_INC_DEC:
				legBuilder.appendAmendFacilityIncDec();
				break;
			case GENERAL_AMENDMENT:
				legBuilder.appendGeneralAmendmentDetails();
				break;
			case PREPAYMENT:
				legBuilder.appendPrePayment();
				break;
			case DRAWDOWN:
				legBuilder.appendDrawDownDetails();
				break;
			case EARYLY_TERMINATION:
				legBuilder.appendEarlyTermination();
				break;
			case CORRECTION:
				legBuilder.appendCorrection();
				break;
			case DEBT_EQUITY_OTHER:
				legBuilder.appendEquityOtherDetail();
				break;
			case DEVIDENTS:
				legBuilder.appendDividends();
				break;
		}
	}
}
