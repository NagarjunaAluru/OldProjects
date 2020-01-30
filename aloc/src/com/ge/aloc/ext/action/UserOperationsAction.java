/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: AuthenticationAction.java
 * Purpose: AuthenticationAction used for the all external user operations
 */
package com.ge.aloc.ext.action;

import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.ext.UserOperationException;
import com.ge.aloc.ext.manager.IUserOperationsManager;
import com.ge.aloc.model.EASDetails;
import com.hydus.hwf.exceptions.HWFServiceException;
import com.opensymphony.xwork2.ActionSupport;

/**
 * This class handles request related user creation and management.
 * 
 * @author chaitanya.n
 */
public class UserOperationsAction extends ActionSupport{

	private static final long serialVersionUID = 1L;

	protected EASDetails easDetails;
	private boolean termsAccepted;
	private String userId;
	private char[] otp;
	private String email;
	private String confirmEmail;
	private char[] password;
	private char[] confirmPassword;
	private IUserOperationsManager userOperationsManager;



	/**
	 * Method to Save New User Details
	 * @return
	 * @throws HWFServiceException
	 * @throws UserOperationException 
	 */
	public String signup() throws HWFServiceException, UserOperationException {
		try {
			userOperationsManager.createUser(easDetails, password);
		} catch (UserOperationException ae) {
			if(UserOperationException.EC_EXISTED_EMAIL.equals(ae.getCode())) {
				addFieldError(ALOCConstants.EAS_MAIL_ADDRESS, getText(ae.getCode())); 
			} else if(UserOperationException.EC_EXISTED.equals(ae.getCode())) {
				addFieldError(ALOCConstants.EAS_USERID, getText(ae.getCode())); 
			} else if(UserOperationException.EC_EXISTED_MSG.equals(ae.getCode())) {
				addFieldError(ALOCConstants.EAS_USERID, getText(ae.getCode())); 
			}else if(UserOperationException.EC_EXISTED_EMAIL_MSG.equals(ae.getCode())) {
				addFieldError(ALOCConstants.EAS_MAIL_ADDRESS, getText(ae.getCode())); 
			}else {
				throw ae;
			}
			return ActionSupport.INPUT;
		}
		addActionMessage(getText(ALOCConstants.MSG_USER_CREATED_SUCCESS, new String[]{easDetails.getEASCredentials().getUserId()}));
		return ActionSupport.SUCCESS;
	}

	/**
	 * This method handles the forgotUserIdOrPassword request.
	 * 
	 * System will send a email with userId and One Time Password after verifying users provided email.
	 * 
	 * @return
	 * @throws UserOperationException
	 * @throws HWFServiceException 
	 */
	public String forgotUserIdOrPassword() throws UserOperationException, HWFServiceException {
		try {
			userOperationsManager.forgotUserIdOrPassword(email);
		} catch (UserOperationException ae) {
			if(UserOperationException.EC_NOTFOUND_EMAIL.equals(ae.getCode())) {
				addActionError(getText(ae.getCodeWithCategoryId(), email));
				return ActionSupport.INPUT;
			} else {
				throw ae;
			}
		}
		addActionMessage(getText(ALOCConstants.MSG_USERID_EMAIL_SUCCESS)); 
		return ActionSupport.SUCCESS;
	}

	/**
	 * This method resets the user's password after verifying the provided userId and One Time Password.
	 * 
	 * @return
	 * @throws HWFServiceException
	 * @throws UserOperationException
	 */
	public String resetPassword() throws HWFServiceException, UserOperationException {
		String result = ActionSupport.SUCCESS;
		try {
			userOperationsManager.resetPassword(userId, otp, password);
			addActionMessage(getText(ALOCConstants.MSG_PASSWORD_RESET_SUCCESS));
		} catch (UserOperationException uoe) {
			if(UserOperationException.EC_OTP_NOTMATCH.equals(uoe.getCode())) {
				addFieldError(ALOCConstants.OTP, ALOCConstants.INVALID_OTP);
				result = ActionSupport.INPUT;
			} else if(UserOperationException.EC_NOTFOUND.equals(uoe.getCode())) {
				addFieldError(ALOCConstants.USER_ID, ALOCConstants.INVALID_USERID);
				result = ActionSupport.INPUT;
			}else {
				throw uoe;
			}
		} 
		return result;
	}

