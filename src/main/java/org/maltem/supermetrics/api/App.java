package org.maltem.supermetrics.api;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;

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
    	
    	// Setting URL API 
        /**
        String startDate = args[0]; 
        String endDate = args[1];
        
        String apiUrl = String.format("", startDate, endDate);
        **/
        String apiUrl = "https://supermetrics.com/api/q/smqB9NCAvnAcw4qkcmujBENhuBYl47ds5YGHHMJCjXWDICVZgU6LB1jviwTIlmoHqlyZz2wnU";
 	   	
        // Calling API 
        HttpResponse response = apiCaller.getData(apiUrl); 
 	   
        // Transforming response into consumable String data
        String apiData = Utils.inputStreamToString(response.getEntity().getContent());
 	   
        // Writing CSV
 	   	csvWriter.createCsv(apiData, ",", "finalTest.csv");
    }
}
