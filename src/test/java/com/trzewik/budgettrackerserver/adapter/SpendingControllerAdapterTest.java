package com.trzewik.budgettrackerserver.adapter;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.context.WebApplicationContext;

import javax.inject.Inject;
import javax.transaction.Transactional;

import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

/**
 * @author Agnieszka Trzewik
 */

@SpringBootTest
@Transactional
class SpendingControllerAdapterTest {

    @Inject
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    void init() {
        RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
    }

    @Test
    void should_return_status_code_200_when_post_proper_spendings() {

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
                .statusCode(200);
    }

    @Test
    void should_return_status_code_400_when_post_too_low_price() {

        RestAssuredMockMvc
                .given()
                .contentType(JSON)
                .body("{" +
                        "\"description\": \"nana\",\n" +
                        "\"price\": \"-10.2\"" +
                        "}")
                .when()
                .post("/spendings")
                .then()
                .statusCode(400);
    }

    @Test
    void should_return_empty_list_when_get_spendings() {

        RestAssuredMockMvc
                .given()
                .get("/spendings")
                .then()
                .contentType(JSON)
                .statusCode(200)
                .body(is(equalTo("[]")));
    }

    @Test
    void should_return_status_code_200_when_proper_get_summary_spendings() {

        RestAssuredMockMvc
                .given()
                .when()
                .get("/summary")
                .then()
                .statusCode(200);
    }

}
