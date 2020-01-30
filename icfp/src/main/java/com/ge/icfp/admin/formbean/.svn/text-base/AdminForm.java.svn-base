/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: AdminForm.java
 * Purpose: AdminForm used for static data maintaince and access approvals attributes.
 */
package com.ge.icfp.admin.formbean;

import java.util.List;
import java.util.Map;

import org.apache.struts.action.ActionForm;

import com.ge.icfp.model.AuditLog;
import com.ge.icfp.model.ModifyApprover.ModifyApprovers;
import com.ge.icfp.model.ModifyApprover.ModifyApprovers.Reassign;
import com.ge.icfp.model.NameValue;
import com.ge.icfp.model.Row;
import com.ge.icfp.model.Row.Column;

/**
 * @author madhusudhan.gosula
 *
 */
public class AdminForm extends ActionForm {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Column> dropDownList;
	private List<Row> tableList;
	private List<Row> oldTableList;
	private List<AuditLog> changeLog;
	private List<ModifyApprovers> modifyApprovers;
	private String[] inputName;
	private String[] inputValue;
	private String[] rowId;
	private String[] columnHeaderName;
	private String[] columnValue1;
	private String[] columnValue2;
	private String[] columnValue3;
	private String[] columnValue4;
	private String[] columnValue5;
	private String[] columnValue6;
	private String[] columnValue7;
	private String[] selectedColumn;
	private String selectedColumnId;
	private String tableName;
	private String sourceName;
	private String dealRequestID;
	private String businessID;
	private String eboardValue;
	private String eboardID;
	private String ssoID;

	private List<String> columnHeaderNameList;
	private List<NameValue> filterList1;
	private List<NameValue> filterList2;
	private List<NameValue> filterList3;
	private List<NameValue> filterList4;
	private List<NameValue> filterList5;
	private List<NameValue> filterList6;
	private List<NameValue> filterList7;
	
	private String filterListValue1;
	private String filterListValue2;
	private String filterListValue3;
	private String filterListValue4;
	private String filterListValue5;
	private String filterListValue6;
	private String filterListValue7;
	
	private Map<String,List<Reassign>> teamMembers;
	private List<Reassign> reasignList;
	private String teamMemberValue;
	/**
	 * @return the teamMemberValue
	 */
	public String getTeamMemberValue() {
		return teamMemberValue;
	}

	/**
	 * @param teamMemberValue the teamMemberValue to set
	 */
	public void setTeamMemberValue(String teamMemberValue) {
		this.teamMemberValue = teamMemberValue;
	}

	/**
	 * @return the dropDownList
	 */
	public List<Column> getDropDownList() {
		return dropDownList;
	}

	/**
	 * @param dropDownList the dropDownList to set
	 */
	public void setDropDownList(List<Column> dropDownList) {
		this.dropDownList = dropDownList;
	}

	/**
	 * @return the tableList
	 */
	public List<Row> getTableList() {
		return tableList;
	}

	/**
	 * @param tableList the tableList to set
	 */
	public void setTableList(List<Row> tableList) {
		this.tableList = tableList;
	}

	/**
	 * @return the oldTableList
	 */
	public List<Row> getOldTableList() {
		return oldTableList;
	}

	/**
	 * @param oldTableList the oldTableList to set
	 */
	public void setOldTableList(List<Row> oldTableList) {
		this.oldTableList = oldTableList;
	}

	/**
	 * @return the changeLog
	 */
	public List<AuditLog> getChangeLog() {
		return changeLog;
	}

	/**
	 * @param changeLog the changeLog to set
	 */
	public void setChangeLog(List<AuditLog> changeLog) {
		this.changeLog = changeLog;
	}

	/**
	 * @return the modifyApprovers
	 */
	public List<ModifyApprovers> getModifyApprovers() {
		return modifyApprovers;
	}

	/**
	 * @param modifyApprovers the modifyApprovers to set
	 */
	public void setModifyApprovers(List<ModifyApprovers> modifyApprovers) {
		this.modifyApprovers = modifyApprovers;
	}

	/**
	 * @return the inputName
	 */
	public String[] getInputName() {
		return inputName;
	}

	/**
	 * @param inputName the inputName to set
	 */
	public void setInputName(String[] inputName) {
		this.inputName = inputName;
	}

	/**
	 * @return the inputValue
	 */
	public String[] getInputValue() {
		return inputValue;
	}

	/**
	 * @param inputValue the inputValue to set
	 */
	public void setInputValue(String[] inputValue) {
		this.inputValue = inputValue;
	}

	/**
	 * @return the rowId
	 */
	public String[] getRowId() {
		return rowId;
	}

	/**
	 * @param rowId the rowId to set
	 */
	public void setRowId(String[] rowId) {
		this.rowId = rowId;
	}

	/**
	 * @return the columnHeaderName
	 */
	public String[] getColumnHeaderName() {
		return columnHeaderName;
	}

