package com.qa.client;

import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;

public class RestClient {
	
	//1.GEt Method
	public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException {
	CloseableHttpClient httpClient = HttpClients.createDefault();  
	HttpGet httpget = new HttpGet(url);  //create new url with method
	CloseableHttpResponse closeableHttpResponse =  httpClient.execute(httpget);
	
	return closeableHttpResponse;
	
	}
	
	//Get with header
	public CloseableHttpResponse get(String url, HashMap<String, String> headerMap) throws ClientProtocolException, IOException {
	CloseableHttpClient httpClient = HttpClients.createDefault();  
	HttpGet httpget = new HttpGet(url);  //create new url with method
	
	//Defined  header value and key 
	for(Map.Entry<String,String> entry : headerMap.entrySet()) {
		httpget.addHeader(entry.getKey(),entry.getValue());
	}
	
	CloseableHttpResponse closeableHttpResponse =  httpClient.execute(httpget);
	
	return closeableHttpResponse;
	
	}

}
