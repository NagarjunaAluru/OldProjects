/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: QualitativeAssessmentVO.java
 * Purpose: QualitativeAssessmentVO has the attributes which are required for QualitativeAssessment.
 */
package com.ge.icfp.common.vo;

/**
 * 
 * @author madhusudhan.gosula
 *
 */
public class QualitativeAssessmentVO {
	/**
	 * qualitativeFactor
	 */
	private String qualitativeFactor;
	/**
	 * assessment
	 */
	private String assessment;
	/**
	 * owner
	 */
	private String owner;
	/**
	 * rationale
	 */
	private String rationale;
	/**
	 * rational
	 */
	private String rational;
	/**
	 * qualitativeFactorId
	 */
	private Integer qualitativeFactorId;
	/**
	 * qualitativeFactorDesc
	 */
	private String qualitativeFactorDesc;
	/**
	 * @return the qualitativeFactor
	 */
	public String getQualitativeFactor() {
		return qualitativeFactor;
	}
	/**
	 * @param qualitativeFactor the qualitativeFactor to set
	 */
	public void setQualitativeFactor(String qualitativeFactor) {
		this.qualitativeFactor = qualitativeFactor;
	}
	/**
	 * @return the assessment
	 */
	public String getAssessment() {
		return assessment;
	}
	/**
	 * @param assessment the assessment to set
	 */
	public void setAssessment(String assessment) {
		this.assessment = assessment;
	}
	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}
	/**
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}
	/**
	 * @return the rationale
	 */
	public String getRationale() {
		return rationale;
	}
	/**
	 * @param rationale the rationale to set
	 */
	public void setRationale(String rationale) {
		this.rationale = rationale;
	}
	/**
	 * @return the rational
	 */
	public String getRational() {
		return rational;
	}
	/**
	 * @param rational the rational to set
	 */
	public void setRational(String rational) {
		this.rational = rational;
	}
	/**
	 * @return the qualitativeFactorId
	 */
	public Integer getQualitativeFactorId() {
		return qualitativeFactorId;
	}
	/**
	 * @param qualitativeFactorId the qualitativeFactorId to set
	 */
	public void setQualitativeFactorId(Integer qualitativeFactorId) {
		this.qualitativeFactorId = qualitativeFactorId;
	}
	/**
	 * @return the qualitativeFactorDesc
	 */
	public String getQualitativeFactorDesc() {
		return qualitativeFactorDesc;
	}
	/**
	 * @param qualitativeFactorDesc the qualitativeFactorDesc to set
	 */
	public void setQualitativeFactorDesc(String qualitativeFactorDesc) {
		this.qualitativeFactorDesc = qualitativeFactorDesc;
	}
}
