/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: PendingEntityVO.java
 * Purpose: PendingEntityVO used for population/Retreival of entity data.
 */
package com.ge.icfp.common.vo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import com.ge.icfp.model.Entity;
import com.hydus.wff.core.security.JAXBObjectSecureSerializer;

/**
 * Adapter class for Entity to support Struts Actionform population/Retreival
 * 
 * @author prithivi.dhamotharan
 * 
 */
public class PendingEntityVO extends JAXBObjectSecureSerializer implements Serializable {
	
	private Entity entity = null;
	
	public PendingEntityVO(Object entity){
		this.entity = (Entity)entity;		
	}
	
	public void setEntity(Entity entity) {
		this.entity = entity;
	}
	
	public Entity getEntity(){
		return this.entity;
	}
	
	@Transient
	public Boolean getPrincplEntityFlag() {
		return entity.isPrincplEntityFlag();
	}

	@Transient
	public Boolean getRegulatedEntityFlag() {
		return entity.isRegulatedEntityFlag();
	}
	
	/**
	 * 
	 */
	@Transient
	public String getLEGoldId() {
		return entity.getLEGoldId();
	}

	/**
	 * Sets the value of the leGoldId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLEGoldId(String value) {
		entity.setLEGoldId(value);
	}

	/**
	 * Gets the value of the leName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Transient
	public String getLEName() {
		return entity.getLEName();
	}

	/**
	 * Sets the value of the leName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLEName(String value) {
		entity.setLEName( value );
	}

	/**
	 * Gets the value of the leCategory property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Transient
	public String getLECategory() {
		return entity.getLECategory();
	}

	/**
	 * Sets the value of the leCategory property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLECategory(String value) {
		entity.setLECategory(value);
	}

	/**
	 * Gets the value of the cdrCd property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Transient
	public String getCDRCd() {
		return entity.getCDRCd();
	}

	/**
	 * Sets the value of the cdrCd property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCDRCd(String value) {
		entity.setCDRCd(value);
	}

	/**
	 * Gets the value of the meName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Transient
	public String getMEName() {
		return entity.getMEName();
	}

	/**
	 * Sets the value of the meName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMEName(String value) {
		entity.setMEName(value);
	}

	/**
	 * Gets the value of the bankTreasuryCd property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Transient
	public String getBankTreasuryCd() {
		return entity.getBankTreasuryCd();
	}

	/**
	 * Sets the value of the bankTreasuryCd property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setBankTreasuryCd(String value) {
		entity.setBankTreasuryCd(value);
	}

	/**
	 * Gets the value of the treasuryCodes property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the treasuryCodes property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getTreasuryCodes().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link String }
	 * 
	 * 
	 */
	@Transient
	public String[] getTreasuryCodes() {	
            int size = entity.getTreasuryCodes().size();
            
            return entity.getTreasuryCodes().toArray( new String[size]);
	}

	/**
	 * Gets the value of the legalEntitySeqId property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	@Transient
	public Integer getLegalEntitySeqId() {
		return entity.getLegalEntitySeqId();
	}

	/**
	 * Sets the value of the legalEntitySeqId property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setLegalEntitySeqId(Integer value) {
		entity.setLegalEntitySeqId(value);
	}

	/**
	 * Gets the value of the country property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Transient
	public String getCountry() {
		return entity.getCountry();
	}

	/**
	 * Sets the value of the country property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCountry(String value) {
		entity.setCountry(value);
	}

	/**
	 * Gets the value of the countryCd property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Transient
	public String getCountryCd() {
		return entity.getCountryCd();
	}

	/**
	 * Sets the value of the countryCd property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCountryCd(String value) {
		entity.setCountryCd(value);
	}

	/**
	 * Gets the value of the leType property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Transient
	public String getLeType() {
		return entity.getLeType();
	}

	/**
	 * Sets the value of the leType property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLeType(String value) {
		entity.setLeType(value);
	}

	/**
	 * Gets the value of the leTypeId property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	@Transient
	public Integer getLeTypeId() {
		return entity.getLeTypeId();
	}

	/**
	 * Sets the value of the leTypeId property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setLeTypeId(Integer value) {
		entity.setLeTypeId(value);
	}

	/**
	 * Gets the value of the meGoldId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Transient
	public String getMeGoldId() {
		return entity.getMeGoldId();
	}

	/**
	 * Sets the value of the meGoldId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMeGoldId(String value) {
		entity.setMeGoldId(value);
	}

	/**
	 * Gets the value of the leCategoryId property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	@Transient
	public Integer getLeCategoryId() {
		return entity.getLeCategoryId();
	}

	/**
	 * Sets the value of the leCategoryId property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setLeCategoryId(Integer value) {
		entity.setLeCategoryId(value);
	}

	/**
	 * Gets the value of the princplEntityFlag property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	@Transient
	public Boolean isPrincplEntityFlag() {
		return entity.isPrincplEntityFlag();
	}

	/**
	 * Sets the value of the princplEntityFlag property.
	 * 
	 * @param value
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setPrincplEntityFlag(Boolean value) {
		entity.setPrincplEntityFlag(value);
	}

	/**
	 * Gets the value of the regulatedEntityFlag property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	@Transient
	public Boolean isRegulatedEntityFlag() {
		return entity.isRegulatedEntityFlag();
	}

	/**
	 * Sets the value of the regulatedEntityFlag property.
	 * 
	 * @param value
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setRegulatedEntityFlag(Boolean value) {
		entity.setRegulatedEntityFlag(value);
	}

	/**
	 * Gets the value of the entitySetupFlag property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Transient
	public String getEntitySetupFlag() {
		return entity.getEntitySetupFlag();
	}

	/**
	 * Sets the value of the entitySetupFlag property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEntitySetupFlag(String value) {
		entity.setEntitySetupFlag(value);
	}

	/**
	 * Gets the value of the capitalIndustrial property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Transient
	public String getCapitalIndustrial() {
		return entity.getCapitalIndustrial();
	}

	/**
	 * Sets the value of the capitalIndustrial property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCapitalIndustrial(String value) {
		entity.setCapitalIndustrial(value);
	}

	/**
	 * Gets the value of the businessSegment property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Transient
	public String getBusinessSegment() {
		return entity.getBusinessSegment();
	}

	/**
	 * Sets the value of the businessSegment property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setBusinessSegment(String value) {
		entity.setBusinessSegment(value);
	}

	/**
	 * Gets the value of the fundHoldOperationId property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	@Transient
	public Integer getFundHoldOperationId() {
		return entity.getFundHoldOperationId();
	}

	/**
	 * Sets the value of the fundHoldOperationId property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setFundHoldOperationId(Integer value) {
		entity.setFundHoldOperationId(value);
	}

	/**
	 * Gets the value of the fundHoldOperation property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Transient
	public String getFundHoldOperation() {
		return entity.getFundHoldOperation();
	}

	/**
	 * Sets the value of the fundHoldOperation property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFundHoldOperation(String value) {
		entity.setFundHoldOperation(value);
	}
	
	/**
	 * setTreasuryCodes
	 * @param codes
	 */
	public void setTreasuryCodes(String[] codes){
		
		List<String> treasuryCodes = entity.getTreasuryCodes();		
		treasuryCodes.clear();
                treasuryCodes.addAll( Arrays.asList(codes));   
                entity.setTreasuryCodes(treasuryCodes);
	}
                
}
