package APITests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CRUDE_DELETE extends Base {
	
	@Test(priority=1)
	public void GetItem() throws IOException
	{
		id1 = new String(Files.readAllBytes(Paths.get("item_id.txt")));
	Response response=given().log().all().contentType(ContentType.JSON)
		
		.when()
		    .delete("/items/" + id1)
		.then()
		    .statusCode(200).extract().response();
	
	System.out.println("Response Body:\n" + response.asString());
	
	given().log().all().contentType(ContentType.JSON)
	.when().get("/items/" + id1)
	.then().log().all().statusCode(404);

	}
	
	@Test(priority=2)
	public void DeleteWithInvalidID() {
	    given()
	        .log().all()
	        .contentType(ContentType.JSON)
	    .when()
	        .delete("/items/"+"111")
	    .then()
	        .statusCode(404);
	}
}
