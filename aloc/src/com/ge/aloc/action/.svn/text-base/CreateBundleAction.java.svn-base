/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: CreateBundleAction.java
 * Purpose: CreateBundleAction class used for add or remove or create functionality of the Bundle.
 *
 */
package com.ge.aloc.action;

import static com.ge.aloc.constants.ALOCConstants.AMP_BUNDLEID;
import static com.ge.aloc.constants.ALOCConstants.BUNDLEID;
import static com.ge.aloc.constants.ALOCConstants.REQUESTID;
import static com.ge.aloc.constants.ALOCConstants.SUCCESSMODAL;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.exception.ALOCException;
import com.ge.aloc.manager.ICreateBundleManager;
import com.ge.aloc.model.RequestDetails;
import com.hydus.hwf.exceptions.HWFApplicationException;
import com.hydus.hwf.exceptions.HWFServiceException;
import com.hydus.hwf.exceptions.HWFServiceStubException;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author rajeswari.guthi
 *
 */
public class CreateBundleAction extends ActionSupport {

	private static final long serialVersionUID = 8200864284381069572L;

	private Map<BigInteger, Set<RequestDetails>> bundleIDToRequestsMap; 		
	private ICreateBundleManager createBundleManager;	
	private String bundleRequestId;
	private String bundleId;
	private RequestDetails requestDetails;
	private List<RequestDetails> requestDetailsList;


	/**
	 * This method is used to add or create Bundle.
	 * @return
	 * @throws HWFServiceException 
	 */
	public String createBundle() throws HWFServiceException,ALOCException{
		try{
			HttpServletRequest request = ServletActionContext.getRequest();
			String requestId = (String)request.getParameter(REQUESTID);
			String bundleId = (String)request.getParameter(AMP_BUNDLEID);	
			requestDetails = createBundleManager.addOrCreateBundle(requestId,bundleId);
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute(ALOCConstants.SUCCESSMSG, (requestDetails.getComments()!=null)?requestDetails.getComments():ALOCConstants.EMPTY_STRING);
		}catch(HWFServiceException hse){						
			addActionMessage(hse.getReason());
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute(ALOCConstants.ERROR, hse.getReason());
		}
		return SUCCESS;
	}

	/**
	 * This method is used to load bundle list 
	 * @return
	 * @throws HWFServiceException
	 * @throws ALOCException  	 */
	public String loadBundleList() throws HWFServiceException, ALOCException{
		try{
			HttpServletRequest request = ServletActionContext.getRequest();
			String requestId = (String)request.getParameter(REQUESTID);
			this.bundleRequestId = requestId;	
			List<RequestDetails> requestDetailsList = createBundleManager.loadBundleList(requestId);	  	  
			Map<BigInteger, Set<RequestDetails>> bundleIdRequestsMap = new HashMap<BigInteger, Set<RequestDetails>>();	    	    
			for(RequestDetails requestDetails : requestDetailsList) {
				if(requestDetails.getBundleDetails()==null)
					continue;
				BigInteger bundleId = requestDetails.getBundleDetails().getBundleId();
				Set<RequestDetails> bundleRequests = bundleIdRequestsMap.get(bundleId);
				if(bundleRequests == null) {
					bundleRequests = new HashSet<RequestDetails>();
					bundleIdRequestsMap.put(bundleId, bundleRequests);
				}
				bundleRequests.add(requestDetails);
			} 
			Map<BigInteger, Set<RequestDetails>> sortedMap = new TreeMap<BigInteger, Set<RequestDetails>>(bundleIdRequestsMap);		    
			this.setBundleIDToRequestsMap(sortedMap); 
		}catch(HWFServiceStubException hse){
			addActionMessage(hse.getReason());		
		}
		return SUCCESS;		
	}

	/**
	 * This method is used to remove bundle
	 * @return
	 * @throws HWFServiceException
	 */
	public String removeBundle() throws HWFServiceException, ALOCException{
		try{
			HttpServletRequest request = ServletActionContext.getRequest();
			String bundleId = (String)request.getParameter(BUNDLEID);
			requestDetails =createBundleManager.removeBundle(bundleId);
		}catch(HWFServiceStubException hse){
			addActionMessage(hse.getReason());						 
		}
		return SUCCESS;
	}

