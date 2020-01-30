/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: TransactionCaptureAction.java
 * Purpose: TransactionCaptureAction used for executing TransactionCapture Screen to load ,submit the deal.
 */
package com.ge.icfp.transactioncapture.action;

import static com.ge.icfp.common.constants.ICFPConstants.ACTIONID;
import static com.ge.icfp.common.constants.ICFPConstants.ADDAPPRV;
import static com.ge.icfp.common.constants.ICFPConstants.AFTER_POPULATING;
import static com.ge.icfp.common.constants.ICFPConstants.APPOVECM;
import static com.ge.icfp.common.constants.ICFPConstants.APPOVEFO;
import static com.ge.icfp.common.constants.ICFPConstants.BEFORE_POPULATING;
import static com.ge.icfp.common.constants.ICFPConstants.BUSINESSAPPROVERSLIST;
import static com.ge.icfp.common.constants.ICFPConstants.CERTFYCM;
import static com.ge.icfp.common.constants.ICFPConstants.CERTFYFO;
import static com.ge.icfp.common.constants.ICFPConstants.CERTIFY;
import static com.ge.icfp.common.constants.ICFPConstants.CLOSE;
import static com.ge.icfp.common.constants.ICFPConstants.CLOSEDATEFLAG;
import static com.ge.icfp.common.constants.ICFPConstants.CLOSINGCHECKLISTS;
import static com.ge.icfp.common.constants.ICFPConstants.CURRENTADDITIONALAPPROVERS;
import static com.ge.icfp.common.constants.ICFPConstants.CURRENTBUSINESSAPPROVERS;
import static com.ge.icfp.common.constants.ICFPConstants.CURRENTUSERINFOLIST;
import static com.ge.icfp.common.constants.ICFPConstants.DAY2LEG;
import static com.ge.icfp.common.constants.ICFPConstants.DEALCOMMENTS;
import static com.ge.icfp.common.constants.ICFPConstants.DEALREQUESTID;
import static com.ge.icfp.common.constants.ICFPConstants.DELETEBUSINESSAPPROVERS;
import static com.ge.icfp.common.constants.ICFPConstants.DELETEUSERINFOLIST;
import static com.ge.icfp.common.constants.ICFPConstants.EIGHT;
import static com.ge.icfp.common.constants.ICFPConstants.FAILUREMSG;
import static com.ge.icfp.common.constants.ICFPConstants.FIVE;
import static com.ge.icfp.common.constants.ICFPConstants.FORWARDPAGE;
import static com.ge.icfp.common.constants.ICFPConstants.HWF_FOURBLOCKER_1001;
import static com.ge.icfp.common.constants.ICFPConstants.ID;
import static com.ge.icfp.common.constants.ICFPConstants.IMMEDIATE_DRAWDOWN;
import static com.ge.icfp.common.constants.ICFPConstants.ISCPA;
import static com.ge.icfp.common.constants.ICFPConstants.ISEQUITY;
import static com.ge.icfp.common.constants.ICFPConstants.LEGNUMBER;
import static com.ge.icfp.common.constants.ICFPConstants.NO;
import static com.ge.icfp.common.constants.ICFPConstants.ONE;
import static com.ge.icfp.common.constants.ICFPConstants.OTHERAPPROVER;
import static com.ge.icfp.common.constants.ICFPConstants.OVERRIDE;
import static com.ge.icfp.common.constants.ICFPConstants.PROCEEDTONEXTLEG;
import static com.ge.icfp.common.constants.ICFPConstants.SAVE;
import static com.ge.icfp.common.constants.ICFPConstants.SAVEMESSAGE;
import static com.ge.icfp.common.constants.ICFPConstants.SECTION;
import static com.ge.icfp.common.constants.ICFPConstants.SUCCESS;
import static com.ge.icfp.common.constants.ICFPConstants.SUCCESSCPA;
import static com.ge.icfp.common.constants.ICFPConstants.TWO;
import static com.ge.icfp.common.constants.ICFPConstants.UPDATEICFPSTATUS;
import static com.ge.icfp.common.constants.ICFPConstants.UPDATEMESSAGE;
import static com.ge.icfp.common.constants.ICFPConstants.VIEWINPUTSCREENS;
import static com.ge.icfp.common.constants.ICFPConstants.YES;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import com.ge.icfp.action.ICFPException;
import com.ge.icfp.common.action.FourBlockerAction;
import com.ge.icfp.common.attachments.AttachmentType;
import com.ge.icfp.common.attachments.AttachmentUtils;
import com.ge.icfp.common.attachments.AttachmentViewFunctions;
import com.ge.icfp.common.attachments.validation.AttachmentValidator;
import com.ge.icfp.common.constants.ICFPConstants;
import com.ge.icfp.common.formbean.InputLegForm;
import com.ge.icfp.common.helper.CurrentDealManager;
import com.ge.icfp.common.helper.EntityHelper;
import com.ge.icfp.common.helper.EntityHelper.EntityType;
import com.ge.icfp.common.helper.ICFPCommonHelper;
import com.ge.icfp.common.helper.ICFPDay2LegHelper;
import com.ge.icfp.common.helper.ICFPLegHelper;
import com.ge.icfp.common.vo.CPALegSummaryVO;
import com.ge.icfp.common.vo.LegSummaryVO;
import com.ge.icfp.common.vo.PendingEntityVO;
import com.ge.icfp.model.Attachment;
import com.ge.icfp.model.CPALegRequest;
import com.ge.icfp.model.CPASummary;
import com.ge.icfp.model.ClosingCheckList;
import com.ge.icfp.model.DealRequest;
import com.ge.icfp.model.DerivativesRequest;
import com.ge.icfp.model.DerivativesRequest.CounterPartyInfo;
import com.ge.icfp.model.Entity;
import com.ge.icfp.model.LegSummary;
import com.ge.icfp.model.NameValue;
import com.ge.icfp.model.OtherLegRequest;
import com.ge.icfp.model.RCALegRequest;
import com.ge.icfp.model.UpdateStatus;
import com.ge.icfp.util.Actions;
import com.ge.icfp.util.ProductType;
import com.ge.icfp.util.StaticDataFactory;
import com.ge.icfp.util.Utils;
import com.hydus.wff.core.context.UserContext;
import com.hydus.wff.core.exception.HWFServiceException;
import com.hydus.wff.core.exception.HWFStubException;

