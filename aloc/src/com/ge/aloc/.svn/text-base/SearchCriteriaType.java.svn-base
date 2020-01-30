/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: SearchCriteriaType.java
 * Purpose: SearchCriteriaType used to define the different search criteria.
 */
package com.ge.aloc;

/**
 * This class defines different types of possible searches.
 * 
 * @author chaitanya.n
 */
public enum SearchCriteriaType {
	ALOC_RECORD_NUM(1),
	INSTRUMENT_FROM_AMOUNT(2),
	APPLICATION_PRINCIPAL_NAME(3),
	BENEFICIARY_OBLIGEE_NAME(4),
	NAME(5),
	INSTRUMENT_PURPOSE(6),
	STATUS(7),
	BUNDLE_ID(8),
	CURRENCY(9),
	TRYPARTY_APPLICANT_NAME(10),
	BANK_REFERNCE_NUMBER(11),
	SURETY_REFERENCE_NUMBER(12),
	BUNDLE_AMOUNT(13),
	MODEL_NAME(14);

	/**
	 * This method returns the {@link SearchCriteriaType} based on the id.
	 * 
	 * @param id
	 * @return
	 */
	public static SearchCriteriaType fromId(int id) {
		for(SearchCriteriaType type : values()) {
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
	private SearchCriteriaType(int id) {
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
