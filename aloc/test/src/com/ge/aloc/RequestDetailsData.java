package com.ge.aloc;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.ge.aloc.model.AdditionalPayments;
import com.ge.aloc.model.AddressDtls;
import com.ge.aloc.model.ApplicantDetails;
import com.ge.aloc.model.AutoExtendClause;
import com.ge.aloc.model.BeneficiaryDetails;
import com.ge.aloc.model.BondDetails;
import com.ge.aloc.model.BondInfo;
import com.ge.aloc.model.BondReqDtls;
import com.ge.aloc.model.BuContactPerson;
import com.ge.aloc.model.BuRequestor;
import com.ge.aloc.model.Customer;
import com.ge.aloc.model.DeliveryInstructions;
import com.ge.aloc.model.GoodsOrigin;
import com.ge.aloc.model.InstrReporting;
import com.ge.aloc.model.InstrumentDetails;
import com.ge.aloc.model.InstrumentRisk;
import com.ge.aloc.model.IssuingBankDetails;
import com.ge.aloc.model.Obligee;
import com.ge.aloc.model.ObligeeRef;
import com.ge.aloc.model.PaymentScheduleDetails;
import com.ge.aloc.model.Principal;
import com.ge.aloc.model.ProjDescription;
import com.ge.aloc.model.RefDetails;
import com.ge.aloc.model.RequestDetails;
import com.ge.aloc.model.ShipmentOrigin;
import com.ge.aloc.model.TpApplicantDetails;
import com.ge.aloc.model.TpBuContactPerson;
import com.ge.aloc.model.TransactionDetails;
import com.ge.aloc.model.TransactionParties;
import com.ge.aloc.model.WFDetails;
import com.hydus.hwf.util.StringUtils;

public class RequestDetailsData {
	
	RequestDetails requestDetails = new RequestDetails();

	/**
	 * This method is used to set the mock data to RequestDetails Object
	 */
	public RequestDetails addWFDetails() {	
		WFDetails det = new WFDetails();
		det.setWFStage("Requestor");
		det.setWFStageID(new BigInteger("1"));
		requestDetails.setWFDetails(det);
		return requestDetails;
	}
	
	/**
	 * This method is used to set the mock data to RequestDetails Object
	 */
	public RequestDetails addTransactionPartiesSection()
	{	
		requestDetails.setRequestId(new BigInteger("7777"));
		requestDetails.setSiteId(new BigInteger("1566"));
		requestDetails.setSiteName("SITE_TEST_HYDUS_FINAN_CR_003");
		WFDetails det = new WFDetails();
		det.setWFStage("Requestor");
		det.setWFStageID(new BigInteger("2"));
		requestDetails.setWFDetails(det);
		
		TransactionParties trnsParties = new TransactionParties();
		trnsParties.setTriPartyRequestFlag(true);
		trnsParties.setPrivateLabelFlag(true);
		TpApplicantDetails tpApplicantDetails = new TpApplicantDetails();
		tpApplicantDetails.setLeGoldId("000084");
		tpApplicantDetails.setLeName("lename");
		
		TpBuContactPerson buContactPerson  = new TpBuContactPerson();
		buContactPerson.setFirstName("firstname");
		buContactPerson.setLastName("lastname");
		buContactPerson.setSsoId(1234);
		tpApplicantDetails.setTpBuContactPerson(buContactPerson);
		
		AddressDtls addressDtls = new AddressDtls();
		List<String> address = new ArrayList<String>();
		address.add("address1");
		address.add("Erramanzil");
		addressDtls.setName("name");
		addressDtls.setAddress(address);
		addressDtls.setCity("Hyderabad");
		addressDtls.setCountry("Australia");
		addressDtls.setCountryCd("AU");
		addressDtls.setZIPPostalCode("500082");
		addressDtls.setStateProvince("Florida");
		addressDtls.setStateProvinceCd("FL");
		tpApplicantDetails.setAddressDtls(addressDtls);
		
		List<RefDetails> refDetails = new ArrayList<RefDetails>();
		RefDetails ref = new RefDetails();
		ref.setRefId(new BigInteger("1234"));
		ref.setRefValue("refname1");
		refDetails.add(ref);
		tpApplicantDetails.setRefDetails(refDetails);
		
		tpApplicantDetails.setBuUnit("buc_1");
		tpApplicantDetails.setBuUnitCode(new BigInteger("2"));
		tpApplicantDetails.setAccDist("adn_1");
		tpApplicantDetails.setAccDistNo(new BigInteger("2"));
		tpApplicantDetails.setCsoNo("gec-e-999135");
		tpApplicantDetails.setCsoApprovalDt(Calendar.getInstance());
		tpApplicantDetails.setCertifyFlag(true);
		
		trnsParties.setTpApplicantDetails(tpApplicantDetails);
		trnsParties.setTriPartyApplicant(addressDtls);
		Customer customer = new Customer();
		customer.setAddressDtls(addressDtls);
		trnsParties.setCustomer(customer);
		
		customer.setRefDetails(refDetails);
		
		requestDetails.setTransactionParties(trnsParties);
		return requestDetails;
	}
	
