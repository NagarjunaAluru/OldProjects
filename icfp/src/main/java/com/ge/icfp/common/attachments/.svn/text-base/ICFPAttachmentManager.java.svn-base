/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: ICFPAttachmentManager.java
 * Purpose: Represents prototype for attachments functionality
 */
package com.ge.icfp.common.attachments;

import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.upload.FormFile;

import com.ge.icfp.action.ICFPException;
import com.ge.icfp.model.Attachment;
import com.ge.icfp.model.DealRequest;

/**
 *
 * This class will have all main features like attachment/download/delete file using GELIB.
 * @author chaitanya.n
 * 
 */
public interface ICFPAttachmentManager {
	
	/**
	 *  This Method returns the attachment object for particular attachment type
	 * @param file
	 * @param type
	 * @param deal
	 * @param legIndex
	 * @param derivativeIndex
	 * @param exceptionIndex
	 * @param ammendmentIndex
	 * @return
	 */
	Attachment addAttachment(FormFile file, AttachmentType type, String comments, DealRequest deal, Integer legIndex, Integer derivativeIndex, Integer exceptionIndex, Integer ammendmentIndex) throws ICFPAttachmentException, ICFPException;

	/**
	 * This Method returns the deal attachment object for particular attachment type
	 * @param file
	 * @param type
	 * @param deal
	 * @return
	 * @throws ICFPAttachmentException
	 */
	Attachment addDealAttachment(FormFile file, AttachmentType type, String comments, DealRequest deal) throws ICFPAttachmentException, ICFPException;
	
	/**
	 * This Method returns the leg attachment object for particular attachment type
	 * @param file
	 * @param type
	 * @param deal
	 * @param legIndex
	 * @return
	 * @throws ICFPAttachmentException
	 */
	List<Attachment> addLegAttachment(FormFile file, AttachmentType type, String comments, DealRequest deal, Integer... legIndex) throws ICFPAttachmentException, ICFPException;
	
	/**
	 * This Method returns the derivative attachment object for particular attachment type
	 * @param file
	 * @param type
	 * @param deal
	 * @param legIndex
	 * @param derivativeIndex
	 * @return
	 * @throws ICFPAttachmentException
	 */
	Attachment addDerivativeAttachment(FormFile file, AttachmentType type, String comments, DealRequest deal, Integer legIndex, Integer derivativeIndex) throws ICFPAttachmentException, ICFPException;
	
	/**
	 * This Method returns the exception attachment object for particular attachment type
	 * @param file
	 * @param type
	 * @param deal
	 * @param legIndex
	 * @param exceptionIndex
	 * @return
	 * @throws ICFPAttachmentException
	 */
	Attachment addExceptionAttachment(FormFile file, AttachmentType type, String comments, DealRequest deal, Integer legIndex, Integer exceptionIndex) throws ICFPAttachmentException, ICFPException;
	
	/**
	 * This Method returns the amendment attachment object for particular attachment type
	 * @param file
	 * @param type
	 * @param deal
	 * @param legIndex
	 * @param ammendmentIndex
	 * @return
	 * @throws ICFPAttachmentException
	 */
	Attachment addAmendmentAttachment(FormFile file, AttachmentType type, String comments, DealRequest deal, Integer legIndex, Integer amendmentIndex) throws ICFPAttachmentException, ICFPException;
	
	/**
	 * This Method used to download file for particular attachment object
	 * @param outStream
	 * @param attachment
	 * @throws ICFPAttachmentException
	 */
	void downloadAttachment(OutputStream outStream, Attachment attachment, DealRequest deal) throws ICFPAttachmentException, ICFPException;
	
	/**
	 * This Method used to download file  based on providing the GE file id
	 * @param outStream
	 * @param repFileId
	 * @param deal
	 * @throws ICFPAttachmentException
	 */
	Attachment downloadAttachment(OutputStream outStream, String repFileId, DealRequest deal) throws ICFPAttachmentException, ICFPException;
	
	/**
	 * This Method used to delete file from GE lib for particular attachment object
	 * @param attachment
	 * @throws ICFPAttachmentException
	 */
	void delete(Attachment attachment, DealRequest deal) throws ICFPAttachmentException, ICFPException;
	
	/**
	 * This Method used to delete file  based on providing the GE file id
	 * @param repFileId
	 * @param deal
	 * @throws ICFPAttachmentException
	 */
	Attachment delete(String repFileId, DealRequest deal) throws ICFPAttachmentException, ICFPException;
	
	/**
	 * This Method used to delete all files for current deal
	 * @param attachmentListToDelete
	 * @param deal
	 * @throws ICFPException
	 */
	void delete(List<Attachment> attachmentListToDelete, DealRequest deal) throws ICFPException;
	
	/**
	 * This Method used to update meta info for current deal
	 * @param deal
	 * @throws ICFPAttachmentException
	 */
	void updateMetadataForAllAttachments(DealRequest deal) throws ICFPAttachmentException, ICFPException;
	
	/**
	 * This Method used to update meta info for current leg
	 * @param leg
	 * @param deal
	 * @throws ICFPAttachmentException
	 * @throws ICFPException
	 */
	void updateMetadataForAllLegAttachments(Object leg, DealRequest deal) throws ICFPAttachmentException, ICFPException; 
	
	/**
	 * This Method used to delete all leg attachments if leg is deleted
	 * @param leg
	 * @param deal
	 * @throws ICFPAttachmentException
	 * @throws ICFPException
	 */
	void deleteAllLegAttachments(Object leg, DealRequest deal) throws ICFPAttachmentException, ICFPException; 
	
	/**
	 * This Method used to delete all leg attachments if deal is canceled
	 * @param deal
	 * @throws ICFPAttachmentException
	 * @throws ICFPException
	 */
	void deleteAllAttachments(DealRequest deal) throws ICFPAttachmentException, ICFPException;
	
	/**
	 * This method uploads UnderWriting File to GE library.
	 * 
	 * @param request
	 * @throws ICFPAttachmentException
	 * @throws ICFPException
	 */
	void uploadUnerWritingFile(HttpServletRequest request) throws ICFPAttachmentException, ICFPException; 
}
