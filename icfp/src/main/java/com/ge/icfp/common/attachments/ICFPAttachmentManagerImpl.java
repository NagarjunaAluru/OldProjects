/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: ICFPAttachmentManager.java
 * Purpose: This class implements the attachments functionality of entire application
 */
package com.ge.icfp.common.attachments;

import static com.ge.icfp.common.attachments.IAttachmentConstants.OPCODE_DEAL;
import static com.ge.icfp.common.attachments.IAttachmentConstants.OPCODE_DELETE;
import static com.ge.icfp.common.attachments.IAttachmentConstants.OPCODE_INSERT;
import static com.ge.icfp.common.attachments.IAttachmentConstants.OPCODE_INSTANTATTCHOP;
import static com.ge.icfp.common.attachments.IAttachmentConstants.OPCODE_UPDATE;
import static com.ge.icfp.common.attachments.IAttachmentConstants.STATUS_SUCCESS;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts.upload.FormFile;

import com.ge.icfp.action.ICFPException;
import com.ge.icfp.common.helper.CurrentDealManager;
import com.ge.icfp.common.helper.ICFPCommonHelper;
import com.ge.icfp.common.helper.ICFPDay2LegHelper;
import com.ge.icfp.common.helper.ICFPLegHelper;
import com.ge.icfp.model.Amendment;
import com.ge.icfp.model.Attachment;
import com.ge.icfp.model.DealRequest;
import com.ge.icfp.model.DerivativesRequest;
import com.ge.icfp.model.ExceptionRequestForm;
import com.ge.icfp.model.MsgHeader;
import com.ge.icfp.util.StaticDataFactory;
import com.ge.icfp.util.report.pdf.DealPDFGenerator;
import com.ge.icfp.util.report.pdf.ReportType;
import com.hydus.wff.common.bw.ServiceClient;
import com.hydus.wff.core.context.UserContext;
import com.hydus.wff.core.exception.HWFServiceException;
import com.hydus.wff.core.exception.HWFStubException;
import com.hydus.wff.ge.attachments.AttachmentException;
import com.hydus.wff.ge.attachments.AttachmentFolder;
import com.hydus.wff.ge.attachments.AttachmentManager;
import com.hydus.wff.ge.attachments.RepositoryFile;

/**
 * This class will have implementation of all main features like attachment/download/delete file using GELIB.
 * @author chaitanya.n
 *
 */
public class ICFPAttachmentManagerImpl implements ICFPAttachmentManager {
	
	private static final Logger LOGGER = Logger.getLogger(ICFPAttachmentManagerImpl.class);
	
	private static final Pattern SPL_CHAR_PATTERN = Pattern.compile("[<>:/\\|*'%.+=#]");
	
	private static final String[] ALLOWED_EXTENSTIONS = new String[] {
		".doc", ".docx", ".docm",".xml",".html",".htm", ".dotx",".dotm",".dot",
		".rtf",".txt",".odt",".wpd",".wps",".zip",".xls",".xlsx",".ppt",".pptx",".pdf",".msg"
	};
	
	private AttachmentManager manager;
	private String repositoryRootFolderId;
	private String repositoryCPARootFolderId;
	private String cpaLegalAgreementsFolderId;
	private Properties configuration;
	private ServiceClient serviceClient;
	private long maxFileSize;
	private StaticDataFactory staticDataFactory;
	
	/**
	 *  This method have implementation of read the form file for particular attachment type and
	 *  its download file in local directory and uploads in GElib using the component
	 *  also call the bw service call.
	 * @throws ICFPException 
	 * @see ICFPAttachmentManager#addAttachment(File, AttachmentType, DealRequest, Integer, Integer, Integer, Integer)
	 */
	public Attachment addAttachment(FormFile file, AttachmentType type, String comments, DealRequest deal, Integer legIndex, Integer derivativeIndex, Integer exceptionIndex, Integer ammendmentIndex) throws ICFPException {
		Attachment newAttachment = null;
		switch(type) {
			case DERIVATIVE_TRADE_TICKET:
				newAttachment = addDerivativeAttachment(file, type, comments, deal, legIndex, derivativeIndex);
				break;
			case EXCEPTIONS_ATTACHMENTS:
				newAttachment = addExceptionAttachment(file, type, comments, deal, legIndex, exceptionIndex);
				break;
			case AMENDMENTS_ATTACHMENTS:
				newAttachment = addAmendmentAttachment(file, type, comments, deal, legIndex, ammendmentIndex);
				break;
			default:
				if(AttachmentType.isDealAttachmentType(type)) {
					newAttachment = addDealAttachment(file, type, comments, deal);
				} else if(AttachmentType.isLegAttachmentType(type)) {
					List<Attachment> newAttachmentsList = addLegAttachment(file, type, comments, deal, legIndex);
					newAttachment = newAttachmentsList.get(0);
				}
				break;
		}
		return newAttachment;
	}
	
	/**
	 * This method have implementation of read the form file for deal attachment and
	 *  its download file in local directory and uploads in GElib using the component 
	 *  also call the bw service call.
	 * @throws ICFPException 
	 * @see ICFPAttachmentManager#addDealAttachment(File, AttachmentType, DealRequest)
	 */
	public Attachment addDealAttachment(FormFile file, AttachmentType type, String comments, DealRequest deal) throws ICFPException {
		validateInput(file, type, deal, null, null, null, null);
		List<Attachment> dealAttachments = deal.getAttachments();
		Attachment attachment = addAttachmentImpl(file, type, comments, dealAttachments, deal, null, null, null, null);
		return attachment;
	}