	/**
	 * This method is used to set the mock data to RequestDetails Object
	 */
	public RequestDetails addProjectDescriptionSection()
	{		
		ProjDescription projectDescription = new ProjDescription();
		projectDescription.setProjDesc("project description");
		projectDescription.setBidCurrCd("USD");
		projectDescription.setBidCurrName("US Dollar");
		projectDescription.setBidContractAmt(BigDecimal.valueOf(21000));
		
		requestDetails.setProjDescription(projectDescription);
		return requestDetails;
	}

	/**
	 * This method is used to set the mock data to RequestDetails Object
	 */
	public RequestDetails addInstrumentRiskSection()
	{
		InstrumentRisk instRisk= new InstrumentRisk();
		instRisk.setNotiClauseFlag(false);
		instRisk.setCurePeriodFlag(true);
		instRisk.setDrDownApprFlag(false);
		instRisk.setCurePeriodValue(new BigInteger("20"));
		instRisk.setContrReqFlag(true);
		instRisk.setContrReqReason("test");
		instRisk.setNoOfDays(new BigInteger("40"));
		
		requestDetails.setInstrumentRisk(instRisk);
		return requestDetails;
	}

	/**
	 * This method is used to set the mock data to RequestDetails Object
	 */
	public RequestDetails addInstrumentDetailsSection()
	{
		InstrumentDetails insDetails= new InstrumentDetails();
		insDetails.setInstrumentCurrencyId("US");
		insDetails.setIssuanceCountry("United States");
		insDetails.setInstrumentCurrencyId("USD");
		insDetails.setInstrumentCurrency("US Dollar");
		insDetails.setInstrumentAmt(BigDecimal.valueOf(25000));
		Calendar cal = Calendar.getInstance();
		insDetails.setIssueDt(cal);
		insDetails.setExpiryDt(cal);
		insDetails.setInitialExpiryDt(cal);
		insDetails.setEconoExpiryDt(cal);
		insDetails.setMaxPossibleExpo("25000");
		insDetails.setPercentValueOfBid(BigDecimal.valueOf(100));
		
		AutoExtendClause autoExtendClause  = new AutoExtendClause();
		autoExtendClause.setAutoExtendFlag("True");
		autoExtendClause.setNonRenewalPeriod("90");
		insDetails.setAutoExtendClause(autoExtendClause);
		
		insDetails.setInitialExpiryDt(cal);
		insDetails.setAutoIncDecFlag("False");
		requestDetails.setInstrumentDetails(insDetails);
		return requestDetails;
	}

