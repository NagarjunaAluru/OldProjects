/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: StandardFormatMgmtManager.java
 * Purpose: StandardFormatMgmtManager used for Standard Format Management operations.
 */
package com.ge.aloc.manager.impl.admin;

import com.ge.aloc.dao.admin.IStandardFormatMgmtDAO;
import com.ge.aloc.manager.admin.IStandardFormatMgmtManager;
import com.ge.aloc.model.StandardFormatMaster;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author rajeswari.guthi
 *
 */
public class StandardFormatMgmtManager implements IStandardFormatMgmtManager {

	private IStandardFormatMgmtDAO standardFormatMgmtDAO;

	/**
	 *  This is used to get the format template details for the selected instrument type,instrument purpose,bond type and bond subtype.
	 * @return
	 * @throws HWFServiceException
	 * @throws IOException
	 */
	public StandardFormatMaster getStandardFormatMaster(StandardFormatMaster standardFormatMaster) throws HWFServiceException{		
		return standardFormatMgmtDAO.getFormatMaster(standardFormatMaster);
	}

	/**
	 * This is used to get the Standard format management DAO Service instance
	 * @return
	 */
	public IStandardFormatMgmtDAO getStandardFormatMgmtDAO() {
		return standardFormatMgmtDAO;
	}

	/**
	 *  This is used to set the Standard format management DAO Service instance
	 * @param standardFormatMgmtDAO
	 */
	public void setStandardFormatMgmtDAO(IStandardFormatMgmtDAO standardFormatMgmtDAO) {
		this.standardFormatMgmtDAO = standardFormatMgmtDAO;
	}

	/**
	 * This is used to get add or update the format template details for the selected instrument type,instrument purpose,bond type and bond sub-type.
	 * @param standardFormatMaster
	 * @return
	 * @throws HWFServiceException
	 */
	public StandardFormatMaster manageStandardFormatMaster(StandardFormatMaster standardFormatMaster) throws HWFServiceException {
		return standardFormatMgmtDAO.manageStandardFormatMaster(standardFormatMaster);
	}


	/**
	 * This is used to get updated format template file for the selected formatAuditTrailId.  
	 * @return
	 * @throws HWFServiceException
	 * @throws IOException
	 */
	public StandardFormatMaster getUpdatedGeStandardFormatFile(StandardFormatMaster standardFormatMaster) throws HWFServiceException {
		return standardFormatMgmtDAO.getUpdatedGeStandardFormatFile(standardFormatMaster);
	}


}
