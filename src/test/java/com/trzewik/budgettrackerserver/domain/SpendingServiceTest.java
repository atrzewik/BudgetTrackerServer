package com.trzewik.budgettrackerserver.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Agnieszka Trzewik
 */
@SpringBootTest
class SpendingServiceTest {

    @Inject
    private SpendingService spendingService;

    @Test
    void should_throw_to_low_price_exception_when_price_less_then_zero() {
        //Given
        //When
        ToLowPriceException toLowPriceException = assertThrows(ToLowPriceException.class,
                () ->
                        spendingService
                                .addNewSpending(new SpendingDTO("nanana", new BigDecimal("-0.1")))
        );
        //Then
        assertTrue(toLowPriceException.getMessage().contains("To low price!"));

    }

    @Test
    @Sql(scripts = {"/clean-up-data.sql"})
    void should_return_zero_when_spendings_are_empty() {
        //Given
        //When
        BigDecimal summary = spendingService.getSpendingSummary().getSummary();
        //Then
        assertThat(summary).isEqualByComparingTo(BigDecimal.ZERO);
    }

    @Test
    @Sql(scripts = {"/clean-up-data.sql"})
    void should_return_empty_list_when_no_spendings() {
        //Given
        //When
        List<SpendingDTO> allSpendings = spendingService.getAllSpendings();
        //Then
        assertThat(allSpendings).isEmpty();
    }

    @Test
    @Sql(scripts = {"/clean-up-data.sql"})
    void should_return_list_size_two_when_two_spendings_in_DB() {
        //Given
        prepare_base_with_two_elements();
        //When
        List<SpendingDTO> allSpendings = spendingService.getAllSpendings();
        //Then
        assertThat(allSpendings).hasSize(2);
    }


    @Test
    @Sql(scripts = {"/clean-up-data.sql"})
    void should_return_list_size_one_when_add_one_spending() {
        //Given
        spendingService.addNewSpending(new SpendingDTO("nana", new BigDecimal("1")));
        //When
        List<SpendingDTO> allSpendings = spendingService.getAllSpendings();
        //Then
        assertThat(allSpendings).hasSize(1);
    }

    private void prepare_base_with_two_elements() {
        spendingService.addNewSpending(new SpendingDTO("nana", new BigDecimal("1")));
        spendingService.addNewSpending(new SpendingDTO("nana", new BigDecimal("1")));
    }

}