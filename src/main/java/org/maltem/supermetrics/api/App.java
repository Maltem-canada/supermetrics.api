package org.maltem.supermetrics.api;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.ZoneId;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.maltem.supermetrics.utils.Consts;
import org.maltem.supermetrics.utils.Utils;

/**
 * Hello world!
 *
 */
public class App 
{
	// TODO : 	- error gestion of api not having data for the day
	// 			- dynamic file name with parsing of date etc 
	//			- readme 
    public static void main( String[] args )
    { 
    	ApiCaller apiCaller = new ApiCaller() ;
    	CsvWriter csvWriter = new CsvWriter() ;
    	String startDate = null;
    	String endDate = null;
    	
    	
    	/**
    	 * Getting the app starting mode and settings dates accordingly
    	 */
    	String startingMode = args[0];
    	switch (startingMode) {
    	case Consts.INIT:
    		startDate = Consts.API_MIN_STARTDATE;
    		endDate = Utils.getTodayDate(ZoneId.of("America/Montreal"));
    		break;
    	case Consts.RECURRENT:
    		startDate = Utils.getTodayDate(ZoneId.of("America/Montreal"));
    		endDate = Utils.getTodayDate(ZoneId.of("America/Montreal"));
    		break;
    	case Consts.CUSTOM:
    		startDate = args[1];
    		endDate = args[2];
    		break;
    	default: 
    		throw new RuntimeException(Consts.ERROR_STARTMODE_NOT_FOUND);
    	}
    	
    	// Setting API's Url
        String apiUrl = Consts.API_URL.replaceFirst("startDateReplace", startDate).replaceFirst("endDateReplace", endDate);
        
		try {
			// Calling API 
			HttpResponse response = apiCaller.getData(apiUrl);

	        // Transforming response into consumable String data
	        String apiData = Utils.inputStreamToString(response.getEntity().getContent());
	        
	        // Writing CSV
	 	   	csvWriter.createCsv(apiData, ",", "finalTest.csv");
	 	   	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    }
}
