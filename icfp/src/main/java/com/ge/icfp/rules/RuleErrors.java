/**
 * 
 */
package com.ge.icfp.rules;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;


/**
 * @author chaitanya
 *
 */
public class RuleErrors extends ArrayList<RuleError> {

	private static final long serialVersionUID = -1690352656140495973L;
	
	/**
	 * 
	 * @param code
	 */
	public void addError(String code) {
		addError(code, (Object[])null);
	}
	/**
	 * 
	 * @param code
	 * @param params
	 */
	public void addError(String code, Object... params) {
		super.add(new RuleError(code, params));
	}
	
	/**
	 * 
	 * @param level
	 * @param code
	 * @param params
	 */
	public void addError(RuleErrorLevel level, String code, Object... params) {
		if(level == null) {
			super.add(new RuleError(code, params));
		} else {
			super.add(new RuleError(level, code, params));
		}
	}
	
	/**
	 * Returns true if an error exists with specified code.
	 * 
	 * @param code
	 * @return
	 */
	public boolean hasError(String code) {
		boolean result = false;
		if(StringUtils.isNotBlank(code)) {
			for(RuleError ruleError : this) {
				String errorCode = ruleError.getCode();
				if(errorCode != null && errorCode.equals(code)) {
					result = true;
					break;
				}
			}	
		}
		return result;
	}
}
