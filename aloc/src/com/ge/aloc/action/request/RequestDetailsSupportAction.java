/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: RequestDetailsSupportAction.java
 * Purpose: RequestDetailsSupportAction used for the all request operations
 */
package com.ge.aloc.action.request;

import static com.ge.aloc.constants.ALOCConstants.AMENDMENT_REQUEST_PAGE;
import static com.ge.aloc.constants.ALOCConstants.AMENDMENT_SECTION_PAGE;
import static com.ge.aloc.constants.ALOCConstants.APPLY_SECTION;
import static com.ge.aloc.constants.ALOCConstants.AUTO_AMENDMENT_REQUEST_PAGE;
import static com.ge.aloc.constants.ALOCConstants.BANKGUARANTEE;
import static com.ge.aloc.constants.ALOCConstants.BANKGUARANTEE_MODEL_REQUEST_PAGE;
import static com.ge.aloc.constants.ALOCConstants.BANKGUARANTEE_REQUEST_PAGE;
import static com.ge.aloc.constants.ALOCConstants.BANKGUARANTEE_SECTION_PAGE;
import static com.ge.aloc.constants.ALOCConstants.DOCLOC_SECTION_PAGE;
import static com.ge.aloc.constants.ALOCConstants.DOCUMENTARY_LETTER_OF_CREDIT_CONFIRMATION;
import static com.ge.aloc.constants.ALOCConstants.DOCUMENT_LOC_REQUEST_PAGE;
import static com.ge.aloc.constants.ALOCConstants.LOC_MODEL_REQUEST_PAGE;
import static com.ge.aloc.constants.ALOCConstants.LOC_REQUEST_PAGE;
import static com.ge.aloc.constants.ALOCConstants.MODEL_REQUEST_ID;
import static com.ge.aloc.constants.ALOCConstants.RIDER_REQUEST_PAGE;
import static com.ge.aloc.constants.ALOCConstants.RIDER_SECTION_PAGE;
import static com.ge.aloc.constants.ALOCConstants.SAVECURRBANKFEES;
import static com.ge.aloc.constants.ALOCConstants.STANDBY_LETTER_OF_CREDIT;
import static com.ge.aloc.constants.ALOCConstants.SURETYBOND_MODEL_REQUEST_PAGE;
import static com.ge.aloc.constants.ALOCConstants.SURETYBOND_REQUEST_PAGE;
import static com.ge.aloc.constants.ALOCConstants.SURETYBOND_SECTION_PAGE;
import static com.ge.aloc.constants.ALOCConstants.SURETY_BOND;
import static com.ge.aloc.constants.ALOCConstants.UPDATETAXONOMY;
import static com.ge.aloc.constants.ALOCConstants.UPDATE_REPORTING_DATA;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.ge.aloc.ALOCContext;
import com.ge.aloc.ActionType;
import com.ge.aloc.AtmtPermType;
import com.ge.aloc.AttachmentType;
import com.ge.aloc.DashboardViewType;
import com.ge.aloc.FormatType;
import com.ge.aloc.IRequestDetailsBOAware;
import com.ge.aloc.InstrumentType;
import com.ge.aloc.OpCode;
import com.ge.aloc.UserRole;
import com.ge.aloc.WorkflowStage;
import com.ge.aloc.bo.AttachmentBO;
import com.ge.aloc.bo.RequestDetailsBO;
import com.ge.aloc.common.util.AttachmentUtils;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.exception.ALOCAttachmentException;
import com.ge.aloc.exception.ALOCException;
import com.ge.aloc.exception.ALOCRuntimeException;
import com.ge.aloc.manager.IALOCAttachmentManager;
import com.ge.aloc.manager.ICreateBundleManager;
import com.ge.aloc.manager.ILinkTransactionManager;
import com.ge.aloc.manager.IRequestDetailsManager;
import com.ge.aloc.manager.IRequestDetailsSectionManager;
import com.ge.aloc.model.ActionDrawDownValues;
import com.ge.aloc.model.AmendmentDetails;
import com.ge.aloc.model.Attachment;
import com.ge.aloc.model.AttachmentPermission;
import com.ge.aloc.model.AuditLog;
import com.ge.aloc.model.CurrentBankFees;
import com.ge.aloc.model.DrawDownValues;
import com.ge.aloc.model.FeeHistoryDetails;
import com.ge.aloc.model.FullSummary;
import com.ge.aloc.model.GetAmendmentRiders;
import com.ge.aloc.model.IssunaceDocType;
import com.ge.aloc.model.NameValue;
import com.ge.aloc.model.ReferenceNumberValidation;
import com.ge.aloc.model.RequestDetails;
import com.ge.aloc.model.RiderDetails;
import com.ge.aloc.model.UpdateReporting;
import com.ge.aloc.util.ALOCCommonHelper;
import com.ge.aloc.util.BookmarksHelper;
import com.ge.aloc.view.section.RequestSectionId;
import com.hydus.hwf.context.UserContext;
import com.hydus.hwf.exceptions.HWFServiceException;
import com.hydus.hwf.exceptions.HWFServiceStubException;
import com.hydus.hwf.util.StringUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.ValidationWorkflowAware;

/**
 * @author chaitanya.n
 */
public abstract class RequestDetailsSupportAction extends ActionSupport implements IRequestDetailsBOAware, ValidationWorkflowAware {

	private static final long serialVersionUID = 7589192723575178405L;

	/**
	 * LOGGER
	 */
	private static final Logger LOGGER = Logger.getLogger(RequestDetailsSupportAction.class);

	protected RequestDetailsBO requestDetailsBO;
	protected BigInteger requestId;
	protected String amendmentOrRiderRequestId;
	protected RequestSectionId sectionId;
	protected boolean editMode;	
	protected List<NameValue> editSectionList;
	protected String bankCountryName;	
	protected String bankName;
	protected String bankSelection;

	protected String goldId;
	protected String goldIdSelection;

	protected String personName;
	protected String personNameSelection;

	protected String nameForAddressTPApplicant;
	protected String tpApplicantAddressSelection;

	protected String nameForAddressTriparty;
	protected String triPartyAddressSelection;

	protected String nameForAddressTPCustomer;
	protected String tpCustomerAddressSelection;

	protected String principalGoldId;
	protected String principalGoldIdSelection;

	protected String nameForAddressPrincipal;
	protected String principlaAddressSelection;

	protected String nameForObligeeAddress;
	protected String obligeeAddressSelection;

	protected String bondReqName;
	protected String bondReqNameSelection;

	protected String issuingBankName;
	protected String issuingBankSelection;

	protected String nameForApplicantAddress;
	protected String applicantSelection;

	protected String beneficiaryGoldId;
	protected String beneficiaryGoldIdSelection;

	protected String nameForBeneficiaryAddress;
	protected String beneficiaryAddressSelection;

	protected String businessContactPerson;
	protected String businessContactPersonSelection;

	protected String geRecipient;
	protected String recipientSelection;

	protected IRequestDetailsManager requestDetailsManager;
	protected IRequestDetailsSectionManager requestDetailsSectionManager;

	protected IALOCAttachmentManager alocAttachmentManager;
	protected String standardFormat;	
	protected String modifiedStandardFormat;
	protected String standardFormatView;	
	protected String modifiedStandardFormatView;
	private ActionType actionType;
	private BigInteger amountIncreaseDecrease;
	protected boolean validationSuccess = true;
	private boolean validCSO = false;
	private boolean issuerDownloadAtmts = false;
	/**
	 * The amendment id will be used for both bank guarantee amendment and sure rider
	 */
	private String amendmentId;
	protected Integer instrumentId;
	private String taxonomyViewType;
	private List<AmendmentDetails> amendsLst;
	private List<RiderDetails> ridersLst;
	protected CurrentBankFees comBidReplies;
	protected UpdateReporting updateReportingData;
	private ILinkTransactionManager linkTransactionManager;
	private ICreateBundleManager createBundleManager;	
	private List<RequestDetails> requestDetailsList ;
	private List<FullSummary> feeHistLst;
	protected List<String> rightBankRecords;
	protected List<Attachment> taxonomyAtmtsLst;
	protected List<Attachment> taxonomyClosureAtmts;

	private WorkflowStage stage;
	private DashboardViewType dashboardViewType;
	protected String wfid;
	protected String queueName;
	protected String procedureName;
	protected String stageName;
	protected BigDecimal bankBidId;
	protected String bidFlag;
	protected BigDecimal bidReplyId;

	private String returnToPage;
	protected BigInteger modelId;
	protected String logType;
	
	protected String hours;
	protected String minutes;
	protected String period;
	protected String bidHours;
	protected String bidMinutes;
	protected String bidPeriod;
	protected String bankLookupName;
	protected String bankCountryCd;
	protected String bankCity;
	protected String bankCountry;
	protected String allInCommissionsValue;
	protected String localCommissionsValue;
	protected String issuanceflag;
	protected String feeStructureValue;

	/**
	 * @return the issuanceflag
	 */
	public String getIssuanceflag() {
		return issuanceflag;
	}

	/**
	 * @param issuanceflag the issuanceflag to set
	 */
	public void setIssuanceflag(String issuanceflag) {
		this.issuanceflag = issuanceflag;
	}

	/**
	 * This is used to open the request upon clicking on the request Id.
	 * @return
	 * @throws HWFServiceException
	 */
	public String openRequest() throws HWFServiceException {
		String resultPage=null;
		ActionContext.getContext().getSession().put(ALOCConstants.TAXONOMY_REQUEST_ATTACHMENTS, null);
		if(requestId!=null && instrumentId!=null && amendmentId!=null){
			requestDetailsBO = requestDetailsManager.openRequest(InstrumentType.fromId(instrumentId),requestId,amendmentId);
			updateworkflowData(requestDetailsBO);
			resultPage= getRequestResultPage();
		}else if(requestId!=null){
			requestDetailsBO = requestDetailsManager.openRequest(requestId);
			updateworkflowData(requestDetailsBO);
			if(WorkflowStage.TREASURYBIDMEMO.getName().equals(stageName) || WorkflowStage.NEWMEMO.getName().equals(stageName) || WorkflowStage.EVLREPLY.getName().equals(stageName)){
				rightBankRecords = ALOCCommonHelper.setSelectedBankDetails((RequestDetails)requestDetailsBO.getModel(), rightBankRecords);
				requestDetailsBO = ALOCCommonHelper.filterBankRecordsBySiteName((RequestDetails)requestDetailsBO.getModel());
				setCalendarDetails((RequestDetails)requestDetailsBO.getModel());
				
				if(requestDetailsBO!=null && requestDetailsBO.getModel().getPricingDetails()!=null){
					if(requestDetailsBO.getModel().getPricingDetails().getAllInCommissionsValue()!=null){
						allInCommissionsValue = requestDetailsBO.getModel().getPricingDetails().getAllInCommissionsValue().toString();
					}
					if(requestDetailsBO.getModel().getPricingDetails().getLocalCommissionsValue()!=null){
						localCommissionsValue = requestDetailsBO.getModel().getPricingDetails().getLocalCommissionsValue().toString();
					}
					if(requestDetailsBO.getModel().getPricingDetails().getOneTimeFeesDetails() != null){
						ALOCCommonHelper.removeOntimFeeBigDecimalZeroValues(requestDetailsBO.getModel().getPricingDetails().getOneTimeFeesDetails());
					}
				}
			}
			
			if(WorkflowStage.TRESEDIT.getName().equals(stageName)){
				setHoursMinutes((RequestDetails)requestDetailsBO.getModel());
			}	
			if(requestDetailsBO.getModel()!=null && requestDetailsBO.getModel().getAttachments()!=null && requestDetailsBO.getModel().getAttachments().size()>ALOCConstants.BASE_VALUE){
			ActionContext.getContext().getSession().put(ALOCConstants.ATTACHMENT_REQUIRE_EDITS,requestDetailsBO.getModel().getAttachments().get(0).isRequiresEdits() );
			ActionContext.getContext().getSession().put(ALOCConstants.ATTACHMENT_SENDBACK_NOTES, requestDetailsBO.getModel().getAttachments().get(0).getSendBackNotes());
			}else{
				ActionContext.getContext().getSession().put(ALOCConstants.ATTACHMENT_REQUIRE_EDITS, false);
				ActionContext.getContext().getSession().put(ALOCConstants.ATTACHMENT_SENDBACK_NOTES, null);
			}
			BigInteger instrumentTypeId = requestDetailsBO.getModel() != null?requestDetailsBO.getModel().getInstrumentTypeId() : null;
			if(instrumentTypeId != null &&(instrumentTypeId.intValue()==InstrumentType.BANK_GUARANTEE.getId() || instrumentTypeId.intValue()==InstrumentType.LOC.getId())){
				String instrumentPurpose = requestDetailsBO.getModel().getTransactionParties() !=null?requestDetailsBO.getModel().getTransactionParties().getInstrumentPurposeId():null;
				ActionContext.getContext().getSession().put(ALOCConstants.INSTRUMENT_PURPOSE,instrumentPurpose);
			}else if(instrumentTypeId != null && instrumentTypeId.intValue() ==  InstrumentType.SURETY_BOND.getId()){
				BigInteger bondTypeId = requestDetailsBO.getModel().getBondDetails() !=null?requestDetailsBO.getModel().getBondDetails().getBondTypeId():null;
				ActionContext.getContext().getSession().put(ALOCConstants.BOND_TYPE,bondTypeId);
				BigInteger bondSubTypeId = requestDetailsBO.getModel().getBondDetails() !=null?requestDetailsBO.getModel().getBondDetails().getSubBondTypeId():null;
				ActionContext.getContext().getSession().put(ALOCConstants.BOND_SUBTYPE,bondSubTypeId);
			}
			resultPage= getRequestResultPage();
		}
		if(bankBidId!=null){
			requestDetailsBO.getModel().setBANKBIDID(bankBidId.toBigInteger());
			ALOCContext.setActiveRequest(requestDetailsBO);
		}
		if(((instrumentId != null && instrumentId.intValue() == InstrumentType.SURETY_BOND.getId()) && WorkflowStage.TREASURYBIDREPLY.getName().equals(stageName))
				|| ((instrumentId != null && (instrumentId.intValue() == InstrumentType.SURETY_BOND.getId() || instrumentId.intValue()==InstrumentType.RIDER.getId())) && (WorkflowStage.TREASURYBIDISSUE.getName().equals(stageName) || WorkflowStage.BANKISUE.getName().equals(stageName) || WorkflowStage.COMPLETE.getName().equals(stageName)))){
			requestDetailsBO = requestDetailsManager.getActiveSuretyMasterList(requestDetailsBO);
			setBidReplyCalendarDetails((RequestDetails)requestDetailsBO.getModel());
		}
		setAttachmentsToRequestByStage((RequestDetails)requestDetailsBO.getModel());		
		taxonomyViewType = ALOCConstants.OPENREQUEST;
		editSectionList=null;
		Map<String, Object> sessionValues =ActionContext.getContext().getSession();
		sessionValues.put(ALOCConstants.EDITSECTIONLIST,null);
		return resultPage;
	}
	
	/**
	 * This method is used to create and open the amendment request on clicking on Create amendment.
	 * @return
	 * @throws HWFServiceException
	 */
	public String openAmendmentRequest() throws HWFServiceException {
		HttpServletRequest request=ServletActionContext.getRequest();
		if(requestId==null){
			if(StringUtils.isNotBlank(request.getParameter(ALOCConstants.REQUESTID))){
				requestId= new BigInteger(request.getParameter(ALOCConstants.REQUESTID));
			}
		}
		if(requestId!=null){
			requestDetailsBO = requestDetailsManager.createAmendmentRequestId(InstrumentType.fromId(instrumentId),requestId);
		}
		return AMENDMENT_REQUEST_PAGE;

	}

	/**
	 * This method is used to create and open the rider request on clicking on Create Rider.
	 * @return
	 * @throws HWFServiceException
	 */
	public String openRiderRequest() throws HWFServiceException {
		HttpServletRequest request=ServletActionContext.getRequest();
		if(requestId==null){
			if(StringUtils.isNotBlank(request.getParameter(ALOCConstants.REQUESTID))){
				requestId= new BigInteger(request.getParameter(ALOCConstants.REQUESTID));
			}
		}
		
		if(requestId!=null){
			requestDetailsBO = requestDetailsManager.createSuretyRiderRequestId(InstrumentType.fromId(instrumentId),requestId);
		}
		return RIDER_REQUEST_PAGE;
	}


	/**
	 * This method is used to open the active request from session.
	 * @return
	 */
	public String openActiveRequest() throws HWFServiceException {
		return getRequestResultPage();
	}

	/**
	 * This method is used to make edit mode as true while clicking on Edit button on each section of the request page .
	 * @return
	 * @throws HWFServiceException 
	 */
	public String editSection() throws HWFServiceException {
		if(requestId != null || amendmentOrRiderRequestId!=null){
			validateRequest();
		}
		editMode = true;
		return getSectionResultPage();
	}

	/**
	 * This method is used to apply the changes to the section and make edit mode as false.
	 * @return
	 */
	public String applySection() throws HWFServiceException, ALOCAttachmentException, ALOCException  {
		if(requestId != null || amendmentOrRiderRequestId!=null){
			validateRequest();
		}
		editMode = false;
		RequestDetails requestDetails=getRequestDetails();
		if((requestDetails.getInstrumentTypeId().equals(BigInteger.valueOf(InstrumentType.BANK_GUARANTEE.getId())) || requestDetails.getInstrumentTypeId().equals(BigInteger.valueOf(InstrumentType.LOC.getId()))) && requestDetails.getInstrumentDetails()!=null){
			requestDetails = ALOCCommonHelper.deleteAutoInc(requestDetails);
			setRequestDetailsBO(new RequestDetailsBO(requestDetails));
		}
		if(sectionId==RequestSectionId.REQUESTOR_MAILING_ADDRESS && requestDetails.getInstrumentTypeId()!=null && InstrumentType.SURETY_BOND.getId() == requestDetails.getInstrumentTypeId().intValue()){
			if(requestDetails.getBondReqDtls()!=null && requestDetails.getAddressDtls()!=null){
				requestDetails = ALOCCommonHelper.setBondReqDtls(requestDetails);
			}
		}
		if(sectionId==RequestSectionId.FORMAT) //needs to save all the attachments 
		{								
			requestDetailsSectionManager.saveFormat(standardFormat,modifiedStandardFormat);
		}
		return getSectionResultPage();
	}

