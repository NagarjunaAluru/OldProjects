/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: RequestDetailsDAOTest.java
 * Purpose: RequestDetailsDAOTest used for the all the request DAO test cases
 */package com.ge.aloc.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.math.BigInteger;

import org.junit.BeforeClass;
import org.junit.Test;

import com.ge.aloc.ActionType;
import com.ge.aloc.InstrumentType;
import com.ge.aloc.OpCode;
import com.ge.aloc.model.MsgHeader;
import com.ge.aloc.model.RequestDetails;
import com.ge.aloc.util.ALOCCommonHelper;
import com.hydus.hwf.bw.service.IServiceClient;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author madhusudhan.gosula
 *
 */
public class RequestDetailsDAOTest {
	private static IServiceClient serviceClient;
	private static RequestDetailsDAO requestDetailsDAO;
	private static RequestDetails requestDetails;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		serviceClient = DAOConnectionHelper.getServiceClient();
		requestDetailsDAO = new RequestDetailsDAO();
		requestDetailsDAO.setServiceClient(serviceClient);
		requestDetails = new RequestDetails();
	}


	/**
	 * Test method for {@link com.ge.aloc.dao.impl.RequestDetailsDAO#performSectionOperation(com.ge.aloc.model.RequestDetails, com.ge.aloc.OpCode)}.
	 */
	@Test
	public final void testPerformSectionOperation() {
		OpCode sectionOperation = OpCode.SAVE;//TODO Each section opcode need to be passed.
		try {
			requestDetailsDAO.performSectionOperation(requestDetails, sectionOperation);
		} catch (HWFServiceException e) {
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.dao.impl.RequestDetailsDAO#createNewRequest(com.ge.aloc.model.RequestDetails, com.ge.aloc.OpCode)}.
	 */
	@Test
	public final void testCreateNewRequest() {
		String instrumentTypeID = null;
		String instrumentTypeName = null;
		assertNull(instrumentTypeID);
		assertNull(instrumentTypeName);
		//Bank Guarantee test case.
		instrumentTypeID = String.valueOf(InstrumentType.BANK_GUARANTEE.getId());
		instrumentTypeName = InstrumentType.BANK_GUARANTEE.getName();
		assertNotNull(instrumentTypeID);
		assertNotNull(instrumentTypeName);
		assertEquals("1", instrumentTypeID);
		assertEquals("Bank Guarantee", instrumentTypeName);
		
		assertNotNull(requestDetails);
		assertNull(requestDetails.getInstrumentTypeId());
		assertNull(requestDetails.getInstrumentType());
		assertNull(requestDetails.getSiteId());
		assertNull(requestDetails.getSiteName());

		requestDetails.setInstrumentTypeId(new BigInteger(instrumentTypeID));
		requestDetails.setInstrumentType(instrumentTypeName);
		requestDetails.setSiteId(new BigInteger("1"));
		requestDetails.setSiteName("Test");
		assertEquals(new BigInteger("1"), requestDetails.getInstrumentTypeId());
		assertEquals(instrumentTypeName, requestDetails.getInstrumentType());
		assertEquals(new BigInteger("1"), requestDetails.getSiteId());
		assertEquals("Test", requestDetails.getSiteName());
		
		try {
			requestDetails = requestDetailsDAO.createNewRequest(requestDetails);
			assertNotNull(requestDetails);
			assertNotNull(requestDetails.getComments());
			assertEquals("service comments", requestDetails.getComments());
			
		} catch (HWFServiceException e) {
			fail("Error while create the request");
		}
		
		//SLOC test cases.
		instrumentTypeID = String.valueOf(InstrumentType.LOC.getId());
		instrumentTypeName = InstrumentType.LOC.getName();
		assertNotNull(instrumentTypeID);
		assertNotNull(instrumentTypeName);
		assertEquals("2", instrumentTypeID);
		assertEquals("Standby Letter Of Credit", instrumentTypeName);
		
		assertNotNull(requestDetails);
		assertNull(requestDetails.getInstrumentTypeId());
		assertNull(requestDetails.getInstrumentType());
		assertNull(requestDetails.getSiteId());
		assertNull(requestDetails.getSiteName());

		requestDetails.setInstrumentTypeId(new BigInteger(instrumentTypeID));
		requestDetails.setInstrumentType(instrumentTypeName);
		requestDetails.setSiteId(new BigInteger("1"));
		requestDetails.setSiteName("Test");
		assertEquals(new BigInteger("1"), requestDetails.getInstrumentTypeId());
		assertEquals(instrumentTypeName, requestDetails.getInstrumentType());
		assertEquals(new BigInteger("1"), requestDetails.getSiteId());
		assertEquals("Test", requestDetails.getSiteName());
		
		try {
			requestDetails = requestDetailsDAO.createNewRequest(requestDetails);
			assertNotNull(requestDetails);
			assertNotNull(requestDetails.getComments());
			assertEquals("service comments", requestDetails.getComments());
			
		} catch (HWFServiceException e) {
			fail("Error while create the request");
		}
	
		//DLOC test cases.
		instrumentTypeID = String.valueOf(InstrumentType.DOCUMENT_LOC.getId());
		instrumentTypeName = InstrumentType.DOCUMENT_LOC.getName();
		assertNotNull(instrumentTypeID);
		assertNotNull(instrumentTypeName);
		assertEquals("4", instrumentTypeID);
		assertEquals("Documentary Letter Of Credit Confirmation", instrumentTypeName);
		
		assertNotNull(requestDetails);
		assertNull(requestDetails.getInstrumentTypeId());
		assertNull(requestDetails.getInstrumentType());
		assertNull(requestDetails.getSiteId());
		assertNull(requestDetails.getSiteName());

		requestDetails.setInstrumentTypeId(new BigInteger(instrumentTypeID));
		requestDetails.setInstrumentType(instrumentTypeName);
		requestDetails.setSiteId(new BigInteger("1"));
		requestDetails.setSiteName("Test");
		assertEquals(new BigInteger("1"), requestDetails.getInstrumentTypeId());
		assertEquals(instrumentTypeName, requestDetails.getInstrumentType());
		assertEquals(new BigInteger("1"), requestDetails.getSiteId());
		assertEquals("Test", requestDetails.getSiteName());
		
		try {
			requestDetails = requestDetailsDAO.createNewRequest(requestDetails);
			assertNotNull(requestDetails);
			assertNotNull(requestDetails.getComments());
			assertEquals("service comments", requestDetails.getComments());
			
		} catch (HWFServiceException e) {
			fail("Error while create the request");
		}

		//Surety Bond Test cases
		instrumentTypeID = String.valueOf(InstrumentType.SURETY_BOND.getId());
		instrumentTypeName = InstrumentType.SURETY_BOND.getName();
		assertNotNull(instrumentTypeID);
		assertNotNull(instrumentTypeName);
		assertEquals("3", instrumentTypeID);
		assertEquals("Surety Bond", instrumentTypeName);
		
		assertNotNull(requestDetails);
		assertNull(requestDetails.getInstrumentTypeId());
		assertNull(requestDetails.getInstrumentType());
		assertNull(requestDetails.getSiteId());
		assertNull(requestDetails.getSiteName());

		requestDetails.setInstrumentTypeId(new BigInteger(instrumentTypeID));
		requestDetails.setInstrumentType(instrumentTypeName);
		requestDetails.setSiteId(new BigInteger("1"));
		requestDetails.setSiteName("Test");
		assertEquals(new BigInteger("1"), requestDetails.getInstrumentTypeId());
		assertEquals(instrumentTypeName, requestDetails.getInstrumentType());
		assertEquals(new BigInteger("1"), requestDetails.getSiteId());
		assertEquals("Test", requestDetails.getSiteName());
		
		try {
			requestDetails = requestDetailsDAO.createNewRequest(requestDetails);
			assertNotNull(requestDetails);
			assertNotNull(requestDetails.getComments());
			assertEquals("service comments", requestDetails.getComments());
			
		} catch (HWFServiceException e) {
			fail("Error while create the request");
		}
		
		//pass invalid data and execute the test case u should get error -ve test case.
		try {
			requestDetails = requestDetailsDAO.createNewRequest(requestDetails);//OPcode null			
		} catch (HWFServiceException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		}
		try {
			requestDetails = requestDetailsDAO.createNewRequest(null);//requetsDeatils and OPcode objects are null.		
		} catch (HWFServiceException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		}
		try {
			requestDetails.setInstrumentType("INVALID");
			requestDetails.setInstrumentTypeId(new BigInteger("99"));
			requestDetails = requestDetailsDAO.createNewRequest(requestDetails);		
		} catch (HWFServiceException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		}

	}

	/**
	 * Test method for {@link com.ge.aloc.dao.impl.RequestDetailsDAO#setMsgHeader(com.ge.aloc.model.RequestDetails, com.ge.aloc.OpCode)}.
	 */
	@Test
	public final void testSetMsgHeader() {
		assertNull(requestDetails.getMsgHeader());
		ALOCCommonHelper.setMsgHeader(requestDetails, OpCode.GETREQUEST);
		MsgHeader msgHeader = requestDetails.getMsgHeader();
		assertNotNull(msgHeader);
		assertEquals(OpCode.GETREQUEST, msgHeader.getOpcode());
		//TODO verify other details like user information.
	}

	/**
	 * Test method for {@link com.ge.aloc.dao.impl.RequestDetailsDAO#getRequest(java.math.BigInteger)}.
	 */
	@Test
	public final void testGetRequest() {
		try {
			requestDetails = requestDetailsDAO.getRequest(new BigInteger("101")); // request ID should be valid
			assertNotNull(requestDetails);
			//TODO more assertions if you know the fetched request details.
		} catch (HWFServiceException e) {
			fail("Error while fetch the request");
		}
		try {
			requestDetails = requestDetailsDAO.getRequest(new BigInteger("000")); // request ID should be invalid
		} catch (HWFServiceException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		}
	}

	/**
	 * Test method for {@link com.ge.aloc.dao.impl.RequestDetailsDAO#saveandSubmit(com.ge.aloc.model.RequestDetails, com.ge.aloc.ActionType)}.
	 */
	@Test
	public final void testSaveandSubmit() {
		ActionType actionType = ActionType.SAVE;
		try {
			// Mock the requestDetails object with some mock data.
			requestDetailsDAO.saveandSubmit(requestDetails, actionType);
		} catch (HWFServiceException e) {
			fail("Error while save the request");
		}
		actionType = ActionType.SAVE_AS_MODEL;
		try {
			// Mock the requestDetails object with some mock data.
			requestDetailsDAO.saveandSubmit(requestDetails, actionType);
		} catch (HWFServiceException e) {
			fail("Error while save the request");
		}
		actionType = ActionType.SUBMIT;
		try {
			// Mock the requestDetails object with some mock data.
			requestDetailsDAO.saveandSubmit(requestDetails, actionType);
		} catch (HWFServiceException e) {
			fail("Error while save the request");
		}
		actionType = null;
		try {
			// Mock the requestDetails object with some mock data.
			requestDetailsDAO.saveandSubmit(requestDetails, actionType);
		} catch (HWFServiceException e) {
			assertNotNull(e);
			assertEquals("", e.getMessage());//TODO verify the error message.
		}
	}

}
