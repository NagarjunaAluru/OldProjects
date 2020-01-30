/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: UserInformationManager.java
 * Purpose: UserInformationManager used to retrieve the User Information.
 */
package com.ge.icfp.tag;

import com.hydus.wff.core.context.UserContext;
/**
 * 
 * @author madhusudhan.gosula
 *
 */
public class UserInformationManager {
	
	/**
	 * 
	 * @return
	 */
	public static UserContext userContext() {
		return UserContext.getCurrentUserContext();
	}
	/**
	 * 
	 * @param defaultValue
	 * @return
	 */
	public static String firstName(String defaultValue) {
		return convertToDefaultIfNull(userContext().getFirstName(), defaultValue);
	}
	/**
	 * 
	 * @param defaultValue
	 * @return
	 */
	public static String lastName(String defaultValue) {
		return convertToDefaultIfNull(userContext().getLastName(), defaultValue);
	}
	/**
	 * 
	 * @param defaultValue
	 * @return
	 */
	public static String title(String defaultValue) {
		return convertToDefaultIfNull(userContext().getTitle(), defaultValue);
	}
	/**
	 * fullName is used retrieve the full name.
	 * @param seperator
	 * @param defaultValue
	 * @return
	 */
	public static String fullName(String seperator, String defaultValue) {
		UserContext context = UserContext.getCurrentUserContext();
		StringBuilder result = new StringBuilder();
		if(context.getLastName() != null) {
			result.append(context.getLastName());
		}
		if(context.getFirstName() != null) {
			if(result.length() > 0) {
				result.append(seperator);
			}
			result.append(context.getFirstName());
		}
		String fullName = result.toString();
		return (fullName == null || fullName.trim().length() == 0) ? defaultValue : fullName;
	}
	/**
	 * convertToDefaultIfNull
	 * @param value
	 * @param defaultValue
	 * @return
	 */
	private static String convertToDefaultIfNull(String value, String defaultValue) {
		return (value == null) ? defaultValue : value;
	}
}
