/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: DeviceResponse.java
 * Purpose: DeviceResponse is used for external users.
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
 * <p>Java class for DeviceResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DeviceResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="deviceTokenCookie" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deviceTokenFSO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeviceResponse", propOrder = {
		"deviceTokenCookie",
		"deviceTokenFSO"
})
public class DeviceResponse
implements Serializable
{

	private final static long serialVersionUID = 2L;
	@XmlElement(nillable = true)
	protected String deviceTokenCookie;
	@XmlElement(nillable = true)
	protected String deviceTokenFSO;

	/**
	 * Gets the value of the deviceTokenCookie property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getDeviceTokenCookie() {
		return deviceTokenCookie;
	}

	/**
	 * Sets the value of the deviceTokenCookie property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setDeviceTokenCookie(String value) {
		this.deviceTokenCookie = value;
	}

	/**
	 * Gets the value of the deviceTokenFSO property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getDeviceTokenFSO() {
		return deviceTokenFSO;
	}

	/**
	 * Sets the value of the deviceTokenFSO property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setDeviceTokenFSO(String value) {
		this.deviceTokenFSO = value;
	}

}