	/**
	 * This method is used to set the mock data to RequestDetails Object
	 */
	public RequestDetails addInstrumentReportingSection() 
	{
		InstrReporting insReporting = new InstrReporting();
		insReporting.setPoleId(BigInteger.valueOf(203));
		insReporting.setPoleName("Americas");
		requestDetails.setInstrReporting(insReporting);
		return requestDetails;
	}

	
	/**
	 * This method is used to set the mock data to RequestDetails Object
	 */
	public RequestDetails addBusinessContactPersonSection()
	{
		BuContactPerson buContactPerson = new BuContactPerson();
		BuRequestor buRequestor = new BuRequestor();
		buRequestor.setName("kranthi kumar");
		buRequestor.setPhoneNumber("9848012345");
		buRequestor.setEmailAddr("kranthi.anumula@hydus.com");
		buRequestor.setSsoId("999911177");
		List<BuRequestor> BuRequestorList = new ArrayList<BuRequestor>();
		BuRequestorList.add(buRequestor);
		buContactPerson.setBuRequestors(BuRequestorList);
		requestDetails.setBuContactPerson(buContactPerson);
		return requestDetails;
	}

	/**
	 * This method is used to set the mock data to RequestDetails Object
	 */
	public RequestDetails addIssuingBankSection()
	{
		IssuingBankDetails issuingBankDetails = new IssuingBankDetails();
		issuingBankDetails.setBankName("Swiss Bank");
		AddressDtls addressDtls = new AddressDtls();
		List<String> address = new ArrayList<String>();
		address.add("Yusuf Guda");
		address.add("Lakshmi Nilayam Street");
		addressDtls.setAddress(address);
		addressDtls.setCity("Hyderabad");
		addressDtls.setStateProvince("Hong Kong");
		addressDtls.setStateProvinceCd("HK");
		addressDtls.setZIPPostalCode("520036");
		addressDtls.setCountry("India");
		addressDtls.setCountryCd("IN");
		issuingBankDetails.setAddressDtls(addressDtls);
		issuingBankDetails.setCreditLetterNo("55555");
		issuingBankDetails.setBIC("BIC_101");
		
		requestDetails.setIssuingBankDetails(issuingBankDetails);
		return requestDetails;
	}

	/**
	 * This method is used to set the mock data to RequestDetails Object
	 */
	public RequestDetails addApplicantSection()
	{
		ApplicantDetails applicantDetails = new ApplicantDetails();
		AddressDtls addressDtls = new AddressDtls();
		addressDtls.setName("Kranthi Kumar");
		List<String> address = new ArrayList<String>();
		address.add("Yusuf Guda");
		address.add("Lakshmi Nilayam Street");
		addressDtls.setAddress(address);
		addressDtls.setCity("Hyderabad");
		addressDtls.setStateProvince("Hong Kong");
		addressDtls.setStateProvinceCd("HK"); 
		addressDtls.setZIPPostalCode("520036");
		addressDtls.setCountry("India");
		addressDtls.setCountryCd("IN");
		addressDtls.setFutureUseFlag("True");
		List<RefDetails> refDetailsList = new ArrayList<RefDetails>();
		RefDetails refDetails1 = new RefDetails();
		refDetails1.setRefValue("GE Ref 111");
		RefDetails refDetails2 = new RefDetails();
		refDetails2.setRefValue("GE Ref 222");
		RefDetails refDetails3 = new RefDetails();
		refDetails3.setRefValue("GE Ref 333");
		refDetailsList.add(0,refDetails1);
		refDetailsList.add(1,refDetails2);
		refDetailsList.add(2,refDetails3);
		applicantDetails.setAddressDtls(addressDtls);
		applicantDetails.setRefDetails(refDetailsList);
		
		requestDetails.setApplicantDetails(applicantDetails);
		return requestDetails;
	}

