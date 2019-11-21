package com.trzewik.budgettrackerserver.atdd;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import com.trzewik.budgettrackerserver.adapter.Spending;
import com.trzewik.budgettrackerserver.domain.SpendingSummary;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Agnieszka Trzewik
 */
@JGivenStage
class ThenSpendingSummary extends Stage<ThenSpendingSummary> {

    @ExpectedScenarioState
    private SpendingSummary spendingSummary;

    @ExpectedScenarioState
    private List<Spending> spendings;


    @As("summary spendings field is 20.4")
    ThenSpendingSummary summary_spendings_is_20_4() {
        assertThat(spendingSummary.getSummary()).isEqualByComparingTo(new BigDecimal("20.4"));
        return self();
    }

    ThenSpendingSummary summary_list_size_is_2() {
        assertThat(spendings).hasSize(2);
        return self();
    }

    ThenSpendingSummary summary_spendings_field_is_zero() {
        assertThat(spendingSummary.getSummary()).isZero();
        return self();
    }

    ThenSpendingSummary list_of_all_spendings_with_description_is_empty() {
        assertThat(spendings).isEmpty();
        return self();
    }
}
