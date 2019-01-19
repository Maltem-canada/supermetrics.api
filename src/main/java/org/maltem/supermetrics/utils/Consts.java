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
	public static final String API_URL = "https://supermetrics.com/api/v1/getData?metrics=Clicks%2CCost&dimensions=Date&maxResults=50&dateRangeType=custom&start-date=startDateReplace&end-date=endDateReplace&profiles=%5B%7B%22ID%22%3A%229217631823%22%2C%22name%22%3A%229217631823%22%7D%5D&dataSource=AW&dsUser=9217631823&apiKey=api_LEyB36lHn0dMmmOZ5_ALiCu5XLXaE9cnfqU0eRHe0568nSxiKs_jqwAF2H9KNqAvpfXrJVw_zPFr7NUUPX3_k23akXVWbcPSJPLQ&targetAppFormat=qlik";
	
	
	/**
	 * Errors 
	 * 
	 */
	public static final String ERROR_STARTMODE_NOT_FOUND = "The starting mode argument specified at the start of the application is not recognized. Please use either INIT, RECURRENT, CUSTOM.";
	
	

}
