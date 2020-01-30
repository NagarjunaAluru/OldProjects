/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: AttachmentViewFunctions.java
 * AttachmentViewFunctions used for utilities for tags and UI
 * 
 * 
 */
package com.ge.icfp.common.attachments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import com.ge.icfp.action.ICFPException;
import com.ge.icfp.common.helper.CurrentDealManager;
import com.ge.icfp.common.helper.ICFPCommonHelper;
import com.ge.icfp.common.helper.ICFPLegHelper;
import com.ge.icfp.common.vo.CPALegSummaryVO;
import com.ge.icfp.common.vo.LegSummaryVO;
import com.ge.icfp.model.Attachment;
import com.ge.icfp.model.AttachmentTypeComments;
import com.ge.icfp.model.CPASummary;
import com.ge.icfp.model.DealRequest;
import com.ge.icfp.model.DerivativesRequest;
import com.ge.icfp.model.ExceptionRequestForm;
import com.ge.icfp.model.LegSummary;
import com.ge.icfp.util.Utils;

/**
 * This class used for view utilities which can helps for tags rendering
 * @author chaitanya.n
 *
 */
public class AttachmentViewFunctions {
	
	/**
	 * This Method gives the deal attachments like cashmap,structure etc by providing product type of current request object
	 * @param typeId
	 * @param request
	 * @return
	 */
	public static List<Attachment> getDealAttachments(Integer typeId, HttpServletRequest request) {
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		return AttachmentUtils.searchAttachmentByType(AttachmentType.fromId(typeId), deal.getAttachments());
	}
	
	/**
	 * This Method gives the list of leg attachments like legal,consolidated,journal,other etc 
	 *  by providing attachment type and legindex of current request object
	 * @param typeId
	 * @param legIndex
	 * @param request
	 * @return
	 * @throws ICFPAttachmentException
	 */
	public static List<Attachment> getLegAttachments(Integer typeId, Integer legIndex, HttpServletRequest request) throws ICFPAttachmentException {
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		Object leg = AttachmentUtils.getLeg(legIndex, deal);
		Object legSummary = ICFPLegHelper.getLegSummary(leg);
		List<Attachment> legAttachments = (legSummary instanceof CPASummary) 
				? ((CPASummary) legSummary).getAttachments() : ((LegSummary) legSummary).getAttachments();
		return AttachmentUtils.searchAttachmentByType(AttachmentType.fromId(typeId), legAttachments);
	}
	
	/**
	 * This Method gives the Map Object which holds leg index as key and leg summary as value 
	 * to get comments and attachments of current request object
	 * @param request
	 * @return
	 */
	public static Map<Long, Object> getAttachmentLegsWithIndexes(HttpServletRequest request) {
		Map<Long, Object> result = new LinkedHashMap<Long, Object>();
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		Map<Integer, Object> legsWithIndexes = AttachmentUtils.getAllAttachmentLegsWithIndexes(deal);
		for(Map.Entry<Integer, Object> eachLeg : legsWithIndexes.entrySet()) {
			result.put(new Long(eachLeg.getKey()), eachLeg.getValue());
		}
		return result;
	}
	
	/**
	 * This Method is the helper method to get the legs information of current request object other than CPA
	 * @param request
	 * @return
	 */
	public static List<LegSummaryVO> getLegSummaryVOs(HttpServletRequest request) {
		List<LegSummaryVO> result = new ArrayList<LegSummaryVO>();
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		Integer[] indexes = AttachmentUtils.getAllAttachmentLegIndexes(deal);
		Object leg = null;
		for(Integer legIndex : indexes) {
			leg = ICFPCommonHelper.getLegByNumber(legIndex, deal);
			result.add(new LegSummaryVO(legIndex, (LegSummary)ICFPLegHelper.getLegSummary(leg), request));
		}
		return result;
	}
	
