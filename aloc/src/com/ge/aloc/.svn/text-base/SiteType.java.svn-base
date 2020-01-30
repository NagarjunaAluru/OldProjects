/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: SiteSectionFactory.java
 * Purpose: SiteSectionFactory used for the creation of each section in the site.
 */
package com.ge.aloc;

/**
 * @author madhusudhan.gosula
 *
 */
public enum SiteType {
	FINANCIAL_BUSINESS_SITE(1, "Financial Business Site"),
	BANK_SITE(2, "Bank Site"),
	TREASURY(3, "Treasury"),
	INDUSTRAIL_BUSINESS_SITE(4, "Industrail Business Site"),
	SURETY(5, "Surety");

	/**
	 * This method is used to get the site type based on id.
	 * @param id
	 * @return
	 */
	public static SiteType fromId(int id) { 
		for(SiteType siteType : values()) {
			if(siteType.id == id) {
				return siteType;
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
	private SiteType(int id, String name) {
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
