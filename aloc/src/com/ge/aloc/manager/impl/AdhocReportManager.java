package com.ge.aloc.manager.impl;

import java.util.List;

import com.ge.aloc.dao.IAdhocReportDAO;
import com.ge.aloc.manager.reports.IAdhocReportManager;
import com.ge.aloc.model.ADHOCReports;
import com.ge.aloc.model.MDM.Currency;
import com.ge.aloc.model.Template;
import com.ge.aloc.reports.adhoc.AdhocReportTabType;
import com.hydus.hwf.exceptions.HWFServiceException;
public class AdhocReportManager implements IAdhocReportManager {

	private IAdhocReportDAO adhocDAO;

	/**
	 * @return the adhocDAO
	 */
	public IAdhocReportDAO getAdhocDAO() {
		return adhocDAO;
	}

	/**
	 * @param adhocDAO the adhocDAO to set
	 */
	public void setAdhocDAO(IAdhocReportDAO adhocDAO) {
		this.adhocDAO = adhocDAO;
	}

	/**
	 * Method to get User Related Templates
	 * 
	 */
	public ADHOCReports getReportTemplates(AdhocReportTabType adhocReportTabType) throws HWFServiceException{
		return adhocDAO.getReportTemplates(adhocReportTabType);
	}
	
	/**
	 * Method to open the selected Template
	 * @throws HWFServiceException 
	 */
	public Template getTemplate(String templateId) throws HWFServiceException {
		return adhocDAO.getTemplate(templateId);
	}

	/**
	 * Method for Saving the Template
	 * @param template
	 * @throws HWFServiceException
	 */
	public Template saveTemplate(Template template) throws HWFServiceException{
		return adhocDAO.saveTemplate(template);
		
	}
	/**
	 * Method for get Spotfire Query Report ID
	 * @param template
	 * @throws HWFServiceException
	 */
	public Template prepareSpotfireQuery(Template template) throws HWFServiceException{
		return adhocDAO.prepareSpotfireQuery(template);
	}

	/**
	 * @see com.ge.aloc.manager.reports.IAdhocReportManager#deleteTemplate(String)
	 */
	public void deleteTemplate(String templateId) throws HWFServiceException {
		adhocDAO.deleteTemplate(templateId);
	}

	/**
	 *  Method for Getting Currency for Report
	 * @throws HWFServiceException 
	 */
	public List<Currency> getReportCurrency() throws HWFServiceException {
		return adhocDAO.getReportCurrency();
	}
	
	
	
	
	
}
