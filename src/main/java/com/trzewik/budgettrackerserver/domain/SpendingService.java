package com.trzewik.budgettrackerserver.domain;

import com.trzewik.budgettrackerserver.domain.port.api.SpendingMapper;
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

    private final SpendingDataPort spendingDataPort;

    private final SpendingMapper spendingMapper;

    @Override
    public void addNewSpendings(SpendingDTO spending) {
        if (spending.getPrice().compareTo(BigDecimal.ZERO) < 0) throw new ToLowPriceException("To low price!");
        else spendingDataPort.save(spendingMapper.map(spending));
    }

    @Override
    public List<SpendingDTO> getAllSpendings() {
        List<SpendingDTO> spendings = new ArrayList<>();
        spendingDataPort
                .findAll()
                .forEach(spending -> spendings.add(spendingMapper.map(spending)));
        return spendings;
    }

    @Override
    public SpendingSummary getSpendingSummary() {
        BigDecimal summary = getAllSpendings()
                .stream()
                .map(SpendingDTO::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return new SpendingSummary(summary, OffsetDateTime.now());
    }
}