	/**
	 * This method have implementation of read the form file for leg attachment for particular attachment type 
	 *  and its download file in local directory and uploads in GElib using the core component 
	 *  also call the bw service call.
	 * @throws ICFPException 
	 * @see ICFPAttachmentManager#addLegAttachment(File, AttachmentType, DealRequest, Integer...)
	 */
	public List<Attachment> addLegAttachment(FormFile file, AttachmentType type, String comments, DealRequest deal, Integer... legIndexes) throws ICFPException {
		List<Attachment> newAttachmentsList = new ArrayList<Attachment>();
		if(legIndexes != null && legIndexes.length > 0) {
			for(Integer index : legIndexes) {
				validateInput(file, type, deal, index, null, null, null);
				Object leg = AttachmentUtils.getLeg(index, deal);
				List<Attachment> legAttachments = ICFPLegHelper.getAttachments(leg);
				Attachment attachment = addAttachmentImpl(file, type, comments, legAttachments, deal, leg, null, null, null);
				attachment.setLegSeqId(ICFPLegHelper.getLegSeqId(leg));
				newAttachmentsList.add(attachment);
			}
		}
		return newAttachmentsList;
	}
	
	/**
	 *  This method have implementation of read the form file for derivative attachment for particular attachment type 
	 *  and its download file in local directory and uploads in GElib using the core component 
	 *  also call the bw service call.
	 * @throws ICFPException 
	 * @see ICFPAttachmentManager#addDerivativeAttachment(File, AttachmentType, DealRequest, Integer, Integer)
	 */
	public Attachment addDerivativeAttachment(FormFile file, AttachmentType type, String comments, DealRequest deal, Integer legIndex, Integer derivativeIndex) throws ICFPException {
		validateInput(file, type, deal, legIndex, derivativeIndex, null, null);
		Object leg = AttachmentUtils.getLeg(legIndex, deal);
		DerivativesRequest derivativesRequest = AttachmentUtils.getDerivativeRequest(derivativeIndex, leg);
		List<Attachment> attachmentList = derivativesRequest.getAttachments();
		Attachment attachment = addAttachmentImpl(file, type, comments, attachmentList, deal, leg, derivativesRequest, null, null);
		return attachment;
	}

	/**
	 *  This method have implementation of read the form file for exception attachment for particular attachment type 
	 *  and its download file in local directory and uploads in GElib using the core component 
	 *  also call the bw service call.
	 * @throws ICFPException 
	 * @see ICFPAttachmentManager#addExceptionAttachment(File, AttachmentType, DealRequest, Integer, Integer)
	 */
	public Attachment addExceptionAttachment(FormFile file, AttachmentType type, String comments, DealRequest deal, Integer legIndex, Integer exceptionIndex) throws ICFPException {
		validateInput(file, type, deal, legIndex, null, exceptionIndex, null);
		Object leg = AttachmentUtils.getLeg(legIndex, deal);
		ExceptionRequestForm exception = ICFPLegHelper.getExceptionRequestFormCreateIfNot(exceptionIndex, leg);
		List<Attachment> attachmentList = exception.getAttachments();
		Attachment attachment = addAttachmentImpl(file, type, comments, attachmentList, deal, leg, null, exception, null);
		return attachment;
	}

	/**
	 *  This method have implementation of read the form file for amendment attachment for particular attachment type 
	 *  and its download file in local directory and uploads in GElib using the core component 
	 *  also call the bw service call.
	 * @throws ICFPException 
	 * @see ICFPAttachmentManager#addAmmendmentAttachment(File, AttachmentType, DealRequest, Integer, Integer)
	 */
	public Attachment addAmendmentAttachment(FormFile file, AttachmentType type, String comments, DealRequest deal, Integer legIndex, Integer amendmentIndex) throws ICFPException {
		validateInput(file, type, deal, legIndex, null, null, amendmentIndex);
		Object leg = AttachmentUtils.getLeg(legIndex, deal);
		Amendment amendment = ICFPDay2LegHelper.getAmendmentCreateIfNot(amendmentIndex, leg);
		List<Attachment> attachmentList = amendment.getAttachments();
		Attachment attachment = addAttachmentImpl(file, type, comments, attachmentList, deal, leg, null, null, amendment);
		return attachment;
	}

	/**
	 *  This method have implementation of download file from gelib of current attachment GE file id by calling core component
	 * @throws ICFPException 
	 * @see ICFPAttachmentManager#downloadAttachment(OutputStream, String, DealRequest)
	 */
	public Attachment downloadAttachment(OutputStream outStream, String repFileId, DealRequest deal) throws ICFPException {
		if(StringUtils.isBlank(repFileId)) {
			throw new ICFPAttachmentException(ICFPAttachmentException.ERROR_CODE_INVALID_INPUT_PARAMS, "Repository ID should not be null or empty");
		}
		Attachment attachment = AttachmentUtils.getAttachmentByGELibId(repFileId, deal);
		downloadAttachment(outStream, attachment, deal);
		return attachment;
	}
	
