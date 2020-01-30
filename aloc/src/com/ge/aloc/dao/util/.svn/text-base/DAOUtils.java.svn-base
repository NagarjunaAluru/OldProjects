/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: DAOUtils.java
 * Purpose: DAOUtils used for the all the DAO Utils.
 */
package com.ge.aloc.dao.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ge.aloc.ALOCContext;
import com.ge.aloc.StaticDataFactory;
import com.ge.aloc.model.NameValue;

/**
 * @author chaitanya.n
 *
 */
public class DAOUtils {
	/**
	 * This method is used to get all user sites.
	 * @return
	 */
	public static Map<String, String> getAllUserSites(){
		Map<String, String> userSites = new HashMap<String, String>();
		StaticDataFactory staticDataFactory = ALOCContext.getStaticDataFactory();
		List <NameValue> userSitesFromDB = staticDataFactory.getUserSites();
		for (NameValue eachUserSites : userSitesFromDB) {
			userSites.put(eachUserSites.getID().toString(), eachUserSites.getName());
		}
		return userSites;
	}
}
