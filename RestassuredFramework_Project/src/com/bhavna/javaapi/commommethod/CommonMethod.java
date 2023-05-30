package com.bhavna.javaapi.commommethod;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

public class CommonMethod {
	
	public static int response_StatusCode(String baseuri, String postresource, String requestBody) {
		
		RestAssured.baseURI= baseuri;		
		// Configure Request Body
		int statusCode =given().header("Content-Type","application/json").body(requestBody)
				.when().post(postresource).then().extract().statusCode();
		
		return statusCode;
		
	}
	
    public static String response_Body(String baseuri, String postresource, String requestBody) {
		
		RestAssured.baseURI= baseuri;		
		
		String responseBody = given().header("Content-Type","application/json").body(requestBody)
				.when().post(postresource).then().extract().response().asString();
		return responseBody;
		

}

}