	/**
	 * This method have implementation of download file from gelib of current attachment GE file id
	 * by calling core component
	 * @throws ICFPException 
	 * @see ICFPAttachmentManager#downloadAttachment(OutputStream, Attachment)
	 */
	public void downloadAttachment(OutputStream outStream, Attachment attachment, DealRequest deal) throws ICFPAttachmentException {
		validateAttachment(attachment);
		try {
			manager.download(outStream, createRepositoryAttachment(attachment));
		} catch (AttachmentException ae) {
			ICFPAttachmentException exception = convertException(ICFPAttachmentException.ERROR_CODE_DOWNLOAD, attachment, deal, ae);
			LOGGER.error(exception.getMessage(), ae);
			throw exception;
		}
	}

	/**
	 *  This method have implementation of delete file from gelib by calling core component
	 * @throws ICFPException 
	 * 
	 */
	public Attachment delete(String repFileId, DealRequest deal) throws ICFPException {
		Attachment attachment = AttachmentUtils.getAttachmentByGELibId(repFileId, deal);
		delete(attachment, deal);
		return attachment;
	}
	
	/**
	 *  This method have implementation of delete all files from gelib of current deal
	 * @throws ICFPException 
	 */
	public void deleteAllAttachments(DealRequest deal) throws ICFPAttachmentException, ICFPException {
		List<Attachment> dealAttachments = deal.getAttachments();
		delete(dealAttachments, deal);
		Map<Integer, Object> attachmentLegs = AttachmentUtils.getAllAttachmentLegsWithIndexes(deal);
		for(Iterator<Object> legItr = attachmentLegs.values().iterator(); legItr.hasNext(); ) {
			deleteAllLegAttachments(legItr.next(), deal);
		}
	}
	
	/**
	 * 	 This method have implementation of delete all files from gelib of current leg and also call bw service call
	 * @throws ICFPException
	 */
	public void deleteAllLegAttachments(Object leg, DealRequest deal) throws ICFPAttachmentException, ICFPException {
		Collection<Attachment> allLegAttachments = AttachmentUtils.getAllLegAttachments(leg);
		for(Attachment attachment: allLegAttachments) {
			delete(attachment, deal);
		}
	}
	
	/**
	 * 	This method have implementation of delete all files from gelib of current deal and also call bw service call
	 * 
	 * @param attachmentListToDelete
	 * @param deal
	 * @throws ICFPException
	 */
	public void delete(List<Attachment> attachmentListToDelete, DealRequest deal) throws ICFPException {
		List<Attachment> attachmentsToDelete = new ArrayList<Attachment>(attachmentListToDelete);
		for(Attachment attachment : attachmentsToDelete) {
			delete(attachment, deal);
		}
	}

	/**
	 * service call to set the delete opcode for particular attachment object
	 * @throws ICFPException 
	 * @see ICFPAttachmentManager#delete(Attachment)
	 */
	public void delete(Attachment attachment, DealRequest deal) throws ICFPException {
		validateAttachment(attachment);
		
		if(LOGGER.isDebugEnabled()) {
			String msg = new StringBuilder().append("Deleteting the file ").append(attachment.getOrigAttachmentName())
					.append(" of type ").append(AttachmentType.fromId(attachment.getAttachmentTypeId()))
					.append(" for the deal ").append(deal.getDealSeqId()).toString();
			LOGGER.debug(msg);
		}
		
		// Deleting from the database
		DealRequest result = invokeService(deal, attachment, OPCODE_DELETE, DealRequest.class);
		if(result != null && STATUS_SUCCESS.equalsIgnoreCase(result.getMsgHeader().getStatus())) {
			if(LOGGER.isInfoEnabled()) {
				StringBuilder msg = new StringBuilder();
				msg.append("Attachment with GEFileID \'").append(attachment.getGeFileId()).append("\' of the deal ")
				.append(deal.getDealSeqId()).append(" has been deleted successfully.");
				LOGGER.info(msg.toString());
			}
		} else {
			ICFPAttachmentException exception = new ICFPAttachmentException(ICFPAttachmentException.ERROR_CODE_DELETE);
			exception.setAttachment(attachment);
			exception.setDealSeqId(deal.getDealSeqId());
			throw exception;
		}
		
		AttachmentUtils.deleteAttachmentByGELibId(attachment.getGeFileId(), deal);
		
		// Deleting from GELib
		try {
			manager.delete(createRepositoryAttachment(attachment));
		} catch (AttachmentException ae) {
			ICFPAttachmentException exception = convertException(ICFPAttachmentException.ERROR_CODE_DELETE, attachment, deal, ae);
			LOGGER.error(exception.getMessage(), ae);
			throw exception;
		}
		
		if(LOGGER.isDebugEnabled()) {
			String msg = new StringBuilder().append("Successfully Deleted the file ").append(attachment.getOrigAttachmentName())
					.append(" of type ").append(AttachmentType.fromId(attachment.getAttachmentTypeId()))
					.append(" for the deal ").append(deal.getDealSeqId()).toString();
			LOGGER.debug(msg);
		}
	}

