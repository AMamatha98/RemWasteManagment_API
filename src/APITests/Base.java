package APITests;
import io.restassured.RestAssured;


import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class Base {
	 public static String id1;
	 public static String id2;

	@BeforeClass
	public static void setup()
	{
 RestAssured.baseURI ="https://crudcrud.com/api";
 
 RestAssured.basePath="/a2f5a54914724c72aa380306a0facaba";
 
	}
 
	
}