import formdef.plugin.util.FormUtils;
/**
 * @author arijit.biswas
 *
 */
public class TransactionCaptureAction extends FourBlockerAction {

	private static final String ENTITY_SETUP_IS_PENDING_FOR_LEG = "Entity Setup is pending for Leg ";
	private static final String ATTACHMENT_MISSING_FOR_CERTIFICATION_MARKED_AS_YES = "Attachment missing for Certification marked as Yes";
	private static final String IS_JOURNAL_MISSING = "isJournalMissing";
	private static final String CHECKLIST_COMMENTS_IS_MANDATORY_FOR_NO_AND_N_A = "Checklist comments is mandatory for No and N/A";
	private static final String CLOSING_CHECKLIST_HAS_NOT_BEEN_PROPERLY_SELECTED = "Closing Checklist has not been Properly Selected";
	private static final String IS_CORPORATE_GOVERANCE_MISSING = "isCorporateGoveranceMissing";
	private static final String IS_CASH_MAP_MISSING = "isCashMapMissing";
	private static final String IS_STRUCTURE_DIAGRAM_MISSING = "isStructureDiagramMissing";
	private static final String IS_LEGAL_AGREE_MISSING = "isLegalAgreeMissing";
	private static final String APPROVE_REJECT2 = "approveReject: ";
	private static final String WF_STAGE2 = "wfStage: ";
	private static final String ACTION_NAME2 = "actionName: ";
	private static final String CHANGE_TYPE_ID = "changeTypeId";
	private static final String CHANGE_TYPE_COMMENTS = "changeTypeComments";
	private static final String CHANGE_AFTER_APPROVAL_FLAG = "changeAfterApprovalFlag";
	private static final String CLOSING_CHECKLIST_FORM = "closingChecklistForm";
	private static final String IS_ADD_APP = "isAddApp";
	private static final Logger LOGGER = Logger.getLogger(TransactionCaptureAction.class);
	/**
	 * load method is 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HWFServiceException 
	 * @throws NumberFormatException 
	 * @throws HWFStubException 
	 * 
	 */
	@Override
	public ActionForward load(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, HWFServiceException, HWFStubException {
		ActionForward forward = null;

		String requestID = request.getParameter(DEALREQUESTID);
		if(requestID == null) {
			requestID = (String) request.getAttribute(DEALREQUESTID); 
		}
		request.getSession().setAttribute(CURRENTUSERINFOLIST,null);
		request.getSession().setAttribute(DELETEUSERINFOLIST,null);		
		request.getSession().setAttribute(CURRENTADDITIONALAPPROVERS, null); 
		request.getSession().setAttribute(BUSINESSAPPROVERSLIST,null);
		request.getSession().setAttribute(DELETEBUSINESSAPPROVERS,null);
		request.getSession().setAttribute(CURRENTBUSINESSAPPROVERS,null);
		
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		if(deal == null || !deal.getDealSeqId().equals(Integer.valueOf(requestID))) {
			deal = ICFPCommonHelper.getDeal(Integer.valueOf(requestID), serviceClient);
			CurrentDealManager.setActiveDeal(deal, request);
			((DynaActionForm) form).reset(mapping, request);
		}
		
		ICFPCommonHelper.prepareUpdateStatusForm((DynaActionForm)form, mapping, request, this);

		//Additional Approvers BEGIN
		if( deal.getAdditionalApprovers() != null && deal.getAdditionalApprovers().getUserInfos() != null  && deal.getAdditionalApprovers().getUserInfos().size() > 0 ){
			request.getSession().setAttribute(CURRENTADDITIONALAPPROVERS, deal.getAdditionalApprovers()); 
		}
		//Additional Approvers END
		
		if( deal.getBusinessApprovers()!= null && deal.getBusinessApprovers().size() > 0 ){
			request.getSession().setAttribute(BUSINESSAPPROVERSLIST, deal.getBusinessApprovers());  
		}
		
		//Assign a reviewer Button BEGIN
		if(request.getParameter(SECTION) != null){
			String section = request.getParameter(SECTION);
			request.getSession().setAttribute(SECTION, section);
		}
		// Prepare ClosingCheckLists
		populateClosingCheckList(mapping, form, request, deal);
		Boolean isCPADeal = CurrentDealManager.isCPADeal(request);
		Boolean isEquityDeal = CurrentDealManager.isEquityDeal(request);
		if(isCPADeal!=null && isCPADeal) {
			forward = mapping.findForward(SUCCESSCPA);
		} else {
			forward = mapping.findForward(SUCCESS);
		}
		request.setAttribute(ISCPA,isCPADeal);
		request.setAttribute(ISEQUITY,isEquityDeal);
		if(deal.isAddApproverFlag()!=null){
			request.getSession().setAttribute(TransactionCaptureAction.IS_ADD_APP, deal.isAddApproverFlag());
		}
		
		return forward;
	}

	/**
	 * @param mapping
	 * @param form
	 * @param deal
	 * @throws HWFStubException 
	 * @throws HWFServiceException 
	 */
	private void populateClosingCheckList(ActionMapping mapping, ActionForm form, HttpServletRequest request, DealRequest deal) throws HWFServiceException, HWFStubException {
		List<ClosingCheckList> closingCheckListList = deal.getClosingCheckLists();
		
		Map<Integer, ClosingCheckList> closingCheckListMap = new HashMap<Integer, ClosingCheckList>();
		for(ClosingCheckList eachCheckList : closingCheckListList) {
			closingCheckListMap.put(Integer.valueOf(eachCheckList.getCertListId()), eachCheckList);
		}
		
		// Make sure all check lists are existed and populate to form
		List<DynaActionForm> closingCheckListFormList = new ArrayList<DynaActionForm>();
		StaticDataFactory staticDataFactory = (StaticDataFactory)getServlet().getServletContext().getAttribute(StaticDataFactory.CTX_KEY);
		List<NameValue> certificateList = staticDataFactory.getCertificateList();
		for(NameValue certificate : certificateList) {
			ClosingCheckList closingCheckList = closingCheckListMap.get(certificate.getID());
			if(closingCheckList == null) {
				closingCheckList = new ClosingCheckList();
				closingCheckList.setCertListId(String.valueOf(certificate.getID()));
			}
			DynaActionForm closingCheckListForm = (DynaActionForm) FormUtils.setFormValues(TransactionCaptureAction.CLOSING_CHECKLIST_FORM, closingCheckList, this, mapping, request);
			closingCheckListFormList.add(closingCheckListForm);
		}
		((DynaActionForm) form).set(CLOSINGCHECKLISTS, closingCheckListFormList);
		
		String s = (String) ((DynaActionForm) form).get(TransactionCaptureAction.CHANGE_AFTER_APPROVAL_FLAG);
		if(StringUtils.isEmpty(s)){
			if(deal.isChngAfterApprovalsFlag() != null && deal.isChngAfterApprovalsFlag()){
				((DynaActionForm) form).set(TransactionCaptureAction.CHANGE_AFTER_APPROVAL_FLAG, ONE);
			}else if(deal.isChngAfterApprovalsFlag() != null && !deal.isChngAfterApprovalsFlag()){
				((DynaActionForm) form).set(TransactionCaptureAction.CHANGE_AFTER_APPROVAL_FLAG, ICFPConstants.ZERO);
			}
		}else{
			((DynaActionForm) form).set(TransactionCaptureAction.CHANGE_AFTER_APPROVAL_FLAG, s);
		}
		String s1 = (String) ((DynaActionForm) form).get(TransactionCaptureAction.CHANGE_TYPE_ID);
		if(StringUtils.isEmpty(s1)){
			if(deal.getChangeTypeId() != null && deal.getChangeTypeId().intValue() == 1){
				((DynaActionForm) form).set(TransactionCaptureAction.CHANGE_TYPE_ID, ONE);
			}else if(deal.getChangeTypeId() != null && deal.getChangeTypeId().intValue() == 2){
				((DynaActionForm) form).set(TransactionCaptureAction.CHANGE_TYPE_ID, TWO);
			}
		}else{
			((DynaActionForm) form).set(TransactionCaptureAction.CHANGE_TYPE_ID, s1);
		}
		String changeTypeComments = (String) ((DynaActionForm) form).get(TransactionCaptureAction.CHANGE_TYPE_COMMENTS);
		
		if(StringUtils.isEmpty(changeTypeComments)){
			if(deal.getChangeTypeComments() != null){
				((DynaActionForm) form).set(TransactionCaptureAction.CHANGE_TYPE_COMMENTS, deal.getChangeTypeComments());
			}
		}else{
			((DynaActionForm) form).set(TransactionCaptureAction.CHANGE_TYPE_COMMENTS, changeTypeComments);
		}
		
	}
	
	/**
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HWFServiceException
	 * @throws HWFStubException 
	 */
	@Override
	public ActionForward submitDealRequest(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws ICFPException, HWFServiceException, HWFStubException{
		
		UpdateStatus updateStatus = createUpdateStatusBean(mapping, form, request);
		Boolean isCPADeal = CurrentDealManager.isCPADeal(request);
		String forwardPage = ((DynaActionForm) form).getString(FORWARDPAGE);
		DealRequest dealRequest = CurrentDealManager.getCurrentDeal(request);
		dealRequest.setClosingCheckLists(updateStatus.getClosingCheckLists());
		String stageName = updateStatus.getWFStage();
		String action = request.getParameter(ACTIONID);
		String actionName = updateStatus.getActionId();
		String approveReject = updateStatus.getApproveReject();
		LOGGER.info(BEFORE_POPULATING);
		LOGGER.info(TransactionCaptureAction.ACTION_NAME2 + actionName);
		LOGGER.info(TransactionCaptureAction.WF_STAGE2 + stageName);
		LOGGER.info(TransactionCaptureAction.APPROVE_REJECT2 + approveReject);
		boolean doValidate = action.equals(CERTIFY) || action.equals(OVERRIDE);
		request.setAttribute(ISCPA,isCPADeal);
		
		if( doValidate
			&& (CERTFYFO.equalsIgnoreCase(stageName) 
				|| CERTFYCM.equalsIgnoreCase(stageName)) ){	
			boolean isEntityAvailable = validateLegalEntity( request );	
			if( !isEntityAvailable ){
				return mapping.findForward( SUCCESS );
			}
			if(CERTIFY.equalsIgnoreCase(actionName)){
				boolean isAttachmentAvailable = validateAttachments( updateStatus.getClosingCheckLists(), request );
				if(!isAttachmentAvailable){
					return mapping.findForward( SUCCESS );
				}
			}
			
		}
		
		// Remove unselected ClosingLists
		int countCL = 0;
		int countCLforNo = 0;
		int commentErrorCount = 0;
		for(ListIterator<ClosingCheckList> closingCheckListItr = updateStatus.getClosingCheckLists().listIterator(); closingCheckListItr.hasNext(); ) {
			ClosingCheckList closingCheckList = closingCheckListItr.next();
			countCL++;
			String flag = closingCheckList.getCertFlag(); 
			String comments = closingCheckList.getComments();
			if( StringUtils.isEmpty(flag) ) {
				closingCheckListItr.remove();
				countCL--;
			}else{
				
				Integer which = Integer.valueOf(flag.trim());				
				switch(which){
			
				case 2: 
					countCLforNo++;
					if(StringUtils.isEmpty(comments))
						commentErrorCount++;
					break;
				case 3:
					if(StringUtils.isEmpty(comments))
						commentErrorCount++;					
				}
			}
			if("".equals(comments)){
				closingCheckList.setComments(null);
			}
		}
		if(countCL == 0){
			updateStatus.setClosingCheckLists(null);
		}		
		dealRequest.setClosingCheckLists(updateStatus.getClosingCheckLists());
		
		
		if((EIGHT.equals(updateStatus.getRoleId()) && CERTIFY.equals(actionName))){
			if(countCL < 31 || countCLforNo > 0){
				request.setAttribute(FAILUREMSG, TransactionCaptureAction.CLOSING_CHECKLIST_HAS_NOT_BEEN_PROPERLY_SELECTED);				
				return mapping.findForward(SUCCESS);
			}else if(commentErrorCount > 0){
				request.setAttribute(FAILUREMSG, TransactionCaptureAction.CHECKLIST_COMMENTS_IS_MANDATORY_FOR_NO_AND_N_A);
				return mapping.findForward(SUCCESS);
			}				
		}
		
		
		if((FIVE.equals(updateStatus.getRoleId()) && CLOSE.equals(actionName))){
			if(!validateBeforeCloseOut(request, dealRequest)){
				if(isCPADeal!=null && isCPADeal){
					request.setAttribute(ISCPA,isCPADeal);
				}
				return mapping.findForward(SUCCESS);
			}
		}
		
		String vaultID = request.getParameter(ICFPConstants.VAULT_ID);
		if(vaultID!=null && StringUtils.isNotBlank(vaultID)){
			updateStatus.setVaultId(vaultID);
		}else{
			updateStatus.setVaultId(null);
		}
		
		
		updateStatus.setDealSeqId(String.valueOf(dealRequest.getDealSeqId()));
		String requestID = dealRequest.getDealSeqId().toString();
		String currentUserId = UserContext.getCurrentUserContext().getId();
		updateStatus.setApproverSSOId(currentUserId);
		updateStatus.setApproverFname(UserContext.getCurrentUserContext().getFirstName());
		updateStatus.setApproverLname(UserContext.getCurrentUserContext().getLastName());
		updateStatus.setActionId(Actions.getID(actionName));
		if(ICFPConstants.NINTEEN.equals(updateStatus.getActionId())){
			updateStatus.setOrdApprovFlag(ONE);
		}
		LOGGER.info(AFTER_POPULATING);
		LOGGER.info(TransactionCaptureAction.ACTION_NAME2 + updateStatus.getActionId());
		LOGGER.info(TransactionCaptureAction.WF_STAGE2 + updateStatus.getWFStage());
		LOGGER.info(TransactionCaptureAction.APPROVE_REJECT2 + updateStatus.getApproveReject());
		setMsgHeader(updateStatus, OTHERAPPROVER,request);
		dealRequest.setComments(((String)request.getParameter(DEALCOMMENTS)));
		CurrentDealManager.syncCommentsWithFormObject(request);
		CurrentDealManager.setDealObjectToUpdateStatusComments(dealRequest, updateStatus, request);
		
		//Attachment integration starts
		request.setAttribute(CLOSEDATEFLAG, actionName);
		//Attachment integration ends	
		
		if(ADDAPPRV.equalsIgnoreCase(stageName) || APPOVEFO.equalsIgnoreCase(stageName) || APPOVECM.equalsIgnoreCase(stageName)){
			if(!actionName.equals(SAVE)){
				ActionErrors errors = null;
				if (isCPADeal != null && isCPADeal) {
					request.setAttribute(ISCPA, isCPADeal);
				}
				errors = AttachmentValidator.getInstance().validateDeal(request);
				if (errors != null && !errors.isEmpty()) {
					saveErrors(request, errors);
					request.setAttribute(ICFPConstants.AMTERROR,"Please fix the following fields highlighted in red.");
					return mapping.findForward(SUCCESS);
				}

			}
		}
		
		if(ICFPConstants.ZERO.equals(updateStatus.getChangeAfterApprovalFlag())){
			updateStatus.setChangeTypeId(null);
			updateStatus.setChangeTypeComments(null);
		}else if(ONE.equals(updateStatus.getChangeAfterApprovalFlag())){
			if(ONE.equals(updateStatus.getChangeTypeId())){
				updateStatus.setClosingCheckLists(null);
			}
		}else if(updateStatus.getChangeAfterApprovalFlag() == null){
			updateStatus.setChangeTypeId(ICFPConstants.ZERO);
		}else if("".equals(updateStatus.getChangeAfterApprovalFlag())){
			updateStatus.setChangeTypeId(null);
			updateStatus.setChangeAfterApprovalFlag(null);
			updateStatus.setChangeTypeComments(null);
			updateStatus.setClosingCheckLists(null);
		}
		updateStatus.setBusinessRequestId(dealRequest.getUniqueId());
		Utils.cleanBlankElements(updateStatus);
		if(StringUtils.isEmpty(updateStatus.getActionId())){
			throw new ICFPException(HWF_FOURBLOCKER_1001);
		}
		
		// Uploads Underwriting File to GE library
		if((CERTFYFO.equalsIgnoreCase(stageName) 
				|| CERTFYCM.equalsIgnoreCase(stageName)) && 
				(ICFPConstants.SEVENTEEN.equals(updateStatus.getActionId())|| ICFPConstants.EIGHTEEN.equals(updateStatus.getActionId()))) {
				attachmentManager.uploadUnerWritingFile(request);
		}
		CurrentDealManager.syncPropertiesforMeta(dealRequest,updateStatus,request); // Method used for update meta info
		attachmentManager.updateMetadataForAllAttachments(dealRequest);
		updateStatus = serviceClient.invokeService(UPDATEICFPSTATUS, updateStatus, UpdateStatus.class);
		dealRequest = ICFPCommonHelper.getDeal(Integer.valueOf(requestID), serviceClient);
		CurrentDealManager.setActiveDeal(dealRequest, request);
		if (updateStatus != null) {
			String updateMsg = updateStatus.getComments();
			if(forwardPage.equals(SUCCESS)){
				if(isCPADeal!=null && isCPADeal){
					request.setAttribute(ISCPA,isCPADeal);
				}
				request.setAttribute(SAVEMESSAGE, updateMsg);
			}else{
				request.setAttribute(UPDATEMESSAGE, updateMsg);
			}
		}
		return mapping.findForward(forwardPage);
	}
	
	/**
	 * Return true if all these below attachmenets are available else false,	
	 * <li>Strutcture Diagram</li>
	 * <li>Cash Map</li>
	 * <li>Journal Entries</li>
	 * <li>Legal agreement</li>
	 * <h2>Coporate goverance document</h2>
	 * 
	 * @param list 
	 * @param request
	 * @return
	 * @throws ICFPException 
	 */
	private boolean validateAttachments(List<ClosingCheckList> list, HttpServletRequest request) throws ICFPException {
		boolean isValid = false;
		boolean isJournalValid = false;
		boolean isLegalValid = false;
		boolean isCorporateValid = false;
		boolean isStructureValid = false;
		boolean isCashMapValid = false;
		boolean is18No = false, is19No = false, is21No =false, is22No = false, is23No = false, is24No = false; 
		
		Boolean isCPA = (Boolean) request.getAttribute(ISCPA);
		if(isCPA == null)
			isCPA = false;
		
		int i=0;
		for(ClosingCheckList item: list){
						
			String flag = item.getCertFlag();
			boolean isYes = ONE.equals(flag);
			
			switch(i){
			
			case 0: //Journal entrires
				isJournalValid = isAttachmentAvailable(isYes, 7, request, true);
				request.setAttribute(TransactionCaptureAction.IS_JOURNAL_MISSING, !isJournalValid);
				break;
			case 4: //legal agreement
				isLegalValid = isAttachmentAvailable(isYes, 3, request, true);
				request.setAttribute(TransactionCaptureAction.IS_LEGAL_AGREE_MISSING, !isLegalValid);
				break;
			case 18://Corporate Governance
				is18No = !isYes;
			case 19:
				is19No = !isYes;
			case 21:
				is21No = !isYes;
			case 22:
				is22No = !isYes;
			case 23:
				is23No = !isYes;
			case 24:
				is24No = !isYes;
				if(isCorporateValid)// Any one document presence is enough
					break;
				isCorporateValid = isYes && checkAttachments( 5, request, true);				
				break;
			case 25 : //structure diagram
				if(isCPA){//Skip for CPA 
					isStructureValid = true;
				}else{
					isStructureValid = isAttachmentAvailable(isYes, 2, request, false);				
				}
				request.setAttribute(TransactionCaptureAction.IS_STRUCTURE_DIAGRAM_MISSING, !isStructureValid);
				break;
			case 29://cash map
				if(isCPA){//Skip for CPA
					isCashMapValid = true;
				}else{
					isCashMapValid = isAttachmentAvailable(isYes, 1, request, false);					
				}
				request.setAttribute(TransactionCaptureAction.IS_CASH_MAP_MISSING, !isCashMapValid);
				break;
				
			}
			i++;
		}
		if( !isCorporateValid ){ 
			isCorporateValid = is18No && is19No && is21No && is22No && is23No && is24No;
			request.setAttribute(TransactionCaptureAction.IS_CORPORATE_GOVERANCE_MISSING, !isCorporateValid);
		}
		
		isValid = isJournalValid && isLegalValid && isCorporateValid && isStructureValid && isCashMapValid;
		
		if(!isValid)
			request.setAttribute(FAILUREMSG, TransactionCaptureAction.ATTACHMENT_MISSING_FOR_CERTIFICATION_MARKED_AS_YES);
		
		return isValid;
	}
	
	/**
	 * 
	 * @param doCheck
	 * @param type
	 * @param request
	 * @return
	 * @throws ICFPException 
	 */
	private boolean isAttachmentAvailable(boolean doCheck,int type, HttpServletRequest request, boolean isLeg) throws ICFPException{
		
		if( !doCheck )
			return true;
		
		return checkAttachments( type, request, isLeg);				
	}	
	/**
	 * 
	 * @param type
	 * @param request
	 * @param isLeg
	 * @return
	 * @throws ICFPException
	 */
	private boolean checkAttachments(int type, HttpServletRequest request, boolean isLeg) throws ICFPException{
		if (isLeg) {
			Boolean isCPADeal = CurrentDealManager.isCPADeal(request);
			List<LegSummaryVO> legSummarys = null;
			List<CPALegSummaryVO> cpaSummarys = null;
			if(isCPADeal!=null && isCPADeal) {
				cpaSummarys = AttachmentViewFunctions.getCPALegSummaryVOs(request);
				if (!cpaSummarys.isEmpty() && cpaSummarys.size() > 0) {
					DealRequest deal = CurrentDealManager.getCurrentDeal(request);
					for (CPALegSummaryVO vo : cpaSummarys) {
						Object leg = AttachmentUtils.getLeg(vo.getLegNumber(),deal);
						List<Attachment> legAttachments = ICFPLegHelper.getAttachments(leg);
						List<Attachment> attachments = AttachmentUtils.searchAttachmentByType(AttachmentType.fromId(type),legAttachments);
						if (!attachments.isEmpty()) {
							return true;
						}
					}
				}
			} else {
				legSummarys = AttachmentViewFunctions.getLegSummaryVOs(request);
				if (!legSummarys.isEmpty() && legSummarys.size() > 0) {
					DealRequest deal = CurrentDealManager.getCurrentDeal(request);
					for (LegSummaryVO vo : legSummarys) {
						Object leg = AttachmentUtils.getLeg(vo.getLegNumber(),deal);
						List<Attachment> legAttachments = ICFPLegHelper.getAttachments(leg);
						List<Attachment> attachments = AttachmentUtils.searchAttachmentByType(AttachmentType.fromId(type),legAttachments);
						if (!attachments.isEmpty()) {
							return true;
						}
					}
				}
			}
		} else {
			return AttachmentViewFunctions.getDealAttachments(type, request).size() > 0; 
		}
		return false;
	}
	

	/**
	 * validateLegalEntity
	 * @param request
	 * @return
	 * @throws ICFPException
	 */
	private boolean validateLegalEntity(HttpServletRequest request) throws ICFPException {
		List<Object> legs =  CurrentDealManager.getCurrentDeal(request).getLegs().getAllLegs();
		int legNumber = 0;
		Integer legSeqId = null;
		for(Object leg : legs){
			legSeqId = ICFPLegHelper.getLegSeqId(leg);
			// validation not required for ImmediateDradown leg.
			if (leg instanceof RCALegRequest) {
				String eventName = ((RCALegRequest) leg).getLegSummary().getTransactionEventType();
				if(StringUtils.isNotBlank(eventName)) {
					if(eventName.equalsIgnoreCase(IMMEDIATE_DRAWDOWN)){
						continue;
					}
				}
			}
			
			legNumber++;
			
			Entity fromEntity = getFromToEntity(leg, true);
			Entity toEntity = getFromToEntity(leg, false);
			
			boolean isFromEntityPending = false;
			if( fromEntity != null )
				isFromEntityPending = ICFPConstants.Y_CAP.equals(fromEntity.getEntitySetupFlag());
			
			boolean isToEntityPending = false;
			if( toEntity != null)
				isToEntityPending = ICFPConstants.Y_CAP.equals(toEntity.getEntitySetupFlag());
			

			if( isFromEntityPending || isToEntityPending){
				request.setAttribute(FAILUREMSG, TransactionCaptureAction.ENTITY_SETUP_IS_PENDING_FOR_LEG + legSeqId);
					return false;
			}

		}
		return true;
	}

	/**
	 * @param request
	 * @param dealRequest
	 */
	private boolean validateBeforeCloseOut(HttpServletRequest request, DealRequest dealRequest) {
		List<String> error = validateTreasuryCode(dealRequest);
		List<String> error1 = validateTransactionCaptureInTerm(dealRequest);
		List<String> error2 = validateDerivativeAmount(dealRequest);
		List<String> error3 = validateSubLedgerTransactionId(dealRequest);
		List<String> error4 = validateWorkFlowID(dealRequest);
		List<String> allErrors = new ArrayList<String>();
		allErrors.addAll(error);
		allErrors.addAll(error1);
		allErrors.addAll(error2);
		allErrors.addAll(error3);
		allErrors.addAll(error4);
		
		int counter=1;
		StringBuilder errorMsg = new StringBuilder("Following Fields are not saved for Legs <br>");
		if(allErrors.size()>0){
			for (String string : allErrors) {
				errorMsg.append(string);
				if( counter != allErrors.size() )
					errorMsg.append("<br>");
				counter++;
			}
		}
		
		request.setAttribute(FAILUREMSG, errorMsg);
		return counter == 1 ? true:false;
	}

	/**
	 * @param dealRequest
	 */
	private List<String> validateTreasuryCode(DealRequest dealRequest) {
		List<String> errorLeg = new ArrayList<String>();
		int i=1;
		Integer legSeqId = null;
		for (Object leg : dealRequest.getLegs().getAllLegs()) {
			legSeqId = ICFPLegHelper.getLegSeqId(leg);
			// validation not required for ImmediateDradown leg.
			if (leg instanceof RCALegRequest) {
				String eventName = ((RCALegRequest) leg).getLegSummary().getTransactionEventType();
				if(StringUtils.isNotBlank(eventName)) {
					if(eventName.equalsIgnoreCase(IMMEDIATE_DRAWDOWN)){
						continue;
					}
					
				}
			}			
			List<Entity> entities = ICFPLegHelper.getEntityList(leg);
			for (Entity entity : entities) {
				if(entity.getLeTypeId() == 1  && entity.getTreasuryCodes().isEmpty()) {
					errorLeg.add("Lender Treasury Code for Leg #"+legSeqId);
				}else if((entity.getLeTypeId() == 2 ) && 
						entity.getTreasuryCodes().isEmpty()){
					errorLeg.add("Borrower Treasury Code for Leg #"+legSeqId);
				}else if((entity.getLeTypeId() == 7 ) && 
						entity.getTreasuryCodes().isEmpty()){
					errorLeg.add("Participant Treasury Code for Leg #"+legSeqId);
				}else if((entity.getLeTypeId() == 8 ) && 
						entity.getTreasuryCodes().isEmpty()){
					errorLeg.add("PoolLeader Treasury Code for Leg #"+legSeqId);
				}
			}
			i++;
		}
		
		return errorLeg;
	}
	
	/**
	 * 
	 * @param dealRequest
	 * @return
	 */
	private List<String> validateTransactionCaptureInTerm(DealRequest dealRequest) {
		List<String> errorLeg = new ArrayList<String>();
		int i=1;
		Integer legSeqId = null;
		for (Object leg : dealRequest.getLegs().getAllLegs()) {
			legSeqId = ICFPLegHelper.getLegSeqId(leg);
			// validation not required for ImmediateDradown leg.
			if (leg instanceof RCALegRequest) {
				String eventName = ((RCALegRequest) leg).getLegSummary().getTransactionEventType();
				if(StringUtils.isNotBlank(eventName)) {
					if(eventName.equalsIgnoreCase(IMMEDIATE_DRAWDOWN)){
						continue;
					}
				}
			}	
			
			if(ICFPLegHelper.getLegSummary(leg) instanceof LegSummary){
				LegSummary legSummary = (LegSummary) ICFPLegHelper.getLegSummary(leg);
				if(legSummary.getTransactionCaptureInId() == null || legSummary.getTransactionCaptureInId().equals("")){
					errorLeg.add("TransactionCaptureIn for Leg #"+legSeqId);
				}
				if(legSummary.getTermInMonths() != null && Integer.signum(legSummary.getTermInMonths().intValue()) == -1){
					errorLeg.add("Terms in Months is Negative for Leg #"+legSeqId);
				}
			}else if(ICFPLegHelper.getLegSummary(leg) instanceof CPASummary){
				CPASummary cpaSummary = (CPASummary) ICFPLegHelper.getLegSummary(leg);
				if(cpaSummary.getTransactionCaptureIn() == null || cpaSummary.getTransactionCaptureIn().equals("")){
					errorLeg.add("TransactionCaptureIn for Leg #"+legSeqId);
				}
				if(cpaSummary.getTerm() != null && Integer.signum(cpaSummary.getTerm().intValue()) == -1){
					errorLeg.add("Terms in Months is Negative for Leg #"+legSeqId);
				}
			}
			i++;
		}
		return errorLeg;
	}
	/**
	 * 
	 * @param dealRequest
	 * @return
	 */
	private List<String> validateDerivativeAmount(DealRequest dealRequest) {
		List<String> errorLeg = new ArrayList<String>();
		int i=1;
		Integer legSeqId = null;
		for (Object leg : dealRequest.getLegs().getAllLegs()) {
			legSeqId = ICFPLegHelper.getLegSeqId(leg);
			// validation not required for ImmediateDradown leg.
			if (leg instanceof RCALegRequest) {
				String eventName = ((RCALegRequest) leg).getLegSummary().getTransactionEventType();
				if(StringUtils.isNotBlank(eventName)) {
					if(eventName.equalsIgnoreCase(IMMEDIATE_DRAWDOWN)){
						continue;
					}
				}
			}				
			
			if(leg instanceof RCALegRequest) {
				List<DerivativesRequest> derivatives = ICFPLegHelper.getDerivatives(leg);
				for (DerivativesRequest derivativesRequest : derivatives) {
					for (CounterPartyInfo counterParty : derivativesRequest.getCounterPartyInfos()) {
						if(counterParty.getAmt().doubleValue() < 0){
							errorLeg.add("Derivative Amount is Negative for Leg #"+legSeqId+" for Counter Party Day Count #"+counterParty.getDayCountId());
						}
					}
				}
			}else if (leg instanceof OtherLegRequest){
				List<DerivativesRequest> derivatives = ICFPLegHelper.getDerivatives(leg);
				for (DerivativesRequest derivativesRequest : derivatives) {
					for (CounterPartyInfo counterParty : derivativesRequest.getCounterPartyInfos()) {
						if(counterParty.getAmt().doubleValue() < 0){
							errorLeg.add("Derivative Amount is Negative for Leg #"+legSeqId+" for Counter Party Day Count #"+counterParty.getDayCountId());
						}
					}
				}
			}
			i++;
		}
		return errorLeg;
	}
	
	/**
	 * validateSubLedgerTransactionId
	 * @param dealRequest
	 * @return
	 */
	private List<String> validateSubLedgerTransactionId(DealRequest dealRequest) {
		List<String> errorLeg = new ArrayList<String>();
		Integer legSeqId = null;
		for (Object leg : dealRequest.getLegs().getAllLegs()) {
			legSeqId = ICFPLegHelper.getLegSeqId(leg);
			if(leg instanceof CPALegRequest) {
				CPALegRequest cpaLeg = (CPALegRequest) leg;
				String subLedgerTransactionId =  cpaLeg.getCPASummary().getSubLedgerTransactionId();
				if(subLedgerTransactionId==null || StringUtils.isEmpty(subLedgerTransactionId))
				{
					errorLeg.add("Inhouse Bank ID/Loan Model ID is mandatory for Leg #"+legSeqId);
				}
			}				
		}
			
		return errorLeg;
	}
	/**
	 * 
	 * @param dealRequest
	 * @return
	 */
	@SuppressWarnings("unused")
	private List<String> validateDerivativeTradeID(DealRequest dealRequest) {
		List<String> errorLeg = new ArrayList<String>();
		int i=1;
		Integer legSeqId = null;
		for (Object leg : dealRequest.getLegs().getAllLegs()) {
			legSeqId = ICFPLegHelper.getLegSeqId(leg);
			// validation not required for ImmediateDradown leg.
			if (leg instanceof RCALegRequest) {
				String eventName = ((RCALegRequest) leg).getLegSummary().getTransactionEventType();
				if(StringUtils.isNotBlank(eventName)) {
					if(eventName.equalsIgnoreCase(IMMEDIATE_DRAWDOWN)){
						continue;
					}
				}
			}					
			
			if(leg instanceof RCALegRequest) {
				List<DerivativesRequest> derivatives = ICFPLegHelper.getDerivatives(leg);
				for (DerivativesRequest derivativesRequest : derivatives) {
					if(StringUtils.isBlank(derivativesRequest.getDerivativesTradeId())){
						errorLeg.add("Derivative Trade Id is Not Updated for Leg #"+legSeqId);
					}
				}
			}else if (leg instanceof OtherLegRequest){
				List<DerivativesRequest> derivatives = ICFPLegHelper.getDerivatives(leg);
				for (DerivativesRequest derivativesRequest : derivatives) {
					if(StringUtils.isBlank(derivativesRequest.getDerivativesTradeId())){
						errorLeg.add("Derivative Trade Id is Not Updated for Leg #"+legSeqId);
					}
				}
			}
			i++;
		}
		return errorLeg;
	}
	/**
	 * Open the Leg page with update entity details
	 * @throws ICFPException 
	 */
	@Override
	public ActionForward viewInputScreens(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws ICFPException{
		ActionForward forward=null;
		UpdateStatus updateStatus = createUpdateStatusBean(mapping, form, request);
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		deal.setClosingCheckLists(updateStatus.getClosingCheckLists());
		HttpSession session = request.getSession(false);
		InputLegForm inputform = (InputLegForm) session.getAttribute(ICFPConstants.INPUTFORM);
		if(inputform == null){
			inputform = new InputLegForm();
			session.setAttribute(ICFPConstants.INPUTFORM, inputform);
		}
		String legNumber = request.getParameter(ID);
		
			Integer legNumberInt = new Integer(legNumber);
			inputform.setLegNumber(legNumberInt);
		
			Object leg = CurrentDealManager.getLegByNumber(legNumberInt, request);
			
			CurrentDealManager.setCurrentLeg(leg, leg.getClass(), request);	
			
			List<Entity> entities = EntityHelper.fetchEntites(leg);
			List<PendingEntityVO> pEntities = inputform.getPEntities();			
			pEntities.clear();
			
			for(Entity entity:entities){
				if(ICFPConstants.Y_CAP.equals(entity.getEntitySetupFlag())){
					PendingEntityVO pEntity = new PendingEntityVO(entity);					
					pEntities.add(pEntity);
				}				
			}
			
			String proceedtoNextLeg = NO;
			
			if(legNumberInt == deal.getLegs().getAllLegs().size()){
				proceedtoNextLeg = YES;
			}
			request.setAttribute(PROCEEDTONEXTLEG, proceedtoNextLeg);
			request.setAttribute(LEGNUMBER, legNumberInt);
			if(ICFPDay2LegHelper.isDay2Leg(leg)){
				 request.setAttribute(ACTIONID, getActionId());
				 forward = mapping.findForward(DAY2LEG);
				 
			}else{
				forward=mapping.findForward(VIEWINPUTSCREENS);
			}
		return forward;
	}

	/**
	*Returns entity 
	*@isFromEntity - if true Returns the From Entity else returns ToEntity
	*/
	private Entity getFromToEntity(Object leg, Boolean isFromEntity) throws ICFPException{

		Entity returnEntity = null;
		ProductType pType = ICFPLegHelper.getProductType(leg);

		switch(pType){
			
				case RCA:										
				case BOND:
				case OTHER:
				case EQUITY:
				case TERM_LOAN:
					if(isFromEntity){
						returnEntity = EntityHelper.searchEntityInLeg(leg, EntityType.ORIGINAL_LENDER);
					}else{
						returnEntity = EntityHelper.searchEntityInLeg(leg, EntityType.ORIGINAL_BORROWER);
					}
					
					break;
				case CPA:
					if( isFromEntity ){
						returnEntity = EntityHelper.searchEntityInLeg(leg, EntityType.PARTICIPANT);
					}else{
						returnEntity = EntityHelper.searchEntityInLeg(leg, EntityType.POOL_LEADER);
					}
										
					break;					
			}

		return returnEntity;
	}
	/**
	 * 
	 * @param dealRequest
	 * @return
	 */
	private List<String> validateWorkFlowID(DealRequest dealRequest) {
		List<String> errorLeg = new ArrayList<String>();
		int i=1;
		Integer legSeqId = null;
		for (Object leg : dealRequest.getLegs().getAllLegs()) {
			legSeqId = ICFPLegHelper.getLegSeqId(leg);
			// validation not required for ImmediateDradown leg.
			if (leg instanceof RCALegRequest) {
				String eventName = ((RCALegRequest) leg).getLegSummary().getTransactionEventType();
				if(StringUtils.isNotBlank(eventName)) {
					if(eventName.equalsIgnoreCase(IMMEDIATE_DRAWDOWN)){
						continue;
					}
				}
			}				
			
			if(leg instanceof RCALegRequest || leg instanceof OtherLegRequest) {
				List<DerivativesRequest> derivatives = ICFPLegHelper.getDerivatives(leg);
				for (DerivativesRequest derivativesRequest : derivatives) {
					String workFlowID =  derivativesRequest.getTradeRequestWorkflowId();
					
						if(workFlowID==null || StringUtils.isEmpty(workFlowID)){
							errorLeg.add("Manual Trade Request Workflow ID for Leg #"+legSeqId+" is mandatory");
						}
					}
				
			}
			i++;
		}
		return errorLeg;
	}
	
}
