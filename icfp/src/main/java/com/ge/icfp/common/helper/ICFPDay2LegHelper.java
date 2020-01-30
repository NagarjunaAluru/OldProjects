/**
 * 
 */
package com.ge.icfp.common.helper;

import static com.ge.icfp.common.constants.ICFPConstants.DAYTWOOPERATIONS;
import static com.ge.icfp.common.constants.ICFPConstants.DELETE;
import static com.ge.icfp.common.constants.ICFPConstants.ONE;
import static com.ge.icfp.common.constants.ICFPConstants.PERMANENT;
import static com.ge.icfp.common.constants.ICFPConstants.TEMPORARY;
import static com.ge.icfp.common.constants.ICFPConstants.TWO;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import com.ge.icfp.action.ICFPException;
import com.ge.icfp.common.attachments.AttachmentSecurity;
import com.ge.icfp.common.attachments.DealPermissions;
import com.ge.icfp.common.attachments.ICFPAttachmentManager;
import com.ge.icfp.common.constants.ICFPConstants;
import com.ge.icfp.model.AgreementExtension;
import com.ge.icfp.model.Amendment;
import com.ge.icfp.model.Assignment;
import com.ge.icfp.model.CPALegRequest;
import com.ge.icfp.model.CPATermination;
import com.ge.icfp.model.Correction;
import com.ge.icfp.model.DayTwoOperations;
import com.ge.icfp.model.DealRequest;
import com.ge.icfp.model.DividendPayment;
import com.ge.icfp.model.DrawDown;
import com.ge.icfp.model.FacilityIncreaseDecrease;
import com.ge.icfp.model.PrePayment;
import com.ge.icfp.model.Termination;
import com.ge.icfp.util.EventType;
import com.ge.icfp.util.Utils;

import formdef.plugin.FormMapping;
import formdef.plugin.util.FormUtils;

/**
 * @author chaitanya
 *
 */
public class ICFPDay2LegHelper {
	
	private static final String AMENDMENT_INDEX = "amendmentIndex";
	private static final String AMEREMEDIATION_TIMELINE_COMMENTS = "ameRemediationTimelineComments";
	private static final String AMERATIONALE_FOR_EXCEPTION_POTENTIAL_ALTERNATIVES = "ameRationaleForExceptionPotentialAlternatives";
	private static final String AMEREMEDIATION_TIMELINE_TIMEFRAME = "ameRemediationTimelineTimeframe";
	private static final String AMERATIONALE_FOR_EXCEPTION_IMPACT = "ameRationaleForExceptionImpact";
	private static final String AMEREQUESTED_EXCEPTION = "ameRequestedException";
	private static final String AMENDMENT_TYPE_ID = "amendmentTypeId";
	private static final String DAY_TWO_OPERATIONS_FORM = "DayTwoOperationsForm";
	/**
	 * Returns true if leg is for Day2 operation based on event type selection.
	 * 
	 * @param leg
	 * @return
	 * @throws ICFPException 
	 */
	public static boolean isDay2Leg(Object leg) throws ICFPException {
		return (getEventType(leg) != null);
	}
	
	/**
	 * This method fetches the EventType of specified leg.
	 * 
	 * @param leg
	 * @return
	 * @throws ICFPException 
	 */
	public static List<Amendment> getAmendments(Object leg) throws ICFPException {
		DayTwoOperations day2Operations = Utils.fetchPropertyValue(DAYTWOOPERATIONS, leg, DayTwoOperations.class);
		if(day2Operations != null) {
			return day2Operations.getAmendments();
		}
		return null;
	}
	
	/**
	 * This method fetches the EventType of specified leg.
	 * 
	 * @param leg
	 * @return
	 * @throws ICFPException 
	 */
	public static EventType getEventType(Object leg) throws ICFPException {
		Integer eventTypeId = null;
		if(leg instanceof CPALegRequest) {
			eventTypeId = Utils.fetchPropertyValue("CPASummary.transactionEventTypeId", leg, Integer.class);
		} else {
			eventTypeId = Utils.fetchPropertyValue("legSummary.transactionEventTypeId", leg, Integer.class);
		}
		return (eventTypeId == null) ? null : EventType.fromId(eventTypeId);
	}
	
