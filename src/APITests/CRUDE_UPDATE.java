package APITests;

import static io.restassured.RestAssured.given;


import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;

public class CRUDE_UPDATE extends Base {
	
	
	@Test(priority=1)
	public void UpdateItem() throws IOException
	{
		

		    id1 = new String(Files.readAllBytes(Paths.get("item_id.txt")));
		    System.out.println("Updating ID: " + id1);

		    Response response = given().log().all().contentType(ContentType.JSON)
		        .body("{ \"name\": \"Mamatha Updated\" }")
		        .when()
		        .put("/items/" + id1)
		        .then()
		        .statusCode(200)
		        .extract().response();

		   
	}
	
	@Test(priority=1)
	public void UpdateWithInvalidID() {
	    given()
	        .log().all()
	        .contentType(ContentType.JSON)
	        .body("{ \"name\": \"Hello\" }")
	    .when()
	        .put("/items/"+"123")
	    .then()
	        .statusCode(404);
	}
}