	/**
	 * This method is used to track the section changes.
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String trackSection() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String trackingSectionId = request.getParameter(ALOCConstants.TRACKCHANGES);
		Map<String, Object> sessionValues =ActionContext.getContext().getSession();
		editSectionList=(List<NameValue>) sessionValues.get(ALOCConstants.EDITSECTIONLIST);
		if(editSectionList==null){
			editSectionList= new ArrayList<NameValue>();
		}
		boolean flag = false;
		NameValue nameValue = new NameValue();
		nameValue.setName(trackingSectionId);
		if(editSectionList.isEmpty()){
			editSectionList.add(nameValue);
		} else {
			for (NameValue sectionName : editSectionList) {
				if (sectionName.getName().equals(trackingSectionId)) {
					flag = true;
					break;
				}
			}
			if(!flag){
				editSectionList.add(nameValue);
			}
		}
		sessionValues.put(ALOCConstants.EDITSECTIONLIST,editSectionList);
		return getRequestResultPage();
	}

	/**
	 * This method is used to do the cancel the section changes if any.
	 * @return
	 */
	public String cancelSection() throws HWFServiceException {
		RequestDetails requestDetails;
		if(requestId != null || amendmentOrRiderRequestId!=null){
			validateRequest();
		}
		InstrumentType instrumentType = InstrumentType.fromId(getRequestDetails().getInstrumentTypeId().intValue());
		List<Attachment> atmtList = getRequestDetails().getAttachments();
		if(instrumentType.equals(InstrumentType.AMENDMENT)){
			requestDetails = requestDetailsManager.getRequest(instrumentType,getRequestDetails().getRequestId(), getRequestDetails().getAmendment().getAmendmentRequestId());
			requestDetails.setAttachments(atmtList);
		}else if(instrumentType.equals(InstrumentType.RIDER)){
			requestDetails = requestDetailsManager.getRequest(instrumentType,getRequestDetails().getRequestId(), getRequestDetails().getRider().getRiderRequestId());
			requestDetails.setAttachments(atmtList);
		}else if(instrumentType != null && sectionId != null && sectionId.equals(RequestSectionId.ATTACHMENTS)){
			requestDetails = getRequestDetails();
		}else{
			requestDetails = requestDetailsManager.getRequest(getRequestDetails().getRequestId());
		}
		
		if(sectionId != null) {
			switch(sectionId) {
			case TRANSACTION_PARTIES:
				getRequestDetails().setTransactionParties(requestDetails.getTransactionParties());
				break;
			case PROJECT_DESCRIPTION:
				getRequestDetails().setProjDescription(requestDetails.getProjDescription());
				break;
			case INSTRUMENT_DETAILS:
				getRequestDetails().setInstrumentDetails(requestDetails.getInstrumentDetails());
				break;
			case INSTRUMENT_RISK:
				getRequestDetails().setInstrumentRisk(requestDetails.getInstrumentRisk());
				break;

			case STANDBY_LETTER_OF_CREDIT_CONDITIONS:
				getRequestDetails().setSBLC(requestDetails.getSBLC());

			case INSTRUMENT_REPORTING_ATTRIBUTES:
				getRequestDetails().setInstrReporting(requestDetails.getInstrReporting());
				break;

			case FORMAT:
				getRequestDetails().setFormat(requestDetails.getFormat());
				getRequestDetails().setSwiftFormatDoc(requestDetails.getSwiftFormatDoc());
				break;	
			case ATTACHMENTS:
				if(instrumentType.equals(InstrumentType.AMENDMENT)){
					getRequestDetails().getAmendment().setAttachments(requestDetails.getAmendment().getAttachments());
				}else{
					getRequestDetails().setAttachments(requestDetails.getAttachments());
					if(!(instrumentType.equals(InstrumentType.RIDER))){
						boolean EditFlag = (Boolean)ActionContext.getContext().getSession().get(ALOCConstants.ATTACHMENT_REQUIRE_EDITS);
						String sendbackNotes = (String)ActionContext.getContext().getSession().get(ALOCConstants.ATTACHMENT_SENDBACK_NOTES);
						if(getRequestDetails().getAttachments()!=null && !getRequestDetails().getAttachments().isEmpty()){
						getRequestDetails().getAttachments().get(ALOCConstants.BASE_VALUE).setRequiresEdits(EditFlag);
						getRequestDetails().getAttachments().get(ALOCConstants.BASE_VALUE).setSendBackNotes(sendbackNotes);
						}
					}
				}
				break;				
				/* LOC Related sections */
			case BUSINESS_CONTACT_PERSON:
				getRequestDetails().setBuContactPerson(requestDetails.getBuContactPerson());
				break;
			case ISSUING_BANK:
				getRequestDetails().setIssuingBankDetails(requestDetails.getIssuingBankDetails());
				break;
			case APPLICANT:
				getRequestDetails().setApplicantDetails(requestDetails.getApplicantDetails());
				break;
			case BENEFICIARY:
				getRequestDetails().setBeneficiaryDetails(requestDetails.getBeneficiaryDetails());

				break;
			case INSTRUMENT_TRANSACTION_DETAILS:
				getRequestDetails().setTransactionDetails(requestDetails.getTransactionDetails());
				break;
			case PAYMENT_SCHEDULE:
				getRequestDetails().setPaymentScheduleDetails(requestDetails.getPaymentScheduleDetails());
				break;
				/* Surety Bond Related sections */

			case BOND_DETAILS:
				getRequestDetails().setBondDetails(requestDetails.getBondDetails());
				getRequestDetails().setPrincipal(requestDetails.getPrincipal());
				getRequestDetails().setObligee(requestDetails.getObligee());
				break;
			case PRINCIPAL:
				getRequestDetails().setPrincipal(requestDetails.getPrincipal());
				break;
			case OBLIGEE:
				getRequestDetails().setObligee(requestDetails.getObligee());
				break;
			case BOND_REQUESTOR:
				getRequestDetails().setBondReqDtls(requestDetails.getBondReqDtls());
				break;
			case REQUESTOR_MAILING_ADDRESS:
				getRequestDetails().setAddressDtls(requestDetails.getAddressDtls());
				break;
			case DELIVERY_INSTRUTIONS:
				if(instrumentType.equals(InstrumentType.AMENDMENT)){
					getRequestDetails().getAmendment().setDeliveryInstructions(requestDetails.getAmendment().getDeliveryInstructions());
				}else{
					getRequestDetails().setDeliveryInstructions(requestDetails.getDeliveryInstructions());
				}
				break;
			case BOND_INFORMATION:
				getRequestDetails().setBondInfo(requestDetails.getBondInfo());
				break;
			case ATTORNEY_BOND_INFORMATION:
				getRequestDetails().setBondInfo(requestDetails.getBondInfo());
				break;					
			case BUSINESS_DELEGATION:
				getRequestDetails().setBuDelegation(requestDetails.getBuDelegation());
				break;	
			case TRIPARTYFLAG:
				getRequestDetails().getTransactionParties().setPrivateLabelFlag(requestDetails.getTransactionParties().isPrivateLabelFlag());
				getRequestDetails().getTransactionParties().setTriPartyRequestFlag(requestDetails.getTransactionParties().isTriPartyRequestFlag());
				getRequestDetails().getTransactionParties().setRequiresEdits(requestDetails.getTransactionParties().isRequiresEdits());
				getRequestDetails().getTransactionParties().setSendBackNotes(requestDetails.getTransactionParties().getSendBackNotes());
				getRequestDetails().getTransactionParties().setInstrumentPurpose(requestDetails.getTransactionParties().getInstrumentPurpose());
				getRequestDetails().getTransactionParties().setInstrumentPurposeId(requestDetails.getTransactionParties().getInstrumentPurposeId());
				getRequestDetails().getTransactionParties().setInstrumentPurposeOther(requestDetails.getTransactionParties().getInstrumentPurposeOther());
				break;
			case TPAPPLICANT:
				if(instrumentType.equals(InstrumentType.AMENDMENT)){
					getRequestDetails().getAmendment().getTransactionParties().setTpApplicantDetails(requestDetails.getAmendment().getTransactionParties().getTpApplicantDetails());
				}else{
					getRequestDetails().getTransactionParties().setTpApplicantDetails(requestDetails.getTransactionParties().getTpApplicantDetails());
				}
				break;
			case TRIPARTY_ADDRESS:
				if(instrumentType.equals(InstrumentType.AMENDMENT)){
					getRequestDetails().getAmendment().getTransactionParties().setTriPartyApplicant(requestDetails.getAmendment().getTransactionParties().getTriPartyApplicant());
				}else{
					getRequestDetails().getTransactionParties().setTriPartyApplicant(requestDetails.getTransactionParties().getTriPartyApplicant());
				}
				break;
			case TPCUSTOMER_BENEFICIARY:
				if(instrumentType.equals(InstrumentType.AMENDMENT)){
					getRequestDetails().getAmendment().getTransactionParties().setCustomer(requestDetails.getAmendment().getTransactionParties().getCustomer());
				}else{
					getRequestDetails().getTransactionParties().setCustomer(requestDetails.getTransactionParties().getCustomer());
				}
				break;
				/* Amendment*/
			case INSTRUMENT_AMOUNT_CURRENCY:
				getRequestDetails().getAmendment().setAmendmentInstrumentAmountCurr(requestDetails.getAmendment().getAmendmentInstrumentAmountCurr());
				break;
			case EXPIRATION_DATES:
				getRequestDetails().getAmendment().setExpiryDate(requestDetails.getAmendment().getExpiryDate());
				break;
			case OTHER_CHANGES:
				getRequestDetails().getAmendment().setOtherChanges(requestDetails.getAmendment().getOtherChanges());
				break;
				/* Surety Rider*/
			case RIDER_PRINCIPAL:
				getRequestDetails().getRider().setPrincipal(requestDetails.getRider().getPrincipal());
				break;
			case RIDER_OBLIGEE:
				getRequestDetails().getRider().setObligee(requestDetails.getRider().getObligee());
				break;
			case RIDER_EXPIRATION_DATES:
				getRequestDetails().getRider().setExpiryDate(requestDetails.getRider().getExpiryDate());
				break;
			case RIDER_BOND_INFORMATION:
				getRequestDetails().getRider().setRiderBondInformation(requestDetails.getRider().getRiderBondInformation());
				break;
			case RIDER_DELIVERY_INSTRUTIONS:
				getRequestDetails().getRider().setDeliveryInstructions(requestDetails.getRider().getDeliveryInstructions());
				break;
			}
		}
		editMode = false;
		return getSectionResultPage();
	}

	/**
	 * This method is used to the request details and make current request as active request.
	 * @return
	 */
	protected void save(ActionType actionType) throws HWFServiceException {
		saveFormatData();
		RequestDetails requestDetails = requestDetailsSectionManager.save(actionType);
		if(requestDetails.getInstrumentTypeId()!=null && InstrumentType.SURETY_BOND.getId()==requestDetails.getInstrumentTypeId().intValue()){
			if(requestDetails.getBondReqDtls()!=null && requestDetails.getAddressDtls()!=null){
				requestDetails = ALOCCommonHelper.setAddressDetails(requestDetails);
			}
		}
		requestDetailsBO = new RequestDetailsBO(requestDetails);
		ALOCContext.setActiveRequest(requestDetailsBO);
	}
	
	/**
	 * This method will save the Format content if the InstrumentPurpose/BondType/BondSubType is changed 
	 * @throws HWFServiceException
	 */
	protected void saveFormatData() throws HWFServiceException {
		RequestDetails requestDetails = ALOCContext.getActiveRequest() != null?ALOCContext.getActiveRequest().getModel() : null;
		String formatTypeId = requestDetails != null && requestDetails.getFormat() != null?requestDetails.getFormat().getFormatTypeId() : null;
		if(StringUtils.isNotBlank(formatTypeId) && Integer.valueOf(formatTypeId) != Integer.valueOf(ALOCConstants.NON_STANDARD_FORMAT) && isFormatDocChangeRequired()){
			String instrPurposeId = null;
			BigInteger bondTypeId = null;
			BigInteger bondSubTypeId = null;
			BigInteger instrumentTypeId = requestDetails != null?requestDetails.getInstrumentTypeId() : null;
			if(instrumentTypeId != null &&(instrumentTypeId.intValue()==InstrumentType.BANK_GUARANTEE.getId() || instrumentTypeId.intValue()==InstrumentType.LOC.getId())){
				instrPurposeId = requestDetails.getTransactionParties() !=null?requestDetails.getTransactionParties().getInstrumentPurposeId():null;
			}else if(instrumentTypeId != null && instrumentTypeId.intValue() ==  InstrumentType.SURETY_BOND.getId()){
				bondTypeId = requestDetails.getBondDetails() !=null?requestDetails.getBondDetails().getBondTypeId():null;
				bondSubTypeId = requestDetails.getBondDetails() !=null?requestDetails.getBondDetails().getSubBondTypeId():null;
			}
			bondSubTypeId = bondSubTypeId!= null ? bondSubTypeId : new BigInteger(ALOCConstants.BASE_STRING_VALUE);
			String formatContent = requestDetailsSectionManager.getStandardFormatDocument(String.valueOf(requestDetailsBO.getModel().getRequestId()),instrPurposeId,bondTypeId,bondSubTypeId);
			try {
				requestDetailsSectionManager.saveFormat(formatContent,formatContent);
				
				if(instrumentTypeId != null &&(instrumentTypeId.intValue()==InstrumentType.BANK_GUARANTEE.getId() || instrumentTypeId.intValue()==InstrumentType.LOC.getId())){
					ActionContext.getContext().getSession().put(ALOCConstants.INSTRUMENT_PURPOSE,instrPurposeId);
				}else if(instrumentTypeId != null && instrumentTypeId.intValue() ==  InstrumentType.SURETY_BOND.getId()){
					ActionContext.getContext().getSession().put(ALOCConstants.BOND_TYPE,bondTypeId);
					ActionContext.getContext().getSession().put(ALOCConstants.BOND_SUBTYPE,bondSubTypeId);
				}
			} catch (ALOCException e) {
				LOGGER.error(e.getMessage(),e);
			}
		}
	}

	/**
	 * This method is used to the amendment request details and make current request as active request.
	 * @throws HWFServiceException
	 */
	protected void saveAmendment() throws HWFServiceException {
		RequestDetails requestDetails = requestDetailsSectionManager.saveAmendment();
		requestDetailsBO = new RequestDetailsBO(requestDetails);
		ALOCContext.setActiveRequest(requestDetailsBO);

	}

	/**
	 * This method is used to the rider request details and make current request as active request.
	 * @throws HWFServiceException
	 */
	protected void saveRider() throws HWFServiceException {
		RequestDetails requestDetails = requestDetailsSectionManager.saveRider();
		requestDetailsBO = new RequestDetailsBO(requestDetails);
		ALOCContext.setActiveRequest(requestDetailsBO);

	}

	/**
	 * This method is used to cancel the request and remove the active request from the session.
	 * @return
	 */
	public String cancel() {
		ALOCContext.removeActiveRequest();
		return SUCCESS;
	}

	/**
	 * This method is used for cancel all changes in the review request.
	 * @return
	 */
	public String cancelAll() throws HWFServiceException {
		RequestDetails requestDetails = requestDetailsManager.getRequest(getRequestDetails().getRequestId());
		RequestDetailsBO oldrequestDetailsBO = new RequestDetailsBO(requestDetails);
		ALOCContext.setActiveRequest(oldrequestDetailsBO);
		oldrequestDetailsBO.getModel().setWFDetails(getRequestDetails().getWFDetails());
		setRequestDetailsBO(oldrequestDetailsBO);
		editSectionList=null;
		Map<String, Object> sessionValues =ActionContext.getContext().getSession();
		sessionValues.put(ALOCConstants.EDITSECTIONLIST,null);
		editMode = false;
		return getRequestResultPage();
	}


	/**
	 * This method is used to update the workflow data.
	 * @param requestDetailsBO 
	 */
	public void updateworkflowData(RequestDetailsBO requestDetailsBO){
		if(requestDetailsBO.getModel().getWFDetails()!=null){
			requestDetailsBO.getModel().getWFDetails().setWFStage(getStageName());
			requestDetailsBO.getModel().getWFDetails().setWFStageID(new BigInteger(getStage().toString()));
			requestDetailsBO.getModel().getWFDetails().setProcedureName(getProcedureName());
			requestDetailsBO.getModel().getWFDetails().setQueueName(getQueueName());
			requestDetailsBO.getModel().getWFDetails().setWFID(getWfid());

		}

	}	

	/** 
	 * This method is used to download the attachment.
	 * @return
	 * @throws IOException 
	 * @throws HWFServiceException
	 */
	public String downloadAttachment() throws IOException, HWFServiceException,HWFServiceStubException,ALOCException {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		String geLibFileId = request.getParameter(ALOCConstants.PARAM_GELIBFILEID);
		String attachmentType = request.getParameter(ALOCConstants.PARAM_ATTACHMENT_TYPE);
		OutputStream outputStream = null;
		Attachment attachmentToDownload = null;
		try {
			if (StringUtils.isNotBlank(geLibFileId)) {
				RequestDetails requestDetails = ALOCContext.getActiveRequest().getModel();
				// If requested attachment is normal attachment
				if(attachmentType.equalsIgnoreCase(String.valueOf(AttachmentType.OTHER.getId()))){
					attachmentToDownload = AttachmentUtils.searchAttachmentByGELibId(geLibFileId,requestDetails.getAttachments()); 		
				}
				// If requested attachment is standard format.
				else if(attachmentType.equalsIgnoreCase(String.valueOf(AttachmentType.STANDARD_FORMAT.getId()))){
					attachmentToDownload = AttachmentUtils.searchAttachmentByGELibId(geLibFileId, requestDetails.getFormat().getAttachments());
				}						
				response.setContentType(ServletActionContext.getServletContext().getMimeType(attachmentToDownload.getAttachmentName()));
				response.addHeader(ALOCConstants.HEADER_CONTENT_DISPOSITION,ALOCConstants.CONTENT_DISPOSITION_VALUE+ attachmentToDownload.getAttachmentName());
				outputStream = response.getOutputStream();
				alocAttachmentManager.downloadAttachment(outputStream,attachmentToDownload);
			}
		} finally {
			outputStream.flush();
			outputStream.close();
		}
		return null;
	}

