/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: RateInfoVO.java
 * Purpose: RateInfoVO used for displaying Leg Summary Data.
 */
package com.ge.icfp.common.vo;

import javax.servlet.http.HttpServletRequest;

import com.ge.icfp.model.RateInformation;
/**
 * @author arijit.biswas
 *
 */
public class RateInfoVO {

	private int legNumber;
	private RateInformation rateInformation;
	private HttpServletRequest request;
	
	/**
	 * Constructor
	 * @param legNumber 
	 * @param legSummary
	 * @param request
	 */
	public RateInfoVO(int legNumber, RateInformation rateInformation, HttpServletRequest request) {
		this.legNumber = legNumber;
		this.rateInformation = rateInformation;
		this.request = request; 
	}
	
	/**
	 * @return getInterestTypeId
	 */
	public Integer getInterestTypeId() {
		return rateInformation.getInterestTypeId();
	}
	
	/**
	 * @return getBaseFixedRate
	 */
	public Double getBaseFixedRate() {
		return rateInformation.getBaseFixedRate();
	}
	
	/**
	 * @return getMinSpread
	 */
	public Double getMinSpread() {
		if(rateInformation != null){
			if(rateInformation.getMinSpread() != null){
				return rateInformation.getMinSpread();
			}
			
		}
		return new Double(0);
	}
	
	/**
	 * @return getFloatingRateIndex
	 */
	public String getFloatingRateIndex() {
		if(rateInformation != null){
			return (rateInformation.getFloatingRateIndex() == null) ? "-" : rateInformation.getFloatingRateIndex();
		}
		return "-";
	
	}
	
	/**
	 * @return getMaxSpread
	 */
	public Double getMaxSpread() {
		if(rateInformation != null){
			if(rateInformation.getMaxSpread() != null){
				return rateInformation.getMaxSpread();
			}
			
		}
		return new Double(0);
		
	}
	
	
	/**
	 * @return getSpread
	 */
	public Double getSpread() {
		if(rateInformation != null){
			if(rateInformation.getSpread() != null){
				return rateInformation.getSpread();
			}
			
		}
		return new Double(0);
	}
	
	/**
	 * @return getFloatingRateIndexTerm
	 */
	public String getFloatingRateIndexTerm() {
		if(rateInformation != null){
			return (rateInformation.getFloatingRateIndexTerm() == null) ? "-" : rateInformation.getFloatingRateIndexTerm();
		}
		return "-";
	}
	
	
	
}
