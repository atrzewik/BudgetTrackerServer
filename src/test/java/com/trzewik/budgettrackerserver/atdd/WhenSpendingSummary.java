package com.trzewik.budgettrackerserver.atdd;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import com.trzewik.budgettrackerserver.adapter.SpendingControllerAdapter;
import com.trzewik.budgettrackerserver.domain.Spending;
import com.trzewik.budgettrackerserver.domain.SpendingSummary;
import com.trzewik.budgettrackerserver.domain.port.api.SpendingPort;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static io.restassured.http.ContentType.JSON;

/**
 * @author Agnieszka Trzewik
 */
@JGivenStage
class WhenSpendingSummary extends Stage<WhenSpendingSummary> {

    @ProvidedScenarioState
    private SpendingSummary spendingSummary;

    @ProvidedScenarioState
    private List<Spending> spendings;

    @Autowired
    private SpendingPort spendingPort;

    @BeforeStage
    private void init() {
        RestAssuredMockMvc.standaloneSetup(new SpendingControllerAdapter(spendingPort));
    }

    @As( "I get spendings summary" )
    WhenSpendingSummary get_spendings_summary() {
        spendingSummary = spendingPort.getSpendingSummary();
        return self();
    }

    WhenSpendingSummary get_all_spendings() {
        spendings = spendingPort.getAllSpendings();
        return self();
    }

    @As( "I add bananas" )
    WhenSpendingSummary post_bananas() {
        RestAssuredMockMvc
                .given()
                .contentType(JSON)
                .body("{" +
                        "\"description\": \"banany\",\n" +
                        "\"price\": \"10.2\"" +
                        "}")
                .post("/spendings");
        return self();
    }

    @As( "and add cherries" )
    WhenSpendingSummary post_cherries() {
        RestAssuredMockMvc
                .given()
                .contentType(JSON)
                .body("{" +
                        "\"description\": \"czereśnie\",\n" +
                        "\"price\": \"10.2\"" +
                        "}")
                .post("/spendings");
        return self();
    }
}
