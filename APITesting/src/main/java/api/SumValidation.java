package api;

import files.Payload;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;
//import org.testng.annotations.Test;

public class SumValidation
{
	@Test
	public void sumValidate()
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
			System.out.println("Total number of copies sold for the Amount : " + Sum);
			TotalSum= TotalSum + Sum;
			
		}
		System.out.println("Total Sum of copies of all course : "  + TotalSum);
		int PurchaseAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println(PurchaseAmount);
		Assert.assertEquals(TotalSum,PurchaseAmount);
		System.out.println("Total sum is matched with purchased amount");
	}
}
