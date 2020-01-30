/**
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: IAdhocReportManager.java
 * Purpose: IAdhocReportManager used for the Ad-hoc Report
 */

package com.ge.aloc.manager.reports;

import java.util.List;

import com.ge.aloc.model.ADHOCReports;
import com.ge.aloc.model.MDM.Currency;
import com.ge.aloc.model.Template;
import com.ge.aloc.reports.adhoc.AdhocReportTabType;
import com.hydus.hwf.exceptions.HWFServiceException;


public interface IAdhocReportManager {
	
	/**
	 * Method to get All user Report Templates as well as Published Reports
	 * @return
	 */
	public ADHOCReports getReportTemplates(AdhocReportTabType adhocReportTabType) throws HWFServiceException;
	
	public Template getTemplate(String templateId) throws HWFServiceException ;
	
	/**
	 * Method for Saving the Template
	 * @param template
	 * @throws HWFServiceException
	 */

	public Template saveTemplate(Template template) throws HWFServiceException;

	
	/**
	 * Method to get Spotfire Query Report ID 
	 * @param template
	 * @throws HWFServiceException
	 */

	public Template prepareSpotfireQuery(Template template) throws HWFServiceException;
	
	/**
	 * Method to delete the Template
	 * @param templateId
	 * @return
	 * @throws HWFServiceException
	 */
	public void deleteTemplate(String templateId) throws HWFServiceException;

	/**
	 * Method to get Currencies without code for Reports
	 * @return
	 * @throws HWFServiceException
	 */
	public List<Currency> getReportCurrency() throws HWFServiceException;
}
