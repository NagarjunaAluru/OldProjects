/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: CPALegAction.java
 * Purpose: CPALegAction used for adding,deleting,updating leg details
 */
package com.ge.icfp.common.legs.action;

import static com.ge.icfp.common.constants.ICFPConstants.ACTIONID;
import static com.ge.icfp.common.constants.ICFPConstants.ADDORMODIFYFLAG;
import static com.ge.icfp.common.constants.ICFPConstants.ADDORMODIFYREQ;
import static com.ge.icfp.common.constants.ICFPConstants.ADDREQUEST;
import static com.ge.icfp.common.constants.ICFPConstants.BANKTREASURYCD;
import static com.ge.icfp.common.constants.ICFPConstants.BOTH;
import static com.ge.icfp.common.constants.ICFPConstants.CAPITAL;
import static com.ge.icfp.common.constants.ICFPConstants.CASHPOOL;
import static com.ge.icfp.common.constants.ICFPConstants.CDR;
import static com.ge.icfp.common.constants.ICFPConstants.COUNTRY;
import static com.ge.icfp.common.constants.ICFPConstants.CPALEGREQUESTFORM;
import static com.ge.icfp.common.constants.ICFPConstants.CPASUMMARY_SMALL;
import static com.ge.icfp.common.constants.ICFPConstants.CURRENCY;
import static com.ge.icfp.common.constants.ICFPConstants.CURRENCYCD;
import static com.ge.icfp.common.constants.ICFPConstants.DEAL;
import static com.ge.icfp.common.constants.ICFPConstants.DISTINCTME;
import static com.ge.icfp.common.constants.ICFPConstants.DRAFT;
import static com.ge.icfp.common.constants.ICFPConstants.DRAFT_GLOBEL;
import static com.ge.icfp.common.constants.ICFPConstants.ENTITYFORM;
import static com.ge.icfp.common.constants.ICFPConstants.EVENTTYPE;
import static com.ge.icfp.common.constants.ICFPConstants.EVENTTYPENAME;
import static com.ge.icfp.common.constants.ICFPConstants.GETGOLDINFO;
import static com.ge.icfp.common.constants.ICFPConstants.GETME;
import static com.ge.icfp.common.constants.ICFPConstants.GOLDIDFLAG;
import static com.ge.icfp.common.constants.ICFPConstants.INDUSTRIAL;
import static com.ge.icfp.common.constants.ICFPConstants.INSERT;
import static com.ge.icfp.common.constants.ICFPConstants.INSERTDEAL;
import static com.ge.icfp.common.constants.ICFPConstants.LEGEXIST;
import static com.ge.icfp.common.constants.ICFPConstants.LEGNUMBER;
import static com.ge.icfp.common.constants.ICFPConstants.LEGNUMBER_STRING;
import static com.ge.icfp.common.constants.ICFPConstants.LEGOLDID;
import static com.ge.icfp.common.constants.ICFPConstants.LEG_LABEL;
import static com.ge.icfp.common.constants.ICFPConstants.LENDERDETAILS;
import static com.ge.icfp.common.constants.ICFPConstants.LENDERORPROVIDER;
import static com.ge.icfp.common.constants.ICFPConstants.LENDERTCODE;
import static com.ge.icfp.common.constants.ICFPConstants.LENDERTREASURYCODE;
import static com.ge.icfp.common.constants.ICFPConstants.MDM;
import static com.ge.icfp.common.constants.ICFPConstants.OPENLEG;
import static com.ge.icfp.common.constants.ICFPConstants.PARTICIPANTBANKDETAILS;
import static com.ge.icfp.common.constants.ICFPConstants.PARTICIPANTENTITY;
import static com.ge.icfp.common.constants.ICFPConstants.PARTICIPANTTCODEENTITIES;
import static com.ge.icfp.common.constants.ICFPConstants.POOLLEADERENTITY;
import static com.ge.icfp.common.constants.ICFPConstants.REGION;
import static com.ge.icfp.common.constants.ICFPConstants.REMOVECURRENT;
import static com.ge.icfp.common.constants.ICFPConstants.SAVE;
import static com.ge.icfp.common.constants.ICFPConstants.SAVED_SUCCESSFULLY;
import static com.ge.icfp.common.constants.ICFPConstants.SAVEMSG;
import static com.ge.icfp.common.constants.ICFPConstants.SUCCESS;
import static com.ge.icfp.common.constants.ICFPConstants.TCODELEME;
import static com.ge.icfp.common.constants.ICFPConstants.TREASURYCODE;
import static com.ge.icfp.common.constants.ICFPConstants.UPDATE;
import static com.ge.icfp.common.constants.ICFPConstants.UPDATED_LABEL;
import static com.ge.icfp.common.constants.ICFPConstants.UPDATEMESSAGE;
import static com.ge.icfp.common.constants.ICFPConstants.VAULTIDDETAILS;
import static com.ge.icfp.common.constants.ICFPConstants.VAULTIDDETAILS_SMALL;
import static com.ge.icfp.common.constants.ICFPConstants.VAULTREQUESTID;
import static com.ge.icfp.common.constants.ICFPConstants.YES;
import static com.ge.icfp.common.constants.ICFPConstants.YES_CAP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import com.ge.icfp.common.attachments.validation.AttachmentValidator;
import com.ge.icfp.common.constants.ICFPConstants;
import com.ge.icfp.common.formbean.InputLegForm;
import com.ge.icfp.common.helper.CurrentDealManager;
import com.ge.icfp.common.helper.EntityHelper;
import com.ge.icfp.common.helper.ICFPCommonHelper;
import com.ge.icfp.common.helper.ICFPDay2LegHelper;
import com.ge.icfp.common.helper.ICFPLegHelper;
import com.ge.icfp.model.CPALegRequest;
import com.ge.icfp.model.CPASummary;
import com.ge.icfp.model.DealCurrency;
import com.ge.icfp.model.DealRequest;
import com.ge.icfp.model.Entity;
import com.ge.icfp.model.Entity.BankInformation;
import com.ge.icfp.model.MDM;
import com.ge.icfp.model.MDM.CashPool;
import com.ge.icfp.model.MDM.Country;
import com.ge.icfp.model.MDM.Pagination;
import com.ge.icfp.model.MDM.Region;
import com.ge.icfp.model.MDM.VaultIDDetails;
import com.ge.icfp.model.MDM.VaultIDDetails.Participant;
import com.ge.icfp.model.MDM.VaultIDDetails.PoolLeader;
import com.ge.icfp.model.MgmtEntity;
import com.ge.icfp.model.MsgHeader;
import com.ge.icfp.util.CashPoolSortByCountry;
import com.ge.icfp.util.ProductType;
import com.hydus.wff.core.exception.HWFServiceException;
import com.hydus.wff.core.exception.HWFStubException;

