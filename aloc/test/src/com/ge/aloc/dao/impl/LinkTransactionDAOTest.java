/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: LinkTransactionDAOTest.java
 * Purpose: This class test the linking functionality of request
 * 
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

import com.ge.aloc.model.Inbox;
import com.ge.aloc.model.LinkDetails;
import com.ge.aloc.model.RequestDetails;
import com.ge.aloc.model.RequestDetailsCollectionType;
import com.hydus.hwf.bw.service.IServiceClient;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 *  @author rajeswari.guthi
 *
 */
public class LinkTransactionDAOTest {
	private static IServiceClient serviceClient;
	private static LinkTransactionDAO linkTransactionDAO;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		serviceClient = DAOConnectionHelper.getServiceClient();
		linkTransactionDAO = new LinkTransactionDAO();
		linkTransactionDAO.setServiceClient(serviceClient);
	}

	/**
	 * Test method for {@link com.ge.aloc.dao.impl.LinkTransactionDAO#loadLinkTransactions(com.ge.aloc.model.Inbox)}.
	 */
	@Test
	public final void testLoadLinkTransactions() {
		 try {			  
			 	String requestId = "4971";
			 	Inbox inbox = new Inbox();		
				RequestDetailsCollectionType requestCoolection = new RequestDetailsCollectionType();
				List<RequestDetails> requestDetList = new ArrayList<RequestDetails>();
				RequestDetails requestDetails = new RequestDetails();
				if(requestId!=null){
					requestDetails.setRequestId(new BigInteger(requestId));
				}				
				requestDetList.add(requestDetails);		
				requestCoolection.setRequestDetails(requestDetList);
				inbox.setBundle(requestCoolection);		
				linkTransactionDAO.loadLinkTransactions(inbox).getRequestDetails();
			} catch (HWFServiceException e) {
				assertNotNull(e);
				assertEquals("", e.getMessage());//TODO verify the error message.
			}
		
	}

	/**
	 * Test method for {@link com.ge.aloc.dao.impl.LinkTransactionDAO#linkTransaction(com.ge.aloc.model.Inbox)}.
	 */
	@Test
	public final void testLinkTransaction() {	
		 try {
			 	String requestId1 = "4951";
			 	String requestId2 = "4953";
			 	Inbox inbox = new Inbox();
				RequestDetailsCollectionType requestCoolection = new RequestDetailsCollectionType();		
				List<RequestDetails> requestDetList = new ArrayList<RequestDetails>();
				RequestDetails requestDetails = new RequestDetails();	
				LinkDetails linkedDetais = new LinkDetails();		
				if(requestId1!= null){
					linkedDetais.setLinkRequestId(new BigInteger(requestId1));			
				}		
				if(requestId2!= null){
					linkedDetais.setLinkedRequestId(new BigInteger(requestId2));
				}				
				requestDetails.setLinkDetails(linkedDetais);
				requestDetList.add(requestDetails);
				requestCoolection.setRequestDetails(requestDetList);
				inbox.setBundle(requestCoolection);		
				inbox = linkTransactionDAO.linkTransaction(inbox);
			} catch (HWFServiceException e) {
				assertNotNull(e);
				assertEquals("", e.getMessage());//TODO verify the error message.
			}
	}

	/**
	 * Test method for {@link com.ge.aloc.dao.impl.LinkTransactionDAO#unLinkTransaction(com.ge.aloc.model.Inbox)}.
	 */
	@Test
	public final void testUnLinkTransaction() {
		 try {
			 	String linkId="64";
			 	String requestId="4791";
			 	Inbox inbox = new Inbox();				
				RequestDetailsCollectionType requestCoolection = new RequestDetailsCollectionType();
				List<RequestDetails> requestDetList = new ArrayList<RequestDetails>();
				RequestDetails requestDetails = new RequestDetails();
				LinkDetails linkedDetais = new LinkDetails();	
				if(linkId!=null){
					linkedDetais.setLinkId(new BigInteger(linkId));
				}
				if(requestId!=null){
					linkedDetais.setLinkedRequestId(new BigInteger(requestId));
				}
					
				requestDetails.setLinkDetails(linkedDetais);
				requestDetList.add(requestDetails);		
				requestCoolection.setRequestDetails(requestDetList);
				inbox.setBundle(requestCoolection);
				inbox = linkTransactionDAO.linkTransaction(inbox);
			} catch (HWFServiceException e) {
				assertNotNull(e);
				assertEquals("", e.getMessage());//TODO verify the error message.
			}
		
	}

	/**
	 * Test method for {@link com.ge.aloc.dao.impl.LinkTransactionDAO#trasactionsAdvanceSearch()}.
	 */
	@Test
	public final void testTrasactionsAdvanceSearch() {
		fail("Not yet implemented"); // TODO need to implement the search functionality
	}
}
