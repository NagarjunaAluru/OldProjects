/*
 * Copyright © 2013 GE. ALL RIGHTS RESERVED.
 * FileName: SuretyBondBuilder.java
 * Purpose: This class renders SuretyBondRequest Page of the PDF report.
 */
package com.ge.aloc.reports.pdf.request;

import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_EST_CURRENCY_CODE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_USDEST_BID_AMOUNT;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_USD_PERFORMANCE_AMOUNT;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_ACTIVITY_CODE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_ATTORNEY_ADDRESS1;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_ATTORNEY_ADDRESS2;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_ATTORNEY_CITY;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_ATTORNEY_COUNTRY;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_ATTORNEY_EMAIL;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_ATTORNEY_FAX_NUMBER;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_ATTORNEY_INFORMATION;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_ATTORNEY_NAME;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_ATTORNEY_PHONE_NUMBER;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_ATTORNEY_STATE_PROVINCE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_ATTORNEY_ZIP_CODE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_BID_BOND_AMOUNT;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_BID_DATE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_BONDDETAILS_BONDSUBTYPE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_BONDDETAILS_BONDTYPE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_BOND_AMOUNT;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_BOND_CURRENCY;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_BOND_INFORMATION;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_BOND_TYPE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_CASE_NUMBER;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_CITY_OBLIGATION;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_CONTACT_PERSON;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_CONTRACT_AMOUNT;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_CONTRACT_CURRENCY;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_CONTRACT_DATE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_COUNTRY_OBLIGATION;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_COUNTRY_OF_ISSUANCE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_COUNTY;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_COURT_BOND_DETAILS;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_COURT_OF_JURISDICTION;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_CURRENCY_CODE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_DATE_FILED;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_DESIRED_EFFECTIVE_DATE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_DESIRED_EXPIRATION_DATE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_EFFECTIVE_DATE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_ESTIMATED_BID_AMOUNT;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_ESTIMATED_COMPLETION_DATE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_ESTIMATED_START_DATE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_EXPIRATION_DATE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_GE_REFERENCE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_GE_REFERENCE_ONE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_GE_REFERENCE_TWO;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_IMPORTER;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_JUDGEMENT_AMOUNT;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_LAW_FIRM_NAME;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_LEGAL_ENTITY_GOLDID;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_LEGAL_ENTITY_NAME;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_LIQUIDATE_DAMAGES;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_NAME_AND_ADDRESS;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_NEED_BY_DATE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_OBLIGEE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_OBLIGEE_REFERENCE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_OBLIGEE_REFERENCE_ONE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_OBLIGEE_REFERENCE_TWO;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_OTHER_INFORMATION;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_PERFORM_BOND_AMOUNTS;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_PRINCIPAL;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_PRINCIPAL_ADN;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_PRINCIPAL_BUC;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_PROJECT_DESCRIPTION;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_PROJECT_INVITATION_BIDNO;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_REQUESTOR_MAILING_ADDRESS;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_SB_NAME_AND_ADDRESS;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_SELECTED_SITE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_STATE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_STATEOFOBLIGATION;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_TYPE_OF_BOND_FORM;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_USD_BOND_AMOUNT;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_USD_CONTRACT_AMOUNT;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_WARRANTY_TERM_MONTHS;

import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.model.AddressDtls;
import com.ge.aloc.model.BondDetails;
import com.ge.aloc.model.BondInfo;
import com.ge.aloc.model.BondReqDtls;
import com.ge.aloc.model.Obligee;
import com.ge.aloc.model.Principal;
import com.ge.aloc.model.RequestDetails;
import com.ge.aloc.reports.pdf.ALOCPDFReportHelper;
import com.ge.aloc.reports.pdf.ALOCPDFStyle;
import com.ge.aloc.reports.pdf.ReportContext;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPTable;

/**
 * This class provides logic to render SuretyBond page of the report.
 * 
 * @author kranthi.anumula
 */
public class SuretyBondBuilder {


	private final ReportContext reportContext;
	private final RequestDetails requestDetails;

	/**
	 * Constructor to instantiate the object.
	 * 
	 * @param context
	 */
	public SuretyBondBuilder(ReportContext context) {
		this.reportContext = context;
		this.requestDetails = context.getRequestDetails();
	}

	/**
	 * This is append bond details section of Surety Bond request
	 * @return
	 */
	public SuretyBondBuilder appendBonddetails() throws DocumentException {
		BondDetails bondDetails = requestDetails.getBondDetails();
		String bondDetailsTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_BOND_TYPE);
		Section section = ALOCPDFStyle.createSection(bondDetailsTitle, reportContext.getCurrentChapter());
		PdfPTable bondDetailsTable = ALOCPDFStyle.createSectionDataTable();

