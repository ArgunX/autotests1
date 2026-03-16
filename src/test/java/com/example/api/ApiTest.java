package com.example.api;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class ApiTest {

  

    @Test
    void getGit() {
        Response response = given()
                .when()
                .get("https://github.com/");

    
        assumeTrue(response.statusCode() == 200,
                "ReqRes API сейчас недоступен или вернул код " + response.statusCode());

    }
}