	/**
	 * This method creates the {@link DayTwoOperations} object and sub-objects if the leg is Day2 leg.
	 * 
	 * @param leg
	 * @throws ICFPException 
	 */
	public static void prepareLegForDay2Operations(Object leg) throws ICFPException {
		EventType eventType = getEventType(leg);
		if(eventType != null) {
			prepareLegForDay2Operations(leg, eventType);
		}
	}
	
	/**
	 * This method creates the {@link DayTwoOperations} object and sub-objects if the leg is Day2 leg.
	 * 
	 * @param leg
	 * @return
	 * @throws ICFPException 
	 */
	public static void prepareLegForDay2Operations(Object leg, EventType eventType) throws ICFPException {
		if(eventType != null) {
			createDay2OperationsIfNotExists(leg, eventType);
		}
	}
	
	/**
	 * Removes empty elements from {@link DayTwoOperations}
	 * 
	 * @param leg
	 * @throws ICFPException 
	 */
	public static void cleanDay2Operations(Object leg) throws ICFPException {
		if(!isDay2Leg(leg)) {
			return;
		}
		DayTwoOperations day2Operations = Utils.fetchPropertyValue(DAYTWOOPERATIONS, leg, DayTwoOperations.class);
		if(day2Operations != null) {
			day2Operations = Utils.cleanBlankElements(day2Operations);
			if(day2Operations == null) {
				Utils.setPropertyValue(DAYTWOOPERATIONS, null, leg);
			}
		}
	}
	
	/**
	 * Synchronizes the Day2Operations form with leg.
	 * 
	 * @param leg
	 * @param form
	 * @param servletContext
	 * @param mapping
	 * @param action
	 * @throws ICFPException 
	 */
	public static void syncDay2OperationsWithForm(Object leg, DynaActionForm form, HttpServletRequest request, ServletContext servletContext, ActionMapping mapping,
			Action action) throws ICFPException {
		EventType eventType = getEventType(leg);
		if(eventType == null) { 
			return;				// Not Day2 leg
		}
		DynaActionForm day2OperationsForm = (DynaActionForm) form.get(DAYTWOOPERATIONS);
		if(day2OperationsForm == null) {
			return;
		}
		DayTwoOperations day2Operations = createDay2OperationsIfNotExists(leg, eventType);
		List<Amendment> amendments = day2Operations.getAmendments();
		FormMapping formMapping = FormUtils.getInstance().findFormDefinition(ICFPDay2LegHelper.DAY_TWO_OPERATIONS_FORM, servletContext, mapping.getModuleConfig());
		FormUtils.getInstance().populateBeanFromForm(formMapping, day2Operations, day2OperationsForm, action, mapping, request);
		List<Amendment> formAmendments = day2Operations.getAmendments();
		// Preserve Amendment Type Id
		for(int i=0; i<formAmendments.size(); i++) {
			amendments.get(i).setExceptionTimelineId(formAmendments.get(i).getExceptionTimelineId());
		}
		
		if(eventType == EventType.GENERAL_AMENDMENT) {
			day2Operations.setAmendments(amendments);
			syncAmendments(form, leg, request);
		}
		cleanDay2Operations(leg);
	}
	
	/**
	 * Synchronizes the form the Day2 operations.
	 * 
	 * @param form
	 * @param leg
	 * @param request
	 * @param servletContext
	 * @param mapping
	 * @param action
	 * @throws ICFPException 
	 */
	public static void syncFormWithDay2Operations(DynaActionForm form, Object leg, HttpServletRequest request,
			ServletContext servletContext, ActionMapping mapping,
			Action action) throws ICFPException {
		EventType eventType = getEventType(leg);
		if(eventType == null) { 
			return;				// Not Day2 leg
		}
		
		DayTwoOperations day2Operations = createDay2OperationsIfNotExists(leg, eventType);
		ActionForm day2OperationsForm = FormUtils.setFormValues(ICFPDay2LegHelper.DAY_TWO_OPERATIONS_FORM, day2Operations, action, mapping, request);
		form.set(DAYTWOOPERATIONS, day2OperationsForm);
	}
	
