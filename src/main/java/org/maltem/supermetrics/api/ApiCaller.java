package org.maltem.supermetrics.api;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;

public class ApiCaller {
	
	/**
	 * 
	 * @param url
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	protected HttpResponse getData(String url) throws ClientProtocolException, IOException {
		HttpUriRequest request = new HttpGet(url);
 	   	return HttpClientBuilder.create().build().execute( request );
	}

}
