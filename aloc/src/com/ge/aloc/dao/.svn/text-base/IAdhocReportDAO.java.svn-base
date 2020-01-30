/**
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: IAdhocReportDAO.java
 * Purpose: IAdhocReportDAO used for the all Ad-hoc Reporting Services
 */
package com.ge.aloc.dao;

import java.util.List;

import com.ge.aloc.IServiceClientAware;
import com.ge.aloc.model.ADHOCReports;
import com.ge.aloc.model.MDM;
import com.ge.aloc.model.Template;
import com.ge.aloc.reports.adhoc.AdhocReportTabType;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author nagarjun.p
 *
 */
public interface IAdhocReportDAO extends IServiceClientAware{
	
	/**
	 * 
	 * Method for Saving the Template
	 * @throws HWFServiceException
	 */
	public Template saveTemplate(Template template) throws HWFServiceException;
	
	/**
	 * Method to Open Report 
	 * @param templateId
	 * @return
	 * @throws HWFServiceException
	 */
	public Template getTemplate(String templateId) throws HWFServiceException;
	
	/**
	 * Method to get all Report Templates
	 * @param adhocReportTabType
	 * @return
	 */
	public ADHOCReports getReportTemplates(AdhocReportTabType adhocReportTabType) throws HWFServiceException;
	
	/**
	 * Method to get The spotfire query Id
	 * @param template
	 * @return
	 * @throws HWFServiceException
	 */
	
	public Template prepareSpotfireQuery(Template template) throws HWFServiceException;

	/**
	 * Method to delete the Template
	 * @param templateId
	 * @return
	 * @throws HWFServiceException
	 */
	public Template deleteTemplate(String templateId) throws HWFServiceException;
	
	/**
	 * Method to load Currency without Code for Reports
	 * @return
	 * @throws HWFServiceException 
	 */
	public List<MDM.Currency> getReportCurrency() throws HWFServiceException;
}
