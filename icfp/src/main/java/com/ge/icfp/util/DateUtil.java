/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: DateUtil.java
 * Purpose: Util class for handing date format conversion
 */

package com.ge.icfp.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;


import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMessage;

/**
 * 
 * Util class for handing date format conversion
 * 
 * @author prithivi.dhamotharan
 *
 */
public class DateUtil {
	
	private static final Logger LOGGER = Logger.getLogger(DateUtil.class);
	
	/*
	 * FromDate and ToDate must be in mm/dd/yyyy format
	 * returns number of days between given two dates
	 */
	public static long daysBetweenDates(String fromDate,String toDate) {

		try{
			
			Calendar fromCalendar = Calendar.getInstance();
			Calendar toCalendar = Calendar.getInstance();

			String dd = "";
			String mm = "";
			String yyyy = "";

			if(fromDate!=null && fromDate.trim().length()>=10)
			{
				mm = fromDate.substring(0, 2);
				dd = fromDate.substring(3, 5);
				yyyy = fromDate.substring(6, 10);

				fromCalendar.set(new Integer(yyyy).intValue(),new Integer(mm).intValue(),new Integer(dd).intValue());

			}

			if(toDate!=null && toDate.trim().length()==10)
			{
				mm = toDate.substring(0, 2);
				dd = toDate.substring(3, 5);
				yyyy = toDate.substring(6, 10);

				toCalendar.set(new Integer(yyyy).intValue(),new Integer(mm).intValue(),new Integer(dd).intValue());

			}


			long milliseconds1 = fromCalendar.getTimeInMillis();
			long milliseconds2 = toCalendar.getTimeInMillis();

			long diff = milliseconds2 - milliseconds1;
			long diffDays = diff / (24 * 60 * 60 * 1000);

			return diffDays;

		}catch(Exception e)
		{
			LOGGER.debug("DateUtil:daysBetweenDates"+e);
			return 0;
		}

	}
	
	/*
	 * returns current date
	 */
	public static String getCurrentDate() {

		try{
			
			String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";
			
			Locale loc = Locale.getDefault();
			Calendar cal = Calendar.getInstance(loc);
		    
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		    
			return sdf.format(cal.getTime());

		}catch(Exception e)
		{
			LOGGER.debug("DateUtil:getCurrentDate"+e);
			return "";
		}
	}
	
	/*
	 * returns the day of the week
	 */
	public static String getDayofWeek(Date  date) throws Exception {

		try {
			
			SimpleDateFormat f = new SimpleDateFormat("EEEE");
		    return f.format(date);
			
		} catch (Exception exe) {

			LOGGER.debug("DateUtil:getDayofWeek"+exe);

		}
		return "";
	}
	/**
	 * getWorkingDays
	 * @param startDt Date
	 * @param endDt Date
	 * @return int
	 * @throws Exception if any thing happens.
	 */
	public static int getWorkingDays(Date startDt, Date endDt)throws Exception {

		try {

			Calendar startCal,endCal;
			startCal = Calendar.getInstance();
			startCal.setTime(startDt);
			endCal = Calendar.getInstance();
			endCal.setTime(endDt);

			int workDays = 0;

			//Return 0 if start and end are the same
			if (startCal.getTimeInMillis()==endCal.getTimeInMillis()) {
				return 0;
			}
			//Just in case the dates were transposed this prevents infinite loop
			if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
				startCal.setTime(endDt);
				endCal.setTime(startDt);
			}

			do {
				startCal.add(Calendar.DAY_OF_MONTH, 1);
				if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
					++workDays;
				}
			} while (startCal.getTimeInMillis() < endCal.getTimeInMillis() );

