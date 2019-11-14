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
    public Spending getSpending(Long id) throws NoSpendingExistsException {
        return spendingDataPort
                .findById(id)
                .orElseThrow(() -> new NoSpendingExistsException("Spending doesn't exist"));
    }

    @Override
    public SpendingSummary getSpendingSummary() throws NoSpendingExistsException {
        BigDecimal summary = getAllSpendings()
                .stream()
                .map(Spending::getPrice)
                .reduce(BigDecimal::add)
                .orElseThrow(() -> new NoSpendingExistsException("There are no spendings!"));
        return new SpendingSummary(summary, OffsetDateTime.now());
    }
}
