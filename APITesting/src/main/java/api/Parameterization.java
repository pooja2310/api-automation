package api;

import files.Payload;
import files.ReUsableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.openqa.selenium.json.Json;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Parameterization
{
	/*--------------------------Post Request-------------------------------*/
	@Test(dataProvider = "DetailsOfBook")
	public  void dynamicJson(String isbn, String aisle)
	{
		RestAssured.baseURI = "http://216.10.245.166";
		String Response = given().log().all().header("Content-Type", "application/json")
				.body(Payload.addBook(isbn, aisle))
				.when().post("/Library/Addbook.php")
				.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js = ReUsableMethods.rawToJson(Response);
		String id = js.get("ID");
		System.out.println("Book ID : " + id);
		
		/*--------------------------Delete Request-------------------------------*/
		
		given().log().all().header("Content-Type", "application/json")
				.body(Payload.deleteBook(id))
				.when().delete("/Library/DeleteBook.php").then().log().all().assertThat().statusCode(200)
				.body("msg", equalTo("book is successfully deleted"));
		
	}
	
	
	@DataProvider(name = "DetailsOfBook")
	public Object[][] getData()
	{
		return new Object[][] {{"A","123"},{"B","343"},{"C","233"}};
	}
}
