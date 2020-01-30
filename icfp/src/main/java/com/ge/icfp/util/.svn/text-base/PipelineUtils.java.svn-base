/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: PipelineUtils.java
 * Purpose: PipelineUtils is a utility class to format pipeline data before displaying
 */
package com.ge.icfp.util;

import static com.ge.icfp.common.constants.ICFPConstants.CERTFYCM;
import static com.ge.icfp.common.constants.ICFPConstants.CERTFYFO;
import static com.ge.icfp.common.constants.ICFPConstants.CLOSEREQ;
import static com.ge.icfp.common.constants.ICFPConstants.CPA;
import static com.ge.icfp.common.constants.ICFPConstants.DRAFT;
import static com.ge.icfp.common.constants.ICFPConstants.FIVE;
import static com.ge.icfp.common.constants.ICFPConstants.FOUR;
import static com.ge.icfp.common.constants.ICFPConstants.HIGH;
import static com.ge.icfp.common.constants.ICFPConstants.IDAGEAG;
import static com.ge.icfp.common.constants.ICFPConstants.IDAGREVW;
import static com.ge.icfp.common.constants.ICFPConstants.MEDIUM;
import static com.ge.icfp.common.constants.ICFPConstants.NINE;
import static com.ge.icfp.common.constants.ICFPConstants.ONE;
import static com.ge.icfp.common.constants.ICFPConstants.PLERIVEW;
import static com.ge.icfp.common.constants.ICFPConstants.RISKREVW;
import static com.ge.icfp.common.constants.ICFPConstants.SEVENTEEN;
import static com.ge.icfp.common.constants.ICFPConstants.SIX;
import static com.ge.icfp.common.constants.ICFPConstants.SOCASHMG;
import static com.ge.icfp.common.constants.ICFPConstants.SOCOUNTX;
import static com.ge.icfp.common.constants.ICFPConstants.SOFRTOFF;
import static com.ge.icfp.common.constants.ICFPConstants.SOMIDOFF;
import static com.ge.icfp.common.constants.ICFPConstants.SOTLEGAL;
import static com.ge.icfp.common.constants.ICFPConstants.SOTPRICE;
import static com.ge.icfp.common.constants.ICFPConstants.SOTRESTX;
import static com.ge.icfp.common.constants.ICFPConstants.STANDARD;
import static com.ge.icfp.common.constants.ICFPConstants.TESGREVW;
import static com.ge.icfp.common.constants.ICFPConstants.THREE;
import static com.ge.icfp.common.constants.ICFPConstants.TWENTY;
import static com.ge.icfp.common.constants.ICFPConstants.TWENTYONE;
import static com.ge.icfp.common.constants.ICFPConstants.TWENTYTHREE;
import static com.ge.icfp.common.constants.ICFPConstants.TWO;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.ge.icfp.common.constants.ICFPConstants;
import com.ge.icfp.model.DealRequest;
import com.ge.icfp.model.DealRequest.StatusInfo;
import com.ge.icfp.model.DealRequests;
import com.ge.icfp.pipeline.form.ChartInfo;
import com.ge.icfp.pipeline.form.PipelineDetails;
import com.ge.icfp.tag.DealManager;
import com.hydus.wff.core.exception.HWFServiceException;
import com.hydus.wff.core.exception.HWFStubException;
/**
 * 
 * @author arijit.biswas
 *
 */
public class PipelineUtils {
	private static final String DATE_DISPLAY_FORMAT = "MMM dd, yyyy";
	private static final String CURRENCY_FORMAT = "###,###.##";
	
