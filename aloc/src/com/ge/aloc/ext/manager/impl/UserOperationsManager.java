/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: UserOperationsManager.java
 * Purpose: UserOperationsManager used for the all external user operations
 */
package com.ge.aloc.ext.manager.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.ext.OTPMailSender;
import com.ge.aloc.ext.UserOperationException;
import com.ge.aloc.ext.dao.IUserOperationsDAO;
import com.ge.aloc.ext.eas.service.client.B2ERequest;
import com.ge.aloc.ext.eas.service.client.B2EResponse;
import com.ge.aloc.ext.eas.service.client.B2EService;
import com.ge.aloc.ext.eas.service.client.B2EService_Service;
import com.ge.aloc.ext.eas.service.client.UserAttributes;
import com.ge.aloc.ext.manager.IUserOperationsManager;
import com.ge.aloc.model.EASDetails;
import com.ge.aloc.model.LandingPageDtls;
import com.hydus.hwf.exceptions.HWFServiceException;
import com.hydus.hwf.security.auth.principals.UserPrincipal;

/**
 * This is the implementation class for {@link IUserOperationsManager}
 * 
 * @see IUserOperationsManager
 * @author chaitanya.n
 */
public class UserOperationsManager implements IUserOperationsManager {
	private static final Logger LOGGER = Logger.getLogger(UserOperationsManager.class);

	private static final String EAS_RESULT_SUCCESS = "SUCCESS";
	private static final String EAS_ECODE_USER_NOT_FOUND = "013";
	private static final String EAS_ECODE_USER_ALREADY_EXISTED = "002";
	private static final String EAS_ECODE_USER_ALREADY_EXISTED019 = "019";

	private B2EService_Service easService;
	private String easOrgId;
	private String easApplicationId;
	private char[] easApplicationPassword;
	private String easOperation;

	private IUserOperationsDAO userOperationsDAO;
	private OTPMailSender otpMailSender;

	/**
	 * Validates the status of EAS service response.
	 * 
	 * @param response
	 * @throws UserOperationException
	 */
	private static void validateEASResponse(B2EResponse response) throws UserOperationException {
		if(!EAS_RESULT_SUCCESS.equals(response.getResult())) {
			UserOperationException authException =  null;
			if(EAS_ECODE_USER_NOT_FOUND.equals(response.getErrCode())) {
				authException = new UserOperationException(UserOperationException.EC_NOTFOUND);
			} else if (EAS_ECODE_USER_ALREADY_EXISTED.equals(response.getErrCode()) 
					|| EAS_ECODE_USER_ALREADY_EXISTED019.equals(response.getErrCode())){
				authException = new UserOperationException(UserOperationException.EC_EXISTED_MSG);
			}
			else {
				StringBuilder errMsg = new StringBuilder().append("EAS Service Error: Error Code = ").append(response.getErrCode())
						.append(" Error Message = ").append(response.getErrMsg());
				authException = new UserOperationException(UserOperationException.EC_EAS_SERVICE, errMsg.toString());
			}
			throw authException;
		}
	}

	/**
	 * @see com.ge.aloc.ext.manager.IUserOperationsManager#createUser(com.ge.aloc.model.EASDetails, char[], char[])
	 */
	public void createUser(EASDetails userDetails, char[] password) throws UserOperationException, HWFServiceException {
		// Unique email check
		EASDetails dbUserDetails = null;
		try {
			dbUserDetails = userOperationsDAO.getUserByEmail(userDetails.getEASContactDetails().getEmailAddress());
		} catch(UserOperationException upe) {
			// Ignore exception represents user not found by email
			if(!UserOperationException.EC_NOTFOUND_EMAIL.equals(upe.getCode())) {
				throw upe;
			}
		}
		if(dbUserDetails != null) {
			throw new UserOperationException(UserOperationException.EC_EXISTED_EMAIL_MSG, userDetails.getEASContactDetails().getEmailAddress());
		}

		// Register with EAS
		B2ERequest request = createEASRequest();

		UserAttributes userAttributes = request.getUserAttributes();
		userAttributes.setSelfReg(Boolean.TRUE.toString());

		userAttributes.setUserName(userDetails.getEASCredentials().getUserId());
		userAttributes.setPassword(new String(password));
		userAttributes.setGivenName(userDetails.getEASContactDetails().getFirstName());
		userAttributes.setSurname(userDetails.getEASContactDetails().getLastName());
		userAttributes.setMail(userDetails.getEASContactDetails().getEmailAddress());

		B2EResponse response = getEASService().addUser(request);
		request = null; // Make sure no references for request object; because it is holding password it has to be garbage collected immediately.
		validateEASResponse(response);

		if(LOGGER.isInfoEnabled()) {
			String message = new StringBuilder().append("User \'").append(userDetails.getEASCredentials().getUserId())
					.append("\' is created successfully in EAS; SSOUID=").append(response.getUserAttributes().getGessouid())
					.toString();
			LOGGER.info(message);
		}

		// Register with IDM and save in ALOC database
		try {
			userOperationsDAO.createUser(userDetails);
		} catch(HWFServiceException hwfse) {
			String errMsg = new StringBuilder().append("User creation failed in database; User[")
					.append("userId=").append(userDetails.getEASCredentials().getUserId())
					.append(", firstName=").append(userDetails.getEASContactDetails().getFirstName())
					.append(", lastName=").append(userDetails.getEASContactDetails().getLastName())
					.append(", emailAddress=").append(userDetails.getEASContactDetails().getEmailAddress())
					.append(", bankName=").append(userDetails.getEASBankDetails().getBankName())
					.append(", roleName=").append(userDetails.getEASBankDetails().getRoleName())
					.append("]").toString();
			LOGGER.error(errMsg);
			throw hwfse;
		}

		if(LOGGER.isInfoEnabled()) {
			String message = new StringBuilder().append("User \'").append(userDetails.getEASCredentials().getUserId())
					.append("\' is created successfully in Database").toString();
			LOGGER.info(message);
		}
	}

