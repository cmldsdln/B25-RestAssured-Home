package com.cydeo.day7;

import com.cydeo.utilities.SpartanAuthTestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class SpartanWithAuthTest extends SpartanAuthTestBase {

//RBAC

    @DisplayName("GET /api/spartans as a public user(guest) expect 401")
    @Test
    public void test1(){
        given().accept(ContentType.JSON)
                .when()
                .get("/api/spartans")
                .then().statusCode(401)
                .log().all()
                .body("error",is("Unauthorized"));
    }

    @DisplayName("GET /api/spartans as admin user expect 200")
    @Test
    public void testAdmin(){
        //how to provide admin admin as a username and password ?

        given()
                .auth().basic("admin","admin")
                .and().accept(ContentType.JSON)
                .log().all()
                .when()
                .get("/api/spartans")
                .then().statusCode(200).log().all();


    }


}
