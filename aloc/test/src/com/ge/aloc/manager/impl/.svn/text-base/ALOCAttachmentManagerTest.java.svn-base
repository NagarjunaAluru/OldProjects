/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ALOCAttachmentManagerTest.java
 * Purpose: This class test the attachments functionality of entire application
 * 
 */
package com.ge.aloc.manager.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import mockit.Mock;
import mockit.MockClass;
import mockit.Mocked;
import mockit.Mockit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.AttachmentType;
import com.ge.aloc.exception.ALOCAttachmentException;
import com.ge.aloc.exception.ALOCException;
import com.ge.aloc.model.Attachment;
import com.ge.aloc.model.AttachmentPermission;
import com.ge.aloc.model.RequestDetails;

/**
 * @author rajeswari.guthi
 *
 */

	public class ALOCAttachmentManagerTest {

	private ALOCAttachmentManager attachmentManager;
	private File file ;
	private AttachmentType type ;
	
	@Mocked
	Attachment attachment;
	AttachmentType attachmentType;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		attachmentManager = new ALOCAttachmentManager();
		file =new File("D://ALOC//hydusurls.txt");		
		type = AttachmentType.OTHER;
		Mockit.setUpMocks(MockAttachment.class,MockAttachmentType.class); 
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddAttachmentFileStringAttachmentTypeAttachment() {
		AttachmentPermission permissions  = new AttachmentPermission();
		permissions.setPermissionId("1");
		permissions.setPermissionName("Treasury");
		permissions.setPermissionId("12");
		permissions.setPermissionName("Business");
		List<AttachmentPermission> permissionList = new ArrayList<AttachmentPermission>();		
		permissionList.add(permissions);			
		Attachment atmt = new Attachment();
		atmt.setAttachmentPermissions(permissionList);
		try {			
			  attachmentManager.addAttachment(file,file.getName(),type,atmt );
		} catch (ALOCAttachmentException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		} catch (ALOCException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		}				
	}

	@Test
	public void testAddAttachmentStringStringAttachmentType() {		
		String content= "This is attachment functionality.";
		try {			
			  attachmentManager.addAttachment(content,file.getName(),type);
		} catch (ALOCAttachmentException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		} catch (ALOCException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		}
	}

	@Test
	public void testSaveAttachment() {
		AttachmentPermission permissions  = new AttachmentPermission();
		permissions.setPermissionId("1");
		permissions.setPermissionName("Treasury");
		permissions.setPermissionId("12");
		permissions.setPermissionName("Business");
		List<AttachmentPermission> permissionList = new ArrayList<AttachmentPermission>();		
		permissionList.add(permissions);			
		Attachment atmt = new Attachment();
		atmt.setAttachmentPermissions(permissionList);
		String content= "This is attachment functionality.";
		try {			
			  attachmentManager.saveAttachment(content, file.getName(), type, atmt);
		} catch (ALOCAttachmentException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		} catch (ALOCException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		}				
	}

	@Test
	public void testAddFormatAttachment() {
		fail("Not yet implemented");
	}

	@Test
	public void testSaveFormatAttachment() {
		AttachmentPermission permissions  = new AttachmentPermission();
		permissions.setPermissionId("1");
		permissions.setPermissionName("Treasury");
		permissions.setPermissionId("12");
		permissions.setPermissionName("Business");
		List<AttachmentPermission> permissionList = new ArrayList<AttachmentPermission>();		
		permissionList.add(permissions);			
		Attachment atmt = new Attachment();
		atmt.setAttachmentPermissions(permissionList);
		String content= "This is attachment functionality.";
		try {			
			  attachmentManager.saveFormatAttachment(content, type, atmt);
		} catch (ALOCAttachmentException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		} catch (ALOCException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		}				
	}

	@Test
	public void testDownloadAttachmentOutputStreamAttachment() {
		try {
				OutputStream outputStream = new ByteArrayOutputStream();
				Attachment atmt = new Attachment();
				attachmentManager.downloadAttachment(outputStream, atmt);
		} catch (ALOCAttachmentException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		} catch (ALOCException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		}		
		
	}

	@Test
	public void testDownloadAttachmentOutputStreamString() {
		try {
			    String repFileId = "56565656565";
				OutputStream outputStream = new ByteArrayOutputStream();
				Attachment atmt = new Attachment();
				atmt = attachmentManager.downloadAttachment(outputStream, repFileId);
				assertNotNull(atmt);
			} catch (ALOCAttachmentException e) {
				assertNotNull(e);
				assertEquals("", e.getMessage());//TODO verify the error message.
			} catch (ALOCException e) {
				assertNotNull(e);
				assertEquals("", e.getMessage());//TODO verify the error message.
		}		
	}

	@Test
	public void testDeleteAttachment() {
		try {
			AttachmentPermission permissions  = new AttachmentPermission();
			permissions.setPermissionId("1");
			permissions.setPermissionName("Treasury");
			permissions.setPermissionId("12");
			permissions.setPermissionName("Business");
			List<AttachmentPermission> permissionList = new ArrayList<AttachmentPermission>();		
			permissionList.add(permissions);			
			Attachment atmt = new Attachment();
			atmt.setAttachmentPermissions(permissionList);			
			attachmentManager.delete(atmt);
		} catch (ALOCAttachmentException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		} catch (ALOCException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
	   }		
	}

	@Test
	public void testDeleteString() {
		try {
			 String repFileId = "56565656565";		
			attachmentManager.delete(repFileId);
		} catch (ALOCAttachmentException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		} catch (ALOCException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
	   }		
	}

	@Test
	public void testDeleteAllAttachments() {
		
	}

	@Test
	public void testDeleteListOfAttachment() {		
		AttachmentPermission permissions  = new AttachmentPermission();
		permissions.setPermissionId("1");
		permissions.setPermissionName("Treasury");
		permissions.setPermissionId("12");
		permissions.setPermissionName("Business");
		List<AttachmentPermission> permissionList = new ArrayList<AttachmentPermission>();		
		permissionList.add(permissions);			
		Attachment atmt = new Attachment();
		atmt.setAttachmentPermissions(permissionList);
		List<Attachment> atmtList = new ArrayList<Attachment>();
		atmtList.add(atmt);
		try {
			attachmentManager.delete(atmtList);
		} catch (ALOCException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		}
		
	}

	@Test
	public void testUpdateMetadataForAllAttachments() {
	
	}

	@Test
	public void testValidateInput() {
		try {
			attachmentManager.validateInput(file,attachment.getAttachmentName(),new RequestDetails());
		} catch (ALOCAttachmentException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		} 
		
	}

	@Test
	public void testValidateExtension() {
		int extStartIndex = file.getName().lastIndexOf('.');
		String ext = file.getName().substring(extStartIndex);
		try {
			attachmentManager.validateExtension(file, ext,new RequestDetails());
		} catch (ALOCAttachmentException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		} 
	}

	@MockClass(realClass = AttachmentType.class)
	public static class MockAttachmentType  {
		@SuppressWarnings("unused")
		private int id = 2;
		@SuppressWarnings("unused")
		private String name ="Other";
		
		MockAttachmentType(int id,String formatName) {
			this.id= id;
			this.name= formatName;
		}   
		
		@Mock     
		public String getFileName()      
		{
			return "hydusurls.txt";
		}
		
		@Mock     
		public String getFileContentType()      
		{
			return "text/plain";
		}
		
		@Mock
		public String getName()
		{
			return "Other";
		}
	}
	
	@MockClass(realClass = com.ge.aloc.model.Attachment.class)
	public static class MockAttachment  {
		
		@Mock
	    public BigInteger getAttachmentId() {
	        return new BigInteger("12");
	    }
	  
		@Mock
	    public String getAttachmentName() {
	        return "hydusurls.txt";
	    }

		@Mock
	    public BigInteger getAttachmentTypeId() {
	        return new BigInteger("2");
	    }
	  
		@Mock
	    public String getGeLibraryReference() {
	        return "";
	    }

	   
		@Mock
	    public String getAttachedBySSOID() {
	        return "999928606";
	    }

	   
		@Mock
	    public String getGeFileId() {
	        return "2";
	    }

	 
		@Mock
		public String getGeFolderId() {
	        return "23";
	    }
		
		@Mock
	    public String getDeleteFlag() {
	        return "false";
	    }

		@Mock
		public String getComments() {
	        return "comments..";
	    }
		@Mock
	    public BigInteger getFormatId() {
	        return new BigInteger("0");
	    }
	  
		
	    public String getFormatName() {
	        return null;
	    }
	    @Mock
	    public List<AttachmentPermission> getAttachmentPermissions() {	       
	        return new ArrayList<AttachmentPermission>();
	    }
	}
	
	
	@MockClass(realClass =com.hydus.hwf.context.UserContext.class)
	public static class MockALOCContext {
		
		@Mock
	    public BigInteger getAttachmentId() {
	        return new BigInteger("12");
	    }
	  
		@Mock
	    public String getAttachmentName() {
	        return "hydusurls.txt";
	    }

		@Mock
	    public BigInteger getAttachmentTypeId() {
	        return new BigInteger("2");
	    }
	  
		@Mock
	    public String getGeLibraryReference() {
	        return "";
	    }

	   
		@Mock
	    public String getAttachedBySSOID() {
	        return "999928606";
	    }

	   
		@Mock
	    public String getGeFileId() {
	        return "2";
	    }

	 
		@Mock
		public String getGeFolderId() {
	        return "23";
	    }
		
		@Mock
	    public String getDeleteFlag() {
	        return "false";
	    }

		@Mock
		public String getComments() {
	        return "comments..";
	    }
		@Mock
	    public BigInteger getFormatId() {
	        return new BigInteger("0");
	    }
	  
	    public String getFormatName() {
	        return null;
	    }
	    @Mock
	    public List<AttachmentPermission> getAttachmentPermissions() {	       
	        return new ArrayList<AttachmentPermission>();
	    }
	}	
}
