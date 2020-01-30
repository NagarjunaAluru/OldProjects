/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: ICFPStrutsValidators.java
 * ICFPStrutsValidators used for validating the new financing request details
 */
package com.ge.icfp.util.validator;

import jarjar.orgapachecommonslang.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.validator.Field;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.ge.icfp.common.helper.CurrentDealManager;
import com.ge.icfp.model.DealRequest;
import com.ge.icfp.model.Legs;
import static com.ge.icfp.common.constants.ICFPConstants.*; 
/**
 * @author srinivasan.desa
 * 
 */
public class ICFPStrutsValidators {

	private static final String LEG_SIZE = "legSize";

	/**
	 * This function validates the value date . If the value date is less than
	 * 10 working days from today or if the value date is on saturday or sunday
	 * then it will display the error
	 * 
	 * @param bean
	 * @param field
	 * @param errors
	 * @param validator
	 * @param request
	 * @return
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	public static boolean valueDateValidation(Object bean, Field field,
			ActionMessages errors, HttpServletRequest request)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {

		String valueDt = (String) PropertyUtils.getProperty(bean,
				field.getProperty());

		int mm = 0;
		int dd = 0;
		int yyyy = 0;

		if (valueDt != null && valueDt.trim().length() >= 10) {
			mm = Integer.parseInt(valueDt.substring(0, 2));
			dd = Integer.parseInt(valueDt.substring(3, 5));
			yyyy = Integer.parseInt(valueDt.substring(6, 10));
		}

		GregorianCalendar gcValueDate = new GregorianCalendar(yyyy, mm, dd);

		GregorianCalendar toDayDate = new GregorianCalendar();
		Calendar startCal = Calendar.getInstance();
		startCal.setTime(toDayDate.getTime());

		Calendar endCal = Calendar.getInstance();
		endCal.setTime(gcValueDate.getTime());

		long milliseconds1 = toDayDate.getTimeInMillis();
		long milliseconds2 = gcValueDate.getTimeInMillis();

		long diff = milliseconds2 - milliseconds1;

		long diffDays = diff / (24 * 60 * 60 * 1000);

		if (diffDays <= 0) {
			if (errors == null) {
				errors = new ActionErrors();
			}
			errors.add(VALUEDATEVALIDATION, new ActionMessage(
					VALUEDATEVALIDATION));

			return false;
		}

		int workingDays = getWorkingDays(new Date(), gcValueDate.getTime());

		if (workingDays < 10) {

			if (errors == null) {
				errors = new ActionErrors();
			}
			errors.add(VALUEDATEVALIDATION, new ActionMessage(
					VALUEDATEVALIDATION));

			return false;

		} else {

			int dayOfTheWeek = gcValueDate.get(Calendar.DAY_OF_WEEK);
			if (dayOfTheWeek == 4 || dayOfTheWeek == 5) {
				if (errors == null) {
					errors = new ActionErrors();
				}
				errors.add(DAYOFTHEWEEK, new ActionMessage(DAYOFTHEWEEK));
				return false;
			}
		}
		return true;
	}

	/**
	 * ICFPStrutsValidators
	 * 
	 * @param startDt
	 * @param endDt
	 * @return
	 */
	public static int getWorkingDays(Date startDt, Date endDt) {

		Calendar startCal, endCal;
		startCal = Calendar.getInstance();
		startCal.setTime(startDt);
		endCal = Calendar.getInstance();
		endCal.setTime(endDt);

		int workDays = 0;
		// Return 0 if start and end are the same
		if (startCal.getTimeInMillis() == endCal.getTimeInMillis()) {
			return 0;
		}

		// Just in case the dates were transposed this prevents infinite loop
		if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
			startCal.setTime(endDt);
			endCal.setTime(startDt);
		}

