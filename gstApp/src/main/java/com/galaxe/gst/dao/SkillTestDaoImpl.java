/**
 * 
 */
package com.galaxe.gst.dao;

import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.galaxe.gst.models.export.Report;
import com.galaxe.gst.models.login.QuestionAndAnswer;
import com.galaxe.gst.models.login.Roles;
import com.galaxe.gst.models.login.TestCategory;
import com.galaxe.gst.models.login.TestForm;
import com.galaxe.gst.models.login.TestQAnswer;
import com.galaxe.gst.models.login.TestQuestions;
import com.galaxe.gst.models.login.TestSubCategory;
import com.galaxe.gst.models.login.Users;

/**
 * @author naluru
 *
 */
@Repository("skillTestDao")
public class SkillTestDaoImpl implements SkillTestDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	Session session = null;
	Transaction tx = null;

	@SuppressWarnings("unchecked")
	@Override
	public List<TestForm> getTestList() {
		List<TestForm> testList = null;
		try{
			session=sessionFactory.openSession();
			testList = (List<TestForm>)session.createCriteria(TestForm.class).list();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			session.close();
		}
		return testList;
	}

	@Override
	public Users createUser(Users user) {
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.save(user);
			
		}catch(Exception e){
			tx.rollback();
			System.out.println(e.getMessage());
			user = null;
		}finally{
			tx.commit();
			session.close();
		}
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Roles> getRoles() {
		List<Roles> roles = null;
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			roles = session.createQuery("from Roles").list();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			session.close();
		}
		return roles;
	}

	@Override
	public String updateUser(Users user) {
		String result = "";
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.update(user);
			
			result = "SUCCESS";
		}catch(Exception e){
			tx.rollback();
			System.out.println(e.getMessage());
			result = "";
		}finally{
			tx.commit();
			session.close();
		}
		return result;
	}

	@Override
	public void saveCategories(List<TestCategory> categories) {
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			for(TestCategory cat :categories){
				session.save(cat);
			}
			
		}catch(Exception e){
			tx.rollback();
			System.out.println(e.getMessage());
		}finally{
			tx.commit();
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TestCategory> getCategories() {
		List<TestCategory> categoriesList = null;
		try{
			session = sessionFactory.openSession();
			categoriesList = session.createQuery("from TestCategory").list();
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			session.close();
		}
		return categoriesList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TestSubCategory> getSubCategories(int id) {
		List<TestSubCategory> subCategoriesList = null;
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			subCategoriesList = session.createQuery("FROM TestSubCategory ts WHERE ts.testCategory ="+ id).list();
			tx.commit();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			session.close();
		}
		return subCategoriesList;
	}

	@Override
	public String saveSubCategories(List<TestSubCategory> subCategoryList) {
		String result  = "";
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			for(TestSubCategory subCat : subCategoryList){
				session.save(subCat);
			}
			
			result = "SUCCESS";
		}catch(Exception e){
			tx.rollback();
			System.out.println(e.getMessage());
			result = null;
		}finally{
			tx.commit();
			session.close();
		}
		return result;
	}

	@Override
	public List<TestQuestions> createTest(TestForm testForm) {
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.save(testForm);
			
		}catch(Exception e){
			tx.rollback();
			System.out.println(e.getMessage());
		}finally{
			tx.commit();
			session.close();
		}
		return null;
	}

	@Override
	public String addQuestion(QuestionAndAnswer questionAnswer) {
		int questionId = 0;
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			questionId = (int) session.save(questionAnswer.getTestQuestion());
			TestQuestions question = new TestQuestions();
			question.setTestQId(questionId);
			for(TestQAnswer choice : questionAnswer.getChoices()){
				choice.setTestQId(question);
				session.save(choice);
			}
			
		}catch(Exception e){
			System.out.println(e.getMessage());
			tx.rollback();
		}finally{
			tx.commit();
			session.close();
		}
		return "";
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TestQuestions> getQuestions(int subCatId) {
		List<TestQuestions> questionsList = null;
		try{
			session = sessionFactory.openSession();
			/*tx = session.beginTransaction();*/
			
			questionsList = session.createQuery("FROM TestQuestions tq WHERE tq.testSubCategory ="+ subCatId).list();
			
			/*tx.commit();*/
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			session.close();
		}
		
		return questionsList;
	}


	@SuppressWarnings("unchecked")
	@Override
	public Users getUserByName(String user) {
		List<Users> list = null;
		try{
			session = sessionFactory.openSession();
			tx=session.beginTransaction();
			Criteria c1 = session.createCriteria(Users.class);
			c1.add(Restrictions.eq("username",user));
			 
			list = (List<Users>)c1.list();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			session.close();
		}
		return list.get(0);
	}

	@Override
	public Users getUser(String userName) {
		Session session=sessionFactory.openSession();
		Users user= (Users)session.get(Users.class, userName);
		return user;
	}
	
	
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Report> getDataFromDB(String sDate, String eDate, String criteria) {
		Query qry =null;
		
		if(criteria.equals("testName")){
			
			System.out.println("Inside criteria test name true!!");
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			Date sDate1 = null;
				try {
					sDate1 = sdf.parse(sDate);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("parsed sDate to:"+sDate1);
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			String parsedSDate1 = sdf1.format(sDate1);
			System.out.println("Formatted sDate to:"+parsedSDate1);
			
			Date eDate1 = null;
				try {
					eDate1 = sdf.parse(eDate);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("parsed eDate to:"+eDate1);
			String parsedEDate1 = sdf1.format(eDate1);
			System.out.println("Formatted sDate to:"+parsedSDate1);
			
		 	session = sessionFactory.openSession();
		 
		 	System.out.println(sDate + " " +eDate);
			qry = session.createQuery("FROM Report AS r WHERE r.testDate BETWEEN :stDate AND :edDate ");
			qry.setParameter("stDate", sDate1);
			qry.setParameter("edDate", eDate1);
		}
		else
			if(criteria.equals("category"))
		{
			System.out.println("Inside criterea equals category true!!");
			session = sessionFactory.openSession();
		 	System.out.println(sDate + " " +eDate);
			qry = session.createQuery("FROM Report AS r WHERE r.categoryName = :stDate AND r.subCategoryName = :edDate ");
			qry.setParameter("stDate", sDate);
			qry.setParameter("edDate", eDate);
		}
			ArrayList<Report> list = new ArrayList<Report>();
			list = (ArrayList<Report>) qry.list();
			System.out.println(list);    
			
			
			/*while (rset.next()) {
			    Customer cust = new Customer(rset.getInt("cust_id"),rset.getString("first_name"), rset.getString("last_name"), rset.getString("email"),rset.getDate("dob"),rset.getString("username"),rset.getString("password"));
			    list.add(cust);
			}*/
			return list;
	}

	@Override
	public void exportToExcel(String sDate, String eDate,String criteria,HttpServletResponse response){
			
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment; filename=MyExcel.xls");
		 	
			
			ArrayList<Report> list = getDataFromDB(sDate,eDate,criteria);
	        
	        HSSFWorkbook wb = new HSSFWorkbook();
	    	HSSFSheet sheet = wb.createSheet("data dump");
	    	int row = 0;
	    	HSSFFont font = wb.createFont();
	    	font.setBoldweight(Font.BOLDWEIGHT_BOLD);
	    	
	    	HSSFCellStyle style = wb.createCellStyle();
	    	style.setFont(font);
	    	   	Row rows = sheet.createRow(row++);
	            
	        	int cellNum;
	        	Cell cell;
	          	cellNum =0;
	        	
	        	cell = rows.createCell(cellNum);
	        	
	        	if(criteria.equalsIgnoreCase("TestName"))
	        	{
	        	cell.setCellValue("Test Start Date:"+sDate);
	        	sheet.addMergedRegion(new CellRangeAddress(rows.getRowNum(),rows.getRowNum(),0,255));
	        	
	        	rows = sheet.createRow(row++);	
	        	
	        	cell = rows.createCell(cellNum);
	        	cell.setCellValue("Test End Date:"+eDate);
	        	sheet.addMergedRegion(new CellRangeAddress(rows.getRowNum(),rows.getRowNum(),0,255));
	        	
	        	}
	        	else
	        		if(criteria.equalsIgnoreCase("category"))
	        		{
	        			cell.setCellValue("Category:"+sDate);
	    	        	sheet.addMergedRegion(new CellRangeAddress(rows.getRowNum(),rows.getRowNum(),0,255));
	    	        	
	    	        	rows = sheet.createRow(row++);	
	    	        	
	    	        	cell = rows.createCell(cellNum);
	    	        	cell.setCellValue("Sub Category:"+eDate);
	    	        	sheet.addMergedRegion(new CellRangeAddress(rows.getRowNum(),rows.getRowNum(),0,255));
	        			
	        		}
	        	rows = sheet.createRow(row++);
	        		
        		cell = rows.createCell(cellNum++);
        		cell.setCellStyle(style);
        		cell.setCellValue("First Name");
        		
        		cell = rows.createCell(cellNum++);
        		cell.setCellStyle(style);
        		cell.setCellValue("Last Name");
        		
        		cell = rows.createCell(cellNum++);
        		cell.setCellStyle(style);
        		cell.setCellValue("e Mail");
        		
        		cell = rows.createCell(cellNum++);
        		cell.setCellStyle(style);
        		cell.setCellValue("Contact No.");
        		
        		cell = rows.createCell(cellNum++);
        		cell.setCellStyle(style);
        		cell.setCellValue("Date of Birth");
        		
        		cell = rows.createCell(cellNum++);
        		cell.setCellStyle(style);
        		cell.setCellValue("Score");
	        	
	        	for (Report s : list) {
	        		cellNum =0;
	        		
	        		rows = sheet.createRow(row++);
	        		
	            	cell = rows.createCell(cellNum++);         	
	            	cell.setCellValue(s.getFirstName());
	            	
	            	cell = rows.createCell(cellNum++);
	            	cell.setCellValue(s.getLastName());
	            	
	            	cell = rows.createCell(cellNum++);
	            	cell.setCellValue(s.getEmail());
	            	             	
	            		            	
	            	cell = rows.createCell(cellNum++);
	            	cell.setCellValue(s.getContact());
	            	
	            	
	            	cell = rows.createCell(cellNum++);
	            	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	            	
	            	cell.setCellValue(sdf.format(s.getDob()));
	            	
	            	
	            	cell = rows.createCell(cellNum++);
	            	cell.setCellValue(s.getScore());

	        	}	
	        	
	        	/*FileOutputStream fos = null;
	        	try{
	        		fos =response.getOutputStream();
	        		wb.write(fos);
	        		response.getWriter().write(wb.toString());
	        		fos = new FileOutputStream("D:\\abc.xls");
	        		wb.write(fos);
	        		fos.close();
	        		os = response.getOutputStream();
	        		System.out.println("output stream :" + os);
	        		wb.write(os);
	        		os.flush();
	        		os.close();
	        		System.out.println("Data imported successfully");
	        	}
	            catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
	        	finally{
	        		
	        		try {
						fos.close();
						return list;
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	        	}*/
	        	
	        	try{
	        		FileOutputStream fos = new FileOutputStream("D:\\abc12.xls");
	        		wb.write(fos);
	        		fos.close();
	        		System.out.println("Data imported successfully");
	        	}
	            catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
	        	finally{
	        	}
	}

	@Override
	public List<String> fetchCategory() {
		// TODO Auto-generated method stub
		
		System.out.println("inside dao Impl!!!");
		session = sessionFactory.openSession();
		Query qry = session.createQuery("SELECT DISTINCT r.categoryName FROM Report AS r");
		List<String> category = (ArrayList<String>)qry.list();	
		System.out.println("Dao impl list:"+category);
		return category;
	}

	@Override
	public List<String> fetchSubCategory(String category) {
		// TODO Auto-generated method stub
		session = sessionFactory.openSession();
		Query qry = session.createQuery("SELECT r.subCategoryName FROM Report AS r WHERE r.categoryName = :categ");
		qry.setParameter("categ", category);
		List<String> subCategory = (ArrayList<String>)qry.list();	
		return subCategory;
	}

}
