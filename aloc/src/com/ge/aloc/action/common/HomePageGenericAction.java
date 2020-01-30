/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: HomePageGenericAction.java
 * Purpose: HomePageGenericAction used for invoking common method like contact us , help, etc.
 */
package com.ge.aloc.action.common;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.ResourceBundle;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.ge.aloc.AlocHelpFileType;
import com.ge.aloc.InstrumentType;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.exception.ALOCException;
import com.ge.aloc.manager.IALOCAttachmentManager;
import com.ge.aloc.manager.common.IHomePageManager;
import com.ge.aloc.model.Attachment;
import com.ge.aloc.model.ContactUsDtls;
import com.ge.aloc.reports.ALOCReportException;
import com.hydus.hwf.exceptions.HWFServiceException;
import com.hydus.hwf.exceptions.HWFServiceStubException;
import com.hydus.hwf.util.StringUtils;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.ValidationWorkflowAware;

/**
 * @author arijit.biswas
 *
 */
public class HomePageGenericAction extends ActionSupport implements ValidationWorkflowAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IHomePageManager homePageManager;
	private ContactUsDtls contactDetails;
	protected IALOCAttachmentManager alocAttachmentManager;
	protected List<String> downloadDocs;
	protected boolean errorShow;


	private static final Logger LOGGER = Logger.getLogger(HomePageGenericAction.class);
	/*
	 * This method is used to download request check list pdf attachment.
	 * @return
	 * @throws IOException 
	 * @throws HWFServiceException
	 */
	public String downloadRequestCheckListPDF() throws IOException, HWFServiceException,HWFServiceStubException,ALOCException {		
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		String instrumentTypeId = (String)request.getParameter(ALOCConstants.INSTRUMENTTYPEID);		
		ResourceBundle glossaryBundle = ResourceBundle.getBundle(ALOCConstants.APP_CONFIG_FILE);		
		OutputStream outputStream = null;
		String geLibFileId = null;
		String fileName = ALOCConstants.EMPTY_STRING;
		Attachment atmt =null;
		InstrumentType instrumentType = InstrumentType.fromId(Integer.valueOf(instrumentTypeId).intValue()); 
		switch(instrumentType) {
		case BANK_GUARANTEE:
			fileName = glossaryBundle.getString(ALOCConstants.BG_ATTACHMENT_NAME);
			geLibFileId =  glossaryBundle.getString(ALOCConstants.BG_FILE_ID);
			atmt = getAttachmentDetails(fileName.trim(),geLibFileId.trim());
			break;
		case LOC:
			fileName = glossaryBundle.getString(ALOCConstants.SBLC_ATTACHMENT_NAME);
			geLibFileId =  glossaryBundle.getString(ALOCConstants.SBLC_FILE_ID);
			atmt = getAttachmentDetails(fileName.trim(),geLibFileId.trim());
			break;
		case SURETY_BOND:
			fileName = glossaryBundle.getString(ALOCConstants.SB_ATTACHMENT_NAME);
			geLibFileId = glossaryBundle.getString(ALOCConstants.SB_FILE_ID);
			atmt = getAttachmentDetails(fileName.trim(),geLibFileId.trim());
			break;
		case DOCUMENT_LOC:
			fileName = glossaryBundle.getString(ALOCConstants.DLOC_ATTACHMENT_NAME);
			geLibFileId =  glossaryBundle.getString(ALOCConstants.DLOC_FILE_ID);
			atmt = getAttachmentDetails(fileName.trim(),geLibFileId.trim());
			break;			
		}
		try {						
			response.setContentType(ServletActionContext.getServletContext().getMimeType(atmt.getAttachmentName()));
			response.addHeader(ALOCConstants.HEADER_CONTENT_DISPOSITION,ALOCConstants.CONTENT_DISPOSITION_VALUE+ atmt.getAttachmentName());
			outputStream = response.getOutputStream();				
			alocAttachmentManager.downloadStaticAttachment(outputStream,atmt);
		} finally {
			outputStream.flush();
			outputStream.close();
		}
		return null;
	}
	
	/**
	 * This method is used to download Resources PDF attachments.
	 * @return
	 * @throws IOException 
	 * @throws HWFServiceException
	 */
	public String downloadGlossaryUserManualPDF() throws IOException, HWFServiceException,HWFServiceStubException,ALOCException {		
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		String resourceType = request.getParameter(ALOCConstants.RESOURCE_TYPE);		
		ResourceBundle glossaryBundle = ResourceBundle.getBundle(ALOCConstants.APP_CONFIG_FILE);		
		OutputStream outputStream = null;
		String geLibFileId = null;
		String fileName = ALOCConstants.EMPTY_STRING;
		Attachment atmt =null;
		if(StringUtils.isNotBlank(resourceType) && resourceType.equals(ALOCConstants.GLOSSARY)){
			fileName = glossaryBundle.getString(ALOCConstants.GLOSSARY_HELP_FILE_NAME);
			geLibFileId =  glossaryBundle.getString(ALOCConstants.GLOSSARY_HELP_FILE_ID);
			atmt = getAttachmentDetails(fileName.trim(),geLibFileId.trim());
		}else if(StringUtils.isNotBlank(resourceType) && resourceType.equals(ALOCConstants.USER_MANUAL)){
			fileName = glossaryBundle.getString(ALOCConstants.USERMANUAL_HELP_FILE_NAME);
			geLibFileId =  glossaryBundle.getString(ALOCConstants.USERMANUAL_HELP_FILE_ID);
			atmt = getAttachmentDetails(fileName.trim(),geLibFileId.trim());
		}
		
		try {						
			response.setContentType(ServletActionContext.getServletContext().getMimeType(atmt.getAttachmentName()));
			response.addHeader(ALOCConstants.HEADER_CONTENT_DISPOSITION,ALOCConstants.CONTENT_DISPOSITION_VALUE+ atmt.getAttachmentName());
			outputStream = response.getOutputStream();				
			alocAttachmentManager.downloadStaticAttachment(outputStream,atmt);
		} finally {
			outputStream.flush();
			outputStream.close();
		}
		return null;
	}

	/**
	 * Download Help PDF file
	 * @return
	 * @throws HWFServiceStubException
	 * @throws ALOCException
	 * @throws HWFServiceException
	 * @throws IOException
	 */
	public String downloadHelpPDF() throws HWFServiceStubException,
		ALOCException, HWFServiceException, IOException {	
		HttpServletResponse response = ServletActionContext.getResponse();		
		Attachment atmt =null;
		OutputStream outputStream = null;
		String fileName = ALOCConstants.EMPTY_STRING;
		downloadDocs = getDownloadDocs();
		if (downloadDocs != null && downloadDocs.size() == ALOCConstants.DOWNLOAD_DOC_MIN_SIZE) {
			for (String docName : downloadDocs) {
				AlocHelpFileType downloadDoc = AlocHelpFileType.fromName(docName);
				atmt = getHelpAttachmentByType(downloadDoc);	
				try {						
					response.setContentType(ServletActionContext.getServletContext().getMimeType(atmt.getAttachmentName()));
					response.addHeader(ALOCConstants.HEADER_CONTENT_DISPOSITION,ALOCConstants.CONTENT_DISPOSITION_VALUE+ atmt.getAttachmentName());
					outputStream = response.getOutputStream();				
					alocAttachmentManager.downloadStaticAttachment(outputStream,atmt);
				} finally {
					outputStream.flush();
					outputStream.close();
				}

			}		
		}else if (downloadDocs != null
				&& downloadDocs.size() > ALOCConstants.DOWNLOAD_DOC_MIN_SIZE) {	
			String zipFileName= com.ge.aloc.common.util.BeanUtils.initCap(downloadDocs.get(ALOCConstants.DOWNLOAD_DOC_BASE_INDEX));
			fileName = new StringBuilder().append(ALOCConstants.ALOC_UNDERSCORE).append(zipFileName).append(ALOCConstants.HYPEN).append(ALOCConstants.HELP).append(ALOCConstants.DOCS_ZIP).toString();
			response.setContentType(ServletActionContext.getServletContext().getMimeType(fileName));
			response.addHeader(ALOCConstants.HEADER_CONTENT_DISPOSITION,ALOCConstants.CONTENT_DISPOSITION_VALUE + fileName);			
			OutputStream outStream = response.getOutputStream();
			ZipOutputStream zOutputStream = new ZipOutputStream(new BufferedOutputStream(outStream));			
			try {
				for (String docName : downloadDocs) {
					AlocHelpFileType downloadDoc = AlocHelpFileType.fromName(docName);						
					atmt = getHelpAttachmentByType(downloadDoc);
					ZipEntry zipEntry = null;
					zipEntry = new ZipEntry(atmt.getAttachmentName());
					zOutputStream.putNextEntry(zipEntry);	
					alocAttachmentManager.downloadStaticAttachment(zOutputStream,atmt);				
					zOutputStream.closeEntry();
				}
				zOutputStream.flush();
			} catch (IOException ioe) {
				String errMsg = new StringBuilder()
				.append(ALOCConstants.ERROR_WHILE_DOWNLOADING_THE_FILE)
				.append(ALOCConstants.AS_ZIP).toString();				
				throw new ALOCReportException(errMsg, ioe);
			} finally {
				try {
					if (zOutputStream != null) {
						zOutputStream.close();
					}
				} catch (IOException ioe) {
					String errMsg = new StringBuilder().append(ALOCConstants.ERROR_WHILE_CLOSING_ZIPOUTPUT_STREAM).append(fileName).toString();	
					LOGGER.error(errMsg, ioe);
				}
				zOutputStream = null;
			}
		}	
		return null;
	}

	/**
	 * 
	 * @param downloadDoc
	 * @return
	 */
	private Attachment getHelpAttachmentByType(AlocHelpFileType downloadDoc){
		ResourceBundle glossaryBundle = ResourceBundle.getBundle(ALOCConstants.APP_CONFIG_FILE);
		String fileName = ALOCConstants.EMPTY_STRING;
		String geLibFileId = null;
		Attachment atmt =null;		
		if (downloadDoc != null) {
			switch (downloadDoc) {
			case BANKFEE:	
				fileName = glossaryBundle.getString(ALOCConstants.BANKFEEPAYMENT_HELP_FILE_NAME);
				geLibFileId =  glossaryBundle.getString(ALOCConstants.BANKFEEPAYMENT_HELP_FILE_ID);
				atmt = getAttachmentDetails(fileName.trim(),geLibFileId.trim());												
				break;									
			case SURETYBONDFEE:	
				fileName = glossaryBundle.getString(ALOCConstants.SURETYBONDFEEPAYMENT_HELP_FILE_NAME);
				geLibFileId =  glossaryBundle.getString(ALOCConstants.SURETYBONDFEEPAYMENT_HELP_FILE_ID);
				atmt = getAttachmentDetails(fileName.trim(),geLibFileId.trim());												
				break;		
			case FEESAMPLE:	
				fileName = glossaryBundle.getString(ALOCConstants.FEECALCULATIONSAMPLE_HELP_FILE_NAME);
				geLibFileId =  glossaryBundle.getString(ALOCConstants.FEECALCULATIONSAMPLE_HELP_FILE_ID);
				atmt = getAttachmentDetails(fileName.trim(),geLibFileId.trim());												
				break;									
			case GLOSSARY:	
				fileName = glossaryBundle.getString(ALOCConstants.GLOSSARY_HELP_FILE_NAME);
				geLibFileId =  glossaryBundle.getString(ALOCConstants.GLOSSARY_HELP_FILE_ID);
				atmt = getAttachmentDetails(fileName.trim(),geLibFileId.trim());												
				break;	
			case POLICY:	
				fileName = glossaryBundle.getString(ALOCConstants.POLICY_HELP_FILE_NAME);
				geLibFileId =  glossaryBundle.getString(ALOCConstants.POLICY_HELP_FILE_ID);
				atmt = getAttachmentDetails(fileName.trim(),geLibFileId.trim());										
				break;									
			case FORMATREDFLAG:	
				fileName = glossaryBundle.getString(ALOCConstants.FORMATRESDFLAGS_HELP_FILE_NAME);
				geLibFileId =  glossaryBundle.getString(ALOCConstants.FORMATRESDFLAGS_HELP_FILE_ID);
				atmt = getAttachmentDetails(fileName.trim(),geLibFileId.trim());										
				break;	
			case SITEADMINS:	
				fileName = glossaryBundle.getString(ALOCConstants.SITEADMINS_HELP_FILE_NAME);
				geLibFileId =  glossaryBundle.getString(ALOCConstants.SITEADMINS_HELP_FILE_ID);
				atmt = getAttachmentDetails(fileName.trim(),geLibFileId.trim());											
				break;									
			case PARTICIPATINGBANK:	
				fileName = glossaryBundle.getString(ALOCConstants.PARTICIPATINGBANKS_HELP_FILE_NAME);
				geLibFileId =  glossaryBundle.getString(ALOCConstants.PARTICIPATINGBANKS_HELP_FILE_ID);
				atmt = getAttachmentDetails(fileName.trim(),geLibFileId.trim());												
				break;	
			case BANKFORTPT:	
				fileName = glossaryBundle.getString(ALOCConstants.BANKSFORTPT_HELP_FILE_NAME);
				geLibFileId =  glossaryBundle.getString(ALOCConstants.BANKSFORTPT_HELP_FILE_ID);
				atmt = getAttachmentDetails(fileName.trim(),geLibFileId.trim());										
				break;									
			case PRIVATEBANK:	
				fileName = glossaryBundle.getString(ALOCConstants.PRIVATEBANKS_HELP_FILE_NAME);
				geLibFileId =  glossaryBundle.getString(ALOCConstants.PRIVATEBANKS_HELP_FILE_ID);
				atmt = getAttachmentDetails(fileName.trim(),geLibFileId.trim());											
				break;	
			case USERMANUAL:	
				fileName = glossaryBundle.getString(ALOCConstants.USERMANUAL_HELP_FILE_NAME);
				geLibFileId =  glossaryBundle.getString(ALOCConstants.USERMANUAL_HELP_FILE_ID);
				atmt = getAttachmentDetails(fileName.trim(),geLibFileId.trim());											
				break;									
			case USERROLES:	
				fileName = glossaryBundle.getString(ALOCConstants.USERROLES_HELP_FILE_NAME);
				geLibFileId =  glossaryBundle.getString(ALOCConstants.USERROLES_HELP_FILE_ID);
				atmt = getAttachmentDetails(fileName.trim(),geLibFileId.trim());												
				break;
			}
		}
		return atmt; 
	}
	/**
	 * This is used for setting the attachment details
	 * @param fileName
	 * @param geLibFileId
	 * @return
	 */
	private Attachment getAttachmentDetails(String fileName,String geLibFileId){
		Attachment atmt = new Attachment();
		atmt.setAttachmentName(fileName);
		atmt.setGeFileId(geLibFileId);	
		return atmt;
	}

	/**
	 * This method is used to load Contact Us Page
	 * @return
	 * @throws HWFServiceException 
	 */
	public String getContactUs() throws HWFServiceException{
		contactDetails = homePageManager.getContactDetails();
		return SUCCESS;
	}

	/**
	 * This method is used to open Help Page
	 * @return
	 * @throws HWFServiceException
	 */
	public String getHelpPage() throws HWFServiceException{
		return SUCCESS;
	}


	/**
	 * This method decides the page to display on validation error conditions
	 */
	public String getInputResultName() {
		errorShow=true;	
		return INPUT;
	}
	
	/**
	 * @return the contactDetails
	 */
	public ContactUsDtls getContactDetails() {
		return contactDetails;
	}

	/**
	 * @param contactDetails the contactDetails to set
	 */
	public void setContactDetails(ContactUsDtls contactDetails) {
		this.contactDetails = contactDetails;
	}

	/**
	 * This is used to create homePageManager instance object.
	 * @return
	 */
	public IHomePageManager getHomePageManager() {
		return homePageManager;
	}
	/**
	 * This is used to set homePageManager instance object.
	 * @param homePageManager
	 */
	public void setHomePageManager(IHomePageManager homePageManager) {
		this.homePageManager = homePageManager;
	}



	/**
	 * This is used to create alocAttachmentManager instance object.
	 * @return the alocAttachmentManager
	 */
	public IALOCAttachmentManager getAlocAttachmentManager() {
		return alocAttachmentManager;
	}



	/**
	 * This is used to set alocAttachmentManager instance object.
	 * @param alocAttachmentManager the alocAttachmentManager to set
	 */
	public void setAlocAttachmentManager(
			IALOCAttachmentManager alocAttachmentManager) {
		this.alocAttachmentManager = alocAttachmentManager;
	}
	
	/**
	 * This is used to get the download help documents list.
	 * @return the downloadDocs
	 */
	public List<String> getDownloadDocs() {
		return downloadDocs; 
	}

	/**
	 * This is used to set the download help documents list.
	 * @param downloadDocs the downloadDocs to set
	 */
	public void setDownloadDocs(List<String> downloadDocs) {
		this.downloadDocs = downloadDocs;
	}

	public boolean isErrorShow() {
		return errorShow;
	}

	public void setErrorShow(boolean errorShow) {
		this.errorShow = errorShow;
	}

}