		do {
			startCal.add(Calendar.DAY_OF_MONTH, 1);
			if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY
					&& startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
				++workDays;
			}
		} while (startCal.getTimeInMillis() < endCal.getTimeInMillis());
		return workDays;
	}

	/**
	 * This function will check number of legs in the deal. If the deal does not
	 * contain any legs then it will generate the error
	 * 
	 * @param bean
	 * @param field
	 * @param errors
	 * @param request
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public static boolean legSizeInDealValidation(Object bean, Field field,
			ActionMessages errors, HttpServletRequest request)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {

		DealRequest dealRequest = CurrentDealManager.getCurrentDeal(request);
		int legListSize = 0;
		if (dealRequest != null) {
			Legs legs = dealRequest.getLegs();
			List<Object> legsList = null;
			if (legs != null) {

				legsList = legs.getAllLegs();

				if (legsList != null) {
					legListSize = legsList.size();
				}
			}

		}

		if (legListSize == 0) {

			if (errors == null) {
				errors = new ActionErrors();
			}
			errors.add(ICFPStrutsValidators.LEG_SIZE, new ActionMessage(ICFPStrutsValidators.LEG_SIZE));

			return false;
		}

		return true;

	}

	/**
	 * Validates the minimum value.
	 * 
	 * @param bean
	 * @param field
	 * @param errors
	 * @param request
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public static boolean minimumValue(Object bean, Field field,
			ActionMessages errors, HttpServletRequest request)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		String doubleData = (String) PropertyUtils.getProperty(bean,
				field.getProperty());

		if (doubleData != null && !doubleData.equals("")) {
			try {

				double doubleValue = Double.parseDouble(doubleData);

				if (doubleValue < 0) {
					if (errors == null) {
						errors = new ActionErrors();
					}
					errors.add(field.getProperty(), new ActionMessage(
							"minimumRange"));

					return false;
				}

			} catch (Exception e) {

				if (errors == null) {
					errors = new ActionErrors();
				}
				errors.add("errors.invalid",
						new ActionMessage("errors.invalid"));

				return false;
			}
		}

		return true;

	}

	/**
	 * Validates the spread max value
	 * 
	 * @param bean
	 * @param field
	 * @param errors
	 * @param request
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public static boolean spreadMaxValue(Object bean, Field field,
			ActionMessages errors, HttpServletRequest request)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		String spreadMaxValueStr = (String) PropertyUtils.getProperty(bean,
				field.getProperty());

		String spreadMinValueStr = (String) PropertyUtils.getProperty(bean,
				"rateInformation.minSpread");

		if (StringUtils.isNotBlank(spreadMinValueStr)
				&& StringUtils.isNotEmpty(spreadMinValueStr)
				&& StringUtils.isNotBlank(spreadMaxValueStr)
				&& StringUtils.isNotEmpty(spreadMaxValueStr)) {
			try {

				double spreadMaxValue = Double.parseDouble(spreadMaxValueStr);

				double spreadMinValue = Double.parseDouble(spreadMinValueStr);

				if (spreadMinValue > spreadMaxValue ) {
					if (errors == null) {
						errors = new ActionErrors();
					}
					errors.add(field.getProperty(), new ActionMessage(
							"rcaTransferPricingInputForm.minmaxSpreadBPS"));

					return false;
				}

			} catch (Exception e) {

				if (errors == null) {
					errors = new ActionErrors();
				}
				errors.add("errors.invalid",
						new ActionMessage("errors.invalid"));

				return false;
			}
		}

		return true;

	}
	
	/**
	 * Validates Amount which should contain 17 digits before decimal and 2 digits after decimal
	 * 
	 * @param bean
	 * @param field
	 * @param errors
	 * @param request
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public static boolean amountValidation(Object bean, Field field,
			ActionMessages errors, HttpServletRequest request)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		String valueStr = (String) PropertyUtils.getProperty(bean,
				field.getProperty());

		if ( StringUtils.isNotBlank(valueStr)) {
			try {
				Scanner scanner = new Scanner(valueStr);   
				if (scanner.hasNextDouble()) {   
					valueStr = valueStr.replace("-", "");
					String[] valueStrArr = valueStr.split("\\.");
							
					if(valueStrArr!=null && valueStrArr.length>0 && valueStrArr[0].length()>14)
					{
						if (errors == null) {
							errors = new ActionErrors();
						}
						errors.add(field.getProperty(), new ActionMessage(
								"amountValidation"));
						return false;
					}
					if(valueStrArr!=null && valueStrArr.length>1 && valueStrArr[1].length()>2)
					{
						if (errors == null) {
							errors = new ActionErrors();
						}
						errors.add(field.getProperty(), new ActionMessage(
								"amountValidation"));
						return false;
					}
					return true;
				}else{
					//Given String is not double then this block
					if (errors == null) {
						errors = new ActionErrors();
					}
					errors.add(field.getProperty(), new ActionMessage(
							"amountValidation"));
					return false;
				}
			} catch (Exception e) {
				if (errors == null) {
					errors = new ActionErrors();
				}
				errors.add(field.getProperty(),
						new ActionMessage("errors.invalid"));
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Validates Amount which should contain 2 digits before decimal and 5 digits after decimal
	 * 
	 * @param bean
	 * @param field
	 * @param errors
	 * @param request
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public static boolean amountDecimalValidation(Object bean, Field field,
			ActionMessages errors, HttpServletRequest request)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		String valueStr = (String) PropertyUtils.getProperty(bean,
				field.getProperty());

		if ( StringUtils.isNotBlank(valueStr)) {
			try {
				Scanner scanner = new Scanner(valueStr);   
				if (scanner.hasNextDouble()) {   
					valueStr = valueStr.replace("-", "");
					String[] valueStrArr = valueStr.split("\\.");
							
					if(valueStrArr!=null && valueStrArr.length>0 && valueStrArr[0].length()>4)
					{
						if (errors == null) {
							errors = new ActionErrors();
						}
						errors.add(field.getProperty(), new ActionMessage(
								"amountDecimalValidation"));
						return false;
					}
					if(valueStrArr!=null && valueStrArr.length>1 && valueStrArr[1].length()>1)
					{
						if (errors == null) {
							errors = new ActionErrors();
						}
						errors.add(field.getProperty(), new ActionMessage(
								"amountDecimalValidation"));
						return false;
					}
					return true;
				}else{
					//Given String is not double then this block
					if (errors == null) {
						errors = new ActionErrors();
					}
					errors.add(field.getProperty(), new ActionMessage(
							"amountDecimalValidation"));
					return false;
				}
			} catch (Exception e) {
				if (errors == null) {
					errors = new ActionErrors();
				}
				errors.add(field.getProperty(),
						new ActionMessage("errors.invalid"));
				return false;
			}
		}
		return true;
	}

}
