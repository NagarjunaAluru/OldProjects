/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: InstrumentPurposeType.java
 * Purpose: InstrumentPurposeType used for the all instrument purpose constants.
 */
package com.ge.aloc;

/**
 * @author arijit.biswas
 *
 */
public enum InstrumentPurposeType {
	ADVANCE_PAYMENT(12, "Advance Payment"),
	BID(1, "Bid"),
	FINANCIAL(15, "Financial"),
	OTHER(16, "Other"),
	PERFORMANCE(13, "Performance"),
	RETENTION(14, "Retention");

	/**
	 * This method is used to get the InstrumentPurposeType based on id.
	 * @param id
	 * @return
	 */
	public static InstrumentPurposeType fromId(int id) { 
		for(InstrumentPurposeType instrumentPurposeType : values()) {
			if(instrumentPurposeType.id == id) {
				return instrumentPurposeType;
			}
		}
		return null;
	}

	/**
	 * This method is used to get the InstrumentPurposeType based on name.
	 * @param id
	 * @return
	 */
	public static InstrumentPurposeType fromName(String name) { 
		for(InstrumentPurposeType instrumentPurposeType : values()) {
			if(instrumentPurposeType.name.equalsIgnoreCase(name)) {
				return instrumentPurposeType;
			}
		}
		return null;
	}

	/**
	 * 
	 */
	private int id;
	/**
	 * 
	 */
	private String name;
	/**
	 * InstrumentPurposeType constructor with id, name
	 * @param id
	 * @param name
	 */
	private InstrumentPurposeType(int id, String name) {
		this.id = id;
		this.name = name;
	}
	/**
	 * This is used to get name attribute
	 * getName
	 * @return
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * This is used to get id attribute
	 * getId
	 * @return
	 */
	public int getId() {
		return this.id;
	}
}