	/**
	 * 
	 * @param dealCollection {@link DealRequest}
	 * @return {@link List}
	 * @throws ParseException 
	 * @throws HWFStubException 
	 * @throws HWFServiceException 
	 */
	public static List<PipelineDetails> populatePipelineMgmt(DealRequests dealCollection, HttpServletRequest request) throws ParseException, HWFServiceException, HWFStubException{
		
		
		String productType = null;
		Map<String, String> dealCategoryName = DealManager.getAllDealCategories(request);
		Map<String, String> wfStageDeacMap = DealManager.getWorkflowStageDescMap(request);
		List<DealRequest> allDealReq=dealCollection.getDealRequests();
		List<PipelineDetails> pipelineDetails = new LinkedList<PipelineDetails>();
		DateFormat dateFormat = new SimpleDateFormat(DATE_DISPLAY_FORMAT);
		DecimalFormat currencyFormat = new DecimalFormat(CURRENCY_FORMAT);
		for (DealRequest eachDeal : allDealReq) {
			PipelineDetails pd = new PipelineDetails();
			pd.setRequestID(String.valueOf(eachDeal.getDealSeqId()));
			pd.setUniqueId(eachDeal.getUniqueId());
			pd.setDealName(eachDeal.getDealName());
			pd.setTransOwnerSsoId(eachDeal.getTransOwnerSsoId());
			productType = eachDeal.getProductTypeCollection();
			if(CPA.equals(productType)){
				pd.setDebtValue("-");
				pd.setEquityValue("-");
			}else{
				String debtValue = (StringUtils.isNotBlank(eachDeal.getDebtValue())) ? currencyFormat.format(new BigDecimal(eachDeal.getDebtValue())) : "-";
				pd.setDebtValue(debtValue);
				String equityValue = (StringUtils.isNotBlank(eachDeal.getEquityValue())) ? currencyFormat.format(new BigDecimal(eachDeal.getEquityValue())) : "-";
				pd.setEquityValue(equityValue);
			}
			if(eachDeal.getDealCategoryId() != null){
				pd.setDealCategory(dealCategoryName.get(String.valueOf(eachDeal.getDealCategoryId())));
			}else{
				pd.setDealCategory("-");
			}
		
			pd.setProductTypeCollection(eachDeal.getProductTypeCollection());
			pd.setResponsibleRegion(eachDeal.getResponsibleRegion());
			if(eachDeal.getValueDt() != null) {
				pd.setValueDate(dateFormat.format(eachDeal.getValueDt().toGregorianCalendar().getTime()));
			}
			if(eachDeal.getRequestDt() != null) {
				pd.setRequestDate(dateFormat.format(eachDeal.getRequestDt().toGregorianCalendar().getTime()));
			}
			pd.setNoOfDaysRemaining(eachDeal.getNumberOfDaysRem());
			pd.setPriority(eachDeal.getPriority());
			pd.setStatus(getDealStatus(eachDeal.getWFStage()));
			pd.setWorkFlowState(wfStageDeacMap.get(eachDeal.getWFStage()));
			getStatusInfoChart(eachDeal, pd, request);
			
			pipelineDetails.add(pd);
		}
		
		return pipelineDetails;
	}
	/**
	 * 
	 * @param dealCollection
	 * @param request
	 * @return
	 * @throws ParseException
	 * @throws HWFServiceException
	 * @throws HWFStubException
	 */
	public static List<PipelineDetails> populatePipelineSearch(DealRequests dealCollection, HttpServletRequest request, String pipelineType ) throws ParseException, HWFServiceException, HWFStubException{
		
		Map<String, String> dealCategoryName = DealManager.getAllDealCategories(request);
		Map<String, String> wfStageDeacMap = DealManager.getWorkflowStageDescMap(request);
		List<DealRequest> allDealReq=dealCollection.getDealRequests();
		List<PipelineDetails> pipelineDetails = new LinkedList<PipelineDetails>();
		DateFormat dateFormat = new SimpleDateFormat(DATE_DISPLAY_FORMAT);
		DecimalFormat currencyFormat = new DecimalFormat(CURRENCY_FORMAT);
		for (DealRequest eachDeal : allDealReq) {
			PipelineDetails pd = new PipelineDetails();
			pd.setRequestID(Integer.toString(eachDeal.getDealSeqId()));
			pd.setUniqueId(eachDeal.getUniqueId());
			pd.setDealName(eachDeal.getDealName());
			if(!StringUtils.isEmpty(eachDeal.getFirstName()) && !StringUtils.isEmpty(eachDeal.getLastName())){
				pd.setTransOwnerSsoId(eachDeal.getLastName()+", "+eachDeal.getFirstName());
			}else{
				pd.setTransOwnerSsoId("-");
			}
			if(!StringUtils.isEmpty(eachDeal.getProductTypeCollection()) && eachDeal.getProductTypeCollection().equalsIgnoreCase(CPA)){
				pd.setDebtValue("-");
				pd.setEquityValue("-");
			}else{
				String debtValue = (StringUtils.isNotBlank(eachDeal.getDebtValue())) ? currencyFormat.format(new BigDecimal(eachDeal.getDebtValue())) : "-";
				pd.setDebtValue(debtValue);
				String equityValue = (StringUtils.isNotBlank(eachDeal.getEquityValue())) ? currencyFormat.format(new BigDecimal(eachDeal.getEquityValue())) : "-";
				pd.setEquityValue(equityValue);
			}
			if(eachDeal.getDealCategoryId() != null){
				pd.setDealCategory(dealCategoryName.get(String.valueOf(eachDeal.getDealCategoryId())));
			}else{
				pd.setDealCategory("-");
			}
			if(!StringUtils.isEmpty(eachDeal.getComments())){
				if(CPA.equals(eachDeal.getComments()))
					pd.setProductTypeCollection("Cash Pool");
				else
					pd.setProductTypeCollection(eachDeal.getComments());
			}else
				pd.setProductTypeCollection("-");
			
			if(eachDeal.getResponsibleRegionId() != null && eachDeal.getResponsibleRegionId() == 1){
				pd.setResponsibleRegion("Americas");
			}else if(eachDeal.getResponsibleRegionId() != null && eachDeal.getResponsibleRegionId() == 2){
				pd.setResponsibleRegion("Europe");
			}else if(eachDeal.getResponsibleRegionId() != null && eachDeal.getResponsibleRegionId() == 3){
				pd.setResponsibleRegion("Asia");
			}
			if(eachDeal.getValueDt() != null) {
				pd.setValueDate(dateFormat.format(eachDeal.getValueDt().toGregorianCalendar().getTime()));
			}
			if(eachDeal.getRequestDt() != null) {
				pd.setRequestDate(dateFormat.format(eachDeal.getRequestDt().toGregorianCalendar().getTime()));
			}
			pd.setNoOfDaysRemaining(eachDeal.getNumberOfDaysRem());
			
			pd.setStatus(getDealStatus(eachDeal.getWFStageId()));
			
			if(eachDeal.getPriorityId() != null && eachDeal.getPriorityId() == 1){
				pd.setPriority(HIGH);
			}else if(eachDeal.getPriorityId() != null && eachDeal.getPriorityId() == 2){
				pd.setPriority(MEDIUM);
			}else if(eachDeal.getPriorityId() != null && eachDeal.getPriorityId() == 3){
				pd.setPriority("Low");
			}
			if(eachDeal.getWFStageId() != null){
				pd.setWorkFlowState(wfStageDeacMap.get(eachDeal.getWFStage()));
			}else{
				pd.setWorkFlowState("-");
			}
			
			
			getStatusInfoChart(eachDeal, pd, request);
			if("MO".equals(pipelineType)){
				setMOPipelineChartTCMO(eachDeal, pd);
			}
			pipelineDetails.add(pd);
		}
		
		return pipelineDetails;
	}
	
