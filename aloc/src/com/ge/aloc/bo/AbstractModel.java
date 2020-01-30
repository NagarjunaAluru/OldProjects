/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: AbstractModel.java
 * Purpose: AbstractModel used for the all the models
 */
package com.ge.aloc.bo;

import java.io.Serializable;

import com.hydus.hwf.security.JAXBObjectSecureSerializer;

/**
 * @author chaitanya.n
 *
 */
public class AbstractModel<T extends Serializable> extends JAXBObjectSecureSerializer {

	protected T model;

	/**
	 * Default constructor
	 * @param model
	 */
	protected AbstractModel(T model) {
		this.model = model;
	}

	/**
	 * This method is used to get the model.
	 * @return
	 */
	public T getModel() {
		return this.model;
	}
}
