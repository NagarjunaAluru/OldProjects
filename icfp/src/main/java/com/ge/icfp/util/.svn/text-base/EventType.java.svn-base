/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: ProductType.java
 * Purpose: Represents Event Type of leg
 */
package com.ge.icfp.util;

/**
 * @author chaitanya
 *
 */
public enum EventType {
	CASHPOOL_TERMINATION(1), 
	CASHPOOL_OTHER(2),
	ASSIGNMENT(3),
	AMENDMENT_AGREMENT_EXTENSION(4),
	AMENDMENT_FACILITY_INC_DEC(5),
	GENERAL_AMENDMENT(6),
	PREPAYMENT(7), 
	DRAWDOWN(8),
	EARYLY_TERMINATION(9),
	CORRECTION(10),
	DEBT_EQUITY_OTHER(11),
	DEVIDENTS(12);   
	
	private int id;
	
	/**
	 * Constructor to create EventType object
	 * 
	 * @param id
	 */
	private EventType(int id) {
		this.id = id;
	}
	
	/**
	 * Returns the ID of EventType
	 * 
	 * @return
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * Returns the Event Type based on ID.
	 * 
	 * @param id
	 * @return
	 */
	public static EventType fromId(int id) {
		EventType result = null;
		for(EventType eventType : EventType.values()) {
			if(eventType.getId() == id) {
				result = eventType;
			}
		}
		return result;
	}
}
