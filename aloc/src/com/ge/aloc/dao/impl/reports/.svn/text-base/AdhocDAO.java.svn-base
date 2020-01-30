/**
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: AdhocDAO.java
 * AdhocDAO used to implement operations for Ad-hoc Report
 */

package com.ge.aloc.dao.impl.reports;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.ge.aloc.OpCode;
import com.ge.aloc.ServiceClientSupport;
import com.ge.aloc.dao.IAdhocReportDAO;
import com.ge.aloc.model.ADHOCReports;
import com.ge.aloc.model.MDM;
import com.ge.aloc.model.MsgHeader;
import com.ge.aloc.model.Template;
import com.ge.aloc.reports.adhoc.AdhocReportTabType;
import com.ge.aloc.util.ALOCCommonHelper;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author nagarjun.P
 * @
 */

public class AdhocDAO extends ServiceClientSupport implements IAdhocReportDAO{
	
	
	/**
	 * Method for Saving the Template
	 * @param template
	 * @throws HWFServiceException
	 */
	public Template saveTemplate(Template template) throws HWFServiceException
	{
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.INSERT.getOperationCode());
		template.setMsgHeader(msgHeader);
		template = serviceClient.invokeService(OpCode.ADHOCOPERATIONS.getOperationCode(), template, Template.class);
		return template;
	}
	
	/**
	 * 
	 * @param adhocReportTabType
	 * @return
	 * @throws HWFServiceException 
	 */
	public ADHOCReports getReportTemplates(AdhocReportTabType adhocReportTabType) throws HWFServiceException{
		ADHOCReports adhocReports = new ADHOCReports();
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(adhocReportTabType.getOpCode().getOperationCode());
		
		adhocReports.setMsgHeader(msgHeader);
		adhocReports = serviceClient.invokeService(OpCode.ADHOCREPORTS.getOperationCode(), adhocReports, ADHOCReports.class);
		return adhocReports;
	}
	
	/**
	 * Method to get the Spotfire Query Report ID
	 * @param template
	 * @throws HWFServiceException
	 */
	
	public Template prepareSpotfireQuery(Template template) throws HWFServiceException{
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.SAVEREPORT.getOperationCode());
		template.setMsgHeader(msgHeader);
		template = serviceClient.invokeService(OpCode.ADHOCOPERATIONS.getOperationCode(), template, Template.class);
		return template;
	}
	
	/**
	 * @see com.ge.aloc.dao.IAdhocReportDAO#getTemplate(String)
	 */
	public Template getTemplate(String templateId) throws HWFServiceException {
		Template template = new Template();
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.GETTEMPLATE.getOperationCode());
		template.setMsgHeader(msgHeader);
		template.setTemplateID(new BigInteger(templateId));
		template = serviceClient.invokeService(OpCode.ADHOCOPERATIONS.getOperationCode(), template, Template.class);
		return template;
	}
	
	/**
	 * @see com.ge.aloc.dao.IAdhocReportDAO#deleteTemplate(String)
	 */
	public Template deleteTemplate(String templateId) throws HWFServiceException {
		Template template = new Template();
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.DELETETEMPLATE.getOperationCode());
		template.setMsgHeader(msgHeader);
		template.setTemplateID(new BigInteger(templateId));
		template = serviceClient.invokeService(OpCode.ADHOCOPERATIONS.getOperationCode(), template, Template.class);
		return template;
	}

	/**
	 *  @throws HWFServiceException 
	 * @see com.ge.aloc.dao.IAdhocReportDAO#getReportCurrency()
	 */
	public List<MDM.Currency> getReportCurrency() throws HWFServiceException {
		MDM mdmObject = new MDM();
		List<MDM.Currency> currencies = new ArrayList<MDM.Currency>();
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.CURRENCYDETAILSFORREPORTS.getOperationCode());
		mdmObject.setMsgHeader(msgHeader);
		mdmObject = serviceClient.invokeService(OpCode.MDM.getOperationCode(),mdmObject , MDM.class);
		currencies = mdmObject.getCurrencies();
		return currencies;
	}

}
