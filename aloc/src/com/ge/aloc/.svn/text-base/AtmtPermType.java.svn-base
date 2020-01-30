/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: AtmtPermType.java
 * Purpose: AtmtPermType used for the all permissions constants.
 */
package com.ge.aloc;

/**
 * @author rajeswari.guthi
 *
 */
public enum AtmtPermType {
	TREASURY("1"),
	Surety("2"),
	BANK("3");

	/**
	 * This method is used to get the attachment permission type based on id.
	 * @param id 
	 * @return
	 */
	public static AtmtPermType fromId(String id) { 
		for(AtmtPermType permType : values()) {
			if(permType.id.equals(id)) {
				return permType;
			}
		}
		return null;
	}

	private String id;
	/**
	 * Attachment permission type constructor
	 * @param id
	 */
	private AtmtPermType(String id) {
		this.id = id;
	}

	/**
	 * This is used to get id attribute
	 * getId
	 * @return
	 */
	public String getId() {
		return this.id;
	}
}
