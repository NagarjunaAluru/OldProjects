/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: ICFPAdminHelper.java
 * Purpose: This file will have all helper methods to handle drop down, table in admin module
 * 
 */
package com.ge.icfp.common.helper;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.ge.icfp.admin.formbean.AdminForm;
import com.ge.icfp.common.constants.ICFPConstants;
import com.ge.icfp.model.AdminDataMaintenance.AdminDataTable;
import com.ge.icfp.model.NameValue;
import com.ge.icfp.model.Row;
import com.ge.icfp.model.Row.Column;
import static com.ge.icfp.common.constants.ICFPConstants.*;

/**
 * This file will have all helper methods to handle leg, exceptions and attachments
 * @author ramakrishna.satti
 *
 */
public class ICFPAdminHelper {
	/**
	 * Clear all the filters
	 * @param adminForm
	 */
	public static void clearFilterValues(AdminForm adminForm) {
		adminForm.setFilterListValue1(null);
		adminForm.setFilterListValue2(null);
		adminForm.setFilterListValue3(null);
		adminForm.setFilterListValue4(null);
		adminForm.setFilterListValue5(null);
		adminForm.setFilterListValue6(null);
		adminForm.setFilterListValue7(null);
	}
	/**
	 * Populate the filters with unique column data
	 * @param adminForm
	 * @param rowList
	 * @return
	 */
	public static AdminForm fillFilterValues(AdminForm adminForm,
			List<Row> rowList) {
		List<NameValue> filterList1 = new ArrayList<NameValue>();
		List<NameValue> filterList2 = new ArrayList<NameValue>();
		List<NameValue> filterList3 = new ArrayList<NameValue>();
		List<NameValue> filterList4 = new ArrayList<NameValue>();
		List<NameValue> filterList5 = new ArrayList<NameValue>();
		List<NameValue> filterList6 = new ArrayList<NameValue>();
		List<NameValue> filterList7 = new ArrayList<NameValue>();

		for (Row rowValue : rowList) {
			List<Column> columnList = rowValue.getColumns();
		
			for(int i =0;i<columnList.size();i++){
				
				switch(i) {
				case 0:
					fillFilterList(filterList1, rowValue.getID(), columnList.get(i).getValue());
					break;
				case 1:
					fillFilterList(filterList2, rowValue.getID(), columnList.get(i).getValue());
					break;
				case 2:
					fillFilterList(filterList3, rowValue.getID(), columnList.get(i).getValue());
					break;
				case 3:
					fillFilterList(filterList4, rowValue.getID(), columnList.get(i).getValue());
					break;
				case 4:
					fillFilterList(filterList5, rowValue.getID(), columnList.get(i).getValue());
					break;
				case 5:
					fillFilterList(filterList6, rowValue.getID(), columnList.get(i).getValue());
					break;
				case 6:
					fillFilterList(filterList7, rowValue.getID(), columnList.get(i).getValue());
					break;
				}
			}
			
		}

		adminForm.setFilterList1(filterList1);
		adminForm.setFilterList2(filterList2);
		adminForm.setFilterList3(filterList3);
		adminForm.setFilterList4(filterList4);
		adminForm.setFilterList5(filterList5);
		adminForm.setFilterList6(filterList6);
		adminForm.setFilterList7(filterList7);
		return adminForm;
	}
	
