/**
 * 
 */
package com.ge.icfp.frontoffice.action;

import static com.ge.icfp.common.constants.ICFPConstants.ACTIONID;
import static com.ge.icfp.common.constants.ICFPConstants.ADDLEG;
import static com.ge.icfp.common.constants.ICFPConstants.ADDORMODIFYFLAG;
import static com.ge.icfp.common.constants.ICFPConstants.ADDORMODIFYREQ;
import static com.ge.icfp.common.constants.ICFPConstants.ALL;
import static com.ge.icfp.common.constants.ICFPConstants.BUSINESSSEGMENT;
import static com.ge.icfp.common.constants.ICFPConstants.CAPITAL;
import static com.ge.icfp.common.constants.ICFPConstants.COUNTRY;
import static com.ge.icfp.common.constants.ICFPConstants.DAY2LEG;
import static com.ge.icfp.common.constants.ICFPConstants.DAYONECCY;
import static com.ge.icfp.common.constants.ICFPConstants.DEAL;
import static com.ge.icfp.common.constants.ICFPConstants.DEALREQUESTID;
import static com.ge.icfp.common.constants.ICFPConstants.ENTITYFORM;
import static com.ge.icfp.common.constants.ICFPConstants.EVENTTYPE;
import static com.ge.icfp.common.constants.ICFPConstants.EVENTTYPENAME;
import static com.ge.icfp.common.constants.ICFPConstants.FLOATINGRATEINDEX;
import static com.ge.icfp.common.constants.ICFPConstants.FOINSERT;
import static com.ge.icfp.common.constants.ICFPConstants.FOUPDATE;
import static com.ge.icfp.common.constants.ICFPConstants.GETGOLDINFO;
import static com.ge.icfp.common.constants.ICFPConstants.GUARANTORENTITY;
import static com.ge.icfp.common.constants.ICFPConstants.INDEXTERMMAP;
import static com.ge.icfp.common.constants.ICFPConstants.INSERT;
import static com.ge.icfp.common.constants.ICFPConstants.INSERTDEAL;
import static com.ge.icfp.common.constants.ICFPConstants.LEGEXIST;
import static com.ge.icfp.common.constants.ICFPConstants.LEGNUMBER;
import static com.ge.icfp.common.constants.ICFPConstants.LEGNUMBER_STRING;
import static com.ge.icfp.common.constants.ICFPConstants.LEGSEQID;
import static com.ge.icfp.common.constants.ICFPConstants.LEGSUMMARY;
import static com.ge.icfp.common.constants.ICFPConstants.LEGTYPE;
import static com.ge.icfp.common.constants.ICFPConstants.LEG_LABEL;
import static com.ge.icfp.common.constants.ICFPConstants.MDM;
import static com.ge.icfp.common.constants.ICFPConstants.MODIFY;
import static com.ge.icfp.common.constants.ICFPConstants.NO;
import static com.ge.icfp.common.constants.ICFPConstants.OPENLEG;
import static com.ge.icfp.common.constants.ICFPConstants.ORIGINALCCY;
import static com.ge.icfp.common.constants.ICFPConstants.PROCEEDTONEXTLEG;
import static com.ge.icfp.common.constants.ICFPConstants.QUALITATIVEFACTORS;
import static com.ge.icfp.common.constants.ICFPConstants.RADIOVALUE;
import static com.ge.icfp.common.constants.ICFPConstants.RATEINFORMATION;
import static com.ge.icfp.common.constants.ICFPConstants.REMAINING;
import static com.ge.icfp.common.constants.ICFPConstants.REMOVECURRENT;
import static com.ge.icfp.common.constants.ICFPConstants.SAVE;
import static com.ge.icfp.common.constants.ICFPConstants.SUCCESS;
import static com.ge.icfp.common.constants.ICFPConstants.TRANSACTIONEVENTTYPE;
import static com.ge.icfp.common.constants.ICFPConstants.TRUE_SMALL;
import static com.ge.icfp.common.constants.ICFPConstants.UPDATE;
import static com.ge.icfp.common.constants.ICFPConstants.UPDATED_LABEL;
import static com.ge.icfp.common.constants.ICFPConstants.UPDATEMESSAGE;
import static com.ge.icfp.common.constants.ICFPConstants.YES;
import static com.ge.icfp.common.constants.ICFPConstants.YES_CAP;
import static com.ge.icfp.common.constants.ICFPConstants.FO_FLAG;
import static com.ge.icfp.common.constants.ICFPConstants.TRUE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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

