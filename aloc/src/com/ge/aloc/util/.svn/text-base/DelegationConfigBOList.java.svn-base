/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: DelegationConfigBOList.java
 * Purpose: DelegationConfigBOList used for delegation operations
 */
package com.ge.aloc.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.ge.aloc.bo.DelegationConfigBO;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.model.DelegationConfig;

/**
 * @author chaitanya.n
 *
 */
public class DelegationConfigBOList extends ArrayList<DelegationConfigBO> {

	private static final long serialVersionUID = 5604532243311269953L;

	private List<DelegationConfig> delegationConfigList;

	/**
	 * This method is used to get DelegationConfigBO
	 * @param delegationConfigList
	 */
	public DelegationConfigBOList(List<DelegationConfig> delegationConfigList) {
		super();
		this.delegationConfigList = delegationConfigList;
		for(DelegationConfig delegationConfig : delegationConfigList) {
			super.add(new DelegationConfigBO(delegationConfig));
		}
	}

	/**
	 * This method is used to add DelegationConfigBO
	 * @param delegationConfigBO
	 */
	@Override
	public boolean add(DelegationConfigBO delegationConfigBO) {
		this.delegationConfigList.add(delegationConfigBO.getModel());
		return super.add(delegationConfigBO);
	}

	/**
	 * This method is used to add DelegationConfig at particular index
	 * @param index
	 * @param delegationConfigBO
	 */
	@Override
	public void add(int index, DelegationConfigBO delegationConfigBO) {
		DelegationConfig delegationConfig = (delegationConfigBO != null) ? delegationConfigBO.getModel() : null;
		delegationConfigList.add(index, delegationConfig);
		super.add(index, delegationConfigBO);
	}

	/**
	 * This method is used to add all DelegationConfigBO
	 */
	@Override
	public boolean addAll(Collection<? extends DelegationConfigBO> c) {
		throw new UnsupportedOperationException(ALOCConstants.NOT_SUPPORTED_COLLECTION);
	}

	/**
	 * This method is used to remove DelegationConfigBO 
	 * @param o
	 */
	@Override
	public boolean remove(Object o) {
		if(o != null && o instanceof DelegationConfigBO) {
			this.delegationConfigList.remove(((DelegationConfigBO) o).getModel());
			return super.remove(o);
		} else {
			this.delegationConfigList.remove(o);
			return super.remove(o);
		}
	}

	/**
	 * This method is used to remove DelegationConfigBO based on index
	 * @param index
	 */
	@Override
	public DelegationConfigBO remove(int index) {
		delegationConfigList.remove(index);
		return super.remove(index);
	}

	/**
	 * This method is used to clear delegationConfigList
	 */
	@Override
	public void clear() {
		delegationConfigList.clear();
		super.clear();
	}

	/**
	 * This method is used to set DelegationConfigBO at particular index
	 * @param index
	 * @param delegationConfigBO
	 */
	@Override
	public DelegationConfigBO set(int index, DelegationConfigBO delegationConfigBO) {
		DelegationConfig delegationConfig = (delegationConfigBO != null) ? delegationConfigBO.getModel() : null;
		delegationConfigList.set(index, delegationConfig);
		return super.set(index, delegationConfigBO);
	}

	/**
	 * This method is used to get delegationConfigList 
	 * @return delegationConfigList
	 */
	public List<DelegationConfig> getDelegationConfigList() {
		return this.delegationConfigList;
	}
}
