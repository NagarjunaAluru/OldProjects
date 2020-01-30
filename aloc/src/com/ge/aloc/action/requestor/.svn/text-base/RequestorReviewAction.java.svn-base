/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: RequestorReviewAction.java
 * Purpose: RequestorReviewAction used for the request review operations
 */
package com.ge.aloc.action.requestor;

import static com.ge.aloc.constants.ALOCConstants.SUBMIT;
import static com.ge.aloc.constants.ALOCConstants.Y;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.ge.aloc.ALOCContext;
import com.ge.aloc.ActionType;
import com.ge.aloc.AtmtPermType;
import com.ge.aloc.FormatType;
import com.ge.aloc.InstrumentType;
import com.ge.aloc.OpCode;
import com.ge.aloc.action.request.RequestDetailsSupportAction;
import com.ge.aloc.bo.AttachmentBO;
import com.ge.aloc.bo.FormatBO;
import com.ge.aloc.bo.RequestDetailsBO;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.exception.ALOCAttachmentException;
import com.ge.aloc.exception.ALOCException;
import com.ge.aloc.exception.ALOCRuntimeException;
import com.ge.aloc.model.Attachment;
import com.ge.aloc.model.AttachmentPermission;
import com.ge.aloc.model.RequestDetails;
import com.hydus.hwf.exceptions.ErrorData;
import com.hydus.hwf.exceptions.HWFServiceException;
import com.hydus.hwf.exceptions.IErrorHandler;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author chaitanya.n
 *
 */
public class RequestorReviewAction extends RequestDetailsSupportAction {

	private static final long serialVersionUID = -2907166054913006064L;
	/**
	 * LOGGER
	 */
	private static final Logger LOGGER = Logger.getLogger(RequestorReviewAction.class);
	private ActionType actionType;
	protected IErrorHandler errorHandler;	
	private String errorMsg;

	/**
	 * method to submit the Request
	 * @return
	 */
	@Override
	public String submit() throws HWFServiceException {
		String resultPage=null;
		HttpSession session = ServletActionContext.getRequest().getSession();
		RequestDetails requestDetails = null;
		if(requestId != null){
			validateRequest();
		}
		try{
			switch(actionType) {
			case SAVE:
				saveStandardFormatDetails();			
				requestDetails = requestDetailsManager.saveandSubmit(actionType);
				resultPage=ALOCConstants.SUCCESSDRAFT;
				break;
			case SAVE_AS_MODEL:
				saveStandardFormatDetails();
				requestDetails = requestDetailsManager.saveandSubmit(actionType);
				resultPage=ALOCConstants.SUCCESSMODEL;
				break;
			case SUBMIT:
				saveStandardFormatDetails();
				requestDetails = requestDetailsManager.saveandSubmit(actionType);
				resultPage=SUCCESS;
				break;
			case RE_SUBMIT:	
				saveStandardFormatDetails();
				requestDetails = requestDetailsManager.saveandSubmit(actionType);
				resultPage=SUCCESS;
				break;
			}
			session.setAttribute(ALOCConstants.SUCCESSMSG, requestDetails.getComments());
		}catch(HWFServiceException hse){	
			ErrorData errorData = errorHandler.handle(hse);
			this.errorMsg = errorData.getCause().getMessage();				
			return openActiveRequest();
		}
		return resultPage;
	}

	/**
	 * method to submit the Amendment Request
	 * @return
	 * @throws HWFServiceException
	 */
	public String submitAmendment() throws HWFServiceException {
		String resultPage = null;
		HttpSession session = ServletActionContext.getRequest().getSession();
		RequestDetails requestDetails = null;
		if(amendmentOrRiderRequestId != null){
			validateRequest();
		}
		try {
			switch (actionType) {
			case SAVE:
				requestDetails = requestDetailsManager.submitAmendment(actionType);
				resultPage = SUCCESS;
				break;
			case SUBMIT:
				requestDetails = requestDetailsManager.submitAmendment(actionType);
				resultPage = SUCCESS;
				break;
			case RE_SUBMIT:
				requestDetails = requestDetailsManager.submitAmendment(actionType);
				resultPage = SUCCESS;
				break;
			case DELETE_AMENDMENT:
				requestDetails = requestDetailsManager.submitAmendment(actionType);
				resultPage = SUCCESS;
				break;
			}
			session.setAttribute(ALOCConstants.SUCCESSMSG, requestDetails.getComments());
		} catch (HWFServiceException hse) {
			ErrorData errorData = errorHandler.handle(hse);
			this.errorMsg = errorData.getCause().getMessage();
			return openActiveRequest();
		}
		return resultPage;
	}

