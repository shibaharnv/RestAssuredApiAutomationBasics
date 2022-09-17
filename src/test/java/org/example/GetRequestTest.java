package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONArray;



import java.io.IOException;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GetRequestTest {

    public static void main(String[] args) {


        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        Response response = given().log().all().when().get("/todos").then().log().all()
                .extract().response();

        System.out.println(response);

        // Json Array capture till root as list

        List<String> jresponse = response.jsonPath().getList("$");

        System.out.println(jresponse);

        List<Boolean> completedlist =response.jsonPath().getList("completed");

        System.out.println("completedlist "+Arrays.asList(completedlist));

        Boolean result=false;

        for(int i=0;i<completedlist.size();i++)
        {

            result=completedlist.get(i);

            if(result)
            {
                String finalValue=response.jsonPath().getList("$").get(i).toString();

                System.out.println(finalValue);
            }

        }






    }
}
