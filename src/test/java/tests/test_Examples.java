package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class test_Examples
{
	@Test
	public void test_1()
	{
		 Response response = RestAssured
	                .given()
	                .header("x-api-key", "pro_ab5073c171a1c010d9c0fc7d37f3c9dee0d69440013c1eb29fc32bb3e03e4736")
	                .get("https://reqres.in/api/users?page=2");
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		
		int statusCode = response.getStatusCode();
		
		Assert.assertEquals(statusCode, 200);		
	}
	
	@Test
	public void test_2()
	{
		baseURI = "https://reqres.in/api";
		given().
		header("x-api-key", "pro_ab5073c171a1c010d9c0fc7d37f3c9dee0d69440013c1eb29fc32bb3e03e4736").
		get("/users?page=2").
		then().
		statusCode(200).
		body("data[1].id", equalTo(8));
			
	}

	


}
