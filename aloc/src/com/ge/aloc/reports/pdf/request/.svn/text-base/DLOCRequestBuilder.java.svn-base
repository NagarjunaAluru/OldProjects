/*
 * Copyright © 2013 GE. ALL RIGHTS RESERVED.
 * FileName: DLOCRequestBuilder.java
 * Purpose: This class renders DLOCRequest Page of the PDF report.
 */
package com.ge.aloc.reports.pdf.request;

import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_APPLICANT;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_APPLICANT_GEAPPLICANTREFERENCE1;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_APPLICANT_GEAPPLICANTREFERENCE2;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_APPLICANT_GEAPPLICANTREFERENCE3;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_APPLICANT_NAMEADDRESS;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_BENEFICIARY;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_BENEFICIARY_BENEFICIARY_REFERENCE1;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_BENEFICIARY_BENEFICIARY_REFERENCE2;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_BENEFICIARY_BENEFICIARY_REFERENCE3;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_INSTRUMENT_TRANSACTION_DETAILS;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_ISSUINGBANK;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_ISSUINGBANK_BANKIDENTIFIERCODE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_ISSUINGBANK_ISSUINGBANK;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_ITD_BANKCHARGES;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_ITD_CONFIRMTYPE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_ITD_CONTRACTAMOUNT;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_ITD_CONTRACTCURRENCY;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_ITD_COUNTRYOFISSUANCE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_ITD_DLOC_AMOUNT;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_ITD_DLOC_CURRENCY;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_ITD_LCPAYMENTTERMS;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_ITD_ORIGIN_OF_GOODS1;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_ITD_ORIGIN_OF_GOODS2;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_ITD_ORIGIN_OF_GOODS3;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_ITD_OTHERPAYMENTDESC;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_ITD_PERCENTUSCONTENT;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_ITD_PROJECTDECSCRIPTION;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_ITD_SHIPMENT_DESTINATION_COUNTRY;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_ITD_SHIPMENT_ORIGIN_COUNTRY1;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_ITD_SHIPMENT_ORIGIN_COUNTRY2;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_ITD_SHIPMENT_ORIGIN_COUNTRY3;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_ITD_USD_DLOC_AMOUNT;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_LEGAL_ENTITY_GOLDID;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_LEGAL_ENTITY_NAME;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_LETTER_OF_CREDIT_NO;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_NAME_AND_ADDRESS;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_PAYMENT_APPROXIMATE_ISSUEDATE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_PAYMENT_ESTIMATED_MONTHS_LCISVALID;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_PAYMENT_ESTIMATED_PAYMENTAMOUNT;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_PAYMENT_ESTIMATED_PAYMENTDATE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_PAYMENT_SCHEDULE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_PAYMENT_SPECIAL_INSTRUCTIONS;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_PAYMENT__ESTIMATED_MONTHS_FROM_ISSUE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_PREFFERED_DOC;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_SELECTED_SITE;

import java.util.List;

import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.model.AdditionalPayments;
import com.ge.aloc.model.AddressDtls;
import com.ge.aloc.model.ApplicantDetails;
import com.ge.aloc.model.BeneficiaryDetails;
import com.ge.aloc.model.BuContactPerson;
import com.ge.aloc.model.BuRequestor;
import com.ge.aloc.model.IssuingBankDetails;
import com.ge.aloc.model.PaymentScheduleDetails;
import com.ge.aloc.model.RequestDetails;
import com.ge.aloc.model.TransactionDetails;
import com.ge.aloc.reports.pdf.ALOCPDFReportHelper;
import com.ge.aloc.reports.pdf.ALOCPDFStyle;
import com.ge.aloc.reports.pdf.ReportContext;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPTable;

/**
 * This class provides logic to render DLOC page of the report.
 * 
 * @author kranthi.anumula
 */
public class DLOCRequestBuilder {

	private final ReportContext reportContext;
	private final RequestDetails requestDetails;

	/**
	 * Constructor to instantiate the object.
	 * 
	 * @param context
	 */
	public DLOCRequestBuilder(ReportContext context) {
		this.reportContext = context;
		this.requestDetails = context.getRequestDetails();
	}

