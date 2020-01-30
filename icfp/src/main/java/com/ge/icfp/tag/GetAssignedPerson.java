/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: GetAllApprovers.java
 * Purpose: GetAssignedPerson used to returns assigned person name
 */
package com.ge.icfp.tag;

import com.ge.icfp.model.WorkItem;
import static com.ge.icfp.common.constants.ICFPConstants.*;
/**
 * Get the Assigned person name for the given stage 
 * 
 * @author prithivi.dhamotharan
 *
 */
public class GetAssignedPerson {
	
	public static String getAssigned(WorkItem item){
		
		String currentStage = item.getCurrentStage();
		
		if(SOFRTOFF.equals(currentStage)){
			return item.getFOAssgned();
		}else if(SOMIDOFF.equals(currentStage)){
			return item.getMOAssigned();
		}else if(SOCASHMG.equals(currentStage)){
			return item.getCMAssigned();
		}else if(SOTPRICE.equals(currentStage)){
			return item.getTPAssigned();
		}else if(SOTLEGAL.equals(currentStage)){
			return item.getTLAssigned();
		}else if(SOTRESTX.equals(currentStage)){
			return item.getTTASSigned();
		}else if(RISKREVW.equals(currentStage)){
			return item.getRUAssigned();
		}
		
		return "";
	}
}
