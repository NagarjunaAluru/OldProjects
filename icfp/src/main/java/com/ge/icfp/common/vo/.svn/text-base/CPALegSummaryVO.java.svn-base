/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: CPALegSummaryVO.java
 * Purpose: CPALegSummaryVO used for displaying Leg Summary Data of CPA.
 */
package com.ge.icfp.common.vo;

import java.util.ArrayList;
import java.util.List;

import com.ge.icfp.action.ICFPException;
import com.ge.icfp.common.helper.EntityHelper;
import com.ge.icfp.model.CPASummary;
import com.ge.icfp.model.Entity;
import com.ge.icfp.model.ExceptionRequestForm;
import com.ge.icfp.model.QualitativeFactors;
import com.ge.icfp.model.RateInformation;
import static com.ge.icfp.common.constants.ICFPConstants.*;
/**
 * 
 * @author arijit.biswas
 *
 */
public class CPALegSummaryVO{
	/**
	 * productType
	 */
	private String productType;
	/**
	 * legNumber
	 */
	private int legNumber;
	/**
	 * cpaSummary
	 */
	private CPASummary cpaSummary;
	/**
	 * 
	 */
	private RateInformation rateInformation;
	

	/**
	 * comments
	 */
	private String comments;
	private Entity participant;
	private Entity poolLeader;
	private String lenderTCode;
	private String borrowerTCode;
    private String transactionEventType;
    private String transactionCapturedInId;
	

	/**
	 * @return the productType
	 */
	public String getProductType() {
		return cpaSummary.getProductType();
	}

	/**
	 * @param productType the productType to set
	 */
	public void setProductType(String productType) {
		this.productType = productType;
	}

	/**
	 * @return the cpaSummary
	 */
	public CPASummary getCpaSummary() {
		return cpaSummary;
	}

	/**
	 * @param cpaSummary the cpaSummary to set
	 */
	public void setCpaSummary(CPASummary cpaSummary) {
		this.cpaSummary = cpaSummary;
	}

