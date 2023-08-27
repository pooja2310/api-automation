package api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddRequest;
import pojo.Location;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Serialization
{
	
	/*---------------------------Serialization - convert POJO class to Json-------------------- */
	
	public static void main(String args[])
	{
		RestAssured.baseURI= "https://rahulshettyacademy.com";
		AddRequest addReq=  new AddRequest();   //object of class in which getter and setter present
		addReq.setAccuracy(50);
		addReq.setAddress("29, side layout, cohen 09");
		addReq.setLanguage("French-IN");
		addReq.setPhone_number("(+91) 983 893 3937");
		addReq.setWebsite("https://rahulshettyacademy.com");
		addReq.setName("Frontline house");
		
		List<String> list = new ArrayList<>();   // types variable is of type list so arraylist object is created
		list.add("shoe park");
		list.add("shop");
		addReq.setTypes(list);
		
		Location l= new Location();   //Location is having nested json so location class is created and object is also created
		l.setLatitude(-38.383494);
		l.setLongitude(33.427362);
		addReq.setLocation(l);
		
		
		// generic fields are mapped in request builder
		RequestSpecification reqSpec= new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addQueryParam("key","qaclick123").setContentType(ContentType.JSON).build();
		
		//generic fields are mapped in response builder
		ResponseSpecification resSpec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		RequestSpecification req= given().log().all().spec(reqSpec).body(addReq);
		
		
		Response response =req.when().post("/maps/api/place/add/json").
				then().log().all().spec(resSpec).extract().response();
		
		String responseString=response.asString();
		System.out.println(responseString);
		
		
	}
}
