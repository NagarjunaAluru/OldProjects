/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: Image.java
 * Purpose: Image is used for external users.
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
 * <p>Java class for Image complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Image">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="altText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="data" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="height" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="width" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="path" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Image", propOrder = {
		"altText",
		"data",
		"height",
		"width",
		"path"
})
public class Image
implements Serializable
{

	private final static long serialVersionUID = 2L;
	@XmlElement(nillable = true)
	protected String altText;
	@XmlElement(nillable = true)
	protected String data;
	@XmlElement(nillable = true)
	protected String height;
	@XmlElement(nillable = true)
	protected String width;
	@XmlElement(nillable = true)
	protected String path;

	/**
	 * Gets the value of the altText property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getAltText() {
		return altText;
	}

	/**
	 * Sets the value of the altText property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setAltText(String value) {
		this.altText = value;
	}

	/**
	 * Gets the value of the data property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getData() {
		return data;
	}

	/**
	 * Sets the value of the data property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setData(String value) {
		this.data = value;
	}

	/**
	 * Gets the value of the height property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getHeight() {
		return height;
	}

	/**
	 * Sets the value of the height property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setHeight(String value) {
		this.height = value;
	}

	/**
	 * Gets the value of the width property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getWidth() {
		return width;
	}

	/**
	 * Sets the value of the width property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setWidth(String value) {
		this.width = value;
	}

	/**
	 * Gets the value of the path property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getPath() {
		return path;
	}

	/**
	 * Sets the value of the path property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setPath(String value) {
		this.path = value;
	}

}