	/**
	 * 
	 * Method used to call metadata each leg for current deal
	 * @throws ICFPException 
	 * @see ICFPAttachmentManager#updateMetadataBeforeSubmitDeal(DealRequest)
	 */
	public void updateMetadataForAllAttachments(DealRequest deal) throws ICFPException {
		updateMetadata(deal.getAttachments(), null, deal);
		Collection<Object> allLegs = AttachmentUtils.getAllAttachmentLegsWithIndexes(deal).values();
		for(Object leg : allLegs) {
			updateMetadataForAllLegAttachments(leg, deal);
		}
	}
	
	/**
	 * Method used to call metadata specific leg for current deal
	 * @throws ICFPException,ICFPAttachmentException 
	 */
	public void updateMetadataForAllLegAttachments(Object leg, DealRequest deal) throws ICFPAttachmentException, ICFPException {
		Collection<Attachment> allLegAttachments = AttachmentUtils.getAllLegAttachments(leg);
		if(!allLegAttachments.isEmpty()) {
			updateMetadata(allLegAttachments, leg, deal);
		}
	}
	
	/**
	 * This method uploads the Under Writing file to GE libraries.
	 * 
	 */
	public void uploadUnerWritingFile(HttpServletRequest request) throws ICFPAttachmentException, ICFPException {
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		DealPDFGenerator pdfGenerator = new DealPDFGenerator(deal);
		pdfGenerator.init(request, ReportType.UNDERWRITING);
		deleteOldFileIfNecessary(AttachmentType.UNDERWRITING, deal.getAttachments(),deal);
		// Creating attachment object for Underwriting file
		Attachment newAttachment = new Attachment();
		String fileName = new StringBuilder().append(deal.getBusinessRequestId()).append("-Underwriting_File.pdf").toString();
		newAttachment.setOrigAttachmentName(fileName);
		newAttachment.setAttachmentName(AttachmentUtils.generateFileName(fileName, AttachmentType.UNDERWRITING, deal, null));
		newAttachment.setAttachmentTypeId(AttachmentType.UNDERWRITING.getId());
		newAttachment.setAttachedBySSOID(UserContext.getCurrentUserContext().getId());
		RepositoryFile repAttachment = createNewRepositoryAttachment(newAttachment, deal, null);
		
		if(LOGGER.isDebugEnabled()) {
			String msg = new StringBuilder().append("Uploading the Under Writing file into GE library ")
					.append(" for the deal ").append(deal.getDealSeqId())
					.append(" with name ").append(newAttachment.getOrigAttachmentName()).toString();
			LOGGER.debug(msg);
		}
		
		// Generates UWFile and uploads to GE library
		byte[] uwFileData = null;
		ByteArrayInputStream uwFileInputStream = null;
		try {
			uwFileData = pdfGenerator.generate();
			uwFileInputStream = new ByteArrayInputStream(uwFileData);
			manager.save(uwFileInputStream, repAttachment);
		} catch (HWFServiceException hse) {
			ICFPAttachmentException exception = convertException(ICFPAttachmentException.ERROR_CODE_UWFILE_GEN, newAttachment, deal, hse);
			LOGGER.error(exception.getMessage(), hse);
			throw exception;
		} catch (HWFStubException hse) {
			ICFPAttachmentException exception = convertException(ICFPAttachmentException.ERROR_CODE_UWFILE_GEN, newAttachment, deal, hse);
			LOGGER.error(exception.getMessage(), hse);
			throw exception;
		} catch(AttachmentException ae) {
			ICFPAttachmentException exception = convertException(ICFPAttachmentException.ERROR_CODE_UPLOAD, newAttachment, deal, ae);
			LOGGER.error(exception.getMessage(), ae);
			throw exception;
		}

		newAttachment.setGeFileId(repAttachment.getId());
		newAttachment.setGeLibraryReference(repAttachment.getLocation());
		newAttachment.setGeFolderId(repAttachment.getParentFolder().getId());
		
		// Insert into database
		insertAttachmentIntoDatabase(deal, newAttachment, deal.getAttachments());
		
		if(LOGGER.isDebugEnabled()) {
			String msg = new StringBuilder().append("Successfully uploaded the Under Writing file into GE library ")
					.append(" for the deal ").append(deal.getDealSeqId())
					.append(" with name ").append(newAttachment.getOrigAttachmentName()).toString();
			LOGGER.debug(msg);
		}
	}
	
	/* --------------------------------------------------------------------------------------------------------------------------------------------------------
	 * 																PRIVATE METHODS
	 -------------------------------------------------------------------------------------------------------------------------------------------------------- */
	
