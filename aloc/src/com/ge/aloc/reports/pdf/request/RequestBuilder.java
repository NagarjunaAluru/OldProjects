/*
 * Copyright © 2013 GE. ALL RIGHTS RESERVED.
 * FileName: RequestBuilder.java
 * Purpose: This class renders Request Page of the PDF report.
 */
package com.ge.aloc.reports.pdf.request;

import static com.ge.aloc.constants.ALOCConstants.GREATETHAN;
import static com.ge.aloc.constants.ALOCConstants.LESSTHAN;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.*;

import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.ge.aloc.ALOCContext;
import com.ge.aloc.InstrumentType;
import com.ge.aloc.StaticDataFactory;
import com.ge.aloc.bo.RequestDetailsBO;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.exception.ALOCException;
import com.ge.aloc.manager.impl.ALOCAttachmentManager;
import com.ge.aloc.model.ActionDetails;
import com.ge.aloc.model.ActionLog;
import com.ge.aloc.model.AdditionalInstrumentDetails;
import com.ge.aloc.model.AddressDtls;
import com.ge.aloc.model.AllinComissions;
import com.ge.aloc.model.Amendment;
import com.ge.aloc.model.AmendmentDetails;
import com.ge.aloc.model.ApproverLevel;
import com.ge.aloc.model.Attachment;
import com.ge.aloc.model.AttachmentPermission;
import com.ge.aloc.model.AuditLog;
import com.ge.aloc.model.BidReplyDetails;
import com.ge.aloc.model.BidmemoDetails;
import com.ge.aloc.model.BondDetails;
import com.ge.aloc.model.BundleDetails;
import com.ge.aloc.model.ConfirmationFees;
import com.ge.aloc.model.CurrentBankFees;
import com.ge.aloc.model.CurrentWinningBank;
import com.ge.aloc.model.DelegationApprovers;
import com.ge.aloc.model.DeliveryInstructions;
import com.ge.aloc.model.FeeHistoryDetails;
import com.ge.aloc.model.Format;
import com.ge.aloc.model.FullSummary;
import com.ge.aloc.model.GetAmendmentRiders;
import com.ge.aloc.model.IndicativePricingCompletedDetails;
import com.ge.aloc.model.InstrumentDetails;
import com.ge.aloc.model.IssuingBankDetails;
import com.ge.aloc.model.LocalComissions;
import com.ge.aloc.model.OneTimeFeesDetails;
import com.ge.aloc.model.OnetimeFees;
import com.ge.aloc.model.ParticipantBank;
import com.ge.aloc.model.PreAgreedPricingDetails;
import com.ge.aloc.model.PricingDetails;
import com.ge.aloc.model.ProposedBankBranchConfirmDetails;
import com.ge.aloc.model.RequestDetails;
import com.ge.aloc.model.RequestDetailsCollectionType;
import com.ge.aloc.model.Rider;
import com.ge.aloc.model.RiderDetails;
import com.ge.aloc.model.TransactionDetails;
import com.ge.aloc.model.TransactionParties;
import com.ge.aloc.model.WinnerDetails;
import com.ge.aloc.model.WinningBankDetails;
import com.ge.aloc.reports.pdf.ALOCPDFReportHelper;
import com.ge.aloc.reports.pdf.ALOCPDFStyle;
import com.ge.aloc.reports.pdf.ReportContext;
import com.hydus.hwf.exceptions.HWFServiceException;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPTable;

/**
 * This class provides logic to render deal page of the report.
 * 
 * @author chaitanya
 */
public class RequestBuilder {

	private final ReportContext reportContext;
	private RequestDetails requestDetails;

	/**
	 * Constructor to instantiate the object.
	 * @param context
	 */
	public RequestBuilder(ReportContext context) {
		this.reportContext = context;
		this.requestDetails = context.getRequestDetails();
	}

	/**
	 * Renders the PDF of the BankGauranteeRequest.
	 * @return
	 * @throws DocumentException 
	 */
	public RequestBuilder appendBankGauranteeRequest() throws DocumentException {
		BankAndSBLCBuilder bankAndSBLCBuilder = new BankAndSBLCBuilder(reportContext);
		appendRequestSummary();
		bankAndSBLCBuilder.appendTransactionParties().appendTriPartyApplicant().appendTpApplicantDetails().appendCustomerDetails().
		appendProjectDescription().appendInstrumentDetails().appendInstrumentRisk().appendInstrReporting();
		appendDeliveryInstructions();
		bankAndSBLCBuilder.appendReimbursementAgreement();
		return this;
	}

	/**
	 * Renders the PDF of the SBLCRequest.
	 * @return
	 * @throws DocumentException 
	 */
	public RequestBuilder appendSBLCRequest() throws DocumentException {
		BankAndSBLCBuilder bankAndSBLCBuilder = new BankAndSBLCBuilder(reportContext);
		appendRequestSummary();
		bankAndSBLCBuilder.appendTransactionParties().appendTpApplicantDetails().appendTriPartyApplicant().appendCustomerDetails().
		appendProjectDescription().appendInstrumentDetails().appendInstrumentRisk().appendStandByLetterOfCredit().appendInstrReporting();
		appendDeliveryInstructions();
		bankAndSBLCBuilder.appendReimbursementAgreement();

		return this;
	}

	/**
	 * Renders the PDF of the SuretyBondRequest.
	 * @return
	 * @throws DocumentException 
	 */
	public RequestBuilder appendSuretyBondRequest() throws DocumentException {
		SuretyBondBuilder suretyBondBuilder = new SuretyBondBuilder(reportContext);
		appendRequestSummary();
		suretyBondBuilder.appendBonddetails().appendPrincipal().appendObligee().appendRequestorMailingAddress();
		appendDeliveryInstructions();

		BondDetails bondDet = requestDetails.getBondDetails();
		BigInteger  bondTypeId = (bondDet!=null) ? bondDet.getBondTypeId() : null;

		if(bondTypeId != null && (bondTypeId.equals(BigInteger.valueOf(ALOCConstants.BIDBOND_ID)))){
			suretyBondBuilder.appendBidBondInformation();
		}else if(bondTypeId != null && (bondTypeId.equals(BigInteger.valueOf(ALOCConstants.CONTRACTBOND_ID)))){
			suretyBondBuilder.appendContractBondInformation();
		}else if(bondTypeId != null && (bondTypeId.equals(BigInteger.valueOf(ALOCConstants.LICENCE_BOND_ID)))){
			suretyBondBuilder.appendLicenseBondInformation();
		}else if(bondTypeId != null && (bondTypeId.equals(BigInteger.valueOf(ALOCConstants.COURT_BOND_ID)))){
			suretyBondBuilder.appendCourtBondInformation().appendAttorneyInformation();
		}else if(bondTypeId != null && (bondTypeId.equals(BigInteger.valueOf(ALOCConstants.CUST_BOND_ID)))){
			suretyBondBuilder.appendCustomsBondInformation();
		}

		return this;
	}

	/**
	 * Renders the PDF of the SuretyBondRequest.
	 * @return
	 * @throws DocumentException 
	 */
	public RequestBuilder appendDLOCRequest() throws DocumentException {
		DLOCRequestBuilder dLOCRequestBuilder = new DLOCRequestBuilder(reportContext);
		appendRequestSummary();
		dLOCRequestBuilder.appendBusinessContactPerson().appendIssuingBank().appendApplicantDetails().appendBeneficiaryDetails()
		.appendInstrumentTransactionDetails().appendPaymentSchedule();

		return this;
	}

	/**
	 * Renders the PDF of the AmendmentRequest.
	 * @return
	 * @throws DocumentException 
	 */
	public RequestBuilder appendAmendmentRequest() throws DocumentException {
		AmendmentBuilder amendmentBuilder = new AmendmentBuilder(reportContext);
		appendRequestSummary();
		amendmentBuilder.appendAmendmentExpirationDates().appendAmendmentInstrumentAmountCurrency().
		appendAmendmentTransactionParties().appendAmendmentTriPartyApplicant().appendAmendmentApplicantDetails().
		appendAmendmentCustomerDetails().appendAmendmentOtherChanges().appendAmendmentDeliveryInstructions();

		return this;	
	}

	/**
	 * Renders the PDF of the SuretyRider Request.
	 * @return
	 * @throws DocumentException 
	 */
	public RequestBuilder appendSuretyRiderRequest() throws DocumentException {
		SuretyRiderBuilder suretyRiderBuilder = new SuretyRiderBuilder(reportContext);
		appendRequestSummary();
		suretyRiderBuilder.appendSuretyRiderPrincipal().appendSuretyRiderObligee().appendRiderExpirationDate()
		.appendRiderBondInfo().appendRiderDeliveryInstructions();

		return this;
	}

	/**
	 * Renders the Summary of the request.
	 * @return
	 * @throws DocumentException 
	 */
	public RequestBuilder appendRequestSummary() throws DocumentException {
		String reqSummaryTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_REQ_SUMMARY);
		PdfPTable requestSummary;
		PdfPTable requestSummary2;
		requestSummary2 = ALOCPDFStyle.createSummaryTable(ALOCConstants.NUM_ONE);
		Section section = ALOCPDFStyle.createSection(reqSummaryTitle, reportContext.getCurrentChapter());

