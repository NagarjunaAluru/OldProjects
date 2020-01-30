/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: IRequestDetailsSectionManager.java
 * Purpose: IRequestDetailsSectionManager used for the all request section operations
 */
package com.ge.aloc.manager;


import java.math.BigInteger;

import com.ge.aloc.ActionType;
import com.ge.aloc.bo.RequestDetailsBO;
import com.ge.aloc.exception.ALOCAttachmentException;
import com.ge.aloc.exception.ALOCException;
import com.ge.aloc.model.RequestDetails;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author chaitanya.n
 *
 */
public interface IRequestDetailsSectionManager {


	/**
	 *  This method is used to save attachments section
	 * @throws HWFServiceException
	 */
	public void saveAttachments() throws HWFServiceException, ALOCAttachmentException, ALOCException;

	/**
	 *  This method is used to save format section
	 * @throws HWFServiceException
	 */
	public void saveFormat(String standardFormat, String modifiedFormat) throws HWFServiceException, ALOCException;

	/**
	 *  This method is used to save Amendment Transaction Parties section
	 * @throws HWFServiceException
	 */
	public void saveAmendmentTP() throws HWFServiceException;

	/**
	 *  This method is used to save Instrument Amount/currency section
	 * @throws HWFServiceException
	 */
	public void saveAmendmentIAC() throws HWFServiceException;

	/**
	 *  This method is used to save Expire dates section
	 * @throws HWFServiceException
	 */
	public void saveAmendmentED() throws HWFServiceException;

	/**
	 *  This method is used to save Other changes section
	 * @throws HWFServiceException
	 */
	public void saveAmendmentOC() throws HWFServiceException;
	/**
	 * This method is used for save
	 * @throws HWFServiceException
	 */
	public RequestDetails save(ActionType actionType) throws HWFServiceException;

	/**
	 *  This method is used to save Amendment details
	 * @throws HWFServiceException
	 */
	public RequestDetails saveAmendment() throws HWFServiceException;

	/**
	 *  This method is used to save rider details
	 * @return
	 * @throws HWFServiceException
	 */
	public RequestDetails saveRider() throws HWFServiceException;

	/**
	 *  This method is used for getting the standard format document
	 *  @param requestId
	 *  @param instrumentPurposeId
	 *  @param bondTypeId
	 *  @param bondSubTypeId
	 * @return
	 * @throws HWFServiceException
	 */
	public String getStandardFormatDocument(String requestId,String instrumentPurposeId,BigInteger bondTypeId,BigInteger bondSubTypeId) throws HWFServiceException;

	/**
	 *  This method is used to save rider principal details
	 * @throws HWFServiceException
	 */
	public void saveRiderPrincipal() throws HWFServiceException;


	/**
	 *  This method is used to save rider obligee section
	 * @throws HWFServiceException
	 */
	public void saveRiderObligee() throws HWFServiceException;


	/**
	 *  This method is used to save rider expire date
	 * @throws HWFServiceException
	 */
	public void saveRiderExpDate() throws HWFServiceException;


	/**
	 *  This method is used to save rider bond information section
	 * @throws HWFServiceException
	 */
	public void saveRiderBondInformation() throws HWFServiceException;

	/**
	 *  This method is used to save rider delivery instructions section
	 * @throws HWFServiceException
	 */
	public void saveRiderDeliveryInstructions() throws HWFServiceException;

	/**
	 * This method is used for creating a landing page request
	 * @throws HWFServiceException
	 */
	public RequestDetailsBO createLandingPageRequest(String siteId,ActionType actionType) throws HWFServiceException;

	/**
	 * This method is used for saving request details
	 * @throws HWFServiceException
	 */
	public RequestDetails saveRequestDetails() throws HWFServiceException;


	/**
	 * This method is used to get the full audit log and action log Details
	 * @throws HWFServiceException
	 * @return
	 */
	public RequestDetails getFullAuditandActionLog(String stageName,String logType,BigInteger resquestID,RequestDetails requestDetail) throws HWFServiceException;

}
