package com.cydeo.day3;

import com.cydeo.utilities.HrTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HrApiTestsWithParams extends HrTestBase {

    @Test
    public void test1(){
        Response response = get("/regions");

        response.prettyPrint();

    }

       /*
        Given accept type is Json
        And parameters: q = {"region_id":2}
        When users sends a GET request to "/countries"
        Then status code is 200
        And Content type is application/json
        And Payload should contain "United States of America"
     */

    @DisplayName("GET request to /countries with query param")
    @Test
    public void test2(){
        Response response = given()
                .accept(ContentType.JSON)
                .and()
                .queryParam("q","{\"region_id\":2}")
                .log().all() //optional
                .when()
                .get("/countries");

        //verify status code
        assertEquals(200,response.statusCode());
        //verify content type
        assertEquals("application/json",response.contentType());
        // verify United States of America exists
        assertTrue(response.body().asString().contains("United States of America"));



    }
       /*
        HW
             Send a GET request to employees and get only employees who works as a IT_PROG
         */

}
