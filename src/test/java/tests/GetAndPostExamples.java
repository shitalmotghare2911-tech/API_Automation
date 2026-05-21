package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.matcher.RestAssuredMatchers.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;



public class GetAndPostExamples 
{
	@Test
	public void testGet()
	{
		baseURI = "https://reqres.in/api";
		given().
		header("x-api-key", "pro_ab5073c171a1c010d9c0fc7d37f3c9dee0d69440013c1eb29fc32bb3e03e4736").
		get("/users?page=2").
		then().
		  statusCode(200).
		  body("data[4].first_name", equalTo("George")).
		  body("data.first_name", hasItems("George", "Rachel"));
	}
	
	@Test
	public void testPost()
	{
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("name", "shitsl");
//		 
//		System.out.println(map);
		
		JSONObject request = new JSONObject();
		request.put("name", "shital");
		request.put("SIRname", "Motgahre");
		
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in/api";
		
		given().
		  header("x-api-key", "pro_ab5073c171a1c010d9c0fc7d37f3c9dee0d69440013c1eb29fc32bb3e03e4736").
//		  header("X-Reqres-Env", "prod")
		    header("Content-Type", "application/json")
		    .body(request.toString())
		.when()
		    .post("/users")
		.then()
		    .statusCode(201)
		    .log().all();
		
	}

	
	

}
