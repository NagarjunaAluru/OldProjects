/*
 *Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: UserAnnouncementMgmtManager.java
 * Purpose: UserAnnouncementMgmtManager used for User Announcement Management operations. 
 */
package com.ge.aloc.manager.impl.admin;

import java.io.File;

import com.ge.aloc.OpCode;
import com.ge.aloc.bo.AttachmentBO;
import com.ge.aloc.bo.UserAnnouncementBO;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.dao.admin.IUserAnnouncementMgmtDAO;
import com.ge.aloc.exception.ALOCAttachmentException;
import com.ge.aloc.exception.ALOCException;
import com.ge.aloc.manager.IALOCAttachmentManager;
import com.ge.aloc.manager.admin.IUserAnnouncementMgmtManager;
import com.ge.aloc.model.Attachment;
import com.ge.aloc.model.UserAnnouncement;
import com.hydus.hwf.exceptions.HWFServiceException;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author rajeswari.guthi
 *
 */
public class UserAnnouncementMgmtManager implements IUserAnnouncementMgmtManager {

	private IUserAnnouncementMgmtDAO userAnnouncementMgmtDAO;
	private IALOCAttachmentManager alocAttachmentManager;

	/**
	 * This method is used to create Or Update UserAnnouncement.
	 * @param UserAnnouncement
	 * @see com.ge.aloc.manager.admin.IUserAnnouncementMgmtManager#createOrUpdateUserAnnouncement(com.ge.aloc.model.UserAnnouncement)
	 */
	public UserAnnouncement createOrUpdateUserAnnouncement(UserAnnouncement userAnnouncement)
			throws HWFServiceException{			
		return userAnnouncementMgmtDAO.createOrUpdateUserAnnouncement(userAnnouncement);

	}

	/**
	 * This method is used to load UserAnnouncementDetails.
	 * @see com.ge.aloc.manager.admin.IUserAnnouncementMgmtManager#loadUserAnnouncementDetailsById()
	 */
	public UserAnnouncement loadUserAnnouncementDetailsById(UserAnnouncement userAnnouncement)
			throws HWFServiceException{

		return userAnnouncementMgmtDAO.loadUserAnnouncementDetailsById(userAnnouncement);

	}

	/**
	 * This method is used load roleslist from DB.
	 * @see com.ge.aloc.manager.admin.IUserAnnouncementMgmtManager#loadRolesList(com.ge.aloc.model.UserAnnouncement)
	 */
	public UserAnnouncement loadRolesList()
			throws HWFServiceException{		
		return userAnnouncementMgmtDAO.loadRolesList();

	}

	/**
	 * This method is used TO load active announcements.
	 * @see com.ge.aloc.manager.admin.IUserAnnouncementMgmtManager#loadActiveAnnouncement(com.ge.aloc.model.UserAnnouncement)
	 */
	public UserAnnouncement loadActiveAnnouncement()
			throws HWFServiceException{

		return userAnnouncementMgmtDAO.loadActiveAnnouncement();

	}

	/**
	 * This method is used TO load active announcements.
	 * @see com.ge.aloc.manager.admin.IUserAnnouncementMgmtManager#deleteAnnouncement(com.ge.aloc.model.UserAnnouncement)
	 */
	public UserAnnouncement deleteAnnouncement(UserAnnouncement userAnnouncement)
			throws HWFServiceException{

		return userAnnouncementMgmtDAO.deleteAnnouncement(userAnnouncement);

	}


	/**
	 * This is used to get UserAnnouncementMgmtDAO object
	 * @return the userAnnouncementMgmtDAO
	 */
	public IUserAnnouncementMgmtDAO getUserAnnouncementMgmtDAO() {
		return userAnnouncementMgmtDAO;
	}

	/**
	 * @return the alocAttachmentManager
	 */
	public IALOCAttachmentManager getAlocAttachmentManager() {
		return alocAttachmentManager;
	}

	/**
	 * @param alocAttachmentManager the alocAttachmentManager to set
	 */
	public void setAlocAttachmentManager(
			IALOCAttachmentManager alocAttachmentManager) {
		this.alocAttachmentManager = alocAttachmentManager;
	}

