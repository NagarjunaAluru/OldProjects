/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: CreateBundleManagerTest.java
 * Purpose: This class is to test the create bundle functionality.
 * 
 */
package com.ge.aloc.manager.impl;

import java.util.List;

import com.ge.aloc.dao.ICreateBundleDAO;
import com.ge.aloc.exception.ALOCException;
import com.ge.aloc.manager.ICreateBundleManager;
import com.ge.aloc.model.RequestDetails;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author rajeswari.guthi
 *
 */
public class CreateBundleManager implements ICreateBundleManager {

	private ICreateBundleDAO createBundleDAO;


	/* (non-Javadoc)
	 * @see com.ge.aloc.manager.ICreateBundleManager#addOrCreateBundle(java.lang.String, java.lang.String)
	 */
	public RequestDetails addOrCreateBundle(String requestId, String bundleId)
			throws HWFServiceException,ALOCException {					
		RequestDetails requestDetails = createBundleDAO.addOrCreateBundle(requestId, bundleId);
		return requestDetails;
	}


	/* (non-Javadoc)
	 * @see com.ge.aloc.manager.ICreateBundleManager#loadBundleList()
	 */
	public List<RequestDetails> loadBundleList(String requestId) throws HWFServiceException {		
		List<RequestDetails> reqDetailsList = createBundleDAO.loadBundleList(requestId);		
		return reqDetailsList;
	}


	/* (non-Javadoc)
	 * @see com.ge.aloc.manager.ICreateBundleManager#removeBundle(java.lang.String, java.lang.String)
	 */
	public RequestDetails removeBundle(String bundleId)
			throws HWFServiceException {				
		RequestDetails requestDetails = createBundleDAO.removeBundle(bundleId);
		return requestDetails;
	}


	/* (non-Javadoc)
	 * @see com.ge.aloc.manager.ICreateBundleManager#submitBundle(java.lang.String)
	 */
	public RequestDetails submitBundle(String bundleId)
			throws HWFServiceException {					
		RequestDetails requestDetails = createBundleDAO.submitBundle(bundleId);
		return requestDetails;
	}


	/* (non-Javadoc)
	 * @see com.ge.aloc.manager.ICreateBundleManager#removeRequestFromBundle(java.lang.String, java.lang.String)
	 */
	public RequestDetails removeRequestFromBundle(String requestId,String bundleId) throws HWFServiceException {							
		RequestDetails requestDetails = createBundleDAO.removeRequestFromBundle(requestId,bundleId);
		return requestDetails;
	}

	/**
	 * 
	 */
	/* (non-Javadoc)
	 * @see com.ge.aloc.manager.ICreateBundleManager#getRequestsForBundle(java.lang.String)
	 */
	public List<RequestDetails> getRequestsForBundle(String bundleId)
			throws HWFServiceException {
		return createBundleDAO.getRequestsForBundle(bundleId);

	}

	/**
	 * This method is used to create createBundleDAO instance
	 * @return
	 */
	public ICreateBundleDAO getCreateBundleDAO() {
		return createBundleDAO;
	}

	/**
	 * This method is used to set createBundleDAO instance
	 * @param createBundleDAO
	 */
	public void setCreateBundleDAO(ICreateBundleDAO createBundleDAO) {
		this.createBundleDAO = createBundleDAO;
	}

}
