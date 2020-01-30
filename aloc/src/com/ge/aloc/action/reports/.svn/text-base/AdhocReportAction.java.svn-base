/**
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: AdhocReportAction.java
 * Purpose: AdhocReportAction used for Ad-hoc ALOC Reports.
 *
 */
package com.ge.aloc.action.reports;

import java.io.IOException;
import java.io.Writer;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.ge.aloc.ALOCContext;
import com.ge.aloc.InstrumentType;
import com.ge.aloc.SiteType;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.manager.reports.IAdhocReportManager;
import com.ge.aloc.model.ADHOCReports;
import com.ge.aloc.model.AvailableSites;
import com.ge.aloc.model.MDM;
import com.ge.aloc.model.SiteAdminStaticData;
import com.ge.aloc.model.SiteAdminStaticData.SitesList;
import com.ge.aloc.model.Template;
import com.ge.aloc.reports.adhoc.AdhocReportTabType;
import com.ge.aloc.reports.adhoc.Field;
import com.ge.aloc.reports.adhoc.FieldManager;
import com.ge.aloc.reports.adhoc.TemplateBO;
import com.ge.aloc.util.JSONHelper;
import com.google.gson.JsonObject;
import com.hydus.hwf.exceptions.ErrorData;
import com.hydus.hwf.exceptions.HWFServiceException;
import com.hydus.hwf.exceptions.IErrorHandler;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author arijit.biswas
 *
 */
