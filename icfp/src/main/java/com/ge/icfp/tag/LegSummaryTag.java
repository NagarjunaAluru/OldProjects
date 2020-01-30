/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: LegSummaryTag.java
 * Purpose: LegSummaryTag used for the leg attributes.
 */
package com.ge.icfp.tag;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;

import com.ge.icfp.action.ICFPException;
import com.ge.icfp.common.vo.LegSummaryVO;

/**
 * @author arijit.biswas
 *
 */
public class LegSummaryTag extends TagSupport {
	/**
	 * logger
	 */
	private static final Logger logger = Logger.getLogger(LegSummaryTag.class);
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -552612544683208303L;
	/**
	 * propertyFilename
	 */
	private static String propertyFilename = "properties/legSummary.properties";
	/**
	 * propetyAttributKey
	 */
	private static String propetyAttributKey = "legSummary_property";
	/**
	 * properties
	 */
	private Properties properties = null;
	/**
	 * property
	 */
	private String property;
	/**
	 * name
	 */
	private String name;
	/**
	 * addLegButton
	 */
	private boolean addLegButton;
	/**
	 * tableId
	 */
	private String tableId;
	/**
	 * styleClass
	 */
	private String styleClass;
	/**
	 * viewType
	 */
	private String viewType;
	
	/**
	 * getViewType
	 * @return
	 */
	public String getViewType() {
		return viewType;
	}
	/**
	 * setViewType
	 * @param viewType
	 */
	public void setViewType(String viewType) {
		this.viewType = viewType;
	}

	/**
	 * @return the properties
	 */
	public Properties getProperties() {
		return properties;
	}

	/**
	 * @param properties the properties to set
	 */
	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	/**
	 * @return the property
	 */
	public String getProperty() {
		return property;
	}

	/**
	 * @param property the property to set
	 */
	public void setProperty(String property) {
		this.property = property;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the addLegButton
	 */
	public boolean isAddLegButton() {
		return addLegButton;
	}

	/**
	 * @param addLegButton the addLegButton to set
	 */
	public void setAddLegButton(boolean addLegButton) {
		this.addLegButton = addLegButton;
	}

	/**
	 * @return the tableId
	 */
	public String getTableId() {
		return tableId;
	}

	/**
	 * @param tableId the tableId to set
	 */
	public void setTableId(String tableId) {
		this.tableId = tableId;
	}

	/**
	 * @return the styleClass
	 */
	public String getStyleClass() {
		return styleClass;
	}

	/**
	 * @param styleClass the styleClass to set
	 */
	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}

