/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: UserAnnouncementBO.java
 * Purpose: UserAnnouncementBO used for the all user announcement operations
 */
package com.ge.aloc.bo;

import java.util.List;

import com.ge.aloc.model.UserAnnouncement;
import com.ge.aloc.util.AttachmentBOList;

/**
 * @author rajeswari.guthi
 *
 */
public class UserAnnouncementBO extends AbstractModel<UserAnnouncement> {

	private List<AttachmentBO> attachmentBOList;

	/**
	 * This is a constructor for User Announcement bo
	 * @param UserAnnouncement
	 */
	public UserAnnouncementBO(UserAnnouncement userAnnouncement) {
		super(userAnnouncement);
		if(getModel().getAttachments()!=null)
			getAttachmentBOList();
	}


	/**
	 * This method is used to get the Attachment bo list
	 * @return
	 */
	public final List<AttachmentBO> getAttachmentBOList() { 
		if(attachmentBOList == null || ((AttachmentBOList) attachmentBOList).getAttachmentList() != getModel().getAttachments()) {
			attachmentBOList = new AttachmentBOList(getModel().getAttachments());
		}
		return attachmentBOList;
	}

}
