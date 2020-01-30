/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: CurrentDealManager.java
 * Purpose: CurrentDealManager used for handling the deal modal object with session.
 */
package com.ge.icfp.common.helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.ge.icfp.action.ICFPException;
import com.ge.icfp.model.Amendment;
import com.ge.icfp.model.Attachment;
import com.ge.icfp.model.AttachmentTypeComments;
import com.ge.icfp.model.BusinessApprovers;
import com.ge.icfp.model.CPALegRequest;
import com.ge.icfp.model.CPASummary;
import com.ge.icfp.model.DealRequest;
import com.ge.icfp.model.DerivativesRequest;
import com.ge.icfp.model.EquityLegRequest;
import com.ge.icfp.model.ExceptionRequestForm;
import com.ge.icfp.model.LegSummary;
import com.ge.icfp.model.Legs;
import com.ge.icfp.model.NameValue;
import com.ge.icfp.model.OtherLegRequest;
import com.ge.icfp.model.RCALegRequest;
import com.ge.icfp.model.UpdateStatus;
import com.ge.icfp.model.UpdateStatus.AdditionalApprovals;
import com.ge.icfp.model.UserInfo;
import com.ge.icfp.util.BusinessRegion;
import com.ge.icfp.util.EventType;
import com.ge.icfp.util.StaticDataFactory;

import static com.ge.icfp.common.constants.ICFPConstants.*;
/**
 * This help is providing common helper class used for the deal
 * 
 * @author chaitanya
 *
 */
public class CurrentDealManager {
	
	private static final String DRAFT = "draft";
	private static final Logger LOGGER = Logger.getLogger(CurrentDealManager.class);
	public static final String SSN_KEY_CURRENT_DEAL = "deal";
	public static final String SSN_KEY_CURRENT_UPDATE_DEAL = "updateDeal";
	public static final String SSN_KEY_CURRENT_LEG = "curLeg";
	private static final String LEG_TYPE_IMMEDIATE_DRAWDOWN = "Immediate Drawdown";
	
	/**
	 * setActiveDeal used to set the deal object to session.
	 * @param deal DealRequest
	 * @param request HttpServletRequest
	 */
	public static void setActiveDeal(DealRequest deal, HttpServletRequest request) {
		if(deal == null) {
			removeCurrentDeal(request);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute(SSN_KEY_CURRENT_DEAL, deal);
		}
	}
	/**
	 * getCurrentDeal used to get the deal object from session.
	 * @param request HttpServletRequest
	 * @return currentDeal DealRequest
	 */
	public static DealRequest getCurrentDeal(HttpServletRequest request) {
		DealRequest currentDeal = null;
		HttpSession session = request.getSession(false);
		if(session != null) {
			currentDeal = (DealRequest) session.getAttribute(SSN_KEY_CURRENT_DEAL);
		}
		return currentDeal;
	}
	/**
	 * removeCurrentDeal used to remove the deal object from session.
	 * @param request HttpServletRequest
	 */
	public static void removeCurrentDeal(HttpServletRequest request) {
		DealRequest currentDeal = null;
		HttpSession session = request.getSession(false);
		if(session != null) {
			currentDeal = (DealRequest) session.getAttribute(SSN_KEY_CURRENT_DEAL);
		}
		
		if(currentDeal != null) {
			session.removeAttribute(SSN_KEY_CURRENT_DEAL);
		}
	}
	/**
	 * isDraft used identify whether the request is going to create Draft mode or not.
	 * @param request HttpServletRequest
	 * @return boolean
	 */
	public static boolean isDraft(HttpServletRequest request) {
		DealRequest deal = getCurrentDeal(request);
		return (deal.getUniqueId().endsWith(DRAFT) || deal.getUniqueId().endsWith(DRAFT_GLOBEL));
	}
	/**
	 * isSubmitted used identify whether the request submited or not.
	 * @param request HttpServletRequest
	 * @return boolean
	 */
	public static boolean isSubmitted(HttpServletRequest request) {
		return !isDraft(request);
	}
	
	/**
	 * isCPADeal used identify whether the CPA Request or not.
	 * @param request HttpServletRequest
	 * @return boolean result
	 */
	public static Boolean isCPADeal(HttpServletRequest request) {
		DealRequest dealRequest = getCurrentDeal(request);
		return ICFPCommonHelper.isCPADeal(dealRequest);
	}
	
	/**
	 * isCPADeal used identify whether the CPA Request or not.
	 * @param request HttpServletRequest
	 * @return boolean result
	 */
	public static Boolean isEquityDeal(HttpServletRequest request) {
		Boolean result = null;
		DealRequest dealRequest = getCurrentDeal(request);
		if (dealRequest.getLegs() != null
				&& !dealRequest.getLegs().getAllLegs().isEmpty()) {

			for (Object legObj : dealRequest.getLegs().getAllLegs()) {

				if (legObj instanceof EquityLegRequest) {
					result = true;

					break;

				}

			}

		}
		return result;
	}
	
	
	/**
	 * isCPADeal used identify whether the EquityDeal Request or not.
	 * @param request HttpServletRequest
	 * @return boolean result
	 */
	public static Boolean isEquityLeg(HttpServletRequest request,Integer legNumber) {
		Boolean result = false;
		DealRequest dealRequest = getCurrentDeal(request);
			Object obj = ICFPCommonHelper.getLegByNumber(legNumber, dealRequest);
			if(obj instanceof EquityLegRequest) {
				result = true;
			} else {
				result = false;
			}
		return result;
	}
	
