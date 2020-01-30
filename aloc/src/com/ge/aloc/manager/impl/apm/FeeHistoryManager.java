/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: FeeHistoryManager.java
 * Purpose: FeeHistoryManager.java used for maintaining Fee History.
 *
 */

package com.ge.aloc.manager.impl.apm;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.dao.apm.IFeeHistoryDAO;
import com.ge.aloc.manager.apm.IFeeHistoryManager;
import com.ge.aloc.model.APMDetails;
import com.ge.aloc.model.FeeHistoryDetails;
import com.ge.aloc.model.FullSummary;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author Rajat-Hydus
 *
 */
public class FeeHistoryManager implements IFeeHistoryManager{

	private IFeeHistoryDAO feeHistoryDAO;

	/**
	 * Method to get the Default fee history Details - Top Level View
	 */
	public APMDetails searchFeeHistory()throws HWFServiceException {
		return feeHistoryDAO.searchFeeHistory();
	}

	/**
	 * This Method is used to get FeeHistory Invoice file
	 * @param alocRecNos
	 * @param paymentIds
	 * @return apmDetails
	 */
	public APMDetails exportInvoiceFeeHistory(String alocRecNos,String paymentIds)throws HWFServiceException {
		String[] alocRecNo =alocRecNos.trim().split(ALOCConstants.COLON);
		String[] paymentId =paymentIds.trim().split(ALOCConstants.COLON);

		APMDetails apmDetails = new APMDetails();
		FeeHistoryDetails feeDet = new FeeHistoryDetails();
		List<FullSummary> fullSummarLst = new ArrayList<FullSummary>();
		FullSummary fullSummary = null;
		for(int i=ALOCConstants.BASE_VALUE;i<alocRecNo.length;i++){
			fullSummary = new FullSummary();
			fullSummary.setPaymentID(paymentId[i]);
			fullSummary.setALOCRecordNumber(new BigInteger(alocRecNo[i]));
			fullSummarLst.add(fullSummary);
		}
		feeDet.setFullSummaries(fullSummarLst);
		apmDetails.setFeeHistoryDetails(feeDet);

		return feeHistoryDAO.exportInvoiceFeeHistory(apmDetails);
	}

	/**
	 * This method is used to get feeHistoryDAO instance
	 * @return the feeHistoryDAO
	 */
	public IFeeHistoryDAO getFeeHistoryDAO() {
		return feeHistoryDAO;
	}

	/**
	 * This method is used to set feeHistoryDAO instance
	 * @param feeHistoryDAO the feeHistoryDAO to set
	 */
	public void setFeeHistoryDAO(IFeeHistoryDAO feeHistoryDAO) {
		this.feeHistoryDAO = feeHistoryDAO;
	}
}
