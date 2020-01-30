/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: SectionFactory.java
 * Purpose: SectionFactory used for the build the section tree.
 */
package com.ge.aloc.view.section;


/**
 * @author chaitanya.n
 *
 */
public abstract class SectionFactory<T extends Section<T, ID>, ID extends SectionId> {

	/**
	 * Constructor to create instance
	 * @return
	 */
	public SectionCollection<T, ID> create() {
		T rootSection = buildTree();
		return new SectionCollection<T, ID>(rootSection);
	}

	/**
	 * This is used to build the tree.
	 * @param requestDetails
	 * @return
	 */
	protected abstract T buildTree();
}
