/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: SearchCriteriaType.java
 * Purpose: SearchCriteriaType used to define the different search criteria.
 */
package com.ge.aloc;

/**
 * This class defines different types of possible searches.
 * 
 * @author bhuvaneswari.a
 */
public enum FHSearchCriteriaType {

	ADN(1),
	ALOC_RECORD_NUM(2),
	APPLICANT_NAME(3),
	BANK_REFERENCE_NUMBER(4),
	BENEFICIARY_NAME(5),
	BUC(6),
	CURRENCY(7),
	FOREIGN_EXPIRY_DATE(8),
	INSTRUMENT_AMOUNT(9),
	PAYMENT_AMOUNT_GREATERTHAN(10),
	PAYMENT_BANK(11),
	PAYMENT_CURRENCY(12),
	PAYMENT_DATE(13);


	/**
	 * This method returns the {@link FHSearchCriteriaType} based on the id.
	 * 
	 * @param id
	 * @return
	 */
	public static FHSearchCriteriaType fromId(int id) {
		for(FHSearchCriteriaType type : values()) {
			if(type.getId() == id) {
				return type;
			}
		}
		return null;
	}

	private int id;

	/**
	 * Constructor to create instance of object.
	 * 
	 * @param id
	 */
	private FHSearchCriteriaType(int id) {
		this.id = id;
	}

	/**
	 * Returns the search criteria ID.
	 * 
	 * @return
	 */
	public int getId() {
		return this.id;
	}
}
