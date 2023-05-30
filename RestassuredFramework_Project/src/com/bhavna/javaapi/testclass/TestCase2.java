package com.bhavna.javaapi.testclass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.bhavna.javaapi.commommethod.CommonMethod;
import com.bhavna.javaapi.commommethod.UtilityCommonMethod;
import com.bhavna.javaapi.reqrepo.PostReqRepo;

import io.restassured.path.json.JsonPath;

public class TestCase2 {
	@Test
public static void run() throws IOException{
		
		for(int i = 0; i<5; i++) {
			
			int res_Status_Code = CommonMethod.response_StatusCode(PostReqRepo.baseURI(), 
					PostReqRepo.postResource(),PostReqRepo.request2());
			
			if(res_Status_Code == 200) {
			
			String response_Body = CommonMethod.response_Body (PostReqRepo.baseURI(), 
					PostReqRepo.postResource(),PostReqRepo.request2());
			
			System.out.println(response_Body);
			
			TestCase1.validator(response_Body, res_Status_Code);
			UtilityCommonMethod.evidenceFileCreater("TestCase2", PostReqRepo.request2(),response_Body);
			
			System.out.println(res_Status_Code);
			break;
			
			}
			
			else {
				System.out.println("Correct status code is not found, hence retrying the API ");
			}
		}
		
		
	}
	
		public static void validator(String responsebody,int statusCode) throws IOException {
		
		JsonPath jsprequest = new JsonPath(PostReqRepo.request2());   //Creating s JSON Object 
		String req_name = jsprequest.getString("name");
		String req_job = jsprequest.getString("job");
		
		// Parse the response body
		JsonPath jsp = new JsonPath(responsebody);
		String res_name = jsp.getString("name");
		String res_job = jsp.getString("job");
		String res_id = jsp.getString("id");
		//String res_createdAt=jsp.getString("createdAt"); 
		//String currentdate=LocalDate.now().toString();
		
		//System.out.println(currentdate);
		
		
		
		// Validate the response body parameters
		Assert.assertEquals(res_name, req_name);
		Assert.assertEquals(res_job, req_job);
		Assert.assertNotNull(res_id);
		//Assert.assertEquals(res_createdAt.substring(0,10), currentdate);
		
	  
	
	}

}

