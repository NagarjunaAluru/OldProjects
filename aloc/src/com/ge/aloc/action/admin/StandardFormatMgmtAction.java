/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: StandardFormatMgmtAction.java
 * Purpose: StandardFormatMgmtAction used for the all treasury admin portal operations
 */
package com.ge.aloc.action.admin;

import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jxl.common.Logger;

import org.apache.struts2.ServletActionContext;

import com.ge.aloc.InstrumentType;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.exception.ALOCException;
import com.ge.aloc.manager.admin.IStandardFormatMgmtManager;
import com.ge.aloc.model.BookMarkMaster;
import com.ge.aloc.model.FormatAuditTrail;
import com.ge.aloc.model.FormatAuditTrailCollection;
import com.ge.aloc.model.StandardFormatMaster;
import com.hydus.hwf.exceptions.HWFServiceException;
import com.hydus.hwf.util.StringUtils;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;



/**
 * @author rajeswari.guthi
 *
 */
public class StandardFormatMgmtAction extends ActionSupport {

	private static final long serialVersionUID = 6466762292901502406L;
	
	private static final Logger LOGGER = Logger.getLogger(StandardFormatMgmtAction.class);

	private StandardFormatMaster standardFormatMaster;

	protected IStandardFormatMgmtManager standardFormatMgmtManager;	

	/**
	 * This method is used to open standard format management form.
	 * @return
	 * @throws HWFServiceException
	 */
	public String openStdFormatUrlManagement() throws HWFServiceException{
		return SUCCESS;
	}

	/**
	 * This method is used to get the standard format management.
	 * @return 
	 * @throws HWFServiceException
	 */
	public String getStdFormatManagement() throws HWFServiceException {	
		try{			
			standardFormatMaster = standardFormatMgmtManager.getStandardFormatMaster(standardFormatMaster);	
			standardFormatMaster = getModifiedBookMarkList(standardFormatMaster);
			ActionContext.getContext().getSession().put(ALOCConstants.STANDARDFORMATDATA, standardFormatMaster);
		}catch(HWFServiceException hse){		
			addActionMessage(hse.getReason());				
		}
		return SUCCESS;	
	}


	/**
	 * This method is used to manage the standard format management.
	 * @return
	 * @throws HWFServiceException
	 */
	public String standardFormatManagement() throws HWFServiceException {					
		try{
			if(standardFormatMaster==null){
				standardFormatMaster = (StandardFormatMaster)ActionContext.getContext().getSession().get(ALOCConstants.STANDARDFORMATDATA);				
			}			
			standardFormatMaster = standardFormatMgmtManager.manageStandardFormatMaster(standardFormatMaster);			
			standardFormatMaster = getModifiedBookMarkList(standardFormatMaster);
		}catch(HWFServiceException hse){			
			String templateText = standardFormatMaster.getStandardFormatFormat();
			standardFormatMaster =(StandardFormatMaster) ActionContext.getContext().getSession().get(ALOCConstants.STANDARDFORMATDATA);
			standardFormatMaster.setStandardFormatFormat(templateText);
			standardFormatMaster.setSaveCode(ALOCConstants.PRICING_ACCEPT_FLAG);
			return INPUT;			
		}	
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute(ALOCConstants.PORTAL_SUCCESSMSG,ALOCConstants.STANDARD_FMT_SUCCESS_MSG);
		return SUCCESS;
	}

	/**
	 * This method is used update the GE standard format file.
	 * @return
	 * @throws HWFServiceException
	 * @throws DocumentException 
	 */
	public String updatedGeStandardFormatFile() throws IOException, HWFServiceException,ALOCException, DocumentException {		
		OutputStream outputStream = null;	
		StringReader stringReader = null;
		Document document = null;
		int formatIndexZero = ALOCConstants.FORMAT_START_INDEX;
		try{				
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();					
			String auditTrailId = request.getParameter(ALOCConstants.FORMATAUDITTRAILID);	
			String InstrumnetTypeId= request.getParameter(ALOCConstants.INSTRUMENT_TYPE_ID);	 
			FormatAuditTrail formatAuditTrail = new FormatAuditTrail();
			formatAuditTrail.setFormatAuditTrailId(Long.valueOf(auditTrailId));
			List<FormatAuditTrail> formatAuditTrailList = new ArrayList<FormatAuditTrail>();
			formatAuditTrailList.add(formatAuditTrail);
			FormatAuditTrailCollection formatAuditTrailCollection = new FormatAuditTrailCollection();
			formatAuditTrailCollection.setFormatAuditTrails(formatAuditTrailList); 
			standardFormatMaster.setFormatAuditTrailCollection(formatAuditTrailCollection);
			standardFormatMaster = standardFormatMgmtManager.getUpdatedGeStandardFormatFile(standardFormatMaster);
			String fileName = getPDFFileName(auditTrailId,InstrumnetTypeId);			
			if (StringUtils.isNotBlank(standardFormatMaster.getFormatAuditTrailCollection().getFormatAuditTrails().get(formatIndexZero).getOldFormat())) {												
				response.addHeader(ALOCConstants.HEADER_CONTENT_DISPOSITION,ALOCConstants.CONTENT_DISPOSITION_VALUE+ fileName);
				String formatObject = standardFormatMaster.getFormatAuditTrailCollection().getFormatAuditTrails().get(formatIndexZero).getOldFormat();
				//fetch the html content line by line
				outputStream = response.getOutputStream();
				int pageSizesFifty = ALOCConstants.DOCUMENT_PAGESIZES;
				document = new Document(PageSize.A4, pageSizesFifty, pageSizesFifty, pageSizesFifty, pageSizesFifty);
				PdfWriter.getInstance(document, outputStream);			    
				document.open();
				stringReader = new StringReader(formatObject);
				ArrayList<Element> htmlContentList = (ArrayList<Element>) HTMLWorker.parseToList(stringReader, null);
				for(Element htmlDataElement : htmlContentList) {	           
					document.add(htmlDataElement);
				}
			}				
		}catch(HWFServiceException hse){						
			addActionMessage(hse.getReason());								
		} finally {		
			if(document != null) {
				document.close();
			}
			if(stringReader != null){
				stringReader.close();
			} 
			
			try {
				if(outputStream != null) {
					outputStream.close();
				}
			} catch (IOException ioe) {
				LOGGER.warn(ALOCConstants.ERROR_WHILE_CLOSINGTHE_OUTPUTSTREAM, ioe);
			}
		}			
		return null;
	}