	/**
	 * This Method is the helper method to get the legs information of current request object for CPA
	 * @param request
	 * @return
	 */
	public static List<CPALegSummaryVO> getCPALegSummaryVOs(HttpServletRequest request) {
		List<CPALegSummaryVO> result = new ArrayList<CPALegSummaryVO>();
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		Integer[] indexes = AttachmentUtils.getAllAttachmentLegIndexes(deal);
		Object leg = null;
		for(Integer legIndex : indexes) {
			leg = ICFPCommonHelper.getLegByNumber(legIndex, deal);
			result.add(new CPALegSummaryVO(legIndex, (CPASummary)ICFPLegHelper.getLegSummary(leg), null,null,null));
		}
		return result;
	}
	
	/**
	 * This Method used to get the list of derivatives by providing the leg index of current leg request
	 * @param legIndex
	 * @param request
	 * @return
	 * @throws ICFPAttachmentException 
	 */
	public static List<DerivativesRequest> getDerivatives(Integer legIndex, HttpServletRequest request) throws ICFPAttachmentException {
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		Object leg = AttachmentUtils.getLeg(legIndex, deal);
		List<DerivativesRequest> derivatives = ICFPLegHelper.getDerivatives(leg);
		return derivatives;
	}
	
	/**
	 *  This Method used to get the list of Exceptions by providing the leg index of current leg request
	 * @param legIndex
	 * @param request
	 * @return
	 * @throws ICFPAttachmentException
	 */
	public static List<ExceptionRequestForm> getExceptions(Integer legIndex, HttpServletRequest request) throws ICFPAttachmentException {
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		Object leg = AttachmentUtils.getLeg(legIndex, deal);
		List<ExceptionRequestForm> exceptions = ICFPLegHelper.getExceptions(leg);
		return exceptions;
	}
	
	/**
	 * This Method used to get the list of derivatives by providing the leg index and derivative index of current derivative request
	 * @param derivativeIndex
	 * @param legIndex
	 * @param request
	 * @return
	 * @throws ICFPAttachmentException
	 */
	public static List<Attachment> getDerivativeAttachments(Integer derivativeIndex, Integer legIndex, HttpServletRequest request) throws ICFPAttachmentException {
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		Object leg = AttachmentUtils.getLeg(legIndex, deal);
		DerivativesRequest derivative = AttachmentUtils.getDerivativeRequest(derivativeIndex, leg);
		return derivative.getAttachments();
	}
	
	/**
	 * This Method used to get the all deal attachment type comments to retrieve comments by attachment typeID
	 * @param commentType
	 * @param request
	 * @return
	 */
	public static Map<Long, String> getAllDealAttachmentTypeComments(HttpServletRequest request) {
		Map<Long, String> result = new HashMap<Long, String>();
		DealRequest dealRequest = CurrentDealManager.getCurrentDeal(request);
		List<AttachmentTypeComments> allAtmtComments = dealRequest.getAttachmentTypeComments();
		for(AttachmentTypeComments comment : allAtmtComments) {
			result.put(new Long(comment.getAttachmentTypeId()), comment.getComments());
		}
		return result;
	}
	
	/**
	 * This Method used to get the all leg attachment type comments to retrieve comments by attachment typeID of current leg
	 * @param legNumber
	 * @param commentType
	 * @param request
	 * @return
	 * @throws ICFPException 
	 */
	public static Map<Long, String> getLegAllAttachmentTypeComments(Integer legIndex, HttpServletRequest request) throws ICFPException {
		Map<Long, String> result = new HashMap<Long, String>();
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		Object leg = AttachmentUtils.getLeg(legIndex, deal);
		Object legSummary = ICFPLegHelper.getLegSummary(leg);
		@SuppressWarnings("unchecked")
		List<AttachmentTypeComments> allLegAttachmentComments = Utils.fetchPropertyValue("attachmentTypeComments", legSummary, List.class);
		for(AttachmentTypeComments comment : allLegAttachmentComments) {
			result.put(new Long(comment.getAttachmentTypeId()), comment.getComments());
		}
		return result;
	}
	
