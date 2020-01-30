/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: IRequestDetailsManager.java
 * Purpose: IRequestDetailsManager used for the all request operations
 */
package com.ge.aloc.manager;

import java.math.BigInteger;
import java.util.List;

import com.ge.aloc.ActionType;
import com.ge.aloc.AttachmentType;
import com.ge.aloc.InstrumentType;
import com.ge.aloc.bo.RequestDetailsBO;
import com.ge.aloc.model.Attachment;
import com.ge.aloc.model.CurrentBankFees;
import com.ge.aloc.model.FeeHistoryDetails;
import com.ge.aloc.model.GetAmendmentRiders;
import com.ge.aloc.model.ReferenceNumberValidation;
import com.ge.aloc.model.RequestDetails;
import com.ge.aloc.model.UpdateReporting;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author chaitanya.n
 *
 */
public interface IRequestDetailsManager {

	/**
	 * This method is used to create a request
	 * @return
	 */
	RequestDetailsBO createRequest(String instrumentTypeId ,String instrumentTypeName, String siteId, String siteName,BigInteger modelId) throws HWFServiceException;

	/**
	 * This method is used to open request
	 * @param instrumentType 
	 * @param id
	 * @param amendmentId
	 * @return
	 * @throws HWFServiceException
	 */
	RequestDetailsBO openRequest(InstrumentType instrumentType,BigInteger id, String amendmentId) throws HWFServiceException;


	/**
	 * This is used to open the Bid Award request upon clicking on the selected bank reply.
	 * @param requestId
	 * @param bidReplyId
	 * @return
	 * @throws HWFServiceException
	 */
	public RequestDetailsBO openBidAwardRequest(BigInteger requestId,BigInteger bidReplyId) throws HWFServiceException;
	
	/**
	 * This is used to open the Bid Reply request upon clicking on the selected bank reply.
	 * @param requestId
	 * @param bankBidId
	 * @return
	 * @throws HWFServiceException
	 */
	public RequestDetailsBO openBidReplyRequest(BigInteger requestId,BigInteger bankBidId) throws HWFServiceException;

	/**
	 * This method is used to opens a request 
	 * @param id
	 * @return
	 * @throws HWFServiceException
	 */
	RequestDetailsBO openRequest(BigInteger id) throws HWFServiceException;

	/**
	 * This method is used to create an amendment request id
	 * @param id
	 * @return
	 * @throws HWFServiceException
	 */
	RequestDetailsBO createAmendmentRequestId(InstrumentType instrumentType, BigInteger bigInteger) throws HWFServiceException;

	/**
	 * This method is used to create surety rider request id
	 * @param id
	 * @return
	 * @throws HWFServiceException
	 */
	RequestDetailsBO createSuretyRiderRequestId(InstrumentType instrumentType, BigInteger bigInteger) throws HWFServiceException;

	/**
	 * This method is used to get a request
	 * @param bigInteger
	 * @return
	 * @throws HWFServiceException 
	 */
	RequestDetails getRequest(BigInteger bigInteger) throws HWFServiceException;

	/**
	 * This method is used to get a request 
	 * @param instrumentType
	 * @param bigInteger
	 * @param amendmentId
	 * @return
	 * @throws HWFServiceException
	 */
	RequestDetails getRequest(InstrumentType instrumentType,BigInteger bigInteger, String amendmentId) throws HWFServiceException;

	/**
	 * This method is used for save and submit 
	 * @param actionType
	 */
	RequestDetails saveandSubmit(ActionType actionType) throws HWFServiceException;

	/**
	 * This method is used to submit an amendment
	 * @param actionType
	 * @return 
	 */
	RequestDetails submitAmendment(ActionType actionType) throws HWFServiceException;

	/**
	 * This method is used to submit rider
	 * @param actionType
	 */
	RequestDetails submitRider(ActionType actionType) throws HWFServiceException;

	/**
	 * This method is used for save and approve
	 * @param actionType
	 * @param rightBankRecords
	 */
	RequestDetails saveandApprove(ActionType actionType) throws HWFServiceException;

	/**
	 * Method to get the amendment details for the taxonomy
	 * @param id
	 * @throws HWFServiceException
	 */
	GetAmendmentRiders getAmendments(BigInteger id) throws HWFServiceException;

