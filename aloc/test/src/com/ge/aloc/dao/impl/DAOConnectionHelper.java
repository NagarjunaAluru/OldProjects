/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: DAOConnectionHelper.java
 * Purpose: DAOConnectionHelper used for service client configuration
 *
 */

package com.ge.aloc.dao.impl;

import com.hydus.hwf.bw.service.ApplicationServiceClient;
import com.hydus.hwf.bw.service.BWServiceStub;
import com.hydus.hwf.bw.service.IServiceClient;
import com.hydus.hwf.transport.jms.QueueTransport;
import com.hydus.hwf.transport.jms.QueueTransportConfiguration;

/**
 * @author rajeswari.guthi
 *
 */
public abstract class DAOConnectionHelper {
	/**
	 * 
	 * @return
	 */
	public static QueueTransportConfiguration getConfigObject(){
		QueueTransportConfiguration config = new QueueTransportConfiguration();
		config.setProviderContextFactory("com.tibco.tibjms.naming.TibjmsInitialContextFactory");			 
		config.setServerURL("tcp://192.168.0.35:7222");//needs to change based on the database server
		config.setJndiUserName("");
		config.setJndiPassword("");
		config.setQueueConnectionFactory("LBQueueConnectionFactory");
		config.setJmsUserName("admin");
		config.setJmsPassword("admin");
		config.setDestination("GE.TREASURY.ALOC.BPM.UI.ROUTER");
		config.setMessageExpiry(180000);
		
		config.setServiceTimeOut(180000);
		config.setMaxRetryCount(3); 	
		return config;
	}
	/**
	 * 
	 * @return
	 */
	public static QueueTransport getTransportObject(){
		com.hydus.hwf.transport.jms.QueueTransport queueTransport = new com.hydus.hwf.transport.jms.QueueTransport();		 
		queueTransport.setConfiguration(getConfigObject());
		return queueTransport;
	}
	/**
	 * 
	 * @return
	 */
	public static BWServiceStub getServiceStubObject(){
		 com.hydus.hwf.binding.xml.JAXBService jaxbService = new com.hydus.hwf.binding.xml.JAXBService();
		 jaxbService.setPackages("com.hydus.hwf.bw.messages.envelop:com.ge.aloc.model");
		 com.hydus.hwf.bw.service.DefaultFaultHandler handler = new com.hydus.hwf.bw.service.DefaultFaultHandler();
		 com.hydus.hwf.bw.service.BWServiceStub stub = new com.hydus.hwf.bw.service.BWServiceStub();
		 stub.setTransport(getTransportObject());			 
		 stub.setBindingService(jaxbService);
		 stub.setFaultHandler(handler);
		return stub;
	}	
	/**
	 * 
	 * @return
	 */
	public static IServiceClient getServiceClient() {
		ApplicationServiceClient applicationServiceClient = new ApplicationServiceClient();
		applicationServiceClient.setServiceStub(getServiceStubObject());
		return applicationServiceClient;
	}
}
