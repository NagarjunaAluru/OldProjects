/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: RequestDetailsSectionDAOTest.java
 * Purpose: RequestDetailsSectionDAOTest used for the all the request section DAO implementations
 */
package com.ge.aloc.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.model.Attachment;
import com.ge.aloc.model.AttachmentPermission;
import com.ge.aloc.model.Format;
import com.ge.aloc.model.MsgHeader;
import com.ge.aloc.model.RequestDetails;
import com.hydus.hwf.bw.service.IServiceClient;
import com.hydus.hwf.context.UserContext;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author narasimhulu.b
 *
 */
public class RequestDetailsSectionDAOTest {
	
	private static IServiceClient serviceClient;
	private static RequestDetailsSectionDAO requestDetailsSectionDAO;
	private static RequestDetails requestDetails;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		serviceClient = DAOConnectionHelper.getServiceClient();
		requestDetailsSectionDAO = new RequestDetailsSectionDAO();
		requestDetailsSectionDAO.setServiceClient(serviceClient);				
		requestDetails = new RequestDetails();
	}
	
	
	
		/**
	 * Test method for {@link com.ge.aloc.dao.impl.RequestDetailsSectionDAO#setMsgHeader(com.ge.aloc.model.RequestDetails, com.ge.aloc.OpCode)}.
	 */
	@Test
	public void testSetMsgHeader() {
		fail("Not yet implemented");
	}
	
	/**
	 * 
	 */
	@Test
	public void testSaveFormatSection()
	{
		Format format = new Format();
		format.setComments("This is format Section");
		format.setFormatType("Modified Standard Format");
		format.setFormatTypeId("2");		
		List<Attachment> attachmentList = new ArrayList<Attachment>();				
		attachmentList.add(new Attachment());
		format.setAttachments(attachmentList);
		requestDetails.setFormat(format);
		try {
			requestDetailsSectionDAO.saveFormat(requestDetails);
		} catch (HWFServiceException e) {
			assertNotNull(e);
			
			assertEquals("", e.getMessage());//TODO verify the error message.
		}			
	}
	
	@Test
	public void testAttachmentsSection()
	{
		AttachmentPermission permissions  = new AttachmentPermission();
		permissions.setPermissionId("1");
		permissions.setPermissionName("Treasury");
		permissions.setPermissionId("12");
		permissions.setPermissionName("Business");
		List<AttachmentPermission> permissionList = new ArrayList<AttachmentPermission>();		
		permissionList.add(permissions);		
		Attachment attachment = new Attachment();
		attachment.setAttachmentName("hydusurls.txt");
		attachment.setAttachmentType("Other");
		attachment.setAttachmentType("2");
		attachment.setAttachmentPermissions(permissionList);
		List<Attachment> attachmentList = new ArrayList<Attachment>();
		attachmentList.add(attachment);		
		requestDetails.setAttachments(attachmentList);
		try {
			requestDetailsSectionDAO.saveAttachments(requestDetails);
		} catch (HWFServiceException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		}		
	}
	
	
	
	/**
	 * method to test get the full audit and action log data
	 * Test method for {@link com.ge.aloc.dao.impl.RequestDetailsSectionDAO#getFullAuditandActionLog(com.ge.aloc.model.RequestDetails)}.
	 */
	@Test
	public void testGetFullAuditandActionLog() {
		requestDetails = new RequestDetails();
		setUserContextDetails();
	    String logType="action";
	    RequestDetails requestDetail=new RequestDetails();
	    requestDetail.setRequestId(new BigInteger("7155"));
	    MsgHeader msgHeader=new MsgHeader();
		  msgHeader.setAuditCreator("999911248");
		try {
			 requestDetails=requestDetailsSectionDAO.getFullAuditandActionLog(logType,requestDetails);
			assertNotNull(requestDetails);
		}catch (HWFServiceException e) {
			fail("Error while save Requestor Mailing Address section" + e.getMessage());
		}
	}
	
	 /**
	   * Method to set the user context details 
	 */
	  private void setUserContextDetails()
	  {
		  List<String> rolesList = new ArrayList<String>();
		  rolesList.add("Approver");
		  UserContext.getContext().getuserDetails().setUserId("999911177");
		  UserContext.getContext().getuserDetails().setLastName("Approver_999911177 ");
		  UserContext.getContext().getuserDetails().setFirstName("Test_999911177");
		  UserContext.getContext().getuserDetails().setRoles(rolesList);
	  }

}
