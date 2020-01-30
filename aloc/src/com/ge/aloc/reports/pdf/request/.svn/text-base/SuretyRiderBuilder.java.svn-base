/*
 * Copyright © 2013 GE. ALL RIGHTS RESERVED.
 * FileName: SuretyRiderBuilder.java
 * Purpose: This class renders SuretyRider Page of the PDF report.
 */
package com.ge.aloc.reports.pdf.request;

import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_ADDRESS1;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_AMOUNT_INCREASE_DECREASE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_BOND_INFORMATION;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_CITY;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_COMPANYNAME;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_COUNTRY;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_CURRENT_BONDAMOUNT;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_DELIVERY_INSTRUCTIONS;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_DELIVER_TYPE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_EXPECT_BONDAMOUNT;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_EXPIRATIONDATE_TITLE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_FALSE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_GERECIPIENT;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_GERECIPIENT_EMAIL;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_INCREASE_DECREASE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_INPERSON_PICKUP;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_LEGAL_ENTITY_GOLDID;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_LEGAL_ENTITY_NAME;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_NAME_AND_ADDRESS;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_OBLIGEE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_ORIGINALEXPDATE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_ORIGINAL_BONDAMOUNT;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_ORIGINAL_CONTRACTAMOUNT;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_PHONE_ADDRESS2_OPTIONAL;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_PHONE_NUMBER;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_PHYSICAL_DELIVERY;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_PRINCIPAL;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_RECIPIENT_FIRSTNAME;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_RECIPIENT_LASTNAME;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_REVISEDEXPDATE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_REVISED_AMOUNT;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_REVISED_USDAMOUNT;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_SEND_ELECTRONIC_COPYTOMYSELF;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_SEND_ELECTRONIC_COPYTO_GERECIPIENT;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_SPECIAL_INSTRUCTIONS;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_STATE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_TITLE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_TRUE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_USE_PREVIOUS_ADDRESS;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_YES_CAP;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_ZIPCODE;
import static com.ge.aloc.reports.pdf.request.RequestPDFConstants.RES_KEY_SB_NAME_AND_ADDRESS;

import java.math.BigInteger;

import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.model.AddressDtls;
import com.ge.aloc.model.DeliveryInstructions;
import com.ge.aloc.model.ExpiryDate;
import com.ge.aloc.model.Obligee;
import com.ge.aloc.model.Principal;
import com.ge.aloc.model.RequestDetails;
import com.ge.aloc.model.Rider;
import com.ge.aloc.model.RiderBondInformation;
import com.ge.aloc.reports.pdf.ALOCPDFReportHelper;
import com.ge.aloc.reports.pdf.ALOCPDFStyle;
import com.ge.aloc.reports.pdf.ReportContext;
import com.hydus.hwf.util.StringUtils;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPTable;

/**
 * This class provides logic to render SuretyRider page of the report.
 * 
 * @author narasimhulu.b
 */
public class SuretyRiderBuilder {

	private final ReportContext reportContext;
	private final RequestDetails requestDetails;

	/**
	 * Constructor to instantiate the object.
	 * 
	 * @param context
	 */
	public SuretyRiderBuilder(ReportContext context) {
		this.reportContext = context;
		this.requestDetails = context.getRequestDetails();
	}


	/**
	 * This is append principal details section of Surety Rider request
	 * @return
	 */
	public SuretyRiderBuilder appendSuretyRiderPrincipal() throws DocumentException {
		
		Rider rider = requestDetails.getRider();
		Principal riderPrincipal = (rider!=null) ? rider.getPrincipal() : null;
		AddressDtls addressDtls= (riderPrincipal!=null) ? riderPrincipal.getAddressDtls() : null;

		String principalTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_PRINCIPAL);
		Section section = ALOCPDFStyle.createSection(principalTitle, reportContext.getCurrentChapter());

		PdfPTable principalTable = ALOCPDFStyle.createSectionDataTable();

