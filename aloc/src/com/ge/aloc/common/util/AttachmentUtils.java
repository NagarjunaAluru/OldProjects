/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: AttachmentUtils.java
 * Purpose: Provides utility methods for the attachments functionality  
 */
package com.ge.aloc.common.util;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.ge.aloc.ALOCContext;
import com.ge.aloc.AttachmentType;
import com.ge.aloc.InstrumentType;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.exception.ALOCException;
import com.ge.aloc.model.Attachment;
import com.ge.aloc.model.RequestDetails;
import com.hydus.hwf.context.UserContext;

/**
 * @author rajeswari.guthi
 *
 */
public class AttachmentUtils {

	/**
	 * This method used to generate file name i.e usersso-ddhhmmss-randomnumber-filename format
	 * 
	 * @param fileName
	 * @param request
	 * @return
	 */
	public static String generateFileName(String fileName) {
		RequestDetails requestDetails = ALOCContext.getActiveRequest().getModel();
		String requestId = ALOCConstants.EMPTY_STRING;
		if(requestDetails.getInstrumentTypeId()!=null && requestDetails.getInstrumentTypeId().intValue() == BigInteger.valueOf(InstrumentType.AMENDMENT.getId()).intValue()){
			requestId =(requestDetails.getAmendment()!=null)?requestDetails.getAmendment().getAmendmentRequestId():String.valueOf(requestDetails.getRequestId());
		}else if(requestDetails.getInstrumentTypeId()!=null && requestDetails.getInstrumentTypeId().intValue() == BigInteger.valueOf(InstrumentType.RIDER.getId()).intValue()){
			requestId =(requestDetails.getRider() != null)?requestDetails.getRider().getRiderRequestId() : String.valueOf(requestDetails.getRequestId());
		}else{
			requestId = requestDetails.getAlocRecordId(); 
		}
		String userSSO = UserContext.getContext().getuserDetails().getUserId();
		StringBuilder newFileName = new StringBuilder().append(requestId).append(ALOCConstants.HYPEN) 
				.append(userSSO).append(ALOCConstants.HYPEN)
				.append(new SimpleDateFormat(ALOCConstants.DATEFORAMTE).format(new Date())).append(ALOCConstants.HYPEN)
				.append(fileName);
		return newFileName.toString();
	}

	/**
	 * This method is used to generate format file Name.
	 * @param type
	 * @return
	 */
	public static String generateFormatFileName(AttachmentType type) {
		String fileName = null;
		if(type.getFormatId() == AttachmentType.STANDARD_FORMAT.getFormatId()) {
			fileName = ALOCConstants.STANDARD_FORMATTXT; 
		} else if(type.getFormatId() == AttachmentType.MODIFIED_STANDARD_FORMAT.getFormatId()) {
			fileName = ALOCConstants.MODIFIED_FORMATTXT;
		}
		return generateFileName(fileName);
	}



	/**
	 * This method return attachment object 
	 * It will search and return the deal Attachment object by providing the gefileId
	 * @param geFileId
	 * @return
	 * @throws ALOCException 
	 */
	public static Attachment getAttachmentByGELibId(String geFileId, RequestDetails request) throws ALOCException {
		// Searching in request attachments 
		Attachment result = searchAttachmentByGELibId(geFileId, request.getAttachments()); 			
		return result;
	}

	/**
	 *  This method returns attachment by searching with the gefileid in the list

	 * @param geFileId
	 * @param attachmentList
	 * @return
	 */
	public static Attachment searchAttachmentByGELibId(String geFileId, List<Attachment> attachmentList) {
		if(attachmentList != null && !attachmentList.isEmpty()) {
			for(Attachment attachment : attachmentList) {
				if(geFileId.equals(attachment.getGeFileId())) {
					return attachment;
				}
			}
		}
		return null;
	}

	/**
	 * This method deletes the specified attachment from the request and returns the deleted attachment.
	 * 
	 * @param geFileId
	 * @return
	 * @throws ALOCException 
	 */
	public static Attachment deleteAttachmentByGELibId(String geFileId, RequestDetails request) throws ALOCException {
		// Searching in request attachments
		List<Attachment> attachmentList = request.getAttachments();
		if(attachmentList != null && !attachmentList.isEmpty()) {
			Iterator<Attachment> attachmentItr = attachmentList.listIterator();
			Attachment attachment = null;
			while(attachmentItr.hasNext()) {
				attachment = attachmentItr.next();
				if(geFileId.equals(attachment.getGeFileId())) {
					attachmentItr.remove();
				}
			}
		}			
		return null;
	}


	/**
	 * This method used to generate file name i.e usersso-ddhhmmss-randomnumber-filename format
	 * 
	 * @param fileName
	 * @param request
	 * @return
	 */
	public static String generateFileNameForUserAnnouncement(String fileName) {		
		String userSSO = UserContext.getContext().getuserDetails().getUserId();
		StringBuilder newFileName = new StringBuilder().append(userSSO).append(ALOCConstants.HYPEN)				
				.append(new SimpleDateFormat(ALOCConstants.DATEFORAMTE).format(new Date())).append(ALOCConstants.HYPEN)
				.append(( int ) ( Math.random() * ALOCConstants.SEED_VALUE ))
				.append(ALOCConstants.HYPEN).append(fileName);
		return newFileName.toString();
	}
}

