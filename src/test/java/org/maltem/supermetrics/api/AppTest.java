package org.maltem.supermetrics.api;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }
    
    /**
     * Assert that API is answering 
     * @throws ClientProtocolException
     * @throws IOException
     */
    public void testStatus() throws ClientProtocolException, IOException {
    	   // Given
    	   HttpUriRequest request = new HttpGet( 
    			   "https://supermetrics.com/api/q/smqcSBip30qkbHeRjaWYMVjVHIEe1z7_KWSSBjk6BU5VWEnchWxxvDjD5Gcn_BJvF4EeVNWy"
    			   );
    	 
    	   // When
    	   HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
    	 
    	   // Then
    	   assertTrue(
    	     httpResponse.getStatusLine().getStatusCode()==HttpStatus.SC_OK);
		
    	assertTrue(true);
    	
    }
    
    /**
     * Assert that API is returning 
     * @throws ClientProtocolException
     * @throws IOException
     */
    public void testContentType() throws ClientProtocolException, IOException {
    	  
    	   // Given
    	   String jsonMimeType = "text/html";
    	   HttpUriRequest request = new HttpGet( 
    			   "https://supermetrics.com/api/q/smqyNdoyH_nVCzW9I5UBfeRQDymxxYpf8quzQDkXlZFioUeRx0H2L1bWlkXIvglT9vimqhf"
    			   );
    	 
    	   // When
    	   HttpResponse response = HttpClientBuilder.create().build().execute( request );
    	   
    	   // Then
    	   String mimeType = ContentType.getOrDefault(response.getEntity()).getMimeType();
    	   assertEquals( jsonMimeType, mimeType );
    }
    
    
}
