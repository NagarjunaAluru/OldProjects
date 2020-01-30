/**
 * 
 */
package com.galaxe.gst.models.login;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonManagedReference;


/**
 * @author naluru
 *
 */
@Entity
@Table(name="TestQuestions")
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestQuestions implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="TestQId")
	private int testQId;
	
	@Column(name="TestQuestion")
	private String testQuestion;
	
	@Column(name="QuestionLevel")
	private String questionLevel;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="SubCategoryId")
	private TestSubCategory testSubCategory;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="TestQId")
	@JsonManagedReference
	private Set<TestQAnswer> testQAnswer ;
	
	public Set<TestQAnswer> getTestQAnswer() {
		return testQAnswer;
	}

	public void setTestQAnswer(Set<TestQAnswer> testQAnswer) {
		this.testQAnswer = testQAnswer;
	}

	public int getTestQId() {
		return testQId;
	}

	public void setTestQId(int testQId) {
		this.testQId = testQId;
	}

	public String getTestQuestion() {
		return testQuestion;
	}

	public void setTestQuestion(String testQuestion) {
		this.testQuestion = testQuestion;
	}

	public String getQuestionLevel() {
		return questionLevel;
	}

	public void setQuestionLevel(String questionLevel) {
		this.questionLevel = questionLevel;
	}

	public TestSubCategory getTestSubCategory() {
		return testSubCategory;
	}

	public void setTestSubCategory(TestSubCategory testSubCategory) {
		this.testSubCategory = testSubCategory;
	}
	

}