	/**
	 * Populate the given List from the colValue and Row ID
	 * @param filterList1
	 * @param colValue 
	 * @param rowId 
	 */
	private static void fillFilterList(List<NameValue> filterList1, Integer rowId, String colValue) {
		NameValue nameValue = new NameValue();
		nameValue.setID(rowId);
		nameValue.setName(colValue);
		
		boolean isAvailable = false;
		for(NameValue obj1 : filterList1){
			if(colValue.equals(obj1.getName())){
				isAvailable = true;
			}
		}
		
		if(!isAvailable){
			filterList1.add(nameValue);
		}
	}
	/**
	 * Populate the Search criteria which can be used in the screen
	 * @param adminForm
	 * @param rowList
	 * @param columnHeaderNameList
	 * @param modalRow
	 * @return
	 */
	public static Row fillSearchCriteria(AdminForm adminForm,
			List<Row> rowList, List<String> columnHeaderNameList, Row modalRow) {
		
		if(!StringUtils.isEmpty(adminForm.getFilterListValue1())){
			fillSearchData(adminForm.getFilterListValue1(),modalRow, columnHeaderNameList.get(0));
		}
		if(!StringUtils.isEmpty(adminForm.getFilterListValue2())){
			fillSearchData(adminForm.getFilterListValue2(),modalRow, columnHeaderNameList.get(1));
		}
		if(!StringUtils.isEmpty(adminForm.getFilterListValue3())){
			fillSearchData(adminForm.getFilterListValue3(),modalRow, columnHeaderNameList.get(2));
		}
		if(!StringUtils.isEmpty(adminForm.getFilterListValue4())){
			fillSearchData(adminForm.getFilterListValue4(),modalRow, columnHeaderNameList.get(3));
		}
		if(!StringUtils.isEmpty(adminForm.getFilterListValue5())){
			fillSearchData(adminForm.getFilterListValue5(),modalRow, columnHeaderNameList.get(4));
		}
		if(!StringUtils.isEmpty(adminForm.getFilterListValue6())){
			fillSearchData(adminForm.getFilterListValue6(),modalRow, columnHeaderNameList.get(5));
		}
		if(!StringUtils.isEmpty(adminForm.getFilterListValue7())){
			fillSearchData(adminForm.getFilterListValue7(),modalRow, columnHeaderNameList.get(6));
		}
		
		return modalRow;
	}
	/**
	 * 
	 * @param filterListValue1
	 * @param modalRow
	 * @param string
	 */
	private static void fillSearchData(String filterListValue, Row modalRow,
			String columnHeaderName) {
			Column modalColumn = new Column();
			modalColumn.setValue(filterListValue);
			modalColumn.setName(columnHeaderName);
			modalRow.getColumns().add(modalColumn);
	}
	/**
	 * Updates the user action like Update or delete  performed
	 * on the screen.
	 * @param dropDownList
	 * @param adminDataTable
	 * @param inputValuesList
	 * @param inputNamesList
	 */
	public static void fillColumnData(List<Column> dropDownList,
			AdminDataTable adminDataTable, List<String> inputValuesList,
			List<String> inputNamesList) {
		String columnName = null;
		for (Column columnOldValue : dropDownList) {
			columnName = columnOldValue.getName();
			Row modalRow = new Row();
			int index = inputNamesList.indexOf(columnOldValue.getID());
			if (index >= 0) {
				if (!columnOldValue.getValue().equals(
						inputValuesList.get(index))) {
					modalRow.setOpCode(UPDATE);
					modalRow.setChange(ICFPConstants.Y_CAP);
					columnOldValue.setValue(inputValuesList.get(index));
					modalRow.setID(Integer.valueOf(columnOldValue.getID()));
				} else {
					continue;
				}
			} else {
				modalRow.setOpCode(DELETE);
				modalRow.setChange(ICFPConstants.Y_CAP);
				modalRow.setID(Integer.valueOf(columnOldValue.getID()));
			}
			modalRow.getColumns().add(columnOldValue);
			adminDataTable.getTableRows().add(modalRow);
		}

		for (int i = inputNamesList.size(); i < inputValuesList.size(); i++) {
			Column modalColumn = new Column();
			Row modalRow = new Row();
			modalRow.setOpCode(INSERT);
			modalColumn.setName(columnName);
			modalColumn.setValue(inputValuesList.get(i));
			modalRow.getColumns().add(modalColumn);
			adminDataTable.getTableRows().add(modalRow);
		}

	}
	/**
	 * Populates the Table row for display
	 * @param tableRowList
	 * @param rowIdList
	 * @param columnHeaderNameList
	 * @param columnValue1List
	 * @param columnValue2List
	 * @param columnValue3List
	 * @param columnValue4List
	 * @param columnValue5List
	 * @param columnValue6List
	 * @param columnValue7List
	 * @param adminDataTable
	 */
	public static void fillRowData(List<Row> tableRowList,
			List<String> rowIdList, List<String> columnHeaderNameList,
			List<String> columnValue1List, List<String> columnValue2List,
			List<String> columnValue3List, List<String> columnValue4List,
			List<String> columnValue5List, List<String> columnValue6List,
			List<String> columnValue7List, AdminDataTable adminDataTable) {

		for (Row rowOldValue : tableRowList) {
			Row modalRow = new Row();
			int index = rowIdList.indexOf(rowOldValue.getID().toString());
			boolean isUpdate = false;
			if (index >= 0) {
				for (int j = 0; j < rowOldValue.getColumns().size(); j++) {
					Column oldColumn = rowOldValue.getColumns().get(j);
					
					switch(j) {
					case 0:
						if (!oldColumn.getValue().equals(
								columnValue1List.get(index))) {
							isUpdate = true;
						}
						break;
					case 1:
						if (!oldColumn.getValue().equals(
								columnValue2List.get(index))) {
							isUpdate = true;
						}
						break;
					case 2:
						if (!oldColumn.getValue().equals(
								columnValue3List.get(index))) {
							isUpdate = true;
						}
						break;
					case 3:
						if (!oldColumn.getValue().equals(
								columnValue4List.get(index))) {
							isUpdate = true;
						}
						break;
					case 4:
						if (!oldColumn.getValue().equals(
								columnValue5List.get(index))) {
							isUpdate = true;
						}
						break;
					case 5:
						if (!oldColumn.getValue().equals(
								columnValue6List.get(index))) {
							isUpdate = true;
						}
						break;
					case 6:
						if (!oldColumn.getValue().equals(
								columnValue7List.get(index))) {
							isUpdate = true;
						}
						break;
					}
				}
				modalRow.setChange(ICFPConstants.Y_CAP);
				
				//fill modal row informations.
				if(!columnValue1List.isEmpty() && columnValue1List.size()>0 && !columnValue1List.get(0).equals("")){
					fillModalRow(columnValue1List,modalRow, index,columnHeaderNameList.get(0));
				}
				if(!columnValue2List.isEmpty() && columnValue2List.size()>0 && !columnValue2List.get(0).equals("")){
					fillModalRow(columnValue2List,modalRow, index,columnHeaderNameList.get(1));
				}
				if(!columnValue3List.isEmpty() && columnValue3List.size()>0 && !columnValue3List.get(0).equals("")){
					fillModalRow(columnValue3List,modalRow, index,columnHeaderNameList.get(2));
				}
				if(!columnValue4List.isEmpty() && columnValue4List.size()>0 && !columnValue4List.get(0).equals("")){
					fillModalRow(columnValue4List,modalRow, index,columnHeaderNameList.get(3));
				}
				if(!columnValue5List.isEmpty() && columnValue5List.size()>0 && !columnValue5List.get(0).equals("")){
					fillModalRow(columnValue5List,modalRow, index,columnHeaderNameList.get(4));
				}
				if(!columnValue6List.isEmpty() && columnValue6List.size()>0 && !columnValue6List.get(0).equals("")){
					fillModalRow(columnValue6List,modalRow, index,columnHeaderNameList.get(5));
				}
				if(!columnValue7List.isEmpty() && columnValue7List.size()>0 && !columnValue7List.get(0).equals("")){
					fillModalRow(columnValue7List,modalRow, index,columnHeaderNameList.get(6));
				}
				
				modalRow.setID(Integer.valueOf(rowOldValue.getID()));
				if (isUpdate) {
					modalRow.setOpCode(UPDATE);
				}
			} else {
				modalRow.setOpCode(DELETE);
				modalRow.setChange(ICFPConstants.Y_CAP);
				modalRow.setID(Integer.valueOf(rowOldValue.getID()));
			}
			if (modalRow.getOpCode() != null) {
				adminDataTable.getTableRows().add(modalRow);
			}
		}
		for (int i = 0; i < rowIdList.size(); i++) {
			if ("".equals(rowIdList.get(i))) {
				Row modalRow = new Row();
				modalRow.setOpCode(INSERT);
				
				//fill modal row informations.
				if(!columnValue1List.isEmpty() && columnValue1List.size()>0 && !columnValue1List.get(0).equals("")){
					fillModalRow(columnValue1List,modalRow, i,columnHeaderNameList.get(0));
				}
				if(!columnValue2List.isEmpty() && columnValue2List.size()>0 && !columnValue2List.get(0).equals("")){
					fillModalRow(columnValue2List,modalRow, i,columnHeaderNameList.get(1));
				}
				if(!columnValue3List.isEmpty() && columnValue3List.size()>0 && !columnValue3List.get(0).equals("")){
					fillModalRow(columnValue3List,modalRow, i,columnHeaderNameList.get(2));
				}
				if(!columnValue4List.isEmpty() && columnValue4List.size()>0 && !columnValue4List.get(0).equals("")){
					fillModalRow(columnValue4List,modalRow, i,columnHeaderNameList.get(3));
				}
				if(!columnValue5List.isEmpty() && columnValue5List.size()>0 && !columnValue5List.get(0).equals("")){
					fillModalRow(columnValue5List,modalRow, i,columnHeaderNameList.get(4));
				}
				if(!columnValue6List.isEmpty() && columnValue6List.size()>0 && !columnValue6List.get(0).equals("")){
					fillModalRow(columnValue6List,modalRow, i,columnHeaderNameList.get(5));
				}
				if(!columnValue7List.isEmpty() && columnValue7List.size()>0 && !columnValue7List.get(0).equals("")){
					fillModalRow(columnValue7List,modalRow, i,columnHeaderNameList.get(6));
				}
				
				adminDataTable.getTableRows().add(modalRow);
			}
		}

	}

	/**
	 * 
	 * @param columnValueList
	 * @param modalRow
	 * @param index
	 * @param columnHeaderNameList
	 */
	private static void fillModalRow(List<String> columnValueList, Row modalRow, int index, String columnHeaderName) {
		if (columnValueList.size() > index) {
			Column modalColumn = new Column();
			modalColumn.setValue(columnValueList.get(index));
			modalColumn.setName(columnHeaderName);
			modalRow.getColumns().add(modalColumn);
		}
	}
}
