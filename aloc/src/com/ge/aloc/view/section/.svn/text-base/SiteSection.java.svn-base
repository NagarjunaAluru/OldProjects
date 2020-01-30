/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: SiteSection.java
 * Purpose: SiteSection used for the section display.
 */
package com.ge.aloc.view.section;

/**
 * @author madhusudhan.gosula
 *
 */
public abstract class SiteSection extends Section<SiteSection, SiteSectionId>{


	/**
	 * Constructor to create instance
	 * @param id
	 */
	SiteSection(SiteSectionId id) {
		super(id);
	}
	/**
	 * Constructor with id, prevSection and next Section.
	 * @param id
	 * @param prevSection
	 * @param nextSection
	 */
	SiteSection(SiteSectionId id, SiteSection prevSection, SiteSection nextSection) {
		super(id, prevSection, nextSection);
	}

	/**
	 * This is used to show link.
	 * @return
	 */
	public boolean showLink() {
		return nextSection().showLink() || hasData() || isFirst();
	}
}