	/**
	 * 
	 * Method have the implementation of creating th data transfer object for core component to upload file to GELIB
	 * @param file
	 * @param type
	 * @param allAttachments
	 * @param deal
	 * @param leg
	 * @param exception
	 * @param derivative
	 * @param amendment
	 * @throws ICFPException 
	 */
	private Attachment addAttachmentImpl(FormFile file, AttachmentType type, String comments, List<Attachment> allAttachments, DealRequest deal, Object leg, DerivativesRequest derivative, ExceptionRequestForm exceptionRequest, Amendment amendment) throws ICFPException {
		deleteOldFileIfNecessary(type, allAttachments, deal);
		if(LOGGER.isDebugEnabled()) {
			String msg = new StringBuilder().append("Uploading file ").append(file.getFileName())
					.append(" of type ").append(type).append(" for the deal ").append(deal.getDealSeqId()).toString();
			LOGGER.debug(msg);
		}
		Attachment newAttachment = createAttachment(file, type, comments, deal, leg, exceptionRequest, derivative, amendment);
		RepositoryFile repAttachment = createNewRepositoryAttachment(newAttachment, deal, leg);
		try {
			manager.save(file.getInputStream(), repAttachment);
		} catch(IOException ioe) {
			ICFPAttachmentException exception = convertException(ICFPAttachmentException.ERROR_CODE_UPLOAD, newAttachment, deal, ioe);
			LOGGER.error(exception.getMessage(), ioe);
			throw exception;
		} catch (AttachmentException ae) {
			ICFPAttachmentException exception = convertException(ICFPAttachmentException.ERROR_CODE_UPLOAD, newAttachment, deal, ae);
			LOGGER.error(exception.getMessage(), ae);
			throw exception;
		}
		newAttachment.setGeFileId(repAttachment.getId());
		newAttachment.setGeLibraryReference(repAttachment.getLocation());
		newAttachment.setGeFolderId(repAttachment.getParentFolder().getId());
		
		// Insert into database
		insertAttachmentIntoDatabase(deal, newAttachment, allAttachments);
		
		if(LOGGER.isDebugEnabled()) {
			String msg = new StringBuilder().append("Successfully uploaded file ").append(newAttachment.getOrigAttachmentName())
					.append(" of type ").append(AttachmentType.fromId(newAttachment.getAttachmentTypeId()))
					.append(" for the deal ").append(deal.getDealSeqId()).toString();
			LOGGER.debug(msg);
		}
		return newAttachment;
	}
	
	/**
	 * Inserts the new attachment into database.
	 * 
	 * @param deal
	 * @param newAttachment
	 * @throws ICFPAttachmentException 
	 */
	private void insertAttachmentIntoDatabase(DealRequest deal, Attachment newAttachment, List<Attachment> attachmentList) throws ICFPAttachmentException {
		DealRequest response = invokeService(deal, newAttachment, OPCODE_INSERT, DealRequest.class);
		if(response != null && STATUS_SUCCESS.equalsIgnoreCase(response.getMsgHeader().getStatus()) && response.getAttachments().size() == 1) {
			Integer attachmentId = response.getAttachments().get(0).getAttachmentId();
			newAttachment.setAttachmentId(attachmentId);
			newAttachment.setActionType(OPCODE_UPDATE);
			attachmentList.add(newAttachment);
			
			if(LOGGER.isInfoEnabled()) {
				StringBuilder msg = new StringBuilder();
				msg.append("Attachment \'").append(newAttachment.getOrigAttachmentName()).append("\' of the deal ")
				.append(deal.getDealSeqId()).append(" has been created successfully in database ")
				.append("with ID \'").append(newAttachment.getGeFileId()).append("\'")
				.append("in Folder ID \'").append(newAttachment.getGeFolderId()).append("\'");
				LOGGER.info(msg.toString());
			}
		} else {
			ICFPAttachmentException exception = new ICFPAttachmentException(ICFPAttachmentException.ERROR_CODE_UPLOAD);
			exception.setAttachment(newAttachment);
			exception.setDealSeqId(deal.getDealSeqId());
			throw exception;
		}
	}
	
	/**
	 *  If type is replace from the UI side it will delete existing attachment
	 * @param type
	 * @param deal
	 * @throws ICFPException 
	 */
	private void deleteOldFileIfNecessary(AttachmentType type, List<Attachment> attachmentList, DealRequest deal) throws ICFPException {
		if(!AttachmentType.getMultipleAllowedTypes().contains(type)) {
			List<Attachment> attachmentsToDelete = AttachmentUtils.searchAttachmentByType(type, attachmentList);
			for(Attachment attachment : attachmentsToDelete) {
				delete(attachment, deal);
			}
		}
	}
	
	/**
	 *  Base method for Update meta data for all attachments for current deal
	 * @param attachments
	 * @param leg
	 * @param deal
	 * @throws ICFPException 
	 */
	private void updateMetadata(Collection<Attachment> attachments, Object leg, DealRequest deal) throws ICFPException {
			for(Attachment attachment : attachments) {
				if(LOGGER.isDebugEnabled()) {
					String msg = new StringBuilder().append("Updating the metadata for the file ").append(attachment.getOrigAttachmentName())
							.append(" of type ").append(attachment).append(" for the deal ").append(deal.getDealSeqId()).toString();
					LOGGER.debug(msg);
				}
				
				com.hydus.wff.ge.attachments.Attachment repAttachment = createRepositoryAttachment(attachment);
				AttachmentUtils.addMetadata(repAttachment, attachment, leg, deal, configuration, staticDataFactory);
				try {
					manager.updateMetadata(repAttachment);
					if(LOGGER.isInfoEnabled()) {
						StringBuilder msg = new StringBuilder();
						msg.append("Metadata updated for the attachment ").append(attachment.getGeFileId()).append(" of deal ").append(deal.getDealSeqId());
						LOGGER.info(msg.toString());
					}
				} catch (AttachmentException ae) {
					ICFPAttachmentException exception = convertException(ICFPAttachmentException.ERROR_CODE_UPDATEMETA, attachment, deal, ae);
					LOGGER.error(exception.getMessage(), ae);
					throw exception;
				}
				if(LOGGER.isDebugEnabled()) {
					String msg = new StringBuilder().append("Successfully updated the metadata for the file ").append(attachment.getOrigAttachmentName())
							.append(" of type ").append(attachment).append(" for the deal ").append(deal.getDealSeqId()).toString();
					LOGGER.debug(msg);
				}
			}
	}
	