	/**
	 * Fetch Day2Operations property from the leg; create if not exists.
	 * 
	 * @param leg
	 * @throws ICFPException 
	 */
	private static DayTwoOperations createDay2OperationsIfNotExists(Object leg, EventType eventType) throws ICFPException {
		DayTwoOperations day2Operations = Utils.fetchPropertyValue(DAYTWOOPERATIONS, leg, DayTwoOperations.class);
		if(day2Operations == null) {
			day2Operations = new DayTwoOperations();
			Utils.setPropertyValue(DAYTWOOPERATIONS, day2Operations, leg);
		}
		
		switch(eventType) {
			case CASHPOOL_TERMINATION:
			case CASHPOOL_OTHER:
				if(day2Operations.getCPATermination() == null) {
					day2Operations.setCPATermination(new CPATermination());
				}
				break;
			case ASSIGNMENT:
				if(day2Operations.getAssignment() == null) {
					day2Operations.setAssignment(new Assignment());
				}
				break;
			case AMENDMENT_AGREMENT_EXTENSION:
				if(day2Operations.getAgreementExtension() == null) {
					day2Operations.setAgreementExtension(new AgreementExtension());
				}
				break;
			case AMENDMENT_FACILITY_INC_DEC:
				if(day2Operations.getFacilityIncreaseDecrease() == null) {
					day2Operations.setFacilityIncreaseDecrease(new FacilityIncreaseDecrease());
				}
				
				break;
			case PREPAYMENT:
				if(day2Operations.getPrePayment() == null) {
					day2Operations.setPrePayment(new PrePayment());
				}
				break;
			case DRAWDOWN:
				if(day2Operations.getDrawDown() == null) {
					day2Operations.setDrawDown(new DrawDown());
				}
				break;
			case EARYLY_TERMINATION:
				if(day2Operations.getTermination() == null) {
					day2Operations.setTermination(new Termination());
				}
				break;
			case CORRECTION:
			case DEBT_EQUITY_OTHER:
				if(day2Operations.getCorrection() == null) {
					day2Operations.setCorrection(new Correction());
				}
				break;
			case DEVIDENTS:
				if(day2Operations.getDividendPayment() == null) {
					day2Operations.setDividendPayment(new DividendPayment());
				}
				break;
		}
		return day2Operations;
	}
	
	
	/**
	 * 
	 * @param day2Operations
	 * @param amendments
	 * @throws ICFPException 
	 */
	private static void syncAmendments(DynaActionForm legReqForm, Object leg, HttpServletRequest request) throws ICFPException {
		DealPermissions dealPermissions = AttachmentSecurity.getDealPermissions(request);
		if(!(dealPermissions.isRequestor() || dealPermissions.isFrontOffice())) {
			return;
		}
		
		String[] amendmentIndex = legReqForm.getStrings(ICFPDay2LegHelper.AMENDMENT_INDEX);
		if(amendmentIndex == null || amendmentIndex.length == 0) {
			deleteAllAmendments(leg, request);
			return;
		}
		
		String[] amendmentTypeId = legReqForm.getStrings(ICFPDay2LegHelper.AMENDMENT_TYPE_ID);
		String[] requestedException = legReqForm.getStrings(ICFPDay2LegHelper.AMEREQUESTED_EXCEPTION);
		String[] rationaleForExceptionImpact = request.getParameterValues(ICFPDay2LegHelper.AMERATIONALE_FOR_EXCEPTION_IMPACT);
		String[] rationaleForExceptionPotentialAlternatives = request.getParameterValues(ICFPDay2LegHelper.AMERATIONALE_FOR_EXCEPTION_POTENTIAL_ALTERNATIVES);
		String[] remediationTimelineComments = request.getParameterValues(ICFPDay2LegHelper.AMEREMEDIATION_TIMELINE_COMMENTS);
		String[] remediationTimelineTimeframe = request.getParameterValues(ICFPDay2LegHelper.AMEREMEDIATION_TIMELINE_TIMEFRAME);

		List<Amendment> modifiedAmendments = new ArrayList<Amendment>();
		Integer currentAmendmentIndex = null;
		String exceptionTimeLineId = null;
		
		for(int i = 0; i<amendmentIndex.length; i++) {
			currentAmendmentIndex = Integer.valueOf(amendmentIndex[i]);
			
			// Ignore the empty Amendment
			if(StringUtils.isBlank(amendmentTypeId[i]) && StringUtils.isBlank(requestedException[i]) && StringUtils.isBlank(rationaleForExceptionImpact[i]) 
					&& StringUtils.isBlank(rationaleForExceptionPotentialAlternatives[i]) && StringUtils.isBlank(remediationTimelineComments[i]) 
					&& StringUtils.isBlank(remediationTimelineTimeframe[i]) && StringUtils.isBlank(request.getParameter("ameExceptionTimelineId[" + currentAmendmentIndex + "]"))) {
				continue;
			}
			
			Amendment amendment = getAmendmentCreateIfNot(currentAmendmentIndex, leg);
			modifiedAmendments.add(amendment);
			
			if(StringUtils.isNotEmpty(amendmentTypeId[i])){
				amendment.setAmendmentTypeId(Integer.valueOf(amendmentTypeId[i]));
			} else {
				amendment.setAmendmentTypeId(null);
			}
			
			if(StringUtils.isNotBlank(requestedException[i])) {
				amendment.setRequestedException(requestedException[i]);
			} else {
				amendment.setRequestedException(null);
			}
			
			if(StringUtils.isNotBlank(rationaleForExceptionImpact[i])) {
				amendment.setRationaleForExceptionImpact(rationaleForExceptionImpact[i]);
			} else {
				amendment.setRationaleForExceptionImpact(null);
			}
			
			exceptionTimeLineId = request.getParameter("ameExceptionTimelineId[" + currentAmendmentIndex + "]");
			if(StringUtils.isNotBlank(exceptionTimeLineId)) {
				amendment.setExceptionTimelineId(Integer.valueOf(exceptionTimeLineId));
				if(exceptionTimeLineId.equals(ONE)){
					amendment.setExceptionTimeline(PERMANENT);
				}else if(exceptionTimeLineId.equals(TWO)){
					amendment.setExceptionTimeline(TEMPORARY);
				}
			} else {
				amendment.setExceptionTimelineId(null);
				amendment.setExceptionTimeline(null);
			}
			
			if(StringUtils.isNotBlank(remediationTimelineTimeframe[i])) {
				amendment.setRemediationTimelineTimeframe(remediationTimelineTimeframe[i]);
			} else {
				amendment.setRemediationTimelineTimeframe(null);
			}
			
			if(StringUtils.isNotBlank(rationaleForExceptionPotentialAlternatives[i])) {
				amendment.setRationaleForExceptionPotentialAlternatives(rationaleForExceptionPotentialAlternatives[i]);
			} else {
				amendment.setRationaleForExceptionPotentialAlternatives(null);
			}
			
			if(StringUtils.isNotBlank(remediationTimelineComments[i])) {
				amendment.setRemediationTimelineComments(remediationTimelineComments[i]);
			} else {
				amendment.setRemediationTimelineComments(null);
			}
			
			if(amendment.getAmendmentDetailsId() == null) {
				amendment.setAmendmentOpcode(ICFPConstants.INSERT);
			} else {
				amendment.setAmendmentOpcode(ICFPConstants.UPDATE);
			}
		}
		
		// Clean Other exceptions
		List<Amendment> amendmentList = getAmendments(leg);
		if(!amendmentList.isEmpty()){
			List<Amendment> amendmentListToDelete = new ArrayList<Amendment>();
			for(ListIterator<Amendment> itr = amendmentList.listIterator(); itr.hasNext(); ) {
				Amendment eachException = itr.next();
				if(!modifiedAmendments.contains(eachException)) {
					amendmentListToDelete.add(eachException);
				}
			}
			deleteAmendment(amendmentListToDelete, amendmentList, request);
		}
	}
	
