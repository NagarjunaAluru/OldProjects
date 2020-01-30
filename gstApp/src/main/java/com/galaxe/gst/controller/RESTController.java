package com.galaxe.gst.controller;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.multipart.MultipartFile;

import com.galaxe.gst.models.export.Report;
import com.galaxe.gst.models.login.QuestionAndAnswer;
import com.galaxe.gst.models.login.Roles;
import com.galaxe.gst.models.login.TestCategory;
import com.galaxe.gst.models.login.TestForm;
import com.galaxe.gst.models.login.TestQuestions;
import com.galaxe.gst.models.login.TestSubCategory;
import com.galaxe.gst.models.login.Users;
import com.galaxe.gst.models.trainer_trainee.Training;
import com.galaxe.gst.service.SkillTestService;
import com.sun.jersey.multipart.FormDataParam;

/**
 * 
 * @author naluru
 *
 */
@Path("/restCtrl")
public class RESTController extends SpringBeanAutowiringSupport {
	static Logger logger = Logger.getLogger(RESTController.class);
	
	@Autowired
	private SkillTestService skillTestService;
	
	@Path("/getRoles")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Roles> getRoles(){
		return skillTestService.getRoles();
	}
	
	@Path("/createUser")
	@POST
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces(MediaType.APPLICATION_JSON)
	public Users createUser(Users user){
		return skillTestService.createUser(user);
	}
	
	@Path("/saveCategories")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void saveCategories(List<TestCategory> categories){
		skillTestService.saveCategories(categories);
	}
	
	@Path("/getCategories")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<TestCategory> getCategories(){
		return skillTestService.getCategories();
	}
	
	@Path("/getSubCategories/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<TestSubCategory> getSubCategories(@PathParam("id")int id){
		return skillTestService.getSubCategories(id);
	}
	
	@Path("/saveSubCategories")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_JSON)
	public String saveSubCategories(List<TestSubCategory> subCategoryList){
		return skillTestService.saveSubCategories(subCategoryList);
	}
	
	@Path("/createTest")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<TestQuestions> createTest(TestForm testForm){
		return skillTestService.createTest(testForm);
		
	}
	
	@Path("/addQuestion")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public String addQuestion(QuestionAndAnswer questionAnswer){
		
		skillTestService.addQuestion(questionAnswer);
		return "";
		
	}
	
	@Path("/getQuestions/{subCatId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<TestQuestions> getQuestions(@PathParam("subCatId")int subCatId){
		
		List<TestQuestions> questionList = skillTestService.getQuestions(subCatId);
		return questionList;
		
	}
	
	/*Applicant Module Start*/
	
	@Path("/saveApplicant")
	@POST
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public String updateUser(Users user) {
	 
	  return skillTestService.updateUser(user);
	}
	
	
	@Path("/getuser/{user}")
	@GET
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Users getUserById(@PathParam("user") String userName) {
		Users user = skillTestService.getUserByName(userName);
	  return user;
	}
	

	@Path("/submitTest/{testAssignTime}/{takenTime}/")
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public String submitTest(Users user,@PathParam("testAssignTime") String testAssignTime,
			@PathParam("takenTime") String takenTime) {
		
	  return "";
	}
	
	/*Applicant Module End*/
	
	/*HR Module Start*/
	
	@Path("/getTestList")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<TestForm> getTestList(){
		List<TestForm> testList = skillTestService.getTestList();
		return testList;
	}
	
	@Path("/createApplicants")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void setApplicantList(List<Users> users){
		for(Users user:users){
			skillTestService.createUser(user);
		}
	}
	
	/*HR Module End*/
	
	/*Export Start*/
	
	@Path("exportToExcel/{sDate}/{eDate}/{criteria}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String exportToExcel(@PathParam("sDate")String str1,@PathParam("eDate")String str2,@PathParam("criteria")String criteria,@Context HttpServletResponse response){
		System.out.println("insdie rest controller!!");
		
		System.out.println(response);
		
		skillTestService.exportToExcel(str1,str2,criteria,response);
		
		return "";
	}
		
	@Path("criteriaSet/{criteria}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Report> exportToExcel(@PathParam("criteria")String sdfd){
		System.out.println("parameter recieved is :" + sdfd);
		/*List<Customer> testList = skillTestService.exportToExcel();*/
		return null;
	}
	
	//TODO: Need to Remove
	@Path("fetchCategory")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> fetchCategory()
	{
		System.out.println("inside rest controller!!");
		List<String> category = skillTestService.fetchCategory();
		System.out.println("rest controller list:"+category);
		return category;
	}
	
	//TODO: Need to Remove
	@Path("fetchSubCategory/{category}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> fetchSubCategory(@PathParam("category")String category)
	{
		
		List <String> subCategory = skillTestService.fetchSubCategory(category);
		
		return subCategory;
	}
	
	/*Export End*/
	
	/*Trainer Module Start*/
	@Path("/createTraining")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA})
	public void createTraining(Training training) throws IOException{
		
		/*String filePath = "D:\\FileUploads\\" + System.currentTimeMillis() + "_" + training.getTrainingFileName();
		File uploadedFile = training.getTrainingFile();
		
		FileOutputStream fout = new FileOutputStream(filePath);
		ObjectOutputStream oos = new ObjectOutputStream(fout);   
		oos.writeBytes(uploadedFile.toString());
		oos.close();*/
		
		String name = "";
        
		byte byteArr[] = training.getFileUpload().getBytes();
         /*if (!training.getTrainingFile().isEmpty()) {
        	 name=training.getTrainingFile().getOriginalFilename();
            
             String rootPath = "D/FileUploads";
             File dir = new File(rootPath + File.separator + "RESUMES");
             if (!dir.exists()){ dir.mkdirs(); }
                
             String serverFileLocation =dir.getAbsolutePath() + File.separator + name;
            
             try {
                   FileCopyUtils.copy(training.getTrainingFile().getBytes(), new File(serverFileLocation));
                } catch (IOException e) {
                      System.out.println(e.getMessage()); 
                }
         }*/
		
		if (training.getFileUpload() != null) {
       	 name=training.getTrainingFileName();
           
            String rootPath = "D:\\FileUploads\\";
            File dir = new File(rootPath);
            if (!dir.exists()){ dir.mkdirs(); }
               
            String serverFileLocation = rootPath + System.currentTimeMillis() + "_" + name;
            
            BufferedOutputStream buffStream = 
                    new BufferedOutputStream(new FileOutputStream(new File(serverFileLocation)));
            buffStream.write(byteArr);
            buffStream.close();
           
           /* try {
                  FileCopyUtils.copy(byteArr, new File(serverFileLocation));
               } catch (IOException e) {
                     System.out.println(e.getMessage()); 
               }*/
        }
		
	}
	
	
	private byte[] readContentIntoByteArray(File file)
	   {
	      FileInputStream fileInputStream = null;
	      byte[] bFile = new byte[(int) file.length()];
	      try
	      {
	         //convert file into array of bytes
	         fileInputStream = new FileInputStream(file.getAbsoluteFile());
	         fileInputStream.read(bFile);
	         fileInputStream.close();
	         for (int i = 0; i < bFile.length; i++)
	         {
	            System.out.print((char) bFile[i]);
	         }
	      }
	      catch (Exception e)
	      {
	         e.printStackTrace();
	      }
	      return bFile;
	   }
	
	/*Trainer Module End*/
	
}