	/**
	 * This method is used to set the mock data to RequestDetails Object
	 */
	public RequestDetails addBeneficiarySection() 
	{
		BeneficiaryDetails beneficiaryDetails = new BeneficiaryDetails();
		AddressDtls addressDtls = new AddressDtls();
		addressDtls.setName("Kranthi Kumar");
		List<String> address = new ArrayList<String>();
		address.add("Yusuf Guda");
		address.add("Lakshmi Nilayam Street");
		addressDtls.setAddress(address);
		addressDtls.setCity("Hyderabad");
		addressDtls.setStateProvince("Florida");
		addressDtls.setStateProvinceCd("FL");
		addressDtls.setZIPPostalCode("520036");
		addressDtls.setCountry("India");
		addressDtls.setCountryCd("IN");
		beneficiaryDetails.setAddressDtls(addressDtls);
		
		List<RefDetails> refDetailsList = new ArrayList<RefDetails>();
		RefDetails refDetails1 = new RefDetails();
		refDetails1.setRefValue("Beneficiary Ref 111");
		RefDetails refDetails2 = new RefDetails();
		refDetails2.setRefValue("Beneficiary Ref 222");
		RefDetails refDetails3 = new RefDetails();
		refDetails3.setRefValue("Beneficiary Ref 333");
		refDetailsList.add(0,refDetails1);
		refDetailsList.add(1,refDetails2);
		refDetailsList.add(2,refDetails3);
		beneficiaryDetails.setRefDetails(refDetailsList);
		
		beneficiaryDetails.setLeGoldId("000084");
		beneficiaryDetails.setLeName("Le Name");
		
		requestDetails.setBeneficiaryDetails(beneficiaryDetails);
		return requestDetails;
	}

	/**
	 * This method is used to set the mock data to RequestDetails Object
	 */
	public RequestDetails addInstrumentTransactionDetailsSection() 
	{
		TransactionDetails transactionDetails = new TransactionDetails();
		transactionDetails.setProjectDesc("Project Description");
		transactionDetails.setIssuanceCountry("India");
		transactionDetails.setIssuanceCountryCd("IN");
		transactionDetails.setContranctAmt(BigDecimal.valueOf(999.89));
		transactionDetails.setContranctCurId("INR");
		transactionDetails.setContranctCur("India");
		transactionDetails.setDocLCCurId("USD");
		transactionDetails.setDocLCCur("United States");
		transactionDetails.setDocLCAmt(BigDecimal.valueOf(888.89));
		transactionDetails.setUSDEquivalent(BigDecimal.valueOf(800.00));
		
		List<ShipmentOrigin> shipmentOriCountries = new ArrayList<ShipmentOrigin>();
		ShipmentOrigin origin  = new ShipmentOrigin();
		origin.setCountryCd("IN");
		origin.setCountyName("India");
		ShipmentOrigin origin1  = new ShipmentOrigin();
		origin1.setCountryCd("AUS");
		origin1.setCountyName("Australia");
		shipmentOriCountries.add(origin);
		shipmentOriCountries.add(origin1);

		transactionDetails.setShipmentDestCountry("South Africa");
		transactionDetails.setShipmentDestCountryCd("ZA");
		
		List<GoodsOrigin> goodsOrigins = new ArrayList<GoodsOrigin>();
		GoodsOrigin goods = new GoodsOrigin();
		goods.setCountryCd("LK");
		goods.setCountyName("Sri Lanka");
		GoodsOrigin goods1 = new GoodsOrigin();
		goods1.setCountryCd("BD");
		goods1.setCountyName("Bangladesh");
		goodsOrigins.add(goods);
		goodsOrigins.add(goods1);
		
		transactionDetails.setUSContentPercent("Less than 50");
		transactionDetails.setLCPaymentId(BigInteger.valueOf(2));
		transactionDetails.setConfirmationType("Silent");
		transactionDetails.setBankChargesId(BigInteger.valueOf(2));
		transactionDetails.setBankChargesType("Deduct From Proceeds");
		
		requestDetails.setTransactionDetails(transactionDetails);
		return requestDetails;
	}

