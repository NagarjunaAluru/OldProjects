/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: LegAdapter.java
 * Purpose: Represents Attachment LegAdapter for all attachments and comments
 */
package com.ge.icfp.common.attachments.validation;

import java.util.List;
import java.util.Map;

import com.ge.icfp.common.attachments.AttachmentUtils;
import com.ge.icfp.common.attachments.DealPermissions;
import com.ge.icfp.common.attachments.ICFPAttachmentException;
import com.ge.icfp.common.helper.ICFPLegHelper;
import com.ge.icfp.model.AttachmentTypeComments;
import com.ge.icfp.model.CPASummary;
import com.ge.icfp.model.DealRequest;
import com.ge.icfp.model.LegSummary;
import com.ge.icfp.util.ProductType;

/**
 * Class for leg adapter to perform validations for leg level
 * @author chaitanya.n
 *
 */
public class LegAdapter extends ValidationAdapter {
	
	/**
	 * Method used to returns the List of comments for particular leg
	 * @param leg
	 * @return
	 */
	private static List<AttachmentTypeComments> fetchComments(Object leg) {
		Object legSummary = ICFPLegHelper.getLegSummary(leg);
		List<AttachmentTypeComments> comments = (legSummary instanceof CPASummary) 
				? ((CPASummary) legSummary).getAttachmentTypeComments() : ((LegSummary) legSummary).getAttachmentTypeComments();
		return comments;
	}
	
	/**
	 * Method used to get index of leg in the current deal object
	 * @param deal
	 * @param leg
	 * @return
	 */
	private static int getIndexOfLeg(DealRequest deal, Object leg) {
		int legNumber = 0;
		// Fetching legIndex;
		Map<Integer, Object> allLegsWithIndex = AttachmentUtils.getAllAttachmentLegsWithIndexes(deal);
		for(Map.Entry<Integer, Object> eachLeg : allLegsWithIndex.entrySet()) {
			if(eachLeg.getValue() == leg) {
				legNumber = eachLeg.getKey();
			}
		}
		return legNumber;
	}
	
	private Object leg;
	private int legIndex;
	private Object legSummary;
	private ProductType productType;
	
	/**
	 * 
	 * @param leg
	 * @param deal
	 * @throws ICFPAttachmentException 
	 */
	LegAdapter(Object leg, DealRequest deal, DealPermissions dealPermissions) throws ICFPAttachmentException {
		this(getIndexOfLeg(deal, leg), leg, deal, dealPermissions);
	}
	
	/**
	 *  Create the leg adapter class to perform the permissions
	 * @param leg
	 * @param deal
	 * @throws ICFPAttachmentException 
	 */
	LegAdapter(int legIndex, Object leg, DealRequest deal, DealPermissions dealPermissions) throws ICFPAttachmentException {
		super(deal, dealPermissions, ICFPLegHelper.getAttachments(leg), fetchComments(leg));
		this.leg = leg;
		this.legSummary = ICFPLegHelper.getLegSummary(leg);
		Integer productTypeId = (legSummary instanceof CPASummary) ? ((CPASummary) legSummary).getLegTypeId() : ((LegSummary) legSummary).getLegTypeId();
		this.productType = ProductType.fromId(productTypeId);
		this.legIndex = legIndex;
	}
	
	/**
	 * @return the leg
	 */
	public Object getLeg() {
		return leg;
	}

	/**
	 * 
	 * @return
	 */
	public ProductType getProductType() {
		return productType;
	}

	/**
	 * @return the legIndex
	 */
	public int getLegIndex() {
		return legIndex;
	}
}
