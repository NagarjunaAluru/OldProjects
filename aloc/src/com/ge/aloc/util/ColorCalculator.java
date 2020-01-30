/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ColorCalculator.java
 * Purpose: ColorCalculator used for the color calculations.
 */
package com.ge.aloc.util;

import java.math.BigInteger;

import com.ge.aloc.InstrumentType;
import com.ge.aloc.constants.ALOCConstants;
import com.hydus.hwf.util.StringUtils;

/**
 * @author madhusudhan.gosula
 *
 */
public class ColorCalculator {
	
	private static final String BIDS_ROW = "bidsRow";
	private static final String ADVANCE_ROW = "advanceRow";
	private static final String PERFOR_ROW = "perforRow";
	private static final String FINANCIAL_ROW = "financialRow";
	private static final String NO_PURPOSE_ROW = "noPurposeRow";
	private static final String DOC_ROW = "docRow";
	
	private static final String BIDS_ROW_INNER = "bidsRowInner";
	private static final String ADVANCE_ROW_INNER = "advanceRowInner";
	private static final String PERFOR_ROW_INNER = "perforRowInner";
	private static final String FINANCIAL_ROW_INNER = "financialRowInner";
	private static final String DOC_ROW_INNER = "docRowInner";
	
	private static final String DOC_ROW_COLOR = "docRowColor";
	private static final String BIDS_ROW_COLOR = "bidsRowColor";
	private static final String ADVANCE_ROW_COLOR = "advanceRowColor";
	private static final String PERFOR_ROW_COLOR = "perforRowColor";
	private static final String FINANCIAL_ROW_COLOR = "financialRowColor";
	
	private static final String ORANGE_SECTION = "orangeSection";
	private static final String GRAY_SECTION = "graySection";
	private static final String BLUE_SECTION = "blueSection";
	private static final String GREEN_SECTION = "greenSection";
	private static final String RED_SECTION = "redSection";
	private static final String NP_SECTION = "noInstrPurposeSection";
	
	/**
	 * This method is used to get the Row Id.
	 * @param instrTypeId
	 * @param instrPurposeId
	 * @param bondTypeId
	 * @param subBondTypeId
	 * @return
	 */
	public static String getRowId(BigInteger instrTypeId, BigInteger instrPurposeId, BigInteger bondTypeId, BigInteger subBondTypeId) {
		if(instrTypeId == null) {
			return null;
		}
		
		switch(instrTypeId.intValue()) {
			case ALOCConstants.DOC_ROW:
				return DOC_ROW;
			case ALOCConstants.SURETY_ROW:
			case ALOCConstants.RIDER_ROW:
				if(bondTypeId != null && bondTypeId.intValue() == ALOCConstants.BIDBOND_ID) {
					return BIDS_ROW;
				} else if(bondTypeId != null && bondTypeId.intValue() == ALOCConstants.CONTRACTBOND_ID && subBondTypeId != null && subBondTypeId.intValue() == ALOCConstants.ADVANCEPAYMENT) {
					return ADVANCE_ROW;
				} else {
					return PERFOR_ROW;
				}
			default:
				if(instrPurposeId==null){
					return NO_PURPOSE_ROW;
				}
				switch(instrPurposeId.intValue()) {
					case ALOCConstants.BIDS_ROW:
						return BIDS_ROW;
					case ALOCConstants.ADVANCE_ROW:
						return ADVANCE_ROW;
					case ALOCConstants.PERFOR_THIRTEEN:
					case ALOCConstants.PERFOR_FOURTEEN:
					case ALOCConstants.PERFOR_ROW:
						return PERFOR_ROW;
					case ALOCConstants.FINANCIAL_ROW:
						return FINANCIAL_ROW;
				}
		}
		return null;
	}
	
	/**
	 * This method is used to get the section color.
	 * @param rowId
	 * @return
	 */
	public static String getSectionColor(String rowId) {
		if(StringUtils.isBlank(rowId)) {
			return NP_SECTION;
		}
		
		if(BIDS_ROW.equals(rowId)) {
			return RED_SECTION;
		} else if(ADVANCE_ROW.equals(rowId)) {
			return GREEN_SECTION;
		} else if(PERFOR_ROW.equals(rowId)) {
			return BLUE_SECTION;
		} else if(FINANCIAL_ROW.equals(rowId)) {
			return GRAY_SECTION;
		} else if(DOC_ROW.equals(rowId)) {
			return ORANGE_SECTION;
		} else {
			return NP_SECTION;
		}
	}
	
	/**
	 * This method is used to get the bundle attributes.
	 * @param instrTypeId
	 * @param strInstrPurposeId
	 * @return
	 */
	public static ColorCalculator getBundleAttributes(BigInteger instrTypeId, String strInstrPurposeId) {
		if(instrTypeId == null) {
			return null;
		}
		
		Integer instrPurposeId = (StringUtils.isNotBlank(strInstrPurposeId)) ? Integer.valueOf(strInstrPurposeId) : null;
		String rowInnerIdValue = null;
		String colorClassValue = null;
		String sectionColor = null;

		// Calculate rowInnerIdValue & colorClassValue
		if(instrTypeId.intValue() == InstrumentType.DOCUMENT_LOC.getId()) {
			rowInnerIdValue = DOC_ROW_INNER;
			colorClassValue = DOC_ROW_COLOR;
			sectionColor = ORANGE_SECTION;
		} else if (instrPurposeId != null) {
			switch(instrPurposeId.intValue()) {
				case ALOCConstants.BIDS_ROW:
					rowInnerIdValue = BIDS_ROW_INNER;
					colorClassValue = BIDS_ROW_COLOR;
					sectionColor = RED_SECTION;
					break;
				case ALOCConstants.ADVANCE_ROW:
					rowInnerIdValue = ADVANCE_ROW_INNER;
					colorClassValue = ADVANCE_ROW_COLOR;
					sectionColor = GREEN_SECTION;
					break;
				case ALOCConstants.PERFOR_THIRTEEN:
				case ALOCConstants.PERFOR_FOURTEEN:
				case ALOCConstants.PERFOR_ROW:
					rowInnerIdValue = PERFOR_ROW_INNER;
					colorClassValue = PERFOR_ROW_COLOR;
					sectionColor = BLUE_SECTION;
					break;
				case ALOCConstants.FINANCIAL_ROW:
					rowInnerIdValue = FINANCIAL_ROW_INNER;
					colorClassValue = FINANCIAL_ROW_COLOR;
					sectionColor = GRAY_SECTION;
					break;
				default :
					sectionColor = NP_SECTION;
			}
		}
		return new ColorCalculator(rowInnerIdValue, colorClassValue, sectionColor);
	}
	
	
	private String rowInnerIdValue;
	private String colorClassValue;
	private String sectionColor;
	
	/**
	 * constructor with row Id, color class and section color.
	 * @param dashboard
	 */
	private ColorCalculator(String rowInnerIdValue, String colorClassValue, String sectionColor) {
		this.rowInnerIdValue = rowInnerIdValue;
		this.colorClassValue = colorClassValue;
		this.sectionColor = sectionColor;
	}

	/**
	 * This method is used to get the Row inner Id value.
	 * @return the rowInnerIdValue
	 */
	public String getRowInnerIdValue() {
		return rowInnerIdValue;
	}

	/**
	 * This method is used to get the color class value.
	 * @return the colorClassValue
	 */
	public String getColorClassValue() {
		return colorClassValue;
	}

	/**
	 * This method is used to get the section color.
	 * @return the sectionColor
	 */
	public String getSectionColor() {
		return sectionColor;
	}
}
