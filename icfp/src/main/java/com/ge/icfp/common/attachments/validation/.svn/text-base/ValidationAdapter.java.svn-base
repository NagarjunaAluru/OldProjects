/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: ValidationAdapter.java
 * Purpose: Represents abstract class for other adapter like deal and leg
 */
package com.ge.icfp.common.attachments.validation;

import jarjar.orgapachecommonslang.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ge.icfp.common.attachments.AttachmentType;
import com.ge.icfp.common.attachments.DealPermissions;
import com.ge.icfp.model.Attachment;
import com.ge.icfp.model.AttachmentTypeComments;
import com.ge.icfp.model.DealRequest;

/**
 * 
 * Create the main validation adapter class which will have all deal and leg permissions
 * @author chaitanya.n
 */
public abstract class ValidationAdapter {
	protected DealRequest deal;
	protected DealPermissions dealPermissions;
	private Map<AttachmentType, AttachmentTypeComments> typeToCommentsMap;
	private Map<AttachmentType, Attachment> typeToAttachmentsMap;
	
	/**
	 * 
	 * @param deal
	 * @param dealPermissions
	 * @param attachments
	 * @param comments
	 */
	protected ValidationAdapter(DealRequest deal, DealPermissions dealPermissions, List<Attachment> attachments, List<AttachmentTypeComments> comments) {
		this.deal = deal;
		this.dealPermissions = dealPermissions;
		
		this.typeToAttachmentsMap = new HashMap<AttachmentType, Attachment>();
		if(!attachments.isEmpty()) {
			for(Attachment attachment : attachments) {
				typeToAttachmentsMap.put(AttachmentType.fromId(attachment.getAttachmentTypeId()), attachment);
			}
		}
		
		this.typeToCommentsMap = new HashMap<AttachmentType, AttachmentTypeComments>();
		if(!comments.isEmpty()) {
			for(AttachmentTypeComments atComments :comments) {
				typeToCommentsMap.put(AttachmentType.fromId(atComments.getAttachmentTypeId()), atComments);
			}
		}
	}
	
	/**
	 * Method used to return attachment if attachment is provided for particular type
	 * @param type
	 * @return
	 */
	public Attachment getAttachment(AttachmentType type) {
		return typeToAttachmentsMap.get(type);
	}
	
	/**
	 * Method used to return true if attachment is provided for particular type
	 * @param type
	 * @return
	 */
	public boolean hasAttachment(AttachmentType type) {
		return (getAttachment(type) != null);
	}
	
	/**
	 * Method used to return comments  for particular attachment type
	 * @param type
	 * @return
	 */
	public AttachmentTypeComments getComment(AttachmentType type) {
		return typeToCommentsMap.get(type);
	}
	
	/**
	 *  Method used to return true if comment is provided for particular attachment type
	 * @param type
	 * @return
	 */
	public boolean hasComment(AttachmentType type) {
		AttachmentTypeComments comment = getComment(type);
		if(comment != null) {
			return StringUtils.isNotBlank(comment.getComments());
		}
		return false;
	}

	/**
	 * @return the deal
	 */
	public DealRequest getDeal() {
		return deal;
	}

	/**
	 * @return the dealPermissions
	 */
	public DealPermissions getDealPermissions() {
		return dealPermissions;
	}
}
