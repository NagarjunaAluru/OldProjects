/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: Event.java
 * Purpose: Event is used for external users.
 */
package com.ge.aloc.ext.eas.service.client;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * @author chaitanya.n
 *
 */
/**
 * <p>Java class for Event complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Event">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="eventType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="success" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numberOfAttempts" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Event", propOrder = {
		"eventType",
		"success",
		"numberOfAttempts"
})
public class Event
implements Serializable
{

	private final static long serialVersionUID = 2L;
	@XmlElement(nillable = true)
	protected String eventType;
	@XmlElement(nillable = true)
	protected String success;
	@XmlElement(nillable = true)
	protected String numberOfAttempts;

	/**
	 * Gets the value of the eventType property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getEventType() {
		return eventType;
	}

	/**
	 * Sets the value of the eventType property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setEventType(String value) {
		this.eventType = value;
	}

	/**
	 * Gets the value of the success property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getSuccess() {
		return success;
	}

	/**
	 * Sets the value of the success property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setSuccess(String value) {
		this.success = value;
	}

	/**
	 * Gets the value of the numberOfAttempts property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getNumberOfAttempts() {
		return numberOfAttempts;
	}

	/**
	 * Sets the value of the numberOfAttempts property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setNumberOfAttempts(String value) {
		this.numberOfAttempts = value;
	}

}
