/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ReportTypes.java
 * Purpose: ReportTypes used for the all Report Names Constants.
 */
package com.ge.aloc;

/**
 * @author rajasekhar.b
 *
 */
public enum ReportTypes {
	ISSUANCEEXPIRATIONREPORT(1, "Issuance and Expiration Report"),
	BIDSUCCESSREPORT(2, "Bid Success Report"),
	CONTINGENTREPORT(3, "Contingent Report"),
	AGINGREPORT(4, "Aging_Report"),
	FEESPAIDREPORT(5, "Fees Paid Report"),
	CYCLETIMEREPORT(6, "Cycle Time Report"),
	USERREPORT(7, "User Report"),
	ECSOREPORT(8, "ECSO Report"),
	GCFOREPORT(9, "GCFO Report"),
	AVERAGEFEESPAIDREPORT(10, "Avg Fees Paid Report"),
	FEEQUOTATIONREPORT(11, "Fee Quotation and Forcast Report"),
	FEEPROJECTIONREPORT(12, "Fee Projection Report");


	/**
	 * This method is used to get the ReportTypes based on name.
	 * @param id
	 * @return
	 */
	public static ReportTypes fromName(String name) { 
		for(ReportTypes reportTypes : values()) {
			if(reportTypes.name.equalsIgnoreCase(name)) {
				return reportTypes;
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
	 * ReportTypes constructor with id, name.
	 * @param id
	 * @param name
	 */
	private ReportTypes(int id, String name) {
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
