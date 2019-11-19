package com.trzewik.budgettrackerserver.adapter;

import com.trzewik.budgettrackerserver.domain.port.api.SpendingPort;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;

/**
 * @author Agnieszka Trzewik
 */

@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
class SpendingControllerAdapterTest {

    @BeforeAll
    static void init() {
        RestAssuredMockMvc.standaloneSetup(new SpendingControllerAdapter(mock(SpendingPort.class)));
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
