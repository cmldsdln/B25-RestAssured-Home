package com.cydeo.day1;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimpleGetRequest {

    String url = "http://54.162.173.63:8000/api/spartans";


    @Test

    public void test(){

        // send a get request and response inside the Response object
        Response response = RestAssured.get(url);

        //print the status code
        System.out.println("response.statusCode() = " + response.statusCode());

        //print response body
        response.prettyPrint();

        Assertions.assertEquals(200,response.statusCode());

    }






}