	/**
	 * Return true if Deal is available in session.
	 * @param request HttpServletRequest
	 * @return boolean
	 */
	public static boolean hasCurrentDeal(HttpServletRequest request) {
		return getCurrentDeal(request) != null;
	}
	/**
	 * setCurrentLeg used to set the leg object to session.
	 * @param leg Object
	 * @param type Object
	 * @param req HttpServletRequest
	 */
	public static <T> void setCurrentLeg(Object leg, Class<T> type, HttpServletRequest req){
		
		HttpSession session = req.getSession();
		session.setAttribute(SSN_KEY_CURRENT_LEG, type.cast(leg));
	}
	/**
	 * getCurrentLegType is used to identify the current leg type.
	 * @param request HttpServletRequest
	 * @return 
	 */
	public static Class<? extends Object> getCurrentLegType(HttpServletRequest request){
		HttpSession session = request.getSession(false);
		return session.getAttribute(SSN_KEY_CURRENT_LEG).getClass();
	}
	/**
	 * getCurrentLeg used to get the current leg from session.
	 * @param type Object
	 * @param request HttpServletRequest
	 * @return leg
	 */
	public static <T> T getCurrentLeg(Class<T> type, HttpServletRequest request){
		HttpSession session = request.getSession(false);
		return type.cast( session.getAttribute(SSN_KEY_CURRENT_LEG) );
	}
	/**
	 * addLeg used to add the leg object the deal.
	 * @param leg Object
	 * @param request HttpServletRequest
	 */
	public static void addLeg(Object leg, HttpServletRequest request) {
		DealRequest dealRequest = getCurrentDeal(request);
		if(dealRequest.getLegs() == null) {
			dealRequest.setLegs(new Legs());
		}
		dealRequest.getLegs().getAllLegs().add(leg);
	}
	
	/**
	 * deleteLeg is used to delete the leg from deal object.
	 * @param legIndex int
	 * @param request HttpServletRequest
	 */
	public static void deleteLeg(int legIndex, HttpServletRequest request) {
		Object leg = getLegByNumber(legIndex, request);
		deleteLeg(leg, request);
	}
	
	
	
	/**
	 * deleteException is used to delete exception from leg object.
	 * @param legIndex int 
	 * @param request HttpServletRequest
	 */
	public static void deleteAmendment(int amendmentNumber, int legIndex, HttpServletRequest request) {
		Object leg = getLegByNumber(legIndex, request);
		deleteAmendment(amendmentNumber, leg, request);
	}
	
	/**
	 * deleteException is used to delete exception from leg object.
	 * @param leg Object 
	 * @param request HttpServletRequest
	 */
	public static void deleteAmendment(int amendmentNumber, Object leg, HttpServletRequest request) {
		List<Amendment> amendments = ICFPLegHelper.getAmendments(leg);
		Amendment amendment = amendments.get(amendmentNumber - 1);
		amendment.setAmendmentOpcode(DELETE);
	}
	
	/**
	 * deleteException is used to delete exception from leg object.
	 * @param exceptionNumber int
	 * @param legIndex int 
	 * @param request HttpServletRequest
	 */
	public static void deleteException(int exceptionNumber, int legIndex, HttpServletRequest request) {
		Object leg = getLegByNumber(legIndex, request);
		deleteException(exceptionNumber, leg, request);
	}
	
	/**
	 * deleteException is used to delete exception from leg object.
	 * @param exceptionNumber int
	 * @param leg Object 
	 * @param request HttpServletRequest
	 */
	public static void deleteException(int exceptionNumber, Object leg, HttpServletRequest request) {
		List<ExceptionRequestForm> exceptions = ICFPLegHelper.getExceptions(leg);
		ExceptionRequestForm exceptionToDelete = exceptions.get(exceptionNumber - 1);
		exceptionToDelete.setExceptionOpcode(DELETE);
	}
	
	/**
	 * deleteLeg is used to delete the leg from deal object.
	 * @param leg Object
	 * @param request HttpServletRequest
	 */
	public static void deleteLeg(Object leg, HttpServletRequest request) {
		DealRequest deal = getCurrentDeal(request);
		if(leg instanceof RCALegRequest) {
			RCALegRequest rcaLeg = (RCALegRequest) leg;
			if(rcaLeg.getLegSummary().getLegSeqId() == null) {
				deal.getLegs().getAllLegs().remove(leg);
			} else {
				rcaLeg.getLegSummary().setLegOpcode(DELETE);
			}
		} else if(leg instanceof EquityLegRequest) {
			EquityLegRequest equityLeg = (EquityLegRequest) leg;
			if(equityLeg.getLegSummary().getLegSeqId() == null) {
				deal.getLegs().getAllLegs().remove(leg);
			} else {
				equityLeg.getLegSummary().setLegOpcode(DELETE);
			}
		} else if(leg instanceof OtherLegRequest) {
			OtherLegRequest otherLeg = (OtherLegRequest) leg;
			if(otherLeg.getLegSummary().getLegSeqId() == null) {
				deal.getLegs().getAllLegs().remove(leg);
			} else {
				otherLeg.getLegSummary().setLegOpcode(DELETE);
			}
		} else if(leg instanceof CPALegRequest) {
			CPALegRequest cpaLeg = (CPALegRequest) leg;
			if(cpaLeg.getCPASummary().getLegSeqId() == null) {
				deal.getLegs().getAllLegs().remove(leg);
			} 
		}
	}
	/**
	 * getLegByNumber is used to retrieve the leg by leg number.
	 * @param index int
	 * @param legClass Object
	 * @param request HttpServletRequest
	 * @return leg
	 */
	public static <T> T getLegByNumber(int index, Class<T> legClass, HttpServletRequest request) {
		Object leg = getLegByNumber(index, request);
		return legClass.cast(leg);
	}
	
