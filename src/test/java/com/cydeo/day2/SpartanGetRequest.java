package com.cydeo.day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class SpartanGetRequest {


    //@BeforeAll is the same thing with BeforeClass in TestNG

    @BeforeAll
            public static void init(){
        RestAssured.baseURI = "http://54.162.173.63:8000";

    }



    /*
    GIVEN Accept type is application/json
    WHEN user sent get request to "/api/spartans" end point
    THEN status code must be 200
    AND response content type must be application/json
     */
@DisplayName(" api/spartans test")
    @Test

    public void test1() {

        Response response = RestAssured.
                given().
                accept(ContentType.JSON)
                .when()
                .get( "/api/spartans");
        //print the status code
        System.out.println("response.statusCode() = " + response.statusCode());
        //print the content type
        System.out.println("response.contentType() = " + response.contentType());

        //how to test API ?
        //verify status code is 200
        Assertions.assertEquals(200, response.statusCode());

        //verify content type is application json
        Assertions.assertEquals("application/json", response.contentType());

    }

    /*
 Given accept header is application/json
        When users send a get request to /api/spartans/3
        Then status code must be 200
        And Content type must be application/json
        And json body should contain 'Fidole'
     */

@DisplayName("get api/spartans/4")
    @Test
    public void test2(){

        Response response = RestAssured.given().accept(ContentType.JSON).when().get("/api/spartans/3");


        Assertions.assertEquals(200, response.statusCode());

        Assertions.assertEquals("application/json", response.contentType());

        //response.body().asString().contains("Fidole")>> This how we check for sTring manupulations
        //RESponse. body() . asString . and so on>>>

        Assertions.assertTrue(response.body().asString().contains("Fidole"));


    }

      /*
        Given no headers provided
        When Users send GET request to /api/hello
        Then response status code should be 200
        And Content type header should be “text/plain;charset=UTF-8”
        And header should contain date
        And Content-Length should be 17
        And body should be “Hello from Sparta"
        */

    @DisplayName(" Get 'api/hello' Test ")
    @Test
    public void test3(){

        Response response = RestAssured.
                when().get("/api/hello");

        response.prettyPrint();// this for printing the body

        Assertions.assertEquals(200, response.statusCode());

        Assertions.assertEquals("text/plain;charset=UTF-8",response.contentType());

        //here i will be verifiying DATE header exist in response headers
        //we use " hasHeaderWithName " method to verify if something exist in the hearder or not
        // it works like contains method
        // going to check the headers for contains word in our case it is "DATE"


        Assertions.assertTrue(response.headers().hasHeaderWithName("Date"));

        //to get header value we use header() method which accepts header name as parameter and return value as string
        System.out.println("response.header(\"Content-Length\") = " + response.header("Content-Length"));
        System.out.println("response.header(\"Connection\") = " + response.header("Connection"));

        //verify content length is 17
        Assertions.assertEquals("17",response.header("Content-Length"));

        //verify body is "hello from sparta"
        Assertions.assertEquals("Hello from Sparta",response.body().asString());


    }



}
