/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ReplaceBookmarksWithContentHelper.java
 * Purpose: ReplaceBookmarksWithContentHelper utility class used for all the bookmark replacement functionality.
 */
package com.ge.aloc.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import com.ge.aloc.InstrumentType;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.model.AddressDtls;
import com.ge.aloc.model.BondInfo;
import com.ge.aloc.model.Customer;
import com.ge.aloc.model.InstrumentDetails;
import com.ge.aloc.model.Obligee;
import com.ge.aloc.model.Principal;
import com.ge.aloc.model.RefDetails;
import com.ge.aloc.model.RequestDetails;
import com.ge.aloc.model.TransactionParties;

/**
 * @author rajeswari.guthi
 *
 */
public class BookmarksHelper {

	private static final Pattern PATTERN =  Pattern.compile("\\&lt;(\\w*(?:\\s*\\w*-?\\w*\\s*\\(?\\w?\\)?)*)\\&gt;");
	
	private final Map<String, String> replacements;
	private final String formatContent;
	
	/**
	 * Constructor
	 * @param requestDetails
	 * @param formatContent
	 */
	public BookmarksHelper(RequestDetails requestDetails, String formatContent) {
		this.replacements = getReplacementValues(requestDetails);
		this.formatContent = formatContent;
	}
	
	/**
	 * This method is used to replace tokens.
	 * @return
	 */
	public String replaceTokens() {
		Matcher matcher = null;
		if(StringUtils.isNotBlank(formatContent)){
		 matcher = PATTERN.matcher(formatContent);
		}else{
		 matcher = PATTERN.matcher(ALOCConstants.EMPTY_SPACE_STRING);
		}
		StringBuffer buffer = new StringBuffer();
		while (matcher.find()) {
			String replacement = replacements.get(matcher.group(ALOCConstants.MATCHER_GROUP_VAL));
			if (replacement != null) {
				matcher.appendReplacement(buffer, ALOCConstants.EMPTY_STRING);
				buffer.append(replacement);
			}
		}
		matcher.appendTail(buffer);
		return buffer.toString();
	}
	
	
	/**
	 *  This method is used to get replacement values 
	 * @param requestDetails
	 * @return
	 */
	private Map<String, String> getReplacementValues(RequestDetails requestDetails) {
		String hypen = (String) ALOCConstants.HYPEN;
		SimpleDateFormat formatter = new SimpleDateFormat(ALOCConstants.FORMAT_INV_PATTERN);
		TransactionParties transactionParties = requestDetails.getTransactionParties();
		InstrumentDetails instrumentDetails = requestDetails.getInstrumentDetails();
		AddressDtls beneficiaryAddr = getCustomerBeneficiaryDetails(requestDetails);
		AddressDtls applicantAddr = getApplicantDetails(requestDetails);
		Principal principal = requestDetails.getPrincipal();
		AddressDtls principalAddr = (principal != null) ? principal.getAddressDtls() : null;
		String principalName = principalAddr != null ? principalAddr.getName() : null;
		Obligee obligee = requestDetails.getObligee();
		AddressDtls obligeeAddr = (obligee != null) ? obligee.getAddressDtls() : null;
		String obligeeName = obligeeAddr != null ? obligeeAddr.getName() : null;
		List<RefDetails> refDetails = (principal != null)? principal.getRefDetails(): null; 
		BondInfo bondInfo = requestDetails.getBondInfo()!=null ? requestDetails.getBondInfo():null;			
		Calendar issuedt = (instrumentDetails != null) ? instrumentDetails.getIssueDt() : null;		
		Calendar expirydt = (instrumentDetails != null) ? instrumentDetails.getExpiryDt() : null;
		String proposalNo = requestDetails.getProjDescription() != null ? requestDetails.getProjDescription().getBidProposalNo() : null;
		String contractNo = requestDetails.getProjDescription() != null ? requestDetails.getProjDescription().getContractNo():null;
		String bondType = requestDetails.getBondDetails() != null ? requestDetails.getBondDetails().getBondType() : null;
		String bondSubType = requestDetails.getBondDetails() != null ? requestDetails.getBondDetails().getBondSubType() : null;
		String exactProDesc = requestDetails.getBondInfo() != null ? requestDetails.getBondInfo().getExactProjDesc() : null;
		String contractCurrCode = requestDetails.getBondInfo() != null ? requestDetails.getBondInfo().getContractCurCd() : null;
		String instrumentPurpose = transactionParties != null ? transactionParties.getInstrumentPurpose() : null;
		
		Map<String, String> replacementValues = new HashMap<String, String>();
		
		replacementValues.put(ALOCConstants.INSTRUMENT_TYPE, requestDetails.getInstrumentType());
		replacementValues.put(ALOCConstants.INSTRUMENT_PURPOSE, (instrumentPurpose != null) ? instrumentPurpose:hypen);
		replacementValues.put(ALOCConstants.ALOC_RECORDNUMBER, (requestDetails.getAlocRecordId()!= null) ? requestDetails.getAlocRecordId() : hypen);
		replacementValues.put(ALOCConstants.ISSUE_DATE, issuedt != null ? formatter.format(issuedt.getTime()) : hypen );		 
		replacementValues.put(ALOCConstants.EXPIRATION_DATE, expirydt != null ? formatter.format(expirydt.getTime()) : hypen);
		
		replacementValues.put(ALOCConstants.BENEFICIARY_NAME, beneficiaryAddr != null? beneficiaryAddr.getName() : hypen);
		replacementValues.put(ALOCConstants.BENEFICIARY_ADDRESS, beneficiaryAddr != null? getAddressDetals(beneficiaryAddr) : hypen);
		
		replacementValues.put(ALOCConstants.APPLICANT_NAME, applicantAddr !=null ? applicantAddr.getName(): hypen);
		replacementValues.put(ALOCConstants.APPLICANT_ADDRESS, applicantAddr != null? getAddressDetals(applicantAddr) : hypen);
		
		replacementValues.put(ALOCConstants.INSTRUMENT_AMOUNT_INWORDS, instrumentDetails != null ? (instrumentDetails.getInstrumentAmt()!=null ? getAmountInWords(String.valueOf(instrumentDetails.getInstrumentAmt())) : hypen): hypen);
		replacementValues.put(ALOCConstants.INSTRUMENT_AMOUNT, instrumentDetails.getInstrumentAmt()!=null ? getFormattedAmount(instrumentDetails.getInstrumentAmt()): hypen);
		replacementValues.put(ALOCConstants.BID_NUMBER, requestDetails.getBidProcessDetails()!= null ? requestDetails.getBidProcessDetails().getBidReplyId() : hypen);
		replacementValues.put(ALOCConstants.PROJECT_DESCRIPTION, getProjectDescription(requestDetails)!= null ? getProjectDescription(requestDetails) : hypen);
		replacementValues.put(ALOCConstants.PRAPOSAL_NUMBER, StringUtils.isNotBlank(proposalNo) ? String.valueOf(proposalNo) : hypen);
	
		replacementValues.put(ALOCConstants.CONTRACT_NUMBER, contractNo != null ? contractNo : hypen);
		replacementValues.put(ALOCConstants.CONTRACT_DATE, getContractDate(requestDetails)!=null?getContractDate(requestDetails):hypen);
		replacementValues.put(ALOCConstants.CONTRACT_AMOUNT,getContractAmount(requestDetails)!= null? getFormattedAmount(getContractAmount(requestDetails)):hypen);

		replacementValues.put(ALOCConstants.ADVANCE_PAYMENT_AMOUNT, getContractAmount(requestDetails)!= null ? getFormattedAmount(getContractAmount(requestDetails)): hypen);			 
		replacementValues.put(ALOCConstants.RETENSION_PAYMENT_AMOUNT, instrumentDetails != null ?  (String.valueOf(instrumentDetails.getInstrumentAmt())) : hypen);
		replacementValues.put(ALOCConstants.CURRENCY_CODE, StringUtils.isNotBlank(getCurrencyCode(requestDetails)) ? getCurrencyCode(requestDetails) : hypen);
		
		replacementValues.put(ALOCConstants.BOND_TYPE, bondType != null ?bondType : hypen);
		replacementValues.put(ALOCConstants.BOND_SUBTYPE, bondSubType != null ? bondSubType :hypen);
		replacementValues.put(ALOCConstants.PRINCIPAL_NAME, principalName!= null ? principalName: hypen);
		replacementValues.put(ALOCConstants.PRINCIPAL_ADDRESS, principalAddr!= null ? getAddressDetals(principalAddr) : hypen);			 
		replacementValues.put(ALOCConstants.OBLIGEE_NAME, obligeeName != null ? obligeeName : hypen);
		replacementValues.put(ALOCConstants.OBLIGEE_ADDRESS, obligeeAddr!= null ? getAddressDetals(obligeeAddr) : hypen);
		replacementValues.put(ALOCConstants.EXACT_PROJECT_DESCRIPTION, exactProDesc != null ? exactProDesc : hypen);
		replacementValues.put(ALOCConstants.CONTRACT_CURRENCY_CODE, contractCurrCode !=null ? contractCurrCode: hypen);
		replacementValues.put(ALOCConstants.GE_REFERENCE_ONE, refDetails!= null ? getRefDetals(refDetails) :hypen); 		
		replacementValues.put(ALOCConstants.BID_BOND_AMOUNT, getBondAmount(requestDetails,ALOCConstants.BID)!=null ? getFormattedAmount(getBondAmount(requestDetails,ALOCConstants.BID)): hypen);
		replacementValues.put(ALOCConstants.BID_BOND_CURRENCY_CODE, getBondCurrencyCode(requestDetails,ALOCConstants.BID) != null ? getBondCurrencyCode(requestDetails,ALOCConstants.BID) : hypen);
		replacementValues.put(ALOCConstants.BOND_AMOUNT, getBondAmount(requestDetails,null)!=null ? getFormattedAmount(getBondAmount(requestDetails,null)): hypen);
		replacementValues.put(ALOCConstants.BOND_CURRENCY_CODE, getBondCurrencyCode(requestDetails,null) != null ? getBondCurrencyCode(requestDetails,null) : hypen);
		replacementValues.put(ALOCConstants.BOND_AMOUNT_INWORDS, bondInfo != null ? (getBondAmount(requestDetails,null)!=null ? getFormattedAmount(getBondAmount(requestDetails,null)): hypen):hypen);
		replacementValues.put(ALOCConstants.PERFORMANCE_BOND_AMOUNT, bondInfo != null ? (bondInfo.getPerformanceBondAmt()!=null ? getFormattedAmount(bondInfo.getPerformanceBondAmt()): hypen):hypen);
		replacementValues.put(ALOCConstants.PERFORMANCE_BONDAMOUNT_INWORDS, bondInfo.getPerformanceBondAmt()!=null ? getAmountInWords(String.valueOf(bondInfo.getPerformanceBondAmt())):hypen);
		replacementValues.put(ALOCConstants.ISSUING_BANK, requestDetails.getIssuingBankDetails()!= null ? requestDetails.getIssuingBankDetails().getBankName() :hypen);		
		return replacementValues;
	}
	
