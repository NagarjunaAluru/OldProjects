package com.ge.icfp.tag;

import java.util.List;

import com.ge.icfp.model.QualitativeFactors;

public class CheckAssessment {
	
	/**
	 * Return true if Assessment is already selected for this
	 * @param legType
	 * @param assessment
	 * @return
	 */
	public static Integer getAssessment(List<QualitativeFactors> factors, Integer factorID){
		
		for(QualitativeFactors factor: factors){
			
			if( factor.getQualitativeFactorId().equals( factorID )){
				return factor.getAssessmentId();
			}
		}
				
		return 0;
	}
	
	
	/**
	 * Return true if Assessment is already selected for this
	 * @param legType
	 * @param assessment
	 * @return
	 */
	public static String getComment(List<QualitativeFactors> factors, Integer factorID){
		
		for(QualitativeFactors factor: factors){
			
			if( factor.getQualitativeFactorId().equals( factorID )){
				return factor.getComment();
			}
		}
				
		return "";
	}
		
}
