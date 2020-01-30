/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ICreateBundleDAO.java
 * Purpose: This interface is used for the bundle functionality.
 * 
 */
package com.ge.aloc.dao;

import java.util.List;

import com.ge.aloc.model.RequestDetails;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author rajeswari.guthi
 *
 */
public interface ICreateBundleDAO {


	/**
	 * This method is used to load the list of bundles available
	 * @return
	 * @throws HWFServiceException 
	 */
	public List<RequestDetails> loadBundleList(String requestId) throws HWFServiceException;


	/**
	 * This is used to get create or update a bundle
	 * @param requestId
	 * @param bundleId
	 * @return
	 * @throws HWFServiceException
	 */
	public RequestDetails addOrCreateBundle(String requestId,String bundleId) throws HWFServiceException;

	/**
	 * This is used to delete selected bundle
	 * @param bundleId
	 * @throws HWFServiceException
	 */
	public RequestDetails removeBundle(String bundleId) throws HWFServiceException;


	/**
	 * This is used to submit selected bundle
	 * @param bundleId
	 * @throws HWFServiceException
	 */
	public RequestDetails submitBundle(String bundleId) throws HWFServiceException;



	/**
	 * This is used to remove a selected request from the selected bundle
	 * @param requestId
	 * @param bundleId
	 * @throws HWFServiceException
	 */
	public RequestDetails removeRequestFromBundle(String requestId,String bundleId) throws HWFServiceException;

	/**
	 * This is used to get requests for a selected bundle
	 * @param bundleId
	 * @return
	 * @throws HWFServiceException
	 */
	public List<RequestDetails> getRequestsForBundle(String bundleId) throws HWFServiceException;
}