	/**
	 *  This is used to set UserAnnouncementMgmtDAO object
	 * @param userAnnouncementMgmtDAO the userAnnouncementMgmtDAO to set
	 */
	public void setUserAnnouncementMgmtDAO(
			IUserAnnouncementMgmtDAO userAnnouncementMgmtDAO) {
		this.userAnnouncementMgmtDAO = userAnnouncementMgmtDAO;
	}


	/**
	 * This method is used to save announcement attachments
	 * @param attachmentBOList
	 * @param userAnnouncement
	 * @return
	 * @throws HWFServiceException
	 * @throws ALOCAttachmentException
	 * @throws ALOCException
	 */
	public UserAnnouncement saveUserAnnouncementAtmts(File file,String fileName) throws HWFServiceException, ALOCAttachmentException, ALOCException {
		UserAnnouncementBO userAnnouncementBO = (UserAnnouncementBO)ActionContext.getContext().getSession().get(ALOCConstants.USERANNCOUNCEMENT);
		if(userAnnouncementBO.getAttachmentBOList().size()==ALOCConstants.ATTACHMENTS_START_INDEX){
			userAnnouncementBO.getAttachmentBOList().add(new AttachmentBO());
		}
		saveUserAnnucementAttachments(userAnnouncementBO.getAttachmentBOList().get(ALOCConstants.ATTACHMENTS_START_INDEX),userAnnouncementBO.getModel(),file,fileName);
		if(userAnnouncementBO.getModel().getUserAnnouncementID()!=null){
			return	userAnnouncementMgmtDAO.createOrUpdateUserAnnouncement(userAnnouncementBO.getModel());}
		else {
			return userAnnouncementBO.getModel();}
	}


	/**
	 * This method is used to save user announcement attachments
	 * @param attachmentBOList
	 * @throws ALOCException 
	 * @throws ALOCAttachmentException 
	 */
	private void saveUserAnnucementAttachments(AttachmentBO attachmentBO,UserAnnouncement userAnnouncement,File file,String fileName) throws ALOCAttachmentException, ALOCException {	
		attachmentBO.getModel().setActionType(OpCode.INSERT.getOperationCode()); // Assume attachment is modified
		boolean deleteAtmt = false;
		Attachment deleteAttachment = null;
		if(attachmentBO.getModel() != null&&attachmentBO.getModel().getGeFileId()!=null&&attachmentBO.getModel().getGeFolderId() != null){
			if(file!=null && file.length() > ALOCConstants.ATTACHMENTS_BASE_COUNT) {				
				alocAttachmentManager.validateAnnounceMentAtmtInput(file, fileName,userAnnouncement);
				attachmentBO.getModel().setActionType(OpCode.UPDATE.getOperationCode());
				deleteAttachment = new Attachment();
				deleteAttachment.setGeFileId(attachmentBO.getModel().getGeFileId());
				deleteAttachment.setGeFolderId(attachmentBO.getModel().getGeFolderId());
				deleteAttachment.setAttachmentTypeId(attachmentBO.getModel().getAttachmentTypeId());
				deleteAttachment.setAttachmentName(attachmentBO.getModel().getAttachmentName());
				deleteAttachment.setAttachmentOriginalName(attachmentBO.getModel().getAttachmentOriginalName());
				deleteAttachment.setGeLibraryReference(attachmentBO.getModel().getGeLibraryReference());
				deleteAtmt = true;
			}
		}
		//upload modified files				
		if(file!=null && file.length() > ALOCConstants.ATTACHMENTS_BASE_COUNT) {				
			alocAttachmentManager.addUserAnnouncementAttachment(file, fileName,userAnnouncement, attachmentBO.getModel());
		}
		// Delete attachment if the attachment already exists
		if(deleteAtmt) {
			alocAttachmentManager.deleteUserAnnouncementAtmt(deleteAttachment,userAnnouncement,!deleteAtmt);
		}
	}

}