/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: LegSummaryVO.java
 * Purpose: LegSummaryVO used for displaying Leg Summary Data.
 */
package com.ge.icfp.common.vo;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.datatype.XMLGregorianCalendar;

import com.ge.icfp.common.constants.ICFPConstants;
import com.ge.icfp.common.helper.ICFPDay2LegHelper;
import com.ge.icfp.model.Amendment;
import com.ge.icfp.model.DayTwoOperations;
import static com.ge.icfp.common.constants.ICFPConstants.*;
/**
 * @author arijit.biswas
 *
 */
public class Day2LegSummaryVO{

	private int legNumber;
	private DayTwoOperations dayTwoOperations;
	private HttpServletRequest request;
	
	/**
	 * Constructor
	 * @param legNumber 
	 * @param legSummary
	 * @param request
	 */
	public Day2LegSummaryVO(int legNumber, DayTwoOperations dayTwoOperations, HttpServletRequest request) {
		this.legNumber = legNumber;
		this.dayTwoOperations = dayTwoOperations;
		this.request = request; 
	}
	
	
	/**
	 * @return getIsNewLenderOrBorrowerFlag
	 */
	public Boolean getIsNewLenderOrBorrowerFlag() {
		return dayTwoOperations.getAssignment().isNewLenderOrBorrowerFlag();
	}
	
	/**
	 * @return getPandLAmount
	 */
	public Double getPandLAmount() {
		return dayTwoOperations.getAssignment().getPandLAmt();
	}
	
	/**
	 * @return getAmendmentMaturityDt
	 */
	public String getAmendmentMaturityDt() {
		if(dayTwoOperations.getAgreementExtension().getAmendmentMaturityDt()!=null){
			XMLGregorianCalendar date = dayTwoOperations.getAgreementExtension().getAmendmentMaturityDt();
			return new SimpleDateFormat(MM_DD_YYYY).format(((XMLGregorianCalendar)date).toGregorianCalendar().getTime()).toString();
		}
		return "";
	}
	
	/**
	 * @return getFacilityTypeId
	 */
	public Integer getFacilityTypeId() {
		return dayTwoOperations.getFacilityIncreaseDecrease().getFacilityTypeId();
	}
	
	/**
	 * @return getAmendedFacilityAmt
	 */
	public Double getAmendedFacilityAmt() {
		return dayTwoOperations.getFacilityIncreaseDecrease().getAmendedFacilityAmt();
	}
	
	/**
	 * @return getAmendedUSDEquivalentAmt
	 */
	public Double getAmendedUSDEquivalentAmt() {
		return dayTwoOperations.getFacilityIncreaseDecrease().getAmendedUSDEquivalentAmt();
	}
	
	/**
	 * @return getBrokerageCostAmt
	 */
	public Double getBrokerageCostAmt() {
		return dayTwoOperations.getTermination().getBrokerageCostAmt();
	}
	
	/**
	 * @return getDebtEquityOtherComments
	 */
	public String getDebtEquityOtherComments() {
		return dayTwoOperations.getCorrection().getDebtEquityOtherComments();
	}
	
	/**
	 * @return getIsDrawdownNoticeAttachedFlag
	 */
	public Boolean getIsDrawdownNoticeAttachedFlag() {
		return dayTwoOperations.getDrawDown().isDrawdownNoticeAttachedFlag();
	}
	
	/**
	 * @return getDrawdownValueDt
	 */
	public String getDrawdownValueDt() {
		if(dayTwoOperations.getDrawDown()!=null){
			return dayTwoOperations.getDrawDown().getDrawdownValueDt().toString();
		}else{
			return "";
		}
	}
	
	/**
	 * @return getDrawdownAmt
	 */
	public Double getDrawdownAmt() {
		return dayTwoOperations.getDrawDown().getDrawdownAmt();
	}
	
	/**
	 * @return isPrepaymentNoticeAttachedFlag
	 */
	public Boolean getIsPrepaymentNoticeAttachedFlag() {
		return dayTwoOperations.getPrePayment().isPrepaymentNoticeAttachedFlag();
	}
	
	/**
	 * @return getProblemStatement
	 */
	public String getProblemStatement() {
		return dayTwoOperations.getCorrection().getProblemStatement();
	}
	
	/**
	 * @return getCorrectionNeededComments
	 */
	public String getCorrectionNeededComments() {
		return dayTwoOperations.getCorrection().getCorrectionNeededComments();
	}
	
	/**
	 * @return getActionNeededByDt
	 */
	public String getActionNeededByDt() {
		if(dayTwoOperations.getCorrection().getActionNeededByDt()!=null){
			XMLGregorianCalendar date = dayTwoOperations.getCorrection().getActionNeededByDt();
			return new SimpleDateFormat(MM_DD_YYYY).format(((XMLGregorianCalendar)date).toGregorianCalendar().getTime()).toString();
		}
		return "";
	}
	
	/**
	 * @return getCurrentCPAAttachedFlag
	 */
	public String getCurrentCPAAttachedFlag() {
		if(dayTwoOperations.getCPATermination().getCurrentCPAAttachedFlag() != null ){
			if(dayTwoOperations.getCPATermination().getCurrentCPAAttachedFlag().equalsIgnoreCase(ICFPConstants.Y_CAP)){
				return YES_CAP;
			}else{
				return NO_CAP;
			}
		} else {
			return "";
		}
		
	}
	
	/**
	 * @return getTerminationNoticeAttachedFlag
	 */
	public String getTerminationNoticeAttachedFlag() {
		if(dayTwoOperations.getCPATermination().getTerminationNoticeAttachedFlag() != null ){
			if(dayTwoOperations.getCPATermination().getTerminationNoticeAttachedFlag().equalsIgnoreCase(ICFPConstants.Y_CAP)){
				return YES_CAP;
			}else{
				return NO_CAP;
			}
		} else {
			return "";
		}
	}
	
	/**
	 * @return getTerminationDt
	 */
	public String getTerminationDt() {
		if(dayTwoOperations.getCPATermination().getTerminationDt()!=null){
			XMLGregorianCalendar date = dayTwoOperations.getCPATermination().getTerminationDt();
			return new SimpleDateFormat(MM_DD_YYYY).format(((XMLGregorianCalendar)date).toGregorianCalendar().getTime()).toString();
		}
		return "";
	}
	
	/**
	 * @return getSettlementDetailsComments
	 */
	public String getSettlementDetailsComments() {
		return dayTwoOperations.getCPATermination().getSettlementDetailsComments();
	}
	
	/**
	 * @return getOtherDetailsComments
	 */
	public String getOtherDetailsComments() {
		return dayTwoOperations.getCPATermination().getOtherDetailsComments();
	}
	
	/**
	 * @return getFacilityIncDecAmt
	 */
	public Double getFacilityIncDecAmt() {
		return dayTwoOperations.getFacilityIncreaseDecrease().getFacilityIncDecAmt();
	}
	
	/**
	 * @return getFacilityIncDecUSDEquivalentAmt
	 */
	public Double getFacilityIncDecUSDEquivalentAmt() {
		return dayTwoOperations.getFacilityIncreaseDecrease().getFacilityIncDecUSDEquivalentAmt();
	}
	
	/**
	 * 
	 * @return List<Amendment>
	 */
	public List<Amendment> getAmendments() {
		return ICFPDay2LegHelper.filterDeletedAmendments(dayTwoOperations.getAmendments());
	}
}
