/**
 * 
 */
package com.ge.icfp.frontoffice.action;
import static com.ge.icfp.common.constants.ICFPConstants.ADDCPAREQUEST;
import static com.ge.icfp.common.constants.ICFPConstants.ADDLEG;
import static com.ge.icfp.common.constants.ICFPConstants.AFFIRM;
import static com.ge.icfp.common.constants.ICFPConstants.AFTER_POPULATING;
import static com.ge.icfp.common.constants.ICFPConstants.ASSIGNREVIEW;
import static com.ge.icfp.common.constants.ICFPConstants.BEFORE_POPULATING;
import static com.ge.icfp.common.constants.ICFPConstants.BUSINESSAPPROVERSLIST;
import static com.ge.icfp.common.constants.ICFPConstants.CASHMANAGEMENT;
import static com.ge.icfp.common.constants.ICFPConstants.CURRENTADDITIONALAPPROVERS;
import static com.ge.icfp.common.constants.ICFPConstants.CURRENTBUSINESSAPPROVERS;
import static com.ge.icfp.common.constants.ICFPConstants.CURRENTUSERINFOLIST;
import static com.ge.icfp.common.constants.ICFPConstants.DEALCOMMENTS;
import static com.ge.icfp.common.constants.ICFPConstants.DEALREQUESTID;
import static com.ge.icfp.common.constants.ICFPConstants.DELETEBUSINESSAPPROVERS;
import static com.ge.icfp.common.constants.ICFPConstants.DELETELEG;
import static com.ge.icfp.common.constants.ICFPConstants.DELETEUSERINFOLIST;
import static com.ge.icfp.common.constants.ICFPConstants.EVENTTYPE;
import static com.ge.icfp.common.constants.ICFPConstants.EVENTTYPEID;
import static com.ge.icfp.common.constants.ICFPConstants.EVENTTYPENAME;
import static com.ge.icfp.common.constants.ICFPConstants.EVENTTYPES;
import static com.ge.icfp.common.constants.ICFPConstants.FAILUREMSG;
import static com.ge.icfp.common.constants.ICFPConstants.FORWARDPAGE;
import static com.ge.icfp.common.constants.ICFPConstants.FOURBLOCKER;
import static com.ge.icfp.common.constants.ICFPConstants.FRONTOFFICE;
import static com.ge.icfp.common.constants.ICFPConstants.ICFFO_CASHMANAGEMENT_MEMBER;
import static com.ge.icfp.common.constants.ICFPConstants.ICFFO_FRONTOFFICE_MEMBER;
import static com.ge.icfp.common.constants.ICFPConstants.ICFFO_MIDDLEOFFICE_MEMBER;
import static com.ge.icfp.common.constants.ICFPConstants.ICFFO_TREASURYTAX_MEMBER;
import static com.ge.icfp.common.constants.ICFPConstants.INBOX_SMALL;
import static com.ge.icfp.common.constants.ICFPConstants.INSERT;
import static com.ge.icfp.common.constants.ICFPConstants.ISCPA;
import static com.ge.icfp.common.constants.ICFPConstants.ISEQUITY;
import static com.ge.icfp.common.constants.ICFPConstants.LEGNUMBER;
import static com.ge.icfp.common.constants.ICFPConstants.LEGTYPE;
import static com.ge.icfp.common.constants.ICFPConstants.LEGTYPEID;
import static com.ge.icfp.common.constants.ICFPConstants.MDM;
import static com.ge.icfp.common.constants.ICFPConstants.MIDDLEOFFICE;
import static com.ge.icfp.common.constants.ICFPConstants.ONE;
import static com.ge.icfp.common.constants.ICFPConstants.OPENLEG;
import static com.ge.icfp.common.constants.ICFPConstants.OTHERAPPROVER;
import static com.ge.icfp.common.constants.ICFPConstants.PRODUCTTYPE;
import static com.ge.icfp.common.constants.ICFPConstants.ROLEIDMAP;
import static com.ge.icfp.common.constants.ICFPConstants.ROLEINFO;
import static com.ge.icfp.common.constants.ICFPConstants.SECTION;
import static com.ge.icfp.common.constants.ICFPConstants.SEVEN;
import static com.ge.icfp.common.constants.ICFPConstants.STANDARD;
import static com.ge.icfp.common.constants.ICFPConstants.STATICDATA;
import static com.ge.icfp.common.constants.ICFPConstants.SUCCESS;
import static com.ge.icfp.common.constants.ICFPConstants.TASK;
import static com.ge.icfp.common.constants.ICFPConstants.TASKASSIGN;
import static com.ge.icfp.common.constants.ICFPConstants.TEAMMEMBERID;
import static com.ge.icfp.common.constants.ICFPConstants.TEAMMEMBERLIST;
import static com.ge.icfp.common.constants.ICFPConstants.TPRIORITYTIMINGS;
import static com.ge.icfp.common.constants.ICFPConstants.TRESURYTAG;
import static com.ge.icfp.common.constants.ICFPConstants.TSUMMARYOWNER;
import static com.ge.icfp.common.constants.ICFPConstants.UPDATEICFPSTATUS;
import static com.ge.icfp.common.constants.ICFPConstants.UPDATEMESSAGE;
import static com.ge.icfp.common.constants.ICFPConstants.USD;
import static com.ge.icfp.common.constants.ICFPConstants.USDEQUI;
import static com.ge.icfp.common.constants.ICFPConstants.USER_MGMT;
import static com.ge.icfp.common.constants.ICFPConstants.VALUEDT;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import com.ge.icfp.action.ICFPBaseAction;
import com.ge.icfp.common.attachments.ICFPAttachmentManager;
import com.ge.icfp.common.attachments.validation.AttachmentValidator;
import com.ge.icfp.common.constants.ICFPConstants;
import com.ge.icfp.common.helper.CurrentDealManager;
import com.ge.icfp.common.helper.CurrentInboxManager;
import com.ge.icfp.common.helper.ICFPCommonHelper;
import com.ge.icfp.common.helper.ICFPLegHelper;
import com.ge.icfp.model.AssignReviewer;
import com.ge.icfp.model.DealRequest;
import com.ge.icfp.model.EquityLegRequest;
import com.ge.icfp.model.FourBlocker;
import com.ge.icfp.model.MDM;
import com.ge.icfp.model.MsgHeader;
import com.ge.icfp.model.NameValue;
import com.ge.icfp.model.OtherLegRequest;
import com.ge.icfp.model.RCALegRequest;
import com.ge.icfp.model.Rates;
import com.ge.icfp.model.ReAffirmApprovers;
import com.ge.icfp.model.RoleInfo;
import com.ge.icfp.model.StaticDataManagement;
import com.ge.icfp.model.StaticDataManagement.TransactionEventTypes;
import com.ge.icfp.model.UpdateStatus;
import com.ge.icfp.model.UserInformation;
import com.ge.icfp.newrequest.action.NewFundingRequestAction;
import com.ge.icfp.rules.RuleExecutor;
import com.ge.icfp.util.Actions;
import com.ge.icfp.util.DateUtil;
import com.ge.icfp.util.EventType;
import com.ge.icfp.util.Utils;
import com.ge.icfp.util.ValidateQualitativeAssessments;
import com.hydus.wff.common.bw.ServiceClient;
import com.hydus.wff.core.config.vo.ProcessComponentVO;
import com.hydus.wff.core.context.UserContext;
import com.hydus.wff.core.exception.HWFServiceException;
import com.hydus.wff.core.exception.HWFStubException;
import com.hydus.wff.core.session.SessionManager;

