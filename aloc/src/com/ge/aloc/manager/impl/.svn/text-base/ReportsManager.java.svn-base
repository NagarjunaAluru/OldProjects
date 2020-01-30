/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: RequestDetailsManager.java
 * Purpose: RequestDetailsManager used for the all request operations
 */
package com.ge.aloc.manager.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.dao.IReportsDAO;
import com.ge.aloc.manager.reports.IReportsManager;
import com.ge.aloc.model.ContingentliabilityDetails;
import com.ge.aloc.model.ReportsDetails;
import com.ge.aloc.model.MDM.BankDetails;
import com.ge.aloc.reports.ALOCReportException;
import com.ge.aloc.util.ReportsHelper;
import com.hydus.hwf.exceptions.HWFServiceException;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author srikanth.bayyannagari
 *
 */
public class ReportsManager extends ActionSupport implements IReportsManager {
	private static final long serialVersionUID = 1L;
	private IReportsDAO reportsDAO;

	/**
	 * (non-Javadoc)
	 * @throws HWFServiceException 
	 * @throws ALOCReportException 
	 * @throws IOException 
	 * @see com.ge.aloc.manager.reports.IReportsManager#callExportExcel(com.ge.aloc.model.ReportsDetails[])
	 */
	public void callContingentReportExport(String reportName, ReportsDetails reportsDetails1, String fileName, Boolean isExternal) throws HWFServiceException, ALOCReportException, IOException {
		ReportsDetails reportsDetails = reportsDAO.callContingentReportExport(reportsDetails1);
		List<ContingentliabilityDetails> contingentList = new ArrayList<ContingentliabilityDetails>();
		contingentList = reportsDetails.getContingentliabilityDetails();
		if(contingentList.isEmpty())
			ReportsHelper.generateExcelReport(reportName, reportsDetails, fileName, isExternal);
		else
			ReportsHelper.callContingentReportExport(reportsDetails, fileName);
	}

	/**
	 * @throws HWFServiceException
	 * @throws ALOCReportException
	 * @see com.ge.aloc.manager.reports.IReportsManager#exportBidSuccessResults()
	 */
	public void exportReportDetails(String reportName, ReportsDetails reportsDetails1, String fileName, Boolean isExternal) throws HWFServiceException, ALOCReportException,IOException {
		ReportsDetails reportsDetails = reportsDAO.exportReportDetails(reportName, reportsDetails1);
		if(reportName.equalsIgnoreCase(ALOCConstants.FEEPROJECTIONREPORT)){
			HttpServletRequest request = ServletActionContext.getRequest();
			request.getSession().setAttribute(ALOCConstants.SELECTEDNOMONTHS, reportsDetails1.getFeeProjectionDetails().get(ALOCConstants.BASE_VALUE).getINNUMMONTHS());
		}
		
		ReportsHelper.generateExcelReport(reportName, reportsDetails, fileName, isExternal);
	}
	
	/**
	 * Method to get records count for All Reports
	 * @throws HWFServiceException
	 * @throws ALOCReportException
	 * @throws IOException
	 */
	public ReportsDetails recordsCountDetails(String reportName, ReportsDetails reportsDetails1) throws HWFServiceException, ALOCReportException,IOException {
		ReportsDetails reportsDetails = reportsDAO.exportReportDetails(reportName, reportsDetails1);
		return reportsDetails;
	}
	
	/**
	 * This method is used to get MOR Rates
	 * Service call to getMORRates
	 */
	public String getMORRates(String selectedCurrency) throws HWFServiceException {
		String MORRates =  reportsDAO.getMORRates(selectedCurrency);
		return MORRates;
	}

	/**
	 * This method is used to create reportsDAO instance
	 * @return the reportsDAO
	 */
	public IReportsDAO getReportsDAO() {
		return reportsDAO;
	}

	/**
	 * This method is used to set reportsDAO instance
	 * @param reportsDAO the reportsDAO to set
	 */
	public void setReportsDAO(IReportsDAO reportsDAO) {
		this.reportsDAO = reportsDAO;
	}
	
	/**
	 * @see com.ge.aloc.manager.ILookupManager#getAlocBankDetails(String)
	 */
	public List<BankDetails> getAlocBankDetails() throws HWFServiceException {
		return reportsDAO.invokeBankDetails();
	}
	
	/**
	 * @see com.ge.aloc.dao.ILookupDAO#getMaxAgingMonths()
	 */
	public ReportsDetails getMaxAgingMonths(String SSOID, String agingFlag, String inAgingMonths)throws HWFServiceException {
		return reportsDAO.getMaxAgingMonths(SSOID, agingFlag, inAgingMonths);
	}
}
