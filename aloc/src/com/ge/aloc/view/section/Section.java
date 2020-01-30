/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: Section.java
 * Purpose: Section used for the section id details.
 */
package com.ge.aloc.view.section;

/**
 * @author chaitanya.n
 *
 */
public abstract class Section<T extends Section<T, ID>, ID extends SectionId> {

	protected ID id;
	protected T prevSection;
	protected T nextSection;
	protected String readOnlyPage;
	protected String editPage;

	/**
	 * This is a parameter constructor for section 
	 * @param id
	 */
	Section(ID id) {
		this.id = id;
	}

	/**
	 * This is a parameter constructor for section
	 * @param id
	 * @param prevSection
	 * @param nextSection
	 */
	Section(ID id, T prevSection, T nextSection) {
		this.id = id;
		this.prevSection = prevSection;
		this.nextSection = nextSection;
	}

	/**
	 * This method is used to get the id
	 * @return the id
	 */
	public ID getId() {
		return id;
	}

	/**
	 * This method is used to get next section
	 * @return the nextSection
	 */
	public T nextSection() {
		return nextSection;
	}

	/**
	 * This method is used for setting the next section
	 * @param nextSection the nextSection to set
	 */
	@SuppressWarnings("unchecked")
	protected T setNextSection(T nextSection) {
		this.nextSection = nextSection;
		return (T) this;
	}

	/**
	 * This method is used to get the previous section
	 * @return the prevSection
	 */
	public T previousSection() {
		return prevSection;
	}

	/**
	 * This method is used to get the read only page
	 * @return the readOnlyPage
	 */
	public String getReadOnlyPage() {
		return readOnlyPage;
	}

	/**
	 * This method is used for getting the edit page
	 * @return the editPage
	 */
	public String getEditPage() {
		return editPage;
	}

	/**
	 * This method is used to set the previous section
	 * @param prevSection the prevSection to set
	 */
	@SuppressWarnings("unchecked")
	protected T setPreviousSection(T prevSection) {
		this.prevSection = prevSection;
		return (T) this;
	}

	/**
	 * This method is used for setting the read only page
	 * @param readOnlyPage the readOnlyPage to set
	 */
	@SuppressWarnings("unchecked")
	public T setReadOnlyPage(String readOnlyPage) {
		this.readOnlyPage = readOnlyPage;
		return (T) this;
	}

	/**
	 * This method is used for setting edit page
	 * @param editPage the editPage to set
	 */
	@SuppressWarnings("unchecked")
	public T setEditPage(String editPage) {
		this.editPage = editPage;
		return (T) this;
	}

	/**
	 * This method is used to check has next section 
	 * @return
	 */
	public boolean hasNext() {
		return (nextSection != null);
	}

	/**
	 * This method is used to check has previous section
	 * @return
	 */
	public boolean hasPrevious() {
		return (prevSection != null);
	}

	/**
	 * This method is used to check section is first section 
	 * @return
	 */
	public boolean isFirst() {
		return (prevSection == null);
	}

	/**
	 * This method is used to check section is last section
	 * @return
	 */
	public boolean isLast() {
		return (nextSection == null);
	}

	/**
	 * This method is used to check it has data
	 * @return
	 */
	public abstract boolean hasData();
}
