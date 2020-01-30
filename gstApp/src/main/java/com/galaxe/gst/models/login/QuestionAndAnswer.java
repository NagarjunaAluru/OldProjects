/**
 * 
 */
package com.galaxe.gst.models.login;

import java.util.ArrayList;
import java.util.List;


/**
 * @author naluru
 *
 */
public class QuestionAndAnswer {
	
	private List<TestQAnswer> choices = new ArrayList<TestQAnswer>();
	
	private TestQuestions testQuestion;
	

	public TestQuestions getTestQuestion() {
		return testQuestion;
	}

	public void setTestQuestion(TestQuestions testQuestion) {
		this.testQuestion = testQuestion;
	}

	public List<TestQAnswer> getChoices() {
		return choices;
	}

	public void setChoices(List<TestQAnswer> choices) {
		this.choices = choices;
	}
}