import com.ge.icfp.action.ICFPException;
import com.ge.icfp.common.attachments.validation.AttachmentValidator;
import com.ge.icfp.common.constants.ICFPConstants;
import com.ge.icfp.common.helper.CurrentDealManager;
import com.ge.icfp.common.helper.EntityHelper;
import com.ge.icfp.common.helper.EntityHelper.EntityType;
import com.ge.icfp.common.helper.ICFPCommonHelper;
import com.ge.icfp.common.helper.ICFPDay2LegHelper;
import com.ge.icfp.common.helper.ICFPLegHelper;
import com.ge.icfp.common.legs.action.RCALegAction;
import com.ge.icfp.model.DealRequest;
import com.ge.icfp.model.Entity;
import com.ge.icfp.model.EquityLegRequest;
import com.ge.icfp.model.LegSummary;
import com.ge.icfp.model.MDM;
import com.ge.icfp.model.MsgHeader;
import com.ge.icfp.model.OtherLegRequest;
import com.ge.icfp.model.QualitativeFactors;
import com.ge.icfp.model.RCALegRequest;
import com.ge.icfp.model.RateInformation;
import com.ge.icfp.tag.DealManager;
import com.ge.icfp.util.DateUtil;
import com.ge.icfp.util.EventType;
import com.ge.icfp.util.ProductType;
import com.ge.icfp.util.Utils;

import formdef.plugin.util.FormUtils;
/**
 * @author sreenivasulu.talloju
 *
 */
public class FORCALegAction extends RCALegAction {
	
	private static final String INFORMATION_IS_SAVED_SUCCESSFULLY = " information is saved successfully";

	private static final String YOUR_LEG = "Your leg ";

	private static final String TCODE = "tcode";

	private static final String PRINCPL_ENTITY = "princplEntity";

	private static final String REGULATED_ENTITY = "regulatedEntity";

	private static final String MGMT_ENTITY = "mgmtEntity";

	private static final String CAPITAL_INDUSTRIAL = "capitalIndustrial";

	private static final String LE_NAME = "leName";

	private static final String GOLD_ID = "goldId";

	private static final String CDR_CODE = "cdrCode";

	private static final String FUN_COMPANY = "funCompany";

	private static final String ENTITY2 = "entity";

	private static final String GUARANTOR_INFO = "guarantorInfo";
	
	private static final String DATE_FORMAT = "MM/dd/yyyy";

	private static final Logger LOGGER = Logger.getLogger(RCALegAction.class);
	

	
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
		int noOfLegs = CurrentDealManager.getLegCount(request);
		
		// Set RateInformation if not exists
		
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
	
			
			
			Double minValue = rateInformation.getMinSpread();
			Double maxValue = rateInformation.getMaxSpread();
			
			Double spread=rateInformation.getSpread();
			
