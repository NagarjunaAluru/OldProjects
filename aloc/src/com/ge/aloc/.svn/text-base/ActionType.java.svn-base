/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ActionType.java
 * Purpose: ActionType used for the all action constants.
 */
package com.ge.aloc;

/**
 * @author narasimhulu.b
 *
 */
public enum ActionType {
	SAVEANDCONTINUE(0,"SAVE"),
	SAVE(1, "SAVE"),
	SUBMIT(2, "SUBMIT"),
	SENDBACK(3,"SENDBACK"),
	APPROVE(4, "APPROVE"),
	REJECT(5, "REJECT"),
	SAVE_AS_MODEL(7, "SAVE"),
	SAVE_SYSTEM_CHECK(8, "SAVE"),
	SUBMIT_BID_REPLY(9, "SAVE"),
	OPT_OUT(10, "OPTOUT"),

	SUBMIT_BID_REPLY_FOR_BUNDLE(11, "SAVE"),
	SUBMIT_BID_MEMO_FOR_BUNDLE(12, "SUBMIT"),

	AWARD_TO_SURETY(13,"AWARDTOSURETY"),
	RETURN_TO_SURETY(14,"RETURNTOSURETY"),

	COMPLETE_TRANSACTION(20,"Complete transaction"),
	DECLINE_TRANSACTION(21,"Decline transaction"),
	BANK_AGREES_TO_CONFIRMATION(22,"Bank agrees to confirmation"),
	BANK_DECLINES_CONFIRMATION(23,"Bank declines confirmation"),
	COMPLETE_AMENDMENT(24,"Complete Amendment"),
	REJECT_AMENDMENT(25,"Reject Amendment"),
	COMPLETE_RIDER(26,"Complete Rider"),
	REJECT_RIDER(27,"Reject Rider"),
	RE_SUBMIT(32,"ReSubmit"),
	RESTART_BIDPROCESS(34,"RestartBidProcess"),
	SAVE_SELECT_BANKS(36,"SaveSelectBanks"),
	RESUBMIT_BIDMEMO(33,"ReSubmitBidMemo"),
	DELETE_AMENDMENT(37,"DELETE"),
	SEND_TO_BIDAWARD(38,"SendToBidAward");

	/**
	 * This method is used to get the action type based on id.
	 * @param id
	 * @return
	 */
	public static ActionType fromId(int id) { 
		for(ActionType actionType : values()) {
			if(actionType.id == id) {
				return actionType;
			}
		}
		return null;
	}
	/**
	 * This method is used to get the action type based on name.
	 * @param name
	 * @return
	 */
	public static ActionType fromName(String name) { 
		for(ActionType actionType : values()) {
			if(name.equals(actionType.name)) {
				return actionType;
			}
		}
		return null;
	}

	private int id;
	private String name;
	/**
	 * ActionType constructor with id, name
	 * @param id
	 * @param name
	 */
	private ActionType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * This is used to get id attribute
	 * getId
	 * @return
	 */
	public int getId() {
		return this.id;
	}
	/**
	 * This is used to get name attribute
	 * getName
	 * @return
	 */
	public String getName() {
		return this.name;
	}
}
