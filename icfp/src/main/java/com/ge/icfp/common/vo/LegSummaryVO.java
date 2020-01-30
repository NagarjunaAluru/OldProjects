/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: LegSummaryVO.java
 * Purpose: LegSummaryVO used for displaying Leg Summary Data.
 */
package com.ge.icfp.common.vo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.lang.StringUtils;

import com.ge.icfp.action.ICFPException;
import com.ge.icfp.common.helper.CurrentDealManager;
import com.ge.icfp.common.helper.EntityHelper;
import com.ge.icfp.common.helper.ICFPCommonHelper;
import com.ge.icfp.common.helper.ICFPLegHelper;
import com.ge.icfp.model.DayTwoOperations;
import com.ge.icfp.model.DerivativesRequest;
import com.ge.icfp.model.Entity;
import com.ge.icfp.model.ExceptionRequestForm;
import com.ge.icfp.model.FacilityIncreaseDecrease;
import com.ge.icfp.model.LegSummary;
import com.ge.icfp.model.QualitativeFactors;
import com.ge.icfp.newrequest.form.vo.DerivativeDetailsVO;
import com.ge.icfp.util.Utils;
import com.ge.icfp.util.report.pdf.PDFReportHelper;
import com.hydus.wff.core.exception.HWFServiceException;
import com.hydus.wff.core.exception.HWFStubException;
import static com.ge.icfp.common.constants.ICFPConstants.*;
/**
 * @author arijit.biswas
 *
 */
public class LegSummaryVO{

	private int legNumber;
	private LegSummary legSummary;
	private EquityLegSummary equityLegSummary;
	private HttpServletRequest request;
	private Entity lenderEntity;
	private Entity borrowerEntity;
	private Entity newLenderEntity;
	private Entity newBorrowerEntity;
	private Entity payorEntity;
	
	/**
	 * Constructor
	 * @param legNumber 
	 * @param legSummary
	 * @param request
	 */
	public LegSummaryVO(int legNumber, LegSummary legSummary, HttpServletRequest request) {
		this.legNumber = legNumber;
		this.legSummary = legSummary;
		this.request = request; 
	}
	/**
	 * 
	 * @return {@link String}
	 */
	
	public String getDrawDown() {
		return legSummary.getDrawDown();
	}
	/**
	 * 
	 * @return legNumber
	 */
	public int getLegNo() {
		return legNumber;
	}
	/**
	 * 
	 * @return legNumber
	 */
	public int getLegNumber() {
		return legNumber;
	}
	/**
	 * 
	 * @return legSeqId
	 */
	public Integer getLegSeqId() {
		return legSummary.getLegSeqId();
	}

	/**
	 * 
	 * @return productType
	 */
	public String getProductType() {
		return legSummary.getProductType();
	}
	
	/**
	 * @return legNumber
	 */
	public Double getFees() {
		return legSummary.getFees();
	}
	
	/**
	 * 
	 * @return productType
	 */
	public Boolean getIsEventNoticeAttachedFlag() {
		return legSummary.isEventNoticeAttachedFlag();
	}
	
	/**
	 * 
	 * @return getGrossSettlementAmt
	 */
	public Double getGrossSettlementAmt() {
		return legSummary.getGrossSettlementAmt();
	}
	
	
	/**
     * Gets the value of the transactionEventType property.
     * @return transactionEventType
     */
    public String getTransactionEventType() {
        return legSummary.getTransactionEventType();
    }
	
    
    public Integer getTransactionEventTypeId() {
        return legSummary.getTransactionEventTypeId();
    }
	/**
	 * 
	 * @return termInMonths
	 */
	public Integer getTermsInMths() {
		return legSummary.getTermInMonths();
	}
	
	/**
	 * @return getdayOneCCY
	 */
	public String getDayOneCCY() {
		return legSummary.getDayOneCCY();
	}
	
	/**
	 * @return getdayOneCCYAmount
	 */
	public Double getDayOneCCYAmount() {
		return legSummary.getDayOneCCYAmount();
	}
	
	/**
	 * @return getdayOneUSD
	 */
	public Double getDayOneUSD() {
		return legSummary.getDayOneUSDEquivalent();
	}
	/**
	 * @return getdayOneCCYAmount
	 */
	public String getDayOneCCYAmount1() {
		if(legSummary.getDayOneCCYAmount()!=null){
			return PDFReportHelper.formatCurrency(legSummary.getDayOneCCYAmount());
		}else {
			return "";
		}
	}
	
	/**
	 * @return getdayOneUSD
	 */
	public String getDayOneUSD1() {
		if(legSummary.getDayOneUSDEquivalent()!=null){
			return PDFReportHelper.formatCurrency(legSummary.getDayOneUSDEquivalent());
		}else {
			return "";
		}
	}
	
	/**
	 * @return getOriginalLegalAgreementsFlag
	 */
	public String getOriginalLegalAgreementsFlag() {
		return legSummary.getOriginalLegalAgreementsFlag();
	}
	
	/**
	 * @return getIsHedgedFlag
	 */
	public String getIsHedgedFlag() {
		return legSummary.getIsHedgedFlag();
	}
	
	/**
	 * @return getAccruedInterestAmt
	 */
	public Double getAccruedInterestAmt() {
		return legSummary.getAccruedInterestAmt();
	}
	
	/**
	 * @return getAccruedInterestAmt
	 */
	public String  getAccruedInterestAmt1() {
		if(legSummary.getAccruedInterestAmt()!=null){
		return PDFReportHelper.formatCurrency(legSummary.getAccruedInterestAmt());
	}else {
		return "";
	}
	}
	/**
	 * @return getisNonStandardAgreementsFlag
	 */
	public Boolean getIsNonStandardAgreementsFlag() {
		return legSummary.isNonStandardAgreementsFlag();
	}
	
