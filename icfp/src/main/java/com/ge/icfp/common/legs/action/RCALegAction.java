/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: RCALegAction.java
 * Purpose: RCALegAction used for adding,deleting,updating leg details
 */
package com.ge.icfp.common.legs.action;

import static com.ge.icfp.common.constants.ICFPConstants.ACTIONID;
import static com.ge.icfp.common.constants.ICFPConstants.ACTIONID_SMALL;
import static com.ge.icfp.common.constants.ICFPConstants.ADDLEG;
import static com.ge.icfp.common.constants.ICFPConstants.ADDORMODIFYDERIVATIVE;
import static com.ge.icfp.common.constants.ICFPConstants.ADDORMODIFYFLAG;
import static com.ge.icfp.common.constants.ICFPConstants.ADDORMODIFYREQ;
import static com.ge.icfp.common.constants.ICFPConstants.AMENDEDUSDEQUIVALENTAMT;
import static com.ge.icfp.common.constants.ICFPConstants.BORROWERENTITY;
import static com.ge.icfp.common.constants.ICFPConstants.BORROWERTCODEENTITY;
import static com.ge.icfp.common.constants.ICFPConstants.CDR;
import static com.ge.icfp.common.constants.ICFPConstants.CPA;
import static com.ge.icfp.common.constants.ICFPConstants.CPALEGSUMMARY;
import static com.ge.icfp.common.constants.ICFPConstants.DAY2LEG;
import static com.ge.icfp.common.constants.ICFPConstants.DAYONECCY;
import static com.ge.icfp.common.constants.ICFPConstants.DAYONEUSDEQUIVALENT;
import static com.ge.icfp.common.constants.ICFPConstants.DAYTWOOPERATIONS;
import static com.ge.icfp.common.constants.ICFPConstants.DEAL;
import static com.ge.icfp.common.constants.ICFPConstants.DEALREQUESTID;
import static com.ge.icfp.common.constants.ICFPConstants.DELETE;
import static com.ge.icfp.common.constants.ICFPConstants.DRAFT;
import static com.ge.icfp.common.constants.ICFPConstants.DRAFT_GLOBEL;
import static com.ge.icfp.common.constants.ICFPConstants.EBOARDAPPROVALREQUIREDFLAG;
import static com.ge.icfp.common.constants.ICFPConstants.EBOARDARFLAGVALUE;
import static com.ge.icfp.common.constants.ICFPConstants.ENTITYFORM;
import static com.ge.icfp.common.constants.ICFPConstants.EVENTTYPE;
import static com.ge.icfp.common.constants.ICFPConstants.EVENTTYPENAME;
import static com.ge.icfp.common.constants.ICFPConstants.EXCEPTIONNUMBER;
import static com.ge.icfp.common.constants.ICFPConstants.FACILITYINCDECUSDEQUIVALENTAMT;
import static com.ge.icfp.common.constants.ICFPConstants.FACILITYINCREASEDECREASE;
import static com.ge.icfp.common.constants.ICFPConstants.FLOATINGRATEINDEX;
import static com.ge.icfp.common.constants.ICFPConstants.GETGOLDINFO;
import static com.ge.icfp.common.constants.ICFPConstants.GOLDIDFLAG;
import static com.ge.icfp.common.constants.ICFPConstants.GROSSSETTLEMENTAMT;
import static com.ge.icfp.common.constants.ICFPConstants.INDEXTERMMAP;
import static com.ge.icfp.common.constants.ICFPConstants.INSERT;
import static com.ge.icfp.common.constants.ICFPConstants.INSERTDEAL;
import static com.ge.icfp.common.constants.ICFPConstants.LEGEXIST;
import static com.ge.icfp.common.constants.ICFPConstants.LEGNUMBER;
import static com.ge.icfp.common.constants.ICFPConstants.LEGNUMBER_STRING;
import static com.ge.icfp.common.constants.ICFPConstants.LEGSEQID;
import static com.ge.icfp.common.constants.ICFPConstants.LEGSUMMARY;
import static com.ge.icfp.common.constants.ICFPConstants.LEGTYPE;
import static com.ge.icfp.common.constants.ICFPConstants.LEGTYPEID;
import static com.ge.icfp.common.constants.ICFPConstants.LEG_LABEL;
import static com.ge.icfp.common.constants.ICFPConstants.LENDERDETAILS;
import static com.ge.icfp.common.constants.ICFPConstants.LENDERENTITY;
import static com.ge.icfp.common.constants.ICFPConstants.LENDERORPROVIDER;
import static com.ge.icfp.common.constants.ICFPConstants.LENDERTCODE;
import static com.ge.icfp.common.constants.ICFPConstants.LENDERTCODEENTITY;
import static com.ge.icfp.common.constants.ICFPConstants.LENDERTREASURYCODE;
import static com.ge.icfp.common.constants.ICFPConstants.MDM;
import static com.ge.icfp.common.constants.ICFPConstants.MODIFY;
import static com.ge.icfp.common.constants.ICFPConstants.NO_CAP;
import static com.ge.icfp.common.constants.ICFPConstants.OPENLEG;
import static com.ge.icfp.common.constants.ICFPConstants.ORIGINALCCY;
import static com.ge.icfp.common.constants.ICFPConstants.ORIGINALCCYAMOUNT;
import static com.ge.icfp.common.constants.ICFPConstants.PRODUCTTYPE;
import static com.ge.icfp.common.constants.ICFPConstants.RATEINFORMATION;
import static com.ge.icfp.common.constants.ICFPConstants.REMOVECURRENT;
import static com.ge.icfp.common.constants.ICFPConstants.SAVE;
import static com.ge.icfp.common.constants.ICFPConstants.SAVED_SUCCESSFULLY;
import static com.ge.icfp.common.constants.ICFPConstants.SAVEMSG;
import static com.ge.icfp.common.constants.ICFPConstants.SUCCESS;
import static com.ge.icfp.common.constants.ICFPConstants.TCODE;
import static com.ge.icfp.common.constants.ICFPConstants.TRANSACTIONEVENTTYPE;
import static com.ge.icfp.common.constants.ICFPConstants.TRANSACTIONEVENTTYPEID;
import static com.ge.icfp.common.constants.ICFPConstants.TREASURYCODE;
import static com.ge.icfp.common.constants.ICFPConstants.TRUE_SMALL;
import static com.ge.icfp.common.constants.ICFPConstants.TWELVE;
import static com.ge.icfp.common.constants.ICFPConstants.TWO;
import static com.ge.icfp.common.constants.ICFPConstants.UPDATE;
import static com.ge.icfp.common.constants.ICFPConstants.UPDATED_LABEL;
import static com.ge.icfp.common.constants.ICFPConstants.UPDATEMESSAGE;
import static com.ge.icfp.common.constants.ICFPConstants.USDEQUI;
import static com.ge.icfp.common.constants.ICFPConstants.USDEQUIVALENT;
import static com.ge.icfp.common.constants.ICFPConstants.YES;
import static com.ge.icfp.common.constants.ICFPConstants.YES_CAP;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import com.ge.icfp.action.ICFPBaseAction;
import com.ge.icfp.action.ICFPException;
import com.ge.icfp.common.attachments.ICFPAttachmentManager;
import com.ge.icfp.common.attachments.validation.AttachmentValidator;
import com.ge.icfp.common.constants.ICFPConstants;
import com.ge.icfp.common.helper.CurrentDealManager;
import com.ge.icfp.common.helper.ICFPCommonHelper;
import com.ge.icfp.common.helper.ICFPDay2LegHelper;
import com.ge.icfp.common.helper.ICFPLegHelper;
import com.ge.icfp.model.Amendment;
import com.ge.icfp.model.CPALegRequest;
import com.ge.icfp.model.DealRequest;
import com.ge.icfp.model.Entity;
import com.ge.icfp.model.EquityLegRequest;
import com.ge.icfp.model.ExceptionRequestForm;
import com.ge.icfp.model.LegSummary;
import com.ge.icfp.model.MDM;
import com.ge.icfp.model.MsgHeader;
import com.ge.icfp.model.OtherLegRequest;
import com.ge.icfp.model.RCALegRequest;
import com.ge.icfp.model.RateInformation;
import com.ge.icfp.model.Rates;
import com.ge.icfp.util.DateUtil;
import com.ge.icfp.util.EventType;
import com.ge.icfp.util.MasterDataFactory;
import com.ge.icfp.util.ProductType;
import com.ge.icfp.util.StaticDataFactory;
import com.ge.icfp.util.Utils;
import com.ge.icfp.util.report.pdf.PDFReportHelper;
import com.hydus.wff.common.bw.ServiceClient;
import com.hydus.wff.core.exception.HWFServiceException;
import com.hydus.wff.core.exception.HWFStubException;

