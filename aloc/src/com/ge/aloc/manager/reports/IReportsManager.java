/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: IDashboardManager.java
 * Purpose: IDashboardManager used for the bundle Dashboard data for draft,my tranaction, my request and 
 *  other business methods
 */
package com.ge.aloc.manager.reports;

import java.io.IOException;
import java.util.List;

import com.ge.aloc.model.MDM.BankDetails;
import com.ge.aloc.model.ReportsDetails;
import com.ge.aloc.reports.ALOCReportException;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author srikanth.bayyannagari
 *
 */
public interface IReportsManager {

	/**
	 * This method is used to get MOR Rates.
	 * @return
	 * @throws HWFServiceException
	 */
	public String getMORRates(String selectedCurrency) throws HWFServiceException;

	/**
	 * This method is used to call Export Excel for Contingent Liability Report.
	 * @throws HWFServiceException
	 * @throws ALOCReportException
	 */

	public void callContingentReportExport(String reportName, ReportsDetails reportsDetails, String fileName, Boolean isExternal) throws HWFServiceException, ALOCReportException, IOException;

	/**
	 * Method is for call the export to Excel for reports
	 * @throws HWFServiceException
	 * @throws ALOCReportException
	 * @throws IOException 
	 */
	public void exportReportDetails(String reportName, ReportsDetails reportsDetails, String fileName, Boolean isExternal) throws HWFServiceException, ALOCReportException, IOException;
	
	/**
	 * Method to get Bank Details List from Local Environment
	 * @param bankName
	 * @return
	 * @throws HWFServiceException
	 */
	public List<BankDetails> getAlocBankDetails() throws HWFServiceException;
	
	/**
	 * Method to get Max Aging Months List for AgingReport List for selected search criteria.
	 * @param requestorName
	 * @return
	 * @throws HWFServiceException
	 */
	public ReportsDetails getMaxAgingMonths(String SSOID,String agingFlag, String inAgingMonths)throws HWFServiceException;
	
	/**
	 * Method to get records count for All Reports
	 * @throws HWFServiceException
	 * @throws ALOCReportException
	 * @throws IOException
	 */
	public ReportsDetails recordsCountDetails(String reportName, ReportsDetails reportsDetails) throws HWFServiceException, ALOCReportException, IOException;
}
