package com.trzewik.budgettrackerserver.atdd;

import com.tngtech.jgiven.integration.spring.EnableJGiven;
import com.tngtech.jgiven.integration.spring.SpringScenarioTest;
import com.tngtech.jgiven.junit5.JGivenExtension;
import com.trzewik.budgettrackerserver.domain.SpendingDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.math.BigDecimal;

/**
 * @author Agnieszka Trzewik
 */

@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
@EnableJGiven
@ExtendWith(JGivenExtension.class)
class AcceptanceTest extends SpringScenarioTest<GivenSpendingSummary, WhenSpendingSummary, ThenSpendingSummary> {


    @Test
    void spendings_summary() {

        section("Summary with no spendings");

        when().get_spendings_summary()
                .and()
                .get_all_spendings();

        then().summary_spendings_field_is_zero()
                .and()
                .list_of_all_spendings_with_description_is_empty();

        section("Summary with two spendings");

        when().post_spendings(new SpendingDTO("banany", new BigDecimal("10.2")), new SpendingDTO("czereśnie", new BigDecimal("10.2")))
                .and().get_spendings_summary()
                .and()
                .get_all_spendings();

        then().summary_spendings_is_20_4()
                .and()
                .summary_list_size_is_2();
    }

}