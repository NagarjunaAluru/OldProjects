/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: DownloadDocName.java
 * Purpose: DownloadDocName used for name of the document to be download.
 */
package com.ge.aloc.reports.pdf;


/**
 * @author narasimhulu.b
 *
 */
public enum DownloadDocName {

	APPLICATION(1, "Application"),
	ATTACHMENT(2, "Attachments"),
	FORMAT(3,"Format"),
	BIDMEMOBIDREPLY(4, "BidMemo BidReply"),
	TAXONOMY(5, "Taxonomy"),
	TREASURYAPPROVER(6, "TreasuryApprover"),
	CSVAPPLICATION(7, "CSVApplication");

	private int id;
	private String name;
	/**
	 * constructor with id and name
	 * @param id
	 * @param name
	 */
	private DownloadDocName(int id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * This is used to get Id attribute
	 * @return
	 */
	public int getId() {
		return this.id;
	}
	/**
	 * This is used to get name attribute
	 * @return
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * This is used to get doenload doc name for the specific id.
	 * @param id
	 * @return
	 */
	public static DownloadDocName fromId(int id) { 
		for(DownloadDocName downloadDocName : values()) {
			if(downloadDocName.id == id) {
				return downloadDocName;
			}
		}
		return null;
	}
	/**
	 * This is used to get doenload doc name for the specific name.
	 * @param name
	 * @return
	 */
	public static DownloadDocName fromName(String name) { 
		for(DownloadDocName downloadDocName : values()) {
			if(name.equals(downloadDocName.name)) {
				return downloadDocName;
			}
		}
		return null;
	}

}
