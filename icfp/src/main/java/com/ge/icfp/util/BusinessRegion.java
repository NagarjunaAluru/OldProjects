/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: BusinessRegion.java
 * Purpose: Represents BusinessRegion of the deal
 */
package com.ge.icfp.util;

import com.ge.icfp.common.attachments.AttachmentType;

/**
 * @author chaitanya.n
 *
 */
public enum BusinessRegion {
	AMERICAS(1, "Americas"), EUROPE(2, "Europe"), ASIA(3, "Asia");
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public static BusinessRegion fromId(int id) {
		for(BusinessRegion region : values()) {
			if(region.getId() == id) {
				return region;
			}
		}
		return null;
	}
	
	/**
	 * Returns BusinessRegion Type based on name.
	 * 
	 * @param name
	 * @return
	 */
	public static BusinessRegion fromName(String name) {
		BusinessRegion type = null;
		for(BusinessRegion eachType : BusinessRegion.values()) {
			if(eachType.getName().equalsIgnoreCase(name)) {
				type = eachType;
				break;
			}
		}
		return type;
	}
	
	private int id;
	private String name;
	
	/**
	 * 
	 * @param id
	 */
	private BusinessRegion(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
}