	/**
	 * doStartTag
	 */
	public int doStartTag() throws JspException {
		if(property == null)
			return SKIP_BODY;
		if( pageContext.getAttribute(propetyAttributKey) == null ){
			loadProperties();
		}else{
			properties = (Properties) pageContext.getAttribute(propetyAttributKey);
		}
		Object bean = pageContext.findAttribute( name );
		Object value = null;
		try {
			value = PropertyUtils.getProperty(bean,property);
		} catch (IllegalAccessException e1) {
			throw new JspException("lookup.access error for " + property + "in " +name, e1);
		} catch (InvocationTargetException e1) {
			throw new JspException("lookup.access error for " + property + "in " +name, e1);
		} catch (NoSuchMethodException e1) {
			throw new JspException("lookup.access error for " + property + "in " +name, e1);
		}
		@SuppressWarnings("unchecked")
		List <LegSummaryVO> legSummary =  ((ArrayList<LegSummaryVO>) value);
		
		StringBuilder returnString = new StringBuilder();
		if(addLegButton){
			returnString.append("<a href=\"#\" id=\"edit-legs\" class=\"cancel btn default\" data-keyboard=\"true\" data-backdrop=\"true\" data-controls-modal=\"modal-from-dom\" onclick=\"javascript:openAddLeg();\">Add a Leg</a><br><br>");
		}
		returnString.append("<table class=\"").append(styleClass)
			.append("\" style=\"display: table;\" id=\"").append(tableId).append("\">");
		returnString.append(returnColumnHeaders());
		try {
			returnString.append(returnRowDetails(legSummary));
		} catch (ICFPException e1) {
			logger.error(e1.getStackTrace());
			throw new JspException(e1);
		}
		returnString.append("</tbody></table>");
		try{
			pageContext.getOut().write(returnString.toString());
		}catch(IOException e){
			logger.error(e.getStackTrace());
			throw new JspException(e);
		}
		return SKIP_BODY;
	}
	/**
	 * returnRowDetails
	 * @param legSummary
	 * @return
	 * @throws ICFPException 
	 */
	private String returnRowDetails(List <LegSummaryVO> legSummary) throws ICFPException {
		StringBuffer rowHeaders=new StringBuffer();
		if(legSummary != null){
			for(int i=0;i<legSummary.size();i++){
				rowHeaders.append("<tr>");
				rowHeaders.append("<td><a href=\"#\" data-nested=\"nested").append(i+1).append("\" class=\"exp\"></td>");

				if(viewType.equalsIgnoreCase("radio")) {
					rowHeaders.append("<td>").append("<input type='radio' value='")
					.append(legSummary.get(i).getLegNumber()).append("' name='optionsRadios'>").append("</td>");
				} else {
					rowHeaders.append("<td><a href=\"javascript:void(0);\" id=\"deleteLeg\" title=\"Delete this exception\" class=\"delete-tr\" onclick=\"javascript:removeLeg(this);\">X</a></td>");
					rowHeaders.append("<td><a href=\"javascript:void(0);\" id=\"edit-legs\" class=\"edit-leg ttip\" data-original-title=\"Edit this leg\" onclick=\"javascript:modifyLeg(this);\"></a></td>");
				}
				
				rowHeaders.append("<td>").append(legSummary.get(i).getLegNumber()).append("</td>");
				rowHeaders.append("<td>").append(legSummary.get(i).getProductType()).append("</td>");
				rowHeaders.append("<td>").append(legSummary.get(i).getTermsInMths()).append("</td>");
				rowHeaders.append("<td>").append(legSummary.get(i).getLenderLegalEntity()).append("</td>");
				rowHeaders.append("<td>").append(legSummary.get(i).getLenderCountry()).append("</td>");
				rowHeaders.append("<td>").append(legSummary.get(i).getBorrowerLegalEntity()).append("</td>");
				rowHeaders.append("<td>").append(legSummary.get(i).getBorrowerCountry()).append("</td>");
				rowHeaders.append("<td>").append(legSummary.get(i).getOriginalCurrency()).append("</td>");
				rowHeaders.append("<td>").append(legSummary.get(i).getOriginalAmount()).append("</td>");
				rowHeaders.append("<td>").append(legSummary.get(i).getUsdEquivalent()).append("</td>");
				rowHeaders.append("<td>").append(legSummary.get(i).getDerivatives()).append("</td>");
				rowHeaders.append("<td>").append(legSummary.get(i).getExisting()).append("</td>");
				rowHeaders.append("</tr>");
			}
		}else{
			rowHeaders.append("<tr class=\"odd1\">");
			rowHeaders.append("<td>-</td>");
			rowHeaders.append("<td>-</td>");
			rowHeaders.append("<td>-</td>");
			rowHeaders.append("<td>-</td>");
			rowHeaders.append("<td>-</td>");
			rowHeaders.append("<td>-</td>");
			rowHeaders.append("<td>-</td>");
			rowHeaders.append("<td>-</td>");
			rowHeaders.append("<td>-</td>");
			rowHeaders.append("<td>-</td>");
			rowHeaders.append("<td>-</td>");
			rowHeaders.append("<td>-</td>");
			rowHeaders.append("<td>-</td>");
			rowHeaders.append("<td>-</td>");
			rowHeaders.append("<td>-</td>");
			rowHeaders.append("</tr>");
		}
		return rowHeaders.toString();
	}
	/**
	 * returnColumnHeaders
	 * @return
	 */
	private String returnColumnHeaders(){
		StringBuffer colHeaders=new StringBuffer();
		colHeaders.append("<thead><tr>");
		
		if(viewType.equalsIgnoreCase("radio")) {
			colHeaders.append("<th class=\"header\" rowspan=\"2\">").append(properties.getProperty("columnHeader.select")).append("</th>");
		} else {
			colHeaders.append("<th class=\"header\" rowspan=\"2\">").append(properties.getProperty("columnHeader.blank")).append("</th>");
			colHeaders.append("<th class=\"header\" colspan=\"2\" rowspan=\"2\" style=\"text-align: center;\">").append(properties.getProperty("columnHeader.action")).append("</th>");
		}
		
	
		colHeaders.append("<th class=\"header\" rowspan=\"2\">").append(properties.getProperty("columnHeader.legNo")).append("</th>");
		colHeaders.append("<th class=\"header\" rowspan=\"2\">").append(properties.getProperty("columnHeader.productType")).append("</th>");
		colHeaders.append("<th class=\"header\" rowspan=\"2\">").append(properties.getProperty("columnHeader.term")).append("</th>");
		colHeaders.append("<th class=\"header\" colspan=\"2\">").append(properties.getProperty("columnHeader.lender")).append("</th>");
		colHeaders.append("<th class=\"header\" colspan=\"2\">").append(properties.getProperty("columnHeader.borrower")).append("</th>");
		colHeaders.append("<th class=\"header\" colspan=\"2\">").append(properties.getProperty("columnHeader.origCurr")).append("</th>");
		colHeaders.append("<th class=\"header\" rowspan=\"2\">").append(properties.getProperty("columnHeader.usdEquivalent")).append("</th>");
		colHeaders.append("<th class=\"header\" rowspan=\"2\">").append(properties.getProperty("columnHeader.derivatives")).append("</th>");
		colHeaders.append("<th class=\"header\" rowspan=\"2\">").append(properties.getProperty("columnHeader.existing")).append("</th>");
		colHeaders.append("</tr><tr>");
		colHeaders.append("<th class=\"header\">").append(properties.getProperty("columnHeader.legalEntity")).append("</th>");
		colHeaders.append("<th class=\"header\">").append(properties.getProperty("columnHeader.country")).append("</th>");
		colHeaders.append("<th class=\"header\">").append(properties.getProperty("columnHeader.legalEntity")).append("</th>");
		colHeaders.append("<th class=\"header\">").append(properties.getProperty("columnHeader.country")).append("</th>");
		colHeaders.append("<th class=\"header\">").append(properties.getProperty("columnHeader.currency")).append("</th>");
		colHeaders.append("<th class=\"header\">").append(properties.getProperty("columnHeader.amount")).append("</th>");
		colHeaders.append("</thead><tbody>");
		return colHeaders.toString();
	}
	
	/**
	 * Load the properties to PageContext Attribute so it can be reused 
	 * for all tags in same JSP.
	 * 
	 * @throws JspException
	 */
	private void loadProperties() throws JspException {
		
		InputStream is =
				LegSummaryTag.class.getClassLoader().getResourceAsStream( propertyFilename );

		if (properties == null)
			properties = new Properties();
		try {
			properties.load(is);
		} catch (IOException e) {
			if (logger.isDebugEnabled()) {
				logger.error(e.getMessage(), e);
			}
			throw  new JspException("Unable to load properties file " + propertyFilename);
		}
		
		pageContext.setAttribute( propetyAttributKey , properties );
		
	}
	
}
