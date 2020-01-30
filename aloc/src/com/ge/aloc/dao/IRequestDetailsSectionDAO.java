/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: IRequestDetailsSectionDAO.java
 * Purpose: IRequestDetailsSectionDAO used for the all the request section DAO declarations
 */
package com.ge.aloc.dao;

import java.math.BigInteger;

import com.ge.aloc.ActionType;
import com.ge.aloc.model.RequestDetails;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author chaitanya.n
 *
 */
public interface IRequestDetailsSectionDAO {

	/**
	 * This method is used to save request details
	 * @param requestDetails
	 * @throws HWFServiceException
	 */
	public RequestDetails save(RequestDetails requestDetails)	throws HWFServiceException;
	public void saveFormat(RequestDetails requestDetails) throws HWFServiceException;

	/**
	 * This method is used to save attachments section
	 * @throws HWFServiceException 
	 * 
	 */
	public void saveAttachments(RequestDetails requestDetails) throws HWFServiceException;

	/**
	 * This method is used to save an Amendment details
	 * @param requestDetails
	 * @throws HWFServiceException
	 */
	public RequestDetails saveAmendment(RequestDetails requestDetails) throws HWFServiceException;

	/**
	 * This method is used to save rider details
	 * @param requestDetails
	 * @return
	 * @throws HWFServiceException
	 */
	public RequestDetails saveRider(RequestDetails requestDetails) throws HWFServiceException;

	/**
	 * This method is used to save an Amendment Transaction Parties section
	 * @param requestDetails
	 * @throws HWFServiceException
	 */
	public void saveAmendmentTP(RequestDetails requestDetails) throws HWFServiceException;

	/**
	 * This method is used to save an Amendment Instrument amount/currency section
	 * @param requestDetails
	 * @throws HWFServiceException
	 */
	public void saveAmendmentIAC(RequestDetails requestDetails) throws HWFServiceException;

	/**
	 * This method is used to save an Amendment expire dates section
	 * @param requestDetails
	 * @throws HWFServiceException
	 */
	public void saveAmendmentED(RequestDetails requestDetails) throws HWFServiceException;

	/**
	 * This method is used to save an Amendment Other Changes section
	 * @param requestDetails
	 * @throws HWFServiceException
	 */
	public void saveAmendmentOC(RequestDetails requestDetails) throws HWFServiceException;
	/**
	 * This method is used to save standard format document
	 * @param requestId
	 * @param instrumentPurposeId
	 * @param bondTypeId
	 * @param bondSubTypeId
	 * @return
	 * @throws HWFServiceException
	 */
	public String getStandardFormatDocument(String requestId,String instrPurposeId,BigInteger bondTypeId,BigInteger bondSubTypeId) throws HWFServiceException;

	/**
	 * This method is used to save rider principal section
	 * @return
	 * @throws HWFServiceException
	 */
	public void saveRiderPrincipal(RequestDetails requestDetails) throws HWFServiceException;

	/**
	 * This method is used to save rider Obligee section
	 * @return
	 * @throws HWFServiceException
	 */
	public void saveRiderObligee(RequestDetails requestDetails) throws HWFServiceException;

	/**
	 * This method is used to save rider Expire Date 
	 * @return
	 * @throws HWFServiceException
	 */
	public void saveRiderExpDate(RequestDetails requestDetails) throws HWFServiceException;

	/**
	 * This method is used to save rider Bond Information section
	 * @return
	 * @throws HWFServiceException
	 */
	public void saveRiderBondInformation(RequestDetails requestDetails) throws HWFServiceException;

	/**
	 * This method is used to save rider delivery Instruction section
	 * @return
	 * @throws HWFServiceException
	 */
	public void saveRiderDeliveryInstructions(RequestDetails requestDetails) throws HWFServiceException;

	/**
	 * This method is used to save create landing page request
	 * @return
	 * @throws HWFServiceException
	 */
	public RequestDetails createLandingPageRequest(RequestDetails requestDetails,String siteId,ActionType actionType) throws HWFServiceException;

	/**
	 * This method is used to save  request details.
	 * @return
	 * @throws HWFServiceException
	 */
	public RequestDetails saveRequestDetails(RequestDetails requestDetails) throws HWFServiceException;



	/**
	 * This method is used to get the full audit and action log Details
	 * @param logType
	 * @param requestDetails
	 * @throws HWFServiceException
	 * @return
	 */
	public RequestDetails getFullAuditandActionLog(String logType,RequestDetails requestDetails) throws HWFServiceException;


}
