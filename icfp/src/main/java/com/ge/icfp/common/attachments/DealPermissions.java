/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: DealPermissions.java
 * DealPermissions used for deal level attachment permissions
 * 
 * 
 */
package com.ge.icfp.common.attachments;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.ge.icfp.common.constants.ICFPConstants;
import com.ge.icfp.common.helper.CurrentDealManager;
import com.ge.icfp.common.helper.CurrentInboxManager;
import com.ge.icfp.common.helper.ICFPCommonHelper;
import com.ge.icfp.model.DealRequest;
import com.ge.icfp.model.EquityLegRequest;
import com.ge.icfp.model.MyTaskData;
import com.ge.icfp.model.WorkItem;
import com.ge.icfp.util.UserRole;
import com.ge.icfp.util.WorkflowStages;
import com.hydus.wff.core.context.UserContext;

/**
 * This class used to provide the deal permissions
 * @author chaitanya.n
 *
 */
public class DealPermissions {
	public static final int WF_STAGE_DEAL_CLOSED = 25;
	private static final String DEAL_STATUS_CLOSED = "CLOSE";
	private static final String DEAL_STATUS_WITHDRAW = "WITHDRAWN";
	private static final String DEAL_STATUS_REJECTED = "REJECT";
			
	
	protected DealRequest deal;
	protected UserContext userContext;
	
	private boolean requestor;
	private boolean pipelineReview;
	private boolean middleOffice;
	private boolean cashManagement;
	private boolean treasuryTax;
	private boolean transferPricing;
	private boolean treasuryLeagal;
	private boolean frontOffice;
	private boolean requlatoryOrJurisdictional;
	private boolean businessApprover;
	private boolean businessCFO;
	private boolean riskReview;
	private boolean IDAGMember;
	private boolean TESGMember;
	private boolean IDAGLead;
	private boolean additionalApprover;
	private boolean transactionCapture;
	private boolean transactionCaptureManager;
	private boolean closeOut;
	private boolean closed;
	private boolean withdrawn;
	private boolean rejected;
	
	/**
	 * 
	 * @param deal
	 */
	DealPermissions(HttpServletRequest request) {
		this.deal = CurrentDealManager.getCurrentDeal(request);
		userContext = UserContext.getCurrentUserContext();
		init(request);
	}
	