	/**
	 * This is used to get the Address details as a string object
	 * @param addressDtls
	 * @return
	 */
	private String getAddressDetals(AddressDtls addressDtls) {
		StringBuilder addressDetails = new StringBuilder();		
		if(addressDtls.getAddress()!=null && addressDtls.getAddress().size() > ALOCConstants.BASE_VALUE){			
			if(addressDtls.getAddress().get(ALOCConstants.MIN_INDEX)!= null)
				addressDetails.append(addressDtls.getAddress().get(ALOCConstants.MIN_INDEX)).append(ALOCConstants.COMMA_SPACE);
			if(addressDtls.getAddress().size() > ALOCConstants.MIN_VALUE && addressDtls.getAddress().get(ALOCConstants.MIN_VALUE)!= null)
				addressDetails.append(addressDtls.getAddress().get(ALOCConstants.MIN_VALUE)).append(ALOCConstants.COMMA_SPACE);				
			if(StringUtils.isNotBlank(addressDtls.getCity()))
				addressDetails.append(addressDtls.getCity()).append(ALOCConstants.COMMA_SPACE);				
			if(StringUtils.isNotBlank(addressDtls.getStateProvince()))
				addressDetails.append(addressDtls.getStateProvince()).append(ALOCConstants.COMMA_SPACE);				
			if(StringUtils.isNotBlank(addressDtls.getZIPPostalCode()))
				addressDetails.append(addressDtls.getZIPPostalCode()).append(ALOCConstants.COMMA_SPACE);				
			if(StringUtils.isNotBlank(addressDtls.getCountry()))
				addressDetails.append(addressDtls.getCountry()).append(ALOCConstants.EMPTY_SPACE_STRING);				
		}
		return addressDetails.toString();
	}
	
