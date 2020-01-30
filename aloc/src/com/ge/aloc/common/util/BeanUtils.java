/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: XMLPropertiesUtils.java
 * Purpose: file used for implementing utilities/reusable XML Properties Utils
 * 
 */
package com.ge.aloc.common.util;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;

import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.exception.ALOCException;
import com.ge.aloc.model.RequestDetails;
import com.hydus.hwf.util.StringUtils;

/**
 * @author hariprasad.madas
 *
 */
public class BeanUtils {

	private static final Logger LOGGER = Logger.getLogger(BeanUtils.class);


	/**
	 * This method fetches the specified property value from the specified bean.
	 * 
	 * @param object
	 * @param exceptedType
	 * @return
	 * @throws ALOCException 
	 */
	public static <T> T fetchPropertyValue(String name, Object bean, Class<T> expectedType) throws ALOCException {
		Object result = null;
		try {
			result = PropertyUtils.getProperty(bean, name);
		} catch (NoSuchMethodException e) {
			String errMsg = new StringBuilder().append(ALOCConstants.COULD_NOT_FETCH_PROPERTY).append(name).append(ALOCConstants.ON_BEAN).append(bean.getClass().getName()).append(ALOCConstants.ERRORLOG_SLASH).toString();
			LOGGER.error(errMsg, e);
			throw new ALOCException(ALOCException.EC_PROP_ACCESS, errMsg, e);
		} catch (IllegalAccessException e) {
			String errMsg = new StringBuilder().append(ALOCConstants.COULD_NOT_FETCH_PROPERTY).append(name).append(ALOCConstants.ON_BEAN).append(bean.getClass().getName()).append(ALOCConstants.ERRORLOG_SLASH).toString();
			LOGGER.error(errMsg, e);
			throw new ALOCException(ALOCException.EC_PROP_ACCESS, errMsg, e);
		} catch (InvocationTargetException e) {
			String errMsg = new StringBuilder().append(ALOCConstants.COULD_NOT_FETCH_PROPERTY).append(name).append(ALOCConstants.ON_BEAN).append(bean.getClass().getName()).append(ALOCConstants.ERRORLOG_SLASH).toString();
			LOGGER.error(errMsg, e);
			throw new ALOCException(ALOCException.EC_PROP_ACCESS, errMsg, e);
		} 
		return expectedType.cast(result);
	}

	/**
	 * This method fetches the specified property value from the specified bean as {@link String}.
	 * 
	 * @return
	 * @throws ALOCException 
	 */
	public static String fetchPropertyValueAsString(String name, Object bean) throws ALOCException {
		Object result = null;
		try {
			result = PropertyUtils.getProperty(bean, name);
		} catch (NoSuchMethodException e) {
			String errMsg = new StringBuilder().append(ALOCConstants.COULD_NOT_FETCH_PROPERTY).append(name).append(ALOCConstants.ON_BEAN).append(bean.getClass().getName()).append(ALOCConstants.ERRORLOG_SLASH).toString();
			LOGGER.error(errMsg, e);
			throw new ALOCException(ALOCException.EC_PROP_ACCESS, errMsg, e);
		} catch (IllegalAccessException e) {
			String errMsg = new StringBuilder().append(ALOCConstants.COULD_NOT_FETCH_PROPERTY).append(name).append(ALOCConstants.ON_BEAN).append(bean.getClass().getName()).append(ALOCConstants.ERRORLOG_SLASH).toString();
			LOGGER.error(errMsg, e);
			throw new ALOCException(ALOCException.EC_PROP_ACCESS, errMsg, e);
		} catch (InvocationTargetException e) {
			String errMsg = new StringBuilder().append(ALOCConstants.COULD_NOT_FETCH_PROPERTY).append(name).append(ALOCConstants.ON_BEAN).append(bean.getClass().getName()).append(ALOCConstants.ERRORLOG_SLASH).toString();
			LOGGER.error(errMsg, e);
			throw new ALOCException(ALOCException.EC_PROP_ACCESS, errMsg, e);
		}
		
		return (result != null) ? String.valueOf(result) : null;
	}

	/**
	 * 
	 * @param name
	 * @param value
	 * @param bean
	 * @throws ALOCException 
	 */
	public static void setPropertyValue(String name, Object value, Object bean) throws ALOCException {
		try {
			PropertyUtils.setProperty(bean, name, value);
		} catch (NoSuchMethodException e) {
			String errMsg = new StringBuilder().append(ALOCConstants.COULD_NOT_SET_PROPERTY).append(name).append(ALOCConstants.ON_BEAN).append(bean.getClass().getName())
					.append(ALOCConstants.WITH_VALUE).append(value).toString();
			LOGGER.error(errMsg, e);
			throw new ALOCException(ALOCException.EC_PROP_SET, errMsg, e);
		} catch (IllegalAccessException e) {
			String errMsg = new StringBuilder().append(ALOCConstants.COULD_NOT_SET_PROPERTY).append(name).append(ALOCConstants.ON_BEAN).append(bean.getClass().getName())
					.append(ALOCConstants.WITH_VALUE).append(value).toString();
			LOGGER.error(errMsg, e);
			throw new ALOCException(ALOCException.EC_PROP_SET, errMsg, e);
		} catch (InvocationTargetException e) {
			String errMsg = new StringBuilder().append(ALOCConstants.COULD_NOT_SET_PROPERTY).append(name).append(ALOCConstants.ON_BEAN).append(bean.getClass().getName())
					.append(ALOCConstants.WITH_VALUE).append(value).toString();
			LOGGER.error(errMsg, e);
			throw new ALOCException(ALOCException.EC_PROP_SET, errMsg, e);
		}
	}


