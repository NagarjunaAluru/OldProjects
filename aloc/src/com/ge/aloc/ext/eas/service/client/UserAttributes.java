/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: UserAttributes.java
 * Purpose: UserAttributes is used for external users.
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
 * <p>Java class for UserAttributes complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UserAttributes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="givenName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="linkedBu" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orgId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="selfReg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="surname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gessouid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="currentPassword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ssoStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sessionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transactionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userLanguage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userCountry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserAttributes", propOrder = {
		"givenName",
		"linkedBu",
		"mail",
		"orgId",
		"password",
		"selfReg",
		"surname",
		"userName",
		"gessouid",
		"currentPassword",
		"ssoStatus",
		"sessionId",
		"transactionId",
		"userLanguage",
		"userCountry"
})
public class UserAttributes
implements Serializable
{

	private final static long serialVersionUID = 2L;
	@XmlElement(nillable = true)
	protected String givenName;
	@XmlElement(nillable = true)
	protected String linkedBu;
	@XmlElement(nillable = true)
	protected String mail;
	@XmlElement(nillable = true)
	protected String orgId;
	@XmlElement(nillable = true)
	protected String password;
	@XmlElement(nillable = true)
	protected String selfReg;
	@XmlElement(nillable = true)
	protected String surname;
	@XmlElement(nillable = true)
	protected String userName;
	@XmlElement(nillable = true)
	protected String gessouid;
	@XmlElement(nillable = true)
	protected String currentPassword;
	@XmlElement(nillable = true)
	protected String ssoStatus;
	@XmlElement(nillable = true)
	protected String sessionId;
	@XmlElement(nillable = true)
	protected String transactionId;
	@XmlElement(nillable = true)
	protected String userLanguage;
	@XmlElement(nillable = true)
	protected String userCountry;

	/**
	 * Gets the value of the givenName property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getGivenName() {
		return givenName;
	}

	/**
	 * Sets the value of the givenName property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setGivenName(String value) {
		this.givenName = value;
	}

	/**
	 * Gets the value of the linkedBu property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getLinkedBu() {
		return linkedBu;
	}

	/**
	 * Sets the value of the linkedBu property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setLinkedBu(String value) {
		this.linkedBu = value;
	}

	/**
	 * Gets the value of the mail property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * Sets the value of the mail property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setMail(String value) {
		this.mail = value;
	}

	/**
	 * Gets the value of the orgId property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getOrgId() {
		return orgId;
	}

	/**
	 * Sets the value of the orgId property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setOrgId(String value) {
		this.orgId = value;
	}

	/**
	 * Gets the value of the password property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the value of the password property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setPassword(String value) {
		this.password = value;
	}

	/**
	 * Gets the value of the selfReg property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getSelfReg() {
		return selfReg;
	}

	/**
	 * Sets the value of the selfReg property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setSelfReg(String value) {
		this.selfReg = value;
	}

	/**
	 * Gets the value of the surname property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * Sets the value of the surname property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setSurname(String value) {
		this.surname = value;
	}

	/**
	 * Gets the value of the userName property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the value of the userName property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setUserName(String value) {
		this.userName = value;
	}

	/**
	 * Gets the value of the gessouid property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getGessouid() {
		return gessouid;
	}

	/**
	 * Sets the value of the gessouid property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setGessouid(String value) {
		this.gessouid = value;
	}

	/**
	 * Gets the value of the currentPassword property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getCurrentPassword() {
		return currentPassword;
	}

	/**
	 * Sets the value of the currentPassword property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setCurrentPassword(String value) {
		this.currentPassword = value;
	}

	/**
	 * Gets the value of the ssoStatus property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getSsoStatus() {
		return ssoStatus;
	}

	/**
	 * Sets the value of the ssoStatus property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setSsoStatus(String value) {
		this.ssoStatus = value;
	}

	/**
	 * Gets the value of the sessionId property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getSessionId() {
		return sessionId;
	}

	/**
	 * Sets the value of the sessionId property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setSessionId(String value) {
		this.sessionId = value;
	}

	/**
	 * Gets the value of the transactionId property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getTransactionId() {
		return transactionId;
	}

	/**
	 * Sets the value of the transactionId property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setTransactionId(String value) {
		this.transactionId = value;
	}

	/**
	 * Gets the value of the userLanguage property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getUserLanguage() {
		return userLanguage;
	}

	/**
	 * Sets the value of the userLanguage property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setUserLanguage(String value) {
		this.userLanguage = value;
	}

	/**
	 * Gets the value of the userCountry property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getUserCountry() {
		return userCountry;
	}

	/**
	 * Sets the value of the userCountry property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setUserCountry(String value) {
		this.userCountry = value;
	}

}