	/**
	 * This is used to get the Reference details as a String object
	 * @param refDetails
	 * @return
	 */
	private String getRefDetals(List<RefDetails> refDetails) {
		String refenceDetails = ALOCConstants.EMPTY_STRING;
		if(refDetails!=null){
			for(RefDetails referenceDetails : refDetails) {		//This is changed as we have to show only ref1 not all	
				refenceDetails = referenceDetails.getRefValue();
				break;
			}
		}
		return refenceDetails;
	}
	

	/**
	 * This is used to get the Contract Date  for all instruments
	 * @param requestDetails
	 * @return
	 */
	private String getContractDate(RequestDetails requestDetails) {	
		Calendar contractDate = null;
		if(requestDetails.getInstrumentTypeId().intValue()==InstrumentType.SURETY_BOND.getId())
		{
			contractDate = requestDetails.getBondInfo().getContractDt();
			
		}
		else if(requestDetails.getInstrumentTypeId().intValue()==InstrumentType.BANK_GUARANTEE.getId() || requestDetails.getInstrumentTypeId().intValue()==InstrumentType.LOC.getId())
		{
			contractDate = requestDetails.getProjDescription().getContractDt();
		}
		if(contractDate == null) {
			return null;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(ALOCConstants.DATE_FORMAT);
		return dateFormat.format(contractDate.getTime());		
	}
	
	
	/**
	 * This is used to get the project description for BG/SBLC/DOCLoc
	 * @param requestDetails
	 * @return
	 */
	private String getProjectDescription(RequestDetails requestDetails) {	
		String projDescription = ALOCConstants.EMPTY_STRING;
		if(requestDetails.getInstrumentTypeId().intValue()==InstrumentType.BANK_GUARANTEE.getId() || requestDetails.getInstrumentTypeId().intValue()==InstrumentType.LOC.getId())
		{
			projDescription = requestDetails.getProjDescription().getProjDesc();
		}else if(requestDetails.getInstrumentTypeId().intValue()==InstrumentType.DOCUMENT_LOC.getId()){
			projDescription = requestDetails.getTransactionDetails().getProjectDesc();
		}
		if(projDescription == null) {
			projDescription =  ALOCConstants.EMPTY_STRING;
		}
		
		return projDescription;		
	}
	
	/**
	 * This is used to get the Contract Amount for all instruments
	 * @param requestDetails
	 * @return
	 */
	private String getCurrencyCode(RequestDetails requestDetails) {	
		String bondCurrencyCode =null;
		if(requestDetails.getInstrumentTypeId().intValue()== InstrumentType.SURETY_BOND.getId())
		{
			if(requestDetails.getBondDetails().getBondTypeId().intValue() == InstrumentType.LOC.getId()){				
				bondCurrencyCode = requestDetails.getBondInfo().getContractCurCd();
			}else if(requestDetails.getBondDetails().getBondTypeId().intValue() == InstrumentType.BANK_GUARANTEE.getId()
					|| requestDetails.getBondDetails().getBondTypeId().intValue() == InstrumentType.SURETY_BOND.getId()
					|| requestDetails.getBondDetails().getBondTypeId().intValue() == InstrumentType.AMENDMENT.getId()){
				bondCurrencyCode = requestDetails.getBondInfo().getCurrencyCd();
			}else if(requestDetails.getBondDetails().getBondTypeId().intValue()== InstrumentType.DOCUMENT_LOC.getId())
			{
				bondCurrencyCode = requestDetails.getBondInfo().getBondCurrencyCd();
			}

		}else if(requestDetails.getInstrumentTypeId().intValue()== InstrumentType.BANK_GUARANTEE.getId() ||
				requestDetails.getInstrumentTypeId().intValue()== InstrumentType.LOC.getId())
		{
			bondCurrencyCode = requestDetails.getInstrumentDetails().getInstrumentCurrencyId();
		}else if(requestDetails.getInstrumentTypeId().intValue()==  InstrumentType.BANK_GUARANTEE.getId() ||
				requestDetails.getInstrumentTypeId().intValue()== InstrumentType.DOCUMENT_LOC.getId())
		{
			bondCurrencyCode = requestDetails.getTransactionDetails().getContranctCurId();
		}

		return bondCurrencyCode;

	}
	
	/**
	 * This is used to get the Contract Amount for all instruments
	 * @param requestDetails
	 * @return
	 */
	private BigDecimal getContractAmount(RequestDetails requestDetails) {	
		BigDecimal contractAmount =null;
		if(requestDetails.getInstrumentTypeId().intValue()== InstrumentType.SURETY_BOND.getId())
		{
			if(requestDetails.getBondDetails().getBondTypeId().intValue() == InstrumentType.LOC.getId()){				
				contractAmount = requestDetails.getBondInfo().getContractAmt();
			}else if(requestDetails.getBondDetails().getBondTypeId().intValue() == InstrumentType.BANK_GUARANTEE.getId()
					|| requestDetails.getBondDetails().getBondTypeId().intValue() == InstrumentType.SURETY_BOND.getId()
					|| requestDetails.getBondDetails().getBondTypeId().intValue() == InstrumentType.AMENDMENT.getId())
			{
				contractAmount = requestDetails.getBondInfo().getBondAmount();
			}else if(requestDetails.getBondDetails().getBondTypeId().intValue()== InstrumentType.DOCUMENT_LOC.getId())
			{
				contractAmount = requestDetails.getBondInfo().getCourtBondAmt();
			}
			
		}else if(requestDetails.getInstrumentTypeId().intValue()== InstrumentType.DOCUMENT_LOC.getId()){
			contractAmount = requestDetails.getTransactionDetails().getContranctAmt();
		}		
		else if(requestDetails.getInstrumentTypeId().intValue()== InstrumentType.BANK_GUARANTEE.getId() ||
				requestDetails.getInstrumentTypeId().intValue()== InstrumentType.LOC.getId())
		{			
				contractAmount = requestDetails.getInstrumentDetails().getInstrumentAmt();
		}
		return contractAmount;
			
	}
	
	/**
	 * This is used to get the Bond Currency for Surety Bond
	 * @param requestDetails
	 * @param bondType
	 * @return
	 */
	private String getBondCurrencyCode(RequestDetails requestDetails,String bondType) {	
		String bondCurrencyCode =null;
		if(requestDetails.getInstrumentTypeId().intValue()== InstrumentType.SURETY_BOND.getId()){
			if(requestDetails.getBondDetails().getBondTypeId().intValue() == Integer.valueOf(ALOCConstants.LICENCE_BOND_ID) ||
				   requestDetails.getBondDetails().getBondTypeId().intValue() == Integer.valueOf(ALOCConstants.CUST_BOND_ID)||
						(requestDetails.getBondDetails().getBondTypeId().intValue() == Integer.valueOf(ALOCConstants.BIDBOND_ID) &&
								bondType!= null && bondType.equals(ALOCConstants.BID))){
				bondCurrencyCode = (requestDetails.getBondInfo() != null) ? requestDetails.getBondInfo().getCurrencyName() : null;
			}
		}		
		return bondCurrencyCode;
	}
	
	/**
	 * This is used to get the Bond Amount for Surety Bond
	 * @param requestDetails
	 * @param bondType
	 * @return
	 */
	private BigDecimal getBondAmount(RequestDetails requestDetails,String bondType) {	
		BigDecimal bondAmount =null;
		if(requestDetails.getInstrumentTypeId().intValue()== InstrumentType.SURETY_BOND.getId()){
			if(requestDetails.getBondDetails().getBondTypeId().intValue() == Integer.valueOf(ALOCConstants.LICENCE_BOND_ID) ||
				   requestDetails.getBondDetails().getBondTypeId().intValue() == Integer.valueOf(ALOCConstants.CUST_BOND_ID)||
						(requestDetails.getBondDetails().getBondTypeId().intValue() == Integer.valueOf(ALOCConstants.BIDBOND_ID) &&
								bondType!= null && bondType.equals(ALOCConstants.BID))){
				bondAmount = (requestDetails.getBondInfo() != null) ? requestDetails.getBondInfo().getBondAmount() : null;
			}
		}		
		return bondAmount;
	}
	
	/**
	 * This is used to get Beneficiary Details
	 * @param requestDetails
	 * @return
	 */
	private AddressDtls getCustomerBeneficiaryDetails(RequestDetails requestDetails){
		AddressDtls addressDet = null;
		BigInteger instrumentTypeId = requestDetails.getInstrumentTypeId();
		if(instrumentTypeId.equals(BigInteger.valueOf(InstrumentType.BANK_GUARANTEE.getId())) || instrumentTypeId.equals(BigInteger.valueOf(InstrumentType.LOC.getId()))){
			Customer customer = (requestDetails.getTransactionParties() != null) ? requestDetails.getTransactionParties().getCustomer() : null; 
			addressDet = (customer != null) ? customer.getAddressDtls() : null;
		}else if(instrumentTypeId.equals(BigInteger.valueOf(InstrumentType.DOCUMENT_LOC.getId()))){
			addressDet = (requestDetails.getBeneficiaryDetails()!= null) ? requestDetails.getBeneficiaryDetails().getAddressDtls() : null;
		}
		return addressDet;
	}
	
	/**
	 * This is used to get Applicant Details
	 * @param requestDetails
	 * @return
	 */
	private AddressDtls getApplicantDetails(RequestDetails requestDetails){
		AddressDtls addressDet = null;
		BigInteger instrumentTypeId = requestDetails.getInstrumentTypeId();
		if(instrumentTypeId.equals(BigInteger.valueOf(InstrumentType.BANK_GUARANTEE.getId())) || instrumentTypeId.equals(BigInteger.valueOf(InstrumentType.LOC.getId()))){
			if(requestDetails.getTransactionParties().isTriPartyRequestFlag() != null && requestDetails.getTransactionParties().isTriPartyRequestFlag()==true){
				addressDet = requestDetails.getTransactionParties() != null ? requestDetails.getTransactionParties().getTriPartyApplicant():null;	
			}else{
				addressDet = requestDetails.getTransactionParties().getTpApplicantDetails() != null ? requestDetails.getTransactionParties().getTpApplicantDetails().getAddressDtls():null; 
			}
		}else if(instrumentTypeId.equals(BigInteger.valueOf(InstrumentType.DOCUMENT_LOC.getId()))){
			addressDet = (requestDetails.getApplicantDetails()!= null) ? requestDetails.getApplicantDetails().getAddressDtls() : null;
		}
		return addressDet;
	}
	/**
	 * This is used to get the Amount in Words format
	 * @param number
	 * @return
	 */
	private String getAmountInWords(String number) {		
		String numberToWords = NumberToWordsHelper.getAmountInWords(number);
		return numberToWords;
	}
	/**
	 * This is used to get amount in formatted form
	 * @param currency
	 * @return
	 */
	private String getFormattedAmount(BigDecimal currency) {	
		if(currency == null) {
			return null;
		}
		DecimalFormat currencyFormatter = new DecimalFormat(ALOCConstants.CURRENCY_FORMAT);
		String currencyAsString = currencyFormatter.format(currency);
		return String.valueOf(currencyAsString);
	}
	
}
