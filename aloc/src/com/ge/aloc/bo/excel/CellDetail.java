/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: CellDetail.java
 * Purpose: CellDetail.java used for maintaining CellDetail.
 *
 */
package com.ge.aloc.bo.excel;

import java.util.Date;

/**
 * @author Rajat-Hydus
 *
 */
public class CellDetail {

	protected Integer columnId;
	protected Integer rowId;
	protected String value;
	protected Double amount;
	protected Date dateValue;

	/**
	 * Gets the value of the columnId property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link Integer }
	 *     
	 */
	public Integer getColumnId() {
		return columnId;
	}

	/**
	 * Sets the value of the columnId property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link Integer }
	 *     
	 */
	public void setColumnId(Integer value) {
		this.columnId = value;
	}

	/**
	 * Gets the value of the rowId property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link Integer }
	 *     
	 */
	public Integer getRowId() {
		return rowId;
	}

	/**
	 * Sets the value of the rowId property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link Integer }
	 *     
	 */
	public void setRowId(Integer value) {
		this.rowId = value;
	}

	/**
	 * Gets the value of the value property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Sets the value of the value property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	/**
	 * Gets the value of the amount property.
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}

	/**
	 * Sets the value of the amount property.
	 * @param amount the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	/**
	 * @return the dateValue
	 */
	public Date getDateValue() {
		return dateValue;
	}

	/**
	 * @param dateValue the dateValue to set
	 */
	public void setDateValue(Date dateValue) {
		this.dateValue = dateValue;
	}

}
