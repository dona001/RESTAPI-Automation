package com.qa.tests;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.RestClient;

public class GetAPITest extends TestBase{
	TestBase testbase;
	String apiUrl;
	String serviceUrl;
	String url;
	RestClient restClient;
	
	
	@BeforeMethod
	public void setUP() throws ClientProtocolException, IOException {
		testbase = new TestBase();
		apiUrl =  prop.getProperty("URL");
		serviceUrl = prop.getProperty("serviceURL");
		
		url = serviceUrl + apiUrl;
		
		
		
	}
	
	@Test
	public void getTest() throws ClientProtocolException, IOException {
		restClient = new RestClient();
		restClient.get(url);
		
	}
	

}
