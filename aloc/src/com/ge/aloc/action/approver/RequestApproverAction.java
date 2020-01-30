/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: RequestApproverAction.java
 * Purpose: RequestApproverAction used for the request approval operations
 */
package com.ge.aloc.action.approver;



import static com.ge.aloc.constants.ALOCConstants.EXPORTING_PDF_FOR_REQUEST;
import static com.ge.aloc.constants.ALOCConstants.SUBMIT;
import static com.ge.aloc.constants.ALOCConstants.SUCCESSFULLY_EXPORTED_THE_PDF_FOR_REQUEST;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.ge.aloc.ALOCContext;
import com.ge.aloc.ActionType;
import com.ge.aloc.FormatType;
import com.ge.aloc.InstrumentType;
import com.ge.aloc.WorkflowStage;
import com.ge.aloc.action.request.RequestDetailsSupportAction;
import com.ge.aloc.bo.AttachmentBO;
import com.ge.aloc.bo.RequestDetailsBO;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.exception.ALOCAttachmentException;
import com.ge.aloc.exception.ALOCException;
import com.ge.aloc.exception.ALOCRuntimeException;
import com.ge.aloc.model.Attachment;
import com.ge.aloc.model.MDM.Country;
import com.ge.aloc.model.OneTimeFeesDetails;
import com.ge.aloc.model.PricingDetails;
import com.ge.aloc.model.ReferenceNumberValidation;
import com.ge.aloc.model.RequestDetails;
import com.ge.aloc.reports.ALOCReportException;
import com.ge.aloc.reports.pdf.DownloadDocName;
import com.ge.aloc.reports.pdf.PDFReportGenerator;
import com.ge.aloc.reports.pdf.PDFReportGeneratorFactory;
import com.ge.aloc.reports.pdf.ReportType;
import com.ge.aloc.util.ALOCCommonHelper;
import com.ge.aloc.util.BookmarksHelper;
import com.hydus.hwf.exceptions.ErrorData;
import com.hydus.hwf.exceptions.HWFServiceException;
import com.hydus.hwf.exceptions.HWFServiceStubException;
import com.hydus.hwf.exceptions.IErrorHandler;
import com.hydus.hwf.util.StringUtils;
import com.opensymphony.xwork2.ActionContext;
/**
 * @author madhusudhan.gosula
 *
 */
