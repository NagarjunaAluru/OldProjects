/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: IUserAgreementMgmtManager.java
 * Purpose: IUserAgreementMgmtManager used for User Announcement Management operations.
 */
package com.ge.aloc.manager.admin;

import java.io.File;

import com.ge.aloc.exception.ALOCAttachmentException;
import com.ge.aloc.exception.ALOCException;
import com.ge.aloc.model.UserAnnouncement;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author sunil.yakkaluru
 *
 */
public interface IUserAnnouncementMgmtManager {

	/**
	 * This method is used for create Or Update UserAnnouncement for selected request.
	 * @param UserAnnouncement
	 * @return
	 * @throws HWFServiceException
	 */
	public UserAnnouncement createOrUpdateUserAnnouncement(UserAnnouncement userAnnouncement) throws HWFServiceException;

	/**
	 * This method is used for load RolesList.
	 * @return
	 * @throws HWFServiceException
	 */
	public UserAnnouncement loadRolesList() throws HWFServiceException;

	/**
	 * This method is used for load UserAnnouncementDetails
	 * @return
	 * @throws HWFServiceException
	 */
	public UserAnnouncement loadUserAnnouncementDetailsById(UserAnnouncement userAnnouncement) throws HWFServiceException;

	/**
	 * This method is used for loading active announcements
	 * @param userAnnouncement
	 * @return
	 * @throws HWFServiceException
	 */
	public UserAnnouncement loadActiveAnnouncement() throws HWFServiceException;

	/**
	 * This method is used to delete announcement
	 * @param userAnnouncement
	 * @return
	 * @throws HWFServiceException
	 */
	public UserAnnouncement deleteAnnouncement(UserAnnouncement userAnnouncement) throws HWFServiceException;


	/**
	 * This method is used to save announcement attachments
	 * @param attachmentBOList
	 * @param userAnnouncement
	 * @return
	 * @throws HWFServiceException
	 * @throws ALOCAttachmentException
	 * @throws ALOCException
	 */
	public UserAnnouncement saveUserAnnouncementAtmts(File fileUpload,String fileUploadFileName) throws HWFServiceException, ALOCAttachmentException, ALOCException;

}
