/**
 * 
 */
package com.galaxe.gst.models.login;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;


/**
 * @author nramanjaneyulu
 *
 */

@Entity
@Table(name="TestForm")
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestForm implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="TestId")
	private int testId;
	
	@Column(name="TestName", unique = true ,nullable = false)
	private String testName;
	
	@Column(name="CreatedBy")
	private String createdBy;
	
	@Column(name="CreatedOn")
	private String createdOn;
	
	@Column(name="UpdatedOn")
	private String updatedOn;
	
	@Column(name="TestTime",nullable = false)
	private int testTime;
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="Test_Questions", 
				joinColumns={@JoinColumn(name="TestId")}, 
				inverseJoinColumns={@JoinColumn(name="TestQId")})
	private List<TestQuestions> testQuestions = new ArrayList<TestQuestions>();
	
	public List<TestQuestions> getTestQuestions() {
		return testQuestions;
	}

	public void setTestQuestions(List<TestQuestions> testQuestions) {
		this.testQuestions = testQuestions;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}

	public int getTestTime() {
		return testTime;
	}

	public void setTestTime(int testTime) {
		this.testTime = testTime;
	}


//	public TestSubCategory getTestSubCategory() {
//		return testSubCategory;
//	}
//
//	public void setTestSubCategory(TestSubCategory testSubCategory) {
//		this.testSubCategory = testSubCategory;
//	}

}