	/**
	 * Returns leg of the current deal by leg number.
	 * 
	 * @param index
	 * @param request
	 * @return
	 */
	public static Object getLegByNumber(int index, HttpServletRequest request) {
		DealRequest dealRequest = getCurrentDeal(request);
		return ICFPCommonHelper.getLegByNumber(index, dealRequest);
	}
	
	/**
	 * getNewLegNumber is used to generate new leg number.
	 * @param request HttpServletRequest
	 * @return int
	 */
	public static int getNewLegNumber(HttpServletRequest request) {
		DealRequest dealRequest = getCurrentDeal(request);
		int legNumber = 1;
		if(dealRequest.getLegs() != null) {
			int count = 0;
			for(Object leg : dealRequest.getLegs().getAllLegs()) {
				String opcode = ICFPLegHelper.getOpCode(leg);
				if(opcode != null && opcode.equalsIgnoreCase(DELETE)) {
					continue;
				}
				count++;
			}
			legNumber = count + 1;
		}
		return legNumber;
	}
	
	/**
	 * getRCALegByNumber is used to retrieve RCA leg request by leg number.
	 * @param legID int
	 * @param request HttpServletRequest
	 * @return RCALegRequest
	 */
	public static RCALegRequest getRCALegByNumber(int legID, HttpServletRequest request){
		return getLegByNumber(legID, RCALegRequest.class, request);
	}
	
	/**
	 * getOtherLegByNumber is used to retrieve RCA leg request by leg number.
	 * @param legID int
	 * @param request HttpServletRequest
	 * @return RCALegRequest
	 */
	public static OtherLegRequest getOtherLegByNumber(int legID, HttpServletRequest request){
		return getLegByNumber(legID, OtherLegRequest.class, request);
	}
	/**
	 * getCPALegByNumber is used to retrieve CPA leg request by leg number.
	 * @param legID int
	 * @param request HttpServletRequest
	 * @return CPALegRequest
	 */
	public static CPALegRequest getCPALegByNumber(int legID, HttpServletRequest request){
		return getLegByNumber(legID, CPALegRequest.class, request);
	}
	/**
	 * setLegByNumber is used to set leg object by leg number.
	 * @param index int
	 * @param legClass Object
	 * @param leg Object
	 * @param request HttpServletRequest
	 * @return leg
	 */
	public static  <T> T setLegByNumber(int index, Class<T> legClass,Object leg, HttpServletRequest request) {
		DealRequest dealRequest = getCurrentDeal(request);
		if(dealRequest.getLegs()!=null){
			Object oldLeg = getLegByNumber(index, request);
			int legIndex = dealRequest.getLegs().getAllLegs().indexOf(oldLeg);
			leg = dealRequest.getLegs().getAllLegs().set(legIndex, leg);
		}else{
			Legs legs = new Legs();
			List<Object> allLegs = new ArrayList<Object>();
			allLegs.add(legClass.cast(leg));
			legs.setAllLegs(allLegs);
			dealRequest.setLegs(legs);
		}
		return legClass.cast(leg);
	}
	/**
	 * setRCALegByNumber is used to set leg object by leg number.
	 * @param legRequest RCALegRequest
	 * @param request HttpServletRequest
	 * @return leg RCALegRequest
	 */
	public static RCALegRequest setRCALegByNumber(int legID,RCALegRequest legRequest,HttpServletRequest request){
		return setLegByNumber(legID, RCALegRequest.class,legRequest, request);
	}
	/**
	 * matchLegId is used to identify the match leg.
	 * @param leg Object
	 * @param legSeqIdToMatch String
	 * @return
	 */
	private static boolean matchLegId(Object leg, String legSeqIdToMatch) {
		String legId = null;
		if(leg instanceof RCALegRequest) {
			legId = ((RCALegRequest) leg).getLegSummary().getLegSeqId().toString();
		} else if(leg instanceof CPALegRequest) {
			legId = ((CPALegRequest) leg).getCPASummary().getLegSeqId().toString();
		} else if(leg instanceof EquityLegRequest) {
			legId = ((EquityLegRequest) leg).getLegSummary().getLegSeqId().toString();
		} else if(leg instanceof OtherLegRequest) {
			legId = ((OtherLegRequest) leg).getLegSummary().getLegSeqId().toString();
		}
		if(legId == null) {
			return false;
		}
		return legId.equals(legSeqIdToMatch);
	}
	/**
	 * getLegBySeq is used retrieve the leg by sequence number.
	 * @param legId String
	 * @param legType Object
	 * @param request HttpServletRequest
	 * @return leg
	 */
	public static <T> T getLegBySeq(String legId, Class<T> legType, HttpServletRequest request) {
		DealRequest currentDeal = getCurrentDeal(request);
		for(Object leg : currentDeal.getLegs().getAllLegs()) {
			if(matchLegId(leg, legId)) {
				return legType.cast(leg);
			}
		}
		return null;
	}
	
