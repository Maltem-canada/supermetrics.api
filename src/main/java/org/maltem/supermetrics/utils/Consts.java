package org.maltem.supermetrics.utils;

import java.text.SimpleDateFormat;

public final class Consts {
	
	/**
	 * Application's starting options
	 */
	public static final String INIT = "INIT" ;
	public static final String RECURRENT = "RECURRENT" ;
	public static final String CUSTOM = "CUSTOM" ; 
	
	/**
	 * API's dates 
	 */
	public static final String API_DATE = "yyyy-MM-dd";
	public static final SimpleDateFormat API_SDF = new SimpleDateFormat("yyyy-MM-dd");
	public static final String API_MIN_STARTDATE = "2000-01-01";
	
	/**
	 * API URL
	 */
	public static final String API_URL = "";
	
	
	/**
	 * Errors 
	 * 
	 */
	public static final String ERROR_STARTMODE_NOT_FOUND = "The starting mode argument specified at the start of the application is not recognized. Please use either INIT, RECURRENT, CUSTOM.";
	
	

}
