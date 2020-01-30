/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: AlocHelpFileType.java
 * Purpose: This file is used for Help File types
 */

package com.ge.aloc;


/**
 * @author rguthi
 *
 */
public enum AlocHelpFileType {

	   BANKFEE(1,"BANKFEE"),
	   SURETYBONDFEE(2,"SURETYBONDFEE"),
	   FEESAMPLE(3,"FEESAMPLE"),
	   GLOSSARY(4,"GLOSSARY"),
	   POLICY(5,"POLICY"),
	   FORMATREDFLAG(6,"FORMATREDFLAG"),
	   SITEADMINS(7,"SITEADMINS"),
	   PARTICIPATINGBANK(8,"PARTICIPATINGBANK"),
	   BANKFORTPT(9,"BANKFORTPT"),
	   PRIVATEBANK(10,"PRIVATEBANK"),
	   USERROLES(11,"USERROLES"),
	   USERMANUAL(12,"USERMANUAL");
	   
	/**
	 * This method is used to get the AlocHelpFileType  based on id.
	 * @param id
	 * @return
	 */
	public static AlocHelpFileType fromId(int id) {
		for(AlocHelpFileType alocHelpFileType : values()) {
			if(alocHelpFileType.id == id) {
				return alocHelpFileType;
			}
		}
		return null;
	}

	/**
	 * This method returns AlocHelpFileType based on name.
	 * 
	 * @param name
	 * @return
	 */
	public static AlocHelpFileType fromName(String name) {
		for(AlocHelpFileType alocHelpFileType : values()) {
			if(alocHelpFileType.getName().equalsIgnoreCase(name)) {
				return alocHelpFileType;
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
	 * constructor to create instance object.
	 * @param id
	 * @param name
	 */
	private AlocHelpFileType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * This is used to get id attribute
	 * getId
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * This is used to get name attribute
	 * getName
	 * @return the name
	 */
	public String getName() {
		return name;
	}

}