	/**
	 * @see IUserOperationsManager#forgotUserIdOrPassword(String)
	 *  @throws HWFServiceException
	 */
	public void forgotUserIdOrPassword(String email) throws UserOperationException, HWFServiceException {

		// Fetch userId by email from database
		EASDetails userDetails = userOperationsDAO.getUserByEmail(email);
		String userName = userDetails.getEASCredentials().getUserId();

		if(LOGGER.isInfoEnabled()) {
			String msg = new StringBuilder().append("UserId for email address \'").append(email)
					.append("\' is \'").append(userName).append("\'.").toString();
			LOGGER.info(msg);

			msg = new StringBuilder().append("Generating One Time Password for the user \'").append(userName).append("\'").toString();
			LOGGER.info(msg);
		}

		B2ERequest request = createEASRequest();
		request.getUserAttributes().setUserName(userName);
		request.setUseOtp(Boolean.TRUE.toString());
		B2EResponse response = getEASService().challenge(request);
		validateEASResponse(response);

		if(LOGGER.isInfoEnabled()) {
			LOGGER.info(new StringBuilder().append("One Time Password of the user \'").append(userName)
					.append("\' is generated successfully"));
		}

		String otp = response.getChallengeQuestionText();
		otpMailSender.send(email, userName, otp.toCharArray());
	}

	/**
	 * @see IUserOperationsManager#resetPassword(char[])
	 */
	public void resetPassword(String userId, char[] otp, char[] password) throws UserOperationException {
		// Validate OTP
		B2ERequest request = createEASRequest();
		request.setUseOtp(Boolean.TRUE.toString());
		UserAttributes userAttributes = request.getUserAttributes();
		userAttributes.setUserName(userId);
		request.setChallengeAnswer(new String(otp));
		B2EResponse response = getEASService().challengeAnswer(request);
		request = null;
		validateEASResponse(response);
		if(response.getChallengeAnswerScore() == null || !response.getChallengeAnswerScore().equals(Integer.valueOf(ALOCConstants.BASE_VALUE))) {
			throw new UserOperationException(UserOperationException.EC_OTP_NOTMATCH);
		}
		
		// Rest Password
		request = createEASRequest();
		userAttributes = request.getUserAttributes();
		userAttributes.setUserName(userId);
		userAttributes.setPassword(new String(password));
		response = getEASService().updatePassword(request);
		request = null; // Make sure no references for request object; because it is holding password it has to be garbage collected immediately.
		validateEASResponse(response);

		if(LOGGER.isInfoEnabled()) {
			String message = new StringBuilder().append("Password of the user \'").append(userId)
					.append("\' is updated successfully").toString();
			LOGGER.info(message);
		}
	}

