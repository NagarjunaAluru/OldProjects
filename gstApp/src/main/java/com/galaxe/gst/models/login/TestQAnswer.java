/**
 * 
 */
package com.galaxe.gst.models.login;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;


/**
 * @author naluru
 *
 */

@Entity
@Table(name="TestQAnswer")
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestQAnswer implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="QAnswerId")
	private int qanswerId;
	
	@Column(name="TestQAnswer")
	private String testQAnswer;
	
	@Column(name="TestAnwerFlag")
	private Boolean testAnwerFlag;
	
	
	@ManyToOne
	@JoinColumn(name="TestQId")
	@JsonBackReference
	private TestQuestions testQId;


	public int getQanswerId() {
		return qanswerId;
	}


	public void setQanswerId(int qanswerId) {
		this.qanswerId = qanswerId;
	}


	public String getTestQAnswer() {
		return testQAnswer;
	}


	public void setTestQAnswer(String testQAnswer) {
		this.testQAnswer = testQAnswer;
	}


	public Boolean getTestAnwerFlag() {
		return testAnwerFlag;
	}


	public void setTestAnwerFlag(Boolean testAnwerFlag) {
		this.testAnwerFlag = testAnwerFlag;
	}


	public TestQuestions getTestQId() {
		return testQId;
	}


	public void setTestQId(TestQuestions testQId) {
		this.testQId = testQId;
	}

	
}