	/**
	 * This method is used to set the mock data to RequestDetails Object
	 */
	public RequestDetails addPaymentScheduleSection()
	{
		PaymentScheduleDetails paymentScheduleDetails = new PaymentScheduleDetails();
		Calendar calender = Calendar.getInstance();
		calender.set(13, 2, 4);
		
		paymentScheduleDetails.setValidLCMonths("5");
		paymentScheduleDetails.setIssueDt(calender);
		paymentScheduleDetails.setSplInstructions("Special Instructions");
		
		List<AdditionalPayments> additionalPaymentsList = new ArrayList<AdditionalPayments>();
		AdditionalPayments additionalPayment1 = new AdditionalPayments();
		additionalPayment1.setEstAmt(BigDecimal.valueOf(555));
		additionalPayment1.setEstDt(calender);
		additionalPayment1.setEstMonths(BigInteger.valueOf(5));
		AdditionalPayments additionalPayment2 = new AdditionalPayments();
		additionalPayment2.setEstAmt(BigDecimal.valueOf(666));
		additionalPayment2.setEstDt(calender);
		additionalPayment2.setEstMonths(BigInteger.valueOf(6));
		additionalPaymentsList.add(additionalPayment1);
		additionalPaymentsList.add(additionalPayment2);
		paymentScheduleDetails.setAdditionalPayments(additionalPaymentsList);
		
		requestDetails.setPaymentScheduleDetails(paymentScheduleDetails);
		return requestDetails;
	}
	
	/**
	 * This method is used to set the mock data to RequestDetails Object
	 */
	public RequestDetails addBondDetailsSection()
	{
		requestDetails.setInstrumentTypeId(new BigInteger("3"));
		requestDetails.setRequestId(new BigInteger("7777"));
		requestDetails.setSiteId(new BigInteger("1566"));
		WFDetails det = new WFDetails();
		det.setWFStage("Requestor");
		det.setWFStageID(new BigInteger("1"));
		requestDetails.setWFDetails(det);
		
		BondDetails bondDetails = new BondDetails();
		bondDetails.setBondType("contract Bond");
		bondDetails.setBondTypeId(new BigInteger("2"));
		bondDetails.setBondSubType("license bond");
		bondDetails.setSubBondTypeId(new BigInteger("9"));
		
		requestDetails.setBondDetails(bondDetails);
		return requestDetails;
			
	}
	
	/**
	 * This method is used to set the mock data to RequestDetails Object
	 */
	public RequestDetails addPrincipalSection()
	{
		Principal principal = new Principal();
		principal.setLeGoldId("000084");
		principal.setLeName("Lename");
		principal.setGeDivisionName("GE_Division1");
		principal.setGeDivisionId(BigInteger.valueOf(2));
		principal.setPrincipleInfoFlag("true");
		
		AddressDtls addressDtls = new AddressDtls();
		List<String> address = new ArrayList<String>();
		address.add("address1");
		address.add("Erramanzil");
		addressDtls.setAddress(address);
		addressDtls.setCity("Hyderabad");
		addressDtls.setCountry("India");
		addressDtls.setCountryCd("IN");
		addressDtls.setStateProvince("Florida");
		addressDtls.setStateProvinceCd("FL");
		addressDtls.setZIPPostalCode("500082");
		principal.setAddressDtls(addressDtls);
		
		principal.setBusinessId("1234");
		
		List<RefDetails> refDetails = new ArrayList<RefDetails>();
		RefDetails ref = new RefDetails();
		ref.setRefId(new BigInteger("1234"));
		ref.setRefValue("refname1");
		refDetails.add(ref);
		principal.setRefDetails(refDetails);
		
		principal.setPrincipalBuUniteCd("buc_1");
		principal.setPrincipalAccDistNo("adn_1");
		
		requestDetails.setPrincipal(principal);
		return requestDetails;
	}
	
