/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: DealManager.java
 * Purpose:DealManager used for the all leg and deal operations
 */
package com.ge.icfp.tag;

import static com.ge.icfp.common.constants.ICFPConstants.DELETE;
import static com.ge.icfp.common.constants.ICFPConstants.FO_FLAG;
import static com.ge.icfp.common.constants.ICFPConstants.IMMEDIATE_DRAWDOWN;
import static com.ge.icfp.common.constants.ICFPConstants.LEGNUMBER;
import static com.ge.icfp.common.constants.ICFPConstants.MM_DD_YYYY;
import static com.ge.icfp.common.constants.ICFPConstants.NO_CAP;
import static com.ge.icfp.common.constants.ICFPConstants.ONE;
import static com.ge.icfp.common.constants.ICFPConstants.TRUE;
import static com.ge.icfp.common.constants.ICFPConstants.UPDATE;
import static com.ge.icfp.common.constants.ICFPConstants.YES_CAP;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.DynaActionForm;

import com.ge.icfp.action.ICFPException;
import com.ge.icfp.common.constants.ICFPConstants;
import com.ge.icfp.common.helper.CurrentDealManager;
import com.ge.icfp.common.helper.EntityHelper;
import com.ge.icfp.common.helper.EntityHelper.EntityType;
import com.ge.icfp.common.helper.ICFPCommonHelper;
import com.ge.icfp.common.helper.ICFPDay2LegHelper;
import com.ge.icfp.common.helper.ICFPLegHelper;
import com.ge.icfp.common.vo.CPALegSummaryVO;
import com.ge.icfp.common.vo.Day2LegSummaryVO;
import com.ge.icfp.common.vo.LegSummaryVO;
import com.ge.icfp.common.vo.RateInfoVO;
import com.ge.icfp.model.ActionLog;
import com.ge.icfp.model.Amendment;
import com.ge.icfp.model.AttachmentTypeComments;
import com.ge.icfp.model.CPALegRequest;
import com.ge.icfp.model.CPASummary;
import com.ge.icfp.model.ClosingCheckList;
import com.ge.icfp.model.DealRequest;
import com.ge.icfp.model.DerivativesRequest;
import com.ge.icfp.model.Entity;
import com.ge.icfp.model.EquityLegRequest;
import com.ge.icfp.model.ExceptionRequestForm;
import com.ge.icfp.model.LegSummary;
import com.ge.icfp.model.NameValue;
import com.ge.icfp.model.OtherLegRequest;
import com.ge.icfp.model.RCALegRequest;
import com.ge.icfp.model.RateInformation;
import com.ge.icfp.model.ShareInfo;
import com.ge.icfp.model.SolvencyMetrics;
import com.ge.icfp.model.StaticDataManagement.WFStageDetails;
import com.ge.icfp.model.TPLegRequest;
import com.ge.icfp.model.TesgList;
import com.ge.icfp.newrequest.form.vo.DerivativeDetailsVO;
import com.ge.icfp.util.ProductType;
import com.ge.icfp.util.StaticDataFactory;
import com.ge.icfp.util.Utils;
import com.hydus.wff.core.exception.HWFServiceException;
import com.hydus.wff.core.exception.HWFStubException;
import com.hydus.wff.core.session.SessionManager;
/**
 * DealManager used for the all leg and deal operations
 * @author srinivasan.desa
 *
 */
public class DealManager {
	
	private static final String LEG_TYPE_IMMEDIATE_DRAWDOWN = IMMEDIATE_DRAWDOWN;
	private static final String TESG_MEMBER_LIST = "TESGMemberList";
	
	/**
	 * fetchLegs used to retrieve legs.
	 * @param request HttpServletRequest
	 * @return legSummaryList List
	 */
	public static List<Object> fetchLegs(HttpServletRequest request) {
		List<Object> legSummaryList = new ArrayList<Object>();
		DealRequest dealRequest = CurrentDealManager.getCurrentDeal(request);
		if(dealRequest.getLegs()!=null && dealRequest.getLegs().getAllLegs()!=null){
			List<Object> legList = dealRequest.getLegs().getAllLegs();
			int count = 1;
			for(Object leg : legList) {
				String opcode = ICFPLegHelper.getOpCode(leg);
				if(opcode == null || !opcode.equals(DELETE)) {
					legSummaryList.add(fetchLegSummary(leg, count, request));
					count++;
				} 
			}
		}
		return legSummaryList;
	}
	

	/**
	 * fetchLegs used to retrieve legs.
	 * @param request HttpServletRequest
	 * @return legSummaryList List
	 */
	public static List<Object> fetchEquityLegs(HttpServletRequest request) {
		List<Object> legSummaryList = new ArrayList<Object>();
		DealRequest dealRequest = CurrentDealManager.getCurrentDeal(request);
		if(dealRequest.getLegs()!=null && dealRequest.getLegs().getAllLegs()!=null){
			List<Object> legList = dealRequest.getLegs().getAllLegs();
			int count = 1;
			for(Object leg : legList) {
				String opcode = ICFPLegHelper.getOpCode(leg);
				if(opcode == null || !opcode.equals(DELETE)) {
					if(leg instanceof EquityLegRequest){
						legSummaryList.add(fetchLegSummary(leg, count, request));
					}
					count++;
				} 
			}
		}
		return legSummaryList;
	}
	
	/**
	 * fetchLegSummary used to retrieve leg summary
	 * @param legNumber Integer
	 * @param request HttpServletRequest
	 * @return fetchLegSummary
	 */
	public static Object fetchLegSummary(Integer legNumber, HttpServletRequest request) {
		Object leg = CurrentDealManager.getLegByNumber(legNumber, request);
		return fetchLegSummary(leg, legNumber, request);
	}
	
	/**
	 * fetchLegSummary used to retrieve leg summary
	 * @param leg Object
	 * @param legNumber Integer
	 * @param request HttpServletRequest
	 * @return Object
	 */
	private static Object fetchLegSummary(Object leg, Integer legNumber, HttpServletRequest request) {
		if(leg instanceof RCALegRequest){
			RCALegRequest rcaLeg = CurrentDealManager.getLegByNumber(legNumber, RCALegRequest.class, request);
			return new LegSummaryVO(legNumber, rcaLeg.getLegSummary(), request);
		}else if(leg instanceof EquityLegRequest){
			EquityLegRequest equityLeg = CurrentDealManager.getLegByNumber(legNumber, EquityLegRequest.class, request);
			return new LegSummaryVO(legNumber, equityLeg.getLegSummary(), request);
		}else if(leg instanceof OtherLegRequest){
			OtherLegRequest otherLeg = CurrentDealManager.getLegByNumber(legNumber, OtherLegRequest.class, request);
			return new LegSummaryVO(legNumber, otherLeg.getLegSummary(), request);
		}else if(leg instanceof CPALegRequest){
			CPALegRequest cpaLeg = CurrentDealManager.getLegByNumber(legNumber, CPALegRequest.class, request);
			return new CPALegSummaryVO(legNumber, cpaLeg.getCPASummary(), cpaLeg.getComments(),cpaLeg.getRateInformation(), cpaLeg.getTransactionCapturedInId());
		}
		return null;
	}
	
	
	/**
	 * fetchLegSummary used to retrieve leg summary
	 * @param legNumber Integer
	 * @param request HttpServletRequest
	 * @return fetchLegSummary
	 */
	public static Object fetchDay2LegSummary(Integer legNumber, HttpServletRequest request) {
		Object leg = CurrentDealManager.getLegByNumber(legNumber, request);
		return fetchDay2LegSummary(leg, legNumber, request);
	}
	
	
	/**
	 * Day2LegSummaryVO used to retrieve leg summary
	 * @param leg Object
	 * @param legNumber Integer
	 * @param request HttpServletRequest
	 * @return Object
	 */
	private static Object fetchDay2LegSummary(Object leg, Integer legNumber, HttpServletRequest request) {
		if(leg instanceof RCALegRequest){
			RCALegRequest rcaLeg = CurrentDealManager.getLegByNumber(legNumber, RCALegRequest.class, request);
			return new Day2LegSummaryVO(legNumber, rcaLeg.getDayTwoOperations(), request);
		}else if(leg instanceof CPALegRequest){
			CPALegRequest cpaLeg = CurrentDealManager.getLegByNumber(legNumber, CPALegRequest.class, request);
			return new Day2LegSummaryVO(legNumber, cpaLeg.getDayTwoOperations(), request);
		}else if(leg instanceof EquityLegRequest){
			EquityLegRequest equityLeg = CurrentDealManager.getLegByNumber(legNumber, EquityLegRequest.class, request);
			return new Day2LegSummaryVO(legNumber, equityLeg.getDayTwoOperations(), request);
		}else if(leg instanceof OtherLegRequest){
			OtherLegRequest otherLeg = CurrentDealManager.getLegByNumber(legNumber, OtherLegRequest.class, request);
			return new Day2LegSummaryVO(legNumber, otherLeg.getDayTwoOperations(), request);
		}
		return null;
	}
	
	/**
	 * 
	 * @param legNumber
	 * @param request
	 * @return
	 */
	public static boolean hideLegView(Integer legNumber, HttpServletRequest request){
		Object leg = CurrentDealManager.getLegByNumber(legNumber, request);
		if(leg instanceof RCALegRequest){
			RCALegRequest rcaLeg = CurrentDealManager.getLegByNumber(legNumber, RCALegRequest.class, request);
			String flag = (String)request.getAttribute(FO_FLAG);
			if(flag!=null && StringUtils.isNotBlank(flag) && flag.equals(TRUE)){
				return getFORCAEventValue(rcaLeg);
			}else{
			    return getRCAEventValue(rcaLeg);
			}
		}else if(leg instanceof CPALegRequest){
			CPALegRequest cpaLeg = CurrentDealManager.getLegByNumber(legNumber, CPALegRequest.class, request);
			return getCPAEventValue(cpaLeg);
		}else if(leg instanceof EquityLegRequest){
			EquityLegRequest equityLeg = CurrentDealManager.getLegByNumber(legNumber, EquityLegRequest.class, request);
			return getEquityEventValue(equityLeg);
		}else if(leg instanceof OtherLegRequest){
			OtherLegRequest otherLeg = CurrentDealManager.getLegByNumber(legNumber, OtherLegRequest.class, request);
			return getOtherEventValue(otherLeg);
		}
		return false;
	}

