/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: AttachmentType.java
 * Purpose: This file is used for different attachment types
 */

package com.ge.aloc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * @author chaitanya.n
 *
 */
public enum AttachmentType {
	STANDARD_FORMAT(1, "Format", 1, "Standard Format"),
	MODIFIED_STANDARD_FORMAT(1, "Format", 2, "Modified Standard Format"),
	NON_STANDARD_FORMAT(1, "Format", 3, "Non Standard Fornat"),
	OTHER(2, "Other"),
    ISSUER(3, "ISSUER"),
    CLOSURE(4, "CLOSURE"),
	WEBCASH(5, "WEBCASH"),
	IBS(6, "IBS"),
	CSV(7, "CSV");

	/**
	 * This is used make unmodifiable list 
	 */
	public static final Collection<AttachmentType> FORMAT_TYPES = Collections.unmodifiableList(new ArrayList<AttachmentType>() {

		private static final long serialVersionUID = -252653860571478648L;

		{
			add(STANDARD_FORMAT);
			add(MODIFIED_STANDARD_FORMAT);
			add(NON_STANDARD_FORMAT);
		}
	});

	/**
	 * Returns Attachment Type based on ID
	 * 
	 * @param id
	 * @return
	 */
	public static AttachmentType fromId(int id) {
		return fromId(id, null);
	}

	/**
	 * This method is used to get the attachment type based on id and format Id.
	 * @param id
	 * @param formatId
	 * @return
	 */
	public static AttachmentType fromId(int id, Integer formatId) {
		AttachmentType type = null;
		for(AttachmentType eachType : AttachmentType.values()) {
			if(eachType.id == id) {
				if(eachType.formatId == null && formatId == null) {
					type = eachType;
					break;
				}

				if(eachType.formatId != null && formatId != null && eachType.formatId.equals(formatId)) {
					type = eachType;
					break;
				}
			}
		}
		return type;
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
	 * 
	 */
	private Integer formatId;
	/**
	 * 
	 */
	private String formatName;

	/**
	 * Attachment type constructor with id, name.
	 * @param id
	 * @param name
	 */
	private AttachmentType(int id, String name) {
		this(id, name, null, null);
	}

	/**
	 * Attachment Type constructor with id, name, formatId, formatName
	 * @param id
	 * @param name
	 * @param subTypeName
	 */
	private AttachmentType(int id, String name, Integer formatId, String formatName) {
		this.id = id;
		this.name = name;
		this.formatId = formatId;
		this.formatName = formatName;
	}

	/**
	 * This is used to get id attribute
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * This is used to get name attribute
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * This is used to get formatId attribute
	 * @return the formatId
	 */
	public Integer getFormatId() {
		return formatId;
	}

	/**
	 * This is used to get format Name attribute
	 * @return the formatName
	 */
	public String getFormatName() {
		return formatName;
	}
}
