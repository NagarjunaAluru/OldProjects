/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: DerivativeAction.java
 * Purpose: DerivativeAction used for adding,deleting,updating leg details
 */

package com.ge.icfp.newrequest.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import com.ge.icfp.action.ICFPBaseAction;
import com.ge.icfp.common.constants.ICFPConstants;
import com.ge.icfp.common.helper.CurrentDealManager;
import com.ge.icfp.common.helper.ICFPCommonHelper;
import com.ge.icfp.common.helper.ICFPLegHelper;
import com.ge.icfp.model.DerivativesRequest;
import com.ge.icfp.model.DerivativesRequest.CounterPartyInfo;
import com.ge.icfp.model.Entity;
import com.ge.icfp.model.MDM;
import com.ge.icfp.model.MsgHeader;
import com.ge.icfp.util.MasterDataFactory;
import com.hydus.wff.common.bw.ServiceClient;
import com.hydus.wff.core.context.UserContext;
import com.hydus.wff.core.exception.HWFServiceException;
import com.hydus.wff.core.exception.HWFStubException;

import formdef.plugin.FormMapping;
import formdef.plugin.util.FormUtils;
import static com.ge.icfp.common.constants.ICFPConstants.*;
/**
 * 
 * @author madhusudhan.gosula
 *
 */
public class DerivativeAction extends ICFPBaseAction {
	private static final String LE_GOLD_ID_VAL = "leGoldIdVal";
	private static final String MANAGEMENT_ENTITY_DATA = "managementEntityData";
	private static final String COUNTER_PARTY_NUMBER = "counterPartyNumber";
	private static final String GOLD_OR_CDR_DETAILS = "goldORCdrDetails";
	private static final String GOLD_VALUE_DATA = "goldValueData";
	private static final String SECOND_CURRENCY_INDEX_TERM_MAP = "secondCurrencyIndexTermMap";
	private static final String FIRST_CURRENCY_INDEX_TERM_MAP = "firstCurrencyIndexTermMap";
	private static final String COUNTER_PARTY1 = "counterParty1";
	private static final String DERIATIVES_CATEGORY_ID = "deriativesCategoryId";
	private static final String OPEN_DERIVATIVE_VIEW = "openDerivativeView";
	private static final String MODIFY_DERIVATIVE = "modifyDerivative";
	private static final String CURRENCY2_NAME = "currency2Name";
	private static final String CURRENCY1_NAME = "currency1Name";
	private static final String INTERNAL_OR_EXTERNAL = "internalOrExternal";
	private static final String FIXED_OR_FLOAT2 = "fixedOrFloat2";
	private static final String FIXED_OR_FLOAT1 = "fixedOrFloat1";
	private static final String COUNTER_PARTY_INFOS = "counterPartyInfos";
	private static final String DERIVATIVES_REQUEST_FORM = "derivativesRequestForm";
	private static final String VIEW = "view";
	private static final String VIEWDERIVATIVE = "viewDerivative";
	/**
	 * serviceClient
	 */
	private ServiceClient serviceClient;
	