	/**
	 * Checks whether all properties of a bean are empty or not
	 * 
	 * @param bean
	 * @return
	 * @throws ALOCException
	 */
	public static boolean isAllPropertiesBlank(Object bean) throws ALOCException {
		boolean allBlank = true;
		try {
			@SuppressWarnings("unchecked")
			Map<String, Object> map = new BeanMap(bean);
			for (String key : map.keySet()) {
				if (ALOCConstants.CLASS.equalsIgnoreCase(key) || ALOCConstants.META_CLASS.equalsIgnoreCase(key)) {
					continue;
				}

				Object value = map.get(key);
				if(value == null) {
					continue;
				}

				if(value instanceof String && StringUtils.isBlank((String) value)) {
					continue;
				}

				if(value.getClass().isArray() && Array.getLength(value) == ALOCConstants.BASE_VALUE) {
					continue;
				}

				if(Collection.class.isAssignableFrom(value.getClass()) && ((Collection<?>) value).isEmpty()) {
					continue;
				}

				allBlank = false;
				break;
			}
		} catch (Exception e) {
			String errMsg = new StringBuilder().append(ALOCConstants.COULD_NOT_FETCH_PROPERTIES_OF_BEAN).append(bean.getClass().getName()).append(ALOCConstants.ERRORLOG_SLASH).toString();
			LOGGER.error(errMsg, e);
			throw new ALOCException(ALOCException.EC_PROP_ACCESS, errMsg, e);
		}
		return allBlank;
	}

	/**
	 * Removes blank elements from specified object.
	 * 
	 * @param model
	 * @return
	 * @throws ALOCException 
	 */
	public static <T extends Object> T cleanBlankElements(T model) throws ALOCException {
		T result = null;

		if(isAllPropertiesBlank(model)) {
			return result;
		}

		result = model;

		// Not considering the model classes only
		if(model == null || !model.getClass().getPackage().getName().equals(RequestDetails.class.getPackage().getName())) {
			return result;
		}

		try {
			@SuppressWarnings("unchecked")
			Map<String, Object> beanMap = new BeanMap(model);
			for(Entry<String, Object> entry : beanMap.entrySet()) {
				String key = entry.getKey();
				Object value = entry.getValue();

				if (ALOCConstants.CLASS.equalsIgnoreCase(key) || ALOCConstants.META_CLASS.equalsIgnoreCase(key)) {
					continue;
				}

				if(value == null) {
					continue;
				}

				if(value instanceof String && StringUtils.isBlank(String.valueOf(value))) {
					beanMap.put(key, null); // Replacing blank String values to null
				}

				// Verifying sub model object
				if(RequestDetails.class.getPackage() == value.getClass().getPackage() && cleanBlankElements(value) == null) {
					beanMap.put(key, null); // Replacing sub model object with null; if it is empty
				}
			}
		} catch (Exception e) {
			String errMsg = new StringBuilder().append(ALOCConstants.COULD_NOT_CLEAN_BLANK_PROPERTIES_OF_MODEL).append(model.getClass().getName()).append(ALOCConstants.ERRORLOG_SLASH).toString();
			LOGGER.error(errMsg, e);
			throw new ALOCException(ALOCException.EC_PROP_SET, errMsg, e);
		} 

		// Checking the bean after analyzing the properties;
		if(isAllPropertiesBlank(model)) {
			result = null;
		}
		return result;
	}

	/**
	 * 
	 * @param params
	 * @return
	 */
	public static final String toString(Object[] params) {
		StringBuilder result = new StringBuilder();
		if(params != null && params.length > ALOCConstants.BASE_VALUE) {
			int size = params.length;
			for(int i = ALOCConstants.BASE_VALUE; i < size; i++) {
				result.append(params[i]);
				if(i < size - ALOCConstants.MIN_VALUE) {
					result.append(ALOCConstants.COMMA);
				}
			}
		}
		return result.toString();
	}
	
	/**
	 * This is used to convert the first letter of the string to a capital letter
	 * @param params
	 * @return
	 */
	public static final String initCap(String param) {
		if(param != null && param.length()>ALOCConstants.BASE_VALUE){	
			param = param.toLowerCase();
			char[] charArray = param.toCharArray(); // convert into char array 
			charArray[ALOCConstants.BASE_VALUE] = Character.toUpperCase(charArray[ALOCConstants.BASE_VALUE]); // set capital letter to first position 
			return new String(charArray); // return desired output 
		}
		else{ 
			return ALOCConstants.EMPTY_STRING; 
		}
	}
}
