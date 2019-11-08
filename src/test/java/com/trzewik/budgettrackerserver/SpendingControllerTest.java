package com.trzewik.budgettrackerserver;

import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.context.WebApplicationContext;

import static io.restassured.http.ContentType.JSON;

/**
 * @author Agnieszka Trzewik
 */

@SpringBootTest
class SpendingControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    void initialiseRestAssuredMockMvcStandalone() {
        RestAssuredMockMvc.webAppContextSetup(webApplicationContext);

    }

    @Test
    void should_returnStatusCode200_when_properSpendingsPost() {

        RestAssuredMockMvc
                .given()
                .contentType(JSON)
                .body("{" +
                        "\"description\": \"nana\",\n" +
                        "\"price\": \"10.2\"" +
                        "}")
                .when()
                .post("/spendings")
                .then()
                .contentType(ContentType.TEXT)
                .statusCode(200);

    }

}
