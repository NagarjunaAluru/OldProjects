/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: RequestSection.java
 * Purpose: RequestSection used for the section display.
 */
package com.ge.aloc.view.section;

/**
 * 
 * @author chaitanya.n
 *
 */
public abstract class RequestSection extends Section<RequestSection, RequestSectionId>{

	/**
	 * Default constructor
	 * @param id
	 */
	RequestSection(RequestSectionId id) {
		super(id);
	}

	/**
	 * constructor with id, prev section an dnext section.
	 * @param id
	 * @param prevSection
	 * @param nextSection
	 */
	RequestSection(RequestSectionId id, RequestSection prevSection, RequestSection nextSection) {
		super(id, prevSection, nextSection);
	}

	/**
	 * This i sused to show the link
	 * @return
	 */
	public boolean showLink() {
		return nextSection().showLink() || hasData() || isFirst();
	}
}