			if (spread == null) {

				if (minValue != null && maxValue != null) {
					spread = (minValue + maxValue) / 2;

				} else if (minValue != null && maxValue == null) {
					spread = minValue / 2;

				} else if (minValue == null && maxValue != null) {
					spread = maxValue / 2;

				}

				rateInformation.setSpread(spread);

			}
			
		}
		// Set QualitativeFactors If not exists
		ICFPLegHelper.prepareQualitativeFactors(leg, 1, 2, 3, 4, 5);
		
		ICFPLegHelper.syncFormWithLeg((DynaActionForm) form, leg, request, getServlet().getServletContext(), mapping, this);
		
		((DynaActionForm) form).set(LEGNUMBER, Integer.toString(legNumber));
		
		String mode = request.getParameter(MODIFY);
		if(mode != null && mode.equals(TRUE_SMALL)) {
			request.getSession().setAttribute(ADDORMODIFYFLAG, MODIFY);
			request.getSession().setAttribute(REMOVECURRENT, YES);
		}
		
		String currentDate = DateUtil.getCurrentDate("MM/dd/yyyy");
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
		
		request.getSession().setAttribute(ADDORMODIFYREQ, MODIFY);
		request.setAttribute(LEGEXIST, YES_CAP);
		request.setAttribute(LEGTYPE, String.valueOf(ICFPLegHelper.getProductType(leg).getId()));
		EventType eventType = ICFPDay2LegHelper.getEventType(leg);
		if(eventType != null) {
			request.setAttribute(EVENTTYPE, String.valueOf(eventType.getId()));
			Object legSummaryObject = ICFPLegHelper.getLegSummary(leg);
			String eventTypeName = Utils.fetchPropertyValue(TRANSACTIONEVENTTYPE, legSummaryObject, String.class);
			request.setAttribute(EVENTTYPENAME, eventTypeName);
		}
		
		if( eventType == EventType.PREPAYMENT
				|| eventType == EventType.DRAWDOWN
				|| eventType == EventType.AMENDMENT_FACILITY_INC_DEC){
			request.setAttribute(ACTIONID, 51);
		}else{
			request.setAttribute(ACTIONID, 2);
		}
		
		request.setAttribute(LEGNUMBER, legNumber);
		request.setAttribute("noOfLegs", noOfLegs);
		String strForward = ADDLEG;
		if(eventType != null) {
			strForward = DAY2LEG;
		}
		int nextLegNo = isNextLeg( legNumber, request ).intValue();
		if(nextLegNo > 0){
			request.setAttribute(PROCEEDTONEXTLEG, YES);
		}else{
			request.setAttribute(PROCEEDTONEXTLEG, NO);
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
		// Set QualitativeFactors If not exists
		ICFPLegHelper.prepareQualitativeFactors(leg, 1, 2, 3, 4, 5);
		
		CurrentDealManager.addLeg(leg, request); // Adding new leg to current deal

		// Sync form with leg object
		ICFPLegHelper.syncFormWithLeg(localForm, leg, request, getServlet().getServletContext(), mapping, this);
		localForm.set(LEGNUMBER, String.valueOf(legNumber));

		String redirectPath = new StringBuilder().append(mapping.findForward(OPENLEG).getPath())
				.append(LEGNUMBER_STRING).append(legNumber).toString();
		return new ActionForward(response.encodeRedirectURL(redirectPath), true);
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
		
		if (legNumber != null) {
			Object leg = CurrentDealManager.getLegByNumber(legNumber.intValue(), request);
			CurrentDealManager.deleteLeg(legNumber.intValue(), request);
			DealRequest deal = CurrentDealManager.getCurrentDeal(request);
			request.setAttribute(DEALREQUESTID, deal.getDealSeqId());
			ICFPLegHelper.prepareMsgHeader(deal, INSERTDEAL, SAVE, 22);
			attachmentManager.deleteAllLegAttachments(leg, deal);
			deal = serviceClient.invokeService(DEAL, deal, DealRequest.class);
			String legSeqId = "";
			if (request.getParameter(LEGSEQID) != null) {
				legSeqId = request.getParameter(LEGSEQID);
			}
			request.setAttribute(UPDATEMESSAGE, LEG_LABEL + legSeqId + " Deleted Successfully.");
		}
		return mapping.findForward(SUCCESS);
	}
	
	/**
	 * Method is used to get the CDR code details from the MDM Service
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward getCDRCodeDetails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		MsgHeader msgHeader = new MsgHeader();
		msgHeader.setOpcode(GETGOLDINFO);
		MDM mdmObject = new MDM();
		mdmObject.setMsgHeader(msgHeader);

		String cdrCode = "";

		cdrCode = request.getParameter(FORCALegAction.GUARANTOR_INFO).toUpperCase();

		List<Entity> entityLst = new ArrayList<Entity>();
		Entity entity = new Entity();
		entity.setCDRCd(cdrCode);

		entityLst.add(entity);
		mdmObject.setEntities(entityLst);

		mdmObject = serviceClient.invokeService(MDM, mdmObject, MDM.class);

		if (mdmObject != null) {
			DynaActionForm legReqForm = (DynaActionForm) form;
			Entity entityBean = new Entity();

			if (mdmObject.getEntities().size() != 0) {
				entityBean = mdmObject.getEntities().get(0);
				if (entityBean.getCapitalIndustrial() != null
						&& entityBean.getCapitalIndustrial().equals(CAPITAL)) {
					entityBean.setLeCategoryId(1);
				} else {
					entityBean.setLeCategoryId(2);

				}
			}
			DynaActionForm legSummaryForm = (DynaActionForm) legReqForm
					.get(LEGSUMMARY);

			DynaActionForm guarantorEntity = new DynaActionForm();
			guarantorEntity = (DynaActionForm) legSummaryForm
					.get(GUARANTORENTITY);

			FormUtils.getInstance().populateForm(ENTITYFORM, guarantorEntity,
					entityBean, mapping.getModuleConfig(), this, mapping,
					request);
		}
		DynaActionForm legReqForm = (DynaActionForm) form;
		String legNumber = (String)legReqForm.get(LEGNUMBER);
		request.setAttribute(ACTIONID, 2);
		request.setAttribute(LEGNUMBER, legNumber);
		return mapping.findForward(ADDLEG);
	}

	/**
	 * 
	 * @param form
	 * @param request
	 * @param mapping
	 */
	@Override
	protected void saveLeg(DynaActionForm form, HttpServletRequest request, ActionMapping mapping, boolean isValidate) throws Exception {
		DynaActionForm legSummaryForm = (DynaActionForm) form.get(LEGSUMMARY);
		int legNumber = Integer.valueOf((String)form.get(LEGNUMBER));
		legSummaryForm.set(LEGNUMBER, String.valueOf(legNumber));
		String currency = "";
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

		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		request.setAttribute(DEALREQUESTID, deal.getDealSeqId());
		Object leg = CurrentDealManager.getLegByNumber(legNumber, request);
		ServletContext servletContext = getServlet().getServletContext();
		ICFPLegHelper.synchLegWithForm(leg, form, request, servletContext, mapping, this);
		CurrentDealManager.syncCommentsWithFormObject(request);
		//Handling Qualitative Factors
		LegSummary legSummary = (LegSummary)ICFPLegHelper.getLegSummary(leg); // Type casting directly to LegSummary because in case of CPA control never comes to this action
		@SuppressWarnings("unchecked")
		List<QualitativeFactors> quanlitativeFectorsList = Utils.fetchPropertyValue(QUALITATIVEFACTORS, legSummary, List.class);
		String radioButton =  request.getParameter(RADIOVALUE);
		if(radioButton!=null) {
			applyQuantativeAssesment(quanlitativeFectorsList, request, radioButton, legNumber);
		}
		
		String opcode = ICFPLegHelper.getOpCode(leg);
		Integer legSeqId = ICFPLegHelper.getLegSeqId(leg);
		if (leg instanceof RCALegRequest) {
			if ((opcode == null && legSeqId == null) || (opcode!=null && opcode.equals(FOINSERT) && legSeqId == null) ) {
				ICFPLegHelper.setOpCodeFlag(leg, FOINSERT);
			} else{
				RCALegRequest rcaLeg = (RCALegRequest) leg;
			    rcaLeg.getLegSummary().setLegOpcode(FOUPDATE);
			}
		} else {
			if ((opcode == null && legSeqId == null) || (opcode!=null && opcode.equals(INSERT) && legSeqId == null)){
				ICFPLegHelper.setOpCodeFlag(leg, INSERT);
			} else{
				ICFPLegHelper.setOpCodeFlag(leg, UPDATE);
			}

		}
		if(isValidate){
			ActionErrors errors = AttachmentValidator.getInstance().validateLeg(leg, request);
			if(!errors.isEmpty()) {
				saveErrors(request, errors);
				request.setAttribute("atmtError","Please fix the following fields highlighted in red.");
				return;
			}
			ICFPLegHelper.setFOValidateFlag(leg, ICFPConstants.Y_CAP);
		}else{
			ICFPLegHelper.setFOValidateFlag(leg, ICFPConstants.N_CAP);
		}
		ICFPLegHelper.prepareMsgHeader(deal, INSERTDEAL, SAVE,22);
		deal = serviceClient.invokeService(DEAL, deal, DealRequest.class);
		deal = ICFPCommonHelper.getDeal(deal.getDealSeqId(), serviceClient);
		CurrentDealManager.setActiveDeal(deal, request);
		
		Object leg1 = CurrentDealManager.getLegByNumber(legNumber, request);
		legSeqId = ICFPLegHelper.getLegSeqId(leg1);
		
		request.setAttribute(UPDATEMESSAGE,LEG_LABEL+ legSeqId + UPDATED_LABEL);
		
	}
	
	/**
	 * applyAssesment is used to apply qualitative assessment for the all or remaining legs.
	 * @param legForm InputLegForm
	 * @param request HttpServletRequest
	 * @throws ICFPException 
	 */
	private void applyQuantativeAssesment(List<QualitativeFactors> currentLegQualitativeFactors, HttpServletRequest request, String qApplyAssessment, int legNumber) throws ICFPException {
		Integer startLegNumber = null;
		
		if (StringUtils.isNotBlank(qApplyAssessment) && ALL.equals(qApplyAssessment)) {
			startLegNumber = 1;
		} else if (StringUtils.isNotBlank(qApplyAssessment) && REMAINING.equals(qApplyAssessment)) {
			startLegNumber = 1;
		} 
		
		// If Checkbox selected
		if(startLegNumber != null) {
			for(; startLegNumber <= CurrentDealManager.getLegCount(request); startLegNumber++) {
				if(startLegNumber.equals(legNumber)) {
					continue;
				}
				request.setAttribute(FO_FLAG, TRUE);
				if(DealManager.hideLegView(startLegNumber, request)){
					continue;
				}
				Object leg = CurrentDealManager.getLegByNumber(startLegNumber, request);
				ICFPLegHelper.applyQualitativeFactor(qApplyAssessment, leg, currentLegQualitativeFactors, 1, 2, 3, 4, 5);
			}
		}
	}
		
	/**
	 * Method is used to Method is used to display ReadOnly Entity Details
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward setLenderBorrowerDetails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm legReqForm = (DynaActionForm) form;
		String entityName=(String)request.getParameter(FORCALegAction.ENTITY2);
		Integer legNumber = Integer.valueOf(legReqForm.getString(LEGNUMBER));
		Object leg = CurrentDealManager.getLegByNumber(legNumber, request);
		EntityType entityType = EntityType.valueOf(entityName);
		Entity entity = EntityHelper.searchEntityInLeg(leg, entityType);

		String funCompany=(String)request.getParameter(FORCALegAction.FUN_COMPANY);
		String companyName=null;
		if(!StringUtils.isBlank(funCompany)){
			int companyId=Integer.valueOf(funCompany);
			companyName=Utils.getFundingCompanyName(companyId, request);
		}

		entity.setCDRCd((String)request.getParameter(FORCALegAction.CDR_CODE));
		entity.setLEGoldId((String)request.getParameter(FORCALegAction.GOLD_ID));
		entity.setLEName((String)request.getParameter(FORCALegAction.LE_NAME));
		entity.setCountry((String)request.getParameter(COUNTRY));
		entity.setCapitalIndustrial((String)request.getParameter(FORCALegAction.CAPITAL_INDUSTRIAL));
		entity.setBusinessSegment((String)request.getParameter(BUSINESSSEGMENT));
		entity.setMEName((String)request.getParameter(FORCALegAction.MGMT_ENTITY));
		entity.setFundHoldOperation(companyName);
		entity.setRegulatedEntityFlag(new Boolean((String)request.getParameter(FORCALegAction.REGULATED_ENTITY)));
		entity.setPrincplEntityFlag(new Boolean((String)request.getParameter(FORCALegAction.PRINCPL_ENTITY)));
	
		String[] tCodes = null;
		String treasuryCode = (String)request.getParameter(FORCALegAction.TCODE);
		if(StringUtils.isNotBlank(treasuryCode)) {
			tCodes = new String[] {treasuryCode};
		}
		
		if(tCodes != null && tCodes.length > 0) {
			ArrayList<String> newList = new ArrayList<String>();
			newList.addAll( Arrays.asList(tCodes) );
			entity.setTreasuryCodes( newList );
		}
		EntityHelper.syncFormWithEntities(legReqForm, leg, request, mapping, this);
		request.setAttribute(ACTIONID, 2);
		request.setAttribute(LEGNUMBER, legNumber);
		return mapping.findForward(DAY2LEG);
	}
	/**
	 * isNextLeg is used to identify whether the next leg is available in the deal object.
	 * @param legForm InputLegForm
	 * @param request HttpServletRequest
	 * @return boolean
	 */
	protected Integer isNextLeg(int legNum, HttpServletRequest request){
		if(legNum < CurrentDealManager.getCurrentDeal(request).getLegs().getAllLegs().size()){
			return getNextLeg(legNum, request);
		}
		return 0;
	}
	/**
	 * @param legForm
	 * @param request
	 * @return
	 */
	protected Integer getNextLeg(Integer legNumber, HttpServletRequest request) {
		request.setAttribute(FO_FLAG, TRUE);
		boolean isGoToNextLeg = DealManager.hideLegView(legNumber+1, request);
		int noOfLegs = CurrentDealManager.getCurrentDeal(request).getLegs().getAllLegs().size();
		if(isGoToNextLeg){
			if((legNumber + 1) < noOfLegs){
				return getNextLeg(legNumber +1, request);
			}else{
				return 0;
			}
		}else{
			if((legNumber + 1) <= noOfLegs){
				return legNumber + 1;
			}else{
				return 0;
			}
		}
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
	public ActionForward saveNextLeg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		saveLeg((DynaActionForm) form, request, mapping, true);
		if(getErrors(request).isEmpty()) {
			CurrentDealManager.syncCommentsWithFormObject(request);
			request.getSession().removeAttribute(ADDORMODIFYFLAG);
			request.getSession().setAttribute(REMOVECURRENT, YES);
			Integer legNumber = Integer.valueOf(((DynaActionForm)form).getString(LEGNUMBER));
			Object leg = CurrentDealManager.getLegByNumber(legNumber, request);
			Integer legSeqId = ICFPLegHelper.getLegSeqId(leg);
			int nextLegNo = isNextLeg( legNumber, request ).intValue();
			if(nextLegNo > 0){
				request.setAttribute(LEGNUMBER, nextLegNo);
				request.setAttribute(UPDATEMESSAGE, FORCALegAction.YOUR_LEG+legSeqId+FORCALegAction.INFORMATION_IS_SAVED_SUCCESSFULLY);
				return openLeg(mapping, form, request, response);
			}
			request.setAttribute(LEGNUMBER, legNumber);
			request.setAttribute(UPDATEMESSAGE, FORCALegAction.YOUR_LEG+legSeqId+FORCALegAction.INFORMATION_IS_SAVED_SUCCESSFULLY);
			return openLeg(mapping, form, request, response);
		}else{
			Integer legNumber = Integer.valueOf(((DynaActionForm)form).getString(LEGNUMBER));
			request.setAttribute(LEGNUMBER, legNumber);
			return openLeg(mapping, form, request, response);
		}
		
	}	
}