	/**
	 * This is used to create standardFormatMgmtManager instance object.
	 * @return
	 */
	public IStandardFormatMgmtManager getStandardFormatMgmtManager() {
		return standardFormatMgmtManager;
	}

	/**
	 * This is used to create standardFormatMgmtManager instance object.
	 * @param standardFormatMgmtManager
	 */
	public void setStandardFormatMgmtManager(IStandardFormatMgmtManager standardFormatMgmtManager) {
		this.standardFormatMgmtManager = standardFormatMgmtManager;
	}


	/**
	 * This is used to create standardFormatMaster instance object.
	 * @return the standardFormatMaster
	 */
	public StandardFormatMaster getStandardFormatMaster() {
		return standardFormatMaster;
	}


	/**
	 * This is used to create standardFormatMaster instance object.
	 * @param standardFormatMaster the standardFormatMaster to set
	 */
	public void setStandardFormatMaster(StandardFormatMaster standardFormatMaster) {
		this.standardFormatMaster = standardFormatMaster;
	}

	/**
	 * This method is used to create the PDF file Name based on instrument type.
	 * @param formatAuditTrailId
	 * @return
	 */
	private String getPDFFileName(String formatAuditTrailId,String instrumnetTypeId){
		String fileName=ALOCConstants.EMPTY_STRING;
		int formatIndexZero = ALOCConstants.FORMAT_START_INDEX;
		String underscore = ALOCConstants.UNDERSCORE;
		String pdfExtension = ALOCConstants.PDF_EXTENSION;
		InstrumentType instrumentType = InstrumentType.fromId(Integer.valueOf(instrumnetTypeId).intValue());		
		Calendar cal = Calendar.getInstance(standardFormatMaster.getFormatAuditTrailCollection().getFormatAuditTrails().get(formatIndexZero).getAuditModifiedDt().getTimeZone());
		cal.setTimeInMillis(standardFormatMaster.getFormatAuditTrailCollection().getFormatAuditTrails().get(formatIndexZero).getAuditModifiedDt().getTimeInMillis());		
		SimpleDateFormat dateFormat = new SimpleDateFormat(ALOCConstants.STANDARDFORMATDATE);			
		String modifiedFomatDate = dateFormat.format(cal.getTimeInMillis());		
		switch(instrumentType) {
		case BANK_GUARANTEE:
			fileName=ALOCConstants.FILENAME_BG_+standardFormatMaster.getStandardFormatId()+underscore+formatAuditTrailId+underscore+modifiedFomatDate+pdfExtension;
			break;
		case LOC:
			fileName=ALOCConstants.FILENAME_SBLC_+standardFormatMaster.getStandardFormatId()+underscore+modifiedFomatDate+pdfExtension;
			break;
		case SURETY_BOND:
			fileName=ALOCConstants.FILENAME_SURETY_+standardFormatMaster.getStandardFormatId()+underscore+modifiedFomatDate+pdfExtension;
			break;
		case DOCUMENT_LOC:
			fileName=ALOCConstants.FILENAME_DOCLC_+modifiedFomatDate+pdfExtension;
			break;
		}
		return fileName;

	}

	/**
	 * This method is used to remove the < and > symobols in the bookmarkslist
	 * @param standardFormatMaster
	 * @return
	 */
	private StandardFormatMaster getModifiedBookMarkList(StandardFormatMaster standardFormatMaster){
		if(standardFormatMaster.getBookMarkMasterCollection().getBookMarkMasters()!=null && !standardFormatMaster.getBookMarkMasterCollection().getBookMarkMasters().isEmpty()){
			List<BookMarkMaster> bookMarksList = new ArrayList<BookMarkMaster>();
			List<BookMarkMaster> bookMarks = standardFormatMaster.getBookMarkMasterCollection().getBookMarkMasters();
			for(BookMarkMaster bookmark:bookMarks)
			{
				String bookmarkName = bookmark.getBookMarkName().replace(ALOCConstants.LESS_THAN, ALOCConstants.EMPTY_STRING);
				bookmarkName = bookmarkName.replace(ALOCConstants.GREATER_THAN, ALOCConstants.EMPTY_STRING);
				bookmark.setBookMarkName(bookmarkName);
				if(!bookMarksList.contains(bookmark))
					bookMarksList.add(bookmark);
			}
			standardFormatMaster.getBookMarkMasterCollection().getBookMarkMasters().clear();
			standardFormatMaster.getBookMarkMasterCollection().setBookMarkMasters(bookMarksList);
		}
		return standardFormatMaster;
	}
}
