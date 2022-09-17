package org.example;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;





public class HttpMethodsTest {



    @Test
    public void get_Test()
    {
        Response response=get("http://api.plos.org/search?q=title:DNA");

        System.out.println(response.getBody().toString());
        int status_code=response.getStatusCode();
        Assert.assertEquals(status_code,200);
        System.out.println(status_code);
        System.out.println(response.getStatusLine().toString());
    }

    @Test

    public void testing()
    {
//        given().get("https://reqres.in/api/users?page=2").then().statusCode(200)
//                .body("");
    }
}
