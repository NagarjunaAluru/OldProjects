/*
 * Copyright © 2013 GE. ALL RIGHTS RESERVED.
 * FileName: AmendmentBuilder.java
 * Purpose: This class renders DLOCRequest Page of the PDF report.
 */
package com.ge.aloc.reports.pdf.request;

import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_ADDRESS1;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_AMOUNT_INCREASE_DECREASE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_AMOUNT_OF_DECREASE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_AMOUNT_OF_INCREASE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_APPLICANT;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_APPLICANT_GEAPPLICANTREFERENCE1;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_APPLICANT_GEAPPLICANTREFERENCE2;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_APPLICANT_GEAPPLICANTREFERENCE3;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_BUSINESS_CONTACT_PERSON;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_CITY;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_COMPANYNAME;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_COUNTRY;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_CUSTOMER_BENEFICIARY;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_CUSTOMER_BENEFICIARY_REFERENCE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_CUSTOMER_BENEFICIARY_REFERENCE2;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_CUSTOMER_BENEFICIARY_REFERENCE3;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_DELIVERY_DESIGNATION_SWIFT;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_DELIVERY_INSTRUCTIONS;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_DELIVER_TYPE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_EXPDATE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_EXPIRATION_DATES;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_FALSE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_GEAPPLICANT_REFERENCE_INFO;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_GERECIPIENT;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_GERECIPIENT_EMAIL;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_INPERSON_PICKUP;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_INSTRUMENT_AMOUNT;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_INSTRUMENT_AMOUNT_CURRENCY;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_LEGAL_ENTITY_DETAILS;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_LEGAL_ENTITY_GOLDID;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_LEGAL_ENTITY_NAME;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_NAME_AND_ADDRESS;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_NEW_INSTRUMENT_CURRENCY;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_OTHER_CHANGES;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_PHONE_ADDRESS2_OPTIONAL;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_PHONE_NUMBER;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_PHYSICAL_DELIVERY;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_PREVIOUR_EXPIRATION_DATE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_PREVIOUR_US_EXPIRATION_DATE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_RECIPIENT_FIRSTNAME;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_RECIPIENT_LASTNAME;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_REVISED_AMOUNT_AMD;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_REVISED_USD_AMOUNT;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_SEND_ELECTRONIC_COPYTOMYSELF;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_SEND_ELECTRONIC_COPYTO_GERECIPIENT;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_SPECIAL_INSTRUCTIONS;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_STATE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_TITLE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_TRANSACTION_PARTIES;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_TRI_PARTY_APPLICANT;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_TRUE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_USEXPIRATION_DATE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_USE_PREVIOUS_ADDRESS;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_ZIPCODE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_CUSTOMER_BENEFICIARY_REFERENCE_INFO;

import java.math.BigInteger;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.model.AddressDtls;
import com.ge.aloc.model.Amendment;
import com.ge.aloc.model.AmendmentInstrumentAmountCurr;
import com.ge.aloc.model.Customer;
import com.ge.aloc.model.DeliveryInstructions;
import com.ge.aloc.model.ExpiryDate;
import com.ge.aloc.model.RefDetails;
import com.ge.aloc.model.RequestDetails;
import com.ge.aloc.model.TpApplicantDetails;
import com.ge.aloc.model.TransactionParties;
import com.ge.aloc.reports.pdf.ALOCPDFReportHelper;
import com.ge.aloc.reports.pdf.ALOCPDFStyle;
import com.ge.aloc.reports.pdf.ReportContext;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPTable;

/**
 * This class provides logic to render Amendment page of the report.
 * 
 * @author kranthi.anumula
 */
public class AmendmentBuilder {

	private final ReportContext reportContext;
	private final RequestDetails requestDetails;

	/**
	 * Constructor to instantiate the object.
	 * 
	 * @param context
	 */
	public AmendmentBuilder(ReportContext context) {
		this.reportContext = context;
		this.requestDetails = context.getRequestDetails();
	}


