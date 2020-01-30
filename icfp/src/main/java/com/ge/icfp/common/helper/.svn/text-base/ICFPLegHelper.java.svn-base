/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: ICFPLegHelper.java
 * Purpose: This file will have all helper methods to handle leg, exceptions and attachments
 * 
 */
package com.ge.icfp.common.helper;

import static com.ge.icfp.common.constants.ICFPConstants.AMENDEDUSDEQUIVALENTAMT;
import static com.ge.icfp.common.constants.ICFPConstants.BORROWER;
import static com.ge.icfp.common.constants.ICFPConstants.BORROWERENTITY;
import static com.ge.icfp.common.constants.ICFPConstants.BORROWERTCODEENTITY;
import static com.ge.icfp.common.constants.ICFPConstants.CASHPOOLLEADER;
import static com.ge.icfp.common.constants.ICFPConstants.CASHPOOLPARTICIPANT;
import static com.ge.icfp.common.constants.ICFPConstants.CPALEGREQUESTFORM;
import static com.ge.icfp.common.constants.ICFPConstants.CPASUMMARY;
import static com.ge.icfp.common.constants.ICFPConstants.CPASUMMARY_SMALL;
import static com.ge.icfp.common.constants.ICFPConstants.DAYONECCY;
import static com.ge.icfp.common.constants.ICFPConstants.DAYONEUSDEQUIVALENT;
import static com.ge.icfp.common.constants.ICFPConstants.DAYTWOOPERATIONS;
import static com.ge.icfp.common.constants.ICFPConstants.DELETE;
import static com.ge.icfp.common.constants.ICFPConstants.EBOARDAPPROVALREQUIREDFLAG;
import static com.ge.icfp.common.constants.ICFPConstants.EBOARDARFLAGVALUE;
import static com.ge.icfp.common.constants.ICFPConstants.ENTITYFORM;
import static com.ge.icfp.common.constants.ICFPConstants.FACILITYINCDECUSDEQUIVALENTAMT;
import static com.ge.icfp.common.constants.ICFPConstants.FACILITYINCREASEDECREASE;
import static com.ge.icfp.common.constants.ICFPConstants.FOURBLOCKER;
import static com.ge.icfp.common.constants.ICFPConstants.FOURBLOCKERFORM;
import static com.ge.icfp.common.constants.ICFPConstants.GROSSSETTLEMENTAMT;
import static com.ge.icfp.common.constants.ICFPConstants.GUARANTORENTITY;
import static com.ge.icfp.common.constants.ICFPConstants.ICFPLEGREQUESTFORM;
import static com.ge.icfp.common.constants.ICFPConstants.ICFPOTHERLEGREQUESTFORM;
import static com.ge.icfp.common.constants.ICFPConstants.IMMDTDRDOWNAMT;
import static com.ge.icfp.common.constants.ICFPConstants.INSERT;
import static com.ge.icfp.common.constants.ICFPConstants.LEGSUMMARY;
import static com.ge.icfp.common.constants.ICFPConstants.LENDER;
import static com.ge.icfp.common.constants.ICFPConstants.LENDERENTITY;
import static com.ge.icfp.common.constants.ICFPConstants.LENDERTCODEENTITY;
import static com.ge.icfp.common.constants.ICFPConstants.NO_CAP;
import static com.ge.icfp.common.constants.ICFPConstants.ONE;
import static com.ge.icfp.common.constants.ICFPConstants.ORIGINALCCY;
import static com.ge.icfp.common.constants.ICFPConstants.ORIGINALCCYAMOUNT;
import static com.ge.icfp.common.constants.ICFPConstants.OTHEREQUITYCOMMENTS;
import static com.ge.icfp.common.constants.ICFPConstants.PARTICIPANTENTITY;
import static com.ge.icfp.common.constants.ICFPConstants.PERMANENT;
import static com.ge.icfp.common.constants.ICFPConstants.POOLLEADERENTITY;
import static com.ge.icfp.common.constants.ICFPConstants.QUALITATIVEFACTORS;
import static com.ge.icfp.common.constants.ICFPConstants.QUALITATIVEFACTORSFORM;
import static com.ge.icfp.common.constants.ICFPConstants.RATEINFORMATION;
import static com.ge.icfp.common.constants.ICFPConstants.SOLVENCYMETRICOPCODE;
import static com.ge.icfp.common.constants.ICFPConstants.SOLVENCYMETRICS;
import static com.ge.icfp.common.constants.ICFPConstants.TCLASSIFICATIONLEVEL;
import static com.ge.icfp.common.constants.ICFPConstants.TCLASSIFICATIONLEVELFORM;
import static com.ge.icfp.common.constants.ICFPConstants.TEMPORARY;
import static com.ge.icfp.common.constants.ICFPConstants.TPLEGREQUEST;
import static com.ge.icfp.common.constants.ICFPConstants.TPRIORITYTIMINGS;
import static com.ge.icfp.common.constants.ICFPConstants.TPRIORITYTIMINGSFORM;
import static com.ge.icfp.common.constants.ICFPConstants.TRUE_SMALL;
import static com.ge.icfp.common.constants.ICFPConstants.TSUMMARYOWNER;
import static com.ge.icfp.common.constants.ICFPConstants.TSUMMARYOWNERFORM;
import static com.ge.icfp.common.constants.ICFPConstants.TWO;
import static com.ge.icfp.common.constants.ICFPConstants.UPDATE;
import static com.ge.icfp.common.constants.ICFPConstants.USDEQUIVALENT;
import static com.ge.icfp.common.constants.ICFPConstants.YES_CAP;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import com.ge.icfp.action.ICFPException;
import com.ge.icfp.common.attachments.AttachmentSecurity;
import com.ge.icfp.common.attachments.DealPermissions;
import com.ge.icfp.common.attachments.ICFPAttachmentException;
import com.ge.icfp.common.attachments.ICFPAttachmentManager;
import com.ge.icfp.common.constants.ICFPConstants;
import com.ge.icfp.model.Amendment;
import com.ge.icfp.model.Attachment;
import com.ge.icfp.model.AttachmentTypeComments;
import com.ge.icfp.model.CPALegRequest;
import com.ge.icfp.model.CPASummary;
import com.ge.icfp.model.DealRequest;
import com.ge.icfp.model.DerivativesRequest;
import com.ge.icfp.model.Entity;
import com.ge.icfp.model.EquityLegRequest;
import com.ge.icfp.model.ExceptionRequestForm;
import com.ge.icfp.model.LegSummary;
import com.ge.icfp.model.MsgHeader;
import com.ge.icfp.model.OtherLegRequest;
import com.ge.icfp.model.QualitativeFactors;
import com.ge.icfp.model.RCALegRequest;
import com.ge.icfp.model.RateInformation;
import com.ge.icfp.model.ShareInfo;
import com.ge.icfp.model.SolvencyMetrics;
import com.ge.icfp.model.TClassificationLevel;
import com.ge.icfp.model.TPLegRequest;
import com.ge.icfp.model.TPriorityTimings;
import com.ge.icfp.model.TSummaryOwner;
import com.ge.icfp.model.UpdateStatus;
import com.ge.icfp.util.EventType;
import com.ge.icfp.util.ProductType;
import com.ge.icfp.util.QualitativeFactorsType;
import com.ge.icfp.util.StaticDataFactory;
import com.ge.icfp.util.Utils;
import com.ge.icfp.util.report.pdf.PDFReportHelper;
import com.hydus.wff.core.context.UserContext;

import formdef.plugin.FormMapping;
import formdef.plugin.util.FormUtils;
/**
 * This file will have all helper methods to handle leg, exceptions and attachments
 * @author ramakrishna.satti
 *
 */
public class ICFPLegHelper {
	
	private static final String NET_PROCEEDS_AMT = "netProceedsAmt";
	private static final String DEBT_TERMS = "debtTerms";
	private static final String SHARE_VALUE = "shareValue";
	private static final String NUMBER_OF_SHARES = "numberOfShares";
	private static final String SHARE_TYPE_ID = "shareTypeId";
	private static final String SHARE_PRF_ID = "sharePrfId";
	private static final String DATE_FORMAT = "MMM dd, yyyy - hh:mm a";
	private static final String EXCEPTION_INDEX = "exceptionIndex";
	private static final String REMEDIATION_TIMELINE_COMMENTS = "remediationTimelineComments";
	private static final String RATIONALE_FOR_EXCEPTION_POTENTIAL_ALTERNATIVES = "rationaleForExceptionPotentialAlternatives";
	private static final String REMEDIATION_TIMELINE = "remediationTimeline";
	private static final String RATIONALE_FOR_EXCEPTION_IMPACT = "rationaleForExceptionImpact";
	private static final String REQUESTED_EXCEPTION = "requestedException";
	private static final String STANDARD_TERMS_CONDITIONS_ID = "standardTermsConditionsId";
	private static final String GUARANTEE_AGREEMENT_FLAG = "guaranteeAgreementFlag";
	private static final String GUARANTEE_FEE_RATE = "guaranteeFeeRate";
	private static final String GUARANTEE_FEE_APPLICABLE_FLAG = "guaranteeFeeApplicableFlag";
	private static final String DESCRIPTION = "description";
	private static final String CPA_SUMMARY_FORM = "cpaSummaryForm";
	private static final String RATE_INFORMATION_FORM = "rateInformationForm";
	private static final String SHARE_INFO_FORM = "ShareInfoForm";
	private static final String SHARE_INFOS = "shareInfos";
	private static final String CROSS_BORDER_FLAG = "crossBorderFlag";
	private static final String DOUBLE_LEVERAGE_FLAG = "doubleLeverageFlag";
	private static final String EQUITY_INFUSIONS_DIVIDENDS_FLAG = "equityInfusionsDividendsFlag";
	private static final String EQUITY_FORM_ID = "equityFormId";
	private static final String NON_STANDARD_AGREEMENTS_FLAG = "nonStandardAgreementsFlag";
	private static final String DAY_ONE_CCY_AMOUNT = "dayOneCCYAmount";
	private static final String SOLVENCY_METRICS_FORM = "solvencyMetricsForm";
	private static final String TP_LEG_REQUEST_FORM = "TPLegRequestForm";
	private static final String LEG_SUMMARY_FORM = "legSummaryForm";
	private static final String GUARANTOR_INFORMATION = "guarantorInformation";
	private static final String ENTITY_INFO_FORM = "entityInfoForm";
	private static final String REVISED_TCL_COMMENTS = "revisedTCLComments";
	private static final String RU_AMENDED_TCL = "RUAmendedTCL";
	private static final String RISK_REVIEW_OVERRIDE = "riskReviewOverride";
	private static final String RU_DEAL_ID = "RU_Deal_ID";
	private static final String CASH_POOL_LEADER_FORM = "cashPoolLeaderForm";
	private static final String CASH_POOL_PARTICIPANT_FORM = "cashPoolParticipantForm";
	private static final String BORROWER_FORM = "borrowerForm";
	private static final String LENDER_FORM = "lenderForm";
	private static final String LEG_SUMMARY_LEG_TYPE_ID = "legSummary.legTypeId";
	private static final String CPA_SUMMARY_LEG_TYPE_ID = "CPASummary.legTypeId";

	/**
	 * Returns the Leg Object based on productType
	 * @param productType
	 * @return
	 */
	public static Object createLegObject(ProductType productType) {
		Object result = null;
		
		switch(productType) {
			case RCA:
			case TERM_LOAN:
			case BOND:
				result = new RCALegRequest();
				break;
			case EQUITY:
				result = new EquityLegRequest();
				break;
			case CPA:
				result = new CPALegRequest();
				break;
			case OTHER:
				result = new OtherLegRequest();
				break;
		}
		return result;
	}
	
	/**
	 * Method will returns the Leg seq ID for particular leg type
	 * @param leg
	 * @return
	 */
	public static Integer getLegSeqId(Object leg) {
		if(leg instanceof RCALegRequest) {
			RCALegRequest rcaLeg = (RCALegRequest) leg;
			return rcaLeg.getLegSummary().getLegSeqId();
		} else if(leg instanceof EquityLegRequest) {
			EquityLegRequest equityLeg = (EquityLegRequest) leg;
			return equityLeg.getLegSummary().getLegSeqId();
		} else if(leg instanceof OtherLegRequest) {
			OtherLegRequest otherLeg = (OtherLegRequest) leg;
			return otherLeg.getLegSummary().getLegSeqId();
		} else if(leg instanceof CPALegRequest) {
			CPALegRequest cpaLeg = (CPALegRequest) leg;
			return cpaLeg.getCPASummary().getLegSeqId();
		}
		return null;
	}
	
	/**
	 * This method returns event type of leg; if leg is day1 this returns null
	 * 
	 * @param leg
	 * @return
	 */
	public static Integer getTransactionEventTypeId(Object leg) {
		if(leg instanceof RCALegRequest) {
			RCALegRequest rcaLeg = (RCALegRequest) leg;
			return rcaLeg.getLegSummary().getTransactionEventTypeId();
		} else if(leg instanceof EquityLegRequest) {
			EquityLegRequest equityLeg = (EquityLegRequest) leg;
			return equityLeg.getLegSummary().getTransactionEventTypeId();
		} else if(leg instanceof OtherLegRequest) {
			OtherLegRequest otherLeg = (OtherLegRequest) leg;
			return otherLeg.getLegSummary().getTransactionEventTypeId();
		} else if(leg instanceof CPALegRequest) {
			CPALegRequest cpaLeg = (CPALegRequest) leg;
			return cpaLeg.getCPASummary().getTransactionEventTypeId();
		}
		return null;
	}
	
	/**
	 * This method returns Product type of leg
	 * 
	 * @param leg
	 * @return
	 */
	public static ProductType getProductType(Object leg) throws ICFPException {
		Integer productTypeId = null;
		if(leg instanceof CPALegRequest) {
			productTypeId = Utils.fetchPropertyValue(ICFPLegHelper.CPA_SUMMARY_LEG_TYPE_ID, leg, Integer.class);
		} else {
			productTypeId = Utils.fetchPropertyValue(ICFPLegHelper.LEG_SUMMARY_LEG_TYPE_ID, leg, Integer.class);
		}
		return (productTypeId == null) ? null : ProductType.fromId(productTypeId);
	}
	
	/**
	 * getOpCode
	 * @param leg
	 * @return opcode
	 */
	public static String getOpCode(Object leg) {
		if(leg instanceof RCALegRequest) {
			RCALegRequest rcaLeg = (RCALegRequest) leg;
			return rcaLeg.getLegSummary().getLegOpcode();
		} else if(leg instanceof EquityLegRequest) {
			EquityLegRequest equityLeg = (EquityLegRequest) leg;
			return equityLeg.getLegSummary().getLegOpcode();
		} else if(leg instanceof OtherLegRequest) {
			OtherLegRequest otherLeg = (OtherLegRequest) leg;
			return otherLeg.getLegSummary().getLegOpcode();
		} else if(leg instanceof CPALegRequest) {
			CPALegRequest cpaLeg = (CPALegRequest) leg;
			return cpaLeg.getCPASummary().getCPALegOpcode();
		}
		return null;
	}
	
	/**
	 * setValidate Flag
	 * @param leg
	 * @return 
	 * @return opcode
	 */
	public static void setReqValidateFlag(Object leg, String validateFlag) {
		if(leg instanceof RCALegRequest) {
			RCALegRequest rcaLeg = (RCALegRequest) leg;
			rcaLeg.getLegSummary().setRequesterValidateFlag(validateFlag);
		} else if(leg instanceof EquityLegRequest) {
			EquityLegRequest equityLeg = (EquityLegRequest) leg;
			equityLeg.getLegSummary().setRequesterValidateFlag(validateFlag);
		} else if(leg instanceof OtherLegRequest) {
			OtherLegRequest otherLeg = (OtherLegRequest) leg;
			otherLeg.getLegSummary().setRequesterValidateFlag(validateFlag);
		} else if(leg instanceof CPALegRequest) {
			CPALegRequest cpaLeg = (CPALegRequest) leg;
			cpaLeg.getCPASummary().setRequesterValidateFlag(validateFlag);
		}
	}
	
