/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: ProductType.java
 * Purpose: Represents Product Type of leg
 */
package com.ge.icfp.util;

/**
 * @author chaitanya
 *
 */
public enum ProductType {
	RCA(1), EQUITY(2), CPA(3), OTHER(4), TERM_LOAN(5), BOND(6);
	
	private int id;
	
	/**
	 * Constructor to create ProductType object
	 * 
	 * @param id
	 */
	private ProductType(int id) {
		this.id = id;
	}
	
	/**
	 * Returns the ID of ProductType
	 * 
	 * @return
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * Returns the Product Type based on ID.
	 * 
	 * @param id
	 * @return
	 */
	public static ProductType fromId(int id) {
		ProductType result = null;
		for(ProductType productType : ProductType.values()) {
			if(productType.getId() == id) {
				result = productType;
			}
		}
		return result;
	}
}
