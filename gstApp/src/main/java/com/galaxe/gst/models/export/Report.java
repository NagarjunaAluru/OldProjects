package com.galaxe.gst.models.export;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="Report")
public class Report implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="reportId")
	private int reportId;
	
	@Column(name="testName")
	private String testName;
	
	@Column(name="duration")
	private int duration;
	
	@Column(name="categoryName")
	private String categoryName;
	
	@Column(name="subCategoryName")
	private String subCategoryName;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	
	@Column(name="emailId")
	private String email;
	
	@Column(name="contact")
	private Long contact;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dob")
	private Date dob;
	
	@Temporal(TemporalType.DATE)
	@Column(name="testDate")
	private Date testDate;
	
	@Column(name="score")
	private int score;
	
	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getContact() {
		return contact;
	}

	public void setContact(Long contact) {
		this.contact = contact;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getTestDate() {
		return testDate;
	}

	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

	
	@Override
	public String toString() {
		return "Report1 [idReport1=" + reportId + ", testName=" + testName
				+ ", duration=" + duration + ", categoryName=" + categoryName
				+ ", subCategoryName=" + subCategoryName + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email
				+ ", contact=" + contact + ", dob=" + dob + ", testDate="
				+ testDate + ", score=" + score + "]";
	}
	
	


}