	/**
	 * @return isSubordinatedDebt
	 */
	public Boolean getIsSubordinatedDebt() {
		return legSummary.isSubordinatedDebt();
	}
	
	/**
	 * @return getMaturityDt
	 */
	public String getMaturityDt() {
		if(legSummary.getMaturityDt()!=null){
			XMLGregorianCalendar date = legSummary.getMaturityDt();
			return new SimpleDateFormat(MM_DD_YYYY).format(((XMLGregorianCalendar)date).toGregorianCalendar().getTime()).toString();
		}
		return "";
	}
	
	/**
	 * 
	 * @return getLegTypeId
	 * @throws ICFPException 
	 */
	public Integer getLegTypeId() throws ICFPException {
			return legSummary.getLegTypeId();
	}
	
	/**
	 * 
	 * @return getIssuePrice
	 * @throws ICFPException 
	 */
	public Double getIssuePrice() throws ICFPException {
		  if(legSummary==null || legSummary.getIssuePrice()==null)
		  {
			  return null;
		  }else{
			return legSummary.getIssuePrice();
		  }	
	}
	
	/**
	 * 
	 * @return getAgentDealerCommission
	 * @throws ICFPException 
	 */
	public Double getAgentDealerCommission() throws ICFPException {
		  if(legSummary==null || legSummary.getAgentDealerCommission()==null)
		  {
			  return null;
		  }else{
			return legSummary.getAgentDealerCommission();
		  }	
	}
	
	/**
	 * 
	 * @return getNetProceeds
	 * @throws ICFPException 
	 */
	public String getNetProceedsAmt() throws ICFPException {
		  if(legSummary==null || legSummary.getNetProceedsAmt()==null)
		  {
			  return null;
		  }else{
			  
			return ICFPCommonHelper.formatNegativeCurrency(legSummary.getNetProceedsAmt().toString());
		  }	
	}
	
	/**
	 * 
	 * @return
	 * @throws ICFPException 
	 */
	public String getLenderLegalEntitySetupFlag() throws ICFPException {
		Entity lenderEntity = getLenderEntity();
		String result = null;
		if(lenderEntity != null) {
			result = PDFReportHelper.convertYOrNToYesOrNo(lenderEntity.getEntitySetupFlag());
		}
		return (result != null) ? result : "-";
	}
	
	/**
	 * 
	 * @return
	 * @throws ICFPException 
	 */
	public String getBorrowerLegalEntitySetupFlag() throws ICFPException {
		Entity lenderEntity = getBorrowerEntity();
		String result = null;
		if(lenderEntity != null) {
			result = PDFReportHelper.convertYOrNToYesOrNo(lenderEntity.getEntitySetupFlag());
		}
		return (result != null) ? result : "-";
	}
	
	/**
	 * 
	 * @return
	 * @throws ICFPException 
	 */
	public String getLenderRequlatedEntity() throws ICFPException {
		Entity lenderEntity = getLenderEntity();
		String result = null;
		if(lenderEntity != null) {
			result = PDFReportHelper.convertBooleanAsYesOrNo(lenderEntity.isRegulatedEntityFlag());
		}
		return (result != null) ? result : "-";
	}
	
	/**
	 * 
	 * @return
	 * @throws ICFPException 
	 */
	public String getBorrowerRequlatedEntity() throws ICFPException {
		Entity lenderEntity = getBorrowerEntity();
		String result = null;
		if(lenderEntity != null) {
			result = PDFReportHelper.convertBooleanAsYesOrNo(lenderEntity.isRegulatedEntityFlag());
		}
		return (result != null) ? result : "-";
	}
	
	/**
	 * 
	 * @return
	 * @throws ICFPException 
	 */
	public String getLenderPrincipalEntity() throws ICFPException {
		Entity lenderEntity = getLenderEntity();
		String result = null;
		if(lenderEntity != null) {
			result = PDFReportHelper.convertBooleanAsYesOrNo(lenderEntity.isPrincplEntityFlag());
		}
		return (result != null) ? result : "-";
	}
	
	/**
	 * 
	 * @return
	 * @throws ICFPException 
	 */
	public String getBorrowerPrincipalEntity() throws ICFPException {
		Entity lenderEntity = getBorrowerEntity();
		String result = null;
		if(lenderEntity != null) {
			result = PDFReportHelper.convertBooleanAsYesOrNo(lenderEntity.isPrincplEntityFlag());
		}
		return (result != null) ? result : "-";
	}
	
	/**
	 * 
	 * @return lenderLegalEntity
	 * @throws ICFPException 
	 */
	public String getLenderLegalEntity() throws ICFPException {
		Entity lenderEntity = getLenderEntity();
		if(lenderEntity != null) {
			return lenderEntity.getLEGoldId();
		}
		return null;
	}
	
	/**
	 * get Lender CDR
	 * @return
	 * @throws ICFPException 
	 */
	public String getLenderCDR() throws ICFPException {
		Entity lenderEntity = getLenderEntity();
		if(lenderEntity != null) {
			return lenderEntity.getCDRCd();
		}
		return null;
	}
	
	/**
	 * 
	 * @return lenderCountry
	 * @throws ICFPException 
	 */
	public String getLenderCountry() throws ICFPException {
		Entity lenderEntity = getLenderEntity();
		if(lenderEntity != null) {
			return lenderEntity.getCountry();
		}
		return null;
	}
	
	/**
	 * @return
	 * @throws ICFPException
	 */
	public String getLenderLEName() throws ICFPException {
		Entity lenderEntity = getLenderEntity();
		if(lenderEntity != null) {
			return lenderEntity.getLEName();
		}
		return null;
	}

