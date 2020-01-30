package com.ge.icfp.util;

import static com.ge.icfp.common.constants.ICFPConstants.HIGH;
import static com.ge.icfp.common.constants.ICFPConstants.MEDIUM;
import static com.ge.icfp.common.constants.ICFPConstants.SOTPRICE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.ge.icfp.common.constants.ICFPConstants;
import com.ge.icfp.common.helper.ICFPLegHelper;
import com.ge.icfp.model.CPALegRequest;
import com.ge.icfp.model.EquityLegRequest;
import com.ge.icfp.model.QualitativeFactors;
import com.ge.icfp.model.RCALegRequest;
/**
 * Validates the given list of qualitative mandatory 
 * for mandatory information
 * @author prithivi.dhamotharan
 *
 */
public class ValidateQualitativeAssessments {
	
	/**
	 * validateQFactorsAssessment to check Quality Assessment Validation Criteria
	 * @param factors {@link List}
	 * @return {@link Boolean}
	 */
	private boolean isError(QualitativeFactors qualitativeFactors) {
		
		boolean notValid = StringUtils.isEmpty( qualitativeFactors.getAssessment() );
		
		if( notValid ){
			return notValid;
		}else{
			String assesment = qualitativeFactors.getAssessment();
			String comments = qualitativeFactors.getComment();
			
			if( HIGH.equals(assesment) || MEDIUM.equals(assesment) ){
					return StringUtils.isEmpty( comments );
			}
		}
		
		return false;
	}
	
	/**
	 * Check for mandatory errors and return the Map having key as factor name
	 * and its validation result in value.
	 * 
	 * @param factors
	 * @return
	 */
	private Map<String, Boolean> checkFOFactors(List<QualitativeFactors> factors){
		
		Map<String, Boolean> results = new HashMap<String, Boolean>();
		
		for( QualitativeFactors factor: factors){
			
			if(factor.getQualitativeFactorId().equals(ICFPConstants.ONE)|| factor.getQualitativeFactorId().equals(ICFPConstants.TWO)
					|| factor.getQualitativeFactorId().equals(ICFPConstants.THREE) ||factor.getQualitativeFactorId().equals(ICFPConstants.FOUR)
					|| factor.getQualitativeFactorId().equals(ICFPConstants.FIVE)){
				boolean error = isError( factor ) ;
				if( error ){
					results.put(factor.getQualitativeFactor(), error);
				}
			}
		}
		return results;
	}
	