	/**
	 * removeLeg is used to remove the leg from deal object.
	 * @param index int
	 * @param legClass Object
	 * @param request HttpServletRequest
	 */
	public static <T> void removeLeg(int index, Class<T> legClass, HttpServletRequest request) {
		DealRequest dealRequest = getCurrentDeal(request);
		dealRequest.getLegs().getAllLegs().remove(index);
	}
	/**
	 * getDerivative is used to retrieve derivate from leg object.
	 * @param legNumber int
	 * @param derivativeNumber int
	 * @param request HttpServletRequest
	 * @return result DerivativesRequest
	 */
	public static DerivativesRequest getDerivative(int legNumber, int derivativeNumber, HttpServletRequest request) {
		DerivativesRequest result = null;
		List<DerivativesRequest> derivatives = getAllDerivatives(legNumber, request);
		if(derivatives != null) {
			result = derivatives.get(derivativeNumber - 1);
		}
		return result;
	}
	/**
	 * getAllDerivatives is used to fetch all the derivative from the leg object.
	 * @param legNumber int
	 * @param request HttpServletRequest
	 * @return result List
	 */ 
	public static List<DerivativesRequest> getAllDerivatives(int legNumber, HttpServletRequest request) {
		List<DerivativesRequest> result = null;
		DealRequest deal = getCurrentDeal(request);
		Object leg = getLegByNumber(legNumber, request);
		if(leg instanceof RCALegRequest) {
			result = ((RCALegRequest) leg).getLegSummary().getDerivativesRequests();
		} else if(leg instanceof EquityLegRequest) {
			result = ((EquityLegRequest) leg).getLegSummary().getDerivativesRequests();
		} 
		else if(leg instanceof OtherLegRequest) {
			result = ((OtherLegRequest) leg).getLegSummary().getDerivativesRequests();
		} 
		return result;
	}
	
	/* -----------------------------------------------------------------------------------------------------------------------------
	 * 										Attachment Methods
	 -------------------------------------------------------------------------------------------------------------------------------*/
	
	
	
	
	
	
	/**
	 * validate the Leg for the attachment
	 * @param legSummary
	 * @param eachLeg
	 * @return
	 * @throws ICFPException
	 */
	public static boolean isValidLegForAttachment(Object legSummary, Object eachLeg) throws ICFPException{
		String transEventName = 
				(legSummary instanceof CPASummary) ? 
						((CPASummary) legSummary).getTransactionEventType() 
						: ((LegSummary) legSummary).getTransactionEventType();
		if (StringUtils.isNotBlank(transEventName) && transEventName.contains(LEG_TYPE_IMMEDIATE_DRAWDOWN)) {			
			return false;
		}
		boolean isDay2Leg = ICFPDay2LegHelper.isDay2Leg(eachLeg);
		if (isDay2Leg) {
			EventType eventType = getDay2EventType(eachLeg);
			if(eventType!=null){
				switch (eventType) {
				case AMENDMENT_FACILITY_INC_DEC:
					return false;
				case PREPAYMENT:
					return false;
				case DRAWDOWN:
					return false;
				case CORRECTION:
					return false;
				}
			}else{
				return true;
			}
		}
		
		return true;
	}
	
	
	/**
	 * Get day2 Event Type
	 * @param eachLeg
	 * @return
	 * @throws ICFPException
	 */
	public static EventType getDay2EventType(Object eachLeg) throws ICFPException {
		if(eachLeg instanceof RCALegRequest){
			RCALegRequest rcaLeg = (RCALegRequest) eachLeg;
			if(rcaLeg.getLegSummary().getTransactionEventTypeId().intValue() == 5){
				if(rcaLeg.getDayTwoOperations().getFacilityIncreaseDecrease().getFacilityTypeId().intValue() == 2){
					return ICFPDay2LegHelper.getEventType(eachLeg);
				}else{
					return null;
				}
			}
		}
		return ICFPDay2LegHelper.getEventType(eachLeg);
		
	}
	