	/**
	 * method to submit the Rider Request
	 * @return
	 * @throws HWFServiceException
	 */
	public String submitRider() throws HWFServiceException {
		String resultPage=null;
		HttpSession session = ServletActionContext.getRequest().getSession();
		RequestDetails requestDetails = null;
		if(amendmentOrRiderRequestId != null){
			validateRequest();
		}
		switch(actionType) {
		case SAVE:
			requestDetails = requestDetailsManager.submitRider(actionType);
			resultPage=SUCCESS;
			break;
		case SUBMIT:
			requestDetails = requestDetailsManager.submitRider(actionType);
			resultPage=SUCCESS;
			break;
		case RE_SUBMIT:
			requestDetails = requestDetailsManager.submitRider(actionType);
			resultPage=SUCCESS;
			break;
		}
		session.setAttribute(ALOCConstants.SUCCESSMSG, requestDetails.getComments());
		return resultPage;
	}

	/**
	 * method used to return the required page 
	 * @return
	 */
	public String getResultPage(){
		return SUCCESS;
	}

	/**
	 * This method is used to open the Resubmit request
	 * @return
	 */
	public String openResubmitRequest() throws HWFServiceException {
		RequestDetails requestDetails= getRequestDetails();

		if(StringUtils.isNotBlank(requestDetails.getSendbackbyBuApprover()) && requestDetails.getSendbackbyBuApprover().equals(Y)){
			editMode = true;
		}else if(StringUtils.isNotBlank(requestDetails.getWFDetails().getWFStage()) && requestDetails.getWFDetails().getWFStage().equalsIgnoreCase(ALOCConstants.BUSAPROV)){
			editMode = true;
		}else {
			InstrumentType instrumentType = InstrumentType.fromId(requestDetails.getInstrumentTypeId().intValue());
			
			if(InstrumentType.AMENDMENT.equals(instrumentType) || InstrumentType.RIDER.equals(instrumentType)){
				editMode = true;
			}
		}
		return getRequestResultPage();
	}

	/**
	 * This method decides the page to display on validation error conditions
	 */
	@Override
	public String getInputResultName() {
		if(requestId != null || amendmentOrRiderRequestId!=null){
			try {
				validateRequest();
			} catch (HWFServiceException e) {
				throw new ALOCRuntimeException(ALOCRuntimeException.EC_ACTIVEREQUEST_NOTFOUND);
			}
		}
		validationSuccess = false;
		RequestDetails requestDetails= getRequestDetails();
		if(StringUtils.isNotBlank(requestDetails.getSendbackbyBuApprover()) && requestDetails.getSendbackbyBuApprover().equals(Y)){
			editMode = true;
		}else if(StringUtils.isNotBlank(requestDetails.getWFDetails().getWFStage()) && requestDetails.getWFDetails().getWFStage().equalsIgnoreCase(ALOCConstants.BUSAPROV)){
			editMode = true;
		}else {
			InstrumentType instrumentType = InstrumentType.fromId(requestDetails.getInstrumentTypeId().intValue());
			
			if(InstrumentType.AMENDMENT.equals(instrumentType) || InstrumentType.RIDER.equals(instrumentType)){
				editMode = true;
			}
		}
		String invokedMethod = ActionContext.getContext().getActionInvocation().getProxy().getMethod();	
		if(invokedMethod.equals(SUBMIT)){
			return getRequestResultPage();
		}else{
			return super.getInputResultName();
		}
		
	}


