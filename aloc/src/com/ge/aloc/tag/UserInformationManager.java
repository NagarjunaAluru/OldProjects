/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: UserInformationManager.java
 * Purpose: UserInformationManager used for displaying User Details
 */
package com.ge.aloc.tag;

import org.apache.commons.lang3.StringUtils;

import com.ge.aloc.constants.ALOCConstants;
import com.hydus.hwf.context.UserContext;

/**
 * @author arijit.biswas
 *
 */
public class UserInformationManager {

	/**
	 * This method is used to get the full name from the userContext.
	 * @param seperator
	 * @param defaultValue
	 * @return
	 */
	public static String fullName(String seperator, String defaultValue){
		UserContext context = UserContext.getContext();
		StringBuilder result = new StringBuilder();
		if(context.getuserDetails().getLastName() != null){
			result.append(context.getuserDetails().getFirstName());
		}
		if(context.getuserDetails().getFirstName() != null) {
			if(result.length() > ALOCConstants.BASE_VALUE) {
				result.append(seperator);
			}
			result.append(context.getuserDetails().getLastName());
		}
		return convertToDefaultIfNull(result.toString(),defaultValue);
	}
	
	/**
	 * This method is used to get the SSO ID from the userContext.
	 * @param defaultValue
	 * @return
	 */
	public static String userSSOId(String defaultValue){
		UserContext context = UserContext.getContext();
		StringBuilder result = new StringBuilder();
		if(StringUtils.isNotBlank(context.getuserDetails().getUserId())){
			result.append(context.getuserDetails().getUserId());
		}
		return convertToDefaultIfNull(result.toString(),defaultValue);
	}
	
	/**
	 * This method is used convertToDefaultIfNull
	 * @param value
	 * @param defaultValue
	 * @return
	 */
	private static String convertToDefaultIfNull(String value, String defaultValue) {
		return (value == null) ? defaultValue : value;
	}
}