	/**
	 * 
	 * @param deal
	 * @param updateStatus
	 * @param request
	 * @return
	 */
	public static UpdateStatus setDealObjectToUpdateStatusComments(
			DealRequest deal, UpdateStatus updateStatus,
			HttpServletRequest request) {

		List<AttachmentTypeComments> allAttachmentsComments = new ArrayList<AttachmentTypeComments>();
		allAttachmentsComments.addAll(deal.getAttachmentTypeComments());
		for (Object leg : deal.getLegs().getAllLegs()) {
			List<AttachmentTypeComments> legAttachmentsComments = CurrentDealManager.getAttachmentCommentsByLeg(leg, request);
			Integer legSeqId = ICFPLegHelper.getAttachmentsSeqIdForLegObj(leg);
			if (legAttachmentsComments != null&& !legAttachmentsComments.isEmpty()) {
				for (int i = 0; i < legAttachmentsComments.size(); i++) {
					AttachmentTypeComments attachmentTypeComments = legAttachmentsComments.get(i);
					if (legSeqId != null) {
						attachmentTypeComments.setLegSeqId(legSeqId);
					}
				}
				allAttachmentsComments.addAll(legAttachmentsComments);
			}
		}
		updateStatus.setAttachmentTypeComments(allAttachmentsComments);
		return updateStatus;

	}
	
	
	
	
	/**
	 * Method used to read the comments from request object
	 * @param request
	 */
	public static void syncCommentsWithFormObject(HttpServletRequest request) {
		String[] dealAtmtCmtType = (String[])request.getParameterValues("atmtCommentType");
		String[] dealAtmtCmt = (String[])request.getParameterValues("atmtComment");
		String[] atmtLegNumber = (String[])request.getParameterValues("atmtLegNumber");
		String[] atmtLegCommentType = (String[])request.getParameterValues("atmtLegCommentType");
		String[] atmtLegComment = (String[])request.getParameterValues("atmtLegComment");
		CurrentDealManager.syncAllAttachmentComments(dealAtmtCmtType, dealAtmtCmt, atmtLegNumber, atmtLegCommentType, atmtLegComment, request,INSERT,false);
	}
	
	/**
	 * Method used to read the comments from request object
	 * @param request
	 */
	public static void syncTPCommentsWithFormObject(HttpServletRequest request) {
		String[] dealAtmtCmtType = (String[])request.getParameterValues("atmtCommentType");
		String[] dealAtmtCmt = (String[])request.getParameterValues("atmtComment");
		String[] atmtLegNumber = (String[])request.getParameterValues("atmtLegNumber");
		String[] atmtLegCommentType = (String[])request.getParameterValues("atmtLegCommentType");
		String[] atmtLegComment = (String[])request.getParameterValues("atmtLegComment");
		CurrentDealManager.syncAllAttachmentComments(dealAtmtCmtType, dealAtmtCmt, atmtLegNumber, atmtLegCommentType, atmtLegComment, request,INSERT,true);
	}
	/**
	 *  Method used to sync the comments with object as per service
	 * @param dealAtmtCmtType
	 * @param dealAtmtCmt	
	 * @param atmtLegNumber
	 * @param legAtmtCmtType
	 * @param legAtmtCmt
	 * @param serviceType
	 * @param request
	 */
	public static void syncAllAttachmentComments(String[] dealAtmtCmtType, String[] dealAtmtCmt, String[] atmtLegNumber, String[] legAtmtCmtType, String[] legAtmtCmt, HttpServletRequest request,String serviceType,boolean tpFlag) {
		DealRequest deal = getCurrentDeal(request);
		List<AttachmentTypeComments> dealList = deal.getAttachmentTypeComments();
		if (dealAtmtCmtType != null) {
			int dealCmtLength = dealAtmtCmtType.length;
			for (int i = 0; i < dealCmtLength; i++) {
				AttachmentTypeComments dealCmtObj = null;
				int cmtType = Integer.valueOf(dealAtmtCmtType[i]);
				String cmt = dealAtmtCmt[i];
				dealCmtObj = getCheckExistForDealType(cmtType, dealList, dealCmtObj, cmt);
				if (dealCmtObj != null && cmt.trim().equals("")) {
					clearDealTypeComments(cmtType, dealList, dealCmtObj, cmt);
					dealCmtObj = null;
				}
				if (!cmt.trim().equals("")) {
					if (dealCmtObj == null) {
						if(cmt!=null && cmt.length()>0) { // this section will be removed in future
							if(cmt.contains("<span>")) {
								cmt = cmt.replaceAll("<span>", "");
								cmt = cmt.replaceAll("</span>", "");
								cmt = cmt.trim();
							}
							}
						dealCmtObj = new AttachmentTypeComments();
						dealCmtObj.setAttachmentTypeId(cmtType);
						dealCmtObj.setComments(cmt);
						dealCmtObj.setCommentOpcode(serviceType);
						dealList.add(dealCmtObj);
						dealCmtObj = null;
					}
				}

			}
		}
		
		// Updating leg level attachment comments
		if (atmtLegNumber != null) {
			Set<String> localSet = new HashSet<String>(Arrays.asList(atmtLegNumber));
			for (int index = 0; index < atmtLegNumber.length; index++) {
				localSet.add(atmtLegNumber[index]);
			}
			Iterator<String> iter = localSet.iterator();
			while (iter.hasNext()) {
				String obj = (String) iter.next();
				if (obj != null) {
					updateAllLegAttachmentComments(obj, atmtLegNumber,legAtmtCmtType, legAtmtCmt, request, serviceType,tpFlag);
					
					
				}
			}
		}
		
	}
	
	/**
	 * Method used to clear the deal type comments
	 * @param cmtType
	 * @param dealList
	 * @param dealObj
	 * @param cmt
	 */
	
	private static void clearDealTypeComments(int cmtType,
			List<AttachmentTypeComments> dealList,
			AttachmentTypeComments dealObj, String cmt) {
		for(int j=0;j<dealList.size();j++) {
			if(dealList.get(j).getCommentId()!=null && dealList.get(j).getAttachmentTypeId()==cmtType) {
				dealObj = dealList.get(j);
				dealObj.setAttachmentTypeId(cmtType);
				dealObj.setComments("");
				dealObj.setCommentOpcode(UPDATE);
				
			} else if(dealList.get(j).getCommentId()==null && dealList.get(j).getAttachmentTypeId()==cmtType) {
				dealObj = dealList.get(j);
				dealObj.setAttachmentTypeId(cmtType);
				dealObj.setComments("");
				dealObj.setCommentOpcode(UPDATE);
				
			}
		}
	}
	
