/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: RequestReportRenderer.java
 * Purpose: This class renders the PDF report for the current active request
 * 
 */
package com.ge.aloc.reports.pdf.request;

import java.util.List;

import com.ge.aloc.InstrumentType;
import com.ge.aloc.UserRole;
import com.ge.aloc.model.RequestDetails;
import com.ge.aloc.reports.ALOCReportException;
import com.ge.aloc.reports.pdf.ALOCPDFReportHelper;
import com.ge.aloc.reports.pdf.ALOCPDFStyle;
import com.ge.aloc.reports.pdf.ReportContext;
import com.ge.aloc.reports.pdf.ReportRenderer;
import com.hydus.hwf.context.UserContext;
import com.hydus.hwf.exceptions.HWFServiceException;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.DocumentException;
import static com.ge.aloc.constants.ALOCConstants.TAXONOMY;
import static com.ge.aloc.constants.ALOCConstants.APPLICATION;
import static com.ge.aloc.constants.ALOCConstants.TREASURYAPPROVER;
import static com.ge.aloc.constants.ALOCConstants.BIDMEMO_BIDREPLY;

/**
 * This class renders the PDF report for the current active request.
 * 
 * @author chaitanya
 */
public class RequestReportRenderer extends ReportRenderer {

	/**
	 * This method renders the total PDF report for current request.
	 * 
	 * @param context
	 * @throws DocumentException 
	 * @throws ALOCReportException 
	 * @throws HWFServiceException 
	 */
	public void render(ReportContext context) throws DocumentException, ALOCReportException, HWFServiceException {
		RequestDetails requestDetails = context.getRequestDetails();
		Chapter chapter = ALOCPDFStyle.createChapter(null, nextChapterNumber());
		context.setCurrentChapter(chapter);
		RequestBuilder requestBuilder = new RequestBuilder(context);
		ALOCPDFReportHelper.setReportContext(context);

		List<String> userRoles = UserContext.getContext().getuserDetails().getRoles();
		InstrumentType instrumentType=InstrumentType.fromId(requestDetails.getInstrumentTypeId().intValue());
		switch(instrumentType) {
		case BANK_GUARANTEE:
			bankGuaranteyRender(context, userRoles,requestBuilder);
			break;
		case LOC:
			sblcRender(context, userRoles,requestBuilder);
			break;
		case SURETY_BOND:
			suretyBondRender(context, userRoles,requestBuilder);
			break;
		case DOCUMENT_LOC:
			documentLOCRender(context, userRoles,requestBuilder);
			break;
		case AMENDMENT:
			requestBuilder.appendAmendmentRequest();
			break;
		case RIDER:
			if(context.getReportName().equalsIgnoreCase(TREASURYAPPROVER)){
				requestBuilder.appendTreasuryApprovals();
			}else{
				requestBuilder.appendSuretyRiderRequest();
			}
			break;

		}
		context.getDocument().newPage();
		context.setCurrentSection(null);
		context.getDocument().add(chapter);
	}
	/**
	 * documentLOCRender to render Document letter of credit details
	 * @param context
	 * @param userRoles
	 * @param requestBuilder
	 * @throws HWFServiceException
	 * @throws DocumentException
	 */
	private void documentLOCRender(ReportContext context,List<String> userRoles, RequestBuilder requestBuilder) throws HWFServiceException, DocumentException {
		if(context.getReportName().equalsIgnoreCase(TAXONOMY)){

			if(userRoles.contains(UserRole.TreasuryAnalyst.getName()) || userRoles.contains(UserRole.TreasuryApprover.getName())) {
				requestBuilder.appendDLOCRequest().appendLinkedTransactions().appendBundleTransactions().appendAuditLogs().appendTransactionHistory().appendCompetingBidReplies();
			}else if(userRoles.contains(UserRole.ReadOnly.getName()) || userRoles.contains(UserRole.SiteAdmin.getName()) ||
					userRoles.contains(UserRole.BankOperations.getName()) || userRoles.contains(UserRole.BankReadOnly.getName()) ||
					userRoles.contains(UserRole.SuretyBrokerOperations.getName()) || userRoles.contains(UserRole.SuretyBrokerReadOnly.getName()) ||
					userRoles.contains(UserRole.Requestor.getName()) || userRoles.contains(UserRole.Approver.getName())){
				requestBuilder.appendDLOCRequest().appendLinkedTransactions().appendBundleTransactions().appendAuditLogs();
			}

		}else if(context.getReportName().equalsIgnoreCase(APPLICATION)){
			requestBuilder.appendDLOCRequest();
		}else if(context.getReportName().equalsIgnoreCase(BIDMEMO_BIDREPLY)){
			requestBuilder.appendDLocBidMemoRequestSummary().appendDlocBidMemoDetails().appendBankSelection().
			appendDLocBidReplyRequestSummary().appendBidReplyConfirmationFees().appendBidReplyProposedBankBranchToConfirm().appendBidReplyIndicativePricingInformation();
		}
		
	}
	/**
	 * suretyBondRender to render surety Bond details
	 * @param context
	 * @param userRoles
	 * @param requestBuilder
	 * @throws HWFServiceException
	 * @throws DocumentException
	 */
	private void suretyBondRender(ReportContext context,List<String> userRoles, RequestBuilder requestBuilder) throws HWFServiceException, DocumentException {
		if(context.getReportName().equalsIgnoreCase(TAXONOMY)){

			if(userRoles.contains(UserRole.TreasuryAnalyst.getName()) || userRoles.contains(UserRole.TreasuryApprover.getName())) {
				requestBuilder.appendSuretyBondRequest().appendRiders().appendLinkedTransactions().appendAuditLogs().appendTransactionHistory().appendCompetingBidReplies();
			}else if(userRoles.contains(UserRole.ReadOnly.getName()) || userRoles.contains(UserRole.SiteAdmin.getName()) ||
					userRoles.contains(UserRole.BankOperations.getName()) || userRoles.contains(UserRole.BankReadOnly.getName()) ||
					userRoles.contains(UserRole.SuretyBrokerOperations.getName()) || userRoles.contains(UserRole.SuretyBrokerReadOnly.getName()) ||
					userRoles.contains(UserRole.Requestor.getName()) || userRoles.contains(UserRole.Approver.getName())){
				requestBuilder.appendSuretyBondRequest().appendRiders().appendLinkedTransactions().appendAuditLogs();
			}

		}else if(context.getReportName().equalsIgnoreCase(APPLICATION)){
			requestBuilder.appendSuretyBondRequest();
		}else if(context.getReportName().equalsIgnoreCase(TREASURYAPPROVER)){
			requestBuilder.appendTreasuryApprovals();
		}
		
	}
	/**
	 *  sblcRender to render SBLC details
	 * @param context
	 * @param userRoles
	 * @param requestBuilder
	 * @throws HWFServiceException
	 * @throws DocumentException
	 */
	private void sblcRender(ReportContext context, List<String> userRoles,RequestBuilder requestBuilder) throws HWFServiceException, DocumentException {
		if(context.getReportName().equalsIgnoreCase(TAXONOMY)){

			if(userRoles.contains(UserRole.TreasuryAnalyst.getName()) || userRoles.contains(UserRole.TreasuryApprover.getName())) {
				requestBuilder.appendSBLCRequest().appendAmendments().appendFeeHisory().appendLinkedTransactions().appendBundleTransactions().appendAuditLogs().appendTransactionHistory().appendCompetingBidReplies();
			}else if(userRoles.contains(UserRole.ReadOnly.getName()) || userRoles.contains(UserRole.SiteAdmin.getName()) ||
					userRoles.contains(UserRole.BankOperations.getName()) || userRoles.contains(UserRole.BankReadOnly.getName()) ||
					userRoles.contains(UserRole.SuretyBrokerOperations.getName()) || userRoles.contains(UserRole.SuretyBrokerReadOnly.getName()) ||
					userRoles.contains(UserRole.Requestor.getName()) || userRoles.contains(UserRole.Approver.getName())){
				requestBuilder.appendSBLCRequest().appendAmendments().appendFeeHisory().appendLinkedTransactions().appendBundleTransactions().appendAuditLogs();
			}

		}else if(context.getReportName().equalsIgnoreCase(APPLICATION)){
			requestBuilder.appendSBLCRequest();
		}else if(context.getReportName().equalsIgnoreCase(BIDMEMO_BIDREPLY)){
			requestBuilder.appendBgBidreplyRequestSummary().appendBidResponseRequiredBy().appendBidMemoDeliveryInstructions().appendPricingDetails().appendBidMemoOneTimeFee().appendBankSelection().
			appendsbBidreplyDetails().appendsbBidreplyIssuingBank().appendPreAgreedPricingDetails().appendBidReplyOneTimeFee();
		}
		
	}
	/**
	 * bankGuaranteyRender to render BankGuarantey details
	 * @param context
	 * @param userRoles
	 * @param requestBuilder
	 * @throws HWFServiceException
	 * @throws DocumentException
	 */
	private void bankGuaranteyRender(ReportContext context,List<String> userRoles,RequestBuilder requestBuilder) throws HWFServiceException, DocumentException{
		if(context.getReportName().equalsIgnoreCase(TAXONOMY)){

			if(userRoles.contains(UserRole.TreasuryAnalyst.getName()) || userRoles.contains(UserRole.TreasuryApprover.getName())) {
				requestBuilder.appendBankGauranteeRequest().appendAmendments().appendFeeHisory().appendLinkedTransactions().appendBundleTransactions().appendAuditLogs().appendTransactionHistory().appendCompetingBidReplies();
			}else if(userRoles.contains(UserRole.ReadOnly.getName()) || userRoles.contains(UserRole.SiteAdmin.getName()) ||
					userRoles.contains(UserRole.BankOperations.getName()) || userRoles.contains(UserRole.BankReadOnly.getName()) ||
					userRoles.contains(UserRole.SuretyBrokerOperations.getName()) || userRoles.contains(UserRole.SuretyBrokerReadOnly.getName()) || 
					userRoles.contains(UserRole.Requestor.getName()) || userRoles.contains(UserRole.Approver.getName())){

				requestBuilder.appendBankGauranteeRequest().appendAmendments().appendFeeHisory().appendLinkedTransactions().appendBundleTransactions().appendAuditLogs();
			}

		}else if(context.getReportName().equalsIgnoreCase(APPLICATION)){
			requestBuilder.appendBankGauranteeRequest();
		}else if(context.getReportName().equalsIgnoreCase(BIDMEMO_BIDREPLY)){
			requestBuilder.appendBgBidreplyRequestSummary().appendBidResponseRequiredBy().appendBidMemoDeliveryInstructions().appendPricingDetails().appendBidMemoOneTimeFee().appendBankSelection().
			appendsbBidreplyDetails().appendsbBidreplyIssuingBank().appendPreAgreedPricingDetails().appendBidReplyOneTimeFee();
		}
		
	}
}
