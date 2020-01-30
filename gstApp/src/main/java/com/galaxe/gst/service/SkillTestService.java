/**
 * 
 */
package com.galaxe.gst.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.galaxe.gst.models.export.Report;
import com.galaxe.gst.models.login.QuestionAndAnswer;
import com.galaxe.gst.models.login.Roles;
import com.galaxe.gst.models.login.TestCategory;
import com.galaxe.gst.models.login.TestForm;
import com.galaxe.gst.models.login.TestQuestions;
import com.galaxe.gst.models.login.TestSubCategory;
import com.galaxe.gst.models.login.Users;

/**
 * @author naluru
 *
 */
public interface SkillTestService {
	
	public List<TestForm> getTestList();
	
	public Users createUser(Users user);
	
	public String updateUser(Users user);
	
	public List<Roles> getRoles();
	
	public void saveCategories(List<TestCategory> categories);
	
	public List<TestCategory> getCategories();
	
	public List<TestSubCategory> getSubCategories(int id);
	
	public String saveSubCategories(List<TestSubCategory> subCategoryList);
	
	public List<TestQuestions> createTest(TestForm testForm);
	
	public String addQuestion(QuestionAndAnswer questionAnswer);
	
	public List<TestQuestions> getQuestions(int subCatId);

	public Users getUserByName(String user);
	
	public void exportToExcel(String sDate, String eDate, String criteria,HttpServletResponse response);
	
	
	//TODO: Need to Remove
	public List<String> fetchCategory();
	//TODO: Need to Remove
	public List<String> fetchSubCategory(String category);

}