	/**
	 * Based on the work flow stage rules will be performed
	 */
	protected void init(HttpServletRequest request) {
		// Deal closed; ReadOnly access
		closed = (StringUtils.isNotBlank(deal.getDealStatus()) && DEAL_STATUS_CLOSED.equalsIgnoreCase(deal.getDealStatus())); 
		if(closed) {
			return;
		}
		withdrawn = (StringUtils.isNotBlank(deal.getDealStatus()) && DEAL_STATUS_WITHDRAW.equalsIgnoreCase(deal.getDealStatus()));
		if(withdrawn) {
			return;
		}
		rejected = (StringUtils.isNotBlank(deal.getDealStatus()) && DEAL_STATUS_REJECTED.equalsIgnoreCase(deal.getDealStatus()));
		if(rejected) {
			return;
		}
		
		WorkflowStages workFlowStage = (deal.getWFStageId() != null) ? WorkflowStages.fromId(deal.getWFStageId()) : null;
		
		if(workFlowStage == null && (deal.getTransOwnerSsoId() == null || deal.getTransOwnerSsoId().equals(userContext.getId()))) {
			requestor = true;
			return;
		}
		
		switch(workFlowStage) {
			case INITIATION:
			case Requester:
			case REREQUST:
				if(deal.getTransOwnerSsoId() == null || deal.getTransOwnerSsoId().equals(userContext.getId())) {
					requestor = true;
				}
				return;
			// Pipeline
			case PLERIVEW:
				if(hasAnyOneOfRole(UserRole.PipelineReviewer, UserRole.Admin)) {
					pipelineReview = true;
				}
				return;
		}
		
		// Try to fetch from Inbox; because workflow stage in deal may not accurate.
		workFlowStage = null; // Make sure workFlowStage is null
		String section = (String) request.getSession().getAttribute("section");
		List<WorkItem> allworkItems = new ArrayList<WorkItem>();
		if(ICFPConstants.MYTASKS_SMALL.equals(section)){
			MyTaskData mytaskData = CurrentInboxManager.getTaskData(request);
			allworkItems.addAll( mytaskData.getWorkItems() );
		}
		
		for(WorkItem item: allworkItems ){
			if(item.getDealSeqID().equals(String.valueOf(deal.getDealSeqId()))){
				workFlowStage = WorkflowStages.valueOf(item.getCurrentStage());
				break;
			}
		}
		
		// Consider a ReadOnly
		if(workFlowStage == null) {
			return;
		}
		
		switch(workFlowStage) {
			/* 			S&O				*/
			case SOFRTOFF:
			case FOOFFICE:
				frontOffice = hasAnyOneOfRole(UserRole.FrontOffice_Delegate, UserRole.FrontOffice_IDAG, UserRole.FrontOffice_Member, UserRole.FrontOffice_TaskAssigner);
				break;
			case SOMIDOFF:
				middleOffice = hasAnyOneOfRole(UserRole.MiddleOffice_Delegate, UserRole.MiddleOffice_IDAG, UserRole.MiddleOffice_Member, UserRole.MiddleOffice_TaskAssigner);
				break;
			case SOCASHMG:
				cashManagement = hasAnyOneOfRole(UserRole.CashManagement_Delegate, UserRole.CashManagement_IDAG, UserRole.CashManagement_Member, UserRole.CashManagement_TaskAssigner);
				break;
			case SOTPRICE:
				transferPricing = hasAnyOneOfRole(UserRole.TransferPricing_Delegate, UserRole.TransferPricing_IDAG, UserRole.TransferPricing_Member, UserRole.TransferPricing_TaskAssigner);
				break;
			case SOTLEGAL: 
				treasuryLeagal = hasAnyOneOfRole(UserRole.TreasuryLegal_Delegate, UserRole.TreasuryLegal_IDAG, UserRole.TreasuryLegal_Member, UserRole.TreasuryLegal_TaskAssigner);
				break;
			case SOTRESTX:
				treasuryTax = hasAnyOneOfRole(UserRole.TreasuryTax_Delegate, UserRole.TreasuryTax_IDAG, UserRole.TreasuryTax_Member, UserRole.TreasuryTax_TaskAssigner);
				break;
			case SOCOUNTX:
				requlatoryOrJurisdictional = hasAnyOneOfRole(UserRole.CountryTax_Delegate, UserRole.CountryTax_IDAG, UserRole.CountryTax_Member);
				break;

				/*		Business Approval */
			// Business Approver
			case BUASIA:
				businessApprover = hasAnyOneOfRole(UserRole.BusinessCFOApproverAsia, UserRole.BusinessCFODelegateAsia);
				break;
			case BUCLLAME:
				businessApprover = hasAnyOneOfRole(UserRole.BusinessCFOApproverCLLAmericas, UserRole.BusinessCFODelegateCLLAmericas);
				break;
			case BUCAPHQO:
				businessApprover = hasAnyOneOfRole(UserRole.BusinessCFOApproverCapitalHQOther, UserRole.BusinessCFODelegateCapitalHQOther);
				break;
			case BUCOMMRE:
				businessApprover = hasAnyOneOfRole(UserRole.BusinessCFOApproverCommRealEstate, UserRole.BusinessCFODelegateCommRealEstate);
				break;
			case BUEMEA:
				businessApprover = hasAnyOneOfRole(UserRole.BusinessCFOApproverEMEA, UserRole.BusinessCFODelegateEMEA);
				break;
			case BURETFIN:
				businessApprover = hasAnyOneOfRole(UserRole.BusinessCFOApproverRetailFinance, UserRole.BusinessCFODelegateRetailFinance);
				break;
			case BURESOP:
				businessApprover = hasAnyOneOfRole(UserRole.BusinessCFOApproverRestructureOp, UserRole.BusinessCFODelegateRestructureOp);
				break;
			case BUGECAS:
				businessApprover = hasAnyOneOfRole(UserRole.BusinessCFOApproverGECAS, UserRole.BusinessCFODelegateGECAS);
				break;
			case BUEMRG:
				businessApprover = hasAnyOneOfRole(UserRole.BusinessCFOApproverEMRG, UserRole.BusinessCFODelegateEMRG);
				break;
			case BUTREAS:
				businessApprover = hasAnyOneOfRole(UserRole.BusinessCFOApproverTreasury, UserRole.BusinessCFODelegateTreasury);
				break;
			case BUEFS:
				businessApprover = hasAnyOneOfRole(UserRole.BusinessCFOApproverEFS, UserRole.BusinessCFODelegateEFS);
				break;
				
			//	Business CFO
			case BAASIA:
				businessCFO = hasAnyOneOfRole(UserRole.BusinessApproversAsia, UserRole.BusinessDelegateAsia);
				break;
			case BACAPHQO:
				businessCFO = hasAnyOneOfRole(UserRole.BusinessApproversApproverCapitalHQOther, UserRole.BusinessApproversDelegateCapitalHQOther);
				break;
			case BACLLAME:
				businessCFO = hasAnyOneOfRole(UserRole.BusinessApproversApproverCLLAmericas, UserRole.BusinessApproversDelegateCLLAmericas);
				break;
			case BACOMMRE:
				businessCFO = hasAnyOneOfRole(UserRole.BusinessApproversApproverCommRealEstate, UserRole.BusinessApproversDelegateCommRealEstate);
				break;
			case BAEFS:
				businessCFO = hasAnyOneOfRole(UserRole.BusinessApproversApproverEFS, UserRole.BusinessApproversDelegateEFS);
				break;
			case BAEMEA:
				businessCFO = hasAnyOneOfRole(UserRole.BusinessApproversApproverEMEA, UserRole.BusinessApproversDelegateEMEA);
				break;
			case BAEMRG:
				businessCFO = hasAnyOneOfRole(UserRole.BusinessApproversApproverEMRG, UserRole.BusinessApproversDelegateEMRG);
				break;
			case BAGECAS:
				businessCFO = hasAnyOneOfRole(UserRole.BusinessApproversApproverGECAS, UserRole.BusinessApproversDelegateGECAS);
				break;
			case BARESOP:
				businessCFO = hasAnyOneOfRole(UserRole.BusinessApproversApproverRestructureOp, UserRole.BusinessApproversDelegateRestructureOp);
				break;
			case BARETFIN:
				businessCFO = hasAnyOneOfRole(UserRole.BusinessApproversApproverRetailFinance, UserRole.BusinessApproversDelegateRetailFinance);
				break;
			case BATREAS:
				businessCFO = hasAnyOneOfRole(UserRole.BusinessApproversApproverTreasury, UserRole.BusinessApproversDelegateTreasury);
				break;
			
			/*		Risk	*/
			case RISKREVW:
				riskReview = hasAnyOneOfRole(UserRole.RiskUnderwriting_Delegate, UserRole.RiskUnderwriting_IDAG, UserRole.RiskUnderwriting_Member, UserRole.RiskUnderwriting_TaskAssigner);
				break;
				
			/*		IDAG		*/
			case IDAGREVW:
				IDAGMember = hasAnyOneOfRole(UserRole.CashManagement_IDAG,UserRole.CashManagement_Delegate,UserRole.MiddleOffice_IDAG,UserRole.MiddleOffice_Delegate,
						UserRole.FrontOffice_IDAG,UserRole.FrontOffice_Delegate, UserRole.TransferPricing_IDAG, UserRole.TransferPricing_Delegate, UserRole.TreasuryLegal_IDAG,UserRole.TreasuryLegal_Delegate, 
						UserRole.TreasuryTax_IDAG,UserRole.TreasuryTax_Delegate, UserRole.CountryTax_IDAG,UserRole.CountryTax_Delegate, UserRole.RiskUnderwriting_IDAG,UserRole.RiskUnderwriting_Delegate, 
						UserRole.TreasuryBUFinance_IDAG,UserRole.TreasuryBUFinance_Delegate, UserRole.CapitalManagement_IDAG,UserRole.CapitalManagement_Delegate, UserRole.Liquidity_IDAG,UserRole.Liquidity_Delegate, UserRole.IDAGEAG_Lead);
				break;
			case IDAGEAG:
				IDAGLead = hasRole(UserRole.IDAGEAG_Lead);
				break;
				
			/*		TESG		*/
			case TESGREVW:
				TESGMember = hasAnyOneOfRole(UserRole.TESG, UserRole.TESG_DELEGATE, UserRole.IDAGEAG_Lead);
				break;
			
			case ADDAPPRV:
				additionalApprover = hasRole(UserRole.AdditionalApprover);
				break;
				
				
			/*		Transaction Capture	*/	
			case CERTFYFO:
			case CERTFYCM:
				transactionCapture = hasAnyOneOfRole(UserRole.FrontOffice_Delegate, UserRole.FrontOffice_IDAG, UserRole.FrontOffice_Member, UserRole.FrontOffice_TaskAssigner,UserRole.CashManagement_Delegate, UserRole.CashManagement_IDAG, UserRole.CashManagement_Member, UserRole.CashManagement_TaskAssigner);
				break;
			
			
				/* Transaction Capture Manger (Override) */
			case APPOVEFO:
			case APPOVECM:
				transactionCaptureManager = hasAnyOneOfRole(UserRole.FrontOffice_IDAG, UserRole.FrontOffice_Delegate,UserRole.CashManagement_IDAG, UserRole.CashManagement_Delegate);
				break;
			
			
			/* CloseOut */
			case CLOSEREQ:
				closeOut = hasAnyOneOfRole(UserRole.MiddleOffice_Delegate, UserRole.MiddleOffice_IDAG, UserRole.MiddleOffice_Member, UserRole.MiddleOffice_TaskAssigner);
				break;
		}
	}
	