	/**
	 * @param columnHeaderName the columnHeaderName to set
	 */
	public void setColumnHeaderName(String[] columnHeaderName) {
		this.columnHeaderName = columnHeaderName;
	}

	/**
	 * @return the columnValue1
	 */
	public String[] getColumnValue1() {
		return columnValue1;
	}

	/**
	 * @param columnValue1 the columnValue1 to set
	 */
	public void setColumnValue1(String[] columnValue1) {
		this.columnValue1 = columnValue1;
	}

	/**
	 * @return the columnValue2
	 */
	public String[] getColumnValue2() {
		return columnValue2;
	}

	/**
	 * @param columnValue2 the columnValue2 to set
	 */
	public void setColumnValue2(String[] columnValue2) {
		this.columnValue2 = columnValue2;
	}

	/**
	 * @return the columnValue3
	 */
	public String[] getColumnValue3() {
		return columnValue3;
	}

	/**
	 * @param columnValue3 the columnValue3 to set
	 */
	public void setColumnValue3(String[] columnValue3) {
		this.columnValue3 = columnValue3;
	}

	/**
	 * @return the columnValue4
	 */
	public String[] getColumnValue4() {
		return columnValue4;
	}

	/**
	 * @param columnValue4 the columnValue4 to set
	 */
	public void setColumnValue4(String[] columnValue4) {
		this.columnValue4 = columnValue4;
	}

	/**
	 * @return the columnValue5
	 */
	public String[] getColumnValue5() {
		return columnValue5;
	}

	/**
	 * @param columnValue5 the columnValue5 to set
	 */
	public void setColumnValue5(String[] columnValue5) {
		this.columnValue5 = columnValue5;
	}

	/**
	 * @return the columnValue6
	 */
	public String[] getColumnValue6() {
		return columnValue6;
	}

	/**
	 * @param columnValue6 the columnValue6 to set
	 */
	public void setColumnValue6(String[] columnValue6) {
		this.columnValue6 = columnValue6;
	}

	/**
	 * @return the columnValue7
	 */
	public String[] getColumnValue7() {
		return columnValue7;
	}

	/**
	 * @param columnValue7 the columnValue7 to set
	 */
	public void setColumnValue7(String[] columnValue7) {
		this.columnValue7 = columnValue7;
	}

	/**
	 * @return the selectedColumn
	 */
	public String[] getSelectedColumn() {
		return selectedColumn;
	}

	/**
	 * @param selectedColumn the selectedColumn to set
	 */
	public void setSelectedColumn(String[] selectedColumn) {
		this.selectedColumn = selectedColumn;
	}

	/**
	 * @return the tableName
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * @param tableName the tableName to set
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/**
	 * @return the sourceName
	 */
	public String getSourceName() {
		return sourceName;
	}

	/**
	 * @param sourceName the sourceName to set
	 */
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	/**
	 * @return the dealRequestID
	 */
	public String getDealRequestID() {
		return dealRequestID;
	}

	/**
	 * @param dealRequestID the dealRequestID to set
	 */
	public void setDealRequestID(String dealRequestID) {
		this.dealRequestID = dealRequestID;
	}

	/**
	 * @return the businessID
	 */
	public String getBusinessID() {
		return businessID;
	}

	/**
	 * @param businessID the businessID to set
	 */
	public void setBusinessID(String businessID) {
		this.businessID = businessID;
	}

	/**
	 * @return the eboardValue
	 */
	public String getEboardValue() {
		return eboardValue;
	}

	/**
	 * @param eboardValue the eboardValue to set
	 */
	public void setEboardValue(String eboardValue) {
		this.eboardValue = eboardValue;
	}

	/**
	 * @return the eboardID
	 */
	public String getEboardID() {
		return eboardID;
	}

	/**
	 * @param eboardID the eboardID to set
	 */
	public void setEboardID(String eboardID) {
		this.eboardID = eboardID;
	}

	/**
	 * @return the ssoID
	 */
	public String getSsoID() {
		return ssoID;
	}