	/**
	 * This method is used to set the mock data to RequestDetails Object
	 */
	public RequestDetails addObligeeSection()
	{
		Obligee obligee = new Obligee();
		AddressDtls addressDtls = new AddressDtls();
		List<String> address = new ArrayList<String>();
		address.add("address1");
		address.add("Erramanzil");
		addressDtls.setName("name");
		addressDtls.setAddress(address);
		addressDtls.setCity("Hyderabad");
		addressDtls.setCountry("India");
		addressDtls.setCountryCd("IN");
		addressDtls.setZIPPostalCode("500082");
		addressDtls.setStateProvince("France");
		addressDtls.setStateProvinceCd("FR");
		obligee.setAddressDtls(addressDtls);
		
		ObligeeRef obligeeRef1=new ObligeeRef();
		obligeeRef1.setRefValue("Ref 111");
		ObligeeRef obligeeRef2=new ObligeeRef();
		obligeeRef2.setRefValue("Ref 111");
		
		List<ObligeeRef> obligeeReves=new ArrayList<ObligeeRef>();
		obligeeReves.add(obligeeRef1);
		obligeeReves.add(obligeeRef2);
		obligee.setObligeeReves(obligeeReves);
		
		requestDetails.setObligee(obligee);
		return requestDetails;
	}
	
	/**
	 * This method is used to set the mock data to RequestDetails Object
	 */
	public RequestDetails addBondRequestorSection() 
	{
		BondReqDtls bondReqDtls= new BondReqDtls();
		bondReqDtls.setName("Kranthi Kumar");
		bondReqDtls.setEmailAddress("abc@bbc.com");
		bondReqDtls.setPhoneNo("999 911 1122");
		bondReqDtls.setFaxNo("999-888-222");
		
		requestDetails.setBondReqDtls(bondReqDtls);
		return requestDetails;
	}
	
	/**
	 * This method is used to set the mock data to RequestDetails Object
	 */
	public RequestDetails addRequestorMailingAddressSection()
	{
		AddressDtls addressDtls = new AddressDtls();
		List<String> address = new ArrayList<String>();
		address.add("address1");
		address.add("Erramanzil");
		addressDtls.setName("name");
		addressDtls.setContactFName("Frist Name");
		addressDtls.setContactLName("Last Name");
		addressDtls.setAddress(address);
		addressDtls.setCity("Hyderabad");
		addressDtls.setCountry("India");
		addressDtls.setCountryCd("IN");
		addressDtls.setZIPPostalCode("500082");
		addressDtls.setStateProvince("New York");
		addressDtls.setStateProvinceCd("NY");
		addressDtls.setCountryOfInc("India");
		addressDtls.setCountryOfIncCd("IN");			
		addressDtls.setStateOfInc("Texas");
		addressDtls.setStateOfIncCd("TX");
		addressDtls.setPhoneNumber("888 999 5555");
		
		requestDetails.setAddressDtls(addressDtls);
		return requestDetails;
	}
	
	/**
	 * This method is used to set the mock data to RequestDetails Object
	 */
	public RequestDetails addBondInformationSection()
	{
		BondInfo bondInfo = new BondInfo();
		Calendar  ptime = Calendar.getInstance();
		ptime.set(Calendar.HOUR,3);
		ptime.set(Calendar.MINUTE,34);
		ptime.set(Calendar.AM_PM,Calendar.PM);
		
		//court bond
		bondInfo.setIssuanceCountryName("Hong Kong");
		bondInfo.setIssuanceCountryCd("HK");
		bondInfo.setCourtOfJurisdiction("Court");
		bondInfo.setCounty("India");
		bondInfo.setState("Alaska");
		bondInfo.setStateCd("AK");
		bondInfo.setCaseNumber(BigInteger.valueOf(12000));
		bondInfo.setDateFiled(ptime);
		bondInfo.setJudgementAmount(BigDecimal.valueOf(36000));
		bondInfo.setBondCurrency("US Dollar");
		bondInfo.setBondCurrencyCd("USD");
		bondInfo.setCourtBondAmt(BigDecimal.valueOf(26000));
		bondInfo.setEffectiveDt(ptime);
		bondInfo.setExpirationDt(ptime);
		bondInfo.setNeedByDate(ptime);
		bondInfo.setOtherInfo("Other info");
		
		//attorney bond
		bondInfo.setLawFirmName("Frim name");
		bondInfo.setAttorneyName("Attorney name");
		bondInfo.setAttorneyAddress1("Addr1");
		bondInfo.setAttorneyCity("Hyderabad");
		bondInfo.setAttorneyState("Hong Kong");
		bondInfo.setAttorneyStateCd("HK");
		bondInfo.setAttorneyCountry("India");
		bondInfo.setAttorneyCountryCode("IN");
		bondInfo.setAttorneyZIPCode("222555");
		bondInfo.setAttorneyPhoneNum("333 555 3333");
		bondInfo.setAttorneyFaxNum("444-666-777");
		bondInfo.setAttorneyEmail("test@ge.com");
		
		requestDetails.setBondInfo(bondInfo);
		return requestDetails;
	}
	
