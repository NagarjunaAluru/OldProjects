/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: AttachmentAction.java
 * Purpose:AttachmentAction used for the attachments upload into local path 
 * and delete from local path as well as gelib
 * 
 */
package com.ge.icfp.common.action;

import static com.ge.icfp.common.attachments.IAttachmentConstants.JSON_PROP_STATUS;
import static com.ge.icfp.common.attachments.IAttachmentConstants.JSON_PROP_ERRMSG;
import static com.ge.icfp.common.attachments.IAttachmentConstants.JSON_PROP_ERRCODE;
import static com.ge.icfp.common.attachments.IAttachmentConstants.JSON_PROP_ATTACHMENT;
import static com.ge.icfp.common.attachments.IAttachmentConstants.JSON_PROP_GELIBFILEID;
import static com.ge.icfp.common.attachments.IAttachmentConstants.JSON_PROP_NAME;
import static com.ge.icfp.common.attachments.IAttachmentConstants.JSON_PROP_GELIBFILENAME;
import static com.ge.icfp.common.attachments.IAttachmentConstants.JSON_PROP_TYPE;
import static com.ge.icfp.common.attachments.IAttachmentConstants.JSON_PROP_TYPEID;
import static com.ge.icfp.common.attachments.IAttachmentConstants.JSON_PROP_DEALSEQID;
import static com.ge.icfp.common.attachments.IAttachmentConstants.JSON_PROP_LEGSEQID;
import static com.ge.icfp.common.attachments.IAttachmentConstants.JSON_PROP_DERIVATIVEINDEX;
import static com.ge.icfp.common.attachments.IAttachmentConstants.JSON_PROP_EXCEPTIONINDEX;
import static com.ge.icfp.common.attachments.IAttachmentConstants.JSON_PROP_AMENDMENTINDEX;
import static com.ge.icfp.common.attachments.IAttachmentConstants.JSON_PROP_LEGINDEX;
import static com.ge.icfp.common.attachments.IAttachmentConstants.JSON_PROP_DERIVATIVESEQID;
import static com.ge.icfp.common.attachments.IAttachmentConstants.JSON_PROP_EXCEPTIONSEQID;
import static com.ge.icfp.common.attachments.IAttachmentConstants.JSON_PROP_AMENDMENTSEQID;
import static com.ge.icfp.common.attachments.IAttachmentConstants.PARAM_TYPE;
import static com.ge.icfp.common.attachments.IAttachmentConstants.PARAM_ATTFILE;
import static com.ge.icfp.common.attachments.IAttachmentConstants.PARAM_SELECTEDLEGS;
import static com.ge.icfp.common.attachments.IAttachmentConstants.PARAM_LEGINDEX;
import static com.ge.icfp.common.attachments.IAttachmentConstants.PARAM_DERIVATIVEINDEX;
import static com.ge.icfp.common.attachments.IAttachmentConstants.PARAM_EXCEPTIONINDEX;
import static com.ge.icfp.common.attachments.IAttachmentConstants.PARAM_AMENDMENTINDEX;
import static com.ge.icfp.common.attachments.IAttachmentConstants.PARAM_GELIBFILEID;
import static com.ge.icfp.common.attachments.IAttachmentConstants.PARAM_APPLYTOALLLEGS;
import static com.ge.icfp.common.attachments.IAttachmentConstants.HEADER_CONTENT_DISPOSITION;
import static com.ge.icfp.common.attachments.IAttachmentConstants.CONTENT_DISPOSITION_VALUE;
import static com.ge.icfp.common.attachments.IAttachmentConstants.STATUS_FAILURE;
import static com.ge.icfp.common.attachments.IAttachmentConstants.STATUS_SUCCESS;
import static com.ge.icfp.common.attachments.IAttachmentConstants.JSON_PROP_ATMT_COUNT;


import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.upload.FormFile;

