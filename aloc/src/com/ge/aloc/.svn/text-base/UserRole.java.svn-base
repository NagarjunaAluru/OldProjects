/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: UserRole.java
 * Purpose: UserRole used for all the roles constants.
 */
package com.ge.aloc;


/**
 * @author madhusudhan.gosula
 *
 */

public enum UserRole {

	Requestor("1","Requestor"),
	Approver("2","Approver"),
	ReadOnly("3","ReadOnly"),
	SiteAdmin("4","SiteAdmin"),
	TreasuryAnalyst("5","TreasuryAnalyst"),
	TreasuryApprover("6","TreasuryApprover"),
	BankOperations("7","BankOperations"),
	BankReadOnly("8","BankReadOnly"),
	SuretyBrokerOperations("9","SuretyBrokerOperations"),
	SuretyBrokerReadOnly("10","SuretyBrokerReadOnly");

	/**
	 * This method fetches the {@link UserRole} based on the name.
	 * 
	 * @param name
	 * @return
	 */
	public static UserRole fromName(String name) {
		UserRole role = null;
		for(UserRole eachRole : values()) {
			if(eachRole.name.equals(name)) {
				role = eachRole;
				break;
			}
		}
		return role;
	}

	private String name;
	private String id;

	/**
	 * Constructor to create instance object.
	 * @param id
	 * @param name
	 */
	private UserRole(String id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * This is used to get name attribute
	 * getName
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * This is used to get id attribute
	 * getId
	 * @return
	 */
	public String getId() {
		return id;
	}

}
