/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ChallengeAnswerResponse.java
 * Purpose: ChallengeAnswerResponse is used for external users.
 */
package com.ge.aloc.ext.eas.service.client;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * @author chaitanya.n
 *
 */
/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="challengeAnswerReturn" type="{http://com.ge.b2ewebservice/B2EService/}B2EResponse"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
		"challengeAnswerReturn"
})
@XmlRootElement(name = "challengeAnswerResponse")
public class ChallengeAnswerResponse
implements Serializable
{

	private final static long serialVersionUID = 2L;
	@XmlElement(required = true, nillable = true)
	protected B2EResponse challengeAnswerReturn;

	/**
	 * Gets the value of the challengeAnswerReturn property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link B2EResponse }
	 *     
	 */
	public B2EResponse getChallengeAnswerReturn() {
		return challengeAnswerReturn;
	}

	/**
	 * Sets the value of the challengeAnswerReturn property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link B2EResponse }
	 *     
	 */
	public void setChallengeAnswerReturn(B2EResponse value) {
		this.challengeAnswerReturn = value;
	}

}
