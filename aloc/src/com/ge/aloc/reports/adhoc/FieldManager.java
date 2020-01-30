/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: FieldManager.java
 * Purpose: FieldManager used to manage configured Adhoc report fields.
 */
package com.ge.aloc.reports.adhoc;

import java.io.InputStream;
import java.io.Writer;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.log4j.Logger;

import com.ge.aloc.InstrumentType;
import com.ge.aloc.exception.ALOCRuntimeException;

/**
 * @author chaitanya.n
 *
 */
public class FieldManager {
	private static final Logger LOGGER = Logger.getLogger(FieldManager.class);
	private static final String CONFIG_FILE_NAME = "adhoc-report-field-config.xml";
	
	private AdhocFieldConfig fieldConfig;
	private JAXBContext jaxbContext;
	
	/**
	 * Method to load config file
	 */
	public void init() {
		try {
			jaxbContext = JAXBContext.newInstance(AdhocFieldConfig.class);
		} catch (JAXBException jaxbe) {
			throw new ALOCRuntimeException(ALOCRuntimeException.EC_CONFIG, "Error while creating JAXBContext, reading Adhoc report field configuration", jaxbe);
		}
		
		InputStream inStream = null;
		//inStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(CONFIG_FILE_NAME);
		inStream = this.getClass().getResourceAsStream(CONFIG_FILE_NAME);
		if(inStream == null) {
			String errMsg = new StringBuilder().append("\'").append(CONFIG_FILE_NAME).append("\' in classpath").toString();
			throw new ALOCRuntimeException(ALOCRuntimeException.EC_CONFIG, errMsg);
		}
		
		try {
			fieldConfig = (AdhocFieldConfig) jaxbContext.createUnmarshaller().unmarshal(inStream);
		} catch (JAXBException jaxbe) {
			throw new ALOCRuntimeException(ALOCRuntimeException.EC_CONFIG, "Error while reading the Adhoc report field configuration", jaxbe);
		}
		
		fieldConfig.init();
	}
	
	/**
	 * Method to search field and Instrument
	 * @param fieldName
	 * @return
	 */
	protected List<Section> search(String fieldName, InstrumentType... instrumentTypes) {
		return fieldConfig.search(fieldName, instrumentTypes);
	}
	
	/**
	 * 
	 * @param domainId
	 * @param fieldId
	 * @return
	 */
	public Field getField(String fieldId) {
		return fieldConfig.getField(fieldId);
	}
	
	/**
	 * Method to Search in config file
	 * @param fieldName
	 * @param writer
	 */
	public void search(String fieldName, InstrumentType[] instrumentTypes, Writer writer) {
		List<Section> resultSections = search(fieldName, instrumentTypes);
		AdhocFieldConfig adhocFieldConfig = new AdhocFieldConfig(resultSections);
		try {
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.marshal(adhocFieldConfig, writer);
		} catch (JAXBException jaxbe) {
			String msg = new StringBuilder().append("Error while marshalling the AdhocFieldConfig ").append(adhocFieldConfig).toString();
			LOGGER.error(msg, jaxbe);
			throw new ALOCRuntimeException(ALOCRuntimeException.EC_CONFIG, msg, jaxbe);
		}
	}
	
}