		if(requestDetails.getInstrumentTypeId().equals(BigInteger.valueOf(ALOCConstants.CUST_BOND_ID))){
			requestSummary = ALOCPDFStyle.createSummaryTable(ALOCConstants.THREE_COLUMNS);
		}else{
			requestSummary = ALOCPDFStyle.createSummaryTable(ALOCConstants.FOUR_COLUMNS);
		}
		String requestorFiledTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_REQUESTOR);
		List<String> requestorFieldValues = new ArrayList<String>();
		StringBuilder fullName = new StringBuilder();
		if(StringUtils.isNotBlank(requestDetails.getRequestSummary().getRequestor().getLastName())) {
			fullName.append(requestDetails.getRequestSummary().getRequestor().getLastName());
		}
		if(StringUtils.isNotBlank(requestDetails.getRequestSummary().getRequestor().getFirstName())) {
			if(fullName.length() > ALOCConstants.BASE_VALUE) {
				fullName.append(ALOCConstants.COMMA_SPACE);
			}
			fullName.append(requestDetails.getRequestSummary().getRequestor().getFirstName());
		}
		requestorFieldValues.add(fullName.toString());
		requestorFieldValues.add(requestDetails.getRequestSummary().getRequestor().getSsoId());
		requestSummary.addCell(ALOCPDFStyle.createMultiRowSummaryFieldCell(requestorFiledTitle, requestorFieldValues, false));

		if(requestDetails.getInstrumentTypeId().equals(BigInteger.valueOf(InstrumentType.AMENDMENT.getId()))){
			Amendment amendment = requestDetails.getAmendment();
			String amdSeqNumberTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_AMDSEQUENCE_NUMBER);
			String amdSeqNumber = (amendment!=null) ? amendment.getAmendmentRequestId() : null;
			requestSummary.addCell(ALOCPDFStyle.createSummaryFieldCell(amdSeqNumberTitle, amdSeqNumber, false));

			String bankRefNumberTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_BANKREF_NUMBER);
			String bankRefNumber = (amendment != null) ? amendment.getBankReferenceNumber() : null;
			requestSummary.addCell(ALOCPDFStyle.createSummaryFieldCell(bankRefNumberTitle, bankRefNumber, false));
		}else if(requestDetails.getInstrumentTypeId().equals(BigInteger.valueOf(InstrumentType.RIDER.getId()))){
			Rider rider = requestDetails.getRider();
			
			String recordNumTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_ALOC_RECORD_NUMBER);
			requestSummary.addCell(ALOCPDFStyle.createSummaryFieldCell(recordNumTitle, requestDetails.getAlocRecordId(), false));
			String riderSeqNumTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_RIDERSEQ_NUMBER);
			String riderSeqNumber = (rider != null) ? rider.getRiderRequestId() : null;
			requestSummary.addCell(ALOCPDFStyle.createSummaryFieldCell(riderSeqNumTitle, riderSeqNumber, false));

			String bondtypeTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_BONDTYPE_SUBTYPE);
			StringBuilder bondValue = new StringBuilder();
			String bondTypeSubType = null;
			if(requestDetails.getBondDetails().getBondType() != null){
				bondValue.append(requestDetails.getBondDetails().getBondType());
			}
			if(requestDetails.getBondDetails().getBondSubType() != null){
				bondValue.append(ALOCConstants.EMPTYSPACE_HYPEN_EMPTYSPACE);
				bondValue.append(requestDetails.getBondDetails().getBondSubType());	
			}
			if(bondValue != null){
				bondTypeSubType = bondValue.toString();
			}
			requestSummary.addCell(ALOCPDFStyle.createSummaryFieldCell(bondtypeTitle, bondTypeSubType, false));
		}else{
			String recordNumTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_ALOC_RECORD_NUMBER);
			requestSummary.addCell(ALOCPDFStyle.createSummaryFieldCell(recordNumTitle,requestDetails.getAlocRecordId(), false));

			String linkedTransactionTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_LINKED_TRANSACTION_ID);
			String linkedTransactionValue = requestDetails.getRequestSummary().getLinkedTransactionId();
			requestSummary.addCell(ALOCPDFStyle.createSummaryFieldCell(linkedTransactionTitle, linkedTransactionValue, false));

			String modelCodeTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_MODEL_CODE);
			String modelCodeValue = (requestDetails.getRequestSummary() != null) ? requestDetails.getRequestSummary().getModelCode(): null;
			requestSummary.addCell(ALOCPDFStyle.createSummaryFieldCell(modelCodeTitle, modelCodeValue, false));
		}
		section.add(requestSummary);
		if(requestDetails.getInstrumentTypeId().equals(BigInteger.valueOf(InstrumentType.RIDER.getId()))){
			WinnerDetails winnerDetails = requestDetails.getWinningBankDetails() != null ? requestDetails.getWinningBankDetails().getWinnerDetails() : null;
			String sbRefNumberTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_SB_REF_NUMBER);
			String sbRefNumber = (winnerDetails != null) ? winnerDetails.getBankReferenceNumber() : null;
			requestSummary2.addCell(ALOCPDFStyle.createSummaryFieldCell(sbRefNumberTitle, sbRefNumber, false));
			section.add(requestSummary2);
		}
		return this;
	}

	/**
	 * This method is used to append Delivery Instructions details section of BG,SBLC and Surety Bond request
	 * @return
	 */
	public RequestBuilder appendDeliveryInstructions() throws DocumentException{
		DeliveryInstructions deliveryInstructions = requestDetails.getDeliveryInstructions();
		String deliveryInstructionsTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_DELIVERY_INSTRUCTIONS);
		Section section = ALOCPDFStyle.createSection(deliveryInstructionsTitle, reportContext.getCurrentChapter());
		PdfPTable deliveryInstructionsTable = ALOCPDFStyle.createSectionDataTable();
		if(requestDetails.getInstrumentTypeId() != null && requestDetails.getInstrumentTypeId().intValue() != ALOCConstants.NUM_THREE){
			String desigSwiftTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_DELIVERY_DESIGNATION_SWIFT);
			String desigSwiftValue = (deliveryInstructions != null) ? deliveryInstructions.getDeliveryDesignationFlag(): null;
			deliveryInstructionsTable.addCell(ALOCPDFStyle.createSectionDataCell(desigSwiftTitle, desigSwiftValue));
		}
		String deliverTypeTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_DELIVER_TYPE);
		String deliverType = (deliveryInstructions != null) ? deliveryInstructions.getDeliveryType(): null;
		if (deliverType != null) {
			String deliverTypevalue=null;
			if (deliverType.equals(ALOCPDFReportHelper.getResourceValue(RES_KEY_TRUE))) {
				deliverTypevalue = ALOCPDFReportHelper.getResourceValue(RES_KEY_INPERSON_PICKUP);
			} else if (deliverType.equals(ALOCPDFReportHelper.getResourceValue(RES_KEY_FALSE))) {
				deliverTypevalue = ALOCPDFReportHelper.getResourceValue(RES_KEY_PHYSICAL_DELIVERY);
			}
			deliveryInstructionsTable.addCell(ALOCPDFStyle.createSectionDataCell(deliverTypeTitle, deliverTypevalue));
		}
		if (deliverType != null && deliverType.equals(ALOCPDFReportHelper.getResourceValue(RES_KEY_FALSE))) {
			String previousDetailsTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_USE_PREVIOUS_ADDRESS);
			String previousDetailsValue = (deliveryInstructions != null) ? deliveryInstructions.getUsePreviousAddress(): null;
			deliveryInstructionsTable.addCell(ALOCPDFStyle.createSectionDataCell(previousDetailsTitle, previousDetailsValue));
		}
		String companyNameTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_COMPANYNAME);
		String companyNameValue = (deliveryInstructions != null) ? deliveryInstructions.getCompanyName(): null;
		deliveryInstructionsTable.addCell(ALOCPDFStyle.createSectionDataCell(companyNameTitle, companyNameValue));
		String recipientFirstNameTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_RECIPIENT_FIRSTNAME);
		String recipientFirstNameValue = (deliveryInstructions != null) ? deliveryInstructions.getFirstName(): null;
		deliveryInstructionsTable.addCell(ALOCPDFStyle.createSectionDataCell(recipientFirstNameTitle, recipientFirstNameValue));
		String recipientLastNameTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_RECIPIENT_LASTNAME);
		String recipientLastNameValue = (deliveryInstructions != null) ? deliveryInstructions.getLastName(): null;
		deliveryInstructionsTable.addCell(ALOCPDFStyle.createSectionDataCell(recipientLastNameTitle, recipientLastNameValue));
		String otherTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_TITLE);
		String otherTitleValue = (deliveryInstructions != null) ? deliveryInstructions.getTitle(): null;
		deliveryInstructionsTable.addCell(ALOCPDFStyle.createSectionDataCell(otherTitle, otherTitleValue));
		deliveryInstructionsTable=addDeliveryTypeAddress(deliveryInstructions,deliveryInstructionsTable);
		String phoneTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_PHONE_NUMBER);
		String phoneNumValue = (deliveryInstructions != null) ? deliveryInstructions.getPhoneNo(): null;
		deliveryInstructionsTable.addCell(ALOCPDFStyle.createSectionDataCell(phoneTitle, phoneNumValue));
		if(requestDetails.getInstrumentTypeId() != null && requestDetails.getInstrumentTypeId().intValue() == ALOCConstants.NUM_THREE){
			String specialInstTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_SPECIAL_INSTRUCTIONS);
			String specialInstValue = (deliveryInstructions != null) ? deliveryInstructions.getSpecialInstructions(): null;
			deliveryInstructionsTable.addCell(ALOCPDFStyle.createSectionDataCell(specialInstTitle, specialInstValue));
		}
		String sendElecTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_SEND_ELECTRONIC_COPYTOMYSELF);
		String sendEcopyMyselfValue = (deliveryInstructions != null) ? ALOCPDFReportHelper.convertStringAsYesOrNo(deliveryInstructions.getEcopyMyself()) : null;
		deliveryInstructionsTable.addCell(ALOCPDFStyle.createSectionDataCell(sendElecTitle, sendEcopyMyselfValue));
		deliveryInstructionsTable=addGeRecipientDetails(deliveryInstructions,deliveryInstructionsTable);
		section.add(deliveryInstructionsTable);
		return this;
	}
	/**
	 * addGeRecipientDetails to add GeRecipientDetails to pdf doc.
	 * @param deliveryInstructions
	 * @param deliveryInstructionsTable
	 */
	private PdfPTable addGeRecipientDetails(DeliveryInstructions deliveryInstructions,PdfPTable deliveryInstructionsTable) {
		String sendelecGerecipTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_SEND_ELECTRONIC_COPYTO_GERECIPIENT);
		String sendelecGerecipValue = (deliveryInstructions != null) ? ALOCPDFReportHelper.convertStringAsYesOrNo(deliveryInstructions.getEcopyOtherGEPerson()) : null;
		deliveryInstructionsTable.addCell(ALOCPDFStyle.createSectionDataCell(sendelecGerecipTitle, sendelecGerecipValue));
		String geRecipientTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_GERECIPIENT);
		String geRecipientEmailTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_GERECIPIENT_EMAIL);
		if(sendelecGerecipValue != null&&sendelecGerecipValue.equals(ALOCPDFReportHelper.getResourceValue(RES_KEY_YES_CAP)) &&deliveryInstructions.getRecipient()!=null){
			StringBuilder fullName = new StringBuilder();
			if(StringUtils.isNotBlank(deliveryInstructions.getRecipient().getRecipientLastName())) {
				fullName.append(deliveryInstructions.getRecipient().getRecipientLastName());
			}
			if(StringUtils.isNotBlank(deliveryInstructions.getRecipient().getRecipientFirstName())) {
				if(fullName.length() > ALOCConstants.BASE_VALUE) {
					fullName.append(ALOCConstants.COMMA_SPACE);
				}
				fullName.append(deliveryInstructions.getRecipient().getRecipientFirstName());
				if(fullName.length() > ALOCConstants.BASE_VALUE) {
					fullName.append(ALOCConstants.EMPTYSPACE_HYPEN_EMPTYSPACE);
				}
				fullName.append(deliveryInstructions.getRecipient().getRecipientSsoId());
			}
			deliveryInstructionsTable.addCell(ALOCPDFStyle.createSectionDataCell(geRecipientTitle, fullName.toString()));
			deliveryInstructionsTable.addCell(ALOCPDFStyle.createSectionDataCell(geRecipientEmailTitle, deliveryInstructions.getRecipient().getRecipientEmail()));
		}
		return deliveryInstructionsTable;
	}

	/**
	 * addDeliveryTypeAddress to add DeliveryType Address to pdf doc.
	 * @param deliveryInstructions
	 * @param deliveryInstructionsTable
	 */
	private PdfPTable addDeliveryTypeAddress(DeliveryInstructions deliveryInstructions,PdfPTable deliveryInstructionsTable) {
		if (deliveryInstructions.getDeliveryType() != null && deliveryInstructions.getDeliveryType().equals(ALOCPDFReportHelper.getResourceValue(RES_KEY_FALSE))) {
			String address1Title = ALOCPDFReportHelper.getResourceValue(RES_KEY_ADDRESS1);
			String address1Value = (deliveryInstructions != null) ? deliveryInstructions.getAddress1(): null;
			deliveryInstructionsTable.addCell(ALOCPDFStyle.createSectionDataCell(address1Title, address1Value));
			String address2Title = ALOCPDFReportHelper.getResourceValue(RES_KEY_PHONE_ADDRESS2_OPTIONAL);
			String address2Value = (deliveryInstructions != null) ? deliveryInstructions.getAddress2(): null;
			deliveryInstructionsTable.addCell(ALOCPDFStyle.createSectionDataCell(address2Title, address2Value));
			String cityTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_CITY);
			String cityValue = (deliveryInstructions != null) ? deliveryInstructions.getCity(): null;
			deliveryInstructionsTable.addCell(ALOCPDFStyle.createSectionDataCell(cityTitle, cityValue));
			String sateTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_STATE);
			String stateValue = (deliveryInstructions != null) ? deliveryInstructions.getStateProvince(): null;
			deliveryInstructionsTable.addCell(ALOCPDFStyle.createSectionDataCell(sateTitle, stateValue));
			String zipCodeTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_ZIPCODE);
			String zipCodeValue = (deliveryInstructions != null) ? deliveryInstructions.getZIPPostalcode(): null;
			deliveryInstructionsTable.addCell(ALOCPDFStyle.createSectionDataCell(zipCodeTitle, zipCodeValue));
			String countryTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_COUNTRY);
			String countryValue = (deliveryInstructions != null) ? deliveryInstructions.getCountry(): null;
			deliveryInstructionsTable.addCell(ALOCPDFStyle.createSectionDataCell(countryTitle, countryValue));
		}
		return deliveryInstructionsTable;
		
	}

	/**
	 * This is append Format section for All Requests
	 * @return
	 */
	public RequestBuilder appendFormat() throws HWFServiceException,ALOCException{

		Format formatDetails = requestDetails.getFormat();
		String formatDetailsTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_FORMAT);		
		Section section = ALOCPDFStyle.createSection(formatDetailsTitle,reportContext.getCurrentChapter());
		PdfPTable formatDetailsTable = ALOCPDFStyle.createSectionDataTable();
		PdfPTable formatTable;
		String formatValue;

		String formatSelectionTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_FORMAT_SELECTION);
		String formatSelectionValue = (formatDetails != null) ? formatDetails.getFormatType(): null;
		formatDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(formatSelectionTitle, formatSelectionValue));

		String formatTypeId = (formatDetails!=null) ? formatDetails.getFormatTypeId() : null;
		if(formatDetails!=null && formatTypeId != null && formatTypeId.equalsIgnoreCase(ALOCConstants.STANDARD_FORMAT)){
			formatTable = ALOCPDFStyle.createTable(100f);
			formatTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_FORMAT_STANDARDFORMAT)));
			if(formatDetails != null && formatDetails.getAttachments() != null && formatDetails.getAttachments().get(ALOCConstants.BASE_VALUE) != null){
				ALOCAttachmentManager alocAttachmentManager = new ALOCAttachmentManager();
				ByteArrayOutputStream tempStream = new ByteArrayOutputStream();
				Attachment attachment= formatDetails.getAttachments().get(ALOCConstants.BASE_VALUE);
				alocAttachmentManager.downloadAttachment(tempStream, attachment);
				formatValue = tempStream.toString();
				formatTable.addCell(ALOCPDFStyle.createTableDataCell(formatValue));
			}
		}else if(formatDetails!=null && formatTypeId != null && formatTypeId.equalsIgnoreCase(ALOCConstants.MODIFIED_FORMAT)){
			formatTable = ALOCPDFStyle.createTable(100f);
			formatTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_FORMAT_MODIFYFORMAT)));
			if(formatDetails != null && formatDetails.getAttachments() != null && formatDetails.getAttachments().get(ALOCConstants.BASE_VALUE) != null){
				ALOCAttachmentManager alocAttachmentManager = new ALOCAttachmentManager();
				ByteArrayOutputStream tempStream = new ByteArrayOutputStream();
				Attachment attachment= formatDetails.getAttachments().get(ALOCConstants.BASE_VALUE);
				alocAttachmentManager.downloadAttachment(tempStream, attachment);
				formatValue = tempStream.toString();
				formatTable.addCell(ALOCPDFStyle.createTableDataCell(formatValue));
			}
		}else{
			formatTable = ALOCPDFStyle.createTable(50f, 50f);
			formatTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_PERMISSIONS)));
			formatTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_DOCUMENTS)));
			List<Attachment> Attachments =formatDetails.getAttachments();
			StringBuilder permissions = new StringBuilder();
			for(Attachment attachment : Attachments) {
				List<AttachmentPermission> attachmentPermissions = attachment.getAttachmentPermissions();
				for(AttachmentPermission attachmentPermission : attachmentPermissions){
					if(attachmentPermission.getPermissionName() != null && attachmentPermission.getPermissionName().length() > ALOCConstants.MIN_VALUE){
						permissions.append(LESSTHAN);
						permissions.append(attachmentPermission.getPermissionName());
						permissions.append(GREATETHAN);
					}
				}
				if(permissions != null){
					String permissionsValue = permissions.toString();
					formatTable.addCell(ALOCPDFStyle.createTableDataCell(permissionsValue));
				}
				String document = (attachment != null) ? attachment.getAttachmentName() : null;
				formatTable.addCell(ALOCPDFStyle.createTableDataCell(document));
			}
		}
		section.add(formatDetailsTable);
		section.add(formatTable);
		return this;
	}

	/**
	 * This is append Attachment section for All Requests
	 * @return
	 */
	public RequestBuilder appendAttachment() {

		List<Attachment> attachmentDetails = requestDetails.getAttachments();
		String attachmentDetailsTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_ATTACHMENTS);		
		Section section = ALOCPDFStyle.createSection(attachmentDetailsTitle,reportContext.getCurrentChapter());
		PdfPTable attachmentDetailsTable = ALOCPDFStyle.createSectionDataTable();
		StringBuilder permissions = new StringBuilder();

		PdfPTable attachmentTable = ALOCPDFStyle.createTable(50f, 50f);
		attachmentTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_PERMISSIONS)));
		attachmentTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_DOCUMENTS)));

		for(Attachment attachment : attachmentDetails) {
			List<AttachmentPermission> attachmentPermissions = attachment.getAttachmentPermissions();
			for(AttachmentPermission attachmentPermission : attachmentPermissions){
				if(attachmentPermission.getPermissionName() != null && attachmentPermission.getPermissionName().length() > ALOCConstants.MIN_VALUE){
					permissions.append(LESSTHAN);
					permissions.append(attachmentPermission.getPermissionName());
					permissions.append(GREATETHAN);
				}
			}
			if(permissions != null){
				String permissionsValue = permissions.toString();
				attachmentTable.addCell(ALOCPDFStyle.createTableDataCell(permissionsValue));
			}
			String document = (attachment != null) ? attachment.getAttachmentName() : null;
			attachmentTable.addCell(ALOCPDFStyle.createTableDataCell(document));
			permissions.setLength(ALOCConstants.BASE_VALUE);			 
		}
		section.add(attachmentDetailsTable);
		section.add(attachmentTable);
		return this;
	}

	/**
	 * Renders the summary of the request.
	 * @return
	 * @throws DocumentException
	 */
	public RequestBuilder appendBidMemoDetails() {
		RequestDetailsBO requestDetailsBO = ALOCContext.getActiveRequest();
		BidmemoDetails bidmemoDetails = requestDetails.getBidmemoDetails();
		String bidMemoDetailsTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_BIDMEMODETAILS);
		Section section = ALOCPDFStyle.createSection(bidMemoDetailsTitle, reportContext.getCurrentChapter());
		PdfPTable bidMemoDetailsTable = ALOCPDFStyle.createSectionDataTable();

		String bidCreatedDateTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_BIDCREATED_DATE);
		String bidCreatedDate = (bidmemoDetails != null) ?ALOCPDFReportHelper.formatDate(bidmemoDetails.getDateBidMemoCreated()) : null;
		bidMemoDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(bidCreatedDateTitle, bidCreatedDate));

		String bidExpDateTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_EXPIRATION_DATE);
		String bidExpDate = ( bidmemoDetails!= null) ?  ALOCPDFReportHelper.formatDate(bidmemoDetails.getExpirationDateTime()) : null;
		bidMemoDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(bidExpDateTitle, bidExpDate));

		String bidExpTimeTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_EXPIRATIONTIME);
		String bidExpTime = ( requestDetailsBO.getBidMemoDetailsBO()!= null) ?  requestDetailsBO.getBidMemoDetailsBO().getExpirationTime() : null;
		bidMemoDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(bidExpTimeTitle, bidExpTime));

		section.add(bidMemoDetailsTable);
		return this;
	}

	/**
	 * This method is used to append Bank Selection Details
	 * @return
	 * @throws DocumentException
	 */
	public RequestBuilder appendBankSelection() {
		String bankSelectionTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_BANK_SELECTION);
		Section section = ALOCPDFStyle.createSection(bankSelectionTitle, reportContext.getCurrentChapter());
		PdfPTable winningBankTable = ALOCPDFStyle.createSectionDataTable();
		String selectedBanksTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_SELECTED_BANKS);
		WinningBankDetails winningBankDetails = requestDetails.getWinningBankDetails();
		String winningBankName = null;
		if(winningBankDetails != null && winningBankDetails.getWinnerDetails()!= null){
		 winningBankName = winningBankDetails.getWinnerDetails().getWinningBankName();
		}
		winningBankTable.addCell(ALOCPDFStyle.createSectionDataCell(selectedBanksTitle, winningBankName));
		section.add(winningBankTable);
		return this;
	}
	
	/**
	 * Renders the Issuing bank branch of Bid reply.
	 * @return
	 * @throws DocumentException 
	 */
	public RequestBuilder appendsbBidreplyIssuingBank() throws DocumentException {

		String issuingBankTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_ISSUING_BANK_BRANCH);
		Section section = ALOCPDFStyle.createSection(issuingBankTitle, reportContext.getCurrentChapter());
		PdfPTable issuingBankTable = ALOCPDFStyle.createSectionDataTable();
		IssuingBankDetails issuingBankDetails = requestDetails.getIssuingBankDetails();

		String nameandAddressTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_BANK_NAME);
		AddressDtls addressDtls = (issuingBankDetails != null) ? issuingBankDetails.getAddressDtls() : null;
		String address1 = null;
		String address2 = null;
		if (addressDtls != null && addressDtls.getAddress() != null
				&& !addressDtls.getAddress().isEmpty()) {
			if (addressDtls.getAddress().get(ALOCConstants.BASE_VALUE) != null) {
				address1 = addressDtls.getAddress().get(ALOCConstants.BASE_VALUE);
			}
			if (addressDtls.getAddress().size() > ALOCConstants.MIN_VALUE
					&& addressDtls.getAddress().get(ALOCConstants.MIN_VALUE) != null) {
				address2 = addressDtls.getAddress().get(ALOCConstants.MIN_VALUE);
			}
		}
		String city = addressDtls != null ? addressDtls.getCity() : null;
		String state = addressDtls != null ? addressDtls.getStateProvince() : null;
		String zipCode = addressDtls != null ? addressDtls.getZIPPostalCode() : null;
		String country = addressDtls != null ? addressDtls.getCountry() : null; 
		String bankName= (issuingBankDetails!=null) ? issuingBankDetails.getBankName() :null;
		String [] addressValues= {bankName,address1,address2,city,state,zipCode,country};
		issuingBankTable.addCell(ALOCPDFStyle.createSectionDataCell(nameandAddressTitle, addressValues));
		String usExpirationTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_USEXPIRATION_DATE);
		String usExpirationDateValue= (issuingBankDetails!=null) ? ALOCPDFReportHelper.formatDate(issuingBankDetails.getUSExpirationDate()) :null;
		issuingBankTable.addCell(ALOCPDFStyle.createSectionDataCell(usExpirationTitle, usExpirationDateValue));
		section.add(issuingBankTable);
		return this;
	}

	/**
	 * Renders the Bid reply details of surety bond request.
	 * @return
	 * @throws DocumentException 
	 */
	public RequestBuilder appendsbBidreplyDetails() throws DocumentException {

		String bidReplyTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_BIDREPLY_DETAILS);
		Section section = ALOCPDFStyle.createSection(bidReplyTitle, reportContext.getCurrentChapter());
		PdfPTable bidReplyTable = ALOCPDFStyle.createSectionDataTable();

		BidReplyDetails bidReplyDetails = requestDetails.getBidReplyDetails();

		String bidExpirationDateTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_BID_EXPIRATION_DATE);
		String bidExpirationDateValue= (bidReplyDetails!=null) ? ALOCPDFReportHelper.formatDate(bidReplyDetails.getBidExpirationDate()) :null;
		bidReplyTable.addCell(ALOCPDFStyle.createSectionDataCell(bidExpirationDateTitle, bidExpirationDateValue));
		String pricingExpirationTimeTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_BIDREPLY_EXP_TIME);
		String pricingExpirationTimeValue= (bidReplyDetails!=null) ?  ALOCPDFReportHelper.formatTime(bidReplyDetails.getBidExpirationTime()) :null;
		bidReplyTable.addCell(ALOCPDFStyle.createSectionDataCell(pricingExpirationTimeTitle, pricingExpirationTimeValue));
		String issuanceStructureTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_ISSUANCE_STRUCTURE);
		String issuanceStructureValue= (bidReplyDetails!=null) ? bidReplyDetails.getIssuanceTypeFlag()  :null;
		bidReplyTable.addCell(ALOCPDFStyle.createSectionDataCell(issuanceStructureTitle, issuanceStructureValue));

		String notesTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_BIDREPLY_NOTES);
		String notesValue= (bidReplyDetails!=null) ? bidReplyDetails.getNotes() :null;
		bidReplyTable.addCell(ALOCPDFStyle.createSectionDataCell(notesTitle, notesValue));

		section.add(bidReplyTable);
		return this;
	}

	/**
	 * Renders the Pricing Details of surety bond request.
	 * @return
	 * @throws DocumentException 
	 */
	public RequestBuilder appendPricingDetails() throws DocumentException {
		
		AdditionalInstrumentDetails additionalInstrDet = requestDetails.getAdditionalInstrumentDetails();
		
		if(additionalInstrDet != null && additionalInstrDet.isRequestForProposal() != null && additionalInstrDet.isRequestForProposal() == true){
			String pricingDetailsTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_PRICINGDETAILS);
			Section section = ALOCPDFStyle.createSection(pricingDetailsTitle, reportContext.getCurrentChapter());
	
			PricingDetails pricingDetails = requestDetails.getPricingDetails();
			BigDecimal allInComm = (pricingDetails!=null) ? pricingDetails.getAllInCommissionsValue() : null;
			BigDecimal localComm = (pricingDetails!=null) ? pricingDetails.getLocalCommissionsValue() : null;
	
			PdfPTable pricingDetailsTable = ALOCPDFStyle.createMultiSectionDataTable();
			pricingDetailsTable.addCell(ALOCPDFStyle.createMultiSectionTitle(ALOCPDFReportHelper.getResourceValue(RES_KEY_ALLCOMMISSIONS)));
			pricingDetailsTable.addCell(ALOCPDFStyle.createMultiSectionTitle(ALOCPDFReportHelper.getResourceValue(RES_KEY_LOCALCOMMISSIONS)));
	
			String allInCommissionsNameTitle =(pricingDetails != null) ? pricingDetails.getAllInCommissionsName() : ALOCConstants.HYPEN.toString();
			String allInCommissionsValue = (allInComm != null) ? allInComm.toString() : null;
			pricingDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(allInCommissionsNameTitle, allInCommissionsValue));
	
			String localCommissionsNameTitle = (pricingDetails != null) ? pricingDetails.getLocalCommissionsName() : ALOCConstants.HYPEN.toString();
			String localCommissionsValue = (localComm != null) ? localComm.toString() : null;
			pricingDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(localCommissionsNameTitle, localCommissionsValue));
			
			String allInAmendmentFeeTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_AMDTRANS_FEE);
			String allInAmendmentFeeValue = null;
			if(pricingDetails != null && pricingDetails.getAllInAmmendmentTransactionFee() != null){
				allInAmendmentFeeValue = ALOCPDFReportHelper.formatCurrency(pricingDetails.getAllInAmmendmentTransactionFee());
			}
			pricingDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(allInAmendmentFeeTitle, allInAmendmentFeeValue));
	
			String localAmendmentFeeTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_AMDTRANS_FEE);
			String localAmendmentFeeValue = null;
			if(pricingDetails != null && pricingDetails.getLocalAmmendmentTransactionFee() != null){
				localAmendmentFeeValue = ALOCPDFReportHelper.formatCurrency(pricingDetails.getLocalAmmendmentTransactionFee());
			}
			pricingDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(localAmendmentFeeTitle, localAmendmentFeeValue));
			
			section.add(pricingDetailsTable);
		}
		return this;
	}
	
	/**
	 * Renders the PreAgreed Pricing Details of surety bond request.
	 * @return
	 * @throws DocumentException 
	 */
	public RequestBuilder appendPreAgreedPricingDetails() throws DocumentException {
		
		AdditionalInstrumentDetails additionalInstrDet = requestDetails.getAdditionalInstrumentDetails();
		
		if(additionalInstrDet != null && additionalInstrDet.isRequestForProposal() != null && additionalInstrDet.isRequestForProposal() == false){
			String pricingDetailsTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_PRICINGDETAILS);
			Section section = ALOCPDFStyle.createSection(pricingDetailsTitle, reportContext.getCurrentChapter());
	
			PricingDetails pricingDetails = requestDetails.getPricingDetails();
			BigDecimal allInComm = (pricingDetails!=null) ? pricingDetails.getAllInCommissionsValue() : null;
			BigDecimal localComm = (pricingDetails!=null) ? pricingDetails.getLocalCommissionsValue() : null;
	
			PdfPTable pricingDetailsTable = ALOCPDFStyle.createMultiSectionDataTable();
			pricingDetailsTable.addCell(ALOCPDFStyle.createMultiSectionTitle(ALOCPDFReportHelper.getResourceValue(RES_KEY_ALLCOMMISSIONS)));
			pricingDetailsTable.addCell(ALOCPDFStyle.createMultiSectionTitle(ALOCPDFReportHelper.getResourceValue(RES_KEY_LOCALCOMMISSIONS)));
	
			String allInCommissionsNameTitle =(pricingDetails != null) ? pricingDetails.getAllInCommissionsName() : ALOCConstants.HYPEN.toString();
			String allInCommissionsValue = (allInComm != null) ? allInComm.toString() : null;
			pricingDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(allInCommissionsNameTitle, allInCommissionsValue));
	
			String localCommissionsNameTitle = (pricingDetails != null) ? pricingDetails.getLocalCommissionsName() : ALOCConstants.HYPEN.toString();
			String localCommissionsValue = (localComm != null) ? localComm.toString() : null;
			pricingDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(localCommissionsNameTitle, localCommissionsValue));
			
			String allInAmendmentFeeTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_AMDTRANS_FEE);
			String allInAmendmentFeeValue = null;
			if(pricingDetails != null && pricingDetails.getAllInAmmendmentTransactionFee() != null){
				allInAmendmentFeeValue = ALOCPDFReportHelper.formatCurrency(pricingDetails.getAllInAmmendmentTransactionFee());
			}
			pricingDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(allInAmendmentFeeTitle, allInAmendmentFeeValue));
	
			String localAmendmentFeeTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_AMDTRANS_FEE);
			String localAmendmentFeeValue = null;
			if(pricingDetails != null && pricingDetails.getLocalAmmendmentTransactionFee() != null){
				localAmendmentFeeValue = ALOCPDFReportHelper.formatCurrency(pricingDetails.getLocalAmmendmentTransactionFee());
			}
			pricingDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(localAmendmentFeeTitle, localAmendmentFeeValue));
			section.add(pricingDetailsTable);
		}else if(additionalInstrDet != null && additionalInstrDet.isRequestForProposal() != null && additionalInstrDet.isRequestForProposal() == true){
			String pricingDetailsTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_PREPRICINGDETAILS);
			Section section = ALOCPDFStyle.createSection(pricingDetailsTitle, reportContext.getCurrentChapter());

			PreAgreedPricingDetails pricingDetails = requestDetails.getPreAgreedPricingDetails();
			BigDecimal allInComm = (pricingDetails!=null) ? pricingDetails.getAllInCommissionsValue() : null;
			BigDecimal localComm = (pricingDetails!=null) ? pricingDetails.getLocalCommissionsValue() : null;

			PdfPTable pricingDetailsTable = ALOCPDFStyle.createMultiSectionDataTable();
			pricingDetailsTable.addCell(ALOCPDFStyle.createMultiSectionTitle(ALOCPDFReportHelper.getResourceValue(RES_KEY_ALLCOMMISSIONS)));
			pricingDetailsTable.addCell(ALOCPDFStyle.createMultiSectionTitle(ALOCPDFReportHelper.getResourceValue(RES_KEY_LOCALCOMMISSIONS)));
			String allInCommissionsNameTitle =(pricingDetails != null) ? pricingDetails.getAllInCommissionsName() : ALOCConstants.HYPEN.toString();
			String allInCommissionsValue = (allInComm != null) ? allInComm.toString() : null;
			pricingDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(allInCommissionsNameTitle, allInCommissionsValue));
			String localCommissionsNameTitle = (pricingDetails != null) ? pricingDetails.getLocalCommissionsName() : ALOCConstants.HYPEN.toString();
			String localCommissionsValue = (localComm != null) ? localComm.toString() : null;
			pricingDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(localCommissionsNameTitle, localCommissionsValue));
			
			String allInAmendmentFeeTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_AMDTRANS_FEE);
			String allInAmendmentFeeValue = null;
			if(pricingDetails != null && pricingDetails.getAllInAmmendmentTransactionFee() != null){
				allInAmendmentFeeValue = ALOCPDFReportHelper.formatCurrency(pricingDetails.getAllInAmmendmentTransactionFee());
			}
			pricingDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(allInAmendmentFeeTitle, allInAmendmentFeeValue));
	
			String localAmendmentFeeTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_AMDTRANS_FEE);
			String localAmendmentFeeValue = null;
			if(pricingDetails != null && pricingDetails.getLocalAmmendmentTransactionFee() != null){
				localAmendmentFeeValue = ALOCPDFReportHelper.formatCurrency(pricingDetails.getLocalAmmendmentTransactionFee());
			}
			pricingDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(localAmendmentFeeTitle, localAmendmentFeeValue));
			section.add(pricingDetailsTable);
		}
		return this;
	}

	/**
	 * Renders the Bid Reply One Time Fee Details.
	 * @return
	 * @throws DocumentException 
	 */
	public RequestBuilder appendBidMemoOneTimeFee() throws DocumentException {
		
		AdditionalInstrumentDetails additionalInstrDet = requestDetails.getAdditionalInstrumentDetails();
		
		if(additionalInstrDet != null && additionalInstrDet.isRequestForProposal() != null && additionalInstrDet.isRequestForProposal() == true){
			
			String pricingDetailsTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_ONETIMEFEE);
			Section section = ALOCPDFStyle.createSection(pricingDetailsTitle, reportContext.getCurrentChapter());
			PdfPTable oneTimeFeesTable = ALOCPDFStyle.createSectionDataTable();
	
			PricingDetails pricingDetails = requestDetails.getPricingDetails();
	
			OneTimeFeesDetails oneTimeFeeDet =  (pricingDetails != null) ? pricingDetails.getOneTimeFeesDetails() : null;
			
			String zero = ".00";
			String vatTaxesTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_VATTAXES);
			String vatTaxesValue = (oneTimeFeeDet != null) ? ALOCPDFReportHelper.formatCurrency(oneTimeFeeDet.getVATTaxes()): null;
			vatTaxesValue = StringUtils.isNotBlank(vatTaxesValue) && vatTaxesValue.equals(zero) ? null : vatTaxesValue;
			oneTimeFeesTable.addCell(ALOCPDFStyle.createSectionDataCell(vatTaxesTitle, vatTaxesValue));
	
			String stampTaxesTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_STAMPTAXES);
			String stampTaxesValue = (oneTimeFeeDet != null) ? ALOCPDFReportHelper.formatCurrency(oneTimeFeeDet.getStampTaxes()): null;
			stampTaxesValue = StringUtils.isNotBlank(stampTaxesValue) && stampTaxesValue.equals(zero) ? null : stampTaxesValue;
			oneTimeFeesTable.addCell(ALOCPDFStyle.createSectionDataCell(stampTaxesTitle, stampTaxesValue));
	
			String incidentalFeeTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_ADMINFEE);
			String incidentalFeeValue = (oneTimeFeeDet != null) ? ALOCPDFReportHelper.formatCurrency(oneTimeFeeDet.getIncidentalAdminFee()): null;
			incidentalFeeValue = StringUtils.isNotBlank(incidentalFeeValue) && incidentalFeeValue.equals(zero) ? null : incidentalFeeValue;
			oneTimeFeesTable.addCell(ALOCPDFStyle.createSectionDataCell(incidentalFeeTitle, incidentalFeeValue));
	
			String otherAmountTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_OTHER);
			String otherAmountValue = (oneTimeFeeDet != null) ? ALOCPDFReportHelper.formatCurrency(oneTimeFeeDet.getOther()): null;
			otherAmountValue = StringUtils.isNotBlank(otherAmountValue) && otherAmountValue.equals(zero) ? null : otherAmountValue;
			oneTimeFeesTable.addCell(ALOCPDFStyle.createSectionDataCell(otherAmountTitle, otherAmountValue));
	
			section.add(oneTimeFeesTable);
		}
		return this;
	}
	
	/**
	 * Renders the Bid Reply One Time Fee Details.
	 * @return
	 * @throws DocumentException 
	 */
	public RequestBuilder appendBidReplyOneTimeFee() throws DocumentException {
		
		OneTimeFeesDetails oneTimeFeeDet = null;
		AdditionalInstrumentDetails additionalInstrDet = requestDetails.getAdditionalInstrumentDetails();
		
		if(additionalInstrDet != null && additionalInstrDet.isRequestForProposal() != null && additionalInstrDet.isRequestForProposal() == true){
			oneTimeFeeDet = requestDetails.getPricingDetails() != null ? requestDetails.getPricingDetails().getOneTimeFeesDetails() : null;
		}else if(additionalInstrDet != null && additionalInstrDet.isRequestForProposal() != null && additionalInstrDet.isRequestForProposal() == false){
			oneTimeFeeDet = requestDetails.getPreAgreedPricingDetails() != null ? requestDetails.getPreAgreedPricingDetails().getOneTimeFeesDetails() : null;
		}
		String pricingDetailsTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_ONETIMEFEE);
		Section section = ALOCPDFStyle.createSection(pricingDetailsTitle, reportContext.getCurrentChapter());
		PdfPTable oneTimeFeesTable = ALOCPDFStyle.createSectionDataTable();
		String zero = ".00";
		
		String vatTaxesTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_VATTAXES);
		String vatTaxesValue = (oneTimeFeeDet != null) ? ALOCPDFReportHelper.formatCurrency(oneTimeFeeDet.getVATTaxes()): null;
		vatTaxesValue = StringUtils.isNotBlank(vatTaxesValue) && vatTaxesValue.equals(zero) ? null : vatTaxesValue;
		oneTimeFeesTable.addCell(ALOCPDFStyle.createSectionDataCell(vatTaxesTitle, vatTaxesValue));

		String stampTaxesTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_STAMPTAXES);
		String stampTaxesValue = (oneTimeFeeDet != null) ? ALOCPDFReportHelper.formatCurrency(oneTimeFeeDet.getStampTaxes()): null;
		stampTaxesValue = StringUtils.isNotBlank(stampTaxesValue) && stampTaxesValue.equals(zero) ? null : stampTaxesValue;
		oneTimeFeesTable.addCell(ALOCPDFStyle.createSectionDataCell(stampTaxesTitle, stampTaxesValue));

		String incidentalFeeTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_ADMINFEE);
		String incidentalFeeValue = (oneTimeFeeDet != null) ? ALOCPDFReportHelper.formatCurrency(oneTimeFeeDet.getIncidentalAdminFee()): null;
		incidentalFeeValue = StringUtils.isNotBlank(incidentalFeeValue) && incidentalFeeValue.equals(zero) ? null : incidentalFeeValue;
		oneTimeFeesTable.addCell(ALOCPDFStyle.createSectionDataCell(incidentalFeeTitle, incidentalFeeValue));

		String otherAmountTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_OTHER);
		String otherAmountValue = (oneTimeFeeDet != null) ? ALOCPDFReportHelper.formatCurrency(oneTimeFeeDet.getOther()): null;
		otherAmountValue = StringUtils.isNotBlank(otherAmountValue) && otherAmountValue.equals(zero) ? null : otherAmountValue;
		oneTimeFeesTable.addCell(ALOCPDFStyle.createSectionDataCell(otherAmountTitle, otherAmountValue));

		section.add(oneTimeFeesTable);
		return this;
	}

	/**
	 * This is append Confirmation Fees section of DLOC bid reply
	 * @return
	 */
	public RequestBuilder appendBidReplyConfirmationFees() {

		ConfirmationFees confirmationFees = requestDetails.getConfirmationFees();
		String confirmationFeesTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_CONFIRMATION_FEES);
		Section section = ALOCPDFStyle.createSection(confirmationFeesTitle,reportContext.getCurrentChapter());
		PdfPTable confirmationFeesTable = ALOCPDFStyle.createSectionDataTable();

		String instructions  = ALOCPDFReportHelper.getResourceValue(RES_KEY_INSTRUCTIONS);
		String quotation = ALOCPDFReportHelper.getResourceValue(RES_KEY_QUOTATION);
		String negotiationFee = ALOCPDFReportHelper.getResourceValue(RES_KEY_NEGOTIONFEE);
		confirmationFeesTable.addCell(ALOCPDFStyle.createSectionDataCell(instructions,quotation+negotiationFee));		
		
		String feeStructureName = (confirmationFees != null) ? confirmationFees.getFeeStructureName() : null;
		BigDecimal feeStructureValue = (confirmationFees != null) ? confirmationFees.getFeeStructureValue() : null;
		String feeStrVal = (feeStructureValue != null) ? ALOCPDFReportHelper.formatCurrency(feeStructureValue) : null;
		confirmationFeesTable.addCell(ALOCPDFStyle.createSectionDataCell(feeStructureName, feeStrVal));

		String otherFees = ALOCPDFReportHelper.getResourceValue(RES_KEY_OTHER_FEES);
		BigDecimal otherFeesValue = (confirmationFees != null) ? confirmationFees.getOtherFees() : null;
		String otherVal = (otherFeesValue != null) ? ALOCPDFReportHelper.formatCurrency(otherFeesValue) : null;
		confirmationFeesTable.addCell(ALOCPDFStyle.createSectionDataCell(otherFees, otherVal));

		String additionalComments = ALOCPDFReportHelper.getResourceValue(RES_KEY_ADDITIONAL_COMMENTS);
		String addCommValue = (confirmationFees != null) ? confirmationFees.getAdditionalComments() : null;
		confirmationFeesTable.addCell(ALOCPDFStyle.createSectionDataCell(additionalComments, addCommValue));

		section.add(confirmationFeesTable);
		return this;
	}

	/**
	 * This is append Proposed Bank Branch to Confirm section of DLOC bid reply
	 * @return
	 */
	public RequestBuilder appendBidReplyProposedBankBranchToConfirm() {

		ProposedBankBranchConfirmDetails proposedBankDetails = requestDetails.getProposedBankBranchConfirmDetails();
		String proposedBankDetailsTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_PROPOSED_BRANCH_TO_CONFIRM);
		Section section = ALOCPDFStyle.createSection(proposedBankDetailsTitle, reportContext.getCurrentChapter());
		PdfPTable proposedBankDetailsTable = ALOCPDFStyle.createSectionDataTable();

		String nameAddressTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_NAME);
		if(proposedBankDetails != null) {
			String address1=null;
			String address2=null;
			String address3=null;
			if(proposedBankDetails.getBankDetails()!=null){
				address1=proposedBankDetails.getBankDetails().getAddress().get(ALOCConstants.BASE_VALUE);
			}
			if(proposedBankDetails.getBankDetails().getAddress().size()>ALOCConstants.MIN_VALUE && proposedBankDetails.getBankDetails().getAddress().get(ALOCConstants.MIN_VALUE)!=null){
				address2=proposedBankDetails.getBankDetails().getAddress().get(ALOCConstants.MIN_VALUE);
			}
			if(proposedBankDetails.getBankDetails().getAddress().size()>ALOCConstants.SECOND_VALUE && proposedBankDetails.getBankDetails().getAddress().get(ALOCConstants.SECOND_VALUE)!=null){
				address3=proposedBankDetails.getBankDetails().getAddress().get(ALOCConstants.SECOND_VALUE);
			}
			String [] addressValues= {proposedBankDetails.getBankDetails().getName(),address1,address2,address3,
					proposedBankDetails.getBankDetails().getCity(),proposedBankDetails.getBankDetails().getStateProvince(),
					proposedBankDetails.getBankDetails().getZIPPostalCode(),proposedBankDetails.getBankDetails().getCountry()};
			proposedBankDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(nameAddressTitle, addressValues));
		}
		String bankIdCode = ALOCPDFReportHelper.getResourceValue(RES_KEY_BANK_IDENTIFIER_CODE);
		String bankIdCodeValue = (proposedBankDetails != null) ? proposedBankDetails.getBankIdentifierCode() : null;
		proposedBankDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(bankIdCode, bankIdCodeValue));

		section.add(proposedBankDetailsTable);
		return this;
	}

	/**
	 * This is append Other Information section of DLOC bid reply
	 * @return
	 */
	public RequestBuilder appendBidReplyOtherInformation() {	
		String otherInfoTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_OTHER_INFO);
		Section section = ALOCPDFStyle.createSection(otherInfoTitle, reportContext.getCurrentChapter());
		PdfPTable otherInfoTable = ALOCPDFStyle.createSectionDataTable();

		String fees = ALOCPDFReportHelper.getResourceValue(RES_KEY_FEES);
		String negotiationFee = ALOCPDFReportHelper.getResourceValue(RES_KEY_NEGOTIONFEE);
		otherInfoTable.addCell(ALOCPDFStyle.createSectionDataCell(fees, negotiationFee));

		String instructions = ALOCPDFReportHelper.getResourceValue(RES_KEY_INSTRUCTIONS);
		String quotation = ALOCPDFReportHelper.getResourceValue(RES_KEY_QUOTATION);
		otherInfoTable.addCell(ALOCPDFStyle.createSectionDataCell(instructions, quotation));

		section.add(otherInfoTable);
		return this;
	}

	/**
	 * This is append Indicative Pricing Information Completed By section of DLOC bid reply
	 * @return
	 */
	public RequestBuilder appendBidReplyIndicativePricingInformation() {

		IndicativePricingCompletedDetails indicativeDetails = (requestDetails!=null) ? requestDetails.getIndicativePricingCompletedDetails() : null;
		String indicativeDetailsTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_INDICATIVE_PRICING_INFO);
		Section section = ALOCPDFStyle.createSection(indicativeDetailsTitle, reportContext.getCurrentChapter());
		PdfPTable indicativeDetailsTable = ALOCPDFStyle.createSectionDataTable();

		String name = ALOCPDFReportHelper.getResourceValue(RES_KEY_NAME);
		String nameValue = (indicativeDetails != null) ? indicativeDetails.getName() : null;
		indicativeDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(name, nameValue));
		String pricingExpDate = ALOCPDFReportHelper.getResourceValue(RES_KEY_PRICING_EXPIRATION_DATE);
		String pricingExpDateValue = (indicativeDetails != null) ? ALOCPDFReportHelper.formatDate(indicativeDetails.getPricingExpirationDateTime()) : null;
		indicativeDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(pricingExpDate, pricingExpDateValue));
		String pricingExpirationTimeTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_PRICING_EXPIRATION_TIME);
		String pricingExpirationTimeValue= (indicativeDetails!=null) ? ALOCPDFReportHelper.formatTime(indicativeDetails.getPricingExpirationTime()) :null;
		indicativeDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(pricingExpirationTimeTitle, pricingExpirationTimeValue));

		section.add(indicativeDetailsTable);
		return this;
	}

	/**
	 * This is append Opting out/Comments of DLOC bid reply
	 * @return
	 */
	public RequestBuilder appendBidReplyOptingOut() {
		ActionDetails actionDetails = requestDetails.getActionDetails();
		String optingOut = ALOCPDFReportHelper.getResourceValue(RES_KEY_OPTING_OUT);
		Section section = ALOCPDFStyle.createSection(optingOut, reportContext.getCurrentChapter());
		PdfPTable optingOutTable = ALOCPDFStyle.createSectionDataTable();

		String pricingExpTime = ALOCPDFReportHelper.getResourceValue(RES_KEY_REASON);
		String pricingExpTimeValue = (actionDetails != null) ?  actionDetails.getReasonForOptingOut(): null;
		optingOutTable.addCell(ALOCPDFStyle.createSectionDataCell(pricingExpTime, pricingExpTimeValue));
		section.add(optingOutTable);
		return this;
	}

	/**
	 * This method is used to append Request Summary for BG,SBLC at Bid Memo & Bid Reply level 
	 * @return
	 * @throws DocumentException 
	 */
	public RequestBuilder appendBgBidreplyRequestSummary() throws DocumentException {
		String reqSummaryTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_REQ_SUMMARY);
		Section section = ALOCPDFStyle.createSection(reqSummaryTitle, reportContext.getCurrentChapter());

		PdfPTable requestSummary = ALOCPDFStyle.createSummaryTable(ALOCConstants.THREE_COLUMNS);

		String applicantTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_APPLICANT);
		
		Boolean tripartyFlag = requestDetails.getTransactionParties() != null ? requestDetails.getTransactionParties().isTriPartyRequestFlag(): null;
		TransactionParties tp = requestDetails.getTransactionParties();
		String[] addressValues = null;
		if(tp!=null && tp.getTpApplicantDetails() != null && tp.getTpApplicantDetails().getAddressDtls() !=null){
			AddressDtls addrDtls=tp.getTpApplicantDetails().getAddressDtls();
			if(addrDtls != null && (tripartyFlag == null || tripartyFlag == false)){
				addressValues = ALOCPDFReportHelper.convertAddressAsString(addrDtls);
			}
		}
		requestSummary.addCell(ALOCPDFStyle.createSectionDataCell(applicantTitle, addressValues));
		String beneficiaryTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_BENEFICIARY);
		String[] addressValues1 = null;
		if(tp!=null && tp.getCustomer() != null && tp.getCustomer().getAddressDtls() !=null){
			AddressDtls addrDtls=tp.getCustomer().getAddressDtls();
			if(addrDtls != null){
				addressValues1 = ALOCPDFReportHelper.convertAddressAsString(addrDtls);
			}
		}
		requestSummary.addCell(ALOCPDFStyle.createSectionDataCell(beneficiaryTitle, addressValues1));
		String triPartyAppTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_TRI_PARTY_APPLICANT);
		String[] addressValues2 = null;
		if(tp!=null && tp.getTriPartyApplicant() != null){
			AddressDtls addrDtls=tp.getTriPartyApplicant();
			if(addrDtls != null && tripartyFlag != null && tripartyFlag == true){
				addressValues2 = ALOCPDFReportHelper.convertAddressAsString(addrDtls);
			}
		}
		requestSummary.addCell(ALOCPDFStyle.createSectionDataCell(triPartyAppTitle, addressValues2));

		PdfPTable requestSummary2 = ALOCPDFStyle.createSummaryTable(ALOCConstants.THREE_COLUMNS);
		InstrumentDetails instrumentDet = requestDetails.getInstrumentDetails();

		String countryofIssuanceTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_COUNTRYOF_ISSUANCE);
		String pricingExpTimeValue = (instrumentDet != null) ?  instrumentDet.getIssuanceCountry() : null;
		requestSummary2.addCell(ALOCPDFStyle.createSectionDataCell(countryofIssuanceTitle, pricingExpTimeValue));

		String instrumentCurrencyTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_INSTRUMENT_CURRENCY);
		String instrumentCurrencValue = (instrumentDet != null) ?  instrumentDet.getInstrumentCurrency() : null;
		requestSummary2.addCell(ALOCPDFStyle.createSectionDataCell(instrumentCurrencyTitle, instrumentCurrencValue));

		BigDecimal instrAmt = (instrumentDet != null) ? instrumentDet.getInstrumentAmt() :null;
		String instrumentAmountTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_INSTAMOUNT);
		String instrumentAmountValue = (instrAmt != null) ?  ALOCPDFReportHelper.formatCurrency(instrAmt) : null;
		requestSummary2.addCell(ALOCPDFStyle.createSectionDataCell(instrumentAmountTitle, instrumentAmountValue));

		PdfPTable requestSummary3 = ALOCPDFStyle.createSummaryTable(ALOCConstants.THREE_COLUMNS);

		Calendar expDate = (instrumentDet != null) ? instrumentDet.getExpiryDt() :null;

		String expDateTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_EXPIRATIONDATE_TITLE);
		String expDateValue = (expDate != null) ? ALOCPDFReportHelper.formatDate(expDate) : null;
		requestSummary3.addCell(ALOCPDFStyle.createSectionDataCell(expDateTitle, expDateValue));

		Calendar ecoExpDate = (instrumentDet != null) ? instrumentDet.getEconoExpiryDt() :null;

		String ecoExpDateTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_ECOEXPDATE);
		String ecoexpDateValue = (ecoExpDate != null) ? ALOCPDFReportHelper.formatDate(ecoExpDate) : null;
		requestSummary3.addCell(ALOCPDFStyle.createSectionDataCell(ecoExpDateTitle, ecoexpDateValue));

		String emptyTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_EMPTY);
		String emptyValue = ALOCConstants.EMPTY_STRING;
		requestSummary3.addCell(ALOCPDFStyle.createSectionDataCell(emptyTitle, emptyValue));

		section.add(requestSummary);
		section.add(requestSummary2);
		section.add(requestSummary3);

		return this;
	}

	/**
	 * This method is used to append Bid Response Required By section
	 * @return
	 */

	public RequestBuilder appendBidResponseRequiredBy() {

		String bidMemoTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_BIDMEMO_TITLE);
		ALOCPDFStyle.createSection(bidMemoTitle,reportContext.getCurrentChapter());

		String bidResponseRequiredByTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_BIDRESPONSE_REQUIREDBY);
		Section section = ALOCPDFStyle.createSection(bidResponseRequiredByTitle,reportContext.getCurrentChapter());

		BidmemoDetails bidMemoDetails = (requestDetails!=null) ? requestDetails.getBidmemoDetails() : null;
		PdfPTable bidResponseRequiredByTable = ALOCPDFStyle.createSectionDataTable();

		String dateBidMemoCreatedTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_BIDCREATED_DATE);
		String dateBidMemoCreatedValue = (bidMemoDetails != null) ? ALOCPDFReportHelper.formatDate(bidMemoDetails.getDateBidMemoCreated()) : null;
		bidResponseRequiredByTable.addCell(ALOCPDFStyle.createSectionDataCell(dateBidMemoCreatedTitle, dateBidMemoCreatedValue));
		String expirationDateTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_EXPIRATION_DATE);
		String expirationDateValue = (bidMemoDetails != null) ? ALOCPDFReportHelper.formatDate(bidMemoDetails.getExpirationDateTime()) : null;
		bidResponseRequiredByTable.addCell(ALOCPDFStyle.createSectionDataCell(expirationDateTitle, expirationDateValue));
		String pricingExpirationTimeTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_EXPIRATIONTIME);
		String pricingExpirationTimeValue= (bidMemoDetails!=null) ? ALOCPDFReportHelper.formatTime(bidMemoDetails.getExpirationTime()) :null;
		bidResponseRequiredByTable.addCell(ALOCPDFStyle.createSectionDataCell(pricingExpirationTimeTitle, pricingExpirationTimeValue));

		section.add(bidResponseRequiredByTable);
		return this;
	}

	/**
	 * This method is used to append Bid Memo Delivery Instructions
	 * @return
	 */
	public RequestBuilder appendBidMemoDeliveryInstructions() {
		String bidDeliveryInstructionTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_DELIVERY_INSTRUCTIONS);
		Section section = ALOCPDFStyle.createSection(bidDeliveryInstructionTitle,reportContext.getCurrentChapter());

		AdditionalInstrumentDetails additionalDetails = (requestDetails != null) ? requestDetails.getAdditionalInstrumentDetails() : null;
		PdfPTable bidDeliveryInstructionTable = ALOCPDFStyle.createSectionDataTable();

		String instrumentTypeTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_INSTUEMENT_TYPE);
		String instrumentTypeValue = (requestDetails != null) ? requestDetails.getInstrumentType() : null;
		bidDeliveryInstructionTable.addCell(ALOCPDFStyle.createSectionDataCell(instrumentTypeTitle, instrumentTypeValue));

		String expirationDateTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_GOVERNING_RULES);
		String expirationDateValue = (additionalDetails != null) ? additionalDetails.getGoverningRulesName() : null;
		bidDeliveryInstructionTable.addCell(ALOCPDFStyle.createSectionDataCell(expirationDateTitle, expirationDateValue));

		BigInteger ruleId = (additionalDetails != null) ? additionalDetails.getGoverningRulesId() : null;

		if(ruleId != null && ruleId.equals(BigInteger.valueOf(ALOCConstants.RULE_ID))){
			String otherGoverningRulesTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_OTHER_GOVERNING_RULES);
			String otherGoverningRulesValue= (additionalDetails!=null) ? additionalDetails.getGoverningRulesOtherDescription() :null;
			bidDeliveryInstructionTable.addCell(ALOCPDFStyle.createSectionDataCell(otherGoverningRulesTitle, otherGoverningRulesValue));
		}
		String pricingExpirationTimeTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_REQUEST_FOR_PROPOSAL);
		String pricingExpirationTimeValue= (additionalDetails!=null) ? ALOCPDFReportHelper.convertBooleanAsYesOrNo(additionalDetails.isRequestForProposal()) :null;
		bidDeliveryInstructionTable.addCell(ALOCPDFStyle.createSectionDataCell(pricingExpirationTimeTitle, pricingExpirationTimeValue));

		section.add(bidDeliveryInstructionTable);
		return this;
	}

	/**
	 * This is append Payment Schedule section of DLOC request
	 * @return
	 */

	public RequestBuilder appendTreasuryApprovals() {

		DelegationApprovers delegateApprovers = requestDetails.getDelegationApprovers();
		List<ApproverLevel> approverLevels = (delegateApprovers != null) ? delegateApprovers.getApproverLevels() : null;
		String approverLevelsTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_TREASURYAPPRINFO);

		Section section = ALOCPDFStyle.createSection(approverLevelsTitle,reportContext.getCurrentChapter());
		PdfPTable treasuryApproversTable = ALOCPDFStyle.createTable(33f, 33f, 34f);

		treasuryApproversTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_APPROVERLEVEL)));
		treasuryApproversTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_APPROVERNAME)));
		treasuryApproversTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_APPROVERSSO)));

		if(approverLevels!=null){

			for(ApproverLevel approverLevel : approverLevels) {
				String levelValue = (approverLevel.getLevelId() != null) ? approverLevel.getLevelId().toString() : null;
				treasuryApproversTable.addCell(ALOCPDFStyle.createTableDataCell(levelValue)); 

				StringBuilder fullName = new StringBuilder();
				if(approverLevel.getFirstName() != null) {
					fullName.append(approverLevel.getFirstName());
				}
				if(approverLevel.getLastName() != null) {
					if(fullName.length() > ALOCConstants.BASE_VALUE) {
						fullName.append(ALOCConstants.COMMA_SPACE);
					}
					fullName.append(approverLevel.getLastName());
				}
				String nameValue = (fullName != null) ? fullName.toString(): null;
				treasuryApproversTable.addCell(ALOCPDFStyle.createTableDataCell(nameValue));

				String ssoValue = (approverLevel != null) ? approverLevel.getSsoId() : null;
				treasuryApproversTable.addCell(ALOCPDFStyle.createTableDataCell(ssoValue));			
			}
		}
		section.add(treasuryApproversTable);
		return this;
	}

	/**
	 * This is append Transaction History
	 * @return
	 */
	public RequestBuilder appendTransactionHistory() throws DocumentException,HWFServiceException {

		requestDetails = ALOCPDFReportHelper.getTransactionAuditLogDetails(requestDetails.getWFDetails().getWFStage(), ALOCConstants.ACTION, requestDetails.getRequestId(), requestDetails);
		List<ActionLog> actionLogs = requestDetails.getActionLogs();
		PdfPTable transacionHistoryTable = ALOCPDFStyle.createTable(12f, 14f, 14f, 20f, 20f,20f);
		if(actionLogs.size() != ALOCConstants.BASE_VALUE){

			String transacionHistoryTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_TRANSACTIONHISTORY);
			Section section = ALOCPDFStyle.createSection(transacionHistoryTitle,reportContext.getCurrentChapter());

			transacionHistoryTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_DATE)));
			transacionHistoryTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_STATEPROVINCE)));
			transacionHistoryTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_ACTION)));
			transacionHistoryTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_REASON_FOR_RETURN)));
			transacionHistoryTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_COMMENT)));
			transacionHistoryTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_ACTIONTAKENBY)));

			for(ActionLog actionLog : actionLogs) {
				String auditCreatedDt = (actionLog != null) ? ALOCPDFReportHelper.formatDate(actionLog.getAuditCreatedDt()) : null;
				transacionHistoryTable.addCell(ALOCPDFStyle.createTableDataCell(auditCreatedDt)); 
				String stageName = (actionLog != null) ? actionLog.getStageName() : null;
				transacionHistoryTable.addCell(ALOCPDFStyle.createTableDataCell(stageName));
				String actionName = (actionLog != null) ? actionLog.getActionName() : null;
				transacionHistoryTable.addCell(ALOCPDFStyle.createTableDataCell(actionName));
				String reasonForReturn = (actionLog != null) ? actionLog.getReasonForRejection() : null;
				transacionHistoryTable.addCell(ALOCPDFStyle.createTableDataCell(reasonForReturn)); 
				String comments = (actionLog != null) ? actionLog.getComments() : null;
				transacionHistoryTable.addCell(ALOCPDFStyle.createTableDataCell(comments)); 
				StringBuilder fullName = new StringBuilder();
				String name=null;
				if(StringUtils.isNotBlank(actionLog.getApproverLastName())) {
					fullName.append(actionLog.getApproverLastName());
				}
				if(StringUtils.isNotBlank(actionLog.getApproverFirstName())) {
					if(fullName.length() > ALOCConstants.BASE_VALUE) {
						fullName.append(ALOCConstants.COMMA_SPACE);
					}
					fullName.append(actionLog.getApproverFirstName());
				}
				if(fullName != null){
					name= fullName.toString();
				}
				transacionHistoryTable.addCell(ALOCPDFStyle.createTableDataCell(name));
			}
			section.add(transacionHistoryTable);
		}
		return this;
	}

	/**
	 * This is append Competing Bid Replies
	 * @return
	 * @throws HWFServiceException 
	 */
	public RequestBuilder appendCompetingBidReplies() throws DocumentException, HWFServiceException {
		CurrentBankFees currBankFees = ALOCPDFReportHelper.getCompetingBidReplies(requestDetails.getRequestId());
		if(currBankFees!=null){
			String competingBidRepliesTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_COMPETING_BID_REPLIES);
			Section section = ALOCPDFStyle.createSection(competingBidRepliesTitle,reportContext.getCurrentChapter());
			CurrentWinningBank currWinBak = currBankFees.getCurrentWinningBank();
			String bankValue = (currWinBak != null) ? currWinBak.getWinningBankName() : null;
			if(bankValue!=null && !(bankValue.equals(ALOCConstants.EMPTY_STRING))){
				PdfPTable winnerBankTable = ALOCPDFStyle.createSectionDataTable();
				winnerBankTable = fillWinningBankTable(winnerBankTable, bankValue, currWinBak);
				section.add(winnerBankTable);
				PdfPTable competingBidRepliesTable = ALOCPDFStyle.createMultiSectionDataTable();
				competingBidRepliesTable = fillCompetingBidRepliesTable(competingBidRepliesTable, currWinBak);
				section.add(competingBidRepliesTable);
				PdfPTable oneTimeFeeTable = ALOCPDFStyle.createSectionDataTable();
				oneTimeFeeTable = fillOneTimeFeeTable(oneTimeFeeTable, currWinBak);
				section.add(oneTimeFeeTable);
			}
			String bankName = null;
			List<ParticipantBank> parBanks = currBankFees.getParticipantBanks();
			for(ParticipantBank eachBankDet : parBanks){
				PdfPTable participantTable = ALOCPDFStyle.createSectionDataTable();
				PdfPTable participantCommisionTable = ALOCPDFStyle.createMultiSectionDataTable();
				bankName = eachBankDet.getParticipantBankName();
				participantTable.addCell(ALOCPDFStyle.createSubSectionDataCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_PARTICIPANT), bankName));
				String participantIssuingBankBranch = ALOCPDFReportHelper.getResourceValue(RES_KEY_ISSUING_BANK_BRANCH);
				String participantBankReferenceNum = ALOCPDFReportHelper.getResourceValue(RES_KEY_BANKREF_NUMBER);
				participantTable.addCell(ALOCPDFStyle.createSectionDataCell(participantIssuingBankBranch, eachBankDet.getIssuingBankBranch()));
				participantTable.addCell(ALOCPDFStyle.createSectionDataCell(participantBankReferenceNum, eachBankDet.getBankReferenceNumber()));

				participantCommisionTable.addCell(ALOCPDFStyle.createMultiSectionTitle(ALOCPDFReportHelper.getResourceValue(RES_KEY_ALLCOMMISSIONS)));
				participantCommisionTable.addCell(ALOCPDFStyle.createMultiSectionTitle(ALOCPDFReportHelper.getResourceValue(RES_KEY_LOCALCOMMISSIONS)));
				section.add(participantTable);
				
				AllinComissions allCom = eachBankDet.getAllinComissions();
				LocalComissions localCom =eachBankDet.getLocalComissions();
				participantCommisionTable = fillParticipantCommTable(participantCommisionTable, allCom, localCom);
				section.add(participantCommisionTable);
				
				OnetimeFees onetimefee = eachBankDet.getOnetimeFees();
				PdfPTable participantOneTimeFeeTable = ALOCPDFStyle.createSectionDataTable();
				participantOneTimeFeeTable = fillParticipantOneTimeFeeTable(onetimefee, participantOneTimeFeeTable);
				section.add(participantOneTimeFeeTable);
			}
		}
		return this;
	}
	
	/**
	 * fillParticipantCommTable
	 * @param participantCommisionTable
	 * @param allCom
	 * @param localCom
	 * @return participantCommisionTable
	 */
	private PdfPTable fillParticipantCommTable(PdfPTable participantCommisionTable, AllinComissions allCom, LocalComissions localCom) {
		Integer allInComId = allCom.getAllinCommissionId();
		Integer localComId = localCom.getLocalCommissionId();
		String allInArreas = ALOCPDFReportHelper.getResourceValue(RES_KEY_RATE_ANNUMARREARS);
		String allInAdvance = ALOCPDFReportHelper.getResourceValue(RES_KEY_RATE_ANNUMINADVANCE);
		String flatAnnumAdvance = ALOCPDFReportHelper.getResourceValue(RES_KEY_FLAT_ANNUMINADVANCE);
		String flatLifeadvance = ALOCPDFReportHelper.getResourceValue(RES_KEY_FLAT_LIFEADVANCE);
		if(allInComId!=null && allInComId == ALOCConstants.MIN_VALUE && allCom.getAllinCommissionValue()!=null){
			participantCommisionTable.addCell(ALOCPDFStyle.createSectionDataCell(allInArreas, allCom.getAllinCommissionValue().toString()));
		}else{
			participantCommisionTable.addCell(ALOCPDFStyle.createSectionDataCell(allInArreas, ALOCConstants.HYPEN.toString()));
		}
		if(localComId!=null && localComId == ALOCConstants.MIN_VALUE && localCom.getLocalCommissionValue()!=null){
			participantCommisionTable.addCell(ALOCPDFStyle.createSectionDataCell(allInArreas, localCom.getLocalCommissionValue().toString()));
		}else{
			participantCommisionTable.addCell(ALOCPDFStyle.createSectionDataCell(allInArreas, ALOCConstants.HYPEN.toString()));
		}
		if(allInComId!=null && allInComId == ALOCConstants.SECOND_VALUE && allCom.getAllinCommissionValue()!=null){
			participantCommisionTable.addCell(ALOCPDFStyle.createSectionDataCell(allInAdvance, allCom.getAllinCommissionValue().toString()));
		}else{
			participantCommisionTable.addCell(ALOCPDFStyle.createSectionDataCell(allInAdvance, ALOCConstants.HYPEN.toString()));
		}
		if(localComId!=null && localComId == ALOCConstants.SECOND_VALUE && localCom.getLocalCommissionValue()!=null){
			participantCommisionTable.addCell(ALOCPDFStyle.createSectionDataCell(allInAdvance, localCom.getLocalCommissionValue().toString()));
		}else{
			participantCommisionTable.addCell(ALOCPDFStyle.createSectionDataCell(allInAdvance, ALOCConstants.HYPEN.toString()));
		}
		if(allInComId!=null && allInComId == ALOCConstants.THIRD_VALUE && allCom.getAllinCommissionValue()!=null){
			participantCommisionTable.addCell(ALOCPDFStyle.createSectionDataCell(flatAnnumAdvance, allCom.getAllinCommissionValue().toString()));
		}else{
			participantCommisionTable.addCell(ALOCPDFStyle.createSectionDataCell(flatAnnumAdvance, ALOCConstants.HYPEN.toString()));
		}
		if(localComId!=null && localComId == ALOCConstants.THIRD_VALUE && localCom.getLocalCommissionValue()!=null){
			participantCommisionTable.addCell(ALOCPDFStyle.createSectionDataCell(flatAnnumAdvance, localCom.getLocalCommissionValue().toString()));
		}else{
			participantCommisionTable.addCell(ALOCPDFStyle.createSectionDataCell(flatAnnumAdvance, ALOCConstants.HYPEN.toString()));
		}
		if(allInComId!=null && allInComId == ALOCConstants.FOURTH_VALUE && allCom.getAllinCommissionValue()!=null){
			participantCommisionTable.addCell(ALOCPDFStyle.createSectionDataCell(flatLifeadvance, allCom.getAllinCommissionValue().toString()));
		}else{
			participantCommisionTable.addCell(ALOCPDFStyle.createSectionDataCell(flatLifeadvance, ALOCConstants.HYPEN.toString()));
		}
		if(localComId!=null && localComId == ALOCConstants.FOURTH_VALUE && localCom.getLocalCommissionValue()!=null){
			participantCommisionTable.addCell(ALOCPDFStyle.createSectionDataCell(flatLifeadvance, localCom.getLocalCommissionValue().toString()));
		}else{
			participantCommisionTable.addCell(ALOCPDFStyle.createSectionDataCell(flatLifeadvance, ALOCConstants.HYPEN.toString()));
		}
		String amemdmentTransFee = ALOCPDFReportHelper.getResourceValue(RES_KEY_AMDTRANS_FEE);
		if(allCom.getAmendmentTransactionFee()!=null){
			participantCommisionTable.addCell(ALOCPDFStyle.createSectionDataCell(amemdmentTransFee, ALOCPDFReportHelper.formatCurrency(allCom.getAmendmentTransactionFee())));
		}
		String amemdmentTransFeeLoc = ALOCPDFReportHelper.getResourceValue(RES_KEY_AMDTRANS_FEE);
		if(localCom.getLocalAmendmentTransactionFee()!=null){
			participantCommisionTable.addCell(ALOCPDFStyle.createSectionDataCell(amemdmentTransFeeLoc, ALOCPDFReportHelper.formatCurrency(localCom.getLocalAmendmentTransactionFee())));
		}
		return participantCommisionTable;
	}

	/**
	 * fillParticipantOneTimeFeeTable
	 * @param onetimefee
	 * @param participantOneTimeFeeTable
	 * @return participantOneTimeFeeTable
	 */
	private PdfPTable fillParticipantOneTimeFeeTable(OnetimeFees onetimefee, PdfPTable participantOneTimeFeeTable) {
		
		participantOneTimeFeeTable.addCell(ALOCPDFStyle.createMultiSectionTitle(ALOCPDFReportHelper.getResourceValue(RES_KEY_ONETIMEFEE)));

		String vatTaxesPart = ALOCPDFReportHelper.getResourceValue(RES_KEY_VATTAXES);
		if(onetimefee.getVatTaxes()!=null){
			participantOneTimeFeeTable.addCell(ALOCPDFStyle.createSectionDataCell(vatTaxesPart, ALOCPDFReportHelper.formatCurrency(onetimefee.getVatTaxes())));
		}else{
			participantOneTimeFeeTable.addCell(ALOCPDFStyle.createSectionDataCell(vatTaxesPart, ALOCConstants.HYPEN.toString()));
		}
		String stampTaxesPart = ALOCPDFReportHelper.getResourceValue(RES_KEY_STAMPTAXES);
		if(onetimefee.getStampTaxes()!=null){
			participantOneTimeFeeTable.addCell(ALOCPDFStyle.createSectionDataCell(stampTaxesPart, ALOCPDFReportHelper.formatCurrency(onetimefee.getStampTaxes())));
		}else{
			participantOneTimeFeeTable.addCell(ALOCPDFStyle.createSectionDataCell(stampTaxesPart, ALOCConstants.HYPEN.toString()));
		}
		String adminTaxesPart = ALOCPDFReportHelper.getResourceValue(RES_KEY_ADMINFEE);
		if(onetimefee.getIncidentalAdminFee()!=null){
			participantOneTimeFeeTable.addCell(ALOCPDFStyle.createSectionDataCell(adminTaxesPart, ALOCPDFReportHelper.formatCurrency(onetimefee.getIncidentalAdminFee())));
		}else{
			participantOneTimeFeeTable.addCell(ALOCPDFStyle.createSectionDataCell(adminTaxesPart, ALOCConstants.HYPEN.toString()));
		}
		String otherTaxesPart = ALOCPDFReportHelper.getResourceValue(RES_KEY_OTHER);
		if(onetimefee.getOther()!=null){
			participantOneTimeFeeTable.addCell(ALOCPDFStyle.createSectionDataCell(otherTaxesPart, ALOCPDFReportHelper.formatCurrency(onetimefee.getOther())));
		}else{
			participantOneTimeFeeTable.addCell(ALOCPDFStyle.createSectionDataCell(otherTaxesPart, ALOCConstants.HYPEN.toString()));
		}
		return participantOneTimeFeeTable;
		
	}

	/**
	 * fillWinningBankTable
	 * @param winnerBankTable
	 * @param bankValue
	 * @param currWinBak
	 * @return winnerBankTable
	 */
	private PdfPTable fillWinningBankTable(PdfPTable winnerBankTable, String bankValue, CurrentWinningBank currWinBak) {
		winnerBankTable.addCell(ALOCPDFStyle.createSubSectionDataCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_WINNER), bankValue));

		String issuingBankBranch = ALOCPDFReportHelper.getResourceValue(RES_KEY_ISSUING_BANK_BRANCH_COLON);
		String issuingBankBranchValue = currWinBak.getIssuingBankBranch();
		winnerBankTable.addCell(ALOCPDFStyle.createSectionDataCell(issuingBankBranch, issuingBankBranchValue));

		String bankReferenceNum = ALOCPDFReportHelper.getResourceValue(RES_KEY_BANKREF_NO_COLON);
		String bankReferenceNumValue = currWinBak.getBankReferenceNumber();
		winnerBankTable.addCell(ALOCPDFStyle.createSectionDataCell(bankReferenceNum, bankReferenceNumValue));
		return winnerBankTable;
	}
	
	/**
	 * fillCompetingBidRepliesTable
	 * @param competingBidRepliesTable
	 * @param currWinBak
	 * @return competingBidRepliesTable
	 */
	private PdfPTable fillCompetingBidRepliesTable(PdfPTable competingBidRepliesTable, CurrentWinningBank currWinBak){
		
		competingBidRepliesTable.addCell(ALOCPDFStyle.createMultiSectionTitle(ALOCPDFReportHelper.getResourceValue(RES_KEY_ALLCOMMISSIONS)));
		competingBidRepliesTable.addCell(ALOCPDFStyle.createMultiSectionTitle(ALOCPDFReportHelper.getResourceValue(RES_KEY_LOCALCOMMISSIONS)));

		String allInRatePerAnnumAreas = ALOCPDFReportHelper.getResourceValue(RES_KEY_RATE_ANNUMARREARS);
		String allInRatePerAnnumAreasInAdvance = ALOCPDFReportHelper.getResourceValue(RES_KEY_RATE_ANNUMINADVANCE);
		String flatFeeInAdvance = ALOCPDFReportHelper.getResourceValue(RES_KEY_FLAT_ANNUMINADVANCE);
		String flatFeeLifeInAdvance = ALOCPDFReportHelper.getResourceValue(RES_KEY_FLAT_LIFEADVANCE);

		AllinComissions allInComm = currWinBak.getAllinComissions();
		Integer allInCommId = allInComm.getAllinCommissionId();

		LocalComissions localComm = currWinBak.getLocalComissions();
		Integer localCommId = localComm.getLocalCommissionId();

		if(allInCommId!=null && allInCommId == ALOCConstants.MIN_VALUE && allInComm.getAllinCommissionValue()!=null){
			competingBidRepliesTable.addCell(ALOCPDFStyle.createSectionDataCell(allInRatePerAnnumAreas, allInComm.getAllinCommissionValue().toString()));
		}else{
			competingBidRepliesTable.addCell(ALOCPDFStyle.createSectionDataCell(allInRatePerAnnumAreas, ALOCConstants.HYPEN.toString()));
		}
		if(localCommId!=null && localCommId == ALOCConstants.MIN_VALUE && localComm.getLocalCommissionValue()!=null){
			competingBidRepliesTable.addCell(ALOCPDFStyle.createSectionDataCell(allInRatePerAnnumAreas, localComm.getLocalCommissionValue().toString()));
		}else{
			competingBidRepliesTable.addCell(ALOCPDFStyle.createSectionDataCell(allInRatePerAnnumAreas, ALOCConstants.HYPEN.toString()));
		}
		if(allInCommId!=null &&  allInCommId == ALOCConstants.SECOND_VALUE && allInComm.getAllinCommissionValue()!=null){
			competingBidRepliesTable.addCell(ALOCPDFStyle.createSectionDataCell(allInRatePerAnnumAreasInAdvance, allInComm.getAllinCommissionValue().toString()));
		}else{
			competingBidRepliesTable.addCell(ALOCPDFStyle.createSectionDataCell(allInRatePerAnnumAreasInAdvance, ALOCConstants.HYPEN.toString()));
		}
		if(localCommId!=null && localCommId == ALOCConstants.SECOND_VALUE && localComm.getLocalCommissionValue()!=null){
			competingBidRepliesTable.addCell(ALOCPDFStyle.createSectionDataCell(allInRatePerAnnumAreasInAdvance, localComm.getLocalCommissionValue().toString()));
		}else{
			competingBidRepliesTable.addCell(ALOCPDFStyle.createSectionDataCell(allInRatePerAnnumAreasInAdvance, ALOCConstants.HYPEN.toString()));
		}
		if(allInCommId!=null && allInCommId == ALOCConstants.THIRD_VALUE && allInComm.getAllinCommissionValue()!=null){
			competingBidRepliesTable.addCell(ALOCPDFStyle.createSectionDataCell(flatFeeInAdvance, allInComm.getAllinCommissionValue().toString()));
		}else{
			competingBidRepliesTable.addCell(ALOCPDFStyle.createSectionDataCell(flatFeeInAdvance, ALOCConstants.HYPEN.toString()));
		}
		if(localCommId!=null && localCommId == ALOCConstants.THIRD_VALUE && localComm.getLocalCommissionValue()!=null){
			competingBidRepliesTable.addCell(ALOCPDFStyle.createSectionDataCell(flatFeeInAdvance, localComm.getLocalCommissionValue().toString()));
		}else{
			competingBidRepliesTable.addCell(ALOCPDFStyle.createSectionDataCell(flatFeeInAdvance, ALOCConstants.HYPEN.toString()));
		}
		if(allInCommId!=null && allInCommId == ALOCConstants.FOURTH_VALUE && allInComm.getAllinCommissionValue()!=null){
			competingBidRepliesTable.addCell(ALOCPDFStyle.createSectionDataCell(flatFeeLifeInAdvance, allInComm.getAllinCommissionValue().toString()));
		}else{
			competingBidRepliesTable.addCell(ALOCPDFStyle.createSectionDataCell(flatFeeLifeInAdvance, ALOCConstants.HYPEN.toString()));
		}
		if(localCommId!=null && localCommId == ALOCConstants.FOURTH_VALUE && localComm.getLocalCommissionValue()!=null){
			competingBidRepliesTable.addCell(ALOCPDFStyle.createSectionDataCell(flatFeeLifeInAdvance, localComm.getLocalCommissionValue().toString()));
		}else{
			competingBidRepliesTable.addCell(ALOCPDFStyle.createSectionDataCell(flatFeeLifeInAdvance, ALOCConstants.HYPEN.toString()));
		}
		String amemdmentTransactionFee = ALOCPDFReportHelper.getResourceValue(RES_KEY_AMDTRANS_FEE);
		if(allInComm.getAmendmentTransactionFee()!=null){
			competingBidRepliesTable.addCell(ALOCPDFStyle.createSectionDataCell(amemdmentTransactionFee, ALOCPDFReportHelper.formatCurrency(allInComm.getAmendmentTransactionFee())));
		}
		String amemdmentTransactionFeeLoc = ALOCPDFReportHelper.getResourceValue(RES_KEY_AMDTRANS_FEE);
		if(localComm.getLocalAmendmentTransactionFee()!=null){
			competingBidRepliesTable.addCell(ALOCPDFStyle.createSectionDataCell(amemdmentTransactionFeeLoc, ALOCPDFReportHelper.formatCurrency(localComm.getLocalAmendmentTransactionFee())));
		}
		return competingBidRepliesTable;
	}

	/**
	 * fillOneTimeFeeTable
	 * @param oneTimeFeeTable
	 * @param currWinBak
	 * @return oneTimeFeeTable
	 */
	private PdfPTable fillOneTimeFeeTable(PdfPTable oneTimeFeeTable, CurrentWinningBank currWinBak) {

		oneTimeFeeTable.addCell(ALOCPDFStyle.createMultiSectionTitle(ALOCPDFReportHelper.getResourceValue(RES_KEY_ONETIMEFEE)));

		OnetimeFees oneTimeFees= currWinBak.getOnetimeFees();

		String vatTaxes = ALOCPDFReportHelper.getResourceValue(RES_KEY_VATTAXES);
		if(oneTimeFees.getVatTaxes()!=null){
			oneTimeFeeTable.addCell(ALOCPDFStyle.createSectionDataCell(vatTaxes, ALOCPDFReportHelper.formatCurrency(oneTimeFees.getVatTaxes())));
		}else{
			oneTimeFeeTable.addCell(ALOCPDFStyle.createSectionDataCell(vatTaxes,  ALOCConstants.HYPEN.toString()));
		}
		String stampTaxes = ALOCPDFReportHelper.getResourceValue(RES_KEY_STAMPTAXES);
		if(oneTimeFees.getStampTaxes()!=null){
			oneTimeFeeTable.addCell(ALOCPDFStyle.createSectionDataCell(stampTaxes,ALOCPDFReportHelper.formatCurrency(oneTimeFees.getStampTaxes())));
		}else{
			oneTimeFeeTable.addCell(ALOCPDFStyle.createSectionDataCell(stampTaxes,  ALOCConstants.HYPEN.toString()));
		}
		String adminTaxes = ALOCPDFReportHelper.getResourceValue(RES_KEY_ADMINFEE);
		if(oneTimeFees.getIncidentalAdminFee()!=null){
			oneTimeFeeTable.addCell(ALOCPDFStyle.createSectionDataCell(adminTaxes, ALOCPDFReportHelper.formatCurrency(oneTimeFees.getIncidentalAdminFee())));
		}else{
			oneTimeFeeTable.addCell(ALOCPDFStyle.createSectionDataCell(adminTaxes, ALOCConstants.HYPEN.toString()));
		}
		String otherTaxes = ALOCPDFReportHelper.getResourceValue(RES_KEY_OTHER);
		if(oneTimeFees.getOther()!=null){
			oneTimeFeeTable.addCell(ALOCPDFStyle.createSectionDataCell(otherTaxes, ALOCPDFReportHelper.formatCurrency(oneTimeFees.getOther())));
		}else{
			oneTimeFeeTable.addCell(ALOCPDFStyle.createSectionDataCell(otherTaxes,  ALOCConstants.HYPEN.toString()));
		}
		return oneTimeFeeTable;
	}

	/**
	 * This is append Current Bank Fees
	 * @return
	 */
	public RequestBuilder appendCurrentBankFees() throws DocumentException {

		List<AuditLog> auditLogs = requestDetails.getAuditLogs();

		String currentBankFeeTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_CURRENT_BANK_FEES);
		Section section = ALOCPDFStyle.createSection(currentBankFeeTitle,reportContext.getCurrentChapter());

		PdfPTable bankNameTable = ALOCPDFStyle.createSectionDataTable();
		bankNameTable.addCell(ALOCPDFStyle.createSingleSectionDataCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_BANK_NAME)));

		String issuingBankBranch = ALOCPDFReportHelper.getResourceValue(RES_KEY_ISSUING_BANK_BRANCH);
		String issuingBankBranchValue = null;
		bankNameTable.addCell(ALOCPDFStyle.createSectionDataCell(issuingBankBranch, issuingBankBranchValue));
		String bankReferenceNum = ALOCPDFReportHelper.getResourceValue(RES_KEY_BANKREF_NUMBER);
		String bankReferenceNumValue = null;
		bankNameTable.addCell(ALOCPDFStyle.createSectionDataCell(bankReferenceNum, bankReferenceNumValue));
		
		PdfPTable currentBankFeeTable = ALOCPDFStyle.createMultiSectionDataTable();
		currentBankFeeTable=fillCurrentBankFeeTable(currentBankFeeTable); 
		
		PdfPTable currentBankFeeSecitonTable = ALOCPDFStyle.createMultiSectionDataTable();
		currentBankFeeSecitonTable=fillCurrentBankFeeSectionTable(currentBankFeeSecitonTable);

		PdfPTable commentsTable = ALOCPDFStyle.createSectionDataTable();
		commentsTable.addCell(ALOCPDFStyle.createSingleSectionDataCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_COMMENT)));

		String comments = ALOCPDFReportHelper.getResourceValue(RES_KEY_COMMENT);
		String commentsValue = null;
		commentsTable.addCell(ALOCPDFStyle.createSectionDataCell(comments, commentsValue));

		PdfPTable auditTable = ALOCPDFStyle.createSectionDataTable();
		auditTable=fillAuditTable(auditTable,auditLogs);

		section.add(bankNameTable);
		section.add(currentBankFeeTable);
		section.add(currentBankFeeSecitonTable);
		section.add(commentsTable);
		section.add(auditTable);
		return this;
	}
	/**
	 * fillAuditTable to fill Audit Table details
	 * @param auditTable
	 * @param auditLogs
	 * @return auditTable
	 */
	private PdfPTable fillAuditTable(PdfPTable auditTable,List<AuditLog> auditLogs) {
		auditTable.addCell(ALOCPDFStyle.createSingleSectionDataCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_AUDITLOG)));

		PdfPTable auditLogTable = ALOCPDFStyle.createTable(25f, 20f, 15f, 20f, 20f,20f,20f);
		auditLogTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_INITIATION_DATE)));
		auditLogTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_TRANSACTION_COMPLETION_DATE)));
		auditLogTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_ALOC_RECORD_NUMBER)));
		auditLogTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_ATTRIBUTE_CHANGED)));
		auditLogTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_OLDVALUE)));
		auditLogTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_UPDATEDVALUE)));
		auditLogTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_ACTIONTAKENBY)));

		if(auditLogs != null){
			for(AuditLog auditLog : auditLogs) {
				String auditCreatedDt = (auditLog != null) ?  ALOCPDFReportHelper.formatDate(auditLog.getAuditCreatedDt()) : null;
				auditLogTable.addCell(ALOCPDFStyle.createTableDataCell(auditCreatedDt)); 
				String transactionCompletionDt = null;
				auditLogTable.addCell(ALOCPDFStyle.createTableDataCell(transactionCompletionDt));
				String alocRecordNumber = null;
				auditLogTable.addCell(ALOCPDFStyle.createTableDataCell(alocRecordNumber));
				String fieldName = (auditLog != null) ? auditLog.getFieldName() : null;
				auditLogTable.addCell(ALOCPDFStyle.createTableDataCell(fieldName));				
				String oldValue = (auditLog != null) ? auditLog.getOldValue() : null;
				auditLogTable.addCell(ALOCPDFStyle.createTableDataCell(oldValue));
				String newValue = (auditLog != null) ? auditLog.getNewValue() : null;
				auditLogTable.addCell(ALOCPDFStyle.createTableDataCell(newValue));

				StringBuilder fullName = new StringBuilder();
				String name=null;
				if(StringUtils.isNotBlank(auditLog.getAuthorLastName())) {
					fullName.append(auditLog.getAuthorLastName());
				}
				if(StringUtils.isNotBlank(auditLog.getAuthorFirstName())) {
					if(fullName.length() > ALOCConstants.BASE_VALUE) {
						fullName.append(ALOCConstants.COMMA_SPACE);
					}
					fullName.append(auditLog.getAuthorFirstName());
				}
				if(fullName != null){
					name= fullName.toString();
				}
				auditLogTable.addCell(ALOCPDFStyle.createTableDataCell(name));
			}			
		}
		auditTable.addCell(auditLogTable);
		return auditLogTable;
		
	}
	/**
	 * fillCurrentBankFeeSectionTable to fill Current Bank FeeSection Table details
	 * @param currentBankFeeSecitonTable
	 * @return currentBankFeeSecitonTable
	 */
	private PdfPTable fillCurrentBankFeeSectionTable(PdfPTable currentBankFeeSecitonTable) {
		currentBankFeeSecitonTable.addCell(ALOCPDFStyle.createMultiSectionTitle(ALOCPDFReportHelper.getResourceValue(RES_KEY_ONETIMEFEE)));
		currentBankFeeSecitonTable.addCell(ALOCPDFStyle.createMultiSectionTitle(ALOCPDFReportHelper.getResourceValue(RES_KEY_POST_BID_REPLY_FEE_ADJUSTMENT)));

		PdfPTable oneTimeFeeTable = ALOCPDFStyle.createTable(5f,5f,5f);
		oneTimeFeeTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_FEE_TYPE)));
		oneTimeFeeTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_CUMULATIVE)));
		oneTimeFeeTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_ADDITIONAL_AMOUNT)));

		String vatTaxes = ALOCPDFReportHelper.getResourceValue(RES_KEY_VATTAXES);
		oneTimeFeeTable.addCell(ALOCPDFStyle.createTableDataCell(vatTaxes));
		String vatCumulative = null;
		oneTimeFeeTable.addCell(ALOCPDFStyle.createTableDataCell(vatCumulative));
		String vatAddAmount = null;
		oneTimeFeeTable.addCell(ALOCPDFStyle.createTableDataCell(vatAddAmount));

		String stampTaxes = ALOCPDFReportHelper.getResourceValue(RES_KEY_STAMPTAXES);
		oneTimeFeeTable.addCell(ALOCPDFStyle.createTableDataCell(stampTaxes));
		String stampCumulative = null;
		oneTimeFeeTable.addCell(ALOCPDFStyle.createTableDataCell(stampCumulative));
		String stampAddAmount = null;
		oneTimeFeeTable.addCell(ALOCPDFStyle.createTableDataCell(stampAddAmount));

		String adminTaxes = ALOCPDFReportHelper.getResourceValue(RES_KEY_ADMINFEE);
		oneTimeFeeTable.addCell(ALOCPDFStyle.createTableDataCell(adminTaxes));
		String adminCumulative = null;
		oneTimeFeeTable.addCell(ALOCPDFStyle.createTableDataCell(adminCumulative));
		String adminAddAmount = null;
		oneTimeFeeTable.addCell(ALOCPDFStyle.createTableDataCell(adminAddAmount));

		String otherTaxes = ALOCPDFReportHelper.getResourceValue(RES_KEY_OTHER);
		oneTimeFeeTable.addCell(ALOCPDFStyle.createTableDataCell(otherTaxes));
		String otherCumulative = null;
		oneTimeFeeTable.addCell(ALOCPDFStyle.createTableDataCell(otherCumulative));
		String otherAddAmount = null;
		oneTimeFeeTable.addCell(ALOCPDFStyle.createTableDataCell(otherAddAmount));

		currentBankFeeSecitonTable.addCell(oneTimeFeeTable);

		PdfPTable feeAdjustmentTable = ALOCPDFStyle.createTable(5f,5f,5f);
		feeAdjustmentTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_FEE_TYPE)));
		feeAdjustmentTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_CUMULATIVE)));
		feeAdjustmentTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_ADDITIONAL_AMOUNT)));

		String adjustTaxes = ALOCPDFReportHelper.getResourceValue(RES_KEY_ADJUSTMENT);
		feeAdjustmentTable.addCell(ALOCPDFStyle.createTableDataCell(adjustTaxes));
		String adjustCumulative = null;
		feeAdjustmentTable.addCell(ALOCPDFStyle.createTableDataCell(adjustCumulative));
		String adjustAddAmount = null;
		feeAdjustmentTable.addCell(ALOCPDFStyle.createTableDataCell(adjustAddAmount));

		currentBankFeeSecitonTable.addCell(feeAdjustmentTable);
		return feeAdjustmentTable;
		
	}
	/**
	 * fillCurrentBankFeeTable to fill Current Bank Fee Table details
	 * @param currentBankFeeTable
	 * @return currentBankFeeTable
	 */
	private PdfPTable fillCurrentBankFeeTable(PdfPTable currentBankFeeTable) {
		currentBankFeeTable.addCell(ALOCPDFStyle.createMultiSectionTitle(ALOCPDFReportHelper.getResourceValue(RES_KEY_ALLCOMMISSIONS)));
		currentBankFeeTable.addCell(ALOCPDFStyle.createMultiSectionTitle(ALOCPDFReportHelper.getResourceValue(RES_KEY_LOCALCOMMISSIONS)));

		String allInRatePerAnnumAreas = ALOCPDFReportHelper.getResourceValue(RES_KEY_RATE_ANNUMARREARS);
		String allInRatePerAnnumAreasValue = null;
		currentBankFeeTable.addCell(ALOCPDFStyle.createSectionDataCell(allInRatePerAnnumAreas, allInRatePerAnnumAreasValue));

		String allInRatePerAnnumAreasLocValue = null;
		currentBankFeeTable.addCell(ALOCPDFStyle.createSectionDataCell(allInRatePerAnnumAreas, allInRatePerAnnumAreasLocValue));

		String allInRatePerAnnumAreasInAdvance = ALOCPDFReportHelper.getResourceValue(RES_KEY_RATE_ANNUMINADVANCE);
		String allInRatePerAnnumAreasInAdvanceValue = null;
		currentBankFeeTable.addCell(ALOCPDFStyle.createSectionDataCell(allInRatePerAnnumAreasInAdvance, allInRatePerAnnumAreasInAdvanceValue));

		String allInRatePerAnnumAreasInAdvanceLocValue = null;
		currentBankFeeTable.addCell(ALOCPDFStyle.createSectionDataCell(allInRatePerAnnumAreasInAdvance, allInRatePerAnnumAreasInAdvanceLocValue));

		String flatFeePerAnnumInAdvance = ALOCPDFReportHelper.getResourceValue(RES_KEY_FLAT_ANNUMINADVANCE);
		String flatFeePerAnnumInAdvanceValue = null;
		currentBankFeeTable.addCell(ALOCPDFStyle.createSectionDataCell(flatFeePerAnnumInAdvance, flatFeePerAnnumInAdvanceValue));

		String flatFeePerAnnumInAdvanceLocValue = null;
		currentBankFeeTable.addCell(ALOCPDFStyle.createSectionDataCell(flatFeePerAnnumInAdvance, flatFeePerAnnumInAdvanceLocValue));

		String flatFeeLifeInAdvance = ALOCPDFReportHelper.getResourceValue(RES_KEY_FLAT_LIFEADVANCE);
		String flatFeeLifeInAdvanceValue = null;
		currentBankFeeTable.addCell(ALOCPDFStyle.createSectionDataCell(flatFeeLifeInAdvance, flatFeeLifeInAdvanceValue));

		String flatFeeLifeInAdvanceLocValue = null;
		currentBankFeeTable.addCell(ALOCPDFStyle.createSectionDataCell(flatFeeLifeInAdvance, flatFeeLifeInAdvanceLocValue));


		String amemdmentTransactionFee = ALOCPDFReportHelper.getResourceValue(RES_KEY_AMDTRANS_FEE);
		String amemdmentTransactionFeeValue = null;
		currentBankFeeTable.addCell(ALOCPDFStyle.createSectionDataCell(amemdmentTransactionFee, amemdmentTransactionFeeValue));

		String amemdmentTransactionFeeLocValue = null;
		currentBankFeeTable.addCell(ALOCPDFStyle.createSectionDataCell(amemdmentTransactionFee, amemdmentTransactionFeeLocValue));

		return currentBankFeeTable;
	}

	/**
	 * This method is used to append Audit Logs
	 * @return
	 */
	public RequestBuilder appendAuditLogs() throws DocumentException,HWFServiceException {
		requestDetails = ALOCPDFReportHelper.getTransactionAuditLogDetails(requestDetails.getWFDetails().getWFStage(), ALOCConstants.AUDIT, requestDetails.getRequestId(), requestDetails);
		List<AuditLog> auditLogs = requestDetails.getAuditLogs();
		PdfPTable auditLogTable = ALOCPDFStyle.createTable(25f, 20f, 15f, 20f, 20f,20f,20f);

		if(auditLogs.size()!=ALOCConstants.BASE_VALUE ){
			String auditLogTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_AUDITLOG);
			Section section = ALOCPDFStyle.createSection(auditLogTitle,reportContext.getCurrentChapter());

			auditLogTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_INITIATION_DATE)));
			auditLogTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_TRANSACTION_COMPLETION_DATE)));
			auditLogTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_ALOC_RECORD_NUMBER)));
			auditLogTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_ATTRIBUTE_CHANGED)));
			auditLogTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_OLDVALUE)));
			auditLogTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_UPDATEDVALUE)));
			auditLogTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_ACTIONTAKENBY)));

			for(AuditLog auditLog : auditLogs) {
				String auditCreatedDt = (auditLog != null) ?  ALOCPDFReportHelper.formatDate(auditLog.getAuditCreatedDt()) : null;
				auditLogTable.addCell(ALOCPDFStyle.createTableDataCell(auditCreatedDt));

				if(auditLog.getTransactionCompleteDt()!=null){
					auditLogTable.addCell(ALOCPDFStyle.createTableDataCell(ALOCPDFReportHelper.formatDate(auditLog.getTransactionCompleteDt())));
				}else{
					auditLogTable.addCell(ALOCPDFStyle.createTableDataCell(ALOCConstants.HYPEN.toString()));
				}

				String alocRecordNumber = null;
				if(auditLog.getAlocRecordId()!=null){
					alocRecordNumber = auditLog.getAlocRecordId();
				}
				auditLogTable.addCell(ALOCPDFStyle.createTableDataCell(alocRecordNumber));

				String fieldName = (auditLog != null) ? auditLog.getFieldName() : null;
				auditLogTable.addCell(ALOCPDFStyle.createTableDataCell(fieldName));				

				String oldValue = (auditLog != null) ? auditLog.getOldValue() : null;
				auditLogTable.addCell(ALOCPDFStyle.createTableDataCell(oldValue));

				String newValue = (auditLog != null) ? auditLog.getNewValue() : null;
				auditLogTable.addCell(ALOCPDFStyle.createTableDataCell(newValue));

				StringBuilder fullName = new StringBuilder();
				String name=null;
				if(StringUtils.isNotBlank(auditLog.getAuthorLastName())) {
					fullName.append(auditLog.getAuthorLastName());
				}
				if(StringUtils.isNotBlank(auditLog.getAuthorFirstName())) {
					if(fullName.length() > ALOCConstants.BASE_VALUE) {
						fullName.append(ALOCConstants.COMMA_SPACE);
					}
					fullName.append(auditLog.getAuthorFirstName());
				}
				if(fullName != null){
					name= fullName.toString();
				}
				auditLogTable.addCell(ALOCPDFStyle.createTableDataCell(name));
			}
			section.add(auditLogTable);
		}		

		return this;
	}

	/**
	 * This method is used to append Audit Logs
	 * @return
	 * @throws HWFServiceException 
	 */
	public RequestBuilder appendFeeHisory() throws DocumentException, HWFServiceException {
		FeeHistoryDetails feeHistoryDetails = ALOCPDFReportHelper.getFeeHisory(requestDetails.getRequestId());
		PdfPTable feeHistoryTable = ALOCPDFStyle.createTable(10f, 15f, 15f, 15f, 15f, 15f, 15f);

		if(feeHistoryDetails != null){
			List<FullSummary>  feeHistoryList = feeHistoryDetails.getFullSummaries();

			if(feeHistoryList.size()!=ALOCConstants.BASE_VALUE){
				String feeHistoryTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_FEEHISTORY);
				Section section = ALOCPDFStyle.createSection(feeHistoryTitle,reportContext.getCurrentChapter());

				feeHistoryTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_PAYMENTID)));
				feeHistoryTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_PAYMENTDATE)));
				feeHistoryTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_PAYMENTCURRENCY)));
				feeHistoryTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_PAYMENTAMOUNT)));
				feeHistoryTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_USDEQUIVALENT)));
				feeHistoryTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_EXPDATE)));
				feeHistoryTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_ECOEXPDATE)));

				for(FullSummary feeHistory : feeHistoryList) {
					String paymentId = (feeHistory.getPaymentID() != null) ? feeHistory.getPaymentID().toString() : null;
					feeHistoryTable.addCell(ALOCPDFStyle.createTableDataCell(paymentId)); 
					String paymentDate =(feeHistory != null) ? ALOCPDFReportHelper.formatDate(feeHistory.getPaymentDate()) : null;
					feeHistoryTable.addCell(ALOCPDFStyle.createTableDataCell(paymentDate));
					String paymentCurrency = (feeHistory != null) ? feeHistory.getPaymentCurrencyName() : null;
					feeHistoryTable.addCell(ALOCPDFStyle.createTableDataCell(paymentCurrency));				
					String paymentAmount = (feeHistory != null) ? ALOCPDFReportHelper.formatCurrency(feeHistory.getPaymentAmount()) : null;
					feeHistoryTable.addCell(ALOCPDFStyle.createTableDataCell(paymentAmount));
					String usdEquivalent = (feeHistory != null) ? ALOCPDFReportHelper.formatCurrency(feeHistory.getUSDPaymentAmount()) : null;
					feeHistoryTable.addCell(ALOCPDFStyle.createTableDataCell(usdEquivalent));
					String expDate = (feeHistory != null) ? ALOCPDFReportHelper.formatDate(feeHistory.getExpiryDt()) : null;
					feeHistoryTable.addCell(ALOCPDFStyle.createTableDataCell(expDate));
					String ecoExpDate = (feeHistory != null) ? ALOCPDFReportHelper.formatDate(feeHistory.getEconomicExpiryDt()) : null;
					feeHistoryTable.addCell(ALOCPDFStyle.createTableDataCell(ecoExpDate));
				}
				section.add(feeHistoryTable);
			}
		}		
		return this;
	}

	/**
	 * This is append linked Transactions
	 * @return
	 * @throws HWFServiceException 
	 */
	public RequestBuilder appendLinkedTransactions() throws DocumentException, HWFServiceException {
		RequestDetailsCollectionType reqDetails = ALOCPDFReportHelper.getLinkedTransactions(requestDetails.getRequestId());
		PdfPTable linkedTable = ALOCPDFStyle.createTable(10f, 13f, 15f, 8f, 12f, 15f, 14f, 14f);
		if(reqDetails!=null){
			List<RequestDetails> reqDetLst = reqDetails.getRequestDetails();
			if(reqDetLst.size()!=ALOCConstants.BASE_VALUE){
				String flinkedTranTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_LINKED_TRANASACTIONS);
				Section section = ALOCPDFStyle.createSection(flinkedTranTitle,reportContext.getCurrentChapter());

				linkedTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_DATE_LINKED)));
				linkedTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_ALOC_RECORD_NUMBER)));
				linkedTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_INSTUEMENT_AMOUNT)));
				linkedTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_LINK_CURRENCY_CODE)));
				linkedTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_INSTAMOUNT)));
				linkedTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_REQ_NAME_SSO)));
				linkedTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_APP_PRN_NAME)));
				linkedTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_BEN_OBL_NAME)));

				for(RequestDetails eachReqDet : reqDetLst) {
					BigInteger instId = eachReqDet.getInstrumentTypeId();

					if(eachReqDet.getLastSaveTime()!=null){
						linkedTable.addCell(ALOCPDFStyle.createTableDataCell(ALOCPDFReportHelper.formatDate(eachReqDet.getLastSaveTime())));
					}else{
						linkedTable.addCell(ALOCPDFStyle.createTableDataCell(ALOCConstants.HYPEN.toString()));
					}

					if(eachReqDet.getAlocRecordId()!=null){
						linkedTable.addCell(ALOCPDFStyle.createTableDataCell(eachReqDet.getAlocRecordId()));
					}else{
						linkedTable.addCell(ALOCPDFStyle.createTableDataCell(ALOCConstants.HYPEN.toString()));
					}
					if(StringUtils.isNotBlank(eachReqDet.getInstrumentType())){
						linkedTable.addCell(ALOCPDFStyle.createTableDataCell(eachReqDet.getInstrumentType()));
					}else{
						linkedTable.addCell(ALOCPDFStyle.createTableDataCell(ALOCConstants.HYPEN.toString()));
					}
					linkedTable = fillInstrumentCurrency(eachReqDet,instId,linkedTable);
					linkedTable = fillInstrumentAmount(eachReqDet,instId,linkedTable);
					linkedTable.addCell(ALOCPDFStyle.createTableDataCell(eachReqDet.getRequestorLName()+ALOCConstants.COMMA+eachReqDet.getRequestorFName()+eachReqDet.getRequestorSSO()));
					linkedTable = fillApplicantName(eachReqDet,instId,linkedTable);			
				}
				section.add(linkedTable);
			}
		}
		
		return this;
	}
	/**
	 * fillApplicantName to fill the Applicant Name
	 * @param eachReqDet
	 * @param instId
	 * @param linkedTable
	 * @return linkedTable
	 */
	private PdfPTable fillApplicantName(RequestDetails eachReqDet,BigInteger instId, PdfPTable linkedTable) {
		if(instId!=null){
			String appName = null;
			if((instId.equals(BigInteger.valueOf(InstrumentType.BANK_GUARANTEE.getId())) || instId.equals(BigInteger.valueOf(InstrumentType.LOC.getId())) || instId.equals(BigInteger.valueOf(InstrumentType.SURETY_BOND.getId()))) && eachReqDet.getTransactionParties()!=null){
				appName = eachReqDet.getTransactionParties().getTpApplicantDetails().getAddressDtls().getName();
			}else if(instId.equals(BigInteger.valueOf(InstrumentType.SURETY_BOND.getId())) && eachReqDet.getPrincipal()!=null){
				appName = eachReqDet.getPrincipal().getAddressDtls().getName();
			}
			if(appName!=null){
				linkedTable.addCell(ALOCPDFStyle.createTableDataCell(appName));
			}else{
				linkedTable.addCell(ALOCPDFStyle.createTableDataCell(ALOCConstants.HYPEN.toString()));
			}
		}else{
			linkedTable.addCell(ALOCPDFStyle.createTableDataCell(ALOCConstants.HYPEN.toString()));
		}

		if(instId!=null){
			String oblName  = null;

			if((instId.equals(BigInteger.valueOf(InstrumentType.BANK_GUARANTEE.getId())) || instId.equals(BigInteger.valueOf(InstrumentType.LOC.getId()))) && eachReqDet.getTransactionParties()!=null){
				oblName = eachReqDet.getTransactionParties().getCustomer().getAddressDtls().getName();
			}else if(instId.equals(BigInteger.valueOf(InstrumentType.SURETY_BOND.getId())) && eachReqDet.getObligee()!=null){
				oblName = eachReqDet.getObligee().getAddressDtls().getName();
			}else if(instId.equals(BigInteger.valueOf(InstrumentType.DOCUMENT_LOC.getId())) && eachReqDet.getBeneficiaryDetails()!=null){
				oblName = eachReqDet.getBeneficiaryDetails().getAddressDtls().getName();
			}

			if(oblName!=null){
				linkedTable.addCell(ALOCPDFStyle.createTableDataCell(oblName));
			}else{
				linkedTable.addCell(ALOCPDFStyle.createTableDataCell(ALOCConstants.HYPEN.toString()));
			}
		}else{
			linkedTable.addCell(ALOCPDFStyle.createTableDataCell(ALOCConstants.HYPEN.toString()));
		}
		return linkedTable;
	}
	/**
	 * fillInstrumentCurrency to fill the Instrument Currency
	 * @param eachReqDet
	 * @param instId
	 * @param linkedTable
	 * @return linkedTable
	 */
	private PdfPTable fillInstrumentCurrency( RequestDetails eachReqDet,BigInteger instId,PdfPTable linkedTable) {
		if(instId!=null){
			String curCode  = null;

			if((instId.equals(BigInteger.valueOf(InstrumentType.BANK_GUARANTEE.getId())) || instId.equals(BigInteger.valueOf(InstrumentType.LOC.getId()))) && eachReqDet.getInstrumentDetails()!=null){
				curCode = eachReqDet.getInstrumentDetails().getInstrumentCurrencyId();
			}else if(instId.equals(BigInteger.valueOf(InstrumentType.SURETY_BOND.getId())) && eachReqDet.getBondInfo()!=null){
				curCode = eachReqDet.getBondInfo().getBondCurrencyCd();
			}else if(instId.equals(BigInteger.valueOf(InstrumentType.DOCUMENT_LOC.getId())) && eachReqDet.getTransactionDetails()!=null){
				curCode = eachReqDet.getTransactionDetails().getDocLCCurId();
			}

			if(curCode!=null){
				linkedTable.addCell(ALOCPDFStyle.createTableDataCell(curCode.toString()));
			}else{
				linkedTable.addCell(ALOCPDFStyle.createTableDataCell(ALOCConstants.HYPEN.toString()));
			}
		}else{
			linkedTable.addCell(ALOCPDFStyle.createTableDataCell(ALOCConstants.HYPEN.toString()));
		}
		return linkedTable;
		
	}

	/**
	 * fillInstrumentCurrency to fill the Instrument Currency
	 * @param eachReqDet
	 * @param instId
	 * @param linkedTable
	 * @return linkedTable
	 */
	private PdfPTable fillInstrumentAmount( RequestDetails eachReqDet,BigInteger instId,PdfPTable linkedTable) {
		if(instId!=null){
			BigDecimal instrumentAmount  = null;
			if((instId.equals(BigInteger.valueOf(InstrumentType.BANK_GUARANTEE.getId())) || instId.equals(BigInteger.valueOf(InstrumentType.LOC.getId()))) && eachReqDet.getInstrumentDetails()!=null){
				instrumentAmount = eachReqDet.getInstrumentDetails().getInstrumentAmt();
			}else if(instId.equals(BigInteger.valueOf(InstrumentType.SURETY_BOND.getId())) && eachReqDet.getBondInfo()!=null){
				if(eachReqDet.getBondDetails()!=null && eachReqDet.getBondDetails().getBondTypeId()!=null && eachReqDet.getBondDetails().getBondTypeId().intValue()==ALOCConstants.CONTRACTBOND_ID){
					instrumentAmount = eachReqDet.getBondInfo().getContractAmt();
				}else if(eachReqDet.getBondDetails()!=null && eachReqDet.getBondDetails().getBondTypeId()!=null && eachReqDet.getBondDetails().getBondTypeId().intValue()==ALOCConstants.COURT_BOND_ID){
					instrumentAmount = eachReqDet.getBondInfo().getCourtBondAmt();
				}if(eachReqDet.getBondDetails()!=null && eachReqDet.getBondDetails().getBondTypeId()!=null){
					instrumentAmount = eachReqDet.getBondInfo().getBondAmount();
				}
				
			}else if(instId.equals(BigInteger.valueOf(InstrumentType.DOCUMENT_LOC.getId())) && eachReqDet.getTransactionDetails()!=null){
				instrumentAmount = eachReqDet.getTransactionDetails().getDocLCAmt();
			}

			if(instrumentAmount!=null){
				linkedTable.addCell(ALOCPDFStyle.createTableDataCell(ALOCPDFReportHelper.formatCurrency(instrumentAmount)));
			}else{
				linkedTable.addCell(ALOCPDFStyle.createTableDataCell(ALOCConstants.HYPEN.toString()));
			}
		}else{
			linkedTable.addCell(ALOCPDFStyle.createTableDataCell(ALOCConstants.HYPEN.toString()));
		}
		return linkedTable;
		
	}
	/**
	 * This is append Bundle Transactions
	 * @return
	 */
	public RequestBuilder appendBundleTransactions() throws DocumentException, HWFServiceException {
		List<RequestDetails> reqDetailsLst = ALOCPDFReportHelper.getBundleTransactions(requestDetails);
		PdfPTable bundledTable = ALOCPDFStyle.createTable(10f, 8f, 20f, 20f, 15f, 10f, 10f, 7f);
		if(reqDetailsLst.size()!=ALOCConstants.BASE_VALUE){
			String flinkedTranTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_BUNDLED_TRANSACTIONS);
			Section section = ALOCPDFStyle.createSection(flinkedTranTitle,reportContext.getCurrentChapter());
			bundledTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_ALOC_RECORD_NUMBER)));
			bundledTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_BUNDLEID)));
			bundledTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_BEN_OBLIGEE)));
			bundledTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_APP_PRINCIPAL)));
			bundledTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_REQUESTOR)));
			bundledTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_REQUESTDATE)));
			bundledTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_INSTAMOUNT)));
			bundledTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_CURRENCY)));
			for(RequestDetails eachReqDet : reqDetailsLst) {
				BigInteger instId = eachReqDet.getInstrumentTypeId();
				if(eachReqDet.getRequestId()!=null){
					bundledTable.addCell(ALOCPDFStyle.createTableDataCell(eachReqDet.getAlocRecordId()));
				}else{
					bundledTable.addCell(ALOCPDFStyle.createTableDataCell(ALOCConstants.HYPEN.toString()));
				}
				if(eachReqDet.getBundleDetails()!=null && eachReqDet.getBundleDetails().getBundleId()!=null){
					bundledTable.addCell(ALOCPDFStyle.createTableDataCell(eachReqDet.getBundleDetails().getBundleId().toString()));
				}else{
					bundledTable.addCell(ALOCPDFStyle.createTableDataCell(ALOCConstants.HYPEN.toString()));
				}
				bundledTable = fillBundleAddressDetails(eachReqDet,instId,bundledTable);
				bundledTable = fillBundleCurrencyAndAmount(eachReqDet,instId,bundledTable);
			}
			section.add(bundledTable);
		}
		return this;
	}

	private PdfPTable fillBundleCurrencyAndAmount(RequestDetails eachReqDet,BigInteger instId,PdfPTable bundledTable) {
		
		if(instId!=null){
			BigDecimal instAmount  = null;
			if((instId.equals(BigInteger.valueOf(InstrumentType.BANK_GUARANTEE.getId())) || instId.equals(BigInteger.valueOf(InstrumentType.LOC.getId()))) && eachReqDet.getInstrumentDetails()!=null){
				instAmount = eachReqDet.getInstrumentDetails().getInstrumentAmt();
			}else if(instId.equals(BigInteger.valueOf(InstrumentType.DOCUMENT_LOC.getId())) && eachReqDet.getTransactionDetails()!=null){
				instAmount = eachReqDet.getTransactionDetails().getDocLCAmt();
			}
			if(instAmount!=null){
				bundledTable.addCell(ALOCPDFStyle.createTableDataCell(ALOCPDFReportHelper.formatCurrency(instAmount)));
			}else{
				bundledTable.addCell(ALOCPDFStyle.createTableDataCell(ALOCConstants.HYPEN.toString()));
			}
		}else{
			bundledTable.addCell(ALOCPDFStyle.createTableDataCell(ALOCConstants.HYPEN.toString()));
		}
		
		if(instId!=null){
			String curCode  = null;
			if((instId.equals(BigInteger.valueOf(InstrumentType.BANK_GUARANTEE.getId())) || instId.equals(BigInteger.valueOf(InstrumentType.LOC.getId()))) && eachReqDet.getInstrumentDetails()!=null){
				curCode = eachReqDet.getInstrumentDetails().getInstrumentCurrencyId();
			}else if(instId.equals(BigInteger.valueOf(InstrumentType.DOCUMENT_LOC.getId())) && eachReqDet.getTransactionDetails()!=null){
				curCode = eachReqDet.getTransactionDetails().getDocLCCurId();
			}
			if(curCode!=null){
				bundledTable.addCell(ALOCPDFStyle.createTableDataCell(curCode.toString()));
			}else{
				bundledTable.addCell(ALOCPDFStyle.createTableDataCell(ALOCConstants.HYPEN.toString()));
			}
		}else{
			bundledTable.addCell(ALOCPDFStyle.createTableDataCell(ALOCConstants.HYPEN.toString()));
		}
		
		return bundledTable;
	}

	private PdfPTable fillBundleAddressDetails(RequestDetails eachReqDet,BigInteger instId,PdfPTable bundledTable) {
		if(instId!=null){
			String[] addressValues = null;
			if((instId.equals(BigInteger.valueOf(InstrumentType.BANK_GUARANTEE.getId())) || instId.equals(BigInteger.valueOf(InstrumentType.LOC.getId()))) && eachReqDet.getTransactionParties()!=null){
				AddressDtls addDet = eachReqDet.getTransactionParties().getCustomer().getAddressDtls();
				addressValues = ALOCPDFReportHelper.convertAddressAsString(addDet);
			}

			if(instId.equals(BigInteger.valueOf(InstrumentType.DOCUMENT_LOC.getId())) && eachReqDet.getBeneficiaryDetails()!=null){
				AddressDtls addDet = eachReqDet.getBeneficiaryDetails().getAddressDtls();
				addressValues = ALOCPDFReportHelper.convertAddressAsString(addDet);
			}
			if(addressValues!=null){
				bundledTable.addCell(ALOCPDFStyle.createTableMultipleDataCells(addressValues));
			}else{
				bundledTable.addCell(ALOCPDFStyle.createTableDataCell(ALOCConstants.HYPEN.toString()));
			}
		}else{
			bundledTable.addCell(ALOCPDFStyle.createTableDataCell(ALOCConstants.HYPEN.toString()));
		}
		if(instId!=null){
			String[] addressValues = null;

			if((instId.equals(BigInteger.valueOf(InstrumentType.BANK_GUARANTEE.getId())) || instId.equals(BigInteger.valueOf(InstrumentType.LOC.getId()))) && eachReqDet.getTransactionParties()!=null){
				AddressDtls addDet = eachReqDet.getTransactionParties().getTpApplicantDetails().getAddressDtls();
				addressValues = ALOCPDFReportHelper.convertAddressAsString(addDet);	
			}
			if(instId.equals(BigInteger.valueOf(InstrumentType.DOCUMENT_LOC.getId())) && eachReqDet.getApplicantDetails()!=null){
				AddressDtls addDet = eachReqDet.getApplicantDetails().getAddressDtls();
				addressValues = ALOCPDFReportHelper.convertAddressAsString(addDet);		
			}
			if(addressValues!=null){
				bundledTable.addCell(ALOCPDFStyle.createTableMultipleDataCells(addressValues));
			}else{
				bundledTable.addCell(ALOCPDFStyle.createTableDataCell(ALOCConstants.HYPEN.toString()));
			}
		}else{
			bundledTable.addCell(ALOCPDFStyle.createTableDataCell(ALOCConstants.HYPEN.toString()));
		}
		bundledTable.addCell(ALOCPDFStyle.createTableDataCell(eachReqDet.getRequestorLName()+ALOCConstants.COMMA+eachReqDet.getRequestorFName()));
		if(eachReqDet.getLastSaveTime()!=null){
			bundledTable.addCell(ALOCPDFStyle.createTableDataCell(ALOCPDFReportHelper.formatDate(eachReqDet.getLastSaveTime())));
		}else{
			bundledTable.addCell(ALOCPDFStyle.createTableDataCell(ALOCConstants.HYPEN.toString()));
		}
		return bundledTable;
	}

	/**
	 * This is append Amendments Details for Taxonomy
	 * @return
	 * @throws HWFServiceException 
	 */
	public RequestBuilder appendAmendments() throws DocumentException, HWFServiceException {
		GetAmendmentRiders amendments = ALOCPDFReportHelper.getAmendmentDetails(requestDetails.getRequestId());
		PdfPTable amendmentsTable = ALOCPDFStyle.createTable(10f, 20f, 10f, 13f, 13f);
		List<AmendmentDetails> amendmentLst = amendments.getAmendmentDetails();

		if(amendmentLst.size()!=ALOCConstants.BASE_VALUE){
			String amendmentsTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_AMENDMENTS);		
			Section section = ALOCPDFStyle.createSection(amendmentsTitle,reportContext.getCurrentChapter());
			
			amendmentsTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_ALOC_RECORD_NUMBER)));
			amendmentsTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_REQUESTOR)));
			amendmentsTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_AMOUNT)));
			amendmentsTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_EXPIRATIONDATE_TITLE)));
			amendmentsTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_REQUESTDATE)));

			for(AmendmentDetails eachAmendment : amendmentLst){
				amendmentsTable.addCell(ALOCPDFStyle.createTableDataCell((eachAmendment.getAmendmentRequestId()!=null) ? eachAmendment.getAmendmentRequestId().toString() : null));
				amendmentsTable.addCell(ALOCPDFStyle.createTableDataCell(eachAmendment.getLastName()+ALOCConstants.COMMA+eachAmendment.getFirstName()));
				amendmentsTable.addCell(ALOCPDFStyle.createTableDataCell((eachAmendment.getInstrumentAmt()!=null) ? eachAmendment.getInstrumentAmt().toString() : null));
				amendmentsTable.addCell(ALOCPDFStyle.createTableDataCell((eachAmendment.getExpiryDate()!=null) ? ALOCPDFReportHelper.formatDate(eachAmendment.getExpiryDate()) : null));
				amendmentsTable.addCell(ALOCPDFStyle.createTableDataCell((eachAmendment.getRequestDate()!=null) ? ALOCPDFReportHelper.formatDate(eachAmendment.getRequestDate()) : null));
			}
			section.add(amendmentsTable);
		}

		return this;
	}


	/**
	 * This is append Riders Details for Taxonomy
	 * @return
	 * @throws HWFServiceException 
	 */
	public RequestBuilder appendRiders() throws DocumentException, HWFServiceException {
		GetAmendmentRiders riders = ALOCPDFReportHelper.getRiderDetails(requestDetails.getRequestId());
		PdfPTable amendmentsTable = ALOCPDFStyle.createTable(10f, 20f, 15f, 10f, 10f);
		List<RiderDetails> riderLst = riders.getRiderDetails();

		if(riderLst.size()!=ALOCConstants.BASE_VALUE){
			String ridersTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_RIDERS);		
			Section section = ALOCPDFStyle.createSection(ridersTitle,reportContext.getCurrentChapter());
			
			amendmentsTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_ALOC_RECORD_NUMBER)));
			amendmentsTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_REQUESTOR)));
			amendmentsTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_AMOUNT)));
			amendmentsTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_EXPIRATIONDATE_TITLE)));
			amendmentsTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_REQUESTDATE)));

			for(RiderDetails eachAmendment : riderLst){
				amendmentsTable.addCell(ALOCPDFStyle.createTableDataCell((eachAmendment.getRiderRequestId()!=null) ? eachAmendment.getRiderRequestId().toString() : null));
				amendmentsTable.addCell(ALOCPDFStyle.createTableDataCell(eachAmendment.getLastName()+ALOCConstants.COMMA+eachAmendment.getFirstName()));
				amendmentsTable.addCell(ALOCPDFStyle.createTableDataCell((eachAmendment.getBondAmt()!=null) ? ALOCPDFReportHelper.formatCurrency(eachAmendment.getBondAmt()) : null));
				amendmentsTable.addCell(ALOCPDFStyle.createTableDataCell((eachAmendment.getExpiryDate()!=null) ? ALOCPDFReportHelper.formatDate(eachAmendment.getExpiryDate()) : null));
				amendmentsTable.addCell(ALOCPDFStyle.createTableDataCell((eachAmendment.getRequestDate()!=null) ? ALOCPDFReportHelper.formatDate(eachAmendment.getRequestDate()) : null));
			}
			section.add(amendmentsTable);
		}

		return this;
	}

	/**
	 * This method is used to append DLOC Bid Memo Request Summary section
	 * @return
	 */
	public RequestBuilder appendDLocBidMemoRequestSummary() throws DocumentException {

		String bidmemoTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_BIDMEMO_TITLE);
		ALOCPDFStyle.createSection(bidmemoTitle, reportContext.getCurrentChapter());

		String requestSummaryTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_REQ_SUMMARY);
		Section section = ALOCPDFStyle.createSection(requestSummaryTitle, reportContext.getCurrentChapter());
		PdfPTable requestSumamruyTable = ALOCPDFStyle.createSectionDataTable();

		TransactionDetails transactionDet = (requestDetails!=null) ? requestDetails.getTransactionDetails() : null;
		BundleDetails bundleDet = (requestDetails!=null) ? requestDetails.getBundleDetails() : null;
		BigInteger bundleId = (bundleDet!=null) ? bundleDet.getBundleId() : null;

		String docLCCurTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_ITD_DLOC_CURRENCY);
		String docLCCurValue = (transactionDet != null) ? transactionDet.getDocLCCur() : null;
		requestSumamruyTable.addCell(ALOCPDFStyle.createSectionDataCell(docLCCurTitle, docLCCurValue));
		String docLCAmtTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_ITD_DLOC_AMOUNT);
		String docLCAmtValue = (transactionDet != null) ? ALOCPDFReportHelper.formatCurrency(transactionDet.getDocLCAmt()) : null;
		requestSumamruyTable.addCell(ALOCPDFStyle.createSectionDataCell(docLCAmtTitle, docLCAmtValue));
		String bundleIdTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_BUNDLEID);
		String bundleIdValue = (bundleId != null) ? bundleId.toString() : null;
		requestSumamruyTable.addCell(ALOCPDFStyle.createSectionDataCell(bundleIdTitle, bundleIdValue));
		section.add(requestSumamruyTable);
		return this;
	}

	/**
	 * This method is used to append DLOC Bid Memo Details Section
	 * @return
	 */
	public RequestBuilder appendDlocBidMemoDetails() throws DocumentException {

		String requestSummaryTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_DLOC_BIDMEMO_DETAILS);
		Section section = ALOCPDFStyle.createSection(requestSummaryTitle, reportContext.getCurrentChapter());
		PdfPTable dlocBidMemoDetailsTable = ALOCPDFStyle.createSectionDataTable();

		BidmemoDetails bidMemoDetails = (requestDetails!=null) ? requestDetails.getBidmemoDetails() : null;

		String dateBidMemoCreatedTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_BIDCREATED_DATE);
		String dateBidMemoCreatedValue = (bidMemoDetails != null) ? ALOCPDFReportHelper.formatDate(bidMemoDetails.getDateBidMemoCreated()) : null;
		dlocBidMemoDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(dateBidMemoCreatedTitle, dateBidMemoCreatedValue));
		String expirationDateTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_EXPIRATION_DATE);
		String expirationDateValue = (bidMemoDetails != null) ? ALOCPDFReportHelper.formatDate(bidMemoDetails.getExpirationDateTime()) : null;
		dlocBidMemoDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(expirationDateTitle, expirationDateValue));
		String pricingExpirationTimeTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_EXPIRATIONTIME);
		String pricingExpirationTimeValue= (bidMemoDetails!=null) ? ALOCPDFReportHelper.formatTime(bidMemoDetails.getExpirationTime()) :null;
		dlocBidMemoDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(pricingExpirationTimeTitle, pricingExpirationTimeValue));

		section.add(dlocBidMemoDetailsTable);
		return this;
	}

	/**
	 * This method is used to append DLOC Bid Reply Request Summary section
	 * @return
	 */
	public RequestBuilder appendDLocBidReplyRequestSummary() throws DocumentException {
		String bidReplyTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_BIDREPLY_TITLE);
		ALOCPDFStyle.createSection(bidReplyTitle, reportContext.getCurrentChapter());

		String requestSummaryTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_REQ_SUMMARY);
		Section section = ALOCPDFStyle.createSection(requestSummaryTitle, reportContext.getCurrentChapter());
		PdfPTable requestSumamruyTable = ALOCPDFStyle.createSectionDataTable();

		StaticDataFactory staticDataFactory = reportContext.getStaticDataFactory();
		List<AddressDtls> addressDtlsLst = (staticDataFactory != null) ? staticDataFactory.getAddressDetails() : null;
		AddressDtls addressDtls = (addressDtlsLst != null && addressDtlsLst.size() > ALOCConstants.BASE_VALUE) ?
				addressDtlsLst.get(ALOCConstants.BASE_VALUE) : null;

		if(addressDtls!=null){
			String name = (addressDtls!=null) ? addressDtls.getName() : null;
			String city = (addressDtls != null) ? addressDtls.getCity() : null;
			String statecode = (addressDtls != null) ? addressDtls.getStateProvinceCd() : null;
			String zipcode = (addressDtls != null) ? addressDtls.getZIPPostalCode() : null;
			String addr1 = null;
			String addr2 = null;

			if(addressDtls.getAddress() != null){
				addr1 = addressDtls.getAddress().get(ALOCConstants.BASE_VALUE);
			}
			if(addressDtls.getAddress() != null && addressDtls.getAddress().size() > ALOCConstants.BASE_VALUE){
				addr2 =  addressDtls.getAddress().get(ALOCConstants.MIN_VALUE);
			}
			String geCorporatetreasuryTitle = (name!=null) ? name+ALOCConstants.COLON : null;
			String[] addressValue = {addr1,addr2,city+ALOCConstants.COMMA_SPACE+statecode+ALOCConstants.EMPTY_SPACE_STRING+zipcode};
			requestSumamruyTable.addCell(ALOCPDFStyle.createSectionDataCell(geCorporatetreasuryTitle, addressValue));
		}
		section.add(requestSumamruyTable);
		return this;
	}
}