	/**
	 * setValidate Flag
	 * @param leg
	 * @return 
	 * @return opcode
	 */
	public static void setTPValidateFlag(Object leg, String validateFlag) {
		if(leg instanceof RCALegRequest) {
			RCALegRequest rcaLeg = (RCALegRequest) leg;
			rcaLeg.getLegSummary().setTpValidateFlag(validateFlag);
		} else if(leg instanceof EquityLegRequest) {
			EquityLegRequest equityLeg = (EquityLegRequest) leg;
			equityLeg.getLegSummary().setTpValidateFlag(validateFlag);
		} else if(leg instanceof OtherLegRequest) {
			OtherLegRequest otherLeg = (OtherLegRequest) leg;
			otherLeg.getLegSummary().setTpValidateFlag(validateFlag);
		} else if(leg instanceof CPALegRequest) {
			CPALegRequest cpaLeg = (CPALegRequest) leg;
			cpaLeg.getCPASummary().setTpValidateFlag(validateFlag);
		}
	}
	
	/**
	 * setValidate Flag
	 * @param leg
	 * @return 
	 * @return opcode
	 */
	public static void setFOValidateFlag(Object leg, String validateFlag) {
		if(leg instanceof RCALegRequest) {
			RCALegRequest rcaLeg = (RCALegRequest) leg;
			rcaLeg.getLegSummary().setFoValidateFlag(validateFlag);
		} else if(leg instanceof EquityLegRequest) {
			EquityLegRequest equityLeg = (EquityLegRequest) leg;
			equityLeg.getLegSummary().setFoValidateFlag(validateFlag);
		} else if(leg instanceof OtherLegRequest) {
			OtherLegRequest otherLeg = (OtherLegRequest) leg;
			otherLeg.getLegSummary().setFoValidateFlag(validateFlag);
		} else if(leg instanceof CPALegRequest) {
			CPALegRequest cpaLeg = (CPALegRequest) leg;
			cpaLeg.getCPASummary().setFoValidateFlag(validateFlag);
		}
	}
	/**
	 * Returns the summary of leg
	 * 
	 * @param leg
	 * @return
	 */
	public static Object getLegSummary(Object leg) {
		if(leg instanceof RCALegRequest) {
			RCALegRequest rcaLeg = (RCALegRequest) leg;
			return rcaLeg.getLegSummary();
		} else if(leg instanceof EquityLegRequest) {
			EquityLegRequest equityLeg = (EquityLegRequest) leg;
			return equityLeg.getLegSummary();
		} else if(leg instanceof OtherLegRequest) {
			OtherLegRequest otherLeg = (OtherLegRequest) leg;
			return otherLeg.getLegSummary();
		} else if(leg instanceof CPALegRequest) {
			CPALegRequest cpaLeg = (CPALegRequest) leg;
			return cpaLeg.getCPASummary();
		}
		return null;
	}
	
	/**
	 * setOpCodeFlag
	 * @param leg Object
	 * @param opcode String
	 */
	public static void setOpCodeFlag(Object leg, String opcode) {
		if(leg instanceof RCALegRequest) {
			RCALegRequest rcaLeg = (RCALegRequest) leg;
			if(rcaLeg.getLegSummary().getLegOpcode() == null) {
				rcaLeg.getLegSummary().setLegOpcode(opcode);
			}
		} else if(leg instanceof EquityLegRequest) {
			EquityLegRequest equityLeg = (EquityLegRequest) leg;
			if(equityLeg.getLegSummary().getLegOpcode() == null) {
				equityLeg.getLegSummary().setLegOpcode(opcode);
			}
		} else if(leg instanceof OtherLegRequest) {
			OtherLegRequest otherLeg = (OtherLegRequest) leg;
			if(otherLeg.getLegSummary().getLegOpcode() == null) {
				otherLeg.getLegSummary().setLegOpcode(opcode);
			} 
		} else if(leg instanceof CPALegRequest) {
			CPALegRequest cpaLeg = (CPALegRequest) leg;
			if(cpaLeg.getCPASummary().getCPALegOpcode() == null || cpaLeg.getCPASummary().getCPALegOpcode().trim().equals("")) {
				cpaLeg.getCPASummary().setCPALegOpcode(opcode);
			}
		}
	}
	
	/**
	 * setOpCodeFlag
	 * @param leg Object
	 * @param opcode String
	 */
	public static void setQAOpCodeFlag(Object leg, String opcode) {
		if(leg instanceof RCALegRequest) {
			RCALegRequest rcaLeg = (RCALegRequest) leg;
			if(rcaLeg.getLegSummary()!= null) {
				List<QualitativeFactors> qalist = rcaLeg.getLegSummary().getQualitativeFactors();
				setOpCodeForQAList(qalist,opcode);
			}
		} else if(leg instanceof EquityLegRequest) {
			EquityLegRequest equityLeg = (EquityLegRequest) leg;
			if(equityLeg.getLegSummary()!= null) {
				List<QualitativeFactors> qalist = equityLeg.getLegSummary().getQualitativeFactors();
				setOpCodeForQAList(qalist,opcode);
			}
		} else if(leg instanceof OtherLegRequest) {
			OtherLegRequest otherLeg = (OtherLegRequest) leg;
			if(otherLeg.getLegSummary()!= null) {
				List<QualitativeFactors> qalist = otherLeg.getLegSummary().getQualitativeFactors();
				setOpCodeForQAList(qalist,opcode);
			} 
		} else if(leg instanceof CPALegRequest) {
			CPALegRequest cpaLeg = (CPALegRequest) leg;
			if(cpaLeg.getCPASummary()!= null) {
				List<QualitativeFactors> qalist = cpaLeg.getCPASummary().getQualitativeFactors();
				setOpCodeForQAList(qalist,opcode);
			}
		}
	}	
		
	/**
	 * setOpCodeForQA
	 * @param qalist
	 * @param opcode
	 */
	public static void setOpCodeForQAList(List<QualitativeFactors> qalist, String opcode) {
		for (QualitativeFactors qualitativeFactor : qalist) {
			Integer qualitativeAssessmentId = qualitativeFactor
					.getQualitativeAssessmentId();
			if (qualitativeAssessmentId == null) {
				qualitativeFactor.setQualitativeFactorOpcode(INSERT);
			} else {
				qualitativeFactor.setQualitativeFactorOpcode(UPDATE);
			}

		}
	}


	/**
	 * setUpdateOpCodeFlag
	 * @param leg Object
	 */
	public static void setUpdateOpCodeFlag(Object leg) {
		if(leg instanceof RCALegRequest) {
			RCALegRequest rcaLeg = (RCALegRequest) leg;
			if(rcaLeg.getLegSummary().getLegSeqId() != null && rcaLeg.getLegSummary().getLegOpcode() == null) {
				rcaLeg.getLegSummary().setLegOpcode(UPDATE);
			}
		} else if(leg instanceof EquityLegRequest) {
			EquityLegRequest equityLeg = (EquityLegRequest) leg;
			if(equityLeg.getLegSummary().getLegSeqId() != null && equityLeg.getLegSummary().getLegOpcode() == null) {
				equityLeg.getLegSummary().setLegOpcode(UPDATE);
			}
		} else if(leg instanceof OtherLegRequest) {
			OtherLegRequest otherLeg = (OtherLegRequest) leg;
			if(otherLeg.getLegSummary().getLegSeqId() != null && otherLeg.getLegSummary().getLegSeqId() == null) {
				otherLeg.getLegSummary().setLegOpcode(UPDATE);
			} 
		} else if(leg instanceof CPALegRequest) {
			CPALegRequest cpaLeg = (CPALegRequest) leg;
			if(cpaLeg.getCPASummary().getLegSeqId() != null && cpaLeg.getCPASummary().getLegSeqId() == null) {
				cpaLeg.getCPASummary().setCPALegOpcode(UPDATE);
			} 
		}
	}
	/**
	 * getDerivatives
	 * @param leg Object
	 * @return list
	 */
	public static List<DerivativesRequest> getDerivatives(Object leg) {
		if(leg instanceof RCALegRequest) {
			RCALegRequest rcaLeg = (RCALegRequest) leg;
			if(rcaLeg.getLegSummary() != null) {
				return rcaLeg.getLegSummary().getDerivativesRequests();
			}
		}
		if(leg instanceof OtherLegRequest) {
			OtherLegRequest othLeg = (OtherLegRequest) leg;
			if(othLeg.getLegSummary() != null) {
				return othLeg.getLegSummary().getDerivativesRequests();
			}
		}
		return null;
	}
	
	/**
	 * This method will returns the list of Exceptions for particular leg type
	 * @param leg
	 * @return
	 */
	public static List<ExceptionRequestForm> getExceptions(Object leg) {
		if(leg instanceof RCALegRequest) {
			RCALegRequest rcaLeg = (RCALegRequest) leg;
			if(rcaLeg.getLegSummary() != null) {
				return rcaLeg.getLegSummary().getExceptionRequestForms();
			}
		} else if(leg instanceof EquityLegRequest) {
			EquityLegRequest equityLeg = (EquityLegRequest) leg;
			if(equityLeg.getLegSummary() != null) {
				return equityLeg.getLegSummary().getExceptionRequestForms();
			}
		} else if(leg instanceof OtherLegRequest) {
			OtherLegRequest otherLeg = (OtherLegRequest) leg;
			if(otherLeg.getLegSummary() != null) {
				return otherLeg.getLegSummary().getExceptionRequestForms();
			}
		} else if(leg instanceof CPALegRequest) {
			CPALegRequest cpaLeg = (CPALegRequest) leg;
			if(cpaLeg.getCPASummary() != null) {
				return cpaLeg.getCPASummary().getExceptionRequestForms();
			}
		}
		return null;
	}
	
	
	/**
	 * This method will returns the list of Exceptions for particular leg type
	 * @param leg
	 * @return
	 */
	public static List<Amendment> getAmendments(Object leg) {
		if(leg instanceof RCALegRequest) {
			RCALegRequest rcaLeg = (RCALegRequest) leg;
			if(rcaLeg.getLegSummary() != null) {
				return rcaLeg.getDayTwoOperations().getAmendments();
			}
		} else if(leg instanceof EquityLegRequest) {
			EquityLegRequest equityLeg = (EquityLegRequest) leg;
			if(equityLeg.getLegSummary() != null) {
				return equityLeg.getDayTwoOperations().getAmendments();
			}
		} else if(leg instanceof OtherLegRequest) {
			OtherLegRequest otherLeg = (OtherLegRequest) leg;
			if(otherLeg.getLegSummary() != null) {
				return otherLeg.getDayTwoOperations().getAmendments();
			}
		} else if(leg instanceof CPALegRequest) {
			CPALegRequest cpaLeg = (CPALegRequest) leg;
			if(cpaLeg.getCPASummary() != null) {
				return cpaLeg.getDayTwoOperations().getAmendments();
			}
		}
		return null;
	}
	
	
	
	/**
	 * 
	 * @param leg
	 * @return
	 */
	public static List<Entity> getEntityList(Object leg){
		if(leg instanceof RCALegRequest) {
			RCALegRequest rcaLeg = (RCALegRequest) leg;
			if(rcaLeg.getLegSummary() != null) {
				return rcaLeg.getLegSummary().getEntities();
			}
		} else if(leg instanceof EquityLegRequest) {
			EquityLegRequest equityLeg = (EquityLegRequest) leg;
			if(equityLeg.getLegSummary() != null) {
				return equityLeg.getLegSummary().getEntities();
			}
		} else if(leg instanceof OtherLegRequest) {
			OtherLegRequest otherLeg = (OtherLegRequest) leg;
			if(otherLeg.getLegSummary() != null) {
				return otherLeg.getLegSummary().getEntities();
			}
		} else if(leg instanceof CPALegRequest) {
			CPALegRequest cpaLeg = (CPALegRequest) leg;
			if(cpaLeg.getCPASummary() != null) {
				return cpaLeg.getCPASummary().getEntities();
			}
		}
		return null;
	}
	/**
	 * This method will returns the list of QualitativeFactors for particular leg type
	 * @param leg
	 * @return
	 */
	public static List<QualitativeFactors> getQualitativeFactors(Object leg) {
		if(leg instanceof RCALegRequest) {
			RCALegRequest rcaLeg = (RCALegRequest) leg;
			if(rcaLeg.getLegSummary() != null) {
				return rcaLeg.getLegSummary().getQualitativeFactors();
			}
		} else if(leg instanceof EquityLegRequest) {
			EquityLegRequest equityLeg = (EquityLegRequest) leg;
			if(equityLeg.getLegSummary() != null) {
				return equityLeg.getLegSummary().getQualitativeFactors();
			}
		} else if(leg instanceof OtherLegRequest) {
			OtherLegRequest otherLeg = (OtherLegRequest) leg;
			if(otherLeg.getLegSummary() != null) {
				return otherLeg.getLegSummary().getQualitativeFactors();
			}
		} else if(leg instanceof CPALegRequest) {
			CPALegRequest cpaLeg = (CPALegRequest) leg;
			if(cpaLeg.getCPASummary() != null) {
				return cpaLeg.getCPASummary().getQualitativeFactors();
			}
		}
		return null;
	}
	
	/**
	 * This method sets the exceptions to the leg
	 * @param leg
	 * @param exceptions
	 */
	public static void setExceptions(Object leg, List<ExceptionRequestForm> exceptions) {
		if(leg instanceof RCALegRequest) {
			RCALegRequest rcaLeg = (RCALegRequest) leg;
			LegSummary legSummary = rcaLeg.getLegSummary();
			if(legSummary == null) {
				legSummary = new LegSummary();
				rcaLeg.setLegSummary(legSummary);
			}
			legSummary.setExceptionRequestForms(exceptions);
		} else if(leg instanceof EquityLegRequest) {
			EquityLegRequest equityLeg = (EquityLegRequest) leg;
			LegSummary legSummary = equityLeg.getLegSummary();
			if(legSummary == null) {
				legSummary = new LegSummary();
				equityLeg.setLegSummary(legSummary);
			}
			legSummary.setExceptionRequestForms(exceptions);
		} else if(leg instanceof OtherLegRequest) {
			OtherLegRequest otherLeg = (OtherLegRequest) leg;
			LegSummary legSummary = otherLeg.getLegSummary();
			if(legSummary == null) {
				legSummary = new LegSummary();
				otherLeg.setLegSummary(legSummary);
			}
			legSummary.setExceptionRequestForms(exceptions);
		} else if(leg instanceof CPALegRequest) {
			CPALegRequest cpaLeg = (CPALegRequest) leg;
			CPASummary summary = cpaLeg.getCPASummary();
			if(summary == null) {
				summary = new CPASummary();
				cpaLeg.setCPASummary(summary);
			}
			summary.setExceptionRequestForms(exceptions);
		}
	}
	
	
	/**
	 * This method sets the derivatives Attachments to the leg
	 * @param leg
	 * @param exceptions
	 */
	public static void setDerivatives(Object leg, List<DerivativesRequest> derivatives) {
		if(leg instanceof RCALegRequest) {
			RCALegRequest rcaLeg = (RCALegRequest) leg;
			LegSummary legSummary = rcaLeg.getLegSummary();
			if(legSummary == null) {
				legSummary = new LegSummary();
				rcaLeg.setLegSummary(legSummary);
			}
			legSummary.setDerivativesRequests(derivatives);
		} else if(leg instanceof EquityLegRequest) {
			EquityLegRequest equityLeg = (EquityLegRequest) leg;
			LegSummary legSummary = equityLeg.getLegSummary();
			if(legSummary == null) {
				legSummary = new LegSummary();
				equityLeg.setLegSummary(legSummary);
			}
			legSummary.setDerivativesRequests(derivatives);
		} else if(leg instanceof OtherLegRequest) {
			OtherLegRequest otherLeg = (OtherLegRequest) leg;
			LegSummary legSummary = otherLeg.getLegSummary();
			if(legSummary == null) {
				legSummary = new LegSummary();
				otherLeg.setLegSummary(legSummary);
			}
			legSummary.setDerivativesRequests(derivatives);
		} 
		
	}
	
	
	/** 
	 * This method used to replace Null Exception
	 * @param exceptions
	 */
	public static void replaceNullExceptions(List<ExceptionRequestForm> exceptions) {
		for(int i=0; i<exceptions.size(); i++) {
			ExceptionRequestForm exception = exceptions.get(i);
			if(exception == null) {
				exception = new ExceptionRequestForm();
				exceptions.set(i, exception);
			}
		}
	}
	