	/**
	 * 
	 * @param index
	 * @param leg
	 * @return
	 * @throws ICFPException 
	 */
	public static Amendment getAmendmentCreateIfNot(int index, Object leg) throws ICFPException {
		Amendment amendment = null;
		List<Amendment> amendmentList = getAmendments(leg);
		List<Amendment> activeAmendments = filterDeletedAmendments(amendmentList);
		if(activeAmendments.size() >= index) {
			amendment = activeAmendments.get(index - 1);
		}
		
		if(amendment == null) {
			int diffToCreate = index - activeAmendments.size();
			for(int i = 0; i < diffToCreate; i++) {
				amendmentList.add(new Amendment());
			}
			amendment = amendmentList.get(index - 1);
		}
		return amendment;
	}
	
	/**
	 * 
	 * @param amendmentListToDelete
	 * @param amendmentList
	 * @param request
	 * @throws ICFPException 
	 */
	private static void deleteAmendment(List<Amendment> amendmentListToDelete, List<Amendment> amendmentList, HttpServletRequest request) throws ICFPException {
		ICFPAttachmentManager attachmentManager = ICFPCommonHelper.getAttachmentManger(request);
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		for(Amendment amendmentToDelete : amendmentListToDelete) {
			if(amendmentToDelete.getAmendmentDetailsId() != null) {
				if(StringUtils.isBlank(amendmentToDelete.getAmendmentOpcode()) 
						|| !ICFPConstants.DELETE.equalsIgnoreCase(amendmentToDelete.getAmendmentOpcode())) {
					amendmentToDelete.setAmendmentOpcode(ICFPConstants.DELETE);
				}
			} else {
				amendmentList.remove(amendmentToDelete);
			}
			attachmentManager.delete(amendmentToDelete.getAttachments(), deal);
		}
	}
	
