/**
 * 
 */
package com.ge.aloc.exception;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author madhusudhan.gosula
 *
 */
public class ALOCAttachmentExceptionTest {
	ALOCAttachmentException atmtException;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		atmtException= new ALOCAttachmentException(ALOCAttachmentException.EC_INVALID_FILENAME);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.ge.aloc.exception.ALOCAttachmentException#ALOCAttachmentException(java.lang.String)}.
	 */
	@Test
	public final void testALOCAttachmentExceptionString() {
		
	}

	/**
	 * Test method for {@link com.ge.aloc.exception.ALOCAttachmentException#ALOCAttachmentException(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testALOCAttachmentExceptionStringString() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.ge.aloc.exception.ALOCAttachmentException#ALOCAttachmentException(java.lang.String, java.lang.Throwable)}.
	 */
	@Test
	public final void testALOCAttachmentExceptionStringThrowable() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.ge.aloc.exception.ALOCAttachmentException#ALOCAttachmentException(java.lang.String, java.lang.String, java.lang.Throwable)}.
	 */
	@Test
	public final void testALOCAttachmentExceptionStringStringThrowable() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.ge.aloc.exception.ALOCAttachmentException#getAttachment()}.
	 */
	@Test
	public final void testGetAttachment() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.ge.aloc.exception.ALOCAttachmentException#setAttachment(com.ge.aloc.model.Attachment)}.
	 */
	@Test
	public final void testSetAttachment() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.ge.aloc.exception.ALOCAttachmentException#getRequestId()}.
	 */
	@Test
	public final void testGetRequestId() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.ge.aloc.exception.ALOCAttachmentException#setRequestId(java.math.BigInteger)}.
	 */
	@Test
	public final void testSetRequestId() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.ge.aloc.exception.ALOCAttachmentException#getFileExtensions()}.
	 */
	@Test
	public final void testGetFileExtensions() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.ge.aloc.exception.ALOCAttachmentException#setFileExtensions(java.lang.String[])}.
	 */
	@Test
	public final void testSetFileExtensions() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.ge.aloc.exception.ALOCAttachmentException#getMessage()}.
	 */
	@Test
	public final void testGetMessage() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.ge.aloc.exception.ALOCAttachmentException#getLocalizedMessage()}.
	 */
	@Test
	public final void testGetLocalizedMessage() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.ge.aloc.exception.ALOCAttachmentException#getMessageParams()}.
	 */
	@Test
	public final void testGetMessageParams() {
		atmtException.getMessageParams();
	}

}
