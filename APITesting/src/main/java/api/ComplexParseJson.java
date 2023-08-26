package api;

import files.Payload;
import io.restassured.path.json.JsonPath;

public class ComplexParseJson
{
	public static void main(String args[])
	{
		JsonPath js = new JsonPath(Payload.coursePrice());
		
		// Print number of courses in API
		int count = js.getInt("courses.size()");
		System.out.println(count);
		
		//Print total purchase amount
		int totalAmount =js.getInt("dashboard.purchaseAmount");
		System.out.println(totalAmount);
		
		//Print title of first course
	   String title=js.getString("courses[0].title");
	   System.out.println(title);
	   
	   //Print all title and price of courses
		for(int i=0; i<count;i++)
		{
			System.out.println(js.get("courses["+i+"].title").toString());
			System.out.println(js.get("courses["+i+"].price").toString());
		}
		
		//Print number of copies of Selenium Python
		
		for(int i=0; i<count;i++)
		{
			String Coursetitle =js.get("courses["+i+"].title");
			if(Coursetitle.equalsIgnoreCase("Selenium Python"))
			{
			   int NoOfCopies=  js.get("courses["+i+"].copies");
				System.out.println("Copies : " + NoOfCopies);
				break;
			}
		}
		
		
	}
}
