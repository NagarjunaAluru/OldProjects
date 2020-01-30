/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: ALOCCommonHelper.java
 * Purpose: ALOCCommonHelper used for print parameters
 */
package com.ge.aloc.util;

import static com.ge.aloc.constants.ALOCConstants.APPLICATION_VND_MS_EXCEL;
import static com.ge.aloc.constants.ALOCConstants.STANDBY_LETTER_OF_CREDIT;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.springframework.util.CollectionUtils;

import com.ge.aloc.ALOCContext;
import com.ge.aloc.ActionType;
import com.ge.aloc.DashboardViewType;
import com.ge.aloc.FormatType;
import com.ge.aloc.InstrumentPurposeType;
import com.ge.aloc.InstrumentType;
import com.ge.aloc.OpCode;
import com.ge.aloc.SearchCriteriaType;
import com.ge.aloc.bo.AttachmentBO;
import com.ge.aloc.bo.DelegationConfigBO;
import com.ge.aloc.bo.RequestDetailsBO;
import com.ge.aloc.bo.SiteDetailsBO;
import com.ge.aloc.bo.excel.CellDetail;
import com.ge.aloc.bo.excel.ExcelSheet;
import com.ge.aloc.bo.excel.ExcelSheetCollection;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.exception.ALOCRuntimeException;
import com.ge.aloc.model.APMDetails;
import com.ge.aloc.model.APMSearch;
import com.ge.aloc.model.ActionDetails;
import com.ge.aloc.model.ActionSearch;
import com.ge.aloc.model.ActionTakenBy;
import com.ge.aloc.model.AdditionalPayments;
import com.ge.aloc.model.AddressDtls;
import com.ge.aloc.model.AllinComissions;
import com.ge.aloc.model.Amendment;
import com.ge.aloc.model.Attachment;
import com.ge.aloc.model.AttachmentPermission;
import com.ge.aloc.model.AuditSearch;
import com.ge.aloc.model.AutoIncDec;
import com.ge.aloc.model.AvailableSites;
import com.ge.aloc.model.BUCAndADN;
import com.ge.aloc.model.BankDetails;
import com.ge.aloc.model.BondDetails;
import com.ge.aloc.model.BondInfo;
import com.ge.aloc.model.BondReqDtls;
import com.ge.aloc.model.BundleDetails;
import com.ge.aloc.model.BusinessUnitCode;
import com.ge.aloc.model.CumulativeFeeAdjustments;
import com.ge.aloc.model.CurrentBankFees;
import com.ge.aloc.model.CurrentWinningBank;
import com.ge.aloc.model.DashBoard;
import com.ge.aloc.model.DelegationConfig;
import com.ge.aloc.model.DeliveryInstructions;
import com.ge.aloc.model.ExpiryDate;
import com.ge.aloc.model.GlanceDetails;
import com.ge.aloc.model.GoodsOrigin;
import com.ge.aloc.model.GroupAssignment;
import com.ge.aloc.model.IBSDetails.IBSMessageDetails;
import com.ge.aloc.model.Inbox;
import com.ge.aloc.model.Inbox.DashBoardTabsCount;
import com.ge.aloc.model.Instrument;
import com.ge.aloc.model.InstrumentDetails;
import com.ge.aloc.model.LocalComissions;
import com.ge.aloc.model.MsgHeader;
import com.ge.aloc.model.NameValue;
import com.ge.aloc.model.Obligee;
import com.ge.aloc.model.ObligeeRef;
import com.ge.aloc.model.OneTimeFeesDetails;
import com.ge.aloc.model.OnetimeFees;
import com.ge.aloc.model.ParticipantBank;
import com.ge.aloc.model.PaymentPeriodDetails;
import com.ge.aloc.model.PoleNameManagement;
import com.ge.aloc.model.PreAgreedPricingDetails;
import com.ge.aloc.model.Principal;
import com.ge.aloc.model.Recipient;
import com.ge.aloc.model.RefDetails;
import com.ge.aloc.model.RequestDetails;
import com.ge.aloc.model.RequestSummary;
import com.ge.aloc.model.Requestor;
import com.ge.aloc.model.RequestorTransaction;
import com.ge.aloc.model.Rider;
import com.ge.aloc.model.RiderBondInformation;
import com.ge.aloc.model.Search;
import com.ge.aloc.model.SearchBankDetails;
import com.ge.aloc.model.SearchInstrDetails;
import com.ge.aloc.model.SearchReqDetails;
import com.ge.aloc.model.SearchReqDetails.BondSubBond;
import com.ge.aloc.model.SelectedBanks;
import com.ge.aloc.model.SelectedSites;
import com.ge.aloc.model.SiteAdmin;
import com.ge.aloc.model.StaticDataManagement.UserSites;
import com.ge.aloc.model.SuretyMaster;
import com.ge.aloc.model.SuretyMasterCollection;
import com.ge.aloc.model.TransactionParties;
import com.ge.aloc.model.WinnerDetails;
import com.ge.aloc.view.section.RequestSectionId;
import com.ge.aloc.view.section.SiteSectionId;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.hydus.hwf.context.UserContext;
import com.hydus.hwf.exceptions.HWFException;
import com.hydus.hwf.exceptions.HWFServiceException;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author sreenivasulu.talloju
 *
 */
public class ALOCCommonHelper {
	private static final Logger LOGGER = Logger.getLogger(ALOCCommonHelper.class);

	/**
	 * Method to Clean Temporary Delegation ConfigBO
	 * @param delegationConfigBOList
	 */
	public static void cleanTempDelegationConfigBOs(List<DelegationConfigBO> delegationConfigBOList) {
		for(Iterator<DelegationConfigBO> delegationConfigBOItr = delegationConfigBOList.listIterator(); delegationConfigBOItr.hasNext(); ) {
			DelegationConfigBO delegationConfigBO = delegationConfigBOItr.next();
			for(Iterator<GroupAssignment> gaItr = delegationConfigBO.getModel().getGroupAssignments().listIterator(); gaItr.hasNext(); ) {
				GroupAssignment groupAssignment = gaItr.next();
				if(groupAssignment.getGroupId() == null && groupAssignment.getOpCode() != null && groupAssignment.getOpCode().equals(OpCode.DELETE.getOperationCode())) {
					gaItr.remove();
				}
			}
			if(delegationConfigBO.getModel().getDelegationConfigId() == null && delegationConfigBO.isDeleted()) {
				delegationConfigBOItr.remove();
			}
		}
	}