	/**
	 *  Method used to check weather comments is already exist for deal type.
	 * If exist and not in the service it will insert comments
	 * If exist and in the service it will update comments
	 * @param cmtType
	 * @param dealList
	 * @param dealCmtObj
	 * @param cmt
	 * @return
	 */
	private static AttachmentTypeComments getCheckExistForDealType(int cmtType,
			List<AttachmentTypeComments> dealList,AttachmentTypeComments dealCmtObj,String cmt) {
		for(int j=0;j<dealList.size();j++) {
			if(dealList.get(j).getCommentId()!=null && dealList.get(j).getAttachmentTypeId()==cmtType) {
				dealCmtObj = dealList.get(j);
				dealCmtObj.setAttachmentTypeId(cmtType);
				dealCmtObj.setComments(cmt);
				dealCmtObj.setCommentOpcode(UPDATE);
				break;
			} else if(dealList.get(j).getCommentId()==null && dealList.get(j).getAttachmentTypeId()==cmtType) {
				dealCmtObj = dealList.get(j);
				dealCmtObj.setAttachmentTypeId(cmtType);
				dealCmtObj.setComments(cmt);
				dealCmtObj.setCommentOpcode(INSERT);
				break;
			}
		}
		return dealCmtObj;
	}
	/**
	 * Method used to update All Leg attachment comment base on the leg
	 * Its also have internal helper methods to identify exist or not exist
	 * Based on exist it will update/insert comments.
	 * 
	 * @param currentLegNum
	 * @param atmtLegNumber
	 * @param legAtmtCmtType
	 * @param legAtmtCmt
	 * @param request
	 * @param serviceType
	 */
	public static void updateAllLegAttachmentComments(String currentLegNum,
		String[] atmtLegNumber, String[] legAtmtCmtType,
		String[] legAtmtCmt, HttpServletRequest request, String serviceType,boolean tpFlag) {
		
		int legCmtLength = atmtLegNumber.length;
		List<AttachmentTypeComments> legCommentsList = null;
		for (int i = 0; i < legCmtLength; i++) {
			AttachmentTypeComments legCmtObj = null;
			if(atmtLegNumber[i]!=null && !atmtLegNumber[i].equals("") && currentLegNum!=null && !currentLegNum.equals("")) {
			int legNumber = Integer.valueOf(atmtLegNumber[i]);
			int currentLegNo = Integer.valueOf(currentLegNum);

			if (currentLegNo == legNumber) {
				Object legObj = getLegByNumber(legNumber, request);
				legCommentsList = getAttachmentCommentsByLeg(legObj, request);
				int legCmtType = Integer.valueOf(legAtmtCmtType[i]);
				String legCmt = legAtmtCmt[i];
				if(legCmt!=null && legCmt.length()>0) {
					if(legCmt.contains("<span>")) {
						legCmt = legCmt.replaceAll("<span>", "");
						legCmt = legCmt.replaceAll("</span>", "");
						legCmt = legCmt.trim();
					}
				}
				
				legCmtObj = getCheckExistForLegObjType(legCmtType, legCommentsList, legCmtObj, legCmt);
				if (legCmtObj != null && legCmt.trim().equals("") && legCmtObj.getCommentId()!=null) {
					clearLegTypeComments(legCmtType, legCommentsList,legCmtObj, legCmt);
					legCmtObj = null;
				}
				if (legCmt!=null && !legCmt.trim().equals("") && legCommentsList!=null) {
					if (legCmtObj == null) {
						if(legCmt!=null && legCmt.length()>0) {
							if(legCmt.contains("<span>")) {
								legCmt = legCmt.replaceAll("<span>", "");
								legCmt = legCmt.replaceAll("</span>", "");
								legCmt = legCmt.trim();
							}
						}
						legCmtObj = new AttachmentTypeComments();
						legCmtObj.setAttachmentTypeId(legCmtType);
						legCmtObj.setComments(legCmt);
						legCmtObj.setCommentOpcode(INSERT);
						legCommentsList.add(legCmtObj);
						legCmtObj = null;
					}
				}
				if(legCommentsList!=null && legCommentsList.size()>0) {
					for(int update=0;update<legCommentsList.size();update++) {
						AttachmentTypeComments attachmentTypeComments = legCommentsList.get(update);
						if(attachmentTypeComments.getCommentOpcode()!=null) {
							setOpCodeForAttachmentComments(legObj,tpFlag);
						}
					}
				}

			}
			}

		}

	}
	
	
	
	
	
/**
 * 
 * @param leg
 */
	public static void setOpCodeForAttachmentComments(Object leg,boolean tpFlag) {
		if(leg instanceof RCALegRequest) {
			if(((RCALegRequest) leg).getLegSummary().getLegSeqId()!=null) {
				if(tpFlag) {
					((RCALegRequest) leg).getLegSummary().setLegOpcode(TPUPDATE);
				} else {
					((RCALegRequest) leg).getLegSummary().setLegOpcode(UPDATE);
				}
			}
		} else if(leg instanceof CPALegRequest) {
			if(((CPALegRequest) leg).getCPASummary().getLegSeqId()!=null) {
				if(tpFlag) {
				((CPALegRequest) leg).getCPASummary().setCPALegOpcode(TPUPDATE);
				} else {
					((CPALegRequest) leg).getCPASummary().setCPALegOpcode(UPDATE);
				}
			}
		} else if(leg instanceof EquityLegRequest) {
			if(((EquityLegRequest) leg).getLegSummary().getLegSeqId()!=null) {
				((EquityLegRequest) leg).getLegSummary().setLegOpcode(UPDATE);
			}
		} else if(leg instanceof OtherLegRequest) {
			if(((OtherLegRequest) leg).getLegSummary().getLegSeqId()!=null) {
				if(tpFlag) {
					((OtherLegRequest) leg).getLegSummary().setLegOpcode(TPUPDATE);
				} else {
					((OtherLegRequest) leg).getLegSummary().setLegOpcode(UPDATE);	
				}
			}
		}
	}
	
	
	
