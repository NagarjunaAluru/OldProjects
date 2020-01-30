/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: IALOCAttachmentManager.java
 * Purpose: This class is the interface for the attachments functionality of entire application
 * 
 */

package com.ge.aloc.manager;

import java.io.File;
import java.io.OutputStream;
import java.util.List;
import java.util.zip.ZipOutputStream;

import com.ge.aloc.AttachmentType;
import com.ge.aloc.exception.ALOCAttachmentException;
import com.ge.aloc.exception.ALOCException;
import com.ge.aloc.model.Attachment;
import com.ge.aloc.model.UserAnnouncement;

/**
 * This class will have all main features like attachment/download/delete file using GELIB.
 * @author rajeswari.guthi
 *
 */
public interface IALOCAttachmentManager {

	/**
	 * This is used to attach the uploaded file to ge library based on the attachment type 
	 * @param file
	 * @param fileName
	 * @param type
	 * @param newAttachment
	 * @throws ALOCAttachmentException
	 * @throws ALOCException
	 */
	Attachment addAttachment(File file, String fileName, AttachmentType type, Attachment newAttachment) throws ALOCAttachmentException, ALOCException;

	/**
	 * This is used to attach the ge standard format file to ge library based on the attachment type 
	 * @param content
	 * @param fileName
	 * @param type
	 * @return
	 */
	Attachment addAttachment(String content, String fileName, AttachmentType type) throws ALOCAttachmentException, ALOCException;
	
	/**
	 * This is used to validate the uploaded attachment before deleting 
	 * @param file
	 * @param fileName
	 */
	void validateAtmtInput(File file, String fileName) throws ALOCAttachmentException, ALOCException;
	
	/**
	 * This is used to validate the uploaded User Announcement attachment before deleting
	 * @param file
	 * @param fileName
	 */
	void validateAnnounceMentAtmtInput(File file, String fileName,UserAnnouncement userAnnouncement) throws ALOCAttachmentException, ALOCException;

	/**
	 * This is used to save the ge standard format file to ge library based on the attachment type 
	 * @param content
	 * @param fileName
	 * @param type
	 * @param attachment
	 */
	void saveAttachment(String content, String fileName, AttachmentType type, Attachment attachment) throws ALOCAttachmentException, ALOCException;

	/**
	 *  This is used to add the ge standard format file to ge library based on the attachment type 
	 * @param content
	 * @param type
	 * @return
	 */
	Attachment addFormatAttachment(String content, AttachmentType type) throws ALOCAttachmentException, ALOCException;

	/**
	 * This is used to add APM webcash/IBS Invoice content to ge library based on the attachment type 
	 * @param content
	 * @param fileName
	 * @param type
	 * @return
	 * @throws ALOCAttachmentException
	 * @throws ALOCException
	 */
	Attachment addAPMAttachment(String content,String fileName,Attachment attachment) throws ALOCAttachmentException, ALOCException;
	
	/**
	 * This is used to add APM CSV File to GE library based on the attachment type 
	 * @param file
	 * @param attachment
	 * @return
	 * @throws ALOCAttachmentException
	 * @throws ALOCException
	 */
	Attachment addCSVAttachment(byte[] data, Attachment attachment) throws ALOCAttachmentException, ALOCException;

	/**
	 *  This is used to save the ge standard format file to ge library based on the attachment type 
	 * @param content
	 * @param type
	 * @param attachment
	 */
	void saveFormatAttachment(String content, AttachmentType type, Attachment attachment) throws ALOCAttachmentException, ALOCException;

	/**
	 * This method have implementation of download file from gelib of current attachment GE file id by calling core component
	 * @param outStream
	 * @param attachment
	 * @throws ALOCAttachmentException
	 * @throws ALOCException
	 */
	void downloadAttachment(OutputStream outStream, Attachment attachment) throws ALOCAttachmentException, ALOCException;
	
	/**
	 * This method have implementation of download file from gelib of current attachment GE file id by calling core component
	 * @param outStream
	 * @param attachment
	 * @throws ALOCAttachmentException
	 * @throws ALOCException
	 */
	void downloadFormatAttachment(OutputStream outStream, Attachment attachment) throws ALOCAttachmentException, ALOCException;

	/**
	 * This method have implementation of download file of the format attachment by calling core component
	 * @param outStream
	 * @param attachment
	 * @throws ALOCAttachmentException
	 * @throws ALOCException
	 */
	public void  downloadAtmtData(OutputStream outStream, Attachment attachment ) throws ALOCAttachmentException, ALOCException;
	
	/**
	 * This is used to download for the outputstream
	 * @param outStream
	 */
	void downloadAllAttachmentsAsZip(OutputStream outStream,List<Attachment> allAttachments);

	
	/**
	 * This is used to download for the outputstream
	 * @param outStream
	 */
	void downloadAllAttachmentsToZip(ZipOutputStream outStream,List<Attachment> allAttachments);

	/**
	 *  This method have implementation of download file from gelib of current attachment GE file id by calling core component
	 * @param outStream
	 * @param repFileId
	 * @return
	 * @throws ALOCException
	 */ 
	public Attachment downloadAttachment(OutputStream outStream, String repFileId) throws ALOCException;
	/**
	 * This is used to delete for the selected attachment
	 * @param attachment
	 * @return
	 * @throws ALOCAttachmentException
	 * @throws ALOCException
	 */
	void delete(Attachment attachment) throws ALOCAttachmentException, ALOCException;


	/**
	 * This method have implementation of delete file from gelib by calling core component
	 * @param repFileId
	 * @return
	 * @throws ALOCAttachmentException
	 * @throws ALOCException
	 */
	Attachment delete(String repFileId) throws ALOCAttachmentException, ALOCException;

	/**
	 * This is used to delete all the attachments
	 * @throws ALOCAttachmentException
	 * @throws ALOCException
	 */
	void deleteAllAttachments()   throws ALOCAttachmentException, ALOCException;


	/**
	 * This is used to delete the list of attachments
	 * @param attachmentListToDelete
	 * @throws ALOCException
	 */
	void delete(List<Attachment> attachmentListToDelete) throws ALOCException;


	/*=============== USER ANNOUNCEMENT MAANGEENT ATTACHMENTS==============*/

	/**
	 * This is used to attach the uploaded file to ge library based on the attachment type for user announcement management
	 * @param file
	 * @param fileName
	 * @param type
	 * @param newAttachment
	 * @throws ALOCAttachmentException
	 * @throws ALOCException
	 */
	public void addUserAnnouncementAttachment(File file, String fileName, UserAnnouncement userAnnouncement, Attachment newAttachment) throws ALOCAttachmentException, ALOCException;

	/**
	 * This is used to delete for user announcement management attachment
	 * @param attachment
	 * @param userAnnouncement
	 * @param errorThrow
	 * @throws ALOCAttachmentException
	 * @throws ALOCException
	 */
	public void deleteUserAnnouncementAtmt(Attachment attachment,UserAnnouncement userAnnouncement,boolean errorThrow) throws ALOCAttachmentException, ALOCException;


	/**
	 * This method have implementation of download file from gelib of current attachment GE file id by calling core component
	 * @param outStream
	 * @param attachment
	 * @return
	 * @throws ALOCException
	 */
	public void downloadUserAnnouncementAttachment(OutputStream outStream, Attachment attachment) throws ALOCException;
	
	/**
	 * This method downloads the static files from GE lib
	 * 
	 * @param outStream
	 * @param attachment
	 * @throws ALOCAttachmentException
	 */
	public void downloadStaticAttachment(OutputStream outStream, Attachment attachment) throws ALOCAttachmentException,ALOCException;

}
