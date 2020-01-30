/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: StringConverter.java
 * Purpose: StringConverter used for for the conversion from object to string.
 */
package com.ge.icfp.util.convertion.formdef;

import formdef.plugin.conversion.ConversionContext;

/**
 * @author chaitanya
 *
 */
public class StringConverter extends formdef.plugin.conversion.StringConverter {
	
	/**
	 * convert
	 * @param context ConversionContext
	 * @return result String
	 */
	  public Object convert(ConversionContext context) {
		  String result = (String) super.convert(context);
		  if(result != null && result.trim().length() == 0) {
			  result = null;
		  }
		  return result;
	  }
}