	/**
	 *  This method used to validate input data and file like incorrect extension, invalid file name,size etc
	 * @param type
	 * @param deal
	 * @param legIndex
	 * @param derivativeIndex
	 * @param exceptionIndex
	 * @param ammendmentIndex
	 * @throws ICFPAttachmentException 
	 */
	protected void validateInput(FormFile file, AttachmentType type, DealRequest deal, Integer legIndex, Integer derivativeIndex, Integer exceptionIndex, Integer amendmentIndex) throws ICFPAttachmentException {
		// Validating file name
		String fileName = file.getFileName();
		if(fileName.length() >= 100) {
			throw createException(ICFPAttachmentException.ERROR_CODE_INVALID_FILENAME, file, type, deal);
		}
		
		int extStartIndex = fileName.lastIndexOf('.');
		if(extStartIndex <= 0) {
			throw createException(ICFPAttachmentException.ERROR_CODE_INVALID_FILENAME, file, type, deal);
		}
		
		String name = fileName.substring(0, extStartIndex);
		if(SPL_CHAR_PATTERN.matcher(name).find()) {
			throw createException(ICFPAttachmentException.ERROR_CODE_INVALID_CHARSINNAME, file, type, deal);
		}
		
		String ext = fileName.substring(extStartIndex);
		validateExtension(file, type, deal, ext);
		
		/*// Validating file size, We can validate if we have any specification change of file size.
		long fileSize = file.getFileSize() / (1024 * 1024);
		if(fileSize > maxFileSize) {
			throw new ICFPAttachmentException(ICFPAttachmentException.ERROR_CODE_INVALID_FILESIZE);
		}*/
		
		if(deal == null) {
			throw new ICFPAttachmentException(ICFPAttachmentException.ERROR_CODE_INVALID_INPUT_PARAMS, "Invalid input param Deal should not be null for the attachment type " + type);
		}
		
		// Skip if attachment type is deal attachment; already deal parameter is validated.
		if(AttachmentType.isDealAttachmentType(type)) {
			return;
		}
		Set<String> errors = new HashSet<String>();
		switch(type) {
			case DERIVATIVE_TRADE_TICKET:
				if(derivativeIndex == null || derivativeIndex == 0) {
					errors.add("Derivative Index");
				}
				break;
			case EXCEPTIONS_ATTACHMENTS:
				if(exceptionIndex == null || exceptionIndex == 0) {
					errors.add("Exception Index");
				}
				break;
			case AMENDMENTS_ATTACHMENTS:
				if(amendmentIndex == null || amendmentIndex == 0) {
					errors.add("Amendment Index");
				}
				break;
			case LEGAL_AGREEMENTS:
			case CONSOLIDATED_FINANCIAL_STATEMENTS:
			case CORPORATE_GOVERNANCE_DOCUMENTS:
			case OTHER_DOCUMENTS:
			case JOURNAL_ENTRIES:
			case TRANSFER_PRICING_ATTACHMENTS:
				if(legIndex == null || legIndex == 0) {
					errors.add("Leg Index");
				}
				break;
		}
		
		if(!errors.isEmpty()) {
			StringBuilder errMsg = new StringBuilder().append("Invalid input parameters ");
			Iterator<String> errItr = errors.iterator();
			while(errItr.hasNext()) {
				errMsg.append(errItr.next());
				if(errItr.hasNext()) {
					errMsg.append(", ");
				}
			}
			errMsg.append("; should not be null or zero for the attachment type ").append(type);
			throw new ICFPAttachmentException(ICFPAttachmentException.ERROR_CODE_INVALID_INPUT_PARAMS, errMsg.toString());
		}
	}
	
	/**
	 *  This method used to validate input file is blank or empty
	 * @param attachment
	 * @throws ICFPAttachmentException
	 */
	private void validateAttachment(Attachment attachment) throws ICFPAttachmentException {
		if(attachment == null || StringUtils.isBlank(attachment.getGeFileId())) {
			throw new ICFPAttachmentException(ICFPAttachmentException.ERROR_CODE_INVALID_INPUT_PARAMS, "Invalid attachment");
		}
	}
	
	/**
	 * Returns root folder depends on type of the deal.
	 * 
	 * @param deal
	 * @return
	 */
	private AttachmentFolder getRootFolder(AttachmentType type, DealRequest deal) {
		Boolean isCPA = ICFPCommonHelper.isCPADeal(deal);
		
		// Decide based on type of attachment
		if(isCPA == null) {
			isCPA = (AttachmentType.isDealAttachmentType(type)) ? false : null;
		}
		
		String parentFolderId =  null;
		if(isCPA) {
			parentFolderId = (type == AttachmentType.LEGAL_AGREEMENTS) ? cpaLegalAgreementsFolderId : repositoryCPARootFolderId;
		} else {
			parentFolderId = repositoryRootFolderId;
		}
		AttachmentFolder folder = new AttachmentFolder();
		folder.setId(parentFolderId);
		folder.setUserId(UserContext.getCurrentUserContext().getId());
		return folder;
	}
	
