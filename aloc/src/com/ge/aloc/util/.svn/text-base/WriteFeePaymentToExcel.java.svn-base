/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: WriteFeePaymentToExcel.java
 * Purpose: WriteFeePaymentToExcel used for the write Fee payments to excel
 */
package com.ge.aloc.util;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.ge.aloc.bo.excel.CellDetail;
import com.ge.aloc.bo.excel.ExcelSheet;
import com.ge.aloc.bo.excel.ExcelSheetCollection;

/**
 * @author Rajat-Hydus
 *
 */
public class WriteFeePaymentToExcel {
	/**
	 * This method is used to write the content to the excel sheet
	 * @param workbook
	 * @param excelSheets
	 */
	public void write(HSSFWorkbook workbook, ExcelSheetCollection excelSheets){
		if(excelSheets != null) {
			for(ExcelSheet sheetDetail: excelSheets.getExcelSheet()){
				HSSFSheet excelSheet = workbook.getSheet(sheetDetail.getSheetName());
				writeContent(excelSheet,sheetDetail.getCellDetail());
			}
		}
	}
	/**
	 * This method is used to write the content to the excel sheet
	 * @param sheet
	 * @param cellList
	 */
	private void writeContent(HSSFSheet sheet,List<CellDetail> cellList) {

		for (CellDetail cellData: cellList){
			HSSFRow row = sheet.getRow(cellData.getRowId());
			if(row == null){
				row = sheet.createRow(cellData.getRowId());
			}
			HSSFCell cell =row.getCell(cellData.getColumnId());
			if(cell == null) {
				cell = row.createCell(cellData.getColumnId());
			}
			if(cellData.getAmount()!=null){
				cell.setCellValue(cellData.getAmount());	
			}else if(cellData.getDateValue()!=null){
				cell.setCellValue(cellData.getDateValue());	
			}else{
				cell.setCellValue(cellData.getValue());
			}
		}

	}

}
