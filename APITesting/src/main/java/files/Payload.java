package files;

public class Payload
{
    public static String addPlace()
    {
         return "{\n" +
                 "    \"name\": \"morpheus\",\n" +
                 "    \"job\": \"leader\",\n" +
                 "    \"id\": \"27\",\n" +
                 "    \"createdAt\": \"2023-08-13T09:51:34.526Z\"\n" +
                 "}";
    }
    
    public static String coursePrice()
    {
        return "{\n" +
                "  \"dashboard\": {\n" +
                "    \"purchaseAmount\": 910,\n" +
                "    \"website\": \"rahulshettyacademy.com\"\n" +
                "  },\n" +
                "  \"courses\": [\n" +
                "    {\n" +
                "      \"title\": \"Selenium Python\",\n" +
                "      \"price\": 50,\n" +
                "      \"copies\": 6\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"Cypress\",\n" +
                "      \"price\": 40,\n" +
                "      \"copies\": 4\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"RPA\",\n" +
                "      \"price\": 45,\n" +
                "      \"copies\": 10\n" +
                "    }\n" +
                "  ]\n" +
                "}";
    }
}