	/**
	 * @param legNumber the legNumber to set
	 */
	public void setLegNumber(int legNumber) {
		this.legNumber = legNumber;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	
	
	/**
	 * @return the transactionCapturedInId
	 */
	public String getTransactionCapturedInId() {
		return transactionCapturedInId;
	}

	/**
	 * @param transactionCapturedInId the transactionCapturedInId to set
	 */
	public void setTransactionCapturedInId(String transactionCapturedInId) {
		this.transactionCapturedInId = transactionCapturedInId;
	}

	/**
	 * constructor
	 * @param legNumber
	 * @param cpaSummary
	 */
	public CPALegSummaryVO(int legNumber, CPASummary cpaSummary, String comments,RateInformation rateInformation, String transactionCapturedInId) {
		this.legNumber = legNumber;
		this.cpaSummary = cpaSummary;
		this.comments = comments;
		if(rateInformation!=null){
		 this.rateInformation = rateInformation;
		}else{
		  this.rateInformation = new RateInformation();	
		}
		this.transactionCapturedInId = transactionCapturedInId;
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
	 * @return comments
	 */
	public String getComments() {
		return comments;
	}
	/**
	 * 
	 * @return legSeqId
	 */
	public Integer getLegSeqId() {
		return cpaSummary.getLegSeqId();
	}
	/**
	 * getProduct
	 * @return
	 */
	public String getProduct() {
		return cpaSummary.getProductType();
	}
	/**
	 * 
	 * @return dealCurrency
	 */
	public String getDealCurrency() {
		return cpaSummary.getCurrencyCd();
	}
	/**
	 * getTerm
	 * @return
	 */
	public Double getTerm(){
		return cpaSummary.getTerm();
	}
	/**
	 * getPoolCapitalIndustrial
	 * @return
	 * @throws ICFPException 
	 */
	public String getPoolCapitalIndustrial() throws ICFPException {
		Entity poolLeader = getPoolLeader();
		if(poolLeader != null) {
			return poolLeader.getLeType();
		}
		return null;
	}
	/**
	 * getParticipantCapitalIndustrial
	 * @return
	 * @throws ICFPException 
	 */
	public String getParticipantCapitalIndustrial() throws ICFPException {
		Entity participant = getParticipant();
		if(participant != null) {
			return participant.getLeType();
		}
		return null;
	}
	/**
	 * getParticipantRegulatedEntity
	 * @return
	 * @throws ICFPException 
	 */
	public String getParticipantRegulatedEntity() throws ICFPException{
		Entity participant = getParticipant();
		if(participant != null && participant.isRegulatedEntityFlag() != null) {
			return (participant.isRegulatedEntityFlag()) ? YES_CAP : NO_CAP;
		}
		return null;
	}
	
	/**
	 * getParticipantPrincipalEntity
	 * @return
	 * @throws ICFPException 
	 */
	public String getParticipantPrincipalEntity() throws ICFPException{
		Entity participant = getParticipant();
		if(participant != null && participant.isPrincplEntityFlag() != null) {
			return (participant.isPrincplEntityFlag()) ? YES_CAP : NO_CAP;
		}
		return null;
	}
	/**
	 * getPoolLeaderRegulatedEntity
	 * @return
	 * @throws ICFPException 
	 */
	public String getPoolLeaderRegulatedEntity() throws ICFPException{
		Entity poolLeader = getPoolLeader();
		if(poolLeader != null && poolLeader.isRegulatedEntityFlag()!= null) {
			return (poolLeader.isRegulatedEntityFlag()) ? YES_CAP : NO_CAP;
		}
		return null;
	}
	/**
	 * getPoolLeaderPrincipalEntity
	 * @return
	 * @throws ICFPException 
	 */
	public String getPoolLeaderPrincipalEntity() throws ICFPException{
		Entity poolLeader = getPoolLeader();
		if(poolLeader != null && poolLeader.isPrincplEntityFlag()!= null ) {
			return (poolLeader.isPrincplEntityFlag()) ? YES_CAP : NO_CAP;
		}
		return null;
	}
	/**
	 * getParticipant
	 * @return Participant
	 * @throws ICFPException 
	 */
	public Entity getParticipant() throws ICFPException {
		if(participant == null) {
			participant = EntityHelper.searchEntity(cpaSummary, EntityHelper.EntityType.PARTICIPANT);
		}
		return participant;
	}
	/**
	 * getPoolLeader
	 * @return PoolLeader
	 * @throws ICFPException 
	 */
	public Entity getPoolLeader() throws ICFPException {
		if(poolLeader == null) {
			poolLeader = EntityHelper.searchEntity(cpaSummary, EntityHelper.EntityType.POOL_LEADER);
		}
		return poolLeader;
	}
	/**
	 * getParticipantCDR
	 * @return ParticipantCDR
	 * @throws ICFPException 
	 */
	public String getParticipantCDR() throws ICFPException {
		Entity participant = getParticipant();
		if(participant != null) {
			return participant.getCDRCd();
		}
		return null;
	}
	
	
	/**
	 * get Participant CDR
	 * @return
	 * @throws ICFPException 
	 */
	public String getParticipantGoldId() throws ICFPException {
		Entity participant = getParticipant();
		if(participant != null) {
			return participant.getLEGoldId();
		}
		return null;
	}
	
	/**
	 * getParticipantName
	 * @return ParticipantName
	 * @throws ICFPException 
	 */
	public String getParticipantName() throws ICFPException {
		Entity participant = getParticipant();
		if(participant != null) {
			return participant.getLEName();
		}
		return null;
	}
	/**
	 * getParticipantCountry
	 * @return ParticipantCountry
	 * @throws ICFPException 
	 */
	public String getParticipantCountry() throws ICFPException {
		Entity participant = getParticipant();
		if(participant != null) {
			return participant.getCountry();
		}
		return null;
	}
	/**
	 * getParticipantMeName
	 * @return ParticipantMeName
	 * @throws ICFPException 
	 */
	public String getParticipantMeName() throws ICFPException {
		Entity participant = getParticipant();
		if(participant != null) {
			return participant.getMEName();
		}
		return null;
	}
	/**
	 * getParticipantType
	 * @return ParticipantType
	 * @throws ICFPException 
	 */
	public String getParticipantType() throws ICFPException {
		Entity participant = getParticipant();
		if(participant != null) {
			return participant.getCapitalIndustrial();
		}
		return null;
	}
	
	
	/**
	 * get Pool Gold Id
	 * @return PoolCDR
	 * @throws ICFPException 
	 */
	public String getPoolGoldId() throws ICFPException {
		Entity poolLeader = getPoolLeader();
		if(poolLeader != null) {
			return poolLeader.getLEGoldId();
		}
		return null;
	}
	
	/**
	 * getPoolCDR
	 * @return PoolCDR
	 * @throws ICFPException 
	 */
	public String getPoolCDR() throws ICFPException {
		Entity poolLeader = getPoolLeader();
		if(poolLeader != null) {
			return poolLeader.getCDRCd();
		}
		return null;
	}
	/**
	 * getPoolName
	 * @return PoolName
	 * @throws ICFPException 
	 */
	public String getPoolName() throws ICFPException {
		Entity poolLeader = getPoolLeader();
		if(poolLeader != null) {
			return poolLeader.getLEName();
		}
		return null;
	}
	/**
	 * getPoolCountry
	 * @return PoolCountry
	 * @throws ICFPException 
	 */
	public String getPoolCountry() throws ICFPException {
		Entity poolLeader = getPoolLeader();
		if(poolLeader != null) {
			return poolLeader.getCountry();
		}
		return null;
	}
	/**
	 * getPoolMeName
	 * @return PoolMeName
	 * @throws ICFPException 
	 */
	public String getPoolMeName() throws ICFPException {
		Entity poolLeader = getPoolLeader();
		if(poolLeader != null) {
			return poolLeader.getMEName();
		}
		return null;
	}
	/**
	 * getPoolType
	 * @return PoolType
	 * @throws ICFPException 
	 */
	public String getPoolType() throws ICFPException {
		Entity poolLeader = getPoolLeader();
		if(poolLeader != null) {
			return poolLeader.getLeType();
		}
		return null;
	}
	
	
	/**
	 * getPoolFCHC
	 * @return
	 * @throws ICFPException 
	 */
	public String getPoolFCHC() throws ICFPException {
		Entity poolLeader = getPoolLeader();
		if(poolLeader != null) {
			return poolLeader.getFundHoldOperation();
		}
		return null;
	}
	
	/**
	 * getParticipantFCHC
	 * @return
	 * @throws ICFPException 
	 */
	public String getParticipantFCHC() throws ICFPException {
		Entity participant = getParticipant();
		if(participant != null) {
			return participant.getFundHoldOperation();
		}
		return null;
	}
	/**
	 * getParticipantBusSegment
	 * @return
	 * @throws ICFPException 
	 */
	public String getParticipantBusSegment() throws ICFPException {
		Entity participant = getParticipant();
		if(participant != null) {
			return participant.getBusinessSegment();
		}
		return null;
	}
	
	/**
	 * getPoolBusSegment
	 * @return
	 * @throws ICFPException 
	 */
	public String getPoolBusSegment() throws ICFPException {
		Entity poolLeader = getPoolLeader();
		if(poolLeader != null) {
			return poolLeader.getBusinessSegment();
		}
		return null;
	}
	
	/**
	 * 
	 * @return PoolLeaderBankName
	 * @throws ICFPException 
	 */
	public String getPoolLeaderBankName() throws ICFPException {
		Entity poolLeader = getPoolLeader();
		if(poolLeader != null) {
			return poolLeader.getBankTreasuryCd();
		}		
		return null;
	}
	
	/**
	 * 
	 * @return
	 * @throws ICFPException
	 */
	public String getPoolLeaderTCode() throws ICFPException {
		Entity poolLeader = getPoolLeader();
		if(poolLeader != null) {
			return (poolLeader.getTreasuryCodes().isEmpty()) ? null : poolLeader.getTreasuryCodes().get(0);
		}
		return null;
	}
	
	/**
	 * 
	 * @return
	 * @throws ICFPException
	 */
	public List<String> getParticipantTCode() throws ICFPException {
		Entity participant = getParticipant();
		if(participant != null) {
			return (participant.getTreasuryCodes().isEmpty()) ? null : participant.getTreasuryCodes();
		}
		return null;
	}
	
	
	/**
	 * getCashPoolName
	 * @return CashPoolName
	 * @throws ICFPException 
	 */
	public String getCashPoolName() throws ICFPException {
		Entity poolLeader = getPoolLeader();
		if(poolLeader != null) {
			return poolLeader.getLEName();
		}
		return null;
	}
	/**
	 * getCashPoolCountry
	 * @return CashPoolCountry
	 * @throws ICFPException 
	 */
	public String getCashPoolCountry() throws ICFPException {
		return cpaSummary.getCountry();
	}
	
	/**
	 * getQualitativeFactorsList
	 * @return
	 */
	public List<QualitativeFactors> getQualitativeFactorsList() {
		return cpaSummary.getQualitativeFactors();
	}
	/**
	 * getCashPoolCurrency
	 * @return CashPoolCurrency
	 */
	public String getCashPoolCurrency() {
		return cpaSummary.getCurrencyCd();
	}
	/**
	 * getCashPoolRegion
	 * @return CashPoolRegion
	 */
	public String getCashPoolRegion() {
		return cpaSummary.getRegion();
	}
	/**
	 * getInterestRateIndex
	 * @return InterestRateIndex
	 */
	public String getInterestRateIndex() {
		return "-";
	}
	/**
	 * getIndexTerm
	 * @return IndexTerm
	 */
	public String getIndexTerm() {
		return "-";
	}
	/**
	 * getDepositeSpread
	 * @return DepositeSpread
	 */
	public String getDepositeSpread() {
		return "-";
	}
	/**
	 * getBorrowingSpread
	 * @return BorrowingSpread
	 */
	public String getBorrowingSpread() {
		return "-";
	}
	
	/**
	 *  getExceptions
	 * @return List<ExceptionRequestForm>
	 */
	public List<ExceptionRequestForm> getExceptions() {
		return cpaSummary.getExceptionRequestForms();
	}
	/**
	 * 
	 * @return
	 */
	public String getSelectedTransactionCapturedIn(){
		if(cpaSummary.getTransactionCaptureIn() == null){
			return "";
		}else{
			return cpaSummary.getTransactionCaptureIn();
		}
	}
	/**
	 * 
	 * @return
	 */
	public String getTransactionId(){
		return "";
	}
	/**
	 * subLedgerTransactionId
	 * @return
	 */
	public String getSubLedgerTransactionId(){
		if(cpaSummary.getSubLedgerTransactionId() == null){
			return "";
		}else{
			return cpaSummary.getSubLedgerTransactionId();
		}
	}
	
	/**
	 * legTypeId
	 * @return
	 */
	public Integer getLegTypeId(){
	  return cpaSummary.getLegTypeId();
    }
	
	
	
	/**
	 * Return all BusinessSegments
	 * @return
	 */
	public List<String> getAllBusinessSegment(){
		
		List<Entity> entities = cpaSummary.getEntities();
		List<String> retList = new ArrayList<String>();
		
		for(Entity entity: entities){
			retList.add( entity.getBusinessSegment() );
		}
		return retList;
	}
	
	/**
	 * getBusinessSegment
	 * @return BusinessSegment
	 */
	public String getBusinessSegment() {
		return(this.participant.getBusinessSegment());
	}
	
	/**
	 * getFundHoldOperationId
	 * @return FundHoldOperationId
	 */
	public Integer getFundHoldOperationId() {
		return(this.participant.getFundHoldOperationId());
	}
	
	/**
	 * getFundHoldOperation
	 * @return FundHoldOperation
	 */
	public String getFundHoldOperation() {
		return(this.participant.getFundHoldOperation());
	}
	
	public String getTermsInMths() {
		return "";
	}
	
	public String getLenderLegalEntity() {
		return "";
	}

	public String getBorrowerLegalEntity(){
		return "";
	}
	
	public String getLenderCountry(){
		return "";
	}
	
	public String getBorrowerCountry(){
		return "";
	}
	
	public String getOriginalCurrency() {
		return "";
	}
	public String getOriginalAmount() {
		return "";
	}
	public String getUsdEquivalent() {
		return "";
	}
	
	public String getDerivatives() {
		return "";
	}

	public RateInformation getRateInformation() {
		return rateInformation;
	}

	public void setRateInformation(RateInformation rateInformation) {
		this.rateInformation = rateInformation;
	}
	
	public String getLenderTCode() {
		return lenderTCode;
	}

	public void setLenderTCode(String lenderTCode) {
		this.lenderTCode = lenderTCode;
	}
	public String getBorrowerTCode() {
		return borrowerTCode;
	}

	public void setBorrowerTCode(String borrowerTCode) {
		this.borrowerTCode = borrowerTCode;
	}
	
	public String getTransactionEventType() {
		return transactionEventType;
	}

	public void setTransactionEventType(String transactionEventType) {
		this.transactionEventType = transactionEventType;
	}
}
