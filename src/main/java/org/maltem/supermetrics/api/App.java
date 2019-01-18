package org.maltem.supermetrics.api;

import java.io.IOException;
import java.time.LocalDate;

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
	
    public static void main( String[] args ) throws ClientProtocolException, IOException
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
    		endDate = Consts.API_SDF.format(LocalDate.now());
    		break;
    	case Consts.RECURRENT:
    		startDate = Consts.API_SDF.format(LocalDate.now());
    		endDate = Consts.API_SDF.format(LocalDate.now());
    		break;
    	case Consts.CUSTOM:
    		startDate = args[1];
    		endDate = args[2];
    		break;
    	default: 
    		throw new RuntimeException(Consts.ERROR_STARTMODE_NOT_FOUND);
    	}
    	
    	// Setting API's Url
        String apiUrl = String.format(Consts.API_URL, startDate, endDate);
        
 	   	
        // Calling API 
        HttpResponse response = apiCaller.getData(apiUrl); 
 	   
        // Transforming response into consumable String data
        String apiData = Utils.inputStreamToString(response.getEntity().getContent());
 	   
        // Writing CSV
 	   	csvWriter.createCsv(apiData, ",", "finalTest.csv");
    }
}
