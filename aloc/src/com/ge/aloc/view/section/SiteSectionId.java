/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: SiteSectionId.java
 * Purpose: SiteSectionId used for the section Id details.
 */
package com.ge.aloc.view.section;

/**
 * @author chaitanya.n
 *
 */
public enum SiteSectionId implements SectionId {

	CREATE_NEW_SITE("site.section.createNewSite"),
	DEFAULT_DELIVERY_INSTRUCTIONS("site.section.defaultDeliveryInstructions"),
	CUSTOMIZED_SITE_REFERENCES("site.section.customizedSiteReferences"),
	BANK_FEE_PAYMENT_SETUP("site.section.bankFeePaymentSetup"),
	CREATE_DELEGATION_CONFIGURATION("site.section.createDelegateConfig"),
	BANK_SWIFT_CONFIGURATION("site.section.bankSwiftConfig"),
	COPY_SELECT_BOX("site.section.copySelectBox"),
	COPY_SITE("site.section.copySite"),
	BUSINESS_SITE_CURRENT_DELEGATES("businessSite.section.currentDelegates"),
	BUSINESS_SITE_AVAILABLE_APPROVERS("businessSite.section.availableApprovers"),
	MODIFY_SITE("site.section.modifySite");
	/**
	 * This is used to get site section Id based on the key value.
	 * @param id
	 * @return
	 */
	public static SiteSectionId fromString(String key) {
		for(SiteSectionId siteSectionId : values()) {
			if(siteSectionId.key.equals(key)) {
				return siteSectionId;
			}
		}
		return null;
	}
	/**
	 * 
	 */
	private String key;
	/**
	 * Constructor to create instance
	 * @param key
	 */
	private SiteSectionId(String key) {
		this.key = key;
	}
	/**
	 * This is used to get as String.
	 */
	public String getAsString() {
		return this.key;
	}
}
