/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: FormatType.java
 * Purpose: This file is used for different attachment format types
 */
package com.ge.aloc;

/**
 * @author rajeswari.guthi
 *
 */
public enum FormatType {
	STANDARD(1), MODIFIED(2), NON_STANDARD(3);

	/**
	 * This method is used to get the format type based on id.
	 * @param id
	 * @return
	 */
	public static FormatType fromId(int id) {
		FormatType type = null;
		for(FormatType formatType : FormatType.values()) {
			if(formatType.id == id) {
				type = formatType;
				break;
			}
		}
		return type;
	}

	/**
	 * 
	 */
	private int id;

	/**
	 * FormatType constructor with Id.
	 * @param id
	 */
	private FormatType(int id) {
		this.id = id;
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