import formdef.plugin.util.FormUtils;
/**
 * @author ramakrishna.satti
 * RCALegAction used for adding, modifying, delete legs from the current deal
 */
public class RCALegAction extends ICFPBaseAction {
	private static final String FAC_INC_USD = "facIncUsd";
	private static final String TRANSACTION = "transaction";
	private static final String AMENDED_USD = "amendedUsd";
	private static final String CURRENCY_USD = "currencyUsd";
	private static final String USD_US_DOLLAR = "USD-US Dollar";
	private static final String AMENDED_FACILITY_AMT = "amendedFacilityAmt";
	private static final String BORROWER_TREASURY_CODE = "borrowerTreasuryCode";
	private static final String BORROWER_T_CODE = "borrowerTCode";
	private static final String CAPITAL = "CAPITAL";
	private static final String SEARCH_FOR = "searchFor";
	private static final String BORROWER_OR_RECIPIENT = "borrowerOrRecipient";
	private static final String BORROWER_DETAILS = "borrowerDetails";
	private static final String ADD_DERIVATIVES = "addDerivatives";
	private static final String DELETE_MESSAGE = "DeleteMessage";
	private static final String AMENDMENT_NUMBER = "amendmentNumber";
	private static final String DATE_FORMAT = "MM/dd/yyyy";
	/**
	 * LOGGER
	 */
	private static final Logger LOGGER = Logger.getLogger(RCALegAction.class);
	/**
	 * serviceClient
	 */
	protected ServiceClient serviceClient;
	
	protected ICFPAttachmentManager attachmentManager;
	
	public ICFPAttachmentManager getAttachmentManager() {
		return attachmentManager;
	}

