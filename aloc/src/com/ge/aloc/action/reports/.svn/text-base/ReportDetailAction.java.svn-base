/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ReportDetailAction.java
 * Purpose: ReportDetailAction used for all ALOC Reports.
 *
 */
package com.ge.aloc.action.reports;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.ge.aloc.ALOCContext;
import com.ge.aloc.ReportTypes;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.exception.ALOCException;
import com.ge.aloc.manager.ILookupManager;
import com.ge.aloc.manager.IReferenceDataManager;
import com.ge.aloc.manager.reports.IReportsManager;
import com.ge.aloc.model.AddressDtls;
import com.ge.aloc.model.AgingDetails;
import com.ge.aloc.model.AvailableSites;
import com.ge.aloc.model.AverageFeesPaidDetails;
import com.ge.aloc.model.BidSuccessDetails;
import com.ge.aloc.model.ContingentliabilityDetails;
import com.ge.aloc.model.CycleTimeDetails;
import com.ge.aloc.model.ECSODetails;
import com.ge.aloc.model.FeeProjectionDetails;
import com.ge.aloc.model.FeeQuotationDetails;
import com.ge.aloc.model.FeesPaidDetails;
import com.ge.aloc.model.GCFODetails;
import com.ge.aloc.model.IssuanceExpirationDetails;
import com.ge.aloc.model.MDM.BankDetails;
import com.ge.aloc.model.NameValue;
import com.ge.aloc.model.ReportsDetails;
import com.ge.aloc.model.StaticDataManagement.UserSites;
import com.ge.aloc.model.UserReportDetails;
import com.ge.aloc.reports.ALOCReportException;
import com.ge.aloc.util.JSONHelper;
import com.hydus.hwf.context.UserContext;
import com.hydus.hwf.exceptions.HWFServiceException;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * @author srikanth.bayyannagar
 * 
 */
