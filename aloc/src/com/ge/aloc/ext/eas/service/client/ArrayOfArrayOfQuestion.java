/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ArrayOfArrayOfQuestion.java
 * Purpose: ArrayOfArrayOfQuestion is used for external users.
 */
package com.ge.aloc.ext.eas.service.client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * @author chaitanya.n
 *
 */
/**
 * <p>Java class for ArrayOfArrayOfQuestion complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfArrayOfQuestion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="item" type="{http://com.ge.b2ewebservice/B2EService/}ArrayOfQuestion" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfArrayOfQuestion", propOrder = {
		"item"
})
public class ArrayOfArrayOfQuestion
implements Serializable
{

	private final static long serialVersionUID = 2L;
	@XmlElement(nillable = true)
	protected List<ArrayOfQuestion> item;

	/**
	 * Gets the value of the item property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list,
	 * not a snapshot. Therefore any modification you make to the
	 * returned list will be present inside the JAXB object.
	 * This is why there is not a <CODE>set</CODE> method for the item property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * <pre>
	 *    getItem().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link ArrayOfQuestion }
	 * 
	 * 
	 */
	public List<ArrayOfQuestion> getItem() {
		if (item == null) {
			item = new ArrayList<ArrayOfQuestion>();
		}
		return this.item;
	}

}
