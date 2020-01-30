/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: DealAdapter.java
 * Purpose: Represents Attachment DealAdapter for all attachments and comments
 */
package com.ge.icfp.common.attachments.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ge.icfp.common.attachments.AttachmentUtils;
import com.ge.icfp.common.attachments.DealPermissions;
import com.ge.icfp.common.attachments.ICFPAttachmentException;
import com.ge.icfp.common.helper.ICFPCommonHelper;
import com.ge.icfp.model.DealRequest;


/**
 * Common class for Attachment deal validator for all attachments and comment
 * @author chaitanya.n
 *
 */

public class DealAdapter extends ValidationAdapter {
	
	/**
	 * Common Attachment validator for all attachments and comments
	 * @param deal
	 */
	public DealAdapter(DealRequest deal, DealPermissions dealPermissions) {
		super(deal, dealPermissions, deal.getAttachments(), deal.getAttachmentTypeComments());
	}
	
	/**
	 *  Method used to retrieve the list of leg adapter
	 * @return
	 * @throws ICFPAttachmentException 
	 */
	public List<LegAdapter> getLegs() throws ICFPAttachmentException {
		List<LegAdapter> legAdaptersList = new ArrayList<LegAdapter>();
		Map<Integer, Object> legsWithIndexes = AttachmentUtils.getAllAttachmentLegsWithIndexes(deal);
		for(Map.Entry<Integer, Object> legEntry : legsWithIndexes.entrySet()) {
			legAdaptersList.add(new LegAdapter(legEntry.getKey(), legEntry.getValue(), deal, dealPermissions));
		}
		return legAdaptersList;
	}
	
	/**
	 *  Method used to return true if deal have CPA leg
	 * @return
	 */
	public boolean isCPA() {
		Boolean isCPA = ICFPCommonHelper.isCPADeal(deal);
		return (isCPA != null) ? isCPA : false; // Consider as non CPA even there is no legs
	}
}