	/* -------------------------------------------------------------------------------------------------------------------------------- 
	 * 											PROPERTY SETTER/GETTER METHODS
	 --------------------------------------------------------------------------------------------------------------------------------- */

	/**
	 * Getter method for password.
	 * 
	 * @return the password
	 */
	public String getPassword() {
		if(password != null) {
			return new String(password);
		}
		return null;
	}

	/**
	 * Setter method for password.
	 * 
	 * @param password the password to set
	 */
	public void setPassword(String strPassword) {
		if(strPassword != null) {
			this.password = new char[strPassword.length()];
			strPassword.getChars(ALOCConstants.BASE_VALUE, strPassword.length(), this.password, ALOCConstants.BASE_VALUE);
		}
		strPassword = null;
	}

	/**
	 * Getter method for confirmation password.
	 * 
	 * @return the conformNewPassword
	 */
	public String getConfirmPassword() {
		if(confirmPassword != null) {
			return new String(confirmPassword);
		}
		return null;
	}

	/**
	 * Setter method for confirmation password.
	 * 
	 * @param conformNewPassword the conformNewPassword to set
	 */
	public void setConfirmPassword(String strPassword) {
		if(strPassword != null) {
			this.confirmPassword = new char[strPassword.length()];
			strPassword.getChars(ALOCConstants.BASE_VALUE, strPassword.length(), this.confirmPassword, ALOCConstants.BASE_VALUE);
		}
		strPassword = null;
	}

	/**
	 * Getter method for {@link EASDetails}
	 * @return the easDetails
	 */
	public EASDetails getEasDetails() {
		return easDetails;
	}

	/**
	 * Getter method for terms accepted field.
	 * 
	 * @return the termsAccepted
	 */
	public boolean isTermsAccepted() {
		return termsAccepted;
	}

	/**
	 * Setter method for {@link EASDetails}.
	 * 
	 * @param easDetails the easDetails to set
	 */
	public void setEasDetails(EASDetails easDetails) {
		this.easDetails = easDetails;
	}

	/**
	 * Setter method for terms accepted field.
	 * 
	 * @param termsAccepted the termsAccepted to set
	 */
	public void setTermsAccepted(boolean termsAccepted) {
		this.termsAccepted = termsAccepted;
	}

	/**
	 * Getter method for email field.
	 * 
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter method for email field.
	 * 
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * Getter method for email confirmation field.
	 * 
	 * @return the conformEmail
	 */
	public String getConfirmEmail() {
		return confirmEmail;
	}

	/**
	 * Setter method for email confirmation field.
	 * 
	 * @param conformEmail the conformEmail to set
	 */
	public void setConfirmEmail(String conformEmail) {
		this.confirmEmail = conformEmail;
	}
	
	/**
	 * Getter method for userId
	 * 
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * Getter method for One Time Password
	 * 
	 * @return the otp
	 */
	public String getOtp() {
		if(otp != null) {
			return new String(otp);
		}
		return null;
	}

	/**
	 * Setter method for userId
	 * 
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * Setter method for One Time Password
	 * 
	 * @param otp the otp to set
	 */
	public void setOtp(String strOtp) {
		if(strOtp != null) {
			this.otp = new char[strOtp.length()];
			strOtp.getChars(ALOCConstants.BASE_VALUE, strOtp.length(), this.otp, ALOCConstants.BASE_VALUE);
		}
		strOtp = null;
	}

	/* -------------------------------------------------------------------------------------------------------------------------------------------------------
	 * 															DEPENDENCY INJECTION METHODS
	 ------------------------------------------------------------------------------------------------------------------------------------------------------- */
	/**
	 * Setter method for {@link IUserOperationsManager} instance.
	 * 
	 * @param authenticationMngr the authenticationMngr to set
	 */
	public void setUserOperationsManager(IUserOperationsManager authenticationMngr) {
		this.userOperationsManager = authenticationMngr;
	}

	/**
	 * Getter method for {@link IUserOperationsManager} instance.
	 * 
	 * @return the authenticationMngr
	 */
	public IUserOperationsManager getUserOperationsManager() {
		return userOperationsManager;
	}
}
