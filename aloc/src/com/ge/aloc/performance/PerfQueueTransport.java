/*
 * Copyright © 2013 GE. ALL RIGHTS RESERVED.
 * FileName: PerfQueueTransport.java
 * Purpose: PerfQueueTransport used for time logging Performances Statistics
 */
package com.ge.aloc.performance;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hydus.hwf.exceptions.HWFTransportException;
import com.hydus.hwf.transport.jms.QueueTransport;
import com.hydus.hwf.transport.jms.QueueTransportConfiguration;

/**
 * @author ramakrishna.satti
 * This class is used for the performance calculation for testing.
 */
public class PerfQueueTransport extends QueueTransport {
	
	/**
	 * Default constructor
	 */
	public PerfQueueTransport() {
		super();
	}
	/**
	 * PerfQueueTransport
	 * @param configuration
	 */
	public PerfQueueTransport(QueueTransportConfiguration configuration) {
		super(configuration);
	}

	@Override
	public String doRequestReply(String input) throws HWFTransportException {
		long startTime = System.currentTimeMillis();
		String output = super.doRequestReply(input);
		long endTime = System.currentTimeMillis();
		
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			PerformanceClac.addBWStats(request, startTime, endTime);
		} catch (Exception e) {
		}
		
		return output;
	}
	
	/**
	 * doRequestReply
	 */
	public String doRequestReply(Map<String, String> input) throws HWFTransportException {
		long startTime = System.currentTimeMillis();
		String output = super.doRequestReply(input);
		long endTime = System.currentTimeMillis();

		HttpServletRequest request = ServletActionContext.getRequest();
		PerformanceClac.addBWStats(request, startTime, endTime);
		return output;
	}

}
