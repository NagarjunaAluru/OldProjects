/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: TimeLogListener.java
 * Purpose: TimeLogListener used for time logging purpose
 */
package com.ge.icfp.util;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

/**
 * This filter is used for time logging purpose.
 */
public class TimeLogListener implements ServletRequestListener {
	
	private Logger log = Logger.getLogger(TimeLogListener.class);
	private long startTime = 0L;
	
	/**
	 * requestDestroyed
	 */
	public void requestDestroyed(ServletRequestEvent arg0) {
		long endTime = System.currentTimeMillis();
		long timeTaken = (endTime-startTime)/1000;
		
		if( arg0.getServletRequest() instanceof HttpServletRequest){
			String url = ((HttpServletRequest)arg0.getServletRequest()).getRequestURL().toString();
			log.info("Time Taken for " + url + " is " + timeTaken + "sec");
		}
		
	}
	/**
	 * requestInitialized
	 */
	public void requestInitialized(ServletRequestEvent arg0) {		
		startTime = System.currentTimeMillis();
		
	}

}
