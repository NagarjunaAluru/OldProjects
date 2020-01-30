/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: AttachmentType.java
 * Purpose: Represents Attachment Type  
 */
package com.ge.icfp.common.attachments;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;


/**
 * @author chaitanya.n
 * This class used for defining all attachment types and categorizing the specific types
 */
public enum AttachmentType {
	CASH_MAP(1, "Cash Map"),
	STRUCTURED_DIAGRAM(2, "Structured Diagram"),
	LEGAL_AGREEMENTS(3, "Legal Agreements"),
	CONSOLIDATED_FINANCIAL_STATEMENTS(4, "Consolidated Financial Statements"),
	CORPORATE_GOVERNANCE_DOCUMENTS(5, "Corporate Governance Documents"),
	OTHER_DOCUMENTS(6, "Other Documents"),
	JOURNAL_ENTRIES(7, "Journal Entries"),
	TRANSFER_PRICING_ATTACHMENTS(8, "Transfer Pricing"),
	DERIVATIVE_TRADE_TICKET(9, "Derivative Trade Ticket"),
	EXCEPTIONS_ATTACHMENTS(10, "Exceptions Documents"),
	EQUITY_PITCH(11, "Equity Pitch"),
	AMENDMENTS_ATTACHMENTS(12, "Amendments Documents"),
	UNDERWRITING(21, "Underwriting File");
	
	private static final Collection<AttachmentType> MULTI_ATTACHMENT_TYPES = Collections.unmodifiableCollection(Arrays.asList(new AttachmentType[] {OTHER_DOCUMENTS,JOURNAL_ENTRIES}));
	private static final Collection<AttachmentType> DEAL_ATTACHMENT_TYPES = Collections.unmodifiableCollection(Arrays.asList(new AttachmentType[] {CASH_MAP, STRUCTURED_DIAGRAM, EQUITY_PITCH}));
	private static final Collection<AttachmentType> LEG_ATTACHMENT_TYPES = Collections.unmodifiableCollection(Arrays.asList(new AttachmentType[] {
			LEGAL_AGREEMENTS, CONSOLIDATED_FINANCIAL_STATEMENTS, CORPORATE_GOVERNANCE_DOCUMENTS, OTHER_DOCUMENTS, JOURNAL_ENTRIES, TRANSFER_PRICING_ATTACHMENTS}));
	public static final AttachmentType[] DEALPAGE_ATMT_TYPES = new AttachmentType[] {
		CASH_MAP, STRUCTURED_DIAGRAM, LEGAL_AGREEMENTS, EQUITY_PITCH,
		CONSOLIDATED_FINANCIAL_STATEMENTS, CORPORATE_GOVERNANCE_DOCUMENTS,
		OTHER_DOCUMENTS, JOURNAL_ENTRIES, TRANSFER_PRICING_ATTACHMENTS
	};
	public static final AttachmentType[] LEGPAGE_ATMT_TYPES = new AttachmentType[] {
		CASH_MAP, STRUCTURED_DIAGRAM, LEGAL_AGREEMENTS, EQUITY_PITCH,
		CONSOLIDATED_FINANCIAL_STATEMENTS, CORPORATE_GOVERNANCE_DOCUMENTS,
		OTHER_DOCUMENTS, JOURNAL_ENTRIES, TRANSFER_PRICING_ATTACHMENTS,
		DERIVATIVE_TRADE_TICKET
	};
	
	/**
	 * 
	 * @return
	 */
	public static Collection<AttachmentType> getMultipleAllowedTypes() {
		return MULTI_ATTACHMENT_TYPES;
	}
	
	/**
	 * 
	 * @param type
	 * @return
	 */
	public static boolean isDealAttachmentType(AttachmentType type) {
		return DEAL_ATTACHMENT_TYPES.contains(type);
	}
	
	/**
	 * 
	 * @param type
	 * @return
	 */
	public static boolean isLegAttachmentType(AttachmentType type) {
		return LEG_ATTACHMENT_TYPES.contains(type);
	}
	
	/**
	 * Returns Attachment Type based on ID
	 * 
	 * @param id
	 * @return
	 */
	public static AttachmentType fromId(int id) {
		AttachmentType type = null;
		for(AttachmentType eachType : AttachmentType.values()) {
			if(eachType.getId() == id) {
				type = eachType;
				break;
			}
		}
		return type;
	}
	
	/**
	 * Returns Attachment Type based on name.
	 * 
	 * @param name
	 * @return
	 */
	public static AttachmentType fromName(String name) {
		AttachmentType type = null;
		for(AttachmentType eachType : AttachmentType.values()) {
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
	 * @param name
	 */
	private AttachmentType(int id, String name) {
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
	
	/**
	 * 
	 * @return
	 */
	public String getName() {
		return this.name;
	}
}