	/**
	 * This is append Business Contact Person section of DLOC request
	 * @return
	 */
	public DLOCRequestBuilder appendBusinessContactPerson() throws DocumentException {
		BuContactPerson buContactPerson = requestDetails.getBuContactPerson();
		String buContactPersonTitle = ALOCPDFReportHelper.getResourceValue(RequestPDFConstants.RES_KEY_BUSINESS_CONTACT_PERSON);
		Section section = ALOCPDFStyle.createSection(buContactPersonTitle, reportContext.getCurrentChapter());
		PdfPTable buContactPersonTable = ALOCPDFStyle.createSectionDataTable();
		
		String selectedSiteTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_SELECTED_SITE);
		String selectedSite = (requestDetails.getSiteName()!= null) ? requestDetails.getSiteName() : null;
		buContactPersonTable.addCell(ALOCPDFStyle.createSectionDataCell(selectedSiteTitle, selectedSite));

		String requestorTitle = null;
		List<BuRequestor> requestorValues = (buContactPerson != null) ? buContactPerson.getBuRequestors() : null;
		int i = ALOCConstants.BASE_VALUE;
		for(BuRequestor buRequestor: requestorValues){
			if(i==ALOCConstants.BASE_VALUE){requestorTitle = ALOCPDFReportHelper.getResourceValue(RequestPDFConstants.RES_KEY_CONTACT_NAME1);}
			else if(i==ALOCConstants.MIN_VALUE){requestorTitle = ALOCPDFReportHelper.getResourceValue(RequestPDFConstants.RES_KEY_CONTACT_NAME2);}
			else if(i==ALOCConstants.SECOND_VALUE){requestorTitle = ALOCPDFReportHelper.getResourceValue(RequestPDFConstants.RES_KEY_CONTACT_NAME3);}
			buContactPersonTable.addCell(ALOCPDFStyle.createSectionDataCell(requestorTitle, buRequestor.getName(),buRequestor.getPhoneNumber(),buRequestor.getEmailAddr()));
			i++;
		}	
		section.add(buContactPersonTable);
		return this;
	}

	/**
	 * This is append Issuing Bank section of DLOC request
	 * @return
	 */
	public DLOCRequestBuilder appendIssuingBank() throws DocumentException {
		IssuingBankDetails issuingBankDetails = requestDetails.getIssuingBankDetails();
		String issuingBankDetailsTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_ISSUINGBANK);
		Section section = ALOCPDFStyle.createSection(issuingBankDetailsTitle, reportContext.getCurrentChapter());
		PdfPTable issuingBankDetailsTable = ALOCPDFStyle.createSectionDataTable();		
		String issuingBankTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_ISSUINGBANK_ISSUINGBANK);

		AddressDtls addressDtls=issuingBankDetails.getAddressDtls();
		String address1 = null;
		String address2 = null;
		if (addressDtls.getAddress() != null && !addressDtls.getAddress().isEmpty()) {
			if (addressDtls.getAddress().get(ALOCConstants.BASE_VALUE) != null) {
				address1 = addressDtls.getAddress().get(ALOCConstants.BASE_VALUE);
			}
			if (addressDtls.getAddress().size() > ALOCConstants.MIN_VALUE	&& addressDtls.getAddress().get(ALOCConstants.MIN_VALUE) != null) {
				address2 = addressDtls.getAddress().get(ALOCConstants.MIN_VALUE);
			}
		}
		String[] addressValues = { issuingBankDetails.getBankName(),
				address1, address2, addressDtls.getCity(),
				addressDtls.getStateProvince(),
				addressDtls.getZIPPostalCode(), addressDtls.getCountry() };
		issuingBankDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(issuingBankTitle, addressValues));			

		String bicTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_ISSUINGBANK_BANKIDENTIFIERCODE);
		String bicValue = (issuingBankDetails != null) ? issuingBankDetails.getBIC() : null;
		issuingBankDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(bicTitle, bicValue));
		
		String letterOfCreditNoTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_LETTER_OF_CREDIT_NO);
		String letterOfCreditNoValue = (issuingBankDetails != null && issuingBankDetails.getCreditLetterNo()!=null) ? issuingBankDetails.getCreditLetterNo().toString() : null;
		issuingBankDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(letterOfCreditNoTitle, letterOfCreditNoValue));
		
		section.add(issuingBankDetailsTable);
		return this;
	}

	/**
	 * This is append Applicant Details section of DLOC request
	 * @return
	 */
	public DLOCRequestBuilder appendApplicantDetails() throws DocumentException {
		ApplicantDetails applicantDetails = requestDetails.getApplicantDetails();
		String applicantDetailsTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_APPLICANT);
		Section section = ALOCPDFStyle.createSection(applicantDetailsTitle, reportContext.getCurrentChapter());
		PdfPTable applicantDetailsTable = ALOCPDFStyle.createSectionDataTable();		
		String nameAddressTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_APPLICANT_NAMEADDRESS);
		AddressDtls addressDtls=applicantDetails.getAddressDtls();
		if (addressDtls != null) {
			String[] addressValues = ALOCPDFReportHelper.convertAddressAsString(addressDtls);
			applicantDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(nameAddressTitle, addressValues));
		}
		String refTitle1 = ALOCPDFReportHelper.getResourceValue(RES_KEY_APPLICANT_GEAPPLICANTREFERENCE1);
		String refValue1 = (applicantDetails != null) ? applicantDetails.getRefDetails().get(ALOCConstants.BASE_VALUE).getRefValue() : null;
		applicantDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(refTitle1, refValue1));
		if(applicantDetails.getRefDetails().size() > ALOCConstants.MIN_VALUE){
			String refTitle2 = ALOCPDFReportHelper.getResourceValue(RES_KEY_APPLICANT_GEAPPLICANTREFERENCE2);
			String refValue2 = (applicantDetails != null) ? applicantDetails.getRefDetails().get(ALOCConstants.MIN_VALUE).getRefValue() : null;
			applicantDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(refTitle2, refValue2));
		}
		if(applicantDetails.getRefDetails().size() > ALOCConstants.SECOND_VALUE){
			String refTitle3 = ALOCPDFReportHelper.getResourceValue(RES_KEY_APPLICANT_GEAPPLICANTREFERENCE3);
			String refValue3 = (applicantDetails != null) ? applicantDetails.getRefDetails().get(ALOCConstants.SECOND_VALUE).getRefValue() : null;
			applicantDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(refTitle3, refValue3));
		}
		section.add(applicantDetailsTable);
		return this;
	}

	/**
	 * This is append Beneficiary Details section of DLOC request
	 * @return
	 */
	public DLOCRequestBuilder appendBeneficiaryDetails() throws DocumentException {
		BeneficiaryDetails beneficiaryDetails = requestDetails.getBeneficiaryDetails();
		String beneficiaryDetailsTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_BENEFICIARY);
		Section section = ALOCPDFStyle.createSection(beneficiaryDetailsTitle, reportContext.getCurrentChapter());
		PdfPTable beneficiaryDetailsTable = ALOCPDFStyle.createSectionDataTable();

		String legalEntityNameTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_LEGAL_ENTITY_NAME);
		String legalEntityNameValue = (beneficiaryDetails != null) ? beneficiaryDetails.getLeName() : null;
		beneficiaryDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(legalEntityNameTitle,legalEntityNameValue));
		String legalGoldIdTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_LEGAL_ENTITY_GOLDID);
		String legalGoldIdValue = (beneficiaryDetails != null) ? beneficiaryDetails.getLeGoldId() : null;
		beneficiaryDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(legalGoldIdTitle, legalGoldIdValue));
		
		String nameandAddressTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_NAME_AND_ADDRESS);
		 AddressDtls addressDtls = beneficiaryDetails.getAddressDtls();		
		 if (addressDtls != null) {
			 String[] addressValues = ALOCPDFReportHelper.convertAddressAsString(addressDtls);
			 beneficiaryDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(nameandAddressTitle, addressValues));
		 }
		 String refTitle1 = ALOCPDFReportHelper.getResourceValue(RES_KEY_BENEFICIARY_BENEFICIARY_REFERENCE1);		
		 String refValue1 = (beneficiaryDetails != null) ? beneficiaryDetails.getRefDetails().get(ALOCConstants.BASE_VALUE).getRefValue() : null;
		 beneficiaryDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(refTitle1, refValue1));
		 if(beneficiaryDetails.getRefDetails().size() > ALOCConstants.MIN_VALUE){
			 String refTitle2 = ALOCPDFReportHelper.getResourceValue(RES_KEY_BENEFICIARY_BENEFICIARY_REFERENCE2);
			 String refValue2 = (beneficiaryDetails != null) ? beneficiaryDetails.getRefDetails().get(ALOCConstants.MIN_VALUE).getRefValue() : null;
			 beneficiaryDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(refTitle2, refValue2));
		 }
		 if(beneficiaryDetails.getRefDetails().size() > ALOCConstants.SECOND_VALUE){
			 String refTitle3 = ALOCPDFReportHelper.getResourceValue(RES_KEY_BENEFICIARY_BENEFICIARY_REFERENCE3);
			 String refValue3 = (beneficiaryDetails != null) ? beneficiaryDetails.getRefDetails().get(ALOCConstants.SECOND_VALUE).getRefValue() : null;
			 beneficiaryDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(refTitle3, refValue3));
		 }
		 section.add(beneficiaryDetailsTable);
		 return this;
	}

	/**
	 * This is append Instrument Transaction Details section of DLOC request
	 * @return
	 */
	public DLOCRequestBuilder appendInstrumentTransactionDetails() throws DocumentException {

		TransactionDetails transactionDetails = requestDetails.getTransactionDetails();
		String transactionDetailsTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_INSTRUMENT_TRANSACTION_DETAILS);
		Section section = ALOCPDFStyle.createSection(transactionDetailsTitle, reportContext.getCurrentChapter());
		PdfPTable transactionDetailsTable = ALOCPDFStyle.createSectionDataTable();

		String projectDescriptionTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_ITD_PROJECTDECSCRIPTION);
		String projectDescriptionValue = (transactionDetails != null) ? transactionDetails.getProjectDesc() : null;
		transactionDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(projectDescriptionTitle,projectDescriptionValue));
		transactionDetailsTable=fillTransactionAmountAndCountries(transactionDetails,transactionDetailsTable);
		
		String preferedCountryTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_PREFFERED_DOC);
		String preferedCountryValue = (transactionDetails != null) ? transactionDetails.getPreferedLocCountryName() : null;
		transactionDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(preferedCountryTitle, preferedCountryValue));

		if(transactionDetails.getUSContentPercent() != null){
			String uSContentTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_ITD_PERCENTUSCONTENT);
			String uSContentValue = (transactionDetails != null) ? transactionDetails.getUSContentPercent() : null;
			transactionDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(uSContentTitle, uSContentValue));
		}
		
		if(transactionDetails.getPreferedLocCountryName() != null){
			String creditLetterNoTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_PREFFERED_DOC);
			String creditLetterNoValue = (transactionDetails.getPreferedLocCountryName() != null) ? transactionDetails.getPreferedLocCountryName() : null;
			transactionDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(creditLetterNoTitle, creditLetterNoValue));
		}

		String lCPaymentTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_ITD_LCPAYMENTTERMS);
		String lCPaymentValue = (transactionDetails != null) ? transactionDetails.getLCPaymentTerm() : null;
		transactionDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(lCPaymentTitle, lCPaymentValue));

		if(transactionDetails != null && transactionDetails.getOthPaymentDesc() != null && transactionDetails.getOthPaymentDesc() !=""){
			String paymentDescTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_ITD_OTHERPAYMENTDESC);
			String paymentDescValue = (transactionDetails != null) ? transactionDetails.getOthPaymentDesc() : null;
			transactionDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(paymentDescTitle, paymentDescValue));
		}

		String confirmTypeTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_ITD_CONFIRMTYPE);
		String confirmTypeValue = (transactionDetails != null) ? transactionDetails.getConfirmationType() : null;
		transactionDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(confirmTypeTitle, confirmTypeValue));

		String bankChargesTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_ITD_BANKCHARGES);
		String bankChargesValue = (transactionDetails != null) ? transactionDetails.getBankChargesType() : null;
		transactionDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(bankChargesTitle, bankChargesValue));

		section.add(transactionDetailsTable);
		return this;
	}
	/**
	 * fillTransactionAmountAndCountries to fill Transaction amount and countries
	 * @param transactionDetails
	 * @param transactionDetailsTable
	 * @return transactionDetailsTable
	 */
	private PdfPTable fillTransactionAmountAndCountries(TransactionDetails transactionDetails,PdfPTable transactionDetailsTable) {
		String countryofIssuanceTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_ITD_COUNTRYOFISSUANCE);
		String countryofIssuanceValue = (transactionDetails != null) ? transactionDetails.getIssuanceCountry() : null;
		transactionDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(countryofIssuanceTitle, countryofIssuanceValue));
		String contractAmountTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_ITD_CONTRACTAMOUNT);
		String contractAmountValue = (transactionDetails != null) ? ALOCPDFReportHelper.formatCurrency(transactionDetails.getContranctAmt()) : null;
		transactionDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(contractAmountTitle, contractAmountValue));

		String contractCurrencyTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_ITD_CONTRACTCURRENCY);
		String contractCurrencyValue = (transactionDetails != null) ? transactionDetails.getContranctCur() : null;
		transactionDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(contractCurrencyTitle, contractCurrencyValue));

		String amountTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_ITD_DLOC_AMOUNT);
		String amountValue = (transactionDetails != null) ? ALOCPDFReportHelper.formatCurrency(transactionDetails.getDocLCAmt()) : null;
		transactionDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(amountTitle, amountValue));

		String dLOCurrencyTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_ITD_DLOC_CURRENCY);
		String dLOCurrencyValue = (transactionDetails != null) ? transactionDetails.getDocLCCur() : null;
		transactionDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(dLOCurrencyTitle, dLOCurrencyValue));

		String dLOCAmountTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_ITD_USD_DLOC_AMOUNT);
		String dLOCAmountValue = (transactionDetails != null) ? ALOCPDFReportHelper.formatCurrency(transactionDetails.getUSDEquivalent()) : null;
		transactionDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(dLOCAmountTitle, dLOCAmountValue));

		String originCountryTitle1 = ALOCPDFReportHelper.getResourceValue(RES_KEY_ITD_SHIPMENT_ORIGIN_COUNTRY1);		
		String originCountryValue1 = (transactionDetails != null) ? transactionDetails.getShipmentOrigins().get(ALOCConstants.BASE_VALUE).getCountyName() : null;
		transactionDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(originCountryTitle1, originCountryValue1));
		if(transactionDetails != null && transactionDetails.getShipmentOrigins() !=null && transactionDetails.getShipmentOrigins().size() > ALOCConstants.MIN_VALUE){
			String originCountryTitle2 = ALOCPDFReportHelper.getResourceValue(RES_KEY_ITD_SHIPMENT_ORIGIN_COUNTRY2);
			String originCountryValue2 = (transactionDetails != null) ? transactionDetails.getShipmentOrigins().get(ALOCConstants.MIN_VALUE).getCountyName() : null;
			transactionDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(originCountryTitle2, originCountryValue2));
		}
		if(transactionDetails != null && transactionDetails.getShipmentOrigins() !=null && transactionDetails.getShipmentOrigins().size() > 2){
			String originCountryTitle3 = ALOCPDFReportHelper.getResourceValue(RES_KEY_ITD_SHIPMENT_ORIGIN_COUNTRY3);
			String originCountryValue3 = (transactionDetails != null) ? transactionDetails.getShipmentOrigins().get(ALOCConstants.SECOND_VALUE).getCountyName() : null;
			transactionDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(originCountryTitle3, originCountryValue3));
		}

		String destinationCountryTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_ITD_SHIPMENT_DESTINATION_COUNTRY);
		String destinationCountryValue = (transactionDetails != null) ? transactionDetails.getShipmentDestCountry() : null;
		transactionDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(destinationCountryTitle, destinationCountryValue));

		String originOfGoodsTitle1 = ALOCPDFReportHelper.getResourceValue(RES_KEY_ITD_ORIGIN_OF_GOODS1);		
		String originOfGoodsValue1 = (transactionDetails != null) ? transactionDetails.getGoodsOrigins().get(ALOCConstants.BASE_VALUE).getCountyName() : null;
		transactionDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(originOfGoodsTitle1, originOfGoodsValue1));
		if(transactionDetails != null && transactionDetails.getGoodsOrigins() != null && transactionDetails.getGoodsOrigins().size() > ALOCConstants.MIN_VALUE){
			String originOfGoodsTitle2 = ALOCPDFReportHelper.getResourceValue(RES_KEY_ITD_ORIGIN_OF_GOODS2);
			String originOfGoodsValue2 = (transactionDetails != null) ? transactionDetails.getGoodsOrigins().get(ALOCConstants.MIN_VALUE).getCountyName() : null;
			transactionDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(originOfGoodsTitle2, originOfGoodsValue2));
		}
		if(transactionDetails != null && transactionDetails.getGoodsOrigins() != null && transactionDetails.getGoodsOrigins().size() > ALOCConstants.SECOND_VALUE){
			String originOfGoodsTitle3 = ALOCPDFReportHelper.getResourceValue(RES_KEY_ITD_ORIGIN_OF_GOODS3);
			String originOfGoodsValue3 = (transactionDetails != null) ? transactionDetails.getGoodsOrigins().get(ALOCConstants.SECOND_VALUE).getCountyName() : null;
			transactionDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(originOfGoodsTitle3, originOfGoodsValue3));
		}
		return transactionDetailsTable;
	}

	/**
	 * This is append Payment Schedule section of DLOC request
	 * @return
	 */
	public DLOCRequestBuilder appendPaymentSchedule() throws DocumentException {

		PaymentScheduleDetails paymentScheduleDetails = requestDetails.getPaymentScheduleDetails();
		String paymentScheduleDetailsTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_PAYMENT_SCHEDULE);

		Section section = ALOCPDFStyle.createSection(paymentScheduleDetailsTitle,reportContext.getCurrentChapter());
		PdfPTable paymentScheduleDetailsTable = ALOCPDFStyle.createSectionDataTable();
		PdfPTable paymentScheduleTable = ALOCPDFStyle.createTable(33f, 33f, 34f);

		String lcisValidTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_PAYMENT_ESTIMATED_MONTHS_LCISVALID);
		String lcisValidTValue = (paymentScheduleDetails != null) ? paymentScheduleDetails.getValidLCMonths(): null;
		paymentScheduleDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(lcisValidTitle, lcisValidTValue));

		String issueDateTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_PAYMENT_APPROXIMATE_ISSUEDATE);
		String issueDateValue = (paymentScheduleDetails != null) ? ALOCPDFReportHelper.formatDate(paymentScheduleDetails.getIssueDt()): null;
		paymentScheduleDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(issueDateTitle, issueDateValue));
		
		String instructionsTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_PAYMENT_SPECIAL_INSTRUCTIONS);
		String instructionsValue = (paymentScheduleDetails != null) ? paymentScheduleDetails.getValidLCMonths(): null;
		paymentScheduleDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(instructionsTitle, instructionsValue));

		paymentScheduleTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_PAYMENT_ESTIMATED_PAYMENTAMOUNT)));
		paymentScheduleTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_PAYMENT__ESTIMATED_MONTHS_FROM_ISSUE)));
		paymentScheduleTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_PAYMENT_ESTIMATED_PAYMENTDATE)));
		if(paymentScheduleDetails!=null){
			List<AdditionalPayments> additionalPayments =paymentScheduleDetails.getAdditionalPayments();
			for(AdditionalPayments additionalPayment : additionalPayments) {
				String paymentAmountValue = (paymentScheduleDetails != null) ? ALOCPDFReportHelper.formatCurrency(additionalPayment.getEstAmt()): null;
				paymentScheduleTable.addCell(ALOCPDFStyle.createTableDataCell(paymentAmountValue)); 
				String monthsValue = (paymentScheduleDetails != null) ? additionalPayment.getEstMonths().toString(): null;
				paymentScheduleTable.addCell(ALOCPDFStyle.createTableDataCell(monthsValue));
				String paymentDateValue = (paymentScheduleDetails != null) ? ALOCPDFReportHelper.formatDate(additionalPayment.getEstDt()) : null;
				paymentScheduleTable.addCell(ALOCPDFStyle.createTableDataCell(paymentDateValue));
			}
		}
		section.add(paymentScheduleDetailsTable);
		section.add(paymentScheduleTable);
		return this;
	}
	
}