	/**
	 * 
	 * @param role
	 * @return
	 */
	public boolean hasRole(UserRole role) {
		if(role != null) {
			return userContext.getUserSession().getRoles().contains(role.getName());
		}
		return false;
	}
	
	/**
	 * 
	 * @param roles
	 * @return
	 */
	public boolean hasAnyOneOfRole(UserRole... roles) {
		if(roles != null && roles.length > 0) {
			List<String> userRoles = userContext.getUserSession().getRoles();
			for(UserRole role : roles) {
				if(userRoles.contains(role.getName())) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 
	 * @return
	 */
	public DealRequest getDeal() {
		return this.deal;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isCPADeal() {
		Boolean cpaDeal = ICFPCommonHelper.isCPADeal(deal);
		return (cpaDeal != null) ? cpaDeal : false;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean hasEquityLegs() {
		Collection<Object> allLegs = AttachmentUtils.getAllAttachmentLegsWithIndexes(deal).values();
		for(Object leg : allLegs) {
			if(leg instanceof EquityLegRequest) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @return the requestor
	 */
	public boolean isRequestor() {
		return requestor;
	}

	/**
	 * @return the pipelineReview
	 */
	public boolean isPipelineReview() {
		return pipelineReview;
	}

	/**
	 * @return the middleOffice
	 */
	public boolean isMiddleOffice() {
		return middleOffice;
	}

	/**
	 * @return the cashManagement
	 */
	public boolean isCashManagement() {
		return cashManagement;
	}

	/**
	 * @return the treasuryTax
	 */
	public boolean isTreasuryTax() {
		return treasuryTax;
	}

	/**
	 * @return the transferPricing
	 */
	public boolean isTransferPricing() {
		return transferPricing;
	}

	/**
	 * @return the treasuryLeagal
	 */
	public boolean isTreasuryLeagal() {
		return treasuryLeagal;
	}

	/**
	 * @return the frontOffice
	 */
	public boolean isFrontOffice() {
		return frontOffice;
	}

	/**
	 * @return the requlatoryOrJurisdictional
	 */
	public boolean isRequlatoryOrJurisdictional() {
		return requlatoryOrJurisdictional;
	}

	/**
	 * @return the businessApprover
	 */
	public boolean isBusinessApprover() {
		return businessApprover;
	}

	/**
	 * @return the businessCFO
	 */
	public boolean isBusinessCFO() {
		return businessCFO;
	}

	/**
	 * @return the riskReview
	 */
	public boolean isRiskReview() {
		return riskReview;
	}

	/**
	 * @return the iDAGMember
	 */
	public boolean isIDAGMember() {
		return IDAGMember;
	}

	/**
	 * @return the tESGMember
	 */
	public boolean isTESGMember() {
		return TESGMember;
	}

	/**
	 * @return the iDAGLead
	 */
	public boolean isIDAGLead() {
		return IDAGLead;
	}

	/**
	 * @return the additionalApprover
	 */
	public boolean isAdditionalApprover() {
		return additionalApprover;
	}

	/**
	 * @return the transactionCapture
	 */
	public boolean isTransactionCapture() {
		return transactionCapture;
	}

	/**
	 * @return the transactionCaptureManager
	 */
	public boolean isTransactionCaptureManager() {
		return transactionCaptureManager;
	}

	/**
	 * @return the closeOut
	 */
	public boolean isCloseOut() {
		return closeOut;
	}
	
	/**
	 * @return the closed
	 */
	public boolean isClosed() {
		return closed;
	}

	/**
	 * @return the withdrawn
	 */
	public boolean isWithdrawn() {
		return withdrawn;
	}

	/**
	 * @return the rejected
	 */
	public boolean isRejected() {
		return rejected;
	}
}