	/**
	 * @return
	 * @throws ICFPException
	 */
	public String getEntitySetupFlag() throws ICFPException {
		Entity lenderEntity = getLenderEntity();
		if(lenderEntity != null) {
			return lenderEntity.getEntitySetupFlag();
		}
		return null;
	}

	/**
	 * 
	 * @return
	 * @throws ICFPException
	 */
	public String getLenderMEName() throws ICFPException {
		Entity lenderEntity = getLenderEntity();
		if(lenderEntity != null && lenderEntity.getMeGoldId()!=null) {
			return lenderEntity.getMeGoldId();
		}
		return null;
	}
	
	
	/**
	 * getLenderRegulated
	 * @return
	 * @throws ICFPException
	 */
	public String getLenderRegulated() throws ICFPException {
		Entity lenderEntity = getLenderEntity();
		if(lenderEntity != null) {
			if(lenderEntity.isRegulatedEntityFlag()!=null && lenderEntity.isRegulatedEntityFlag()){
				return YES_CAP;
			}else{
				return NO_CAP;
			}
		}
		return null;
	}
	
	
	/**
	 * getLenderPrincipal
	 * @return
	 * @throws ICFPException
	 */
	public String getLenderPrincipal() throws ICFPException {
		Entity lenderEntity = getLenderEntity();
		if(lenderEntity != null) {
			if(lenderEntity.isPrincplEntityFlag()!=null && lenderEntity.isPrincplEntityFlag()){
				return YES_CAP;
			}else{
				return NO_CAP;
			}
		}
		return null;
	}
	
	/**
	 * getLenderCapital
	 * @return
	 * @throws ICFPException
	 */
	public String getLenderCapital() throws ICFPException {
		Entity lenderEntity = getLenderEntity();
		if(lenderEntity != null) {
			return lenderEntity.getCapitalIndustrial();
		}
		return null;
	}
	
	/**
	 * getBusinessSegment
	 * @return
	 * @throws ICFPException
	 */
	public String getLenderBusinessSegment() throws ICFPException {
		Entity lenderEntity = getLenderEntity();
		if(lenderEntity != null) {
			return lenderEntity.getBusinessSegment();
		}
		return null;
	}
	
	/**
	 * 
	 * @return
	 * @throws ICFPException
	 */
	public String getLenderTCode() throws ICFPException {
		Entity lenderEntity = getLenderEntity();
		if(lenderEntity != null) {
			return (lenderEntity.getTreasuryCodes().isEmpty()) ? null : lenderEntity.getTreasuryCodes().get(0);
		}
		return null;
	}
	
	/**
	 * 
	 * @return borrowerCountry
	 * @throws ICFPException 
	 */
	public String getLenderFCHC() throws ICFPException {
		Entity lenderEntity = getLenderEntity();
		if(lenderEntity != null && lenderEntity.getFundHoldOperation()!=null) {
			return lenderEntity.getFundHoldOperation().toString();
		}
		return "";
	}
	
	/**
	 * 
	 * @return lenderLegalEntity
	 * @throws ICFPException 
	 */
	public String getNewLenderLegalEntity() throws ICFPException {
		Entity newLenderEntity = getNewLenderEntity();
		if(newLenderEntity != null) {
			return newLenderEntity.getLEGoldId();
		}
		return null;
	}
	
	/**
	 * get Lender CDR
	 * @return
	 * @throws ICFPException 
	 */
	public String getNewLenderCDR() throws ICFPException {
		Entity newLenderEntity = getNewLenderEntity();
		if(newLenderEntity != null) {
			return newLenderEntity.getCDRCd();
		}
		return null;
	}
	
	/**
	 * 
	 * @return lenderCountry
	 * @throws ICFPException 
	 */
	public String getNewLenderCountry() throws ICFPException {
		Entity newLenderEntity = getNewLenderEntity();
		if(newLenderEntity != null) {
			return newLenderEntity.getCountry();
		}
		return null;
	}
	
	/**
	 * 
	 * @return
	 * @throws ICFPException
	 */
	public String getNewLenderLEName() throws ICFPException {
		Entity newLenderEntity = getNewLenderEntity();
		if(newLenderEntity != null) {
			return newLenderEntity.getLEName();
		}
		return null;
	}
	
	/**
	 * @return
	 * @throws ICFPException
	 */
	public String getNewLenderEntitySetupFlag() throws ICFPException {
		Entity newLenderEntity = getNewLenderEntity();
		if(newLenderEntity != null) {
			return newLenderEntity.getEntitySetupFlag();
		}
		return null;
	}

	/**
	 * 
	 * @return
	 * @throws ICFPException
	 */
	public String getNewLenderMEName() throws ICFPException {
		Entity newLenderEntity = getNewLenderEntity();
		if(newLenderEntity != null && newLenderEntity.getMeGoldId()!=null) {
			return newLenderEntity.getMeGoldId();
		}
		return null;
	}
	
	
	/**
	 * getLenderRegulated
	 * @return
	 * @throws ICFPException
	 */
	public String getNewLenderRegulated() throws ICFPException {
		Entity newLenderEntity = getNewLenderEntity();
		if(newLenderEntity != null && newLenderEntity.isRegulatedEntityFlag()!=null) {
			if(newLenderEntity.isRegulatedEntityFlag()){
				return YES_CAP;
			}else{
				return NO_CAP;
			}
		}
		return null;
	}
	
	
	/**
	 * getLenderPrincipal
	 * @return
	 * @throws ICFPException
	 */
	public String getNewLenderPrincipal() throws ICFPException {
		Entity newLenderEntity = getNewLenderEntity();
		if(newLenderEntity != null && newLenderEntity.isPrincplEntityFlag()!=null) {
			if(newLenderEntity.isPrincplEntityFlag()){
				return YES_CAP;
			}else{
				return NO_CAP;
			}
		}
		return null;
	}
	