	/**
	 * 
	 * @param currentStageId
	 * @return
	 */
	private static String getDealStatus(Integer currentStageId) {
		// Refractored the code for performance improvement
		String result = "";
		if(currentStageId != null) {
			switch(currentStageId) {
				case 1:
					result = "10%";
					break;
				case 15:
					result = "15%";
					break;
				case 14:
					result = "20%";
					break;
				case 17:
					result = "25%";
					break;
				case 18:
					result = "30%";
					break;
				case 19:
					result = "35%";
					break;
				case 16:
					result = "40%";
					break;
				case 13:
				case 27:
					result = "50%";
					break;
				case 3:
					result = "55%";
					break;
				case 4: // business Review
					result = "60%";
					break;
				case 5:
				case 6:
					result = "65%";
					break;
				case 7:
					result = "70%";
					break;
				case 8: //eboardroom
					result = "75%";
					break;
				case 10:
					result = "80%";
					break;
				case 23:
				case 24:
					result = "85%";
					break;
				case 9:
				case 21:
					result = "90%";
					break;
				case 25:
					result = "95%";
					break;
			}
		}
		return result;
	}
	/**
	 * @param eachDeal
	 * @param pd
	 */
	private static void getStatusInfoChart(DealRequest eachDeal,
			PipelineDetails pd, HttpServletRequest request) {
		 List<StatusInfo> siList = eachDeal.getStatusInfos();
		
		if(siList.size() == 0){
			pd.setPipeline(new ChartInfo("partial", new StatusInfo()));
			setNotDoneStatus(pd, new StatusInfo(), eachDeal);
			setNotDoneStatusRA(pd, new StatusInfo());
			setNotDoneStatusClosing(pd, new StatusInfo());
		}
		boolean isCountryTaxCompleted = false;
		
		for (StatusInfo statusInfo : siList) {
			switch(Integer.valueOf(statusInfo.getRoleName())) {
				case 26:
					if(statusInfo.getStatus().equals(TWO) || statusInfo.getStatus().equals(TWENTYTHREE)) {
						pd.setPipeline(new ChartInfo("partial", statusInfo));
						setNotDoneStatus(pd, statusInfo, eachDeal);
						setNotDoneStatusRA(pd, statusInfo);
						setNotDoneStatusClosing(pd, statusInfo);
					}
					break;
				case 1:
					if(statusInfo.getStatus().equals(TWENTYONE) || statusInfo.getStatus().equals(THREE)) {
						pd.setPipeline(new ChartInfo("completed", statusInfo));
						setInprogress(pd, statusInfo, eachDeal);
						setNotDoneStatusRA(pd, statusInfo);
						setNotDoneStatusClosing(pd, statusInfo);
					}
					break;
				case 13:
				case 27:
					if(statusInfo.getStatus().equals(FIVE)) {
						pd.setFrontO(new ChartInfo("completed",statusInfo));
						if("Cash Pool".equals(pd.getProductTypeCollection())){
							for (StatusInfo statusInfo1 : siList) {
								if(ICFPConstants.NINTEEN.equals(statusInfo1.getRoleName())){
									isCountryTaxCompleted = true;
								}
							}
							if(!isCountryTaxCompleted){
								pd.setCountryT(new ChartInfo("notapplicable", statusInfo));
							}
						}
						if(RISKREVW.equals(eachDeal.getWFStage())){
							pd.setRiskM(new ChartInfo("partial", statusInfo));
						}
					}
					break;
				case 14:
					if(statusInfo.getStatus().equals(FIVE)) {
						pd.setMiddleO(new ChartInfo("completed", statusInfo));
					}
					break;
				case 15:
					if(statusInfo.getStatus().equals(FIVE)) {
						pd.setCashM(new ChartInfo("completed", statusInfo));
					}
					break;
				case 16:
					if(statusInfo.getStatus().equals(FIVE)) {
						pd.settPricing(new ChartInfo("completed", statusInfo));
					}
					break;
				case 17:
					if(statusInfo.getStatus().equals(FIVE)) {
						pd.settLegal(new ChartInfo("completed", statusInfo));
					}
					break;
				case 18:
					if(statusInfo.getStatus().equals(FIVE)) {
						pd.settTax(new ChartInfo("completed", statusInfo));
					}
					break;
				case 19:
					if(statusInfo.getStatus().equals(FIVE)) {
						pd.setCountryT(new ChartInfo("completed", statusInfo));
					}
					break;
				case 3:
					if(statusInfo.getStatus().equals(FIVE)) {
						pd.setRiskM(new ChartInfo("completed", statusInfo));
						if(IDAGREVW.equals(eachDeal.getWFStage()) || IDAGEAG.equals(eachDeal.getWFStage())){
							pd.setBusinessF(new ChartInfo("notapplicable", statusInfo));
							pd.setIdag(new ChartInfo("partial", statusInfo));
						}else if("BUASIA".equals(eachDeal.getWFStage()) || "BUCLLAME".equals(eachDeal.getWFStage()) || "BUCAPHQO".equals(eachDeal.getWFStage()) || "BUCOMMRE".equals(eachDeal.getWFStage()) || "BUEMEA".equals(eachDeal.getWFStage()) || "BURETFIN".equals(eachDeal.getWFStage()) || "BURESOP".equals(eachDeal.getWFStage()) || "BUGECAS".equals(eachDeal.getWFStage()) || "BUEMRG".equals(eachDeal.getWFStage()) || "BUTREAS".equals(eachDeal.getWFStage()) || "BUEFS".equals(eachDeal.getWFStage()) || "BAASIA".equals(eachDeal.getWFStage()) || "BACAPHQO".equals(eachDeal.getWFStage()) || "BACLLAME".equals(eachDeal.getWFStage()) || "BACOMMRE".equals(eachDeal.getWFStage()) || "BAEFS".equals(eachDeal.getWFStage()) || "BAEMEA".equals(eachDeal.getWFStage()) || "BAEMRG".equals(eachDeal.getWFStage()) || "BAGECAS".equals(eachDeal.getWFStage()) || "BARESOP".equals(eachDeal.getWFStage()) || "BARETFIN".equals(eachDeal.getWFStage()) || "BATREAS".equals(eachDeal.getWFStage()) ){
							pd.setBusinessF(new ChartInfo("partial", statusInfo));
						}
					}
					break;
				case 4:
					if(statusInfo.getStatus().equals(FIVE)) {
						pd.setBusinessF(new ChartInfo("completed", statusInfo));
						if(IDAGREVW.equals(eachDeal.getWFStage()) || IDAGEAG.equals(eachDeal.getWFStage())){
							pd.setIdag(new ChartInfo("partial", statusInfo));
						}
					}
					break;
				case 5:
				case 6:
					if(statusInfo.getStatus().equals(FIVE) || statusInfo.getStatus().equals(THREE) || statusInfo.getStatus().equals(NINE)) {
						
						if(IDAGEAG.equals(eachDeal.getWFStage()) || IDAGREVW.equals(eachDeal.getWFStage())){
							pd.setIdag(new ChartInfo("partial", statusInfo));
						}else{
							pd.setIdag(new ChartInfo("completed", statusInfo));
							if(ICFPConstants.ZERO.equals(eachDeal.getTesgStatus())){
								if(ICFPConstants.ZERO.equals(eachDeal.getAddApproverStatus())){
									pd.setAdditionalR(new ChartInfo("notapplicable", statusInfo));
									setClosingState(eachDeal, pd, statusInfo);
								}else if(ONE.equals(eachDeal.getAddApproverStatus())){
									pd.setAdditionalR(new ChartInfo("partial", statusInfo));
								}else if(TWO.equals(eachDeal.getAddApproverStatus())){
									pd.setAdditionalR(new ChartInfo("completed", statusInfo));
									setClosingState(eachDeal, pd, statusInfo);
								}
								pd.setTesg(new ChartInfo("notapplicable", statusInfo));
							}else if(ONE.equals(eachDeal.getTesgStatus())){
								pd.setTesg(new ChartInfo("partial", statusInfo));
							}else if(TWO.equals(eachDeal.getTesgStatus())){
								pd.setTesg(new ChartInfo("completed", statusInfo));
							}
						}
						if(!"completed".equals(pd.getBusinessF().getStatus())){
							pd.setBusinessF(new ChartInfo("notapplicable", statusInfo));
						}
					}
					break;
				case 7:
					if(statusInfo.getStatus().equals(FIVE) || statusInfo.getStatus().equals(THREE)) {
						
						if(ONE.equals(eachDeal.getTesgStatus())){
							pd.setTesg(new ChartInfo("partial", statusInfo));
						}else if(TWO.equals(eachDeal.getTesgStatus())){
							pd.setTesg(new ChartInfo("completed", statusInfo));
						}
						
						if(ICFPConstants.ZERO.equals(eachDeal.getAddApproverStatus())){
							pd.setAdditionalR(new ChartInfo("notapplicable", statusInfo));
							setClosingState(eachDeal, pd, statusInfo);
						}else if(ONE.equals(eachDeal.getAddApproverStatus())){
							pd.setAdditionalR(new ChartInfo("partial", statusInfo));
						}else if(TWO.equals(eachDeal.getAddApproverStatus())){
							pd.setAdditionalR(new ChartInfo("completed", statusInfo));
							setClosingState(eachDeal, pd, statusInfo);
						}
					}
					break;
				case 10:
					if(statusInfo.getStatus().equals(THREE)) {
						if(ONE.equals(eachDeal.getAddApproverStatus())){
							pd.setAdditionalR(new ChartInfo("partial", statusInfo));
						}else if(TWO.equals(eachDeal.getAddApproverStatus())){
							pd.setAdditionalR(new ChartInfo("completed", statusInfo));
							setClosingState(eachDeal, pd, statusInfo);
						}
					}
					break;
				case 9:
				case 21:
				case 22:
					if(statusInfo.getStatus().equals(SEVENTEEN)) {
						pd.setCertify(new ChartInfo("completed", statusInfo));
					}
					if(CLOSEREQ.equals(eachDeal.getWFStage())){
						pd.setClose(new ChartInfo("partial", statusInfo));
					}
					break;
				case 25:
					if(statusInfo.getStatus().equals(TWENTY)) {
						pd.setClose(new ChartInfo("completed", statusInfo));
					}
					break;
			}
		}
	}
	/**
	 * @param eachDeal
	 * @param pd
	 * @param statusInfo
	 */
	private static void setClosingState(DealRequest eachDeal,
			PipelineDetails pd, StatusInfo statusInfo) {
		if(CERTFYFO.equals(eachDeal.getWFStage()) || CERTFYCM.equals(eachDeal.getWFStage()) || "TCCERTIFY".equals(eachDeal.getWFStage())){
			pd.setCertify(new ChartInfo("partial", statusInfo));
		}else if(CLOSEREQ.equals(eachDeal.getWFStage())){
			pd.setClose(new ChartInfo("partial", statusInfo));
		}
	}
	/**
	 * 
	 * @param dealCollection
	 * @param request
	 * @return
	 * @throws ParseException
	 * @throws HWFServiceException
	 * @throws HWFStubException
	 */
	public static List<PipelineDetails> populatePipelineMgmtMO(DealRequests dealCollection, HttpServletRequest request) throws ParseException, HWFServiceException, HWFStubException{
		Map<String, String> dealCategoryName = DealManager.getAllDealCategories(request);
		Map<String, String> wfStageDeacMap = DealManager.getWorkflowStageDescMap(request);
		List<DealRequest> allDealReq=dealCollection.getDealRequests();
		List<PipelineDetails> pipelineDetails = new LinkedList<PipelineDetails>();
		DateFormat dateFormat = new SimpleDateFormat(DATE_DISPLAY_FORMAT);
		DecimalFormat currencyFormat = new DecimalFormat(CURRENCY_FORMAT);
		for (DealRequest eachDeal : allDealReq) {
			PipelineDetails pd = new PipelineDetails();
			pd.setRequestID(Integer.toString(eachDeal.getDealSeqId()));
			pd.setUniqueId(eachDeal.getUniqueId());
			pd.setDealName(eachDeal.getDealName());
			pd.setTransOwnerSsoId(eachDeal.getTransOwnerSsoId());
			if(eachDeal.getProductTypeCollection().equalsIgnoreCase(CPA)){
				pd.setDebtValue("-");
				pd.setEquityValue("-");
			}else{
				String debtValue = (StringUtils.isNotBlank(eachDeal.getDebtValue())) ? currencyFormat.format(new BigDecimal(eachDeal.getDebtValue())) : "-";
				pd.setDebtValue(debtValue);
				String equityValue = (StringUtils.isNotBlank(eachDeal.getEquityValue())) ? currencyFormat.format(new BigDecimal(eachDeal.getEquityValue())) : "-";
				pd.setEquityValue(equityValue);
			}
			pd.setDealCategory(dealCategoryName.get(String.valueOf(eachDeal.getDealCategoryId())));
			if(eachDeal.getEventType() != null){
				pd.setEvent(eachDeal.getEventType());
			}else{
				pd.setEvent("-");
			}
			pd.setResponsibleRegion(eachDeal.getResponsibleRegion());
			
			if(eachDeal.getValueDt() != null) {
				pd.setValueDate(dateFormat.format(eachDeal.getValueDt().toGregorianCalendar().getTime()));
			}
			if(eachDeal.getRequestDt() != null) {
				pd.setRequestDate(dateFormat.format(eachDeal.getRequestDt().toGregorianCalendar().getTime()));
			}
			pd.setNoOfDaysRemaining(eachDeal.getNumberOfDaysRem());
			pd.setPriority(eachDeal.getPriority());
			pd.setStatus(getDealStatus(eachDeal.getWFStage()));
			pd.setWorkFlowState(wfStageDeacMap.get(eachDeal.getWFStage()));
			if(eachDeal.isNonStandardDocsFlag() != null && eachDeal.isNonStandardDocsFlag() == true){
				pd.setStandardException("Exception");
			}else if(eachDeal.isNonStandardDocsFlag() != null && eachDeal.isNonStandardDocsFlag() == false){
				pd.setStandardException(STANDARD);
			}else{
				pd.setStandardException("-");
			}
			getStatusInfoChart(eachDeal, pd, request);
			setMOPipelineChartTCMO(eachDeal, pd);
			pipelineDetails.add(pd);
		}
		return pipelineDetails;
	}
	/**
	 * @param eachDeal
	 * @param pd
	 */
	private static void setMOPipelineChartTCMO(DealRequest eachDeal,
			PipelineDetails pd) {
		StatusInfo statusInfo = new StatusInfo(); 
		if(CLOSEREQ.equals(eachDeal.getWFStage())){
			pd.setFrontO(new ChartInfo("notapplicable",statusInfo));
			pd.setCashM(new ChartInfo("notapplicable",statusInfo));
			pd.setMiddleO(new ChartInfo("notapplicable", statusInfo));
			pd.settPricing(new ChartInfo("notapplicable", statusInfo));
			pd.settLegal(new ChartInfo("notapplicable", statusInfo));
			pd.settTax(new ChartInfo("notapplicable", statusInfo));
			pd.setCountryT(new ChartInfo("notapplicable", statusInfo));
			pd.setRiskM(new ChartInfo("notapplicable",statusInfo));
			pd.setBusinessF(new ChartInfo("notapplicable",statusInfo));
			pd.setIdag(new ChartInfo("notapplicable", statusInfo));
			pd.setTesg(new ChartInfo("notapplicable", statusInfo));
			pd.setAdditionalR(new ChartInfo("notapplicable",statusInfo));
			pd.setCertify(new ChartInfo("notapplicable",statusInfo));
			pd.setClose(new ChartInfo("partial", new StatusInfo()));
		}
	}
	/**
	 * 
	 * @param dealCollection
	 * @param request
	 * @return
	 * @throws ParseException
	 * @throws HWFServiceException
	 * @throws HWFStubException
	 */
	public static List<PipelineDetails> populateSearchDetails(DealRequests dealCollection, HttpServletRequest request) throws ParseException, HWFServiceException, HWFStubException{
		Map<String, String> dealCategoryName = DealManager.getAllDealCategories(request);
		Map<String, String> wfStageDeacMap = DealManager.getWorkflowStageDescMap(request);
		List<DealRequest> allDealReq=dealCollection.getDealRequests();
		List<PipelineDetails> searchDetails = new LinkedList<PipelineDetails>();
		DateFormat dateFormat = new SimpleDateFormat(DATE_DISPLAY_FORMAT);
		DecimalFormat currencyFormat = new DecimalFormat(CURRENCY_FORMAT);
		for (DealRequest eachDeal : allDealReq) {
			PipelineDetails pd = new PipelineDetails();
			pd.setRequestID(Integer.toString(eachDeal.getDealSeqId()));
			pd.setUniqueId(eachDeal.getUniqueId());
			pd.setDealName(eachDeal.getDealName());
			if(eachDeal.getDealStatus() != null && eachDeal.getDealStatus().equals(ONE) ){
				pd.setStatus("In Progress");
			}else if(eachDeal.getDealStatus() != null && eachDeal.getDealStatus().equals(TWO) ){
				pd.setStatus(DRAFT);
			}else if(eachDeal.getDealStatus() != null && eachDeal.getDealStatus().equals(THREE) ){
				pd.setStatus("Close");
			}else if(eachDeal.getDealStatus() != null && eachDeal.getDealStatus().equals(FOUR) ){
				pd.setStatus("Withdrawn");
			}else if(eachDeal.getDealStatus() != null && eachDeal.getDealStatus().equals(FIVE) ){
				pd.setStatus("Rejected");
			}else if(eachDeal.getDealStatus() != null && eachDeal.getDealStatus().equals(SIX) ){
				pd.setStatus("Expired");
			}
			
			if(eachDeal.getDealCategoryId() != null){
				pd.setDealCategory(dealCategoryName.get(String.valueOf(eachDeal.getDealCategoryId())));
			}else{
				pd.setDealCategory("-");
			}
			pd.setEvent(eachDeal.getEventType());
			String debtValue = (StringUtils.isNotBlank(eachDeal.getDebtValue())) ? currencyFormat.format(new BigDecimal(eachDeal.getDebtValue())) : "-";
			pd.setDebtValue(debtValue);
			String equityValue = (StringUtils.isNotBlank(eachDeal.getEquityValue())) ? currencyFormat.format(new BigDecimal(eachDeal.getEquityValue())) : "-";
			pd.setEquityValue(equityValue);
			if(eachDeal.getValueDt() != null) {
				pd.setValueDate(dateFormat.format(eachDeal.getValueDt().toGregorianCalendar().getTime()));
			}
			if(eachDeal.getRequestDt() != null) {
				pd.setRequestDate(dateFormat.format(eachDeal.getRequestDt().toGregorianCalendar().getTime()));
			}
			pd.setNoOfDaysRemaining(eachDeal.getNumberOfDaysRem());
			if(eachDeal.getPriorityId() != null && eachDeal.getPriorityId() == 1){
				pd.setPriority(HIGH);
			}else if(eachDeal.getPriorityId() != null && eachDeal.getPriorityId() == 2){
				pd.setPriority(MEDIUM);
			}else if(eachDeal.getPriorityId() != null && eachDeal.getPriorityId() == 3){
				pd.setPriority("Low");
			}
			pd.setName(eachDeal.getLastName()+", "+eachDeal.getFirstName());
			pd.setWorkFlowState(wfStageDeacMap.get(eachDeal.getWFStage()));
			searchDetails.add(pd);
		}
		return searchDetails;
	}
	
