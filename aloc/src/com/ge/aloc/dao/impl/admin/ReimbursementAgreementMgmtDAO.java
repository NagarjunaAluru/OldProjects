/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ReimbursementAgreementMgmtDAO.java
 * Purpose: ReimbursementAgreementMgmtDAO  used for Reimebursement Agreement Management operations.
 */

package com.ge.aloc.dao.impl.admin;

import java.math.BigInteger;

import com.ge.aloc.OpCode;
import com.ge.aloc.ServiceClientSupport;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.dao.admin.IReimbursementAgreementMgmtDAO;
import com.ge.aloc.model.MsgHeader;
import com.ge.aloc.model.Reimbursement;
import com.ge.aloc.util.ALOCCommonHelper;
import com.hydus.hwf.exceptions.HWFServiceException;

/**
 * @author rajeswari.guthi
 *
 */
public class ReimbursementAgreementMgmtDAO extends ServiceClientSupport  implements IReimbursementAgreementMgmtDAO {

	/**
	 * This is used to get add or update the reimbursement agreement
	 * @param reimbursement
	 * @return
	 * @throws HWFServiceException
	 */
	public Reimbursement createOrUpdateReimbursementAgreement(Reimbursement reimbursement)	throws HWFServiceException {

		if(reimbursement.getReimbursementAgreement().getReimbursementAgreementId().equals(new BigInteger(ALOCConstants.MONE))){
			MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.INSERT.getOperationCode());	
			reimbursement.setOpCode(OpCode.INSERT.getOperationCode()); 				
			reimbursement.setMsgHeader(msgHeader);
		}else{
			reimbursement.setOpCode(OpCode.UPDATE.getOperationCode());	
			MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.UPDATE.getOperationCode());
			reimbursement.setMsgHeader(msgHeader);
		}

		reimbursement = serviceClient.invokeService(OpCode.REIMBURSEMENTAGREEMENT.getOperationCode(), reimbursement,Reimbursement.class);
		return reimbursement;
	}

	/**
	 * This is used to get list of reimbursement agreement available
	 * @param reimbursementAgreement
	 * @return
	 * @throws HWFServiceException
	 */
	public Reimbursement loadReimbursementAgreementList(Reimbursement reimbursement) throws HWFServiceException {
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.GETREIMBURSEMENTLIST.getOperationCode());
		reimbursement.setMsgHeader(msgHeader);		
		reimbursement = serviceClient.invokeService(OpCode.REIMBURSEMENTAGREEMENT.getOperationCode(), reimbursement,Reimbursement.class);
		return reimbursement;
	}



	/**
	 * This is used to get details of selected reimbursement agreement 
	 * @param reimbursementAgreement
	 * @return
	 * @throws HWFServiceException
	 */
	public Reimbursement loadReimbursementAgreementDetailsById(Reimbursement reimbursement) throws HWFServiceException {
		MsgHeader msgHeader = ALOCCommonHelper.createMsgHeader(OpCode.GETREIMBURSEMENT.getOperationCode());
		reimbursement.setMsgHeader(msgHeader);						
		reimbursement = serviceClient.invokeService(OpCode.REIMBURSEMENTAGREEMENT.getOperationCode(), reimbursement,Reimbursement.class);
		return reimbursement;
	}

}
