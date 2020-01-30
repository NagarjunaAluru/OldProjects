/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ALOCAttachmentManager.java
 * Purpose: This class implements the attachments functionality of entire application
 * 
 */
package com.ge.aloc.manager.impl;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.ge.aloc.ALOCContext;
import com.ge.aloc.AttachmentType;
import com.ge.aloc.InstrumentType;
import com.ge.aloc.OpCode;
import com.ge.aloc.StaticDataFactory;
import com.ge.aloc.common.util.AttachmentUtils;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.exception.ALOCAttachmentException;
import com.ge.aloc.exception.ALOCException;
import com.ge.aloc.manager.IALOCAttachmentManager;
import com.ge.aloc.model.Attachment;
import com.ge.aloc.model.NameValue;
import com.ge.aloc.model.RequestDetails;
import com.ge.aloc.model.UserAnnouncement;
import com.ge.aloc.util.ALOCCommonHelper;
import com.hydus.hwf.context.UserContext;
import com.hydus.hwf.ge.attachments.AttachmentException;
import com.hydus.hwf.ge.attachments.AttachmentFolder;
import com.hydus.hwf.ge.attachments.AttachmentManager;
import com.hydus.hwf.ge.attachments.RepositoryFile;

/**
 *  This class will have implementation of all main features like attachment/download/delete file using GELIB.
 * @author rajeswari.guthi
 * 
 */
public class ALOCAttachmentManager implements IALOCAttachmentManager {

	/**
	 * LOGGER
	 */
	private static final Logger LOGGER = Logger.getLogger(ALOCAttachmentManager.class);
	private AttachmentManager attachmentManager;
	private String repositoryRootFolderId;	

	/**
	 * This is used to attach the uploaded file to ge library based on the attachment type 
	 * @param file
	 * @param fileName
	 * @param type
	 * @param newAttachment
	 * @throws ALOCAttachmentException
	 * @throws ALOCException
	 */
	public Attachment addAttachment(File file, String fileName, AttachmentType type, Attachment newAttachment) throws ALOCAttachmentException, ALOCException {
		RequestDetails request = (RequestDetails)ALOCContext.getActiveRequest().getModel();
		validateInput(file,fileName,request);
		if(newAttachment.getAttachmentId() == null) {
			newAttachment.setActionType(OpCode.INSERT.getOperationCode());
		} else {
			newAttachment.setActionType(OpCode.UPDATE.getOperationCode());
		}
		newAttachment.setAttachmentName(AttachmentUtils.generateFileName(fileName));
		newAttachment.setAttachmentOriginalName(fileName); 
		addAttachmentImpl(file, type, newAttachment);
		return newAttachment;
	}

	/**
	 * This is used to attach the ge standard format file to ge library based on the attachment type 
	 * @param content
	 * @param fileName
	 * @param type
	 * @return
	 */
	public Attachment addAttachment(String content, String fileName, AttachmentType type) throws ALOCAttachmentException, ALOCException {		
		Attachment attachment = new Attachment();
		attachment.setActionType(OpCode.INSERT.getOperationCode());
		attachment.setAttachmentName(AttachmentUtils.generateFileName(fileName));
		attachment.setAttachmentOriginalName(fileName); 
		addAttachmentImpl(new ByteArrayInputStream(content.getBytes()), type, attachment);
		return attachment;
	}
	
	/**
	 * This is used to validate the uploaded attachment before deleting 
	 * @param file
	 * @param fileName
	 */
	public void validateAtmtInput(File file, String fileName) throws ALOCAttachmentException, ALOCException {		
		RequestDetails request = (RequestDetails)ALOCContext.getActiveRequest().getModel();
		validateInput(file,fileName,request);
	}
	
	/**
	 * This is used to validate the uploaded User Announcement attachment before deleting 
	 * @param file
	 * @param fileName
	 */
	public void validateAnnounceMentAtmtInput(File file, String fileName,UserAnnouncement userAnnouncement) throws ALOCAttachmentException, ALOCException {		
		validateInput(file,fileName,userAnnouncement);
	}

	/**
	 * This is used to save the ge standard format file to ge library based on the attachment type  
	 * @param content
	 * @param fileName
	 * @param type
	 * @param attachment
	 */
	public void saveAttachment(String content, String fileName, AttachmentType type, Attachment attachment) throws ALOCException {
		attachment.setAttachmentName(AttachmentUtils.generateFormatFileName(type));
		attachment.setActionType(OpCode.UPDATE.getOperationCode());
		attachment.setAttachmentOriginalName(fileName); 
		addAttachmentImpl(new ByteArrayInputStream(content.getBytes()), type, attachment);
	}

	/**
	 *  This is used to add the ge standard format file to ge library based on the attachment type 
	 * @param content
	 * @param type
	 * @return
	 */
	public Attachment addFormatAttachment(String content, AttachmentType type) throws ALOCAttachmentException, ALOCException {
		Attachment attachment = new Attachment();	
		String fileName = AttachmentUtils.generateFormatFileName(type);
		attachment.setAttachmentName(fileName);
		attachment.setActionType(OpCode.INSERT.getOperationCode());
		addAttachmentImpl(new ByteArrayInputStream(content.getBytes()), type, attachment);
		return attachment;
	}	