	/**
	 * getLenderCapital
	 * @return
	 * @throws ICFPException
	 */
	public String getNewLenderCapital() throws ICFPException {
		Entity newLenderEntity = getNewLenderEntity();
		if(newLenderEntity != null) {
			return newLenderEntity.getCapitalIndustrial();
		}
		return null;
	}
	
	/**
	 * getBusinessSegment
	 * @return
	 * @throws ICFPException
	 */
	public String getNewLenderBusinessSegment() throws ICFPException {
		Entity newLenderEntity = getNewLenderEntity();
		if(newLenderEntity != null) {
			return newLenderEntity.getBusinessSegment();
		}
		return null;
	}
	
	/**
	 * 
	 * @return
	 * @throws ICFPException
	 */
	public String getNewLenderTCode() throws ICFPException {
		Entity newLenderEntity = getNewLenderEntity();
		if(newLenderEntity != null) {
			return (newLenderEntity.getTreasuryCodes().isEmpty()) ? null : newLenderEntity.getTreasuryCodes().get(0);
		}
		return null;
	}
	
	/**
	 * 
	 * @return borrowerCountry
	 * @throws ICFPException 
	 */
	public String getNewLenderFCHC() throws ICFPException {
		Entity newLenderEntity = getNewLenderEntity();
		if(newLenderEntity != null && newLenderEntity.getFundHoldOperation()!=null) {
			return newLenderEntity.getFundHoldOperation().toString();
		}
		
		return "";
	}
	
	/**
	 * 
	 * @return borrowerLegalEntity
	 * @throws ICFPException 
	 */
	public String getBorrowerLegalEntity() throws ICFPException {
		Entity borrowerEntity = getBorrowerEntity();
		if(borrowerEntity != null) {
			return borrowerEntity.getLEGoldId();
		}
		return null;
	}
	/**
	 * 
	 * @return borrowerCountry
	 * @throws ICFPException 
	 */
	public String getBorrowerCountry() throws ICFPException {
		Entity borrowerEntity = getBorrowerEntity();
		if(borrowerEntity != null) {
			return borrowerEntity.getCountry();
		}
		return null;
	}
	
	/**
	 * @return
	 * @throws ICFPException
	 */
	public String getBorEntitySetupFlag() throws ICFPException {
		Entity borrowerEntity = getBorrowerEntity();
		if(borrowerEntity != null) {
			return borrowerEntity.getEntitySetupFlag();
		}
		return null;
	}

	
	/**
	 * Get Borrower CDR
	 * @return
	 * @throws ICFPException 
	 */
	public String getBorrowerCDR() throws ICFPException {
		Entity borrowerEntity = getBorrowerEntity();
		if(borrowerEntity != null) {
			return borrowerEntity.getCDRCd();
		}
		return null;
	}
	/**
	 * 
	 * @return
	 * @throws ICFPException 
	 */
	public String getBorrowerTCode() throws ICFPException {
		Entity borrowerEntity = getBorrowerEntity();
		if(borrowerEntity != null) {
			return (borrowerEntity.getTreasuryCodes().isEmpty()) ? null : borrowerEntity.getTreasuryCodes().get(0);
		}
		return null;
	}
	
	/**
	 * 
	 * @return
	 * @throws ICFPException
	 */
	public String getBorrowerLEName() throws ICFPException {
		Entity borrowerEntity = getBorrowerEntity();
		if(borrowerEntity != null) {
			return borrowerEntity.getLEName();
		}
		return null;
	}
	
	/**
	 * getBorrowerRegulated
	 * @return
	 * @throws ICFPException
	 */
	public String getBorrowerRegulated() throws ICFPException {
		Entity borrowerEntity = getBorrowerEntity();
		if(borrowerEntity != null) {
			if(borrowerEntity.isRegulatedEntityFlag()!=null && borrowerEntity.isRegulatedEntityFlag()){
				return YES_CAP;
			}else{
				return NO_CAP;
			}
		}
		return null;
	}
	
	/**
	 * getBorrowerPrincipal
	 * @return
	 * @throws ICFPException
	 */
	public String getBorrowerPrincipal() throws ICFPException {
		Entity borrowerEntity = getBorrowerEntity();
		if(borrowerEntity != null) {
			if(borrowerEntity.isPrincplEntityFlag()!=null && borrowerEntity.isPrincplEntityFlag()){
				return YES_CAP;
			}else{
				return NO_CAP;
			}
		}
		return null;
	}
	
	/**
	 * getBorrowerMEName
	 * @return
	 * @throws ICFPException 
	 */
	public String getBorrowerMEName() throws ICFPException {
		Entity borrowerEntity = getBorrowerEntity();
		if(borrowerEntity != null && borrowerEntity.getMeGoldId()!=null) {
			return borrowerEntity.getMeGoldId();
		}
		return null;
	}
	
	/**
	 * getBorrowerCapital
	 * @return
	 * @throws ICFPException
	 */
	public String getBorrowerCapital() throws ICFPException {
		Entity borrowerEntity = getBorrowerEntity();
		if(borrowerEntity != null) {
			return borrowerEntity.getCapitalIndustrial();
		}
		return null;
	}
	
	/**
	 * getBorrowerBusSegment
	 * @return
	 * @throws ICFPException
	 */
	public String getBorrowerBusSegment() throws ICFPException {
		Entity borrowerEntity = getBorrowerEntity();
		if(borrowerEntity != null) {
			return borrowerEntity.getBusinessSegment();
		}
		return null;
	}
	
	
	/**
	 * getBorrowerFCHC
	 * @return
	 * @throws ICFPException
	 */
	public String getBorrowerFCHC() throws ICFPException {
		Entity borrowerEntity = getBorrowerEntity();
		if(borrowerEntity != null && borrowerEntity.getFundHoldOperation()!=null) {
			return borrowerEntity.getFundHoldOperation();
		}
		return "";
	}
	
