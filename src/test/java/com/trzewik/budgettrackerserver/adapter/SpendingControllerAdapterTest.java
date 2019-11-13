package com.trzewik.budgettrackerserver.adapter;

import com.trzewik.budgettrackerserver.domain.port.api.SpendingPort;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;

/**
 * @author Agnieszka Trzewik
 */

@SpringBootTest
class SpendingControllerAdapterTest {

    @BeforeEach
    void initialiseRestAssuredMockMvcStandalone() {
        RestAssuredMockMvc.standaloneSetup(new SpendingControllerAdapter(mock(SpendingPort.class)));
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
                .statusCode(200);
    }

    @Test
    void should_returnEmptyList_when_properSpendingsGet() {

        RestAssuredMockMvc
                .given()
                .get("/spendings")
                .then()
                .contentType(JSON)
                .statusCode(200)
                .body(is(equalTo("[]")));
    }

}
