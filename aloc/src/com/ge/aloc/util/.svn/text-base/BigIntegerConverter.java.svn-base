/**
 * 
 */
package com.ge.aloc.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;

import com.hydus.hwf.struts2.typeconverters.BigDecimalConverter;
import com.hydus.hwf.util.HWFUtilities;

/**
 * @author nagarjuna.aluru
 *
 */
public class BigIntegerConverter extends BigDecimalConverter {
	
	private static final String NUMBER_FORMAT = HWFUtilities.getProperty(BigIntegerConverter.class, "numberFormat");

	/**
	 * 
	 * @return
	 */
	public String getPattern() {
		return NUMBER_FORMAT;
	}
	
	/**
	 * @see NumberConverter#replaceNumber(Number)
	 */
	protected Number replaceNumber(Number parsedNumber) {
		return ((BigDecimal) parsedNumber).toBigInteger();
	}
	
	/**
	 * @see org.apache.struts2.util.StrutsTypeConverter#convertToString(java.util.Map, java.lang.Object)
	 */
	@Override
	public String convertToString(@SuppressWarnings("rawtypes") Map context, Object o) {
		BigInteger value = (BigInteger) o;
		String result = null;
		
		if(value != null) {
			result = value.toString();
		}
		return result;
	}
}