	/**
	 * 
	 * @return borrowerLegalEntity
	 * @throws ICFPException 
	 */
	public String getNewBorrowerLegalEntity() throws ICFPException {
		Entity newBorrowerEntity = getNewBorrowerEntity();
		if(newBorrowerEntity != null) {
			return newBorrowerEntity.getLEGoldId();
		}
		return null;
	}
	/**
	 * 
	 * @return borrowerCountry
	 * @throws ICFPException 
	 */
	public String getNewBorrowerCountry() throws ICFPException {
		Entity newBorrowerEntity = getNewBorrowerEntity();
		if(newBorrowerEntity != null) {
			return newBorrowerEntity.getCountry();
		}
		return null;
	}
	
	
	
	/**
	 * Get Borrower CDR
	 * @return
	 * @throws ICFPException 
	 */
	public String getNewBorrowerCDR() throws ICFPException {
		Entity newBorrowerEntity = getNewBorrowerEntity();
		if(newBorrowerEntity != null) {
			return newBorrowerEntity.getCDRCd();
		}
		return null;
	}
	/**
	 * 
	 * @return
	 * @throws ICFPException 
	 */
	public String getNewBorrowerTCode() throws ICFPException {
		Entity newBorrowerEntity = getNewBorrowerEntity();
		if(newBorrowerEntity != null) {
			return (newBorrowerEntity.getTreasuryCodes().isEmpty()) ? null : newBorrowerEntity.getTreasuryCodes().get(0);
		}
		return null;
	}
	
	/**
	 * @return
	 * @throws ICFPException
	 */
	public String getNewBorEntitySetupFlag() throws ICFPException {
		Entity borrowerEntity = getNewBorrowerEntity();
		if(borrowerEntity != null) {
			return borrowerEntity.getEntitySetupFlag();
		}
		return null;
	}
	
	/**
	 * 
	 * @return
	 * @throws ICFPException
	 */
	public String getNewBorrowerLEName() throws ICFPException {
		Entity newBorrowerEntity = getNewBorrowerEntity();
		if(newBorrowerEntity != null) {
			return newBorrowerEntity.getLEName();
		}
		return null;
	}
	
	/**
	 * getBorrowerRegulated
	 * @return
	 * @throws ICFPException
	 */
	public String getNewBorrowerRegulated() throws ICFPException {
		Entity newBorrowerEntity = getNewBorrowerEntity();
		if(newBorrowerEntity != null) {
			if(newBorrowerEntity.isRegulatedEntityFlag()!=null && newBorrowerEntity.isRegulatedEntityFlag()){
				return YES_CAP;
			}else{
				return NO_CAP;
			}
		}
		return null;
	}
	
	/**
	 * getBorrowerPrincipal
	 * @return
	 * @throws ICFPException
	 */
	public String getNewBorrowerPrincipal() throws ICFPException {
		Entity newBorrowerEntity = getNewBorrowerEntity();
		if(newBorrowerEntity != null) {
			if(newBorrowerEntity.isPrincplEntityFlag()!=null && newBorrowerEntity.isPrincplEntityFlag()){
				return YES_CAP;
			}else{
				return NO_CAP;
			}
		}
		return null;
	}
	
	/**
	 * getBorrowerMEName
	 * @return
	 * @throws ICFPException 
	 */
	public String getNewBorrowerMEName() throws ICFPException {
		Entity newBorrowerEntity = getNewBorrowerEntity();
		if(newBorrowerEntity != null && newBorrowerEntity.getMeGoldId()!=null) {
			return newBorrowerEntity.getMeGoldId();
		}
		return null;
	}
	
	/**
	 * getBorrowerCapital
	 * @return
	 * @throws ICFPException
	 */
	public String getNewBorrowerCapital() throws ICFPException {
		Entity newBorrowerEntity = getNewBorrowerEntity();
		if(newBorrowerEntity != null) {
			return newBorrowerEntity.getCapitalIndustrial();
		}
		return null;
	}
	
	/**
	 * getBorrowerBusSegment
	 * @return
	 * @throws ICFPException
	 */
	public String getNewBorrowerBusSegment() throws ICFPException {
		Entity newBorrowerEntity = getNewBorrowerEntity();
		if(newBorrowerEntity != null) {
			return newBorrowerEntity.getBusinessSegment();
		}
		return null;
	}
	
	/**
	 * getBorrowerFCHC
	 * @return
	 * @throws ICFPException
	 */
	public String getNewBorrowerFCHC() throws ICFPException {
		Entity newBorrowerEntity = getNewBorrowerEntity();
		if(newBorrowerEntity != null && newBorrowerEntity.getFundHoldOperation()!=null) {
			return newBorrowerEntity.getFundHoldOperation();
		}
		return "";
	}
	
	/**
	 * 
	 * @return borrowerLegalEntity
	 * @throws ICFPException 
	 */
	public String getPayorLegalEntity() throws ICFPException {
		Entity payorEntity = getPayorEntity();
		if(payorEntity != null) {
			return payorEntity.getLEGoldId();
		}
		return null;
	}
	/**
	 * 
	 * @return borrowerCountry
	 * @throws ICFPException 
	 */
	public String getPayorCountry() throws ICFPException {
		Entity payorEntity = getPayorEntity();
		if(payorEntity != null) {
			return payorEntity.getCountry();
		}
		return null;
	}
	
	
	
