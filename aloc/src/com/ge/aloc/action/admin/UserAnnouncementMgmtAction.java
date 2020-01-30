/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: UserAnnouncementMgmtAction.java
 * Purpose: UserAnnouncementMgmtAction used for all user messages related functionality
 */

package com.ge.aloc.action.admin;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.ge.aloc.bo.AttachmentBO;
import com.ge.aloc.bo.UserAnnouncementBO;
import com.ge.aloc.common.util.AttachmentUtils;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.exception.ALOCAttachmentException;
import com.ge.aloc.exception.ALOCException;
import com.ge.aloc.manager.IALOCAttachmentManager;
import com.ge.aloc.manager.admin.IUserAnnouncementMgmtManager;
import com.ge.aloc.model.ActiveAnnoucement;
import com.ge.aloc.model.Attachment;
import com.ge.aloc.model.RoleSelection;
import com.ge.aloc.model.UserAnnouncement;
import com.hydus.hwf.exceptions.ErrorData;
import com.hydus.hwf.exceptions.HWFServiceException;
import com.hydus.hwf.exceptions.HWFServiceStubException;
import com.hydus.hwf.exceptions.IErrorHandler;
import com.hydus.hwf.util.StringUtils;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author rajeswari.guthi
 *
 */
public class UserAnnouncementMgmtAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4720308151566613506L;

	/**
	 * LOGGER
	 */
	private static final Logger LOGGER = Logger.getLogger(UserAnnouncementMgmtAction.class);
	
	private IUserAnnouncementMgmtManager userAnnouncementMgmtManager;
	protected IALOCAttachmentManager alocAttachmentManager;
	private UserAnnouncementBO userAnnouncementBO;
	private Integer userAnnouncementId;
	private UserAnnouncement activeUserAnnouncement;
	protected IErrorHandler errorHandler;

	private File fileUpload;
	private String fileUploadContentType;
	private String fileUploadFileName;
	
	// Result Properties
	private Integer typeId;
	private String status;
	private String errorCode;
	private String errorMsg;
	private Attachment attachment;

	/**
	 * This method is used to retrieve UserAnnouncementDetails from DB
	 * @return
	 * @throws HWFServiceException
	 */
	public String loadUserAnnouncement() throws HWFServiceException{
		UserAnnouncement userAnnouncement = new UserAnnouncement();
		userAnnouncement.setUserAnnouncementID(userAnnouncementId);
		userAnnouncement = userAnnouncementMgmtManager.loadUserAnnouncementDetailsById(userAnnouncement);
		setCurrentUserAnnouncement(userAnnouncement);
		return ALOCConstants.USERANNCOUNCEMENT;
	}

	/**
	 * This method is used to create user announcement.
	 * @return
	 */
	public String createUserAnnouncement() {
		createNewUserAnnouncement();
		return ALOCConstants.USERANNCOUNCEMENT;
	}
	
	/**
	 * This method is used to create Or Update UserAnnouncement form
	 * @return
	 * @throws HWFServiceException
	 */
	public String saveUserAnnouncement() throws HWFServiceException{	
		UserAnnouncement userAnnouncement = getUserAnnouncement();
		try{
			if(userAnnouncement.getAttachments()!= null && userAnnouncement.getAttachments().size()>ALOCConstants.ATTACHMENTS_START_INDEX){
				userAnnouncement.getAttachments().get(ALOCConstants.ATTACHMENTS_START_INDEX).setDeleteFlag(ALOCConstants.N_CAP);				
			}
			userAnnouncement = userAnnouncementMgmtManager.createOrUpdateUserAnnouncement(userAnnouncement);
		}catch(HWFServiceException hse){
			addActionError(hse.getErrorMessage());	
			return ALOCConstants.USERANNCOUNCEMENT;
		}
		HttpSession session = ServletActionContext.getRequest().getSession();
		if(userAnnouncement !=null && userAnnouncement.getMsgHeader().getStatus() !=null){
		session.setAttribute(ALOCConstants.PORTAL_SUCCESSMSG,userAnnouncement.getMsgHeader().getStatus());}
		return ALOCConstants.TREASURYADMINPORTAL;

	}
	
	
	/**
	 * This method is used to show the preview by audience
	 * @return
	 * @throws HWFServiceException
	 */
	public String previewUserAnnouncement() throws HWFServiceException{	
		UserAnnouncement userAnnouncement = getUserAnnouncement();					
		setCurrentUserAnnouncement(userAnnouncement);
		return ALOCConstants.USERANNCOUNCEMENT;
	}

	/**
	 * This Method is used to load Active Announcements.
	 * @return
	 * @throws HWFServiceException
	 */
	public String loadActiveAnnouncement() throws HWFServiceException{
		activeUserAnnouncement = userAnnouncementMgmtManager.loadActiveAnnouncement();
		ActionContext.getContext().getSession().put(ALOCConstants.ACTIVEANNOUNCEMENTS, activeUserAnnouncement);		
		return ALOCConstants.ACTIVEANNOUNCEMENTS;
	}

	/**
	 * This Method is used to delete Announcement.
	 * @return
	 * @throws HWFServiceException
	 */
	public String deleteAnnouncement() throws HWFServiceException{
		UserAnnouncement userAnnouncement = new UserAnnouncement();
		userAnnouncement.setUserAnnouncementID(userAnnouncementId);
		activeUserAnnouncement = userAnnouncementMgmtManager.deleteAnnouncement(userAnnouncement);
		return ALOCConstants.ACTIVEANNOUNCEMENTS;
	}
	
	/**
	 * This Method is used to delete User Announcement attachment.
	 * @return
	 * @throws HWFServiceException
	 */
	public String deleteUserAnnouncementAtmt() throws HWFServiceException,ALOCException{		
		List<AttachmentBO> attachmentBOList = getUserAnnouncementBO().getAttachmentBOList();
		if(attachmentBOList !=null && !attachmentBOList.isEmpty()){
			AttachmentBO attachmentBO = userAnnouncementBO.getAttachmentBOList().get(ALOCConstants.ATTACHMENTS_START_INDEX);
			attachment = attachmentBO.getModel();	
			UserAnnouncement userAnnouncement = userAnnouncementBO.getModel();	
			try {
				
				alocAttachmentManager.deleteUserAnnouncementAtmt(attachment,userAnnouncement,true);
				attachmentBOList.remove(attachmentBO);			
				if(userAnnouncement.getUserAnnouncementID()!= null){
					attachment.setDeleteFlag(ALOCConstants.Y_CAP);
					// delete from db				
					userAnnouncement.getAttachments().add(attachment);					
					userAnnouncement = userAnnouncementMgmtManager.createOrUpdateUserAnnouncement(userAnnouncement);
					userAnnouncementId =userAnnouncement.getUserAnnouncementID();
					userAnnouncement = new UserAnnouncement();
					userAnnouncement.setUserAnnouncementID(userAnnouncementId);
					userAnnouncement = userAnnouncementMgmtManager.loadUserAnnouncementDetailsById(userAnnouncement);
					setCurrentUserAnnouncement(userAnnouncement);
				} 
			} catch (ALOCException e) {
				
				if(userAnnouncement.getUserAnnouncementID()!= null){
					attachmentBOList.remove(attachmentBO);			
					attachment.setDeleteFlag(ALOCConstants.Y_CAP);
					// delete from db				
					userAnnouncement.getAttachments().add(attachment);						
					userAnnouncement = userAnnouncementMgmtManager.createOrUpdateUserAnnouncement(userAnnouncement);
					userAnnouncementId =userAnnouncement.getUserAnnouncementID();
					userAnnouncement = new UserAnnouncement();
					userAnnouncement.setUserAnnouncementID(userAnnouncementId); 
					userAnnouncement = userAnnouncementMgmtManager.loadUserAnnouncementDetailsById(userAnnouncement);
					setCurrentUserAnnouncement(userAnnouncement); 
				}else{
					this.status = ALOCConstants.ERROR;
					ErrorData errorData = errorHandler.handle(e);
					this.errorCode = errorData.getCode();
					this.errorMsg = errorData.getMessage(); 
					return Action.ERROR;
				}
			}
		}					
		return ALOCConstants.SUCCESS;
	}
	

	/**
	 * This method is used to open user announcement management attachment.
	 * @return
	 * @throws HWFServiceException
	 */
	public String saveUserAnnouncementAttchments() throws HWFServiceException, ALOCAttachmentException, ALOCException{	
		UserAnnouncement userAnnouncement = null;
		try{
			
			userAnnouncement = userAnnouncementMgmtManager.saveUserAnnouncementAtmts(fileUpload,fileUploadFileName);
			setCurrentUserAnnouncement(userAnnouncement);
			attachment = userAnnouncement.getAttachments().get(ALOCConstants.ATTACHMENTS_START_INDEX);
		}catch(ALOCException ae){
			this.status = ALOCConstants.ERROR;
			ErrorData errorData = errorHandler.handle(ae);
			this.errorCode = errorData.getCode();
			this.errorMsg = errorData.getMessage();
			return Action.ERROR;
		}
		catch(HWFServiceException hse){	
			try{
				attachment = userAnnouncementBO!= null ? userAnnouncementBO.getAttachmentBOList().get(ALOCConstants.ATTACHMENTS_START_INDEX).getModel() : null;
				alocAttachmentManager.deleteUserAnnouncementAtmt(attachment,userAnnouncement,true);
			}catch(ALOCAttachmentException e){
				LOGGER.error(ALOCConstants.ERROR_WHILE_DELETING_FILE + attachment!= null?attachment.getAttachmentName():ALOCConstants.EMPTY_STRING, e);
			}			
			this.status = ALOCConstants.ERROR;
			ErrorData errorData = errorHandler.handle(hse);
			this.errorCode = errorData.getCode();
			this.errorMsg = errorData.getMessage();
			return Action.ERROR;
		}
		this.status = ALOCConstants.USERANNCOUNCEMENT;
		return Action.SUCCESS;		
	}


	/** 
	 * This method is used to download the user announcement attachments.
	 * @return
	 * @throws IOException 
	 * @throws HWFServiceException
	 */
	public String downloadAttachment() throws IOException, HWFServiceException,HWFServiceStubException,ALOCException {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		String geLibFileId = request.getParameter(ALOCConstants.PARAM_GELIBFILEID);		
		String announcementType = request.getParameter(ALOCConstants.ANNOUNCEMENTTYPE);
		String activeAnnouncementIndex = request.getParameter(ALOCConstants.ACTIVEANNOUNCEMENTINDEX);
		String announcementId = request.getParameter(ALOCConstants.USERANNOUNCEMENTID);
		OutputStream outputStream = null;
		Attachment attachmentToDownload = null;
		try {
			if (StringUtils.isNotBlank(geLibFileId)) {				
				if(announcementType.equalsIgnoreCase(ALOCConstants.ACTIVEANNOUNCEMENTS))
				{
					activeUserAnnouncement = (UserAnnouncement)ActionContext.getContext().getSession().get(ALOCConstants.ACTIVEANNOUNCEMENTS);
					ActiveAnnoucement activeAnnoujcement = (ActiveAnnoucement)activeUserAnnouncement.getActiveAnnouncement().getActiveAnnoucements().get(Integer.valueOf(activeAnnouncementIndex));
					attachmentToDownload = AttachmentUtils.searchAttachmentByGELibId(geLibFileId,activeAnnoujcement.getAttachments()); 

				}else if(announcementType.equalsIgnoreCase(ALOCConstants.USERANNCOUNCEMENT)){
					//code for showing attachments for user announcement coming from landing page starts here.
					if(userAnnouncementId!= null){
						userAnnouncementId = Integer.valueOf(announcementId);
						loadUserAnnouncement();
					} //code for showing attachments for user announcement coming from landing page ends here.
					userAnnouncementBO = (UserAnnouncementBO)ActionContext.getContext().getSession().get(ALOCConstants.USERANNCOUNCEMENT);
					attachmentToDownload = AttachmentUtils.searchAttachmentByGELibId(geLibFileId,userAnnouncementBO.getModel().getAttachments()); 
				}																				
				response.setContentType(ServletActionContext.getServletContext().getMimeType(attachmentToDownload.getAttachmentName()));
				response.addHeader(ALOCConstants.HEADER_CONTENT_DISPOSITION,ALOCConstants.CONTENT_DISPOSITION_VALUE+ attachmentToDownload.getAttachmentName());				
				outputStream = response.getOutputStream();				
				alocAttachmentManager.downloadUserAnnouncementAttachment(outputStream,attachmentToDownload);
			}
		} finally {
			outputStream.flush();
			outputStream.close();
		}
		return null;
	}



	/**
	 * This method is used to set CurrentUserAnnouncement
	 * @param userAnnouncement
	 */
	private void setCurrentUserAnnouncement(UserAnnouncement userAnnouncement) {
		userAnnouncementBO = new UserAnnouncementBO(userAnnouncement);					
		ActionContext.getContext().getSession().put(ALOCConstants.USERANNCOUNCEMENT, userAnnouncementBO);
	}


	/**
	 * This is used to get userAnnouncementMgmtManager object
	 * @return the userAnnouncement
	 */
	public IUserAnnouncementMgmtManager getUserAnnouncementMgmtManager() {
		return userAnnouncementMgmtManager;
	}

	/**
	 *  This is used to create userAnnouncementMgmtManager instance object
	 * @param userAgreementMgmtManager the userAnnouncement to set
	 */
	public void setUserAnnouncementMgmtManager(
			IUserAnnouncementMgmtManager userAnnouncementMgmtManager) {
		this.userAnnouncementMgmtManager = userAnnouncementMgmtManager;
	}

	/**
	 * This method is used to get User announcement BO object.
	 * @return
	 */
	public UserAnnouncementBO getUserAnnouncementBO() {
		if(userAnnouncementBO == null) {
			userAnnouncementBO = (UserAnnouncementBO)ActionContext.getContext().getSession().get(ALOCConstants.USERANNCOUNCEMENT);	
		}		
		return userAnnouncementBO;
	}

	/**
	 * This is used to get UserAnnouncement object
	 * @return the userAnnouncement
	 */
	public UserAnnouncement getUserAnnouncement() {
		return getUserAnnouncementBO().getModel();
	}

	/**
	 * This method is used to create new user announcement.
	 * @return
	 */
	private void createNewUserAnnouncement() {
		this.userAnnouncementBO = new UserAnnouncementBO(new UserAnnouncement());
		ActionContext.getContext().getSession().put(ALOCConstants.USERANNCOUNCEMENT, userAnnouncementBO);
	}

	/**
	 * This method is used to load roles from DB
	 * @return
	 * @throws HWFServiceException
	 */
	@SuppressWarnings("unchecked")
	public List<RoleSelection> getAllRoles() throws HWFServiceException{			
		List<RoleSelection> roleSelectionList = (List<RoleSelection>) ActionContext.getContext().getSession().get(ALOCConstants.USERANNOUCEMENTROLES);			
		if(roleSelectionList == null || roleSelectionList.isEmpty()) {
			UserAnnouncement userAnnouncement = userAnnouncementMgmtManager.loadRolesList();			
			roleSelectionList = userAnnouncement.getRoleSelections();			
			ActionContext.getContext().getSession().put(ALOCConstants.USERANNOUCEMENTROLES, roleSelectionList);
		}
		return roleSelectionList;
	}

	/**
	 * This method is used to get selected roles
	 * @return
	 * @throws HWFServiceException 
	 */
	public List<Integer> getSelectedRoles() throws HWFServiceException {					
		List<Integer> selectedRoleIdList = getUserAnnouncement().getSelectedRoles();					
		return selectedRoleIdList;
	}


	/**
	 * This method is used to get userAnnouncementId property
	 * @return the userAnnouncementId
	 */
	public Integer getUserAnnouncementId() {
		return userAnnouncementId;
	}


	/**
	 * This method is used to set userAnnouncementId property
	 * @param userAnnouncementId the userAnnouncementId to set
	 */
	public void setUserAnnouncementId(Integer userAnnouncementId) {
		this.userAnnouncementId = userAnnouncementId;
	}

	/**
	 * This method is used to get activeUserAnnouncement property
	 * @return the activeUserAnnouncement
	 */
	public UserAnnouncement getActiveUserAnnouncement() {
		return activeUserAnnouncement;
	}

	/**
	 * This method is used to set activeUserAnnouncement property
	 * @param activeUserAnnouncement the activeUserAnnouncement to set
	 */
	public void setActiveUserAnnouncement(UserAnnouncement activeUserAnnouncement) {
		this.activeUserAnnouncement = activeUserAnnouncement;
	}

	/**
	 * This method is used to get alocAttachmentManager
	 * @return the alocAttachmentManager
	 */
	public IALOCAttachmentManager getAlocAttachmentManager() {
		return alocAttachmentManager;
	}

	/**
	 * This method is used to set alocAttachmentManager
	 * @param alocAttachmentManager the alocAttachmentManager to set
	 */
	public void setAlocAttachmentManager(
			IALOCAttachmentManager alocAttachmentManager) {
		this.alocAttachmentManager = alocAttachmentManager;
	}

	/**
	 * @return the errorHandler
	 */
	public IErrorHandler getErrorHandler() {
		return errorHandler;
	}

	/**
	 * @param errorHandler the errorHandler to set
	 */
	public void setErrorHandler(IErrorHandler errorHandler) {
		this.errorHandler = errorHandler;
	}

	/**
	 * @return the fileUpload
	 */
	public File getFileUpload() {
		return fileUpload;
	}

	/**
	 * @param fileUpload the fileUpload to set
	 */
	public void setFileUpload(File fileUpload) {
		this.fileUpload = fileUpload;
	}

	/**
	 * @return the fileUploadContentType
	 */
	public String getFileUploadContentType() {
		return fileUploadContentType;
	}

	/**
	 * @param fileUploadContentType the fileUploadContentType to set
	 */
	public void setFileUploadContentType(String fileUploadContentType) {
		this.fileUploadContentType = fileUploadContentType;
	}

	/**
	 * @return the fileUploadFileName
	 */
	public String getFileUploadFileName() {
		return fileUploadFileName;
	}

	/**
	 * @param fileUploadFileName the fileUploadFileName to set
	 */
	public void setFileUploadFileName(String fileUploadFileName) {
		this.fileUploadFileName = fileUploadFileName;
	}
	
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @return the typeId
	 */
	public Integer getTypeId() {
		return typeId;
	}

	/**
	 * @param typeId the typeId to set
	 */
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @return the errorMsg
	 */
	public String getErrorMsg() {
		return errorMsg;
	}

	/**
	 * @return the attachment
	 */
	public Attachment getAttachment() {
		return attachment;
	}

	/**
	 * @param userAnnouncementBO the userAnnouncementBO to set
	 */
	public void setUserAnnouncementBO(UserAnnouncementBO userAnnouncementBO) {
		this.userAnnouncementBO = userAnnouncementBO;
	}
}
