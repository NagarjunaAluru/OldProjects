/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: IRequestDetailsDAO.java
 * Purpose: IRequestDetailsDAO used for the all the request DAO declarations
 */
package com.ge.aloc.dao;


import java.math.BigInteger;

import com.ge.aloc.ActionType;
import com.ge.aloc.AttachmentType;
import com.ge.aloc.IServiceClientAware;
import com.ge.aloc.InstrumentType;
import com.ge.aloc.model.Attachment;
import com.ge.aloc.model.CurrentBankFees;
import com.ge.aloc.model.FeeHistoryDetails;
import com.ge.aloc.model.GetAmendmentRiders;
import com.ge.aloc.model.ReferenceNumberValidation;
import com.ge.aloc.model.RequestDetails;
import com.ge.aloc.model.SuretyMaster;
import com.ge.aloc.model.SuretyMasterCollection;
import com.ge.aloc.model.UpdateReporting;
import com.hydus.hwf.exceptions.HWFServiceException;
/**
 * 
 * @author madhusudhan.gosula
 *
 */
public interface IRequestDetailsDAO extends IServiceClientAware {

	/**
	 * This method is used to create a new request
	 * @param requestDetails
	 * @param Operation
	 * @return
	 * @throws HWFServiceException
	 */
	RequestDetails createNewRequest(RequestDetails requestDetails) throws HWFServiceException;


	/**
	 * This method is used to get the request details
	 * @param instrumentType
	 * @param bigInteger
	 * @param amendmentId
	 * @return
	 * @throws HWFServiceException
	 */
	RequestDetails getRequest(InstrumentType instrumentType, BigInteger bigInteger, String amendmentId) throws HWFServiceException;

	/**
	 * This method is used to get the request details
	 * @param bigInteger
	 * @return
	 * @throws HWFServiceException
	 */
	RequestDetails getRequest(BigInteger bigInteger) throws HWFServiceException;

	/**
	 * This is used to open the Bid Award request upon clicking on the selected bank reply.
	 * @param requestDetails
	 * @return
	 * @throws HWFServiceException
	 */
	public RequestDetails openBidAwardRequest(RequestDetails requestDetails) throws HWFServiceException;

	/**
	 * This method is used to create amendment and riders request id
	 * @param bigInteger
	 * @return
	 * @throws HWFServiceException
	 */
	RequestDetails createAmendmentandRiderRequestId(InstrumentType instrumentType,BigInteger bigInteger) throws HWFServiceException;

	/**
	 * This method is used to save and submit
	 * @param requestDetails
	 * @param actionType
	 * @throws HWFServiceException
	 */
	public RequestDetails saveandSubmit(RequestDetails requestDetails, ActionType actionType)	throws HWFServiceException;

	/**
	 * This method is used to submit an amendment
	 * @param requestDetails
	 * @param actionType
	 * @return 
	 * @throws HWFServiceException
	 */
	public RequestDetails submitAmendment(RequestDetails requestDetails, ActionType actionType)	throws HWFServiceException;


	/**
	 * This method is used to submit rider details
	 * @param requestDetails
	 * @param actionType
	 * @throws HWFServiceException
	 */
	public RequestDetails submitRider(RequestDetails requestDetails, ActionType actionType)	throws HWFServiceException;



	/**
	 * This method is used to save and approve
	 * @param requestDetails
	 * @param actionType
	 * @throws HWFServiceException
	 */
	public RequestDetails saveandApprove(RequestDetails requestDetails, ActionType actionType) throws HWFServiceException;

	/**
	 * Method to get the Amendment details for the Taxonomy
	 * @throws HWFServiceException
	 * @param id 
	 */
	public GetAmendmentRiders getAmendments(BigInteger id) throws HWFServiceException;

	/**
	 * Method to get the Riders details for the Taxonomy
	 * @throws HWFServiceException
	 * @param id 
	 */
	public GetAmendmentRiders getRiders(BigInteger id) throws HWFServiceException;