import com.ge.icfp.action.ICFPBaseAction;
import com.ge.icfp.action.ICFPException;
import com.ge.icfp.common.attachments.AttachmentType;
import com.ge.icfp.common.attachments.AttachmentUtils;
import com.ge.icfp.common.attachments.AttachmentViewFunctions;
import com.ge.icfp.common.attachments.ICFPAttachmentException;
import com.ge.icfp.common.attachments.ICFPAttachmentManager;
import com.ge.icfp.common.constants.ICFPConstants;
import com.ge.icfp.common.helper.CurrentDealManager;
import com.ge.icfp.model.Attachment;
import com.ge.icfp.model.DealRequest;
import com.ge.icfp.util.Utils;
import com.ge.icfp.util.report.pdf.DealPDFGenerator;
import com.ge.icfp.util.report.pdf.ReportType;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.hydus.wff.common.bw.ServiceClient;
import com.hydus.wff.core.exception.HWFServiceException;
import com.hydus.wff.core.exception.HWFStubException;


/**
 *	AttachmentAction used for the attachments upload into local path 
 * @author hariprasad.madas
 *
 */
public class AttachmentAction extends ICFPBaseAction {
	private static final String UW = "UW";

	/**
	 * LOGGER
	 */
	private static final Logger LOGGER = Logger.getLogger(AttachmentAction.class);

	/**
	 * serviceClient
	 */
	private ServiceClient serviceClient;
	
	private ICFPAttachmentManager attachmentManager;
	
