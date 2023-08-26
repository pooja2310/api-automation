package api;
import files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Basics
{
    public static void main(String[] args)
    {
        
        /*-----------------------------------Post Request-----------------------------------------------*/
        
        RestAssured.baseURI= "https://reqres.in";
       String response =  given().log().all().queryParam("key","pass123").header("Content-Type", "application/json")
                .body(Payload.addPlace()).when().post("api/users").
                then().log().all().assertThat().statusCode(201).body("id",equalTo("27"))
                .header("Server","cloudflare").extract().response().asString();
       System.out.println("Response : " + response);

       JsonPath js= new JsonPath(response);   // jsonpath takes string and convert it to json .also help to parse json.
       String Job= js.getString("job");
        System.out.println("Job Name : " + Job);
        
        
        /*-----------------------------------Put Request--------------------------------------------------*/
        
        given().log().all().queryParam("key","pass123").header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"zion resident\",\n" +
                        "    \"updatedAt\": \"2023-08-13T11:18:19.314Z\"\n" +
                        "}").when().put("api/users/2")
                .then().log().all().assertThat().statusCode(200);
    
    
        /*-----------------------------------Get Request--------------------------------------------------*/
        
        given().log().all().queryParam("key","pass123").when().get("https://reqres.in/api/users/2")
                .then().log().all().assertThat().statusCode(200);
        

    }

}