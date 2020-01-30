/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: IUserAnnouncementMgmtDAO.java
 * Purpose: IUserAnnouncementMgmtDAO used for User Announcement Management operations. 
 */
package com.ge.aloc.dao.admin;

import com.ge.aloc.model.UserAnnouncement;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author sunil.yakkaluru
 *
 */
public interface IUserAnnouncementMgmtDAO {

	/**
	 * This method is used to get create or update user announcement.
	 * @param UserAnnouncement
	 * @return
	 * @throws HWFServiceException
	 */
	public UserAnnouncement createOrUpdateUserAnnouncement(UserAnnouncement userAnnouncement) throws HWFServiceException;

	/**
	 * This method is used to load roles list
	 * @param UserAnnouncement
	 * @return
	 * @throws HWFServiceException
	 */
	public UserAnnouncement loadRolesList() throws HWFServiceException;


	/**
	 * This method is used to load user announcement details by Id.
	 * @param UserAnnouncement
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

}
