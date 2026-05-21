package tests;
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class testOnLocalAPI 
{
	@Test
	public void get()
	{
		baseURI = "http://localhost:3000";
		given()
		.get("/users").then().statusCode(200);
	}
	
//   @Test
//	public void put() 
//	{
//		
//		JSONObject request = new JSONObject();
//		
//		request.put("firstName" , "laura");
//		request.put("lastName" , "paul");
//		request.put("subjectID", 3);
//		request.put("id", 3);
//		
//		baseURI = "http://localhost:3000";
//		
//		given()
//		  .contentType(ContentType.JSON)
//		  .accept(ContentType.JSON )
//	  .body(request.toJSONString())
//    .when()
//	      .post("/users")
//	      
//	    .then().statusCode(201);	
//	}
	
//	@Test
//	public void patch() 
//	{
//		
//		JSONObject request = new JSONObject();
//		
//		request.put("firstName" , "chanda");
//		request.put("lastName" , "rey");
//		request.put("subjectID", 1);
//		request.put("id", 4);
//		
//		baseURI = "http://localhost:3000";
//		
//		given()
//		  .contentType(ContentType.JSON)
//		  .accept(ContentType.JSON )
//		  .body(request.toJSONString())
//	    .when()
//	      .patch("/users/4")
//	      
//	    .then().statusCode(200);
//	}
	@Test
	public void delete()
	{
		baseURI = "http://localhost:3000";
		given().
		when().delete("/users/1").then().statusCode(200);
	}
}
