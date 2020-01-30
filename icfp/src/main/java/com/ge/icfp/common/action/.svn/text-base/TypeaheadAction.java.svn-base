/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: TypeaheadAction.java
 * Purpose: Handle typeahead request and response for UI 
 */
package com.ge.icfp.common.action;

import static com.ge.icfp.common.constants.ICFPConstants.BANKTREASURYCD;
import static com.ge.icfp.common.constants.ICFPConstants.CDR;
import static com.ge.icfp.common.constants.ICFPConstants.CPALEGREQUESTFORM;
import static com.ge.icfp.common.constants.ICFPConstants.CPASUMMARY_SMALL;
import static com.ge.icfp.common.constants.ICFPConstants.DISTINCTME;
import static com.ge.icfp.common.constants.ICFPConstants.GETGOLDINFO;
import static com.ge.icfp.common.constants.ICFPConstants.GETME;
import static com.ge.icfp.common.constants.ICFPConstants.MDM;
import static com.ge.icfp.common.constants.ICFPConstants.ME;
import static com.ge.icfp.common.constants.ICFPConstants.PARTICIPANTENTITY;
import static com.ge.icfp.common.constants.ICFPConstants.PARTICIPANTTCODEENTITIES;
import static com.ge.icfp.common.constants.ICFPConstants.TCODE;
import static com.ge.icfp.common.constants.ICFPConstants.TCODELEME;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.actions.DispatchAction;

import com.ge.icfp.action.ICFPException;
import com.ge.icfp.common.constants.ICFPConstants;
import com.ge.icfp.model.Entity;
import com.ge.icfp.model.MDM;
import com.ge.icfp.model.MDM.Pagination;
import com.ge.icfp.model.MgmtEntity;
import com.ge.icfp.model.MsgHeader;
import com.hydus.wff.common.bw.ServiceClient;
import com.hydus.wff.core.context.UserContext;
import com.hydus.wff.core.exception.HWFServiceException;
import com.hydus.wff.core.exception.HWFStubException;
/**
 * Action class for handling autocomplete AJAX request
 * and return response in format <code> ["value1", "value2",....] </code>
 * 
 * @author prithivi.dhamotharan
 *
 */
public class TypeaheadAction extends DispatchAction {
	private static final String L_ERESULTS = "LEresults";
	private static final String FOR = "for";
	private static final String ERROR_WRITING_INTO_HTTP_RESPONSE = "Error writing into HTTP Response";
	private static final String TEXT_STRING = "text/string";
	private static final String GETBUSINESSSEGMENT = "GETBUSINESSSEGMENT";
	private static final String M_ERESULTS = "MEresults";
	private static final String RESULTS = "results";
	private static final String BS2 = "BS";
	private static final String LE2 = "LE";
	private static final String Q = "q";
	private static final String T_RESULTS = "TCODEResults";

	/**
	 * LOGGER
	 */
	private static final Logger LOGGER = Logger.getLogger(TypeaheadAction.class);
	/**
	 * client
	 */
	private ServiceClient client = null;
	
	/**
	 * 
	 * Request to retrieve Management Entities based on Legal Entity 
	 * and typed in query 
	 * @throws HWFServiceException 
	 * @throws HWFStubException 
	 * 
	 */
	public ActionForward getME(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response ) throws HWFServiceException, HWFStubException{
		
		String query = request.getParameter(Q);
		String le = request.getParameter(LE2);
		String bs = request.getParameter(BS2);
		String leGoldID = request.getParameter(ICFPConstants.LE_GOLD_ID);
		
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
		
		
		MsgHeader header = getMsgHeader();
		
		if((le==null || StringUtils.isBlank(le)) && (leGoldID!=null && StringUtils.isNotBlank(leGoldID)))
		{
			le=leGoldID;
		}
		
		if(query!=null && query.equals(ICFPConstants.UNDEFINED))
		{
			query=null;
		}
		if(le!=null && le.equals(ICFPConstants.UNDEFINED))
		{
			le=null;
		}
		if(bs!=null && bs.equals(ICFPConstants.UNDEFINED))
		{
			bs=null;
		}
		/**
		 * As per BW team DISTINCTME service need to be called only when le_gold_id is empty
		 */
		if( StringUtils.isEmpty(le) ){
			header.setOpcode(DISTINCTME);
		}else{
			
			header.setOpcode(GETME);
		}
		
		Entity en = new Entity();
		en.setLEGoldId( le );
		en.setMEName( query );
		en.setBusinessSegment(bs);
		
		MDM mdm = new MDM();
		mdm.getEntities().add(en);
		mdm.setMsgHeader(header);
		mdm.setPagination(pagination);
		mdm = client.invokeService(MDM, mdm, MDM.class);
		
		request.setAttribute(RESULTS, mdm.getEntities() );
		
		int recordCount = mdm.getRecordCount();
		request.setAttribute(ICFPConstants.ME_PREV_NUM, pageNumberInt);
		if(recordCount >= ICFPConstants.THREE_HUNDRED){
			pageNumberInt = pageNumberInt+ICFPConstants.THREE_HUNDRED;
			request.setAttribute(ICFPConstants.ME_NEXT_NUM, pageNumberInt);
		}
		request.setAttribute(ICFPConstants.ME_RECORD_COUNT, mdm.getRecordCount());
		request.setAttribute(ICFPConstants.VALID_RECORD_COUNT, mdm.getValidRecordCount());
		request.setAttribute(ICFPConstants.LE_GOLD_ID, le);
		
		return mapping.findForward(M_ERESULTS);		
	}	
	