	/**
	 * This method is used to set the mock data to RequestDetails Object
	 */
	public RequestDetails addDeliveryInstructionsSection()
	{
		DeliveryInstructions deliveryInstructions = new DeliveryInstructions();
		deliveryInstructions.setDeliveryType("True");
		deliveryInstructions.setCompanyName("Hydus");
		deliveryInstructions.setFirstName("Kranthi");
		deliveryInstructions.setLastName("Kumar");
		deliveryInstructions.setTitle("Software");
		deliveryInstructions.setPhoneNo("984 801 2345");
		deliveryInstructions.setSpecialInstructions("special instr");
		deliveryInstructions.setDeliveryDesignationFlag("Applicant");
		
		requestDetails.setDeliveryInstructions(deliveryInstructions);
		return requestDetails;
	}
	
	/**
	 * This method is used to set the mock data to RequestDetails for BG Object
	 */
	public RequestDetails getBgOrSblcDetails(String instrumentTypeId)
	{	
		if(StringUtils.isNotBlank(instrumentTypeId))
		{
			requestDetails.setInstrumentTypeId(new BigInteger(instrumentTypeId));
		}
		requestDetails.setTransactionParties(addTransactionPartiesSection().getTransactionParties());
		requestDetails.setProjDescription(addProjectDescriptionSection().getProjDescription());
		requestDetails.setInstrumentDetails(addInstrumentDetailsSection().getInstrumentDetails());
		requestDetails.setInstrumentRisk(addInstrumentRiskSection().getInstrumentRisk());
		requestDetails.setInstrReporting(addInstrumentReportingSection().getInstrReporting());
		requestDetails.setDeliveryInstructions(addDeliveryInstructionsSection().getDeliveryInstructions());			
		return requestDetails;
	}
	
	/**
	 * This method is used to set the mock data to RequestDetails for Surety Bond Object
	 */
	public RequestDetails getSuretyBondDetails()
	{	
		requestDetails.setInstrumentTypeId(new BigInteger("3"));
		requestDetails.setBondDetails(addBondDetailsSection().getBondDetails());
		requestDetails.setPrincipal(addPrincipalSection().getPrincipal());
		requestDetails.setObligee(addObligeeSection().getObligee());
		requestDetails.setBondReqDtls(addBondRequestorSection().getBondReqDtls());
		requestDetails.setAddressDtls(addRequestorMailingAddressSection().getAddressDtls());
		requestDetails.setDeliveryInstructions(addDeliveryInstructionsSection().getDeliveryInstructions());
		requestDetails.setBondInfo(addBondInformationSection().getBondInfo());
		return requestDetails;
	}
	
	/**
	 * This method is used to set the mock data to RequestDetails for DLOC Object
	 */
	public RequestDetails getDlocDetails()
	{
		requestDetails.setInstrumentTypeId(new BigInteger("4"));
		requestDetails.setSiteId(new BigInteger("1566"));
		requestDetails.setBuContactPerson(addBusinessContactPersonSection().getBuContactPerson());
		requestDetails.setIssuingBankDetails(addIssuingBankSection().getIssuingBankDetails());
		requestDetails.setApplicantDetails(addApplicantSection().getApplicantDetails());
		requestDetails.setBeneficiaryDetails(addBeneficiarySection().getBeneficiaryDetails());
		requestDetails.setTransactionDetails(addTransactionPartiesSection().getTransactionDetails());
		requestDetails.setPaymentScheduleDetails(addPaymentScheduleSection().getPaymentScheduleDetails());
		return requestDetails;
	}
}