	/**
	 * This method is used to download all attachments as zip format.
	 * @return
	 * @throws ALOCAttachmentException 
	 */
	@SuppressWarnings("unchecked")
	public String downloadAllAttachmentsAsZip() throws ALOCAttachmentException {
		HttpServletResponse response = ServletActionContext.getResponse();
		List<Attachment> atmtsList = (List<Attachment>)ActionContext.getContext().getSession().get(requestDetailsBO.getModel().getRequestId()+ALOCConstants.UNDERSCORE+ALOCConstants.ATTACHMENTS_BY_TYPE);
		if(atmtsList == null || atmtsList.size() == ALOCConstants.BASE_VALUE){
			atmtsList = (List<Attachment>)ActionContext.getContext().getSession().get(requestDetailsBO.getModel().getRequestId()+ALOCConstants.UNDERSCORE+ALOCConstants.TAXONOMY_ATTACHMENTS);
		}
		if(atmtsList == null){
			atmtsList = new ArrayList<Attachment>();
		}
		String fileName = new StringBuilder().append(ALOCConstants.ALOC_UNDERSCORE).append(requestDetailsBO.getModel().getAlocRecordId()).append(ALOCConstants.DOCS_ZIP).toString();
		response.setContentType(ServletActionContext.getServletContext().getMimeType(fileName));
		response.addHeader(ALOCConstants.HEADER_CONTENT_DISPOSITION,ALOCConstants.CONTENT_DISPOSITION_VALUE+ fileName);
		OutputStream outStream = null;
		try {
			outStream = response.getOutputStream();
			alocAttachmentManager.downloadAllAttachmentsAsZip(outStream,atmtsList);
		} catch (IOException e) {
			LOGGER.error(ALOCConstants.ERROR_WHILE_CREATING_FILE + fileName, e);
			throw new ALOCAttachmentException(null, ALOCConstants.ERROR_WHILE_CREATING_FILE + fileName, e);
		} finally {
			try {
				if(outStream != null) {
					outStream.close();
				}
			} catch (IOException e) {
				LOGGER.warn(ALOCConstants.ERROR_CLOSING_STREAM_WHILE_DOWNLOAD_FILE + fileName, e);
			}
		}
		return null;
	}

	
	/**
	 * This method is used to download selected format type from format section .
	 * @return
	 * @throws ALOCException 
	 */
	public String downloadFormatData() throws ALOCException {
		HttpServletResponse response = ServletActionContext.getResponse();	
		PrintWriter pw = null;
		Attachment attachmentToDownload = null;
		String fileName = ALOCConstants.EMPTY_STRING;
		try {
			RequestDetails requestDetails = ALOCContext.getActiveRequest() != null?ALOCContext.getActiveRequest().getModel():null;			
			attachmentToDownload = (requestDetails != null &&!requestDetails.getFormat().getAttachments().isEmpty()) ? requestDetails.getFormat().getAttachments().get(ALOCConstants.BASE_VALUE) : new Attachment();
			if(requestDetails != null && Integer.valueOf(requestDetails.getFormat().getFormatTypeId()).intValue()== FormatType.STANDARD.getId()
					|| Integer.valueOf(requestDetails.getFormat().getFormatTypeId()).intValue() == FormatType.MODIFIED.getId()){
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				boolean formatDoc = false;
				if(StringUtils.isNotBlank(requestDetails.getSwiftFormatDoc())){
					formatDoc = true;
				}else{
					alocAttachmentManager.downloadAttachment(baos,attachmentToDownload);
				}
				if(Integer.valueOf(requestDetails.getFormat().getFormatTypeId()).intValue()== FormatType.STANDARD.getId()){
					fileName = new StringBuilder().append(ALOCConstants.ALOC_UNDERSCORE).append(requestDetailsBO.getModel().getAlocRecordId()).append(ALOCConstants.HYPEN).append(ALOCConstants.STANDARD_FORMATDOC).toString();}
				if(Integer.valueOf(requestDetails.getFormat().getFormatTypeId()).intValue() == FormatType.MODIFIED.getId()){
					fileName = new StringBuilder().append(ALOCConstants.ALOC_UNDERSCORE).append(requestDetailsBO.getModel().getAlocRecordId()).append(ALOCConstants.HYPEN).append(ALOCConstants.MODIFIED_FORMATDOC).toString();}
				String formatSwiftDoc = ALOCConstants.EMPTY_STRING;
				if(attachmentToDownload != null || formatDoc == true){
					if(formatDoc == true){
						formatSwiftDoc = requestDetails.getSwiftFormatDoc();
					}else{
						formatSwiftDoc = baos!= null?baos.toString():ALOCConstants.EMPTY_STRING;
					}
				}
				String data = new BookmarksHelper(requestDetailsBO.getModel(), formatSwiftDoc).replaceTokens();
				response.setContentType(ServletActionContext.getServletContext().getMimeType(fileName));					
				response.addHeader(ALOCConstants.HEADER_CONTENT_DISPOSITION,ALOCConstants.CONTENT_DISPOSITION_VALUE+ fileName);	
				pw = response.getWriter();
				pw.println(ALOCCommonHelper.getFormatTemplateDoc(data));
			}
			else{
				OutputStream outStream = response.getOutputStream();															
				response.setContentType(ServletActionContext.getServletContext().getMimeType(attachmentToDownload.getAttachmentName()));
				response.addHeader(ALOCConstants.HEADER_CONTENT_DISPOSITION,ALOCConstants.CONTENT_DISPOSITION_VALUE+ attachmentToDownload.getAttachmentName());			
				alocAttachmentManager.downloadAttachment(outStream,attachmentToDownload);			
			}

		} catch (IOException ie) {
			LOGGER.error(ALOCConstants.ERROR_DOWNLOADING_FILE + attachmentToDownload.getAttachmentName(), ie);
			throw new ALOCAttachmentException(null, ALOCConstants.ERROR_DOWNLOADING_FILE, ie);
		} finally {
			if(pw != null) {
				pw.close();
			}
		}
		return null;
	}
	
	/**
	 * This method is used to get the Generated modifiedStandardFormat document.
	 * @return
	 */
	public void generateFormatDoc()  throws HWFServiceException,ALOCException  {
		HttpServletResponse response = ServletActionContext.getResponse();		
		PrintWriter pw = null;
		String formatType = requestDetailsBO.getModel().getFormat().getFormatTypeId();
		String templateData = ALOCConstants.EMPTY_STRING;
		String fileName = ALOCConstants.EMPTY_STRING;
		if(formatType != null)
		{			
			if(Integer.valueOf(formatType).intValue() == FormatType.MODIFIED.getId()){				
				templateData  = getModifiedStandardFormat();
				fileName = new StringBuilder().append(ALOCConstants.ALOC_UNDERSCORE).append(requestDetailsBO.getModel().getAlocRecordId()).append(ALOCConstants.HYPEN).append(ALOCConstants.MODIFIED_FORMATDOC).toString();
			}
			if(Integer.valueOf(formatType).intValue() == FormatType.STANDARD.getId()){
				templateData = getStandardFormat();
				fileName = new StringBuilder().append(ALOCConstants.ALOC_UNDERSCORE).append(requestDetailsBO.getModel().getAlocRecordId()).append(ALOCConstants.HYPEN).append(ALOCConstants.STANDARD_FORMATDOC).toString();
			}							
			try {
				String data = new BookmarksHelper(requestDetailsBO.getModel(),templateData).replaceTokens();
				response.setContentType(ServletActionContext.getServletContext().getMimeType(fileName));					
				response.addHeader(ALOCConstants.HEADER_CONTENT_DISPOSITION,ALOCConstants.CONTENT_DISPOSITION_VALUE+ fileName);	
				pw = response.getWriter();
				pw.println(ALOCCommonHelper.getFormatTemplateDoc(data));//This is format render script which needs to be added dynamically while downloading the format template with request details				
			} catch (IOException e) {
				LOGGER.error(ALOCConstants.ERROR_DOWNLOADING_FILE + fileName, e);
			}finally {
				if(pw != null) {
					pw.close();
				}
			}		
		}
	}
	
	/**
	 * This method is used to download selected format type from format section .
	 * @return requestDetails
	 * @throws ALOCException 
	 * @throws HWFServiceException 
	 */
	public RequestDetails saveFormatSwiftData() throws ALOCException, HWFServiceException {
		Attachment attachmentToDownload = null;
		RequestDetails requestDetails = null;
		requestDetails = ALOCContext.getActiveRequest() != null?ALOCContext.getActiveRequest().getModel() : null;
		BigInteger instrumentType = requestDetails != null ? requestDetails.getInstrumentTypeId() : null;
		if(requestDetails == null || instrumentType == null){
			requestDetailsBO = requestDetailsManager.openRequest(requestId);
			requestDetails = requestDetailsBO.getModel();
		}
		if(requestDetails.getInstrumentTypeId() != null && (requestDetails.getInstrumentTypeId().intValue() != InstrumentType.AMENDMENT.getId() &&
				requestDetails.getInstrumentTypeId().intValue() != InstrumentType.RIDER.getId())){
		attachmentToDownload = (requestDetails.getFormat()!=null && !requestDetails.getFormat().getAttachments().isEmpty()) ? requestDetails.getFormat().getAttachments().get(ALOCConstants.BASE_VALUE) : new Attachment();
		if((Integer.valueOf(requestDetails.getFormat().getFormatTypeId()) == FormatType.STANDARD.getId()
				|| Integer.valueOf(requestDetails.getFormat().getFormatTypeId()) == FormatType.MODIFIED.getId())){
			ByteArrayOutputStream tempStream = new ByteArrayOutputStream();
			boolean formatDoc = false;
			if(StringUtils.isNotBlank(requestDetails.getSwiftFormatDoc())){
				formatDoc = true;
			}else{
				try {
					alocAttachmentManager.downloadAttachment(tempStream, attachmentToDownload);
				} catch (ALOCException e) {
					LOGGER.error(e.getMessage(),e);
				}
				try{
					alocAttachmentManager.delete(attachmentToDownload);
				}catch(ALOCAttachmentException ae){
					LOGGER.error(ae.getMessage(),ae);
				}
			}
			if(attachmentToDownload != null || formatDoc == true){
				String formatSwiftDoc = ALOCConstants.EMPTY_STRING;
				if(formatDoc == true){
					formatSwiftDoc = requestDetails.getSwiftFormatDoc();
				}else{
					List<Attachment> atmtLst = new ArrayList<Attachment>();
					attachmentToDownload.setOpCode(OpCode.DELETE.getOperationCode());
					attachmentToDownload.setActionType(ALOCConstants.DELETE);
					atmtLst.add(attachmentToDownload);
					requestDetails.getFormat().setAttachments(atmtLst);
					formatSwiftDoc = tempStream != null ? tempStream.toString():ALOCConstants.EMPTY_STRING;
				}
				String formatData = new BookmarksHelper(requestDetailsBO.getModel(), formatSwiftDoc).replaceTokens();
				requestDetails.setSwiftFormatDoc(formatData);
				requestDetails = requestDetailsManager.saveFormatSwiftData(requestDetails);
				requestDetails.setSwiftFormatDoc(formatData);
			}
		}else {
			requestDetailsBO.getModel().setSwiftFormatDoc(null);
		}
	}
		return requestDetails;
	}
	
	/**
	 * This method is used to send the selected format swift data at BidReply stage .
	 * @throws ALOCException 
	 * @throws HWFServiceException 
	 */
	public void sendFormatSwiftData() throws ALOCException, HWFServiceException {
		Attachment attachmentToDownload = null;
		RequestDetails requestDetails = null;
		requestDetails = ALOCContext.getActiveRequest() != null?ALOCContext.getActiveRequest().getModel() : null;
		if(requestDetails == null){
			requestDetailsBO = requestDetailsManager.openRequest(requestId);
			requestDetails = requestDetailsBO.getModel();
		}
		if(requestDetails.getInstrumentTypeId() != null){
		attachmentToDownload = (requestDetails.getFormat()!=null && !requestDetails.getFormat().getAttachments().isEmpty()) ? requestDetails.getFormat().getAttachments().get(ALOCConstants.BASE_VALUE) : new Attachment();
		if((Integer.valueOf(requestDetails.getFormat().getFormatTypeId()) == FormatType.STANDARD.getId()
				|| Integer.valueOf(requestDetails.getFormat().getFormatTypeId()) == FormatType.MODIFIED.getId())){
			ByteArrayOutputStream tempStream = new ByteArrayOutputStream();
			boolean formatDoc = false;
			if(StringUtils.isNotBlank(requestDetails.getSwiftFormatDoc())){
				formatDoc = true;
			}else{
				try {
					alocAttachmentManager.downloadAttachment(tempStream, attachmentToDownload);
				} catch (ALOCException e) {
					LOGGER.error(e.getMessage(),e);
				}
			}
			if(tempStream != null || formatDoc == true){
				String formatSwiftDoc = ALOCConstants.EMPTY_STRING;
				if(formatDoc == true){
					formatSwiftDoc = requestDetails.getSwiftFormatDoc();
				}else{
					formatSwiftDoc = tempStream != null ? tempStream.toString():ALOCConstants.EMPTY_STRING;
				}
				String formatData = new BookmarksHelper(requestDetailsBO.getModel(), formatSwiftDoc).replaceTokens();
				requestDetailsBO.getModel().setSwiftFormatDoc(formatData);
			}
		}else {
			requestDetailsBO.getModel().setSwiftFormatDoc(null);
		}
	}
	}
	
	/**
	 * This is use dto submit the request.
	 * @return
	 */
	public abstract String submit() throws HWFServiceException,ALOCAttachmentException,ALOCException;

	/**
	 * This method decides the page to display on validation error conditions
	 */
	public String getInputResultName() {
		editMode = true;
		validationSuccess = false;
		boolean taxonomyFlag = isTaxonomyPage();
		if(taxonomyFlag == true){
			return returnTaxonomyPage();
		}
		if(ActionContext.getContext().getActionInvocation().getProxy().getMethod().equals(SAVECURRBANKFEES)){
			editMode = false;
			if(ActionContext.getContext().getSession().get(ALOCConstants.CURRBANKFEES_AUDITLOG)!=null){
			@SuppressWarnings("unchecked")
			List<AuditLog> Logs=(List<AuditLog>)ActionContext.getContext().getSession().get(ALOCConstants.CURRBANKFEES_AUDITLOG);
				comBidReplies.setAuditLogs(Logs);
			}
			return getRequestResultPage();
		}
		if(ActionContext.getContext().getActionInvocation().getProxy().getMethod().equals(UPDATE_REPORTING_DATA)){
			editMode = false;
			if(ActionContext.getContext().getSession().get(ALOCConstants.UPDATEREPORTING_AUDITLOG)!=null){
				@SuppressWarnings("unchecked")
				List<AuditLog> Logs=(List<AuditLog>)ActionContext.getContext().getSession().get(ALOCConstants.UPDATEREPORTING_AUDITLOG);
				updateReportingData.setAuditLogs(Logs);
				}
			return returnTaxonomyPage();
		}
		return (isRequestForValidateSection()) ? getSectionResultPage() : INPUT;
	}

	/**
	 * This method is used to navigate to the appropriate request page based on instrument type.
	 * @return
	 */
	protected String getRequestResultPage() {
		String resultName = null;
		InstrumentType instrumentType = InstrumentType.fromId(getRequestDetails().getInstrumentTypeId().intValue()); 
		switch(instrumentType) {
		case BANK_GUARANTEE:
			resultName = BANKGUARANTEE_REQUEST_PAGE;
			break;
		case LOC:
			resultName = LOC_REQUEST_PAGE;
			break;
		case SURETY_BOND:
			resultName = SURETYBOND_REQUEST_PAGE;
			break;
		case DOCUMENT_LOC:
			resultName = DOCUMENT_LOC_REQUEST_PAGE;
			break;
		case AMENDMENT:
			if(StringUtils.isNotBlank(getRequestDetails().getAmendment().getAmendmentType()) 
					&& ALOCConstants.Y_CAP.equalsIgnoreCase(getRequestDetails().getAmendment().getAmendmentType().trim())){
				resultName = AUTO_AMENDMENT_REQUEST_PAGE;
				
			}else{
				resultName = AMENDMENT_REQUEST_PAGE;
			}
			break;
		case RIDER:
			resultName = RIDER_REQUEST_PAGE;
			break;
		}
		return resultName;
	}

	/**
	 * This method is used to retrieve the section result page.
	 * @return
	 */
	protected String getSectionResultPage() {
		String resultName = null;
		InstrumentType instrumentType = InstrumentType.fromId(getRequestDetails().getInstrumentTypeId().intValue()); 
		switch(instrumentType) {
		case BANK_GUARANTEE:
			resultName = BANKGUARANTEE_SECTION_PAGE;
			break;
		case LOC:
			resultName = BANKGUARANTEE_SECTION_PAGE;
			break;
		case SURETY_BOND:
			resultName = SURETYBOND_SECTION_PAGE;
			break;
		case DOCUMENT_LOC:
			resultName = DOCLOC_SECTION_PAGE;
			break;
		case AMENDMENT:
			resultName = AMENDMENT_SECTION_PAGE;
			break;
		case RIDER:
			resultName = RIDER_SECTION_PAGE;
			break;
		}
		return resultName;
	}


	/**
	 * This is used to do the validation on the each section.
	 * @return
	 */
	protected boolean isRequestForValidateSection() {
		return ActionContext.getContext().getActionInvocation().getProxy().getMethod().equals(APPLY_SECTION);
	}

	/**
	 * This method is used to change editMode for taxonomy
	 */
	protected boolean isTaxonomyPage() {
		boolean result = false;
		if(ActionContext.getContext().getActionInvocation().getProxy().getMethod().equals(UPDATETAXONOMY)){
			editMode = false;
			taxonomyViewType = ALOCConstants.OPENREQUEST;
			result = true;
		}else if(ActionContext.getContext().getActionInvocation().getProxy().getMethod().equals(ALOCConstants.ISSUANCE_SAVE)){
			editMode = false;
			taxonomyViewType = ALOCConstants.ISSUER;
			result = true;
		}
		return result;
	}
	
	/**
	 * This method is used to decide the INPUT page of Taxonomy
	 */
	protected String returnTaxonomyPage() {
		int instrumentTypeId = getRequestDetails().getInstrumentTypeId().intValue();
			if(InstrumentType.DOCUMENT_LOC.getId()==instrumentTypeId){
				return ALOCConstants.DLOC_INPUT;
			}else if(InstrumentType.SURETY_BOND.getId()==instrumentTypeId){
				return ALOCConstants.SB_INPUT;
			}else if(InstrumentType.RIDER.getId()==instrumentTypeId){
				return "riderInput";
			}else if(InstrumentType.AMENDMENT.getId()==instrumentTypeId){
				if(StringUtils.isNotBlank(getRequestDetails().getAmendment().getAmendmentType()) 
						&& ALOCConstants.Y_CAP.equalsIgnoreCase(getRequestDetails().getAmendment().getAmendmentType().trim())){
					return "autoAmendmentInput";
					
				}else{
					return "amendmentInput";
				}
				
				
			}
		return INPUT;
	}

	/** 
	 * This method is used to get the amendment details for the taxonomy
	 * @return resultPage value
	 * @throws HWFServiceException
	 */
	public String getAmendments() throws HWFServiceException {
		String resultPage = null;
		if(requestId!=null){
			validateRequest();
			GetAmendmentRiders amendments = requestDetailsManager.getAmendments(requestId);
			amendsLst = amendments.getAmendmentDetails();
			resultPage= getRequestResultPage();
			taxonomyViewType = ALOCConstants.AMENDMENTS;
		}
		return resultPage;
	}
	
	/** 
	 * This method is used to get the attachments details for the request
	 * @return 
	 * @throws HWFServiceException
	 */
	public String getRequestorAtmt() throws HWFServiceException {
		HttpSession session = ServletActionContext.getRequest().getSession();
		if(requestId != null){
			validateRequest();
			if(instrumentId != null &&(instrumentId.intValue() == InstrumentType.BANK_GUARANTEE.getId() ||
					instrumentId.intValue() == InstrumentType.LOC.getId())){
				requestDetailsBO = requestDetailsManager.openRequest(requestId);
			}
		}
		@SuppressWarnings("unchecked")
		List<Attachment> newtaxonomyAtmtsLst = (List<Attachment>) session.getAttribute(ALOCConstants.TAXONOMY_REQUEST_ATTACHMENTS);
		String resultPage = null;
		if(newtaxonomyAtmtsLst!=null){
			taxonomyAtmtsLst = newtaxonomyAtmtsLst;
		}
		resultPage= getRequestResultPage();
		taxonomyViewType = ALOCConstants.OPENREQUEST;
		issuanceflag = ALOCConstants.YES;
		return resultPage;
	}
	