	/**
	 * @param pd
	 * @param statusInfo
	 */
	private static void setNotDoneStatus(PipelineDetails pd,
			StatusInfo statusInfo, DealRequest deal) {
		pd.setFrontO(new ChartInfo("inprogress",statusInfo));
		pd.setCashM(new ChartInfo("inprogress",statusInfo));
		pd.setMiddleO(new ChartInfo("inprogress", statusInfo));
		pd.settPricing(new ChartInfo("inprogress", statusInfo));
		pd.settLegal(new ChartInfo("inprogress", statusInfo));
		pd.settTax(new ChartInfo("inprogress", statusInfo));
		if("Cash Pool".equals(pd.getProductTypeCollection())){
			pd.setCountryT(new ChartInfo("inprogress", statusInfo));
		}else{
			pd.setCountryT(new ChartInfo("notapplicable", statusInfo));
		}
		
	}
	/**
	 * @param pd
	 * @param statusInfo
	 */
	private static void setNotDoneStatusRA(PipelineDetails pd,
			StatusInfo statusInfo) {
		pd.setRiskM(new ChartInfo("inprogress",statusInfo));
		pd.setBusinessF(new ChartInfo("inprogress",statusInfo));
		pd.setIdag(new ChartInfo("inprogress", statusInfo));
		pd.setTesg(new ChartInfo("inprogress", statusInfo));
	}
	/**
	 * @param pd
	 * @param statusInfo
	 */
	private static void setNotDoneStatusClosing(PipelineDetails pd,
			StatusInfo statusInfo) {
		pd.setAdditionalR(new ChartInfo("inprogress",statusInfo));
		pd.setCertify(new ChartInfo("inprogress",statusInfo));
		pd.setClose(new ChartInfo("inprogress", statusInfo));
	}
	/**
	 * @param pd
	 * @param statusInfo
	 */
	private static void setInprogress(PipelineDetails pd,
			StatusInfo statusInfo, DealRequest deal) {
		pd.setFrontO(new ChartInfo("partial",statusInfo));
		pd.setCashM(new ChartInfo("partial",statusInfo));
		pd.setMiddleO(new ChartInfo("partial", statusInfo));
		pd.settPricing(new ChartInfo("partial", statusInfo));
		pd.settLegal(new ChartInfo("partial", statusInfo));
		pd.settTax(new ChartInfo("partial", statusInfo));
		if("Cash Pool".equals(pd.getProductTypeCollection())){
			pd.setCountryT(new ChartInfo("partial", statusInfo));
		}else{
			pd.setCountryT(new ChartInfo("notapplicable", statusInfo));
		}
		
	}
	