public class ReportDetailAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;

	private IReportsManager reportsManager;
	private IReferenceDataManager referenceDataManager;
	protected List<UserSites> childSitesList;
	protected List<AvailableSites> availableSitesList;
	private String morRate;
	private String bloombergRate;
	private ILookupManager lookupManager;
	private List<BankDetails> bankDetailsList;
	private String goldIdCount;
	private String csoCountName;
	protected String[] goldId;
	protected String[] csoId;
	private String reportName;
	private ReportsDetails reportsDetails;
	private String bankName;
	private int recordCount;
	private Map<String, Object> sessionValues = ActionContext.getContext().getSession();
	private List<AddressDtls> benficiaryAddressDtl;
	private List<AddressDtls> applicantAddressDtl;
	private List<AddressDtls> thirdPartyAddressDtl;
	private List<AddressDtls> applicantDtls;
	private List<AddressDtls> benficiaryDtls;
	private List<AddressDtls> addressDetailsList;
	private String ssoId;
	private String exportByBank;
	private List<String> agingMonthList;
	private List<String> bankNamesList;
	private BigInteger count;
	
	/**
	 * Method to assign default values for site search field
	 * @return
	 * @throws HWFServiceException
	 */
	public String loadContingentReport() throws HWFServiceException{
		loadUserSites();
		loadBankDtls();
		ssoId = UserContext.getContext().getuserDetails().getUserId();
		return ALOCConstants.SUCCESS;
	}
	
	/**
	 * Method to load sites for ECSO Report
	 * @return
	 * @throws HWFServiceException
	 */
	public String loadECSOReport() throws HWFServiceException{
		loadUserSites();
		ssoId = UserContext.getContext().getuserDetails().getUserId();
		return ALOCConstants.SUCCESS;
	}
	
	/**
	* Method to reset all selected sites
	* @return
	* @throws HWFServiceException
	*/
	@SuppressWarnings("unchecked")
	public String resetSitesValues() throws HWFServiceException{
		availableSitesList = new ArrayList<AvailableSites>();
		availableSitesList = (List<AvailableSites>) sessionValues.get(ALOCConstants.ALLSITELIST);
		return ALOCConstants.SUCCESS;
	}
	
	/**
	* Method to reset selected Bank Names
	* @return
	* @throws HWFServiceException
	*/
	@SuppressWarnings("unchecked")
	public String resetBankNamesBidSuccess() throws HWFServiceException{
		bankDetailsList = new ArrayList<BankDetails>();
		bankDetailsList = (List<BankDetails>)sessionValues.get(ALOCConstants.REPORTSBANKSLIST);
		return ALOCConstants.SUCCESS;
	}
	
	/**
	 * @Method to get the sites for the selected site types
	 * @return
	 * @throws HWFServiceException
	 */
	public String getSitesInfo() throws HWFServiceException {
		childSitesList = referenceDataManager.getSites();
		availableSitesList = new ArrayList<AvailableSites>();
		HttpServletRequest request = ServletActionContext.getRequest();
		AvailableSites availableSites = null;
		for(UserSites siteList:childSitesList){
			availableSites = new AvailableSites();
			availableSites.setSiteId(siteList.getID().intValue());
			availableSites.setSiteName(siteList.getName());
			availableSitesList.add(availableSites);
		}
		request.getSession().removeAttribute(ALOCConstants.ALLSITELIST);
		request.getSession().setAttribute(ALOCConstants.ALLSITELIST, availableSitesList);
		return ALOCConstants.SUCCESS;
	 }
	
	/**
	 * @Method to load all required Average fee paid details
	 * @return
	 * 
	 */
	public String loadAverageFeeDetails() throws HWFServiceException {
		loadUserSites();
		loadBankDtls();
		addressDetailsList = ALOCContext.getStaticDataFactory().getReportAddressDetails();
		applicantDtls = new ArrayList<AddressDtls>();
		benficiaryDtls = new ArrayList<AddressDtls>();
		for(AddressDtls addressDetails : addressDetailsList){
			switch(addressDetails.getAddressTypeId().intValue()){
				case ALOCConstants.NUM_ONE:  	
					applicantDtls.add(addressDetails);
					break;
				case ALOCConstants.NUM_SEVEN:  
					benficiaryDtls.add(addressDetails);
					break;
			}
		}
		return ALOCConstants.SUCCESS;
	}

	/**
	 * @Method to assign the default values for the issuance and expiration Report 
	 * @return
	 * @throws HWFServiceException
	 */
	public String assignInsuanceValues() throws HWFServiceException{
		loadUserSites();
		loadBanksForIssuance();
		getAddressDetails();
		ssoId = UserContext.getContext().getuserDetails().getUserId();
		return ALOCConstants.SUCCESS;
	}
	
	/**
	 * @Method to assign default values for issuer & branch in issuance report
	 * @return
	 * @throws HWFServiceException
	 */
	public void loadBanksForIssuance() throws HWFServiceException{
		@SuppressWarnings("unchecked")
		List<BankDetails> bankDtl = (List<BankDetails>)sessionValues.get(ALOCConstants.REPORTSBANKSLIST);
		if(bankDtl == null)
			bankDtl = reportsManager.getAlocBankDetails();
		bankDetailsList = new ArrayList<BankDetails>();
		for(BankDetails nameValue : bankDtl){
			if(nameValue.getBankName()!= null && nameValue.getSiteName()!= null){
				nameValue.setBankCode(nameValue.getBankName() + ALOCConstants.HYPEN + nameValue.getSiteName());
				bankDetailsList.add(nameValue);
			}
		}
		sessionValues.put(ALOCConstants.REPORTSBANKSLIST, bankDetailsList);
	}
	
	/**
	 * @Method to assign default values for cycle time Report 
	 * @return
	 * @throws HWFServiceException
	 */
	public String loadCycleTimeReport() throws HWFServiceException{
		loadUserSites();
		loadBankDtls();
		getAddressDetails();
		ssoId = UserContext.getContext().getuserDetails().getUserId();
		return ALOCConstants.SUCCESS;
	}
	
	/**
	 * Method to assign default values for bidSuccessReport
	 * @return
	 * @throws HWFServiceException
	 */
	public String loadBidSuccessReport() throws HWFServiceException{
		loadUserSites();
		loadBankDtls();
		ssoId = UserContext.getContext().getuserDetails().getUserId();
		return ALOCConstants.SUCCESS;
	}
	
	/**
	 * Method to assign default values for agingReport
	 * @return
	 * @throws HWFServiceException
	 */
	public String loadAgingReport() throws HWFServiceException{
		loadUserSites();
		loadBankDtls();
		ssoId = UserContext.getContext().getuserDetails().getUserId();
		getAddressDetails();
		// Aging Max Months
		reportsDetails = reportsManager.getMaxAgingMonths(ssoId,ALOCConstants.TRUE_SMALL,ALOCConstants.MAX_AGE);
		List<AgingDetails> agingList = reportsDetails.getAgingDetails();
		if (agingList.get(ALOCConstants.BASE_VALUE).getInAgingMonths() == null
				|| ALOCConstants.EMPTY_STRING.equals(agingList.get(
						ALOCConstants.BASE_VALUE).getInAgingMonths())){
			recordCount = ALOCConstants.BASE_VALUE;
		} else {
			recordCount = Integer.parseInt(agingList.get(ALOCConstants.BASE_VALUE).getInAgingMonths());
		}
		Integer j = ALOCConstants.BASE_VALUE;
		agingMonthList = new ArrayList<String>();
		for(int i=recordCount;i>=ALOCConstants.BASE_VALUE;i--){
			agingMonthList.add(j.toString());
			j++;
		}
		return ALOCConstants.SUCCESS;
	}

	/**
	 * Method to assign default values for Fees Paid Report
	 * @return
	 * @throws HWFServiceException
	 */
	public String onloadFeesPaidReport() throws HWFServiceException{
		loadUserSites();
		loadBankDtls();
		ssoId = UserContext.getContext().getuserDetails().getUserId();
		getAddressDetails();
		return ALOCConstants.SUCCESS;
	}
	
	/**
	 * Method to load sites information based on the user
	 * @return void
	 * @throws HWFServiceException 
	 * 
	 */
	@SuppressWarnings("unchecked")
	protected void loadUserSites() throws HWFServiceException{
		HttpServletRequest request = ServletActionContext.getRequest();
		List<UserSites> userSites = (List<UserSites>) sessionValues.get(ALOCConstants.USERSPECIFICSITES); 
		availableSitesList = new ArrayList<AvailableSites>();
		AvailableSites availableSites = null;
		for (NameValue nameValue : userSites) {
			availableSites = new AvailableSites();
			availableSites.setSiteId(nameValue.getID().intValue());
			availableSites.setSiteName(nameValue.getName());
			availableSitesList.add(availableSites);
		}
		request.getSession().removeAttribute(ALOCConstants.ALLSITELIST);
		request.getSession().setAttribute(ALOCConstants.ALLSITELIST, availableSitesList);
		request.getSession().removeAttribute(ALOCConstants.AVAILABLESITES);
		request.getSession().setAttribute(ALOCConstants.AVAILABLESITES, availableSitesList);
	}	
	
	/**
	 * Method to load bank details for all reports
	 * @throws HWFServiceException 
	 * 
	 */
	@SuppressWarnings({ "unchecked"})
	protected void loadBankDtls() throws HWFServiceException{
		List<BankDetails> bankDtl = (List<BankDetails>)sessionValues.get(ALOCConstants.REPORTSBANKSLIST);
		if(bankDtl == null)
			bankDtl = reportsManager.getAlocBankDetails();
		bankDetailsList = new ArrayList<BankDetails>();
		for(BankDetails nameValue : bankDtl){
			if(nameValue.getSiteName()!= null){
				bankName = nameValue.getSiteName();
				nameValue.setBankCode(nameValue.getSiteName());
				bankDetailsList.add(nameValue);
			}	
		}
		sessionValues.put(ALOCConstants.REPORTSBANKSLIST, bankDetailsList);
	}
	
	/**
	 * Method to get the Fee Projection MOR Rates based on selected currency code
	 * @throws HWFServiceException 
	 * 
	 */
	public String getMORForFeeProjection() throws HWFServiceException{
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			String selectedCurrency = request.getParameter(ALOCConstants.SELECTEDCURRENCY);
			morRate = reportsManager.getMORRates(selectedCurrency);
			HttpServletResponse response = ServletActionContext.getResponse();
			JSONHelper.writeSuccessResponse(morRate,response);
		} catch(HWFServiceException hse){
			addActionError(hse.getErrorMessage());	
			throw hse;
		}
		return null;
	}
	
	/**
	 * Method for export results to Excel file for Contingent Liability report
	 * @throws HWFServiceException
	 * @throws IOException 
	 * @throws ALOCReportException
	 */
	public void exportContingentReporttoFile() throws HWFServiceException, ALOCException, IOException {
		if(ALOCConstants.TRUE.equalsIgnoreCase(exportByBank)){
			exportContingentDetailsByBank();
		}else{
			exportReportDetails();
		}
	}
	
	/**
	 * Method for bank wise export results to Excel file for Contingent Liability report 
	 * @throws HWFServiceException
	 * @throws IOException 
	 * @throws ALOCReportException
	 */
	public void exportContingentDetailsByBank() throws HWFServiceException, ALOCReportException, IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		Boolean isExternal = Boolean.TRUE.equals(request.getAttribute(ALOCConstants.REQ_ATTR_ISEXTERNAL))?Boolean.TRUE:Boolean.FALSE;
		String fileName = request.getParameter(ALOCConstants.REPORT_XLSHEET_NAME);
		reportsManager.callContingentReportExport(reportName, reportsDetails, fileName, isExternal);
	}

	/**
	 * Method for export results to Excel file for ALOC Reports
	 * @throws HWFServiceException
	 * @throws ALOCReportException
	 * @throws IOException
	 */
	public void exportReportDetails() throws HWFServiceException, ALOCReportException, IOException {	
		HttpServletRequest request = ServletActionContext.getRequest();
		Boolean isExternal = Boolean.TRUE.equals(request.getAttribute(ALOCConstants.REQ_ATTR_ISEXTERNAL))?Boolean.TRUE:Boolean.FALSE;
		String fileName = request.getParameter(ALOCConstants.REPORT_XLSHEET_NAME);
		reportsManager.exportReportDetails(reportName, reportsDetails, fileName, isExternal);
	}
    
	/**
	 * Method to get records count for All Reports
	 * @throws HWFServiceException
	 * @throws ALOCReportException
	 * @throws IOException
	 */
	public void recordsCountDetails() throws HWFServiceException, ALOCReportException, IOException{
		
		ReportsDetails reportDtl = null;
		count = BigInteger.ZERO;
		ReportTypes reportTypes = ReportTypes.fromName(reportName);
		switch(reportTypes){
		case ISSUANCEEXPIRATIONREPORT:
			reportDtl = reportsManager.recordsCountDetails(reportName, reportsDetails);
			List<IssuanceExpirationDetails> issuenceAndExpirationList = new ArrayList<IssuanceExpirationDetails>();
			issuenceAndExpirationList = reportDtl.getIssuanceExpirationDetails();
			count = BigInteger.valueOf(issuenceAndExpirationList.size());
			break;
			
		case BIDSUCCESSREPORT:
			reportDtl = reportsManager.recordsCountDetails(reportName, reportsDetails);
			List<BidSuccessDetails> bidSuccessList = new ArrayList<BidSuccessDetails>();
			bidSuccessList = reportDtl.getBidSuccessDetails();
			count = BigInteger.valueOf(bidSuccessList.size());
			break;
			
		case AGINGREPORT:
			reportDtl = reportsManager.recordsCountDetails(reportName, reportsDetails);
			List<AgingDetails> agingList = new ArrayList<AgingDetails>();
			agingList = reportDtl.getAgingDetails();
			count = BigInteger.valueOf(agingList.size());
			break;
			
		case FEESPAIDREPORT:
			reportDtl = reportsManager.recordsCountDetails(reportName, reportsDetails);
			List<FeesPaidDetails> feespaidList = new ArrayList<FeesPaidDetails>();
			feespaidList = reportDtl.getFeesPaidDetails();
			count = BigInteger.valueOf(feespaidList.size());
			break;
			
		case CYCLETIMEREPORT:
			reportDtl = reportsManager.recordsCountDetails(reportName, reportsDetails);
			List<CycleTimeDetails> cycleTimeList = new ArrayList<CycleTimeDetails>();
			cycleTimeList = reportDtl.getCycleTimeDetails();
			count = BigInteger.valueOf(cycleTimeList.size());
			break;
			
		case ECSOREPORT:
			reportDtl = reportsManager.recordsCountDetails(reportName, reportsDetails);
			List<ECSODetails> ecsoDetailsList = new ArrayList<ECSODetails>();
			ecsoDetailsList = reportDtl.getECSODetails();
			count = BigInteger.valueOf(ecsoDetailsList.size());
			break;
			
		case GCFOREPORT:
			reportDtl = reportsManager.recordsCountDetails(reportName, reportsDetails);
			List<GCFODetails> gcfoDetailsList = new ArrayList<GCFODetails>();
			gcfoDetailsList = reportDtl.getGCFODetails();
			count = BigInteger.valueOf(gcfoDetailsList.size());
			break;
			
		case USERREPORT:
			reportDtl = reportsManager.recordsCountDetails(reportName, reportsDetails);
			List<UserReportDetails> userDetailsList = new ArrayList<UserReportDetails>();
			userDetailsList = reportDtl.getUserReportDetails();
			count = BigInteger.valueOf(userDetailsList.size());
			break;
			
		case FEEQUOTATIONREPORT:
			reportDtl = reportsManager.recordsCountDetails(reportName, reportsDetails);
			List<FeeQuotationDetails> feeQuotationDetailsList = new ArrayList<FeeQuotationDetails>();
			feeQuotationDetailsList = reportDtl.getFeeQuotationDetails();
			count = BigInteger.valueOf(feeQuotationDetailsList.size());
			break;
			
		case AVERAGEFEESPAIDREPORT:
			reportDtl = reportsManager.recordsCountDetails(reportName, reportsDetails);
			List<AverageFeesPaidDetails> averageFeeDetailsList = new ArrayList<AverageFeesPaidDetails>();
			averageFeeDetailsList = reportDtl.getAverageFeesPaidDetails();
			count = BigInteger.valueOf(averageFeeDetailsList.size());
			break;
			
		case FEEPROJECTIONREPORT:
			reportDtl = reportsManager.recordsCountDetails(reportName, reportsDetails);
			List<FeeProjectionDetails> feeProjectionList = new ArrayList<FeeProjectionDetails>();
			feeProjectionList = reportDtl.getFeeProjectionDetails();
			count = BigInteger.valueOf(feeProjectionList.size());
			break;
			
		case CONTINGENTREPORT:
			reportDtl = reportsManager.recordsCountDetails(reportName, reportsDetails);
			List<ContingentliabilityDetails> contingentList = new ArrayList<ContingentliabilityDetails>();
			contingentList = reportDtl.getContingentliabilityDetails();
			count = BigInteger.valueOf(contingentList.size());
			break;
		}
		
		
		HttpServletResponse response = ServletActionContext.getResponse();
		JSONHelper.writeSuccessResponse(count,response);
	}
	/**
	 * Method to get the dynamic Report Name 
	 * @param reportNameAction
	 */
	public void setReportName(String reportNameAction){
		reportName = reportNameAction;
	}

	/**
	 * This method is used to add Elements.
	 * @return
	 * @throws HWFServiceException
	 */
	public String addElements() throws HWFServiceException{
		return ALOCConstants.SUCCESS;
	}
	
	/**
	 * This method is used to call Fee Projection Report.
	 * @return
	 * @throws HWFServiceException
	 */
	public String feeProjInfo() throws HWFServiceException{
		loadUserSites();
		loadBankDtls();
		addressDetailsList = ALOCContext.getStaticDataFactory().getReportAddressDetails();
		applicantDtls = new ArrayList<AddressDtls>();
		benficiaryDtls = new ArrayList<AddressDtls>();
		for(AddressDtls addressDetails : addressDetailsList){
			switch(addressDetails.getAddressTypeId().intValue()){
				case ALOCConstants.NUM_ONE:  	
					applicantDtls.add(addressDetails);
					break;
				case ALOCConstants.NUM_SEVEN:  
					benficiaryDtls.add(addressDetails);
					break;
			}
		}
		return ALOCConstants.SUCCESS;
	}
	
	/**
	 * This method is used to get Applicant, Principal, Benficiary, Obligee & Triparty applicant details.
	 * @return
	 * @throws HWFServiceException
	 */
	@SuppressWarnings("unchecked")
	public void getAddressDetails() throws HWFServiceException{
		addressDetailsList = (List<AddressDtls>)sessionValues.get(ALOCConstants.ADDRESSSDTLSLIST);
		if(addressDetailsList == null){
			addressDetailsList = ALOCContext.getStaticDataFactory().getReportAddressDetails();
		}
		applicantAddressDtl = new ArrayList<AddressDtls>();
		benficiaryAddressDtl = new ArrayList<AddressDtls>();
		thirdPartyAddressDtl = new ArrayList<AddressDtls>();
		for(AddressDtls addressDetails : addressDetailsList){
			switch(addressDetails.getAddressTypeId().intValue()){
				case ALOCConstants.NUM_ONE:  
				case ALOCConstants.NUM_FOUR:	
					applicantAddressDtl.add(addressDetails);
					break;
				case ALOCConstants.NUM_SEVEN:  
				case ALOCConstants.NUM_FIVE:
				case ALOCConstants.NUM_THREE:
					benficiaryAddressDtl.add(addressDetails);
					break;
				case ALOCConstants.NUM_TWO:  
					thirdPartyAddressDtl.add(addressDetails);
					break;
			}
		}
		sessionValues.put(ALOCConstants.ADDRESSSDTLSLIST, addressDetailsList);
	}
	
	/* -------------------------------------------------------------------------------------------------------------------------------------------------------
	PROPERTY GETTER/SETTER METHODS
	------------------------------------------------------------------------------------------------------------------------------------------------------- */

	/**
	 * @return the reportsManager
	 */
	public IReportsManager getReportsManager() {
		return reportsManager;
	}

	/**
	 * @param reportsManager the reportsManager to set
	 */
	public void setReportsManager(IReportsManager reportsManager) {
		this.reportsManager = reportsManager;
	}

	/**
	 * @return the availableSitesList
	 */
	public List<AvailableSites> getAvailableSitesList() {
		return availableSitesList;
	}

	/**
	 * @param availableSitesList the availableSitesList to set
	 */
	public void setAvailableSitesList(List<AvailableSites> availableSitesList) {
		this.availableSitesList = availableSitesList;
	}

	/**
	 * @return the lookupManager
	 */
	public ILookupManager getLookupManager() {
		return lookupManager;
	}

	/**
	 * @param lookupManager the lookupManager to set
	 */
	public void setLookupManager(ILookupManager lookupManager) {
		this.lookupManager = lookupManager;
	}
	
	/**
	 * @return the bankDetailsList
	 */
	public List<BankDetails> getBankDetailsList() {
		return bankDetailsList;
	}

	/**
	 * @param bankDetailsList the bankDetailsList to set
	 */
	public void setBankDetailsList(List<BankDetails> bankDetailsList) {
		this.bankDetailsList = bankDetailsList;
	}

	/**
	 * @return the morRate
	 */
	public String getMorRate() {
		return morRate;
	}

	/**
	 * @param morRate the morRate to set
	 */
	public void setMorRate(String morRate) {
		this.morRate = morRate;
	}

	/**
	 * @return the goldIdCount
	 */
	public String getGoldIdCount() {
		return goldIdCount;
	}

	/**
	 * @param goldIdCount
	 *        the goldIdCount to set
	 */
	public void setGoldIdCount(String goldIdCount) {
		this.goldIdCount = goldIdCount;
	}

	/**
	 * @return the goldId
	 */
	public String[] getGoldId() {
		return goldId;
	}

	/**
	 * @param goldId
	 *        the goldId to set
	 */
	public void setGoldId(String[] goldId) {
		this.goldId = goldId;
	}

	/**
	 * @return the csoId
	 */
	public String[] getCsoId() {
		return csoId;
	}

	/**
	 * @param csoId
	 *        the csoId to set
	 */
	public void setCsoId(String[] csoId) {
		this.csoId=null;
		this.csoId = csoId;
	}

	/**
	 * @return the csoCountName
	 */
	public String getCsoCountName() {
		return csoCountName;
	}

	/**
	 * @param csoCountName
	 *        the csoCountName to set
	 */
	public void setCsoCountName(String csoCountName) {
		this.csoCountName = csoCountName;
	}

	/**
	 * @return the bloombergRate
	 */
	public String getBloombergRate() {
		return bloombergRate;
	}

	/**
	 * @param bloombergRate the bloombergRate to set
	 */
	public void setBloombergRate(String bloombergRate) {
		this.bloombergRate = bloombergRate;
	}

	/**
	 * get the report details
	 * @return
	 */
	public ReportsDetails getReportsDetails() {
		return reportsDetails;
	}
	/**
	 * set the report details
	 * @param reportsDetails
	 */
	public void setReportsDetails(ReportsDetails reportsDetails) {
		this.reportsDetails = reportsDetails;
	}

	/**
	 * Method to get Bank Name
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * Method to set Bank Name
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	/**
	 * set the record count
	 * @param recordCount
	 */
	public int getRecordCount() {
		return recordCount;
	}
	
	/**
	 * @return the recordCount
	 */
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	/**
	 * @return the referenceDataManager
	 */
	public IReferenceDataManager getReferenceDataManager() {
		return referenceDataManager;
	}


	/**
	 * @param referenceDataManager the referenceDataManager to set
	 */
	public void setReferenceDataManager(IReferenceDataManager referenceDataManager) {
		this.referenceDataManager = referenceDataManager;
	}


	/**
	 * @return the childSitesList
	 */
	public List<UserSites> getChildSitesList() {
		return childSitesList;
	}


	/**
	 * @param childSitesList the childSitesList to set
	 */
	public void setChildSitesList(List<UserSites> childSitesList) {
		this.childSitesList = childSitesList;
	}

	/**
	 * @return the benficiaryAddressDtl
	 */
	public List<AddressDtls> getBenficiaryAddressDtl() {
		return benficiaryAddressDtl;
	}

	/**
	 * @param benficiaryAddressDtl the benficiaryAddressDtl to set
	 */
	public void setBenficiaryAddressDtl(List<AddressDtls> benficiaryAddressDtl) {
		this.benficiaryAddressDtl = benficiaryAddressDtl;
	}

	/**
	 * @return the applicantAddressDtl
	 */
	public List<AddressDtls> getApplicantAddressDtl() {
		return applicantAddressDtl;
	}

	/**
	 * @param applicantAddressDtl the applicantAddressDtl to set
	 */
	public void setApplicantAddressDtl(List<AddressDtls> applicantAddressDtl) {
		this.applicantAddressDtl = applicantAddressDtl;
	}

	/**
	 * @return the thirdPartyAddressDtl
	 */
	public List<AddressDtls> getThirdPartyAddressDtl() {
		return thirdPartyAddressDtl;
	}

	/**
	 * @param thirdPartyAddressDtl the thirdPartyAddressDtl to set
	 */
	public void setThirdPartyAddressDtl(List<AddressDtls> thirdPartyAddressDtl) {
		this.thirdPartyAddressDtl = thirdPartyAddressDtl;
	}

	/**
	 * @return the ssoId
	 */
	public String getSsoId() {
		return ssoId;
	}

	/**
	 * @param ssoId the ssoId to set
	 */
	public void setSsoId(String ssoId) {
		this.ssoId = ssoId;
	}

	/**
	 * @return the exportByBank
	 */
	public String getExportByBank() {
		return exportByBank;
	}

	/**
	 * @param exportByBank the exportByBank to set
	 */
	public void setExportByBank(String exportByBank) {
		this.exportByBank = exportByBank;
	}
	
	/**
	 * @return the agingMonthList
	 */
	public List<String> getAgingMonthList() {
		return agingMonthList;
	}
	
	/**
	 * @param agingMonthList the agingMonthList to set
	 */
	public void setAgingMonthList(List<String> agingMonthList) {
		this.agingMonthList = agingMonthList;
	}
	
	/**
	 * @return the bankNamesList
	 */
	public List<String> getBankNamesList() {
		return bankNamesList;
	}
	
	/**
	 * @param bankNamesList the bankNamesList to set
	 */
	public void setBankNamesList(List<String> bankNamesList) {
		this.bankNamesList = bankNamesList;
	}
	
	/**
	 * @return the applicantDtls
	 */
	public List<AddressDtls> getApplicantDtls() {
		return applicantDtls;
	}
	
	/**
	 * @param applicantDtls the applicantDtls to set
	 */
	public void setApplicantDtls(
			List<AddressDtls> applicantDtls) {
		this.applicantDtls = applicantDtls;
	}
	
	/**
	 * @return the feeProjectionBenficiaryDtls
	 */
	public List<AddressDtls> getBenficiaryDtls() {
		return benficiaryDtls;
	}
	
	/**
	 * @param feeProjectionBenficiaryDtls the feeProjectionBenficiaryDtls to set
	 */
	public void setBenficiaryDtls(
			List<AddressDtls> benficiaryDtls) {
		this.benficiaryDtls = benficiaryDtls;
	}
	
	/**
	 * @return the addressDetailsList
	 */
	public List<AddressDtls> getAddressDetailsList() {
		return addressDetailsList;
	}
	
	/**
	 * @param addressDetailsList the addressDetailsList to set
	 */
	public void setAddressDetailsList(List<AddressDtls> addressDetailsList) {
		this.addressDetailsList = addressDetailsList;
	}
}
