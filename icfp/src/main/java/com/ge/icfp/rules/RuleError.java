/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: RuleError.java
 * Purpose: RuleError represents error of RuleExecutor
 */
package com.ge.icfp.rules;

import java.util.Arrays;

/**
 * @author chaitanya
 *
 */
public class RuleError {
	private String code;
	private RuleErrorLevel level;
	private Object[] parameters;
	
	/**
	 * 
	 * @param level
	 * @param code
	 * @param params
	 */
	public RuleError(RuleErrorLevel level, String code, Object... params) {
		this.level = level;
		this.code = code;
		if(params != null && params.length > 0) {
			parameters = params;
		}
	}
	
	/**
	 * 
	 * @param code
	 * @param params
	 */
	public RuleError(String code, Object... params) {
		this(RuleErrorLevel.ERROR, code, params);
	}

	/**
	 * 
	 * @return
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 
	 * @return
	 */
	public RuleErrorLevel getLevel() {
		return level;
	}

	/**
	 * 
	 * @return
	 */
	public Object[] getParameters() {
		return parameters;
	}

	/**
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((level == null) ? 0 : level.hashCode());
		result = prime * result + Arrays.hashCode(parameters);
		return result;
	}

	/**
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RuleError other = (RuleError) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (level != other.level)
			return false;
		if (!Arrays.equals(parameters, other.parameters))
			return false;
		return true;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RuleError [code=").append(code).append(", level=")
				.append(level).append(", parameters=")
				.append(Arrays.toString(parameters)).append("]");
		return builder.toString();
	}
}
