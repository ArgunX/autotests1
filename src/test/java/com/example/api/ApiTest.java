package com.example.api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class ApiTest {

    @Test
    void getUser_shouldReturnUserData() {
        RestAssured.baseURI = "https://reqres.in";

        given()
                .when()
                .get("/api/users/2")
                .then()
                .statusCode(200)
                .body("data.id", equalTo(2))
                .body("data.email", containsString("@reqres.in"));
    }
}

