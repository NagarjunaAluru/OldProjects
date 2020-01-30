/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: GetAllApprovers.java
 * Purpose: GetAllApprovers used to returns all the IDAG approvers
 */
package com.ge.icfp.tag;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.ge.icfp.model.ActionLog;
import com.hydus.wff.common.bw.ServiceClient;

/**
 * 
 * @author prithivi.dhamotharan
 *
 */
public class GetAllApprovers {
	
	private ServiceClient service = null;
	
	/**
	 * Returns all the IDAG approvers in the below format
	 * 
	 *  Last name, First Name <br/>
	 *  Last name, First Name <br/>
	 *  
	 * @param lists
	 * @return
	 */
	public static String allIDAGApprovers(List<ActionLog> lists){
		
		Set<String> uniqueList = new HashSet<String>();
		
		for(ActionLog item:lists){
			
			if("IDAG/EAG Review".equals(item.getGroupName())){
				uniqueList.add( item.getSSOID() );
			}
		}
		
		StringBuilder retStr = new StringBuilder();
		
		for(String str : uniqueList){
			retStr.append( str );
			retStr.append(";");
		}
		
		return retStr.toString();
	}
	
	public ServiceClient getService() {
		return service;
	}
	
	@Autowired
	public void setService(ServiceClient service) {
		this.service = service;
	}
}
