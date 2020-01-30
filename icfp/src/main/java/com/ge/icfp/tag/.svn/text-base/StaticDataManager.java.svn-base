/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: StaticDataManager.java
 * Purpose: StaticDataManager used to retrieve the Static data.
 */
package com.ge.icfp.tag;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import javax.servlet.jsp.PageContext;

import com.ge.icfp.common.vo.NameValueVO;
import com.ge.icfp.model.NameValue;
import com.ge.icfp.model.StaticDataManagement;
import com.ge.icfp.util.StaticDataFactory;
import com.hydus.wff.core.exception.HWFServiceException;
import com.hydus.wff.core.exception.HWFStubException;

/**
 * @author srinivasan.desa
 *
 */
public class StaticDataManager {

	/**
	 * 
	 * @param pageContext
	 * @return
	 * @throws HWFServiceException 
	 * @throws HWFStubException 
	 */
	public static List<NameValue> getDealCategories(PageContext pageContext) throws HWFServiceException, HWFStubException {
		StaticDataFactory staticDataFactory = (StaticDataFactory) pageContext.getServletContext().getAttribute(StaticDataFactory.CTX_KEY);
		return staticDataFactory.getDealCategories();
	}
	/**
	 * 
	 * @param pageContext
	 * @return
	 * @throws HWFServiceException 
	 * @throws HWFStubException 
	 */
	public static List<NameValue> getDerivativeTypes(PageContext pageContext) throws HWFServiceException, HWFStubException {
		StaticDataFactory staticDataFactory = (StaticDataFactory) pageContext.getServletContext().getAttribute(StaticDataFactory.CTX_KEY);
		return staticDataFactory.getDerivativeTypes();
	}
	/**
	 * 
	 * @param pageContext
	 * @return
	 * @throws HWFServiceException
	 * @throws HWFStubException
	 */
	public static List<NameValue> getProductTypes(PageContext pageContext) throws HWFServiceException, HWFStubException {
		StaticDataFactory staticDataFactory = (StaticDataFactory) pageContext.getServletContext().getAttribute(StaticDataFactory.CTX_KEY);
		return staticDataFactory.getAllProductTypes();
	}
	/**
	 * 
	 * @param pageContext
	 * @return
	 * @throws HWFServiceException 
	 * @throws HWFStubException 
	 */
	public static List<NameValue> getHedgeDesignation(PageContext pageContext) throws HWFServiceException, HWFStubException {
		StaticDataFactory staticDataFactory = (StaticDataFactory) pageContext.getServletContext().getAttribute(StaticDataFactory.CTX_KEY);
		return staticDataFactory.getHedgeDesignation();
	}
	/**
	 * 
	 * @param pageContext
	 * @return
	 * @throws HWFServiceException 
	 * @throws HWFStubException 
	 */
	public static List<NameValue> getTaxDesignation(PageContext pageContext) throws HWFServiceException, HWFStubException {
		StaticDataFactory staticDataFactory = (StaticDataFactory) pageContext.getServletContext().getAttribute(StaticDataFactory.CTX_KEY);
		return staticDataFactory.getTaxDesignation();
	}
	/**
	 * 
	 * @param pageContext
	 * @return
	 * @throws HWFServiceException 
	 * @throws HWFStubException 
	 */
	public static List<NameValue> getInterestResetFreqs(PageContext pageContext) throws HWFServiceException, HWFStubException {
		StaticDataFactory staticDataFactory = (StaticDataFactory) pageContext.getServletContext().getAttribute(StaticDataFactory.CTX_KEY);
		return staticDataFactory.getInterestResetFreqs();
	}	
	/**
	 * 
	 * @param pageContext
	 * @return
	 * @throws HWFServiceException 
	 * @throws HWFStubException 
	 */
	public static List<NameValue> getHedgePrograms(PageContext pageContext) throws HWFServiceException, HWFStubException {
		StaticDataFactory staticDataFactory = (StaticDataFactory) pageContext.getServletContext().getAttribute(StaticDataFactory.CTX_KEY);
		return staticDataFactory.getHedgePrograms();
	}
	/**
	 * 
	 * @param pageContext
	 * @return
	 * @throws HWFServiceException 
	 * @throws HWFStubException 
	 */
	public static List<NameValue> getDayCounts(PageContext pageContext) throws HWFServiceException, HWFStubException {
		StaticDataFactory staticDataFactory = (StaticDataFactory) pageContext.getServletContext().getAttribute(StaticDataFactory.CTX_KEY);
		return staticDataFactory.getDayCounts();
	}
	/**
	 * 
	 * @param pageContext
	 * @return
	 * @throws HWFServiceException 
	 * @throws HWFStubException 
	 */
	public static List<NameValue> getContractClass(PageContext pageContext) throws HWFServiceException, HWFStubException {
		StaticDataFactory staticDataFactory = (StaticDataFactory) pageContext.getServletContext().getAttribute(StaticDataFactory.CTX_KEY);
		return staticDataFactory.getContractClass();
	}	
	/**
	 * This method will get the solvency matrix details from static data factory
	 * @param pageContext
	 * @return
	 * @throws HWFServiceException
	 * @throws HWFStubException 
	 */
	public static List<StaticDataManagement.SolvencyMetricsCalc> getSolvencyMatrixList(PageContext pageContext) throws HWFServiceException, HWFStubException {
		StaticDataFactory staticDataFactory = (StaticDataFactory) pageContext.getServletContext().getAttribute(StaticDataFactory.CTX_KEY);
		for(int i=0;i<staticDataFactory.getSolvencyMatrixValues().size();i++){
			StaticDataManagement.SolvencyMetricsCalc obj = (StaticDataManagement.SolvencyMetricsCalc)staticDataFactory.getSolvencyMatrixValues().get(0);
		}
		return staticDataFactory.getSolvencyMatrixValues();
	}
	/**
	 * 
	 * @param pageContext
	 * @return
	 * @throws HWFServiceException
	 * @throws HWFStubException
	 */
	public static List<StaticDataManagement.ContactICF> getContactUsList(PageContext pageContext) throws HWFServiceException, HWFStubException {
		StaticDataFactory staticDataFactory = (StaticDataFactory) pageContext.getServletContext().getAttribute(StaticDataFactory.CTX_KEY);
		return staticDataFactory.getContactUsValues();
	}
	/**
	 * 
	 * @param pageContext
	 * @return
	 * @throws HWFServiceException
	 * @throws HWFStubException
	 */
	public static List<StaticDataManagement.WFStageDetails> getWorkFlowStageList(PageContext pageContext) throws HWFServiceException, HWFStubException {
		StaticDataFactory staticDataFactory = (StaticDataFactory) pageContext.getServletContext().getAttribute(StaticDataFactory.CTX_KEY);
		return staticDataFactory.getWorkFlowStageDetails();
	}
	/**
	 * getCertificateList Method is used to get Cert List
	 * @param pageContext
	 * @return
	 * @throws HWFServiceException
	 * @throws HWFStubException
	 */
	public static List<NameValue> getCertificateList(PageContext pageContext) throws HWFServiceException, HWFStubException {
		StaticDataFactory staticDataFactory = (StaticDataFactory) pageContext.getServletContext().getAttribute(StaticDataFactory.CTX_KEY);
		return staticDataFactory.getCertificateList();
	}
	