	/**
	 * Get Borrower CDR
	 * @return
	 * @throws ICFPException 
	 */
	public String getPayorCDR() throws ICFPException {
		Entity payorEntity = getPayorEntity();
		if(payorEntity != null) {
			return payorEntity.getCDRCd();
		}
		return null;
	}
	/**
	 * 
	 * @return
	 * @throws ICFPException 
	 */
	public String getpayorTCode() throws ICFPException {
		Entity payorEntity = getPayorEntity();
		if(payorEntity != null) {
			return (payorEntity.getTreasuryCodes().isEmpty()) ? null : payorEntity.getTreasuryCodes().get(0);
		}
		return null;
	}
	
	/**
	 * 
	 * @return
	 * @throws ICFPException
	 */
	public String getPayorLEName() throws ICFPException {
		Entity payorEntity = getPayorEntity();
		if(payorEntity != null) {
			return payorEntity.getLEName();
		}
		return null;
	}
	
	/**
	 * @return
	 * @throws ICFPException
	 */
	public String getPayorEntitySetupFlag() throws ICFPException {
		Entity payorEntity = getPayorEntity();
		if(payorEntity != null) {
			return payorEntity.getEntitySetupFlag();
		}
		return null;
	}
	
	/**
	 * getBorrowerRegulated
	 * @return
	 * @throws ICFPException
	 */
	public String getPayorRegulated() throws ICFPException {
		Entity payorEntity = getPayorEntity();
		if(payorEntity != null && payorEntity.isRegulatedEntityFlag()!=null) {
			if(payorEntity.isRegulatedEntityFlag()){
				return YES_CAP;
			}else{
				return NO_CAP;
			}
		}
		return null;
	}
	
	/**
	 * getBorrowerPrincipal
	 * @return
	 * @throws ICFPException
	 */
	public String getPayorPrincipal() throws ICFPException {
		Entity payorEntity = getPayorEntity();
		if(payorEntity != null && payorEntity.isPrincplEntityFlag()!=null) {
			if(payorEntity.isPrincplEntityFlag()){
				return YES_CAP;
			}else{
				return NO_CAP;
			}
		}
		return null;
	}
	
	/**
	 * getBorrowerMEName
	 * @return
	 * @throws ICFPException 
	 */
	public String getPayorMEName() throws ICFPException {
		Entity payorEntity = getPayorEntity();
		if(payorEntity != null && payorEntity.getMeGoldId()!=null) {
			return payorEntity.getMeGoldId();
		}
		return null;
	}
	
	/**
	 * getBorrowerCapital
	 * @return
	 * @throws ICFPException
	 */
	public String getpayorCapital() throws ICFPException {
		Entity payorEntity = getPayorEntity();
		if(payorEntity != null) {
			return payorEntity.getCapitalIndustrial();
		}
		return null;
	}
	
	/**
	 * getBorrowerBusSegment
	 * @return
	 * @throws ICFPException
	 */
	public String getPayorBusSegment() throws ICFPException {
		Entity payorEntity = getPayorEntity();
		if(payorEntity != null) {
			return payorEntity.getBusinessSegment();
		}
		return null;
	}
	
	/**
	 * getBorrowerFCHC
	 * @return
	 * @throws ICFPException
	 */
	public String getPayorFCHC() throws ICFPException {
		Entity payorEntity = getPayorEntity();
		if(payorEntity != null) {
			return payorEntity.getFundHoldOperation();
		}
		return null;
	}
	
	/**
	 * 
	 * @return originalCurrency
	 */
	public String getOriginalCurrency() {
		if(!"".equals(legSummary.getOriginalCCY()) && legSummary.getOriginalCCY()!=null){
			return legSummary.getOriginalCCY();
		}else {
			return "";
		}
	}

	/**
	 * 
	 * @return originalAmount
	 */
	public String getOriginalAmount() {
		if(legSummary.getOriginalCCYAmount()!=null){
			return PDFReportHelper.formatCurrency(legSummary.getOriginalCCYAmount());
		}else {
			return "";
		}
	}

	/**
	 * 
	 * @return usdEquivalent
	 */
	public String getUsdEquivalent() {
		if(legSummary.getUSDEquivalent()!=null){
			return PDFReportHelper.formatCurrency(legSummary.getUSDEquivalent());
		}else{
			return "";
		}
	}

	/**
	 * 
	 * @return derivatives
	 */
	public String getDerivatives() {
		if(legSummary.isDerivativesFlag() != null && legSummary.isDerivativesFlag() == true){
			return YES_CAP;
		}else{
			return NO_CAP;
		}
	}
	/**
	 * 
	 * @return existing
	 */
	public String getExisting() {
		
		if(legSummary.isExistingFlag() != null && legSummary.isExistingFlag() == true){
			return YES_CAP;
		}else{
			return NO_CAP;
		}
	}
	/**
	 * 
	 * @return
	 */
	public List<QualitativeFactors> getQualitativeFactorsList() {
		return legSummary.getQualitativeFactors();
	}
	/**
	 * 
	 * @return List<DerivativeDetailsVO>
	 * @throws HWFServiceException
	 * @throws HWFStubException 
	 */
	public List<DerivativeDetailsVO> getDerivativeDetailsVOList() throws HWFServiceException, HWFStubException {
		List<DerivativeDetailsVO> result = new ArrayList<DerivativeDetailsVO>();
		List<DerivativesRequest> derivatives = legSummary.getDerivativesRequests();
		int count = 1;
		for(DerivativesRequest derivativeRequest : derivatives) {
			DerivativeDetailsVO derivativeDetailsVO = Utils.createDerivativeDetailsVO(derivativeRequest, request);
			derivativeDetailsVO.setDerivativeNumber(count++);
			result.add(derivativeDetailsVO);
		}
		return result;
	}
	/**
	 * 
	 * @return ExceptionComments
	 */
	public String getExceptionComments() {
		return null;
	}
	