	/** 
	 * This method used to replace Null Exception
	 * @param exceptions
	 */
	public static void replaceNullAmendments(List<Amendment> amendments) {
		for(int i=0; i<amendments.size(); i++) {
			Amendment amendment = amendments.get(i);
			if(amendment == null) {
				amendment = new Amendment();
				amendments.set(i, amendment);
			}
		}
	}
	
	/**
	 *  This method used to removing null Exceptions
	 * @param exceptions
	 */
	public static void removeNullExceptions(List<ExceptionRequestForm> exceptions) {
		for(ListIterator<ExceptionRequestForm> exceptionItr = exceptions.listIterator(); exceptionItr.hasNext(); ) {
			if(exceptionItr.next() == null) {
				exceptionItr.remove();
			}
		}
	}
	
	/**
	 *  This method used for filter Exceptions attachments to delete
	 * @param exceptions
	 * @return
	 */
	public static List<ExceptionRequestForm> filterDeletedExceptions(List<ExceptionRequestForm> exceptions) {
		List<ExceptionRequestForm> filteredExceptions = new ArrayList<ExceptionRequestForm>();
		if(exceptions != null && !exceptions.isEmpty()) {
			replaceNullExceptions(exceptions);
			for(ExceptionRequestForm eachException : exceptions) {
				if(eachException.getExceptionOpcode() == null || !eachException.getExceptionOpcode().equalsIgnoreCase(DELETE)) {
					filteredExceptions.add(eachException);
				}
			}
		}
		return filteredExceptions;
	}
	
	/**
	 * This method filters the deleted derivatives.
	 * @param derivatives
	 * @return
	 */
	public static List<DerivativesRequest> filterDeletedDerivatives(List<DerivativesRequest> derivatives) {
		List<DerivativesRequest> filteredDerivatives = new ArrayList<DerivativesRequest>();
		if(derivatives != null && !derivatives.isEmpty()) {
			for(DerivativesRequest derivative : derivatives) {
				if(derivative.getDerivativesOpcode() == null || !derivative.getDerivativesOpcode().equalsIgnoreCase("DELETE")) {
					filteredDerivatives.add(derivative);
				}
			}
		}
		return filteredDerivatives;
	}

	
	/**
	 *  This method used for filter Exceptions attachments to delete
	 * @param exceptions
	 * @return
	 */
	public static List<Amendment> filterDeletedAmendments(List<Amendment> amendments) {
		List<Amendment> filteredAmendments = new ArrayList<Amendment>();
		if(amendments != null && !amendments.isEmpty()) {
			replaceNullAmendments(amendments);
			for(Amendment eachamendment : amendments) {
				if(eachamendment.getAmendmentOpcode() == null || !eachamendment.getAmendmentOpcode().equalsIgnoreCase(DELETE)) {
					filteredAmendments.add(eachamendment);
				}
			}
		}
		return filteredAmendments;
	}
	
	
	/**
	 * This method returns the seqId for perticular Leg
	 * @param leg
	 * @return
	 */
	public static Integer getAttachmentsSeqIdForLegObj(Object leg) {
		if(leg instanceof RCALegRequest) {
			RCALegRequest rcaLeg = (RCALegRequest) leg;
			return rcaLeg.getLegSummary().getLegSeqId();
		} else if(leg instanceof EquityLegRequest) {
			EquityLegRequest equityLeg = (EquityLegRequest) leg;
			return equityLeg.getLegSummary().getLegSeqId();
		} else if(leg instanceof OtherLegRequest) {
			OtherLegRequest otherLeg = (OtherLegRequest) leg;
			return otherLeg.getLegSummary().getLegSeqId();
		} else if(leg instanceof CPALegRequest) {
			CPALegRequest cpaLeg = (CPALegRequest) leg;
			return cpaLeg.getCPASummary().getLegSeqId();
		}
		return null;
	}
	
	/**
	 * This method returns the attachments for perticular leg
	 * @param leg
	 * @return
	 */
	public static List<Attachment> getAttachments(Object leg) {
		if(leg instanceof RCALegRequest) {
			RCALegRequest rcaLeg = (RCALegRequest) leg;
			return rcaLeg.getLegSummary().getAttachments();
		} else if(leg instanceof EquityLegRequest) {
			EquityLegRequest equityLeg = (EquityLegRequest) leg;
			return equityLeg.getLegSummary().getAttachments();
		} else if(leg instanceof OtherLegRequest) {
			OtherLegRequest otherLeg = (OtherLegRequest) leg;
			return otherLeg.getLegSummary().getAttachments();
		} else if(leg instanceof CPALegRequest) {
			CPALegRequest cpaLeg = (CPALegRequest) leg;
			return cpaLeg.getCPASummary().getAttachments();
		}
		return null;
	}
	
	/**
	 *  This method used to set the attachments for particular leg type
	 * @param leg
	 * @param attachments
	 */
	public static void setAttachments(Object leg, List<Attachment> attachments) {
		if(attachments == null) {
			return;
		}
		if(leg instanceof RCALegRequest) {
			RCALegRequest rcaLeg = (RCALegRequest) leg;
			LegSummary legSummary = rcaLeg.getLegSummary();
			if(legSummary == null) {
				legSummary = new LegSummary();
				rcaLeg.setLegSummary(legSummary);
			}
			legSummary.setAttachments(attachments);
		} else if(leg instanceof EquityLegRequest) {
			EquityLegRequest equityLeg = (EquityLegRequest) leg;
			LegSummary legSummary = equityLeg.getLegSummary();
			if(legSummary == null) {
				legSummary = new LegSummary();
				equityLeg.setLegSummary(legSummary);
			}
			legSummary.setAttachments(attachments);
		} else if(leg instanceof OtherLegRequest) {
			OtherLegRequest otherLeg = (OtherLegRequest) leg;
			LegSummary legSummary = otherLeg.getLegSummary();
			if(legSummary == null) {
				legSummary = new LegSummary();
				otherLeg.setLegSummary(legSummary);
			}
			legSummary.setAttachments(attachments);
		} else if(leg instanceof CPALegRequest) {
			CPALegRequest cpaLeg = (CPALegRequest) leg;
			CPASummary summary = cpaLeg.getCPASummary();
			if(summary == null) {
				summary = new CPASummary();
				cpaLeg.setCPASummary(summary);
			}
			summary.setAttachments(attachments);
		}
	}
	
	/**
	 * prepareSearchForm
	 * @param form
	 * @param mapping
	 * @param request
	 * @param action
	 */
	public static void prepareSearchForm(DynaActionForm form,
			ActionMapping mapping, HttpServletRequest request, Action action){
		DynaActionForm lenderEntity = FormUtils.getInstance().createDynaActionForm(ICFPLegHelper.LENDER_FORM, mapping.getModuleConfig(), action);
		form.set(LENDER, lenderEntity);
		DynaActionForm borrowerEntity = FormUtils.getInstance().createDynaActionForm(ICFPLegHelper.BORROWER_FORM, mapping.getModuleConfig(), action);
		form.set(BORROWER, borrowerEntity);
		DynaActionForm cashPoolParticipantEntity = FormUtils.getInstance().createDynaActionForm(ICFPLegHelper.CASH_POOL_PARTICIPANT_FORM, mapping.getModuleConfig(), action);
		form.set(CASHPOOLPARTICIPANT, cashPoolParticipantEntity);
		DynaActionForm cashPoolLeaderEntity = FormUtils.getInstance().createDynaActionForm(ICFPLegHelper.CASH_POOL_LEADER_FORM, mapping.getModuleConfig(), action);
		form.set(CASHPOOLLEADER, cashPoolLeaderEntity);
	}
	/**
	 * prepareTCLForm
	 * @param form
	 * @param mapping
	 * @param request
	 * @param action
	 */
	public static void prepareTCLForm(DynaActionForm form,
			ActionMapping mapping, HttpServletRequest request, Action action){
		DynaActionForm fourBlockerForm = (DynaActionForm) form.get(FOURBLOCKER);
		if(fourBlockerForm == null || fourBlockerForm.getDynaClass() == null) {
			fourBlockerForm = FormUtils.getInstance().createDynaActionForm(FOURBLOCKERFORM, mapping.getModuleConfig(), action);
			form.set(FOURBLOCKER, fourBlockerForm);
		}
		
		DynaActionForm tClassificationLevelForm = (DynaActionForm) fourBlockerForm.get(TCLASSIFICATIONLEVEL);
		if(tClassificationLevelForm == null || tClassificationLevelForm.getDynaClass() == null) {
			tClassificationLevelForm = FormUtils.getInstance().createDynaActionForm(TCLASSIFICATIONLEVELFORM, mapping.getModuleConfig(), action);
			fourBlockerForm.set(TCLASSIFICATIONLEVEL, tClassificationLevelForm);
		}
		
		// Following code identifies whether deal is changed after the form sync
		boolean sync = false;
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		if(request.getSession().getAttribute(ICFPLegHelper.RU_DEAL_ID) == null) {
			request.getSession().setAttribute(ICFPLegHelper.RU_DEAL_ID, deal.getDealSeqId());
			sync = true;
		} else {
			Integer dealSeqId = (Integer) request.getSession().getAttribute(ICFPLegHelper.RU_DEAL_ID);
			sync = (!dealSeqId.equals(deal.getDealSeqId()));
		}
		
		if(sync) {
			Boolean riskOverrideFlagBoolean = deal.isRiskOverrideFlag();
			
			if(riskOverrideFlagBoolean == Boolean.TRUE) {
				tClassificationLevelForm.set(ICFPLegHelper.RISK_REVIEW_OVERRIDE, ONE);
				Integer ruAmendedTcl = deal.getRuAmendedTcl();
				String revisedTclComments = deal.getRevisedTclComments();
				if(ruAmendedTcl != null) {
					tClassificationLevelForm.set(ICFPLegHelper.RU_AMENDED_TCL, String.valueOf(ruAmendedTcl));
				}
				tClassificationLevelForm.set(ICFPLegHelper.REVISED_TCL_COMMENTS, revisedTclComments);
			} else if (riskOverrideFlagBoolean == Boolean.FALSE) {
				tClassificationLevelForm.set(ICFPLegHelper.RISK_REVIEW_OVERRIDE, ICFPConstants.ZERO);
			} else if(riskOverrideFlagBoolean == null){
				tClassificationLevelForm.set(ICFPLegHelper.RISK_REVIEW_OVERRIDE, null);
				tClassificationLevelForm.set(ICFPLegHelper.RU_AMENDED_TCL, null);
				tClassificationLevelForm.set(ICFPLegHelper.REVISED_TCL_COMMENTS, null);
				
			}
		}
	}
	/**
	 * prepareICFPLegRequestForm
	 * @param form
	 * @param mapping
	 * @param request
	 * @param action
	 */
	public static void prepareICFPLegRequestForm(DynaActionForm form,
			ActionMapping mapping, HttpServletRequest request, Action action){
	
			DynaActionForm guarantorInformation = FormUtils.getInstance().createDynaActionForm(ICFPLegHelper.ENTITY_INFO_FORM, mapping.getModuleConfig(), action);
			form.set(ICFPLegHelper.GUARANTOR_INFORMATION, guarantorInformation);

			DynaActionForm legSummary = FormUtils.getInstance().createDynaActionForm(ICFPLegHelper.LEG_SUMMARY_FORM, mapping.getModuleConfig(), action);
			form.set(LEGSUMMARY, legSummary);

			DynaActionForm lenderEntity = FormUtils.getInstance().createDynaActionForm(ENTITYFORM, mapping.getModuleConfig(), action);
			legSummary.set(LENDERENTITY, lenderEntity);

			DynaActionForm borrowerEntity = FormUtils.getInstance().createDynaActionForm(ENTITYFORM, mapping.getModuleConfig(), action);
			legSummary.set(BORROWERENTITY, borrowerEntity);

			DynaActionForm guarantorEntity = FormUtils.getInstance().createDynaActionForm(ENTITYFORM, mapping.getModuleConfig(), action);
			legSummary.set(GUARANTORENTITY, guarantorEntity);

			
			DynaActionForm lenderTCodeEntity = FormUtils.getInstance().createDynaActionForm(ENTITYFORM, mapping.getModuleConfig(), action);
			legSummary.set(LENDERTCODEENTITY, lenderTCodeEntity);

			DynaActionForm borrowerTCodeEntity = FormUtils.getInstance().createDynaActionForm(ENTITYFORM, mapping.getModuleConfig(), action);
			legSummary.set(BORROWERTCODEENTITY, borrowerTCodeEntity);
	}
	
	/**
	 * This method is used to add the solvency matrix object if not exists in the form.
	 * @param icfpLegForm
	 * @param mapping
	 * @param request
	 * @param action
	 */
	public static void prepareTPLegRequestSubForm(DynaActionForm icfpLegForm, ActionMapping mapping, HttpServletRequest request, Action action) {
		DynaActionForm tpLegRequest = FormUtils.getInstance().createDynaActionForm(ICFPLegHelper.TP_LEG_REQUEST_FORM, mapping.getModuleConfig(), action);
		List<DynaActionForm> solvencyMatrix = null;
		if(tpLegRequest.get(SOLVENCYMETRICS)==null) {
			solvencyMatrix = new ArrayList<DynaActionForm>(7);
			for(int i=0; i<7; i++) {
				DynaActionForm solvencyMatrixForm = FormUtils.getInstance().createDynaActionForm(ICFPLegHelper.SOLVENCY_METRICS_FORM, mapping.getModuleConfig(), action);
				solvencyMatrixForm.set(SOLVENCYMETRICOPCODE, INSERT);
				solvencyMatrix.add(solvencyMatrixForm);
			}
			tpLegRequest.set(SOLVENCYMETRICS, solvencyMatrix);
			} 
		icfpLegForm.set("tpLegRequest", tpLegRequest);
	}
	
	/**
	 * 
	 * @param icfpLegForm
	 * @param mapping
	 * @param request
	 * @param action
	 */
	public static void prepareRateInfoSubForm(DynaActionForm form, ActionMapping mapping, HttpServletRequest request, Action action) {
		DynaActionForm rateInformation = FormUtils.getInstance().createDynaActionForm(ICFPLegHelper.RATE_INFORMATION_FORM, mapping.getModuleConfig(), action);
		form.set(RATEINFORMATION, rateInformation);
	}
	
	/**
	 * 
	 * @param leg
	 * @throws ICFPException 
	 */
	public static void prepareQualitativeFactors(Object leg, Integer... ids) throws ICFPException {
		String legSummaryProperty = (leg instanceof CPALegRequest) ? CPASUMMARY : LEGSUMMARY;
		Object summary = Utils.fetchPropertyValue(legSummaryProperty, leg, Object.class);
		@SuppressWarnings("unchecked")
		List<QualitativeFactors> allQualitativeFactors = Utils.fetchPropertyValue(QUALITATIVEFACTORS, summary, List.class);
		
		if(ids != null && ids.length > 0) {
			Map<Integer, QualitativeFactors> idToQualitativeFactorMap = createQualitativeFactrosMap(allQualitativeFactors);
			
			for(Integer eachId : ids) {
				QualitativeFactors qualitativeFactors = idToQualitativeFactorMap.get(eachId);
				if(qualitativeFactors == null) {
					qualitativeFactors = new QualitativeFactors();
					qualitativeFactors.setQualitativeFactorId(eachId);
					qualitativeFactors.setQualitativeFactor(QualitativeFactorsType.fromId(eachId).getName());
					qualitativeFactors.setQualitativeFactorOpcode(INSERT);
					allQualitativeFactors.add(qualitativeFactors);
				} else {
					if(StringUtils.isBlank(qualitativeFactors.getQualitativeFactorOpcode())) {
						qualitativeFactors.setQualitativeFactorOpcode(UPDATE);
					}
				}
			}
		}
	}
	
