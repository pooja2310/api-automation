package api;

import files.Payload;
import files.ReUsableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static java.nio.file.Files.readAllBytes;

public class StaticJsonPayload
{
	
	// content of file will convert into byte and then byte into string
	@Test
	public void dynamicJson() throws IOException {
		RestAssured.baseURI = "http://216.10.245.166";
		String Response = given().log().all().header("Content-Type", "application/json")
				.body(new String(readAllBytes(Paths.get("/Users/sandipkumbhar/Documents/GitHub/api-automation/APITesting/src/main/java/files/Body.json"))))
				.when().post("/Library/Addbook.php")
				.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js = ReUsableMethods.rawToJson(Response);
		String id = js.get("ID");
		System.out.println("Book ID : " + id);
	}
}