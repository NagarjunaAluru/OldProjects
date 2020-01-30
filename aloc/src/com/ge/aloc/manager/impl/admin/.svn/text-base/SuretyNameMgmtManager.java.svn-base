/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: SuretyNameMgmtManager.java
 * Purpose: SuretyNameMgmtManager used for Surety Name Management operations and user actions.
 */
package com.ge.aloc.manager.impl.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.dao.admin.ISuretyNameMgmtDAO;
import com.ge.aloc.manager.admin.ISuretyNameMgmtManager;
import com.ge.aloc.model.SuretyMaster;
import com.ge.aloc.model.SuretyMasterCollection;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author Rajat-Hydus
 *
 */
public class SuretyNameMgmtManager implements ISuretyNameMgmtManager{

	private ISuretyNameMgmtDAO suretyNameMgmtDAO;

	/**
	 * This method is used to fetch All Surety Name available in DB
	 * @return Surety Names
	 */
	public SuretyMasterCollection open() throws HWFServiceException {
		SuretyMasterCollection suretyList = new SuretyMasterCollection();
		SuretyMaster suretyMaster = new SuretyMaster();
		suretyList = suretyNameMgmtDAO.open(suretyMaster);
		return suretyList;
	}

	/**
	 * Method to add or update given SuretyCompany Name
	 * @return added or updated surety Name
	 */
	public SuretyMaster update(SuretyMaster suretyMaster)
			throws HWFServiceException {
		suretyNameMgmtDAO.update(suretyMaster);
		return suretyMaster;
	}

	/**
	 * Method to cancel the SuretyCompany Name changes
	 * @param suretyMasterList
	 * @param suretyId
	 * @return
	 */
	public SuretyMaster cancel(List<SuretyMaster> suretyMasterList, String suretyId) {
		SuretyMaster suretyMaster = new SuretyMaster();
		if(suretyId!=null && !(suretyId.equals(ALOCConstants.EMPTY_STRING)))
		{
			if(suretyMasterList != null && suretyMasterList.size() > ALOCConstants.BASE_VALUE)
			{
				for(SuretyMaster tempSuretyMaster : suretyMasterList)
				{
					if((Long.valueOf(suretyId)).equals(tempSuretyMaster.getSuretyId()))
					{
						suretyMaster = tempSuretyMaster;
						break;
					}
				}
			}
		}
		return suretyMaster;
	}

	/**
	 * Method to get the Surety Comp Name Row value for given suretyId
	 * @return 
	 * @throws HWFServiceException
	 */
	public SuretyMasterCollection getSuretyDetailsForSelSurety(SuretyMasterCollection suretyMasterCollection,SuretyMaster suretyMaster) throws HWFServiceException{
		List<SuretyMaster> tempSuretyNameList =suretyMasterCollection.getSuretyMasters();
		List<SuretyMaster> suretyNameList = new ArrayList<SuretyMaster>();

		for(SuretyMaster tempSuretyMaster : tempSuretyNameList)
		{
			if(suretyMaster.getSuretyId() != null  && !(suretyMaster.getSuretyId().equals(ALOCConstants.EMPTY_STRING)))
			{
				if(tempSuretyMaster.getSuretyId().equals(suretyMaster.getSuretyId())){
					suretyNameList.add(suretyMaster);
				}else{
					suretyNameList.add(tempSuretyMaster);
				}}else{
					suretyNameList.add(tempSuretyMaster);
				}
		}

		if(suretyMaster.getSuretyId() == null  || suretyMaster.getSuretyId().equals(ALOCConstants.EMPTY_STRING)){
			HttpServletRequest request = ServletActionContext.getRequest();
			String curIndex = request.getParameter(ALOCConstants.CURINDEX);
			suretyNameList.add(Integer.valueOf(curIndex), suretyMaster);
		}
		suretyMasterCollection.setSuretyMasters(suretyNameList);
		return suretyMasterCollection;
	}

	/**
	 * This method is used to get the suretyNameMgmtDAO object instance
	 * @return the suretyNameMgmtDAO
	 */
	public ISuretyNameMgmtDAO getSuretyNameMgmtDAO() {
		return suretyNameMgmtDAO;
	}

	/**
	 * This method is used to set the suretyNameMgmtDAO object instance
	 * @param suretyNameMgmtDAO the suretyNameMgmtDAO to set
	 */
	public void setSuretyNameMgmtDAO(ISuretyNameMgmtDAO suretyNameMgmtDAO) {
		this.suretyNameMgmtDAO = suretyNameMgmtDAO;
	}
}
