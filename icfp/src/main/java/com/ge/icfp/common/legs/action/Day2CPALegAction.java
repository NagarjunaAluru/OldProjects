/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: CPALegAction.java
 * Purpose: Day2CPALegAction used for adding,deleting,updating leg details
 */
package com.ge.icfp.common.legs.action;

 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import static com.ge.icfp.common.constants.ICFPConstants.*;
/**
 * @author sreenivas.pattaswamy
 * Day2CPALegAction used for adding, modifying, delete legs from the current deal
 */
public class Day2CPALegAction extends CPALegAction {
	private static final Logger logger = Logger.getLogger(Day2CPALegAction.class);
	
	/**
	 * Method used to add a leg to current deal
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward addLeg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		return mapping.findForward(ADDREQUEST);
	}
	
	/**
	 * Method used to save the leg as draft
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward saveAsDraft(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		return mapping.findForward(ADDLEG);
	}
	/**
	 * Method to save the leg and return to deal
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward saveAndReturnToDeal(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward(SUCCESS);
	}
	/**
	 * Method to save the leg to current deal
	 * @param form
	 * @param request
	 * @param mapping
	 */
	public void saveLeg(DynaActionForm form, HttpServletRequest request, ActionMapping mapping) throws Exception{
	}
	/**
	 * Method to get the pool details
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward getPoolLeaderEntites(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws Exception {
		return mapping.findForward(ADDREQUEST);
	}
	
	/**
	 * Method to get Pool lender details from the MDM Service
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward getPoolLeaderDetailas(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward(ADDREQUEST);
	}
	
	/**
	 * Method to get Gold details
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward getGoldIdDetails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws Exception {
		return mapping.findForward(ADDREQUEST);
	}
	
	/**
	 * Method to get Gold details
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward getTCodeDetails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws Exception {
		return mapping.findForward(ADDREQUEST);
	}

}
