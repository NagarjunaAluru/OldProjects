/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: BusinessUnitCodeManager.java
 * Purpose: 
 */
package com.ge.aloc.manager.impl.admin;

import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.dao.admin.IBlockBUCDAO;
import com.ge.aloc.manager.admin.IBlockBUCManager;
import com.ge.aloc.model.BusinessUnitCode;
import com.ge.aloc.model.BusinessUnitCodeList;
import com.hydus.hwf.exceptions.HWFServiceException;
import com.hydus.hwf.util.StringUtils;

/**
 * @author Rajat-Hydus
 *
 */
public class BlockBUCManager implements IBlockBUCManager{

	private IBlockBUCDAO blockBUCDAO;

	/**
	 * Method to get the list of already blocked BUC's
	 * @return BusinessUnitCodeList
	 * @throws HWFServiceException
	 */
	public BusinessUnitCodeList open() throws HWFServiceException {
		return blockBUCDAO.open();
	}


	/**
	 * Method to search the BUC and get the associated ADN's 
	 * @param businessUnitCode
	 * @return BusinessUnitCodeList
	 * @throws HWFServiceException
	 */
	public BusinessUnitCodeList search(BusinessUnitCode businessUnitCode) throws HWFServiceException {
		return blockBUCDAO.search(businessUnitCode);
	}

	public BusinessUnitCode validateBUC(String buc) throws HWFServiceException {
		BusinessUnitCode blockBusinessUnitCode = new BusinessUnitCode();
		blockBusinessUnitCode.setBUC(buc);
		return blockBUCDAO.validateBUC(blockBusinessUnitCode);
	}

	/**
	 * Method to block the selected BUC and ADN combination
	 * @param businessUnitCode
	 * @return BusinessUnitCode
	 * @throws HWFServiceException
	 */
	public BusinessUnitCode blockBUC(BusinessUnitCode businessUnitCode,String reasonForBlock) throws HWFServiceException {
		BusinessUnitCode blockBusinessUnitCode = new BusinessUnitCode();
		blockBusinessUnitCode.setBUC(businessUnitCode.getBUC());
		blockBusinessUnitCode.setNotes(businessUnitCode.getNotes());
		if(StringUtils.isBlank(businessUnitCode.getADN()))
		{
			blockBusinessUnitCode.setADN(ALOCConstants.ALLADN);
		}
		else
		{
			blockBusinessUnitCode.setADN(businessUnitCode.getADN());
		}
		if(!StringUtils.isBlank(reasonForBlock))
		{
			blockBusinessUnitCode.setNotes(reasonForBlock);
		}
		return blockBUCDAO.blockBUC(blockBusinessUnitCode);
	}

	/**
	 * Method to unblock the selected BUC and ADN combination
	 * @param businessUnitCode
	 * @return BusinessUnitCode
	 * @throws HWFServiceException
	 */
	public BusinessUnitCode unBlockBUC(BusinessUnitCode businessUnitCode) throws HWFServiceException {
		return blockBUCDAO.unBlockBUC(businessUnitCode);
	}	

	/**
	 * Method to get the blockBUCDAO object instance
	 * @return the blockBUCDAO
	 */
	public IBlockBUCDAO getBlockBUCDAO() {
		return blockBUCDAO;
	}

	/**
	 * Method to set the blockBUCDAO object instance
	 * @param blockBUCDAO the blockBUCDAO to set
	 */
	public void setBlockBUCDAO(IBlockBUCDAO blockBUCDAO) {
		this.blockBUCDAO = blockBUCDAO;
	}
}
