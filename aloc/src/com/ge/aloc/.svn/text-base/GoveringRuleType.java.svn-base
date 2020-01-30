/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: GoveringRuleType.java
 * Purpose: GoveringRuleType used for the govering Rules constants.
 */
package com.ge.aloc;

/**
 * @author arijit.biswas
 *
 */
public enum GoveringRuleType {
	PRACTICE(1,"practice"),
	GUARANTEE(2,"guarantee"),
	CUSTOMS(3,"customs"),
	DEMAND(4,"demand"),
	UNKNOWN(5,"unknown");
	/**
	 * This method is used to get the GoveringRule Type based on id.
	 * @param id
	 * @return
	 */
	public static GoveringRuleType fromId(int id) { 
		for(GoveringRuleType createRequestType : values()) {
			if(createRequestType.id == id) {
				return createRequestType;
			}
		}
		return null;
	}
	/**
	 * This method is used to get the GoveringRule Type based on name.
	 * @param name
	 * @return
	 */
	public static GoveringRuleType fromName(String name) { 
		for(GoveringRuleType createRequestType : values()) {
			if(name.equals(createRequestType.name)) {
				return createRequestType;
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
	 * GoveringRuleType constructor with id and name
	 * @param id
	 * @param name
	 */
	private GoveringRuleType(int id, String name) {
		this.id = id;
		this.name = name;
	}
	/**
	 * This method is used get name.
	 * @return
	 */
	public String getName() {
		return name;
	}
}
