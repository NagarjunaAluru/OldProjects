/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: XMLGregorianCalendarConverter.java
 * Purpose: XMLGregorianCalendarConverter used for for the date conversion.
 */
package com.ge.icfp.util.convertion.formdef;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.log4j.Logger;

import formdef.plugin.conversion.ConversionContext;
import formdef.plugin.conversion.Converter;

/**
 * @author chaitanya
 *
 */
public class XMLGregorianCalendarConverter implements Converter {
	
	private static final Logger LOGGER = Logger.getLogger(XMLGregorianCalendarConverter.class);

	/** 
	 * @see formdef.plugin.conversion.Converter#convert(formdef.plugin.conversion.ConversionContext)
	 */
	public Object convert(ConversionContext context) throws Exception {
		
		Object value = context.getValue();
		Class<?> type = context.getType();
		Object param = context.getParam();
		Locale locale = context.getLocale();
		String propertyName = context.getPropertyName();
		
		if(LOGGER.isDebugEnabled()) {
			StringBuilder msg = new StringBuilder();
			msg.append("Converting [").append(value).append("] to type [").append(type)
			.append("] using param=[").append(param).append("]");
			LOGGER.debug(msg.toString());
		}
		
		if (param == null) {
            throw new IllegalArgumentException("Date fields require a conversion format."); 
        }
		
		SimpleDateFormat sdf = new SimpleDateFormat((String) param, locale);
		
		// Converting String values to XMLGregorianCalendar
		if(value instanceof String) {
			if(!type.equals(XMLGregorianCalendar.class)) {
				StringBuilder msg = new StringBuilder().append("Unsupported type parameter: ").append(type)
						.append(" for property ").append(propertyName);
				  throw new IllegalArgumentException(msg.toString());
			}
			
			// create a date instance and set its value
            java.util.Date date = null;
            try {
                date = sdf.parse((String) value);
            } catch (ParseException e) {
                return null;
            }
            
            GregorianCalendar gc = new GregorianCalendar();
        	gc.setTime(date);
        	return DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
		} else {
			// Either expecting null or String
			if ((value == null) || ((value instanceof String) && (((String)value).length() <= 0))) {
                if (type.equals(String.class)) {
                    return "";
                } else {
                    return null;
                }
            }
            
			XMLGregorianCalendar gcValue = (XMLGregorianCalendar) value;
            return sdf.format(gcValue.toGregorianCalendar().getTime());
		}
	}
}