	/**
	 * @param ssoID the ssoID to set
	 */
	public void setSsoID(String ssoID) {
		this.ssoID = ssoID;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the selectedColumnId
	 */
	public String getSelectedColumnId() {
		return selectedColumnId;
	}

	/**
	 * @param selectedColumnId the selectedColumnId to set
	 */
	public void setSelectedColumnId(String selectedColumnId) {
		this.selectedColumnId = selectedColumnId;
	}

	/**
	 * @return the columnHeaderNameList
	 */
	public List<String> getColumnHeaderNameList() {
		return columnHeaderNameList;
	}

	/**
	 * @param columnHeaderNameList the columnHeaderNameList to set
	 */
	public void setColumnHeaderNameList(List<String> columnHeaderNameList) {
		this.columnHeaderNameList = columnHeaderNameList;
	}

	/**
	 * @return the filterList1
	 */
	public List<NameValue> getFilterList1() {
		return filterList1;
	}

	/**
	 * @param filterList1 the filterList1 to set
	 */
	public void setFilterList1(List<NameValue> filterList1) {
		this.filterList1 = filterList1;
	}

	/**
	 * @return the filterList2
	 */
	public List<NameValue> getFilterList2() {
		return filterList2;
	}

	/**
	 * @param filterList2 the filterList2 to set
	 */
	public void setFilterList2(List<NameValue> filterList2) {
		this.filterList2 = filterList2;
	}

	/**
	 * @return the filterList3
	 */
	public List<NameValue> getFilterList3() {
		return filterList3;
	}

	/**
	 * @param filterList3 the filterList3 to set
	 */
	public void setFilterList3(List<NameValue> filterList3) {
		this.filterList3 = filterList3;
	}

	/**
	 * @return the filterList4
	 */
	public List<NameValue> getFilterList4() {
		return filterList4;
	}

	/**
	 * @param filterList4 the filterList4 to set
	 */
	public void setFilterList4(List<NameValue> filterList4) {
		this.filterList4 = filterList4;
	}

	/**
	 * @return the filterList5
	 */
	public List<NameValue> getFilterList5() {
		return filterList5;
	}

	/**
	 * @param filterList5 the filterList5 to set
	 */
	public void setFilterList5(List<NameValue> filterList5) {
		this.filterList5 = filterList5;
	}

	/**
	 * @return the filterList6
	 */
	public List<NameValue> getFilterList6() {
		return filterList6;
	}

	/**
	 * @param filterList6 the filterList6 to set
	 */
	public void setFilterList6(List<NameValue> filterList6) {
		this.filterList6 = filterList6;
	}

	/**
	 * @return the filterList7
	 */
	public List<NameValue> getFilterList7() {
		return filterList7;
	}

	/**
	 * @param filterList7 the filterList7 to set
	 */
	public void setFilterList7(List<NameValue> filterList7) {
		this.filterList7 = filterList7;
	}

	/**
	 * @return the filterListValue1
	 */
	public String getFilterListValue1() {
		return filterListValue1;
	}

	/**
	 * @param filterListValue1 the filterListValue1 to set
	 */
	public void setFilterListValue1(String filterListValue1) {
		this.filterListValue1 = filterListValue1;
	}

	/**
	 * @return the filterListValue2
	 */
	public String getFilterListValue2() {
		return filterListValue2;
	}

	/**
	 * @param filterListValue2 the filterListValue2 to set
	 */
	public void setFilterListValue2(String filterListValue2) {
		this.filterListValue2 = filterListValue2;
	}

	/**
	 * @return the filterListValue3
	 */
	public String getFilterListValue3() {
		return filterListValue3;
	}

	/**
	 * @param filterListValue3 the filterListValue3 to set
	 */
	public void setFilterListValue3(String filterListValue3) {
		this.filterListValue3 = filterListValue3;
	}

	/**
	 * @return the filterListValue4
	 */
	public String getFilterListValue4() {
		return filterListValue4;
	}

	/**
	 * @param filterListValue4 the filterListValue4 to set
	 */
	public void setFilterListValue4(String filterListValue4) {
		this.filterListValue4 = filterListValue4;
	}

	/**
	 * @return the filterListValue5
	 */
	public String getFilterListValue5() {
		return filterListValue5;
	}

	/**
	 * @param filterListValue5 the filterListValue5 to set
	 */
	public void setFilterListValue5(String filterListValue5) {
		this.filterListValue5 = filterListValue5;
	}

	/**
	 * @return the filterListValue6
	 */
	public String getFilterListValue6() {
		return filterListValue6;
	}

	/**
	 * @param filterListValue6 the filterListValue6 to set
	 */
	public void setFilterListValue6(String filterListValue6) {
		this.filterListValue6 = filterListValue6;
	}

	/**
	 * @return the filterListValue7
	 */
	public String getFilterListValue7() {
		return filterListValue7;
	}

	/**
	 * @param filterListValue7 the filterListValue7 to set
	 */
	public void setFilterListValue7(String filterListValue7) {
		this.filterListValue7 = filterListValue7;
	}

	/**
	 * @return the teamMembers
	 */
	public Map<String, List<Reassign>> getTeamMembers() {
		return teamMembers;
	}

	/**
	 * @param teamMembers the teamMembers to set
	 */
	public void setTeamMembers(Map<String, List<Reassign>> teamMembers) {
		this.teamMembers = teamMembers;
	}

	/**
	 * @return the reasignList
	 */
	public List<Reassign> getReasignList() {
		return reasignList;
	}

	/**
	 * @param reasignList the reasignList to set
	 */
	public void setReasignList(List<Reassign> reasignList) {
		this.reasignList = reasignList;
	}

}
