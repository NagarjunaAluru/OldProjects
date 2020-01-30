/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: RequestSectionId.java
 * Purpose: RequestSectionId used for the section id details.
 */
package com.ge.aloc.view.section;

/**
 * 
 * @author madhusudhan.gosula
 *
 */
public enum RequestSectionId implements SectionId {

	TRANSACTION_PARTIES("request.section.transactionParties"),
	PROJECT_DESCRIPTION("request.section.projectDescription"),
	INSTRUMENT_DETAILS("request.section.instrumentDetails"),
	INSTRUMENT_RISK("request.section.instrumentRisk"),
	STANDBY_LETTER_OF_CREDIT_CONDITIONS("request.section.standbyLetterofCredit"),
	INSTRUMENT_REPORTING_ATTRIBUTES("request.section.instrumentReporting"),
	FORMAT("request.section.format"),
	DELIVERY_INSTRUTIONS("request.section.deliveryInstructions"),
	ATTACHMENTS("request.section.attachments"),

	BOND_DETAILS("request.section.bondDetails"),
	PRINCIPAL("request.section.principal"),
	BILLING_INFORMATION("request.section.billingInformation"),
	OBLIGEE("request.section.obligee"),
	BOND_REQUESTOR("request.section.bondRequestor"),
	REQUESTOR_MAILING_ADDRESS("request.section.requestorMailingAddress"),
	BOND_INFORMATION("request.section.bondInformation"),
	ATTORNEY_BOND_INFORMATION("request.section.attorneyBondInformation"),
	BUSINESS_DELEGATION("request.section.businessDelegation"),
	BUSINESS_CONTACT_PERSON("request.section.businessContactPerson"),
	ISSUING_BANK("request.section.issuingBank"),
	APPLICANT("request.section.applicant"),
	BENEFICIARY("request.section.beneficiary"),
	INSTRUMENT_TRANSACTION_DETAILS("request.section.instrumentTransactionDetails"),
	PAYMENT_SCHEDULE("request.section.paymentSchedule"),
	TREASURY_DELEGATION("request.section.treasuryDelegation"),
	TRIPARTYFLAG("request.section.tripartyFlag"),
	TPAPPLICANT("request.section.tpapplicant"),
	TRIPARTY_ADDRESS("request.section.tripartyAddress"),
	TPCUSTOMER_BENEFICIARY("request.section.tpCustomerbeneficiary"),

	//Bid sections
	BID_DETAILS("request.section.bidDetails"),
	BID_MEMO_DETAILS("request.section.bidMemoDetails"),
	ADDITIONAL_INSTRUMENT_DETAILS("request.section.additionalInstrumentDetails"),
	BANK_SELECTION("request.section.bankSelection"),
	BID_REPLY("request.section.bidReplyDetails"),
	ISSUING_BRANCH("request.section.issuingBankBranch"),
	PRICING_DETAILS("request.section.pricingDetails"),
	PRE_AGREED_PRICING_DETAILS("request.section.preAgreedPricingDetails"),

	//Amendment Sections
	AMENDMENT_TRANSACTION_PARTIES("request.section.amendmentTransactionParties"),
	INSTRUMENT_AMOUNT_CURRENCY("request.section.instrumentAmountCurrency"),
	EXPIRATION_DATES("request.section.expirationDates"),
	OTHER_CHANGES("request.section.otherChanges"),

	//Surety Rider section
	RIDER_PRINCIPAL("request.section.riderPrincipal"),
	RIDER_OBLIGEE("request.section.riderObligee"),
	RIDER_EXPIRATION_DATES("request.section.riderExpirationDates"),
	RIDER_BOND_INFORMATION("request.section.riderBondInformation"),
	RIDER_DELIVERY_INSTRUTIONS("request.section.riderDeliveryInstructions");
	/**
	 * This method is used to get request section Id based on key
	 * @param key
	 * @return
	 */
	public static RequestSectionId fromString(String key) {
		for(RequestSectionId requestSectionId : values()) {
			if(requestSectionId.key.equals(key)) {
				return requestSectionId;
			}
		}
		return null;
	}

	private String key;
	/**
	 * default constructor
	 * @param id
	 */
	private RequestSectionId(String id) {
		this.key = id;
	}
	/**
	 * This is used to get key as string
	 */
	public String getAsString() {
		return this.key;
	}
}
