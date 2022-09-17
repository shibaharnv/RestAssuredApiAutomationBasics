package org.example;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

public class JsonPathComplextJson {


    @Test
    public void jsonParsingTest()
    {

        JsonPath js = new JsonPath(SampleJson.samplePayload());

       int count= js.getInt("courses.size()");

        System.out.println("course count "+count);

        String purchaseAumount =js.getString("dashboard.purchaseAmount");
        System.out.println(purchaseAumount);

        String courseTitle=js.getString("courses[0].title");

        System.out.println(courseTitle);

        // print all course title
        for(int i=0;i<count;i++)
        {

            String value=js.get("courses["+i+"].title");
            if(value.equalsIgnoreCase("RPA"))
            {
                int copies= js.get("courses["+i+"].copies");

                System.out.println(copies);
            }
            System.out.println(value);
        }

        //Get the number of copies sold by RPA


        int finalAmount=0;
        for(int i=0;i<count;i++)
        {

            int price=js.get("courses["+i+"].price");
            finalAmount=finalAmount+price;
            System.out.println(price);
        }
        System.out.println(finalAmount);

        int purchaseAumountInt =js.getInt("dashboard.purchaseAmount");

        System.out.println("purchaseAumountInt "+purchaseAumountInt);

        if(finalAmount==purchaseAumountInt)
        {
            System.out.println("Matching");
        }

        else {
            System.out.println("NOTMatching");
        }
    }
}
