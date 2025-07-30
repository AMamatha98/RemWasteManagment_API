package APITests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CRUDE_GET extends Base {
	
	
	@Test(enabled=false)
	public void loginTest() {
	  
	    given()
	        .contentType(ContentType.JSON)
	        .body("{\"username\": \"admin\", \"password\": \"admin123\"}")
	    .when()
	        .post("/login")
	    .then()
	        .statusCode(anyOf(is(201), is(404))); 
	}
	
	@Test(priority=1,dependsOnMethods = {"APITests.CRUDE_POST.CreateItems"})
	public void GetItem() throws IOException
	{
		id1 = new String(Files.readAllBytes(Paths.get("item_id.txt")));
	Response response=given().log().all().contentType(ContentType.JSON)
		
		.when()
		    .get("/items/"+id1)
		.then()
		    .statusCode(200).extract().response();
	
	System.out.println("Response Body:\n" + response.asString());
	
	response.then().body("_id", equalTo(id1));

	}
	
	@Test(priority = 2)
	public void GetAllItems() {
	    given()
	        .log().all()
	        .contentType(ContentType.JSON)
	    .when()
	        .get("/items")
	    .then()
	        .statusCode(200)
	        .body("$", not(empty()));  
	}
}
