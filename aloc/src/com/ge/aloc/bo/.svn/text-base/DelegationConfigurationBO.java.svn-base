/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: DelegationConfigurationBO.java
 * Purpose: DelegationConfigurationBO used for the all Delegation operations
 */
package com.ge.aloc.bo;

import java.util.List;

import com.ge.aloc.model.DelegationConfiguration;
import com.ge.aloc.util.DelegationConfigBOList;

/**
 * @author chaitanya.n
 *
 */
public class DelegationConfigurationBO extends AbstractModel<DelegationConfiguration> {

	private DelegationConfigBOList delegationConfigBOList;

	/**
	 * This method is used to get new DelegationConfiguration
	 */
	public DelegationConfigurationBO() {
		this(new DelegationConfiguration());
	}

	/**
	 * This method is used  to set DelegationConfiguration
	 * @param model
	 */
	public DelegationConfigurationBO(DelegationConfiguration model) {
		super(model);
	}

	/**
	 * This method is used to get delegationConfigBOList
	 * @return the delegationConfigBOList
	 */
	public List<DelegationConfigBO> getDelegationConfigBOList() {
		if(delegationConfigBOList == null || ((DelegationConfigBOList) delegationConfigBOList).getDelegationConfigList() != getModel().getDelegationConfigs()) {
			delegationConfigBOList = new DelegationConfigBOList(getModel().getDelegationConfigs());
		}
		return delegationConfigBOList;
	}
}
