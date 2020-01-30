/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: AbstractFormlMapper.java
 * Purpose: AbstractFormlMapper used for fill modal and form objects
 */
package com.ge.icfp.form;

/**
 * @author chaitanya
 *
 */
public abstract class AbstractFormlMapper<MODEL, FORM> {
	/**
	 * createAndFillModel
	 * @param form
	 * @return
	 */
	public MODEL createAndFillModel(FORM form) {
		MODEL model = createModel();
		fillModel(model, form);
		return model;
	}
	/**
	 * fillModel
	 * @param model
	 * @param form
	 */
	public abstract void fillModel(MODEL model, FORM form);
	/**
	 * fillForm
	 * @param form
	 * @param model
	 */
	public abstract void fillForm(FORM  form, MODEL model);
	/**
	 * createModel
	 * @return
	 */
	protected abstract MODEL createModel();
	/**
	 * createAddLegModel
	 * @param form
	 * @return
	 */
	public MODEL createAddLegModel(FORM form) {
		MODEL model = createModel();
		form = fillAddLegModel(model, form);
		return model;
	}
	/**
	 * fillAddLegModel
	 * @param model
	 * @param form
	 * @return
	 */
	public FORM fillAddLegModel(MODEL model, FORM form) {
		return form;
	}
	
}