	/**
	 * Create DTO object using input data for core component
	 * @param originalName
	 * @param deal
	 * @param leg
	 * @return
	 * @throws ICFPException 
	 */
	private com.hydus.wff.ge.attachments.Attachment createNewRepositoryAttachment(Attachment attachment, DealRequest deal, Object leg) throws ICFPException {
		com.hydus.wff.ge.attachments.Attachment repAttachment = new com.hydus.wff.ge.attachments.Attachment();
		repAttachment.setOriginalName(attachment.getOrigAttachmentName());
		repAttachment.setName(attachment.getAttachmentName());
		repAttachment.setTitle(attachment.getOrigAttachmentName());
		repAttachment.setUserId(attachment.getAttachedBySSOID());
		AttachmentFolder parentFolder = getRootFolder(AttachmentType.fromId(attachment.getAttachmentTypeId()), deal);
		attachment.setGeFileId(parentFolder.getId()); // Fix for missing GEFolder ID in Attachment Model object
		repAttachment.setParentFolder(parentFolder);
		AttachmentUtils.addMetadata(repAttachment, attachment, leg, deal, configuration, staticDataFactory);
		return repAttachment;
	}
	
	/**
	 * Create DTO object using input data from GELIb
	 * @param attachment
	 * @return
	 */
	private com.hydus.wff.ge.attachments.Attachment createRepositoryAttachment(Attachment attachment) {
		com.hydus.wff.ge.attachments.Attachment repAttachment = new com.hydus.wff.ge.attachments.Attachment();
		repAttachment.setId(attachment.getGeFileId());
		repAttachment.setName(attachment.getAttachmentName());
		repAttachment.setOriginalName(attachment.getOrigAttachmentName());
		AttachmentFolder parentFolder = new AttachmentFolder();
		parentFolder.setId(attachment.getGeFolderId());
		repAttachment.setParentFolder(parentFolder);
		return repAttachment;
	}
	
	/**
	 * Method used to set the UI input data like SSO, DealSeqID, legSeqID etc to attachment object
	 * @param file
	 * @param type
	 * @param deal
	 * @param leg
	 * @return
	 */
	private Attachment createAttachment(FormFile file, AttachmentType type, String comments, DealRequest deal, Object leg, ExceptionRequestForm exception, DerivativesRequest derivative, Amendment amendment) {
		Attachment newAttachment = new Attachment();
		newAttachment.setOrigAttachmentName(file.getFileName());
		newAttachment.setAttachmentName(AttachmentUtils.generateFileName(file.getFileName(), type, deal, leg));
		newAttachment.setAttachmentTypeId(type.getId());
		newAttachment.setAttachedBySSOID(UserContext.getCurrentUserContext().getId());
		newAttachment.setComments(comments);
		if(leg != null) {
			newAttachment.setLegSeqId(ICFPLegHelper.getLegSeqId(leg));
		}
		if(exception != null) {
			newAttachment.setExceptionId(exception.getLegalExceptionsId()); // TODO Need to verify
		}
		if(derivative != null) {
			newAttachment.setDerivativesId(derivative.getDeriativesSeqId());
		}
		if(amendment != null) {
			newAttachment.setAmendmentDetailsId(amendment.getAmendmentDetailsId());
		}
		return newAttachment;
	}
	
	/**
	 * Method used convert exceptions with attachment input information
	 * @param errorCode
	 * @param msg
	 * @param attachment
	 * @param deal
	 * @return
	 */
	private ICFPAttachmentException convertException(String errorCode, Attachment attachment, DealRequest deal, Throwable t) {
		ICFPAttachmentException attachmentException = new ICFPAttachmentException(errorCode, t);
		attachmentException.setAttachment(attachment);
		attachmentException.setDealSeqId(deal.getDealSeqId());
		return attachmentException;
	}
	
	/**
	 * Method used call bw service call for instant upload
	 * @param attachment
	 * @param opcode
	 * @return
	 * @throws ICFPAttachmentException 
	 */
	private <T> T invokeService(DealRequest deal, Attachment attachment, String opcode, Class<T> responseType) throws ICFPAttachmentException {
		DealRequest msgDeal = new DealRequest();
		msgDeal.setDealSeqId(deal.getDealSeqId());
		
		MsgHeader msgHeader = new MsgHeader();
		msgHeader.setOpcode(OPCODE_INSTANTATTCHOP);
		String userId = UserContext.getCurrentUserContext().getId();
		msgHeader.setAuditCreator(userId);
		msgHeader.setAuditModifier(userId);
		msgHeader.setAuditCreatorFirstName(UserContext.getCurrentUserContext().getFirstName());
		msgHeader.setAuditCreatorLastName(UserContext.getCurrentUserContext().getLastName());
		msgDeal.setMsgHeader(msgHeader);
		
		attachment.setActionType(opcode);
		msgDeal.getAttachments().add(attachment);
		
		T response = null;
		try {
			response = serviceClient.invokeService(OPCODE_DEAL, msgDeal, responseType);
		} catch (HWFServiceException hse) {
			ICFPAttachmentException exception = convertException(ICFPAttachmentException.ERROR_CODE_SERVICEERR, attachment, deal, hse);
			LOGGER.error(exception.getMessage(), hse);
			throw exception;
		} catch (HWFStubException hse) {
			ICFPAttachmentException exception = convertException(ICFPAttachmentException.ERROR_CODE_SERVICEERR, attachment, deal, hse);
			LOGGER.error(exception.getMessage(), hse);
			throw exception;
		}
		
		return response;
	}
	