	/**
	 * 
	 * @param leg
	 * @param request
	 * @throws ICFPException
	 */
	private static void deleteAllAmendments(Object leg, HttpServletRequest request) throws ICFPException {
		List<Amendment> allAmendments = getAmendments(leg);
		List<Amendment> amendmentsToDelete = new ArrayList<Amendment>(allAmendments);
		deleteAmendment(amendmentsToDelete, allAmendments, request);
	}

	/**
	 *  This method used for filter Amendments attachments to delete
	 * @param amendments
	 * @return
	 */
	public static List<Amendment> filterDeletedAmendments(List<Amendment> amendments) {
		List<Amendment> filteredAmendments = new ArrayList<Amendment>();
		if(amendments != null && !amendments.isEmpty()) {
			replaceNullAmendments(amendments);
			for(Amendment eachAmendment : amendments) {
				if(eachAmendment.getAmendmentOpcode() == null || !eachAmendment.getAmendmentOpcode().equalsIgnoreCase(DELETE)) {
					filteredAmendments.add(eachAmendment);
				}
			}
		}
		return filteredAmendments;
	}
	/** 
	 * This method used to replace Null Amendment
	 * @param exceptions
	 */
	public static void replaceNullAmendments(List<Amendment> amendments) {
		for(int i=0; i<amendments.size(); i++) {
			Amendment amendment = amendments.get(i);
			if(amendment == null) {
				amendment = new Amendment();
				amendments.set(i, amendment);
			}
		}
	}
}