	/**
	 * @see IUserOperationsManager#getUserPrincipal(String)
	 */
	public UserPrincipal getUserPrincipal(String userName) throws UserOperationException, HWFServiceException {
		B2ERequest request = createEASRequest();
		request.getUserAttributes().setUserName(userName);
		B2EResponse response = getEASService().getUserInfo(request);
		if(!(ALOCConstants.ERROR_CAP.equals(response.getResult()) && ALOCConstants.USER_ERROR_CODE.equals(response.getErrCode()))) { // TODO Need to remove this check once EAS bug is fixed
			validateEASResponse(response);
		}

		UserAttributes userAttributes = response.getUserAttributes();
		UserPrincipal userPrincipal = new UserPrincipal(userAttributes.getUserName());
		userPrincipal.setFirstName(userAttributes.getGivenName());
		userPrincipal.setLastName(userAttributes.getSurname());
		userPrincipal.setEmailAddress(userAttributes.getMail());
		userPrincipal.setBusinessUnit(userAttributes.getLinkedBu()); 
		userPrincipal.setCompany(userAttributes.getOrgId());
		
		EASDetails userDetails = userOperationsDAO.getUser(userName);
		/* 
		 * Bank name is storing as Primary Department of user. Whenever application need to validate the user
		 * Against bank need to use same field.
		 */
		userPrincipal.setPrimaryDepartment(userDetails.getEASBankDetails().getBankName());
		userPrincipal.getRoles().add(userDetails.getEASBankDetails().getRoleName());
		Map<String, String> statusMap = new HashMap<String, String>();
		statusMap.put(ALOCConstants.IDM_STATUS, userDetails.getEASBankDetails().getStatus());
		userPrincipal.setStatusMap(statusMap);
		return userPrincipal;
	}

	/**
	 * @see com.ge.aloc.ext.manager.IUserOperationsManager#getEASOrgId()
	 */
	public String getEASOrgId() {
		return this.easOrgId;
	}

	/**
	 * Creates the EAS service request object and initialises the common input
	 * 
	 * @return 
	 */
	protected B2ERequest createEASRequest() {
		B2ERequest request = new B2ERequest();
		request.setApplicationID(easApplicationId);
		request.setApplicationPassword(new String(easApplicationPassword));
		request.setOperation(easOperation);
		UserAttributes userAttributes = new UserAttributes();
		userAttributes.setOrgId(easOrgId);
		request.setUserAttributes(userAttributes);
		return request;
	}

	/**
	 * Returns the {@link B2EService} port.
	 * 
	 * @return
	 */
	protected B2EService getEASService() {
		return this.easService.getB2EServiceSOAP();
	}

	/**
	 * This method is used to get landing page details.
	 */
	public LandingPageDtls getLandingPageDetails(List<String> userRoles) throws HWFServiceException {
		return userOperationsDAO.getLandingPageDetails();
	}

	/* -------------------------------------------------------------------------------------------------------------------------------------------------------
	 * 															DEPENDENCY INJECTION METHODS
	 ------------------------------------------------------------------------------------------------------------------------------------------------------- */

	/**
	 * Setter method for {@link B2EService_Service}
	 * 
	 * @param easService the easService to set
	 */
	public void setEasService(B2EService_Service easService) {
		this.easService = easService;
	}

	/**
	 * Setter method for application organisation id of EAS.
	 * 
	 * @param easOrgId the easOrgId to set
	 */
	public void setEasOrgId(String easOrgId) {
		this.easOrgId = easOrgId;
	}

	/**
	 * Setter method for application Id of EAS.
	 * 
	 * @param easApplicationId the easApplicationId to set
	 */
	public void setEasApplicationId(String easApplicationId) {
		this.easApplicationId = easApplicationId;
	}

	/**
	 * Setter method application password of EAS
	 * 
	 * @param easApplicationPassword the easApplicationPassword to set
	 */
	public void setEasApplicationPassword(String strPassword) {
		if(strPassword != null) {
			this.easApplicationPassword = new char[strPassword.length()];
			strPassword.getChars(ALOCConstants.BASE_VALUE, strPassword.length(), this.easApplicationPassword, ALOCConstants.BASE_VALUE);
		}
		strPassword = null;
	}

	/**
	 * Setter method for EAS mode.
	 * 
	 * @param easOperation the easOperation to set
	 */
	public void setEasOperation(String easOperation) {
		this.easOperation = easOperation;
	}

	/**
	 * Setter method for {@link IUserOperationsDAO}.
	 * 
	 * @param authenticationDAO the authenticationDAO to set
	 */
	public void setUserOperationsDAO(IUserOperationsDAO authenticationDAO) {
		this.userOperationsDAO = authenticationDAO;
	}

	/**
	 * Setter method for {@link OTPMailSender}.
	 * 
	 * @param otpMailSender the otpMailSender to set
	 */
	public void setOtpMailSender(OTPMailSender otpMailSender) {
		this.otpMailSender = otpMailSender;
	}
}
