/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ChannelIndicatorType.java
 * Purpose: ChannelIndicatorType is used for external users.
 */
package com.ge.aloc.ext.eas.service.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * @author chaitanya.n
 *
 */
/**
 * <p>Java class for ChannelIndicatorType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ChannelIndicatorType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="WEB"/>
 *     &lt;enumeration value="MOBILE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ChannelIndicatorType")
@XmlEnum
public enum ChannelIndicatorType {

	WEB,
	MOBILE;

	public String value() {
		return name();
	}

	public static ChannelIndicatorType fromValue(String v) {
		return valueOf(v);
	}

}