	/**
	 * This method is used to submit the bundle.
	 * @return
	 * @throws HWFServiceException
	 */
	public String submitBundle() throws HWFServiceException{
		try{
			HttpServletRequest request = ServletActionContext.getRequest();
			String bundleId = (String)request.getParameter(BUNDLEID);
			requestDetails = createBundleManager.submitBundle(bundleId);
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute(ALOCConstants.SUCCESSMSG,(requestDetails.getComments()!=null)?requestDetails.getComments():ALOCConstants.EMPTY_STRING);
		}catch(HWFApplicationException hse){
			addActionMessage(hse.getReason());
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute(ALOCConstants.ERROR, hse.getReason());
		}
		return SUCCESS;
	}

	/**
	 * This method is used remove the request from the bundle.
	 * @return
	 * @throws HWFServiceException
	 */
	public String removeRequestFromBundle() throws HWFServiceException{
		try{
			HttpServletRequest request = ServletActionContext.getRequest();
			String requestId = (String)request.getParameter(REQUESTID);
			String bundleId = (String)request.getParameter(BUNDLEID);
			requestDetails = createBundleManager.removeRequestFromBundle(requestId,bundleId);	
		}catch(HWFApplicationException hse){
			addActionMessage(hse.getReason());
		}
		return SUCCESS;
	}

	/**
	 * This method is used for request for bundle
	 * @return
	 * @throws HWFServiceException
	 */	
	public String requestsForBundle() throws HWFServiceException{		
		HttpServletRequest request = ServletActionContext.getRequest();		
		String bundleId = (String)request.getParameter(BUNDLEID);
		requestDetailsList = createBundleManager.getRequestsForBundle(bundleId);	 
		return SUCCESSMODAL;
	}



	/**
	 * This is used creatBundleManager instance.
	 * @return
	 */
	public ICreateBundleManager getCreateBundleManager() {
		return createBundleManager;
	}

	/**
	 * This is used createBundleManager instance.
	 * @param createBundleManager
	 */
	public void setCreateBundleManager(ICreateBundleManager createBundleManager) {
		this.createBundleManager = createBundleManager;
	}

	/**
	 * This is used to get the Bundle Request Id.
	 * @return
	 */
	public String getBundleRequestId() {
		return bundleRequestId;
	}

	/**
	 * This is used to set Bundle Request Id.
	 * @param bundleRequestId
	 */
	public void setBundleRequestId(String bundleRequestId) {
		this.bundleRequestId = bundleRequestId;
	}

	/**
	 * get Bundle ID.
	 * @return
	 */
	public String getBundleId() {
		return bundleId;
	}

	/**
	 * This is used to set the Bundle Id.
	 * @param bundleId
	 */
	public void setBundleId(String bundleId) {
		this.bundleId = bundleId;
	}

	/**
	 * this is used to get the BundleIdToRequests Map.
	 * @return
	 */
	public Map<BigInteger, Set<RequestDetails>> getBundleIDToRequestsMap() {
		return bundleIDToRequestsMap;
	}

	/**
	 * This is used to set BundleIdToRequestsMap.
	 * @param bundleIDToRequestsMap
	 */
	public void setBundleIDToRequestsMap(
			Map<BigInteger, Set<RequestDetails>> bundleIDToRequestsMap) {
		this.bundleIDToRequestsMap = bundleIDToRequestsMap;
	}
	/**
	 * This is used to get the Request details object.
	 * @return
	 */
	public RequestDetails getRequestDetails() {
		return requestDetails;
	}
	/**
	 * This is used to set request details.
	 * @param requestDetails
	 */
	public void setRequestDetails(RequestDetails requestDetails) {
		this.requestDetails = requestDetails;
	}
	/**
	 * This is used to get Request details list
	 * @return
	 */
	public List<RequestDetails> getRequestDetailsList() {
		return requestDetailsList;
	}
	/**
	 * This is used to set the request details list.
	 * @param requestDetailsList
	 */
	public void setRequestDetailsList(List<RequestDetails> requestDetailsList) {
		this.requestDetailsList = requestDetailsList;
	}
}
