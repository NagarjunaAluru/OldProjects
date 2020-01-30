/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: CreateRequestAction.java
 * Purpose: CreateRequestAction used for the request operations
 */
package com.ge.aloc.action.requestor;

import java.math.BigInteger;

import com.ge.aloc.ALOCContext;
import com.ge.aloc.GoveringRuleType;
import com.ge.aloc.InstrumentType;
import com.ge.aloc.bo.RequestDetailsBO;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.dao.util.DAOUtils;
import com.ge.aloc.manager.IRequestDetailsManager;
import com.ge.aloc.model.RequestDetails;
import com.ge.aloc.model.RequestSummary;
import com.ge.aloc.model.Requestor;
import com.hydus.hwf.context.UserContext;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author chaitanya.n
 *
 */
public class CreateRequestAction {

	protected IRequestDetailsManager requestDetailsManager;
	private InstrumentType instrumentType;

	private String siteId;
	private String selectedInstrumentType;
	private boolean notSureAboutInstrument;
	private String instrumentIssuedRegion;
	private String instrumentGoverningRules;
	private String subjectToLocalCountryLaws;
	private String textFormatRefer;

	/**
	 * This method is used to create a request based on site selection and Instrument selection
	 * @return
	 * @throws HWFServiceException 
	 */
	public String execute() throws HWFServiceException {
		String instrumentTypeID = null;
		String instrumentTypeName = null;
		String siteId = getSiteId().replace(ALOCConstants.COMMA, ALOCConstants.EMPTY_STRING);
		String siteName = DAOUtils.getAllUserSites().get(siteId);
		if(!isNotSureAboutInstrument()){
			instrumentTypeID = getSelectedInstrumentType();
			instrumentTypeName = InstrumentType.fromId(Integer.parseInt(instrumentTypeID)).getName();
		} else {
			if (ALOCConstants.INSIDEUS.equals(instrumentIssuedRegion)) {
				if (GoveringRuleType.PRACTICE.getName().equals(instrumentGoverningRules)) {
					instrumentTypeID = String.valueOf(InstrumentType.LOC.getId());
					instrumentTypeName = InstrumentType.LOC.getName();
				} else if (GoveringRuleType.GUARANTEE.getName().equals(instrumentGoverningRules)) {
					instrumentTypeID = String.valueOf(InstrumentType.BANK_GUARANTEE.getId());
					instrumentTypeName = InstrumentType.BANK_GUARANTEE.getName();
				}
			} else if (ALOCConstants.OUTSIDEUS.equals(instrumentIssuedRegion)) {
				boolean subToLocalCountryLaws = ALOCConstants.YES.equals(subjectToLocalCountryLaws);

				if(GoveringRuleType.DEMAND.getName().equals(instrumentGoverningRules) && subToLocalCountryLaws) {
					instrumentTypeID = String.valueOf(InstrumentType.BANK_GUARANTEE.getId());
					instrumentTypeName = InstrumentType.BANK_GUARANTEE.getName();
				} else if(GoveringRuleType.CUSTOMS.getName().equals(instrumentGoverningRules) 
						|| (GoveringRuleType.DEMAND.getName().equals(instrumentGoverningRules) && !subToLocalCountryLaws)){
					if (ALOCConstants.SLOC.equals(textFormatRefer)) {
						instrumentTypeID = String.valueOf(InstrumentType.LOC.getId());
						instrumentTypeName = InstrumentType.LOC.getName();
					} else if (ALOCConstants.BG.equals(textFormatRefer)) {
						instrumentTypeID = String.valueOf(InstrumentType.BANK_GUARANTEE.getId());
						instrumentTypeName = InstrumentType.BANK_GUARANTEE.getName();
					}
				} else if(GoveringRuleType.UNKNOWN.getName().equals(instrumentGoverningRules)){
					if (ALOCConstants.SLOC.equals(textFormatRefer)) {
						instrumentTypeID = String.valueOf(InstrumentType.LOC.getId());
						instrumentTypeName = InstrumentType.LOC.getName();
					} else if (ALOCConstants.BG.equals(textFormatRefer)) {
						instrumentTypeID = String.valueOf(InstrumentType.BANK_GUARANTEE.getId());
						instrumentTypeName = InstrumentType.BANK_GUARANTEE.getName();
					}
				}
			}
		}	

		RequestDetails requestDetails = new RequestDetails();
		String userSSO = UserContext.getContext().getuserDetails().getUserId();
		String lastName = UserContext.getContext().getuserDetails().getLastName();
		String firstName = UserContext.getContext().getuserDetails().getFirstName();
		RequestSummary requestSummary= new RequestSummary();
		Requestor requestor= new Requestor();
		requestor.setSsoId(userSSO);
		requestor.setFirstName(firstName);
		requestor.setLastName(lastName);
		requestSummary.setRequestor(requestor);
		requestDetails.setRequestSummary(requestSummary);
		requestDetails.setInstrumentTypeId(new BigInteger(instrumentTypeID));
		requestDetails.setInstrumentType(instrumentTypeName);	
		requestDetails.setSiteId(new BigInteger(siteId));
		requestDetails.setSiteName(siteName);
		RequestDetailsBO requestDetailsBO = new RequestDetailsBO(requestDetails);
		ALOCContext.setActiveRequest(requestDetailsBO);

		return ALOCConstants.SUCCESS;

	}

