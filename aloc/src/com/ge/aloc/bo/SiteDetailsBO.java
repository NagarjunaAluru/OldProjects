/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: SiteDetailsBO.java
 * Purpose: SiteDetailsBO used for the all site operations
 */
package com.ge.aloc.bo;

import com.ge.aloc.model.SiteAdmin;

/**
 * @author madhusudhan.gosula
 *
 */
public class SiteDetailsBO extends AbstractModel<SiteAdmin> {

	private DelegationConfigurationBO delegationConfigurationBO;

	/**
	 * Default constructor
	 * @param siteDetails
	 */
	public SiteDetailsBO(SiteAdmin siteDetails) {
		super(siteDetails);
	}

	/**
	 * Method to get Delegation ConfigBO Object
	 * @return the delegationConfigurationBO
	 */
	public DelegationConfigurationBO getDelegationConfigurationBO() {
		if(delegationConfigurationBO != null && delegationConfigurationBO.getModel() == getModel().getDelegationConfiguration()) {
			return delegationConfigurationBO;
		}

		return (getModel().getDelegationConfiguration() != null) ? new DelegationConfigurationBO(getModel().getDelegationConfiguration()) : null;
	}

	/**
	 * Method to set Delegation ConfigBO Object
	 * @param delegationConfigurationBO the delegationConfigurationBO to set
	 */
	public void setDelegationConfigurationBO(DelegationConfigurationBO delegationConfigurationBO) {
		this.delegationConfigurationBO = delegationConfigurationBO;
		getModel().setDelegationConfiguration(delegationConfigurationBO.getModel());
	}
}
