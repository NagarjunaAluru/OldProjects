/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: AttachmentBO.java
 * Purpose: AttachmentBO used for the all attachment operations
 */
package com.ge.aloc.bo;

import java.math.BigInteger;
import java.util.Calendar;

import com.ge.aloc.AtmtPermType;
import com.ge.aloc.AttachmentType;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.model.Attachment;
import com.ge.aloc.model.AttachmentPermission;

/**
 * @author chaitanya.n
 *
 */
public class AttachmentBO extends AbstractModel<Attachment> {

	//Properties set for issuance 
	private String issuanceDocType;
	private String issuanceBankRefNo;
    private Calendar issuanceDate;
    private String issuanceDesc;
    private String issuanceDocument;
    private Integer issuanceDocId;

	/**
	 * Default constructor
	 */
	public AttachmentBO() {
		super(new Attachment());
	}

	/**
	 * This method is used set Attachment object to the BO.
	 * @param model
	 */
	public AttachmentBO(Attachment attachment) {
		super(attachment);
	}	

	/**
	 * This method is used to set TreasuryPermission.
	 * @param status
	 */
	public void setTreasuryPermission(boolean status) {
		if(status) {
			setPermission(AtmtPermType.TREASURY);
		} else {
			removePermission(AtmtPermType.TREASURY);
		}
	}

	/**
	 * This method is used to verify TreasuryPermission.
	 * @return
	 */
	public boolean isTreasuryPermission() {
		return hasPermission(AtmtPermType.TREASURY);
	}

	/**
	 * This method is used to set SuretyPermission.
	 * @param status
	 */
	public void setSuretyPermission(boolean status) {
		if(status) {
			setPermission(AtmtPermType.Surety);
		} else {
			removePermission(AtmtPermType.Surety);
		}
	}

	/**
	 * This method is used to verify SuretyPermission.
	 * @return
	 */
	public boolean isSuretyPermission() {
		return hasPermission(AtmtPermType.Surety);
	}

	/**
	 * This method is used to set BankPermission.
	 * @param status
	 */
	public void setBankPermission(boolean status) {
		if(status) {
			setPermission(AtmtPermType.BANK);
		} else {
			removePermission(AtmtPermType.BANK);
		}
	}

	/**
	 * This method is used to verify BankPermission.
	 * @return
	 */
	public boolean isBankPermission() {
		return hasPermission(AtmtPermType.BANK);
	}

	/**
	 * This is used to verify the deleted flag
	 * @return
	 */
	public boolean isDeleted() {
		if(model.getDeleteFlag() == null || model.getDeleteFlag().equalsIgnoreCase(ALOCConstants.FALSE)
				|| model.getDeleteFlag().equalsIgnoreCase(ALOCConstants.N)){
			return false;
		}
		else
		{
			return true;
		}
	}
	/**
	 * This method is used to get Attachment Type.
	 * @return
	 */
	public AttachmentType getAttachmentType() {
		AttachmentType type = null;
		BigInteger typeId = getModel().getAttachmentTypeId();
		if(typeId != null) {
			type = AttachmentType.fromId(typeId.intValue());
		}
		return type;
	}

	/**
	 *  This is used to set the deleted flag
	 * @param deleted
	 */
	public void setDeleted(boolean deleted) {
		model.setDeleteFlag(String.valueOf(deleted));
	}

	/**
	 *  This is used to set the Permission
	 * @param permType
	 */
	private void setPermission(AtmtPermType permType) {
		if(!hasPermission(permType)) {
			AttachmentPermission atmtPerm = new AttachmentPermission();
			atmtPerm.setPermissionId(permType.getId());
			atmtPerm.setPermissionName(permType.name());
			model.getAttachmentPermissions().add(atmtPerm);
		}
	}

	/**
	 * This is used to remove the Permission
	 * @param permType
	 */
	private void removePermission(AtmtPermType permType) {
		AttachmentPermission atmtPerm = getPermission(permType);
		if(atmtPerm != null) {
			model.getAttachmentPermissions().remove(atmtPerm);
		}
	}

	/**
	 * This is used to verify the Permission
	 * @param roleId
	 * @return
	 */
	private boolean hasPermission(AtmtPermType permType) {
		return (getPermission(permType) != null);
	}

	/**
	 * This is used to get the AttachmentPermission
	 * @param permType
	 * @return
	 */
	private AttachmentPermission getPermission(AtmtPermType permType) {
		for(AttachmentPermission permission : model.getAttachmentPermissions()) {
			if(permType == AtmtPermType.fromId(permission.getPermissionId())) {
				return permission;
			}
		}
		return null;
	}
	
	/**
	 * This is used to get issuanceBankRefNo
	 * @return the issuanceBankRefNo
	 */
	public String getIssuanceBankRefNo() {
		return issuanceBankRefNo;
	}

	/**
	 * This is used to set issuanceBankRefNo
	 * @param issuanceBankRefNo the issuanceBankRefNo to set
	 */
	public void setIssuanceBankRefNo(String issuanceBankRefNo) {
		this.issuanceBankRefNo = issuanceBankRefNo;
	}

	/**
	 * @return the issuanceDate
	 */
	public Calendar getIssuanceDate() {
		return issuanceDate;
	}

	/**
	 * @param issuanceDate the issuanceDate to set
	 */
	public void setIssuanceDate(Calendar issuanceDate) {
		this.issuanceDate = issuanceDate;
	}

	/**
	 * @return the issuanceDesc
	 */
	public String getIssuanceDesc() {
		return issuanceDesc;
	}

	/**
	 * @param issuanceDesc the issuanceDesc to set
	 */
	public void setIssuanceDesc(String issuanceDesc) {
		this.issuanceDesc = issuanceDesc;
	}

	/**
	 * @return the issuanceDocument
	 */
	public String getIssuanceDocument() {
		return issuanceDocument;
	}

	/**
	 * @param issuanceDocument the issuanceDocument to set
	 */
	public void setIssuanceDocument(String issuanceDocument) {
		this.issuanceDocument = issuanceDocument;
	}

	/**
	 * This is used to get issuanceDocId
	 * @return the issuanceDocId
	 */
	public Integer getIssuanceDocId() {
		return issuanceDocId;
	}

	/**
	 * This is used to set issuanceDocId
	 * @param issuanceDocId the issuanceDocId to set
	 */
	public void setIssuanceDocId(Integer issuanceDocId) {
		this.issuanceDocId = issuanceDocId;
	}

	/**
	 * This is used to get issuanceDocType
	 * @return the issuanceDocType
	 */
	public String getIssuanceDocType() {
		return issuanceDocType;
	}

	/**
	 * This is used to set issuanceDocType
	 * @param issuanceDocType the issuanceDocType to set
	 */
	public void setIssuanceDocType(String issuanceDocType) {
		this.issuanceDocType = issuanceDocType;
	}
}