			return workDays;

		} catch (Exception exe) {

			LOGGER.debug("DateUtil:getWorkingDays"+exe);

		}
		return 0;

	}
	/**
	 * getValueDate
	 * @param dt XMLGregorianCalendar
	 * @param FORMAT String
	 * @return
	 */
	public static String getValueDate(XMLGregorianCalendar dt, final String FORMAT ){
		if(dt != null){
			SimpleDateFormat sdf = new SimpleDateFormat(FORMAT);
			Date date = dt.toGregorianCalendar().getTime();
			return sdf.format(date);
		}
		return "";
	}
	
	/*
	 * returns current date
	 */
	public static String getCurrentDate(String DATE_FORMAT_NOW) {

		try{
			
			Locale loc = Locale.getDefault();
			Calendar cal = Calendar.getInstance(loc);
		    
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
			
			return sdf.format(cal.getTime());

		}catch(Exception e)
		{
			LOGGER.debug("DateUtil:getCurrentDate"+e);
			return "";
		}
	}

	/**
	 * Method is used to validate the Latest Date of financial statement
	 * @param latestDtOfFinSttmnt
	 * @param errors
	 * @return
	 */
	public static ActionErrors validateLatestDtOfFinSttmnt(String latestDtOfFinSttmnt,ActionErrors errors)
	{
			try{
				
				String currentDate = DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss");
				String mm="";
				String dd="";
				String yyyy="";
				long diffDays = 0;
				
				if(currentDate!=null)
				{
					mm = currentDate.substring(5,7);
					dd = currentDate.substring(8,10);
					yyyy = currentDate.substring(0,4);
				}
				currentDate = mm+"/"+dd+"/"+yyyy;
				
				if(latestDtOfFinSttmnt!=null && latestDtOfFinSttmnt.trim().length()>=10)
				{
					diffDays = DateUtil.validateLastStmtDate(currentDate, latestDtOfFinSttmnt );
				}
				
				if(diffDays>=0)
				{
					if(errors == null)
					{
						errors = new ActionErrors();
					}
					errors.add("latestDtOfFinSttmntCurrDateValidation", new ActionMessage("latestDtOfFinSttmntValidation"));
				}
			}catch(Exception e)
			{
				return null;
			}
		return errors;
	}
	
	/*
	 * FromDate and ToDate must be in mm/dd/yyyy format
	 * FromDate is moved back to one year
	 * returns number of days between given two dates
	 */
	public static long validateLastStmtDate(String fromDate,String toDate) {

		try{
			
			Calendar fromCalendar = Calendar.getInstance();
			Calendar toCalendar = Calendar.getInstance();

			String dd = "";
			String mm = "";
			String yyyy = "";

			if(fromDate!=null && fromDate.trim().length()>=10)
			{
				mm = fromDate.substring(0, 2);
				dd = fromDate.substring(3, 5);
				yyyy = fromDate.substring(6, 10);

				fromCalendar.set(new Integer(yyyy).intValue(),new Integer(mm).intValue(),new Integer(dd).intValue());

			}

			if(toDate!=null && toDate.trim().length()==10)
			{
				mm = toDate.substring(0, 2);
				dd = toDate.substring(3, 5);
				yyyy = toDate.substring(6, 10);

				toCalendar.set(new Integer(yyyy).intValue(),new Integer(mm).intValue(),new Integer(dd).intValue());

			}
			fromCalendar.add(Calendar.MONTH, -12);
			

			long milliseconds1 = fromCalendar.getTimeInMillis();
			long milliseconds2 = toCalendar.getTimeInMillis();

			long diff = milliseconds2 - milliseconds1;
			long diffDays = diff / (24 * 60 * 60 * 1000);
			
			return diffDays;

		}catch(Exception e)
		{
			LOGGER.debug("DateUtil:validateLastStmtDate"+e);
			return 0;
		}

	}
	
	
	/**
	 * Method is used to validate the " value date "
	 * @param valueDt
	 * @param errors
	 * @return
	 */
	public static ActionErrors validateValueDt(String valueDt,ActionErrors errors)
	{
			try{
				String mm="";
				String dd="";
				String yyyy="";
				Calendar valueDate = null;
				Calendar currentDate = null;
				int workingDays = 0;
				
			
				String currentDt = DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss");
				String currentDateStr="";
				if(currentDt!=null)
				{
					mm = currentDt.substring(5,7);
					dd = currentDt.substring(8,10);
					yyyy = currentDt.substring(0,4);
					currentDateStr = mm+"/"+dd+"/"+yyyy;
				}
				
				currentDate = new GregorianCalendar(new Integer(yyyy).intValue(),new Integer(mm).intValue(),new Integer(dd).intValue());

				
				if(valueDt!=null && valueDt.trim().length()>=10)
				{
					mm = valueDt.substring(0, 2);
					dd = valueDt.substring(3, 5);
					yyyy = valueDt.substring(6, 10);
					String vaultDtStr = mm+"/"+dd+"/"+yyyy;
				
					valueDate = new GregorianCalendar(new Integer(yyyy).intValue(),new Integer(mm).intValue(),new Integer(dd).intValue());
					           
				   long  diffDays = DateUtil.daysBetweenDates(currentDateStr, vaultDtStr );
					if(diffDays<=0)
					{
						if(errors == null)
						{
							errors = new ActionErrors();
						}
						errors.add("valueDateValidation", new ActionMessage("valueDateValidation"));
						
						if(errors!=null && !errors.isEmpty())
						{
							return errors;
						}
					}
					
					workingDays = DateUtil.getWorkingDays(currentDate.getTime(),valueDate.getTime());
					if(workingDays<10)
					{
						if(errors == null)
						{
							errors = new ActionErrors();
						}
						errors.add("valueDateValidation", new ActionMessage("valueDateValidation"));
						if(errors!=null && !errors.isEmpty())
						{
							return errors;
						}
					}
					valueDate = null;
					valueDate = new GregorianCalendar(new Integer(yyyy).intValue(),new Integer(mm).intValue()-1,new Integer(dd).intValue());
					String dayOfWeek = DateUtil.getDayofWeek(valueDate.getTime());
										
					if(dayOfWeek!=null && (dayOfWeek.equals("Sunday") || dayOfWeek.equals("Saturday")))
					{
						if(errors == null)
						{
							errors = new ActionErrors();
						}

						errors.add("dayOfTheWeek", new ActionMessage("dayOfTheWeek"));
					}
				}

				}catch(Exception e)
				{
					return null;
				}
		return errors;
	}
	

	/**
	 * Method is used to validate the Draw down date
	 * @param drawdowndate validation
	 * @param errors
	 * @return
	 */
	public static boolean validateDrawdownDate(String drawDownDate,String valueDate)
	{
			long diffDays = 0;

			if(drawDownDate!=null && valueDate!=null && drawDownDate.trim().length()>=10 && valueDate.trim().length()>=10)
			{
				diffDays = DateUtil.daysBetweenDates(valueDate, drawDownDate );
			}

			if(diffDays<0)
			{
				return false;
			}

			return true;
	}
	

}