	/**
	 * Method to get the Rider details for the taxonomy
	 * @param id
	 * @throws HWFServiceException
	 */
	GetAmendmentRiders getRiders(BigInteger id) throws HWFServiceException;

	/**
	 * Method to get the Fee History details for the Taxonomy
	 * @param id
	 * @throws HWFServiceException
	 */
	FeeHistoryDetails getFeeHistory(BigInteger id) throws HWFServiceException;
	
	/**
	 * Method to get the Fee History details for the Taxonomy
	 * @param id
	 * @throws HWFServiceException
	 */
	CurrentBankFees getCompBidReplies(BigInteger id) throws HWFServiceException;
	
	/**
	 * Method to get the Current bank Fees details for the Taxonomy
	 * @param id
	 * @throws HWFServiceException
	 */
	CurrentBankFees getCurrBankFees(BigInteger id) throws HWFServiceException;
	/**
	 * Method to get the Current bank Fees details for the Taxonomy
	 * @param id
	 * @throws HWFServiceException
	 */
	CurrentBankFees saveCurrBankFees(CurrentBankFees curBankFees) throws HWFServiceException;
	
	/**
	 * Method to get the Bank Reference Number valid or not at Issuance page.
	 * @param referenceNumberValidation
	 * @throws HWFServiceException
	 */
	public ReferenceNumberValidation checkBankRefNumber(ReferenceNumberValidation referenceNumberValidation) throws HWFServiceException;
	
	/**
	 * Method to get the selected model requestDetails
	 * @param requestId
	 * @return
	 * @throws HWFServiceException
	 */
	public RequestDetailsBO openModelRequest(String requestId) throws HWFServiceException;

	/**
	 * Method to save the Modified Model details
	 * @param requestDetails
	 * @throws HWFServiceException
	 */
	public RequestDetails saveModel(List<String> rightSelSites) throws HWFServiceException;

	/**
	 * Method to update Taxonomy Transaction Parties fields
	 * @throws HWFServiceException
	 */
	RequestDetails updateTaxonomy() throws HWFServiceException;
	
	/**
	 * Method to get Taxonomy ReportingData
	 * @param requestId
	 * @throws HWFServiceException
	 */
	UpdateReporting getReportingData(BigInteger requestId) throws HWFServiceException;
	
	/**
	 * Method to update Taxonomy ReportingData
	 * @param updateReporting
	 * @throws HWFServiceException
	 */
	UpdateReporting updateReportingData(UpdateReporting updateReporting) throws HWFServiceException;

	/**
	 * Method to retrieve the Surety Company Names List
	 * @throws HWFServiceException
	 */
	public RequestDetailsBO getActiveSuretyMasterList(RequestDetailsBO requestDetailsBO) throws HWFServiceException;


	/**
	 * Method to save Attachment
	 * @throws HWFServiceException
	 */
	RequestDetails saveAttachments(AttachmentType type,Attachment attachment) throws HWFServiceException;

	/**
	 * This is used to select the winner for Bid award
	 * @param actionType
	 * @param requestId
	 * @param bidReplyId
	 * @param transmissionPlatform
	 * @param procedureName
	 * @param workFlowstageId
	 * @param queueName
	 * @param stageName
	 * @param wfid
	 * @param swiftData
	 * @throws HWFServiceException
	 */
	public RequestDetails selectWinnerForBidAward(ActionType actionType,
			BigInteger requestId, BigInteger bidReplyId,
			String transmissionPlatform, String wfid, String stageName,
			String queueName, String procedureName, String workFlowstageId,String selBidWinnerType,String sitePrefix,String swiftData)
					throws HWFServiceException; 

	/**
	 * Method to save Attachment
	 * @throws HWFServiceException
	 */
	RequestDetails deleteAttachments(Attachment atmt,AttachmentType type) throws HWFServiceException;
	
	/**
	 * Method to save FormatData with Swift changes
	 * @throws HWFServiceException
	 */
	RequestDetails saveFormatSwiftData(RequestDetails requestDetails) throws HWFServiceException;
	/**
	 * Method to save issuance data at taxonomy level
	 * @param actionType
	 * @throws HWFServiceException
	 */
	public RequestDetails issuanceSave(ActionType actionType) throws HWFServiceException;
}
