/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ALOCContext.java
 * Purpose: ALOCContext used to handle the scope of the objects.
 */
package com.ge.aloc;

import java.util.Collections;
import java.util.Map;

import com.ge.aloc.bo.RequestDetailsBO;
import com.hydus.hwf.context.UserContext;

/**
 * @author chaitanya.n
 *
 */
public class ALOCContext {

	public static final String SSN_KEY_CURR_REQUEST = RequestDetailsBO.class.getName();

	/**
	 * This method is used to get the active request from the session.
	 * @return
	 */
	public static RequestDetailsBO getActiveRequest() {
		return (RequestDetailsBO) UserContext.getContext().getSessionScopedContext().get(SSN_KEY_CURR_REQUEST);
	}

	/**
	 * This method is used to set the active request to the seesion
	 * @param requestDetails
	 */
	public static void setActiveRequest(RequestDetailsBO requestDetails) {
		UserContext.getContext().getSessionScopedContext().put(SSN_KEY_CURR_REQUEST, requestDetails);
	}

	/**
	 * This method is used to remove the active request from the session.
	 * @return
	 */
	public static boolean removeActiveRequest() {
		RequestDetailsBO requestDetails = getActiveRequest();
		if(requestDetails != null) {
			UserContext.getContext().getSessionScopedContext().remove(SSN_KEY_CURR_REQUEST);
		}
		return requestDetails != null;
	}

	/**
	 * this method is used to get the static data factory from the application scope.
	 * @return
	 */
	public static StaticDataFactory getStaticDataFactory() {
		return (StaticDataFactory) UserContext.getContext().getApplicationScopedContext().get(StaticDataFactory.CTX_KEY);
	}

	/**
	 * This method is used to get the master data factory from the application scope.
	 * @return
	 */
	public static MasterDataFactory getMasterDataFactory() {
		return (MasterDataFactory) UserContext.getContext().getApplicationScopedContext().get(MasterDataFactory.CTX_KEY);
	}

	/**
	 * This method is used to get the context map from the user contest and make unmodifiable.
	 * @return
	 */
	public static Map<String, Object> getContextMap() {
		return Collections.unmodifiableMap(UserContext.getContext().getContextMap());
	}

	/**
	 * This method is used to get the object based on the key.
	 * @param key
	 * @return
	 */
	public static Object get(String key) {
		return UserContext.getContext().get(key);
	}

	/**
	 * This method is used to store the key, value pairs to the Context.
	 * @param key
	 * @param value
	 */
	public static void put(String key, Object value) {
		UserContext.getContext().put(key, value);
	}

	/**
	 * This method is used to remove the key from the context map.
	 * @param key
	 * @return object.
	 */
	public static Object remove(String key) {
		return UserContext.getContext().remove(key);
	}
}
