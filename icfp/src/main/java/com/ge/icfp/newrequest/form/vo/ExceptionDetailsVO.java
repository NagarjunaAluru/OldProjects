/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: ExceptionDetailsVO.java
 * Purpose: ExceptionDetailsVO used for the exception attributes.
 */
package com.ge.icfp.newrequest.form.vo;

/**
 * @author madhusudhan.gosula
 *
 */
public class ExceptionDetailsVO{
	
	private String	standardTerms = "";
	private String  requestException = "";
	private String  exceptionImpact = "";
	private String  exceptionPotential = "";
	private String  exceptionTimeLine = "";
	private String  remediationComments = "";
	private String  remediationTimeFrame = "";
	/**
	 * @return the standardTerms
	 */
	public String getStandardTerms() {
		return standardTerms;
	}
	/**
	 * @param standardTerms the standardTerms to set
	 */
	public void setStandardTerms(String standardTerms) {
		this.standardTerms = standardTerms;
	}
	/**
	 * @return the requestException
	 */
	public String getRequestException() {
		return requestException;
	}
	/**
	 * @param requestException the requestException to set
	 */
	public void setRequestException(String requestException) {
		this.requestException = requestException;
	}
	/**
	 * @return the exceptionImpact
	 */
	public String getExceptionImpact() {
		return exceptionImpact;
	}
	/**
	 * @param exceptionImpact the exceptionImpact to set
	 */
	public void setExceptionImpact(String exceptionImpact) {
		this.exceptionImpact = exceptionImpact;
	}
	/**
	 * @return the exceptionPotential
	 */
	public String getExceptionPotential() {
		return exceptionPotential;
	}
	/**
	 * @param exceptionPotential the exceptionPotential to set
	 */
	public void setExceptionPotential(String exceptionPotential) {
		this.exceptionPotential = exceptionPotential;
	}
	/**
	 * @return the exceptionTimeLine
	 */
	public String getExceptionTimeLine() {
		return exceptionTimeLine;
	}
	/**
	 * @param exceptionTimeLine the exceptionTimeLine to set
	 */
	public void setExceptionTimeLine(String exceptionTimeLine) {
		this.exceptionTimeLine = exceptionTimeLine;
	}
	/**
	 * @return the remediationComments
	 */
	public String getRemediationComments() {
		return remediationComments;
	}
	/**
	 * @param remediationComments the remediationComments to set
	 */
	public void setRemediationComments(String remediationComments) {
		this.remediationComments = remediationComments;
	}
	/**
	 * @return the remediationTimeFrame
	 */
	public String getRemediationTimeFrame() {
		return remediationTimeFrame;
	}
	/**
	 * @param remediationTimeFrame the remediationTimeFrame to set
	 */
	public void setRemediationTimeFrame(String remediationTimeFrame) {
		this.remediationTimeFrame = remediationTimeFrame;
	}
}
