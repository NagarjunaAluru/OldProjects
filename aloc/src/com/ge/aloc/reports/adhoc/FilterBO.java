/**
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: FilterBO.java
 * Purpose: FilterBO used to manage Filters for Adhoc Report
 */
package com.ge.aloc.reports.adhoc;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.ge.aloc.constants.ALOCConstants;

/**
 * @author chaitanya.n
 *
 */
public class FilterBO {
	
	private String fieldId;
	private Operator operator;
	private String condition;
	private List<String> value;
	private DataType dataType;
	
	/**
	 * @return the fieldId
	 */
	public String getFieldId() {
		return fieldId;
	}
	/**
	 * @return the operator
	 */
	public Operator getOperatorType() {
		return operator;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getOperator() {
		return (operator == null) ? null : operator.value();
	}
	
	/**
	 * @return the conditionalOperator
	 */
	public String getCondition() {
		return condition;
	}
	/**
	 * @return the values
	 */
	public List<String> getValue() {
		if(value == null) {
			value = new ArrayList<String>(ALOCConstants.SECOND_VALUE);
		}
		return value;
	}
	
	/**
	 * @param value the value to set
	 */
	public void setValue(List<String> value) {
		this.value = value;
	}
	/**
	 * @param fieldId the fieldId to set
	 */
	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
	}
	
	/**
	 * @param operator the operator to set
	 */
	public void setOperatorType(Operator operator) {
		this.operator = operator;
	}
	
	/**
	 * To Set the Operator Value
	 * @param value
	 */
	public void setOperator(String value) {
		if(StringUtils.isNotBlank(value)){
			this.operator = Operator.fromValue(value);
		}
	}
	
	/**
	 * @param conditionalOperator the conditionalOperator to set
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}
	/**
	 * @return the dataType
	 */
	public DataType getDataType() {
		return dataType;
	}
	/**
	 * @param dataType the dataType to set
	 */
	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}
}
