/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: ICFPBaseAction.java
 * Purpose: ICFPBaseAction used as generic action for all actions.
 */
package com.ge.icfp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.ge.icfp.common.constants.ICFPConstants;
import com.hydus.wff.core.config.AuthorizationConfigManager;
import com.hydus.wff.core.exception.HWFException;
import com.hydus.wff.core.exception.HWFServiceException;
import com.hydus.wff.core.exception.HWFStubException;
import com.hydus.wff.core.session.SessionManager;
import com.hydus.wff.core.session.SessionVO;
import static com.ge.icfp.common.constants.ICFPConstants.*;
/**
 * Base Action class for all actions.
 * @author madhusudhan.gosula
 *
 */
public class ICFPBaseAction extends DispatchAction {
	private static final String COMMENT_LOG = "commentLog";
	private static final String AUDIT_LOG = "auditLog";
	private static final String ICFP_EXCEPTION = "icfp.exception";
	private static final String ON_SERVING_THE_REQUEST = "; on serving the request ";
	private static final String SERVICE_EXCEPTION = "ServiceException: ";
	private static final String HWF_FRAMEWORK_ERROR_WHILE_HANDLING_THE_REQUEST = "HWF framework error while handling the request ";
	private static final String NO_PERMISSION_TO_ACCESS_THE_PAGE = "No permission to access the page.";
	/**
	 * LOGGER
	 */
	private static final Logger LOGGER = Logger.getLogger(ICFPBaseAction.class);
	/**
	 * ERROR_PAGE
	 */
	public static final String ERROR_PAGE = "/jsp/common/error.jsp";
	/**
	 * REQ_PROCESSING_ERROR_CODE
	 */
	public static final String REQ_PROCESSING_ERROR_CODE = "ICFP-030";
	/**
	 * APPLICATION_ID
	 */
	public static final String APPLICATION_ID = "icfp";
	/**
	 * authConfigMngr
	 */
	private static volatile AuthorizationConfigManager authConfigMngr = null;
	
	
	/**
	 * 
	 * @return
	 * @throws Exception 
	 * @throws HWFException 
	 */
	public static void initializeAuthorizationConfigManager() throws HWFException, Exception {
		if(authConfigMngr == null) {
			synchronized (AuthorizationConfigManager.class) {
				if(authConfigMngr == null) {
					authConfigMngr = AuthorizationConfigManager.getInstance(APPLICATION_ID);
				}
			}
		}
	}
	
	
	/**
	 * execute
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return forward ActionForward
	 */
	 public ActionForward execute(ActionMapping mapping, ActionForm form,
		        HttpServletRequest request, HttpServletResponse response) {
		 ActionForward forward = null;
		 Exception exception = null;
		 
		 try {
			 boolean hasPermission = false;
			 SessionVO sessionVO = SessionManager.getSessionUser(request);
			 initializeAuthorizationConfigManager(); 	// Make sure Authorization Manager is initialized
			 String requestPath = request.getRequestURI().substring(request.getContextPath().length());
			 // If user is authenticated
			 if(sessionVO != null) {
				 hasPermission = AuthorizationConfigManager.hasPermission(requestPath, sessionVO.getRoles());
			 } 
			 
			 // If user is not authenticated
			 else {
				 // Check whether URI is protected; if not grant access
				 hasPermission = !AuthorizationConfigManager.isProtected(requestPath);
			 }
			 
			 if(!hasPermission) {
				 throw new ICFPAuthorizationException("", NO_PERMISSION_TO_ACCESS_THE_PAGE);
			 }
			 
			forward = super.execute(mapping, form, request, response);
		} catch(HWFServiceException hwfse) {
			String errMsg = new StringBuilder().append(HWF_FRAMEWORK_ERROR_WHILE_HANDLING_THE_REQUEST)
					.append(request.getRequestURI()).toString();
			LOGGER.error(errMsg, hwfse);
			exception = hwfse;
		} catch(HWFStubException hwfstube) {
			String errMsg = new StringBuilder().append(SERVICE_EXCEPTION)
					.append(hwfstube.getErrorMessage())
					.append(ON_SERVING_THE_REQUEST)
					.append(request.getRequestURI()).toString();
			LOGGER.error(errMsg, hwfstube);
			exception = hwfstube;
		} catch(HWFException hwfe) {
			String errMsg = new StringBuilder().append(HWF_FRAMEWORK_ERROR_WHILE_HANDLING_THE_REQUEST)
					.append(request.getRequestURI()).toString();
			LOGGER.error(errMsg, hwfe);
			exception = hwfe;
		} catch(ICFPException icfpe) {
			LOGGER.error(icfpe.getReason(), icfpe);
			exception = icfpe;
		} catch (Exception e) {
			ICFPException icfpException = new ICFPException(REQ_PROCESSING_ERROR_CODE, e);
			LOGGER.error(icfpException.getReason(), icfpException);
			exception = icfpException;
		}
		 
		 if(exception != null) {
			 forward = new ActionForward(ERROR_PAGE);
			 request.setAttribute(ICFP_EXCEPTION, exception);
		 }
		 
		 return forward;
	 }
	 
	 /**
	  * Displays the audit log.
	  * 
	  * @param mapping
	  * @param form
	  * @param request
	  * @param response
	  * @return
	  * @throws HWFServiceException
	  */
	 public ActionForward auditLogFull(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)throws HWFServiceException{
		    String source = request.getParameter(SOURCE);
			request.setAttribute(SOURCE,source);
			String isReadOnly = request.getParameter(ICFPConstants.ISREADONLY);
			Boolean isReadOnlyVal = ICFPConstants.TRUE_SMALL.equals(isReadOnly);
			request.setAttribute(ICFPConstants.ISREADONLY, isReadOnlyVal);
			return mapping.findForward(AUDIT_LOG);
		}

	 /**
	  * Displays the comment log.
	  * 
	  * @param mapping
	  * @param form
	  * @param request
	  * @param response
	  * @return
	  * @throws HWFServiceException
	  */
	public ActionForward commentsLogFull(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HWFServiceException {
		String source = request.getParameter(SOURCE);
		request.setAttribute(SOURCE, source);
		String isReadOnly = request.getParameter(ICFPConstants.ISREADONLY);
		Boolean isReadOnlyVal = ICFPConstants.TRUE_SMALL.equals(isReadOnly);
		request.setAttribute(ICFPConstants.ISREADONLY, isReadOnlyVal);
		return mapping.findForward(COMMENT_LOG);
	}
}
