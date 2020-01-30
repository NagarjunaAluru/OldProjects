/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: AddressType.java
 * Purpose: AddressType used for the all address constants.
 */
package com.ge.aloc;

/**
 * 
 * @author arijit.biswas
 *
 */
public enum AddressType {
	APPLICANT(1,"Applicant"),
	TRI_PARTY_APPLICANT(2,"Tri-Party Applicant"),
	CUSTOMER(3,"Customer"),
	PRINCIPAL(4,"Principal"),
	OBLIGEE(5,"Obligee"),
	BOND_REQUESTOR(6,"Bond Requestor"),
	BENEFICIARY(7,"Beneficiary");

	/**
	 * This method is used to get the address type based on id.
	 * @param id
	 * @return
	 */
	public static AddressType fromId(int id) { 
		for(AddressType addressType : values()) {
			if(addressType.id == id) {
				return addressType;
			}
		}
		return null;
	}
	/**
	 * This method is used to get the address type based on name.
	 * @param name
	 * @return
	 */
	public static AddressType fromName(String name) { 
		for(AddressType addressType : values()) {
			if(name.equals(addressType.name)) {
				return addressType;
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
	 * AddressType constructor.
	 * @param id
	 * @param name
	 */
	private AddressType(int id, String name) {
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