	/**
	 * Creates Map of {@link QualitativeFactors} with key as id
	 * 
	 * @param qualitativeFactors
	 * @return
	 */
	public static Map<Integer, QualitativeFactors> createQualitativeFactrosMap(List<QualitativeFactors> qualitativeFactors) {
		Map<Integer, QualitativeFactors> idToQualitativeFactorMap = new HashMap<Integer, QualitativeFactors>();
		for(QualitativeFactors qualitativeFactor : qualitativeFactors) {
			idToQualitativeFactorMap.put(qualitativeFactor.getQualitativeFactorId(), qualitativeFactor);
		}
		return idToQualitativeFactorMap;
	}
	
	/**
	 * 
	 * @param qualitativeFactors
	 * @return
	 */
	public static void populateQualitativeFactors(QualitativeFactors to, QualitativeFactors from) {
		to.setQualitativeFactor(from.getQualitativeFactor());
		to.setAssessment(from.getAssessment());
		to.setAssessmentId(from.getAssessmentId());
		to.setOwnerSso(from.getOwnerSso());
		to.setComment(from.getComment());
		to.setQualitativeFactorId(from.getQualitativeFactorId());
		to.setQualitativeFactorDesc(from.getQualitativeFactorDesc());
		to.setRoleId(from.getRoleId());
	}
	
	/**
	 * This method applies the specified {@link QualitativeFactors} to the leg.
	 * 
	 * @param leg
	 * @param qualitativeFactors
	 * @throws ICFPException 
	 */
	public static void applyQualitativeFactor(String qApplyAssessment,Object leg, List<QualitativeFactors> newQualitativeFactorsList, int... ids) throws ICFPException {
		if(ids == null || ids.length == 0) {
			return;
		}
		boolean isQAUpdate=true;
		boolean isCPA = (leg instanceof CPALegRequest);
		String legSummaryProperty = (isCPA) ? CPASUMMARY : LEGSUMMARY;
		Object legSummary = Utils.fetchPropertyValue(legSummaryProperty, leg, Object.class);
		@SuppressWarnings("unchecked")
		List<QualitativeFactors> legQualitativeFactorsList = Utils.fetchPropertyValue(QUALITATIVEFACTORS, legSummary, List.class);
		
		Map<Integer, QualitativeFactors> oldQualitativeFactorsMap = createQualitativeFactrosMap(legQualitativeFactorsList);
		Map<Integer, QualitativeFactors> newQualitativeFactorsMap = createQualitativeFactrosMap(newQualitativeFactorsList);
		for(Integer id : ids) {
			QualitativeFactors qualitativeFactors = oldQualitativeFactorsMap.get(id);
			if(qualitativeFactors != null) {
				
				if ("all".equals(qApplyAssessment)) {
					qualitativeFactors.setQualitativeFactorOpcode(ICFPConstants.UPDATE);
					
				} else if ("remaining".equals(qApplyAssessment)) {
					isQAUpdate=false;
					continue;
				}
				
			} else {
				qualitativeFactors = new QualitativeFactors();
				qualitativeFactors.setQualitativeFactorOpcode(INSERT);
				legQualitativeFactorsList.add(qualitativeFactors);
			}
			
			QualitativeFactors newQualitativeFactors = newQualitativeFactorsMap.get(id);
			populateQualitativeFactors(qualitativeFactors, newQualitativeFactors);
		}
		if(isQAUpdate){
		setOpCodeFlag(leg, UPDATE);
		}
	}

	/**
	 * prepareCPALegRequestForm
	 * @param form
	 * @param mapping
	 * @param request
	 * @param action
	 */
	public static void prepareCPALegRequestForm(DynaActionForm form,
			ActionMapping mapping, HttpServletRequest request, Action action) {
		DynaActionForm cpaSummary = FormUtils.getInstance().createDynaActionForm(ICFPLegHelper.CPA_SUMMARY_FORM, mapping.getModuleConfig(), action);
		form.set(CPASUMMARY_SMALL, cpaSummary);
		
		DynaActionForm rateInformation = FormUtils.getInstance().createDynaActionForm(ICFPLegHelper.RATE_INFORMATION_FORM, mapping.getModuleConfig(), action);
		form.set(RATEINFORMATION, rateInformation);
		
		DynaActionForm participantEntity = FormUtils.getInstance().createDynaActionForm(ENTITYFORM, mapping.getModuleConfig(), action);
		cpaSummary.set(PARTICIPANTENTITY, participantEntity);

		DynaActionForm poolLeaderEntity = FormUtils.getInstance().createDynaActionForm(ENTITYFORM, mapping.getModuleConfig(), action);
		cpaSummary.set(POOLLEADERENTITY, poolLeaderEntity);
	}
	
	/**
	 * synchLegWithForm
	 * @param leg
	 * @param form
	 * @param request
	 * @param context
	 * @param mapping
	 * @param action
	 * @throws ICFPException 
	 */
	public static void synchLegWithForm(Object leg, DynaActionForm form,
			HttpServletRequest request, ServletContext context,
			ActionMapping mapping, Action action) throws ICFPException {
	if(leg instanceof RCALegRequest) {
			syncRCALegWithForm((RCALegRequest) leg, form, request, context, mapping, action);
		} else if(leg instanceof EquityLegRequest) {
			syncEquityLegWithForm((EquityLegRequest) leg, form, request, context, mapping, action);
		} else if(leg instanceof OtherLegRequest) {
			synchOtherLegWithForm((OtherLegRequest) leg, form, request, context, mapping, action);
		}else if(leg instanceof CPALegRequest){
			syncCPALegWithForm((CPALegRequest) leg, form, request, context, mapping, action);
		}
	}
	
	/**
	 * syncCPALegWithForm
	 * @param cpaLeg
	 * @param form
	 * @param request
	 * @param context
	 * @param mapping
	 * @param action
	 * @throws ICFPException 
	 */
	public static void syncCPALegWithForm(CPALegRequest cpaLeg, DynaActionForm form, HttpServletRequest request, ServletContext context, ActionMapping mapping, Action action) throws ICFPException {
		CPASummary cpaSummary = cpaLeg.getCPASummary();
		
		if(cpaSummary == null) {
			cpaSummary = new CPASummary();
			cpaLeg.setCPASummary(cpaSummary);
		}
		
		FormMapping formMapping = FormUtils.getInstance().findFormDefinition(CPALEGREQUESTFORM, context, mapping.getModuleConfig());
		FormUtils.getInstance().populateBeanFromForm(formMapping, cpaLeg, form, action, mapping, request);
		
		// Populate cpaSummary object explicitly; because there is variation in name between form and bean
		Integer transactionEventTypeId =  cpaLeg.getCPASummary().getTransactionEventTypeId();
		Integer legSeqId = cpaSummary.getLegSeqId();
		List<ExceptionRequestForm> exceptions = cpaSummary.getExceptionRequestForms();
		List<Attachment> attachments = cpaSummary.getAttachments();
		List<AttachmentTypeComments> attachmentTypeComments = cpaSummary.getAttachmentTypeComments();
		DynaActionForm legSummaryForm = (DynaActionForm) form.get(CPASUMMARY_SMALL);
		if(legSummaryForm!=null){
			FormMapping tpLegRequestFormMapping = FormUtils.getInstance().findFormDefinition(ICFPLegHelper.CPA_SUMMARY_FORM, context, mapping.getModuleConfig());
			FormUtils.getInstance().populateBeanFromForm(tpLegRequestFormMapping, cpaSummary, legSummaryForm, action, mapping, request);
		}
		cpaLeg.setCPASummary(cpaSummary);
		EntityHelper.syncEntitiesWithForm(cpaLeg, form, request, context, mapping, action);
		cpaLeg.getCPASummary().setLegSeqId(legSeqId);
		cpaLeg.getCPASummary().setAttachments(attachments);
		// Preserve attachments comments
		
		if(attachmentTypeComments != null) {
			cpaLeg.getCPASummary().setAttachmentTypeComments(attachmentTypeComments);
		}
		cpaLeg.getCPASummary().setExceptionRequestForms(exceptions);
		// transactionEventTypeId is not getting retained so capturing it into the var and using it to set the same later
		cpaLeg.getCPASummary().setTransactionEventTypeId(transactionEventTypeId);
		cpaLeg.getCPASummary().setLegSeqId(legSeqId);//temporary setting legSeqId but need to change above code
		
		boolean nonStandardFlag = true;
		
		if(cpaLeg.isNonStandardAgreementsFlag() != null &&
				!cpaLeg.isNonStandardAgreementsFlag())
		{
			nonStandardFlag = false;
		}
		
		syncExceptions(form, cpaLeg,nonStandardFlag, request);
		settingStandardTermsConditions(exceptions,request);
		ICFPDay2LegHelper.cleanDay2Operations(cpaLeg); // Added for Day2
	}

	
	/**
	 * 
	 * @param updateStatus
	 * @param form
	 * @param request
	 * @param context
	 * @param mapping
	 * @param action
	 */
	public static void syncTClassificationLevel(UpdateStatus updateStatus,DynaActionForm form, HttpServletRequest request,
			ServletContext context, ActionMapping mapping, Action action){
		DynaActionForm fourBlockerForm = (DynaActionForm) form.get(FOURBLOCKER);
		DynaActionForm tClassificationLevelForm = (DynaActionForm) fourBlockerForm.get(TCLASSIFICATIONLEVEL);
		
		TClassificationLevel tClassificationLevel = new TClassificationLevel();
		FormMapping tClassificationFormMapping = FormUtils.getInstance().findFormDefinition(TCLASSIFICATIONLEVELFORM, context, mapping.getModuleConfig());
		FormUtils.getInstance().populateBeanFromForm(tClassificationFormMapping, tClassificationLevel, tClassificationLevelForm, action, mapping, request);
		
		if(tClassificationLevel.getRiskReviewOverride() == null){
			tClassificationLevel.setRevisedTCLComments("");
			tClassificationLevel.setRUAmendedTCL(ONE);
			tClassificationLevel.setRiskReviewOverride(ICFPConstants.ZERO);
		}else if(tClassificationLevel.getRiskReviewOverride().equals(ICFPConstants.ZERO) ){
			tClassificationLevel.setRevisedTCLComments("");
			tClassificationLevel.setRUAmendedTCL(tClassificationLevel.getDefaultClassificationLevel());	
		}
		
		updateStatus.getFourBlocker().setTClassificationLevel(tClassificationLevel);
		
	}
	/**
	 * 
	 * @param updateStatus
	 * @param form
	 * @param request
	 * @param context
	 * @param mapping
	 * @param action
	 */
	public static void syncTPriorityTimings(UpdateStatus updateStatus,DynaActionForm form, HttpServletRequest request,
			ServletContext context, ActionMapping mapping, Action action){
		DynaActionForm fourBlockerForm = (DynaActionForm) form.get(FOURBLOCKER);
		DynaActionForm tClassificationLevelForm = (DynaActionForm) fourBlockerForm.get(TPRIORITYTIMINGS);
		
		TPriorityTimings tPriorityTimings = new TPriorityTimings();
		FormMapping tClassificationFormMapping = FormUtils.getInstance().findFormDefinition(TPRIORITYTIMINGSFORM, context, mapping.getModuleConfig());
		FormUtils.getInstance().populateBeanFromForm(tClassificationFormMapping, tPriorityTimings, tClassificationLevelForm, action, mapping, request);
		updateStatus.getFourBlocker().setTPriorityTimings(tPriorityTimings);
	}
	/**
	 * 
	 * @param updateStatus
	 * @param form
	 * @param request
	 * @param context
	 * @param mapping
	 * @param action
	 */
	public static void syncTSummaryOwner(UpdateStatus updateStatus,DynaActionForm form, HttpServletRequest request,
			ServletContext context, ActionMapping mapping, Action action){
		DynaActionForm fourBlockerForm = (DynaActionForm) form.get(FOURBLOCKER);
		DynaActionForm tSummaryOwnerForm = (DynaActionForm) fourBlockerForm.get(TSUMMARYOWNER);
		
		TSummaryOwner tSummaryOwner = new TSummaryOwner();
		FormMapping tClassificationFormMapping = FormUtils.getInstance().findFormDefinition(TSUMMARYOWNERFORM, context, mapping.getModuleConfig());
		FormUtils.getInstance().populateBeanFromForm(tClassificationFormMapping, tSummaryOwner, tSummaryOwnerForm, action, mapping, request);
		updateStatus.getFourBlocker().setTSummaryOwner(tSummaryOwner);
	}
	

