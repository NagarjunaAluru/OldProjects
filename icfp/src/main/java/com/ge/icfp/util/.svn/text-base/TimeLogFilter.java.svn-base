/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: TimeLogFilter.java
 * Purpose: TimeLogFilter used for time logging purpose
 */
package com.ge.icfp.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


import org.apache.log4j.Logger;



/**
 * This filter is used for time logging purpose.
 */
public class TimeLogFilter implements Filter {
	
	/**
	 * LOGGER
	 */
	private static final Logger LOGGER = Logger.getLogger(TimeLogFilter.class);

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		Long startTime = System.currentTimeMillis();
		chain.doFilter(request, response);
		Long endTime = System.currentTimeMillis();
		Long totalTime= endTime - startTime;
		Long timetaken= (totalTime/1000)%60;
		LOGGER.info("Time taken:"+timetaken+" sec");
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig config) throws ServletException {
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}
}
