/**
 * 
 */
package com.ge.icfp.util;

import java.util.Comparator;

import com.ge.icfp.common.helper.ICFPLegHelper;
import com.ge.icfp.model.CPALegRequest;
import com.ge.icfp.model.EquityLegRequest;
import com.ge.icfp.model.OtherLegRequest;
import com.ge.icfp.model.RCALegRequest;

/**
 * @author chaitanya.n
 *
 */
public class LegComparator implements Comparator<Object> {

	/**
	 * This method compares the legs based on sequence id
	 */
	public int compare(Object source, Object target) {
		validateLeg(source);
		validateLeg(target);
		Integer sourceId = ICFPLegHelper.getLegSeqId(source);
		Integer targetId = ICFPLegHelper.getLegSeqId(target);
		return sourceId.compareTo(targetId);
	}

	/**
	 * Validate the object is leg or not.
	 * 
	 * @param leg
	 */
	private void validateLeg(Object leg) {
		boolean isLeg = (leg instanceof RCALegRequest || leg instanceof EquityLegRequest 
				|| leg instanceof OtherLegRequest || leg instanceof CPALegRequest);
		if(!isLeg) {
			String msg = new StringBuilder().append("Object ").append(leg).append(" is not a valid leg object").toString();
			throw new IllegalArgumentException(msg);
		}
	}
}