	/**
	 * Check for mandatory errors and return the Map having key as factor name
	 * and its validation result in value.
	 * 
	 * @param factors
	 * @return
	 */
	private Map<String, Boolean> checkFactors(QualitativeFactors factors){
		
		Map<String, Boolean> results = new HashMap<String, Boolean>();
		
			
		boolean error = isError( factors ) ;
		if( error ){
			results.put(factors.getQualitativeFactor(), error);
		}
		return results;
	}
	/**
	 * Check for assessment error for all the Legs
	 * 
	 * @param allLegs
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List<Integer> checkError(List allLegs, Integer qFactorId, String wfStage, HttpServletRequest request){
		
		List<QualitativeFactors> factors=null;
		List<Integer> errorLeg = new ArrayList<Integer>();		
		Integer legSeqId = null;
		for(Object leg: allLegs ){
			int hasQA = 0;
			legSeqId = ICFPLegHelper.getLegSeqId(leg);
			// Qualitative assessment not need for Equity products for Transfer Pricing S&O.
			if(leg instanceof EquityLegRequest && SOTPRICE.equals(wfStage)){
				continue;
			}
			// Qualitative assessment validation not required for Drawdown/Prepayment/Correction/Amendmend-FacilityDecrease event.
			if (leg instanceof RCALegRequest) {
				Integer eventid = ((RCALegRequest) leg).getLegSummary()
						.getTransactionEventTypeId();
				if (eventid != null) {
					int id = eventid.intValue();
					if (id == 8 || id == 7 || id == 10) {
						continue;
					}else if(id == 5){
						if(((RCALegRequest) leg).getDayTwoOperations().getFacilityIncreaseDecrease().getFacilityTypeId().intValue() == 2){
							continue;
						}
					}
				}
			}else if(leg instanceof EquityLegRequest){
				Integer eventid = ((EquityLegRequest) leg).getLegSummary()
						.getTransactionEventTypeId();
				if (eventid != null) {
					int id = eventid.intValue();
					if (id == 8 || id == 7 || id == 10) {
						continue;
					}else if(id == 5){
						if(((EquityLegRequest) leg).getDayTwoOperations().getFacilityIncreaseDecrease().getFacilityTypeId().intValue() == 2){
							continue;
						}
					}
				}
			}else if(leg instanceof CPALegRequest){
				Integer eventid = ((CPALegRequest) leg).getCPASummary()
						.getTransactionEventTypeId();
				if (eventid != null) {
					int id = eventid.intValue();
					if (id == 8 || id == 7 || id == 10) {
						continue;
					}else if(id == 5){
						if(((CPALegRequest) leg).getDayTwoOperations().getFacilityIncreaseDecrease().getFacilityTypeId().intValue() == 2){
							continue;
						}
					}
				}
			}
			
			factors = ICFPLegHelper.getQualitativeFactors( leg );
			if(factors.size() >= 1){
				for (QualitativeFactors qFactor : factors) {
					if(qFactor.getQualitativeFactorId().intValue() == qFactorId.intValue()){
						hasQA = 1;
						if(checkFactors( qFactor ).size() > 0){
							errorLeg.add( legSeqId );
						}
					}
				}
			}else{
				hasQA = 2;
				errorLeg.add( legSeqId );
			}
			if(hasQA==0){
				errorLeg.add( legSeqId );
			}
		}
		
		return errorLeg;
	}
	
	/**
	 * Check for assessment error for all the Legs of Front office 
	 * 
	 * @param allLegs
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List<Integer> checkFOError(List allLegs, HttpServletRequest request){
		
		List<QualitativeFactors> factors=null;
		List<Integer> errorLeg = new ArrayList<Integer>();		
		@SuppressWarnings("unused")
		int i=1;
		Integer legSeqId = null;
		for(Object leg: allLegs ){
			legSeqId = ICFPLegHelper.getLegSeqId(leg);
			// Qualitative assessment validation not required for Drawdown/Prepayment/Correction/Amendmend-FacilityDecrease event.
			if (leg instanceof RCALegRequest) {
				Integer eventid = ((RCALegRequest) leg).getLegSummary()
						.getTransactionEventTypeId();
				if (eventid != null) {
					int id = eventid.intValue();
					if (id == 8 || id == 7 || id == 10) {
						i++;
						continue;
					}else if(id == 5){
						if(((RCALegRequest) leg).getDayTwoOperations().getFacilityIncreaseDecrease().getFacilityTypeId().intValue() == 2){
							i++;
							continue;
						}
					}
				}
			}else if(leg instanceof EquityLegRequest){
				Integer eventid = ((EquityLegRequest) leg).getLegSummary()
						.getTransactionEventTypeId();
				if (eventid != null) {
					int id = eventid.intValue();
					if (id == 8 || id == 7 || id == 10) {
						i++;
						continue;
					}else if(id == 5){
						if(((EquityLegRequest) leg).getDayTwoOperations().getFacilityIncreaseDecrease().getFacilityTypeId().intValue() == 2){
							i++;
							continue;
						}
					}
				}
			}else if(leg instanceof CPALegRequest){
				Integer eventid = ((CPALegRequest) leg).getCPASummary()
						.getTransactionEventTypeId();
				if (eventid != null) {
					int id = eventid.intValue();
					if (id == 8 || id == 7 || id == 10) {
						i++;
						continue;
					}else if(id == 5){
						if(((CPALegRequest) leg).getDayTwoOperations().getFacilityIncreaseDecrease().getFacilityTypeId().intValue() == 2){
							i++;
							continue;
						}
					}
				}
			}
			factors = ICFPLegHelper.getQualitativeFactors( leg );
			
			if( factors.size() < 1 || checkFOFactors( factors ).size() > 0){
				errorLeg.add( legSeqId );
			}else {
				int counter=0;
				for(int j=0;j<factors.size();j++){
				int qualityFactorId= factors.get(j).getQualitativeFactorId();
				switch (qualityFactorId){  
					case 1:
						counter++;
						break;
					case 2:
						counter++;
						break;
					case 3:
						counter++;
						break;
					case 4:
						counter++;
						break;
					case 5:
						counter++;
						break;
			  }
			}
				if(counter<5){
					errorLeg.add( legSeqId );
				}
			}
			i++;
		}
		
		return errorLeg;
	}
	
	
	
}