	/**
	 * Method to get the Fee History details for the Taxonomy
	 * @throws HWFServiceException
	 * @param id 
	 */
	public FeeHistoryDetails getFeeHistory(BigInteger id) throws HWFServiceException;
	
	/**
	 * Method to get the Competing bid reply details for the Taxonomy
	 * @throws HWFServiceException
	 * @param id 
	 */
	public CurrentBankFees getCompBidReplies(BigInteger id) throws HWFServiceException;

	/**
	 * Method to get the Current Bank fees details for the Taxonomy
	 * @throws HWFServiceException
	 * @param id 
	 */
	public CurrentBankFees getCurrBankFees(BigInteger id) throws HWFServiceException;
	
	/**
	 * Method to get the Current Bank fees details for the Taxonomy
	 * @throws HWFServiceException
	 * @param id 
	 */
	public CurrentBankFees saveCurrBankFees(CurrentBankFees curBankFees) throws HWFServiceException;
	
	/**
	 * Method to get the Bank Reference Number valid or not(Issuance stage).
	 * @param referenceNumberValidation
	 * @throws HWFServiceException
	 */
	public ReferenceNumberValidation checkBankRefNumber(ReferenceNumberValidation referenceNumberValidation) throws HWFServiceException;
	
	/**
	 * This Method to get the selected Model requestDetails
	 * @param requestDetails
	 * @return
	 * @throws HWFServiceException
	 */
	public RequestDetails openModelRequest(String requestId) throws HWFServiceException;

	/**
	 * This Method to save the Modified Model details
	 * @param requestDetails
	 * @return
	 * @throws HWFServiceException
	 */
	public RequestDetails saveModel(RequestDetails requestDetails) throws HWFServiceException;

	/**
	 * This Method to update Taxonomy Transaction Parties fields
	 * @throws HWFServiceException
	 * @param requestDetails
	 */
	public RequestDetails updateTaxonomy(RequestDetails requestDetails) throws HWFServiceException;
	
	/**
	 * This method is used to get the Taxonomy ReportingData
	 * @throws HWFServiceException
	 * @param requestDetails
	 */
	public UpdateReporting getReportingData(UpdateReporting updateReporting) throws HWFServiceException;
	
	/**
	 * This method is used to update the Taxonomy ReportingData
	 * @throws HWFServiceException
	 * @param requestDetails
	 */
	public UpdateReporting updateReportingData(UpdateReporting updateReporting) throws HWFServiceException;


	/**
	 * This Method used to save the attachment 
	 * @throws HWFServiceException
	 * @param requestDetails
	 */
	public RequestDetails saveAttachments(RequestDetails requestDetails,AttachmentType type,Attachment attachment) throws HWFServiceException;


	/**
	 * delete the attachment
	 * @param requestDetails
	 * @param type
	 * @return
	 * @throws HWFServiceException
	 */
	public RequestDetails deleteAttachments(RequestDetails requestDetails,Attachment atmt,AttachmentType type) throws HWFServiceException;



	/**
	 * Method to retrieve the Surety Company Names List
	 * @param suretyMaster
	 * @return SuretyMasterCollection
	 * @throws HWFServiceException
	 */
	public SuretyMasterCollection getActiveSuretyMasterList(SuretyMaster suretyMaster) throws HWFServiceException;


	/**
	 * Method to submit the surety bond
	 * @param requestDetails
	 * @param actionType
	 * @throws HWFServiceException
	 */
	public RequestDetails awardSubmit(RequestDetails requestDetails,ActionType actionType) throws HWFServiceException;
	
	/**
	 * Method to save FormatData with Swift changes
	 * @param requestDetails
	 * @throws HWFServiceException
	 */
	public RequestDetails saveFormatSwiftData(RequestDetails requestDetails) throws HWFServiceException;
	
	/**
	 * Method to save issuance data at taxonomy level
	 * @param requestDetails
	 * @param actionType
	 * @throws HWFServiceException
	 */
	public RequestDetails issuanceSave(RequestDetails requestDetails,ActionType actionType) throws HWFServiceException;
}