	/**
	 * Method used validate file extension provided by GE
	 * @param type
	 * @param ext
	 * @return
	 * @throws ICFPAttachmentException 
	 */
	public void validateExtension(FormFile file, AttachmentType type, DealRequest deal, String ext) throws ICFPAttachmentException {
		String[] allowedExtensions = null;
		if(type == AttachmentType.EQUITY_PITCH) {
			List<String> allExtensions = staticDataFactory.getReferenceFileExtData();
			allExtensions.remove(".txt");
			allowedExtensions = allExtensions.toArray(new String[allExtensions.size()]);
		} else {
			List<String> allExtensions = staticDataFactory.getReferenceFileExtData();
			allowedExtensions = allExtensions.toArray(new String[allExtensions.size()]);
		}
		
		if(StringUtils.isNotBlank(ext)) {
			for(String eachExt : allowedExtensions) {
				if(eachExt.equalsIgnoreCase(ext)) {
					return;
				}
			}
		}
		ICFPAttachmentException exception = createException(ICFPAttachmentException.ERROR_CODE_INVALID_FILEEXTENSION, file, type, deal);
		exception.setFileExtensions(allowedExtensions);
		throw exception;
	}
	
	/**
	 * Method used create ICFPAttachmentException with the help of pre information of particular attachment
	 * @param file
	 * @param type
	 * @param deal
	 * @return
	 */
	private ICFPAttachmentException createException(String errorCode, FormFile file, AttachmentType type, DealRequest deal) {
		ICFPAttachmentException exception = new ICFPAttachmentException(errorCode);
		Attachment newAttachment = new Attachment();
		newAttachment.setOrigAttachmentName(file.getFileName());
		newAttachment.setAttachmentTypeId(type.getId());
		exception.setAttachment(newAttachment);
		exception.setDealSeqId(deal.getDealSeqId());
		return exception;
	}
	
	/* --------------------------------------------------------------------------------------------------------------------------------------------------------
	 * 															DEPENDENCY INJECTION METHODS
	 -------------------------------------------------------------------------------------------------------------------------------------------------------- */
	
	/**
	 * @return the manager
	 */
	public AttachmentManager getManager() {
		return manager;
	}

	/**
	 * @param manager the manager to set
	 */
	public void setManager(AttachmentManager manager) {
		this.manager = manager;
	}

	/**
	 * @return the repositoryRootFolderId
	 */
	public String getRepositoryRootFolderId() {
		return repositoryRootFolderId;
	}

	/**
	 * @param repositoryRootFolderId the repositoryRootFolderId to set
	 */
	public void setRepositoryRootFolderId(String repositoryRootFolderId) {
		this.repositoryRootFolderId = repositoryRootFolderId;
	}

	/**
	 * @return the repositoryCPARootFolderId
	 */
	public String getRepositoryCPARootFolderId() {
		return repositoryCPARootFolderId;
	}

	/**
	 * @param repositoryCPARootFolderId the repositoryCPARootFolderId to set
	 */
	public void setRepositoryCPARootFolderId(String repositoryCPARootFolderId) {
		this.repositoryCPARootFolderId = repositoryCPARootFolderId;
	}

	/**
	 * @return the cpaLegalAgreementsFolderId
	 */
	public String getCpaLegalAgreementsFolderId() {
		return cpaLegalAgreementsFolderId;
	}

	/**
	 * @param cpaLegalAgreementsFolderId the cpaLegalAgreementsFolderId to set
	 */
	public void setCpaLegalAgreementsFolderId(String cpaLegalAgreementsFolderId) {
		this.cpaLegalAgreementsFolderId = cpaLegalAgreementsFolderId;
	}

	/**
	 * @return the configuration
	 */
	public Properties getConfiguration() {
		return configuration;
	}

	/**
	 * @param configuration the configuration to set
	 */
	public void setConfiguration(Properties configuration) {
		this.configuration = configuration;
	}

	/**
	 * @return the serviceClient
	 */
	public ServiceClient getServiceClient() {
		return serviceClient;
	}

	/**
	 * @param serviceClient the serviceClient to set
	 */
	public void setServiceClient(ServiceClient serviceClient) {
		this.serviceClient = serviceClient;
	}

	/**
	 * @return the maxFileSize
	 */
	public long getMaxFileSize() {
		return maxFileSize;
	}

	/**
	 * @param maxFileSize the maxFileSize to set
	 */
	public void setMaxFileSize(long maxFileSize) {
		this.maxFileSize = maxFileSize;
	}

	/**
	 * @return the staticDataFactory
	 */
	public StaticDataFactory getStaticDataFactory() {
		return staticDataFactory;
	}

	/**
	 * @param staticDataFactory the staticDataFactory to set
	 */
	public void setStaticDataFactory(StaticDataFactory staticDataFactory) {
		this.staticDataFactory = staticDataFactory;
	}
}