public class AdhocReportAction extends ReportDetailAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6991569615856520710L;
	private static final Logger LOGGER = Logger.getLogger(AdhocReportAction.class);
	private FieldManager fieldManager;
	
	private String fieldName;
	private String fieldId;
	private String templateId;
	private String templateName;
	private TemplateBO template ;
	private ADHOCReports adhocReports;
	protected AdhocReportTabType adhocReportTabType;
	private IAdhocReportManager adhocReportManager;
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response = ServletActionContext.getResponse();
	protected IErrorHandler errorHandler;
	protected List<MDM.Currency> reportCurrency;
	private Map<String, Object> sessionValues = ActionContext.getContext().getSession();
	
	
	/**
	 * Method to Open the Custom Report
	 * @throws HWFServiceException
	 * @return
	 */
	public String open() throws HWFServiceException {
		loadAdhocSiteNames();
		loadBankDtls();
		loadCurrencies();
		return ActionSupport.SUCCESS;
	}
	/**
	 * Method to open the Template from MyReports
	 * @return
	 * @throws HWFServiceException 
	 * @throws ParseException 
	 */
	public String openWithTemplate() throws HWFServiceException, ParseException {
		loadBankDtls();
		loadAdhocSiteNames();
		setTemplate(new TemplateBO(adhocReportManager.getTemplate(templateId)));
		return ActionSupport.SUCCESS;
	}
	
	/**
	 * Method to delete Template
	 * @return
	 * @throws HWFServiceException 
	 */
	public String deleteTemplate() throws HWFServiceException{
		String returnType = null;
		adhocReportManager.deleteTemplate(templateId);
		request.setAttribute(ALOCConstants.DELETEDTEMPLATE,templateName);
		if(adhocReportTabType == AdhocReportTabType.MYREPORTS){
			returnType = ALOCConstants.SUCCESSMYREPORT;
		}else if (adhocReportTabType == AdhocReportTabType.PUBLISHEDREPORTS){
			returnType = ALOCConstants.SUCCESSPUBLISHEDREPORT;
		}
		return returnType;
	}
	/**
	 * Method to render the filters drag and drop
	 * @return
	 */
	public String renderFilter() {
		return ActionSupport.SUCCESS;
	}
	
	/**
	 * Method to render the columns to drag and drop
	 * @return
	 */
	public String renderColumn() {
		return ActionSupport.SUCCESS;
	}
	
	/**
	 * Method to save Template
	 * @throws HWFServiceException
	 * @return
	 */
	public String saveTemplate() throws HWFServiceException, ParseException{
		try{
			Template templateModel = template.getTemplate();
			
			templateModel = adhocReportManager.saveTemplate(templateModel);
			if(templateModel.getTemplateID() != null){
				JSONHelper.writeSuccessResponse(templateModel.getTemplateID(), response);
			}
		}
		catch(HWFServiceException hse){	
			ErrorData errorData = errorHandler.handle(hse);
			JSONHelper.writeFailureResponse(errorData.getCode(), errorData.getCause().getMessage(), response);
			return null;
		}
		return null;
	}
		
	/**
	 * Method for field search
	 * @return
	 * @throws IOException 
	 */
	public String searchFields() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		String[] instrumentTypes = request.getParameterValues(ALOCConstants.INSTRUMENT_TYPES);
		response.setContentType(ALOCConstants.TEXT_XML);
		Writer writer = null;
		InstrumentType[] instrTypes = null;
		if(instrumentTypes == null){
			instrTypes = (template != null && template.getInstrumentTypeObjects() != null) 
				? template.getInstrumentTypeObjects() : InstrumentType.values();
		}
		else{
				instrTypes = new InstrumentType[instrumentTypes.length];
				int i=ALOCConstants.BASE_VALUE;
				for(String instId : instrumentTypes){
					instrTypes[i++] = InstrumentType.fromId(Integer.valueOf(instId));
				}
		}
		
		try {
			writer = response.getWriter();
			fieldManager.search(fieldName, instrTypes, writer);
		} finally {
			try {
				if(writer != null) {
					writer.close();
				}
			} catch (IOException ioe) {
				String errMsg = new StringBuilder().append(ALOCConstants.ADHOC_REPORT_WRITER_OBJECT_ERROR_MSG).toString();
				LOGGER.warn(errMsg, ioe);
			}
		}
		return null;
	}
	
	/**
	 * Method to prepare the Spotfire Query 
	 * @throws HWFServiceException
	 * @return
	 */
	public String prepareSpotfireQuery() throws HWFServiceException, ParseException{
		Template templateObj = template.getTemplate();
		templateObj = adhocReportManager.prepareSpotfireQuery(templateObj);
		if(templateObj.getTemplateID() != null){
			JsonObject result = new JsonObject();
			result.addProperty(ALOCConstants.JSON_PROP_DATA, templateObj.getTemplateID());
			JSONHelper.writeResponse(result, response);
		}
		
		return null;
	}
	
	/**
	 * Method to get the Available Reports
	 * @return
	 */
	public String getAvailableReports() throws HWFServiceException{
		if(adhocReportTabType != null){
			adhocReports = adhocReportManager.getReportTemplates(adhocReportTabType);
		}
		return ActionSupport.SUCCESS;
	}
	
	/**
	 * Method to get the field Id
	 * @param fieldId
	 * @return
	 */
	public Field getField(String fieldId) {
		return fieldManager.getField(fieldId);
	}
	
	/**
	 * Method to load all the sites
	 * @return
	 * @throws HWFServiceException
	 */
	public void loadAdhocSiteNames() throws HWFServiceException{
		
		List<SiteAdminStaticData.SitesList> siteTypes = ALOCContext.getStaticDataFactory().getAllSites();
		availableSitesList = new ArrayList<AvailableSites>();
		AvailableSites availableSites = null;
		for(SitesList eachSite : siteTypes) {
			availableSites = new AvailableSites();
			BigInteger siteTypeId = eachSite.getSiteTypeId();
			SiteType siteType = (siteTypeId != null) ? SiteType.fromId(siteTypeId.intValue()) : null;
			if(siteType != null && (siteType == SiteType.FINANCIAL_BUSINESS_SITE || siteType == SiteType.INDUSTRAIL_BUSINESS_SITE )){
				availableSites.setSiteId(eachSite.getSiteId().intValue());
				availableSites.setSiteName(eachSite.getSiteName());
				availableSitesList.add(availableSites);
			}
		}
	}
	
	/**
	 * Method to load the currencies without Currency Code
	 * @throws HWFServiceException
	 */
	public void loadCurrencies() throws HWFServiceException{
		reportCurrency = new ArrayList<MDM.Currency>();
		reportCurrency = adhocReportManager.getReportCurrency();
		sessionValues.put(ALOCConstants.REPORTCURRENCY, reportCurrency);
		
	}
	
	
	/**
	 * Method to reset all selected sites and Banks
	 * @return
	 * @throws HWFServiceException
	 */
	public String resetSitesAndBanks() throws HWFServiceException{
		return ALOCConstants.SUCCESS;
	}
	
	
	/************************************************
	 ******* Getters and Setters********************* 
	 ************************************************/
	
	/**
	 * @return the fieldName
	 */
	public String getFieldName() {
		return fieldName;
	}

	/**
	 * @param fieldName the fieldName to set
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	/**
	 * @return the fieldId
	 */
	public String getFieldId() {
		return fieldId;
	}

	/**
	 * @param fieldId the fieldId to set
	 */
	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
	}

	/**
	 * @return the template
	 */
	public TemplateBO getTemplate() {
		return template;
	}

	/**
	 * @param template the template to set
	 */
	public void setTemplate(TemplateBO template) {
		this.template = template;
	}

	/**
	 * @return the fieldManager
	 */
	public FieldManager getFieldManager() {
		return fieldManager;
	}

	/**
	 * @param fieldManager the fieldManager to set
	 */
	public void setFieldManager(FieldManager fieldManager) {
		this.fieldManager = fieldManager;
	}
	/**
	 * @return the adhocReportManager
	 */
	public IAdhocReportManager getAdhocReportManager() {
		return adhocReportManager;
	}
	/**
	 * @param adhocReportManager the adhocReportManager to set
	 */
	public void setAdhocReportManager(IAdhocReportManager adhocReportManager) {
		this.adhocReportManager = adhocReportManager;
	}
	/**
	 * @return the templateName
	 */
	public String getTemplateName() {
		return templateName;
	}
	/**
	 * @param templateName the templateName to set
	 */
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	/**
	 * @return the templateId
	 */
	public String getTemplateId() {
		return templateId;
	}
	/**
	 * @param templateId the templateId to set
	 */
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
	/**
	 * @return the adhocReports
	 */
	public ADHOCReports getAdhocReports() {
		return adhocReports;
	}
	/**
	 * @param adhocReports the adhocReports to set
	 */
	public void setAdhocReports(ADHOCReports adhocReports) {
		this.adhocReports = adhocReports;
	}
	/**
	 * @return the adhocReportTabType
	 */
	public AdhocReportTabType getAdhocReportTabType() {
		return adhocReportTabType;
	}
	/**
	 * @param adhocReportTabType the adhocReportTabType to set
	 */
	public void setAdhocReportTabType(AdhocReportTabType adhocReportTabType) {
		this.adhocReportTabType = adhocReportTabType;
	}
	
	/**
	 * @return the errorHandler
	 */
	public IErrorHandler getErrorHandler() {
		return errorHandler;
	}
	/**
	 * @param errorHandler the errorHandler to set
	 */
	public void setErrorHandler(IErrorHandler errorHandler) {
		this.errorHandler = errorHandler;
	}
	/**
	 * @return the reportCurrency
	 */
	public List<MDM.Currency> getReportCurrency() {
		return reportCurrency;
	}
	/**
	 * @param reportCurrency the reportCurrency to set
	 */
	public void setReportCurrency(List<MDM.Currency> reportCurrency) {
		this.reportCurrency = reportCurrency;
	}
	
}