	/**
	 * 
	 * @param rcaLeg
	 * @param form
	 * @param request
	 * @param context
	 * @param mapping
	 * @param action
	 * @throws ICFPException 
	 */
	public static void syncRCALegWithForm(RCALegRequest rcaLeg,
			DynaActionForm form, HttpServletRequest request,
			ServletContext context, ActionMapping mapping, Action action) throws ICFPException {
		    List<ExceptionRequestForm> exceptions = null;
		  	List<DerivativesRequest> derivatives = null;
		  	List<AttachmentTypeComments> attachmentTypeComments = null;
		  	List<Amendment> amendments = (rcaLeg.getDayTwoOperations() != null) ? rcaLeg.getDayTwoOperations().getAmendments() : null;
			List<Attachment> attachments = null;
			@SuppressWarnings("unused")
			List<QualitativeFactors> qualitativeFactors = null;
			LegSummary legSummary = rcaLeg.getLegSummary();
			Integer legSeqId = null;
			if(legSummary != null) {
				exceptions = legSummary.getExceptionRequestForms();
				derivatives = legSummary.getDerivativesRequests();
				attachments = legSummary.getAttachments();
				attachmentTypeComments = legSummary.getAttachmentTypeComments();
				qualitativeFactors = legSummary.getQualitativeFactors();
				legSeqId = legSummary.getLegSeqId();
			}
			
			TPLegRequest tpLegRequest = rcaLeg.getTPLegRequest();
			@SuppressWarnings("unused")
			List<SolvencyMetrics> solvencyMetricsList = null;
			if(tpLegRequest!=null)
			{
				solvencyMetricsList = tpLegRequest.getSolvencyMetrics();
			}
			DynaActionForm legSummaryForm = (DynaActionForm) form.get(LEGSUMMARY);
			String usdEquivalent = legSummaryForm.getString(USDEQUIVALENT);
			if(usdEquivalent!=null && !usdEquivalent.equals(""))
			{
				legSummaryForm.set(USDEQUIVALENT, (ICFPCommonHelper.convetCurrencyFormatToDouble(usdEquivalent))+"");
			}
			String originalCCYAmount = legSummaryForm.getString(ORIGINALCCYAMOUNT);
			if(originalCCYAmount!=null && !originalCCYAmount.equals(""))
			{
				legSummaryForm.set(ORIGINALCCYAMOUNT, (ICFPCommonHelper.convetCurrencyFormatToDouble(originalCCYAmount))+"");
			}else {
				rcaLeg.getLegSummary().setOriginalCCYAmount(null);
			}
			
			String immdtDrdownAmt = form.getString(IMMDTDRDOWNAMT);
			if(immdtDrdownAmt!=null && !immdtDrdownAmt.equals(""))
			{
				form.set(IMMDTDRDOWNAMT, (ICFPCommonHelper.convetCurrencyFormatToDouble(immdtDrdownAmt))+"");
			}else {
				rcaLeg.setImmdtDrdownAmt(null);
			}
			
			
			String dayOneCCYAmount = legSummaryForm.getString(ICFPLegHelper.DAY_ONE_CCY_AMOUNT);
			if(dayOneCCYAmount!=null && !dayOneCCYAmount.equals(""))
			{
				legSummaryForm.set(ICFPLegHelper.DAY_ONE_CCY_AMOUNT, (ICFPCommonHelper.convetCurrencyFormatToDouble(dayOneCCYAmount))+"");
			}else {
				rcaLeg.getLegSummary().setDayOneCCYAmount(null);
			}
			
			String netProceedsAmt = legSummaryForm.getString(NET_PROCEEDS_AMT);
			if(netProceedsAmt!=null && StringUtils.isNotEmpty(netProceedsAmt))
			{
				legSummaryForm.set(NET_PROCEEDS_AMT, (ICFPCommonHelper.convertNegativeCurrencyFormatToDouble(netProceedsAmt))+"");
			}
			
			String dayOneUSDEquivalent = legSummaryForm.getString(DAYONEUSDEQUIVALENT);
			if(dayOneUSDEquivalent!=null && !dayOneUSDEquivalent.equals(""))
			{
				legSummaryForm.set(DAYONEUSDEQUIVALENT, (ICFPCommonHelper.convetCurrencyFormatToDouble(dayOneUSDEquivalent))+"");
			}else {
				rcaLeg.getLegSummary().setDayOneUSDEquivalent(null);
			}
			
			
			if(rcaLeg.getLegSummary().getTransactionEventTypeId()!=null && rcaLeg.getLegSummary().getTransactionEventTypeId() == 5){
				
				DynaActionForm day2Form = (DynaActionForm) form.get(DAYTWOOPERATIONS);
				DynaActionForm incForm = (DynaActionForm) day2Form.get(FACILITYINCREASEDECREASE);
				String facilityIncDecUSDEquivalentAmt = incForm.getString(FACILITYINCDECUSDEQUIVALENTAMT);
				
				if(facilityIncDecUSDEquivalentAmt!=null && !"".equals(facilityIncDecUSDEquivalentAmt)){
					incForm.set(FACILITYINCDECUSDEQUIVALENTAMT, (ICFPCommonHelper.convetCurrencyFormatToDouble(facilityIncDecUSDEquivalentAmt))+"");
				}
				
				
				String amendedUSDEquivalentAmt = incForm.getString(AMENDEDUSDEQUIVALENTAMT);
				if(amendedUSDEquivalentAmt!=null && !"".equals(amendedUSDEquivalentAmt)){
					incForm.set(AMENDEDUSDEQUIVALENTAMT, (ICFPCommonHelper.convetCurrencyFormatToDouble(amendedUSDEquivalentAmt))+"");
				}
			}
			
			
			FormMapping formMapping = FormUtils.getInstance().findFormDefinition(ICFPLEGREQUESTFORM, context, mapping.getModuleConfig());
			FormUtils.getInstance().populateBeanFromForm(formMapping, rcaLeg, form, action, mapping, request);
			if(amendments != null) {
				rcaLeg.getDayTwoOperations().setAmendments(amendments);
			}
			ICFPDay2LegHelper.syncDay2OperationsWithForm(rcaLeg, form, request, context, mapping, action);// Added for Day2
			
			rcaLeg = setDayOneAmts(legSummaryForm, rcaLeg);
			
			EntityHelper.syncEntitiesWithForm(rcaLeg, form, request, context, mapping, action); // Added to sync entities
			rcaLeg.getLegSummary().setLegSeqId(legSeqId);
			// Preserve derivatives
			if(derivatives != null) {
				rcaLeg.getLegSummary().setDerivativesRequests(derivatives);
			}
			// Preserve attachments
			if(attachments != null) {
				rcaLeg.getLegSummary().setAttachments(attachments);
			}
			// Preserve attachments comments
			if(attachmentTypeComments != null) {
				rcaLeg.getLegSummary().setAttachmentTypeComments(attachmentTypeComments);
			}
			
			boolean nonStandardFlag = true;
			
			if(rcaLeg.getLegSummary().isNonStandardAgreementsFlag() != null &&
					!rcaLeg.getLegSummary().isNonStandardAgreementsFlag())
			{
				nonStandardFlag = false;
			}
			
			if(exceptions != null) {
				rcaLeg.getLegSummary().setExceptionRequestForms(exceptions);
			}
					
			syncExceptions(form, rcaLeg, nonStandardFlag, request);
			settingStandardTermsConditions(exceptions,request);			

			DynaActionForm tpLegRequestForm = (DynaActionForm) form.get(TPLEGREQUEST);
			
			if(tpLegRequest==null)
				tpLegRequest = new TPLegRequest();
			
			if(tpLegRequestForm!=null && tpLegRequestForm.getDynaClass() != null){
				
			FormMapping tpLegRequestFormMapping = FormUtils.getInstance().findFormDefinition(ICFPLegHelper.TP_LEG_REQUEST_FORM, context, mapping.getModuleConfig());
			FormUtils.getInstance().populateBeanFromForm(tpLegRequestFormMapping, tpLegRequest, tpLegRequestForm, action, mapping, request);
			}
			rcaLeg.setTPLegRequest(tpLegRequest);
			if(rcaLeg.getLegSummary().isDerivativesFlag()!=null){
				if(rcaLeg.getLegSummary().isDerivativesFlag().booleanValue() == false) {
					deletedDerivatives(rcaLeg.getLegSummary().getDerivativesRequests());
				}
			}
			if(rcaLeg.isGuaranteeFeeApplicableFlag()!=null && !rcaLeg.isGuaranteeFeeApplicableFlag())
			{
				rcaLeg.setGuaranteeFeeRate(null);
			}
			
			if(!StringUtils.isNotBlank(rcaLeg.getLegSummary().getTransactionEventType())){
				if(rcaLeg.isImmdtDrdownApplicableFlag()!=null && !rcaLeg.isImmdtDrdownApplicableFlag()){
					
					rcaLeg.setImmdtDrdownAmt(null);
					rcaLeg.setDrdownValueDt(null);
				}
			}
			
			EventType eventType = ICFPDay2LegHelper.getEventType(rcaLeg);
			if(eventType == null) {
				if(rcaLeg.isOtherFeeFlag()!=null && !rcaLeg.isOtherFeeFlag()){
					rcaLeg.getLegSummary().setFees(null);
					rcaLeg.setOtherFeeCCY(null);
				}
			}
			
			ICFPDay2LegHelper.cleanDay2Operations(rcaLeg); // Added for Day2
	}

	/**
	 * deletedDerivatives
	 * @param derivatives list
	 */
	private static void deletedDerivatives(List<DerivativesRequest> derivatives) {
		if(derivatives != null && !derivatives.isEmpty()) {
			for(ListIterator<DerivativesRequest> itr= derivatives.listIterator(); itr.hasNext(); ) {
				DerivativesRequest derivativeRequest = itr.next();
				if(derivativeRequest.getDeriativesSeqId() == null) {
					itr.remove();
				} else if(derivativeRequest.getDerivativesOpcode() == null 
						|| !derivativeRequest.getDerivativesOpcode().equals(DELETE)) {
					derivativeRequest.setDerivativesOpcode(DELETE);
				}
			}
		}
	}

	/**
	 * syncEquityLegWithForm
	 * @param leg
	 * @param form
	 * @param request
	 * @param servletContext
	 * @param mapping
	 * @param action
	 * @throws ICFPException 
	 */
	public static void syncEquityLegWithForm(EquityLegRequest leg,
			DynaActionForm form, HttpServletRequest request,
			ServletContext servletContext, ActionMapping mapping,
			Action action) throws ICFPException {
		List<ShareInfo> shareInfos = leg.getShareInfos();
		LegSummary legSummary = leg.getLegSummary();
		List<Amendment> amendments = (leg.getDayTwoOperations() != null) ? leg.getDayTwoOperations().getAmendments() : null;
		if(legSummary == null) {
			legSummary = new LegSummary();
			leg.setLegSummary(legSummary);
		}
		Integer seqId = legSummary.getLegSeqId();
		List<Attachment> attachments = legSummary.getAttachments();
		List<ExceptionRequestForm> exceptions = legSummary.getExceptionRequestForms();
		List<AttachmentTypeComments> attachmentTypeComments = legSummary.getAttachmentTypeComments();
		Integer equityFormId = (Integer)form.get(ICFPLegHelper.EQUITY_FORM_ID);
		leg.setEquityFormId(equityFormId);
		leg.setEquityInfusionsDividendsFlag((Boolean)form.get(ICFPLegHelper.EQUITY_INFUSIONS_DIVIDENDS_FLAG));
		leg.setDoubleLeverageFlag((Boolean) form.get(ICFPLegHelper.DOUBLE_LEVERAGE_FLAG));

		leg.setOtherEquityComments(form.getString(OTHEREQUITYCOMMENTS));
		leg.setEBoardApprovalRequiredFlag((Boolean) form.get(EBOARDAPPROVALREQUIREDFLAG));
		String crossBorderFlag = form.getString(CROSS_BORDER_FLAG);
		if(crossBorderFlag!=null && StringUtils.isNotEmpty(crossBorderFlag)){
			if(crossBorderFlag.equals(ICFPConstants.TRUE_SMALL))
			{
				leg.setCrossBorderFlag(true);
			}else if(crossBorderFlag.equals(ICFPConstants.FALSE_SMALL)){
				leg.setCrossBorderFlag(false);
			}
			
		}
		if(amendments != null) {
					leg.getDayTwoOperations().setAmendments(amendments);
				}
		ICFPDay2LegHelper.syncDay2OperationsWithForm(leg, form, request, servletContext, mapping, action); // Added for Day2
		DynaActionForm legSummaryForm = (DynaActionForm) form.get(LEGSUMMARY);
		FormMapping legSummaryMapping = FormUtils.getInstance().findFormDefinition(ICFPLegHelper.LEG_SUMMARY_FORM, servletContext, mapping.getModuleConfig());
		String usdEquivalent = legSummaryForm.getString(USDEQUIVALENT);
		if(usdEquivalent!=null && !usdEquivalent.equals(""))
		{
			legSummaryForm.set(USDEQUIVALENT, (ICFPCommonHelper.convetCurrencyFormatToDouble(usdEquivalent))+"");
		}
		String dayOneCCYAmount = legSummaryForm.getString(ICFPLegHelper.DAY_ONE_CCY_AMOUNT);
		if(dayOneCCYAmount!=null && !dayOneCCYAmount.equals(""))
		{
			legSummaryForm.set(ICFPLegHelper.DAY_ONE_CCY_AMOUNT, (ICFPCommonHelper.convetCurrencyFormatToDouble(dayOneCCYAmount))+"");
		}
		
		String dayOneUSDEquivalent = legSummaryForm.getString(DAYONEUSDEQUIVALENT);
		if(dayOneUSDEquivalent!=null && !dayOneUSDEquivalent.equals(""))
		{
			legSummaryForm.set(DAYONEUSDEQUIVALENT, (ICFPCommonHelper.convetCurrencyFormatToDouble(dayOneUSDEquivalent))+"");
		}
		String originalCCYAmount = legSummaryForm.getString(ORIGINALCCYAMOUNT);
		if(originalCCYAmount!=null && !originalCCYAmount.equals(""))
		{
			legSummaryForm.set(ORIGINALCCYAMOUNT, (ICFPCommonHelper.convetCurrencyFormatToDouble(originalCCYAmount))+"");
		}else {
			legSummary.setOriginalCCYAmount(null);
		}
		
		String grossSettlementAmt = legSummaryForm.getString(GROSSSETTLEMENTAMT);
		if(grossSettlementAmt!=null && !grossSettlementAmt.equals(""))
		{
			legSummaryForm.set(GROSSSETTLEMENTAMT, (ICFPCommonHelper.convetCurrencyFormatToDouble(grossSettlementAmt))+"");
		}else {
			legSummary.setGrossSettlementAmt(null);
		}
		
		FormUtils.getInstance().populateBeanFromForm(legSummaryMapping, legSummary, legSummaryForm, action, mapping, request);
		EntityHelper.syncEntitiesWithForm(leg, form, request, servletContext, mapping, action); // Added to sync entities
		legSummary.setLegSeqId(seqId);
		leg.getLegSummary().setAttachments(attachments);
		
		// Preserve attachments comments
		if(attachmentTypeComments != null) {
			leg.getLegSummary().setAttachmentTypeComments(attachmentTypeComments);
		}
		boolean nonStandardFlag = true;
		
		if(legSummary.isNonStandardAgreementsFlag() != null &&
				!legSummary.isNonStandardAgreementsFlag())
		{
			nonStandardFlag = false;
		}
		
		legSummary.setExceptionRequestForms(exceptions);
		syncExceptions(form, leg, nonStandardFlag, request);
		settingStandardTermsConditions(exceptions,request);
		leg.getLegSummary().setExceptionRequestForms(exceptions);
				
		EventType eventType = ICFPDay2LegHelper.getEventType(leg);
		if(eventType == null) {
			syncSharesInfos(form, shareInfos, equityFormId);
			leg.setShareInfos(shareInfos);
		}
		
		if(equityFormId == null || equityFormId == 0){
			leg.setEquityFormId(null);
		}
		
		if(attachments != null) {
			legSummary.setAttachments(attachments);
		}
	}

	/**
	 * synchOtherLegWithForm
	 * @param leg
	 * @param form
	 * @param request
	 * @param servletContext
	 * @param mapping
	 * @param action
	 * @throws ICFPException 
	 */
	public static void synchOtherLegWithForm(OtherLegRequest leg,
			DynaActionForm form, HttpServletRequest request,
			ServletContext servletContext, ActionMapping mapping,
			Action action) throws ICFPException {
		
		LegSummary legSummary = leg.getLegSummary();
		List<DerivativesRequest> derivativeAttachments = null;
		if(legSummary == null) {
			legSummary = new LegSummary();
			leg.setLegSummary(legSummary);
		}
		Integer legSeqId = legSummary.getLegSeqId();
		List<Attachment> attachments = legSummary.getAttachments();
		List<AttachmentTypeComments> attachmentTypeComments = legSummary.getAttachmentTypeComments();
		List<ExceptionRequestForm> exceptions = legSummary.getExceptionRequestForms();
		if(legSummary.getDerivativesRequests()!=null) {
			derivativeAttachments = legSummary.getDerivativesRequests();
		}
		if(StringUtils.isNotBlank(form.getString(ICFPLegHelper.DESCRIPTION))) {
			leg.setDescription(form.getString(ICFPLegHelper.DESCRIPTION));
		}
					
		String crossBorderFlag = form.getString(CROSS_BORDER_FLAG);
		if(crossBorderFlag!=null && StringUtils.isNotEmpty(crossBorderFlag)){
			if(crossBorderFlag.equals("true"))
			{
				leg.setCrossBorderFlag(true);
			}else if(crossBorderFlag.equals("false")){
				leg.setCrossBorderFlag(false);
			}
		}
		
		DynaActionForm legSummaryForm = (DynaActionForm) form.get(LEGSUMMARY);
		String usdEquivalent = legSummaryForm.getString(USDEQUIVALENT);
		if(StringUtils.isNotBlank(usdEquivalent)) {
			legSummaryForm.set(USDEQUIVALENT, (ICFPCommonHelper.convetCurrencyFormatToDouble(usdEquivalent))+"");
		}
		String originalCCYAmount = legSummaryForm.getString(ORIGINALCCYAMOUNT);
		if(StringUtils.isNotBlank(originalCCYAmount)) {
			legSummaryForm.set(ORIGINALCCYAMOUNT, (ICFPCommonHelper.convetCurrencyFormatToDouble(originalCCYAmount))+"");
		}else {
			legSummary.setOriginalCCYAmount(null);
		}
		
		FormMapping legSummaryMapping = FormUtils.getInstance().findFormDefinition(ICFPLegHelper.LEG_SUMMARY_FORM, servletContext, mapping.getModuleConfig());
		FormUtils.getInstance().populateBeanFromForm(legSummaryMapping, legSummary, legSummaryForm, action, mapping, request);
		EntityHelper.syncEntitiesWithForm(leg, form, request, servletContext, mapping, action); // Added to sync entities
		legSummary.setLegSeqId(legSeqId);
		
		boolean nonStandardFlag = true;
		if(legSummary.isNonStandardAgreementsFlag() != null &&
				!legSummary.isNonStandardAgreementsFlag())
		{
			nonStandardFlag = false;
		}
		// Preserve attachments comments
		if(attachmentTypeComments != null) {
			leg.getLegSummary().setAttachmentTypeComments(attachmentTypeComments);
		}
		legSummary.setExceptionRequestForms(exceptions);
		syncExceptions(form, leg, nonStandardFlag, request);
		settingStandardTermsConditions(exceptions,request);
		leg.getLegSummary().setExceptionRequestForms(exceptions);
		
		leg.getLegSummary().setAttachments(attachments);
		
		if(derivativeAttachments != null) {
			legSummary.setDerivativesRequests(derivativeAttachments);
		}
		
		if(leg.getLegSummary().isDerivativesFlag()!=null){
			if(leg.getLegSummary().isDerivativesFlag().booleanValue() == false) {
				deletedDerivatives(leg.getLegSummary().getDerivativesRequests());
			}
		}
		DynaActionForm tpLegRequestForm = (DynaActionForm) form.get(TPLEGREQUEST);
		DynaActionForm rateInformationForm = (DynaActionForm) form.get(RATEINFORMATION);
		TPLegRequest tpLegRequest = leg.getTPLegRequest();
		if(tpLegRequest == null) {
			tpLegRequest = new TPLegRequest();
			leg.setTPLegRequest(tpLegRequest);
		}
		RateInformation rateInformation = leg.getRateInformation();
		if(rateInformation == null) {
			rateInformation = new RateInformation();
			leg.setRateInformation(rateInformation);
		}
		
		if(tpLegRequestForm!=null && tpLegRequestForm.getDynaClass() != null){
			FormMapping tpLegRequestFormMapping = FormUtils.getInstance().findFormDefinition(ICFPLegHelper.TP_LEG_REQUEST_FORM, servletContext, mapping.getModuleConfig());
			FormUtils.getInstance().populateBeanFromForm(tpLegRequestFormMapping, tpLegRequest, tpLegRequestForm, action, mapping, request);
		}
		
		if(rateInformationForm!=null){
			FormMapping rateInformationFormMapping = FormUtils.getInstance().findFormDefinition(ICFPLegHelper.RATE_INFORMATION_FORM, servletContext, mapping.getModuleConfig());
			FormUtils.getInstance().populateBeanFromForm(rateInformationFormMapping, rateInformation, rateInformationForm, action, mapping, request);
		}
		rateInformation = Utils.cleanBlankElements(rateInformation);
		String guaranteeFeeApplicableFlag = ((DynaActionForm) form).getString(ICFPLegHelper.GUARANTEE_FEE_APPLICABLE_FLAG);
		leg.setGuaranteeFeeApplicableFlag((StringUtils.isNotBlank(guaranteeFeeApplicableFlag)) ? Boolean.valueOf(guaranteeFeeApplicableFlag) : null);
		String guarenteeFeeRate = ((DynaActionForm) form).getString(ICFPLegHelper.GUARANTEE_FEE_RATE);
		leg.setGuaranteeFeeRate((StringUtils.isNotBlank(guarenteeFeeRate)) ? Double.valueOf(guarenteeFeeRate) : null);
		String guaranteeAgreementFlag = ((DynaActionForm) form).getString(ICFPLegHelper.GUARANTEE_AGREEMENT_FLAG);
		leg.setGuaranteeAgreementFlag((StringUtils.isNotBlank(guaranteeAgreementFlag)) ? Boolean.valueOf(guaranteeAgreementFlag) : null);
		ICFPDay2LegHelper.cleanDay2Operations(leg); // Added for Day2
	}
	
