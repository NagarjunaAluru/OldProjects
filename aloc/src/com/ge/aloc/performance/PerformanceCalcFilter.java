/*
 * Copyright © 2013 GE. ALL RIGHTS RESERVED.
 * FileName: PerformanceCalcFilter.java
 * Purpose: PerformanceCalcFilter used for time logging Performances Statistics
 */
package com.ge.aloc.performance;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 * @author ramakrishna.satti
 * This class is used for the performance calculation for testing.
 */
public class PerformanceCalcFilter implements Filter {
	
	private static final String INIT_PARAM_LOGGER_NAME = "loggerName";
	
	private Logger logger;
	
	/**
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		String loggerName = filterConfig.getInitParameter(INIT_PARAM_LOGGER_NAME);
		if(StringUtils.isBlank(loggerName)) {
			loggerName = "com.ge.aloc.performance";
		}
		logger = Logger.getLogger(loggerName);
	}

	/**
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		
		PerformanceClac.start(httpRequest);
		try {
			filterChain.doFilter(request, response);
		} finally {
			PerformanceClac.end(httpRequest);
			
			PerformanceClac.RequestStats reqStats = PerformanceClac.getRequestStats(httpRequest);
			StringBuilder statsBuilder = new StringBuilder();
			statsBuilder.append("\nPerformances Statistics for URI: ").append(reqStats.getURI()).append("\n");
			statsBuilder.append("Throughput: ").append((reqStats.throughput() / 1000)).append("sec \n");
			statsBuilder.append("Total BW Time: ").append((reqStats.totalBWTime() / 1000)).append("sec \n");
			statsBuilder.append("Java Time: ").append((reqStats.javaTime() / 1000)).append("sec \n\n\n");
			
			
			List<PerformanceClac.BWRequestStats> bwStats = reqStats.getBWRequestStats();
			statsBuilder.append("BW Call Count: ").append(bwStats.size()).append("\n");
			statsBuilder.append("Detailed BW stats:").append("\n\n");
			int counter = 1;
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss", Locale.getDefault());
			for(PerformanceClac.BWRequestStats eachCall : bwStats) {
				statsBuilder.append("call ").append(counter).append(" : \n");
				statsBuilder.append("\tStart Time: ").append(df.format(new Date(eachCall.startTime))).append("\n");
				statsBuilder.append("\tEnd Time: ").append(df.format(new Date(eachCall.endTime))).append("\n");
				statsBuilder.append("\tTotal Call Time: ").append(eachCall.timeTaken() / 1000).append("sec \n\n");
				counter++;
			}
			
			logger.info(statsBuilder);
		}
	}

	

}
