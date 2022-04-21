package com.cydeo.day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SpartanNegativeGetRequest {

     /*TASK
    Given Accept type application/xml
    When user send GET request to /api/spartans/10 end point
    Then status code must be 406
    And response Content Type must be application/xml;charset=UTF-8;
    */


    @BeforeAll
    public static void init(){

        RestAssured.baseURI= "http://54.162.173.63:8000";

    }



    @Test
    public void test() {

        Response response = RestAssured.given().
                accept(ContentType.XML).
                when().get("/api/spartans/10");


        Assertions.assertEquals(406, response.statusCode());

        Assertions.assertEquals("application/xml;charset=UTF-8", response.contentType());

    }


}