	/**
	 *  Request to retrieve business segment from ME.
	 * @throws ICFPException 
	 */
	public ActionForward  getBS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response ) throws HWFServiceException, HWFStubException, ICFPException{
		
		String me = request.getParameter(ME);
		
		MsgHeader header = getMsgHeader();
		header.setOpcode( GETBUSINESSSEGMENT );
		
		MgmtEntity meEnt  = new MgmtEntity();
		meEnt.setName(me);
		
		MDM mdm = new MDM();
		mdm.getMgmtEntities().add( meEnt );
		mdm.setMsgHeader(header);
		mdm = client.invokeService(MDM, mdm, MDM.class);
		
		String out = mdm.getEntities().get(0).getBusinessSegment();
		response.setContentType(TEXT_STRING);
		
		try {
			response.getWriter().write(out);
		} catch (IOException e) {
			LOGGER.error(ERROR_WRITING_INTO_HTTP_RESPONSE + out);
			throw new ICFPException("",ERROR_WRITING_INTO_HTTP_RESPONSE, e);
		}
		
		return null;		
	}
	
	/**
	 * 
	 * Request to retrieve Legal Entity for typed in query
	 * @throws HWFServiceException 
	 * @throws HWFStubException 
	 */
	public ActionForward getLE(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response ) throws HWFServiceException, HWFStubException{
		
		String query = request.getParameter(Q);
		String which = request.getParameter(FOR);
		String forType = request.getParameter(ICFPConstants.FOR_TYPE);
		if(forType!=null && StringUtils.isNotBlank(forType))
		{
			which = forType;
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
		
		MsgHeader header = getMsgHeader();
		header.setOpcode(GETGOLDINFO);
		
		Entity en = new Entity();
		
		if(CDR.equals(which)){
			en.setCDRCd( query );
		}else{
			en.setLEGoldId( query );
		}
		
		MDM mdm = new MDM();
		mdm.getEntities().add(en);
		mdm.setMsgHeader(header);
		mdm.setPagination(pagination);
		mdm = client.invokeService(MDM, mdm, MDM.class);
		
		int recordCount = mdm.getRecordCount();
		request.setAttribute(ICFPConstants.LE_PREV_NUM, pageNumberInt);
		if(recordCount >= ICFPConstants.THREE_HUNDRED){
			pageNumberInt = pageNumberInt+ICFPConstants.THREE_HUNDRED;
			request.setAttribute(ICFPConstants.LE_NEXT_NUM, pageNumberInt);
		}
		request.setAttribute(ICFPConstants.LE_RECORD_COUNT, mdm.getRecordCount());
		request.setAttribute(ICFPConstants.VALID_RECORD_COUNT, mdm.getValidRecordCount());
		request.setAttribute(ICFPConstants.FOR_TYPE, which);
		request.setAttribute(ICFPConstants.QUERY, query);
		
		
		request.setAttribute(RESULTS, mdm.getEntities() );
		return mapping.findForward(L_ERESULTS);
	}
	
	/**
	 * Handles request for retrieving TCode based on Legal entity and management entity
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HWFServiceException 
	 * @throws HWFStubException 
	 * @throws ICFPException 
	 */
	public ActionForward getTCode(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response ) throws HWFServiceException, HWFStubException, ICFPException{
		
		String le = request.getParameter(LE2);
		String tc = request.getParameter(TCODE);
		
		MsgHeader header = getMsgHeader();
		header.setOpcode(TCODELEME);
		
		List<String> tCodes = new ArrayList<String>();
		tCodes.add(tc);
		
		Entity en = new Entity();
		en.setLEGoldId( le );
		en.setTreasuryCodes( tCodes );
		
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
		
		MDM mdm = new MDM();
		mdm.getEntities().add(en);
		mdm.setMsgHeader(header);
		mdm.setPagination(pagination);
		mdm = client.invokeService(MDM, mdm, MDM.class);
		Entity entity = mdm.getEntities().get(0);
				
		request.setAttribute(RESULTS, entity.getBankInformations() );
		
		int recordCount = mdm.getRecordCount();
		request.setAttribute(ICFPConstants.TC_PREV_NUM, pageNumberInt);
		if(recordCount >= ICFPConstants.THREE_HUNDRED){
			pageNumberInt = pageNumberInt+ICFPConstants.THREE_HUNDRED;
			request.setAttribute(ICFPConstants.TC_NEXT_NUM, pageNumberInt);
		}
		request.setAttribute(ICFPConstants.TC_RECORD_COUNT, mdm.getRecordCount());
		request.setAttribute(ICFPConstants.VALID_RECORD_COUNT, mdm.getValidRecordCount());
		request.setAttribute(ICFPConstants.TC_LE_GOLD_ID, le);
		request.setAttribute(ICFPConstants.TCODE_SMALL, tc);
				
		return mapping.findForward(T_RESULTS);
	}

   /**
	* Clear Previous TCODE's for CPA
	*
	*/
	public ActionForward clearCPATCode(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response ){

		HttpSession session = request.getSession(false);		
		DynaActionForm dynaForm = (DynaActionForm)session.getAttribute(CPALEGREQUESTFORM);		
		DynaActionForm cpaSummary = (DynaActionForm)dynaForm.get(CPASUMMARY_SMALL);
		cpaSummary.set(PARTICIPANTTCODEENTITIES, new String[0]);
		
		DynaActionForm pEntity = (DynaActionForm) cpaSummary.get(PARTICIPANTENTITY);
		pEntity.set(BANKTREASURYCD, "");
		
		return null;
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

	public ServiceClient getServiceClient() {
		return client;
	}

	public void setServiceClient(ServiceClient client) {
		this.client = client;
	}
}