	/**
	 * 
	 * @return derivatives
	 */
	public Boolean getIsDerivativesFlag() {
		return legSummary.isDerivativesFlag();
	}
	/**
	 * 
	 * @return List<ExceptionRequestForm>
	 */
	public List<ExceptionRequestForm> getExceptions() {
		return ICFPLegHelper.filterDeletedExceptions(legSummary.getExceptionRequestForms());
	}
	
	/**
	 * 
	 * @return EffectiveDate
	 */
	public String getEffectiveDate(){
		if(legSummary.getEffectiveDt() != null){
			return legSummary.getEffectiveDt().toString();
		}else{
			return "";
		}
	}
	/**
	 * 
	 * @return MaturityDate
	 */
	public String getMaturityDate(){
		if(legSummary.getMaturityDt()!=null){
			XMLGregorianCalendar date = legSummary.getMaturityDt();
			return new SimpleDateFormat(MM_DD_YYYY).format(((XMLGregorianCalendar)date).toGregorianCalendar().getTime()).toString();
		}
		return "";
	}
	
	public String getComments(){
		return legSummary.getComments();
	}
	
	/**
	 * 
	 * @return equityFormId
	 */
	public String getformOfEquity() {
		return equityLegSummary.getEquityFormId();
	}
	
	/**
	 * 
	 * @return debtTerms
	 */
	public String getdebtTerms() {
		return equityLegSummary.getDebtTerms();
	}
	
	/**
	 * 
	 * @return shareTypeId
	 */
	public String getshareType() {
		return equityLegSummary.getShareTypeId();
	}
	/**
	 * 
	 * @return numberOfShares
	 */
	public String getNumberOfShares() {
		return equityLegSummary.getNumberOfShares();
	}
	/**
	 * 
	 * @return
	 */
	public String getGuarantorCDR(){
		List<Entity> entities = legSummary.getEntities();
		for(Entity eachEntity: entities) {
			if(eachEntity.getLeTypeId() == 3) {
				return eachEntity.getCDRCd();
			}
		}
		return "-";
	}
	/**
	 * 
	 */
	public String getGuarantorLEName(){
		List<Entity> entities = legSummary.getEntities();
		for(Entity eachEntity: entities) {
			if(eachEntity.getLeTypeId() == 3) {
				return eachEntity.getLEName();
			}
		}
		return "-";
	}
	public String getGuarantorLEGoldId(){
		List<Entity> entities = legSummary.getEntities();
		for(Entity eachEntity: entities) {
			if(eachEntity.getLeTypeId() == 3) {
				return eachEntity.getLEGoldId();
			}
		}
		return "-";
	}
	public String getGuarantorME(){
		List<Entity> entities = legSummary.getEntities();
		for(Entity eachEntity: entities) {
			if(eachEntity.getLeTypeId() == 3) {
				return eachEntity.getMEName();
			}
		}
		return "-";
	}
	public String getGuarantorCountry(){
		List<Entity> entities = legSummary.getEntities();
		for(Entity eachEntity: entities) {
			if(eachEntity.getLeTypeId() == 3) {
				return eachEntity.getCountry();
			}
		}
		return "-";
	}

	public String getGuarantorPrincipalEntity() {
		List<Entity> entities = legSummary.getEntities();
		for (Entity eachEntity : entities) {
			if (eachEntity.getLeTypeId() != null) {
				if (eachEntity.getLeTypeId() == 3) {
					if (eachEntity.isPrincplEntityFlag() != null) {
						if (eachEntity.isPrincplEntityFlag()) {
							return YES_CAP;
						} else {
							return NO_CAP;
						}
					} else {
						return NO_CAP;
					}
				}
			} else {
				return NO_CAP;
			}
		}
		return "-";
	}

	public String getGuarantorRegulatedEntity() {
		List<Entity> entities = legSummary.getEntities();
		for (Entity eachEntity : entities) {
			if (eachEntity.getLeTypeId() != null) {
				if (eachEntity.getLeTypeId() == 3) {
					if (eachEntity.isRegulatedEntityFlag() != null) {
						if (eachEntity.isRegulatedEntityFlag()) {
							return YES_CAP;
						} else {
							return NO_CAP;
						}
					} else {
						return NO_CAP;
					}
				}
			} else {
				return NO_CAP;
			}
		}
		return "-";
	}
	public String getSelectedTransactionCapturedIn(){
		if(legSummary.getTransactionCaptureIn() == null){
			return "";
		}else{
			return legSummary.getTransactionCaptureIn();
		}
	}
	
	public Integer getSelectedTransactionCapturedInId(){
		if(legSummary.getTransactionCaptureInId() == null){
			return null;
		}else{
			return legSummary.getTransactionCaptureInId();
		}
	}
	
	
	public String getTransactionId(){
		return (StringUtils.isNotBlank(legSummary.getTransactionId())) ? legSummary.getTransactionId() : "";
	}
	public String getInstrumentId(){
		if(legSummary.getInstrumentId() == null){
			return "";
		}else{
			return legSummary.getInstrumentId();
		}
	}
	
	/**
	 * Return all BusinessSegments
	 * @return
	 */
	public List<String> getAllBusinessSegment(){
		
		List<Entity> entities = legSummary.getEntities();
		List<String> retList = new ArrayList<String>();
		
		for(Entity entity: entities){
			retList.add( entity.getBusinessSegment() );
		}
		
		return retList;
	}
	
	/**
	 * Returns the Original Lender from leg.
	 * 
	 * @return
	 * @throws ICFPException
	 */
	public Entity getLenderEntity() throws ICFPException {
		if(lenderEntity == null) {
			lenderEntity = EntityHelper.searchEntity(legSummary, EntityHelper.EntityType.ORIGINAL_LENDER);
		}
		return lenderEntity;
	}
	
