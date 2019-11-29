package com.trzewik.budgettrackerserver.domain;

import com.trzewik.budgettrackerserver.domain.port.api.SpendingMapper;
import com.trzewik.budgettrackerserver.domain.port.spi.SpendingDataPort;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

class SpendingServiceTest {

    @Test
    void should_throw_to_low_price_exception_when_price_less_then_zero() {
        //Given
        SpendingService spendingService = new SpendingService(mock(SpendingDataPort.class), mock(SpendingMapper.class));
        //When
        //Then
        assertThatThrownBy(() ->
                spendingService
                        .addNewSpending(new SpendingDTO("nanana", new BigDecimal("-0.1"))))
                .isExactlyInstanceOf(ToLowPriceException.class)
                .hasMessage("To low price!");

    }

    @Test
    void should_invoke_get_all_spending_summary_once_when_get_spendings_summary_called() {
        //Given
        SpendingService spendingService = mock(SpendingService.class);
        //When
        when(spendingService.getAllSpendings()).thenReturn(Lists.emptyList());
        when(spendingService.getSpendingSummary()).thenCallRealMethod();
        spendingService.getSpendingSummary();
        //Then
        verify(spendingService, times(1)).getAllSpendings();
    }

}