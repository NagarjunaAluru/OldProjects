/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: InstrumentType.java
 * Purpose: InstrumentType used for the all instrument constants.
 */
package com.ge.aloc;

/**
 * @author chaitanya.n
 *
 */
public enum InstrumentType {
	BANK_GUARANTEE(1, "Bank Guarantee"),
	LOC(2, "Standby Letter Of Credit"),
	SURETY_BOND(3, "Surety Bond"),
	DOCUMENT_LOC(4, "Documentary Letter Of Credit Confirmation"),
	AMENDMENT(5, "Amendment"),
	RIDER(6, "Rider");


	/**
	 * This method is used to get the InstrumentType based on id.
	 * @param id
	 * @return
	 */
	public static InstrumentType fromId(int id) { 
		for(InstrumentType instrumentType : values()) {
			if(instrumentType.id == id) {
				return instrumentType;
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
	 * InstrumentType constructor with id, name.
	 * @param id
	 * @param name
	 */
	private InstrumentType(int id, String name) {
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