	/**
	 * This method is used to get the Rider details for the taxonomy
	 * @return resultPage value
	 * @throws HWFServiceException
	 */
	public String getRiders() throws HWFServiceException {
		String resultPage = null;
		if(requestId!=null){
			validateRequest();
			GetAmendmentRiders riders = requestDetailsManager.getRiders(requestId);
			ridersLst = riders.getRiderDetails();
			resultPage= getRequestResultPage();
			taxonomyViewType = ALOCConstants.RIDERS;
		}
		return resultPage;
	}

	/**
	 * This method is used to get the Link Transaction Details
	 * @return resultPage value
	 * @throws HWFServiceException
	 */
	public String getLinkTansactions() throws HWFServiceException {
		String resultPage = null;
		try{
			if(requestId!=null){
				validateRequest();
				requestDetailsList  =  linkTransactionManager.loadLinkTransactions(requestId.toString()).getRequestDetails();
			}
		}catch(HWFServiceException hse){
			if(StringUtils.isNotBlank(hse.getReason())){
				addActionMessage(hse.getReason());	
			}else{
				addActionMessage(hse.getCode());
			}
		}
		resultPage= getRequestResultPage();
		taxonomyViewType = ALOCConstants.LINKTRANSACTIONS;
		return resultPage;
	}

	
	/**
	 * This method is used to get the BUNDLE Transaction Details
	 * @return resultPage value
	 * @throws HWFServiceException
	 */
	public String getBundleTansactions() throws HWFServiceException {
		String resultPage = null;
		try{
			if(requestId!=null && requestDetailsBO.getModel()!=null && requestDetailsBO.getModel().getBundleDetails()!=null 
					&& requestDetailsBO.getModel().getBundleDetails().getBundleId()!=null){
				validateRequest();
				String bundleId = requestDetailsBO.getModel().getBundleDetails().getBundleId().toString();
				requestDetailsList  =  createBundleManager.getRequestsForBundle(bundleId);
			}
		}catch(HWFServiceException hse){
			if(StringUtils.isNotBlank(hse.getReason())){
				addActionMessage(hse.getReason());	
			}else{
				addActionMessage(hse.getCode());
			}
		}
		resultPage= getRequestResultPage();
		taxonomyViewType = ALOCConstants.BUNDLETRANSACTIONS;
		return resultPage;
	}
	
	/**
	 * This method is used to get the Fee History details for the Taxonomy
	 * @return resultPage value
	 * @throws HWFServiceException
	 */
	public String getFeeHistory() throws HWFServiceException {
		String resultPage = null;
		try{
			if(requestId!=null){
				validateRequest();
				FeeHistoryDetails  feeHistDet = requestDetailsManager.getFeeHistory(requestId);
				if(feeHistDet!=null){
					feeHistLst = feeHistDet.getFullSummaries();
				}
			}
		}catch(HWFServiceException hse){						
			if(StringUtils.isNotBlank(hse.getReason())){
				addActionMessage(hse.getReason());	
			}else{
				addActionMessage(hse.getCode());
			}		}
		resultPage= getRequestResultPage();
		taxonomyViewType = ALOCConstants.FEEHISTORY;
		return resultPage;
	}
	
	/**
	 * This method is used to check the multiple tabs
	 * @return resultPage value
	 * @throws HWFServiceException
	 */
	public void validateRequest() throws HWFServiceException {
		requestDetailsBO = ALOCContext.getActiveRequest();
		String activeRequestId;
		if(requestDetailsBO != null && requestDetailsBO.getModel().getInstrumentTypeId()!=null && requestDetailsBO.getModel().getInstrumentTypeId().intValue()==InstrumentType.AMENDMENT.getId()){
			activeRequestId=requestDetailsBO.getModel().getAmendment().getAmendmentRequestId();
		}else if(requestDetailsBO != null && requestDetailsBO.getModel().getInstrumentTypeId()!=null && requestDetailsBO.getModel().getInstrumentTypeId().intValue()==InstrumentType.RIDER.getId()){
			activeRequestId=requestDetailsBO.getModel().getRider().getRiderRequestId();
		}else{
		 activeRequestId = requestDetailsBO != null ? requestDetailsBO.getModel().getRequestId()!=null ? requestDetailsBO.getModel().getRequestId().toString() :null : null;
		}
		if(requestDetailsBO.getModel().getInstrumentTypeId()!=null && (requestDetailsBO.getModel().getInstrumentTypeId().intValue()==InstrumentType.AMENDMENT.getId() || requestDetailsBO.getModel().getInstrumentTypeId().intValue()==InstrumentType.RIDER.getId())){
		if(StringUtils.isBlank(activeRequestId) || (StringUtils.isNotBlank(activeRequestId) && StringUtils.isNotBlank(amendmentOrRiderRequestId) && !activeRequestId.equalsIgnoreCase(amendmentOrRiderRequestId))){
			throw new ALOCRuntimeException(ALOCRuntimeException.EC_ACTIVEREQUEST_NOTFOUND);
			}
		}else if(StringUtils.isBlank(activeRequestId) || (StringUtils.isNotBlank(activeRequestId) && requestId!=null && !activeRequestId.equalsIgnoreCase(requestId.toString()))){
			throw new ALOCRuntimeException(ALOCRuntimeException.EC_ACTIVEREQUEST_NOTFOUND);
		}
	}
	
	/**
	 * This method is used to get the Fee History details for the Taxonomy
	 * @return resultPage value
	 * @throws HWFServiceException
	 */
	public String getCompBidReplies() throws HWFServiceException {
		String resultPage = null;
		try{
			if(requestId!=null){
				validateRequest();
				comBidReplies = requestDetailsManager.getCompBidReplies(requestId);
				if(comBidReplies != null && comBidReplies.getParticipantBanks() != null){
					comBidReplies = ALOCCommonHelper.getCompetingBidValuesAsString(comBidReplies);
				}
			}
		}catch(HWFServiceException hse){						
			if(StringUtils.isNotBlank(hse.getReason())){
				addActionMessage(hse.getReason());	
			}else{
				addActionMessage(hse.getCode());
			}   
		}
		resultPage= getRequestResultPage();
		taxonomyViewType = ALOCConstants.COMBIDREPLIES;
		return resultPage;
	}

	/**
	 * This method is used to get the Fee History details for the Taxonomy
	 * @return resultPage value
	 * @throws HWFServiceException
	 */
	public String getCurrBankFees() throws HWFServiceException {
		String resultPage = null;
		try{
			if(requestId!=null){
				validateRequest();
				comBidReplies = requestDetailsManager.getCurrBankFees(requestId);
				if(comBidReplies!=null && comBidReplies.getCurrentWinningBank()!=null){
					if(comBidReplies.getCurrentWinningBank().getAllinComissions()!=null && comBidReplies.getCurrentWinningBank().getAllinComissions().getAllinCommissionValue()!=null){
						allInCommissionsValue = comBidReplies.getCurrentWinningBank().getAllinComissions().getAllinCommissionValue().toString();
					}
					if(comBidReplies.getCurrentWinningBank().getLocalComissions()!=null && comBidReplies.getCurrentWinningBank().getLocalComissions().getLocalCommissionValue()!=null){
						localCommissionsValue = comBidReplies.getCurrentWinningBank().getLocalComissions().getLocalCommissionValue().toString();
					}
					if(comBidReplies.getAuditLogs()!=null){
						ActionContext.getContext().getSession().put(ALOCConstants.CURRBANKFEES_AUDITLOG,comBidReplies.getAuditLogs());
					}
				}
			}
		}catch(HWFServiceException hse){						
			if(StringUtils.isNotBlank(hse.getReason())){
				addActionMessage(hse.getReason());	
			}else{
				addActionMessage(hse.getCode());
			}	
		}
		resultPage= getRequestResultPage();
		taxonomyViewType = ALOCConstants.CURRBANKFEE;
		return resultPage;
	}

	/**
	 * This method is used to get the Fee History details for the Taxonomy
	 * @return resultPage value
	 * @throws HWFServiceException
	 */
	public String saveCurrBankFees() throws HWFServiceException {
		HttpSession session = ServletActionContext.getRequest().getSession();
		try{
			if(requestId != null){
				validateRequest();
				comBidReplies.setAlocRequestId(requestId);
				comBidReplies = ALOCCommonHelper.setAllInLocalCommValues(comBidReplies,allInCommissionsValue,localCommissionsValue);
				comBidReplies = requestDetailsManager.saveCurrBankFees(comBidReplies);
				session.setAttribute(ALOCConstants.SUCCESSMSG, ALOCConstants.CURR_BANKFEES_SUCCESS_MSG);
			}
		}catch(HWFServiceException hse){						
			if(StringUtils.isNotBlank(hse.getReason())){
				addActionMessage(hse.getReason());	
			}else{
				addActionMessage(hse.getCode());
			}
			return getRequestResultPage();
		}
		return ActionSupport.SUCCESS;
	}

	/**
	 * This method is used to update Taxonomy Transaction Parties fields
	 * @return resultPage value
	 * @throws HWFServiceException
	 */
	public String updateTaxonomy() throws HWFServiceException {
		String resultPage = null;
		RequestDetails requestDetails = null;
		HttpSession session = ServletActionContext.getRequest().getSession();
		if(requestId!=null){
			validateRequest();
			requestDetails = requestDetailsManager.updateTaxonomy();
			resultPage= getRequestResultPage();
			taxonomyViewType = ALOCConstants.OPENREQUEST;
		}
		session.setAttribute(ALOCConstants.SUCCESSMSG, requestDetails.getComments());
		return resultPage;
	}
	
	/**
	 * This method is used to get the Audit Log Details
	 * @return
	 * @throws HWFServiceException
	 */
	public String getAuditLog() throws HWFServiceException {
		taxonomyViewType = ALOCConstants.AUDITLOG;
		return getRequestResultPage();
	}
	
	/**
	 * This method is used to get the Transaction Log Details
	 * @return
	 * @throws HWFServiceException
	 */
	public String getTransactionLog() throws HWFServiceException {
		taxonomyViewType = ALOCConstants.TRANSACTIONLOG;
		return getRequestResultPage();
	}
	
	/**
	 * This method is used to get the Transaction Log Details
	 * @return
	 * @throws HWFServiceException
	 */
	public String getIssuer() throws HWFServiceException {
		taxonomyViewType = ALOCConstants.ISSUER;
		List<AttachmentBO>  attachmentBOList= requestDetailsBO.getAttachmentBOList();
		int index=0;
		if(requestDetailsBO.getModel().getAttachments()!=null){
		for(Attachment attachment : requestDetailsBO.getModel().getAttachments()) {				
			if(((attachment.getAttachmentTypeId() != null && attachment.getAttachmentTypeId().intValue() == AttachmentType.ISSUER.getId()))) {
				attachmentBOList.get(index).setIssuanceBankRefNo(attachment.getIssuanceBankRefNo());
				attachmentBOList.get(index).setIssuanceDate(attachment.getIssuanceDate());
				attachmentBOList.get(index).setIssuanceDesc(attachment.getIssuanceDesc());
				attachmentBOList.get(index).setIssuanceDocType(attachment.getIssuanceDocTypeId()!=null?attachment.getIssuanceDocTypeId().toString():null);
				attachmentBOList.get(index).setIssuanceDocId(attachment.getIssuanceDocTypeId()!=null?attachment.getIssuanceDocTypeId().intValue():null);
				attachmentBOList.get(index).setIssuanceDocument(attachment.getIssuanceDocument());
			}
			index++;
		}
			}
		return getRequestResultPage();
	}
	
	/**
	 * This method is used to get the Transaction Log Details
	 * @return
	 * @throws HWFServiceException
	 */
	public String getClosure() throws HWFServiceException {
		taxonomyViewType = ALOCConstants.CLOSURE;
		HttpSession session = ServletActionContext.getRequest().getSession();
		@SuppressWarnings("unchecked")
		List<Attachment> taxonomyClosureAtmt = (List<Attachment>) session.getAttribute(ALOCConstants.TAXONOMY_CLOSURE_ATTACHMENTS);
		if(taxonomyClosureAtmt != null){
			taxonomyClosureAtmts =taxonomyClosureAtmt;
		}
		return getRequestResultPage();
	}
	
	/**
	 * This method is used to get the Transaction Log Details
	 * @return
	 * @throws HWFServiceException
	 */
	public String getReportingData() throws HWFServiceException {
		taxonomyViewType = ALOCConstants.UPDATEDATA;
		try{
			if(requestId!=null){
				validateRequest();
				updateReportingData = requestDetailsManager.getReportingData(requestId);
				if(updateReportingData.getAuditLogs()!=null){
					ActionContext.getContext().getSession().put(ALOCConstants.UPDATEREPORTING_AUDITLOG,updateReportingData.getAuditLogs());
				}
			}
		}catch(HWFServiceException hse){						
			if(StringUtils.isNotBlank(hse.getReason())){
				addActionMessage(hse.getReason());	
			}else{
				addActionMessage(hse.getCode());
			}
			return getRequestResultPage();
		}
		return getRequestResultPage();
	}
	
	/**
	 * This method is used to get the Transaction Log Details
	 * @return
	 * @throws HWFServiceException
	 */
	public String updateReportingData() throws HWFServiceException {
		HttpServletRequest request = ServletActionContext.getRequest();
		taxonomyViewType = ALOCConstants.UPDATEDATA;
		try{
			if(updateReportingData!=null && requestId != null){
				validateRequest();
				String refNoCheck = null;
				ReferenceNumberValidation referenceNumberValidation = new ReferenceNumberValidation();
				referenceNumberValidation.setIssuanceDocTypeId(new BigInteger(ALOCConstants.DEFAULT_ISSUANCE_TYPE_ID));
				referenceNumberValidation.setReferenceNumber(updateReportingData.getBankReferenceNumber());
				referenceNumberValidation.setRequestId(requestDetailsBO.getModel().getRequestId());
				if(StringUtils.isNotBlank(referenceNumberValidation.getReferenceNumber())){
					ReferenceNumberValidation refNoValidation = requestDetailsManager.checkBankRefNumber(referenceNumberValidation);
					referenceNumberValidation.setStatusMessage(refNoValidation.getStatusMessage());
					refNoCheck = refNoValidation.getStatusMessage();
					if(refNoCheck != null && refNoCheck.equalsIgnoreCase(ALOCConstants.ISSUER_BANKREFNO_EXISTED)){
						addFieldError(ALOCConstants.ISSUER_ACTIONS_ERROR_FILED, ALOCConstants.ISSUER_BANKREFNO_ERROR_MSG);
						return returnTaxonomyPage();
					}
				}
				if(updateReportingData.getOldUSExpirationDate()!=null && updateReportingData.getUSExpirationDate()!=null && updateReportingData.getUSExpirationDate().compareTo(ALOCCommonHelper.getCurrentDateWithOutTime()) > 0 && updateReportingData.getUSExpirationDate().compareTo(updateReportingData.getOldUSExpirationDate())>0){
					updateReportingData.setExpChangeFlag(ALOCConstants.Y_CAP);
				}else if(updateReportingData.getForeignExpirationDate()!=null && updateReportingData.getOldForeignExpirationDate()!=null && updateReportingData.getForeignExpirationDate().compareTo(ALOCCommonHelper.getCurrentDateWithOutTime()) > 0 && updateReportingData.getForeignExpirationDate().compareTo(updateReportingData.getOldForeignExpirationDate())>0 ){
					updateReportingData.setExpChangeFlag(ALOCConstants.Y_CAP);
				}
				updateReportingData = requestDetailsManager.updateReportingData(updateReportingData);
			}
		}catch(HWFServiceException hse){						
			if(StringUtils.isNotBlank(hse.getReason())){
				addActionMessage(hse.getReason());	
			}else{
				addActionMessage(hse.getCode());
			}
			return returnTaxonomyPage();
		}
		request.setAttribute(ALOCConstants.SUCCESSMSG, updateReportingData.getMsgHeader() != null ?
				updateReportingData.getMsgHeader().getStatus() : ALOCConstants.EMPTY_STRING);
		return getRequestResultPage();
	}

	
	/**
	 * This method is used to retrive the model request result page based on the instrument type.
	 * @return
	 */
	protected String getModelRequestResultPage() {
		String resultName = null;
		InstrumentType instrumentType = InstrumentType.fromId(getRequestDetails().getInstrumentTypeId().intValue()); 
		switch(instrumentType) {
		case BANK_GUARANTEE:
			resultName = BANKGUARANTEE_MODEL_REQUEST_PAGE;
			break;
		case LOC:
			resultName = LOC_MODEL_REQUEST_PAGE;
			break;
		case SURETY_BOND:
			resultName = SURETYBOND_MODEL_REQUEST_PAGE;
			break;
		}
		return resultName;
	}

