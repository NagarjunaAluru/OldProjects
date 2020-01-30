/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: AttachmentPermissions.java
 * Purpose: NewFundingRequestAction Class used to check weather deal/leg have read/editable/delete permissions
 */
package com.ge.icfp.common.attachments;

import java.util.Collection;

import com.ge.icfp.common.helper.ICFPCommonHelper;
import com.ge.icfp.model.DealRequest;
import com.ge.icfp.model.EquityLegRequest;

/**
 * 
 * Class used to check weather deal/leg have read/editable/delete permissions
 * @author hariprasad.madas
 *
 */
public class AttachmentPermissions {
	private DealPermissions dealPermissions;
	private AttachmentType attachmentType;
	private Object leg;
	
	private boolean deletable;
	private boolean editable;
	private boolean viewable;
	private boolean mandatory;
	
	private boolean freez;
	
	/**
	 * 
	 * @param attachmentType
	 * @param request
	 */
	AttachmentPermissions(AttachmentType attachmentType, DealPermissions dealPermissions) {
		this.attachmentType = attachmentType;
		this.dealPermissions = dealPermissions;
	}
	
	/**
	 * 
	 * @param attachmentType
	 * @param request
	 */
	AttachmentPermissions(AttachmentType attachmentType, Object leg, DealPermissions dealPermissions) {
		this(attachmentType, dealPermissions);
		this.leg = leg;
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	public AttachmentType getAttachmentType() {
		return attachmentType;
	}

	/**
	 * @return the dealPermissions
	 */
	public DealPermissions getDealPermissions() {
		return dealPermissions;
	}

	/**
	 * 
	 * @return
	 */
	public Object getLeg() {
		return leg;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isDeletable() {
		return deletable;
	}

	/**
	 * 
	 * @param deletable
	 */
	public void setDeletable(boolean deletable) {
		this.deletable = deletable;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isEditable() {
		return editable;
	}

	/**
	 * 
	 * @param editable
	 * @throws ICFPAttachmentException 
	 */
	public void setEditable(boolean editable) {
		checkFreez();
		this.editable = editable;
	}

	/**
	 * 
	 * @return
	 * @throws ICFPAttachmentException 
	 */
	public boolean isViewable() {
		return viewable;
	}

	/**
	 * 
	 * @param viewable
	 * @throws ICFPAttachmentException 
	 */
	public void setViewable(boolean viewable) {
		checkFreez();
		this.viewable = viewable;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isMandatory() {
		return mandatory;
	}

	/**
	 * 
	 * @param mandatory
	 * @throws ICFPAttachmentException
	 */
	public void setMandatory(boolean mandatory) {
		checkFreez();
		this.mandatory = mandatory;
	}

	/**
	 * 
	 */
	public void freez() {
		this.freez = true;
	}
	
	/**
	 * 
	 * @throws ICFPAttachmentException
	 */
	private void checkFreez() {
		if(freez) {
			throw new RuntimeException();
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public DealRequest getDeal() {
		return dealPermissions.getDeal();
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isCPADeal() {
		return dealPermissions.isCPADeal();
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean hasEquityLegs() {
		return dealPermissions.hasEquityLegs();
	}
}