	/**
	 * Method to get Calendar Object
	 * @return calendar
	 */
	public static Calendar getCurrentDateWithOutTime() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR, cal.getActualMinimum(Calendar.HOUR));
		cal.set(Calendar.HOUR_OF_DAY, cal.getActualMinimum(Calendar.HOUR_OF_DAY));
		cal.set(Calendar.MINUTE,      cal.getActualMinimum(Calendar.MINUTE));
		cal.set(Calendar.SECOND,      cal.getActualMinimum(Calendar.SECOND));
		cal.set(Calendar.MILLISECOND, cal.getActualMinimum(Calendar.MILLISECOND));
		return cal;
	}

	/**
	 * This Method is used to set Opcode
	 * @param requestDetails RequestDetails
	 * @param actionType
	 */
	public static void setOpCode(RequestDetails requestDetails,
			ActionType actionType) {

		if (requestDetails.getActionDetails() == null) {
			ActionDetails acdetails = new ActionDetails();
			acdetails.setActionId(String.valueOf(actionType.getId()));
			acdetails.setActionName(actionType.getName());
			requestDetails.setActionDetails(acdetails);
		} else {
			requestDetails.getActionDetails().setActionId(
					String.valueOf(actionType.getId()));
			requestDetails.getActionDetails().setActionName(
					actionType.getName());
		}
		requestDetails.setOpCode(actionType.getName());
	}

	/**
	 * Method to set the Bank Details to the Request details
	 * @param requestDetails
	 * @param rightBankRecords
	 * @return requestDetails
	 */
	public static RequestDetails setBankDetails(RequestDetails requestDetails,List<String> rightBankRecords) {
		if(rightBankRecords!=null){
			SelectedBanks selectBanks  = new SelectedBanks();
			List<BankDetails> bankDetLst = new ArrayList<BankDetails>();
			BankDetails bankDetails = new BankDetails();

			for(String bankRecord : rightBankRecords){
				bankDetails = new BankDetails();
				String siteName = bankRecord;
				List<BankDetails> orgBankDet = requestDetails.getBankDetails();
				String eachSiteName = null;
				
				for(BankDetails eachBankDet : orgBankDet){
					eachSiteName = eachBankDet.getSiteName();
					if(eachSiteName != null && eachSiteName.equals(siteName)){
						bankDetails.setBankMDMId(eachBankDet.getBankMDMId());
						bankDetails.setBankIdentifierCode(eachBankDet.getBankIdentifierCode());
						bankDetails.setName(eachBankDet.getName());
						bankDetails.setSiteId(eachBankDet.getSiteId());
						bankDetails.setSiteName(eachBankDet.getSiteName());
						break;
					}
				}
				bankDetLst.add(bankDetails);
			}
			selectBanks.setBankDetails(bankDetLst);
			requestDetails.setSelectedBanks(selectBanks);
		}
		return requestDetails;
	}

	/**
	 * This Method is used to set the message header details for request details
	 * @param requestDetails
	 * @param Operation
	 */
	public static void setMsgHeader(RequestDetails requestDetails,
			OpCode Operation){
		String opCode = Operation.getOperationCode();
		MsgHeader msgHeader = createMsgHeader(opCode);

		requestDetails.setMsgHeader(msgHeader);
	}

	/**
	 * This Method is used to set the dashboard model message header details
	 * @param opCode
	 * @param status
	 * @return msgHeader
	 */
	public static MsgHeader setMsgHeaderForModel(String opCode,String status){
		MsgHeader msgHeader = createMsgHeader(opCode);
		msgHeader.setStatus(status);
		return msgHeader;
	}	
	/**
	 * This Method is used to set the message header details
	 * @param opCode
	 * @return msgHeader
	 */
	public static MsgHeader createMsgHeader(String opCode) {
		MsgHeader msgHeader = new MsgHeader();
		msgHeader.setOpcode(opCode);
		String userSSO = UserContext.getContext().getuserDetails().getUserId();
		String lastName = UserContext.getContext().getuserDetails().getLastName();
		String firstName = UserContext.getContext().getuserDetails().getFirstName();
		msgHeader.setRoleName(getRoles(UserContext.getContext().getuserDetails().getRoles()));
		msgHeader.setAuditCreator(userSSO); 
		msgHeader.setAuditModifier(userSSO);
		msgHeader.setAuditCreatorFirstName(firstName);
		msgHeader.setAuditCreatorLastName(lastName);
		msgHeader.setAuditModifierFirstName(firstName);
		msgHeader.setAuditModifierLastName(lastName);

		List<String> userRoles = UserContext.getContext().getuserDetails().getRoles();
		StringBuilder roles = new StringBuilder();
		getUserRoles(userRoles, roles);

		msgHeader.setRoleName(roles.toString());
		return msgHeader;
	}

	/**
	 * This method is used to get UserRoles
	 * @param userRoles
	 * @param roles
	 */
	private static void getUserRoles(List<String> userRoles, StringBuilder roles) {
		int i=ALOCConstants.MIN_VALUE;
		for (String string : userRoles) {
			roles.append(string);
			if(i != userRoles.size()){
				roles.append(ALOCConstants.COMMA);
			}
			i++;
		}
	}

	/**
	 * Mandatory Validation for the SiteAdmin Delegation
	 * @return
	 */
	public static Boolean delegationFieldsMandatory() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		SiteDetailsBO siteDetailsBO = SiteAdminHelper.getActiveSite();
		SiteAdmin siteAdmin = siteDetailsBO.getModel();
		int rowCnt = ALOCConstants.MIN_VALUE;
		Set<Integer> allRowsSet = new TreeSet<Integer>();

		if(siteAdmin.getDelegationConfiguration()!=null){
			List<DelegationConfig> delegationConfigLst = siteAdmin.getDelegationConfiguration().getDelegationConfigs();
			for(DelegationConfig eachDeleg : delegationConfigLst){
				if(!(eachDeleg.getOpCode()!=null && eachDeleg.getOpCode().equals(ALOCConstants.DELETE))){
					List<Instrument> instrLst = eachDeleg.getInstruments();
					int instrSize = ALOCConstants.BASE_VALUE;
					for(Instrument instr:instrLst){
						if(instr.getOpCode()!=null && !(instr.getOpCode().equals(ALOCConstants.DELETE))){
							instrSize = instrSize+1;
						}
					}
					if(instrSize== ALOCConstants.BASE_VALUE || eachDeleg.getInstrBaseAmt()==null || eachDeleg.getInstrEndAmt()==null){
						allRowsSet.add(rowCnt);
					}else{
						for(Instrument eachInstr: instrLst){
							if(eachInstr.getOpCode()!=null && !(eachInstr.getOpCode().equals(ALOCConstants.DELETE))){
								int instrId = eachInstr.getInstrId();
								if(instrId == InstrumentType.BANK_GUARANTEE.getId() || instrId == InstrumentType.LOC.getId() || instrId == InstrumentType.AMENDMENT.getId()){
									if(eachDeleg.getNotificationCaluseFlag()==null || eachDeleg.getCurePeriodIndicatorFlag()==null
											|| eachDeleg.getGEAppDrawFlag() ==null){
										allRowsSet.add(rowCnt);
									}
								}
							}
						}
						List<GroupAssignment> grAssignmentLst = eachDeleg.getGroupAssignments();
						for(GroupAssignment eachAssign: grAssignmentLst){
							if(!(eachAssign.getOpCode()!=null && eachAssign.getOpCode().equals(ALOCConstants.DELETE))){
								if(ALOCConstants.EMPTY_STRING.equals(eachAssign.getGroupName())){
									allRowsSet.add(rowCnt);
								}
							}
						}
					}
					rowCnt += ALOCConstants.MIN_VALUE;
				}
			}
			if(allRowsSet.size()!=ALOCConstants.MIN_INDEX){
				String allRows = ALOCConstants.EMPTY_STRING;
				for(Integer eachRow : allRowsSet){
					allRows = allRows + eachRow + ALOCConstants.COMMA_SPACE;
				}
				allRows = allRows.substring(ALOCConstants.MIN_INDEX, allRows.length() - ALOCConstants.SECOND_VALUE);
				session.setAttribute(ALOCConstants.VALIDATE_DELEGATION,ALOCConstants.DELEG_VALIDATE_MANDATORY + allRows);
				return false;
			}
		}else {
			return false;
		}
		return true;
	}

	/**
	 * Method to validate the Instrument amount must be Positive
	 * @return
	 */
	public static Boolean instrAmtPostive(){
		SiteDetailsBO siteDetailsBO = SiteAdminHelper.getActiveSite();
		SiteAdmin siteAdmin = siteDetailsBO.getModel();

		List<DelegationConfig> delegationConfigLst = siteAdmin.getDelegationConfiguration().getDelegationConfigs();
		BigDecimal instrBaseAmt;
		BigDecimal instrEndAmt;
		
		int rowCnt = ALOCConstants.MIN_VALUE;
		HttpSession session = ServletActionContext.getRequest().getSession();
		Set<Integer> allRowsSet = new TreeSet<Integer>();

		for(DelegationConfig eachDelegate : delegationConfigLst){
			if(!(eachDelegate.getOpCode()!=null && eachDelegate.getOpCode().equals(ALOCConstants.DELETE))){
				instrBaseAmt = eachDelegate.getInstrBaseAmt();
				instrEndAmt = eachDelegate.getInstrEndAmt();
				if(instrBaseAmt.compareTo(BigDecimal.valueOf(ALOCConstants.BASE_VALUE))==ALOCConstants.LESS_AMOUNT || instrEndAmt.compareTo(BigDecimal.valueOf(ALOCConstants.BASE_VALUE))==ALOCConstants.LESS_AMOUNT){
					allRowsSet.add(rowCnt);
				}
			}
			rowCnt += ALOCConstants.MIN_VALUE;
		}
		if(allRowsSet.size()!=ALOCConstants.MIN_INDEX){
			String allRows = ALOCConstants.EMPTY_STRING;
			for(Integer eachRow : allRowsSet){
				allRows = allRows + eachRow + ALOCConstants.COMMA_SPACE;
			}
			allRows = allRows.substring(ALOCConstants.MIN_INDEX, allRows.length() - ALOCConstants.SECOND_VALUE);
			session.setAttribute(ALOCConstants.VALIDATE_DELEGATION,ALOCConstants.DELEG_VALIDATE_POSITIVE + allRows);
			return false;
		}
		return true;
	}

	/**
	 * Method to validate the Instrument amount(Must be 14,2)
	 * @return
	 */
	public static Boolean instrAmtInvalid(){
		SiteDetailsBO siteDetailsBO = SiteAdminHelper.getActiveSite();
		SiteAdmin siteAdmin = siteDetailsBO.getModel();

		List<DelegationConfig> delegationConfigLst = siteAdmin.getDelegationConfiguration().getDelegationConfigs();
		BigDecimal instrBaseAmt;
		BigDecimal instrEndAmt;
		String expression = ALOCConstants.VALIDATENUMBER_REGEXP;
		boolean invalidFlag = true;
		
		int rowCnt = ALOCConstants.MIN_VALUE;
		HttpSession session = ServletActionContext.getRequest().getSession();
		Set<Integer> allRowsSet = new TreeSet<Integer>();

		for(DelegationConfig eachDelegate : delegationConfigLst){
			if(!(eachDelegate.getOpCode()!=null && eachDelegate.getOpCode().equals(ALOCConstants.DELETE))){
				instrBaseAmt = eachDelegate.getInstrBaseAmt();
				instrEndAmt = eachDelegate.getInstrEndAmt();

				if(instrBaseAmt!=null && instrEndAmt !=null){
					invalidFlag = instrBaseAmt.toString().matches(expression);
					if(invalidFlag == true){
						invalidFlag = instrEndAmt.toString().matches(expression);
					}
				}
				if(invalidFlag == false){
					allRowsSet.add(rowCnt);
				}
			}
			rowCnt += ALOCConstants.MIN_VALUE;
		}
		if(allRowsSet.size()!=ALOCConstants.MIN_INDEX){
			String allRows = ALOCConstants.EMPTY_STRING;
			for(Integer eachRow : allRowsSet){
				allRows = allRows + eachRow + ALOCConstants.COMMA_SPACE;
			}
			allRows = allRows.substring(ALOCConstants.MIN_INDEX, allRows.length() - ALOCConstants.SECOND_VALUE);
			session.setAttribute(ALOCConstants.VALIDATE_DELEGATION, ALOCConstants.DELEG_VALIDATE_AMT_INVALID + allRows);
			return false;
		}
		return true;
	}


	/**
	 * Validation for Delegation Instrument Base amount be less than Instrument end amount
	 * @return
	 */
	public static Boolean delegBaseEndAmtValidation() {
		SiteDetailsBO siteDetailsBO = SiteAdminHelper.getActiveSite();
		SiteAdmin siteAdmin = siteDetailsBO.getModel();
		
		int rowCnt = ALOCConstants.MIN_VALUE;
		HttpSession session = ServletActionContext.getRequest().getSession();
		Set<Integer> allRowsSet = new TreeSet<Integer>();
		
		if(siteAdmin.getDelegationConfiguration()!=null){
			BigDecimal baseAmt;
			BigDecimal endAmt;
			List<DelegationConfig> delegationConfigLst = siteAdmin.getDelegationConfiguration().getDelegationConfigs();
			for(DelegationConfig eachDeleg : delegationConfigLst){
				if(!(eachDeleg.getOpCode()!=null &&  eachDeleg.getOpCode().equals(ALOCConstants.DELETE))){
					baseAmt = eachDeleg.getInstrBaseAmt();
					endAmt = eachDeleg.getInstrEndAmt();
					if(baseAmt.compareTo(endAmt) == ALOCConstants.BASE_VALUE || baseAmt.compareTo(endAmt) == ALOCConstants.MIN_VALUE){
						allRowsSet.add(rowCnt);
					}
				}
				rowCnt += ALOCConstants.MIN_VALUE;
			}
		}
		if(allRowsSet.size()!=ALOCConstants.MIN_INDEX){
			String allRows = ALOCConstants.EMPTY_STRING;
			for(Integer eachRow : allRowsSet){
				allRows = allRows + eachRow + ALOCConstants.COMMA_SPACE;
			}
			allRows = allRows.substring(ALOCConstants.MIN_INDEX, allRows.length() - ALOCConstants.SECOND_VALUE);
			session.setAttribute(ALOCConstants.VALIDATE_DELEGATION,ALOCConstants.DELEG_VALIDATE_BASE_END_AMT + allRows);
			return false;
		}
		return true;
	}

	/**
	 * Delegation Instrument amount range must be Different
	 * @return
	 */
	public static Boolean delegInstrRangeDiff() {

		SiteDetailsBO siteDetailsBO = SiteAdminHelper.getActiveSite();
		SiteAdmin siteAdmin = siteDetailsBO.getModel();

		List<DelegationConfig> delegationConfigLst = siteAdmin.getDelegationConfiguration().getDelegationConfigs();
		List<DelegationConfig> oldDelegLst = new ArrayList<DelegationConfig>();
		List<DelegationConfig> newDelegLst = new ArrayList<DelegationConfig>();

		HashMap<BigInteger,BigDecimal> unSortedMap= new HashMap<BigInteger,BigDecimal>();

		int idVal=ALOCConstants.MIN_VALUE;
		for(DelegationConfig eachDelegate : delegationConfigLst){
			if(!(eachDelegate.getOpCode()!=null && eachDelegate.getOpCode().equals(ALOCConstants.DELETE))){
				DelegationConfig deleg = new DelegationConfig();
				deleg.setDelegationConfigId(BigInteger.valueOf(idVal));
				deleg.setInstrBaseAmt(eachDelegate.getInstrBaseAmt());
				deleg.setInstrEndAmt(eachDelegate.getInstrEndAmt());

				deleg.setNotificationCaluseFlag(eachDelegate.getNotificationCaluseFlag());
				deleg.setCurePeriodIndicatorFlag(eachDelegate.getCurePeriodIndicatorFlag());
				deleg.setGEAppDrawFlag(eachDelegate.getGEAppDrawFlag());

				deleg.setInstrEndAmt(eachDelegate.getInstrEndAmt());

				List<Instrument> instLstOld = eachDelegate.getInstruments();
				List<Instrument> instLstNew = new ArrayList<Instrument>();
				for(Instrument inst : instLstOld){
					if(!(inst.getOpCode().equals(ALOCConstants.DELETE))){
						instLstNew.add(inst);
					}
				}
				deleg.setInstruments(instLstNew);

				oldDelegLst.add(deleg);
				unSortedMap.put(BigInteger.valueOf(idVal), eachDelegate.getInstrBaseAmt());

				idVal+=ALOCConstants.MIN_VALUE;
			}
		}
		delegateInstrumentAmount(unSortedMap,oldDelegLst,newDelegLst);
		return delegateEachInstrumentAmount(newDelegLst);
	}

	/**
	 * Delegation Instrument amount range must be Different
	 * @param newDelegLst
	 * @return
	 */
	private static boolean delegateEachInstrumentAmount(List<DelegationConfig> newDelegLst) {
		BigDecimal baseAmt = BigDecimal.valueOf(ALOCConstants.BASE_AMOUNT);
		BigDecimal endAmt;
		List<Instrument> prevRowInstLst = new ArrayList<Instrument>();
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		Set<String> allRowsSet = new TreeSet<String>();

		String prevNotFlag = null;
		String prevCurFlag = null;
		String prevGEFlag = null;
		String prevRow = ALOCConstants.EMPTY_STRING;

		int baseCnt = ALOCConstants.MIN_VALUE;
		int insCnt = ALOCConstants.MIN_VALUE;
		for(DelegationConfig eachDeleg : newDelegLst){
			baseAmt = eachDeleg.getInstrBaseAmt();
			prevRowInstLst = eachDeleg.getInstruments();
			prevNotFlag = eachDeleg.getNotificationCaluseFlag();
			prevCurFlag = eachDeleg.getCurePeriodIndicatorFlag();
			prevGEFlag = eachDeleg.getGEAppDrawFlag();
			prevRow = eachDeleg.getRowNum();

			insCnt = ALOCConstants.MIN_VALUE;
			for(DelegationConfig eachDelegIns : newDelegLst){
				if(baseCnt<insCnt){

					endAmt = eachDelegIns.getInstrEndAmt();
					if(baseAmt.compareTo(endAmt) == ALOCConstants.BASE_VALUE || baseAmt.compareTo(endAmt) == ALOCConstants.LESS_AMOUNT){

						List<Instrument> curRowInstLst = eachDelegIns.getInstruments();
						List<Integer> curStrLst = new ArrayList<Integer>();
						for(Instrument inst: curRowInstLst){
							curStrLst.add(inst.getInstrId());
						}
						String curNotFlag = eachDelegIns.getNotificationCaluseFlag();
						String curCurFlag = eachDelegIns.getCurePeriodIndicatorFlag();
						String curGEFlag = eachDelegIns.getGEAppDrawFlag();
						
						boolean notflag = false;
						boolean curFlag = false;
						boolean geflag = false;
						
						if((prevNotFlag.equals(ALOCConstants.NA) || curNotFlag.equals(ALOCConstants.NA)) || (prevNotFlag.equals(curNotFlag))){
							notflag = true;
						}
						if((prevCurFlag.equals(ALOCConstants.NA) || curCurFlag.equals(ALOCConstants.NA)) || (prevCurFlag.equals(curCurFlag))){
							curFlag = true;
						}
						if((prevGEFlag.equals(ALOCConstants.NA) || curGEFlag.equals(ALOCConstants.NA)) || (prevGEFlag.equals(curGEFlag))){
							geflag = true;
						}
						
						if(notflag && curFlag && geflag){
							for(Instrument eachInst: prevRowInstLst){
								if(curStrLst.contains(eachInst.getInstrId())){
									allRowsSet.add(eachDelegIns.getRowNum());
									allRowsSet.add(prevRow);
								}
							}
						}
					}
				}
				insCnt+=ALOCConstants.MIN_VALUE;
			}
			baseCnt+=ALOCConstants.MIN_VALUE;
		}
		if(allRowsSet!=null && allRowsSet.size()!=ALOCConstants.MIN_INDEX){
			String allRows = ALOCConstants.EMPTY_STRING;
			for(String eachRow : allRowsSet){
				allRows = allRows + eachRow + ALOCConstants.COMMA_SPACE;
			}
			allRows = allRows.substring(ALOCConstants.MIN_INDEX, allRows.length() - ALOCConstants.SECOND_VALUE);
			session.setAttribute(ALOCConstants.VALIDATE_DELEGATION, ALOCConstants.DELEG_VALID_ROWS_SAME +allRows);
			return false;
		}
		return true;
	}

	/**
	 * Delegation Instrument amount range must be Different
	 * @param unSortedMap
	 * @param oldDelegLst
	 * @param newDelegLst
	 */
	private static void delegateInstrumentAmount(HashMap<BigInteger,BigDecimal> unSortedMap,List<DelegationConfig> oldDelegLst,List<DelegationConfig> newDelegLst) {
		Map<BigInteger,BigDecimal> sortedMap = new HashMap<BigInteger,BigDecimal>();
		sortedMap = sortHashMap(unSortedMap);

		for (BigInteger delId : sortedMap.keySet()){
			int index=ALOCConstants.MIN_VALUE;
			for(DelegationConfig eachDeleg : oldDelegLst){
				if(!(eachDeleg.getOpCode()!=null && eachDeleg.getOpCode().equals(ALOCConstants.DELETE))){
					if(delId.compareTo(eachDeleg.getDelegationConfigId())==ALOCConstants.BASE_VALUE){
						DelegationConfig deleg = new DelegationConfig();
						deleg.setDelegationConfigId(eachDeleg.getDelegationConfigId());
						deleg.setInstrBaseAmt(eachDeleg.getInstrBaseAmt());
						deleg.setInstrEndAmt(eachDeleg.getInstrEndAmt());
						deleg.setRowNum(String.valueOf(index));

						List<Instrument> instLstOld = eachDeleg.getInstruments();
						List<Instrument> instLstNew = new ArrayList<Instrument>();
						for(Instrument inst : instLstOld){
							if(!(inst.getOpCode().equals(ALOCConstants.DELETE))){
								instLstNew.add(inst);
							}
						}
						deleg.setInstruments(instLstNew);

						List<Integer> ItrLst = new ArrayList<Integer>();
						for(Instrument inst: instLstNew){
							ItrLst.add(inst.getInstrId());
						}
						if((ItrLst.size()==ALOCConstants.SECOND_VALUE && ItrLst.contains(InstrumentType.SURETY_BOND.getId()) && ItrLst.contains(InstrumentType.RIDER.getId())) || 
								(ItrLst.size()==ALOCConstants.MIN_VALUE && (ItrLst.contains(InstrumentType.SURETY_BOND.getId()) || ItrLst.contains(InstrumentType.RIDER.getId())))){
							deleg.setNotificationCaluseFlag(ALOCConstants.EMPTY_STRING);
							deleg.setCurePeriodIndicatorFlag(ALOCConstants.EMPTY_STRING);
							deleg.setGEAppDrawFlag(ALOCConstants.EMPTY_STRING);
						}else{
							deleg.setNotificationCaluseFlag(eachDeleg.getNotificationCaluseFlag());
							deleg.setCurePeriodIndicatorFlag(eachDeleg.getCurePeriodIndicatorFlag());
							deleg.setGEAppDrawFlag(eachDeleg.getGEAppDrawFlag());
						}
						newDelegLst.add(deleg);
					}
				}
				index++;
			}
		}
	}

	/**
	 * Method to Sort the Map Values for the site delegation validation
	 * @param input
	 * @return sortedMap
	 */
	public static Map<BigInteger,BigDecimal> sortHashMap(Map<BigInteger,BigDecimal> map) {
		List<Map.Entry<BigInteger,BigDecimal>> list = new LinkedList<Map.Entry<BigInteger,BigDecimal>>(map.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<BigInteger,BigDecimal>>() {

			public int compare(Map.Entry<BigInteger,BigDecimal> m1, Map.Entry<BigInteger,BigDecimal> m2) {
				return (m2.getValue()).compareTo(m1.getValue());
			}
		});

		Map<BigInteger,BigDecimal> result = new LinkedHashMap<BigInteger,BigDecimal>();
		for (Map.Entry<BigInteger,BigDecimal> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}

	/**
	 * Method to validate the eas signup password(Atleast 2 Numbers,atleast 2 letters)
	 * @param password
	 * @return
	 */
	public static Boolean validatePassword(String password) {
		char c;  
		int count = ALOCConstants.BASE_VALUE; 
		for (int i = ALOCConstants.BASE_VALUE; i < password.length() - ALOCConstants.MIN_VALUE; i++) {  
			c = password.charAt(i);  
			if (Character.isDigit(c)) {  
				count++;  
			} 
		}  
		if (count < ALOCConstants.COUNT_MIN_VALUE)   {     
			return false;  
		}

		return true;
	}

	/**
	 * Mandatory Validation for the InstrumentDetails AutoIncrease Decrease Validation
	 * @return
	 */
	public static Boolean autoIncreaseDecreaseMandatory() {
		RequestDetailsBO requestDetailsBO = ALOCContext.getActiveRequest();
		RequestDetails requestDetails = requestDetailsBO.getModel();		
		if(requestDetails.getInstrumentDetails().getAutoIncDecFlag() != null && requestDetails.getInstrumentDetails().getAutoIncDecFlag().equals(ALOCConstants.TRUE_SMALL)){
			if (requestDetails.getInstrumentDetails().getAutoIncDecs() != null) {
				List<AutoIncDec> autoIncDecList = requestDetails.getInstrumentDetails().getAutoIncDecs();
				for (AutoIncDec eachAutoIncDec : autoIncDecList) {						
					if(!(eachAutoIncDec.getOpCode()!=null && eachAutoIncDec.getOpCode().equals(ALOCConstants.DELETE))){					
						if (eachAutoIncDec.getAutoIncAmt() == null
								|| eachAutoIncDec.getAutoIncIndicator() == null
								|| eachAutoIncDec.getAutoIncDt() == null) {
							return false;
						}

					}
				}
			}else {
				return false;
			}

		}
		return true;
	}
	
	
	/**
	 * Mandatory Validation for the InstrumentDetails AutoIncrease Decrease Date Validation
	 * @return
	 */
	public static Boolean autoIncreaseDecreaseDateValidation() {
		RequestDetailsBO requestDetailsBO = ALOCContext.getActiveRequest();
		RequestDetails requestDetails = requestDetailsBO.getModel();	
		Set<Calendar> autoIncDecDates = new HashSet<Calendar>();
		if(requestDetails.getInstrumentDetails().getAutoIncDecFlag() != null && requestDetails.getInstrumentDetails().getAutoIncDecFlag().equals(ALOCConstants.TRUE_SMALL)){
			List<AutoIncDec> autoIncDecList = requestDetails.getInstrumentDetails().getAutoIncDecs();
			for (AutoIncDec eachAutoIncDec : autoIncDecList) {
				if(!(eachAutoIncDec.getOpCode()!=null && eachAutoIncDec.getOpCode().equals(ALOCConstants.DELETE))){					
					if(!autoIncDecDates.add(eachAutoIncDec.getAutoIncDt())) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	/**
	 * Mandatory Validation for the InstrumentDetails AutoIncrease Decrease Date Validation greater than today.
	 * @return
	 */
	public static Boolean autoIncDecDateCompareToTodayDate() {
		RequestDetailsBO requestDetailsBO = ALOCContext.getActiveRequest();
		RequestDetails requestDetails = requestDetailsBO.getModel();	
		//Set<Calendar> autoIncDecDates = new HashSet<Calendar>();
		if(requestDetails.getInstrumentDetails().getAutoIncDecFlag() != null && requestDetails.getInstrumentDetails().getAutoIncDecFlag().equals(ALOCConstants.TRUE_SMALL)){
			List<AutoIncDec> autoIncDecList = requestDetails.getInstrumentDetails().getAutoIncDecs();
			for (AutoIncDec eachAutoIncDec : autoIncDecList) {
				if(!(eachAutoIncDec.getOpCode()!=null && eachAutoIncDec.getOpCode().equals(ALOCConstants.DELETE))){					
					if(eachAutoIncDec.getAutoIncDt().compareTo(getCurrentDateWithOutTime()) == -1){
						return false;
					}
				}
			}
		}
		return true;
	}
	
	/**
	 * Mandatory Validation for the InstrumentDetails AutoIncrease Decrease Amount Validation.
	 * @return
	 */
	public static Boolean autoIncDecAmountValidation() {
		RequestDetailsBO requestDetailsBO = ALOCContext.getActiveRequest();
		RequestDetails requestDetails = requestDetailsBO.getModel();	
		//Set<Calendar> autoIncDecDates = new HashSet<Calendar>();
		if(requestDetails.getInstrumentDetails().getAutoIncDecFlag() != null && requestDetails.getInstrumentDetails().getAutoIncDecFlag().equals(ALOCConstants.TRUE_SMALL)){
			List<AutoIncDec> autoIncDecList = requestDetails.getInstrumentDetails().getAutoIncDecs();
			for (AutoIncDec eachAutoIncDec : autoIncDecList) {
				if(!(eachAutoIncDec.getOpCode()!=null && eachAutoIncDec.getOpCode().equals(ALOCConstants.DELETE))){					
					if(eachAutoIncDec.getAutoIncAmt()!=null && eachAutoIncDec.getAutoIncAmt().intValue() <= 0){
						return false;
					}
				}
			}
		}
		return true;
	}
	
	
	/**
	 * Mandatory Validation for the Payment Schedule validation
	 * @return
	 */
	public static Boolean paymentScheduleMandatory() {
		RequestDetailsBO requestDetailsBO = ALOCContext.getActiveRequest();
		RequestDetails requestDetails = requestDetailsBO.getModel();
		if (requestDetails.getPaymentScheduleDetails().getAdditionalPayments() != null) {
			List<AdditionalPayments> additionalPaymentsList = requestDetails.getPaymentScheduleDetails().getAdditionalPayments();
			for (AdditionalPayments additionalPayment : additionalPaymentsList) {
				if(!(additionalPayment.getOpCode()!=null && additionalPayment.getOpCode().equals(ALOCConstants.DELETE))){
					if (additionalPayment.getEstAmt() == null
							|| additionalPayment.getEstMonths() == null
							|| additionalPayment.getEstDt() == null) {
						return false;
					}
				}
			}
		}else {
			return false;
		}
		return true;
	}

	/**
	 * Mandatory Validation for the Payment Schedule Amount validation
	 * @return
	 */
	public static Boolean paymentScheduleAmountValidation() {
		RequestDetailsBO requestDetailsBO = ALOCContext.getActiveRequest();
		RequestDetails requestDetails = requestDetailsBO.getModel();
		if (requestDetails.getPaymentScheduleDetails().getAdditionalPayments() != null && requestDetails.getTransactionDetails().getDocLCAmt() != null) {
			List<AdditionalPayments> additionalPaymentsList = requestDetails.getPaymentScheduleDetails().getAdditionalPayments();
			for (AdditionalPayments additionalPayment : additionalPaymentsList) {
				if(!(additionalPayment.getOpCode()!=null && additionalPayment.getOpCode().equals(ALOCConstants.DELETE))){
					if (additionalPayment.getEstAmt() == null || requestDetails.getTransactionDetails().getDocLCAmt() == null || requestDetails.getTransactionDetails().getDocLCAmt().compareTo(additionalPayment.getEstAmt()) < 0) {
						return false;
					}
				}
			}
		}else {
			return true;
		}
		return true;
	}
	/**
	 * This method is used to get Instrument Type Id
	 * @return
	 */
	public static int getInstrumentTypeId() {
		RequestDetailsBO requestDetailsBO = ALOCContext.getActiveRequest();
		RequestDetails requestDetails = requestDetailsBO.getModel();
		return requestDetails.getInstrumentTypeId().intValue();
	}

	/**
	 * This method is used to get Stage Id
	 * @return stageid
	 */
	public static int getStageId()
	{
		int stageid=ALOCConstants.BASE_VALUE;
		RequestDetailsBO requestDetailsBO = ALOCContext.getActiveRequest();
		RequestDetails requestDetails = requestDetailsBO.getModel();
		if(requestDetails.getWFDetails() != null){
			if(requestDetails.getWFDetails().getWFStageID() != null){
				return requestDetails.getWFDetails().getWFStageID().intValue();
			}
		}
		return stageid;
	}

	/**
	 * This method is used to find the request is BankGaurantee or not 
	 * @param sectionId
	 * @return
	 */
	public static boolean isBankGuaranteeOrSBLCRequest(BigInteger instrumentTypeId){
		if(instrumentTypeId!=null){
			if(InstrumentType.BANK_GUARANTEE.getId()==instrumentTypeId.intValue() 
					|| InstrumentType.LOC.getId()==instrumentTypeId.intValue()){
				return true;
			}
		}
		return false;
	}

	/**
	 * This method is used to find the request is documentloc or not 
	 * @param sectionId
	 * @return
	 */
	public static boolean isDocLOCRequest(BigInteger instrumentTypeId){
		if(instrumentTypeId!=null){
			if(InstrumentType.DOCUMENT_LOC.getId()==instrumentTypeId.intValue()){
				return true;
			}
		}
		return false;
	}

	/**
	 * This method id used to Validate BUC and ADN combination
	 * @param ibsMsgId
	 * @return
	 */
	public static boolean isValidBUCADN(BigInteger ibsMsgId){
		BigInteger bigInt = new BigInteger(ALOCConstants.BASE_STRING_VALUE);
		if(ibsMsgId != null && !ibsMsgId.equals(bigInt)){
			return true;
		}
		return false;
	}

	/**
	 * This method is used to find the section name is TripartyFlag or not 
	 * @param sectionId
	 * @return
	 */
	public static boolean isTripartyFlagSection(String sectionId){
		if(RequestSectionId.TRIPARTYFLAG.getAsString().equals(sectionId)){
			return true;
		}
		return false;
	}



	/**
	 * This method is used to find the section name is Transaction Parties or not 
	 * @param sectionId
	 * @return
	 */
	public static boolean isTPSection(String sectionId){
		if(RequestSectionId.TRANSACTION_PARTIES.getAsString().equals(sectionId)){
			return true;
		}
		return false;
	}

	/**
	 * This method is used to find the section name is Transaction Parties Applicant or not
	 * @param sectionId
	 * @return
	 */
	public static boolean isTPapplicantSection(String sectionId){
		if(RequestSectionId.TPAPPLICANT.getAsString().equals(sectionId)){
			return true;
		}
		return false;
	}

	/**
	 * This method is used to find the section name is Transaction Parties Customer or not
	 * @param sectionId
	 * @return
	 */
	public static boolean isTPcustomerSection(String sectionId){
		if(RequestSectionId.TPCUSTOMER_BENEFICIARY.getAsString().equals(sectionId)){
			return true;
		}
		return false;
	}

	/**
	 * This method is used to find TP Tri-Party having value or not
	 * @param siteTypeName
	 * @param triPartyRequestFlag
	 * @return
	 */
	public static boolean isTPTriParty(String siteTypeName, Boolean triPartyRequestFlag){
		if(ALOCConstants.FINANCIAL_BUSINESS.equals(siteTypeName) 
				&& (triPartyRequestFlag != null && triPartyRequestFlag.booleanValue())){
			return true;
		}
		return false;
	}

	/**
	 * This method is used to find the section name is createNewSite or not
	 * @param sectionId
	 * @return
	 */
	public static boolean isSiteSection(String sectionId){
		if(SiteSectionId.CREATE_NEW_SITE.getAsString().equals(sectionId)){
			return true;
		}
		return false;
	}

	/**
	 * This method is used to find the section name is Principal or not
	 * @param sectionId
	 * @return
	 */
	public static boolean isPrincipalSection(String sectionId){
		if(RequestSectionId.PRINCIPAL.getAsString().equals(sectionId)){
			return true;
		}
		return false;
	}

	/**
	 * This method is used to find the section name is Obligee or not
	 * @param sectionId
	 * @return
	 */
	public static boolean isObligeeSection(String sectionId){
		if(RequestSectionId.OBLIGEE.getAsString().equals(sectionId)){
			return true;
		}
		return false;
	}

	/**
	 * This method is used to find the section name is bondRequestor or not
	 * @param sectionId
	 * @return
	 */
	public static boolean isBondRequestorSection(String sectionId){
		if(RequestSectionId.BOND_REQUESTOR.getAsString().equals(sectionId)){
			return true;
		}
		return false;
	}

	/**
	 * This method is used to find the section name is issuingBank or not
	 * @param sectionId
	 * @return
	 */
	public static boolean isIssuingBankSection(String sectionId){
		if(RequestSectionId.ISSUING_BANK.getAsString().equals(sectionId)){
			return true;
		}
		return false;
	}

	/**
	 * This method is used to find the section name is Applicant or not
	 * @param sectionId
	 * @return
	 */
	public static boolean isApplicantSection(String sectionId){
		if(RequestSectionId.APPLICANT.getAsString().equals(sectionId)){
			return true;
		}
		return false;
	}

	/**
	 * This method is used to find the section name is Beneficiary or not
	 * @param sectionId
	 * @return
	 */
	public static boolean isBeneficiarySection(String sectionId){
		if(RequestSectionId.BENEFICIARY.getAsString().equals(sectionId)){
			return true;
		}
		return false;
	}

	/**
	 * This method is used to find the section name is Delivery instructions or not
	 * @param sectionId
	 * @param ecopyOtherGEPerson
	 * @return
	 */
	public static boolean isDeliverySection(String sectionId,String ecopyOtherGEPerson){
		if(RequestSectionId.DELIVERY_INSTRUTIONS.getAsString().equals(sectionId) && (ecopyOtherGEPerson != null && ecopyOtherGEPerson.equals(ALOCConstants.TRUE_SMALL))){
			return true;
		}
		return false;
	}
	
	/**
	 * This method is used to find the section name is Rider Delivery instructions or not
	 * @param sectionId
	 * @return
	 */
	public static boolean isRiderDeliverySection(String sectionId){
		if(RequestSectionId.RIDER_DELIVERY_INSTRUTIONS.getAsString().equals(sectionId)){
			return true;
		}
		return false;
	}
	
	/**
	 * Validation for Attachments File Upload
	 * @return || attachmentBO.getModel().getGeFileId()==null
	 */
	public static Boolean validateFormatDefaultAtmtFileUpload() {		
		RequestDetailsBO requestDetailsBO = ALOCContext.getActiveRequest();				
		List<AttachmentBO> attachmentBOList = requestDetailsBO.getFormatBO().getAttachmentBOList();
		if( requestDetailsBO.getFormatBO().getFormatType()==FormatType.NON_STANDARD){
			for (AttachmentBO attachmentBO : attachmentBOList) {
				if(attachmentBO.getModel().getGeFileId() ==null){
					return false;
				}else if(StringUtils.isBlank(attachmentBO.getModel().getAttachmentOriginalName())){
					return false;
				}else{
					return true;
				}
			}
			return true;
		}else {
			return true; }
	}

	/**
	 * Validation for Attachments File Upload
	 * @return
	 */
	public static Boolean validateFormatAtmtFileUpload() {		
		RequestDetailsBO requestDetailsBO = ALOCContext.getActiveRequest();				
		List<AttachmentBO> attachmentBOList = requestDetailsBO.getFormatBO().getAttachmentBOList();		
		if( requestDetailsBO.getFormatBO().getFormatType()==FormatType.NON_STANDARD){
			return validateFileUpload(attachmentBOList);
		}else {
			return true; }
	}

	/**
	 * Validation for Attachments File Upload
	 * @return
	 */
	public static Boolean validateAtmtFileUpload() {		
		RequestDetailsBO requestDetailsBO = ALOCContext.getActiveRequest();				
		List<AttachmentBO> attachmentBOList = requestDetailsBO.getAttachmentBOList();			
		return validateFileUpload(attachmentBOList);
	}

	/**
	 * This method is used to validate the File upload
	 * @param attachmentBOList
	 * @return
	 */
	private static boolean validateFileUpload(List<AttachmentBO> attachmentBOList){
		if (attachmentBOList != null && !attachmentBOList.isEmpty()) {				
			for (AttachmentBO attachmentBO : attachmentBOList) {	
				if(attachmentBO.getModel().getAttachmentPermissions() != null && !attachmentBO.getModel().getAttachmentPermissions().isEmpty()){
					if ((attachmentBO.getModel().getGeFileId() == null &&  (attachmentBO.isBankPermission() == true ||	attachmentBO.isTreasuryPermission() == true || attachmentBO.isSuretyPermission() == true))){
						return false;
					}
					continue;
				}
			}
			return true;
		}
		return true;
	}


	/**
	 * Validation for issuance bank reference number
	 * @return
	 */
	public static boolean validateissuerAttachment(){
		RequestDetailsBO requestDetailsBO = ALOCContext.getActiveRequest();	
		List<AttachmentBO> attachmentBOList = requestDetailsBO.getAttachmentBOList();	
		if (attachmentBOList != null && !attachmentBOList.isEmpty()) {
			RequestDetails requestDetails = requestDetailsBO.getModel();
			String issuanceType = requestDetails.getBidReplyDetails() != null ? requestDetails.getBidReplyDetails().getIssuanceTypeFlag() : null;
			for (AttachmentBO attachmentBO : attachmentBOList) {
				if(issuanceType != null && issuanceType.equalsIgnoreCase(ALOCConstants.ISSUANCE_TYPE_INDIRECT)){
					if(attachmentBO.getIssuanceDocType() != null && attachmentBO.getIssuanceDocType().equalsIgnoreCase(ALOCConstants.DOCTYPE_OTHER)){
						if(StringUtils.isBlank(attachmentBO.getIssuanceBankRefNo()) || StringUtils.isBlank(attachmentBO.getIssuanceDesc()) || attachmentBO.getIssuanceDate()==null){
							return false;
						}
					}else {
						if(StringUtils.isBlank(attachmentBO.getIssuanceBankRefNo()) && StringUtils.isBlank(attachmentBO.getIssuanceDesc()) && attachmentBO.getIssuanceDate()==null && StringUtils.isBlank(attachmentBO.getModel().getGeFileId()) && StringUtils.isBlank(attachmentBO.getIssuanceDocument())){
							return true;
						}else if(StringUtils.isNotBlank(attachmentBO.getIssuanceBankRefNo()) && StringUtils.isNotBlank(attachmentBO.getIssuanceDesc()) && attachmentBO.getIssuanceDate()!=null){
							return true;
						}else{
							return false;
						}
					}
				}else {
					if(StringUtils.isBlank(attachmentBO.getIssuanceBankRefNo()) || StringUtils.isBlank(attachmentBO.getIssuanceDesc()) || attachmentBO.getIssuanceDate()==null){
						return false;
					}
				}
				continue;		
			}
			return true;
		}
		return true;		

	}

	/**
	 * Validation for issuance attachment date 
	 * @return
	 */
	public static boolean validateIssuanceDate(){
		RequestDetailsBO requestDetailsBO = ALOCContext.getActiveRequest();	
		List<AttachmentBO> attachmentBOList = requestDetailsBO.getAttachmentBOList();	
		Calendar expirationDate = null;	
		if (requestDetailsBO.getModel().getInstrumentTypeId().intValue() == InstrumentType.BANK_GUARANTEE.getId()
				|| requestDetailsBO.getModel().getInstrumentTypeId().intValue() == InstrumentType.LOC.getId()
				|| requestDetailsBO.getModel().getInstrumentTypeId().intValue() == InstrumentType.AMENDMENT.getId()) {
			
			if (requestDetailsBO.getModel().getInstrumentTypeId().intValue() == InstrumentType.AMENDMENT.getId()) { //validation for closure date based on the instrument type
				if(requestDetailsBO.getModel().getAmendment().getExpiryDate().getRevisedExpiryDate()!= null)
					expirationDate = (Calendar) requestDetailsBO.getModel().getAmendment().getExpiryDate().getRevisedExpiryDate();
			} else {
				if(requestDetailsBO.getModel().getIssuingBankDetails().getUSExpirationDate()!= null)
					expirationDate = (Calendar) requestDetailsBO.getModel().getIssuingBankDetails().getUSExpirationDate();
				if(expirationDate==null){					
					if(requestDetailsBO.getModel().getInstrumentDetails().getExpiryDt()!= null)
						expirationDate = (Calendar) requestDetailsBO.getModel().getInstrumentDetails().getExpiryDt();
					boolean checkDate = isEconoExpiryDtMandatory(expirationDate);							
					if(checkDate)
					{
						if(requestDetailsBO.getModel().getInstrumentDetails().getEconoExpiryDt()!= null)
							expirationDate = requestDetailsBO.getModel().getInstrumentDetails().getEconoExpiryDt();
					}
				}
		     }
		}else if (requestDetailsBO.getModel().getInstrumentTypeId().intValue() == InstrumentType.SURETY_BOND.getId()
					|| requestDetailsBO.getModel().getInstrumentTypeId().intValue() == InstrumentType.RIDER.getId()) {
				if( requestDetailsBO.getModel().getInstrumentTypeId().intValue() == InstrumentType.RIDER.getId())
				{
					if(requestDetailsBO.getModel().getRider().getExpiryDate().getRevisedExpiryDate() != null)
						expirationDate = (Calendar) requestDetailsBO.getModel().getRider().getExpiryDate().getRevisedExpiryDate(); 
				}else{
					if(requestDetailsBO.getModel().getBondInfo().getExpirationDt()!= null)
						expirationDate = (Calendar) requestDetailsBO.getModel().getBondInfo().getExpirationDt();
				}
		 }
		if (attachmentBOList != null && !attachmentBOList.isEmpty()) {				
			for (AttachmentBO attachmentBO : attachmentBOList) {	
				if(requestDetailsBO.getModel().getInstrumentTypeId().intValue() == InstrumentType.DOCUMENT_LOC.getId()){
					if((attachmentBO.getIssuanceDocType() != null &&attachmentBO.getIssuanceDocType().equalsIgnoreCase(ALOCConstants.DOCTYPE_FORMAT) || attachmentBO.getIssuanceDocType().equalsIgnoreCase(ALOCConstants.DOCTYPE_OTHER)) && attachmentBO.getIssuanceDate()!= null){
						if(attachmentBO.getIssuanceDate().compareTo(getCurrentDateWithOutTime())==ALOCConstants.BASE_NEGATIVE_VALUE) {
							return false; }
					}else {
						return true; }
				}
				else{
					if((attachmentBO.getIssuanceDocType() != null && (attachmentBO.getIssuanceDocType().equalsIgnoreCase(ALOCConstants.DOCTYPE_FORMAT) || attachmentBO.getIssuanceDocType().equalsIgnoreCase(ALOCConstants.DOCTYPE_OTHER))) && attachmentBO.getIssuanceDate()!= null){
						if(attachmentBO.getIssuanceDate().compareTo(getCurrentDateWithOutTime())==-1
								&& (expirationDate != null && expirationDate.compareTo(attachmentBO.getIssuanceDate())==ALOCConstants.BASE_NEGATIVE_VALUE)) {
							return false; }
					}else {
						return true; }				
				}				
			}
			return true;
		}
		return true;		
	}
	

	/**
	 * Validation for issuance attachment
	 * @return
	 */
	public static boolean validateAttachment(){
		RequestDetailsBO requestDetailsBO = ALOCContext.getActiveRequest();	
		List<AttachmentBO> attachmentBOList = requestDetailsBO.getAttachmentBOList();	
		if (attachmentBOList != null && !attachmentBOList.isEmpty()) {
			RequestDetails requestDetails = requestDetailsBO.getModel();
			String issuanceType = requestDetails.getBidReplyDetails() != null ? requestDetails.getBidReplyDetails().getIssuanceTypeFlag() : null;
			
			Attachment attachment = null;
			for (AttachmentBO attachmentBO : attachmentBOList) {
				if(attachmentBO.getModel().getGeFileId()!=null 
						&&(attachmentBO.getModel().getIssuanceDocTypeId() != null 
						&& !attachmentBO.getIssuanceDocType().equals(attachmentBO.getModel().getIssuanceDocTypeId().toString()))){
					
					attachment = attachmentBO.getModel();
					
					AttachmentBO atmtBO = new AttachmentBO(new Attachment());
					atmtBO.setIssuanceBankRefNo(attachmentBO.getIssuanceBankRefNo());
					atmtBO.setIssuanceDate(attachmentBO.getIssuanceDate());
					atmtBO.setIssuanceDocType(attachmentBO.getIssuanceDocType());
					atmtBO.setIssuanceDesc(attachmentBO.getIssuanceDesc());
					atmtBO.setIssuanceDocument(attachmentBO.getIssuanceDocument());
					
					attachmentBOList.set(0, atmtBO);
					
				}else if(attachmentBO.getModel().getGeFileId()==null && attachmentBO.getIssuanceDocType().equals(ALOCConstants.MIN_VALUE)){
					AttachmentBO secondAtmtBO = new AttachmentBO(attachment);
					secondAtmtBO.setIssuanceBankRefNo(attachmentBO.getIssuanceBankRefNo());
					secondAtmtBO.setIssuanceDate(attachmentBO.getIssuanceDate());
					secondAtmtBO.setIssuanceDocType(attachmentBO.getIssuanceDocType());
					secondAtmtBO.setIssuanceDesc(attachmentBO.getIssuanceDesc());
					secondAtmtBO.setIssuanceDocument(attachmentBO.getIssuanceDocument());
					attachmentBOList.set(1, secondAtmtBO);				
				}
			}
			for (AttachmentBO attachmentBO : attachmentBOList) {
				if(issuanceType != null && issuanceType.equalsIgnoreCase(ALOCConstants.ISSUANCE_TYPE_INDIRECT)){
					if(attachmentBO.getIssuanceDocType() != null && attachmentBO.getIssuanceDocType().equalsIgnoreCase(ALOCConstants.DOCTYPE_OTHER)){
						
						if(StringUtils.isBlank(attachmentBO.getModel().getGeFileId()) && StringUtils.isBlank(attachmentBO.getIssuanceDocument())){
							return false;
						}
					}else {
						if((StringUtils.isBlank(attachmentBO.getIssuanceBankRefNo()) && (StringUtils.isBlank(attachmentBO.getIssuanceDesc()) && attachmentBO.getIssuanceDate()==null)) && (StringUtils.isBlank(attachmentBO.getModel().getGeFileId()) && StringUtils.isBlank(attachmentBO.getIssuanceDocument()))){
							return true;
						}else if((StringUtils.isNotBlank(attachmentBO.getIssuanceBankRefNo()) || (StringUtils.isNotBlank(attachmentBO.getIssuanceDesc()) || attachmentBO.getIssuanceDate()!=null)) && (StringUtils.isNotBlank(attachmentBO.getModel().getGeFileId()) || StringUtils.isNotBlank(attachmentBO.getIssuanceDocument()))){
							return true;
						}else{
							return false;
						}
					}
				}else{
					if(StringUtils.isBlank(attachmentBO.getModel().getGeFileId()) && StringUtils.isBlank(attachmentBO.getIssuanceDocument())){
						return false;
					}
				}
				continue;		
			}
			return true;
		}
		return true;		
	}

	/**
	 * Validation for preAgreed Pricing Details
	 * @return
	 */
	public static boolean validatepreAgreedPricingDetails(String optVal){
		RequestDetailsBO requestDetailsBO = ALOCContext.getActiveRequest();
		PreAgreedPricingDetails preAgreedPricingDetails = requestDetailsBO.getModel().getPreAgreedPricingDetails();
		if (com.hydus.hwf.util.StringUtils.isNotBlank(optVal) && optVal.equals(ALOCConstants.BID_REPLY_FLAG)
				&& requestDetailsBO.getModel().getAdditionalInstrumentDetails() != null
				&& requestDetailsBO.getModel().getAdditionalInstrumentDetails().isRequestForProposal() != null
				&& requestDetailsBO.getModel().getAdditionalInstrumentDetails().isRequestForProposal()) {
			if (preAgreedPricingDetails != null	&& (preAgreedPricingDetails.getOneTimeFeesDetails().getAcceptPricingDetailsFlag() == null || 
					preAgreedPricingDetails.getOneTimeFeesDetails().getAcceptPricingDetailsFlag().equalsIgnoreCase(ALOCConstants.EMPTY_STRING))) {
				return false;
			} else {
				return true;
			}
		}
		return true;
	}

	/**
	 * Validation for ReasonForRejection
	 * 
	 * @return
	 */
	public static boolean validateReasonForRejection() {
		RequestDetailsBO requestDetailsBO = ALOCContext.getActiveRequest();
		PreAgreedPricingDetails preAgreedPricingDetails = requestDetailsBO
				.getModel().getPreAgreedPricingDetails();
		if (com.hydus.hwf.util.StringUtils.isNotBlank(requestDetailsBO.getModel().getBidOrOptFlag())&& requestDetailsBO.getModel().getBidOrOptFlag().equals(ALOCConstants.BID_REPLY_FLAG)) {
			if (preAgreedPricingDetails != null&& (preAgreedPricingDetails.getOneTimeFeesDetails().getAcceptPricingDetailsFlag() != null && preAgreedPricingDetails.getOneTimeFeesDetails().getAcceptPricingDetailsFlag().equalsIgnoreCase(ALOCConstants.PRICINGREJECT) && 
					preAgreedPricingDetails.getOneTimeFeesDetails().getReasonForRejection().equalsIgnoreCase(ALOCConstants.EMPTY_STRING))) {
				return false;
			} else {
				return true;
			}
		}
		return true;
	}



	/**
	 * Method to get the selected SiteNames for the given Model
	 * @param requestDetails
	 * @param selectedSiteNames
	 * @return
	 */
	public static String setSelSiteNames(
			RequestDetails requestDetails, String selectedSiteNames) {
		List<SelectedSites> selSiteList = requestDetails.getSiteSelection().getSelectedSites();

		if(selSiteList != null && selSiteList.size() > ALOCConstants.BASE_VALUE)
		{
			for(SelectedSites selectedSite : selSiteList)
			{
				if(selectedSiteNames == null || selectedSiteNames.length() == ALOCConstants.BASE_VALUE)
				{
					selectedSiteNames = selectedSite.getSiteName();
				}
				else
				{
					selectedSiteNames = selectedSiteNames+ALOCConstants.COMMA+ selectedSite.getSiteName();
				}
			}
		}
		return selectedSiteNames;
	}

	/**
	 * Validation for usContentPercent selection
	 * @return
	 */
	public static boolean validatingGoodsOrigin()
	{
		List<GoodsOrigin> goodsorigin = new ArrayList<GoodsOrigin>();
		boolean contentpercent = false;
		RequestDetailsBO requestDetailsBO = ALOCContext.getActiveRequest();
		RequestDetails requestDetails = requestDetailsBO.getModel();
		if(requestDetails.getTransactionDetails() != null){
			if(requestDetails.getTransactionDetails().getGoodsOrigins() != null){
				goodsorigin = requestDetails.getTransactionDetails().getGoodsOrigins();
				for(GoodsOrigin goodsOrigins : goodsorigin){
					if(goodsOrigins.getCountryCd().equals(ALOCConstants.US)){
						if(requestDetails.getTransactionDetails().getUSContentPercent() == null || requestDetails.getTransactionDetails().getUSContentPercent().equals(ALOCConstants.EMPTY_STRING)){
							contentpercent = false;
						}else { contentpercent = true; }
					}else { contentpercent = true; }
				}
			}
		}
		return contentpercent;
	}

	/**
	 * Method to get the selected SiteIds for the given Model
	 * @param requestDetails
	 * @param rightSelSites
	 * @return rightSelSites
	 */
	public static List<String> setSelSiteIds(RequestDetails requestDetails,List<String> rightSelSites) {					
		List<SelectedSites> selSiteList = requestDetails.getSiteSelection().getSelectedSites();
		for(SelectedSites selectedSite : selSiteList)
		{
			if(rightSelSites == null || rightSelSites.size() == ALOCConstants.SELSITES_BASE_SIZE)
			{
				rightSelSites = new ArrayList<String>();
				rightSelSites.add(selectedSite.getSiteId().toString());
			}
			else{
				rightSelSites.add(selectedSite.getSiteId().toString());
			}
		}
		return rightSelSites;
	}

	/**
	 * Method to set the selected sites into requestdetails
	 * @param requestDetails
	 * @param rightSelSiteList
	 * @return
	 */
	public static RequestDetails setSiteSelectionDetails(RequestDetails requestDetails,List<String> rightSelSiteList)
	{
		List<SelectedSites> newSelectedSitesList = new ArrayList<SelectedSites>();
		if(rightSelSiteList == null || rightSelSiteList.size() == ALOCConstants.SELSITES_BASE_SIZE)
		{
			SelectedSites selectedSites = new SelectedSites();
			selectedSites.setSiteId(requestDetails.getSiteId().intValue());
			selectedSites.setSiteName(requestDetails.getSiteName());
			newSelectedSitesList.add(selectedSites);
		}
		else
		{
			List<AvailableSites> availableSitesList = requestDetails.getSiteSelection().getAvailableSites();
			if(availableSitesList != null && availableSitesList.size() > ALOCConstants.BASE_VALUE)
			{
				SelectedSites selectedSites = null;
				for(AvailableSites availableSites : availableSitesList )
				{
					if(rightSelSiteList.contains((availableSites.getSiteId()).toString()))
					{
						selectedSites =new SelectedSites();
						selectedSites.setSiteId(availableSites.getSiteId());
						selectedSites.setSiteName(availableSites.getSiteName());
						newSelectedSitesList.add(selectedSites);
					}
				}
			}
		}
		requestDetails.getSiteSelection().setSelectedSites(newSelectedSitesList);
		requestDetails.getSiteSelection().setAvailableSites(null);
		return requestDetails;
	}

	/**
	 * This method is used to convert String to Calendar
	 * @param dateString
	 * @return Calendar
	 * @throws ParseException
	 */
	public static Calendar convertStringToCal(String dateString) throws ParseException{
		Calendar cal = null;
		DateFormat formatter = new SimpleDateFormat(ALOCConstants.FEE_HISTORY_DATEPATTERN);
		Date date = formatter.parse(dateString);
		cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}

	/**
	 * Checking Treasury Approver validation is required for amendment or not.
	 * @return
	 */
	public static boolean amdTreasuryApproverValidationRequired()
	{
		boolean result = false;
		RequestDetailsBO requestDetailsBO = ALOCContext.getActiveRequest();
		RequestDetails requestDetails = requestDetailsBO.getModel();
		if (requestDetails.getAmendment() != null) {
			BigDecimal revisedUSDEquiAmt = requestDetails.getAmendment()
					.getAmendmentInstrumentAmountCurr().getRevisedUSDEquiAmt();
			BigDecimal amdWorkflowAmt = requestDetails.getAmendment()
					.getAMDWorkflowAmt();
			if (revisedUSDEquiAmt != null && amdWorkflowAmt != null) {
				int compareVal = revisedUSDEquiAmt.compareTo(amdWorkflowAmt);
				if (compareVal == ALOCConstants.MIN_VALUE) {
					result= true;
				} else if (compareVal == ALOCConstants.BASE_NEGATIVE_VALUE) {
					result= false;
				}

			}

		}

		return result;
	}

	/**
	 * Validation for approver Size
	 * @return
	 */
	public static boolean approverSizeValidation()
	{
		RequestDetailsBO requestDetailsBO = ALOCContext.getActiveRequest();
		RequestDetails requestDetails = requestDetailsBO.getModel();
		if (requestDetails.getDelegationApprovers().getDelegationGroups()
				.get(ALOCConstants.BASE_VALUE).getGroupApprovers() != null
				&& requestDetails.getDelegationApprovers()
				.getDelegationGroups().get(ALOCConstants.BASE_VALUE).getGroupApprovers()
				.size() > ALOCConstants.BASE_VALUE) {
			return true; }
		else {
			return false; }
	}

	/**
	 * Method to set the selected bankIds for given RequestDetails
	 * @param requestDetails
	 * @param rightBankRecords
	 * @return rightBankRecords
	 */
	public static List<String> setSelectedBankDetails(RequestDetails requestDetails,List<String> rightBankRecords){
		if(requestDetails.getSelectedBanks() != null){
			List<BankDetails> selBankDetailsList = requestDetails.getSelectedBanks().getBankDetails();
			if(selBankDetailsList != null && selBankDetailsList.size() > ALOCConstants.BASE_VALUE){
				rightBankRecords = new ArrayList<String>();
				for(BankDetails selBankDetails : selBankDetailsList){
					if(StringUtils.isNotBlank(selBankDetails.getSiteName())){
						rightBankRecords.add(selBankDetails.getSiteName());
					}
				}
			}
		}
		return rightBankRecords;
	}

	/**
	 * Method to set the selected bankIds for given RequestDetails
	 * @param requestDetails
	 * @return
	 */
	public static RequestDetailsBO filterBankRecordsBySiteName(RequestDetails requestDetails){
		List<BankDetails> filBanksLst = new ArrayList<BankDetails>(); 
		if(requestDetails.getBankDetails() != null){
			List<BankDetails> bankDetLst = requestDetails.getBankDetails();
			List<String> siteNameLt = new ArrayList<String>();
			if(bankDetLst.size()!=ALOCConstants.BASE_VALUE){
				for(BankDetails eachbank : bankDetLst){
					BankDetails bankDet = new BankDetails();
					String siteName = eachbank.getSiteName();
					if(StringUtils.isNotBlank(siteName) && !(siteNameLt.contains(eachbank.getSiteName()))){
						bankDet.setBankIdentifierCode(eachbank.getBankIdentifierCode());
						bankDet.setBankMDMId(eachbank.getBankMDMId());
						bankDet.setName(eachbank.getName());
						bankDet.setSiteId(eachbank.getSiteId());
						bankDet.setSiteName(eachbank.getSiteName());
						filBanksLst.add(bankDet);
						siteNameLt.add(eachbank.getSiteName());
					}
				}
			}
		}
		requestDetails.setBankDetails(filBanksLst);
		RequestDetailsBO requestDetailsBO = new RequestDetailsBO(requestDetails);
		return requestDetailsBO;
	}

	/**
	 * Method for validating check box list selected or not
	 * @param list
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static boolean validatelist(List list)
	{
		if(list== null || list.size() == ALOCConstants.BASE_VALUE) {
			return false; }
		else {
			return true; }
	}
	
	/**
	 * Method for validating format exists or not in the request
	 * @param list
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static boolean validateDownloadFormat(List list){		
		if(list != null && list.size() > ALOCConstants.BASE_VALUE){
		    if(list.contains(ALOCConstants.FORMAT)) {
				RequestDetails requestDetails = ALOCContext.getActiveRequest().getModel();	
				List<Attachment> atmtsList = requestDetails.getFormat().getAttachments();
				if((atmtsList==null || atmtsList.isEmpty()) && StringUtils.isBlank(requestDetails.getSwiftFormatDoc())) {
					return false; }
				else {
					return true; }
			}
		}
		return true;

	}

	/**
	 * Validation for suretyStatus of suretyMaster
	 * @param suretyMaster
	 * @return
	 */
	public static boolean validateSuretyMasterStatus(SuretyMaster suretyMaster){
		HttpServletRequest request = ServletActionContext.getRequest();
		String suretyStatus = request.getParameter(ALOCConstants.SURETYMASSTATUS);
		if(suretyStatus != null && suretyStatus.length() > ALOCConstants.BASE_VALUE)
		{
			return true;
		}
		else
		{
			suretyMaster.setSuretyStatus(null);
			return false;
		}
	}

	/**
	 * Return role name as comma separated string
	 * @param roles
	 * @return roleBuilder
	 * @throws HWFException 
	 */
	public static String getRoles(List<String> roles ) {
		if(roles == null || roles.size() == ALOCConstants.BASE_VALUE){
			throw new  ALOCRuntimeException(ALOCRuntimeException.EC_ROLES_NOTFOUND);
		}
		StringBuilder roleBuilder = new StringBuilder();
		int roleCount = roles.size();
		int counter = ALOCConstants.BASE_VALUE;
		for(String eachRole : roles) {
			roleBuilder.append(eachRole);
			if(counter < roleCount - ALOCConstants.MIN_VALUE) {
				roleBuilder.append(ALOCConstants.COMMA);
			}
			counter++;
		}
		return roleBuilder.toString();
	}

	/**
	 * Validation for BUCADNList Update
	 * @param bucAdnList
	 * @return
	 */
	public static boolean validateBucAdnUpdatedList(List<BUCAndADN> bucAdnList){
		boolean isBucAdnUpdate = false;

		if(bucAdnList != null & bucAdnList.size() > ALOCConstants.BASE_VALUE){
			for(BUCAndADN bucAndADN : bucAdnList){
				if(bucAndADN.isUpdateFlag()){
					isBucAdnUpdate = true;
					break;
				}
			}
		}
		else{
			isBucAdnUpdate = false;
		}
		return isBucAdnUpdate;
	}

	/**
	 * Validation for suretyMaster name Already Exists or not
	 * @param suretyName
	 * @return
	 */
	public static boolean validateSuretyMasterNameExists(String suretyName){
		final SuretyMasterCollection suretyList = (SuretyMasterCollection)(ActionContext.getContext().getSession()).get(ALOCConstants.SURETYNAMES);
		HttpServletRequest request = ServletActionContext.getRequest();
		String suretyId = request.getParameter(ALOCConstants.SURETYMASSURID);
		if(suretyName != null && suretyName.length() > ALOCConstants.BASE_VALUE)
		{
			if(suretyList.getSuretyMasters() != null && suretyList.getSuretyMasters().size() > ALOCConstants.BASE_VALUE){
				for(SuretyMaster tempSuretyMaster : suretyList.getSuretyMasters()){
					if(suretyName.equals(tempSuretyMaster.getSuretyName())){
						if(suretyId != null && !suretyId.equalsIgnoreCase(ALOCConstants.EMPTY_STRING)){
							if((Long.valueOf(suretyId)).equals(tempSuretyMaster.getSuretyId())){
								return true;
							}
							else
							{
								return false;
							}
						}
						else
						{
							return false;
						}
					}}}}
		return true;
	}

	/**
	 * method to create the search criteria
	 * @param instrumentPurpose
	 * @return search
	 */ 
	public static Search createSearch(String instrumentPurpose){
		Search search=new Search();
		List<DashBoard> dashBoards =new ArrayList<DashBoard>();
		DashBoard dashBoard=new DashBoard();
		if(instrumentPurpose.equalsIgnoreCase(ALOCConstants.BID)){
			dashBoard.setInstrumentPurposeId(BigInteger.valueOf(InstrumentPurposeType.BID.getId()));
		}
		else if(instrumentPurpose.equalsIgnoreCase(ALOCConstants.PERFORMANCE)){
			dashBoard.setInstrumentPurposeId(BigInteger.valueOf(InstrumentPurposeType.PERFORMANCE.getId()));
		}
		else if(instrumentPurpose.equalsIgnoreCase(ALOCConstants.FINANCIALS)){
			dashBoard.setInstrumentPurposeId(BigInteger.valueOf(InstrumentPurposeType.FINANCIAL.getId()));
		}
		else if(instrumentPurpose.equalsIgnoreCase(ALOCConstants.ADVANCE_PAYMENT)){
			dashBoard.setInstrumentPurposeId(BigInteger.valueOf(InstrumentPurposeType.ADVANCE_PAYMENT.getId()));
		}
		else{
			dashBoard.setInstrumentID(BigInteger.valueOf(InstrumentType.DOCUMENT_LOC.getId()));
		}
		dashBoards.add(dashBoard);
		search.setDashBoards(dashBoards);
		return search;
	}

	/**
	 * Method to get the unique bundle details from inbox
	 * @param inbox
	 * @return
	 */
	public static Inbox getInboxDetailByBundleId(Inbox inbox) {
		List<RequestDetails> tempRequestDetailsList = inbox.getBundle().getRequestDetails();
		Set<BigInteger> bundleIdSet = new TreeSet<BigInteger>();
		List<RequestDetails> requestDetailsList = new ArrayList<RequestDetails>();
		Map<BigInteger,RequestDetails>  requestDetailsMap = new HashMap<BigInteger, RequestDetails>();
		BigDecimal totalUSDEquivalent;
		Map<BigInteger,BigDecimal>  totalUSDEquivalentMap = new HashMap<BigInteger, BigDecimal>();
		String firstTransactionState = ALOCConstants.EMPTY_STRING;;
		String bundleTransactionState = ALOCConstants.EMPTY_STRING;
		Map<BigInteger,String> bundleStatusMap = new HashMap<BigInteger, String>();

		if(tempRequestDetailsList != null && tempRequestDetailsList.size() > ALOCConstants.BASE_VALUE )
		{
			for(RequestDetails tempRequestDetails : tempRequestDetailsList)
			{
				bundleIdSet.add(tempRequestDetails.getBundleDetails().getBundleId());
			}

			for(BigInteger bundleId : bundleIdSet)
			{
				totalUSDEquivalent = BigDecimal.valueOf(ALOCConstants.BASE_VALUE);
				firstTransactionState = ALOCConstants.EMPTY_STRING;
				bundleTransactionState = ALOCConstants.EMPTY_STRING;
				for(RequestDetails tempRequestDetails : tempRequestDetailsList)
				{
					if(bundleId.equals(tempRequestDetails.getBundleDetails().getBundleId()))
					{

						if(tempRequestDetails.getInstrumentDetails() != null && tempRequestDetails.getInstrumentDetails().getInstrumentCurrencyId() != null)
						{
							if(!tempRequestDetails.getInstrumentDetails().getInstrumentCurrencyId().equals(ALOCConstants.BUNDLE_USD_CURRENCY))
							{
								if(tempRequestDetails.getInstrumentDetails().getUSDEquivalent() != null)
									totalUSDEquivalent = totalUSDEquivalent.add(tempRequestDetails.getInstrumentDetails().getUSDEquivalent()); 
							}
							else
							{
								if(tempRequestDetails.getInstrumentDetails().getInstrumentAmt() != null)
									totalUSDEquivalent = totalUSDEquivalent.add(tempRequestDetails.getInstrumentDetails().getInstrumentAmt());
							}
						}

						if(tempRequestDetails.getTransactionDetails() != null && tempRequestDetails.getTransactionDetails().getDocLCCurId() != null)
						{
							if(!tempRequestDetails.getTransactionDetails().getDocLCCurId().equals(ALOCConstants.BUNDLE_USD_CURRENCY))
							{
								if(tempRequestDetails.getTransactionDetails().getUSDEquivalent() != null)
									totalUSDEquivalent = totalUSDEquivalent.add(tempRequestDetails.getTransactionDetails().getUSDEquivalent()); 
							}
							else
							{
								if(tempRequestDetails.getTransactionDetails().getDocLCAmt() != null)
									totalUSDEquivalent = totalUSDEquivalent.add(tempRequestDetails.getTransactionDetails().getDocLCAmt());
							}
						}
						if(StringUtils.isBlank(firstTransactionState)){
							firstTransactionState = tempRequestDetails.getBundleDetails().getTransactionState();}
						else if(StringUtils.isNotBlank(firstTransactionState) && 
								!firstTransactionState.equalsIgnoreCase(tempRequestDetails.getBundleDetails().getTransactionState())){
							bundleTransactionState = ALOCConstants.BUNDLE_HOLD;	}
					}
				}
				totalUSDEquivalentMap.put(bundleId, totalUSDEquivalent);
				if(StringUtils.isNotBlank(bundleTransactionState)) {
					bundleStatusMap.put(bundleId, bundleTransactionState); }
				else { bundleStatusMap.put(bundleId, firstTransactionState); }
			}

			for(BigInteger bundleId : bundleIdSet)
			{
				for(RequestDetails tempRequestDetails : tempRequestDetailsList)
				{
					if(bundleId.equals(tempRequestDetails.getBundleDetails().getBundleId()))
					{
						InstrumentDetails instrumentDetails = tempRequestDetails.getInstrumentDetails();
						if(instrumentDetails == null)
						{
							instrumentDetails = new InstrumentDetails();
						}
						instrumentDetails.setUSDEquivalent(totalUSDEquivalentMap.get(bundleId));
						tempRequestDetails.setInstrumentDetails(instrumentDetails);
						BundleDetails bundleDetails = tempRequestDetails.getBundleDetails();
						if(bundleDetails == null){ bundleDetails = new BundleDetails(); }
						bundleDetails.setTransactionState(bundleStatusMap.get(bundleId));
						tempRequestDetails.setBundleDetails(bundleDetails);
						requestDetailsList.add(tempRequestDetails);
						requestDetailsMap.put(bundleId, tempRequestDetails);
						break;
					}
				}
			}
		}
		requestDetailsList = sortBundleHashMap(requestDetailsMap);
		inbox.getBundle().setRequestDetails(requestDetailsList);
		return inbox;
	}
	
	/**
	 * Method to Sort the Map Values for the Bundle Dashboard display
	 * @param input
	 * @return requestDetailsList
	 */
	public static List<RequestDetails> sortBundleHashMap(Map<BigInteger,RequestDetails> map) {
		List<Map.Entry<BigInteger,RequestDetails>> list = new LinkedList<Map.Entry<BigInteger,RequestDetails>>(map.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<BigInteger,RequestDetails>>() {

			public int compare(Map.Entry<BigInteger,RequestDetails> map1, Map.Entry<BigInteger,RequestDetails> map2) {
				return (map2.getKey()).compareTo(map1.getKey());
			}
		});
		List<RequestDetails> requestDetailsList = new ArrayList<RequestDetails>();
		for (Map.Entry<BigInteger,RequestDetails> entry : list) {
			requestDetailsList.add(entry.getValue());
		}
		return requestDetailsList;
	}

	/**
	 * Returns true if specified input string is number.
	 * @param s
	 * @return
	 */
	public static boolean isInteger(String s) {
		try { 
			Integer.parseInt(s); 
		} catch(NumberFormatException e) { 
			return false; 
		}
		return true;
	}

	/**
	 * Validation for start date
	 * @return
	 * @throws ParseException 
	 */
	public static boolean validateStartDate(Calendar startDate) throws ParseException{
		boolean flag = true;
		HttpServletRequest request = ServletActionContext.getRequest();
		SimpleDateFormat formatter = new SimpleDateFormat(ALOCConstants.PAYMENT_DATEPATTERN);
		APMDetails apmDetails=(APMDetails)ActionContext.getContext().getSession().get(ALOCConstants.PAYMENT_PERIOD_DETAILS);
		 List<PaymentPeriodDetails> paymentperiodDetails=null;
		if(apmDetails!=null){
		    paymentperiodDetails=apmDetails.getPaymentPeriodDetails();
		}
		if(paymentperiodDetails==null || paymentperiodDetails.size()==ALOCConstants.BASE_VALUE){
			String twoRowPreviousEndDate=request.getParameter(ALOCConstants.ENDDATE);
			if(twoRowPreviousEndDate!=null && twoRowPreviousEndDate!=ALOCConstants.EMPTY_STRING){
				Date date = (Date)formatter.parse(twoRowPreviousEndDate); 
				Calendar previousTwoEndDate=Calendar.getInstance();
				previousTwoEndDate.setTime(date);
				previousTwoEndDate.add(Calendar.DATE, ALOCConstants.MIN_VALUE);
				int i=previousTwoEndDate.compareTo(startDate);
				if(i==ALOCConstants.BASE_VALUE){ flag=true; }
				else{flag = false;}
				previousTwoEndDate.add(Calendar.DATE, ALOCConstants.BASE_NEGATIVE_VALUE);
			} 


		}else{
			String currentIndex=request.getParameter(ALOCConstants.CURINDEX);
			int index=Integer.parseInt(currentIndex)-1;		
			if(paymentperiodDetails != null & paymentperiodDetails.size() > ALOCConstants.BASE_VALUE && index >= ALOCConstants.BASE_VALUE)
			{  
				PaymentPeriodDetails PaymentPeriod=new PaymentPeriodDetails();
				PaymentPeriod.setPaymentPeriodEndDate(paymentperiodDetails.get(index).getPaymentPeriodEndDate());
				Calendar dateOne=(Calendar)PaymentPeriod.getPaymentPeriodEndDate();
				dateOne.add(Calendar.DATE, ALOCConstants.MIN_VALUE);
				String firstDate=formatter.format(dateOne.getTime());
				Date date1=formatter.parse(firstDate);
				String secondDateDate=formatter.format(startDate.getTime());	
				Date date2=formatter.parse(secondDateDate);;
				int i=date1.compareTo(date2);
				if(i==ALOCConstants.BASE_VALUE){ flag=true; }
				else{flag = false;}	
				dateOne.add(Calendar.DATE, ALOCConstants.BASE_NEGATIVE_VALUE);
				} 
		}

		return flag;
	}

	/**
	 * method to populate the search criteria from basic Search
	 * @param userSpecificSites 
	 * @return
	 */
	public static Search populateSearchSchema(String siteId,Integer searchCriteriaType,
			String searchCriteriaText,List<UserSites> userSpecificSites) {
		Search basicSearch = new Search();
		SearchReqDetails searchReqDetails = new SearchReqDetails();
		SearchBankDetails searchBankDetails = new SearchBankDetails();
		searchReqDetails.setSiteIds(populateSiteList(siteId,userSpecificSites));
		if(searchCriteriaType == null) {
			searchCriteriaType = SearchCriteriaType.ALOC_RECORD_NUM.getId();
		}
		if(searchCriteriaType != null) {
			if(!searchCriteriaType.equals(SearchCriteriaType.INSTRUMENT_FROM_AMOUNT.getId()) && !searchCriteriaType.equals(SearchCriteriaType.NAME.getId()) && searchCriteriaText.length() < 3){
				throw new ALOCRuntimeException(ALOCRuntimeException.EC_SEARCH_INVALID_VALUE);
			}else if(searchCriteriaType.equals(SearchCriteriaType.NAME.getId()) && searchCriteriaText.length() < 2){
				throw new ALOCRuntimeException(ALOCRuntimeException.EC_SEARCH_INVALID_NAME);
			}
			switch (SearchCriteriaType.fromId(searchCriteriaType)) {
			case ALOC_RECORD_NUM:
				if(searchCriteriaText != null){
					searchReqDetails.setALOCRecordId(searchCriteriaText);
				}
				break;
			case INSTRUMENT_FROM_AMOUNT:
				basicSearch.setSearchInstrDetails(populateInstrumentAmount(searchCriteriaText));
				break;
			case APPLICATION_PRINCIPAL_NAME:
				basicSearch.setApplicantOrPrincipalName(searchCriteriaText);
				break;
			case BENEFICIARY_OBLIGEE_NAME:
				basicSearch.setBeneficiaryOrObligeeName(searchCriteriaText);
				break;
			case NAME:
				populateRequestorName(searchCriteriaText,searchReqDetails);
				break;
			case INSTRUMENT_PURPOSE:
				populateInstrumentPurpose(searchCriteriaText,searchReqDetails);
				break;
			case STATUS:
				basicSearch.setStatus(searchCriteriaText);
				break;
			case BUNDLE_ID:
				searchReqDetails.setBundleId(new BigInteger(searchCriteriaText));
				break;
			case TRYPARTY_APPLICANT_NAME:
				basicSearch.setTriPartyApplicantName(searchCriteriaText);
				break;
			case BANK_REFERNCE_NUMBER:
				searchBankDetails.setBankRefNo(searchCriteriaText);
				break;
			case SURETY_REFERENCE_NUMBER:
				searchBankDetails.setSuretyRefNo(searchCriteriaText);
				break;
			case MODEL_NAME:
				searchReqDetails.setModelName(searchCriteriaText);
				break;
			default:
				break;
			}
		}
		basicSearch.setSearchReqDetails(searchReqDetails);
		basicSearch.setSearchBankDetails(searchBankDetails);
		return basicSearch;
	}

	/**
	 * method to populate the search criteria from instrument purpose basic Search
	 * @param searchCriteriaText
	 * @param searchReqDetails
	 */
	private static void populateInstrumentPurpose(String searchCriteriaText,
			SearchReqDetails searchReqDetails) {
		List<String> instrPurposeTypes = new ArrayList<String>();
		if(StringUtils.isNotEmpty(searchCriteriaText)){
			InstrumentPurposeType instrumentPurposeType=InstrumentPurposeType.fromName(searchCriteriaText);
			if(instrumentPurposeType != null){
				instrPurposeTypes.add(String.valueOf(instrumentPurposeType.getId()));
				searchReqDetails.setInstrPurposeTypes(instrPurposeTypes);
			}else{
				instrPurposeTypes.add(ALOCConstants.INSTRUMENTPURPOSE_MAX_ADDEDVAL);
				searchReqDetails.setInstrPurposeTypes(instrPurposeTypes);
			}
		}
	}

	/**
	 * method to populate the search criteria from requestor name basic Search
	 * @param searchCriteriaText
	 * @param searchReqDetails
	 */
	private static void populateRequestorName(String searchCriteriaText,
			SearchReqDetails searchReqDetails) {
		if(StringUtils.isNotEmpty(searchCriteriaText)){
			String[] strArray=searchCriteriaText.split(ALOCConstants.COMMA);
			if(strArray.length>ALOCConstants.MIN_VALUE){
				searchReqDetails.setFirstName(strArray[ALOCConstants.MIN_VALUE]);
				searchReqDetails.setLastName(strArray[ALOCConstants.BASE_VALUE]);
			}else{
				searchReqDetails.setLastName(strArray[ALOCConstants.BASE_VALUE]);
			}
		}
	}

	/**
	 * method to populate the search criteria from  instrument amount basic Search
	 * @param searchCriteriaText
	 * @return
	 */
	private static SearchInstrDetails populateInstrumentAmount(String searchCriteriaText) {
		SearchInstrDetails searchInstrDetails = new SearchInstrDetails();
		if(searchCriteriaText!=null && searchCriteriaText.matches(ALOCConstants.AMOUNT_CHECK)){
			searchInstrDetails.setInstrFromAmt(new BigDecimal(searchCriteriaText));
		}
		else{
			 throw new  ALOCRuntimeException(ALOCRuntimeException.EC_SEARCH_INVALID_AMOUNT);
		}
		return searchInstrDetails;
	}

	/**
	 * method to populate the search criteria from site list basic Search
	 * @param siteId
	 * @param userSpecificSites
	 * @return
	 */
	private static List<BigInteger> populateSiteList(String siteId,List<UserSites> userSpecificSites) {
		List<BigInteger> siteIds = new ArrayList<BigInteger>();
		if(StringUtils.isNotBlank(siteId)&& !siteId.equals(ALOCConstants.MONE)){
			siteId=siteId.replace(ALOCConstants.COMMA,ALOCConstants.EMPTY_STRING);
			siteIds.add(new BigInteger(siteId));
		}
		else{
			if(!CollectionUtils.isEmpty(userSpecificSites)){
				for (NameValue nameValue : userSpecificSites) {
					siteIds.add(new BigInteger(nameValue.getID().toString()));
				}
			}
		}
		return siteIds;
	}

	/**
	 * method to populate the search criteria from advance Search
	 * @param searchCriteria
	 * @param instrumentTypes
	 * @return
	 */
	public static Search createSearchCriteria(Search searchCriteria,BigInteger[] instrumentTypes,List<BigInteger> selSites, List<BondSubBond> bondSubBondList){
		HttpServletRequest request = ServletActionContext.getRequest();
		if(!ArrayUtils.isEmpty(instrumentTypes)){
			List<BigInteger> instrTypeIds = Arrays.asList(instrumentTypes);
			if(searchCriteria.getSearchInstrDetails() == null){
				SearchInstrDetails seraInstrDetails=new SearchInstrDetails();
				seraInstrDetails.setInstrTypeIds(instrTypeIds);
				searchCriteria.setSearchInstrDetails(seraInstrDetails);
			}else{
				searchCriteria.getSearchInstrDetails().setInstrTypeIds(instrTypeIds);
			}
		}
		if(selSites != null && !selSites.isEmpty()){
			searchCriteria.getSearchReqDetails().setSiteIds(selSites);
		}
		
		if(ALOCConstants.FALSE.equalsIgnoreCase(searchCriteria.getTriPartyApplicantFlag())){
			searchCriteria.setTriPartyApplicantFlag(null);
		}
		if(ALOCConstants.FALSE.equalsIgnoreCase(searchCriteria.getPrivateLabelApplicantFlag())){
			searchCriteria.setPrivateLabelApplicantFlag(null);
		}
		String searchCriteriaText = request.getParameter(ALOCConstants.ADVANCESEARCHCRITERIATEXT);
		if(StringUtils.isNotEmpty(searchCriteriaText)){
			String[] strArray=searchCriteriaText.split(ALOCConstants.COMMA);
			if(strArray.length>ALOCConstants.MIN_VALUE){
				searchCriteria.getSearchReqDetails().setFirstName(strArray[ALOCConstants.MIN_VALUE]);
				searchCriteria.getSearchReqDetails().setLastName(strArray[ALOCConstants.BASE_VALUE]);	
			}else{
				searchCriteria.getSearchReqDetails().setLastName(strArray[ALOCConstants.BASE_VALUE]);	
			}
		}
		String contactPersonName=request.getParameter(ALOCConstants.CONTACTPERSONNAME);
		if(StringUtils.isNotEmpty(contactPersonName)){
			String[] strNameArray=contactPersonName.split(ALOCConstants.COMMA);
			if(strNameArray.length>ALOCConstants.MIN_VALUE){
				searchCriteria.setBusinessContactFirstName(strNameArray[ALOCConstants.MIN_VALUE]);
				searchCriteria.setBusinessContactLastName(strNameArray[ALOCConstants.BASE_VALUE]);
			}else{
				searchCriteria.setBusinessContactLastName(strNameArray[ALOCConstants.BASE_VALUE]);	
			}
		}
		createSearchCriteriaForSelectedFields(searchCriteria,bondSubBondList);
		createSearchCriteriaForSelectedDates(searchCriteria);
		return searchCriteria;
	}

	/**
	 * method to populate the search criteria from advance Search
	 * @param searchCriteria
	 */
	private static void createSearchCriteriaForSelectedFields(Search searchCriteria,List<BondSubBond> bondSubBondList) {
		if(searchCriteria.getSearchInstrDetails()!=null && searchCriteria.getSearchInstrDetails().getInstrCurrencyCds()!=null){
			List<String> currencyList=new ArrayList<String>();
			for(String currencies:searchCriteria.getSearchInstrDetails().getInstrCurrencyCds()){
				if(StringUtils.isNotEmpty(currencies)){
					currencyList.add(currencies);
				}
			  }
			if(currencyList!=null && currencyList.size()>0 && searchCriteria.getSearchInstrDetails()!=null){
					searchCriteria.getSearchInstrDetails().setInstrCurrencyCds(currencyList);	
			}
		}
		if(searchCriteria.getSearchInstrDetails()!=null && searchCriteria.getSearchInstrDetails().getIssuanceCountries()!=null){
			List<String> countryList=new ArrayList<String>();
			for(String country:searchCriteria.getSearchInstrDetails().getIssuanceCountries()){
				if(StringUtils.isNotEmpty(country)){
					countryList.add(country);
				}
			}
			if(countryList!=null && countryList.size()>0 && searchCriteria.getSearchInstrDetails()!=null){
					searchCriteria.getSearchInstrDetails().setIssuanceCountries(countryList);	
			}	
		}
		if(searchCriteria.getSearchPaymentDetails()!=null && searchCriteria.getSearchPaymentDetails().getPaymentCurrencyCds()!=null){
			List<String> paymentCurrencyList=new ArrayList<String>();
			for(String paymentCurrency:searchCriteria.getSearchPaymentDetails().getPaymentCurrencyCds()){
				if(StringUtils.isNotEmpty(paymentCurrency)){
					paymentCurrencyList.add(paymentCurrency);
				}
			}
				if(paymentCurrencyList!=null && paymentCurrencyList.size()>0 && searchCriteria.getSearchPaymentDetails()!=null){
					searchCriteria.getSearchPaymentDetails().setPaymentCurrencyCds(paymentCurrencyList);	
				}
		}
		if(searchCriteria.getPoles()!=null){
			List<String> poleList=new ArrayList<String>();
			for(String poles:searchCriteria.getPoles()){
				if(StringUtils.isNotEmpty(poles)){
					poleList.add(poles);
				}	
			}
			if(poleList!=null && poleList.size()>ALOCConstants.BASE_VALUE){
				searchCriteria.setPoles(poleList);
			}
		}
		clearInstrPurpose(searchCriteria);
		setBondAndSubBondTypes(searchCriteria,bondSubBondList);
	}

	/**
	 * method to populate the selected bond and subBond types to search criteria from advance Search
	 * @param searchCriteria
	 * @param bondSubBondList
	 */
	private static void setBondAndSubBondTypes(Search searchCriteria,
			List<BondSubBond> bondSubBondList) {
		List<BondSubBond> newBondSubBondList = new ArrayList<SearchReqDetails.BondSubBond>();
		if(bondSubBondList != null && bondSubBondList.size() > 0)
		{
			for(BondSubBond bondSubBond : bondSubBondList)
			{
				if((StringUtils.isNotBlank(bondSubBond.getTypeBond()) || StringUtils.isNotBlank(bondSubBond.getTypeSubBond())))
				{
					newBondSubBondList.add(bondSubBond);
				}
			}
			searchCriteria.getSearchReqDetails().setBondSubBonds(newBondSubBondList);
		}
	}

	/**
	 * method to populate the search criteria from advance Search
	 * @param searchCriteria
	 */
	private static void createSearchCriteriaForSelectedDates(Search searchCriteria) {
		if(searchCriteria.getSearchInstrDetails() != null && searchCriteria.getSearchInstrDetails().getInstrFromAmt() != null && searchCriteria.getSearchInstrDetails().getInstrToAmt() != null){
			if(searchCriteria.getSearchInstrDetails().getInstrFromAmt().compareTo(searchCriteria.getSearchInstrDetails().getInstrToAmt()) == ALOCConstants.MIN_VALUE){
				throw new  ALOCRuntimeException(ALOCRuntimeException.EC_SEARCH_INVALID_AMT_RANGE);
			}
		}
		if(searchCriteria.getSearchDates()!=null && searchCriteria.getSearchDates().getExpiryFromDt()!=null && searchCriteria.getSearchDates().getExpiryToDt()!=null){
			if(searchCriteria.getSearchDates().getExpiryFromDt().compareTo(searchCriteria.getSearchDates().getExpiryToDt())>ALOCConstants.BASE_VALUE){
				throw new  ALOCRuntimeException(ALOCRuntimeException.EC_SEARCH_INVALID_DATE_RANGE);
			}
		}
		if(searchCriteria.getSearchDates()!=null && searchCriteria.getSearchDates().getIssueFromDt()!=null && searchCriteria.getSearchDates().getIssueToDt()!=null){
			if(searchCriteria.getSearchDates().getIssueFromDt().compareTo(searchCriteria.getSearchDates().getIssueToDt())>ALOCConstants.BASE_VALUE){
				throw new  ALOCRuntimeException(ALOCRuntimeException.EC_SEARCH_INVALID_DATE_RANGE);
			}
		}
		if(searchCriteria.getSearchDates()!=null && searchCriteria.getSearchDates().getCreationFromDt()!=null&& searchCriteria.getSearchDates().getCreationToDt()!=null){
			if(searchCriteria.getSearchDates().getCreationFromDt().compareTo(searchCriteria.getSearchDates().getCreationToDt())>ALOCConstants.BASE_VALUE){
			   throw new  ALOCRuntimeException(ALOCRuntimeException.EC_SEARCH_INVALID_DATE_RANGE);
			}
		}
		if(searchCriteria.getSearchDates()!=null && searchCriteria.getSearchDates().getEconoExpiryFromDt()!=null&& searchCriteria.getSearchDates().getEconoExpiryToDt()!=null){
			if(searchCriteria.getSearchDates().getEconoExpiryFromDt().compareTo(searchCriteria.getSearchDates().getEconoExpiryToDt())>ALOCConstants.BASE_VALUE){
			   throw new  ALOCRuntimeException(ALOCRuntimeException.EC_SEARCH_INVALID_DATE_RANGE);
			}
		}
		if(searchCriteria.getSearchPaymentDetails()!=null && searchCriteria.getSearchPaymentDetails().getPaymentFromDate()!=null&& searchCriteria.getSearchPaymentDetails().getPaymentToDate()!=null){
			if(searchCriteria.getSearchPaymentDetails().getPaymentFromDate().compareTo(searchCriteria.getSearchPaymentDetails().getPaymentToDate())>ALOCConstants.BASE_VALUE){
			   throw new  ALOCRuntimeException(ALOCRuntimeException.EC_SEARCH_INVALID_DATE_RANGE);
			}
		}
	}
	
	/**
	 * Method to clear empty instrument purpose from List
	 * @param searchCriteria
	 */
	private static void clearInstrPurpose(Search searchCriteria) {
		if(searchCriteria.getSearchReqDetails().getInstrPurposeTypes().size() > ALOCConstants.MIN_VALUE){
			for(Iterator<String> instrPItr = searchCriteria.getSearchReqDetails().getInstrPurposeTypes().listIterator(); instrPItr.hasNext(); ) {
				String element = instrPItr.next();
				if(StringUtils.isBlank(element)) {
					instrPItr.remove();
				}
			}
		}
	}
	/**
	 * method to set the glance details in session
	 * @param results
	 * @param sessionValues
	 * @return
	 */
	public static void setGlanceDetails(Inbox results,Map<String, Object> sessionValues){
		GlanceDetails glanceDetails;
		glanceDetails=results.getGlanceDetails();
		if(glanceDetails==null){
			glanceDetails=(GlanceDetails) sessionValues.get(ALOCConstants.GLANCE_DETAILS);
			results.setGlanceDetails(glanceDetails);
		}else{
			sessionValues.put(ALOCConstants.GLANCE_DETAILS, glanceDetails);
		}
	}

	/**
	 * method to set the Dashboard Tab Count in session
	 * @param results
	 * @param sessionValues
	 * @return
	 */
	public static void setDashboardTabCount(Inbox results,Map<String, Object> sessionValues){
		DashBoardTabsCount dashBoardTabsCount;
		dashBoardTabsCount = results.getDashBoardTabsCount();
		if(dashBoardTabsCount == null){
			dashBoardTabsCount = (DashBoardTabsCount) sessionValues.get(ALOCConstants.DASHBOARD_TABS_COUNT);
			results.setDashBoardTabsCount(dashBoardTabsCount);
		}else{
			sessionValues.put(ALOCConstants.DASHBOARD_TABS_COUNT, dashBoardTabsCount);
		}
	}

	/**
	 * method to set message header opcode in session
	 * @param results
	 * @param sessionValues
	 * @return
	 */
	public static void setHeaderOpcode(Inbox results,Map<String, Object> sessionValues){
		MsgHeader msgHeader;
		msgHeader=results.getMsgHeader();

		if(msgHeader == null){
			msgHeader=(MsgHeader)sessionValues.get(ALOCConstants.DASHBOARD_HEADEROPCODE);
			results.setMsgHeader(msgHeader);
		}else{
			sessionValues.put(ALOCConstants.DASHBOARD_HEADEROPCODE, msgHeader);
		}
	}


	/**
	 * method to check if user has access to Financial Business
	 * @param userSpecificSitesList
	 * @return
	 */
	public static boolean isFinancialBusiness(List<UserSites> userSpecificSitesList){
		if (userSpecificSitesList != null && !userSpecificSitesList.isEmpty()) {
			for (UserSites eachUserSite : userSpecificSitesList) {
				if (eachUserSite.getSiteType() != null
						&& eachUserSite.getSiteType().equals(ALOCConstants.FINANCIAL_BUSINESS)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * method to check if user has access to Industrial Business
	 * @param userSpecificSitesList
	 * @return
	 */
	public static boolean isIndustrialBusiness(List<UserSites> userSpecificSitesList){
		if (userSpecificSitesList != null && !userSpecificSitesList.isEmpty()) {
			for (UserSites eachUserSite : userSpecificSitesList) {
				if (eachUserSite.getSiteType() != null
						&& eachUserSite.getSiteType().equals(ALOCConstants.INDUSTRIAL_BUSINESS)) {
					return true;
				}
			}
		}
		return false;
	}
	/**
	 * method to set the Search Dashboard Tab Count in session
	 * @param searchResult
	 * @param sessionValues
	 * @param dashboardViewType
	 * @return
	 */
	public static void setSearchTabCount(Inbox searchResult,DashBoardTabsCount dashBoardTabsCount, DashboardViewType dashboardViewType){
		if(searchResult.getDashBoardTabsCount() == null){
			searchResult.setDashBoardTabsCount(new DashBoardTabsCount());
		}
		searchResult.getDashBoardTabsCount().setMyTransCount(dashBoardTabsCount.getMyTransCount());
		searchResult.getDashBoardTabsCount().setAllRequestsCount(dashBoardTabsCount.getAllRequestsCount());
		searchResult.getDashBoardTabsCount().setDraftsCount(dashBoardTabsCount.getDraftsCount());
		searchResult.getDashBoardTabsCount().setModelsCount(dashBoardTabsCount.getModelsCount());
		searchResult.getDashBoardTabsCount().setBundlesCount(dashBoardTabsCount.getBundlesCount());
		searchResult.getDashBoardTabsCount().setTreasBidProcCount(dashBoardTabsCount.getTreasBidProcCount());
		searchResult.getDashBoardTabsCount().setBankBidProcCount(dashBoardTabsCount.getBankBidProcCount());
		searchResult.getDashBoardTabsCount().setBankPendingIssuanceCount(dashBoardTabsCount.getBankPendingIssuanceCount());
		searchResult.getDashBoardTabsCount().setBankHistTransCount(dashBoardTabsCount.getBankHistTransCount());
		searchResult.getDashBoardTabsCount().setBrokerBidProcCount(dashBoardTabsCount.getBrokerBidProcCount());
		searchResult.getDashBoardTabsCount().setBrokerPendingIssuanceCount(dashBoardTabsCount.getBrokerPendingIssuanceCount());
		searchResult.getDashBoardTabsCount().setBrokerHistTransCount(dashBoardTabsCount.getBrokerHistTransCount());
		switch (dashboardViewType) {
		case MYTRANSACTIONS:
			searchResult.getDashBoardTabsCount().setMyTransCount(new BigInteger(String.valueOf(searchResult.getMyTransactions().getDashBoards().size())));
			break;
		case ALLREQUESTS:
			searchResult.getDashBoardTabsCount().setAllRequestsCount(new BigInteger(String.valueOf(searchResult.getAllRequests().getDashBoards().size())));
			break;
		case DRAFTS:
			searchResult.getDashBoardTabsCount().setDraftsCount(new BigInteger(String.valueOf(searchResult.getDrafts().getDashBoards().size())));
			break;
		case MODEL:
			searchResult.getDashBoardTabsCount().setModelsCount(new BigInteger(String.valueOf(searchResult.getModels().getRequestDetails().size())));
			break;
		case BUNDLES:
			searchResult.getDashBoardTabsCount().setBundlesCount(new BigInteger(String.valueOf(searchResult.getBundle().getRequestDetails().size())));
			break;
		case TREASURYBIDPROCESS:
			searchResult.getDashBoardTabsCount().setTreasBidProcCount(new BigInteger(String.valueOf(searchResult.getTreasuryBidProcess().getBidProcess().size())));
			break;
		case BANKBIDPROCESS:
			searchResult.getDashBoardTabsCount().setBankBidProcCount(new BigInteger(String.valueOf(searchResult.getBankBidProcess().getBidProcess().size())));
			break;
		case TREASURYBANKPENDINGINCE:
			searchResult.getDashBoardTabsCount().setBankPendingIssuanceCount(new BigInteger(String.valueOf(searchResult.getPendingIssuance().getDashBoards().size())));
			break;
		case TREASURYBANKHIST:
			searchResult.getDashBoardTabsCount().setBankHistTransCount(new BigInteger(String.valueOf(searchResult.getHistroricalTransactions().getDashBoards().size())));
			break;
		case TREASURYBROKERBIDPROCESS:
			searchResult.getDashBoardTabsCount().setBrokerBidProcCount(new BigInteger(String.valueOf(searchResult.getBankBidProcess().getBidProcess().size())));
			break;
		case TREASURYBROKERPENDINGINCE:
			searchResult.getDashBoardTabsCount().setBrokerPendingIssuanceCount(new BigInteger(String.valueOf(searchResult.getPendingIssuance().getDashBoards().size())));
			break;
		case TREASURYBROKERHIST:
			searchResult.getDashBoardTabsCount().setBrokerHistTransCount(new BigInteger(String.valueOf(searchResult.getHistroricalTransactions().getDashBoards().size())));
			break;
		}
	}

	/**
	 * Method to prepare Json Object from IBS Message Details from MDM.
	 * @param ibsMessageDetails
	 * @return
	 */
	public static JsonArray prepareBUCADNJsonObject(IBSMessageDetails ibsMessageDetails, JsonArray jsonArray) {
		JsonObject obj = new JsonObject();
		obj.addProperty(ALOCConstants.IBSMESSAGE, ibsMessageDetails.getIBSMessage());
		if(ibsMessageDetails.getIBSMessageId() != null){
			obj.addProperty(ALOCConstants.IBSMESSAGEID, ibsMessageDetails.getIBSMessageId() );
		}else{
			obj.addProperty(ALOCConstants.IBSMESSAGEID, ALOCConstants.EMPTY_STRING);
		}
		if(ibsMessageDetails.getContactPersonDetails() != null){
			if(StringUtils.isBlank(ibsMessageDetails.getContactPersonDetails().getLastName()) && StringUtils.isBlank(ibsMessageDetails.getContactPersonDetails().getFirstName())){
				obj.addProperty(ALOCConstants.CONTACT, (String) ALOCConstants.HYPEN);
			}else{
				obj.addProperty(ALOCConstants.CONTACT, ibsMessageDetails.getContactPersonDetails().getLastName() + ALOCConstants.COMMA_SPACE + ibsMessageDetails.getContactPersonDetails().getFirstName());
			}
			if(StringUtils.isBlank(ibsMessageDetails.getContactPersonDetails().getPhone())){
				obj.addProperty(ALOCConstants.PHONE, (String) ALOCConstants.HYPEN);
			}else{
				obj.addProperty(ALOCConstants.PHONE, ibsMessageDetails.getContactPersonDetails().getPhone());
			}
		}else{
			obj.addProperty(ALOCConstants.CONTACT, ALOCConstants.EMPTY_STRING);
			obj.addProperty(ALOCConstants.PHONE, ALOCConstants.EMPTY_STRING);
		}
		jsonArray.add(obj);
		return jsonArray;
	}

	/**
	 * Method to prepare Json Object from Business Unit Code from MDM.
	 * @param buCode
	 * @param jsonArray
	 * @return
	 */
	public static JsonArray prepareBlockedBUCJsonObject(BusinessUnitCode buCode, JsonArray jsonArray) {
		JsonObject obj = new JsonObject();
		obj.addProperty(ALOCConstants.BLOCKEDBUCNAME, buCode.getBlockedByLastNm() + ALOCConstants.COMMA_SPACE + buCode.getBlockedByFirstNm());
		obj.addProperty(ALOCConstants.BLOCKEDBUCPHONE, buCode.getBlockedByPhone());
		jsonArray.add(obj);
		return jsonArray;
	}

	/**
	 * Validation for Pole name Already Exists or not
	 * @param poleName
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static boolean validatePoleNameExists(String poleName){
		final Map<Integer, PoleNameManagement> poleNameManagements  = (Map<Integer, PoleNameManagement>) ServletActionContext.getRequest().getSession().getAttribute(ALOCConstants.POLENAMES);
		HttpServletRequest request = ServletActionContext.getRequest();
		String poleId = request.getParameter(ALOCConstants.POLENAMEID);
		if(poleName != null && poleName.length() > ALOCConstants.BASE_VALUE)
		{
			if(poleNameManagements != null && poleNameManagements.size() > ALOCConstants.BASE_VALUE){
				for(Integer curPoleId : poleNameManagements.keySet()){
					PoleNameManagement  tempPoleNameManagement = poleNameManagements.get(curPoleId);
					if(poleName.equals(tempPoleNameManagement.getPoleName())){
						if(poleId != null && !poleId.equalsIgnoreCase(ALOCConstants.EMPTY_STRING)){
							if((Integer.valueOf(poleId)).equals(tempPoleNameManagement.getPoleId())){
								return true;
							}
							else
							{
								return false;
							}
						}
						else
						{
							return false;
						}
					}}}}
		return true;
	}

	/**
	 * method to create the auditLog  search criteria
	 * @return
	 * @throws ParseException 
	 * @throws HWFServiceException 
	 */
	public static RequestDetails auditLogSearchCriteria(String fromDate,String toDate,String searchCriteriaType,String searchCriteriaText) throws ParseException {
		RequestDetails requestDetails=new RequestDetails();
		RequestDetails requestDetail = ALOCContext.getActiveRequest().getModel();
		AuditSearch auditSearch=new AuditSearch();

		ActionTakenBy actionTakenBy=new ActionTakenBy();
		List<String> attributeList=new ArrayList<String>();

		DateFormat formatter =new SimpleDateFormat(ALOCConstants.PAYMENT_DATEPATTERN);
		if(StringUtils.isNotEmpty(fromDate)){
			Calendar fromcal=Calendar.getInstance();
			fromcal.setTime((Date)formatter.parse(fromDate));
			auditSearch.setFromDate(fromcal);
		}
		if(StringUtils.isNotEmpty(toDate)){
			Calendar tocal=Calendar.getInstance();
			tocal.setTime((Date)formatter.parse(toDate));
			auditSearch.setToDate(tocal);
		}  
		if(StringUtils.isNotEmpty(searchCriteriaText)){
			actionTakenBy.setSsoId(searchCriteriaText);
		}  
		if(StringUtils.isNotEmpty(toDate) && StringUtils.isNotEmpty(fromDate)){
			if(auditSearch.getFromDate().compareTo(auditSearch.getToDate())>ALOCConstants.BASE_VALUE){
				throw new  ALOCRuntimeException(ALOCRuntimeException.EC_SEARCH_INVALID_DATE_RANGE);
			}
		}
		if(!searchCriteriaType.equals(ALOCConstants.MONE)){
			attributeList.add(searchCriteriaType);   
		}
		else{
			attributeList=requestDetail.getDrawDownValues().getAttributeChangeds();
		}
		auditSearch.setAttributeChangeds(attributeList);   
		auditSearch.setActionTakenBy(actionTakenBy);
		requestDetails.setAuditSearch(auditSearch);
		requestDetails.setRequestId(requestDetail.getRequestId());
		return requestDetails;

	}

	/**
	 * method to create the actionLog  search criteria
	 * @return
	 * @throws ParseException 
	 * @throws HWFServiceException 
	 */
	public static RequestDetails actionLogSearchCriteria(String fromDate,String toDate,String searchCriteriaType,String searchCriteriaText) throws ParseException {
		RequestDetails requestDetails=new RequestDetails();
		RequestDetails requestDetail = ALOCContext.getActiveRequest().getModel();
		ActionSearch actionSearch=new ActionSearch();
		com.ge.aloc.model.ActionSearch.ActionTakenBy actionTakenBy=new  com.ge.aloc.model.ActionSearch.ActionTakenBy();
		List<String> actionList=new ArrayList<String>();
		DateFormat formatter =new SimpleDateFormat(ALOCConstants.PAYMENT_DATEPATTERN);
		if(StringUtils.isNotEmpty(fromDate)){
			Calendar fromcal=Calendar.getInstance();
			fromcal.setTime((Date)formatter.parse(fromDate));
			actionSearch.setFromDate(fromcal);
		}
		if(StringUtils.isNotEmpty(toDate)){
			Calendar tocal=Calendar.getInstance();
			tocal.setTime((Date)formatter.parse(toDate));
			actionSearch.setToDate(tocal);
		}  
		if(StringUtils.isNotEmpty(searchCriteriaText)){
			actionTakenBy.setSsoId(searchCriteriaText);
		}
		if(StringUtils.isNotEmpty(toDate) && StringUtils.isNotEmpty(fromDate)){
			if(actionSearch.getFromDate().compareTo(actionSearch.getToDate())>ALOCConstants.BASE_VALUE){
				throw new  ALOCRuntimeException(ALOCRuntimeException.EC_SEARCH_INVALID_DATE_RANGE);
			}
		}
		if(!searchCriteriaType.equals(ALOCConstants.MONE)){
			actionList.add(searchCriteriaType);

		}
		else{
			actionList=requestDetail.getActionDrawDownValues().getActions();
		}
		actionSearch.setActions(actionList);
		actionSearch.setActionTakenBy(actionTakenBy);
		requestDetails.setActionSearch(actionSearch);
		requestDetails.setRequestId(requestDetail.getRequestId());
		return requestDetails;
	}

	/**
	 * Validation for ADN of Block BUC
	 * @param blockBUCSelectedVal
	 * @param adn
	 * @return
	 */
	public static boolean validateSelectedADN(String blockBUCSelectedVal,String adn){
		if(com.hydus.hwf.util.StringUtils.isNotBlank(blockBUCSelectedVal))
		{
			if(blockBUCSelectedVal.equals(ALOCConstants.BLOCKBUCADN))
			{
				if(com.hydus.hwf.util.StringUtils.isBlank(adn)) {
					return false; }
				else {
					return true; }
			}
			else {
				return true; }
		}
		else {
			return true; }
	}
	
	/**
	 * method to populate the pricing details for selected request in Bid reply stage
	 * @param requestDetails
	 * @return requestDetails
	 */
	public static RequestDetails setPricingDetails(RequestDetails requestDetails) {
		if(requestDetails.getAdditionalInstrumentDetails() != null && (requestDetails.getAdditionalInstrumentDetails().isRequestForProposal() != null && requestDetails.getAdditionalInstrumentDetails().isRequestForProposal()))
		{
			if(requestDetails.getPreAgreedPricingDetails() != null && requestDetails.getPreAgreedPricingDetails().getOneTimeFeesDetails() != null)
			{
				if(requestDetails.getPreAgreedPricingDetails().getOneTimeFeesDetails().getAcceptPricingDetailsFlag() != null)
				{
					requestDetails.setPricingDetails(null);
					if(requestDetails.getPreAgreedPricingDetails().getOneTimeFeesDetails().getAcceptPricingDetailsFlag().equals(ALOCConstants.PRICINGACCEPT))
					{
						requestDetails.getPreAgreedPricingDetails().getOneTimeFeesDetails().setAcceptPricingDetailsFlag(ALOCConstants.PRICING_ACCEPT_FLAG);
					}
					else
					{
						OneTimeFeesDetails oneTimeFeesDetails = requestDetails.getPreAgreedPricingDetails().getOneTimeFeesDetails();
						requestDetails.setPreAgreedPricingDetails(null);
						PreAgreedPricingDetails preAgreedPricingDetails = new PreAgreedPricingDetails();
						OneTimeFeesDetails newOneTimeFeesDetails = new OneTimeFeesDetails();
						newOneTimeFeesDetails.setAcceptPricingDetailsFlag(ALOCConstants.PRICING_REJECT_FLAG);
						newOneTimeFeesDetails.setReasonForRejection(oneTimeFeesDetails.getReasonForRejection());
						preAgreedPricingDetails.setOneTimeFeesDetails(newOneTimeFeesDetails);
						requestDetails.setPreAgreedPricingDetails(preAgreedPricingDetails);
						setOpCode(requestDetails, ActionType.OPT_OUT);
						requestDetails.setBidOrOptFlag(ALOCConstants.BIDREPLY_OPTOUT);
					}
				}
			}
		}
		else
		{
			requestDetails.setPreAgreedPricingDetails(null);
		}
		if(StringUtils.isNotBlank(requestDetails.getBidOrOptFlag()) && requestDetails.getBidOrOptFlag().equals(ALOCConstants.BIDREPLY_OPTOUT))
		{
			requestDetails.setPricingDetails(null);
			requestDetails.setPreAgreedPricingDetails(null);
		}
		return requestDetails;
	}	


	/**
	 * method to delete autoIncDec List values that are having opcode delete 
	 * @param requestDetails
	 * @return requestDetails
	 */
	public static RequestDetails deleteAutoInc(RequestDetails requestDetails) {
		List<AutoIncDec> autoIncDecList = requestDetails.getInstrumentDetails().getAutoIncDecs();
		List<AutoIncDec> modifiedIncDecList = new ArrayList<AutoIncDec>();
		
		if(requestDetails.getInstrumentDetails()!=null){
			if(requestDetails.getInstrumentDetails().getAutoIncDecFlag()!=null && requestDetails.getInstrumentDetails().getAutoIncDecFlag().equalsIgnoreCase(ALOCConstants.TRUE)){
				for(AutoIncDec autoIncDec : autoIncDecList){
					if(!(autoIncDec.getOpCode().equalsIgnoreCase(ALOCConstants.DELETE) && StringUtils.isEmpty(autoIncDec.getAutoIncDecId())))
					{
						if(!(autoIncDec.getOpCode().equalsIgnoreCase(ALOCConstants.INSERT) && autoIncDec.getAutoIncAmt() == null && autoIncDec.getAutoIncDt() == null && autoIncDec.getAutoIncIndicator() == null)){
							modifiedIncDecList.add(autoIncDec);
						}
					}
				}
			}
			else if(requestDetails.getInstrumentDetails().getAutoIncDecFlag()!=null && requestDetails.getInstrumentDetails().getAutoIncDecFlag().equalsIgnoreCase(ALOCConstants.FALSE)){
				for(AutoIncDec autoIncDec : autoIncDecList){
					if(autoIncDec.getOpCode().equalsIgnoreCase(ALOCConstants.UPDATE)){
						autoIncDec.setOpCode(ALOCConstants.DELETE);
						modifiedIncDecList.add(autoIncDec);	
					}else if(autoIncDec.getOpCode().equalsIgnoreCase(ALOCConstants.DELETE)){
						modifiedIncDecList.add(autoIncDec);	
					}
				}
			}
		requestDetails.getInstrumentDetails().setAutoIncDecs(modifiedIncDecList);
	}
		return requestDetails;
	}


	/**
	 * method to clone the BG/SBLC details to  RequestDetails
	 * @param requestDetails
	 * @return requestDetails
	 */
	public static RequestDetails bgSblcClone(RequestDetails requestDetails,RequestDetails cloneRequestDetails, boolean isCloned) {			
		if(requestDetails.getTransactionParties()!= null){
			cloneRequestDetails.setTransactionParties(requestDetails.getTransactionParties());
			cloneRequestDetails.getTransactionParties().setRequiresEdits(null);
			cloneRequestDetails.getTransactionParties().getTpApplicantDetails().setRequiresEdits(null);
			cloneRequestDetails.getTransactionParties().getTpApplicantDetails().setIBSMsgId(null);
			if(cloneRequestDetails.getTransactionParties().getTriPartyApplicant() !=null){
			cloneRequestDetails.getTransactionParties().getTriPartyApplicant().setRequiresEdits(null);
			}
			cloneRequestDetails.getTransactionParties().getCustomer().getAddressDtls().setRequiresEdits(null);
			if(StringUtils.isNotBlank(cloneRequestDetails.getTransactionParties().getSendBackNotes())){
				cloneRequestDetails.getTransactionParties().setSendBackNotes(null);	
			}
		}
		if(requestDetails.getInstrumentDetails()!= null){
			cloneRequestDetails.setInstrumentDetails(requestDetails.getInstrumentDetails());
			if(requestDetails.getInstrumentDetails().getAutoIncDecs()!=null){
				for(AutoIncDec AutoIncDec:requestDetails.getInstrumentDetails().getAutoIncDecs()){
					AutoIncDec.setAutoIncDecId(null);
				}
			}
			if(isCloned){
			cloneRequestDetails.getInstrumentDetails().setInstrumentAmt(null);
			cloneRequestDetails.getInstrumentDetails().setUSDEquivalent(null);
			cloneRequestDetails.getInstrumentDetails().setPercentValueOfBid(null);
			cloneRequestDetails.getInstrumentDetails().setIssueDt(null);
			cloneRequestDetails.getInstrumentDetails().setExpiryDt(null);
			}
			cloneRequestDetails.getInstrumentDetails().setRequiresEdits(null);
			if(StringUtils.isNotBlank(cloneRequestDetails.getInstrumentDetails().getSendBackNotes())){
				cloneRequestDetails.getInstrumentDetails().setSendBackNotes(null);	
			}
		}
		if(requestDetails.getProjDescription()!= null){
			cloneRequestDetails.setProjDescription(requestDetails.getProjDescription());
			if(isCloned){
			cloneRequestDetails.getProjDescription().setBidContractAmt(null);
			cloneRequestDetails.getProjDescription().setBidUSDEquivalent(null);
			}
			cloneRequestDetails.getProjDescription().setRequiresEdits(null);
			if(StringUtils.isNotBlank(cloneRequestDetails.getProjDescription().getSendBackNotes())){
				cloneRequestDetails.getProjDescription().setSendBackNotes(null);	
			}
		}	
		if(requestDetails.getInstrumentRisk()!= null){
			cloneRequestDetails.setInstrumentRisk(requestDetails.getInstrumentRisk());
			cloneRequestDetails.getInstrumentRisk().setRequiresEdits(null);
			if(StringUtils.isNotBlank(cloneRequestDetails.getInstrumentRisk().getSendBackNotes())){
				cloneRequestDetails.getInstrumentRisk().setSendBackNotes(null);	
			}
		}
		if(requestDetails.getInstrReporting()!= null){
			cloneRequestDetails.setInstrReporting(requestDetails.getInstrReporting());
			cloneRequestDetails.getInstrReporting().setRequiresEdits(null);
			if(StringUtils.isNotBlank(cloneRequestDetails.getInstrReporting().getSendBackNotes())){
				cloneRequestDetails.getInstrReporting().setSendBackNotes(null);	
			}
		}
		if(requestDetails.getDeliveryInstructions()!= null){
			BigInteger addressId=null;
			if(cloneRequestDetails.getDeliveryInstructions()!=null && cloneRequestDetails.getDeliveryInstructions().getAddressId()!=null){
				addressId=cloneRequestDetails.getDeliveryInstructions().getAddressId();
			}
			cloneRequestDetails.setDeliveryInstructions(requestDetails.getDeliveryInstructions());
			cloneRequestDetails.getDeliveryInstructions().setRequiresEdits(null);
			if(StringUtils.isNotBlank(cloneRequestDetails.getDeliveryInstructions().getSendBackNotes())){
				cloneRequestDetails.getDeliveryInstructions().setSendBackNotes(null);
			}
			if(addressId!=null){
				cloneRequestDetails.getDeliveryInstructions().setAddressId(addressId);
			}
		}
		if(requestDetails.getBuDelegation()!= null){
			cloneRequestDetails.setBuDelegation(requestDetails.getBuDelegation());
		}
		if(requestDetails.getInstrumentType().equalsIgnoreCase(STANDBY_LETTER_OF_CREDIT) && requestDetails.getSBLC() != null){
			cloneRequestDetails.setSBLC(requestDetails.getSBLC());	
			cloneRequestDetails.getSBLC().setRequiresEdits(null);
			if(StringUtils.isNotBlank(cloneRequestDetails.getSBLC().getSendBackNotes())){
				cloneRequestDetails.getSBLC().setSendBackNotes(null);
			}
		}
		return cloneRequestDetails;
	}
	/**
	 * method to clone the Surety Bond details to  RequestDetails 
	 * @param requestDetails
	 * @return requestDetails
	 */
	public static RequestDetails suretyBondClone(RequestDetails requestDetails,RequestDetails cloneRequestDetails,boolean isCloned) {
		if(requestDetails.getBondDetails()!= null){
			cloneRequestDetails.setBondDetails(requestDetails.getBondDetails());
			cloneRequestDetails.getBondDetails().setRequiresEdits(null);
			if(StringUtils.isNotBlank(cloneRequestDetails.getBondDetails().getSendBackNotes())){
				cloneRequestDetails.getBondDetails().setSendBackNotes(null);
			}
		}
		if(requestDetails.getPrincipal()!= null){
			cloneRequestDetails.setPrincipal(requestDetails.getPrincipal());
			cloneRequestDetails.getPrincipal().setRequiresEdits(null);
			cloneRequestDetails.getPrincipal().setIBSMsgId(null);
			if(StringUtils.isNotBlank(cloneRequestDetails.getPrincipal().getSendBackNotes())){
				cloneRequestDetails.getPrincipal().setSendBackNotes(null);
			}
		}
		if(requestDetails.getObligee()!= null){
			cloneRequestDetails.setObligee(requestDetails.getObligee());
			cloneRequestDetails.getObligee().setRequiresEdits(null);
			if(StringUtils.isNotBlank(cloneRequestDetails.getObligee().getSendBackNotes())){
				cloneRequestDetails.getObligee().setSendBackNotes(null);
			}
		}
		if(requestDetails.getBondReqDtls()!= null){
			cloneRequestDetails.setBondReqDtls(requestDetails.getBondReqDtls());
			cloneRequestDetails.getBondReqDtls().setRequiresEdits(null);
			if(StringUtils.isNotBlank(cloneRequestDetails.getBondReqDtls().getSendBackNotes())){
				cloneRequestDetails.getBondReqDtls().setSendBackNotes(null);
			}
		}
		if(requestDetails.getAddressDtls()!= null){
			cloneRequestDetails.setAddressDtls(requestDetails.getAddressDtls());
			cloneRequestDetails.getAddressDtls().setRequiresEdits(null);
			if(cloneRequestDetails.getBondReqDtls()!=null){
				cloneRequestDetails = setAddressDetails(cloneRequestDetails);
			}
			if(StringUtils.isNotBlank(cloneRequestDetails.getAddressDtls().getSendBackNotes())){
				cloneRequestDetails.getAddressDtls().setSendBackNotes(null);
			}
		}
		if(requestDetails.getDeliveryInstructions()!= null){
			BigInteger addressId=null;
			if(cloneRequestDetails.getDeliveryInstructions()!=null && cloneRequestDetails.getDeliveryInstructions().getAddressId()!=null){
				addressId=cloneRequestDetails.getDeliveryInstructions().getAddressId();
			}
			cloneRequestDetails.setDeliveryInstructions(requestDetails.getDeliveryInstructions());
			cloneRequestDetails.getDeliveryInstructions().setRequiresEdits(null);
			if(StringUtils.isNotBlank(cloneRequestDetails.getDeliveryInstructions().getSendBackNotes())){
				cloneRequestDetails.getDeliveryInstructions().setSendBackNotes(null);
			}
			if(addressId!=null){
				cloneRequestDetails.getDeliveryInstructions().setAddressId(addressId);
			}
		}
		if(requestDetails.getBondInfo()!= null){
			cloneRequestDetails.setBondInfo(requestDetails.getBondInfo());
			cloneRequestDetails.getBondInfo().setRequiresEdits(null);
			if(isCloned){
			if(requestDetails.getBondDetails()!=null && requestDetails.getBondDetails().getBondTypeId()!=null){
				BigInteger bondTypeId = requestDetails.getBondDetails().getBondTypeId();
				if(bondTypeId.equals(BigInteger.valueOf(ALOCConstants.BIDBOND_ID)) || bondTypeId.equals(BigInteger.valueOf(ALOCConstants.CUST_BOND_ID)) || 
						bondTypeId.equals(BigInteger.valueOf(ALOCConstants.LICENCE_BOND_ID))){
					cloneRequestDetails.getBondInfo().setBondAmount(null);
					cloneRequestDetails.getBondInfo().setUSEquivalentBondAmt(null);
				}else if(bondTypeId.equals(BigInteger.valueOf(ALOCConstants.CONTRACTBOND_ID))){
					cloneRequestDetails.getBondInfo().setContractAmt(null);
					cloneRequestDetails.getBondInfo().setUSDContractAmt(null);
				}else if(bondTypeId.equals(BigInteger.valueOf(ALOCConstants.COURT_BOND_ID))){
					cloneRequestDetails.getBondInfo().setCourtBondAmt(null);
					cloneRequestDetails.getBondInfo().setUSDCourtBondAmt(null);
					
				}
			}
			cloneRequestDetails.getBondInfo().setExpirationDt(null);
			}
			if(StringUtils.isNotBlank(cloneRequestDetails.getBondInfo().getSendBackNotes())){
				cloneRequestDetails.getBondInfo().setSendBackNotes(null);
			}
		}
		if(requestDetails.getBuDelegation()!= null){
			cloneRequestDetails.setBuDelegation(requestDetails.getBuDelegation());
		}
		return cloneRequestDetails;
	}
	/**
	 * method to clone the DLOC details to  RequestDetails 
	 * @param requestDetails
	 * @return requestDetails
	 */
	public static RequestDetails dlocClone(RequestDetails requestDetails,RequestDetails cloneRequestDetails,boolean isCloned) {
		if(requestDetails.getBuContactPerson()!= null){
			cloneRequestDetails.setBuContactPerson(requestDetails.getBuContactPerson());
			cloneRequestDetails.getBuContactPerson().setRequiresEdits(null);
			if(StringUtils.isNotBlank(cloneRequestDetails.getBuContactPerson().getSendBackNotes())){
				cloneRequestDetails.getBuContactPerson().setSendBackNotes(null);
			}
		}
		if(requestDetails.getIssuingBankDetails()!= null){
			cloneRequestDetails.setIssuingBankDetails(requestDetails.getIssuingBankDetails());
			cloneRequestDetails.getIssuingBankDetails().setRequiresEdits(null);
			if(StringUtils.isNotBlank(cloneRequestDetails.getIssuingBankDetails().getSendBackNotes())){
				cloneRequestDetails.getIssuingBankDetails().setSendBackNotes(null);
			}
		}
		if(requestDetails.getApplicantDetails()!= null){
			cloneRequestDetails.setApplicantDetails(requestDetails.getApplicantDetails());
			cloneRequestDetails.getApplicantDetails().setRequiresEdits(null);
			if(StringUtils.isNotBlank(cloneRequestDetails.getApplicantDetails().getSendBackNotes())){
				cloneRequestDetails.getApplicantDetails().setSendBackNotes(null);
			}
		}
		if(requestDetails.getBeneficiaryDetails()!= null){
			cloneRequestDetails.setBeneficiaryDetails(requestDetails.getBeneficiaryDetails());
			cloneRequestDetails.getBeneficiaryDetails().setRequiresEdits(null);
			if(StringUtils.isNotBlank(cloneRequestDetails.getBeneficiaryDetails().getSendBackNotes())){
				cloneRequestDetails.getBeneficiaryDetails().setSendBackNotes(null);
			}
		}
		if(requestDetails.getTransactionDetails()!= null){
			cloneRequestDetails.setTransactionDetails(requestDetails.getTransactionDetails());
			cloneRequestDetails.getTransactionDetails().setRequiresEdits(null);
			if(isCloned){
			cloneRequestDetails.getTransactionDetails().setDocLCAmt(null);
			cloneRequestDetails.getTransactionDetails().setUSDEquivalent(null);
			}
			if(StringUtils.isNotBlank(cloneRequestDetails.getTransactionDetails().getSendBackNotes())){
				cloneRequestDetails.getTransactionDetails().setSendBackNotes(null);
			}
		}
		if(requestDetails.getPaymentScheduleDetails()!= null){
			cloneRequestDetails.setPaymentScheduleDetails(requestDetails.getPaymentScheduleDetails());
				for(AdditionalPayments additionalPayment:requestDetails.getPaymentScheduleDetails().getAdditionalPayments()){
					additionalPayment.setEstPayId(null);
				}
			cloneRequestDetails.getPaymentScheduleDetails().setRequiresEdits(null);
			if(StringUtils.isNotBlank(cloneRequestDetails.getPaymentScheduleDetails().getSendBackNotes())){
				cloneRequestDetails.getPaymentScheduleDetails().setSendBackNotes(null);
			}
		}
		return cloneRequestDetails;
	}

	/**
	 * Validation for BUC Block Reason of Block BUC
	 * @param blockBUCSelectedVal
	 * @param buc
	 * @param notes
	 * @return
	 */
	public static boolean validateSelectedBUCBlockedReason(String blockBUCSelectedVal,String buc,String notes){
		if(com.hydus.hwf.util.StringUtils.isNotBlank(blockBUCSelectedVal))
		{
			if(!blockBUCSelectedVal.equals(ALOCConstants.BLOCKBUCADN))
			{
				if(com.hydus.hwf.util.StringUtils.isBlank(notes)) {
					return false; }
				else {
					return true; }
			}
			else {
				return true; }
		}
		else {
			return true; }
	}

	/**
	 * Validation for ADN Block Reason of Block BUC
	 * @param blockBUCSelectedVal
	 * @param adn
	 * @param reasonForBlock
	 * @return
	 */
	public static boolean validateSelectedADNBlockedReason(String blockBUCSelectedVal,String adn,String reasonForBlock){
		if(com.hydus.hwf.util.StringUtils.isNotBlank(blockBUCSelectedVal))
		{
			if(blockBUCSelectedVal.equals(ALOCConstants.BLOCKBUCADN))
			{
				if(com.hydus.hwf.util.StringUtils.isBlank(reasonForBlock)) {
					return false; }
				else {
					return true; }
			}
			else {
				return true; }
		}
		else {
			return true; }
	}

	/**
	 * Validation for fee structure amount value
	 * @param bidOrOptFlag
	 * @param feeStructurId
	 * @param feeStructureAmount
	 * @return
	 */
	public static boolean validateFeeStructureValue(String bidOrOptFlag,String feeStructurId,BigDecimal feeStructureAmount){
		if(com.hydus.hwf.util.StringUtils.isNotBlank(bidOrOptFlag) && bidOrOptFlag.equals(ALOCConstants.BID_REPLY_FLAG) && feeStructurId != null)
		{
			if(feeStructureAmount != null)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return true;
		}
	}

	/**
	 * Validation for fee structure amount 
	 * @param feeStructureAmount
	 * @param bidOrOptFlag
	 * @return
	 */
	public static boolean validateFeeStructureAmount(
			BigDecimal feeStructureAmount, String bidOrOptFlag) {
		if (com.hydus.hwf.util.StringUtils.isNotBlank(bidOrOptFlag)
				&& bidOrOptFlag.equals(ALOCConstants.BID_REPLY_FLAG)
				&& feeStructureAmount != null) {
			if (isValidDecimalFourteen(feeStructureAmount)) {
				return true;
			} else {
				return false;
			}
		} else {
			return true;
		}
	}
	
	/**
	 * Validation for given Expiration Date
	 * @param expDate
	 * @param bidOrOptFlag
	 * @return
	 */
	public static boolean validateBidExpirationDate(Calendar expDate,String bidOrOptFlag) {
		if (com.hydus.hwf.util.StringUtils.isNotBlank(bidOrOptFlag)
				&& bidOrOptFlag.equals(ALOCConstants.BID_REPLY_FLAG)
				&& expDate != null) {
			Calendar currentDateCal = Calendar.getInstance(TimeZone.getTimeZone(ALOCConstants.BID_TIMEZONE), Locale.US);
		    Date curDateWithoutTime = expDate.getTime();
			Calendar expDateWithoutTimeCal = Calendar.getInstance();
			expDateWithoutTimeCal.setTime(curDateWithoutTime);
			expDateWithoutTimeCal.setTimeZone(TimeZone.getTimeZone(ALOCConstants.BID_TIMEZONE));
			
			currentDateCal.set(Calendar.HOUR, currentDateCal.getActualMinimum(Calendar.HOUR));
			currentDateCal.set(Calendar.HOUR_OF_DAY, currentDateCal.getActualMinimum(Calendar.HOUR_OF_DAY));
			currentDateCal.set(Calendar.MINUTE,      currentDateCal.getActualMinimum(Calendar.MINUTE));
			currentDateCal.set(Calendar.SECOND,      currentDateCal.getActualMinimum(Calendar.SECOND));
			currentDateCal.set(Calendar.MILLISECOND, currentDateCal.getActualMinimum(Calendar.MILLISECOND));
			
			expDateWithoutTimeCal.set(Calendar.HOUR, expDateWithoutTimeCal.getActualMinimum(Calendar.HOUR));
			expDateWithoutTimeCal.set(Calendar.HOUR_OF_DAY, expDateWithoutTimeCal.getActualMinimum(Calendar.HOUR_OF_DAY));
			expDateWithoutTimeCal.set(Calendar.MINUTE,      expDateWithoutTimeCal.getActualMinimum(Calendar.MINUTE));
			expDateWithoutTimeCal.set(Calendar.SECOND,      expDateWithoutTimeCal.getActualMinimum(Calendar.SECOND));
			expDateWithoutTimeCal.set(Calendar.MILLISECOND, expDateWithoutTimeCal.getActualMinimum(Calendar.MILLISECOND));
			if (expDateWithoutTimeCal.compareTo(currentDateCal) >= ALOCConstants.BASE_VALUE) {
				return true;
			} else {
				return false;
			}
		} else {
			return true;
		}
	}
	
	/**
	 * Validation for given Bid reply Expiration Date and time
	 * @param expDate
	 * @param bidOrOptFlag
	 * @param hours
	 * @param minutes
	 * @param period
	 * @return
	 */
	public static boolean validateBidExpirationTime(Calendar expDate,String bidOrOptFlag,String hours,String minutes,String period) {
		if (com.hydus.hwf.util.StringUtils.isNotBlank(bidOrOptFlag)
				&& bidOrOptFlag.equals(ALOCConstants.BID_REPLY_FLAG)
				&& expDate != null) {
				return validateBidMemoExpirationDate(expDate, hours, minutes, period);
		} else {
			return true;
		}
	}


	/**
	 * check validation of expiryDate 
	 * @param expiryDt Calendar
	 * @return
	 */
	public static boolean isEconoExpiryDtMandatory(Calendar expiryDt) {
		if (expiryDt != null) {
			int expiryYear = expiryDt.get(Calendar.YEAR);
			if (expiryYear >= ALOCConstants.MAX_YEAR) {
				return true;
			}
		}
		return false;
	}

	/**
	 * empty check list condition for search
	 * @param apmSearch
	 * @return
	 */
	public static APMSearch formatFHSearch(APMSearch apmSearch){
		if(apmSearch.getPaymentCurrencies()!=null){
			List<String> currencyList=new ArrayList<String>();
			for(String currencies:apmSearch.getPaymentCurrencies()){
				if(StringUtils.isNotEmpty(currencies)){
					currencyList.add(currencies);
				}
				if(currencyList!=null){
					apmSearch.setPaymentCurrencies(currencyList);
				}
			}

		}
		if(apmSearch.getCountryOfIssuences()!=null){
			List<String> countryList=new ArrayList<String>();
			for(String country:apmSearch.getCountryOfIssuences()){
				if(StringUtils.isNotEmpty(country)){
					countryList.add(country);
				}
				if(countryList!=null){
					apmSearch.setCountryOfIssuences(countryList);
				}
			}
		}
		return apmSearch;
	}

	/**
	 * Set Bid Memo Details to request details
	 * @param requestDetails
	 * @param hours
	 * @param minutes
	 * @param period
	 */
	public static void setBidMemoDetails(List<String> rightBankRecords,String hours,String minutes,String period,String AllInValue,String localValue){
		RequestDetailsBO requestDetailsBO = ALOCContext.getActiveRequest();

		if (requestDetailsBO != null) {
			RequestDetails requestDetails = requestDetailsBO.getModel();
			if (requestDetails != null && requestDetails.getWFDetails() != null) {
				if (requestDetails.getWFDetails().getWFStage() != null
						&& (requestDetails.getWFDetails().getWFStage().equals(ALOCConstants.BID_MEMO) || 
								requestDetails.getWFDetails().getWFStage().equals(ALOCConstants.NEW_MEMO) ||
								requestDetails.getWFDetails().getWFStage().equals(ALOCConstants.EVL_REPLY))) {
					if (requestDetails.getBidmemoDetails() != null) {
						Calendar expDateTime = requestDetails
								.getBidmemoDetails().getExpirationDateTime();
						expDateTime = setTimeToCalendar(expDateTime, hours,
								minutes, period);
						requestDetails.getBidmemoDetails()
						.setExpirationDateTime(expDateTime);
					}
					requestDetails = setBankDetails(requestDetails,rightBankRecords);
				}
			}
			if(requestDetails.getPricingDetails()!=null){
				if(requestDetails.getPricingDetails().getAllInCommissionsId()==null){
					requestDetails.getPricingDetails().setAllInCommissionsName(ALOCConstants.EMPTY_STRING);
				}else{
					if(AllInValue!=null){
						requestDetails.getPricingDetails().setAllInCommissionsValue(new BigDecimal(AllInValue));
					}
				}
				if(requestDetails.getPricingDetails().getLocalCommissionsId()==null){
					requestDetails.getPricingDetails().setLocalCommissionsName(ALOCConstants.EMPTY_STRING);
				}else{
					if(localValue!=null){
						requestDetails.getPricingDetails().setLocalCommissionsValue(new BigDecimal(localValue));
					}
				}
			}
		}
	}

	/**
	 * Validation for issuance bank reference number
	 * @return
	 */
	public static boolean validateClosureAttachment(){
		RequestDetailsBO requestDetailsBO = ALOCContext.getActiveRequest();	
		List<AttachmentBO> attachmentBOList = requestDetailsBO.getAttachmentBOList();	
		if (attachmentBOList != null && !attachmentBOList.isEmpty()) {				
			for (AttachmentBO attachmentBO : attachmentBOList) {	
				if((attachmentBO.getModel().getAttachmentPermissions() != null && !attachmentBO.getModel().getAttachmentPermissions().isEmpty()) && (attachmentBO.getModel().getGeFileId() == null)){
					return false;
				}	
				continue;
			}
			return true;
		}
		return true;		

	}

	/**
	 * Validation for CLosure upload Description
	 * @return
	 */
	public static boolean validateClosureUploadDescription(){
		RequestDetailsBO requestDetailsBO = ALOCContext.getActiveRequest();	
		List<AttachmentBO> attachmentBOList = requestDetailsBO.getAttachmentBOList();	
		if (attachmentBOList != null && !attachmentBOList.isEmpty()) {				
			for (AttachmentBO attachmentBO : attachmentBOList) {	
				if(!StringUtils.isNotBlank(attachmentBO.getIssuanceDesc()) && !attachmentBO.getModel().getAttachmentPermissions().isEmpty()){
					for(AttachmentPermission atmtPermissions : attachmentBO.getModel().getAttachmentPermissions()){
						if(StringUtils.isNotBlank(atmtPermissions.getPermissionId()) && StringUtils.isNotBlank(atmtPermissions.getPermissionName())){
							return false;
						}
					}
				}	
				continue;
			}
			return true;
		}
		return true;		

	}

	/**
	 * Validation for Closure Date with instrument type 
	 * @return
	 */
	public static boolean validateClosureDate() {
		RequestDetailsBO requestDetailsBO = ALOCContext.getActiveRequest();
		Calendar expirationDate = null;		
		if (requestDetailsBO.getModel().getInstrumentTypeId().intValue() == InstrumentType.BANK_GUARANTEE.getId()
				|| requestDetailsBO.getModel().getInstrumentTypeId().intValue() == InstrumentType.LOC.getId()
				|| requestDetailsBO.getModel().getInstrumentTypeId().intValue() == InstrumentType.DOCUMENT_LOC.getId()
				|| requestDetailsBO.getModel().getInstrumentTypeId().intValue() == InstrumentType.AMENDMENT.getId()) {
			if (requestDetailsBO.getModel().getInstrumentTypeId().intValue() == InstrumentType.AMENDMENT.getId()) { //validation for closure date based on the instrument type
				if(requestDetailsBO.getModel().getAmendment().getExpiryDate().getRevisedExpiryDate()!= null)
					expirationDate = (Calendar) requestDetailsBO.getModel().getAmendment().getExpiryDate().getRevisedExpiryDate();
			} else {
				if(requestDetailsBO.getModel().getIssuingBankDetails().getUSExpirationDate()!= null)
					expirationDate = (Calendar) requestDetailsBO.getModel().getIssuingBankDetails().getUSExpirationDate();
				if(expirationDate==null){					
					if(requestDetailsBO.getModel().getInstrumentDetails().getExpiryDt()!= null)
						expirationDate = (Calendar) requestDetailsBO.getModel().getInstrumentDetails().getExpiryDt();
					boolean checkDate = isEconoExpiryDtMandatory(expirationDate);							
					if(checkDate)
					{
						if(requestDetailsBO.getModel().getInstrumentDetails().getEconoExpiryDt()!= null)
							expirationDate = requestDetailsBO.getModel().getInstrumentDetails().getEconoExpiryDt();
					}
				}
			}
		} else if (requestDetailsBO.getModel().getInstrumentTypeId().intValue() == InstrumentType.SURETY_BOND.getId()
				|| requestDetailsBO.getModel().getInstrumentTypeId().intValue() == InstrumentType.RIDER.getId()) {
			if( requestDetailsBO.getModel().getInstrumentTypeId().intValue() == InstrumentType.RIDER.getId())
			{
				if(requestDetailsBO.getModel().getRider().getExpiryDate().getRevisedExpiryDate() != null)
					expirationDate = (Calendar) requestDetailsBO.getModel().getRider().getExpiryDate().getRevisedExpiryDate(); 
			}else{
				if(requestDetailsBO.getModel().getBondInfo().getExpirationDt()!= null)
					expirationDate = (Calendar) requestDetailsBO.getModel().getBondInfo().getExpirationDt();
			}
		}
		if (expirationDate == null
				&& requestDetailsBO.getModel().getNewExpDate().compareTo(requestDetailsBO.getModel().getIssuanceDate()) == ALOCConstants.MIN_VALUE) {
			return true;
		} else if ((requestDetailsBO.getModel().getNewExpDate().compareTo(expirationDate) == ALOCConstants.BASE_NEGATIVE_VALUE
				|| requestDetailsBO.getModel().getNewExpDate().compareTo(expirationDate) == ALOCConstants.BASE_VALUE) 
				&& (requestDetailsBO.getModel().getNewExpDate().compareTo(requestDetailsBO.getModel().getIssuanceDate()) == ALOCConstants.MIN_VALUE)) {
			return true;
		} else {
			return false;
		}

	}
	
	/**
	 * Validation for Closure Date with Today Date 
	 * @return
	 */
	public static boolean validateClosureDateByToday() {
		RequestDetailsBO requestDetailsBO = ALOCContext.getActiveRequest();
		if (requestDetailsBO.getModel().getNewExpDate().compareTo(getCurrentDateWithOutTime()) <= ALOCConstants.BASE_VALUE){
			return true;
		} else {
			return false;
		}
	}


	/**
	 * This method is used to set Hours/Minute/Period to Calendar
	 * @param dateString
	 * @return Calendar
	 * @throws ParseException
	 */
	public static Calendar setTimeToCalendar(Calendar expDateTime,String hours,String minutes,String period){
		if(StringUtils.isNotBlank(hours)){
			expDateTime.set(Calendar.HOUR, Integer.parseInt(hours));
		}
		if(StringUtils.isNotBlank(minutes)){
			expDateTime.set(Calendar.MINUTE, Integer.parseInt(minutes));
		}
		if(StringUtils.isNotBlank(hours)){
			if(StringUtils.isNotBlank(period)){
				if(period.equals(ALOCConstants.AM)){
					expDateTime.set(Calendar.AM_PM, ALOCConstants.BASE_VALUE);
				}else if(period.equals(ALOCConstants.PM)){
					expDateTime.set(Calendar.AM_PM, ALOCConstants.MIN_VALUE);
				}
			}
		}
		return expDateTime;
	}

	/**
	 * Set Bid Reply expiration date and time Details to request details
	 * @param requestDetails
	 * @param hours
	 * @param minutes
	 * @param period
	 */
	public static void setBidReplyExpDateDetails(String hours,String minutes,String period,String AllInValue,String localValue, String feeStructureValue){
		RequestDetailsBO requestDetailsBO = ALOCContext.getActiveRequest();

		if(requestDetailsBO!=null){
			RequestDetails requestDetails =  requestDetailsBO.getModel();
			if(requestDetails!=null && requestDetails.getWFDetails()!=null){
				if(requestDetails.getWFDetails().getWFStage()!=null && requestDetails.getWFDetails().getWFStage().equals(ALOCConstants.BID_REPLY)){
					if(requestDetails.getBidReplyDetails()!=null){
						if(requestDetails.getInstrumentTypeId() != null && requestDetails.getInstrumentTypeId().intValue() != InstrumentType.DOCUMENT_LOC.getId())
						{
							Calendar expDateTime = requestDetails.getBidReplyDetails().getBidExpirationDate();
							expDateTime = setTimeToCalendar(expDateTime,hours,minutes,period);
							requestDetails.getBidReplyDetails().setBidExpirationDate(expDateTime);
						}
						else if(requestDetails.getInstrumentTypeId() != null && requestDetails.getInstrumentTypeId().intValue() == InstrumentType.DOCUMENT_LOC.getId())
						{
							Calendar expDateTime = requestDetails.getIndicativePricingCompletedDetails().getPricingExpirationDateTime();
							expDateTime = setTimeToCalendar(expDateTime,hours,minutes,period);
							requestDetails.getIndicativePricingCompletedDetails().setPricingExpirationDateTime(expDateTime);
						}
					}
					
					if(requestDetails.getPricingDetails()!=null){
						if(requestDetails.getPricingDetails().getAllInCommissionsId()==null){
							requestDetails.getPricingDetails().setAllInCommissionsName(ALOCConstants.EMPTY_STRING);
						}else{
							if(AllInValue!=null){
								requestDetails.getPricingDetails().setAllInCommissionsValue(new BigDecimal(AllInValue));
							}
						}
						if(requestDetails.getPricingDetails().getLocalCommissionsId()==null){
							requestDetails.getPricingDetails().setLocalCommissionsName(ALOCConstants.EMPTY_STRING);
						}else{
							if(localValue!=null){
								requestDetails.getPricingDetails().setLocalCommissionsValue(new BigDecimal(localValue));
							}
						}
					}
					
					if(requestDetails.getConfirmationFees() != null && feeStructureValue != null && !feeStructureValue.equals(ALOCConstants.EMPTY_STRING)) {
						requestDetails.getConfirmationFees().setFeeStructureValue(new BigDecimal(feeStructureValue));
					}
				}
			}
		}
	}

	/**
	 * Method to check valid Decimal or Not
	 * @param decvalue
	 * @return
	 */
	public static Boolean isValidDecimal(BigDecimal decvalue){
		String expression = ALOCConstants.VALIDATENUMBER_REGEXP;
		if(decvalue!=null){
			if(decvalue.signum() == ALOCConstants.BASE_NEGATIVE_VALUE || decvalue.signum() == ALOCConstants.BASE_VALUE)
				return false;
			return decvalue.toString().matches(expression);
		}
		return true;
	}
	
	/**
	 * Method to check valid ZipFormat or Not
	 * @param decvalue
	 * @return
	 */
	public static Boolean isValidZipformat(String zipFormat){
		String chrexpression = ALOCConstants.VALIDATE_ZIPFORMAT_REGEXP_CHR;
		String numexpression = ALOCConstants.VALIDATE_ZIPFORMAT_REGEXP_NUM;
		if(zipFormat!=null){
			if(zipFormat.equalsIgnoreCase(ALOCConstants.NOTAPPLICABLE)){
				return true;
			}
			else if (!(!zipFormat.matches(chrexpression) && (zipFormat.matches(numexpression)))){
				return false; 
			 }
		}
		return true;
	}
	
	/**
	 * Method to check warranty Term Value is in between 1 to 100 or not
	 * @param warrantyTerm
	 * @return
	 */
	public static Boolean isValidWarrantyTerm(Integer warrantyTerm){
		int warrantyTermValue = warrantyTerm.intValue();
		if(warrantyTermValue > ALOCConstants.TERM_MIN_VALUE && warrantyTermValue < ALOCConstants.TERM_MAX_VALUE ){
			return true;
		}
		return false;
	}
	
	/**
	 * Validation for given US Expiration Date value
	 * @param expDate
	 * @param bidOrOptFlag
	 * @return
	 */
	public static boolean validateBidUSExpirationDate(Calendar usExpDate,String bidOrOptFlag) {
		RequestDetailsBO requestDetailsBO = ALOCContext.getActiveRequest();
		RequestDetails requestDetails = requestDetailsBO.getModel();
		if (requestDetails != null && requestDetails.isUSExpirationDateRequired() != null
				&& requestDetails.isUSExpirationDateRequired()) {
			if (com.hydus.hwf.util.StringUtils.isNotBlank(bidOrOptFlag)
					&& bidOrOptFlag.equals(ALOCConstants.BID_REPLY_FLAG)
					&& usExpDate != null) {
				if (usExpDate.compareTo(getCurrentDateWithOutTime()) >= ALOCConstants.BASE_VALUE) {
					return true;
				} else {
					return false;
				}
			} else {
				return true;
			}
		}
		return true;
	}
	
	/**
	 * This Method is used to download CSV File for SuretyBond Application
	 * @return
	 * @param  apmDetails
	 * @throws IOException 
	 */
	public void downloadSBApplicationCSV(RequestDetails requestDetails,OutputStream outStream) throws IOException {

		HttpServletResponse response = ServletActionContext.getResponse();	
		String filename =null;
		StringBuilder addedFileName = new StringBuilder().append(requestDetails.getAlocRecordId())
				.append(ALOCConstants.HYPEN).append(ALOCConstants.SB_APPLICATION_CSV);
		filename = addedFileName.toString();
		response.setContentType(APPLICATION_VND_MS_EXCEL);
		response.setHeader(ALOCConstants.CONTENTDESC, ALOCConstants.ATTACHMENTFILE + filename + ALOCConstants.SLASH);
		WriteFeePaymentToExcel writeToExcel = new WriteFeePaymentToExcel();

		HSSFWorkbook poiWorkbook = null; 
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(ALOCConstants.SB_CSV_XLPATH);
		poiWorkbook= new HSSFWorkbook(is, true);

		int columnId = ALOCConstants.COLUMN_ONE;
		ExcelSheetCollection excelSheets = new ExcelSheetCollection();
		ExcelSheet excelSheetObj = new ExcelSheet();
		if(requestDetails!=null){
			repeatableObjForDownloadSuretyBondCSV(columnId, requestDetails, excelSheetObj);
		}
		excelSheetObj.setSheetName(poiWorkbook.getSheetName(ALOCConstants.BASE_VALUE));
		excelSheets.getExcelSheet().add(excelSheetObj);
		writeToExcel.write(poiWorkbook, excelSheets);
		
		if(outStream!=null){
			poiWorkbook.write(outStream);
		}else{
			writeExcelToResponse(poiWorkbook, response);
		}
		
	}

	/**
	 * This method to used to add cells to Download CSV for SuretyBond Application
	 * @param objId
	 * @param feeCal
	 * @param excelSheetObj
	 */
	public static void repeatableObjForDownloadSuretyBondCSV(int columnId , RequestDetails requestDetails,ExcelSheet excelSheetObj){
		//constants
		int zero = ALOCConstants.NUM_ZERO;
		int one = ALOCConstants.NUM_ONE;
		String empty = ALOCConstants.EMPTY_STRING;
		
		//Bond Details
		String linkedId = (requestDetails.getRequestSummary() != null) ? requestDetails.getRequestSummary().getLinkedTransactionId() : null;
		String modelCode = (requestDetails.getRequestSummary() != null) ? requestDetails.getRequestSummary().getModelCode() : null;
		BondDetails bondDetails = (requestDetails.getBondDetails() != null) ? requestDetails.getBondDetails() : null;
		
		//Requestor Mailing Address
		AddressDtls reqMailAddrDet = requestDetails.getAddressDtls();
		List<String> reqMailAddrLst = (reqMailAddrDet!=null) ? reqMailAddrDet.getAddress() : null;
		String reqMailAddr1 = null;
		String reqMailAddr2 = null;
		if(reqMailAddrLst!= null && reqMailAddrLst.size() > zero && reqMailAddrLst.get(zero) != null){
			reqMailAddr1 = reqMailAddrLst.get(zero);
		}
		if(reqMailAddrLst!= null && reqMailAddrLst.size() > one && reqMailAddrLst.get(one) != null){
			reqMailAddr2 = reqMailAddrLst.get(one);
		}
		//Bond Details
		fillCellDetails(excelSheetObj, columnId, requestDetails.getAlocRecordId()!=null?requestDetails.getAlocRecordId():empty,ALOCConstants.ROW_ONE);
		fillCellDetails(excelSheetObj, columnId, linkedId!=null ? linkedId : empty, ALOCConstants.ROW_TWO);
		fillCellDetails(excelSheetObj, columnId, modelCode!=null ? modelCode : empty, ALOCConstants.ROW_THREE);
		fillCellDetails(excelSheetObj, columnId, requestDetails.getSiteName()!=null ? requestDetails.getSiteName() : empty, ALOCConstants.ROW_FOUR);
		fillCellDetails(excelSheetObj, columnId, bondDetails!=null ? bondDetails.getBondType() : empty, ALOCConstants.ROW_FIVE);
		fillCellDetails(excelSheetObj, columnId, bondDetails!=null ? bondDetails.getBondSubType() : empty, ALOCConstants.ROW_SIX);
		//Principal
		fillPrincipalDetails(columnId, requestDetails, excelSheetObj);
		//Obligee
		fillObligeeBondReqDetails(columnId, requestDetails, excelSheetObj);
		//Requestor Mailing Address
		fillCellDetails(excelSheetObj, columnId, reqMailAddrDet!=null ? reqMailAddrDet.getName() : empty, ALOCConstants.ROW_THIRTYSEVEN);
		fillCellDetails(excelSheetObj, columnId, reqMailAddrDet!=null ? reqMailAddrDet.getContactFName() : empty, ALOCConstants.ROW_THIRTYEIGHT);
		fillCellDetails(excelSheetObj, columnId, reqMailAddrDet!=null ? reqMailAddrDet.getContactLName() : empty, ALOCConstants.ROW_THIRTYNINE);
		fillCellDetails(excelSheetObj, columnId, reqMailAddr1!=null ? reqMailAddr1 : empty, ALOCConstants.ROW_FORTY);
		fillCellDetails(excelSheetObj, columnId, reqMailAddr2!=null ? reqMailAddr2 : empty, ALOCConstants.ROW_FORTYONE);
		fillCellDetails(excelSheetObj, columnId, reqMailAddrDet!=null ? reqMailAddrDet.getCity() : empty, ALOCConstants.ROW_FORTYTWO);
		fillCellDetails(excelSheetObj, columnId, reqMailAddrDet!=null ? reqMailAddrDet.getStateProvince() : empty, ALOCConstants.ROW_FORTYTHREE);
		fillCellDetails(excelSheetObj, columnId, reqMailAddrDet!=null ? reqMailAddrDet.getZIPPostalCode() : empty, ALOCConstants.ROW_FORTYFOUR);
		fillCellDetails(excelSheetObj, columnId, reqMailAddrDet!=null ? reqMailAddrDet.getCountry() : empty, ALOCConstants.ROW_FORTYFIVE);
		fillCellDetails(excelSheetObj, columnId, reqMailAddrDet!=null ? reqMailAddrDet.getCountryOfInc() : empty, ALOCConstants.ROW_FORTYSIX);
		fillCellDetails(excelSheetObj, columnId, reqMailAddrDet!=null ? reqMailAddrDet.getStateOfInc() : empty, ALOCConstants.ROW_FORTYSEVEN);
		fillCellDetails(excelSheetObj, columnId, reqMailAddrDet!=null ? reqMailAddrDet.getPhoneNumber() : empty, ALOCConstants.ROW_FORTYEIGHT);
		//Delivery Instructions
		fillDeliveryInstructionsDetails(columnId, requestDetails, excelSheetObj);
		//Bond Details
		fillBondDetails(columnId, requestDetails, excelSheetObj);
	}
	
	/**
	 * This method is used to fill Principal Details
	 * @param columnId
	 * @param requestDetails
	 * @param excelSheetObj
	 */
	private static void fillPrincipalDetails(int columnId , RequestDetails requestDetails,ExcelSheet excelSheetObj){
		//constants
		int zero = ALOCConstants.NUM_ZERO;
		int one = ALOCConstants.NUM_ONE;
		int two = ALOCConstants.NUM_TWO;
		String empty = ALOCConstants.EMPTY_STRING;
		//Principal Details
		Principal principal = requestDetails.getPrincipal();
		AddressDtls princAddrDet = (principal!=null) ? principal.getAddressDtls() :null;
		List<String> princAddrLst = (princAddrDet!=null) ? princAddrDet.getAddress() : null;
		String princAddr1 = null;
		String princAddr2 = null;
		String princRef1 = null;
		String princRef2 = null;
		String princRef3 = null;

		if(princAddrLst!=null && princAddrLst.size()> zero && princAddrLst.get(zero) != null){
			princAddr1 = princAddrLst.get(zero);
		}
		if(princAddrLst!=null && princAddrLst.size()> one && princAddrLst.get(one) != null){
			princAddr2 = princAddrLst.get(one);
		}
		List<RefDetails> refDetLst =  (principal!=null) ? principal.getRefDetails() : null;
		if(refDetLst!=null && refDetLst.size()> zero && refDetLst.get(zero)!=null){
			princRef1 = (refDetLst.get(zero).getRefValue()!=null) ? refDetLst.get(zero).getRefValue() : null;
		}
		if(refDetLst!=null && refDetLst.size()> one && refDetLst.get(one)!=null){
			princRef2 = (refDetLst.get(one).getRefValue()!=null) ? refDetLst.get(one).getRefValue() : null;
		}
		if(refDetLst!=null && refDetLst.size()> two && refDetLst.get(two)!=null){
			princRef3 = (refDetLst.get(two).getRefValue()!=null) ? refDetLst.get(two).getRefValue() : null;
		}
		//Principal
		fillCellDetails(excelSheetObj, columnId, principal!=null ? principal.getLeName() : empty, ALOCConstants.ROW_SEVEN);
		fillCellDetails(excelSheetObj, columnId, principal!=null ? principal.getLeGoldId() : empty, ALOCConstants.ROW_EIGHT);
		//GE division name
		/*fillCellDetails(excelSheetObj, columnId, principal!=null ? principal.getGeDivisionName() : empty, ALOCConstants.ROW_NINE);*/
		fillCellDetails(excelSheetObj, columnId, princAddrDet!=null ? princAddrDet.getName() : empty, ALOCConstants.ROW_NINE);
		fillCellDetails(excelSheetObj, columnId, princAddr1!=null ? princAddr1 : empty, ALOCConstants.ROW_TEN);
		fillCellDetails(excelSheetObj, columnId, princAddr2!=null ? princAddr2 : empty, ALOCConstants.ROW_ELEVEN);
		fillCellDetails(excelSheetObj, columnId, princAddrDet!=null ? princAddrDet.getCity() : empty, ALOCConstants.ROW_TWELVE);
		fillCellDetails(excelSheetObj, columnId, princAddrDet!=null ? princAddrDet.getStateProvince() : empty, ALOCConstants.ROW_THIRTEEN);
		fillCellDetails(excelSheetObj, columnId, princAddrDet!=null ? princAddrDet.getZIPPostalCode() : empty, ALOCConstants.ROW_FOURTEEN);
		fillCellDetails(excelSheetObj, columnId, princAddrDet!=null ? princAddrDet.getCountry() : empty, ALOCConstants.ROW_FIFTEEN);
		fillCellDetails(excelSheetObj, columnId, princAddrDet!=null ? princAddrDet.getCountryOfInc() : empty, ALOCConstants.ROW_SIXTEEN);
		fillCellDetails(excelSheetObj, columnId, princAddrDet!=null ? princAddrDet.getStateOfInc() : empty, ALOCConstants.ROW_SEVENTEEN);
		//Principal - Business ID
		/*fillCellDetails(excelSheetObj, columnId, principal!=null ? principal.getBusinessId() : empty, ALOCConstants.ROW_NINTEEN);*/
		fillCellDetails(excelSheetObj, columnId, princRef1!=null ? princRef1 : empty, ALOCConstants.ROW_EIGHTEEN);
		fillCellDetails(excelSheetObj, columnId, princRef2!=null ? princRef2 : empty, ALOCConstants.ROW_NINTEEN);
		fillCellDetails(excelSheetObj, columnId, princRef3!=null ? princRef3 : empty, ALOCConstants.ROW_TWENTY);
		fillCellDetails(excelSheetObj, columnId, principal!=null ? principal.getPrincipalBuUniteCd() : empty, ALOCConstants.ROW_TWENTYONE);
		fillCellDetails(excelSheetObj, columnId, principal!=null ? principal.getPrincipalAccDistNo() : empty, ALOCConstants.ROW_TWENTYTWO);
	}

	/**
	 * This method is used to fill Obligee/BondRequest Details
	 * @param columnId
	 * @param requestDetails
	 * @param excelSheetObj
	 */
	private static void fillObligeeBondReqDetails(int columnId , RequestDetails requestDetails,ExcelSheet excelSheetObj){
		//constants
		int zero = ALOCConstants.NUM_ZERO;
		int one = ALOCConstants.NUM_ONE;
		int two = ALOCConstants.NUM_TWO;
		String empty = ALOCConstants.EMPTY_STRING;
		//Obligee Details
		Obligee obligee = requestDetails.getObligee();
		AddressDtls obligAddrDet = (obligee!=null) ? obligee.getAddressDtls() : null;
		List<String> obligAddrLst = (obligAddrDet!=null) ? obligAddrDet.getAddress() : null;
		String obligAddr1 = null;
		String obligAddr2 = null;
		String obligRef1 = null;
		String obligRef2 = null;
		String obligRef3 = null;

		if(obligAddrLst!=null && obligAddrLst.size()> zero && obligAddrLst.get(zero) != null){
			obligAddr1 = obligAddrLst.get(zero);
		}
		if(obligAddrLst!=null && obligAddrLst.size()> one && obligAddrLst.get(one) != null){
			obligAddr2 = obligAddrLst.get(one);
		}
		List<ObligeeRef> obligRefDetLst =  (obligee!=null) ? obligee.getObligeeReves() : null;
		if(obligRefDetLst!=null && obligRefDetLst.size()> zero && obligRefDetLst.get(zero)!=null){
			obligRef1 = (obligRefDetLst.get(zero).getRefValue()!=null) ? obligRefDetLst.get(zero).getRefValue() : null;
		}
		if(obligRefDetLst!=null && obligRefDetLst.size()> one && obligRefDetLst.get(one)!=null){
			obligRef2 = (obligRefDetLst.get(one).getRefValue()!=null) ? obligRefDetLst.get(one).getRefValue() : null;
		}
		if(obligRefDetLst!=null && obligRefDetLst.size()> two && obligRefDetLst.get(two)!=null){
			obligRef3 = (obligRefDetLst.get(two).getRefValue()!=null) ? obligRefDetLst.get(two).getRefValue() : null;
		}
		
		BondReqDtls bondReqDet = requestDetails.getBondReqDtls();
	
		fillCellDetails(excelSheetObj, columnId, obligAddrDet!=null ? obligAddrDet.getName() : empty, ALOCConstants.ROW_TWENTYTHREE);
		fillCellDetails(excelSheetObj, columnId, obligAddr1!=null ? obligAddr1 : empty, ALOCConstants.ROW_TWENTYFOUR);
		fillCellDetails(excelSheetObj, columnId, obligAddr2!=null ? obligAddr2 : empty, ALOCConstants.ROW_TWENTYFIVE);
		fillCellDetails(excelSheetObj, columnId, obligAddrDet!=null ? obligAddrDet.getCity() : empty, ALOCConstants.ROW_TWENTYSIX);
		fillCellDetails(excelSheetObj, columnId, obligAddrDet!=null ? obligAddrDet.getStateProvince() : empty, ALOCConstants.ROW_TWENTYSEVEN);
		fillCellDetails(excelSheetObj, columnId, obligAddrDet!=null ? obligAddrDet.getZIPPostalCode() : empty, ALOCConstants.ROW_TWENTYEIGHT);
		fillCellDetails(excelSheetObj, columnId, obligAddrDet!=null ? obligAddrDet.getCountry() : empty, ALOCConstants.ROW_TWENTYNINE);		
		fillCellDetails(excelSheetObj, columnId, obligRef1!=null ? obligRef1 : empty, ALOCConstants.ROW_THIRTY);
		fillCellDetails(excelSheetObj, columnId, obligRef2!=null ? obligRef2 : empty, ALOCConstants.ROW_THIRTYONE);
		fillCellDetails(excelSheetObj, columnId, obligRef3!=null ? obligRef3 : empty, ALOCConstants.ROW_THIRTYTWO);
		//Bond Requestor
		fillCellDetails(excelSheetObj, columnId, bondReqDet!=null ? bondReqDet.getName() : empty, ALOCConstants.ROW_THIRTYTHREE);
		fillCellDetails(excelSheetObj, columnId, bondReqDet!=null ? bondReqDet.getEmailAddress() : empty, ALOCConstants.ROW_THIRTYFOUR);
		fillCellDetails(excelSheetObj, columnId, bondReqDet!=null ? bondReqDet.getPhoneNo() : empty, ALOCConstants.ROW_THIRTYFIVE);
		fillCellDetails(excelSheetObj, columnId, bondReqDet!=null ? bondReqDet.getFaxNo() : empty, ALOCConstants.ROW_THIRTYSIX);
	}
	
	/**
	 * This method is used to fill DeleveryInstructions Details
	 * @param columnId
	 * @param requestDetails
	 * @param excelSheetObj
	 */
	private static void fillDeliveryInstructionsDetails(int columnId , RequestDetails requestDetails,ExcelSheet excelSheetObj){
		String empty = ALOCConstants.EMPTY_STRING;
		//Delivery Instructions
		DeliveryInstructions deliveryInstr = requestDetails.getDeliveryInstructions();
		String deliveryType = null;
		String deliveryTypeVal = (deliveryInstr!= null) ? deliveryInstr.getDeliveryType() : null;
		if(deliveryTypeVal!=null && deliveryTypeVal.equalsIgnoreCase(ALOCConstants.TRUE_SMALL)){
			deliveryType = ALOCConstants.INPERSON_PICKUP;
		}
		if(deliveryTypeVal!=null && deliveryTypeVal.equalsIgnoreCase(ALOCConstants.FALSE)){
			deliveryType = ALOCConstants.PHYSICAL_DELIVERY;
		}
		String usePreAddrVal = (deliveryInstr!= null) ? deliveryInstr.getUsePreviousAddress() : null;
		String usePreAddr = null;
		if(usePreAddrVal!=null && usePreAddrVal.equalsIgnoreCase(ALOCConstants.PRINCIPALDETAILS)){
			usePreAddr = ALOCConstants.PRINCIPAL_DETAILS;
		}
		if(usePreAddrVal!=null && usePreAddrVal.equalsIgnoreCase(ALOCConstants.OBLIGEEDETAILS)){
			usePreAddr = ALOCConstants.OBLIGEE_DETAILS;
		}
		String ecopyMySelf = null;
		String ecopyMySelfVal = (deliveryInstr!= null) ? deliveryInstr.getEcopyMyself() : null;
		if(ecopyMySelfVal!= null && ecopyMySelfVal.equalsIgnoreCase(ALOCConstants.TRUE_SMALL)){
			ecopyMySelf = ALOCConstants.YES_CAP;
		}else{
			ecopyMySelf = ALOCConstants.NO_CAP;
		}
		String ecopyToOtherGE = null;
		String ecopyToOtherGEfVal = (deliveryInstr!= null) ? deliveryInstr.getEcopyOtherGEPerson() : null;
		if(ecopyToOtherGEfVal!= null && ecopyToOtherGEfVal.equalsIgnoreCase(ALOCConstants.TRUE_SMALL)){
			ecopyToOtherGE = ALOCConstants.YES_CAP;
		}else{
			ecopyToOtherGE = ALOCConstants.NO_CAP;
		}
		Recipient recipient = (deliveryInstr!= null) ? deliveryInstr.getRecipient() : null;
		//Delivery Instructions
		fillCellDetails(excelSheetObj, columnId, deliveryType!=null ? deliveryType : empty, ALOCConstants.ROW_FORTYNINE);
		fillCellDetails(excelSheetObj, columnId, usePreAddr!=null ? usePreAddr : empty, ALOCConstants.ROW_FIFTY);
		fillCellDetails(excelSheetObj, columnId, deliveryInstr!=null ? deliveryInstr.getCompanyName() : empty, ALOCConstants.ROW_FIFTYONE);
		fillCellDetails(excelSheetObj, columnId, deliveryInstr!=null ? deliveryInstr.getFirstName() : empty, ALOCConstants.ROW_FIFTYTWO);
		fillCellDetails(excelSheetObj, columnId, deliveryInstr!=null ? deliveryInstr.getLastName() : empty, ALOCConstants.ROW_FIFTYTHREE);
		fillCellDetails(excelSheetObj, columnId, deliveryInstr!=null ? deliveryInstr.getTitle() : empty, ALOCConstants.ROW_FIFTYFOUR);
		fillCellDetails(excelSheetObj, columnId, deliveryInstr!=null ? deliveryInstr.getAddress1() : empty, ALOCConstants.ROW_FIFTYFIVE);
		fillCellDetails(excelSheetObj, columnId, deliveryInstr!=null ? deliveryInstr.getAddress2() : empty, ALOCConstants.ROW_FIFTYSIX);
		fillCellDetails(excelSheetObj, columnId, deliveryInstr!=null ? deliveryInstr.getCity() : empty, ALOCConstants.ROW_FIFTYSEVEN);
		fillCellDetails(excelSheetObj, columnId, deliveryInstr!=null ? deliveryInstr.getStateProvince() : empty, ALOCConstants.ROW_FIFTYEIGHT);
		fillCellDetails(excelSheetObj, columnId, deliveryInstr!=null ? deliveryInstr.getZIPPostalcode(): empty, ALOCConstants.ROW_FIFTYNINE);
		fillCellDetails(excelSheetObj, columnId, deliveryInstr!=null ? deliveryInstr.getCountry() : empty, ALOCConstants.ROW_SIXTY);
		fillCellDetails(excelSheetObj, columnId, deliveryInstr!=null ? deliveryInstr.getPhoneNo() : empty, ALOCConstants.ROW_SIXTYONE);
		fillCellDetails(excelSheetObj, columnId, deliveryInstr!=null ? deliveryInstr.getSpecialInstructions() : empty, ALOCConstants.ROW_SIXTYTWO);
		fillCellDetails(excelSheetObj, columnId, ecopyMySelf!=null ? ecopyMySelf : empty, ALOCConstants.ROW_SIXTYTHREE);
		fillCellDetails(excelSheetObj, columnId, ecopyToOtherGE!=null ? ecopyToOtherGE : empty, ALOCConstants.ROW_SIXTYFOUR);
		if(ecopyToOtherGE != null && ecopyToOtherGE.equalsIgnoreCase(ALOCConstants.YES_CAP)){
			fillCellDetails(excelSheetObj, columnId, recipient!=null ? recipient.getRecipientFirstName() : empty, ALOCConstants.ROW_SIXTYFIVE);
			fillCellDetails(excelSheetObj, columnId, recipient!=null ? recipient.getRecipientLastName() : empty, ALOCConstants.ROW_SIXTYSIX);
			fillCellDetails(excelSheetObj, columnId, recipient!=null ? recipient.getRecipientSsoId() : empty, ALOCConstants.ROW_SIXTYSEVEN);
			fillCellDetails(excelSheetObj, columnId, recipient!=null ? recipient.getRecipientEmail() : empty, ALOCConstants.ROW_SIXTYEIGHT);
		}
	}
	
	/**
	 * This method is used to fill BondDetails
	 * @param columnId
	 * @param requestDetails
	 * @param excelSheetObj
	 */
	private static void fillBondDetails(int columnId , RequestDetails requestDetails,ExcelSheet excelSheetObj){
		SimpleDateFormat formatter = new SimpleDateFormat(ALOCConstants.FORMAT_INV_PATTERN);
		String empty = ALOCConstants.EMPTY_STRING;
		//Bond Information
		BondDetails bondDet = requestDetails.getBondDetails();
		BigInteger  bondTypeId = (bondDet!=null) ? bondDet.getBondTypeId() : null;
		BondInfo bondInfo = requestDetails.getBondInfo();
		BigDecimal bidBondAmt = (bondInfo!= null) ? bondInfo.getBondAmount(): null;
		BigInteger caseNumber = (bondInfo!= null) ? bondInfo.getCaseNumber() : null;
		BigDecimal jugdementAmt = (bondInfo!= null) ? bondInfo.getJudgementAmount(): null;
		BigDecimal bondAmt = (bondInfo!= null) ? bondInfo.getCourtBondAmt(): null;
		BigDecimal usdCourtBondAmt = (bondInfo!= null) ? bondInfo.getUSDCourtBondAmt(): null;
		Calendar dateField = (bondInfo!=null) ? bondInfo.getDateFiled() : null;
		Calendar effectiveDate = null;
		if(bondTypeId != null && (bondTypeId.equals(BigInteger.valueOf(ALOCConstants.CONTRACTBOND_ID)) || 
				(bondTypeId.equals(BigInteger.valueOf(ALOCConstants.LICENCE_BOND_ID))))){
			effectiveDate = (bondInfo!=null) ? bondInfo.getEffectiveDt() : null;
		}else if(bondTypeId != null && (bondTypeId.equals(BigInteger.valueOf(ALOCConstants.COURT_BOND_ID)))){
			effectiveDate = (bondInfo!=null) ? bondInfo.getEffectiveDate() : null;
		}
		Calendar expirDate = (bondInfo!=null) ? bondInfo.getExpirationDt() : null;
		BigDecimal usdEstBondAmt = bondInfo.getUSDEstimatedBondAmt();
		BigDecimal usdPerBondAmt = bondInfo.getUSDPerformanceBondAmt();
		
		fillBondDetailsSectionData(columnId, requestDetails, excelSheetObj);
		
		fillCellDetails(excelSheetObj, columnId, bondInfo!=null ? bondInfo.getCounty() : empty, ALOCConstants.ROW_NINETYTHREE);
		fillCellDetails(excelSheetObj, columnId, bondInfo!=null ? bondInfo.getState(): empty, ALOCConstants.ROW_NINETYFOUR);
		fillCellDetails(excelSheetObj, columnId, caseNumber!=null ? caseNumber.toString() : empty, ALOCConstants.ROW_NINETYFIVE);
		fillCellDetails(excelSheetObj, columnId, dateField!=null ? formatter.format(dateField.getTime()) : empty, ALOCConstants.ROW_NINETYSIX);
		fillCellDetails(excelSheetObj, columnId, jugdementAmt!=null ? getStringWithDecimalValue(jugdementAmt.toString()) : empty, ALOCConstants.ROW_NINETYSEVEN);
		fillCellDetails(excelSheetObj, columnId, bondInfo!=null ? bondInfo.getBondCurrency() : empty, ALOCConstants.ROW_NINETYEIGHT);
		fillCellDetails(excelSheetObj, columnId, bondAmt!=null ? getStringWithDecimalValue(bondAmt.toString()) : empty, ALOCConstants.ROW_NINETYNINE);
		fillCellDetails(excelSheetObj, columnId, usdCourtBondAmt!=null ? getStringWithDecimalValue(usdCourtBondAmt.toString()) : empty, ALOCConstants.ROW_HUNDRED);
		fillCellDetails(excelSheetObj, columnId, bondInfo!=null ? bondInfo.getLawFirmName() : empty, ALOCConstants.ROW_HUNDRED_AND_ONE);
		fillCellDetails(excelSheetObj, columnId, bondInfo!=null ? bondInfo.getAttorneyName(): empty, ALOCConstants.ROW_HUNDRED_AND_TWO);
		fillCellDetails(excelSheetObj, columnId, bondInfo!=null ? bondInfo.getAttorneyAddress1() : empty, ALOCConstants.ROW_HUNDRED_AND_THREE);
		fillCellDetails(excelSheetObj, columnId, bondInfo!=null ? bondInfo.getAttorneyAddress2() : empty, ALOCConstants.ROW_HUNDRED_AND_FOUR);
		fillCellDetails(excelSheetObj, columnId, bondInfo!=null ? bondInfo.getAttorneyCity() : empty, ALOCConstants.ROW_HUNDRED_AND_FIVE);
		fillCellDetails(excelSheetObj, columnId, bondInfo!=null ? bondInfo.getAttorneyState() : empty, ALOCConstants.ROW_HUNDRED_AND_SIX);
		fillCellDetails(excelSheetObj, columnId, bondInfo!=null ? bondInfo.getAttorneyCountry(): empty, ALOCConstants.ROW_HUNDRED_AND_SEVEN);
		fillCellDetails(excelSheetObj, columnId, bondInfo!=null ? bondInfo.getAttorneyZIPCode() : empty, ALOCConstants.ROW_HUNDRED_AND_EIGHT);
		fillCellDetails(excelSheetObj, columnId, bondInfo!=null ? bondInfo.getAttorneyPhoneNum() : empty, ALOCConstants.ROW_HUNDRED_AND_NINE);
		fillCellDetails(excelSheetObj, columnId, bondInfo!=null ? bondInfo.getAttorneyFaxNum() : empty, ALOCConstants.ROW_HUNDRED_AND_TEN);
		fillCellDetails(excelSheetObj, columnId, bondInfo!=null ? bondInfo.getAttorneyEmail() : empty, ALOCConstants.ROW_HUNDRED_AND_ELEVEN);
		if(bondTypeId != null && (bondTypeId.equals(BigInteger.valueOf(ALOCConstants.CUST_BOND_ID)))){
			fillCellDetails(excelSheetObj, columnId, bidBondAmt!=null ? getStringWithDecimalValue(bidBondAmt.toString()) : empty, ALOCConstants.ROW_HUNDRED_AND_TWELVE);
		}
		if(bondTypeId != null && (bondTypeId.equals(BigInteger.valueOf(ALOCConstants.LICENCE_BOND_ID)))){
			fillCellDetails(excelSheetObj, columnId, bidBondAmt!=null ? getStringWithDecimalValue(bidBondAmt.toString()) : empty, ALOCConstants.ROW_HUNDRED_AND_THIRTEEN);
		}
		fillCellDetails(excelSheetObj, columnId, bondInfo!=null ? bondInfo.getImporterNum() : empty, ALOCConstants.ROW_HUNDRED_AND_FOURTEEN);
		fillCellDetails(excelSheetObj, columnId, bondInfo!=null ? bondInfo.getActivityCd() : empty, ALOCConstants.ROW_HUNDRED_AND_FIFTEEN);
		fillCellDetails(excelSheetObj, columnId, bondInfo!=null ? bondInfo.getIssuanceCountryName():empty,ALOCConstants.ROW_HUNDRED_AND_SIXTEEN);
		if(bondTypeId != null && (!(bondTypeId.equals(BigInteger.valueOf(ALOCConstants.CUST_BOND_ID))))){
			fillCellDetails(excelSheetObj, columnId, effectiveDate!=null ? formatter.format(effectiveDate.getTime()) : empty, ALOCConstants.ROW_HUNDRED_AND_SEVENTEEN);
			fillCellDetails(excelSheetObj, columnId, expirDate!=null ? formatter.format(expirDate.getTime()) : empty, ALOCConstants.ROW_HUNDRED_AND_EIGHTEEN);
		}
		if(bondTypeId != null && bondTypeId.equals(BigInteger.valueOf(ALOCConstants.BIDBOND_ID))){
			fillCellDetails(excelSheetObj, columnId, bondInfo!=null ? bondInfo.getBidBondCurrencyName() : empty, ALOCConstants.ROW_HUNDRED_AND_NINTEEN);
			fillCellDetails(excelSheetObj, columnId, usdEstBondAmt!=null ? getStringWithDecimalValue(usdEstBondAmt.toString()) : empty, ALOCConstants.ROW_HUNDRED_AND_TWENTY);
		}
		if(bondTypeId != null && bondTypeId.equals(BigInteger.valueOf(ALOCConstants.CONTRACTBOND_ID))){
			fillCellDetails(excelSheetObj, columnId, usdPerBondAmt!=null ? getStringWithDecimalValue(usdPerBondAmt.toString()) : empty, ALOCConstants.ROW_HUNDRED_AND_TWENTYONE);
		}
	}
	
	/**
	 * This method is used to fill BondDetails
	 * @param columnId
	 * @param requestDetails
	 * @param excelSheetObj
	 */
	private static void fillBondDetailsSectionData(int columnId , RequestDetails requestDetails,ExcelSheet excelSheetObj){
		SimpleDateFormat formatter = new SimpleDateFormat(ALOCConstants.FORMAT_INV_PATTERN);
		String empty = ALOCConstants.EMPTY_STRING;
		
		BondDetails bondDet = requestDetails.getBondDetails();
		BigInteger  bondTypeId = (bondDet!=null) ? bondDet.getBondTypeId() : null;
		BondInfo bondInfo = requestDetails.getBondInfo();
		String invitationOrBidNo = (bondInfo!= null) ? bondInfo.getInvitationOrBidNo() : null;
		BigDecimal estBidAmt = (bondInfo!= null) ? bondInfo.getEstBidAmount() : null;
		BigDecimal bidBondAmt = (bondInfo!= null) ? bondInfo.getBondAmount(): null;
		BigDecimal usdEqualBondAmt = (bondInfo!= null) ? bondInfo.getUSEquivalentBondAmt(): null;
		Integer warrentyMonths = (bondInfo!= null) ? bondInfo.getWarrantyTerm(): null;
		BigDecimal performanceBondAmt = (bondInfo!= null) ? bondInfo.getPerformanceBondAmt(): null;
		BigDecimal contractAmt = (bondInfo!= null) ? bondInfo.getContractAmt(): null;
		BigDecimal usdContractAmt = (bondInfo!= null) ? bondInfo.getUSDContractAmt(): null;
		Calendar bidDate = (bondInfo!=null) ? bondInfo.getBidDt() : null;
		Calendar estStartDate = (bondInfo!=null) ? bondInfo.getEstStartDt() : null;
		Calendar estCompDate = (bondInfo!=null) ? bondInfo.getEstCompletionDt() : null;
		Calendar needByDate = (bondInfo!=null) ? bondInfo.getNeedByDt() : null;
		Calendar effectiveDate = (bondInfo!=null) ? bondInfo.getEffectiveDt() : null;
		Calendar expirDate = (bondInfo!=null) ? bondInfo.getExpirationDt() : null;
		Calendar contractDate = (bondInfo!=null) ? bondInfo.getContractDt() : null;
		
		fillCellDetails(excelSheetObj, columnId, bondInfo!=null ? bondInfo.getExactProjDesc() : empty, ALOCConstants.ROW_SIXTYNINE);
		fillCellDetails(excelSheetObj, columnId, invitationOrBidNo!=null ? invitationOrBidNo.toString() : empty, ALOCConstants.ROW_SEVENTY);
		fillCellDetails(excelSheetObj, columnId, bondInfo!=null ? bondInfo.getObligationCity() : empty, ALOCConstants.ROW_SEVENTYONE);
		fillCellDetails(excelSheetObj, columnId, bondInfo!=null ? bondInfo.getObligationCountryOrState() : empty, ALOCConstants.ROW_SEVENTYTWO);
		fillCellDetails(excelSheetObj, columnId, bidDate!=null ? formatter.format(bidDate.getTime()) : empty, ALOCConstants.ROW_SEVENTYTHREE);
		fillCellDetails(excelSheetObj, columnId, estStartDate!=null ? formatter.format(estStartDate.getTime()) : empty, ALOCConstants.ROW_SEVENTYFOUR);
		fillCellDetails(excelSheetObj, columnId, estCompDate!=null ? formatter.format(estCompDate.getTime()) : empty, ALOCConstants.ROW_SEVENTYFIVE);
		fillCellDetails(excelSheetObj, columnId, estBidAmt!=null ? getStringWithDecimalValue(estBidAmt.toString()) : empty, ALOCConstants.ROW_SEVENTYSIX);
		if(bondTypeId != null && (bondTypeId.equals(BigInteger.valueOf(ALOCConstants.BIDBOND_ID)))){
			fillCellDetails(excelSheetObj, columnId, bidBondAmt!=null ? getStringWithDecimalValue(bidBondAmt.toString()) : empty, ALOCConstants.ROW_SEVENTYSEVEN);
		}
		fillCellDetails(excelSheetObj, columnId, usdEqualBondAmt!=null ? getStringWithDecimalValue(usdEqualBondAmt.toString()) : empty, ALOCConstants.ROW_SEVENTYEIGHT);
		fillCellDetails(excelSheetObj, columnId, bondInfo!=null ? bondInfo.getPerformanceBondCurrencyName(): empty, ALOCConstants.ROW_SEVENTYNINE);
		fillCellDetails(excelSheetObj, columnId, warrentyMonths!=null ? warrentyMonths.toString() : empty, ALOCConstants.ROW_EIGHTY);
		fillCellDetails(excelSheetObj, columnId, needByDate!=null ? formatter.format(needByDate.getTime()) : empty, ALOCConstants.ROW_EIGHTYONE);
		fillCellDetails(excelSheetObj, columnId, bondInfo!=null ? bondInfo.getOtherInfo() : empty, ALOCConstants.ROW_EIGHTYTWO);
		fillCellDetails(excelSheetObj, columnId, bondInfo!=null ? bondInfo.getBondFormType() : empty, ALOCConstants.ROW_EIGHTYTHREE);
		if(bondTypeId != null && (bondTypeId.equals(BigInteger.valueOf(ALOCConstants.CUST_BOND_ID)))){
			fillCellDetails(excelSheetObj, columnId, effectiveDate!=null ? formatter.format(effectiveDate.getTime()) : empty, ALOCConstants.ROW_EIGHTYFOUR);
			fillCellDetails(excelSheetObj, columnId, expirDate!=null ? formatter.format(expirDate.getTime()) : empty, ALOCConstants.ROW_EIGHTYFIVE);
		}
		fillCellDetails(excelSheetObj, columnId, contractDate!=null ? formatter.format(contractDate.getTime()): empty, ALOCConstants.ROW_EIGHTYSIX);
		fillCellDetails(excelSheetObj, columnId, performanceBondAmt!=null ? getStringWithDecimalValue(performanceBondAmt.toString()) : empty, ALOCConstants.ROW_EIGHTYSEVEN);
		fillCellDetails(excelSheetObj, columnId, bondInfo!=null ? bondInfo.getContractCurName() : empty, ALOCConstants.ROW_EIGHTYEIGHT);
		fillCellDetails(excelSheetObj, columnId, contractAmt!=null ? getStringWithDecimalValue(contractAmt.toString()) : empty, ALOCConstants.ROW_EIGHTYNINE);
		fillCellDetails(excelSheetObj, columnId, usdContractAmt!=null ? getStringWithDecimalValue(usdContractAmt.toString()) : empty, ALOCConstants.ROW_NINETY);
		fillCellDetails(excelSheetObj, columnId, bondInfo!=null ? bondInfo.getLiquidatedDamages() : empty, ALOCConstants.ROW_NINETYONE);
		fillCellDetails(excelSheetObj, columnId, bondInfo!=null ? bondInfo.getCourtOfJurisdiction() : empty, ALOCConstants.ROW_NINETYTWO);
	}
	
	/**
	 * This method to used to fill cell details to the excel sheet
	 * @param excelSheetObj
	 * @param i
	 * @param value
	 * @param objId
	 */
	private static void fillCellDetails(ExcelSheet excelSheetObj, int i, String value, int objId) {
		CellDetail cellDetailObj = new CellDetail();
		cellDetailObj.setRowId(objId);
		cellDetailObj.setColumnId(i);
		cellDetailObj.setValue(value);
		excelSheetObj.getCellDetail().add(cellDetailObj);

	}
	
	/**
	 * This is utility method to write {@link HSSFWorkbook} to {@link HttpServletResponse}.
	 * @param poiWorkbook
	 * @param response
	 * @throws IOException
	 */
	private void writeExcelToResponse(HSSFWorkbook poiWorkbook, HttpServletResponse response) throws IOException {
		OutputStream out = null;
		try {
			out = response.getOutputStream();
			poiWorkbook.write(out);
			out.flush();
		} finally {
			try {
				if(out != null) {
					out.close();
				}
			} catch (IOException ioe) {
				LOGGER.warn(ALOCConstants.SERVELET_OUTPUTSTREAM_ERROR, ioe);
			}
		}
	}
	
	/**
	 * This Method is used to download CSV File for SuretyRider Application
	 * @return
	 * @param  apmDetails
	 * @throws IOException 
	 */
	public void downloadRiderApplicationCSV(RequestDetails requestDetails,OutputStream outStream) throws IOException {

		HttpServletResponse response = ServletActionContext.getResponse();	
		String filename =null;
		StringBuilder addedFileName = new StringBuilder().append(requestDetails.getAlocRecordId())
				.append(ALOCConstants.HYPEN).append(ALOCConstants.RIDER_APPLICATION_CSV);
		filename = addedFileName.toString();
		response.setContentType(APPLICATION_VND_MS_EXCEL);
		response.setHeader(ALOCConstants.CONTENTDESC, ALOCConstants.ATTACHMENTFILE + filename + ALOCConstants.SLASH);
		WriteFeePaymentToExcel writeToExcel = new WriteFeePaymentToExcel();

		HSSFWorkbook poiWorkbook = null; 
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(ALOCConstants.RIDER_CSV_XLPATH);
		poiWorkbook= new HSSFWorkbook(is, true);

		int columnId = ALOCConstants.COLUMN_ONE;
		ExcelSheetCollection excelSheets = new ExcelSheetCollection();
		ExcelSheet excelSheetObj = new ExcelSheet();
		if(requestDetails!=null){
			repeatableObjForDownloadSuretyRiderCSV(columnId, requestDetails, excelSheetObj);
		}
		excelSheetObj.setSheetName(poiWorkbook.getSheetName(ALOCConstants.BASE_VALUE));
		excelSheets.getExcelSheet().add(excelSheetObj);
		writeToExcel.write(poiWorkbook, excelSheets);
		
		if(outStream!=null){
			poiWorkbook.write(outStream);
		}else{
			writeExcelToResponse(poiWorkbook, response);
		}
		
	}
	
	/**
	 * This method to used to add cells to Download CSV for SuretyRider Application
	 * @param objId
	 * @param feeCal
	 * @param excelSheetObj
	 */
	public static void repeatableObjForDownloadSuretyRiderCSV(int columnId , RequestDetails requestDetails,ExcelSheet excelSheetObj){
		SimpleDateFormat formatter = new SimpleDateFormat(ALOCConstants.FORMAT_INV_PATTERN);
		String empty = ALOCConstants.EMPTY_STRING;
		
		String modelCode = (requestDetails.getRequestSummary() != null) ? requestDetails.getRequestSummary().getModelCode() : null;
		Rider rider = requestDetails.getRider();
		Rider preRider = requestDetails.getPreviousRider();
		BondDetails bondDetails = requestDetails.getBondDetails();
		//Expiration Date
		ExpiryDate expiryDate = (rider !=null) ? rider.getExpiryDate() : null;
		ExpiryDate preExpiryDate = (preRider !=null) ? preRider.getExpiryDate() : null;
		Calendar revisedExpDate = (expiryDate !=null) ? expiryDate.getRevisedExpiryDate() : null;
		Calendar preRevisedExpDate = (preExpiryDate !=null) ? preExpiryDate.getRevisedExpiryDate() : null;
		if(preRevisedExpDate == null){
			preRevisedExpDate = (expiryDate !=null) ? expiryDate.getCurrentExpiryDate() : null;
		}
		//Bond Information
		RiderBondInformation riderBondInfo = (rider !=null) ? rider.getRiderBondInformation() : null;
		BigDecimal originalBondAmt = (riderBondInfo != null) ? riderBondInfo.getOriginalBondAmt() : null;
		BigDecimal currentBondAmt = (riderBondInfo != null) ? riderBondInfo.getCurrentBondAmt() : null;
		BigDecimal amtOfIncDec = (riderBondInfo !=null) ? riderBondInfo.getAmtOfIncreaseOrDecrease() : null;
		BigDecimal revisedBondAmt = (riderBondInfo !=null) ? riderBondInfo.getRevisedBondAmt() : null;
		BigDecimal originalContractAmt = (riderBondInfo != null) ? riderBondInfo.getOriginalContractAmt() : null;
		BigDecimal revisedContractAmt = (riderBondInfo != null) ? riderBondInfo.getRevisedContractAmt() : null;
		BigDecimal revisedUSDContractAmt = (riderBondInfo != null) ? riderBondInfo.getRevisedUSDEquiContractAmt() : null;
		//Bond Details
		fillCellDetails(excelSheetObj, columnId, requestDetails.getAlocRecordId() !=null ? requestDetails.getAlocRecordId() : empty , ALOCConstants.ROW_ONE);
		fillCellDetails(excelSheetObj, columnId, modelCode !=null ? modelCode : empty, ALOCConstants.ROW_TWO);
		fillCellDetails(excelSheetObj, columnId, rider !=null ? rider.getRiderRequestId() : empty, ALOCConstants.ROW_THREE);
		fillCellDetails(excelSheetObj, columnId, bondDetails !=null ? bondDetails.getBondType() : empty, ALOCConstants.ROW_FOUR);
		fillCellDetails(excelSheetObj, columnId, bondDetails !=null ? bondDetails.getBondSubType() : empty, ALOCConstants.ROW_FIVE);
		//Principal/Obligee
		fillRiderPrincipalObligeeDetails(columnId , requestDetails, excelSheetObj);
		//Expiration Date
		fillCellDetails(excelSheetObj,columnId,preRevisedExpDate!=null?formatter.format(preRevisedExpDate.getTime()):empty,ALOCConstants.ROW_TWENTYTHREE);
		fillCellDetails(excelSheetObj, columnId, revisedExpDate!=null ? formatter.format(revisedExpDate.getTime()):empty,ALOCConstants.ROW_TWENTYFOUR);
		//Bond Information
		fillCellDetails(excelSheetObj, columnId, originalBondAmt !=null ? getStringWithDecimalValue(originalBondAmt.toString()) : empty , ALOCConstants.ROW_TWENTYFIVE);
		fillCellDetails(excelSheetObj, columnId, currentBondAmt !=null ? getStringWithDecimalValue(currentBondAmt.toString()) : empty , ALOCConstants.ROW_TWENTYSIX);
		fillCellDetails(excelSheetObj, columnId, riderBondInfo !=null ? riderBondInfo.getOperation() : empty , ALOCConstants.ROW_TWENTYSEVEN);
		fillCellDetails(excelSheetObj, columnId, amtOfIncDec !=null ? getStringWithDecimalValue(amtOfIncDec.toString()) : empty , ALOCConstants.ROW_TWENTYEIGHT);
		fillCellDetails(excelSheetObj, columnId, revisedBondAmt !=null ? getStringWithDecimalValue(revisedBondAmt.toString()) : empty , ALOCConstants.ROW_TWENTYNINE);
		fillCellDetails(excelSheetObj, columnId, originalContractAmt !=null ? getStringWithDecimalValue(originalContractAmt.toString()) : empty , ALOCConstants.ROW_THIRTY);
		fillCellDetails(excelSheetObj, columnId, revisedContractAmt !=null ? getStringWithDecimalValue(revisedContractAmt.toString()) : empty , ALOCConstants.ROW_THIRTYONE);
		fillCellDetails(excelSheetObj, columnId, revisedUSDContractAmt !=null ? getStringWithDecimalValue(revisedUSDContractAmt.toString()):empty,ALOCConstants.ROW_THIRTYTWO);
		//Delivery Instructions
		fillRiderDeliveryInstructions(columnId , requestDetails, excelSheetObj);
	}
	
	/**
	 * This method is used to fill Rider Principal/Obligee Details
	 * @param columnId
	 * @param requestDetails
	 * @param excelSheetObj
	 */
	private static void fillRiderPrincipalObligeeDetails(int columnId , RequestDetails requestDetails,ExcelSheet excelSheetObj){
		String empty = ALOCConstants.EMPTY_STRING;
		int zero = ALOCConstants.NUM_ZERO;
		int one = ALOCConstants.NUM_ONE;		
		//Principal/Obligee
		Rider rider = requestDetails.getRider();
		Principal principal = (rider!= null) ? rider.getPrincipal() : null;
		AddressDtls princAddrDet = (principal!=null) ? principal.getAddressDtls() :null;
		List<String> princAddrLst = (princAddrDet!=null) ? princAddrDet.getAddress() : null;
		String princAddr1 = null;
		String princAddr2 = null;
		
		if(princAddrLst!=null && princAddrLst.size()> zero && princAddrLst.get(zero) != null){
			princAddr1 = princAddrLst.get(zero);
		}
		if(princAddrLst!=null && princAddrLst.size()> one && princAddrLst.get(one) != null){
			princAddr2 = princAddrLst.get(one);
		}
		Obligee obligee = (rider!=null) ? rider.getObligee() : null;
		AddressDtls obligAddrDet = (obligee!=null) ? obligee.getAddressDtls() : null;
		List<String> obligAddrLst = (obligAddrDet!=null) ? obligAddrDet.getAddress() : null;
		String obligAddr1 = null;
		String obligAddr2 = null;
		if(obligAddrLst!=null && obligAddrLst.size()> zero && obligAddrLst.get(zero) != null){
			obligAddr1 = obligAddrLst.get(zero);
		}
		if(obligAddrLst!=null && obligAddrLst.size()> one && obligAddrLst.get(one) != null){
			obligAddr2 = obligAddrLst.get(one);
		}
		fillCellDetails(excelSheetObj, columnId, principal !=null ? principal.getLeName() : empty , ALOCConstants.ROW_SIX);
		fillCellDetails(excelSheetObj, columnId, principal !=null ? principal.getLeGoldId() : empty , ALOCConstants.ROW_SEVEN);
		/*fillCellDetails(excelSheetObj, columnId, principal !=null ? principal.getGeDivisionName() : empty , ALOCConstants.ROW_EIGHT);*/
		fillCellDetails(excelSheetObj, columnId, princAddrDet !=null ? princAddrDet.getName() : empty ,ALOCConstants.ROW_EIGHT);
		fillCellDetails(excelSheetObj, columnId, princAddr1 !=null ? princAddr1 : empty , ALOCConstants.ROW_NINE);
		fillCellDetails(excelSheetObj, columnId, princAddr2 !=null ? princAddr2 : empty , ALOCConstants.ROW_TEN);
		fillCellDetails(excelSheetObj, columnId, princAddrDet !=null ? princAddrDet.getCity() : empty , ALOCConstants.ROW_ELEVEN);
		fillCellDetails(excelSheetObj, columnId, princAddrDet !=null ? princAddrDet.getStateProvince() : empty , ALOCConstants.ROW_TWELVE);
		fillCellDetails(excelSheetObj, columnId, princAddrDet !=null ? princAddrDet.getZIPPostalCode() : empty , ALOCConstants.ROW_THIRTEEN);
		fillCellDetails(excelSheetObj, columnId, princAddrDet !=null ? princAddrDet.getCountry() : empty , ALOCConstants.ROW_FOURTEEN);
		fillCellDetails(excelSheetObj, columnId, princAddrDet !=null ? princAddrDet.getStateOfInc() : empty , ALOCConstants.ROW_FIFTEEN);
		fillCellDetails(excelSheetObj, columnId, obligAddrDet !=null ? obligAddrDet.getName() : empty , ALOCConstants.ROW_SIXTEEN);
		fillCellDetails(excelSheetObj, columnId, obligAddr1 !=null ? obligAddr1 : empty , ALOCConstants.ROW_SEVENTEEN);
		fillCellDetails(excelSheetObj, columnId, obligAddr2 !=null ? obligAddr2 : empty , ALOCConstants.ROW_EIGHTEEN);
		fillCellDetails(excelSheetObj, columnId, obligAddrDet !=null ? obligAddrDet.getCity() : empty , ALOCConstants.ROW_NINTEEN);
		fillCellDetails(excelSheetObj, columnId, obligAddrDet !=null ? obligAddrDet.getStateProvince() : empty , ALOCConstants.ROW_TWENTY);
		fillCellDetails(excelSheetObj, columnId, obligAddrDet !=null ? obligAddrDet.getZIPPostalCode() : empty , ALOCConstants.ROW_TWENTYONE);
		fillCellDetails(excelSheetObj, columnId, obligAddrDet !=null ? obligAddrDet.getCountry() : empty , ALOCConstants.ROW_TWENTYTWO);
	}
	
	/**
	 * This method is used to fill Rider DeliveryInstructions Details
	 * @param columnId
	 * @param requestDetails
	 * @param excelSheetObj
	 */
	private static void fillRiderDeliveryInstructions(int columnId , RequestDetails requestDetails,ExcelSheet excelSheetObj){
		String empty = ALOCConstants.EMPTY_STRING;
		//Delivery Instructions
		Rider rider = requestDetails.getRider();
		DeliveryInstructions deliveryInstr = (rider != null) ? rider.getDeliveryInstructions() : null;
		String deliveryType = null;
		String deliveryTypeVal = (deliveryInstr!= null) ? deliveryInstr.getDeliveryType() : null;
		if(deliveryTypeVal!=null && deliveryTypeVal.equalsIgnoreCase(ALOCConstants.TRUE_SMALL)){
			deliveryType = ALOCConstants.INPERSON_PICKUP;
		}
		if(deliveryTypeVal!=null && deliveryTypeVal.equalsIgnoreCase(ALOCConstants.FALSE)){
			deliveryType = ALOCConstants.PHYSICAL_DELIVERY;
		}
		String usePreAddrVal = (deliveryInstr!= null) ? deliveryInstr.getUsePreviousAddress() : null;
		String usePreAddr = null;
		if(usePreAddrVal!=null && usePreAddrVal.equalsIgnoreCase(ALOCConstants.PRINCIPALDETAILS)){
			usePreAddr = ALOCConstants.PRINCIPAL_DETAILS;
		}
		if(usePreAddrVal!=null && usePreAddrVal.equalsIgnoreCase(ALOCConstants.OBLIGEEDETAILS)){
			usePreAddr = ALOCConstants.OBLIGEE_DETAILS;
		}
		String ecopyMySelf = null;
		String ecopyMySelfVal = (deliveryInstr!= null) ? deliveryInstr.getEcopyMyself() : null;
		if(ecopyMySelfVal!= null && ecopyMySelfVal.equalsIgnoreCase(ALOCConstants.TRUE_SMALL)){ecopyMySelf = ALOCConstants.YES_CAP;}
		else{ecopyMySelf = ALOCConstants.NO_CAP;}
		String ecopyToOtherGE = null;
		String ecopyToOtherGEfVal = (deliveryInstr!= null) ? deliveryInstr.getEcopyOtherGEPerson() : null;
		if(ecopyToOtherGEfVal!= null && ecopyToOtherGEfVal.equalsIgnoreCase(ALOCConstants.TRUE_SMALL)){ecopyToOtherGE = ALOCConstants.YES_CAP;}
		else{ecopyToOtherGE = ALOCConstants.NO_CAP;}
		Recipient recipient = (deliveryInstr!= null) ? deliveryInstr.getRecipient() : null;
		WinnerDetails winnerDetails = requestDetails.getWinningBankDetails() != null ?requestDetails.getWinningBankDetails().getWinnerDetails() : null;
		String sbRefNumber = winnerDetails != null ? winnerDetails.getBankReferenceNumber() :null;
		fillCellDetails(excelSheetObj, columnId, deliveryType !=null ? deliveryType : empty, ALOCConstants.ROW_THIRTYTHREE);
		fillCellDetails(excelSheetObj, columnId, usePreAddr !=null ? usePreAddr : empty, ALOCConstants.ROW_THIRTYFOUR);
		fillCellDetails(excelSheetObj, columnId, deliveryInstr !=null ? deliveryInstr.getCompanyName() : empty, ALOCConstants.ROW_THIRTYFIVE);
		fillCellDetails(excelSheetObj, columnId, deliveryInstr !=null ? deliveryInstr.getFirstName() : empty, ALOCConstants.ROW_THIRTYSIX);
		fillCellDetails(excelSheetObj, columnId, deliveryInstr !=null ? deliveryInstr.getLastName() : empty, ALOCConstants.ROW_THIRTYSEVEN);
		fillCellDetails(excelSheetObj, columnId, deliveryInstr !=null ? deliveryInstr.getTitle() : empty, ALOCConstants.ROW_THIRTYEIGHT);
		fillCellDetails(excelSheetObj, columnId, deliveryInstr !=null ? deliveryInstr.getAddress1() : empty, ALOCConstants.ROW_THIRTYNINE);
		fillCellDetails(excelSheetObj, columnId, deliveryInstr !=null ? deliveryInstr.getAddress2() : empty, ALOCConstants.ROW_FORTY);
		fillCellDetails(excelSheetObj, columnId, deliveryInstr !=null ? deliveryInstr.getCity() : empty, ALOCConstants.ROW_FORTYONE);
		fillCellDetails(excelSheetObj, columnId, deliveryInstr !=null ? deliveryInstr.getStateProvince() : empty, ALOCConstants.ROW_FORTYTWO);
		fillCellDetails(excelSheetObj, columnId, deliveryInstr !=null ? deliveryInstr.getZIPPostalcode(): empty, ALOCConstants.ROW_FORTYTHREE);
		fillCellDetails(excelSheetObj, columnId, deliveryInstr !=null ? deliveryInstr.getCountry() : empty, ALOCConstants.ROW_FORTYFOUR);
		fillCellDetails(excelSheetObj, columnId, deliveryInstr !=null ? deliveryInstr.getPhoneNo() : empty, ALOCConstants.ROW_FORTYFIVE);
		fillCellDetails(excelSheetObj, columnId, deliveryInstr !=null ? deliveryInstr.getSpecialInstructions() : empty, ALOCConstants.ROW_FORTYSIX);
		fillCellDetails(excelSheetObj, columnId, ecopyMySelf !=null ? ecopyMySelf : empty, ALOCConstants.ROW_FORTYSEVEN);
		fillCellDetails(excelSheetObj, columnId, ecopyToOtherGE!=null ? ecopyToOtherGE : empty, ALOCConstants.ROW_FORTYEIGHT);
		if(ecopyToOtherGE != null && ecopyToOtherGE.equalsIgnoreCase(ALOCConstants.YES_CAP)){
			fillCellDetails(excelSheetObj, columnId, recipient !=null ? recipient.getRecipientFirstName() : empty, ALOCConstants.ROW_FORTYNINE);
			fillCellDetails(excelSheetObj, columnId, recipient !=null ? recipient.getRecipientLastName() : empty, ALOCConstants.ROW_FIFTY);
			fillCellDetails(excelSheetObj, columnId, recipient !=null ? recipient.getRecipientSsoId() : empty, ALOCConstants.ROW_FIFTYONE);
			fillCellDetails(excelSheetObj, columnId, recipient !=null ? recipient.getRecipientEmail() : empty, ALOCConstants.ROW_FIFTYTWO);
		}
		fillCellDetails(excelSheetObj, columnId, sbRefNumber !=null ? sbRefNumber : empty, ALOCConstants.ROW_FIFTYTHREE);
	}
	
	/**
	 * Method to set the AllIn/Local Commissions Values for the Current Bank Fees
	 * @param currFess
	 * @param allinValue
	 * @param localValue
	 * @return
	 */
	public static CurrentBankFees setAllInLocalCommValues(CurrentBankFees currFess,String allinValue,String localValue){
		if(StringUtils.isNotBlank(allinValue)){
			currFess.getCurrentWinningBank().getAllinComissions().setAllinCommissionValue(new BigDecimal(allinValue));
		}
		if(StringUtils.isNotBlank(localValue)){
			currFess.getCurrentWinningBank().getLocalComissions().setLocalCommissionValue(new BigDecimal(localValue));
		}
		
		return currFess;
	}
	
	/**
	 * Method to check valid Decimal with Fourteen decimals or Not
	 * @param decvalue
	 * @return
	 */
	public static Boolean isValidDecimalFourteen(BigDecimal decvalue){
		String expression = ALOCConstants.VALIDATE_DECIMAL_FOURTEEN;
		if(decvalue!=null){
			if(decvalue.signum() == ALOCConstants.BASE_NEGATIVE_VALUE || decvalue.compareTo(new BigDecimal(ALOCConstants.MIN_VALUE)) == ALOCConstants.BASE_VALUE || decvalue.compareTo(new BigDecimal(ALOCConstants.MIN_VALUE)) == ALOCConstants.MIN_VALUE)
				return false;
			return decvalue.toString().matches(expression);
		}
		return true;
	}
	
	/**
	 * This method is used to set the RequestSummary to RequestDetails
	 * 
	 */
	public static RequestDetails addRequestSummary(RequestDetails requestDetails) {
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
		return requestDetails;
	}
	
	/**
	 * @param requestorTransactionList
	 * @return
	 */
	public static boolean validateRequestorTransactions(List<RequestorTransaction> requestorTransactionList){
		boolean isSelectedRequest = false;

		if(requestorTransactionList != null & requestorTransactionList.size() > ALOCConstants.BASE_VALUE)
		{
			for(RequestorTransaction requestorTransaction : requestorTransactionList)
			{
				if(requestorTransaction.isSelectedRequest())
				{
					isSelectedRequest = true;
					break;
				}
			}
		}
		else
		{
			isSelectedRequest = false;
		}
		return isSelectedRequest;
	}
	

	/**
	 * This is used to render format data to html form to show it in the word document.
	 * @param formatDoc
	 * @return
	 */
	public static  String getFormatTemplateDoc(String formatDoc){
		StringBuilder builder = new StringBuilder();
		builder.append(ALOCConstants.FORMAT_TEPLATE_HTML)
		.append(ALOCConstants.FORMAT_TEPLATE_HEAD)
		.append(ALOCConstants.FORMAT_TEPLATE_STYLE)
		.append(ALOCConstants.FORMAT_TEPLATE_DISPLAY)
		.append(ALOCConstants.FORMAT_TEPLATE_COLOR)
		.append(ALOCConstants.FORMAT_TEPLATE_BORDER)		
		.append(ALOCConstants.FORMAT_TEPLATE_INSCOLOR)		
		.append(ALOCConstants.FORMAT_TEPLATE_TEXTDECORATION)
		.append(ALOCConstants.FORMAT_TEPLATE_STYLECLOSE)
		.append(ALOCConstants.FORMAT_TEPLATE_HEADCLOSE)
		.append(ALOCConstants.FORMAT_TEPLATE_BODY)
		.append(formatDoc)
		.append(ALOCConstants.FORMAT_TEPLATE_BODYCLOSE)
		.append(ALOCConstants.FORMAT_TEPLATE_HTMLCLOSE);
		return builder.toString();		
	}
	
	/**
	 * This is used to render format data to html form to show it in the word document.
	 * @param formatDoc
	 * @return
	 */
	public static  String getLeGoldIDByInstrumentType(RequestDetails requestDetails){
		String legalEntityGoldId = ALOCConstants.EMPTY_STRING;
		if(requestDetails.getInstrumentTypeId().intValue() ==InstrumentType.BANK_GUARANTEE.getId() 
				|| requestDetails.getInstrumentTypeId().intValue() ==InstrumentType.LOC.getId()){
			legalEntityGoldId = requestDetails.getTransactionParties().getTpApplicantDetails().getLeGoldId();			
		}else if(requestDetails.getInstrumentTypeId().intValue() ==InstrumentType.AMENDMENT.getId()){
			legalEntityGoldId = requestDetails.getAmendment().getTransactionParties().getTpApplicantDetails().getLeGoldId();
		}
		else if(requestDetails.getInstrumentTypeId().intValue() ==InstrumentType.SURETY_BOND.getId()){
			legalEntityGoldId = requestDetails.getPrincipal().getLeGoldId();
		}else if(requestDetails.getInstrumentTypeId().intValue() ==InstrumentType.RIDER.getId()){
			legalEntityGoldId = requestDetails.getRider().getPrincipal().getLeGoldId();
		}
		else if(requestDetails.getInstrumentTypeId().intValue() ==InstrumentType.DOCUMENT_LOC.getId()){
			legalEntityGoldId = requestDetails.getBeneficiaryDetails().getLeGoldId();
		}
		
		return legalEntityGoldId;		
	}
	
	/**
	 * This is used to render format data to html form to show it in the word document.
	 * @param formatDoc
	 * @return
	 */
	public static  String getInstrumentPurpose(RequestDetails requestDetails){
		String instrumentPurposeVal = ALOCConstants.EMPTY_STRING;
		if(requestDetails.getInstrumentTypeId().intValue() ==InstrumentType.BANK_GUARANTEE.getId() 
				|| requestDetails.getInstrumentTypeId().intValue() ==InstrumentType.LOC.getId()){
			instrumentPurposeVal = requestDetails.getTransactionParties().getInstrumentPurpose();			
		}else if(requestDetails.getInstrumentTypeId().intValue() ==InstrumentType.AMENDMENT.getId()){
			instrumentPurposeVal = requestDetails.getAmendment().getTransactionParties().getInstrumentPurpose();
		}	
		if(instrumentPurposeVal==null){
			instrumentPurposeVal=ALOCConstants.EMPTY_STRING;
		}
		return instrumentPurposeVal;		
	}
	
	/**
	 * This is used to get the selected Site Id's List for dashboard advance search site selection criteria
	 * @param selSiteList
	 * @return
	 */
	public static List<BigInteger> getSelectedSitesForAdvanceSearch(String selSiteList)
	{
		List<BigInteger> rightSelSiteList  = new ArrayList<BigInteger>();
		if(selSiteList != null && selSiteList.length() > ALOCConstants.BASE_VALUE)
		{
			StringTokenizer strToken = new StringTokenizer(selSiteList,ALOCConstants.COMMA);
			while(strToken.hasMoreTokens())
			{
				rightSelSiteList.add(new BigInteger(strToken.nextToken().toString()));
			}
		}
		return rightSelSiteList;
	}
	
	/**
	 * This is used to set the selected Site Id's List for dashboard advance search site selection criteria
	 * @param selSites
	 * @return
	 */
	public static String setSelectedSitesForAdvanceSearch(List<BigInteger> selSites)
	{
		String rightSelSites = ALOCConstants.EMPTY_STRING;
		if(selSites!=null && selSites.size()>ALOCConstants.BASE_VALUE){
			for(BigInteger SitesSel:selSites){
				if(SitesSel!=null){
					if(rightSelSites.length() == ALOCConstants.BASE_VALUE) {
						rightSelSites = SitesSel.toString(); }
					else {
						rightSelSites = rightSelSites+ALOCConstants.COMMA+SitesSel.toString(); }
				}
			}
		}
		return rightSelSites;
	}
	
	/**
	 * Method to check valid Phone number or Not
	 * @param phoneNumber
	 * @return
	 */
	public static Boolean isValidPhoneNumber(String phoneNumber){
		String numexpression = ALOCConstants.VALIDATE_PHONENUMBER_REGEXP;
		if(phoneNumber!=null){
			if(phoneNumber.trim().length() < 1){
				return false; 
			}
			else if (!(phoneNumber.matches(numexpression))){
				return false; 
			 }
		}
		return true;
	}
	
	/**
	 * Validation for given Expiration Date and time
	 * @param expDate
	 * @param hours
	 * @param minutes
	 * @param period
	 * @return
	 */
	public static boolean validateBidMemoExpirationDate(Calendar expDate,String hours,String minutes,String period) {
		if(expDate != null && (StringUtils.isNotBlank(hours) && Integer.parseInt(hours) >= ALOCConstants.BASE_VALUE 
			&& Integer.parseInt(hours) < ALOCConstants.BIDMAX_HOURS) && (StringUtils.isNotBlank(minutes)
			&& Integer.parseInt(minutes) >= ALOCConstants.BASE_VALUE && Integer.parseInt(minutes) < ALOCConstants.BIDMAX_MINUTES)){
			    Calendar currentDateCal = Calendar.getInstance(TimeZone.getTimeZone(ALOCConstants.BID_TIMEZONE), Locale.US);
			    Date curDateWithoutTime = expDate.getTime();
				Calendar expDateWithoutTimeCal = Calendar.getInstance();
				expDateWithoutTimeCal.setTime(curDateWithoutTime);
				expDateWithoutTimeCal.setTimeZone(TimeZone.getTimeZone(ALOCConstants.BID_TIMEZONE));
				
				currentDateCal.set(Calendar.HOUR, currentDateCal.getActualMinimum(Calendar.HOUR));
				currentDateCal.set(Calendar.HOUR_OF_DAY, currentDateCal.getActualMinimum(Calendar.HOUR_OF_DAY));
				currentDateCal.set(Calendar.MINUTE,      currentDateCal.getActualMinimum(Calendar.MINUTE));
				currentDateCal.set(Calendar.SECOND,      currentDateCal.getActualMinimum(Calendar.SECOND));
				currentDateCal.set(Calendar.MILLISECOND, currentDateCal.getActualMinimum(Calendar.MILLISECOND));
				
				expDateWithoutTimeCal.set(Calendar.HOUR, expDateWithoutTimeCal.getActualMinimum(Calendar.HOUR));
				expDateWithoutTimeCal.set(Calendar.HOUR_OF_DAY, expDateWithoutTimeCal.getActualMinimum(Calendar.HOUR_OF_DAY));
				expDateWithoutTimeCal.set(Calendar.MINUTE,      expDateWithoutTimeCal.getActualMinimum(Calendar.MINUTE));
				expDateWithoutTimeCal.set(Calendar.SECOND,      expDateWithoutTimeCal.getActualMinimum(Calendar.SECOND));
				expDateWithoutTimeCal.set(Calendar.MILLISECOND, expDateWithoutTimeCal.getActualMinimum(Calendar.MILLISECOND));
				
				if(expDateWithoutTimeCal.compareTo(currentDateCal) == 0)
				{
					Calendar currentTimeCal = Calendar.getInstance(TimeZone.getTimeZone(ALOCConstants.BID_TIMEZONE), Locale.US);
					Date curDate = expDate.getTime();
					Calendar expDateCal = Calendar.getInstance();
					expDateCal.setTime(curDate);
					expDateCal.setTimeZone(TimeZone.getTimeZone(ALOCConstants.BID_TIMEZONE));
					String seconds = ALOCConstants.BIDMIN_SECOUNDS;
					if(StringUtils.isNotBlank(hours)){
						if(StringUtils.isNotBlank(period)){
							if(period.equals(ALOCConstants.AM)){
								expDateCal.set(Calendar.HOUR, Integer.parseInt(hours));
						}else if(period.equals(ALOCConstants.PM)){
							expDateCal.set(Calendar.HOUR, Integer.parseInt(hours)+12);
						} }	}
					if(StringUtils.isNotBlank(minutes)){
						expDateCal.set(Calendar.MINUTE, Integer.parseInt(minutes));
					}
					if(StringUtils.isNotBlank(seconds)){
						expDateCal.set(Calendar.SECOND, Integer.parseInt(seconds));
						currentTimeCal.set(Calendar.SECOND, Integer.parseInt(seconds));
					}
					if (expDateCal.compareTo(currentTimeCal) >= ALOCConstants.BASE_VALUE) {
							return true;
					} else {
							return false;
					}
				}
		}
		return true;
	}
	
	/**
	 * Validation for given Expiration Date
	 * @param expDate
	 * @param bidOrOptFlag
	 * @return
	 */
	public static boolean validateBidMemoExpDateWithoutTime(Calendar expDate) {
		if (expDate != null) {
			Calendar currentDateCal = Calendar.getInstance(TimeZone.getTimeZone(ALOCConstants.BID_TIMEZONE), Locale.US);
		    Date curDateWithoutTime = expDate.getTime();
			Calendar expDateWithoutTimeCal = Calendar.getInstance();
			expDateWithoutTimeCal.setTime(curDateWithoutTime);
			expDateWithoutTimeCal.setTimeZone(TimeZone.getTimeZone(ALOCConstants.BID_TIMEZONE));
			
			currentDateCal.set(Calendar.HOUR, currentDateCal.getActualMinimum(Calendar.HOUR));
			currentDateCal.set(Calendar.HOUR_OF_DAY, currentDateCal.getActualMinimum(Calendar.HOUR_OF_DAY));
			currentDateCal.set(Calendar.MINUTE,      currentDateCal.getActualMinimum(Calendar.MINUTE));
			currentDateCal.set(Calendar.SECOND,      currentDateCal.getActualMinimum(Calendar.SECOND));
			currentDateCal.set(Calendar.MILLISECOND, currentDateCal.getActualMinimum(Calendar.MILLISECOND));
			
			expDateWithoutTimeCal.set(Calendar.HOUR, expDateWithoutTimeCal.getActualMinimum(Calendar.HOUR));
			expDateWithoutTimeCal.set(Calendar.HOUR_OF_DAY, expDateWithoutTimeCal.getActualMinimum(Calendar.HOUR_OF_DAY));
			expDateWithoutTimeCal.set(Calendar.MINUTE,      expDateWithoutTimeCal.getActualMinimum(Calendar.MINUTE));
			expDateWithoutTimeCal.set(Calendar.SECOND,      expDateWithoutTimeCal.getActualMinimum(Calendar.SECOND));
			expDateWithoutTimeCal.set(Calendar.MILLISECOND, expDateWithoutTimeCal.getActualMinimum(Calendar.MILLISECOND));
			if (expDateWithoutTimeCal.compareTo(currentDateCal) >= ALOCConstants.BASE_VALUE) {
				return true;
			} else {
				return false;
			}
		} else {
			return true;
		}
	}
	
	/**
	 * Method to Assign the decimal digits to the String in CompetingBidReply Tab of Taxonomy screen
	 * @param comBidReplies
	 * @return CurrentBankFees
	 */
	public static CurrentBankFees getCompetingBidValuesAsString(CurrentBankFees comBidReplies){
		
		if(comBidReplies.getCurrentWinningBank() != null){
			CurrentWinningBank curWinBank = comBidReplies.getCurrentWinningBank();
			if(curWinBank.getAllinComissions() != null ){
				AllinComissions allInComissions = getAllinComissionsValuesAsString(curWinBank.getAllinComissions());
				curWinBank.setAllinComissions(allInComissions);
			}
			if(curWinBank.getLocalComissions() != null ){
				LocalComissions localComissions = getLocalComissionsValuesAsString(curWinBank.getLocalComissions());
				curWinBank.setLocalComissions(localComissions);
			}
			if(curWinBank.getOnetimeFees() != null ){
				OnetimeFees onetimeFees = getOnetimeFeesValuesAsString(curWinBank.getOnetimeFees());
				curWinBank.setOnetimeFees(onetimeFees);
			}
		}
		
		if(comBidReplies.getParticipantBanks() != null && comBidReplies.getParticipantBanks().size() > ALOCConstants.BASE_VALUE){
			for(ParticipantBank participantBanks : comBidReplies.getParticipantBanks()){
				if(participantBanks.getAllinComissions() != null ){
					AllinComissions allInComissions = getAllinComissionsValuesAsString(participantBanks.getAllinComissions());
					participantBanks.setAllinComissions(allInComissions);
				}
				if(participantBanks.getLocalComissions() != null ){
					LocalComissions localComissions = getLocalComissionsValuesAsString(participantBanks.getLocalComissions());
					participantBanks.setLocalComissions(localComissions);
				}
				if(participantBanks.getOnetimeFees() != null ){
					OnetimeFees onetimeFees = getOnetimeFeesValuesAsString(participantBanks.getOnetimeFees());
					participantBanks.setOnetimeFees(onetimeFees);
				}
			}
		}
		return comBidReplies;
	}
	
	/**
	 * Method to Assign the decimal digits to the String in CompetingBidReply Tab of Taxonomy screen
	 * @param allInComissions
	 * @return AllinComissions
	 */
	public static AllinComissions getAllinComissionsValuesAsString(AllinComissions allInComissions){
		if(allInComissions.getAllinCommissionValue() != null){
			allInComissions.setAllinCommissionValueString(allInComissions.getAllinCommissionValue().toString());
		}
		if(allInComissions.getAmendmentTransactionFee() != null){
			allInComissions.setAmendmentTransactionFeeString(getStringWithDecimalValue(allInComissions.getAmendmentTransactionFee().toString()));
		}
		return allInComissions;
	}
	
	/**
	 * Method to Assign the decimal digits to the String in CompetingBidReply Tab of Taxonomy screen
	 * @param localComissions
	 * @return LocalComissions
	 */
	public static LocalComissions getLocalComissionsValuesAsString(LocalComissions localComissions){
		if(localComissions.getLocalCommissionValue() != null){
			localComissions.setLocalCommissionValueString(localComissions.getLocalCommissionValue().toString());
		}
		if(localComissions.getLocalAmendmentTransactionFee() != null){
			localComissions.setLocalAmendmentTransactionFeeString(getStringWithDecimalValue(localComissions.getLocalAmendmentTransactionFee().toString()));
		}
		return localComissions;
	}
	
	/**
	 * Method to Assign the decimal digits to the String in CompetingBidReply Tab of Taxonomy screen
	 * @param onetimeFees
	 * @return OnetimeFees
	 */
	public static OnetimeFees getOnetimeFeesValuesAsString(OnetimeFees onetimeFees){
		if(onetimeFees.getIncidentalAdminFee() != null){
			onetimeFees.setIncidentalAdminFeeString(getStringWithDecimalValue(onetimeFees.getIncidentalAdminFee().toString()));
		}
		if(onetimeFees.getOther() != null){
			onetimeFees.setOtherString(getStringWithDecimalValue(onetimeFees.getOther().toString()));
		}
		if(onetimeFees.getStampTaxes() != null){
			onetimeFees.setStampTaxesString(getStringWithDecimalValue(onetimeFees.getStampTaxes().toString()));
		}
		if(onetimeFees.getVatTaxes() != null){
			onetimeFees.setVatTaxesString(getStringWithDecimalValue(onetimeFees.getVatTaxes().toString()));
		}
		return onetimeFees;
	}
	
	/**
	 * Method to check valid creditLetterNo or Not
	 * @param creditLetterNo
	 * @return
	 */
	public static Boolean isValidCreditNo(String creditLetterNo){
		String numexpression = ALOCConstants.VALIDATE_CREDITNUMBER_REGEXP;
		if(creditLetterNo!=null){
			if(creditLetterNo.trim().length() < 1){
				return false; 
			}
			else if (!(creditLetterNo.matches(numexpression))){
				return false; 
			 }
		}
		return true;
	}
	
	/**
	 * method to compare two dates 
	 * @param firstDate
	 * @param secondDate
	 * @return
	 */
	public static boolean compareTwoDates(Calendar firstDate,Calendar secondDate) {
		 
		if(firstDate != null && secondDate != null){
			firstDate.setTime(firstDate.getTime());
			secondDate.setTime(secondDate.getTime());
			firstDate.setTimeZone(TimeZone.getTimeZone(ALOCConstants.BID_TIMEZONE));
		    secondDate.setTimeZone(TimeZone.getTimeZone(ALOCConstants.BID_TIMEZONE));
			 
				firstDate.set(Calendar.HOUR, firstDate.getActualMinimum(Calendar.HOUR));
				firstDate.set(Calendar.HOUR_OF_DAY, firstDate.getActualMinimum(Calendar.HOUR_OF_DAY));
				firstDate.set(Calendar.MINUTE,      firstDate.getActualMinimum(Calendar.MINUTE));
				firstDate.set(Calendar.SECOND,      firstDate.getActualMinimum(Calendar.SECOND));
				firstDate.set(Calendar.MILLISECOND, firstDate.getActualMinimum(Calendar.MILLISECOND));
				
				secondDate.set(Calendar.HOUR, secondDate.getActualMinimum(Calendar.HOUR));
				secondDate.set(Calendar.HOUR_OF_DAY, secondDate.getActualMinimum(Calendar.HOUR_OF_DAY));
				secondDate.set(Calendar.MINUTE, secondDate.getActualMinimum(Calendar.MINUTE));
				secondDate.set(Calendar.SECOND, secondDate.getActualMinimum(Calendar.SECOND));
				secondDate.set(Calendar.MILLISECOND, secondDate.getActualMinimum(Calendar.MILLISECOND));
				
				if(firstDate.compareTo(secondDate) == -1)
				{
			        return false;
				}
		}
		return true;
	}
	/**
	 * method to check bond type is contact or not 
	 * @param BondType
	 * @return
	 */
	public static boolean isContractBond(String BondType) {
		 
		if(StringUtils.isNotBlank(BondType) && BondType.replace(ALOCConstants.EMPTY_SPACE_STRING, ALOCConstants.EMPTY_STRING).equals(ALOCConstants.CONTRACTBONDS)){
			        return true;
		}
		return false;
	}
	
	/**
	 * method to set the  AddressDetails from BondReqDtls
	 * @param requestDetails
	 * @return
	 */
	public static RequestDetails setAddressDetails(RequestDetails requestDetails) {
		requestDetails.getAddressDtls().setBondReqContactPerson(requestDetails.getBondReqDtls().getContactPerson());
		requestDetails.getAddressDtls().setBondReqName(requestDetails.getBondReqDtls().getName());
		requestDetails.getAddressDtls().setBondReqEmailAddress(requestDetails.getBondReqDtls().getEmailAddress());
		requestDetails.getAddressDtls().setBondReqPhoneNo(requestDetails.getBondReqDtls().getPhoneNo());
		requestDetails.getAddressDtls().setBondReqFaxNo(requestDetails.getBondReqDtls().getFaxNo());
		return requestDetails;
	}
	
	/**
	 * method to set the  BondReqDtls from AddressDetails
	 * @param requestDetails
	 * @return
	 */
	public static RequestDetails setBondReqDtls(RequestDetails requestDetails) {
		requestDetails.getBondReqDtls().setContactPerson(requestDetails.getAddressDtls().getBondReqContactPerson());
		requestDetails.getBondReqDtls().setName(requestDetails.getAddressDtls().getBondReqName());
		requestDetails.getBondReqDtls().setEmailAddress(requestDetails.getAddressDtls().getBondReqEmailAddress());
		requestDetails.getBondReqDtls().setPhoneNo(requestDetails.getAddressDtls().getBondReqPhoneNo());
		requestDetails.getBondReqDtls().setFaxNo(requestDetails.getAddressDtls().getBondReqFaxNo());
		return requestDetails;
	}
	/**
	 * Checking Treasury Approver validation is required for Rider or not.
	 * @return
	 */
	public static boolean riderTreasuryApproverValidationRequired(BigDecimal validationUsdAmount)
	{
		boolean result = false;
		RequestDetails requestDetails = ALOCContext.getActiveRequest().getModel();
		BigDecimal riderWorkflowAmt = null;
		//new
		if(requestDetails.getRider()!=null)
		{
			riderWorkflowAmt = requestDetails.getRider().getRiderWorkflowAmt();
		}
		if (validationUsdAmount != null && riderWorkflowAmt != null) {
			int compareVal = validationUsdAmount.compareTo(riderWorkflowAmt);
			if (compareVal == ALOCConstants.MIN_VALUE) {
				result= true;
			} else if (compareVal == ALOCConstants.BASE_NEGATIVE_VALUE) {
				result= false;
			}
		
		}
		return result;
	}	
	
	 
	/**
	* Checking amendment fields are modified or not.
	* @return
	*/
	public static boolean amdModifiedValidation()
	{
	RequestDetails requestDetails = ALOCContext.getActiveRequest().getModel();
	if(requestDetails!=null && requestDetails.getAmendment()!=null){

	Amendment amendment= requestDetails.getAmendment();
	 TransactionParties  transactionParties = null;
	
	if(StringUtils.isNotBlank(amendment.getOtherChanges())){
		return true;
	}
	if(amendment.getAmendmentInstrumentAmountCurr().getAmtOfIncreaseOrDecrease()!=null && StringUtils.isNotBlank(amendment.getAmendmentInstrumentAmountCurr().getOperation())){
		return true;
	}
	if(amendment.getExpiryDate().getRevisedExpiryDate()!=null && amendment.getExpiryDate().getCurrentExpiryDate()!=null){
		if(compareDates(amendment.getExpiryDate().getRevisedExpiryDate(),amendment.getExpiryDate().getCurrentExpiryDate()) == true){
		return true;
		}
	}
	if(amendment.getExpiryDate().getUSRevisedExpiryDate()!=null && amendment.getExpiryDate().getUSCurrentExpiryDate()!=null ){
		if(compareDates(amendment.getExpiryDate().getUSRevisedExpiryDate(),amendment.getExpiryDate().getUSCurrentExpiryDate()) == true){
		return true;
		}
	}
	if(amendment.getAmendmentRequestId()!=null && amendment.getAmendmentRequestId().endsWith("-1")){
		transactionParties = requestDetails.getTransactionParties();
	}else if(requestDetails.getPreviousAmendment()!=null){
			transactionParties = requestDetails.getPreviousAmendment().getTransactionParties();
	}	
	if(transactionParties!=null){
	if(StringUtils.isNotBlank(requestDetails.getSiteTypeName()) && requestDetails.getSiteTypeName().equalsIgnoreCase(ALOCConstants.FINANCIAL_BUSINESS) && requestDetails.getTransactionParties().isTriPartyRequestFlag()){
	if(StringUtils.isNotBlank(amendment.getTransactionParties().getTriPartyApplicant().getName()) && StringUtils.isNotBlank(transactionParties.getTriPartyApplicant().getName()) && amendment.getTransactionParties().getTriPartyApplicant().getName().compareToIgnoreCase(transactionParties.getTriPartyApplicant().getName())!=0){
		return true;
	}
	if(StringUtils.isNotBlank(amendment.getTransactionParties().getTriPartyApplicant().getAddress().get(0)) && StringUtils.isNotBlank(transactionParties.getTriPartyApplicant().getAddress().get(0)) && amendment.getTransactionParties().getTriPartyApplicant().getAddress().get(0).compareToIgnoreCase(transactionParties.getTriPartyApplicant().getAddress().get(0))!=0){
		return true;
	}
	if(StringUtils.isNotBlank(amendment.getTransactionParties().getTriPartyApplicant().getCity()) && StringUtils.isNotBlank(transactionParties.getTriPartyApplicant().getCity()) && amendment.getTransactionParties().getTriPartyApplicant().getCity().compareToIgnoreCase(transactionParties.getTriPartyApplicant().getCity())!=0){
		return true;
	}
	if(StringUtils.isNotBlank(amendment.getTransactionParties().getTriPartyApplicant().getZIPPostalCode()) && StringUtils.isNotBlank(transactionParties.getTriPartyApplicant().getZIPPostalCode()) && amendment.getTransactionParties().getTriPartyApplicant().getZIPPostalCode().compareToIgnoreCase(transactionParties.getTriPartyApplicant().getZIPPostalCode())!=0){
		return true;
	}
	if(StringUtils.isNotBlank(amendment.getTransactionParties().getTriPartyApplicant().getCountry()) && StringUtils.isNotBlank(transactionParties.getTriPartyApplicant().getCountry()) && amendment.getTransactionParties().getTriPartyApplicant().getCountry().compareToIgnoreCase(transactionParties.getTriPartyApplicant().getCountry())!=0){
		return true;
	}
	}else{
	
	if(StringUtils.isNotBlank(amendment.getTransactionParties().getTpApplicantDetails().getAddressDtls().getName()) && StringUtils.isNotBlank(transactionParties.getTpApplicantDetails().getAddressDtls().getName()) && amendment.getTransactionParties().getTpApplicantDetails().getAddressDtls().getName().compareToIgnoreCase(transactionParties.getTpApplicantDetails().getAddressDtls().getName())!=0){
		return true;
	}
	if(StringUtils.isNotBlank(amendment.getTransactionParties().getTpApplicantDetails().getAddressDtls().getAddress().get(0)) && StringUtils.isNotBlank(transactionParties.getTpApplicantDetails().getAddressDtls().getAddress().get(0)) && amendment.getTransactionParties().getTpApplicantDetails().getAddressDtls().getAddress().get(0).compareToIgnoreCase(transactionParties.getTpApplicantDetails().getAddressDtls().getAddress().get(0))!=0){
		return true;
	}
	if(StringUtils.isNotBlank(amendment.getTransactionParties().getTpApplicantDetails().getAddressDtls().getCity()) && StringUtils.isNotBlank(transactionParties.getTpApplicantDetails().getAddressDtls().getCity()) && amendment.getTransactionParties().getTpApplicantDetails().getAddressDtls().getCity().compareToIgnoreCase(transactionParties.getTpApplicantDetails().getAddressDtls().getCity())!=0){
		return true;
	}
	if(StringUtils.isNotBlank(amendment.getTransactionParties().getTpApplicantDetails().getAddressDtls().getZIPPostalCode()) && StringUtils.isNotBlank(transactionParties.getTpApplicantDetails().getAddressDtls().getZIPPostalCode()) && amendment.getTransactionParties().getTpApplicantDetails().getAddressDtls().getZIPPostalCode().compareToIgnoreCase(transactionParties.getTpApplicantDetails().getAddressDtls().getZIPPostalCode())!=0){
		return true;
	}
	if(StringUtils.isNotBlank(amendment.getTransactionParties().getTpApplicantDetails().getAddressDtls().getCountry()) && StringUtils.isNotBlank(transactionParties.getTpApplicantDetails().getAddressDtls().getCountry()) && amendment.getTransactionParties().getTpApplicantDetails().getAddressDtls().getCountry().compareToIgnoreCase(transactionParties.getTpApplicantDetails().getAddressDtls().getCountry())!=0){
		return true;
	}
	}
	if(StringUtils.isNotBlank(amendment.getTransactionParties().getCustomer().getAddressDtls().getName()) && StringUtils.isNotBlank(transactionParties.getCustomer().getAddressDtls().getName()) && amendment.getTransactionParties().getCustomer().getAddressDtls().getName().compareToIgnoreCase(transactionParties.getCustomer().getAddressDtls().getName())!=0){
		return true;
	}
	if(StringUtils.isNotBlank(amendment.getTransactionParties().getCustomer().getAddressDtls().getAddress().get(0)) && StringUtils.isNotBlank(transactionParties.getCustomer().getAddressDtls().getAddress().get(0)) && amendment.getTransactionParties().getCustomer().getAddressDtls().getAddress().get(0).compareToIgnoreCase(transactionParties.getCustomer().getAddressDtls().getAddress().get(0))!=0){
		return true;
	}
	if(StringUtils.isNotBlank(amendment.getTransactionParties().getCustomer().getAddressDtls().getCity()) && StringUtils.isNotBlank(transactionParties.getCustomer().getAddressDtls().getCity()) && amendment.getTransactionParties().getCustomer().getAddressDtls().getCity().compareToIgnoreCase(transactionParties.getCustomer().getAddressDtls().getCity())!=0){
		return true;
	}
	if(StringUtils.isNotBlank(amendment.getTransactionParties().getCustomer().getAddressDtls().getZIPPostalCode()) && StringUtils.isNotBlank(transactionParties.getCustomer().getAddressDtls().getZIPPostalCode()) && amendment.getTransactionParties().getCustomer().getAddressDtls().getZIPPostalCode().compareToIgnoreCase(transactionParties.getCustomer().getAddressDtls().getZIPPostalCode())!=0){
		return true;
	}
	if(StringUtils.isNotBlank(amendment.getTransactionParties().getCustomer().getAddressDtls().getCountry()) && StringUtils.isNotBlank(transactionParties.getCustomer().getAddressDtls().getCountry()) && amendment.getTransactionParties().getCustomer().getAddressDtls().getCountry().compareToIgnoreCase(transactionParties.getCustomer().getAddressDtls().getCountry())!=0){
		return true;
	}
	}
	}
	return false;
	}
	
	/**
	 * method to compare two dates 
	 * @param firstDate
	 * @param secondDate
	 * @return
	 */
	public static boolean compareDates(Calendar firstDate,Calendar secondDate) {
		 
		if(firstDate != null && secondDate != null){
			firstDate.setTime(firstDate.getTime());
			secondDate.setTime(secondDate.getTime());
			firstDate.setTimeZone(TimeZone.getTimeZone(ALOCConstants.BID_TIMEZONE));
		    secondDate.setTimeZone(TimeZone.getTimeZone(ALOCConstants.BID_TIMEZONE));
			 
				firstDate.set(Calendar.HOUR, firstDate.getActualMinimum(Calendar.HOUR));
				firstDate.set(Calendar.HOUR_OF_DAY, firstDate.getActualMinimum(Calendar.HOUR_OF_DAY));
				firstDate.set(Calendar.MINUTE,      firstDate.getActualMinimum(Calendar.MINUTE));
				firstDate.set(Calendar.SECOND,      firstDate.getActualMinimum(Calendar.SECOND));
				firstDate.set(Calendar.MILLISECOND, firstDate.getActualMinimum(Calendar.MILLISECOND));
				
				secondDate.set(Calendar.HOUR, secondDate.getActualMinimum(Calendar.HOUR));
				secondDate.set(Calendar.HOUR_OF_DAY, secondDate.getActualMinimum(Calendar.HOUR_OF_DAY));
				secondDate.set(Calendar.MINUTE, secondDate.getActualMinimum(Calendar.MINUTE));
				secondDate.set(Calendar.SECOND, secondDate.getActualMinimum(Calendar.SECOND));
				secondDate.set(Calendar.MILLISECOND, secondDate.getActualMinimum(Calendar.MILLISECOND));
				
				if(firstDate.compareTo(secondDate) != 0)
				{
			        return true;
				}
		}
		return false;
	}
	
	/**
	 * This method is used to convert minimum 2 decimal points 
	 * @param strWithoutDecimal
	 * @return
	 */
	public static String getStringWithDecimalValue(String strWithoutDecimal) {
		String strWithDecimal = ALOCConstants.EMPTY_STRING;
		
		if(StringUtils.isNotBlank(strWithoutDecimal)){
			  DecimalFormat df = new DecimalFormat(ALOCConstants.STRING_DECIMAL_VALUE); 
			  BigDecimal val = new BigDecimal(strWithoutDecimal);
			  strWithDecimal = df.format(val);
		  }
		return strWithDecimal;
	}
	
	/**
	 * This method is used to set null for the BigDecimal values which are equal to 0 
	 * @param cumulativeFee
	 * @return
	 */
	public static void removeBigDecimalZeroValues(CumulativeFeeAdjustments cumulativeFee) {
		int zero = ALOCConstants.BASE_VALUE;
		if(cumulativeFee.getVATAdditionalAmt() != null && cumulativeFee.getVATAdditionalAmt().compareTo(new BigDecimal(ALOCConstants.BASE_STRING_VALUE)) == zero){
			cumulativeFee.setVATAdditionalAmt(null);
		}
		if(cumulativeFee.getStampAdditionalAmt() != null && cumulativeFee.getStampAdditionalAmt().compareTo(new BigDecimal(ALOCConstants.BASE_STRING_VALUE)) == zero){
			cumulativeFee.setStampAdditionalAmt(null);
		}
		if(cumulativeFee.getIncidentalAdditionalAmt()!=null&&cumulativeFee.getIncidentalAdditionalAmt().compareTo(new BigDecimal(ALOCConstants.BASE_STRING_VALUE))==zero){
			cumulativeFee.setIncidentalAdditionalAmt(null);
		}
		if(cumulativeFee.getOtherAdditionalAmt() != null && cumulativeFee.getOtherAdditionalAmt().compareTo(new BigDecimal(ALOCConstants.BASE_STRING_VALUE)) == zero){
			cumulativeFee.setOtherAdditionalAmt(null);
		}
		if(cumulativeFee.getAdjustmentAmt() != null && cumulativeFee.getAdjustmentAmt().compareTo(new BigDecimal(ALOCConstants.BASE_STRING_VALUE)) == zero){
			cumulativeFee.setAdjustmentAmt(null);
		}
	}
	
	/**
	 * This method is used to set null for the OneTimeFee BigDecimal values which are equal to 0 
	 * @param cumulativeFee
	 * @return
	 */
	public static void removeOntimFeeBigDecimalZeroValues(OneTimeFeesDetails oneTimeFee) {
		int zero = ALOCConstants.BASE_VALUE;
		if(oneTimeFee.getVATTaxes() != null && oneTimeFee.getVATTaxes().compareTo(new BigDecimal(ALOCConstants.BASE_STRING_VALUE)) == zero){
			oneTimeFee.setVATTaxes(null);
		}
		if(oneTimeFee.getStampTaxes() != null && oneTimeFee.getStampTaxes().compareTo(new BigDecimal(ALOCConstants.BASE_STRING_VALUE)) == zero){
			oneTimeFee.setStampTaxes(null);
		}
		if(oneTimeFee.getIncidentalAdminFee()!=null&&oneTimeFee.getIncidentalAdminFee().compareTo(new BigDecimal(ALOCConstants.BASE_STRING_VALUE))==zero){
			oneTimeFee.setIncidentalAdminFee(null);
		}
		if(oneTimeFee.getOther() != null && oneTimeFee.getOther().compareTo(new BigDecimal(ALOCConstants.BASE_STRING_VALUE)) == zero){
			oneTimeFee.setOther(null);
		}
	}
}
