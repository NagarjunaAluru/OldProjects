package com.galaxe.gst.models.trainer_trainee;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.galaxe.gst.models.login.TestCategory;
import com.galaxe.gst.models.login.TestSubCategory;

@Entity
@Table(name="testTraining")
public class TestTraining{
	
	@Id
	@GeneratedValue
	@Column(name="trainingId")
	private int trainingId;

	@Column(name="trainingName")
	private String trainingName;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="CaegoryID")
	private TestCategory testCategory;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="subCategoryId")
	private TestSubCategory testSubCategory;
	
	@Column(name="trainingDuration")
	private String TrainingDuration;
	
	@Column(name="trainingFile")
	private String trainingFile;

	public int getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}

	public String getTrainingName() {
		return trainingName;
	}

	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}

	public TestCategory getTestCategory() {
		return testCategory;
	}

	public void setTestCategory(TestCategory testCategory) {
		this.testCategory = testCategory;
	}

	public TestSubCategory getTestSubCategory() {
		return testSubCategory;
	}

	public void setTestSubCategory(TestSubCategory testSubCategory) {
		this.testSubCategory = testSubCategory;
	}

	public String getTrainingDuration() {
		return TrainingDuration;
	}

	public void setTrainingDuration(String trainingDuration) {
		TrainingDuration = trainingDuration;
	}

	public String getTrainingFile() {
		return trainingFile;
	}

	public void setTrainingFile(String trainingFile) {
		this.trainingFile = trainingFile;
	}
}
