/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ExcelSheetCollection.java
 * Purpose: ExcelSheetCollection.java used for maintaining ExcelSheetCollection.
 *
 */
package com.ge.aloc.bo.excel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rajat-Hydus
 *
 */
public class ExcelSheetCollection {

	protected List<ExcelSheet> excelSheet;

	/**
	 * Gets the value of the excelSheet property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list,
	 * not a snapshot. 
	 * This is why there is not a <CODE>set</CODE> method for the excelSheet property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * <pre>
	 *    getExcelSheet().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link ExcelSheet }
	 * 
	 * 
	 */
	public List<ExcelSheet> getExcelSheet() {
		if (excelSheet == null) {
			excelSheet = new ArrayList<ExcelSheet>();
		}
		return this.excelSheet;
	}

}
