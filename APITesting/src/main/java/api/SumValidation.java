package api;

import files.Payload;
import io.restassured.path.json.JsonPath;
//import org.testng.annotations.Test;

public class SumValidation
{
	
	public static void main(String args[])
	{
		int TotalSum= 0;
		JsonPath js = new JsonPath(Payload.coursePrice());
		int count = js.getInt("courses.size()");
		System.out.println(count);
	
		for(int i=0; i<count;i++)
		{
			int PriceOfCopies = js.get("courses["+i+"].price");
			int CountOfCopies = js.get("courses["+i+"].copies");
			int Sum = PriceOfCopies * CountOfCopies ;
			System.out.println("Sum of copies of each course : "  + Sum);
			TotalSum= TotalSum + Sum;
			
		}
		System.out.println("Total Sum of copies of all course : "  + TotalSum);
		
		
	}
}
