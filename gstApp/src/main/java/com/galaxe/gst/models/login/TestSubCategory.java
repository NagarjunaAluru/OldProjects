package com.galaxe.gst.models.login;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;


@Entity
@Table(name="testsubcategory")
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestSubCategory implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="SubCategoryId")
	private int subCategoryId;
	
	@Column(name="SubCategory")
	private String subCategory;
	
	@Column(name="CreatedBy")
	private String createdBy;
	
	@Column(name="CreatedOn")
	private Date createdOn;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="CategoryId")
	private TestCategory testCategory;
	
	public int getSubCategoryId() {
		return subCategoryId;
	}
	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}
	public String getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	public TestCategory getTestCategory() {
		return testCategory;
	}
	public void setTestCategory(TestCategory testCategory) {
		this.testCategory = testCategory;
	}
}
