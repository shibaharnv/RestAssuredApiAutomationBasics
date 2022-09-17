package org.example;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class SerializationJavaObjecToJson {

    public static void main(String[] args) throws IOException {

        //Deserialization is the process of converting json to java object

        //Serialization is the process of converting java object to Json
        String filePath ="/Users/snagarajan/Documents/pemyremote/RestAssuredTesting/src/test/java/org/example/place.json";
        File fileObj = new File(filePath);

        ObjectMapper mapper = new ObjectMapper();

        PlacePojoClass clasObj= mapper.readValue(fileObj, PlacePojoClass.class);

        System.out.println(clasObj.getAddress());
        System.out.println(clasObj.getPlace_id());
        System.out.println(clasObj.getKey());

        clasObj.setAddress("xyz");

        mapper.writeValue(new File(filePath),clasObj);




    }

}