	/**
	 * Method used to remove object if user clear the comments
	 * @param legCmtType
	 * @param legCommentsList
	 * @param legCmtObj
	 * @param legCmt
	 */
	private static void clearLegTypeComments(int legCmtType,
			List<AttachmentTypeComments> legCommentsList, AttachmentTypeComments legCmtObj,
			String legCmt) {
		for(int j=0;j<legCommentsList.size();j++) {
			if(legCommentsList.get(j).getCommentId()!=null && legCommentsList.get(j).getAttachmentTypeId()==legCmtType) {
			} else if(legCommentsList.get(j).getCommentId()==null && legCommentsList.get(j).getAttachmentTypeId()==legCmtType) {
				legCommentsList.remove(j);	
				
			}
		}
		
	}
	/**
	 * Method used to check weather comments is already exist for leg type,
	 * If exist and not in the service it will insert comments
	 * If exist and in the service it will update comments
	 * @param legCmtType
	 * @param legCommentsList
	 * @param legCmtObj
	 * @param legCmt
	 * @return
	 */
	private static AttachmentTypeComments getCheckExistForLegObjType(
			int legCmtType, List<AttachmentTypeComments> legCommentsList,
			AttachmentTypeComments legCmtObj, String legCmt) {
		if(legCommentsList!=null){
			for(int j=0;j<legCommentsList.size();j++) {
				if(legCommentsList.get(j).getCommentId()!=null && legCommentsList.get(j).getAttachmentTypeId()==legCmtType) {
					legCmtObj = legCommentsList.get(j);
					legCmtObj.setAttachmentTypeId(legCmtType);
					legCmtObj.setComments(legCmt);
					legCmtObj.setCommentOpcode(UPDATE);
					break;
				} else if(legCommentsList.get(j).getCommentId()==null && legCommentsList.get(j).getAttachmentTypeId()==legCmtType) {
					legCmtObj = legCommentsList.get(j);
					legCmtObj.setAttachmentTypeId(legCmtType);
					legCmtObj.setComments(legCmt);
					legCmtObj.setCommentOpcode(INSERT);
					break;
				}
			}
		}
		return legCmtObj;
	}
	
	
	/**
	 * Method used to return the list of attachment comments for specific leg type
	 * @param leg
	 * @param request
	 * @return
	 */
	public static List<AttachmentTypeComments> getAttachmentCommentsByLeg(Object leg, HttpServletRequest request) {
		if(leg instanceof RCALegRequest) {
			RCALegRequest rcaLeg = (RCALegRequest) leg;
			return rcaLeg.getLegSummary().getAttachmentTypeComments();
		} else if(leg instanceof EquityLegRequest) {
			EquityLegRequest equityLeg = (EquityLegRequest) leg;
			return equityLeg.getLegSummary().getAttachmentTypeComments();
		} else if(leg instanceof OtherLegRequest) {
			OtherLegRequest otherLeg = (OtherLegRequest) leg;
			return otherLeg.getLegSummary().getAttachmentTypeComments();
		} else if(leg instanceof CPALegRequest) {
			CPALegRequest cpaLeg = (CPALegRequest) leg;
			return cpaLeg.getCPASummary().getAttachmentTypeComments();
		}
		return null;
	}
	
	
	/**
	 * All added AdditionalApprovers populated to deal
	 * @param request
	 * @param updateStatus
	 * @param deal
	 */
	@SuppressWarnings("unchecked")
	public static void populateAdditionalApprovers(HttpServletRequest request,UpdateStatus updateStatus, DealRequest deal) {
				
		List<UserInfo> deleteUserInfos  = (List<UserInfo>) request.getSession().getAttribute(DELETEUSERINFOLIST);
		List<UserInfo> userInfoList = (List<UserInfo>) request.getSession().getAttribute(CURRENTUSERINFOLIST);
		List<AdditionalApprovals> additionalApprovals = new ArrayList<AdditionalApprovals>();
		String appFlag=null;
		
		if(userInfoList!=null && userInfoList.size()>0 ){
			String opCode = INSERT;
			appFlag = ONE;
			additionalApprovals=addAdditionalApprovers(updateStatus, userInfoList, opCode, appFlag,additionalApprovals);
			
		}		
		if((deleteUserInfos!=null) && (deleteUserInfos.size()>0)){
			String opCode = DELETE;
			additionalApprovals=addAdditionalApprovers(updateStatus, deleteUserInfos, opCode, appFlag,additionalApprovals);
		}		
		if((additionalApprovals!=null) && (additionalApprovals.size()>0)){
			updateStatus.setAddiAppFlag(appFlag);
			updateStatus.setAdditionalApprovals(additionalApprovals);
			
		}
		
	}
	/**
	 * All added AdditionalApprovers populated to deal
	 * @param request
	 * @param updateStatus
	 * @param deal
	 */
	@SuppressWarnings("unchecked")
	public static void populateBusinessApprovers(HttpServletRequest request,UpdateStatus updateStatus, DealRequest deal) {
		
		List<BusinessApprovers> deleteBusinessApprovers  = (List<BusinessApprovers>) request.getSession().getAttribute(DELETEBUSINESSAPPROVERS);
		List<BusinessApprovers> addedApproversList = (List<BusinessApprovers>) request.getSession().getAttribute(CURRENTBUSINESSAPPROVERS);
		List<BusinessApprovers> businessApprovals = new ArrayList<BusinessApprovers>();
		String appFlag=null;
		
		if(addedApproversList!=null && addedApproversList.size()>0 ){
			
			businessApprovals=addBusinessApprovers(businessApprovals, addedApproversList);
			
		}		
		if((deleteBusinessApprovers!=null) && (deleteBusinessApprovers.size()>0)){
			
			businessApprovals=addBusinessApprovers(businessApprovals, deleteBusinessApprovers);
		}		
		if((businessApprovals!=null) && (businessApprovals.size()>0)){
			appFlag = ONE;
			updateStatus.setAddiAppFlag(appFlag);
			updateStatus.setBusinessApprovers(businessApprovals);
			
		}
		
	}

	
	
	
	/**
	 * addAdditionalApprovers
	 * @param updateStatus
	 * @param userInfos
	 * @param opCode
	 * @param additionalApprovals
	 */
	public static List<AdditionalApprovals> addAdditionalApprovers(UpdateStatus updateStatus,
			List<UserInfo> userInfos, String opCode, String appFlag,List<AdditionalApprovals> additionalApprovals) {
		for(int i =0;i<userInfos.size();i++){
			UserInfo userInfo = (UserInfo) userInfos.get(i);
			AdditionalApprovals additionalApprover = new AdditionalApprovals();
			additionalApprover.setSSOId(userInfo.getSsoId());
			additionalApprover.setFirstName(userInfo.getFirstName());
			additionalApprover.setLastName(userInfo.getLastName());
			additionalApprover.setOpCode(opCode);
			additionalApprovals.add(additionalApprover);
		}
		return additionalApprovals;
		
		
	}
	/**
	 * businessApprovers
	 * @param businessApprovals
	 * @param totalBusinessApprovals
	 * 
	 */
	public static List<BusinessApprovers> addBusinessApprovers(List<BusinessApprovers> businessApprovals,List<BusinessApprovers> totalBusinessApprovals) {
		for(int i =0;i<totalBusinessApprovals.size();i++){
			BusinessApprovers ba = (BusinessApprovers) totalBusinessApprovals.get(i);
			businessApprovals.add(ba);
		}
		return businessApprovals;
	}
	
