/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: ReportsDAO.java
 * ReportsDAO used to implement common operations for all dashboards
 */
package com.ge.aloc.dao.impl.reports;

import java.util.ArrayList;
import java.util.List;

import com.ge.aloc.OpCode;
import com.ge.aloc.ServiceClientSupport;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.dao.IReportsDAO;
import com.ge.aloc.model.AgingDetails;
import com.ge.aloc.model.ContingentliabilityDetails;
import com.ge.aloc.model.MDM;
import com.ge.aloc.model.MDM.BankDetails;
import com.ge.aloc.model.Rates;
import com.ge.aloc.model.ReportsDetails;
import com.ge.aloc.util.ALOCCommonHelper;
import com.ge.aloc.util.ReportsHelper;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author srikanth.bayyannagari
 * @
 */
public class ReportsDAO extends ServiceClientSupport implements IReportsDAO {

	/**
	 * @param
	 * Method to call the Contingent Report BW process for Export to Excel functionality
	 */
	public ReportsDetails callContingentReportExport(ReportsDetails reportDetails) throws HWFServiceException {
		List<ContingentliabilityDetails> cdtlArray = reportDetails.getContingentliabilityDetails();
		ContingentliabilityDetails cdtl = cdtlArray.get(ALOCConstants.BASE_VALUE);
		cdtlArray.set(0,cdtl);

		reportDetails.setMsgHeader(ALOCCommonHelper.createMsgHeader(OpCode.GETCONTINGENTLIABILITY.toString()));
		reportDetails.setContingentliabilityDetails(cdtlArray);

		ReportsDetails reportDetailsReply = serviceClient.invokeService(OpCode.REPORTS.getOperationCode(), reportDetails ,ReportsDetails.class);
		return reportDetailsReply;
	}

	/**
	 * call to get all MOR Rates
	 */
	public String getMORRates(String selectedCurrency) throws HWFServiceException {
		MDM mdmObject = new MDM();
		List<Rates> rates = new ArrayList<Rates>();
		Rates sltedRate = new Rates();
		sltedRate.setObjectCurrencyCode(selectedCurrency);
		rates.add(sltedRate);
		mdmObject.setRates(rates);
		mdmObject.setMsgHeader(ALOCCommonHelper.createMsgHeader(OpCode.OTHERMORRATE.toString()));
		mdmObject = serviceClient.invokeService(OpCode.MDM.getOperationCode(), mdmObject,MDM.class);
		return mdmObject.getRates().get(ALOCConstants.BASE_VALUE).getObjectCurrencyCode();
	}

	/**
	 * Method to call export to Excel results of reports  
	 * @throws HWFServiceException
	 */
	public ReportsDetails exportReportDetails(String reportName,ReportsDetails reportsDetails1) throws HWFServiceException {

		ReportsDetails reportDetailsReply ;
		if(!reportName.equalsIgnoreCase(ALOCConstants.CONTINGENTREPORT)){
			ReportsDetails reportDetails = ReportsHelper.assignReportProperties(reportName,reportsDetails1);
			reportDetailsReply = serviceClient.invokeService(OpCode.REPORTS.getOperationCode(), reportDetails ,ReportsDetails.class);
		}else{
			reportDetailsReply = callContingentReportExport(reportsDetails1);
		}

		return reportDetailsReply;
	}
	
	/**
	 * Method to get Bank Details List from Local Environment
	 * @throws HWFServiceException
	 */
	public List<BankDetails> invokeBankDetails() throws HWFServiceException {
		MDM mdmObject = new MDM();
		mdmObject.setMsgHeader(ALOCCommonHelper.createMsgHeader(OpCode.GETALOCBANKSLIST.toString()));
		mdmObject = serviceClient.invokeService(OpCode.MDM.getOperationCode(), mdmObject,MDM.class);
		return mdmObject.getBankDetails();
	}
	
	/**
	 * @see com.ge.aloc.dao.IReportsDAO#getAgingBenefObligeeDetails()
	 */
	public ReportsDetails getMaxAgingMonths(String SSOID, String agingFlag, String inAgingMonths)throws HWFServiceException {

		ReportsDetails reportDetails = new ReportsDetails();
		reportDetails.setMsgHeader(ALOCCommonHelper.createMsgHeader(OpCode.GETAGING.toString()));
		AgingDetails agingDetails = new AgingDetails();
		agingDetails.setAgingUserSSO(SSOID);
		agingDetails.setMaxAgingMonths(agingFlag);
		agingDetails.setInAgingMonths(inAgingMonths);
		List<AgingDetails> agingList  = new ArrayList<AgingDetails>();
		agingList.add(agingDetails);
		reportDetails.setAgingDetails(agingList);
		reportDetails = serviceClient.invokeService(OpCode.REPORTS.getOperationCode(), reportDetails, ReportsDetails.class);
		return reportDetails;
	}
}
