package com.galaxe.gst.models.trainer_trainee;

import java.io.File;
import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.web.multipart.MultipartFile;

import com.galaxe.gst.models.login.TestCategory;
import com.galaxe.gst.models.login.TestSubCategory;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Training implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int trainingID;
	private String trainingName;
	private TestCategory testCategory;
	private TestSubCategory testSubCategory;
	private String trainingDuration;
	private MultipartFile trainingFile;
	private String fileUpload;
	private String trainingFileName;

	public String getFileUpload() {
		return fileUpload;
	}
	public void setFileUpload(String fileUpload) {
		this.fileUpload = fileUpload;
	}
	public MultipartFile getTrainingFile() {
		return trainingFile;
	}
	public void setTrainingFile(MultipartFile trainingFile) {
		this.trainingFile = trainingFile;
	}
	public String getTrainingFileName() {
		return trainingFileName;
	}
	public void setTrainingFileName(String trainingFileName) {
		this.trainingFileName = trainingFileName;
	}
	public int getTrainingID() {
		return trainingID;
	}
	public void setTrainingID(int trainingID) {
		this.trainingID = trainingID;
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
		return trainingDuration;
	}
	public void setTrainingDuration(String trainingDuration) {
		this.trainingDuration = trainingDuration;
	}
	
}
