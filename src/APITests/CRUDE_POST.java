package APITests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CRUDE_POST extends Base {
	
	//TestDataStore td=new TestDataStore();
	 
		
	@Test(priority=1,enabled=true)
	public  void CreateItems() throws IOException
	{
		Response response1 = given().log().all().contentType(ContentType.JSON)
		.body("{ \"name\": \"Mamatha\" }")
		.when()
		    .post("/items")
		.then()
		    .statusCode(201).extract().response();
		
		
		id1= response1.jsonPath().getString("_id");
		
		Files.write(Paths.get("item_id.txt"), id1.getBytes());
		
		Response response2 = given().log().all().contentType(ContentType.JSON)
				.body("{\"name\":\"Likitha\"}")
				.when()
				    .post("/items")
				.then()
				    .statusCode(201).extract().response();
				 id2=response2.jsonPath().getString("_id");
			
				 Files.write(Paths.get("item_id.txt"), id2.getBytes());
		System.out.println(id1);
		System.out.println(id2);
	}
	
	@Test(priority=2)
	public void CreateItemWithInvalidPayload() {
	    given()
	        .log().all()
	        .contentType(ContentType.JSON)
	        .body("{\"\":\"Likitha\"}") 
	    .when()
	        .post("/items")
	    .then()
	        .statusCode(anyOf(is(400), is(500)));
	}
	

}
