/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ILookupDAO.java
 * Purpose: ILookupDAO used for the all the lookup DAO declarations
 */
package com.ge.aloc.dao;

import java.util.List;

import com.ge.aloc.IServiceClientAware;
import com.ge.aloc.model.MDM.BankDetails;
import com.ge.aloc.model.ReportsDetails;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author srikanth.bayyannagari
 *
 */
public interface IReportsDAO extends IServiceClientAware {

	/**
	 * 
	 * @throws HWFServiceException
	 */
	public ReportsDetails callContingentReportExport(ReportsDetails reportsDetails) throws HWFServiceException;

	/**
	 * @return
	 * @throws HWFServiceException
	 */
	public String getMORRates(String selectedCurrency) throws HWFServiceException; 

	/**
	 * @return BidSuccessDetails
	 * @throws HWFServiceException
	 */
	public ReportsDetails exportReportDetails(String reportName, ReportsDetails reportsDetails) throws HWFServiceException;
	
	/**
	 * Method to get Bank Details List from Local Environment
	 * @param bankName
	 * @return
	 * @throws HWFServiceException
	 */
	public List<BankDetails> invokeBankDetails() throws HWFServiceException;
	
	/**
	  * Method to get Max Aging Months for Aging Report selected search criteria.
	 * @param requestorName
	 * @return
	 * @throws HWFServiceException
	 */
	public ReportsDetails getMaxAgingMonths(String SSOID, String agingFlag, String inAgingMonths)throws HWFServiceException;
	
}