	public void setAttachmentManager(ICFPAttachmentManager attachmentManager) {
		this.attachmentManager = attachmentManager;
	}


	/**
	 * Method is used to open the leg details
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward openLeg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Integer legNumber = (Integer) request.getAttribute(LEGNUMBER);
		if(legNumber == null) {
			legNumber = Integer.valueOf(request.getParameter(LEGNUMBER));
		}
		Object leg = CurrentDealManager.getLegByNumber(legNumber, request);
		if(!(leg instanceof EquityLegRequest)){
			RateInformation rateInformation = Utils.fetchPropertyValue(RATEINFORMATION, leg, RateInformation.class);
			if(rateInformation == null) {
				rateInformation = new RateInformation();
				Utils.setPropertyValue(RATEINFORMATION, rateInformation, leg);
			}
			if(rateInformation.getFloatingRateIndex()==null || StringUtils.isEmpty(rateInformation.getFloatingRateIndex())){
				((DynaActionForm)form).set(INDEXTERMMAP, new HashMap<String, String>());
			}else{
				request.setAttribute(FLOATINGRATEINDEX, rateInformation.getFloatingRateIndex());
				getIndexTermData(mapping,form,request,response); 
			}
		}
		
		ICFPLegHelper.syncFormWithLeg((DynaActionForm) form, leg, request, getServlet().getServletContext(), mapping, this);
		
		((DynaActionForm) form).set(LEGNUMBER, Integer.toString(legNumber));
		
		request.getSession().removeAttribute("currentDate");
		String currentDate = DateUtil.getCurrentDate(DATE_FORMAT);
		if(currentDate!=null && StringUtils.isNotEmpty(currentDate))
		{
			request.getSession().setAttribute("currentDate", currentDate);	
		}
		
		
		DealRequest dealRequest = CurrentDealManager.getCurrentDeal(request);
		XMLGregorianCalendar valueDt = dealRequest.getValueDt();
		String valueDate = DateUtil.getValueDate(valueDt, DATE_FORMAT);
		request.getSession().removeAttribute("valueDate");
		
		if(valueDate!=null && StringUtils.isNotEmpty(valueDate))
		{
			request.getSession().setAttribute("valueDate", valueDate);	
		}
		
		String mode = request.getParameter(MODIFY);
		if(mode != null && mode.equals(TRUE_SMALL)) {
			request.getSession().setAttribute(ADDORMODIFYFLAG, MODIFY);
			request.getSession().setAttribute(REMOVECURRENT, YES);
		}
		if(leg instanceof CPALegRequest){
			String addAttribute = (String)request.getSession().getAttribute(ICFPConstants.ADD_CPA_LEG);
			if(addAttribute!=null && addAttribute.equals(ICFPConstants.ADD_CPA_LEG))
			{
				request.getSession().setAttribute(ADDORMODIFYREQ, ICFPConstants.ADD_CPA_LEG);
			}else{
				 request.getSession().setAttribute(ADDORMODIFYREQ, MODIFY);
			}
		}else{
		   request.getSession().setAttribute(ADDORMODIFYREQ, MODIFY);
		}
		request.getSession().removeAttribute(ICFPConstants.ADD_CPA_LEG);
		request.setAttribute(LEGEXIST, YES_CAP);
		request.setAttribute(LEGTYPE, String.valueOf(ICFPLegHelper.getProductType(leg).getId()));
		EventType eventType = ICFPDay2LegHelper.getEventType(leg);
		if(eventType != null) {
			request.setAttribute(EVENTTYPE, String.valueOf(eventType.getId()));
			Object legSummaryObject = ICFPLegHelper.getLegSummary(leg);
			String eventTypeName = Utils.fetchPropertyValue(TRANSACTIONEVENTTYPE, legSummaryObject, String.class);
			request.setAttribute(EVENTTYPENAME, eventTypeName);
		}
		
		request.setAttribute(ACTIONID, 1);
		request.setAttribute(LEGNUMBER, legNumber);
		String strForward = ADDLEG;
		if(eventType != null) {
			strForward = DAY2LEG;
		}
		return mapping.findForward(strForward);
	}
	
	
	/**
	 * Method used to add a leg to current deal
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
		DynaActionForm localForm = (DynaActionForm)form;
		localForm.getMap().clear();
		ICFPLegHelper.prepareICFPLegRequestForm((DynaActionForm)form, mapping, request, this);
		
		ProductType productType = ProductType.fromId(Integer.valueOf((String)request.getAttribute(LEGTYPE)));
		String strEventTypeId = (String) request.getAttribute(EVENTTYPE);
		Integer eventTypeId = (!StringUtils.isBlank(strEventTypeId)) ? Integer.valueOf(strEventTypeId) : null;
		int legNumber = CurrentDealManager.getNewLegNumber(request);
		
		Object leg = ICFPLegHelper.createLegObject(productType);
		
		// Initialize new leg
		LegSummary legSummary = new LegSummary();
		legSummary.setLegTypeId(productType.getId());
		legSummary.setProductType(Utils.getProductName(productType.getId(), request));
		legSummary.setTransactionEventTypeId(eventTypeId);
		legSummary.setTransactionEventType((String)request.getAttribute(EVENTTYPENAME));
		switch(productType) {
			case RCA:
			case TERM_LOAN:
			case BOND:
				((RCALegRequest) leg).setLegSummary(legSummary);
				((RCALegRequest) leg).setRateInformation(new RateInformation());
				break;
				
			case EQUITY:
				((EquityLegRequest) leg).setLegSummary(legSummary);
				break;
			
			case OTHER:
				((OtherLegRequest) leg).setLegSummary(legSummary);
				((OtherLegRequest) leg).setRateInformation(new RateInformation());
				break;
		}
		
		CurrentDealManager.addLeg(leg, request); // Adding new leg to current deal
		
		// Sync form with leg object
		ICFPLegHelper.syncFormWithLeg(localForm, leg, request, getServlet().getServletContext(), mapping, this);
		localForm.set(LEGNUMBER, String.valueOf(legNumber));
		
		String redirectPath = new StringBuilder().append(mapping.findForward(OPENLEG).getPath())
				.append(LEGNUMBER_STRING).append(legNumber).toString();
		return new ActionForward(response.encodeRedirectURL(redirectPath), true);
	}
	
	
	/**
	 * Method used to delete the exception details from the current leg
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward deleteExceptionDetails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		Integer legNumber = Integer.valueOf(request.getParameter(LEGNUMBER));
		String strExceptionNumber = request.getParameter(EXCEPTIONNUMBER);
		if(strExceptionNumber != null && strExceptionNumber.trim().length() > 0) {
			Integer exceptionNumber = Integer.valueOf(strExceptionNumber);
			Object leg = CurrentDealManager.getLegByNumber(legNumber, request);
			List<ExceptionRequestForm> exceptions = ICFPLegHelper.getExceptions(leg);
			List<ExceptionRequestForm> filteredExceptions = ICFPLegHelper.filterDeletedExceptions(exceptions);
			if(filteredExceptions.size()>0){
				ExceptionRequestForm exceptionToDelete = filteredExceptions.get(exceptionNumber - 1);
				if(exceptionToDelete.getStandardTermsConditionsId() != null) {
					exceptionToDelete.setExceptionOpcode(DELETE);
				} else {
					exceptions.remove(exceptionToDelete);
				}
			}
		}
		return null;
	}
	
	/**
	 * Method used to delete the Amendment details from the current leg
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws ICFPException 
	 */
	public ActionForward deleteAmendment(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws ICFPException {
		Integer legNumber = Integer.valueOf(request.getParameter(LEGNUMBER));
		String strAmendmentNumber = request.getParameter(RCALegAction.AMENDMENT_NUMBER);
		if(strAmendmentNumber != null && strAmendmentNumber.trim().length() > 0) {
			Integer amendmentNumber = Integer.valueOf(strAmendmentNumber);
			Object leg = CurrentDealManager.getLegByNumber(legNumber, request);
			List<Amendment> amendments = ICFPDay2LegHelper.getAmendments(leg);
			List<Amendment> filteredAmendments = ICFPDay2LegHelper.filterDeletedAmendments(amendments);
			if(filteredAmendments.size()>0){
				Amendment amendmentToDelete = filteredAmendments.get(amendmentNumber - 1);
				amendmentToDelete.setAmendmentOpcode(DELETE);
			}
		}
		return null;
	}
	
	/**
	 * Method is used to save the leg and return to Deal screen
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward saveAndReturnToDeal(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		saveLeg((DynaActionForm) form, request, mapping, true);
		
		if(getErrors(request).isEmpty()) {
			request.getSession().removeAttribute("addOrModifyFlag");
			request.getSession().removeAttribute("removeCurrent");
			return mapping.findForward("success");
		} else {
			return openLeg(mapping, form, request, response);
		}
	}
	
	/**
	 * Method used to save the leg as draft
	 * @param mapping
	 * @param form
	 * @param requests
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward saveAsDraft(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		saveLeg((DynaActionForm) form, request, mapping, false);
		CurrentDealManager.syncCommentsWithFormObject(request);
		request.getSession().removeAttribute(ADDORMODIFYFLAG);
		request.getSession().setAttribute(REMOVECURRENT, YES);
		Integer legNumber = Integer.valueOf(((DynaActionForm)form).getString(LEGNUMBER));
		request.setAttribute(LEGNUMBER, legNumber);
		request.setAttribute(SAVEMSG, SAVED_SUCCESSFULLY);
		return openLeg(mapping, form, request, response);
	}
	
	/**
	 * Method is used to delete the leg from the current deal
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
		if(legNumber!=null){
			Object leg = CurrentDealManager.getLegByNumber(legNumber.intValue(), request);
			CurrentDealManager.deleteLeg(legNumber.intValue(), request);
			DealRequest deal = CurrentDealManager.getCurrentDeal(request);
			request.setAttribute(DEALREQUESTID, deal.getDealSeqId());
			ICFPLegHelper.prepareMsgHeader(deal, INSERTDEAL, SAVE,22);
			attachmentManager.deleteAllLegAttachments(leg, deal);
			deal = serviceClient.invokeService(DEAL, deal, DealRequest.class);
			deal = ICFPCommonHelper.getDeal(deal.getDealSeqId(), serviceClient);
			CurrentDealManager.setActiveDeal(deal, request);
			String legSeqId = "";
			if(request.getParameter(LEGSEQID) != null ){
				legSeqId = request.getParameter(LEGSEQID);
			}
			request.setAttribute(RCALegAction.DELETE_MESSAGE,LEG_LABEL+ legSeqId + " Deleted Successfully.");
		}

		return mapping.findForward(SUCCESS);
	}
	
	/**`
	 * Method is used to redirect from leg screen to deal screen
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward redirectFundingRequest(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm legReqForm = (DynaActionForm) form;
		int legNumber = Integer.valueOf(legReqForm.getString(LEGNUMBER));
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		request.setAttribute(DEALREQUESTID, deal.getDealSeqId());
		Object leg = CurrentDealManager.getLegByNumber(legNumber, request);
		List<ExceptionRequestForm> exceptions = ICFPLegHelper.getExceptions(leg);
		ICFPLegHelper.removeNullExceptions(exceptions);
		String opcode = ICFPLegHelper.getOpCode(leg);
		if(opcode == null && ICFPLegHelper.getLegSeqId(leg) == null) {
			deal.getLegs().getAllLegs().remove(leg);
		}
		request.getSession().removeAttribute(ADDORMODIFYFLAG);
		request.getSession().removeAttribute(REMOVECURRENT);
		return mapping.findForward(SUCCESS);
	}
	
	/**
	 * Method is used to add the derivatives
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward addDerivatives(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm legReqForm = (DynaActionForm) form;
		Integer legNumber = Integer.valueOf(legReqForm.getString(LEGNUMBER));
		Object leg = CurrentDealManager.getLegByNumber(legNumber, request);
		ICFPLegHelper.synchLegWithForm(leg, (DynaActionForm) form, request, getServlet().getServletContext(), mapping, this);
		request.setAttribute(LEGNUMBER, legNumber);

		String addOrModifyFlag = (String) request.getSession().getAttribute(ADDORMODIFYFLAG);
		request.getSession().setAttribute(ADDORMODIFYFLAG, addOrModifyFlag);
		request.getSession().setAttribute(ADDORMODIFYDERIVATIVE, "");
		return mapping.findForward(RCALegAction.ADD_DERIVATIVES);
	}
	
	/**
	 * Method is used to get the gold id details from the MDM Service
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward getGoldIdDetails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		MsgHeader msgHeader = new MsgHeader();
		msgHeader.setOpcode(GETGOLDINFO);
		MDM mdmObject = new MDM();
		mdmObject.setMsgHeader(msgHeader);
		
	    String goldId=""; 
	    String goldIdFlag = request.getParameter(GOLDIDFLAG);
	    if(goldIdFlag.equals(LENDERDETAILS)){
	    	goldId = request.getParameter(LENDERORPROVIDER).toUpperCase();
	    }else if(goldIdFlag.equals(RCALegAction.BORROWER_DETAILS)){
	    	goldId = request.getParameter(RCALegAction.BORROWER_OR_RECIPIENT).toUpperCase();
	    }
	    String which = request.getParameter(RCALegAction.SEARCH_FOR);
	    
		List<Entity> entityLst = new ArrayList<Entity>();
		Entity entity = new Entity();
		
		if(CDR.equals(which)){
			entity.setCDRCd( goldId );
		}else{
			entity.setLEGoldId(goldId);
		}
		
		entityLst.add(entity);
		mdmObject.setEntities(entityLst);
		
		mdmObject = serviceClient.invokeService(MDM, mdmObject,MDM.class);
		
		if(mdmObject!=null){
			DynaActionForm legReqForm = (DynaActionForm) form;
			Entity entityBean = new Entity();
			if(mdmObject.getEntities().size()!=0){
				entityBean = mdmObject.getEntities().get(0);
				if(entityBean.getCapitalIndustrial()!=null && entityBean.getCapitalIndustrial().equals(RCALegAction.CAPITAL))
				{
					entityBean.setLeCategoryId(1);
				}else
				{
					entityBean.setLeCategoryId(2);
				}
			}
			DynaActionForm legSummaryForm = (DynaActionForm) legReqForm.get(LEGSUMMARY);
			
			DynaActionForm lenderOrBorrowerEntity = new DynaActionForm();
			if(goldIdFlag.equals(LENDERDETAILS)){
				lenderOrBorrowerEntity = (DynaActionForm) legSummaryForm.get(LENDERENTITY);
			}else if(goldIdFlag.equals(RCALegAction.BORROWER_DETAILS)){
				lenderOrBorrowerEntity = (DynaActionForm) legSummaryForm.get(BORROWERENTITY);
			}
			FormUtils.getInstance().populateForm(ENTITYFORM, lenderOrBorrowerEntity, entityBean, mapping.getModuleConfig(), this, mapping, request);
		}
		return mapping.findForward(ADDLEG);
	}
	
	/**
	 * Method is used to get the TCode details from the MDM Service
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward getTCodeDetails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		MsgHeader msgHeader = new MsgHeader();
		msgHeader.setOpcode(TCODE);
		MDM mdmObject = new MDM();
		mdmObject.setMsgHeader(msgHeader);

		String goldId = "";
		String goldIdFlag = request.getParameter(GOLDIDFLAG);
		if (goldIdFlag!=null && goldIdFlag.equals(LENDERTCODE)) {
			goldId = request.getParameter(LENDERTREASURYCODE).toUpperCase();
		} else if (goldIdFlag!=null && goldIdFlag.equals(RCALegAction.BORROWER_T_CODE)) {
			goldId = request.getParameter(RCALegAction.BORROWER_TREASURY_CODE).toUpperCase();
		}

		List<Entity> entityLst = new ArrayList<Entity>();
		Entity entity = new Entity();
		entity.getTreasuryCodes().add(goldId);
		entityLst.add(entity);
		mdmObject.setEntities(entityLst);

		mdmObject = serviceClient.invokeService(MDM, mdmObject, MDM.class);

		if (mdmObject != null) {
			DynaActionForm legReqForm = (DynaActionForm) form;
			Entity entityBean = new Entity();
			if (mdmObject.getEntities().size() != 0) {
				entityBean = mdmObject.getEntities().get(0);
			
			}
			DynaActionForm legSummaryForm = (DynaActionForm) legReqForm.get(LEGSUMMARY);

			DynaActionForm lenderOrBorrowerEntity = new DynaActionForm();
			if (goldIdFlag!=null && goldIdFlag.equals(LENDERTCODE)) {
				lenderOrBorrowerEntity = (DynaActionForm) legSummaryForm
						.get(LENDERTCODEENTITY);
				lenderOrBorrowerEntity.set(TREASURYCODE, goldId.toUpperCase());
			} else if (goldIdFlag!=null && goldIdFlag.equals(RCALegAction.BORROWER_T_CODE)) {
				lenderOrBorrowerEntity = (DynaActionForm) legSummaryForm
						.get(BORROWERTCODEENTITY);
				lenderOrBorrowerEntity.set(TREASURYCODE, goldId.toUpperCase());
			}
			FormUtils.getInstance().populateForm(ENTITYFORM,
					lenderOrBorrowerEntity, entityBean,
					mapping.getModuleConfig(), this, mapping, request);
		}
		DynaActionForm legReqForm = (DynaActionForm) form;
		String legNumber = (String)legReqForm.get(LEGNUMBER);
		request.setAttribute(ACTIONID, 1);
		request.setAttribute(LEGNUMBER, legNumber);

		return mapping.findForward(ADDLEG);
	}
	
	/**
	 * Method is used to get the USD details from the MDM Service
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward getUSDEquiDetails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		MsgHeader msgHeader = new MsgHeader();
		msgHeader.setOpcode(USDEQUI);
		MDM mdmObject = new MDM();
		mdmObject.setMsgHeader(msgHeader);

		String originalCCYAmount = request.getParameter(ORIGINALCCYAMOUNT);
		String originalCCY = request.getParameter(ORIGINALCCY);
		String productType = request.getParameter(PRODUCTTYPE);
		String amendedFacilityAmt = request.getParameter(RCALegAction.AMENDED_FACILITY_AMT);
		String transactionEventTypeId = request.getParameter(TRANSACTIONEVENTTYPEID);		
		String usdAmount = "";
		
		BigDecimal amountDouble = new BigDecimal(originalCCYAmount);
		
		DynaActionForm legReqForm = (DynaActionForm) form;
		DynaActionForm legSummaryForm = (DynaActionForm) legReqForm.get(LEGSUMMARY);
		if (originalCCY!=null && !(originalCCY.equalsIgnoreCase(RCALegAction.USD_US_DOLLAR))) {

			Rates rates = new Rates();
			rates.setFrequency(amountDouble.doubleValue());
			if(originalCCY !=null && !"".equals(originalCCY) && originalCCY.contains("-"))
				rates.setObjectCurrencyCode(originalCCY.substring(0, originalCCY.indexOf("-")));
			List<Rates> ratesList = new ArrayList<Rates>();
			ratesList.add(rates);
			mdmObject.setRates(ratesList);
			mdmObject = serviceClient
					.invokeService(MDM, mdmObject, MDM.class);
			if (mdmObject != null) {
				Rates ratesDet = (mdmObject.getRates().size() != 0) ? mdmObject
						.getRates().get(0) : null;
				if(ratesDet!=null){
					usdAmount = ICFPCommonHelper.formatCurrency(ratesDet.getFrequency()+ "");
				}
				
				if(amendedFacilityAmt==null || amendedFacilityAmt.equals(RCALegAction.CURRENCY_USD)){
					legSummaryForm.set(USDEQUIVALENT, usdAmount);
					if(StringUtils.isNotEmpty(transactionEventTypeId) && transactionEventTypeId.equals(TWELVE)){
						legSummaryForm.set(GROSSSETTLEMENTAMT, usdAmount);
					}
				}else if(amendedFacilityAmt.equals(RCALegAction.AMENDED_USD)){
					DynaActionForm day2Form = (DynaActionForm) legReqForm.get(DAYTWOOPERATIONS);
					DynaActionForm incForm = (DynaActionForm) day2Form.get(FACILITYINCREASEDECREASE);
					if(usdAmount!=null){
						usdAmount = usdAmount.replaceAll(",", "");
					}
					incForm.set(AMENDEDUSDEQUIVALENTAMT, PDFReportHelper.formatCurrency(Double.valueOf(usdAmount)));
				}else if(amendedFacilityAmt.equals(RCALegAction.TRANSACTION)){
					legSummaryForm.set(DAYONEUSDEQUIVALENT, usdAmount);
				}else if(amendedFacilityAmt.equals(RCALegAction.FAC_INC_USD)){
					if(usdAmount!=null){
						usdAmount = usdAmount.replaceAll(",", "");
					}
					DynaActionForm day2Form = (DynaActionForm) legReqForm.get(DAYTWOOPERATIONS);
					DynaActionForm incForm = (DynaActionForm) day2Form.get(FACILITYINCREASEDECREASE);
					incForm.set(FACILITYINCDECUSDEQUIVALENTAMT, PDFReportHelper.formatCurrency(Double.valueOf(usdAmount)));
				}
			}
		} else {
			usdAmount = ICFPCommonHelper.formatCurrency(originalCCYAmount);
			if(amendedFacilityAmt==null || amendedFacilityAmt.equals(RCALegAction.CURRENCY_USD)){
				legSummaryForm.set(USDEQUIVALENT, usdAmount);
				if(StringUtils.isNotEmpty(transactionEventTypeId) && transactionEventTypeId.equals(TWELVE)){
					legSummaryForm.set(GROSSSETTLEMENTAMT, usdAmount);
				}
			}else if(amendedFacilityAmt.equals(RCALegAction.AMENDED_USD)){
				DynaActionForm day2Form = (DynaActionForm) legReqForm.get(DAYTWOOPERATIONS);
				DynaActionForm incForm = (DynaActionForm) day2Form.get(FACILITYINCREASEDECREASE);
				if(usdAmount!=null){
					usdAmount = usdAmount.replaceAll(",", "");
				}
				incForm.set(AMENDEDUSDEQUIVALENTAMT, PDFReportHelper.formatCurrency(Double.valueOf(usdAmount)));
			}else if(amendedFacilityAmt.equals(RCALegAction.TRANSACTION)){
				legSummaryForm.set(DAYONEUSDEQUIVALENT, usdAmount);
			}else if(amendedFacilityAmt.equals(RCALegAction.FAC_INC_USD)){
				DynaActionForm day2Form = (DynaActionForm) legReqForm.get(DAYTWOOPERATIONS);
				DynaActionForm incForm = (DynaActionForm) day2Form.get(FACILITYINCREASEDECREASE);
				if(usdAmount!=null){
					usdAmount = usdAmount.replaceAll(",", "");
				}
				incForm.set(FACILITYINCDECUSDEQUIVALENTAMT, PDFReportHelper.formatCurrency(Double.valueOf(usdAmount)));
			}
		}

		if(productType!=null && productType.equals(TWO)){
	
			StaticDataFactory statData = (StaticDataFactory) request.getSession().getServletContext().getAttribute(StaticDataFactory.CTX_KEY);
			String referenceData =  statData.getReferenceData();
			BigDecimal eboardAmt =  new BigDecimal(0.0);
			if(!"".equals(referenceData) && referenceData!=null){
				eboardAmt = new BigDecimal(referenceData);
			}
			if(usdAmount!=null && !usdAmount.equals("") && amendedFacilityAmt==null){
				BigDecimal usdDouble = new BigDecimal(ICFPCommonHelper.convetCurrencyFormatToDouble(usdAmount));
				if(usdDouble.compareTo(eboardAmt) ==0 || usdDouble.compareTo(eboardAmt)==1){
					legReqForm.set(EBOARDAPPROVALREQUIREDFLAG, true);
					request.setAttribute(EBOARDARFLAGVALUE, YES_CAP);
				} else {
					legReqForm.set(EBOARDAPPROVALREQUIREDFLAG, false);
					request.setAttribute(EBOARDARFLAGVALUE, NO_CAP);
				}
			}
		}
		
		request.setAttribute(LEGTYPE, (String)legSummaryForm.get(LEGTYPEID));
		String eventType = (String)legSummaryForm.get(TRANSACTIONEVENTTYPEID);
		
		String actionId = request.getParameter(ACTIONID);
		String legNumber = (String)legReqForm.get(LEGNUMBER);
		request.setAttribute(LEGNUMBER, legNumber);
		request.setAttribute(ACTIONID, actionId);
		
		if(eventType != null) {
			request.setAttribute(EVENTTYPE, eventType);
			request.setAttribute(EVENTTYPENAME, (String)legSummaryForm.get(TRANSACTIONEVENTTYPE));
		}
		String strForward = (eventType != null) ? DAY2LEG : ADDLEG;
		return mapping.findForward(strForward);
	}
	
	/**
	 * getServiceClient
	 * @return serviceClient
	 */
	public ServiceClient getServiceClient() {
		return serviceClient;
	}
	/**
	 * setServiceClient
	 * @param serviceClient
	 */
	public void setServiceClient(ServiceClient serviceClient) {
		this.serviceClient = serviceClient;
	}
	
	/**
	 * Method is used to save the current leg
	 * @param form
	 * @param request
	 * @param mapping
	 */
	protected void saveLeg(DynaActionForm form, HttpServletRequest request, ActionMapping mapping, boolean validate) throws Exception {
		DynaActionForm legSummaryForm = (DynaActionForm) form.get(LEGSUMMARY);
		int legNumber = Integer.valueOf((String)form.get(LEGNUMBER));
		legSummaryForm.set(LEGNUMBER, String.valueOf(legNumber));
		String currency = "";
		boolean cloneFlag= false;
		String currencyName = (String)legSummaryForm.get(ORIGINALCCY);
		if(currencyName!=null){
			String tempCurrnecy[] = currencyName.split("-");
			currency = tempCurrnecy[0];
		}
		legSummaryForm.set(ORIGINALCCY, currency);
		
		String dayOnecurrency = "";
		String dayOnecurrencyName = (String)legSummaryForm.get(DAYONECCY);
		if(dayOnecurrencyName!=null){
			String dayOnetempCurrnecy[] = dayOnecurrencyName.split("-");
			dayOnecurrency = dayOnetempCurrnecy[0];
		}
		legSummaryForm.set(DAYONECCY, dayOnecurrency);


		Object leg = CurrentDealManager.getLegByNumber(legNumber, request);
		ServletContext servletContext = getServlet().getServletContext();
		ICFPLegHelper.synchLegWithForm(leg, form, request, servletContext, mapping, this);
		CurrentDealManager.syncCommentsWithFormObject(request);
		
		String opcode = ICFPLegHelper.getOpCode(leg);
		Integer legSeqId = ICFPLegHelper.getLegSeqId(leg);
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		
		if(legSeqId==null && opcode!=null && opcode.equals(INSERT)) {
			cloneFlag = true;
		}
			if(!cloneFlag) {
			if(opcode == null &&  legSeqId == null) {
				ICFPLegHelper.setOpCodeFlag(leg, INSERT);
			} else if(legSeqId != null && opcode == null) {
				ICFPLegHelper.setOpCodeFlag(leg, UPDATE);
			}
			
		} else {
			ICFPLegHelper.setOpCodeFlag(leg, INSERT);
		}
		if(validate){
			ActionErrors errors = AttachmentValidator.getInstance().validateLeg(leg, request);
			if(!errors.isEmpty()) {
				saveErrors(request, errors);
				request.setAttribute(ICFPConstants.AMTERROR,"Please fix the following fields highlighted in red.");
				return;
			}
			ICFPLegHelper.setReqValidateFlag(leg, ICFPConstants.Y_CAP);
		}else{
			ICFPLegHelper.setReqValidateFlag(leg, ICFPConstants.N_CAP);
		}
		
		if(deal != null && deal.getUniqueId().contains(DRAFT)){
			ICFPLegHelper.prepareMsgHeader(deal, INSERTDEAL, DRAFT_GLOBEL,1);
		}else{
			ICFPLegHelper.prepareMsgHeader(deal, INSERTDEAL, SAVE,22);
		}
		deal = serviceClient.invokeService(DEAL, deal, DealRequest.class);
		deal = ICFPCommonHelper.getDeal(deal.getDealSeqId(), serviceClient);
		CurrentDealManager.setActiveDeal(deal, request);
		
		Object leg1 = CurrentDealManager.getLegByNumber(legNumber, request);
		legSeqId = ICFPLegHelper.getLegSeqId(leg1);
		
	request.setAttribute(UPDATEMESSAGE,LEG_LABEL+ legSeqId + UPDATED_LABEL);
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
	 * @throws ICFPException 
	 */
	public ActionForward getIndexTermData(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws HWFServiceException, HWFStubException, ICFPException {

		String floatRateIndexVal = (String)request.getParameter(FLOATINGRATEINDEX);
		String actionID  = request.getParameter(ACTIONID_SMALL);
		Integer legNumber = (Integer) request.getAttribute(LEGNUMBER);
		if(legNumber == null) {
			legNumber = Integer.valueOf(request.getParameter(LEGNUMBER));
		}
		
		
		Object leg = CurrentDealManager.getLegByNumber(legNumber, request);
		EventType eventType = ICFPDay2LegHelper.getEventType(leg);
		
		if(floatRateIndexVal==null || StringUtils.isEmpty(floatRateIndexVal))
		{
			floatRateIndexVal = (String)request.getAttribute(FLOATINGRATEINDEX);
		}
		
		Map<String,String> indexTermMap = new HashMap<String, String>();
		
		if(floatRateIndexVal!=null && !floatRateIndexVal.equals(""))
		{
			MasterDataFactory mdmDataFactoryObj = (MasterDataFactory) getServlet().getServletContext().getAttribute(MasterDataFactory.CTX_KEY);
			indexTermMap = mdmDataFactoryObj.getIndexTerm(floatRateIndexVal,serviceClient);
		}
		
	    ((DynaActionForm)form).set(INDEXTERMMAP, indexTermMap);
	    String productType=request.getParameter(PRODUCTTYPE);
	    request.setAttribute(ACTIONID, actionID);
		request.setAttribute(LEGNUMBER, legNumber);
		
	    if(productType!=null && productType.equals(CPA)){
	    	 return mapping.findForward(CPALEGSUMMARY);
	    }
	    if(eventType != null) {
	    	request.setAttribute(ACTIONID, 2);
	    	return mapping.findForward(DAY2LEG);	
	    }else{
	    	 return mapping.findForward(ADDLEG);
	    }
	   
	}

}