	@SuppressWarnings("unused")
	private void saveStandardFormatDetails(){		
		RequestDetailsBO requestDetailsBO = ALOCContext.getActiveRequest();
		FormatBO formatBO = requestDetailsBO.getFormatBO();
		if(formatBO!= null && formatBO.getFormatType() != null && !formatBO.getAttachmentBOList().isEmpty()){
			FormatType formatType = formatBO.getFormatType();
			List<AttachmentBO> formatAttachmentBOList =  formatBO.getAttachmentBOList();
			AttachmentBO formatAttachmentBO = (!formatAttachmentBOList.isEmpty()) ? formatAttachmentBOList.get(ALOCConstants.BASE_VALUE) : null;
			Attachment atmt = null;
			try{
				if((formatAttachmentBO != null && formatAttachmentBO.getModel().getGeFileId() != null) && (formatType.getId() != FormatType.NON_STANDARD.getId())) {
					formatAttachmentBO.getModel().getAttachmentPermissions().clear();
					try{
						alocAttachmentManager.delete(formatAttachmentBO.getModel());
					}catch(ALOCAttachmentException ae){
						LOGGER.error(ae.getMessage(),ae);
					}
				}		
				String actionType = (formatAttachmentBO.getModel().getActionType() == null && (formatAttachmentBO.getModel().getGeFileId() == null)) ? OpCode.UPDATE.getOperationCode() : OpCode.DELETE.getOperationCode();
				if(formatAttachmentBO == null) {
					formatAttachmentBO = new AttachmentBO(); 
					formatAttachmentBOList.add(formatAttachmentBO);
				}
				if(FormatType.STANDARD.equals(formatType)){
					if(actionType.equals(ALOCConstants.DELETE)){
						formatAttachmentBO.getModel().setActionType(OpCode.DELETE.getOperationCode());
						formatAttachmentBO.getModel().setOpCode(OpCode.DELETE.getOperationCode());
						requestDetailsBO.getModel().setSwiftFormatDoc(standardFormat);
					}
					else{
						formatAttachmentBO.getModel().setActionType(OpCode.UPDATE.getOperationCode());
						formatAttachmentBO.getModel().setOpCode(OpCode.UPDATE.getOperationCode());
						requestDetailsBO.getModel().setSwiftFormatDoc(standardFormat);
					}
					standardFormat=null; 
				} else if(FormatType.MODIFIED.equals(formatType)){
					if(actionType.equals(ALOCConstants.DELETE)){
						formatAttachmentBO.getModel().setActionType(OpCode.DELETE.getOperationCode());
						formatAttachmentBO.getModel().setOpCode(OpCode.DELETE.getOperationCode());
						requestDetailsBO.getModel().setSwiftFormatDoc(modifiedStandardFormat);
					}else{
						formatAttachmentBO.getModel().setActionType(OpCode.UPDATE.getOperationCode());
						formatAttachmentBO.getModel().setOpCode(OpCode.UPDATE.getOperationCode());
						requestDetailsBO.getModel().setSwiftFormatDoc(modifiedStandardFormat);
					 }
					modifiedStandardFormat= null;
				}else if(FormatType.NON_STANDARD.equals(formatType)){
					BigInteger instrumentType = requestDetailsBO.getModel().getInstrumentTypeId();
					if(formatAttachmentBO.getModel().getGeFileId() != null){
						List<AttachmentPermission> atmtPermissions = new ArrayList<AttachmentPermission>();
						AttachmentPermission treasury = new AttachmentPermission();
						treasury.setPermissionId(AtmtPermType.TREASURY.getId());
						treasury.setPermissionName(AtmtPermType.TREASURY.name());
						atmtPermissions.add(treasury);
						if(instrumentType != null && (instrumentType.equals(BigInteger.valueOf(InstrumentType.SURETY_BOND.getId())) || instrumentType.equals(BigInteger.valueOf(InstrumentType.RIDER.getId())))){
							AttachmentPermission broker = new AttachmentPermission();
							broker.setPermissionId(AtmtPermType.Surety.getId());
							broker.setPermissionName(AtmtPermType.Surety.name());
							atmtPermissions.add(broker);
						}else{
							AttachmentPermission bank = new AttachmentPermission();
							bank.setPermissionId(AtmtPermType.BANK.getId());
							bank.setPermissionName(AtmtPermType.BANK.name());
							atmtPermissions.add(bank);
						}
						formatAttachmentBO.getModel().setAttachmentPermissions(atmtPermissions);
					}
					requestDetailsBO.getModel().setSwiftFormatDoc(null);
				}
				requestDetailsBO.getModel().getFormat().setFormatValue(null);	

			} catch (ALOCException e) {
				LOGGER.error(e.getMessage(),e);
			}
		}
	}

	/* -------------------------------------------------------------------------------------------------------------------------------------------------------
	 * 															PROPERTY GETTER/SETTER METHODS
	 ------------------------------------------------------------------------------------------------------------------------------------------------------- */

	/**
	 * This method is used to get the actionType.
	 * @return the actionType
	 */
	public int getActionType() {
		return actionType.getId();
	}

	/**
	 * This method is used to set the actionType.
	 * @param actionType 
	 */
	public void setActionType(int actionTypeId) {
		actionType = ActionType.fromId(actionTypeId);
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
}