import formdef.plugin.util.FormUtils;
/**
 * @author sreenivasulu.talloju
 *
 */
public class FOFourBlockerAction extends ICFPBaseAction {
	
	private static final String QUALITATIVE_ASSESSMENT_IS_NOT_SAVED_FOR_LEGS = "Qualitative Assessment is not saved for Legs ";

	private static final String REAFFIRM_APPROVERS = "reaffirmApprovers";

	private static final String REAFFIRMAPPROVERS2 = "REAFFIRMAPPROVERS";

	private static final String DEAL_SEQ_ID = "dealSeqId";

	private static final String CURRENT_TIME = "currentTime";

	private static final String EDT = "EDT";

	private static final String EASTERN_DAYLIGHT_TIME = "Eastern Daylight Time";

	private static final String EST = "EST";

	private static final String DAYLIGHT = "Daylight";

	private static final String EASTERN_STANDARD_TIME = "Eastern Standard Time";

	private static final String EST5EDT = "EST5EDT";

	private static final String MMM_DD_YYYY_H_MM_A_ZZZZ = "MMM dd, yyyy - h:mm a zzzz";

	private static final String GETEVENTDETAILS = "GETEVENTDETAILS";

	private static final String ICFP_COUNTRY_TAX = "ICFP-CountryTax";

	private static final String ICFP_TRANSFER_PRICING = "ICFP-TransferPricing";

	private static final String ICFP_TREASURY_TAX = "ICFP-TreasuryTax";

	private static final String ICFP_TREASURY_LEGAL = "ICFP-TreasuryLegal";

	private static final String ICFP_MIDDLE_OFFICE = "ICFP-MiddleOffice";

	private static final String ICFP_CASH_MANAGEMENT = "ICFP-CashManagement";

	private static final String REAFFIRM_APPROVER_LIST = "reaffirmApproverList";

	private static final String TEXTAREA2 = "textarea2";

	private static final String CHNG_AFTER_APPROVALS_FLAG_IDN = "chngAfterApprovalsFlagIDN";

	private static final String OPEN_CPA_LEG = "openCPALeg";

	private static final String IS_FRONT_OFFICE = "isFrontOffice";

	private static final String LATEST_DATE_OF_FINANCIAL_STATEMENT = "latestDateOfFinancialStatement";

	private static final String CHNG_AFTER_APPROVALS_FLAG = "chngAfterApprovalsFlag";

	private static final String OPENDEAL = "opendeal";

	private static final String OPEN_CP_ADEAL = "openCPAdeal";
	
	private static final String DELEGATE = "Delegate";
	
	private static final Logger LOGGER = Logger.getLogger(NewFundingRequestAction.class);
	
	private ServiceClient serviceClient;

	/**
	 * 
	 */
	private ICFPAttachmentManager attachmentManager;
	

	/**
	 * 
	 * @return
	 */
	public ICFPAttachmentManager getAttachmentManager() {
		return attachmentManager;
	}
	/**
	 * 
	 * @param attachmentManager
	 */
	public void setAttachmentManager(ICFPAttachmentManager attachmentManager) {
		this.attachmentManager = attachmentManager;
	}

