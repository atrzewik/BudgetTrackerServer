package com.trzewik.budgettrackerserver.domain.port.api;

import com.trzewik.budgettrackerserver.domain.SpendingDTO;
import com.trzewik.budgettrackerserver.domain.ToLowPriceException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.TestPropertySource;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Agnieszka Trzewik
 */
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
@Transactional
class SpendingPortTest {

    @Inject
    private SpendingPort spendingPort;

    @Test
    void should_throw_to_low_price_exception_when_price_less_then_zero() {
        //Given
        //When
        ToLowPriceException toLowPriceException = assertThrows(ToLowPriceException.class,
                () ->
                        spendingPort
                                .addNewSpending(new SpendingDTO("nanana", new BigDecimal("-0.1")))
        );
        //Then
        assertTrue(toLowPriceException.getMessage().contains("To low price!"));

    }

    @Test
    void should_return_zero_when_spendings_are_empty() {
        //Given
        //When
        BigDecimal summary = spendingPort.getSpendingSummary().getSummary();
        //Then
        assertThat(summary).isEqualByComparingTo(BigDecimal.ZERO);
    }

    @Test
    void should_return_empty_list_when_no_spendings() {
        //Given
        //When
        List<SpendingDTO> allSpendings = spendingPort.getAllSpendings();
        //Then
        assertThat(allSpendings).isEmpty();
    }

    @Test
    void should_return_list_size_one_when_one_spendings() {
        //Given
        spendingPort.addNewSpending(new SpendingDTO("nana", new BigDecimal("1")));
        //When
        List<SpendingDTO> allSpendings = spendingPort.getAllSpendings();
        //Then
        assertThat(allSpendings).hasSize(1);
    }


    @Test
    void should_return_list_size_one_when_one_spendings2() {
        //Given
        spendingPort.addNewSpending(new SpendingDTO("nana", new BigDecimal("1")));
        //When
        List<SpendingDTO> allSpendings = spendingPort.getAllSpendings();
        //Then
        assertThat(allSpendings).hasSize(1);
    }

}