public class RequestApproverAction extends RequestDetailsSupportAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ActionType actionType;
	protected List<String> downloadDocs;
	private String currentStage;
	protected boolean errorShow;
	protected String transmissionPlatform;  
	protected String workFlowstageId;
	protected String returnReason;
	protected String optionsRadiosp;
	protected String issuerRadioOption;
	protected IErrorHandler errorHandler;	
	private String errorMsg;
	protected String selBidWinnerType;
	protected String sitePrefix;

	private static final Logger LOGGER = Logger.getLogger(RequestApproverAction.class);
	
	@Override
	public String submit() throws HWFServiceException, ALOCException {
		String resultPage=null;		
		HttpSession session = ServletActionContext.getRequest().getSession();
		errorShow=false;
		if(requestId != null || amendmentOrRiderRequestId!=null){
			validateRequest();
		}
		if(actionType!=null){
			RequestDetails requestDetails = null;
			try{
				ALOCCommonHelper.setBidMemoDetails(rightBankRecords,hours,minutes,period,allInCommissionsValue,localCommissionsValue);
				ALOCCommonHelper.setBidReplyExpDateDetails(bidHours, bidMinutes, bidPeriod,allInCommissionsValue,localCommissionsValue,feeStructureValue);
				if(actionType==ActionType.BANK_AGREES_TO_CONFIRMATION){
					RequestDetails reqDet = requestDetailsBO.getModel();
					String refNoStatus = null;
					BigInteger instrumentType = reqDet != null ? reqDet.getInstrumentTypeId() : null;
					if(instrumentType!= null){
						refNoStatus = checkBankRefNumber();
						if(refNoStatus != null && refNoStatus.equalsIgnoreCase(ALOCConstants.ISSUER_BANKREFNO_EXISTED)){
							addFieldError(ALOCConstants.ISSUER_ACTIONS_ERROR_FILED, ALOCConstants.ISSUER_BANKREFNO_ERROR_MSG) ;
							errorShow=true;
							return openActiveRequest();
						}
					}
					saveFormatSwiftData();
				}else if(actionType==ActionType.SUBMIT_BID_REPLY || actionType ==ActionType.SUBMIT_BID_REPLY_FOR_BUNDLE){
					sendFormatSwiftData();
				}
				requestDetails = requestDetailsManager.saveandApprove(actionType);
			}catch(HWFServiceException hse){	
				ErrorData errorData = errorHandler.handle(hse);
				this.errorMsg = errorData.getCause().getMessage();				
				return openActiveRequest();
			}
			// Save and Go To Next | Submit bid for Bundle
			if(requestDetails.getRequestId()!=null){
				requestDetailsBO = new RequestDetailsBO(requestDetails);
				resultPage = openActiveRequest();
			}else{
				resultPage = SUCCESS;
			}
			
			session.setAttribute(ALOCConstants.SUCCESSMSG, requestDetails.getComments());
		}
		return resultPage;
	}
	
	/**
	 * This is used to check the Bank Reference Number is valid or not
	 * @return refNoCheck
	 * @throws HWFServiceException
	 */
	protected String checkBankRefNumber() throws HWFServiceException {
		String refNoCheck = null;
		ReferenceNumberValidation referenceNumberValidation = new ReferenceNumberValidation();
		List<AttachmentBO> attachmentBOList = requestDetailsBO.getAttachmentBOList();
		for(AttachmentBO atmtBO : attachmentBOList) {
			if(StringUtils.isNotBlank(atmtBO.getIssuanceDocType())){
				referenceNumberValidation.setIssuanceDocTypeId(new BigInteger(atmtBO.getIssuanceDocType()));
			}
			referenceNumberValidation.setReferenceNumber(atmtBO.getIssuanceBankRefNo());
			referenceNumberValidation.setRequestId(requestDetailsBO.getModel().getRequestId());
			if(StringUtils.isNotBlank(referenceNumberValidation.getReferenceNumber())){
				ReferenceNumberValidation refNoValidation = requestDetailsManager.checkBankRefNumber(referenceNumberValidation);
				referenceNumberValidation.setStatusMessage(refNoValidation.getStatusMessage());
				refNoCheck = refNoValidation.getStatusMessage();
				if(refNoCheck != null && refNoCheck.equalsIgnoreCase(ALOCConstants.ISSUER_BANKREFNO_EXISTED)){
					return refNoCheck;
				}
			}
		}
		return refNoCheck;
	}

	/**
	 * This is used to select the winner for Bid award
	 * @return
	 * @throws HWFServiceException
	 */
	public String selectWinnerForBidAward() throws HWFServiceException,ALOCException {
		String resultPage=null;
		HttpSession session = ServletActionContext.getRequest().getSession();
		if(actionType!=null){
			RequestDetails requestDetails = null;
			try{
				if(ALOCConstants.SELWINNER_FROMREQUEST.equalsIgnoreCase(selBidWinnerType))  {
					validateRequest();
				}
				if(bidReplyId != null) {
					String swiftData = null;
					RequestDetails reqDetails = saveFormatSwiftData();
					swiftData = (reqDetails!= null) ? reqDetails.getSwiftFormatDoc():null;
					requestDetails = requestDetailsManager.selectWinnerForBidAward(actionType,requestId,bidReplyId.toBigInteger(),transmissionPlatform,wfid,stageName,queueName,procedureName,workFlowstageId,selBidWinnerType,sitePrefix,swiftData);
				}
			}
			catch(HWFServiceException hse){	
				ErrorData errorData = errorHandler.handle(hse);
				this.errorMsg = errorData.getCause().getMessage();	
				if(ALOCConstants.SELWINNER_FROMREQUEST.equalsIgnoreCase(selBidWinnerType)){
					return openActiveRequest();}
				else {
					return SUCCESS;}
			}
				resultPage = SUCCESS;
				session.setAttribute(ALOCConstants.SUCCESSMSG, requestDetails.getComments());
			    errorShow=false;
		}
		return resultPage;
	}

	/**
	 * This is used to open the Bid Award request upon clicking on the selected bank reply.
	 * @return
	 * @throws HWFServiceException
	 */
	public String openBidAwardRequest() throws HWFServiceException {
		String resultPage=null;
		if(requestId!=null && bidReplyId != null)
		{
			requestDetailsBO = requestDetailsManager.openBidAwardRequest(requestId,bidReplyId.toBigInteger());
			updateworkflowData(requestDetailsBO);
			setHoursMinutes((RequestDetails)requestDetailsBO.getModel());
			
			if(requestDetailsBO!=null && requestDetailsBO.getModel().getPreAgreedPricingDetails()!=null){
				if(requestDetailsBO.getModel().getPreAgreedPricingDetails().getAllInCommissionsValue()!=null){
					allInCommissionsValue = requestDetailsBO.getModel().getPreAgreedPricingDetails().getAllInCommissionsValue().toString();
				}
				if(requestDetailsBO.getModel().getPreAgreedPricingDetails().getLocalCommissionsValue()!=null){
					localCommissionsValue = requestDetailsBO.getModel().getPreAgreedPricingDetails().getLocalCommissionsValue().toString();
				}
			}
			resultPage= getRequestResultPage();
		}
		return resultPage;
	}

	/**
	 * This is used to open the Bid Reply request upon clicking on the selected bank reply.
	 * @return
	 * @throws HWFServiceException
	 */
	public String openBidReplyRequest() throws HWFServiceException {
		String resultPage=null;
		if(requestId!=null && bankBidId != null)
		{
			requestDetailsBO = requestDetailsManager.openBidReplyRequest(requestId,bankBidId.toBigInteger());
			updateworkflowData(requestDetailsBO);
			if(bankBidId!=null){
				requestDetailsBO.getModel().setBANKBIDID(bankBidId.toBigInteger());
				ALOCContext.setActiveRequest(requestDetailsBO);
			}
			if(StringUtils.isNotBlank(bidFlag))	{
				if(bidFlag.equals(ALOCConstants.Y_CAP))
					requestDetailsBO.getModel().setBidOrOptFlag(ALOCConstants.BID_REPLY_FLAG);
				else if(bidFlag.equals(ALOCConstants.N_CAP))
					requestDetailsBO.getModel().setBidOrOptFlag(ALOCConstants.BIDREPLY_OPTOUT);
			}
			if((instrumentId != null && instrumentId == InstrumentType.SURETY_BOND.getId()) && WorkflowStage.TREASURYBIDREPLY.getName().equals(stageName)){
				requestDetailsBO = requestDetailsManager.getActiveSuretyMasterList(requestDetailsBO);
				setBidReplyCalendarDetails((RequestDetails)requestDetailsBO.getModel());
				setCalendarDetails((RequestDetails)requestDetailsBO.getModel());
			}
			if((instrumentId != null && (instrumentId == InstrumentType.BANK_GUARANTEE.getId() || instrumentId == InstrumentType.LOC.getId() || instrumentId == InstrumentType.DOCUMENT_LOC.getId())) && WorkflowStage.TREASURYBIDREPLY.getName().equals(stageName)){
				Calendar toDayDate = Calendar.getInstance();
				if(requestDetailsBO.getModel().getBidReplyDetails() != null)
					requestDetailsBO.getModel().getBidReplyDetails().setTodayDate(toDayDate);
				setCalendarDetails((RequestDetails)requestDetailsBO.getModel());
				bankLookupName = changeBankLookupName(bankName);
				bankCountry = (bankCountryName != null && !bankCountryName.isEmpty()) ? bankCountryName :ALOCConstants.EMPTY_STRING;
				bankCountryCd = getCountryCode(bankCountry);
				setBidReplyCalendarDetails((RequestDetails)requestDetailsBO.getModel());
				
				if(requestDetailsBO!=null && requestDetailsBO.getModel().getPreAgreedPricingDetails()!=null){
					if(requestDetailsBO.getModel().getPreAgreedPricingDetails().getAllInCommissionsValue()!=null){
						allInCommissionsValue = requestDetailsBO.getModel().getPreAgreedPricingDetails().getAllInCommissionsValue().toString();
					}
					if(requestDetailsBO.getModel().getPreAgreedPricingDetails().getLocalCommissionsValue()!=null){
						localCommissionsValue = requestDetailsBO.getModel().getPreAgreedPricingDetails().getLocalCommissionsValue().toString();
					}
					setPricingDetails(requestDetailsBO);
				}
				
				if(requestDetailsBO != null && requestDetailsBO.getModel().getConfirmationFees() != null && requestDetailsBO.getModel().getConfirmationFees().getFeeStructureValue() != null)  {
					feeStructureValue = requestDetailsBO.getModel().getConfirmationFees().getFeeStructureValue().toString();
				}
			}
			resultPage= getRequestResultPage();
		}
		return resultPage;
	}
	
	/**
	 * This method is used to get the Country Code based on the CountryName
	 * @param countryName
	 * @return countryCode
	 */
	public String getCountryCode(String countryName) {
		String countryCode = ALOCConstants.EMPTY_STRING;
		List<Country> MDMCountries = ALOCContext.getMasterDataFactory().getCountries();
		if(MDMCountries !=null && !MDMCountries.isEmpty() && StringUtils.isNotBlank(countryName)){
			for(Country mdmCountriesLst : MDMCountries){
				if(StringUtils.isNotBlank(mdmCountriesLst.getCountryName()) && mdmCountriesLst.getCountryName().equalsIgnoreCase(countryName)){
					return mdmCountriesLst.getCountryCode();
				}
			}
		}
		return countryCode;
	}
	
	/**
	 * Method to set the pricing details from preAgreed pricing details
	 * @param requestDetailsBO
	 */
	private void setPricingDetails(RequestDetailsBO requestDetailsBO) {
		PricingDetails pricingDetails = new PricingDetails();
		pricingDetails.setAllInAmmendmentTransactionFee(requestDetailsBO.getModel().getPreAgreedPricingDetails().getAllInAmmendmentTransactionFee());
		pricingDetails.setAllInCommissionsId(requestDetailsBO.getModel().getPreAgreedPricingDetails().getAllInCommissionsId());
		pricingDetails.setAllInCommissionsName(requestDetailsBO.getModel().getPreAgreedPricingDetails().getAllInCommissionsName());
		pricingDetails.setLocalAmmendmentTransactionFee(requestDetailsBO.getModel().getPreAgreedPricingDetails().getLocalAmmendmentTransactionFee());
		pricingDetails.setLocalCommissionsId(requestDetailsBO.getModel().getPreAgreedPricingDetails().getLocalCommissionsId());
		pricingDetails.setLocalCommissionsName(requestDetailsBO.getModel().getPreAgreedPricingDetails().getLocalCommissionsName());
		if(requestDetailsBO.getModel().getPreAgreedPricingDetails().getOneTimeFeesDetails() != null) {
			int zero = ALOCConstants.BASE_VALUE;
			OneTimeFeesDetails oneTimeFeesDetails = new OneTimeFeesDetails(); 
			oneTimeFeesDetails.setAcceptPricingDetailsFlag(requestDetailsBO.getModel().getPreAgreedPricingDetails().getOneTimeFeesDetails().getAcceptPricingDetailsFlag());
			if(requestDetailsBO.getModel().getPreAgreedPricingDetails().getOneTimeFeesDetails().getIncidentalAdminFee() != null &&
					requestDetailsBO.getModel().getPreAgreedPricingDetails().getOneTimeFeesDetails().getIncidentalAdminFee().compareTo(new BigDecimal(ALOCConstants.BASE_VALUE)) == zero){
				oneTimeFeesDetails.setIncidentalAdminFee(null);
			}else{
				oneTimeFeesDetails.setIncidentalAdminFee(requestDetailsBO.getModel().getPreAgreedPricingDetails().getOneTimeFeesDetails().getIncidentalAdminFee());
			}
			if(requestDetailsBO.getModel().getPreAgreedPricingDetails().getOneTimeFeesDetails().getOther() != null &&
					requestDetailsBO.getModel().getPreAgreedPricingDetails().getOneTimeFeesDetails().getOther().compareTo(new BigDecimal(ALOCConstants.BASE_VALUE)) == zero){
				oneTimeFeesDetails.setOther(null);
			}else{
				oneTimeFeesDetails.setOther(requestDetailsBO.getModel().getPreAgreedPricingDetails().getOneTimeFeesDetails().getOther());
			}
			if(requestDetailsBO.getModel().getPreAgreedPricingDetails().getOneTimeFeesDetails().getStampTaxes() != null &&
					requestDetailsBO.getModel().getPreAgreedPricingDetails().getOneTimeFeesDetails().getStampTaxes().compareTo(new BigDecimal(ALOCConstants.BASE_VALUE)) == zero){
				oneTimeFeesDetails.setStampTaxes(null);
			}else{
				oneTimeFeesDetails.setStampTaxes(requestDetailsBO.getModel().getPreAgreedPricingDetails().getOneTimeFeesDetails().getStampTaxes());
			}
			if(requestDetailsBO.getModel().getPreAgreedPricingDetails().getOneTimeFeesDetails().getVATTaxes() != null &&
					requestDetailsBO.getModel().getPreAgreedPricingDetails().getOneTimeFeesDetails().getVATTaxes().compareTo(new BigDecimal(ALOCConstants.BASE_VALUE)) == zero){
				oneTimeFeesDetails.setVATTaxes(null);
			}else{
				oneTimeFeesDetails.setVATTaxes(requestDetailsBO.getModel().getPreAgreedPricingDetails().getOneTimeFeesDetails().getVATTaxes());
			}
			oneTimeFeesDetails.setReasonForRejection(requestDetailsBO.getModel().getPreAgreedPricingDetails().getOneTimeFeesDetails().getReasonForRejection());
			pricingDetails.setOneTimeFeesDetails(oneTimeFeesDetails);
		}
		requestDetailsBO.getModel().setPricingDetails(pricingDetails);
	}

	/**
	 * This method decides the page to display on validation error conditions
	 */
	public String getInputResultName() {
		if(requestId != null || amendmentOrRiderRequestId!=null){
			try {
				validateRequest();
			} catch (HWFServiceException e) {
				throw new ALOCRuntimeException(ALOCRuntimeException.EC_ACTIVEREQUEST_NOTFOUND);
			}
		}
		if(isRequestForValidateTreasuryAnalyst()|| isRequestForValidateAward() || isRequestFOrValidateAttachment()){
			errorShow=true;			
			return getRequestResultPage();
		}
		else{
			return super.getInputResultName();
		}
	}

	/**
	 * Create PDF file and sends it to download
	 * 
	 * @return
	 * @throws ALOCException
	 * @throws IOException 
	 * @throws HWFServiceStubException 
	 * @throws HWFServiceException 
	 */
	public String downloadPDFFile() throws HWFServiceStubException,
	ALOCException, HWFServiceException, IOException {
		RequestDetails requestDetails = ALOCContext.getActiveRequest().getModel();
		downloadDocs = getDownloadDocs();
		if (downloadDocs != null
				&& downloadDocs.size() == ALOCConstants.NUM_ONE) {
			downloadOneDocument(requestDetails);
		} else if (downloadDocs != null
				&& downloadDocs.size() > ALOCConstants.NUM_ONE) {
			downloadMultipleDocuments(requestDetails);
		}
		if (LOGGER.isInfoEnabled()) {
			String msg = new StringBuilder().append(EXPORTING_PDF_FOR_REQUEST)
					.append(requestDetails.getAlocRecordId()).toString();
			LOGGER.info(msg);
		}

		if (LOGGER.isInfoEnabled()) {
			String msg = new StringBuilder()
			.append(SUCCESSFULLY_EXPORTED_THE_PDF_FOR_REQUEST)
			.append(requestDetails.getAlocRecordId()).toString();
			LOGGER.info(msg);
		}

		return null;
	}

	/**
	 * downloadOneDocument from the issuer screen
	 * @param requestDetails
	 * @throws HWFServiceException
	 * @throws ALOCException
	 */
	private void downloadOneDocument(RequestDetails requestDetails) throws HWFServiceException, ALOCException {

		for (String reportName : downloadDocs) {
			DownloadDocName downloadDocName = DownloadDocName.fromName(reportName);
			if (downloadDocName != null) {
				PDFReportGenerator reportGenerator = PDFReportGeneratorFactory.INSTANCE
						.getReportGenerator(ReportType.REQUEST);
				switch (downloadDocName) {
				case APPLICATION:
				case BIDMEMOBIDREPLY:
				case TAXONOMY:
					reportGenerator.init(reportName);
					reportGenerator.generate();
					break;
				case ATTACHMENT:
					downloadAllAttachmentsAsZip();
					break;
				case TREASURYAPPROVER:
					reportGenerator.init(reportName);
					reportGenerator.generate();
					break;
				case FORMAT:
					downloadFormatData();
					break;
				case CSVAPPLICATION:
					ALOCCommonHelper alocHelper = new ALOCCommonHelper();
					try {
						if(requestDetails != null && requestDetails.getInstrumentTypeId().equals(BigInteger.valueOf(InstrumentType.SURETY_BOND.getId()))){
							alocHelper.downloadSBApplicationCSV(requestDetails,null);
						}else{
							alocHelper.downloadRiderApplicationCSV(requestDetails,null);
						}
					} catch (IOException e) {
						String errMsg = new StringBuilder().append(ALOCConstants.ERROR_DOWNLOADING_FILE)
								.append(ALOCConstants.AS_CSV).toString();
						LOGGER.error(errMsg, e);
						throw new ALOCReportException(errMsg, e);
					}
					break;
				}
			}

		}

	}

	/**
	 * downloadMultipleDocuments is used to download multiple documents as zip format
	 * @param requestDetails
	 * @throws HWFServiceException
	 * @throws IOException
	 * @throws ALOCAttachmentException
	 * @throws ALOCException
	 */
	@SuppressWarnings("unchecked")
	private void downloadMultipleDocuments(RequestDetails requestDetails) throws HWFServiceException, IOException, ALOCAttachmentException, ALOCException {		
		HttpServletResponse response = ServletActionContext.getResponse();
		String fileName = new StringBuilder().append(ALOCConstants.ALOC_UNDERSCORE)
				.append(getRequestDetails().getAlocRecordId())
				.append(ALOCConstants.DOCS_ZIP).toString();
		response.setContentType(ServletActionContext.getServletContext()
				.getMimeType(fileName));
		response.addHeader(ALOCConstants.HEADER_CONTENT_DISPOSITION,
				ALOCConstants.CONTENT_DISPOSITION_VALUE + fileName);
		PDFReportGenerator reportGenerator = PDFReportGeneratorFactory.INSTANCE
				.getReportGenerator(ReportType.REQUEST);
		OutputStream outStream = null;
		outStream = response.getOutputStream();
		ZipOutputStream zOutputStream = new ZipOutputStream(new BufferedOutputStream(outStream));
		try {
			for (String reportName : downloadDocs) {
				DownloadDocName downloadDocName = DownloadDocName.fromName(reportName);				
				String addedFileName = getDownloadFileName(requestDetails,downloadDocName,reportName);
				if(!downloadDocName.equals(DownloadDocName.ATTACHMENT)) {
					ZipEntry zipEntry = null;
					zipEntry = new ZipEntry(addedFileName);
					zOutputStream.putNextEntry(zipEntry);						
				}
				ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
				if (downloadDocName != null) {
					switch (downloadDocName) {
					case APPLICATION:
					case BIDMEMOBIDREPLY:
						reportGenerator.init(reportName);
						byteOutputStream = (ByteArrayOutputStream) reportGenerator.addMultiplePDFfilesToZip(byteOutputStream);
						byteOutputStream.writeTo(zOutputStream);
						zOutputStream.closeEntry();
						break;
					case ATTACHMENT:
						List<Attachment> atmtsList = (List<Attachment>)ActionContext.getContext().getSession().get(requestDetails.getRequestId()+ALOCConstants.UNDERSCORE+ALOCConstants.ATTACHMENTS_BY_TYPE);
						if(atmtsList == null || atmtsList.size() == ALOCConstants.BASE_VALUE){
							atmtsList = (List<Attachment>)ActionContext.getContext().getSession().get(requestDetails.getRequestId()+ALOCConstants.UNDERSCORE+ALOCConstants.TAXONOMY_ATTACHMENTS);
						}
						if(atmtsList == null){
							atmtsList = new ArrayList<Attachment>();
						}
						alocAttachmentManager.downloadAllAttachmentsToZip(zOutputStream,atmtsList); 							
						break;
					case TREASURYAPPROVER:
						reportGenerator.init(reportName);
						byteOutputStream = (ByteArrayOutputStream) reportGenerator.addMultiplePDFfilesToZip(byteOutputStream);
						byteOutputStream.writeTo(zOutputStream);
						zOutputStream.closeEntry();
						break;
					case FORMAT:
						Attachment atmt  = (requestDetails != null &&!requestDetails.getFormat().getAttachments().isEmpty()) ? requestDetails.getFormat().getAttachments().get(ALOCConstants.BASE_VALUE) : new Attachment();
						if(Integer.valueOf(requestDetails.getFormat().getFormatTypeId()).intValue()== FormatType.STANDARD.getId()
								|| Integer.valueOf(requestDetails.getFormat().getFormatTypeId()).intValue() == FormatType.MODIFIED.getId()){				
							boolean formatDoc = false;
							if(StringUtils.isNotBlank(requestDetails.getSwiftFormatDoc())){
								formatDoc = true;
							}else{
								alocAttachmentManager.downloadAttachment(byteOutputStream,atmt);	
							}
							String formatSwiftDoc = ALOCConstants.EMPTY_STRING;
							if(atmt != null || formatDoc == true){
								if(formatDoc == true){
									formatSwiftDoc = requestDetails.getSwiftFormatDoc();
								}else{
									formatSwiftDoc = byteOutputStream!= null?byteOutputStream.toString():ALOCConstants.EMPTY_STRING;
								}
							}
							String data = new BookmarksHelper(requestDetailsBO.getModel(), formatSwiftDoc).replaceTokens();											
							data = ALOCCommonHelper.getFormatTemplateDoc(data);
							byte buf[] = data.getBytes(); 
							zOutputStream.write(buf); 			
						}else{
							alocAttachmentManager.downloadAtmtData(zOutputStream,atmt);
						}
						zOutputStream.closeEntry();
						break;
					case CSVAPPLICATION:
						ALOCCommonHelper alocHelper = new ALOCCommonHelper();
						try {
							if(requestDetails != null && requestDetails.getInstrumentTypeId().equals(BigInteger.valueOf(InstrumentType.SURETY_BOND.getId()))){
								alocHelper.downloadSBApplicationCSV(requestDetails,zOutputStream);
							}else{
								alocHelper.downloadRiderApplicationCSV(requestDetails,zOutputStream);
							}
						} catch (IOException e) {
							String errMsg = new StringBuilder()
							.append(ALOCConstants.ERROR_WHILE_DOWNLOADING_THE_FILE).append(ALOCConstants.AS_ZIP).toString();
							LOGGER.error(errMsg, e);
							throw new ALOCReportException(errMsg, e);
						}
						zOutputStream.closeEntry();
						break;
					}
				}
			}
			zOutputStream.flush();
		} catch (IOException ioe) {
			String errMsg = new StringBuilder()
			.append(ALOCConstants.ERROR_WHILE_DOWNLOADING_THE_FILE)
			.append(ALOCConstants.AS_ZIP).toString();
			LOGGER.error(errMsg, ioe);
			throw new ALOCReportException(errMsg, ioe);
		} finally {

			try {
				if (zOutputStream != null) {
					zOutputStream.close();
				}
			} catch (IOException ioe) {
				String errMsg = new StringBuilder()
				.append(ALOCConstants.ERROR_WHILE_CLOSING_ZIPOUTPUT_STREAM)
				.append(fileName).toString();
				LOGGER.warn(errMsg, ioe);
			}
			zOutputStream = null;
		}
	
		
	}
	
	/**
	 * getDownloadFileName is used to fetch the added file name.
	 * @param requestDetails
	 * @param downloadDocName
	 * @param reportName
	 * @return
	 */
	private String  getDownloadFileName(RequestDetails requestDetails,DownloadDocName downloadDocName,String reportName) {
		StringBuilder addedFileName = null;
		if (downloadDocName != null) {
			switch (downloadDocName) {
			case ATTACHMENT:
				addedFileName = new StringBuilder()
				.append(requestDetails.getAlocRecordId())
				.append(ALOCConstants.UNDERSCORE).append(reportName).append(ALOCConstants.ZIP_EXTENSION);
				break;
			case FORMAT:
				if(Integer.valueOf(requestDetails.getFormat().getFormatTypeId()).intValue()== FormatType.STANDARD.getId()
				|| Integer.valueOf(requestDetails.getFormat().getFormatTypeId()).intValue() == FormatType.MODIFIED.getId()){
					if(Integer.valueOf(requestDetails.getFormat().getFormatTypeId()).intValue()== FormatType.STANDARD.getId() )
						addedFileName = new StringBuilder().append(ALOCConstants.ALOC_UNDERSCORE).append(requestDetailsBO.getModel().getAlocRecordId()).append(ALOCConstants.HYPEN).append(ALOCConstants.STANDARD_FORMATDOC);
					if(Integer.valueOf(requestDetails.getFormat().getFormatTypeId()).intValue()== FormatType.MODIFIED.getId())
						addedFileName = new StringBuilder().append(ALOCConstants.ALOC_UNDERSCORE).append(requestDetailsBO.getModel().getAlocRecordId()).append(ALOCConstants.HYPEN).append(ALOCConstants.MODIFIED_FORMATDOC);
				}else{
					addedFileName = new StringBuilder().append(ALOCContext.getActiveRequest().getModel().getFormat().getAttachments().get(ALOCConstants.BASE_VALUE).getAttachmentName());
				}
				break;
			case CSVAPPLICATION:
				if(requestDetails != null && requestDetails.getInstrumentTypeId().equals(BigInteger.valueOf(InstrumentType.SURETY_BOND.getId()))){
					addedFileName = new StringBuilder().append(requestDetails.getAlocRecordId())
							.append(ALOCConstants.HYPEN).append(ALOCConstants.SB_APPLICATION_CSV);
				}else{
					addedFileName = new StringBuilder().append(requestDetails.getAlocRecordId())
							.append(ALOCConstants.HYPEN).append(ALOCConstants.RIDER_APPLICATION_CSV);
				}
				break;
			default:
				addedFileName = new StringBuilder()
				.append(requestDetails.getAlocRecordId())
				.append(ALOCConstants.HYPEN).append(reportName).append(ALOCConstants.PDF_EXTENSION);
				break;
			}
		}
		return addedFileName.toString();
	}

	/**
	 * bank lookup name filtering based on Hyphen
	 * @param oldBankName
	 * @return
	 */
	private String changeBankLookupName(String oldBankName) {
		String newBankName = ALOCConstants.EMPTY_STRING;
		if(StringUtils.isNotBlank(oldBankName))
		{
			if(oldBankName.indexOf(ALOCConstants.BANKLOOKUP_HYPEN) > ALOCConstants.BASE_VALUE)
			{
				int endVal = oldBankName.indexOf(ALOCConstants.BANKLOOKUP_HYPEN);
				newBankName = oldBankName.substring(ALOCConstants.BASE_VALUE, endVal);
			}
			else
			{
				newBankName = oldBankName;
			}
		}
		return newBankName;
	}

	
	public String issuanceSave() throws HWFServiceException, ALOCException {
		String resultPage=null;		
		HttpServletRequest request = ServletActionContext.getRequest();
		errorShow=false;
		if(actionType!=null){
			validateRequest();
			RequestDetails requestDetails = null;
			
			RequestDetails reqDet = requestDetailsBO.getModel();
			String refNoStatus = null;
			BigInteger instrumentType = reqDet != null ? reqDet.getInstrumentTypeId() : null;
			//Need to Change for Amendment or Rider :- instrumentType.intValue() !=InstrumentType.AMENDMENT.getId() && instrumentType.intValue() != InstrumentType.RIDER.getId()
			if(instrumentType!= null){
				refNoStatus = checkBankRefNumber();
				if(refNoStatus != null && refNoStatus.equalsIgnoreCase(ALOCConstants.ISSUER_BANKREFNO_EXISTED)){
					addFieldError(ALOCConstants.ISSUER_ACTIONS_ERROR_FILED, ALOCConstants.ISSUER_BANKREFNO_ERROR_MSG) ;
					errorShow=true;
					return openActiveRequest();
				}
			}
			try{
				requestDetails = requestDetailsManager.issuanceSave(actionType);
			}catch(HWFServiceException hse){	
				ErrorData errorData = errorHandler.handle(hse);
				this.errorMsg = errorData.getCause().getMessage();				
				return openActiveRequest();
			}			
			request.setAttribute(ALOCConstants.SUCCESSMSG, requestDetails.getComments());
		}
		resultPage = openActiveRequest();
		return resultPage;
	}
	
	/**
	 * This method is used to verify is request to validate treasury analyst.
	 * @return
	 */
	protected boolean isRequestForValidateTreasuryAnalyst() {
		return ActionContext.getContext().getActionInvocation().getProxy().getMethod().equals(SUBMIT);
	}
	/**
	 * This method is used to verify is request to validate bid award.
	 * @return
	 */
	protected boolean isRequestForValidateAward() {
		return ActionContext.getContext().getActionInvocation().getProxy().getMethod().equals(ALOCConstants.AWARDSUBMIT);
	}
	/**
	 * This method is used to verify is request to validate bid award.
	 * @return
	 */
	protected boolean isRequestFOrValidateAttachment() {
		return ActionContext.getContext().getActionInvocation().getProxy().getMethod().equals(ALOCConstants.DOWNLAODPDF);
	}

	/* --------------------------------------------------------------------------------------------------------------------
	 * 															PROPERTY GETTER/SETTER METHODS
	 ---------------------------------------------------------------------------------------------------------------------- */

	/**
	 * This is used to get action id.
	 * @return the actionType
	 */
	public int getActionType() {
		return actionType.getId();
	}

	/**
	 * This is used to set action type based on action type id.
	 * @param actionType the actionType to set
	 */
	public void setActionType(int actionTypeId) {
		actionType = ActionType.fromId(actionTypeId);
	}

	/**
	 * This is used to get the current stage.
	 * @return the currentStage
	 */
	public String getCurrentStage() {
		return currentStage;
	}

	/**
	 * This is used to set the current stage.
	 * @param currentStage the currentStage to set
	 */
	public void setCurrentStage(String currentStage) {
		this.currentStage = currentStage;
	}


	/**
	 * This used to show the error.
	 * @return the errorShow
	 */
	public boolean isErrorShow() {
		return errorShow;
	}


	/**
	 * This used to set the error flag.
	 * @param errorShow the errorShow to set
	 */
	public void setErrorShow(boolean errorShow) {
		this.errorShow = errorShow;
	}

	/**
	 * This is used to get the download docs list.
	 * @return the downloadDocs
	 */
	public List<String> getDownloadDocs() {
		return downloadDocs;
	}

	/**
	 * This is used to set the download docs list.
	 * @param downloadDocs the downloadDocs to set
	 */
	public void setDownloadDocs(List<String> downloadDocs) {
		this.downloadDocs = downloadDocs;
	}

	/**
	 * This is used to get the workFlowstageId
	 * @return the workFlowstageId
	 */
	public String getWorkFlowstageId() {
		return workFlowstageId;
	}

	/**
	 * This is used to set the workFlowstageId
	 * @param workFlowstageId the workFlowstageId to set
	 */
	public void setWorkFlowstageId(String workFlowstageId) {
		this.workFlowstageId = workFlowstageId;
	}


	/**
	 * This is used to get the TransmissionPlatform
	 * @return the transmissionPlatform
	 */
	public String getTransmissionPlatform() {
		return transmissionPlatform;
	}

	/**
	 * This is used to set the TransmissionPlatform.
	 * @param transmissionPlatform the transmissionPlatform to set
	 */
	public void setTransmissionPlatform(String transmissionPlatform) {
		this.transmissionPlatform = transmissionPlatform;
	}


	/**
	 * This is used to get the returnReason.
	 * @return the returnReason
	 */
	public String getReturnReason() {
		return returnReason;
	}


	/**
	 * This is used to set the returnReason.
	 * @param returnReason the returnReason to set
	 */
	public void setReturnReason(String returnReason) {
		this.returnReason = returnReason;
	}


	/**
	 * This is used to get the optionsRadiosp value
	 * @return the optionsRadiosp
	 */
	public String getOptionsRadiosp() {
		return optionsRadiosp;
	}


	/**
	 * This is used to set the optionsRadiosp value
	 * @param optionsRadiosp the optionsRadiosp to set
	 */
	public void setOptionsRadiosp(String optionsRadiosp) {
		this.optionsRadiosp = optionsRadiosp;
	}


	/**
	 * This is used to get the issuerRadioOption value
	 * @return the issuerRadioOption
	 */
	public String getIssuerRadioOption() {
		return issuerRadioOption;
	}


	/**
	 * This is used to set the issuerRadioOption value
	 * @param issuerRadioOption the issuerRadioOption to set
	 */
	public void setIssuerRadioOption(String issuerRadioOption) {
		this.issuerRadioOption = issuerRadioOption;
	}

	/**
	 * This is used to get the errorHandler
	 * @return the errorHandler
	 */
	public IErrorHandler getErrorHandler() {
		return errorHandler;
	}

	/**
	 * This is used to set the errorHandler
	 * @param errorHandler the errorHandler to set
	 */
	public void setErrorHandler(IErrorHandler errorHandler) {
		this.errorHandler = errorHandler;
	}

	/**
	 * This is used to get the errorMsg
	 * @return the errorMsg
	 */
	public String getErrorMsg() {
		return errorMsg;
	}

	/**
	 * This is used to set the errorMsg
	 * @param errorMsg the errorMsg to set
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	/**
	 * This is used to get the selBidWinnerType
	 * @return the selBidWinnerType
	 */
	public String getSelBidWinnerType() {
		return selBidWinnerType;
	}

	/**
	 * This is used to set the selBidWinnerType
	 * @param selBidWinnerType the selBidWinnerType to set
	 */
	public void setSelBidWinnerType(String selBidWinnerType) {
		this.selBidWinnerType = selBidWinnerType;
	}
	
	/**
	 * This is used to get the SitePrefix value
	 * @return the sitePrefix
	 */
	public String getSitePrefix() {
		return sitePrefix;
	}

	/**
	 * This is used to set the SitePrefix value
	 * @param sitePrefix the sitePrefix to set
	 */
	public void setSitePrefix(String sitePrefix) {
		this.sitePrefix = sitePrefix;
	}
}