	/**
	 * Returns the Original Borrower from leg.
	 * 
	 * @return
	 * @throws ICFPException
	 */
	public Entity getBorrowerEntity() throws ICFPException {
		if(borrowerEntity == null) {
			borrowerEntity = EntityHelper.searchEntity(legSummary, EntityHelper.EntityType.ORIGINAL_BORROWER);
		}
		return borrowerEntity;
	}
	
	/**
	 * Returns the New Lender from leg.
	 * 
	 * @return
	 * @throws ICFPException
	 */
	public Entity getNewLenderEntity() throws ICFPException {
		if(newLenderEntity == null) {
			newLenderEntity = EntityHelper.searchEntity(legSummary, EntityHelper.EntityType.NEW_LENDER);
		}
		return newLenderEntity;
	}
	
	/**
	 * Returns the New Borrower from leg.
	 * 
	 * @return
	 * @throws ICFPException
	 */
	public Entity getNewBorrowerEntity() throws ICFPException {
		if(newBorrowerEntity == null) {
			newBorrowerEntity = EntityHelper.searchEntity(legSummary, EntityHelper.EntityType.NEW_BORROWER);
		}
		return newBorrowerEntity;
	}
	
	/**
	 * Returns the Payor from leg.
	 * 
	 * @return
	 * @throws ICFPException
	 */
	public Entity getPayorEntity() throws ICFPException {
		if(payorEntity == null) {
			payorEntity = EntityHelper.searchEntity(legSummary, EntityHelper.EntityType.PAYOR);
		}
		return payorEntity;
	}
	
	/**
	 * 
	 * @return OrgAmount
	 */
	public String getOrgAmount() {
		if(legSummary.getOriginalCCYAmount()!=null){
			return String.valueOf(legSummary.getOriginalCCYAmount());
		}else {
			return "";
		}
	}
	
	/**
	 * 
	 * @return getUsdEqui
	 */
	public String getUsdEqui() {
		if(legSummary.getUSDEquivalent()!=null){
			return String.valueOf(legSummary.getUSDEquivalent());
		}else{
			return "";
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public String getIsTransactionHedged() {
		String result = PDFReportHelper.convertZeroOrOneToNoOrYes(legSummary.getIsHedgedFlag());
		return (StringUtils.isNotBlank(result)) ? result : "-";
	}
	
	/**
	 * 
	 * @return
	 */
	public String getNonStandardLegalAgrements() {
		String result = PDFReportHelper.convertZeroOrOneToNoOrYes(legSummary.getOriginalLegalAgreementsFlag());
		return (StringUtils.isNotBlank(result)) ? result : "-";
	}
	
	/**
	 * 
	 * @return
	 */
	public String getDrawDownNoticeAttached() {
		String result = PDFReportHelper.convertBooleanAsYesOrNo(legSummary.isEventNoticeAttachedFlag());
		return (result != null) ? result : "-";
	}
	
	/**
	 * 
	 * @return
	 * @throws ICFPException 
	 */
	public String getFacilityIncDecAmt() throws ICFPException {
		Object leg = CurrentDealManager.getLegByNumber(legNumber, request);
		DayTwoOperations dayTwoOperations = Utils.fetchPropertyValue(DAYTWOOPERATIONS, leg, DayTwoOperations.class);
		FacilityIncreaseDecrease facilityIncDec = (dayTwoOperations != null) ? dayTwoOperations.getFacilityIncreaseDecrease() : null;
		String result = null;
		if(facilityIncDec != null) {
			result = PDFReportHelper.formatCurrency(facilityIncDec.getFacilityIncDecAmt());
		}
		return (result != null) ? result : "-";
	}
	
	/**
	 * 
	 * @return
	 * @throws ICFPException 
	 */
	public String getFacilityIncDecUSDEquivalentAmt() throws ICFPException {
		Object leg = CurrentDealManager.getLegByNumber(legNumber, request);
		DayTwoOperations dayTwoOperations = Utils.fetchPropertyValue(DAYTWOOPERATIONS, leg, DayTwoOperations.class);
		FacilityIncreaseDecrease facilityIncDec = (dayTwoOperations != null) ? dayTwoOperations.getFacilityIncreaseDecrease() : null;
		String result = null;
		if(facilityIncDec != null) {
			result = PDFReportHelper.formatCurrency(facilityIncDec.getFacilityIncDecUSDEquivalentAmt());
		}
		return (result != null) ? result : "-";
	}
	
	/**
	 * 
	 * @return
	 * @throws ICFPException 
	 */
	public String getAmendedUSDEquivalentAmt() throws ICFPException {
		Object leg = CurrentDealManager.getLegByNumber(legNumber, request);
		DayTwoOperations dayTwoOperations = Utils.fetchPropertyValue(DAYTWOOPERATIONS, leg, DayTwoOperations.class);
		FacilityIncreaseDecrease facilityIncDec = (dayTwoOperations != null) ? dayTwoOperations.getFacilityIncreaseDecrease() : null;
		String result = null;
		if(facilityIncDec != null) {
			result = PDFReportHelper.formatCurrency(facilityIncDec.getAmendedUSDEquivalentAmt());
		}
		return (result != null) ? result : "-";
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LegSummaryVO [legNumber=").append(legNumber)
				.append(", legSummary=").append(legSummary)
				.append(", equityLegSummary=").append(equityLegSummary)
				.append(", request=").append(request).append(", lenderEntity=")
				.append(lenderEntity).append(", borrowerEntity=")
				.append(borrowerEntity).append(", newLenderEntity=")
				.append(newLenderEntity).append(", newBorrowerEntity=")
				.append(newBorrowerEntity).append(", payorEntity=")
				.append(payorEntity).append("]");
		return builder.toString();
	}
	
	
}
