package com.qa.client;

import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;

public class RestClient {
	
	//1.GEt Method
	public void get(String url) throws ClientProtocolException, IOException {
	CloseableHttpClient httpClient = HttpClients.createDefault();  
	HttpGet httpget = new HttpGet(url);  //create new url with method
	CloseableHttpResponse closeableHttpResponse =  httpClient.execute(httpget);
	int statusCode =  closeableHttpResponse.getStatusLine().getStatusCode();
	System.out.println("Status Code--->"+statusCode);
	
	
	String responceString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");  //pure string
	
	//json cenvert to String 
	JSONObject responceJson = new JSONObject(responceString);
	System.out.println("Responce Json-->"+responceJson);
	
	//Header Responce 
	Header[] headersArray = closeableHttpResponse.getAllHeaders();
	
	HashMap<String, String> allHeaders = new HashMap<String, String>();
	for(Header header : headersArray) {
		allHeaders.put(header.getName(), header.getValue());
	}
	
	System.out.println("Header Array---"+allHeaders);

	 
	
	}

}