		String selectedSiteTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_SELECTED_SITE);
		String selectedSite = (requestDetails.getSiteName()!= null) ? requestDetails.getSiteName() : null;
		bondDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(selectedSiteTitle, selectedSite));
		String bondTypeTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_BONDDETAILS_BONDTYPE);
		String bondTypeValue = (bondDetails != null) ? bondDetails.getBondType() : null;
		bondDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(bondTypeTitle, bondTypeValue));
		String bondSubTypeTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_BONDDETAILS_BONDSUBTYPE);
		String bondSubTypeValue = (bondDetails != null) ? bondDetails.getBondSubType(): null;
		bondDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(bondSubTypeTitle, bondSubTypeValue));
		section.add(bondDetailsTable);
		return this;
	}

	/**
	 * This is append Obligee details section of Surety Bond request
	 * @return
	 */
	public SuretyBondBuilder appendObligee() throws DocumentException {
		Obligee obligee = requestDetails.getObligee();
		String obligeeDetailsTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_OBLIGEE);
		Section section = ALOCPDFStyle.createSection(obligeeDetailsTitle, reportContext.getCurrentChapter());
		PdfPTable obligeeDetailsTable = ALOCPDFStyle.createSectionDataTable();

		String nameandAddressTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_NAME_AND_ADDRESS);
		if(obligee!=null && obligee.getAddressDtls()!=null){
			AddressDtls addressDtls=obligee.getAddressDtls();
			if(addressDtls != null){
				String[] addressValues = ALOCPDFReportHelper.convertAddressAsString(addressDtls);
				obligeeDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(nameandAddressTitle, addressValues));				
			}
		}
		if(obligee != null && obligee.getObligeeReves()!=null && !obligee.getObligeeReves().isEmpty()){
			String obligeeRefTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_OBLIGEE_REFERENCE);
			String obligeeReferenceValue = (obligee != null) ? obligee.getObligeeReves().get(ALOCConstants.BASE_VALUE).getRefValue() : null;
			obligeeDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(obligeeRefTitle, obligeeReferenceValue));
			if(obligee.getObligeeReves().size()>ALOCConstants.MIN_VALUE){
				String obligeeRef1Title = ALOCPDFReportHelper.getResourceValue(RES_KEY_OBLIGEE_REFERENCE_ONE);
				String obligeeReference1Value = (obligee != null) ? obligee.getObligeeReves().get(ALOCConstants.MIN_VALUE).getRefValue() : null;
				obligeeDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(obligeeRef1Title, obligeeReference1Value));
			}
			if(obligee.getObligeeReves().size()>ALOCConstants.SECOND_VALUE){
				String obligeeRef2Title = ALOCPDFReportHelper.getResourceValue(RES_KEY_OBLIGEE_REFERENCE_TWO);
				String obligeeReference2Value = (obligee != null) ? obligee.getObligeeReves().get(ALOCConstants.SECOND_VALUE).getRefValue() : null;
				obligeeDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(obligeeRef2Title, obligeeReference2Value));
			}
		}
		section.add(obligeeDetailsTable);
		return this;
	}

	/**
	 * This is append Bond Requester details section of Surety Bond request
	 * @return
	 *//*
	public SuretyBondBuilder appendBondrequestor() throws DocumentException {
		BondReqDtls bondReqDtls = requestDetails.getBondReqDtls();
		String bondReqDtlsTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_BOND_REQUESTOR);
		Section section = ALOCPDFStyle.createSection(bondReqDtlsTitle, reportContext.getCurrentChapter());
		PdfPTable bondReqDtlsTable = ALOCPDFStyle.createSectionDataTable();

		String contactPersonTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_CONTACT_PERSON);
		String conatctPersonNameValue = (bondReqDtls != null) ? bondReqDtls.getName(): null;
		String conatctPersonEmailValue = (bondReqDtls != null) ? bondReqDtls.getEmailAddress(): null;
		String conatctPersonPhnoValue = (bondReqDtls != null) ? bondReqDtls.getPhoneNo(): null;
		String conatctPersonFaxValue = (bondReqDtls != null) ? bondReqDtls.getFaxNo(): null;

		String [] contactPersonValues= {conatctPersonNameValue,conatctPersonEmailValue,conatctPersonPhnoValue,conatctPersonFaxValue};
		bondReqDtlsTable.addCell(ALOCPDFStyle.createSectionDataCell(contactPersonTitle, contactPersonValues));
		section.add(bondReqDtlsTable);
		return this;
	}*/

	/**
	 * This is append Requester Mailing Address details section of Surety Bond request
	 * @return
	 */
	public SuretyBondBuilder appendRequestorMailingAddress() throws DocumentException {
		AddressDtls mailingAddressDtls = requestDetails.getAddressDtls();
		BondReqDtls bondReqDtls = requestDetails.getBondReqDtls();
		String mailingAddressDtlsTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_REQUESTOR_MAILING_ADDRESS);
		Section section = ALOCPDFStyle.createSection(mailingAddressDtlsTitle, reportContext.getCurrentChapter());
		PdfPTable mailingAddressDetailsTable = ALOCPDFStyle.createSectionDataTable();

		String nameandAddressTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_NAME_AND_ADDRESS);
		int zero = ALOCConstants.NUM_ZERO;
		int one = ALOCConstants.NUM_ONE;
		
		if(mailingAddressDtls!=null){
			String address1=null;
			String address2=null;
			if(mailingAddressDtls.getAddress().size() > zero && mailingAddressDtls.getAddress().get(zero) !=null){
				address1=mailingAddressDtls.getAddress().get(zero);
			}
			if(mailingAddressDtls.getAddress().size() > one && mailingAddressDtls.getAddress().get(one) !=null){
				address2=mailingAddressDtls.getAddress().get(one);
			}
			String [] mailingAddressValues= {mailingAddressDtls.getName(),mailingAddressDtls.getContactFName(),
					mailingAddressDtls.getContactLName(),address1,address2,mailingAddressDtls.getCity(),
					mailingAddressDtls.getStateProvince(),mailingAddressDtls.getZIPPostalCode(),mailingAddressDtls.getCountry(),
					mailingAddressDtls.getCountryOfInc(),mailingAddressDtls.getStateOfInc(),mailingAddressDtls.getPhoneNumber()};
			mailingAddressDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(nameandAddressTitle, mailingAddressValues));
		}
		String contactPersonTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_CONTACT_PERSON);
		String conatctPersonNameValue = (bondReqDtls != null) ? bondReqDtls.getName(): null;
		String conatctPersonEmailValue = (bondReqDtls != null) ? bondReqDtls.getEmailAddress(): null;
		String conatctPersonPhnoValue = (bondReqDtls != null) ? bondReqDtls.getPhoneNo(): null;
		String conatctPersonFaxValue = (bondReqDtls != null) ? bondReqDtls.getFaxNo(): null;

		String [] contactPersonValues= {conatctPersonNameValue,conatctPersonEmailValue,conatctPersonPhnoValue,conatctPersonFaxValue};
		mailingAddressDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(contactPersonTitle, contactPersonValues));

		section.add(mailingAddressDetailsTable);
		return this;
	}

	/**
	 * This is append principal details section of Surety Bond request
	 * @return
	 */
	public SuretyBondBuilder appendPrincipal() throws DocumentException {

		Principal principal = requestDetails.getPrincipal();
		String principalTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_PRINCIPAL);
		Section section = ALOCPDFStyle.createSection(principalTitle, reportContext.getCurrentChapter());
		PdfPTable principalTable = ALOCPDFStyle.createSectionDataTable();

		String legalEntityNameTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_LEGAL_ENTITY_NAME);
		String legalEntityNameValue = (principal != null) ? principal.getLeName() : null;
		principalTable.addCell(ALOCPDFStyle.createSectionDataCell(legalEntityNameTitle, legalEntityNameValue));
		String legalGoldIdTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_LEGAL_ENTITY_GOLDID);
		String legalGoldIdValue = (principal != null) ? principal.getLeGoldId() : null;
		principalTable.addCell(ALOCPDFStyle.createSectionDataCell(legalGoldIdTitle, legalGoldIdValue));
		String nameandAddressTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_SB_NAME_AND_ADDRESS);

		AddressDtls addressDtls=principal.getAddressDtls();
		int zero = ALOCConstants.NUM_ZERO;
		int one = ALOCConstants.NUM_ONE;
		if(addressDtls != null){
				String address1=null;
				String address2=null;
				if(addressDtls.getAddress().size() > zero && addressDtls.getAddress().get(zero) !=null){
					address1 = addressDtls.getAddress().get(zero);
				}
				if(addressDtls.getAddress().size() > one && addressDtls.getAddress().get(one) !=null){
					address2 = addressDtls.getAddress().get(one);
				}
				String [] addressValues= {addressDtls.getName(),address1,address2,addressDtls.getCity(),
						addressDtls.getStateProvince(),addressDtls.getZIPPostalCode(),addressDtls.getCountry(),
						addressDtls.getCountryOfInc(),addressDtls.getStateOfInc()};
			principalTable.addCell(ALOCPDFStyle.createSectionDataCell(nameandAddressTitle, addressValues));			
		}
		if(principal != null && principal.getRefDetails()!=null && !principal.getRefDetails().isEmpty()){
			String geReferenceTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_GE_REFERENCE);
			String geReferenceValue = (principal != null) ? principal.getRefDetails().get(ALOCConstants.BASE_VALUE).getRefValue() : null;
			principalTable.addCell(ALOCPDFStyle.createSectionDataCell(geReferenceTitle, geReferenceValue));
			if(principal.getRefDetails().size()>ALOCConstants.MIN_VALUE){
				String geReference1Title = ALOCPDFReportHelper.getResourceValue(RES_KEY_GE_REFERENCE_ONE);
				String geReference1Value = (principal != null) ? principal.getRefDetails().get(ALOCConstants.MIN_VALUE).getRefValue() : null;
				principalTable.addCell(ALOCPDFStyle.createSectionDataCell(geReference1Title, geReference1Value));
			}
			if(principal.getRefDetails().size()>ALOCConstants.SECOND_VALUE){
				String geReference2Title = ALOCPDFReportHelper.getResourceValue(RES_KEY_GE_REFERENCE_TWO);
				String geReference2Value = (principal != null) ? principal.getRefDetails().get(ALOCConstants.SECOND_VALUE).getRefValue() : null;
				principalTable.addCell(ALOCPDFStyle.createSectionDataCell(geReference2Title, geReference2Value));
			}
		}
		String principalBUCTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_PRINCIPAL_BUC);
		String principalBUCValue = (principal != null) ? principal.getPrincipalBuUniteCd() : null;
		principalTable.addCell(ALOCPDFStyle.createSectionDataCell(principalBUCTitle, principalBUCValue));
		String principalADNTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_PRINCIPAL_ADN);
		String principalADNValue = (principal != null) ? principal.getPrincipalAccDistNo() : null;
		principalTable.addCell(ALOCPDFStyle.createSectionDataCell(principalADNTitle, principalADNValue));

		section.add(principalTable);
		return this;
	}

	/**
	 * This is append Bond Information details section of Surety Bond request
	 * @return
	 */
	public SuretyBondBuilder appendBidBondInformation() throws DocumentException {

		BondInfo bondInfo = requestDetails.getBondInfo();
		String bondInformationTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_BOND_INFORMATION);
		Section section = ALOCPDFStyle.createSection(bondInformationTitle, reportContext.getCurrentChapter());
		PdfPTable bondInformationTable = ALOCPDFStyle.createSectionDataTable();

		String countryOfIssuanceTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_COUNTRY_OF_ISSUANCE);
		String countryOfIssuanceValue = (bondInfo != null) ? bondInfo.getIssuanceCountryName(): null;
		bondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(countryOfIssuanceTitle, countryOfIssuanceValue));
		String exactProjDescTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_PROJECT_DESCRIPTION);
		String exactProjDescValue = (bondInfo != null) ? bondInfo.getExactProjDesc(): null;
		bondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(exactProjDescTitle, exactProjDescValue));
		String invitationBidNoTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_PROJECT_INVITATION_BIDNO);
		String invitationBidNoValue = (bondInfo != null) ?(bondInfo.getInvitationOrBidNo() != null ? bondInfo.getInvitationOrBidNo().toString() : null) : null ;
		bondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(invitationBidNoTitle, invitationBidNoValue));
		String cityObligationTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_CITY_OBLIGATION);
		String cityObligationValue = (bondInfo != null) ? bondInfo.getObligationCity(): null;
		bondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(cityObligationTitle, cityObligationValue));
		String countryObligationTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_COUNTRY_OBLIGATION);
		String countryObligationValue = (bondInfo != null) ? bondInfo.getObligationCountryOrState(): null;
		bondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(countryObligationTitle, countryObligationValue));
		String bidDateTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_BID_DATE);
		String bidDateValue = (bondInfo != null) ? ALOCPDFReportHelper.formatDate(bondInfo.getBidDt()): null;
		bondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(bidDateTitle, bidDateValue));
		String estStartDateTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_ESTIMATED_START_DATE);
		String estStartDateValue = (bondInfo != null) ? ALOCPDFReportHelper.formatDate(bondInfo.getEstStartDt()): null;
		bondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(estStartDateTitle, estStartDateValue));
		String estCompletionDateTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_ESTIMATED_COMPLETION_DATE);
		String estCompletionDateValue = (bondInfo != null) ? ALOCPDFReportHelper.formatDate(bondInfo.getEstCompletionDt()): null;
		bondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(estCompletionDateTitle, estCompletionDateValue));
		String expiryDateTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_EXPIRATION_DATE);
		String bidBondCurrencyCodeTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_EST_CURRENCY_CODE);
		String bidBondCurrencyCodeValue = (bondInfo != null) ? bondInfo.getBidBondCurrencyName(): null;
		bondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(bidBondCurrencyCodeTitle, bidBondCurrencyCodeValue));
		String expireDateValue = (bondInfo != null) ? ALOCPDFReportHelper.formatDate(bondInfo.getExpirationDt()): null;
		bondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(expiryDateTitle, expireDateValue));
		String estBidAmountTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_ESTIMATED_BID_AMOUNT);
		String usdEstBondAmountTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_USDEST_BID_AMOUNT);
		String usdEstBondAmountValue = (bondInfo != null) ? ALOCPDFReportHelper.formatCurrency(bondInfo.getUSDEstimatedBondAmt()): null;
		bondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(usdEstBondAmountTitle, usdEstBondAmountValue));
		String estBidAmountValue = (bondInfo != null) ? ALOCPDFReportHelper.formatCurrency(bondInfo.getEstBidAmount()): null;
		bondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(estBidAmountTitle, estBidAmountValue));
		String currencyCodeTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_CURRENCY_CODE);
		String currencyCodeValue = (bondInfo != null) ? bondInfo.getCurrencyName(): null;
		bondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(currencyCodeTitle, currencyCodeValue));
		String bidBondAmountTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_BID_BOND_AMOUNT);
		String bidBondAmountValue = (bondInfo != null) ? ALOCPDFReportHelper.formatCurrency(bondInfo.getBondAmount()): null;
		bondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(bidBondAmountTitle, bidBondAmountValue));
		String usdBondAmountTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_USD_BOND_AMOUNT);
		String usdBondAmountValue = (bondInfo != null) ? ALOCPDFReportHelper.formatCurrency(bondInfo.getUSEquivalentBondAmt()): null;
		bondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(usdBondAmountTitle, usdBondAmountValue));
		String warrantyTermTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_WARRANTY_TERM_MONTHS);
		String warrantyTermValue = (bondInfo.getWarrantyTerm() != null) ? bondInfo.getWarrantyTerm().toString(): null;
		bondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(warrantyTermTitle, warrantyTermValue));
		String needByDateTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_NEED_BY_DATE);
		String needByDateValue = (bondInfo != null) ? ALOCPDFReportHelper.formatDate(bondInfo.getNeedByDt()): null;
		bondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(needByDateTitle, needByDateValue));
		String otherInfoTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_OTHER_INFORMATION);
		String otherInfoValue = (bondInfo != null) ? bondInfo.getOtherInfo(): null;
		bondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(otherInfoTitle, otherInfoValue));
		String bondFormTypeTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_TYPE_OF_BOND_FORM);
		String bondFormTypeValue = (bondInfo != null) ? bondInfo.getBondFormType(): null;
		bondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(bondFormTypeTitle, bondFormTypeValue));
		section.add(bondInformationTable);
		return this;
	}

	/**
	 * This is append Contract Bond Information details section of Surety Bond request
	 * @return
	 */
	public SuretyBondBuilder appendContractBondInformation() throws DocumentException {
		BondInfo bondInfo = requestDetails.getBondInfo();
		String contractBondInformationTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_BOND_INFORMATION);
		Section section = ALOCPDFStyle.createSection(contractBondInformationTitle, reportContext.getCurrentChapter());
		PdfPTable contractBondInformationTable = ALOCPDFStyle.createSectionDataTable();
		
		String countryOfIssuanceTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_COUNTRY_OF_ISSUANCE);
		String countryOfIssuanceValue = (bondInfo != null) ? bondInfo.getIssuanceCountryName(): null;
		contractBondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(countryOfIssuanceTitle, countryOfIssuanceValue));
		String exactProjDescTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_PROJECT_DESCRIPTION);
		String exactProjDescValue = (bondInfo != null) ? bondInfo.getExactProjDesc(): null;
		contractBondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(exactProjDescTitle, exactProjDescValue));
		String invitationBidNoTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_PROJECT_INVITATION_BIDNO);
		String invitationBidNoValue = (bondInfo != null) ?(bondInfo.getInvitationOrBidNo() != null ? bondInfo.getInvitationOrBidNo().toString() : null) : null ;
		contractBondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(invitationBidNoTitle, invitationBidNoValue));
		String cityObligationTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_CITY_OBLIGATION);
		String cityObligationValue = (bondInfo != null) ? bondInfo.getObligationCity(): null;
		contractBondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(cityObligationTitle, cityObligationValue));
		String countryObligationTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_COUNTRY_OBLIGATION);
		String countryObligationValue = (bondInfo != null) ? bondInfo.getObligationCountryOrState(): null;
		contractBondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(countryObligationTitle, countryObligationValue));
		String effectiveDateTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_EFFECTIVE_DATE);
		String effectiveDateValue = (bondInfo != null) ? ALOCPDFReportHelper.formatDate(bondInfo.getEffectiveDt()): null;
		contractBondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(effectiveDateTitle, effectiveDateValue));
		String expiryDateTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_EXPIRATION_DATE);
		String expireDateValue = (bondInfo != null) ? ALOCPDFReportHelper.formatDate(bondInfo.getExpirationDt()): null;
		contractBondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(expiryDateTitle, expireDateValue));
		String contractDateTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_CONTRACT_DATE);
		String contractDateValue = (bondInfo != null) ? ALOCPDFReportHelper.formatDate(bondInfo.getContractDt()): null;
		contractBondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(contractDateTitle, contractDateValue));
		String estCompletionDateTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_ESTIMATED_COMPLETION_DATE);
		String estCompletionDateValue = (bondInfo != null) ? ALOCPDFReportHelper.formatDate(bondInfo.getEstCompletionDt()): null;
		contractBondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(estCompletionDateTitle, estCompletionDateValue));
		contractBondInformationTable = fillContractAmountandCurrency(bondInfo,contractBondInformationTable);
		String warrantyTermTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_WARRANTY_TERM_MONTHS);
		String warrantyTermValue = (bondInfo.getWarrantyTerm() != null) ? bondInfo.getWarrantyTerm().toString(): null;
		contractBondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(warrantyTermTitle, warrantyTermValue));
		String needByDateTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_NEED_BY_DATE);
		String needByDateValue = (bondInfo != null) ? ALOCPDFReportHelper.formatDate(bondInfo.getNeedByDt()): null;
		contractBondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(needByDateTitle, needByDateValue));
		String otherInfoTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_OTHER_INFORMATION);
		String otherInfoValue = (bondInfo != null) ? bondInfo.getOtherInfo(): null;
		contractBondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(otherInfoTitle, otherInfoValue));
		String bondFormTypeTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_TYPE_OF_BOND_FORM);
		String bondFormTypeValue = (bondInfo != null) ? bondInfo.getBondFormType(): null;
		contractBondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(bondFormTypeTitle, bondFormTypeValue));
		section.add(contractBondInformationTable);
		return this;
	}
	/**
	 * fillContractAmountandCurrency to fill ContractAmount and Currency of Contract bond
	 * @param bondInfo
	 * @param contractBondInformationTable
	 * @return contractBondInformationTable
	 */
	private PdfPTable fillContractAmountandCurrency(BondInfo bondInfo,PdfPTable contractBondInformationTable) {
		
		String currencyCodeTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_CURRENCY_CODE);
		String currencyCodeValue = (bondInfo != null) ? bondInfo.getPerformanceBondCurrencyName(): null;
		contractBondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(currencyCodeTitle, currencyCodeValue));
		
		String performBondAmtTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_PERFORM_BOND_AMOUNTS);
		String performBondAmtValue = (bondInfo != null) ? ALOCPDFReportHelper.formatCurrency(bondInfo.getPerformanceBondAmt()): null;
		contractBondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(performBondAmtTitle, performBondAmtValue));
		
		String usdPerformanceAmtTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_USD_PERFORMANCE_AMOUNT);
		String usdPerformanceBondAmtValue = (bondInfo != null) ? ALOCPDFReportHelper.formatCurrency(bondInfo.getUSDPerformanceBondAmt()): null;
		contractBondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(usdPerformanceAmtTitle, usdPerformanceBondAmtValue));
		
		String contractCurrencyTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_CONTRACT_CURRENCY);
		String contractCurrencyValue = (bondInfo != null) ? bondInfo.getContractCurName(): null;
		contractBondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(contractCurrencyTitle, contractCurrencyValue));
		
		String contractAmtTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_CONTRACT_AMOUNT);
		String contractAmtValue = (bondInfo != null) ? ALOCPDFReportHelper.formatCurrency(bondInfo.getContractAmt()): null;
		contractBondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(contractAmtTitle, contractAmtValue));
		
		String usdContractAmtTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_USD_CONTRACT_AMOUNT);
		String usdContractAmtValue = (bondInfo != null) ? ALOCPDFReportHelper.formatCurrency(bondInfo.getUSDContractAmt()): null;
		contractBondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(usdContractAmtTitle, usdContractAmtValue));
		
		String liquidateDamagesTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_LIQUIDATE_DAMAGES);
		String liquidateDamagesValue = (bondInfo != null) ? bondInfo.getLiquidatedDamages(): null;
		contractBondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(liquidateDamagesTitle, liquidateDamagesValue));
		
		return contractBondInformationTable;		
	}

	/**
	 * This is append Court Bond Information details section of Surety Bond request
	 * @return
	 */
	public SuretyBondBuilder appendCourtBondInformation() throws DocumentException {

		BondInfo bondInfo = requestDetails.getBondInfo();
		String courtBondInformationTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_COURT_BOND_DETAILS);
		Section section = ALOCPDFStyle.createSection(courtBondInformationTitle, reportContext.getCurrentChapter());
		PdfPTable courtBondInformationTable = ALOCPDFStyle.createSectionDataTable();
		
		String countryOfIssuanceTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_COUNTRY_OF_ISSUANCE);
		String countryOfIssuanceValue = (bondInfo != null) ? bondInfo.getIssuanceCountryName(): null;
		courtBondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(countryOfIssuanceTitle, countryOfIssuanceValue));
		String courtOfJurisdictionTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_COURT_OF_JURISDICTION);
		String courtOfJurisdictionValue = (bondInfo != null) ? bondInfo.getCourtOfJurisdiction(): null;
		courtBondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(courtOfJurisdictionTitle, courtOfJurisdictionValue));
		String countyTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_COUNTY);
		String countyValue = (bondInfo != null) ? bondInfo.getCounty(): null; 
		courtBondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(countyTitle, countyValue));
		String stateTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_STATE);
		String stateValue = (bondInfo != null) ? bondInfo.getState(): null;
		courtBondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(stateTitle, stateValue));
		String caseTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_CASE_NUMBER);
		String caseValue = (bondInfo != null) ? ((bondInfo.getCaseNumber() != null) ? bondInfo.getCaseNumber().toString(): null): null;
		courtBondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(caseTitle, caseValue));
		String dateFieldTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_DATE_FILED);
		String dateFieldValue = (bondInfo != null) ? ALOCPDFReportHelper.formatDate(bondInfo.getDateFiled()): null;
		courtBondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(dateFieldTitle, dateFieldValue));
		String judgementAmountTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_JUDGEMENT_AMOUNT);
		String judgementAmountValue = (bondInfo != null) ? ALOCPDFReportHelper.formatCurrency(bondInfo.getJudgementAmount()):null;
		courtBondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(judgementAmountTitle, judgementAmountValue));
		String bondCurrencyTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_BOND_CURRENCY);
		String bondCurrencyValue = (bondInfo != null) ? bondInfo.getBondCurrency(): null;
		courtBondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(bondCurrencyTitle, bondCurrencyValue));
		String courtBondAmountTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_BOND_AMOUNT);
		String courtBondAmountValue = (bondInfo != null) ? ALOCPDFReportHelper.formatCurrency(bondInfo.getCourtBondAmt()):null;
		courtBondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(courtBondAmountTitle, courtBondAmountValue));
		String usdCourtBondAmountTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_USD_BOND_AMOUNT);
		String usdCourtBondAmountValue = (bondInfo != null) ? ALOCPDFReportHelper.formatCurrency(bondInfo.getUSDCourtBondAmt()):null;
		courtBondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(usdCourtBondAmountTitle, usdCourtBondAmountValue));
		String effsctiveDateTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_EFFECTIVE_DATE);
		String effsctiveDateValue = (bondInfo != null) ? ALOCPDFReportHelper.formatDate(bondInfo.getEffectiveDate()): null;
		courtBondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(effsctiveDateTitle, effsctiveDateValue));
		String needByDateTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_NEED_BY_DATE);
		String needByDateValue = (bondInfo != null) ? ALOCPDFReportHelper.formatDate(bondInfo.getNeedByDt()): null;
		courtBondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(needByDateTitle, needByDateValue));
		String expiryDateTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_EXPIRATION_DATE);
		String expireDateValue = (bondInfo != null) ? ALOCPDFReportHelper.formatDate(bondInfo.getExpirationDt()): null;
		courtBondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(expiryDateTitle, expireDateValue));
		String otherInfoTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_OTHER_INFORMATION);
		String otherInfoValue = (bondInfo != null) ? bondInfo.getOtherInfo(): null;
		courtBondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(otherInfoTitle, otherInfoValue));

		section.add(courtBondInformationTable);
		return this;
	}

	/**
	 * This is append Attorney Information details section of Surety Bond request
	 * @return
	 */
	public SuretyBondBuilder appendAttorneyInformation() throws DocumentException {

		BondInfo bondInfo = requestDetails.getBondInfo();
		String attorneyInformationTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_ATTORNEY_INFORMATION);
		Section section = ALOCPDFStyle.createSection(attorneyInformationTitle, reportContext.getCurrentChapter());
		PdfPTable attorneyInformationTable = ALOCPDFStyle.createSectionDataTable();

		String lawFirmNameTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_LAW_FIRM_NAME);
		String lawFirmNameValue = (bondInfo != null) ? bondInfo.getLawFirmName(): null;
		attorneyInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(lawFirmNameTitle, lawFirmNameValue));
		String attorneyNameTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_ATTORNEY_NAME);
		String attorneyNameValue = (bondInfo != null) ? bondInfo.getAttorneyName(): null;
		attorneyInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(attorneyNameTitle, attorneyNameValue));
		String attorneyAddress1Title = ALOCPDFReportHelper.getResourceValue(RES_KEY_ATTORNEY_ADDRESS1);
		String attorneyAddress1Value = (bondInfo != null) ? bondInfo.getAttorneyAddress1(): null;
		attorneyInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(attorneyAddress1Title, attorneyAddress1Value));
		String attorneyAddress2Title = ALOCPDFReportHelper.getResourceValue(RES_KEY_ATTORNEY_ADDRESS2);
		String attorneyAddress2Value = (bondInfo != null) ? bondInfo.getAttorneyAddress2(): null;
		attorneyInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(attorneyAddress2Title, attorneyAddress2Value));
		String attorneyCityTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_ATTORNEY_CITY);
		String attorneyCityValue = (bondInfo != null) ? bondInfo.getAttorneyCity(): null;
		attorneyInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(attorneyCityTitle, attorneyCityValue));
		String attorneyStateTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_ATTORNEY_STATE_PROVINCE);
		String attorneyStateValue = (bondInfo != null) ? bondInfo.getAttorneyState(): null;
		attorneyInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(attorneyStateTitle, attorneyStateValue));
		String attorneyCountryTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_ATTORNEY_COUNTRY);
		String attorneyCountryValue = (bondInfo != null) ? bondInfo.getAttorneyCountry(): null;
		attorneyInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(attorneyCountryTitle, attorneyCountryValue));
		String attorneyZipCodeTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_ATTORNEY_ZIP_CODE);
		String attorneyZipCodeValue = (bondInfo != null) ? bondInfo.getAttorneyZIPCode(): null;
		attorneyInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(attorneyZipCodeTitle, attorneyZipCodeValue));
		String attorneyPhoneNumberTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_ATTORNEY_PHONE_NUMBER);
		String attorneyPhoneNumberValue = (bondInfo != null) ? bondInfo.getAttorneyPhoneNum(): null;
		attorneyInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(attorneyPhoneNumberTitle, attorneyPhoneNumberValue));
		String attorneyFaxNumberTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_ATTORNEY_FAX_NUMBER);
		String attorneyFaxNumberValue = (bondInfo != null) ? bondInfo.getAttorneyFaxNum(): null;
		attorneyInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(attorneyFaxNumberTitle, attorneyFaxNumberValue));
		String attorneyEmailTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_ATTORNEY_EMAIL);
		String attorneyEmailValue = (bondInfo != null) ? bondInfo.getAttorneyEmail(): null;
		attorneyInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(attorneyEmailTitle, attorneyEmailValue));

		section.add(attorneyInformationTable);
		return this;
	}

	/**
	 * This is append Customs Bond Information details section of Surety Bond request
	 * @return
	 */
	public SuretyBondBuilder appendCustomsBondInformation() throws DocumentException {

		BondInfo bondInfo = requestDetails.getBondInfo();
		String customsBondInformationTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_BOND_INFORMATION);
		Section section = ALOCPDFStyle.createSection(customsBondInformationTitle, reportContext.getCurrentChapter());
		PdfPTable customsBondInformationTable = ALOCPDFStyle.createSectionDataTable();

		String countryOfIssuanceTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_COUNTRY_OF_ISSUANCE);
		String countryOfIssuanceValue = (bondInfo != null) ? bondInfo.getIssuanceCountryName(): null;
		customsBondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(countryOfIssuanceTitle, countryOfIssuanceValue));
		String exactProjDescTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_PROJECT_DESCRIPTION);
		String exactProjDescValue = (bondInfo != null) ? bondInfo.getExactProjDesc(): null;
		customsBondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(exactProjDescTitle, exactProjDescValue));
		String importerTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_IMPORTER);
		String importerValue = (bondInfo != null) ? ((bondInfo.getImporterNum() != null) ? bondInfo.getImporterNum().toString(): null): null;
		customsBondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(importerTitle, importerValue));
		String activityCodeTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_ACTIVITY_CODE);
		String activityCodeValue = (bondInfo != null) ? bondInfo.getActivityCd(): null;
		customsBondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(activityCodeTitle, activityCodeValue));
		String currencyCodeTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_CURRENCY_CODE);
		String currencyCodeValue = (bondInfo != null) ? bondInfo.getCurrencyName(): null;
		customsBondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(currencyCodeTitle, currencyCodeValue));
		String bondAmountTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_BOND_AMOUNT);
		String bondAmountValue = (bondInfo != null) ? ALOCPDFReportHelper.formatCurrency(bondInfo.getBondAmount()):null;
		customsBondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(bondAmountTitle, bondAmountValue));
		String usdBondAmountTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_USD_BOND_AMOUNT);
		String usdBondAmountValue = (bondInfo != null) ? ALOCPDFReportHelper.formatCurrency(bondInfo.getUSEquivalentBondAmt()): null;
		customsBondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(usdBondAmountTitle, usdBondAmountValue));
		String effectiveDateTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_DESIRED_EFFECTIVE_DATE);
		String effectiveDateValue = (bondInfo != null) ? ALOCPDFReportHelper.formatDate(bondInfo.getEffectiveDt()): null;
		customsBondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(effectiveDateTitle, effectiveDateValue));
		String expiryDateTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_DESIRED_EXPIRATION_DATE);
		String expireDateValue = (bondInfo != null) ? ALOCPDFReportHelper.formatDate(bondInfo.getExpirationDt()): null;
		customsBondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(expiryDateTitle, expireDateValue));
		String stateObligationTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_STATEOFOBLIGATION);
		String stateObligationValue = (bondInfo != null) ? bondInfo.getObligationCountryOrState(): null;
		customsBondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(stateObligationTitle, stateObligationValue));
		String needByDateTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_NEED_BY_DATE);
		String needByDateValue = (bondInfo != null) ? ALOCPDFReportHelper.formatDate(bondInfo.getNeedByDt()): null;
		customsBondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(needByDateTitle, needByDateValue));
		String otherInfoTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_OTHER_INFORMATION);
		String otherInfoValue = (bondInfo != null) ? bondInfo.getOtherInfo(): null;
		customsBondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(otherInfoTitle, otherInfoValue));

		section.add(customsBondInformationTable);
		return this;
	}

	/**
	 * This is append License/Permit Bond Information details section of Surety Bond request
	 * @return
	 */
	public SuretyBondBuilder appendLicenseBondInformation() throws DocumentException {

		BondInfo bondInfo = requestDetails.getBondInfo();
		String licenseBondInformationTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_BOND_INFORMATION);
		Section section = ALOCPDFStyle.createSection(licenseBondInformationTitle, reportContext.getCurrentChapter());
		PdfPTable licenseBondInformationTable = ALOCPDFStyle.createSectionDataTable();

		String countryOfIssuanceTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_COUNTRY_OF_ISSUANCE);
		String countryOfIssuanceValue = (bondInfo != null) ? bondInfo.getIssuanceCountryName(): null;
		licenseBondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(countryOfIssuanceTitle, countryOfIssuanceValue));
		String exactProjDescTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_PROJECT_DESCRIPTION);
		String exactProjDescValue = (bondInfo != null) ? bondInfo.getExactProjDesc(): null;
		licenseBondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(exactProjDescTitle, exactProjDescValue));
		String currencyCodeTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_CURRENCY_CODE);
		String currencyCodeValue = (bondInfo != null) ? bondInfo.getCurrencyName(): null;
		licenseBondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(currencyCodeTitle, currencyCodeValue));
		String bondAmountTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_BOND_AMOUNT);
		String bondAmountValue = (bondInfo != null) ? ALOCPDFReportHelper.formatCurrency(bondInfo.getBondAmount()):null;
		licenseBondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(bondAmountTitle, bondAmountValue));
		String usdBondAmountTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_USD_BOND_AMOUNT);
		String usdBondAmountValue = (bondInfo != null) ? ALOCPDFReportHelper.formatCurrency(bondInfo.getUSEquivalentBondAmt()): null;
		licenseBondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(usdBondAmountTitle, usdBondAmountValue));
		String effectiveDateTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_EFFECTIVE_DATE);
		String effectiveDateValue = (bondInfo != null) ? ALOCPDFReportHelper.formatDate(bondInfo.getEffectiveDt()): null;
		licenseBondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(effectiveDateTitle, effectiveDateValue));
		String expiryDateTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_EXPIRATION_DATE);
		String expireDateValue = (bondInfo != null) ? ALOCPDFReportHelper.formatDate(bondInfo.getExpirationDt()): null;
		licenseBondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(expiryDateTitle, expireDateValue));
		String stateObligationTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_COUNTRY_OBLIGATION);
		String stateObligationValue = (bondInfo != null) ? bondInfo.getObligationCountryOrState(): null;
		licenseBondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(stateObligationTitle, stateObligationValue));
		String needByDateTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_NEED_BY_DATE);
		String needByDateValue = (bondInfo != null) ? ALOCPDFReportHelper.formatDate(bondInfo.getNeedByDt()): null;
		licenseBondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(needByDateTitle, needByDateValue));
		String otherInfoTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_OTHER_INFORMATION);
		String otherInfoValue = (bondInfo != null) ? bondInfo.getOtherInfo(): null;
		licenseBondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(otherInfoTitle, otherInfoValue));
		String bondFormTypeTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_TYPE_OF_BOND_FORM);
		String bondFormTypeValue = (bondInfo != null) ? bondInfo.getBondFormType(): null;
		licenseBondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(bondFormTypeTitle, bondFormTypeValue));

		section.add(licenseBondInformationTable);
		return this;
	}
	
}
