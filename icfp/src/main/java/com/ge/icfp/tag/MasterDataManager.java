/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: MasterDataManager.java
 * Purpose: MasterDataManager used to retrieve the MDM data.
 */
package com.ge.icfp.tag;

import java.util.List;

import javax.servlet.jsp.PageContext;

import com.ge.icfp.common.vo.NameValueVO;
import com.ge.icfp.model.NameValue;
import com.ge.icfp.util.MasterDataFactory;
import com.hydus.wff.core.exception.HWFServiceException;
import com.hydus.wff.core.exception.HWFStubException;

/**
 * @author srinivasan.desa
 *
 */
public class MasterDataManager {
	/**
	 * getDealCurrencies
	 * @param pageContext
	 * @return
	 * @throws HWFServiceException
	 * @throws HWFStubException 
	 */
	public static List<NameValueVO> getDealCurrencies(PageContext pageContext)
			throws HWFServiceException, HWFStubException {
		MasterDataFactory masterDataFacotry = (MasterDataFactory) pageContext
				.getServletContext().getAttribute(MasterDataFactory.CTX_KEY);
		return masterDataFacotry.getDealCurrencies();
	}
	/**
	 * getFloatingIndex
	 * @param pageContext
	 * @return
	 * @throws HWFServiceException
	 * @throws HWFStubException 
	 */
	public static List<NameValue> getFloatingIndex(PageContext pageContext)
			throws HWFServiceException, HWFStubException {
		MasterDataFactory masterDataFacotry = (MasterDataFactory) pageContext
				.getServletContext().getAttribute(MasterDataFactory.CTX_KEY);
		return masterDataFacotry.getFloatingIndex();
	}
}
