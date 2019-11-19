package com.trzewik.budgettrackerserver.domain;

import com.trzewik.budgettrackerserver.domain.port.api.SpendingPort;
import com.trzewik.budgettrackerserver.domain.port.spi.SpendingDataPort;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Agnieszka Trzewik
 */
@Named
@RequiredArgsConstructor
class SpendingService implements SpendingPort {

    private final SpendingDataPort<Spending> spendingDataPort;

    @Override
    public void addNewSpendings(Spending spending) throws ToLowPriceException {
        if (spending.getPrice().compareTo(BigDecimal.ZERO) < 0) throw new ToLowPriceException("To low price!");
        else spendingDataPort.save(spending);
    }

    @Override
    public List<Spending> getAllSpendings() {
        List<Spending> spendings = new ArrayList<>();
        spendingDataPort
                .findAll()
                .forEach(spendings::add);
        return spendings;
    }

    @Override
    public SpendingSummary getSpendingSummary() {
        BigDecimal summary = getAllSpendings()
                .stream()
                .map(Spending::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return new SpendingSummary(summary, OffsetDateTime.now());
    }
}