	/**
	 * Method used to upload attachments for particular attachment type and return respective view 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 * @throws ICFPException 
	 */
	public ActionForward upload(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws ICFPException, IOException {
		
		AttachmentType attachmentType = AttachmentType.fromId(Integer.valueOf(request.getParameter(PARAM_TYPE)));
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		FormFile attachmentFile = (FormFile) ((DynaActionForm) form).get(PARAM_ATTFILE);
		
		Integer[] selectedLegs = Utils.convertStringArrayToIntegerArray(request.getParameterValues(PARAM_SELECTEDLEGS));
		Boolean applyToAllLegs = (StringUtils.isNotBlank(request.getParameter(PARAM_APPLYTOALLLEGS))) ? Boolean.valueOf(request.getParameter(PARAM_APPLYTOALLLEGS)) : null;
		Integer legIndex = (StringUtils.isNotBlank(request.getParameter(PARAM_LEGINDEX))) ? Integer.valueOf(request.getParameter(PARAM_LEGINDEX)) : null;
		Integer derivativeIndex = (StringUtils.isNotBlank(request.getParameter(PARAM_DERIVATIVEINDEX))) ? Integer.valueOf(request.getParameter(PARAM_DERIVATIVEINDEX)) : null;
		Integer exceptionIndex = (StringUtils.isNotBlank(request.getParameter(PARAM_EXCEPTIONINDEX))) ? Integer.valueOf(request.getParameter(PARAM_EXCEPTIONINDEX)) : null;
		Integer amendmentIndex = (StringUtils.isNotBlank(request.getParameter(PARAM_AMENDMENTINDEX))) ? Integer.valueOf(request.getParameter(PARAM_AMENDMENTINDEX)) : null;
		
		List<Attachment> uploadedAttachments = null;
		ICFPException exception = null;
		JsonArray resultJsonArray = new JsonArray();
		try {
			if(AttachmentType.isLegAttachmentType(attachmentType)) {
				if(applyToAllLegs != null && applyToAllLegs) {
					Integer[] allLegIndexes = AttachmentUtils.getAllAttachmentLegIndexes(deal);
					uploadedAttachments = attachmentManager.addLegAttachment(attachmentFile, attachmentType, null, deal, allLegIndexes);
					for(int i = 0; i < uploadedAttachments.size(); i++) {
						resultJsonArray.add(createAttachmentJSONObject(uploadedAttachments.get(i), deal, allLegIndexes[i], null, null, null));
					}
				} else if(selectedLegs != null && selectedLegs.length > 0) {
					uploadedAttachments = attachmentManager.addLegAttachment(attachmentFile, attachmentType, null, deal, selectedLegs);
					for(int i = 0; i < uploadedAttachments.size(); i++) {
						resultJsonArray.add(createAttachmentJSONObject(uploadedAttachments.get(i), deal, selectedLegs[i], null, null, null));
					}
				} else {
					uploadedAttachments = attachmentManager.addLegAttachment(attachmentFile, attachmentType, null, deal, legIndex);
					resultJsonArray.add(createAttachmentJSONObject(uploadedAttachments.get(0), deal, legIndex, null, null, null));
				}
			} else {
				Attachment attachment = attachmentManager.addAttachment(attachmentFile, attachmentType, null, deal, legIndex, derivativeIndex, exceptionIndex, amendmentIndex);
				uploadedAttachments = new ArrayList<Attachment>();
				uploadedAttachments.add(attachment);
				resultJsonArray.add(createAttachmentJSONObject(attachment, deal, legIndex, derivativeIndex, exceptionIndex, amendmentIndex));
			}
		} catch (ICFPAttachmentException ae) {
			exception = ae;
		} catch(ICFPException e) {
			String errMsg = new StringBuilder().append("Error while uploading the file ")
					.append(constructAttachmentMessage(attachmentFile, attachmentType, deal, legIndex, derivativeIndex, exceptionIndex, amendmentIndex))
					.toString();
			LOGGER.error(errMsg, e);
			exception = e;
		}
		
		JsonObject result = new JsonObject();
		if(exception != null) {
			result.addProperty(JSON_PROP_STATUS, STATUS_FAILURE);
			result.addProperty(JSON_PROP_ERRCODE, exception.getCode());
			result.addProperty(JSON_PROP_ERRMSG, exception.getLocalizedMessage());
		} else {
			result.addProperty(JSON_PROP_STATUS, STATUS_SUCCESS);
			result.add(JSON_PROP_ATTACHMENT, resultJsonArray);
		}
		writeResponse(result, response);
		return null;
	}
	

	/**
	 * Method used to delete attachment for particular type and returns particular view
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException {
		String geLibFileId = request.getParameter(PARAM_GELIBFILEID);
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		Attachment attachment = null;
		ICFPException exception = null;
		try {
			if(StringUtils.isNotBlank(geLibFileId)) {
				attachment = attachmentManager.delete(geLibFileId, deal);
			}
		} catch (ICFPAttachmentException e) {
			String errMsg = new StringBuilder().append("Error while deleting the file ").append(geLibFileId).toString();
			LOGGER.error(errMsg, e);
			exception = e;
		} catch (ICFPException e) {
			String errMsg = new StringBuilder().append("Error while deleting the file ").append(geLibFileId).toString();
			LOGGER.error(errMsg, e);
			exception = e;
		}
		
		JsonObject result = new JsonObject();
		if(exception != null) {
			result.addProperty(JSON_PROP_STATUS, STATUS_FAILURE);
			result.addProperty(JSON_PROP_ERRCODE, exception.getCode());
			result.addProperty(JSON_PROP_ERRMSG, exception.getLocalizedMessage());
			JsonObject attachmentJsonObj = new JsonObject();
			attachmentJsonObj.addProperty(JSON_PROP_GELIBFILEID, geLibFileId);
			JsonArray attachments = new JsonArray();
			attachments.add(attachmentJsonObj);
			result.add(JSON_PROP_ATTACHMENT, attachments);
		} else {
			result.addProperty(JSON_PROP_STATUS, STATUS_SUCCESS);
			JsonArray attachments = new JsonArray();
			attachments.add(createAttachmentJSONObject(attachment, deal, null, null, null, null));
			result.add(JSON_PROP_ATTACHMENT, attachments);
		}
		
		writeResponse(result, response);
		
		return null;
	}
	
	/**
	 *  Method used download file from GELib based on request parameters like GELIb FileID etc
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public ActionForward download(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException {
		String geLibFileId = request.getParameter(PARAM_GELIBFILEID);
		OutputStream outStream = null;
		ICFPException exception = null;
		try {
			if(StringUtils.isNotBlank(geLibFileId)) {
				DealRequest deal = CurrentDealManager.getCurrentDeal(request);
				Attachment attachmentToDownload = AttachmentUtils.getAttachmentByGELibId(geLibFileId, deal);
				response.setContentType(getServlet().getServletContext().getMimeType(attachmentToDownload.getOrigAttachmentName()));
				response.addHeader(HEADER_CONTENT_DISPOSITION, CONTENT_DISPOSITION_VALUE + attachmentToDownload.getOrigAttachmentName()); 
				outStream = response.getOutputStream();
				attachmentManager.downloadAttachment(outStream, attachmentToDownload, deal);
			}
		} catch (ICFPAttachmentException e) {
			String errMsg = new StringBuilder().append("Error while downloading the file ").append(geLibFileId).toString();
			LOGGER.error(errMsg, e);
			exception = e;
		} catch (ICFPException e) {
			String errMsg = new StringBuilder().append("Error while downloading the file ").append(geLibFileId).toString();
			LOGGER.error(errMsg, e);
			exception = e;
		} 
		
		if(exception != null) {
			JsonObject result = new JsonObject();
			result.addProperty(JSON_PROP_STATUS, STATUS_FAILURE);
			result.addProperty(JSON_PROP_ERRCODE, exception.getCode());
			result.addProperty(JSON_PROP_ERRMSG, exception.getLocalizedMessage());
			JsonObject attachment = new JsonObject();
			attachment.addProperty(PARAM_GELIBFILEID, geLibFileId);
			writeResponse(result, response);
		}
		
		return null;
	}
	
	/**
	 * Create Underwriting PDF file and sends it to download
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws ICFPException
	 * @throws IOException 
	 * @throws HWFStubException 
	 * @throws HWFServiceException 
	 */
	public ActionForward downloadUnderWritingFile(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws IOException, HWFServiceException, HWFStubException{
		AttachmentType attachmentType = (request.getParameter(PARAM_TYPE) != null) ? AttachmentType.fromId(Integer.valueOf(request.getParameter(PARAM_TYPE))) : null;
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		Attachment attachment = null;
		ICFPException exception = null;
		
		// Check if UW file is finalized already
		try {
			if(attachmentType == AttachmentType.UNDERWRITING) {
				List<Attachment> uwFileList = AttachmentUtils.searchAttachmentByType(AttachmentType.UNDERWRITING, deal.getAttachments());
				if(!uwFileList.isEmpty()) {
					attachment = uwFileList.get(0);
					response.setContentType(getServlet().getServletContext().getMimeType(attachment.getOrigAttachmentName()));
					response.addHeader(HEADER_CONTENT_DISPOSITION, CONTENT_DISPOSITION_VALUE + attachment.getOrigAttachmentName());
					attachmentManager.downloadAttachment(response.getOutputStream(), attachment, deal);
				}
			}
		} catch (ICFPAttachmentException e) {
			String errMsg = new StringBuilder().append("Error while downloading the file ").append(attachment.getGeFolderId()).toString();
			LOGGER.error(errMsg, e);
			exception = e;
		} catch (ICFPException e) {
			String errMsg = new StringBuilder().append("Error while downloading the file ").append(attachment.getGeFolderId()).toString();
			LOGGER.error(errMsg, e);
			exception = e;
		}
		
		try {
			// UW file is not finalized or request is for not UW file
			if(attachment == null) {
				DealPDFGenerator pdfGenerator = new DealPDFGenerator(deal);
				pdfGenerator.init(request, (AttachmentType.UNDERWRITING == attachmentType) ? ReportType.UNDERWRITING : ReportType.EXPORT_DEAL);
				pdfGenerator.generate(request, response);
			}
		} catch (ICFPException e) {
			LOGGER.error("Error while generating the pdf file.", e);
			exception = e;
		}
		
		if(exception != null) {
			JsonObject result = new JsonObject();
			result.addProperty(JSON_PROP_STATUS, STATUS_FAILURE);
			result.addProperty(JSON_PROP_ERRCODE, exception.getCode());
			result.addProperty(JSON_PROP_ERRMSG, exception.getLocalizedMessage());
			JsonObject jsonAttachment = new JsonObject();
			jsonAttachment.addProperty(PARAM_GELIBFILEID, (attachment != null) ? attachment.getGeFileId() : UW);
			writeResponse(result, response);
		}
		return null;
	}
	
	/**
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	public ActionForward getAttachmentCount(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		Integer legIndex = (StringUtils.isNotBlank(request.getParameter(PARAM_LEGINDEX))) ? Integer.valueOf(request.getParameter(PARAM_LEGINDEX)) : null;
		int count = 0;
		JsonObject result = new JsonObject();
		try {
			count = (legIndex == null) ? AttachmentViewFunctions.getDealPageAttachmentsCount(request) 
					: AttachmentViewFunctions.getLegPageAttachmentsCount(legIndex, request);
			result.addProperty(JSON_PROP_STATUS, STATUS_SUCCESS);
			result.addProperty(JSON_PROP_ATMT_COUNT, ((count == 0) ? ICFPConstants.EMPTY : String.valueOf(count)));
		} catch (ICFPException e) {
			LOGGER.error("Error while fetching attachment count", e);
			result.addProperty(JSON_PROP_STATUS, STATUS_FAILURE);
		}
		writeResponse(result, response);
		return null;
	}
	
	/**
	 * Method used construct attachment message if any error occurs
	 * @param file
	 * @param type
	 * @param deal
	 * @param legIndex
	 * @param derivativeIndex
	 * @param exceptionIndex
	 * @param amendmentIndex
	 * @return
	 */
	private String constructAttachmentMessage(FormFile file, AttachmentType type, DealRequest deal, Integer legIndex, Integer derivativeIndex, Integer exceptionIndex, Integer amendmentIndex) {
		StringBuilder result = new StringBuilder();
		result.append("\'").append(file.getFileName()).append("\' of type ").append(type.getName()).append(" for the deal ").append(deal.getDealSeqId());
		if(legIndex != null) {
			result.append(", Leg Index ").append(legIndex);
		}
		
		if(derivativeIndex != null) {
			result.append(", Derivative Index ").append(derivativeIndex);
		}
		
		if(exceptionIndex != null) {
			result.append(", Exception Index ").append(exceptionIndex);
		}
		
		if(amendmentIndex != null) {
			result.append(" and Amendment Index ").append(amendmentIndex);
		}
		return result.toString();
	}
	
	/**
	 *  Method used to create json object to show attached file information at front end using ajax
	 * @param attachment
	 * @param deal
	 * @param legIndex
	 * @param derivativeIndex
	 * @param exceptionIndex
	 * @param amendmentIndex
	 * @return
	 */
	private JsonObject createAttachmentJSONObject(Attachment attachment, DealRequest deal, Integer legIndex, Integer derivativeIndex, Integer exceptionIndex, Integer amendmentIndex) {
		JsonObject result = new JsonObject();
		result.addProperty(JSON_PROP_NAME, attachment.getOrigAttachmentName());
		result.addProperty(JSON_PROP_GELIBFILENAME, attachment.getAttachmentName());
		result.addProperty(JSON_PROP_GELIBFILEID, attachment.getGeFileId());
		AttachmentType type = AttachmentType.fromId(attachment.getAttachmentTypeId());
		result.addProperty(JSON_PROP_TYPE, type.getName());
		result.addProperty(JSON_PROP_TYPEID, type.getId());
		result.addProperty(JSON_PROP_DEALSEQID, deal.getDealSeqId());
		result.addProperty(JSON_PROP_LEGINDEX, legIndex);
		result.addProperty(JSON_PROP_DERIVATIVEINDEX, derivativeIndex);
		result.addProperty(JSON_PROP_EXCEPTIONINDEX, exceptionIndex);
		result.addProperty(JSON_PROP_AMENDMENTINDEX, amendmentIndex);
		result.addProperty(JSON_PROP_LEGSEQID, attachment.getLegSeqId());
		result.addProperty(JSON_PROP_DERIVATIVESEQID, attachment.getDerivativesId());
		result.addProperty(JSON_PROP_EXCEPTIONSEQID, attachment.getExceptionId());
		result.addProperty(JSON_PROP_AMENDMENTSEQID, attachment.getAmendmentDetailsId());
		
		return result;
	}
	
	/**
	 * Method used to write response stream to HttpServletResponse object
	 * @param result
	 * @param response
	 * @throws IOException 
	 */
	private void writeResponse(JsonObject result, HttpServletResponse response) throws IOException {
		if(LOGGER.isInfoEnabled()) {
			LOGGER.info("Writing JSON response: " + result);
		}
		PrintWriter out = null;
        response.setHeader("Cache-control", "no-cache, no-store");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "-1");
        try {
			out = response.getWriter();
			out.print(result);
		} catch (IOException ioe) {
			LOGGER.error("Error while writing data to the response", ioe);
			throw ioe;
		} finally {
			if(out != null) {
				out.close();
			}
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public ServiceClient getServiceClient() {
		return serviceClient;
	}
	/**
	 * 
	 * @param serviceClient
	 */
	public void setServiceClient(ServiceClient serviceClient) {
		this.serviceClient = serviceClient;
	}

	/**
	 * @return the attachmentManager
	 */
	public ICFPAttachmentManager getAttachmentManager() {
		return attachmentManager;
	}

	/**
	 * @param attachmentManager the attachmentManager to set
	 */
	public void setAttachmentManager(ICFPAttachmentManager attachmentManager) {
		this.attachmentManager = attachmentManager;
	}

}