	/**
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HWFServiceException 
	 * @throws NumberFormatException 
	 */
	public ActionForward openCurrentDealRequest(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, HWFServiceException {
		
		ActionForward forward = null;
		
		ICFPCommonHelper.prepareUpdateStatusForm((DynaActionForm) form, mapping, request, this);
		Boolean isCPADeal = CurrentDealManager.isCPADeal(request);
		Boolean isEquityDeal = CurrentDealManager.isEquityDeal(request);

		
		if(isCPADeal != null && isCPADeal) {
			forward = mapping.findForward(FOFourBlockerAction.OPEN_CP_ADEAL);
		}else {
			forward = mapping.findForward(FOFourBlockerAction.OPENDEAL);
		}
		request.setAttribute(ISCPA,isCPADeal);
		request.setAttribute(ISEQUITY,isEquityDeal);
		return forward;
	}
	
	/**
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HWFServiceException 
	 * @throws NumberFormatException 
	 * @throws HWFStubException 
	 */
	public ActionForward load(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, HWFServiceException, HWFStubException {
		String requestID = request.getParameter(DEALREQUESTID);
		if(requestID==null){
			Integer rid=(Integer)request.getAttribute(DEALREQUESTID);
			if(rid!=null){
			requestID = rid.toString();
			}
		}
		roleInfoInvocation(request);
		request.getSession().setAttribute(CURRENTUSERINFOLIST,null);
		request.getSession().setAttribute(DELETEUSERINFOLIST,null);
		request.getSession().setAttribute(CURRENTADDITIONALAPPROVERS,null);
		request.getSession().setAttribute(BUSINESSAPPROVERSLIST,null);
		request.getSession().setAttribute(DELETEBUSINESSAPPROVERS,null);
		request.getSession().setAttribute(CURRENTBUSINESSAPPROVERS,null);
		
		DealRequest dealRequest = null;
		if(requestID!=null){
			dealRequest = ICFPCommonHelper.getDeal(Integer.valueOf(requestID), serviceClient);
			CurrentDealManager.setActiveDeal(dealRequest, request);
			if(dealRequest != null){
				//Additional Approvers BEGIN
				
				if( dealRequest.getAdditionalApprovers() != null && dealRequest.getAdditionalApprovers().getUserInfos() != null  && dealRequest.getAdditionalApprovers().getUserInfos().size() > 0 ){
					request.getSession().setAttribute(CURRENTADDITIONALAPPROVERS, dealRequest.getAdditionalApprovers());  
				}
				//Additional Approvers END
				
				if( dealRequest.getBusinessApprovers()!= null && dealRequest.getBusinessApprovers().size() > 0 ){
					request.getSession().setAttribute(BUSINESSAPPROVERSLIST, dealRequest.getBusinessApprovers());  
				}

				//Change After Approvals Flag BEGIN
				if(dealRequest.isChngAfterApprovalsFlag() != null){
					request.getSession().setAttribute(FOFourBlockerAction.CHNG_AFTER_APPROVALS_FLAG,dealRequest.isChngAfterApprovalsFlag());
				}
				//Change After Approvals Flag END

				//Assign a reviewer Button BEGIN
				if(request.getParameter(SECTION) != null){
					String section = request.getParameter(SECTION);
					request.getSession().setAttribute(SECTION, section);
				}
				//Assign a reviewer Button END
				
				List<String> roles = SessionManager.getRoles(request);
				String roleName = "";
				if(!roles.isEmpty()){
					for(String actualRole : roles) {
						if(actualRole.contains(TASK)){
							roleName = actualRole;
							break;
						}
					}
					if("".equals(roleName)){
						for(String actualRole : roles) {
							if(actualRole.contains(DELEGATE)){
								roleName = actualRole;
								break;
							}
						}
					}
					
				}
				
				request.getSession().setAttribute(TEAMMEMBERLIST,getTeamMembers(roleName, request));
			}
		}
		
		 ActionForward forward = openCurrentDealRequest(mapping, form, request, response); 
		 DynaActionForm updateStatusForm = (DynaActionForm)form;
		 DynaActionForm fourBlocker = (DynaActionForm)updateStatusForm.get(FOURBLOCKER);
		 DynaActionForm tSummaryOwner = (DynaActionForm)fourBlocker.get(TSUMMARYOWNER);

		 if(dealRequest!=null &&  dealRequest.getLatestDtOfFinSttmnt()!=null){

			 String latestDtOfFinSttmnt = dealRequest.getLatestDtOfFinSttmnt().toString();
			 if(latestDtOfFinSttmnt!=null && latestDtOfFinSttmnt.length()>10){
				 tSummaryOwner.set(FOFourBlockerAction.LATEST_DATE_OF_FINANCIAL_STATEMENT, dealRequest.getLatestDtOfFinSttmnt().getMonth()+"/"+dealRequest.getLatestDtOfFinSttmnt().getDay()+"/"+dealRequest.getLatestDtOfFinSttmnt().getYear());

			 }
		 }
		 return forward;
	}
	
	/**
	 * getTeamMembers
	 * @param roleName
	 * @param request
	 * @return
	 * @throws HWFStubException 
	 * @throws HWFServiceException if any thing happens.
	 */
	public List<NameValue> getTeamMembers(String roleName, HttpServletRequest request) throws HWFServiceException, HWFStubException {
		List<NameValue> teamMembers = new ArrayList<NameValue>();
		MsgHeader msgHeader = new MsgHeader();
		msgHeader.setOpcode(ROLEINFO);
		UserInformation userInfo = new UserInformation();
		RoleInfo roleInfo = new RoleInfo();
		roleInfo.setRoleName(roleName);
		userInfo.getRoleInfos().add(roleInfo);
		userInfo.setMsgHeader(msgHeader);
		userInfo = serviceClient.invokeService(USER_MGMT, userInfo,UserInformation.class);
		if (userInfo != null) {
			ArrayList<RoleInfo> roleInfoList = (ArrayList<RoleInfo>) userInfo.getRoleInfos();
			RoleInfo roleInfo1 = null; 
			Map<String,Integer> roleIDMap = new HashMap<String,Integer>();
			for(int i=0;i<roleInfoList.size();i++)
			{
				boolean isAvailable = false;
				roleInfo1 = (RoleInfo)roleInfoList.get(i);
				for(NameValue oldName : teamMembers) {
					if (roleInfo1.getSsoId().equals(String.valueOf(oldName.getID()))) {
						isAvailable = true;
						break;
					}
				}
				if(isAvailable){
					continue;
				}
				NameValue nameValue = new NameValue();
				nameValue.setID(new Integer(roleInfo1.getSsoId()));
				String userName = roleInfo1.getLastName() +" , " +roleInfo1.getFirstName();
				nameValue.setName(userName);
				
				teamMembers.add(nameValue);
				roleIDMap.put(roleInfo1.getSsoId(), roleInfo1.getRoleId());
				
			}
			request.getSession().setAttribute(ROLEIDMAP, roleIDMap);
		}
		return teamMembers;
	}
	
    /**
	 * cancel
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return success
	 */
	public ActionForward cancel(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		return mapping.findForward(INBOX_SMALL);
	}
	
	/**
	 * Add A Leg
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward addLeg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String frontOffice = request.getParameter(FOFourBlockerAction.IS_FRONT_OFFICE);
		request.setAttribute(FOFourBlockerAction.IS_FRONT_OFFICE,frontOffice);
		DynaActionForm dealRequestForm = (DynaActionForm)form;
		String legTypeId = dealRequestForm.getString(LEGTYPEID);
		String eventTypeId = dealRequestForm.getString(EVENTTYPEID);
		Integer intEventTypeId = (StringUtils.isNotBlank(eventTypeId)) ? Integer.valueOf(eventTypeId) : null;
		ActionForward forward = null;
		// Check allowed leg combination rules
		ActionErrors errors = RuleExecutor.INSTANCE.checkAddLeg(CurrentDealManager.getCurrentDeal(request), Integer.valueOf(legTypeId), intEventTypeId, request);
		if(errors != null && !errors.isEmpty()) {
			saveErrors(request, errors);
			forward = openCurrentDealRequest(mapping, dealRequestForm, request, response);
		} else {
			request.setAttribute(LEGTYPE,legTypeId);
			request.setAttribute(EVENTTYPE, eventTypeId);
			if(!"".equals(eventTypeId) &&  eventTypeId!=null){
				@SuppressWarnings({ "rawtypes", "unchecked" })
				HashMap<String,String> eventMap = (HashMap) dealRequestForm.get(EVENTTYPES);
				request.setAttribute(EVENTTYPENAME, eventMap.get(eventTypeId));
			}
			
			forward = (CurrentDealManager.isCPADeal(request)) 
					? mapping.findForward(ADDCPAREQUEST)
					: mapping.findForward(ADDLEG);
		}
		return forward;
	}
	
	/**
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward deleteLeg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		Integer	legNumber = (Integer) request.getAttribute(LEGNUMBER);
		if(legNumber == null) {
			legNumber = Integer.valueOf(request.getParameter(LEGNUMBER));
		}
		request.setAttribute(LEGNUMBER, legNumber);
		return mapping.findForward(DELETELEG);
			
	}
	
	/**
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward openLeg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Integer legNumber = Integer.valueOf(request.getParameter(LEGNUMBER));
		request.setAttribute(LEGNUMBER, legNumber);
		ActionForward forward = (CurrentDealManager.isCPADeal(request)) 
				? mapping.findForward(FOFourBlockerAction.OPEN_CPA_LEG)
				: mapping.findForward(OPENLEG);
		return forward;
	}
	
	
	/**
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward submitDeal(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception  {
		UpdateStatus updateStatus = createUpdateStatusBean(mapping, form, request,this);
		DealRequest dealRequest = CurrentDealManager.getCurrentDeal(request);
		request.setAttribute(DEALREQUESTID, dealRequest.getDealSeqId());
		//For CPA Front Office checking
		Boolean isCPADeal = CurrentDealManager.isCPADeal(request);
		request.setAttribute(ISCPA,isCPADeal);
		ActionErrors errors = null;
		String actionName = updateStatus.getActionId();
		CurrentDealManager.syncCommentsWithFormObject(request);
		CurrentDealManager.setDealObjectToUpdateStatusComments(dealRequest, updateStatus, request);
		
		if( updateStatus.getActionId().equals(AFFIRM))
		{
			 DynaActionForm dealRequestForm = (DynaActionForm) form; 
			 DynaActionForm fourBlockerForm = (DynaActionForm) dealRequestForm.get(FOURBLOCKER);
			 DynaActionForm tClassificationLevelForm = (DynaActionForm) fourBlockerForm.get(TPRIORITYTIMINGS);
			 String valueDate =  (String) tClassificationLevelForm.get(VALUEDT);
			 
			 errors = ICFPCommonHelper.validateLegData(dealRequest,valueDate,true,false);
			 
			 if(errors!=null && !errors.isEmpty()) {
					saveErrors(request, errors);
					return mapping.findForward(SUCCESS);
			 }
						 
			 DynaActionForm tSummaryOwnerForm = (DynaActionForm)fourBlockerForm.get(TSUMMARYOWNER);
			 
			 if(tSummaryOwnerForm!=null){
			
				 String latestDtOfFinSttmnt = (String)tSummaryOwnerForm.get(FOFourBlockerAction.LATEST_DATE_OF_FINANCIAL_STATEMENT);
				 
				 if(latestDtOfFinSttmnt!=null && latestDtOfFinSttmnt.trim().length()>0){
					 errors = DateUtil.validateLatestDtOfFinSttmnt(latestDtOfFinSttmnt,errors);
				 }
				 
			 }	
			 
			 
			 XMLGregorianCalendar dealRequestDate = dealRequest.getRequestDt();
			
			 errors = Utils.validateValueDt(valueDate,errors,dealRequestDate);	
			 if(errors!=null && !errors.isEmpty()) {
				saveErrors(request, errors);
				return mapping.findForward(SUCCESS);
			 }
			 errors = AttachmentValidator.getInstance().validateDeal(request);
			 if(errors!=null && !errors.isEmpty()) {
				saveErrors(request, errors);
				return mapping.findForward(SUCCESS);
			 }
		}
				
		if( updateStatus.getActionId().equals(AFFIRM)
				&& !validateAssessments(request, dealRequest) ){
			return mapping.findForward(SUCCESS);
		}
		
		if((request.getSession().getAttribute(CURRENTUSERINFOLIST) != null) ||  (request.getSession().getAttribute(DELETEUSERINFOLIST) != null)) {
			CurrentDealManager.populateAdditionalApprovers(request, updateStatus, dealRequest);
		}
		
		if((request.getSession().getAttribute(BUSINESSAPPROVERSLIST) != null) ||  (request.getSession().getAttribute(DELETEBUSINESSAPPROVERS) != null)) {
			CurrentDealManager.populateBusinessApprovers(request, updateStatus, dealRequest);
		}
		
		//Additional Approvers END
		if(request.getParameter("chngAfterApprovalsFlagIDY") != null ){
			String ChngAfterApprovals = request.getParameter("chngAfterApprovalsFlagIDY");
			updateStatus.setChangeAfterApprovalFlag(ChngAfterApprovals);
		}
		if(request.getParameter(FOFourBlockerAction.CHNG_AFTER_APPROVALS_FLAG_IDN) != null ){
			String ChngAfterApprovals = request.getParameter(FOFourBlockerAction.CHNG_AFTER_APPROVALS_FLAG_IDN);
			updateStatus.setChangeAfterApprovalFlag(ChngAfterApprovals);
		}

		updateStatus.setDealSeqId(String.valueOf(dealRequest.getDealSeqId()));
		String currentUserId = UserContext.getCurrentUserContext().getId();
		String lastName = UserContext.getCurrentUserContext().getLastName();
		String firstName = UserContext.getCurrentUserContext().getFirstName();

		updateStatus.setApproverSSOId(currentUserId);
		updateStatus.setApproverLname(lastName);
		updateStatus.setApproverFname(firstName);
		updateStatus.setActionId(Actions.getID(updateStatus.getActionId()));
		updateStatus.setComments((String) request.getParameter(DEALCOMMENTS));

		updateStatus.setMaterialCFlag(ICFPConstants.ZERO);
		updateStatus.setAddiAppFlag(ICFPConstants.ZERO);
		//Attachment integration ends	
		if(updateStatus.getActionId().equals(SEVEN)){
			updateStatus.setAcctionComments((String) request.getParameter(FOFourBlockerAction.TEXTAREA2));
			updateStatus.setSocmFlag(ICFPConstants.ZERO);
			updateStatus.setSoctFlag(ICFPConstants.ZERO);
			updateStatus.setSomidFlag(ICFPConstants.ZERO);
			updateStatus.setSotlFlag(ICFPConstants.ZERO);
			updateStatus.setSotpFlag(ICFPConstants.ZERO);
			updateStatus.setSottFlag(ICFPConstants.ZERO);

			String approversList[]=request.getParameterValues(FOFourBlockerAction.REAFFIRM_APPROVER_LIST);
			if(approversList != null) {
				for(String approver:approversList){
					if(approver.equalsIgnoreCase(FOFourBlockerAction.ICFP_CASH_MANAGEMENT)){
						updateStatus.setSocmFlag(ONE);
						continue;
					}
					if(approver.equalsIgnoreCase(FOFourBlockerAction.ICFP_MIDDLE_OFFICE)){
						updateStatus.setSomidFlag(ONE);
						continue;
					}
					if(approver.equalsIgnoreCase(FOFourBlockerAction.ICFP_TREASURY_LEGAL)){
						updateStatus.setSotlFlag(ONE);
						continue;
					}
					if(approver.equalsIgnoreCase(FOFourBlockerAction.ICFP_TREASURY_TAX)){
						updateStatus.setSottFlag(ONE);
						continue;
					}
					if(approver.equalsIgnoreCase(FOFourBlockerAction.ICFP_TRANSFER_PRICING)){
						updateStatus.setSotpFlag(ONE);
						continue;
					}
					if(approver.equalsIgnoreCase(FOFourBlockerAction.ICFP_COUNTRY_TAX)){
						updateStatus.setSoctFlag(ONE);
						continue;
					}
				}
			}
			
		}
		
		if(updateStatus.getFourBlocker().getTSummaryOwner().getLatestDateOfFinancialStatement()!=null && updateStatus.getFourBlocker().getTSummaryOwner().getLatestDateOfFinancialStatement().toString().length()>10)
			{
				updateStatus.getFourBlocker().getTSummaryOwner().setFinancialStatementFlag(true);
			}else{
				updateStatus.getFourBlocker().getTSummaryOwner().setFinancialStatementFlag(false);
			}
		
		if(ASSIGNREVIEW.equals(actionName)){
			//show Assign Reviewer button
			setMsgHeader(updateStatus, TASKASSIGN);
			updateStatus.setApproveReject(SEVEN);
			if(null != request.getParameter(TEAMMEMBERID) ){
				List<AssignReviewer> assignReviewers = new ArrayList<AssignReviewer>(); 
				FourBlocker fourBlocker = new FourBlocker();
				AssignReviewer assignReviewer = new AssignReviewer();
				String ssoID = request.getParameter(TEAMMEMBERID);
				@SuppressWarnings("unchecked")
				Map<String,Integer> roleIDMap = (HashMap<String,Integer>)request.getSession().getAttribute(ROLEIDMAP);
				String roleID =  roleIDMap.get(ssoID).toString();
				assignReviewer.setOpcode(INSERT);
				assignReviewer.setSSOID(ssoID); 
				assignReviewer.setRoleId(roleID);
				
				assignReviewers.add(assignReviewer);
				
				fourBlocker.setAssignReviewers(assignReviewers);
				updateStatus.setFourBlocker(fourBlocker);
			}
		}else{
			setMsgHeader(updateStatus, OTHERAPPROVER);
		}
		
		
		if(isCPADeal!=null && isCPADeal){
			if(updateStatus.getFourBlocker() != null && updateStatus.getFourBlocker().getTSummaryOwner() != null){
			updateStatus.getFourBlocker().getTSummaryOwner().setSecurityType(null);
			}
		}
		dealRequest.setComments(((String)request.getParameter(DEALCOMMENTS)));
		//Business ID
		updateStatus.setBusinessRequestId(dealRequest.getUniqueId());
		
		CurrentDealManager.syncPropertiesforMeta(dealRequest,updateStatus,request); // Method used for update meta info
		attachmentManager.updateMetadataForAllAttachments(dealRequest);
		updateStatus = serviceClient.invokeService(UPDATEICFPSTATUS, updateStatus, UpdateStatus.class);
		if (updateStatus != null) {
			String updateMsg = updateStatus.getComments();
			request.setAttribute(UPDATEMESSAGE, updateMsg);
		}
		String forwardPage = ((DynaActionForm) form).getString(FORWARDPAGE);
		return mapping.findForward(forwardPage);
	}

	/**
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @return
	 */
	private UpdateStatus createUpdateStatusBean(ActionMapping mapping, ActionForm form, HttpServletRequest request,Action action) {
		LOGGER.info(BEFORE_POPULATING);
		LOGGER.info("WFId: " + request.getParameter("WFId"));
		LOGGER.info("WFStage: " + request.getParameter("WFStage"));
		LOGGER.info("queueName: " + request.getParameter("queueName"));
		UpdateStatus updateStatus = (UpdateStatus) FormUtils.getFormValues(form, this, mapping, request);
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		
		if(StringUtils.isEmpty(updateStatus.getWFId()) 
				|| StringUtils.isEmpty(updateStatus.getWFStage())
				|| StringUtils.isEmpty(updateStatus.getQueueName())){
			updateStatus.setDealSeqId(deal.getDealSeqId().toString());
			CurrentInboxManager.updateWorkflowData(updateStatus, request);
		}
		LOGGER.info(AFTER_POPULATING);
		LOGGER.info("WFId: " + updateStatus.getWFId());
		LOGGER.info("WFStage: " + updateStatus.getWFStage());
		LOGGER.info("queueName: " + updateStatus.getQueueName());
		DynaActionForm updateStatusForm = (DynaActionForm) form;
		ICFPLegHelper.syncTClassificationLevel(updateStatus, updateStatusForm,
				request, action.getServlet().getServletContext(), mapping,
				action);
		ICFPLegHelper.syncTPriorityTimings(updateStatus, updateStatusForm,
				request, action.getServlet().getServletContext(), mapping,
				action);
		ICFPLegHelper.syncTSummaryOwner(updateStatus, updateStatusForm,
				request, action.getServlet().getServletContext(), mapping,
				action);
		return updateStatus;
	}	
	
	
	/**
	 * 
	 * @param updateStatus
	 * @param opcode
	 */
	private void setMsgHeader(UpdateStatus updateStatus, String opcode) {
		MsgHeader msgHeader = new MsgHeader();
		msgHeader.setOpcode(opcode);
		String currentUserId = UserContext.getCurrentUserContext().getId();
		msgHeader.setAuditCreator(currentUserId);
		msgHeader.setAuditModifier(currentUserId);
		updateStatus.setMsgHeader(msgHeader);
	}
	
	
	/**
	 * getEventDetails
	 * @return
	 * @throws HWFServiceException
	 * @throws HWFStubException
	 */
	public ActionForward getEventDetails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws HWFServiceException, HWFStubException {
		MsgHeader msgHeader = new MsgHeader();
		msgHeader = new MsgHeader();
		msgHeader.setOpcode(FOFourBlockerAction.GETEVENTDETAILS);
		
		String productTypeId = request.getParameter(PRODUCTTYPE);

		StaticDataManagement staticDataObject = new StaticDataManagement();
		List<TransactionEventTypes> transTypesLst = new ArrayList<TransactionEventTypes>();
		TransactionEventTypes transTypes = new TransactionEventTypes();
		transTypes.setLegTypeID(productTypeId);
		transTypesLst.add(transTypes);
					
		staticDataObject.setTransactionEventTypes(transTypesLst);
		staticDataObject.setMsgHeader(msgHeader);
		staticDataObject = serviceClient.invokeService(STATICDATA, staticDataObject,StaticDataManagement.class);
		
		transTypesLst =  staticDataObject.getTransactionEventTypes();
		
		Map<String,String> eventMap = new HashMap<String, String>();
		for(TransactionEventTypes eventTypes:transTypesLst){
			String eventTypeId = eventTypes.getEventTypeID();
			if (eventTypeId != null
					&& Integer.parseInt(eventTypeId) != EventType.CORRECTION.getId()) {
			eventMap.put(eventTypes.getEventTypeID(),eventTypes.getEventTypeName());
			}
		}
		
	    ((DynaActionForm)form).set(EVENTTYPES, eventMap);
	    return mapping.findForward(SUCCESS);
	}
	
	/**
	 * This method is used for refresh the latest SpotRates from service
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return forward ActionForward
	 * @throws Exception
	 */
	public ActionForward refreshSpotRates(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String currency = "";
		Double amount = 0.0;
		List<Rates> ratesList = new ArrayList<Rates>();
		DealRequest dealRequest = CurrentDealManager.getCurrentDeal(request);
		UpdateStatus updateStatus = (UpdateStatus) FormUtils.getFormValues(form, this, mapping, request);
		String currentTime = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat(FOFourBlockerAction.MMM_DD_YYYY_H_MM_A_ZZZZ);
		dateFormat.setTimeZone(TimeZone.getTimeZone(FOFourBlockerAction.EST5EDT));
		String todayTime = dateFormat.format(new Date());
		if (todayTime.contains(STANDARD)) {
			currentTime = todayTime.replaceAll(FOFourBlockerAction.EASTERN_STANDARD_TIME, FOFourBlockerAction.EST);
		} else if (todayTime.contains(FOFourBlockerAction.DAYLIGHT)) {
			currentTime = todayTime.replaceAll(FOFourBlockerAction.EASTERN_DAYLIGHT_TIME, FOFourBlockerAction.EDT);
		}
		if(dealRequest.getSpotRatesTimestamp() != null)
		{
			request.setAttribute(FOFourBlockerAction.CURRENT_TIME,dealRequest.getSpotRatesTimestamp());
		}
		else{
			request.setAttribute(FOFourBlockerAction.CURRENT_TIME,currentTime);
			updateStatus.setSpotRatesTimestamp((XMLGregorianCalendar) request.getAttribute(currentTime));	
		}
		
		if (dealRequest.getLegs() != null
				&& dealRequest.getLegs().getAllLegs() != null) {
			List<Object> legList = dealRequest.getLegs().getAllLegs();
			for (Object leg : legList) {

				if (leg instanceof RCALegRequest) {
					currency = ((RCALegRequest) leg).getLegSummary()
							.getOriginalCCY();
					amount = ((RCALegRequest) leg).getLegSummary()
							.getOriginalCCYAmount();

				} else if (leg instanceof EquityLegRequest) {
					currency = ((EquityLegRequest) leg).getLegSummary()
							.getOriginalCCY();
					amount = ((EquityLegRequest) leg).getLegSummary()
							.getOriginalCCYAmount();

				} else if (leg instanceof OtherLegRequest) {
					currency = ((OtherLegRequest) leg).getLegSummary()
							.getOriginalCCY();
					amount = ((OtherLegRequest) leg).getLegSummary()
							.getOriginalCCYAmount();

				}

				if (currency != null && !currency.equalsIgnoreCase(USD)) {
					Rates rates = new Rates();
					rates.setFrequency(amount);
					rates.setObjectCurrencyCode(currency);
					
					ratesList.add(rates);
				}

			}
			if (ratesList.size() > 0) {

				getLatestSpotRates(ratesList, legList);

			}
		}

		return mapping.findForward(FOFourBlockerAction.OPENDEAL);
	}

	/**
	 * This method  is used for to set the latest SpotRates 
	 * @param ratesList List
	 * @param legList List
	 * @throws Exception
	 */
	private void getLatestSpotRates(List<Rates> ratesList, List<Object> legList)
			throws Exception {

		MsgHeader msgHeader = new MsgHeader();
		msgHeader.setOpcode(USDEQUI);
		MDM mdmObject = new MDM();
		mdmObject.setMsgHeader(msgHeader);
		mdmObject.setRates(ratesList);
		mdmObject = serviceClient.invokeService(MDM, mdmObject, MDM.class);
		if (mdmObject != null) {
			List<Rates> latestRates = mdmObject.getRates();
			for (Rates rate : latestRates) {
				for (Object leg : legList) {

					if (leg instanceof RCALegRequest) {

						RCALegRequest rcaLeg = (RCALegRequest) leg;
						setRCALegSpotRates(rcaLeg, rate);

					} else if (leg instanceof EquityLegRequest) {
						EquityLegRequest eqLeg = (EquityLegRequest) leg;
						setEquityLegSpotRates(eqLeg, rate);

					} else if (leg instanceof OtherLegRequest) {
						OtherLegRequest otLeg = (OtherLegRequest) leg;
						setOtherLegSpotRates(otLeg, rate);

					}

				}
			}

		}
	}
	
	/**
	 * This method  is used for to set the latest RCALegRequest SpotRates 
	 * @param leg RCALegRequest
	 * @param rate Rates
	 */
	private void setRCALegSpotRates(RCALegRequest leg, Rates rate) {
		String currency = "";
		Double amount = 0.0;
		Double originalAmount = 0.0;
		currency = leg.getLegSummary().getOriginalCCY();
		amount = leg.getLegSummary().getOriginalCCYAmount();
		if (currency != null && amount != null) {
			if (StringUtils.isNotBlank(rate.getApplicationName())) {
				originalAmount = Double.valueOf(rate.getApplicationName());

			}

			if (currency.equalsIgnoreCase(rate.getObjectCurrencyCode())
					&& amount.equals(originalAmount)) {
				leg.getLegSummary().setUSDEquivalent(rate.getFrequency());
			}

		}

	}
	
	/**
	 * This method  is used for to set the latest EquityLegRequest SpotRates 
	 * @param leg EquityLegRequest
	 * @param rate Rates
	 */
	private void setEquityLegSpotRates(EquityLegRequest leg, Rates rate) {
		String currency = "";
		Double amount = 0.0;
		Double originalAmount = 0.0;
		currency = leg.getLegSummary().getOriginalCCY();
		amount = leg.getLegSummary().getOriginalCCYAmount();
		if (currency != null && amount != null) {
			if (StringUtils.isNotBlank(rate.getApplicationName())) {
				originalAmount = Double.valueOf(rate.getApplicationName());

			}
			if (currency.equalsIgnoreCase(rate.getObjectCurrencyCode())
					&& amount.equals(originalAmount)) {
				leg.getLegSummary().setUSDEquivalent(rate.getFrequency());
			}

		}

	}
	
	/**
	 * This method  is used for to set the latest OtherLegRequest SpotRates 
	 * @param leg OtherLegRequest
	 * @param rate Rates
	 */
	private void setOtherLegSpotRates(OtherLegRequest leg, Rates rate) {
		String currency = "";
		Double amount = 0.0;
		Double originalAmount = 0.0;
		currency = leg.getLegSummary().getOriginalCCY();
		amount = leg.getLegSummary().getOriginalCCYAmount();
		if (currency != null && amount != null) {
			if (StringUtils.isNotBlank(rate.getApplicationName())) {
				originalAmount = Double.valueOf(rate.getApplicationName());

			}
			if (currency.equalsIgnoreCase(rate.getObjectCurrencyCode())
					&& amount.equals(originalAmount)) {
				leg.getLegSummary().setUSDEquivalent(rate.getFrequency());
			}

		}

	}
		
	/**
	 * getTeamMembers
	 * @param roleName
	 * @param request
	 * @return
	 * @throws Exception if any thing happens.
	 */
	public ActionForward getReaffirmApprovers(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String dealSeqId = request.getParameter(FOFourBlockerAction.DEAL_SEQ_ID);
		String currentUserId = UserContext.getCurrentUserContext().getId();
		List<ReAffirmApprovers> reaffirmApprovers = null;
		MsgHeader msgHeader = new MsgHeader();
		msgHeader.setOpcode(FOFourBlockerAction.REAFFIRMAPPROVERS2);
		UserInformation userInfo = new UserInformation();
		ReAffirmApprovers reaffirmInput = new ReAffirmApprovers();
		reaffirmInput.setDealSeqID(Integer.valueOf(dealSeqId));
		reaffirmInput.setSSOID(currentUserId);
		reaffirmInput.setFOSSOID(currentUserId);
		userInfo.getReAffirmApprovers().add(reaffirmInput);
		userInfo.setMsgHeader(msgHeader);
		userInfo = serviceClient.invokeService(USER_MGMT, userInfo,UserInformation.class);
		if (userInfo != null) {
			reaffirmApprovers = (ArrayList<ReAffirmApprovers>) userInfo.getReAffirmApprovers();
		}
		request.setAttribute(FOFourBlockerAction.REAFFIRM_APPROVERS, reaffirmApprovers);
		return  mapping.findForward(FOFourBlockerAction.REAFFIRM_APPROVERS);
	}
	
	/**
	 * validateAssessments
	 * @param request
	 * @param dealRequest
	 * @return
	 */
	protected boolean validateAssessments(HttpServletRequest request,
			DealRequest dealRequest) {
		ValidateQualitativeAssessments validate = new ValidateQualitativeAssessments();
		List<Integer>errors =  validate.checkFOError( dealRequest.getLegs().getAllLegs(), request );
		int counter = 1;
		StringBuilder errorMsg = new StringBuilder(FOFourBlockerAction.QUALITATIVE_ASSESSMENT_IS_NOT_SAVED_FOR_LEGS);
		for(Integer i : errors){
			errorMsg.append( i );
			if( counter != errors.size() )
				errorMsg.append(",");
			counter++;
		}
		if(!errors.isEmpty()) {
			request.setAttribute(FAILUREMSG, errorMsg);
		}
		return errors.isEmpty();
	}
	/**
	 * 
	 * @param request
	 * @throws HWFServiceException
	 * @throws HWFStubException
	 */
	protected void roleInfoInvocation(HttpServletRequest request) throws HWFServiceException, HWFStubException {
		MsgHeader msgHeader1 = new MsgHeader();
		msgHeader1.setOpcode(ROLEINFO);
		UserInformation userInfo = new UserInformation();
		userInfo.setMsgHeader(msgHeader1);
		userInfo = serviceClient.invokeService(USER_MGMT, userInfo,UserInformation.class);
		if (userInfo != null) {
			ArrayList<RoleInfo> roleInfoList = (ArrayList<RoleInfo>) userInfo.getRoleInfos();
			RoleInfo roleInfo = new RoleInfo(); 
			List<ProcessComponentVO> processComp1 = new ArrayList<ProcessComponentVO>();
			List<ProcessComponentVO> processComp2 = new ArrayList<ProcessComponentVO>();
			List<ProcessComponentVO> processComp3 = new ArrayList<ProcessComponentVO>();
			List<ProcessComponentVO> processComp4 = new ArrayList<ProcessComponentVO>();
			
			for(int i=0;i<roleInfoList.size();i++)
			{
				roleInfo = (RoleInfo)roleInfoList.get(i);
				ProcessComponentVO processComp = new ProcessComponentVO();
				processComp.setId( String.valueOf(roleInfo.getRoleId()) );
				processComp.setLabel(roleInfo.getRoleName());
				processComp.setId( roleInfo.getSsoId() );
				String UserName = roleInfo.getLastName() +" , " +roleInfo.getFirstName();
				
				processComp.setLabel(UserName);
				if(roleInfo.getRoleName().equalsIgnoreCase(ICFFO_MIDDLEOFFICE_MEMBER)){//Front Office
					processComp1.add(processComp);
				}else if(roleInfo.getRoleName().equalsIgnoreCase(ICFFO_FRONTOFFICE_MEMBER)){//Middle Office
					processComp2.add(processComp);
				}else if(roleInfo.getRoleName().equalsIgnoreCase(ICFFO_CASHMANAGEMENT_MEMBER)){//CM
					processComp3.add(processComp);
				}else if(roleInfo.getRoleName().equalsIgnoreCase(ICFFO_TREASURYTAX_MEMBER)){//TT
					processComp4.add(processComp);
				}
			}
			request.getSession().setAttribute(MIDDLEOFFICE, processComp1);
			request.getSession().setAttribute(FRONTOFFICE, processComp2);
			request.getSession().setAttribute(CASHMANAGEMENT, processComp3);
			request.getSession().setAttribute(TRESURYTAG, processComp4);
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
}
