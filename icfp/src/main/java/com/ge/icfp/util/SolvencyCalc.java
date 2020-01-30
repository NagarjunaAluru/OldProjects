/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: SolvencyCalc.java
 * Purpose: file is used to slovency calculations
 * 
 */
package com.ge.icfp.util;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.ge.icfp.action.ICFPException;


/**
 * @author hariprasad.madas
 *
 */
public class SolvencyCalc {
	private static final Pattern OPERATOR_PATTERN = Pattern.compile("\\s*((<\\s*=)|(>\\s*=)|<|>)\\s*");
	private static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\s*");
	
	/**
	 * 
	 * @param value
	 */
	private static String removeWhiteSpaces(String value) {
		String result = null;
		Matcher whiteSpaceMatcher = WHITESPACE_PATTERN.matcher(value);
		if(whiteSpaceMatcher.find()) {
			result = whiteSpaceMatcher.replaceAll("");
		} else {
			result = value;
		}
		return result;
	}
	 
	private double postTransaction;
	private String operator;
	private double solvencyValue;
	private double solvencyMinValue;
	private double solvencyMaxValue;
	private NumberFormat numberFormatter = null;
	
	/**
	 * 
	 * @param postTransaction
	 * @throws ICFPException
	 */
	public SolvencyCalc(String postTransaction) throws ICFPException {
		numberFormatter = NumberFormat.getInstance(Locale.US);
		try {
			this.postTransaction = numberFormatter.parse(postTransaction).doubleValue();
		} catch (ParseException pe) {
			String msg = new StringBuilder().append("Invalid Post Transaction Value \'")
					.append(postTransaction).append("\'").toString();
			throw new ICFPException("", msg, pe);
		}
	}
	
	/**
	 * 
	 * @param solvencyValue
	 * @return
	 * @throws ICFPException 
	 */
	public boolean validate(String solvencyCondition) throws ICFPException {
		if(StringUtils.isNotBlank(solvencyCondition)) {
			parseCondition(solvencyCondition);
			return compute();
		}
		return false;
	}
	
	/**
	 * 
	 * @param solvencyCondition
	 * @throws ICFPException 
	 */
	private void parseCondition(String solvencyCondition) throws ICFPException {
		String condition = solvencyCondition.trim();
		Matcher matcher =  OPERATOR_PATTERN.matcher(condition);
		String operand = null;
		try {
			if(matcher.find()) {
				operator = removeWhiteSpaces(matcher.group().trim());
				operand = matcher.replaceFirst("");
				solvencyValue = numberFormatter.parse(operand).doubleValue();
				return;
			}
		} catch (ParseException pe) {
			String msg = new StringBuilder().append("Invalid number \'").append(operand)
					.append("\' in Solvency condition ").append(solvencyCondition).toString();
			throw new ICFPException("", msg, pe);
		}
		
		String[] betweenSplit = condition.split("-");
		if(betweenSplit.length != 2) {
			String msg = new StringBuilder().append("Invalid Solvency condition \'").append(solvencyCondition).append("\'").toString();
			throw new ICFPException("", msg);
		}
		operator = "-";
		try {
			solvencyMinValue = numberFormatter.parse(betweenSplit[0].trim()).doubleValue();
		} catch (ParseException pe) {
			String msg = new StringBuilder().append("Invalid number \'").append(betweenSplit[0])
					.append("\' in Solvency condition ").append(solvencyCondition).toString();
			throw new ICFPException("", msg, pe);
		}
		
		try {
			solvencyMaxValue = numberFormatter.parse(betweenSplit[1].trim()).doubleValue();
		} catch (ParseException pe) {
			String msg = new StringBuilder().append("Invalid number \'").append(betweenSplit[1])
					.append("\' in Solvency condition ").append(solvencyCondition).toString();
			throw new ICFPException("", msg, pe);
		}
		
		if(operator == null) {
			String msg = new StringBuilder().append("Invalid Solvency condition \'").append(solvencyCondition).append("\'").toString();
			throw new ICFPException("", msg);
		}
	}
	
	/**
	 * 
	 * @return
	 */
	
	private boolean compute() {
		if("<".equals(operator)) {
			return postTransaction < solvencyValue;
		}
		
		if(">".equals(operator)) {
			return postTransaction > solvencyValue;
		}
		
		if(">=".equals(operator)) {
			return postTransaction >= solvencyValue;
		}
		
		if("<=".equals(operator)) {
			return postTransaction <= solvencyValue;
		}
		
		if("-".equals(operator)) {
			return (postTransaction >= solvencyMinValue && postTransaction <= solvencyMaxValue);
		}
		return false;
	}
	
}
