/*
 * Copyright © 2013 GE. ALL RIGHTS RESERVED.
 * FileName: BankAndSBLCBuilder.java
 * Purpose: This class renders BankGuaranteeRequest Page of the PDF report.
 */
package com.ge.aloc.reports.pdf.request;

import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_AGREEMENT_NAME;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_AMOUNT_OF_INSTRUMENT;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_APPLICANT;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_APPLICANT_GEAPPLICANTREFERENCE1;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_APPLICANT_GEAPPLICANTREFERENCE2;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_APPLICANT_GEAPPLICANTREFERENCE3;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_APPROXIMATE_USD_INSTRUMENT_AMT;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_AUTO_INCDEC_AMOUNT;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_AUTO_INCDEC_DATE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_AUTO_INCDEC_INDICATOR;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_AUTO_INCREASE_OR_DECREASE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_BID_CONTRACT_AMOUNT;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_BID_CONTRACT_CURRENCY;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_BID_DATE_OPTIONAL;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_BID_PROPOSAL_NUMBER;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_BILLING_REFERENCE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_BUSINESS_CONTACT_PERSON;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_BUSINESS_PROJECT_ID;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_CONTRACT_DATE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_CONTRACT_NUMBER;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_COUNTRY_OF_ISSUANCE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_CURRENCY_OF_INSTRUMENT;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_CUSTOMER_BENEFICIARY;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_CUSTOMER_BENEFICIARY_REFERENCE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_CUSTOMER_BENEFICIARY_REFERENCE2;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_CUSTOMER_BENEFICIARY_REFERENCE3;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_DAYS_IN_CURE_PERIOD;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_ECONOMIC_EXPIRATION_DATE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_EXPIRATION_DATE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_FALSE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_HAS_CSOREFERENCE_BEEN_CERTIFIED;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_INITIAL_EXP_DATE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_INSTRUMENT_COMPLIES_WITH_CONTRACT_REQUIREMENTS;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_INSTRUMENT_DETAILS;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_INSTRUMENT_HAS_CURE_PERIOD;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_INSTRUMENT_HAS_NOTIFICATION_CLAUSE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_INSTRUMENT_PURPOSE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_INSTRUMENT_REPORTING_ATTRIBUTES;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_INSTRUMENT_REQUIRES_GEAPPROVAL;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_INSTRUMENT_RISK;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_ISSUE_DATE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_IS_TRI_PARTY_APPLICANT;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_IS_TRI_PARTY_PRIVATE_LABEL;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_LEGAL_ENTITY_GOLDID;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_LEGAL_ENTITY_NAME;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_MAXIMUM_POSSIBLE_EXPOSURE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_NAME_AND_ADDRESS;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_NO_OF_DAYS_NOTICE_PERIOD;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_PERCENTAGE_VALUE_OF_TOTAL_BID;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_POLE_NAME;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_PRINCIPAL_ADN;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_PRINCIPAL_BUC;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_PRINCIPAL_CSO_DATE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_PRINCIPAL_CSO_NUMBER;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_PROJECT_DESC;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_REIMBERSMENT_AGREEMENT;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_REIMBURSEMENT_AGREEMENT_TEXT;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_SELECTED_SITE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_SPECIAL_INSTRUCTIONS;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_STANDBY_ADVERTISEMENT;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_STANDBY_ADVISED_IN;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_STANDBY_CONFIRMATION;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_STANDBY_CONFIRMED_IN;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_STANDBY_ISSUESD_US;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_STANDBY_LETTER_OF_CREDIT;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_TRANSACTION_PARTIES;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_TRI_PARTY_APPLICANT;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_TRUE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_USD_BID_CONTRACT_AMOUNT;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_USD_IS_AUTO_EXTEND_CLAUSE_PRESENT;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_WHY_THIS_INSTRUMENT_DOES_NOT_COMPLY;

import java.util.List;

import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.model.AddressDtls;
import com.ge.aloc.model.AutoIncDec;
import com.ge.aloc.model.Customer;
import com.ge.aloc.model.DeliveryInstructions;
import com.ge.aloc.model.InstrReporting;
import com.ge.aloc.model.InstrumentDetails;
import com.ge.aloc.model.InstrumentRisk;
import com.ge.aloc.model.ProjDescription;
import com.ge.aloc.model.RequestDetails;
import com.ge.aloc.model.SBLC;
import com.ge.aloc.model.SiteCustom;
import com.ge.aloc.model.TpApplicantDetails;
import com.ge.aloc.model.TransactionParties;
import com.ge.aloc.reports.pdf.ALOCPDFReportHelper;
import com.ge.aloc.reports.pdf.ALOCPDFStyle;
import com.ge.aloc.reports.pdf.ReportContext;
import com.hydus.hwf.exceptions.HWFServiceException;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPTable;