	/**
	 * syncFormWithLeg
	 * @param form
	 * @param leg
	 * @param request
	 * @param servletContext
	 * @param mapping
	 * @param action
	 * @throws ICFPException 
	 */
	public static void syncFormWithLeg(DynaActionForm form, Object leg, HttpServletRequest request,
			ServletContext servletContext, ActionMapping mapping,
			Action action) throws ICFPException {
		if(leg instanceof RCALegRequest) {
			syncFormWithRCALeg(form, (RCALegRequest) leg, request, servletContext, mapping, action);
		} else if(leg instanceof EquityLegRequest) {
			syncFormWithEquityLeg(form, (EquityLegRequest) leg, request, servletContext, mapping, action);
		} else if(leg instanceof OtherLegRequest) {
			syncFormWithOtherLeg(form, (OtherLegRequest) leg, request, servletContext, mapping, action);
		} else if(leg instanceof CPALegRequest) {
			syncFormWithCPALeg(form, (CPALegRequest) leg, request, servletContext, mapping, action);
		} 
	}
	
	/**
	 * syncFormWithRCALeg
	 * @param form
	 * @param leg
	 * @param request
	 * @param servletContext
	 * @param mapping
	 * @param action
	 * @throws ICFPException 
	 */
	public static void syncFormWithRCALeg(DynaActionForm form, RCALegRequest leg, HttpServletRequest request,
			ServletContext servletContext, ActionMapping mapping,
			Action action) throws ICFPException {
		ICFPDay2LegHelper.prepareLegForDay2Operations(leg); // Added for Day2
		FormUtils.getInstance().populateForm(ICFPLEGREQUESTFORM, form, leg, mapping.getModuleConfig(),action, mapping, request);
		DynaActionForm legSummaryForm = (DynaActionForm) form.get(LEGSUMMARY);	
		if(legSummaryForm == null) {
			legSummaryForm = FormUtils.getInstance().createDynaActionForm(ICFPLegHelper.LEG_SUMMARY_FORM, mapping.getModuleConfig(), action);
			form.set(LEGSUMMARY, legSummaryForm);
		}
		EntityHelper.syncFormWithEntities(form, leg, request, mapping, action); // Added for sync entities
		
		Double USDEquivalent = (leg.getLegSummary().getUSDEquivalent())==null?0:leg.getLegSummary().getUSDEquivalent();
		legSummaryForm.set(USDEQUIVALENT, ICFPCommonHelper.formatCurrency(USDEquivalent+""));
		
		if(leg.getLegSummary().getNetProceedsAmt()!=null){
		  legSummaryForm.set(NET_PROCEEDS_AMT, ICFPCommonHelper.formatNegativeCurrency(leg.getLegSummary().getNetProceedsAmt()+""));
		}
		
		String originalCurCode = (leg.getLegSummary().getOriginalCCY())==null?"":leg.getLegSummary().getOriginalCCY();
		if( !"".equals(originalCurCode) && !originalCurCode.contains("-")){
			String orgCurrency  =ICFPCommonHelper.getCurrencyNameById(originalCurCode, request);
			if(orgCurrency!=""){
				legSummaryForm.set(ORIGINALCCY, originalCurCode +"-"+orgCurrency);
			}
		}
		
		String dayOneCCYCode = (leg.getLegSummary().getDayOneCCY())==null?"":leg.getLegSummary().getDayOneCCY();
		if( !"".equals(dayOneCCYCode) && !dayOneCCYCode.contains("-")){
			String transCCY = ICFPCommonHelper.getCurrencyNameById(dayOneCCYCode, request);
			if(transCCY!=""){
				legSummaryForm.set(DAYONECCY, dayOneCCYCode +"-"+transCCY);
			}
		}
		
		Double dayOneusdEquivalent = (leg.getLegSummary().getDayOneUSDEquivalent())==null?0:leg.getLegSummary().getDayOneUSDEquivalent();
		legSummaryForm.set(DAYONEUSDEQUIVALENT, ICFPCommonHelper.formatCurrency(dayOneusdEquivalent+""));
		
		if(leg.getLegSummary().getTransactionEventTypeId()!=null && leg.getLegSummary().getTransactionEventTypeId() == 5){
			
			Double facilityIncDecUSDEquivalentAmt = (leg.getDayTwoOperations().getFacilityIncreaseDecrease().getFacilityIncDecUSDEquivalentAmt())==null?0:leg.getDayTwoOperations().getFacilityIncreaseDecrease().getFacilityIncDecUSDEquivalentAmt();
			DynaActionForm day2Form = (DynaActionForm) form.get(DAYTWOOPERATIONS);
			DynaActionForm incForm = (DynaActionForm) day2Form.get(FACILITYINCREASEDECREASE);
			
			if(facilityIncDecUSDEquivalentAmt!=null && facilityIncDecUSDEquivalentAmt!=0.0){
					incForm.set(FACILITYINCDECUSDEQUIVALENTAMT, PDFReportHelper.formatCurrency(facilityIncDecUSDEquivalentAmt));
			}
			
			Double amendedUSDEquivalentAmt = (leg.getDayTwoOperations().getFacilityIncreaseDecrease().getAmendedUSDEquivalentAmt())==null?0:leg.getDayTwoOperations().getFacilityIncreaseDecrease().getAmendedUSDEquivalentAmt();
			if(amendedUSDEquivalentAmt!=null && amendedUSDEquivalentAmt!=0.0){
				incForm.set(AMENDEDUSDEQUIVALENTAMT, PDFReportHelper.formatCurrency(amendedUSDEquivalentAmt));
			}
		}
		
		
		List<ExceptionRequestForm> exceptionList = leg.getLegSummary().getExceptionRequestForms();
		
		if(exceptionList!=null && exceptionList.size()>0)
		{
			((DynaActionForm)form).set(ICFPLegHelper.NON_STANDARD_AGREEMENTS_FLAG, TRUE_SMALL);
		}
		
	}
	

	/**
	 * syncFormWithEquityLeg
	 * @param form
	 * @param leg
	 * @param request
	 * @param servletContext
	 * @param mapping
	 * @param action
	 * @throws ICFPException 
	 */
	public static void syncFormWithEquityLeg(DynaActionForm form, EquityLegRequest leg, HttpServletRequest request,
			ServletContext servletContext, ActionMapping mapping,
			Action action) throws ICFPException {
		form.set(ICFPLegHelper.EQUITY_FORM_ID, leg.getEquityFormId());
		form.set(OTHEREQUITYCOMMENTS, leg.getOtherEquityComments());
		form.set(ICFPLegHelper.EQUITY_INFUSIONS_DIVIDENDS_FLAG, leg.isEquityInfusionsDividendsFlag());
		form.set(ICFPLegHelper.DOUBLE_LEVERAGE_FLAG, leg.isDoubleLeverageFlag());
		form.set(EBOARDAPPROVALREQUIREDFLAG, leg.isEBoardApprovalRequiredFlag());
		if(leg.isCrossBorderFlag()!=null && !leg.isCrossBorderFlag().toString().equals("")){
			form.set(ICFPLegHelper.CROSS_BORDER_FLAG, leg.isCrossBorderFlag().toString());	
		}
		ICFPDay2LegHelper.syncFormWithDay2Operations(form, leg, request, servletContext, mapping, action); // Added of Day2
		DynaActionForm legSummaryForm = (DynaActionForm) FormUtils.setFormValues(ICFPLegHelper.LEG_SUMMARY_FORM, leg.getLegSummary(), action, mapping, request);
		form.set(LEGSUMMARY, legSummaryForm);
		EntityHelper.syncFormWithEntities(form, leg, request, mapping, action); // Added for sync entities
		
		List<DynaActionForm> shareInfoForms = new ArrayList<DynaActionForm>();
		form.set(ICFPLegHelper.SHARE_INFOS, shareInfoForms);
		List<ShareInfo> shareInfos = leg.getShareInfos();
		if(!shareInfos.isEmpty()) {
			for(ShareInfo eachShareInfo : shareInfos) {
				DynaActionForm shareInfoForm = FormUtils.getInstance().createDynaActionForm(ICFPLegHelper.SHARE_INFO_FORM, mapping.getModuleConfig(), action);
				FormUtils.getInstance().populateForm(ICFPLegHelper.SHARE_INFO_FORM, shareInfoForm, eachShareInfo, mapping.getModuleConfig(), action, mapping, request);
				shareInfoForms.add(shareInfoForm);
			}
		}
		Double amount= leg.getLegSummary().getOriginalCCYAmount();
		BigDecimal bigDecAmt = new BigDecimal(0.0);
		if(!"".equals(amount) && amount!=null){
			bigDecAmt = new BigDecimal(amount);
		}

		StaticDataFactory statData = (StaticDataFactory) request.getSession().getServletContext().getAttribute(StaticDataFactory.CTX_KEY);
		String referenceData =  statData.getReferenceData();
		BigDecimal eboardAmt =  new BigDecimal(0.0);
		if(!"".equals(referenceData) && referenceData!=null){
			eboardAmt = new BigDecimal(referenceData);
		}
		
		if(amount!=null && !amount.equals("")){
			if(bigDecAmt.compareTo(eboardAmt) ==0 || bigDecAmt.compareTo(eboardAmt)==1){
				request.setAttribute(EBOARDARFLAGVALUE, YES_CAP);
			} else {
				request.setAttribute(EBOARDARFLAGVALUE, NO_CAP);
			}
		}
		
		Double USDEquivalent = (leg.getLegSummary().getUSDEquivalent())==null?0:leg.getLegSummary().getUSDEquivalent();
		legSummaryForm.set(USDEQUIVALENT, ICFPCommonHelper.formatCurrency(USDEquivalent+""));
		
		String originalCurCode = (leg.getLegSummary().getOriginalCCY())==null?"":leg.getLegSummary().getOriginalCCY();
		if( !"".equals(originalCurCode) && !originalCurCode.contains("-")){
			String orgCurrency  =ICFPCommonHelper.getCurrencyNameById(originalCurCode, request);
			if(orgCurrency!=""){
				legSummaryForm.set(ORIGINALCCY, originalCurCode +"-"+orgCurrency);
			}
		}
		
		String dayOneCCYCode = (leg.getLegSummary().getDayOneCCY())==null?"":leg.getLegSummary().getDayOneCCY();
		if( !"".equals(dayOneCCYCode) && !dayOneCCYCode.contains("-")){
			String transCCY = ICFPCommonHelper.getCurrencyNameById(dayOneCCYCode, request);
			if(transCCY!=""){
				legSummaryForm.set(DAYONECCY, dayOneCCYCode +"-"+transCCY);
			}
		}
		
		Double dayOneusdEquivalent = (leg.getLegSummary().getDayOneUSDEquivalent())==null?0:leg.getLegSummary().getDayOneUSDEquivalent();
		legSummaryForm.set(DAYONEUSDEQUIVALENT, ICFPCommonHelper.formatCurrency(dayOneusdEquivalent+""));
		
		DynaActionForm rateInformationForm = FormUtils.getInstance().createDynaActionForm(ICFPLegHelper.RATE_INFORMATION_FORM, mapping.getModuleConfig(), action);
		form.set(RATEINFORMATION, rateInformationForm);
	}
	
	/**
	 * syncFormWithCPALeg
	 * @param form
	 * @param leg
	 * @param request
	 * @param servletContext
	 * @param mapping
	 * @param action
	 * @throws ICFPException 
	 */
	public static void syncFormWithCPALeg(DynaActionForm form, CPALegRequest leg, HttpServletRequest request,
			ServletContext servletContext, ActionMapping mapping,
			Action action) throws ICFPException {
		form.reset(mapping, request);
		ICFPDay2LegHelper.prepareLegForDay2Operations(leg); // Added for Day2
		FormUtils.getInstance().populateForm(CPALEGREQUESTFORM, form, leg, mapping.getModuleConfig(),action, mapping, request);
		
		DynaActionForm cpaSummaryForm = FormUtils.getInstance().createDynaActionForm(ICFPLegHelper.CPA_SUMMARY_FORM, mapping.getModuleConfig(), action);
		FormUtils.getInstance().populateForm(ICFPLegHelper.CPA_SUMMARY_FORM, cpaSummaryForm, leg.getCPASummary(), mapping.getModuleConfig(), action, mapping, request);
		form.set(CPASUMMARY_SMALL, cpaSummaryForm);
		EntityHelper.syncFormWithEntities(form, leg, request, mapping, action); // Added for sync entities
	}
	