	public static List<NameValue> getSearchCriteria(PageContext pageContext) throws HWFServiceException, HWFStubException {
		StaticDataFactory staticDataFactory = (StaticDataFactory) pageContext.getServletContext().getAttribute(StaticDataFactory.CTX_KEY);
		return staticDataFactory.getSearchCriteria();
	}
	/**
	 * 
	 * @return
	 * @throws HWFServiceException
	 * @throws HWFStubException
	 */
	public static List<NameValueVO> getReportsURLS(PageContext pageContext) throws HWFServiceException, HWFStubException {
		List<NameValueVO> reportsList = new ArrayList<NameValueVO>();
 		try {
 			NameValueVO nvObj = null;
			Properties properties = new Properties();
			properties.load(StaticDataManager.class.getClassLoader().getResourceAsStream("properties/cognosReportsURLs.properties"));

			@SuppressWarnings("rawtypes")
			Enumeration enuKeys = properties.keys();
			while (enuKeys.hasMoreElements()) {
				String key = (String) enuKeys.nextElement();
				String value = properties.getProperty(key);
				nvObj = new NameValueVO();
				nvObj.setId(key.replace("_"," "));
				nvObj.setName(value);
				reportsList.add(nvObj);
			}
		} catch (FileNotFoundException e) {
			String errMsg = new StringBuilder().append("Unable to load file ").append("properties/cognosReportsURLs.properties").toString();
			throw new HWFServiceException(errMsg, e);
		} catch (IOException e) {
			String errMsg = new StringBuilder().append("Unable to read file ").append("properties/cognosReportsURLs.properties").toString();
			throw new HWFServiceException(errMsg, e);
		}

		
		return reportsList;
	}
	
	public static List<NameValue> getRegionResponsibility(PageContext pageContext) throws HWFServiceException, HWFStubException {
		StaticDataFactory staticDataFactory = (StaticDataFactory) pageContext.getServletContext().getAttribute(StaticDataFactory.CTX_KEY);
		return staticDataFactory.getRegionResponsibility();
	}
}
