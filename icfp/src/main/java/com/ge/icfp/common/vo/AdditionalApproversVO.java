/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: AdditionalApproversVO.java
 * Purpose: AdditionalApproversVO used for define the additional Approvers attributes
 */
package com.ge.icfp.common.vo;

/**
 * AdditionalApproversAction used for define the additional Approvers attributes
 * @author sreenivas.pattaswamy
 *
 */
public class AdditionalApproversVO{

	/**
	 * ssoId
	 */
	private String ssoId;
	/**
	 * firstName
	 */
	private String firstName;
	/**
	 * lastName
	 */
	private String lastName;
	/**
	 * fullName
	 */
	private String fullName;
	/**
	 * emailAddress
	 */
	private String emailAddress;
	/**
	 * @return the ssoId
	 */
	public String getSsoId() {
		return ssoId;
	}
	/**
	 * @param ssoId the ssoId to set
	 */
	public void setSsoId(String ssoId) {
		this.ssoId = ssoId;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}
	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}
	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
}