	/**
	 * This method is used to get the selected Model Details
	 * @return
	 * @throws HWFServiceException
	 */
	public String openModelRequest() throws HWFServiceException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String requestId = request.getParameter(MODEL_REQUEST_ID);
		if(requestId!=null){
			requestDetailsBO = requestDetailsManager.openModelRequest(requestId);
		}
		return ALOCConstants.SUCCESS;
	}

	/**
	 * This method is used to save the Modified Model details
	 * @return
	 * @throws HWFServiceException
	 */
	public String saveModel(List<String> rightSelSites) throws HWFServiceException {
		HttpSession session = ServletActionContext.getRequest().getSession();
		RequestDetails requestDetails = requestDetailsManager.saveModel(rightSelSites);
		session.setAttribute(ALOCConstants.SUCCESSMSG, requestDetails.getComments());
		return ALOCConstants.SUCCESS;
	}

	/**
	 * This method is used to Clone the Request details
	 * @return
	 * @throws HWFServiceException
	 */
	public String cloneRequest() throws HWFServiceException {
		RequestDetails requestDetails = requestDetailsManager.getRequest(requestId);
		requestDetailsManager.createRequest(requestDetails.getInstrumentTypeId().toString(),requestDetails.getInstrumentType(), requestDetails.getSiteId().toString(),requestDetails.getSiteName(),modelId);
		requestDetailsBO = ALOCContext.getActiveRequest();
		RequestDetails cloneRequestDetails = requestDetailsBO.getModel();
		if(requestDetails.getInstrumentType().equalsIgnoreCase(BANKGUARANTEE) || requestDetails.getInstrumentType().equalsIgnoreCase(STANDBY_LETTER_OF_CREDIT))
		{
			cloneRequestDetails = ALOCCommonHelper.bgSblcClone(requestDetails, cloneRequestDetails, true);

		}else if(requestDetails.getInstrumentType().equalsIgnoreCase(SURETY_BOND))
		{
			cloneRequestDetails = ALOCCommonHelper.suretyBondClone(requestDetails, cloneRequestDetails, true);

		}else if(requestDetails.getInstrumentType().equalsIgnoreCase(DOCUMENTARY_LETTER_OF_CREDIT_CONFIRMATION))
		{
			cloneRequestDetails = ALOCCommonHelper.dlocClone(requestDetails, cloneRequestDetails, true);		
		} 		
		editMode=true;
		return getRequestResultPage();
	}

	/**
	 * This method is used to save the request details and make current request as active request.
	 * @return
	 */
	public String saveRequestDetails() throws HWFServiceException {
		RequestDetails requestDetails = requestDetailsSectionManager.saveRequestDetails();
		RequestDetailsBO requestDetailsBO = new RequestDetailsBO(requestDetails);
		ALOCContext.setActiveRequest(requestDetailsBO);
		return SUCCESS;
	}

	/**
	 * This method is used to get the full audit and action log Details
	 * @throws HWFServiceException
	 * @return
	 * 
	 */
	public String getFullAuditAndActionLog() throws HWFServiceException{	
		
		RequestDetails  requestDetail = new RequestDetails();
		requestDetail = requestDetailsSectionManager.getFullAuditandActionLog(stageName,logType,requestId,requestDetail);
		
		if(logType.equalsIgnoreCase(ALOCConstants.ACTION)){
			if(requestDetail.getActionLogs()!=null){
				ALOCContext.getActiveRequest().getModel().setActionLogs(requestDetail.getActionLogs());
			}
			if(requestDetail.getActionDrawDownValues()!=null){
				ActionDrawDownValues drawDownValues=new ActionDrawDownValues();
				if(requestDetail.getActionDrawDownValues().getActions()!=null){
					drawDownValues.setActions(requestDetail.getActionDrawDownValues().getActions());
				}
				if(requestDetail.getActionDrawDownValues().getActionTakenBies()!=null){
					drawDownValues.setActionTakenBies(requestDetail.getActionDrawDownValues().getActionTakenBies());
				}
				ALOCContext.getActiveRequest().getModel().setActionDrawDownValues(drawDownValues);
			}
			return ALOCConstants.ACTION;
		}
		else{
			if(requestDetail.getAuditLogs()!=null){
				ALOCContext.getActiveRequest().getModel().setAuditLogs(requestDetail.getAuditLogs());
			}
			if(requestDetail.getDrawDownValues()!=null){
				DrawDownValues drawDownvalues=new DrawDownValues();
				if(requestDetail.getDrawDownValues().getActionTakenBies()!=null){
					drawDownvalues.setActionTakenBies(requestDetail.getDrawDownValues().getActionTakenBies());
				}
				if(requestDetail.getDrawDownValues().getAttributeChangeds()!=null){
					drawDownvalues.setAttributeChangeds(requestDetail.getDrawDownValues().getAttributeChangeds());
				}
				ALOCContext.getActiveRequest().getModel().setDrawDownValues(drawDownvalues);
			}
			return ALOCConstants.AUDIT;
		}
	}
	
	/**
	 * Method to set the Hour/Minute/Period Details
	 * @param requestDetails
	 * @return
	 */
	protected void setCalendarDetails(RequestDetails requestDetails){
		if(requestDetails!=null && requestDetails.getBidmemoDetails()!=null){
			String expTime = requestDetails.getBidmemoDetails().getExpirationTime();
			int baseVal = ALOCConstants.BASE_VALUE;
			int minVal = ALOCConstants.MIN_VALUE;
			int secondVal = ALOCConstants.SECOND_VALUE;
			if(StringUtils.isNotBlank(expTime)){
				String[] time = expTime.split(ALOCConstants.COMMA);
				minutes = time.length > baseVal ? time[baseVal] : ALOCConstants.EMPTY_STRING;
				hours = time.length > minVal ? time[minVal] : ALOCConstants.EMPTY_STRING;
				period = time.length > secondVal ? time[secondVal] : ALOCConstants.EMPTY_STRING;
			}
			if(StringUtils.isNotBlank(hours)){
				int hoursIntVal = Integer.parseInt(hours);
				if(hoursIntVal >= ALOCConstants.MIN_HOURS  && hoursIntVal < ALOCConstants.MAX_HOURS)
					hours = ALOCConstants.BASE_VALUE+hours;
			}
			if(StringUtils.isNotBlank(minutes)){
				int minutesIntVal = Integer.parseInt(minutes);
				if(minutesIntVal >= ALOCConstants.MIN_MINUTES  && minutesIntVal < ALOCConstants.MAX_MINUTES)
					minutes = ALOCConstants.BASE_VALUE+minutes;
			}
		}
	}	
	
	/**
	 * Method to set the attachments to download at issuer level
	 * @param requestDetails
	 * @return
	 */
	protected void setAttachmentsToRequestByStage(RequestDetails requestDetails){
		String roleName = (requestDetails.getMsgHeader() != null) ? requestDetails.getMsgHeader().getRoleName() : null;
		if(WorkflowStage.TREASURYBIDISSUE.getName().equals(stageName)
				|| WorkflowStage.COMPLETE.getName().equals(stageName)
				|| WorkflowStage.BANKISUE.getName().equals(stageName)){//This is for amendment and rider
			List<Attachment> atmtsTempList = new ArrayList<Attachment>();
			List<Attachment> atmtsList = new ArrayList<Attachment>();
			taxonomyAtmtsLst = new ArrayList<Attachment>();
			taxonomyClosureAtmts = new ArrayList<Attachment>();
			if(requestDetails.getAttachments() != null && requestDetails.getAttachments().size() > ALOCConstants.MIN_SIZE) {
				for(Attachment attachment : requestDetails.getAttachments()) {
					if(((WorkflowStage.TREASURYBIDISSUE.getName().equals(stageName) ||  WorkflowStage.BANKISUE.getName().equals(stageName)) && attachment.getAttachmentTypeId().intValue() == AttachmentType.ISSUER.getId())
					|| ((WorkflowStage.COMPLETE.getName().equals(stageName)) && attachment.getAttachmentTypeId().intValue() == AttachmentType.CLOSURE.getId())
					||(issuanceflag!=null &&issuanceflag.equals(ALOCConstants.YES) && WorkflowStage.COMPLETE.getName().equals(stageName) && attachment.getAttachmentTypeId().intValue() == AttachmentType.ISSUER.getId()) 
					|| (StringUtils.isBlank(issuanceflag) && dashboardViewType != null && dashboardViewType.name()== ALOCConstants.ALLREQUESTS && attachment.getAttachmentTypeId().intValue() == 3)
					) {
						if(attachment.getAttachmentTypeId().intValue() == AttachmentType.CLOSURE.getId()){
							boolean permissionsStatus = checkUserPermissionsToDownloadAtmts(attachment);
							if(permissionsStatus){
								taxonomyClosureAtmts.add(attachment);
								ActionContext.getContext().getSession().put(ALOCConstants.TAXONOMY_CLOSURE_ATTACHMENTS, taxonomyClosureAtmts);
							}
						}else{
							atmtsTempList.add(attachment);
						}
					}else{
							boolean permissionsStatus = checkUserPermissionsToDownloadAtmts(attachment);
							if(permissionsStatus){
								atmtsList.add(attachment);
								taxonomyAtmtsLst.add(attachment);
							}
					}
				}
				
				if(!atmtsList.isEmpty()){
					issuerDownloadAtmts= true;
					ActionContext.getContext().getSession().put(requestDetails.getRequestId()+ALOCConstants.UNDERSCORE+ALOCConstants.ROLE_BASED_ATTACHMENT_DOWNLOAD, issuerDownloadAtmts);
				}
				
				if(!taxonomyAtmtsLst.isEmpty()){
					ActionContext.getContext().getSession().put(ALOCConstants.TAXONOMY_REQUEST_ATTACHMENTS, taxonomyAtmtsLst);
				}
				
				ActionContext.getContext().getSession().put(requestDetails.getRequestId()+ALOCConstants.UNDERSCORE+ALOCConstants.ATTACHMENTS_BY_TYPE, atmtsList);
				
				if(WorkflowStage.TREASURYBIDISSUE.getName().equals(stageName) 
						||  WorkflowStage.BANKISUE.getName().equals(stageName)
						||(issuanceflag!=null && issuanceflag.equals(ALOCConstants.YES) 
						&& !WorkflowStage.COMPLETE.getName().equals(stageName))) {
					if(atmtsTempList.size() == ALOCConstants.MIN_VALUE) {
						Attachment atmt = atmtsTempList.get(ALOCConstants.BASE_VALUE);
						if(requestDetails.getBidReplyDetails().getIssuanceTypeFlag() != null && ALOCConstants.ISSUANCE_TYPE_INDIRECT.equalsIgnoreCase(requestDetails.getBidReplyDetails().getIssuanceTypeFlag())) {
							Attachment newAtmt = new Attachment();
							newAtmt.setAttachmentTypeId(new BigInteger(ALOCConstants.DOCTYPE_ISSUER));
							
							if(atmt.getIssuanceDocTypeId().intValue() == ALOCConstants.MIN_VALUE) {
								newAtmt.setIssuanceDocTypeId(new BigInteger(ALOCConstants.DOCTYPE_OTHER));
								newAtmt.setIssuanceDocType(ALOCConstants.DOCTYPE_OTHER);
								atmtsTempList.add(ALOCConstants.BASE_VALUE, newAtmt);
							} else {
								newAtmt.setIssuanceDocTypeId(new BigInteger(ALOCConstants.DOCTYPE_FORMAT));
								newAtmt.setIssuanceDocType(ALOCConstants.DOCTYPE_FORMAT);
								atmtsTempList.add(newAtmt);
							}
						}
					} else if(atmtsTempList.size() == ALOCConstants.SECOND_VALUE) {
						if(atmtsTempList.get(ALOCConstants.BASE_VALUE).getIssuanceDocTypeId().intValue() == ALOCConstants.MIN_VALUE) {
							Attachment atmt = atmtsTempList.remove(ALOCConstants.BASE_VALUE);
							atmtsTempList.add(atmt);
						}
					}
				}
			
			
			}
			if(issuanceflag!=null &&issuanceflag.equals(ALOCConstants.YES)){
				atmtsTempList = setTaxonomyIssuerAtmts(atmtsTempList);
			}
			
			requestDetailsBO.getModel().setAttachments(atmtsTempList);
			atmtsTempList= null;
		}else if(((WorkflowStage.TREASURYANALYST.getName().equals(stageName)||WorkflowStage.TRESEDIT.getName().equals(stageName))
					&& roleName != null&&(roleName.equalsIgnoreCase(UserRole.TreasuryAnalyst.getName())||roleName.equalsIgnoreCase(UserRole.TreasuryApprover.getName())))
					&& requestDetails.getAttachments() != null	&& requestDetails.getAttachments().size()>ALOCConstants.BASE_VALUE) {
			List<Attachment> atmtsList = new ArrayList<Attachment>();
			
			for(Attachment attachment : requestDetails.getAttachments()) {
				if(attachment.getAttachmentTypeId().intValue() == AttachmentType.OTHER.getId()){
					if(!attachment.getAttachmentPermissions().isEmpty()){
						for(AttachmentPermission atmtPermissions : attachment.getAttachmentPermissions()){
							if(StringUtils.isNotBlank(atmtPermissions.getPermissionId())&&Integer.valueOf(atmtPermissions.getPermissionId())==ALOCConstants.MIN_VALUE){
								atmtsList.add(attachment);
								break;
							}
						}
					}
				}else{
					atmtsList.add(attachment);
				}
			}
			requestDetailsBO.getModel().setAttachments(atmtsList);
		}
	}	
	
	/**
	 * This method is to set the attachments at issuer taxonomy level
	 * @param atmtsTempList
	 * @return
	 */
	private List<Attachment> setTaxonomyIssuerAtmts(List<Attachment> atmtsTempList) {
		List<Attachment> newAtmtsTempList = new ArrayList<Attachment>();
		List<IssunaceDocType> issuanceDocLst = requestDetailsBO.getModel().getIssunaceDocTypes();
		String issuanceTypeFlag = requestDetailsBO.getModel().getBidReplyDetails().getIssuanceTypeFlag();
		if(issuanceTypeFlag != null && issuanceTypeFlag.equalsIgnoreCase(ALOCConstants.ISSUANCE_TYPE_INDIRECT)){
		Boolean atmtflag=false;
		int size=ALOCConstants.BASE_VALUE;
		if(atmtsTempList != null && atmtsTempList.size() == ALOCConstants.SECOND_VALUE && issuanceDocLst == null){
			return atmtsTempList;
		}else if(atmtsTempList != null && atmtsTempList.size()>ALOCConstants.BASE_VALUE){
			for(Attachment atmt : atmtsTempList){
				if(atmt.getIssuanceDocTypeId() != null && atmt.getIssuanceDocTypeId().intValue() == ALOCConstants.SECOND_VALUE){
					newAtmtsTempList.add(atmt);
					atmtflag = true;
					size++;
				}else if(atmtflag==true && atmt.getIssuanceDocTypeId() != null 
						&& (atmt.getIssuanceDocTypeId().intValue() == ALOCConstants.MIN_VALUE 
						|| atmt.getIssuanceDocTypeId().intValue() == ALOCConstants.THIRD_VALUE)){
					newAtmtsTempList.add(atmt);
					size++;
				}
				if(size==ALOCConstants.SECOND_VALUE){
					return newAtmtsTempList;
				}
			}
		}
		if(size<ALOCConstants.SECOND_VALUE && issuanceDocLst != null && issuanceDocLst.size()>ALOCConstants.BASE_VALUE){
			for(IssunaceDocType issuanceDoc : issuanceDocLst){
				if(issuanceDoc.getIssuerDocTypeId() != null && issuanceDoc.getIssuerDocTypeId().intValue() == ALOCConstants.SECOND_VALUE){
					Attachment docTypeAtmt = new Attachment();
					docTypeAtmt.setIssuanceBankRefNo(issuanceDoc.getReferenceNum());
					docTypeAtmt.setIssuanceDate(issuanceDoc.getIssueDt());
					docTypeAtmt.setIssuanceDesc(issuanceDoc.getIssuanceDesc());
					docTypeAtmt.setIssuanceDocType(issuanceDoc.getIssuerDocTypeName());
					docTypeAtmt.setIssuanceDocTypeId(issuanceDoc.getIssuerDocTypeId());
					docTypeAtmt.setIssuanceDocument(issuanceDoc.getIssuanceDocument());
					docTypeAtmt.setAttachmentTypeId(BigInteger.valueOf(AttachmentType.ISSUER.getId()));
					docTypeAtmt.setAttachmentType(AttachmentType.ISSUER.getName());
					newAtmtsTempList.add(docTypeAtmt);
					size++;
					atmtflag=true;
				}else if(atmtflag==true && issuanceDoc.getIssuerDocTypeId() != null && issuanceDoc.getIssuerDocTypeId().intValue() == ALOCConstants.MIN_VALUE || issuanceDoc.getIssuerDocTypeId().intValue() == ALOCConstants.THIRD_VALUE){
					Attachment docTypeAtmt = new Attachment();
					docTypeAtmt.setIssuanceBankRefNo(issuanceDoc.getReferenceNum());
					docTypeAtmt.setIssuanceDate(issuanceDoc.getIssueDt());
					docTypeAtmt.setIssuanceDesc(issuanceDoc.getIssuanceDesc());
					docTypeAtmt.setIssuanceDocType(issuanceDoc.getIssuerDocTypeName());
					docTypeAtmt.setIssuanceDocTypeId(issuanceDoc.getIssuerDocTypeId());
					docTypeAtmt.setIssuanceDocument(issuanceDoc.getIssuanceDocument());
					docTypeAtmt.setAttachmentTypeId(BigInteger.valueOf(AttachmentType.ISSUER.getId()));
					docTypeAtmt.setAttachmentType(AttachmentType.ISSUER.getName());
					newAtmtsTempList.add(docTypeAtmt);
					size++;
				}
				if(size==ALOCConstants.SECOND_VALUE){
					return newAtmtsTempList;
				}
			}
		}
		if(atmtsTempList != null && atmtsTempList.size()>ALOCConstants.BASE_VALUE){
			for(Attachment atmt : atmtsTempList){
				 if(atmt.getIssuanceDocTypeId() != null && (atmt.getIssuanceDocTypeId().intValue() == ALOCConstants.MIN_VALUE || atmt.getIssuanceDocTypeId().intValue() == ALOCConstants.THIRD_VALUE)){
					newAtmtsTempList.add(atmt);
					size++;
				}
				if(size==ALOCConstants.SECOND_VALUE){
					return newAtmtsTempList;
				}
			}
		}
		if(size<ALOCConstants.SECOND_VALUE && issuanceDocLst != null && issuanceDocLst.size()>ALOCConstants.BASE_VALUE){
			for(IssunaceDocType issuanceDoc : issuanceDocLst){
				 if(issuanceDoc.getIssuerDocTypeId() != null && issuanceDoc.getIssuerDocTypeId().intValue() == ALOCConstants.MIN_VALUE || issuanceDoc.getIssuerDocTypeId().intValue() == ALOCConstants.THIRD_VALUE){
					Attachment docTypeAtmt = new Attachment();
					docTypeAtmt.setIssuanceBankRefNo(issuanceDoc.getReferenceNum());
					docTypeAtmt.setIssuanceDate(issuanceDoc.getIssueDt());
					docTypeAtmt.setIssuanceDesc(issuanceDoc.getIssuanceDesc());
					docTypeAtmt.setIssuanceDocType(issuanceDoc.getIssuerDocTypeName());
					docTypeAtmt.setIssuanceDocTypeId(issuanceDoc.getIssuerDocTypeId());
					docTypeAtmt.setIssuanceDocument(issuanceDoc.getIssuanceDocument());
					docTypeAtmt.setAttachmentTypeId(BigInteger.valueOf(AttachmentType.ISSUER.getId()));
					docTypeAtmt.setAttachmentType(AttachmentType.ISSUER.getName());
					newAtmtsTempList.add(docTypeAtmt);
					size++;
					if(size==ALOCConstants.SECOND_VALUE){
						return newAtmtsTempList;
					}
				}
			}
		}
		if(newAtmtsTempList.size()==ALOCConstants.MIN_VALUE){
			if(newAtmtsTempList.get(ALOCConstants.BASE_VALUE).getIssuanceDocTypeId() != null && newAtmtsTempList.get(ALOCConstants.BASE_VALUE).getIssuanceDocTypeId().intValue() == ALOCConstants.SECOND_VALUE){
				Attachment docTypeAtmt = new Attachment();
				docTypeAtmt.setIssuanceDocTypeId(BigInteger.valueOf(ALOCConstants.MIN_VALUE));
				docTypeAtmt.setIssuanceDocType(ALOCConstants.DOCTYPE_FORMAT);
				docTypeAtmt.setAttachmentTypeId(BigInteger.valueOf(AttachmentType.ISSUER.getId()));
				docTypeAtmt.setAttachmentType(AttachmentType.ISSUER.getName());
				newAtmtsTempList.add(docTypeAtmt);
				return newAtmtsTempList;
			}else{
				Attachment docTypeAtmt1 = new Attachment();
				docTypeAtmt1.setIssuanceDocTypeId(BigInteger.valueOf(ALOCConstants.SECOND_VALUE));
				docTypeAtmt1.setIssuanceDocType(ALOCConstants.DOCTYPE_OTHER);
				docTypeAtmt1.setAttachmentTypeId(BigInteger.valueOf(AttachmentType.ISSUER.getId()));
				docTypeAtmt1.setAttachmentType(AttachmentType.ISSUER.getName());
				newAtmtsTempList.add(ALOCConstants.BASE_VALUE,docTypeAtmt1);
				return newAtmtsTempList;
			}
		}
		}else{
			if(issuanceDocLst != null && issuanceDocLst.size()>ALOCConstants.BASE_VALUE){
				for(IssunaceDocType issuanceDoc : issuanceDocLst){
					if(issuanceDoc.getIssuerDocTypeId() != null){
						Attachment docTypeAtmt = new Attachment();
						docTypeAtmt.setIssuanceBankRefNo(issuanceDoc.getReferenceNum());
						docTypeAtmt.setIssuanceDate(issuanceDoc.getIssueDt());
						docTypeAtmt.setIssuanceDesc(issuanceDoc.getIssuanceDesc());
						docTypeAtmt.setIssuanceDocType(issuanceDoc.getIssuerDocTypeName());
						docTypeAtmt.setIssuanceDocTypeId(issuanceDoc.getIssuerDocTypeId());
						docTypeAtmt.setIssuanceDocument(issuanceDoc.getIssuanceDocument());
						docTypeAtmt.setAttachmentTypeId(BigInteger.valueOf(AttachmentType.ISSUER.getId()));
						docTypeAtmt.setAttachmentType(AttachmentType.ISSUER.getName());
						newAtmtsTempList.add(docTypeAtmt);
						return newAtmtsTempList;
					}
				}
				return atmtsTempList;
			}
		}
		return atmtsTempList;
	}

	/**
	 * Method is used to check the attachment download/view permissions
	 * @param attachment
	 */
	private boolean checkUserPermissionsToDownloadAtmts(Attachment attachment){
		List<String> userRoles = UserContext.getContext().getuserDetails().getRoles();
		List<AttachmentPermission> atmtPermissions = attachment.getAttachmentPermissions();
		boolean isBankRole = false;
		boolean isSuretyRole = false;
		boolean isTreasuryRole = false;
		boolean isBank = false;
		boolean isSurety = false;	
		boolean isTreasury = false;
		boolean isBusinessRole = false;
		if(userRoles.contains(UserRole.BankOperations.getName()) || userRoles.contains(UserRole.BankReadOnly.getName())){
			isBankRole = true;
		}
		else if(userRoles.contains(UserRole.SuretyBrokerOperations.getName()) || userRoles.contains(UserRole.SuretyBrokerReadOnly.getName())){
			isSuretyRole = true;
		}else if(userRoles.contains(UserRole.TreasuryAnalyst.getName()) || userRoles.contains(UserRole.TreasuryApprover.getName())){
			isTreasuryRole = true;
		}else { 
			isBusinessRole = true;
		}
		if(atmtPermissions!=null && !atmtPermissions.isEmpty()){
			for(AttachmentPermission permission : atmtPermissions) {
				if(permission.getPermissionId()!= null && permission.getPermissionId().equalsIgnoreCase(AtmtPermType.BANK.getId())) {
					isBank=true;
					isTreasury = true;
				}
				if(permission.getPermissionId()!= null && permission.getPermissionId().equalsIgnoreCase(AtmtPermType.Surety.getId())) {
					isSurety = true;
					isTreasury = true;
				}
				if(permission.getPermissionId()!= null && permission.getPermissionId().equalsIgnoreCase(AtmtPermType.TREASURY.getId())) {
					isTreasury = true;
				}
			}		
		}
		if((isBankRole && isBank) || (isSuretyRole && isSurety) || (isTreasuryRole && isTreasury) || isBusinessRole){
			return true;
		}
		else
		{
			return false;
		}		
	}	
	
	/**
	 * Method to set the Hour/Minute/Period Details for Bid Reply
	 * @param requestDetails
	 * @return
	 */
	protected void setBidReplyCalendarDetails(RequestDetails requestDetails){
		if (requestDetails != null) {
			if (requestDetails.getInstrumentTypeId() != null
					&& requestDetails.getInstrumentTypeId().intValue() != InstrumentType.DOCUMENT_LOC.getId()
					&& requestDetails.getBidReplyDetails() != null) {
				String expTime = requestDetails.getBidReplyDetails().getBidExpirationTime();
				if (expTime != null) {
					setCalendarTime(expTime);
				}
			} else if (requestDetails.getInstrumentTypeId() != null
					&& requestDetails.getInstrumentTypeId().intValue() == InstrumentType.DOCUMENT_LOC.getId()
					&& requestDetails.getIndicativePricingCompletedDetails() != null) {
				String expPricingTime = requestDetails.getIndicativePricingCompletedDetails().getPricingExpirationTime();
				if (expPricingTime != null) {
					setCalendarTime(expPricingTime);
				}
			}
		}
	}	
	
	
	/**
	 * Method to set the time Details for Bid Reply
	 * @param calendar
	 * @param am_pm
	 */
	private void setCalendarTime(String expTime){
		int baseVal = ALOCConstants.BASE_VALUE;
		int minVal = ALOCConstants.MIN_VALUE;
		int secondVal = ALOCConstants.SECOND_VALUE;
		if(StringUtils.isNotBlank(expTime)){
			String[] time = expTime.split(ALOCConstants.COMMA);
			bidMinutes = time.length > baseVal ? time[baseVal] : ALOCConstants.EMPTY_STRING;
			bidHours = time.length > minVal ? time[minVal] : ALOCConstants.EMPTY_STRING;
			bidPeriod = time.length > secondVal ? time[secondVal] : ALOCConstants.EMPTY_STRING;
		}
		
		if(StringUtils.isNotBlank(bidHours)){
			int hoursIntVal = Integer.parseInt(bidHours);
			if(hoursIntVal >= ALOCConstants.MIN_HOURS  && hoursIntVal < ALOCConstants.MAX_HOURS)
				bidHours = ALOCConstants.BASE_VALUE+bidHours;
		}
		if(StringUtils.isNotBlank(bidMinutes)){
			int minutesIntVal = Integer.parseInt(bidMinutes);
			if(minutesIntVal >= ALOCConstants.MIN_MINUTES  && minutesIntVal < ALOCConstants.MAX_MINUTES)
			bidMinutes = ALOCConstants.BASE_VALUE+bidMinutes;
		}
	}
	
	/**
	 * Method to set the Hour/Minute/Period Details
	 * @param requestDetails
	 * @return
	 */
	protected void setHoursMinutes(RequestDetails requestDetails){
		String expTime=null;
		if(instrumentId != null && (instrumentId.intValue() == InstrumentType.BANK_GUARANTEE.getId() || instrumentId.intValue() == InstrumentType.LOC.getId() || instrumentId.intValue() == InstrumentType.SURETY_BOND.getId())){
			if(requestDetails!=null && requestDetails.getBidReplyDetails()!=null){
				expTime = requestDetails.getBidReplyDetails().getBidExpirationTime();	
			}
		}
		if(instrumentId != null && instrumentId.intValue() == InstrumentType.DOCUMENT_LOC.getId()){
			if(requestDetails!=null && requestDetails.getIndicativePricingCompletedDetails()!=null){
				expTime =requestDetails.getIndicativePricingCompletedDetails().getPricingExpirationTime();
			}
		}
		
		int baseVal = ALOCConstants.BASE_VALUE;
		int minVal = ALOCConstants.MIN_VALUE;
		int secondVal = ALOCConstants.SECOND_VALUE;
		if(StringUtils.isNotBlank(expTime)){
			String[] time = expTime.split(ALOCConstants.COMMA);
			minutes = time.length > baseVal ? time[baseVal] : ALOCConstants.EMPTY_STRING;
			hours = time.length > minVal ? time[minVal] : ALOCConstants.EMPTY_STRING;
			period = time.length > secondVal ? time[secondVal] : ALOCConstants.EMPTY_STRING;
		}
		
		if(StringUtils.isNotBlank(hours)){
			int hoursIntVal = Integer.parseInt(hours);
			if(hoursIntVal >= ALOCConstants.MIN_HOURS  && hoursIntVal < ALOCConstants.MAX_HOURS)
				hours = ALOCConstants.BASE_VALUE+hours;
		}
		if(StringUtils.isNotBlank(minutes)){
			int minutesIntVal = Integer.parseInt(minutes);
			if(minutesIntVal >= ALOCConstants.MIN_MINUTES  && minutesIntVal < ALOCConstants.MAX_MINUTES)
				minutes = ALOCConstants.BASE_VALUE+minutes;
		}
	}   
	
	/**
	 * This method is used to get the Format content based on the Insrument Purpose
	 * @return
	 */
	public String getOnchangeFormat() throws HWFServiceException {
		HttpServletRequest request=ServletActionContext.getRequest();
		String instrPurposeId = request.getParameter(ALOCConstants.INSTRUMENT_PURPOSE_ID);
		
		if(StringUtils.isNotBlank(instrPurposeId)){
			String formatContent = requestDetailsSectionManager.getStandardFormatDocument(String.valueOf(requestDetailsBO.getModel().getRequestId()),instrPurposeId,null,null);
			
			RequestDetails requestDetails = requestDetailsBO.getModel() != null?requestDetailsBO.getModel() : null;
			String formatTypeId = requestDetails != null && requestDetails.getFormat() != null?requestDetails.getFormat().getFormatTypeId() : null;
			if(StringUtils.isNotBlank(formatTypeId) && Integer.valueOf(formatTypeId) != Integer.valueOf(ALOCConstants.NON_STANDARD_FORMAT)){
				requestDetailsBO.getModel().setSwiftFormatDoc(formatContent);
			}
			request.getSession().setAttribute(ALOCConstants.INSTRUMENT_PURPOSE_ID, instrPurposeId);
		}
		return SUCCESS;
	}
	
	/**
	 * This is used to do the validation on the each section.
	 * @return
	 */
	protected boolean isFormatDocChangeRequired() {
		RequestDetails requestDetails = requestDetailsBO.getModel();
		BigInteger instrumentTypeId = requestDetails != null?requestDetails.getInstrumentTypeId() : null;
		if(instrumentTypeId != null &&(instrumentTypeId.intValue()==InstrumentType.BANK_GUARANTEE.getId() || instrumentTypeId.intValue()==InstrumentType.LOC.getId())){
			String instrumentPurpose = requestDetails.getTransactionParties() !=null?requestDetails.getTransactionParties().getInstrumentPurposeId():null;
			String activeInstrPurpose = ActionContext.getContext().getSession().get(ALOCConstants.INSTRUMENT_PURPOSE) != null?
					(String) ActionContext.getContext().getSession().get(ALOCConstants.INSTRUMENT_PURPOSE) :null;
			if(StringUtils.isNotBlank(instrumentPurpose) && StringUtils.isNotBlank(activeInstrPurpose) && Integer.parseInt(instrumentPurpose) != Integer.parseInt(activeInstrPurpose)){
				return true;
			}
		}else if(instrumentTypeId != null && instrumentTypeId.intValue() ==  InstrumentType.SURETY_BOND.getId()){
			BigInteger bondTypeId = requestDetails.getBondDetails() !=null?requestDetails.getBondDetails().getBondTypeId():null;
			BigInteger activeBondTypeId = ActionContext.getContext().getSession().get(ALOCConstants.BOND_TYPE) != null?
					(BigInteger) ActionContext.getContext().getSession().get(ALOCConstants.BOND_TYPE) : null;
			if(bondTypeId != null && activeBondTypeId != null && bondTypeId.intValue() != activeBondTypeId.intValue()){
				return true;
			}else{
				BigInteger bondSubTypeId = requestDetails.getBondDetails() !=null?requestDetails.getBondDetails().getSubBondTypeId():null;
				BigInteger activeBondSubTypeId = ActionContext.getContext().getSession().get(ALOCConstants.BOND_SUBTYPE) != null?
						(BigInteger) ActionContext.getContext().getSession().get(ALOCConstants.BOND_SUBTYPE) : null;
				if(bondSubTypeId != null && activeBondSubTypeId != null && bondSubTypeId.intValue() != activeBondSubTypeId.intValue()){
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * This method is used to Throws Runtime error for Multiple Tabs issue.
	 * @return 
	 */
	public void multiTabError(){
		throw new ALOCRuntimeException(ALOCRuntimeException.EC_ACTIVEREQUEST_NOTFOUND);	
	}
	/* -------------------------------------------------------------------------------------------------------------------------------------------------------
	 * 															PROPERTY GETTER/SETTER METHODS
	 ------------------------------------------------------------------------------------------------------------------------------------------------------- */
	/**
	 * This method is used to get the editSectionList.
	 * @return the editSectionList
	 */
	public List<NameValue> getEditSectionList() {
		return editSectionList;
	}

	/**
	 * This method is used to set the editSectionList.
	 * @param editSectionList
	 */
	public void setEditSectionList(List<NameValue> editSectionList) {
		this.editSectionList = editSectionList;
	}
	/**
	 * This method is used to get the requestDetailsBO.
	 * @return the requestDetailsBO
	 */
	public RequestDetailsBO getRequestDetailsBO() {
		return requestDetailsBO;
	}

	/**
	 * This method is used to get the requestId.
	 * @return the requestId
	 */
	public BigInteger getRequestId() {
		return requestId;
	}

	/**
	 * This method is used to set the requestId.
	 * @param requestId 
	 */
	public void setRequestId(BigInteger requestId) {
		this.requestId = requestId;
	}

	/**
	 * This method is used to get the sectionId.
	 * @return the sectionId
	 */
	public String getSectionId() {
		return (sectionId != null) ? sectionId.getAsString() : null;
	}

	/**
	 * This method is used to set the sectionId.
	 * @param sectionId 
	 */
	public void setSectionId(String sectionId) {
		RequestSectionId requestSectionId = null;
		if(StringUtils.isNotBlank(sectionId)) {
			requestSectionId = RequestSectionId.fromString(sectionId);
		}
		this.sectionId = requestSectionId;
	}

	/**
	 * This method is used to set the requestDetailsBO.
	 * @param requestDetailsBO 
	 */
	public void setRequestDetailsBO(RequestDetailsBO requestDetailsBO) {
		this.requestDetailsBO = requestDetailsBO;
	}


	/*
	 * @see com.ge.aloc.IRequestDetailsBOAware#getRequestDetails()
	 * This method is used to get the RequestDetails.
	 */
	public RequestDetails getRequestDetails() {
		return requestDetailsBO.getModel();
	}


	/**
	 * This method is used to get the editMode.
	 * @return the editMode
	 */
	public boolean isEditMode() {
		return editMode;
	}

	/**
	 * This method is used to set the editMode.
	 * @param editMode
	 */
	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}

	/**
	 * Place holder for search field bank name
	 * This method is used to get the editSectionList.
	 * @return
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * This method is used to get the editSectionList.
	 * 
	 * @param bankName
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	/**
	 * Bank selection type either selected the existing bank or adding the new
	 * bank
	 * 
	 * @return
	 */
	public String getBankSelection() {
		return bankSelection;
	}

	/**
	 * This method is used to set the bankSelection.
	 * 
	 * @param bankSelection
	 */
	public void setBankSelection(String bankSelection) {
		this.bankSelection = bankSelection;
	}

	/**
	 * This method is used to get the goldId.
	 * @return the goldId
	 */
	public String getGoldId() {
		return goldId;
	}

	/**
	 * This method is used to set the goldId.
	 * @param goldId 
	 */
	public void setGoldId(String goldId) {
		this.goldId = goldId;
	}

	/**
	 * This method is used to get the goldIdSelection.
	 * @return the goldIdSelection
	 */
	public String getGoldIdSelection() {
		return goldIdSelection;
	}

	/**
	 * This method is used to set the goldIdSelection.
	 * @param goldIdSelection 
	 */
	public void setGoldIdSelection(String goldIdSelection) {
		this.goldIdSelection = goldIdSelection;
	}

	/**
	 * This method is used to get the personName.
	 * @return the personName
	 */
	public String getPersonName() {
		return personName;
	}

	/**
	 * This method is used to set the personName.
	 * @param personName
	 */
	public void setPersonName(String personName) {
		this.personName = personName;
	}

	/**
	 * This method is used to get the personNameSelection.
	 * @return the personNameSelection
	 */
	public String getPersonNameSelection() {
		return personNameSelection;
	}

	/**
	 * This method is used to set the personNameSelection.
	 * @param personNameSelection
	 */
	public void setPersonNameSelection(String personNameSelection) {
		this.personNameSelection = personNameSelection;
	}

	/**
	 * This method is used to get the nameForAddressTPApplicant.
	 * @return the nameForAddress
	 */
	public String getNameForAddressTPApplicant() {
		return nameForAddressTPApplicant;
	}

	/**
	 * This method is used to set the nameForAddressTPApplicant.
	 * @param nameForAddress
	 */
	public void setNameForAddressTPApplicant(String nameForAddressTPApplicant) {
		this.nameForAddressTPApplicant = nameForAddressTPApplicant;
	}

	/**
	 * This method is used to get the tpApplicantAddressSelection.
	 * @return the tpApplicantAddressSelection
	 */
	public String getTpApplicantAddressSelection() {
		return tpApplicantAddressSelection;
	}

	/**
	 * This method is used to set the tpApplicantAddressSelection.
	 * @param tpApplicantAddressSelection
	 */
	public void setTpApplicantAddressSelection(String tpApplicantAddressSelection) {
		this.tpApplicantAddressSelection = tpApplicantAddressSelection;
	}

	/**
	 * This method is used to get the nameForAddressTriparty.
	 * @return the nameForAddressTriparty
	 */
	public String getNameForAddressTriparty() {
		return nameForAddressTriparty;
	}

	/**
	 * This method is used to set the nameForAddressTriparty.
	 * @param nameForAddressTriparty
	 */
	public void setNameForAddressTriparty(String nameForAddressTriparty) {
		this.nameForAddressTriparty = nameForAddressTriparty;
	}

	/**
	 * This method is used to get the triPartyAddressSelection.
	 * @return the triPartyAddressSelection
	 */
	public String getTriPartyAddressSelection() {
		return triPartyAddressSelection;
	}

	/**
	 * This method is used to set the triPartyAddressSelection.
	 * @param triPartyAddressSelection
	 */
	public void setTriPartyAddressSelection(String triPartyAddressSelection) {
		this.triPartyAddressSelection = triPartyAddressSelection;
	}

	/**
	 * This method is used to get the nameForAddressTPCustomer.
	 * @return the nameForAddressTPCustomer
	 */
	public String getNameForAddressTPCustomer() {
		return nameForAddressTPCustomer;
	}

	/**
	 * This method is used to set the nameForAddressTPCustomer.
	 * @param nameForAddressTPCustomer
	 */
	public void setNameForAddressTPCustomer(String nameForAddressTPCustomer) {
		this.nameForAddressTPCustomer = nameForAddressTPCustomer;
	}

	/**
	 * This method is used to get the tpCustomerAddressSelection.
	 * @return the tpCustomerAddressSelection
	 */
	public String getTpCustomerAddressSelection() {
		return tpCustomerAddressSelection;
	}

	/**
	 * This method is used to set the tpCustomerAddressSelection.
	 * @param tpCustomerAddressSelection
	 */
	public void setTpCustomerAddressSelection(String tpCustomerAddressSelection) {
		this.tpCustomerAddressSelection = tpCustomerAddressSelection;
	}

	/**
	 * This method is used to get the standardFormat.
	 * @return standardFormat
	 * @throws HWFServiceException
	 * @throws ALOCException
	 */
	public String getStandardFormat() throws HWFServiceException,ALOCException { //need to work on that		
		String formatType = requestDetailsBO.getModel().getFormat() != null ? requestDetailsBO.getModel().getFormat().getFormatTypeId() : null;
		String FormatDoc = requestDetailsBO.getModel().getSwiftFormatDoc();
		String insrumentPurpose = ServletActionContext.getRequest().getSession().getAttribute(ALOCConstants.INSTRUMENT_PURPOSE_ID)!=null?(String)ServletActionContext.getRequest().getSession().getAttribute(ALOCConstants.INSTRUMENT_PURPOSE_ID):null;
		if(formatType != null && StringUtils.isNotBlank(FormatDoc) && Integer.valueOf(formatType).intValue() == FormatType.STANDARD.getId()  && !isFormatDocChangeRequired()){
			standardFormat = FormatDoc;
		}else if((StringUtils.isNotBlank(formatType) && (formatType.equalsIgnoreCase(ALOCConstants.EMPTY_STRING)?false:Integer.valueOf(formatType).intValue() == FormatType.STANDARD.getId()))
				&& requestDetailsBO.getModel().getFormat().getAttachments()!= null && !requestDetailsBO.getModel().getFormat().getAttachments().isEmpty() && (standardFormat ==null || standardFormat.equalsIgnoreCase(ALOCConstants.EMPTY_STRING)))
			{
			ByteArrayOutputStream tempStream = new ByteArrayOutputStream();
			alocAttachmentManager.downloadFormatAttachment(tempStream, requestDetailsBO.getModel().getFormat().getAttachments().get(ALOCConstants.BASE_VALUE));
			standardFormat = tempStream.toString();
			if(StringUtils.isBlank(standardFormat)){
				standardFormat = requestDetailsSectionManager.getStandardFormatDocument(String.valueOf(requestDetailsBO.getModel().getRequestId()),insrumentPurpose,null,null);
			}
		}else{
			if(standardFormat ==null || standardFormat.equalsIgnoreCase(ALOCConstants.EMPTY_STRING)){
				standardFormat = requestDetailsSectionManager.getStandardFormatDocument(String.valueOf(requestDetailsBO.getModel().getRequestId()),insrumentPurpose,null,null);				
			} 
		}
		return standardFormat;
	}		

	/**
	 * This method is used to set the standardFormat.
	 * @param standardFormat
	 */
	public void setStandardFormat(String standardFormat) throws ALOCException{			
		this.standardFormat = standardFormat;
	}

	/**
	 * This method is used to get the modifiedStandardFormat.
	 * @return modifiedStandardFormat
	 */
	public String getModifiedStandardFormat()  throws HWFServiceException,ALOCException  {
		String formatType = requestDetailsBO.getModel().getFormat() != null ? requestDetailsBO.getModel().getFormat().getFormatTypeId() : null;
		String FormatDoc = requestDetailsBO.getModel().getSwiftFormatDoc();
		String insrumentPurpose = ServletActionContext.getRequest().getSession().getAttribute(ALOCConstants.INSTRUMENT_PURPOSE_ID)!=null?(String)ServletActionContext.getRequest().getSession().getAttribute(ALOCConstants.INSTRUMENT_PURPOSE_ID):null;
		if(formatType != null && StringUtils.isNotBlank(FormatDoc) && Integer.valueOf(formatType).intValue() == FormatType.MODIFIED.getId() && !isFormatDocChangeRequired()){
			modifiedStandardFormat = FormatDoc;
		}else if((formatType != null && !formatType.equalsIgnoreCase(ALOCConstants.EMPTY_STRING) && (formatType.equalsIgnoreCase(ALOCConstants.EMPTY_STRING)?false:Integer.valueOf(formatType).intValue() == FormatType.MODIFIED.getId()))
				&& requestDetailsBO.getModel().getFormat().getAttachments()!= null && !requestDetailsBO.getModel().getFormat().getAttachments().isEmpty() && (modifiedStandardFormat ==null || modifiedStandardFormat.equalsIgnoreCase(ALOCConstants.EMPTY_STRING)))
			{
			ByteArrayOutputStream tempStream = new ByteArrayOutputStream();
			alocAttachmentManager.downloadFormatAttachment(tempStream, requestDetailsBO.getModel().getFormat().getAttachments().get(ALOCConstants.BASE_VALUE));
			modifiedStandardFormat = tempStream.toString();
			if(StringUtils.isBlank(modifiedStandardFormat)){
				modifiedStandardFormat = requestDetailsSectionManager.getStandardFormatDocument(String.valueOf(requestDetailsBO.getModel().getRequestId()),insrumentPurpose,null,null);
			}
		}else{
			if(modifiedStandardFormat ==null || modifiedStandardFormat.equalsIgnoreCase(ALOCConstants.EMPTY_STRING)){
				modifiedStandardFormat = requestDetailsSectionManager.getStandardFormatDocument(String.valueOf(requestDetailsBO.getModel().getRequestId()),insrumentPurpose,null,null);				
			}
		}
		ServletActionContext.getRequest().getSession().removeAttribute(ALOCConstants.INSTRUMENT_PURPOSE_ID);
		return modifiedStandardFormat;
	}
	
	/**
	 * This method is used to set the modifiedStandardFormat.
	 * @param modifiedStandardFormat
	 */
	public void setModifiedStandardFormat(String modifiedStandardFormat) {
		this.modifiedStandardFormat = modifiedStandardFormat;
	}
	
	/**
	 * This method is used to get the standardFormatView.
	 * @return the standardFormatView
	 * @throws ALOCException 
	 * @throws HWFServiceException 
	 */
	public String getStandardFormatView() throws HWFServiceException,ALOCException {
		String formatType = requestDetailsBO.getModel().getFormat() != null ? requestDetailsBO.getModel().getFormat().getFormatTypeId() : null;
		String insrumentPurpose = ServletActionContext.getRequest().getSession().getAttribute(ALOCConstants.INSTRUMENT_PURPOSE_ID)!=null?(String)ServletActionContext.getRequest().getSession().getAttribute(ALOCConstants.INSTRUMENT_PURPOSE_ID):null;
		if(StringUtils.isNotBlank(standardFormat)){
			standardFormatView = standardFormat;
		}else if(StringUtils.isNotBlank(formatType) && (formatType.equalsIgnoreCase(ALOCConstants.EMPTY_STRING)?false:Integer.valueOf(formatType).intValue() == FormatType.STANDARD.getId())
				&& requestDetailsBO.getModel().getFormat().getAttachments()!= null && !requestDetailsBO.getModel().getFormat().getAttachments().isEmpty() &&
				(requestDetailsBO.getModel().getFormat().getAttachments().get(ALOCConstants.BASE_VALUE).getGeFileId() != null)){
			ByteArrayOutputStream tempStream = new ByteArrayOutputStream();
			alocAttachmentManager.downloadFormatAttachment(tempStream, requestDetailsBO.getModel().getFormat().getAttachments().get(ALOCConstants.BASE_VALUE));
			standardFormatView = (tempStream != null) ? tempStream.toString() : ALOCConstants.EMPTY_STRING;			
		}else if(StringUtils.isBlank(standardFormatView)){
			standardFormatView = requestDetailsSectionManager.getStandardFormatDocument(String.valueOf(requestDetailsBO.getModel().getRequestId()),insrumentPurpose,null,null);				
		}
		if(StringUtils.isNotBlank(standardFormatView)){
			standardFormatView = new BookmarksHelper(requestDetailsBO.getModel(), standardFormatView).replaceTokens();
		}
		return standardFormatView;
	}

	/**
	 * This method is used to set the standardFormatView.
	 * @param standardFormatView the standardFormatView to set
	 */
	public void setStandardFormatView(String standardFormatView) {
		this.standardFormatView = standardFormatView;
	}

	/**
	 * This method is used to get the modifiedStandardFormatView.
	 * @return modifiedStandardFormatView
	 * @throws ALOCException 
	 * @throws HWFServiceException 
	 */
	public String getModifiedStandardFormatView() throws HWFServiceException,ALOCException {
		String formatType = requestDetailsBO.getModel().getFormat() != null ? requestDetailsBO.getModel().getFormat().getFormatTypeId() : null;	
		String insrumentPurpose = ServletActionContext.getRequest().getSession().getAttribute(ALOCConstants.INSTRUMENT_PURPOSE_ID)!=null?(String) ServletActionContext.getRequest().getSession().getAttribute(ALOCConstants.INSTRUMENT_PURPOSE_ID) : null;
		if(StringUtils.isNotBlank(modifiedStandardFormat)){
			modifiedStandardFormatView = modifiedStandardFormat;
		}else if(StringUtils.isNotBlank(formatType) && (formatType.equalsIgnoreCase(ALOCConstants.EMPTY_STRING)?false:Integer.valueOf(formatType).intValue() == FormatType.MODIFIED.getId())
				&& requestDetailsBO.getModel().getFormat().getAttachments()!= null && !requestDetailsBO.getModel().getFormat().getAttachments().isEmpty() &&
				(requestDetailsBO.getModel().getFormat().getAttachments().get(ALOCConstants.BASE_VALUE).getGeFileId() != null)){
			ByteArrayOutputStream tempStream = new ByteArrayOutputStream();
			alocAttachmentManager.downloadFormatAttachment(tempStream, requestDetailsBO.getModel().getFormat().getAttachments().get(ALOCConstants.BASE_VALUE));
			modifiedStandardFormatView = (tempStream != null) ? tempStream.toString() : ALOCConstants.EMPTY_STRING;			
		}else{
			if(StringUtils.isBlank(modifiedStandardFormatView)){
				modifiedStandardFormatView = requestDetailsSectionManager.getStandardFormatDocument(String.valueOf(requestDetailsBO.getModel().getRequestId()),insrumentPurpose,null,null);				
			} 
		}
		if(StringUtils.isNotBlank(modifiedStandardFormatView)){
			modifiedStandardFormatView = new BookmarksHelper(requestDetailsBO.getModel(), modifiedStandardFormatView).replaceTokens();
		}
		return modifiedStandardFormatView;
	}

	/**
	 * This method is used to set the modifiedStandardFormatView.
	 * @param modifiedStandardFormatView the modifiedStandardFormatView to set
	 */
	public void setModifiedStandardFormatView(String modifiedStandardFormatView) {
		this.modifiedStandardFormatView = modifiedStandardFormatView;
	}

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
	 * Gets the amendment id
	 * @return
	 */
	public String getAmendmentId() {
		return amendmentId;
	}

	/**
	 * Sets the amendment id
	 * @param amendmentId
	 */
	public void setAmendmentId(String amendmentId) {
		this.amendmentId = amendmentId;
	}

	/**
	 * Gets the instrument id
	 * @return
	 */
	public Integer getInstrumentId() {
		return instrumentId;
	}

	/**
	 * Sets the instrument id
	 * @param instrumentId
	 */
	public void setInstrumentId(Integer instrumentId) {
		this.instrumentId = instrumentId;
	}



	/**
	 * Get the Taxonomy ViewType
	 * @return
	 */
	public String getTaxonomyViewType() {
		return taxonomyViewType;
	}

	/**
	 * Set the Taxonomy ViewType
	 * @param taxonomyViewType
	 */
	public void setTaxonomyViewType(String taxonomyViewType) {
		this.taxonomyViewType = taxonomyViewType;
	}

	/**
	 * get The amendments List
	 * @return
	 */
	public List<AmendmentDetails> getAmendsLst() {
		return amendsLst;
	}

	/**
	 * Set the amendments List
	 * @param amendsLst
	 */
	public void setAmendsLst(List<AmendmentDetails> amendsLst) {
		this.amendsLst = amendsLst;
	}

	/**
	 * Get Riders List
	 * @return
	 */
	public List<RiderDetails> getRidersLst() {
		return ridersLst;
	}

	/**
	 * Set the riders List
	 * @param ridersLst
	 */
	public void setRidersLst(List<RiderDetails> ridersLst) {
		this.ridersLst = ridersLst;
	}

	/**
	 * This method is used to get the stage.
	 * @return the stage
	 */
	public Integer getStage() {
		return (stage != null) ? stage.getId() : WorkflowStage.DRAFT.getId();
	}
	/**
	 * This method is used to set the stage.
	 * @param stage
	 */
	public void setStage(Integer stage) {
		if(stage != null) {
			this.stage = WorkflowStage.fromId(stage);
		}
	}

	/**
	 * This method is used to get the dashboardViewType.
	 * @return the dashboardViewType
	 */
	public DashboardViewType getDashboardViewType() {
		return dashboardViewType;
	}

	/**
	 * This method is used to set the dashboardViewType.
	 * @param dashboardViewType
	 */
	public void setDashboardViewType(DashboardViewType dashboardViewType) {
		this.dashboardViewType = dashboardViewType;
	}

	/**
	 * This method is used to get the wfid.
	 * @return the wfid
	 */
	public String getWfid() {
		return wfid;
	}

	/**
	 * This method is used to set the wfid.
	 * @param wfid
	 */
	public void setWfid(String wfid) {
		this.wfid = wfid;
	}

	/**
	 * This method is used to get the queueName.
	 * @return the queueName
	 */
	public String getQueueName() {
		return queueName;
	}

	/**
	 * This method is used to set the queueName.
	 * @param queueName
	 */
	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

	/**
	 * This method is used to get the procedureName.
	 * @return the procedureName
	 */
	public String getProcedureName() {
		return procedureName;
	}

	/**
	 * This method is used to set the procedureName.
	 * @param procedureName the procedureName to set
	 */
	public void setProcedureName(String procedureName) {
		this.procedureName = procedureName;
	}
	/**
	 * This method is used to get the stage name.
	 * @return the stageName
	 */
	public String getStageName() {
		return stageName;
	}
	/**
	 * This method is used to set the stage name.
	 * @param stageName the stageName to set
	 */
	public void setStageName(String stageName) {
		this.stageName = stageName;
	}


	/* -------------------------------------------------------------------------------------------------------------------------------------------------------
	 * 															DEPENDENCY INJECTION METHODS
	 ------------------------------------------------------------------------------------------------------------------------------------------------------- */

	/**
	 * This is used to create requestDetailsSectionManager instance object.
	 * @return requestDetailsSectionManager
	 */
	public IRequestDetailsSectionManager getRequestDetailsSectionManager() {
		return (IRequestDetailsSectionManager) requestDetailsSectionManager;
	}

	/**
	 * This is used to create requestDetailsSectionManager instance object.
	 * @param requestDetailsSectionManager the requestDetailsSectionManager to set
	 */
	public void setRequestDetailsSectionManager(
			IRequestDetailsSectionManager requestDetailsSectionManager) {
		this.requestDetailsSectionManager = requestDetailsSectionManager;
	}

	/**
	 * This is used to create requestDetailsManager instance object.
	 * @return the requestDetailsManager
	 */
	public IRequestDetailsManager getRequestDetailsManager() {
		return requestDetailsManager;
	}

	/**
	 * This is used to create requestDetailsManager instance object.
	 * @param requestDetailsManager the requestDetailsManager to set
	 */
	public void setRequestDetailsManager(
			IRequestDetailsManager requestDetailsManager) {
		this.requestDetailsManager = requestDetailsManager;
	}

	/**
	 * This is used to create alocAttachmentManager instance object.
	 * @return the alocAttachmentManager
	 */
	public IALOCAttachmentManager getAlocAttachmentManager() {
		return alocAttachmentManager;
	}

	/**
	 * This is used to create alocAttachmentManager instance object.
	 * @param alocAttachmentManager the alocAttachmentManager to set
	 */
	public void setAlocAttachmentManager(
			IALOCAttachmentManager alocAttachmentManager) {
		this.alocAttachmentManager = alocAttachmentManager;
	}

	/**
	 * This is used to validations
	 * @return validationSuccess
	 */
	public boolean isValidationSuccess() {
		return validationSuccess;
	}

	/**
	 * This is used to set the validation flag.
	 * @param validationSuccess
	 */
	public void setValidationSuccess(boolean validationSuccess) {
		this.validationSuccess = validationSuccess;
	}


	/**
	 * This is used to do CSO validation
	 * @return the validCSO
	 */
	public boolean isValidCSO() {
		return validCSO;
	}

	/**
	 * This is used to set the CSO validation flag.
	 * @param validCSO the validCSO to set
	 */
	public void setValidCSO(boolean validCSO) {
		this.validCSO = validCSO;
	}
	/**
	 * This method is used to get the amountIncreaseDecrease.
	 * @return
	 */
	public BigInteger getAmountIncreaseDecrease() {
		return amountIncreaseDecrease;
	}
	/**
	 * This method is used to set the amountIncreaseDecrease.
	 * @param amountIncreaseDecrease
	 */
	public void setAmountIncreaseDecrease(BigInteger amountIncreaseDecrease) {
		this.amountIncreaseDecrease = amountIncreaseDecrease;
	}

	/**
	 * This method is used to get the linkTransactionManager.
	 * @return the linkTransactionManager
	 */
	public ILinkTransactionManager getLinkTransactionManager() {
		return linkTransactionManager;
	}

	/**
	 * This method is used to set the linkTransactionManager.
	 * @param linkTransactionManager the linkTransactionManager to set
	 */
	public void setLinkTransactionManager(
			ILinkTransactionManager linkTransactionManager) {
		this.linkTransactionManager = linkTransactionManager;
	}

	/**
	 * This is used creatBundleManager instance.
	 * @return
	 */
	public ICreateBundleManager getCreateBundleManager() {
		return createBundleManager;
	}

	/**
	 * This is used createBundleManager instance.
	 * @param createBundleManager
	 */
	public void setCreateBundleManager(ICreateBundleManager createBundleManager) {
		this.createBundleManager = createBundleManager;
	}

	/**
	 * This method is used to get the Request details List
	 * @return
	 */
	public List<RequestDetails> getRequestDetailsList() {
		return requestDetailsList;
	}

	/**
	 * This method is used to set the request details List
	 * @param requestDetailsList
	 */
	public void setRequestDetailsList(List<RequestDetails> requestDetailsList) {
		this.requestDetailsList = requestDetailsList;
	}

	/**
	 * This method is used to get the nameForAddressPrincipal.
	 * @return nameForAddressPrincipal
	 */
	public String getNameForAddressPrincipal() {
		return nameForAddressPrincipal;
	}

	/**
	 * This method is used to set the nameForAddressPrincipal.
	 * @param nameForAddressPrincipal
	 */
	public void setNameForAddressPrincipal(String nameForAddressPrincipal) {
		this.nameForAddressPrincipal = nameForAddressPrincipal;
	}

	/**
	 * This method is used to get the principlaAddressSelection.
	 * @return principlaAddressSelection
	 */
	public String getPrinciplaAddressSelection() {
		return principlaAddressSelection;
	}

	/**
	 * This method is used to set the principlaAddressSelection.
	 * @param principlaAddressSelection
	 */
	public void setPrinciplaAddressSelection(String principlaAddressSelection) {
		this.principlaAddressSelection = principlaAddressSelection;
	}
	/**
	 * This method is used to get the nameForObligeeAddress.
	 * @return nameForObligeeAddress
	 */
	public String getNameForObligeeAddress() {
		return nameForObligeeAddress;
	}

	/**
	 * This method is used to set the nameForObligeeAddress.
	 * @param nameForObligeeAddress
	 */
	public void setNameForObligeeAddress(String nameForObligeeAddress) {
		this.nameForObligeeAddress = nameForObligeeAddress;
	}

	/**
	 * This method is used to get the obligeeAddressSelection.
	 * @return obligeeAddressSelection
	 */
	public String getObligeeAddressSelection() {
		return obligeeAddressSelection;
	}

	/**
	 * This method is used to set the obligeeAddressSelection.
	 * @param obligeeAddressSelection
	 */
	public void setObligeeAddressSelection(String obligeeAddressSelection) {
		this.obligeeAddressSelection = obligeeAddressSelection;
	}

	/**
	 * This method is used to get the principalGoldId.
	 * @return principalGoldId
	 */
	public String getPrincipalGoldId() {
		return principalGoldId;
	}

	/**
	 * This method is used to set the principalGoldId.
	 * @param principalGoldId
	 */
	public void setPrincipalGoldId(String principalGoldId) {
		this.principalGoldId = principalGoldId;
	}

	/**
	 * This method is used to get the principalGoldIdSelection.
	 * @return principalGoldIdSelection
	 */
	public String getPrincipalGoldIdSelection() {
		return principalGoldIdSelection;
	}

	/**
	 * This method is used to set the principalGoldIdSelection.
	 * @param principalGoldIdSelection
	 */
	public void setPrincipalGoldIdSelection(String principalGoldIdSelection) {
		this.principalGoldIdSelection = principalGoldIdSelection;
	}

	/**
	 * This method is used to get the bondReqName.
	 * @return bondReqName
	 */
	public String getBondReqName() {
		return bondReqName;
	}

	/**
	 * This method is used to set the bondReqName.
	 * @param bondReqName
	 */
	public void setBondReqName(String bondReqName) {
		this.bondReqName = bondReqName;
	}

	/**
	 * This method is used to get the bondReqNameSelection.
	 * @return bondReqNameSelection
	 */
	public String getBondReqNameSelection() {
		return bondReqNameSelection;
	}

	/**
	 * This method is used to set the bondReqNameSelection.
	 * @param bondReqNameSelection
	 */
	public void setBondReqNameSelection(String bondReqNameSelection) {
		this.bondReqNameSelection = bondReqNameSelection;
	}

	/**
	 * This method is used to get the issuingBankName.
	 * @return issuingBankName
	 */
	public String getIssuingBankName() {
		return issuingBankName;
	}

	/**
	 * This method is used to set the issuingBankName.
	 * @param issuingBankName
	 */
	public void setIssuingBankName(String issuingBankName) {
		this.issuingBankName = issuingBankName;
	}

	/**
	 * This method is used to get the issuingBankSelection.
	 * @return issuingBankSelection
	 */
	public String getIssuingBankSelection() {
		return issuingBankSelection;
	}

	/**
	 * This method is used to set the issuingBankSelection.
	 * @param issuingBankSelection
	 */
	public void setIssuingBankSelection(String issuingBankSelection) {
		this.issuingBankSelection = issuingBankSelection;
	}


	/**
	 * This method is used to get the nameForApplicantAddress.
	 * @return nameForApplicantAddress
	 */
	public String getNameForApplicantAddress() {
		return nameForApplicantAddress;
	}

	/**
	 * This method is used to set the nameForApplicantAddress.
	 * @param nameForApplicantAddress
	 */
	public void setNameForApplicantAddress(String nameForApplicantAddress) {
		this.nameForApplicantAddress = nameForApplicantAddress;
	}

	/**
	 * This method is used to get the applicantSelection.
	 * @return applicantSelection
	 */
	public String getApplicantSelection() {
		return applicantSelection;
	}

	/**
	 * This method is used to set the applicantSelection.
	 * @param applicantSelection
	 */
	public void setApplicantSelection(String applicantSelection) {
		this.applicantSelection = applicantSelection;
	}

	/**
	 * This method is used to get the beneficiaryGoldId.
	 * @return beneficiaryGoldId
	 */
	public String getBeneficiaryGoldId() {
		return beneficiaryGoldId;
	}

	/**
	 * This method is used to set the beneficiaryGoldId.
	 * @param beneficiaryGoldId
	 */
	public void setBeneficiaryGoldId(String beneficiaryGoldId) {
		this.beneficiaryGoldId = beneficiaryGoldId;
	}

	/**
	 * This method is used to get the beneficiaryGoldIdSelection.
	 * @return beneficiaryGoldIdSelection
	 */
	public String getBeneficiaryGoldIdSelection() {
		return beneficiaryGoldIdSelection;
	}

	/**
	 * This method is used to set the beneficiaryGoldIdSelection.
	 * @param beneficiaryGoldIdSelection
	 */
	public void setBeneficiaryGoldIdSelection(String beneficiaryGoldIdSelection) {
		this.beneficiaryGoldIdSelection = beneficiaryGoldIdSelection;
	}

	/**
	 * This method is used to get the nameForBeneficiaryAddress.
	 * @return nameForBeneficiaryAddress
	 */
	public String getNameForBeneficiaryAddress() {
		return nameForBeneficiaryAddress;
	}

	/**
	 * This method is used to set the nameForBeneficiaryAddress.
	 * @param nameForBeneficiaryAddress
	 */
	public void setNameForBeneficiaryAddress(String nameForBeneficiaryAddress) {
		this.nameForBeneficiaryAddress = nameForBeneficiaryAddress;
	}

	/**
	 * This method is used to get the beneficiaryAddressSelection.
	 * @return beneficiaryAddressSelection
	 */
	public String getBeneficiaryAddressSelection() {
		return beneficiaryAddressSelection;
	}

	/**
	 * This method is used to set the beneficiaryAddressSelection.
	 * @param beneficiaryAddressSelection
	 */
	public void setBeneficiaryAddressSelection(String beneficiaryAddressSelection) {
		this.beneficiaryAddressSelection = beneficiaryAddressSelection;
	}

	/**
	 * This method is used to get the bidFlag.
	 * @return the bidFlag
	 */
	public String getBidFlag() {
		return bidFlag;
	}

	/**
	 * This method is used to set the bidFlag.
	 * @param bidFlag the bidFlag to set
	 */
	public void setBidFlag(String bidFlag) {
		this.bidFlag = bidFlag;
	}

	/**
	 * This method is used to get the bankBidId.
	 * @return the bankBidId
	 */
	public BigDecimal getBankBidId() {
		return bankBidId;
	}

	/**
	 * This method is used to set the bankBidId.
	 * @param bankBidId the bankBidId to set
	 */
	public void setBankBidId(BigDecimal bankBidId) {
		this.bankBidId = bankBidId;
	}	

	/**
	 * This method is used to get the rightBankRecords.
	 * @return the rightBankRecords
	 */
	public List<String> getRightBankRecords() {
		return rightBankRecords;
	}

	/**
	 * This method is used to set the rightBankRecords.
	 * @param rightBankRecords the rightBankRecords to set
	 */
	public void setRightBankRecords(List<String> rightBankRecords) {
		this.rightBankRecords = rightBankRecords;
	}

	/**
	 * This method is used to get the returnToPage
	 * @return the returnToPage
	 */
	public String getReturnToPage() {
		return returnToPage;
	}

	/**
	 * This method is used to set the returnToPage
	 * @param returnToPage the returnToPage to set
	 */
	public void setReturnToPage(String returnToPage) {
		this.returnToPage = returnToPage;
	}

	/**
	 * This method is used to get the businessContactPerson.
	 * @return the businessContactPerson
	 */
	public String getBusinessContactPerson() {
		return businessContactPerson;
	}

	/**
	 * This method is used to set the businessContactPerson.
	 * @param businessContactPerson the businessContactPerson to set
	 */
	public void setBusinessContactPerson(String businessContactPerson) {
		this.businessContactPerson = businessContactPerson;
	}

	/**
	 * This method is used to get the businessContactPersonSelection.
	 * @return the businessContactPersonSelection
	 */
	public String getBusinessContactPersonSelection() {
		return businessContactPersonSelection;
	}

	/**
	 * This method is used to set the principalGoldSelection.
	 * @param businessContactPersonSelection the businessContactPersonSelection to set
	 */
	public void setBusinessContactPersonSelection(
			String businessContactPersonSelection) {
		this.businessContactPersonSelection = businessContactPersonSelection;
	}

	/**
	 * @return the modelId
	 */
	public BigInteger getModelId() {
		return modelId;
	}

	/**
	 * @param modelId the modelId to set
	 */
	public void setModelId(BigInteger modelId) {
		this.modelId = modelId;
	}

	/**
	 * @return the logType
	 */
	public String getLogType() {
		return logType;
	}

	/**
	 * @param logType the logType to set
	 */
	public void setLogType(String logType) {
		this.logType = logType;
	}

	/**
	 * This is used to get fee history Details
	 * @return
	 */
	public List<FullSummary> getFeeHistLst() {
		return feeHistLst;
	}

	/**
	 * This is used to set fee history details
	 * @param feeHistLst
	 */
	public void setFeeHistLst(List<FullSummary> feeHistLst) {
		this.feeHistLst = feeHistLst;
	}

	/**
	 * This is used to get competing Bid Replies
	 * @return
	 */
	public CurrentBankFees getComBidReplies() {
		return comBidReplies;
	}

	/**
	 * This is used to set competing Bid Replies
	 * @param comBidReplies
	 */
	public void setComBidReplies(CurrentBankFees comBidReplies) {
		this.comBidReplies = comBidReplies;
	}

	/**
	 * This is used to get GeRecipient
	 * @return
	 */
	public String getGeRecipient() {
		return geRecipient;
	}

	/**
	 * This is used to set ge GeRecipient
	 * @param geRecipient
	 */
	public void setGeRecipient(String geRecipient) {
		this.geRecipient = geRecipient;
	}

	/**
	 * This is used to get RecipientSelection
	 * @return
	 */
	public String getRecipientSelection() {
		return recipientSelection;
	}

	/**
	 * This is used to set RecipientSelection
	 * @param recipientSelection
	 */
	public void setRecipientSelection(String recipientSelection) {
		this.recipientSelection = recipientSelection;
	}
	
	/**
	 * This is used to get Hours
	 * @return
	 */
	public String getHours() {
		return hours;
	}

	/**
	 * This is used to set Hours
	 * @return
	 */
	public void setHours(String hours) {
		this.hours = hours;
	}

	/**
	 * This is used to get Minutes
	 * @return
	 */
	public String getMinutes() {
		return minutes;
	}

	/**
	 * This is used to set Minutes
	 * @return
	 */
	public void setMinutes(String minutes) {
		this.minutes = minutes;
	}

	/**
	 * This is used to get Period
	 * @return
	 */
	public String getPeriod() {
		return period;
	}

	/**
	 * This is used to set period
	 * @param period
	 */
	public void setPeriod(String period) {
		this.period = period;
	}
	
	/**
	 * This is used to get bankLookupName
	 * @return the bankLookupName
	 */
	public String getBankLookupName() {
		return bankLookupName;
	}

	/**
	 * This is used to set bankLookupName
	 * @param bankLookupName the bankLookupName to set
	 */
	public void setBankLookupName(String bankLookupName) {
		this.bankLookupName = bankLookupName;
	}
	
	/**
	 * This is used to get the bidHours
	 * @return the bidHours
	 */
	public String getBidHours() {
		return bidHours;
	}

	/**
	 * This is used to set the bidHours
	 * @param bidHours the bidHours to set
	 */
	public void setBidHours(String bidHours) {
		this.bidHours = bidHours;
	}

	/**
	 * This is used to get the bidMinutes
	 * @return the bidMinutes
	 */
	public String getBidMinutes() {
		return bidMinutes;
	}

	/**
	 * This is used to set the bidMinutes
	 * @param bidMinutes the bidMinutes to set
	 */
	public void setBidMinutes(String bidMinutes) {
		this.bidMinutes = bidMinutes;
	}

	/**
	 * This is used to get the bidPeriod
	 * @return the bidPeriod
	 */
	public String getBidPeriod() {
		return bidPeriod;
	}

	/**
	 * This is used to get the bidPeriod
	 * @param bidPeriod the bidPeriod to set
	 */
	public void setBidPeriod(String bidPeriod) {
		this.bidPeriod = bidPeriod;
	}
	
	/**
	 * @return the bankCity
	 */
	public String getBankCity() {
		return bankCity;
	}

	/**
	 * @param bankCity the bankCity to set
	 */
	public void setBankCity(String bankCity) {
		this.bankCity = bankCity;
	}

	/**
	 * @return the bankCountryCd
	 */
	public String getBankCountryCd() {
		return bankCountryCd;
	}

	/**
	 * @param bankCountryCd the bankCountryCd to set
	 */
	public void setBankCountryCd(String bankCountryCd) {
		this.bankCountryCd = bankCountryCd;
	}
	/**
	 * This is used to get the All In Commissions value
	 * @return
	 */
	public String getAllInCommissionsValue() {
		return allInCommissionsValue;
	}

	/**
	 * This is used to set the Local Commissions Value
	 * @param allInCommissionsValue
	 */
	public void setAllInCommissionsValue(String allInCommissionsValue) {
		this.allInCommissionsValue = allInCommissionsValue;
	}

	/**
	 * This is used to get the local Commisions Value
	 * @return
	 */
	public String getLocalCommissionsValue() {
		return localCommissionsValue;
	}

	/**
	 * This is used to set the Local Commmissions value
	 * @param localCommissionsValue
	 */
	public void setLocalCommissionsValue(String localCommissionsValue) {
		this.localCommissionsValue = localCommissionsValue;
	}
	

	/**
	 * This is used to get status of the user based attachment downloads
	 * @return issuerDownloadAtmts
	 */
	public boolean isIssuerDownloadAtmts() {
		Boolean isAtmtdownload = null;
		if(issuerDownloadAtmts == false){
			isAtmtdownload = (Boolean) ActionContext.getContext().getSession().get(requestDetailsBO.getModel().getRequestId()+ALOCConstants.UNDERSCORE+ALOCConstants.ROLE_BASED_ATTACHMENT_DOWNLOAD);
			setIssuerDownloadAtmts(isAtmtdownload.booleanValue());			
		}
		return issuerDownloadAtmts;
	}

	/**
	 *  This is used to get status of the user based attachment downloads
	 * @param issuerDownloadAtmts
	 */
	public void setIssuerDownloadAtmts(boolean issuerDownloadAtmts) {		
		this.issuerDownloadAtmts = issuerDownloadAtmts;
	}
	
	/**
	 * This is used to get the bidReplyId Value
	 * @return the bidReplyId
	 */
	public BigDecimal getBidReplyId() {
		return bidReplyId;
	}

	/**
	 * This is used to set the bidReplyId Value
	 * @param bidReplyId the bidReplyId to set
	 */
	public void setBidReplyId(BigDecimal bidReplyId) {
		this.bidReplyId = bidReplyId;
	}
	
	/**
	 * This is used to set the bankCountryName Value
	 * @return the bankCountryName
	 */
	public String getBankCountryName() {
		return bankCountryName;
	}

	/**
	 * This is used to get the bankCountryName Value
	 * @param countryName the bankCountryName to set
	 */
	public void setBankCountryName(String bankCountryName) {
		this.bankCountryName = bankCountryName;
	}
	
	/**
	 * This is used to get the bankCountry Value
	 * @return the bankCountry
	 */
	public String getBankCountry() {
		return bankCountry;
	}

	/**
	 * This is used to set the bankCountry Value
	 * @param bankCountry the bankCountry to set
	 */
	public void setBankCountry(String bankCountry) {
		this.bankCountry = bankCountry;
	}

	/**
	 *  This is used to get the updateReportingData Values
	 * @return the updateReportingData
	 */
	public UpdateReporting getUpdateReportingData() {
		return updateReportingData;
	}

	/**
	 * This is used to set the updateReportingData Values
	 * @param updateReportingData the updateReportingData to set
	 */
	public void setUpdateReportingData(UpdateReporting updateReportingData) {
		this.updateReportingData = updateReportingData;
	}

	/**
	 *  This is used to get the taxonomyAtmtsLst Values
	 * @return the taxonomyAtmts
	 */
	public List<Attachment> getTaxonomyAtmtsLst() {
		return taxonomyAtmtsLst;
	}

	/**
	 * This is used to set the taxonomyAtmtsLst Values
	 * @param taxonomyAtmts the taxonomyAtmts to set
	 */
	public void setTaxonomyAtmtsLst(List<Attachment> taxonomyAtmtsLst) {
		this.taxonomyAtmtsLst = taxonomyAtmtsLst;
	}
	
	/**
	 * This is used to get the feeStructureValue
	 * @return the feeStructureValue
	 */
	public String getFeeStructureValue() {
		return feeStructureValue;
	}

	/**
	 * This is used to set the feeStructureValue
	 * @param feeStructureValue the feeStructureValue to set
	 */
	public void setFeeStructureValue(String feeStructureValue) {
		this.feeStructureValue = feeStructureValue;
	}

	/**
	 * This is used to get the taxonomyClosureAtmts Values
	 * @return the taxonomyClosureAtmts
	 */
	public List<Attachment> getTaxonomyClosureAtmts() {
		return taxonomyClosureAtmts;
	}

	/**
	 * This is used to set the taxonomyClosureAtmts Values
	 * @param taxonomyClosureAtmts the taxonomyClosureAtmts to set
	 */
	public void setTaxonomyClosureAtmts(List<Attachment> taxonomyClosureAtmts) {
		this.taxonomyClosureAtmts = taxonomyClosureAtmts;
	}
	
	/**
	 * This is used to get the amendmentOrRiderRequestId
	 * @return the amendmentOrRiderRequestId
	 */
	public String getAmendmentOrRiderRequestId() {
		return amendmentOrRiderRequestId;
	}
	
	/**
	 * This is used to set the amendmentOrRiderRequestId
	 * @param amendmentOrRiderRequestId
	 */
	public void setAmendmentOrRiderRequestId(String amendmentOrRiderRequestId) {
		this.amendmentOrRiderRequestId = amendmentOrRiderRequestId;
	}
}