package com.trzewik.budgettrackerserver.atdd;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.annotation.Table;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import com.trzewik.budgettrackerserver.adapter.SpendingControllerAdapter;
import com.trzewik.budgettrackerserver.domain.SpendingDTO;
import com.trzewik.budgettrackerserver.domain.SpendingSummary;
import com.trzewik.budgettrackerserver.domain.port.api.SpendingPort;
import io.restassured.module.mockmvc.RestAssuredMockMvc;

import javax.inject.Inject;
import java.util.List;

/**
 * @author Agnieszka Trzewik
 */
@JGivenStage
class WhenSpendingSummary extends Stage<WhenSpendingSummary> {

    @ProvidedScenarioState
    private SpendingSummary spendingSummary;

    @ProvidedScenarioState
    private List<SpendingDTO> spendings;

    @Inject
    private SpendingPort spendingPort;

    @BeforeStage
    private void init() {
        RestAssuredMockMvc.standaloneSetup(new SpendingControllerAdapter(spendingPort));
    }

    @As("I get spendings summary")
    WhenSpendingSummary get_spendings_summary() {
        spendingSummary = spendingPort.getSpendingSummary();
        return self();
    }

    WhenSpendingSummary get_all_spendings() {
        spendings = spendingPort.getAllSpendings();
        return self();
    }

    @As("add spendings")
    WhenSpendingSummary post_spendings(@Table SpendingDTO... spendings) {
        for (SpendingDTO spending : spendings) {
            spendingPort.addNewSpending(spending);
        }
        return self();
    }
}