	/**
	 * @param allDealReq
	 * @param i
	 * @param pd
	 */
	private static String getDealStatus(String currentStage) {
		if(StringUtils.isNotBlank(currentStage)) {
			currentStage = currentStage.toUpperCase().trim();
			if(currentStage.equals(PLERIVEW)){
				return "10%";
			}else if(currentStage.equals(SOCASHMG)){
				return "15%";
			}else if(currentStage.equals(SOMIDOFF)){
				return "20%";
			}else if(currentStage.equals(SOTLEGAL)){
				return "25%";
			}else if(currentStage.equals(SOTRESTX)){
				return "30%";
			}else if(currentStage.equals(SOCOUNTX)){
				return "35%";
			}else if(currentStage.equals(SOTPRICE)){
				return "40%";
			}else if(currentStage.equals(SOFRTOFF) || currentStage.equals("FOOFFICE")){
				return "50%";
			}else if(currentStage.equals(RISKREVW)){
				return "55%";
			}else if(currentStage.equals(IDAGEAG) || currentStage.equals(IDAGREVW)){
				return "60%";
			}else if(currentStage.equals(TESGREVW)){
				return "70%";
			}else if(currentStage.equals("ADDAPPRV")){
				return "80%";
			}else if(currentStage.equals("APPOVEFO") || currentStage.equals("APPOVECM")){
				return "85%";
			}else if(currentStage.equals(CERTFYFO) || currentStage.equals(CERTFYCM) || currentStage.equals("TCCERTIFY")){
				return "90%";
			}else if(currentStage.equals(CLOSEREQ)){
				return "95%";
			}
		}
		return "";
	}
}
