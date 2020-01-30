/*
 * Copyright © 2013 GE. ALL RIGHTS RESERVED.
 * FileName: PerformanceClac.java
 * Purpose: PerformanceClac used for time logging Performances Statistics
 */
package com.ge.aloc.performance;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ge.aloc.constants.ALOCConstants;


/**
 * @author ramakrishna.satti
 * This class is used for the performance calculation for testing.
 */
public class PerformanceClac {
	
	private static final String REQ_ATTR = RequestStats.class.getName();
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public static RequestStats getRequestStats(HttpServletRequest request) {
		RequestStats reqStats = (RequestStats) request.getAttribute(REQ_ATTR);
		if(reqStats == null) {
			reqStats = new RequestStats();
			request.setAttribute(REQ_ATTR, reqStats);
		}
		return reqStats;
	}
	
	/**
	 * 
	 * @param requestURI
	 */
	public static void start(HttpServletRequest request) {
		getRequestStats(request).start(request.getRequestURI());
	}
	
	/**
	 * 
	 */
	public static void end(HttpServletRequest request) {
		getRequestStats(request).end();
	}
	/**
	 * 
	 * @param bwRequestStats
	 */
	public static void addBWStats(HttpServletRequest request, long startTime, long endTime) {
		getRequestStats(request).addBWRequestStats(startTime, endTime);
	}
	
	public static class RequestStats {
		private String uri;
		private long startTime;
		private long endTime;
		
		protected List<BWRequestStats> bwStats = new ArrayList<PerformanceClac.BWRequestStats>();
		/**
		 * 
		 * @param uri
		 */
		public void start(String uri) {
			this.uri = uri;
			this.startTime = System.currentTimeMillis();
		}
		/**
		 * 
		 */
		public void end() {
			this.endTime = System.currentTimeMillis();
		}
		/**
		 * 
		 * @param bwRequestStats
		 */
		public void addBWRequestStats(long startTime, long endTime) {
			BWRequestStats bwRequestStats = new BWRequestStats(startTime, endTime);
			this.bwStats.add(bwRequestStats);
		}
		
		/**
		 * 
		 * @return
		 */
		public long throughput() {
			return endTime - startTime;
		}
		/**
		 * 
		 * @return
		 */
		public long totalBWTime() {
			long result = ALOCConstants.BASE_VALUE;
			for(BWRequestStats bwReqStats : bwStats) {
				result += bwReqStats.timeTaken();
			}
			return result;
		}
		/**
		 * 
		 * @return
		 */
		public long javaTime() {
			return throughput() - totalBWTime();
		}
		/**
		 * 
		 * @return
		 */
		public List<BWRequestStats> getBWRequestStats() {
			return bwStats;
		}
		/**
		 * 
		 * @return
		 */
		public String getURI() {
			return uri;
		}
	}
	
	public static class BWRequestStats {
		protected long startTime;
		protected long endTime;
		
		public BWRequestStats(long startTime, long endTime) {
			this.startTime = startTime;
			this.endTime = endTime;
		}

		/**
		 * 
		 * @return
		 */
		public long timeTaken() {
			return endTime - startTime;
		}

		/**
		 * @return the startTime
		 */
		public long getStartTime() {
			return startTime;
		}

		/**
		 * @return the endTime
		 */
		public long getEndTime() {
			return endTime;
		}
	}
}
