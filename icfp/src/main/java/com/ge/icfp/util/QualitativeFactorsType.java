/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: QualitativeFactorTypes.java
 * Purpose: Represents Event Type of leg
 */
package com.ge.icfp.util;

public enum QualitativeFactorsType {
	REGULATORY_RISK(1, "Regulatory Risk"),
	LEGAL_GOVERNANCE_RISK(2, "Legal Governance Risk"),
	SOLVEREIGN_RISK(3, "Sovereign Risk"),
	REPUTATIONAL_RISK(4, "Reputational Risk"),
	FINANCE_RISK(5, "Finance Risk"),
	OPERATIONAL_RISK_INITIAL(6, "Operational Risk - Initial"),
	OPERATIONAL_RISK_ONGOING(7, "Operational Risk - Ongoing"),
	TAX_RISK(8, "Tax Risk"),
	LEGAL_RISK(9, "Legal Risk"),
	TRANSFER_PRICING_RISK(10, "Transfer Pricing Risk"),
	COUNTRY_TAX_RISK(11, "Regulatory/Jurisdictional Reviews Risk");
	
	private int id;
	private String name;
	
	private QualitativeFactorsType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	/**
	 * Returns the Event Type based on ID.
	 * 
	 * @param id
	 * @return
	 */
	public static QualitativeFactorsType fromId(int id) {
		QualitativeFactorsType result = null;
		for(QualitativeFactorsType qualitativeFactorType : QualitativeFactorsType.values()) {
			if(qualitativeFactorType.getId() == id) {
				result = qualitativeFactorType;
			}
		}
		return result;
	}
}