	/**
	 * syncFormWithOtherLeg
	 * @param form
	 * @param leg
	 * @param request
	 * @param servletContext
	 * @param mapping
	 * @param action
	 * @throws ICFPException 
	 */
	public static void syncFormWithOtherLeg(DynaActionForm form, OtherLegRequest leg, HttpServletRequest request,
			ServletContext servletContext, ActionMapping mapping,
			Action action) throws ICFPException {
		ICFPDay2LegHelper.syncFormWithDay2Operations(form, leg, request, servletContext, mapping, action); // Added of Day2
		LegSummary legSummary = leg.getLegSummary();
		if(leg.isCrossBorderFlag()!=null && !leg.isCrossBorderFlag().toString().equals("")){
			form.set(ICFPLegHelper.CROSS_BORDER_FLAG, leg.isCrossBorderFlag().toString());	
		}
		form.set(ICFPLegHelper.DESCRIPTION, leg.getDescription());
		DynaActionForm legSummaryForm = (DynaActionForm) FormUtils.setFormValues(ICFPLegHelper.LEG_SUMMARY_FORM, legSummary, action, mapping, request);
		form.set(LEGSUMMARY, legSummaryForm);
		EntityHelper.syncFormWithEntities(form, leg, request, mapping, action); // Added for sync entities
		Double USDEquivalent = (leg.getLegSummary().getUSDEquivalent())==null?0:leg.getLegSummary().getUSDEquivalent();
		legSummaryForm.set(USDEQUIVALENT, ICFPCommonHelper.formatCurrency(String.valueOf(USDEquivalent)));
		TPLegRequest tpLegRequest = leg.getTPLegRequest();
		if(tpLegRequest!=null){
			DynaActionForm tpLegRequestForm = (DynaActionForm) FormUtils.setFormValues(ICFPLegHelper.TP_LEG_REQUEST_FORM, tpLegRequest, action, mapping, request);
			form.set(TPLEGREQUEST, tpLegRequestForm);
		}
		syncFormWithRateInformation(form, leg, request, mapping, action);
		
		form.set(ICFPLegHelper.GUARANTEE_FEE_APPLICABLE_FLAG, (leg.isGuaranteeFeeApplicableFlag() != null) ? String.valueOf(leg.isGuaranteeFeeApplicableFlag()) : null);
		form.set(ICFPLegHelper.GUARANTEE_FEE_RATE, (leg.getGuaranteeFeeRate() != null) ? String.valueOf(leg.getGuaranteeFeeRate()) : null);
		form.set(ICFPLegHelper.GUARANTEE_AGREEMENT_FLAG, (leg.isGuaranteeAgreementFlag() != null) ? String.valueOf(leg.isGuaranteeAgreementFlag()) : null);
	}
	
	/**
	 * Synchronizes the {@link RateInformation} object with form
	 * @param form
	 * @param leg
	 * @param request
	 * @param mapping
	 * @param action
	 * @throws ICFPException
	 */
	private static void syncFormWithRateInformation(DynaActionForm form, Object leg, HttpServletRequest request, ActionMapping mapping, Action action) throws ICFPException {
		RateInformation rateInformation = Utils.fetchPropertyValue(RATEINFORMATION, leg, RateInformation.class);
		DynaActionForm rateInformationForm = null;
		if(rateInformation != null) {
			rateInformationForm = (DynaActionForm) FormUtils.setFormValues(ICFPLegHelper.RATE_INFORMATION_FORM, rateInformation, action, mapping, request);
		} else {
			rateInformationForm = FormUtils.getInstance().createDynaActionForm(ICFPLegHelper.RATE_INFORMATION_FORM, mapping.getModuleConfig(), action);
		}
		form.set(RATEINFORMATION, rateInformationForm);
	}
	/**
	 * syncExceptions
	 * @param legReqForm
	 * @param exceptions
	 * @param mapping
	 * @param action
	 * @throws ICFPException 
	 */
	private static void syncExceptions(DynaActionForm legReqForm, Object leg, boolean nonStandardFlag, HttpServletRequest request) throws ICFPException {
		DealPermissions dealPermissions = AttachmentSecurity.getDealPermissions(request);
		if(!(dealPermissions.isRequestor() || dealPermissions.isFrontOffice())) {
			return;
		}
		
		String[] exceptionIndex = legReqForm.getStrings(ICFPLegHelper.EXCEPTION_INDEX);
		if(exceptionIndex == null || exceptionIndex.length == 0 || !nonStandardFlag) {
			deleteAllExceptions(leg, request);
			return;
		}
		
		String[] standardTermsConditionsId = legReqForm.getStrings(ICFPLegHelper.STANDARD_TERMS_CONDITIONS_ID);
		String[] requestedException = legReqForm.getStrings(ICFPLegHelper.REQUESTED_EXCEPTION);
		String[] rationaleForExceptionImpact = legReqForm.getStrings(ICFPLegHelper.RATIONALE_FOR_EXCEPTION_IMPACT);
		String[] remediationTimelineTimeframe = legReqForm.getStrings(ICFPLegHelper.REMEDIATION_TIMELINE);
		String[] rationaleForExceptionPotentialAlternatives = legReqForm.getStrings(ICFPLegHelper.RATIONALE_FOR_EXCEPTION_POTENTIAL_ALTERNATIVES);
		String[] remediationTimelineComments = legReqForm.getStrings(ICFPLegHelper.REMEDIATION_TIMELINE_COMMENTS);
		
		List<ExceptionRequestForm> modifiedExceptions = new ArrayList<ExceptionRequestForm>();
		Integer currentExceptionIndex = null;
		String exceptionTimeLineId = null;
		for(int i = 0; i<exceptionIndex.length; i++) {
			currentExceptionIndex = Integer.valueOf(exceptionIndex[i]);
			
			// Ignore the empty exception
			if(StringUtils.isBlank(standardTermsConditionsId[i]) && StringUtils.isBlank(requestedException[i]) && StringUtils.isBlank(rationaleForExceptionImpact[i]) 
					&& StringUtils.isBlank(remediationTimelineTimeframe[i]) && StringUtils.isBlank(rationaleForExceptionPotentialAlternatives[i]) 
					&& StringUtils.isBlank(remediationTimelineComments[i]) && StringUtils.isBlank(request.getParameter("exceptionTimelineId[" + currentExceptionIndex + "]"))) {
				continue;
			}
			 
			ExceptionRequestForm exception = getExceptionRequestFormCreateIfNot(currentExceptionIndex, leg);
			modifiedExceptions.add(exception);
			
			if(StringUtils.isNotEmpty(standardTermsConditionsId[i])){
				exception.setStandardTermsConditionsId(Integer.valueOf(standardTermsConditionsId[i]));
			} else {
				exception.setStandardTermsConditionsId(null);
			}
			
			if(StringUtils.isNotBlank(requestedException[i])) {
				exception.setRequestedException(requestedException[i]);
			} else {
				exception.setRequestedException(null);
			}
			
			if(StringUtils.isNotBlank(rationaleForExceptionImpact[i])) {
				exception.setRationaleForExceptionImpact(rationaleForExceptionImpact[i]);
			} else {
				exception.setRationaleForExceptionImpact(null);
			}
			
			exceptionTimeLineId = request.getParameter("exceptionTimelineId[" + currentExceptionIndex + "]");
			if(StringUtils.isNotBlank(exceptionTimeLineId)) {
				exception.setExceptionTimelineId(Integer.valueOf(exceptionTimeLineId));
				if(exceptionTimeLineId.equals(ONE)){
					exception.setExceptionTimeline(PERMANENT);
				}else if(exceptionTimeLineId.equals(TWO)){
					exception.setExceptionTimeline(TEMPORARY);
				}
			} else {
				exception.setExceptionTimelineId(null);
				exception.setExceptionTimeline(null);
			}
			
			if(StringUtils.isNotBlank(remediationTimelineTimeframe[i])) {
				exception.setRemediationTimeline(remediationTimelineTimeframe[i]);
			} else {
				exception.setRemediationTimeline(null);
			}
			
			if(StringUtils.isNotBlank(rationaleForExceptionPotentialAlternatives[i])) {
				exception.setRationaleForExceptionPotentialAlternatives(rationaleForExceptionPotentialAlternatives[i]);
			} else {
				exception.setRationaleForExceptionPotentialAlternatives(null);
			}
			
			if(StringUtils.isNotBlank(remediationTimelineComments[i])) {
				exception.setRemediationTimelineComments(remediationTimelineComments[i]);
			} else {
				exception.setRemediationTimelineComments(null);
			}
			
			String fullName = UserContext.getCurrentUserContext().getLastName()+", "+UserContext.getCurrentUserContext().getFirstName();
			String dateFormat = ICFPLegHelper.DATE_FORMAT;
			DateFormat format = new SimpleDateFormat(dateFormat);
			
			exception.setActionBy(fullName +"\r\n"+ format.format(new Date()));
			
			if(exception.getLegalExceptionsId() == null) {
				exception.setExceptionOpcode(ICFPConstants.INSERT);
			} else {
				exception.setExceptionOpcode(ICFPConstants.UPDATE);
			}
		}
		
		// Clean Other exceptions
		List<ExceptionRequestForm> exceptionList = getExceptions(leg);
		if(exceptionList!=null && !exceptionList.isEmpty()){
			List<ExceptionRequestForm> exceptionListToDelete = new ArrayList<ExceptionRequestForm>();
			for(ListIterator<ExceptionRequestForm> itr = exceptionList.listIterator(); itr.hasNext(); ) {
				ExceptionRequestForm eachException = itr.next();
				if(!modifiedExceptions.contains(eachException)) {
					exceptionListToDelete.add(eachException);
				}
			}
			deleteException(exceptionListToDelete, exceptionList, request);
		}
	}
	
	/**
	 * used to set the StandardTermsConditions name.
	 * @param exceptions
	 * @param request
	 */
	private static void settingStandardTermsConditions(List<ExceptionRequestForm> exceptions,HttpServletRequest request){
		StaticDataFactory statData = (StaticDataFactory) request.getSession().getServletContext().getAttribute(StaticDataFactory.CTX_KEY);
		Map<Integer, String> termsAndConditionsMap = statData.getTermsAndConditionsMap();
		for(ExceptionRequestForm exceptionForm:exceptions){
			if(termsAndConditionsMap != null){
				exceptionForm.setStandardTermsConditions(termsAndConditionsMap.get(exceptionForm.getStandardTermsConditionsId()));
			}
		}
		
	}
	
	/**
	 * getSubordinatedDebtFlag
	 * @param leg Object
	 * @return boolean
	 */
	public static boolean getSubordinatedDebtFlag(Object leg) {
		if(leg instanceof RCALegRequest) {
			RCALegRequest rcaLeg = (RCALegRequest) leg;
			if(rcaLeg.getLegSummary() != null) {
				if(rcaLeg.getLegSummary().isSubordinatedDebt()!=null ){
				     return rcaLeg.getLegSummary().isSubordinatedDebt();
				}else{
					return false;
				}					
			}
		} else if(leg instanceof EquityLegRequest) {
			EquityLegRequest equityLeg = (EquityLegRequest) leg;
			if(equityLeg.getLegSummary().isSubordinatedDebt()!=null ){
			     return equityLeg.getLegSummary().isSubordinatedDebt();
			}else{
				return false;
			}
		} else if(leg instanceof OtherLegRequest) {
			OtherLegRequest otherLeg = (OtherLegRequest) leg;
			if(otherLeg.getLegSummary().isSubordinatedDebt()!=null ){
			     return otherLeg.getLegSummary().isSubordinatedDebt();
			}else{				
				return false;
			}
		} else if(leg instanceof CPALegRequest) {
			CPALegRequest cpaLeg = (CPALegRequest) leg;
			if(cpaLeg.getCPASummary() != null) {
			
				if(cpaLeg.isSubordinatedDebt()!=null ){
				     return cpaLeg.isSubordinatedDebt();
				}else{
					return false;
				}
			}
		}
		return false;
	}
	/**
	 * getEquityInfusionsDividendsFlag
	 * @param leg Object
	 * @return boolean
	 */
	public static boolean getEquityInfusionsDividendsFlag(Object leg) {
		
		int legTypeId = -1;
		
		if(leg instanceof RCALegRequest) {
			RCALegRequest rcaLeg = (RCALegRequest) leg;
			if(rcaLeg.getLegSummary() != null && rcaLeg.getLegSummary().getLegTypeId()!=null) {
				legTypeId = rcaLeg.getLegSummary().getLegTypeId();
			}
		} else if(leg instanceof EquityLegRequest) {
			EquityLegRequest equityLeg = (EquityLegRequest) leg;
			if(equityLeg.getLegSummary() != null && equityLeg.getLegSummary().getLegTypeId()!=null) {
				legTypeId = equityLeg.getLegSummary().getLegTypeId();
			}
		} else if(leg instanceof OtherLegRequest) {
			OtherLegRequest otherLeg = (OtherLegRequest) leg;
			if(otherLeg.getLegSummary() != null && otherLeg.getLegSummary().getLegTypeId()!=null) {
				legTypeId = otherLeg.getLegSummary().getLegTypeId();
			}
		} else if(leg instanceof CPALegRequest) {
			CPALegRequest cpaLeg = (CPALegRequest) leg;
			if(cpaLeg.getCPASummary() != null) {
				legTypeId = -1;
			}
		}
		
		if(legTypeId==2)
		{
			return true;
		}
		
		return false;
	}
	/**
	 * getPrincipalEntityFlag
	 * @param leg Object
	 * @return boolean
	 */
	public static boolean getPrincipalEntityFlag(Object leg) {
		boolean isPrincipalEntityFlag = false;
		if(leg instanceof RCALegRequest) {
			
			RCALegRequest rcaLeg = (RCALegRequest) leg;
			
			if(rcaLeg.getLegSummary().getEntities() != null) {
				List<Entity> entityLst = rcaLeg.getLegSummary().getEntities();
				if(entityLst!=null)
				return  getPrincipalEntityFlagFromEntityList(entityLst);
			}		
			
		} else if(leg instanceof EquityLegRequest) {
			EquityLegRequest equityLeg = (EquityLegRequest) leg;
			List<Entity> entityLst = equityLeg.getLegSummary().getEntities();
			if(entityLst!=null)
			return  getPrincipalEntityFlagFromEntityList(entityLst);
		} else if(leg instanceof OtherLegRequest) {
			OtherLegRequest otherLeg = (OtherLegRequest) leg;
			List<Entity> entityLst = otherLeg.getLegSummary().getEntities();
			
			if(entityLst!=null) {
				return  getPrincipalEntityFlagFromEntityList(entityLst);
			}
		} else if(leg instanceof CPALegRequest) {
			CPALegRequest cpaLeg = (CPALegRequest) leg;
			List<Entity> entityLst = cpaLeg.getCPASummary().getEntities();
			
			if(entityLst!=null) {
				return  getPrincipalEntityFlagFromEntityList(entityLst);
			}
		}
		return isPrincipalEntityFlag;
	}
	/**
	 * getPrincipalEntityFlagFromEntityList
	 * @param entityLst list
	 * @return boolean
	 */
	public static boolean getPrincipalEntityFlagFromEntityList(List<Entity> entityLst)
	{
		boolean isPrincipalEntityFlag = false;
		
		for(Entity entity:entityLst){
			if(entity!=null && entity.isPrincplEntityFlag()!=null) {
				isPrincipalEntityFlag = entity.isPrincplEntityFlag();
			}
			if(isPrincipalEntityFlag)
			{
				return isPrincipalEntityFlag;
			}
		}
		
		return isPrincipalEntityFlag ;
	}
	/**
	 * getPrudentialEntityFlag
	 * @param leg Object
	 * @return boolean
	 */
	public static boolean getPrudentialEntityFlag(Object leg) {
		boolean isPrudentialEntityFlag = false;
		if(leg instanceof RCALegRequest) {
			RCALegRequest rcaLeg = (RCALegRequest) leg;
			if(rcaLeg.getLegSummary().getEntities() != null) {
				List<Entity> entityLst = rcaLeg.getLegSummary().getEntities();
				if(entityLst!=null) {
					return  getPrudentialEntityFlagFromEntityList(entityLst);
				}
			}		
		} else if(leg instanceof EquityLegRequest) {
			EquityLegRequest equityLeg = (EquityLegRequest) leg;
			List<Entity> entityLst = equityLeg.getLegSummary().getEntities();
			if(entityLst!=null) {
				return  getPrudentialEntityFlagFromEntityList(entityLst);
			}
		} else if(leg instanceof OtherLegRequest) {
			OtherLegRequest otherLeg = (OtherLegRequest) leg;
			List<Entity> entityLst = otherLeg.getLegSummary().getEntities();
			if(entityLst!=null) {
				return  getPrudentialEntityFlagFromEntityList(entityLst);
			}
		} else if(leg instanceof CPALegRequest) {
			CPALegRequest cpaLeg = (CPALegRequest) leg;
			List<Entity> entityLst = cpaLeg.getCPASummary().getEntities();
			if(entityLst!=null) {
				return  getPrudentialEntityFlagFromEntityList(entityLst);
			}
		}
		return isPrudentialEntityFlag;
		
	}
	/**
	 * getPrudentialEntityFlagFromEntityList
	 * @param entityLst list
	 * @return boolean
	 */
	public static boolean getPrudentialEntityFlagFromEntityList(List<Entity> entityLst)
	{
		boolean isPrudentialEntityFlag = false;
		for(Entity entity:entityLst){
			if(entity!=null && entity.isRegulatedEntityFlag()!=null) {
				isPrudentialEntityFlag = entity.isRegulatedEntityFlag();
			}
			if( isPrudentialEntityFlag)
			{
				return isPrudentialEntityFlag;
			}
		}
		return isPrudentialEntityFlag ;
	}
	/**
	 * getCrossBorderFlagValue
	 * @param leg Object
	 * @return boolean
	 */
	public static boolean getCrossBorderFlagValue(Object leg) {

		boolean crossBorderFlagValue = false;

		if(leg instanceof RCALegRequest) {
			RCALegRequest rcaLeg = (RCALegRequest) leg;
			if(rcaLeg.isCrossBorderFlag()!=null) {
				return rcaLeg.isCrossBorderFlag();
			}
		} else if(leg instanceof EquityLegRequest) {
			EquityLegRequest equityLeg = (EquityLegRequest) leg;
			if(equityLeg.isCrossBorderFlag()!=null) {
				return equityLeg.isCrossBorderFlag();
			}
		} else if(leg instanceof OtherLegRequest) {
			OtherLegRequest otherLeg = (OtherLegRequest) leg;
			if(otherLeg.isCrossBorderFlag()!=null) {
				return otherLeg.isCrossBorderFlag();
			}
		} else if(leg instanceof CPALegRequest) {
			CPALegRequest cpaLeg = (CPALegRequest) leg;
			if(cpaLeg.isCrossBorderFlag()!=null) {
				return cpaLeg.isCrossBorderFlag();
			}
		}
		return crossBorderFlagValue;
	}
	