	/**
	 *  This is used to save the ge standard format file to ge library based on the attachment type 
	 * @param content
	 * @param type
	 * @param attachment
	 */
	public void saveFormatAttachment(String content, AttachmentType type, Attachment attachment) throws ALOCAttachmentException, ALOCException {		
		attachment.setAttachmentName(AttachmentUtils.generateFormatFileName(type));
		attachment.setActionType(OpCode.UPDATE.getOperationCode());
		addAttachmentImpl(new ByteArrayInputStream(content.getBytes()), type, attachment);
	}

	/**
	 * This method have implementation of download file from gelib of current attachment GE file id by calling core component
	 * @param outStream
	 * @param attachment
	 * @throws ALOCAttachmentException
	 * @throws ALOCException
	 */
	public void downloadAttachment(OutputStream outStream, Attachment attachment) throws ALOCAttachmentException, ALOCException {
		RequestDetails request = null; 
		if(ALOCContext.getActiveRequest() != null)
			request = (RequestDetails)ALOCContext.getActiveRequest().getModel();
		validateAttachment(attachment);
		try {
			attachmentManager.download(outStream, createRepositoryAttachment(attachment));
		} catch (AttachmentException ae) {
			ALOCAttachmentException exception = convertException(ALOCAttachmentException.EC_DOWNLOAD, attachment, request, ae);
			LOGGER.error(exception.getMessage(), ae);
			throw exception;
		}
	}
	
	/**
	 * This method is used to download only for the Format Documents to display in UI
	 * @param outStream
	 * @param attachment
	 * @throws ALOCAttachmentException
	 * @throws ALOCException
	 */
	public void downloadFormatAttachment(OutputStream outStream, Attachment attachment) throws ALOCAttachmentException, ALOCException {
		RequestDetails request = null; 
		if(ALOCContext.getActiveRequest() != null)
			request = (RequestDetails)ALOCContext.getActiveRequest().getModel();
		validateAttachment(attachment);
		try {
			attachmentManager.download(outStream, createRepositoryAttachment(attachment));
		} catch (AttachmentException ae) {
			ALOCAttachmentException exception = convertException(ALOCAttachmentException.EC_DOWNLOAD, attachment, request, ae);
			LOGGER.error(exception.getMessage(), ae);
		}
	}
	
	/**
	 * This method downloads the static files from GE lib
	 * 
	 * @param outStream
	 * @param attachment
	 * @throws ALOCAttachmentException 
	 */
	public void downloadStaticAtmtData(OutputStream outStream, Attachment attachment) throws ALOCAttachmentException {
		com.hydus.hwf.ge.attachments.Attachment repAtmt = createRepositoryAttachment(attachment);
		String adminFolderId = ResourceBundle.getBundle(ALOCConstants.APP_CONFIG_FILE).getString(ALOCConstants.PROP_GELIB_ALOC_ADMIN_FOLDERID);
		AttachmentFolder folder = new AttachmentFolder();
		folder.setId(adminFolderId);
		repAtmt.setParentFolder(folder);
		
		try {
			attachmentManager.download(outStream, createRepositoryAttachment(attachment));
		} catch (AttachmentException ae) {
			ALOCAttachmentException exception = convertException(ALOCAttachmentException.EC_DOWNLOAD, attachment, null, ae);
			LOGGER.error(exception.getMessage(), ae);
			throw exception;
		}
	}

	

	/**
	 * This method downloads the static files from GE lib
	 * 
	 * @param outStream
	 * @param attachment
	 * @throws ALOCException 
	 */
	public void downloadStaticAttachment(OutputStream outStream, Attachment attachment) throws ALOCException {
		com.hydus.hwf.ge.attachments.Attachment repAtmt = createRepositoryAttachment(attachment);
		String adminFolderId = ResourceBundle.getBundle(ALOCConstants.APP_CONFIG_FILE).getString(ALOCConstants.PROP_GELIB_ALOC_ADMIN_FOLDERID);
		AttachmentFolder folder = new AttachmentFolder();
		folder.setId(adminFolderId);
		repAtmt.setParentFolder(folder);
		
		try {
			downloadAtmtData(outStream,attachment);
		} catch (AttachmentException ae) {
			ALOCAttachmentException exception = convertException(ALOCAttachmentException.EC_DOWNLOAD, attachment, null, ae);
			LOGGER.error(exception.getMessage(), ae);
			throw exception;
		}
	}
	

