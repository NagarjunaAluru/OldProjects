/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: IStandardFormatMgmtManager.java
 * Purpose: IStandardFormatMgmtManager used for Standard Format Management operations.
 */
package com.ge.aloc.manager.admin;


import com.ge.aloc.model.StandardFormatMaster;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author rajeswari.guthi
 *
 */
public interface IStandardFormatMgmtManager {

	/**
	 * This is used to get updated formt template file for the selected formatAuditTrailId.  
	 * @return
	 * @throws HWFServiceException
	 * @throws IOException
	 */
	public StandardFormatMaster getUpdatedGeStandardFormatFile(StandardFormatMaster standardFormatMaster)throws HWFServiceException;


	/**
	 *  This is used to get the formt template details for the selected instrumenttype,instrument purpose,biond type and bond subtype.
	 * @return
	 * @throws HWFServiceException
	 * @throws IOException
	 */
	public StandardFormatMaster getStandardFormatMaster(StandardFormatMaster standardFormatMaster)throws HWFServiceException;


	/**
	 * This is used to get add or update the formt template details for the selected instrumenttype,instrument purpose,biond type and bond subtype.
	 * @param standardFormatMaster
	 * @return
	 * @throws HWFServiceException
	 */
	public StandardFormatMaster manageStandardFormatMaster(StandardFormatMaster standardFormatMaster)throws HWFServiceException;



}
