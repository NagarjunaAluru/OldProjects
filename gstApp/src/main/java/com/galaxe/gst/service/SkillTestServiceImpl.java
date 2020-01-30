/**
 * 
 */
package com.galaxe.gst.service;

import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.galaxe.gst.dao.SkillTestDao;
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
@Service("skillTestService")
public class SkillTestServiceImpl implements SkillTestService {
	private static final String CHAR_LIST =
	        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	private static final int RANDOM_STRING_LENGTH = 8;
	
	@Autowired
	private SkillTestDao skillTestDao;
	
	public List<TestForm> getTestList(){
		return skillTestDao.getTestList();
		
	}

	@Override
	public Users createUser(Users user) {
		user.setEnabled(true);
		user.setUsername((user.getFirstName()).substring(0, 3)+(user.getLastName()).substring(0, 4));
		user.setPassword(generateRandomString());
		
		if(user.getUserRole() == null || user.getUserRole().size() <= 0){
			Roles role = new Roles();
			role.setRole("USER");
			role.setRoleId(3);
			Set<Roles> rolesList = new HashSet<Roles>();
			rolesList.add(role);
			user.setUserRole(rolesList);
		}
		if(skillTestDao.getUser(user.getUsername())!= null)
		{
			user.setUsername(user.getUsername()+getRandomNumber());
		}
		Users newUser=skillTestDao.createUser(user);
		if(newUser != null)
		{
			mail(newUser.getEmail(),newUser.getFirstName(),newUser.getLastName(),newUser.getUsername(),newUser.getPassword());
		}
		return newUser;
	}

	@Override
	public List<Roles> getRoles() {
		return skillTestDao.getRoles();
	}

	@Override
	public String updateUser(Users user) {
		return skillTestDao.updateUser(user);
	}

	@Override
	public void saveCategories(List<TestCategory> categories) {
		skillTestDao.saveCategories(categories);
		
	}

	@Override
	public List<TestCategory> getCategories() {
		return skillTestDao.getCategories();
	}

	@Override
	public List<TestSubCategory> getSubCategories(int id) {
		return skillTestDao.getSubCategories(id);
	}

	@Override
	public String saveSubCategories(List<TestSubCategory> subCategoryList) {
		return skillTestDao.saveSubCategories(subCategoryList);
	}

	@Override
	public List<TestQuestions> createTest(TestForm testForm) {
		return skillTestDao.createTest(testForm);
	}

	@Override
	public String addQuestion(QuestionAndAnswer questionAnswer) {
		return skillTestDao.addQuestion(questionAnswer);
	}

	@Override
	public List<TestQuestions> getQuestions(int subCatId) {
		return skillTestDao.getQuestions(subCatId);
	}

	@Override
	public Users getUserByName(String user) {
		return skillTestDao.getUserByName(user);
	}
	
	/**
	 * 
	 * @return
	 */
	public String generateRandomString(){
        
        StringBuffer randStr = new StringBuffer();
        for(int i=0; i<RANDOM_STRING_LENGTH; i++){
            int number = getRandomNumber();
            char ch = CHAR_LIST.charAt(number);
            randStr.append(ch);
        }
        return randStr.toString();
    }
	
	/**
	 * 
	 * @return
	 */
    private int getRandomNumber() {
        int randomInt = 0;
        Random randomGenerator = new Random();
        randomInt = randomGenerator.nextInt(CHAR_LIST.length());
        if (randomInt - 1 == -1) {
            return randomInt;
        } else {
            return randomInt - 1;
        }
    }
    
    /**
     * 
     * @param recipient
     * @param fisrtName
     * @param lastName
     * @param userName
     * @param pwd
     */
    private void mail(String recipient,String fisrtName,String lastName,String userName,String pwd)
    {
           
           final String username = "nagarjuna.aluru@gmail.com";
           final String password = "test";

           Properties props = new Properties();
           props.put("mail.smtp.auth", "true");
           props.put("mail.smtp.starttls.enable", "true");
           props.put("mail.smtp.host", "smtp.gmail.com");
           props.put("mail.smtp.port", "587");

           Session session = Session.getInstance(props, new Authenticator() {
                  protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                  }
             });

           try {
                  Message message = new MimeMessage(session);
                  message.setFrom(new InternetAddress("nagarjuna.aluru@gmail.com"));
                  message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(recipient));
                  message.setSubject("GalaxE Talent Aquisition Team: Interview");
                  message.setText("Dear "+fisrtName+" "+lastName+ " ,  UserName is created as : "
                		  +userName+" and password is : "+pwd);

                  Transport.send(message);
           } catch (MessagingException e) {
                  throw new RuntimeException(e);
           }
    }
    
    
    @Override
	public void exportToExcel(String sDate, String eDate,String criteria,HttpServletResponse response) {
		skillTestDao.exportToExcel(sDate,eDate,criteria,response);
		
	}

	@Override
	public List<String> fetchCategory() {
		return skillTestDao.fetchCategory();
	}

	@Override
	public List<String> fetchSubCategory(String category) {
		return skillTestDao.fetchSubCategory(category);
	}

}
