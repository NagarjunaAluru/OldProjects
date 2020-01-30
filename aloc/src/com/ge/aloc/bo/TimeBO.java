package com.ge.aloc.bo;

import java.util.Calendar;

import com.ge.aloc.constants.ALOCConstants;

/**
 * This class provides the business functionalities related to time model
 * 
 * @author ramakrishna.vadla
 */
public class TimeBO {
	private Integer hours;
	private Integer minutes;
	private String period;
	private final Calendar calendar;
	/**
	 * Default constructor
	 * @param calendar
	 */
	public TimeBO(Calendar calendar) {
		this.calendar = calendar;
	}

	/**
	 * This method is used to Get the hours
	 * @return
	 */
	public Integer getHours() {
		return hours;
	}

	/**
	 * This method is used to Set the hours
	 * @param hours
	 */
	public void setHours(Integer hours) {
		this.hours = hours;
		calendar.set(Calendar.HOUR, hours);
	}

	/**
	 * This method is used to Get the minutes
	 * @return
	 */
	public Integer getMinutes() {
		return minutes;
	}

	/**
	 * This method is used to Set the minutes
	 * @param minutes
	 */
	public void setMinutes(Integer minutes) {
		this.minutes = minutes;
		calendar.set(Calendar.MINUTE, minutes);
	}

	/**
	 * This method is used to Get the period i.e. AM or PM
	 * @return
	 */
	public String getPeriod() {
		return period;
	}

	/**
	 * This method is used to Set the period i.e. AM or PM
	 * @param period
	 */
	public void setPeriod(String period) {
		this.period = period;
		calendar.set(Calendar.AM_PM,ALOCConstants.AM.equalsIgnoreCase(period) ? Calendar.AM : Calendar.PM);
	}

}
