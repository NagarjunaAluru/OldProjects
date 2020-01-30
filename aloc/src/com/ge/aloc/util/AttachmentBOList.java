/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: AttachmentBOList.java
 * Purpose: AttachmentBOList used for attachment operations
 */
package com.ge.aloc.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.ge.aloc.AttachmentType;
import com.ge.aloc.bo.AttachmentBO;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.model.Attachment;

/**
 * 
 * @author chaitanya.n
 *
 */
public class AttachmentBOList extends ArrayList<AttachmentBO> implements List<AttachmentBO> {

	private static final long serialVersionUID = 2753043156149217865L;

	private List<Attachment> attachmentList;

	/**
	 * This is to set the attachemnts list to BO object
	 * @param attachmentList
	 */
	public AttachmentBOList(List<Attachment> attachmentList) {
		super();
		this.attachmentList = attachmentList;
		for(Attachment attachment : attachmentList) {
			super.add(new AttachmentBO(attachment));
		}
	}

	/**
	 *This is used to add atatchmentBo object to the atatchmentList
	 */
	@Override
	public boolean add(AttachmentBO attachmentBO) {
		this.attachmentList.add(attachmentBO.getModel());
		return super.add(attachmentBO);
	}

	/**
	 * This is used to add atatchmentBo object to the atatchmentList
	 */
	@Override
	public void add(int index, AttachmentBO attachmentBO) {
		Attachment attachment = (attachmentBO != null) ? attachmentBO.getModel() : null;
		attachmentList.add(index, attachment);
		super.add(index, attachmentBO);
	}

	/**
	 * This is used to addAll AttachmentBO objects
	 */
	@Override
	public boolean addAll(Collection<? extends AttachmentBO> c) {
		throw new UnsupportedOperationException(ALOCConstants.OPERATION_NOT_SUPPORT_BY_COLLECTION);
	}

	/**
	 *This is used to remove object from attachmentList
	 */
	@Override
	public boolean remove(Object o) {
		if(o != null && o instanceof AttachmentBO) {
			this.attachmentList.remove(((AttachmentBO) o).getModel());
			return super.remove(o);
		} else {
			this.attachmentList.remove(o);
			return super.remove(o);
		}
	}

	/**
	 *This is used to remove object from attachmentList
	 */
	@Override
	public AttachmentBO remove(int index) {
		attachmentList.remove(index);
		return super.remove(index);
	}

	/**
	 * This is used to clear the list
	 */
	@Override
	public void clear() {
		attachmentList.clear();
		super.clear();
	}

	/**
	 * This is used to set the AttachmentBO to the list
	 */
	@Override
	public AttachmentBO set(int index, AttachmentBO attachmentBO) {
		Attachment attachment = (attachmentBO != null) ? attachmentBO.getModel() : null;
		attachmentList.set(index, attachment);
		return super.set(index, attachmentBO);
	}

	/**
	 *This is used to get the AttachmentList 
	 * @return
	 */
	public List<Attachment> getAttachmentList() {
		return this.attachmentList;
	}

	/**
	 * This is used to get the AttachmentBOList 
	 * @param types
	 * @return
	 */
	public List<AttachmentBO> getAttachmentBOs(AttachmentType... types) {
		List<AttachmentBO> result = new ArrayList<AttachmentBO>();
		List<AttachmentType> typeList = Arrays.asList(types);
		for(Iterator<AttachmentBO> attachmentBOItr = iterator(); attachmentBOItr.hasNext(); ) {
			AttachmentBO attachmentBO = attachmentBOItr.next();
			AttachmentType attachmentType = attachmentBO.getAttachmentType();
			if(attachmentType != null && typeList.contains(attachmentType)) {
				result.add(attachmentBO);
			}
		}
		return result;
	}

	/**
	 * This is used to get the AttachmentList 
	 * @param types
	 * @return
	 */
	public List<Attachment> getAttachments(AttachmentType... types) {
		List<Attachment> result = new ArrayList<Attachment>();
		List<AttachmentType> typeList = Arrays.asList(types);
		for(Iterator<AttachmentBO> attachmentBOItr = iterator(); attachmentBOItr.hasNext(); ) {
			AttachmentBO attachmentBO = attachmentBOItr.next();
			AttachmentType attachmentType = attachmentBO.getAttachmentType();
			if(attachmentType != null && typeList.contains(attachmentType)) {
				result.add(attachmentBO.getModel());
			}
		}
		return result;
	}
}