	/**
	 * Method is used to add a derivative to the current leg
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward addDerivative(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer legNumber = (Integer) request.getAttribute(LEGNUMBER);
		if(legNumber == null) {
			legNumber = Integer.valueOf(request.getParameter(LEGNUMBER));
		}
		Object leg = CurrentDealManager.getLegByNumber(Integer.valueOf(legNumber), request);
		List<DerivativesRequest> derivatives = ICFPLegHelper.getDerivatives(leg);
		DerivativesRequest derivativeRequest = new DerivativesRequest();
		derivatives.add(derivativeRequest);
		int derivativeNumber = derivatives.indexOf(derivativeRequest) + 1;
	
		request.setAttribute(LEGNUMBER, String.valueOf(legNumber));
		request.setAttribute(DERIVATIVENUMBER, String.valueOf(derivativeNumber));
		String addOrModifyFlag = (String) request.getSession().getAttribute(ADDORMODIFYFLAG);
		request.getSession().setAttribute(ADDORMODIFYFLAG, addOrModifyFlag);
		
		String redirectPath = new StringBuilder().append(mapping.findForward("openDerivative").getPath())
				.append(LEGNUMBER_STRING).append(legNumber).toString();
		redirectPath=redirectPath+"&"+DERIVATIVENUMBER+"="+derivativeNumber;
		return new ActionForward(response.encodeRedirectURL(redirectPath), true);		
	}	
	
	/**
	 * Method to open the derivative from the existing leg
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward openDerivative(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
		DynaActionForm derivativeForm = (DynaActionForm) form;
		String legNumber = request.getParameter(LEGNUMBER);
		if(legNumber == null) {
			legNumber = (String) request.getAttribute(LEGNUMBER);
		}
		String derivativeNumber = request.getParameter(DERIVATIVENUMBER);
		
		String addDerivativeNumber = (String)request.getAttribute(DERIVATIVENUMBER);
		
		if(addDerivativeNumber!=null && !StringUtils.isEmpty(addDerivativeNumber))
		{
			derivativeNumber = addDerivativeNumber;
		}
		
		DerivativesRequest derivative = CurrentDealManager.getDerivative(Integer.valueOf(legNumber), Integer.valueOf(derivativeNumber), request);
		List<CounterPartyInfo> counterPartyInfos = derivative.getCounterPartyInfos();
		if(counterPartyInfos.size() < 2) {
			for(int i=counterPartyInfos.size(); i < 2; i++) {
				CounterPartyInfo cInfo = new CounterPartyInfo();
				cInfo.setEntity(new Entity());
				counterPartyInfos.add(cInfo);
			}
		} 
		
		FormUtils.getInstance().populateForm(DerivativeAction.DERIVATIVES_REQUEST_FORM, form, derivative, mapping.getModuleConfig(), this, mapping, request);
		derivativeForm.set(DerivativeAction.COUNTER_PARTY_INFOS, counterPartyInfos);
		derivativeForm.set(LEGNUMBER, legNumber);
		derivativeForm.set(DERIVATIVENUMBER, derivativeNumber);
		
		CounterPartyInfo counterPartyInfo = counterPartyInfos.get(0); 
		if(((Object)counterPartyInfo.getFixedRateValue())!=null){
			derivativeForm.set(DerivativeAction.FIXED_OR_FLOAT1,Y_CAP);
		}else if(counterPartyInfo.getIndex()!=null){
			derivativeForm.set(DerivativeAction.FIXED_OR_FLOAT1,N_CAP);
		}
		CounterPartyInfo counterPartyInfo1 = counterPartyInfos.get(1); 
		if(((Object)counterPartyInfo1.getFixedRateValue())!=null){
			derivativeForm.set(DerivativeAction.FIXED_OR_FLOAT2,Y_CAP);
		}else if(counterPartyInfo1.getIndex()!=null){
			derivativeForm.set(DerivativeAction.FIXED_OR_FLOAT2,N_CAP);
		}
		
		if(derivative.getDeriativesCategoryId() != null && derivative.getDeriativesCategoryId()==1){
			derivativeForm.set(DerivativeAction.INTERNAL_OR_EXTERNAL,Y_CAP);
		}
		if(derivative.getDeriativesCategoryId() != null && derivative.getDeriativesCategoryId()==2){
			derivativeForm.set(DerivativeAction.INTERNAL_OR_EXTERNAL,N_CAP);
		}
		
		String currency1Name = ICFPCommonHelper.getCurrencyNameById(counterPartyInfo.getCurrencyPair(), request);
		String currency2Name = ICFPCommonHelper.getCurrencyNameById(counterPartyInfo1.getCurrencyPair(), request);
		if(counterPartyInfo.getCurrencyPair() != null){
			derivativeForm.set(DerivativeAction.CURRENCY1_NAME, counterPartyInfo.getCurrencyPair()+'-'+currency1Name);
		}else{
			derivativeForm.set(DerivativeAction.CURRENCY1_NAME, "");
		}
		if(counterPartyInfo1.getCurrencyPair() != null){
			derivativeForm.set(DerivativeAction.CURRENCY2_NAME, counterPartyInfo1.getCurrencyPair()+'-'+currency2Name);
		}else{
			derivativeForm.set(DerivativeAction.CURRENCY2_NAME,"");
		}
		String mode = request.getParameter(DerivativeAction.MODIFY_DERIVATIVE);
		if(mode != null && mode.equals(TRUE_SMALL)) {
			request.getSession().setAttribute(ADDORMODIFYDERIVATIVE, MODIFY);
		}
		String addOrModifyFlag = (String) request.getSession().getAttribute(ADDORMODIFYFLAG);
		request.getSession().setAttribute(ADDORMODIFYFLAG, addOrModifyFlag);
		
		String viewMode = request.getParameter(DerivativeAction.VIEW);
		request.setAttribute(DERIVATIVESEQID, derivative.getDeriativesSeqId());
		request.setAttribute(LEGNUMBER, legNumber);
		String actionId = request.getParameter(ACTIONID);
		
		if(viewMode!=null && viewMode.equals(TRUE_SMALL)){
			
			// This derivativeViewFlag will be true while comming from USERS who 
			// are after S&O levels.
			String derivativeViewFlag = request.getParameter("derivativeViewFlag");  
			if(derivativeViewFlag!=null && derivativeViewFlag.equals("true"))
			{
				request.setAttribute(ACTIONID, 9999);	
			}else{
				request.setAttribute(ACTIONID, actionId);
			}
			request.setAttribute(VIEWDERIVATIVE, YES);
			return mapping.findForward(DerivativeAction.VIEWDERIVATIVE);
		}else{		
			if(actionId!=null){
				request.setAttribute(ACTIONID, actionId);
			}
			return mapping.findForward(DerivativeAction.OPEN_DERIVATIVE_VIEW);
		}
	}
	
	/**
	 * Method to cancel the modifications of current derivative
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward cancelDerivative(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		DynaActionForm derivativeRequestForm = (DynaActionForm) form;
		Integer legNumber = Integer.valueOf(derivativeRequestForm.getString(LEGNUMBER));
		Integer derivativeNumber = Integer.valueOf(derivativeRequestForm.getString(DERIVATIVENUMBER));
		
		String viewDerivative = request.getParameter(DERIVATIVETYPE);
		
		if(viewDerivative!=null && StringUtils.isNotBlank(viewDerivative)){
			request.setAttribute(LEGNUMBER, legNumber);
			return mapping.findForward(VIEWLEG);
		}
		
		
		DerivativesRequest derivativeRequest = CurrentDealManager.getDerivative(legNumber, derivativeNumber, request);
		if(derivativeRequest.getDeriativesSeqId() == null && derivativeRequest.getDerivativesOpcode() == null) {
			CurrentDealManager.getAllDerivatives(legNumber, request).remove(derivativeRequest);
		}
		request.setAttribute(LEGNUMBER,legNumber);
		request.getSession().removeAttribute(ADDORMODIFYDERIVATIVE);
		return mapping.findForward(OPENLEG);
	}
	
	/**
	 * Method to save the derivative to the existing leg
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward saveDerivative(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws Exception {
		DynaActionForm derivativeRequestForm = (DynaActionForm) form;
		prepareToSave(derivativeRequestForm);
		Integer legNumber = Integer.valueOf(derivativeRequestForm.getString(LEGNUMBER));
		Integer derivativeNumber = Integer.valueOf(derivativeRequestForm.getString(DERIVATIVENUMBER));
		if(legNumber!=null && derivativeNumber != null){
			syncBeanWithForm(legNumber, derivativeNumber, mapping, derivativeRequestForm, request);
		}
		derivativeRequestForm.getMap().get("");
		request.setAttribute(ADDORMODIFYFLAG, "add");
		request.setAttribute(REMOVECURRENT, NO);	

		request.setAttribute(LEGNUMBER,legNumber);
		request.getSession().removeAttribute(ADDORMODIFYDERIVATIVE);
		String actionId = request.getParameter(ICFPConstants.ACTIONID);
		if(actionId!=null && actionId.equals(ICFPConstants.TWO))
		{
			return mapping.findForward(VIEWLEG);
		}
		return mapping.findForward(OPENLEG);
	}
	
	
	
	/**
	 * Method to save the derivative and open the new derivative 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward saveAndNewDerivative(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws Exception {
		DynaActionForm derivativeRequestForm = (DynaActionForm) form;
		prepareToSave(derivativeRequestForm);
		String legNumber = derivativeRequestForm.getString(LEGNUMBER);
		String derivativeNumber = derivativeRequestForm.getString(DERIVATIVENUMBER);
		if(legNumber!=null && derivativeNumber != null){
			syncBeanWithForm(Integer.valueOf(legNumber), Integer.valueOf(derivativeNumber), mapping, derivativeRequestForm, request);
		}
		request.getSession().removeAttribute(ADDORMODIFYDERIVATIVE);
		return addDerivative(mapping, derivativeRequestForm, request, response);
	}
	
	/**
	 * Method to delete the derivative
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HWFStubException 
	 * @throws HWFServiceException 
	 */
	public ActionForward deleteDerivative(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws HWFServiceException, HWFStubException {
		Integer legNumber = (Integer) request.getAttribute(LEGNUMBER); 
		if(legNumber == null) {
			legNumber = Integer.valueOf(request.getParameter(LEGNUMBER));
		}
		Integer derivativeNumber = (Integer) request.getAttribute(DERIVATIVENUMBER); 
		if(derivativeNumber == null ) {
			String derNbrStr = request.getParameter(DERIVATIVENUMBER);
			if(derNbrStr!=null &&  StringUtils.isNotBlank(derNbrStr) && !derNbrStr.equals(NULL))
			{
				derivativeNumber = Integer.valueOf(request.getParameter(DERIVATIVENUMBER));	
			}
			 
		}
		DerivativesRequest derivativeToDelete = CurrentDealManager.getDerivative(legNumber, derivativeNumber, request);
		if(derivativeToDelete != null) {
			if(derivativeToDelete.getDeriativesSeqId() != null) {
				derivativeToDelete.setDerivativesOpcode(DELETE);
			} else {
				List<DerivativesRequest> derivativeList = CurrentDealManager.getAllDerivatives(legNumber, request);
				derivativeList.remove(derivativeToDelete);
			}
		}
		request.setAttribute(LEGNUMBER, legNumber);
		
		String actionId = request.getParameter(ACTIONID);
		if(actionId!=null && actionId.equals(ICFPConstants.TWO)){
			return mapping.findForward(VIEWLEG);
		}
		
		return mapping.findForward(OPENLEG);
	}
	
	/**
	 * Method to synchronize the Bean with the Form bean
	 * @param legNumber
	 * @param derivativeNumber
	 * @param mapping
	 * @param form
	 * @param request
	 */
	@SuppressWarnings("unchecked")
	private void syncBeanWithForm(int legNumber, int derivativeNumber, ActionMapping mapping, DynaActionForm form, HttpServletRequest request) {
		DerivativesRequest derivativeToUpdate = CurrentDealManager.getDerivative(Integer.valueOf(legNumber), Integer.valueOf(derivativeNumber), request);
		FormMapping formMapping = FormUtils.getInstance().findFormDefinition(DerivativeAction.DERIVATIVES_REQUEST_FORM, getServlet().getServletContext(), mapping.getModuleConfig());
		FormUtils.getInstance().populateBeanFromForm(formMapping, derivativeToUpdate, form, this, mapping, request);
		List<CounterPartyInfo> counterPartyInfos =  (List<CounterPartyInfo>) form.get(DerivativeAction.COUNTER_PARTY_INFOS);
		clearEmptyCounterPatryInfo(counterPartyInfos);
		//derivativeToUpdate.setCounterPartyInfos(counterPartyInfos);
		if(derivativeToUpdate.getDeriativesSeqId() == null && (derivativeToUpdate.getDerivativesOpcode()==null || StringUtils.isEmpty(derivativeToUpdate.getDerivativesOpcode()))) {
			derivativeToUpdate.setDerivativesOpcode(INSERT);
		} else if(derivativeToUpdate.getDeriativesSeqId() != null && "".equals(derivativeToUpdate.getDerivativesOpcode())) {
			derivativeToUpdate.setDerivativesOpcode(UPDATE);
		} else if(derivativeToUpdate.getDeriativesSeqId() != null && !"".equals(derivativeToUpdate.getDerivativesOpcode())) {
			derivativeToUpdate.setDerivativesOpcode(UPDATE);
		}
		else{
			derivativeToUpdate.setDerivativesOpcode(INSERT);
		}
	}
	/**
	 * 
	 * @param counterPartyInfos
	 */
	private void clearEmptyCounterPatryInfo(
			List<CounterPartyInfo> counterPartyInfos) {
		if (counterPartyInfos.get(0).getInterestResetFreqId() != null
				&& counterPartyInfos.get(0).getInterestResetFreqId().intValue() == 0) {
			counterPartyInfos.get(0).setInterestResetFreqId(null);
		}
		if (counterPartyInfos.get(1).getInterestResetFreqId() != null
				&& counterPartyInfos.get(1).getInterestResetFreqId().intValue() == 0) {
			counterPartyInfos.get(1).setInterestResetFreqId(null);
		}
		if (counterPartyInfos.get(0).getFixedRateValue() != null
				&& counterPartyInfos.get(0).getFixedRateValue().intValue() == 0) {
			counterPartyInfos.get(0).setFixedRateValue(null);
		}
		if (counterPartyInfos.get(1).getFixedRateValue() != null
				&& counterPartyInfos.get(1).getFixedRateValue().intValue() == 0) {
			counterPartyInfos.get(1).setFixedRateValue(null);
		}
		if (counterPartyInfos.get(0).getDayCountId() != null
				&& counterPartyInfos.get(0).getDayCountId().intValue() == 0) {
			counterPartyInfos.get(0).setDayCountId(null);
		}
		if (counterPartyInfos.get(1).getDayCountId() != null
				&& counterPartyInfos.get(1).getDayCountId().intValue() == 0) {
			counterPartyInfos.get(1).setDayCountId(null);
		}
		
	}

	/**
	 * Method to set the parameter to form before saving the derivative 
	 * @param form
	 */
	private void prepareToSave(DynaActionForm form) {
		String internalOrExternal = form.getString(DerivativeAction.INTERNAL_OR_EXTERNAL);
		if(internalOrExternal.equalsIgnoreCase(ICFPConstants.Y_CAP)){
			form.set(DerivativeAction.DERIATIVES_CATEGORY_ID,ONE);
		}else{
			form.set(DerivativeAction.DERIATIVES_CATEGORY_ID,TWO);
		}
		@SuppressWarnings("unchecked")
		List<CounterPartyInfo> list =  (List<CounterPartyInfo>) form.get(DerivativeAction.COUNTER_PARTY_INFOS);
		if(list.get(0).getCurrencyPair()!=null){
			String tempCurrnecy[] = list.get(0).getCurrencyPair().split("-");
			list.get(0).setCurrencyPair(tempCurrnecy[0]);
		}
		if(list.get(1).getCurrencyPair()!=null){
			String tempCurrnecy[] = list.get(1).getCurrencyPair().split("-");
			list.get(1).setCurrencyPair(tempCurrnecy[0]);
		}		
		String fixedOrFloat1 = (String) form.getString(DerivativeAction.FIXED_OR_FLOAT1);
		if(fixedOrFloat1.equalsIgnoreCase(Y_CAP)){
			list.get(0).setInterestTypeId(1);
		}
		if(fixedOrFloat1.equalsIgnoreCase(N_CAP)){
			list.get(0).setInterestTypeId(2);
		}
		String fixedOrFloat2 = (String) form.getString(DerivativeAction.FIXED_OR_FLOAT2);
		if(fixedOrFloat2.equalsIgnoreCase(Y_CAP)){
			list.get(1).setInterestTypeId(1);
		}
		if(fixedOrFloat2.equalsIgnoreCase(N_CAP)){
			list.get(1).setInterestTypeId(2);
		}
	}
	
	/**
	 * Method to redirect to current leg
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward redirectAddLeg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Integer legNumber = (Integer) request.getAttribute(LEGNUMBER); 
		if(legNumber == null) {
			legNumber = Integer.valueOf(request.getParameter(LEGNUMBER));
		}
		Integer derivativeNumber = (Integer) request.getAttribute(DERIVATIVENUMBER); 
		if(derivativeNumber == null) {
			derivativeNumber = Integer.valueOf(request.getParameter(DERIVATIVENUMBER)); 
		}
		DerivativesRequest derivativeToDelete = CurrentDealManager.getDerivative(legNumber, derivativeNumber, request);
		if(derivativeToDelete != null) {
			if(derivativeToDelete.getDeriativesSeqId() == null) {
				List<DerivativesRequest> derivativeList = CurrentDealManager.getAllDerivatives(legNumber, request);
				derivativeList.remove(derivativeToDelete);
			}
		}
		request.setAttribute(LEGNUMBER, legNumber);
		return mapping.findForward(OPENLEG);	
	}	
	
	/**
	 * 
	 */
	public ActionForward getIndexTermData(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws HWFServiceException, HWFStubException {

		String floatRateIndexVal = (String)request.getParameter(FLOATINGRATEINDEX);
		String counterParty = (String)request.getParameter("counterParty");
		Map<String,String> indexTermMap = new HashMap<String, String>();
		
		if(floatRateIndexVal!=null && !floatRateIndexVal.equals(""))
		{
			MasterDataFactory mdmDataFactoryObj = (MasterDataFactory) getServlet().getServletContext().getAttribute(MasterDataFactory.CTX_KEY);
			indexTermMap = mdmDataFactoryObj.getIndexTerm(floatRateIndexVal,serviceClient);
		}
		
		if(!StringUtils.isEmpty(counterParty) && counterParty.equals(DerivativeAction.COUNTER_PARTY1)){
			((DynaActionForm)form).set(DerivativeAction.FIRST_CURRENCY_INDEX_TERM_MAP, indexTermMap);	
		}else{
			((DynaActionForm)form).set(DerivativeAction.SECOND_CURRENCY_INDEX_TERM_MAP, indexTermMap);	
		}
	    
	    return mapping.findForward(DerivativeAction.OPEN_DERIVATIVE_VIEW);
	}
	
	/**
	 * 
	 * Request to retrieve Legal Entity for typed in query
	 * @throws HWFServiceException 
	 * @throws HWFStubException 
	 */
	public ActionForward getCountPartyLenderDetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response ) throws HWFServiceException, HWFStubException{
		
		String goldTextBoxValue = request.getParameter(DerivativeAction.GOLD_VALUE_DATA);
		String goldORCdrDetails = request.getParameter(DerivativeAction.GOLD_OR_CDR_DETAILS);
		String counterPartNbr = request.getParameter(DerivativeAction.COUNTER_PARTY_NUMBER);
		
		MsgHeader header = getMsgHeader();
		header.setOpcode(GETGOLDINFO);
		
		Entity entity = new Entity();
		
		if(CDR.equals(goldORCdrDetails)){
			entity.setCDRCd( goldTextBoxValue );
		}else{
			entity.setLEGoldId( goldTextBoxValue );
		}
		
		MDM mdm = new MDM();
		mdm.getEntities().add(entity);
		mdm.setMsgHeader(header);
		mdm = serviceClient.invokeService(MDM, mdm, MDM.class);
		
		DynaActionForm derivativesRequestForm = (DynaActionForm)form ;
		@SuppressWarnings("unchecked")
		List<CounterPartyInfo> counterPartyInfoList =  (List<CounterPartyInfo>) derivativesRequestForm.get(DerivativeAction.COUNTER_PARTY_INFOS);
		CounterPartyInfo counterPartyInfo= null;
		
		if(!StringUtils.isEmpty(counterPartNbr) && counterPartNbr.equals(ONE))
		{
			counterPartyInfo= counterPartyInfoList.get(0);
		}else{
			counterPartyInfo= counterPartyInfoList.get(1);
		}
		counterPartyInfo.setEntity(mdm.getEntities().get(0));
		return mapping.findForward(DerivativeAction.OPEN_DERIVATIVE_VIEW);
		
	}
	
	/**
	 * 
	 * Request to retrieve Management Entities based on Legal Entity 
	 * and typed in query 
	 * @throws HWFServiceException 
	 * @throws HWFStubException 
	 * 
	 */
	public ActionForward getManagementEntityDetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response ) throws HWFServiceException, HWFStubException{
		
		String counterPartNbr = request.getParameter(DerivativeAction.COUNTER_PARTY_NUMBER);
		String managementEntityData = request.getParameter(DerivativeAction.MANAGEMENT_ENTITY_DATA);
		String leGoldIdVal = request.getParameter(DerivativeAction.LE_GOLD_ID_VAL);
		
		MsgHeader header = getMsgHeader();
		
		if( StringUtils.isEmpty(managementEntityData) 
				&& StringUtils.isEmpty(leGoldIdVal) ){
			header.setOpcode(DISTINCTME);
		}else{
			header.setOpcode(GETME);
		}
		
		Entity en = new Entity();
		en.setLEGoldId( leGoldIdVal );
		en.setMEName( managementEntityData );
	
		
		MDM mdm = new MDM();
		mdm.getEntities().add(en);
		mdm.setMsgHeader(header);
		mdm = serviceClient.invokeService(MDM, mdm, MDM.class);
		
		if(mdm.getEntities()!=null && mdm.getEntities().size()>0)
		{
			DynaActionForm derivativesRequestForm = (DynaActionForm)form ;
			
			@SuppressWarnings("unchecked")
			List<CounterPartyInfo> counterPartyInfoList =  (List<CounterPartyInfo>) derivativesRequestForm.get(DerivativeAction.COUNTER_PARTY_INFOS);
			CounterPartyInfo counterPartyInfo= null;
			
			if(counterPartNbr!=null && !StringUtils.isEmpty(counterPartNbr) && counterPartNbr.equals(ONE))
			{
				counterPartyInfo= counterPartyInfoList.get(0);
			}else{
				counterPartyInfo= counterPartyInfoList.get(1);
			}
			
			if(counterPartyInfo.getEntity()!=null)
			{
				counterPartyInfo.getEntity().setMeGoldId(mdm.getEntities().get(0).getMeGoldId());
				counterPartyInfo.getEntity().setMEName(mdm.getEntities().get(0).getMeGoldId());
			}
		}
		return mapping.findForward(DerivativeAction.OPEN_DERIVATIVE_VIEW);
		
	}	
	
	/**
	 * getMsgHeader
	 * @return header MsgHeader
	 */
	private MsgHeader getMsgHeader() {
		MsgHeader header = new MsgHeader();
		header.setAuditCreator( UserContext.getCurrentUserContext().getId() );
		header.setAuditModifier( UserContext.getCurrentUserContext().getId() );
		return header;
	}
	/**
	 * getServiceClient
	 * @return
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
}