	/**
	 * This is used to download all the attachments to the mainzip
	 * @param outStream
	 * @param allAttachments
	 */
	public void downloadAllAttachmentsToZip(ZipOutputStream zipOutputStream ,List<Attachment> allAttachments) {		
		List<com.hydus.hwf.ge.attachments.Attachment> repAtmtList = createRepositoryAttachments(allAttachments);			 
		try {
			if(repAtmtList != null && !repAtmtList.isEmpty()) {
				ZipEntry zipEntry = null;
				for(RepositoryFile repFile : repAtmtList) {		
					zipEntry = new ZipEntry(repFile.getOriginalName());
					zipOutputStream.putNextEntry(zipEntry);				
					attachmentManager.download(zipOutputStream, repFile);	 
					zipOutputStream.closeEntry();
				}			
			}
		} catch (IOException ioe) {			
			String errMsg = new StringBuilder().append(ALOCConstants.ERROR_WHILE_DOWNLOADING_THE_FILE).append(repAtmtList).toString();
			LOGGER.error(errMsg, ioe);
			throw new AttachmentException(errMsg, ioe);
		} 
	}
	
	/**
	 * This is used to download for the outputstream
	 * @param outStream
	 */
	public void downloadAllAttachmentsAsZip(OutputStream outStream ,List<Attachment> allAttachments) {		
		List<com.hydus.hwf.ge.attachments.Attachment> repAtmtList = createRepositoryAttachments(allAttachments);
		downloadAsZipFile(outStream, repAtmtList);
	}
	
	
	