		String legalGoldIdTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_LEGAL_ENTITY_GOLDID);
		String riderGoldIdValue = (riderPrincipal != null) ? riderPrincipal.getLeGoldId() : null;
		principalTable.addCell(ALOCPDFStyle.createSectionDataCell(legalGoldIdTitle, riderGoldIdValue));
		String legalEntityNameTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_LEGAL_ENTITY_NAME);
		String riderEntityNameValue = (riderPrincipal != null) ? riderPrincipal.getLeName() : null;
		principalTable.addCell(ALOCPDFStyle.createSectionDataCell(legalEntityNameTitle, riderEntityNameValue));
		String nameandAddressTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_SB_NAME_AND_ADDRESS);
		if (addressDtls != null) {
			String address1 = null;
			String address2 = null;
			int zero = ALOCConstants.NUM_ZERO;
			int one = ALOCConstants.NUM_ONE;
			if (addressDtls.getAddress().size() > zero && addressDtls.getAddress().get(zero) !=null) {
				address1 = addressDtls.getAddress().get(zero);
			}
			if (addressDtls.getAddress().size() > one && addressDtls.getAddress().get(one) != null) {
				address2 = addressDtls.getAddress().get(one);
			}
			String stateOfInc = ALOCConstants.EMPTY_STRING;
			if(StringUtils.isNotBlank(addressDtls.getCountryCd()) && addressDtls.getCountryCd().equalsIgnoreCase(ALOCConstants.US)){
				stateOfInc = addressDtls.getStateOfInc();
			}
			String[] addressValues = { addressDtls.getName(), address1,address2, addressDtls.getCity(),
					addressDtls.getStateProvince(),addressDtls.getZIPPostalCode(), addressDtls.getCountry(),
					stateOfInc };
			principalTable.addCell(ALOCPDFStyle.createSectionDataCell(nameandAddressTitle, addressValues));
		}
		
		section.add(principalTable);
		return this;	
	}

	/**
	 * This is append Obligee details section of Surety Rider request
	 * @return
	 */
	public SuretyRiderBuilder appendSuretyRiderObligee() throws DocumentException {
		Rider rider = requestDetails.getRider();
		Obligee riderObligee = (rider!=null) ? rider.getObligee() : null;
		AddressDtls addressDtls = (riderObligee!=null) ? riderObligee.getAddressDtls() : null;
		
		String obligeeDetailsTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_OBLIGEE);			
		Section section = ALOCPDFStyle.createSection(obligeeDetailsTitle, reportContext.getCurrentChapter());

		PdfPTable obligeeDetailsTable = ALOCPDFStyle.createSectionDataTable();

		String nameandAddressTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_NAME_AND_ADDRESS);
		String[] addressValues = ALOCPDFReportHelper.convertAddressAsString(addressDtls);
		obligeeDetailsTable.addCell(ALOCPDFStyle.createSectionDataCell(nameandAddressTitle, addressValues));
		
		section.add(obligeeDetailsTable);
		return this;	
	}


	/**
	 * This method is used to append Expiration Date section for Surety Rider request
	 * @return
	 */
	public SuretyRiderBuilder appendRiderExpirationDate() throws DocumentException {

		String expirationDateTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_EXPIRATIONDATE_TITLE);
		Section section = ALOCPDFStyle.createSection(expirationDateTitle, reportContext.getCurrentChapter());
		
		ExpiryDate expiyDate = (requestDetails.getRider() != null) ? requestDetails.getRider().getExpiryDate() : null;
		ExpiryDate originalExpiyDate = (requestDetails.getPreviousRider() != null) ? requestDetails.getPreviousRider().getExpiryDate() : null;
		
		PdfPTable expirationDateTable = ALOCPDFStyle.createMultiSectionDataTable();
		String revisedExpDateTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_REVISEDEXPDATE);
		String revisedExpDateValue = (expiyDate != null) ? ALOCPDFReportHelper.formatDate(expiyDate.getRevisedExpiryDate()) : null;
		expirationDateTable.addCell(ALOCPDFStyle.createSectionDataCell(revisedExpDateTitle, revisedExpDateValue));
		String originalExpDateTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_ORIGINALEXPDATE);
		String originalExpDate = null;
		if(originalExpiyDate != null && originalExpiyDate.getRevisedExpiryDate() != null){
			originalExpDate = (originalExpiyDate != null) ? ALOCPDFReportHelper.formatDate(originalExpiyDate.getRevisedExpiryDate()) : null;
		}else{
			originalExpDate = (expiyDate != null) ? ALOCPDFReportHelper.formatDate(expiyDate.getCurrentExpiryDate()) : null;
		}
		expirationDateTable.addCell(ALOCPDFStyle.createSectionDataCell(originalExpDateTitle, originalExpDate));

		section.add(expirationDateTable);
		return this;
	}

	/**
	 * This method is used to append Bond Information section for Surety Rider request
	 * @return
	 */
	public SuretyRiderBuilder appendRiderBondInfo() throws DocumentException {
		RiderBondInformation riderBondInfo = (requestDetails.getRider() != null) ? requestDetails.getRider().getRiderBondInformation() : null;
		String bondInformationTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_BOND_INFORMATION);
		Section section = ALOCPDFStyle.createSection(bondInformationTitle, reportContext.getCurrentChapter());
		PdfPTable bondInformationTable = ALOCPDFStyle.createSectionDataTable();

		String originalBondAmtTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_ORIGINAL_BONDAMOUNT);
		String originalBondAmtValue = (riderBondInfo != null) ? ALOCPDFReportHelper.formatCurrency(riderBondInfo.getOriginalBondAmt()) : null;
		bondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(originalBondAmtTitle, originalBondAmtValue));

		String currentBondAmtTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_CURRENT_BONDAMOUNT);
		String currentBondAmtValue = (riderBondInfo != null) ? ALOCPDFReportHelper.formatCurrency(riderBondInfo.getCurrentBondAmt()) : null;
		bondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(currentBondAmtTitle, currentBondAmtValue));

		String incDecTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_INCREASE_DECREASE);
		String incDecValue = (riderBondInfo != null) ? riderBondInfo.getOperation() : null;
		bondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(incDecTitle, incDecValue));

		String amtIncDecTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_AMOUNT_INCREASE_DECREASE);
		String amtIncDecValue = (riderBondInfo != null) ? ALOCPDFReportHelper.formatCurrency(riderBondInfo.getAmtOfIncreaseOrDecrease()) : null;
		bondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(amtIncDecTitle, amtIncDecValue));
		
		String expectBondAmtTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_EXPECT_BONDAMOUNT);
		String expectBondAmtValue = (riderBondInfo != null) ? ALOCPDFReportHelper.formatCurrency(riderBondInfo.getRevisedBondAmt()) : null;
		bondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(expectBondAmtTitle, expectBondAmtValue));
		
		BigInteger bondTypeId = (requestDetails.getBondDetails() != null) ?  requestDetails.getBondDetails().getBondTypeId() : null;
		if(bondTypeId != null && bondTypeId.equals(BigInteger.valueOf(ALOCConstants.CONTRACTBOND_ID))){
			String contractAmtTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_ORIGINAL_CONTRACTAMOUNT);
			String contractAmtValue = (riderBondInfo != null) ? ALOCPDFReportHelper.formatCurrency(riderBondInfo.getOriginalContractAmt()) : null;
			bondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(contractAmtTitle, contractAmtValue));

			String revisedAmtTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_REVISED_AMOUNT);
			String revisedAmtValue = (riderBondInfo != null) ? ALOCPDFReportHelper.formatCurrency(riderBondInfo.getRevisedContractAmt()): null;
			bondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(revisedAmtTitle, revisedAmtValue));

			String usdContractAmtTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_REVISED_USDAMOUNT);
			String usdContractAmtValue = (riderBondInfo != null) ? ALOCPDFReportHelper.formatCurrency(riderBondInfo.getRevisedUSDEquiContractAmt()) : null;
			bondInformationTable.addCell(ALOCPDFStyle.createSectionDataCell(usdContractAmtTitle, usdContractAmtValue));
		}
		section.add(bondInformationTable);
		return this;

	}

	/**
	 * This method is used to append Delivery Instructions section for Surety Rider request
	 * @return
	 */
	public SuretyRiderBuilder appendRiderDeliveryInstructions() throws DocumentException {

		DeliveryInstructions deliveryInstructions = requestDetails.getRider().getDeliveryInstructions();
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
		deliveryInstructionsTable = fillDeliveryAddress(deliveryInstructions,deliverType,deliveryInstructionsTable);
		String phoneTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_PHONE_NUMBER);
		String phoneNumValue = (deliveryInstructions != null) ? deliveryInstructions.getPhoneNo(): null;
		deliveryInstructionsTable.addCell(ALOCPDFStyle.createSectionDataCell(phoneTitle, phoneNumValue));
		String specialInstTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_SPECIAL_INSTRUCTIONS);
		String specialInstValue = (deliveryInstructions != null) ? deliveryInstructions.getSpecialInstructions(): null;
		deliveryInstructionsTable.addCell(ALOCPDFStyle.createSectionDataCell(specialInstTitle, specialInstValue));
		
		String sendElecTitle = ALOCPDFReportHelper.getResourceValue(RES_KEY_SEND_ELECTRONIC_COPYTOMYSELF);
		String sendEcopyMyselfValue = (deliveryInstructions != null) ? ALOCPDFReportHelper.convertStringAsYesOrNo(deliveryInstructions.getEcopyMyself()) : null;
		deliveryInstructionsTable.addCell(ALOCPDFStyle.createSectionDataCell(sendElecTitle, sendEcopyMyselfValue));

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
				if(StringUtils.isNotBlank(deliveryInstructions.getRecipient().getRecipientSsoId())) {
					fullName.append(ALOCConstants.EMPTYSPACE_HYPEN_EMPTYSPACE + deliveryInstructions.getRecipient().getRecipientSsoId());
				}
			}
			deliveryInstructionsTable.addCell(ALOCPDFStyle.createSectionDataCell(geRecipientTitle, fullName.toString()));
			deliveryInstructionsTable.addCell(ALOCPDFStyle.createSectionDataCell(geRecipientEmailTitle, deliveryInstructions.getRecipient().getRecipientEmail()));
		}
		section.add(deliveryInstructionsTable);
		return this;
	}

	/**
	 * fillDeliveryAdress to fill Delivery Address of Delivery Instructions
	 * @param deliveryInstructions
	 * @param deliverType
	 * @param deliveryInstructionsTable
	 * @return deliveryInstructionsTable
	 */
	private PdfPTable fillDeliveryAddress(DeliveryInstructions deliveryInstructions,String deliverType,PdfPTable deliveryInstructionsTable) {
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

		if (deliverType != null && deliverType.equals(ALOCPDFReportHelper.getResourceValue(RES_KEY_FALSE))) {
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

}
