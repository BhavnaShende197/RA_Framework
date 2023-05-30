package com.bhavna.javaapi.reqrepo;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.BeforeTest;

import com.bhavna.javaapi.commommethod.UtilityCommonMethod;


public class PostReqRepo {
	@BeforeTest

	public static String baseURI() {
		
	String baseuri = "https://api.instantwebtools.net";
	return baseuri;
	}	
	public static String postResource() {
		
		String postresource = "/v1/passenger";
		return postresource;
	}
	
	public static String request1() throws IOException {
		ArrayList<String> airline = UtilityCommonMethod.readDataExcel("POST_SHEET", "Post_TC_1");
		//System.out.println(data);
		String req_name=airline.get(1);
	    String req_trips=airline.get(2);
		String req_airline=airline.get(3);

		String requestbody="{\r\n"
				+ "    \"name\": \""+req_name+"\",\r\n"
				+ "    \"trips\":\""+req_trips+"\",\r\n"
				+ "    \"airline\":\""+req_airline+"\"r\n"
				+ "}";
		
		return requestbody;
	}
	
	public static String request2() throws IOException {
		ArrayList<String> airline = UtilityCommonMethod.readDataExcel("POST_SHEET", "Post_TC_2");
		//System.out.println(data);
		String req_name=airline.get(1);
	    String req_trips=airline.get(2);
		String req_airline=airline.get(3);

		String requestbody="{\r\n"
				+ "    \"name\": \""+req_name+"\",\r\n"
				+ "    \"trips\":\""+req_trips+"\",\r\n"
				+ "    \"airline\":\""+req_airline+"\"r\n"
				+ "}";
		
		return requestbody;
	}
	
	public static String request3() throws IOException {
		ArrayList<String> airline = UtilityCommonMethod.readDataExcel("POST_SHEET", "Post_TC_3");
		//System.out.println(data);
		String req_name=airline.get(1);
	    String req_trips=airline.get(2);
		String req_airline=airline.get(3);

		String requestbody="{\r\n"
				+ "    \"name\": \""+req_name+"\",\r\n"
				+ "    \"trips\":\""+req_trips+"\",\r\n"
				+ "    \"airline\":\""+req_airline+"\"r\n"
				+ "}";
		
		return requestbody;
	}
}
	