	/**
	 * 
	 * @param outStream
	 * @param files
	 */
	public void downloadAsZipFile(OutputStream outStream, List<? extends RepositoryFile> files) {					
		ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(outStream));
		try {			
			if(files != null && !files.isEmpty()) {
				ZipEntry zipEntry = null;
				for(RepositoryFile repFile : files) {
					zipEntry = new ZipEntry(repFile.getOriginalName());
					zipOutputStream.putNextEntry(zipEntry);
					attachmentManager.download(zipOutputStream, repFile);					
					zipOutputStream.closeEntry();
				}
				zipOutputStream.flush();
			}
		} catch (IOException ioe) {
			String errMsg = new StringBuilder().append(ALOCConstants.ERROR_WHILE_DOWNLOADING_THE_FILE).append(files).append(ALOCConstants.AS_ZIP).toString();
			LOGGER.error(errMsg, ioe);
			throw new AttachmentException(errMsg, ioe);
		} finally {
			try {
				if(zipOutputStream != null) { 
					zipOutputStream.close();
				}
			} catch (IOException ioe) {
				String errMsg = new StringBuilder().append(ALOCConstants.ERROR_WHILE_CLOSING_ZIPOUTPUT_STREAM).append(files).toString();
				LOGGER.warn(errMsg, ioe);
			}
			zipOutputStream = null;
		}
	}
	
	/**
	 * This is used to download for the outputstream
	 * @param outStream
	 * @throws ALOCException 
	 * @throws ALOCAttachmentException 
	 */
	public void downloadAtmtData(OutputStream outStream,Attachment atmt) throws ALOCAttachmentException, ALOCException {	
		ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();		
		downloadAttachment(byteOutputStream, atmt);	
		try {	
			
			byteOutputStream.writeTo(outStream);
			byteOutputStream.flush();
		} catch (IOException e) {			
			LOGGER.error(e.getMessage(), e);
		}finally{
			try {
				if(byteOutputStream != null) {
					byteOutputStream.close();
				}
			} catch (IOException ioe) {
				LOGGER.warn(ALOCConstants.SERVELET_OUTPUTSTREAM_ERROR, ioe);
			}
		}
		
	}


	/**
	 *  This method have implementation of download file from gelib of current attachment GE file id by calling core component
	 * @throws ALOCException 
	 * @see ALOCAttachmentManager#downloadAttachment(OutputStream, String)
	 */
	public Attachment downloadAttachment(OutputStream outStream, String repFileId) throws ALOCException {
		RequestDetails request = (RequestDetails)ALOCContext.getActiveRequest().getModel();		
		if(StringUtils.isBlank(repFileId)) {
			throw new ALOCAttachmentException(ALOCAttachmentException.EC_INVALID_INPUT_PARAMS,ALOCConstants.REPOSITORY_ID_NOT_NULL);
		}
		Attachment attachment = AttachmentUtils.getAttachmentByGELibId(repFileId, request);
		downloadAttachment(outStream, attachment);
		return attachment;
	}

	/**
	 * This is used to delete for the selected attachment
	 * @see com.ge.aloc.manager.IALOCAttachmentManager#delete(com.ge.aloc.model.Attachment)
	 */
	public void delete(Attachment attachment) throws ALOCAttachmentException, ALOCException {
		RequestDetails request = null;
		BigInteger atmtTypeId = (attachment != null) ? attachment.getAttachmentTypeId() : null;
		if(atmtTypeId != null && !(atmtTypeId.intValue() == AttachmentType.IBS.getId()) &&
				!(atmtTypeId.intValue() == AttachmentType.WEBCASH.getId()) && !(atmtTypeId.intValue() == AttachmentType.CSV.getId())){
			request = (RequestDetails)ALOCContext.getActiveRequest().getModel();
		}
		validateAttachment(attachment);

		if(LOGGER.isDebugEnabled()) {
			String msg = new StringBuilder().append(ALOCConstants.DELETING_FILE).append(attachment.getAttachmentName())					
					.append(ALOCConstants.FOR_THE_REQUEST).append((request != null) ?request.getRequestId():ALOCConstants.EMPTY_STRING).toString();
			LOGGER.debug(msg);
		}
		try {
			attachmentManager.delete(createRepositoryAttachment(attachment));
		} catch (AttachmentException ae) {
			ALOCAttachmentException exception = convertException(ALOCAttachmentException.EC_DELETE, attachment, request, ae);
			LOGGER.error(exception.getMessage(), ae);
			throw exception;
		}

		if(LOGGER.isDebugEnabled()) {
			String msg = new StringBuilder().append(ALOCConstants.SUCCESSFULLY_DELETED_THE_FILE).append(attachment.getAttachmentName())					
					.append(ALOCConstants.FOR_THE_REQUEST).append((request != null)?request.getRequestId():ALOCConstants.EMPTY_STRING).toString();
			LOGGER.debug(msg);
		}
		attachment.setActionType(OpCode.DELETE.getOperationCode());
	}

	/**
	 * This method have implementation of delete file from gelib by calling core component
	 * @param repFileId
	 * @return
	 * @throws ALOCAttachmentException
	 * @throws ALOCException
	 */
	public Attachment delete(String repFileId) throws ALOCException {
		RequestDetails request = (RequestDetails)ALOCContext.getActiveRequest().getModel();		
		Attachment attachment = AttachmentUtils.getAttachmentByGELibId(repFileId, request);
		delete(attachment);
		return attachment;
	}

	/**
	 * This is used to delete all the attachments
	 * @see com.ge.aloc.manager.IALOCAttachmentManager#deleteAllAttachments()
	 */
	public void deleteAllAttachments() throws ALOCAttachmentException, ALOCException {
		RequestDetails request = (RequestDetails)ALOCContext.getActiveRequest().getModel();
		List<Attachment> dealAttachments = request.getAttachments();
		delete(dealAttachments);		
	}

	/**
	 * This is used to delete the list of attachments
	 * @see com.ge.aloc.manager.IALOCAttachmentManager#delete(java.util.List)
	 */
	public void delete(List<Attachment> attachmentListToDelete) throws ALOCException {
		List<Attachment> attachmentsToDelete = new ArrayList<Attachment>(attachmentListToDelete);
		for(Attachment attachment : attachmentsToDelete) {
			delete(attachment);
		}
	}

	/**
	 * This is used to get the attachment manager
	 * @return the attachmentManager
	 */
	public AttachmentManager getAttachmentManager() {
		return attachmentManager;
	}

	/**
	 * This is used to set the attachment manager
	 * @param attachmentManager the attachmentManager to set
	 */
	public void setAttachmentManager(AttachmentManager attachmentManager) {
		this.attachmentManager = attachmentManager;
	}

	/**
	 * This is used to get the Repository Root Folder Id
	 * @return the repositoryRootFolderId
	 */
	public String getRepositoryRootFolderId() {
		return repositoryRootFolderId;
	}

	/**
	 * This is used to set the Repository Root Folder Id
	 * @param repositoryRootFolderId the repositoryRootFolderId to set
	 */
	public void setRepositoryRootFolderId(String repositoryRootFolderId) {
		this.repositoryRootFolderId = repositoryRootFolderId;
	}

	/* --------------------------------------------------------------------------------------------------------------------------------------------------------
	 * 										Attachment sub calls for the main methods 
	 * 	 -------------------------------------------------------------------------------------------------------------------------------------------------------- 
	 */

	/**
	 * 
	 * @param file
	 * @param fileName
	 * @param permissions
	 * @param allAttachments
	 * @return
	 * @throws ALOCException 
	 */
	private void addAttachmentImpl(Object file, AttachmentType attachmentType, Attachment newAttachment) throws ALOCException {
		newAttachment.setAttachmentTypeId(BigInteger.valueOf(attachmentType.getId()));
		newAttachment.setAttachmentType(attachmentType.getName());	
		String userSSO = UserContext.getContext().getuserDetails().getUserId();
		newAttachment.setAttachedBySSOID(userSSO);
		addAttachmentImpl(file, newAttachment);
	}

	/**
	 * @param file
	 * @param attachmentType
	 * @param allAttachments
	 * @param request
	 * @return
	 * @throws ALOCException 
	 */
	private void addAttachmentImpl(Object file, Attachment newAttachment) throws ALOCException {
		RequestDetails request = (RequestDetails)ALOCContext.getActiveRequest().getModel();

		if(LOGGER.isDebugEnabled()) {
			String msg = new StringBuilder().append(ALOCConstants.UPLOADING_FILE).append(newAttachment.getAttachmentName()).append(ALOCConstants.FOR_THE_REQUEST).append(request.getRequestId()).toString();
			LOGGER.debug(msg);
		}
		RepositoryFile repAttachment = createNewRepositoryAttachment(newAttachment);
		if(newAttachment.getAttachmentTypeId().intValue()==AttachmentType.STANDARD_FORMAT.getId()
				|| newAttachment.getAttachmentTypeId().intValue()==AttachmentType.OTHER.getId()
				|| newAttachment.getAttachmentTypeId().intValue()==AttachmentType.ISSUER.getId()
				|| newAttachment.getAttachmentTypeId().intValue()==AttachmentType.CLOSURE.getId()){
			ResourceBundle appConfig = ResourceBundle.getBundle(ALOCConstants.APP_CONFIG_FILE);	
			String requestIdMetaName = appConfig.getString(ALOCConstants.PROP_GELIBMATTR_REQUESTID);
			String instrumentTypeMetaName = appConfig.getString(ALOCConstants.PROP_GELIBMATTR_INSTRUMENTTYPE);
			String instrumentPurposeMetaName = appConfig.getString(ALOCConstants.PROP_GELIBMATTR_INSTRUMENTPURPOSE);
			String poleMetaName = appConfig.getString(ALOCConstants.PROP_GELIBMATTR_POLENAME);
			String closureDateMetaName = appConfig.getString(ALOCConstants.PROP_GELIBMATTR_CLOSEDDATE);
			String SiteMetaName = appConfig.getString(ALOCConstants.PROP_GELIBMATTR_SITENAME);
			String goldIdMetaName = appConfig.getString(ALOCConstants.PROP_GELIBMATTR_GOLDID);
			String userId = appConfig.getString(ALOCConstants.PROP_GELIBMATTR_USERID);
			
			repAttachment.metadata().put(requestIdMetaName, request.getRequestId()); //commented to get the GE library meta data permissions
			repAttachment.metadata().put(instrumentTypeMetaName, getInstrumentType(request));
			repAttachment.metadata().put(instrumentPurposeMetaName, ALOCCommonHelper.getInstrumentPurpose(request));
			repAttachment.metadata().put(SiteMetaName, request.getSiteName());
			if(request.getInstrReporting() != null && request.getInstrReporting().getPoleName()!=null){
				repAttachment.metadata().put(poleMetaName, (request.getInstrReporting().getPoleName()!=null ? request.getInstrReporting().getPoleName():ALOCConstants.EMPTY_STRING));
			}
			if(request.getNewExpDate()!= null){
				SimpleDateFormat dateFormat = new SimpleDateFormat(ALOCConstants.MM_DD_YYYY);
				Date newExpDate = request.getNewExpDate().getTime();
				repAttachment.metadata().put(closureDateMetaName, newExpDate!= null ? dateFormat.format(newExpDate.getTime()): null);
			}
			repAttachment.metadata().put(goldIdMetaName,ALOCCommonHelper.getLeGoldIDByInstrumentType(request));
			String userSSO = UserContext.getContext().getuserDetails() != null ? UserContext.getContext().getuserDetails().getUserId():ALOCConstants.EMPTY_STRING;
			repAttachment.metadata().put(userId,userSSO);
		}
		try {

			if(file instanceof File) {
				attachmentManager.save((File)file, repAttachment);
			} else if(file instanceof InputStream) {
				attachmentManager.save((InputStream) file, repAttachment);
			}
		} catch (AttachmentException ae) {
			LOGGER.error(ae.getMessage(), ae);
			if(ae.getMessage().indexOf(ALOCConstants.ATMT_METADATA)!=ALOCConstants.BASE_NEGATIVE_VALUE) {
				throw new ALOCAttachmentException(ALOCAttachmentException.EC_NO_METADATA_FOR_FOLDER, ae.getMessage());}
			else {
				throw convertException(ALOCAttachmentException.EC_UPLOAD, newAttachment,(Object)request,ae);}			
		}
		newAttachment.setGeFileId(repAttachment.getId());
		newAttachment.setGeLibraryReference(repAttachment.getLocation());
		newAttachment.setGeFolderId(repAttachment.getParentFolder().getId());

		if(LOGGER.isDebugEnabled()) {
			String msg = new StringBuilder().append(ALOCConstants.SUCCESSFULLY_UPLOADED).append(newAttachment.getAttachmentName())					
					.append(ALOCConstants.FOR_THE_REQUEST).append(request.getRequestId()).toString();
			LOGGER.debug(msg);
		}
	}

	/**
	 * This method is used to get the instrument type based on instrument typeId
	 * @param request
	 * @return
	 */
	private String getInstrumentType(RequestDetails request) {
		String instrumentType = ALOCConstants.EMPTY_STRING;
		if (request.getInstrumentType() != null) {
			instrumentType = request.getInstrumentType();
		} else {
			if(request.getInstrumentTypeId() != null){
				instrumentType = InstrumentType.fromId(request.getInstrumentTypeId().intValue()).getName();
			}
		}
		return instrumentType;
	}

	/**
	 *  This method used to validate input file is blank or empty
	 * @param attachment
	 * @throws ALOCAttachmentException
	 */
	private void validateAttachment(Attachment attachment) throws ALOCAttachmentException {
		if(attachment == null || StringUtils.isBlank(attachment.getGeFileId()== null?attachment.getAttachmentName():attachment.getGeFileId())) {
			throw new ALOCAttachmentException(ALOCAttachmentException.EC_INVALID_INPUT_PARAMS, ALOCConstants.INVALID_ATTACHMENT);
		}
	}	

	/**
	 * @param errorCode
	 * @param file
	 * @param request
	 * @return
	 */
	private ALOCAttachmentException createException(String errorCode, File file,Object object) {
		ALOCAttachmentException exception = new ALOCAttachmentException(errorCode);
		if(object instanceof RequestDetails) {
			exception.setRequestId(((RequestDetails) object).getRequestId()); }
		else {
			exception.setUserAnnouncementID(((UserAnnouncement) object).getUserAnnouncementID()); }

		Attachment newAttachment = new Attachment();
		newAttachment.setAttachmentName(file.getName());		
		exception.setAttachment(newAttachment);				
		return exception;
	}

	/**
	 * @param errorCode
	 * @param attachment
	 * @param request
	 * @param t
	 * @return
	 */
	private ALOCAttachmentException convertException(String errorCode, Attachment attachment, Object object, Throwable t) {
		ALOCAttachmentException attachmentException = new ALOCAttachmentException(errorCode, t);
		attachmentException.setAttachment(attachment);
		if(object instanceof RequestDetails) {
			attachmentException.setRequestId(((RequestDetails) object).getRequestId()); }
		else {
			attachmentException.setUserAnnouncementID(((UserAnnouncement) object).getUserAnnouncementID());}
		return attachmentException;
	}

	/**
	 * @param attachmentType
	 * @param attachment
	 * @param request
	 * @return
	 * @throws ALOCException
	 */
	private com.hydus.hwf.ge.attachments.Attachment createNewRepositoryAttachment(Attachment attachment) throws ALOCException {
		com.hydus.hwf.ge.attachments.Attachment repAttachment = new com.hydus.hwf.ge.attachments.Attachment();		
		repAttachment.setName(attachment.getAttachmentName());
		repAttachment.setTitle(attachment.getAttachmentName());
		repAttachment.setUserId(attachment.getAttachedBySSOID());		
		AttachmentFolder parentFolder = getRootFolder();
		attachment.setGeFileId(parentFolder.getId());
		repAttachment.setParentFolder(parentFolder);
		return repAttachment;
	}


	/**
	 * @param type
	 * @param request
	 * @return
	 */
	private AttachmentFolder getRootFolder() {		
		String parentFolderId =  repositoryRootFolderId;	
		AttachmentFolder folder = new AttachmentFolder();
		folder.setId(parentFolderId);		
		return folder;
	}

	/**
	 * 
	 * @param alocAttachments
	 * @return
	 */
	private List<com.hydus.hwf.ge.attachments.Attachment> createRepositoryAttachments(List<Attachment> alocAttachments) {
		List<com.hydus.hwf.ge.attachments.Attachment> result = new ArrayList<com.hydus.hwf.ge.attachments.Attachment>();
		if(alocAttachments != null && !alocAttachments.isEmpty()) {
			for(Attachment atmt : alocAttachments) {
				result.add(createRepositoryAttachment(atmt));
			}
		}
		return result;
	}

	/**
	 * Create DTO object using input data from GELIb
	 * @param attachment
	 * @return
	 */
	private com.hydus.hwf.ge.attachments.Attachment createRepositoryAttachment(Attachment attachment) {
		com.hydus.hwf.ge.attachments.Attachment repAttachment = new com.hydus.hwf.ge.attachments.Attachment();
		repAttachment.setId(attachment.getGeFileId());
		repAttachment.setName(attachment.getAttachmentName());	
		repAttachment.setOriginalName(attachment.getAttachmentOriginalName() != null ?attachment.getAttachmentOriginalName() :attachment.getAttachmentName());	
		AttachmentFolder parentFolder = new AttachmentFolder();
		parentFolder.setId(attachment.getGeFolderId());
		repAttachment.setParentFolder(parentFolder);
		return repAttachment;
	}


	/**
	 * This is used to validate the input data
	 * @param file
	 * @param request
	 * @throws ALOCAttachmentException
	 */
	protected void validateInput(File file,String fileName,Object obj) throws ALOCAttachmentException {			
		// Validating file name		
		if(fileName.length() >= ALOCConstants.FILENAME_MAX_LENGTH) {
			throw createException(ALOCAttachmentException.EC_INVALID_FILENAME, file,obj);
		}

		int extStartIndex = fileName.lastIndexOf('.');
		if(extStartIndex <= ALOCConstants.MIN_INDEX) {
			throw createException(ALOCAttachmentException.EC_INVALID_FILENAME, file,obj);
		}

		String name = fileName.substring(ALOCConstants.MIN_INDEX, extStartIndex);
		if(ALOCConstants.ALLOWED_CHAR_PATTERN.matcher(name).find()) {
			throw createException(ALOCAttachmentException.EC_SPECIAL_CHARS_FILENAME, file,obj);
		}
		if(file.length()>ALOCConstants.UPLOADEDFILE_MAXSIZE) {		
			throw createException(ALOCAttachmentException.EC_FILE_SIZE_LIMIT, file,obj);
		}

		String ext = fileName.substring(extStartIndex);
		validateExtension(file, ext,obj);
	}	

	/**
	 * This is used to validate the file extensions
	 * @param file
	 * @param request
	 * @param ext
	 * @throws ALOCAttachmentException
	 */
	public void validateExtension(File file,String ext,Object object) throws ALOCAttachmentException {
		List<NameValue> allowedExtensions = ALOCContext.getStaticDataFactory().getFileExtnsList();	
		if(StringUtils.isNotBlank(ext)) {
			for(NameValue eachExt : allowedExtensions) {
				if(eachExt.getName().equalsIgnoreCase(ext)) {
					return;
				}
			}
		}
		ALOCAttachmentException exception = createException(ALOCAttachmentException.EC_INVALID_FILEEXTENSION, file,object);
		String[] allowedExtns = getAllowedExtensions();
		exception.setFileExtensions(allowedExtns);
		throw exception;
	}

	/**
	 * Method to get the file extensions
	 * @return
	 */
	private String[] getAllowedExtensions(){
		List<String> allowedExtnsList = new ArrayList<String>();		
		StaticDataFactory staticDataFactory =ALOCContext.getStaticDataFactory(); 
		List <NameValue> fileExtnTypes = staticDataFactory.getFileExtnsList();
		for(NameValue namevalue:fileExtnTypes){
			allowedExtnsList.add(namevalue.getName());
		}
		String [] allowedExtns = allowedExtnsList.toArray(new String[allowedExtnsList.size()]);		
		return allowedExtns;
	}

	/*======================================================User Announcement Management Attachments ============================*/

	/**
	 * This is used to attach the uploaded file to ge library based on the attachment type for user announcement management
	 * @param file
	 * @param fileName
	 * @param type
	 * @param newAttachment
	 * @throws ALOCAttachmentException
	 * @throws ALOCException
	 */
	public void addUserAnnouncementAttachment(File file, String fileName, UserAnnouncement userAnnouncement, Attachment newAttachment) throws ALOCAttachmentException, ALOCException {
		validateInput(file,fileName,userAnnouncement);
		if(newAttachment.getAttachmentId() == null) {
			newAttachment.setActionType(OpCode.INSERT.getOperationCode());
		} else {
			newAttachment.setActionType(OpCode.UPDATE.getOperationCode());
		}
		newAttachment.setAttachmentName(AttachmentUtils.generateFileNameForUserAnnouncement(fileName));
		newAttachment.setAttachmentOriginalName(fileName); 
		addUserAnnouncementAttachmentImpl(file, userAnnouncement, newAttachment);
		newAttachment.setDeleteFlag(ALOCConstants.N_CAP);
	}

	/**
	 * 
	 * @param file
	 * @param fileName
	 * @param permissions
	 * @param allAttachments
	 * @return
	 * @throws ALOCException 
	 */
	private void addUserAnnouncementAttachmentImpl(Object file, UserAnnouncement userAnnouncement, Attachment newAttachment) throws ALOCException {
		String userSSO = UserContext.getContext().getuserDetails().getUserId();
		newAttachment.setAttachedBySSOID(userSSO);
		addUserAnnouncementAttachmentImpl(file, newAttachment,userAnnouncement);
	}

	/**
	 * @param file
	 * @param attachmentType
	 * @param allAttachments
	 * @param request
	 * @return
	 * @throws ALOCException 
	 */
	private void addUserAnnouncementAttachmentImpl(Object file, Attachment newAttachment,UserAnnouncement userAnnouncement) throws ALOCException {
		if(LOGGER.isDebugEnabled()) {
			String msg = new StringBuilder().append(ALOCConstants.UPLOADING_FILE).append(newAttachment.getAttachmentName()).append(ALOCConstants.FOR_THE_REQUEST).append(userAnnouncement.getUserAnnouncementID()).toString();
			LOGGER.debug(msg);
		}
		RepositoryFile repAttachment = createNewRepositoryAttachment(newAttachment);
		try {
			if(file instanceof File) {
				attachmentManager.save((File)file, repAttachment);
			} else if(file instanceof InputStream) {
				attachmentManager.save((InputStream) file, repAttachment);
			}
		} catch (AttachmentException ae) {
			ALOCAttachmentException exception = convertException(ALOCAttachmentException.EC_UPLOAD, newAttachment, userAnnouncement, ae);
			LOGGER.error(exception.getMessage(), ae);
			throw exception;
		}
		newAttachment.setGeFileId(repAttachment.getId());
		newAttachment.setGeLibraryReference(repAttachment.getLocation());
		newAttachment.setGeFolderId(repAttachment.getParentFolder().getId());

		if(LOGGER.isDebugEnabled()) {
			String msg = new StringBuilder().append(ALOCConstants.SUCCESSFULLY_UPLOADED).append(newAttachment.getAttachmentName())					
					.append(ALOCConstants.FOR_THE_REQUEST).append(userAnnouncement.getUserAnnouncementID()).toString();
			LOGGER.debug(msg);
		}
	}

	/**
	 * This method have implementation of download file from gelib of current attachment GE file id by calling core component
	 * @param outStream
	 * @param attachment
	 * @return
	 * @throws ALOCException
	 */
	public void downloadUserAnnouncementAttachment(OutputStream outStream,Attachment attachment) throws ALOCException {
		if(StringUtils.isBlank(attachment.getGeFileId())) {
			throw new ALOCAttachmentException(ALOCAttachmentException.EC_INVALID_INPUT_PARAMS,ALOCConstants.REPOSITORY_ID_NOT_NULL);
		}			
		validateAttachment(attachment);
		try {
			attachmentManager.download(outStream, createRepositoryAttachment(attachment));
		} catch (AttachmentException ae) {
			ALOCAttachmentException exception = convertException(ALOCAttachmentException.EC_DOWNLOAD, attachment, null, ae);
			LOGGER.error(exception.getMessage(), ae);
			throw exception;
		}		
	}

	/**
	 * This is used to delete for the selected attachment
	 * @see com.ge.aloc.manager.IALOCAttachmentManager#delete(com.ge.aloc.model.Attachment)
	 */
	public void deleteUserAnnouncementAtmt(Attachment attachment,UserAnnouncement userAnnouncement,boolean errorThrow) throws ALOCAttachmentException, ALOCException {		
		validateAttachment(attachment);		
		if(LOGGER.isDebugEnabled()) {
			String msg = new StringBuilder().append(ALOCConstants.DELETING_FILE).append(attachment.getAttachmentName())					
					.append(ALOCConstants.FOR_THE_REQUEST).append(userAnnouncement.getUserAnnouncementID()).toString();
			LOGGER.debug(msg);
		}
		try {
			attachmentManager.delete(createRepositoryAttachment(attachment));
		} catch (AttachmentException ae) {
			ALOCAttachmentException exception = convertException(ALOCAttachmentException.EC_DELETE, attachment, userAnnouncement, ae);
			LOGGER.error(exception.getMessage(), ae);
			if(errorThrow){
				throw exception;
			}
		}

		if(LOGGER.isDebugEnabled()) {
			String msg = new StringBuilder().append(ALOCConstants.SUCCESSFULLY_DELETED_THE_FILE).append(attachment.getAttachmentName())					
					.append(ALOCConstants.FOR_THE_REQUEST).append(userAnnouncement.getUserAnnouncementID()).toString();
			LOGGER.debug(msg);
		}
		attachment.setActionType(OpCode.DELETE.getOperationCode());
	}

	/**
	 * This is used to add APM webcash/IBS Invoice content to ge library based on the attachment type 
	 * @param content
	 * @param fileName
	 * @param type
	 * @return
	 * @throws ALOCAttachmentException
	 * @throws ALOCException
	 */
	public Attachment addAPMAttachment(String content,String fileName,Attachment attachment)
			throws ALOCAttachmentException, ALOCException {					
		attachment.setAttachmentName(fileName);
		attachment.setAttachmentOriginalName(fileName);
		String userSSO = UserContext.getContext().getuserDetails().getUserId();
		attachment.setAttachedBySSOID(userSSO);					
		RepositoryFile repAttachment = createNewRepositoryAttachment(attachment);
		Object file = new ByteArrayInputStream(content.getBytes());
		try {
			if(file instanceof InputStream) {
				attachmentManager.save((InputStream) file, repAttachment);
			}
		} catch (AttachmentException ae) {
			LOGGER.error(ae.getMessage(), ae);			
			throw convertException(ALOCAttachmentException.EC_UPLOAD, attachment,null,ae);			
		}
		attachment.setGeFileId(repAttachment.getId());
		attachment.setGeLibraryReference(repAttachment.getLocation());
		attachment.setGeFolderId(repAttachment.getParentFolder().getId());

		if(LOGGER.isDebugEnabled()) {
			String msg = new StringBuilder().append(ALOCConstants.SUCCESSFULLY_UPLOADED).append(attachment.getAttachmentName()).toString();
			LOGGER.debug(msg);
		}
		return attachment;		
	}
	
	/**
	 * This is used to add APM webcash/IBS Invoice content to ge library based on the attachment type 
	 * @param content
	 * @param fileName
	 * @param type
	 * @return
	 * @throws ALOCAttachmentException
	 * @throws ALOCException
	 */
	public Attachment addCSVAttachment(byte[] data, Attachment attachment)
			throws ALOCAttachmentException, ALOCException {					
		RepositoryFile repAttachment = createNewRepositoryAttachment(attachment);
		try {
			attachmentManager.save(data, repAttachment);
		} catch (AttachmentException ae) {
			LOGGER.error(ae.getMessage(), ae);			
		}
		attachment.setGeFileId(repAttachment.getId());
		attachment.setGeLibraryReference(repAttachment.getLocation());
		attachment.setGeFolderId(repAttachment.getParentFolder().getId());

		if(LOGGER.isDebugEnabled()) {
			String msg = new StringBuilder().append(ALOCConstants.SUCCESSFULLY_UPLOADED).append(attachment.getAttachmentName()).toString();
			LOGGER.debug(msg);
		}
		return attachment;		
	}

}