	/**
	 * This is append Amendment Transaction Parties section 
	 * @return
	 */
	public AmendmentBuilder appendAmendmentTransactionParties() throws DocumentException {
		String transactionPartiesTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_TRANSACTION_PARTIES);
		Section section = ALOCPDFStyle.createSection(transactionPartiesTitle, reportContext.getCurrentChapter());
		PdfPTable transactionPartiesTable = ALOCPDFStyle.createSectionDataTable();
		section.add(transactionPartiesTable);
		return this;
	}

	/**
	 * This is append Amendment Applicant Details section 
	 * @return
	 */
	public AmendmentBuilder appendAmendmentApplicantDetails() throws DocumentException {
		Amendment amendment = requestDetails.getAmendment();
		TransactionParties transParties =  (amendment!=null) ? amendment.getTransactionParties() : null;
		TpApplicantDetails transpartiesAppDet = (transParties!=null) ? transParties.getTpApplicantDetails() : null;
		AddressDtls addrDet =  (transpartiesAppDet!=null) ? transpartiesAppDet.getAddressDtls() : null;
		
		String applicantDetailsTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_APPLICANT);
		Section section = ALOCPDFStyle.createSection(applicantDetailsTitle, reportContext.getCurrentChapter());
		PdfPTable tpApplicantDetailsTable = ALOCPDFStyle.createSectionDataTable();
		
		String nameAddressTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_NAME_AND_ADDRESS);
		String [] addressValues = ALOCPDFReportHelper.convertAddressAsString(addrDet);
		tpApplicantDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(nameAddressTitle, addressValues));
		
		section.add(tpApplicantDetailsTable);
		
		String leDetailsTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_LEGAL_ENTITY_DETAILS);
		Section leDetailssection = ALOCPDFStyle.createSection(leDetailsTitle, reportContext.getCurrentChapter());
		PdfPTable leDetailsTable = ALOCPDFStyle.createSectionDataTable();
		
		String legalEntityName = ALOCPDFReportHelper.getResourceValue(RES_KEY_LEGAL_ENTITY_NAME);
		String leNameCurrentValue = (transpartiesAppDet != null) ? transpartiesAppDet.getLeName() : null;
		leDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(legalEntityName, leNameCurrentValue));
		String legalEntityGoldId = ALOCPDFReportHelper.getResourceValue(RES_KEY_LEGAL_ENTITY_GOLDID);
		String legalEntityGoldIdCurrentValue = (transpartiesAppDet != null) ? transpartiesAppDet.getLeGoldId() : null;
		leDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(legalEntityGoldId, legalEntityGoldIdCurrentValue));
		String businessContactPersonTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_BUSINESS_CONTACT_PERSON);
		if (transpartiesAppDet != null && transpartiesAppDet.getTpBuContactPerson() != null) {
			String ssoId = (transpartiesAppDet.getTpBuContactPerson().getSsoId()!=null) ?
					transpartiesAppDet.getTpBuContactPerson().getSsoId().toString() : null;
			String [] businessContactPerson = {transpartiesAppDet.getTpBuContactPerson().getFirstName(),
					transpartiesAppDet.getTpBuContactPerson().getLastName(),
					ssoId};
			leDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(businessContactPersonTitle,businessContactPerson));
		}
		List<RefDetails> refDetLst = (transpartiesAppDet!=null) ? transpartiesAppDet.getRefDetails() : null;
		
		leDetailssection.add(leDetailsTable);
		
		String applicantRefTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_GEAPPLICANT_REFERENCE_INFO);
		Section geApplsection = ALOCPDFStyle.createSection(applicantRefTitle, reportContext.getCurrentChapter());
		PdfPTable geAppliDetailsTable = ALOCPDFStyle.createSectionDataTable();
		String refTitle1 = ALOCPDFReportHelper.getResourceValue(RES_KEY_APPLICANT_GEAPPLICANTREFERENCE1);
		if(refDetLst != null && refDetLst.size() > ALOCConstants.BASE_VALUE && refDetLst.get(ALOCConstants.BASE_VALUE) != null){
			String refCurrentValue1 = (refDetLst != null) ? refDetLst.get(ALOCConstants.BASE_VALUE).getRefValue() : null;
			geAppliDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(refTitle1, refCurrentValue1));
		}
		String refTitle2 = ALOCPDFReportHelper.getResourceValue(RES_KEY_APPLICANT_GEAPPLICANTREFERENCE2);
		if(refDetLst != null && refDetLst.size() > ALOCConstants.MIN_VALUE && refDetLst.get(ALOCConstants.MIN_VALUE) != null){
			String refCurrentValue2 = (refDetLst != null) ? refDetLst.get(ALOCConstants.MIN_VALUE).getRefValue() : null;
			geAppliDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(refTitle2, refCurrentValue2));
		}
		String refTitle3 = ALOCPDFReportHelper.getResourceValue(RES_KEY_APPLICANT_GEAPPLICANTREFERENCE3);
		if(refDetLst != null && refDetLst.size() > ALOCConstants.SECOND_VALUE && refDetLst.get(ALOCConstants.SECOND_VALUE) != null){
			String refCurrentValue3 = (refDetLst != null) ? refDetLst.get(ALOCConstants.SECOND_VALUE).getRefValue() : null;
			geAppliDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(refTitle3, refCurrentValue3));
		}
		geApplsection.add(geAppliDetailsTable);
		return this;
	}

	/**
	 * This is append Amendment TriParty applicant section 
	 * @return
	 */
	public AmendmentBuilder appendAmendmentTriPartyApplicant() throws DocumentException {
		Amendment amendment = requestDetails.getAmendment();
		TransactionParties transPartyDetails = (amendment != null) ? amendment.getTransactionParties() : null;
		AddressDtls amendmentTPApplicant = (transPartyDetails != null) ? transPartyDetails.getTriPartyApplicant() : null;
		
		if(requestDetails.getSiteTypeId().equals(new BigInteger(ALOCConstants.SITE_TYPE_ID))){
			if(requestDetails.getAmendment().getTransactionParties().isTriPartyRequestFlag() != null && requestDetails.getAmendment().getTransactionParties().isTriPartyRequestFlag()){
				String triPartyApplicantTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_TRI_PARTY_APPLICANT);
				Section section = ALOCPDFStyle.createSection(triPartyApplicantTitle, reportContext.getCurrentChapter());
				PdfPTable triPartyApplicantTable = ALOCPDFStyle.createSectionDataTable();
				
				String nameAddressTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_NAME_AND_ADDRESS);
				
				String [] addressValues = ALOCPDFReportHelper.convertAddressAsString(amendmentTPApplicant);
				triPartyApplicantTable.addCell(ALOCPDFStyle.createSectionDataCell(nameAddressTitle, addressValues));
			
				section.add(triPartyApplicantTable);
			}
		}
		return this;
	}

	/**
	 * This is append Amendment Customer Details section of request
	 * @return
	 */
	public AmendmentBuilder appendAmendmentCustomerDetails() throws DocumentException {
		Amendment amendment = requestDetails.getAmendment();
		TransactionParties trasnParties = (amendment != null) ? amendment.getTransactionParties() : null;
		Customer customer = (trasnParties != null) ? trasnParties.getCustomer() : null;
		AddressDtls addrDet =  (customer != null) ? customer.getAddressDtls() : null;
		List<RefDetails> refDetLst = (customer!=null) ? customer.getRefDetails() : null;
		
		String customerDetailsTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_CUSTOMER_BENEFICIARY);
		Section section = ALOCPDFStyle.createSection(customerDetailsTitle, reportContext.getCurrentChapter());
		PdfPTable customerDetailsTable = ALOCPDFStyle.createSectionDataTable();

		String nameAddressTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_NAME_AND_ADDRESS);
		String [] addressValues = ALOCPDFReportHelper.convertAddressAsString(addrDet);
		customerDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(nameAddressTitle, addressValues));
		
		section.add(customerDetailsTable);
		
		String customerBenfiTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_CUSTOMER_BENEFICIARY_REFERENCE_INFO);
		Section CustomerSection = ALOCPDFStyle.createSection(customerBenfiTitle, reportContext.getCurrentChapter());
		PdfPTable customerBenfTable = ALOCPDFStyle.createSectionDataTable();

		String refTitle1 = ALOCPDFReportHelper.getResourceValue(RES_KEY_CUSTOMER_BENEFICIARY_REFERENCE);
		if(refDetLst!= null && refDetLst.size() > ALOCConstants.BASE_VALUE && refDetLst.get(ALOCConstants.BASE_VALUE) != null){
			String refCurrentValue1 = (refDetLst != null) ? refDetLst.get(ALOCConstants.BASE_VALUE).getRefValue() : null;
			customerBenfTable.addCell(ALOCPDFStyle.createSectionDataCell(refTitle1, refCurrentValue1));
		}
		String refTitle2 = ALOCPDFReportHelper.getResourceValue(RES_KEY_CUSTOMER_BENEFICIARY_REFERENCE2);
		if(refDetLst!= null && refDetLst.size() > 1 && refDetLst.get(ALOCConstants.MIN_VALUE) != null){
			String refValue2 = (refDetLst != null) ? refDetLst.get(ALOCConstants.MIN_VALUE).getRefValue() : null;
			customerBenfTable.addCell(ALOCPDFStyle.createSectionDataCell(refTitle2, refValue2));
		}
		String refTitle3 = ALOCPDFReportHelper.getResourceValue(RES_KEY_CUSTOMER_BENEFICIARY_REFERENCE3);
		if(refDetLst!= null && refDetLst.size() > ALOCConstants.SECOND_VALUE && refDetLst.get(ALOCConstants.SECOND_VALUE) != null){
			String refValue3 = (refDetLst != null) ? refDetLst.get(ALOCConstants.SECOND_VALUE).getRefValue() : null;
			customerBenfTable.addCell(ALOCPDFStyle.createSectionDataCell(refTitle3, refValue3));
		}
		CustomerSection.add(customerBenfTable);
		return this;
	}

	/**
	 * This is append Amendment Other changes section of request
	 * @return
	 */
	public AmendmentBuilder appendAmendmentOtherChanges() throws DocumentException {
		Amendment otherChanges = requestDetails.getAmendment(); 
		String otherChangesTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_OTHER_CHANGES);
		Section section = ALOCPDFStyle.createSection(otherChangesTitle, reportContext.getCurrentChapter());
		PdfPTable otherChangesTable = ALOCPDFStyle.createSectionDataTable();

		String otherChangesValue = (otherChanges != null) ? otherChanges.getOtherChanges(): null;
		otherChangesTable.addCell(ALOCPDFStyle.createSectionDataCell(otherChangesTitle, otherChangesValue));

		section.add(otherChangesTable);
		return this;
	}

	/**
	 * This is append Amendment Expiration Dates section of request
	 * @return
	 */
	public AmendmentBuilder appendAmendmentExpirationDates() throws DocumentException {
		Amendment amendmentDatails = requestDetails.getAmendment();
		Amendment previousAmendmentDet = requestDetails.getPreviousAmendment(); 
		String expirationDatesTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_EXPIRATION_DATES);
		Section section = ALOCPDFStyle.createSection(expirationDatesTitle, reportContext.getCurrentChapter());
		
		PdfPTable expirationDatesTable = ALOCPDFStyle.createMultiSectionDataTable();	
		
		ExpiryDate expiryDates = (amendmentDatails!=null) ? amendmentDatails.getExpiryDate() : null;
		String originalExpirationDateTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_EXPDATE);
		String originalExpirationDateValue = (expiryDates != null) ? ALOCPDFReportHelper.formatDate(expiryDates.getRevisedExpiryDate()): null;
		expirationDatesTable.addCell(ALOCPDFStyle.createSectionDataCell(originalExpirationDateTitle, originalExpirationDateValue));
		
		ExpiryDate preExpiryDates = (previousAmendmentDet!=null) ? previousAmendmentDet.getExpiryDate() : null;
		String currentExpirationDate = ALOCPDFReportHelper.getResourceValue(RES_KEY_PREVIOUR_EXPIRATION_DATE);
		String currentExpirationDateValue = (preExpiryDates != null) ? ALOCPDFReportHelper.formatDate(preExpiryDates.getOriginalExpiryDate()): null;
		expirationDatesTable.addCell(ALOCPDFStyle.createSectionDataCell(currentExpirationDate, currentExpirationDateValue));
		
		String revisedExpirationDate = ALOCPDFReportHelper.getResourceValue(RES_KEY_USEXPIRATION_DATE);
		String revisedExpirationDateValue = (expiryDates != null) ? ALOCPDFReportHelper.formatDate(expiryDates.getUSRevisedExpiryDate()): null;
		expirationDatesTable.addCell(ALOCPDFStyle.createSectionDataCell(revisedExpirationDate, revisedExpirationDateValue));
		
		String originalUSExpirationDate = ALOCPDFReportHelper.getResourceValue(RES_KEY_PREVIOUR_US_EXPIRATION_DATE);
		String originalUSExpirationDateValue = (preExpiryDates != null) ? ALOCPDFReportHelper.formatDate(preExpiryDates.getUSOriginalExpiryDate()): null;
		expirationDatesTable.addCell(ALOCPDFStyle.createSectionDataCell(originalUSExpirationDate, originalUSExpirationDateValue));
	
		section.add(expirationDatesTable);
		return this;
	}

	/**
	 * This is append Amendment Instrument Amount Currency section of request
	 * @return
	 */
	public AmendmentBuilder appendAmendmentInstrumentAmountCurrency() throws DocumentException {
		Amendment amendmentDetails = requestDetails.getAmendment(); 
		String instrumentAmountCurrencyTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_INSTRUMENT_AMOUNT_CURRENCY);
		Section section = ALOCPDFStyle.createSection(instrumentAmountCurrencyTitle, reportContext.getCurrentChapter());
		PdfPTable instrumentAmountCurrencyTable = ALOCPDFStyle.createSectionDataTable();
		
		AmendmentInstrumentAmountCurr instrAmt = amendmentDetails.getAmendmentInstrumentAmountCurr();
		
		String originalInstrumentAmount = ALOCPDFReportHelper.getResourceValue(RES_KEY_INSTRUMENT_AMOUNT);
		String originalInstrumentAmountValue = (instrAmt != null) ? ALOCPDFReportHelper.formatCurrency(instrAmt.getOriginalInstrumentAmt()) : null;
		instrumentAmountCurrencyTable.addCell(ALOCPDFStyle.createSectionDataCell(originalInstrumentAmount, originalInstrumentAmountValue));
		String instrumentOperationTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_AMOUNT_INCREASE_DECREASE);
		String instrumentOperationValue = (instrAmt != null) ? instrAmt.getOperation() : null;
		instrumentAmountCurrencyTable.addCell(ALOCPDFStyle.createSectionDataCell(instrumentOperationTitle, instrumentOperationValue));
		String currentAmountIncreaseDecrease = null;
		if(instrumentOperationValue != null && instrumentOperationValue.equalsIgnoreCase(ALOCConstants.INCREASE)){
			currentAmountIncreaseDecrease = ALOCPDFReportHelper.getResourceValue(RES_KEY_AMOUNT_OF_INCREASE);
		}else{
			currentAmountIncreaseDecrease = ALOCPDFReportHelper.getResourceValue(RES_KEY_AMOUNT_OF_DECREASE);
		}
		String currentAmountIncreaseDecreaseValue = (instrAmt != null) ? ALOCPDFReportHelper.formatCurrency(instrAmt.getAmtOfIncreaseOrDecrease()) : null;
		instrumentAmountCurrencyTable.addCell(ALOCPDFStyle.createSectionDataCell(currentAmountIncreaseDecrease, currentAmountIncreaseDecreaseValue));
		String revisedAmount = ALOCPDFReportHelper.getResourceValue(RES_KEY_REVISED_AMOUNT_AMD);
		String revisedAmountValue = (instrAmt != null) ? ALOCPDFReportHelper.formatCurrency(instrAmt.getRevisedInstrumentAmt()) : null;
		instrumentAmountCurrencyTable.addCell(ALOCPDFStyle.createSectionDataCell(revisedAmount, revisedAmountValue));
		String originalInstrumentCurrency = ALOCPDFReportHelper.getResourceValue(RES_KEY_REVISED_USD_AMOUNT);
		String originalInstrumentCurrencyValue =  (instrAmt != null) ? ALOCPDFReportHelper.formatCurrency(instrAmt.getRevisedUSDEquiAmt()) : null;
		instrumentAmountCurrencyTable.addCell(ALOCPDFStyle.createSectionDataCell(originalInstrumentCurrency, originalInstrumentCurrencyValue));
		String newInstrumentCurrency = ALOCPDFReportHelper.getResourceValue(RES_KEY_NEW_INSTRUMENT_CURRENCY);
		String newInstrumentCurrencyValue = (instrAmt != null) ? instrAmt.getNewInstrumentCurrCode() : null;
		instrumentAmountCurrencyTable.addCell(ALOCPDFStyle.createSectionDataCell(newInstrumentCurrency, newInstrumentCurrencyValue));

		section.add(instrumentAmountCurrencyTable);
		return this;
	}
	
	/**
	 * This method is used to append Delivery Instructions details section of Amendment request
	 * @return
	 */
	public AmendmentBuilder appendAmendmentDeliveryInstructions() throws DocumentException{
		Amendment amendment = requestDetails.getAmendment();
		DeliveryInstructions deliveryInstructions = (amendment != null) ? amendment.getDeliveryInstructions() : null;
		String deliveryInstructionsTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_DELIVERY_INSTRUCTIONS);
		Section section = ALOCPDFStyle.createSection(deliveryInstructionsTitle, reportContext.getCurrentChapter());
		PdfPTable deliveryInstructionsTable = ALOCPDFStyle.createSectionDataTable();

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
		deliveryInstructionsTable = fillCompanyDetails(deliveryInstructionsTable, deliveryInstructions);
		
		if (deliverType != null && deliverType.equals(ALOCPDFReportHelper.getResourceValue(RES_KEY_FALSE))) {
			deliveryInstructionsTable = fillAddressDetails(deliveryInstructionsTable, deliveryInstructions);
		}
		String phoneTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_PHONE_NUMBER);
		String phoneNumValue = (deliveryInstructions != null) ? deliveryInstructions.getPhoneNo(): null;
		deliveryInstructionsTable.addCell(ALOCPDFStyle.createSectionDataCell(phoneTitle, phoneNumValue));
		String specialInstTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_SPECIAL_INSTRUCTIONS);
		String specialInstValue = (deliveryInstructions != null) ? deliveryInstructions.getSpecialInstructions(): null;
		deliveryInstructionsTable.addCell(ALOCPDFStyle.createSectionDataCell(specialInstTitle, specialInstValue));
		String desigSwiftTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_DELIVERY_DESIGNATION_SWIFT);
		String desigSwiftValue = (deliveryInstructions != null) ? deliveryInstructions.getDeliveryDesignationFlag(): null;
		deliveryInstructionsTable.addCell(ALOCPDFStyle.createSectionDataCell(desigSwiftTitle, desigSwiftValue));
		String sendElecTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_SEND_ELECTRONIC_COPYTOMYSELF);
		String sendEcopyMyselfValue = (deliveryInstructions != null) ? ALOCPDFReportHelper.convertStringAsYesOrNo(deliveryInstructions.getEcopyMyself()) : null;
		deliveryInstructionsTable.addCell(ALOCPDFStyle.createSectionDataCell(sendElecTitle, sendEcopyMyselfValue));
		String sendelecGerecipTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_SEND_ELECTRONIC_COPYTO_GERECIPIENT);
		String sendelecGerecipValue = (deliveryInstructions != null) ? ALOCPDFReportHelper.convertStringAsYesOrNo(deliveryInstructions.getEcopyOtherGEPerson()) : null;
		deliveryInstructionsTable.addCell(ALOCPDFStyle.createSectionDataCell(sendelecGerecipTitle, sendelecGerecipValue));

		String otherGEPerson = (deliveryInstructions!= null) ? deliveryInstructions.getEcopyOtherGEPerson() : null;
		if(otherGEPerson != null&&otherGEPerson.equals(ALOCPDFReportHelper.getResourceValue(RES_KEY_TRUE))
				&& deliveryInstructions.getRecipient()!=null){
			deliveryInstructionsTable = fillRecipientDetails(deliveryInstructionsTable, deliveryInstructions);
		}
		section.add(deliveryInstructionsTable);
		return this;
	}

	/**
	 * fillRecipientDetails
	 * @param deliveryInstructionsTable
	 * @param deliveryInstructions
	 * @return deliveryInstructionsTable
	 */
	private PdfPTable fillRecipientDetails(PdfPTable deliveryInstructionsTable, DeliveryInstructions deliveryInstructions) {

		String geRecipientTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_GERECIPIENT);
		String geRecipientEmailTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_GERECIPIENT_EMAIL);
		
		StringBuilder fullName = new StringBuilder();
		if(StringUtils.isNotBlank(deliveryInstructions.getRecipient().getRecipientLastName())) {
			fullName.append(deliveryInstructions.getRecipient().getRecipientLastName());
		}
		if(StringUtils.isNotBlank(deliveryInstructions.getRecipient().getRecipientFirstName())) {
			if(fullName.length() > ALOCConstants.BASE_VALUE) {
				fullName.append(ALOCConstants.COMMA_SPACE);
			}
			fullName.append(deliveryInstructions.getRecipient().getRecipientFirstName());
		}
		if(StringUtils.isNotBlank(deliveryInstructions.getRecipient().getRecipientSsoId())) {
			fullName.append(ALOCConstants.EMPTYSPACE_HYPEN_EMPTYSPACE + deliveryInstructions.getRecipient().getRecipientSsoId());
		}
		deliveryInstructionsTable.addCell(ALOCPDFStyle.createSectionDataCell(geRecipientTitle, fullName.toString()));
		deliveryInstructionsTable.addCell(ALOCPDFStyle.createSectionDataCell(geRecipientEmailTitle, deliveryInstructions.getRecipient().getRecipientEmail()));
		return deliveryInstructionsTable;
	}

	/**
	 * fillAddressDetails
	 * @param deliveryInstructionsTable
	 * @param deliveryInstructions
	 * @return deliveryInstructionsTable
	 */
	private PdfPTable fillAddressDetails(PdfPTable deliveryInstructionsTable, DeliveryInstructions deliveryInstructions) {
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
		return deliveryInstructionsTable;
	}

	/**
	 * fillCompanyDetails
	 * @param deliveryInstructionsTable
	 * @param deliveryInstructions
	 * @return deliveryInstructionsTable
	 */
	private PdfPTable fillCompanyDetails(PdfPTable deliveryInstructionsTable, DeliveryInstructions deliveryInstructions) {
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
		return deliveryInstructionsTable;
	}

}