	/**
	 * This Method used to get the all legs attachment type comments to retrieve comments for current request
	 * @param request
	 * @return
	 * @throws ICFPException
	 */
	public static Map<Long, Map<Long, String>> getAllLegsAllAttachmentTypeComments(HttpServletRequest request) throws ICFPException {
		Map<Long, Map<Long, String>> result = new HashMap<Long, Map<Long,String>>();
		Map<Long, Object> indexToLegMap = getAttachmentLegsWithIndexes(request);
		for(Entry<Long, Object> eachLegEntry : indexToLegMap.entrySet()) {
			Map<Long, String> legAttachmentTypeComments = new HashMap<Long, String>();
			Object legSummary = ICFPLegHelper.getLegSummary(eachLegEntry.getValue());
			@SuppressWarnings("unchecked")
			List<AttachmentTypeComments> allLegAttachmentComments = Utils.fetchPropertyValue("attachmentTypeComments", legSummary, List.class);
			for(AttachmentTypeComments comment : allLegAttachmentComments) {
				legAttachmentTypeComments.put(new Long(comment.getAttachmentTypeId()), comment.getComments());
			}
			result.put(eachLegEntry.getKey(), legAttachmentTypeComments);
		}
		return result;
	}
	
	
	/**
	 * This Method used to get the underwriting file name format i.e businss requestid-Underwriting_File.pdf format
	 * @param request
	 * @return
	 */
	public static String getUnderWritingFileName(HttpServletRequest request) {
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		StringBuilder name = new StringBuilder();
		if(deal.getBusinessRequestId() != null) {
			name.append(deal.getBusinessRequestId()).append("-");
		}
		name.append("Underwriting_File.pdf");
		return name.toString();
	}
	
	
	
	/**
	 * This method give the permission object for particular attachment type of current request
	 * @param attachmentType
	 * @param request
	 * @return
	 * @throws ICFPAttachmentException 
	 */
	public static AttachmentPermissions getAttachmentPermissions(Integer attachmentType, HttpServletRequest request) throws ICFPAttachmentException {
		AttachmentPermissions permissions = AttachmentSecurity.getInstance().getDealLevelPermissions(AttachmentType.fromId(attachmentType), request);
		return permissions;
	}
	
	/**
	 * This method give the permission object for particular attachment type of current leg request
	 * @param attachmentType
	 * @param legIndex
	 * @param request
	 * @return
	 * @throws ICFPAttachmentException 
	 */
	public static AttachmentPermissions getLegAttachmentPermissions(Integer attachmentType, Integer legIndex, HttpServletRequest request) throws ICFPAttachmentException {
		AttachmentPermissions permissions = AttachmentSecurity.getInstance().getLegLevelPermissions(AttachmentType.fromId(attachmentType), legIndex, request);
		return permissions;
	}
	
	/**
	 * This method give the deal permission for attachments/comments
	 * @param request
	 * @return
	 */
	public static DealPermissions getDealPermissions(HttpServletRequest request) {
		return AttachmentSecurity.getDealPermissions(request);
	}
	
	/**
	 * This method used to convert Integer object to Long object value
	 * @param value
	 * @return
	 */
	public static Long toLong(Integer value) {
		return (value != null) ? Long.valueOf(value.longValue()) : null;
	}
	
	/**
	 * 
	 * @param legIndex
	 * @param request
	 * @return
	 * @throws ICFPException
	 */
	public static int getLegPageAttachmentsCount(Integer legIndex, HttpServletRequest request) throws ICFPException {
		int count = 0;
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		List<Attachment> allAttachments = new ArrayList<Attachment>();
		allAttachments.addAll(deal.getAttachments());
		Object leg = AttachmentUtils.getLeg(legIndex, deal);
		allAttachments.addAll(AttachmentUtils.getAllLegAttachments(leg));
		for(AttachmentType type: AttachmentType.LEGPAGE_ATMT_TYPES) {
			count += AttachmentUtils.searchAttachmentByType(type, allAttachments).size();
		}
		return count;
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 * @throws ICFPException
	 */
	public static int getDealPageAttachmentsCount(HttpServletRequest request) throws ICFPException {
		int count = 1; // Need to start with 1 to consider UnderWriting file.
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		List<Attachment> allAttachments = AttachmentUtils.getAllAttachments(deal);
		for(AttachmentType type : AttachmentType.DEALPAGE_ATMT_TYPES) {
			count += AttachmentUtils.searchAttachmentByType(type, allAttachments).size();
		}
		return count;
	}
}
