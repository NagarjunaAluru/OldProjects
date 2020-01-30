/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: IStandardFormatMgmtDAO.java
 * Purpose: IStandardFormatMgmtDAO used for the all treasury admin portal operations
 */
package com.ge.aloc.dao.admin;

import com.ge.aloc.model.StandardFormatMaster;
import com.hydus.hwf.exceptions.HWFServiceException;


/**
 * @author rajeswari.guthi
 *
 */
public interface IStandardFormatMgmtDAO {

	/**
	 * This is used to get the formt template details for the selected instrumenttype,instrument purpose,biond type and bond subtype. 
	 * @param standardFormatMaster
	 * @return
	 * @throws HWFServiceException
	 */
	public StandardFormatMaster getFormatMaster(StandardFormatMaster standardFormatMaster)	throws HWFServiceException;


	/**
	 * This is used to get updated formt template file for the selected formatAuditTrailId. 
	 * @param standardFormatMaster
	 * @return
	 * @throws HWFServiceException
	 */
	public StandardFormatMaster getUpdatedGeStandardFormatFile(StandardFormatMaster standardFormatMaster)	throws HWFServiceException;


	/**
	 * This is used to get add or update the formt template details for the selected instrumenttype,instrument purpose,biond type and bond subtype.
	 * @param standardFormatMaster
	 * @return
	 * @throws HWFServiceException
	 */
	public StandardFormatMaster manageStandardFormatMaster(StandardFormatMaster standardFormatMaster)	throws HWFServiceException;

}