/**
 * This class provides logic to render BankGuaranteeRequest page of the report.
 * 
 * @author kranthi.anumula
 */
public class BankAndSBLCBuilder {

	private final ReportContext reportContext;
	private final RequestDetails requestDetails;

	/**
	 * Constructor to instantiate the object.
	 * 
	 * @param context
	 */
	public BankAndSBLCBuilder(ReportContext context) {
		this.reportContext = context;
		this.requestDetails = context.getRequestDetails();
	}


	/**
	 * This is append Transaction Parties section of Bank Guarantee request
	 * @return
	 */
	public BankAndSBLCBuilder appendTransactionParties() throws DocumentException {
		TransactionParties transactionParties = requestDetails.getTransactionParties();
		String transactionPartiesTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_TRANSACTION_PARTIES);
		Section section = ALOCPDFStyle.createSection(transactionPartiesTitle, reportContext.getCurrentChapter());
		PdfPTable transactionPartiesTable = ALOCPDFStyle.createSectionDataTable();

		String selectedSiteTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_SELECTED_SITE);
		String selectedSite = (requestDetails.getSiteName()!= null) ? requestDetails.getSiteName() : null;
		transactionPartiesTable.addCell(ALOCPDFStyle.createSectionDataCell(selectedSiteTitle, selectedSite));

		String instrumentPurposeTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_INSTRUMENT_PURPOSE);
		String instrumentPurpose = ( transactionParties!= null) ? transactionParties.getInstrumentPurpose() : null;
		transactionPartiesTable.addCell(ALOCPDFStyle.createSectionDataCell(instrumentPurposeTitle, instrumentPurpose));


		String isATriPartyRequestTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_IS_TRI_PARTY_APPLICANT);
		String isATriPartyRequest = ( transactionParties!= null) ? ALOCPDFReportHelper.convertBooleanAsYesOrNo(transactionParties.isTriPartyRequestFlag()) : null;
		transactionPartiesTable.addCell(ALOCPDFStyle.createSectionDataCell(isATriPartyRequestTitle, isATriPartyRequest));

		String isATriPartyPrivateLabelTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_IS_TRI_PARTY_PRIVATE_LABEL);
		String isATriPartyPrivateLabel = ( transactionParties!= null) ? ALOCPDFReportHelper.convertBooleanAsYesOrNo(transactionParties.isPrivateLabelFlag()) : null;
		transactionPartiesTable.addCell(ALOCPDFStyle.createSectionDataCell(isATriPartyPrivateLabelTitle, isATriPartyPrivateLabel));

		section.add(transactionPartiesTable);
		return this;
	}

	/**
	 * This is append Transaction Parties/applicant section of Bank Guarantee request
	 * @return
	 */
	public BankAndSBLCBuilder appendTpApplicantDetails() throws DocumentException {
		TpApplicantDetails tpApplicantDetails = requestDetails.getTransactionParties().getTpApplicantDetails();
		String tpApplicantDetailsTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_APPLICANT);
		Section section = ALOCPDFStyle.createSection(tpApplicantDetailsTitle, reportContext.getCurrentChapter());
		PdfPTable tpApplicantDetailsTable = ALOCPDFStyle.createSectionDataTable();

		String legalEntityNameTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_LEGAL_ENTITY_NAME);
		String legalEntityName = ( tpApplicantDetails!= null) ? tpApplicantDetails.getLeName() : null;
		tpApplicantDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(legalEntityNameTitle, legalEntityName));

		String legalEntityGOLDIDTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_LEGAL_ENTITY_GOLDID);
		String legalEntityGOLDID = ( tpApplicantDetails!= null) ? tpApplicantDetails.getLeGoldId() : null;
		tpApplicantDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(legalEntityGOLDIDTitle, legalEntityGOLDID));

		String businessContactPersonTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_BUSINESS_CONTACT_PERSON);
		if (tpApplicantDetails != null) {
			Integer ssoid = tpApplicantDetails.getTpBuContactPerson().getSsoId();
			String [] businessContactPerson = {tpApplicantDetails.getTpBuContactPerson().getFirstName(),
					tpApplicantDetails.getTpBuContactPerson().getLastName(),
					(ssoid != null) ? ssoid.toString(): null};
			tpApplicantDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(businessContactPersonTitle,businessContactPerson));
		}
		String nameAddressTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_NAME_AND_ADDRESS);
		AddressDtls addressDtls = tpApplicantDetails.getAddressDtls();
		if(addressDtls != null) {
			String[] addressValues = ALOCPDFReportHelper.convertAddressAsString(addressDtls);
			tpApplicantDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(nameAddressTitle, addressValues));

		}
		String refTitle1 = ALOCPDFReportHelper.getResourceValue(RES_KEY_APPLICANT_GEAPPLICANTREFERENCE1);
		String refValue1 = (tpApplicantDetails != null) ? tpApplicantDetails.getRefDetails().get(ALOCConstants.BASE_VALUE).getRefValue() : null;
		tpApplicantDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(refTitle1, refValue1));
		if(tpApplicantDetails.getRefDetails().size() > ALOCConstants.MIN_VALUE){
			String refTitle2 = ALOCPDFReportHelper.getResourceValue(RES_KEY_APPLICANT_GEAPPLICANTREFERENCE2);
			String refValue2 = (tpApplicantDetails != null) ? tpApplicantDetails.getRefDetails().get(ALOCConstants.MIN_VALUE).getRefValue() : null;
			tpApplicantDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(refTitle2, refValue2));
		}
		if(tpApplicantDetails.getRefDetails().size() > ALOCConstants.SECOND_VALUE){
			String refTitle3 = ALOCPDFReportHelper.getResourceValue(RES_KEY_APPLICANT_GEAPPLICANTREFERENCE3);
			String refValue3 = (tpApplicantDetails != null) ? tpApplicantDetails.getRefDetails().get(ALOCConstants.SECOND_VALUE).getRefValue() : null;
			tpApplicantDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(refTitle3, refValue3));
		}
		String businessUnitCodeTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_PRINCIPAL_BUC);
		String businessUnitCode = ( tpApplicantDetails!= null) ? tpApplicantDetails.getBuUnit() : null;
		tpApplicantDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(businessUnitCodeTitle, businessUnitCode));

		String accountingDistributionNumberTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_PRINCIPAL_ADN);
		String accountingDistributionNumber = ( tpApplicantDetails!= null) ? tpApplicantDetails.getAccDist() : null;
		tpApplicantDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(accountingDistributionNumberTitle, accountingDistributionNumber));

		String csoNumberTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_PRINCIPAL_CSO_NUMBER);
		String csoNumber = ( tpApplicantDetails!= null) ? tpApplicantDetails.getCsoNo() : null;
		tpApplicantDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(csoNumberTitle, csoNumber));

		String approvalDateTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_PRINCIPAL_CSO_DATE);
		String approvalDate = ( tpApplicantDetails!= null) ? ALOCPDFReportHelper.formatDate(tpApplicantDetails.getCsoApprovalDt()) : null;
		tpApplicantDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(approvalDateTitle, approvalDate));

		String certifyFlagTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_HAS_CSOREFERENCE_BEEN_CERTIFIED);
		String certifyFlag = ( tpApplicantDetails!= null) ? ALOCPDFReportHelper.convertBooleanAsYesOrNo(tpApplicantDetails.isCertifyFlag()) : null;
		tpApplicantDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(certifyFlagTitle, certifyFlag));

		section.add(tpApplicantDetailsTable);
		return this;
	}

	/**
	 * This is append TriParty applicant section of Bank Guarantee request
	 * @return
	 */
	public BankAndSBLCBuilder appendCustomerDetails() throws DocumentException {
		Customer customerDetails = requestDetails.getTransactionParties().getCustomer();
		String customerDetailsTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_CUSTOMER_BENEFICIARY);
		Section section = ALOCPDFStyle.createSection(customerDetailsTitle, reportContext.getCurrentChapter());
		PdfPTable customerDetailsTable = ALOCPDFStyle.createSectionDataTable();

		String nameAddressTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_NAME_AND_ADDRESS);
		AddressDtls addressDtls = customerDetails.getAddressDtls();
		if(addressDtls != null) {
			String[] addressValues = ALOCPDFReportHelper.convertAddressAsString(addressDtls);
			customerDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(nameAddressTitle, addressValues));				
		}
		String refTitle1 = ALOCPDFReportHelper.getResourceValue(RES_KEY_CUSTOMER_BENEFICIARY_REFERENCE);
		String refValue1 = (customerDetails != null) ? customerDetails.getRefDetails().get(ALOCConstants.BASE_VALUE).getRefValue() : null;
		customerDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(refTitle1, refValue1));
		if(customerDetails.getRefDetails().size() > ALOCConstants.MIN_VALUE){
			String refTitle2 = ALOCPDFReportHelper.getResourceValue(RES_KEY_CUSTOMER_BENEFICIARY_REFERENCE2);
			String refValue2 = (customerDetails != null) ? customerDetails.getRefDetails().get(ALOCConstants.MIN_VALUE).getRefValue() : null;
			customerDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(refTitle2, refValue2));
		}
		if(customerDetails.getRefDetails().size() > ALOCConstants.SECOND_VALUE){
			String refTitle3 = ALOCPDFReportHelper.getResourceValue(RES_KEY_CUSTOMER_BENEFICIARY_REFERENCE3);
			String refValue3 = (customerDetails != null) ? customerDetails.getRefDetails().get(ALOCConstants.SECOND_VALUE).getRefValue() : null;
			customerDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(refTitle3, refValue3));
		}
		section.add(customerDetailsTable);
		return this;
	}

	/**
	 * This is append TriParty applicant section of Bank Guarantee request
	 * @return
	 */
	public BankAndSBLCBuilder appendTriPartyApplicant() throws DocumentException {
		
		TransactionParties tp =	requestDetails.getTransactionParties();
		Boolean tpFlag = (tp != null) ? tp.isTriPartyRequestFlag() : null; 
		if(tpFlag != null && tpFlag == true){
			AddressDtls triPartyApplicant = tp.getTriPartyApplicant();
			String triPartyApplicantTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_TRI_PARTY_APPLICANT);
			Section section = ALOCPDFStyle.createSection(triPartyApplicantTitle, reportContext.getCurrentChapter());
			PdfPTable triPartyApplicantTable = ALOCPDFStyle.createSectionDataTable();

			String nameAddressTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_NAME_AND_ADDRESS);
			if(triPartyApplicant != null) {
				String [] addressValues = ALOCPDFReportHelper.convertAddressAsString(triPartyApplicant);
				triPartyApplicantTable.addCell(ALOCPDFStyle.createSectionDataCell(nameAddressTitle, addressValues));
			}
			section.add(triPartyApplicantTable);
		}
		return this;
	}

	/**
	 * This is append Instrument Details section  of Bank Guarantee request
	 * @return
	 */
	public BankAndSBLCBuilder appendInstrumentDetails() throws DocumentException {
		InstrumentDetails instrumentDetails = requestDetails.getInstrumentDetails();
		String instrumentDetailsTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_INSTRUMENT_DETAILS);
		Section section = ALOCPDFStyle.createSection(instrumentDetailsTitle, reportContext.getCurrentChapter());
		PdfPTable instrumentDetailsTable = ALOCPDFStyle.createSectionDataTable();

		instrumentDetailsTable=fillAmountAndDates(instrumentDetails,instrumentDetailsTable);
		String isAnAutoExtendClausePresentTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_USD_IS_AUTO_EXTEND_CLAUSE_PRESENT);
		String isAnAutoExtendClausePresent = ( instrumentDetails!= null ) ? instrumentDetails.getAutoExtendClause().getAutoExtendFlag()  : null;
		String autoStr = ALOCConstants.EMPTY_STRING;
		if(isAnAutoExtendClausePresent != null && isAnAutoExtendClausePresent.equals(ALOCConstants.TRUE_SMALL)){
			autoStr = ALOCConstants.YES;
		}else {
			autoStr = ALOCConstants.NO;
		}
		instrumentDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(isAnAutoExtendClausePresentTitle, autoStr));
		if(autoStr.equals(ALOCConstants.YES)){
			String noOfDaysTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_NO_OF_DAYS_NOTICE_PERIOD);
			String noOfdays = ( instrumentDetails!= null ) ? instrumentDetails.getAutoExtendClause().getNonRenewalPeriod()  : null;
			instrumentDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(noOfDaysTitle, noOfdays));
			
			String initialExpdateTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_INITIAL_EXP_DATE);
			String initialExpDate = ALOCConstants.EMPTY_STRING;
			if(instrumentDetails!= null && instrumentDetails.getInitialExpiryDt()!=null){
				initialExpDate = ALOCPDFReportHelper.formatDate(instrumentDetails.getInitialExpiryDt());
			}
			instrumentDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(initialExpdateTitle, initialExpDate));
		}
		String autoIncDecTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_AUTO_INCREASE_OR_DECREASE);
		String autoIncDecFlag = ( instrumentDetails!= null ) ? instrumentDetails.getAutoIncDecFlag() : null;
		if(autoIncDecFlag != null && autoIncDecFlag.equalsIgnoreCase(ALOCConstants.TRUE_SMALL)){
			autoIncDecFlag = ALOCConstants.YES;
		}else {
			autoIncDecFlag = ALOCConstants.NO;
		}
		instrumentDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(autoIncDecTitle, autoIncDecFlag));
		section.add(instrumentDetailsTable);
		if(instrumentDetails != null &&instrumentDetails.getAutoIncDecFlag()!=null && instrumentDetails.getAutoIncDecFlag().equalsIgnoreCase(ALOCConstants.TRUE_SMALL)){
			PdfPTable autoIncDecTable = ALOCPDFStyle.createTable(33f, 33f, 34f);
			autoIncDecTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_AUTO_INCDEC_INDICATOR)));
			autoIncDecTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_AUTO_INCDEC_AMOUNT)));
			autoIncDecTable.addCell(ALOCPDFStyle.createTableHeaderCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_AUTO_INCDEC_DATE)));
			if(instrumentDetails!=null){
				List<AutoIncDec> autoIncDecs =instrumentDetails.getAutoIncDecs();
				for(AutoIncDec autoIncDec : autoIncDecs) { 
					autoIncDecTable.addCell(ALOCPDFStyle.createTableDataCell(autoIncDec.getAutoIncIndicator()));
					autoIncDecTable.addCell(ALOCPDFStyle.createTableDataCell(ALOCPDFReportHelper.formatCurrency(autoIncDec.getAutoIncAmt())));
					autoIncDecTable.addCell(ALOCPDFStyle.createTableDataCell(ALOCPDFReportHelper.formatDate(autoIncDec.getAutoIncDt())));
				}
			}
			section.add(autoIncDecTable);
		}
		return this;
	}
	/**
	 * fillAmountAndDates to fill Amount And Dates of instrumentDetails
	 * @param instrumentDetails
	 * @param instrumentDetailsTable
	 * @return instrumentDetailsTable
	 */
	private PdfPTable fillAmountAndDates(InstrumentDetails instrumentDetails,PdfPTable instrumentDetailsTable) {
		
		String countryOfIssuanceTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_COUNTRY_OF_ISSUANCE);
		String countryOfIssuance = ( instrumentDetails!= null) ? instrumentDetails.getIssuanceCountry() : null;
		instrumentDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(countryOfIssuanceTitle, countryOfIssuance));
		
		String currencyOfInstrumentTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_CURRENCY_OF_INSTRUMENT);
		String currencyOfInstrument = ( instrumentDetails!= null) ? instrumentDetails.getInstrumentCurrency() : null;
		instrumentDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(currencyOfInstrumentTitle, currencyOfInstrument));

		String amountOfInstrumentTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_AMOUNT_OF_INSTRUMENT);
		String amountOfInstrument = ( instrumentDetails!= null && instrumentDetails.getInstrumentAmt()!=null) ?
				ALOCPDFReportHelper.formatCurrency(instrumentDetails.getInstrumentAmt()) : null;
		instrumentDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(amountOfInstrumentTitle, amountOfInstrument));

		String approximateUSDInstrumentAmountTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_APPROXIMATE_USD_INSTRUMENT_AMT);
		String approximateUSDInstrumentAmount = ( instrumentDetails!= null && instrumentDetails.getUSDEquivalent()!= null ) ?
				ALOCPDFReportHelper.formatCurrency(instrumentDetails.getUSDEquivalent()) : null;
		instrumentDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(approximateUSDInstrumentAmountTitle, approximateUSDInstrumentAmount));

		String percentageOfValueOfTotalBidTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_PERCENTAGE_VALUE_OF_TOTAL_BID);
		String percentageOfValueOfTotalBid = ( instrumentDetails!= null && instrumentDetails.getPercentValueOfBid()!= null ) ?
				instrumentDetails.getPercentValueOfBid().toString() : null;
		instrumentDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(percentageOfValueOfTotalBidTitle, percentageOfValueOfTotalBid));

		String maximumPossibleExposureTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_MAXIMUM_POSSIBLE_EXPOSURE);
		String maximumPossibleExposure = ( instrumentDetails!= null ) ? instrumentDetails.getMaxPossibleExpo() : null;
		instrumentDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(maximumPossibleExposureTitle, maximumPossibleExposure));

		String issueDateTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_ISSUE_DATE);
		String issueDateValue = (instrumentDetails != null) ? ALOCPDFReportHelper.formatDate(instrumentDetails.getIssueDt()): null;
		instrumentDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(issueDateTitle, issueDateValue));

		String expiryDateTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_EXPIRATION_DATE);
		String expireDateValue = (instrumentDetails != null) ? ALOCPDFReportHelper.formatDate(instrumentDetails.getExpiryDt()): null;
		instrumentDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(expiryDateTitle, expireDateValue));

		String economicExpirationDateTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_ECONOMIC_EXPIRATION_DATE);
		String economicExpirationDate = ( instrumentDetails!= null ) ?  ALOCPDFReportHelper.formatDate(instrumentDetails.getEconoExpiryDt()): null;
		instrumentDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(economicExpirationDateTitle, economicExpirationDate));
		
		DeliveryInstructions deliveryInstructions = requestDetails.getDeliveryInstructions();
		String specialInstTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_SPECIAL_INSTRUCTIONS);
		String specialInstValue = (deliveryInstructions != null) ? deliveryInstructions.getSpecialInstructions(): null;
		instrumentDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(specialInstTitle, specialInstValue));
		
		return instrumentDetailsTable;
	}


	/**
	 * This is append Instrument Risk section of Bank Guarantee request
	 * @return
	 */
	public BankAndSBLCBuilder appendInstrumentRisk() throws DocumentException {
		InstrumentRisk instrumentRisk = requestDetails.getInstrumentRisk();
		String instrumentRiskTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_INSTRUMENT_RISK);
		Section section = ALOCPDFStyle.createSection(instrumentRiskTitle, reportContext.getCurrentChapter());
		PdfPTable instrumentRiskTable = ALOCPDFStyle.createSectionDataTable();

		String instrumentHasANotificationClauseTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_INSTRUMENT_HAS_NOTIFICATION_CLAUSE);
		String instrumentHasANotificationClause = ( instrumentRisk!= null) ? ALOCPDFReportHelper.convertBooleanAsYesOrNo(instrumentRisk.isNotiClauseFlag()) : null;
		instrumentRiskTable.addCell(ALOCPDFStyle.createSectionDataCell(instrumentHasANotificationClauseTitle, instrumentHasANotificationClause));

		String instrumentHasACurePeriodTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_INSTRUMENT_HAS_CURE_PERIOD);
		String instrumentHasACurePeriod = ( instrumentRisk!= null) ? ALOCPDFReportHelper.convertBooleanAsYesOrNo(instrumentRisk.isCurePeriodFlag()) : null;
		instrumentRiskTable.addCell(ALOCPDFStyle.createSectionDataCell(instrumentHasACurePeriodTitle, instrumentHasACurePeriod));
		
		String cureFlag = (instrumentRisk!=null) ? instrumentRisk.isCurePeriodFlag().toString() : null;
		if(cureFlag != null && cureFlag.equals(ALOCPDFReportHelper.getResourceValue(RES_KEY_TRUE))){
			String numberOfDaysInCurePeriodTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_DAYS_IN_CURE_PERIOD);
			String numberOfDaysInCurePeriod = ( instrumentRisk!= null && instrumentRisk.getCurePeriodValue()!= null) ? instrumentRisk.getCurePeriodValue().toString() : null;
			instrumentRiskTable.addCell(ALOCPDFStyle.createSectionDataCell(numberOfDaysInCurePeriodTitle, numberOfDaysInCurePeriod));
		}
		String instrumentRequiresGEApprovalPriorToDrawDownTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_INSTRUMENT_REQUIRES_GEAPPROVAL);
		String instrumentRequiresGEApprovalPriorToDrawDown = ( instrumentRisk!= null ) ? ALOCPDFReportHelper.convertBooleanAsYesOrNo(instrumentRisk.isDrDownApprFlag()) : null;
		instrumentRiskTable.addCell(ALOCPDFStyle.createSectionDataCell(instrumentRequiresGEApprovalPriorToDrawDownTitle, instrumentRequiresGEApprovalPriorToDrawDown));

		String instrumentCompliesWithTheContractRequirementsTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_INSTRUMENT_COMPLIES_WITH_CONTRACT_REQUIREMENTS);
		String instrumentCompliesWithTheContractRequirements = ( instrumentRisk!= null ) ? ALOCPDFReportHelper.convertBooleanAsYesOrNo(instrumentRisk.isContrReqFlag()) : null;
		instrumentRiskTable.addCell(ALOCPDFStyle.createSectionDataCell(instrumentCompliesWithTheContractRequirementsTitle, instrumentCompliesWithTheContractRequirements));
		
		if(instrumentCompliesWithTheContractRequirements != null && instrumentHasACurePeriod.equals(ALOCPDFReportHelper.getResourceValue(RES_KEY_FALSE))){
			String explainOfWhyThisInstrumentDoesNotComplyTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_WHY_THIS_INSTRUMENT_DOES_NOT_COMPLY);
			String explainOfWhyThisInstrumentDoesNotComply = ( instrumentRisk!= null ) ? instrumentRisk.getContrReqReason() : null;
			instrumentRiskTable.addCell(ALOCPDFStyle.createSectionDataCell(explainOfWhyThisInstrumentDoesNotComplyTitle, explainOfWhyThisInstrumentDoesNotComply));
		}
		section.add(instrumentRiskTable);
		return this;
	}

	/**
	 * This is append Instrument Reporting Attributes section of Bank Guarantee request
	 * @return
	 */
	public BankAndSBLCBuilder appendInstrReporting() throws DocumentException {
		InstrReporting instrReporting = requestDetails.getInstrReporting();
		String instrReportingTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_INSTRUMENT_REPORTING_ATTRIBUTES);
		Section section = ALOCPDFStyle.createSection(instrReportingTitle, reportContext.getCurrentChapter());
		PdfPTable instrReportingTable = ALOCPDFStyle.createSectionDataTable();

		String poleNameTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_POLE_NAME);
		String poleName = ( instrReporting!= null ) ? instrReporting.getPoleName() : null;
		instrReportingTable.addCell(ALOCPDFStyle.createSectionDataCell(poleNameTitle, poleName));
		List<SiteCustom> siteCustoms = instrReporting.getSiteCustoms();
		for(SiteCustom siteCustom:siteCustoms){
			String siteCustomTitle = siteCustom.getSiteCustomField();
			String siteCustomValue = (siteCustom != null) ? siteCustom.getSiteCustomValue() : null;
			instrReportingTable.addCell(ALOCPDFStyle.createSectionDataCell(siteCustomTitle, siteCustomValue));
		}
		String businessProjectIDTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_BUSINESS_PROJECT_ID);
		String businessProjectID = ( instrReporting!= null && instrReporting.getBuProjId()!= null) ? instrReporting.getBuProjId().toString() : null;
		instrReportingTable.addCell(ALOCPDFStyle.createSectionDataCell(businessProjectIDTitle, businessProjectID));

		String billingReferenceTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_BILLING_REFERENCE);
		String billingReference = ( instrReporting!= null) ? instrReporting.getBillingRef() : null;
		instrReportingTable.addCell(ALOCPDFStyle.createSectionDataCell(billingReferenceTitle, billingReference));

		section.add(instrReportingTable);
		return this;
	}
	
	/**
	 * This method is used to add Project Description section
	 * @return
	 * @throws DocumentException
	 */
	public BankAndSBLCBuilder appendProjectDescription() throws DocumentException {
		ProjDescription projectDescription = requestDetails.getProjDescription();
		String projDescTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_PROJECT_DESC);
		Section section = ALOCPDFStyle.createSection(projDescTitle, reportContext.getCurrentChapter());
		PdfPTable projectDescriptionTable = ALOCPDFStyle.createSectionDataTable();

		String projectDescValue = (projectDescription != null) ? projectDescription.getProjDesc() : null;
		projectDescriptionTable.addCell(ALOCPDFStyle.createSectionDataCell(projDescTitle, projectDescValue));

		String bidDateTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_BID_DATE_OPTIONAL);
		String bidDate = ( projectDescription!= null) ?  ALOCPDFReportHelper.formatDate(projectDescription.getBidDt()) : null;
		projectDescriptionTable.addCell(ALOCPDFStyle.createSectionDataCell(bidDateTitle, bidDate));

		String bidProposalNumberTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_BID_PROPOSAL_NUMBER);
		String bidProposalNumber = ( projectDescription!= null && projectDescription.getBidProposalNo()!= null) ?  projectDescription.getBidProposalNo().toString() : null;
		projectDescriptionTable.addCell(ALOCPDFStyle.createSectionDataCell(bidProposalNumberTitle, bidProposalNumber));

		String contractNumberTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_CONTRACT_NUMBER);
		String contractNumber = ( projectDescription!= null && projectDescription.getContractNo()!= null) ?  projectDescription.getContractNo().toString() : null;
		projectDescriptionTable.addCell(ALOCPDFStyle.createSectionDataCell(contractNumberTitle, contractNumber));

		String contractDateTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_CONTRACT_DATE);
		String contractDate = ( projectDescription!= null) ?  ALOCPDFReportHelper.formatDate(projectDescription.getContractDt()) : null;
		projectDescriptionTable.addCell(ALOCPDFStyle.createSectionDataCell(contractDateTitle, contractDate));

		String bidContractCurrencyTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_BID_CONTRACT_CURRENCY);
		String bidContractCurrency = ( projectDescription!= null) ?  projectDescription.getBidCurrName() : null;
		projectDescriptionTable.addCell(ALOCPDFStyle.createSectionDataCell(bidContractCurrencyTitle, bidContractCurrency));

		String bidContractAmountTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_BID_CONTRACT_AMOUNT);
		String bidContractAmount = ( projectDescription!= null && projectDescription.getBidContractAmt()!=null) ? 
				ALOCPDFReportHelper.formatCurrency(projectDescription.getBidContractAmt()) : null;
		projectDescriptionTable.addCell(ALOCPDFStyle.createSectionDataCell(bidContractAmountTitle, bidContractAmount));

		String usdBidContractAmountTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_USD_BID_CONTRACT_AMOUNT);
		String usdBidContractAmount = ( projectDescription!= null && projectDescription.getBidUSDEquivalent()!=null) ? 
				ALOCPDFReportHelper.formatCurrency(projectDescription.getBidUSDEquivalent()) : null;
		projectDescriptionTable.addCell(ALOCPDFStyle.createSectionDataCell(usdBidContractAmountTitle, usdBidContractAmount));

		section.add(projectDescriptionTable);
		return this;
	}

	/**
	 * This is append StandByLetterOfCredit Details section 
	 * @return
	 */
	public BankAndSBLCBuilder appendStandByLetterOfCredit() throws DocumentException {

		SBLC sblc = requestDetails.getSBLC();
		String sblcDetailsTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_STANDBY_LETTER_OF_CREDIT);

		Section section = ALOCPDFStyle.createSection(sblcDetailsTitle,reportContext.getCurrentChapter());
		PdfPTable sblcDetailsTable = ALOCPDFStyle.createSectionDataTable();

		String standbyIssuedinUSTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_STANDBY_ISSUESD_US);
		String standbyIssuedinUSValue = (sblc != null) ? ALOCPDFReportHelper.convertBooleanAsYesOrNo(sblc.isUSIssuanceFlag()) : null;
		sblcDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(standbyIssuedinUSTitle, standbyIssuedinUSValue));

		if(sblc!=null && sblc.isUSIssuanceFlag()){
			String standbyConfirmationTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_STANDBY_CONFIRMATION);
			String standbyConfirmationValue = (sblc != null) ? ALOCPDFReportHelper.convertBooleanAsYesOrNo(sblc.isCreditReqCnfmFlag()) : null;
			sblcDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(standbyConfirmationTitle, standbyConfirmationValue));
			if(sblc!=null && sblc.isCreditReqCnfmFlag()){
				String standbyConfirmedInTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_STANDBY_CONFIRMED_IN);
				String standbyConfirmedInValue = (sblc != null) ? sblc.getCreditCnfmCountry() : null;
				sblcDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(standbyConfirmedInTitle, standbyConfirmedInValue));
			}else{
				String standbyAdvertisementTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_STANDBY_ADVERTISEMENT);
				String standbyAdvertisementValue = (sblc != null) ? ALOCPDFReportHelper.convertBooleanAsYesOrNo(sblc.isCreditReqAdviseFlag()) : null;
				sblcDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(standbyAdvertisementTitle, standbyAdvertisementValue));
				if(sblc!=null && sblc.isCreditReqAdviseFlag()){
					String standbyAdvisedInTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_STANDBY_ADVISED_IN);
					String standbyAdvisedInValue = (sblc != null) ? sblc.getCreditAdviseCountry() : null;
					sblcDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(standbyAdvisedInTitle, standbyAdvisedInValue));
				}
			}
		}
		section.add(sblcDetailsTable);
		return this;
	}


	/**
	 * This is append ReimbursementAgreement request
	 * @return
	 */
	public BankAndSBLCBuilder appendReimbursementAgreement() throws DocumentException {

		String reimbursementAgreementTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_REIMBERSMENT_AGREEMENT);
		Section section = ALOCPDFStyle.createSection(reimbursementAgreementTitle, reportContext.getCurrentChapter());
		PdfPTable reimbursementAgreementTable = ALOCPDFStyle.createSectionDataTable();
		
		String agreementNameTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_AGREEMENT_NAME);
		String agreementNameValue = (requestDetails != null) ? requestDetails.getReimbursementAgreementName() : null;
		reimbursementAgreementTable.addCell(ALOCPDFStyle.createSectionDataCell(agreementNameTitle, agreementNameValue));
		
		reimbursementAgreementTable.addCell(ALOCPDFStyle.createSingleSectionDataCell(ALOCPDFReportHelper.getResourceValue(RES_KEY_REIMBURSEMENT_AGREEMENT_TEXT)));
		try{
			String reimbursementAgreementDeta=ALOCPDFReportHelper.getReimbursementAgreementData(requestDetails.getReimbursementAgreementId());
			String reimbursementData = reimbursementAgreementDeta!=null?reimbursementAgreementDeta.replaceAll(ALOCConstants.HTML_REMOVE_REGX,ALOCConstants.EMPTY_STRING):ALOCConstants.EMPTY_STRING;
			reimbursementData = reimbursementData.replaceAll(ALOCConstants.HTML_NBSP, ALOCConstants.EMPTY_STRING);
			reimbursementAgreementTable.addCell(ALOCPDFStyle.createSingleSectionDataCell(reimbursementData));
			section.add(reimbursementAgreementTable);
		}catch (HWFServiceException e) {
			throw new DocumentException(e);
		}
		return this;
	}
	
}