import formdef.plugin.util.FormUtils;
/**
 * @author ramakrishna.satti
 * CPALegAction used for adding, modifying, delete legs from the current deal
 */
public class CPALegAction extends RCALegAction {
	private static final String POOLLEGOLDID = "poollegoldid";
	private static final String PARTLEGOLDID = "partlegoldid";
	private static final String SIZE_OF_DETAILS = "sizeOfDetails";
	private static final String VAULT_DETAILS = "vaultDetails";
	private static final String TCODE_SIZE = "tcodeSize";
	private static final String ME_NAME = "MEName";
	private static final String PARTICIPANT_CODE = "participantCode";
	private static final String SELECTED_CASH_POOL = "selectedCashPool";
	private static final String BNK_NAME = "bnkName";
	private static final String ACCOUNT_ID = "accountId";
	private static final String CASH_POOLS = "cashPools";
	private static final String POOL_LEADER_SIZE = "poolLeaderSize";
	private static final String LE_GOLD_ID_DETAILS = "leGoldIDDetails";
	private static final String CURRENCY_LABEL = "currencyLabel";
	private static final String COUNTRY_LABEL = "countryLabel";
	private static final String REGION_LABEL = "regionLabel";
	private static final String CASH_POOL_SESSION = "cashPoolSession";
	private static final String VAULT_ID = "vaultId";
	private static final String TCODE = "tCode";
	private static final Logger logger = Logger.getLogger(CPALegAction.class);
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
			HttpServletRequest request, HttpServletResponse response)throws Exception {

		DynaActionForm localForm = (DynaActionForm)form;
		localForm.getMap().clear();
		ICFPLegHelper.prepareCPALegRequestForm((DynaActionForm)form, mapping, request, this);
		/* Day2 Start*/
		String eventTypeIdStr = (String) request.getAttribute(EVENTTYPE);
		Integer eventTypeId = (!StringUtils.isBlank(eventTypeIdStr)) ? Integer.valueOf(eventTypeIdStr) : null;
		/* Day2 End*/
		CPALegRequest cpaLeg = new CPALegRequest();
		CPASummary cpaSummary = new CPASummary();
		cpaSummary.setLegTypeId(3);
		cpaSummary.setProductType(ProductType.CPA.name());
		cpaSummary.setLegNumber(1);
		cpaSummary.setTransactionEventTypeId(eventTypeId);
		cpaSummary.setTransactionEventType((String)request.getAttribute(EVENTTYPENAME));
		request.getSession().setAttribute(ICFPConstants.ADD_CPA_LEG, ICFPConstants.ADD_CPA_LEG);
		cpaLeg.setCPASummary(cpaSummary);
		int legNumber = CurrentDealManager.getNewLegNumber(request);
		CurrentDealManager.addLeg(cpaLeg, request);
		ICFPDay2LegHelper.prepareLegForDay2Operations(cpaLeg);
		FormUtils.getInstance().populateForm(CPALEGREQUESTFORM, form, cpaLeg, mapping.getModuleConfig(), this, mapping, request);
		EntityHelper.syncFormWithEntities(localForm, cpaLeg, request, mapping, this);
		CurrentDealManager.syncCommentsWithFormObject(request);
		localForm.set(LEGNUMBER, String.valueOf(legNumber));
		String redirectPath = new StringBuilder().append(mapping.findForward(OPENLEG).getPath())
				.append(LEGNUMBER_STRING).append(legNumber).toString();
		
		request.setAttribute(ICFPConstants.PREV_PAGE_NUM, 1);
		request.setAttribute(ICFPConstants.NEXT_PAGE_NUM, 1);
		return new ActionForward(response.encodeRedirectURL(redirectPath), true);

		 
	}


	/**
	 * Method used to save the leg as draft
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward saveAsDraft(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception {

		saveLeg((DynaActionForm) form, request, mapping,false);
	
		request.getSession().removeAttribute(ADDORMODIFYFLAG);
		request.getSession().removeAttribute(ADDORMODIFYREQ);
		request.getSession().setAttribute(REMOVECURRENT, YES);
		request.setAttribute(LEGEXIST, YES_CAP);
		
		DynaActionForm legForm = (DynaActionForm) form;
		int legNumber = Integer.valueOf((String)legForm.get(LEGNUMBER));
		CPALegRequest leg = CurrentDealManager.getLegByNumber(legNumber, CPALegRequest.class, request);

		request.setAttribute(SAVEMSG, SAVED_SUCCESSFULLY);

		request.setAttribute(ACTIONID, 1);
		request.setAttribute(LEGNUMBER, legNumber);
	
		return openLeg(mapping, form, request, response);
	}

	/**
	 * Method to save the leg and return to deal
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
			CurrentDealManager.syncCommentsWithFormObject(request);
			request.getSession().removeAttribute(ADDORMODIFYFLAG);
			request.getSession().removeAttribute(ADDORMODIFYREQ);
			request.setAttribute(LEGEXIST, YES_CAP);
			return mapping.findForward(SUCCESS);
		}else{
			return openLeg(mapping, form, request, response);
		}
	}
		
	/**
	 * Method to save and add another leg
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward saveAndAddAnotherLeg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		saveLeg((DynaActionForm) form, request, mapping,true);
		if (getErrors(request).isEmpty()) {
			request.getSession().removeAttribute(ADDORMODIFYFLAG);
			request.getSession().removeAttribute(ADDORMODIFYREQ);
			request.setAttribute(LEGEXIST, YES_CAP);
			return addLeg(mapping, form, request, response);
		}else{
			return openLeg(mapping, form, request, response);
		}
	}		
	/**
	 * Method to save the leg to current deal
	 * @param form
	 * @param request
	 * @param mapping
	 */
	public void saveLeg(DynaActionForm form, HttpServletRequest request, ActionMapping mapping, boolean isValidate) throws Exception{
		DynaActionForm legSummaryForm = (DynaActionForm) form.get(CPASUMMARY_SMALL);
		int legNumber = Integer.valueOf((String)form.get(LEGNUMBER));
		legSummaryForm.set(LEGNUMBER, String.valueOf(legNumber));
		request.getSession().removeAttribute(VAULTREQUESTID);
		String vaultRequestID = (String)form.get(CPALegAction.VAULT_ID);
		boolean cloneFlag = false;
		if(!StringUtils.isEmpty(vaultRequestID))
		{
			DealRequest deal = CurrentDealManager.getCurrentDeal(request);
			deal.setVaultId(vaultRequestID);
			request.getSession().setAttribute(VAULTREQUESTID,vaultRequestID);
		}
		
		CPALegRequest leg = CurrentDealManager.getLegByNumber(legNumber, CPALegRequest.class, request);
		ServletContext servletContext = getServlet().getServletContext();
		
		if(logger.isInfoEnabled()) {
			logger.info("Saving form bean to leg type " + leg);
		}
		ICFPLegHelper.syncCPALegWithForm(leg, form, request, servletContext, mapping, this);
		
		String opcode = leg.getCPASummary().getCPALegOpcode();
		Integer legSeqId = leg.getCPASummary().getLegSeqId();
		if(legSeqId==null && opcode!=null && opcode.equals(INSERT)) {
			cloneFlag = true;
		}
		
		if(!cloneFlag) {
		if((opcode == null || opcode.equals("")) &&  legSeqId == null) {
			leg.getCPASummary().setCPALegOpcode(INSERT);
		} else if(legSeqId != null && opcode == null) {
			leg.getCPASummary().setCPALegOpcode(UPDATE);
		}
		}else{
			leg.getCPASummary().setCPALegOpcode(INSERT);
		}
		request.setAttribute(LEGNUMBER, legNumber);
		request.setAttribute(LEGEXIST, YES_CAP);
		request.getSession().setAttribute(CPALegAction.CASH_POOL_SESSION, null);
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		CurrentDealManager.syncCommentsWithFormObject(request);
		if(deal != null && deal.getUniqueId().contains(DRAFT)){
			ICFPLegHelper.prepareMsgHeader(deal, INSERTDEAL, DRAFT_GLOBEL,1);
		}else{
			ICFPLegHelper.prepareMsgHeader(deal, INSERTDEAL, SAVE,22);
		}
		if(isValidate){
			ActionErrors errors = AttachmentValidator.getInstance().validateLeg(leg, request);
			if(!errors.isEmpty()) {
				saveErrors(request, errors);
				request.setAttribute("atmtError","Please fix the following fields highlighted in red.");
				return;
			}
			ICFPLegHelper.setReqValidateFlag(leg, ICFPConstants.Y_CAP);
		}else{
			ICFPLegHelper.setReqValidateFlag(leg, ICFPConstants.N_CAP);
		}
		deal = serviceClient.invokeService(DEAL, deal, DealRequest.class);
		deal = ICFPCommonHelper.getDeal(deal.getDealSeqId(), serviceClient);
		CurrentDealManager.setActiveDeal(deal, request);
		
		Object leg1 = CurrentDealManager.getLegByNumber(legNumber, request);
		legSeqId = ICFPLegHelper.getLegSeqId(leg1);
		
		request.setAttribute(UPDATEMESSAGE,LEG_LABEL+ legSeqId + UPDATED_LABEL);
	}
	
	/**
	 * Method to get the pool details
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "unchecked" })
	public ActionForward getPoolLeaderEntites(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws Exception {
		request.getSession().setAttribute(CPALegAction.CASH_POOL_SESSION, null);
		String actionId = request.getParameter(ACTIONID);
		String regionCode = request.getParameter(REGION);
		String countryCode = request.getParameter(COUNTRY);
		String currencyCode = request.getParameter(CURRENCY);
		String regionLabel = request.getParameter(CPALegAction.REGION_LABEL);
		String countryLabel = request.getParameter(CPALegAction.COUNTRY_LABEL);
		String currencyLabel = request.getParameter(CPALegAction.CURRENCY_LABEL);
		String leGoldID = request.getParameter(CPALegAction.LE_GOLD_ID_DETAILS);
		String tCode =  request.getParameter(CPALegAction.TCODE);
		
		if(regionCode==null || regionCode.equals("") || regionCode.equals(ICFPConstants.ZERO))
		{
			request.getSession().setAttribute(CPALegAction.REGION_LABEL, "--");
		}else
		{
			request.getSession().setAttribute(CPALegAction.REGION_LABEL, regionLabel);
		}
		if(currencyCode==null || currencyCode.equals("") || currencyCode.equals(ICFPConstants.ZERO))
		{
			request.getSession().setAttribute(CPALegAction.CURRENCY_LABEL, "--");
		}else
		{
			request.getSession().setAttribute(CPALegAction.CURRENCY_LABEL, currencyLabel);
		}

		List<Region> regions = new ArrayList<Region>();
		Region region = new Region();
		if(regionCode!=null  && !regionCode.trim().equals("") && !regionCode.trim().equals(ICFPConstants.ZERO)){

			region.setRegionID(regionCode);
			region.setRegionName(regionLabel);
			regions.add(region);
		}
		Pagination pagination = new Pagination();
		String pageNumber = request.getParameter(ICFPConstants.PAGE_NUMBER);
		int pageNumberInt=1;
		if(pageNumber!=null && StringUtils.isNotBlank(pageNumber)){
			pageNumberInt = Integer.parseInt(pageNumber);
			pagination.setPaginationStart(pageNumberInt);	
		}else{
			pagination.setPaginationStart(1);
		}
		
		pagination.setPaginationIncrement(ICFPConstants.THREE_HUNDRED);
		
		List<Country> countries = new ArrayList<Country>();
		Country country = new Country();
		if(countryCode!=null && !countryCode.trim().equals("") &&  !countryCode.trim().equals(ICFPConstants.ZERO)){
			country.setCountryCode(countryCode);
			country.setCountryName(countryLabel);
			countries.add(country);
		}
		List<DealCurrency> dealCurrencies = new ArrayList<DealCurrency>();
		DealCurrency dealCurrency = new DealCurrency();

		if(currencyCode!=null  && !currencyCode.trim().equals("") && !currencyCode.trim().equals(ICFPConstants.ZERO)){
			dealCurrency.setCurrencyCode(currencyCode);
			dealCurrencies.add(dealCurrency);
		}
		
		List<Entity> entityLst = null;
		
		if(leGoldID!=null && StringUtils.isNotBlank(leGoldID)){
			entityLst = new ArrayList<Entity>();
			Entity entity = new Entity();
			entity.setLEGoldId(leGoldID);
			entityLst.add(entity);
		}
    	
		if(tCode!=null && StringUtils.isNotEmpty(tCode))
		{
			entityLst = new ArrayList<Entity>();
			List<String> tcodeList = new ArrayList<String>();
			tcodeList.add(tCode);
			Entity entity = new Entity();
			entity.setTreasuryCodes(tcodeList);
			entityLst.add(entity);
		}
		
		MDM mdm = new MDM();
		MsgHeader msgHeader = new MsgHeader();
		msgHeader.setOpcode(CASHPOOL);
		mdm.setMsgHeader(msgHeader);
		mdm.setRegions(regions);
		mdm.setCountries(countries);
		mdm.setDealCurrencies(dealCurrencies);
		mdm.setPagination(pagination);
		if(entityLst!=null && entityLst.size()>0){
		   mdm.setEntities(entityLst);
		}
		
		mdm = serviceClient.invokeService(MDM,mdm,MDM.class);
		List<CashPool> resultCP = null;
		if(mdm != null){
			resultCP = mdm.getCashPools();
			Collections.sort(resultCP,new CashPoolSortByCountry());
			request.setAttribute(CPALegAction.POOL_LEADER_SIZE, resultCP.size());
			int recordCount = mdm.getRecordCount();
			request.setAttribute(ICFPConstants.PREV_PAGE_NUM, pageNumberInt);
			if(recordCount >= ICFPConstants.THREE_HUNDRED){
				pageNumberInt = pageNumberInt+ICFPConstants.THREE_HUNDRED;
				request.setAttribute(ICFPConstants.NEXT_PAGE_NUM, pageNumberInt);
			}
			request.setAttribute(ICFPConstants.RECORD_COUNT, mdm.getRecordCount());
			request.setAttribute(ICFPConstants.VALID_RECORD_COUNT, mdm.getValidRecordCount());
		}
		request.getSession().setAttribute(CPALegAction.CASH_POOL_SESSION, resultCP);
		request.setAttribute(CPALegAction.CASH_POOLS, resultCP);
		DynaActionForm legReqForm = (DynaActionForm) form;
		String legNumber = (String)legReqForm.get(LEGNUMBER);
		request.setAttribute(ACTIONID, actionId);
		request.setAttribute(LEGNUMBER, legNumber);
		
		return mapping.findForward(ADDREQUEST);
	}
	
	/**
	 * Method to get Pool lender details from the MDM Service
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward getPoolLeaderDetailas(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String accountNbr = request.getParameter(CPALegAction.ACCOUNT_ID);
		String actionId = request.getParameter(ACTIONID);
		@SuppressWarnings("unchecked")
		List<CashPool> cashPoolList = (List<CashPool>) request.getSession().getAttribute(CPALegAction.CASH_POOL_SESSION);
		Entity entityBean = new Entity();
		
		if(cashPoolList!=null && accountNbr!=null )
		{
			for(CashPool cashPoolObj:cashPoolList)
			{
				if(cashPoolObj==null)
					continue;
				
				String cashPoolAcctNbr = cashPoolObj.getAccountId();
				
				if(cashPoolAcctNbr!=null && cashPoolAcctNbr.equals(accountNbr))
				{
					// This service call is to get CDR Code and capital or industrial
					// based on LE GOLD ID
					Entity serviceEntity= getCDRCapitalValues(cashPoolObj);
					entityBean.setBusinessSegment(cashPoolObj.getBusinessSegment());
					entityBean.setCDRCd(serviceEntity.getCDRCd());
					entityBean.setCapitalIndustrial(serviceEntity.getCapitalIndustrial());
					entityBean.setLeType(serviceEntity.getCapitalIndustrial());
					entityBean.setLEName(cashPoolObj.getLegalEntity());
					entityBean.setLEGoldId(cashPoolObj.getLEGoldID());
					entityBean.setLeTypeId(8);
					//entityBean.setCDRCd(cashPoolObj.getCDRCode());
					entityBean.setCountry(serviceEntity.getCountry());
					String countryCode = cashPoolObj.getCountry();
					if(countryCode==null || countryCode.equals("") || countryCode.equals(ICFPConstants.ZERO))
					{
						request.getSession().setAttribute(CPALegAction.COUNTRY_LABEL, "--");
					}else
					{
						request.getSession().setAttribute(CPALegAction.COUNTRY_LABEL, countryCode);
					}
					entityBean.setRegulatedEntityFlag(Boolean.parseBoolean(cashPoolObj.getRegulatedEntity()));
					entityBean.setPrincplEntityFlag(Boolean.parseBoolean(cashPoolObj.getPrincipalEntity()));
					entityBean.setMEName(cashPoolObj.getManagementEntity());
					if(entityBean.getCapitalIndustrial()!=null && entityBean.getCapitalIndustrial().equals(CAPITAL))
					{
						entityBean.setLeCategoryId(1);
					}else if(entityBean.getCapitalIndustrial()!=null && entityBean.getCapitalIndustrial().equals(INDUSTRIAL))
					{
						entityBean.setLeCategoryId(2);
					}else if(entityBean.getCapitalIndustrial()!=null && entityBean.getCapitalIndustrial().equals(BOTH))
					{
						entityBean.setLeCategoryId(3);
					}else{
						entityBean.setLeCategoryId(null);
					}
					entityBean.getTreasuryCodes().add(cashPoolObj.getTreasuryCode());
					entityBean.setBankTreasuryCd(cashPoolObj.getBankName());
					
					DynaActionForm legReqForm = (DynaActionForm) form;
					DynaActionForm legSummaryForm = (DynaActionForm) legReqForm.get(CPASUMMARY_SMALL);
					DynaActionForm poolLeaderEntity = new DynaActionForm();
					poolLeaderEntity = (DynaActionForm) legSummaryForm.get(POOLLEADERENTITY);
			
					FormUtils.getInstance().populateForm(ENTITYFORM, poolLeaderEntity, entityBean, mapping.getModuleConfig(), this, mapping, request);
					poolLeaderEntity.set(TREASURYCODE, cashPoolObj.getTreasuryCode());
					legSummaryForm.set(REGION, cashPoolObj.getRegion());
					legSummaryForm.set(COUNTRY, cashPoolObj.getCountry());
					legSummaryForm.set(CURRENCYCD, cashPoolObj.getCurrency());
					legSummaryForm.set(CPALegAction.BNK_NAME, cashPoolObj.getBankName());
					request.setAttribute(CPALegAction.SELECTED_CASH_POOL, cashPoolObj);
					
					request.getSession().setAttribute(CPALegAction.CASH_POOL_SESSION, null);
					
					break;
				}
			}
		}
		DynaActionForm legReqForm = (DynaActionForm) form;
		String legNumber = (String)legReqForm.get(LEGNUMBER);
		request.setAttribute(ACTIONID, actionId);
		request.setAttribute(LEGNUMBER, legNumber);
	
		return mapping.findForward(ADDREQUEST);
	}
	
	/**
	 * Method to get Gold details
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
		}
		String participantCode = request.getParameter(CPALegAction.PARTICIPANT_CODE);
		List<Entity> entityLst = new ArrayList<Entity>();
		Entity entity = new Entity();
		if(participantCode!= null && participantCode.equals(CDR)){
			entity.setCDRCd(goldId);
		}else{
			entity.setLEGoldId( goldId );
		}
		entity.setLeTypeId(7);
		entityLst.add(entity);
		mdmObject.setEntities(entityLst);
		mdmObject = serviceClient.invokeService(MDM, mdmObject,MDM.class);
		if(mdmObject!=null){
			DynaActionForm legReqForm = (DynaActionForm) form;
			Entity entityBean = new Entity();
			if(mdmObject.getEntities().size()!=0){
				entityBean = mdmObject.getEntities().get(0);
			}
			DynaActionForm legSummaryForm = (DynaActionForm) legReqForm.get(CPASUMMARY_SMALL);

			DynaActionForm participantEntity = new DynaActionForm();
			if(goldIdFlag.equals(LENDERDETAILS)){
				participantEntity = (DynaActionForm) legSummaryForm.get(PARTICIPANTENTITY);
			}
			FormUtils.getInstance().populateForm(ENTITYFORM, participantEntity, entityBean, mapping.getModuleConfig(), this, mapping, request);
		}
		DynaActionForm legReqForm = (DynaActionForm) form;
		String legNumber = (String)legReqForm.get(LEGNUMBER);
		request.setAttribute(ACTIONID, 1);
		request.setAttribute(LEGNUMBER, legNumber);
		
		return mapping.findForward(ADDREQUEST);
	}
	
	/**
	 * Method to get Gold details
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward getTCodeDetails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws Exception {

		
		MsgHeader msgHeader = new MsgHeader();
		msgHeader.setOpcode(TCODE);
		MDM mdmObject = new MDM();
		mdmObject.setMsgHeader(msgHeader);
		String goldId=""; 
		String goldIdFlag = request.getParameter(GOLDIDFLAG);
		if(goldIdFlag.equals(LENDERTCODE)){
			goldId = request.getParameter(LENDERTREASURYCODE).toUpperCase();
		}
		String cdrGoldID = request.getParameter(LEGOLDID);
		String MEName = request.getParameter(CPALegAction.ME_NAME);
		
		List<Entity> entityLst = new ArrayList<Entity>();
		Entity entity = new Entity();
		entity.getTreasuryCodes().add(goldId);
		entity.setLEGoldId(cdrGoldID);
		entity.setMEName(MEName);
		entityLst.add(entity);
		mdmObject.setEntities(entityLst);
		mdmObject = serviceClient.invokeService(MDM, mdmObject,MDM.class);
		if(mdmObject!=null){
			DynaActionForm legReqForm = (DynaActionForm) form;
			if(mdmObject.getEntities().size()!=0){
				
				for(Entity entityObj:mdmObject.getEntities())
				{
					
					if(entityObj.getTreasuryCodes()!=null && goldId!=null && entityObj.getTreasuryCodes().equals(goldId))
					{
						entity = entityObj;
						break;
					}
				}
				
				
			}
			
			DynaActionForm legSummaryForm = (DynaActionForm) legReqForm.get(CPASUMMARY_SMALL);
			String tcodes[] = (String[])legSummaryForm.get(PARTICIPANTTCODEENTITIES);
			
			if(tcodes==null || tcodes.length==0)
			{
				String[] tCodes = new String[entity.getTreasuryCodes().size()];
				legSummaryForm.set(PARTICIPANTTCODEENTITIES, entity.getTreasuryCodes().toArray(tCodes));
				request.setAttribute(CPALegAction.TCODE_SIZE, tCodes.length);
			}else if (tcodes.length>0)
			{
				List<String> data= new ArrayList<String>();
				for(String existingTcode:tcodes) {
					data.add(existingTcode);
				}
				data.addAll(entity.getTreasuryCodes());
				String[] finalTCodes = new String[data.size()];
				finalTCodes = data.toArray(finalTCodes);
				legSummaryForm.set(PARTICIPANTTCODEENTITIES, finalTCodes);
			}
			
			List<Entity.BankInformation> bankInformationList = 
					(List<BankInformation>) request.getSession().getAttribute(PARTICIPANTBANKDETAILS);
			
			if(bankInformationList==null || bankInformationList.size()<=0)
			{
				MsgHeader header = new MsgHeader();
				header.setOpcode(TCODELEME);
				
				Entity en = new Entity();
				en.setLEGoldId( cdrGoldID );
				en.setMEName( MEName );
				
				MDM mdm = new MDM();
				mdm.getEntities().add(en);
				mdm.setMsgHeader(header);
				
				mdm = serviceClient.invokeService(MDM, mdm, MDM.class);
				Entity entityObj = mdm.getEntities().get(0);
				
				if(entityObj!=null && entityObj.getBankInformations()!=null && entityObj.getBankInformations().size()>0)
				{
					request.getSession().removeAttribute(PARTICIPANTBANKDETAILS);
					request.getSession().setAttribute(PARTICIPANTBANKDETAILS, entityObj.getBankInformations());
					bankInformationList = entityObj.getBankInformations();
				}
			}
			
			
			
			DynaActionForm pEntity = (DynaActionForm) legSummaryForm.get(PARTICIPANTENTITY);
			String bankName = pEntity.getString(BANKTREASURYCD);
			
			if(bankInformationList!=null){

				for(Entity.BankInformation bankInformation:bankInformationList)
				{
					if(goldId!=null && StringUtils.isNotEmpty(goldId) 
							&& goldId.equals(bankInformation.getTreasuryCode()))
					{	
						
						
						if(bankName==null || StringUtils.isEmpty(bankName))
						{
							bankName=bankInformation.getBankName();
							break;
						}else if (bankName.contains(bankInformation.getBankName()))
						{
							break;
						}else{
							
							bankName = bankName 
										+ ";;"
										+ bankInformation.getBankName();
									
						}
					}
				}								
				pEntity.set(BANKTREASURYCD, bankName);
			}
		}
		DynaActionForm legReqForm = (DynaActionForm) form;
		String legNumber = (String)legReqForm.get(LEGNUMBER);
		request.setAttribute(ACTIONID, 1);
		request.setAttribute(LEGNUMBER, legNumber);
		return mapping.findForward(ADDREQUEST);
	}
	
	/**
	 * This method is called when you give vault id in vault id text box and press the button
	 * this will return related participant and pool leader details.
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward getVaultDetails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws Exception {
		
		String vaultID = (String)request.getParameter(VAULTIDDETAILS_SMALL);
		MDM mdm = new MDM();
		MsgHeader msgHeader = new MsgHeader();
		msgHeader.setOpcode(VAULTIDDETAILS);
		mdm.setMsgHeader(msgHeader);
		
		List<VaultIDDetails> vaultRequestIDList = new ArrayList<VaultIDDetails>();
		VaultIDDetails vaultRequestID = new VaultIDDetails();
		vaultRequestID.setVaultRequestID(vaultID);
		vaultRequestIDList.add(vaultRequestID);
		mdm.setVaultIDDetails(vaultRequestIDList);
		
		mdm = serviceClient.invokeService(MDM,mdm,MDM.class);
		List<VaultIDDetails> resultVaultDetails = null;
		if(mdm != null){
			resultVaultDetails = mdm.getVaultIDDetails();
		}
	
		List<Entity> entitiesList = mdm.getEntities();
		if(entitiesList!=null)
		{
			for(int i=0;i<entitiesList.size();i++)
			{
				if(i==0)
				{
					Entity entityObj = entitiesList.get(0);
					List<MgmtEntity> managementEntityList = mdm.getMgmtEntities();
					
					if(managementEntityList!=null && managementEntityList.size()>0){
						MgmtEntity mgmtEntityObj = managementEntityList.get(0);
						if(mgmtEntityObj!=null){
						  entityObj.setMEName(mgmtEntityObj.getName());
						}
					}
					

					DynaActionForm legReqForm = (DynaActionForm) form;
					DynaActionForm legSummaryForm = (DynaActionForm) legReqForm.get(CPASUMMARY_SMALL);
					DynaActionForm participantEntity = new DynaActionForm();
					participantEntity = (DynaActionForm) legSummaryForm.get(PARTICIPANTENTITY);
					FormUtils.getInstance().populateForm(ENTITYFORM, participantEntity, entityObj, mapping.getModuleConfig(), this, mapping, request);
					if(entityObj.getTreasuryCodes()!=null && entityObj.getTreasuryCodes().size()>0 )
					{
						String[] tcodes = {entityObj.getTreasuryCodes().get(0)};
						legSummaryForm.set(PARTICIPANTTCODEENTITIES, tcodes);
					}
					
					
				}else if (i==1)
				{
					Entity entityBean = new Entity();
					Entity serviceEntity = entitiesList.get(1);
					List<CashPool> cashPoolList = mdm.getCashPools();
					if(cashPoolList!=null && cashPoolList.size()>0){
							CashPool cashPoolObj = cashPoolList.get(0);
							entityBean.setCDRCd(serviceEntity.getCDRCd());
							entityBean.setCapitalIndustrial(serviceEntity.getCapitalIndustrial());
							entityBean.setLeType(serviceEntity.getCapitalIndustrial());
							entityBean.setLEName(cashPoolObj.getLegalEntity());
							entityBean.setLEGoldId(cashPoolObj.getLEGoldID());
							entityBean.setLeTypeId(8);
							entityBean.setCountry(serviceEntity.getCountry());
							String countryCode = cashPoolObj.getCountry();
							if(countryCode==null || countryCode.equals("") || countryCode.equals(ICFPConstants.ZERO))
							{
								request.getSession().setAttribute(CPALegAction.COUNTRY_LABEL, "--");
							}else
							{
								request.getSession().setAttribute(CPALegAction.COUNTRY_LABEL, countryCode);
							}
							entityBean.setRegulatedEntityFlag(serviceEntity.isRegulatedEntityFlag());
							entityBean.setPrincplEntityFlag(serviceEntity.isPrincplEntityFlag());
							entityBean.setMEName(cashPoolObj.getManagementEntity());
							
							if(entityBean.getCapitalIndustrial()!=null && entityBean.getCapitalIndustrial().equals(CAPITAL))
							{
								entityBean.setLeCategoryId(1);
							}else if(entityBean.getCapitalIndustrial()!=null && entityBean.getCapitalIndustrial().equals(INDUSTRIAL))
							{
								entityBean.setLeCategoryId(2);
							}else if(entityBean.getCapitalIndustrial()!=null && entityBean.getCapitalIndustrial().equals(BOTH))
							{
								entityBean.setLeCategoryId(3);
							}else{
								entityBean.setLeCategoryId(null);
							}
							entityBean.setBankTreasuryCd(cashPoolObj.getBankName());
							entityBean.setBusinessSegment(cashPoolObj.getBusinessSegment());
							
							DynaActionForm legReqForm = (DynaActionForm) form;
							DynaActionForm legSummaryForm = (DynaActionForm) legReqForm.get(CPASUMMARY_SMALL);
							DynaActionForm poolLeaderEntity = new DynaActionForm();
							poolLeaderEntity = (DynaActionForm) legSummaryForm.get(POOLLEADERENTITY);
					
							FormUtils.getInstance().populateForm(ENTITYFORM, poolLeaderEntity, entityBean, mapping.getModuleConfig(), this, mapping, request);
							poolLeaderEntity.set(TREASURYCODE, cashPoolObj.getTreasuryCode());
							legSummaryForm.set(REGION, cashPoolObj.getRegion());
							legSummaryForm.set(COUNTRY, cashPoolObj.getCountry());
							legSummaryForm.set(CURRENCYCD, cashPoolObj.getCurrency());
							legSummaryForm.set(CPALegAction.BNK_NAME, cashPoolObj.getBankName());
							request.setAttribute(CPALegAction.SELECTED_CASH_POOL, cashPoolObj);
							request.getSession().setAttribute(CPALegAction.CASH_POOL_SESSION, null);
						
						}
					
				}
			}
		}
		
		for(int i=0;i<resultVaultDetails.size();i++){
			VaultIDDetails vaultIDDetailsObj = resultVaultDetails.get(i);
			Participant participantObj = vaultIDDetailsObj.getParticipant();
			PoolLeader poolLeader = vaultIDDetailsObj.getPoolLeader();
					if(participantObj==null){
						resultVaultDetails.get(i).setParticipant(new Participant());
					}
					if(poolLeader==null)
					{
						PoolLeader poolLeaderObj = new PoolLeader();
						poolLeaderObj.setCDR("");
						poolLeaderObj.setLEGoldID("");
						
						resultVaultDetails.get(i).setPoolLeader(poolLeaderObj);
					}
			
		}
		
		request.setAttribute(CPALegAction.VAULT_DETAILS, resultVaultDetails);

		if(resultVaultDetails!=null && resultVaultDetails.size()>0)
		{
			request.setAttribute(CPALegAction.SIZE_OF_DETAILS, resultVaultDetails.size());
			
			int size = resultVaultDetails.size();
			
			if(size==1){
				//poolLeader.LEGoldID
				VaultIDDetails vaultIDDetailsObj = resultVaultDetails.get(0);
				
				request.setAttribute(CPALegAction.PARTLEGOLDID, vaultIDDetailsObj.getParticipant().getLEGoldID());
				request.setAttribute(CPALegAction.POOLLEGOLDID, vaultIDDetailsObj.getPoolLeader().getLEGoldID());
				
				
			}
			
			
		}
		

		DynaActionForm legReqForm = (DynaActionForm) form;
		String legNumber = (String)legReqForm.get(LEGNUMBER);
		if( null == legNumber || "".equals(legNumber) ){
			InputLegForm inputForm =
					(InputLegForm) request.getSession().getAttribute("inputform");
			Integer legNo = inputForm.getLegNumber();
			legNumber = (legNo!=null) ? String.valueOf(inputForm.getLegNumber()) : "";
		}
		request.setAttribute(ACTIONID, 1);
		request.setAttribute(LEGNUMBER, legNumber);

	
		return mapping.findForward(ADDREQUEST);
	}

	/**
	 * This method is called from vault details screen. If the vault details contain pool lender 
	 * legoldid then using that legoldid the related cash pool details are fetched and displayed
	 * in the leg screen
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward getVaultCashPoolDetails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
				throws Exception {
		
		    String leGoldId = request.getParameter(CPALegAction.LE_GOLD_ID_DETAILS);
		
		    List<CashPool> resultCP = null;
		    
		    if(!StringUtils.isEmpty(leGoldId)){

		    	MDM mdm = new MDM();
		    	List<Entity> entityLst = new ArrayList<Entity>();
		    	Entity entity = new Entity();
		    	entity.setLEGoldId(leGoldId);
		    	entityLst.add(entity);
		    	mdm.setEntities(entityLst);

		    	MsgHeader msgHeader = new MsgHeader();
		    	msgHeader.setOpcode(CASHPOOL);
		    	mdm.setMsgHeader(msgHeader);
		    	mdm = serviceClient.invokeService(MDM,mdm,MDM.class);

		    	if(mdm != null){
		    		resultCP = mdm.getCashPools();
		    	}
		    }
			
			Entity entityBean = new Entity();
			if(resultCP!=null && !resultCP.isEmpty())
			{
				CashPool cashPoolObj = resultCP.get(0);
				
				Entity serviceEntity = getCDRCapitalValues(cashPoolObj);
				
				entityBean.setLEName(cashPoolObj.getLegalEntity());
				entityBean.setLEGoldId(cashPoolObj.getLEGoldID());
				entityBean.setLeTypeId(8);
				entityBean.setCDRCd(serviceEntity.getCDRCd());
				entityBean.setCountry(serviceEntity.getCountry());
				String countryCode = cashPoolObj.getCountry();
				if(countryCode==null || countryCode.equals("") || countryCode.equals(ICFPConstants.ZERO))
				{
					request.getSession().setAttribute(CPALegAction.COUNTRY_LABEL, "--");
				}else
				{
					request.getSession().setAttribute(CPALegAction.COUNTRY_LABEL, countryCode);
				}
				entityBean.setRegulatedEntityFlag(Boolean.parseBoolean(cashPoolObj.getRegulatedEntity()));
				entityBean.setPrincplEntityFlag(Boolean.parseBoolean(cashPoolObj.getPrincipalEntity()));
				entityBean.setMEName(cashPoolObj.getManagementEntity());
				entityBean.setLeType(serviceEntity.getCapitalIndustrial());
				entityBean.setCapitalIndustrial(serviceEntity.getCapitalIndustrial());
				if(entityBean.getCapitalIndustrial()!=null && entityBean.getCapitalIndustrial().equals(CAPITAL))
				{
					entityBean.setLeCategoryId(1);
				}else if(entityBean.getCapitalIndustrial()!=null && entityBean.getCapitalIndustrial().equals(INDUSTRIAL))
				{
					entityBean.setLeCategoryId(2);
				}else if(entityBean.getCapitalIndustrial()!=null && entityBean.getCapitalIndustrial().equals(BOTH))
				{
					entityBean.setLeCategoryId(3);
				}else{
					entityBean.setLeCategoryId(null);
				}
				
				entityBean.setBankTreasuryCd(cashPoolObj.getBankName());
				entityBean.setBusinessSegment(cashPoolObj.getBusinessSegment());
				
				DynaActionForm legReqForm = (DynaActionForm) form;
				DynaActionForm legSummaryForm = (DynaActionForm) legReqForm.get(CPASUMMARY_SMALL);
				DynaActionForm poolLeaderEntity = new DynaActionForm();
				poolLeaderEntity = (DynaActionForm) legSummaryForm.get(POOLLEADERENTITY);
		
				FormUtils.getInstance().populateForm(ENTITYFORM, poolLeaderEntity, entityBean, mapping.getModuleConfig(), this, mapping, request);
				poolLeaderEntity.set(TREASURYCODE,cashPoolObj.getTreasuryCode());
				legSummaryForm.set(REGION, cashPoolObj.getRegion());
				legSummaryForm.set(COUNTRY, cashPoolObj.getCountry());
				legSummaryForm.set(CURRENCYCD, cashPoolObj.getCurrency());
				legSummaryForm.set(CPALegAction.BNK_NAME, cashPoolObj.getBankName());
				request.setAttribute(CPALegAction.SELECTED_CASH_POOL, cashPoolObj);
				
				request.getSession().setAttribute(CPALegAction.CASH_POOL_SESSION, null);
		
			}else{
				
				DynaActionForm legReqForm = (DynaActionForm) form;
				DynaActionForm legSummaryForm = (DynaActionForm) legReqForm.get(CPASUMMARY_SMALL);
				DynaActionForm poolLeaderEntity = new DynaActionForm();
				poolLeaderEntity = (DynaActionForm) legSummaryForm.get(POOLLEADERENTITY);
				
				FormUtils.getInstance().populateForm(ENTITYFORM, poolLeaderEntity, entityBean, mapping.getModuleConfig(), this, mapping, request);
				
			}
			DynaActionForm legReqForm = (DynaActionForm) form;
			String legNumber = (String)legReqForm.get(LEGNUMBER);
			request.setAttribute(ACTIONID, 1);
			request.setAttribute(LEGNUMBER, legNumber);
			
			return mapping.findForward(ADDREQUEST);
	   }
	
	/**
	 * Method to CDR CODE, CAPITAL OR INDUSTRIAL VALUES BASED ON GOLD ID
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public Entity getCDRCapitalValues(CashPool cashPoolObj)throws Exception {
		
		// This service call is to get CDR Code and capital or industrial
		// based on LE GOLD ID
		String leGoldID = cashPoolObj.getLEGoldID();
		Entity serviceEntity= new Entity();
		
		if(leGoldID!=null && !StringUtils.isEmpty(leGoldID)){
			
			serviceEntity.setLEGoldId(cashPoolObj.getLEGoldID());
			MsgHeader msgHeader = new MsgHeader();
			msgHeader.setOpcode(GETGOLDINFO);
			MDM mdmObject = new MDM();
			mdmObject.setMsgHeader(msgHeader);
			List<Entity> entityLst = new ArrayList<Entity>();
			entityLst.add(serviceEntity);
			mdmObject.setEntities(entityLst);
			mdmObject = serviceClient.invokeService(MDM, mdmObject,MDM.class);
			if(mdmObject!=null){

				if(mdmObject.getEntities().size()!=0){
					serviceEntity = mdmObject.getEntities().get(0);
				}

			}
		}
		
		return serviceEntity;
	}
	
	/**
	 * Returns ME for the given goldID and matching ME letter
	 * 
	 * @param meName
	 * @param leGoldID
	 * @return
	 * @throws HWFServiceException
	 * @throws HWFStubException
	 */
	public List<Entity> getME(String meName,String leGoldID ) throws HWFServiceException, HWFStubException{
		
		MsgHeader header = new MsgHeader();
		
		if( StringUtils.isEmpty(meName) 
				&& StringUtils.isEmpty(leGoldID) ){
			header.setOpcode(DISTINCTME);
		}else{
			header.setOpcode(GETME);
		}
		
		Entity en = new Entity();
		en.setLEGoldId( leGoldID );
		en.setMEName( meName );
		
		
		MDM mdm = new MDM();
		mdm.getEntities().add(en);
		mdm.setMsgHeader(header);
		mdm = serviceClient.invokeService(MDM, mdm, MDM.class);
		
		return mdm.getEntities();
		
		
	}	
	
	
}
