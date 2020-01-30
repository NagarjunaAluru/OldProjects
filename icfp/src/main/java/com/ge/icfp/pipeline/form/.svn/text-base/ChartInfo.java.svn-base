/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: ChartInfo.java
 * Purpose: ChartInfo data carrier for display chat
 */
package com.ge.icfp.pipeline.form;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import com.ge.icfp.model.DealRequest.StatusInfo;
import com.hydus.wff.core.security.JAXBObjectSecureSerializer;
/**
 * 
 * @author arijit.biswas
 *
 */
public class ChartInfo extends JAXBObjectSecureSerializer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String DATE_COMPLETED_FORMAT = "MMM dd, yyyy hh:mm a z";
	private StatusInfo statusInfo;
	private String status;
	private DateFormat completedDateFormat = new SimpleDateFormat(DATE_COMPLETED_FORMAT);
	
	/**
	 * Creates the ChatInfo object
	 * 
	 * @param status
	 * @param statusInfo
	 */
	public ChartInfo(String status, StatusInfo statusInfo){
		this.status = status;
		this.statusInfo = statusInfo;
	}
	/**
	 * Returns the status
	 * 
	 * @return
	 */
	public String getStatus(){
		return status;
	}
	
	/**
	 * Returns the name
	 * @return
	 */
	public String getName(){
		return statusInfo.getActionBy();
	}

	public StatusInfo getStatusInfo(){
		return statusInfo;
	}
	
	/**
	 * Returns the completion date.
	 * 
	 * @return
	 * @throws ParseException
	 */
	@Transient
	public String getDateCompleted() throws ParseException{
		if(statusInfo.getDate() != null){
			GregorianCalendar gc = statusInfo.getDate().toGregorianCalendar();
			Date date = new Date(gc.getTimeInMillis());
			return completedDateFormat.format(date);
		}
		return "-";
	}
}
