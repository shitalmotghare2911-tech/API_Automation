package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PutPatchDeleteExamples 
{
	@Test
	public void TestPut()
	{
	JSONObject request = new JSONObject();
	request.put("name", "shital");
	request.put("SIRname", "Motgahre");
	
	System.out.println(request.toJSONString());
	
	baseURI = "https://reqres.in/api";
	
	given().
	  header("x-api-key", "pro_ab5073c171a1c010d9c0fc7d37f3c9dee0d69440013c1eb29fc32bb3e03e4736").
//	  header("X-Reqres-Env", "prod")
	    header("Content-Type", "application/json")
	    .body(request.toString())
	.when()
	    .put("/users/2")
	.then()
	    .statusCode(200)
	    .log().all();
	}
	
	@Test
	public void testPatch()
	{
	JSONObject request = new JSONObject();
	request.put("name", "shital");
	request.put("SIRname", "Motgahre");
	
	System.out.println(request.toJSONString());
	
	baseURI = "https://reqres.in";
	
	given().
	  header("x-api-key", "pro_ab5073c171a1c010d9c0fc7d37f3c9dee0d69440013c1eb29fc32bb3e03e4736").
//	  header("X-Reqres-Env", "prod")
	    header("Content-Type", "application/json")
	    .body(request.toString())
	.when()
	    .patch("/api/users/2")
	.then()
	    .statusCode(200)
	    .log().all();
	}
	
	@Test
	public void testDelete()
	{

	baseURI = "https://reqres.in";
	
	given().
	  header("x-api-key", "pro_ab5073c171a1c010d9c0fc7d37f3c9dee0d69440013c1eb29fc32bb3e03e4736").
      header("X-Reqres-Env", "prod").
	    header("Content-Type", "application/json")
	    .when()
	    .delete("/api/users/2")
	.then()
	    .statusCode(204)
	    .log().all();
	}
}