	/**
	 * createOldShareInfoMap
	 * @param sharePrfId
	 * @param shareInfos
	 * @return map
	 */
	private static Map<Integer, ShareInfo> createOldShareInfoMap(List<ShareInfo> shareInfos) {
		Map<Integer, ShareInfo> oldShareInfoMap = new HashMap<Integer, ShareInfo>();
		for(ShareInfo eachShareInfo : shareInfos) {
			eachShareInfo.setShareOpcode(DELETE);
			oldShareInfoMap.put(eachShareInfo.getSharePrfId(), eachShareInfo);
		}
		return oldShareInfoMap;
	}
	
	/**
	 * removeNewShareInfos
	 * @param shareInfos list
	 */
	private static void removeNewShareInfos(List<ShareInfo> shareInfos) {
		for(ListIterator<ShareInfo> shareInfoItr = shareInfos.listIterator(); shareInfoItr.hasNext(); ) {
			if(shareInfoItr.next().getSharePrfId() == null) {
				shareInfoItr.remove();
			}
		}
	}
	
	
	/**
	 * syncSharesInfos
	 * @param form DynaActionForm
	 * @param shareInfos list
	 * @param equityFormId Integer
	 */
	private static void syncSharesInfos(DynaActionForm form, List<ShareInfo> shareInfos, Integer equityFormId) {
		String[] sharePrfIds = form.getStrings(ICFPLegHelper.SHARE_PRF_ID);
		String[] shareTypeIds = form.getStrings(ICFPLegHelper.SHARE_TYPE_ID);
		String[] numberOfShares = form.getStrings(ICFPLegHelper.NUMBER_OF_SHARES);
		String[] shareValues = form.getStrings(ICFPLegHelper.SHARE_VALUE);
		String[] debtTerms = form.getStrings(ICFPLegHelper.DEBT_TERMS);
		
		if(!shareInfos.isEmpty()) {
			removeNewShareInfos(shareInfos);
		}
		Map<Integer, ShareInfo> oldShareInfoMap = null;
		if(!shareInfos.isEmpty()) {
			oldShareInfoMap = createOldShareInfoMap(shareInfos);
		}
			if(shareTypeIds!=null){
				for(int i=0; i<shareTypeIds.length; i++) {
					if(shareTypeIds[i] != null && shareTypeIds[i].trim().length() > 0){
						ShareInfo shareInfo = null;
						if(sharePrfIds!=null && sharePrfIds.length > 0 && sharePrfIds[i].trim().length() > 0) {
							Integer itrSharePrfId = Integer.valueOf(sharePrfIds[i]);
							shareInfo = oldShareInfoMap.get(itrSharePrfId);
							shareInfo.setShareOpcode(UPDATE);
						} else {
							shareInfo = new ShareInfo();
							shareInfo.setShareOpcode(INSERT);
							shareInfos.add(shareInfo);
						}
						
						shareInfo.setShareTypeId(new Integer(shareTypeIds[i]));
						String noOfShares = numberOfShares[i];
						noOfShares = noOfShares.replaceAll(",","");
						if(StringUtils.isNotBlank(noOfShares)){
							shareInfo.setNumberOfShares(new Integer(noOfShares));
						}
						
						
						String sharevalue = shareValues[i];
						sharevalue = sharevalue.replaceAll(",","");
						if(StringUtils.isNotBlank(sharevalue)){
							Double shareValDbl = new Double(sharevalue);
							shareValDbl = new Double(Math.round(shareValDbl));
							shareInfo.setShareValue(shareValDbl);
						}
						if(equityFormId == 4){
							shareInfo.setDebtTerms(debtTerms[i]);
						}
					}
				}
			}
	}
	

	/**
	 * filterDeletedEquities
	 * @param shareInfos list
	 * @return filteredEquities List
	 */
	public static List<ShareInfo> filterDeletedEquities(List<ShareInfo> shareInfos) {
		List<ShareInfo> filteredEquities = new ArrayList<ShareInfo>();
		if(shareInfos != null && !shareInfos.isEmpty()) {
			replaceNullEquities(shareInfos);
			for(ShareInfo eachEquity : shareInfos) {
				if(eachEquity.getShareOpcode() != null && !eachEquity.getShareOpcode().equalsIgnoreCase(DELETE)) {
					filteredEquities.add(eachEquity);
				}
			}
		}
		return filteredEquities;
	}
	/**
	 * replaceNullEquities
	 * @param shareInfos List
	 */
	public static void replaceNullEquities(List<ShareInfo> shareInfos) {
		for(int i=0; i<shareInfos.size(); i++) {
			ShareInfo shareInfo = shareInfos.get(i);
			if(shareInfo == null) {
				shareInfo = new ShareInfo();
				shareInfos.set(i, shareInfo);
			}
		}
	}
	
	/**
	 * 
	 * @param dealRequest
	 * @param opcode
	 * @param action
	 * @param actionId
	 */
	public static void prepareMsgHeader(DealRequest dealRequest, String opcode,
			String action, int actionId) {
		MsgHeader msgHeader = new MsgHeader();
		msgHeader.setOpcode(opcode);
		String userId = UserContext.getCurrentUserContext().getId();
		msgHeader.setAuditCreator(userId);
		msgHeader.setAuditModifier(userId);
		msgHeader.setAuditCreatorFirstName(UserContext.getCurrentUserContext().getFirstName());
		msgHeader.setAuditCreatorLastName(UserContext.getCurrentUserContext().getLastName());
		msgHeader.setAuditModifierFirstName(UserContext.getCurrentUserContext().getFirstName());
		msgHeader.setAuditModifierLastName(UserContext.getCurrentUserContext().getLastName());

		if (actionId != 0) {
			dealRequest.setActionId(actionId);
		}
		dealRequest.setMsgHeader(msgHeader);
		if (action != null && action.trim().length() > 0) {
			dealRequest.setAction(action);
		}
		dealRequest.setTransOwnerSsoId(userId);
	}
	
	/**
	 * This is used to create CPAQualitativeFactorsForm 
	 * @param form
	 * @param mapping
	 * @param request
	 * @param action
	 * @param count
	 */
	public static void prepareCPAQualitativeFactorsForm(DynaActionForm form,
			ActionMapping mapping, HttpServletRequest request, Action action,
			int count) {
		DynaActionForm legSummaryForm = (DynaActionForm) form.get(CPASUMMARY_SMALL);
		List<DynaActionForm> qualitativeFactors = new ArrayList<DynaActionForm>(
				count);
		for (int i = 0; i < count; i++) {
			DynaActionForm qualitativeForm = FormUtils.getInstance()
					.createDynaActionForm(QUALITATIVEFACTORSFORM,
							mapping.getModuleConfig(), action);
			qualitativeFactors.add(qualitativeForm);
		}
		legSummaryForm.set(QUALITATIVEFACTORS, qualitativeFactors);
	}
	

	/**
	 * prepareICFPOtherLegRequestForm
	 * @param form
	 * @param mapping
	 * @param request
	 * @param action
	 */
	public static void prepareICFPOtherLegRequestForm(DynaActionForm form,
			ActionMapping mapping, HttpServletRequest request, Action action){
		DynaActionForm legSummary = FormUtils.getInstance().createDynaActionForm(ICFPLegHelper.LEG_SUMMARY_FORM, mapping.getModuleConfig(), action);
		form.set(LEGSUMMARY, legSummary);
	}
	
	/**
	 * 
	 * @param form
	 * @param leg
	 * @param request
	 * @param servletContext
	 * @param mapping
	 * @param action
	 * @throws ICFPException
	 */
	public static void syncFormWithOtherLegForTP(DynaActionForm form, OtherLegRequest leg, HttpServletRequest request,
			ServletContext servletContext, ActionMapping mapping,
			Action action) throws ICFPException {
		ICFPDay2LegHelper.prepareLegForDay2Operations(leg); // Added for Day2
		DynaActionForm legSummaryForm = null;
		FormUtils.getInstance().populateForm(ICFPOTHERLEGREQUESTFORM, form, leg, mapping.getModuleConfig(),action, mapping, request);
		
		if(leg.getLegSummary() != null){
			legSummaryForm = (DynaActionForm) FormUtils.setFormValues(ICFPLegHelper.LEG_SUMMARY_FORM, leg.getLegSummary(), action, mapping, request);
			List<Entity> entityLst = leg.getLegSummary().getEntities();
			
			for(Entity entity:entityLst){
				DynaActionForm entityForm = FormUtils.getInstance().createDynaActionForm(ENTITYFORM, mapping.getModuleConfig(), action);
				DynaActionForm tCodeentityForm = FormUtils.getInstance().createDynaActionForm(ENTITYFORM, mapping.getModuleConfig(), action);
				if(entity.getLeTypeId()==1){
					FormUtils.getInstance().populateForm(ENTITYFORM, entityForm, entity, mapping.getModuleConfig(), action, mapping, request);
					FormUtils.getInstance().populateForm(ENTITYFORM, tCodeentityForm, entity, mapping.getModuleConfig(), action, mapping, request);
					legSummaryForm.set(LENDERENTITY, entityForm);
					legSummaryForm.set(LENDERTCODEENTITY, tCodeentityForm);
				}else if(entity.getLeTypeId()==2){
					FormUtils.getInstance().populateForm(ENTITYFORM, entityForm, entity, mapping.getModuleConfig(), action, mapping, request);
					FormUtils.getInstance().populateForm(ENTITYFORM, tCodeentityForm, entity, mapping.getModuleConfig(), action, mapping, request);
					legSummaryForm.set(BORROWERENTITY, entityForm);
					legSummaryForm.set(BORROWERTCODEENTITY, tCodeentityForm);
				}
			}
			DynaActionForm entityForm = FormUtils.getInstance().createDynaActionForm(ENTITYFORM, mapping.getModuleConfig(), action);
			legSummaryForm.set(GUARANTORENTITY, entityForm);
			form.set(LEGSUMMARY, legSummaryForm);
		} 
		Double USDEquivalent = (leg.getLegSummary().getUSDEquivalent())==null?0:leg.getLegSummary().getUSDEquivalent();
		legSummaryForm.set(USDEQUIVALENT, ICFPCommonHelper.formatCurrency(USDEquivalent+""));
	}
	
	/**
	 * setDayOneAmts
	 * @param legSummaryForm
	 * @param rcaLeg
	 */
	private static RCALegRequest setDayOneAmts(DynaActionForm legSummaryForm,RCALegRequest rcaLeg){
		String dayOneUSDEquivalent = legSummaryForm.getString(DAYONEUSDEQUIVALENT);
		if(dayOneUSDEquivalent!=null && !dayOneUSDEquivalent.equals(""))
		{
			legSummaryForm.set(DAYONEUSDEQUIVALENT, String.valueOf(ICFPCommonHelper.convetCurrencyFormatToDouble(dayOneUSDEquivalent)));
		}
		String dayOneCCYAmount = legSummaryForm.getString(ICFPLegHelper.DAY_ONE_CCY_AMOUNT);
		if(dayOneCCYAmount!=null && !dayOneCCYAmount.equals(""))
		{
			legSummaryForm.set(ICFPLegHelper.DAY_ONE_CCY_AMOUNT, String.valueOf(ICFPCommonHelper.convetCurrencyFormatToDouble(dayOneCCYAmount)));
		}else {
			rcaLeg.getLegSummary().setDayOneCCYAmount(null);
		}
		
		return rcaLeg;
	}
	
	/**
	 * 
	 * @param index
	 * @param leg
	 * @return
	 * @throws ICFPAttachmentException 
	 */
	public static ExceptionRequestForm getExceptionRequestFormCreateIfNot(int index, Object leg) throws ICFPAttachmentException {
		ExceptionRequestForm exceptionRequest = null;
		List<ExceptionRequestForm> exceptionList = getExceptions(leg);
		List<ExceptionRequestForm> activeExceptoins = ICFPLegHelper.filterDeletedExceptions(exceptionList);
		if(activeExceptoins.size() >= index) {
			exceptionRequest = activeExceptoins.get(index - 1);
		}
		
		if(exceptionRequest == null) {
			int diffToCreate = index - activeExceptoins.size();
			for(int i = 0; i < diffToCreate; i++) {
				exceptionList.add(new ExceptionRequestForm());
			}
			exceptionRequest = exceptionList.get(index - 1);
		}
		return exceptionRequest;
	}
	
	/**
	 * 
	 * @param exceptionsNeedToDelete
	 * @param allExceptions
	 * @param request
	 * @throws ICFPException 
	 */
	private static void deleteException(List<ExceptionRequestForm> exceptionListToDelete, List<ExceptionRequestForm> allExceptions, HttpServletRequest request) throws ICFPException {
		ICFPAttachmentManager attachmentManager = ICFPCommonHelper.getAttachmentManger(request);
		DealRequest deal = CurrentDealManager.getCurrentDeal(request);
		for(ExceptionRequestForm exceptionToDelete : exceptionListToDelete) {
			if(exceptionToDelete.getLegalExceptionsId() != null) {
				if(StringUtils.isBlank(exceptionToDelete.getExceptionOpcode()) 
						|| !ICFPConstants.DELETE.equalsIgnoreCase(exceptionToDelete.getExceptionOpcode())) {
					exceptionToDelete.setExceptionOpcode(ICFPConstants.DELETE);
				}
			} else {
				allExceptions.remove(exceptionToDelete);
			}
			attachmentManager.delete(exceptionToDelete.getAttachments(), deal);
		}
	}
	
	/**
	 * 
	 * @param leg
	 * @param request
	 * @throws ICFPException
	 */
	private static void deleteAllExceptions(Object leg, HttpServletRequest request) throws ICFPException {
		List<ExceptionRequestForm> allExceptions = getExceptions(leg);
		List<ExceptionRequestForm> exceptionsToDelete = new ArrayList<ExceptionRequestForm>(allExceptions);
		deleteException(exceptionsToDelete, allExceptions, request);
	}
}
