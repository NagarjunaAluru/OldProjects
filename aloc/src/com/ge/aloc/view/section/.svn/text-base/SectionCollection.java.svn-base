/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: SectionCollection.java
 * Purpose: SectionCollection used for the section details.
 */
package com.ge.aloc.view.section;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chaitanya.n
 *
 */
public class SectionCollection<T extends Section<T, ID>, ID extends SectionId> {

	private T root;
	private Map<ID, T> idToRequestSectionMap = new HashMap<ID, T>();

	/**
	 * Constructor 
	 * @param root
	 */
	public SectionCollection(T root) {
		this.root = root;
		if(root != null) {
			idToRequestSectionMap.put(root.getId(), root);
			T reqSection = root;
			while(reqSection.hasNext()) {
				reqSection = reqSection.nextSection();
				idToRequestSectionMap.put(reqSection.getId(), reqSection);
			}
		}
	}

	/**
	 * This is used to get section based on id
	 * @param id
	 * @return
	 */
	public T getSection(ID id) {
		return (T) this.idToRequestSectionMap.get(id);
	}

	/**
	 * This is used to get root.
	 * @return the root
	 */
	public T getRoot() {
		return root;
	}
	/**
	 * This is used to get the size of the map.
	 * @return
	 */
	public int size() {
		return idToRequestSectionMap.size();
	}
}
