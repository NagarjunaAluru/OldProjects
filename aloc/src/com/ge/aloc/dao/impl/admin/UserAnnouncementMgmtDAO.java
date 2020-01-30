/*
 *Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: UserAnnouncementMgmtDAO.java
 * Purpose: UserAnnouncementMgmtDAO used for User Announcement Management operations. 
 */
package com.ge.aloc.dao.impl.admin;


import com.ge.aloc.OpCode;
import com.ge.aloc.ServiceClientSupport;
import com.ge.aloc.dao.admin.IUserAnnouncementMgmtDAO;
import com.ge.aloc.model.MsgHeader;
import com.ge.aloc.model.UserAnnouncement;
import com.ge.aloc.util.ALOCCommonHelper;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author sunil.yakkaluru
 *
 */
public class UserAnnouncementMgmtDAO extends ServiceClientSupport  implements IUserAnnouncementMgmtDAO{

	/**
	 * This method is used for create Or Update UserAnnouncement for selected request.
	 * @param UserAnnouncement
	 * @see com.ge.aloc.dao.admin.IUserAnnouncementMgmtDAO#createOrUpdateUserAnnouncement(com.ge.aloc.model.UserAnnouncement)
	 */
	public UserAnnouncement createOrUpdateUserAnnouncement(UserAnnouncement userAnnouncement)
			throws HWFServiceException{
		if(userAnnouncement.getUserAnnouncementID()==null){
			MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.INSERT.getOperationCode());
			userAnnouncement.setMsgHeader(msgHeader);
		}else{
			MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.UPDATE.getOperationCode());
			userAnnouncement.setMsgHeader(msgHeader);
		}
		userAnnouncement = serviceClient.invokeService(OpCode.USERANNOUNCEMENT.getOperationCode(),userAnnouncement,UserAnnouncement.class);
		return userAnnouncement;
	}

	/**
	 * This method is used to load roles list from DB.
	 * @see com.ge.aloc.dao.admin.IUserAnnouncementMgmtDAO#loadRolesList()
	 */
	public UserAnnouncement loadRolesList()	throws HWFServiceException{
		UserAnnouncement userAnnouncement = new UserAnnouncement();
		MsgHeader msgHeader = new MsgHeader();
		msgHeader.setOpcode(OpCode.GETROLES.getOperationCode());		
		userAnnouncement.setMsgHeader(msgHeader);
		userAnnouncement = serviceClient.invokeService(OpCode.USERANNOUNCEMENT.getOperationCode(),userAnnouncement,UserAnnouncement.class);
		return userAnnouncement;
	}

	/**
	 * This method is used to load UserAnnouncementDetails.
	 * @see com.ge.aloc.dao.admin.IUserAnnouncementMgmtDAO#loadUserAnnouncementDetailsById()
	 */
	public UserAnnouncement loadUserAnnouncementDetailsById(UserAnnouncement userAnnouncement) throws HWFServiceException{
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.GETUSERANNOUNCEMENTDETAILS.getOperationCode());
		userAnnouncement.setMsgHeader(msgHeader);
		userAnnouncement = serviceClient.invokeService(OpCode.USERANNOUNCEMENT.getOperationCode(),userAnnouncement,UserAnnouncement.class);
		return userAnnouncement;
	}

	/**
	 * This method is used to load active announcements.
	 * @see com.ge.aloc.dao.admin.IUserAnnouncementMgmtDAO#loadActiveAnnouncement()
	 */
	public UserAnnouncement loadActiveAnnouncement() throws HWFServiceException{
		UserAnnouncement userAnnouncement = new UserAnnouncement();
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.GETACTIVEANNOUNCEMENTS.getOperationCode());
		userAnnouncement.setMsgHeader(msgHeader);
		userAnnouncement = serviceClient.invokeService(OpCode.USERANNOUNCEMENT.getOperationCode(),userAnnouncement,UserAnnouncement.class);
		return userAnnouncement;
	}

	/**
	 * This method is used to delete announcement.
	 * @see com.ge.aloc.dao.admin.IUserAnnouncementMgmtDAO#deleteAnnouncement()
	 */
	public UserAnnouncement deleteAnnouncement(UserAnnouncement userAnnouncement) throws HWFServiceException{
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.DELETEUSERANNOUNCEMENT.getOperationCode());
		userAnnouncement.setMsgHeader(msgHeader);
		userAnnouncement = serviceClient.invokeService(OpCode.USERANNOUNCEMENT.getOperationCode(),userAnnouncement,UserAnnouncement.class);
		return userAnnouncement;
	}


}