	/**
	 * This method is used to get the instrumentType.
	 * @return the instrumentType
	 */
	public InstrumentType getInstrumentType() {
		return instrumentType;
	}

	/**
	 * This method is used to get the siteId.
	 * @return the siteId
	 */
	public String getSiteId() {
		return siteId;
	}

	/**
	 * This method is used to get the selectedInstrumentType.
	 * @return
	 */
	public String getSelectedInstrumentType() {
		return selectedInstrumentType;
	}

	/**
	 * This method is used to set the selectedInstrumentType.
	 * @param selectedInstrumentType
	 */
	public void setSelectedInstrumentType(String selectedInstrumentType) {
		this.selectedInstrumentType = selectedInstrumentType;
	}

	/**
	 * This method is used to get the notSureAboutInstrument.
	 * @return
	 */
	public boolean isNotSureAboutInstrument() {
		return notSureAboutInstrument;
	}

	/**
	 * This method is used to set the notSureAboutInstrument.
	 * @param notSureAboutInstrument
	 */
	public void setNotSureAboutInstrument(boolean notSureAboutInstrument) {
		this.notSureAboutInstrument = notSureAboutInstrument;
	}

	/**
	 * This method is used to get the instrumentIssuedRegion.
	 * @return the instrumentIssuedRegion
	 */
	public String getInstrumentIssuedRegion() {
		return instrumentIssuedRegion;
	}

	/**
	 * This method is used to get the instrumentGoverningRules.
	 * @return the instrumentGoverningRules
	 */
	public String getInstrumentGoverningRules() {
		return instrumentGoverningRules;
	}

	/**
	 * This method is used to get the subjectToLocalCountryLaws.
	 * @return the subjectToLocalCountryLaws
	 */
	public String getSubjectToLocalCountryLaws() {
		return subjectToLocalCountryLaws;
	}

	/**
	 * This method is used to set the instrumentType.
	 * @param instrumentType
	 */
	public void setInstrumentType(InstrumentType instrumentType) {
		this.instrumentType = instrumentType;
	}

	/**
	 * This method is used to set the siteId.
	 * @param siteId
	 */
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	/**
	 * This method is used to set the instrumentIssuedRegion.
	 * @param instrumentIssuedRegion
	 */
	public void setInstrumentIssuedRegion(String instrumentIssuedRegion) {
		this.instrumentIssuedRegion = instrumentIssuedRegion;
	}

	/**
	 * This method is used to set the instrumentGoverningRules.
	 * @param instrumentGoverningRules
	 */
	public void setInstrumentGoverningRules(String instrumentGoverningRules) {
		this.instrumentGoverningRules = instrumentGoverningRules;
	}

	/**
	 * This method is used to set the subjectToLocalCountryLaws.
	 * @param subjectToLocalCountryLaws
	 */
	public void setSubjectToLocalCountryLaws(String subjectToLocalCountryLaws) {
		this.subjectToLocalCountryLaws = subjectToLocalCountryLaws;
	}

	/**
	 * This method is used to get the textFormatRefer.
	 * @return the textFormatRefer
	 */
	public String getTextFormatRefer() {
		return textFormatRefer;
	}

	/**
	 * This method is used to set the textFormatRefer.
	 * @param textFormatRefer
	 */
	public void setTextFormatRefer(String textFormatRefer) {
		this.textFormatRefer = textFormatRefer;
	}

	/**
	 * This method is used to get the requestDetailsManager.
	 * @return the requestDetailsManager
	 */
	public IRequestDetailsManager getRequestDetailsManager() {
		return requestDetailsManager;
	}

	/**
	 * This method is used to set the requestDetailsManager.
	 * @param requestDetailsManager
	 */
	public void setRequestDetailsManager(
			IRequestDetailsManager requestDetailsManager) {
		this.requestDetailsManager = requestDetailsManager;
	}
}
