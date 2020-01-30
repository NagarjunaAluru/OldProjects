/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: EASAuthenicationMngr.java
 * Purpose: EASAuthenicationMngr is used to get the User Principal Details
 */

package com.ge.aloc.ext.auth;

import java.util.Map;

import com.ge.aloc.exception.ALOCRuntimeException;
import com.ge.aloc.ext.UserOperationException;
import com.ge.aloc.ext.manager.IUserOperationsManager;
import com.hydus.hwf.exceptions.HWFServiceException;
import com.hydus.hwf.security.UserNotFoundException;
import com.hydus.hwf.security.auth.WebAppAuthenticationManager;
import com.hydus.hwf.security.auth.principals.UserPrincipal;

/**
 * This class extends the {@link WebAppAuthenticationManager} class and customises the {@link UserPrincipal} retrieval.
 * 
 * @author chaitanya.n
 */
public class EASAuthenicationMngr extends WebAppAuthenticationManager {

	private static final String CTX_KEY_USR_OPER_MNGR = IUserOperationsManager.class.getName();

	/**
	 * Constructor to create instance of this class.
	 * 
	 * @param applicationName
	 * @param options
	 */
	public EASAuthenicationMngr(String applicationName, Map<String, Object> options) {
		super(applicationName, options);
	}

	/**
	 * Fetches the user information from EAS and ALOC database.
	 */
	@Override
	public UserPrincipal getUserPrincipal(String accountName) throws UserNotFoundException {
		if(servletContext == null) {
			throw new ALOCRuntimeException(null, "Config Error: ServletContext not available");
		}

		IUserOperationsManager userOperMngr = (IUserOperationsManager) servletContext.getAttribute(CTX_KEY_USR_OPER_MNGR);
		if(userOperMngr == null) {
			throw new ALOCRuntimeException(null, 
					"Config Error: UserOperationsManager is not available at application scope under the key " + CTX_KEY_USR_OPER_MNGR);
		}
		UserPrincipal userPrincipal = null;
		try {
			userPrincipal = userOperMngr.getUserPrincipal(accountName);
		} catch (UserOperationException upe) {
			if(UserOperationException.EC_NOTFOUND.equals(upe.getCode())) {
				throw new UserNotFoundException(upe);
			}
			throw new ALOCRuntimeException(upe.getCodeWithCategoryId(), upe); 
		} catch (HWFServiceException e) {
			throw new ALOCRuntimeException(e.getCodeWithCategoryId(), e); 
		}

		return userPrincipal;
	}
}