	/**
	 * 
	 * @param otherLeg
	 * @return
	 */
	private static boolean getOtherEventValue(OtherLegRequest otherLeg) {
		if(otherLeg.getLegSummary().getTransactionEventTypeId() != null){
			if(otherLeg.getLegSummary().getTransactionEventTypeId().intValue() == 7){
				return true;
			}else if(otherLeg.getLegSummary().getTransactionEventTypeId().intValue() == 10){
				return true;
			}else if(otherLeg.getLegSummary().getTransactionEventTypeId().intValue() == 8){
				return true;
			}else if(otherLeg.getLegSummary().getTransactionEventTypeId().intValue() == 5){
				if(otherLeg.getDayTwoOperations().getFacilityIncreaseDecrease().getFacilityTypeId().intValue() == 2){
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 
	 * @param equityLeg
	 * @return
	 */
	private static boolean getEquityEventValue(EquityLegRequest equityLeg) {
		if(equityLeg.getLegSummary().getTransactionEventTypeId() != null){
			if(equityLeg.getLegSummary().getTransactionEventTypeId().intValue() == 7){
				return true;
			}else if(equityLeg.getLegSummary().getTransactionEventTypeId().intValue() == 10){
				return true;
			}else if(equityLeg.getLegSummary().getTransactionEventTypeId().intValue() == 8){
				return true;
			}else if(equityLeg.getLegSummary().getTransactionEventTypeId().intValue() == 5){
				if(equityLeg.getDayTwoOperations().getFacilityIncreaseDecrease().getFacilityTypeId().intValue() == 2){
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 
	 * @param cpaLeg
	 * @return
	 */
	private static boolean getCPAEventValue(CPALegRequest cpaLeg) {
		if(cpaLeg.getCPASummary().getTransactionEventTypeId() != null){
			if(cpaLeg.getCPASummary().getTransactionEventTypeId().intValue() == 7){
				return true;
			}else if(cpaLeg.getCPASummary().getTransactionEventTypeId().intValue() == 10){
				return true;
			}else if(cpaLeg.getCPASummary().getTransactionEventTypeId().intValue() == 8){
				return true;
			}else if(cpaLeg.getCPASummary().getTransactionEventTypeId().intValue() == 5){
				if(cpaLeg.getDayTwoOperations().getFacilityIncreaseDecrease().getFacilityTypeId().intValue() == 2){
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 
	 * @param rcaLeg
	 * @return
	 */
	private static boolean getRCAEventValue(RCALegRequest rcaLeg) {
		if(rcaLeg.getLegSummary().getTransactionEventTypeId() != null){
			if(rcaLeg.getLegSummary().getTransactionEventTypeId().intValue() == 7){
				return true;
			}else if(rcaLeg.getLegSummary().getTransactionEventTypeId().intValue() == 10){
				return true;
			}else if(rcaLeg.getLegSummary().getTransactionEventTypeId().intValue() == 8){
				return true;
			}else if(rcaLeg.getLegSummary().getTransactionEventTypeId().intValue() == 5){
				if(rcaLeg.getDayTwoOperations().getFacilityIncreaseDecrease().getFacilityTypeId()!=null && rcaLeg.getDayTwoOperations().getFacilityIncreaseDecrease().getFacilityTypeId().intValue() == 2){
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param rcaLeg
	 * @return
	 */
	private static boolean getFORCAEventValue(RCALegRequest rcaLeg) {
		if(rcaLeg.getLegSummary().getTransactionEventTypeId() != null){
			 if(rcaLeg.getLegSummary().getTransactionEventTypeId().intValue() == 10 ){
				return true;
			 }
			String eventName = ((RCALegRequest) rcaLeg).getLegSummary().getTransactionEventType();
			if (StringUtils.isNotBlank(eventName)) {
				if (eventName.equalsIgnoreCase(IMMEDIATE_DRAWDOWN)) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * fetchRateInfo used to retrieve leg summary
	 * @param legNumber Integer
	 * @param request HttpServletRequest
	 * @return fetchLegSummary
	 */
	public static Object fetchRateInfo(Integer legNumber, HttpServletRequest request) {
		Object leg = CurrentDealManager.getLegByNumber(legNumber, request);
		return fetchRateInfo(leg, legNumber, request);
	}
	
	
	/**
	 * fetchRateInfo used to retrieve leg summary
	 * @param leg Object
	 * @param legNumber Integer
	 * @param request HttpServletRequest
	 * @return Object
	 */
	private static Object fetchRateInfo(Object leg, Integer legNumber, HttpServletRequest request) {
		if(leg instanceof RCALegRequest){
			RCALegRequest rcaLeg = CurrentDealManager.getLegByNumber(legNumber, RCALegRequest.class, request);
			return new RateInfoVO(legNumber, rcaLeg.getRateInformation(), request);
		}else if(leg instanceof OtherLegRequest){
			OtherLegRequest otherLeg = CurrentDealManager.getLegByNumber(legNumber, OtherLegRequest.class, request);
			return new RateInfoVO(legNumber, otherLeg.getRateInformation(), request);
		}else if(leg instanceof CPALegRequest){
			CPALegRequest cpaLeg = CurrentDealManager.getLegByNumber(legNumber, CPALegRequest.class, request);
			return new RateInfoVO(legNumber, cpaLeg.getRateInformation(), request);
		}
		return null;
	}
	
	
	/**
	 * getImmediateDrawdown 
	 * @param legNumber
	 * @param request
	 * @return
	 */
	public static String getImmediateDrawdown(Integer legNumber, HttpServletRequest request){
		Object leg = CurrentDealManager.getLegByNumber(legNumber, request);
		if (leg instanceof RCALegRequest) {
			if(((RCALegRequest) leg).isImmdtDrdownApplicableFlag() != null){
				if(((RCALegRequest) leg).isImmdtDrdownApplicableFlag() == true){
					return YES_CAP;
				}else if(((RCALegRequest) leg).isImmdtDrdownApplicableFlag() == false){
					return NO_CAP;
				}else {
					return "-";
				}
			}
		}
		return "-";
	}
	/**
	 * getImmediateDrawdownAmount
	 * @param legNumber
	 * @param request
	 * @return
	 */
	public static String getImmediateDrawdownAmount(Integer legNumber, HttpServletRequest request){
		String resultFlag = null;
		if(getImmediateDrawdown(legNumber, request).equals(YES_CAP)){
			Object leg = CurrentDealManager.getLegByNumber(legNumber, request);
			if (leg instanceof RCALegRequest && ((RCALegRequest) leg).getImmdtDrdownAmt()!=null) {
				return ICFPCommonHelper.formatAmount(((RCALegRequest) leg).getImmdtDrdownAmt().toString());
			}
		}
		return resultFlag;
	}
	/**
	 * getImmediateDrawdownAmount
	 * @param legNumber
	 * @param request
	 * @return
	 */
	public static String getImmediateDrawdownValDt(Integer legNumber, HttpServletRequest request){
		String resultFlag = null;
		if(getImmediateDrawdown(legNumber, request).equals(YES_CAP)){
			Object leg = CurrentDealManager.getLegByNumber(legNumber, request);
			if (leg instanceof RCALegRequest && ((RCALegRequest) leg).getDrdownValueDt()!=null) {
				return ((RCALegRequest) leg).getDrdownValueDt().getMonth()+"/"+((RCALegRequest) leg).getDrdownValueDt().getDay()+"/"+((RCALegRequest) leg).getDrdownValueDt().getYear();
			}
		}
		return resultFlag;
	}
	
	/**
	 * getDrawdownValueDate
	 * @param legNumber
	 * @param request
	 * @return
	 */
	public static String getDrawdownValDt(Integer legNumber, HttpServletRequest request){
		String resultFlag = null;
		
			Object leg = CurrentDealManager.getLegByNumber(legNumber, request);
			if (leg instanceof RCALegRequest) {
				if(((RCALegRequest) leg).getDrdownValueDt()!=null){
					XMLGregorianCalendar date = ((RCALegRequest) leg).getDrdownValueDt();
					return new SimpleDateFormat(MM_DD_YYYY).format(((XMLGregorianCalendar)date).toGregorianCalendar().getTime()).toString();
				}
			}
		
		return resultFlag;
	}
	
	
	/**
	 * getInterestType
	 * @param legNumber
	 * @param request
	 * @return
	 */
	public static RateInformation getInterest(Integer legNumber, HttpServletRequest request){
		RateInformation resultFlag = null;
		Object leg = CurrentDealManager.getLegByNumber(legNumber, request);
		if (leg instanceof RCALegRequest) {
			if(((RCALegRequest) leg).getRateInformation().getInterestTypeId() != null ){
				resultFlag = ((RCALegRequest) leg).getRateInformation();
			}
		}else if (leg instanceof OtherLegRequest) {
			if(((OtherLegRequest) leg).getRateInformation().getInterestTypeId() != null ){
				resultFlag = ((OtherLegRequest) leg).getRateInformation();
			}
		}else if (leg instanceof CPALegRequest) {
			if(((CPALegRequest) leg).getRateInformation().getInterestTypeId() != null ){
				resultFlag = ((CPALegRequest) leg).getRateInformation();
			}
		}
		return resultFlag;
	}
	/**
	 * 
	 * @param legNumber
	 * @param request
	 * @return
	 */
	public static TPLegRequest getTransferPricing(Integer legNumber, HttpServletRequest request){
		TPLegRequest resultFlag = null;
		if(legNumber==null || legNumber==0)
		{
			Object objLegNumber = request.getAttribute(LEGNUMBER);
			if(objLegNumber != null) {
				if(objLegNumber instanceof Integer) {
					legNumber = (Integer) objLegNumber;
				} else if(StringUtils.isNotBlank((String)objLegNumber)){
					legNumber = Integer.valueOf((String) objLegNumber);
				}
			}
			
			if(legNumber==null){
				legNumber=0;
			}
		}
		Object leg = CurrentDealManager.getLegByNumber(legNumber, request);
		if (leg instanceof RCALegRequest) {
				resultFlag = ((RCALegRequest) leg).getTPLegRequest();
		}else if (leg instanceof OtherLegRequest) {
				resultFlag = ((OtherLegRequest) leg).getTPLegRequest();
		}else if (leg instanceof CPALegRequest) {
				resultFlag = ((CPALegRequest) leg).getTPLegRequest();
		}
		return resultFlag;
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public static String getQualitativeNotching(HttpServletRequest request){
		DealRequest dealRequest = CurrentDealManager.getCurrentDeal(request);
		String data=null;
		if(dealRequest.getLegs()!=null && dealRequest.getLegs().getAllLegs()!=null){
			List<Object> legList = dealRequest.getLegs().getAllLegs();
			int counter = 1;
			for(Object leg : legList) {
				String opcode = ICFPLegHelper.getOpCode(leg);
				if(opcode == null || !opcode.equals(DELETE)) {
					TPLegRequest tpLegRequest = getTransferPricing(counter, request);
					if(tpLegRequest != null){
						String qNotches = tpLegRequest.getQualitativeNotches();
						if(qNotches!=null && StringUtils.isNotEmpty(qNotches))
						{
							double qNotchesDbl = new Double(qNotches).doubleValue();
							if(qNotchesDbl>0){
								return YES_CAP;
							}else{
								data = NO_CAP;
							}
						}
						
					}
				}
				counter++;
			}
		}
		return data;
	}
	
	
	/**
	 * 
	 * @param legNumber
	 * @param request
	 * @return
	 */
	public static List<String> getSolvencyMetricsAssessment(Integer legNumber, HttpServletRequest request){
		TPLegRequest tpLegRequest = getTransferPricing(legNumber, request);
		List<String> result = new ArrayList<String>();
		if(tpLegRequest != null){
			for (SolvencyMetrics solvencyMetrics : tpLegRequest.getSolvencyMetrics()) {
				if(solvencyMetrics.isAssessmentFlag()){
					result.add(YES_CAP);
				}else{
					result.add(NO_CAP);
				}
			}
		}
		return result;
	}
	
	public static String getSovereignConstraint(Integer legNumber, HttpServletRequest request){
		TPLegRequest tpLegRequest = getTransferPricing(legNumber, request);
		if(tpLegRequest != null){
			if(tpLegRequest.isSovereignConstraintFlag() != null && tpLegRequest.isSovereignConstraintFlag()){
				return YES_CAP;
			}else if(tpLegRequest.isSovereignConstraintFlag() != null && !tpLegRequest.isSovereignConstraintFlag()){
				return NO_CAP;
			}
			else{
				return "-";
			}
		}
		return null;
	}
	/**
	 * getCommitmentFee
	 * @param legNumber
	 * @param request
	 * @return
	 */
	public static String getCommitmentFee(Integer legNumber, HttpServletRequest request){
		String resultFlag = "-";
		Object leg = CurrentDealManager.getLegByNumber(legNumber, request);
		if (leg instanceof RCALegRequest) {
			if(((RCALegRequest) leg).isCommitmentFeeApplicableFlag() != null && ((RCALegRequest) leg).isCommitmentFeeApplicableFlag()){
				resultFlag = YES_CAP;
			}else if(((RCALegRequest) leg).isCommitmentFeeApplicableFlag() != null && !((RCALegRequest) leg).isCommitmentFeeApplicableFlag()){
				resultFlag = NO_CAP;
			}
		}else if (leg instanceof OtherLegRequest) {
			if(((OtherLegRequest) leg).isCommitmentFeeApplicableFlag() != null && ((OtherLegRequest) leg).isCommitmentFeeApplicableFlag()){
				resultFlag = YES_CAP;
			}else if(((OtherLegRequest) leg).isCommitmentFeeApplicableFlag() != null && !((OtherLegRequest) leg).isCommitmentFeeApplicableFlag()){
				resultFlag = NO_CAP;
			}
		}
		return resultFlag;
	}
	/**
	 * 
	 * @param legNumber
	 * @param request
	 * @return
	 */
	public static String getCommitmentFeeRate(Integer legNumber, HttpServletRequest request){
		String resultFlag = null;
		if(getCommitmentFee(legNumber, request).equals(YES_CAP)){
			Object leg = CurrentDealManager.getLegByNumber(legNumber, request);
			if (leg instanceof RCALegRequest) {
			
				if(((RCALegRequest) leg).getCommitmentFeeRate()!=null){
					return  Double.toString(((RCALegRequest) leg).getCommitmentFeeRate());
				}else{
					return "0.00";
				}
			}if (leg instanceof OtherLegRequest) {
				
				if(((OtherLegRequest) leg).getCommitmentFeeRate()!=null){
					return  Double.toString(((OtherLegRequest) leg).getCommitmentFeeRate());
				}else{
					return "0.00";
				}
			}
		}
		return resultFlag;
	}
	/**
	 * getWithholdingTax
	 * @param legNumber
	 * @param request
	 * @return
	 */
	public static String getWithholdingTax(Integer legNumber, HttpServletRequest request){
		String resultFlag = "-";
		Object leg = CurrentDealManager.getLegByNumber(legNumber, request);
		if (leg instanceof RCALegRequest) {
			if(((RCALegRequest) leg).isWithhldngTaxApplicableFlag() != null && ((RCALegRequest) leg).isWithhldngTaxApplicableFlag()){
				resultFlag = YES_CAP;
			}else if(((RCALegRequest) leg).isWithhldngTaxApplicableFlag() != null && ((RCALegRequest) leg).isWithhldngTaxApplicableFlag()){
				resultFlag = NO_CAP;
			}
		}
		return resultFlag;
	}
	/**
	 * getGuaranteeFee
	 * @param legNumber
	 * @param request
	 * @return
	 */
	public static String getGuaranteeFee(Integer legNumber, HttpServletRequest request){
		String resultFlag = "-";
		Object leg = CurrentDealManager.getLegByNumber(legNumber, request);
		if (leg instanceof RCALegRequest) {
			if(((RCALegRequest) leg).isGuaranteeFeeApplicableFlag() != null && ((RCALegRequest) leg).isGuaranteeFeeApplicableFlag()){
				resultFlag = YES_CAP;
			}else if(((RCALegRequest) leg).isGuaranteeFeeApplicableFlag() != null && !((RCALegRequest) leg).isGuaranteeFeeApplicableFlag()){
				resultFlag = NO_CAP;
			}
		}else if (leg instanceof OtherLegRequest) {
			if(((OtherLegRequest) leg).isGuaranteeFeeApplicableFlag() != null && ((OtherLegRequest) leg).isGuaranteeFeeApplicableFlag()){
				resultFlag = YES_CAP;
			}else if(((OtherLegRequest) leg).isGuaranteeFeeApplicableFlag() != null && !((OtherLegRequest) leg).isGuaranteeFeeApplicableFlag()){
				resultFlag = NO_CAP;
			}
		}
		return resultFlag;
	}
	/**
	 * 
	 * @param legNumber
	 * @param request
	 * @return
	 */
	public static String getGuaranteeFeeRate(Integer legNumber, HttpServletRequest request){
		String resultFlag = null;
		if(getGuaranteeFee(legNumber, request).equals(YES_CAP)){
			Object leg = CurrentDealManager.getLegByNumber(legNumber, request);
			if (leg instanceof RCALegRequest) {
				
				if(((RCALegRequest) leg).getGuaranteeFeeRate()!=null){
					return  ((RCALegRequest) leg).getGuaranteeFeeRate().toString();
				}else{
					return "0.00";
				}
				
			}else if (leg instanceof OtherLegRequest) {
				
				if(((OtherLegRequest) leg).getGuaranteeFeeRate()!=null){
					return  ((OtherLegRequest) leg).getGuaranteeFeeRate().toString();
				}else{
					return "0.00";
				}
			}
		}
		return resultFlag;
	}
	/**
	 * 
	 * @param legNumber
	 * @param request
	 * @return
	 */
	public static String getGuaranteeAgreement(Integer legNumber, HttpServletRequest request){
		String resultFlag = "-";
		Object leg = CurrentDealManager.getLegByNumber(legNumber, request);
		if (leg instanceof RCALegRequest) {
			if(((RCALegRequest) leg).isGuaranteeAgreementFlag() != null && ((RCALegRequest) leg).isGuaranteeAgreementFlag()){
				resultFlag = YES_CAP;
			}else if(((RCALegRequest) leg).isGuaranteeAgreementFlag() != null && !((RCALegRequest) leg).isGuaranteeAgreementFlag()){
				resultFlag = NO_CAP;
			}
		}else if (leg instanceof OtherLegRequest) {
			if(((OtherLegRequest) leg).isGuaranteeAgreementFlag() != null && ((OtherLegRequest) leg).isGuaranteeAgreementFlag()){
				resultFlag = YES_CAP;
			}else if(((OtherLegRequest) leg).isGuaranteeAgreementFlag() != null && !((OtherLegRequest) leg).isGuaranteeAgreementFlag()){
				resultFlag = NO_CAP;
			}
		}
		return resultFlag;
	}
	/**
	 * 
	 * @param legNumber
	 * @param request
	 * @return
	 */
	public static String getHedgeInterestRate(Integer legNumber, HttpServletRequest request){
		String resultFlag = null;
		Object leg = CurrentDealManager.getLegByNumber(legNumber, request);
		if (leg instanceof RCALegRequest) {
			if(((RCALegRequest) leg).isHedgeInterestRateDerivativieFlag() != null && ((RCALegRequest) leg).isHedgeInterestRateDerivativieFlag()){
				resultFlag = YES_CAP;
			}else{
				resultFlag = NO_CAP;
			}
		}
		return resultFlag;
	}
	/**
	 * 
	 * @param legNumber
	 * @param request
	 * @return
	 */
	public static String getHedgeForeignExchange(Integer legNumber, HttpServletRequest request){
		String resultFlag = null;
		Object leg = CurrentDealManager.getLegByNumber(legNumber, request);
		if (leg instanceof RCALegRequest) {
			if(((RCALegRequest) leg).isHedgeForeignExDerivativieFlag() != null && ((RCALegRequest) leg).isHedgeForeignExDerivativieFlag()){
				resultFlag = YES_CAP;
			}else{
				resultFlag = NO_CAP;
			}
		}
		return resultFlag;
	}
	/**
	 * getNonStandardDocsFlag used to retrieve Non Standard Flag based on exceptions
	 * @param request HttpServletRequest
	 * @return resultFlag String
	 */
	public static String getNonStandardDocsFlag(HttpServletRequest request) throws ICFPException {
		String resultFlag = null;
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		List<Object> legs = (deal.getLegs() != null) ? deal.getLegs().getAllLegs() : null;
		if(legs != null && !legs.isEmpty()) {
			for(Object leg : legs) {
				List<ExceptionRequestForm> exceptions = ICFPLegHelper.getExceptions(leg);
				if(exceptions != null && !exceptions.isEmpty()) {
					resultFlag = YES_CAP;
					return resultFlag;
				} else {
					
					boolean isDay2Leg= ICFPDay2LegHelper.isDay2Leg(leg);
					if(isDay2Leg){
						Integer eventTypeId = null;
						if(leg instanceof CPALegRequest) {
							eventTypeId = Utils.fetchPropertyValue("CPASummary.transactionEventTypeId", leg, Integer.class);
						} else {
							eventTypeId = Utils.fetchPropertyValue("legSummary.transactionEventTypeId", leg, Integer.class);
						}
						if(eventTypeId!=null && (eventTypeId == 7 || eventTypeId ==8)){
							String flag = ICFPConstants.ZERO;
							if (leg instanceof RCALegRequest) {
								if(((RCALegRequest) leg).getLegSummary().getOriginalLegalAgreementsFlag() != null ){
									flag = ((RCALegRequest) leg).getLegSummary().getOriginalLegalAgreementsFlag();
								}
							}
							if(flag.equals(ONE)){
								resultFlag = YES_CAP;
								return resultFlag;
							}else {
								resultFlag = NO_CAP;
							}
						}
					}
					resultFlag = NO_CAP;
				}
			}
		} else {
			resultFlag = "-";
		}
		return resultFlag;
	}
	
	public static String getNonStandardDocsFlag(List<Object> legs) {
		String resultFlag = null;
		if(legs != null && !legs.isEmpty()) {
			for(Object leg : legs) {
				List<ExceptionRequestForm> exceptions = ICFPLegHelper.getExceptions(leg);
				if(exceptions != null && !exceptions.isEmpty()) {
					resultFlag = YES_CAP;
					return resultFlag;
				} else {
					resultFlag = NO_CAP;
				}
			}
		} else {
			resultFlag = "-";
		}
		return resultFlag;
	}
	/**
	 * getCPANonStandardDocsFlag
	 * @param request HttpServletRequest
	 * @return String
	 */
	public static String getCPANonStandardDocsFlag(HttpServletRequest request) {
		String resultFlag = null;
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		List<Object> legs = (deal.getLegs() != null) ? deal.getLegs().getAllLegs() : null;
		if(legs != null && !legs.isEmpty()) {
			for(Object leg : legs) {
				CPALegRequest cpaLeg = (CPALegRequest)leg;
				if(cpaLeg.isNonStandardAgreementsFlag()!=null){
					boolean b = cpaLeg.isNonStandardAgreementsFlag();
					if(b){
						resultFlag = YES_CAP;
					}else{
						resultFlag = NO_CAP;
					}
				}else{
					resultFlag = NO_CAP;
				}
			}
		} else {
			resultFlag = "-";
		}
		return resultFlag;
	}
	/**
	 * getSubOrdinateDebtFlag used to retrieve subOrdinateDebtFlag
	 * @param request HttpServletRequest
	 * @return resultFlag String
	 */
	public static String getSubOrdinateDebtFlag(HttpServletRequest request) {
		String resultFlag = null;
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		List<Object> legs = (deal.getLegs() != null) ? deal.getLegs().getAllLegs() : null;
		if(legs != null && !legs.isEmpty()) {
			for(Object leg : legs) {
				boolean subOrdinateDebtFlag = ICFPLegHelper.getSubordinatedDebtFlag(leg);

				if(subOrdinateDebtFlag) {
					resultFlag = YES_CAP;
					return resultFlag;
				} else {
					resultFlag = NO_CAP;
				}
				
			}
		} else {
			resultFlag = "-";
		}
		return resultFlag;
	}
	
	public static String getSubOrdinateDebtFlag(List<Object> legs ) {
		String resultFlag = null;
		if(legs != null && !legs.isEmpty()) {
			for(Object leg : legs) {
				boolean subOrdinateDebtFlag = ICFPLegHelper.getSubordinatedDebtFlag(leg);

				if(subOrdinateDebtFlag) {
					resultFlag = YES_CAP;
					return resultFlag;
				} else {
					resultFlag = NO_CAP;
				}
				
			}
		} else {
			resultFlag = "-";
		}
		return resultFlag;
	}
	
	/**
	 * getEquityInfusionsDividendsFlag used to retrieve equityInfusionsDividendsFlag
	 * @param request HttpServletRequest
	 * @return resultFlag String
	 */
	public static String getEquityInfusionsDividendsFlag(HttpServletRequest request) {
		String resultFlag = null;
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		List<Object> legs = (deal.getLegs() != null) ? deal.getLegs().getAllLegs() : null;
		if(legs != null && !legs.isEmpty()) {
			for(Object leg : legs) {
				boolean equityInfusionsDividendsFlag = ICFPLegHelper.getEquityInfusionsDividendsFlag(leg);

				if(equityInfusionsDividendsFlag) {
					resultFlag = YES_CAP;
					return resultFlag;
				} else {
					resultFlag = NO_CAP;
				}
				
			}
		} else {
			resultFlag = "-";
		}
		return resultFlag;
	}
	
	
	public static String getEquityInfusionsDividendsFlag(List<Object> legs) {
		String resultFlag = null;
		if(legs != null && !legs.isEmpty()) {
			for(Object leg : legs) {
				boolean equityInfusionsDividendsFlag = ICFPLegHelper.getEquityInfusionsDividendsFlag(leg);

				if(equityInfusionsDividendsFlag) {
					resultFlag = YES_CAP;
					return resultFlag;
				} else {
					resultFlag = NO_CAP;
				}
				
			}
		} else {
			resultFlag = "-";
		}
		return resultFlag;
	}
	
	/**
	 * Return the Highest equity amount from all the legs
	 * 
	 * @param request
	 * @return
	 */
	public static Boolean getHighestEquityAmount(HttpServletRequest request){
		
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		
		List legs = deal.getLegs().getAllLegs();
		Double highestAmt = 0.0D;
		
		for(Object leg : legs){
			if( leg instanceof EquityLegRequest){
				EquityLegRequest equity = (EquityLegRequest) leg;
				Double curAmt = equity.getLegSummary().getOriginalCCYAmount();
				
				if(curAmt!=null &&  curAmt > highestAmt )
					highestAmt = curAmt;
			}
		}
		
		BigDecimal bigDecAmt = new BigDecimal(0.0);
		if(!"".equals(highestAmt) && highestAmt!=null){
			bigDecAmt = new BigDecimal(highestAmt);
		}

		StaticDataFactory statData = (StaticDataFactory) request.getSession().getServletContext().getAttribute(StaticDataFactory.CTX_KEY);
		String referenceData =  statData.getReferenceData();
		BigDecimal eboardAmt =  new BigDecimal(0.0);
		if(!"".equals(referenceData) && referenceData!=null){
			eboardAmt = new BigDecimal(referenceData);
		}
		
		if(highestAmt!=null && !highestAmt.equals("")){
			if(eboardAmt.compareTo(bigDecAmt) == -1){
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	/**
	 * getDerivativesRequestsFlag used to retrieve derivatives flag based derivatives added.
	 * @param request HttpServletRequest
	 * @return resultFlag String
	 */
	public static String getDerivativesRequestsFlag(HttpServletRequest request) {
		String resultFlag = null;
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		
		List<Object> legs = (deal.getLegs() != null) ? deal.getLegs().getAllLegs() : null;
		
		if(legs != null && !legs.isEmpty()) {
			for(Object leg : legs) {
				List<DerivativesRequest> derivatives = ICFPLegHelper.getDerivatives(leg);
				if(derivatives != null && !derivatives.isEmpty()) {
					resultFlag = YES_CAP;
					return resultFlag;
				} else if(leg instanceof EquityLegRequest)
				{
				
					resultFlag = NO_CAP;
				}
				else {
					resultFlag = NO_CAP;
				}
				
			}
		} 
		
		else {
			resultFlag = "-";
		}
		return resultFlag;
	}
	/**
	 * getImpairmentHistoryFlag used to retrieve impairementHistory.
	 * @param request HttpServletRequest
	 * @return resultFlag String
	 */
	public static String getImpairmentHistoryFlag(HttpServletRequest request) {
		String resultFlag = null;
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		Boolean impairementHistory = deal.isImpairmentHistoryFlag();
			
		if(impairementHistory != null &&  impairementHistory) {
			resultFlag = YES_CAP;			
		} else {
			resultFlag = NO_CAP;
		}	

		return resultFlag;
	}
	/**
	 * getFinalStatementFlag used to retrieve finalStatementFlag.
	 * @param request HttpServletRequest
	 * @return resultFlag String
	 */		
	public static String getFinalStatementFlag(HttpServletRequest request) {
		String resultFlag = null;
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		Boolean finalStatementFlag = deal.isFinSttmntDtAboveOneYrFlag();
			
		if(finalStatementFlag != null && finalStatementFlag) {
					resultFlag = YES_CAP;
					return resultFlag;
		} else {
					resultFlag = NO_CAP;
				}	
		
				return resultFlag;
		}
	
	
	/**
	 * fetchDerivatives used to fetch Derivatives List
	 * @param legNumber Integer
	 * @param pageContext PageContext
	 * @return result List
	 * @throws HWFServiceException 
	 * @throws HWFStubException 
	 */
	public static List<DerivativeDetailsVO> fetchDerivatives(Integer legNumber, PageContext pageContext) throws HWFServiceException, HWFStubException {
		List<DerivativeDetailsVO> result = null;
		Object leg = CurrentDealManager.getLegByNumber(legNumber, (HttpServletRequest) pageContext.getRequest());
		List<DerivativesRequest> derivatives = ICFPLegHelper.getDerivatives(leg);
		int count = 1;
		if(derivatives != null) {
			result = new LinkedList<DerivativeDetailsVO>();
			for(DerivativesRequest derivativeRequest : derivatives) {
				if(derivativeRequest.getDerivativesOpcode() != null && !derivativeRequest.getDerivativesOpcode().equals(DELETE)) {
					DerivativeDetailsVO derivativeVO = Utils.createDerivativeDetailsVO(derivativeRequest, (HttpServletRequest) pageContext.getRequest());
					derivativeVO.setDerivativeNumber(count);
					result.add(derivativeVO);
				}else if (derivativeRequest!=null && derivativeRequest.getDerivativesOpcode()==null){
					derivativeRequest.setDerivativesOpcode(UPDATE);
					DerivativeDetailsVO derivativeVO = Utils.createDerivativeDetailsVO(derivativeRequest, (HttpServletRequest) pageContext.getRequest());
					derivativeVO.setDerivativeNumber(count);
					result.add(derivativeVO);
				}
				count++;
			}
		}
		return result;
	}
	
	/**
	 *  This method return the derivativedetailsvo object which contains data of
	 *  derivativerequest object.
	 */
	public static DerivativeDetailsVO getDerivative(Integer legNumber, Integer deriativesSeqId,  PageContext pageContext) throws HWFServiceException, HWFStubException {
		
		Object leg = CurrentDealManager.getLegByNumber(legNumber, (HttpServletRequest) pageContext.getRequest());
		List<DerivativesRequest> derivatives = ICFPLegHelper.getDerivatives(leg);
		int count = 1;
		if(derivatives != null) {
		
			for(DerivativesRequest derivativeRequest : derivatives) {
				
				if(derivativeRequest.getDeriativesSeqId()== deriativesSeqId)
				{
					DerivativeDetailsVO derivativeVO = Utils.createDerivativeDetailsVO(derivativeRequest, (HttpServletRequest) pageContext.getRequest());
					derivativeVO.setDerivativeNumber(count);
					return derivativeVO;
				}
				count++;
			}
		}
		return null;
	}
	/**
	 * getTotalNumberofLegs used to retrieve count of the legs in deal screen.
	 * @param request HttpServletRequest
	 * @return resultFlag String
	 */
	public static int getTotalNumberofLegs(HttpServletRequest request) {
		int numberOfLegs = fetchLegs(request).size();
		return numberOfLegs;

	}
	
	
	/**
	 * Get deal Category Name for Transaction summary in Add Leg
	 * @param dealCategoryId
	 * @param request
	 * @return
	 * @throws HWFServiceException 
	 * @throws HWFStubException 
	 */
	public static String getDealCategoryName(Integer dealCategoryId,HttpServletRequest request) throws HWFServiceException, HWFStubException {
		
		String dealCatName = "";
		dealCatName = Utils.getDealCategoryName(dealCategoryId, request);
		
		return dealCatName;
	}
	
	/**
	 * Returns all deal categories as a map.
	 * 
	 * @param request
	 * @return
	 */
	public static Map<String, String> getAllDealCategories(HttpServletRequest request) {
		Map<String, String> categories = new HashMap<String, String>();
		ServletContext servletContext = request.getSession().getServletContext();
		StaticDataFactory staticDataFactory =(StaticDataFactory)servletContext.getAttribute(StaticDataFactory.CTX_KEY); 
		List <NameValue> categroiesFromDB = staticDataFactory.getDealCategories(); 
		for(NameValue eachCategory : categroiesFromDB) {
			categories.put(String.valueOf(eachCategory.getID()), eachCategory.getName());
		}
		return categories;
	}
	
	/**
	 * 
	 * @param workFlowStage
	 * @param request
	 * @return
	 * @throws HWFServiceException
	 * @throws HWFStubException
	 */
	public static String getWorkFlowStageDesc(String workFlowStage,HttpServletRequest request) throws HWFServiceException, HWFStubException {
		
		String dealCatName = "";
		dealCatName = Utils.getWorkFlowStageDesc(workFlowStage, request);
		
		return dealCatName;
	}
	
	/**
	 * Returns workflow stage description map.
	 * 
	 * @param request
	 * @return
	 * @throws HWFStubException 
	 * @throws HWFServiceException 
	 */
	public static Map<String, String> getWorkflowStageDescMap(HttpServletRequest request) throws HWFServiceException, HWFStubException {
		Map<String, String> stageDescMap = new HashMap<String, String>();
		ServletContext servletContext = request.getSession().getServletContext();
		StaticDataFactory staticDataFactory =(StaticDataFactory)servletContext.getAttribute(StaticDataFactory.CTX_KEY); 
		List<WFStageDetails> workFlowStages = staticDataFactory.getWorkFlowStageDetails(); 
		for(WFStageDetails wfStageDetails : workFlowStages){
			stageDescMap.put(wfStageDetails.getWFStage(), wfStageDetails.getWFStageDesc());
		}
		return stageDescMap;
	}
	
	/**
	 * 
	 * @param workFlowStageId
	 * @param request
	 * @return
	 * @throws HWFServiceException
	 * @throws HWFStubException
	 */
	public static String getWorkFlowStageDesc(Integer workFlowStageId,HttpServletRequest request) throws HWFServiceException, HWFStubException {
		
		String dealCatName = "";
		dealCatName = Utils.getWorkFlowStageDesc(workFlowStageId, request);
		
		return dealCatName;
	}
	/**
	 * 
	 * @param eventTypeId
	 * @param request
	 * @return
	 * @throws HWFServiceException
	 * @throws HWFStubException
	 */
	public static String getEventTypeName(String eventTypeId,HttpServletRequest request) throws HWFServiceException, HWFStubException {
		
		String eventTypeName = "";
		eventTypeName = Utils.getEventTypeName(eventTypeId, request);
		
		return eventTypeName;
	}
	/**
	 * getPrincipalEntityFlag used to retrieve principalEntityFlag.
	 * @param request HttpServletRequest
	 * @return resultFlag String
	 */
	public static String getPrincipalEntityFlag(HttpServletRequest request) {
		String resultFlag = null;
		boolean principalEntityFlag = false;
		
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		List<Object> legs = (deal.getLegs() != null) ? deal.getLegs().getAllLegs() : null;
		if(legs != null && !legs.isEmpty()) {
			for(Object leg : legs) {
				
				principalEntityFlag = ICFPLegHelper.getPrincipalEntityFlag(leg);
				
				if(principalEntityFlag) {
					resultFlag = YES_CAP;
					return resultFlag;
				} else {
					resultFlag = NO_CAP;
				}
			}
		} else {
			resultFlag = "-";
		}
		return resultFlag;
	}
	
	public static String getPrincipalEntityFlag(List<Object> legs) {
		String resultFlag = null;
		boolean principalEntityFlag = false;
		if(legs != null && !legs.isEmpty()) {
			for(Object leg : legs) {
				
				principalEntityFlag = ICFPLegHelper.getPrincipalEntityFlag(leg);
				
				if(principalEntityFlag) {
					resultFlag = YES_CAP;
					return resultFlag;
				} else {
					resultFlag = NO_CAP;
				}
			}
		} else {
			resultFlag = "-";
		}
		return resultFlag;
	}
	/**
	 * getPrudentialEntityFlag used to retrieve prudentialEntityFlag.
	 * @param request HttpServletRequest
	 * @return resultFlag String
	 */
	public static String getPrudentialEntityFlag(HttpServletRequest request) {
		
		String resultFlag = null;
		boolean prudentialEntityFlag = false;
		
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		List<Object> legs = (deal.getLegs() != null) ? deal.getLegs().getAllLegs() : null;
		if(legs != null && !legs.isEmpty()) {
			for(Object leg : legs) {
				
				prudentialEntityFlag = ICFPLegHelper.getPrudentialEntityFlag(leg);
				
				if(prudentialEntityFlag) {
					resultFlag = YES_CAP;
					return resultFlag;
				} else {
					resultFlag = NO_CAP;
				}
			}
		} else {
			resultFlag = "-";
		}
		return resultFlag;
	}
	
	
	public static String getPrudentialEntityFlag(List<Object> legs) {
		
		String resultFlag = null;
		boolean prudentialEntityFlag = false;
		
		if(legs != null && !legs.isEmpty()) {
			for(Object leg : legs) {
				
				prudentialEntityFlag = ICFPLegHelper.getPrudentialEntityFlag(leg);
				
				if(prudentialEntityFlag) {
					resultFlag = YES_CAP;
					return resultFlag;
				} else {
					resultFlag = NO_CAP;
				}
			}
		} else {
			resultFlag = "-";
		}
		return resultFlag;
	}
	
	/**
	 * 
	 * @param legNumber
	 * @param request
	 * @return
	 */
	public static Boolean getLegCrossBorderFlagValue(Integer legNumber, HttpServletRequest request) {
		Object leg = CurrentDealManager.getLegByNumber(legNumber, request);
		return ICFPLegHelper.getCrossBorderFlagValue(leg);
	}

	/**
	 * getCrossBorderFlagValue used to retrieve crossBorderFlag.
	 * @param request HttpServletRequest
	 * @return resultFlag String
	 */
	public static String getCrossBorderFlagValue(HttpServletRequest request) {
		
		
		String resultFlag = null;
		boolean crossBorderFlag = false;
		
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		
		
		List<Object> legs = (deal.getLegs() != null) ? deal.getLegs().getAllLegs() : null;
		if(legs != null && !legs.isEmpty()) {
			for(Object leg : legs) {	
				crossBorderFlag = ICFPLegHelper.getCrossBorderFlagValue(leg);
				
				if(crossBorderFlag) {
					resultFlag = YES_CAP;
					return resultFlag;
				} else {
					resultFlag = NO_CAP;
				}
			}
		} else {
			resultFlag = "-";
		}
		return resultFlag;
	}
	
	
	/**
	 * getCrossBorderFlagValue used to retrieve crossBorderFlag.
	 * @param request HttpServletRequest
	 * @return resultFlag String
	 */
	public static String getCrossBorderFlagValue(List<Object> legs) {
		
		
		String resultFlag = null;
		boolean crossBorderFlag = false;
		
		if(legs != null && !legs.isEmpty()) {
			for(Object leg : legs) {	
				crossBorderFlag = ICFPLegHelper.getCrossBorderFlagValue(leg);
				
				if(crossBorderFlag) {
					resultFlag = YES_CAP;
					return resultFlag;
				} else {
					resultFlag = NO_CAP;
				}
			}
		} else {
			resultFlag = "-";
		}
		return resultFlag;
	}
	
	/**
	 * getSecurityTypeFlag used to retrieve securityTypeFlag.
	 * @param request HttpServletRequest
	 * @return resultFlag String
	 */
	public static String getSecurityTypeFlag(HttpServletRequest request) {
		String resultFlag = null;
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		if(deal.getSecurityCategoryId()!=null){
		int i = deal.getSecurityCategoryId();
			
		if( i == 1)
			resultFlag = YES_CAP;
		else
			resultFlag = NO_CAP;
		}
		return resultFlag;
		}
		
	/**
	 * 
	 * @param request
	 * @return
	 */
	public static String getRiskOverride(HttpServletRequest request){
		String resultFlag = null;
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		Boolean securityTypeFlag = deal.isRiskOverrideFlag();
		if(securityTypeFlag!=null) {
		if(securityTypeFlag != false) {
			resultFlag = YES_CAP;
			return resultFlag;
		} else {
			resultFlag = NO_CAP;
		}	
		} else {
			resultFlag = NO_CAP;
		}

		return resultFlag;
	}
	
	/**
	 * Return comments entered on Eboard action
	 * 
	 * @param request
	 * @return
	 */
	public static String getEboardComments(HttpServletRequest request){
		
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		
		List<ActionLog> logs = deal.getActionLogs();
		List<ActionLog> eboardComments = new ArrayList<ActionLog>();
		String decision = null;
		
		//Get only the EboardRoomComments
		for(ActionLog log : logs){
			decision = log.getDecision();
			if("SendToEboardroomApprove".equals(decision)){
				eboardComments.add(log);
			}
		}
		
		String getLatestComment = "";
		String actionDt = null;
		Date date = null;
		Date prevDate = null;
		
		//Get  latest eboard room comments
		for(ActionLog log2 : eboardComments){
			actionDt = log2.getActionDt();
			try {
				date = Utils.parseActionLogDate(actionDt);
			} catch (ParseException e) {
				//ignore the parse error
				continue;
			}
			
			if(prevDate == null){
				prevDate = date;
				getLatestComment = log2.getComments();
			}
			
			if(date.after(prevDate)){
				getLatestComment = log2.getComments();
			}
		}
		
		return getLatestComment;
	}
	/**
	 * getChangeAfterIdagApprovalFlag
	 * @param request HttpServletRequest
	 * @return String
	 */
	public static String getChangeAfterIdagApprovalFlag(HttpServletRequest request){
		String resultFlag = null;
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		Boolean securityTypeFlag = deal.isChngAfterIdagApprovalFlag();
		if(securityTypeFlag!=null) {
		if(securityTypeFlag != false) {
			resultFlag = YES_CAP;
			return resultFlag;
		} else {
			resultFlag = NO_CAP;
		}	
		} else {
			resultFlag = NO_CAP;
		}

		return resultFlag;
	}
	/**
	 * getChangeAfterApprovalFlag
	 * @param request
	 * @return
	 */
	public static String getChangeAfterApprovalFlag(HttpServletRequest request){
		String resultFlag = null;
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		Boolean securityTypeFlag = deal.isChngAfterApprovalsFlag();
		if(securityTypeFlag!=null) {
		if(securityTypeFlag != false) {
			resultFlag = YES_CAP;
			return resultFlag;
		} else {
			resultFlag = NO_CAP;
		}	
		} else {
			resultFlag = NO_CAP;
		}

		return resultFlag;
	}

	/**
	 * getEBoardApprovalRequiredFlag
	 * @param legNumber Integer
	 * @param request HttpServletRequest
	 * @return String
	 */
	public static String getEBoardApprovalRequiredFlag(Integer legNumber,
			HttpServletRequest request) {
		String resultFlag = null;
		boolean isEBoardApprovalRequiredFlag =false;
		Object leg = CurrentDealManager.getLegByNumber(legNumber, request);
		if (leg instanceof EquityLegRequest) {
			EquityLegRequest equityLeg = CurrentDealManager.getLegByNumber(
					legNumber, EquityLegRequest.class, request);
			if(equityLeg.isEBoardApprovalRequiredFlag()!=null) {
				isEBoardApprovalRequiredFlag = equityLeg.isEBoardApprovalRequiredFlag();
			}
			if (isEBoardApprovalRequiredFlag != false) {
				resultFlag = YES_CAP;
				return resultFlag;
			} else {
				resultFlag = NO_CAP;
			}

		}
		return resultFlag;

	}
	/**
	 * getDoubleLeverageFlag
	 * @param legNumber Integer
	 * @param request HttpServletRequest
	 * @return String
	 */
	public static String getDoubleLeverageFlag(Integer legNumber,
			HttpServletRequest request) {
		String resultFlag = null;
		boolean isEBoardApprovalRequiredFlag =false;
		Object leg = CurrentDealManager.getLegByNumber(legNumber, request);
		if (leg instanceof EquityLegRequest) {
			EquityLegRequest equityLeg = CurrentDealManager.getLegByNumber(legNumber, EquityLegRequest.class, request);
			if(equityLeg.isDoubleLeverageFlag()!=null) {
				isEBoardApprovalRequiredFlag = equityLeg.isDoubleLeverageFlag();
			}
			if (isEBoardApprovalRequiredFlag != false) {
				resultFlag = YES_CAP;
				return resultFlag;
			} else {
				resultFlag = NO_CAP;
			}

		}
		return resultFlag;
	}
	
	/**
	 * getShareInfoList
	 * @param legNumber Integer
	 * @param request HttpServletRequest
	 * @return shareInfo list
	 * @throws HWFServiceException if any thing happens
	 */
	public static List<ShareInfo> getShareInfoList(Integer legNumber,
			HttpServletRequest request) throws HWFServiceException {

		Object leg = CurrentDealManager.getLegByNumber(legNumber, request);
		if (leg instanceof EquityLegRequest) {
			EquityLegRequest equityLeg = CurrentDealManager.getLegByNumber(
					legNumber, EquityLegRequest.class, request);

			List<ShareInfo> shareInfo = equityLeg.getShareInfos();

			return shareInfo;
		}
		return null;
	}
	/**
	 * getEquityFormId
	 * @param legNumber
	 * @param request
	 * @return
	 * @throws HWFServiceException
	 */
	public static String getEquityFormId(Integer legNumber,
			HttpServletRequest request) throws HWFServiceException {
		Object leg = CurrentDealManager.getLegByNumber(legNumber, request);
		if (leg instanceof EquityLegRequest) {
			EquityLegRequest equityLeg = CurrentDealManager.getLegByNumber(
					legNumber, EquityLegRequest.class, request);
			String equityFormId = equityLeg.getEquityForm();
			if (equityFormId != null) {
				return equityFormId;
			}
		}
		return "";

	}
	
	/**
	 * getOtherEquityComments
	 * @param legNumber
	 * @param request
	 * @return
	 * @throws HWFServiceException
	 */
	public static String getOtherEquityComments(Integer legNumber,
			HttpServletRequest request) throws HWFServiceException {
		Object leg = CurrentDealManager.getLegByNumber(legNumber, request);
		if (leg instanceof EquityLegRequest) {
			EquityLegRequest equityLeg = CurrentDealManager.getLegByNumber(
					legNumber, EquityLegRequest.class, request);
			String equityFormId = equityLeg.getOtherEquityComments();
			if (equityFormId != null) {
				return equityFormId;
			}
		}
		return "";

	}
	
	/**
	 * getDoubleLeverage
	 * @param legNumber
	 * @param request
	 * @return
	 * @throws HWFServiceException
	 */
	public static String getDoubleLeverage(Integer legNumber,
			HttpServletRequest request) throws HWFServiceException {
		Object leg = CurrentDealManager.getLegByNumber(legNumber, request);
		if (leg instanceof EquityLegRequest) {
			EquityLegRequest equityLeg = CurrentDealManager.getLegByNumber(
					legNumber, EquityLegRequest.class, request);
			String doubleLeverage = String.valueOf(equityLeg.isDoubleLeverageFlag());
			if (doubleLeverage != null) {
				return doubleLeverage;
			}
		}
		return "";

	}
	
	/**
	 * getDebtTerms
	 * @param legNumber
	 * @param request
	 * @return
	 * @throws HWFServiceException
	 */
	public static String getDebtTerms(Integer legNumber,
			HttpServletRequest request) throws HWFServiceException {
		String resultFlag = null;
		Object leg = CurrentDealManager.getLegByNumber(legNumber, request);
		if (leg instanceof EquityLegRequest) {
			EquityLegRequest equityLeg = CurrentDealManager.getLegByNumber(
					legNumber, EquityLegRequest.class, request);
			boolean shareTypeId = equityLeg.getShareInfos().size() > 0;
			shareTypeId = shareTypeId	&&	equityLeg.getShareInfos().get(0).getDebtTerms() != null;
			if (shareTypeId != false) {
				resultFlag = YES_CAP;
				return resultFlag;
			} else {
				resultFlag = NO_CAP;
			}

		}
		return resultFlag;

	}
	/**
	 * getShareTypeId
	 * @param legNumber
	 * @param request
	 * @return
	 * @throws HWFServiceException
	 */
	public static String getShareTypeId(Integer legNumber,
			HttpServletRequest request) throws HWFServiceException {
		Object leg = CurrentDealManager.getLegByNumber(legNumber, request);
		if (leg instanceof EquityLegRequest) {
			EquityLegRequest equityLeg = CurrentDealManager.getLegByNumber(
					legNumber, EquityLegRequest.class, request);
			if(equityLeg.getShareInfos().size() > 0){
				String shareType = equityLeg.getShareInfos().get(0).getShareType();
				return shareType;
			}
		}
		return null;

	}
	/**
	 * getNumberOfShares
	 * @param legNumber
	 * @param request
	 * @return
	 * @throws HWFServiceException
	 */
	public static int getNumberOfShares(Integer legNumber,
			HttpServletRequest request) throws HWFServiceException {
		Object leg = CurrentDealManager.getLegByNumber(legNumber, request);
		if (leg instanceof EquityLegRequest) {
			EquityLegRequest equityLeg = CurrentDealManager.getLegByNumber(
					legNumber, EquityLegRequest.class, request);
			
			if( equityLeg.getShareInfos().size() > 0){
				int numberOfShares = equityLeg.getShareInfos().get(0)
						.getNumberOfShares();
				return numberOfShares;
			}
			
		}
		return 0;

	}
	/**
	 * getSharePrfId
	 * @param legNumber
	 * @param request
	 * @return
	 * @throws HWFServiceException
	 */
	public static double getSharePrfId(Integer legNumber,
			HttpServletRequest request) throws HWFServiceException {

		Object leg = CurrentDealManager.getLegByNumber(legNumber, request);
		if (leg instanceof EquityLegRequest) {
			EquityLegRequest equityLeg = CurrentDealManager.getLegByNumber(
					legNumber, EquityLegRequest.class, request);
			
			if( equityLeg.getShareInfos().size() > 0 ){
				double sharePrfId = equityLeg.getShareInfos().get(0).getShareValue();
				return sharePrfId;
			}
		}
		return 0;

	}

	/**
	 * getClosingRequestMap
	 * @param request
	 * @return
	 */
	public static Map<Integer, ClosingCheckList> getClosingRequestMap(
			HttpServletRequest request) {
		Map<Integer, ClosingCheckList> result = new HashMap<Integer, ClosingCheckList>();
		DealRequest currentDeal = CurrentDealManager.getCurrentDeal(request);
		List<ClosingCheckList> closingCheckLists = currentDeal
				.getClosingCheckLists();
		if (!closingCheckLists.isEmpty()) {
			for (ClosingCheckList eachCheckList : closingCheckLists) {
				result.put(Integer.valueOf(eachCheckList.getCertListId()), eachCheckList);
			}
		}
		return result;
	}
	
	/**
	 * isNextLeg
	 * @param legForm
	 * @param request
	 * @param legNumber
	 * @return
	 */
	public static int isNextLeg(DynaActionForm legForm, HttpServletRequest request,Integer legNumber){
		if(legNumber < CurrentDealManager.getCurrentDeal(request).getLegs().getAllLegs().size()){
			return legNumber+1;
		}
		return 0;
	}
	
	/**
	 * This method is used for all leg exceptions count of current deal.
	 * @param request HttpServletRequest
	 * @return count int
	 */
	public static int exceptionCount(HttpServletRequest request) {
		DealRequest dealRequest = CurrentDealManager.getCurrentDeal(request);
		int count = 0;
		if (dealRequest.getLegs() != null
				&& dealRequest.getLegs().getAllLegs() != null) {
			List<Object> legList = dealRequest.getLegs().getAllLegs();
			for (Object leg : legList) {
				String opcode = ICFPLegHelper.getOpCode(leg);
				if (opcode == null || !opcode.equals(DELETE)) {
					List<ExceptionRequestForm> exceptionList = ICFPLegHelper
							.getExceptions(leg);
					for (ExceptionRequestForm eachExceptionRequest : exceptionList) {
						if (!eachExceptionRequest.getExceptionOpcode().equals(
								DELETE)) {
							count++;
						}
					}
				}
			}
		}
		return count;
	}
	/**
	 * getFinalStatement
	 * @param request
	 * @return
	 */
	public static String getFinalStatement(HttpServletRequest request) {
		String resultFlag = null;
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		if(deal.isFinSttmntDtAboveOneYrFlag()!=null){
		
		boolean finalStatementFlag = deal.isFinSttmntDtAboveOneYrFlag();
			
				if(finalStatementFlag != false) {
					resultFlag = ONE;
					return resultFlag;
				} else {
					resultFlag = ICFPConstants.ZERO;
				}	
		}
		return resultFlag;
		}
	
	
	/**
	 * getModelTypeIdForDeal
	 * @param request
	 * @return
	 */
	public static Integer getModelTypeIdForLeg(HttpServletRequest request,Integer legNumber) {
		Integer result = null;
		Object legSummary = CurrentDealManager.getLegByNumber(legNumber, request);
		if(legSummary!=null) {
		if(legSummary instanceof RCALegRequest) {
			RCALegRequest rcaLeg = (RCALegRequest) legSummary;
				Integer modelTypeId = (rcaLeg.getTPLegRequest() != null) ? rcaLeg.getTPLegRequest().getModelTypeId() : null;
				if(modelTypeId != null && modelTypeId >= 2) {
					result = modelTypeId;
				}
			} else 
			if(legSummary instanceof CPALegRequest) {
				CPALegRequest cpaLeg = (CPALegRequest) legSummary;
				Integer modelTypeId = (cpaLeg.getTPLegRequest() != null) ? cpaLeg.getTPLegRequest().getModelTypeId() : null;
				if(modelTypeId != null && modelTypeId >= 2) {
					result = modelTypeId;
				}
			} else
			if(legSummary instanceof OtherLegRequest) {
				OtherLegRequest otherLeg = (OtherLegRequest) legSummary;
				Integer modelTypeId = (otherLeg.getTPLegRequest() != null) ? otherLeg.getTPLegRequest().getModelTypeId() : null;
				if(modelTypeId != null && modelTypeId >= 2) {
					result = modelTypeId;
				}
			}
		}
		return result;
	}
	
	/**
	 * getModelTypeIdForDeal
	 * @param request
	 * @return
	 */
	public static Integer getModelTypeIdForDeal(HttpServletRequest request) {
		Integer result = null;
		DealRequest dealRequest = CurrentDealManager.getCurrentDeal(request);
		if(dealRequest.getLegs() == null) {
			return result;
		}
		for(Object leg : dealRequest.getLegs().getAllLegs()) {
			if(leg instanceof RCALegRequest) {
				RCALegRequest rcaLeg = (RCALegRequest) leg;
				Integer modelTypeId = (rcaLeg.getTPLegRequest() != null) ? rcaLeg.getTPLegRequest().getModelTypeId() : null;
				if(modelTypeId != null && modelTypeId >= 2) {
					result = modelTypeId;
					break;
				}
			} else 
			if(leg instanceof CPALegRequest) {
				CPALegRequest cpaLeg = (CPALegRequest) leg;
				Integer modelTypeId = (cpaLeg.getTPLegRequest() != null) ? cpaLeg.getTPLegRequest().getModelTypeId() : null;
				if(modelTypeId != null && modelTypeId >= 2) {
					result = modelTypeId;
					break;
				}
			} else
			if(leg instanceof OtherLegRequest) {
				OtherLegRequest otherLeg = (OtherLegRequest) leg;
				Integer modelTypeId = (otherLeg.getTPLegRequest() != null) ? otherLeg.getTPLegRequest().getModelTypeId() : null;
				if(modelTypeId != null && modelTypeId >= 2) {
					result = modelTypeId;
					break;
				}
			} 
		}
		return result;
	}
	
	
	/**
	 * getModelTypeIdForDeal
	 * @param request
	 * @return
	 */
	public static Integer getModelTypeCountForDeal(HttpServletRequest request) {
		Integer count = new Integer(0);
		DealRequest dealRequest = CurrentDealManager.getCurrentDeal(request);
		if(dealRequest.getLegs() == null) {
			return count;
		}
		for(Object leg : dealRequest.getLegs().getAllLegs()) {
			if(leg instanceof RCALegRequest) {
				RCALegRequest rcaLeg = (RCALegRequest) leg;
				Integer modelTypeId = (rcaLeg.getTPLegRequest() != null) ? rcaLeg.getTPLegRequest().getModelTypeId() : null;
				if(modelTypeId != null && modelTypeId >= 2) {
					++count;
				
				}
			} else 
			if(leg instanceof CPALegRequest) {
				CPALegRequest cpaLeg = (CPALegRequest) leg;
				Integer modelTypeId = (cpaLeg.getTPLegRequest() != null) ? cpaLeg.getTPLegRequest().getModelTypeId() : null;
				if(modelTypeId != null && modelTypeId >= 2) {
					++count;

				}
			} else
			if(leg instanceof OtherLegRequest) {
				OtherLegRequest otherLeg = (OtherLegRequest) leg;
				Integer modelTypeId = (otherLeg.getTPLegRequest() != null) ? otherLeg.getTPLegRequest().getModelTypeId() : null;
				if(modelTypeId != null && modelTypeId >= 2) {
					++count;

				}
			} 
		}
		return 	count;

	}
	
	/**
	 * getFOAffirmFlag For front office, returns the reaffirmation flag
	 * @param request
	 * @return
	 */
	public static String getFOAffirmFlag(HttpServletRequest request) {
		String resultFlag = NO_CAP;
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		Boolean foAffirmFlag = deal.isFOAffirmFlag();
		if(foAffirmFlag != null && foAffirmFlag == true) {
			resultFlag = YES_CAP;
			return resultFlag;
		}
		return resultFlag;
	}
	
	/**
	 * 
	 * @param commentType
	 * @param request
	 * @return
	 */
	public static String getDealAttachmentComment(Integer commentType, HttpServletRequest request) {
		String comment = "";
		DealRequest dealRequest = CurrentDealManager.getCurrentDeal(request);
		List li = dealRequest.getAttachmentTypeComments();
		for(int i=0;i<li.size();i++) {
			AttachmentTypeComments cmtObj =(AttachmentTypeComments)li.get(i);
			if(cmtObj.getAttachmentTypeId().equals(commentType)) {
				if(cmtObj.getComments()!=null) {
				comment = cmtObj.getComments();
				}
			}
			
		}

		return comment;
	}
	
	/**
	 * 
	 * @param legNumber
	 * @param commentType
	 * @param request
	 * @return
	 */
	public static String getLegAttachmentComment(Integer legNumber, Integer commentType, HttpServletRequest request) {
		String comment = "";
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		Object legSummary = CurrentDealManager.getLegByNumber(legNumber, request);
		if(legSummary instanceof RCALegRequest) {
			RCALegRequest rcaLeg = (RCALegRequest) legSummary;
			for(int i=0;i<rcaLeg.getLegSummary().getAttachmentTypeComments().size();i++) {
			if(rcaLeg.getLegSummary().getAttachmentTypeComments().get(i).getAttachmentTypeId().equals(commentType))
			{
				comment = rcaLeg.getLegSummary().getAttachmentTypeComments().get(i).getComments();
				if(comment!=null && comment.length()>0) { // this section will be removed in future
				if(comment.contains("<span>")) {
					comment = comment.replaceAll("<span>", "");
					comment = comment.replaceAll("</span>", "");
					comment = comment.trim();
				}
				}
			}
			}
		} else if(legSummary instanceof EquityLegRequest) {
			EquityLegRequest equityLeg = (EquityLegRequest) legSummary;
			for(int i=0;i<equityLeg.getLegSummary().getAttachmentTypeComments().size();i++) {
			if(equityLeg.getLegSummary().getAttachmentTypeComments().get(i).getAttachmentTypeId().equals(commentType))
			{
				comment = equityLeg.getLegSummary().getAttachmentTypeComments().get(i).getComments();
				if(comment!=null && comment.length()>0) { // this section will be removed in future
				if(comment.contains("<span>")) {
					comment = comment.replaceAll("<span>", "");
					comment = comment.replaceAll("</span>", "");
					comment = comment.trim();
				}
				}
			}
			}
		} else if(legSummary instanceof OtherLegRequest) {
			OtherLegRequest otherLeg = (OtherLegRequest) legSummary;
			for(int i=0;i<otherLeg.getLegSummary().getAttachmentTypeComments().size();i++) {
			if(otherLeg.getLegSummary().getAttachmentTypeComments().get(i).getAttachmentTypeId().equals(commentType))
			{
				comment = otherLeg.getLegSummary().getAttachmentTypeComments().get(i).getComments();
				if(comment!=null && comment.length()>0) { // this section will be removed in future
				if(comment.contains("<span>")) {
					comment = comment.replaceAll("<span>", "");
					comment = comment.replaceAll("</span>", "");
					comment = comment.trim();
				}
				}
			}
			}
		} else if(legSummary instanceof CPALegRequest) { 
			CPALegRequest cpaLeg = (CPALegRequest) legSummary;
			for(int i=0;i<cpaLeg.getCPASummary().getAttachmentTypeComments().size();i++) {
			if(cpaLeg.getCPASummary().getAttachmentTypeComments().get(i).getAttachmentTypeId().equals(commentType))
			{
				comment = cpaLeg.getCPASummary().getAttachmentTypeComments().get(i).getComments();
				if(comment!=null && comment.length()>0) { // this section will be removed in future
				if(comment.contains("<span>")) {
					comment.replaceAll("<span>", "");
					comment.replaceAll("</span>", "");
					comment.trim();
				}
				}
			}
			}
				
		}
		
		return comment;
	}
	
	/**
	 * 
	 * @return
	 */
	public static String formatXMLGregorianCalendar(XMLGregorianCalendar calendar, String format) {
		String result = null;
		if(calendar != null) {
			Date date = calendar.toGregorianCalendar().getTime();
			SimpleDateFormat dateFormat = new SimpleDateFormat(format);
			result = dateFormat.format(date);
		}
		return result;
	}
	
	/**
	 * Return currency format for the given string
	 * @param calendar
	 * @param format
	 * @return
	 */
	public static String convertAmountToCurrencyFormat(String amountStr) {
		
		if(amountStr!=null && !amountStr.equals(""))
		{
			amountStr = ICFPCommonHelper.formatCurrency(amountStr);
		}
		return amountStr;
	}
	
	/**
	 * Returns the summary object of leg
	 * @param legNumber
	 * @param request
	 * @return
	 */
	public static Object fetchLegSummaryObject(Integer legNumber, HttpServletRequest request) {
		Object leg = CurrentDealManager.getLegByNumber(legNumber, request);
		return ICFPLegHelper.getLegSummary(leg);
	}
	
	/**
	 * Return unique list of business segment from all the legs.
	 * 
	 * @param request
	 * @return
	 */
	public static Set<String> getAllBusinessSegment(HttpServletRequest request){
		
		Set<String> uniqueList = new HashSet<String>(); 

		for(Object leg : fetchLegs(request) ) {
			
			if( leg instanceof LegSummaryVO){
				
				LegSummaryVO vo = (LegSummaryVO) leg;
				uniqueList.addAll( vo.getAllBusinessSegment() );
				
			}else if ( leg instanceof CPALegSummaryVO ){
				
				CPALegSummaryVO vo = (CPALegSummaryVO) leg;
				uniqueList.addAll( vo.getAllBusinessSegment() );		
			}
		}
		
		return uniqueList;
	}
	
	/**
	 * Return unique list of business segment from all the legs.
	 * 
	 * @param request
	 * @return
	 */
	public static List<String> getEquityBusinessSegment(HttpServletRequest request){
		
		List<String> uniqueList = new ArrayList<String>(); 

		for(Object leg : fetchEquityLegs(request) ) {
			
			if( leg instanceof LegSummaryVO){
				
				LegSummaryVO vo = (LegSummaryVO) leg;
				uniqueList.addAll( vo.getAllBusinessSegment() );
				
			}
		}
		
		return uniqueList;
	}
	
	
	/**
	 * Method to get borrower insolvency flag
	 * @param request
	 * @return
	 */
	public static String getBorrowerInsolvencyFlag(HttpServletRequest request){
		DealRequest dealRequest = CurrentDealManager.getCurrentDeal(request);
		String borrowerInSolvent = "-";
		boolean borrowerInSolventFlag = false;
		if(dealRequest.getLegs()!=null && dealRequest.getLegs().getAllLegs()!=null){
			List<Object> legList = dealRequest.getLegs().getAllLegs();
			int counter = 1;
			for(Object leg : legList) {
				String opcode = ICFPLegHelper.getOpCode(leg);
				if(opcode == null || !opcode.equals(DELETE)) {
					TPLegRequest tpLegRequest = getTransferPricing(counter, request);
					if(tpLegRequest != null && tpLegRequest.getSolvencyMetrics()!=null && !tpLegRequest.getSolvencyMetrics().isEmpty()){
						List<SolvencyMetrics> solvencyMetricsList = tpLegRequest.getSolvencyMetrics();
						for(SolvencyMetrics solvencyMetricsObj:solvencyMetricsList)
						{
							Integer solvencyMetricsID = solvencyMetricsObj.getSolvencyMetricId();
							if(solvencyMetricsID!=null && solvencyMetricsID.intValue()==7)
							{
								borrowerInSolventFlag = solvencyMetricsObj.isAssessmentFlag();
							}
							
							if(borrowerInSolventFlag){
								borrowerInSolvent = YES_CAP;
								break;
							}else if (!borrowerInSolventFlag && !StringUtils.isEmpty(borrowerInSolvent) &&
									!borrowerInSolvent.equals(NO_CAP))
							{
								borrowerInSolvent = NO_CAP;
							}
						}
					}
				}
				
				if(borrowerInSolventFlag){
					break;
				}
				counter++;
			}
		}
		return borrowerInSolvent;
	}
	
	
	
	public static String getTPFundHoldOperationId(Integer legNumber, HttpServletRequest request) {
		
		try{
			
			if(legNumber==null || legNumber == 0)
			{
				return ICFPConstants.ZERO;
			}
			
			Object leg = CurrentDealManager.getLegByNumber(legNumber, request);
			Entity entityObject = null;
			ProductType pType = ICFPLegHelper.getProductType(leg);

			switch(pType){

			case RCA:										
			case BOND:
			case OTHER:
			case EQUITY:
			case TERM_LOAN:
				entityObject = EntityHelper.searchEntityInLeg(leg, EntityType.ORIGINAL_BORROWER);
				break;
			case CPA:
				entityObject = EntityHelper.searchEntityInLeg(leg, EntityType.POOL_LEADER);
				break;					
			}

			if(entityObject!=null && entityObject.getFundHoldOperationId()!=null)
			{
				return entityObject.getFundHoldOperationId().toString();
			}

		}catch(Exception e)
		{
			return ICFPConstants.ZERO;
		}
		
		return ICFPConstants.ZERO;
	}
	
	/**
	 * getIncreaseOrDecrease
	 * @param legNumber
	 * @param request
	 * @return
	 */
	public static String getIncreaseOrDecrease(Integer legNumber, HttpServletRequest request){
		String resultFlag = null;
		Object leg = CurrentDealManager.getLegByNumber(legNumber, request);
		if (leg instanceof RCALegRequest) {
			if(((RCALegRequest) leg).getDayTwoOperations().getFacilityIncreaseDecrease().getFacilityTypeId() != null){
				resultFlag = ((RCALegRequest) leg).getDayTwoOperations().getFacilityIncreaseDecrease().getFacilityTypeId().toString();
			}else{
				resultFlag = "";
			}
		}
		return resultFlag;
	}
	
	/**
	 * get Value date format
	 * @param request
	 * @return
	 */
	public static  String getVaultID(HttpServletRequest request)
	{
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		if(deal!=null && deal.getVaultId()!=null && StringUtils.isNotEmpty(deal.getVaultId()))
		{
			return deal.getVaultId();
		}else{
			return "";
		}
	}
	
	/**
	 * 
	 * @param pattern
	 * @return
	 */
	public static DateFormat getDateFormat(String pattern) {
		Locale loc = new Locale("en","US");
		return new SimpleDateFormat(pattern, loc);
	}
	
	/**
	 * 
	 * @param date
	 * @param formatter
	 * @return
	 */
	public static String formatDate(XMLGregorianCalendar date, DateFormat formatter) {
		if(date == null) {
			return null;
		}
		return formatter.format(date.toGregorianCalendar().getTime());
	}
	
	/**
	 * getCrossBorderFlagValue used to retrieve crossBorderFlag.
	 * @param request HttpServletRequest
	 * @return resultFlag String
	 */
	public static String getOtherDescription(HttpServletRequest request) {
		
		
		String resultFlag = null;
		
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		
		
		List<Object> legs = (deal.getLegs() != null) ? deal.getLegs().getAllLegs() : null;
		if(legs != null && !legs.isEmpty()) {
			for(Object leg : legs) {	
				if(leg instanceof OtherLegRequest){
					resultFlag = ((OtherLegRequest) leg).getDescription();
				}
			}
		} else {
			resultFlag = "-";
		}
		return resultFlag;
	}
	/**
	 * fetchLegsWithoutImmediate used to retrieve legs other than immediateDrawDown.
	 * @param request HttpServletRequest
	 * @return legSummaryList List
	 */
	public static List<Object> fetchLegsWithoutImmediate(HttpServletRequest request) {
		List<Object> legSummaryList = new ArrayList<Object>();
		DealRequest dealRequest = CurrentDealManager.getCurrentDeal(request);
		if(dealRequest.getLegs()!=null && dealRequest.getLegs().getAllLegs()!=null){
			List<Object> legs = dealRequest.getLegs().getAllLegs();
			int count = 1;
			Object legSummary = null;
			String transEventName = null;
			for(Object eachLeg : legs) {
				legSummary = ICFPLegHelper.getLegSummary(eachLeg);
				transEventName = (legSummary instanceof CPASummary) ? ((CPASummary) legSummary).getTransactionEventType() 
						: ((LegSummary) legSummary).getTransactionEventType();
				if(StringUtils.isNotBlank(transEventName) && transEventName.contains(LEG_TYPE_IMMEDIATE_DRAWDOWN)) {
					count++;
					continue;
				}
				legSummaryList.add(fetchLegSummary(eachLeg, count++, request));
			}
			
		}
		return legSummaryList;
	}
	
	
	/**
	 * fetchTPLegs used to retrieve legs suitable for transfer pricing attachments.
	 * @param request HttpServletRequest
	 * @return legSummaryList List
	 */
	public static List<Object> fetchTPLegs(HttpServletRequest request) {
		List<Object> legSummaryList = new ArrayList<Object>();
		DealRequest dealRequest = CurrentDealManager.getCurrentDeal(request);
		Integer modelTypeId = null;
		if(dealRequest.getLegs()!=null && dealRequest.getLegs().getAllLegs()!=null){
			List<Object> legList = dealRequest.getLegs().getAllLegs();
			int count = 1;
			for(Object leg : legList) {
				String opcode = ICFPLegHelper.getOpCode(leg);
				if(opcode == null || !opcode.equals(DELETE)) {
					
					if(leg instanceof RCALegRequest) {
						RCALegRequest rcaLeg = (RCALegRequest) leg;
						modelTypeId = (rcaLeg.getTPLegRequest() != null) ? rcaLeg.getTPLegRequest().getModelTypeId() : null;
						if(modelTypeId != null && modelTypeId >= 2) {
							legSummaryList.add(fetchLegSummary(leg, count, request));
						}
						count++;
						continue;
					}
					if(leg instanceof CPALegRequest) {
						CPALegRequest cpaLeg = (CPALegRequest) leg;
						modelTypeId = (cpaLeg.getTPLegRequest() != null) ? cpaLeg.getTPLegRequest().getModelTypeId() : null;
						if(modelTypeId != null && modelTypeId >= 2) {
							legSummaryList.add(fetchLegSummary(leg, count, request));
						}
						count++;
						continue;
					}
					if(leg instanceof OtherLegRequest) {
						OtherLegRequest otherLeg = (OtherLegRequest) leg;
						modelTypeId = (otherLeg.getTPLegRequest() != null) ? otherLeg.getTPLegRequest().getModelTypeId() : null;
						if(modelTypeId != null && modelTypeId >= 2) {
							legSummaryList.add(fetchLegSummary(leg, count, request));
						}
						count++;
						continue;
					}
					if(leg instanceof EquityLegRequest){
						count++;
						continue;
					}
				}
			}
		}
		return legSummaryList;
	}
	
	/**
	 * 
	 * @param legIndex
	 * @param request
	 * @return
	 */
	public static List<ExceptionRequestForm> getExceptions(Integer legIndex, HttpServletRequest request) {
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		Object leg = ICFPCommonHelper.getLegByNumber(legIndex, deal);
		List<ExceptionRequestForm> allExceptions = ICFPLegHelper.getExceptions(leg);
		return ICFPLegHelper.filterDeletedExceptions(allExceptions);
	}
	
	/**
	 * 
	 * @param legIndex
	 * @param request
	 * @return
	 * @throws ICFPException
	 */
	public static List<Amendment> getAmendments(Integer legIndex, HttpServletRequest request) throws ICFPException {
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		Object leg = ICFPCommonHelper.getLegByNumber(legIndex, deal);
		List<Amendment> allAmendments = ICFPDay2LegHelper.getAmendments(leg);
		return ICFPDay2LegHelper.filterDeletedAmendments(allAmendments);
	}
	
	
	/**
	 * Return True if the logged in user SSO is available in pending TESGMemberList	
	 * @param ssoID
	 * @param request
	 * @return
	 */
	public static boolean isUserInTESGPending( HttpServletRequest request){
		
		HttpSession session = request.getSession(false);
		List<TesgList> pendingList = (List<TesgList>)session.getAttribute(TESG_MEMBER_LIST);
		
		String ssoID = SessionManager.getUserID(request);
	
		for(TesgList item: pendingList){			
			if(item.getSSOID().equals(ssoID) ){
				return true;
			}				
		}
		
		return false;		
	}
}