	/**
	 * Returns number of non deleted legs in the request.
	 * @param request
	 * @return
	 */
	public static int getLegCount(HttpServletRequest request) {
		DealRequest dealRequest = getCurrentDeal(request);
		return ICFPCommonHelper.getLegCount(dealRequest);
	}
	
	/**
	 * method used to sync deal to update status object for meta information with gelib
	 * @param dealRequest
	 * @param updateStatus
	 * @param request
	 * @return
	 */
	public static DealRequest syncPropertiesforMeta(DealRequest dealRequest,UpdateStatus updateStatus,HttpServletRequest request) {
		StaticDataFactory statData = (StaticDataFactory) request.getSession().getServletContext().getAttribute(StaticDataFactory.CTX_KEY);
		if (updateStatus.getFourBlocker() != null) {
			if (updateStatus.getFourBlocker().getProjectSummary() != null
					&& updateStatus.getFourBlocker().getProjectSummary().getDealName() != null) {
				dealRequest.setDealName(updateStatus.getFourBlocker().getProjectSummary().getDealName());
			}
			if (updateStatus.getFourBlocker().getTPriorityTimings() != null
					&& updateStatus.getFourBlocker().getTPriorityTimings().getRegionResponsibility() != null)
				dealRequest.setResponsibleRegionId(Integer.valueOf(updateStatus.getFourBlocker().getTPriorityTimings().getRegionResponsibility()));
			Iterator<NameValue> dealCategoriesItr = statData.getDealCategories().iterator();
			if (updateStatus.getFourBlocker().getProjectSummary() != null
					&& updateStatus.getFourBlocker().getProjectSummary().getDealCategory() != null) {
			while (dealCategoriesItr.hasNext()) {
				NameValue category = dealCategoriesItr.next();
				if (category.getName().equalsIgnoreCase(
						updateStatus.getFourBlocker().getProjectSummary().getDealCategory())) {
						dealRequest.setDealCategoryId(category.getID());
						return dealRequest;
				}
			}
			}
		}
		return dealRequest;
	}
}
