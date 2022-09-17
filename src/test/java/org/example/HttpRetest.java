package org.example;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

public class HttpRetest {

    @Test
    public void actual_test()
    {
        RestAssured.baseURI="http://api.plos.org/search";
//
//        String response =given().log().all().queryParam("q","title:DNA")
//                .when().get().then().log().all().statusCode(200).body("numFound",equalTo("5626")).toString();
//
//        System.out.println("response "+response);


       String outputResponse= given().log().all().queryParam("q","title:DNA").when().get().then().log().all()
                .statusCode(200).extract().response().toString();

        System.out.println(outputResponse);

        JsonPath js= new JsonPath(outputResponse);

       String num=js.getString("response");
        System.out.println(num);
    }
}
